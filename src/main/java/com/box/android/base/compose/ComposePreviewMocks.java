package com.box.android.base.compose;

import com.box.android.domain.models.item.FileModel;
import com.box.android.domain.models.item.FolderModel;
import com.box.android.domain.models.item.RecentFileModel;
import com.box.android.domain.models.item.RecentItemModel;
import com.box.android.domain.models.item.UserModel;
import com.box.android.domain.usecases.InteractionType;
import kotlin.Metadata;

/* JADX INFO: compiled from: ComposePreviewUtils.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/box/android/base/compose/ComposePreviewMocks;", "", "<init>", "()V", "EMPTY_FILE_MODEL", "Lcom/box/android/domain/models/item/FileModel;", "getEMPTY_FILE_MODEL", "()Lcom/box/android/domain/models/item/FileModel;", "EMPTY_RECENT_FILE_MODEL", "Lcom/box/android/domain/models/item/RecentFileModel;", "getEMPTY_RECENT_FILE_MODEL", "()Lcom/box/android/domain/models/item/RecentFileModel;", "EMPTY_FOLDER_MODEL", "Lcom/box/android/domain/models/item/FolderModel;", "getEMPTY_FOLDER_MODEL", "()Lcom/box/android/domain/models/item/FolderModel;", "EMPTY_USER_MODEL", "Lcom/box/android/domain/models/item/UserModel;", "getEMPTY_USER_MODEL", "()Lcom/box/android/domain/models/item/UserModel;", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ComposePreviewMocks {
    public static final ComposePreviewMocks INSTANCE = new ComposePreviewMocks();
    private static final FileModel EMPTY_FILE_MODEL = new FileModel(FileModel.INSTANCE.createItemId("file-id"), "name", false, false, null, null, null, null, null, null, null, false, 0, null, null, null, null, null, null, "", null, null, null, null, null, null, null);
    private static final RecentFileModel EMPTY_RECENT_FILE_MODEL = new RecentFileModel(FileModel.INSTANCE.createItemId("folder-id"), "name", false, false, null, null, null, null, null, null, null, false, 0, null, null, null, null, null, null, "", null, null, null, null, null, new RecentItemModel(InteractionType.MODIFY, null, null), null, 67108864, null);
    private static final FolderModel EMPTY_FOLDER_MODEL = new FolderModel(FileModel.INSTANCE.createItemId("folder-id"), "name", false, false, null, null, null, null, null, null, null, false, 0L, null, null, null, null, null, null, 262144, null);
    private static final UserModel EMPTY_USER_MODEL = new UserModel("", "", null, null, null, null, null, null, null);
    public static final int $stable = 8;

    private ComposePreviewMocks() {
    }

    public final FileModel getEMPTY_FILE_MODEL() {
        return EMPTY_FILE_MODEL;
    }

    public final RecentFileModel getEMPTY_RECENT_FILE_MODEL() {
        return EMPTY_RECENT_FILE_MODEL;
    }

    public final FolderModel getEMPTY_FOLDER_MODEL() {
        return EMPTY_FOLDER_MODEL;
    }

    public final UserModel getEMPTY_USER_MODEL() {
        return EMPTY_USER_MODEL;
    }
}
