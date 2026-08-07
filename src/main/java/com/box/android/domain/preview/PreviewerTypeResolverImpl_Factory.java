package com.box.android.domain.preview;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes11.dex */
public final class PreviewerTypeResolverImpl_Factory implements Factory<PreviewerTypeResolverImpl> {
    @Override // javax.inject.Provider, jakarta.inject.Provider
    public PreviewerTypeResolverImpl get() {
        return newInstance();
    }

    public static PreviewerTypeResolverImpl_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static PreviewerTypeResolverImpl newInstance() {
        return new PreviewerTypeResolverImpl();
    }

    private static final class InstanceHolder {
        static final PreviewerTypeResolverImpl_Factory INSTANCE = new PreviewerTypeResolverImpl_Factory();

        private InstanceHolder() {
        }
    }
}
