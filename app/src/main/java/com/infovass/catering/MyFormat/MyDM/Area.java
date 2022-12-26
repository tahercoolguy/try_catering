package com.infovass.catering.MyFormat.MyDM;

public class Area {
    private String id;
    private String catererId;
    private String areaId;
    private Object deliveryCharge;
    private String cateringCharge;
    private String createdAt;
    private String updatedAt;
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getCatererId() {
        return catererId;
    }
    public void setCatererId(String catererId) {
        this.catererId = catererId;
    }
    public String getAreaId() {
        return areaId;
    }
    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }
    public Object getDeliveryCharge() {
        return deliveryCharge;
    }
    public void setDeliveryCharge(Object deliveryCharge) {
        this.deliveryCharge = deliveryCharge;
    }
    public String getCateringCharge() {
        return cateringCharge;
    }
    public void setCateringCharge(String cateringCharge) {
        this.cateringCharge = cateringCharge;
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
}
