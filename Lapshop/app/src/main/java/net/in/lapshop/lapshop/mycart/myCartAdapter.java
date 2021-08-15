package net.in.lapshop.lapshop.mycart;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;

import net.in.lapshop.lapshop.R;
import net.in.lapshop.lapshop.SpecificLaptop.DisplaySpecificLaptop;
import net.in.lapshop.lapshop.link;
import net.in.lapshop.lapshop.login.SharedPreferenceConfig;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Nikunj Ramani on 03/13/18.
 */

public class myCartAdapter extends RecyclerView.Adapter<myCartAdapter.myCartHolder> {
    List<MyCart> myCartList;
    Context ctx;
   static int price1=0;

    public myCartAdapter(Context ctx, List<MyCart> myCartList) {
        this.ctx = ctx;
        this.myCartList = myCartList;
    }

    @Override
    public myCartHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(ctx);
        View view = layoutInflater.inflate(R.layout.my_cart_list, null);
        return new myCartHolder(view);
    }

    @Override
    public void onBindViewHolder(myCartHolder holder, int position) {
        final MyCart myCart = myCartList.get(position);
        Glide.with(ctx).load(myCart.getImage_1()).into(holder.imageView);
        holder.laptop_title.setText(myCart.getLaptop_title());
        holder.laptop_brand.setText(myCart.getLaptop_brand());
        holder.screen_size.setText(myCart.getScreen_size());
        holder.laptop_price.setText(myCart.getLaptop_price());

        final String title,price,brand,screen,email,images,color;
        email=String.valueOf(SharedPreferenceConfig.getemail2());
        title=String.valueOf(myCart.getLaptop_title());
        price=String.valueOf(myCart.getLaptop_price());
        brand=String.valueOf(myCart.getLaptop_brand());
        screen=String.valueOf(myCart.getScreen_size());
        color="";
        price1+=Integer.parseInt(myCart.getLaptop_price());

        images=String.valueOf(myCart.getImage_1());
        holder.wishlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RequestQueue queue = Volley.newRequestQueue(ctx);
                final String url = link.url+"/Lapshop/WishList/laptop_insert_wishlist.php";
                StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.e("nnn", response);
                        if (response.equals("1")){
                            Toast.makeText(ctx,"Item Add in Wish List",Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(ctx,"Item Not Add in Wish List",Toast.LENGTH_SHORT).show();
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(ctx, "Fail To Add item" + error, Toast.LENGTH_SHORT).show();
                    }
                }){
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String, String> par = new HashMap<>();
                        par.put("sid",String.valueOf(myCart.getSid()));
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
        holder.remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ctx);

                builder.setTitle("Remove Laptop From MyCart");
                builder.setMessage("Are you sure you want to delete this laptop?");

                builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {

                        final String sid;
                        sid=myCart.getSid();
                        RequestQueue queue = Volley.newRequestQueue(ctx);
                        final String url = link.url+"/Lapshop/Mycart/laptop_removelaptop.php?sid="+sid;
                        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                Log.e("nnn", response);
                                if (response.equals("1")){
                                    Toast.makeText(ctx,"Item Is Removed From MyCart",Toast.LENGTH_SHORT).show();
                                }else{
                                    Toast.makeText(ctx,"Item Is Not Removed From MyCart",Toast.LENGTH_SHORT).show();
                                }
                            }
                        }, new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Toast.makeText(ctx, "Fail To Remove Item" + error, Toast.LENGTH_SHORT).show();
                            }
                        });
                        queue.add(stringRequest);
                        dialog.dismiss();
                    }
                });

                builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        // Do nothing
                        dialog.dismiss();
                    }
                });

                AlertDialog alert = builder.create();
                alert.show();
            }
        });
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(ctx,DisplaySpecificLaptop.class);
                i.putExtra("id",String.valueOf(myCart.getSid()));
                ctx.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return myCartList.size();
    }

    class myCartHolder extends RecyclerView.ViewHolder {
        private CardView cardView;
        private Spinner spinner;
        TextView remove, wishlist;
        private TextView laptop_title, laptop_brand, laptop_price, screen_size;
        private ImageView imageView;
        String[] no={"1","2","3","4","5","6","7","8","9","10"};
        public myCartHolder(View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.cardView);
            laptop_title = itemView.findViewById(R.id.laptop_title);
            laptop_brand = itemView.findViewById(R.id.laptop_brand);
            screen_size = itemView.findViewById(R.id.screen_size);
            laptop_price = itemView.findViewById(R.id.laptop_price);
            imageView = itemView.findViewById(R.id.imageView);
            spinner=itemView.findViewById(R.id.spiner);
            ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(ctx,android.R.layout.simple_spinner_dropdown_item,no);
            spinner.setAdapter(arrayAdapter);
            wishlist=(TextView)itemView.findViewById(R.id.wishlist_myCart);
            remove=itemView.findViewById(R.id.remove_myCart);
            cardView=itemView.findViewById(R.id.cardView_mycart);
        }
    }
}


