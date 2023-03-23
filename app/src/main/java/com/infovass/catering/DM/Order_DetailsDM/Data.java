package com.infovass.catering.DM.Order_DetailsDM;

import java.util.ArrayList;

public class Data {
    public String id ;
    public String invoice_id ;
    public String invoice_date ;
    public String request_date_time ;
    public String customer_id ;
    public String caterer_id ;
    public String address_id ;
    public String delivery_charge ;
    public String catering_charge ;
    public String area_id ;
    public String female_service ;
    public String title ;
    public String direction ;
    public String building_type ;
    public String order_details ;
    public String street ;
    public String building_no ;
    public String customer_lat ;
    public String customer_lng ;
    public String payment_type ;
    public String payment_id ;
    public String payment_date ;
    public String transaction_number ;
    public String track_id ;
    public String payment_status ;
    public String cupon_code ;
    public String order_status ;
    public String order_sorting ;
    public String delivery_status ;
    public String status ;
    public String device ;
    public String deleted_at ;
    public String created_at ;
    public String updated_at ;
    public String mode_id ;
    public String total_amount ;
    public ArrayList<OrderIteam> order_iteam ;

    public Data(String id, String invoice_id, String invoice_date, String request_date_time, String customer_id, String caterer_id, String address_id, String delivery_charge, String catering_charge, String area_id, String female_service, String title, String direction, String building_type, String order_details, String street, String building_no, String customer_lat, String customer_lng, String payment_type, String payment_id, String payment_date, String transaction_number, String track_id, String payment_status, String cupon_code, String order_status, String order_sorting, String delivery_status, String status, String device, String deleted_at, String created_at, String updated_at, String mode_id, String total_amount, ArrayList<OrderIteam> order_iteam) {
        this.id = id;
        this.invoice_id = invoice_id;
        this.invoice_date = invoice_date;
        this.request_date_time = request_date_time;
        this.customer_id = customer_id;
        this.caterer_id = caterer_id;
        this.address_id = address_id;
        this.delivery_charge = delivery_charge;
        this.catering_charge = catering_charge;
        this.area_id = area_id;
        this.female_service = female_service;
        this.title = title;
        this.direction = direction;
        this.building_type = building_type;
        this.order_details = order_details;
        this.street = street;
        this.building_no = building_no;
        this.customer_lat = customer_lat;
        this.customer_lng = customer_lng;
        this.payment_type = payment_type;
        this.payment_id = payment_id;
        this.payment_date = payment_date;
        this.transaction_number = transaction_number;
        this.track_id = track_id;
        this.payment_status = payment_status;
        this.cupon_code = cupon_code;
        this.order_status = order_status;
        this.order_sorting = order_sorting;
        this.delivery_status = delivery_status;
        this.status = status;
        this.device = device;
        this.deleted_at = deleted_at;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.mode_id = mode_id;
        this.total_amount = total_amount;
        this.order_iteam = order_iteam;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getInvoice_id() {
        return invoice_id;
    }

    public void setInvoice_id(String invoice_id) {
        this.invoice_id = invoice_id;
    }

    public String getInvoice_date() {
        return invoice_date;
    }

    public void setInvoice_date(String invoice_date) {
        this.invoice_date = invoice_date;
    }

    public String getRequest_date_time() {
        return request_date_time;
    }

    public void setRequest_date_time(String request_date_time) {
        this.request_date_time = request_date_time;
    }

    public String getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }

    public String getCaterer_id() {
        return caterer_id;
    }

    public void setCaterer_id(String caterer_id) {
        this.caterer_id = caterer_id;
    }

    public String getAddress_id() {
        return address_id;
    }

    public void setAddress_id(String address_id) {
        this.address_id = address_id;
    }

    public String getDelivery_charge() {
        return delivery_charge;
    }

    public void setDelivery_charge(String delivery_charge) {
        this.delivery_charge = delivery_charge;
    }

    public String getCatering_charge() {
        return catering_charge;
    }

    public void setCatering_charge(String catering_charge) {
        this.catering_charge = catering_charge;
    }

    public String getArea_id() {
        return area_id;
    }

    public void setArea_id(String area_id) {
        this.area_id = area_id;
    }

    public String getFemale_service() {
        return female_service;
    }

    public void setFemale_service(String female_service) {
        this.female_service = female_service;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getBuilding_type() {
        return building_type;
    }

    public void setBuilding_type(String building_type) {
        this.building_type = building_type;
    }

    public String getOrder_details() {
        return order_details;
    }

    public void setOrder_details(String order_details) {
        this.order_details = order_details;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getBuilding_no() {
        return building_no;
    }

    public void setBuilding_no(String building_no) {
        this.building_no = building_no;
    }

    public String getCustomer_lat() {
        return customer_lat;
    }

    public void setCustomer_lat(String customer_lat) {
        this.customer_lat = customer_lat;
    }

    public String getCustomer_lng() {
        return customer_lng;
    }

    public void setCustomer_lng(String customer_lng) {
        this.customer_lng = customer_lng;
    }

    public String getPayment_type() {
        return payment_type;
    }

    public void setPayment_type(String payment_type) {
        this.payment_type = payment_type;
    }

    public String getPayment_id() {
        return payment_id;
    }

    public void setPayment_id(String payment_id) {
        this.payment_id = payment_id;
    }

    public String getPayment_date() {
        return payment_date;
    }

    public void setPayment_date(String payment_date) {
        this.payment_date = payment_date;
    }

    public String getTransaction_number() {
        return transaction_number;
    }

    public void setTransaction_number(String transaction_number) {
        this.transaction_number = transaction_number;
    }

    public String getTrack_id() {
        return track_id;
    }

    public void setTrack_id(String track_id) {
        this.track_id = track_id;
    }

    public String getPayment_status() {
        return payment_status;
    }

    public void setPayment_status(String payment_status) {
        this.payment_status = payment_status;
    }

    public String getCupon_code() {
        return cupon_code;
    }

    public void setCupon_code(String cupon_code) {
        this.cupon_code = cupon_code;
    }

    public String getOrder_status() {
        return order_status;
    }

    public void setOrder_status(String order_status) {
        this.order_status = order_status;
    }

    public String getOrder_sorting() {
        return order_sorting;
    }

    public void setOrder_sorting(String order_sorting) {
        this.order_sorting = order_sorting;
    }

    public String getDelivery_status() {
        return delivery_status;
    }

    public void setDelivery_status(String delivery_status) {
        this.delivery_status = delivery_status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public String getDeleted_at() {
        return deleted_at;
    }

    public void setDeleted_at(String deleted_at) {
        this.deleted_at = deleted_at;
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

    public String getMode_id() {
        return mode_id;
    }

    public void setMode_id(String mode_id) {
        this.mode_id = mode_id;
    }

    public String getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(String total_amount) {
        this.total_amount = total_amount;
    }

    public ArrayList<OrderIteam> getOrder_iteam() {
        return order_iteam;
    }

    public void setOrder_iteam(ArrayList<OrderIteam> order_iteam) {
        this.order_iteam = order_iteam;
    }
}
