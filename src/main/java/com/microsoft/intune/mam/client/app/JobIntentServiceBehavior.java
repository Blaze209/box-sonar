package com.microsoft.intune.mam.client.app;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;

/* JADX INFO: loaded from: classes3.dex */
public interface JobIntentServiceBehavior extends ServiceBehavior {
    void attachBaseContext(HookedJobIntentService hookedJobIntentService, Context context);

    void onHandleWork(Intent intent);

    IBinder onMAMBind(Intent intent);
}
