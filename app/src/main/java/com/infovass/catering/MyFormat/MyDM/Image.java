package com.infovass.catering.MyFormat.MyDM;

public class Image {
    public String id;
    public String caterer_item_id;
    public String image;
    public String created_at;
    public String updated_at;
    public String item_logo_path;
    public String caterer_id;
    public String cover_image_path;

    public Image(String id, String caterer_item_id, String image, String created_at, String updated_at, String item_logo_path, String caterer_id, String cover_image_path) {
        this.id = id;
        this.caterer_item_id = caterer_item_id;
        this.image = image;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.item_logo_path = item_logo_path;
        this.caterer_id = caterer_id;
        this.cover_image_path = cover_image_path;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCaterer_item_id() {
        return caterer_item_id;
    }

    public void setCaterer_item_id(String caterer_item_id) {
        this.caterer_item_id = caterer_item_id;
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

    public String getItem_logo_path() {
        return item_logo_path;
    }

    public void setItem_logo_path(String item_logo_path) {
        this.item_logo_path = item_logo_path;
    }

    public String getCaterer_id() {
        return caterer_id;
    }

    public void setCaterer_id(String caterer_id) {
        this.caterer_id = caterer_id;
    }

    public String getCover_image_path() {
        return cover_image_path;
    }

    public void setCover_image_path(String cover_image_path) {
        this.cover_image_path = cover_image_path;
    }
}
