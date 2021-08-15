package net.in.lapshop.lapshop.order;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import net.in.lapshop.lapshop.R;
import net.in.lapshop.lapshop.link;
import net.in.lapshop.lapshop.login.SharedPreferenceConfig;
import net.in.lapshop.lapshop.mywalletandcard.MyWalletAndCard;

import java.util.HashMap;
import java.util.Map;

public class payments_method extends AppCompatActivity {

    RadioButton paytm,netBanking,creditdebitcard,cashonDelivery;
    Button continues;
    TextView price;
    String  url3= link.url+"/Lapshop/order/inser_ordernow_data.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payments_method);
        paytm=findViewById(R.id.paytm);
        netBanking=findViewById(R.id.netbanking);
        creditdebitcard=findViewById(R.id.creditdebitcard);
        cashonDelivery=findViewById(R.id.cashondelivery);
        continues=findViewById(R.id.cc1);
        price=findViewById(R.id.price1);
        price.setText(getIntent().getStringExtra("price"));
        if(paytm.isChecked()){
            netBanking.setChecked(false);
            cashonDelivery.setChecked(false);
            creditdebitcard.setChecked(false);
        }else if(netBanking.isChecked()){
            paytm.setChecked(false);
            cashonDelivery.setChecked(false);
            creditdebitcard.setChecked(false);
        }else if(creditdebitcard.isChecked()){
            paytm.setChecked(false);
            netBanking.setChecked(false);
            cashonDelivery.setChecked(false);
        }else if(cashonDelivery.isChecked()){
            netBanking.setChecked(false);
            paytm.setChecked(false);
            creditdebitcard.setChecked(false);
        }
        continues.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(paytm.isChecked()){
                 }else if(netBanking.isChecked()){
                 }else if(creditdebitcard.isChecked()){
                    Intent i=new Intent(payments_method.this,creditdebitcardpayment.class);
                    i.putExtra("price",getIntent().getStringExtra("price"));
                    i.putExtra("maid",getIntent().getStringExtra("maid"));
                    i.putExtra("sid",getIntent().getStringExtra("sid"));
                    startActivity(i);
                }else if(cashonDelivery.isChecked()){
                    StringRequest stringRequest=new StringRequest(StringRequest.Method.POST, url3, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            if (response.equals("1")){
                                Toast.makeText(payments_method.this,"Order Is Booked",Toast.LENGTH_LONG).show();
                                startActivity(new Intent(payments_method.this,MyWalletAndCard.class));
                            }else {
                                Toast.makeText(payments_method.this,"Order Is Not Booked Due To Some Error",Toast.LENGTH_LONG).show();
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
                            par.put("cdid","");
                            par.put("maid",getIntent().getStringExtra("maid"));
                            par.put("payment_method","cash On Delivery");
                            return par;
                        }
                    };
                    Volley.newRequestQueue(payments_method.this).add(stringRequest);
                 }
            }
        });
    }
}
