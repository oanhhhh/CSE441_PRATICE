package com.example.customlistview;

public class Phone {
    private String namephone;
    private int imgphone;
    private String pricephone;

    public Phone(int imgphone, String namephone, String pricephone) {
        this.imgphone = imgphone;
        this.namephone = namephone;
        this.pricephone = pricephone;
    }

    public int getImgphone() {
        return imgphone;
    }

    public void setImgphone(int imgphone) {
        this.imgphone = imgphone;
    }

    public String getNamephone() {
        return namephone;
    }

    public void setNamephone(String namephone) {
        this.namephone = namephone;
    }

    public  String getPricephone(){
        return pricephone;
    }

    public void setPricephone(String pricephone){
        this.pricephone = pricephone;
    }
}
