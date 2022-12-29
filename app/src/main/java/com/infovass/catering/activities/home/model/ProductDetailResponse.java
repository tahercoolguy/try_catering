package com.infovass.catering.activities.home.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ProductDetailResponse {

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
        private Float itemCostPerServe;
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
        private Float arabicItemCostPerServe;
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
        @SerializedName("addon")
        @Expose
        private List<Addon> addon = null;
        @SerializedName("is_favorite")
        @Expose
        private Boolean isFavorite;
        @SerializedName("area")
        @Expose
        private String area;
        @SerializedName("images")
        @Expose
        private List<Object> images = null;
        @SerializedName("item_logo_path")
        @Expose
        private String itemLogoPath;
        @SerializedName("caterer")
        @Expose
        private Caterer caterer;
        @SerializedName("meals")
        @Expose
        private List<Meal> meals = null;

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

        public Float getItemCostPerServe() {
            return itemCostPerServe;
        }

        public void setItemCostPerServe(Float itemCostPerServe) {
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

        public Float getArabicItemCostPerServe() {
            return arabicItemCostPerServe;
        }

        public void setArabicItemCostPerServe(Float arabicItemCostPerServe) {
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

        public List<Addon> getAddon() {
            return addon;
        }

        public void setAddon(List<Addon> addon) {
            this.addon = addon;
        }

        public Boolean getIsFavorite() {
            return isFavorite;
        }

        public void setIsFavorite(Boolean isFavorite) {
            this.isFavorite = isFavorite;
        }

        public Object getArea() {
            return area;
        }

        public void setArea(String area) {
            this.area = area;
        }

        public List<Object> getImages() {
            return images;
        }

        public void setImages(List<Object> images) {
            this.images = images;
        }

        public String getItemLogoPath() {
            return itemLogoPath;
        }

        public void setItemLogoPath(String itemLogoPath) {
            this.itemLogoPath = itemLogoPath;
        }

        public Caterer getCaterer() {
            return caterer;
        }

        public void setCaterer(Caterer caterer) {
            this.caterer = caterer;
        }

        public List<Meal> getMeals() {
            return meals;
        }

        public void setMeals(List<Meal> meals) {
            this.meals = meals;
        }

    }

    public class Addon {

        @SerializedName("title")
        @Expose
        private String title;
        @SerializedName("items")
        @Expose
        private List<Item> items = null;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public List<Item> getItems() {
            return items;
        }

        public void setItems(List<Item> items) {
            this.items = items;
        }

    }

    public class Item {

        @SerializedName("category_name")
        @Expose
        private String categoryName;
        @SerializedName("category_name_ar")
        @Expose
        private String categoryNameAr;
        @SerializedName("item")
        @Expose
        private List<Item__1> item = null;

        public String getCategoryName() {
            return categoryName;
        }

        public void setCategoryName(String categoryName) {
            this.categoryName = categoryName;
        }

        public String getCategoryNameAr() {
            return categoryNameAr;
        }

        public void setCategoryNameAr(String categoryNameAr) {
            this.categoryNameAr = categoryNameAr;
        }

        public List<Item__1> getItem() {
            return item;
        }

        public void setItem(List<Item__1> item) {
            this.item = item;
        }

    }

    public class Item__1 {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("caterer_item_id")
        @Expose
        private Integer catererItemId;
        @SerializedName("addon_item_id")
        @Expose
        private Integer addonItemId;
        @SerializedName("price")
        @Expose
        private float price;
        @SerializedName("deleted_at")
        @Expose
        private String deletedAt;
        @SerializedName("created_at")
        @Expose
        private String createdAt;
        @SerializedName("updated_at")
        @Expose
        private String updatedAt;
        @SerializedName("title")
        @Expose
        private String title;
        @SerializedName("arabic_title")
        @Expose
        private String arabicTitle;
        @SerializedName("description")
        @Expose
        private String description;
        @SerializedName("image")
        @Expose
        private String image;
        @SerializedName("image_path")
        @Expose
        private String imagePath;
        @SerializedName("category_id")
        @Expose
        private Integer categoryId;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Integer getCatererItemId() {
            return catererItemId;
        }

        public void setCatererItemId(Integer catererItemId) {
            this.catererItemId = catererItemId;
        }

        public Integer getAddonItemId() {
            return addonItemId;
        }

        public void setAddonItemId(Integer addonItemId) {
            this.addonItemId = addonItemId;
        }

        public float getPrice() {
            return price;
        }

        public void setPrice(float price) {
            this.price = price;
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

        public void setDescription(String description) {
            this.description = description;
        }

        public Object getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getImagePath() {
            return imagePath;
        }

        public void setImagePath(String imagePath) {
            this.imagePath = imagePath;
        }

        public Integer getCategoryId() {
            return categoryId;
        }

        public void setCategoryId(Integer categoryId) {
            this.categoryId = categoryId;
        }

    }

    public class Meal {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("meal_type_id")
        @Expose
        private Integer mealTypeId;
        @SerializedName("caterer_item_id")
        @Expose
        private Integer catererItemId;
        @SerializedName("mealType_title")
        @Expose
        private String mealTypeTitle;
        @SerializedName("mealType_arabic_title")
        @Expose
        private String mealTypeArabicTitle;
        @SerializedName("num_of_taken")
        @Expose
        private String numOfTaken;
        @SerializedName("mealItems")
        @Expose
        private List<MealItem> mealItems = null;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Integer getMealTypeId() {
            return mealTypeId;
        }

        public void setMealTypeId(Integer mealTypeId) {
            this.mealTypeId = mealTypeId;
        }

        public Integer getCatererItemId() {
            return catererItemId;
        }

        public void setCatererItemId(Integer catererItemId) {
            this.catererItemId = catererItemId;
        }

        public String getMealTypeTitle() {
            return mealTypeTitle;
        }

        public void setMealTypeTitle(String mealTypeTitle) {
            this.mealTypeTitle = mealTypeTitle;
        }

        public String getMealTypeArabicTitle() {
            return mealTypeArabicTitle;
        }

        public void setMealTypeArabicTitle(String mealTypeArabicTitle) {
            this.mealTypeArabicTitle = mealTypeArabicTitle;
        }

        public String getNumOfTaken() {
            return numOfTaken;
        }

        public void setNumOfTaken(String numOfTaken) {
            this.numOfTaken = numOfTaken;
        }

        public List<MealItem> getMealItems() {
            return mealItems;
        }

        public void setMealItems(List<MealItem> mealItems) {
            this.mealItems = mealItems;
        }

    }

    public class MealItem {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("title")
        @Expose
        private String title;
        @SerializedName("arabic_title")
        @Expose
        private String arabicTitle;
        @SerializedName("description")
        @Expose
        private String description;
        @SerializedName("arabic_description")
        @Expose
        private String arabicDescription;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
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

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getArabicDescription() {
            return arabicDescription;
        }

        public void setArabicDescription(String arabicDescription) {
            this.arabicDescription = arabicDescription;
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
        private Double deliveryCharge;
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
        private Object endDate;
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

        public Double getDeliveryCharge() {
            return deliveryCharge;
        }

        public void setDeliveryCharge(Double deliveryCharge) {
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

















