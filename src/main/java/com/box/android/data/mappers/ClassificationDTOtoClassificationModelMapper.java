package com.box.android.data.mappers;

import com.box.android.data.api.models.ClassificationDTO;
import com.box.android.domain.models.ClassificationModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ClassificationDTOtoClassificationModelMapper.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\u0004\u001a\u00020\u0005*\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/box/android/data/mappers/ClassificationDTOtoClassificationModelMapper;", "", "<init>", "()V", "toDomain", "Lcom/box/android/domain/models/ClassificationModel;", "Lcom/box/android/data/api/models/ClassificationDTO;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ClassificationDTOtoClassificationModelMapper {
    public static final ClassificationDTOtoClassificationModelMapper INSTANCE = new ClassificationDTOtoClassificationModelMapper();

    private ClassificationDTOtoClassificationModelMapper() {
    }

    public final ClassificationModel toDomain(ClassificationDTO classificationDTO) {
        Intrinsics.checkNotNullParameter(classificationDTO, "<this>");
        return new ClassificationModel(classificationDTO.getName(), classificationDTO.getColor(), classificationDTO.getDefinition());
    }
}
