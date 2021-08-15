package net.in.lapshop.lapshop.vieworder;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

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

public class view_order extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<viewOrder> orderList;
    private vieworderAdapter adapter;
    String url;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_order);
       url= link.url+"/Lapshop/view_order/show_view_order.php?email="+ SharedPreferenceConfig.getemail2();
        recyclerView=findViewById(R.id.recyclerView);
        orderList=new ArrayList<>();
        LinearLayoutManager layoutManager=new LinearLayoutManager(view_order.this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        showData();
    }

    private void showData() {
        StringRequest stringRequest=new StringRequest(StringRequest.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray array=new JSONArray(response);
                    for(int i=0;i<array.length();i++){
                        JSONObject v=array.getJSONObject(i);
                        orderList.add(new viewOrder(
                           v.getInt("oid"),
                           v.getString("title"),
                           v.getString("price"),
                           v.getString("payment_method"),
                           v.getString("tracking"),
                           v.getString("image_1")
                        ));
                        adapter=new vieworderAdapter(orderList,view_order.this);
                        recyclerView.setAdapter(adapter);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        Volley.newRequestQueue(view_order.this).add(stringRequest);
    }
}
