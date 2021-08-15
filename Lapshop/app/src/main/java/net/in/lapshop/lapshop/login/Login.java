package net.in.lapshop.lapshop.login;

/**
 * Created by Nikunj Ramani on 03/09/18.
 */

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
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
import net.in.lapshop.lapshop.homepage.customer_homepage;
import net.in.lapshop.lapshop.link;
import net.in.lapshop.lapshop.notification.EndPoints;
import net.in.lapshop.lapshop.notification.MyVolley;
import net.in.lapshop.lapshop.notification.SharedPrefManager;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.com.simplepass.loading_button_lib.customViews.CircularProgressButton;


public class Login extends AppCompatActivity {
    String gender="";
    private ProgressDialog progressDialog;
    TextInputLayout login_t1, login_t2, tt1, tt2, tt3, tt4, tt5;
    CircularProgressButton login_button, registration_button;
    Button login, singup;
    CardView c1, cc1;
    RadioButton male,female;
    String firstname, lastname, reemail, repassword, mobileno,strDate;
    TextView title,forgot_password;
    EditText login_email, login_password, registration_firstname, registration_lastname, registration_password, registration_email, registration_mobileno;
    String email, password,str=null;
    SharedPreferenceConfig sharedPreferenceConfig;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();
        sharedPreferenceConfig = new SharedPreferenceConfig(Login.this);

        title = findViewById(R.id.title);
        c1 = findViewById(R.id.c1);
        cc1 = findViewById(R.id.cc1);
        login_t1 = findViewById(R.id.login_t1);
        login_t2 = findViewById(R.id.login_t2);
        tt1 = findViewById(R.id.tt1);
        tt2 = findViewById(R.id.tt2);
        tt3 = findViewById(R.id.tt3);
        tt4 = findViewById(R.id.tt4);
        tt5 = findViewById(R.id.tt5);
        male=findViewById(R.id.male);
        female=findViewById(R.id.female);
        login_email = findViewById(R.id.login_email);
        login_password = findViewById(R.id.login_password);
        registration_firstname = findViewById(R.id.reg_firstname);
        registration_lastname = findViewById(R.id.reg_lastname);
        registration_email = findViewById(R.id.reg_email);
        registration_password = findViewById(R.id.reg_password);
        registration_mobileno = findViewById(R.id.reg_mobileno);
        login = findViewById(R.id.login);
        singup = findViewById(R.id.registration);
        login_button = findViewById(R.id.login_button);
        registration_button = findViewById(R.id.reg_button);

       if (sharedPreferenceConfig.ReadLoginStatus()) {
        startActivity(new Intent(Login.this, customer_homepage.class));
           finish();
        }

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation a, b, c, d;
                title.setVisibility(View.GONE);
                c1.setVisibility(View.VISIBLE);
                login.setVisibility(View.GONE);
                singup.setVisibility(View.GONE);
                a = AnimationUtils.loadAnimation(Login.this, R.anim.login_button);
                b = AnimationUtils.loadAnimation(Login.this, R.anim.login_email);
                c = AnimationUtils.loadAnimation(Login.this, R.anim.login_password);
                d = AnimationUtils.loadAnimation(Login.this, R.anim.cardview);
                c1.setAnimation(d);
                login_t1.setAnimation(b);
                login_t2.setAnimation(c);
                login_button.setAnimation(a);
                login_button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        final RequestQueue queue = Volley.newRequestQueue(Login.this);
                        email = login_email.getText().toString().trim();
                        password = login_password.getText().toString().trim();
                        if (TextUtils.isEmpty(email) || TextUtils.isEmpty(password)) {
                            login_email.setError("Fields can't be empty");
                            login_password.setError("Fields can't be empty");
                        }
                        else {
                            if (login_email.getText().toString().length() == 0) {
                                email = SharedPreferenceConfig.getemail2();
                            } else {
                                sharedPreferenceConfig.getEmaill(login_email.getText().toString().trim());
                            }
                            login_button.startAnimation();

                            AsyncTask<String, String, String> demoLogin = new AsyncTask<String, String, String>() {
                                @Override
                                protected String doInBackground(String... params) {
                                    String url = link.url+"/Lapshop/Account/customer_login.php";
                                    StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                                        @Override
                                        public void onResponse(String response) {
                                                Intent i = new Intent(Login.this, customer_homepage.class);
                                                startActivity(i);
                                                Toast.makeText(Login.this, "Account Successfully Login", Toast.LENGTH_LONG).show();
                                                sharedPreferenceConfig.WriteLoginStatus(true);
                                                finish();

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
                                    return str;
                                }

                                @Override
                                protected void onPostExecute(String s) {

                                }
                            };
                            demoLogin.execute();


                        }
                    }
                });

            }
        });


        singup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                title.setVisibility(View.GONE);
                final Animation a, b, c, d, e, f, g;
                cc1.setVisibility(View.VISIBLE);
                login.setVisibility(View.GONE);
                singup.setVisibility(View.GONE);
                a = AnimationUtils.loadAnimation(Login.this, R.anim.registration_button);
                b = AnimationUtils.loadAnimation(Login.this, R.anim.cardview);
                c = AnimationUtils.loadAnimation(Login.this, R.anim.registration_firstname);
                d = AnimationUtils.loadAnimation(Login.this, R.anim.registration_lastname);
                e = AnimationUtils.loadAnimation(Login.this, R.anim.registration_email);
                f = AnimationUtils.loadAnimation(Login.this, R.anim.registration_password);
                g = AnimationUtils.loadAnimation(Login.this, R.anim.registration_mobileno);
                cc1.setAnimation(b);
                tt1.setAnimation(c);
                tt2.setAnimation(d);
                tt3.setAnimation(e);
                tt4.setAnimation(f);
                tt5.setAnimation(g);
                registration_button.setAnimation(a);
                registration_button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Calendar c = Calendar.getInstance();
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        strDate = sdf.format(c.getTime());
                        final RequestQueue queue = Volley.newRequestQueue(Login.this);
                        firstname = registration_firstname.getText().toString();
                        lastname = registration_lastname.getText().toString();
                        reemail = registration_email.getText().toString();
                        repassword = registration_password.getText().toString();
                        mobileno = registration_mobileno.getText().toString();

                        if (male.isChecked()){
                            female.setChecked(false);
                            gender="Male";
                        }else if(female.isChecked()){
                            male.setChecked(false);
                            gender="Female";
                        }

                        if (TextUtils.isEmpty(reemail) || TextUtils.isEmpty(repassword) || TextUtils.isEmpty(firstname) || TextUtils.isEmpty(lastname) || TextUtils.isEmpty(mobileno)) {
                            Toast.makeText(Login.this, "Any Fields Can not be empty,Please enter Details", Toast.LENGTH_LONG).show();
                        } else {
                            registration_button.startAnimation();

                            AsyncTask<String, String, String> demoLogin = new AsyncTask<String, String, String>() {
                                @Override
                                protected String doInBackground(String... params) {

                                    String url = link.url+"/Lapshop/Account/customer_singup.php";
                                    StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                                        @Override
                                        public void onResponse(String response) {
                                            Log.e("nnn", response);
                                                sendTokenToServer();
                                                Intent i = new Intent(Login.this, Login.class);
                                                startActivity(i);
                                                Toast.makeText(Login.this, "Account Created Successfully", Toast.LENGTH_LONG).show();

                                        }
                                    }, new Response.ErrorListener() {
                                        @Override
                                        public void onErrorResponse(VolleyError error) {
                                            login_button.revertAnimation();
                                            Toast.makeText(Login.this, "Fail To Create Account" + error, Toast.LENGTH_SHORT).show();
                                        }
                                    }) {
                                        @Override
                                        protected Map<String, String> getParams() throws AuthFailureError {
                                            Map<String, String> par = new HashMap<>();
                                            par.put("firstname", firstname);
                                            par.put("lastname", lastname);
                                            par.put("email", reemail);
                                            par.put("password", repassword);
                                            par.put("gender",gender);
                                            par.put("mobileno", mobileno);
                                            par.put("date", strDate);
                                            return par;
                                        }
                                    };
                                    queue.add(stringRequest);

                                    return "done";
                                }

                                @Override
                                protected void onPostExecute(String s) {
                                }
                            };
                            demoLogin.execute();
                        }
                    }
                });

            }
        });

        forgot_password=findViewById(R.id.login_forgotpassword);
        forgot_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(login_email.getText())){
                    login_email.setError("Enter Email Address");
                }else{
                    Intent i=new Intent(Login.this,forgot_password.class);
                    i.putExtra("email",login_email.getText().toString());
                    startActivity(i);
                }
            }
        });
    }
    private void sendTokenToServer() {
        final String token = SharedPrefManager.getInstance(this).getDeviceToken();
        final String reemail = this.reemail;

        if (token == null) {
            Toast.makeText(this, "Token not generated", Toast.LENGTH_LONG).show();
            return;
        }

        StringRequest stringRequest = new StringRequest(Request.Method.POST, EndPoints.URL_REGISTER_DEVICE,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject obj = new JSONObject(response);
                            Toast.makeText(Login.this, obj.getString("message"), Toast.LENGTH_LONG).show();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(Login.this, error.getMessage(), Toast.LENGTH_LONG).show();
                    }
                }) {

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("email", reemail);
                params.put("token", token);
                return params;
            }
        };
        MyVolley.getInstance(this).addToRequestQueue(stringRequest);
    }


    private boolean emailValidator(String s) {
        Pattern pattern;
        Matcher matcher;
        final String Email_Pattern = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        pattern = Pattern.compile(Email_Pattern);
        matcher = pattern.matcher(s);
        return matcher.matches();
    }
    private boolean isValidPassword(String password) {
        Pattern pattern;
        Matcher matcher;
        final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{4,}$";
        pattern = Pattern.compile(PASSWORD_PATTERN);
        matcher = pattern.matcher(password);

        return matcher.matches();

    }
    @Override
    public void onBackPressed() {
        startActivity(new Intent(Login.this, Login.class));
    }
}
