package net.in.lapshop.lapshop.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import net.in.lapshop.lapshop.R;
import net.in.lapshop.lapshop.link;
import net.in.lapshop.lapshop.mywalletandcard.MyWalletAndCard;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class forgot_password extends AppCompatActivity {

    String url1,url2;
    Button next;
    EditText e1;
    Integer otp1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        next=findViewById(R.id.next);
        e1=findViewById(R.id.login_email1);

        url2= link.url+"/Lapshop/forgot_password/show_otp.php?e="+getIntent().getStringExtra("email");
        url1=link.url+"/Lapshop/forgot_password/send_message.php?e="+getIntent().getStringExtra("email");
        sendOtp();
        matchOtp();
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringRequest stringRequest = new StringRequest(Request.Method.POST, url2,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                if(Integer.parseInt(e1.getText().toString())==otp1) {
                                    Toast.makeText(forgot_password.this,"Otp is Match",Toast.LENGTH_LONG).show();
                                    try {
                                        JSONArray array = new JSONArray(response);
                                        for (int i = 0; i < array.length(); i++) {
                                            JSONObject laptop = array.getJSONObject(i);
                                                Intent ii = new Intent(forgot_password.this, change_password.class);
                                                ii.putExtra("mobileno", laptop.getString("mobileno"));
                                                startActivity(ii);
                                        }
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }
                                }else {

                                }
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Toast.makeText(forgot_password.this, "Error is " + error, Toast.LENGTH_LONG).show();
                            }
                        });
                Volley.newRequestQueue(forgot_password.this).add(stringRequest);
            }
        });
    }
    private void matchOtp() {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url2,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray array = new JSONArray(response);
                            for (int i = 0; i < array.length(); i++) {
                                JSONObject laptop = array.getJSONObject(i);
                                otp1=laptop.getInt("otp");
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(forgot_password.this, "Error is " + error, Toast.LENGTH_LONG).show();
                    }
                });
        Volley.newRequestQueue(forgot_password.this).add(stringRequest);
    }


    private void sendOtp() {
        RequestQueue queue= Volley.newRequestQueue(forgot_password.this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url1, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response.equals("1")){
                    startActivity(new Intent(forgot_password.this, MyWalletAndCard.class));
                    Toast.makeText(forgot_password.this, "Otp is Send", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(forgot_password.this, "Otp is not Send", Toast.LENGTH_LONG).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(forgot_password.this, "Fail To send Otp" + error, Toast.LENGTH_SHORT).show();
            }
        });
        queue.add(stringRequest);
    }
}
