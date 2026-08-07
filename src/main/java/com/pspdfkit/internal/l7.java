package com.pspdfkit.internal;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PointF;
import com.pspdfkit.annotations.BorderEffect;
import com.pspdfkit.annotations.BorderStyle;
import com.pspdfkit.internal.j7;
import com.pspdfkit.ui.annotations.OnAnnotatingModeSettingsChangeListener;
import com.pspdfkit.ui.special_mode.controller.AnnotatingController;
import com.pspdfkit.ui.special_mode.controller.AnnotationToolVariant;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes3.dex */
public abstract class l7<T extends j7> extends s70<T> implements OnAnnotatingModeSettingsChangeListener {
    public boolean G;
    public PointF H;
    public e30 I;

    public l7(q0 q0Var, AnnotationToolVariant annotationToolVariant) {
        super(q0Var, annotationToolVariant);
        this.G = false;
    }

    @Override // com.pspdfkit.internal.o7, com.pspdfkit.internal.d3, com.pspdfkit.internal.gu
    public final void a(q30 q30Var) {
        super.a(q30Var);
        q0 q0Var = this.a;
        q0Var.getClass();
        q0Var.l.a(this);
        this.I = new e30(this.a.a);
    }

    @Override // com.pspdfkit.internal.o7
    public boolean b(float f, float f2) {
        T t;
        if (this.l == 0) {
            return false;
        }
        PointF pointF = new PointF(f, f2);
        o();
        r();
        ((j7) this.l).a(pointF, this.c, this.k);
        T t2 = this.l;
        if (t2 != 0 && ((j7) t2).a.a() && (t = this.l) != 0 && ((k7) ((j7) t).a).t.size() > 3) {
            k7 k7Var = (k7) ((j7) this.l).a;
            k7Var.u = false;
            if (!k7Var.t.isEmpty()) {
                ArrayList arrayList = k7Var.t;
                arrayList.remove(arrayList.size() - 1);
            }
            ((j7) this.l).a(this.H, this.c, this.k);
            T t3 = this.l;
            if (t3 != 0) {
                k7 k7Var2 = (k7) ((j7) t3).a;
                k7Var2.u = false;
                k7Var2.v = true;
                k7Var2.a(2);
                if (true != k7Var2.l) {
                    k7Var2.h();
                    k7Var2.l = true;
                }
                r();
                this.l = null;
            }
        }
        return true;
    }

    @Override // com.pspdfkit.internal.o7, com.pspdfkit.internal.gu
    public final boolean c() {
        q0 q0Var = this.a;
        q0Var.getClass();
        q0Var.l.b(this);
        return super.c();
    }

    /* JADX WARN: Code duplicated, block: B:9:0x003d  */
    @Override // com.pspdfkit.internal.o7
    public final void d(float f, float f2) {
        boolean z;
        if (!this.I.g.isSnapToSelfEnabled().booleanValue() || this.H == null) {
            z = false;
        } else {
            float f3 = this.k;
            PointF pointF = new PointF(f / f3, f2 / f3);
            PointF pointF2 = this.H;
            float f4 = this.I.f;
            float f5 = pointF2.x - pointF.x;
            float f6 = pointF2.y - pointF.y;
            if (((float) Math.sqrt((f6 * f6) + (f5 * f5))) <= f4) {
                z = true;
            } else {
                z = false;
            }
        }
        this.G = z;
        super.d(f, f2);
    }

    @Override // com.pspdfkit.internal.o7, com.pspdfkit.internal.gu
    public final void g() {
        q0 q0Var = this.a;
        q0Var.getClass();
        q0Var.l.b(this);
        super.g();
    }

    @Override // com.pspdfkit.internal.o7
    public final r4 n() {
        if (this.l == 0) {
            this.l = y();
        }
        j7 j7Var = (j7) this.l;
        j7Var.getClass();
        j7Var.a.a(1);
        return (j7) this.l;
    }

    @Override // com.pspdfkit.ui.annotations.OnAnnotatingModeSettingsChangeListener
    public final void onAnnotatingModeSettingsChange(AnnotatingController annotatingController) {
        T t;
        T t2 = this.l;
        if (t2 == 0) {
            return;
        }
        q0 q0Var = this.a;
        j7 j7Var = (j7) t2;
        q0.a aVar = q0Var.p;
        int i = aVar.b;
        int i2 = aVar.c;
        float f = aVar.e;
        BorderStyle borderStyle = aVar.g.getBorderStyle();
        BorderEffect borderEffect = q0Var.p.g.getBorderEffect();
        float borderEffectIntensity = q0Var.p.g.getBorderEffectIntensity();
        List<Integer> dashArray = q0Var.p.g.getDashArray();
        q0.a aVar2 = q0Var.p;
        if (j7Var.a(i, i2, f, borderStyle, borderEffect, borderEffectIntensity, dashArray, aVar2.i, aVar2.h) || (t = this.l) == 0) {
            return;
        }
        k7 k7Var = (k7) ((j7) t).a;
        k7Var.u = false;
        k7Var.v = true;
        k7Var.a(2);
        if (true != k7Var.l) {
            k7Var.h();
            k7Var.l = true;
        }
        r();
        this.l = null;
    }

    @Override // com.pspdfkit.internal.o7
    public final void p() {
        T t = this.l;
        if (t == 0) {
            return;
        }
        k7 k7Var = (k7) ((j7) t).a;
        if (!k7Var.t.isEmpty()) {
            ArrayList arrayList = k7Var.t;
            arrayList.remove(arrayList.size() - 1);
        }
        ef efVar = this.t;
        if (efVar != null) {
            efVar.d.reset();
        }
        this.u.f.reset();
        r();
        t();
        o();
    }

    @Override // com.pspdfkit.internal.o7
    public final void q() {
        T t;
        T t2;
        T t3 = this.l;
        if (t3 == 0) {
            return;
        }
        ((k7) ((j7) t3).a).u = false;
        ef efVar = this.t;
        if (efVar != null) {
            efVar.d.reset();
        }
        this.u.f.reset();
        r();
        t();
        o();
        if (!this.G || (t = this.l) == 0 || !((j7) t).a.a() || (t2 = this.l) == 0 || ((k7) ((j7) t2).a).t.size() <= 3) {
            return;
        }
        k7 k7Var = (k7) ((j7) this.l).a;
        k7Var.u = false;
        if (!k7Var.t.isEmpty()) {
            ArrayList arrayList = k7Var.t;
            arrayList.remove(arrayList.size() - 1);
        }
        ((j7) this.l).a(this.H, this.c, this.k);
        T t4 = this.l;
        if (t4 == 0) {
            return;
        }
        k7 k7Var2 = (k7) ((j7) t4).a;
        k7Var2.u = false;
        k7Var2.v = true;
        k7Var2.a(2);
        if (true != k7Var2.l) {
            k7Var2.h();
            k7Var2.l = true;
        }
        r();
        this.l = null;
    }

    public abstract T y();

    @Override // com.pspdfkit.internal.o7
    public final void c(float f, float f2) {
        super.c(f, f2);
        T t = this.l;
        if (t == 0) {
            return;
        }
        j7 j7Var = (j7) t;
        k7 k7Var = (k7) j7Var.a;
        k7Var.u = true;
        this.H = !k7Var.t.isEmpty() ? (PointF) ((k7) j7Var.a).t.get(0) : null;
        this.G = false;
    }

    @Override // com.pspdfkit.internal.o7
    public final void a(PointF pointF, PointF pointF2) {
        PointF pointF3;
        T t = this.l;
        if (t == 0) {
            return;
        }
        j7 j7Var = (j7) t;
        int i = 0;
        if (((k7) j7Var.a).t.isEmpty()) {
            pointF3 = null;
        } else {
            int size = ((k7) j7Var.a).t.size();
            DrawingShape drawingshape = j7Var.a;
            if (size > 2) {
                ArrayList arrayList = ((k7) drawingshape).t;
                pointF3 = (PointF) arrayList.get(arrayList.size() - 2);
            } else {
                pointF3 = (PointF) ((k7) drawingshape).t.get(0);
            }
        }
        if (pointF3 != null) {
            PointF pointF4 = new PointF();
            float f = pointF3.x;
            float f2 = this.k;
            pointF4.set(f * f2, pointF3.y * f2);
            this.u.b(pointF4, pointF2);
            n0 n0Var = this.u;
            ArrayList arrayList2 = ((k7) ((j7) this.l).a).t;
            float f3 = this.k;
            n0Var.getClass();
            arrayList2.getClass();
            ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
            int size2 = arrayList2.size();
            while (i < size2) {
                Object obj = arrayList2.get(i);
                i++;
                PointF pointF5 = (PointF) obj;
                PointF pointF6 = new PointF();
                pointF6.x = pointF5.x * f3;
                pointF6.y = pointF5.y * f3;
                arrayList3.add(pointF6);
            }
            n0Var.a(pointF4, pointF2, arrayList3);
            return;
        }
        this.u.b(pointF, pointF2);
    }

    @Override // com.pspdfkit.internal.o7
    public final PointF a(PointF pointF) {
        if (this.H != null && this.G) {
            PointF pointF2 = this.H;
            float f = pointF2.x;
            float f2 = this.k;
            return new PointF(f * f2, pointF2.y * f2);
        }
        return super.a(pointF);
    }

    @Override // com.pspdfkit.internal.o7, com.pspdfkit.internal.gu
    public final void a(Canvas canvas) {
        au auVarL;
        super.a(canvas);
        T t = this.l;
        if (t == 0 || !this.G || t == 0 || ((k7) ((j7) t).a).t.size() <= 3 || (auVarL = l()) == null) {
            return;
        }
        e30 e30Var = this.I;
        PointF pointF = this.H;
        float zoomScale = auVarL.getZoomScale();
        e30Var.getClass();
        pointF.getClass();
        if (e30Var.g.isSnapToSelfEnabled().booleanValue()) {
            e30Var.c.reset();
            e30Var.e.reset();
            float f = e30Var.a / zoomScale;
            e30Var.c.moveTo(pointF.x - f, pointF.y - f);
            e30Var.c.lineTo(pointF.x + f, pointF.y + f);
            e30Var.c.moveTo(pointF.x + f, pointF.y - f);
            e30Var.c.lineTo(pointF.x - f, pointF.y + f);
            if (zoomScale == 1.0f) {
                canvas.drawPath(e30Var.c, e30Var.b);
                return;
            }
            e30Var.d.setScale(zoomScale, zoomScale);
            Path path = e30Var.c;
            Path path2 = e30Var.e;
            Matrix matrix = e30Var.d;
            path2.set(path);
            path2.transform(matrix);
            canvas.drawPath(e30Var.e, e30Var.b);
        }
    }
}
