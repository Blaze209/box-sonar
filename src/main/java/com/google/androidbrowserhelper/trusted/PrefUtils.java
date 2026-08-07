package com.google.androidbrowserhelper.trusted;

import android.content.Context;
import android.content.SharedPreferences;

/* JADX INFO: loaded from: classes13.dex */
public class PrefUtils {
    private static final String KEY_HAS_REQUESTED_NOTIFICATION_PERMISSION = "HAS_REQUESTED_NOTIFICATION_PERMISSION";
    private static final String SHARED_PREFERENCES_NAME = "com.google.androidbrowserhelper";

    private PrefUtils() {
    }

    public static SharedPreferences getAppSharedPreferences(Context context) {
        return context.getApplicationContext().getSharedPreferences("com.google.androidbrowserhelper", 0);
    }

    public static boolean hasRequestedNotificationPermission(Context context) {
        return getAppSharedPreferences(context).getBoolean(KEY_HAS_REQUESTED_NOTIFICATION_PERMISSION, false);
    }

    public static void setHasRequestedNotificationPermission(Context context) {
        getAppSharedPreferences(context).edit().putBoolean(KEY_HAS_REQUESTED_NOTIFICATION_PERMISSION, true).apply();
    }
}
