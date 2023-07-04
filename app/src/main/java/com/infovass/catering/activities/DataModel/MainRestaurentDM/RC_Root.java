package com.infovass.catering.activities.DataModel.MainRestaurentDM;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class RC_Root {
    private String status ;
    private String message ;
    private ArrayList<RC_Data> data ;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ArrayList<RC_Data> getData() {
        return data;
    }

    public void setData(ArrayList<RC_Data> data) {
        this.data = data;
    }
}
