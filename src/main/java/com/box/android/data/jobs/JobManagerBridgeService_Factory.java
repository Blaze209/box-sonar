package com.box.android.data.jobs;

import com.box.android.coreservices.jobmanager.JobManager;
import dagger.internal.Factory;
import dagger.internal.Provider;
import kotlinx.coroutines.CoroutineDispatcher;

/* JADX INFO: loaded from: classes11.dex */
public final class JobManagerBridgeService_Factory implements Factory<JobManagerBridgeService> {
    private final Provider<CoroutineDispatcher> dispatcherProvider;
    private final Provider<JobManager> jobManagerProvider;

    private JobManagerBridgeService_Factory(Provider<JobManager> jobManagerProvider, Provider<CoroutineDispatcher> dispatcherProvider) {
        this.jobManagerProvider = jobManagerProvider;
        this.dispatcherProvider = dispatcherProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public JobManagerBridgeService get() {
        return newInstance(this.jobManagerProvider.get(), this.dispatcherProvider.get());
    }

    public static JobManagerBridgeService_Factory create(Provider<JobManager> jobManagerProvider, Provider<CoroutineDispatcher> dispatcherProvider) {
        return new JobManagerBridgeService_Factory(jobManagerProvider, dispatcherProvider);
    }

    public static JobManagerBridgeService newInstance(JobManager jobManager, CoroutineDispatcher dispatcher) {
        return new JobManagerBridgeService(jobManager, dispatcher);
    }
}
