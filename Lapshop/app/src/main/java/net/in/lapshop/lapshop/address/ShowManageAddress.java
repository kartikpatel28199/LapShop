package net.in.lapshop.lapshop.address;

/**
 * Created by Nikunj Ramani on 03/14/18.
 */

public class ShowManageAddress {
    int maid;
    String city,locality,faltno,pincode,state,lendmark,name,mobileno,alternativemobileno,addresstype;

    public ShowManageAddress(int maid, String city, String locality, String faltno, String pincode, String state, String lendmark, String name, String mobileno, String alternativemobileno, String addresstype) {
        this.maid = maid;
        this.city = city;
        this.locality = locality;
        this.faltno = faltno;
        this.pincode = pincode;
        this.state = state;
        this.lendmark = lendmark;
        this.name = name;
        this.mobileno = mobileno;
        this.alternativemobileno = alternativemobileno;
        this.addresstype = addresstype;
    }

    public int getId() {
        return maid;
    }

    public void setId(int maid) {
        this.maid = maid;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getFaltno() {
        return faltno;
    }

    public void setFaltno(String faltno) {
        this.faltno = faltno;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getLendmark() {
        return lendmark;
    }

    public void setLendmark(String lendmark) {
        this.lendmark = lendmark;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobileno() {
        return mobileno;
    }

    public void setMobileno(String mobileno) {
        this.mobileno = mobileno;
    }

    public String getAlternativemobileno() {
        return alternativemobileno;
    }

    public void setAlternativemobileno(String alternativemobileno) {
        this.alternativemobileno = alternativemobileno;
    }

    public String getAddresstype() {
        return addresstype;
    }

    public void setAddresstype(String addresstype) {
        this.addresstype = addresstype;
    }
}
