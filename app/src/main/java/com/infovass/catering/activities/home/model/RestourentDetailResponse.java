package com.infovass.catering.activities.home.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RestourentDetailResponse {

//    @SerializedName("status")
//    @Expose
//    private Boolean status;
//    @SerializedName("message")
//    @Expose
//    private String message;
//    @SerializedName("data")
//    @Expose
//    private Data data;
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
//    public Data getData() {
//        return data;
//    }
//
//    public void setData(Data data) {
//        this.data = data;
//    }
//
//    public class Data {
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
//        private String setupTimeInMinute;
//        @SerializedName("requirements")
//        @Expose
//        private String requirements;
//        @SerializedName("arabic_setup_time_in_minute")
//        @Expose
//        private String arabicSetupTimeInMinute;
//        @SerializedName("arabic_requirements")
//        @Expose
//        private String arabicRequirements;
//        @SerializedName("discount_available")
//        @Expose
//        private String discountAvailable;
//        @SerializedName("discount_type")
//        @Expose
//        private String discountType;
//        @SerializedName("discount_value")
//        @Expose
//        private String discountValue;
//        @SerializedName("start_date")
//        @Expose
//        private String startDate;
//        @SerializedName("end_date")
//        @Expose
//        private String endDate;
//        @SerializedName("time")
//        @Expose
//        private String time;
//        @SerializedName("cash_order_policy")
//        @Expose
//        private String cashOrderPolicy;
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
//        private String deletedAt;
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
//        @SerializedName("is_favorite")
//        @Expose
//        private Boolean isFavorite;
//        @SerializedName("offday")
//        @Expose
//        private Boolean offday;
//        @SerializedName("cover_images")
//        @Expose
//        private List<CoverImage> coverImages = null;
//        @SerializedName("modes")
//        @Expose
//        private List<Mode> modes = null;
//        @SerializedName("item")
//        @Expose
//        private List<Item> item = null;
//        @SerializedName("number_of_review")
//        @Expose
//        private Integer numberOfReview;
//        @SerializedName("rating")
//        @Expose
//        private Integer rating;
//        @SerializedName("logo_path")
//        @Expose
//        private String logoPath;
//        @SerializedName("cover_image_path")
//        @Expose
//        private String coverImagePath;
//        @SerializedName("credential")
//        @Expose
//        private Credential credential;
//        @SerializedName("images")
//        @Expose
//        private List<Object> images = null;
//        @SerializedName("areas")
//        @Expose
//        private List<Area> areas = null;
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
//        public String getSetupTimeInMinute() {
//            return setupTimeInMinute;
//        }
//
//        public void setSetupTimeInMinute(String setupTimeInMinute) {
//            this.setupTimeInMinute = setupTimeInMinute;
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
//        public String getArabicSetupTimeInMinute() {
//            return arabicSetupTimeInMinute;
//        }
//
//        public void setArabicSetupTimeInMinute(String arabicSetupTimeInMinute) {
//            this.arabicSetupTimeInMinute = arabicSetupTimeInMinute;
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
//        public void setDiscountValue(String discountValue) {
//            this.discountValue = discountValue;
//        }
//
//        public String getStartDate() {
//            return startDate;
//        }
//
//        public void setStartDate(String startDate) {
//            this.startDate = startDate;
//        }
//
//        public String getEndDate() {
//            return endDate;
//        }
//
//        public void setEndDate(String endDate) {
//            this.endDate = endDate;
//        }
//
//        public String getTime() {
//            return time;
//        }
//
//        public void setTime(String time) {
//            this.time = time;
//        }
//
//        public String getCashOrderPolicy() {
//            return cashOrderPolicy;
//        }
//
//        public void setCashOrderPolicy(String cashOrderPolicy) {
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
//        public void setDeletedAt(String deletedAt) {
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
//        public Boolean getIsFavorite() {
//            return isFavorite;
//        }
//
//        public void setIsFavorite(Boolean isFavorite) {
//            this.isFavorite = isFavorite;
//        }
//
//        public Boolean getOffday() {
//            return offday;
//        }
//
//        public void setOffday(Boolean offday) {
//            this.offday = offday;
//        }
//
//        public List<CoverImage> getCoverImages() {
//            return coverImages;
//        }
//
//        public void setCoverImages(List<CoverImage> coverImages) {
//            this.coverImages = coverImages;
//        }
//
//        public List<Mode> getModes() {
//            return modes;
//        }
//
//        public void setModes(List<Mode> modes) {
//            this.modes = modes;
//        }
//
//        public List<Item> getItem() {
//            return item;
//        }
//
//        public void setItem(List<Item> item) {
//            this.item = item;
//        }
//
//        public Integer getNumberOfReview() {
//            return numberOfReview;
//        }
//
//        public void setNumberOfReview(Integer numberOfReview) {
//            this.numberOfReview = numberOfReview;
//        }
//
//        public Integer getRating() {
//            return rating;
//        }
//
//        public void setRating(Integer rating) {
//            this.rating = rating;
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
//        public Credential getCredential() {
//            return credential;
//        }
//
//        public void setCredential(Credential credential) {
//            this.credential = credential;
//        }
//
//        public List<Object> getImages() {
//            return images;
//        }
//
//        public void setImages(List<Object> images) {
//            this.images = images;
//        }
//
//        public List<Area> getAreas() {
//            return areas;
//        }
//
//        public void setAreas(List<Area> areas) {
//            this.areas = areas;
//        }
//
//    }
//
//    public class Area {
//
//        @SerializedName("id")
//        @Expose
//        private Integer id;
//        @SerializedName("caterer_id")
//        @Expose
//        private Integer catererId;
//        @SerializedName("area_id")
//        @Expose
//        private Integer areaId;
//        @SerializedName("delivery_charge")
//        @Expose
//        private String deliveryCharge;
//        @SerializedName("catering_charge")
//        @Expose
//        private String cateringCharge;
//        @SerializedName("created_at")
//        @Expose
//        private String createdAt;
//        @SerializedName("updated_at")
//        @Expose
//        private String updatedAt;
//
//        public Integer getId() {
//            return id;
//        }
//
//        public void setId(Integer id) {
//            this.id = id;
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
//        public Integer getAreaId() {
//            return areaId;
//        }
//
//        public void setAreaId(Integer areaId) {
//            this.areaId = areaId;
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
//        public String getCateringCharge() {
//            return cateringCharge;
//        }
//
//        public void setCateringCharge(String cateringCharge) {
//            this.cateringCharge = cateringCharge;
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
//    }
//    public class CoverImage {
//
//        @SerializedName("cover_image_path")
//        @Expose
//        private String coverImagePath;
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
//    public class Credential {
//
//        @SerializedName("id")
//        @Expose
//        private Integer id;
//        @SerializedName("caterer_id")
//        @Expose
//        private Integer catererId;
//        @SerializedName("name")
//        @Expose
//        private String name;
//        @SerializedName("email")
//        @Expose
//        private String email;
//        @SerializedName("email_verified_at")
//        @Expose
//        private String emailVerifiedAt;
//        @SerializedName("first_name")
//        @Expose
//        private String firstName;
//        @SerializedName("last_name")
//        @Expose
//        private String lastName;
//        @SerializedName("username")
//        @Expose
//        private String username;
//        @SerializedName("address")
//        @Expose
//        private String address;
//        @SerializedName("lat")
//        @Expose
//        private String lat;
//        @SerializedName("lng")
//        @Expose
//        private String lng;
//        @SerializedName("city_id")
//        @Expose
//        private Integer cityId;
//        @SerializedName("area_id")
//        @Expose
//        private Integer areaId;
//        @SerializedName("phone")
//        @Expose
//        private String phone;
//        @SerializedName("is_admin")
//        @Expose
//        private Integer isAdmin;
//        @SerializedName("status")
//        @Expose
//        private String status;
//        @SerializedName("current_language")
//        @Expose
//        private String currentLanguage;
//        @SerializedName("refer_code")
//        @Expose
//        private String referCode;
//        @SerializedName("accessToken")
//        @Expose
//        private String accessToken;
//        @SerializedName("device_token")
//        @Expose
//        private String deviceToken;
//        @SerializedName("device_type")
//        @Expose
//        private String deviceType;
//        @SerializedName("deleted_at")
//        @Expose
//        private String deletedAt;
//        @SerializedName("created_at")
//        @Expose
//        private String createdAt;
//        @SerializedName("updated_at")
//        @Expose
//        private String updatedAt;
//        @SerializedName("social_id")
//        @Expose
//        private String socialId;
//        @SerializedName("social_account_type")
//        @Expose
//        private String socialAccountType;
//
//        public Integer getId() {
//            return id;
//        }
//
//        public void setId(Integer id) {
//            this.id = id;
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
//        public String getName() {
//            return name;
//        }
//
//        public void setName(String name) {
//            this.name = name;
//        }
//
//        public String getEmail() {
//            return email;
//        }
//
//        public void setEmail(String email) {
//            this.email = email;
//        }
//
//        public String getEmailVerifiedAt() {
//            return emailVerifiedAt;
//        }
//
//        public void setEmailVerifiedAt(String emailVerifiedAt) {
//            this.emailVerifiedAt = emailVerifiedAt;
//        }
//
//        public String getFirstName() {
//            return firstName;
//        }
//
//        public void setFirstName(String firstName) {
//            this.firstName = firstName;
//        }
//
//        public String getLastName() {
//            return lastName;
//        }
//
//        public void setLastName(String lastName) {
//            this.lastName = lastName;
//        }
//
//        public String getUsername() {
//            return username;
//        }
//
//        public void setUsername(String username) {
//            this.username = username;
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
//        public String getLat() {
//            return lat;
//        }
//
//        public void setLat(String lat) {
//            this.lat = lat;
//        }
//
//        public String getLng() {
//            return lng;
//        }
//
//        public void setLng(String lng) {
//            this.lng = lng;
//        }
//
//        public Integer getCityId() {
//            return cityId;
//        }
//
//        public void setCityId(Integer cityId) {
//            this.cityId = cityId;
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
//        public String getPhone() {
//            return phone;
//        }
//
//        public void setPhone(String phone) {
//            this.phone = phone;
//        }
//
//        public Integer getIsAdmin() {
//            return isAdmin;
//        }
//
//        public void setIsAdmin(Integer isAdmin) {
//            this.isAdmin = isAdmin;
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
//        public String getCurrentLanguage() {
//            return currentLanguage;
//        }
//
//        public void setCurrentLanguage(String currentLanguage) {
//            this.currentLanguage = currentLanguage;
//        }
//
//        public String getReferCode() {
//            return referCode;
//        }
//
//        public void setReferCode(String referCode) {
//            this.referCode = referCode;
//        }
//
//        public String getAccessToken() {
//            return accessToken;
//        }
//
//        public void setAccessToken(String accessToken) {
//            this.accessToken = accessToken;
//        }
//
//        public String getDeviceToken() {
//            return deviceToken;
//        }
//
//        public void setDeviceToken(String deviceToken) {
//            this.deviceToken = deviceToken;
//        }
//
//        public String getDeviceType() {
//            return deviceType;
//        }
//
//        public void setDeviceType(String deviceType) {
//            this.deviceType = deviceType;
//        }
//
//        public String getDeletedAt() {
//            return deletedAt;
//        }
//
//        public void setDeletedAt(String deletedAt) {
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
//        public String getSocialId() {
//            return socialId;
//        }
//
//        public void setSocialId(String socialId) {
//            this.socialId = socialId;
//        }
//
//        public String getSocialAccountType() {
//            return socialAccountType;
//        }
//
//        public void setSocialAccountType(String socialAccountType) {
//            this.socialAccountType = socialAccountType;
//        }
//
//    }
//
//    public class Image {
//
//        @SerializedName("id")
//        @Expose
//        private Integer id;
//        @SerializedName("caterer_item_id")
//        @Expose
//        private Integer catererItemId;
//        @SerializedName("image")
//        @Expose
//        private String image;
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
//        public Integer getCatererItemId() {
//            return catererItemId;
//        }
//
//        public void setCatererItemId(Integer catererItemId) {
//            this.catererItemId = catererItemId;
//        }
//
//        public String getImage() {
//            return image;
//        }
//
//        public void setImage(String image) {
//            this.image = image;
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
//        @SerializedName("category_name")
//        @Expose
//        private String categoryName;
//        @SerializedName("category_name_ar")
//        @Expose
//        private String categoryNameAr;
//        @SerializedName("items")
//        @Expose
//        private List<Item__1> items = null;
//
//        public String getCategoryName() {
//            return categoryName;
//        }
//
//        public void setCategoryName(String categoryName) {
//            this.categoryName = categoryName;
//        }
//
//        public String getCategoryNameAr() {
//            return categoryNameAr;
//        }
//
//        public void setCategoryNameAr(String categoryNameAr) {
//            this.categoryNameAr = categoryNameAr;
//        }
//
//        public List<Item__1> getItems() {
//            return items;
//        }
//
//        public void setItems(List<Item__1> items) {
//            this.items = items;
//        }
//
//    }
//    public class Item__1 {
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
//        private String serviceAndPresentation;
//        @SerializedName("food_details")
//        @Expose
//        private String foodDetails;
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
//        private String arabicServiceAndPresentation;
//        @SerializedName("arabic_food_details")
//        @Expose
//        private String arabicFoodDetails;
//        @SerializedName("status")
//        @Expose
//        private String status;
//        @SerializedName("deleted_at")
//        @Expose
//        private String deletedAt;
//        @SerializedName("created_at")
//        @Expose
//        private String createdAt;
//        @SerializedName("updated_at")
//        @Expose
//        private String updatedAt;
//        @SerializedName("addon_item")
//        @Expose
//        private Boolean addonItem;
//        @SerializedName("is_favorite")
//        @Expose
//        private Boolean isFavorite;
//        @SerializedName("images")
//        @Expose
//        private List<Image> images = null;
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
//        public String getServiceAndPresentation() {
//            return serviceAndPresentation;
//        }
//
//        public void setServiceAndPresentation(String serviceAndPresentation) {
//            this.serviceAndPresentation = serviceAndPresentation;
//        }
//
//        public String getFoodDetails() {
//            return foodDetails;
//        }
//
//        public void setFoodDetails(String foodDetails) {
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
//        public String getArabicServiceAndPresentation() {
//            return arabicServiceAndPresentation;
//        }
//
//        public void setArabicServiceAndPresentation(String arabicServiceAndPresentation) {
//            this.arabicServiceAndPresentation = arabicServiceAndPresentation;
//        }
//
//        public String getArabicFoodDetails() {
//            return arabicFoodDetails;
//        }
//
//        public void setArabicFoodDetails(String arabicFoodDetails) {
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
//        public String getDeletedAt() {
//            return deletedAt;
//        }
//
//        public void setDeletedAt(String deletedAt) {
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
//        public Boolean getAddonItem() {
//            return addonItem;
//        }
//
//        public void setAddonItem(Boolean addonItem) {
//            this.addonItem = addonItem;
//        }
//
//        public Boolean getIsFavorite() {
//            return isFavorite;
//        }
//
//        public void setIsFavorite(Boolean isFavorite) {
//            this.isFavorite = isFavorite;
//        }
//
//        public List<Image> getImages() {
//            return images;
//        }
//
//        public void setImages(List<Image> images) {
//            this.images = images;
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
//    public class Mode {
//
//        @SerializedName("id")
//        @Expose
//        private Integer id;
//        @SerializedName("name")
//        @Expose
//        private String name;
//        @SerializedName("arabic_title")
//        @Expose
//        private String arabicTitle;
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
//        public String getName() {
//            return name;
//        }
//
//        public void setName(String name) {
//            this.name = name;
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
//        public String getImagePath() {
//            return imagePath;
//        }
//
//        public void setImagePath(String imagePath) {
//            this.imagePath = imagePath;
//        }
//
//    }







    //new response

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
        //        @SerializedName("setup_time_in_minute")
//        @Expose
//        private Object setupTimeInMinute;
//        @SerializedName("requirements")
//        @Expose
//        private Object requirements;
//        @SerializedName("arabic_setup_time_in_minute")
//        @Expose
//        private String arabicSetupTimeInMinute;
//        @SerializedName("arabic_requirements")
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
//        @Expose
//        private String arabicRequirements;
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
        @SerializedName("is_favorite")
        @Expose
        private Boolean isFavorite;
        @SerializedName("offday")
        @Expose
        private Boolean offday;
        @SerializedName("modes")
        @Expose
        private List<Mode> modes = null;
        @SerializedName("item")
        @Expose
        private List<Item> item;
        @SerializedName("number_of_review")
        @Expose
        private Integer numberOfReview;
        @SerializedName("rating")
        @Expose
        private Integer rating;
        @SerializedName("logo_path")
        @Expose
        private String logoPath;
        @SerializedName("cover_image_path")
        @Expose
        private String coverImagePath;
        @SerializedName("credential")
        @Expose
        private Credential credential;
        @SerializedName("areas")
        @Expose
        private List<Area> areas = null;
        @SerializedName("images")
        @Expose
        private List<cover_images> images = null;

        public List<cover_images> getImages() {
            return images;
        }

        public void setImages(List<cover_images> images) {
            this.images = images;
        }

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

        //        public Object getSetupTimeInMinute() {
//            return setupTimeInMinute;
//        }
//
//        public void setSetupTimeInMinute(String setupTimeInMinute) {
//            this.setupTimeInMinute = setupTimeInMinute;
//        }
//
//        public Object getRequirements() {
//            return requirements;
//        }
//
//        public void setRequirements(String requirements) {
//            this.requirements = requirements;
//        }
//
//        public Object getArabicSetupTimeInMinute() {
//            return arabicSetupTimeInMinute;
//        }
//
//        public void setArabicSetupTimeInMinute(String arabicSetupTimeInMinute) {
//            this.arabicSetupTimeInMinute = arabicSetupTimeInMinute;
//        }
//
//        public Object getArabicRequirements() {
//            return arabicRequirements;
//        }
//
//        public void setArabicRequirements(String arabicRequirements) {
//            this.arabicRequirements = arabicRequirements;
//        }

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

        public Boolean getIsFavorite() {
            return isFavorite;
        }

        public void setIsFavorite(Boolean isFavorite) {
            this.isFavorite = isFavorite;
        }

        public Boolean getOffday() {
            return offday;
        }

        public void setOffday(Boolean offday) {
            this.offday = offday;
        }

        public List<Mode> getModes() {
            return modes;
        }

        public void setModes(List<Mode> modes) {
            this.modes = modes;
        }

        public List<Item> getItem() {
            return item;
        }

        public void setItem(List<Item> item) {
            this.item = item;
        }
        //        public Item getItem() {
//            return item;
//        }
//
//        public void setItem(Item item) {
//            this.item = item;
//        }

        public Integer getNumberOfReview() {
            return numberOfReview;
        }

        public void setNumberOfReview(Integer numberOfReview) {
            this.numberOfReview = numberOfReview;
        }

        public Integer getRating() {
            return rating;
        }

        public void setRating(Integer rating) {
            this.rating = rating;
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

        public Credential getCredential() {
            return credential;
        }

        public void setCredential(Credential credential) {
            this.credential = credential;
        }

        public List<Area> getAreas() {
            return areas;
        }

        public void setAreas(List<Area> areas) {
            this.areas = areas;
        }

    }

    public class cover_images {
        @SerializedName("cover_image_path")
        @Expose
        private String cover_image_path;

        public String getCover_image_path() {
            return cover_image_path;
        }

        public void setCover_image_path(String cover_image_path) {
            this.cover_image_path = cover_image_path;
        }
    }

    public class Mode {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("arabic_title")
        @Expose
        private String arabicTitle;
        @SerializedName("image_path")
        @Expose
        private String imagePath;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getArabicTitle() {
            return arabicTitle;
        }

        public void setArabicTitle(String arabicTitle) {
            this.arabicTitle = arabicTitle;
        }

        public String getImagePath() {
            return imagePath;
        }

        public void setImagePath(String imagePath) {
            this.imagePath = imagePath;
        }

    }

    public class Credential {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("caterer_id")
        @Expose
        private Integer catererId;
        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("email")
        @Expose
        private String email;
        @SerializedName("email_verified_at")
        @Expose
        private Object emailVerifiedAt;
        @SerializedName("first_name")
        @Expose
        private String firstName;
        @SerializedName("last_name")
        @Expose
        private String lastName;
        @SerializedName("username")
        @Expose
        private String username;
        @SerializedName("address")
        @Expose
        private String address;
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
        @SerializedName("phone")
        @Expose
        private String phone;
        @SerializedName("is_admin")
        @Expose
        private Integer isAdmin;
        @SerializedName("status")
        @Expose
        private String status;
        @SerializedName("current_language")
        @Expose
        private String currentLanguage;
        @SerializedName("refer_code")
        @Expose
        private String referCode;
        @SerializedName("accessToken")
        @Expose
        private String accessToken;
        @SerializedName("device_token")
        @Expose
        private String deviceToken;
        @SerializedName("device_type")
        @Expose
        private String deviceType;
        @SerializedName("deleted_at")
        @Expose
        private String deletedAt;
        @SerializedName("created_at")
        @Expose
        private String createdAt;
        @SerializedName("updated_at")
        @Expose
        private String updatedAt;
        @SerializedName("social_id")
        @Expose
        private String socialId;
        @SerializedName("social_account_type")
        @Expose
        private String socialAccountType;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Integer getCatererId() {
            return catererId;
        }

        public void setCatererId(Integer catererId) {
            this.catererId = catererId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public Object getEmailVerifiedAt() {
            return emailVerifiedAt;
        }

        public void setEmailVerifiedAt(Object emailVerifiedAt) {
            this.emailVerifiedAt = emailVerifiedAt;
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

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
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

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public Integer getIsAdmin() {
            return isAdmin;
        }

        public void setIsAdmin(Integer isAdmin) {
            this.isAdmin = isAdmin;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getCurrentLanguage() {
            return currentLanguage;
        }

        public void setCurrentLanguage(String currentLanguage) {
            this.currentLanguage = currentLanguage;
        }

        public Object getReferCode() {
            return referCode;
        }

        public void setReferCode(String referCode) {
            this.referCode = referCode;
        }

        public Object getAccessToken() {
            return accessToken;
        }

        public void setAccessToken(String accessToken) {
            this.accessToken = accessToken;
        }

        public Object getDeviceToken() {
            return deviceToken;
        }

        public void setDeviceToken(String deviceToken) {
            this.deviceToken = deviceToken;
        }

        public Object getDeviceType() {
            return deviceType;
        }

        public void setDeviceType(String deviceType) {
            this.deviceType = deviceType;
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

        public Object getSocialId() {
            return socialId;
        }

        public void setSocialId(String socialId) {
            this.socialId = socialId;
        }

        public Object getSocialAccountType() {
            return socialAccountType;
        }

        public void setSocialAccountType(String socialAccountType) {
            this.socialAccountType = socialAccountType;
        }

    }

    public class Item {

        @SerializedName("category_name")
        @Expose
        private String categoryName;
        @SerializedName("category_name_ar")
        @Expose
        private String categoryNameAr;
        @SerializedName("items")
        @Expose
        private List<Item__1> items = null;

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

        public List<Item__1> getItems() {
            return items;
        }

        public void setItems(List<Item__1> items) {
            this.items = items;
        }

    }

    public class Item__1 {

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
        @SerializedName("addon_item")
        @Expose
        private Boolean addonItem;
        @SerializedName("is_favorite")
        @Expose
        private Boolean isFavorite;
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

        public Boolean getAddonItem() {
            return addonItem;
        }

        public void setAddonItem(Boolean addonItem) {
            this.addonItem = addonItem;
        }

        public Boolean getIsFavorite() {
            return isFavorite;
        }

        public void setIsFavorite(Boolean isFavorite) {
            this.isFavorite = isFavorite;
        }

        public String getItemLogoPath() {
            return itemLogoPath;
        }

        public void setItemLogoPath(String itemLogoPath) {
            this.itemLogoPath = itemLogoPath;
        }

    }

    public class Area {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("caterer_id")
        @Expose
        private Integer catererId;
        @SerializedName("area_id")
        @Expose
        private Integer areaId;
        @SerializedName("delivery_charge")
        @Expose
        private String deliveryCharge;
        @SerializedName("catering_charge")
        @Expose
        private String cateringCharge;
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

        public Integer getCatererId() {
            return catererId;
        }

        public void setCatererId(Integer catererId) {
            this.catererId = catererId;
        }

        public Integer getAreaId() {
            return areaId;
        }

        public void setAreaId(Integer areaId) {
            this.areaId = areaId;
        }

        public Object getDeliveryCharge() {
            return deliveryCharge;
        }

        public void setDeliveryCharge(String deliveryCharge) {
            this.deliveryCharge = deliveryCharge;
        }

        public String getCateringCharge() {
            return cateringCharge;
        }

        public void setCateringCharge(String cateringCharge) {
            this.cateringCharge = cateringCharge;
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



    //old response

//    @SerializedName("status")
//    @Expose
//    private Boolean status;
//    @SerializedName("message")
//    @Expose
//    private String message;
//    @SerializedName("data")
//    @Expose
//    private Data data;
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
//    public Data getData() {
//        return data;
//    }
//
//    public void setData(Data data) {
//        this.data = data;
//    }
//
//    public class Data {
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
//        private Integer deliveryCharge;
//        @SerializedName("min_order")
//        @Expose
//        private String minOrder;
//        @SerializedName("setup_time_in_minute")
//        @Expose
//        private String setupTimeInMinute;
//        @SerializedName("requirements")
//        @Expose
//        private String requirements;
//        @SerializedName("arabic_setup_time_in_minute")
//        @Expose
//        private String arabicSetupTimeInMinute;
//        @SerializedName("arabic_requirements")
//        @Expose
//        private String arabicRequirements;
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
//        private String time;
//        @SerializedName("cash_order_policy")
//        @Expose
//        private String cashOrderPolicy;
//        @SerializedName("cancellation_policy")
//        @Expose
//        private String cancellationPolicy;
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
//        @SerializedName("is_favorite")
//        @Expose
//        private Boolean isFavorite;
//        @SerializedName("modes")
//        @Expose
//        private List<Mode> modes = null;
//        @SerializedName("number_of_review")
//        @Expose
//        private Integer numberOfReview;
//        @SerializedName("rating")
//        @Expose
//        private Integer rating;
//        @SerializedName("logo_path")
//        @Expose
//        private String logoPath;
//        @SerializedName("cover_image_path")
//        @Expose
//        private String coverImagePath;
//        @SerializedName("item")
//        @Expose
//        private List<Item> item = null;
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
//        public Integer getDeliveryCharge() {
//            return deliveryCharge;
//        }
//
//        public void setDeliveryCharge(Integer deliveryCharge) {
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
//        public String getSetupTimeInMinute() {
//            return setupTimeInMinute;
//        }
//
//        public void setSetupTimeInMinute(String setupTimeInMinute) {
//            this.setupTimeInMinute = setupTimeInMinute;
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
//        public String getArabicSetupTimeInMinute() {
//            return arabicSetupTimeInMinute;
//        }
//
//        public void setArabicSetupTimeInMinute(String arabicSetupTimeInMinute) {
//            this.arabicSetupTimeInMinute = arabicSetupTimeInMinute;
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
//        public String getTime() {
//            return time;
//        }
//
//        public void setTime(String time) {
//            this.time = time;
//        }
//
//        public String getCashOrderPolicy() {
//            return cashOrderPolicy;
//        }
//
//        public void setCashOrderPolicy(String cashOrderPolicy) {
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
//        public Boolean getIsFavorite() {
//            return isFavorite;
//        }
//
//        public void setIsFavorite(Boolean isFavorite) {
//            this.isFavorite = isFavorite;
//        }
//
//        public List<Mode> getModes() {
//            return modes;
//        }
//
//        public void setModes(List<Mode> modes) {
//            this.modes = modes;
//        }
//
//        public Integer getNumberOfReview() {
//            return numberOfReview;
//        }
//
//        public void setNumberOfReview(Integer numberOfReview) {
//            this.numberOfReview = numberOfReview;
//        }
//
//        public Integer getRating() {
//            return rating;
//        }
//
//        public void setRating(Integer rating) {
//            this.rating = rating;
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
//        public List<Item> getItem() {
//            return item;
//        }
//
//        public void setItem(List<Item> item) {
//            this.item = item;
//        }
//
//        public class Mode {
//
//            @SerializedName("id")
//            @Expose
//            private Integer id;
//            @SerializedName("name")
//            @Expose
//            private String name;
//            @SerializedName("arabic_title")
//            @Expose
//            private String arabicTitle;
//            @SerializedName("image_path")
//            @Expose
//            private String imagePath;
//
//            public Integer getId() {
//                return id;
//            }
//
//            public void setId(Integer id) {
//                this.id = id;
//            }
//
//            public String getName() {
//                return name;
//            }
//
//            public void setName(String name) {
//                this.name = name;
//            }
//
//            public String getArabicTitle() {
//                return arabicTitle;
//            }
//
//            public void setArabicTitle(String arabicTitle) {
//                this.arabicTitle = arabicTitle;
//            }
//
//            public String getImagePath() {
//                return imagePath;
//            }
//
//            public void setImagePath(String imagePath) {
//                this.imagePath = imagePath;
//            }
//
//        }
//
//        public class Item {
//
//            @SerializedName("id")
//            @Expose
//            private Integer id;
//            @SerializedName("item_code")
//            @Expose
//            private String itemCode;
//            @SerializedName("category_id")
//            @Expose
//            private String categoryId;
//            @SerializedName("subcategory_id")
//            @Expose
//            private String subcategoryId;
//            @SerializedName("organisation")
//            @Expose
//            private String organisation;
//            @SerializedName("item_name")
//            @Expose
//            private String itemName;
//            @SerializedName("item_display_name")
//            @Expose
//            private String itemDisplayName;
//            @SerializedName("item_short_description")
//            @Expose
//            private String itemShortDescription;
//            @SerializedName("item_long_description")
//            @Expose
//            private String itemLongDescription;
//            @SerializedName("item_cost_per_serve")
//            @Expose
//            private String itemCostPerServe;
//            @SerializedName("item_markup_per_serve")
//            @Expose
//            private String itemMarkupPerServe;
//            @SerializedName("item_serving_capacity")
//            @Expose
//            private String itemServingCapacity;
//            @SerializedName("setup_time_in_minute")
//            @Expose
//            private String setupTimeInMinute;
//            @SerializedName("max_time")
//            @Expose
//            private String maxTime;
//            @SerializedName("requirements")
//            @Expose
//            private String requirements;
//            @SerializedName("service_and_presentation")
//            @Expose
//            private String serviceAndPresentation;
//            @SerializedName("food_details")
//            @Expose
//            private String foodDetails;
//            @SerializedName("currency_id")
//            @Expose
//            private String currencyId;
//            @SerializedName("item_logo")
//            @Expose
//            private String itemLogo;
//            @SerializedName("item_status")
//            @Expose
//            private String itemStatus;
//            @SerializedName("arabic_item_code")
//            @Expose
//            private String arabicItemCode;
//            @SerializedName("arabic_item_name")
//            @Expose
//            private String arabicItemName;
//            @SerializedName("arabic_item_display_name")
//            @Expose
//            private String arabicItemDisplayName;
//            @SerializedName("arabic_item_short_description")
//            @Expose
//            private String arabicItemShortDescription;
//            @SerializedName("arabic_item_long_description")
//            @Expose
//            private String arabicItemLongDescription;
//            @SerializedName("arabic_item_cost_per_serve")
//            @Expose
//            private String arabicItemCostPerServe;
//            @SerializedName("arabic_item_markup_per_serve")
//            @Expose
//            private String arabicItemMarkupPerServe;
//            @SerializedName("arabic_item_serving_capacity")
//            @Expose
//            private String arabicItemServingCapacity;
//            @SerializedName("arabic_setup_time_in_minute")
//            @Expose
//            private String arabicSetupTimeInMinute;
//            @SerializedName("arabic_max_time")
//            @Expose
//            private String arabicMaxTime;
//            @SerializedName("arabic_requirements")
//            @Expose
//            private String arabicRequirements;
//            @SerializedName("arabic_service_and_presentation")
//            @Expose
//            private String arabicServiceAndPresentation;
//            @SerializedName("arabic_food_details")
//            @Expose
//            private String arabicFoodDetails;
//            @SerializedName("status")
//            @Expose
//            private String status;
//            @SerializedName("deleted_at")
//            @Expose
//            private Object deletedAt;
//            @SerializedName("created_at")
//            @Expose
//            private String createdAt;
//            @SerializedName("updated_at")
//            @Expose
//            private String updatedAt;
//            @SerializedName("item_logo_path")
//            @Expose
//            private String itemLogoPath;
//
//            public Integer getId() {
//                return id;
//            }
//
//            public void setId(Integer id) {
//                this.id = id;
//            }
//
//            public String getItemCode() {
//                return itemCode;
//            }
//
//            public void setItemCode(String itemCode) {
//                this.itemCode = itemCode;
//            }
//
//            public String getCategoryId() {
//                return categoryId;
//            }
//
//            public void setCategoryId(String categoryId) {
//                this.categoryId = categoryId;
//            }
//
//            public String getSubcategoryId() {
//                return subcategoryId;
//            }
//
//            public void setSubcategoryId(String subcategoryId) {
//                this.subcategoryId = subcategoryId;
//            }
//
//            public String getOrganisation() {
//                return organisation;
//            }
//
//            public void setOrganisation(String organisation) {
//                this.organisation = organisation;
//            }
//
//            public String getItemName() {
//                return itemName;
//            }
//
//            public void setItemName(String itemName) {
//                this.itemName = itemName;
//            }
//
//            public String getItemDisplayName() {
//                return itemDisplayName;
//            }
//
//            public void setItemDisplayName(String itemDisplayName) {
//                this.itemDisplayName = itemDisplayName;
//            }
//
//            public String getItemShortDescription() {
//                return itemShortDescription;
//            }
//
//            public void setItemShortDescription(String itemShortDescription) {
//                this.itemShortDescription = itemShortDescription;
//            }
//
//            public String getItemLongDescription() {
//                return itemLongDescription;
//            }
//
//            public void setItemLongDescription(String itemLongDescription) {
//                this.itemLongDescription = itemLongDescription;
//            }
//
//            public String getItemCostPerServe() {
//                return itemCostPerServe;
//            }
//
//            public void setItemCostPerServe(String itemCostPerServe) {
//                this.itemCostPerServe = itemCostPerServe;
//            }
//
//            public String getItemMarkupPerServe() {
//                return itemMarkupPerServe;
//            }
//
//            public void setItemMarkupPerServe(String itemMarkupPerServe) {
//                this.itemMarkupPerServe = itemMarkupPerServe;
//            }
//
//            public String getItemServingCapacity() {
//                return itemServingCapacity;
//            }
//
//            public void setItemServingCapacity(String itemServingCapacity) {
//                this.itemServingCapacity = itemServingCapacity;
//            }
//
//            public String getSetupTimeInMinute() {
//                return setupTimeInMinute;
//            }
//
//            public void setSetupTimeInMinute(String setupTimeInMinute) {
//                this.setupTimeInMinute = setupTimeInMinute;
//            }
//
//            public String getMaxTime() {
//                return maxTime;
//            }
//
//            public void setMaxTime(String maxTime) {
//                this.maxTime = maxTime;
//            }
//
//            public String getRequirements() {
//                return requirements;
//            }
//
//            public void setRequirements(String requirements) {
//                this.requirements = requirements;
//            }
//
//            public String getServiceAndPresentation() {
//                return serviceAndPresentation;
//            }
//
//            public void setServiceAndPresentation(String serviceAndPresentation) {
//                this.serviceAndPresentation = serviceAndPresentation;
//            }
//
//            public String getFoodDetails() {
//                return foodDetails;
//            }
//
//            public void setFoodDetails(String foodDetails) {
//                this.foodDetails = foodDetails;
//            }
//
//            public String getCurrencyId() {
//                return currencyId;
//            }
//
//            public void setCurrencyId(String currencyId) {
//                this.currencyId = currencyId;
//            }
//
//            public String getItemLogo() {
//                return itemLogo;
//            }
//
//            public void setItemLogo(String itemLogo) {
//                this.itemLogo = itemLogo;
//            }
//
//            public String getItemStatus() {
//                return itemStatus;
//            }
//
//            public void setItemStatus(String itemStatus) {
//                this.itemStatus = itemStatus;
//            }
//
//            public String getArabicItemCode() {
//                return arabicItemCode;
//            }
//
//            public void setArabicItemCode(String arabicItemCode) {
//                this.arabicItemCode = arabicItemCode;
//            }
//
//            public String getArabicItemName() {
//                return arabicItemName;
//            }
//
//            public void setArabicItemName(String arabicItemName) {
//                this.arabicItemName = arabicItemName;
//            }
//
//            public String getArabicItemDisplayName() {
//                return arabicItemDisplayName;
//            }
//
//            public void setArabicItemDisplayName(String arabicItemDisplayName) {
//                this.arabicItemDisplayName = arabicItemDisplayName;
//            }
//
//            public String getArabicItemShortDescription() {
//                return arabicItemShortDescription;
//            }
//
//            public void setArabicItemShortDescription(String arabicItemShortDescription) {
//                this.arabicItemShortDescription = arabicItemShortDescription;
//            }
//
//            public String getArabicItemLongDescription() {
//                return arabicItemLongDescription;
//            }
//
//            public void setArabicItemLongDescription(String arabicItemLongDescription) {
//                this.arabicItemLongDescription = arabicItemLongDescription;
//            }
//
//            public String getArabicItemCostPerServe() {
//                return arabicItemCostPerServe;
//            }
//
//            public void setArabicItemCostPerServe(String arabicItemCostPerServe) {
//                this.arabicItemCostPerServe = arabicItemCostPerServe;
//            }
//
//            public String getArabicItemMarkupPerServe() {
//                return arabicItemMarkupPerServe;
//            }
//
//            public void setArabicItemMarkupPerServe(String arabicItemMarkupPerServe) {
//                this.arabicItemMarkupPerServe = arabicItemMarkupPerServe;
//            }
//
//            public String getArabicItemServingCapacity() {
//                return arabicItemServingCapacity;
//            }
//
//            public void setArabicItemServingCapacity(String arabicItemServingCapacity) {
//                this.arabicItemServingCapacity = arabicItemServingCapacity;
//            }
//
//            public String getArabicSetupTimeInMinute() {
//                return arabicSetupTimeInMinute;
//            }
//
//            public void setArabicSetupTimeInMinute(String arabicSetupTimeInMinute) {
//                this.arabicSetupTimeInMinute = arabicSetupTimeInMinute;
//            }
//
//            public String getArabicMaxTime() {
//                return arabicMaxTime;
//            }
//
//            public void setArabicMaxTime(String arabicMaxTime) {
//                this.arabicMaxTime = arabicMaxTime;
//            }
//
//            public String getArabicRequirements() {
//                return arabicRequirements;
//            }
//
//            public void setArabicRequirements(String arabicRequirements) {
//                this.arabicRequirements = arabicRequirements;
//            }
//
//            public String getArabicServiceAndPresentation() {
//                return arabicServiceAndPresentation;
//            }
//
//            public void setArabicServiceAndPresentation(String arabicServiceAndPresentation) {
//                this.arabicServiceAndPresentation = arabicServiceAndPresentation;
//            }
//
//            public String getArabicFoodDetails() {
//                return arabicFoodDetails;
//            }
//
//            public void setArabicFoodDetails(String arabicFoodDetails) {
//                this.arabicFoodDetails = arabicFoodDetails;
//            }
//
//            public String getStatus() {
//                return status;
//            }
//
//            public void setStatus(String status) {
//                this.status = status;
//            }
//
//            public Object getDeletedAt() {
//                return deletedAt;
//            }
//
//            public void setDeletedAt(Object deletedAt) {
//                this.deletedAt = deletedAt;
//            }
//
//            public String getCreatedAt() {
//                return createdAt;
//            }
//
//            public void setCreatedAt(String createdAt) {
//                this.createdAt = createdAt;
//            }
//
//            public String getUpdatedAt() {
//                return updatedAt;
//            }
//
//            public void setUpdatedAt(String updatedAt) {
//                this.updatedAt = updatedAt;
//            }
//
//            public String getItemLogoPath() {
//                return itemLogoPath;
//            }
//
//            public void setItemLogoPath(String itemLogoPath) {
//                this.itemLogoPath = itemLogoPath;
//            }
//
//        }
//
//    }

}