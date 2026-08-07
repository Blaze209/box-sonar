package com.box.android.data.mappers;

import com.box.android.data.CreateFolderMutation;
import com.box.android.data.api.models.PathCollectionDTO;
import com.box.android.data.api.models.PermissionsDTO;
import com.box.android.data.api.models.UserMiniDTO;
import com.box.android.data.api.models.collections.CollectionDTO;
import com.box.android.data.api.models.items.FolderDTO;
import com.box.android.data.api.models.items.IItemDTO;
import com.box.android.data.api.models.items.mini.FolderMiniDTO;
import com.box.android.data.type.ItemType;
import com.box.androidsdk.content.utils.BoxDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GQLCreateFolderToFolderDTOMapper.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u001a\u0010\n\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u001a\u0010\u0006\u001a\u00020\u000b*\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\f\u0010\u0006\u001a\u00020\u0010*\u00020\u0011H\u0002J\f\u0010\u0006\u001a\u00020\u0012*\u00020\u0013H\u0002J\f\u0010\u0006\u001a\u00020\u0014*\u00020\u0015H\u0002¨\u0006\u0016"}, d2 = {"Lcom/box/android/data/mappers/GQLCreateFolderToFolderDTOMapper;", "Lcom/box/android/data/mappers/GraphQLMapper;", "Lcom/box/android/data/api/models/items/FolderDTO;", "Lcom/box/android/data/CreateFolderMutation$Value;", "<init>", "()V", "toGraphQL", "source", "options", "", "fromGraphQL", "Lcom/box/android/data/CreateFolderMutation$ItemCollectionConnection;", "", "Lcom/box/android/data/api/models/collections/CollectionDTO;", "itemDTO", "Lcom/box/android/data/api/models/items/IItemDTO;", "Lcom/box/android/data/CreateFolderMutation$OwnedBy;", "Lcom/box/android/data/api/models/UserMiniDTO;", "Lcom/box/android/data/CreateFolderMutation$Parent;", "Lcom/box/android/data/api/models/items/mini/FolderMiniDTO;", "Lcom/box/android/data/CreateFolderMutation$PermissionsV2Api;", "Lcom/box/android/data/api/models/PermissionsDTO;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class GQLCreateFolderToFolderDTOMapper implements GraphQLMapper<FolderDTO, CreateFolderMutation.Value> {
    public static final GQLCreateFolderToFolderDTOMapper INSTANCE = new GQLCreateFolderToFolderDTOMapper();

    private GQLCreateFolderToFolderDTOMapper() {
    }

    @Override // com.box.android.data.mappers.GraphQLMapper
    public CreateFolderMutation.Value toGraphQL(FolderDTO source, Object options) {
        Intrinsics.checkNotNullParameter(source, "source");
        String id = source.getId();
        ItemType itemType = ItemType.folder;
        String name = source.getName();
        Long size = source.getSize();
        String createdAt = source.getCreatedAt();
        Date date = createdAt != null ? BoxDateFormat.parse(createdAt) : null;
        String modifiedAt = source.getModifiedAt();
        Date date2 = modifiedAt != null ? BoxDateFormat.parse(modifiedAt) : null;
        PathCollectionDTO pathCollection = source.getPathCollection();
        Boolean boolValueOf = pathCollection != null ? Boolean.valueOf(pathCollection.getIsRooted()) : null;
        List<CollectionDTO> collections = source.getCollections();
        CreateFolderMutation.ItemCollectionConnection graphQL = collections != null ? toGraphQL(collections, (IItemDTO) source) : null;
        String contentCreatedAt = source.getContentCreatedAt();
        Date date3 = contentCreatedAt != null ? BoxDateFormat.parse(contentCreatedAt) : null;
        String contentModifiedAt = source.getContentModifiedAt();
        Date date4 = contentModifiedAt != null ? BoxDateFormat.parse(contentModifiedAt) : null;
        UserMiniDTO ownedBy = source.getOwnedBy();
        CreateFolderMutation.OwnedBy graphQL2 = ownedBy != null ? toGraphQL(ownedBy) : null;
        Boolean hasCollaborations = source.getHasCollaborations();
        Boolean boolIsExternallyOwned = source.isExternallyOwned();
        FolderMiniDTO parent = source.getParent();
        CreateFolderMutation.Parent graphQL3 = parent != null ? toGraphQL(parent) : null;
        PermissionsDTO permissions = source.getPermissions();
        CreateFolderMutation.PermissionsV2Api graphQL4 = permissions != null ? toGraphQL(permissions) : null;
        UserMiniDTO modifiedBy = source.getModifiedBy();
        return new CreateFolderMutation.Value(id, itemType, name, size, date, date2, date3, date4, boolValueOf, graphQL2, hasCollaborations, boolIsExternallyOwned, graphQL3, modifiedBy != null ? new CreateFolderMutation.UpdatedBy(modifiedBy.getId(), modifiedBy.getName()) : null, graphQL4, graphQL);
    }

    @Override // com.box.android.data.mappers.GraphQLMapper
    public FolderDTO fromGraphQL(CreateFolderMutation.Value source, Object options) {
        Intrinsics.checkNotNullParameter(source, "source");
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    private final CreateFolderMutation.ItemCollectionConnection toGraphQL(List<CollectionDTO> list, IItemDTO iItemDTO) {
        List<CollectionDTO> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        for (CollectionDTO collectionDTO : list2) {
            arrayList.add(new CreateFolderMutation.Edge(collectionDTO.getId(), new CreateFolderMutation.Node(collectionDTO.getId(), collectionDTO.getName(), collectionDTO.getCollectionType().name())));
        }
        return new CreateFolderMutation.ItemCollectionConnection(arrayList);
    }

    private final CreateFolderMutation.OwnedBy toGraphQL(UserMiniDTO userMiniDTO) {
        String id = userMiniDTO.getId();
        String name = userMiniDTO.getName();
        if (name == null) {
            name = "";
        }
        return new CreateFolderMutation.OwnedBy(id, name);
    }

    private final CreateFolderMutation.Parent toGraphQL(FolderMiniDTO folderMiniDTO) {
        return new CreateFolderMutation.Parent(folderMiniDTO.getId(), folderMiniDTO.getName());
    }

    private final CreateFolderMutation.PermissionsV2Api toGraphQL(PermissionsDTO permissionsDTO) {
        return new CreateFolderMutation.PermissionsV2Api(permissionsDTO.getCanInviteCollaborator(), permissionsDTO.getCanSetShareAccess(), permissionsDTO.getCanDownload(), permissionsDTO.getCanPreview(), permissionsDTO.getCanComment(), permissionsDTO.getCanUpload(), permissionsDTO.getCanRename(), permissionsDTO.getCanDelete(), permissionsDTO.getCanShare(), permissionsDTO.getCanViewAnnotations(), permissionsDTO.getCanCreateAnnotations());
    }
}
