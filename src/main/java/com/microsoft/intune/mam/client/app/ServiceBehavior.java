package com.microsoft.intune.mam.client.app;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;

/* JADX INFO: loaded from: classes3.dex */
public interface ServiceBehavior {
    void attachBaseContext(HookedService hookedService, Context context);

    IBinder onBind(Intent intent);

    void onMAMStart(Intent intent, int i);

    int onMAMStartCommand(Intent intent, int i, int i2);

    void onStart(Intent intent, int i);

    int onStartCommand(Intent intent, int i, int i2);
}
