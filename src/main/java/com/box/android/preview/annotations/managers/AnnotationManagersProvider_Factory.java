package com.box.android.preview.annotations.managers;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes12.dex */
public final class AnnotationManagersProvider_Factory implements Factory<AnnotationManagersProvider> {
    @Override // javax.inject.Provider, jakarta.inject.Provider
    public AnnotationManagersProvider get() {
        return newInstance();
    }

    public static AnnotationManagersProvider_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static AnnotationManagersProvider newInstance() {
        return new AnnotationManagersProvider();
    }

    private static final class InstanceHolder {
        static final AnnotationManagersProvider_Factory INSTANCE = new AnnotationManagersProvider_Factory();

        private InstanceHolder() {
        }
    }
}
