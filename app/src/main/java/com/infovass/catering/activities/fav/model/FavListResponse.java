package com.infovass.catering.activities.fav.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FavListResponse {

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
        @SerializedName("user_id")
        @Expose
        private Integer userId;
        @SerializedName("caterer_id")
        @Expose
        private Integer catererId;
        @SerializedName("is_favorite")
        @Expose
        private String isFavorite;
        @SerializedName("created_at")
        @Expose
        private String createdAt;
        @SerializedName("updated_at")
        @Expose
        private String updatedAt;
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

        public String getIsFavorite() {
            return isFavorite;
        }

        public void setIsFavorite(String isFavorite) {
            this.isFavorite = isFavorite;
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

        public Caterer getCaterer() {
            return caterer;
        }

        public void setCaterer(Caterer caterer) {
            this.caterer = caterer;
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
            private Object arabicSetupTimeInMinute;
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
            private Object discountValue;
            @SerializedName("start_date")
            @Expose
            private Object startDate;
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
            private Object deletedAt;
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

            public Object getArabicSetupTimeInMinute() {
                return arabicSetupTimeInMinute;
            }

            public void setArabicSetupTimeInMinute(Object arabicSetupTimeInMinute) {
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

            public Object getDiscountValue() {
                return discountValue;
            }

            public void setDiscountValue(Object discountValue) {
                this.discountValue = discountValue;
            }

            public Object getStartDate() {
                return startDate;
            }

            public void setStartDate(Object startDate) {
                this.startDate = startDate;
            }

            public Object getEndDate() {
                return endDate;
            }

            public void setEndDate(Object endDate) {
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

            public Object getDeletedAt() {
                return deletedAt;
            }

            public void setDeletedAt(Object deletedAt) {
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

    }

}
