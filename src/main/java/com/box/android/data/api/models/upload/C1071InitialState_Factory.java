package com.box.android.data.api.models.upload;

import com.box.android.data.jobs.JobService;
import com.box.android.data.jobs.UploadFileJobV2;
import com.box.android.data.service.impl.LocalItemService;
import com.box.android.data.service.impl.UploadFileService;
import dagger.internal.Provider;

/* JADX INFO: renamed from: com.box.android.data.api.models.upload.InitialState_Factory, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes11.dex */
public final class C1071InitialState_Factory {
    private final Provider<JobService> jobServiceProvider;
    private final Provider<LocalItemService> localItemServiceProvider;
    private final Provider<UploadFileService> uploadFileServiceProvider;

    private C1071InitialState_Factory(Provider<JobService> jobServiceProvider, Provider<UploadFileService> uploadFileServiceProvider, Provider<LocalItemService> localItemServiceProvider) {
        this.jobServiceProvider = jobServiceProvider;
        this.uploadFileServiceProvider = uploadFileServiceProvider;
        this.localItemServiceProvider = localItemServiceProvider;
    }

    public InitialState get(UploadFileJobV2 job) {
        return newInstance(this.jobServiceProvider.get(), job, this.uploadFileServiceProvider.get(), this.localItemServiceProvider.get());
    }

    public static C1071InitialState_Factory create(Provider<JobService> jobServiceProvider, Provider<UploadFileService> uploadFileServiceProvider, Provider<LocalItemService> localItemServiceProvider) {
        return new C1071InitialState_Factory(jobServiceProvider, uploadFileServiceProvider, localItemServiceProvider);
    }

    public static InitialState newInstance(JobService jobService, UploadFileJobV2 job, UploadFileService uploadFileService, LocalItemService localItemService) {
        return new InitialState(jobService, job, uploadFileService, localItemService);
    }
}
