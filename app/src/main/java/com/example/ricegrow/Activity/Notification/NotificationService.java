package com.example.ricegrow.Activity.Notification;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;

import java.util.Calendar;

public class NotificationService extends Service {

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        scheduleAlarm(this, 7,0, 123);
        scheduleAlarm(this, 13, 0, 321);

        // Return START_STICKY to ensure the service continues running even if it's killed by the system
        return START_STICKY;
    }

    private void scheduleAlarm(Context context, int hour, int minute, int code) {
        // Set the time for the alarm to trigger (7 AM)
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.set(Calendar.HOUR_OF_DAY, hour);
        calendar.set(Calendar.MINUTE, minute);
        calendar.set(Calendar.SECOND, 0);

        // If the time is in the past, add one day to the calendar
        if (calendar.getTimeInMillis() < System.currentTimeMillis()) {
            calendar.add(Calendar.DAY_OF_MONTH, 1);
        }

        // Create an intent to the AlarmReceiver
        Intent intent = new Intent(context, AlarmReceiver.class);

        // Create a unique request code for the pending intent

        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, code, intent, PendingIntent.FLAG_IMMUTABLE);

        // Get the AlarmManager
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);

        // Set the repeating alarm using RTC_WAKEUP to wake up the device if it's in sleep mode
        if (alarmManager != null) {
            alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), AlarmManager.INTERVAL_DAY, pendingIntent);
        }
    }
}
