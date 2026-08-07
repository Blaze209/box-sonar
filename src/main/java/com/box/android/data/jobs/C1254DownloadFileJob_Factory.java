package com.box.android.data.jobs;

import android.content.Context;
import androidx.work.Data;
import com.box.android.data.service.impl.DownloadFileService;
import com.box.android.data.service.impl.SharedLinkService;
import com.box.android.domain.jobs.JobId;
import com.box.android.domain.localrepo.IBoxStorage;
import com.box.android.domain.services.IRemoteItemService;
import com.squareup.moshi.Moshi;
import dagger.internal.Provider;

/* JADX INFO: renamed from: com.box.android.data.jobs.DownloadFileJob_Factory, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes11.dex */
public final class C1254DownloadFileJob_Factory {
    private final Provider<Context> appContextProvider;
    private final Provider<IBoxStorage> boxStorageProvider;
    private final Provider<DownloadFileService> downloadFileServiceProvider;
    private final Provider<IRemoteItemService> itemServiceProvider;
    private final Provider<JobService> jobServiceProvider;
    private final Provider<Moshi> moshiProvider;
    private final Provider<SharedLinkService> sharedLinkServiceProvider;

    private C1254DownloadFileJob_Factory(Provider<DownloadFileService> downloadFileServiceProvider, Provider<IRemoteItemService> itemServiceProvider, Provider<IBoxStorage> boxStorageProvider, Provider<Moshi> moshiProvider, Provider<SharedLinkService> sharedLinkServiceProvider, Provider<Context> appContextProvider, Provider<JobService> jobServiceProvider) {
        this.downloadFileServiceProvider = downloadFileServiceProvider;
        this.itemServiceProvider = itemServiceProvider;
        this.boxStorageProvider = boxStorageProvider;
        this.moshiProvider = moshiProvider;
        this.sharedLinkServiceProvider = sharedLinkServiceProvider;
        this.appContextProvider = appContextProvider;
        this.jobServiceProvider = jobServiceProvider;
    }

    public DownloadFileJob get(JobId jobId, Data inputData) {
        return newInstance(this.downloadFileServiceProvider.get(), this.itemServiceProvider.get(), this.boxStorageProvider.get(), this.moshiProvider.get(), this.sharedLinkServiceProvider.get(), jobId, inputData, this.appContextProvider.get(), this.jobServiceProvider.get());
    }

    public static C1254DownloadFileJob_Factory create(Provider<DownloadFileService> downloadFileServiceProvider, Provider<IRemoteItemService> itemServiceProvider, Provider<IBoxStorage> boxStorageProvider, Provider<Moshi> moshiProvider, Provider<SharedLinkService> sharedLinkServiceProvider, Provider<Context> appContextProvider, Provider<JobService> jobServiceProvider) {
        return new C1254DownloadFileJob_Factory(downloadFileServiceProvider, itemServiceProvider, boxStorageProvider, moshiProvider, sharedLinkServiceProvider, appContextProvider, jobServiceProvider);
    }

    public static DownloadFileJob newInstance(DownloadFileService downloadFileService, IRemoteItemService itemService, IBoxStorage boxStorage, Moshi moshi, SharedLinkService sharedLinkService, JobId jobId, Data inputData, Context appContext, JobService jobService) {
        return new DownloadFileJob(downloadFileService, itemService, boxStorage, moshi, sharedLinkService, jobId, inputData, appContext, jobService);
    }
}
