package com.box.android.data.mappers;

import com.box.android.data.api.models.UserMiniDTO;
import com.box.android.data.api.models.fileversions.FileVersionDTOV2;
import com.box.android.domain.models.fileversions.FileVersionModel;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FileVersionDTOV2toFileVersionModelMapper.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\u0004\u001a\u00020\u0005*\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/box/android/data/mappers/FileVersionDTOV2toFileVersionModelMapper;", "", "<init>", "()V", "toDomain", "Lcom/box/android/domain/models/fileversions/FileVersionModel;", "Lcom/box/android/data/api/models/fileversions/FileVersionDTOV2;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class FileVersionDTOV2toFileVersionModelMapper {
    public static final FileVersionDTOV2toFileVersionModelMapper INSTANCE = new FileVersionDTOV2toFileVersionModelMapper();

    private FileVersionDTOV2toFileVersionModelMapper() {
    }

    public final FileVersionModel toDomain(FileVersionDTOV2 fileVersionDTOV2) {
        Intrinsics.checkNotNullParameter(fileVersionDTOV2, "<this>");
        String id = fileVersionDTOV2.getId();
        String name = fileVersionDTOV2.getName();
        if (name == null) {
            name = "";
        }
        String str = name;
        Integer number = fileVersionDTOV2.getNumber();
        int iIntValue = number != null ? number.intValue() : 1;
        Date createdAt = fileVersionDTOV2.getCreatedAt();
        Date modifiedAt = fileVersionDTOV2.getModifiedAt();
        UserMiniDTO modifiedBy = fileVersionDTOV2.getModifiedBy();
        return new FileVersionModel(id, str, iIntValue, createdAt, modifiedAt, modifiedBy != null ? UserMiniDTOtoUserDomainModelMapper.INSTANCE.toDomain(modifiedBy) : null);
    }
}
