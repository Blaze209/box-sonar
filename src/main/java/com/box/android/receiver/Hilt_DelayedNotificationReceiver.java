package com.box.android.receiver;

import android.content.Context;
import android.content.Intent;
import androidx.legacy.content.WakefulBroadcastReceiver;
import dagger.hilt.android.internal.managers.BroadcastReceiverComponentManager;
import dagger.hilt.internal.UnsafeCasts;

/* JADX INFO: loaded from: classes12.dex */
abstract class Hilt_DelayedNotificationReceiver extends WakefulBroadcastReceiver {
    private volatile boolean injected = false;
    private final Object injectedLock = new Object();

    Hilt_DelayedNotificationReceiver() {
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
                ((DelayedNotificationReceiver_GeneratedInjector) BroadcastReceiverComponentManager.generatedComponent(context)).injectDelayedNotificationReceiver((DelayedNotificationReceiver) UnsafeCasts.unsafeCast(this));
                this.injected = true;
            }
        }
    }
}
