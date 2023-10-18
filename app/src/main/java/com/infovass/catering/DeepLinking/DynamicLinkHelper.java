package com.infovass.catering.DeepLinking;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.widget.Toast;

import com.google.firebase.dynamiclinks.DynamicLink;
import com.google.firebase.dynamiclinks.FirebaseDynamicLinks;
import com.infovass.catering.R;
import com.infovass.catering.activities.Location.view.LocationActivity;
import com.infovass.catering.activities.SplashActivity;

public class DynamicLinkHelper {


    private Context context;
    Activity activity;
    String tittle = "", subtittle = "", img = "", id = "", type = "", price = "";

    public DynamicLinkHelper(Context context, Activity activity) {
        this.context = context;
        this.activity = activity;
    }

//    public void getDynamicLinkFromFirebase() {
//        FirebaseDynamicLinks.getInstance().getDynamicLink(activity.getIntent())
//                .addOnSuccessListener(pendingDynamicLinkData -> {
//                    Uri deepLink = null;
//                    if (pendingDynamicLinkData != null) {
//                        deepLink = pendingDynamicLinkData.getLink();
//                    }
//
//                    if (deepLink != null) {
//                        String id = deepLink.getQueryParameter("id");
//                        if (id != null) {
//                            // Handle the 'id' parameter or other parameters as needed
//                            Log.e("DeepLinkHandler", "Received dynamic link with id: " + id);
//                        }
//                    }
//                })
//                .addOnFailureListener(e -> {
//                    Toast.makeText(context, e.toString(), Toast.LENGTH_SHORT).show();
//                });
//    }


    public void getDynamicLinkFromFirebase() {
        FirebaseDynamicLinks.getInstance().getDynamicLink(activity.getIntent())
                .addOnSuccessListener(pendingDynamicLinkData -> {
                    Uri deepLink = null;
                    if (pendingDynamicLinkData != null) {
                        deepLink = pendingDynamicLinkData.getLink();
                    }

                    if (deepLink != null) {
                        String id = deepLink.getQueryParameter("id");
                        String type = deepLink.getQueryParameter("type");
                        String restaurant_Status = deepLink.getQueryParameter("restaurant_Status");
                        String min_time = deepLink.getQueryParameter("min_time");
                        if (id != null && type != null) {
                            // Pass the extracted parameters to the activity
                            ((SplashActivity) context).handleDynamicLinkData(id, type, restaurant_Status, min_time);

                            Log.e("DeepLinkHandler", "Received dynamic link with id: " + id);
                        }
                    }else{
                        Intent intent = new Intent(context, LocationActivity.class);
                        context.startActivity(intent);
                        activity.overridePendingTransition(R.anim.left_slide_in, R.anim.right_slide_out);

                        activity.finish();
                    }
                })
                .addOnFailureListener(e -> {
                    Toast.makeText(context, e.toString(), Toast.LENGTH_SHORT).show();
                });
    }


    public void createDynamicLinkForFirebase(String title, String img, String id, String type, String subtittle, String restaurant_Status, String min_time) {
        Uri deepLinkUri = Uri.parse("https://www.try-catering.com/deeplink?id=" + id + "&type=" + type + "&restaurant_Status=" + restaurant_Status + "&min_time=" + min_time);

        DynamicLink dynamicLink = FirebaseDynamicLinks.getInstance().createDynamicLink()
                .setLink(deepLinkUri)
                .setDomainUriPrefix("https://trycateringapp.page.link/")
                .setAndroidParameters(new DynamicLink.AndroidParameters.Builder().build())
                .setIosParameters(new DynamicLink.IosParameters.Builder("com.infovass.catering").build())
                .setSocialMetaTagParameters(new DynamicLink.SocialMetaTagParameters.Builder()
                        .setTitle(title)
                        .setDescription(subtittle)
                        .setImageUrl(Uri.parse(img))
                        .build())
                .buildDynamicLink();

        Uri dynamicLinkUri = dynamicLink.getUri();
        buildShortDynamicLink(dynamicLinkUri, title);
    }


    private void buildShortDynamicLink(Uri dynamicLinkUri, String title) {
        FirebaseDynamicLinks.getInstance().createDynamicLink()
                .setLink(dynamicLinkUri)
                .setDomainUriPrefix("https://trycateringapp.page.link/")
                // Set other parameters if needed
                .buildShortDynamicLink()
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        Uri shortLink = task.getResult().getShortLink();
                        Uri flowchartLink = task.getResult().getPreviewLink();
                        Log.e("DeepLinkHandler", "Short Link: " + shortLink.toString());

                        shareLink(shortLink, title);
                    } else {
                        Log.e("DeepLinkHandler", "Error creating short link");
                    }
                });
    }

    private void shareLink(Uri shortLink, String title) {
        if (shortLink != null) {
            Intent shareIntent = new Intent(Intent.ACTION_SEND);
            shareIntent.setType("text/plain");
            shareIntent.putExtra(Intent.EXTRA_TEXT, shortLink.toString());
            shareIntent.putExtra(Intent.EXTRA_SUBJECT, title);  // Set the title as the subject of the shared message
            shareIntent.putExtra(Intent.EXTRA_TITLE, subtittle);  // Set the subtitle as the title of the shared message

            context.startActivity(Intent.createChooser(shareIntent, title));
        }
    }


}
