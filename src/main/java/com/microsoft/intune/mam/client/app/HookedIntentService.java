package com.microsoft.intune.mam.client.app;

import android.content.Intent;
import android.os.IBinder;

/* JADX INFO: loaded from: classes3.dex */
public interface HookedIntentService extends HookedService {
    IBinder onBindReal(Intent intent);
}
