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
import com.box.android.domain.models.item.WebLinkModel;
import com.box.androidsdk.content.models.BoxBookmark;
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
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: WebLinkModelMapper.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u0005*\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bJ\u0016\u0010\t\u001a\u00020\u0006*\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\bH\u0007¨\u0006\u000b"}, d2 = {"Lcom/box/android/domain/mappers/WebLinkModelMapper;", "", "<init>", "()V", "toWebLinkModel", "Lcom/box/android/domain/models/item/WebLinkModel;", "Lcom/box/androidsdk/content/models/BoxBookmark;", "shouldAssignParent", "", "toBoxBookmark", "supportLegacy", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class WebLinkModelMapper {
    public static final WebLinkModelMapper INSTANCE = new WebLinkModelMapper();

    private WebLinkModelMapper() {
    }

    public static /* synthetic */ WebLinkModel toWebLinkModel$default(WebLinkModelMapper webLinkModelMapper, BoxBookmark boxBookmark, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return webLinkModelMapper.toWebLinkModel(boxBookmark, z);
    }

    public final WebLinkModel toWebLinkModel(BoxBookmark boxBookmark, boolean z) {
        ItemId itemId;
        ArrayList arrayList;
        ArrayList arrayList2;
        Iterable<BoxFolder> entries;
        BoxFolder parent;
        Intrinsics.checkNotNullParameter(boxBookmark, "<this>");
        BoxUser ownedBy = boxBookmark.getOwnedBy();
        UserModel userModel = ownedBy != null ? UserModelMapper.INSTANCE.toUserModel(ownedBy) : null;
        EnumSet<BoxItem.Permission> permissions = boxBookmark.getPermissions();
        PermissionsModel permissionsModel = permissions != null ? PermissionsModelMapper.INSTANCE.toPermissionsModel(permissions) : null;
        WebLinkModel.Companion companion = WebLinkModel.INSTANCE;
        String id = boxBookmark.getUserId();
        Intrinsics.checkNotNullExpressionValue(id, "getId(...)");
        ItemId itemIdCreateItemId = companion.createItemId(id);
        String name = boxBookmark.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        BoxUser modifiedBy = boxBookmark.getModifiedBy();
        UserModel userModel2 = modifiedBy != null ? UserModelMapper.INSTANCE.toUserModel(modifiedBy) : null;
        BoxIterator<BoxFolder> pathCollection = boxBookmark.getPathCollection();
        Collection entries2 = pathCollection != null ? pathCollection.getEntries() : null;
        boolean zAreEqual = (entries2 == null || entries2.isEmpty()) ? false : Intrinsics.areEqual(((BoxFolder) boxBookmark.getPathCollection().getEntries().get(0)).getUserId(), "0");
        FolderModel folderModel = (!z || (parent = boxBookmark.getParent()) == null) ? null : FolderModelMapper.INSTANCE.toFolderModel(parent, false);
        Date createdAt = boxBookmark.getCreatedAt();
        Date modifiedAt = boxBookmark.getModifiedAt();
        String url = boxBookmark.getUrl();
        BoxIterator<BoxFolder> pathCollection2 = boxBookmark.getPathCollection();
        if (pathCollection2 == null || (entries = pathCollection2.getEntries()) == null) {
            itemId = itemIdCreateItemId;
            arrayList = null;
        } else {
            ArrayList arrayList3 = new ArrayList();
            for (BoxFolder boxFolder : entries) {
                String id2 = boxFolder.getUserId();
                Intrinsics.checkNotNullExpressionValue(id2, "getId(...)");
                ItemId itemId2 = itemIdCreateItemId;
                ItemId.Remote remote = new ItemId.Remote(id2, ItemType.FOLDER);
                String name2 = boxFolder.getName();
                if (name2 == null) {
                    name2 = "";
                }
                arrayList3.add(new PathCollectionEntry(remote, name2));
                itemIdCreateItemId = itemId2;
            }
            itemId = itemIdCreateItemId;
            arrayList = arrayList3;
        }
        List<BoxCollection> collections = boxBookmark.getCollections();
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
        String description = boxBookmark.getDescription();
        BoxSharedLink sharedLink = boxBookmark.getSharedLink();
        return new WebLinkModel(itemId, name, false, false, folderModel, userModel, userModel2, createdAt, null, modifiedAt, null, zAreEqual, permissionsModel, arrayList, url, sharedLink != null ? SharedLinkModelMapper.INSTANCE.toSharedLinkModel(sharedLink) : null, arrayList2, description, 1280, null);
    }

    public static /* synthetic */ BoxBookmark toBoxBookmark$default(WebLinkModelMapper webLinkModelMapper, WebLinkModel webLinkModel, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return webLinkModelMapper.toBoxBookmark(webLinkModel, z);
    }

    @Deprecated(message = "Refactor legacy code to use WeblinkModel instead")
    public final BoxBookmark toBoxBookmark(WebLinkModel webLinkModel, boolean z) {
        Intrinsics.checkNotNullParameter(webLinkModel, "<this>");
        JsonObject jsonObject = new JsonObject();
        WebLinkModel webLinkModel2 = webLinkModel;
        jsonObject.add("id", ItemModelMapperKt.toBoxItemId(webLinkModel2));
        jsonObject.add("name", webLinkModel.getName());
        jsonObject.add("description", webLinkModel.getDescription());
        FolderModel parentFolder = webLinkModel.getParentFolder();
        if (parentFolder != null) {
            jsonObject.add("parent", BoxFolder.createFromIdAndName(ItemModelMapperKt.toBoxItemId(parentFolder), parentFolder.getName()).toJsonObject());
        }
        UserModel owner = webLinkModel.getOwner();
        if (owner != null) {
            jsonObject.add(BoxItem.FIELD_OWNED_BY, BoxUser.createFromId(owner.getId()).toJsonObject().add("name", owner.getName()));
        }
        UserModel updatedBy = webLinkModel.getUpdatedBy();
        if (updatedBy != null) {
            jsonObject.add("modified_by", BoxUser.createFromId(updatedBy.getId()).toJsonObject().add("name", updatedBy.getName()));
        }
        Date createdDate = webLinkModel.getCreatedDate();
        if (createdDate != null) {
            jsonObject.add("created_at", BoxDateFormat.format(createdDate));
        }
        Date modifiedDate = webLinkModel.getModifiedDate();
        if (modifiedDate != null) {
            jsonObject.add("modified_at", BoxDateFormat.format(modifiedDate));
        }
        PermissionsModel permissions = webLinkModel.getPermissions();
        if (permissions != null) {
            jsonObject.add("permissions", JsonObject.readFrom(PermissionsModelMapper.INSTANCE.toJsonString(permissions)));
        }
        jsonObject.add("type", BoxBookmark.TYPE);
        String url = webLinkModel.getUrl();
        if (url != null) {
            jsonObject.add("url", url);
        }
        List<PathCollectionEntry> pathCollection = webLinkModel.getPathCollection();
        if (pathCollection == null) {
            pathCollection = z ? ItemModel.INSTANCE.buildApproximateLegacyPathCollection(webLinkModel2) : null;
        }
        if (pathCollection != null) {
            jsonObject.add(BoxItem.FIELD_PATH_COLLECTION, JsonObject.readFrom(PathCollectionEntryMapper.INSTANCE.toJsonString(pathCollection)));
        }
        List<CollectionModel> collections = webLinkModel.getCollections();
        if (collections != null) {
            jsonObject.add(BoxItem.FIELD_COLLECTIONS, CollectionMapperUtil.INSTANCE.transformCollectionModelsToBoxCollections(collections));
        }
        SharedLinkModel sharedLink = webLinkModel.getSharedLink();
        if (sharedLink != null) {
            jsonObject.add("shared_link", SharedLinkModelMapper.INSTANCE.toBoxSharedLink(sharedLink).toJsonObject());
        }
        BoxEntity boxEntityCreateEntityFromJson = BoxItem.createEntityFromJson(jsonObject);
        Intrinsics.checkNotNull(boxEntityCreateEntityFromJson, "null cannot be cast to non-null type com.box.androidsdk.content.models.BoxBookmark");
        return (BoxBookmark) boxEntityCreateEntityFromJson;
    }
}
