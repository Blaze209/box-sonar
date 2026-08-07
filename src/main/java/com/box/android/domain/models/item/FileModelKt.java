package com.box.android.domain.models.item;

import com.box.android.domain.utils.SupportedFileExtensions;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FileModel.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0003\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0004"}, d2 = {"isReadOnlyBoxNote", "", "Lcom/box/android/domain/models/item/FileModel;", "isWatermarkedVideo", "domain_prodRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class FileModelKt {
    public static final boolean isReadOnlyBoxNote(FileModel fileModel) {
        Intrinsics.checkNotNullParameter(fileModel, "<this>");
        if (!SupportedFileExtensions.INSTANCE.isBoxNoteExtension(fileModel.getExtension())) {
            return false;
        }
        PermissionsModel permissions = fileModel.getPermissions();
        return (permissions != null && permissions.getCanDownload() && permissions.getCanUpload()) ? false : true;
    }

    public static final boolean isWatermarkedVideo(FileModel fileModel) {
        Intrinsics.checkNotNullParameter(fileModel, "<this>");
        WatermarkModel watermark = fileModel.getWatermark();
        return watermark != null && watermark.isWatermarked() && SupportedFileExtensions.INSTANCE.isVideoExtension(fileModel.getExtension());
    }
}
