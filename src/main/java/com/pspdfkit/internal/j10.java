package com.pspdfkit.internal;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.pspdfkit.annotations.Annotation;
import com.pspdfkit.annotations.AnnotationType;
import com.pspdfkit.annotations.BlendMode;
import com.pspdfkit.configuration.PdfConfiguration;
import com.pspdfkit.internal.jni.NativeLicenseFeatures;
import com.pspdfkit.internal.views.document.DocumentView;
import com.pspdfkit.ui.overlay.OverlayLayoutParams;
import com.pspdfkit.utils.PdfLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class j10 extends View implements a5<Annotation>, nx {
    public final Matrix a;
    public final n10 b;
    public final Paint c;
    public final Paint d;
    public final Paint e;
    public final PdfConfiguration f;
    public BlendMode g;
    public final DocumentView h;
    public final Rect i;
    public final Rect j;
    public final Rect k;
    public final RectF l;
    public float m;
    public final ArrayList n;
    public final ArrayList o;
    public float p;
    public float q;
    public boolean r;
    public final Runnable s;
    public final ft<Annotation> t;
    public final Handler u;
    public boolean v;

    public class a extends u20 {
        public a() {
        }

        @Override // io.reactivex.rxjava3.core.CompletableObserver
        public final void onComplete() {
            Bitmap bitmapA;
            j10 j10Var = j10.this;
            n10 n10Var = j10Var.b;
            boolean z = n10Var.g && (bitmapA = n10Var.a()) != null && !bitmapA.isRecycled() && j10Var.b.b().equals(j10Var.i);
            j10 j10Var2 = j10.this;
            if (z) {
                j10Var2.t.a();
            } else {
                j10Var2.g();
            }
            j10.this.invalidate();
        }
    }

    public static /* synthetic */ class b {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[AnnotationType.values().length];
            a = iArr;
            try {
                iArr[AnnotationType.INK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[AnnotationType.LINE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[AnnotationType.POLYGON.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[AnnotationType.FREETEXT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[AnnotationType.POLYLINE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[AnnotationType.CIRCLE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[AnnotationType.SQUARE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j10(Context context, PdfConfiguration pdfConfiguration, DocumentView documentView, int i) {
        super(context);
        List<? extends Annotation> list = Collections.EMPTY_LIST;
        this.a = new Matrix();
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setDither(true);
        paint.setStyle(Paint.Style.STROKE);
        this.c = paint;
        Paint paint2 = new Paint();
        paint2.setAntiAlias(true);
        paint2.setDither(true);
        paint2.setStyle(Paint.Style.FILL);
        this.d = paint2;
        this.e = new Paint();
        this.g = BlendMode.NORMAL;
        this.i = new Rect();
        this.j = new Rect();
        this.k = new Rect();
        this.l = new RectF();
        this.m = 0.0f;
        this.n = new ArrayList();
        this.o = new ArrayList();
        this.p = 0.0f;
        this.q = 0.0f;
        this.r = false;
        this.s = new Runnable() { // from class: com.pspdfkit.internal.j10$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.d();
            }
        };
        this.t = new ft<>(this);
        this.u = new Handler(Looper.getMainLooper());
        this.v = false;
        this.f = pdfConfiguration;
        this.h = documentView;
        ColorMatrixColorFilter colorMatrixColorFilterA = ff.a(pdfConfiguration.isToGrayscale(), pdfConfiguration.isInvertColors());
        paint.setColorFilter(colorMatrixColorFilterA);
        paint2.setColorFilter(colorMatrixColorFilterA);
        this.b = new n10(paint, paint2);
        setAnnotations(list);
        setWillNotDraw(false);
    }

    @Override // com.pspdfkit.internal.z4
    public final View a() {
        return this;
    }

    @Override // com.pspdfkit.internal.z4
    public final boolean a(RectF rectF) {
        return true;
    }

    @Override // com.pspdfkit.internal.z4
    public final void b() {
        ArrayList arrayList;
        boolean localVisibleRect = getLocalVisibleRect(this.j);
        if (getParent() == null || this.m == 0.0f || !localVisibleRect) {
            this.v = true;
            return;
        }
        boolean z = this.v;
        int i = 0;
        this.v = false;
        int i2 = 0;
        boolean zA = false;
        while (true) {
            int size = this.n.size();
            arrayList = this.o;
            if (i2 >= size) {
                break;
            }
            zA |= ((r4) arrayList.get(i2)).a((Annotation) this.n.get(i2), this.a, this.m);
            i2++;
        }
        int size2 = arrayList.size();
        int i3 = 0;
        while (i3 < size2) {
            Object obj = arrayList.get(i3);
            i3++;
            zA |= ((r4) obj).a(this.m, this.a);
        }
        boolean zJ = j() | zA;
        if (!this.n.isEmpty()) {
            this.g = ((Annotation) this.n.get(0)).getBlendMode();
            ArrayList arrayList2 = this.n;
            int size3 = arrayList2.size();
            int i4 = 0;
            while (i4 < size3) {
                Object obj2 = arrayList2.get(i4);
                i4++;
                BlendMode blendMode = ((Annotation) obj2).getBlendMode();
                if (this.g != blendMode) {
                    PdfLog.w("Nutri.ShapeAnnotationView", "Incompatible blend modes detected in annotation group. Expected: " + this.g + ", found: " + blendMode + ". Falling back to NORMAL blend mode.", new Object[0]);
                    this.g = BlendMode.NORMAL;
                    break;
                }
            }
            if (this.f.isInvertColors()) {
                BlendMode blendMode2 = this.g;
                EnumSet<AnnotationType> enumSet = b5.a;
                BlendMode blendMode3 = BlendMode.MULTIPLY;
                if (blendMode2 == blendMode3) {
                    blendMode2 = BlendMode.SCREEN;
                } else if (blendMode2 == BlendMode.SCREEN) {
                    blendMode2 = blendMode3;
                }
                this.g = blendMode2;
            }
            Paint paint = this.e;
            BlendMode blendMode4 = this.g;
            EnumSet<AnnotationType> enumSet2 = b5.a;
            if (paint == null) {
                paint = new Paint();
            } else {
                paint.reset();
            }
            gf.a(paint, blendMode4);
            int i5 = b5.a.a[this.g.ordinal()];
            if (i5 == 1) {
                i = -1;
            } else if (i5 == 2) {
                i = -16777216;
            }
            setBackgroundColor(i);
        }
        if (zJ || z) {
            g();
            invalidate();
        }
    }

    public final void c() {
        d7 kkVar;
        xp measurementProperties;
        this.o.clear();
        ArrayList arrayList = this.n;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            Annotation annotation = (Annotation) obj;
            ArrayList arrayList2 = this.o;
            switch (b.a[annotation.getType().ordinal()]) {
                case 1:
                    kkVar = new kk(this.f.getUseCubicInterpolationForInkAnnotations());
                    break;
                case 2:
                    kkVar = new xn();
                    break;
                case 3:
                    kkVar = new mw();
                    break;
                case 4:
                case 5:
                    kkVar = new pw();
                    break;
                case 6:
                    kkVar = new t20(2);
                    break;
                case 7:
                    kkVar = new t20(1);
                    break;
                default:
                    throw new IllegalStateException("Shape for " + annotation.getType() + " annotation type is not implemented.");
            }
            if (annotation.isMeasurement() && ar.b().a(NativeLicenseFeatures.MEASUREMENT_TOOLS) && (measurementProperties = annotation.getInternal().getMeasurementProperties()) != null) {
                kkVar.a.a(measurementProperties);
            }
            arrayList2.add(kkVar);
        }
        n();
        b();
        if (this.n.isEmpty()) {
            return;
        }
        this.t.a();
    }

    public final void d() {
        this.b.a(this.i, this.o, this.a, this.m, 0L).subscribe(new a());
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        int iSave = canvas.save();
        if (this.g != BlendMode.NORMAL) {
            canvas.saveLayer(null, this.e);
        }
        super.draw(canvas);
        canvas.restoreToCount(iSave);
    }

    public final void g() {
        if (this.r) {
            return;
        }
        n10 n10Var = this.b;
        n10Var.g = false;
        yz.a(n10Var.j);
        n10Var.j = null;
        this.u.removeCallbacks(this.s);
        this.u.postDelayed(this.s, 50L);
    }

    @Override // com.pspdfkit.internal.z4
    public Annotation getAnnotation() {
        int size = this.n.size();
        ArrayList arrayList = this.n;
        if (size == 1) {
            return (Annotation) arrayList.get(0);
        }
        if (arrayList.size() <= 1) {
            return null;
        }
        PdfLog.w("Nutri.ShapeAnnotationView", "getAnnotation() can be used only when single annotation is bound to ShapeAnnotationView.", new Object[0]);
        return null;
    }

    @Override // com.pspdfkit.internal.a5
    public List<Annotation> getAnnotations() {
        return this.n;
    }

    public List<r4> getShapes() {
        return this.o;
    }

    @Override // com.pspdfkit.internal.z4
    public final boolean i() {
        sp spVar;
        DocumentView documentView = this.h;
        if (documentView == null || (spVar = documentView.q0) == null || Intrinsics.areEqual(spVar.d, (Object) null)) {
            return false;
        }
        j10 j10Var = spVar.d;
        if (j10Var != null) {
            j10Var.a(true);
        }
        spVar.d = null;
        return false;
    }

    public final boolean j() {
        OverlayLayoutParams overlayLayoutParams;
        if (this.m == 0.0f || (overlayLayoutParams = (OverlayLayoutParams) getLayoutParams()) == null) {
            return false;
        }
        RectF pageRect = overlayLayoutParams.pageRect.getPageRect();
        RectF rectF = this.l;
        Matrix matrix = this.a;
        rectF.set(pageRect);
        matrix.mapRect(rectF);
        RectF rectF2 = this.l;
        float f = rectF2.left;
        float f2 = this.m;
        this.p = f / f2;
        float f3 = rectF2.top;
        this.q = f3 / f2;
        Rect rect = this.j;
        if (!rectF2.intersect(rect.left + f, rect.top + f3, rect.right + f, rect.bottom + f3)) {
            this.l.setEmpty();
        }
        if (this.i.left == Math.round(this.l.left) && this.i.top == Math.round(this.l.top) && this.i.right == Math.round(this.l.right) && this.i.bottom == Math.round(this.l.bottom)) {
            return false;
        }
        this.i.set(Math.round(this.l.left), Math.round(this.l.top), Math.round(this.l.right), Math.round(this.l.bottom));
        return true;
    }

    @Override // com.pspdfkit.internal.z4
    public final void m() {
        sp spVar;
        DocumentView documentView = this.h;
        if (documentView == null || (spVar = documentView.q0) == null || Intrinsics.areEqual(spVar.d, this)) {
            return;
        }
        j10 j10Var = spVar.d;
        if (j10Var != null) {
            j10Var.a(true);
        }
        spVar.d = this;
    }

    @Override // com.pspdfkit.internal.z4
    public final void n() {
        EnumSet<AnnotationType> enumSet = b5.a;
        a().setLayoutParams(b5.a(this, false));
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        Bitmap bitmapA;
        super.onDraw(canvas);
        if (!getLocalVisibleRect(this.j) || this.m == 0.0f) {
            return;
        }
        if (j()) {
            g();
        }
        int i = 0;
        if (this.r) {
            int iSave = canvas.save();
            canvas.clipRect(this.j);
            Rect rect = this.j;
            int i2 = rect.left;
            Rect rect2 = this.i;
            canvas.translate(i2 - rect2.left, rect.top - rect2.top);
            ArrayList arrayList = this.o;
            int size = arrayList.size();
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                ((f10) obj).a(canvas, this.c, this.d);
            }
            canvas.restoreToCount(iSave);
            return;
        }
        n10 n10Var = this.b;
        if (n10Var.g && (bitmapA = n10Var.a()) != null && !bitmapA.isRecycled() && this.b.b().equals(this.i)) {
            int iSave2 = canvas.save();
            Rect rect3 = this.j;
            canvas.translate(rect3.left, rect3.top);
            Rect rectB = this.b.b();
            this.k.set(0, 0, rectB.width(), rectB.height());
            canvas.drawBitmap(this.b.a(), (Rect) null, this.k, (Paint) null);
            canvas.restoreToCount(iSave2);
            return;
        }
        int iSave3 = canvas.save();
        canvas.clipRect(this.j);
        float f = this.m;
        canvas.scale(f, f);
        canvas.translate(-this.p, -this.q);
        ArrayList arrayList2 = this.o;
        int size2 = arrayList2.size();
        while (i < size2) {
            Object obj2 = arrayList2.get(i);
            i++;
            ((f10) obj2).b(canvas, this.c, this.d);
        }
        canvas.restoreToCount(iSave3);
    }

    @Override // android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        b();
    }

    @Override // com.pspdfkit.internal.nx
    public final void recycle() {
        this.b.recycle();
        this.i.setEmpty();
        this.j.setEmpty();
        this.l.setEmpty();
        this.a.reset();
        this.m = 0.0f;
        this.n.clear();
        this.o.clear();
        this.p = 0.0f;
        this.q = 0.0f;
        this.r = false;
        this.t.b.clear();
    }

    @Override // com.pspdfkit.internal.z4
    public void setAnnotation(Annotation annotation) {
        setAnnotations(Collections.singletonList(annotation));
    }

    public void setAnnotations(List<? extends Annotation> list) {
        this.n.clear();
        this.n.addAll(list);
        c();
    }

    public void setForceHighQualityDrawing(boolean z) {
        this.r = z;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // com.pspdfkit.internal.z4
    public final void a(z4.a<Annotation> aVar) {
        this.t.b.a((z4.a<T>) aVar);
        if (this.n.isEmpty()) {
            return;
        }
        this.t.a();
    }

    @Override // com.pspdfkit.internal.z4
    public final void a(Matrix matrix, float f) {
        this.a.set(matrix);
        this.m = f;
        b();
    }

    public final void a(boolean z) {
        ArrayList arrayList = this.o;
        int size = arrayList.size();
        int i = 0;
        boolean z2 = false;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            if (((r4) obj).a(z)) {
                z2 = true;
            }
        }
        if (z2 && getParent() != null && getLocalVisibleRect(this.j)) {
            j();
            g();
            invalidate();
        }
    }
}
