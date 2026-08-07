package com.box.android.browse.cpl.browse;

import com.box.android.browse.cpl.browse.fab.FilesFabEnvironment;
import com.box.android.browse.cpl.createfolder.CreateFolderEnvironment;
import com.box.android.browse.utilities.BrowseAnalytics;
import com.box.android.domain.identity.IUserContextManager;
import com.box.android.domain.services.ApdexService;
import com.box.android.domain.usecases.browse.FolderUseCase;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BrowseReducer.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0007\u0018\u00002\u00020\u0001BA\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001f¨\u0006 "}, d2 = {"Lcom/box/android/browse/cpl/browse/BrowseEnvironment;", "", "actionableItemsListEnvironment", "Lcom/box/android/browse/cpl/browse/ActionableFolderViewEnvironment;", "fabEnvironment", "Lcom/box/android/browse/cpl/browse/fab/FilesFabEnvironment;", "browseAnalytics", "Lcom/box/android/browse/utilities/BrowseAnalytics;", "folderViewUseCase", "Lcom/box/android/domain/usecases/browse/FolderUseCase;", "userContextManager", "Lcom/box/android/domain/identity/IUserContextManager;", "createFolderEnvironment", "Lcom/box/android/browse/cpl/createfolder/CreateFolderEnvironment;", "apdexService", "Lcom/box/android/domain/services/ApdexService;", "<init>", "(Lcom/box/android/browse/cpl/browse/ActionableFolderViewEnvironment;Lcom/box/android/browse/cpl/browse/fab/FilesFabEnvironment;Lcom/box/android/browse/utilities/BrowseAnalytics;Lcom/box/android/domain/usecases/browse/FolderUseCase;Lcom/box/android/domain/identity/IUserContextManager;Lcom/box/android/browse/cpl/createfolder/CreateFolderEnvironment;Lcom/box/android/domain/services/ApdexService;)V", "getActionableItemsListEnvironment", "()Lcom/box/android/browse/cpl/browse/ActionableFolderViewEnvironment;", "getFabEnvironment", "()Lcom/box/android/browse/cpl/browse/fab/FilesFabEnvironment;", "getBrowseAnalytics", "()Lcom/box/android/browse/utilities/BrowseAnalytics;", "getFolderViewUseCase", "()Lcom/box/android/domain/usecases/browse/FolderUseCase;", "getUserContextManager", "()Lcom/box/android/domain/identity/IUserContextManager;", "getCreateFolderEnvironment", "()Lcom/box/android/browse/cpl/createfolder/CreateFolderEnvironment;", "getApdexService", "()Lcom/box/android/domain/services/ApdexService;", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class BrowseEnvironment {
    public static final int $stable = 8;
    private final ActionableFolderViewEnvironment actionableItemsListEnvironment;
    private final ApdexService apdexService;
    private final BrowseAnalytics browseAnalytics;
    private final CreateFolderEnvironment createFolderEnvironment;
    private final FilesFabEnvironment fabEnvironment;
    private final FolderUseCase folderViewUseCase;
    private final IUserContextManager userContextManager;

    @Inject
    public BrowseEnvironment(ActionableFolderViewEnvironment actionableItemsListEnvironment, FilesFabEnvironment fabEnvironment, BrowseAnalytics browseAnalytics, FolderUseCase folderViewUseCase, IUserContextManager userContextManager, CreateFolderEnvironment createFolderEnvironment, ApdexService apdexService) {
        Intrinsics.checkNotNullParameter(actionableItemsListEnvironment, "actionableItemsListEnvironment");
        Intrinsics.checkNotNullParameter(fabEnvironment, "fabEnvironment");
        Intrinsics.checkNotNullParameter(browseAnalytics, "browseAnalytics");
        Intrinsics.checkNotNullParameter(folderViewUseCase, "folderViewUseCase");
        Intrinsics.checkNotNullParameter(userContextManager, "userContextManager");
        Intrinsics.checkNotNullParameter(createFolderEnvironment, "createFolderEnvironment");
        Intrinsics.checkNotNullParameter(apdexService, "apdexService");
        this.actionableItemsListEnvironment = actionableItemsListEnvironment;
        this.fabEnvironment = fabEnvironment;
        this.browseAnalytics = browseAnalytics;
        this.folderViewUseCase = folderViewUseCase;
        this.userContextManager = userContextManager;
        this.createFolderEnvironment = createFolderEnvironment;
        this.apdexService = apdexService;
    }

    public final ActionableFolderViewEnvironment getActionableItemsListEnvironment() {
        return this.actionableItemsListEnvironment;
    }

    public final FilesFabEnvironment getFabEnvironment() {
        return this.fabEnvironment;
    }

    public final BrowseAnalytics getBrowseAnalytics() {
        return this.browseAnalytics;
    }

    public final FolderUseCase getFolderViewUseCase() {
        return this.folderViewUseCase;
    }

    public final IUserContextManager getUserContextManager() {
        return this.userContextManager;
    }

    public final CreateFolderEnvironment getCreateFolderEnvironment() {
        return this.createFolderEnvironment;
    }

    public final ApdexService getApdexService() {
        return this.apdexService;
    }
}
