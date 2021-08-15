package net.in.lapshop.lapshop.order;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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
import net.in.lapshop.lapshop.mywalletandcard.MyWalletAndCard;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class otp extends AppCompatActivity {

    Button pay;
    String url1,url2,url3;
    Integer otp1;
    EditText otp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);
        url2= link.url+"/Lapshop/order/show_otp.php?e="+ SharedPreferenceConfig.getemail2();
        url3=link.url+"/Lapshop/order/inser_ordernow_data.php";
        url1=link.url+"/Lapshop/order/send_message.php?e="+SharedPreferenceConfig.getemail2();
        sendOtp();
        pay=findViewById(R.id.pay);
        otp=findViewById(R.id.otp);
        matchOtp();
        pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Integer.parseInt(otp.getText().toString())==otp1){
                    Toast.makeText(otp.this,"Otp is Match",Toast.LENGTH_LONG).show();
                    StringRequest stringRequest=new StringRequest(StringRequest.Method.POST, url3, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            if (response.equals("1")){
                                Toast.makeText(otp.this,"Order Is Booked",Toast.LENGTH_LONG).show();
                                startActivity(new Intent(otp.this,MyWalletAndCard.class));
                            }else {
                                Toast.makeText(otp.this,"Order Is Not Booked Due To Some Error",Toast.LENGTH_LONG).show();
                            }
                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {

                        }
                    }){
                        @Override
                        protected Map<String, String> getParams() throws AuthFailureError {
                            Map<String,String> par=new HashMap<>();
                            par.put("cemail", SharedPreferenceConfig.getemail2());
                            par.put("price",getIntent().getStringExtra("price"));
                            par.put("sid",getIntent().getStringExtra("sid"));
                            par.put("cdid",getIntent().getStringExtra("cdid"));
                            par.put("maid",getIntent().getStringExtra("maid"));
                            par.put("payment_method",getIntent().getStringExtra("payment_method"));
                            return par;
                        }
                    };
                    Volley.newRequestQueue(otp.this).add(stringRequest);
                }else {
                    Toast.makeText(otp.this,"Otp Is Wrong",Toast.LENGTH_LONG).show();
                }
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
                        Toast.makeText(otp.this, "Error is " + error, Toast.LENGTH_LONG).show();
                    }
                });
        Volley.newRequestQueue(otp.this).add(stringRequest);
    }

    private void sendOtp() {
        RequestQueue queue= Volley.newRequestQueue(otp.this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url1, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                    Toast.makeText(otp.this, "Otp is Send", Toast.LENGTH_LONG).show();

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(otp.this, "Fail To send Otp" + error, Toast.LENGTH_SHORT).show();
            }
        });
        queue.add(stringRequest);
    }
}
