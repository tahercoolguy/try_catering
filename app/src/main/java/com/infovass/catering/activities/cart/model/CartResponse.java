package com.infovass.catering.activities.cart.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CartResponse {
//        @SerializedName("status")
//        @Expose
//        private Boolean status;
//        @SerializedName("message")
//        @Expose
//        private String message;
//        @SerializedName("data")
//        @Expose
//        private Data data;
//
//        public Boolean getStatus() {
//            return status;
//        }
//
//        public void setStatus(Boolean status) {
//            this.status = status;
//        }
//
//        public String getMessage() {
//            return message;
//        }
//
//        public void setMessage(String message) {
//            this.message = message;
//        }
//
//        public Data getData() {
//            return data;
//        }
//
//        public void setData(Data data) {
//            this.data = data;
//        }
//
//        public class Data {
//
//            @SerializedName("total_amount")
//            @Expose
//            private Double totalAmount;
//            @SerializedName("discount_amount")
//            @Expose
//            private Integer discountAmount;
//            @SerializedName("service_charges")
//            @Expose
//            private Integer serviceCharges;
//            @SerializedName("addon_total")
//            @Expose
//            private Double addonTotal;
//            @SerializedName("all_total")
//            @Expose
//            private Double allTotal;
//            @SerializedName("main_item")
//            @Expose
//            private List<MainItem> mainItem = null;
//            @SerializedName("address")
//            @Expose
//            private String address;
//
//            public Double getTotalAmount() {
//                return totalAmount;
//            }
//
//            public void setTotalAmount(Double totalAmount) {
//                this.totalAmount = totalAmount;
//            }
//
//            public Integer getDiscountAmount() {
//                return discountAmount;
//            }
//
//            public void setDiscountAmount(Integer discountAmount) {
//                this.discountAmount = discountAmount;
//            }
//
//            public Integer getServiceCharges() {
//                return serviceCharges;
//            }
//
//            public void setServiceCharges(Integer serviceCharges) {
//                this.serviceCharges = serviceCharges;
//            }
//
//            public Double getAddonTotal() {
//                return addonTotal;
//            }
//
//            public void setAddonTotal(Double addonTotal) {
//                this.addonTotal = addonTotal;
//            }
//
//            public Double getAllTotal() {
//                return allTotal;
//            }
//
//            public void setAllTotal(Double allTotal) {
//                this.allTotal = allTotal;
//            }
//
//            public List<MainItem> getMainItem() {
//                return mainItem;
//            }
//
//            public void setMainItem(List<MainItem> mainItem) {
//                this.mainItem = mainItem;
//            }
//
//            public String getAddress() {
//                return address;
//            }
//
//            public void setAddress(String address) {
//                this.address = address;
//            }
//
//        }
//
//    public class AddonIteam {
//
//        @SerializedName("id")
//        @Expose
//        private Integer id;
//        @SerializedName("cart_id")
//        @Expose
//        private Integer cartId;
//        @SerializedName("addon_category_item_id")
//        @Expose
//        private Integer addonCategoryItemId;
//        @SerializedName("caterer_item_addon_id")
//        @Expose
//        private Integer catererItemAddonId;
//        @SerializedName("quantity")
//        @Expose
//        private Integer quantity;
//        @SerializedName("price")
//        @Expose
//        private String price;
//        @SerializedName("created_at")
//        @Expose
//        private String createdAt;
//        @SerializedName("updated_at")
//        @Expose
//        private String updatedAt;
//        @SerializedName("total_price")
//        @Expose
//        private Double totalPrice;
//        @SerializedName("item")
//        @Expose
//        private Item item;
//
//        public Integer getId() {
//            return id;
//        }
//
//        public void setId(Integer id) {
//            this.id = id;
//        }
//
//        public Integer getCartId() {
//            return cartId;
//        }
//
//        public void setCartId(Integer cartId) {
//            this.cartId = cartId;
//        }
//
//        public Integer getAddonCategoryItemId() {
//            return addonCategoryItemId;
//        }
//
//        public void setAddonCategoryItemId(Integer addonCategoryItemId) {
//            this.addonCategoryItemId = addonCategoryItemId;
//        }
//
//        public Integer getCatererItemAddonId() {
//            return catererItemAddonId;
//        }
//
//        public void setCatererItemAddonId(Integer catererItemAddonId) {
//            this.catererItemAddonId = catererItemAddonId;
//        }
//
//        public Integer getQuantity() {
//            return quantity;
//        }
//
//        public void setQuantity(Integer quantity) {
//            this.quantity = quantity;
//        }
//
//        public String getPrice() {
//            return price;
//        }
//
//        public void setPrice(String price) {
//            this.price = price;
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
//        public Double getTotalPrice() {
//            return totalPrice;
//        }
//
//        public void setTotalPrice(Double totalPrice) {
//            this.totalPrice = totalPrice;
//        }
//
//        public Item getItem() {
//            return item;
//        }
//
//        public void setItem(Item item) {
//            this.item = item;
//        }
//
//    }
//
//    public class Caterer {
//
//        @SerializedName("id")
//        @Expose
//        private Integer id;
//        @SerializedName("created_by")
//        @Expose
//        private Integer createdBy;
//        @SerializedName("name")
//        @Expose
//        private String name;
//        @SerializedName("arabic_name")
//        @Expose
//        private String arabicName;
//        @SerializedName("detail")
//        @Expose
//        private String detail;
//        @SerializedName("arabic_detail")
//        @Expose
//        private String arabicDetail;
//        @SerializedName("status")
//        @Expose
//        private String status;
//        @SerializedName("female_service")
//        @Expose
//        private String femaleService;
//        @SerializedName("logo")
//        @Expose
//        private String logo;
//        @SerializedName("cover_image")
//        @Expose
//        private String coverImage;
//        @SerializedName("time_show")
//        @Expose
//        private String timeShow;
//        @SerializedName("delivery_charge")
//        @Expose
//        private String deliveryCharge;
//        @SerializedName("min_order")
//        @Expose
//        private String minOrder;
//        @SerializedName("setup_time_in_minute")
//        @Expose
//        private Object setupTimeInMinute;
//        @SerializedName("requirements")
//        @Expose
//        private Object requirements;
//        @SerializedName("arabic_setup_time_in_minute")
//        @Expose
//        private Object arabicSetupTimeInMinute;
//        @SerializedName("arabic_requirements")
//        @Expose
//        private Object arabicRequirements;
//        @SerializedName("discount_available")
//        @Expose
//        private String discountAvailable;
//        @SerializedName("discount_type")
//        @Expose
//        private String discountType;
//        @SerializedName("discount_value")
//        @Expose
//        private Object discountValue;
//        @SerializedName("start_date")
//        @Expose
//        private Object startDate;
//        @SerializedName("end_date")
//        @Expose
//        private Object endDate;
//        @SerializedName("time")
//        @Expose
//        private Object time;
//        @SerializedName("cash_order_policy")
//        @Expose
//        private Object cashOrderPolicy;
//        @SerializedName("cancellation_policy")
//        @Expose
//        private String cancellationPolicy;
//        @SerializedName("cancellation_policy_arabic")
//        @Expose
//        private String cancellationPolicyArabic;
//        @SerializedName("is_active")
//        @Expose
//        private String isActive;
//        @SerializedName("created_at")
//        @Expose
//        private String createdAt;
//        @SerializedName("updated_at")
//        @Expose
//        private String updatedAt;
//        @SerializedName("deleted_at")
//        @Expose
//        private Object deletedAt;
//        @SerializedName("commission")
//        @Expose
//        private String commission;
//        @SerializedName("minimum_time")
//        @Expose
//        private String minimumTime;
//        @SerializedName("start_time")
//        @Expose
//        private String startTime;
//        @SerializedName("end_time")
//        @Expose
//        private String endTime;
//        @SerializedName("logo_path")
//        @Expose
//        private String logoPath;
//        @SerializedName("cover_image_path")
//        @Expose
//        private String coverImagePath;
//
//        public Integer getId() {
//            return id;
//        }
//
//        public void setId(Integer id) {
//            this.id = id;
//        }
//
//        public Integer getCreatedBy() {
//            return createdBy;
//        }
//
//        public void setCreatedBy(Integer createdBy) {
//            this.createdBy = createdBy;
//        }
//
//        public String getName() {
//            return name;
//        }
//
//        public void setName(String name) {
//            this.name = name;
//        }
//
//        public String getArabicName() {
//            return arabicName;
//        }
//
//        public void setArabicName(String arabicName) {
//            this.arabicName = arabicName;
//        }
//
//        public String getDetail() {
//            return detail;
//        }
//
//        public void setDetail(String detail) {
//            this.detail = detail;
//        }
//
//        public String getArabicDetail() {
//            return arabicDetail;
//        }
//
//        public void setArabicDetail(String arabicDetail) {
//            this.arabicDetail = arabicDetail;
//        }
//
//        public String getStatus() {
//            return status;
//        }
//
//        public void setStatus(String status) {
//            this.status = status;
//        }
//
//        public String getFemaleService() {
//            return femaleService;
//        }
//
//        public void setFemaleService(String femaleService) {
//            this.femaleService = femaleService;
//        }
//
//        public String getLogo() {
//            return logo;
//        }
//
//        public void setLogo(String logo) {
//            this.logo = logo;
//        }
//
//        public String getCoverImage() {
//            return coverImage;
//        }
//
//        public void setCoverImage(String coverImage) {
//            this.coverImage = coverImage;
//        }
//
//        public String getTimeShow() {
//            return timeShow;
//        }
//
//        public void setTimeShow(String timeShow) {
//            this.timeShow = timeShow;
//        }
//
//        public String getDeliveryCharge() {
//            return deliveryCharge;
//        }
//
//        public void setDeliveryCharge(String deliveryCharge) {
//            this.deliveryCharge = deliveryCharge;
//        }
//
//        public String getMinOrder() {
//            return minOrder;
//        }
//
//        public void setMinOrder(String minOrder) {
//            this.minOrder = minOrder;
//        }
//
//        public Object getSetupTimeInMinute() {
//            return setupTimeInMinute;
//        }
//
//        public void setSetupTimeInMinute(Object setupTimeInMinute) {
//            this.setupTimeInMinute = setupTimeInMinute;
//        }
//
//        public Object getRequirements() {
//            return requirements;
//        }
//
//        public void setRequirements(Object requirements) {
//            this.requirements = requirements;
//        }
//
//        public Object getArabicSetupTimeInMinute() {
//            return arabicSetupTimeInMinute;
//        }
//
//        public void setArabicSetupTimeInMinute(Object arabicSetupTimeInMinute) {
//            this.arabicSetupTimeInMinute = arabicSetupTimeInMinute;
//        }
//
//        public Object getArabicRequirements() {
//            return arabicRequirements;
//        }
//
//        public void setArabicRequirements(Object arabicRequirements) {
//            this.arabicRequirements = arabicRequirements;
//        }
//
//        public String getDiscountAvailable() {
//            return discountAvailable;
//        }
//
//        public void setDiscountAvailable(String discountAvailable) {
//            this.discountAvailable = discountAvailable;
//        }
//
//        public String getDiscountType() {
//            return discountType;
//        }
//
//        public void setDiscountType(String discountType) {
//            this.discountType = discountType;
//        }
//
//        public Object getDiscountValue() {
//            return discountValue;
//        }
//
//        public void setDiscountValue(Object discountValue) {
//            this.discountValue = discountValue;
//        }
//
//        public Object getStartDate() {
//            return startDate;
//        }
//
//        public void setStartDate(Object startDate) {
//            this.startDate = startDate;
//        }
//
//        public Object getEndDate() {
//            return endDate;
//        }
//
//        public void setEndDate(Object endDate) {
//            this.endDate = endDate;
//        }
//
//        public Object getTime() {
//            return time;
//        }
//
//        public void setTime(Object time) {
//            this.time = time;
//        }
//
//        public Object getCashOrderPolicy() {
//            return cashOrderPolicy;
//        }
//
//        public void setCashOrderPolicy(Object cashOrderPolicy) {
//            this.cashOrderPolicy = cashOrderPolicy;
//        }
//
//        public String getCancellationPolicy() {
//            return cancellationPolicy;
//        }
//
//        public void setCancellationPolicy(String cancellationPolicy) {
//            this.cancellationPolicy = cancellationPolicy;
//        }
//
//        public String getCancellationPolicyArabic() {
//            return cancellationPolicyArabic;
//        }
//
//        public void setCancellationPolicyArabic(String cancellationPolicyArabic) {
//            this.cancellationPolicyArabic = cancellationPolicyArabic;
//        }
//
//        public String getIsActive() {
//            return isActive;
//        }
//
//        public void setIsActive(String isActive) {
//            this.isActive = isActive;
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
//        public Object getDeletedAt() {
//            return deletedAt;
//        }
//
//        public void setDeletedAt(Object deletedAt) {
//            this.deletedAt = deletedAt;
//        }
//
//        public String getCommission() {
//            return commission;
//        }
//
//        public void setCommission(String commission) {
//            this.commission = commission;
//        }
//
//        public String getMinimumTime() {
//            return minimumTime;
//        }
//
//        public void setMinimumTime(String minimumTime) {
//            this.minimumTime = minimumTime;
//        }
//
//        public String getStartTime() {
//            return startTime;
//        }
//
//        public void setStartTime(String startTime) {
//            this.startTime = startTime;
//        }
//
//        public String getEndTime() {
//            return endTime;
//        }
//
//        public void setEndTime(String endTime) {
//            this.endTime = endTime;
//        }
//
//        public String getLogoPath() {
//            return logoPath;
//        }
//
//        public void setLogoPath(String logoPath) {
//            this.logoPath = logoPath;
//        }
//
//        public String getCoverImagePath() {
//            return coverImagePath;
//        }
//
//        public void setCoverImagePath(String coverImagePath) {
//            this.coverImagePath = coverImagePath;
//        }
//
//    }
//
//    public class Iteam {
//
//        @SerializedName("id")
//        @Expose
//        private Integer id;
//        @SerializedName("item_code")
//        @Expose
//        private String itemCode;
//        @SerializedName("category_id")
//        @Expose
//        private String categoryId;
//        @SerializedName("subcategory_id")
//        @Expose
//        private String subcategoryId;
//        @SerializedName("organisation")
//        @Expose
//        private String organisation;
//        @SerializedName("item_name")
//        @Expose
//        private String itemName;
//        @SerializedName("item_display_name")
//        @Expose
//        private String itemDisplayName;
//        @SerializedName("item_short_description")
//        @Expose
//        private String itemShortDescription;
//        @SerializedName("item_long_description")
//        @Expose
//        private String itemLongDescription;
//        @SerializedName("item_cost_per_serve")
//        @Expose
//        private String itemCostPerServe;
//        @SerializedName("item_markup_per_serve")
//        @Expose
//        private String itemMarkupPerServe;
//        @SerializedName("item_serving_capacity")
//        @Expose
//        private String itemServingCapacity;
//        @SerializedName("setup_time_in_minute")
//        @Expose
//        private String setupTimeInMinute;
//        @SerializedName("max_time")
//        @Expose
//        private String maxTime;
//        @SerializedName("requirements")
//        @Expose
//        private String requirements;
//        @SerializedName("service_and_presentation")
//        @Expose
//        private Object serviceAndPresentation;
//        @SerializedName("food_details")
//        @Expose
//        private Object foodDetails;
//        @SerializedName("currency_id")
//        @Expose
//        private String currencyId;
//        @SerializedName("item_logo")
//        @Expose
//        private String itemLogo;
//        @SerializedName("item_status")
//        @Expose
//        private String itemStatus;
//        @SerializedName("arabic_item_code")
//        @Expose
//        private String arabicItemCode;
//        @SerializedName("arabic_item_name")
//        @Expose
//        private String arabicItemName;
//        @SerializedName("arabic_item_display_name")
//        @Expose
//        private String arabicItemDisplayName;
//        @SerializedName("arabic_item_short_description")
//        @Expose
//        private String arabicItemShortDescription;
//        @SerializedName("arabic_item_long_description")
//        @Expose
//        private String arabicItemLongDescription;
//        @SerializedName("arabic_item_cost_per_serve")
//        @Expose
//        private String arabicItemCostPerServe;
//        @SerializedName("arabic_item_markup_per_serve")
//        @Expose
//        private String arabicItemMarkupPerServe;
//        @SerializedName("arabic_item_serving_capacity")
//        @Expose
//        private String arabicItemServingCapacity;
//        @SerializedName("arabic_setup_time_in_minute")
//        @Expose
//        private String arabicSetupTimeInMinute;
//        @SerializedName("arabic_max_time")
//        @Expose
//        private String arabicMaxTime;
//        @SerializedName("arabic_requirements")
//        @Expose
//        private String arabicRequirements;
//        @SerializedName("arabic_service_and_presentation")
//        @Expose
//        private Object arabicServiceAndPresentation;
//        @SerializedName("arabic_food_details")
//        @Expose
//        private Object arabicFoodDetails;
//        @SerializedName("status")
//        @Expose
//        private String status;
//        @SerializedName("deleted_at")
//        @Expose
//        private Object deletedAt;
//        @SerializedName("created_at")
//        @Expose
//        private String createdAt;
//        @SerializedName("updated_at")
//        @Expose
//        private String updatedAt;
//        @SerializedName("item_logo_path")
//        @Expose
//        private String itemLogoPath;
//
//        public Integer getId() {
//            return id;
//        }
//
//        public void setId(Integer id) {
//            this.id = id;
//        }
//
//        public String getItemCode() {
//            return itemCode;
//        }
//
//        public void setItemCode(String itemCode) {
//            this.itemCode = itemCode;
//        }
//
//        public String getCategoryId() {
//            return categoryId;
//        }
//
//        public void setCategoryId(String categoryId) {
//            this.categoryId = categoryId;
//        }
//
//        public String getSubcategoryId() {
//            return subcategoryId;
//        }
//
//        public void setSubcategoryId(String subcategoryId) {
//            this.subcategoryId = subcategoryId;
//        }
//
//        public String getOrganisation() {
//            return organisation;
//        }
//
//        public void setOrganisation(String organisation) {
//            this.organisation = organisation;
//        }
//
//        public String getItemName() {
//            return itemName;
//        }
//
//        public void setItemName(String itemName) {
//            this.itemName = itemName;
//        }
//
//        public String getItemDisplayName() {
//            return itemDisplayName;
//        }
//
//        public void setItemDisplayName(String itemDisplayName) {
//            this.itemDisplayName = itemDisplayName;
//        }
//
//        public String getItemShortDescription() {
//            return itemShortDescription;
//        }
//
//        public void setItemShortDescription(String itemShortDescription) {
//            this.itemShortDescription = itemShortDescription;
//        }
//
//        public String getItemLongDescription() {
//            return itemLongDescription;
//        }
//
//        public void setItemLongDescription(String itemLongDescription) {
//            this.itemLongDescription = itemLongDescription;
//        }
//
//        public String getItemCostPerServe() {
//            return itemCostPerServe;
//        }
//
//        public void setItemCostPerServe(String itemCostPerServe) {
//            this.itemCostPerServe = itemCostPerServe;
//        }
//
//        public String getItemMarkupPerServe() {
//            return itemMarkupPerServe;
//        }
//
//        public void setItemMarkupPerServe(String itemMarkupPerServe) {
//            this.itemMarkupPerServe = itemMarkupPerServe;
//        }
//
//        public String getItemServingCapacity() {
//            return itemServingCapacity;
//        }
//
//        public void setItemServingCapacity(String itemServingCapacity) {
//            this.itemServingCapacity = itemServingCapacity;
//        }
//
//        public String getSetupTimeInMinute() {
//            return setupTimeInMinute;
//        }
//
//        public void setSetupTimeInMinute(String setupTimeInMinute) {
//            this.setupTimeInMinute = setupTimeInMinute;
//        }
//
//        public String getMaxTime() {
//            return maxTime;
//        }
//
//        public void setMaxTime(String maxTime) {
//            this.maxTime = maxTime;
//        }
//
//        public String getRequirements() {
//            return requirements;
//        }
//
//        public void setRequirements(String requirements) {
//            this.requirements = requirements;
//        }
//
//        public Object getServiceAndPresentation() {
//            return serviceAndPresentation;
//        }
//
//        public void setServiceAndPresentation(Object serviceAndPresentation) {
//            this.serviceAndPresentation = serviceAndPresentation;
//        }
//
//        public Object getFoodDetails() {
//            return foodDetails;
//        }
//
//        public void setFoodDetails(Object foodDetails) {
//            this.foodDetails = foodDetails;
//        }
//
//        public String getCurrencyId() {
//            return currencyId;
//        }
//
//        public void setCurrencyId(String currencyId) {
//            this.currencyId = currencyId;
//        }
//
//        public String getItemLogo() {
//            return itemLogo;
//        }
//
//        public void setItemLogo(String itemLogo) {
//            this.itemLogo = itemLogo;
//        }
//
//        public String getItemStatus() {
//            return itemStatus;
//        }
//
//        public void setItemStatus(String itemStatus) {
//            this.itemStatus = itemStatus;
//        }
//
//        public String getArabicItemCode() {
//            return arabicItemCode;
//        }
//
//        public void setArabicItemCode(String arabicItemCode) {
//            this.arabicItemCode = arabicItemCode;
//        }
//
//        public String getArabicItemName() {
//            return arabicItemName;
//        }
//
//        public void setArabicItemName(String arabicItemName) {
//            this.arabicItemName = arabicItemName;
//        }
//
//        public String getArabicItemDisplayName() {
//            return arabicItemDisplayName;
//        }
//
//        public void setArabicItemDisplayName(String arabicItemDisplayName) {
//            this.arabicItemDisplayName = arabicItemDisplayName;
//        }
//
//        public String getArabicItemShortDescription() {
//            return arabicItemShortDescription;
//        }
//
//        public void setArabicItemShortDescription(String arabicItemShortDescription) {
//            this.arabicItemShortDescription = arabicItemShortDescription;
//        }
//
//        public String getArabicItemLongDescription() {
//            return arabicItemLongDescription;
//        }
//
//        public void setArabicItemLongDescription(String arabicItemLongDescription) {
//            this.arabicItemLongDescription = arabicItemLongDescription;
//        }
//
//        public String getArabicItemCostPerServe() {
//            return arabicItemCostPerServe;
//        }
//
//        public void setArabicItemCostPerServe(String arabicItemCostPerServe) {
//            this.arabicItemCostPerServe = arabicItemCostPerServe;
//        }
//
//        public String getArabicItemMarkupPerServe() {
//            return arabicItemMarkupPerServe;
//        }
//
//        public void setArabicItemMarkupPerServe(String arabicItemMarkupPerServe) {
//            this.arabicItemMarkupPerServe = arabicItemMarkupPerServe;
//        }
//
//        public String getArabicItemServingCapacity() {
//            return arabicItemServingCapacity;
//        }
//
//        public void setArabicItemServingCapacity(String arabicItemServingCapacity) {
//            this.arabicItemServingCapacity = arabicItemServingCapacity;
//        }
//
//        public String getArabicSetupTimeInMinute() {
//            return arabicSetupTimeInMinute;
//        }
//
//        public void setArabicSetupTimeInMinute(String arabicSetupTimeInMinute) {
//            this.arabicSetupTimeInMinute = arabicSetupTimeInMinute;
//        }
//
//        public String getArabicMaxTime() {
//            return arabicMaxTime;
//        }
//
//        public void setArabicMaxTime(String arabicMaxTime) {
//            this.arabicMaxTime = arabicMaxTime;
//        }
//
//        public String getArabicRequirements() {
//            return arabicRequirements;
//        }
//
//        public void setArabicRequirements(String arabicRequirements) {
//            this.arabicRequirements = arabicRequirements;
//        }
//
//        public Object getArabicServiceAndPresentation() {
//            return arabicServiceAndPresentation;
//        }
//
//        public void setArabicServiceAndPresentation(Object arabicServiceAndPresentation) {
//            this.arabicServiceAndPresentation = arabicServiceAndPresentation;
//        }
//
//        public Object getArabicFoodDetails() {
//            return arabicFoodDetails;
//        }
//
//        public void setArabicFoodDetails(Object arabicFoodDetails) {
//            this.arabicFoodDetails = arabicFoodDetails;
//        }
//
//        public String getStatus() {
//            return status;
//        }
//
//        public void setStatus(String status) {
//            this.status = status;
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
//        public String getItemLogoPath() {
//            return itemLogoPath;
//        }
//
//        public void setItemLogoPath(String itemLogoPath) {
//            this.itemLogoPath = itemLogoPath;
//        }
//
//    }
//
//    public class Item {
//
//        @SerializedName("id")
//        @Expose
//        private Integer id;
//        @SerializedName("category_id")
//        @Expose
//        private Integer categoryId;
//        @SerializedName("caterer_id")
//        @Expose
//        private Integer catererId;
//        @SerializedName("title")
//        @Expose
//        private String title;
//        @SerializedName("arabic_title")
//        @Expose
//        private String arabicTitle;
//        @SerializedName("description")
//        @Expose
//        private Object description;
//        @SerializedName("image")
//        @Expose
//        private Object image;
//        @SerializedName("status")
//        @Expose
//        private String status;
//        @SerializedName("deleted_at")
//        @Expose
//        private Object deletedAt;
//        @SerializedName("created_at")
//        @Expose
//        private String createdAt;
//        @SerializedName("updated_at")
//        @Expose
//        private String updatedAt;
//        @SerializedName("image_path")
//        @Expose
//        private String imagePath;
//
//        public Integer getId() {
//            return id;
//        }
//
//        public void setId(Integer id) {
//            this.id = id;
//        }
//
//        public Integer getCategoryId() {
//            return categoryId;
//        }
//
//        public void setCategoryId(Integer categoryId) {
//            this.categoryId = categoryId;
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
//        public String getTitle() {
//            return title;
//        }
//
//        public void setTitle(String title) {
//            this.title = title;
//        }
//
//        public String getArabicTitle() {
//            return arabicTitle;
//        }
//
//        public void setArabicTitle(String arabicTitle) {
//            this.arabicTitle = arabicTitle;
//        }
//
//        public Object getDescription() {
//            return description;
//        }
//
//        public void setDescription(Object description) {
//            this.description = description;
//        }
//
//        public Object getImage() {
//            return image;
//        }
//
//        public void setImage(Object image) {
//            this.image = image;
//        }
//
//        public String getStatus() {
//            return status;
//        }
//
//        public void setStatus(String status) {
//            this.status = status;
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
//        public String getImagePath() {
//            return imagePath;
//        }
//
//        public void setImagePath(String imagePath) {
//            this.imagePath = imagePath;
//        }
//
//    }
//
//    public class MainItem {
//
//        @SerializedName("id")
//        @Expose
//        private Integer id;
//        @SerializedName("user_id")
//        @Expose
//        private Integer userId;
//        @SerializedName("caterer_id")
//        @Expose
//        private Integer catererId;
//        @SerializedName("item_id")
//        @Expose
//        private Integer itemId;
//        @SerializedName("cost")
//        @Expose
//        private Integer cost;
//        @SerializedName("quantity")
//        @Expose
//        private Integer quantity;
//        @SerializedName("female_service")
//        @Expose
//        private Integer femaleService;
//        @SerializedName("special_request")
//        @Expose
//        private Object specialRequest;
//        @SerializedName("created_at")
//        @Expose
//        private String createdAt;
//        @SerializedName("updated_at")
//        @Expose
//        private String updatedAt;
//        @SerializedName("mode_id")
//        @Expose
//        private String modeId;
//        @SerializedName("addon_total")
//        @Expose
//        private Double addonTotal;
//        @SerializedName("total_cost")
//        @Expose
//        private Integer totalCost;
//        @SerializedName("iteam")
//        @Expose
//        private Iteam iteam;
//        @SerializedName("addon_iteam")
//        @Expose
//        private List<AddonIteam> addonIteam = null;
//        @SerializedName("meals")
//        @Expose
//        private List<Object> meals = null;
//        @SerializedName("caterer")
//        @Expose
//        private Caterer caterer;
//
//        public Integer getId() {
//            return id;
//        }
//
//        public void setId(Integer id) {
//            this.id = id;
//        }
//
//        public Integer getUserId() {
//            return userId;
//        }
//
//        public void setUserId(Integer userId) {
//            this.userId = userId;
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
//        public Integer getItemId() {
//            return itemId;
//        }
//
//        public void setItemId(Integer itemId) {
//            this.itemId = itemId;
//        }
//
//        public Integer getCost() {
//            return cost;
//        }
//
//        public void setCost(Integer cost) {
//            this.cost = cost;
//        }
//
//        public Integer getQuantity() {
//            return quantity;
//        }
//
//        public void setQuantity(Integer quantity) {
//            this.quantity = quantity;
//        }
//
//        public Integer getFemaleService() {
//            return femaleService;
//        }
//
//        public void setFemaleService(Integer femaleService) {
//            this.femaleService = femaleService;
//        }
//
//        public Object getSpecialRequest() {
//            return specialRequest;
//        }
//
//        public void setSpecialRequest(Object specialRequest) {
//            this.specialRequest = specialRequest;
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
//        public String getModeId() {
//            return modeId;
//        }
//
//        public void setModeId(String modeId) {
//            this.modeId = modeId;
//        }
//
//        public Double getAddonTotal() {
//            return addonTotal;
//        }
//
//        public void setAddonTotal(Double addonTotal) {
//            this.addonTotal = addonTotal;
//        }
//
//        public Integer getTotalCost() {
//            return totalCost;
//        }
//
//        public void setTotalCost(Integer totalCost) {
//            this.totalCost = totalCost;
//        }
//
//        public Iteam getIteam() {
//            return iteam;
//        }
//
//        public void setIteam(Iteam iteam) {
//            this.iteam = iteam;
//        }
//
//        public List<AddonIteam> getAddonIteam() {
//            return addonIteam;
//        }
//
//        public void setAddonIteam(List<AddonIteam> addonIteam) {
//            this.addonIteam = addonIteam;
//        }
//
//        public List<Object> getMeals() {
//            return meals;
//        }
//
//        public void setMeals(List<Object> meals) {
//            this.meals = meals;
//        }
//
//        public Caterer getCaterer() {
//            return caterer;
//        }
//
//        public void setCaterer(Caterer caterer) {
//            this.caterer = caterer;
//        }
//
//    }
//
//    }






//old response

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

        @SerializedName("total_amount")
        @Expose
        private float totalAmount;
        @SerializedName("addon_total")
        @Expose
        private float addonTotal;
        @SerializedName("all_total")
        @Expose
        private float allTotal;
        @SerializedName("main_item")
        @Expose
        private List<MainItem> mainItem = null;
        @SerializedName("address")
        @Expose
        private Address address;
        @SerializedName("service_charges")
        @Expose
        private String service_charges;

        @SerializedName("discount_amount")
        @Expose
        private String discount_amount;

        public String getDiscount_amount() {
            return discount_amount;
        }

        public void setDiscount_amount(String discount_amount) {
            this.discount_amount = discount_amount;
        }

        public String getService_charges() {
            return service_charges;
        }

        public void setService_charges(String service_charges) {
            this.service_charges = service_charges;
        }

        public float getTotalAmount() {
            return totalAmount;
        }

        public void setTotalAmount(float totalAmount) {
            this.totalAmount = totalAmount;
        }

        public float getAddonTotal() {
            return addonTotal;
        }

        public void setAddonTotal(float addonTotal) {
            this.addonTotal = addonTotal;
        }

        public float getAllTotal() {
            return allTotal;
        }

        public void setAllTotal(float allTotal) {
            this.allTotal = allTotal;
        }

        public List<MainItem> getMainItem() {
            return mainItem;
        }

        public void setMainItem(List<MainItem> mainItem) {
            this.mainItem = mainItem;
        }

        public Address getAddress() {
            return address;
        }

        public void setAddress(Address address) {
            this.address = address;
        }

        public class Address {

            @SerializedName("id")
            @Expose
            private Integer id;
            @SerializedName("user_id")
            @Expose
            private Integer userId;
            @SerializedName("first_name")
            @Expose
            private String firstName;
            @SerializedName("last_name")
            @Expose
            private String lastName;
            @SerializedName("house_no")
            @Expose
            private String houseNo;
            @SerializedName("contact_no")
            @Expose
            private String contactNo;
            @SerializedName("appartment")
            @Expose
            private String appartment;
            @SerializedName("landmark")
            @Expose
            private String landmark;
            @SerializedName("pincode")
            @Expose
            private String pincode;
            @SerializedName("address_type")
            @Expose
            private String addressType;
            @SerializedName("city")
            @Expose
            private String city;
            @SerializedName("area")
            @Expose
            private String area;
            @SerializedName("address")
            @Expose
            private String address;
            @SerializedName("piece")
            @Expose
            private String piece;
            @SerializedName("avenue")
            @Expose
            private String avenue;
            @SerializedName("street")
            @Expose
            private String street;
            @SerializedName("lat")
            @Expose
            private String lat;
            @SerializedName("lng")
            @Expose
            private String lng;
            @SerializedName("city_id")
            @Expose
            private Integer cityId;
            @SerializedName("area_id")
            @Expose
            private Integer areaId;
            @SerializedName("status")
            @Expose
            private String status;
            @SerializedName("is_default")
            @Expose
            private String isDefault;
            @SerializedName("deleted_at")
            @Expose
            private String deletedAt;
            @SerializedName("created_at")
            @Expose
            private String createdAt;
            @SerializedName("updated_at")
            @Expose
            private String updatedAt;
            @SerializedName("full_address")
            @Expose
            private String fullAddress;

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

            public String getFirstName() {
                return firstName;
            }

            public void setFirstName(String firstName) {
                this.firstName = firstName;
            }

            public String getLastName() {
                return lastName;
            }

            public void setLastName(String lastName) {
                this.lastName = lastName;
            }

            public String getHouseNo() {
                return houseNo;
            }

            public void setHouseNo(String houseNo) {
                this.houseNo = houseNo;
            }

            public String getContactNo() {
                return contactNo;
            }

            public void setContactNo(String contactNo) {
                this.contactNo = contactNo;
            }

            public String getAppartment() {
                return appartment;
            }

            public void setAppartment(String appartment) {
                this.appartment = appartment;
            }

            public String getLandmark() {
                return landmark;
            }

            public void setLandmark(String landmark) {
                this.landmark = landmark;
            }

            public String getPincode() {
                return pincode;
            }

            public void setPincode(String pincode) {
                this.pincode = pincode;
            }

            public String getAddressType() {
                return addressType;
            }

            public void setAddressType(String addressType) {
                this.addressType = addressType;
            }

            public String getCity() {
                return city;
            }

            public void setCity(String city) {
                this.city = city;
            }

            public String getArea() {
                return area;
            }

            public void setArea(String area) {
                this.area = area;
            }

            public String getAddress() {
                return address;
            }

            public void setAddress(String address) {
                this.address = address;
            }

            public String getPiece() {
                return piece;
            }

            public void setPiece(String piece) {
                this.piece = piece;
            }

            public String getAvenue() {
                return avenue;
            }

            public void setAvenue(String avenue) {
                this.avenue = avenue;
            }

            public String getStreet() {
                return street;
            }

            public void setStreet(String street) {
                this.street = street;
            }

            public String getLat() {
                return lat;
            }

            public void setLat(String lat) {
                this.lat = lat;
            }

            public String getLng() {
                return lng;
            }

            public void setLng(String lng) {
                this.lng = lng;
            }

            public Integer getCityId() {
                return cityId;
            }

            public void setCityId(Integer cityId) {
                this.cityId = cityId;
            }

            public Integer getAreaId() {
                return areaId;
            }

            public void setAreaId(Integer areaId) {
                this.areaId = areaId;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public String getIsDefault() {
                return isDefault;
            }

            public void setIsDefault(String isDefault) {
                this.isDefault = isDefault;
            }

            public String getDeletedAt() {
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

            public String getFullAddress() {
                return fullAddress;
            }

            public void setFullAddress(String fullAddress) {
                this.fullAddress = fullAddress;
            }

        }

        public class MainItem {

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
            private float cost;
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
            @SerializedName("addon_total")
            @Expose
            private float addonTotal;
            @SerializedName("total_cost")
            @Expose
            private float totalCost;
            @SerializedName("iteam")
            @Expose
            private Iteam iteam;
            @SerializedName("addon_iteam")
            @Expose
            private List<AddonIteam> addonIteam = null;
            @SerializedName("meals")
            @Expose
            private List<Meal> meals = null;
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

            public float getCost() {
                return cost;
            }

            public void setCost(float cost) {
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

            public String getSpecialRequest() {
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

            public float getAddonTotal() {
                return addonTotal;
            }

            public void setAddonTotal(float addonTotal) {
                this.addonTotal = addonTotal;
            }

            public float getTotalCost() {
                return totalCost;
            }

            public void setTotalCost(float totalCost) {
                this.totalCost = totalCost;
            }

            public Iteam getIteam() {
                return iteam;
            }

            public void setIteam(Iteam iteam) {
                this.iteam = iteam;
            }

            public List<AddonIteam> getAddonIteam() {
                return addonIteam;
            }

            public void setAddonIteam(List<AddonIteam> addonIteam) {
                this.addonIteam = addonIteam;
            }

            public List<Meal> getMeals() {
                return meals;
            }

            public void setMeals(List<Meal> meals) {
                this.meals = meals;
            }

            public Caterer getCaterer() {
                return caterer;
            }

            public void setCaterer(Caterer caterer) {
                this.caterer = caterer;
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

                public String getServiceAndPresentation() {
                    return serviceAndPresentation;
                }

                public void setServiceAndPresentation(String serviceAndPresentation) {
                    this.serviceAndPresentation = serviceAndPresentation;
                }

                public String getFoodDetails() {
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

                public String getArabicServiceAndPresentation() {
                    return arabicServiceAndPresentation;
                }

                public void setArabicServiceAndPresentation(String arabicServiceAndPresentation) {
                    this.arabicServiceAndPresentation = arabicServiceAndPresentation;
                }

                public String getArabicFoodDetails() {
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

                public String getDeletedAt() {
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

                public String getSetupTimeInMinute() {
                    return setupTimeInMinute;
                }

                public void setSetupTimeInMinute(String setupTimeInMinute) {
                    this.setupTimeInMinute = setupTimeInMinute;
                }

                public String getRequirements() {
                    return requirements;
                }

                public void setRequirements(String requirements) {
                    this.requirements = requirements;
                }

                public String getArabicSetupTimeInMinute() {
                    return arabicSetupTimeInMinute;
                }

                public void setArabicSetupTimeInMinute(String arabicSetupTimeInMinute) {
                    this.arabicSetupTimeInMinute = arabicSetupTimeInMinute;
                }

                public String getArabicRequirements() {
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

                public String getDiscountValue() {
                    return discountValue;
                }

                public void setDiscountValue(String discountValue) {
                    this.discountValue = discountValue;
                }

                public String getStartDate() {
                    return startDate;
                }

                public void setStartDate(String startDate) {
                    this.startDate = startDate;
                }

                public String getEndDate() {
                    return endDate;
                }

                public void setEndDate(String endDate) {
                    this.endDate = endDate;
                }

                public String getTime() {
                    return time;
                }

                public void setTime(String time) {
                    this.time = time;
                }

                public String getCashOrderPolicy() {
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

                public String getDeletedAt() {
                    return deletedAt;
                }

                public void setDeletedAt(String deletedAt) {
                    this.deletedAt = deletedAt;
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

            public class Meal {

                @SerializedName("id")
                @Expose
                private Integer id;
                @SerializedName("cart_id")
                @Expose
                private Integer cartId;
                @SerializedName("meal_item_id")
                @Expose
                private Integer mealItemId;
                @SerializedName("meal_category_title")
                @Expose
                private String mealCategoryTitle;
                @SerializedName("meal_category_arabic_title")
                @Expose
                private String mealCategoryArabicTitle;
                @SerializedName("item_title")
                @Expose
                private String itemTitle;
                @SerializedName("item_arabic_title")
                @Expose
                private String itemArabicTitle;
                @SerializedName("quantity")
                @Expose
                private String quantity;
                @SerializedName("created_at")
                @Expose
                private String createdAt;
                @SerializedName("updated_at")
                @Expose
                private String updatedAt;

                public Integer getId() {
                    return id;
                }

                public void setId(Integer id) {
                    this.id = id;
                }

                public Integer getCartId() {
                    return cartId;
                }

                public void setCartId(Integer cartId) {
                    this.cartId = cartId;
                }

                public Integer getMealItemId() {
                    return mealItemId;
                }

                public void setMealItemId(Integer mealItemId) {
                    this.mealItemId = mealItemId;
                }

                public String getMealCategoryTitle() {
                    return mealCategoryTitle;
                }

                public void setMealCategoryTitle(String mealCategoryTitle) {
                    this.mealCategoryTitle = mealCategoryTitle;
                }

                public String getMealCategoryArabicTitle() {
                    return mealCategoryArabicTitle;
                }

                public void setMealCategoryArabicTitle(String mealCategoryArabicTitle) {
                    this.mealCategoryArabicTitle = mealCategoryArabicTitle;
                }

                public String getItemTitle() {
                    return itemTitle;
                }

                public void setItemTitle(String itemTitle) {
                    this.itemTitle = itemTitle;
                }

                public String getItemArabicTitle() {
                    return itemArabicTitle;
                }

                public void setItemArabicTitle(String itemArabicTitle) {
                    this.itemArabicTitle = itemArabicTitle;
                }

                public String getQuantity() {
                    return quantity;
                }

                public void setQuantity(String quantity) {
                    this.quantity = quantity;
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

            }

            public class AddonIteam {

                @SerializedName("id")
                @Expose
                private Integer id;
                @SerializedName("cart_id")
                @Expose
                private Integer cartId;
                @SerializedName("addon_category_item_id")
                @Expose
                private Integer addonCategoryItemId;
                @SerializedName("caterer_item_addon_id")
                @Expose
                private Integer catererItemAddonId;
                @SerializedName("quantity")
                @Expose
                private Integer quantity;
                @SerializedName("price")
                @Expose
                private float price;
                @SerializedName("created_at")
                @Expose
                private String createdAt;
                @SerializedName("updated_at")
                @Expose
                private String updatedAt;
                @SerializedName("total_price")
                @Expose
                private float totalPrice;
                @SerializedName("item")
                @Expose
                private Item item;

                public Integer getId() {
                    return id;
                }

                public void setId(Integer id) {
                    this.id = id;
                }

                public Integer getCartId() {
                    return cartId;
                }

                public void setCartId(Integer cartId) {
                    this.cartId = cartId;
                }

                public Integer getAddonCategoryItemId() {
                    return addonCategoryItemId;
                }

                public void setAddonCategoryItemId(Integer addonCategoryItemId) {
                    this.addonCategoryItemId = addonCategoryItemId;
                }

                public Integer getCatererItemAddonId() {
                    return catererItemAddonId;
                }

                public void setCatererItemAddonId(Integer catererItemAddonId) {
                    this.catererItemAddonId = catererItemAddonId;
                }

                public Integer getQuantity() {
                    return quantity;
                }

                public void setQuantity(Integer quantity) {
                    this.quantity = quantity;
                }

                public float getPrice() {
                    return price;
                }

                public void setPrice(float price) {
                    this.price = price;
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

                public float getTotalPrice() {
                    return totalPrice;
                }

                public void setTotalPrice(float totalPrice) {
                    this.totalPrice = totalPrice;
                }

                public Item getItem() {
                    return item;
                }

                public void setItem(Item item) {
                    this.item = item;
                }

                public class Item {

                    @SerializedName("id")
                    @Expose
                    private Integer id;
                    @SerializedName("category_id")
                    @Expose
                    private Integer categoryId;
                    @SerializedName("caterer_id")
                    @Expose
                    private Integer catererId;
                    @SerializedName("title")
                    @Expose
                    private String title;
                    @SerializedName("arabic_title")
                    @Expose
                    private String arabicTitle;
                    @SerializedName("description")
                    @Expose
                    private Object description;
                    @SerializedName("image")
                    @Expose
                    private Object image;
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
                    @SerializedName("image_path")
                    @Expose
                    private String imagePath;

                    public Integer getId() {
                        return id;
                    }

                    public void setId(Integer id) {
                        this.id = id;
                    }

                    public Integer getCategoryId() {
                        return categoryId;
                    }

                    public void setCategoryId(Integer categoryId) {
                        this.categoryId = categoryId;
                    }

                    public Integer getCatererId() {
                        return catererId;
                    }

                    public void setCatererId(Integer catererId) {
                        this.catererId = catererId;
                    }

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getArabicTitle() {
                        return arabicTitle;
                    }

                    public void setArabicTitle(String arabicTitle) {
                        this.arabicTitle = arabicTitle;
                    }

                    public Object getDescription() {
                        return description;
                    }

                    public void setDescription(Object description) {
                        this.description = description;
                    }

                    public Object getImage() {
                        return image;
                    }

                    public void setImage(Object image) {
                        this.image = image;
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

                    public String getImagePath() {
                        return imagePath;
                    }

                    public void setImagePath(String imagePath) {
                        this.imagePath = imagePath;
                    }

                }

            }



        }

    }

}