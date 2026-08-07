package com.pspdfkit.internal;

import android.graphics.Matrix;
import com.pspdfkit.annotations.Annotation;
import com.pspdfkit.annotations.PolygonAnnotation;
import com.pspdfkit.ui.inspector.views.BorderStylePreset;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public final class mw extends j7<nw> {
    public mw() {
        super(new nw());
    }

    @Override // com.pspdfkit.internal.d7, com.pspdfkit.internal.r4
    public final Annotation a(int i, Matrix matrix, float f) {
        ArrayList arrayListA = a(matrix, f);
        if (arrayListA.size() < 2) {
            return null;
        }
        PolygonAnnotation polygonAnnotation = new PolygonAnnotation(i, arrayListA);
        a(polygonAnnotation);
        return polygonAnnotation;
    }

    @Override // com.pspdfkit.internal.d7, com.pspdfkit.internal.r4
    public final boolean b(Annotation annotation, Matrix matrix, float f) {
        if (!(annotation instanceof PolygonAnnotation)) {
            throw new IllegalArgumentException("You need to pass a PolygonAnnotation to this shape.");
        }
        ArrayList arrayListA = a(matrix, f);
        boolean z = false;
        if (arrayListA.size() < 2) {
            return false;
        }
        PolygonAnnotation polygonAnnotation = (PolygonAnnotation) annotation;
        if (!polygonAnnotation.getPoints().equals(arrayListA)) {
            polygonAnnotation.setPoints(arrayListA);
            z = true;
        }
        return a(annotation) | z;
    }

    public mw(int i, int i2, float f, float f2, BorderStylePreset borderStylePreset) {
        super(new nw(i, i2, f, f2, borderStylePreset));
    }

    public mw(nw nwVar) {
        super(nwVar);
    }
}
