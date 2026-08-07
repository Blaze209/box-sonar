package com.box.android.data.mappers;

import com.box.android.data.api.models.fileversions.FileVersionMiniDTO;
import com.box.android.domain.models.item.FileVersionMiniModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FileVersionMiniDTOMapper.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/box/android/data/mappers/FileVersionMiniDTOMapper;", "", "<init>", "()V", "toDomain", "Lcom/box/android/domain/models/item/FileVersionMiniModel;", "fileVersionMiniDTO", "Lcom/box/android/data/api/models/fileversions/FileVersionMiniDTO;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class FileVersionMiniDTOMapper {
    public static final FileVersionMiniDTOMapper INSTANCE = new FileVersionMiniDTOMapper();

    private FileVersionMiniDTOMapper() {
    }

    public final FileVersionMiniModel toDomain(FileVersionMiniDTO fileVersionMiniDTO) {
        Intrinsics.checkNotNullParameter(fileVersionMiniDTO, "fileVersionMiniDTO");
        return new FileVersionMiniModel(fileVersionMiniDTO.getId(), fileVersionMiniDTO.getSha1());
    }
}
