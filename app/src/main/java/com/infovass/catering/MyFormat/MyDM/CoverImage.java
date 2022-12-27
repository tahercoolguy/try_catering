package com.infovass.catering.MyFormat.MyDM;

public class CoverImage {
    public String id;
    public String caterer_id;
    public String image;
    public String created_at;
    public String updated_at;
    public String cover_image_path;

    public CoverImage(String id, String caterer_id, String image, String created_at, String updated_at, String cover_image_path) {
        this.id = id;
        this.caterer_id = caterer_id;
        this.image = image;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.cover_image_path = cover_image_path;
    }

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
