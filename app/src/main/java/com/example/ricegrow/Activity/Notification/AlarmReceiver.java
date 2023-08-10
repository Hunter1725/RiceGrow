package com.example.ricegrow.Activity.Notification;

import static com.example.ricegrow.Activity.Planning.Plan.PlanGenerate.SHOW_FRAGMENT;

import android.Manifest;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.example.ricegrow.Activity.Main.MainActivity;
import com.example.ricegrow.DatabaseFiles.Model.PlanActivities;
import com.example.ricegrow.DatabaseFiles.Model.PlanStages;
import com.example.ricegrow.DatabaseFiles.Model.UserCrops;
import com.example.ricegrow.DatabaseFiles.RiceGrowDatabase;
import com.example.ricegrow.R;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AlarmReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        //Test notification
        RiceGrowDatabase db = RiceGrowDatabase.getInstance(context);
        List<String> content = new ArrayList<>();
        String intro = "Today you need to do:";
        content.add(intro);
        ArrayList<UserCrops> userCrops = (ArrayList<UserCrops>) db.userCropDao().getAllUserCrops();
        for (UserCrops userCrop : userCrops){
            ArrayList<PlanStages> planStages = (ArrayList<PlanStages>) db.planStageDao().getAllPlanStageByUserCropId(userCrop.getId());
            for (PlanStages planStage : planStages){
                if(planStage.getStartDate().isBefore(LocalDate.now().plusDays(1)) && planStage.getEndDate().isAfter(LocalDate.now())) {
                    ArrayList<PlanActivities> planActivities = (ArrayList<PlanActivities>) db.planActivityDao().getAllPlanActivitiesByPlanStageId(planStage.getId());
                    for (PlanActivities planActivity : planActivities) {
                        if (planActivity.getStartDate().isBefore(LocalDate.now().plusDays(1)) && planActivity.getEndDate().isAfter(LocalDate.now())){
                            String reminder ="- " + "\"" + db.activityDao().getActivityById(planActivity.getActivityId()).getName() + "\"" + " for the plan" + " \"" + userCrop.getName() + "\"";
                            content.add("\n" + reminder );
                        }
                    }
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (String cropStageString : content) {
            stringBuilder.append(cropStageString);
        }
        String title = "Reminder";
        String message = stringBuilder.toString();

        Bitmap image = BitmapFactory.decodeResource(context.getResources(), R.mipmap.logo);

        // Create an intent for the action (You can replace MainActivity.class with the desired activity)
        Intent actionIntent = new Intent(context, MainActivity.class);
        actionIntent.putExtra(SHOW_FRAGMENT, "planFragment"); // Add any extra data you need
        // Create the pending intent for the action
        PendingIntent actionPendingIntent = PendingIntent.getActivity(context, 1, actionIntent, PendingIntent.FLAG_MUTABLE);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, "channel1")
                .setSmallIcon(R.drawable.ic_bell)
                .setContentTitle(title)
                .setContentText("Todo list for today")
                .setColor(Color.GREEN)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setVisibility(NotificationCompat.VISIBILITY_PUBLIC)
                .setLargeIcon(image)
                .setContentIntent(actionPendingIntent)
                .setStyle(new NotificationCompat.BigTextStyle()
                        .setBigContentTitle("Reminder plans")
                        .bigText(message)
                        .setSummaryText("Reminder for farming plan"))
                .setAutoCancel(true);

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(context);
        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(context, "Please grant the notify permission", Toast.LENGTH_SHORT).show();
            return;
        }
        notificationManager.notify(1, builder.build());
        NotificationManagerCompat manager = NotificationManagerCompat.from(context);
    }
}

