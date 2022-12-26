package com.infovass.catering.DM;

import java.util.ArrayList;
import java.util.List;

public class Data {

    private ArrayList<Item> item = new ArrayList<Item>();
    private String totalAmount;
    private String addonTotal;
    private String discountAmount;
    private String serviceCharges;
    private String allTotal;
    public List<Item> getItem() {
        return item;
    }
    public void setItem(ArrayList<Item> item) {
        this.item = item;
    }
    public String getTotalAmount() {
        return totalAmount;
    }
    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }
    public String getAddonTotal() {
        return addonTotal;
    }
    public void setAddonTotal(String addonTotal) {
        this.addonTotal = addonTotal;
    }
    public String getDiscountAmount() {
        return discountAmount;
    }
    public void setDiscountAmount(String discountAmount) {
        this.discountAmount = discountAmount;
    }
    public String getServiceCharges() {
        return serviceCharges;
    }
    public void setServiceCharges(String serviceCharges) {
        this.serviceCharges = serviceCharges;
    }
    public String getAllTotal() {
        return allTotal;
    }
    public void setAllTotal(String allTotal) {
        this.allTotal = allTotal;
    }
}
