package com.box.android.capture.viewmodel;

import com.box.android.domain.usecases.capture.CaptureHistoryUseCase;
import com.box.android.domain.usecases.capture.DeleteCaptureHistoryUseCase;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes10.dex */
public final class CaptureHistoryViewModel_Factory implements Factory<CaptureHistoryViewModel> {
    private final Provider<CaptureHistoryUseCase> captureHistoryInteractorProvider;
    private final Provider<DeleteCaptureHistoryUseCase> deleteCaptureHistoryUseCaseProvider;

    private CaptureHistoryViewModel_Factory(Provider<CaptureHistoryUseCase> provider, Provider<DeleteCaptureHistoryUseCase> provider2) {
        this.captureHistoryInteractorProvider = provider;
        this.deleteCaptureHistoryUseCaseProvider = provider2;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public CaptureHistoryViewModel get() {
        return newInstance(this.captureHistoryInteractorProvider.get(), this.deleteCaptureHistoryUseCaseProvider.get());
    }

    public static CaptureHistoryViewModel_Factory create(Provider<CaptureHistoryUseCase> provider, Provider<DeleteCaptureHistoryUseCase> provider2) {
        return new CaptureHistoryViewModel_Factory(provider, provider2);
    }

    public static CaptureHistoryViewModel newInstance(CaptureHistoryUseCase captureHistoryUseCase, DeleteCaptureHistoryUseCase deleteCaptureHistoryUseCase) {
        return new CaptureHistoryViewModel(captureHistoryUseCase, deleteCaptureHistoryUseCase);
    }
}
