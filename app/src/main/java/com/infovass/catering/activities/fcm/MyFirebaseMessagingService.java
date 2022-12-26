package com.infovass.catering.activities.fcm;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;
import android.util.Log;

import androidx.core.app.NotificationCompat;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.infovass.catering.R;
import com.infovass.catering.activities.MainActivity;
import com.infovass.catering.activities.network.Constants;

import org.json.JSONObject;

public class MyFirebaseMessagingService extends FirebaseMessagingService {
    private static final String TAG = "MyFirebaseMsgService";
    String notificationType = "0";


    /**
     * Called when message is received.
     *
     * @param remoteMessage Object representing the message received from Firebase Cloud Messaging.
     */
    // [START receive_message]
    public void onMessageReceived(RemoteMessage remoteMessage) {
        Log.d(TAG, "From: " + remoteMessage.getFrom());


        if (remoteMessage.getData().size() > 0) {
            Log.d(TAG, "Message data payload: " + remoteMessage.getData());
        }

        if (remoteMessage.getNotification() != null) {
            Log.d(TAG, "Message Notification Body: " + remoteMessage.getNotification().getBody());
        }

        if (remoteMessage.getNotification() == null) {
            String channelUrl = null;
            JSONObject sendBird = new JSONObject(remoteMessage.getData());
//            String message1 = sendBird.optString("info");
            try {

//                JSONObject jsonObject = new JSONObject(message1);

//                    sendNoti(this, sendBird.optString("title"), sendBird.optString("body"),"");
                handleNotification(this, sendBird.optString("title"), sendBird.optString("body"), "", sendBird, sendBird);


            } catch (Exception e) {
                String aa = "aa";

            }

        } else {

            sendNoti(this, remoteMessage.getNotification().getBody(), remoteMessage.getNotification().getBody(), remoteMessage.getNotification().getTitle());
        }
    }

    public void sendNoti(Context context, String message, String body, String notificationType) {
        Intent intent;

        intent = new Intent(context, MainActivity.class);


        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0 /* Request code */, intent,
                PendingIntent.FLAG_IMMUTABLE);
        Uri soundUri = Uri.parse(ContentResolver.SCHEME_ANDROID_RESOURCE + "://" + context.getApplicationContext().getPackageName() + "/" + R.raw.firebase_common_keep);
        NotificationManager mNotificationManager = (NotificationManager) context.getApplicationContext().getSystemService(Context.NOTIFICATION_SERVICE);
        NotificationChannel mChannel;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            mChannel = new NotificationChannel(Constants.CHANNEL_SIREN_ID, Constants.CHANNEL_SIREN_NAME, NotificationManager.IMPORTANCE_HIGH);
            mChannel.setLightColor(Color.GRAY);
            mChannel.enableLights(true);
            mChannel.setDescription(Constants.CHANNEL_SIREN_DESCRIPTION);
            AudioAttributes audioAttributes = new AudioAttributes.Builder()
                    .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                    .setUsage(AudioAttributes.USAGE_NOTIFICATION)
                    .build();
            mChannel.setSound(soundUri, audioAttributes);

            if (mNotificationManager != null) {
                mNotificationManager.createNotificationChannel(mChannel);
            }
        }

        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(context.getApplicationContext(), Constants.CHANNEL_SIREN_ID)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setLargeIcon(BitmapFactory.decodeResource(Resources.getSystem(), R.mipmap.ic_launcher))
                .setTicker(message)
                .setContentTitle(message)
                .setContentText(body)
                .setAutoCancel(true)
                .setLights(0xff0000ff, 300, 1000) // blue color
                .setWhen(System.currentTimeMillis())
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setContentIntent(pendingIntent);

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.O) {
            mBuilder.setSound(soundUri);
        }

        int NOTIFICATION_ID = 1; // Causes to update the same notification over and over again.
        if (mNotificationManager != null) {
            mNotificationManager.notify(NOTIFICATION_ID, mBuilder.build());
        }
    }


    private void handleNotification(Context context, String message, String body, String imageIcon, JSONObject jsonObject, JSONObject sendBird) {
        if (!NotificationS.isAppIsInBackground(context.getApplicationContext())) {
            // app is in foreground, broadcast the push message

//            if(sendBird.optString("notificationType").equalsIgnoreCase("endservice")) {
            Intent pushNotification = new Intent(Config.PUSH_NOTIFICATION);
            pushNotification.putExtra("message", message);
            pushNotification.putExtra("body", body);
            pushNotification.putExtra("statusService", sendBird.optString("notificationType"));

            LocalBroadcastManager.getInstance(context.getApplicationContext()).sendBroadcast(pushNotification);

//            }

            sendNoti(context.getApplicationContext(), message, body, imageIcon);
        } else {
            sendNoti(context.getApplicationContext(), message, body, imageIcon);

            // If the app is in background, firebase itself handles the notification
        }

    }
}
