package com.microsoft.intune.mam.client.app;

import android.app.Notification;
import android.app.NotificationManager;

/* JADX INFO: loaded from: classes3.dex */
public interface NotificationManagementBehavior {
    void notify(NotificationManager notificationManager, int i, Notification notification);

    void notify(NotificationManager notificationManager, String str, int i, Notification notification);

    void notifyAsPackage(NotificationManager notificationManager, String str, String str2, int i, Notification notification);
}
