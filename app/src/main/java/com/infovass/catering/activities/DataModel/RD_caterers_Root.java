package com.infovass.catering.activities.DataModel;

public class RD_caterers_Root {

    private String status ;
    private String message ;
    private RD_caterers_Data data ;

    public RD_caterers_Root(String status, String message, RD_caterers_Data data) {
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

    public RD_caterers_Data getData() {
        return data;
    }

    public void setData(RD_caterers_Data data) {
        this.data = data;
    }
}
