package net.in.lapshop.seller.managelaptop;

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

import net.in.lapshop.seller.R;
import net.in.lapshop.seller.showlaptopdetails.ShowLaptopDetails;

import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by Nikunj Ramani on 04/09/18.
 */

public class manageLaptopAdapter extends RecyclerView.Adapter<manageLaptopAdapter.ManageLaptopViewHolder> {
    private List<ManageLaptop> laptopList;
    private Context ctx;
    private String s;
    public manageLaptopAdapter(List<ManageLaptop> laptopList, Context ctx) {
        this.laptopList = laptopList;
        this.ctx = ctx;
    }

    @Override
    public manageLaptopAdapter.ManageLaptopViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(ctx);
        View view=inflater.inflate(R.layout.list_laptop,null,true);
        return new ManageLaptopViewHolder(view);
    }

    @Override
    public void onBindViewHolder(manageLaptopAdapter.ManageLaptopViewHolder holder, int position) {
        final ManageLaptop manageLaptop=laptopList.get(position);
        Glide.with(ctx).load(manageLaptop.getImage()).into(holder.imageView);
        s= String.valueOf(manageLaptop.getSid());
        holder.sid.setText(s);
        holder.title.setText(manageLaptop.getTitle());
        holder.price.setText(manageLaptop.getPrice());
        holder.c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(ctx,ShowLaptopDetails.class);
                i.putExtra("sid",manageLaptop.getSid());
                ctx.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return laptopList.size();
    }

    public class ManageLaptopViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView title,sid,price;
        CardView c1;
        public ManageLaptopViewHolder(View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.imageView);
            title=itemView.findViewById(R.id.title);
            price=itemView.findViewById(R.id.price);
            sid=itemView.findViewById(R.id.sid);
            c1=itemView.findViewById(R.id.c1);
        }
    }
}
