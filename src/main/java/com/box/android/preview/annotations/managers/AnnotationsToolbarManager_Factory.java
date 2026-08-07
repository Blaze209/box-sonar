package com.box.android.preview.annotations.managers;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes12.dex */
public final class AnnotationsToolbarManager_Factory implements Factory<AnnotationsToolbarManager> {
    @Override // javax.inject.Provider, jakarta.inject.Provider
    public AnnotationsToolbarManager get() {
        return newInstance();
    }

    public static AnnotationsToolbarManager_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static AnnotationsToolbarManager newInstance() {
        return new AnnotationsToolbarManager();
    }

    private static final class InstanceHolder {
        static final AnnotationsToolbarManager_Factory INSTANCE = new AnnotationsToolbarManager_Factory();

        private InstanceHolder() {
        }
    }
}
