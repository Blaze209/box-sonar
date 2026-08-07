package com.microsoft.intune.mam.client.app;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

/* JADX INFO: loaded from: classes3.dex */
public final class MAMPendingIntent {
    private static final PendingIntentFactory FACTORY = (PendingIntentFactory) MAMComponents.get(PendingIntentFactory.class);

    private MAMPendingIntent() {
    }

    public static PendingIntent getActivities(Context context, int i, Intent[] intentArr, int i2) {
        PendingIntentFactory pendingIntentFactory = FACTORY;
        if (pendingIntentFactory != null) {
            return pendingIntentFactory.getActivities(context, i, intentArr, i2);
        }
        return PendingIntent.getActivities(context, i, intentArr, i2);
    }

    public static PendingIntent getActivities(Context context, int i, Intent[] intentArr, int i2, Bundle bundle) {
        PendingIntentFactory pendingIntentFactory = FACTORY;
        if (pendingIntentFactory != null) {
            return pendingIntentFactory.getActivities(context, i, intentArr, i2, bundle);
        }
        return PendingIntent.getActivities(context, i, intentArr, i2, bundle);
    }

    public static PendingIntent getActivity(Context context, int i, Intent intent, int i2) {
        PendingIntentFactory pendingIntentFactory = FACTORY;
        if (pendingIntentFactory != null) {
            return pendingIntentFactory.getActivity(context, i, intent, i2);
        }
        return PendingIntent.getActivity(context, i, intent, i2);
    }

    public static PendingIntent getActivity(Context context, int i, Intent intent, int i2, Bundle bundle) {
        PendingIntentFactory pendingIntentFactory = FACTORY;
        if (pendingIntentFactory != null) {
            return pendingIntentFactory.getActivity(context, i, intent, i2, bundle);
        }
        return PendingIntent.getActivity(context, i, intent, i2, bundle);
    }

    public static PendingIntent getBroadcast(Context context, int i, Intent intent, int i2) {
        PendingIntentFactory pendingIntentFactory = FACTORY;
        if (pendingIntentFactory != null) {
            return pendingIntentFactory.getBroadcast(context, i, intent, i2);
        }
        return PendingIntent.getBroadcast(context, i, intent, i2);
    }

    public static PendingIntent getService(Context context, int i, Intent intent, int i2) {
        PendingIntentFactory pendingIntentFactory = FACTORY;
        if (pendingIntentFactory != null) {
            return pendingIntentFactory.getService(context, i, intent, i2);
        }
        return PendingIntent.getService(context, i, intent, i2);
    }

    public static PendingIntent getForegroundService(Context context, int i, Intent intent, int i2) {
        PendingIntentFactory pendingIntentFactory = FACTORY;
        if (pendingIntentFactory != null) {
            return pendingIntentFactory.getForegroundService(context, i, intent, i2);
        }
        return PendingIntent.getForegroundService(context, i, intent, i2);
    }
}
