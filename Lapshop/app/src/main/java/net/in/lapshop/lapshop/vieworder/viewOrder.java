package net.in.lapshop.lapshop.vieworder;

public class viewOrder {
    int oid;
    String title,price,paymentmethod,tracking,image;

    public viewOrder(int oid, String title, String price, String paymentmethod, String tracking, String image) {
        this.oid = oid;
        this.title = title;
        this.price = price;
        this.paymentmethod = paymentmethod;
        this.tracking = tracking;
        this.image = image;
    }

    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
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

    public String getPaymentmethod() {
        return paymentmethod;
    }

    public void setPaymentmethod(String paymentmethod) {
        this.paymentmethod = paymentmethod;
    }

    public String getTracking() {
        return tracking;
    }

    public void setTracking(String tracking) {
        this.tracking = tracking;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
