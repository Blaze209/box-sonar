package com.pspdfkit.internal;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PointF;
import com.pspdfkit.annotations.Annotation;
import com.pspdfkit.annotations.AnnotationType;
import com.pspdfkit.annotations.InkAnnotation;
import com.pspdfkit.internal.n7;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes3.dex */
public class d7<DrawingShape extends n7> implements r4 {
    public final DrawingShape a;

    public d7(DrawingShape drawingshape) {
        this.a = drawingshape;
    }

    @Override // com.pspdfkit.internal.r4
    public Annotation a(int i, Matrix matrix, float f) {
        matrix.getClass();
        return null;
    }

    @Override // com.pspdfkit.internal.r4
    public boolean b(Annotation annotation, Matrix matrix, float f) {
        matrix.getClass();
        return a(annotation);
    }

    @Override // com.pspdfkit.internal.f10
    public final int c() {
        int iC = this.a.c();
        if (iC != 0) {
            return iC;
        }
        throw null;
    }

    @Override // com.pspdfkit.internal.r4
    public final String d() {
        return this.a.m;
    }

    @Override // com.pspdfkit.internal.f10
    public final void hide() {
        this.a.a(0.0f, 0.0f);
    }

    public static final Unit b(d7 d7Var, int i) {
        d7Var.a.f = i;
        return Unit.INSTANCE;
    }

    public boolean a(Annotation annotation) {
        annotation.getClass();
        int color = annotation.getColor();
        int i = this.a.e;
        boolean z = color != i;
        if (z) {
            annotation.setColor(i);
        }
        Unit unit = Unit.INSTANCE;
        int fillColor = annotation.getFillColor();
        int i2 = this.a.f;
        boolean z2 = fillColor != i2;
        if (z2) {
            annotation.setFillColor(i2);
        }
        boolean z3 = z | z2;
        float alpha = annotation.getAlpha();
        float f = this.a.h;
        boolean z4 = alpha == f;
        boolean z5 = !z4;
        if (!z4) {
            annotation.setAlpha(f);
        }
        boolean z6 = z3 | z5;
        float fillAlpha = annotation.getFillAlpha();
        float f2 = this.a.i;
        boolean z7 = fillAlpha == f2;
        boolean z8 = !z7;
        if (!z7) {
            annotation.setFillAlpha(f2);
        }
        boolean z9 = z6 | z8;
        float borderWidth = annotation.getBorderWidth();
        float f3 = this.a.g;
        boolean z10 = borderWidth == f3;
        boolean z11 = !z10;
        if (!z10) {
            annotation.setBorderWidth(f3);
        }
        return z9 | z11;
    }

    @Override // com.pspdfkit.internal.f10
    public final void b(Canvas canvas, Paint paint, Paint paint2) {
        canvas.getClass();
        paint.getClass();
        this.a.b(canvas, paint, paint2);
    }

    @Override // com.pspdfkit.internal.r4
    public final boolean b() {
        return this.a.k != null;
    }

    @Override // com.pspdfkit.internal.r4
    public boolean a(Annotation annotation, Matrix matrix, float f, boolean z) {
        float borderWidth;
        annotation.getClass();
        matrix.getClass();
        Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        Integer numValueOf = Integer.valueOf(this.a.e);
        Integer numValueOf2 = Integer.valueOf(annotation.getColor());
        Function1 function1 = new Function1() { // from class: com.pspdfkit.internal.d7$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return d7.a(this.f$0, ((Integer) obj).intValue());
            }
        };
        if (!Intrinsics.areEqual(numValueOf, numValueOf2)) {
            function1.invoke(numValueOf2);
            booleanRef.element = true;
        }
        Integer numValueOf3 = Integer.valueOf(this.a.f);
        Integer numValueOf4 = Integer.valueOf(annotation.getFillColor());
        Function1 function2 = new Function1() { // from class: com.pspdfkit.internal.d7$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return d7.b(this.f$0, ((Integer) obj).intValue());
            }
        };
        if (!Intrinsics.areEqual(numValueOf3, numValueOf4)) {
            function2.invoke(numValueOf4);
            booleanRef.element = true;
        }
        if (annotation.getType() == AnnotationType.INK) {
            borderWidth = ((InkAnnotation) annotation).getLineWidth();
        } else {
            borderWidth = annotation.getBorderWidth();
        }
        Float fValueOf = Float.valueOf(this.a.g);
        Float fValueOf2 = Float.valueOf(borderWidth);
        Function1 function3 = new Function1() { // from class: com.pspdfkit.internal.d7$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return d7.a(this.f$0, ((Float) obj).floatValue());
            }
        };
        if (!Intrinsics.areEqual((Object) fValueOf, (Object) fValueOf2)) {
            function3.invoke(fValueOf2);
            booleanRef.element = true;
        }
        if (this.a.a(annotation.getAlpha(), annotation.getFillAlpha())) {
            booleanRef.element = true;
        }
        return booleanRef.element;
    }

    public static final Unit a(d7 d7Var, int i) {
        d7Var.a.e = i;
        return Unit.INSTANCE;
    }

    public static final Unit a(d7 d7Var, float f) {
        DrawingShape drawingshape = d7Var.a;
        if (drawingshape.g != f) {
            drawingshape.g = f;
            drawingshape.e();
        }
        return Unit.INSTANCE;
    }

    @Override // com.pspdfkit.internal.r4
    public final boolean a(Annotation annotation, Matrix matrix, float f) {
        annotation.getClass();
        matrix.getClass();
        return a(annotation, matrix, f, true);
    }

    @Override // com.pspdfkit.internal.f10
    public final void a(Canvas canvas, Paint paint, Paint paint2) {
        canvas.getClass();
        paint.getClass();
        this.a.a(canvas, paint, paint2);
    }

    @Override // com.pspdfkit.internal.f10
    public void a(PointF pointF, Matrix matrix, float f) {
        pointF.getClass();
        matrix.getClass();
        this.a.a(pointF, matrix, f);
    }

    @Override // com.pspdfkit.internal.f10
    public void a(int i) {
        if (i != 0) {
            this.a.a(i);
            return;
        }
        throw null;
    }

    @Override // com.pspdfkit.internal.r4
    public final boolean a(boolean z) {
        DrawingShape drawingshape = this.a;
        if (z == drawingshape.l) {
            return false;
        }
        drawingshape.h();
        drawingshape.l = z;
        return true;
    }

    @Override // com.pspdfkit.internal.f10
    public final boolean a(float f, Matrix matrix) {
        matrix.getClass();
        return this.a.a(f, matrix);
    }

    @Override // com.pspdfkit.internal.f10
    public final boolean a() {
        return this.a.a();
    }
}
