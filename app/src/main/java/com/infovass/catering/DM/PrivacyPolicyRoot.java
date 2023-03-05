package com.infovass.catering.DM;

import java.util.ArrayList;

public class PrivacyPolicyRoot {

    public String status ;
    public String message ;
    public  PrivacyPolicyData data ;

    public PrivacyPolicyRoot(String status, String message,  PrivacyPolicyData data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

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

    public  PrivacyPolicyData getData() {
        return data;
    }

    public void setData(PrivacyPolicyData data) {
        this.data = data;
    }
}
