package com.box.android.data.jobs;

import android.content.Context;
import androidx.work.Data;
import com.box.android.data.service.impl.LocalItemService;
import com.box.android.domain.jobs.JobId;
import com.box.android.domain.localrepo.IBoxStorage;
import com.box.android.domain.services.IdMappingService;
import com.squareup.moshi.Moshi;
import dagger.internal.Provider;

/* JADX INFO: renamed from: com.box.android.data.jobs.UploadFileJobV2_Factory, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes11.dex */
public final class C1347UploadFileJobV2_Factory {
    private final Provider<Context> appContextProvider;
    private final Provider<IBoxStorage> boxStorageProvider;
    private final Provider<IdMappingService> idMappingServiceProvider;
    private final Provider<JobService> jobServiceProvider;
    private final Provider<LocalItemService> localItemServiceProvider;
    private final Provider<Moshi> moshiProvider;
    private final Provider<UploadStatesFactory> uploadStatesFactoryProvider;

    private C1347UploadFileJobV2_Factory(Provider<LocalItemService> localItemServiceProvider, Provider<Moshi> moshiProvider, Provider<IBoxStorage> boxStorageProvider, Provider<Context> appContextProvider, Provider<JobService> jobServiceProvider, Provider<UploadStatesFactory> uploadStatesFactoryProvider, Provider<IdMappingService> idMappingServiceProvider) {
        this.localItemServiceProvider = localItemServiceProvider;
        this.moshiProvider = moshiProvider;
        this.boxStorageProvider = boxStorageProvider;
        this.appContextProvider = appContextProvider;
        this.jobServiceProvider = jobServiceProvider;
        this.uploadStatesFactoryProvider = uploadStatesFactoryProvider;
        this.idMappingServiceProvider = idMappingServiceProvider;
    }

    public UploadFileJobV2 get(JobId jobId, Data inputData) {
        return newInstance(this.localItemServiceProvider.get(), this.moshiProvider.get(), this.boxStorageProvider.get(), jobId, inputData, this.appContextProvider.get(), this.jobServiceProvider.get(), this.uploadStatesFactoryProvider.get(), this.idMappingServiceProvider.get());
    }

    public static C1347UploadFileJobV2_Factory create(Provider<LocalItemService> localItemServiceProvider, Provider<Moshi> moshiProvider, Provider<IBoxStorage> boxStorageProvider, Provider<Context> appContextProvider, Provider<JobService> jobServiceProvider, Provider<UploadStatesFactory> uploadStatesFactoryProvider, Provider<IdMappingService> idMappingServiceProvider) {
        return new C1347UploadFileJobV2_Factory(localItemServiceProvider, moshiProvider, boxStorageProvider, appContextProvider, jobServiceProvider, uploadStatesFactoryProvider, idMappingServiceProvider);
    }

    public static UploadFileJobV2 newInstance(LocalItemService localItemService, Moshi moshi, IBoxStorage boxStorage, JobId jobId, Data inputData, Context appContext, JobService jobService, UploadStatesFactory uploadStatesFactory, IdMappingService idMappingService) {
        return new UploadFileJobV2(localItemService, moshi, boxStorage, jobId, inputData, appContext, jobService, uploadStatesFactory, idMappingService);
    }
}
