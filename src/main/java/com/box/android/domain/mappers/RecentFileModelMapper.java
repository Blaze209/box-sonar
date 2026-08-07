package com.box.android.domain.mappers;

import com.box.android.domain.models.CollectionModel;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.models.RepresentationModel;
import com.box.android.domain.models.SharedLinkPermissionOptionType;
import com.box.android.domain.models.item.FileLockModel;
import com.box.android.domain.models.item.FileModel;
import com.box.android.domain.models.item.FileVersionMiniModel;
import com.box.android.domain.models.item.FolderModel;
import com.box.android.domain.models.item.ItemType;
import com.box.android.domain.models.item.PathCollectionEntry;
import com.box.android.domain.models.item.PermissionsModel;
import com.box.android.domain.models.item.RecentFileModel;
import com.box.android.domain.models.item.RecentItemModel;
import com.box.android.domain.models.item.SharedLinkModel;
import com.box.android.domain.models.item.UserModel;
import com.box.android.domain.models.item.WatermarkModel;
import com.box.android.domain.usecases.InteractionType;
import com.box.androidsdk.content.models.BoxCollaborationItem;
import com.box.androidsdk.content.models.BoxCollection;
import com.box.androidsdk.content.models.BoxEntity;
import com.box.androidsdk.content.models.BoxFile;
import com.box.androidsdk.content.models.BoxFileVersion;
import com.box.androidsdk.content.models.BoxFolder;
import com.box.androidsdk.content.models.BoxItem;
import com.box.androidsdk.content.models.BoxIterator;
import com.box.androidsdk.content.models.BoxIteratorRepresentations;
import com.box.androidsdk.content.models.BoxLock;
import com.box.androidsdk.content.models.BoxRecentItem;
import com.box.androidsdk.content.models.BoxRepresentation;
import com.box.androidsdk.content.models.BoxSharedLink;
import com.box.androidsdk.content.models.BoxUser;
import com.box.androidsdk.content.models.BoxWatermark;
import com.box.androidsdk.content.utils.BoxDateFormat;
import com.box.boxandroidlibv2private.model.BoxRecentBoxFile;
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

/* JADX INFO: compiled from: RecentFileModelMapper.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u0005*\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bJ\f\u0010\t\u001a\u00020\u0006*\u00020\u0005H\u0007J\u0012\u0010\u0004\u001a\u00020\u0005*\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\n\u0010\r\u001a\u00020\n*\u00020\u0005¨\u0006\u000e"}, d2 = {"Lcom/box/android/domain/mappers/RecentFileModelMapper;", "", "<init>", "()V", "toRecentFileModel", "Lcom/box/android/domain/models/item/RecentFileModel;", "Lcom/box/boxandroidlibv2private/model/BoxRecentBoxFile;", "shouldAssignParent", "", "toBoxRecentFile", "Lcom/box/android/domain/models/item/FileModel;", "interactionModel", "Lcom/box/android/domain/models/item/RecentItemModel;", "toFileModel", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class RecentFileModelMapper {
    public static final RecentFileModelMapper INSTANCE = new RecentFileModelMapper();

    private RecentFileModelMapper() {
    }

    public static /* synthetic */ RecentFileModel toRecentFileModel$default(RecentFileModelMapper recentFileModelMapper, BoxRecentBoxFile boxRecentBoxFile, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return recentFileModelMapper.toRecentFileModel(boxRecentBoxFile, z);
    }

    public final RecentFileModel toRecentFileModel(BoxRecentBoxFile boxRecentBoxFile, boolean z) {
        FolderModel folderModel;
        boolean z2;
        ArrayList arrayList;
        ArrayList arrayList2;
        Long lValueOf;
        InteractionType next;
        ArrayList arrayList3;
        ArrayList<BoxRepresentation> entries;
        Iterable entries2;
        BoxFolder parent;
        BoxRecentBoxFile boxRecentBoxFile2 = boxRecentBoxFile;
        Intrinsics.checkNotNullParameter(boxRecentBoxFile2, "<this>");
        BoxUser ownedBy = boxRecentBoxFile2.getOwnedBy();
        UserModel userModel = ownedBy != null ? UserModelMapper.INSTANCE.toUserModel(ownedBy) : null;
        EnumSet<BoxItem.Permission> permissions = boxRecentBoxFile2.getPermissions();
        PermissionsModel permissionsModel = permissions != null ? PermissionsModelMapper.INSTANCE.toPermissionsModel(permissions) : null;
        ArrayList<BoxSharedLink.Permission> sharedLinkPermissionOptions = boxRecentBoxFile2.getSharedLinkPermissionOptions();
        List<SharedLinkPermissionOptionType> sharedLinkPermissionModel = sharedLinkPermissionOptions != null ? SharedLinkPermissionsModelMapper.INSTANCE.toSharedLinkPermissionModel(sharedLinkPermissionOptions) : null;
        FileModel.Companion companion = FileModel.INSTANCE;
        String id = boxRecentBoxFile2.getUserId();
        String str = "getId(...)";
        Intrinsics.checkNotNullExpressionValue(id, "getId(...)");
        ItemId itemIdCreateItemId = companion.createItemId(id);
        String name = boxRecentBoxFile2.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        Boolean hasCollaborations = boxRecentBoxFile2.getHasCollaborations();
        boolean zBooleanValue = hasCollaborations != null ? hasCollaborations.booleanValue() : false;
        Boolean isExternallyOwned = boxRecentBoxFile2.getIsExternallyOwned();
        boolean zBooleanValue2 = isExternallyOwned != null ? isExternallyOwned.booleanValue() : false;
        BoxUser modifiedBy = boxRecentBoxFile2.getModifiedBy();
        UserModel userModel2 = modifiedBy != null ? UserModelMapper.INSTANCE.toUserModel(modifiedBy) : null;
        Date createdAt = boxRecentBoxFile2.getCreatedAt();
        Date modifiedAt = boxRecentBoxFile2.getModifiedAt();
        Date contentCreatedAt = boxRecentBoxFile2.getContentCreatedAt();
        Date contentModifiedAt = boxRecentBoxFile2.getContentModifiedAt();
        BoxIterator<BoxFolder> pathCollection = boxRecentBoxFile2.getPathCollection();
        Collection entries3 = pathCollection != null ? pathCollection.getEntries() : null;
        boolean zAreEqual = (entries3 == null || entries3.isEmpty()) ? false : Intrinsics.areEqual(((BoxFolder) boxRecentBoxFile2.getPathCollection().getEntries().get(0)).getUserId(), "0");
        Long size = boxRecentBoxFile2.getSize();
        long jLongValue = size != null ? size.longValue() : 0L;
        String sha1 = boxRecentBoxFile2.getSha1();
        Intrinsics.checkNotNullExpressionValue(sha1, "getSha1(...)");
        BoxWatermark watermark = boxRecentBoxFile2.getWatermark();
        WatermarkModel watermarkModel = watermark != null ? WatermarkModelMapper.INSTANCE.toWatermarkModel(watermark) : null;
        BoxFileVersion fileVersion = boxRecentBoxFile2.getFileVersion();
        FileVersionMiniModel fileVersionMiniModel = fileVersion != null ? FileVersionMiniModelMapper.INSTANCE.toFileVersionMiniModel(fileVersion) : null;
        FolderModel folderModel2 = (!z || (parent = boxRecentBoxFile2.getParent()) == null) ? null : FolderModelMapper.INSTANCE.toFolderModel(parent, false);
        BoxIterator<BoxFolder> pathCollection2 = boxRecentBoxFile2.getPathCollection();
        if (pathCollection2 == null || (entries2 = pathCollection2.getEntries()) == null) {
            folderModel = folderModel2;
            z2 = zBooleanValue;
            arrayList = null;
        } else {
            ArrayList arrayList4 = new ArrayList();
            Iterator it = entries2.iterator();
            while (it.hasNext()) {
                BoxFolder boxFolder = (BoxFolder) it.next();
                Iterator it2 = it;
                FolderModel folderModel3 = folderModel2;
                boolean z3 = zBooleanValue;
                String id2 = boxFolder.getUserId();
                Intrinsics.checkNotNullExpressionValue(id2, str);
                String str2 = str;
                ItemId.Remote remote = new ItemId.Remote(id2, ItemType.FOLDER);
                String name2 = boxFolder.getName();
                if (name2 == null) {
                    name2 = "";
                }
                arrayList4.add(new PathCollectionEntry(remote, name2));
                it = it2;
                folderModel2 = folderModel3;
                zBooleanValue = z3;
                str = str2;
            }
            folderModel = folderModel2;
            z2 = zBooleanValue;
            arrayList = arrayList4;
        }
        List<BoxCollection> collections = boxRecentBoxFile2.getCollections();
        if (collections != null) {
            List<BoxCollection> list = collections;
            ArrayList arrayList5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            for (BoxCollection boxCollection : list) {
                CollectionModelMapper collectionModelMapper = CollectionModelMapper.INSTANCE;
                Intrinsics.checkNotNull(boxCollection);
                arrayList5.add(collectionModelMapper.toCollectionModel(boxCollection));
            }
            arrayList2 = arrayList5;
        } else {
            arrayList2 = null;
        }
        BoxLock lock = boxRecentBoxFile2.getLock();
        FileLockModel fileLockModel = lock != null ? FileLockModelMapper.INSTANCE.toFileLockModel(lock) : null;
        long j = jLongValue;
        ArrayList arrayList6 = arrayList;
        boolean z4 = z2;
        Long commentCount = boxRecentBoxFile2.getCommentCount();
        Long commentCount2 = boxRecentBoxFile2.getCommentCount(true);
        if (commentCount2 != null) {
            long jLongValue2 = commentCount2.longValue();
            Long commentCount3 = boxRecentBoxFile2.getCommentCount(false);
            lValueOf = Long.valueOf(jLongValue2 - (commentCount3 != null ? commentCount3.longValue() : 0L));
        } else {
            lValueOf = null;
        }
        Iterator<InteractionType> it3 = InteractionType.getEntries().iterator();
        while (true) {
            if (!it3.hasNext()) {
                next = null;
                break;
            }
            next = it3.next();
            String value = next.getValue();
            BoxRecentItem recentItem = boxRecentBoxFile2.getRecentItem();
            if (Intrinsics.areEqual(value, recentItem != null ? recentItem.getInteractionType() : null)) {
                break;
            }
            boxRecentBoxFile2 = boxRecentBoxFile;
        }
        InteractionType interactionType = next;
        if (interactionType == null) {
            interactionType = InteractionType.PREVIEW;
        }
        BoxRecentItem recentItem2 = boxRecentBoxFile.getRecentItem();
        Date interactedAt = recentItem2 != null ? recentItem2.getInteractedAt() : null;
        BoxRecentItem recentItem3 = boxRecentBoxFile.getRecentItem();
        RecentItemModel recentItemModel = new RecentItemModel(interactionType, interactedAt, recentItem3 != null ? recentItem3.getInteractionSharedLink() : null);
        BoxIteratorRepresentations representations = boxRecentBoxFile.getRepresentations();
        if (representations == null || (entries = representations.getEntries()) == null) {
            arrayList3 = null;
        } else {
            ArrayList arrayList7 = new ArrayList();
            Iterator it4 = entries.iterator();
            while (it4.hasNext()) {
                BoxRepresentation boxRepresentation = (BoxRepresentation) it4.next();
                Iterator it5 = it4;
                RepresentationsModelMapper representationsModelMapper = RepresentationsModelMapper.INSTANCE;
                Intrinsics.checkNotNull(boxRepresentation);
                RepresentationModel representationModel = representationsModelMapper.toRepresentationModel(boxRepresentation);
                if (representationModel != null) {
                    arrayList7.add(representationModel);
                }
                it4 = it5;
            }
            arrayList3 = arrayList7;
        }
        String description = boxRecentBoxFile.getDescription();
        BoxSharedLink sharedLink = boxRecentBoxFile.getSharedLink();
        return new RecentFileModel(itemIdCreateItemId, name, z4, zBooleanValue2, folderModel, userModel, userModel2, createdAt, contentCreatedAt, modifiedAt, contentModifiedAt, zAreEqual, j, permissionsModel, arrayList6, arrayList2, sharedLink != null ? SharedLinkModelMapper.INSTANCE.toSharedLinkModel(sharedLink) : null, arrayList3, sharedLinkPermissionModel, sha1, watermarkModel, fileVersionMiniModel, fileLockModel, commentCount, lValueOf, recentItemModel, description);
    }

    @Deprecated(message = "Refactor legacy code to use RecentFileModel instead")
    public final BoxRecentBoxFile toBoxRecentFile(RecentFileModel recentFileModel) {
        Intrinsics.checkNotNullParameter(recentFileModel, "<this>");
        JsonObject jsonObject = new JsonObject();
        JsonObject jsonObject2 = new JsonObject();
        jsonObject.add("id", ItemModelMapperKt.toBoxItemId(recentFileModel));
        jsonObject.add("name", recentFileModel.getName());
        jsonObject.add(BoxCollaborationItem.FIELD_HAS_COLLABORATIONS, recentFileModel.getHasCollaborations());
        jsonObject.add(BoxCollaborationItem.FIELD_IS_EXTERNALLY_OWNED, recentFileModel.isExternallyOwned());
        FolderModel parentFolder = recentFileModel.getParentFolder();
        if (parentFolder != null) {
            jsonObject.add("parent", BoxFolder.createFromIdAndName(ItemModelMapperKt.toBoxItemId(parentFolder), parentFolder.getName()).toJsonObject());
        }
        UserModel owner = recentFileModel.getOwner();
        if (owner != null) {
            jsonObject.add(BoxItem.FIELD_OWNED_BY, BoxUser.createFromId(owner.getId()).toJsonObject().add("name", owner.getName()));
        }
        UserModel updatedBy = recentFileModel.getUpdatedBy();
        if (updatedBy != null) {
            jsonObject.add("modified_by", BoxUser.createFromId(updatedBy.getId()).toJsonObject().add("name", updatedBy.getName()));
        }
        Date createdDate = recentFileModel.getCreatedDate();
        if (createdDate != null) {
            jsonObject.add("created_at", BoxDateFormat.format(createdDate));
        }
        Date modifiedDate = recentFileModel.getModifiedDate();
        if (modifiedDate != null) {
            jsonObject.add("modified_at", BoxDateFormat.format(modifiedDate));
        }
        Date contentCreatedDate = recentFileModel.getContentCreatedDate();
        if (contentCreatedDate != null) {
            jsonObject.add("content_created_at", BoxDateFormat.format(contentCreatedDate));
        }
        Date contentModifiedDate = recentFileModel.getContentModifiedDate();
        if (contentModifiedDate != null) {
            jsonObject.add("content_modified_at", BoxDateFormat.format(contentModifiedDate));
        }
        jsonObject.add("size", recentFileModel.getSize().longValue());
        PermissionsModel permissions = recentFileModel.getPermissions();
        if (permissions != null) {
            jsonObject.add("permissions", JsonObject.readFrom(PermissionsModelMapper.INSTANCE.toJsonString(permissions)));
        }
        jsonObject.add("type", "file");
        jsonObject.add("sha1", recentFileModel.getSha1());
        FileVersionMiniModel fileVersion = recentFileModel.getFileVersion();
        if (fileVersion != null) {
            jsonObject.add("file_version", JsonObject.readFrom(FileVersionMiniModelMapper.INSTANCE.toJsonString(fileVersion)));
        }
        List<PathCollectionEntry> pathCollection = recentFileModel.getPathCollection();
        if (pathCollection != null) {
            jsonObject.add(BoxItem.FIELD_PATH_COLLECTION, JsonObject.readFrom(PathCollectionEntryMapper.INSTANCE.toJsonString(pathCollection)));
        }
        List<CollectionModel> collections = recentFileModel.getCollections();
        if (collections != null) {
            jsonObject.add(BoxItem.FIELD_COLLECTIONS, CollectionMapperUtil.INSTANCE.transformCollectionModelsToBoxCollections(collections));
        }
        Long commentCount = recentFileModel.getCommentCount();
        if (commentCount != null) {
            jsonObject.add("comment_count", commentCount.longValue());
        }
        Long annotationCount = recentFileModel.getAnnotationCount();
        if (annotationCount != null) {
            jsonObject.add("annotation_count", annotationCount.longValue());
        }
        FileLockModel fileLock = recentFileModel.getFileLock();
        if (fileLock != null) {
            jsonObject.add(BoxFile.FIELD_LOCK, FileLockModelMapper.INSTANCE.toJsonObject(fileLock));
        }
        String description = recentFileModel.getDescription();
        if (description != null) {
            jsonObject.add("description", description);
        }
        List<RepresentationModel> representations = recentFileModel.getRepresentations();
        if (representations != null) {
            jsonObject.add(BoxFile.FIELD_REPRESENTATIONS, RepresentationsModelMapper.INSTANCE.toBoxIteratorRepresentations(representations).toJsonObject());
        }
        SharedLinkModel sharedLink = recentFileModel.getSharedLink();
        if (sharedLink != null) {
            jsonObject.add("shared_link", SharedLinkModelMapper.INSTANCE.toBoxSharedLink(sharedLink).toJsonObject());
        }
        WatermarkModel watermark = recentFileModel.getWatermark();
        if (watermark != null) {
            jsonObject.add(BoxFile.FIELD_WATERMARK, WatermarkModelMapper.INSTANCE.toJsonObject(watermark));
        }
        jsonObject2.add("interaction_type", recentFileModel.getRecentItem().getInteractionType().getValue());
        Date interactedAt = recentFileModel.getRecentItem().getInteractedAt();
        if (interactedAt != null) {
            jsonObject2.add("interacted_at", BoxDateFormat.format(interactedAt));
        }
        jsonObject2.add("interaction_shared_link", recentFileModel.getRecentItem().getInteractionSharedLink());
        BoxEntity boxEntityCreateEntityFromJson = BoxFile.createEntityFromJson(jsonObject);
        Intrinsics.checkNotNull(boxEntityCreateEntityFromJson, "null cannot be cast to non-null type com.box.androidsdk.content.models.BoxFile");
        return new BoxRecentBoxFile((BoxFile) boxEntityCreateEntityFromJson, new BoxRecentItem(jsonObject2));
    }

    public final RecentFileModel toRecentFileModel(FileModel fileModel, RecentItemModel interactionModel) {
        Intrinsics.checkNotNullParameter(fileModel, "<this>");
        Intrinsics.checkNotNullParameter(interactionModel, "interactionModel");
        return new RecentFileModel(fileModel.getItemId(), fileModel.getName(), fileModel.getHasCollaborations(), fileModel.isExternallyOwned(), fileModel.getParentFolder(), fileModel.getOwner(), fileModel.getUpdatedBy(), fileModel.getCreatedDate(), fileModel.getContentCreatedDate(), fileModel.getModifiedDate(), fileModel.getContentModifiedDate(), fileModel.isRooted(), fileModel.getSize().longValue(), fileModel.getPermissions(), fileModel.getPathCollection(), fileModel.getCollections(), fileModel.getSharedLink(), fileModel.getRepresentations(), fileModel.getSharedLinkPermissions(), fileModel.getSha1(), fileModel.getWatermark(), fileModel.getFileVersion(), fileModel.getFileLock(), fileModel.getCommentCount(), fileModel.getAnnotationCount(), interactionModel, fileModel.getDescription());
    }

    public final FileModel toFileModel(RecentFileModel recentFileModel) {
        Intrinsics.checkNotNullParameter(recentFileModel, "<this>");
        ItemId itemId = recentFileModel.getItemId();
        String name = recentFileModel.getName();
        boolean hasCollaborations = recentFileModel.getHasCollaborations();
        boolean zIsExternallyOwned = recentFileModel.isExternallyOwned();
        UserModel owner = recentFileModel.getOwner();
        Date createdDate = recentFileModel.getCreatedDate();
        Date modifiedDate = recentFileModel.getModifiedDate();
        Date contentCreatedDate = recentFileModel.getContentCreatedDate();
        Date contentModifiedDate = recentFileModel.getContentModifiedDate();
        boolean zIsRooted = recentFileModel.isRooted();
        long jLongValue = recentFileModel.getSize().longValue();
        PermissionsModel permissions = recentFileModel.getPermissions();
        String sha1 = recentFileModel.getSha1();
        WatermarkModel watermark = recentFileModel.getWatermark();
        FileVersionMiniModel fileVersion = recentFileModel.getFileVersion();
        FolderModel parentFolder = recentFileModel.getParentFolder();
        List<PathCollectionEntry> pathCollection = recentFileModel.getPathCollection();
        List<CollectionModel> collections = recentFileModel.getCollections();
        FileLockModel fileLock = recentFileModel.getFileLock();
        Long commentCount = recentFileModel.getCommentCount();
        Long annotationCount = recentFileModel.getAnnotationCount();
        List<SharedLinkPermissionOptionType> sharedLinkPermissions = recentFileModel.getSharedLinkPermissions();
        return new FileModel(itemId, name, hasCollaborations, zIsExternallyOwned, parentFolder, owner, recentFileModel.getUpdatedBy(), createdDate, contentCreatedDate, modifiedDate, contentModifiedDate, zIsRooted, jLongValue, permissions, pathCollection, collections, recentFileModel.getSharedLink(), recentFileModel.getRepresentations(), sharedLinkPermissions, sha1, fileVersion, fileLock, commentCount, annotationCount, null, watermark, recentFileModel.getDescription(), 16777216, null);
    }
}
