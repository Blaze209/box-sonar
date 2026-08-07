package com.microsoft.identity.common.components;

import android.content.Context;
import com.microsoft.identity.common.internal.cache.SharedPreferencesFileManager;
import com.microsoft.identity.common.internal.util.SharedPreferenceLongStorage;
import com.microsoft.identity.common.java.util.ClockSkewManager;

/* JADX INFO: loaded from: classes14.dex */
public class AndroidClockSkewManager extends ClockSkewManager {
    private static final String SKEW_PREFERENCES_FILENAME = "com.microsoft.identity.client.clock_correction";

    public AndroidClockSkewManager(Context context) {
        super(new SharedPreferenceLongStorage(SharedPreferencesFileManager.getSharedPreferences(context, SKEW_PREFERENCES_FILENAME, null)));
        if (context == null) {
            throw new NullPointerException("context is marked non-null but is null");
        }
    }
}
