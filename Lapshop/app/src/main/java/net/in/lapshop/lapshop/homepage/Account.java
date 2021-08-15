package net.in.lapshop.lapshop.homepage;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import net.in.lapshop.lapshop.R;
import net.in.lapshop.lapshop.account.EditMyAccount;
import net.in.lapshop.lapshop.address.ManageAddress;
import net.in.lapshop.lapshop.link;
import net.in.lapshop.lapshop.login.Login;
import net.in.lapshop.lapshop.login.SharedPreferenceConfig;
import net.in.lapshop.lapshop.mywalletandcard.MyWalletAndCard;
import net.in.lapshop.lapshop.vieworder.view_order;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class Account extends Fragment {

    private String URL= link.url+"/Lapshop/profile_update/update_customer_profile.php?email="+ SharedPreferenceConfig.getemail2();
    SharedPreferenceConfig sharedPreferenceConfig;
    private CardView editaccount;
    View rootView;
    private TextView addNewAddress;
    private TextView myWalletAndCard,Notification,textView_name,textView_email,view_order1,logout,myProfile;
    private ImageView imageView_user;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView=inflater.inflate(R.layout.fragment_account, container, false);
        editaccount=rootView.findViewById(R.id.editAccount_homepage);
        editaccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(),EditMyAccount.class));
            }
        });
        view_order1=rootView.findViewById(R.id.view_order);
        view_order1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(),view_order.class));
            }
        });
        myWalletAndCard=rootView.findViewById(R.id.textView_myWalletAndCard);
        myWalletAndCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), MyWalletAndCard.class));
            }
        });
        addNewAddress=rootView.findViewById(R.id.textView_ManageAddress);
        addNewAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), ManageAddress.class));
            }
        });

        Notification=rootView.findViewById(R.id.textView_Notification);
        Notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), net.in.lapshop.lapshop.notification.Notification.class));
            }
        });
        logout=rootView.findViewById(R.id.logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sharedPreferenceConfig.WriteLoginStatus(false);
                startActivity(new Intent(getContext(),Login.class));
                getActivity().finish();
            }
        });
        myProfile=rootView.findViewById(R.id.myProfile);
        myProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(),EditMyAccount.class));
            }
        });
        textView_email=rootView.findViewById(R.id.textView_email);
        textView_name=rootView.findViewById(R.id.textView_name);
        imageView_user=rootView.findViewById(R.id.imageView_user);
        loadProfileData();
        return rootView;
    }

    private void loadProfileData() {

        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray array = new JSONArray(response);
                            for (int i = 0; i < array.length(); i++) {
                                JSONObject laptop = array.getJSONObject(i);
                                textView_name.setText(laptop.getString("firstname")+" "+laptop.getString("lastname"));
                                textView_email.setText(laptop.getString("email"));
                                if (laptop.getString("gender").toLowerCase().equals("male")){
                                    imageView_user.setImageResource(R.drawable.homepage_account_maleprofile);
                                }else if(laptop.getString("gender").toLowerCase().equals("female")){
                                    imageView_user.setImageResource(R.drawable.homepage_account_femaleprofile);
                                }else {
                                    imageView_user.setImageResource(R.drawable.homepage_account_maleprofile);
                                }
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
