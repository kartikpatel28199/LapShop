package net.in.lapshop.lapshop.showlaptop;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import net.in.lapshop.lapshop.Filter.FilterLaptop;
import net.in.lapshop.lapshop.R;
import net.in.lapshop.lapshop.link;
import net.in.lapshop.lapshop.mycart.My_Cart;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class showlaptop extends AppCompatActivity {

    private String URL_PRODUCTS = link.url+"/Lapshop/retrive_data_for_searchpage.php";
    private ArrayList<Laptop> laptopList;
    SharedPreferences sharedPreferences;
    private RecyclerView recyclerView;
    private LaptopAdapter adapter;
    private Button sortby,filters;
    private AlertDialog alertDialog;
    private CharSequence[] sortbylist={"Sorted By Brand","Price - Low to High","Price - High to Low","Popularity","Newest First"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        setContentView(R.layout.activity_showlaptop);

        sharedPreferences=getSharedPreferences("SHARED_PREF_NAME",Context.MODE_PRIVATE);

        sortby=findViewById(R.id.showlaptop_sortby);
        filters=findViewById(R.id.showlaptop_filters);
        recyclerView = findViewById(R.id.recyclerView_showlaptop);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager llm=new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(llm);

        //Here Get String[] array to FilterList
        Bundle bundle=getIntent().getExtras();
        ArrayList list= bundle.getParcelableArrayList("allLaptopList");
        if(list==null){
            laptopList = new ArrayList<>();
            loadLaptop();
        }else {
            adapter = new LaptopAdapter(showlaptop.this, list);
            recyclerView.setAdapter(adapter);
        }

        filters.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(showlaptop.this, FilterLaptop.class);
                startActivity(i);
            }
        });
        sortby.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAlertDialogBoxControl();
            }
        });

    }

    private void showAlertDialogBoxControl() {
        final AlertDialog.Builder builder=new AlertDialog.Builder(showlaptop.this);
        builder.setTitle("Select Your Choice");
        builder.setSingleChoiceItems(sortbylist, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch(which){
                    case 0:
                        Collections.sort(laptopList, new Comparator<Laptop>() {
                            @Override
                            public int compare(Laptop o1, Laptop o2) {
                                Laptop p1 = (Laptop) o1;
                                Laptop p2 = (Laptop) o2;
                                return p1.getLaptop_brand().compareToIgnoreCase(p2.getLaptop_brand());
                            }
                        });
                        adapter=new LaptopAdapter(showlaptop.this,laptopList);
                        recyclerView.setAdapter(adapter);
                        break;
                    case 1:
                        Collections.sort(laptopList, new Comparator<Laptop>() {
                            @Override
                            public int compare(Laptop o1, Laptop o2) {
                                return Integer.valueOf(o1.getLaptop_price()).compareTo(Integer.valueOf(o2.getLaptop_price()));
                            }
                        });
                        adapter=new LaptopAdapter(showlaptop.this,laptopList);
                        recyclerView.setAdapter(adapter);
                        break;
                    case 2:
                        Collections.sort(laptopList, new Comparator<Laptop>() {
                            @Override
                            public int compare(Laptop o1, Laptop o2) {
                                return Integer.valueOf(o2.getLaptop_price()).compareTo(Integer.valueOf(o1.getLaptop_price()));
                            }
                        });
                        adapter=new LaptopAdapter(showlaptop.this,laptopList);
                        recyclerView.setAdapter(adapter);
                        break;
                    case 3:

                    case 4:
                        Collections.sort(laptopList, new Comparator<Laptop>() {
                            @Override
                            public int compare(Laptop o1, Laptop o2) {
                                return o2.getDate().compareTo(o1.getDate());
                            }
                        });
                        adapter=new LaptopAdapter(showlaptop.this,laptopList);
                        recyclerView.setAdapter(adapter);
                        break;
                }
                alertDialog.dismiss();
            }
        });
        alertDialog=builder.create();
        alertDialog.show();
    }
    private void loadLaptop() {
        final ProgressDialog progressDialog = ProgressDialog.show(showlaptop.this, "Searching Laptop...", "Please Wait...", true);
        new Thread() {
            @Override
            public void run() {
                super.run();
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
                            progressDialog.dismiss();
                            filterslist();
                            adapter = new LaptopAdapter(showlaptop.this, laptopList);
                            recyclerView.setAdapter(adapter);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(showlaptop.this,"Error is "+error,Toast.LENGTH_LONG).show();
                    }
                });
        Volley.newRequestQueue(showlaptop.this).add(stringRequest);
                    }
                }.start();
    }

    private void filterslist() {
        ArrayList<Laptop> filteredList = new ArrayList<>();
        String charString=getIntent().getStringExtra("laptop_brand");
        for (Laptop allLaptop : laptopList) {

            if (allLaptop.getLaptop_title().toLowerCase().contains(charString)) {

                filteredList.add(allLaptop);
            }
        }

        laptopList = filteredList;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.customer_homepage, menu);

        MenuItem item=menu.findItem(R.id.action_notification);
        item.setVisible(false);
        MenuItem search = menu.findItem(R.id.action_search);
        android.support.v7.widget.SearchView searchView = (android.support.v7.widget.SearchView) MenuItemCompat.getActionView(search);
        search(searchView);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id==R.id.action_cart){
            startActivity(new Intent(showlaptop.this,My_Cart.class));
        }else if(id==android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    private void search(android.support.v7.widget.SearchView searchView) {

        searchView.setOnQueryTextListener(new android.support.v7.widget.SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                if (adapter != null) adapter.getFilter().filter(newText);
                return true;
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
