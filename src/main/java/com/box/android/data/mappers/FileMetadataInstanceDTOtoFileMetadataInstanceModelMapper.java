package com.box.android.data.mappers;

import com.box.android.data.api.models.FileMetadataInstanceDTO;
import com.box.android.domain.models.metadata.FileMetadataInstanceModel;
import com.box.android.domain.models.metadata.FileMetadataModel;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FileMetadataInstanceDTOtoFileMetadataInstanceModelMapper.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\u0004\u001a\u00020\u0005*\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/box/android/data/mappers/FileMetadataInstanceDTOtoFileMetadataInstanceModelMapper;", "", "<init>", "()V", "toDomain", "Lcom/box/android/domain/models/metadata/FileMetadataInstanceModel;", "Lcom/box/android/data/api/models/FileMetadataInstanceDTO;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class FileMetadataInstanceDTOtoFileMetadataInstanceModelMapper {
    public static final FileMetadataInstanceDTOtoFileMetadataInstanceModelMapper INSTANCE = new FileMetadataInstanceDTOtoFileMetadataInstanceModelMapper();

    private FileMetadataInstanceDTOtoFileMetadataInstanceModelMapper() {
    }

    public final FileMetadataInstanceModel toDomain(FileMetadataInstanceDTO fileMetadataInstanceDTO) {
        Intrinsics.checkNotNullParameter(fileMetadataInstanceDTO, "<this>");
        String id = fileMetadataInstanceDTO.getId();
        String scope = fileMetadataInstanceDTO.getScope();
        String templateKey = fileMetadataInstanceDTO.getTemplateKey();
        String parent = fileMetadataInstanceDTO.getParent();
        int version = fileMetadataInstanceDTO.getVersion();
        Map<String, String> fields = fileMetadataInstanceDTO.getFields();
        ArrayList arrayList = new ArrayList(fields.size());
        for (Map.Entry<String, String> entry : fields.entrySet()) {
            arrayList.add(new FileMetadataModel(entry.getKey(), entry.getValue()));
        }
        return new FileMetadataInstanceModel(id, scope, templateKey, parent, version, arrayList);
    }
}
