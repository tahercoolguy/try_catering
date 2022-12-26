package com.infovass.catering.activities.cart.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PromoCodeResponse {
    @SerializedName("status")
    @Expose
    private Boolean status;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("data")
    @Expose
    private Data data;

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

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public class Data {

        @SerializedName("item")
        @Expose
        private List<Item> item = null;
        @SerializedName("all_total")
        @Expose
        private float grandTotal;
        @SerializedName("discount_amount")
        @Expose
        private float discountAmount;
        @SerializedName("delivery_chareges")
        @Expose
        private float deliveryChareges;
        @SerializedName("total_amount")
        @Expose
        private float totalAmount;
        @SerializedName("service_charges")
        @Expose
        private float service_charge;

        public float getService_charge() {
            return service_charge;
        }

        public void setService_charge(float service_charge) {
            this.service_charge = service_charge;
        }

        public List<Item> getItem() {
            return item;
        }

        public void setItem(List<Item> item) {
            this.item = item;
        }

        public float getGrandTotal() {
            return grandTotal;
        }

        public void setGrandTotal(float grandTotal) {
            this.grandTotal = grandTotal;
        }

        public float getDiscountAmount() {
            return discountAmount;
        }

        public void setDiscountAmount(float discountAmount) {
            this.discountAmount = discountAmount;
        }

        public float getDeliveryChareges() {
            return deliveryChareges;
        }

        public void setDeliveryChareges(Integer deliveryChareges) {
            this.deliveryChareges = deliveryChareges;
        }

        public float getTotalAmount() {
            return totalAmount;
        }

        public void setTotalAmount(float totalAmount) {
            this.totalAmount = totalAmount;
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
        private String serviceAndPresentation;
        @SerializedName("food_details")
        @Expose
        private String foodDetails;
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
        private String arabicServiceAndPresentation;
        @SerializedName("arabic_food_details")
        @Expose
        private String arabicFoodDetails;
        @SerializedName("status")
        @Expose
        private String status;
        @SerializedName("deleted_at")
        @Expose
        private String deletedAt;
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

        public void setServiceAndPresentation(String serviceAndPresentation) {
            this.serviceAndPresentation = serviceAndPresentation;
        }

        public Object getFoodDetails() {
            return foodDetails;
        }

        public void setFoodDetails(String foodDetails) {
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

        public void setArabicServiceAndPresentation(String arabicServiceAndPresentation) {
            this.arabicServiceAndPresentation = arabicServiceAndPresentation;
        }

        public Object getArabicFoodDetails() {
            return arabicFoodDetails;
        }

        public void setArabicFoodDetails(String arabicFoodDetails) {
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

        public void setDeletedAt(String deletedAt) {
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

    public class Item {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("user_id")
        @Expose
        private Integer userId;
        @SerializedName("caterer_id")
        @Expose
        private Integer catererId;
        @SerializedName("item_id")
        @Expose
        private Integer itemId;
        @SerializedName("cost")
        @Expose
        private Integer cost;
        @SerializedName("quantity")
        @Expose
        private Integer quantity;
        @SerializedName("female_service")
        @Expose
        private Integer femaleService;
        @SerializedName("special_request")
        @Expose
        private String specialRequest;
        @SerializedName("created_at")
        @Expose
        private String createdAt;
        @SerializedName("updated_at")
        @Expose
        private String updatedAt;
        @SerializedName("mode_id")
        @Expose
        private String modeId;
        @SerializedName("total_cost")
        @Expose
        private Integer totalCost;
        @SerializedName("iteam")
        @Expose
        private Iteam iteam;
        @SerializedName("caterer")
        @Expose
        private Caterer caterer;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Integer getUserId() {
            return userId;
        }

        public void setUserId(Integer userId) {
            this.userId = userId;
        }

        public Integer getCatererId() {
            return catererId;
        }

        public void setCatererId(Integer catererId) {
            this.catererId = catererId;
        }

        public Integer getItemId() {
            return itemId;
        }

        public void setItemId(Integer itemId) {
            this.itemId = itemId;
        }

        public Integer getCost() {
            return cost;
        }

        public void setCost(Integer cost) {
            this.cost = cost;
        }

        public Integer getQuantity() {
            return quantity;
        }

        public void setQuantity(Integer quantity) {
            this.quantity = quantity;
        }

        public Integer getFemaleService() {
            return femaleService;
        }

        public void setFemaleService(Integer femaleService) {
            this.femaleService = femaleService;
        }

        public Object getSpecialRequest() {
            return specialRequest;
        }

        public void setSpecialRequest(String specialRequest) {
            this.specialRequest = specialRequest;
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

        public Integer getTotalCost() {
            return totalCost;
        }

        public void setTotalCost(Integer totalCost) {
            this.totalCost = totalCost;
        }

        public Iteam getIteam() {
            return iteam;
        }

        public void setIteam(Iteam iteam) {
            this.iteam = iteam;
        }

        public Caterer getCaterer() {
            return caterer;
        }

        public void setCaterer(Caterer caterer) {
            this.caterer = caterer;
        }

    }

    public class Caterer {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("created_by")
        @Expose
        private Integer createdBy;
        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("arabic_name")
        @Expose
        private String arabicName;
        @SerializedName("detail")
        @Expose
        private String detail;
        @SerializedName("arabic_detail")
        @Expose
        private String arabicDetail;
        @SerializedName("status")
        @Expose
        private String status;
        @SerializedName("female_service")
        @Expose
        private String femaleService;
        @SerializedName("logo")
        @Expose
        private String logo;
        @SerializedName("cover_image")
        @Expose
        private String coverImage;
        @SerializedName("time_show")
        @Expose
        private String timeShow;
        @SerializedName("delivery_charge")
        @Expose
        private Integer deliveryCharge;
        @SerializedName("min_order")
        @Expose
        private String minOrder;
        @SerializedName("setup_time_in_minute")
        @Expose
        private String setupTimeInMinute;
        @SerializedName("requirements")
        @Expose
        private String requirements;
        @SerializedName("arabic_setup_time_in_minute")
        @Expose
        private String arabicSetupTimeInMinute;
        @SerializedName("arabic_requirements")
        @Expose
        private String arabicRequirements;
        @SerializedName("discount_available")
        @Expose
        private String discountAvailable;
        @SerializedName("discount_type")
        @Expose
        private String discountType;
        @SerializedName("discount_value")
        @Expose
        private String discountValue;
        @SerializedName("start_date")
        @Expose
        private String startDate;
        @SerializedName("end_date")
        @Expose
        private String endDate;
        @SerializedName("time")
        @Expose
        private String time;
        @SerializedName("cash_order_policy")
        @Expose
        private String cashOrderPolicy;
        @SerializedName("cancellation_policy")
        @Expose
        private String cancellationPolicy;
        @SerializedName("cancellation_policy_arabic")
        @Expose
        private String cancellationPolicyArabic;
        @SerializedName("is_active")
        @Expose
        private String isActive;
        @SerializedName("created_at")
        @Expose
        private String createdAt;
        @SerializedName("updated_at")
        @Expose
        private String updatedAt;
        @SerializedName("deleted_at")
        @Expose
        private String deletedAt;
        @SerializedName("commission")
        @Expose
        private String commission;
        @SerializedName("minimum_time")
        @Expose
        private String minimumTime;
        @SerializedName("start_time")
        @Expose
        private String startTime;
        @SerializedName("end_time")
        @Expose
        private String endTime;
        @SerializedName("logo_path")
        @Expose
        private String logoPath;
        @SerializedName("cover_image_path")
        @Expose
        private String coverImagePath;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Integer getCreatedBy() {
            return createdBy;
        }

        public void setCreatedBy(Integer createdBy) {
            this.createdBy = createdBy;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getArabicName() {
            return arabicName;
        }

        public void setArabicName(String arabicName) {
            this.arabicName = arabicName;
        }

        public String getDetail() {
            return detail;
        }

        public void setDetail(String detail) {
            this.detail = detail;
        }

        public String getArabicDetail() {
            return arabicDetail;
        }

        public void setArabicDetail(String arabicDetail) {
            this.arabicDetail = arabicDetail;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getFemaleService() {
            return femaleService;
        }

        public void setFemaleService(String femaleService) {
            this.femaleService = femaleService;
        }

        public String getLogo() {
            return logo;
        }

        public void setLogo(String logo) {
            this.logo = logo;
        }

        public String getCoverImage() {
            return coverImage;
        }

        public void setCoverImage(String coverImage) {
            this.coverImage = coverImage;
        }

        public String getTimeShow() {
            return timeShow;
        }

        public void setTimeShow(String timeShow) {
            this.timeShow = timeShow;
        }

        public Integer getDeliveryCharge() {
            return deliveryCharge;
        }

        public void setDeliveryCharge(Integer deliveryCharge) {
            this.deliveryCharge = deliveryCharge;
        }

        public String getMinOrder() {
            return minOrder;
        }

        public void setMinOrder(String minOrder) {
            this.minOrder = minOrder;
        }

        public Object getSetupTimeInMinute() {
            return setupTimeInMinute;
        }

        public void setSetupTimeInMinute(String setupTimeInMinute) {
            this.setupTimeInMinute = setupTimeInMinute;
        }

        public Object getRequirements() {
            return requirements;
        }

        public void setRequirements(String requirements) {
            this.requirements = requirements;
        }

        public Object getArabicSetupTimeInMinute() {
            return arabicSetupTimeInMinute;
        }

        public void setArabicSetupTimeInMinute(String arabicSetupTimeInMinute) {
            this.arabicSetupTimeInMinute = arabicSetupTimeInMinute;
        }

        public Object getArabicRequirements() {
            return arabicRequirements;
        }

        public void setArabicRequirements(String arabicRequirements) {
            this.arabicRequirements = arabicRequirements;
        }

        public String getDiscountAvailable() {
            return discountAvailable;
        }

        public void setDiscountAvailable(String discountAvailable) {
            this.discountAvailable = discountAvailable;
        }

        public String getDiscountType() {
            return discountType;
        }

        public void setDiscountType(String discountType) {
            this.discountType = discountType;
        }

        public Object getDiscountValue() {
            return discountValue;
        }

        public void setDiscountValue(String discountValue) {
            this.discountValue = discountValue;
        }

        public Object getStartDate() {
            return startDate;
        }

        public void setStartDate(String startDate) {
            this.startDate = startDate;
        }

        public Object getEndDate() {
            return endDate;
        }

        public void setEndDate(String endDate) {
            this.endDate = endDate;
        }

        public Object getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public Object getCashOrderPolicy() {
            return cashOrderPolicy;
        }

        public void setCashOrderPolicy(String cashOrderPolicy) {
            this.cashOrderPolicy = cashOrderPolicy;
        }

        public String getCancellationPolicy() {
            return cancellationPolicy;
        }

        public void setCancellationPolicy(String cancellationPolicy) {
            this.cancellationPolicy = cancellationPolicy;
        }

        public String getCancellationPolicyArabic() {
            return cancellationPolicyArabic;
        }

        public void setCancellationPolicyArabic(String cancellationPolicyArabic) {
            this.cancellationPolicyArabic = cancellationPolicyArabic;
        }

        public String getIsActive() {
            return isActive;
        }

        public void setIsActive(String isActive) {
            this.isActive = isActive;
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

        public Object getDeletedAt() {
            return deletedAt;
        }

        public void setDeletedAt(String deletedAt) {
            this.deletedAt = deletedAt;
        }

        public Object getCommission() {
            return commission;
        }

        public void setCommission(String commission) {
            this.commission = commission;
        }

        public Object getMinimumTime() {
            return minimumTime;
        }

        public void setMinimumTime(String minimumTime) {
            this.minimumTime = minimumTime;
        }

        public Object getStartTime() {
            return startTime;
        }

        public void setStartTime(String startTime) {
            this.startTime = startTime;
        }

        public Object getEndTime() {
            return endTime;
        }

        public void setEndTime(String endTime) {
            this.endTime = endTime;
        }

        public String getLogoPath() {
            return logoPath;
        }

        public void setLogoPath(String logoPath) {
            this.logoPath = logoPath;
        }

        public String getCoverImagePath() {
            return coverImagePath;
        }

        public void setCoverImagePath(String coverImagePath) {
            this.coverImagePath = coverImagePath;
        }

    }
}
