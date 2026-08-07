package com.box.android.jobsui;

import com.box.android.cpl.IStoreFactory;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes12.dex */
public final class JobsUIViewModel_Factory implements Factory<JobsUIViewModel> {
    private final Provider<JobsReducer> jobsReducerProvider;
    private final Provider<IStoreFactory> storeFactoryProvider;

    private JobsUIViewModel_Factory(Provider<JobsReducer> provider, Provider<IStoreFactory> provider2) {
        this.jobsReducerProvider = provider;
        this.storeFactoryProvider = provider2;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public JobsUIViewModel get() {
        return newInstance(this.jobsReducerProvider.get(), this.storeFactoryProvider.get());
    }

    public static JobsUIViewModel_Factory create(Provider<JobsReducer> provider, Provider<IStoreFactory> provider2) {
        return new JobsUIViewModel_Factory(provider, provider2);
    }

    public static JobsUIViewModel newInstance(JobsReducer jobsReducer, IStoreFactory iStoreFactory) {
        return new JobsUIViewModel(jobsReducer, iStoreFactory);
    }
}
