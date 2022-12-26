package com.infovass.catering.MyFormat.MyDM;

import java.util.ArrayList;
import java.util.List;

public class Item {
    private String categoryName;
    private String categoryNameAr;
    private List<Item_> items = new ArrayList<Item_>();
    public String getCategoryName() {
        return categoryName;
    }
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
    public String getCategoryNameAr() {
        return categoryNameAr;
    }
    public void setCategoryNameAr(String categoryNameAr) {
        this.categoryNameAr = categoryNameAr;
    }
    public List<Item_> getItems() {
        return items;
    }
    public void setItems(List<Item_> items) {
        this.items = items;
    }
}
