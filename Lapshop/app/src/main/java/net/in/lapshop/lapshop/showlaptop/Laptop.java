package net.in.lapshop.lapshop.showlaptop;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Nikunj Ramani on 03/13/18.
 */

public class Laptop implements Parcelable {
    String id;
    String date;
    private String laptop_title,laptop_brand,laptop_shortdesc,laptop_price,image_1;

    public Laptop(String id,String date, String laptop_title, String laptop_brand, String laptop_shortdesc, String laptop_price, String image_1) {
        this.id = id;
        this.date=date;
        this.laptop_title = laptop_title;
        this.laptop_brand = laptop_brand;
        this.laptop_shortdesc = laptop_shortdesc;
        this.laptop_price = laptop_price;
        this.image_1 = image_1;
    }

    public Laptop(Parcel source) {
        id=source.readString();
        laptop_brand=source.readString();
        laptop_price=source.readString();
        laptop_shortdesc=source.readString();
        laptop_title=source.readString();
        image_1=source.readString();
        date=source.readString();
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public String getLaptop_title() {
        return laptop_title;
    }

    public String getLaptop_brand() {
        return laptop_brand;
    }

    public String getLaptop_shortdesc() {
        return laptop_shortdesc;
    }

    public String getLaptop_price() {
        return laptop_price;
    }

    public String getImage_1() {
        return image_1;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(laptop_brand);
        dest.writeString(laptop_price);
        dest.writeString(laptop_shortdesc);
        dest.writeString(laptop_title);
        dest.writeString(image_1);
        dest.writeString(date);
    }
    public static final Parcelable.Creator<Laptop> CREATOR=new Parcelable.Creator<Laptop>(){

        @Override
        public Laptop createFromParcel(Parcel source) {
            return new Laptop(source);
        }

        @Override
        public Laptop[] newArray(int size) {
            return new Laptop[size];
        }
    };
}
