package net.in.lapshop.lapshop.notification;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import net.in.lapshop.lapshop.R;
import net.in.lapshop.lapshop.homepage.wishListAdapter;

import java.util.List;

/**
 * Created by Nikunj Ramani on 04/08/18.
 */

public class notificationAdapter extends RecyclerView.Adapter<notificationAdapter.notificationViewHolder> {

    List<showNotification> showNotifications;
    Context ctx;

    public notificationAdapter(List<showNotification> showNotifications, Context ctx) {
        this.showNotifications = showNotifications;
        this.ctx = ctx;
    }

    @Override
    public notificationViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(ctx);
        View view = inflater.inflate(R.layout.listnotification,null);
        return new notificationAdapter.notificationViewHolder(view);
    }

    @Override
    public void onBindViewHolder(notificationViewHolder holder, int position) {
        showNotification s=showNotifications.get(position);
       /* if (s.getImage()==null){

        }else {
            Glide.with(ctx).load(s.getImage()).into(holder.image);
        }*/
        holder.title.setText(s.getTitle());
        holder.msg.setText(s.getMessage());
    }

    @Override
    public int getItemCount() {
        return showNotifications.size();
    }

    class notificationViewHolder extends RecyclerView.ViewHolder {

        private TextView title,msg;
        private ImageView image;
        public notificationViewHolder(View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.textView_title);
            msg=itemView.findViewById(R.id.textView_message);
            image=itemView.findViewById(R.id.imageView_notification);
        }
    }
}
