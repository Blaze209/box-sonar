package com.box.android.data.mappers;

import com.box.android.common.utilities.NumberUtils;
import com.box.android.data.CreateFolderMutation;
import com.box.android.domain.models.CollectionModel;
import com.box.android.domain.models.CollectionType;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.models.item.FolderModel;
import com.box.android.domain.models.item.PermissionsModel;
import com.box.android.domain.models.item.UserModel;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GQLCreateFolderToFolderModelMapper.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0007\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u001a\u0010\n\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\f\u0010\u000b\u001a\u00020\u0002*\u00020\fH\u0002J\f\u0010\r\u001a\u00020\u000e*\u00020\u000fH\u0002J\f\u0010\r\u001a\u00020\u000e*\u00020\u0010H\u0002J\f\u0010\u0011\u001a\u00020\u0012*\u00020\u0013H\u0002¨\u0006\u0014"}, d2 = {"Lcom/box/android/data/mappers/GQLCreateFolderToFolderModelMapper;", "Lcom/box/android/data/mappers/GraphQLMapper;", "Lcom/box/android/domain/models/item/FolderModel;", "Lcom/box/android/data/CreateFolderMutation$Value;", "<init>", "()V", "toGraphQL", "source", "options", "", "fromGraphQL", "toFolderModel", "Lcom/box/android/data/CreateFolderMutation$Parent;", "toUserModel", "Lcom/box/android/domain/models/item/UserModel;", "Lcom/box/android/data/CreateFolderMutation$OwnedBy;", "Lcom/box/android/data/CreateFolderMutation$UpdatedBy;", "toPermissionsModel", "Lcom/box/android/domain/models/item/PermissionsModel;", "Lcom/box/android/data/CreateFolderMutation$PermissionsV2Api;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class GQLCreateFolderToFolderModelMapper implements GraphQLMapper<FolderModel, CreateFolderMutation.Value> {
    public static final GQLCreateFolderToFolderModelMapper INSTANCE = new GQLCreateFolderToFolderModelMapper();

    private GQLCreateFolderToFolderModelMapper() {
    }

    @Override // com.box.android.data.mappers.GraphQLMapper
    public CreateFolderMutation.Value toGraphQL(FolderModel source, Object options) {
        Intrinsics.checkNotNullParameter(source, "source");
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    /* JADX WARN: Code duplicated, block: B:49:0x00f6  */
    @Override // com.box.android.data.mappers.GraphQLMapper
    public FolderModel fromGraphQL(CreateFolderMutation.Value source, Object options) {
        ArrayList arrayList;
        List<CreateFolderMutation.Edge> edges;
        CollectionType collectionTypeValueOf;
        Intrinsics.checkNotNullParameter(source, "source");
        ItemId itemIdCreateItemId = FolderModel.INSTANCE.createItemId(source.getId());
        String name = source.getName();
        String str = name == null ? "" : name;
        Boolean hasCollaborations = source.getHasCollaborations();
        boolean zBooleanValue = hasCollaborations != null ? hasCollaborations.booleanValue() : false;
        Boolean boolIsExternallyOwned = source.isExternallyOwned();
        boolean zBooleanValue2 = boolIsExternallyOwned != null ? boolIsExternallyOwned.booleanValue() : false;
        CreateFolderMutation.Parent parent = source.getParent();
        FolderModel folderModel = parent != null ? toFolderModel(parent) : null;
        CreateFolderMutation.OwnedBy ownedBy = source.getOwnedBy();
        UserModel userModel = ownedBy != null ? toUserModel(ownedBy) : null;
        CreateFolderMutation.UpdatedBy updatedBy = source.getUpdatedBy();
        UserModel userModel2 = updatedBy != null ? toUserModel(updatedBy) : null;
        Date createdAt = source.getCreatedAt();
        Date contentCreatedAt = source.getContentCreatedAt();
        Date updatedAt = source.getUpdatedAt();
        Date contentUpdatedAt = source.getContentUpdatedAt();
        FolderModel folderModel2 = folderModel;
        long longOrDefault = NumberUtils.INSTANCE.toLongOrDefault(source.getSize(), 0L);
        CreateFolderMutation.PermissionsV2Api permissionsV2Api = source.getPermissionsV2Api();
        PermissionsModel permissionsModel = permissionsV2Api != null ? toPermissionsModel(permissionsV2Api) : null;
        Boolean boolIsRooted = source.isRooted();
        boolean zBooleanValue3 = boolIsRooted != null ? boolIsRooted.booleanValue() : false;
        CreateFolderMutation.ItemCollectionConnection itemCollectionConnection = source.getItemCollectionConnection();
        if (itemCollectionConnection == null || (edges = itemCollectionConnection.getEdges()) == null) {
            arrayList = null;
        } else {
            List<CreateFolderMutation.Edge> list = edges;
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            for (CreateFolderMutation.Edge edge : list) {
                String id = edge.getNode().getId();
                String name2 = edge.getNode().getName();
                String str2 = name2 == null ? "" : name2;
                String collectionType = edge.getNode().getCollectionType();
                if (collectionType != null) {
                    String upperCase = collectionType.toUpperCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
                    collectionTypeValueOf = CollectionType.valueOf(upperCase);
                    if (collectionTypeValueOf == null) {
                        collectionTypeValueOf = CollectionType.FAVORITES;
                    }
                } else {
                    collectionTypeValueOf = CollectionType.FAVORITES;
                }
                arrayList2.add(new CollectionModel(id, collectionTypeValueOf, str2, null, null));
            }
            arrayList = arrayList2;
        }
        return new FolderModel(itemIdCreateItemId, str, zBooleanValue, zBooleanValue2, folderModel2, userModel, userModel2, createdAt, contentCreatedAt, updatedAt, contentUpdatedAt, zBooleanValue3, Long.valueOf(longOrDefault), permissionsModel, null, arrayList, null, null, null, 393216, null);
    }

    private final FolderModel toFolderModel(CreateFolderMutation.Parent parent) {
        ItemId itemIdCreateItemId = FolderModel.INSTANCE.createItemId(parent.getId());
        String name = parent.getName();
        if (name == null) {
            name = "";
        }
        return new FolderModel(itemIdCreateItemId, name, false, false, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, 393216, null);
    }

    private final UserModel toUserModel(CreateFolderMutation.OwnedBy ownedBy) {
        return new UserModel(ownedBy.getId(), ownedBy.getName(), null, null, null, null, null, null, null);
    }

    private final UserModel toUserModel(CreateFolderMutation.UpdatedBy updatedBy) {
        return new UserModel(updatedBy.getId(), updatedBy.getName(), null, null, null, null, null, null, null);
    }

    private final PermissionsModel toPermissionsModel(CreateFolderMutation.PermissionsV2Api permissionsV2Api) {
        Boolean canDelete = permissionsV2Api.getCanDelete();
        boolean zBooleanValue = canDelete != null ? canDelete.booleanValue() : false;
        Boolean canRename = permissionsV2Api.getCanRename();
        boolean zBooleanValue2 = canRename != null ? canRename.booleanValue() : false;
        Boolean canDownload = permissionsV2Api.getCanDownload();
        boolean zBooleanValue3 = canDownload != null ? canDownload.booleanValue() : false;
        Boolean canPreview = permissionsV2Api.getCanPreview();
        boolean zBooleanValue4 = canPreview != null ? canPreview.booleanValue() : false;
        Boolean canUpload = permissionsV2Api.getCanUpload();
        boolean zBooleanValue5 = canUpload != null ? canUpload.booleanValue() : false;
        Boolean canComment = permissionsV2Api.getCanComment();
        boolean zBooleanValue6 = canComment != null ? canComment.booleanValue() : false;
        Boolean canShare = permissionsV2Api.getCanShare();
        boolean zBooleanValue7 = canShare != null ? canShare.booleanValue() : false;
        Boolean canInviteCollaborator = permissionsV2Api.getCanInviteCollaborator();
        boolean zBooleanValue8 = canInviteCollaborator != null ? canInviteCollaborator.booleanValue() : false;
        Boolean canSetShareAccess = permissionsV2Api.getCanSetShareAccess();
        boolean zBooleanValue9 = canSetShareAccess != null ? canSetShareAccess.booleanValue() : false;
        Boolean canViewAnnotations = permissionsV2Api.getCanViewAnnotations();
        boolean zBooleanValue10 = canViewAnnotations != null ? canViewAnnotations.booleanValue() : false;
        Boolean canCreateAnnotations = permissionsV2Api.getCanCreateAnnotations();
        return new PermissionsModel(zBooleanValue, zBooleanValue2, zBooleanValue3, zBooleanValue4, zBooleanValue5, zBooleanValue6, zBooleanValue7, zBooleanValue8, zBooleanValue9, zBooleanValue10, canCreateAnnotations != null ? canCreateAnnotations.booleanValue() : false, false, 2048, null);
    }
}
