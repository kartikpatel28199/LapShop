package net.in.lapshop.lapshop.account;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import net.in.lapshop.lapshop.R;
import net.in.lapshop.lapshop.link;
import net.in.lapshop.lapshop.login.Login;
import net.in.lapshop.lapshop.login.SharedPreferenceConfig;
import net.in.lapshop.lapshop.login.change_password;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class EditMyAccount extends AppCompatActivity {
    private String URL= link.url+"/Lapshop/profile_update/update_customer_profile.php?email="+ SharedPreferenceConfig.getemail2();

    ImageView edit;
    private TextView myWalletAndCard,Notification,textView_name,textView_email,textView_username,textView_mobileno,textView_gender;
    private ImageView imageView_user;
    String mobile;
    SharedPreferenceConfig sharedPreferenceConfig;
    private TextView textView_changepassword,textView_logout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_my_account);
        edit=findViewById(R.id.imageView_editaccount);
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(EditMyAccount.this,EditAccoutDetails.class));
            }
        });
        textView_email=findViewById(R.id.textView_email);
        textView_name=findViewById(R.id.textView_name);
        imageView_user=findViewById(R.id.imageView_user);
        textView_changepassword=findViewById(R.id.textView_changepassword);
        textView_username=findViewById(R.id.textView_username);
        textView_mobileno=findViewById(R.id.textView_mobileno);
        textView_gender=findViewById(R.id.textView_gender);
        loadProfileData();
        textView_changepassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(EditMyAccount.this,change_password.class);
                i.putExtra("mobileno",mobile);
                startActivity(i);
            }
        });
        textView_logout=findViewById(R.id.textView_logout);
        textView_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sharedPreferenceConfig.WriteLoginStatus(false);
                startActivity(new Intent(EditMyAccount.this,Login.class));
                finish();
            }
        });
    }
    private void loadProfileData() {

        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray array = new JSONArray(response);
                            for (int i = 0; i < array.length(); i++) {
                                JSONObject laptop = array.getJSONObject(i);
                                mobile=laptop.getString("mobileno");
                                textView_name.setText(laptop.getString("firstname")+" "+laptop.getString("lastname"));
                                textView_username.setText(laptop.getString("firstname")+" "+laptop.getString("lastname"));
                                textView_email.setText(laptop.getString("email"));
                                if (laptop.getString("gender").toLowerCase().equals("male")){
                                    imageView_user.setImageResource(R.drawable.homepage_account_maleprofile);
                                    textView_gender.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.homepage_account_male_gender,0,0,0);
                                }else if(laptop.getString("gender").toLowerCase().equals("female")){
                                    imageView_user.setImageResource(R.drawable.homepage_account_femaleprofile);
                                    textView_gender.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.homepage_account_female_gender,0,0,0);
                                }else {
                                    imageView_user.setImageResource(R.drawable.homepage_account_maleprofile);
                                    textView_gender.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.homepage_account_male_gender,0,0,0);
                                }
                                textView_mobileno.setText(laptop.getString("mobileno"));
                                textView_gender.setText(laptop.getString("gender"));
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(EditMyAccount.this, "Error is " + error, Toast.LENGTH_LONG).show();
                    }
                });
        Volley.newRequestQueue(EditMyAccount.this).add(stringRequest);
    }

}
