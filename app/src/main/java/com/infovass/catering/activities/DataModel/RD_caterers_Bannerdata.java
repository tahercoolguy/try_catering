package com.infovass.catering.activities.DataModel;

public class RD_caterers_Bannerdata {

    private String id ;
    private String name ;
    private String image ;
    private String status ;

    public RD_caterers_Bannerdata(String id, String name, String image, String status) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
