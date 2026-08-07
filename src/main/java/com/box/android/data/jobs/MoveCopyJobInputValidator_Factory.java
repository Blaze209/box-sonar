package com.box.android.data.jobs;

import com.box.android.domain.services.ILocalItemService;
import com.box.android.domain.services.IdMappingService;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class MoveCopyJobInputValidator_Factory implements Factory<MoveCopyJobInputValidator> {
    private final Provider<IdMappingService> idMappingServiceProvider;
    private final Provider<ILocalItemService> localItemServiceProvider;

    private MoveCopyJobInputValidator_Factory(Provider<ILocalItemService> localItemServiceProvider, Provider<IdMappingService> idMappingServiceProvider) {
        this.localItemServiceProvider = localItemServiceProvider;
        this.idMappingServiceProvider = idMappingServiceProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public MoveCopyJobInputValidator get() {
        return newInstance(this.localItemServiceProvider.get(), this.idMappingServiceProvider.get());
    }

    public static MoveCopyJobInputValidator_Factory create(Provider<ILocalItemService> localItemServiceProvider, Provider<IdMappingService> idMappingServiceProvider) {
        return new MoveCopyJobInputValidator_Factory(localItemServiceProvider, idMappingServiceProvider);
    }

    public static MoveCopyJobInputValidator newInstance(ILocalItemService localItemService, IdMappingService idMappingService) {
        return new MoveCopyJobInputValidator(localItemService, idMappingService);
    }
}
