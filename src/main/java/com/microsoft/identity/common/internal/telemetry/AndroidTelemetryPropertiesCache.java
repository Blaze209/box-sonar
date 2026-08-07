package com.microsoft.identity.common.internal.telemetry;

import android.content.Context;
import com.microsoft.identity.common.SharedPreferenceStringStorage;
import com.microsoft.identity.common.java.telemetry.TelemetryPropertiesCache;

/* JADX INFO: loaded from: classes14.dex */
@Deprecated
public class AndroidTelemetryPropertiesCache extends TelemetryPropertiesCache {
    private static final String SHARED_PREFS_NAME = "com.microsoft.common.telemetry-properties";

    public AndroidTelemetryPropertiesCache(Context context) {
        super(new SharedPreferenceStringStorage(context, SHARED_PREFS_NAME));
        if (context == null) {
            throw new NullPointerException("context is marked non-null but is null");
        }
    }
}
