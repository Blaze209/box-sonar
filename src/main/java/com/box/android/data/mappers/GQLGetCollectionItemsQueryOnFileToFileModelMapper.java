package com.box.android.data.mappers;

import com.box.android.common.utilities.NumberUtils;
import com.box.android.data.GetCollectionItemsQuery;
import com.box.android.data.type.ItemType;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.models.item.FileModel;
import com.box.android.domain.models.item.FolderModel;
import com.box.android.domain.models.item.ItemModelKt;
import com.box.android.domain.models.item.PermissionsModel;
import com.box.android.domain.models.item.UserModel;
import com.box.android.domain.models.item.WatermarkModel;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GQLGetCollectionItemsQueryOnFileToFileModelMapper.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u001a\u0010\n\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\u000b"}, d2 = {"Lcom/box/android/data/mappers/GQLGetCollectionItemsQueryOnFileToFileModelMapper;", "Lcom/box/android/data/mappers/GraphQLMapper;", "Lcom/box/android/domain/models/item/FileModel;", "Lcom/box/android/data/GetCollectionItemsQuery$OnFile;", "<init>", "()V", "toGraphQL", "source", "options", "", "fromGraphQL", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class GQLGetCollectionItemsQueryOnFileToFileModelMapper implements GraphQLMapper<FileModel, GetCollectionItemsQuery.OnFile> {
    public static final GQLGetCollectionItemsQueryOnFileToFileModelMapper INSTANCE = new GQLGetCollectionItemsQueryOnFileToFileModelMapper();

    private GQLGetCollectionItemsQueryOnFileToFileModelMapper() {
    }

    @Override // com.box.android.data.mappers.GraphQLMapper
    public GetCollectionItemsQuery.OnFile toGraphQL(FileModel source, Object options) {
        GetCollectionItemsQuery.UpdatedBy updatedBy;
        String id;
        Intrinsics.checkNotNullParameter(source, "source");
        String boxId = ItemModelKt.toItemIdRemoteId(source).getBoxId();
        ItemType itemType = ItemType.file;
        String name = source.getName();
        long jLongValue = source.getSize().longValue();
        Date createdDate = source.getCreatedDate();
        Date modifiedDate = source.getModifiedDate();
        UserModel owner = source.getOwner();
        GetCollectionItemsQuery.OwnedBy ownedBy = (owner == null || (id = owner.getId()) == null) ? null : new GetCollectionItemsQuery.OwnedBy(id);
        UserModel updatedBy2 = source.getUpdatedBy();
        if (updatedBy2 != null) {
            String id2 = updatedBy2.getId();
            String name2 = updatedBy2.getName();
            if (name2 == null) {
                name2 = "";
            }
            updatedBy = new GetCollectionItemsQuery.UpdatedBy(id2, name2);
        } else {
            updatedBy = null;
        }
        Date contentCreatedDate = source.getContentCreatedDate();
        Date contentModifiedDate = source.getContentModifiedDate();
        boolean hasCollaborations = source.getHasCollaborations();
        boolean zIsExternallyOwned = source.isExternallyOwned();
        String sha1 = source.getSha1();
        WatermarkModel watermark = source.getWatermark();
        GetCollectionItemsQuery.Watermark watermark2 = watermark != null ? new GetCollectionItemsQuery.Watermark(Boolean.valueOf(watermark.isWatermarked())) : null;
        FolderModel parentFolder = source.getParentFolder();
        GetCollectionItemsQuery.Parent parent = parentFolder != null ? new GetCollectionItemsQuery.Parent(ItemModelKt.toItemIdRemoteId(parentFolder).getBoxId(), parentFolder.getName()) : null;
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
        return new GetCollectionItemsQuery.OnFile(boxId, itemType, name, Long.valueOf(jLongValue), createdDate, modifiedDate, contentCreatedDate, contentModifiedDate, ownedBy, updatedBy, Boolean.valueOf(hasCollaborations), Boolean.valueOf(zIsExternallyOwned), sha1, watermark2, parent, new GetCollectionItemsQuery.PermissionsV2Api(boolValueOf, boolValueOf8, boolValueOf5, boolValueOf6, boolValueOf2, boolValueOf10, boolValueOf7, boolValueOf4, boolValueOf9, permissions11 != null ? Boolean.valueOf(permissions11.getCanViewAnnotations()) : null, boolValueOf3), SharedLinkModelToApolloSharedLinkMapper.INSTANCE.toGetCollectionItemsFile(source.getSharedLink()));
    }

    @Override // com.box.android.data.mappers.GraphQLMapper
    public FileModel fromGraphQL(GetCollectionItemsQuery.OnFile source, Object options) {
        WatermarkModel watermarkModel;
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
        ItemId itemIdCreateItemId = FileModel.INSTANCE.createItemId(source.getId());
        String name = source.getName();
        String str = name == null ? "" : name;
        Boolean hasCollaborations = source.getHasCollaborations();
        boolean zBooleanValue = hasCollaborations != null ? hasCollaborations.booleanValue() : false;
        Boolean boolIsExternallyOwned = source.isExternallyOwned();
        boolean zBooleanValue2 = boolIsExternallyOwned != null ? boolIsExternallyOwned.booleanValue() : false;
        GetCollectionItemsQuery.OwnedBy ownedBy = source.getOwnedBy();
        UserModel userModel = (ownedBy == null || (id = ownedBy.getId()) == null) ? null : new UserModel(id, null, null, null, null, null, null, null, null);
        GetCollectionItemsQuery.UpdatedBy updatedBy = source.getUpdatedBy();
        UserModel userModel2 = updatedBy != null ? new UserModel(updatedBy.getId(), updatedBy.getName(), null, null, null, null, null, null, null) : null;
        Date createdAt = source.getCreatedAt();
        Date updatedAt = source.getUpdatedAt();
        Date contentCreatedAt = source.getContentCreatedAt();
        Date contentUpdatedAt = source.getContentUpdatedAt();
        long longOrDefault = NumberUtils.INSTANCE.toLongOrDefault(source.getSize(), 0L);
        GetCollectionItemsQuery.PermissionsV2Api permissionsV2Api = source.getPermissionsV2Api();
        boolean zBooleanValue3 = (permissionsV2Api == null || (canInviteCollaborator = permissionsV2Api.getCanInviteCollaborator()) == null) ? false : canInviteCollaborator.booleanValue();
        GetCollectionItemsQuery.PermissionsV2Api permissionsV2Api2 = source.getPermissionsV2Api();
        boolean zBooleanValue4 = (permissionsV2Api2 == null || (canComment = permissionsV2Api2.getCanComment()) == null) ? false : canComment.booleanValue();
        GetCollectionItemsQuery.PermissionsV2Api permissionsV2Api3 = source.getPermissionsV2Api();
        boolean zBooleanValue5 = (permissionsV2Api3 == null || (canCreateAnnotations = permissionsV2Api3.getCanCreateAnnotations()) == null) ? false : canCreateAnnotations.booleanValue();
        GetCollectionItemsQuery.PermissionsV2Api permissionsV2Api4 = source.getPermissionsV2Api();
        boolean zBooleanValue6 = (permissionsV2Api4 == null || (canDelete = permissionsV2Api4.getCanDelete()) == null) ? false : canDelete.booleanValue();
        GetCollectionItemsQuery.PermissionsV2Api permissionsV2Api5 = source.getPermissionsV2Api();
        boolean zBooleanValue7 = (permissionsV2Api5 == null || (canDownload = permissionsV2Api5.getCanDownload()) == null) ? false : canDownload.booleanValue();
        GetCollectionItemsQuery.PermissionsV2Api permissionsV2Api6 = source.getPermissionsV2Api();
        boolean zBooleanValue8 = (permissionsV2Api6 == null || (canPreview = permissionsV2Api6.getCanPreview()) == null) ? false : canPreview.booleanValue();
        GetCollectionItemsQuery.PermissionsV2Api permissionsV2Api7 = source.getPermissionsV2Api();
        boolean zBooleanValue9 = (permissionsV2Api7 == null || (canRename = permissionsV2Api7.getCanRename()) == null) ? false : canRename.booleanValue();
        GetCollectionItemsQuery.PermissionsV2Api permissionsV2Api8 = source.getPermissionsV2Api();
        boolean zBooleanValue10 = (permissionsV2Api8 == null || (canSetShareAccess = permissionsV2Api8.getCanSetShareAccess()) == null) ? false : canSetShareAccess.booleanValue();
        GetCollectionItemsQuery.PermissionsV2Api permissionsV2Api9 = source.getPermissionsV2Api();
        boolean zBooleanValue11 = (permissionsV2Api9 == null || (canShare = permissionsV2Api9.getCanShare()) == null) ? false : canShare.booleanValue();
        GetCollectionItemsQuery.PermissionsV2Api permissionsV2Api10 = source.getPermissionsV2Api();
        boolean zBooleanValue12 = (permissionsV2Api10 == null || (canUpload = permissionsV2Api10.getCanUpload()) == null) ? false : canUpload.booleanValue();
        GetCollectionItemsQuery.PermissionsV2Api permissionsV2Api11 = source.getPermissionsV2Api();
        PermissionsModel permissionsModel = new PermissionsModel(zBooleanValue6, zBooleanValue9, zBooleanValue7, zBooleanValue8, zBooleanValue12, zBooleanValue4, zBooleanValue11, zBooleanValue3, zBooleanValue10, (permissionsV2Api11 == null || (canViewAnnotations = permissionsV2Api11.getCanViewAnnotations()) == null) ? false : canViewAnnotations.booleanValue(), zBooleanValue5, false, 2048, null);
        String sha1 = source.getSha1();
        String str2 = sha1 == null ? "" : sha1;
        GetCollectionItemsQuery.Watermark watermark = source.getWatermark();
        if (watermark != null) {
            Boolean boolIsWatermarked = watermark.isWatermarked();
            watermarkModel = new WatermarkModel(boolIsWatermarked != null ? boolIsWatermarked.booleanValue() : false, false, false, 6, null);
        } else {
            watermarkModel = null;
        }
        GetCollectionItemsQuery.Parent parent = source.getParent();
        return new FileModel(itemIdCreateItemId, str, zBooleanValue, zBooleanValue2, parent != null ? (FolderModel) GraphQLMapper.fromGraphQL$default(GQLGetCollectionItemsQueryOnFolderToFolderModelMapper.INSTANCE, new GetCollectionItemsQuery.OnFolder(parent.getId(), ItemType.folder, parent.getName(), null, null, null, null, null, null, null, null, null, null, null, null), null, 2, null) : null, userModel, userModel2, createdAt, contentCreatedAt, updatedAt, contentUpdatedAt, false, longOrDefault, permissionsModel, null, null, GQLSharedLinkFragmentToSharedLinkModelMapper.INSTANCE.fromGetCollectionItemsFile(source.getSharedLink()), null, null, str2, null, null, null, null, null, watermarkModel, null, 83886080, null);
    }
}
