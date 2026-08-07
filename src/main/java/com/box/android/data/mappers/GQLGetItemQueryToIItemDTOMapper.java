package com.box.android.data.mappers;

import com.box.android.data.GetItemQuery;
import com.box.android.data.api.models.ClassificationDTO;
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

/* JADX INFO: compiled from: GQLGetItemQueryToIItemDTOMapper.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0007\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u001a\u0010\n\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\f\u0010\u000b\u001a\u00020\u0003*\u00020\fH\u0002J\f\u0010\u000b\u001a\u00020\u0003*\u00020\rH\u0002J\f\u0010\u000b\u001a\u00020\u0003*\u00020\u000eH\u0002¨\u0006\u000f"}, d2 = {"Lcom/box/android/data/mappers/GQLGetItemQueryToIItemDTOMapper;", "Lcom/box/android/data/mappers/GraphQLMapper;", "Lcom/box/android/data/api/models/items/IItemDTO;", "Lcom/box/android/data/GetItemQuery$Item;", "<init>", "()V", "toGraphQL", "source", "options", "", "fromGraphQL", "toItem", "Lcom/box/android/data/api/models/items/FileDTO;", "Lcom/box/android/data/api/models/items/FolderDTO;", "Lcom/box/android/data/api/models/items/WebLinkDTO;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class GQLGetItemQueryToIItemDTOMapper implements GraphQLMapper<IItemDTO, GetItemQuery.Item> {
    public static final GQLGetItemQueryToIItemDTOMapper INSTANCE = new GQLGetItemQueryToIItemDTOMapper();

    private GQLGetItemQueryToIItemDTOMapper() {
    }

    @Override // com.box.android.data.mappers.GraphQLMapper
    public GetItemQuery.Item toGraphQL(IItemDTO source, Object options) {
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
    public IItemDTO fromGraphQL(GetItemQuery.Item source, Object options) {
        Intrinsics.checkNotNullParameter(source, "source");
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    private final GetItemQuery.Item toItem(FileDTO fileDTO) {
        GetItemQuery.UpdatedBy updatedBy;
        Date date;
        String str;
        GetItemQuery.ItemCollectionConnection itemCollectionConnection;
        GetItemQuery.FileLock fileLock;
        String gQLTypename = TypenameMapperKt.toGQLTypename(ItemType.FILE);
        String id = fileDTO.getId();
        com.box.android.data.type.ItemType itemType = com.box.android.data.type.ItemType.file;
        String name = fileDTO.getName();
        String createdAt = fileDTO.getCreatedAt();
        Date date2 = createdAt != null ? BoxDateFormat.parse(createdAt) : null;
        String modifiedAt = fileDTO.getModifiedAt();
        Date date3 = modifiedAt != null ? BoxDateFormat.parse(modifiedAt) : null;
        String contentCreatedAt = fileDTO.getContentCreatedAt();
        Date date4 = contentCreatedAt != null ? BoxDateFormat.parse(contentCreatedAt) : null;
        String contentModifiedAt = fileDTO.getContentModifiedAt();
        Date date5 = contentModifiedAt != null ? BoxDateFormat.parse(contentModifiedAt) : null;
        UserMiniDTO ownedBy = fileDTO.getOwnedBy();
        GetItemQuery.OwnedBy ownedBy2 = ownedBy != null ? new GetItemQuery.OwnedBy(ownedBy.getId(), ownedBy.getName()) : null;
        UserMiniDTO modifiedBy = fileDTO.getModifiedBy();
        if (modifiedBy != null) {
            String id2 = modifiedBy.getId();
            String name2 = modifiedBy.getName();
            if (name2 == null) {
                name2 = "";
            }
            updatedBy = new GetItemQuery.UpdatedBy(id2, name2);
        } else {
            updatedBy = null;
        }
        FolderMiniDTO parent = fileDTO.getParent();
        GetItemQuery.Parent parent2 = parent != null ? new GetItemQuery.Parent(parent.getId(), parent.getName()) : null;
        Long size = fileDTO.getSize();
        Boolean hasCollaborations = fileDTO.getHasCollaborations();
        Boolean boolIsExternallyOwned = fileDTO.isExternallyOwned();
        String sha1 = fileDTO.getSha1();
        PathCollectionDTO pathCollection = fileDTO.getPathCollection();
        boolean isRooted = pathCollection != null ? pathCollection.getIsRooted() : false;
        PermissionsDTO permissions = fileDTO.getPermissions();
        GetItemQuery.PermissionsV2Api permissionsV2Api = permissions != null ? new GetItemQuery.PermissionsV2Api(permissions.getCanComment(), permissions.getCanDelete(), permissions.getCanDownload(), permissions.getCanInviteCollaborator(), permissions.getCanPreview(), permissions.getCanRename(), permissions.getCanSetShareAccess(), permissions.getCanShare(), permissions.getCanUpload(), permissions.getCanViewAnnotations(), permissions.getCanCreateAnnotations()) : null;
        FileVersionMiniDTO fileVersion = fileDTO.getFileVersion();
        GetItemQuery.FileVersion fileVersion2 = fileVersion != null ? new GetItemQuery.FileVersion(fileVersion.getId(), fileVersion.getSha1()) : null;
        List<CollectionDTO> collections = fileDTO.getCollections();
        if (collections != null) {
            List<CollectionDTO> list = collections;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            for (CollectionDTO collectionDTO : list) {
                arrayList.add(new GetItemQuery.Edge(collectionDTO.getId(), new GetItemQuery.Node(collectionDTO.getId(), collectionDTO.getName(), collectionDTO.getCollectionType().name())));
                date2 = date2;
                id = id;
            }
            date = date2;
            str = id;
            itemCollectionConnection = new GetItemQuery.ItemCollectionConnection(arrayList);
        } else {
            date = date2;
            str = id;
            itemCollectionConnection = null;
        }
        FileLockDTO fileLock2 = fileDTO.getFileLock();
        if (fileLock2 != null) {
            String id3 = fileLock2.getId();
            String appType = fileLock2.getAppType();
            String createdAt2 = fileLock2.getCreatedAt();
            Date date6 = createdAt2 != null ? BoxDateFormat.parse(createdAt2) : null;
            UserMiniDTO createdBy = fileLock2.getCreatedBy();
            GetItemQuery.CreatedBy createdBy2 = createdBy != null ? new GetItemQuery.CreatedBy(createdBy.getId(), createdBy.getName(), createdBy.getLogin()) : null;
            String expiresAt = fileLock2.getExpiresAt();
            fileLock = new GetItemQuery.FileLock(id3, appType, date6, createdBy2, expiresAt != null ? BoxDateFormat.parse(expiresAt) : null, fileLock2.isDownloadPrevented());
        } else {
            fileLock = null;
        }
        Long commentCount = fileDTO.getCommentCount();
        Integer numValueOf = commentCount != null ? Integer.valueOf((int) commentCount.longValue()) : null;
        Long annotationCount = fileDTO.getAnnotationCount();
        Integer numValueOf2 = annotationCount != null ? Integer.valueOf((int) annotationCount.longValue()) : null;
        boolean z = isRooted;
        String description = fileDTO.getDescription();
        ClassificationDTO classification = fileDTO.getClassification();
        GetItemQuery.Classification classification2 = classification != null ? new GetItemQuery.Classification(classification.getName(), classification.getColor(), classification.getDefinition()) : null;
        GetItemQuery.SharedLink getItemQueryFile = SharedLinkModelToApolloSharedLinkMapper.INSTANCE.toGetItemQueryFile(SharedLinkDTOtoSharedLinkModelMapper.INSTANCE.toSharedLinkModelOrNull(fileDTO.getSharedLink()));
        WatermarkDTO watermark = fileDTO.getWatermark();
        return new GetItemQuery.Item(gQLTypename, new GetItemQuery.OnFile(str, itemType, name, date, date3, description, date4, date5, Boolean.valueOf(z), numValueOf, numValueOf2, itemCollectionConnection, classification2, size, hasCollaborations, boolIsExternallyOwned, sha1, watermark != null ? new GetItemQuery.Watermark(Boolean.valueOf(watermark.isWatermarked())) : null, ownedBy2, updatedBy, parent2, permissionsV2Api, fileVersion2, fileLock, getItemQueryFile), null, null);
    }

    private final GetItemQuery.Item toItem(FolderDTO folderDTO) {
        GetItemQuery.UpdatedBy1 updatedBy1;
        Date date;
        String str;
        com.box.android.data.type.ItemType itemType;
        String str2;
        GetItemQuery.ItemCollectionConnection1 itemCollectionConnection1;
        String gQLTypename = TypenameMapperKt.toGQLTypename(ItemType.FOLDER);
        String id = folderDTO.getId();
        com.box.android.data.type.ItemType itemType2 = com.box.android.data.type.ItemType.folder;
        String name = folderDTO.getName();
        String createdAt = folderDTO.getCreatedAt();
        Date date2 = createdAt != null ? BoxDateFormat.parse(createdAt) : null;
        String modifiedAt = folderDTO.getModifiedAt();
        Date date3 = modifiedAt != null ? BoxDateFormat.parse(modifiedAt) : null;
        String contentCreatedAt = folderDTO.getContentCreatedAt();
        Date date4 = contentCreatedAt != null ? BoxDateFormat.parse(contentCreatedAt) : null;
        String contentModifiedAt = folderDTO.getContentModifiedAt();
        Date date5 = contentModifiedAt != null ? BoxDateFormat.parse(contentModifiedAt) : null;
        UserMiniDTO ownedBy = folderDTO.getOwnedBy();
        GetItemQuery.OwnedBy1 ownedBy1 = ownedBy != null ? new GetItemQuery.OwnedBy1(ownedBy.getId(), ownedBy.getName()) : null;
        UserMiniDTO modifiedBy = folderDTO.getModifiedBy();
        if (modifiedBy != null) {
            String id2 = modifiedBy.getId();
            String name2 = modifiedBy.getName();
            if (name2 == null) {
                name2 = "";
            }
            updatedBy1 = new GetItemQuery.UpdatedBy1(id2, name2);
        } else {
            updatedBy1 = null;
        }
        FolderMiniDTO parent = folderDTO.getParent();
        GetItemQuery.Parent1 parent1 = parent != null ? new GetItemQuery.Parent1(parent.getId(), parent.getName()) : null;
        Long size = folderDTO.getSize();
        Boolean hasCollaborations = folderDTO.getHasCollaborations();
        Boolean boolIsExternallyOwned = folderDTO.isExternallyOwned();
        PathCollectionDTO pathCollection = folderDTO.getPathCollection();
        boolean isRooted = pathCollection != null ? pathCollection.getIsRooted() : false;
        PermissionsDTO permissions = folderDTO.getPermissions();
        GetItemQuery.PermissionsV2Api1 permissionsV2Api1 = permissions != null ? new GetItemQuery.PermissionsV2Api1(permissions.getCanDelete(), permissions.getCanDownload(), permissions.getCanInviteCollaborator(), permissions.getCanRename(), permissions.getCanSetShareAccess(), permissions.getCanShare(), permissions.getCanUpload(), permissions.getCanPreview(), permissions.getCanComment(), permissions.getCanViewAnnotations(), permissions.getCanCreateAnnotations()) : null;
        List<CollectionDTO> collections = folderDTO.getCollections();
        if (collections != null) {
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(collections, 10));
            for (Iterator it = r10.iterator(); it.hasNext(); it = it) {
                CollectionDTO collectionDTO = (CollectionDTO) it.next();
                arrayList.add(new GetItemQuery.Edge1(collectionDTO.getId(), new GetItemQuery.Node1(collectionDTO.getId(), collectionDTO.getName(), collectionDTO.getCollectionType().name())));
                date2 = date2;
                id = id;
                itemType2 = itemType2;
                name = name;
            }
            date = date2;
            str = id;
            itemType = itemType2;
            str2 = name;
            itemCollectionConnection1 = new GetItemQuery.ItemCollectionConnection1(arrayList);
        } else {
            date = date2;
            str = id;
            itemType = itemType2;
            str2 = name;
            itemCollectionConnection1 = null;
        }
        return new GetItemQuery.Item(gQLTypename, null, new GetItemQuery.OnFolder(str, itemType, str2, date, folderDTO.getDescription(), date3, date4, date5, Boolean.valueOf(isRooted), itemCollectionConnection1, size, hasCollaborations, boolIsExternallyOwned, ownedBy1, updatedBy1, parent1, permissionsV2Api1, SharedLinkModelToApolloSharedLinkMapper.INSTANCE.toGetItemQueryFolder(SharedLinkDTOtoSharedLinkModelMapper.INSTANCE.toSharedLinkModelOrNull(folderDTO.getSharedLink()))), null);
    }

    private final GetItemQuery.Item toItem(WebLinkDTO webLinkDTO) {
        GetItemQuery.UpdatedBy2 updatedBy2;
        GetItemQuery.PermissionsV2Api2 permissionsV2Api2;
        Date date;
        String str;
        com.box.android.data.type.ItemType itemType;
        String str2;
        GetItemQuery.ItemCollectionConnection2 itemCollectionConnection2;
        String gQLTypename = TypenameMapperKt.toGQLTypename(ItemType.WEBLINK);
        String id = webLinkDTO.getId();
        com.box.android.data.type.ItemType itemType2 = com.box.android.data.type.ItemType.web_link;
        String name = webLinkDTO.getName();
        String createdAt = webLinkDTO.getCreatedAt();
        Date date2 = createdAt != null ? BoxDateFormat.parse(createdAt) : null;
        String modifiedAt = webLinkDTO.getModifiedAt();
        Date date3 = modifiedAt != null ? BoxDateFormat.parse(modifiedAt) : null;
        UserMiniDTO ownedBy = webLinkDTO.getOwnedBy();
        GetItemQuery.OwnedBy2 ownedBy2 = ownedBy != null ? new GetItemQuery.OwnedBy2(ownedBy.getId(), ownedBy.getName()) : null;
        UserMiniDTO modifiedBy = webLinkDTO.getModifiedBy();
        if (modifiedBy != null) {
            String id2 = modifiedBy.getId();
            String name2 = modifiedBy.getName();
            if (name2 == null) {
                name2 = "";
            }
            updatedBy2 = new GetItemQuery.UpdatedBy2(id2, name2);
        } else {
            updatedBy2 = null;
        }
        PathCollectionDTO pathCollection = webLinkDTO.getPathCollection();
        boolean isRooted = pathCollection != null ? pathCollection.getIsRooted() : false;
        FolderMiniDTO parent = webLinkDTO.getParent();
        GetItemQuery.Parent2 parent2 = parent != null ? new GetItemQuery.Parent2(parent.getId(), parent.getName()) : null;
        PermissionsDTO permissions = webLinkDTO.getPermissions();
        if (permissions != null) {
            Boolean canComment = permissions.getCanComment();
            Boolean canDelete = permissions.getCanDelete();
            Boolean canRename = permissions.getCanRename();
            Boolean canSetShareAccess = permissions.getCanSetShareAccess();
            Boolean canShare = permissions.getCanShare();
            Boolean canCreateAnnotations = permissions.getCanCreateAnnotations();
            permissionsV2Api2 = new GetItemQuery.PermissionsV2Api2(permissions.getCanInviteCollaborator(), canSetShareAccess, permissions.getCanDownload(), permissions.getCanPreview(), canComment, permissions.getCanUpload(), canRename, canDelete, canShare, permissions.getCanViewAnnotations(), canCreateAnnotations);
        } else {
            permissionsV2Api2 = null;
        }
        String url = webLinkDTO.getUrl();
        List<CollectionDTO> collections = webLinkDTO.getCollections();
        if (collections != null) {
            List<CollectionDTO> list = collections;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            for (CollectionDTO collectionDTO : list) {
                arrayList.add(new GetItemQuery.Edge2(collectionDTO.getId(), new GetItemQuery.Node2(collectionDTO.getId(), collectionDTO.getName(), collectionDTO.getCollectionType().name())));
                date2 = date2;
                id = id;
                itemType2 = itemType2;
                name = name;
            }
            date = date2;
            str = id;
            itemType = itemType2;
            str2 = name;
            itemCollectionConnection2 = new GetItemQuery.ItemCollectionConnection2(arrayList);
        } else {
            date = date2;
            str = id;
            itemType = itemType2;
            str2 = name;
            itemCollectionConnection2 = null;
        }
        return new GetItemQuery.Item(gQLTypename, null, null, new GetItemQuery.OnWeblink(str, itemType, str2, date, webLinkDTO.getDescription(), date3, Boolean.valueOf(isRooted), itemCollectionConnection2, url, ownedBy2, updatedBy2, parent2, permissionsV2Api2, SharedLinkModelToApolloSharedLinkMapper.INSTANCE.toGetItemQueryWeblink(SharedLinkDTOtoSharedLinkModelMapper.INSTANCE.toSharedLinkModelOrNull(webLinkDTO.getSharedLink()))));
    }
}
