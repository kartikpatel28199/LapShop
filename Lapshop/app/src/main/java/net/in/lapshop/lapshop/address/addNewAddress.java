package net.in.lapshop.lapshop.address;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
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

import java.util.HashMap;
import java.util.Map;

public class addNewAddress extends AppCompatActivity {

    TextInputEditText city,locality,flatno,pincode,state,landmark,name,mobileno,alternativemobileno;
    private RadioButton home,work;
    Button save;
    String str = "";
    private String url,showurl;
    int a=0;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_address);
        city=findViewById(R.id.customer_city);
        locality=findViewById(R.id.customer_locality);
        flatno=findViewById(R.id.customer_flatno);
        pincode=findViewById(R.id.customer_pincode);
        state=findViewById(R.id.customer_state);
        landmark=findViewById(R.id.customer_lendmark);
        name=findViewById(R.id.customer_name);
        mobileno=findViewById(R.id.customer_mobileno);
        alternativemobileno=findViewById(R.id.customer_alternativemobileno);
        home=findViewById(R.id.customer_home);
        work=findViewById(R.id.customer_work);
        save=findViewById(R.id.customer_save);
        save.setVisibility(View.VISIBLE);
        a=getIntent().getIntExtra("maid",0);
        if(a==0){
            url= link.url+"/Lapshop/ManageAddress/insert_new_address.php";
        }else {
            url=link.url+"/Lapshop/ManageAddress/update_new_address.php?maid="+getIntent().getIntExtra("maid",0);
            showurl=link.url+"/Lapshop/ManageAddress/show_addresses.php?maid="+getIntent().getIntExtra("maid",0);
            showAddress();
        }
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (home.isChecked()){
                    work.setChecked(false);
                    str="home";
                }else if (work.isChecked()){
                    home.setChecked(false);
                    str="work";
                }
                RequestQueue queue= Volley.newRequestQueue(addNewAddress.this);
                StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.e("nnn", response);
                        if (response.equals("1")){
                            startActivity(new Intent(addNewAddress.this, ManageAddress.class));
                            Toast.makeText(addNewAddress.this, "Address Add Successfully", Toast.LENGTH_LONG).show();
                        }else{
                            Toast.makeText(addNewAddress.this, "Insert Valid Address", Toast.LENGTH_LONG).show();
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(addNewAddress.this, "Fail To Add Address" + error, Toast.LENGTH_SHORT).show();
                    }
                }) {
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String, String> par = new HashMap<>();
                        par.put("cemail", SharedPreferenceConfig.getemail2() );
                        par.put("customer_city",city.getText().toString().trim());
                        par.put("customer_locality", locality.getText().toString().trim());
                        par.put("customer_flatno", flatno.getText().toString().trim());
                        par.put("customer_pincode", pincode.getText().toString().trim());
                        par.put("customer_state",state.getText().toString().trim());
                        par.put("customer_landmark",landmark.getText().toString().trim());
                        par.put("customer_name",name.getText().toString().trim());
                        par.put("customer_mobileno",mobileno.getText().toString().trim());
                        par.put("customer_alternativemobileno",alternativemobileno.getText().toString().trim());
                        par.put("customer_addresstype",str);
                        return par;
                    }
                };
                queue.add(stringRequest);
            }
        });
    }

    private void showAddress() {
        RequestQueue queue= Volley.newRequestQueue(addNewAddress.this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, showurl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e("nnn", response);
                try {
                    JSONArray array=new JSONArray(response);
                    for (int i=0;i<array.length();i++) {
                        JSONObject address=array.getJSONObject(i);
                        city.setText(address.getString("customer_city"));
                        locality.setText(address.getString("customer_locality"));
                                flatno.setText(address.getString("customer_flatno"));
                                pincode.setText(address.getString("customer_pincode"));
                                state.setText(address.getString("customer_state"));
                                landmark.setText(address.getString("customer_landmark"));
                                name.setText(address.getString("customer_name"));
                                mobileno.setText(address.getString("customer_mobileno"));
                                alternativemobileno.setText(address.getString("customer_alternativemobileno"));
                               if (address.getString("customer_addresstype").equals("home")){
                                   home.setChecked(true);
                               }else{
                                   work.setChecked(true);
                               }
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
                Toast.makeText(addNewAddress.this, "Fail To Add Address" + error, Toast.LENGTH_SHORT).show();
            }
        });
        queue.add(stringRequest);
    }

    @Override
    public void onBackPressed() {
      super.onBackPressed();
    }
}
