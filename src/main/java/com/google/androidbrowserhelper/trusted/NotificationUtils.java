package com.google.androidbrowserhelper.trusted;

import android.app.NotificationChannel;
import android.content.Context;
import androidx.core.app.NotificationManagerCompat;
import java.util.Locale;
import sdk.pendo.io.models.SessionDataKt;

/* JADX INFO: loaded from: classes13.dex */
public class NotificationUtils {
    private NotificationUtils() {
    }

    public static boolean areNotificationsEnabled(Context context, String str) {
        if (!NotificationManagerCompat.from(context).areNotificationsEnabled()) {
            return false;
        }
        NotificationChannel notificationChannel = NotificationManagerCompat.from(context).getNotificationChannel(channelNameToId(str));
        return notificationChannel == null || notificationChannel.getImportance() != 0;
    }

    public static void createNotificationChannel(Context context, String str) {
        NotificationManagerCompat.from(context).createNotificationChannel(new NotificationChannel(channelNameToId(str), str, 3));
    }

    private static String channelNameToId(String str) {
        return str.toLowerCase(Locale.ROOT).replace(' ', SessionDataKt.UNDERSCORE) + "_channel_id";
    }
}
