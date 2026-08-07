package com.box.android.data.mappers.annotation;

import com.box.android.data.api.models.annotations.CommentDTO;
import com.box.android.data.api.models.annotations.ReferenceDTO;
import com.box.android.data.mappers.EntityMapper;
import com.box.android.data.persistence.annotations.CommentEntity;
import com.box.android.data.persistence.annotations.FileActivityStatus;
import com.squareup.moshi.Moshi;
import java.util.Date;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: compiled from: CommentDTOEntityMapper.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rJ\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0003H\u0016J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0002H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/box/android/data/mappers/annotation/CommentDTOEntityMapper;", "Lcom/box/android/data/mappers/EntityMapper;", "Lcom/box/android/data/persistence/annotations/CommentEntity;", "Lcom/box/android/data/api/models/annotations/CommentDTO;", "moshi", "Lcom/squareup/moshi/Moshi;", "activityStatusDTOEntityMapper", "Lcom/box/android/data/mappers/annotation/FileActivityStatusDTOEntityMapper;", "<init>", "(Lcom/squareup/moshi/Moshi;Lcom/box/android/data/mappers/annotation/FileActivityStatusDTOEntityMapper;)V", "toEntity", "sourceModel", "fileId", "", "fromEntity", "entityModel", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CommentDTOEntityMapper implements EntityMapper<CommentEntity, CommentDTO> {
    private final FileActivityStatusDTOEntityMapper activityStatusDTOEntityMapper;
    private final Moshi moshi;

    @Inject
    public CommentDTOEntityMapper(Moshi moshi, FileActivityStatusDTOEntityMapper activityStatusDTOEntityMapper) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        Intrinsics.checkNotNullParameter(activityStatusDTOEntityMapper, "activityStatusDTOEntityMapper");
        this.moshi = moshi;
        this.activityStatusDTOEntityMapper = activityStatusDTOEntityMapper;
    }

    public final CommentEntity toEntity(CommentDTO sourceModel, String fileId) {
        Intrinsics.checkNotNullParameter(sourceModel, "sourceModel");
        Intrinsics.checkNotNullParameter(fileId, "fileId");
        String json = this.moshi.adapter(CommentDTO.class).toJson(sourceModel);
        String id = sourceModel.getId();
        Date createdAt = sourceModel.getCreatedAt();
        Intrinsics.checkNotNull(json);
        byte[] bytes = json.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        int totalReplies = sourceModel.getTotalReplies();
        FileActivityStatus entity = this.activityStatusDTOEntityMapper.toEntity(sourceModel.getStatus());
        ReferenceDTO parent = sourceModel.getParent();
        return new CommentEntity(id, createdAt, fileId, bytes, null, totalReplies, entity, parent != null ? parent.getId() : null, 16, null);
    }

    @Override // com.box.android.data.mappers.EntityMapper
    public CommentEntity toEntity(CommentDTO sourceModel) {
        Intrinsics.checkNotNullParameter(sourceModel, "sourceModel");
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.box.android.data.mappers.EntityMapper
    public CommentDTO fromEntity(CommentEntity entityModel) {
        Intrinsics.checkNotNullParameter(entityModel, "entityModel");
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }
}
