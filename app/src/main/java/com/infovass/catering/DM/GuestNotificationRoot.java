package com.infovass.catering.DM;

import java.util.ArrayList;

public class GuestNotificationRoot {

    public boolean status ;
    public String message ;
    public ArrayList<Object> result ;

    public GuestNotificationRoot(boolean status, String message, ArrayList<Object> result) {
        this.status = status;
        this.message = message;
        this.result = result;
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

    public ArrayList<Object> getResult() {
        return result;
    }

    public void setResult(ArrayList<Object> result) {
        this.result = result;
    }
}
