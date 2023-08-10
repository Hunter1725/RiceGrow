package com.example.ricegrow.Activity.Notification;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;

public class RiceGrow extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        createNotificationChannel();
    }

    private void createNotificationChannel() {
        NotificationChannel channel1 = new NotificationChannel("channel1", "Plan Reminder", NotificationManager.IMPORTANCE_HIGH);
        channel1.setDescription("This is an important channel for reminding users of the farming plan");

        NotificationManager manager = getSystemService(NotificationManager.class);
        manager.createNotificationChannel(channel1);
    }
}
