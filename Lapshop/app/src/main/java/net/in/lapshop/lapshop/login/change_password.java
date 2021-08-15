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

public class change_password extends AppCompatActivity {

    String url;
    EditText e1,e2;
    Button chnagepassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);
        url= link.url+"/Lapshop/forgot_password/change_password.php"+getIntent().getStringExtra("mobileno");
        e1=findViewById(R.id.e1);
        e2=findViewById(R.id.e2);
        chnagepassword=findViewById(R.id.change_password);
        chnagepassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(e1.getText().toString()== e2.getText().toString()){
                    RequestQueue queue= Volley.newRequestQueue(change_password.this);
                    StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            if (response.equals("1")){
                                startActivity(new Intent(change_password.this, Login.class));
                                Toast.makeText(change_password.this, "Password Is Updated", Toast.LENGTH_LONG).show();
                            }else{
                                Toast.makeText(change_password.this, "Password Is Not Updated", Toast.LENGTH_LONG).show();
                            }
                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText(change_password.this, "Fail To Update Password" + error, Toast.LENGTH_SHORT).show();
                        }
                    });
                    queue.add(stringRequest);
                }else{
                    e2.setError("Password Must Be Same");
                    e1.setError("Password Must Be Same");
                }
            }
        });
    }
}
