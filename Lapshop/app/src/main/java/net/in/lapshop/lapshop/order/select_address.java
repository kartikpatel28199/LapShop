package net.in.lapshop.lapshop.order;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import net.in.lapshop.lapshop.R;
import net.in.lapshop.lapshop.address.ShowManageAddress;
import net.in.lapshop.lapshop.link;
import net.in.lapshop.lapshop.login.SharedPreferenceConfig;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class select_address extends AppCompatActivity {
    RecyclerView recyclerView;
    private List<ShowManageAddress> addressList;
    private  String url= link.url+"/Lapshop/ManageAddress/show_address.php?cemail="+ SharedPreferenceConfig.getemail2();
    private showAddressAdapter addressAdapter;
    private String sid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_address);
       sid=getIntent().getStringExtra("sid");
        recyclerView=findViewById(R.id.recyclerView_selectaddress);
        LinearLayoutManager llm=new LinearLayoutManager(select_address.this);
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
                        addressAdapter=new showAddressAdapter(addressList,select_address.this,sid);
                        recyclerView.setAdapter(addressAdapter);
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

}
