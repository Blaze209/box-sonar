package com.microsoft.intune.mam.client.notification;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.microsoft.intune.mam.client.app.MAMComponents;
import com.microsoft.intune.mam.policy.notification.NotificationReceiverBinderFactory;

/* JADX INFO: loaded from: classes3.dex */
public final class MAMNotificationReceiverService extends Service {
    private IBinder mBinder;

    @Override // android.app.Service, android.content.ContextWrapper
    protected void attachBaseContext(Context context) {
        MAMComponents.initialize(context);
        super.attachBaseContext(context);
    }

    @Override // android.app.Service
    public void onCreate() {
        NotificationReceiverBinderFactory notificationReceiverBinderFactory = (NotificationReceiverBinderFactory) MAMComponents.get(NotificationReceiverBinderFactory.class);
        this.mBinder = notificationReceiverBinderFactory == null ? null : notificationReceiverBinderFactory.create();
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.mBinder;
    }
}
