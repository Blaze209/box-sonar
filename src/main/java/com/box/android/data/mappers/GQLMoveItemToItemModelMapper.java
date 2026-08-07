package com.box.android.data.mappers;

import com.box.android.common.utilities.NumberUtils;
import com.box.android.data.MoveItemMutation;
import com.box.android.domain.models.CollectionModel;
import com.box.android.domain.models.CollectionType;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.models.item.FileLockModel;
import com.box.android.domain.models.item.FileModel;
import com.box.android.domain.models.item.FileVersionMiniModel;
import com.box.android.domain.models.item.FolderModel;
import com.box.android.domain.models.item.ItemModel;
import com.box.android.domain.models.item.PermissionsModel;
import com.box.android.domain.models.item.UserModel;
import com.box.android.domain.models.item.WatermarkModel;
import com.box.android.domain.models.item.WebLinkModel;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GQLMoveItemToItemModelMapper.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0007\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u001a\u0010\n\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\f\u0010\u000b\u001a\u00020\f*\u00020\rH\u0002J\f\u0010\u000e\u001a\u00020\u000f*\u00020\u0010H\u0002J\f\u0010\u0011\u001a\u00020\u0012*\u00020\u0013H\u0002¨\u0006\u0014"}, d2 = {"Lcom/box/android/data/mappers/GQLMoveItemToItemModelMapper;", "Lcom/box/android/data/mappers/GraphQLMapper;", "Lcom/box/android/domain/models/item/ItemModel;", "Lcom/box/android/data/MoveItemMutation$MoveItem;", "<init>", "()V", "toGraphQL", "source", "options", "", "fromGraphQL", "toFileModel", "Lcom/box/android/domain/models/item/FileModel;", "Lcom/box/android/data/MoveItemMutation$OnFile;", "toFolderModel", "Lcom/box/android/domain/models/item/FolderModel;", "Lcom/box/android/data/MoveItemMutation$OnFolder;", "toWeblinkModel", "Lcom/box/android/domain/models/item/WebLinkModel;", "Lcom/box/android/data/MoveItemMutation$OnWeblink;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class GQLMoveItemToItemModelMapper implements GraphQLMapper<ItemModel, MoveItemMutation.MoveItem> {
    public static final GQLMoveItemToItemModelMapper INSTANCE = new GQLMoveItemToItemModelMapper();

    private GQLMoveItemToItemModelMapper() {
    }

    @Override // com.box.android.data.mappers.GraphQLMapper
    public MoveItemMutation.MoveItem toGraphQL(ItemModel source, Object options) {
        Intrinsics.checkNotNullParameter(source, "source");
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.box.android.data.mappers.GraphQLMapper
    public ItemModel fromGraphQL(MoveItemMutation.MoveItem source, Object options) throws Exception {
        FileModel fileModel;
        Intrinsics.checkNotNullParameter(source, "source");
        MoveItemMutation.OnFile onFile = source.getOnFile();
        if (onFile != null && (fileModel = toFileModel(onFile)) != null) {
            return fileModel;
        }
        MoveItemMutation.OnFolder onFolder = source.getOnFolder();
        if (onFolder != null) {
            return toFolderModel(onFolder);
        }
        MoveItemMutation.OnWeblink onWeblink = source.getOnWeblink();
        WebLinkModel weblinkModel = onWeblink != null ? toWeblinkModel(onWeblink) : null;
        if (weblinkModel != null) {
            return weblinkModel;
        }
        throw new Exception("Unexpected source: " + source);
    }

    /* JADX WARN: Code duplicated, block: B:97:0x01ff  */
    private final FileModel toFileModel(MoveItemMutation.OnFile onFile) {
        FolderModel folderModel;
        PermissionsModel permissionsModel;
        boolean z;
        ArrayList arrayList;
        WatermarkModel watermarkModel;
        FileLockModel fileLockModel;
        List<MoveItemMutation.Edge> edges;
        CollectionType collectionTypeValueOf;
        ItemId itemIdCreateItemId = FileModel.INSTANCE.createItemId(onFile.getId());
        String name = onFile.getName();
        String str = name == null ? "" : name;
        Boolean hasCollaborations = onFile.getHasCollaborations();
        boolean zBooleanValue = hasCollaborations != null ? hasCollaborations.booleanValue() : false;
        Boolean boolIsExternallyOwned = onFile.isExternallyOwned();
        boolean zBooleanValue2 = boolIsExternallyOwned != null ? boolIsExternallyOwned.booleanValue() : false;
        MoveItemMutation.Parent parent = onFile.getParent();
        if (parent != null) {
            ItemId itemIdCreateItemId2 = FolderModel.INSTANCE.createItemId(parent.getId());
            String name2 = parent.getName();
            folderModel = new FolderModel(itemIdCreateItemId2, name2 == null ? "" : name2, false, false, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, 393216, null);
        } else {
            folderModel = null;
        }
        MoveItemMutation.OwnedBy ownedBy = onFile.getOwnedBy();
        UserModel userModel = ownedBy != null ? new UserModel(ownedBy.getId(), ownedBy.getName(), null, null, null, null, null, null, null) : null;
        MoveItemMutation.UpdatedBy updatedBy = onFile.getUpdatedBy();
        UserModel userModel2 = updatedBy != null ? new UserModel(updatedBy.getId(), updatedBy.getName(), null, null, null, null, null, null, null) : null;
        FolderModel folderModel2 = folderModel;
        Date createdAt = onFile.getCreatedAt();
        Date contentCreatedAt = onFile.getContentCreatedAt();
        Date updatedAt = onFile.getUpdatedAt();
        Date contentUpdatedAt = onFile.getContentUpdatedAt();
        long longOrDefault = NumberUtils.INSTANCE.toLongOrDefault(onFile.getSize(), 0L);
        MoveItemMutation.PermissionsV2Api permissionsV2Api = onFile.getPermissionsV2Api();
        if (permissionsV2Api != null) {
            Boolean canComment = permissionsV2Api.getCanComment();
            boolean zBooleanValue3 = canComment != null ? canComment.booleanValue() : false;
            Boolean canCreateAnnotations = permissionsV2Api.getCanCreateAnnotations();
            boolean zBooleanValue4 = canCreateAnnotations != null ? canCreateAnnotations.booleanValue() : false;
            Boolean canDelete = permissionsV2Api.getCanDelete();
            boolean zBooleanValue5 = canDelete != null ? canDelete.booleanValue() : false;
            Boolean canDownload = permissionsV2Api.getCanDownload();
            boolean zBooleanValue6 = canDownload != null ? canDownload.booleanValue() : false;
            Boolean canPreview = permissionsV2Api.getCanPreview();
            boolean zBooleanValue7 = canPreview != null ? canPreview.booleanValue() : false;
            Boolean canRename = permissionsV2Api.getCanRename();
            boolean zBooleanValue8 = canRename != null ? canRename.booleanValue() : false;
            Boolean canSetShareAccess = permissionsV2Api.getCanSetShareAccess();
            boolean zBooleanValue9 = canSetShareAccess != null ? canSetShareAccess.booleanValue() : false;
            Boolean canShare = permissionsV2Api.getCanShare();
            boolean zBooleanValue10 = canShare != null ? canShare.booleanValue() : false;
            Boolean canUpload = permissionsV2Api.getCanUpload();
            boolean zBooleanValue11 = canUpload != null ? canUpload.booleanValue() : false;
            Boolean canViewAnnotations = permissionsV2Api.getCanViewAnnotations();
            boolean zBooleanValue12 = canViewAnnotations != null ? canViewAnnotations.booleanValue() : false;
            Boolean canInviteCollaborator = permissionsV2Api.getCanInviteCollaborator();
            permissionsModel = new PermissionsModel(zBooleanValue5, zBooleanValue8, zBooleanValue6, zBooleanValue7, zBooleanValue11, zBooleanValue3, zBooleanValue10, canInviteCollaborator != null ? canInviteCollaborator.booleanValue() : false, zBooleanValue9, zBooleanValue12, zBooleanValue4, false, 2048, null);
        } else {
            permissionsModel = null;
        }
        Boolean boolIsRooted = onFile.isRooted();
        boolean zBooleanValue13 = boolIsRooted != null ? boolIsRooted.booleanValue() : false;
        MoveItemMutation.ItemCollectionConnection itemCollectionConnection = onFile.getItemCollectionConnection();
        if (itemCollectionConnection == null || (edges = itemCollectionConnection.getEdges()) == null) {
            z = false;
            arrayList = null;
        } else {
            List<MoveItemMutation.Edge> list = edges;
            z = false;
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            for (MoveItemMutation.Edge edge : list) {
                String id = edge.getNode().getId();
                String name3 = edge.getNode().getName();
                String str2 = name3 == null ? "" : name3;
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
        String sha1 = onFile.getSha1();
        String str3 = sha1 == null ? "" : sha1;
        MoveItemMutation.Watermark watermark = onFile.getWatermark();
        if (watermark != null) {
            Boolean boolIsWatermarked = watermark.isWatermarked();
            watermarkModel = new WatermarkModel(boolIsWatermarked != null ? boolIsWatermarked.booleanValue() : z, false, false, 6, null);
        } else {
            watermarkModel = null;
        }
        MoveItemMutation.FileVersion fileVersion = onFile.getFileVersion();
        FileVersionMiniModel fileVersionMiniModel = fileVersion != null ? new FileVersionMiniModel(fileVersion.getId(), fileVersion.getSha1()) : null;
        MoveItemMutation.FileLock fileLock = onFile.getFileLock();
        if (fileLock != null) {
            String id2 = fileLock.getId();
            String appType = fileLock.getAppType();
            Date createdAt2 = fileLock.getCreatedAt();
            MoveItemMutation.CreatedBy createdBy = fileLock.getCreatedBy();
            fileLockModel = new FileLockModel(id2, appType, createdAt2, createdBy != null ? new UserModel(createdBy.getId(), createdBy.getName(), createdBy.getLogin(), null, null, null, null, null, null) : null, fileLock.getExpiresAt(), Boolean.valueOf(z));
        } else {
            fileLockModel = null;
        }
        Integer commentCount = onFile.getCommentCount();
        Long lValueOf = commentCount != null ? Long.valueOf(commentCount.intValue()) : null;
        Integer annotationCount = onFile.getAnnotationCount();
        return new FileModel(itemIdCreateItemId, str, zBooleanValue, zBooleanValue2, folderModel2, userModel, userModel2, createdAt, contentCreatedAt, updatedAt, contentUpdatedAt, zBooleanValue13, longOrDefault, permissionsModel, null, arrayList, null, null, null, str3, fileVersionMiniModel, fileLockModel, lValueOf, annotationCount != null ? Long.valueOf(annotationCount.intValue()) : null, null, watermarkModel, null, 83886080, null);
    }

    /* JADX WARN: Code duplicated, block: B:80:0x01c9  */
    private final FolderModel toFolderModel(MoveItemMutation.OnFolder onFolder) {
        FolderModel folderModel;
        PermissionsModel permissionsModel;
        ArrayList arrayList;
        List<MoveItemMutation.Edge1> edges;
        CollectionType collectionTypeValueOf;
        ItemId itemIdCreateItemId = FolderModel.INSTANCE.createItemId(onFolder.getId());
        String name = onFolder.getName();
        String str = name == null ? "" : name;
        Boolean hasCollaborations = onFolder.getHasCollaborations();
        boolean zBooleanValue = hasCollaborations != null ? hasCollaborations.booleanValue() : false;
        Boolean boolIsExternallyOwned = onFolder.isExternallyOwned();
        boolean zBooleanValue2 = boolIsExternallyOwned != null ? boolIsExternallyOwned.booleanValue() : false;
        MoveItemMutation.Parent1 parent = onFolder.getParent();
        if (parent != null) {
            ItemId itemIdCreateItemId2 = FolderModel.INSTANCE.createItemId(parent.getId());
            String name2 = parent.getName();
            folderModel = new FolderModel(itemIdCreateItemId2, name2 == null ? "" : name2, false, false, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, 393216, null);
        } else {
            folderModel = null;
        }
        MoveItemMutation.OwnedBy1 ownedBy = onFolder.getOwnedBy();
        UserModel userModel = ownedBy != null ? new UserModel(ownedBy.getId(), ownedBy.getName(), null, null, null, null, null, null, null) : null;
        MoveItemMutation.UpdatedBy1 updatedBy = onFolder.getUpdatedBy();
        UserModel userModel2 = updatedBy != null ? new UserModel(updatedBy.getId(), updatedBy.getName(), null, null, null, null, null, null, null) : null;
        FolderModel folderModel2 = folderModel;
        Date createdAt = onFolder.getCreatedAt();
        Date contentCreatedAt = onFolder.getContentCreatedAt();
        Date updatedAt = onFolder.getUpdatedAt();
        Date contentUpdatedAt = onFolder.getContentUpdatedAt();
        long longOrDefault = NumberUtils.INSTANCE.toLongOrDefault(onFolder.getSize(), 0L);
        MoveItemMutation.PermissionsV2Api1 permissionsV2Api = onFolder.getPermissionsV2Api();
        if (permissionsV2Api != null) {
            Boolean canDelete = permissionsV2Api.getCanDelete();
            boolean zBooleanValue3 = canDelete != null ? canDelete.booleanValue() : false;
            Boolean canDownload = permissionsV2Api.getCanDownload();
            boolean zBooleanValue4 = canDownload != null ? canDownload.booleanValue() : false;
            Boolean canRename = permissionsV2Api.getCanRename();
            boolean zBooleanValue5 = canRename != null ? canRename.booleanValue() : false;
            Boolean canSetShareAccess = permissionsV2Api.getCanSetShareAccess();
            boolean zBooleanValue6 = canSetShareAccess != null ? canSetShareAccess.booleanValue() : false;
            Boolean canShare = permissionsV2Api.getCanShare();
            boolean zBooleanValue7 = canShare != null ? canShare.booleanValue() : false;
            Boolean canUpload = permissionsV2Api.getCanUpload();
            boolean zBooleanValue8 = canUpload != null ? canUpload.booleanValue() : false;
            Boolean canInviteCollaborator = permissionsV2Api.getCanInviteCollaborator();
            permissionsModel = new PermissionsModel(zBooleanValue3, zBooleanValue5, zBooleanValue4, false, zBooleanValue8, false, zBooleanValue7, canInviteCollaborator != null ? canInviteCollaborator.booleanValue() : false, zBooleanValue6, false, false, false, 3624, null);
        } else {
            permissionsModel = null;
        }
        Boolean boolIsRooted = onFolder.isRooted();
        boolean zBooleanValue9 = boolIsRooted != null ? boolIsRooted.booleanValue() : false;
        MoveItemMutation.ItemCollectionConnection1 itemCollectionConnection = onFolder.getItemCollectionConnection();
        if (itemCollectionConnection == null || (edges = itemCollectionConnection.getEdges()) == null) {
            arrayList = null;
        } else {
            List<MoveItemMutation.Edge1> list = edges;
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            for (MoveItemMutation.Edge1 edge1 : list) {
                String id = edge1.getNode().getId();
                String name3 = edge1.getNode().getName();
                String str2 = name3 == null ? "" : name3;
                String collectionType = edge1.getNode().getCollectionType();
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
        return new FolderModel(itemIdCreateItemId, str, zBooleanValue, zBooleanValue2, folderModel2, userModel, userModel2, createdAt, contentCreatedAt, updatedAt, contentUpdatedAt, zBooleanValue9, Long.valueOf(longOrDefault), permissionsModel, null, arrayList, null, null, null, 393216, null);
    }

    /* JADX WARN: Code duplicated, block: B:64:0x017a  */
    private final WebLinkModel toWeblinkModel(MoveItemMutation.OnWeblink onWeblink) {
        FolderModel folderModel;
        PermissionsModel permissionsModel;
        List<MoveItemMutation.Edge2> edges;
        CollectionType collectionTypeValueOf;
        ItemId itemIdCreateItemId = WebLinkModel.INSTANCE.createItemId(onWeblink.getId());
        String name = onWeblink.getName();
        String str = name == null ? "" : name;
        MoveItemMutation.Parent2 parent = onWeblink.getParent();
        ArrayList arrayList = null;
        if (parent != null) {
            ItemId itemIdCreateItemId2 = FolderModel.INSTANCE.createItemId(parent.getId());
            String name2 = parent.getName();
            folderModel = new FolderModel(itemIdCreateItemId2, name2 == null ? "" : name2, false, false, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, 393216, null);
        } else {
            folderModel = null;
        }
        MoveItemMutation.OwnedBy2 ownedBy = onWeblink.getOwnedBy();
        UserModel userModel = ownedBy != null ? new UserModel(ownedBy.getId(), ownedBy.getName(), null, null, null, null, null, null, null) : null;
        MoveItemMutation.UpdatedBy2 updatedBy = onWeblink.getUpdatedBy();
        UserModel userModel2 = updatedBy != null ? new UserModel(updatedBy.getId(), updatedBy.getName(), null, null, null, null, null, null, null) : null;
        Date createdAt = onWeblink.getCreatedAt();
        Date updatedAt = onWeblink.getUpdatedAt();
        MoveItemMutation.PermissionsV2Api2 permissionsV2Api = onWeblink.getPermissionsV2Api();
        if (permissionsV2Api != null) {
            Boolean canComment = permissionsV2Api.getCanComment();
            boolean zBooleanValue = canComment != null ? canComment.booleanValue() : false;
            Boolean canDelete = permissionsV2Api.getCanDelete();
            boolean zBooleanValue2 = canDelete != null ? canDelete.booleanValue() : false;
            Boolean canRename = permissionsV2Api.getCanRename();
            boolean zBooleanValue3 = canRename != null ? canRename.booleanValue() : false;
            Boolean canSetShareAccess = permissionsV2Api.getCanSetShareAccess();
            boolean zBooleanValue4 = canSetShareAccess != null ? canSetShareAccess.booleanValue() : false;
            Boolean canShare = permissionsV2Api.getCanShare();
            permissionsModel = new PermissionsModel(zBooleanValue2, zBooleanValue3, false, false, false, zBooleanValue, canShare != null ? canShare.booleanValue() : false, false, zBooleanValue4, false, false, false, 3740, null);
        } else {
            permissionsModel = null;
        }
        Boolean boolIsRooted = onWeblink.isRooted();
        boolean zBooleanValue5 = boolIsRooted != null ? boolIsRooted.booleanValue() : false;
        Object url = onWeblink.getUrl();
        Intrinsics.checkNotNull(url, "null cannot be cast to non-null type kotlin.String");
        String str2 = (String) url;
        MoveItemMutation.ItemCollectionConnection2 itemCollectionConnection = onWeblink.getItemCollectionConnection();
        if (itemCollectionConnection != null && (edges = itemCollectionConnection.getEdges()) != null) {
            List<MoveItemMutation.Edge2> list = edges;
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            for (MoveItemMutation.Edge2 edge2 : list) {
                String id = edge2.getNode().getId();
                String name3 = edge2.getNode().getName();
                String str3 = name3 == null ? "" : name3;
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
                arrayList2.add(new CollectionModel(id, collectionTypeValueOf, str3, null, null));
            }
            arrayList = arrayList2;
        }
        return new WebLinkModel(itemIdCreateItemId, str, false, false, folderModel, userModel, userModel2, createdAt, null, updatedAt, null, zBooleanValue5, permissionsModel, null, str2, null, arrayList, null, 131072, null);
    }
}
