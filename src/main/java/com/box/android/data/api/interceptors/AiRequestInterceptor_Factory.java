package com.box.android.data.api.interceptors;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes11.dex */
public final class AiRequestInterceptor_Factory implements Factory<AiRequestInterceptor> {
    @Override // javax.inject.Provider, jakarta.inject.Provider
    public AiRequestInterceptor get() {
        return newInstance();
    }

    public static AiRequestInterceptor_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static AiRequestInterceptor newInstance() {
        return new AiRequestInterceptor();
    }

    private static final class InstanceHolder {
        static final AiRequestInterceptor_Factory INSTANCE = new AiRequestInterceptor_Factory();

        private InstanceHolder() {
        }
    }
}
