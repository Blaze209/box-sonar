package com.box.android.observability;

import android.content.Context;
import android.content.Intent;
import com.microsoft.intune.mam.client.content.MAMBroadcastReceiver;
import dagger.hilt.android.internal.managers.BroadcastReceiverComponentManager;
import dagger.hilt.internal.UnsafeCasts;

/* JADX INFO: loaded from: classes12.dex */
public abstract class Hilt_DiagnosticsNotificationHandler extends MAMBroadcastReceiver {
    private volatile boolean injected = false;
    private final Object injectedLock = new Object();

    public void onMAMReceive(Context context, Intent intent) {
        inject(context);
    }

    protected void inject(Context context) {
        if (this.injected) {
            return;
        }
        synchronized (this.injectedLock) {
            if (!this.injected) {
                ((DiagnosticsNotificationHandler_GeneratedInjector) BroadcastReceiverComponentManager.generatedComponent(context)).injectDiagnosticsNotificationHandler((DiagnosticsNotificationHandler) UnsafeCasts.unsafeCast(this));
                this.injected = true;
            }
        }
    }
}
