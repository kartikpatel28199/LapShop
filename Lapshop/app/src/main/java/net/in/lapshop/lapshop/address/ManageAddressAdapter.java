package net.in.lapshop.lapshop.address;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import net.in.lapshop.lapshop.R;
import net.in.lapshop.lapshop.link;

import java.util.List;

/**
 * Created by Nikunj Ramani on 03/14/18.
 */
public class ManageAddressAdapter extends RecyclerView.Adapter<ManageAddressAdapter.AddressViewHolder>{

    private Context ctx;
    private List<ShowManageAddress> addressList;

    public ManageAddressAdapter(Context ctx, List<ShowManageAddress> addressList) {
        this.ctx = ctx;
        this.addressList = addressList;
    }

    @Override
    public AddressViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(ctx);
        View view = inflater.inflate(R.layout.manage_address,null,true);
        return new AddressViewHolder(view,ctx);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onBindViewHolder(AddressViewHolder holder, int position) {
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
                        i.putExtra("maid",showManageAddress.getId());
                        ctx.startActivity(i);
                    } else if (id == R.id.remove) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(ctx);

                        builder.setTitle("Remove Address");
                        builder.setMessage("Are you sure you want to delete this address?");

                        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {

                            public void onClick(DialogInterface dialog, int which) {
                                RequestQueue queue = Volley.newRequestQueue(ctx);
                                final String url = link.url+"/Lapshop/ManageAddress/remove_address.php?maid="+showManageAddress.getId();
                                StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                                    @Override
                                    public void onResponse(String response) {
                                        Log.e("nnn", response);
                                        if (response.equals("1")){
                                            Toast.makeText(ctx,"Address is Removed",Toast.LENGTH_SHORT).show();
                                        }else{
                                            Toast.makeText(ctx,"Address is Not Removed",Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                }, new Response.ErrorListener() {
                                    @Override
                                    public void onErrorResponse(VolleyError error) {
                                        Toast.makeText(ctx, "Fail to Remove Item" + error, Toast.LENGTH_SHORT).show();
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
                    return true;
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return addressList.size();
    }
    class AddressViewHolder extends RecyclerView.ViewHolder{

        Toolbar toolbar;
        TextView address,name,mobileno,addresstype;
        public AddressViewHolder(View itemView, Context ctx) {
            super(itemView);
            address=itemView.findViewById(R.id.customer_address);
            name=itemView.findViewById(R.id.customer_name);
            mobileno=itemView.findViewById(R.id.customer_mobileno);
            addresstype=itemView.findViewById(R.id.customer_addresstype);
            toolbar=itemView.findViewById(R.id.manage_address_toolbar);
        }
    }
}

