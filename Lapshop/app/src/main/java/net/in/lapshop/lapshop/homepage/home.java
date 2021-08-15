package net.in.lapshop.lapshop.homepage;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import net.in.lapshop.lapshop.R;
import net.in.lapshop.lapshop.link;
import net.in.lapshop.lapshop.searchpage.searchpage;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class home extends Fragment {
    ImageView search;
    private RecyclerView newLaptop,bestLaptop;
    private List<showNewLaptop> newLaptopList;
    private List<showBestLaptop> bestLaptopList;
    private newLaptopAdapter adapter;
    private bestLaptopAdapter adapter1;
    private String URL_PRODUCTS = link.url+"/Lapshop/retrive_data_for_searchpage.php";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                              Bundle savedInstanceState) {
         View rootView=inflater.inflate(R.layout.fragment_home, container,false);
//         search=rootView.findViewById(R.id.searchview_homepage);
//         search.setOnClickListener(new View.OnClickListener() {
//             @Override
//             public void onClick(View v) {
//                 startActivity(new Intent(getContext(),searchpage.class));
//             }
//         });
        newLaptop=rootView.findViewById(R.id.recyclerView_newLaptop);
        bestLaptop=rootView.findViewById(R.id.recyclerView_bestLaptop);

        loadNewLaptop();
        loadBestLaptop();
        return rootView;
    }

    private void loadBestLaptop() {
        RecyclerView.LayoutManager layoutManager=new GridLayoutManager(getContext(),1,GridLayoutManager.HORIZONTAL,false);
        bestLaptop.setHasFixedSize(true);
        bestLaptop.setLayoutManager(layoutManager);
        bestLaptopList= new ArrayList<>();
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_PRODUCTS,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray array = new JSONArray(response);
                            for (int i = 0; i < array.length(); i++) {
                                JSONObject laptop = array.getJSONObject(i);
                                bestLaptopList.add(new showBestLaptop(
                                        laptop.getString("sid"),
                                        laptop.getString("laptop_brand"),
                                        laptop.getString("laptop_price"),
                                        laptop.getString("datetime"),
                                        laptop.getString("laptop_modelname"),
                                        laptop.getString("laptop_modelno"),
                                        laptop.getString("image_1")
                                ));
                            }
                            Collections.sort(bestLaptopList, new Comparator<showBestLaptop>() {
                                @Override
                                public int compare(showBestLaptop o1, showBestLaptop o2) {
                                    return Integer.valueOf(o2.getLaptop_price()).compareTo(Integer.valueOf(o1.getLaptop_price()));
                                }
                            });
                            adapter1 = new bestLaptopAdapter(getContext(),bestLaptopList);
                            bestLaptop.setAdapter(adapter1);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getContext(),"Error is "+error,Toast.LENGTH_LONG).show();
                    }
                });
        Volley.newRequestQueue(getContext()).add(stringRequest);

    }

    private void loadNewLaptop() {

        RecyclerView.LayoutManager layoutManager=new GridLayoutManager(getContext(),1,GridLayoutManager.HORIZONTAL,false);
        newLaptop.setHasFixedSize(true);
        newLaptop.setLayoutManager(layoutManager);
        newLaptopList= new ArrayList<showNewLaptop>();
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_PRODUCTS,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray array = new JSONArray(response);
                            for (int i = 0; i < array.length(); i++) {
                                JSONObject laptop = array.getJSONObject(i);
                                newLaptopList.add(new showNewLaptop(
                                        laptop.getString("sid"),
                                        laptop.getString("laptop_brand"),
                                        laptop.getString("laptop_price"),
                                        laptop.getString("datetime"),
                                        laptop.getString("laptop_modelname"),
                                        laptop.getString("laptop_modelno"),
                                        laptop.getString("image_1")
                                ));
                            }
                            Collections.sort(newLaptopList, new Comparator<showNewLaptop>() {
                                @Override
                                public int compare(showNewLaptop o1, showNewLaptop o2) {
                                    return o1.getDatetime().compareToIgnoreCase(o2.getDatetime());
                                }
                            });
                            adapter = new newLaptopAdapter(getContext(),newLaptopList);
                            newLaptop.setAdapter(adapter);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getContext(),"Error is "+error,Toast.LENGTH_LONG).show();
                    }
                });
        Volley.newRequestQueue(getContext()).add(stringRequest);
    }

}