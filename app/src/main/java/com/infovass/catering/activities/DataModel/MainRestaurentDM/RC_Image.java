package com.infovass.catering.activities.DataModel.MainRestaurentDM;

public class RC_Image {
    private String id ;
    private String caterer_id ;
    private String image ;
    private String created_at ;
    private String updated_at ;
    private String cover_image_path ;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCaterer_id() {
        return caterer_id;
    }

    public void setCaterer_id(String caterer_id) {
        this.caterer_id = caterer_id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public String getCover_image_path() {
        return cover_image_path;
    }

    public void setCover_image_path(String cover_image_path) {
        this.cover_image_path = cover_image_path;
    }
}
