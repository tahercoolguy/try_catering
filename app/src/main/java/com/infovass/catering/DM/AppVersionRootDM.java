package com.infovass.catering.DM;

import java.util.ArrayList;

public class AppVersionRootDM {
    public boolean status ;
    public String message ;
    public ArrayList<AppVersionResult> result ;

    public AppVersionRootDM(boolean status, String message, ArrayList<AppVersionResult> result) {
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

    public ArrayList<AppVersionResult> getResult() {
        return result;
    }

    public void setResult(ArrayList<AppVersionResult> result) {
        this.result = result;
    }
}
