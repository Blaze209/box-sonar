package com.box.android.jobsui;

import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes12.dex */
public final class JobsReducer_Factory implements Factory<JobsReducer> {
    private final Provider<JobsUIEnvironment> environmentProvider;

    private JobsReducer_Factory(Provider<JobsUIEnvironment> provider) {
        this.environmentProvider = provider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public JobsReducer get() {
        return newInstance(this.environmentProvider.get());
    }

    public static JobsReducer_Factory create(Provider<JobsUIEnvironment> provider) {
        return new JobsReducer_Factory(provider);
    }

    public static JobsReducer newInstance(JobsUIEnvironment jobsUIEnvironment) {
        return new JobsReducer(jobsUIEnvironment);
    }
}
