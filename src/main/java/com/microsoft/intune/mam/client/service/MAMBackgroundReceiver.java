package com.microsoft.intune.mam.client.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.microsoft.intune.mam.client.app.MAMComponents;

/* JADX INFO: loaded from: classes3.dex */
public final class MAMBackgroundReceiver extends BroadcastReceiver {
    private static final MAMBackgroundReceiverBehavior BEHAVIOR = (MAMBackgroundReceiverBehavior) MAMComponents.get(MAMBackgroundReceiverBehavior.class);

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        MAMBackgroundReceiverBehavior mAMBackgroundReceiverBehavior = BEHAVIOR;
        if (mAMBackgroundReceiverBehavior != null) {
            mAMBackgroundReceiverBehavior.onReceive(context, intent);
        }
    }
}
