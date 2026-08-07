package com.box.android.data.mappers;

import com.box.android.common.utilities.NumberUtils;
import com.box.android.data.datasource.gql.cache.GQLEdgeHelper;
import com.box.android.data.fragment.FileFields;
import com.box.android.data.fragment.FolderFields;
import com.box.android.data.fragment.ItemConnectionFragment;
import com.box.android.data.fragment.WeblinkFields;
import com.box.android.domain.models.CollectionModel;
import com.box.android.domain.models.CollectionType;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.models.item.FileLockModel;
import com.box.android.domain.models.item.FileModel;
import com.box.android.domain.models.item.FileVersionMiniModel;
import com.box.android.domain.models.item.FolderModel;
import com.box.android.domain.models.item.ItemModel;
import com.box.android.domain.models.item.ItemModelKt;
import com.box.android.domain.models.item.ItemType;
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
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GQLGetFolderItemsQueryEdgeToItemModelMapper.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0007\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u001a\u0010\n\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0007J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0007J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0007J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u0002H\u0007J\f\u0010\u001a\u001a\u00020\u000e*\u00020\fH\u0007J\f\u0010\u001b\u001a\u00020\u0012*\u00020\u0010H\u0007J\f\u0010\u001c\u001a\u00020\u0016*\u00020\u0014H\u0007¨\u0006\u001d"}, d2 = {"Lcom/box/android/data/mappers/GQLGetFolderItemsQueryEdgeToItemModelMapper;", "Lcom/box/android/data/mappers/GraphQLMapper;", "Lcom/box/android/domain/models/item/ItemModel;", "Lcom/box/android/data/fragment/ItemConnectionFragment$Edge;", "<init>", "()V", "toGraphQL", "source", "options", "", "fromGraphQL", "nodeToFileModel", "Lcom/box/android/domain/models/item/FileModel;", "fileNode", "Lcom/box/android/data/fragment/FileFields;", "nodeToFolderModel", "Lcom/box/android/domain/models/item/FolderModel;", "folderNode", "Lcom/box/android/data/fragment/FolderFields;", "nodeToWeblinkModel", "Lcom/box/android/domain/models/item/WebLinkModel;", "weblinkNode", "Lcom/box/android/data/fragment/WeblinkFields;", "getNode", "Lcom/box/android/data/fragment/ItemConnectionFragment$Node;", "itemModel", "toOnFile", "toOnFolder", "toOnWeblink", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class GQLGetFolderItemsQueryEdgeToItemModelMapper implements GraphQLMapper<ItemModel, ItemConnectionFragment.Edge> {
    public static final GQLGetFolderItemsQueryEdgeToItemModelMapper INSTANCE = new GQLGetFolderItemsQueryEdgeToItemModelMapper();

    private GQLGetFolderItemsQueryEdgeToItemModelMapper() {
    }

    @Override // com.box.android.data.mappers.GraphQLMapper
    public ItemConnectionFragment.Edge toGraphQL(ItemModel source, Object options) {
        Intrinsics.checkNotNullParameter(source, "source");
        ItemConnectionFragment.Node node = getNode(source);
        if (node != null) {
            return new ItemConnectionFragment.Edge(GQLEdgeHelper.INSTANCE.constructEdgeId(source, node.get__typename()), node);
        }
        return null;
    }

    @Override // com.box.android.data.mappers.GraphQLMapper
    public ItemModel fromGraphQL(ItemConnectionFragment.Edge source, Object options) throws Exception {
        FileModel fileModelNodeToFileModel;
        Intrinsics.checkNotNullParameter(source, "source");
        FileFields fileFields = source.getNode().getFileFields();
        if (fileFields != null && (fileModelNodeToFileModel = INSTANCE.nodeToFileModel(fileFields)) != null) {
            return fileModelNodeToFileModel;
        }
        FolderFields folderFields = source.getNode().getFolderFields();
        if (folderFields != null) {
            return INSTANCE.nodeToFolderModel(folderFields);
        }
        WeblinkFields weblinkFields = source.getNode().getWeblinkFields();
        WebLinkModel webLinkModelNodeToWeblinkModel = weblinkFields != null ? INSTANCE.nodeToWeblinkModel(weblinkFields) : null;
        if (webLinkModelNodeToWeblinkModel != null) {
            return webLinkModelNodeToWeblinkModel;
        }
        throw new Exception("Unexpected node: " + source.getNode());
    }

    /* JADX WARN: Code duplicated, block: B:97:0x020e  */
    public final FileModel nodeToFileModel(FileFields fileNode) {
        FolderModel folderModel;
        PermissionsModel permissionsModel;
        String str;
        ArrayList arrayList;
        WatermarkModel watermarkModel;
        FileLockModel fileLockModel;
        List<FileFields.Edge> edges;
        CollectionType collectionTypeValueOf;
        Intrinsics.checkNotNullParameter(fileNode, "fileNode");
        ItemId itemIdCreateItemId = FileModel.INSTANCE.createItemId(fileNode.getId());
        String name = fileNode.getName();
        String str2 = name == null ? "" : name;
        Boolean hasCollaborations = fileNode.getHasCollaborations();
        boolean zBooleanValue = hasCollaborations != null ? hasCollaborations.booleanValue() : false;
        Boolean boolIsExternallyOwned = fileNode.isExternallyOwned();
        boolean zBooleanValue2 = boolIsExternallyOwned != null ? boolIsExternallyOwned.booleanValue() : false;
        FileFields.Parent parent = fileNode.getParent();
        if (parent != null) {
            ItemId itemIdCreateItemId2 = FolderModel.INSTANCE.createItemId(parent.getId());
            String name2 = parent.getName();
            folderModel = new FolderModel(itemIdCreateItemId2, name2 == null ? "" : name2, false, false, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, 393232, null);
        } else {
            folderModel = null;
        }
        FileFields.OwnedBy ownedBy = fileNode.getOwnedBy();
        UserModel userModel = ownedBy != null ? new UserModel(ownedBy.getId(), ownedBy.getName(), null, null, null, null, null, null, null) : null;
        FileFields.UpdatedBy updatedBy = fileNode.getUpdatedBy();
        UserModel userModel2 = updatedBy != null ? new UserModel(updatedBy.getId(), updatedBy.getName(), null, null, null, null, null, null, null) : null;
        FolderModel folderModel2 = folderModel;
        Date createdAt = fileNode.getCreatedAt();
        Date contentCreatedAt = fileNode.getContentCreatedAt();
        Date updatedAt = fileNode.getUpdatedAt();
        Date contentUpdatedAt = fileNode.getContentUpdatedAt();
        long longOrDefault = NumberUtils.INSTANCE.toLongOrDefault(fileNode.getSize(), 0L);
        FileFields.PermissionsV2Api permissionsV2Api = fileNode.getPermissionsV2Api();
        if (permissionsV2Api != null) {
            Boolean canDelete = permissionsV2Api.getCanDelete();
            boolean zBooleanValue3 = canDelete != null ? canDelete.booleanValue() : false;
            Boolean canRename = permissionsV2Api.getCanRename();
            boolean zBooleanValue4 = canRename != null ? canRename.booleanValue() : false;
            Boolean canDownload = permissionsV2Api.getCanDownload();
            boolean zBooleanValue5 = canDownload != null ? canDownload.booleanValue() : false;
            Boolean canPreview = permissionsV2Api.getCanPreview();
            boolean zBooleanValue6 = canPreview != null ? canPreview.booleanValue() : false;
            Boolean canUpload = permissionsV2Api.getCanUpload();
            boolean zBooleanValue7 = canUpload != null ? canUpload.booleanValue() : false;
            Boolean canComment = permissionsV2Api.getCanComment();
            boolean zBooleanValue8 = canComment != null ? canComment.booleanValue() : false;
            Boolean canShare = permissionsV2Api.getCanShare();
            boolean zBooleanValue9 = canShare != null ? canShare.booleanValue() : false;
            Boolean canInviteCollaborator = permissionsV2Api.getCanInviteCollaborator();
            boolean zBooleanValue10 = canInviteCollaborator != null ? canInviteCollaborator.booleanValue() : false;
            Boolean canSetShareAccess = permissionsV2Api.getCanSetShareAccess();
            boolean zBooleanValue11 = canSetShareAccess != null ? canSetShareAccess.booleanValue() : false;
            Boolean canViewAnnotations = permissionsV2Api.getCanViewAnnotations();
            boolean zBooleanValue12 = canViewAnnotations != null ? canViewAnnotations.booleanValue() : false;
            Boolean canCreateAnnotations = permissionsV2Api.getCanCreateAnnotations();
            permissionsModel = new PermissionsModel(zBooleanValue3, zBooleanValue4, zBooleanValue5, zBooleanValue6, zBooleanValue7, zBooleanValue8, zBooleanValue9, zBooleanValue10, zBooleanValue11, zBooleanValue12, canCreateAnnotations != null ? canCreateAnnotations.booleanValue() : false, false, 2048, null);
        } else {
            permissionsModel = null;
        }
        Boolean boolIsRooted = fileNode.isRooted();
        boolean zBooleanValue13 = boolIsRooted != null ? boolIsRooted.booleanValue() : false;
        FileFields.ItemCollectionConnection itemCollectionConnection = fileNode.getItemCollectionConnection();
        if (itemCollectionConnection == null || (edges = itemCollectionConnection.getEdges()) == null) {
            str = "";
            arrayList = null;
        } else {
            List<FileFields.Edge> list = edges;
            str = "";
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator it = list.iterator();
            while (it.hasNext()) {
                FileFields.Edge edge = (FileFields.Edge) it.next();
                String id = edge.getNode().getId();
                String name3 = edge.getNode().getName();
                String str3 = name3 == null ? str : name3;
                String collectionType = edge.getNode().getCollectionType();
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
                arrayList2.add(new CollectionModel(id, collectionTypeValueOf, str3, null, null));
                it = it2;
            }
            arrayList = arrayList2;
        }
        String sha1 = fileNode.getSha1();
        String str4 = sha1 == null ? str : sha1;
        FileFields.Watermark watermark = fileNode.getWatermark();
        if (watermark != null) {
            Boolean boolIsWatermarked = watermark.isWatermarked();
            watermarkModel = new WatermarkModel(boolIsWatermarked != null ? boolIsWatermarked.booleanValue() : false, false, false, 6, null);
        } else {
            watermarkModel = null;
        }
        FileFields.FileVersion fileVersion = fileNode.getFileVersion();
        FileVersionMiniModel fileVersionMiniModel = fileVersion != null ? new FileVersionMiniModel(fileVersion.getId(), fileVersion.getSha1()) : null;
        FileFields.FileLock fileLock = fileNode.getFileLock();
        if (fileLock != null) {
            String id2 = fileLock.getId();
            String appType = fileLock.getAppType();
            Date createdAt2 = fileLock.getCreatedAt();
            FileFields.CreatedBy createdBy = fileLock.getCreatedBy();
            fileLockModel = new FileLockModel(id2, appType, createdAt2, createdBy != null ? new UserModel(createdBy.getId(), createdBy.getName(), createdBy.getLogin(), null, null, null, null, null, null) : null, fileLock.getExpiresAt(), false);
        } else {
            fileLockModel = null;
        }
        Integer commentCount = fileNode.getCommentCount();
        Long lValueOf = commentCount != null ? Long.valueOf(commentCount.intValue()) : null;
        Integer annotationCount = fileNode.getAnnotationCount();
        return new FileModel(itemIdCreateItemId, str2, zBooleanValue, zBooleanValue2, folderModel2, userModel, userModel2, createdAt, contentCreatedAt, updatedAt, contentUpdatedAt, zBooleanValue13, longOrDefault, permissionsModel, null, arrayList, GQLSharedLinkFragmentToSharedLinkModelMapper.INSTANCE.fromFileFields(fileNode.getSharedLink()), null, null, str4, fileVersionMiniModel, fileLockModel, lValueOf, annotationCount != null ? Long.valueOf(annotationCount.intValue()) : null, null, watermarkModel, null, 83886080, null);
    }

    /* JADX WARN: Code duplicated, block: B:81:0x01cc  */
    public final FolderModel nodeToFolderModel(FolderFields folderNode) {
        FolderModel folderModel;
        PermissionsModel permissionsModel;
        ArrayList arrayList;
        List<FolderFields.Edge> edges;
        CollectionType collectionTypeValueOf;
        Intrinsics.checkNotNullParameter(folderNode, "folderNode");
        ItemId itemIdCreateItemId = FolderModel.INSTANCE.createItemId(folderNode.getId());
        String name = folderNode.getName();
        String str = name == null ? "" : name;
        Boolean hasCollaborations = folderNode.getHasCollaborations();
        boolean zBooleanValue = hasCollaborations != null ? hasCollaborations.booleanValue() : false;
        Boolean boolIsExternallyOwned = folderNode.isExternallyOwned();
        boolean zBooleanValue2 = boolIsExternallyOwned != null ? boolIsExternallyOwned.booleanValue() : false;
        FolderFields.Parent parent = folderNode.getParent();
        if (parent != null) {
            ItemId itemIdCreateItemId2 = FolderModel.INSTANCE.createItemId(parent.getId());
            String name2 = parent.getName();
            folderModel = new FolderModel(itemIdCreateItemId2, name2 == null ? "" : name2, false, false, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, 393232, null);
        } else {
            folderModel = null;
        }
        FolderFields.OwnedBy ownedBy = folderNode.getOwnedBy();
        UserModel userModel = ownedBy != null ? new UserModel(ownedBy.getId(), ownedBy.getName(), null, null, null, null, null, null, null) : null;
        FolderFields.UpdatedBy updatedBy = folderNode.getUpdatedBy();
        UserModel userModel2 = updatedBy != null ? new UserModel(updatedBy.getId(), updatedBy.getName(), null, null, null, null, null, null, null) : null;
        Date createdAt = folderNode.getCreatedAt();
        Date contentCreatedAt = folderNode.getContentCreatedAt();
        Date updatedAt = folderNode.getUpdatedAt();
        Date contentUpdatedAt = folderNode.getContentUpdatedAt();
        FolderModel folderModel2 = folderModel;
        long longOrDefault = NumberUtils.INSTANCE.toLongOrDefault(folderNode.getSize(), 0L);
        FolderFields.PermissionsV2Api permissionsV2Api = folderNode.getPermissionsV2Api();
        if (permissionsV2Api != null) {
            Boolean canDelete = permissionsV2Api.getCanDelete();
            boolean zBooleanValue3 = canDelete != null ? canDelete.booleanValue() : false;
            Boolean canRename = permissionsV2Api.getCanRename();
            boolean zBooleanValue4 = canRename != null ? canRename.booleanValue() : false;
            Boolean canDownload = permissionsV2Api.getCanDownload();
            boolean zBooleanValue5 = canDownload != null ? canDownload.booleanValue() : false;
            Boolean canUpload = permissionsV2Api.getCanUpload();
            boolean zBooleanValue6 = canUpload != null ? canUpload.booleanValue() : false;
            Boolean canShare = permissionsV2Api.getCanShare();
            boolean zBooleanValue7 = canShare != null ? canShare.booleanValue() : false;
            Boolean canInviteCollaborator = permissionsV2Api.getCanInviteCollaborator();
            boolean zBooleanValue8 = canInviteCollaborator != null ? canInviteCollaborator.booleanValue() : false;
            Boolean canSetShareAccess = permissionsV2Api.getCanSetShareAccess();
            permissionsModel = new PermissionsModel(zBooleanValue3, zBooleanValue4, zBooleanValue5, false, zBooleanValue6, false, zBooleanValue7, zBooleanValue8, canSetShareAccess != null ? canSetShareAccess.booleanValue() : false, false, false, false, 2048, null);
        } else {
            permissionsModel = null;
        }
        Boolean boolIsRooted = folderNode.isRooted();
        boolean zBooleanValue9 = boolIsRooted != null ? boolIsRooted.booleanValue() : false;
        FolderFields.ItemCollectionConnection itemCollectionConnection = folderNode.getItemCollectionConnection();
        if (itemCollectionConnection == null || (edges = itemCollectionConnection.getEdges()) == null) {
            arrayList = null;
        } else {
            List<FolderFields.Edge> list = edges;
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator it = list.iterator();
            while (it.hasNext()) {
                FolderFields.Edge edge = (FolderFields.Edge) it.next();
                String id = edge.getNode().getId();
                String name3 = edge.getNode().getName();
                String str2 = name3 == null ? "" : name3;
                String collectionType = edge.getNode().getCollectionType();
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
        return new FolderModel(itemIdCreateItemId, str, zBooleanValue, zBooleanValue2, folderModel2, userModel, userModel2, createdAt, contentCreatedAt, updatedAt, contentUpdatedAt, zBooleanValue9, Long.valueOf(longOrDefault), permissionsModel, null, arrayList, GQLSharedLinkFragmentToSharedLinkModelMapper.INSTANCE.fromFolderFields(folderNode.getSharedLink()), null, null, 393216, null);
    }

    /* JADX WARN: Code duplicated, block: B:64:0x018a  */
    public final WebLinkModel nodeToWeblinkModel(WeblinkFields weblinkNode) {
        FolderModel folderModel;
        PermissionsModel permissionsModel;
        List<WeblinkFields.Edge> edges;
        CollectionType collectionTypeValueOf;
        Intrinsics.checkNotNullParameter(weblinkNode, "weblinkNode");
        ItemId itemIdCreateItemId = WebLinkModel.INSTANCE.createItemId(weblinkNode.getId());
        String name = weblinkNode.getName();
        String str = name == null ? "" : name;
        WeblinkFields.Parent parent = weblinkNode.getParent();
        ArrayList arrayList = null;
        if (parent != null) {
            ItemId itemIdCreateItemId2 = FolderModel.INSTANCE.createItemId(parent.getId());
            String name2 = parent.getName();
            folderModel = new FolderModel(itemIdCreateItemId2, name2 == null ? "" : name2, false, false, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, 393232, null);
        } else {
            folderModel = null;
        }
        WeblinkFields.OwnedBy ownedBy = weblinkNode.getOwnedBy();
        UserModel userModel = ownedBy != null ? new UserModel(ownedBy.getId(), ownedBy.getName(), null, null, null, null, null, null, null) : null;
        WeblinkFields.UpdatedBy updatedBy = weblinkNode.getUpdatedBy();
        UserModel userModel2 = updatedBy != null ? new UserModel(updatedBy.getId(), updatedBy.getName(), null, null, null, null, null, null, null) : null;
        Date createdAt = weblinkNode.getCreatedAt();
        Date updatedAt = weblinkNode.getUpdatedAt();
        WeblinkFields.PermissionsV2Api permissionsV2Api = weblinkNode.getPermissionsV2Api();
        if (permissionsV2Api != null) {
            Boolean canDelete = permissionsV2Api.getCanDelete();
            boolean zBooleanValue = canDelete != null ? canDelete.booleanValue() : false;
            Boolean canRename = permissionsV2Api.getCanRename();
            boolean zBooleanValue2 = canRename != null ? canRename.booleanValue() : false;
            Boolean canComment = permissionsV2Api.getCanComment();
            boolean zBooleanValue3 = canComment != null ? canComment.booleanValue() : false;
            Boolean canShare = permissionsV2Api.getCanShare();
            boolean zBooleanValue4 = canShare != null ? canShare.booleanValue() : false;
            Boolean canSetShareAccess = permissionsV2Api.getCanSetShareAccess();
            permissionsModel = new PermissionsModel(zBooleanValue, zBooleanValue2, false, false, false, zBooleanValue3, zBooleanValue4, false, canSetShareAccess != null ? canSetShareAccess.booleanValue() : false, false, false, false, 2048, null);
        } else {
            permissionsModel = null;
        }
        Boolean boolIsRooted = weblinkNode.isRooted();
        boolean zBooleanValue5 = boolIsRooted != null ? boolIsRooted.booleanValue() : false;
        Object url = weblinkNode.getUrl();
        Intrinsics.checkNotNull(url, "null cannot be cast to non-null type kotlin.String");
        String str2 = (String) url;
        WeblinkFields.ItemCollectionConnection itemCollectionConnection = weblinkNode.getItemCollectionConnection();
        if (itemCollectionConnection != null && (edges = itemCollectionConnection.getEdges()) != null) {
            List<WeblinkFields.Edge> list = edges;
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            for (WeblinkFields.Edge edge : list) {
                String id = edge.getNode().getId();
                String name3 = edge.getNode().getName();
                String str3 = name3 == null ? "" : name3;
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
                arrayList2.add(new CollectionModel(id, collectionTypeValueOf, str3, null, null));
            }
            arrayList = arrayList2;
        }
        return new WebLinkModel(itemIdCreateItemId, str, false, false, folderModel, userModel, userModel2, createdAt, null, updatedAt, null, zBooleanValue5, permissionsModel, null, str2, GQLSharedLinkFragmentToSharedLinkModelMapper.INSTANCE.fromWeblinkFields(weblinkNode.getSharedLink()), arrayList, null, 132352, null);
    }

    public final ItemConnectionFragment.Node getNode(ItemModel itemModel) {
        Intrinsics.checkNotNullParameter(itemModel, "itemModel");
        if (itemModel instanceof FileModel) {
            return new ItemConnectionFragment.Node(TypenameMapperKt.toGQLTypename(ItemType.FILE), toOnFile((FileModel) itemModel), null, null);
        }
        if (itemModel instanceof FolderModel) {
            return new ItemConnectionFragment.Node(TypenameMapperKt.toGQLTypename(ItemType.FOLDER), null, toOnFolder((FolderModel) itemModel), null);
        }
        if (!(itemModel instanceof WebLinkModel)) {
            return null;
        }
        return new ItemConnectionFragment.Node(TypenameMapperKt.toGQLTypename(ItemType.WEBLINK), null, null, toOnWeblink((WebLinkModel) itemModel));
    }

    public final FileFields toOnFile(FileModel fileModel) {
        FileFields.OwnedBy ownedBy;
        FileFields.UpdatedBy updatedBy;
        FileFields.PermissionsV2Api permissionsV2Api;
        String str;
        String str2;
        com.box.android.data.type.ItemType itemType;
        Date date;
        FileFields.ItemCollectionConnection itemCollectionConnection;
        FileFields.FileLock fileLock;
        Intrinsics.checkNotNullParameter(fileModel, "<this>");
        String boxId = ItemModelKt.toItemIdRemoteId(fileModel).getBoxId();
        String name = fileModel.getName();
        com.box.android.data.type.ItemType itemType2 = com.box.android.data.type.ItemType.file;
        Date createdDate = fileModel.getCreatedDate();
        Date modifiedDate = fileModel.getModifiedDate();
        Date contentCreatedDate = fileModel.getContentCreatedDate();
        Date contentModifiedDate = fileModel.getContentModifiedDate();
        UserModel owner = fileModel.getOwner();
        if (owner != null) {
            String id = owner.getId();
            String name2 = owner.getName();
            if (name2 == null) {
                name2 = "";
            }
            ownedBy = new FileFields.OwnedBy(id, name2);
        } else {
            ownedBy = null;
        }
        UserModel updatedBy2 = fileModel.getUpdatedBy();
        if (updatedBy2 != null) {
            String id2 = updatedBy2.getId();
            String name3 = updatedBy2.getName();
            updatedBy = new FileFields.UpdatedBy(id2, name3 != null ? name3 : "");
        } else {
            updatedBy = null;
        }
        FolderModel parentFolder = fileModel.getParentFolder();
        FileFields.Parent parent = parentFolder != null ? new FileFields.Parent(ItemModelKt.toItemIdRemoteId(parentFolder).getBoxId(), parentFolder.getName()) : null;
        long jLongValue = fileModel.getSize().longValue();
        boolean zIsRooted = fileModel.isRooted();
        boolean hasCollaborations = fileModel.getHasCollaborations();
        boolean zIsExternallyOwned = fileModel.isExternallyOwned();
        String sha1 = fileModel.getSha1();
        WatermarkModel watermark = fileModel.getWatermark();
        FileFields.Watermark watermark2 = watermark != null ? new FileFields.Watermark(Boolean.valueOf(watermark.isWatermarked())) : null;
        PermissionsModel permissions = fileModel.getPermissions();
        if (permissions != null) {
            boolean canComment = permissions.getCanComment();
            boolean canViewAnnotations = permissions.getCanViewAnnotations();
            boolean canUpload = permissions.getCanUpload();
            boolean canShare = permissions.getCanShare();
            boolean canSetShareAccess = permissions.getCanSetShareAccess();
            boolean canRename = permissions.getCanRename();
            boolean canPreview = permissions.getCanPreview();
            permissionsV2Api = new FileFields.PermissionsV2Api(Boolean.valueOf(canComment), Boolean.valueOf(permissions.getCanDelete()), Boolean.valueOf(permissions.getCanDownload()), Boolean.valueOf(permissions.getCanInviteCollaborators()), Boolean.valueOf(canPreview), Boolean.valueOf(canRename), Boolean.valueOf(canSetShareAccess), Boolean.valueOf(canShare), Boolean.valueOf(canUpload), Boolean.valueOf(canViewAnnotations), Boolean.valueOf(permissions.getCanCreateAnnotations()));
        } else {
            permissionsV2Api = null;
        }
        FileVersionMiniModel fileVersion = fileModel.getFileVersion();
        FileFields.FileVersion fileVersion2 = fileVersion != null ? new FileFields.FileVersion(fileVersion.getId(), fileVersion.getSha1()) : null;
        List<CollectionModel> collections = fileModel.getCollections();
        if (collections != null) {
            List<CollectionModel> list = collections;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator it = list.iterator();
            while (it.hasNext()) {
                CollectionModel collectionModel = (CollectionModel) it.next();
                arrayList.add(new FileFields.Edge(collectionModel.getId(), new FileFields.Node(collectionModel.getId(), collectionModel.getName(), collectionModel.getType().name())));
                it = it;
                boxId = boxId;
                name = name;
                itemType2 = itemType2;
                createdDate = createdDate;
            }
            str = boxId;
            str2 = name;
            itemType = itemType2;
            date = createdDate;
            itemCollectionConnection = new FileFields.ItemCollectionConnection(arrayList);
        } else {
            str = boxId;
            str2 = name;
            itemType = itemType2;
            date = createdDate;
            itemCollectionConnection = null;
        }
        FileLockModel fileLock2 = fileModel.getFileLock();
        if (fileLock2 != null) {
            String id3 = fileLock2.getId();
            String appType = fileLock2.getAppType();
            Date createdAt = fileLock2.getCreatedAt();
            UserModel createdBy = fileLock2.getCreatedBy();
            fileLock = new FileFields.FileLock(id3, appType, createdAt, createdBy != null ? new FileFields.CreatedBy(createdBy.getId(), createdBy.getName(), createdBy.getLogin()) : null, fileLock2.getExpiresAt(), fileLock2.isDownloadPrevented());
        } else {
            fileLock = null;
        }
        Long commentCount = fileModel.getCommentCount();
        Integer numValueOf = commentCount != null ? Integer.valueOf((int) commentCount.longValue()) : null;
        Long annotationCount = fileModel.getAnnotationCount();
        return new FileFields(str, str2, itemType, date, modifiedDate, contentCreatedDate, contentModifiedDate, Boolean.valueOf(zIsRooted), numValueOf, annotationCount != null ? Integer.valueOf((int) annotationCount.longValue()) : null, ownedBy, updatedBy, parent, fileVersion2, itemCollectionConnection, Long.valueOf(jLongValue), Boolean.valueOf(hasCollaborations), Boolean.valueOf(zIsExternallyOwned), sha1, watermark2, permissionsV2Api, fileLock, SharedLinkModelToApolloSharedLinkMapper.INSTANCE.toFileFields(fileModel.getSharedLink()));
    }

    public final FolderFields toOnFolder(FolderModel folderModel) {
        FolderFields.UpdatedBy updatedBy;
        FolderFields.OwnedBy ownedBy;
        FolderFields.PermissionsV2Api permissionsV2Api;
        boolean z;
        String str;
        String str2;
        com.box.android.data.type.ItemType itemType;
        Intrinsics.checkNotNullParameter(folderModel, "<this>");
        String boxId = ItemModelKt.toItemIdRemoteId(folderModel).getBoxId();
        String name = folderModel.getName();
        com.box.android.data.type.ItemType itemType2 = com.box.android.data.type.ItemType.folder;
        Date createdDate = folderModel.getCreatedDate();
        Date modifiedDate = folderModel.getModifiedDate();
        Date contentCreatedDate = folderModel.getContentCreatedDate();
        Date contentModifiedDate = folderModel.getContentModifiedDate();
        UserModel updatedBy2 = folderModel.getUpdatedBy();
        FolderFields.ItemCollectionConnection itemCollectionConnection = null;
        if (updatedBy2 != null) {
            String id = updatedBy2.getId();
            String name2 = updatedBy2.getName();
            if (name2 == null) {
                name2 = "";
            }
            updatedBy = new FolderFields.UpdatedBy(id, name2);
        } else {
            updatedBy = null;
        }
        UserModel owner = folderModel.getOwner();
        if (owner != null) {
            String id2 = owner.getId();
            String name3 = owner.getName();
            ownedBy = new FolderFields.OwnedBy(id2, name3 != null ? name3 : "");
        } else {
            ownedBy = null;
        }
        FolderModel parentFolder = folderModel.getParentFolder();
        FolderFields.Parent parent = parentFolder != null ? new FolderFields.Parent(ItemModelKt.toItemIdRemoteId(parentFolder).getBoxId(), parentFolder.getName()) : null;
        Long size = folderModel.getSize();
        boolean hasCollaborations = folderModel.getHasCollaborations();
        boolean zIsExternallyOwned = folderModel.isExternallyOwned();
        boolean zIsRooted = folderModel.isRooted();
        PermissionsModel permissions = folderModel.getPermissions();
        if (permissions != null) {
            boolean canUpload = permissions.getCanUpload();
            boolean canShare = permissions.getCanShare();
            permissionsV2Api = new FolderFields.PermissionsV2Api(Boolean.valueOf(permissions.getCanDelete()), Boolean.valueOf(permissions.getCanDownload()), Boolean.valueOf(permissions.getCanInviteCollaborators()), Boolean.valueOf(permissions.getCanRename()), Boolean.valueOf(permissions.getCanSetShareAccess()), Boolean.valueOf(canShare), Boolean.valueOf(canUpload));
        } else {
            permissionsV2Api = null;
        }
        List<CollectionModel> collections = folderModel.getCollections();
        if (collections != null) {
            List<CollectionModel> list = collections;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator it = list.iterator();
            while (it.hasNext()) {
                CollectionModel collectionModel = (CollectionModel) it.next();
                arrayList.add(new FolderFields.Edge(collectionModel.getId(), new FolderFields.Node(collectionModel.getId(), collectionModel.getName(), collectionModel.getType().name())));
                it = it;
                zIsExternallyOwned = zIsExternallyOwned;
                boxId = boxId;
                name = name;
                itemType2 = itemType2;
            }
            z = zIsExternallyOwned;
            str = boxId;
            str2 = name;
            itemType = itemType2;
            itemCollectionConnection = new FolderFields.ItemCollectionConnection(arrayList);
        } else {
            z = zIsExternallyOwned;
            str = boxId;
            str2 = name;
            itemType = itemType2;
        }
        return new FolderFields(str, str2, itemType, createdDate, modifiedDate, contentCreatedDate, contentModifiedDate, Boolean.valueOf(zIsRooted), ownedBy, updatedBy, parent, itemCollectionConnection, size, Boolean.valueOf(hasCollaborations), Boolean.valueOf(z), permissionsV2Api, SharedLinkModelToApolloSharedLinkMapper.INSTANCE.toFolderFields(folderModel.getSharedLink()));
    }

    public final WeblinkFields toOnWeblink(WebLinkModel webLinkModel) {
        WeblinkFields.OwnedBy ownedBy;
        WeblinkFields.UpdatedBy updatedBy;
        WeblinkFields.PermissionsV2Api permissionsV2Api;
        boolean z;
        String str;
        WeblinkFields.ItemCollectionConnection itemCollectionConnection;
        Intrinsics.checkNotNullParameter(webLinkModel, "<this>");
        String boxId = ItemModelKt.toItemIdRemoteId(webLinkModel).getBoxId();
        String name = webLinkModel.getName();
        com.box.android.data.type.ItemType itemType = com.box.android.data.type.ItemType.web_link;
        boolean zIsRooted = webLinkModel.isRooted();
        Date createdDate = webLinkModel.getCreatedDate();
        Date modifiedDate = webLinkModel.getModifiedDate();
        UserModel owner = webLinkModel.getOwner();
        if (owner != null) {
            String id = owner.getId();
            String name2 = owner.getName();
            if (name2 == null) {
                name2 = "";
            }
            ownedBy = new WeblinkFields.OwnedBy(id, name2);
        } else {
            ownedBy = null;
        }
        UserModel updatedBy2 = webLinkModel.getUpdatedBy();
        if (updatedBy2 != null) {
            String id2 = updatedBy2.getId();
            String name3 = updatedBy2.getName();
            updatedBy = new WeblinkFields.UpdatedBy(id2, name3 != null ? name3 : "");
        } else {
            updatedBy = null;
        }
        FolderModel parentFolder = webLinkModel.getParentFolder();
        WeblinkFields.Parent parent = parentFolder != null ? new WeblinkFields.Parent(ItemModelKt.toItemIdRemoteId(parentFolder).getBoxId(), parentFolder.getName()) : null;
        PermissionsModel permissions = webLinkModel.getPermissions();
        if (permissions != null) {
            permissionsV2Api = new WeblinkFields.PermissionsV2Api(Boolean.valueOf(permissions.getCanComment()), Boolean.valueOf(permissions.getCanDelete()), Boolean.valueOf(permissions.getCanRename()), Boolean.valueOf(permissions.getCanSetShareAccess()), Boolean.valueOf(permissions.getCanShare()));
        } else {
            permissionsV2Api = null;
        }
        String url = webLinkModel.getUrl();
        List<CollectionModel> collections = webLinkModel.getCollections();
        if (collections != null) {
            List<CollectionModel> list = collections;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator it = list.iterator();
            while (it.hasNext()) {
                CollectionModel collectionModel = (CollectionModel) it.next();
                arrayList.add(new WeblinkFields.Edge(collectionModel.getId(), new WeblinkFields.Node(collectionModel.getId(), collectionModel.getName(), collectionModel.getType().name())));
                zIsRooted = zIsRooted;
                it = it;
                boxId = boxId;
            }
            z = zIsRooted;
            str = boxId;
            itemCollectionConnection = new WeblinkFields.ItemCollectionConnection(arrayList);
        } else {
            z = zIsRooted;
            str = boxId;
            itemCollectionConnection = null;
        }
        return new WeblinkFields(str, name, itemType, createdDate, modifiedDate, Boolean.valueOf(z), ownedBy, updatedBy, parent, itemCollectionConnection, url, permissionsV2Api, SharedLinkModelToApolloSharedLinkMapper.INSTANCE.toWeblinkFields(webLinkModel.getSharedLink()));
    }
}
