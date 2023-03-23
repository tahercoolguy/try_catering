package com.infovass.catering.DM.Order_DetailsDM;

import java.util.ArrayList;

public class OrderIteam {
    public String id ;
    public String order_id ;
    public String item_id ;
    public String addon_category_item_id ;
    public String quantity ;
    public String special_instruction ;
    public String mrp ;
    public String dis_price ;
    public String sell_price ;
    public String flat_charges ;
    public String total_price ;
    public String deleted_at ;
    public String created_at ;
    public String updated_at ;
    public ArrayList<Object> orderAddons ;
    public String item_price ;
    public Iteam iteam ;
    public ArrayList<Object> meal_iteam ;

    public OrderIteam(String id, String order_id, String item_id, String addon_category_item_id, String quantity, String special_instruction, String mrp, String dis_price, String sell_price, String flat_charges, String total_price, String deleted_at, String created_at, String updated_at, ArrayList<Object> orderAddons, String item_price, Iteam iteam, ArrayList<Object> meal_iteam) {
        this.id = id;
        this.order_id = order_id;
        this.item_id = item_id;
        this.addon_category_item_id = addon_category_item_id;
        this.quantity = quantity;
        this.special_instruction = special_instruction;
        this.mrp = mrp;
        this.dis_price = dis_price;
        this.sell_price = sell_price;
        this.flat_charges = flat_charges;
        this.total_price = total_price;
        this.deleted_at = deleted_at;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.orderAddons = orderAddons;
        this.item_price = item_price;
        this.iteam = iteam;
        this.meal_iteam = meal_iteam;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public String getItem_id() {
        return item_id;
    }

    public void setItem_id(String item_id) {
        this.item_id = item_id;
    }

    public String getAddon_category_item_id() {
        return addon_category_item_id;
    }

    public void setAddon_category_item_id(String addon_category_item_id) {
        this.addon_category_item_id = addon_category_item_id;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getSpecial_instruction() {
        return special_instruction;
    }

    public void setSpecial_instruction(String special_instruction) {
        this.special_instruction = special_instruction;
    }

    public String getMrp() {
        return mrp;
    }

    public void setMrp(String mrp) {
        this.mrp = mrp;
    }

    public String getDis_price() {
        return dis_price;
    }

    public void setDis_price(String dis_price) {
        this.dis_price = dis_price;
    }

    public String getSell_price() {
        return sell_price;
    }

    public void setSell_price(String sell_price) {
        this.sell_price = sell_price;
    }

    public String getFlat_charges() {
        return flat_charges;
    }

    public void setFlat_charges(String flat_charges) {
        this.flat_charges = flat_charges;
    }

    public String getTotal_price() {
        return total_price;
    }

    public void setTotal_price(String total_price) {
        this.total_price = total_price;
    }

    public String getDeleted_at() {
        return deleted_at;
    }

    public void setDeleted_at(String deleted_at) {
        this.deleted_at = deleted_at;
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

    public ArrayList<Object> getOrderAddons() {
        return orderAddons;
    }

    public void setOrderAddons(ArrayList<Object> orderAddons) {
        this.orderAddons = orderAddons;
    }

    public String getItem_price() {
        return item_price;
    }

    public void setItem_price(String item_price) {
        this.item_price = item_price;
    }

    public Iteam getIteam() {
        return iteam;
    }

    public void setIteam(Iteam iteam) {
        this.iteam = iteam;
    }

    public ArrayList<Object> getMeal_iteam() {
        return meal_iteam;
    }

    public void setMeal_iteam(ArrayList<Object> meal_iteam) {
        this.meal_iteam = meal_iteam;
    }
}
