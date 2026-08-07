package com.pspdfkit.annotations;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import com.pspdfkit.internal.j3;
import com.pspdfkit.internal.ji;
import com.pspdfkit.internal.o50;
import com.pspdfkit.internal.s60;
import com.pspdfkit.internal.uw;
import com.pspdfkit.utils.EdgeInsets;
import com.pspdfkit.utils.PdfLog;
import com.pspdfkit.utils.Size;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class FreeTextAnnotation extends Annotation {
    private static final Size CALLOUT_MINIMUM_SIZE = new Size(24.0f, 16.0f);
    private static final String LOG_TAG = "Nutri.FreeTextAnnotation";

    public enum FreeTextAnnotationIntent {
        FREE_TEXT,
        FREE_TEXT_CALLOUT,
        FREE_TEXT_TYPE_WRITER
    }

    public enum FreeTextTextJustification {
        LEFT,
        CENTER,
        RIGHT
    }

    public FreeTextAnnotation(int i, RectF rectF, String str) {
        super(i);
        uw.a(rectF, "rect", null);
        j3 j3Var = this.propertyManager;
        j3Var.f.a(9, rectF, true);
        j3Var.l();
        j3 j3Var2 = this.propertyManager;
        j3Var2.f.a(3, str, true);
        j3Var2.l();
    }

    private void internalSetRotation(int i, RectF rectF, boolean z) {
        if (getIntent() == FreeTextAnnotationIntent.FREE_TEXT_CALLOUT) {
            if (i % 90 != 0) {
                throw new IllegalArgumentException("Callout annotations can only be rotated in 90° increments.");
            }
            if (getRotation() != i) {
                int rotation = ((i - getRotation()) + 360) % 360;
                EdgeInsets textInsets = getTextInsets();
                textInsets.getClass();
                RectF rectF2 = new RectF();
                EdgeInsets textInsets2 = getTextInsets();
                textInsets2.getClass();
                RectF boundingBox = getBoundingBox(rectF2);
                RectF rectF3 = new RectF(boundingBox.left + textInsets2.left, boundingBox.top - textInsets2.top, boundingBox.right - textInsets2.right, boundingBox.bottom + textInsets2.bottom);
                RectF rectF4 = new RectF();
                Matrix matrix = new Matrix();
                matrix.setRotate(rotation, rectF3.centerX(), rectF3.centerY());
                matrix.mapRect(rectF4, rectF3);
                float f = rectF4.bottom;
                float f2 = rectF4.top;
                if (f > f2) {
                    rectF4.top = f;
                    rectF4.bottom = f2;
                }
                rectF2.left = ((int) textInsets.left) == 0 ? rectF4.left : Math.min(rectF2.left, rectF4.left);
                rectF2.right = ((int) textInsets.right) == 0 ? rectF4.right : Math.max(rectF2.right, rectF4.right);
                rectF2.top = ((int) textInsets.top) == 0 ? rectF4.top : Math.max(rectF2.top, rectF4.top);
                rectF2.bottom = ((int) textInsets.bottom) == 0 ? rectF4.bottom : Math.min(rectF2.bottom, rectF4.bottom);
                setBoundingBox(rectF2);
                setTextInsets(new EdgeInsets(Math.abs(rectF2.top - rectF4.top), Math.abs(rectF4.left - rectF2.left), Math.abs(rectF4.bottom - rectF2.bottom), Math.abs(rectF2.right - rectF4.right)));
                ji.a(this, false);
            }
        }
        getInternal().setRotation(i);
        setContentSize(rectF, false);
        if (z) {
            adjustBoundsForRotation();
        }
    }

    public void adjustBoundsForRotation() {
        getInternal().adjustBoundsForRotation(1.0f);
    }

    public List<PointF> getCallOutPoints() {
        List<?> listE = this.propertyManager.e(100);
        if (listE == null || listE.isEmpty()) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        for (PointF pointF : (List) listE.get(0)) {
            arrayList.add(new PointF(pointF.x, pointF.y));
        }
        return arrayList;
    }

    public FreeTextAnnotationIntent getIntent() {
        return FreeTextAnnotationIntent.values()[this.propertyManager.a(1000, 0)];
    }

    public LineEndType getLineEnd() {
        List<?> listE = this.propertyManager.e(102);
        return (listE == null || listE.isEmpty()) ? LineEndType.NONE : (LineEndType) listE.get(0);
    }

    @Override // com.pspdfkit.annotations.Annotation
    public Size getMinimumSize() {
        if (getIntent() == FreeTextAnnotationIntent.FREE_TEXT_CALLOUT) {
            return CALLOUT_MINIMUM_SIZE;
        }
        if (hasCustomMinimumSize()) {
            return super.getMinimumSize();
        }
        float fA = (ji.a(getBorderWidth()) * 2) + o50.a[0];
        return new Size(fA, fA);
    }

    public int getRotation() {
        return getInternal().getRotation() % 360;
    }

    public EdgeInsets getTextInsets() {
        return getInternal().getEdgeInsets();
    }

    public int getTextStrokeColor() {
        return this.propertyManager.a(1004, 0);
    }

    @Override // com.pspdfkit.annotations.Annotation
    public AnnotationType getType() {
        return AnnotationType.FREETEXT;
    }

    @Override // com.pspdfkit.annotations.Annotation
    /* JADX INFO: renamed from: isResizable */
    public boolean getIsResizable() {
        return getIntent() != FreeTextAnnotationIntent.FREE_TEXT_CALLOUT;
    }

    @Override // com.pspdfkit.annotations.Annotation
    public boolean isUiRotationSupported() {
        return true;
    }

    public void setCallOutPoints(List<PointF> list) {
        uw.a(list, "points", null);
        if (!list.isEmpty() && (list.size() < 2 || list.size() > 3)) {
            throw new IllegalArgumentException("You need to provide 2 or 3 points, provided: " + list.size() + " points");
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(list);
        j3 j3Var = this.propertyManager;
        j3Var.f.a(100, arrayList, true);
        j3Var.l();
    }

    @Override // com.pspdfkit.annotations.Annotation
    public void setContentSize(RectF rectF, boolean z) {
        if (getIntent() == FreeTextAnnotationIntent.FREE_TEXT_CALLOUT) {
            return;
        }
        super.setContentSize(rectF, z);
    }

    @Override // com.pspdfkit.annotations.Annotation
    public void setContents(String str) {
        setRichText(str);
        super.setContents(str);
    }

    @Override // com.pspdfkit.annotations.Annotation
    public void setFlags(EnumSet<AnnotationFlags> enumSet) {
        if (getIntent() == FreeTextAnnotationIntent.FREE_TEXT_CALLOUT) {
            enumSet.remove(AnnotationFlags.NOZOOM);
            PdfLog.e(LOG_TAG, "FreeTextAnnotations of type callout do not support the NOZOOM flag at the moment.", new Object[0]);
        }
        super.setFlags(enumSet);
    }

    public void setIntent(FreeTextAnnotationIntent freeTextAnnotationIntent) {
        uw.a(freeTextAnnotationIntent, "intent", null);
        j3 j3Var = this.propertyManager;
        j3Var.f.a(1000, Integer.valueOf(freeTextAnnotationIntent.ordinal()), true);
        j3Var.l();
    }

    public void setLineEnd(LineEndType lineEndType) {
        uw.a(lineEndType, "lineEnd", null);
        ArrayList arrayList = new ArrayList(2);
        arrayList.add(lineEndType);
        j3 j3Var = this.propertyManager;
        j3Var.f.a(102, arrayList, true);
        j3Var.l();
    }

    public void setRotation(int i, Size size, boolean z) {
        internalSetRotation(i, new RectF(0.0f, Math.abs(size.height), Math.abs(size.width), 0.0f), z);
    }

    public void setTextInsets(EdgeInsets edgeInsets) {
        getInternal().setEdgeInsets(edgeInsets);
    }

    public void setTextStrokeColor(int i) {
        j3 j3Var = this.propertyManager;
        j3Var.f.a(1004, Integer.valueOf(i), true);
        j3Var.l();
    }

    @Override // com.pspdfkit.annotations.Annotation
    public void updateTransformationProperties(RectF rectF, RectF rectF2) {
        Matrix matrixA = s60.a(rectF, rectF2);
        if (matrixA.isIdentity()) {
            return;
        }
        List<PointF> callOutPoints = getCallOutPoints();
        if (callOutPoints.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList(callOutPoints.size());
        for (PointF pointF : callOutPoints) {
            arrayList.add(new PointF(pointF.x, pointF.y));
        }
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            s60.a((PointF) obj, matrixA);
        }
        setCallOutPoints(arrayList);
    }

    @Override // com.pspdfkit.annotations.Annotation
    public FreeTextAnnotation getCopy() {
        FreeTextAnnotation freeTextAnnotation = new FreeTextAnnotation(this.propertyManager, true);
        freeTextAnnotation.getInternal().prepareForCopy();
        return freeTextAnnotation;
    }

    public void setRotation(int i) {
        RectF contentSize = getInternal().getContentSize(null);
        if (contentSize == null) {
            contentSize = getBoundingBox();
        }
        internalSetRotation(i, contentSize, true);
    }

    public FreeTextAnnotation(j3 j3Var, boolean z) {
        super(j3Var, z);
    }
}
