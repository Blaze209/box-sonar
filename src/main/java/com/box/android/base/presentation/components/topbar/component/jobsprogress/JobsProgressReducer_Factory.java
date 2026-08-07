package com.box.android.base.presentation.components.topbar.component.jobsprogress;

import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes9.dex */
public final class JobsProgressReducer_Factory implements Factory<JobsProgressReducer> {
    private final Provider<JobsProgressEnvironment> environmentProvider;

    private JobsProgressReducer_Factory(Provider<JobsProgressEnvironment> provider) {
        this.environmentProvider = provider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public JobsProgressReducer get() {
        return newInstance(this.environmentProvider.get());
    }

    public static JobsProgressReducer_Factory create(Provider<JobsProgressEnvironment> provider) {
        return new JobsProgressReducer_Factory(provider);
    }

    public static JobsProgressReducer newInstance(JobsProgressEnvironment jobsProgressEnvironment) {
        return new JobsProgressReducer(jobsProgressEnvironment);
    }
}
