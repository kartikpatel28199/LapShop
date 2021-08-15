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

public class bestLaptopAdapter extends RecyclerView.Adapter<bestLaptopAdapter.bestLaptopViewHolder> {
    Context ctx;
    List<showBestLaptop> laptopList;

    public bestLaptopAdapter(Context ctx, List<showBestLaptop> laptopList) {
        this.ctx = ctx;
        this.laptopList = laptopList;
    }

    @Override
    public bestLaptopAdapter.bestLaptopViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(ctx);
        View view=inflater.inflate(R.layout.listlaptop_homepage,null,true);
        return new bestLaptopViewHolder(view);
    }

    @Override
    public void onBindViewHolder(bestLaptopAdapter.bestLaptopViewHolder holder, int position) {
        final showBestLaptop showBestLaptop=laptopList.get(position);
        Glide.with(ctx).load(showBestLaptop.getImage_1()).into(holder.image);
        holder.brand.setText(showBestLaptop.getLaptop_brand());
        holder.price.setText(showBestLaptop.getLaptop_price());
        String s=showBestLaptop.getLaptop_modelname()+" "+showBestLaptop.getLaptop_modelno();
        holder.details.setText(s);
        holder.c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(ctx, DisplaySpecificLaptop.class);
                String id=showBestLaptop.getId();
                i.putExtra("id",id);
                ctx.startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return laptopList.size();
    }
    class bestLaptopViewHolder extends RecyclerView.ViewHolder{
        ImageView image;
        TextView brand,details,price;
        CardView c1;
        public bestLaptopViewHolder(View itemView) {
            super(itemView);
            image=itemView.findViewById(R.id.imageView_homepage);
            brand=itemView.findViewById(R.id.brand_homepage);
            details=itemView.findViewById(R.id.showDetails_homepage);
            price=itemView.findViewById(R.id.price_homepage);
            c1=itemView.findViewById(R.id.c1);

        }
    }
}
