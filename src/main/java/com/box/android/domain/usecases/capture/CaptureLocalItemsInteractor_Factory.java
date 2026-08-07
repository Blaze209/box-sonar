package com.box.android.domain.usecases.capture;

import com.box.android.domain.services.ICaptureHistoryFilesService;
import com.box.android.domain.services.ICaptureThumbnailService;
import com.box.android.domain.services.ILocalItemService;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class CaptureLocalItemsInteractor_Factory implements Factory<CaptureLocalItemsInteractor> {
    private final Provider<ICaptureHistoryFilesService> captureHistoryFilesServiceProvider;
    private final Provider<ICaptureThumbnailService> captureThumbnailServiceProvider;
    private final Provider<ILocalItemService> localItemServiceProvider;

    private CaptureLocalItemsInteractor_Factory(Provider<ILocalItemService> provider, Provider<ICaptureHistoryFilesService> provider2, Provider<ICaptureThumbnailService> provider3) {
        this.localItemServiceProvider = provider;
        this.captureHistoryFilesServiceProvider = provider2;
        this.captureThumbnailServiceProvider = provider3;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public CaptureLocalItemsInteractor get() {
        return newInstance(this.localItemServiceProvider.get(), this.captureHistoryFilesServiceProvider.get(), this.captureThumbnailServiceProvider.get());
    }

    public static CaptureLocalItemsInteractor_Factory create(Provider<ILocalItemService> provider, Provider<ICaptureHistoryFilesService> provider2, Provider<ICaptureThumbnailService> provider3) {
        return new CaptureLocalItemsInteractor_Factory(provider, provider2, provider3);
    }

    public static CaptureLocalItemsInteractor newInstance(ILocalItemService iLocalItemService, ICaptureHistoryFilesService iCaptureHistoryFilesService, ICaptureThumbnailService iCaptureThumbnailService) {
        return new CaptureLocalItemsInteractor(iLocalItemService, iCaptureHistoryFilesService, iCaptureThumbnailService);
    }
}
