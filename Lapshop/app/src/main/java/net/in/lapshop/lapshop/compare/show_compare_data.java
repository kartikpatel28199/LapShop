package net.in.lapshop.lapshop.compare;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;

import net.in.lapshop.lapshop.R;
import net.in.lapshop.lapshop.link;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class show_compare_data extends AppCompatActivity {
    private TextView brand1,type1,modelno1,modelname1,ram1,ssd1,price1,ramtype1,hdd1,os1,graphic1,cache1,battery1,processor1;
    private TextView brand2,type2,modelno2,modelname2,ram2,ssd2,price2,ramtype2,hdd2,os2,graphic2,cache2,battery2,processor2;
    private ImageView image1,image2;
    private String URL_LAPTOP1,URL_LAPTOP2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_compare_data);
        URL_LAPTOP1= link.url+"/Lapshop/compare/laptop_compare.php?sid="+getIntent().getStringExtra("sid1");
        URL_LAPTOP2=link.url+"/Lapshop/compare/laptop_compare.php?sid="+getIntent().getStringExtra("sid2");
        Toast.makeText(this,URL_LAPTOP1,Toast.LENGTH_LONG).show();
        Toast.makeText(this,URL_LAPTOP2,Toast.LENGTH_LONG).show();
        getActivityResources();
        getCompareData1();
        getCompareData2();
    }

    private void getCompareData2() {
        StringRequest stringRequest=new StringRequest(Request.Method.POST, URL_LAPTOP2, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    String s;
                    JSONArray array=new JSONArray(response);
                    for (int i=0;i<array.length();i++){
                        JSONObject laptop=array.getJSONObject(i);
                        brand2.setText(laptop.getString("laptop_brand"));
                        type2.setText(laptop.getString("laptop_type"));
                        modelname2.setText(laptop.getString("laptop_modelno"));
                        modelno2.setText(laptop.getString("laptop_modelname"));
                        ram2.setText(laptop.getString("ram"));
                        ssd2.setText(laptop.getString("ssd"));
                        price2.setText(laptop.getString("laptop_price"));
                        ramtype2.setText(laptop.getString("ram_type"));
                        hdd2.setText(laptop.getString("hdd_capacity"));
                        os2.setText(laptop.getString("operating_system"));
                        graphic2.setText(laptop.getString("graphics_processor"));
                        cache2.setText(laptop.getString("cache"));
                        battery2.setText(laptop.getString("battary_backup"));
                        s=laptop.getString("processor_brand")+laptop.getString("processor_name")+laptop.getString("processor_generation");
                        processor2.setText(s);
                        Glide.with(show_compare_data.this).load(laptop.getString("image_1")).into(image2);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(show_compare_data.this,"error"+error,Toast.LENGTH_LONG).show();
            }
        }
        );
        Volley.newRequestQueue(show_compare_data.this).add(stringRequest);
    }

    private void getCompareData1() {
        StringRequest stringRequest=new StringRequest(Request.Method.POST, URL_LAPTOP1, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    String s;
                    JSONArray array=new JSONArray(response);
                    for (int i=0;i<array.length();i++){
                        JSONObject laptop=array.getJSONObject(i);
                        brand1.setText(laptop.getString("laptop_brand"));
                        type1.setText(laptop.getString("laptop_type"));
                        modelname1.setText(laptop.getString("laptop_modelno"));
                        modelno1.setText(laptop.getString("laptop_modelname"));
                        ram1.setText(laptop.getString("ram"));
                        ssd1.setText(laptop.getString("ssd"));
                        price1.setText(laptop.getString("laptop_price"));
                        ramtype1.setText(laptop.getString("ram_type"));
                        hdd1.setText(laptop.getString("hdd_capacity"));
                        os1.setText(laptop.getString("operating_system"));
                        graphic1.setText(laptop.getString("graphics_processor"));
                        cache1.setText(laptop.getString("cache"));
                        battery1.setText(laptop.getString("battary_backup"));
                        s=laptop.getString("processor_brand")+" "+laptop.getString("processor_name")+" "+laptop.getString("processor_generation");
                        processor1.setText(s);

                        Glide.with(show_compare_data.this).load(laptop.getString("image_1")).into(image1);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(show_compare_data.this,"error"+error,Toast.LENGTH_LONG).show();
            }
        }
        );
        Volley.newRequestQueue(show_compare_data.this).add(stringRequest);
    }

    private void getActivityResources() {
        brand1=findViewById(R.id.brand1);
        type1=findViewById(R.id.type1);
        modelname1=findViewById(R.id.modelname1);
        modelno1=findViewById(R.id.modelno1);
        ram1=findViewById(R.id.ram1);
        ssd1=findViewById(R.id.ssd1);
        price1=findViewById(R.id.price1);
        ramtype1=findViewById(R.id.ramtype1);
        hdd1=findViewById(R.id.hdd1);
        os1=findViewById(R.id.os1);
        graphic1=findViewById(R.id.graphics1);
        cache1=findViewById(R.id.cache1);
        battery1=findViewById(R.id.batterybackup1);
        processor1=findViewById(R.id.processor1);
        image1=findViewById(R.id.image1);
        brand2=findViewById(R.id.brand2);
        type2=findViewById(R.id.type2);
        modelname2=findViewById(R.id.modelname2);
        modelno2=findViewById(R.id.modelno2);
        ram2=findViewById(R.id.ram2);
        ssd2=findViewById(R.id.ssd2);
        price2=findViewById(R.id.price2);
        ramtype2=findViewById(R.id.ramtype2);
        hdd2=findViewById(R.id.hdd2);
        os2=findViewById(R.id.os2);
        graphic2=findViewById(R.id.graphics2);
        cache2=findViewById(R.id.cache2);
        battery2=findViewById(R.id.batterybackup2);
        processor2=findViewById(R.id.processor2);
        image2=findViewById(R.id.image2);
    }
}
