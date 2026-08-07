package com.box.android.data.jobs;

import android.content.Context;
import androidx.work.Data;
import com.box.android.data.service.impl.CreateFolderService;
import com.box.android.data.service.impl.LocalItemService;
import com.box.android.domain.jobs.JobId;
import com.box.android.domain.services.IdMappingService;
import dagger.internal.Provider;

/* JADX INFO: renamed from: com.box.android.data.jobs.CreateFolderJob_Factory, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes11.dex */
public final class C1242CreateFolderJob_Factory {
    private final Provider<Context> appContextProvider;
    private final Provider<CreateFolderService> createFolderServiceProvider;
    private final Provider<IdMappingService> idMappingServiceProvider;
    private final Provider<JobService> jobServiceProvider;
    private final Provider<LocalItemService> localItemServiceProvider;

    private C1242CreateFolderJob_Factory(Provider<CreateFolderService> createFolderServiceProvider, Provider<LocalItemService> localItemServiceProvider, Provider<IdMappingService> idMappingServiceProvider, Provider<Context> appContextProvider, Provider<JobService> jobServiceProvider) {
        this.createFolderServiceProvider = createFolderServiceProvider;
        this.localItemServiceProvider = localItemServiceProvider;
        this.idMappingServiceProvider = idMappingServiceProvider;
        this.appContextProvider = appContextProvider;
        this.jobServiceProvider = jobServiceProvider;
    }

    public CreateFolderJob get(JobId jobId, Data inputData) {
        return newInstance(this.createFolderServiceProvider.get(), this.localItemServiceProvider.get(), this.idMappingServiceProvider.get(), jobId, inputData, this.appContextProvider.get(), this.jobServiceProvider.get());
    }

    public static C1242CreateFolderJob_Factory create(Provider<CreateFolderService> createFolderServiceProvider, Provider<LocalItemService> localItemServiceProvider, Provider<IdMappingService> idMappingServiceProvider, Provider<Context> appContextProvider, Provider<JobService> jobServiceProvider) {
        return new C1242CreateFolderJob_Factory(createFolderServiceProvider, localItemServiceProvider, idMappingServiceProvider, appContextProvider, jobServiceProvider);
    }

    public static CreateFolderJob newInstance(CreateFolderService createFolderService, LocalItemService localItemService, IdMappingService idMappingService, JobId jobId, Data inputData, Context appContext, JobService jobService) {
        return new CreateFolderJob(createFolderService, localItemService, idMappingService, jobId, inputData, appContext, jobService);
    }
}
