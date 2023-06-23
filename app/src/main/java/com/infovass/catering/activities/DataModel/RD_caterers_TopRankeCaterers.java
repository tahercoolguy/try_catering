package com.infovass.catering.activities.DataModel;

import java.util.ArrayList;

public class RD_caterers_TopRankeCaterers {
    public String id;
    public String created_by;
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
    public String setup_time_in_minute;
    public String requirements;
    public String arabic_setup_time_in_minute;
    public String arabic_requirements;
    public String discount_available;
    public String discount_type;
    public String discount_value;
    public String start_date;
    public String end_date;
    public String time;
    public String cash_order_policy;
    public String cancellation_policy;
    public String cancellation_policy_arabic;
    public String is_active;
    public String is_top_ranked;
    public String created_at;
    public String updated_at;
    public String deleted_at;
    public String commission;
    public String minimum_time;
    public String start_time;
    public String end_time;
    public String email;
    public String number_of_review;
    public String rating;
    public String offday;
    public String Restaurant_Status;
    public String is_favorite;
    public ArrayList<RD_CoverImage> cover_images;
    public ArrayList<RD_Mode> modes;
    public String logo_path;
    public String cover_image_path;
    public ArrayList<RD_Image> images;

    public RD_caterers_TopRankeCaterers(String id, String created_by, String name, String arabic_name, String detail, String arabic_detail, String status, String female_service, String logo, String cover_image, String time_show, String delivery_charge, String min_order, String setup_time_in_minute, String requirements, String arabic_setup_time_in_minute, String arabic_requirements, String discount_available, String discount_type, String discount_value, String start_date, String end_date, String time, String cash_order_policy, String cancellation_policy, String cancellation_policy_arabic, String is_active, String is_top_ranked, String created_at, String updated_at, String deleted_at, String commission, String minimum_time, String start_time, String end_time, String email, String number_of_review, String rating, String offday, String restaurant_Status, String is_favorite, ArrayList<RD_CoverImage> cover_images, ArrayList<RD_Mode> modes, String logo_path, String cover_image_path, ArrayList<RD_Image> images) {
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
        this.is_top_ranked = is_top_ranked;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.deleted_at = deleted_at;
        this.commission = commission;
        this.minimum_time = minimum_time;
        this.start_time = start_time;
        this.end_time = end_time;
        this.email = email;
        this.number_of_review = number_of_review;
        this.rating = rating;
        this.offday = offday;
        Restaurant_Status = restaurant_Status;
        this.is_favorite = is_favorite;
        this.cover_images = cover_images;
        this.modes = modes;
        this.logo_path = logo_path;
        this.cover_image_path = cover_image_path;
        this.images = images;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreated_by() {
        return created_by;
    }

    public void setCreated_by(String created_by) {
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

    public String getSetup_time_in_minute() {
        return setup_time_in_minute;
    }

    public void setSetup_time_in_minute(String setup_time_in_minute) {
        this.setup_time_in_minute = setup_time_in_minute;
    }

    public String getRequirements() {
        return requirements;
    }

    public void setRequirements(String requirements) {
        this.requirements = requirements;
    }

    public String getArabic_setup_time_in_minute() {
        return arabic_setup_time_in_minute;
    }

    public void setArabic_setup_time_in_minute(String arabic_setup_time_in_minute) {
        this.arabic_setup_time_in_minute = arabic_setup_time_in_minute;
    }

    public String getArabic_requirements() {
        return arabic_requirements;
    }

    public void setArabic_requirements(String arabic_requirements) {
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

    public String getDiscount_value() {
        return discount_value;
    }

    public void setDiscount_value(String discount_value) {
        this.discount_value = discount_value;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getCash_order_policy() {
        return cash_order_policy;
    }

    public void setCash_order_policy(String cash_order_policy) {
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

    public String getIs_top_ranked() {
        return is_top_ranked;
    }

    public void setIs_top_ranked(String is_top_ranked) {
        this.is_top_ranked = is_top_ranked;
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

    public String getDeleted_at() {
        return deleted_at;
    }

    public void setDeleted_at(String deleted_at) {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumber_of_review() {
        return number_of_review;
    }

    public void setNumber_of_review(String number_of_review) {
        this.number_of_review = number_of_review;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getOffday() {
        return offday;
    }

    public void setOffday(String offday) {
        this.offday = offday;
    }

    public String getRestaurant_Status() {
        return Restaurant_Status;
    }

    public void setRestaurant_Status(String restaurant_Status) {
        Restaurant_Status = restaurant_Status;
    }

    public String getIs_favorite() {
        return is_favorite;
    }

    public void setIs_favorite(String is_favorite) {
        this.is_favorite = is_favorite;
    }

    public ArrayList<RD_CoverImage> getCover_images() {
        return cover_images;
    }

    public void setCover_images(ArrayList<RD_CoverImage> cover_images) {
        this.cover_images = cover_images;
    }

    public ArrayList<RD_Mode> getModes() {
        return modes;
    }

    public void setModes(ArrayList<RD_Mode> modes) {
        this.modes = modes;
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

    public ArrayList<RD_Image> getImages() {
        return images;
    }

    public void setImages(ArrayList<RD_Image> images) {
        this.images = images;
    }
}
