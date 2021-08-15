package net.in.lapshop.lapshop.showlaptop;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import net.in.lapshop.lapshop.R;
import net.in.lapshop.lapshop.SpecificLaptop.DisplaySpecificLaptop;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nikunj Ramani on 03/13/18.
 */
public class LaptopAdapter extends RecyclerView.Adapter<LaptopAdapter.LaptopViewHolder> {


    private Context mCtx;
    private List<Laptop> mLaptop;
    private List<Laptop> laptopList;
    public LaptopAdapter(Context mCtx, List<Laptop> laptopList) {
        this.mCtx = mCtx;
        this.mLaptop=laptopList;
        this.laptopList = laptopList;
    }

    @Override
    public LaptopViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.listlaptop,null,true);
        return new LaptopViewHolder(view,mCtx,laptopList);
    }


    @Override
    public void onBindViewHolder(LaptopViewHolder holder,int position) {
        final Laptop laptop = laptopList.get(position);
        //loading the image
        Glide.with(mCtx)
                .load(laptop.getImage_1())
                .into(holder.imageView);

        holder.textViewTitle.setText(laptop.getLaptop_title());
        holder.textViewBrand.setText(laptop.getLaptop_brand());
        holder.textViewShortDesc.setText(laptop.getLaptop_shortdesc());
        holder.textViewPrice.setText(laptop.getLaptop_price());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(mCtx,DisplaySpecificLaptop.class);
                i.putExtra("id",laptop.getId());
                mCtx.startActivity(i);
            }
        });
    }
    public Filter getFilter(){
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                String charString = constraint.toString();
                if (charString.isEmpty()) {

                    laptopList = mLaptop;
                } else {

                    List<Laptop> filteredList = new ArrayList<>();

                    for (Laptop allLaptop : mLaptop) {

                        if (allLaptop.getLaptop_title().toLowerCase().contains(charString)) {

                            filteredList.add(allLaptop);
                        }
                    }

                    laptopList = filteredList;
                }
                FilterResults filterResults = new FilterResults();
                filterResults.values = laptopList;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                notifyDataSetChanged();
            }
        };
    }

    @Override
    public int getItemCount() {
        return laptopList.size();
    }

    class LaptopViewHolder extends RecyclerView.ViewHolder {

        TextView textViewTitle,textViewBrand, textViewShortDesc, textViewPrice;
        ImageView imageView;
        Context ctx;
        public CardView cardView;
        List<Laptop> laptops=new ArrayList<Laptop>();
        public LaptopViewHolder(View itemView, final Context ctx, List<Laptop> laptop) {
            super(itemView);
            this.ctx=ctx;
            this.laptops=laptop;
            cardView=(CardView)itemView.findViewById(R.id.cardView);
            textViewTitle = (TextView)itemView.findViewById(R.id.textViewTitle);
            textViewBrand = itemView.findViewById(R.id.textViewBrand);
            textViewShortDesc = itemView.findViewById(R.id.textViewShortDesc);
            textViewPrice = (TextView)itemView.findViewById(R.id.textViewPrice);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }
}