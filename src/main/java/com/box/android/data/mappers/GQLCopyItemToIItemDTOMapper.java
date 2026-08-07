package com.box.android.data.mappers;

import com.box.android.data.CopyItemMutation;
import com.box.android.data.api.models.PathCollectionDTO;
import com.box.android.data.api.models.PermissionsDTO;
import com.box.android.data.api.models.UserMiniDTO;
import com.box.android.data.api.models.WatermarkDTO;
import com.box.android.data.api.models.collections.CollectionDTO;
import com.box.android.data.api.models.fileversions.FileVersionMiniDTO;
import com.box.android.data.api.models.items.FileDTO;
import com.box.android.data.api.models.items.FolderDTO;
import com.box.android.data.api.models.items.IItemDTO;
import com.box.android.data.api.models.items.WebLinkDTO;
import com.box.android.data.api.models.items.mini.FolderMiniDTO;
import com.box.android.data.type.ItemType;
import com.box.androidsdk.content.utils.BoxDateFormat;
import com.box.androidsdk.content.utils.BoxLogUtils;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GQLCopyItemToIItemDTOMapper.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0007\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u001a\u0010\n\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\f\u0010\u000b\u001a\u00020\u0003*\u00020\fH\u0002J\f\u0010\u000b\u001a\u00020\u0003*\u00020\rH\u0002J\f\u0010\u000b\u001a\u00020\u0003*\u00020\u000eH\u0002¨\u0006\u000f"}, d2 = {"Lcom/box/android/data/mappers/GQLCopyItemToIItemDTOMapper;", "Lcom/box/android/data/mappers/GraphQLMapper;", "Lcom/box/android/data/api/models/items/IItemDTO;", "Lcom/box/android/data/CopyItemMutation$CopyItem;", "<init>", "()V", "toGraphQL", "source", "options", "", "fromGraphQL", "toItem", "Lcom/box/android/data/api/models/items/FileDTO;", "Lcom/box/android/data/api/models/items/FolderDTO;", "Lcom/box/android/data/api/models/items/WebLinkDTO;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class GQLCopyItemToIItemDTOMapper implements GraphQLMapper<IItemDTO, CopyItemMutation.CopyItem> {
    public static final GQLCopyItemToIItemDTOMapper INSTANCE = new GQLCopyItemToIItemDTOMapper();

    private GQLCopyItemToIItemDTOMapper() {
    }

    @Override // com.box.android.data.mappers.GraphQLMapper
    public CopyItemMutation.CopyItem toGraphQL(IItemDTO source, Object options) {
        Intrinsics.checkNotNullParameter(source, "source");
        if (source instanceof FileDTO) {
            return toItem((FileDTO) source);
        }
        if (source instanceof FolderDTO) {
            return toItem((FolderDTO) source);
        }
        if (source instanceof WebLinkDTO) {
            return toItem((WebLinkDTO) source);
        }
        BoxLogUtils.w("Unexpected source: " + source);
        return null;
    }

    @Override // com.box.android.data.mappers.GraphQLMapper
    public IItemDTO fromGraphQL(CopyItemMutation.CopyItem source, Object options) {
        Intrinsics.checkNotNullParameter(source, "source");
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    private final CopyItemMutation.CopyItem toItem(FileDTO fileDTO) {
        CopyItemMutation.OwnedBy ownedBy;
        CopyItemMutation.UpdatedBy updatedBy;
        Date date;
        String str;
        ItemType itemType;
        String str2;
        CopyItemMutation.ItemCollectionConnection itemCollectionConnection;
        String gQLTypename = TypenameMapperKt.toGQLTypename(com.box.android.domain.models.item.ItemType.FILE);
        String id = fileDTO.getId();
        ItemType itemType2 = ItemType.file;
        String name = fileDTO.getName();
        String createdAt = fileDTO.getCreatedAt();
        Date date2 = createdAt != null ? BoxDateFormat.parse(createdAt) : null;
        String modifiedAt = fileDTO.getModifiedAt();
        Date date3 = modifiedAt != null ? BoxDateFormat.parse(modifiedAt) : null;
        String contentCreatedAt = fileDTO.getContentCreatedAt();
        Date date4 = contentCreatedAt != null ? BoxDateFormat.parse(contentCreatedAt) : null;
        String contentModifiedAt = fileDTO.getContentModifiedAt();
        Date date5 = contentModifiedAt != null ? BoxDateFormat.parse(contentModifiedAt) : null;
        PathCollectionDTO pathCollection = fileDTO.getPathCollection();
        Boolean boolValueOf = pathCollection != null ? Boolean.valueOf(pathCollection.getIsRooted()) : null;
        UserMiniDTO ownedBy2 = fileDTO.getOwnedBy();
        if (ownedBy2 != null) {
            String id2 = ownedBy2.getId();
            String name2 = ownedBy2.getName();
            if (name2 == null) {
                name2 = "";
            }
            ownedBy = new CopyItemMutation.OwnedBy(id2, name2);
        } else {
            ownedBy = null;
        }
        UserMiniDTO modifiedBy = fileDTO.getModifiedBy();
        if (modifiedBy != null) {
            String id3 = modifiedBy.getId();
            String name3 = modifiedBy.getName();
            updatedBy = new CopyItemMutation.UpdatedBy(id3, name3 != null ? name3 : "");
        } else {
            updatedBy = null;
        }
        FolderMiniDTO parent = fileDTO.getParent();
        CopyItemMutation.Parent parent2 = parent != null ? new CopyItemMutation.Parent(parent.getId(), parent.getName()) : null;
        Long size = fileDTO.getSize();
        Boolean hasCollaborations = fileDTO.getHasCollaborations();
        Boolean boolIsExternallyOwned = fileDTO.isExternallyOwned();
        String sha1 = fileDTO.getSha1();
        WatermarkDTO watermark = fileDTO.getWatermark();
        CopyItemMutation.Watermark watermark2 = watermark != null ? new CopyItemMutation.Watermark(Boolean.valueOf(watermark.isWatermarked())) : null;
        PermissionsDTO permissions = fileDTO.getPermissions();
        CopyItemMutation.PermissionsV2Api permissionsV2Api = permissions != null ? new CopyItemMutation.PermissionsV2Api(permissions.getCanComment(), permissions.getCanCreateAnnotations(), permissions.getCanDelete(), permissions.getCanDownload(), permissions.getCanInviteCollaborator(), permissions.getCanPreview(), permissions.getCanRename(), permissions.getCanSetShareAccess(), permissions.getCanShare(), permissions.getCanUpload(), permissions.getCanViewAnnotations()) : null;
        FileVersionMiniDTO fileVersion = fileDTO.getFileVersion();
        CopyItemMutation.FileVersion fileVersion2 = fileVersion != null ? new CopyItemMutation.FileVersion(fileVersion.getId(), fileVersion.getSha1()) : null;
        List<CollectionDTO> collections = fileDTO.getCollections();
        if (collections != null) {
            List<CollectionDTO> list = collections;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            for (CollectionDTO collectionDTO : list) {
                arrayList.add(new CopyItemMutation.Edge(collectionDTO.getId(), new CopyItemMutation.Node(collectionDTO.getId(), collectionDTO.getName(), collectionDTO.getCollectionType().name())));
                date2 = date2;
                id = id;
                itemType2 = itemType2;
                name = name;
            }
            date = date2;
            str = id;
            itemType = itemType2;
            str2 = name;
            itemCollectionConnection = new CopyItemMutation.ItemCollectionConnection(arrayList);
        } else {
            date = date2;
            str = id;
            itemType = itemType2;
            str2 = name;
            itemCollectionConnection = null;
        }
        Long commentCount = fileDTO.getCommentCount();
        Integer numValueOf = commentCount != null ? Integer.valueOf((int) commentCount.longValue()) : null;
        Long annotationCount = fileDTO.getAnnotationCount();
        return new CopyItemMutation.CopyItem(gQLTypename, new CopyItemMutation.OnFile(str, itemType, str2, date, date3, date4, date5, boolValueOf, numValueOf, annotationCount != null ? Integer.valueOf((int) annotationCount.longValue()) : null, itemCollectionConnection, ownedBy, updatedBy, parent2, size, hasCollaborations, boolIsExternallyOwned, sha1, watermark2, permissionsV2Api, fileVersion2), null, null);
    }

    private final CopyItemMutation.CopyItem toItem(FolderDTO folderDTO) {
        CopyItemMutation.OwnedBy1 ownedBy1;
        CopyItemMutation.UpdatedBy1 updatedBy1;
        String str;
        ItemType itemType;
        String str2;
        Date date;
        CopyItemMutation.ItemCollectionConnection1 itemCollectionConnection1;
        String gQLTypename = TypenameMapperKt.toGQLTypename(com.box.android.domain.models.item.ItemType.FOLDER);
        String id = folderDTO.getId();
        ItemType itemType2 = ItemType.folder;
        String name = folderDTO.getName();
        String createdAt = folderDTO.getCreatedAt();
        Date date2 = createdAt != null ? BoxDateFormat.parse(createdAt) : null;
        String modifiedAt = folderDTO.getModifiedAt();
        Date date3 = modifiedAt != null ? BoxDateFormat.parse(modifiedAt) : null;
        String contentCreatedAt = folderDTO.getContentCreatedAt();
        Date date4 = contentCreatedAt != null ? BoxDateFormat.parse(contentCreatedAt) : null;
        String contentModifiedAt = folderDTO.getContentModifiedAt();
        Date date5 = contentModifiedAt != null ? BoxDateFormat.parse(contentModifiedAt) : null;
        PathCollectionDTO pathCollection = folderDTO.getPathCollection();
        Boolean boolValueOf = pathCollection != null ? Boolean.valueOf(pathCollection.getIsRooted()) : null;
        UserMiniDTO ownedBy = folderDTO.getOwnedBy();
        if (ownedBy != null) {
            String id2 = ownedBy.getId();
            String name2 = ownedBy.getName();
            if (name2 == null) {
                name2 = "";
            }
            ownedBy1 = new CopyItemMutation.OwnedBy1(id2, name2);
        } else {
            ownedBy1 = null;
        }
        UserMiniDTO modifiedBy = folderDTO.getModifiedBy();
        if (modifiedBy != null) {
            String id3 = modifiedBy.getId();
            String name3 = modifiedBy.getName();
            updatedBy1 = new CopyItemMutation.UpdatedBy1(id3, name3 != null ? name3 : "");
        } else {
            updatedBy1 = null;
        }
        FolderMiniDTO parent = folderDTO.getParent();
        CopyItemMutation.Parent1 parent1 = parent != null ? new CopyItemMutation.Parent1(parent.getId(), parent.getName()) : null;
        Long size = folderDTO.getSize();
        Boolean hasCollaborations = folderDTO.getHasCollaborations();
        Boolean boolIsExternallyOwned = folderDTO.isExternallyOwned();
        PermissionsDTO permissions = folderDTO.getPermissions();
        CopyItemMutation.PermissionsV2Api1 permissionsV2Api1 = permissions != null ? new CopyItemMutation.PermissionsV2Api1(permissions.getCanDelete(), permissions.getCanDownload(), permissions.getCanInviteCollaborator(), permissions.getCanRename(), permissions.getCanSetShareAccess(), permissions.getCanShare(), permissions.getCanUpload()) : null;
        List<CollectionDTO> collections = folderDTO.getCollections();
        if (collections != null) {
            List<CollectionDTO> list = collections;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator it = list.iterator();
            while (it.hasNext()) {
                CollectionDTO collectionDTO = (CollectionDTO) it.next();
                arrayList.add(new CopyItemMutation.Edge1(collectionDTO.getId(), new CopyItemMutation.Node1(collectionDTO.getId(), collectionDTO.getName(), collectionDTO.getCollectionType().name())));
                it = it;
                id = id;
                itemType2 = itemType2;
                name = name;
                date3 = date3;
            }
            str = id;
            itemType = itemType2;
            str2 = name;
            date = date3;
            itemCollectionConnection1 = new CopyItemMutation.ItemCollectionConnection1(arrayList);
        } else {
            str = id;
            itemType = itemType2;
            str2 = name;
            date = date3;
            itemCollectionConnection1 = null;
        }
        return new CopyItemMutation.CopyItem(gQLTypename, null, new CopyItemMutation.OnFolder(str, itemType, str2, date2, date, date4, date5, boolValueOf, itemCollectionConnection1, ownedBy1, updatedBy1, parent1, size, hasCollaborations, boolIsExternallyOwned, permissionsV2Api1), null);
    }

    private final CopyItemMutation.CopyItem toItem(WebLinkDTO webLinkDTO) {
        CopyItemMutation.OwnedBy2 ownedBy2;
        CopyItemMutation.UpdatedBy2 updatedBy2;
        String str;
        ItemType itemType;
        String str2;
        CopyItemMutation.ItemCollectionConnection2 itemCollectionConnection2;
        String gQLTypename = TypenameMapperKt.toGQLTypename(com.box.android.domain.models.item.ItemType.WEBLINK);
        String id = webLinkDTO.getId();
        ItemType itemType2 = ItemType.web_link;
        String name = webLinkDTO.getName();
        String createdAt = webLinkDTO.getCreatedAt();
        Date date = createdAt != null ? BoxDateFormat.parse(createdAt) : null;
        String modifiedAt = webLinkDTO.getModifiedAt();
        Date date2 = modifiedAt != null ? BoxDateFormat.parse(modifiedAt) : null;
        PathCollectionDTO pathCollection = webLinkDTO.getPathCollection();
        Boolean boolValueOf = pathCollection != null ? Boolean.valueOf(pathCollection.getIsRooted()) : null;
        UserMiniDTO ownedBy = webLinkDTO.getOwnedBy();
        if (ownedBy != null) {
            String id2 = ownedBy.getId();
            String name2 = ownedBy.getName();
            if (name2 == null) {
                name2 = "";
            }
            ownedBy2 = new CopyItemMutation.OwnedBy2(id2, name2);
        } else {
            ownedBy2 = null;
        }
        UserMiniDTO modifiedBy = webLinkDTO.getModifiedBy();
        if (modifiedBy != null) {
            String id3 = modifiedBy.getId();
            String name3 = modifiedBy.getName();
            updatedBy2 = new CopyItemMutation.UpdatedBy2(id3, name3 != null ? name3 : "");
        } else {
            updatedBy2 = null;
        }
        FolderMiniDTO parent = webLinkDTO.getParent();
        CopyItemMutation.Parent2 parent2 = parent != null ? new CopyItemMutation.Parent2(parent.getId(), parent.getName()) : null;
        PermissionsDTO permissions = webLinkDTO.getPermissions();
        CopyItemMutation.PermissionsV2Api2 permissionsV2Api2 = permissions != null ? new CopyItemMutation.PermissionsV2Api2(permissions.getCanComment(), permissions.getCanDelete(), permissions.getCanRename(), permissions.getCanSetShareAccess(), permissions.getCanShare()) : null;
        String url = webLinkDTO.getUrl();
        List<CollectionDTO> collections = webLinkDTO.getCollections();
        if (collections != null) {
            List<CollectionDTO> list = collections;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator it = list.iterator();
            while (it.hasNext()) {
                CollectionDTO collectionDTO = (CollectionDTO) it.next();
                arrayList.add(new CopyItemMutation.Edge2(collectionDTO.getId(), new CopyItemMutation.Node2(collectionDTO.getId(), collectionDTO.getName(), collectionDTO.getCollectionType().name())));
                it = it;
                id = id;
                itemType2 = itemType2;
                name = name;
            }
            str = id;
            itemType = itemType2;
            str2 = name;
            itemCollectionConnection2 = new CopyItemMutation.ItemCollectionConnection2(arrayList);
        } else {
            str = id;
            itemType = itemType2;
            str2 = name;
            itemCollectionConnection2 = null;
        }
        return new CopyItemMutation.CopyItem(gQLTypename, null, null, new CopyItemMutation.OnWeblink(str, itemType, str2, date, date2, boolValueOf, itemCollectionConnection2, ownedBy2, updatedBy2, parent2, url, permissionsV2Api2));
    }
}
