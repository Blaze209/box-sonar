package com.box.android.data.mappers;

import com.box.android.data.MoveItemMutation;
import com.box.android.data.api.models.FileLockDTO;
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

/* JADX INFO: compiled from: GQLMoveItemToIItemDTOMapper.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0007\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u001a\u0010\n\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\f\u0010\u000b\u001a\u00020\u0003*\u00020\fH\u0002J\f\u0010\u000b\u001a\u00020\u0003*\u00020\rH\u0002J\f\u0010\u000b\u001a\u00020\u0003*\u00020\u000eH\u0002¨\u0006\u000f"}, d2 = {"Lcom/box/android/data/mappers/GQLMoveItemToIItemDTOMapper;", "Lcom/box/android/data/mappers/GraphQLMapper;", "Lcom/box/android/data/api/models/items/IItemDTO;", "Lcom/box/android/data/MoveItemMutation$MoveItem;", "<init>", "()V", "toGraphQL", "source", "options", "", "fromGraphQL", "toItem", "Lcom/box/android/data/api/models/items/FileDTO;", "Lcom/box/android/data/api/models/items/FolderDTO;", "Lcom/box/android/data/api/models/items/WebLinkDTO;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class GQLMoveItemToIItemDTOMapper implements GraphQLMapper<IItemDTO, MoveItemMutation.MoveItem> {
    public static final GQLMoveItemToIItemDTOMapper INSTANCE = new GQLMoveItemToIItemDTOMapper();

    private GQLMoveItemToIItemDTOMapper() {
    }

    @Override // com.box.android.data.mappers.GraphQLMapper
    public MoveItemMutation.MoveItem toGraphQL(IItemDTO source, Object options) {
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
    public IItemDTO fromGraphQL(MoveItemMutation.MoveItem source, Object options) {
        Intrinsics.checkNotNullParameter(source, "source");
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    private final MoveItemMutation.MoveItem toItem(FileDTO fileDTO) {
        MoveItemMutation.OwnedBy ownedBy;
        MoveItemMutation.UpdatedBy updatedBy;
        Date date;
        String str;
        ItemType itemType;
        String str2;
        MoveItemMutation.ItemCollectionConnection itemCollectionConnection;
        MoveItemMutation.FileLock fileLock;
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
        boolean isRooted = pathCollection != null ? pathCollection.getIsRooted() : false;
        UserMiniDTO ownedBy2 = fileDTO.getOwnedBy();
        if (ownedBy2 != null) {
            String id2 = ownedBy2.getId();
            String name2 = ownedBy2.getName();
            if (name2 == null) {
                name2 = "";
            }
            ownedBy = new MoveItemMutation.OwnedBy(id2, name2);
        } else {
            ownedBy = null;
        }
        UserMiniDTO modifiedBy = fileDTO.getModifiedBy();
        if (modifiedBy != null) {
            String id3 = modifiedBy.getId();
            String name3 = modifiedBy.getName();
            updatedBy = new MoveItemMutation.UpdatedBy(id3, name3 != null ? name3 : "");
        } else {
            updatedBy = null;
        }
        FolderMiniDTO parent = fileDTO.getParent();
        MoveItemMutation.Parent parent2 = parent != null ? new MoveItemMutation.Parent(parent.getId(), parent.getName()) : null;
        Long size = fileDTO.getSize();
        Boolean hasCollaborations = fileDTO.getHasCollaborations();
        Boolean boolIsExternallyOwned = fileDTO.isExternallyOwned();
        String sha1 = fileDTO.getSha1();
        WatermarkDTO watermark = fileDTO.getWatermark();
        MoveItemMutation.Watermark watermark2 = watermark != null ? new MoveItemMutation.Watermark(Boolean.valueOf(watermark.isWatermarked())) : null;
        PermissionsDTO permissions = fileDTO.getPermissions();
        MoveItemMutation.PermissionsV2Api permissionsV2Api = permissions != null ? new MoveItemMutation.PermissionsV2Api(permissions.getCanComment(), permissions.getCanCreateAnnotations(), permissions.getCanDelete(), permissions.getCanDownload(), permissions.getCanInviteCollaborator(), permissions.getCanPreview(), permissions.getCanRename(), permissions.getCanSetShareAccess(), permissions.getCanShare(), permissions.getCanUpload(), permissions.getCanViewAnnotations()) : null;
        FileVersionMiniDTO fileVersion = fileDTO.getFileVersion();
        MoveItemMutation.FileVersion fileVersion2 = fileVersion != null ? new MoveItemMutation.FileVersion(fileVersion.getId(), fileVersion.getSha1()) : null;
        List<CollectionDTO> collections = fileDTO.getCollections();
        if (collections != null) {
            List<CollectionDTO> list = collections;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            for (CollectionDTO collectionDTO : list) {
                arrayList.add(new MoveItemMutation.Edge(collectionDTO.getId(), new MoveItemMutation.Node(collectionDTO.getId(), collectionDTO.getName(), collectionDTO.getCollectionType().name())));
                date2 = date2;
                id = id;
                itemType2 = itemType2;
                name = name;
            }
            date = date2;
            str = id;
            itemType = itemType2;
            str2 = name;
            itemCollectionConnection = new MoveItemMutation.ItemCollectionConnection(arrayList);
        } else {
            date = date2;
            str = id;
            itemType = itemType2;
            str2 = name;
            itemCollectionConnection = null;
        }
        FileLockDTO fileLock2 = fileDTO.getFileLock();
        if (fileLock2 != null) {
            String id4 = fileLock2.getId();
            String appType = fileLock2.getAppType();
            String createdAt2 = fileLock2.getCreatedAt();
            Date date6 = createdAt2 != null ? BoxDateFormat.parse(createdAt2) : null;
            UserMiniDTO createdBy = fileLock2.getCreatedBy();
            MoveItemMutation.CreatedBy createdBy2 = createdBy != null ? new MoveItemMutation.CreatedBy(createdBy.getId(), createdBy.getName(), createdBy.getLogin()) : null;
            String expiresAt = fileLock2.getExpiresAt();
            fileLock = new MoveItemMutation.FileLock(id4, appType, date6, createdBy2, expiresAt != null ? BoxDateFormat.parse(expiresAt) : null, fileLock2.isDownloadPrevented());
        } else {
            fileLock = null;
        }
        Long commentCount = fileDTO.getCommentCount();
        Integer numValueOf = commentCount != null ? Integer.valueOf((int) commentCount.longValue()) : null;
        Long annotationCount = fileDTO.getAnnotationCount();
        return new MoveItemMutation.MoveItem(gQLTypename, new MoveItemMutation.OnFile(str, itemType, str2, date, date3, date4, date5, Boolean.valueOf(isRooted), numValueOf, annotationCount != null ? Integer.valueOf((int) annotationCount.longValue()) : null, itemCollectionConnection, ownedBy, updatedBy, parent2, size, hasCollaborations, boolIsExternallyOwned, sha1, watermark2, permissionsV2Api, fileVersion2, fileLock), null, null);
    }

    private final MoveItemMutation.MoveItem toItem(FolderDTO folderDTO) {
        MoveItemMutation.OwnedBy1 ownedBy1;
        MoveItemMutation.UpdatedBy1 updatedBy1;
        String str;
        ItemType itemType;
        String str2;
        Date date;
        MoveItemMutation.ItemCollectionConnection1 itemCollectionConnection1;
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
        boolean isRooted = pathCollection != null ? pathCollection.getIsRooted() : false;
        UserMiniDTO ownedBy = folderDTO.getOwnedBy();
        if (ownedBy != null) {
            String id2 = ownedBy.getId();
            String name2 = ownedBy.getName();
            if (name2 == null) {
                name2 = "";
            }
            ownedBy1 = new MoveItemMutation.OwnedBy1(id2, name2);
        } else {
            ownedBy1 = null;
        }
        UserMiniDTO modifiedBy = folderDTO.getModifiedBy();
        if (modifiedBy != null) {
            String id3 = modifiedBy.getId();
            String name3 = modifiedBy.getName();
            updatedBy1 = new MoveItemMutation.UpdatedBy1(id3, name3 != null ? name3 : "");
        } else {
            updatedBy1 = null;
        }
        FolderMiniDTO parent = folderDTO.getParent();
        MoveItemMutation.Parent1 parent1 = parent != null ? new MoveItemMutation.Parent1(parent.getId(), parent.getName()) : null;
        Long size = folderDTO.getSize();
        Boolean hasCollaborations = folderDTO.getHasCollaborations();
        Boolean boolIsExternallyOwned = folderDTO.isExternallyOwned();
        PermissionsDTO permissions = folderDTO.getPermissions();
        MoveItemMutation.PermissionsV2Api1 permissionsV2Api1 = permissions != null ? new MoveItemMutation.PermissionsV2Api1(permissions.getCanDelete(), permissions.getCanDownload(), permissions.getCanInviteCollaborator(), permissions.getCanRename(), permissions.getCanSetShareAccess(), permissions.getCanShare(), permissions.getCanUpload()) : null;
        List<CollectionDTO> collections = folderDTO.getCollections();
        if (collections != null) {
            List<CollectionDTO> list = collections;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator it = list.iterator();
            while (it.hasNext()) {
                CollectionDTO collectionDTO = (CollectionDTO) it.next();
                arrayList.add(new MoveItemMutation.Edge1(collectionDTO.getId(), new MoveItemMutation.Node1(collectionDTO.getId(), collectionDTO.getName(), collectionDTO.getCollectionType().name())));
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
            itemCollectionConnection1 = new MoveItemMutation.ItemCollectionConnection1(arrayList);
        } else {
            str = id;
            itemType = itemType2;
            str2 = name;
            date = date3;
            itemCollectionConnection1 = null;
        }
        return new MoveItemMutation.MoveItem(gQLTypename, null, new MoveItemMutation.OnFolder(str, itemType, str2, date2, date, date4, date5, Boolean.valueOf(isRooted), itemCollectionConnection1, ownedBy1, updatedBy1, parent1, size, hasCollaborations, boolIsExternallyOwned, permissionsV2Api1), null);
    }

    private final MoveItemMutation.MoveItem toItem(WebLinkDTO webLinkDTO) {
        MoveItemMutation.OwnedBy2 ownedBy2;
        MoveItemMutation.UpdatedBy2 updatedBy2;
        boolean z;
        String str;
        ItemType itemType;
        String str2;
        MoveItemMutation.ItemCollectionConnection2 itemCollectionConnection2;
        String gQLTypename = TypenameMapperKt.toGQLTypename(com.box.android.domain.models.item.ItemType.WEBLINK);
        String id = webLinkDTO.getId();
        ItemType itemType2 = ItemType.web_link;
        String name = webLinkDTO.getName();
        String createdAt = webLinkDTO.getCreatedAt();
        Date date = createdAt != null ? BoxDateFormat.parse(createdAt) : null;
        String modifiedAt = webLinkDTO.getModifiedAt();
        Date date2 = modifiedAt != null ? BoxDateFormat.parse(modifiedAt) : null;
        PathCollectionDTO pathCollection = webLinkDTO.getPathCollection();
        boolean isRooted = pathCollection != null ? pathCollection.getIsRooted() : false;
        UserMiniDTO ownedBy = webLinkDTO.getOwnedBy();
        if (ownedBy != null) {
            String id2 = ownedBy.getId();
            String name2 = ownedBy.getName();
            if (name2 == null) {
                name2 = "";
            }
            ownedBy2 = new MoveItemMutation.OwnedBy2(id2, name2);
        } else {
            ownedBy2 = null;
        }
        UserMiniDTO modifiedBy = webLinkDTO.getModifiedBy();
        if (modifiedBy != null) {
            String id3 = modifiedBy.getId();
            String name3 = modifiedBy.getName();
            updatedBy2 = new MoveItemMutation.UpdatedBy2(id3, name3 != null ? name3 : "");
        } else {
            updatedBy2 = null;
        }
        FolderMiniDTO parent = webLinkDTO.getParent();
        MoveItemMutation.Parent2 parent2 = parent != null ? new MoveItemMutation.Parent2(parent.getId(), parent.getName()) : null;
        PermissionsDTO permissions = webLinkDTO.getPermissions();
        MoveItemMutation.PermissionsV2Api2 permissionsV2Api2 = permissions != null ? new MoveItemMutation.PermissionsV2Api2(permissions.getCanComment(), permissions.getCanDelete(), permissions.getCanRename(), permissions.getCanSetShareAccess(), permissions.getCanShare()) : null;
        String url = webLinkDTO.getUrl();
        List<CollectionDTO> collections = webLinkDTO.getCollections();
        if (collections != null) {
            List<CollectionDTO> list = collections;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            for (CollectionDTO collectionDTO : list) {
                arrayList.add(new MoveItemMutation.Edge2(collectionDTO.getId(), new MoveItemMutation.Node2(collectionDTO.getId(), collectionDTO.getName(), collectionDTO.getCollectionType().name())));
                isRooted = isRooted;
                id = id;
                itemType2 = itemType2;
                name = name;
            }
            z = isRooted;
            str = id;
            itemType = itemType2;
            str2 = name;
            itemCollectionConnection2 = new MoveItemMutation.ItemCollectionConnection2(arrayList);
        } else {
            z = isRooted;
            str = id;
            itemType = itemType2;
            str2 = name;
            itemCollectionConnection2 = null;
        }
        return new MoveItemMutation.MoveItem(gQLTypename, null, null, new MoveItemMutation.OnWeblink(str, itemType, str2, date, date2, Boolean.valueOf(z), itemCollectionConnection2, ownedBy2, updatedBy2, parent2, url, permissionsV2Api2));
    }
}
