package com.box.android.browse.cpl.copymove;

import com.box.android.browse.cpl.browse.FolderViewEnvironment;
import com.box.android.browse.cpl.createfolder.CreateFolderEnvironment;
import com.box.android.domain.services.ILocalItemService;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes10.dex */
public final class CopyOrMoveEnvironment_Factory implements Factory<CopyOrMoveEnvironment> {
    private final Provider<CreateFolderEnvironment> createFolderEnvironmentProvider;
    private final Provider<FolderViewEnvironment> folderViewEnvironmentProvider;
    private final Provider<ILocalItemService> localItemServiceProvider;

    private CopyOrMoveEnvironment_Factory(Provider<FolderViewEnvironment> provider, Provider<CreateFolderEnvironment> provider2, Provider<ILocalItemService> provider3) {
        this.folderViewEnvironmentProvider = provider;
        this.createFolderEnvironmentProvider = provider2;
        this.localItemServiceProvider = provider3;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public CopyOrMoveEnvironment get() {
        return newInstance(this.folderViewEnvironmentProvider.get(), this.createFolderEnvironmentProvider.get(), this.localItemServiceProvider.get());
    }

    public static CopyOrMoveEnvironment_Factory create(Provider<FolderViewEnvironment> provider, Provider<CreateFolderEnvironment> provider2, Provider<ILocalItemService> provider3) {
        return new CopyOrMoveEnvironment_Factory(provider, provider2, provider3);
    }

    public static CopyOrMoveEnvironment newInstance(FolderViewEnvironment folderViewEnvironment, CreateFolderEnvironment createFolderEnvironment, ILocalItemService iLocalItemService) {
        return new CopyOrMoveEnvironment(folderViewEnvironment, createFolderEnvironment, iLocalItemService);
    }
}
