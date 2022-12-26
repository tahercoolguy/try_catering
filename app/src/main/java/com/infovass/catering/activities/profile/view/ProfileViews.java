package com.infovass.catering.activities.profile.view;

import com.infovass.catering.activities.network.Loading;
import com.infovass.catering.activities.profile.model.PagesResponse;
import com.infovass.catering.activities.profile.model.ProfileResponse;

public interface ProfileViews extends Loading {
    void onSuccessGetProfileAPi(ProfileResponse profileResponse);
    void onSuccessPagesAPi(PagesResponse pagesResponse);
}
