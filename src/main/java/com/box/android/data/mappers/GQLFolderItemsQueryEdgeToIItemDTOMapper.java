package com.box.android.data.mappers;

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
import com.box.android.data.datasource.gql.cache.GQLEdgeHelper;
import com.box.android.data.fragment.FileFields;
import com.box.android.data.fragment.FolderFields;
import com.box.android.data.fragment.ItemConnectionFragment;
import com.box.android.data.fragment.WeblinkFields;
import com.box.android.domain.models.item.ItemType;
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

/* JADX INFO: compiled from: GQLFolderItemsQueryEdgeToIItemDTOMapper.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0007\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u001a\u0010\n\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u0002H\u0002J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\u0010H\u0002J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u0013H\u0002J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\r\u001a\u00020\u0016H\u0002¨\u0006\u0017"}, d2 = {"Lcom/box/android/data/mappers/GQLFolderItemsQueryEdgeToIItemDTOMapper;", "Lcom/box/android/data/mappers/GraphQLMapper;", "Lcom/box/android/data/api/models/items/IItemDTO;", "Lcom/box/android/data/fragment/ItemConnectionFragment$Edge;", "<init>", "()V", "toGraphQL", "source", "options", "", "fromGraphQL", "getNode", "Lcom/box/android/data/fragment/ItemConnectionFragment$Node;", "itemDTO", "getOnFile", "Lcom/box/android/data/fragment/FileFields;", "Lcom/box/android/data/api/models/items/FileDTO;", "getOnFolder", "Lcom/box/android/data/fragment/FolderFields;", "Lcom/box/android/data/api/models/items/FolderDTO;", "getOnWeblink", "Lcom/box/android/data/fragment/WeblinkFields;", "Lcom/box/android/data/api/models/items/WebLinkDTO;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class GQLFolderItemsQueryEdgeToIItemDTOMapper implements GraphQLMapper<IItemDTO, ItemConnectionFragment.Edge> {
    public static final GQLFolderItemsQueryEdgeToIItemDTOMapper INSTANCE = new GQLFolderItemsQueryEdgeToIItemDTOMapper();

    private GQLFolderItemsQueryEdgeToIItemDTOMapper() {
    }

    @Override // com.box.android.data.mappers.GraphQLMapper
    public ItemConnectionFragment.Edge toGraphQL(IItemDTO source, Object options) {
        Intrinsics.checkNotNullParameter(source, "source");
        ItemConnectionFragment.Node node = getNode(source);
        if (node != null) {
            return new ItemConnectionFragment.Edge(GQLEdgeHelper.INSTANCE.constructEdgeId(source), node);
        }
        return null;
    }

    @Override // com.box.android.data.mappers.GraphQLMapper
    public IItemDTO fromGraphQL(ItemConnectionFragment.Edge source, Object options) {
        Intrinsics.checkNotNullParameter(source, "source");
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    private final ItemConnectionFragment.Node getNode(IItemDTO itemDTO) {
        if (itemDTO instanceof FileDTO) {
            return new ItemConnectionFragment.Node(TypenameMapperKt.toGQLTypename(ItemType.FILE), getOnFile((FileDTO) itemDTO), null, null);
        }
        if (itemDTO instanceof FolderDTO) {
            return new ItemConnectionFragment.Node(TypenameMapperKt.toGQLTypename(ItemType.FOLDER), null, getOnFolder((FolderDTO) itemDTO), null);
        }
        if (itemDTO instanceof WebLinkDTO) {
            return new ItemConnectionFragment.Node(TypenameMapperKt.toGQLTypename(ItemType.WEBLINK), null, null, getOnWeblink((WebLinkDTO) itemDTO));
        }
        BoxLogUtils.e("Failed to translate itemDTO to GetFolderItemsQuery.Node");
        return null;
    }

    private final FileFields getOnFile(FileDTO itemDTO) {
        FileFields.OwnedBy ownedBy;
        FileFields.UpdatedBy updatedBy;
        Date date;
        String str;
        String str2;
        com.box.android.data.type.ItemType itemType;
        FileFields.ItemCollectionConnection itemCollectionConnection;
        FileFields.FileLock fileLock;
        String id = itemDTO.getId();
        String name = itemDTO.getName();
        com.box.android.data.type.ItemType itemType2 = com.box.android.data.type.ItemType.file;
        String createdAt = itemDTO.getCreatedAt();
        Date date2 = createdAt != null ? BoxDateFormat.parse(createdAt) : null;
        String modifiedAt = itemDTO.getModifiedAt();
        Date date3 = modifiedAt != null ? BoxDateFormat.parse(modifiedAt) : null;
        String contentCreatedAt = itemDTO.getContentCreatedAt();
        Date date4 = contentCreatedAt != null ? BoxDateFormat.parse(contentCreatedAt) : null;
        String contentModifiedAt = itemDTO.getContentModifiedAt();
        Date date5 = contentModifiedAt != null ? BoxDateFormat.parse(contentModifiedAt) : null;
        PathCollectionDTO pathCollection = itemDTO.getPathCollection();
        Boolean boolValueOf = pathCollection != null ? Boolean.valueOf(pathCollection.getIsRooted()) : null;
        UserMiniDTO ownedBy2 = itemDTO.getOwnedBy();
        if (ownedBy2 != null) {
            String id2 = ownedBy2.getId();
            String name2 = ownedBy2.getName();
            if (name2 == null) {
                name2 = "";
            }
            ownedBy = new FileFields.OwnedBy(id2, name2);
        } else {
            ownedBy = null;
        }
        UserMiniDTO modifiedBy = itemDTO.getModifiedBy();
        if (modifiedBy != null) {
            String id3 = modifiedBy.getId();
            String name3 = modifiedBy.getName();
            updatedBy = new FileFields.UpdatedBy(id3, name3 != null ? name3 : "");
        } else {
            updatedBy = null;
        }
        FolderMiniDTO parent = itemDTO.getParent();
        FileFields.Parent parent2 = parent != null ? new FileFields.Parent(parent.getId(), parent.getName()) : null;
        Long size = itemDTO.getSize();
        Boolean hasCollaborations = itemDTO.getHasCollaborations();
        Boolean boolIsExternallyOwned = itemDTO.isExternallyOwned();
        String sha1 = itemDTO.getSha1();
        WatermarkDTO watermark = itemDTO.getWatermark();
        FileFields.Watermark watermark2 = watermark != null ? new FileFields.Watermark(Boolean.valueOf(watermark.isWatermarked())) : null;
        PermissionsDTO permissions = itemDTO.getPermissions();
        FileFields.PermissionsV2Api permissionsV2Api = permissions != null ? new FileFields.PermissionsV2Api(permissions.getCanComment(), permissions.getCanDelete(), permissions.getCanDownload(), permissions.getCanInviteCollaborator(), permissions.getCanPreview(), permissions.getCanRename(), permissions.getCanSetShareAccess(), permissions.getCanShare(), permissions.getCanUpload(), permissions.getCanViewAnnotations(), permissions.getCanCreateAnnotations()) : null;
        FileVersionMiniDTO fileVersion = itemDTO.getFileVersion();
        FileFields.FileVersion fileVersion2 = fileVersion != null ? new FileFields.FileVersion(fileVersion.getId(), fileVersion.getSha1()) : null;
        List<CollectionDTO> collections = itemDTO.getCollections();
        if (collections != null) {
            List<CollectionDTO> list = collections;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            for (CollectionDTO collectionDTO : list) {
                arrayList.add(new FileFields.Edge(collectionDTO.getId(), new FileFields.Node(collectionDTO.getId(), collectionDTO.getName(), collectionDTO.getCollectionType().name())));
                date2 = date2;
                id = id;
                name = name;
                itemType2 = itemType2;
            }
            date = date2;
            str = id;
            str2 = name;
            itemType = itemType2;
            itemCollectionConnection = new FileFields.ItemCollectionConnection(arrayList);
        } else {
            date = date2;
            str = id;
            str2 = name;
            itemType = itemType2;
            itemCollectionConnection = null;
        }
        FileLockDTO fileLock2 = itemDTO.getFileLock();
        if (fileLock2 != null) {
            String id4 = fileLock2.getId();
            String appType = fileLock2.getAppType();
            String createdAt2 = fileLock2.getCreatedAt();
            Date date6 = createdAt2 != null ? BoxDateFormat.parse(createdAt2) : null;
            UserMiniDTO createdBy = fileLock2.getCreatedBy();
            FileFields.CreatedBy createdBy2 = createdBy != null ? new FileFields.CreatedBy(createdBy.getId(), createdBy.getName(), createdBy.getLogin()) : null;
            String expiresAt = fileLock2.getExpiresAt();
            fileLock = new FileFields.FileLock(id4, appType, date6, createdBy2, expiresAt != null ? BoxDateFormat.parse(expiresAt) : null, fileLock2.isDownloadPrevented());
        } else {
            fileLock = null;
        }
        Long commentCount = itemDTO.getCommentCount();
        Integer numValueOf = commentCount != null ? Integer.valueOf((int) commentCount.longValue()) : null;
        Long annotationCount = itemDTO.getAnnotationCount();
        return new FileFields(str, str2, itemType, date, date3, date4, date5, boolValueOf, numValueOf, annotationCount != null ? Integer.valueOf((int) annotationCount.longValue()) : null, ownedBy, updatedBy, parent2, fileVersion2, itemCollectionConnection, size, hasCollaborations, boolIsExternallyOwned, sha1, watermark2, permissionsV2Api, fileLock, SharedLinkModelToApolloSharedLinkMapper.INSTANCE.toFileFields(SharedLinkDTOtoSharedLinkModelMapper.INSTANCE.toSharedLinkModelOrNull(itemDTO.getSharedLink())));
    }

    private final FolderFields getOnFolder(FolderDTO itemDTO) {
        FolderFields.OwnedBy ownedBy;
        FolderFields.UpdatedBy updatedBy;
        String str;
        String str2;
        com.box.android.data.type.ItemType itemType;
        Date date;
        FolderFields.ItemCollectionConnection itemCollectionConnection;
        String id = itemDTO.getId();
        String name = itemDTO.getName();
        com.box.android.data.type.ItemType itemType2 = com.box.android.data.type.ItemType.folder;
        String createdAt = itemDTO.getCreatedAt();
        Date date2 = createdAt != null ? BoxDateFormat.parse(createdAt) : null;
        String modifiedAt = itemDTO.getModifiedAt();
        Date date3 = modifiedAt != null ? BoxDateFormat.parse(modifiedAt) : null;
        String contentCreatedAt = itemDTO.getContentCreatedAt();
        Date date4 = contentCreatedAt != null ? BoxDateFormat.parse(contentCreatedAt) : null;
        String contentModifiedAt = itemDTO.getContentModifiedAt();
        Date date5 = contentModifiedAt != null ? BoxDateFormat.parse(contentModifiedAt) : null;
        PathCollectionDTO pathCollection = itemDTO.getPathCollection();
        Boolean boolValueOf = pathCollection != null ? Boolean.valueOf(pathCollection.getIsRooted()) : null;
        UserMiniDTO ownedBy2 = itemDTO.getOwnedBy();
        if (ownedBy2 != null) {
            String id2 = ownedBy2.getId();
            String name2 = ownedBy2.getName();
            if (name2 == null) {
                name2 = "";
            }
            ownedBy = new FolderFields.OwnedBy(id2, name2);
        } else {
            ownedBy = null;
        }
        UserMiniDTO modifiedBy = itemDTO.getModifiedBy();
        if (modifiedBy != null) {
            String id3 = modifiedBy.getId();
            String name3 = modifiedBy.getName();
            updatedBy = new FolderFields.UpdatedBy(id3, name3 != null ? name3 : "");
        } else {
            updatedBy = null;
        }
        FolderMiniDTO parent = itemDTO.getParent();
        FolderFields.Parent parent2 = parent != null ? new FolderFields.Parent(parent.getId(), parent.getName()) : null;
        Long size = itemDTO.getSize();
        Boolean hasCollaborations = itemDTO.getHasCollaborations();
        Boolean boolIsExternallyOwned = itemDTO.isExternallyOwned();
        PermissionsDTO permissions = itemDTO.getPermissions();
        FolderFields.PermissionsV2Api permissionsV2Api = permissions != null ? new FolderFields.PermissionsV2Api(permissions.getCanDelete(), permissions.getCanDownload(), permissions.getCanInviteCollaborator(), permissions.getCanRename(), permissions.getCanSetShareAccess(), permissions.getCanShare(), permissions.getCanUpload()) : null;
        List<CollectionDTO> collections = itemDTO.getCollections();
        if (collections != null) {
            List<CollectionDTO> list = collections;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator it = list.iterator();
            while (it.hasNext()) {
                CollectionDTO collectionDTO = (CollectionDTO) it.next();
                arrayList.add(new FolderFields.Edge(collectionDTO.getId(), new FolderFields.Node(collectionDTO.getId(), collectionDTO.getName(), collectionDTO.getCollectionType().name())));
                it = it;
                id = id;
                name = name;
                itemType2 = itemType2;
                date3 = date3;
            }
            str = id;
            str2 = name;
            itemType = itemType2;
            date = date3;
            itemCollectionConnection = new FolderFields.ItemCollectionConnection(arrayList);
        } else {
            str = id;
            str2 = name;
            itemType = itemType2;
            date = date3;
            itemCollectionConnection = null;
        }
        return new FolderFields(str, str2, itemType, date2, date, date4, date5, boolValueOf, ownedBy, updatedBy, parent2, itemCollectionConnection, size, hasCollaborations, boolIsExternallyOwned, permissionsV2Api, SharedLinkModelToApolloSharedLinkMapper.INSTANCE.toFolderFields(SharedLinkDTOtoSharedLinkModelMapper.INSTANCE.toSharedLinkModelOrNull(itemDTO.getSharedLink())));
    }

    private final WeblinkFields getOnWeblink(WebLinkDTO itemDTO) {
        WeblinkFields.OwnedBy ownedBy;
        WeblinkFields.UpdatedBy updatedBy;
        Date date;
        String str;
        String str2;
        WeblinkFields.ItemCollectionConnection itemCollectionConnection;
        String id = itemDTO.getId();
        String name = itemDTO.getName();
        com.box.android.data.type.ItemType itemType = com.box.android.data.type.ItemType.web_link;
        String createdAt = itemDTO.getCreatedAt();
        Date date2 = createdAt != null ? BoxDateFormat.parse(createdAt) : null;
        String modifiedAt = itemDTO.getModifiedAt();
        Date date3 = modifiedAt != null ? BoxDateFormat.parse(modifiedAt) : null;
        PathCollectionDTO pathCollection = itemDTO.getPathCollection();
        Boolean boolValueOf = pathCollection != null ? Boolean.valueOf(pathCollection.getIsRooted()) : null;
        UserMiniDTO ownedBy2 = itemDTO.getOwnedBy();
        if (ownedBy2 != null) {
            String id2 = ownedBy2.getId();
            String name2 = ownedBy2.getName();
            if (name2 == null) {
                name2 = "";
            }
            ownedBy = new WeblinkFields.OwnedBy(id2, name2);
        } else {
            ownedBy = null;
        }
        UserMiniDTO modifiedBy = itemDTO.getModifiedBy();
        if (modifiedBy != null) {
            String id3 = modifiedBy.getId();
            String name3 = modifiedBy.getName();
            updatedBy = new WeblinkFields.UpdatedBy(id3, name3 != null ? name3 : "");
        } else {
            updatedBy = null;
        }
        FolderMiniDTO parent = itemDTO.getParent();
        WeblinkFields.Parent parent2 = parent != null ? new WeblinkFields.Parent(parent.getId(), parent.getName()) : null;
        String url = itemDTO.getUrl();
        PermissionsDTO permissions = itemDTO.getPermissions();
        WeblinkFields.PermissionsV2Api permissionsV2Api = permissions != null ? new WeblinkFields.PermissionsV2Api(permissions.getCanComment(), permissions.getCanDelete(), permissions.getCanRename(), permissions.getCanSetShareAccess(), permissions.getCanShare()) : null;
        List<CollectionDTO> collections = itemDTO.getCollections();
        if (collections != null) {
            List<CollectionDTO> list = collections;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            for (CollectionDTO collectionDTO : list) {
                arrayList.add(new WeblinkFields.Edge(collectionDTO.getId(), new WeblinkFields.Node(collectionDTO.getId(), collectionDTO.getName(), collectionDTO.getCollectionType().name())));
                date2 = date2;
                id = id;
                name = name;
            }
            date = date2;
            str = id;
            str2 = name;
            itemCollectionConnection = new WeblinkFields.ItemCollectionConnection(arrayList);
        } else {
            date = date2;
            str = id;
            str2 = name;
            itemCollectionConnection = null;
        }
        return new WeblinkFields(str, str2, itemType, date, date3, boolValueOf, ownedBy, updatedBy, parent2, itemCollectionConnection, url, permissionsV2Api, SharedLinkModelToApolloSharedLinkMapper.INSTANCE.toWeblinkFields(SharedLinkDTOtoSharedLinkModelMapper.INSTANCE.toSharedLinkModelOrNull(itemDTO.getSharedLink())));
    }
}
