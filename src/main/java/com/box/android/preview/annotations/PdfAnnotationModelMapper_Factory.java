package com.box.android.preview.annotations;

import android.content.Context;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes12.dex */
public final class PdfAnnotationModelMapper_Factory implements Factory<PdfAnnotationModelMapper> {
    private final Provider<Context> applicationContextProvider;

    private PdfAnnotationModelMapper_Factory(Provider<Context> provider) {
        this.applicationContextProvider = provider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public PdfAnnotationModelMapper get() {
        return newInstance(this.applicationContextProvider.get());
    }

    public static PdfAnnotationModelMapper_Factory create(Provider<Context> provider) {
        return new PdfAnnotationModelMapper_Factory(provider);
    }

    public static PdfAnnotationModelMapper newInstance(Context context) {
        return new PdfAnnotationModelMapper(context);
    }
}
