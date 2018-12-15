package com.example.myapp;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import java.util.Timer;
import java.util.TimerTask;

public class NotificationService extends Service {


    @Override
    public void onCreate() {
        super.onCreate();

        Log.i("Notification", "AAAAAAAAAAAAAAAAAAAAAAAAASSSSASSSSSSSSSSSSSSSSSSSSSSSSSS");
    }

    Timer timer;

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Log.i("Notification", "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
        timer = new Timer();
        timer.schedule(new ShowNotification(), 3000, 7000); // перед, период (3, 7 сек)


        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i("Notification", "AAAAAAAAAAAAAAAAAAAAAAAAASSSSASSSSSSSSSSSSSSSSSSSSSSSSSS");

        timer.cancel();
    }

    private void setNotification() {
        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(this)
                        .setSmallIcon(R.drawable.x_nof)
                        .setContentTitle("Title")
                        .setContentText("text")
                        .setAutoCancel(true);

        Intent resultIntent = new Intent(this, MainActivity.class);
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        stackBuilder.addParentStack(MainActivity.class);
        stackBuilder.addNextIntent(resultIntent);
        PendingIntent resultPendingIntent = stackBuilder.getPendingIntent(
                0,
                PendingIntent.FLAG_UPDATE_CURRENT
        );
        mBuilder.setContentIntent(resultPendingIntent);
        NotificationManager mNotificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        mNotificationManager.notify(1, mBuilder.build());

    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    class ShowNotification extends TimerTask {
        @Override
        public void run() {
            setNotification();
        }
    }
}
