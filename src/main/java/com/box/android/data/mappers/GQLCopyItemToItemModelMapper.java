package com.box.android.data.mappers;

import com.box.android.common.utilities.NumberUtils;
import com.box.android.data.CopyItemMutation;
import com.box.android.domain.models.CollectionModel;
import com.box.android.domain.models.CollectionType;
import com.box.android.domain.models.ItemId;
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
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GQLCopyItemToItemModelMapper.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0007\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u001a\u0010\n\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\f\u0010\u000b\u001a\u00020\f*\u00020\rH\u0002J\f\u0010\u000e\u001a\u00020\u000f*\u00020\u0010H\u0002J\f\u0010\u0011\u001a\u00020\u0012*\u00020\u0013H\u0002¨\u0006\u0014"}, d2 = {"Lcom/box/android/data/mappers/GQLCopyItemToItemModelMapper;", "Lcom/box/android/data/mappers/GraphQLMapper;", "Lcom/box/android/domain/models/item/ItemModel;", "Lcom/box/android/data/CopyItemMutation$CopyItem;", "<init>", "()V", "toGraphQL", "source", "options", "", "fromGraphQL", "toFileModel", "Lcom/box/android/domain/models/item/FileModel;", "Lcom/box/android/data/CopyItemMutation$OnFile;", "toFolderModel", "Lcom/box/android/domain/models/item/FolderModel;", "Lcom/box/android/data/CopyItemMutation$OnFolder;", "toWeblinkModel", "Lcom/box/android/domain/models/item/WebLinkModel;", "Lcom/box/android/data/CopyItemMutation$OnWeblink;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class GQLCopyItemToItemModelMapper implements GraphQLMapper<ItemModel, CopyItemMutation.CopyItem> {
    public static final GQLCopyItemToItemModelMapper INSTANCE = new GQLCopyItemToItemModelMapper();

    private GQLCopyItemToItemModelMapper() {
    }

    @Override // com.box.android.data.mappers.GraphQLMapper
    public CopyItemMutation.CopyItem toGraphQL(ItemModel source, Object options) {
        Intrinsics.checkNotNullParameter(source, "source");
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.box.android.data.mappers.GraphQLMapper
    public ItemModel fromGraphQL(CopyItemMutation.CopyItem source, Object options) throws Exception {
        FileModel fileModel;
        Intrinsics.checkNotNullParameter(source, "source");
        CopyItemMutation.OnFile onFile = source.getOnFile();
        if (onFile != null && (fileModel = toFileModel(onFile)) != null) {
            return fileModel;
        }
        CopyItemMutation.OnFolder onFolder = source.getOnFolder();
        if (onFolder != null) {
            return toFolderModel(onFolder);
        }
        CopyItemMutation.OnWeblink onWeblink = source.getOnWeblink();
        WebLinkModel weblinkModel = onWeblink != null ? toWeblinkModel(onWeblink) : null;
        if (weblinkModel != null) {
            return weblinkModel;
        }
        throw new Exception("Unexpected source: " + source);
    }

    /* JADX WARN: Code duplicated, block: B:97:0x01ff  */
    private final FileModel toFileModel(CopyItemMutation.OnFile onFile) {
        FolderModel folderModel;
        PermissionsModel permissionsModel;
        ArrayList arrayList;
        WatermarkModel watermarkModel;
        List<CopyItemMutation.Edge> edges;
        CollectionType collectionTypeValueOf;
        ItemId itemIdCreateItemId = FileModel.INSTANCE.createItemId(onFile.getId());
        String name = onFile.getName();
        String str = name == null ? "" : name;
        Boolean hasCollaborations = onFile.getHasCollaborations();
        boolean zBooleanValue = hasCollaborations != null ? hasCollaborations.booleanValue() : false;
        Boolean boolIsExternallyOwned = onFile.isExternallyOwned();
        boolean zBooleanValue2 = boolIsExternallyOwned != null ? boolIsExternallyOwned.booleanValue() : false;
        CopyItemMutation.Parent parent = onFile.getParent();
        if (parent != null) {
            ItemId itemIdCreateItemId2 = FolderModel.INSTANCE.createItemId(parent.getId());
            String name2 = parent.getName();
            folderModel = new FolderModel(itemIdCreateItemId2, name2 == null ? "" : name2, false, false, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, 393216, null);
        } else {
            folderModel = null;
        }
        CopyItemMutation.OwnedBy ownedBy = onFile.getOwnedBy();
        UserModel userModel = ownedBy != null ? new UserModel(ownedBy.getId(), ownedBy.getName(), null, null, null, null, null, null, null) : null;
        CopyItemMutation.UpdatedBy updatedBy = onFile.getUpdatedBy();
        UserModel userModel2 = updatedBy != null ? new UserModel(updatedBy.getId(), updatedBy.getName(), null, null, null, null, null, null, null) : null;
        FolderModel folderModel2 = folderModel;
        Date createdAt = onFile.getCreatedAt();
        Date contentCreatedAt = onFile.getContentCreatedAt();
        Date updatedAt = onFile.getUpdatedAt();
        Date contentUpdatedAt = onFile.getContentUpdatedAt();
        long longOrDefault = NumberUtils.INSTANCE.toLongOrDefault(onFile.getSize(), 0L);
        Boolean boolIsRooted = onFile.isRooted();
        boolean zBooleanValue3 = boolIsRooted != null ? boolIsRooted.booleanValue() : false;
        CopyItemMutation.PermissionsV2Api permissionsV2Api = onFile.getPermissionsV2Api();
        if (permissionsV2Api != null) {
            Boolean canComment = permissionsV2Api.getCanComment();
            boolean zBooleanValue4 = canComment != null ? canComment.booleanValue() : false;
            Boolean canCreateAnnotations = permissionsV2Api.getCanCreateAnnotations();
            boolean zBooleanValue5 = canCreateAnnotations != null ? canCreateAnnotations.booleanValue() : false;
            Boolean canDelete = permissionsV2Api.getCanDelete();
            boolean zBooleanValue6 = canDelete != null ? canDelete.booleanValue() : false;
            Boolean canDownload = permissionsV2Api.getCanDownload();
            boolean zBooleanValue7 = canDownload != null ? canDownload.booleanValue() : false;
            Boolean canPreview = permissionsV2Api.getCanPreview();
            boolean zBooleanValue8 = canPreview != null ? canPreview.booleanValue() : false;
            Boolean canRename = permissionsV2Api.getCanRename();
            boolean zBooleanValue9 = canRename != null ? canRename.booleanValue() : false;
            Boolean canSetShareAccess = permissionsV2Api.getCanSetShareAccess();
            boolean zBooleanValue10 = canSetShareAccess != null ? canSetShareAccess.booleanValue() : false;
            Boolean canShare = permissionsV2Api.getCanShare();
            boolean zBooleanValue11 = canShare != null ? canShare.booleanValue() : false;
            Boolean canUpload = permissionsV2Api.getCanUpload();
            boolean zBooleanValue12 = canUpload != null ? canUpload.booleanValue() : false;
            Boolean canViewAnnotations = permissionsV2Api.getCanViewAnnotations();
            boolean zBooleanValue13 = canViewAnnotations != null ? canViewAnnotations.booleanValue() : false;
            Boolean canInviteCollaborator = permissionsV2Api.getCanInviteCollaborator();
            permissionsModel = new PermissionsModel(zBooleanValue6, zBooleanValue9, zBooleanValue7, zBooleanValue8, zBooleanValue12, zBooleanValue4, zBooleanValue11, canInviteCollaborator != null ? canInviteCollaborator.booleanValue() : false, zBooleanValue10, zBooleanValue13, zBooleanValue5, false, 2048, null);
        } else {
            permissionsModel = null;
        }
        CopyItemMutation.ItemCollectionConnection itemCollectionConnection = onFile.getItemCollectionConnection();
        if (itemCollectionConnection == null || (edges = itemCollectionConnection.getEdges()) == null) {
            arrayList = null;
        } else {
            List<CopyItemMutation.Edge> list = edges;
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            for (CopyItemMutation.Edge edge : list) {
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
        CopyItemMutation.Watermark watermark = onFile.getWatermark();
        if (watermark != null) {
            Boolean boolIsWatermarked = watermark.isWatermarked();
            watermarkModel = new WatermarkModel(boolIsWatermarked != null ? boolIsWatermarked.booleanValue() : false, false, false, 6, null);
        } else {
            watermarkModel = null;
        }
        CopyItemMutation.FileVersion fileVersion = onFile.getFileVersion();
        FileVersionMiniModel fileVersionMiniModel = fileVersion != null ? new FileVersionMiniModel(fileVersion.getId(), fileVersion.getSha1()) : null;
        Integer commentCount = onFile.getCommentCount();
        Long lValueOf = commentCount != null ? Long.valueOf(commentCount.intValue()) : null;
        Integer annotationCount = onFile.getAnnotationCount();
        return new FileModel(itemIdCreateItemId, str, zBooleanValue, zBooleanValue2, folderModel2, userModel, userModel2, createdAt, contentCreatedAt, updatedAt, contentUpdatedAt, zBooleanValue3, longOrDefault, permissionsModel, null, arrayList, null, null, null, str3, fileVersionMiniModel, null, lValueOf, annotationCount != null ? Long.valueOf(annotationCount.intValue()) : null, null, watermarkModel, null, 83886080, null);
    }

    /* JADX WARN: Code duplicated, block: B:81:0x01c1  */
    private final FolderModel toFolderModel(CopyItemMutation.OnFolder onFolder) {
        FolderModel folderModel;
        PermissionsModel permissionsModel;
        List<CopyItemMutation.Edge1> edges;
        CollectionType collectionTypeValueOf;
        ItemId itemIdCreateItemId = FolderModel.INSTANCE.createItemId(onFolder.getId());
        String name = onFolder.getName();
        String str = name == null ? "" : name;
        Boolean hasCollaborations = onFolder.getHasCollaborations();
        boolean zBooleanValue = hasCollaborations != null ? hasCollaborations.booleanValue() : false;
        Boolean boolIsExternallyOwned = onFolder.isExternallyOwned();
        boolean zBooleanValue2 = boolIsExternallyOwned != null ? boolIsExternallyOwned.booleanValue() : false;
        CopyItemMutation.Parent1 parent = onFolder.getParent();
        ArrayList arrayList = null;
        if (parent != null) {
            ItemId itemIdCreateItemId2 = FolderModel.INSTANCE.createItemId(parent.getId());
            String name2 = parent.getName();
            folderModel = new FolderModel(itemIdCreateItemId2, name2 == null ? "" : name2, false, false, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, 393216, null);
        } else {
            folderModel = null;
        }
        CopyItemMutation.OwnedBy1 ownedBy = onFolder.getOwnedBy();
        UserModel userModel = ownedBy != null ? new UserModel(ownedBy.getId(), ownedBy.getName(), null, null, null, null, null, null, null) : null;
        CopyItemMutation.UpdatedBy1 updatedBy = onFolder.getUpdatedBy();
        UserModel userModel2 = updatedBy != null ? new UserModel(updatedBy.getId(), updatedBy.getName(), null, null, null, null, null, null, null) : null;
        Date createdAt = onFolder.getCreatedAt();
        Date contentCreatedAt = onFolder.getContentCreatedAt();
        Date updatedAt = onFolder.getUpdatedAt();
        Date contentUpdatedAt = onFolder.getContentUpdatedAt();
        long longOrDefault = NumberUtils.INSTANCE.toLongOrDefault(onFolder.getSize(), 0L);
        CopyItemMutation.PermissionsV2Api1 permissionsV2Api = onFolder.getPermissionsV2Api();
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
        CopyItemMutation.ItemCollectionConnection1 itemCollectionConnection = onFolder.getItemCollectionConnection();
        if (itemCollectionConnection != null && (edges = itemCollectionConnection.getEdges()) != null) {
            List<CopyItemMutation.Edge1> list = edges;
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator it = list.iterator();
            while (it.hasNext()) {
                CopyItemMutation.Edge1 edge1 = (CopyItemMutation.Edge1) it.next();
                String id = edge1.getNode().getId();
                String name3 = edge1.getNode().getName();
                String str2 = name3 == null ? "" : name3;
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
                arrayList2.add(new CollectionModel(id, collectionTypeValueOf, str2, null, null));
                it = it2;
            }
            arrayList = arrayList2;
        }
        return new FolderModel(itemIdCreateItemId, str, zBooleanValue, zBooleanValue2, folderModel, userModel, userModel2, createdAt, contentCreatedAt, updatedAt, contentUpdatedAt, zBooleanValue9, Long.valueOf(longOrDefault), permissionsModel, null, arrayList, null, null, null, 393216, null);
    }

    /* JADX WARN: Code duplicated, block: B:64:0x0179  */
    private final WebLinkModel toWeblinkModel(CopyItemMutation.OnWeblink onWeblink) {
        FolderModel folderModel;
        PermissionsModel permissionsModel;
        List<CopyItemMutation.Edge2> edges;
        CollectionType collectionTypeValueOf;
        ItemId itemIdCreateItemId = WebLinkModel.INSTANCE.createItemId(onWeblink.getId());
        String name = onWeblink.getName();
        String str = name == null ? "" : name;
        CopyItemMutation.Parent2 parent = onWeblink.getParent();
        ArrayList arrayList = null;
        if (parent != null) {
            ItemId itemIdCreateItemId2 = FolderModel.INSTANCE.createItemId(parent.getId());
            String name2 = parent.getName();
            folderModel = new FolderModel(itemIdCreateItemId2, name2 == null ? "" : name2, false, false, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, 393216, null);
        } else {
            folderModel = null;
        }
        CopyItemMutation.OwnedBy2 ownedBy = onWeblink.getOwnedBy();
        UserModel userModel = ownedBy != null ? new UserModel(ownedBy.getId(), ownedBy.getName(), null, null, null, null, null, null, null) : null;
        CopyItemMutation.UpdatedBy2 updatedBy = onWeblink.getUpdatedBy();
        UserModel userModel2 = updatedBy != null ? new UserModel(updatedBy.getId(), updatedBy.getName(), null, null, null, null, null, null, null) : null;
        Date createdAt = onWeblink.getCreatedAt();
        Date updatedAt = onWeblink.getUpdatedAt();
        CopyItemMutation.PermissionsV2Api2 permissionsV2Api = onWeblink.getPermissionsV2Api();
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
        CopyItemMutation.ItemCollectionConnection2 itemCollectionConnection = onWeblink.getItemCollectionConnection();
        if (itemCollectionConnection != null && (edges = itemCollectionConnection.getEdges()) != null) {
            List<CopyItemMutation.Edge2> list = edges;
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            for (CopyItemMutation.Edge2 edge2 : list) {
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
        return new WebLinkModel(itemIdCreateItemId, str, false, false, folderModel, userModel, userModel2, createdAt, null, updatedAt, null, zBooleanValue5, permissionsModel, null, str2, null, arrayList, null, 132352, null);
    }
}
