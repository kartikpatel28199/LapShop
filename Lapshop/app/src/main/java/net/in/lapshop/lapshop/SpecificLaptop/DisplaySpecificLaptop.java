package net.in.lapshop.lapshop.SpecificLaptop;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Gallery;
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

import net.in.lapshop.lapshop.R;
import net.in.lapshop.lapshop.link;
import net.in.lapshop.lapshop.login.SharedPreferenceConfig;
import net.in.lapshop.lapshop.mycart.My_Cart;
import net.in.lapshop.lapshop.order.order_now;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DisplaySpecificLaptop extends AppCompatActivity {

    private String URL_PRODUCTS;
    Gallery gallery;
    private ImageAdapter im;
    private TextView laptop_title, laptop_brand, laptop_shortdesc, laptop_price, laptop_type,  battary_backup, processor_brand, processor_name, processor_generation,ram, ram_type, hdd_capacity,cache, operating_system;
    private Button addcart, order;
    ImageView wishlist;
    TextView moredetails;
    private String title, price, brand, screen, email, images, color,sid;
    ArrayList<String> imagearray;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_specific_laptop);

        URL_PRODUCTS = link.url+"/Lapshop/retrive_data_laptop_specification.php?id="+Integer.parseInt(getIntent().getStringExtra("id"));

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        gallery = (Gallery) findViewById(R.id.gallary);
        imagearray = new ArrayList<>();

        getAllLaptopData();
        getAllLaptopSpecifications();


        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(DisplaySpecificLaptop.this,order_now.class);
                i.putExtra("sid",sid);
                startActivity(i);
            }
        });

        addcart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RequestQueue queue = Volley.newRequestQueue(DisplaySpecificLaptop.this);
                final String url = link.url+"/Lapshop/Mycart/laptop_insert_mycart_data.php";
                StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.e("nnn", response);
                        if (response.equals("1")){
                            Toast.makeText(DisplaySpecificLaptop.this,"Item Add in Cart",Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(DisplaySpecificLaptop.this,"Item Not Add in Cart",Toast.LENGTH_SHORT).show();
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(DisplaySpecificLaptop.this, "Fail To Add item" + error, Toast.LENGTH_SHORT).show();
                    }
                }){
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String, String> par = new HashMap<>();
                        par.put("sid",sid);
                        par.put("email",email);
                        par.put("laptop_title", title);
                        par.put("laptop_brand", brand);
                        par.put("screen_size", screen);
                        par.put("laptop_price", price);
                        par.put("image_1",images);
                        return par;
                    }
                };
                queue.add(stringRequest);
            }
        });
        wishlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RequestQueue queue = Volley.newRequestQueue(DisplaySpecificLaptop.this);
                final String url = link.url+"/Lapshop/WishList/laptop_insert_wishlist.php";
                StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if (response.equals("1")){
                            Toast.makeText(DisplaySpecificLaptop.this,"Item Add in Wish List",Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(DisplaySpecificLaptop.this,"Item Not Add in Wish List",Toast.LENGTH_SHORT).show();
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(DisplaySpecificLaptop.this, "Fail To Add item" + error, Toast.LENGTH_SHORT).show();
                    }
                }){
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String, String> par = new HashMap<>();
                        par.put("sid",sid);
                        par.put("email",email);
                        par.put("laptop_title", title);
                        par.put("laptop_brand", brand);
                        par.put("screen_size", screen);
                        par.put("color",color);
                        par.put("laptop_price", price);
                        par.put("image_1",images);
                        return par;
                    }
                };
                queue.add(stringRequest);
            }
        });

        moredetails=findViewById(R.id.moreDetails);
        moredetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(DisplaySpecificLaptop.this,DisplayLaptopSpecification.class);
                i.putExtra("id",sid);
                startActivity(i);
            }
        });
    }

    void getAllLaptopData() {
        addcart = findViewById(R.id.addcart);
        order = findViewById(R.id.order);
        wishlist = findViewById(R.id.wishlist);
        laptop_title = (TextView) findViewById(R.id.laptopTitle);
        laptop_brand = (TextView) findViewById(R.id.laptopBrand);
        laptop_shortdesc = (TextView) findViewById(R.id.laptopRatting);
        laptop_price = (TextView) findViewById(R.id.laptopPrice);
        laptop_type = findViewById(R.id.laptopType);
        battary_backup = findViewById(R.id.battaryBackup);
        processor_brand = findViewById(R.id.processorBrand);
        processor_name = findViewById(R.id.processorName);
        processor_generation = findViewById(R.id.processorGeneration);
        ram = findViewById(R.id.ram);
        ram_type = findViewById(R.id.ramType);
        hdd_capacity = findViewById(R.id.hddCapacity);
        cache = findViewById(R.id.cache);
        operating_system = findViewById(R.id.operatingSystem);
    }

    void getAllLaptopSpecifications() {

        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_PRODUCTS,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray array = new JSONArray(response);
                            for (int i = 0; i < array.length(); i++) {
                                JSONObject laptop = array.getJSONObject(i);

                                laptop_title.setText(laptop.getString("laptop_title"));
                                laptop_brand.setText(laptop.getString("laptop_brand"));
                                laptop_shortdesc.setText(laptop.getString("laptop_shortdesc"));
                                laptop_price.setText(laptop.getString("laptop_price"));
                                laptop_type.setText(laptop.getString("laptop_type"));
                                battary_backup.setText(laptop.getString("battary_backup"));
                                processor_brand.setText(laptop.getString("processor_brand"));
                                processor_name.setText(laptop.getString("processor_name"));
                                processor_generation.setText(laptop.getString("processor_generation"));
                                ram.setText(laptop.getString("ram"));
                                ram_type.setText(laptop.getString("ram_type"));
                                hdd_capacity.setText(laptop.getString("hdd_capacity"));
                                cache.setText(laptop.getString("cache"));
                                operating_system.setText(laptop.getString("operating_system"));
                                sid=String.valueOf(laptop.getString("sid"));

                                email=String.valueOf(SharedPreferenceConfig.getemail2());
                                title= String.valueOf(laptop.getString("laptop_title"));
                                price= String.valueOf(laptop.getString("laptop_price"));
                                brand= String.valueOf(laptop.getString("laptop_brand"));
                                screen= String.valueOf(laptop.getString("screen_size"));
                                color=String.valueOf(laptop.getString("laptop_color"));
                                images=String.valueOf(laptop.getString("image_1"));
                                imagearray.add(laptop.getString("image_1"));
                                imagearray.add(laptop.getString("image_2"));
                                imagearray.add(laptop.getString("image_3"));
                                imagearray.add(laptop.getString("image_4"));
                                imagearray.add(laptop.getString("image_5"));
                                im = new ImageAdapter(imagearray, DisplaySpecificLaptop.this);
                                gallery.setAdapter(im);

                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(DisplaySpecificLaptop.this, "Error is " + error, Toast.LENGTH_LONG).show();
                    }
                });
        Volley.newRequestQueue(this).add(stringRequest);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id == R.id.action_cart) {
           startActivity(new Intent(DisplaySpecificLaptop.this, My_Cart.class));
        } else if (id == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}