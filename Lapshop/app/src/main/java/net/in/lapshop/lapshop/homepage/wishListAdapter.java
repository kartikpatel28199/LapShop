package net.in.lapshop.lapshop.homepage;

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
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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

import java.util.List;

/**
 * Created by Nikunj Ramani on 03/14/18.
 */

public class wishListAdapter extends RecyclerView.Adapter<wishListAdapter.wishListViewHolder>{
    private Context ctx;
    private List<getWishList> wishListList;

    public wishListAdapter(Context ctx, List<getWishList> wishListList) {
        this.ctx = ctx;
        this.wishListList = wishListList;
    }

    @Override
    public wishListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(ctx);
        View view = inflater.inflate(R.layout.my_wishlist,null);
        return new wishListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(wishListViewHolder holder, int position) {
        final getWishList getwishList = wishListList.get(position);
        Glide.with(ctx).load(getwishList.getImage_1()).into(holder.imageView);
        holder.laptop_title.setText(getwishList.getLaptop_title());
        holder.laptop_brand.setText(getwishList.getLaptop_brand());
        holder.screen_size.setText(getwishList.getScreen_size());
        holder.laptop_price.setText(getwishList.getLaptop_price());
        holder.color.setText(getwishList.getLaptop_color());
        holder.remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ctx);

                builder.setTitle("Remove Laptop From Wishlist");
                builder.setMessage("Are you sure you want to delete this laptop?");

                builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {

                        int id;
                        id=getwishList.getId();
                        RequestQueue queue = Volley.newRequestQueue(ctx);
                        final String url = link.url+ "/Lapshop/WishList/laptop_removelaptop.php?id="+id;
                        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                if (response.equals("1")){
                                    Toast.makeText(ctx,"Item Is Removed From WishList",Toast.LENGTH_SHORT).show();
                                }else{
                                    Toast.makeText(ctx,"Item Is Not Removed From WishList",Toast.LENGTH_SHORT).show();
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
                i.putExtra("id",String.valueOf(getwishList.getSid()));
                ctx.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {return wishListList.size();}

    class wishListViewHolder extends RecyclerView.ViewHolder{

        private CardView cardView;
        private TextView laptop_title,laptop_brand,laptop_price,color,screen_size;
        private ImageView imageView,remove;
        public wishListViewHolder(View itemView) {
            super(itemView);
            laptop_title=itemView.findViewById(R.id.laptop_title_wishlist);
            laptop_brand=itemView.findViewById(R.id.laptop_brand_wishlist);
            laptop_price=itemView.findViewById(R.id.laptop_price_wishlist);
            color=itemView.findViewById(R.id.color_wishlist);
            screen_size=itemView.findViewById(R.id.screensize_wishlist);
            imageView=itemView.findViewById(R.id.imageViewWishList);
            remove=itemView.findViewById(R.id.remove);
            cardView=itemView.findViewById(R.id.cardView_wishlist);
        }
    }
}