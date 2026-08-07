package com.box.android.data.mappers;

import com.box.android.data.api.models.collections.CollectionDTO;
import com.box.android.domain.models.CollectionModel;
import com.box.android.domain.models.CollectionType;
import com.box.androidsdk.content.utils.BoxDateFormat;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CollectionDTOToDomainModelMapper.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/box/android/data/mappers/CollectionDTOToDomainModelMapper;", "", "<init>", "()V", "toDomain", "Lcom/box/android/domain/models/CollectionModel;", "collectionDTO", "Lcom/box/android/data/api/models/collections/CollectionDTO;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CollectionDTOToDomainModelMapper {
    public static final CollectionDTOToDomainModelMapper INSTANCE = new CollectionDTOToDomainModelMapper();

    private CollectionDTOToDomainModelMapper() {
    }

    public final CollectionModel toDomain(CollectionDTO collectionDTO) {
        Intrinsics.checkNotNullParameter(collectionDTO, "collectionDTO");
        String id = collectionDTO.getId();
        CollectionType collectionType = collectionDTO.getCollectionType();
        String name = collectionDTO.getName();
        String createdAt = collectionDTO.getCreatedAt();
        Date date = createdAt != null ? BoxDateFormat.parse(createdAt) : null;
        String updatedAt = collectionDTO.getUpdatedAt();
        return new CollectionModel(id, collectionType, name, date, updatedAt != null ? BoxDateFormat.parse(updatedAt) : null);
    }
}
