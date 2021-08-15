package net.in.lapshop.lapshop.mywalletandcard;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import net.in.lapshop.lapshop.R;
import net.in.lapshop.lapshop.link;
import net.in.lapshop.lapshop.login.SharedPreferenceConfig;

import java.util.HashMap;
import java.util.Map;

public class AddCardDetails extends AppCompatActivity {
    Button cont;
    TextInputEditText cardnumber,cardname,cardlabel;
    Spinner spinner1,spinner2;
    String s1,s2,url;
    String[] no={"01","02","03","04","05","06","07","08","09","10","11","12"};
    String[] no1={"2018","2019","2020","2021","2022","2023","2024","2025","2026","2027","2028","2029","2030","2031","2032","2033","2034","2035"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_card_details);
        cont=findViewById(R.id.cont);
        url= link.url+"/Lapshop/MyWalletAndCard/insert_credit_debit_card_details.php";
        cardlabel=findViewById(R.id.cardlabel);
        cardname=findViewById(R.id.cardname);
        cardnumber=findViewById(R.id.cardnumber);
        spinner1=findViewById(R.id.spiner1);
        spinner2=findViewById(R.id.spiner2);
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(AddCardDetails.this,android.R.layout.simple_spinner_dropdown_item,no);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(arrayAdapter);

        ArrayAdapter<String> arrayAdapter1=new ArrayAdapter<String>(AddCardDetails.this,android.R.layout.simple_spinner_dropdown_item,no1);
        arrayAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(arrayAdapter1);


        cont.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s1=spinner1.getSelectedItem().toString();
                s2=spinner2.getSelectedItem().toString();
                StringRequest stringRequest=new StringRequest(StringRequest.Method.POST, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if (response.equals("1")){
                            Toast.makeText(AddCardDetails.this,"Card Insert Successfully",Toast.LENGTH_LONG).show();
                            startActivity(new Intent(AddCardDetails.this,MyWalletAndCard.class));
                        }else {
                            Toast.makeText(AddCardDetails.this,"Invalid Details",Toast.LENGTH_LONG).show();
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
                        par.put("card_label",cardlabel.getText().toString());
                        par.put("card_name",cardname.getText().toString());
                        par.put("card_number",cardnumber.getText().toString());
                        par.put("expiry_date",s1+" "+s2);
                        return par;
                    }
                };
                Volley.newRequestQueue(AddCardDetails.this).add(stringRequest);
            }
        });
    }
}
