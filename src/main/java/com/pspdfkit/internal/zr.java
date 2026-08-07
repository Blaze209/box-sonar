package com.pspdfkit.internal;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.RectF;
import android.view.MotionEvent;
import com.pspdfkit.annotations.AnnotationProviderRxJava;
import com.pspdfkit.annotations.NoteAnnotation;
import com.pspdfkit.ui.special_mode.controller.AnnotationTool;
import com.pspdfkit.ui.special_mode.controller.AnnotationToolVariant;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;

/* JADX INFO: loaded from: classes3.dex */
public class zr extends d3 {
    public Point c;
    public final AnnotationToolVariant d;

    public zr(q0 q0Var, AnnotationToolVariant annotationToolVariant) {
        super(q0Var);
        this.d = annotationToolVariant;
    }

    @Override // com.pspdfkit.internal.gu
    public final void a(Canvas canvas) {
    }

    @Override // com.pspdfkit.internal.gu
    public final void a(Matrix matrix) {
    }

    public void a(NoteAnnotation noteAnnotation) {
        q0 q0Var = this.a;
        q0Var.getClass();
        ww.a(q0Var.g, noteAnnotation);
        noteAnnotation.getInternal().setVariant(q0Var.t);
        noteAnnotation.setColor(this.a.f.getAnnotationPreferences().getColor(AnnotationTool.NOTE, this.d));
    }

    @Override // com.pspdfkit.internal.gu
    public final boolean c() {
        return false;
    }

    @Override // com.pspdfkit.internal.gu
    public final boolean d() {
        this.a.b(this);
        return false;
    }

    @Override // com.pspdfkit.internal.gu
    public final int f() {
        return 3;
    }

    @Override // com.pspdfkit.internal.gu
    public final void g() {
        this.a.c(this);
    }

    @Override // com.pspdfkit.internal.d3
    public AnnotationTool h() {
        return AnnotationTool.NOTE;
    }

    @Override // com.pspdfkit.internal.d3
    public final AnnotationToolVariant i() {
        return this.d;
    }

    @Override // com.pspdfkit.internal.gu
    public final boolean a(MotionEvent motionEvent) {
        au auVarL = l();
        if (auVarL == null) {
            return false;
        }
        if (motionEvent.getActionMasked() == 1 && this.c != null) {
            Context context = this.a.a;
            context.getClass();
            Point point = this.c;
            if (!a80.a(context, point.x, point.y, (int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                RectF rectF = new RectF(motionEvent.getX(), motionEvent.getY(), motionEvent.getX(), motionEvent.getY());
                s60.a(rectF, auVarL.a((Matrix) null));
                rectF.inset(-16.0f, -16.0f);
                NoteAnnotation noteAnnotation = new NoteAnnotation(k(), rectF, "", this.a.f.getAnnotationPreferences().getNoteAnnotationIcon(AnnotationTool.NOTE, this.d));
                a(noteAnnotation);
                au auVarL2 = l();
                if (auVarL2 != null) {
                    AnnotationProviderRxJava.addAnnotationToPageCompletable(j().getAnnotationProvider(), noteAnnotation).observeOn(AndroidSchedulers.mainThread()).subscribe(new yr(this, auVarL2, noteAnnotation));
                }
                this.c = null;
                return true;
            }
        }
        if (motionEvent.getActionMasked() != 0) {
            return false;
        }
        this.c = new Point((int) motionEvent.getRawX(), (int) motionEvent.getRawY());
        return true;
    }

    @Override // com.pspdfkit.internal.d3, com.pspdfkit.internal.gu
    public final void a(q30 q30Var) {
        this.b = q30Var;
        this.a.a(this);
    }
}
