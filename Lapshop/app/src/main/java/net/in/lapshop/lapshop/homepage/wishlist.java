package net.in.lapshop.lapshop.homepage;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.Request;
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

import java.util.ArrayList;
import java.util.List;


public class wishlist extends Fragment {
    View rootView;
    private String URL_PRODUCTS = link.url+"/Lapshop/WishList/laptop_show_wishlist.php?email="+ SharedPreferenceConfig.getemail2();
    RecyclerView recyclerViewWishList;
    List<getWishList> wishListList;
    wishListAdapter adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView=inflater.inflate(R.layout.fragment_wishlist, container, false);
        recyclerViewWishList=rootView.findViewById(R.id.recyclerViewWishList);
        recyclerViewWishList.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerViewWishList.setLayoutManager(llm);
        wishListList = new ArrayList<>();
        showWishListData();
        return rootView;
    }

    private void showWishListData() {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_PRODUCTS,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray array = new JSONArray(response);
                            for (int i = 0; i < array.length(); i++) {
                                JSONObject laptop = array.getJSONObject(i);
                                wishListList.add(new getWishList(
                                        laptop.getInt("id"),
                                        laptop.getString("sid"),
                                        laptop.getString("email"),
                                        laptop.getString("laptop_title"),
                                        laptop.getString("laptop_brand"),
                                        laptop.getString("screen_size"),
                                        laptop.getString("color"),
                                        laptop.getString("laptop_price"),
                                        laptop.getString("image_1")
                                ));
                            }
                            adapter = new wishListAdapter(getActivity(),wishListList);
                            recyclerViewWishList.setAdapter(adapter);
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
