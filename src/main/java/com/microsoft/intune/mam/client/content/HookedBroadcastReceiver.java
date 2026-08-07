package com.microsoft.intune.mam.client.content;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* JADX INFO: loaded from: classes3.dex */
public interface HookedBroadcastReceiver {
    BroadcastReceiver asBroadcastReceiver();

    void onMAMReceive(Context context, Intent intent);
}
