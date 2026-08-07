package com.box.android.browse.cpl.copymove;

import com.box.android.browse.cpl.browse.FolderViewEnvironment;
import com.box.android.browse.cpl.createfolder.CreateFolderEnvironment;
import com.box.android.domain.services.ILocalItemService;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CopyOrMoveReducer.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/box/android/browse/cpl/copymove/CopyOrMoveEnvironment;", "", "folderViewEnvironment", "Lcom/box/android/browse/cpl/browse/FolderViewEnvironment;", "createFolderEnvironment", "Lcom/box/android/browse/cpl/createfolder/CreateFolderEnvironment;", "localItemService", "Lcom/box/android/domain/services/ILocalItemService;", "<init>", "(Lcom/box/android/browse/cpl/browse/FolderViewEnvironment;Lcom/box/android/browse/cpl/createfolder/CreateFolderEnvironment;Lcom/box/android/domain/services/ILocalItemService;)V", "getFolderViewEnvironment", "()Lcom/box/android/browse/cpl/browse/FolderViewEnvironment;", "getCreateFolderEnvironment", "()Lcom/box/android/browse/cpl/createfolder/CreateFolderEnvironment;", "getLocalItemService", "()Lcom/box/android/domain/services/ILocalItemService;", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CopyOrMoveEnvironment {
    public static final int $stable = 8;
    private final CreateFolderEnvironment createFolderEnvironment;
    private final FolderViewEnvironment folderViewEnvironment;
    private final ILocalItemService localItemService;

    @Inject
    public CopyOrMoveEnvironment(FolderViewEnvironment folderViewEnvironment, CreateFolderEnvironment createFolderEnvironment, ILocalItemService localItemService) {
        Intrinsics.checkNotNullParameter(folderViewEnvironment, "folderViewEnvironment");
        Intrinsics.checkNotNullParameter(createFolderEnvironment, "createFolderEnvironment");
        Intrinsics.checkNotNullParameter(localItemService, "localItemService");
        this.folderViewEnvironment = folderViewEnvironment;
        this.createFolderEnvironment = createFolderEnvironment;
        this.localItemService = localItemService;
    }

    public final FolderViewEnvironment getFolderViewEnvironment() {
        return this.folderViewEnvironment;
    }

    public final CreateFolderEnvironment getCreateFolderEnvironment() {
        return this.createFolderEnvironment;
    }

    public final ILocalItemService getLocalItemService() {
        return this.localItemService;
    }
}
