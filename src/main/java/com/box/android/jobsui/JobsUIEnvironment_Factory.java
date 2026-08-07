package com.box.android.jobsui;

import com.box.android.base.presentation.ThumbnailManager;
import com.box.android.domain.services.IJobManagerBridgeService;
import com.box.android.domain.services.IJobService;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes12.dex */
public final class JobsUIEnvironment_Factory implements Factory<JobsUIEnvironment> {
    private final Provider<IJobManagerBridgeService> jobManagerBridgeServiceProvider;
    private final Provider<IJobNotificationService> jobNotificationServiceProvider;
    private final Provider<IJobService> jobServiceProvider;
    private final Provider<JobsUICoreHelper> jobsUICoreHelperProvider;
    private final Provider<ThumbnailManager> thumbnailManagerProvider;

    private JobsUIEnvironment_Factory(Provider<IJobManagerBridgeService> provider, Provider<IJobService> provider2, Provider<ThumbnailManager> provider3, Provider<JobsUICoreHelper> provider4, Provider<IJobNotificationService> provider5) {
        this.jobManagerBridgeServiceProvider = provider;
        this.jobServiceProvider = provider2;
        this.thumbnailManagerProvider = provider3;
        this.jobsUICoreHelperProvider = provider4;
        this.jobNotificationServiceProvider = provider5;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public JobsUIEnvironment get() {
        return newInstance(this.jobManagerBridgeServiceProvider.get(), this.jobServiceProvider.get(), this.thumbnailManagerProvider.get(), this.jobsUICoreHelperProvider.get(), this.jobNotificationServiceProvider.get());
    }

    public static JobsUIEnvironment_Factory create(Provider<IJobManagerBridgeService> provider, Provider<IJobService> provider2, Provider<ThumbnailManager> provider3, Provider<JobsUICoreHelper> provider4, Provider<IJobNotificationService> provider5) {
        return new JobsUIEnvironment_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static JobsUIEnvironment newInstance(IJobManagerBridgeService iJobManagerBridgeService, IJobService iJobService, ThumbnailManager thumbnailManager, JobsUICoreHelper jobsUICoreHelper, IJobNotificationService iJobNotificationService) {
        return new JobsUIEnvironment(iJobManagerBridgeService, iJobService, thumbnailManager, jobsUICoreHelper, iJobNotificationService);
    }
}
