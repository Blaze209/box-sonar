package com.microsoft.intune.mam.client.notification;

import com.microsoft.intune.mam.policy.notification.MAMNotification;

/* JADX INFO: loaded from: classes3.dex */
public interface MAMNotificationReceiver {
    boolean onReceive(MAMNotification mAMNotification);
}
