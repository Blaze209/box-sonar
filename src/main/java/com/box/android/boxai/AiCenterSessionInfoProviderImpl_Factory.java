package com.box.android.boxai;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes9.dex */
public final class AiCenterSessionInfoProviderImpl_Factory implements Factory<AiCenterSessionInfoProviderImpl> {
    @Override // javax.inject.Provider, jakarta.inject.Provider
    public AiCenterSessionInfoProviderImpl get() {
        return newInstance();
    }

    public static AiCenterSessionInfoProviderImpl_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static AiCenterSessionInfoProviderImpl newInstance() {
        return new AiCenterSessionInfoProviderImpl();
    }

    private static final class InstanceHolder {
        static final AiCenterSessionInfoProviderImpl_Factory INSTANCE = new AiCenterSessionInfoProviderImpl_Factory();

        private InstanceHolder() {
        }
    }
}
