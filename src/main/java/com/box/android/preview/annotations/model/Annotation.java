package com.box.android.preview.annotations.model;

import android.graphics.Canvas;
import android.graphics.RectF;
import kotlin.Metadata;

/* JADX INFO: compiled from: Annotation.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H&J\b\u0010\u0012\u001a\u00020\u000fH&J\b\u0010\u0013\u001a\u00020\u000fH&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u0014À\u0006\u0003"}, d2 = {"Lcom/box/android/preview/annotations/model/Annotation;", "", "annotationId", "", "getAnnotationId", "()Ljava/lang/String;", "selectedState", "Lcom/box/android/preview/annotations/model/AnnotationSelectedState;", "getSelectedState", "()Lcom/box/android/preview/annotations/model/AnnotationSelectedState;", "boundingRect", "Landroid/graphics/RectF;", "getBoundingRect", "()Landroid/graphics/RectF;", "drawAnnotation", "", "canvas", "Landroid/graphics/Canvas;", "setSelected", "setUnselected", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface Annotation {
    void drawAnnotation(Canvas canvas);

    String getAnnotationId();

    RectF getBoundingRect();

    AnnotationSelectedState getSelectedState();

    void setSelected();

    void setUnselected();
}
