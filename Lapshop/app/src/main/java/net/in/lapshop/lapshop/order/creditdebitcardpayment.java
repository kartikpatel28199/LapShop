package net.in.lapshop.lapshop.order;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

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

public class creditdebitcardpayment extends AppCompatActivity {

    TextView cardnumber,cardlabel,price;
    EditText cvv;
    Button continues;
    String url;
    String cdid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creditdebitcardpayment);
        url= link.url+"/Lapshop/MyWalletAndCard/show_creditdebitcard_details.php?cemail="+ SharedPreferenceConfig.getemail2();
        cardnumber=findViewById(R.id.cardnumber);
        cardlabel=findViewById(R.id.cardlabel);
        cvv=findViewById(R.id.cvv);
        price=findViewById(R.id.price1);
        continues=findViewById(R.id.continues);
        price.setText(getIntent().getStringExtra("price"));
        getData();
        continues.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(creditdebitcardpayment.this,otp.class);
                i.putExtra("price",getIntent().getStringExtra("price"));
                i.putExtra("maid",getIntent().getStringExtra("maid"));
                i.putExtra("sid",getIntent().getStringExtra("sid"));
                i.putExtra("payment_method","creditDebit");
                i.putExtra("cdid",cdid);
                startActivity(i);
            }
        });
    }

    private void getData() {
        StringRequest stringRequest=new StringRequest(StringRequest.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray array=new JSONArray(response);
                    if(array==null){

                    }else {
                        for (int i = 0; i < array.length(); i++) {
                            JSONObject caard = array.getJSONObject(i);
                            cdid=caard.getString("cdid");
                            cardnumber.setText(caard.getString("card_number"));
                            cardlabel.setText(caard.getString("card_label"));
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        Volley.newRequestQueue(creditdebitcardpayment.this).add(stringRequest);
    }
}
