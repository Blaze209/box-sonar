package com.microsoft.intune.mam.client.service;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import com.microsoft.intune.mam.client.app.MAMComponents;

/* JADX INFO: loaded from: classes3.dex */
public final class MAMBackgroundService extends IntentService {
    private MAMBackgroundServiceBehavior mBehavior;

    public MAMBackgroundService() {
        super(MAMBackgroundService.class.getName());
    }

    @Override // android.app.Service, android.content.ContextWrapper
    protected void attachBaseContext(Context context) {
        MAMComponents.initialize(context);
        super.attachBaseContext(context);
    }

    @Override // android.app.IntentService, android.app.Service
    public void onCreate() {
        super.onCreate();
        this.mBehavior = (MAMBackgroundServiceBehavior) MAMComponents.get(MAMBackgroundServiceBehavior.class);
    }

    @Override // android.app.IntentService
    protected void onHandleIntent(Intent intent) {
        MAMBackgroundServiceBehavior mAMBackgroundServiceBehavior = this.mBehavior;
        if (mAMBackgroundServiceBehavior != null) {
            mAMBackgroundServiceBehavior.onHandleIntent(intent);
        }
    }
}
