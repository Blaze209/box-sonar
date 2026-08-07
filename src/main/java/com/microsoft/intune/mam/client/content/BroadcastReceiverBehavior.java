package com.microsoft.intune.mam.client.content;

import android.content.Context;
import android.content.Intent;

/* JADX INFO: loaded from: classes3.dex */
public interface BroadcastReceiverBehavior {
    void onReceive(HookedBroadcastReceiver hookedBroadcastReceiver, Context context, Intent intent);
}
