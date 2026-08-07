package com.pspdfkit.internal;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.GradientDrawable;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.MotionEvent;
import com.pspdfkit.annotations.Annotation;
import com.pspdfkit.ui.special_mode.controller.AnnotationTool;
import com.pspdfkit.ui.special_mode.controller.AnnotationToolVariant;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class a3 extends d3 {
    public final Matrix c;
    public final ArrayList d;
    public final GradientDrawable e;
    public final Paint f;
    public final RectF g;
    public final AnnotationTool h;
    public final AnnotationToolVariant i;
    public final RectF j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a3(q0 q0Var) {
        super(q0Var);
        q0Var.getClass();
        this.c = new Matrix();
        this.d = new ArrayList();
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setStroke(4, 0);
        gradientDrawable.setColor(838860800);
        this.e = gradientDrawable;
        Paint paint = new Paint(1);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(-16777216);
        Context context = q0Var.a;
        context.getClass();
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        displayMetrics.getClass();
        paint.setStrokeWidth(TypedValue.applyDimension(1, 2.0f, displayMetrics));
        this.f = paint;
        this.g = new RectF();
        this.h = AnnotationTool.ANNOTATION_MULTI_SELECTION;
        AnnotationToolVariant annotationToolVariantDefaultVariant = AnnotationToolVariant.defaultVariant();
        annotationToolVariantDefaultVariant.getClass();
        this.i = annotationToolVariantDefaultVariant;
        this.j = new RectF();
    }

    @Override // com.pspdfkit.internal.d3, com.pspdfkit.internal.gu
    public final void a(q30 q30Var) {
        m4 m4Var;
        this.b = q30Var;
        au auVarL = l();
        if (auVarL == null || auVarL.getState() == null) {
            return;
        }
        auVarL.a(this.c);
        this.a.a(this);
        au auVarL2 = l();
        vt pageEditor = auVarL2 != null ? auVarL2.getPageEditor() : null;
        if (pageEditor != null && (m4Var = pageEditor.k) != null) {
            m4Var.c = this;
        }
        q30Var.bringToFront();
    }

    @Override // com.pspdfkit.internal.gu
    public final boolean a(MotionEvent motionEvent) {
        return false;
    }

    @Override // com.pspdfkit.internal.gu
    public final boolean c() {
        return false;
    }

    @Override // com.pspdfkit.internal.gu
    public final boolean d() {
        m4 m4Var;
        au auVarL = l();
        vt pageEditor = auVarL != null ? auVarL.getPageEditor() : null;
        if (pageEditor != null && (m4Var = pageEditor.k) != null) {
            m4Var.c = null;
        }
        this.a.b(this);
        return false;
    }

    @Override // com.pspdfkit.internal.gu
    public final int f() {
        return 25;
    }

    @Override // com.pspdfkit.internal.gu
    public final void g() {
        m4 m4Var;
        au auVarL = l();
        vt pageEditor = auVarL != null ? auVarL.getPageEditor() : null;
        if (pageEditor != null && (m4Var = pageEditor.k) != null) {
            m4Var.c = null;
        }
        this.a.c(this);
    }

    @Override // com.pspdfkit.internal.d3
    public final AnnotationTool h() {
        return this.h;
    }

    @Override // com.pspdfkit.internal.d3
    public final AnnotationToolVariant i() {
        return this.i;
    }

    @Override // com.pspdfkit.internal.gu
    public final void a(Canvas canvas) {
        m4 m4Var;
        canvas.getClass();
        au auVarL = l();
        vt pageEditor = auVarL != null ? auVarL.getPageEditor() : null;
        if (pageEditor == null || (m4Var = pageEditor.k) == null || m4Var.z == null) {
            return;
        }
        int iSave = canvas.save();
        try {
            canvas.setMatrix(this.c);
            this.e.draw(canvas);
            ArrayList arrayList = this.d;
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                ((Annotation) obj).getBoundingBox(this.g).inset(-3.0f, 3.0f);
                canvas.drawRect(this.g, this.f);
            }
            canvas.restoreToCount(iSave);
        } catch (Throwable th) {
            canvas.restoreToCount(iSave);
            throw th;
        }
    }

    @Override // com.pspdfkit.internal.gu
    public final void a(Matrix matrix) {
        au auVarL = l();
        if (auVarL == null || auVarL.getState() == null || Intrinsics.areEqual(this.c, matrix)) {
            return;
        }
        this.c.set(matrix);
    }
}
