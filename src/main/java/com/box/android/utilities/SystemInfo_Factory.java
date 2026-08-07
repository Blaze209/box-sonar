package com.box.android.utilities;

import android.content.Context;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes13.dex */
public final class SystemInfo_Factory implements Factory<SystemInfo> {
    private final Provider<Context> contextProvider;

    private SystemInfo_Factory(Provider<Context> provider) {
        this.contextProvider = provider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public SystemInfo get() {
        return newInstance(this.contextProvider.get());
    }

    public static SystemInfo_Factory create(Provider<Context> provider) {
        return new SystemInfo_Factory(provider);
    }

    public static SystemInfo newInstance(Context context) {
        return new SystemInfo(context);
    }
}
