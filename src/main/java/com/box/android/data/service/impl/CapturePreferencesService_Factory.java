package com.box.android.data.service.impl;

import android.content.SharedPreferences;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class CapturePreferencesService_Factory implements Factory<CapturePreferencesService> {
    private final Provider<SharedPreferences> captureSharedPrefsProvider;

    private CapturePreferencesService_Factory(Provider<SharedPreferences> captureSharedPrefsProvider) {
        this.captureSharedPrefsProvider = captureSharedPrefsProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public CapturePreferencesService get() {
        return newInstance(this.captureSharedPrefsProvider.get());
    }

    public static CapturePreferencesService_Factory create(Provider<SharedPreferences> captureSharedPrefsProvider) {
        return new CapturePreferencesService_Factory(captureSharedPrefsProvider);
    }

    public static CapturePreferencesService newInstance(SharedPreferences captureSharedPrefs) {
        return new CapturePreferencesService(captureSharedPrefs);
    }
}
