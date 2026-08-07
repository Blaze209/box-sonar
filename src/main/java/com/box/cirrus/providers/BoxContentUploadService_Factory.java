package com.box.cirrus.providers;

import com.box.android.common.utilities.ResourcesProvider;
import com.box.android.domain.services.IUploadFileProvider;
import com.box.android.domain.services.IUploadFileService;
import dagger.internal.Factory;
import dagger.internal.Provider;
import kotlinx.coroutines.CoroutineDispatcher;

/* JADX INFO: loaded from: classes13.dex */
public final class BoxContentUploadService_Factory implements Factory<BoxContentUploadService> {
    private final Provider<CoroutineDispatcher> coroutineDispatcherProvider;
    private final Provider<ResourcesProvider> resourcesProvider;
    private final Provider<IUploadFileProvider> uploadFileProvider;
    private final Provider<IUploadFileService> uploadFileServiceProvider;

    private BoxContentUploadService_Factory(Provider<IUploadFileService> provider, Provider<IUploadFileProvider> provider2, Provider<ResourcesProvider> provider3, Provider<CoroutineDispatcher> provider4) {
        this.uploadFileServiceProvider = provider;
        this.uploadFileProvider = provider2;
        this.resourcesProvider = provider3;
        this.coroutineDispatcherProvider = provider4;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public BoxContentUploadService get() {
        return newInstance(this.uploadFileServiceProvider.get(), this.uploadFileProvider.get(), this.resourcesProvider.get(), this.coroutineDispatcherProvider.get());
    }

    public static BoxContentUploadService_Factory create(Provider<IUploadFileService> provider, Provider<IUploadFileProvider> provider2, Provider<ResourcesProvider> provider3, Provider<CoroutineDispatcher> provider4) {
        return new BoxContentUploadService_Factory(provider, provider2, provider3, provider4);
    }

    public static BoxContentUploadService newInstance(IUploadFileService iUploadFileService, IUploadFileProvider iUploadFileProvider, ResourcesProvider resourcesProvider, CoroutineDispatcher coroutineDispatcher) {
        return new BoxContentUploadService(iUploadFileService, iUploadFileProvider, resourcesProvider, coroutineDispatcher);
    }
}
