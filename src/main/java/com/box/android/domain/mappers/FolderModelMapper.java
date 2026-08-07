package com.box.android.domain.mappers;

import com.box.android.domain.models.CollectionModel;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.models.item.FolderModel;
import com.box.android.domain.models.item.ItemModel;
import com.box.android.domain.models.item.ItemType;
import com.box.android.domain.models.item.PathCollectionEntry;
import com.box.android.domain.models.item.PermissionsModel;
import com.box.android.domain.models.item.SharedLinkModel;
import com.box.android.domain.models.item.UserModel;
import com.box.androidsdk.content.models.BoxCollaborationItem;
import com.box.androidsdk.content.models.BoxCollection;
import com.box.androidsdk.content.models.BoxEntity;
import com.box.androidsdk.content.models.BoxFolder;
import com.box.androidsdk.content.models.BoxItem;
import com.box.androidsdk.content.models.BoxIterator;
import com.box.androidsdk.content.models.BoxSharedLink;
import com.box.androidsdk.content.models.BoxUser;
import com.box.androidsdk.content.utils.BoxDateFormat;
import com.eclipsesource.json.JsonObject;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FolderModelMapper.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u0005*\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bJ\u0016\u0010\t\u001a\u00020\u0006*\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\bH\u0007¨\u0006\u000b"}, d2 = {"Lcom/box/android/domain/mappers/FolderModelMapper;", "", "<init>", "()V", "toFolderModel", "Lcom/box/android/domain/models/item/FolderModel;", "Lcom/box/androidsdk/content/models/BoxFolder;", "shouldAssignParent", "", "toBoxFolder", "supportLegacy", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class FolderModelMapper {
    public static final FolderModelMapper INSTANCE = new FolderModelMapper();

    private FolderModelMapper() {
    }

    public static /* synthetic */ FolderModel toFolderModel$default(FolderModelMapper folderModelMapper, BoxFolder boxFolder, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return folderModelMapper.toFolderModel(boxFolder, z);
    }

    public final FolderModel toFolderModel(BoxFolder boxFolder, boolean z) {
        String str;
        ArrayList arrayList;
        ArrayList arrayList2;
        Iterable entries;
        BoxFolder parent;
        Intrinsics.checkNotNullParameter(boxFolder, "<this>");
        BoxUser ownedBy = boxFolder.getOwnedBy();
        UserModel userModel = ownedBy != null ? UserModelMapper.INSTANCE.toUserModel(ownedBy) : null;
        EnumSet<BoxItem.Permission> permissions = boxFolder.getPermissions();
        PermissionsModel permissionsModel = permissions != null ? PermissionsModelMapper.INSTANCE.toPermissionsModel(permissions) : null;
        FolderModel.Companion companion = FolderModel.INSTANCE;
        String id = boxFolder.getUserId();
        String str2 = "getId(...)";
        Intrinsics.checkNotNullExpressionValue(id, "getId(...)");
        ItemId itemIdCreateItemId = companion.createItemId(id);
        String name = boxFolder.getName();
        if (name == null) {
            name = "";
        }
        Boolean hasCollaborations = boxFolder.getHasCollaborations();
        boolean zAreEqual = false;
        boolean zBooleanValue = hasCollaborations != null ? hasCollaborations.booleanValue() : false;
        Boolean isExternallyOwned = boxFolder.getIsExternallyOwned();
        boolean zBooleanValue2 = isExternallyOwned != null ? isExternallyOwned.booleanValue() : false;
        FolderModel folderModel = (!z || (parent = boxFolder.getParent()) == null) ? null : toFolderModel(parent, false);
        BoxUser modifiedBy = boxFolder.getModifiedBy();
        UserModel userModel2 = modifiedBy != null ? UserModelMapper.INSTANCE.toUserModel(modifiedBy) : null;
        Date createdAt = boxFolder.getCreatedAt();
        boolean z2 = zBooleanValue2;
        FolderModel folderModel2 = folderModel;
        UserModel userModel3 = userModel2;
        Date contentCreatedAt = boxFolder.getContentCreatedAt();
        Date modifiedAt = boxFolder.getModifiedAt();
        Date contentModifiedAt = boxFolder.getContentModifiedAt();
        BoxIterator<BoxFolder> pathCollection = boxFolder.getPathCollection();
        Collection entries2 = pathCollection != null ? pathCollection.getEntries() : null;
        if (entries2 != null && !entries2.isEmpty()) {
            zAreEqual = Intrinsics.areEqual(((BoxFolder) boxFolder.getPathCollection().getEntries().get(0)).getUserId(), "0");
        }
        Long size = boxFolder.getSize();
        BoxIterator<BoxFolder> pathCollection2 = boxFolder.getPathCollection();
        if (pathCollection2 == null || (entries = pathCollection2.getEntries()) == null) {
            str = name;
            arrayList = null;
        } else {
            ArrayList arrayList3 = new ArrayList();
            Iterator it = entries.iterator();
            while (it.hasNext()) {
                BoxFolder boxFolder2 = (BoxFolder) it.next();
                Iterator it2 = it;
                String str3 = name;
                String id2 = boxFolder2.getUserId();
                Intrinsics.checkNotNullExpressionValue(id2, str2);
                String str4 = str2;
                ItemId.Remote remote = new ItemId.Remote(id2, ItemType.FOLDER);
                String name2 = boxFolder2.getName();
                if (name2 == null) {
                    name2 = "";
                }
                arrayList3.add(new PathCollectionEntry(remote, name2));
                it = it2;
                name = str3;
                str2 = str4;
            }
            str = name;
            arrayList = arrayList3;
        }
        List<BoxCollection> collections = boxFolder.getCollections();
        if (collections != null) {
            List<BoxCollection> list = collections;
            ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            for (BoxCollection boxCollection : list) {
                CollectionModelMapper collectionModelMapper = CollectionModelMapper.INSTANCE;
                Intrinsics.checkNotNull(boxCollection);
                arrayList4.add(collectionModelMapper.toCollectionModel(boxCollection));
            }
            arrayList2 = arrayList4;
        } else {
            arrayList2 = null;
        }
        BoxSharedLink sharedLink = boxFolder.getSharedLink();
        return new FolderModel(itemIdCreateItemId, str, zBooleanValue, z2, folderModel2, userModel, userModel3, createdAt, contentCreatedAt, modifiedAt, contentModifiedAt, zAreEqual, size, permissionsModel, arrayList, arrayList2, sharedLink != null ? SharedLinkModelMapper.INSTANCE.toSharedLinkModel(sharedLink) : null, null, boxFolder.getDescription(), 131072, null);
    }

    public static /* synthetic */ BoxFolder toBoxFolder$default(FolderModelMapper folderModelMapper, FolderModel folderModel, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return folderModelMapper.toBoxFolder(folderModel, z);
    }

    @Deprecated(message = "Refactor legacy code to use FolderModel instead")
    public final BoxFolder toBoxFolder(FolderModel folderModel, boolean z) {
        Intrinsics.checkNotNullParameter(folderModel, "<this>");
        JsonObject jsonObject = new JsonObject();
        FolderModel folderModel2 = folderModel;
        jsonObject.add("id", ItemModelMapperKt.toBoxItemId(folderModel2));
        jsonObject.add("name", folderModel.getName());
        jsonObject.add(BoxCollaborationItem.FIELD_HAS_COLLABORATIONS, folderModel.getHasCollaborations());
        jsonObject.add(BoxCollaborationItem.FIELD_IS_EXTERNALLY_OWNED, folderModel.isExternallyOwned());
        jsonObject.add("description", folderModel.getDescription());
        FolderModel parentFolder = folderModel.getParentFolder();
        if (parentFolder != null) {
            jsonObject.add("parent", BoxFolder.createFromIdAndName(ItemModelMapperKt.toBoxItemId(parentFolder), parentFolder.getName()).toJsonObject());
        }
        UserModel owner = folderModel.getOwner();
        if (owner != null) {
            jsonObject.add(BoxItem.FIELD_OWNED_BY, BoxUser.createFromId(owner.getId()).toJsonObject().add("name", owner.getName()));
        }
        UserModel updatedBy = folderModel.getUpdatedBy();
        if (updatedBy != null) {
            jsonObject.add("modified_by", BoxUser.createFromId(updatedBy.getId()).toJsonObject().add("name", updatedBy.getName()));
        }
        Date createdDate = folderModel.getCreatedDate();
        if (createdDate != null) {
            jsonObject.add("created_at", BoxDateFormat.format(createdDate));
        }
        Date modifiedDate = folderModel.getModifiedDate();
        if (modifiedDate != null) {
            jsonObject.add("modified_at", BoxDateFormat.format(modifiedDate));
        }
        Date contentCreatedDate = folderModel.getContentCreatedDate();
        if (contentCreatedDate != null) {
            jsonObject.add("content_created_at", BoxDateFormat.format(contentCreatedDate));
        }
        Date contentModifiedDate = folderModel.getContentModifiedDate();
        if (contentModifiedDate != null) {
            jsonObject.add("content_modified_at", BoxDateFormat.format(contentModifiedDate));
        }
        Long size = folderModel.getSize();
        if (size != null) {
            jsonObject.add("size", size.longValue());
        }
        PermissionsModel permissions = folderModel.getPermissions();
        if (permissions != null) {
            jsonObject.add("permissions", JsonObject.readFrom(PermissionsModelMapper.INSTANCE.toJsonString(permissions)));
        }
        jsonObject.add("type", "folder");
        List<PathCollectionEntry> pathCollection = folderModel.getPathCollection();
        if (pathCollection == null) {
            pathCollection = z ? ItemModel.INSTANCE.buildApproximateLegacyPathCollection(folderModel2) : null;
        }
        if (pathCollection != null) {
            jsonObject.add(BoxItem.FIELD_PATH_COLLECTION, JsonObject.readFrom(PathCollectionEntryMapper.INSTANCE.toJsonString(pathCollection)));
        }
        List<CollectionModel> collections = folderModel.getCollections();
        if (collections != null) {
            jsonObject.add(BoxItem.FIELD_COLLECTIONS, CollectionMapperUtil.INSTANCE.transformCollectionModelsToBoxCollections(collections));
        }
        SharedLinkModel sharedLink = folderModel.getSharedLink();
        if (sharedLink != null) {
            jsonObject.add("shared_link", SharedLinkModelMapper.INSTANCE.toBoxSharedLink(sharedLink).toJsonObject());
        }
        BoxEntity boxEntityCreateEntityFromJson = BoxFolder.createEntityFromJson(jsonObject);
        Intrinsics.checkNotNull(boxEntityCreateEntityFromJson, "null cannot be cast to non-null type com.box.androidsdk.content.models.BoxFolder");
        return (BoxFolder) boxEntityCreateEntityFromJson;
    }
}
