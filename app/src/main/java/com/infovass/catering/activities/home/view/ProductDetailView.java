package com.infovass.catering.activities.home.view;

import com.infovass.catering.activities.home.model.ProductAddToCartResponse;
import com.infovass.catering.activities.home.model.ProductDetailResponse;
import com.infovass.catering.activities.home.model.RestourentAddToFevResponse;
import com.infovass.catering.activities.network.Loading;

public interface ProductDetailView extends Loading {
    void onSuccessGetProductDetailAPi(ProductDetailResponse productDetailResponse);
    void onSuccessAddToFevItemAPi(RestourentAddToFevResponse restourentAddToFevResponse);
    void onSuccessProductAddToCartAPi(ProductAddToCartResponse productAddToCartResponse);
}
