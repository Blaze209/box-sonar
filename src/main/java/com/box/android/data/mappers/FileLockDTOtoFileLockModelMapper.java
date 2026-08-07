package com.box.android.data.mappers;

import com.box.android.data.api.models.FileLockDTO;
import com.box.android.data.api.models.UserMiniDTO;
import com.box.android.domain.models.item.FileLockModel;
import com.box.android.domain.models.item.UserModel;
import com.box.androidsdk.content.utils.BoxDateFormat;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FileLockDTOtoFileLockModelMapper.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/box/android/data/mappers/FileLockDTOtoFileLockModelMapper;", "", "<init>", "()V", "toDomain", "Lcom/box/android/domain/models/item/FileLockModel;", "fileLockDTO", "Lcom/box/android/data/api/models/FileLockDTO;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class FileLockDTOtoFileLockModelMapper {
    public static final FileLockDTOtoFileLockModelMapper INSTANCE = new FileLockDTOtoFileLockModelMapper();

    private FileLockDTOtoFileLockModelMapper() {
    }

    public final FileLockModel toDomain(FileLockDTO fileLockDTO) {
        Intrinsics.checkNotNullParameter(fileLockDTO, "fileLockDTO");
        String id = fileLockDTO.getId();
        String appType = fileLockDTO.getAppType();
        String createdAt = fileLockDTO.getCreatedAt();
        Date date = createdAt != null ? BoxDateFormat.parse(createdAt) : null;
        UserMiniDTO createdBy = fileLockDTO.getCreatedBy();
        UserModel domain = createdBy != null ? UserMiniDTOtoUserDomainModelMapper.INSTANCE.toDomain(createdBy) : null;
        String expiresAt = fileLockDTO.getExpiresAt();
        return new FileLockModel(id, appType, date, domain, expiresAt != null ? BoxDateFormat.parse(expiresAt) : null, fileLockDTO.isDownloadPrevented());
    }
}
