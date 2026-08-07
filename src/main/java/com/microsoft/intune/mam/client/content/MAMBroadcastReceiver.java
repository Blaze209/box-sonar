package com.microsoft.intune.mam.client.content;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.microsoft.intune.mam.client.app.MAMComponents;

/* JADX INFO: loaded from: classes3.dex */
public abstract class MAMBroadcastReceiver extends BroadcastReceiver implements HookedBroadcastReceiver {
    private BroadcastReceiverBehavior mBehavior;
    private boolean mInitalized = false;

    @Override // com.microsoft.intune.mam.client.content.HookedBroadcastReceiver
    public final BroadcastReceiver asBroadcastReceiver() {
        return this;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        MAMComponents.initialize(context);
        if (!this.mInitalized) {
            this.mBehavior = (BroadcastReceiverBehavior) MAMComponents.get(BroadcastReceiverBehavior.class);
            this.mInitalized = true;
        }
        BroadcastReceiverBehavior broadcastReceiverBehavior = this.mBehavior;
        if (broadcastReceiverBehavior == null) {
            onMAMReceive(context, intent);
        } else {
            broadcastReceiverBehavior.onReceive(this, context, intent);
        }
    }
}
