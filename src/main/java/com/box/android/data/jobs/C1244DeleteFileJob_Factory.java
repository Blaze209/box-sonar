package com.box.android.data.jobs;

import android.content.Context;
import androidx.work.Data;
import com.box.android.domain.jobs.JobId;
import com.box.android.domain.services.IDeleteFileService;
import com.box.android.domain.services.ILocalItemService;
import com.box.android.domain.services.IdMappingService;
import dagger.internal.Provider;

/* JADX INFO: renamed from: com.box.android.data.jobs.DeleteFileJob_Factory, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes11.dex */
public final class C1244DeleteFileJob_Factory {
    private final Provider<Context> appContextProvider;
    private final Provider<IDeleteFileService> deleteFileServiceProvider;
    private final Provider<IdMappingService> idMappingServiceProvider;
    private final Provider<JobService> jobServiceProvider;
    private final Provider<ILocalItemService> localItemServiceProvider;

    private C1244DeleteFileJob_Factory(Provider<Context> appContextProvider, Provider<JobService> jobServiceProvider, Provider<IDeleteFileService> deleteFileServiceProvider, Provider<ILocalItemService> localItemServiceProvider, Provider<IdMappingService> idMappingServiceProvider) {
        this.appContextProvider = appContextProvider;
        this.jobServiceProvider = jobServiceProvider;
        this.deleteFileServiceProvider = deleteFileServiceProvider;
        this.localItemServiceProvider = localItemServiceProvider;
        this.idMappingServiceProvider = idMappingServiceProvider;
    }

    public DeleteFileJob get(JobId jobId, Data inputData) {
        return newInstance(this.appContextProvider.get(), this.jobServiceProvider.get(), this.deleteFileServiceProvider.get(), this.localItemServiceProvider.get(), this.idMappingServiceProvider.get(), jobId, inputData);
    }

    public static C1244DeleteFileJob_Factory create(Provider<Context> appContextProvider, Provider<JobService> jobServiceProvider, Provider<IDeleteFileService> deleteFileServiceProvider, Provider<ILocalItemService> localItemServiceProvider, Provider<IdMappingService> idMappingServiceProvider) {
        return new C1244DeleteFileJob_Factory(appContextProvider, jobServiceProvider, deleteFileServiceProvider, localItemServiceProvider, idMappingServiceProvider);
    }

    public static DeleteFileJob newInstance(Context appContext, JobService jobService, IDeleteFileService deleteFileService, ILocalItemService localItemService, IdMappingService idMappingService, JobId jobId, Data inputData) {
        return new DeleteFileJob(appContext, jobService, deleteFileService, localItemService, idMappingService, jobId, inputData);
    }
}
