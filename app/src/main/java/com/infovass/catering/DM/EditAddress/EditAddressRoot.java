package com.infovass.catering.DM.EditAddress;

import java.util.ArrayList;

public class EditAddressRoot {

    public boolean status ;
    public String message ;
    public ArrayList<EditAddressData> data ;

    public EditAddressRoot(boolean status, String message, ArrayList<EditAddressData> data) {
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

    public ArrayList<EditAddressData> getData() {
        return data;
    }

    public void setData(ArrayList<EditAddressData> data) {
        this.data = data;
    }
}
