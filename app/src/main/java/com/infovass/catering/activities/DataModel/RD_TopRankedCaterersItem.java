package com.infovass.catering.activities.DataModel;

public class RD_TopRankedCaterersItem {
    private String id ;
    private String item_code ;
    private String category_id ;
    private String subcategory_id ;
    private String item_name ;
    private String item_display_name ;
    private String item_short_description ;
    private String item_cost_per_serve ;
    private String item_markup_per_serve ;
    private String item_serving_capacity ;
    private String item_logo ;
    private String status ;
    private String is_top_ranked ;

    public RD_TopRankedCaterersItem(String id, String item_code, String category_id, String subcategory_id, String item_name, String item_display_name, String item_short_description, String item_cost_per_serve, String item_markup_per_serve, String item_serving_capacity, String item_logo, String status, String is_top_ranked) {
        this.id = id;
        this.item_code = item_code;
        this.category_id = category_id;
        this.subcategory_id = subcategory_id;
        this.item_name = item_name;
        this.item_display_name = item_display_name;
        this.item_short_description = item_short_description;
        this.item_cost_per_serve = item_cost_per_serve;
        this.item_markup_per_serve = item_markup_per_serve;
        this.item_serving_capacity = item_serving_capacity;
        this.item_logo = item_logo;
        this.status = status;
        this.is_top_ranked = is_top_ranked;
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
}
