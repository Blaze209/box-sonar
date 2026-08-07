package com.box.android.preview.annotations;

import android.graphics.Canvas;
import android.graphics.RectF;
import com.box.android.preview.annotations.model.Annotation;
import com.box.android.preview.annotations.model.AnnotationSelectedState;
import com.pspdfkit.annotations.HighlightAnnotation;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PdfTextSelectionAnnotation.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000  2\u00020\u00012\u00020\u0002:\u0001 B-\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u001bH\u0016J\b\u0010\u001f\u001a\u00020\u001bH\u0016R\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0004X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006!"}, d2 = {"Lcom/box/android/preview/annotations/PdfTextSelectionAnnotation;", "Lcom/pspdfkit/annotations/HighlightAnnotation;", "Lcom/box/android/preview/annotations/model/Annotation;", "boundingBoxCoordinates", "Landroid/graphics/RectF;", "selections", "", "annotationId", "", "pageIndex", "", "<init>", "(Landroid/graphics/RectF;Ljava/util/List;Ljava/lang/String;I)V", "getAnnotationId", "()Ljava/lang/String;", "selectedState", "Lcom/box/android/preview/annotations/model/AnnotationSelectedState;", "getSelectedState", "()Lcom/box/android/preview/annotations/model/AnnotationSelectedState;", "setSelectedState", "(Lcom/box/android/preview/annotations/model/AnnotationSelectedState;)V", "boundingRect", "getBoundingRect", "()Landroid/graphics/RectF;", "setBoundingRect", "(Landroid/graphics/RectF;)V", "drawAnnotation", "", "canvas", "Landroid/graphics/Canvas;", "setSelected", "setUnselected", "Companion", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class PdfTextSelectionAnnotation extends HighlightAnnotation implements Annotation {
    public static final float ALPHA_SELECTED = 0.75f;
    public static final float ALPHA_UNSELECTED = 0.33f;
    private final String annotationId;
    private RectF boundingRect;
    private AnnotationSelectedState selectedState;
    public static final int $stable = 8;

    @Override // com.box.android.preview.annotations.model.Annotation
    public void drawAnnotation(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PdfTextSelectionAnnotation(RectF boundingBoxCoordinates, List<? extends RectF> selections, String annotationId, int i) {
        super(i, (List<RectF>) selections);
        Intrinsics.checkNotNullParameter(boundingBoxCoordinates, "boundingBoxCoordinates");
        Intrinsics.checkNotNullParameter(selections, "selections");
        Intrinsics.checkNotNullParameter(annotationId, "annotationId");
        this.annotationId = annotationId;
        this.selectedState = AnnotationSelectedState.UNSELECTED.INSTANCE;
        this.boundingRect = boundingBoxCoordinates;
        if (Intrinsics.areEqual(getSelectedState(), AnnotationSelectedState.UNSELECTED.INSTANCE)) {
            setUnselected();
        }
    }

    @Override // com.box.android.preview.annotations.model.Annotation
    public String getAnnotationId() {
        return this.annotationId;
    }

    @Override // com.box.android.preview.annotations.model.Annotation
    public AnnotationSelectedState getSelectedState() {
        return this.selectedState;
    }

    public void setSelectedState(AnnotationSelectedState annotationSelectedState) {
        Intrinsics.checkNotNullParameter(annotationSelectedState, "<set-?>");
        this.selectedState = annotationSelectedState;
    }

    @Override // com.box.android.preview.annotations.model.Annotation
    public RectF getBoundingRect() {
        return this.boundingRect;
    }

    public void setBoundingRect(RectF rectF) {
        Intrinsics.checkNotNullParameter(rectF, "<set-?>");
        this.boundingRect = rectF;
    }

    @Override // com.box.android.preview.annotations.model.Annotation
    public void setSelected() {
        setSelectedState(AnnotationSelectedState.SELECTED.INSTANCE);
        setFillAlpha(0.75f);
    }

    @Override // com.box.android.preview.annotations.model.Annotation
    public void setUnselected() {
        setSelectedState(AnnotationSelectedState.UNSELECTED.INSTANCE);
        setFillAlpha(0.33f);
    }
}
