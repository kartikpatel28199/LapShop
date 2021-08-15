package net.in.lapshop.lapshop.mycart;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

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

public class My_Cart extends AppCompatActivity {
    private String URL_PRODUCTS = link.url+"/Lapshop/Mycart/laptop_show_mycart_data.php?email="+ SharedPreferenceConfig.getemail2();
    private List<MyCart> myCartList;
    private RecyclerView recyclerView;
    private myCartAdapter adapter;
    private int sumOfAllCartItem=0;
    private TextView totalprice;
    int price=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_cart);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        totalprice=findViewById(R.id.mycart_totalprice);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(llm);
        myCartList = new ArrayList<>();
        showMycartdata();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.
                getItemId();
        if(id==android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    private void showMycartdata() {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_PRODUCTS,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray array = new JSONArray(response);
                            for (int i = 0; i < array.length(); i++) {
                                JSONObject laptop = array.getJSONObject(i);
                                price=price+laptop.getInt("laptop_price");

                                myCartList.add(new MyCart(
                                        laptop.getString("id"),
                                        laptop.getString("sid"),
                                        laptop.getString("email"),
                                        laptop.getString("laptop_title"),
                                        laptop.getString("laptop_brand"),
                                        laptop.getString("screen_size"),
                                        laptop.getString("laptop_price"),
                                        laptop.getString("image_1")
                                ));

                            }
                            totalprice.setText(price+"");
                            adapter = new myCartAdapter(My_Cart.this, myCartList);
                            recyclerView.setAdapter(adapter);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(My_Cart.this, "Error is " + error, Toast.LENGTH_LONG).show();
                    }
                });
        Volley.newRequestQueue(this).add(stringRequest);
    }
}
