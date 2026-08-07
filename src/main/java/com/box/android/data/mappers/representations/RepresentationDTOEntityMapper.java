package com.box.android.data.mappers.representations;

import com.box.android.data.api.models.RepresentationsDTO;
import com.box.android.data.mappers.EntityMapper;
import com.box.android.data.persistence.representations.RepresentationsItemEntity;
import com.box.android.domain.models.ItemId;
import com.squareup.moshi.Moshi;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RepresentationDTOEntityMapper.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001e\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0011\u001a\u00020\u0002H\u0016J\u0014\u0010\n\u001a\u0004\u0018\u00010\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0012"}, d2 = {"Lcom/box/android/data/mappers/representations/RepresentationDTOEntityMapper;", "Lcom/box/android/data/mappers/EntityMapper;", "Lcom/box/android/data/persistence/representations/RepresentationsItemEntity;", "Lcom/box/android/data/api/models/RepresentationsDTO;", "moshi", "Lcom/squareup/moshi/Moshi;", "<init>", "(Lcom/squareup/moshi/Moshi;)V", "getMoshi", "()Lcom/squareup/moshi/Moshi;", "toEntity", "sourceModel", "fileId", "Lcom/box/android/domain/models/ItemId$Remote;", "sha1", "", "fromEntity", "entityModel", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class RepresentationDTOEntityMapper implements EntityMapper<RepresentationsItemEntity, RepresentationsDTO> {
    private final Moshi moshi;

    @Inject
    public RepresentationDTOEntityMapper(Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        this.moshi = moshi;
    }

    public final Moshi getMoshi() {
        return this.moshi;
    }

    public final RepresentationsItemEntity toEntity(RepresentationsDTO sourceModel, ItemId.Remote fileId, String sha1) {
        Intrinsics.checkNotNullParameter(sourceModel, "sourceModel");
        Intrinsics.checkNotNullParameter(fileId, "fileId");
        Intrinsics.checkNotNullParameter(sha1, "sha1");
        String json = this.moshi.adapter(RepresentationsDTO.class).toJson(sourceModel);
        Intrinsics.checkNotNullExpressionValue(json, "toJson(...)");
        return new RepresentationsItemEntity(fileId, sha1, json);
    }

    @Override // com.box.android.data.mappers.EntityMapper
    public RepresentationsDTO fromEntity(RepresentationsItemEntity entityModel) {
        Intrinsics.checkNotNullParameter(entityModel, "entityModel");
        return (RepresentationsDTO) this.moshi.adapter(RepresentationsDTO.class).fromJson(entityModel.getResponseJson());
    }

    @Override // com.box.android.data.mappers.EntityMapper
    public RepresentationsItemEntity toEntity(RepresentationsDTO sourceModel) {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }
}
