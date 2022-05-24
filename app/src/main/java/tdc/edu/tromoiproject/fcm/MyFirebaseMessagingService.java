package tdc.edu.tromoiproject.fcm;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;


import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import java.util.Map;

import tdc.edu.tromoiproject.MyApplication;
import tdc.edu.tromoiproject.R;

public class MyFirebaseMessagingService extends FirebaseMessagingService {
    public static final String TAG = MyFirebaseMessagingService.class.getName();

    @Override
    public void onMessageReceived(@NonNull RemoteMessage message) {
        super.onMessageReceived(message);
//        RemoteMessage.Notification notification = message.getNotification();
//        if (notification == null){
//            return;
//        }
//        String strTitle = notification.getTitle();
//        String strMessage = notification.getBody();

//       DATA  messaging
        Map<String, String> stringMap = message.getData();

        String id = stringMap.get("user_id");
        String email =  stringMap.get("user_email");
        String name =  stringMap.get("user_name");
        String phone =  stringMap.get("user_phone");
        String pass =  stringMap.get("user_password");
        String avatar = stringMap.get("user_avatar");
        sendNotification(id,email,name,phone,pass,avatar);
    }

    private void sendNotification(String id, String email, String name, String phone, String strTitle, String strMessage) {
        Intent intent = new Intent(this, MyApplication.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        NotificationCompat.Builder builder = new
                NotificationCompat.Builder(this, MyApplication.CHANNER_ID)
                .setContentTitle(strTitle)
                .setContentText(strMessage)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentIntent(pendingIntent);
        Notification notification = builder.build();
        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        if (notificationManager != null) {
            notificationManager.notify(1, notification);
        }
        ;
    }

    @Override
    public void onNewToken(@NonNull String token) {
        super.onNewToken(token);
        Log.e(TAG, token);
    }
}
