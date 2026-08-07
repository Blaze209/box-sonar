package com.box.android.data.mappers;

import com.box.android.data.api.models.PermissionsDTO;
import com.box.android.domain.models.item.PermissionsModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PermissionsDTOtoPermissionsModelMapper.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/box/android/data/mappers/PermissionsDTOtoPermissionsModelMapper;", "", "<init>", "()V", "toDomain", "Lcom/box/android/domain/models/item/PermissionsModel;", "dataModel", "Lcom/box/android/data/api/models/PermissionsDTO;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class PermissionsDTOtoPermissionsModelMapper {
    public static final PermissionsDTOtoPermissionsModelMapper INSTANCE = new PermissionsDTOtoPermissionsModelMapper();

    private PermissionsDTOtoPermissionsModelMapper() {
    }

    public final PermissionsModel toDomain(PermissionsDTO dataModel) {
        Intrinsics.checkNotNullParameter(dataModel, "dataModel");
        Boolean canDelete = dataModel.getCanDelete();
        boolean zBooleanValue = canDelete != null ? canDelete.booleanValue() : false;
        Boolean canRename = dataModel.getCanRename();
        boolean zBooleanValue2 = canRename != null ? canRename.booleanValue() : false;
        Boolean canDownload = dataModel.getCanDownload();
        boolean zBooleanValue3 = canDownload != null ? canDownload.booleanValue() : false;
        Boolean canPreview = dataModel.getCanPreview();
        boolean zBooleanValue4 = canPreview != null ? canPreview.booleanValue() : false;
        Boolean canUpload = dataModel.getCanUpload();
        boolean zBooleanValue5 = canUpload != null ? canUpload.booleanValue() : false;
        Boolean canComment = dataModel.getCanComment();
        boolean zBooleanValue6 = canComment != null ? canComment.booleanValue() : false;
        Boolean canShare = dataModel.getCanShare();
        boolean zBooleanValue7 = canShare != null ? canShare.booleanValue() : false;
        Boolean canInviteCollaborator = dataModel.getCanInviteCollaborator();
        boolean zBooleanValue8 = canInviteCollaborator != null ? canInviteCollaborator.booleanValue() : false;
        Boolean canSetShareAccess = dataModel.getCanSetShareAccess();
        boolean zBooleanValue9 = canSetShareAccess != null ? canSetShareAccess.booleanValue() : false;
        Boolean canViewAnnotations = dataModel.getCanViewAnnotations();
        boolean zBooleanValue10 = canViewAnnotations != null ? canViewAnnotations.booleanValue() : false;
        Boolean canCreateAnnotations = dataModel.getCanCreateAnnotations();
        return new PermissionsModel(zBooleanValue, zBooleanValue2, zBooleanValue3, zBooleanValue4, zBooleanValue5, zBooleanValue6, zBooleanValue7, zBooleanValue8, zBooleanValue9, zBooleanValue10, canCreateAnnotations != null ? canCreateAnnotations.booleanValue() : false, false, 2048, null);
    }
}
