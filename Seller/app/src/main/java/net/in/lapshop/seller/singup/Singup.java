package net.in.lapshop.seller.singup;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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

import net.in.lapshop.seller.Login.Login;
import net.in.lapshop.seller.R;

import java.util.HashMap;
import java.util.Map;

public class Singup extends AppCompatActivity {
    String firstname, lastname, email, password,mobileno;
    EditText e1, e2, e3, e4, e5;
    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singup);
        e1 = (EditText) findViewById(R.id.e1);
        e2 = (EditText) findViewById(R.id.e2);
        e3 = (EditText) findViewById(R.id.e3);
        e4 = (EditText) findViewById(R.id.e4);
        e5 = (EditText) findViewById(R.id.e5);
        b1=(Button)findViewById(R.id.b1);
        getSupportActionBar().hide();
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RequestQueue queue = Volley.newRequestQueue(Singup.this);
                firstname = e1.getText().toString();
                lastname = e2.getText().toString();
                email = e3.getText().toString();
                password = e4.getText().toString();
                mobileno = e5.getText().toString();

                String url = "http://lapshop.in.net/seller/Login/seller_singup.php";
                StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.e("nnn", response);
                        if (response.equals("1")){
                            startActivity(new Intent(Singup.this, Login.class));
                            Toast.makeText(Singup.this, "Account Created Successfully", Toast.LENGTH_LONG).show();
                        }else{
                            Toast.makeText(Singup.this, "Insert Valid Details", Toast.LENGTH_LONG).show();
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(Singup.this, "Fail To Create Account" + error, Toast.LENGTH_SHORT).show();
                    }
                }) {
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String, String> par = new HashMap<>();
                        par.put("firstname", firstname);
                        par.put("lastname", lastname);
                        par.put("email", email);
                        par.put("password", password);
                        par.put("mobileno", mobileno);
                        return par;
                    }
                };
                queue.add(stringRequest);
            }
        });
    }
}