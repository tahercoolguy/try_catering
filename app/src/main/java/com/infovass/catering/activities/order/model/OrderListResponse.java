package com.infovass.catering.activities.order.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OrderListResponse {
    @SerializedName("status")
    @Expose
    private Boolean status;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("data")
    @Expose
    private List<Datum> data = null;

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

    public List<Datum> getData() {
        return data;
    }

    public void setData(List<Datum> data) {
        this.data = data;
    }
    public class Datum {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("invoice_id")
        @Expose
        private Integer invoiceId;
        @SerializedName("invoice_date")
        @Expose
        private String invoiceDate;
        @SerializedName("request_date_time")
        @Expose
        private String requestDateTime;
        @SerializedName("customer_id")
        @Expose
        private Integer customerId;
        @SerializedName("caterer_id")
        @Expose
        private Integer catererId;
        @SerializedName("address_id")
        @Expose
        private Integer addressId;
        @SerializedName("delivery_charge")
        @Expose
        private Object deliveryCharge;
        @SerializedName("catering_charge")
        @Expose
        private Object cateringCharge;
        @SerializedName("area_id")
        @Expose
        private Integer areaId;
        @SerializedName("female_service")
        @Expose
        private Object femaleService;
        @SerializedName("title")
        @Expose
        private String title;
        @SerializedName("direction")
        @Expose
        private String direction;
        @SerializedName("building_type")
        @Expose
        private String buildingType;
        @SerializedName("order_details")
        @Expose
        private String orderDetails;
        @SerializedName("street")
        @Expose
        private String street;
        @SerializedName("building_no")
        @Expose
        private String buildingNo;
        @SerializedName("customer_lat")
        @Expose
        private String customerLat;
        @SerializedName("customer_lng")
        @Expose
        private String customerLng;
        @SerializedName("payment_type")
        @Expose
        private String paymentType;
        @SerializedName("payment_id")
        @Expose
        private Object paymentId;
        @SerializedName("payment_date")
        @Expose
        private Object paymentDate;
        @SerializedName("payment_status")
        @Expose
        private String paymentStatus;
        @SerializedName("cupon_code")
        @Expose
        private Object cuponCode;
        @SerializedName("order_status")
        @Expose
        private String orderStatus;
        @SerializedName("order_sorting")
        @Expose
        private Integer orderSorting;
        @SerializedName("delivery_status")
        @Expose
        private Integer deliveryStatus;
        @SerializedName("deleted_at")
        @Expose
        private Object deletedAt;
        @SerializedName("created_at")
        @Expose
        private String createdAt;
        @SerializedName("updated_at")
        @Expose
        private String updatedAt;
        @SerializedName("mode_id")
        @Expose
        private String modeId;
        @SerializedName("total_amount")
        @Expose
        private String totalAmount;
        @SerializedName("order_iteam")
        @Expose
        private List<OrderIteam> orderIteam = null;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Integer getInvoiceId() {
            return invoiceId;
        }

        public void setInvoiceId(Integer invoiceId) {
            this.invoiceId = invoiceId;
        }

        public String getInvoiceDate() {
            return invoiceDate;
        }

        public void setInvoiceDate(String invoiceDate) {
            this.invoiceDate = invoiceDate;
        }

        public String getRequestDateTime() {
            return requestDateTime;
        }

        public void setRequestDateTime(String requestDateTime) {
            this.requestDateTime = requestDateTime;
        }

        public Integer getCustomerId() {
            return customerId;
        }

        public void setCustomerId(Integer customerId) {
            this.customerId = customerId;
        }

        public Integer getCatererId() {
            return catererId;
        }

        public void setCatererId(Integer catererId) {
            this.catererId = catererId;
        }

        public Integer getAddressId() {
            return addressId;
        }

        public void setAddressId(Integer addressId) {
            this.addressId = addressId;
        }

        public Object getDeliveryCharge() {
            return deliveryCharge;
        }

        public void setDeliveryCharge(Object deliveryCharge) {
            this.deliveryCharge = deliveryCharge;
        }

        public Object getCateringCharge() {
            return cateringCharge;
        }

        public void setCateringCharge(Object cateringCharge) {
            this.cateringCharge = cateringCharge;
        }

        public Integer getAreaId() {
            return areaId;
        }

        public void setAreaId(Integer areaId) {
            this.areaId = areaId;
        }

        public Object getFemaleService() {
            return femaleService;
        }

        public void setFemaleService(Object femaleService) {
            this.femaleService = femaleService;
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

        public String getBuildingType() {
            return buildingType;
        }

        public void setBuildingType(String buildingType) {
            this.buildingType = buildingType;
        }

        public String getOrderDetails() {
            return orderDetails;
        }

        public void setOrderDetails(String orderDetails) {
            this.orderDetails = orderDetails;
        }

        public String getStreet() {
            return street;
        }

        public void setStreet(String street) {
            this.street = street;
        }

        public String getBuildingNo() {
            return buildingNo;
        }

        public void setBuildingNo(String buildingNo) {
            this.buildingNo = buildingNo;
        }

        public String getCustomerLat() {
            return customerLat;
        }

        public void setCustomerLat(String customerLat) {
            this.customerLat = customerLat;
        }

        public String getCustomerLng() {
            return customerLng;
        }

        public void setCustomerLng(String customerLng) {
            this.customerLng = customerLng;
        }

        public String getPaymentType() {
            return paymentType;
        }

        public void setPaymentType(String paymentType) {
            this.paymentType = paymentType;
        }

        public Object getPaymentId() {
            return paymentId;
        }

        public void setPaymentId(Object paymentId) {
            this.paymentId = paymentId;
        }

        public Object getPaymentDate() {
            return paymentDate;
        }

        public void setPaymentDate(Object paymentDate) {
            this.paymentDate = paymentDate;
        }

        public String getPaymentStatus() {
            return paymentStatus;
        }

        public void setPaymentStatus(String paymentStatus) {
            this.paymentStatus = paymentStatus;
        }

        public Object getCuponCode() {
            return cuponCode;
        }

        public void setCuponCode(Object cuponCode) {
            this.cuponCode = cuponCode;
        }

        public String getOrderStatus() {
            return orderStatus;
        }

        public void setOrderStatus(String orderStatus) {
            this.orderStatus = orderStatus;
        }

        public Integer getOrderSorting() {
            return orderSorting;
        }

        public void setOrderSorting(Integer orderSorting) {
            this.orderSorting = orderSorting;
        }

        public Integer getDeliveryStatus() {
            return deliveryStatus;
        }

        public void setDeliveryStatus(Integer deliveryStatus) {
            this.deliveryStatus = deliveryStatus;
        }

        public Object getDeletedAt() {
            return deletedAt;
        }

        public void setDeletedAt(Object deletedAt) {
            this.deletedAt = deletedAt;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getUpdatedAt() {
            return updatedAt;
        }

        public void setUpdatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
        }

        public String getModeId() {
            return modeId;
        }

        public void setModeId(String modeId) {
            this.modeId = modeId;
        }

        public String getTotalAmount() {
            return totalAmount;
        }

        public void setTotalAmount(String totalAmount) {
            this.totalAmount = totalAmount;
        }

        public List<OrderIteam> getOrderIteam() {
            return orderIteam;
        }

        public void setOrderIteam(List<OrderIteam> orderIteam) {
            this.orderIteam = orderIteam;
        }

    }

    public class Iteam {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("item_code")
        @Expose
        private String itemCode;
        @SerializedName("category_id")
        @Expose
        private String categoryId;
        @SerializedName("subcategory_id")
        @Expose
        private String subcategoryId;
        @SerializedName("organisation")
        @Expose
        private String organisation;
        @SerializedName("item_name")
        @Expose
        private String itemName;
        @SerializedName("item_display_name")
        @Expose
        private String itemDisplayName;
        @SerializedName("item_short_description")
        @Expose
        private String itemShortDescription;
        @SerializedName("item_long_description")
        @Expose
        private String itemLongDescription;
        @SerializedName("item_cost_per_serve")
        @Expose
        private String itemCostPerServe;
        @SerializedName("item_markup_per_serve")
        @Expose
        private String itemMarkupPerServe;
        @SerializedName("item_serving_capacity")
        @Expose
        private String itemServingCapacity;
        @SerializedName("setup_time_in_minute")
        @Expose
        private String setupTimeInMinute;
        @SerializedName("max_time")
        @Expose
        private String maxTime;
        @SerializedName("requirements")
        @Expose
        private String requirements;
        @SerializedName("service_and_presentation")
        @Expose
        private Object serviceAndPresentation;
        @SerializedName("food_details")
        @Expose
        private Object foodDetails;
        @SerializedName("currency_id")
        @Expose
        private String currencyId;
        @SerializedName("item_logo")
        @Expose
        private String itemLogo;
        @SerializedName("item_status")
        @Expose
        private String itemStatus;
        @SerializedName("arabic_item_code")
        @Expose
        private String arabicItemCode;
        @SerializedName("arabic_item_name")
        @Expose
        private String arabicItemName;
        @SerializedName("arabic_item_display_name")
        @Expose
        private String arabicItemDisplayName;
        @SerializedName("arabic_item_short_description")
        @Expose
        private String arabicItemShortDescription;
        @SerializedName("arabic_item_long_description")
        @Expose
        private String arabicItemLongDescription;
        @SerializedName("arabic_item_cost_per_serve")
        @Expose
        private String arabicItemCostPerServe;
        @SerializedName("arabic_item_markup_per_serve")
        @Expose
        private String arabicItemMarkupPerServe;
        @SerializedName("arabic_item_serving_capacity")
        @Expose
        private String arabicItemServingCapacity;
        @SerializedName("arabic_setup_time_in_minute")
        @Expose
        private String arabicSetupTimeInMinute;
        @SerializedName("arabic_max_time")
        @Expose
        private String arabicMaxTime;
        @SerializedName("arabic_requirements")
        @Expose
        private String arabicRequirements;
        @SerializedName("arabic_service_and_presentation")
        @Expose
        private Object arabicServiceAndPresentation;
        @SerializedName("arabic_food_details")
        @Expose
        private Object arabicFoodDetails;
        @SerializedName("status")
        @Expose
        private String status;
        @SerializedName("deleted_at")
        @Expose
        private Object deletedAt;
        @SerializedName("created_at")
        @Expose
        private String createdAt;
        @SerializedName("updated_at")
        @Expose
        private String updatedAt;
        @SerializedName("item_logo_path")
        @Expose
        private String itemLogoPath;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getItemCode() {
            return itemCode;
        }

        public void setItemCode(String itemCode) {
            this.itemCode = itemCode;
        }

        public String getCategoryId() {
            return categoryId;
        }

        public void setCategoryId(String categoryId) {
            this.categoryId = categoryId;
        }

        public String getSubcategoryId() {
            return subcategoryId;
        }

        public void setSubcategoryId(String subcategoryId) {
            this.subcategoryId = subcategoryId;
        }

        public String getOrganisation() {
            return organisation;
        }

        public void setOrganisation(String organisation) {
            this.organisation = organisation;
        }

        public String getItemName() {
            return itemName;
        }

        public void setItemName(String itemName) {
            this.itemName = itemName;
        }

        public String getItemDisplayName() {
            return itemDisplayName;
        }

        public void setItemDisplayName(String itemDisplayName) {
            this.itemDisplayName = itemDisplayName;
        }

        public String getItemShortDescription() {
            return itemShortDescription;
        }

        public void setItemShortDescription(String itemShortDescription) {
            this.itemShortDescription = itemShortDescription;
        }

        public String getItemLongDescription() {
            return itemLongDescription;
        }

        public void setItemLongDescription(String itemLongDescription) {
            this.itemLongDescription = itemLongDescription;
        }

        public String getItemCostPerServe() {
            return itemCostPerServe;
        }

        public void setItemCostPerServe(String itemCostPerServe) {
            this.itemCostPerServe = itemCostPerServe;
        }

        public String getItemMarkupPerServe() {
            return itemMarkupPerServe;
        }

        public void setItemMarkupPerServe(String itemMarkupPerServe) {
            this.itemMarkupPerServe = itemMarkupPerServe;
        }

        public String getItemServingCapacity() {
            return itemServingCapacity;
        }

        public void setItemServingCapacity(String itemServingCapacity) {
            this.itemServingCapacity = itemServingCapacity;
        }

        public String getSetupTimeInMinute() {
            return setupTimeInMinute;
        }

        public void setSetupTimeInMinute(String setupTimeInMinute) {
            this.setupTimeInMinute = setupTimeInMinute;
        }

        public String getMaxTime() {
            return maxTime;
        }

        public void setMaxTime(String maxTime) {
            this.maxTime = maxTime;
        }

        public String getRequirements() {
            return requirements;
        }

        public void setRequirements(String requirements) {
            this.requirements = requirements;
        }

        public Object getServiceAndPresentation() {
            return serviceAndPresentation;
        }

        public void setServiceAndPresentation(Object serviceAndPresentation) {
            this.serviceAndPresentation = serviceAndPresentation;
        }

        public Object getFoodDetails() {
            return foodDetails;
        }

        public void setFoodDetails(Object foodDetails) {
            this.foodDetails = foodDetails;
        }

        public String getCurrencyId() {
            return currencyId;
        }

        public void setCurrencyId(String currencyId) {
            this.currencyId = currencyId;
        }

        public String getItemLogo() {
            return itemLogo;
        }

        public void setItemLogo(String itemLogo) {
            this.itemLogo = itemLogo;
        }

        public String getItemStatus() {
            return itemStatus;
        }

        public void setItemStatus(String itemStatus) {
            this.itemStatus = itemStatus;
        }

        public String getArabicItemCode() {
            return arabicItemCode;
        }

        public void setArabicItemCode(String arabicItemCode) {
            this.arabicItemCode = arabicItemCode;
        }

        public String getArabicItemName() {
            return arabicItemName;
        }

        public void setArabicItemName(String arabicItemName) {
            this.arabicItemName = arabicItemName;
        }

        public String getArabicItemDisplayName() {
            return arabicItemDisplayName;
        }

        public void setArabicItemDisplayName(String arabicItemDisplayName) {
            this.arabicItemDisplayName = arabicItemDisplayName;
        }

        public String getArabicItemShortDescription() {
            return arabicItemShortDescription;
        }

        public void setArabicItemShortDescription(String arabicItemShortDescription) {
            this.arabicItemShortDescription = arabicItemShortDescription;
        }

        public String getArabicItemLongDescription() {
            return arabicItemLongDescription;
        }

        public void setArabicItemLongDescription(String arabicItemLongDescription) {
            this.arabicItemLongDescription = arabicItemLongDescription;
        }

        public String getArabicItemCostPerServe() {
            return arabicItemCostPerServe;
        }

        public void setArabicItemCostPerServe(String arabicItemCostPerServe) {
            this.arabicItemCostPerServe = arabicItemCostPerServe;
        }

        public String getArabicItemMarkupPerServe() {
            return arabicItemMarkupPerServe;
        }

        public void setArabicItemMarkupPerServe(String arabicItemMarkupPerServe) {
            this.arabicItemMarkupPerServe = arabicItemMarkupPerServe;
        }

        public String getArabicItemServingCapacity() {
            return arabicItemServingCapacity;
        }

        public void setArabicItemServingCapacity(String arabicItemServingCapacity) {
            this.arabicItemServingCapacity = arabicItemServingCapacity;
        }

        public String getArabicSetupTimeInMinute() {
            return arabicSetupTimeInMinute;
        }

        public void setArabicSetupTimeInMinute(String arabicSetupTimeInMinute) {
            this.arabicSetupTimeInMinute = arabicSetupTimeInMinute;
        }

        public String getArabicMaxTime() {
            return arabicMaxTime;
        }

        public void setArabicMaxTime(String arabicMaxTime) {
            this.arabicMaxTime = arabicMaxTime;
        }

        public String getArabicRequirements() {
            return arabicRequirements;
        }

        public void setArabicRequirements(String arabicRequirements) {
            this.arabicRequirements = arabicRequirements;
        }

        public Object getArabicServiceAndPresentation() {
            return arabicServiceAndPresentation;
        }

        public void setArabicServiceAndPresentation(Object arabicServiceAndPresentation) {
            this.arabicServiceAndPresentation = arabicServiceAndPresentation;
        }

        public Object getArabicFoodDetails() {
            return arabicFoodDetails;
        }

        public void setArabicFoodDetails(Object arabicFoodDetails) {
            this.arabicFoodDetails = arabicFoodDetails;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public Object getDeletedAt() {
            return deletedAt;
        }

        public void setDeletedAt(Object deletedAt) {
            this.deletedAt = deletedAt;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getUpdatedAt() {
            return updatedAt;
        }

        public void setUpdatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
        }

        public String getItemLogoPath() {
            return itemLogoPath;
        }

        public void setItemLogoPath(String itemLogoPath) {
            this.itemLogoPath = itemLogoPath;
        }

    }
    public class OrderIteam {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("order_id")
        @Expose
        private Integer orderId;
        @SerializedName("item_id")
        @Expose
        private Integer itemId;
        @SerializedName("addon_category_item_id")
        @Expose
        private Object addonCategoryItemId;
        @SerializedName("quantity")
        @Expose
        private Integer quantity;
        @SerializedName("special_instruction")
        @Expose
        private String specialInstruction;
        @SerializedName("mrp")
        @Expose
        private Integer mrp;
        @SerializedName("dis_price")
        @Expose
        private Integer disPrice;
        @SerializedName("sell_price")
        @Expose
        private Integer sellPrice;
        @SerializedName("flat_charges")
        @Expose
        private Integer flatCharges;
        @SerializedName("total_price")
        @Expose
        private Integer totalPrice;
        @SerializedName("deleted_at")
        @Expose
        private Object deletedAt;
        @SerializedName("created_at")
        @Expose
        private String createdAt;
        @SerializedName("updated_at")
        @Expose
        private String updatedAt;
        @SerializedName("item_price")
        @Expose
        private Integer itemPrice;
        @SerializedName("iteam")
        @Expose
        private Iteam iteam;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Integer getOrderId() {
            return orderId;
        }

        public void setOrderId(Integer orderId) {
            this.orderId = orderId;
        }

        public Integer getItemId() {
            return itemId;
        }

        public void setItemId(Integer itemId) {
            this.itemId = itemId;
        }

        public Object getAddonCategoryItemId() {
            return addonCategoryItemId;
        }

        public void setAddonCategoryItemId(Object addonCategoryItemId) {
            this.addonCategoryItemId = addonCategoryItemId;
        }

        public Integer getQuantity() {
            return quantity;
        }

        public void setQuantity(Integer quantity) {
            this.quantity = quantity;
        }

        public String getSpecialInstruction() {
            return specialInstruction;
        }

        public void setSpecialInstruction(String specialInstruction) {
            this.specialInstruction = specialInstruction;
        }

        public Integer getMrp() {
            return mrp;
        }

        public void setMrp(Integer mrp) {
            this.mrp = mrp;
        }

        public Integer getDisPrice() {
            return disPrice;
        }

        public void setDisPrice(Integer disPrice) {
            this.disPrice = disPrice;
        }

        public Integer getSellPrice() {
            return sellPrice;
        }

        public void setSellPrice(Integer sellPrice) {
            this.sellPrice = sellPrice;
        }

        public Integer getFlatCharges() {
            return flatCharges;
        }

        public void setFlatCharges(Integer flatCharges) {
            this.flatCharges = flatCharges;
        }

        public Integer getTotalPrice() {
            return totalPrice;
        }

        public void setTotalPrice(Integer totalPrice) {
            this.totalPrice = totalPrice;
        }

        public Object getDeletedAt() {
            return deletedAt;
        }

        public void setDeletedAt(Object deletedAt) {
            this.deletedAt = deletedAt;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getUpdatedAt() {
            return updatedAt;
        }

        public void setUpdatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
        }

        public Integer getItemPrice() {
            return itemPrice;
        }

        public void setItemPrice(Integer itemPrice) {
            this.itemPrice = itemPrice;
        }

        public Iteam getIteam() {
            return iteam;
        }

        public void setIteam(Iteam iteam) {
            this.iteam = iteam;
        }

    }




//    @SerializedName("status")
//    @Expose
//    private Boolean status;
//    @SerializedName("message")
//    @Expose
//    private String message;
//    @SerializedName("data")
//    @Expose
//    private List<Datum> data = null;
//
//    public Boolean getStatus() {
//        return status;
//    }
//
//    public void setStatus(Boolean status) {
//        this.status = status;
//    }
//
//    public String getMessage() {
//        return message;
//    }
//
//    public void setMessage(String message) {
//        this.message = message;
//    }
//
//    public List<Datum> getData() {
//        return data;
//    }
//
//    public void setData(List<Datum> data) {
//        this.data = data;
//    }
//
//    public class Datum {
//
//        @SerializedName("id")
//        @Expose
//        private Integer id;
//        @SerializedName("invoice_id")
//        @Expose
//        private Integer invoiceId;
//        @SerializedName("invoice_date")
//        @Expose
//        private String invoiceDate;
//        @SerializedName("request_date_time")
//        @Expose
//        private Object requestDateTime;
//        @SerializedName("customer_id")
//        @Expose
//        private Integer customerId;
//        @SerializedName("caterer_id")
//        @Expose
//        private Integer catererId;
//        @SerializedName("address_id")
//        @Expose
//        private Integer addressId;
//        @SerializedName("area_id")
//        @Expose
//        private Integer areaId;
//        @SerializedName("female_service")
//        @Expose
//        private Object femaleService;
//        @SerializedName("title")
//        @Expose
//        private String title;
//        @SerializedName("direction")
//        @Expose
//        private String direction;
//        @SerializedName("building_type")
//        @Expose
//        private String buildingType;
//        @SerializedName("address")
//        @Expose
//        private String address;
//        @SerializedName("street")
//        @Expose
//        private String street;
//        @SerializedName("building_no")
//        @Expose
//        private String buildingNo;
//        @SerializedName("customer_lat")
//        @Expose
//        private String customerLat;
//        @SerializedName("customer_lng")
//        @Expose
//        private String customerLng;
//        @SerializedName("payment_type")
//        @Expose
//        private String paymentType;
//        @SerializedName("cupon_code")
//        @Expose
//        private String cuponCode;
//        @SerializedName("order_status")
//        @Expose
//        private String orderStatus;
//        @SerializedName("order_sorting")
//        @Expose
//        private Integer orderSorting;
//        @SerializedName("delivery_status")
//        @Expose
//        private Integer deliveryStatus;
//        @SerializedName("deleted_at")
//        @Expose
//        private Object deletedAt;
//        @SerializedName("created_at")
//        @Expose
//        private String createdAt;
//        @SerializedName("updated_at")
//        @Expose
//        private String updatedAt;
//        @SerializedName("order_iteam")
//        @Expose
//        private List<Object> orderIteam = null;
//
//        public Integer getId() {
//            return id;
//        }
//
//        public void setId(Integer id) {
//            this.id = id;
//        }
//
//        public Integer getInvoiceId() {
//            return invoiceId;
//        }
//
//        public void setInvoiceId(Integer invoiceId) {
//            this.invoiceId = invoiceId;
//        }
//
//        public String getInvoiceDate() {
//            return invoiceDate;
//        }
//
//        public void setInvoiceDate(String invoiceDate) {
//            this.invoiceDate = invoiceDate;
//        }
//
//        public Object getRequestDateTime() {
//            return requestDateTime;
//        }
//
//        public void setRequestDateTime(Object requestDateTime) {
//            this.requestDateTime = requestDateTime;
//        }
//
//        public Integer getCustomerId() {
//            return customerId;
//        }
//
//        public void setCustomerId(Integer customerId) {
//            this.customerId = customerId;
//        }
//
//        public Integer getCatererId() {
//            return catererId;
//        }
//
//        public void setCatererId(Integer catererId) {
//            this.catererId = catererId;
//        }
//
//        public Integer getAddressId() {
//            return addressId;
//        }
//
//        public void setAddressId(Integer addressId) {
//            this.addressId = addressId;
//        }
//
//        public Integer getAreaId() {
//            return areaId;
//        }
//
//        public void setAreaId(Integer areaId) {
//            this.areaId = areaId;
//        }
//
//        public Object getFemaleService() {
//            return femaleService;
//        }
//
//        public void setFemaleService(Object femaleService) {
//            this.femaleService = femaleService;
//        }
//
//        public String getTitle() {
//            return title;
//        }
//
//        public void setTitle(String title) {
//            this.title = title;
//        }
//
//        public String getDirection() {
//            return direction;
//        }
//
//        public void setDirection(String direction) {
//            this.direction = direction;
//        }
//
//        public String getBuildingType() {
//            return buildingType;
//        }
//
//        public void setBuildingType(String buildingType) {
//            this.buildingType = buildingType;
//        }
//
//        public String getAddress() {
//            return address;
//        }
//
//        public void setAddress(String address) {
//            this.address = address;
//        }
//
//        public String getStreet() {
//            return street;
//        }
//
//        public void setStreet(String street) {
//            this.street = street;
//        }
//
//        public String getBuildingNo() {
//            return buildingNo;
//        }
//
//        public void setBuildingNo(String buildingNo) {
//            this.buildingNo = buildingNo;
//        }
//
//        public String getCustomerLat() {
//            return customerLat;
//        }
//
//        public void setCustomerLat(String customerLat) {
//            this.customerLat = customerLat;
//        }
//
//        public String getCustomerLng() {
//            return customerLng;
//        }
//
//        public void setCustomerLng(String customerLng) {
//            this.customerLng = customerLng;
//        }
//
//        public String getPaymentType() {
//            return paymentType;
//        }
//
//        public void setPaymentType(String paymentType) {
//            this.paymentType = paymentType;
//        }
//
//        public String getCuponCode() {
//            return cuponCode;
//        }
//
//        public void setCuponCode(String cuponCode) {
//            this.cuponCode = cuponCode;
//        }
//
//        public String getOrderStatus() {
//            return orderStatus;
//        }
//
//        public void setOrderStatus(String orderStatus) {
//            this.orderStatus = orderStatus;
//        }
//
//        public Integer getOrderSorting() {
//            return orderSorting;
//        }
//
//        public void setOrderSorting(Integer orderSorting) {
//            this.orderSorting = orderSorting;
//        }
//
//        public Integer getDeliveryStatus() {
//            return deliveryStatus;
//        }
//
//        public void setDeliveryStatus(Integer deliveryStatus) {
//            this.deliveryStatus = deliveryStatus;
//        }
//
//        public Object getDeletedAt() {
//            return deletedAt;
//        }
//
//        public void setDeletedAt(Object deletedAt) {
//            this.deletedAt = deletedAt;
//        }
//
//        public String getCreatedAt() {
//            return createdAt;
//        }
//
//        public void setCreatedAt(String createdAt) {
//            this.createdAt = createdAt;
//        }
//
//        public String getUpdatedAt() {
//            return updatedAt;
//        }
//
//        public void setUpdatedAt(String updatedAt) {
//            this.updatedAt = updatedAt;
//        }
//
//        public List<Object> getOrderIteam() {
//            return orderIteam;
//        }
//
//        public void setOrderIteam(List<Object> orderIteam) {
//            this.orderIteam = orderIteam;
//        }
//
//    }
//
}
