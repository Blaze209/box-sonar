package com.box.android.browse.cpl.browse;

import com.box.android.base.presentation.components.fileactions.DownloadEnvironment;
import com.box.android.base.presentation.components.fileactions.OfflineFilesEnvironment;
import com.box.android.boxai.BoxAiEnvironment;
import com.box.android.browse.utilities.BrowseAnalytics;
import com.box.android.coreservices.utilities.BoxAccountManagerHelper;
import com.box.android.coreservices.utilities.FileActionsManager;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes10.dex */
public final class ActionableFolderViewEnvironment_Factory implements Factory<ActionableFolderViewEnvironment> {
    private final Provider<BoxAccountManagerHelper> boxAccountManagerHelperProvider;
    private final Provider<BoxAiEnvironment> boxAiEnvironmentProvider;
    private final Provider<BrowseAnalytics> browseAnalyticsProvider;
    private final Provider<DownloadEnvironment> downloadEnvironmentProvider;
    private final Provider<FileActionsManager> fileActionsManagerProvider;
    private final Provider<FolderViewEnvironment> itemListViewEnvironmentProvider;
    private final Provider<OfflineFilesEnvironment> offlineFilesEnvironmentProvider;

    private ActionableFolderViewEnvironment_Factory(Provider<FolderViewEnvironment> provider, Provider<BrowseAnalytics> provider2, Provider<BoxAccountManagerHelper> provider3, Provider<FileActionsManager> provider4, Provider<OfflineFilesEnvironment> provider5, Provider<DownloadEnvironment> provider6, Provider<BoxAiEnvironment> provider7) {
        this.itemListViewEnvironmentProvider = provider;
        this.browseAnalyticsProvider = provider2;
        this.boxAccountManagerHelperProvider = provider3;
        this.fileActionsManagerProvider = provider4;
        this.offlineFilesEnvironmentProvider = provider5;
        this.downloadEnvironmentProvider = provider6;
        this.boxAiEnvironmentProvider = provider7;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public ActionableFolderViewEnvironment get() {
        return newInstance(this.itemListViewEnvironmentProvider.get(), this.browseAnalyticsProvider.get(), this.boxAccountManagerHelperProvider.get(), this.fileActionsManagerProvider.get(), this.offlineFilesEnvironmentProvider.get(), this.downloadEnvironmentProvider.get(), this.boxAiEnvironmentProvider.get());
    }

    public static ActionableFolderViewEnvironment_Factory create(Provider<FolderViewEnvironment> provider, Provider<BrowseAnalytics> provider2, Provider<BoxAccountManagerHelper> provider3, Provider<FileActionsManager> provider4, Provider<OfflineFilesEnvironment> provider5, Provider<DownloadEnvironment> provider6, Provider<BoxAiEnvironment> provider7) {
        return new ActionableFolderViewEnvironment_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    public static ActionableFolderViewEnvironment newInstance(FolderViewEnvironment folderViewEnvironment, BrowseAnalytics browseAnalytics, BoxAccountManagerHelper boxAccountManagerHelper, FileActionsManager fileActionsManager, OfflineFilesEnvironment offlineFilesEnvironment, DownloadEnvironment downloadEnvironment, BoxAiEnvironment boxAiEnvironment) {
        return new ActionableFolderViewEnvironment(folderViewEnvironment, browseAnalytics, boxAccountManagerHelper, fileActionsManager, offlineFilesEnvironment, downloadEnvironment, boxAiEnvironment);
    }
}
