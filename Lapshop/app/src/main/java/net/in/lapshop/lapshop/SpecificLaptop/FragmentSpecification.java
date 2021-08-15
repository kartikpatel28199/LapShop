package net.in.lapshop.lapshop.SpecificLaptop;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import net.in.lapshop.lapshop.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class FragmentSpecification extends Fragment {
    private TextView laptop_modelno, laptop_modelname, laptop_color, battary_backup, processor_brand, processor_name, processor_generation, ssd, ram, ram_type, hdd_capacity, processor_variant, clock_speed, cache, graphics_processor, operating_system, mic_in, touch_screen, screen_size, screen_resolution, screen_type, speakers, internal_mic, sound_properties, wireless_lan, bluetooth, ethernet, disk_drive, web_camera, read_write_speed, keybord, pointer_device, battery, battery_type, warranty_summary, warranty_service_type, covered_in_warranty, not_covered_in_warranty, domestic_warranty;
    private View rootView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_fragment_specification, container, false);
        getData();
        showData();
        return rootView;
    }

    public FragmentSpecification() {
    }

    public void getData() {
        laptop_modelno = rootView.findViewById(R.id.modelNo);
        laptop_modelname = rootView.findViewById(R.id.modelName);
        laptop_color = rootView.findViewById(R.id.color);
        battary_backup = rootView.findViewById(R.id.battaryBackup);
        processor_brand = rootView.findViewById(R.id.processorBrand);
        processor_name = rootView.findViewById(R.id.processorName);
        processor_generation = rootView.findViewById(R.id.processorGeneration);
        ssd = rootView.findViewById(R.id.ssd);
        ram = rootView.findViewById(R.id.ram);
        ram_type = rootView.findViewById(R.id.ramType);
        hdd_capacity = rootView.findViewById(R.id.hddCapacity);
        processor_variant = rootView.findViewById(R.id.processorVariant);
        clock_speed = rootView.findViewById(R.id.clockSpeed);
        cache = rootView.findViewById(R.id.cache);
        graphics_processor = rootView.findViewById(R.id.graphicsProcessor);
        operating_system = rootView.findViewById(R.id.operatingSystem);
        mic_in = rootView.findViewById(R.id.micIn);
        touch_screen = rootView.findViewById(R.id.touchScreen);
        screen_size = rootView.findViewById(R.id.screenSize);
        screen_resolution = rootView.findViewById(R.id.screenResolution);
        screen_type = rootView.findViewById(R.id.screenType);
        speakers = rootView.findViewById(R.id.speaker);
        internal_mic = rootView.findViewById(R.id.internalMic);
        sound_properties = rootView.findViewById(R.id.soundProperties);
        wireless_lan = rootView.findViewById(R.id.wirelessLan);
        bluetooth = rootView.findViewById(R.id.bluetooth);
        ethernet = rootView.findViewById(R.id.ethernet);
        disk_drive = rootView.findViewById(R.id.diskDrive);
        web_camera = rootView.findViewById(R.id.webCamera);
        read_write_speed = rootView.findViewById(R.id.readWriteSpeed);
        keybord = rootView.findViewById(R.id.keybord);
        pointer_device = rootView.findViewById(R.id.pointerDevice);
        battery = rootView.findViewById(R.id.battary);
        battery_type = rootView.findViewById(R.id.battaryType);
        warranty_summary = rootView.findViewById(R.id.warrantSummary);
        warranty_service_type = rootView.findViewById(R.id.warrantServicetype);
        covered_in_warranty = rootView.findViewById(R.id.coveredInWarranty);
        not_covered_in_warranty = rootView.findViewById(R.id.notCoveredInWarranty);
        domestic_warranty = rootView.findViewById(R.id.domesticWarranty);
    }

    public void showData() {

        StringRequest stringRequest = new StringRequest(Request.Method.POST, DisplayLaptopSpecification.URL_PRODUCTS,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray array = new JSONArray(response);
                            for (int i = 0; i < array.length(); i++) {
                                JSONObject laptop = array.getJSONObject(i);
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
                        Toast.makeText(getContext(), "Error is " + error, Toast.LENGTH_LONG).show();
                    }
                });
        Volley.newRequestQueue(getContext()).add(stringRequest);
    }
}