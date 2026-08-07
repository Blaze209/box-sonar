package com.box.android.preview.annotations.managers;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes12.dex */
public final class BoxPdfAnnotationManager_Factory implements Factory<BoxPdfAnnotationManager> {
    @Override // javax.inject.Provider, jakarta.inject.Provider
    public BoxPdfAnnotationManager get() {
        return newInstance();
    }

    public static BoxPdfAnnotationManager_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static BoxPdfAnnotationManager newInstance() {
        return new BoxPdfAnnotationManager();
    }

    private static final class InstanceHolder {
        static final BoxPdfAnnotationManager_Factory INSTANCE = new BoxPdfAnnotationManager_Factory();

        private InstanceHolder() {
        }
    }
}
