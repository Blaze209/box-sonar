package com.box.android.data.mappers;

import com.box.android.data.GetFolderMiniWithParentQuery;
import com.box.android.data.api.models.items.FolderDTO;
import com.box.android.data.api.models.items.mini.FolderMiniDTO;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GQLGetFolderMiniWithParentQueryToFolderDTOMapper.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0007\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u001a\u0010\n\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\u000b"}, d2 = {"Lcom/box/android/data/mappers/GQLGetFolderMiniWithParentQueryToFolderDTOMapper;", "Lcom/box/android/data/mappers/GraphQLMapper;", "Lcom/box/android/data/api/models/items/FolderDTO;", "Lcom/box/android/data/GetFolderMiniWithParentQuery$Folder;", "<init>", "()V", "toGraphQL", "source", "options", "", "fromGraphQL", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class GQLGetFolderMiniWithParentQueryToFolderDTOMapper implements GraphQLMapper<FolderDTO, GetFolderMiniWithParentQuery.Folder> {
    public static final GQLGetFolderMiniWithParentQueryToFolderDTOMapper INSTANCE = new GQLGetFolderMiniWithParentQueryToFolderDTOMapper();

    private GQLGetFolderMiniWithParentQueryToFolderDTOMapper() {
    }

    @Override // com.box.android.data.mappers.GraphQLMapper
    public GetFolderMiniWithParentQuery.Folder toGraphQL(FolderDTO source, Object options) {
        Intrinsics.checkNotNullParameter(source, "source");
        String id = source.getId();
        String name = source.getName();
        FolderMiniDTO parent = source.getParent();
        return new GetFolderMiniWithParentQuery.Folder(id, name, parent != null ? new GetFolderMiniWithParentQuery.Parent(parent.getId(), parent.getName()) : null);
    }

    @Override // com.box.android.data.mappers.GraphQLMapper
    public FolderDTO fromGraphQL(GetFolderMiniWithParentQuery.Folder source, Object options) {
        Intrinsics.checkNotNullParameter(source, "source");
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }
}
