package com.box.android.data.api.models.items;

import com.box.android.data.api.models.ClassificationDTO;
import com.box.android.data.api.models.FileLockDTO;
import com.box.android.data.api.models.RepresentationsDTO;
import com.box.android.data.api.models.WatermarkDTO;
import com.box.android.data.api.models.fileversions.FileVersionMiniDTO;
import com.box.android.data.api.models.items.mini.IFileMiniDTO;
import com.box.android.domain.models.SharedLinkPermissionOptionType;
import com.box.androidsdk.content.models.BoxFile;
import com.box.androidsdk.content.models.BoxItem;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: FileDTO.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u00012\u00020\u0002R\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u0004\u0018\u00010\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u0004\u0018\u00010\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\u0006R\u0014\u0010\r\u001a\u0004\u0018\u00010\u000eX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u0004\u0018\u00010\u000eX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0010R\u001a\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u0004\u0018\u00010\u0019X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\u0004\u0018\u00010\u001dX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u0014\u0010 \u001a\u0004\u0018\u00010!X¦\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u0014\u0010$\u001a\u0004\u0018\u00010%X¦\u0004¢\u0006\u0006\u001a\u0004\b&\u0010'¨\u0006(À\u0006\u0003"}, d2 = {"Lcom/box/android/data/api/models/items/IFileDTO;", "Lcom/box/android/data/api/models/items/IItemDTO;", "Lcom/box/android/data/api/models/items/mini/IFileMiniDTO;", "sha1", "", "getSha1", "()Ljava/lang/String;", "fileVersion", "Lcom/box/android/data/api/models/fileversions/FileVersionMiniDTO;", "getFileVersion", "()Lcom/box/android/data/api/models/fileversions/FileVersionMiniDTO;", "versionNumber", "getVersionNumber", "commentCount", "", "getCommentCount", "()Ljava/lang/Long;", "annotationCount", "getAnnotationCount", "sharedLinkPermissions", "", "Lcom/box/android/domain/models/SharedLinkPermissionOptionType;", "getSharedLinkPermissions", "()Ljava/util/List;", "fileLock", "Lcom/box/android/data/api/models/FileLockDTO;", "getFileLock", "()Lcom/box/android/data/api/models/FileLockDTO;", BoxFile.FIELD_REPRESENTATIONS, "Lcom/box/android/data/api/models/RepresentationsDTO;", "getRepresentations", "()Lcom/box/android/data/api/models/RepresentationsDTO;", BoxItem.FIELD_CLASSIFICATION, "Lcom/box/android/data/api/models/ClassificationDTO;", "getClassification", "()Lcom/box/android/data/api/models/ClassificationDTO;", "watermark", "Lcom/box/android/data/api/models/WatermarkDTO;", "getWatermark", "()Lcom/box/android/data/api/models/WatermarkDTO;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface IFileDTO extends IItemDTO, IFileMiniDTO {
    Long getAnnotationCount();

    ClassificationDTO getClassification();

    Long getCommentCount();

    FileLockDTO getFileLock();

    FileVersionMiniDTO getFileVersion();

    RepresentationsDTO getRepresentations();

    String getSha1();

    List<SharedLinkPermissionOptionType> getSharedLinkPermissions();

    String getVersionNumber();

    WatermarkDTO getWatermark();
}
