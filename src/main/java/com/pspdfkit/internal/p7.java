package com.pspdfkit.internal;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Point;
import android.view.MotionEvent;
import com.pspdfkit.ui.special_mode.controller.AnnotationToolVariant;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public abstract class p7 extends d3 {
    public final wi c;
    public cx d;
    public final AnnotationToolVariant e;

    public class a extends w20 {
        public Point a;

        public a() {
        }

        @Override // com.pspdfkit.internal.w20, com.pspdfkit.internal.xi
        public final void c(MotionEvent motionEvent) {
            this.a = null;
        }

        @Override // com.pspdfkit.internal.w20, com.pspdfkit.internal.xi
        public final boolean d(MotionEvent motionEvent) {
            au auVarL = p7.this.l();
            int i = 0;
            if (this.a != null) {
                Context context = p7.this.a.a;
                context.getClass();
                Point point = this.a;
                if (!a80.a(context, point.x, point.y, (int) motionEvent.getRawX(), (int) motionEvent.getRawY()) && auVarL != null && !auVarL.getPageEditor().b(motionEvent)) {
                    ArrayList arrayList = p7.this.a.o;
                    int size = arrayList.size();
                    while (i < size) {
                        Object obj = arrayList.get(i);
                        i++;
                        d3 d3Var = (d3) obj;
                        if (d3Var instanceof p7) {
                            ((p7) d3Var).m();
                        }
                    }
                    p7.this.a(motionEvent.getX(), motionEvent.getY());
                    this.a = null;
                    return true;
                }
            }
            return false;
        }

        @Override // com.pspdfkit.internal.w20, com.pspdfkit.internal.xi
        public final void onDown(MotionEvent motionEvent) {
            this.a = new Point((int) motionEvent.getRawX(), (int) motionEvent.getRawY());
        }
    }

    public p7(q0 q0Var, AnnotationToolVariant annotationToolVariant) {
        super(q0Var);
        this.e = annotationToolVariant;
        Context context = q0Var.a;
        context.getClass();
        wi wiVar = new wi(context);
        this.c = wiVar;
        wiVar.a(vi.Tap, new a());
    }

    public abstract void a(float f, float f2);

    @Override // com.pspdfkit.internal.gu
    public final void a(Canvas canvas) {
    }

    @Override // com.pspdfkit.internal.gu
    public final void a(Matrix matrix) {
    }

    @Override // com.pspdfkit.internal.gu
    public final boolean a(MotionEvent motionEvent) {
        return this.c.a(motionEvent);
    }

    @Override // com.pspdfkit.internal.gu
    public final boolean c() {
        m();
        return false;
    }

    @Override // com.pspdfkit.internal.gu
    public boolean d() {
        m();
        this.a.b(this);
        return false;
    }

    @Override // com.pspdfkit.internal.gu
    public void g() {
        this.a.c(this);
    }

    @Override // com.pspdfkit.internal.d3
    public final AnnotationToolVariant i() {
        return this.e;
    }

    public void m() {
    }

    public final void n() {
        cx cxVar = this.d;
        if (cxVar != null) {
            cxVar.dismiss();
            this.d = null;
        }
    }
}
