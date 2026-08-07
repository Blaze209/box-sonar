package com.pspdfkit.internal;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Pair;
import android.view.GestureDetector;
import android.view.MotionEvent;
import com.pspdfkit.annotations.Annotation;
import com.pspdfkit.annotations.AnnotationProvider;
import com.pspdfkit.internal.r4;
import com.pspdfkit.preferences.PSPDFKitPreferences;
import com.pspdfkit.ui.special_mode.controller.AnnotationToolVariant;
import com.pspdfkit.utils.PdfLog;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Action;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public abstract class o7<T extends r4> extends d3 implements zs, AnnotationProvider.OnAnnotationUpdatedListener {
    public final AnnotationToolVariant A;
    public Disposable B;
    public GestureDetector C;
    public final PSPDFKitPreferences D;
    public final List<Integer> E;
    public final a F;
    public final Matrix c;
    public final ArrayList d;
    public final n10 e;
    public final Rect f;
    public final Rect g;
    public final Paint h;
    public final Paint i;
    public final Paint j;
    public float k;
    public T l;
    public float m;
    public float n;
    public long o;
    public float p;
    public float q;
    public boolean r;
    public float s;
    public ef t;
    public final n0 u;
    public boolean v;
    public boolean w;
    public boolean x;
    public final HashMap<r4, Annotation> y;
    public boolean z;

    public class a extends ArrayList<Integer> {
        public a(o7 o7Var) {
            addAll(o7Var.E);
            add(3);
        }
    }

    public class b extends GestureDetector.SimpleOnGestureListener {
        public b() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public final boolean onDoubleTap(MotionEvent motionEvent) {
            return o7.this.a(motionEvent.getX(), motionEvent.getY()) ? o7.this.b(motionEvent.getX(), motionEvent.getY()) : super.onDoubleTap(motionEvent);
        }
    }

    public o7(q0 q0Var, AnnotationToolVariant annotationToolVariant) {
        super(q0Var);
        this.c = new Matrix();
        this.d = new ArrayList();
        this.f = new Rect();
        this.g = new Rect();
        this.j = new Paint();
        this.k = 0.0f;
        this.r = false;
        this.y = new HashMap<>();
        this.C = null;
        this.E = Arrays.asList(100, 103);
        this.F = new a(this);
        this.A = annotationToolVariant;
        Context context = q0Var.a;
        context.getClass();
        this.u = new n0(context);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setDither(true);
        paint.setStyle(Paint.Style.STROKE);
        this.h = paint;
        Paint paint2 = new Paint();
        paint2.setAntiAlias(true);
        paint2.setDither(true);
        paint2.setStyle(Paint.Style.FILL);
        this.i = paint2;
        this.e = new n10(paint, paint2);
        Context context2 = q0Var.a;
        context2.getClass();
        this.D = PSPDFKitPreferences.get(context2);
    }

    public void a(PointF pointF, PointF pointF2) {
    }

    @Override // com.pspdfkit.internal.d3, com.pspdfkit.internal.gu
    public void a(q30 q30Var) {
        m40 state;
        this.b = q30Var;
        au auVarL = l();
        if (auVarL == null || (state = auVarL.getState()) == null) {
            return;
        }
        this.C = new GestureDetector(q30Var.getContext(), new b());
        auVarL.a(this.c);
        auVarL.getLocalVisibleRect(this.f);
        float f = state.f;
        this.k = f;
        T t = this.l;
        if (t != null) {
            t.a(f, this.c);
        }
        ArrayList arrayList = this.d;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            ((r4) obj).a(f, this.c);
        }
        this.a.a(this);
        this.w = auVarL.getPdfConfiguration().isToGrayscale();
        this.v = auVarL.getPdfConfiguration().isInvertColors();
        this.x = auVarL.getPdfConfiguration().getEnableStylusOnDetection();
        ColorMatrixColorFilter colorMatrixColorFilterA = ff.a(this.w, this.v);
        this.j.setColorFilter(colorMatrixColorFilterA);
        this.h.setColorFilter(colorMatrixColorFilterA);
        Paint paint = this.i;
        if (paint != null) {
            paint.setColorFilter(colorMatrixColorFilterA);
        }
        this.a.f.addOnAnnotationUpdatedListener(this);
    }

    public boolean b(float f, float f2) {
        return false;
    }

    @Override // com.pspdfkit.internal.gu
    public boolean c() {
        final q30 q30Var = this.b;
        final au auVarL = l();
        if (auVarL == null) {
            return false;
        }
        n10 n10Var = this.e;
        n10Var.g = false;
        yz.a(n10Var.j);
        n10Var.j = null;
        yz.a(this.B);
        this.B = null;
        t();
        List<? extends Annotation> listW = w();
        if (listW.isEmpty() || q30Var == null) {
            this.e.recycle();
        } else {
            q30 q30Var2 = this.b;
            if (q30Var2 != null) {
                q30Var2.setRetainedPageModeHandler(this);
            }
            auVarL.getAnnotationRenderingCoordinator().a(listW, false, new Function0() { // from class: com.pspdfkit.internal.o7$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return this.f$0.a(auVarL, q30Var);
                }
            });
        }
        this.a.f.removeOnAnnotationUpdatedListener(this);
        return false;
    }

    @Override // com.pspdfkit.internal.gu
    public final boolean d() {
        c();
        this.a.b(this);
        this.a.f.removeOnAnnotationUpdatedListener(this);
        return false;
    }

    public final void e(float f, float f2) {
        if (v()) {
            int[] iArr = new int[2];
            l().getLocationInWindow(iArr);
            int[] iArr2 = new int[2];
            this.a.i.a.getLocationInWindow(iArr2);
            Pair pair = new Pair(Float.valueOf((f + iArr[0]) - iArr2[0]), Float.valueOf((f2 + iArr[1]) - iArr2[1]));
            wo.a(this.a.i, l().getContext(), ((Float) pair.first).floatValue(), ((Float) pair.second).floatValue(), 2.0f);
            boolean zA = this.l.a();
            T t = this.l;
            if (!zA) {
                t.a(false);
                return;
            }
            String strD = t.d();
            if (strD == null) {
                return;
            }
            sp spVar = l().getParentView().q0;
            if (spVar == null ? false : spVar.a(strD)) {
                this.l.a(false);
            }
        }
    }

    @Override // com.pspdfkit.internal.gu
    public void g() {
        n10 n10Var = this.e;
        n10Var.g = false;
        yz.a(n10Var.j);
        n10Var.j = null;
        yz.a(this.B);
        this.B = null;
        t();
        w();
        q30 q30Var = this.b;
        if (q30Var != null) {
            q30Var.e = null;
        }
        this.a.c(this);
        this.e.recycle();
        Iterator<Annotation> it = this.y.values().iterator();
        while (it.hasNext()) {
            it.next().getInternal().removeOnAnnotationPropertyChangeListener(this);
        }
        this.y.clear();
    }

    @Override // com.pspdfkit.internal.d3
    public final AnnotationToolVariant i() {
        return this.A;
    }

    public boolean m() {
        return false;
    }

    public abstract T n();

    public void o() {
        sp spVar;
        this.a.i.d();
        if (l() != null && (spVar = l().getParentView().q0) != null) {
            spVar.c.setVisibility(4);
            j10 j10Var = spVar.d;
            if (j10Var != null) {
                j10Var.a(true);
            }
        }
        T t = this.l;
        if (t != null) {
            t.a(true);
        }
    }

    @Override // com.pspdfkit.annotations.AnnotationProvider.OnAnnotationUpdatedListener
    public void onAnnotationCreated(Annotation annotation) {
    }

    public void onAnnotationPropertyChange(final Annotation annotation, int i, Object obj, Object obj2) {
        if (this.z || obj2 == null || obj2.equals(obj)) {
            return;
        }
        if ((annotation.isMeasurement() ? this.F : this.E).contains(Integer.valueOf(i))) {
            h60.a(new Runnable() { // from class: com.pspdfkit.internal.o7$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.a(annotation);
                }
            });
        }
    }

    public void onAnnotationRemoved(Annotation annotation) {
        if (this.y.containsValue(annotation)) {
            for (Map.Entry<r4, Annotation> entry : this.y.entrySet()) {
                if (entry.getValue() == annotation) {
                    this.d.remove(entry.getKey());
                    if (entry.getKey().equals(this.l)) {
                        this.l = null;
                    }
                    r();
                    s();
                    return;
                }
            }
        }
    }

    @Override // com.pspdfkit.annotations.AnnotationProvider.OnAnnotationUpdatedListener
    public final void onAnnotationUpdated(Annotation annotation) {
    }

    @Override // com.pspdfkit.annotations.AnnotationProvider.OnAnnotationUpdatedListener
    public final void onAnnotationZOrderChanged(int i, List<Annotation> list, List<Annotation> list2) {
    }

    public void p() {
        ef efVar = this.t;
        if (efVar != null) {
            efVar.d.reset();
        }
        this.u.f.reset();
        o();
        if (this.l != null) {
            if (SystemClock.elapsedRealtime() - this.o <= 300 && new PointF(this.n - this.p, this.m - this.q).length() <= 75.0f) {
                this.d.remove(this.l);
                this.l = null;
            } else {
                this.l.a(2);
                if (!this.l.a()) {
                    this.l.hide();
                }
                this.l = null;
            }
        }
        r();
        t();
    }

    public void q() {
        ef efVar = this.t;
        if (efVar != null) {
            efVar.d.reset();
        }
        this.u.f.reset();
        o();
        T t = this.l;
        if (t != null) {
            t.a(2);
            if (!this.l.a()) {
                this.l.hide();
            }
            this.l = null;
        }
        r();
        t();
    }

    public final void r() {
        yz.a(this.B);
        this.B = this.e.a(this.f, this.d, this.c, this.k, 100L).subscribe(new Action() { // from class: com.pspdfkit.internal.o7$$ExternalSyntheticLambda2
            @Override // io.reactivex.rxjava3.functions.Action
            public final void run() {
                this.f$0.s();
            }
        });
    }

    public final void s() {
        q30 q30Var = this.b;
        if (q30Var == null) {
            return;
        }
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            q30Var.invalidate();
        } else {
            q30Var.postInvalidate();
        }
    }

    public void t() {
        if (this.d.isEmpty() || l() == null) {
            return;
        }
        ArrayList arrayList = new ArrayList(this.d.size());
        ArrayList arrayList2 = new ArrayList(this.y.values());
        at atVar = this.a.c;
        atVar.getClass();
        i3 i3Var = new i3(arrayList2, atVar);
        i3Var.b();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = this.d;
        int size = arrayList4.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList4.get(i);
            i++;
            r4 r4Var = (r4) obj;
            if (this.y.containsKey(r4Var)) {
                Annotation annotation = this.y.get(r4Var);
                if (annotation == null) {
                    arrayList3.add(r4Var);
                } else {
                    this.z = true;
                    boolean zB = r4Var.b(annotation, this.c, this.k);
                    this.z = false;
                    if (zB) {
                        annotation.getInternal().markPreferredForPlatformRendering();
                    }
                }
            } else if (r4Var.a()) {
                Annotation annotationA = r4Var.a(k(), this.c, this.k);
                if (annotationA == null) {
                    arrayList3.add(r4Var);
                } else {
                    annotationA.getInternal().markPreferredForPlatformRendering();
                    q0 q0Var = this.a;
                    q0Var.getClass();
                    ww.a(q0Var.g, annotationA);
                    annotationA.getInternal().setVariant(q0Var.t);
                    arrayList.add(annotationA);
                    l().getAnnotationRenderingCoordinator().a(annotationA);
                    this.y.put(r4Var, annotationA);
                    annotationA.getInternal().addOnAnnotationPropertyChangeListener(this);
                }
            } else {
                arrayList3.add(r4Var);
            }
        }
        int size2 = arrayList3.size();
        int i2 = 0;
        while (i2 < size2) {
            Object obj2 = arrayList3.get(i2);
            i2++;
            this.d.remove((r4) obj2);
        }
        i3Var.c();
        int size3 = arrayList.size();
        int i3 = 0;
        while (i3 < size3) {
            Object obj3 = arrayList.get(i3);
            i3++;
            this.a.f.addAnnotationToPage((Annotation) obj3, u());
        }
        PdfLog.d("Nutri.BShapeAnnotMHand", "Created " + arrayList.size() + " annotations from the drawing session.", new Object[0]);
    }

    public boolean u() {
        return false;
    }

    public boolean v() {
        T t = this.l;
        return t != null && t.b() && this.a.i.e;
    }

    public List<? extends Annotation> w() {
        if (this.y.isEmpty() || l() == null) {
            return Collections.EMPTY_LIST;
        }
        for (Annotation annotation : this.y.values()) {
            l().getAnnotationRenderingCoordinator().b(annotation);
            annotation.getInternal().removeOnAnnotationPropertyChangeListener(this);
        }
        ArrayList arrayList = new ArrayList(this.y.values());
        this.y.clear();
        return arrayList;
    }

    public void d(float f, float f2) {
        if (l() == null || this.l == null) {
            return;
        }
        boolean zA = a(f, f2);
        boolean z = this.r;
        if (zA) {
            if (z && !m()) {
                c(f, f2);
                return;
            }
        } else if (z) {
            return;
        } else {
            this.r = true;
        }
        float fMax = Math.max(this.s, Math.min(f, l().getWidth() - this.s));
        float fMax2 = Math.max(this.s, Math.min(f2, l().getHeight() - this.s));
        float fAbs = Math.abs(fMax - this.p);
        float fAbs2 = Math.abs(fMax2 - this.q);
        if (this.r || fAbs > 4.0f || fAbs2 > 4.0f) {
            PointF pointF = new PointF(fMax, fMax2);
            ef efVar = this.t;
            if (efVar != null) {
                float f3 = this.n;
                float f4 = this.m;
                float f5 = this.k;
                float f6 = efVar.a / f5;
                if (f6 != 0.0f) {
                    float f7 = pointF.x - f3;
                    float f8 = pointF.y - f4;
                    if (Math.abs(Math.abs(f7) - Math.abs(f8)) < f6) {
                        float fMax3 = Math.max(Math.abs(f7), Math.abs(f8));
                        float f9 = ((f7 > 0.0f ? 1.0f : -1.0f) * fMax3) + f3;
                        pointF.x = f9;
                        float f10 = (fMax3 * (f8 > 0.0f ? 1.0f : -1.0f)) + f4;
                        pointF.y = f10;
                        float f11 = efVar.b / f5;
                        if (f11 > 0.0f) {
                            float f12 = (f3 < f9 ? 1.0f : -1.0f) * f11;
                            f3 -= f12;
                            f9 += f12;
                            float f13 = f11 * (f4 >= f10 ? -1.0f : 1.0f);
                            f4 -= f13;
                            f10 += f13;
                        }
                        efVar.d.reset();
                        efVar.d.moveTo(f3, f4);
                        efVar.d.lineTo(f9, f10);
                    } else {
                        efVar.d.reset();
                    }
                }
            }
            this.p = pointF.x;
            this.q = pointF.y;
            PointF pointFA = a(pointF);
            float f14 = pointFA.x;
            float f15 = this.k;
            pointFA.set(f14 / f15, pointFA.y / f15);
            this.l.a(pointFA, this.c, this.k);
            a(new PointF(this.n, this.m), new PointF(this.p, this.q));
            if (this.r && !m()) {
                q();
            }
        }
        e(fMax, fMax2);
    }

    public void c(float f, float f2) {
        aq aqVar;
        if (a(f, f2) && l() != null) {
            this.r = false;
            this.n = f;
            this.m = f2;
            this.o = SystemClock.elapsedRealtime();
            this.p = f;
            this.q = f2;
            this.s = (s60.a(this.c) * this.a.p.e) / 2.0f;
            d7 d7Var = (T) n();
            this.l = d7Var;
            float f3 = this.k;
            Matrix matrix = this.c;
            d7 d7Var2 = d7Var;
            d7Var2.getClass();
            matrix.getClass();
            d7Var2.a.a(f3, matrix);
            PointF pointF = new PointF(f, f2);
            if (p10.a(h().toAnnotationType()) && (aqVar = l().getPageEditor().p) != null && aqVar.b.isMeasurementSnappingEnabled().booleanValue() && aqVar.e > 0.0f) {
                PointF pointF2 = new PointF(pointF.x, pointF.y);
                Matrix matrix2 = aqVar.a;
                Matrix matrix3 = new Matrix();
                matrix2.invert(matrix3);
                s60.a(pointF2, matrix3);
                pointF = aqVar.a(pointF2);
                s60.a(pointF, aqVar.a);
            }
            float f4 = pointF.x;
            float f5 = this.k;
            pointF.set(f4 / f5, pointF.y / f5);
            this.l.a(pointF, this.c, this.k);
            if (!this.d.contains(this.l)) {
                this.d.add(this.l);
            }
            e(f, f2);
            this.u.e = true;
        }
    }

    @Override // com.pspdfkit.internal.gu
    public final boolean a(MotionEvent motionEvent) {
        GestureDetector gestureDetector = this.C;
        if (gestureDetector == null || !gestureDetector.onTouchEvent(motionEvent)) {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked != 0) {
                if (actionMasked == 1) {
                    q();
                } else if (actionMasked == 2) {
                    d(motionEvent.getX(), motionEvent.getY());
                    s();
                } else if (actionMasked == 3) {
                    p();
                }
            } else {
                if (!br.a(motionEvent, this.x, this.D)) {
                    return false;
                }
                c(motionEvent.getX(), motionEvent.getY());
                s();
            }
        }
        return true;
    }

    @Override // com.pspdfkit.internal.gu
    public final void a(Matrix matrix) {
        m40 state;
        au auVarL = l();
        if (auVarL == null || (state = auVarL.getState()) == null) {
            return;
        }
        auVarL.getLocalVisibleRect(this.f);
        if (!this.c.equals(matrix)) {
            this.c.set(matrix);
        }
        float f = state.f;
        this.k = f;
        T t = this.l;
        if (t != null) {
            t.a(f, this.c);
        }
        ArrayList arrayList = this.d;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            ((r4) obj).a(f, this.c);
        }
        if (!this.e.b().equals(this.f)) {
            r();
        }
        s();
    }

    @Override // com.pspdfkit.internal.gu
    public void a(Canvas canvas) {
        Bitmap bitmapA;
        canvas.clipRect(this.f);
        Bitmap bitmapA2 = this.e.a();
        n10 n10Var = this.e;
        int i = 0;
        if (n10Var.g && (bitmapA = n10Var.a()) != null && !bitmapA.isRecycled() && bitmapA2 != null && this.e.b().equals(this.f)) {
            canvas.save();
            Rect rect = this.f;
            canvas.translate(rect.left, rect.top);
            this.g.set(0, 0, this.f.width(), this.f.height());
            canvas.drawBitmap(bitmapA2, (Rect) null, this.g, (this.v || this.w) ? this.j : null);
            canvas.restore();
            ArrayList arrayList = this.d;
            int size = arrayList.size();
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                r4 r4Var = (r4) obj;
                if (r4Var.c() != 3) {
                    r4Var.a(canvas, this.h, this.i);
                }
            }
        } else {
            canvas.save();
            float f = this.k;
            canvas.scale(f, f);
            ArrayList arrayList2 = this.d;
            int size2 = arrayList2.size();
            while (i < size2) {
                Object obj2 = arrayList2.get(i);
                i++;
                r4 r4Var2 = (r4) obj2;
                if (r4Var2 != this.l) {
                    r4Var2.b(canvas, this.h, this.i);
                }
            }
            canvas.restore();
            T t = this.l;
            if (t != null) {
                t.a(canvas, this.h, this.i);
            }
        }
        T t2 = this.l;
        if (t2 == null || t2.c() != 1) {
            return;
        }
        ef efVar = this.t;
        if (efVar != null && !efVar.d.isEmpty()) {
            canvas.drawPath(efVar.d, efVar.c);
        }
        n0 n0Var = this.u;
        Rect rect2 = this.f;
        n0Var.getClass();
        rect2.getClass();
        if (n0Var.f.isEmpty()) {
            return;
        }
        canvas.save();
        canvas.clipRect(rect2);
        canvas.drawPath(n0Var.f, n0Var.g);
        canvas.restore();
    }

    public PointF a(PointF pointF) {
        if (l() == null || !p10.a(h().toAnnotationType())) {
            return pointF;
        }
        aq aqVar = l().getPageEditor().p;
        if (aqVar != null && aqVar.b.isMeasurementSnappingEnabled().booleanValue() && aqVar.e > 0.0f) {
            PointF pointF2 = new PointF(pointF.x, pointF.y);
            Matrix matrix = aqVar.a;
            Matrix matrix2 = new Matrix();
            matrix.invert(matrix2);
            s60.a(pointF2, matrix2);
            pointF = aqVar.a(pointF2);
            s60.a(pointF, aqVar.a);
        }
        n0 n0Var = this.u;
        n0Var.getClass();
        return n0Var.a(pointF, 0.0f, 0.0f);
    }

    public final boolean a(float f, float f2) {
        return l() != null && ip.b(f, (float) l().getWidth()) && ip.b(f2, (float) l().getHeight());
    }

    public final void a(Annotation annotation) {
        for (Map.Entry<r4, Annotation> entry : this.y.entrySet()) {
            if (entry.getValue() == annotation) {
                entry.getKey().a(annotation, this.c, this.k, false);
                r();
                return;
            }
        }
    }

    public final Unit a(au auVar, q30 q30Var) {
        auVar.a(false);
        if (q30Var != null) {
            q30Var.e = null;
        }
        this.e.recycle();
        return Unit.INSTANCE;
    }
}
