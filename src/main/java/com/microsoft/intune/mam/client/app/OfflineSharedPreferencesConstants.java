package com.microsoft.intune.mam.client.app;

import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class OfflineSharedPreferencesConstants {
    public static final String LOCAL_SETTINGS_BASE_SHARED_PREFS_NAME = "com.microsoft.intune.mam.local";
    public static final String MAMWE_ACCOUNT_REGISTRY_SHARED_PREFS_NAME = "com.microsoft.intune.mam.accountRegistry";
    public static final String MAM_ENROLLED_IDENTITIES_CACHE_SHARED_PREFS_NAME = "com.microsoft.intune.mam.enrolledIdentities";
    public static final String MAM_ENROLLMENT_STATUS_CACHE_SHARED_PREFS_NAME = "com.microsoft.intune.mam.enrollmentStatus";
    public static final String MAM_SERVICE_URL_CACHE_SHARED_PREFS_NAME = "com.microsoft.intune.mam.mamServiceUrls";
    public static final String RETRY_TIMER_RECORDS_SHARED_PREFS_NAME = "com.microsoft.intune.mam.RetryTimers";
    public static final String SESSION_DURATION_STORE_SHARED_PREFS_NAME = "com.microsoft.intune.mam.sessionDuration";
    public static final String USER_LOCAL_SETTINGS_SHARED_PREFS_NAME = "com.microsoft.intune.mam.user.local";

    private OfflineSharedPreferencesConstants() {
    }

    public static List<String> getSharedPrefsNames() {
        return Arrays.asList(MAMWE_ACCOUNT_REGISTRY_SHARED_PREFS_NAME, MAM_ENROLLMENT_STATUS_CACHE_SHARED_PREFS_NAME, SESSION_DURATION_STORE_SHARED_PREFS_NAME, LOCAL_SETTINGS_BASE_SHARED_PREFS_NAME, RETRY_TIMER_RECORDS_SHARED_PREFS_NAME, MAM_ENROLLED_IDENTITIES_CACHE_SHARED_PREFS_NAME, MAM_SERVICE_URL_CACHE_SHARED_PREFS_NAME, USER_LOCAL_SETTINGS_SHARED_PREFS_NAME);
    }
}
