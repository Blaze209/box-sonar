package com.microsoft.intune.mam.client.app;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

/* JADX INFO: loaded from: classes3.dex */
public interface PendingIntentFactory {
    PendingIntent getActivities(Context context, int i, Intent[] intentArr, int i2);

    PendingIntent getActivities(Context context, int i, Intent[] intentArr, int i2, Bundle bundle);

    PendingIntent getActivity(Context context, int i, Intent intent, int i2);

    PendingIntent getActivity(Context context, int i, Intent intent, int i2, Bundle bundle);

    PendingIntent getBroadcast(Context context, int i, Intent intent, int i2);

    PendingIntent getForegroundService(Context context, int i, Intent intent, int i2);

    PendingIntent getService(Context context, int i, Intent intent, int i2);
}
