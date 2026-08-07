package com.box.android.data.jobs;

import android.content.Context;
import androidx.work.Data;
import com.box.android.data.service.impl.LocalItemService;
import com.box.android.data.service.impl.RemoteItemService;
import com.box.android.domain.jobs.JobId;
import com.box.android.domain.localrepo.IBoxStorage;
import com.box.android.domain.services.IdMappingService;
import com.squareup.moshi.Moshi;
import dagger.internal.Provider;

/* JADX INFO: renamed from: com.box.android.data.jobs.UploadFolderJob_Factory, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes11.dex */
public final class C1360UploadFolderJob_Factory {
    private final Provider<Context> appContextProvider;
    private final Provider<IBoxStorage> boxStorageProvider;
    private final Provider<IdMappingService> idMappingServiceProvider;
    private final Provider<JobService> jobServiceProvider;
    private final Provider<LocalItemService> localItemServiceProvider;
    private final Provider<Moshi> moshiProvider;
    private final Provider<RemoteItemService> remoteItemServiceProvider;

    private C1360UploadFolderJob_Factory(Provider<LocalItemService> localItemServiceProvider, Provider<Moshi> moshiProvider, Provider<Context> appContextProvider, Provider<JobService> jobServiceProvider, Provider<IdMappingService> idMappingServiceProvider, Provider<RemoteItemService> remoteItemServiceProvider, Provider<IBoxStorage> boxStorageProvider) {
        this.localItemServiceProvider = localItemServiceProvider;
        this.moshiProvider = moshiProvider;
        this.appContextProvider = appContextProvider;
        this.jobServiceProvider = jobServiceProvider;
        this.idMappingServiceProvider = idMappingServiceProvider;
        this.remoteItemServiceProvider = remoteItemServiceProvider;
        this.boxStorageProvider = boxStorageProvider;
    }

    public UploadFolderJob get(JobId jobId, Data inputData) {
        return newInstance(this.localItemServiceProvider.get(), this.moshiProvider.get(), jobId, inputData, this.appContextProvider.get(), this.jobServiceProvider.get(), this.idMappingServiceProvider.get(), this.remoteItemServiceProvider.get(), this.boxStorageProvider.get());
    }

    public static C1360UploadFolderJob_Factory create(Provider<LocalItemService> localItemServiceProvider, Provider<Moshi> moshiProvider, Provider<Context> appContextProvider, Provider<JobService> jobServiceProvider, Provider<IdMappingService> idMappingServiceProvider, Provider<RemoteItemService> remoteItemServiceProvider, Provider<IBoxStorage> boxStorageProvider) {
        return new C1360UploadFolderJob_Factory(localItemServiceProvider, moshiProvider, appContextProvider, jobServiceProvider, idMappingServiceProvider, remoteItemServiceProvider, boxStorageProvider);
    }

    public static UploadFolderJob newInstance(LocalItemService localItemService, Moshi moshi, JobId jobId, Data inputData, Context appContext, JobService jobService, IdMappingService idMappingService, RemoteItemService remoteItemService, IBoxStorage boxStorage) {
        return new UploadFolderJob(localItemService, moshi, jobId, inputData, appContext, jobService, idMappingService, remoteItemService, boxStorage);
    }
}
