package com.box.android.browse.cpl.browse;

import com.box.android.browse.cpl.browse.fab.FilesFabEnvironment;
import com.box.android.browse.cpl.createfolder.CreateFolderEnvironment;
import com.box.android.browse.utilities.BrowseAnalytics;
import com.box.android.domain.identity.IUserContextManager;
import com.box.android.domain.services.ApdexService;
import com.box.android.domain.usecases.browse.FolderUseCase;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes10.dex */
public final class BrowseEnvironment_Factory implements Factory<BrowseEnvironment> {
    private final Provider<ActionableFolderViewEnvironment> actionableItemsListEnvironmentProvider;
    private final Provider<ApdexService> apdexServiceProvider;
    private final Provider<BrowseAnalytics> browseAnalyticsProvider;
    private final Provider<CreateFolderEnvironment> createFolderEnvironmentProvider;
    private final Provider<FilesFabEnvironment> fabEnvironmentProvider;
    private final Provider<FolderUseCase> folderViewUseCaseProvider;
    private final Provider<IUserContextManager> userContextManagerProvider;

    private BrowseEnvironment_Factory(Provider<ActionableFolderViewEnvironment> provider, Provider<FilesFabEnvironment> provider2, Provider<BrowseAnalytics> provider3, Provider<FolderUseCase> provider4, Provider<IUserContextManager> provider5, Provider<CreateFolderEnvironment> provider6, Provider<ApdexService> provider7) {
        this.actionableItemsListEnvironmentProvider = provider;
        this.fabEnvironmentProvider = provider2;
        this.browseAnalyticsProvider = provider3;
        this.folderViewUseCaseProvider = provider4;
        this.userContextManagerProvider = provider5;
        this.createFolderEnvironmentProvider = provider6;
        this.apdexServiceProvider = provider7;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public BrowseEnvironment get() {
        return newInstance(this.actionableItemsListEnvironmentProvider.get(), this.fabEnvironmentProvider.get(), this.browseAnalyticsProvider.get(), this.folderViewUseCaseProvider.get(), this.userContextManagerProvider.get(), this.createFolderEnvironmentProvider.get(), this.apdexServiceProvider.get());
    }

    public static BrowseEnvironment_Factory create(Provider<ActionableFolderViewEnvironment> provider, Provider<FilesFabEnvironment> provider2, Provider<BrowseAnalytics> provider3, Provider<FolderUseCase> provider4, Provider<IUserContextManager> provider5, Provider<CreateFolderEnvironment> provider6, Provider<ApdexService> provider7) {
        return new BrowseEnvironment_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    public static BrowseEnvironment newInstance(ActionableFolderViewEnvironment actionableFolderViewEnvironment, FilesFabEnvironment filesFabEnvironment, BrowseAnalytics browseAnalytics, FolderUseCase folderUseCase, IUserContextManager iUserContextManager, CreateFolderEnvironment createFolderEnvironment, ApdexService apdexService) {
        return new BrowseEnvironment(actionableFolderViewEnvironment, filesFabEnvironment, browseAnalytics, folderUseCase, iUserContextManager, createFolderEnvironment, apdexService);
    }
}
