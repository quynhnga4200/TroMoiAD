package tdc.edu.tromoiproject;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;

public class MyApplication extends Application {
   public static final String CHANNER_ID = "push" ;

    @Override
    public void onCreate() {
        super.onCreate();

        createChanelNotifytion();
    }

    private void createChanelNotifytion() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel Channel =new NotificationChannel(CHANNER_ID,"PUSH NOTIFYCATION",
                    NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(Channel);

        }

    }
}
