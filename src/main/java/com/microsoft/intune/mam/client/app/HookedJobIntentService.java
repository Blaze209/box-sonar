package com.microsoft.intune.mam.client.app;

import android.content.Intent;
import android.os.IBinder;

/* JADX INFO: loaded from: classes3.dex */
public interface HookedJobIntentService extends HookedService {
    IBinder onBindReal(Intent intent);

    void onMAMHandleWork(Intent intent);
}
