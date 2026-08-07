package com.box.android.data.mappers;

import com.box.android.data.GetFolderMiniQuery;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.models.item.FolderModel;
import com.box.android.domain.models.item.ItemModelKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GQLGetFolderMiniQueryDataToFolderModelMapper.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0007\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u001a\u0010\n\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\u000b"}, d2 = {"Lcom/box/android/data/mappers/GQLGetFolderMiniQueryDataToFolderModelMapper;", "Lcom/box/android/data/mappers/GraphQLMapper;", "Lcom/box/android/domain/models/item/FolderModel;", "Lcom/box/android/data/GetFolderMiniQuery$Data;", "<init>", "()V", "toGraphQL", "source", "options", "", "fromGraphQL", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class GQLGetFolderMiniQueryDataToFolderModelMapper implements GraphQLMapper<FolderModel, GetFolderMiniQuery.Data> {
    public static final GQLGetFolderMiniQueryDataToFolderModelMapper INSTANCE = new GQLGetFolderMiniQueryDataToFolderModelMapper();

    private GQLGetFolderMiniQueryDataToFolderModelMapper() {
    }

    @Override // com.box.android.data.mappers.GraphQLMapper
    public GetFolderMiniQuery.Data toGraphQL(FolderModel source, Object options) {
        Intrinsics.checkNotNullParameter(source, "source");
        return new GetFolderMiniQuery.Data(new GetFolderMiniQuery.Folder(ItemModelKt.toItemIdRemoteId(source).getBoxId(), source.getName()));
    }

    @Override // com.box.android.data.mappers.GraphQLMapper
    public FolderModel fromGraphQL(GetFolderMiniQuery.Data source, Object options) throws Exception {
        Intrinsics.checkNotNullParameter(source, "source");
        GetFolderMiniQuery.Folder folder = source.getFolder();
        if (folder != null) {
            ItemId itemIdCreateItemId = FolderModel.INSTANCE.createItemId(folder.getId());
            String name = folder.getName();
            if (name == null) {
                name = "";
            }
            return new FolderModel(itemIdCreateItemId, name, false, false, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, 393216, null);
        }
        throw new Exception("Unexpected node: " + source.getFolder());
    }
}
