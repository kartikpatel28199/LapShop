package net.in.lapshop.seller.managelaptop;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import net.in.lapshop.seller.Login.SharedPreferenceConfig;
import net.in.lapshop.seller.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class manage_laptop extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<ManageLaptop> laptopList;
    private manageLaptopAdapter adapter;
    String URL_PRODUCTS="http://lapshop.in.net/seller/retrive_data_for_searchpage.php?email="+ SharedPreferenceConfig.getemail2();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_laptop);
        recyclerView=findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager layoutManager=new GridLayoutManager(manage_laptop.this, 2, GridLayoutManager.VERTICAL, false);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        laptopList=new ArrayList<>();
        loadLaptop();
    }

    private void loadLaptop() {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_PRODUCTS,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray array = new JSONArray(response);
                            for (int i = 0; i < array.length(); i++) {
                                JSONObject laptop = array.getJSONObject(i);
                                laptopList.add(new ManageLaptop(
                                        laptop.getInt("sid"),
                                        laptop.getString("laptop_title"),
                                        laptop.getString("laptop_price"),
                                        laptop.getString("image_1")
                                ));
                            }
                            adapter = new manageLaptopAdapter( laptopList,manage_laptop.this);
                            recyclerView.setAdapter(adapter);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(manage_laptop.this,"Error is "+error,Toast.LENGTH_LONG).show();
                    }
                });
        Volley.newRequestQueue(this).add(stringRequest);    }
}
