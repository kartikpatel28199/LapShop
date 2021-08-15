package net.in.lapshop.seller.showlaptopdetails;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import net.in.lapshop.seller.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ShowLaptopDetails extends AppCompatActivity {
    String URL_PRODUCTS;

    private EditText brand,type,title,price,shortdesc,laptop_modelno, laptop_modelname, laptop_color, battary_backup, processor_brand, processor_name, processor_generation, ssd, ram, ram_type, hdd_capacity, processor_variant, clock_speed, cache, graphics_processor, operating_system, mic_in, touch_screen, screen_size, screen_resolution, screen_type, speakers, internal_mic, sound_properties, wireless_lan, bluetooth, ethernet, disk_drive, web_camera, read_write_speed, keybord, pointer_device, battery, battery_type, warranty_summary, warranty_service_type, covered_in_warranty, not_covered_in_warranty, domestic_warranty;    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_laptop_details);
        URL_PRODUCTS = "http://lapshop.in.net/seller/retrive_data_laptop_specification.php?id="+getIntent().getIntExtra("sid",0);
        getData();
        showData();
    }
    public void getData() {

        title = findViewById(R.id.title);
        brand = findViewById(R.id.laptop_brand);
        type = findViewById(R.id.laptop_type);
        shortdesc = findViewById(R.id.laptop_shortdesc);
        price = findViewById(R.id.laptop_price);
        laptop_modelno = findViewById(R.id.modelNo);
        laptop_modelname = findViewById(R.id.modelName);
        laptop_color = findViewById(R.id.color);
        battary_backup = findViewById(R.id.battaryBackup);
        processor_brand = findViewById(R.id.processorBrand);
        processor_name = findViewById(R.id.processorName);
        processor_generation = findViewById(R.id.processorGeneration);
        ssd = findViewById(R.id.ssd);
        ram = findViewById(R.id.ram);
        ram_type = findViewById(R.id.ramType);
        hdd_capacity = findViewById(R.id.hddCapacity);
        processor_variant = findViewById(R.id.processorVariant);
        clock_speed = findViewById(R.id.clockSpeed);
        cache = findViewById(R.id.cache);
        graphics_processor = findViewById(R.id.graphicsProcessor);
        operating_system = findViewById(R.id.operatingSystem);
        mic_in = findViewById(R.id.micIn);
        touch_screen = findViewById(R.id.touchScreen);
        screen_size = findViewById(R.id.screenSize);
        screen_resolution = findViewById(R.id.screenResolution);
        screen_type = findViewById(R.id.screenType);
        speakers = findViewById(R.id.speaker);
        internal_mic = findViewById(R.id.internalMic);
        sound_properties = findViewById(R.id.soundProperties);
        wireless_lan = findViewById(R.id.wirelessLan);
        bluetooth = findViewById(R.id.bluetooth);
        ethernet = findViewById(R.id.ethernet);
        disk_drive = findViewById(R.id.diskDrive);
        web_camera = findViewById(R.id.webCamera);
        read_write_speed = findViewById(R.id.readWriteSpeed);
        keybord = findViewById(R.id.keybord);
        pointer_device = findViewById(R.id.pointerDevice);
        battery = findViewById(R.id.battary);
        battery_type = findViewById(R.id.battaryType);
        warranty_summary = findViewById(R.id.warrantSummary);
        warranty_service_type = findViewById(R.id.warrantServicetype);
        covered_in_warranty = findViewById(R.id.coveredInWarranty);
        not_covered_in_warranty = findViewById(R.id.notCoveredInWarranty);
        domestic_warranty = findViewById(R.id.domesticWarranty);
    }
    public void showData() {

        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_PRODUCTS,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray array = new JSONArray(response);
                            for (int i = 0; i < array.length(); i++) {
                                JSONObject laptop = array.getJSONObject(i);
                                title.setText(laptop.getString("laptop_title"));
                                price.setText(laptop.getString("laptop_price"));
                                brand.setText(laptop.getString("laptop_brand"));
                                type.setText(laptop.getString("laptop_type"));
                                shortdesc.setText(laptop.getString("laptop_shortdesc"));
                                laptop_modelno.setText(laptop.getString("laptop_modelno"));
                                laptop_modelname.setText(laptop.getString("laptop_modelname"));
                                laptop_color.setText(laptop.getString("laptop_color"));
                                battary_backup.setText(laptop.getString("battary_backup"));
                                processor_brand.setText(laptop.getString("processor_brand"));
                                processor_name.setText(laptop.getString("processor_name"));
                                processor_generation.setText(laptop.getString("processor_generation"));
                                ssd.setText(laptop.getString("ssd"));
                                ram.setText(laptop.getString("ram"));
                                ram_type.setText(laptop.getString("ram_type"));
                                hdd_capacity.setText(laptop.getString("hdd_capacity"));
                                processor_variant.setText(laptop.getString("processor_variant"));
                                clock_speed.setText(laptop.getString("clock_speed"));
                                cache.setText(laptop.getString("cache"));
                                graphics_processor.setText(laptop.getString("graphics_processor"));
                                operating_system.setText(laptop.getString("operating_system"));
                                mic_in.setText(laptop.getString("mic_in"));
                                touch_screen.setText(laptop.getString("touch_screen"));
                                screen_size.setText(laptop.getString("screen_size"));
                                screen_resolution.setText(laptop.getString("screen_resolution"));
                                screen_type.setText(laptop.getString("screen_type"));
                                speakers.setText(laptop.getString("speakers"));
                                internal_mic.setText(laptop.getString("internal_mic"));
                                sound_properties.setText(laptop.getString("sound_properties"));
                                wireless_lan.setText(laptop.getString("wireless_lan"));
                                bluetooth.setText(laptop.getString("bluetooth"));
                                ethernet.setText(laptop.getString("ethernet"));
                                disk_drive.setText(laptop.getString("disk_drive"));
                                web_camera.setText(laptop.getString("web_camera"));
                                read_write_speed.setText(laptop.getString("read_write_speed"));
                                keybord.setText(laptop.getString("keybord"));
                                pointer_device.setText(laptop.getString("pointer_device"));
                                battery.setText(laptop.getString("battery"));
                                battery_type.setText(laptop.getString("battery_type"));
                                warranty_summary.setText(laptop.getString("warranty_summary"));
                                warranty_service_type.setText(laptop.getString("warranty_service_type"));
                                covered_in_warranty.setText(laptop.getString("covered_in_warranty"));
                                not_covered_in_warranty.setText(laptop.getString("not_covered_in_warranty"));
                                domestic_warranty.setText(laptop.getString("domestic_warranty"));

                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(ShowLaptopDetails.this, "Error is " + error, Toast.LENGTH_LONG).show();
                    }
                });
        Volley.newRequestQueue(ShowLaptopDetails.this).add(stringRequest);
    }

}
