package com.box.android.data.mappers.annotation;

import com.box.android.data.api.models.annotations.FileActivityPermissionsDTO;
import com.box.android.data.mappers.DomainMapper;
import com.box.android.domain.models.annotations.FileActivityPermissionsModel;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FileActivityPermissionsDTOToDomainModelMapper.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0003H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0002H\u0016¨\u0006\n"}, d2 = {"Lcom/box/android/data/mappers/annotation/FileActivityPermissionsDTOToDomainModelMapper;", "Lcom/box/android/data/mappers/DomainMapper;", "Lcom/box/android/domain/models/annotations/FileActivityPermissionsModel;", "Lcom/box/android/data/api/models/annotations/FileActivityPermissionsDTO;", "<init>", "()V", "toDomain", "dataModel", "fromDomain", "domainModel", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class FileActivityPermissionsDTOToDomainModelMapper implements DomainMapper<FileActivityPermissionsModel, FileActivityPermissionsDTO> {
    public static final FileActivityPermissionsDTOToDomainModelMapper INSTANCE = new FileActivityPermissionsDTOToDomainModelMapper();

    private FileActivityPermissionsDTOToDomainModelMapper() {
    }

    @Override // com.box.android.data.mappers.DomainMapper
    public FileActivityPermissionsModel toDomain(FileActivityPermissionsDTO dataModel) {
        Intrinsics.checkNotNullParameter(dataModel, "dataModel");
        boolean canReply = dataModel.getCanReply();
        return new FileActivityPermissionsModel(dataModel.getCanDelete(), dataModel.getCanEdit(), canReply, dataModel.getCanResolve(), dataModel.getCanChangeStatus());
    }

    @Override // com.box.android.data.mappers.DomainMapper
    public FileActivityPermissionsDTO fromDomain(FileActivityPermissionsModel domainModel) {
        Intrinsics.checkNotNullParameter(domainModel, "domainModel");
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }
}
