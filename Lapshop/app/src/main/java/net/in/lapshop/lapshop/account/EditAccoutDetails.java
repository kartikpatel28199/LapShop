package net.in.lapshop.lapshop.account;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
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
import net.in.lapshop.lapshop.login.Login;
import net.in.lapshop.lapshop.login.SharedPreferenceConfig;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class EditAccoutDetails extends AppCompatActivity {

    private String URL= link.url+"/Lapshop/profile_update/update_customer_profile.php?email="+ SharedPreferenceConfig.getemail2();
    private EditText firstname,lastname,email,mobileno;
    private TextView editpassword;
    private Button submit;
    private String e1,e2,e3,e4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        setContentView(R.layout.activity_edit_accout_details);
        firstname=findViewById(R.id.firstname);
        lastname=findViewById(R.id.lastname);
        email=findViewById(R.id.email);
        mobileno=findViewById(R.id.mobileno);
        getdata();


        submit=findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RequestQueue queue = Volley.newRequestQueue(EditAccoutDetails.this);
                e1 = firstname.getText().toString();
                e2 = lastname.getText().toString();
                e3 = email.getText().toString();
                e4 = mobileno.getText().toString();
                String url = link.url+"/Lapshop/profile_update/update_customer_profile_1.php?e="+SharedPreferenceConfig.getemail2();
                StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.e("nnn", response);
                        if (response.equals("1")){
                            startActivity(new Intent(EditAccoutDetails.this, Login.class));
                            Toast.makeText(EditAccoutDetails.this, "Account Update Successfully", Toast.LENGTH_LONG).show();
                        }else{
                            Toast.makeText(EditAccoutDetails.this, "Insert Valid Details", Toast.LENGTH_LONG).show();
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(EditAccoutDetails.this, "Fail To Edit Account" + error, Toast.LENGTH_SHORT).show();
                    }
                }) {
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String, String> par = new HashMap<>();
                        par.put("firstname", e1);
                        par.put("lastname", e2);
                        par.put("email", e3);
                        par.put("mobileno", e4);
                        return par;
                    }
                };
                queue.add(stringRequest);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();
        if(id==android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
    public void getdata(){
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray array = new JSONArray(response);
                            for (int i = 0; i < array.length(); i++) {
                                JSONObject laptop = array.getJSONObject(i);
                                firstname.setText(laptop.getString("firstname"));
                                lastname.setText(laptop.getString("lastname"));
                                email.setText(laptop.getString("email"));
                                mobileno.setText(laptop.getString("mobileno"));
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(EditAccoutDetails.this, "Error is " + error, Toast.LENGTH_LONG).show();
                    }
                });
        Volley.newRequestQueue(this).add(stringRequest);
    }

}