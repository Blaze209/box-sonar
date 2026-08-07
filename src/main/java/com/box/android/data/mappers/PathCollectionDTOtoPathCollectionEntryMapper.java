package com.box.android.data.mappers;

import com.box.android.data.api.models.PathCollectionDTO;
import com.box.android.data.api.models.items.mini.FolderMiniDTO;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.models.item.ItemType;
import com.box.android.domain.models.item.PathCollectionEntry;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PathCollectionDTOtoPathCollectionEntryMapper.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"Lcom/box/android/data/mappers/PathCollectionDTOtoPathCollectionEntryMapper;", "", "<init>", "()V", "toDomain", "", "Lcom/box/android/domain/models/item/PathCollectionEntry;", "pathCollectionDTO", "Lcom/box/android/data/api/models/PathCollectionDTO;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class PathCollectionDTOtoPathCollectionEntryMapper {
    public static final PathCollectionDTOtoPathCollectionEntryMapper INSTANCE = new PathCollectionDTOtoPathCollectionEntryMapper();

    private PathCollectionDTOtoPathCollectionEntryMapper() {
    }

    public final List<PathCollectionEntry> toDomain(PathCollectionDTO pathCollectionDTO) {
        Intrinsics.checkNotNullParameter(pathCollectionDTO, "pathCollectionDTO");
        List<FolderMiniDTO> entries = pathCollectionDTO.getEntries();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(entries, 10));
        for (FolderMiniDTO folderMiniDTO : entries) {
            ItemId.Remote remote = new ItemId.Remote(folderMiniDTO.getId(), ItemType.FOLDER);
            String name = folderMiniDTO.getName();
            if (name == null) {
                name = "";
            }
            arrayList.add(new PathCollectionEntry(remote, name));
        }
        return arrayList;
    }
}
