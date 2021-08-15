package net.in.lapshop.lapshop.order;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import net.in.lapshop.lapshop.R;
import net.in.lapshop.lapshop.link;
import net.in.lapshop.lapshop.login.SharedPreferenceConfig;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class order_now extends AppCompatActivity {

    TextView name,address,addresstype,mobileno,price1;
    String address_url,details_url;
    Button changeaddress;
    List<showOrder> orderList;
    private orderAdapter adapter;
    private RecyclerView recyclerView;
    private Button changeAddress,continues;
    private String maid,sid,prices;
    static int a;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_now);

        details_url= link.url+"/Lapshop/order/show_laptop_details.php?id="+ getIntent().getStringExtra("sid");
        getData();
        a=getIntent().getIntExtra("maid",0);
        if(a==0){
            address_url=link.url+"/Lapshop/order/show_address_details.php?cemail="+ SharedPreferenceConfig.getemail2();
        }
        else{
            address_url=link.url+"/Lapshop/order/show_address_detailsa.php?maid="+ getIntent().getIntExtra("maid",0);

        }
        getAddressDataToShow();
        orderList=new ArrayList<>();
        LinearLayoutManager llm=new LinearLayoutManager(order_now.this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(llm);
        getLaptopDetails();
        changeaddress=findViewById(R.id.changeaddress);
        changeaddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(order_now.this,select_address.class);
                i.putExtra("sid",getIntent().getStringExtra("sid"));
                startActivity(i);
            }
        });
        maid=getIntent().getStringExtra("maid");
        sid=getIntent().getStringExtra("sid");
        continues.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(order_now.this,payments_method.class);
                i.putExtra("sid",sid);
                i.putExtra("price",prices);
                i.putExtra("maid",maid);
                startActivity(i);
            }
        });

    }

    private void getLaptopDetails() {
        StringRequest stringRequest=new StringRequest(Request.Method.POST, details_url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray array=new JSONArray(response);
                    for (int i=0;i<array.length();i++) {
                        JSONObject laptop=array.getJSONObject(i);
                        String s;
                        price1.setText(laptop.getString("laptop_price"));
                        prices=laptop.getString("laptop_price");
                        s=laptop.getString("screen_size")+" "+laptop.getString("laptop_color");
                        orderList.add(new showOrder(
                                laptop.getString("laptop_title"),
                                s,
                                laptop.getString("laptop_price"),
                                laptop.getString("laptop_price"),
                                laptop.getString("image_1")
                        ));
                        adapter=new orderAdapter(orderList,order_now.this);
                        recyclerView.setAdapter(adapter);

                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        Volley.newRequestQueue(this).add(stringRequest);
    }

    private void getAddressDataToShow() {
        StringRequest stringRequest=new StringRequest(Request.Method.POST, address_url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray array=new JSONArray(response);
                    for (int i=0;i<array.length();i++) {
                        JSONObject addres=array.getJSONObject(i);
                                String s;
                                maid=addres.getString("maid");
                                s=addres.getString("customer_flatno")+","+addres.getString("customer_locality")+","+addres.getString("customer_city")+","+addres.getString("customer_state")+"-"+ addres.getString("customer_pincode");
                                address.setText(s);
                                name.setText(addres.getString("customer_name"));
                                mobileno.setText(addres.getString("customer_mobileno"));
                                addresstype.setText(addres.getString("customer_addresstype"));
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        Volley.newRequestQueue(this).add(stringRequest);
    }

    private void getData() {
        name=findViewById(R.id.name);
        address=findViewById(R.id.address);
        addresstype=findViewById(R.id.addresstype);
        mobileno=findViewById(R.id.mobileno);
        changeaddress=findViewById(R.id.changeaddress);
        recyclerView=findViewById(R.id.recyclerView);
        continues=findViewById(R.id.continues);
        price1=findViewById(R.id.price1);
    }
}
