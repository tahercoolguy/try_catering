package com.infovass.catering.activities.DataModel;

public class RD_Mode {

    private String id ;
    private String name ;
    private String arabic_title ;
    private String image_path ;

    public RD_Mode(String id, String name, String arabic_title, String image_path) {
        this.id = id;
        this.name = name;
        this.arabic_title = arabic_title;
        this.image_path = image_path;
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

    public String getArabic_title() {
        return arabic_title;
    }

    public void setArabic_title(String arabic_title) {
        this.arabic_title = arabic_title;
    }

    public String getImage_path() {
        return image_path;
    }

    public void setImage_path(String image_path) {
        this.image_path = image_path;
    }
}
