package com.box.android.data.jobs;

import android.content.Context;
import androidx.work.Data;
import com.box.android.data.service.impl.LocalItemService;
import com.box.android.data.service.impl.UploadFileService;
import com.box.android.domain.jobs.JobId;
import com.squareup.moshi.Moshi;
import dagger.internal.Provider;
import kotlinx.coroutines.CoroutineDispatcher;

/* JADX INFO: renamed from: com.box.android.data.jobs.ChunkUploadJob_Factory, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes11.dex */
public final class C1238ChunkUploadJob_Factory {
    private final Provider<Context> appContextProvider;
    private final Provider<CoroutineDispatcher> dispatcherProvider;
    private final Provider<JobService> jobServiceProvider;
    private final Provider<LocalItemService> localItemServiceProvider;
    private final Provider<Moshi> moshiProvider;
    private final Provider<UploadFileService> uploadFileServiceProvider;

    private C1238ChunkUploadJob_Factory(Provider<UploadFileService> uploadFileServiceProvider, Provider<LocalItemService> localItemServiceProvider, Provider<Moshi> moshiProvider, Provider<Context> appContextProvider, Provider<JobService> jobServiceProvider, Provider<CoroutineDispatcher> dispatcherProvider) {
        this.uploadFileServiceProvider = uploadFileServiceProvider;
        this.localItemServiceProvider = localItemServiceProvider;
        this.moshiProvider = moshiProvider;
        this.appContextProvider = appContextProvider;
        this.jobServiceProvider = jobServiceProvider;
        this.dispatcherProvider = dispatcherProvider;
    }

    public ChunkUploadJob get(JobId jobId, Data inputData) {
        return newInstance(this.uploadFileServiceProvider.get(), this.localItemServiceProvider.get(), this.moshiProvider.get(), jobId, inputData, this.appContextProvider.get(), this.jobServiceProvider.get(), this.dispatcherProvider.get());
    }

    public static C1238ChunkUploadJob_Factory create(Provider<UploadFileService> uploadFileServiceProvider, Provider<LocalItemService> localItemServiceProvider, Provider<Moshi> moshiProvider, Provider<Context> appContextProvider, Provider<JobService> jobServiceProvider, Provider<CoroutineDispatcher> dispatcherProvider) {
        return new C1238ChunkUploadJob_Factory(uploadFileServiceProvider, localItemServiceProvider, moshiProvider, appContextProvider, jobServiceProvider, dispatcherProvider);
    }

    public static ChunkUploadJob newInstance(UploadFileService uploadFileService, LocalItemService localItemService, Moshi moshi, JobId jobId, Data inputData, Context appContext, JobService jobService, CoroutineDispatcher dispatcher) {
        return new ChunkUploadJob(uploadFileService, localItemService, moshi, jobId, inputData, appContext, jobService, dispatcher);
    }
}
