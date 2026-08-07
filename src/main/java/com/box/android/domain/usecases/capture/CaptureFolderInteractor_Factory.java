package com.box.android.domain.usecases.capture;

import com.box.android.domain.services.ICapturePreferencesService;
import com.box.android.domain.services.IJobService;
import com.box.android.domain.services.IdMappingService;
import com.box.boxandroidlibv2private.resourcemanagers.BoxExtendedApiFolder;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class CaptureFolderInteractor_Factory implements Factory<CaptureFolderInteractor> {
    private final Provider<BoxExtendedApiFolder> boxExtendedApiFolderProvider;
    private final Provider<CaptureLocalItemsUseCase> captureLocalItemsUseCaseProvider;
    private final Provider<ICapturePreferencesService> capturePreferencesServiceProvider;
    private final Provider<IdMappingService> idMappingServiceProvider;
    private final Provider<IJobService> jobServiceProvider;

    private CaptureFolderInteractor_Factory(Provider<IJobService> provider, Provider<ICapturePreferencesService> provider2, Provider<CaptureLocalItemsUseCase> provider3, Provider<BoxExtendedApiFolder> provider4, Provider<IdMappingService> provider5) {
        this.jobServiceProvider = provider;
        this.capturePreferencesServiceProvider = provider2;
        this.captureLocalItemsUseCaseProvider = provider3;
        this.boxExtendedApiFolderProvider = provider4;
        this.idMappingServiceProvider = provider5;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public CaptureFolderInteractor get() {
        return newInstance(this.jobServiceProvider.get(), this.capturePreferencesServiceProvider.get(), this.captureLocalItemsUseCaseProvider.get(), this.boxExtendedApiFolderProvider.get(), this.idMappingServiceProvider.get());
    }

    public static CaptureFolderInteractor_Factory create(Provider<IJobService> provider, Provider<ICapturePreferencesService> provider2, Provider<CaptureLocalItemsUseCase> provider3, Provider<BoxExtendedApiFolder> provider4, Provider<IdMappingService> provider5) {
        return new CaptureFolderInteractor_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static CaptureFolderInteractor newInstance(IJobService iJobService, ICapturePreferencesService iCapturePreferencesService, CaptureLocalItemsUseCase captureLocalItemsUseCase, BoxExtendedApiFolder boxExtendedApiFolder, IdMappingService idMappingService) {
        return new CaptureFolderInteractor(iJobService, iCapturePreferencesService, captureLocalItemsUseCase, boxExtendedApiFolder, idMappingService);
    }
}
