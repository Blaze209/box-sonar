package com.box.android.data.mappers.annotation;

import com.box.android.data.api.models.annotations.VersionsDTO;
import com.box.android.data.mappers.EntityMapper;
import com.box.android.data.persistence.annotations.GroupedFileVersionEntities;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: VersionsDTOGroupedFileVersionEntitiesMapper.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rJ\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0002H\u0016J\u0012\u0010\n\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\u0003H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/box/android/data/mappers/annotation/VersionsDTOGroupedFileVersionEntitiesMapper;", "Lcom/box/android/data/mappers/EntityMapper;", "Lcom/box/android/data/persistence/annotations/GroupedFileVersionEntities;", "Lcom/box/android/data/api/models/annotations/VersionsDTO;", "fileVersionDTOV1EntityMapper", "Lcom/box/android/data/mappers/annotation/FileVersionDTOV1EntityMapper;", "versionsDTOGroupedFileVersionsEntityMapper", "Lcom/box/android/data/mappers/annotation/VersionsDTOGroupedFileVersionsEntityMapper;", "<init>", "(Lcom/box/android/data/mappers/annotation/FileVersionDTOV1EntityMapper;Lcom/box/android/data/mappers/annotation/VersionsDTOGroupedFileVersionsEntityMapper;)V", "toEntity", "sourceModel", "fileId", "", "fromEntity", "entityModel", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class VersionsDTOGroupedFileVersionEntitiesMapper implements EntityMapper<GroupedFileVersionEntities, VersionsDTO> {
    private final FileVersionDTOV1EntityMapper fileVersionDTOV1EntityMapper;
    private final VersionsDTOGroupedFileVersionsEntityMapper versionsDTOGroupedFileVersionsEntityMapper;

    @Inject
    public VersionsDTOGroupedFileVersionEntitiesMapper(FileVersionDTOV1EntityMapper fileVersionDTOV1EntityMapper, VersionsDTOGroupedFileVersionsEntityMapper versionsDTOGroupedFileVersionsEntityMapper) {
        Intrinsics.checkNotNullParameter(fileVersionDTOV1EntityMapper, "fileVersionDTOV1EntityMapper");
        Intrinsics.checkNotNullParameter(versionsDTOGroupedFileVersionsEntityMapper, "versionsDTOGroupedFileVersionsEntityMapper");
        this.fileVersionDTOV1EntityMapper = fileVersionDTOV1EntityMapper;
        this.versionsDTOGroupedFileVersionsEntityMapper = versionsDTOGroupedFileVersionsEntityMapper;
    }

    public final GroupedFileVersionEntities toEntity(VersionsDTO sourceModel, String fileId) {
        Intrinsics.checkNotNullParameter(sourceModel, "sourceModel");
        Intrinsics.checkNotNullParameter(fileId, "fileId");
        return new GroupedFileVersionEntities(this.versionsDTOGroupedFileVersionsEntityMapper.toEntity(sourceModel, fileId), this.fileVersionDTOV1EntityMapper.toEntity(sourceModel.getStart(), fileId), this.fileVersionDTOV1EntityMapper.toEntity(sourceModel.getEnd(), fileId));
    }

    @Override // com.box.android.data.mappers.EntityMapper
    public VersionsDTO fromEntity(GroupedFileVersionEntities entityModel) {
        Intrinsics.checkNotNullParameter(entityModel, "entityModel");
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.box.android.data.mappers.EntityMapper
    public GroupedFileVersionEntities toEntity(VersionsDTO sourceModel) {
        Intrinsics.checkNotNullParameter(sourceModel, "sourceModel");
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }
}
