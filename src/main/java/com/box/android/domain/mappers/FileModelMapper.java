package com.box.android.domain.mappers;

import com.box.android.domain.models.ClassificationModel;
import com.box.android.domain.models.CollectionModel;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.models.RepresentationModel;
import com.box.android.domain.models.SharedLinkPermissionOptionType;
import com.box.android.domain.models.item.FileLockModel;
import com.box.android.domain.models.item.FileModel;
import com.box.android.domain.models.item.FileVersionMiniModel;
import com.box.android.domain.models.item.FolderModel;
import com.box.android.domain.models.item.ItemModel;
import com.box.android.domain.models.item.ItemType;
import com.box.android.domain.models.item.PathCollectionEntry;
import com.box.android.domain.models.item.PermissionsModel;
import com.box.android.domain.models.item.SharedLinkModel;
import com.box.android.domain.models.item.UserModel;
import com.box.android.domain.models.item.WatermarkModel;
import com.box.androidsdk.content.models.BoxClassification;
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
import com.box.androidsdk.content.models.BoxRepresentation;
import com.box.androidsdk.content.models.BoxSharedLink;
import com.box.androidsdk.content.models.BoxUser;
import com.box.androidsdk.content.models.BoxWatermark;
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

/* JADX INFO: compiled from: FileModelMapper.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u0005*\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bJ\u0016\u0010\t\u001a\u00020\u0006*\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\bH\u0007¨\u0006\u000b"}, d2 = {"Lcom/box/android/domain/mappers/FileModelMapper;", "", "<init>", "()V", "toFileModel", "Lcom/box/android/domain/models/item/FileModel;", "Lcom/box/androidsdk/content/models/BoxFile;", "shouldAssignParent", "", "toBoxFile", "supportLegacy", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class FileModelMapper {
    public static final FileModelMapper INSTANCE = new FileModelMapper();

    private FileModelMapper() {
    }

    public static /* synthetic */ FileModel toFileModel$default(FileModelMapper fileModelMapper, BoxFile boxFile, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return fileModelMapper.toFileModel(boxFile, z);
    }

    public final FileModel toFileModel(BoxFile boxFile, boolean z) {
        ItemId itemId;
        boolean z2;
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        Long lValueOf;
        ArrayList<BoxRepresentation> entries;
        Iterable entries2;
        BoxFolder parent;
        Intrinsics.checkNotNullParameter(boxFile, "<this>");
        BoxUser ownedBy = boxFile.getOwnedBy();
        UserModel userModel = ownedBy != null ? UserModelMapper.INSTANCE.toUserModel(ownedBy) : null;
        EnumSet<BoxItem.Permission> permissions = boxFile.getPermissions();
        PermissionsModel permissionsModel = permissions != null ? PermissionsModelMapper.INSTANCE.toPermissionsModel(permissions) : null;
        ArrayList<BoxSharedLink.Permission> sharedLinkPermissionOptions = boxFile.getSharedLinkPermissionOptions();
        List<SharedLinkPermissionOptionType> sharedLinkPermissionModel = sharedLinkPermissionOptions != null ? SharedLinkPermissionsModelMapper.INSTANCE.toSharedLinkPermissionModel(sharedLinkPermissionOptions) : null;
        FileModel.Companion companion = FileModel.INSTANCE;
        String id = boxFile.getUserId();
        String str = "getId(...)";
        Intrinsics.checkNotNullExpressionValue(id, "getId(...)");
        ItemId itemIdCreateItemId = companion.createItemId(id);
        String name = boxFile.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        Boolean hasCollaborations = boxFile.getHasCollaborations();
        boolean zBooleanValue = hasCollaborations != null ? hasCollaborations.booleanValue() : false;
        Boolean isExternallyOwned = boxFile.getIsExternallyOwned();
        boolean zBooleanValue2 = isExternallyOwned != null ? isExternallyOwned.booleanValue() : false;
        FolderModel folderModel = (!z || (parent = boxFile.getParent()) == null) ? null : FolderModelMapper.INSTANCE.toFolderModel(parent, false);
        BoxUser modifiedBy = boxFile.getModifiedBy();
        UserModel userModel2 = modifiedBy != null ? UserModelMapper.INSTANCE.toUserModel(modifiedBy) : null;
        Date createdAt = boxFile.getCreatedAt();
        Date contentCreatedAt = boxFile.getContentCreatedAt();
        Date modifiedAt = boxFile.getModifiedAt();
        Date contentModifiedAt = boxFile.getContentModifiedAt();
        BoxIterator<BoxFolder> pathCollection = boxFile.getPathCollection();
        Collection entries3 = pathCollection != null ? pathCollection.getEntries() : null;
        boolean zAreEqual = (entries3 == null || entries3.isEmpty()) ? false : Intrinsics.areEqual(((BoxFolder) boxFile.getPathCollection().getEntries().get(0)).getUserId(), "0");
        Long size = boxFile.getSize();
        long jLongValue = size != null ? size.longValue() : 0L;
        BoxIterator<BoxFolder> pathCollection2 = boxFile.getPathCollection();
        if (pathCollection2 == null || (entries2 = pathCollection2.getEntries()) == null) {
            itemId = itemIdCreateItemId;
            z2 = zBooleanValue;
            arrayList = null;
        } else {
            ArrayList arrayList4 = new ArrayList();
            Iterator it = entries2.iterator();
            while (it.hasNext()) {
                BoxFolder boxFolder = (BoxFolder) it.next();
                ItemId itemId2 = itemIdCreateItemId;
                Iterator it2 = it;
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
                itemIdCreateItemId = itemId2;
                zBooleanValue = z3;
                str = str2;
            }
            itemId = itemIdCreateItemId;
            z2 = zBooleanValue;
            arrayList = arrayList4;
        }
        List<BoxCollection> collections = boxFile.getCollections();
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
        BoxSharedLink sharedLink = boxFile.getSharedLink();
        SharedLinkModel sharedLinkModel = sharedLink != null ? SharedLinkModelMapper.INSTANCE.toSharedLinkModel(sharedLink) : null;
        BoxIteratorRepresentations representations = boxFile.getRepresentations();
        if (representations == null || (entries = representations.getEntries()) == null) {
            arrayList3 = null;
        } else {
            ArrayList arrayList6 = new ArrayList();
            Iterator it3 = entries.iterator();
            while (it3.hasNext()) {
                BoxRepresentation boxRepresentation = (BoxRepresentation) it3.next();
                Iterator it4 = it3;
                RepresentationsModelMapper representationsModelMapper = RepresentationsModelMapper.INSTANCE;
                Intrinsics.checkNotNull(boxRepresentation);
                RepresentationModel representationModel = representationsModelMapper.toRepresentationModel(boxRepresentation);
                if (representationModel != null) {
                    arrayList6.add(representationModel);
                }
                it3 = it4;
            }
            arrayList3 = arrayList6;
        }
        String sha1 = boxFile.getSha1();
        Intrinsics.checkNotNullExpressionValue(sha1, "getSha1(...)");
        BoxFileVersion fileVersion = boxFile.getFileVersion();
        FileVersionMiniModel fileVersionMiniModel = fileVersion != null ? FileVersionMiniModelMapper.INSTANCE.toFileVersionMiniModel(fileVersion) : null;
        BoxLock lock = boxFile.getLock();
        FileVersionMiniModel fileVersionMiniModel2 = fileVersionMiniModel;
        FileLockModel fileLockModel = lock != null ? FileLockModelMapper.INSTANCE.toFileLockModel(lock) : null;
        Long commentCount = boxFile.getCommentCount();
        Long commentCount2 = boxFile.getCommentCount(true);
        if (commentCount2 != null) {
            long jLongValue2 = commentCount2.longValue();
            Long commentCount3 = boxFile.getCommentCount(false);
            lValueOf = Long.valueOf(jLongValue2 - (commentCount3 != null ? commentCount3.longValue() : 0L));
        } else {
            lValueOf = null;
        }
        BoxClassification classification = boxFile.getClassification();
        ClassificationModel classificationModel = classification != null ? ClassificationModelMapper.INSTANCE.toClassificationModel(classification) : null;
        String description = boxFile.getDescription();
        BoxWatermark watermark = boxFile.getWatermark();
        return new FileModel(itemId, name, z2, zBooleanValue2, folderModel, userModel, userModel2, createdAt, contentCreatedAt, modifiedAt, contentModifiedAt, zAreEqual, jLongValue, permissionsModel, arrayList, arrayList2, sharedLinkModel, arrayList3, sharedLinkPermissionModel, sha1, fileVersionMiniModel2, fileLockModel, commentCount, lValueOf, classificationModel, watermark != null ? WatermarkModelMapper.INSTANCE.toWatermarkModel(watermark) : null, description);
    }

    public static /* synthetic */ BoxFile toBoxFile$default(FileModelMapper fileModelMapper, FileModel fileModel, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return fileModelMapper.toBoxFile(fileModel, z);
    }

    @Deprecated(message = "Refactor legacy code to use FileModel instead")
    public final BoxFile toBoxFile(FileModel fileModel, boolean z) {
        Intrinsics.checkNotNullParameter(fileModel, "<this>");
        JsonObject jsonObject = new JsonObject();
        FileModel fileModel2 = fileModel;
        jsonObject.add("id", ItemModelMapperKt.toBoxItemId(fileModel2));
        jsonObject.add("name", fileModel.getName());
        jsonObject.add(BoxCollaborationItem.FIELD_HAS_COLLABORATIONS, fileModel.getHasCollaborations());
        jsonObject.add(BoxCollaborationItem.FIELD_IS_EXTERNALLY_OWNED, fileModel.isExternallyOwned());
        jsonObject.add("description", fileModel.getDescription());
        FolderModel parentFolder = fileModel.getParentFolder();
        if (parentFolder != null) {
            jsonObject.add("parent", BoxFolder.createFromIdAndName(ItemModelMapperKt.toBoxItemId(parentFolder), parentFolder.getName()).toJsonObject());
        }
        UserModel owner = fileModel.getOwner();
        if (owner != null) {
            jsonObject.add(BoxItem.FIELD_OWNED_BY, BoxUser.createFromId(owner.getId()).toJsonObject().add("name", owner.getName()));
        }
        UserModel updatedBy = fileModel.getUpdatedBy();
        if (updatedBy != null) {
            jsonObject.add("modified_by", BoxUser.createFromId(updatedBy.getId()).toJsonObject().add("name", updatedBy.getName()));
        }
        Date createdDate = fileModel.getCreatedDate();
        if (createdDate != null) {
            jsonObject.add("created_at", BoxDateFormat.format(createdDate));
        }
        Date modifiedDate = fileModel.getModifiedDate();
        if (modifiedDate != null) {
            jsonObject.add("modified_at", BoxDateFormat.format(modifiedDate));
        }
        Date contentCreatedDate = fileModel.getContentCreatedDate();
        if (contentCreatedDate != null) {
            jsonObject.add("content_created_at", BoxDateFormat.format(contentCreatedDate));
        }
        Date contentModifiedDate = fileModel.getContentModifiedDate();
        if (contentModifiedDate != null) {
            jsonObject.add("content_modified_at", BoxDateFormat.format(contentModifiedDate));
        }
        jsonObject.add("size", fileModel.getSize().longValue());
        PermissionsModel permissions = fileModel.getPermissions();
        if (permissions != null) {
            jsonObject.add("permissions", JsonObject.readFrom(PermissionsModelMapper.INSTANCE.toJsonString(permissions)));
        }
        jsonObject.add("type", "file");
        jsonObject.add("sha1", fileModel.getSha1());
        FileVersionMiniModel fileVersion = fileModel.getFileVersion();
        if (fileVersion != null) {
            jsonObject.add("file_version", JsonObject.readFrom(FileVersionMiniModelMapper.INSTANCE.toJsonString(fileVersion)));
        }
        List<PathCollectionEntry> pathCollection = fileModel.getPathCollection();
        if (pathCollection == null) {
            pathCollection = (z || fileModel.isRooted()) ? ItemModel.INSTANCE.buildApproximateLegacyPathCollection(fileModel2) : null;
        }
        if (pathCollection != null) {
            jsonObject.add(BoxItem.FIELD_PATH_COLLECTION, JsonObject.readFrom(PathCollectionEntryMapper.INSTANCE.toJsonString(pathCollection)));
        }
        List<CollectionModel> collections = fileModel.getCollections();
        if (collections != null) {
            jsonObject.add(BoxItem.FIELD_COLLECTIONS, CollectionMapperUtil.INSTANCE.transformCollectionModelsToBoxCollections(collections));
        }
        Long commentCount = fileModel.getCommentCount();
        if (commentCount != null) {
            jsonObject.add("comment_count", commentCount.longValue());
        }
        Long annotationCount = fileModel.getAnnotationCount();
        if (annotationCount != null) {
            jsonObject.add("annotation_count", annotationCount.longValue());
        }
        FileLockModel fileLock = fileModel.getFileLock();
        if (fileLock != null) {
            jsonObject.add(BoxFile.FIELD_LOCK, FileLockModelMapper.INSTANCE.toJsonObject(fileLock));
        }
        List<RepresentationModel> representations = fileModel.getRepresentations();
        if (representations != null) {
            jsonObject.add(BoxFile.FIELD_REPRESENTATIONS, RepresentationsModelMapper.INSTANCE.toBoxIteratorRepresentations(representations).toJsonObject());
        }
        ClassificationModel classification = fileModel.getClassification();
        if (classification != null) {
            jsonObject.add(BoxItem.FIELD_CLASSIFICATION, ClassificationModelMapper.INSTANCE.toBoxClassification(classification).toJsonObject());
        }
        SharedLinkModel sharedLink = fileModel.getSharedLink();
        if (sharedLink != null) {
            jsonObject.add("shared_link", SharedLinkModelMapper.INSTANCE.toBoxSharedLink(sharedLink).toJsonObject());
        }
        WatermarkModel watermark = fileModel.getWatermark();
        if (watermark != null) {
            jsonObject.add(BoxFile.FIELD_WATERMARK, WatermarkModelMapper.INSTANCE.toJsonObject(watermark));
        }
        BoxEntity boxEntityCreateEntityFromJson = BoxFile.createEntityFromJson(jsonObject);
        Intrinsics.checkNotNull(boxEntityCreateEntityFromJson, "null cannot be cast to non-null type com.box.androidsdk.content.models.BoxFile");
        return (BoxFile) boxEntityCreateEntityFromJson;
    }
}
