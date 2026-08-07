package com.box.android.contentpicker.uploadcontent;

import com.box.android.domain.services.IUploadFileProvider;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes10.dex */
public final class CaptureMediaEnvironment_Factory implements Factory<CaptureMediaEnvironment> {
    private final Provider<IUploadFileProvider> uploadFileProvider;

    private CaptureMediaEnvironment_Factory(Provider<IUploadFileProvider> provider) {
        this.uploadFileProvider = provider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public CaptureMediaEnvironment get() {
        return newInstance(this.uploadFileProvider.get());
    }

    public static CaptureMediaEnvironment_Factory create(Provider<IUploadFileProvider> provider) {
        return new CaptureMediaEnvironment_Factory(provider);
    }

    public static CaptureMediaEnvironment newInstance(IUploadFileProvider iUploadFileProvider) {
        return new CaptureMediaEnvironment(iUploadFileProvider);
    }
}
