package com.infovass.catering.activities.DataModel;

public class RD_caterers_Bannerdata {
 
    private String id ;
    private String name ;
    private String image ;
    private String status ;
    private String banner_type ;
    private Caterer caterer ;
    private CatererItem caterer_item ;

    public RD_caterers_Bannerdata(String id, String name, String image, String status, String banner_type, Caterer caterer, CatererItem caterer_item) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.status = status;
        this.banner_type = banner_type;
        this.caterer = caterer;
        this.caterer_item = caterer_item;
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

    public String getBanner_type() {
        return banner_type;
    }

    public void setBanner_type(String banner_type) {
        this.banner_type = banner_type;
    }

    public Caterer getCaterer() {
        return caterer;
    }

    public void setCaterer(Caterer caterer) {
        this.caterer = caterer;
    }

    public CatererItem getCaterer_item() {
        return caterer_item;
    }

    public void setCaterer_item(CatererItem caterer_item) {
        this.caterer_item = caterer_item;
    }
}
