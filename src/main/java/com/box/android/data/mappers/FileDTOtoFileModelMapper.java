package com.box.android.data.mappers;

import com.box.android.data.api.models.ClassificationDTO;
import com.box.android.data.api.models.FileLockDTO;
import com.box.android.data.api.models.PathCollectionDTO;
import com.box.android.data.api.models.PermissionsDTO;
import com.box.android.data.api.models.RepresentationsDTO;
import com.box.android.data.api.models.SharedLinkDTO;
import com.box.android.data.api.models.UserMiniDTO;
import com.box.android.data.api.models.WatermarkDTO;
import com.box.android.data.api.models.collections.CollectionDTO;
import com.box.android.data.api.models.fileversions.FileVersionMiniDTO;
import com.box.android.data.api.models.items.FileDTO;
import com.box.android.data.api.models.items.mini.FolderMiniDTO;
import com.box.android.domain.models.ClassificationModel;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.models.RepresentationModel;
import com.box.android.domain.models.SharedLinkPermissionOptionType;
import com.box.android.domain.models.item.FileLockModel;
import com.box.android.domain.models.item.FileModel;
import com.box.android.domain.models.item.FileVersionMiniModel;
import com.box.android.domain.models.item.FolderModel;
import com.box.android.domain.models.item.PathCollectionEntry;
import com.box.android.domain.models.item.PermissionsModel;
import com.box.android.domain.models.item.SharedLinkModel;
import com.box.android.domain.models.item.UserModel;
import com.box.androidsdk.content.utils.BoxDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FileDTOtoFileModelMapper.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/box/android/data/mappers/FileDTOtoFileModelMapper;", "", "<init>", "()V", "toDomain", "Lcom/box/android/domain/models/item/FileModel;", "dataModel", "Lcom/box/android/data/api/models/items/FileDTO;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class FileDTOtoFileModelMapper {
    public static final FileDTOtoFileModelMapper INSTANCE = new FileDTOtoFileModelMapper();

    private FileDTOtoFileModelMapper() {
    }

    public final FileModel toDomain(FileDTO dataModel) {
        ArrayList arrayList;
        Intrinsics.checkNotNullParameter(dataModel, "dataModel");
        ItemId itemIdCreateItemId = FileModel.INSTANCE.createItemId(dataModel.getId());
        String name = dataModel.getName();
        String str = name == null ? "" : name;
        Boolean hasCollaborations = dataModel.getHasCollaborations();
        boolean zBooleanValue = hasCollaborations != null ? hasCollaborations.booleanValue() : false;
        Boolean boolIsExternallyOwned = dataModel.isExternallyOwned();
        boolean zBooleanValue2 = boolIsExternallyOwned != null ? boolIsExternallyOwned.booleanValue() : false;
        Long size = dataModel.getSize();
        long jLongValue = size != null ? size.longValue() : 0L;
        String sha1 = dataModel.getSha1();
        String str2 = sha1 == null ? "" : sha1;
        String createdAt = dataModel.getCreatedAt();
        Date date = createdAt != null ? BoxDateFormat.parse(createdAt) : null;
        String contentCreatedAt = dataModel.getContentCreatedAt();
        Date date2 = contentCreatedAt != null ? BoxDateFormat.parse(contentCreatedAt) : null;
        String modifiedAt = dataModel.getModifiedAt();
        Date date3 = modifiedAt != null ? BoxDateFormat.parse(modifiedAt) : null;
        UserMiniDTO modifiedBy = dataModel.getModifiedBy();
        UserModel domain = modifiedBy != null ? UserMiniDTOtoUserDomainModelMapper.INSTANCE.toDomain(modifiedBy) : null;
        String contentModifiedAt = dataModel.getContentModifiedAt();
        Date date4 = contentModifiedAt != null ? BoxDateFormat.parse(contentModifiedAt) : null;
        PathCollectionDTO pathCollection = dataModel.getPathCollection();
        boolean isRooted = pathCollection != null ? pathCollection.getIsRooted() : false;
        PermissionsDTO permissions = dataModel.getPermissions();
        PermissionsModel domain2 = permissions != null ? PermissionsDTOtoPermissionsModelMapper.INSTANCE.toDomain(permissions) : null;
        List<SharedLinkPermissionOptionType> sharedLinkPermissions = dataModel.getSharedLinkPermissions();
        SharedLinkDTO sharedLink = dataModel.getSharedLink();
        SharedLinkModel domain3 = sharedLink != null ? SharedLinkDTOtoSharedLinkModelMapper.INSTANCE.toDomain(sharedLink) : null;
        FolderMiniDTO parent = dataModel.getParent();
        FolderModel domain4 = parent != null ? FolderMiniDTOtoFolderModelMapper.INSTANCE.toDomain(parent) : null;
        UserMiniDTO ownedBy = dataModel.getOwnedBy();
        UserModel domain5 = ownedBy != null ? UserMiniDTOtoUserDomainModelMapper.INSTANCE.toDomain(ownedBy) : null;
        PathCollectionDTO pathCollection2 = dataModel.getPathCollection();
        List<PathCollectionEntry> domain6 = pathCollection2 != null ? PathCollectionDTOtoPathCollectionEntryMapper.INSTANCE.toDomain(pathCollection2) : null;
        List<CollectionDTO> collections = dataModel.getCollections();
        if (collections != null) {
            List<CollectionDTO> list = collections;
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            for (Iterator it = list.iterator(); it.hasNext(); it = it) {
                arrayList2.add(CollectionDTOToDomainModelMapper.INSTANCE.toDomain((CollectionDTO) it.next()));
            }
            arrayList = arrayList2;
        } else {
            arrayList = null;
        }
        FileVersionMiniDTO fileVersion = dataModel.getFileVersion();
        FileVersionMiniModel domain7 = fileVersion != null ? FileVersionMiniDTOMapper.INSTANCE.toDomain(fileVersion) : null;
        FileLockDTO fileLock = dataModel.getFileLock();
        FileLockModel domain8 = fileLock != null ? FileLockDTOtoFileLockModelMapper.INSTANCE.toDomain(fileLock) : null;
        Long commentCount = dataModel.getCommentCount();
        Long annotationCount = dataModel.getAnnotationCount();
        RepresentationsDTO representations = dataModel.getRepresentations();
        List<RepresentationModel> domain9 = representations != null ? RepresentationToDomainUtilsKt.toDomain(representations) : null;
        String description = dataModel.getDescription();
        ClassificationDTO classification = dataModel.getClassification();
        ClassificationModel domain10 = classification != null ? ClassificationDTOtoClassificationModelMapper.INSTANCE.toDomain(classification) : null;
        WatermarkDTO watermark = dataModel.getWatermark();
        return new FileModel(itemIdCreateItemId, str, zBooleanValue, zBooleanValue2, domain4, domain5, domain, date, date2, date3, date4, isRooted, jLongValue, domain2, domain6, arrayList, domain3, domain9, sharedLinkPermissions, str2, domain7, domain8, commentCount, annotationCount, domain10, watermark != null ? WatermarkDTOtoWatermarkModelMapper.INSTANCE.toDomain(watermark) : null, description);
    }
}
