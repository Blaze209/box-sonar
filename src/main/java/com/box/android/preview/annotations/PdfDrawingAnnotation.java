package com.box.android.preview.annotations;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.PointF;
import android.graphics.RectF;
import com.box.android.domain.models.annotations.AnnotationPath;
import com.box.android.domain.models.annotations.AnnotationPathGroup;
import com.box.android.domain.models.annotations.AnnotationPoint;
import com.box.android.preview.R;
import com.box.android.preview.annotations.model.Annotation;
import com.box.android.preview.annotations.model.AnnotationSelectedState;
import com.pspdfkit.annotations.InkAnnotation;
import com.pspdfkit.ui.drawable.PdfDrawable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PdfDrawingAnnotation.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 -2\u00020\u0001:\u0001-B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0016J\b\u0010+\u001a\u00020(H\u0016J\b\u0010,\u001a\u00020(H\u0016R\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u001e\u001a\u00020\u001f8F¢\u0006\u0006\u001a\u0004\b \u0010!R\u0017\u0010\"\u001a\b\u0012\u0004\u0012\u00020$0#¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&¨\u0006."}, d2 = {"Lcom/box/android/preview/annotations/PdfDrawingAnnotation;", "Lcom/box/android/preview/annotations/model/Annotation;", "boundingBoxCoordinates", "Landroid/graphics/RectF;", "pathGroups", "", "Lcom/box/android/domain/models/annotations/AnnotationPathGroup;", "annotationId", "", "pageIndex", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/graphics/RectF;Ljava/util/List;Ljava/lang/String;ILandroid/content/Context;)V", "getAnnotationId", "()Ljava/lang/String;", "selectedState", "Lcom/box/android/preview/annotations/model/AnnotationSelectedState;", "getSelectedState", "()Lcom/box/android/preview/annotations/model/AnnotationSelectedState;", "setSelectedState", "(Lcom/box/android/preview/annotations/model/AnnotationSelectedState;)V", "boundingRect", "getBoundingRect", "()Landroid/graphics/RectF;", "setBoundingRect", "(Landroid/graphics/RectF;)V", "_selectedShadowRect", "Lcom/box/android/preview/annotations/SelectedShadowRect;", "selectedShadowRect", "Lcom/pspdfkit/ui/drawable/PdfDrawable;", "getSelectedShadowRect", "()Lcom/pspdfkit/ui/drawable/PdfDrawable;", "inkAnnotations", "", "Lcom/pspdfkit/annotations/InkAnnotation;", "getInkAnnotations", "()Ljava/util/List;", "drawAnnotation", "", "canvas", "Landroid/graphics/Canvas;", "setSelected", "setUnselected", "Companion", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class PdfDrawingAnnotation implements Annotation {
    public static final float ALPHA_SELECTED = 1.0f;
    public static final float ALPHA_UNSELECTED = 0.5f;
    private SelectedShadowRect _selectedShadowRect;
    private final String annotationId;
    private RectF boundingRect;
    private final List<InkAnnotation> inkAnnotations;
    private AnnotationSelectedState selectedState;
    public static final int $stable = 8;

    @Override // com.box.android.preview.annotations.model.Annotation
    public void drawAnnotation(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
    }

    public PdfDrawingAnnotation(RectF boundingBoxCoordinates, List<AnnotationPathGroup> pathGroups, String annotationId, int i, Context context) {
        Intrinsics.checkNotNullParameter(boundingBoxCoordinates, "boundingBoxCoordinates");
        Intrinsics.checkNotNullParameter(pathGroups, "pathGroups");
        Intrinsics.checkNotNullParameter(annotationId, "annotationId");
        Intrinsics.checkNotNullParameter(context, "context");
        this.annotationId = annotationId;
        this.selectedState = AnnotationSelectedState.UNSELECTED.INSTANCE;
        this.boundingRect = boundingBoxCoordinates;
        this.inkAnnotations = new ArrayList();
        if (!pathGroups.isEmpty()) {
            setBoundingRect(new RectF((float) pathGroups.get(0).getPaths().get(0).getPoints().get(0).getX(), (float) pathGroups.get(0).getPaths().get(0).getPoints().get(0).getY(), (float) pathGroups.get(0).getPaths().get(0).getPoints().get(0).getX(), (float) pathGroups.get(0).getPaths().get(0).getPoints().get(0).getY()));
            for (AnnotationPathGroup annotationPathGroup : pathGroups) {
                List<InkAnnotation> list = this.inkAnnotations;
                InkAnnotation inkAnnotation = new InkAnnotation(i);
                List<AnnotationPath> paths = annotationPathGroup.getPaths();
                int i2 = 10;
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(paths, 10));
                Iterator<T> it = paths.iterator();
                while (it.hasNext()) {
                    List<AnnotationPoint> points = ((AnnotationPath) it.next()).getPoints();
                    ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(points, i2));
                    for (Iterator it2 = points.iterator(); it2.hasNext(); it2 = it2) {
                        AnnotationPoint annotationPoint = (AnnotationPoint) it2.next();
                        if (getBoundingRect().left > annotationPoint.getX()) {
                            getBoundingRect().left = (float) annotationPoint.getX();
                        }
                        if (getBoundingRect().top > annotationPoint.getY()) {
                            getBoundingRect().top = (float) annotationPoint.getY();
                        }
                        if (getBoundingRect().right < annotationPoint.getX()) {
                            getBoundingRect().right = (float) annotationPoint.getX();
                        }
                        if (getBoundingRect().bottom < annotationPoint.getY()) {
                            getBoundingRect().bottom = (float) annotationPoint.getY();
                        }
                        arrayList2.add(new PointF((float) annotationPoint.getX(), (float) annotationPoint.getY()));
                    }
                    arrayList.add(arrayList2);
                    i2 = 10;
                }
                inkAnnotation.setLines(arrayList);
                inkAnnotation.setLineWidth(annotationPathGroup.getStroke().getWidth());
                inkAnnotation.setColor(Color.parseColor(annotationPathGroup.getStroke().getColor()));
                list.add(inkAnnotation);
            }
            float dimension = context.getResources().getDimension(R.dimen.box_annotation_drawing_selection_padding) * (-1);
            getBoundingRect().inset(dimension, dimension);
        }
        this._selectedShadowRect = new SelectedShadowRect(getBoundingRect(), context, Intrinsics.areEqual(getSelectedState(), AnnotationSelectedState.SELECTED.INSTANCE));
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

    public final PdfDrawable getSelectedShadowRect() {
        return this._selectedShadowRect;
    }

    public final List<InkAnnotation> getInkAnnotations() {
        return this.inkAnnotations;
    }

    @Override // com.box.android.preview.annotations.model.Annotation
    public void setSelected() {
        setSelectedState(AnnotationSelectedState.SELECTED.INSTANCE);
        this._selectedShadowRect.setVisible(true);
        Iterator<T> it = this.inkAnnotations.iterator();
        while (it.hasNext()) {
            ((InkAnnotation) it.next()).setAlpha(1.0f);
        }
    }

    @Override // com.box.android.preview.annotations.model.Annotation
    public void setUnselected() {
        setSelectedState(AnnotationSelectedState.UNSELECTED.INSTANCE);
        this._selectedShadowRect.setVisible(false);
        Iterator<T> it = this.inkAnnotations.iterator();
        while (it.hasNext()) {
            ((InkAnnotation) it.next()).setAlpha(0.5f);
        }
    }
}
