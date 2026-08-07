package com.box.android.data.mappers.annotation;

import com.box.android.data.api.models.annotations.FileVersionDTOV1;
import com.box.android.data.mappers.EntityMapper;
import com.box.android.data.persistence.annotations.FileVersionEntity;
import java.util.Date;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FileVersionDTOV1EntityMapper.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\t\b\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tJ\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0002H\u0016J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u0003H\u0016¨\u0006\f"}, d2 = {"Lcom/box/android/data/mappers/annotation/FileVersionDTOV1EntityMapper;", "Lcom/box/android/data/mappers/EntityMapper;", "Lcom/box/android/data/persistence/annotations/FileVersionEntity;", "Lcom/box/android/data/api/models/annotations/FileVersionDTOV1;", "<init>", "()V", "toEntity", "sourceModel", "fileId", "", "fromEntity", "entityModel", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class FileVersionDTOV1EntityMapper implements EntityMapper<FileVersionEntity, FileVersionDTOV1> {
    @Inject
    public FileVersionDTOV1EntityMapper() {
    }

    public final FileVersionEntity toEntity(FileVersionDTOV1 sourceModel, String fileId) {
        Intrinsics.checkNotNullParameter(sourceModel, "sourceModel");
        Intrinsics.checkNotNullParameter(fileId, "fileId");
        String id = sourceModel.getId();
        Date createdAt = sourceModel.getCreatedAt();
        Integer number = sourceModel.getNumber();
        return new FileVersionEntity(id, fileId, createdAt, number != null ? number.intValue() : 1, new Date());
    }

    @Override // com.box.android.data.mappers.EntityMapper
    public FileVersionDTOV1 fromEntity(FileVersionEntity entityModel) {
        Intrinsics.checkNotNullParameter(entityModel, "entityModel");
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.box.android.data.mappers.EntityMapper
    public FileVersionEntity toEntity(FileVersionDTOV1 sourceModel) {
        Intrinsics.checkNotNullParameter(sourceModel, "sourceModel");
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }
}
