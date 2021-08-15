package net.in.lapshop.lapshop.order;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toolbar;

import net.in.lapshop.lapshop.R;
import net.in.lapshop.lapshop.address.ShowManageAddress;
import net.in.lapshop.lapshop.address.addNewAddress;

import java.util.List;

public class showAddressAdapter extends RecyclerView.Adapter<showAddressAdapter.ShowAddressViewHolder> {
   List<ShowManageAddress> addressList;
   Context ctx;
   String sid;

    public showAddressAdapter(List<ShowManageAddress> addressList, Context ctx,String sid) {
        this.addressList = addressList;
        this.ctx = ctx;
        this.sid=sid;
    }

    @Override
    public ShowAddressViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(ctx);
        View view=inflater.inflate(R.layout.manage_address,null,true);
        return new ShowAddressViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ShowAddressViewHolder holder, int position) {
        {
            final ShowManageAddress showManageAddress=addressList.get(position);
            String str=null;
            str=showManageAddress.getFaltno()+","+showManageAddress.getLocality()+","+showManageAddress.getCity() +","+showManageAddress.getState()+","+showManageAddress.getPincode();
            holder.toolbar.setTitle(showManageAddress.getName());
            holder.addresstype.setText(showManageAddress.getAddresstype());
            holder.address.setText(str);
            holder.mobileno.setText(showManageAddress.getMobileno());
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                holder.toolbar.inflateMenu(R.menu.manage_address_menuoption);
                holder.toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        int id = item.getItemId();
                        if (id == R.id.edit_address) {
                            Intent i = new Intent(ctx,addNewAddress.class);
                            i.putExtra("city", showManageAddress.getCity());
                            i.putExtra("locality",showManageAddress.getLocality());
                            i.putExtra("flatno",showManageAddress.getFaltno());
                            i.putExtra("pincode",showManageAddress.getPincode());
                            i.putExtra("state",showManageAddress.getState());
                            i.putExtra("lendmark",showManageAddress.getLendmark());
                            i.putExtra("name",showManageAddress.getName());
                            i.putExtra("mobileno",showManageAddress.getMobileno());
                            i.putExtra("alternativemobileno",showManageAddress.getAlternativemobileno());
                            i.putExtra("addresstype",showManageAddress.getAddresstype());
                            ctx.startActivity(i);
                        } else if (id == R.id.remove) {
                            AlertDialog.Builder builder = new AlertDialog.Builder(ctx);

                            builder.setTitle("Remove Address");
                            builder.setMessage("Are you sure you want to delete this address?");

                            builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {

                                public void onClick(DialogInterface dialog, int which) {
                                    // Do nothing but close the dialog

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
                        return true;
                    }
                });
                holder.c1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i=new Intent(ctx,order_now.class);
                        i.putExtra("sid",sid);
                        i.putExtra("maid",showManageAddress.getId());
                        ctx.startActivity(i);
                    }
                });
            }
        }
    }

    @Override
    public int getItemCount() {
        return addressList.size();
    }

    public class ShowAddressViewHolder extends RecyclerView.ViewHolder {
        Toolbar toolbar;
        CardView c1;
        TextView address,name,mobileno,addresstype;
        public ShowAddressViewHolder(View itemView) {
            super(itemView);
            address=itemView.findViewById(R.id.customer_address);
            name=itemView.findViewById(R.id.customer_name);
            mobileno=itemView.findViewById(R.id.customer_mobileno);
            addresstype=itemView.findViewById(R.id.customer_addresstype);
            toolbar=itemView.findViewById(R.id.manage_address_toolbar);
            c1=itemView.findViewById(R.id.c1);
        }
    }
}
