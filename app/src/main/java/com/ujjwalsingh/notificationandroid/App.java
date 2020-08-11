package com.ujjwalsingh.notificationandroid;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;

import java.nio.channels.Channel;
import java.util.ArrayList;
import java.util.List;

public class App extends Application {
    public static final String CONSTANT_ONE="channel_one_id";
    public static final String CONSTANT_two="channel_two_id";
    @Override
    public void onCreate() {
        super.onCreate();

        if (Build.VERSION.SDK_INT >=Build.VERSION_CODES.O){
            NotificationChannel channel1 = new NotificationChannel(CONSTANT_ONE,"Channel 1", NotificationManager.IMPORTANCE_HIGH);
            channel1.setDescription("This is a channel one for app");
            NotificationChannel channel2 = new NotificationChannel(CONSTANT_two,"Channel 2", NotificationManager.IMPORTANCE_DEFAULT);
            channel2.setDescription("This is a channel two for app");

            NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            List<NotificationChannel> list = new ArrayList<>();
            list.add(channel1);
            list.add(channel2);
            manager.createNotificationChannels(list);

        }
    }
}
