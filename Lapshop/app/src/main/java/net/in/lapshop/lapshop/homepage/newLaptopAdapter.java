package net.in.lapshop.lapshop.homepage;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import net.in.lapshop.lapshop.R;
import net.in.lapshop.lapshop.SpecificLaptop.DisplaySpecificLaptop;

import java.util.List;

/**
 * Created by Nikunj Ramani on 04/10/18.
 */

public class newLaptopAdapter extends RecyclerView.Adapter<newLaptopAdapter.newLaptopViewHolder> {
    Context ctx;
    List<showNewLaptop> laptopList;

    public newLaptopAdapter(Context ctx, List<showNewLaptop> laptopList) {
        this.ctx = ctx;
        this.laptopList = laptopList;
    }

    @Override
    public newLaptopAdapter.newLaptopViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(ctx);
        View view=inflater.inflate(R.layout.listlaptop_homepage,null,true);
        return new newLaptopViewHolder(view);
    }

    @Override
    public void onBindViewHolder(newLaptopAdapter.newLaptopViewHolder holder, int position) {
        final showNewLaptop showNewLaptop=laptopList.get(position);
        Glide.with(ctx).load(showNewLaptop.getImage_1()).into(holder.image);
        holder.brand.setText(showNewLaptop.getLaptop_brand());
        holder.details.setText(showNewLaptop.getLaptop_price());
        String s=showNewLaptop.getLaptop_modelname()+" "+showNewLaptop.getLaptop_modelno();
        holder.price.setText(s);
        holder.c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(ctx, DisplaySpecificLaptop.class);
                String id=showNewLaptop.getId();
                i.putExtra("id",id);
                ctx.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return laptopList.size();
    }
    class newLaptopViewHolder extends RecyclerView.ViewHolder{
        ImageView image;
        TextView brand,details,price;
        CardView c1;

        public newLaptopViewHolder(View itemView) {
            super(itemView);
            image=itemView.findViewById(R.id.imageView_homepage);
            brand=itemView.findViewById(R.id.brand_homepage);
            details=itemView.findViewById(R.id.showDetails_homepage);
            price=itemView.findViewById(R.id.price_homepage);
            c1=itemView.findViewById(R.id.c1);
        }
    }
}
