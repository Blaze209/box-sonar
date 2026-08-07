package com.box.android.data.mappers;

import com.box.android.data.GetFolderMiniWithParentQuery;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.models.item.FolderModel;
import com.box.android.domain.models.item.ItemModelKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GQLGetFolderMiniWithParentQueryDataToFolderModelMapper.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0007\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u001a\u0010\n\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\u000b"}, d2 = {"Lcom/box/android/data/mappers/GQLGetFolderMiniWithParentQueryDataToFolderModelMapper;", "Lcom/box/android/data/mappers/GraphQLMapper;", "Lcom/box/android/domain/models/item/FolderModel;", "Lcom/box/android/data/GetFolderMiniWithParentQuery$Data;", "<init>", "()V", "toGraphQL", "source", "options", "", "fromGraphQL", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class GQLGetFolderMiniWithParentQueryDataToFolderModelMapper implements GraphQLMapper<FolderModel, GetFolderMiniWithParentQuery.Data> {
    public static final GQLGetFolderMiniWithParentQueryDataToFolderModelMapper INSTANCE = new GQLGetFolderMiniWithParentQueryDataToFolderModelMapper();

    private GQLGetFolderMiniWithParentQueryDataToFolderModelMapper() {
    }

    @Override // com.box.android.data.mappers.GraphQLMapper
    public GetFolderMiniWithParentQuery.Data toGraphQL(FolderModel source, Object options) {
        Intrinsics.checkNotNullParameter(source, "source");
        String boxId = ItemModelKt.toItemIdRemoteId(source).getBoxId();
        String name = source.getName();
        FolderModel parentFolder = source.getParentFolder();
        return new GetFolderMiniWithParentQuery.Data(new GetFolderMiniWithParentQuery.Folder(boxId, name, parentFolder != null ? new GetFolderMiniWithParentQuery.Parent(ItemModelKt.toItemIdRemoteId(parentFolder).getBoxId(), parentFolder.getName()) : null));
    }

    @Override // com.box.android.data.mappers.GraphQLMapper
    public FolderModel fromGraphQL(GetFolderMiniWithParentQuery.Data source, Object options) throws Exception {
        FolderModel folderModel;
        Intrinsics.checkNotNullParameter(source, "source");
        GetFolderMiniWithParentQuery.Folder folder = source.getFolder();
        if (folder != null) {
            ItemId itemIdCreateItemId = FolderModel.INSTANCE.createItemId(folder.getId());
            String name = folder.getName();
            String str = name == null ? "" : name;
            GetFolderMiniWithParentQuery.Parent parent = folder.getParent();
            if (parent != null) {
                ItemId itemIdCreateItemId2 = FolderModel.INSTANCE.createItemId(parent.getId());
                String name2 = parent.getName();
                folderModel = new FolderModel(itemIdCreateItemId2, name2 == null ? "" : name2, false, false, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, 393216, null);
            } else {
                folderModel = null;
            }
            return new FolderModel(itemIdCreateItemId, str, false, false, folderModel, null, null, null, null, null, null, false, null, null, null, null, null, null, null, 393216, null);
        }
        throw new Exception("Unexpected node: " + source.getFolder());
    }
}
