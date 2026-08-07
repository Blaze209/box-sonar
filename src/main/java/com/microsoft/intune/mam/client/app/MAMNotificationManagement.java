package com.microsoft.intune.mam.client.app;

import android.app.Notification;
import android.app.NotificationManager;
import com.microsoft.intune.mam.client.CachedBehaviorProvider;

/* JADX INFO: loaded from: classes3.dex */
public final class MAMNotificationManagement {
    private static CachedBehaviorProvider<NotificationManagementBehavior> sCachedBehavior = new CachedBehaviorProvider<>(NotificationManagementBehavior.class);

    private MAMNotificationManagement() {
    }

    public static void notify(NotificationManager notificationManager, int i, Notification notification) {
        sCachedBehavior.get().notify(notificationManager, i, notification);
    }

    public static void notify(NotificationManager notificationManager, String str, int i, Notification notification) {
        sCachedBehavior.get().notify(notificationManager, str, i, notification);
    }

    public static void notifyAsPackage(NotificationManager notificationManager, String str, String str2, int i, Notification notification) {
        sCachedBehavior.get().notifyAsPackage(notificationManager, str, str2, i, notification);
    }
}
