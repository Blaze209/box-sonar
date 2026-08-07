package com.microsoft.intune.mam.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Build;

/* JADX INFO: loaded from: classes3.dex */
public final class MAMBroadcastReceiverCompat {
    private MAMBroadcastReceiverCompat() {
    }

    public static void registerReceiver(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, boolean z) {
        int i;
        if (Build.VERSION.SDK_INT >= 33) {
            i = z ? 2 : 4;
        } else {
            i = 0;
        }
        context.registerReceiver(broadcastReceiver, intentFilter, i);
    }
}
