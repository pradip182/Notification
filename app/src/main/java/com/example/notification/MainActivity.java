package com.example.notification;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.app.NotificationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private NotificationManagerCompat notificationManagerCompat;

    private Button btnDisplayNotificaton;
    private Button btnDisplayNotificaton2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        notificationManagerCompat = NotificationManagerCompat.from(this);
        CreateChannel channel = new CreateChannel(this);
        channel.createChannel();

        btnDisplayNotificaton= findViewById(R.id.btnNotification);
        btnDisplayNotificaton2= findViewById(R.id.btnNotification2);

        btnDisplayNotificaton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DisplayNotification();

            }

        });
        btnDisplayNotificaton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DisplayNotification2();
            }


        });


    }

    private void DisplayNotification(){
        Notification notification=new NotificationCompat.Builder(this,CreateChannel.CHANNEL_1)
                .setSmallIcon(R.drawable.notification1)
                .setContentTitle("First Message")
                .setContentText("First message body")
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .build();
        notificationManagerCompat.notify(1,notification);
    }

    private void DisplayNotification2(){
        Notification notification=new NotificationCompat.Builder(this,CreateChannel.CHANNEL_1)
                .setSmallIcon(R.drawable.notification2)
                .setContentTitle("Second Message")
                .setContentText("Second message body")
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .build();
        notificationManagerCompat.notify(2,notification);
    }
}


