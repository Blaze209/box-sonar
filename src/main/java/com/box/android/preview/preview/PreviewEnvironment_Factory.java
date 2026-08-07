package com.box.android.preview.preview;

import com.box.android.coreservices.jobmanager.JobManager;
import com.box.android.coreservices.utilities.FileActionsManager;
import com.box.android.domain.configuration.FeatureFlips;
import com.box.android.domain.services.IAudioPlaylistItemsService;
import com.box.android.domain.services.IGalleryItemsService;
import com.box.android.domain.services.ILocalItemService;
import com.box.android.domain.usecases.preview.TrackRecentPreviewItemInteractor;
import com.box.android.preview.fileactions.FileActionsEnvironment;
import com.box.android.preview.item.ItemPreviewEnvironment;
import com.box.android.preview.preview.previewbar.bottombar.BottomBarEnvironment;
import com.box.android.preview.preview.previewbar.topbar.TopBarEnvironment;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes12.dex */
public final class PreviewEnvironment_Factory implements Factory<PreviewEnvironment> {
    private final Provider<PreviewAnalytics> analyticsProvider;
    private final Provider<IAudioPlaylistItemsService> audioPlaylistItemsServiceProvider;
    private final Provider<BottomBarEnvironment> bottomBarEnvironmentProvider;
    private final Provider<FeatureFlips> featureFlipsProvider;
    private final Provider<FileActionsEnvironment> fileActionsEnvironmentProvider;
    private final Provider<FileActionsManager> fileActionsManagerProvider;
    private final Provider<IGalleryItemsService> galleryItemsServiceProvider;
    private final Provider<ItemPreviewEnvironment> itemPreviewEnvironmentProvider;
    private final Provider<ILocalItemService> itemServiceProvider;
    private final Provider<JobManager> jobManagerProvider;
    private final Provider<TopBarEnvironment> topBarEnvironmentProvider;
    private final Provider<TrackRecentPreviewItemInteractor> trackRecentPreviewItemInteractorProvider;

    private PreviewEnvironment_Factory(Provider<ItemPreviewEnvironment> provider, Provider<JobManager> provider2, Provider<FeatureFlips> provider3, Provider<FileActionsManager> provider4, Provider<TrackRecentPreviewItemInteractor> provider5, Provider<ILocalItemService> provider6, Provider<PreviewAnalytics> provider7, Provider<FileActionsEnvironment> provider8, Provider<IGalleryItemsService> provider9, Provider<IAudioPlaylistItemsService> provider10, Provider<TopBarEnvironment> provider11, Provider<BottomBarEnvironment> provider12) {
        this.itemPreviewEnvironmentProvider = provider;
        this.jobManagerProvider = provider2;
        this.featureFlipsProvider = provider3;
        this.fileActionsManagerProvider = provider4;
        this.trackRecentPreviewItemInteractorProvider = provider5;
        this.itemServiceProvider = provider6;
        this.analyticsProvider = provider7;
        this.fileActionsEnvironmentProvider = provider8;
        this.galleryItemsServiceProvider = provider9;
        this.audioPlaylistItemsServiceProvider = provider10;
        this.topBarEnvironmentProvider = provider11;
        this.bottomBarEnvironmentProvider = provider12;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public PreviewEnvironment get() {
        return newInstance(this.itemPreviewEnvironmentProvider.get(), this.jobManagerProvider.get(), this.featureFlipsProvider.get(), this.fileActionsManagerProvider.get(), this.trackRecentPreviewItemInteractorProvider.get(), this.itemServiceProvider.get(), this.analyticsProvider.get(), this.fileActionsEnvironmentProvider.get(), this.galleryItemsServiceProvider.get(), this.audioPlaylistItemsServiceProvider.get(), this.topBarEnvironmentProvider.get(), this.bottomBarEnvironmentProvider.get());
    }

    public static PreviewEnvironment_Factory create(Provider<ItemPreviewEnvironment> provider, Provider<JobManager> provider2, Provider<FeatureFlips> provider3, Provider<FileActionsManager> provider4, Provider<TrackRecentPreviewItemInteractor> provider5, Provider<ILocalItemService> provider6, Provider<PreviewAnalytics> provider7, Provider<FileActionsEnvironment> provider8, Provider<IGalleryItemsService> provider9, Provider<IAudioPlaylistItemsService> provider10, Provider<TopBarEnvironment> provider11, Provider<BottomBarEnvironment> provider12) {
        return new PreviewEnvironment_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12);
    }

    public static PreviewEnvironment newInstance(ItemPreviewEnvironment itemPreviewEnvironment, JobManager jobManager, FeatureFlips featureFlips, FileActionsManager fileActionsManager, TrackRecentPreviewItemInteractor trackRecentPreviewItemInteractor, ILocalItemService iLocalItemService, PreviewAnalytics previewAnalytics, FileActionsEnvironment fileActionsEnvironment, IGalleryItemsService iGalleryItemsService, IAudioPlaylistItemsService iAudioPlaylistItemsService, TopBarEnvironment topBarEnvironment, BottomBarEnvironment bottomBarEnvironment) {
        return new PreviewEnvironment(itemPreviewEnvironment, jobManager, featureFlips, fileActionsManager, trackRecentPreviewItemInteractor, iLocalItemService, previewAnalytics, fileActionsEnvironment, iGalleryItemsService, iAudioPlaylistItemsService, topBarEnvironment, bottomBarEnvironment);
    }
}
