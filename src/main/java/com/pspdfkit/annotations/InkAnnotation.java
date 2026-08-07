package com.pspdfkit.annotations;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import com.pspdfkit.internal.j3;
import com.pspdfkit.internal.s60;
import com.pspdfkit.internal.uw;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class InkAnnotation extends Annotation {
    private static final String ACTUAL_LINE_WIDTH = "InkAnnotation.ActualLineWidth";

    public InkAnnotation(int i) {
        super(i);
    }

    public float getLineWidth() {
        return this.propertyManager.a(101, 0.0f);
    }

    public List<List<PointF>> getLines() {
        List<?> listE = this.propertyManager.e(100);
        return listE == null ? new ArrayList() : new ArrayList(listE);
    }

    @Override // com.pspdfkit.annotations.Annotation
    public AnnotationType getType() {
        return AnnotationType.INK;
    }

    @Override // com.pspdfkit.annotations.Annotation
    /* JADX INFO: renamed from: isResizable */
    public boolean getIsResizable() {
        List<List<PointF>> lines = getLines();
        return lines.size() > 0 && (lines.size() > 1 || lines.get(0).size() > 1);
    }

    public void setIsSignature(boolean z) {
        getInternal().setIsSignature(z);
    }

    public void setLineWidth(float f) {
        if (isAttached()) {
            getInternal().setAdditionalData(ACTUAL_LINE_WIDTH, String.valueOf(f), false);
        }
        j3 j3Var = this.propertyManager;
        j3Var.f.a(101, Float.valueOf(f), true);
        j3Var.l();
    }

    public void setLines(List<List<PointF>> list) {
        uw.a(list, "lines", null);
        j3 j3Var = this.propertyManager;
        j3Var.f.a(100, list, true);
        j3Var.l();
    }

    @Override // com.pspdfkit.annotations.Annotation
    public void updateTransformationProperties(RectF rectF, RectF rectF2) {
        float lineWidth;
        List<List<PointF>> lines = getLines();
        if (lines.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList(lines.size());
        float fWidth = rectF.width() / rectF2.width();
        if (Float.isInfinite(fWidth) || Float.isNaN(fWidth)) {
            fWidth = 1.0f;
        }
        if (!isAttached() || getInternal().getAdditionalData(ACTUAL_LINE_WIDTH) == null) {
            lineWidth = getLineWidth();
        } else {
            try {
                lineWidth = Float.parseFloat(getInternal().getAdditionalData(ACTUAL_LINE_WIDTH));
            } catch (NumberFormatException unused) {
                lineWidth = getLineWidth();
            }
        }
        float fMax = Math.max(fWidth * lineWidth, 0.5f);
        boolean z = true;
        if (lines.size() <= 1 && lines.get(0).size() == 1) {
            z = false;
        }
        float fMax2 = (Math.max(5.0f, fMax * 0.2f) + fMax) / 2.0f;
        float fMax3 = (Math.max(5.0f, 0.2f * lineWidth) + lineWidth) / 2.0f;
        if (z) {
            rectF.inset(fMax2, -fMax2);
            rectF2.inset(fMax3, -fMax3);
        }
        Matrix matrixA = s60.a(rectF, rectF2);
        if (z) {
            rectF.inset(-fMax2, fMax2);
            rectF2.inset(-fMax3, fMax3);
        }
        for (List<PointF> list : lines) {
            ArrayList arrayList2 = new ArrayList(list.size());
            for (PointF pointF : list) {
                PointF pointF2 = new PointF(pointF.x, pointF.y);
                s60.a(pointF2, matrixA);
                arrayList2.add(pointF2);
            }
            arrayList.add(arrayList2);
        }
        setLines(arrayList);
        setLineWidth(Math.max(fMax, 0.5f));
        if (isAttached()) {
            getInternal().setAdditionalData(ACTUAL_LINE_WIDTH, String.valueOf(fMax), false);
        }
    }

    public InkAnnotation(j3 j3Var, boolean z) {
        super(j3Var, z);
    }

    @Override // com.pspdfkit.annotations.Annotation
    public InkAnnotation getCopy() {
        InkAnnotation inkAnnotation = new InkAnnotation(this.propertyManager, true);
        inkAnnotation.getInternal().prepareForCopy();
        return inkAnnotation;
    }
}
