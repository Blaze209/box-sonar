package com.box.android.data.mappers;

import com.box.android.data.GetItemWithWatermarkDataQuery;
import com.box.android.data.api.models.ClassificationDTO;
import com.box.android.data.api.models.FileLockDTO;
import com.box.android.data.api.models.PathCollectionDTO;
import com.box.android.data.api.models.PermissionsDTO;
import com.box.android.data.api.models.SharedLinkDTO;
import com.box.android.data.api.models.SharedLinkPermissionsDTO;
import com.box.android.data.api.models.UserMiniDTO;
import com.box.android.data.api.models.WatermarkDTO;
import com.box.android.data.api.models.collections.CollectionDTO;
import com.box.android.data.api.models.fileversions.FileVersionMiniDTO;
import com.box.android.data.api.models.items.FileDTO;
import com.box.android.data.api.models.items.FolderDTO;
import com.box.android.data.api.models.items.IItemDTO;
import com.box.android.data.api.models.items.WebLinkDTO;
import com.box.android.data.api.models.items.mini.FolderMiniDTO;
import com.box.android.domain.models.CollectionType;
import com.box.android.domain.models.item.ItemType;
import com.box.androidsdk.content.models.BoxOrder;
import com.box.androidsdk.content.utils.BoxDateFormat;
import com.box.androidsdk.content.utils.BoxLogUtils;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GQLGetItemWithWatermarkDataQueryToIItemDTOMapper.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000Æ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0007\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u001a\u0010\n\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0002J\u0014\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0002J\f\u0010\u0011\u001a\u00020\u0012*\u00020\u0013H\u0002J\f\u0010\u0014\u001a\u00020\u0015*\u00020\u0016H\u0002J\f\u0010\u0017\u001a\u00020\u0018*\u00020\u0019H\u0002J\f\u0010\u0017\u001a\u00020\u0018*\u00020\u001aH\u0002J\f\u0010\u0017\u001a\u00020\u0018*\u00020\u001bH\u0002J\f\u0010\u0017\u001a\u00020\u0018*\u00020\u001cH\u0002J\f\u0010\u001d\u001a\u00020\u001e*\u00020\u001fH\u0002J\f\u0010\u001d\u001a\u00020\u001e*\u00020 H\u0002J\f\u0010!\u001a\u00020\"*\u00020#H\u0002J\f\u0010!\u001a\u00020\"*\u00020$H\u0002J\f\u0010%\u001a\u00020&*\u00020'H\u0002J\f\u0010%\u001a\u00020&*\u00020(H\u0002J\f\u0010)\u001a\u00020**\u00020+H\u0002J\f\u0010)\u001a\u00020**\u00020,H\u0002J\f\u0010-\u001a\u00020.*\u00020/H\u0002J\f\u00100\u001a\u000201*\u000202H\u0002J\f\u00103\u001a\u000204*\u000205H\u0002J\f\u0010\u0017\u001a\u00020\u0018*\u000206H\u0002J\u0012\u00107\u001a\b\u0012\u0004\u0012\u00020908*\u00020:H\u0002J\u0012\u00107\u001a\b\u0012\u0004\u0012\u00020908*\u00020;H\u0002J\f\u0010<\u001a\u00020\u0003*\u00020\u0012H\u0002J\f\u0010<\u001a\u00020\u0003*\u00020\u0015H\u0002¨\u0006="}, d2 = {"Lcom/box/android/data/mappers/GQLGetItemWithWatermarkDataQueryToIItemDTOMapper;", "Lcom/box/android/data/mappers/GraphQLMapper;", "Lcom/box/android/data/api/models/items/IItemDTO;", "Lcom/box/android/data/GetItemWithWatermarkDataQuery$Item;", "<init>", "()V", "toGraphQL", "source", "options", "", "fromGraphQL", "createRootPathCollection", "Lcom/box/android/data/api/models/PathCollectionDTO;", "formatDate", "", BoxOrder.SORT_DATE, "Ljava/util/Date;", "toFileDTO", "Lcom/box/android/data/api/models/items/FileDTO;", "Lcom/box/android/data/GetItemWithWatermarkDataQuery$OnFile;", "toFolderDTO", "Lcom/box/android/data/api/models/items/FolderDTO;", "Lcom/box/android/data/GetItemWithWatermarkDataQuery$OnFolder;", "toUserMiniDTO", "Lcom/box/android/data/api/models/UserMiniDTO;", "Lcom/box/android/data/GetItemWithWatermarkDataQuery$OwnedBy;", "Lcom/box/android/data/GetItemWithWatermarkDataQuery$OwnedBy1;", "Lcom/box/android/data/GetItemWithWatermarkDataQuery$UpdatedBy;", "Lcom/box/android/data/GetItemWithWatermarkDataQuery$UpdatedBy1;", "toFolderMiniDTO", "Lcom/box/android/data/api/models/items/mini/FolderMiniDTO;", "Lcom/box/android/data/GetItemWithWatermarkDataQuery$Parent;", "Lcom/box/android/data/GetItemWithWatermarkDataQuery$Parent1;", "toPermissionsDTO", "Lcom/box/android/data/api/models/PermissionsDTO;", "Lcom/box/android/data/GetItemWithWatermarkDataQuery$PermissionsV2Api;", "Lcom/box/android/data/GetItemWithWatermarkDataQuery$PermissionsV2Api1;", "toSharedLinkDTO", "Lcom/box/android/data/api/models/SharedLinkDTO;", "Lcom/box/android/data/GetItemWithWatermarkDataQuery$SharedLink;", "Lcom/box/android/data/GetItemWithWatermarkDataQuery$SharedLink1;", "toWatermarkDTO", "Lcom/box/android/data/api/models/WatermarkDTO;", "Lcom/box/android/data/GetItemWithWatermarkDataQuery$Watermark;", "Lcom/box/android/data/GetItemWithWatermarkDataQuery$Watermark1;", "toFileVersionMiniDTO", "Lcom/box/android/data/api/models/fileversions/FileVersionMiniDTO;", "Lcom/box/android/data/GetItemWithWatermarkDataQuery$FileVersion;", "toClassificationDTO", "Lcom/box/android/data/api/models/ClassificationDTO;", "Lcom/box/android/data/GetItemWithWatermarkDataQuery$Classification;", "toFileLockDTO", "Lcom/box/android/data/api/models/FileLockDTO;", "Lcom/box/android/data/GetItemWithWatermarkDataQuery$FileLock;", "Lcom/box/android/data/GetItemWithWatermarkDataQuery$CreatedBy;", "toCollectionDTOs", "", "Lcom/box/android/data/api/models/collections/CollectionDTO;", "Lcom/box/android/data/GetItemWithWatermarkDataQuery$ItemCollectionConnection;", "Lcom/box/android/data/GetItemWithWatermarkDataQuery$ItemCollectionConnection1;", "toItemWithWatermarkData", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class GQLGetItemWithWatermarkDataQueryToIItemDTOMapper implements GraphQLMapper<IItemDTO, GetItemWithWatermarkDataQuery.Item> {
    public static final GQLGetItemWithWatermarkDataQueryToIItemDTOMapper INSTANCE = new GQLGetItemWithWatermarkDataQueryToIItemDTOMapper();

    private GQLGetItemWithWatermarkDataQueryToIItemDTOMapper() {
    }

    @Override // com.box.android.data.mappers.GraphQLMapper
    public GetItemWithWatermarkDataQuery.Item toGraphQL(IItemDTO source, Object options) {
        Intrinsics.checkNotNullParameter(source, "source");
        if (source instanceof FileDTO) {
            return toItemWithWatermarkData((FileDTO) source);
        }
        if (source instanceof FolderDTO) {
            return toItemWithWatermarkData((FolderDTO) source);
        }
        if (source instanceof WebLinkDTO) {
            return null;
        }
        BoxLogUtils.w("Unexpected source: " + source);
        return null;
    }

    @Override // com.box.android.data.mappers.GraphQLMapper
    public IItemDTO fromGraphQL(GetItemWithWatermarkDataQuery.Item source, Object options) {
        Intrinsics.checkNotNullParameter(source, "source");
        if (source.getOnFile() != null) {
            return toFileDTO(source.getOnFile());
        }
        if (source.getOnFolder() != null) {
            return toFolderDTO(source.getOnFolder());
        }
        if (source.getOnWeblink() != null) {
            BoxLogUtils.w("Weblink is not supported in GetItemWithWatermarkDataQuery");
            throw new UnsupportedOperationException("Weblink is not supported in GetItemWithWatermarkDataQuery");
        }
        throw new UnsupportedOperationException("Unexpected item type: " + source.get__typename());
    }

    private final PathCollectionDTO createRootPathCollection() {
        return new PathCollectionDTO(CollectionsKt.listOf(new FolderMiniDTO("0", ItemType.FOLDER.getValue(), null, null)), 1);
    }

    private final String formatDate(Date date) {
        if (date != null) {
            return BoxDateFormat.format(date);
        }
        return null;
    }

    private final FileDTO toFileDTO(GetItemWithWatermarkDataQuery.OnFile onFile) {
        String id = onFile.getId();
        String lowerCase = onFile.getType().name().toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        String name = onFile.getName();
        if (name == null) {
            name = "";
        }
        String date = formatDate(onFile.getCreatedAt());
        String date2 = formatDate(onFile.getUpdatedAt());
        String date3 = formatDate(onFile.getContentCreatedAt());
        String date4 = formatDate(onFile.getContentUpdatedAt());
        String description = onFile.getDescription();
        PathCollectionDTO pathCollectionDTOCreateRootPathCollection = Intrinsics.areEqual((Object) onFile.isRooted(), (Object) true) ? createRootPathCollection() : null;
        GetItemWithWatermarkDataQuery.UpdatedBy updatedBy = onFile.getUpdatedBy();
        UserMiniDTO userMiniDTO = updatedBy != null ? toUserMiniDTO(updatedBy) : null;
        GetItemWithWatermarkDataQuery.OwnedBy ownedBy = onFile.getOwnedBy();
        UserMiniDTO userMiniDTO2 = ownedBy != null ? toUserMiniDTO(ownedBy) : null;
        GetItemWithWatermarkDataQuery.PermissionsV2Api permissionsV2Api = onFile.getPermissionsV2Api();
        PermissionsDTO permissionsDTO = permissionsV2Api != null ? toPermissionsDTO(permissionsV2Api) : null;
        GetItemWithWatermarkDataQuery.ItemCollectionConnection itemCollectionConnection = onFile.getItemCollectionConnection();
        List<CollectionDTO> collectionDTOs = itemCollectionConnection != null ? toCollectionDTOs(itemCollectionConnection) : null;
        Object size = onFile.getSize();
        Long l = size instanceof Long ? (Long) size : null;
        Boolean hasCollaborations = onFile.getHasCollaborations();
        Boolean boolIsExternallyOwned = onFile.isExternallyOwned();
        Integer commentCount = onFile.getCommentCount();
        Long lValueOf = commentCount != null ? Long.valueOf(commentCount.intValue()) : null;
        Integer annotationCount = onFile.getAnnotationCount();
        Long lValueOf2 = annotationCount != null ? Long.valueOf(annotationCount.intValue()) : null;
        String sha1 = onFile.getSha1();
        GetItemWithWatermarkDataQuery.FileVersion fileVersion = onFile.getFileVersion();
        FileVersionMiniDTO fileVersionMiniDTO = fileVersion != null ? toFileVersionMiniDTO(fileVersion) : null;
        GetItemWithWatermarkDataQuery.FileLock fileLock = onFile.getFileLock();
        FileLockDTO fileLockDTO = fileLock != null ? toFileLockDTO(fileLock) : null;
        GetItemWithWatermarkDataQuery.Classification classification = onFile.getClassification();
        ClassificationDTO classificationDTO = classification != null ? toClassificationDTO(classification) : null;
        GetItemWithWatermarkDataQuery.Watermark watermark = onFile.getWatermark();
        WatermarkDTO watermarkDTO = watermark != null ? toWatermarkDTO(watermark) : null;
        GetItemWithWatermarkDataQuery.Parent parent = onFile.getParent();
        FolderMiniDTO folderMiniDTO = parent != null ? toFolderMiniDTO(parent) : null;
        GetItemWithWatermarkDataQuery.SharedLink sharedLink = onFile.getSharedLink();
        return new FileDTO(id, lowerCase, name, null, folderMiniDTO, sharedLink != null ? toSharedLinkDTO(sharedLink) : null, date, date2, date3, date4, description, pathCollectionDTOCreateRootPathCollection, userMiniDTO, userMiniDTO2, permissionsDTO, null, null, null, collectionDTOs, l, hasCollaborations, null, null, boolIsExternallyOwned, lValueOf, lValueOf2, sha1, fileVersionMiniDTO, null, null, fileLockDTO, null, classificationDTO, watermarkDTO);
    }

    private final FolderDTO toFolderDTO(GetItemWithWatermarkDataQuery.OnFolder onFolder) {
        String id = onFolder.getId();
        String lowerCase = onFolder.getType().name().toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        String name = onFolder.getName();
        if (name == null) {
            name = "";
        }
        String date = formatDate(onFolder.getCreatedAt());
        String date2 = formatDate(onFolder.getUpdatedAt());
        String date3 = formatDate(onFolder.getContentCreatedAt());
        String date4 = formatDate(onFolder.getContentUpdatedAt());
        String description = onFolder.getDescription();
        PathCollectionDTO pathCollectionDTOCreateRootPathCollection = Intrinsics.areEqual((Object) onFolder.isRooted(), (Object) true) ? createRootPathCollection() : null;
        GetItemWithWatermarkDataQuery.UpdatedBy1 updatedBy = onFolder.getUpdatedBy();
        UserMiniDTO userMiniDTO = updatedBy != null ? toUserMiniDTO(updatedBy) : null;
        GetItemWithWatermarkDataQuery.OwnedBy1 ownedBy = onFolder.getOwnedBy();
        UserMiniDTO userMiniDTO2 = ownedBy != null ? toUserMiniDTO(ownedBy) : null;
        GetItemWithWatermarkDataQuery.PermissionsV2Api1 permissionsV2Api = onFolder.getPermissionsV2Api();
        PermissionsDTO permissionsDTO = permissionsV2Api != null ? toPermissionsDTO(permissionsV2Api) : null;
        GetItemWithWatermarkDataQuery.ItemCollectionConnection1 itemCollectionConnection = onFolder.getItemCollectionConnection();
        List<CollectionDTO> collectionDTOs = itemCollectionConnection != null ? toCollectionDTOs(itemCollectionConnection) : null;
        Object size = onFolder.getSize();
        Long l = size instanceof Long ? (Long) size : null;
        Boolean hasCollaborations = onFolder.getHasCollaborations();
        Boolean boolIsExternallyOwned = onFolder.isExternallyOwned();
        GetItemWithWatermarkDataQuery.Watermark1 watermark = onFolder.getWatermark();
        WatermarkDTO watermarkDTO = watermark != null ? toWatermarkDTO(watermark) : null;
        GetItemWithWatermarkDataQuery.Parent1 parent = onFolder.getParent();
        FolderMiniDTO folderMiniDTO = parent != null ? toFolderMiniDTO(parent) : null;
        GetItemWithWatermarkDataQuery.SharedLink1 sharedLink = onFolder.getSharedLink();
        return new FolderDTO(id, lowerCase, name, null, folderMiniDTO, sharedLink != null ? toSharedLinkDTO(sharedLink) : null, date, date2, date3, date4, description, pathCollectionDTOCreateRootPathCollection, userMiniDTO, userMiniDTO2, permissionsDTO, null, null, collectionDTOs, l, hasCollaborations, null, null, boolIsExternallyOwned, null, null, watermarkDTO);
    }

    private final UserMiniDTO toUserMiniDTO(GetItemWithWatermarkDataQuery.OwnedBy ownedBy) {
        return new UserMiniDTO(ownedBy.getId(), "user", null, ownedBy.getName());
    }

    private final UserMiniDTO toUserMiniDTO(GetItemWithWatermarkDataQuery.OwnedBy1 ownedBy1) {
        return new UserMiniDTO(ownedBy1.getId(), "user", null, ownedBy1.getName());
    }

    private final UserMiniDTO toUserMiniDTO(GetItemWithWatermarkDataQuery.UpdatedBy updatedBy) {
        return new UserMiniDTO(updatedBy.getId(), "user", null, updatedBy.getName());
    }

    private final UserMiniDTO toUserMiniDTO(GetItemWithWatermarkDataQuery.UpdatedBy1 updatedBy1) {
        return new UserMiniDTO(updatedBy1.getId(), "user", null, updatedBy1.getName());
    }

    private final FolderMiniDTO toFolderMiniDTO(GetItemWithWatermarkDataQuery.Parent parent) {
        return new FolderMiniDTO(parent.getId(), "folder", parent.getName(), null);
    }

    private final FolderMiniDTO toFolderMiniDTO(GetItemWithWatermarkDataQuery.Parent1 parent1) {
        return new FolderMiniDTO(parent1.getId(), "folder", parent1.getName(), null);
    }

    private final PermissionsDTO toPermissionsDTO(GetItemWithWatermarkDataQuery.PermissionsV2Api permissionsV2Api) {
        return new PermissionsDTO(permissionsV2Api.getCanInviteCollaborator(), permissionsV2Api.getCanSetShareAccess(), permissionsV2Api.getCanDownload(), permissionsV2Api.getCanPreview(), permissionsV2Api.getCanComment(), permissionsV2Api.getCanUpload(), permissionsV2Api.getCanRename(), permissionsV2Api.getCanDelete(), permissionsV2Api.getCanShare(), permissionsV2Api.getCanViewAnnotations(), permissionsV2Api.getCanCreateAnnotations(), permissionsV2Api.getCanApplyWatermark());
    }

    private final PermissionsDTO toPermissionsDTO(GetItemWithWatermarkDataQuery.PermissionsV2Api1 permissionsV2Api1) {
        return new PermissionsDTO(permissionsV2Api1.getCanInviteCollaborator(), permissionsV2Api1.getCanSetShareAccess(), permissionsV2Api1.getCanDownload(), permissionsV2Api1.getCanPreview(), permissionsV2Api1.getCanComment(), permissionsV2Api1.getCanUpload(), permissionsV2Api1.getCanRename(), permissionsV2Api1.getCanDelete(), permissionsV2Api1.getCanShare(), permissionsV2Api1.getCanViewAnnotations(), permissionsV2Api1.getCanCreateAnnotations(), permissionsV2Api1.getCanApplyWatermark());
    }

    private final SharedLinkDTO toSharedLinkDTO(GetItemWithWatermarkDataQuery.SharedLink sharedLink) {
        String url = sharedLink.getUrl();
        String effectiveAccess = sharedLink.getEffectiveAccess();
        String effectivePermission = sharedLink.getEffectivePermission();
        Boolean boolIsPasswordEnabled = sharedLink.isPasswordEnabled();
        String date = formatDate(sharedLink.getUnsharedAt());
        Boolean canDownload = sharedLink.getCanDownload();
        return new SharedLinkDTO(null, null, null, null, effectivePermission, boolIsPasswordEnabled, canDownload != null ? new SharedLinkPermissionsDTO(Boolean.valueOf(canDownload.booleanValue()), null, null) : null, effectiveAccess, null, date, url);
    }

    private final SharedLinkDTO toSharedLinkDTO(GetItemWithWatermarkDataQuery.SharedLink1 sharedLink1) {
        String url = sharedLink1.getUrl();
        String effectiveAccess = sharedLink1.getEffectiveAccess();
        String effectivePermission = sharedLink1.getEffectivePermission();
        Boolean boolIsPasswordEnabled = sharedLink1.isPasswordEnabled();
        String date = formatDate(sharedLink1.getUnsharedAt());
        Boolean canDownload = sharedLink1.getCanDownload();
        return new SharedLinkDTO(null, null, null, null, effectivePermission, boolIsPasswordEnabled, canDownload != null ? new SharedLinkPermissionsDTO(Boolean.valueOf(canDownload.booleanValue()), null, null) : null, effectiveAccess, null, date, url);
    }

    private final WatermarkDTO toWatermarkDTO(GetItemWithWatermarkDataQuery.Watermark watermark) {
        Boolean boolIsWatermarked = watermark.isWatermarked();
        boolean zBooleanValue = boolIsWatermarked != null ? boolIsWatermarked.booleanValue() : false;
        Boolean boolIsWatermarkInherited = watermark.isWatermarkInherited();
        boolean zBooleanValue2 = boolIsWatermarkInherited != null ? boolIsWatermarkInherited.booleanValue() : false;
        Boolean boolIsWatermarkedByAccessPolicy = watermark.isWatermarkedByAccessPolicy();
        return new WatermarkDTO(zBooleanValue, zBooleanValue2, boolIsWatermarkedByAccessPolicy != null ? boolIsWatermarkedByAccessPolicy.booleanValue() : false);
    }

    private final WatermarkDTO toWatermarkDTO(GetItemWithWatermarkDataQuery.Watermark1 watermark1) {
        Boolean boolIsWatermarked = watermark1.isWatermarked();
        boolean zBooleanValue = boolIsWatermarked != null ? boolIsWatermarked.booleanValue() : false;
        Boolean boolIsWatermarkInherited = watermark1.isWatermarkInherited();
        boolean zBooleanValue2 = boolIsWatermarkInherited != null ? boolIsWatermarkInherited.booleanValue() : false;
        Boolean boolIsWatermarkedByAccessPolicy = watermark1.isWatermarkedByAccessPolicy();
        return new WatermarkDTO(zBooleanValue, zBooleanValue2, boolIsWatermarkedByAccessPolicy != null ? boolIsWatermarkedByAccessPolicy.booleanValue() : false);
    }

    private final FileVersionMiniDTO toFileVersionMiniDTO(GetItemWithWatermarkDataQuery.FileVersion fileVersion) {
        String id = fileVersion.getId();
        String sha1 = fileVersion.getSha1();
        if (sha1 == null) {
            sha1 = "";
        }
        return new FileVersionMiniDTO(id, "file_version", sha1);
    }

    private final ClassificationDTO toClassificationDTO(GetItemWithWatermarkDataQuery.Classification classification) {
        return new ClassificationDTO(classification.getName(), classification.getColor(), classification.getDefinition());
    }

    private final FileLockDTO toFileLockDTO(GetItemWithWatermarkDataQuery.FileLock fileLock) {
        String id = fileLock.getId();
        String appType = fileLock.getAppType();
        String date = formatDate(fileLock.getCreatedAt());
        GetItemWithWatermarkDataQuery.CreatedBy createdBy = fileLock.getCreatedBy();
        return new FileLockDTO(id, "file_lock", appType, date, createdBy != null ? toUserMiniDTO(createdBy) : null, formatDate(fileLock.getExpiresAt()), fileLock.isDownloadPrevented());
    }

    private final UserMiniDTO toUserMiniDTO(GetItemWithWatermarkDataQuery.CreatedBy createdBy) {
        return new UserMiniDTO(createdBy.getId(), "user", createdBy.getLogin(), createdBy.getName());
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0050  */
    private final List<CollectionDTO> toCollectionDTOs(GetItemWithWatermarkDataQuery.ItemCollectionConnection itemCollectionConnection) {
        CollectionType collectionTypeValueOf;
        String upperCase;
        List<GetItemWithWatermarkDataQuery.Edge> edges = itemCollectionConnection.getEdges();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(edges, 10));
        for (GetItemWithWatermarkDataQuery.Edge edge : edges) {
            String id = edge.getNode().getId();
            String name = edge.getNode().getName();
            if (name == null) {
                name = "";
            }
            String str = name;
            try {
                String collectionType = edge.getNode().getCollectionType();
                if (collectionType != null) {
                    upperCase = collectionType.toUpperCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
                    if (upperCase == null) {
                        upperCase = "FAVORITES";
                    }
                } else {
                    upperCase = "FAVORITES";
                }
                collectionTypeValueOf = CollectionType.valueOf(upperCase);
            } catch (IllegalArgumentException unused) {
                collectionTypeValueOf = CollectionType.FAVORITES;
            }
            arrayList.add(new CollectionDTO(id, str, collectionTypeValueOf, null, null));
        }
        return arrayList;
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0050  */
    private final List<CollectionDTO> toCollectionDTOs(GetItemWithWatermarkDataQuery.ItemCollectionConnection1 itemCollectionConnection1) {
        CollectionType collectionTypeValueOf;
        String upperCase;
        List<GetItemWithWatermarkDataQuery.Edge1> edges = itemCollectionConnection1.getEdges();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(edges, 10));
        for (GetItemWithWatermarkDataQuery.Edge1 edge1 : edges) {
            String id = edge1.getNode().getId();
            String name = edge1.getNode().getName();
            if (name == null) {
                name = "";
            }
            String str = name;
            try {
                String collectionType = edge1.getNode().getCollectionType();
                if (collectionType != null) {
                    upperCase = collectionType.toUpperCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
                    if (upperCase == null) {
                        upperCase = "FAVORITES";
                    }
                } else {
                    upperCase = "FAVORITES";
                }
                collectionTypeValueOf = CollectionType.valueOf(upperCase);
            } catch (IllegalArgumentException unused) {
                collectionTypeValueOf = CollectionType.FAVORITES;
            }
            arrayList.add(new CollectionDTO(id, str, collectionTypeValueOf, null, null));
        }
        return arrayList;
    }

    private final GetItemWithWatermarkDataQuery.Item toItemWithWatermarkData(FileDTO fileDTO) {
        GetItemWithWatermarkDataQuery.UpdatedBy updatedBy;
        Date date;
        String str;
        GetItemWithWatermarkDataQuery.ItemCollectionConnection itemCollectionConnection;
        GetItemWithWatermarkDataQuery.FileLock fileLock;
        String gQLTypename = TypenameMapperKt.toGQLTypename(ItemType.FILE);
        String id = fileDTO.getId();
        com.box.android.data.type.ItemType itemType = com.box.android.data.type.ItemType.file;
        String name = fileDTO.getName();
        String createdAt = fileDTO.getCreatedAt();
        Date date2 = createdAt != null ? BoxDateFormat.parse(createdAt) : null;
        String modifiedAt = fileDTO.getModifiedAt();
        Date date3 = modifiedAt != null ? BoxDateFormat.parse(modifiedAt) : null;
        String contentCreatedAt = fileDTO.getContentCreatedAt();
        Date date4 = contentCreatedAt != null ? BoxDateFormat.parse(contentCreatedAt) : null;
        String contentModifiedAt = fileDTO.getContentModifiedAt();
        Date date5 = contentModifiedAt != null ? BoxDateFormat.parse(contentModifiedAt) : null;
        UserMiniDTO ownedBy = fileDTO.getOwnedBy();
        GetItemWithWatermarkDataQuery.OwnedBy ownedBy2 = ownedBy != null ? new GetItemWithWatermarkDataQuery.OwnedBy(ownedBy.getId(), ownedBy.getName()) : null;
        UserMiniDTO modifiedBy = fileDTO.getModifiedBy();
        if (modifiedBy != null) {
            String id2 = modifiedBy.getId();
            String name2 = modifiedBy.getName();
            if (name2 == null) {
                name2 = "";
            }
            updatedBy = new GetItemWithWatermarkDataQuery.UpdatedBy(id2, name2);
        } else {
            updatedBy = null;
        }
        FolderMiniDTO parent = fileDTO.getParent();
        GetItemWithWatermarkDataQuery.Parent parent2 = parent != null ? new GetItemWithWatermarkDataQuery.Parent(parent.getId(), parent.getName()) : null;
        Long size = fileDTO.getSize();
        Boolean hasCollaborations = fileDTO.getHasCollaborations();
        Boolean boolIsExternallyOwned = fileDTO.isExternallyOwned();
        String sha1 = fileDTO.getSha1();
        PathCollectionDTO pathCollection = fileDTO.getPathCollection();
        boolean isRooted = pathCollection != null ? pathCollection.getIsRooted() : false;
        PermissionsDTO permissions = fileDTO.getPermissions();
        GetItemWithWatermarkDataQuery.PermissionsV2Api permissionsV2Api = permissions != null ? new GetItemWithWatermarkDataQuery.PermissionsV2Api(permissions.getCanComment(), permissions.getCanDelete(), permissions.getCanDownload(), permissions.getCanInviteCollaborator(), permissions.getCanPreview(), permissions.getCanRename(), permissions.getCanSetShareAccess(), permissions.getCanShare(), permissions.getCanUpload(), permissions.getCanViewAnnotations(), permissions.getCanCreateAnnotations(), permissions.getCanApplyWatermark()) : null;
        FileVersionMiniDTO fileVersion = fileDTO.getFileVersion();
        GetItemWithWatermarkDataQuery.FileVersion fileVersion2 = fileVersion != null ? new GetItemWithWatermarkDataQuery.FileVersion(fileVersion.getId(), fileVersion.getSha1()) : null;
        List<CollectionDTO> collections = fileDTO.getCollections();
        if (collections != null) {
            List<CollectionDTO> list = collections;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            for (CollectionDTO collectionDTO : list) {
                arrayList.add(new GetItemWithWatermarkDataQuery.Edge(collectionDTO.getId(), new GetItemWithWatermarkDataQuery.Node(collectionDTO.getId(), collectionDTO.getName(), collectionDTO.getCollectionType().name())));
                date2 = date2;
                id = id;
            }
            date = date2;
            str = id;
            itemCollectionConnection = new GetItemWithWatermarkDataQuery.ItemCollectionConnection(arrayList);
        } else {
            date = date2;
            str = id;
            itemCollectionConnection = null;
        }
        FileLockDTO fileLock2 = fileDTO.getFileLock();
        if (fileLock2 != null) {
            String id3 = fileLock2.getId();
            String appType = fileLock2.getAppType();
            String createdAt2 = fileLock2.getCreatedAt();
            Date date6 = createdAt2 != null ? BoxDateFormat.parse(createdAt2) : null;
            UserMiniDTO createdBy = fileLock2.getCreatedBy();
            GetItemWithWatermarkDataQuery.CreatedBy createdBy2 = createdBy != null ? new GetItemWithWatermarkDataQuery.CreatedBy(createdBy.getId(), createdBy.getName(), createdBy.getLogin()) : null;
            String expiresAt = fileLock2.getExpiresAt();
            fileLock = new GetItemWithWatermarkDataQuery.FileLock(id3, appType, date6, createdBy2, expiresAt != null ? BoxDateFormat.parse(expiresAt) : null, fileLock2.isDownloadPrevented());
        } else {
            fileLock = null;
        }
        Long commentCount = fileDTO.getCommentCount();
        Integer numValueOf = commentCount != null ? Integer.valueOf((int) commentCount.longValue()) : null;
        Long annotationCount = fileDTO.getAnnotationCount();
        Integer numValueOf2 = annotationCount != null ? Integer.valueOf((int) annotationCount.longValue()) : null;
        boolean z = isRooted;
        String description = fileDTO.getDescription();
        ClassificationDTO classification = fileDTO.getClassification();
        GetItemWithWatermarkDataQuery.Classification classification2 = classification != null ? new GetItemWithWatermarkDataQuery.Classification(classification.getName(), classification.getColor(), classification.getDefinition()) : null;
        GetItemWithWatermarkDataQuery.SharedLink getItemWithWatermarkDataQueryFile = SharedLinkModelToApolloSharedLinkMapper.INSTANCE.toGetItemWithWatermarkDataQueryFile(SharedLinkDTOtoSharedLinkModelMapper.INSTANCE.toSharedLinkModelOrNull(fileDTO.getSharedLink()));
        WatermarkDTO watermark = fileDTO.getWatermark();
        return new GetItemWithWatermarkDataQuery.Item(gQLTypename, new GetItemWithWatermarkDataQuery.OnFile(str, itemType, name, date, date3, description, date4, date5, Boolean.valueOf(z), numValueOf, numValueOf2, itemCollectionConnection, classification2, size, hasCollaborations, boolIsExternallyOwned, sha1, ownedBy2, updatedBy, parent2, permissionsV2Api, fileVersion2, fileLock, getItemWithWatermarkDataQueryFile, watermark != null ? new GetItemWithWatermarkDataQuery.Watermark(Boolean.valueOf(watermark.isWatermarked()), Boolean.valueOf(watermark.isWatermarkInherited()), Boolean.valueOf(watermark.isWatermarkedByAccessPolicy())) : null), null, null);
    }

    private final GetItemWithWatermarkDataQuery.Item toItemWithWatermarkData(FolderDTO folderDTO) {
        GetItemWithWatermarkDataQuery.UpdatedBy1 updatedBy1;
        Date date;
        String str;
        com.box.android.data.type.ItemType itemType;
        String str2;
        GetItemWithWatermarkDataQuery.ItemCollectionConnection1 itemCollectionConnection1;
        String gQLTypename = TypenameMapperKt.toGQLTypename(ItemType.FOLDER);
        String id = folderDTO.getId();
        com.box.android.data.type.ItemType itemType2 = com.box.android.data.type.ItemType.folder;
        String name = folderDTO.getName();
        String createdAt = folderDTO.getCreatedAt();
        Date date2 = createdAt != null ? BoxDateFormat.parse(createdAt) : null;
        String modifiedAt = folderDTO.getModifiedAt();
        Date date3 = modifiedAt != null ? BoxDateFormat.parse(modifiedAt) : null;
        String contentCreatedAt = folderDTO.getContentCreatedAt();
        Date date4 = contentCreatedAt != null ? BoxDateFormat.parse(contentCreatedAt) : null;
        String contentModifiedAt = folderDTO.getContentModifiedAt();
        Date date5 = contentModifiedAt != null ? BoxDateFormat.parse(contentModifiedAt) : null;
        UserMiniDTO ownedBy = folderDTO.getOwnedBy();
        GetItemWithWatermarkDataQuery.OwnedBy1 ownedBy1 = ownedBy != null ? new GetItemWithWatermarkDataQuery.OwnedBy1(ownedBy.getId(), ownedBy.getName()) : null;
        UserMiniDTO modifiedBy = folderDTO.getModifiedBy();
        if (modifiedBy != null) {
            String id2 = modifiedBy.getId();
            String name2 = modifiedBy.getName();
            if (name2 == null) {
                name2 = "";
            }
            updatedBy1 = new GetItemWithWatermarkDataQuery.UpdatedBy1(id2, name2);
        } else {
            updatedBy1 = null;
        }
        FolderMiniDTO parent = folderDTO.getParent();
        GetItemWithWatermarkDataQuery.Parent1 parent1 = parent != null ? new GetItemWithWatermarkDataQuery.Parent1(parent.getId(), parent.getName()) : null;
        Long size = folderDTO.getSize();
        Boolean hasCollaborations = folderDTO.getHasCollaborations();
        Boolean boolIsExternallyOwned = folderDTO.isExternallyOwned();
        PathCollectionDTO pathCollection = folderDTO.getPathCollection();
        boolean isRooted = pathCollection != null ? pathCollection.getIsRooted() : false;
        PermissionsDTO permissions = folderDTO.getPermissions();
        GetItemWithWatermarkDataQuery.PermissionsV2Api1 permissionsV2Api1 = permissions != null ? new GetItemWithWatermarkDataQuery.PermissionsV2Api1(permissions.getCanDelete(), permissions.getCanDownload(), permissions.getCanInviteCollaborator(), permissions.getCanRename(), permissions.getCanSetShareAccess(), permissions.getCanShare(), permissions.getCanUpload(), permissions.getCanPreview(), permissions.getCanComment(), permissions.getCanViewAnnotations(), permissions.getCanCreateAnnotations(), permissions.getCanApplyWatermark()) : null;
        List<CollectionDTO> collections = folderDTO.getCollections();
        if (collections != null) {
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(collections, 10));
            for (Iterator it = r10.iterator(); it.hasNext(); it = it) {
                CollectionDTO collectionDTO = (CollectionDTO) it.next();
                arrayList.add(new GetItemWithWatermarkDataQuery.Edge1(collectionDTO.getId(), new GetItemWithWatermarkDataQuery.Node1(collectionDTO.getId(), collectionDTO.getName(), collectionDTO.getCollectionType().name())));
                date2 = date2;
                id = id;
                itemType2 = itemType2;
                name = name;
            }
            date = date2;
            str = id;
            itemType = itemType2;
            str2 = name;
            itemCollectionConnection1 = new GetItemWithWatermarkDataQuery.ItemCollectionConnection1(arrayList);
        } else {
            date = date2;
            str = id;
            itemType = itemType2;
            str2 = name;
            itemCollectionConnection1 = null;
        }
        boolean z = isRooted;
        String description = folderDTO.getDescription();
        GetItemWithWatermarkDataQuery.SharedLink1 getItemWithWatermarkDataQueryFolder = SharedLinkModelToApolloSharedLinkMapper.INSTANCE.toGetItemWithWatermarkDataQueryFolder(SharedLinkDTOtoSharedLinkModelMapper.INSTANCE.toSharedLinkModelOrNull(folderDTO.getSharedLink()));
        WatermarkDTO watermark = folderDTO.getWatermark();
        return new GetItemWithWatermarkDataQuery.Item(gQLTypename, null, new GetItemWithWatermarkDataQuery.OnFolder(str, itemType, str2, date, description, date3, date4, date5, Boolean.valueOf(z), itemCollectionConnection1, size, hasCollaborations, boolIsExternallyOwned, ownedBy1, updatedBy1, parent1, permissionsV2Api1, getItemWithWatermarkDataQueryFolder, watermark != null ? new GetItemWithWatermarkDataQuery.Watermark1(Boolean.valueOf(watermark.isWatermarked()), Boolean.valueOf(watermark.isWatermarkInherited()), Boolean.valueOf(watermark.isWatermarkedByAccessPolicy())) : null), null);
    }
}
