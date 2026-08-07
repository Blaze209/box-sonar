package com.box.android.capture.viewmodel;

import com.box.android.domain.services.ICaptureThumbnailService;
import com.box.android.domain.usecases.capture.CaptureHistoryUseCase;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes10.dex */
public final class CaptureHistoryButtonViewModel_Factory implements Factory<CaptureHistoryButtonViewModel> {
    private final Provider<CaptureHistoryUseCase> captureHistoryInteractorProvider;
    private final Provider<ICaptureThumbnailService> captureThumbnailServiceProvider;

    private CaptureHistoryButtonViewModel_Factory(Provider<CaptureHistoryUseCase> provider, Provider<ICaptureThumbnailService> provider2) {
        this.captureHistoryInteractorProvider = provider;
        this.captureThumbnailServiceProvider = provider2;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public CaptureHistoryButtonViewModel get() {
        return newInstance(this.captureHistoryInteractorProvider.get(), this.captureThumbnailServiceProvider.get());
    }

    public static CaptureHistoryButtonViewModel_Factory create(Provider<CaptureHistoryUseCase> provider, Provider<ICaptureThumbnailService> provider2) {
        return new CaptureHistoryButtonViewModel_Factory(provider, provider2);
    }

    public static CaptureHistoryButtonViewModel newInstance(CaptureHistoryUseCase captureHistoryUseCase, ICaptureThumbnailService iCaptureThumbnailService) {
        return new CaptureHistoryButtonViewModel(captureHistoryUseCase, iCaptureThumbnailService);
    }
}
