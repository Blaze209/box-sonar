package com.box.android.data.jobs;

import android.content.Context;
import androidx.work.Data;
import com.box.android.domain.jobs.JobId;
import com.box.android.domain.services.ILocalItemService;
import com.box.android.domain.services.IRemoteItemService;
import com.box.android.domain.services.IdMappingService;
import dagger.internal.Provider;

/* JADX INFO: renamed from: com.box.android.data.jobs.CopyItemJob_Factory, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes11.dex */
public final class C1239CopyItemJob_Factory {
    private final Provider<Context> appContextProvider;
    private final Provider<IdMappingService> idMappingServiceProvider;
    private final Provider<IMoveCopyJobInputValidator> inputValidatorProvider;
    private final Provider<JobService> jobServiceProvider;
    private final Provider<ILocalItemService> localItemServiceProvider;
    private final Provider<IRemoteItemService> remoteServiceProvider;

    private C1239CopyItemJob_Factory(Provider<Context> appContextProvider, Provider<JobService> jobServiceProvider, Provider<ILocalItemService> localItemServiceProvider, Provider<IRemoteItemService> remoteServiceProvider, Provider<IdMappingService> idMappingServiceProvider, Provider<IMoveCopyJobInputValidator> inputValidatorProvider) {
        this.appContextProvider = appContextProvider;
        this.jobServiceProvider = jobServiceProvider;
        this.localItemServiceProvider = localItemServiceProvider;
        this.remoteServiceProvider = remoteServiceProvider;
        this.idMappingServiceProvider = idMappingServiceProvider;
        this.inputValidatorProvider = inputValidatorProvider;
    }

    public CopyItemJob get(JobId jobId, Data inputData) {
        return newInstance(this.appContextProvider.get(), this.jobServiceProvider.get(), this.localItemServiceProvider.get(), this.remoteServiceProvider.get(), jobId, inputData, this.idMappingServiceProvider.get(), this.inputValidatorProvider.get());
    }

    public static C1239CopyItemJob_Factory create(Provider<Context> appContextProvider, Provider<JobService> jobServiceProvider, Provider<ILocalItemService> localItemServiceProvider, Provider<IRemoteItemService> remoteServiceProvider, Provider<IdMappingService> idMappingServiceProvider, Provider<IMoveCopyJobInputValidator> inputValidatorProvider) {
        return new C1239CopyItemJob_Factory(appContextProvider, jobServiceProvider, localItemServiceProvider, remoteServiceProvider, idMappingServiceProvider, inputValidatorProvider);
    }

    public static CopyItemJob newInstance(Context appContext, JobService jobService, ILocalItemService localItemService, IRemoteItemService remoteService, JobId jobId, Data inputData, IdMappingService idMappingService, IMoveCopyJobInputValidator inputValidator) {
        return new CopyItemJob(appContext, jobService, localItemService, remoteService, jobId, inputData, idMappingService, inputValidator);
    }
}
