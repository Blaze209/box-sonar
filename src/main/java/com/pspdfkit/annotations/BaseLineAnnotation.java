package com.pspdfkit.annotations;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import androidx.core.util.Pair;
import com.pspdfkit.internal.i10;
import com.pspdfkit.internal.j3;
import com.pspdfkit.internal.qp;
import com.pspdfkit.internal.rp;
import com.pspdfkit.internal.s60;
import com.pspdfkit.internal.uw;
import com.pspdfkit.internal.xp;
import com.pspdfkit.utils.Size;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public abstract class BaseLineAnnotation extends ShapeAnnotation {
    private static final Size MINIMUM_SIZE = new Size(128.0f, 128.0f);

    public BaseLineAnnotation(int i) {
        super(i);
    }

    public List<Integer> getDashArray() {
        return getBorderDashArray();
    }

    public Pair<LineEndType, LineEndType> getLineEnds() {
        List<?> listE = this.propertyManager.e(102);
        if (listE == null || listE.isEmpty()) {
            LineEndType lineEndType = LineEndType.NONE;
            return new Pair<>(lineEndType, lineEndType);
        }
        LineEndType lineEndType2 = (LineEndType) listE.get(0);
        LineEndType lineEndType3 = LineEndType.NONE;
        if (listE.size() > 1) {
            lineEndType3 = (LineEndType) listE.get(1);
        }
        return new Pair<>(lineEndType2, lineEndType3);
    }

    public BorderStyle getLineStyle() {
        return getBorderStyle();
    }

    public float getLineWidth() {
        return getBorderWidth();
    }

    @Override // com.pspdfkit.annotations.Annotation
    public rp getMeasurementLabelValue(xp xpVar) {
        return qp.a(xpVar, getPointsList());
    }

    @Override // com.pspdfkit.annotations.ShapeAnnotation, com.pspdfkit.annotations.Annotation
    public Size getMinimumSize() {
        if (hasCustomMinimumSize()) {
            return super.getMinimumSize();
        }
        Pair<LineEndType, LineEndType> lineEnds = getLineEnds();
        List<PointF> pointsList = getPointsList();
        if (pointsList.size() < 2) {
            return MINIMUM_SIZE;
        }
        float fA = i10.a(this) / 2.0f;
        Size size = MINIMUM_SIZE;
        float f = fA * 3.0f;
        float fMax = Math.max(size.width, f);
        float fMax2 = Math.max(size.height, f);
        float lineWidth = getLineWidth();
        LineEndType lineEndType = lineEnds.first;
        LineEndType lineEndType2 = LineEndType.NONE;
        if (lineEndType != lineEndType2) {
            RectF rectFA = i10.a(pointsList.get(0), pointsList.get(1), lineEnds.first, lineWidth);
            rectFA.sort();
            fMax = Math.max(fMax, rectFA.width());
            fMax2 = Math.max(fMax2, rectFA.height());
        }
        if (lineEnds.second != lineEndType2) {
            RectF rectFA2 = i10.a(pointsList.get(pointsList.size() - 1), pointsList.get(pointsList.size() - 2), lineEnds.second, lineWidth);
            rectFA2.sort();
            fMax = Math.max(fMax, rectFA2.width());
            fMax2 = Math.max(fMax2, rectFA2.height());
        }
        return new Size(fMax, fMax2);
    }

    public List<PointF> getPointsList() {
        List<?> listE = this.propertyManager.e(103);
        return listE == null ? new ArrayList() : new ArrayList(listE);
    }

    public void setDashArray(List<Integer> list) {
        uw.a(list, "dashes", null);
        setBorderDashArray(list);
    }

    public void setLineEnds(LineEndType lineEndType, LineEndType lineEndType2) {
        uw.a(lineEndType, "lineEnd1", "Line ends may not be null.");
        ArrayList arrayList = new ArrayList(2);
        arrayList.add(lineEndType);
        arrayList.add(lineEndType2);
        j3 j3Var = this.propertyManager;
        j3Var.f.a(102, arrayList, true);
        j3Var.l();
    }

    public void setLineStyle(BorderStyle borderStyle) {
        uw.a(borderStyle, "style", null);
        setBorderStyle(borderStyle);
    }

    public void setLineWidth(float f) {
        setBorderWidth(f);
    }

    public void setPoints(List<PointF> list) {
        uw.a(list, "points", null);
        j3 j3Var = this.propertyManager;
        j3Var.f.a(103, list, true);
        j3Var.l();
    }

    @Override // com.pspdfkit.annotations.ShapeAnnotation, com.pspdfkit.annotations.Annotation
    public void updateTransformationProperties(RectF rectF, RectF rectF2) {
        super.updateTransformationProperties(rectF, rectF2);
        float fA = i10.a(this) / 2.0f;
        float f = -fA;
        rectF.inset(fA, f);
        rectF2.inset(fA, f);
        Matrix matrixA = s60.a(rectF, rectF2);
        rectF.inset(f, fA);
        rectF2.inset(f, fA);
        if (matrixA.isIdentity()) {
            return;
        }
        List<PointF> pointsList = getPointsList();
        if (pointsList.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList(pointsList.size());
        for (PointF pointF : pointsList) {
            arrayList.add(new PointF(pointF.x, pointF.y));
        }
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            s60.a((PointF) obj, matrixA);
        }
        getInternal().setPointsWithoutCoreSync(arrayList);
    }

    public BaseLineAnnotation(j3 j3Var, boolean z) {
        super(j3Var, z);
    }
}
