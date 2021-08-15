package net.in.lapshop.seller.Login;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import net.in.lapshop.seller.R;
import net.in.lapshop.seller.homepage.home_page;
import net.in.lapshop.seller.singup.Singup;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Login extends AppCompatActivity {
    TextView t1;
    ImageView b1;
    TextInputEditText e1, e2;
    String email, password;
    SharedPreferenceConfig sharedPreferenceConfig;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();
        sharedPreferenceConfig = new SharedPreferenceConfig(Login.this);
        e1 = findViewById(R.id.e1);
        e2 = findViewById(R.id.e2);
        b1 = findViewById(R.id.b1);
        t1 = (TextView) findViewById(R.id.t3);
        if (sharedPreferenceConfig.ReadLoginStatus()) {
            startActivity(new Intent(Login.this, home_page.class));
            finish();
        }
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final ProgressDialog progressDialog = ProgressDialog.show(Login.this, "Logining...", "Please Wait...", true);
                new Thread(){
                    @Override
                    public void run() {
                        RequestQueue queue = Volley.newRequestQueue(Login.this);
                        email = e1.getText().toString().trim();
                        password = e2.getText().toString().trim();
                        if (TextUtils.isEmpty(email) || TextUtils.isEmpty(password)) {
                            e1.setError("Fields can't be empty");
                            e2.setError("Fields can't be empty");
                        } else if (!emailValidator(e1.getText().toString())) {
                            e1.setError("Please Enter Valid Email Address");
                        } else {
                            if (e1.getText().toString().length() == 0) {
                                email = SharedPreferenceConfig.getemail2();
                            } else {
                                sharedPreferenceConfig.getEmaill(e1.getText().toString().trim());
                            }
                            String url = "http://lapshop.in.net/seller/Login/seller_login.php";
                            StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                                @Override
                                public void onResponse(String response) {
                                    if (response.equals("1")) {
                                        Toast.makeText(Login.this, "Account Successfully Login", Toast.LENGTH_LONG).show();
                                        startActivity(new Intent(Login.this, home_page.class));
                                        sharedPreferenceConfig.WriteLoginStatus(true);
                                        finish();
                                    } else {
                                        e1.setText("");
                                        e2.setText("");
                                        Toast.makeText(Login.this, "Invalid Email And Password", Toast.LENGTH_LONG).show();
                                    }
                                }
                            }, new Response.ErrorListener() {
                                @Override
                                public void onErrorResponse(VolleyError error) {
                                    Toast.makeText(Login.this, "Error" + error, Toast.LENGTH_SHORT).show();
                                }
                            }) {
                                @Override
                                protected Map<String, String> getParams() throws AuthFailureError {
                                    Map<String, String> par = new HashMap<>();
                                    par.put("email", email);
                                    par.put("password", password);
                                    return par;
                                }
                            };
                            queue.add(stringRequest);
                        }
                        progressDialog.dismiss();
                    }
                }.start();

            }
        });
        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Login.this, Singup.class));
            }
        });

    }

    private boolean emailValidator(String s) {
        Pattern pattern;
        Matcher matcher;
        final String Email_Pattern = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        pattern = Pattern.compile(Email_Pattern);
        matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
