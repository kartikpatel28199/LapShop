package net.in.lapshop.lapshop.homepage;

/**
 * Created by Nikunj Ramani on 03/14/18.
 */

public class getWishList {
    int id;
    String laptop_title,laptop_brand,laptop_color,screen_size,sid,laptop_price,email,image_1;

    public getWishList(int id,String sid, String email,String laptop_title, String laptop_brand, String laptop_color, String screen_size, String laptop_price,String image_1) {
        this.id = id;
        this.sid=sid;
        this.email=email;
        this.laptop_title = laptop_title;
        this.laptop_brand = laptop_brand;
        this.laptop_color = laptop_color;
        this.screen_size = screen_size;
        this.laptop_price = laptop_price;
        this.image_1=image_1;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImage_1() {
        return image_1;
    }

    public void setImage_1(String image_1) {
        this.image_1 = image_1;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLaptop_title() {
        return laptop_title;
    }

    public void setLaptop_title(String laptop_title) {
        this.laptop_title = laptop_title;
    }

    public String getLaptop_brand() {
        return laptop_brand;
    }

    public void setLaptop_brand(String laptop_brand) {
        this.laptop_brand = laptop_brand;
    }

    public String getLaptop_color() {
        return laptop_color;
    }

    public void setLaptop_color(String laptop_color) {
        this.laptop_color = laptop_color;
    }

    public String getScreen_size() {
        return screen_size;
    }

    public void setScreen_size(String screen_size) {
        this.screen_size = screen_size;
    }

    public String getLaptop_price() {
        return laptop_price;
    }

    public void setLaptop_price(String laptop_price) {
        this.laptop_price = laptop_price;
    }
}
