package com.box.android.data.jobs;

import android.content.Context;
import androidx.work.Data;
import com.box.android.domain.identity.IUserContextManager;
import com.box.android.domain.jobs.JobId;
import com.box.android.domain.services.IRemoteItemService;
import com.squareup.moshi.Moshi;
import dagger.internal.Provider;

/* JADX INFO: renamed from: com.box.android.data.jobs.MarkForOfflineFolderJob_Factory, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes11.dex */
public final class C1310MarkForOfflineFolderJob_Factory {
    private final Provider<Context> appContextProvider;
    private final Provider<JobService> jobServiceProvider;
    private final Provider<Moshi> moshiProvider;
    private final Provider<IRemoteItemService> remoteItemServiceProvider;
    private final Provider<IUserContextManager> userContextManagerProvider;

    private C1310MarkForOfflineFolderJob_Factory(Provider<Moshi> moshiProvider, Provider<Context> appContextProvider, Provider<JobService> jobServiceProvider, Provider<IRemoteItemService> remoteItemServiceProvider, Provider<IUserContextManager> userContextManagerProvider) {
        this.moshiProvider = moshiProvider;
        this.appContextProvider = appContextProvider;
        this.jobServiceProvider = jobServiceProvider;
        this.remoteItemServiceProvider = remoteItemServiceProvider;
        this.userContextManagerProvider = userContextManagerProvider;
    }

    public MarkForOfflineFolderJob get(JobId jobId, Data inputData) {
        return newInstance(this.moshiProvider.get(), jobId, inputData, this.appContextProvider.get(), this.jobServiceProvider.get(), this.remoteItemServiceProvider.get(), this.userContextManagerProvider.get());
    }

    public static C1310MarkForOfflineFolderJob_Factory create(Provider<Moshi> moshiProvider, Provider<Context> appContextProvider, Provider<JobService> jobServiceProvider, Provider<IRemoteItemService> remoteItemServiceProvider, Provider<IUserContextManager> userContextManagerProvider) {
        return new C1310MarkForOfflineFolderJob_Factory(moshiProvider, appContextProvider, jobServiceProvider, remoteItemServiceProvider, userContextManagerProvider);
    }

    public static MarkForOfflineFolderJob newInstance(Moshi moshi, JobId jobId, Data inputData, Context appContext, JobService jobService, IRemoteItemService remoteItemService, IUserContextManager userContextManager) {
        return new MarkForOfflineFolderJob(moshi, jobId, inputData, appContext, jobService, remoteItemService, userContextManager);
    }
}
