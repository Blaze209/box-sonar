package com.pspdfkit.internal;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.RectF;
import android.view.MotionEvent;
import com.pspdfkit.annotations.SoundAnnotation;
import com.pspdfkit.ui.special_mode.controller.AnnotationTool;
import com.pspdfkit.ui.special_mode.controller.AnnotationToolVariant;

/* JADX INFO: loaded from: classes3.dex */
public final class h30 extends d3 {
    public final AnnotationToolVariant c;
    public Point d;

    public h30(q0 q0Var, AnnotationToolVariant annotationToolVariant) {
        super(q0Var);
        this.c = annotationToolVariant;
    }

    @Override // com.pspdfkit.internal.gu
    public final void a(Canvas canvas) {
    }

    @Override // com.pspdfkit.internal.gu
    public final void a(Matrix matrix) {
    }

    public final void a(SoundAnnotation soundAnnotation) {
        this.a.e.enterAudioRecordingMode(soundAnnotation);
        q0 q0Var = this.a;
        if (q0Var.s == AnnotationTool.SOUND) {
            AnnotationTool annotationTool = AnnotationTool.NONE;
            AnnotationToolVariant annotationToolVariantDefaultVariant = AnnotationToolVariant.defaultVariant();
            q0Var.getClass();
            annotationTool.getClass();
            annotationToolVariantDefaultVariant.getClass();
            q0Var.b.enterAnnotatingMode(annotationTool, annotationToolVariantDefaultVariant);
        }
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
        return 4;
    }

    @Override // com.pspdfkit.internal.gu
    public final void g() {
        this.a.c(this);
    }

    @Override // com.pspdfkit.internal.d3
    public final AnnotationTool h() {
        return AnnotationTool.SOUND;
    }

    @Override // com.pspdfkit.internal.d3
    public final AnnotationToolVariant i() {
        return this.c;
    }

    @Override // com.pspdfkit.internal.gu
    public final boolean a(MotionEvent motionEvent) {
        if (motionEvent.getActionMasked() == 1 && this.d != null) {
            Context context = this.a.a;
            context.getClass();
            Point point = this.d;
            if (!a80.a(context, point.x, point.y, (int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                au auVarL = l();
                if (auVarL != null) {
                    RectF rectF = new RectF(motionEvent.getX(), motionEvent.getY(), motionEvent.getX(), motionEvent.getY());
                    s60.a(rectF, auVarL.a((Matrix) null));
                    rectF.inset(-10.0f, -7.5f);
                    a(rectF);
                }
                this.d = null;
                return true;
            }
        }
        if (motionEvent.getActionMasked() != 0) {
            return false;
        }
        this.d = new Point((int) motionEvent.getRawX(), (int) motionEvent.getRawY());
        return true;
    }

    @Override // com.pspdfkit.internal.d3, com.pspdfkit.internal.gu
    public final void a(q30 q30Var) {
        this.b = q30Var;
        this.a.a(this);
    }

    public final void a(RectF rectF) {
        final SoundAnnotation soundAnnotation = new SoundAnnotation(k(), rectF);
        q0 q0Var = this.a;
        q0Var.getClass();
        ww.a(q0Var.g, soundAnnotation);
        soundAnnotation.getInternal().setVariant(q0Var.t);
        this.a.f.addAnnotationToPage(soundAnnotation, true, new Runnable() { // from class: com.pspdfkit.internal.h30$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.a(soundAnnotation);
            }
        });
    }
}
