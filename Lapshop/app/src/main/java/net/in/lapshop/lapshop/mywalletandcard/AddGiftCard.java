package net.in.lapshop.lapshop.mywalletandcard;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import net.in.lapshop.lapshop.R;
import net.in.lapshop.lapshop.address.ManageAddress;
import net.in.lapshop.lapshop.link;
import net.in.lapshop.lapshop.login.SharedPreferenceConfig;

import java.util.HashMap;
import java.util.Map;

public class AddGiftCard extends AppCompatActivity {

    private String url= link.url+"/Lapshop/MyWalletAndCard/insert_giftcard_details.php";
    private TextInputEditText giftcardnumber,giftcardpincode;
    private Button apply;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_gift_card);
        giftcardnumber=findViewById(R.id.addgiftcard_giftcardnumber);
        giftcardpincode=findViewById(R.id.addgiftcard_giftcardpincode);
        apply=findViewById(R.id.textView_apply);
        apply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addGiftCardDetails();
            }
        });

    }

    private void addGiftCardDetails() {
        RequestQueue queue= Volley.newRequestQueue(AddGiftCard.this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response.equals("1")){
                    startActivity(new Intent(AddGiftCard.this, MyWalletAndCard.class));
                    Toast.makeText(AddGiftCard.this, "GiftCard Add Successfully", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(AddGiftCard.this, "Insert Valid GiftCard Details", Toast.LENGTH_LONG).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(AddGiftCard.this, "Fail To Add GiftCard" + error, Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> par = new HashMap<>();
                par.put("cemail", SharedPreferenceConfig.getemail2() );
                par.put("gift_card_number",giftcardnumber.getText().toString().trim());
                par.put("gift_card_pincode", giftcardpincode.getText().toString().trim());
                return par;
            }
        };
        queue.add(stringRequest);
    }
}

