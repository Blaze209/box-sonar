package com.box.android.data.mappers.annotation;

import com.box.android.data.api.models.UserMiniDTO;
import com.box.android.data.api.models.annotations.AnnotationDTO;
import com.box.android.data.api.models.annotations.DescriptionDTO;
import com.box.android.data.api.models.annotations.FileActivityPermissionsDTO;
import com.box.android.data.api.models.annotations.Location;
import com.box.android.data.api.models.annotations.TargetDTO;
import com.box.android.data.mappers.EntityMapper;
import com.box.android.data.persistence.annotations.AnnotationEntity;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import java.util.Date;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.NotImplementedError;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: compiled from: AnnotationDTOEntityMapper.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0003H\u0016J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0002H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/box/android/data/mappers/annotation/AnnotationDTOEntityMapper;", "Lcom/box/android/data/mappers/EntityMapper;", "Lcom/box/android/data/persistence/annotations/AnnotationEntity;", "Lcom/box/android/data/api/models/annotations/AnnotationDTO;", "moshi", "Lcom/squareup/moshi/Moshi;", "fileActivityStatusDTOEntityMapper", "Lcom/box/android/data/mappers/annotation/FileActivityStatusDTOEntityMapper;", "<init>", "(Lcom/squareup/moshi/Moshi;Lcom/box/android/data/mappers/annotation/FileActivityStatusDTOEntityMapper;)V", "toEntity", "sourceModel", "fromEntity", "entityModel", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class AnnotationDTOEntityMapper implements EntityMapper<AnnotationEntity, AnnotationDTO> {
    private final FileActivityStatusDTOEntityMapper fileActivityStatusDTOEntityMapper;
    private final Moshi moshi;

    @Inject
    public AnnotationDTOEntityMapper(Moshi moshi, FileActivityStatusDTOEntityMapper fileActivityStatusDTOEntityMapper) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        Intrinsics.checkNotNullParameter(fileActivityStatusDTOEntityMapper, "fileActivityStatusDTOEntityMapper");
        this.moshi = moshi;
        this.fileActivityStatusDTOEntityMapper = fileActivityStatusDTOEntityMapper;
    }

    @Override // com.box.android.data.mappers.EntityMapper
    public AnnotationEntity toEntity(AnnotationDTO sourceModel) {
        String json;
        Intrinsics.checkNotNullParameter(sourceModel, "sourceModel");
        String json2 = this.moshi.adapter(DescriptionDTO.class).toJson(sourceModel.getDescription());
        Intrinsics.checkNotNullExpressionValue(json2, "toJson(...)");
        JsonAdapter jsonAdapterAdapter = this.moshi.adapter(UserMiniDTO.class);
        String json3 = jsonAdapterAdapter.toJson(sourceModel.getCreatedBy());
        String json4 = jsonAdapterAdapter.toJson(sourceModel.getModifiedBy());
        JsonAdapter jsonAdapterAdapter2 = this.moshi.adapter(Location.class);
        JsonAdapter jsonAdapterAdapter3 = this.moshi.adapter(TargetDTO.class);
        TargetDTO target = sourceModel.getTarget();
        if (target instanceof TargetDTO.Region) {
            json = jsonAdapterAdapter2.toJson(((TargetDTO.Region) sourceModel.getTarget()).getLocation());
        } else if (target instanceof TargetDTO.Highlight) {
            json = jsonAdapterAdapter2.toJson(((TargetDTO.Highlight) sourceModel.getTarget()).getLocation());
        } else {
            if (!(target instanceof TargetDTO.Drawing)) {
                throw new NoWhenBranchMatchedException();
            }
            json = jsonAdapterAdapter2.toJson(((TargetDTO.Drawing) sourceModel.getTarget()).getLocation());
        }
        String json5 = jsonAdapterAdapter3.toJson(sourceModel.getTarget());
        String json6 = this.moshi.adapter(FileActivityPermissionsDTO.class).toJson(sourceModel.getPermissions());
        String id = sourceModel.getId();
        String id2 = sourceModel.getFileVersion().getId();
        int versionNumber = sourceModel.getFileVersion().getVersionNumber();
        Date createdAt = sourceModel.getCreatedAt();
        Intrinsics.checkNotNull(json3);
        byte[] bytes = json3.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        Date modifiedAt = sourceModel.getModifiedAt();
        Intrinsics.checkNotNull(json4);
        byte[] bytes2 = json4.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes2, "getBytes(...)");
        byte[] bytes3 = json2.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes3, "getBytes(...)");
        Intrinsics.checkNotNull(json);
        byte[] bytes4 = json.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes4, "getBytes(...)");
        Intrinsics.checkNotNull(json5);
        byte[] bytes5 = json5.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes5, "getBytes(...)");
        Intrinsics.checkNotNull(json6);
        byte[] bytes6 = json6.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes6, "getBytes(...)");
        return new AnnotationEntity(id, id2, versionNumber, createdAt, bytes, modifiedAt, bytes2, bytes3, bytes4, bytes5, bytes6, null, sourceModel.getTotalReplies(), this.fileActivityStatusDTOEntityMapper.toEntity(sourceModel.getStatus()), 2048, null);
    }

    @Override // com.box.android.data.mappers.EntityMapper
    public AnnotationDTO fromEntity(AnnotationEntity entityModel) {
        Intrinsics.checkNotNullParameter(entityModel, "entityModel");
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }
}
