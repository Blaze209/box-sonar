package com.box.android.preview.boxcanvas;

import dagger.internal.Factory;
import dagger.internal.Provider;
import okhttp3.OkHttpClient;

/* JADX INFO: loaded from: classes12.dex */
public final class CanvasAuthorizer_Factory implements Factory<CanvasAuthorizer> {
    private final Provider<OkHttpClient> clientProvider;

    private CanvasAuthorizer_Factory(Provider<OkHttpClient> provider) {
        this.clientProvider = provider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public CanvasAuthorizer get() {
        return newInstance(this.clientProvider.get());
    }

    public static CanvasAuthorizer_Factory create(Provider<OkHttpClient> provider) {
        return new CanvasAuthorizer_Factory(provider);
    }

    public static CanvasAuthorizer newInstance(OkHttpClient okHttpClient) {
        return new CanvasAuthorizer(okHttpClient);
    }
}
