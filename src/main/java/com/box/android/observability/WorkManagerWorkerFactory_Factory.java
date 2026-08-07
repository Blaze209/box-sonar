package com.box.android.observability;

import com.box.android.coreservices.jobmanager.JobManager;
import com.box.android.domain.identity.IUserContextManager;
import com.box.android.domain.services.ILocalItemService;
import com.box.android.domain.usecases.observability.MetricsUseCase;
import com.box.android.domain.usecases.observability.UploadLogsUseCase;
import com.box.boxandroidlibv2private.resourcemanagers.BoxApiPrivate;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes12.dex */
public final class WorkManagerWorkerFactory_Factory implements Factory<WorkManagerWorkerFactory> {
    private final Provider<BoxApiPrivate> boxApiPrivateProvider;
    private final Provider<JobManager> jobManagerProvider;
    private final Provider<ILocalItemService> localItemServiceProvider;
    private final Provider<MetricsUseCase> metricsInteractorProvider;
    private final Provider<UploadLogsUseCase> uploadLogsInteractorProvider;
    private final Provider<IUserContextManager> userContextManagerProvider;

    private WorkManagerWorkerFactory_Factory(Provider<UploadLogsUseCase> provider, Provider<MetricsUseCase> provider2, Provider<IUserContextManager> provider3, Provider<BoxApiPrivate> provider4, Provider<JobManager> provider5, Provider<ILocalItemService> provider6) {
        this.uploadLogsInteractorProvider = provider;
        this.metricsInteractorProvider = provider2;
        this.userContextManagerProvider = provider3;
        this.boxApiPrivateProvider = provider4;
        this.jobManagerProvider = provider5;
        this.localItemServiceProvider = provider6;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public WorkManagerWorkerFactory get() {
        return newInstance(this.uploadLogsInteractorProvider.get(), this.metricsInteractorProvider.get(), this.userContextManagerProvider.get(), this.boxApiPrivateProvider.get(), this.jobManagerProvider.get(), this.localItemServiceProvider.get());
    }

    public static WorkManagerWorkerFactory_Factory create(Provider<UploadLogsUseCase> provider, Provider<MetricsUseCase> provider2, Provider<IUserContextManager> provider3, Provider<BoxApiPrivate> provider4, Provider<JobManager> provider5, Provider<ILocalItemService> provider6) {
        return new WorkManagerWorkerFactory_Factory(provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static WorkManagerWorkerFactory newInstance(UploadLogsUseCase uploadLogsUseCase, MetricsUseCase metricsUseCase, IUserContextManager iUserContextManager, BoxApiPrivate boxApiPrivate, JobManager jobManager, ILocalItemService iLocalItemService) {
        return new WorkManagerWorkerFactory(uploadLogsUseCase, metricsUseCase, iUserContextManager, boxApiPrivate, jobManager, iLocalItemService);
    }
}
