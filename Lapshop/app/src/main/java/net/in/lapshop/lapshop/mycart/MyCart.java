package net.in.lapshop.lapshop.mycart;

/**
 * Created by Nikunj Ramani on 03/13/18.
 */

public class MyCart {

        String id;
        String sid,email, laptop_title, laptop_brand, laptop_price, screen_size, image_1;

        public MyCart(String id, String sid,String email, String laptop_title, String laptop_brand, String screen_size,String laptop_price, String image_1) {
            this.id = id;
            this.sid=sid;
            this.email = email;
            this.laptop_title = laptop_title;
            this.laptop_brand = laptop_brand;
            this.screen_size = screen_size;
            this.laptop_price = laptop_price;
            this.image_1 = image_1;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getSid() {
            return sid;
        }

        public void setSid(String sid) {
            this.sid = sid;
        }

        public String getId() {
            return id;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
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

        public String getImage_1() {
            return image_1;
        }

        public void setImage_1(String image_1) {
            this.image_1 = image_1;
        }
}
