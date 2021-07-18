package com.mfundoza.services;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private final String APP_NAME = getText(R.string.app_name).toString();
    private String Channel_ID = "main_channel";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void createNotification(View view) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, Channel_ID)
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setContentTitle(APP_NAME)
                .setContentText("This is my first notification!")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);
    }
}