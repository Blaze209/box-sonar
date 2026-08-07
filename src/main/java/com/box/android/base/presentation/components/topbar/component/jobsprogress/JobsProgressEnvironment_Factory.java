package com.box.android.base.presentation.components.topbar.component.jobsprogress;

import com.box.android.domain.services.IJobManagerBridgeService;
import com.box.android.domain.services.IJobService;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes9.dex */
public final class JobsProgressEnvironment_Factory implements Factory<JobsProgressEnvironment> {
    private final Provider<IJobManagerBridgeService> jobManagerBridgeServiceProvider;
    private final Provider<IJobService> jobServiceProvider;

    private JobsProgressEnvironment_Factory(Provider<IJobManagerBridgeService> provider, Provider<IJobService> provider2) {
        this.jobManagerBridgeServiceProvider = provider;
        this.jobServiceProvider = provider2;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public JobsProgressEnvironment get() {
        return newInstance(this.jobManagerBridgeServiceProvider.get(), this.jobServiceProvider.get());
    }

    public static JobsProgressEnvironment_Factory create(Provider<IJobManagerBridgeService> provider, Provider<IJobService> provider2) {
        return new JobsProgressEnvironment_Factory(provider, provider2);
    }

    public static JobsProgressEnvironment newInstance(IJobManagerBridgeService iJobManagerBridgeService, IJobService iJobService) {
        return new JobsProgressEnvironment(iJobManagerBridgeService, iJobService);
    }
}
