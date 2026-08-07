package com.box.android.domain.usecases.capture;

import com.box.android.domain.services.ICaptureHistoryFilesService;
import com.box.android.domain.services.IJobService;
import com.box.android.domain.services.ILocalItemService;
import com.box.android.domain.services.IdMappingService;
import dagger.internal.Factory;
import dagger.internal.Provider;
import kotlinx.coroutines.CoroutineDispatcher;

/* JADX INFO: loaded from: classes11.dex */
public final class DeleteCaptureHistoryInteractor_Factory implements Factory<DeleteCaptureHistoryInteractor> {
    private final Provider<ICaptureHistoryFilesService> captureHistoryFilesServiceProvider;
    private final Provider<IdMappingService> idMappingServiceProvider;
    private final Provider<CoroutineDispatcher> ioDispatcherProvider;
    private final Provider<IJobService> jobServiceProvider;
    private final Provider<ILocalItemService> localItemServiceProvider;

    private DeleteCaptureHistoryInteractor_Factory(Provider<IJobService> provider, Provider<ILocalItemService> provider2, Provider<ICaptureHistoryFilesService> provider3, Provider<IdMappingService> provider4, Provider<CoroutineDispatcher> provider5) {
        this.jobServiceProvider = provider;
        this.localItemServiceProvider = provider2;
        this.captureHistoryFilesServiceProvider = provider3;
        this.idMappingServiceProvider = provider4;
        this.ioDispatcherProvider = provider5;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public DeleteCaptureHistoryInteractor get() {
        return newInstance(this.jobServiceProvider.get(), this.localItemServiceProvider.get(), this.captureHistoryFilesServiceProvider.get(), this.idMappingServiceProvider.get(), this.ioDispatcherProvider.get());
    }

    public static DeleteCaptureHistoryInteractor_Factory create(Provider<IJobService> provider, Provider<ILocalItemService> provider2, Provider<ICaptureHistoryFilesService> provider3, Provider<IdMappingService> provider4, Provider<CoroutineDispatcher> provider5) {
        return new DeleteCaptureHistoryInteractor_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static DeleteCaptureHistoryInteractor newInstance(IJobService iJobService, ILocalItemService iLocalItemService, ICaptureHistoryFilesService iCaptureHistoryFilesService, IdMappingService idMappingService, CoroutineDispatcher coroutineDispatcher) {
        return new DeleteCaptureHistoryInteractor(iJobService, iLocalItemService, iCaptureHistoryFilesService, idMappingService, coroutineDispatcher);
    }
}
