package com.google.androidbrowserhelper.trusted;

import android.content.Context;
import android.content.SharedPreferences;

/* JADX INFO: loaded from: classes13.dex */
public class TwaSharedPreferencesManager {
    private static final String KEY_PROVIDER_PACKAGE = "KEY_PROVIDER_PACKAGE";
    private static final String PREFS_NAME = "TrustedWebActivityLauncherPrefs";
    private final SharedPreferences mSharedPreferences;

    public TwaSharedPreferencesManager(Context context) {
        this.mSharedPreferences = context.getSharedPreferences(PREFS_NAME, 0);
    }

    public void writeLastLaunchedProviderPackageName(String str) {
        this.mSharedPreferences.edit().putString(KEY_PROVIDER_PACKAGE, str).apply();
    }

    public String readLastLaunchedProviderPackageName() {
        return this.mSharedPreferences.getString(KEY_PROVIDER_PACKAGE, null);
    }
}
