package com.infovass.catering.DM.FavoriteCatererListDM;

import java.util.ArrayList;

public class FavoriteCatererRoot {
    public boolean status ;
    public String message ;
    public ArrayList<FavoriteCatererData> data ;

    public FavoriteCatererRoot(boolean status, String message, ArrayList<FavoriteCatererData> data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ArrayList<FavoriteCatererData> getData() {
        return data;
    }

    public void setData(ArrayList<FavoriteCatererData> data) {
        this.data = data;
    }
}
