package com.microsoft.intune.mam.client.notification;

import com.microsoft.intune.mam.policy.notification.MAMNotificationType;

/* JADX INFO: loaded from: classes3.dex */
public interface MAMNotificationReceiverRegistry {
    void registerReceiver(MAMNotificationReceiver mAMNotificationReceiver, MAMNotificationType mAMNotificationType);

    void unregisterReceiver(MAMNotificationReceiver mAMNotificationReceiver, MAMNotificationType mAMNotificationType);
}
