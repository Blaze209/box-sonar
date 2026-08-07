package com.box.android.fileactivity.model;

import com.box.android.domain.models.annotations.AnnotationLocationModel;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AnnotationLocationModelMapper.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\u0004\u001a\u00020\u0005*\u00020\u0006J\n\u0010\u0007\u001a\u00020\u0006*\u00020\u0005¨\u0006\b"}, d2 = {"Lcom/box/android/fileactivity/model/AnnotationLocationModelMapper;", "", "<init>", "()V", "toAnnotationLocationModel", "Lcom/box/android/domain/models/annotations/AnnotationLocationModel;", "Lcom/box/android/fileactivity/model/AnnotationLocationUIModel;", "toAnnotationLocationUIModel", "file-activity_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class AnnotationLocationModelMapper {
    public static final int $stable = 0;
    public static final AnnotationLocationModelMapper INSTANCE = new AnnotationLocationModelMapper();

    private AnnotationLocationModelMapper() {
    }

    public final AnnotationLocationModel toAnnotationLocationModel(AnnotationLocationUIModel annotationLocationUIModel) {
        Intrinsics.checkNotNullParameter(annotationLocationUIModel, "<this>");
        if (annotationLocationUIModel instanceof AnnotationLocationUIModel.Page) {
            return new AnnotationLocationModel.Page(((AnnotationLocationUIModel.Page) annotationLocationUIModel).getPageNumber());
        }
        if (annotationLocationUIModel instanceof AnnotationLocationUIModel.Frame) {
            return new AnnotationLocationModel.Frame(((AnnotationLocationUIModel.Frame) annotationLocationUIModel).getFrameTimestampMs());
        }
        if (annotationLocationUIModel instanceof AnnotationLocationUIModel.None) {
            return AnnotationLocationModel.None.INSTANCE;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final AnnotationLocationUIModel toAnnotationLocationUIModel(AnnotationLocationModel annotationLocationModel) {
        Intrinsics.checkNotNullParameter(annotationLocationModel, "<this>");
        if (annotationLocationModel instanceof AnnotationLocationModel.Page) {
            return new AnnotationLocationUIModel.Page(((AnnotationLocationModel.Page) annotationLocationModel).getPageNumber());
        }
        if (annotationLocationModel instanceof AnnotationLocationModel.Frame) {
            return new AnnotationLocationUIModel.Frame(((AnnotationLocationModel.Frame) annotationLocationModel).getFrameTimestampMs());
        }
        if (annotationLocationModel instanceof AnnotationLocationModel.None) {
            return AnnotationLocationUIModel.None.INSTANCE;
        }
        throw new NoWhenBranchMatchedException();
    }
}
