
package com.example.akash.coupons;


public class Coupon {



    private String name;
     private String url;
     private String purl;

    public Coupon(String name, String url,String purl){
        this.name=name;
        this.url=url;

        this.purl =purl;

    }

    public String getPurl() {
        return purl;
    }

    public void setPurl(String purl) {
        this.purl = purl;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
