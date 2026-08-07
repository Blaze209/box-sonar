package com.box.android.data.jobs;

import android.content.Context;
import androidx.work.Data;
import com.box.android.data.service.impl.LocalItemService;
import com.box.android.data.service.impl.RemoteItemService;
import com.box.android.domain.identity.IUserContextManager;
import com.box.android.domain.jobs.JobId;
import com.box.android.domain.localrepo.IBoxStorage;
import com.squareup.moshi.Moshi;
import dagger.internal.Provider;

/* JADX INFO: renamed from: com.box.android.data.jobs.AutoUploadJob_Factory, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes11.dex */
public final class C1237AutoUploadJob_Factory {
    private final Provider<Context> appContextProvider;
    private final Provider<IBoxStorage> boxStorageProvider;
    private final Provider<JobService> jobServiceProvider;
    private final Provider<LocalItemService> localItemServiceProvider;
    private final Provider<Moshi> moshiProvider;
    private final Provider<RemoteItemService> remoteItemServiceProvider;
    private final Provider<IUserContextManager> userContextManagerProvider;

    private C1237AutoUploadJob_Factory(Provider<LocalItemService> localItemServiceProvider, Provider<Moshi> moshiProvider, Provider<Context> appContextProvider, Provider<JobService> jobServiceProvider, Provider<RemoteItemService> remoteItemServiceProvider, Provider<IBoxStorage> boxStorageProvider, Provider<IUserContextManager> userContextManagerProvider) {
        this.localItemServiceProvider = localItemServiceProvider;
        this.moshiProvider = moshiProvider;
        this.appContextProvider = appContextProvider;
        this.jobServiceProvider = jobServiceProvider;
        this.remoteItemServiceProvider = remoteItemServiceProvider;
        this.boxStorageProvider = boxStorageProvider;
        this.userContextManagerProvider = userContextManagerProvider;
    }

    public AutoUploadJob get(JobId jobId, Data inputData) {
        return newInstance(this.localItemServiceProvider.get(), this.moshiProvider.get(), jobId, inputData, this.appContextProvider.get(), this.jobServiceProvider.get(), this.remoteItemServiceProvider.get(), this.boxStorageProvider.get(), this.userContextManagerProvider.get());
    }

    public static C1237AutoUploadJob_Factory create(Provider<LocalItemService> localItemServiceProvider, Provider<Moshi> moshiProvider, Provider<Context> appContextProvider, Provider<JobService> jobServiceProvider, Provider<RemoteItemService> remoteItemServiceProvider, Provider<IBoxStorage> boxStorageProvider, Provider<IUserContextManager> userContextManagerProvider) {
        return new C1237AutoUploadJob_Factory(localItemServiceProvider, moshiProvider, appContextProvider, jobServiceProvider, remoteItemServiceProvider, boxStorageProvider, userContextManagerProvider);
    }

    public static AutoUploadJob newInstance(LocalItemService localItemService, Moshi moshi, JobId jobId, Data inputData, Context appContext, JobService jobService, RemoteItemService remoteItemService, IBoxStorage boxStorage, IUserContextManager userContextManager) {
        return new AutoUploadJob(localItemService, moshi, jobId, inputData, appContext, jobService, remoteItemService, boxStorage, userContextManager);
    }
}
