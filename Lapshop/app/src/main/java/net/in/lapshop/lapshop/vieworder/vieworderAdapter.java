package net.in.lapshop.lapshop.vieworder;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import net.in.lapshop.lapshop.R;

import java.util.List;

public class vieworderAdapter extends RecyclerView.Adapter<vieworderAdapter.viewOrderViewHolder> {
    private List<viewOrder> orderList;
    private Context ctx;

    public vieworderAdapter(List<viewOrder> orderList, Context ctx) {
        this.orderList = orderList;
        this.ctx = ctx;
    }

    @Override
    public vieworderAdapter.viewOrderViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(ctx);
        View view=inflater.inflate(R.layout.show_order,null,true);
        return new viewOrderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(vieworderAdapter.viewOrderViewHolder holder, int position) {
        viewOrder v=orderList.get(position);
        holder.title.setText(v.getTitle());
        holder.price.setText(v.getPrice());
        holder.payment.setText(v.getPaymentmethod());
        holder.tracking.setText(v.getTracking());
        Glide.with(ctx).load(v.getImage()).into(holder.image);
        holder.c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return orderList.size();
    }
    class viewOrderViewHolder extends RecyclerView.ViewHolder{
        CardView c1;
        TextView title,price,payment,tracking;
        ImageView image;
        public viewOrderViewHolder(View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.title);
            price=itemView.findViewById(R.id.price);
            image=itemView.findViewById(R.id.image);
            tracking=itemView.findViewById(R.id.tracking);
            payment=itemView.findViewById(R.id.payment_method);
            c1=itemView.findViewById(R.id.c1);
        }
    }
}
