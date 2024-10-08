package com.infovass.catering.activities.DataModel;

public class RD_TopRankedCaterersItem {
    public String id ;
    public String item_code ;
    public String item_code_arabic ;
    public String category_id ;
    public String subcategory_id ;
    public String item_name ;
    public String item_name_arabic ;
    public String item_display_name ;
    public String item_short_description ;
    public String item_cost_per_serve ;
    public String item_markup_per_serve ;
    public String item_serving_capacity ;
    public String item_logo ;
    public String status ;
    public String is_top_ranked ;
    public String addon_item ;
    public String currency ;
    public Caterer caterer ;

    public RD_TopRankedCaterersItem(String id, String item_code, String item_code_arabic, String category_id, String subcategory_id, String item_name, String item_name_arabic, String item_display_name, String item_short_description, String item_cost_per_serve, String item_markup_per_serve, String item_serving_capacity, String item_logo, String status, String is_top_ranked, String addon_item, String currency, Caterer caterer) {
        this.id = id;
        this.item_code = item_code;
        this.item_code_arabic = item_code_arabic;
        this.category_id = category_id;
        this.subcategory_id = subcategory_id;
        this.item_name = item_name;
        this.item_name_arabic = item_name_arabic;
        this.item_display_name = item_display_name;
        this.item_short_description = item_short_description;
        this.item_cost_per_serve = item_cost_per_serve;
        this.item_markup_per_serve = item_markup_per_serve;
        this.item_serving_capacity = item_serving_capacity;
        this.item_logo = item_logo;
        this.status = status;
        this.is_top_ranked = is_top_ranked;
        this.addon_item = addon_item;
        this.currency = currency;
        this.caterer = caterer;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getItem_code() {
        return item_code;
    }

    public void setItem_code(String item_code) {
        this.item_code = item_code;
    }

    public String getItem_code_arabic() {
        return item_code_arabic;
    }

    public void setItem_code_arabic(String item_code_arabic) {
        this.item_code_arabic = item_code_arabic;
    }

    public String getCategory_id() {
        return category_id;
    }

    public void setCategory_id(String category_id) {
        this.category_id = category_id;
    }

    public String getSubcategory_id() {
        return subcategory_id;
    }

    public void setSubcategory_id(String subcategory_id) {
        this.subcategory_id = subcategory_id;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public String getItem_name_arabic() {
        return item_name_arabic;
    }

    public void setItem_name_arabic(String item_name_arabic) {
        this.item_name_arabic = item_name_arabic;
    }

    public String getItem_display_name() {
        return item_display_name;
    }

    public void setItem_display_name(String item_display_name) {
        this.item_display_name = item_display_name;
    }

    public String getItem_short_description() {
        return item_short_description;
    }

    public void setItem_short_description(String item_short_description) {
        this.item_short_description = item_short_description;
    }

    public String getItem_cost_per_serve() {
        return item_cost_per_serve;
    }

    public void setItem_cost_per_serve(String item_cost_per_serve) {
        this.item_cost_per_serve = item_cost_per_serve;
    }

    public String getItem_markup_per_serve() {
        return item_markup_per_serve;
    }

    public void setItem_markup_per_serve(String item_markup_per_serve) {
        this.item_markup_per_serve = item_markup_per_serve;
    }

    public String getItem_serving_capacity() {
        return item_serving_capacity;
    }

    public void setItem_serving_capacity(String item_serving_capacity) {
        this.item_serving_capacity = item_serving_capacity;
    }

    public String getItem_logo() {
        return item_logo;
    }

    public void setItem_logo(String item_logo) {
        this.item_logo = item_logo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getIs_top_ranked() {
        return is_top_ranked;
    }

    public void setIs_top_ranked(String is_top_ranked) {
        this.is_top_ranked = is_top_ranked;
    }

    public String getAddon_item() {
        return addon_item;
    }

    public void setAddon_item(String addon_item) {
        this.addon_item = addon_item;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Caterer getCaterer() {
        return caterer;
    }

    public void setCaterer(Caterer caterer) {
        this.caterer = caterer;
    }
}
