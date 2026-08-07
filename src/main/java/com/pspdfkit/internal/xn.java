package com.pspdfkit.internal;

import android.graphics.Matrix;
import android.graphics.PointF;
import androidx.core.util.Pair;
import com.pspdfkit.annotations.Annotation;
import com.pspdfkit.annotations.LineAnnotation;
import com.pspdfkit.annotations.LineEndType;
import com.pspdfkit.ui.inspector.views.BorderStylePreset;
import java.util.ArrayList;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public class xn extends m7<zn> {
    public xn() {
        super(new zn());
    }

    public LineAnnotation a(int i, PointF pointF, PointF pointF2) {
        return new LineAnnotation(i, pointF, pointF2);
    }

    @Override // com.pspdfkit.internal.m7, com.pspdfkit.internal.d7, com.pspdfkit.internal.r4
    public final boolean b(Annotation annotation, Matrix matrix, float f) {
        if (!(annotation instanceof LineAnnotation)) {
            throw new IllegalArgumentException("You need to pass a LineAnnotation to this shape.");
        }
        LineAnnotation lineAnnotation = (LineAnnotation) annotation;
        ArrayList arrayListA = a(matrix, f);
        boolean z = false;
        PointF pointF = arrayListA.size() < 2 ? null : (PointF) arrayListA.get(0);
        ArrayList arrayListA2 = a(matrix, f);
        PointF pointF2 = arrayListA2.size() >= 2 ? (PointF) arrayListA2.get(1) : null;
        if (pointF == null || pointF2 == null) {
            return false;
        }
        Pair<PointF, PointF> points = lineAnnotation.getPoints();
        if (!Objects.equals(points.first, pointF) || !Objects.equals(points.second, pointF2)) {
            lineAnnotation.setPoints(pointF, pointF2);
            z = true;
        }
        return a(annotation) | z;
    }

    public xn(int i, int i2, float f, float f2, BorderStylePreset borderStylePreset, Pair<LineEndType, LineEndType> pair) {
        super(new zn(i, i2, f, f2, borderStylePreset, pair));
    }

    @Override // com.pspdfkit.internal.m7, com.pspdfkit.internal.d7, com.pspdfkit.internal.r4
    public final Annotation a(int i, Matrix matrix, float f) {
        ArrayList arrayListA = a(matrix, f);
        PointF pointF = arrayListA.size() < 2 ? null : (PointF) arrayListA.get(0);
        ArrayList arrayListA2 = a(matrix, f);
        PointF pointF2 = arrayListA2.size() < 2 ? null : (PointF) arrayListA2.get(1);
        if (pointF == null || pointF2 == null) {
            return null;
        }
        LineAnnotation lineAnnotationA = a(i, pointF, pointF2);
        a(lineAnnotationA);
        return lineAnnotationA;
    }

    public xn(zn znVar) {
        super(znVar);
    }
}
