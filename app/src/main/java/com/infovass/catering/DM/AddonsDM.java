package com.infovass.catering.DM;

public class AddonsDM {
    private int img;
    private  String tittle;
    private String price;

    public AddonsDM(int img, String tittle, String price) {
        this.img = img;
        this.tittle = tittle;
        this.price = price;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
