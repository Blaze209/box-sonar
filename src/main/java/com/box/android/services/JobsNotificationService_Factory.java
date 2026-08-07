package com.box.android.services;

import com.box.android.coreservices.jobmanager.JobManager;
import com.box.android.domain.services.IJobService;
import com.box.android.usercontext.UserContextManager;
import dagger.internal.Factory;
import dagger.internal.Provider;
import kotlinx.coroutines.CoroutineDispatcher;

/* JADX INFO: loaded from: classes13.dex */
public final class JobsNotificationService_Factory implements Factory<JobsNotificationService> {
    private final Provider<CoroutineDispatcher> coroutineDispatcherProvider;
    private final Provider<JobManager> jobManagerProvider;
    private final Provider<IJobService> jobServiceProvider;
    private final Provider<UserContextManager> userContextManagerProvider;

    private JobsNotificationService_Factory(Provider<JobManager> provider, Provider<IJobService> provider2, Provider<UserContextManager> provider3, Provider<CoroutineDispatcher> provider4) {
        this.jobManagerProvider = provider;
        this.jobServiceProvider = provider2;
        this.userContextManagerProvider = provider3;
        this.coroutineDispatcherProvider = provider4;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public JobsNotificationService get() {
        return newInstance(this.jobManagerProvider.get(), this.jobServiceProvider.get(), this.userContextManagerProvider.get(), this.coroutineDispatcherProvider.get());
    }

    public static JobsNotificationService_Factory create(Provider<JobManager> provider, Provider<IJobService> provider2, Provider<UserContextManager> provider3, Provider<CoroutineDispatcher> provider4) {
        return new JobsNotificationService_Factory(provider, provider2, provider3, provider4);
    }

    public static JobsNotificationService newInstance(JobManager jobManager, IJobService iJobService, UserContextManager userContextManager, CoroutineDispatcher coroutineDispatcher) {
        return new JobsNotificationService(jobManager, iJobService, userContextManager, coroutineDispatcher);
    }
}
