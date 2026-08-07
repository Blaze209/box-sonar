package com.box.android.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import okhttp3.OkHttpClient;

/* JADX INFO: loaded from: classes11.dex */
public final class BoxModule_Companion_ProvideAuthorizerOkHttpClientFactory implements Factory<OkHttpClient> {
    @Override // javax.inject.Provider, jakarta.inject.Provider
    public OkHttpClient get() {
        return provideAuthorizerOkHttpClient();
    }

    public static BoxModule_Companion_ProvideAuthorizerOkHttpClientFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static OkHttpClient provideAuthorizerOkHttpClient() {
        return (OkHttpClient) Preconditions.checkNotNullFromProvides(BoxModule.INSTANCE.provideAuthorizerOkHttpClient());
    }

    private static final class InstanceHolder {
        static final BoxModule_Companion_ProvideAuthorizerOkHttpClientFactory INSTANCE = new BoxModule_Companion_ProvideAuthorizerOkHttpClientFactory();

        private InstanceHolder() {
        }
    }
}
