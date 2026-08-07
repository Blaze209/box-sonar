package com.box.android.data.service.impl.preview.helpers.legacycache;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes11.dex */
public final class PreviewerTypeLegacyCacheMapper_Factory implements Factory<PreviewerTypeLegacyCacheMapper> {
    @Override // javax.inject.Provider, jakarta.inject.Provider
    public PreviewerTypeLegacyCacheMapper get() {
        return newInstance();
    }

    public static PreviewerTypeLegacyCacheMapper_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static PreviewerTypeLegacyCacheMapper newInstance() {
        return new PreviewerTypeLegacyCacheMapper();
    }

    private static final class InstanceHolder {
        static final PreviewerTypeLegacyCacheMapper_Factory INSTANCE = new PreviewerTypeLegacyCacheMapper_Factory();

        private InstanceHolder() {
        }
    }
}
