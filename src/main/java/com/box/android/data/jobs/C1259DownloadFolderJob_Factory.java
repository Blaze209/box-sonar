package com.box.android.data.jobs;

import android.content.Context;
import androidx.work.Data;
import com.box.android.domain.jobs.JobId;
import com.box.android.domain.services.IRemoteItemService;
import com.squareup.moshi.Moshi;
import dagger.internal.Provider;

/* JADX INFO: renamed from: com.box.android.data.jobs.DownloadFolderJob_Factory, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes11.dex */
public final class C1259DownloadFolderJob_Factory {
    private final Provider<Context> appContextProvider;
    private final Provider<IRemoteItemService> itemServiceProvider;
    private final Provider<JobService> jobServiceProvider;
    private final Provider<Moshi> moshiProvider;

    private C1259DownloadFolderJob_Factory(Provider<IRemoteItemService> itemServiceProvider, Provider<Moshi> moshiProvider, Provider<Context> appContextProvider, Provider<JobService> jobServiceProvider) {
        this.itemServiceProvider = itemServiceProvider;
        this.moshiProvider = moshiProvider;
        this.appContextProvider = appContextProvider;
        this.jobServiceProvider = jobServiceProvider;
    }

    public DownloadFolderJob get(JobId jobId, Data inputData) {
        return newInstance(this.itemServiceProvider.get(), this.moshiProvider.get(), jobId, inputData, this.appContextProvider.get(), this.jobServiceProvider.get());
    }

    public static C1259DownloadFolderJob_Factory create(Provider<IRemoteItemService> itemServiceProvider, Provider<Moshi> moshiProvider, Provider<Context> appContextProvider, Provider<JobService> jobServiceProvider) {
        return new C1259DownloadFolderJob_Factory(itemServiceProvider, moshiProvider, appContextProvider, jobServiceProvider);
    }

    public static DownloadFolderJob newInstance(IRemoteItemService itemService, Moshi moshi, JobId jobId, Data inputData, Context appContext, JobService jobService) {
        return new DownloadFolderJob(itemService, moshi, jobId, inputData, appContext, jobService);
    }
}
