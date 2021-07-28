package com.mfundoza.services;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private static final int CHANNEL_ID = 0;
    NotificationManager notificationManager;
    Notification notification;
    Button notificationButton;
    Button cancelNotificationButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        notificationButton = (Button) findViewById(R.id.notificationButton);
        notificationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createNotification();
                createNotificationChannel();
            }
        });

        cancelNotificationButton = (Button) findViewById(R.id.cancelNotificationButton);
        cancelNotificationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cancelNotification();
            }
        });
    }

    private void cancelNotification() {
        notificationManager.cancelAll();
    }

    private void createNotification() {
        notification = new NotificationCompat.Builder(this, String.valueOf(CHANNEL_ID))
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setContentTitle("Services")
                .setContentText("This is my first notification!")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT).build();
    }

    private void createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "Standard Channel";
            String description = "The standard notification channel";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(String.valueOf(CHANNEL_ID), name, importance);
            channel.setDescription(description);
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }

        notificationManager.notify(CHANNEL_ID, notification);
    }
}