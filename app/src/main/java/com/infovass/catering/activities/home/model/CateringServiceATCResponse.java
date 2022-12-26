package com.infovass.catering.activities.home.model;

import com.google.gson.JsonArray;

public class CateringServiceATCResponse {
    String item_id;
   // String quantity;
    String remove_old;
    String special_request;
    String mode_id;
    JsonArray addon_items;
    JsonArray meals;
  //  String value;

    public CateringServiceATCResponse(String item_id, String remove_old, String special_request, String mode_id, JsonArray addon_items, JsonArray meals) {
        this.item_id = item_id;
      //  this.quantity = quantity;
        this.remove_old = remove_old;
        this.special_request = special_request;
        this.mode_id = mode_id;
        this.addon_items = addon_items;
        this.meals = meals;
      //  this.value = value;
    }

    public String getItem_id() {
        return item_id;
    }

    public void setItem_id(String item_id) {
        this.item_id = item_id;
    }

//    public String getQuantity() {
//        return quantity;
//    }
//
//    public void setQuantity(String quantity) {
//        this.quantity = quantity;
//    }

    public String getRemove_old() {
        return remove_old;
    }

    public void setRemove_old(String remove_old) {
        this.remove_old = remove_old;
    }

    public String getSpecial_request() {
        return special_request;
    }

    public void setSpecial_request(String special_request) {
        this.special_request = special_request;
    }

    public String getMode_id() {
        return mode_id;
    }

    public void setMode_id(String mode_id) {
        this.mode_id = mode_id;
    }

    public JsonArray getAddon_items() {
        return addon_items;
    }

    public void setAddon_items(JsonArray addon_items) {
        this.addon_items = addon_items;
    }

    public JsonArray getMeals() {
        return meals;
    }

    public void setMeals(JsonArray meals) {
        this.meals = meals;
    }

//    public String getValue() {
//        return value;
//    }
//
//    public void setValue(String value) {
//        this.value = value;
//    }
}
