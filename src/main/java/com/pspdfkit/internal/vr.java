package com.pspdfkit.internal;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.view.MotionEvent;
import com.pspdfkit.ui.special_mode.controller.AnnotationTool;
import com.pspdfkit.ui.special_mode.controller.AnnotationToolVariant;

/* JADX INFO: loaded from: classes3.dex */
public final class vr extends d3 {
    public vr(q0 q0Var) {
        super(q0Var);
    }

    @Override // com.pspdfkit.internal.gu
    public final void a(Canvas canvas) {
    }

    @Override // com.pspdfkit.internal.gu
    public final void a(Matrix matrix) {
    }

    @Override // com.pspdfkit.internal.gu
    public final boolean a(MotionEvent motionEvent) {
        au auVarL;
        if (motionEvent.getActionMasked() == 0 && (auVarL = l()) != null) {
            vt pageEditor = auVarL.getPageEditor();
            pageEditor.getClass();
            if (pageEditor.a(motionEvent, true) != null) {
                return true;
            }
        }
        return false;
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
    public final boolean e() {
        return true;
    }

    @Override // com.pspdfkit.internal.gu
    public final int f() {
        return 20;
    }

    @Override // com.pspdfkit.internal.gu
    public final void g() {
        this.a.c(this);
    }

    @Override // com.pspdfkit.internal.d3
    public final AnnotationTool h() {
        return AnnotationTool.NONE;
    }

    @Override // com.pspdfkit.internal.d3
    public final AnnotationToolVariant i() {
        return AnnotationToolVariant.defaultVariant();
    }

    @Override // com.pspdfkit.internal.d3, com.pspdfkit.internal.gu
    public final void a(q30 q30Var) {
        this.b = q30Var;
        this.a.a(this);
    }
}
