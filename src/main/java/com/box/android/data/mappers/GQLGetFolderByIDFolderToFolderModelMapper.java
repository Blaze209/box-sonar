package com.box.android.data.mappers;

import com.box.android.common.utilities.NumberUtils;
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
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GQLGetFolderByIDFolderToFolderModelMapper.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u001a\u0010\n\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\u000b"}, d2 = {"Lcom/box/android/data/mappers/GQLGetFolderByIDFolderToFolderModelMapper;", "Lcom/box/android/data/mappers/GraphQLMapper;", "Lcom/box/android/domain/models/item/FolderModel;", "Lcom/box/android/data/GetItemQuery$OnFolder;", "<init>", "()V", "toGraphQL", "source", "options", "", "fromGraphQL", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class GQLGetFolderByIDFolderToFolderModelMapper implements GraphQLMapper<FolderModel, GetItemQuery.OnFolder> {
    public static final GQLGetFolderByIDFolderToFolderModelMapper INSTANCE = new GQLGetFolderByIDFolderToFolderModelMapper();

    private GQLGetFolderByIDFolderToFolderModelMapper() {
    }

    @Override // com.box.android.data.mappers.GraphQLMapper
    public GetItemQuery.OnFolder toGraphQL(FolderModel source, Object options) {
        GetItemQuery.UpdatedBy1 updatedBy1;
        boolean z;
        String str;
        ItemType itemType;
        GetItemQuery.ItemCollectionConnection1 itemCollectionConnection1;
        Intrinsics.checkNotNullParameter(source, "source");
        String boxId = ItemModelKt.toItemIdRemoteId(source).getBoxId();
        ItemType itemType2 = ItemType.folder;
        String name = source.getName();
        Long size = source.getSize();
        Date createdDate = source.getCreatedDate();
        Date modifiedDate = source.getModifiedDate();
        UserModel owner = source.getOwner();
        GetItemQuery.OwnedBy1 ownedBy1 = owner != null ? new GetItemQuery.OwnedBy1(owner.getId(), owner.getName()) : null;
        UserModel updatedBy = source.getUpdatedBy();
        if (updatedBy != null) {
            String id = updatedBy.getId();
            String name2 = updatedBy.getName();
            if (name2 == null) {
                name2 = "";
            }
            updatedBy1 = new GetItemQuery.UpdatedBy1(id, name2);
        } else {
            updatedBy1 = null;
        }
        Date contentCreatedDate = source.getContentCreatedDate();
        Date contentModifiedDate = source.getContentModifiedDate();
        boolean hasCollaborations = source.getHasCollaborations();
        boolean zIsExternallyOwned = source.isExternallyOwned();
        FolderModel parentFolder = source.getParentFolder();
        GetItemQuery.Parent1 parent1 = parentFolder != null ? new GetItemQuery.Parent1(ItemModelKt.toItemIdRemoteId(parentFolder).getBoxId(), parentFolder.getName()) : null;
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
        GetItemQuery.PermissionsV2Api1 permissionsV2Api1 = new GetItemQuery.PermissionsV2Api1(boolValueOf4, boolValueOf5, boolValueOf, boolValueOf7, boolValueOf8, boolValueOf9, boolValueOf10, boolValueOf6, boolValueOf2, permissions11 != null ? Boolean.valueOf(permissions11.getCanViewAnnotations()) : null, boolValueOf3);
        boolean zIsRooted = source.isRooted();
        List<CollectionModel> collections = source.getCollections();
        if (collections != null) {
            List<CollectionModel> list = collections;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            for (CollectionModel collectionModel : list) {
                arrayList.add(new GetItemQuery.Edge1(collectionModel.getId(), new GetItemQuery.Node1(collectionModel.getId(), collectionModel.getName(), collectionModel.getType().name())));
                hasCollaborations = hasCollaborations;
                boxId = boxId;
                itemType2 = itemType2;
            }
            z = hasCollaborations;
            str = boxId;
            itemType = itemType2;
            itemCollectionConnection1 = new GetItemQuery.ItemCollectionConnection1(arrayList);
        } else {
            z = hasCollaborations;
            str = boxId;
            itemType = itemType2;
            itemCollectionConnection1 = null;
        }
        return new GetItemQuery.OnFolder(str, itemType, name, createdDate, source.getDescription(), modifiedDate, contentCreatedDate, contentModifiedDate, Boolean.valueOf(zIsRooted), itemCollectionConnection1, size, Boolean.valueOf(z), Boolean.valueOf(zIsExternallyOwned), ownedBy1, updatedBy1, parent1, permissionsV2Api1, SharedLinkModelToApolloSharedLinkMapper.INSTANCE.toGetItemQueryFolder(source.getSharedLink()));
    }

    /* JADX WARN: Code duplicated, block: B:107:0x022b  */
    @Override // com.box.android.data.mappers.GraphQLMapper
    public FolderModel fromGraphQL(GetItemQuery.OnFolder source, Object options) {
        ArrayList arrayList;
        FolderModel folderModel;
        ArrayList arrayList2;
        List<GetItemQuery.Edge1> edges;
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
        ItemId itemIdCreateItemId = FolderModel.INSTANCE.createItemId(source.getId());
        String name = source.getName();
        String str = name == null ? "" : name;
        Boolean hasCollaborations = source.getHasCollaborations();
        boolean zBooleanValue = hasCollaborations != null ? hasCollaborations.booleanValue() : false;
        Boolean boolIsExternallyOwned = source.isExternallyOwned();
        boolean zBooleanValue2 = boolIsExternallyOwned != null ? boolIsExternallyOwned.booleanValue() : false;
        GetItemQuery.OwnedBy1 ownedBy = source.getOwnedBy();
        UserModel userModel = ownedBy != null ? new UserModel(ownedBy.getId(), ownedBy.getName(), null, null, null, null, null, null, null) : null;
        GetItemQuery.UpdatedBy1 updatedBy = source.getUpdatedBy();
        UserModel userModel2 = updatedBy != null ? new UserModel(updatedBy.getId(), updatedBy.getName(), null, null, null, null, null, null, null) : null;
        Date createdAt = source.getCreatedAt();
        Date updatedAt = source.getUpdatedAt();
        Date contentCreatedAt = source.getContentCreatedAt();
        Date contentUpdatedAt = source.getContentUpdatedAt();
        long longOrDefault = NumberUtils.INSTANCE.toLongOrDefault(source.getSize(), 0L);
        GetItemQuery.PermissionsV2Api1 permissionsV2Api = source.getPermissionsV2Api();
        boolean zBooleanValue3 = (permissionsV2Api == null || (canInviteCollaborator = permissionsV2Api.getCanInviteCollaborator()) == null) ? false : canInviteCollaborator.booleanValue();
        GetItemQuery.PermissionsV2Api1 permissionsV2Api2 = source.getPermissionsV2Api();
        boolean zBooleanValue4 = (permissionsV2Api2 == null || (canComment = permissionsV2Api2.getCanComment()) == null) ? false : canComment.booleanValue();
        GetItemQuery.PermissionsV2Api1 permissionsV2Api3 = source.getPermissionsV2Api();
        boolean zBooleanValue5 = (permissionsV2Api3 == null || (canCreateAnnotations = permissionsV2Api3.getCanCreateAnnotations()) == null) ? false : canCreateAnnotations.booleanValue();
        GetItemQuery.PermissionsV2Api1 permissionsV2Api4 = source.getPermissionsV2Api();
        boolean zBooleanValue6 = (permissionsV2Api4 == null || (canDelete = permissionsV2Api4.getCanDelete()) == null) ? false : canDelete.booleanValue();
        GetItemQuery.PermissionsV2Api1 permissionsV2Api5 = source.getPermissionsV2Api();
        boolean zBooleanValue7 = (permissionsV2Api5 == null || (canDownload = permissionsV2Api5.getCanDownload()) == null) ? false : canDownload.booleanValue();
        GetItemQuery.PermissionsV2Api1 permissionsV2Api6 = source.getPermissionsV2Api();
        boolean zBooleanValue8 = (permissionsV2Api6 == null || (canPreview = permissionsV2Api6.getCanPreview()) == null) ? false : canPreview.booleanValue();
        GetItemQuery.PermissionsV2Api1 permissionsV2Api7 = source.getPermissionsV2Api();
        boolean zBooleanValue9 = (permissionsV2Api7 == null || (canRename = permissionsV2Api7.getCanRename()) == null) ? false : canRename.booleanValue();
        GetItemQuery.PermissionsV2Api1 permissionsV2Api8 = source.getPermissionsV2Api();
        boolean zBooleanValue10 = (permissionsV2Api8 == null || (canSetShareAccess = permissionsV2Api8.getCanSetShareAccess()) == null) ? false : canSetShareAccess.booleanValue();
        GetItemQuery.PermissionsV2Api1 permissionsV2Api9 = source.getPermissionsV2Api();
        boolean zBooleanValue11 = (permissionsV2Api9 == null || (canShare = permissionsV2Api9.getCanShare()) == null) ? false : canShare.booleanValue();
        GetItemQuery.PermissionsV2Api1 permissionsV2Api10 = source.getPermissionsV2Api();
        boolean zBooleanValue12 = (permissionsV2Api10 == null || (canUpload = permissionsV2Api10.getCanUpload()) == null) ? false : canUpload.booleanValue();
        GetItemQuery.PermissionsV2Api1 permissionsV2Api11 = source.getPermissionsV2Api();
        PermissionsModel permissionsModel = new PermissionsModel(zBooleanValue6, zBooleanValue9, zBooleanValue7, zBooleanValue8, zBooleanValue12, zBooleanValue4, zBooleanValue11, zBooleanValue3, zBooleanValue10, (permissionsV2Api11 == null || (canViewAnnotations = permissionsV2Api11.getCanViewAnnotations()) == null) ? false : canViewAnnotations.booleanValue(), zBooleanValue5, false, 2048, null);
        GetItemQuery.Parent1 parent = source.getParent();
        if (parent != null) {
            arrayList = null;
            folderModel = (FolderModel) GraphQLMapper.fromGraphQL$default(GQLGetCollectionItemsQueryOnFolderToFolderModelMapper.INSTANCE, new GetCollectionItemsQuery.OnFolder(parent.getId(), ItemType.folder, parent.getName(), null, null, null, null, null, null, null, null, null, null, null, null), null, 2, null);
        } else {
            arrayList = null;
            folderModel = null;
        }
        GetItemQuery.ItemCollectionConnection1 itemCollectionConnection = source.getItemCollectionConnection();
        if (itemCollectionConnection == null || (edges = itemCollectionConnection.getEdges()) == null) {
            arrayList2 = arrayList;
        } else {
            List<GetItemQuery.Edge1> list = edges;
            ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator it = list.iterator();
            while (it.hasNext()) {
                GetItemQuery.Edge1 edge1 = (GetItemQuery.Edge1) it.next();
                String id = edge1.getNode().getId();
                String name2 = edge1.getNode().getName();
                String str2 = name2 == null ? "" : name2;
                String collectionType = edge1.getNode().getCollectionType();
                Iterator it2 = it;
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
                arrayList3.add(new CollectionModel(id, collectionTypeValueOf, str2, null, null));
                it = it2;
            }
            arrayList2 = arrayList3;
        }
        Boolean boolIsRooted = source.isRooted();
        return new FolderModel(itemIdCreateItemId, str, zBooleanValue, zBooleanValue2, folderModel, userModel, userModel2, createdAt, contentCreatedAt, updatedAt, contentUpdatedAt, boolIsRooted != null ? boolIsRooted.booleanValue() : false, Long.valueOf(longOrDefault), permissionsModel, null, arrayList2, GQLSharedLinkFragmentToSharedLinkModelMapper.INSTANCE.fromGetItemQueryFolder(source.getSharedLink()), null, source.getDescription(), 131072, null);
    }
}
