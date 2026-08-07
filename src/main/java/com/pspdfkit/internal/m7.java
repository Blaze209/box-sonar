package com.pspdfkit.internal;

import android.graphics.Matrix;
import androidx.core.util.Pair;
import com.pspdfkit.annotations.Annotation;
import com.pspdfkit.annotations.BorderEffect;
import com.pspdfkit.annotations.BorderStyle;
import com.pspdfkit.annotations.LineEndType;
import com.pspdfkit.annotations.PolylineAnnotation;
import com.pspdfkit.internal.qw;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public abstract class m7<ShapeDelegate extends qw> extends j7<ShapeDelegate> {
    public m7(ShapeDelegate shapedelegate) {
        super(shapedelegate);
    }

    @Override // com.pspdfkit.internal.d7, com.pspdfkit.internal.r4
    public Annotation a(int i, Matrix matrix, float f) {
        ArrayList arrayListA = a(matrix, f);
        if (arrayListA.size() < 2) {
            return null;
        }
        PolylineAnnotation polylineAnnotation = new PolylineAnnotation(i, arrayListA);
        a(polylineAnnotation);
        return polylineAnnotation;
    }

    @Override // com.pspdfkit.internal.d7, com.pspdfkit.internal.r4
    public boolean b(Annotation annotation, Matrix matrix, float f) {
        if (!(annotation instanceof PolylineAnnotation)) {
            throw new IllegalArgumentException("You need to pass a PolylineAnnotation to this shape.");
        }
        ArrayList arrayListA = a(matrix, f);
        boolean z = false;
        if (arrayListA.size() < 2) {
            return false;
        }
        PolylineAnnotation polylineAnnotation = (PolylineAnnotation) annotation;
        if (!polylineAnnotation.getPoints().equals(arrayListA)) {
            polylineAnnotation.setPoints(arrayListA);
            z = true;
        }
        return a(annotation) | z;
    }

    @Override // com.pspdfkit.internal.l8, com.pspdfkit.internal.d7
    public final boolean a(Annotation annotation) {
        boolean zA = super.a(annotation);
        Pair<LineEndType, LineEndType> pairD = ww.d(annotation);
        Pair<LineEndType, LineEndType> pair = ((qw) this.a).z;
        if (Objects.equals(pairD, pair)) {
            return zA;
        }
        LineEndType lineEndType = pair.first;
        LineEndType lineEndType2 = lineEndType != null ? lineEndType : LineEndType.NONE;
        LineEndType lineEndType3 = pair.second;
        return ww.a(annotation, lineEndType2, lineEndType3 != null ? lineEndType3 : LineEndType.NONE) | zA;
    }

    @Override // com.pspdfkit.internal.j7, com.pspdfkit.internal.l8, com.pspdfkit.internal.d7, com.pspdfkit.internal.r4
    public final boolean a(Annotation annotation, Matrix matrix, float f, boolean z) {
        boolean zA = super.a(annotation, matrix, f, z);
        Pair<LineEndType, LineEndType> pairD = ww.d(annotation);
        if (Objects.equals(pairD, ((qw) this.a).z) || pairD == null) {
            return zA;
        }
        ((qw) this.a).z = pairD;
        return true;
    }

    @Override // com.pspdfkit.internal.j7
    public final boolean a(int i, int i2, float f, BorderStyle borderStyle, BorderEffect borderEffect, float f2, List<Integer> list, float f3, Pair<LineEndType, LineEndType> pair) {
        return super.a(i, i2, f, borderStyle, borderEffect, f2, list, f3, pair) && Objects.equals(((qw) this.a).z, pair);
    }
}
