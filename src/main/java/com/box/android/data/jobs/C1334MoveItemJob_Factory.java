package com.box.android.data.jobs;

import android.content.Context;
import androidx.work.Data;
import com.box.android.domain.jobs.JobId;
import com.box.android.domain.services.ILocalItemService;
import com.box.android.domain.services.IRemoteItemService;
import com.box.android.domain.services.IdMappingService;
import dagger.internal.Provider;

/* JADX INFO: renamed from: com.box.android.data.jobs.MoveItemJob_Factory, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes11.dex */
public final class C1334MoveItemJob_Factory {
    private final Provider<Context> appContextProvider;
    private final Provider<IdMappingService> idMappingServiceProvider;
    private final Provider<IMoveCopyJobInputValidator> inputValidatorProvider;
    private final Provider<JobService> jobServiceProvider;
    private final Provider<ILocalItemService> localItemServiceProvider;
    private final Provider<IRemoteItemService> remoteServiceProvider;

    private C1334MoveItemJob_Factory(Provider<Context> appContextProvider, Provider<JobService> jobServiceProvider, Provider<ILocalItemService> localItemServiceProvider, Provider<IRemoteItemService> remoteServiceProvider, Provider<IdMappingService> idMappingServiceProvider, Provider<IMoveCopyJobInputValidator> inputValidatorProvider) {
        this.appContextProvider = appContextProvider;
        this.jobServiceProvider = jobServiceProvider;
        this.localItemServiceProvider = localItemServiceProvider;
        this.remoteServiceProvider = remoteServiceProvider;
        this.idMappingServiceProvider = idMappingServiceProvider;
        this.inputValidatorProvider = inputValidatorProvider;
    }

    public MoveItemJob get(JobId jobId, Data inputData) {
        return newInstance(this.appContextProvider.get(), this.jobServiceProvider.get(), this.localItemServiceProvider.get(), this.remoteServiceProvider.get(), jobId, inputData, this.idMappingServiceProvider.get(), this.inputValidatorProvider.get());
    }

    public static C1334MoveItemJob_Factory create(Provider<Context> appContextProvider, Provider<JobService> jobServiceProvider, Provider<ILocalItemService> localItemServiceProvider, Provider<IRemoteItemService> remoteServiceProvider, Provider<IdMappingService> idMappingServiceProvider, Provider<IMoveCopyJobInputValidator> inputValidatorProvider) {
        return new C1334MoveItemJob_Factory(appContextProvider, jobServiceProvider, localItemServiceProvider, remoteServiceProvider, idMappingServiceProvider, inputValidatorProvider);
    }

    public static MoveItemJob newInstance(Context appContext, JobService jobService, ILocalItemService localItemService, IRemoteItemService remoteService, JobId jobId, Data inputData, IdMappingService idMappingService, IMoveCopyJobInputValidator inputValidator) {
        return new MoveItemJob(appContext, jobService, localItemService, remoteService, jobId, inputData, idMappingService, inputValidator);
    }
}
