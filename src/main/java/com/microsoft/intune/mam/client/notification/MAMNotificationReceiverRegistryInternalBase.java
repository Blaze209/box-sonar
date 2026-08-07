package com.microsoft.intune.mam.client.notification;

/* JADX INFO: loaded from: classes3.dex */
public interface MAMNotificationReceiverRegistryInternalBase<NotificationType, Notification> {
    boolean hasRegisteredReceiver(NotificationType notificationtype);

    boolean sendNotification(Notification notification);
}
