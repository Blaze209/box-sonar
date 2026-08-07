package com.microsoft.intune.mam.client.telemetry;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.SystemClock;
import com.microsoft.intune.mam.client.telemetry.events.MAMInterfaceError;
import com.microsoft.intune.mam.log.MAMLogger;
import com.microsoft.intune.mam.log.MAMLoggerProvider;

/* JADX INFO: loaded from: classes3.dex */
public class SessionDurationStore extends BaseSharedPrefs {
    private static final String KEY_SESSION_START_PREFIX = "sessionstart_";
    private static final MAMLogger LOGGER = MAMLoggerProvider.getLogger(SessionDurationStore.class);
    private static final long MAX_ENTRIES = 100;
    private static final String SHARED_PREFS_NAME = "com.microsoft.intune.mam.sessionDuration";

    public SessionDurationStore(Context context) {
        super(context, "com.microsoft.intune.mam.sessionDuration", true);
    }

    public void setSessionStart(String str) {
        clearIfNeeded();
        setTelemetrySessionStartFromSharedPrefs(str, SystemClock.elapsedRealtime());
    }

    public long getSessionStop() {
        return SystemClock.elapsedRealtime();
    }

    public Long getSessionDuration(String str) {
        return getSessionDuration(str, SystemClock.elapsedRealtime());
    }

    public Long getSessionDuration(String str, long j) {
        if (str == null) {
            return null;
        }
        Long telemetrySessionStartSharedPrefs = getTelemetrySessionStartSharedPrefs(str);
        clearTelemetrySessionStartFromSharedPrefs(str);
        if (telemetrySessionStartSharedPrefs == null) {
            LOGGER.info("No session start time found for sessionID: {0}", str);
            return null;
        }
        if (j < telemetrySessionStartSharedPrefs.longValue()) {
            LOGGER.error(MAMInterfaceError.SESSION_DURATION_INVALID_START, "Session start time was after the current time for sessionID: {0}", str);
            return null;
        }
        return Long.valueOf(j - telemetrySessionStartSharedPrefs.longValue());
    }

    private void clearIfNeeded() {
        getSetSharedPref(new BaseSharedPrefs.GetSetPref() { // from class: com.microsoft.intune.mam.client.telemetry.SessionDurationStore$$ExternalSyntheticLambda0
            @Override // com.microsoft.intune.mam.client.telemetry.BaseSharedPrefs.GetSetPref
            public final void execute(SharedPreferences sharedPreferences, SharedPreferences.Editor editor) {
                SessionDurationStore.lambda$clearIfNeeded$0(sharedPreferences, editor);
            }
        });
    }

    static /* synthetic */ void lambda$clearIfNeeded$0(SharedPreferences sharedPreferences, SharedPreferences.Editor editor) {
        if (sharedPreferences.getAll().size() > 100) {
            editor.clear();
        }
    }

    private Long getTelemetrySessionStartSharedPrefs(final String str) {
        return (Long) getSharedPref(new BaseSharedPrefs.GetPref() { // from class: com.microsoft.intune.mam.client.telemetry.SessionDurationStore$$ExternalSyntheticLambda3
            @Override // com.microsoft.intune.mam.client.telemetry.BaseSharedPrefs.GetPref
            public final Object execute(SharedPreferences sharedPreferences) {
                return SessionDurationStore.lambda$getTelemetrySessionStartSharedPrefs$1(str, sharedPreferences);
            }
        });
    }

    static /* synthetic */ Long lambda$getTelemetrySessionStartSharedPrefs$1(String str, SharedPreferences sharedPreferences) {
        long j = sharedPreferences.getLong(KEY_SESSION_START_PREFIX + str, -1L);
        if (j == -1) {
            return null;
        }
        return Long.valueOf(j);
    }

    private void clearTelemetrySessionStartFromSharedPrefs(final String str) {
        setSharedPref(new BaseSharedPrefs.SetPref() { // from class: com.microsoft.intune.mam.client.telemetry.SessionDurationStore$$ExternalSyntheticLambda1
            @Override // com.microsoft.intune.mam.client.telemetry.BaseSharedPrefs.SetPref
            public final void execute(SharedPreferences.Editor editor) {
                editor.remove(SessionDurationStore.KEY_SESSION_START_PREFIX + str);
            }
        });
    }

    private void setTelemetrySessionStartFromSharedPrefs(final String str, final long j) {
        setSharedPref(new BaseSharedPrefs.SetPref() { // from class: com.microsoft.intune.mam.client.telemetry.SessionDurationStore$$ExternalSyntheticLambda2
            @Override // com.microsoft.intune.mam.client.telemetry.BaseSharedPrefs.SetPref
            public final void execute(SharedPreferences.Editor editor) {
                SessionDurationStore.lambda$setTelemetrySessionStartFromSharedPrefs$3(str, j, editor);
            }
        });
    }

    static /* synthetic */ void lambda$setTelemetrySessionStartFromSharedPrefs$3(String str, long j, SharedPreferences.Editor editor) {
        String str2 = KEY_SESSION_START_PREFIX + str;
        LOGGER.info("Setting telemetry session [" + str + "] start time: " + j, new Object[0]);
        editor.putLong(str2, j);
    }
}
