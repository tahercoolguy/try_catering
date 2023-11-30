package com.infovass.catering.MyFormat.MyDM;

import java.util.ArrayList;
import java.util.List;

public class Item {
    public String category_name;
    public String category_name_ar;
    public ArrayList<NewItem> items;

    public Item(String category_name, String category_name_ar, ArrayList<NewItem> items) {
        this.category_name = category_name;
        this.category_name_ar = category_name_ar;
        this.items = items;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public String getCategory_name_ar() {
        return category_name_ar;
    }

    public void setCategory_name_ar(String category_name_ar) {
        this.category_name_ar = category_name_ar;
    }

    public ArrayList<NewItem> getItems() {
        return items;
    }

    public void setItems(ArrayList<NewItem> items) {
        this.items = items;
    }
}
