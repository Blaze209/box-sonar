package com.box.android.base.presentation.components.fileactions;

import com.box.android.coreservices.jobmanager.JobManager;
import com.box.android.coreservices.utilities.FileActionsManager;
import com.box.android.domain.configuration.FeatureFlips;
import com.box.android.domain.services.ILocalItemService;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes9.dex */
public final class DownloadEnvironment_Factory implements Factory<DownloadEnvironment> {
    private final Provider<FeatureFlips> featureFlipsProvider;
    private final Provider<FileActionsManager> fileActionsManagerProvider;
    private final Provider<ILocalItemService> itemServiceProvider;
    private final Provider<JobManager> jobManagerProvider;

    private DownloadEnvironment_Factory(Provider<FileActionsManager> provider, Provider<JobManager> provider2, Provider<FeatureFlips> provider3, Provider<ILocalItemService> provider4) {
        this.fileActionsManagerProvider = provider;
        this.jobManagerProvider = provider2;
        this.featureFlipsProvider = provider3;
        this.itemServiceProvider = provider4;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public DownloadEnvironment get() {
        return newInstance(this.fileActionsManagerProvider.get(), this.jobManagerProvider.get(), this.featureFlipsProvider.get(), this.itemServiceProvider.get());
    }

    public static DownloadEnvironment_Factory create(Provider<FileActionsManager> provider, Provider<JobManager> provider2, Provider<FeatureFlips> provider3, Provider<ILocalItemService> provider4) {
        return new DownloadEnvironment_Factory(provider, provider2, provider3, provider4);
    }

    public static DownloadEnvironment newInstance(FileActionsManager fileActionsManager, JobManager jobManager, FeatureFlips featureFlips, ILocalItemService iLocalItemService) {
        return new DownloadEnvironment(fileActionsManager, jobManager, featureFlips, iLocalItemService);
    }
}
