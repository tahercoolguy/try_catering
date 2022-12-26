package com.infovass.catering.activities.login.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ForGotPasswordResponse {

    @SerializedName("status")
    @Expose
    private Boolean status;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("data")
    @Expose
    private Data data;

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public class Data {

        @SerializedName("phone")
        @Expose
        private String phone;
        @SerializedName("country_code")
        @Expose
        private Object countryCode;

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public Object getCountryCode() {
            return countryCode;
        }

        public void setCountryCode(Object countryCode) {
            this.countryCode = countryCode;
        }

    }

}
