package com.box.android.domain.usecases.capture;

import com.box.android.domain.services.ICaptureHistoryFilesService;
import com.box.android.domain.services.IJobService;
import com.box.android.domain.services.ILocalItemService;
import com.box.android.domain.services.IdMappingService;
import com.box.androidsdk.content.BoxCache;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class CaptureHistoryInteractor_Factory implements Factory<CaptureHistoryInteractor> {
    private final Provider<BoxCache> boxCacheProvider;
    private final Provider<ICaptureHistoryFilesService> captureHistoryFilesServiceProvider;
    private final Provider<IdMappingService> idMappingServiceProvider;
    private final Provider<IJobService> jobServiceProvider;
    private final Provider<ILocalItemService> localItemServiceProvider;

    private CaptureHistoryInteractor_Factory(Provider<ICaptureHistoryFilesService> provider, Provider<ILocalItemService> provider2, Provider<BoxCache> provider3, Provider<IJobService> provider4, Provider<IdMappingService> provider5) {
        this.captureHistoryFilesServiceProvider = provider;
        this.localItemServiceProvider = provider2;
        this.boxCacheProvider = provider3;
        this.jobServiceProvider = provider4;
        this.idMappingServiceProvider = provider5;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public CaptureHistoryInteractor get() {
        return newInstance(this.captureHistoryFilesServiceProvider.get(), this.localItemServiceProvider.get(), this.boxCacheProvider.get(), this.jobServiceProvider.get(), this.idMappingServiceProvider.get());
    }

    public static CaptureHistoryInteractor_Factory create(Provider<ICaptureHistoryFilesService> provider, Provider<ILocalItemService> provider2, Provider<BoxCache> provider3, Provider<IJobService> provider4, Provider<IdMappingService> provider5) {
        return new CaptureHistoryInteractor_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static CaptureHistoryInteractor newInstance(ICaptureHistoryFilesService iCaptureHistoryFilesService, ILocalItemService iLocalItemService, BoxCache boxCache, IJobService iJobService, IdMappingService idMappingService) {
        return new CaptureHistoryInteractor(iCaptureHistoryFilesService, iLocalItemService, boxCache, iJobService, idMappingService);
    }
}
