package com.box.android.data.jobs;

import android.content.Context;
import com.box.android.data.datasource.jobs.JobsDataSource;
import com.box.android.domain.configuration.FeatureFlips;
import com.box.android.domain.metrics.Gen204JobServiceHelper;
import com.box.android.domain.services.RumService;
import dagger.Lazy;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.Provider;
import kotlinx.coroutines.CoroutineDispatcher;

/* JADX INFO: loaded from: classes11.dex */
public final class JobService_Factory implements Factory<JobService> {
    private final Provider<Context> appContextProvider;
    private final Provider<CoroutineDispatcher> dispatcherProvider;
    private final Provider<FeatureFlips> featureFlipsProvider;
    private final Provider<Gen204JobServiceHelper> gen204JobServiceHelperProvider;
    private final Provider<JobFactory> jobFactoryProvider;
    private final Provider<JobsDataSource> jobsDataSourceProvider;
    private final Provider<RumService> rumServiceProvider;

    private JobService_Factory(Provider<Context> appContextProvider, Provider<JobsDataSource> jobsDataSourceProvider, Provider<JobFactory> jobFactoryProvider, Provider<Gen204JobServiceHelper> gen204JobServiceHelperProvider, Provider<RumService> rumServiceProvider, Provider<FeatureFlips> featureFlipsProvider, Provider<CoroutineDispatcher> dispatcherProvider) {
        this.appContextProvider = appContextProvider;
        this.jobsDataSourceProvider = jobsDataSourceProvider;
        this.jobFactoryProvider = jobFactoryProvider;
        this.gen204JobServiceHelperProvider = gen204JobServiceHelperProvider;
        this.rumServiceProvider = rumServiceProvider;
        this.featureFlipsProvider = featureFlipsProvider;
        this.dispatcherProvider = dispatcherProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public JobService get() {
        return newInstance(this.appContextProvider.get(), this.jobsDataSourceProvider.get(), this.jobFactoryProvider.get(), DoubleCheck.lazy((Provider) this.gen204JobServiceHelperProvider), DoubleCheck.lazy((Provider) this.rumServiceProvider), DoubleCheck.lazy((Provider) this.featureFlipsProvider), this.dispatcherProvider.get());
    }

    public static JobService_Factory create(Provider<Context> appContextProvider, Provider<JobsDataSource> jobsDataSourceProvider, Provider<JobFactory> jobFactoryProvider, Provider<Gen204JobServiceHelper> gen204JobServiceHelperProvider, Provider<RumService> rumServiceProvider, Provider<FeatureFlips> featureFlipsProvider, Provider<CoroutineDispatcher> dispatcherProvider) {
        return new JobService_Factory(appContextProvider, jobsDataSourceProvider, jobFactoryProvider, gen204JobServiceHelperProvider, rumServiceProvider, featureFlipsProvider, dispatcherProvider);
    }

    public static JobService newInstance(Context appContext, JobsDataSource jobsDataSource, JobFactory jobFactory, Lazy<Gen204JobServiceHelper> gen204JobServiceHelper, Lazy<RumService> rumService, Lazy<FeatureFlips> featureFlips, CoroutineDispatcher dispatcher) {
        return new JobService(appContext, jobsDataSource, jobFactory, gen204JobServiceHelper, rumService, featureFlips, dispatcher);
    }
}
