package com.box.android.preview.fileactions;

import com.box.android.base.cpl.DeleteEnvironment;
import com.box.android.base.cpl.EndCollaborationEnvironment;
import com.box.android.base.presentation.components.fileactions.DownloadEnvironment;
import com.box.android.base.presentation.components.fileactions.OfflineFilesEnvironment;
import com.box.android.boxai.BoxAiEnvironment;
import com.box.android.coreservices.models.BoxModelOfflineManagerWrapper;
import com.box.android.coreservices.utilities.FileActionsManager;
import com.box.android.domain.configuration.FeatureFlips;
import com.box.android.domain.services.IOfflineService;
import com.box.android.preview.fileactions.copylink.CopyLinkEnvironment;
import com.box.android.preview.fileactions.openin.OpenInEnvironment;
import com.box.android.preview.preview.PreviewAnalytics;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes12.dex */
public final class FileActionsEnvironment_Factory implements Factory<FileActionsEnvironment> {
    private final Provider<PreviewAnalytics> analyticsProvider;
    private final Provider<BoxAiEnvironment> boxAiEnvironmentProvider;
    private final Provider<BoxModelOfflineManagerWrapper> boxModelOfflineManagerWrapperProvider;
    private final Provider<CopyLinkEnvironment> copyLinkEnvironmentProvider;
    private final Provider<DeleteEnvironment> deleteEnvironmentProvider;
    private final Provider<DownloadEnvironment> downloadEnvironmentProvider;
    private final Provider<EndCollaborationEnvironment> endCollaborationEnvironmentProvider;
    private final Provider<FeatureFlips> featureFlipsProvider;
    private final Provider<FileActionsManager> fileActionsManagerProvider;
    private final Provider<OfflineFilesEnvironment> offlineFilesEnvironmentProvider;
    private final Provider<IOfflineService> offlineServiceProvider;
    private final Provider<OpenInEnvironment> openInEnvironmentProvider;
    private final Provider<UpdateItemInfoEnvironment> updateItemInfoEnvironmentProvider;

    private FileActionsEnvironment_Factory(Provider<FileActionsManager> provider, Provider<IOfflineService> provider2, Provider<CopyLinkEnvironment> provider3, Provider<DeleteEnvironment> provider4, Provider<EndCollaborationEnvironment> provider5, Provider<UpdateItemInfoEnvironment> provider6, Provider<OpenInEnvironment> provider7, Provider<DownloadEnvironment> provider8, Provider<OfflineFilesEnvironment> provider9, Provider<BoxAiEnvironment> provider10, Provider<PreviewAnalytics> provider11, Provider<BoxModelOfflineManagerWrapper> provider12, Provider<FeatureFlips> provider13) {
        this.fileActionsManagerProvider = provider;
        this.offlineServiceProvider = provider2;
        this.copyLinkEnvironmentProvider = provider3;
        this.deleteEnvironmentProvider = provider4;
        this.endCollaborationEnvironmentProvider = provider5;
        this.updateItemInfoEnvironmentProvider = provider6;
        this.openInEnvironmentProvider = provider7;
        this.downloadEnvironmentProvider = provider8;
        this.offlineFilesEnvironmentProvider = provider9;
        this.boxAiEnvironmentProvider = provider10;
        this.analyticsProvider = provider11;
        this.boxModelOfflineManagerWrapperProvider = provider12;
        this.featureFlipsProvider = provider13;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public FileActionsEnvironment get() {
        return newInstance(this.fileActionsManagerProvider.get(), this.offlineServiceProvider.get(), this.copyLinkEnvironmentProvider.get(), this.deleteEnvironmentProvider.get(), this.endCollaborationEnvironmentProvider.get(), this.updateItemInfoEnvironmentProvider.get(), this.openInEnvironmentProvider.get(), this.downloadEnvironmentProvider.get(), this.offlineFilesEnvironmentProvider.get(), this.boxAiEnvironmentProvider.get(), this.analyticsProvider.get(), this.boxModelOfflineManagerWrapperProvider.get(), this.featureFlipsProvider.get());
    }

    public static FileActionsEnvironment_Factory create(Provider<FileActionsManager> provider, Provider<IOfflineService> provider2, Provider<CopyLinkEnvironment> provider3, Provider<DeleteEnvironment> provider4, Provider<EndCollaborationEnvironment> provider5, Provider<UpdateItemInfoEnvironment> provider6, Provider<OpenInEnvironment> provider7, Provider<DownloadEnvironment> provider8, Provider<OfflineFilesEnvironment> provider9, Provider<BoxAiEnvironment> provider10, Provider<PreviewAnalytics> provider11, Provider<BoxModelOfflineManagerWrapper> provider12, Provider<FeatureFlips> provider13) {
        return new FileActionsEnvironment_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12, provider13);
    }

    public static FileActionsEnvironment newInstance(FileActionsManager fileActionsManager, IOfflineService iOfflineService, CopyLinkEnvironment copyLinkEnvironment, DeleteEnvironment deleteEnvironment, EndCollaborationEnvironment endCollaborationEnvironment, UpdateItemInfoEnvironment updateItemInfoEnvironment, OpenInEnvironment openInEnvironment, DownloadEnvironment downloadEnvironment, OfflineFilesEnvironment offlineFilesEnvironment, BoxAiEnvironment boxAiEnvironment, PreviewAnalytics previewAnalytics, BoxModelOfflineManagerWrapper boxModelOfflineManagerWrapper, FeatureFlips featureFlips) {
        return new FileActionsEnvironment(fileActionsManager, iOfflineService, copyLinkEnvironment, deleteEnvironment, endCollaborationEnvironment, updateItemInfoEnvironment, openInEnvironment, downloadEnvironment, offlineFilesEnvironment, boxAiEnvironment, previewAnalytics, boxModelOfflineManagerWrapper, featureFlips);
    }
}
