package com.box.android.data.mappers.annotation;

import com.box.android.data.api.models.UserMiniDTO;
import com.box.android.data.api.models.annotations.VersionsDTO;
import com.box.android.data.mappers.EntityMapper;
import com.box.android.data.persistence.annotations.GroupedFileVersionsEntity;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: compiled from: VersionsDTOGroupedFileVersionsEntityMapper.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bJ\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0002H\u0016J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\u0003H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/box/android/data/mappers/annotation/VersionsDTOGroupedFileVersionsEntityMapper;", "Lcom/box/android/data/mappers/EntityMapper;", "Lcom/box/android/data/persistence/annotations/GroupedFileVersionsEntity;", "Lcom/box/android/data/api/models/annotations/VersionsDTO;", "moshi", "Lcom/squareup/moshi/Moshi;", "<init>", "(Lcom/squareup/moshi/Moshi;)V", "toEntity", "sourceModel", "fileId", "", "fromEntity", "entityModel", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class VersionsDTOGroupedFileVersionsEntityMapper implements EntityMapper<GroupedFileVersionsEntity, VersionsDTO> {
    private final Moshi moshi;

    @Inject
    public VersionsDTOGroupedFileVersionsEntityMapper(Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        this.moshi = moshi;
    }

    public final GroupedFileVersionsEntity toEntity(VersionsDTO sourceModel, String fileId) {
        Intrinsics.checkNotNullParameter(sourceModel, "sourceModel");
        Intrinsics.checkNotNullParameter(fileId, "fileId");
        JsonAdapter jsonAdapterAdapter = this.moshi.adapter(Types.newParameterizedType(List.class, UserMiniDTO.class));
        Intrinsics.checkNotNullExpressionValue(jsonAdapterAdapter, "adapter(...)");
        String id = sourceModel.getStart().getId();
        String id2 = sourceModel.getEnd().getId();
        String json = jsonAdapterAdapter.toJson(sourceModel.getCreatedBy());
        Intrinsics.checkNotNullExpressionValue(json, "toJson(...)");
        byte[] bytes = json.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        return new GroupedFileVersionsEntity(id, id2, fileId, bytes, null, 16, null);
    }

    @Override // com.box.android.data.mappers.EntityMapper
    public VersionsDTO fromEntity(GroupedFileVersionsEntity entityModel) {
        Intrinsics.checkNotNullParameter(entityModel, "entityModel");
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.box.android.data.mappers.EntityMapper
    public GroupedFileVersionsEntity toEntity(VersionsDTO sourceModel) {
        Intrinsics.checkNotNullParameter(sourceModel, "sourceModel");
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }
}
