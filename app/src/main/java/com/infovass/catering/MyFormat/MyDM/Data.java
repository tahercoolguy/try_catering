package com.infovass.catering.MyFormat.MyDM;

import java.util.ArrayList;
import java.util.List;

public class Data {
    public int id;
    public int created_by;
    public String name;
    public String arabic_name;
    public String detail;
    public String arabic_detail;
    public String status;
    public String female_service;
    public String logo;
    public String cover_image;
    public String time_show;
    public String delivery_charge;
    public String min_order;
    public Object setup_time_in_minute;
    public Object requirements;
    public Object arabic_setup_time_in_minute;
    public Object arabic_requirements;
    public String discount_available;
    public String discount_type;
    public Object discount_value;
    public Object start_date;
    public Object end_date;
    public Object time;
    public Object cash_order_policy;
    public String cancellation_policy;
    public String cancellation_policy_arabic;
    public String is_active;
    public String created_at;
    public String updated_at;
    public Object deleted_at;
    public String commission;
    public String minimum_time;
    public String start_time;
    public String end_time;
    public String is_favorite;
    public String offday;
    public ArrayList<CoverImage> cover_images;
    public ArrayList<Mode> modes;
    public ArrayList<Item> item;
    public int number_of_review;
    public int rating;
    public String logo_path;
    public String cover_image_path;
    public Credential credential;
    public ArrayList<Image> images;
    public ArrayList<Area> areas;

    public Data(int id, int created_by, String name, String arabic_name, String detail, String arabic_detail, String status, String female_service, String logo, String cover_image, String time_show, String delivery_charge, String min_order, Object setup_time_in_minute, Object requirements, Object arabic_setup_time_in_minute, Object arabic_requirements, String discount_available, String discount_type, Object discount_value, Object start_date, Object end_date, Object time, Object cash_order_policy, String cancellation_policy, String cancellation_policy_arabic, String is_active, String created_at, String updated_at, Object deleted_at, String commission, String minimum_time, String start_time, String end_time, String is_favorite, String offday, ArrayList<CoverImage> cover_images, ArrayList<Mode> modes, ArrayList<Item> item, int number_of_review, int rating, String logo_path, String cover_image_path, Credential credential, ArrayList<Image> images, ArrayList<Area> areas) {
        this.id = id;
        this.created_by = created_by;
        this.name = name;
        this.arabic_name = arabic_name;
        this.detail = detail;
        this.arabic_detail = arabic_detail;
        this.status = status;
        this.female_service = female_service;
        this.logo = logo;
        this.cover_image = cover_image;
        this.time_show = time_show;
        this.delivery_charge = delivery_charge;
        this.min_order = min_order;
        this.setup_time_in_minute = setup_time_in_minute;
        this.requirements = requirements;
        this.arabic_setup_time_in_minute = arabic_setup_time_in_minute;
        this.arabic_requirements = arabic_requirements;
        this.discount_available = discount_available;
        this.discount_type = discount_type;
        this.discount_value = discount_value;
        this.start_date = start_date;
        this.end_date = end_date;
        this.time = time;
        this.cash_order_policy = cash_order_policy;
        this.cancellation_policy = cancellation_policy;
        this.cancellation_policy_arabic = cancellation_policy_arabic;
        this.is_active = is_active;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.deleted_at = deleted_at;
        this.commission = commission;
        this.minimum_time = minimum_time;
        this.start_time = start_time;
        this.end_time = end_time;
        this.is_favorite = is_favorite;
        this.offday = offday;
        this.cover_images = cover_images;
        this.modes = modes;
        this.item = item;
        this.number_of_review = number_of_review;
        this.rating = rating;
        this.logo_path = logo_path;
        this.cover_image_path = cover_image_path;
        this.credential = credential;
        this.images = images;
        this.areas = areas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCreated_by() {
        return created_by;
    }

    public void setCreated_by(int created_by) {
        this.created_by = created_by;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArabic_name() {
        return arabic_name;
    }

    public void setArabic_name(String arabic_name) {
        this.arabic_name = arabic_name;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getArabic_detail() {
        return arabic_detail;
    }

    public void setArabic_detail(String arabic_detail) {
        this.arabic_detail = arabic_detail;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFemale_service() {
        return female_service;
    }

    public void setFemale_service(String female_service) {
        this.female_service = female_service;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getCover_image() {
        return cover_image;
    }

    public void setCover_image(String cover_image) {
        this.cover_image = cover_image;
    }

    public String getTime_show() {
        return time_show;
    }

    public void setTime_show(String time_show) {
        this.time_show = time_show;
    }

    public String getDelivery_charge() {
        return delivery_charge;
    }

    public void setDelivery_charge(String delivery_charge) {
        this.delivery_charge = delivery_charge;
    }

    public String getMin_order() {
        return min_order;
    }

    public void setMin_order(String min_order) {
        this.min_order = min_order;
    }

    public Object getSetup_time_in_minute() {
        return setup_time_in_minute;
    }

    public void setSetup_time_in_minute(Object setup_time_in_minute) {
        this.setup_time_in_minute = setup_time_in_minute;
    }

    public Object getRequirements() {
        return requirements;
    }

    public void setRequirements(Object requirements) {
        this.requirements = requirements;
    }

    public Object getArabic_setup_time_in_minute() {
        return arabic_setup_time_in_minute;
    }

    public void setArabic_setup_time_in_minute(Object arabic_setup_time_in_minute) {
        this.arabic_setup_time_in_minute = arabic_setup_time_in_minute;
    }

    public Object getArabic_requirements() {
        return arabic_requirements;
    }

    public void setArabic_requirements(Object arabic_requirements) {
        this.arabic_requirements = arabic_requirements;
    }

    public String getDiscount_available() {
        return discount_available;
    }

    public void setDiscount_available(String discount_available) {
        this.discount_available = discount_available;
    }

    public String getDiscount_type() {
        return discount_type;
    }

    public void setDiscount_type(String discount_type) {
        this.discount_type = discount_type;
    }

    public Object getDiscount_value() {
        return discount_value;
    }

    public void setDiscount_value(Object discount_value) {
        this.discount_value = discount_value;
    }

    public Object getStart_date() {
        return start_date;
    }

    public void setStart_date(Object start_date) {
        this.start_date = start_date;
    }

    public Object getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Object end_date) {
        this.end_date = end_date;
    }

    public Object getTime() {
        return time;
    }

    public void setTime(Object time) {
        this.time = time;
    }

    public Object getCash_order_policy() {
        return cash_order_policy;
    }

    public void setCash_order_policy(Object cash_order_policy) {
        this.cash_order_policy = cash_order_policy;
    }

    public String getCancellation_policy() {
        return cancellation_policy;
    }

    public void setCancellation_policy(String cancellation_policy) {
        this.cancellation_policy = cancellation_policy;
    }

    public String getCancellation_policy_arabic() {
        return cancellation_policy_arabic;
    }

    public void setCancellation_policy_arabic(String cancellation_policy_arabic) {
        this.cancellation_policy_arabic = cancellation_policy_arabic;
    }

    public String getIs_active() {
        return is_active;
    }

    public void setIs_active(String is_active) {
        this.is_active = is_active;
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

    public Object getDeleted_at() {
        return deleted_at;
    }

    public void setDeleted_at(Object deleted_at) {
        this.deleted_at = deleted_at;
    }

    public String getCommission() {
        return commission;
    }

    public void setCommission(String commission) {
        this.commission = commission;
    }

    public String getMinimum_time() {
        return minimum_time;
    }

    public void setMinimum_time(String minimum_time) {
        this.minimum_time = minimum_time;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    public String getIs_favorite() {
        return is_favorite;
    }

    public void setIs_favorite(String is_favorite) {
        this.is_favorite = is_favorite;
    }

    public String getOffday() {
        return offday;
    }

    public void setOffday(String offday) {
        this.offday = offday;
    }

    public ArrayList<CoverImage> getCover_images() {
        return cover_images;
    }

    public void setCover_images(ArrayList<CoverImage> cover_images) {
        this.cover_images = cover_images;
    }

    public ArrayList<Mode> getModes() {
        return modes;
    }

    public void setModes(ArrayList<Mode> modes) {
        this.modes = modes;
    }

    public ArrayList<Item> getItem() {
        return item;
    }

    public void setItem(ArrayList<Item> item) {
        this.item = item;
    }

    public int getNumber_of_review() {
        return number_of_review;
    }

    public void setNumber_of_review(int number_of_review) {
        this.number_of_review = number_of_review;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getLogo_path() {
        return logo_path;
    }

    public void setLogo_path(String logo_path) {
        this.logo_path = logo_path;
    }

    public String getCover_image_path() {
        return cover_image_path;
    }

    public void setCover_image_path(String cover_image_path) {
        this.cover_image_path = cover_image_path;
    }

    public Credential getCredential() {
        return credential;
    }

    public void setCredential(Credential credential) {
        this.credential = credential;
    }

    public ArrayList<Image> getImages() {
        return images;
    }

    public void setImages(ArrayList<Image> images) {
        this.images = images;
    }

    public ArrayList<Area> getAreas() {
        return areas;
    }

    public void setAreas(ArrayList<Area> areas) {
        this.areas = areas;
    }
}
