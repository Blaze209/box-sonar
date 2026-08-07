package com.pspdfkit.internal;

import android.graphics.Matrix;
import android.graphics.RectF;
import com.pspdfkit.annotations.Annotation;
import com.pspdfkit.annotations.BorderEffect;
import com.pspdfkit.annotations.CircleAnnotation;
import com.pspdfkit.annotations.SquareAnnotation;
import com.pspdfkit.ui.inspector.views.BorderStylePreset;
import com.pspdfkit.utils.EdgeInsets;

/* JADX INFO: loaded from: classes3.dex */
public final class t20 extends l8<a30> {
    public t20(int i) {
        super(new a30(i));
    }

    @Override // com.pspdfkit.internal.d7, com.pspdfkit.internal.r4
    public final Annotation a(int i, Matrix matrix, float f) {
        Annotation circleAnnotation;
        RectF rectFA = a(matrix, f);
        if (rectFA == null) {
            return null;
        }
        int i2 = ((a30) this.a).y;
        if (i2 == 1) {
            circleAnnotation = new SquareAnnotation(i, rectFA);
        } else {
            if (i2 != 2) {
                return null;
            }
            circleAnnotation = new CircleAnnotation(i, rectFA);
        }
        if (!a(circleAnnotation)) {
            return circleAnnotation;
        }
        int iC = this.a.c();
        if (iC == 0) {
            throw null;
        }
        a(circleAnnotation, matrix, f, iC == 2);
        return circleAnnotation;
    }

    @Override // com.pspdfkit.internal.d7, com.pspdfkit.internal.r4
    public final boolean b(Annotation annotation, Matrix matrix, float f) {
        int i = ((a30) this.a).y;
        boolean z = true;
        if (i == 1 && !(annotation instanceof SquareAnnotation)) {
            throw new IllegalArgumentException("You need to pass a SquareAnnotation to this shape.");
        }
        if (i == 2 && !(annotation instanceof CircleAnnotation)) {
            throw new IllegalArgumentException("You need to pass a CircleAnnotation to this shape.");
        }
        RectF rectFA = a(matrix, f);
        if (rectFA == null || lx.a(rectFA, annotation.getBoundingBox())) {
            z = false;
        } else {
            annotation.setBoundingBox(rectFA);
        }
        return a(annotation) | z;
    }

    public t20(a30 a30Var) {
        super(a30Var);
    }

    public t20(int i, int i2, float f, float f2, BorderStylePreset borderStylePreset, int i3) {
        super(new a30(i, i2, f, f2, borderStylePreset, i3));
    }

    @Override // com.pspdfkit.internal.l8, com.pspdfkit.internal.d7
    public final boolean a(Annotation annotation) {
        boolean zA = super.a(annotation);
        if (annotation.getBorderEffect() != BorderEffect.CLOUDY || annotation.getBorderEffectIntensity() <= 0.0f) {
            return zA;
        }
        float borderEffectIntensity = annotation.getBorderEffectIntensity() * 4.25f;
        if (new EdgeInsets(borderEffectIntensity, borderEffectIntensity, borderEffectIntensity, borderEffectIntensity).equals(annotation.getInternal().getEdgeInsets())) {
            return zA;
        }
        annotation.getInternal().setEdgeInsets(new EdgeInsets(borderEffectIntensity, borderEffectIntensity, borderEffectIntensity, borderEffectIntensity));
        return true;
    }

    @Override // com.pspdfkit.internal.l8, com.pspdfkit.internal.d7, com.pspdfkit.internal.r4
    public final boolean a(Annotation annotation, Matrix matrix, float f, boolean z) {
        boolean z2;
        Matrix matrix2 = new Matrix(matrix);
        float f2 = 1.0f / f;
        matrix2.postScale(f2, f2);
        RectF boundingBox = annotation.getBoundingBox();
        RectF rectF = new RectF();
        rectF.set(boundingBox);
        matrix2.mapRect(rectF);
        if (lx.a(rectF, ((a30) this.a).t)) {
            z2 = false;
        } else {
            a30 a30Var = (a30) this.a;
            a30Var.t.set(rectF.left, rectF.top, rectF.right, rectF.bottom);
            a30Var.t.sort();
            z2 = true;
            a30Var.B = true;
            if (z) {
                this.a.a(2);
            }
        }
        return super.a(annotation, matrix, f, z) | z2;
    }

    public final RectF a(Matrix matrix, float f) {
        RectF rectF = ((a30) this.a).t;
        if (rectF.width() <= 0.0f || rectF.height() <= 0.0f) {
            return null;
        }
        RectF rectF2 = new RectF(rectF);
        rectF2.left *= f;
        rectF2.right *= f;
        rectF2.top *= f;
        rectF2.bottom *= f;
        RectF rectF3 = new RectF();
        rectF3.set(rectF2);
        s60.a(rectF3, matrix);
        return rectF3;
    }
}
