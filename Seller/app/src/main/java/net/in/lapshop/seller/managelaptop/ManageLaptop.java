package net.in.lapshop.seller.managelaptop;

/**
 * Created by Nikunj Ramani on 04/09/18.
 */

public class ManageLaptop {
    int sid;
    String title,price,image;

    public ManageLaptop(int sid, String title, String price, String image) {
        this.sid = sid;
        this.title = title;
        this.price = price;
        this.image = image;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
