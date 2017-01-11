package ir.nikagram.Nika.Helper;

import android.annotation.TargetApi;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;

import ir.nikagram.messenger.ApplicationLoader;
import ir.nikagram.messenger.LocaleController;
import ir.nikagram.messenger.R;
import ir.nikagram.ui.LaunchActivity;

public class NotiFicationMaker {
    private static final int NOTIFICATION_ID = 21312;
    private static final int NOTIFICATION_ID_ANSWER = 21315;

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public static void createNotification() {
        NotificationManager notificationManager = (NotificationManager) ApplicationLoader.applicationContext.getSystemService(ApplicationLoader.applicationContext.NOTIFICATION_SERVICE);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(ApplicationLoader.applicationContext)
                .setContentTitle(LocaleController.getString("GhostModeIsActive", R.string.GhostModeIsActive))
                .setContentText(LocaleController.getString("GhostModeInfo", R.string.GhostModeInfo))
                .setSmallIcon(R.drawable.ic_ghost)
                .setOngoing(true)
                .setAutoCancel(false);

        Intent intent = new Intent(ApplicationLoader.applicationContext, LaunchActivity.class);
        intent.setAction(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_LAUNCHER);

        TaskStackBuilder stackBuilder = TaskStackBuilder.create(ApplicationLoader.applicationContext);
        stackBuilder.addParentStack(LaunchActivity.class);
        stackBuilder.addNextIntent(intent);

        PendingIntent pendingIntent = stackBuilder.getPendingIntent(0,  PendingIntent.FLAG_UPDATE_CURRENT);

        builder.setContentIntent(pendingIntent);

        notificationManager.notify(NOTIFICATION_ID, builder.build());
    }

    public static void createNotificationAnswer() {
        NotificationManager notificationManager = (NotificationManager) ApplicationLoader.applicationContext.getSystemService(ApplicationLoader.applicationContext.NOTIFICATION_SERVICE);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(ApplicationLoader.applicationContext)
                .setContentTitle("پاسخگوی خودکار فعال است")
                .setContentText("پیام پیشفرض در پاسخ به مخاطبین شما ارسال میشود")
                .setSmallIcon(R.drawable.ic_auto_answer)
                .setOngoing(true)
                .setAutoCancel(false);

        Intent intent = new Intent(ApplicationLoader.applicationContext, LaunchActivity.class);
        intent.setAction(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_LAUNCHER);

        TaskStackBuilder stackBuilder = TaskStackBuilder.create(ApplicationLoader.applicationContext);
        stackBuilder.addParentStack(LaunchActivity.class);
        stackBuilder.addNextIntent(intent);

        PendingIntent pendingIntent = stackBuilder.getPendingIntent(0,  PendingIntent.FLAG_UPDATE_CURRENT);

        builder.setContentIntent(pendingIntent);

        notificationManager.notify(NOTIFICATION_ID_ANSWER, builder.build());
    }

    public static void cancelNotification() {
        NotificationManager notificationManager = (NotificationManager)ApplicationLoader.applicationContext.getSystemService(ApplicationLoader.applicationContext.NOTIFICATION_SERVICE);

        notificationManager.cancel(NOTIFICATION_ID);
    }

    public static void cancelNotificationAnswer() {
        NotificationManager notificationManager = (NotificationManager)ApplicationLoader.applicationContext.getSystemService(ApplicationLoader.applicationContext.NOTIFICATION_SERVICE);

        notificationManager.cancel(NOTIFICATION_ID_ANSWER);
    }
}
