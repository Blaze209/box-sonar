package com.box.android.base.presentation.components.topbar.component.jobsprogress;

import com.box.android.cpl.IStoreFactory;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes9.dex */
public final class JobsProgressViewModel_Factory implements Factory<JobsProgressViewModel> {
    private final Provider<JobsProgressEnvironment> jobsProgressEnvironmentProvider;
    private final Provider<IStoreFactory> storeFactoryProvider;

    private JobsProgressViewModel_Factory(Provider<JobsProgressEnvironment> provider, Provider<IStoreFactory> provider2) {
        this.jobsProgressEnvironmentProvider = provider;
        this.storeFactoryProvider = provider2;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public JobsProgressViewModel get() {
        return newInstance(this.jobsProgressEnvironmentProvider.get(), this.storeFactoryProvider.get());
    }

    public static JobsProgressViewModel_Factory create(Provider<JobsProgressEnvironment> provider, Provider<IStoreFactory> provider2) {
        return new JobsProgressViewModel_Factory(provider, provider2);
    }

    public static JobsProgressViewModel newInstance(JobsProgressEnvironment jobsProgressEnvironment, IStoreFactory iStoreFactory) {
        return new JobsProgressViewModel(jobsProgressEnvironment, iStoreFactory);
    }
}
