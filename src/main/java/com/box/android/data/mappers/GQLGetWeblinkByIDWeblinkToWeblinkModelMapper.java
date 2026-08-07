package com.box.android.data.mappers;

import com.box.android.data.GetCollectionItemsQuery;
import com.box.android.data.GetItemQuery;
import com.box.android.data.type.ItemType;
import com.box.android.domain.models.CollectionModel;
import com.box.android.domain.models.CollectionType;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.models.item.FolderModel;
import com.box.android.domain.models.item.ItemModelKt;
import com.box.android.domain.models.item.PermissionsModel;
import com.box.android.domain.models.item.UserModel;
import com.box.android.domain.models.item.WebLinkModel;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GQLGetWeblinkByIDWeblinkToWeblinkModelMapper.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u001a\u0010\n\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\u000b"}, d2 = {"Lcom/box/android/data/mappers/GQLGetWeblinkByIDWeblinkToWeblinkModelMapper;", "Lcom/box/android/data/mappers/GraphQLMapper;", "Lcom/box/android/domain/models/item/WebLinkModel;", "Lcom/box/android/data/GetItemQuery$OnWeblink;", "<init>", "()V", "toGraphQL", "source", "options", "", "fromGraphQL", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class GQLGetWeblinkByIDWeblinkToWeblinkModelMapper implements GraphQLMapper<WebLinkModel, GetItemQuery.OnWeblink> {
    public static final GQLGetWeblinkByIDWeblinkToWeblinkModelMapper INSTANCE = new GQLGetWeblinkByIDWeblinkToWeblinkModelMapper();

    private GQLGetWeblinkByIDWeblinkToWeblinkModelMapper() {
    }

    @Override // com.box.android.data.mappers.GraphQLMapper
    public GetItemQuery.OnWeblink toGraphQL(WebLinkModel source, Object options) {
        GetItemQuery.UpdatedBy2 updatedBy2;
        boolean z;
        String str;
        ItemType itemType;
        GetItemQuery.ItemCollectionConnection2 itemCollectionConnection2;
        Intrinsics.checkNotNullParameter(source, "source");
        String boxId = ItemModelKt.toItemIdRemoteId(source).getBoxId();
        ItemType itemType2 = ItemType.web_link;
        String name = source.getName();
        Date createdDate = source.getCreatedDate();
        Date modifiedDate = source.getModifiedDate();
        UserModel owner = source.getOwner();
        GetItemQuery.OwnedBy2 ownedBy2 = owner != null ? new GetItemQuery.OwnedBy2(owner.getId(), owner.getName()) : null;
        UserModel updatedBy = source.getUpdatedBy();
        if (updatedBy != null) {
            String id = updatedBy.getId();
            String name2 = updatedBy.getName();
            if (name2 == null) {
                name2 = "";
            }
            updatedBy2 = new GetItemQuery.UpdatedBy2(id, name2);
        } else {
            updatedBy2 = null;
        }
        FolderModel parentFolder = source.getParentFolder();
        GetItemQuery.Parent2 parent2 = parentFolder != null ? new GetItemQuery.Parent2(ItemModelKt.toItemIdRemoteId(parentFolder).getBoxId(), parentFolder.getName()) : null;
        boolean zIsRooted = source.isRooted();
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
        GetItemQuery.PermissionsV2Api2 permissionsV2Api2 = new GetItemQuery.PermissionsV2Api2(boolValueOf, boolValueOf8, boolValueOf5, boolValueOf6, boolValueOf2, boolValueOf10, boolValueOf7, boolValueOf4, boolValueOf9, permissions11 != null ? Boolean.valueOf(permissions11.getCanViewAnnotations()) : null, boolValueOf3);
        String url = source.getUrl();
        List<CollectionModel> collections = source.getCollections();
        if (collections != null) {
            List<CollectionModel> list = collections;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            for (CollectionModel collectionModel : list) {
                arrayList.add(new GetItemQuery.Edge2(collectionModel.getId(), new GetItemQuery.Node2(collectionModel.getId(), collectionModel.getName(), collectionModel.getType().name())));
                zIsRooted = zIsRooted;
                boxId = boxId;
                itemType2 = itemType2;
            }
            z = zIsRooted;
            str = boxId;
            itemType = itemType2;
            itemCollectionConnection2 = new GetItemQuery.ItemCollectionConnection2(arrayList);
        } else {
            z = zIsRooted;
            str = boxId;
            itemType = itemType2;
            itemCollectionConnection2 = null;
        }
        return new GetItemQuery.OnWeblink(str, itemType, name, createdDate, source.getDescription(), modifiedDate, Boolean.valueOf(z), itemCollectionConnection2, url, ownedBy2, updatedBy2, parent2, permissionsV2Api2, SharedLinkModelToApolloSharedLinkMapper.INSTANCE.toGetItemQueryWeblink(source.getSharedLink()));
    }

    /* JADX WARN: Code duplicated, block: B:102:0x01f8  */
    @Override // com.box.android.data.mappers.GraphQLMapper
    public WebLinkModel fromGraphQL(GetItemQuery.OnWeblink source, Object options) {
        List<GetItemQuery.Edge2> edges;
        CollectionType collectionTypeValueOf;
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
        Intrinsics.checkNotNullParameter(source, "source");
        ItemId itemIdCreateItemId = WebLinkModel.INSTANCE.createItemId(source.getId());
        String name = source.getName();
        String str = name == null ? "" : name;
        GetItemQuery.OwnedBy2 ownedBy = source.getOwnedBy();
        ArrayList arrayList = null;
        UserModel userModel = ownedBy != null ? new UserModel(ownedBy.getId(), ownedBy.getName(), null, null, null, null, null, null, null) : null;
        GetItemQuery.UpdatedBy2 updatedBy = source.getUpdatedBy();
        UserModel userModel2 = updatedBy != null ? new UserModel(updatedBy.getId(), updatedBy.getName(), null, null, null, null, null, null, null) : null;
        Date createdAt = source.getCreatedAt();
        Date updatedAt = source.getUpdatedAt();
        GetItemQuery.PermissionsV2Api2 permissionsV2Api = source.getPermissionsV2Api();
        boolean zBooleanValue = (permissionsV2Api == null || (canInviteCollaborator = permissionsV2Api.getCanInviteCollaborator()) == null) ? false : canInviteCollaborator.booleanValue();
        GetItemQuery.PermissionsV2Api2 permissionsV2Api2 = source.getPermissionsV2Api();
        boolean zBooleanValue2 = (permissionsV2Api2 == null || (canComment = permissionsV2Api2.getCanComment()) == null) ? false : canComment.booleanValue();
        GetItemQuery.PermissionsV2Api2 permissionsV2Api3 = source.getPermissionsV2Api();
        boolean zBooleanValue3 = (permissionsV2Api3 == null || (canCreateAnnotations = permissionsV2Api3.getCanCreateAnnotations()) == null) ? false : canCreateAnnotations.booleanValue();
        GetItemQuery.PermissionsV2Api2 permissionsV2Api4 = source.getPermissionsV2Api();
        boolean zBooleanValue4 = (permissionsV2Api4 == null || (canDelete = permissionsV2Api4.getCanDelete()) == null) ? false : canDelete.booleanValue();
        GetItemQuery.PermissionsV2Api2 permissionsV2Api5 = source.getPermissionsV2Api();
        boolean zBooleanValue5 = (permissionsV2Api5 == null || (canDownload = permissionsV2Api5.getCanDownload()) == null) ? false : canDownload.booleanValue();
        GetItemQuery.PermissionsV2Api2 permissionsV2Api6 = source.getPermissionsV2Api();
        boolean zBooleanValue6 = (permissionsV2Api6 == null || (canPreview = permissionsV2Api6.getCanPreview()) == null) ? false : canPreview.booleanValue();
        GetItemQuery.PermissionsV2Api2 permissionsV2Api7 = source.getPermissionsV2Api();
        boolean zBooleanValue7 = (permissionsV2Api7 == null || (canRename = permissionsV2Api7.getCanRename()) == null) ? false : canRename.booleanValue();
        GetItemQuery.PermissionsV2Api2 permissionsV2Api8 = source.getPermissionsV2Api();
        boolean zBooleanValue8 = (permissionsV2Api8 == null || (canSetShareAccess = permissionsV2Api8.getCanSetShareAccess()) == null) ? false : canSetShareAccess.booleanValue();
        GetItemQuery.PermissionsV2Api2 permissionsV2Api9 = source.getPermissionsV2Api();
        boolean zBooleanValue9 = (permissionsV2Api9 == null || (canShare = permissionsV2Api9.getCanShare()) == null) ? false : canShare.booleanValue();
        GetItemQuery.PermissionsV2Api2 permissionsV2Api10 = source.getPermissionsV2Api();
        boolean zBooleanValue10 = (permissionsV2Api10 == null || (canUpload = permissionsV2Api10.getCanUpload()) == null) ? false : canUpload.booleanValue();
        GetItemQuery.PermissionsV2Api2 permissionsV2Api11 = source.getPermissionsV2Api();
        PermissionsModel permissionsModel = new PermissionsModel(zBooleanValue4, zBooleanValue7, zBooleanValue5, zBooleanValue6, zBooleanValue10, zBooleanValue2, zBooleanValue9, zBooleanValue, zBooleanValue8, (permissionsV2Api11 == null || (canViewAnnotations = permissionsV2Api11.getCanViewAnnotations()) == null) ? false : canViewAnnotations.booleanValue(), zBooleanValue3, false, 2048, null);
        GetItemQuery.Parent2 parent = source.getParent();
        FolderModel folderModel = parent != null ? (FolderModel) GraphQLMapper.fromGraphQL$default(GQLGetCollectionItemsQueryOnFolderToFolderModelMapper.INSTANCE, new GetCollectionItemsQuery.OnFolder(parent.getId(), ItemType.folder, parent.getName(), null, null, null, null, null, null, null, null, null, null, null, null), null, 2, null) : null;
        Boolean boolIsRooted = source.isRooted();
        boolean zBooleanValue11 = boolIsRooted != null ? boolIsRooted.booleanValue() : false;
        GetItemQuery.ItemCollectionConnection2 itemCollectionConnection = source.getItemCollectionConnection();
        if (itemCollectionConnection != null && (edges = itemCollectionConnection.getEdges()) != null) {
            List<GetItemQuery.Edge2> list = edges;
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            for (GetItemQuery.Edge2 edge2 : list) {
                String id = edge2.getNode().getId();
                String name2 = edge2.getNode().getName();
                String str2 = name2 == null ? "" : name2;
                String collectionType = edge2.getNode().getCollectionType();
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
        return new WebLinkModel(itemIdCreateItemId, str, false, false, folderModel, userModel, userModel2, createdAt, null, updatedAt, null, zBooleanValue11, permissionsModel, null, String.valueOf(source.getUrl()), GQLSharedLinkFragmentToSharedLinkModelMapper.INSTANCE.fromGetItemQueryWeblink(source.getSharedLink()), arrayList, source.getDescription(), 1280, null);
    }
}
