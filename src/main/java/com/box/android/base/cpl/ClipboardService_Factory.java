package com.box.android.base.cpl;

import android.content.Context;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes9.dex */
public final class ClipboardService_Factory implements Factory<ClipboardService> {
    private final Provider<Context> contextProvider;

    private ClipboardService_Factory(Provider<Context> provider) {
        this.contextProvider = provider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public ClipboardService get() {
        return newInstance(this.contextProvider.get());
    }

    public static ClipboardService_Factory create(Provider<Context> provider) {
        return new ClipboardService_Factory(provider);
    }

    public static ClipboardService newInstance(Context context) {
        return new ClipboardService(context);
    }
}
