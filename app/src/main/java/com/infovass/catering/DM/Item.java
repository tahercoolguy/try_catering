package com.infovass.catering.DM;

import java.util.ArrayList;

public class Item {

    private String id;
    private String userId;
    private String catererId;
    private String itemId;
    private String cost;
    private String quantity;
    private String femaleService;
    private String specialRequest;
    private String createdAt;
    private String updatedAt;
    private String modeId;
    private String addonTotal;
    private String totalCost;
    private Iteam iteam;
    private Caterer caterer;
    private ArrayList<Object> addonIteam = new ArrayList<Object>();
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public String getCatererId() {
        return catererId;
    }
    public void setCatererId(String catererId) {
        this.catererId = catererId;
    }
    public String getItemId() {
        return itemId;
    }
    public void setItemId(String itemId) {
        this.itemId = itemId;
    }
    public String getCost() {
        return cost;
    }
    public void setCost(String cost) {
        this.cost = cost;
    }
    public String getQuantity() {
        return quantity;
    }
    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
    public String getFemaleService() {
        return femaleService;
    }
    public void setFemaleService(String femaleService) {
        this.femaleService = femaleService;
    }
    public String getSpecialRequest() {
        return specialRequest;
    }
    public void setSpecialRequest(String specialRequest) {
        this.specialRequest = specialRequest;
    }
    public String getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
    public String getUpdatedAt() {
        return updatedAt;
    }
    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }
    public String getModeId() {
        return modeId;
    }
    public void setModeId(String modeId) {
        this.modeId = modeId;
    }
    public String getAddonTotal() {
        return addonTotal;
    }
    public void setAddonTotal(String addonTotal) {
        this.addonTotal = addonTotal;
    }
    public String getTotalCost() {
        return totalCost;
    }
    public void setTotalCost(String totalCost) {
        this.totalCost = totalCost;
    }
    public Iteam getIteam() {
        return iteam;
    }
    public void setIteam(Iteam iteam) {
        this.iteam = iteam;
    }
    public Caterer getCaterer() {
        return caterer;
    }
    public void setCaterer(Caterer caterer) {
        this.caterer = caterer;
    }
    public ArrayList<Object> getAddonIteam() {
        return addonIteam;
    }
    public void setAddonIteam(ArrayList<Object> addonIteam) {
        this.addonIteam = addonIteam;
    }
}
