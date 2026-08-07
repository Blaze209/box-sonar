package com.microsoft.intune.mam.client.app;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;

/* JADX INFO: loaded from: classes3.dex */
public interface IntentServiceBehavior extends ServiceBehavior {
    void attachBaseContext(HookedIntentService hookedIntentService, Context context);

    IBinder onMAMBind(Intent intent);
}
