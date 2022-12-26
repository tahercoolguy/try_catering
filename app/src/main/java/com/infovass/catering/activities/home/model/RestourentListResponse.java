package com.infovass.catering.activities.home.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RestourentListResponse {

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
        private String deliveryCharge;
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
        @SerializedName("number_of_review")
        @Expose
        private Integer numberOfReview;
        @SerializedName("rating")
        @Expose
        private Integer rating;
        @SerializedName("offday")
        @Expose
        private Boolean offday;
        @SerializedName("Restaurant_Status")
        @Expose
        private Integer restaurantStatus;
        @SerializedName("is_favorite")
        @Expose
        private Boolean isFavorite;
        @SerializedName("cover_images")
        @Expose
        private List<CoverImage> coverImages = null;
        @SerializedName("modes")
        @Expose
        private List<Mode> modes = null;
        @SerializedName("logo_path")
        @Expose
        private String logoPath;
        @SerializedName("cover_image_path")
        @Expose
        private String coverImagePath;
        @SerializedName("credential")
        @Expose
        private Credential credential;

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

        public String getDeliveryCharge() {
            return deliveryCharge;
        }

        public void setDeliveryCharge(String deliveryCharge) {
            this.deliveryCharge = deliveryCharge;
        }

        public Object getMinOrder() {
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

        public String getCommission() {
            return commission;
        }

        public void setCommission(String commission) {
            this.commission = commission;
        }

        public String getMinimumTime() {
            return minimumTime;
        }

        public void setMinimumTime(String minimumTime) {
            this.minimumTime = minimumTime;
        }

        public String getStartTime() {
            return startTime;
        }

        public void setStartTime(String startTime) {
            this.startTime = startTime;
        }

        public String getEndTime() {
            return endTime;
        }

        public void setEndTime(String endTime) {
            this.endTime = endTime;
        }

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

        public Boolean getOffday() {
            return offday;
        }

        public void setOffday(Boolean offday) {
            this.offday = offday;
        }

        public Integer getRestaurantStatus() {
            return restaurantStatus;
        }

        public void setRestaurantStatus(Integer restaurantStatus) {
            this.restaurantStatus = restaurantStatus;
        }

        public Boolean getIsFavorite() {
            return isFavorite;
        }

        public void setIsFavorite(Boolean isFavorite) {
            this.isFavorite = isFavorite;
        }

        public List<CoverImage> getCoverImages() {
            return coverImages;
        }

        public void setCoverImages(List<CoverImage> coverImages) {
            this.coverImages = coverImages;
        }

        public List<Mode> getModes() {
            return modes;
        }

        public void setModes(List<Mode> modes) {
            this.modes = modes;
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

    public class CoverImage {

        @SerializedName("cover_image_path")
        @Expose
        private String coverImagePath;

        public String getCoverImagePath() {
            return coverImagePath;
        }

        public void setCoverImagePath(String coverImagePath) {
            this.coverImagePath = coverImagePath;
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
        private String emailVerifiedAt;
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

        public void setEmailVerifiedAt(String emailVerifiedAt) {
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
//        private Object minOrder;
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
//        private Object cashOrderPolicy;
//        @SerializedName("cancellation_policy")
//        @Expose
//        private Object cancellationPolicy;
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
//        @SerializedName("number_of_review")
//        @Expose
//        private Integer numberOfReview;
//        @SerializedName("rating")
//        @Expose
//        private Integer rating;
//        @SerializedName("modes")
//        @Expose
//        private List<Mode> modes = null;
//        @SerializedName("logo_path")
//        @Expose
//        private String logoPath;
//        @SerializedName("Restruant_Status")
//        @Expose
//        private String Restruant_Status;
//
//        public String getRestruant_Status() {
//            return Restruant_Status;
//        }
//
//        public void setRestruant_Status(String restruant_Status) {
//            Restruant_Status = restruant_Status;
//        }
//
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
//        public Integer getDeliveryCharge() {
//            return deliveryCharge;
//        }
//
//        public void setDeliveryCharge(Integer deliveryCharge) {
//            this.deliveryCharge = deliveryCharge;
//        }
//
//        public Object getMinOrder() {
//            return minOrder;
//        }
//
//        public void setMinOrder(Object minOrder) {
//            this.minOrder = minOrder;
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
//        public Object getCashOrderPolicy() {
//            return cashOrderPolicy;
//        }
//
//        public void setCashOrderPolicy(Object cashOrderPolicy) {
//            this.cashOrderPolicy = cashOrderPolicy;
//        }
//
//        public Object getCancellationPolicy() {
//            return cancellationPolicy;
//        }
//
//        public void setCancellationPolicy(Object cancellationPolicy) {
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
//        public List<Mode> getModes() {
//            return modes;
//        }
//
//        public void setModes(List<Mode> modes) {
//            this.modes = modes;
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
//    }

}