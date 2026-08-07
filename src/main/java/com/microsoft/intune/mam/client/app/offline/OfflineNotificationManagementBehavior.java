package com.microsoft.intune.mam.client.app.offline;

import android.app.Notification;
import android.app.NotificationManager;
import com.microsoft.intune.mam.client.app.NotificationManagementBehavior;

/* JADX INFO: loaded from: classes3.dex */
public class OfflineNotificationManagementBehavior implements NotificationManagementBehavior {
    @Override // com.microsoft.intune.mam.client.app.NotificationManagementBehavior
    public void notify(NotificationManager notificationManager, int i, Notification notification) {
        notificationManager.notify(i, notification);
    }

    @Override // com.microsoft.intune.mam.client.app.NotificationManagementBehavior
    public void notify(NotificationManager notificationManager, String str, int i, Notification notification) {
        notificationManager.notify(str, i, notification);
    }

    @Override // com.microsoft.intune.mam.client.app.NotificationManagementBehavior
    public void notifyAsPackage(NotificationManager notificationManager, String str, String str2, int i, Notification notification) {
        notificationManager.notifyAsPackage(str, str2, i, notification);
    }
}
