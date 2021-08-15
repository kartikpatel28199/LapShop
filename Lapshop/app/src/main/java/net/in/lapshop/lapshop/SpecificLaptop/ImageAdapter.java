package net.in.lapshop.lapshop.SpecificLaptop;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by Nikunj Ramani on 03/13/18.
 */
class ImageAdapter extends BaseAdapter {

    private List<String> image;
    private Context ctx;

    public ImageAdapter(List<String> image, Context ctx) {
        this.image = image;
        this.ctx = ctx;
    }

    @Override
    public int getCount() {
        return image.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView = new ImageView(ctx);
        Glide.with(ctx).load(image.get(position)).into(imageView);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setLayoutParams(new Gallery.LayoutParams(1040, 800));
        return imageView;
    }
}
