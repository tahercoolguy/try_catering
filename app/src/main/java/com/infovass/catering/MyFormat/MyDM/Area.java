package com.infovass.catering.MyFormat.MyDM;

public class Area {
    public String id;
    public String caterer_id;
    public String area_id;
    public Object delivery_charge;
    public String catering_charge;
    public String created_at;
    public String updated_at;

    public Area(String id, String caterer_id, String area_id, Object delivery_charge, String catering_charge, String created_at, String updated_at) {
        this.id = id;
        this.caterer_id = caterer_id;
        this.area_id = area_id;
        this.delivery_charge = delivery_charge;
        this.catering_charge = catering_charge;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCaterer_id() {
        return caterer_id;
    }

    public void setCaterer_id(String caterer_id) {
        this.caterer_id = caterer_id;
    }

    public String getArea_id() {
        return area_id;
    }

    public void setArea_id(String area_id) {
        this.area_id = area_id;
    }

    public Object getDelivery_charge() {
        return delivery_charge;
    }

    public void setDelivery_charge(Object delivery_charge) {
        this.delivery_charge = delivery_charge;
    }

    public String getCatering_charge() {
        return catering_charge;
    }

    public void setCatering_charge(String catering_charge) {
        this.catering_charge = catering_charge;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }
}
