package net.in.lapshop.lapshop.order;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import net.in.lapshop.lapshop.R;

import java.util.List;

public class orderAdapter extends RecyclerView.Adapter<orderAdapter.orderViewHolder> {
    private List<showOrder> orderList;
    private Context ctx;

    public orderAdapter(List<showOrder> orderList, Context ctx) {
        this.orderList = orderList;
        this.ctx = ctx;
    }

    @Override
    public orderAdapter.orderViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(ctx);
        View view = inflater.inflate(R.layout.list_order,null,true);
        return new orderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(orderAdapter.orderViewHolder holder, int position) {
        showOrder s=orderList.get(position);
        holder.title.setText(s.getTitle());
        holder.details.setText(s.details);
        holder.sellernme.setText(s.seller_name);
        holder.price.setText(s.getPrice());
        Glide.with(ctx).load(s.getImage_1()).into(holder.image);
    }

    @Override
    public int getItemCount() {
        return orderList.size();
    }
    class orderViewHolder extends RecyclerView.ViewHolder{
        TextView title,details,sellernme,price,price1;
        Spinner spiner;
        ImageView image;
        public orderViewHolder(View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.title);
            details=itemView.findViewById(R.id.details);
            sellernme=itemView.findViewById(R.id.sellername);
            price=itemView.findViewById(R.id.price);
            spiner=itemView.findViewById(R.id.spiner);
            image=itemView.findViewById(R.id.image);
            price1=itemView.findViewById(R.id.price1);
        }
    }
}
