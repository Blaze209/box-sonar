package com.box.android.data.jobs;

import android.content.Context;
import androidx.work.Data;
import com.box.android.data.service.impl.DownloadFileService;
import com.box.android.domain.jobs.JobId;
import com.box.android.domain.localrepo.IBoxStorage;
import com.squareup.moshi.Moshi;
import dagger.internal.Provider;

/* JADX INFO: renamed from: com.box.android.data.jobs.DownloadChunkJob_Factory, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes11.dex */
public final class C1245DownloadChunkJob_Factory {
    private final Provider<Context> appContextProvider;
    private final Provider<IBoxStorage> boxStorageProvider;
    private final Provider<DownloadFileService> downloadFileServiceProvider;
    private final Provider<JobService> jobServiceProvider;
    private final Provider<Moshi> moshiProvider;

    private C1245DownloadChunkJob_Factory(Provider<DownloadFileService> downloadFileServiceProvider, Provider<IBoxStorage> boxStorageProvider, Provider<Moshi> moshiProvider, Provider<Context> appContextProvider, Provider<JobService> jobServiceProvider) {
        this.downloadFileServiceProvider = downloadFileServiceProvider;
        this.boxStorageProvider = boxStorageProvider;
        this.moshiProvider = moshiProvider;
        this.appContextProvider = appContextProvider;
        this.jobServiceProvider = jobServiceProvider;
    }

    public DownloadChunkJob get(JobId jobId, Data inputData) {
        return newInstance(this.downloadFileServiceProvider.get(), this.boxStorageProvider.get(), this.moshiProvider.get(), jobId, inputData, this.appContextProvider.get(), this.jobServiceProvider.get());
    }

    public static C1245DownloadChunkJob_Factory create(Provider<DownloadFileService> downloadFileServiceProvider, Provider<IBoxStorage> boxStorageProvider, Provider<Moshi> moshiProvider, Provider<Context> appContextProvider, Provider<JobService> jobServiceProvider) {
        return new C1245DownloadChunkJob_Factory(downloadFileServiceProvider, boxStorageProvider, moshiProvider, appContextProvider, jobServiceProvider);
    }

    public static DownloadChunkJob newInstance(DownloadFileService downloadFileService, IBoxStorage boxStorage, Moshi moshi, JobId jobId, Data inputData, Context appContext, JobService jobService) {
        return new DownloadChunkJob(downloadFileService, boxStorage, moshi, jobId, inputData, appContext, jobService);
    }
}
