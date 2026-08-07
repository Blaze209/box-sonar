package com.box.android.data.mappers;

import com.box.android.data.GetCollectionItemsQuery;
import com.box.android.data.type.ItemType;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.models.item.FolderModel;
import com.box.android.domain.models.item.ItemModelKt;
import com.box.android.domain.models.item.PermissionsModel;
import com.box.android.domain.models.item.UserModel;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GQLGetCollectionItemsQueryOnFolderToFolderModelMapper.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u001a\u0010\n\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\u000b"}, d2 = {"Lcom/box/android/data/mappers/GQLGetCollectionItemsQueryOnFolderToFolderModelMapper;", "Lcom/box/android/data/mappers/GraphQLMapper;", "Lcom/box/android/domain/models/item/FolderModel;", "Lcom/box/android/data/GetCollectionItemsQuery$OnFolder;", "<init>", "()V", "toGraphQL", "source", "options", "", "fromGraphQL", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class GQLGetCollectionItemsQueryOnFolderToFolderModelMapper implements GraphQLMapper<FolderModel, GetCollectionItemsQuery.OnFolder> {
    public static final GQLGetCollectionItemsQueryOnFolderToFolderModelMapper INSTANCE = new GQLGetCollectionItemsQueryOnFolderToFolderModelMapper();

    private GQLGetCollectionItemsQueryOnFolderToFolderModelMapper() {
    }

    @Override // com.box.android.data.mappers.GraphQLMapper
    public GetCollectionItemsQuery.OnFolder toGraphQL(FolderModel source, Object options) {
        GetCollectionItemsQuery.UpdatedBy1 updatedBy1;
        String id;
        Intrinsics.checkNotNullParameter(source, "source");
        String boxId = ItemModelKt.toItemIdRemoteId(source).getBoxId();
        ItemType itemType = ItemType.folder;
        String name = source.getName();
        Long size = source.getSize();
        Date createdDate = source.getCreatedDate();
        Date modifiedDate = source.getModifiedDate();
        Date contentCreatedDate = source.getContentCreatedDate();
        Date contentModifiedDate = source.getContentModifiedDate();
        UserModel owner = source.getOwner();
        GetCollectionItemsQuery.OwnedBy1 ownedBy1 = (owner == null || (id = owner.getId()) == null) ? null : new GetCollectionItemsQuery.OwnedBy1(id);
        UserModel updatedBy = source.getUpdatedBy();
        if (updatedBy != null) {
            String id2 = updatedBy.getId();
            String name2 = updatedBy.getName();
            if (name2 == null) {
                name2 = "";
            }
            updatedBy1 = new GetCollectionItemsQuery.UpdatedBy1(id2, name2);
        } else {
            updatedBy1 = null;
        }
        Boolean boolValueOf = Boolean.valueOf(source.getHasCollaborations());
        Boolean boolValueOf2 = Boolean.valueOf(source.isExternallyOwned());
        FolderModel parentFolder = source.getParentFolder();
        GetCollectionItemsQuery.Parent1 parent1 = parentFolder != null ? new GetCollectionItemsQuery.Parent1(ItemModelKt.toItemIdRemoteId(parentFolder).getBoxId(), parentFolder.getName()) : null;
        PermissionsModel permissions = source.getPermissions();
        Boolean boolValueOf3 = permissions != null ? Boolean.valueOf(permissions.getCanInviteCollaborators()) : null;
        PermissionsModel permissions2 = source.getPermissions();
        Boolean boolValueOf4 = permissions2 != null ? Boolean.valueOf(permissions2.getCanComment()) : null;
        PermissionsModel permissions3 = source.getPermissions();
        Boolean boolValueOf5 = permissions3 != null ? Boolean.valueOf(permissions3.getCanCreateAnnotations()) : null;
        PermissionsModel permissions4 = source.getPermissions();
        Boolean boolValueOf6 = permissions4 != null ? Boolean.valueOf(permissions4.getCanDelete()) : null;
        PermissionsModel permissions5 = source.getPermissions();
        Boolean boolValueOf7 = permissions5 != null ? Boolean.valueOf(permissions5.getCanDownload()) : null;
        PermissionsModel permissions6 = source.getPermissions();
        Boolean boolValueOf8 = permissions6 != null ? Boolean.valueOf(permissions6.getCanPreview()) : null;
        PermissionsModel permissions7 = source.getPermissions();
        Boolean boolValueOf9 = permissions7 != null ? Boolean.valueOf(permissions7.getCanRename()) : null;
        PermissionsModel permissions8 = source.getPermissions();
        Boolean boolValueOf10 = permissions8 != null ? Boolean.valueOf(permissions8.getCanSetShareAccess()) : null;
        PermissionsModel permissions9 = source.getPermissions();
        Boolean boolValueOf11 = permissions9 != null ? Boolean.valueOf(permissions9.getCanShare()) : null;
        PermissionsModel permissions10 = source.getPermissions();
        Boolean boolValueOf12 = permissions10 != null ? Boolean.valueOf(permissions10.getCanUpload()) : null;
        PermissionsModel permissions11 = source.getPermissions();
        return new GetCollectionItemsQuery.OnFolder(boxId, itemType, name, size, createdDate, modifiedDate, contentCreatedDate, contentModifiedDate, ownedBy1, updatedBy1, boolValueOf, boolValueOf2, parent1, new GetCollectionItemsQuery.PermissionsV2Api1(boolValueOf3, boolValueOf10, boolValueOf7, boolValueOf8, boolValueOf4, boolValueOf12, boolValueOf9, boolValueOf6, boolValueOf11, permissions11 != null ? Boolean.valueOf(permissions11.getCanViewAnnotations()) : null, boolValueOf5), SharedLinkModelToApolloSharedLinkMapper.INSTANCE.toGetCollectionItemsFolder(source.getSharedLink()));
    }

    @Override // com.box.android.data.mappers.GraphQLMapper
    public FolderModel fromGraphQL(GetCollectionItemsQuery.OnFolder source, Object options) {
        UserModel userModel;
        FolderModel folderModel;
        Boolean canViewAnnotations;
        Boolean canUpload;
        Boolean canShare;
        Boolean canSetShareAccess;
        Boolean canRename;
        Boolean canPreview;
        Boolean canDownload;
        Boolean canDelete;
        Boolean canCreateAnnotations;
        Boolean canComment;
        Boolean canInviteCollaborator;
        long jLongValue;
        String id;
        Intrinsics.checkNotNullParameter(source, "source");
        ItemId itemIdCreateItemId = FolderModel.INSTANCE.createItemId(source.getId());
        String name = source.getName();
        String str = name == null ? "" : name;
        Boolean hasCollaborations = source.getHasCollaborations();
        boolean zBooleanValue = hasCollaborations != null ? hasCollaborations.booleanValue() : false;
        Boolean boolIsExternallyOwned = source.isExternallyOwned();
        boolean zBooleanValue2 = boolIsExternallyOwned != null ? boolIsExternallyOwned.booleanValue() : false;
        GetCollectionItemsQuery.OwnedBy1 ownedBy = source.getOwnedBy();
        UserModel userModel2 = (ownedBy == null || (id = ownedBy.getId()) == null) ? null : new UserModel(id, null, null, null, null, null, null, null, null);
        GetCollectionItemsQuery.UpdatedBy1 updatedBy = source.getUpdatedBy();
        UserModel userModel3 = updatedBy != null ? new UserModel(updatedBy.getId(), updatedBy.getName(), null, null, null, null, null, null, null) : null;
        Date createdAt = source.getCreatedAt();
        Date updatedAt = source.getUpdatedAt();
        Date contentCreatedAt = source.getContentCreatedAt();
        Date contentUpdatedAt = source.getContentUpdatedAt();
        Object size = source.getSize();
        long j = 0;
        if (size != null) {
            if (size instanceof Integer) {
                userModel = userModel2;
                jLongValue = ((Number) size).intValue();
            } else {
                userModel = userModel2;
                if (size instanceof Long) {
                    jLongValue = ((Number) size).longValue();
                }
            }
            j = jLongValue;
        } else {
            userModel = userModel2;
        }
        GetCollectionItemsQuery.PermissionsV2Api1 permissionsV2Api = source.getPermissionsV2Api();
        boolean zBooleanValue3 = (permissionsV2Api == null || (canInviteCollaborator = permissionsV2Api.getCanInviteCollaborator()) == null) ? false : canInviteCollaborator.booleanValue();
        GetCollectionItemsQuery.PermissionsV2Api1 permissionsV2Api2 = source.getPermissionsV2Api();
        boolean zBooleanValue4 = (permissionsV2Api2 == null || (canComment = permissionsV2Api2.getCanComment()) == null) ? false : canComment.booleanValue();
        GetCollectionItemsQuery.PermissionsV2Api1 permissionsV2Api3 = source.getPermissionsV2Api();
        boolean zBooleanValue5 = (permissionsV2Api3 == null || (canCreateAnnotations = permissionsV2Api3.getCanCreateAnnotations()) == null) ? false : canCreateAnnotations.booleanValue();
        GetCollectionItemsQuery.PermissionsV2Api1 permissionsV2Api4 = source.getPermissionsV2Api();
        boolean zBooleanValue6 = (permissionsV2Api4 == null || (canDelete = permissionsV2Api4.getCanDelete()) == null) ? false : canDelete.booleanValue();
        GetCollectionItemsQuery.PermissionsV2Api1 permissionsV2Api5 = source.getPermissionsV2Api();
        boolean zBooleanValue7 = (permissionsV2Api5 == null || (canDownload = permissionsV2Api5.getCanDownload()) == null) ? false : canDownload.booleanValue();
        GetCollectionItemsQuery.PermissionsV2Api1 permissionsV2Api6 = source.getPermissionsV2Api();
        boolean zBooleanValue8 = (permissionsV2Api6 == null || (canPreview = permissionsV2Api6.getCanPreview()) == null) ? false : canPreview.booleanValue();
        GetCollectionItemsQuery.PermissionsV2Api1 permissionsV2Api7 = source.getPermissionsV2Api();
        boolean zBooleanValue9 = (permissionsV2Api7 == null || (canRename = permissionsV2Api7.getCanRename()) == null) ? false : canRename.booleanValue();
        GetCollectionItemsQuery.PermissionsV2Api1 permissionsV2Api8 = source.getPermissionsV2Api();
        boolean zBooleanValue10 = (permissionsV2Api8 == null || (canSetShareAccess = permissionsV2Api8.getCanSetShareAccess()) == null) ? false : canSetShareAccess.booleanValue();
        GetCollectionItemsQuery.PermissionsV2Api1 permissionsV2Api9 = source.getPermissionsV2Api();
        boolean zBooleanValue11 = (permissionsV2Api9 == null || (canShare = permissionsV2Api9.getCanShare()) == null) ? false : canShare.booleanValue();
        GetCollectionItemsQuery.PermissionsV2Api1 permissionsV2Api10 = source.getPermissionsV2Api();
        boolean zBooleanValue12 = (permissionsV2Api10 == null || (canUpload = permissionsV2Api10.getCanUpload()) == null) ? false : canUpload.booleanValue();
        GetCollectionItemsQuery.PermissionsV2Api1 permissionsV2Api11 = source.getPermissionsV2Api();
        PermissionsModel permissionsModel = new PermissionsModel(zBooleanValue6, zBooleanValue9, zBooleanValue7, zBooleanValue8, zBooleanValue12, zBooleanValue4, zBooleanValue11, zBooleanValue3, zBooleanValue10, (permissionsV2Api11 == null || (canViewAnnotations = permissionsV2Api11.getCanViewAnnotations()) == null) ? false : canViewAnnotations.booleanValue(), zBooleanValue5, false, 2048, null);
        GetCollectionItemsQuery.Parent1 parent = source.getParent();
        if (parent != null) {
            ItemId itemIdCreateItemId2 = FolderModel.INSTANCE.createItemId(parent.getId());
            String name2 = parent.getName();
            folderModel = new FolderModel(itemIdCreateItemId2, name2 == null ? "" : name2, false, false, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, 393216, null);
        } else {
            folderModel = null;
        }
        return new FolderModel(itemIdCreateItemId, str, zBooleanValue, zBooleanValue2, folderModel, userModel, userModel3, createdAt, contentCreatedAt, updatedAt, contentUpdatedAt, false, Long.valueOf(j), permissionsModel, null, null, GQLSharedLinkFragmentToSharedLinkModelMapper.INSTANCE.fromGetCollectionItemsFolder(source.getSharedLink()), null, null, 393216, null);
    }
}
