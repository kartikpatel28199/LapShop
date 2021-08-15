package net.in.lapshop.lapshop.address;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import net.in.lapshop.lapshop.R;
import net.in.lapshop.lapshop.link;
import net.in.lapshop.lapshop.login.SharedPreferenceConfig;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ManageAddress extends AppCompatActivity {

    CardView addaddress;
    RecyclerView recyclerView;
    private List<ShowManageAddress> addressList;
    private  String url= link.url+"/Lapshop/ManageAddress/show_address.php?cemail="+ SharedPreferenceConfig.getemail2();
    private ManageAddressAdapter manageAddressAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        setContentView(R.layout.activity_manage_address);
        addaddress=findViewById(R.id.cardview_manage_address);
        recyclerView=findViewById(R.id.recyclerView_mageaddress);
        addaddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ManageAddress.this,addNewAddress.class));
            }
        });
        LinearLayoutManager llm=new LinearLayoutManager(ManageAddress.this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(llm);
        addressList=new ArrayList<>();
        loadAddress();
    }

    private void loadAddress() {
        StringRequest stringRequest=new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray array=new JSONArray(response);
                    for (int i=0;i<array.length();i++) {
                        JSONObject address=array.getJSONObject(i);
                        addressList.add(new ShowManageAddress(
                                address.getInt("maid"),
                                address.getString("customer_city"),
                                address.getString("customer_locality"),
                                address.getString("customer_flatno"),
                                address.getString("customer_pincode"),
                                address.getString("customer_state"),
                                address.getString("customer_landmark"),
                                address.getString("customer_name"),
                                address.getString("customer_mobileno"),
                                address.getString("customer_alternativemobileno"),
                                address.getString("customer_addresstype")
                        ));
                        manageAddressAdapter=new ManageAddressAdapter(ManageAddress.this,addressList);
                        recyclerView.setAdapter(manageAddressAdapter);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
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

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();
        if(id==android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}

