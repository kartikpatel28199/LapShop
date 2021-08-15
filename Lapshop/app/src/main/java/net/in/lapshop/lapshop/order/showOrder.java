package net.in.lapshop.lapshop.order;

public class showOrder {
    String title,details,seller_name,price,image_1;

    public showOrder(String title, String details, String seller_name, String price, String image_1) {
        this.title = title;
        this.details = details;
        this.seller_name = seller_name;
        this.price = price;
        this.image_1 = image_1;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getSeller_name() {
        return seller_name;
    }

    public void setSeller_name(String seller_name) {
        this.seller_name = seller_name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getImage_1() {
        return image_1;
    }

    public void setImage_1(String image_1) {
        this.image_1 = image_1;
    }
}
