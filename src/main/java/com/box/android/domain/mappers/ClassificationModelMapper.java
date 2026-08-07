package com.box.android.domain.mappers;

import com.box.android.domain.models.ClassificationModel;
import com.box.androidsdk.content.models.BoxClassification;
import com.eclipsesource.json.JsonObject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ClassificationModelMapper.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\u0004\u001a\u00020\u0005*\u00020\u0006J\n\u0010\u0007\u001a\u00020\u0006*\u00020\u0005¨\u0006\b"}, d2 = {"Lcom/box/android/domain/mappers/ClassificationModelMapper;", "", "<init>", "()V", "toBoxClassification", "Lcom/box/androidsdk/content/models/BoxClassification;", "Lcom/box/android/domain/models/ClassificationModel;", "toClassificationModel", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ClassificationModelMapper {
    public static final ClassificationModelMapper INSTANCE = new ClassificationModelMapper();

    private ClassificationModelMapper() {
    }

    public final BoxClassification toBoxClassification(ClassificationModel classificationModel) {
        Intrinsics.checkNotNullParameter(classificationModel, "<this>");
        JsonObject jsonObject = new JsonObject();
        jsonObject.add("name", classificationModel.getName());
        jsonObject.add("color", classificationModel.getColor());
        jsonObject.add(BoxClassification.FIELD_DEFINITION, classificationModel.getDefinition());
        return new BoxClassification(jsonObject);
    }

    public final ClassificationModel toClassificationModel(BoxClassification boxClassification) {
        Intrinsics.checkNotNullParameter(boxClassification, "<this>");
        return new ClassificationModel(boxClassification.getName(), boxClassification.getColor(), boxClassification.getDefinition());
    }
}
