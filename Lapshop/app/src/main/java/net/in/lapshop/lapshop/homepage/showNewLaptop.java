package net.in.lapshop.lapshop.homepage;

/**
 * Created by Nikunj Ramani on 04/10/18.
 */

public class showNewLaptop {
    String id;
    String laptop_brand,laptop_price,datetime,laptop_modelname,laptop_modelno,image_1;

    public showNewLaptop(String id, String laptop_brand, String laptop_price, String datetime, String laptop_modelname, String laptop_modelno, String image_1) {
        this.id = id;
        this.laptop_brand = laptop_brand;
        this.laptop_price = laptop_price;
        this.datetime = datetime;
        this.laptop_modelname = laptop_modelname;
        this.laptop_modelno = laptop_modelno;
        this.image_1 = image_1;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLaptop_brand() {
        return laptop_brand;
    }

    public void setLaptop_brand(String laptop_brand) {
        this.laptop_brand = laptop_brand;
    }

    public String getLaptop_price() {
        return laptop_price;
    }

    public void setLaptop_price(String laptop_price) {
        this.laptop_price = laptop_price;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public String getLaptop_modelname() {
        return laptop_modelname;
    }

    public void setLaptop_modelname(String laptop_modelname) {
        this.laptop_modelname = laptop_modelname;
    }

    public String getLaptop_modelno() {
        return laptop_modelno;
    }

    public void setLaptop_modelno(String laptop_modelno) {
        this.laptop_modelno = laptop_modelno;
    }

    public String getImage_1() {
        return image_1;
    }

    public void setImage_1(String image_1) {
        this.image_1 = image_1;
    }
}
