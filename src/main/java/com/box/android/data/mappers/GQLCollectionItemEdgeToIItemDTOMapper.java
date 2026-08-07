package com.box.android.data.mappers;

import com.box.android.data.GetCollectionItemsQuery;
import com.box.android.data.api.models.PermissionsDTO;
import com.box.android.data.api.models.UserMiniDTO;
import com.box.android.data.api.models.WatermarkDTO;
import com.box.android.data.api.models.items.FileDTO;
import com.box.android.data.api.models.items.FolderDTO;
import com.box.android.data.api.models.items.IItemDTO;
import com.box.android.data.api.models.items.WebLinkDTO;
import com.box.android.data.api.models.items.mini.FolderMiniDTO;
import com.box.android.data.datasource.gql.cache.GQLEdgeHelper;
import com.box.android.domain.models.item.ItemType;
import com.box.androidsdk.content.utils.BoxDateFormat;
import java.text.ParseException;
import java.util.Date;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GQLCollectionItemEdgeToIItemDTOMapper.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0007\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u001a\u0010\n\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u0002H\u0002J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\u0010H\u0002J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u0013H\u0002J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\r\u001a\u00020\u0016H\u0002¨\u0006\u0017"}, d2 = {"Lcom/box/android/data/mappers/GQLCollectionItemEdgeToIItemDTOMapper;", "Lcom/box/android/data/mappers/GraphQLMapper;", "Lcom/box/android/data/api/models/items/IItemDTO;", "Lcom/box/android/data/GetCollectionItemsQuery$Edge;", "<init>", "()V", "toGraphQL", "source", "options", "", "fromGraphQL", "getNode", "Lcom/box/android/data/GetCollectionItemsQuery$Node;", "itemDTO", "getOnFile", "Lcom/box/android/data/GetCollectionItemsQuery$OnFile;", "Lcom/box/android/data/api/models/items/FileDTO;", "getOnFolder", "Lcom/box/android/data/GetCollectionItemsQuery$OnFolder;", "Lcom/box/android/data/api/models/items/FolderDTO;", "getOnWeblink", "Lcom/box/android/data/GetCollectionItemsQuery$OnWeblink;", "Lcom/box/android/data/api/models/items/WebLinkDTO;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class GQLCollectionItemEdgeToIItemDTOMapper implements GraphQLMapper<IItemDTO, GetCollectionItemsQuery.Edge> {
    public static final GQLCollectionItemEdgeToIItemDTOMapper INSTANCE = new GQLCollectionItemEdgeToIItemDTOMapper();

    private GQLCollectionItemEdgeToIItemDTOMapper() {
    }

    @Override // com.box.android.data.mappers.GraphQLMapper
    public GetCollectionItemsQuery.Edge toGraphQL(IItemDTO source, Object options) {
        GetCollectionItemsQuery.Node node;
        Intrinsics.checkNotNullParameter(source, "source");
        if (!(options instanceof String) || (node = getNode(source)) == null) {
            return null;
        }
        return new GetCollectionItemsQuery.Edge(GQLEdgeHelper.INSTANCE.constructEdgeId(source), node);
    }

    @Override // com.box.android.data.mappers.GraphQLMapper
    public IItemDTO fromGraphQL(GetCollectionItemsQuery.Edge source, Object options) {
        Intrinsics.checkNotNullParameter(source, "source");
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    private final GetCollectionItemsQuery.Node getNode(IItemDTO itemDTO) throws ParseException {
        if (itemDTO instanceof FileDTO) {
            return new GetCollectionItemsQuery.Node(TypenameMapperKt.toGQLTypename(ItemType.FILE), getOnFile((FileDTO) itemDTO), null, null);
        }
        if (itemDTO instanceof FolderDTO) {
            return new GetCollectionItemsQuery.Node(TypenameMapperKt.toGQLTypename(ItemType.FOLDER), null, getOnFolder((FolderDTO) itemDTO), null);
        }
        if (!(itemDTO instanceof WebLinkDTO)) {
            return null;
        }
        return new GetCollectionItemsQuery.Node(TypenameMapperKt.toGQLTypename(ItemType.WEBLINK), null, null, getOnWeblink((WebLinkDTO) itemDTO));
    }

    private final GetCollectionItemsQuery.OnFile getOnFile(FileDTO itemDTO) {
        GetCollectionItemsQuery.UpdatedBy updatedBy;
        String id = itemDTO.getId();
        String name = itemDTO.getName();
        com.box.android.data.type.ItemType itemType = com.box.android.data.type.ItemType.file;
        Long size = itemDTO.getSize();
        String createdAt = itemDTO.getCreatedAt();
        Date date = createdAt != null ? BoxDateFormat.parse(createdAt) : null;
        String modifiedAt = itemDTO.getModifiedAt();
        Date date2 = modifiedAt != null ? BoxDateFormat.parse(modifiedAt) : null;
        String contentCreatedAt = itemDTO.getContentCreatedAt();
        Date date3 = contentCreatedAt != null ? BoxDateFormat.parse(contentCreatedAt) : null;
        String contentModifiedAt = itemDTO.getContentModifiedAt();
        Date date4 = contentModifiedAt != null ? BoxDateFormat.parse(contentModifiedAt) : null;
        UserMiniDTO ownedBy = itemDTO.getOwnedBy();
        GetCollectionItemsQuery.OwnedBy ownedBy2 = ownedBy != null ? new GetCollectionItemsQuery.OwnedBy(ownedBy.getId()) : null;
        UserMiniDTO modifiedBy = itemDTO.getModifiedBy();
        if (modifiedBy != null) {
            String id2 = modifiedBy.getId();
            String name2 = modifiedBy.getName();
            if (name2 == null) {
                name2 = "";
            }
            updatedBy = new GetCollectionItemsQuery.UpdatedBy(id2, name2);
        } else {
            updatedBy = null;
        }
        Boolean hasCollaborations = itemDTO.getHasCollaborations();
        Boolean boolIsExternallyOwned = itemDTO.isExternallyOwned();
        FolderMiniDTO parent = itemDTO.getParent();
        GetCollectionItemsQuery.Parent parent2 = parent != null ? new GetCollectionItemsQuery.Parent(parent.getId(), parent.getName()) : null;
        String sha1 = itemDTO.getSha1();
        WatermarkDTO watermark = itemDTO.getWatermark();
        GetCollectionItemsQuery.Watermark watermark2 = watermark != null ? new GetCollectionItemsQuery.Watermark(Boolean.valueOf(watermark.isWatermarked())) : null;
        PermissionsDTO permissions = itemDTO.getPermissions();
        Boolean canInviteCollaborator = permissions != null ? permissions.getCanInviteCollaborator() : null;
        PermissionsDTO permissions2 = itemDTO.getPermissions();
        Boolean canComment = permissions2 != null ? permissions2.getCanComment() : null;
        PermissionsDTO permissions3 = itemDTO.getPermissions();
        Boolean canCreateAnnotations = permissions3 != null ? permissions3.getCanCreateAnnotations() : null;
        PermissionsDTO permissions4 = itemDTO.getPermissions();
        Boolean canDelete = permissions4 != null ? permissions4.getCanDelete() : null;
        PermissionsDTO permissions5 = itemDTO.getPermissions();
        Boolean canDownload = permissions5 != null ? permissions5.getCanDownload() : null;
        PermissionsDTO permissions6 = itemDTO.getPermissions();
        Boolean canPreview = permissions6 != null ? permissions6.getCanPreview() : null;
        PermissionsDTO permissions7 = itemDTO.getPermissions();
        Boolean canRename = permissions7 != null ? permissions7.getCanRename() : null;
        PermissionsDTO permissions8 = itemDTO.getPermissions();
        Boolean canSetShareAccess = permissions8 != null ? permissions8.getCanSetShareAccess() : null;
        PermissionsDTO permissions9 = itemDTO.getPermissions();
        Boolean canShare = permissions9 != null ? permissions9.getCanShare() : null;
        PermissionsDTO permissions10 = itemDTO.getPermissions();
        Boolean canUpload = permissions10 != null ? permissions10.getCanUpload() : null;
        PermissionsDTO permissions11 = itemDTO.getPermissions();
        return new GetCollectionItemsQuery.OnFile(id, itemType, name, size, date, date2, date3, date4, ownedBy2, updatedBy, hasCollaborations, boolIsExternallyOwned, sha1, watermark2, parent2, new GetCollectionItemsQuery.PermissionsV2Api(canInviteCollaborator, canSetShareAccess, canDownload, canPreview, canComment, canUpload, canRename, canDelete, canShare, permissions11 != null ? permissions11.getCanViewAnnotations() : null, canCreateAnnotations), SharedLinkModelToApolloSharedLinkMapper.INSTANCE.toGetCollectionItemsFile(SharedLinkDTOtoSharedLinkModelMapper.INSTANCE.toSharedLinkModelOrNull(itemDTO.getSharedLink())));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final GetCollectionItemsQuery.OnFolder getOnFolder(FolderDTO itemDTO) throws ParseException {
        Boolean canViewAnnotations;
        Date date;
        GetCollectionItemsQuery.UpdatedBy1 updatedBy1;
        String id = itemDTO.getId();
        String name = itemDTO.getName();
        com.box.android.data.type.ItemType itemType = com.box.android.data.type.ItemType.folder;
        String createdAt = itemDTO.getCreatedAt();
        Date date2 = createdAt != null ? BoxDateFormat.parse(createdAt) : null;
        String modifiedAt = itemDTO.getModifiedAt();
        Date date3 = modifiedAt != null ? BoxDateFormat.parse(modifiedAt) : null;
        String contentCreatedAt = itemDTO.getContentCreatedAt();
        Date date4 = contentCreatedAt != null ? BoxDateFormat.parse(contentCreatedAt) : null;
        String contentModifiedAt = itemDTO.getContentModifiedAt();
        if (contentModifiedAt != null) {
            date = BoxDateFormat.parse(contentModifiedAt);
            canViewAnnotations = null;
        } else {
            canViewAnnotations = null;
            date = null;
        }
        Long size = itemDTO.getSize();
        UserMiniDTO ownedBy = itemDTO.getOwnedBy();
        GetCollectionItemsQuery.OwnedBy1 ownedBy1 = ownedBy != null ? new GetCollectionItemsQuery.OwnedBy1(ownedBy.getId()) : canViewAnnotations;
        UserMiniDTO modifiedBy = itemDTO.getModifiedBy();
        if (modifiedBy != null) {
            String id2 = modifiedBy.getId();
            String name2 = modifiedBy.getName();
            if (name2 == null) {
                name2 = "";
            }
            updatedBy1 = new GetCollectionItemsQuery.UpdatedBy1(id2, name2);
        } else {
            updatedBy1 = canViewAnnotations;
        }
        Boolean hasCollaborations = itemDTO.getHasCollaborations();
        Boolean boolIsExternallyOwned = itemDTO.isExternallyOwned();
        FolderMiniDTO parent = itemDTO.getParent();
        GetCollectionItemsQuery.Parent1 parent1 = parent != null ? new GetCollectionItemsQuery.Parent1(parent.getId(), parent.getName()) : canViewAnnotations;
        PermissionsDTO permissions = itemDTO.getPermissions();
        Boolean canInviteCollaborator = permissions != null ? permissions.getCanInviteCollaborator() : canViewAnnotations;
        PermissionsDTO permissions2 = itemDTO.getPermissions();
        Boolean canComment = permissions2 != null ? permissions2.getCanComment() : canViewAnnotations;
        PermissionsDTO permissions3 = itemDTO.getPermissions();
        Boolean canCreateAnnotations = permissions3 != null ? permissions3.getCanCreateAnnotations() : canViewAnnotations;
        PermissionsDTO permissions4 = itemDTO.getPermissions();
        Boolean canDelete = permissions4 != null ? permissions4.getCanDelete() : canViewAnnotations;
        PermissionsDTO permissions5 = itemDTO.getPermissions();
        Boolean canDownload = permissions5 != null ? permissions5.getCanDownload() : canViewAnnotations;
        PermissionsDTO permissions6 = itemDTO.getPermissions();
        Boolean canPreview = permissions6 != null ? permissions6.getCanPreview() : canViewAnnotations;
        PermissionsDTO permissions7 = itemDTO.getPermissions();
        Boolean canRename = permissions7 != null ? permissions7.getCanRename() : canViewAnnotations;
        PermissionsDTO permissions8 = itemDTO.getPermissions();
        Boolean canSetShareAccess = permissions8 != null ? permissions8.getCanSetShareAccess() : canViewAnnotations;
        PermissionsDTO permissions9 = itemDTO.getPermissions();
        Boolean canShare = permissions9 != null ? permissions9.getCanShare() : canViewAnnotations;
        PermissionsDTO permissions10 = itemDTO.getPermissions();
        Boolean canUpload = permissions10 != null ? permissions10.getCanUpload() : canViewAnnotations;
        PermissionsDTO permissions11 = itemDTO.getPermissions();
        if (permissions11 != null) {
            canViewAnnotations = permissions11.getCanViewAnnotations();
        }
        return new GetCollectionItemsQuery.OnFolder(id, itemType, name, size, date2, date3, date4, date, ownedBy1, updatedBy1, hasCollaborations, boolIsExternallyOwned, parent1, new GetCollectionItemsQuery.PermissionsV2Api1(canInviteCollaborator, canSetShareAccess, canDownload, canPreview, canComment, canUpload, canRename, canDelete, canShare, canViewAnnotations, canCreateAnnotations), SharedLinkModelToApolloSharedLinkMapper.INSTANCE.toGetCollectionItemsFolder(SharedLinkDTOtoSharedLinkModelMapper.INSTANCE.toSharedLinkModelOrNull(itemDTO.getSharedLink())));
    }

    private final GetCollectionItemsQuery.OnWeblink getOnWeblink(WebLinkDTO itemDTO) {
        GetCollectionItemsQuery.UpdatedBy2 updatedBy2;
        String id = itemDTO.getId();
        String name = itemDTO.getName();
        com.box.android.data.type.ItemType itemType = com.box.android.data.type.ItemType.web_link;
        String createdAt = itemDTO.getCreatedAt();
        Date date = createdAt != null ? BoxDateFormat.parse(createdAt) : null;
        String modifiedAt = itemDTO.getModifiedAt();
        Date date2 = modifiedAt != null ? BoxDateFormat.parse(modifiedAt) : null;
        String contentCreatedAt = itemDTO.getContentCreatedAt();
        Date date3 = contentCreatedAt != null ? BoxDateFormat.parse(contentCreatedAt) : null;
        String contentModifiedAt = itemDTO.getContentModifiedAt();
        Date date4 = contentModifiedAt != null ? BoxDateFormat.parse(contentModifiedAt) : null;
        UserMiniDTO ownedBy = itemDTO.getOwnedBy();
        GetCollectionItemsQuery.OwnedBy2 ownedBy2 = ownedBy != null ? new GetCollectionItemsQuery.OwnedBy2(ownedBy.getId()) : null;
        UserMiniDTO modifiedBy = itemDTO.getModifiedBy();
        if (modifiedBy != null) {
            String id2 = modifiedBy.getId();
            String name2 = modifiedBy.getName();
            if (name2 == null) {
                name2 = "";
            }
            updatedBy2 = new GetCollectionItemsQuery.UpdatedBy2(id2, name2);
        } else {
            updatedBy2 = null;
        }
        FolderMiniDTO parent = itemDTO.getParent();
        GetCollectionItemsQuery.Parent2 parent2 = parent != null ? new GetCollectionItemsQuery.Parent2(parent.getId(), parent.getName()) : null;
        String url = itemDTO.getUrl();
        PermissionsDTO permissions = itemDTO.getPermissions();
        Boolean canInviteCollaborator = permissions != null ? permissions.getCanInviteCollaborator() : null;
        PermissionsDTO permissions2 = itemDTO.getPermissions();
        Boolean canComment = permissions2 != null ? permissions2.getCanComment() : null;
        PermissionsDTO permissions3 = itemDTO.getPermissions();
        Boolean canCreateAnnotations = permissions3 != null ? permissions3.getCanCreateAnnotations() : null;
        PermissionsDTO permissions4 = itemDTO.getPermissions();
        Boolean canDelete = permissions4 != null ? permissions4.getCanDelete() : null;
        PermissionsDTO permissions5 = itemDTO.getPermissions();
        Boolean canDownload = permissions5 != null ? permissions5.getCanDownload() : null;
        PermissionsDTO permissions6 = itemDTO.getPermissions();
        Boolean canPreview = permissions6 != null ? permissions6.getCanPreview() : null;
        PermissionsDTO permissions7 = itemDTO.getPermissions();
        Boolean canRename = permissions7 != null ? permissions7.getCanRename() : null;
        PermissionsDTO permissions8 = itemDTO.getPermissions();
        Boolean canSetShareAccess = permissions8 != null ? permissions8.getCanSetShareAccess() : null;
        PermissionsDTO permissions9 = itemDTO.getPermissions();
        Boolean canShare = permissions9 != null ? permissions9.getCanShare() : null;
        PermissionsDTO permissions10 = itemDTO.getPermissions();
        Boolean canUpload = permissions10 != null ? permissions10.getCanUpload() : null;
        PermissionsDTO permissions11 = itemDTO.getPermissions();
        return new GetCollectionItemsQuery.OnWeblink(id, itemType, name, date, date2, date3, date4, ownedBy2, updatedBy2, url, parent2, new GetCollectionItemsQuery.PermissionsV2Api2(canInviteCollaborator, canSetShareAccess, canDownload, canPreview, canComment, canUpload, canRename, canDelete, canShare, permissions11 != null ? permissions11.getCanViewAnnotations() : null, canCreateAnnotations), SharedLinkModelToApolloSharedLinkMapper.INSTANCE.toGetCollectionItemsWeblink(SharedLinkDTOtoSharedLinkModelMapper.INSTANCE.toSharedLinkModelOrNull(itemDTO.getSharedLink())));
    }
}
