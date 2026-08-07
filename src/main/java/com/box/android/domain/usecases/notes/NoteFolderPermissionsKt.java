package com.box.android.domain.usecases.notes;

import com.box.android.domain.models.item.FolderModel;
import com.box.android.domain.models.item.PermissionsModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NoteFolderPermissions.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, d2 = {"canCreateNotes", "", "Lcom/box/android/domain/models/item/FolderModel;", "domain_prodRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class NoteFolderPermissionsKt {
    public static final boolean canCreateNotes(FolderModel folderModel) {
        Intrinsics.checkNotNullParameter(folderModel, "<this>");
        PermissionsModel permissions = folderModel.getPermissions();
        if (permissions == null) {
            return true;
        }
        return permissions.getCanUpload() && permissions.getCanDownload();
    }
}
