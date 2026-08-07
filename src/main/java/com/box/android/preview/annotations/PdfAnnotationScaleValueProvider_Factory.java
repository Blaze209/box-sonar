package com.box.android.preview.annotations;

import dagger.internal.Factory;

/* JADX INFO: loaded from: classes12.dex */
public final class PdfAnnotationScaleValueProvider_Factory implements Factory<PdfAnnotationScaleValueProvider> {
    @Override // javax.inject.Provider, jakarta.inject.Provider
    public PdfAnnotationScaleValueProvider get() {
        return newInstance();
    }

    public static PdfAnnotationScaleValueProvider_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static PdfAnnotationScaleValueProvider newInstance() {
        return new PdfAnnotationScaleValueProvider();
    }

    private static final class InstanceHolder {
        static final PdfAnnotationScaleValueProvider_Factory INSTANCE = new PdfAnnotationScaleValueProvider_Factory();

        private InstanceHolder() {
        }
    }
}
