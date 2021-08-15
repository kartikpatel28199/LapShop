package net.in.lapshop.lapshop.Filter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import net.in.lapshop.lapshop.R;
import net.in.lapshop.lapshop.link;
import net.in.lapshop.lapshop.showlaptop.Laptop;
import net.in.lapshop.lapshop.showlaptop.LaptopAdapter;
import net.in.lapshop.lapshop.showlaptop.showlaptop;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class FilterLaptop extends AppCompatActivity {
    private String URL_PRODUCTS = link.url+"/Lapshop/retrive_data_for_searchpage.php";
    private ListView filter1;
    private ListView filter2;
    private String[] filter1List,filter2List;
    private ArrayList<Laptop> allLaptopList,laptopList;
    private Button apply;
    LaptopAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        allLaptopList=new ArrayList<>();
        laptopList=new ArrayList<>();
        setContentView(R.layout.activity_filter_laptop);
        loadLaptop();
        apply=findViewById(R.id.apply);
        filter1=findViewById(R.id.listView_filter1);
        filter2=findViewById(R.id.recyclerView_filter2);

        filter1List=getResources().getStringArray(R.array.filterList);
        final ArrayAdapter<String> filter1Adapter=new ArrayAdapter<String>(FilterLaptop.this,android.R.layout.simple_selectable_list_item,android.R.id.text1,filter1List);
        filter1.setAdapter(filter1Adapter);

        filter1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               if(position==0){
                   filter2List=getResources().getStringArray(R.array.filter_brand);
                   final ArrayAdapter<String> filter2Adapter=new ArrayAdapter<String>(FilterLaptop.this,android.R.layout.simple_list_item_multiple_choice,android.R.id.text1,filter2List);
                   filter2.setAdapter(filter2Adapter);
                   filter2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                       @Override
                       public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                           CheckedTextView checkedTextView = ((CheckedTextView)view);
                           checkedTextView.setChecked(!checkedTextView.isChecked());
                           if(position==0){
                               Filterlist("acer");

                           }else if(position==1){
                               Filterlist("dell");
                           }else if(position==2){
                               Filterlist("lenovo");
                           }else if(position==3){
                               Filterlist("hp");
                           }else if(position==4){
                               Filterlist("toshiba");
                           }else if(position==5){
                               Filterlist("lg");
                           }else if(position==6){
                               Filterlist("apple");
                           }else if(position==7){
                               Filterlist("micromax");
                           }else if(position==8){
                               Filterlist("microsoft");
                           }else if(position==9){
                               Filterlist("sony");
                           }else if(position==10){
                               Filterlist("samsung");
                           }
                       }
                   });
               }else if(position == 1){

               }else if(position == 2){
                   filter2List=getResources().getStringArray(R.array.filter_processor);
                   final ArrayAdapter<String> filter2Adapter=new ArrayAdapter<String>(FilterLaptop.this,android.R.layout.simple_list_item_multiple_choice,android.R.id.text1,filter2List);
                   filter2.setAdapter(filter2Adapter);
               }else if(position == 3){
                   filter2List=getResources().getStringArray(R.array.filter_os);
                   final ArrayAdapter<String> filter2Adapter=new ArrayAdapter<String>(FilterLaptop.this,android.R.layout.simple_list_item_multiple_choice,android.R.id.text1,filter2List);
                   filter2.setAdapter(filter2Adapter);
               }else if(position == 4){
                   filter2List=getResources().getStringArray(R.array.filter_ram);
                   final ArrayAdapter<String> filter2Adapter=new ArrayAdapter<String>(FilterLaptop.this,android.R.layout.simple_list_item_multiple_choice,android.R.id.text1,filter2List);
                   filter2.setAdapter(filter2Adapter);
               }else if(position == 5){

               }else if(position == 6){
                   filter2List=getResources().getStringArray(R.array.filter_graphics_memory);
                   final ArrayAdapter<String> filter2Adapter=new ArrayAdapter<String>(FilterLaptop.this,android.R.layout.simple_list_item_multiple_choice,android.R.id.text1,filter2List);
                   filter2.setAdapter(filter2Adapter);
               }else if(position == 7){
                   filter2List=getResources().getStringArray(R.array.filter_hdd);
                   final ArrayAdapter<String> filter2Adapter=new ArrayAdapter<String>(FilterLaptop.this,android.R.layout.simple_list_item_multiple_choice,android.R.id.text1,filter2List);
                   filter2.setAdapter(filter2Adapter);
               }else if(position == 8){
                   filter2List=getResources().getStringArray(R.array.filter_ssd);
                   final ArrayAdapter<String> filter2Adapter=new ArrayAdapter<String>(FilterLaptop.this,android.R.layout.simple_list_item_multiple_choice,android.R.id.text1,filter2List);
                   filter2.setAdapter(filter2Adapter);

               }else if(position == 9) {
                   filter2List = getResources().getStringArray(R.array.filter_touch_scrren);
                   final ArrayAdapter<String> filter2Adapter = new ArrayAdapter<String>(FilterLaptop.this, android.R.layout.simple_list_item_single_choice, android.R.id.text1, filter2List);
                   filter2.setAdapter(filter2Adapter);
               }

            }
        });
        apply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(FilterLaptop.this,showlaptop.class);
                Bundle bundle=new Bundle();
                bundle.putParcelableArrayList("allLaptopList",allLaptopList);
                i.putExtras(bundle);
                startActivity(i);
            }
        });
    }
    private void loadLaptop() {
                StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_PRODUCTS,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(final String response) {
                                try {
                                    JSONArray array = new JSONArray(response);
                                    for (int i = 0; i < array.length(); i++) {
                                        JSONObject laptop = array.getJSONObject(i);
                                        laptopList.add(new Laptop(
                                                laptop.getString("sid"),
                                                laptop.getString("datetime"),
                                                laptop.getString("laptop_title"),
                                                laptop.getString("laptop_brand"),
                                                laptop.getString("laptop_shortdesc"),
                                                laptop.getString("laptop_price"),
                                                laptop.getString("image_1")
                                        ));
                                    }
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Toast.makeText(FilterLaptop.this,"Error is "+error,Toast.LENGTH_LONG).show();
                            }
                        });
                Volley.newRequestQueue(FilterLaptop.this).add(stringRequest);
            }
            void Filterlist(String string){

                ArrayList<Laptop> filteredList = new ArrayList<>();
                for (Laptop allLaptop : laptopList) {
                    if (allLaptop.getLaptop_title().toLowerCase().contains(string)) {
                        filteredList.add(allLaptop);
                    }
                }
                allLaptopList.addAll(filteredList);
            }
}