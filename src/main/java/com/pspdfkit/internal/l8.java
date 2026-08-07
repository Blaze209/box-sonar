package com.pspdfkit.internal;

import android.graphics.Matrix;
import com.pspdfkit.annotations.Annotation;
import com.pspdfkit.annotations.BorderEffect;
import com.pspdfkit.annotations.BorderStyle;
import com.pspdfkit.annotations.FreeTextAnnotation;
import com.pspdfkit.annotations.measurements.MeasurementPrecision;
import com.pspdfkit.annotations.measurements.Scale;
import com.pspdfkit.annotations.measurements.SecondaryMeasurementUnit;
import com.pspdfkit.internal.m8;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public class l8<DrawingShape extends m8> extends d7<DrawingShape> {
    public SecondaryMeasurementUnit b;

    public l8(DrawingShape drawingshape) {
        super(drawingshape);
    }

    @Override // com.pspdfkit.internal.d7
    public boolean a(Annotation annotation) {
        annotation.getClass();
        boolean zA = super.a(annotation);
        if (((m8) this.a).n != annotation.getBorderStyle()) {
            BorderStyle borderStyle = ((m8) this.a).n;
            borderStyle.getClass();
            annotation.setBorderStyle(borderStyle);
            zA = true;
        }
        if (((m8) this.a).p != annotation.getBorderEffect()) {
            BorderEffect borderEffect = ((m8) this.a).p;
            borderEffect.getClass();
            annotation.setBorderEffect(borderEffect);
            zA = true;
        }
        if (((m8) this.a).q != annotation.getBorderEffectIntensity()) {
            annotation.setBorderEffectIntensity(((m8) this.a).q);
            zA = true;
        }
        if (!Intrinsics.areEqual(((m8) this.a).o, annotation.getBorderDashArray())) {
            List<Integer> list = ((m8) this.a).o;
            annotation.setBorderDashArray(list == null ? null : new ArrayList(list));
            zA = true;
        }
        xp xpVar = this.a.k;
        if (xpVar == null) {
            return zA;
        }
        if (annotation.getFontName() == null) {
            float f = ww.a;
            annotation.setFontName(ar.c().b().getName());
            annotation.setTextSize(18.0f);
            annotation.setTextJustification(FreeTextAnnotation.FreeTextTextJustification.CENTER);
            zA = true;
        }
        if (xpVar.b != annotation.getInternal().getMeasurementPrecision()) {
            annotation.getInternal().setMeasurementPrecision(xpVar.b);
            zA = true;
        }
        if (!Intrinsics.areEqual(xpVar.a, annotation.getInternal().getMeasurementScale())) {
            annotation.getInternal().setMeasurementScale(xpVar.a);
            zA = true;
        }
        if (Intrinsics.areEqual(annotation.getContents(), this.a.m)) {
            return zA;
        }
        annotation.setContents(this.a.m);
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:20:0x007e A[PHI: r9
      0x007e: PHI (r9v9 boolean) = (r9v5 boolean), (r9v8 boolean), (r9v8 boolean) binds: [B:19:0x007c, B:35:0x00cb, B:37:0x00d5] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // com.pspdfkit.internal.d7, com.pspdfkit.internal.r4
    public boolean a(Annotation annotation, Matrix matrix, float f, boolean z) {
        annotation.getClass();
        matrix.getClass();
        boolean zA = super.a(annotation, matrix, f, z);
        boolean z2 = true;
        if (((m8) this.a).n != annotation.getBorderStyle()) {
            ((m8) this.a).n = annotation.getBorderStyle();
            zA = true;
        }
        if (((m8) this.a).p != annotation.getBorderEffect()) {
            ((m8) this.a).p = annotation.getBorderEffect();
            zA = true;
        }
        if (((m8) this.a).q != annotation.getBorderEffectIntensity()) {
            m8 m8Var = (m8) this.a;
            float borderEffectIntensity = annotation.getBorderEffectIntensity();
            if (m8Var.q != borderEffectIntensity) {
                m8Var.q = borderEffectIntensity;
                m8Var.e();
            }
            zA = true;
        }
        if (!Intrinsics.areEqual(((m8) this.a).o, annotation.getBorderDashArray())) {
            ((m8) this.a).o = annotation.getBorderDashArray();
            zA = true;
        }
        xp xpVar = this.a.k;
        boolean z3 = false;
        if (xpVar == null) {
            z2 = z3;
        } else {
            MeasurementPrecision measurementPrecision = annotation.getInternal().getMeasurementPrecision();
            Scale measurementScale = annotation.getInternal().getMeasurementScale();
            lm internalDocument = annotation.getInternal().getInternalDocument();
            SecondaryMeasurementUnit secondaryMeasurementUnit = internalDocument != null ? internalDocument.getSecondaryMeasurementUnit() : null;
            if ((xpVar.b != measurementPrecision || !Intrinsics.areEqual(xpVar.a, measurementScale) || !Intrinsics.areEqual(secondaryMeasurementUnit, this.b)) && measurementScale != null && measurementPrecision != null) {
                this.b = secondaryMeasurementUnit;
                this.a.a(new xp(measurementScale, measurementPrecision, xpVar.c, secondaryMeasurementUnit));
                z3 = true;
            }
            String contents = annotation.getContents();
            if (contents == null || Intrinsics.areEqual(this.a.m, contents)) {
                z2 = z3;
            } else {
                this.a.m = contents;
            }
        }
        return zA | z2;
    }
}
