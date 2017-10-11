package com.example.hp.inbox_notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    //creating Method
    public void sendInboxStyleNotification(View view) {
        getPendingIntent(); // Calling method

        /*
           Builder class for NotificationCompat objects. It helps in constructing the typical
             notification layouts.
         */
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this)
                //Setting Title
                .setContentTitle("EVENT DETAIL")
                //Setting Text
                .setContentText("Inbox Notification!!")
                //Setting Icon
                .setSmallIcon(R.mipmap.ic_launcher);

        Notification notification = null;
        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            notification = new NotificationCompat.InboxStyle(builder)
                    //Adding Notifications
                    .addLine("Helloo..!").addLine("How are you?")
                    .addLine("HIII !!").addLine("i am fine...")
                    .addLine("what about you? all is well?")
                    .addLine("Yes, every thing is all right..")
                    .build();
            //  Auto cancel notification flag
            notification.flags |= Notification.FLAG_AUTO_CANCEL;
            NotificationManager notificationManager = getNotificationManager();//Creating object
            notificationManager.notify(0, notification);
        }
    }
    //Creating PendingIntent Method()
    public PendingIntent getPendingIntent() {
        return PendingIntent.getActivity(this, 0, new Intent(this,
                Notification_Alert.class), 0);
    }
    //Creating getNotificationManager() method to get the Notifications
    private NotificationManager getNotificationManager() {
        return (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
    }

}