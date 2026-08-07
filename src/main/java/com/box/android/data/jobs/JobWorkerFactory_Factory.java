package com.box.android.data.jobs;

import com.box.android.coreservices.jobmanager.JobManager;
import com.box.android.domain.identity.IUserContextManager;
import com.box.boxandroidlibv2private.resourcemanagers.BoxApiPrivate;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes11.dex */
public final class JobWorkerFactory_Factory implements Factory<JobWorkerFactory> {
    private final Provider<BoxApiPrivate> boxApiPrivateProvider;
    private final Provider<JobManager> jobManagerProvider;
    private final Provider<JobService> jobServiceProvider;
    private final Provider<IUserContextManager> userContextManagerProvider;

    private JobWorkerFactory_Factory(Provider<JobService> jobServiceProvider, Provider<IUserContextManager> userContextManagerProvider, Provider<BoxApiPrivate> boxApiPrivateProvider, Provider<JobManager> jobManagerProvider) {
        this.jobServiceProvider = jobServiceProvider;
        this.userContextManagerProvider = userContextManagerProvider;
        this.boxApiPrivateProvider = boxApiPrivateProvider;
        this.jobManagerProvider = jobManagerProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public JobWorkerFactory get() {
        return newInstance(this.jobServiceProvider.get(), this.userContextManagerProvider.get(), this.boxApiPrivateProvider.get(), this.jobManagerProvider.get());
    }

    public static JobWorkerFactory_Factory create(Provider<JobService> jobServiceProvider, Provider<IUserContextManager> userContextManagerProvider, Provider<BoxApiPrivate> boxApiPrivateProvider, Provider<JobManager> jobManagerProvider) {
        return new JobWorkerFactory_Factory(jobServiceProvider, userContextManagerProvider, boxApiPrivateProvider, jobManagerProvider);
    }

    public static JobWorkerFactory newInstance(JobService jobService, IUserContextManager userContextManager, BoxApiPrivate boxApiPrivate, JobManager jobManager) {
        return new JobWorkerFactory(jobService, userContextManager, boxApiPrivate, jobManager);
    }
}
