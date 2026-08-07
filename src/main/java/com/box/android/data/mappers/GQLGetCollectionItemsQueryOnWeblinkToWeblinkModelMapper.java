package com.box.android.data.mappers;

import com.box.android.data.GetCollectionItemsQuery;
import com.box.android.data.type.ItemType;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.models.item.FolderModel;
import com.box.android.domain.models.item.ItemModelKt;
import com.box.android.domain.models.item.PermissionsModel;
import com.box.android.domain.models.item.UserModel;
import com.box.android.domain.models.item.WebLinkModel;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GQLGetCollectionItemsQueryOnWeblinkToWeblinkModelMapper.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u001a\u0010\n\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\u000b"}, d2 = {"Lcom/box/android/data/mappers/GQLGetCollectionItemsQueryOnWeblinkToWeblinkModelMapper;", "Lcom/box/android/data/mappers/GraphQLMapper;", "Lcom/box/android/domain/models/item/WebLinkModel;", "Lcom/box/android/data/GetCollectionItemsQuery$OnWeblink;", "<init>", "()V", "toGraphQL", "source", "options", "", "fromGraphQL", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class GQLGetCollectionItemsQueryOnWeblinkToWeblinkModelMapper implements GraphQLMapper<WebLinkModel, GetCollectionItemsQuery.OnWeblink> {
    public static final GQLGetCollectionItemsQueryOnWeblinkToWeblinkModelMapper INSTANCE = new GQLGetCollectionItemsQueryOnWeblinkToWeblinkModelMapper();

    private GQLGetCollectionItemsQueryOnWeblinkToWeblinkModelMapper() {
    }

    @Override // com.box.android.data.mappers.GraphQLMapper
    public GetCollectionItemsQuery.OnWeblink toGraphQL(WebLinkModel source, Object options) {
        GetCollectionItemsQuery.UpdatedBy2 updatedBy2;
        String id;
        Intrinsics.checkNotNullParameter(source, "source");
        String boxId = ItemModelKt.toItemIdRemoteId(source).getBoxId();
        ItemType itemType = ItemType.web_link;
        String name = source.getName();
        Date createdDate = source.getCreatedDate();
        Date modifiedDate = source.getModifiedDate();
        Date contentCreatedDate = source.getContentCreatedDate();
        Date contentModifiedDate = source.getContentModifiedDate();
        UserModel owner = source.getOwner();
        GetCollectionItemsQuery.OwnedBy2 ownedBy2 = (owner == null || (id = owner.getId()) == null) ? null : new GetCollectionItemsQuery.OwnedBy2(id);
        UserModel updatedBy = source.getUpdatedBy();
        if (updatedBy != null) {
            String id2 = updatedBy.getId();
            String name2 = updatedBy.getName();
            if (name2 == null) {
                name2 = "";
            }
            updatedBy2 = new GetCollectionItemsQuery.UpdatedBy2(id2, name2);
        } else {
            updatedBy2 = null;
        }
        FolderModel parentFolder = source.getParentFolder();
        GetCollectionItemsQuery.Parent2 parent2 = parentFolder != null ? new GetCollectionItemsQuery.Parent2(ItemModelKt.toItemIdRemoteId(parentFolder).getBoxId(), parentFolder.getName()) : null;
        String url = source.getUrl();
        PermissionsModel permissions = source.getPermissions();
        Boolean boolValueOf = permissions != null ? Boolean.valueOf(permissions.getCanInviteCollaborators()) : null;
        PermissionsModel permissions2 = source.getPermissions();
        Boolean boolValueOf2 = permissions2 != null ? Boolean.valueOf(permissions2.getCanComment()) : null;
        PermissionsModel permissions3 = source.getPermissions();
        Boolean boolValueOf3 = permissions3 != null ? Boolean.valueOf(permissions3.getCanCreateAnnotations()) : null;
        PermissionsModel permissions4 = source.getPermissions();
        Boolean boolValueOf4 = permissions4 != null ? Boolean.valueOf(permissions4.getCanDelete()) : null;
        PermissionsModel permissions5 = source.getPermissions();
        Boolean boolValueOf5 = permissions5 != null ? Boolean.valueOf(permissions5.getCanDownload()) : null;
        PermissionsModel permissions6 = source.getPermissions();
        Boolean boolValueOf6 = permissions6 != null ? Boolean.valueOf(permissions6.getCanPreview()) : null;
        PermissionsModel permissions7 = source.getPermissions();
        Boolean boolValueOf7 = permissions7 != null ? Boolean.valueOf(permissions7.getCanRename()) : null;
        PermissionsModel permissions8 = source.getPermissions();
        Boolean boolValueOf8 = permissions8 != null ? Boolean.valueOf(permissions8.getCanSetShareAccess()) : null;
        PermissionsModel permissions9 = source.getPermissions();
        Boolean boolValueOf9 = permissions9 != null ? Boolean.valueOf(permissions9.getCanShare()) : null;
        PermissionsModel permissions10 = source.getPermissions();
        Boolean boolValueOf10 = permissions10 != null ? Boolean.valueOf(permissions10.getCanUpload()) : null;
        PermissionsModel permissions11 = source.getPermissions();
        return new GetCollectionItemsQuery.OnWeblink(boxId, itemType, name, createdDate, modifiedDate, contentCreatedDate, contentModifiedDate, ownedBy2, updatedBy2, url, parent2, new GetCollectionItemsQuery.PermissionsV2Api2(boolValueOf, boolValueOf8, boolValueOf5, boolValueOf6, boolValueOf2, boolValueOf10, boolValueOf7, boolValueOf4, boolValueOf9, permissions11 != null ? Boolean.valueOf(permissions11.getCanViewAnnotations()) : null, boolValueOf3), SharedLinkModelToApolloSharedLinkMapper.INSTANCE.toGetCollectionItemsWeblink(source.getSharedLink()));
    }

    @Override // com.box.android.data.mappers.GraphQLMapper
    public WebLinkModel fromGraphQL(GetCollectionItemsQuery.OnWeblink source, Object options) {
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
        String id;
        Intrinsics.checkNotNullParameter(source, "source");
        ItemId itemIdCreateItemId = WebLinkModel.INSTANCE.createItemId(source.getId());
        String name = source.getName();
        String str = name == null ? "" : name;
        GetCollectionItemsQuery.OwnedBy2 ownedBy = source.getOwnedBy();
        UserModel userModel = (ownedBy == null || (id = ownedBy.getId()) == null) ? null : new UserModel(id, null, null, null, null, null, null, null, null);
        GetCollectionItemsQuery.UpdatedBy2 updatedBy = source.getUpdatedBy();
        UserModel userModel2 = updatedBy != null ? new UserModel(updatedBy.getId(), updatedBy.getName(), null, null, null, null, null, null, null) : null;
        Date createdAt = source.getCreatedAt();
        Date updatedAt = source.getUpdatedAt();
        Date contentCreatedAt = source.getContentCreatedAt();
        Date contentUpdatedAt = source.getContentUpdatedAt();
        GetCollectionItemsQuery.PermissionsV2Api2 permissionsV2Api = source.getPermissionsV2Api();
        boolean zBooleanValue = false;
        boolean zBooleanValue2 = (permissionsV2Api == null || (canInviteCollaborator = permissionsV2Api.getCanInviteCollaborator()) == null) ? false : canInviteCollaborator.booleanValue();
        GetCollectionItemsQuery.PermissionsV2Api2 permissionsV2Api2 = source.getPermissionsV2Api();
        boolean zBooleanValue3 = (permissionsV2Api2 == null || (canComment = permissionsV2Api2.getCanComment()) == null) ? false : canComment.booleanValue();
        GetCollectionItemsQuery.PermissionsV2Api2 permissionsV2Api3 = source.getPermissionsV2Api();
        boolean zBooleanValue4 = (permissionsV2Api3 == null || (canCreateAnnotations = permissionsV2Api3.getCanCreateAnnotations()) == null) ? false : canCreateAnnotations.booleanValue();
        GetCollectionItemsQuery.PermissionsV2Api2 permissionsV2Api4 = source.getPermissionsV2Api();
        boolean zBooleanValue5 = (permissionsV2Api4 == null || (canDelete = permissionsV2Api4.getCanDelete()) == null) ? false : canDelete.booleanValue();
        GetCollectionItemsQuery.PermissionsV2Api2 permissionsV2Api5 = source.getPermissionsV2Api();
        boolean zBooleanValue6 = (permissionsV2Api5 == null || (canDownload = permissionsV2Api5.getCanDownload()) == null) ? false : canDownload.booleanValue();
        GetCollectionItemsQuery.PermissionsV2Api2 permissionsV2Api6 = source.getPermissionsV2Api();
        boolean zBooleanValue7 = (permissionsV2Api6 == null || (canPreview = permissionsV2Api6.getCanPreview()) == null) ? false : canPreview.booleanValue();
        GetCollectionItemsQuery.PermissionsV2Api2 permissionsV2Api7 = source.getPermissionsV2Api();
        boolean zBooleanValue8 = (permissionsV2Api7 == null || (canRename = permissionsV2Api7.getCanRename()) == null) ? false : canRename.booleanValue();
        GetCollectionItemsQuery.PermissionsV2Api2 permissionsV2Api8 = source.getPermissionsV2Api();
        boolean zBooleanValue9 = (permissionsV2Api8 == null || (canSetShareAccess = permissionsV2Api8.getCanSetShareAccess()) == null) ? false : canSetShareAccess.booleanValue();
        GetCollectionItemsQuery.PermissionsV2Api2 permissionsV2Api9 = source.getPermissionsV2Api();
        boolean zBooleanValue10 = (permissionsV2Api9 == null || (canShare = permissionsV2Api9.getCanShare()) == null) ? false : canShare.booleanValue();
        GetCollectionItemsQuery.PermissionsV2Api2 permissionsV2Api10 = source.getPermissionsV2Api();
        boolean zBooleanValue11 = (permissionsV2Api10 == null || (canUpload = permissionsV2Api10.getCanUpload()) == null) ? false : canUpload.booleanValue();
        GetCollectionItemsQuery.PermissionsV2Api2 permissionsV2Api11 = source.getPermissionsV2Api();
        if (permissionsV2Api11 != null && (canViewAnnotations = permissionsV2Api11.getCanViewAnnotations()) != null) {
            zBooleanValue = canViewAnnotations.booleanValue();
        }
        PermissionsModel permissionsModel = new PermissionsModel(zBooleanValue5, zBooleanValue8, zBooleanValue6, zBooleanValue7, zBooleanValue11, zBooleanValue3, zBooleanValue10, zBooleanValue2, zBooleanValue9, zBooleanValue, zBooleanValue4, false, 2048, null);
        String strValueOf = String.valueOf(source.getUrl());
        GetCollectionItemsQuery.Parent2 parent = source.getParent();
        if (parent != null) {
            ItemId itemIdCreateItemId2 = FolderModel.INSTANCE.createItemId(parent.getId());
            String name2 = parent.getName();
            folderModel = new FolderModel(itemIdCreateItemId2, name2 == null ? "" : name2, false, false, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, 393216, null);
        } else {
            folderModel = null;
        }
        return new WebLinkModel(itemIdCreateItemId, str, false, false, folderModel, userModel, userModel2, createdAt, contentCreatedAt, updatedAt, contentUpdatedAt, false, permissionsModel, null, strValueOf, GQLSharedLinkFragmentToSharedLinkModelMapper.INSTANCE.fromGetCollectionItemsWeblink(source.getSharedLink()), null, null, 131072, null);
    }
}
