package com.box.android.contentpicker.uploadcontent;

import com.box.android.domain.services.IContentFileService;
import com.box.android.domain.services.IUploadFileProvider;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes10.dex */
public final class UploadContentEnvironment_Factory implements Factory<UploadContentEnvironment> {
    private final Provider<IContentFileService> contentFileServiceProvider;
    private final Provider<IUploadFileProvider> uploadFileProvider;

    private UploadContentEnvironment_Factory(Provider<IUploadFileProvider> provider, Provider<IContentFileService> provider2) {
        this.uploadFileProvider = provider;
        this.contentFileServiceProvider = provider2;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public UploadContentEnvironment get() {
        return newInstance(this.uploadFileProvider.get(), this.contentFileServiceProvider.get());
    }

    public static UploadContentEnvironment_Factory create(Provider<IUploadFileProvider> provider, Provider<IContentFileService> provider2) {
        return new UploadContentEnvironment_Factory(provider, provider2);
    }

    public static UploadContentEnvironment newInstance(IUploadFileProvider iUploadFileProvider, IContentFileService iContentFileService) {
        return new UploadContentEnvironment(iUploadFileProvider, iContentFileService);
    }
}
