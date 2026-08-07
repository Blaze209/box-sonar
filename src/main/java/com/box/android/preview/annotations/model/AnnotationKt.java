package com.box.android.preview.annotations.model;

import com.box.android.domain.models.annotations.FileActivityModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Annotation.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002\u001a\u0012\u0010\u0004\u001a\u00020\u0005*\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"compare", "", "Lcom/box/android/preview/annotations/model/Annotation;", "other", "toAnnotationWithLocation", "Lcom/box/android/preview/annotations/model/AnnotationWithLocation;", "annotationModel", "Lcom/box/android/domain/models/annotations/FileActivityModel$AnnotationModel;", "preview_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class AnnotationKt {
    public static final boolean compare(Annotation annotation, Annotation other) {
        Intrinsics.checkNotNullParameter(annotation, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        return Intrinsics.areEqual(annotation.getAnnotationId(), other.getAnnotationId()) && Intrinsics.areEqual(annotation.getBoundingRect(), other.getBoundingRect());
    }

    public static final AnnotationWithLocation toAnnotationWithLocation(Annotation annotation, FileActivityModel.AnnotationModel annotationModel) {
        Intrinsics.checkNotNullParameter(annotation, "<this>");
        Intrinsics.checkNotNullParameter(annotationModel, "annotationModel");
        return new AnnotationWithLocation(annotation, annotationModel.getLocation(), annotationModel.getPermissions().getCanDelete());
    }
}
