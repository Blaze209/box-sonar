package com.box.android.data.mappers;

import com.box.android.common.utilities.NumberUtils;
import com.box.android.data.GetCollectionItemsQuery;
import com.box.android.data.GetItemQuery;
import com.box.android.data.type.ItemType;
import com.box.android.domain.models.ClassificationModel;
import com.box.android.domain.models.CollectionModel;
import com.box.android.domain.models.CollectionType;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.models.item.FileLockModel;
import com.box.android.domain.models.item.FileModel;
import com.box.android.domain.models.item.FileVersionMiniModel;
import com.box.android.domain.models.item.FolderModel;
import com.box.android.domain.models.item.ItemModelKt;
import com.box.android.domain.models.item.PermissionsModel;
import com.box.android.domain.models.item.SharedLinkModel;
import com.box.android.domain.models.item.UserModel;
import com.box.android.domain.models.item.WatermarkModel;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GQLGetFileByIDFileToFileModelMapper.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u001a\u0010\n\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\u000b"}, d2 = {"Lcom/box/android/data/mappers/GQLGetFileByIDFileToFileModelMapper;", "Lcom/box/android/data/mappers/GraphQLMapper;", "Lcom/box/android/domain/models/item/FileModel;", "Lcom/box/android/data/GetItemQuery$OnFile;", "<init>", "()V", "toGraphQL", "source", "options", "", "fromGraphQL", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class GQLGetFileByIDFileToFileModelMapper implements GraphQLMapper<FileModel, GetItemQuery.OnFile> {
    public static final GQLGetFileByIDFileToFileModelMapper INSTANCE = new GQLGetFileByIDFileToFileModelMapper();

    private GQLGetFileByIDFileToFileModelMapper() {
    }

    @Override // com.box.android.data.mappers.GraphQLMapper
    public GetItemQuery.OnFile toGraphQL(FileModel source, Object options) {
        GetItemQuery.UpdatedBy updatedBy;
        long j;
        String str;
        ItemType itemType;
        GetItemQuery.ItemCollectionConnection itemCollectionConnection;
        GetItemQuery.FileLock fileLock;
        Intrinsics.checkNotNullParameter(source, "source");
        String boxId = ItemModelKt.toItemIdRemoteId(source).getBoxId();
        ItemType itemType2 = ItemType.file;
        String name = source.getName();
        long jLongValue = source.getSize().longValue();
        Date createdDate = source.getCreatedDate();
        Date modifiedDate = source.getModifiedDate();
        Date contentCreatedDate = source.getContentCreatedDate();
        Date contentModifiedDate = source.getContentModifiedDate();
        boolean zIsRooted = source.isRooted();
        UserModel owner = source.getOwner();
        GetItemQuery.OwnedBy ownedBy = owner != null ? new GetItemQuery.OwnedBy(owner.getId(), owner.getName()) : null;
        UserModel updatedBy2 = source.getUpdatedBy();
        if (updatedBy2 != null) {
            String id = updatedBy2.getId();
            String name2 = updatedBy2.getName();
            if (name2 == null) {
                name2 = "";
            }
            updatedBy = new GetItemQuery.UpdatedBy(id, name2);
        } else {
            updatedBy = null;
        }
        boolean hasCollaborations = source.getHasCollaborations();
        boolean zIsExternallyOwned = source.isExternallyOwned();
        String sha1 = source.getSha1();
        FolderModel parentFolder = source.getParentFolder();
        GetItemQuery.Parent parent = parentFolder != null ? new GetItemQuery.Parent(ItemModelKt.toItemIdRemoteId(parentFolder).getBoxId(), parentFolder.getName()) : null;
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
        GetItemQuery.PermissionsV2Api permissionsV2Api = new GetItemQuery.PermissionsV2Api(boolValueOf2, boolValueOf4, boolValueOf5, boolValueOf, boolValueOf6, boolValueOf7, boolValueOf8, boolValueOf9, boolValueOf10, permissions11 != null ? Boolean.valueOf(permissions11.getCanViewAnnotations()) : null, boolValueOf3);
        FileVersionMiniModel fileVersion = source.getFileVersion();
        GetItemQuery.FileVersion fileVersion2 = fileVersion != null ? new GetItemQuery.FileVersion(fileVersion.getId(), fileVersion.getSha1()) : null;
        List<CollectionModel> collections = source.getCollections();
        if (collections != null) {
            List<CollectionModel> list = collections;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            for (CollectionModel collectionModel : list) {
                arrayList.add(new GetItemQuery.Edge(collectionModel.getId(), new GetItemQuery.Node(collectionModel.getId(), collectionModel.getName(), collectionModel.getType().name())));
                boxId = boxId;
                jLongValue = jLongValue;
                itemType2 = itemType2;
            }
            j = jLongValue;
            str = boxId;
            itemType = itemType2;
            itemCollectionConnection = new GetItemQuery.ItemCollectionConnection(arrayList);
        } else {
            j = jLongValue;
            str = boxId;
            itemType = itemType2;
            itemCollectionConnection = null;
        }
        FileLockModel fileLock2 = source.getFileLock();
        if (fileLock2 != null) {
            String id2 = fileLock2.getId();
            String appType = fileLock2.getAppType();
            Date createdAt = fileLock2.getCreatedAt();
            UserModel createdBy = fileLock2.getCreatedBy();
            fileLock = new GetItemQuery.FileLock(id2, appType, createdAt, createdBy != null ? new GetItemQuery.CreatedBy(createdBy.getId(), createdBy.getName(), createdBy.getLogin()) : null, fileLock2.getExpiresAt(), fileLock2.isDownloadPrevented());
        } else {
            fileLock = null;
        }
        Long commentCount = source.getCommentCount();
        Integer numValueOf = commentCount != null ? Integer.valueOf((int) commentCount.longValue()) : null;
        Long annotationCount = source.getAnnotationCount();
        Integer numValueOf2 = annotationCount != null ? Integer.valueOf((int) annotationCount.longValue()) : null;
        String description = source.getDescription();
        ClassificationModel classification = source.getClassification();
        GetItemQuery.Classification classification2 = classification != null ? new GetItemQuery.Classification(classification.getName(), classification.getColor(), classification.getDefinition()) : null;
        GetItemQuery.SharedLink getItemQueryFile = SharedLinkModelToApolloSharedLinkMapper.INSTANCE.toGetItemQueryFile(source.getSharedLink());
        WatermarkModel watermark = source.getWatermark();
        return new GetItemQuery.OnFile(str, itemType, name, createdDate, modifiedDate, description, contentCreatedDate, contentModifiedDate, Boolean.valueOf(zIsRooted), numValueOf, numValueOf2, itemCollectionConnection, classification2, Long.valueOf(j), Boolean.valueOf(hasCollaborations), Boolean.valueOf(zIsExternallyOwned), sha1, watermark != null ? new GetItemQuery.Watermark(Boolean.valueOf(watermark.isWatermarked())) : null, ownedBy, updatedBy, parent, permissionsV2Api, fileVersion2, fileLock, getItemQueryFile);
    }

    /* JADX WARN: Code duplicated, block: B:119:0x025a  */
    @Override // com.box.android.data.mappers.GraphQLMapper
    public FileModel fromGraphQL(GetItemQuery.OnFile source, Object options) {
        FolderModel folderModel;
        ArrayList arrayList;
        FileLockModel fileLockModel;
        WatermarkModel watermarkModel;
        List<GetItemQuery.Edge> edges;
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
        ItemId itemIdCreateItemId = FileModel.INSTANCE.createItemId(source.getId());
        String name = source.getName();
        String str = name == null ? "" : name;
        Boolean hasCollaborations = source.getHasCollaborations();
        boolean zBooleanValue = hasCollaborations != null ? hasCollaborations.booleanValue() : false;
        Boolean boolIsExternallyOwned = source.isExternallyOwned();
        boolean zBooleanValue2 = boolIsExternallyOwned != null ? boolIsExternallyOwned.booleanValue() : false;
        GetItemQuery.OwnedBy ownedBy = source.getOwnedBy();
        UserModel userModel = ownedBy != null ? new UserModel(ownedBy.getId(), ownedBy.getName(), null, null, null, null, null, null, null) : null;
        GetItemQuery.UpdatedBy updatedBy = source.getUpdatedBy();
        UserModel userModel2 = updatedBy != null ? new UserModel(updatedBy.getId(), updatedBy.getName(), null, null, null, null, null, null, null) : null;
        Date createdAt = source.getCreatedAt();
        Date updatedAt = source.getUpdatedAt();
        Date contentCreatedAt = source.getContentCreatedAt();
        Date contentUpdatedAt = source.getContentUpdatedAt();
        Boolean boolIsRooted = source.isRooted();
        boolean zBooleanValue3 = boolIsRooted != null ? boolIsRooted.booleanValue() : false;
        UserModel userModel3 = userModel;
        long longOrDefault = NumberUtils.INSTANCE.toLongOrDefault(source.getSize(), 0L);
        GetItemQuery.PermissionsV2Api permissionsV2Api = source.getPermissionsV2Api();
        boolean zBooleanValue4 = (permissionsV2Api == null || (canInviteCollaborator = permissionsV2Api.getCanInviteCollaborator()) == null) ? false : canInviteCollaborator.booleanValue();
        GetItemQuery.PermissionsV2Api permissionsV2Api2 = source.getPermissionsV2Api();
        boolean zBooleanValue5 = (permissionsV2Api2 == null || (canComment = permissionsV2Api2.getCanComment()) == null) ? false : canComment.booleanValue();
        GetItemQuery.PermissionsV2Api permissionsV2Api3 = source.getPermissionsV2Api();
        boolean zBooleanValue6 = (permissionsV2Api3 == null || (canCreateAnnotations = permissionsV2Api3.getCanCreateAnnotations()) == null) ? false : canCreateAnnotations.booleanValue();
        GetItemQuery.PermissionsV2Api permissionsV2Api4 = source.getPermissionsV2Api();
        boolean zBooleanValue7 = (permissionsV2Api4 == null || (canDelete = permissionsV2Api4.getCanDelete()) == null) ? false : canDelete.booleanValue();
        GetItemQuery.PermissionsV2Api permissionsV2Api5 = source.getPermissionsV2Api();
        boolean zBooleanValue8 = (permissionsV2Api5 == null || (canDownload = permissionsV2Api5.getCanDownload()) == null) ? false : canDownload.booleanValue();
        GetItemQuery.PermissionsV2Api permissionsV2Api6 = source.getPermissionsV2Api();
        boolean zBooleanValue9 = (permissionsV2Api6 == null || (canPreview = permissionsV2Api6.getCanPreview()) == null) ? false : canPreview.booleanValue();
        GetItemQuery.PermissionsV2Api permissionsV2Api7 = source.getPermissionsV2Api();
        boolean zBooleanValue10 = (permissionsV2Api7 == null || (canRename = permissionsV2Api7.getCanRename()) == null) ? false : canRename.booleanValue();
        GetItemQuery.PermissionsV2Api permissionsV2Api8 = source.getPermissionsV2Api();
        boolean zBooleanValue11 = (permissionsV2Api8 == null || (canSetShareAccess = permissionsV2Api8.getCanSetShareAccess()) == null) ? false : canSetShareAccess.booleanValue();
        GetItemQuery.PermissionsV2Api permissionsV2Api9 = source.getPermissionsV2Api();
        boolean zBooleanValue12 = (permissionsV2Api9 == null || (canShare = permissionsV2Api9.getCanShare()) == null) ? false : canShare.booleanValue();
        GetItemQuery.PermissionsV2Api permissionsV2Api10 = source.getPermissionsV2Api();
        boolean zBooleanValue13 = (permissionsV2Api10 == null || (canUpload = permissionsV2Api10.getCanUpload()) == null) ? false : canUpload.booleanValue();
        GetItemQuery.PermissionsV2Api permissionsV2Api11 = source.getPermissionsV2Api();
        PermissionsModel permissionsModel = new PermissionsModel(zBooleanValue7, zBooleanValue10, zBooleanValue8, zBooleanValue9, zBooleanValue13, zBooleanValue5, zBooleanValue12, zBooleanValue4, zBooleanValue11, (permissionsV2Api11 == null || (canViewAnnotations = permissionsV2Api11.getCanViewAnnotations()) == null) ? false : canViewAnnotations.booleanValue(), zBooleanValue6, false, 2048, null);
        String sha1 = source.getSha1();
        String str2 = sha1 == null ? "" : sha1;
        GetItemQuery.FileVersion fileVersion = source.getFileVersion();
        FileVersionMiniModel fileVersionMiniModel = fileVersion != null ? new FileVersionMiniModel(fileVersion.getId(), fileVersion.getSha1()) : null;
        GetItemQuery.Parent parent = source.getParent();
        FolderModel folderModel2 = parent != null ? (FolderModel) GraphQLMapper.fromGraphQL$default(GQLGetCollectionItemsQueryOnFolderToFolderModelMapper.INSTANCE, new GetCollectionItemsQuery.OnFolder(parent.getId(), ItemType.folder, parent.getName(), null, null, null, null, null, null, null, null, null, null, null, null), null, 2, null) : null;
        GetItemQuery.ItemCollectionConnection itemCollectionConnection = source.getItemCollectionConnection();
        if (itemCollectionConnection == null || (edges = itemCollectionConnection.getEdges()) == null) {
            folderModel = folderModel2;
            arrayList = null;
        } else {
            List<GetItemQuery.Edge> list = edges;
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            for (GetItemQuery.Edge edge : list) {
                String id = edge.getNode().getId();
                String name2 = edge.getNode().getName();
                String str3 = name2 == null ? "" : name2;
                String collectionType = edge.getNode().getCollectionType();
                FolderModel folderModel3 = folderModel2;
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
                folderModel2 = folderModel3;
            }
            folderModel = folderModel2;
            arrayList = arrayList2;
        }
        GetItemQuery.FileLock fileLock = source.getFileLock();
        if (fileLock != null) {
            String id2 = fileLock.getId();
            String appType = fileLock.getAppType();
            Date createdAt2 = fileLock.getCreatedAt();
            GetItemQuery.CreatedBy createdBy = fileLock.getCreatedBy();
            fileLockModel = new FileLockModel(id2, appType, createdAt2, createdBy != null ? new UserModel(createdBy.getId(), createdBy.getName(), createdBy.getLogin(), null, null, null, null, null, null) : null, fileLock.getExpiresAt(), fileLock.isDownloadPrevented());
        } else {
            fileLockModel = null;
        }
        Integer commentCount = source.getCommentCount();
        Long lValueOf = commentCount != null ? Long.valueOf(commentCount.intValue()) : null;
        Integer annotationCount = source.getAnnotationCount();
        Long lValueOf2 = annotationCount != null ? Long.valueOf(annotationCount.intValue()) : null;
        String description = source.getDescription();
        GetItemQuery.Classification classification = source.getClassification();
        ClassificationModel classificationModel = classification != null ? new ClassificationModel(classification.getName(), classification.getColor(), classification.getDefinition()) : null;
        SharedLinkModel sharedLinkModelFromGetItemQueryFile = GQLSharedLinkFragmentToSharedLinkModelMapper.INSTANCE.fromGetItemQueryFile(source.getSharedLink());
        GetItemQuery.Watermark watermark = source.getWatermark();
        if (watermark != null) {
            Boolean boolIsWatermarked = watermark.isWatermarked();
            watermarkModel = new WatermarkModel(boolIsWatermarked != null ? boolIsWatermarked.booleanValue() : false, false, false, 6, null);
        } else {
            watermarkModel = null;
        }
        return new FileModel(itemIdCreateItemId, str, zBooleanValue, zBooleanValue2, folderModel, userModel3, userModel2, createdAt, contentCreatedAt, updatedAt, contentUpdatedAt, zBooleanValue3, longOrDefault, permissionsModel, null, arrayList, sharedLinkModelFromGetItemQueryFile, null, null, str2, fileVersionMiniModel, fileLockModel, lValueOf, lValueOf2, classificationModel, watermarkModel, description);
    }
}
