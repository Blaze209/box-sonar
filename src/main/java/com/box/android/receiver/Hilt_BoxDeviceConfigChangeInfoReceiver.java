package com.box.android.receiver;

import android.content.Context;
import android.content.Intent;
import com.microsoft.intune.mam.client.content.MAMBroadcastReceiver;
import dagger.hilt.android.internal.managers.BroadcastReceiverComponentManager;
import dagger.hilt.internal.UnsafeCasts;

/* JADX INFO: loaded from: classes12.dex */
abstract class Hilt_BoxDeviceConfigChangeInfoReceiver extends MAMBroadcastReceiver {
    private volatile boolean injected = false;
    private final Object injectedLock = new Object();

    Hilt_BoxDeviceConfigChangeInfoReceiver() {
    }

    public void onMAMReceive(Context context, Intent intent) {
        inject(context);
    }

    protected void inject(Context context) {
        if (this.injected) {
            return;
        }
        synchronized (this.injectedLock) {
            if (!this.injected) {
                ((BoxDeviceConfigChangeInfoReceiver_GeneratedInjector) BroadcastReceiverComponentManager.generatedComponent(context)).injectBoxDeviceConfigChangeInfoReceiver((BoxDeviceConfigChangeInfoReceiver) UnsafeCasts.unsafeCast(this));
                this.injected = true;
            }
        }
    }
}
