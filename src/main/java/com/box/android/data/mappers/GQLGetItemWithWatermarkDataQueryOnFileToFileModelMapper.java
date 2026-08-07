package com.box.android.data.mappers;

import com.box.android.common.utilities.NumberUtils;
import com.box.android.data.GetCollectionItemsQuery;
import com.box.android.data.GetItemWithWatermarkDataQuery;
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

/* JADX INFO: compiled from: GQLGetItemWithWatermarkDataQueryOnFileToFileModelMapper.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u001a\u0010\n\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\u000b"}, d2 = {"Lcom/box/android/data/mappers/GQLGetItemWithWatermarkDataQueryOnFileToFileModelMapper;", "Lcom/box/android/data/mappers/GraphQLMapper;", "Lcom/box/android/domain/models/item/FileModel;", "Lcom/box/android/data/GetItemWithWatermarkDataQuery$OnFile;", "<init>", "()V", "toGraphQL", "source", "options", "", "fromGraphQL", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class GQLGetItemWithWatermarkDataQueryOnFileToFileModelMapper implements GraphQLMapper<FileModel, GetItemWithWatermarkDataQuery.OnFile> {
    public static final GQLGetItemWithWatermarkDataQueryOnFileToFileModelMapper INSTANCE = new GQLGetItemWithWatermarkDataQueryOnFileToFileModelMapper();

    private GQLGetItemWithWatermarkDataQueryOnFileToFileModelMapper() {
    }

    @Override // com.box.android.data.mappers.GraphQLMapper
    public GetItemWithWatermarkDataQuery.OnFile toGraphQL(FileModel source, Object options) {
        GetItemWithWatermarkDataQuery.UpdatedBy updatedBy;
        long j;
        String str;
        ItemType itemType;
        GetItemWithWatermarkDataQuery.ItemCollectionConnection itemCollectionConnection;
        GetItemWithWatermarkDataQuery.FileLock fileLock;
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
        GetItemWithWatermarkDataQuery.OwnedBy ownedBy = owner != null ? new GetItemWithWatermarkDataQuery.OwnedBy(owner.getId(), owner.getName()) : null;
        UserModel updatedBy2 = source.getUpdatedBy();
        if (updatedBy2 != null) {
            String id = updatedBy2.getId();
            String name2 = updatedBy2.getName();
            if (name2 == null) {
                name2 = "";
            }
            updatedBy = new GetItemWithWatermarkDataQuery.UpdatedBy(id, name2);
        } else {
            updatedBy = null;
        }
        FolderModel parentFolder = source.getParentFolder();
        GetItemWithWatermarkDataQuery.Parent parent = parentFolder != null ? new GetItemWithWatermarkDataQuery.Parent(ItemModelKt.toItemIdRemoteId(parentFolder).getBoxId(), parentFolder.getName()) : null;
        boolean hasCollaborations = source.getHasCollaborations();
        boolean zIsExternallyOwned = source.isExternallyOwned();
        String sha1 = source.getSha1();
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
        Boolean boolValueOf11 = permissions11 != null ? Boolean.valueOf(permissions11.getCanViewAnnotations()) : null;
        PermissionsModel permissions12 = source.getPermissions();
        GetItemWithWatermarkDataQuery.PermissionsV2Api permissionsV2Api = new GetItemWithWatermarkDataQuery.PermissionsV2Api(boolValueOf2, boolValueOf4, boolValueOf5, boolValueOf, boolValueOf6, boolValueOf7, boolValueOf8, boolValueOf9, boolValueOf10, boolValueOf11, boolValueOf3, permissions12 != null ? Boolean.valueOf(permissions12.getCanApplyWatermark()) : null);
        FileVersionMiniModel fileVersion = source.getFileVersion();
        GetItemWithWatermarkDataQuery.FileVersion fileVersion2 = fileVersion != null ? new GetItemWithWatermarkDataQuery.FileVersion(fileVersion.getId(), fileVersion.getSha1()) : null;
        List<CollectionModel> collections = source.getCollections();
        if (collections != null) {
            List<CollectionModel> list = collections;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            for (CollectionModel collectionModel : list) {
                arrayList.add(new GetItemWithWatermarkDataQuery.Edge(collectionModel.getId(), new GetItemWithWatermarkDataQuery.Node(collectionModel.getId(), collectionModel.getName(), collectionModel.getType().name())));
                boxId = boxId;
                jLongValue = jLongValue;
                itemType2 = itemType2;
            }
            j = jLongValue;
            str = boxId;
            itemType = itemType2;
            itemCollectionConnection = new GetItemWithWatermarkDataQuery.ItemCollectionConnection(arrayList);
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
            fileLock = new GetItemWithWatermarkDataQuery.FileLock(id2, appType, createdAt, createdBy != null ? new GetItemWithWatermarkDataQuery.CreatedBy(createdBy.getId(), createdBy.getName(), createdBy.getLogin()) : null, fileLock2.getExpiresAt(), fileLock2.isDownloadPrevented());
        } else {
            fileLock = null;
        }
        Long commentCount = source.getCommentCount();
        Integer numValueOf = commentCount != null ? Integer.valueOf((int) commentCount.longValue()) : null;
        Long annotationCount = source.getAnnotationCount();
        Integer numValueOf2 = annotationCount != null ? Integer.valueOf((int) annotationCount.longValue()) : null;
        String description = source.getDescription();
        ClassificationModel classification = source.getClassification();
        GetItemWithWatermarkDataQuery.Classification classification2 = classification != null ? new GetItemWithWatermarkDataQuery.Classification(classification.getName(), classification.getColor(), classification.getDefinition()) : null;
        GetItemWithWatermarkDataQuery.SharedLink getItemWithWatermarkDataQueryFile = SharedLinkModelToApolloSharedLinkMapper.INSTANCE.toGetItemWithWatermarkDataQueryFile(source.getSharedLink());
        WatermarkModel watermark = source.getWatermark();
        return new GetItemWithWatermarkDataQuery.OnFile(str, itemType, name, createdDate, modifiedDate, description, contentCreatedDate, contentModifiedDate, Boolean.valueOf(zIsRooted), numValueOf, numValueOf2, itemCollectionConnection, classification2, Long.valueOf(j), Boolean.valueOf(hasCollaborations), Boolean.valueOf(zIsExternallyOwned), sha1, ownedBy, updatedBy, parent, permissionsV2Api, fileVersion2, fileLock, getItemWithWatermarkDataQueryFile, watermark != null ? new GetItemWithWatermarkDataQuery.Watermark(Boolean.valueOf(watermark.isWatermarked()), Boolean.valueOf(watermark.isWatermarkInherited()), Boolean.valueOf(watermark.isWatermarkedByAccessPolicy())) : null);
    }

    /* JADX WARN: Code duplicated, block: B:125:0x0269  */
    @Override // com.box.android.data.mappers.GraphQLMapper
    public FileModel fromGraphQL(GetItemWithWatermarkDataQuery.OnFile source, Object options) {
        FolderModel folderModel;
        ArrayList arrayList;
        FileLockModel fileLockModel;
        WatermarkModel watermarkModel;
        List<GetItemWithWatermarkDataQuery.Edge> edges;
        CollectionType collectionTypeValueOf;
        Boolean canApplyWatermark;
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
        GetItemWithWatermarkDataQuery.OwnedBy ownedBy = source.getOwnedBy();
        UserModel userModel = ownedBy != null ? new UserModel(ownedBy.getId(), ownedBy.getName(), null, null, null, null, null, null, null) : null;
        GetItemWithWatermarkDataQuery.UpdatedBy updatedBy = source.getUpdatedBy();
        UserModel userModel2 = updatedBy != null ? new UserModel(updatedBy.getId(), updatedBy.getName(), null, null, null, null, null, null, null) : null;
        Date createdAt = source.getCreatedAt();
        Date updatedAt = source.getUpdatedAt();
        Date contentCreatedAt = source.getContentCreatedAt();
        Date contentUpdatedAt = source.getContentUpdatedAt();
        Boolean boolIsRooted = source.isRooted();
        boolean zBooleanValue3 = boolIsRooted != null ? boolIsRooted.booleanValue() : false;
        UserModel userModel3 = userModel;
        long longOrDefault = NumberUtils.INSTANCE.toLongOrDefault(source.getSize(), 0L);
        GetItemWithWatermarkDataQuery.PermissionsV2Api permissionsV2Api = source.getPermissionsV2Api();
        boolean zBooleanValue4 = (permissionsV2Api == null || (canInviteCollaborator = permissionsV2Api.getCanInviteCollaborator()) == null) ? false : canInviteCollaborator.booleanValue();
        GetItemWithWatermarkDataQuery.PermissionsV2Api permissionsV2Api2 = source.getPermissionsV2Api();
        boolean zBooleanValue5 = (permissionsV2Api2 == null || (canComment = permissionsV2Api2.getCanComment()) == null) ? false : canComment.booleanValue();
        GetItemWithWatermarkDataQuery.PermissionsV2Api permissionsV2Api3 = source.getPermissionsV2Api();
        boolean zBooleanValue6 = (permissionsV2Api3 == null || (canCreateAnnotations = permissionsV2Api3.getCanCreateAnnotations()) == null) ? false : canCreateAnnotations.booleanValue();
        GetItemWithWatermarkDataQuery.PermissionsV2Api permissionsV2Api4 = source.getPermissionsV2Api();
        boolean zBooleanValue7 = (permissionsV2Api4 == null || (canDelete = permissionsV2Api4.getCanDelete()) == null) ? false : canDelete.booleanValue();
        GetItemWithWatermarkDataQuery.PermissionsV2Api permissionsV2Api5 = source.getPermissionsV2Api();
        boolean zBooleanValue8 = (permissionsV2Api5 == null || (canDownload = permissionsV2Api5.getCanDownload()) == null) ? false : canDownload.booleanValue();
        GetItemWithWatermarkDataQuery.PermissionsV2Api permissionsV2Api6 = source.getPermissionsV2Api();
        boolean zBooleanValue9 = (permissionsV2Api6 == null || (canPreview = permissionsV2Api6.getCanPreview()) == null) ? false : canPreview.booleanValue();
        GetItemWithWatermarkDataQuery.PermissionsV2Api permissionsV2Api7 = source.getPermissionsV2Api();
        boolean zBooleanValue10 = (permissionsV2Api7 == null || (canRename = permissionsV2Api7.getCanRename()) == null) ? false : canRename.booleanValue();
        GetItemWithWatermarkDataQuery.PermissionsV2Api permissionsV2Api8 = source.getPermissionsV2Api();
        boolean zBooleanValue11 = (permissionsV2Api8 == null || (canSetShareAccess = permissionsV2Api8.getCanSetShareAccess()) == null) ? false : canSetShareAccess.booleanValue();
        GetItemWithWatermarkDataQuery.PermissionsV2Api permissionsV2Api9 = source.getPermissionsV2Api();
        boolean zBooleanValue12 = (permissionsV2Api9 == null || (canShare = permissionsV2Api9.getCanShare()) == null) ? false : canShare.booleanValue();
        GetItemWithWatermarkDataQuery.PermissionsV2Api permissionsV2Api10 = source.getPermissionsV2Api();
        boolean zBooleanValue13 = (permissionsV2Api10 == null || (canUpload = permissionsV2Api10.getCanUpload()) == null) ? false : canUpload.booleanValue();
        GetItemWithWatermarkDataQuery.PermissionsV2Api permissionsV2Api11 = source.getPermissionsV2Api();
        boolean zBooleanValue14 = (permissionsV2Api11 == null || (canViewAnnotations = permissionsV2Api11.getCanViewAnnotations()) == null) ? false : canViewAnnotations.booleanValue();
        GetItemWithWatermarkDataQuery.PermissionsV2Api permissionsV2Api12 = source.getPermissionsV2Api();
        PermissionsModel permissionsModel = new PermissionsModel(zBooleanValue7, zBooleanValue10, zBooleanValue8, zBooleanValue9, zBooleanValue13, zBooleanValue5, zBooleanValue12, zBooleanValue4, zBooleanValue11, zBooleanValue14, zBooleanValue6, (permissionsV2Api12 == null || (canApplyWatermark = permissionsV2Api12.getCanApplyWatermark()) == null) ? false : canApplyWatermark.booleanValue());
        String sha1 = source.getSha1();
        String str2 = sha1 == null ? "" : sha1;
        GetItemWithWatermarkDataQuery.FileVersion fileVersion = source.getFileVersion();
        FileVersionMiniModel fileVersionMiniModel = fileVersion != null ? new FileVersionMiniModel(fileVersion.getId(), fileVersion.getSha1()) : null;
        GetItemWithWatermarkDataQuery.Parent parent = source.getParent();
        FolderModel folderModel2 = parent != null ? (FolderModel) GraphQLMapper.fromGraphQL$default(GQLGetCollectionItemsQueryOnFolderToFolderModelMapper.INSTANCE, new GetCollectionItemsQuery.OnFolder(parent.getId(), ItemType.folder, parent.getName(), null, null, null, null, null, null, null, null, null, null, null, null), null, 2, null) : null;
        GetItemWithWatermarkDataQuery.ItemCollectionConnection itemCollectionConnection = source.getItemCollectionConnection();
        if (itemCollectionConnection == null || (edges = itemCollectionConnection.getEdges()) == null) {
            folderModel = folderModel2;
            arrayList = null;
        } else {
            List<GetItemWithWatermarkDataQuery.Edge> list = edges;
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            for (GetItemWithWatermarkDataQuery.Edge edge : list) {
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
        GetItemWithWatermarkDataQuery.FileLock fileLock = source.getFileLock();
        if (fileLock != null) {
            String id2 = fileLock.getId();
            String appType = fileLock.getAppType();
            Date createdAt2 = fileLock.getCreatedAt();
            GetItemWithWatermarkDataQuery.CreatedBy createdBy = fileLock.getCreatedBy();
            fileLockModel = new FileLockModel(id2, appType, createdAt2, createdBy != null ? new UserModel(createdBy.getId(), createdBy.getName(), createdBy.getLogin(), null, null, null, null, null, null) : null, fileLock.getExpiresAt(), fileLock.isDownloadPrevented());
        } else {
            fileLockModel = null;
        }
        Integer commentCount = source.getCommentCount();
        Long lValueOf = commentCount != null ? Long.valueOf(commentCount.intValue()) : null;
        Integer annotationCount = source.getAnnotationCount();
        Long lValueOf2 = annotationCount != null ? Long.valueOf(annotationCount.intValue()) : null;
        String description = source.getDescription();
        GetItemWithWatermarkDataQuery.Classification classification = source.getClassification();
        ClassificationModel classificationModel = classification != null ? new ClassificationModel(classification.getName(), classification.getColor(), classification.getDefinition()) : null;
        SharedLinkModel sharedLinkModelFromGetItemWithWatermarkDataQueryFile = GQLSharedLinkFragmentToSharedLinkModelMapper.INSTANCE.fromGetItemWithWatermarkDataQueryFile(source.getSharedLink());
        GetItemWithWatermarkDataQuery.Watermark watermark = source.getWatermark();
        if (watermark != null) {
            Boolean boolIsWatermarked = watermark.isWatermarked();
            boolean zBooleanValue15 = boolIsWatermarked != null ? boolIsWatermarked.booleanValue() : false;
            Boolean boolIsWatermarkInherited = watermark.isWatermarkInherited();
            boolean zBooleanValue16 = boolIsWatermarkInherited != null ? boolIsWatermarkInherited.booleanValue() : false;
            Boolean boolIsWatermarkedByAccessPolicy = watermark.isWatermarkedByAccessPolicy();
            watermarkModel = new WatermarkModel(zBooleanValue15, zBooleanValue16, boolIsWatermarkedByAccessPolicy != null ? boolIsWatermarkedByAccessPolicy.booleanValue() : false);
        } else {
            watermarkModel = null;
        }
        return new FileModel(itemIdCreateItemId, str, zBooleanValue, zBooleanValue2, folderModel, userModel3, userModel2, createdAt, contentCreatedAt, updatedAt, contentUpdatedAt, zBooleanValue3, longOrDefault, permissionsModel, null, arrayList, sharedLinkModelFromGetItemWithWatermarkDataQueryFile, null, null, str2, fileVersionMiniModel, fileLockModel, lValueOf, lValueOf2, classificationModel, watermarkModel, description);
    }
}
