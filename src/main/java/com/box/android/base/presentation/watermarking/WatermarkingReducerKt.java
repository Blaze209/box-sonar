package com.box.android.base.presentation.watermarking;

import com.box.android.domain.models.item.FileModel;
import com.box.android.domain.models.item.FolderModel;
import com.box.android.domain.models.item.ItemModel;
import com.box.android.domain.models.item.PermissionsModel;
import com.box.android.domain.models.item.WatermarkModel;
import com.box.android.domain.utils.SupportedFileExtensions;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: WatermarkingReducer.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a$\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0002\u001a\u0012\u0010\b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0002\u001a\u00020\u0003H\u0002\u001a\u0012\u0010\t\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0002\u001a\u00020\u0003H\u0002\u001a\n\u0010\n\u001a\u00020\u000b*\u00020\f\u001a\n\u0010\n\u001a\u00020\u000b*\u00020\r¨\u0006\u000e"}, d2 = {"disabledReasonFrom", "Lcom/box/android/base/presentation/watermarking/WatermarkingReducer$WatermarkingDisabledReason;", "itemModel", "Lcom/box/android/domain/models/item/ItemModel;", "watermark", "Lcom/box/android/domain/models/item/WatermarkModel;", "permissions", "Lcom/box/android/domain/models/item/PermissionsModel;", "extractWatermarkFromItem", "extractPermissionsFromItem", "toWatermarkingState", "Lcom/box/android/base/presentation/watermarking/WatermarkingReducer$State;", "Lcom/box/android/domain/models/item/FileModel;", "Lcom/box/android/domain/models/item/FolderModel;", "base_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class WatermarkingReducerKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final WatermarkingReducer.WatermarkingDisabledReason disabledReasonFrom(ItemModel itemModel, WatermarkModel watermarkModel, PermissionsModel permissionsModel) {
        if ((itemModel instanceof FileModel) && SupportedFileExtensions.INSTANCE.isWatermarkUnsupportedExtension(((FileModel) itemModel).getExtension())) {
            return WatermarkingReducer.WatermarkingDisabledReason.NotSupportedForFileType.INSTANCE;
        }
        if (watermarkModel != null && watermarkModel.isWatermarkedByAccessPolicy()) {
            return WatermarkingReducer.WatermarkingDisabledReason.EnforcedByAccessPolicy.INSTANCE;
        }
        if (watermarkModel != null && watermarkModel.isWatermarkInherited()) {
            return WatermarkingReducer.WatermarkingDisabledReason.EnabledAtParentLevel.INSTANCE;
        }
        if (permissionsModel.getCanApplyWatermark()) {
            return null;
        }
        return WatermarkingReducer.WatermarkingDisabledReason.NoPermission.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WatermarkModel extractWatermarkFromItem(ItemModel itemModel) {
        if (itemModel instanceof FileModel) {
            return ((FileModel) itemModel).getWatermark();
        }
        if (itemModel instanceof FolderModel) {
            return ((FolderModel) itemModel).getWatermark();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PermissionsModel extractPermissionsFromItem(ItemModel itemModel) {
        if (itemModel instanceof FileModel) {
            return ((FileModel) itemModel).getPermissions();
        }
        if (itemModel instanceof FolderModel) {
            return ((FolderModel) itemModel).getPermissions();
        }
        return null;
    }

    public static final WatermarkingReducer.State toWatermarkingState(FileModel fileModel) {
        Intrinsics.checkNotNullParameter(fileModel, "<this>");
        return new WatermarkingReducer.State.Loading(new WatermarkingReducer.WatermarkingTarget.File(fileModel));
    }

    public static final WatermarkingReducer.State toWatermarkingState(FolderModel folderModel) {
        Intrinsics.checkNotNullParameter(folderModel, "<this>");
        return new WatermarkingReducer.State.Loading(new WatermarkingReducer.WatermarkingTarget.Folder(folderModel));
    }
}
