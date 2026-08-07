package com.pspdfkit.internal;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.pspdfkit.annotations.Annotation;
import com.pspdfkit.annotations.AnnotationFlags;
import com.pspdfkit.annotations.AnnotationProvider;
import com.pspdfkit.annotations.AnnotationType;
import com.pspdfkit.annotations.InkAnnotation;
import com.pspdfkit.preferences.PSPDFKitPreferences;
import com.pspdfkit.ui.special_mode.controller.AnnotationTool;
import com.pspdfkit.ui.special_mode.controller.AnnotationToolVariant;
import com.pspdfkit.undo.edit.CompoundEdit;
import com.pspdfkit.undo.edit.annotations.AnnotationPropertyEdit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt__JobKt;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: classes3.dex */
public final class jg extends d3 implements AnnotationProvider.OnAnnotationUpdatedListener {
    public final Paint c;
    public final j10 d;
    public final Matrix e;
    public final Path f;
    public float g;
    public float h;
    public float i;
    public boolean j;
    public boolean k;
    public boolean l;
    public final PSPDFKitPreferences m;
    public float n;
    public final CoroutineScope o;
    public Job p;
    public final AnnotationTool q;
    public final AnnotationToolVariant r;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public jg(q0 q0Var, Paint paint, j10 j10Var) {
        super(q0Var);
        q0Var.getClass();
        this.c = paint;
        this.d = j10Var;
        this.e = new Matrix();
        this.f = new Path();
        PSPDFKitPreferences pSPDFKitPreferences = PSPDFKitPreferences.get(q0Var.a);
        pSPDFKitPreferences.getClass();
        this.m = pSPDFKitPreferences;
        this.o = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getMain().getImmediate()));
        this.q = AnnotationTool.ERASER;
        AnnotationToolVariant annotationToolVariantDefaultVariant = AnnotationToolVariant.defaultVariant();
        annotationToolVariantDefaultVariant.getClass();
        this.r = annotationToolVariantDefaultVariant;
    }

    @Override // com.pspdfkit.internal.d3, com.pspdfkit.internal.gu
    public final void a(q30 q30Var) {
        m40 state;
        this.b = q30Var;
        au auVarL = l();
        if (auVarL == null || (state = auVarL.getState()) == null) {
            return;
        }
        auVarL.a(this.e);
        this.l = auVarL.getPdfConfiguration().getEnableStylusOnDetection();
        this.g = state.f;
        this.a.f.addOnAnnotationUpdatedListener(this);
        this.a.a(this);
        if (this.d.getParent() != null) {
            ViewParent parent = this.d.getParent();
            parent.getClass();
            ((ViewGroup) parent).removeView(this.d);
        }
        auVarL.addView(this.d);
        q30Var.bringToFront();
        Job job = this.p;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        lm lmVarJ = j();
        if (lmVarJ == null) {
            return;
        }
        this.p = BuildersKt__Builders_commonKt.launch$default(this.o, null, null, new hg(this, lmVarJ.getAnnotationProvider(), null), 3, null);
    }

    public final void b(final q30 q30Var) {
        Job job = this.p;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.p = null;
        JobKt__JobKt.cancelChildren$default(this.o.getCoroutineContext(), (CancellationException) null, 1, (Object) null);
        final au parentView = q30Var.getParentView();
        if (parentView == null) {
            return;
        }
        if (this.d.getAnnotations().isEmpty()) {
            parentView.removeView(this.d);
            return;
        }
        i4 annotationRenderingCoordinator = parentView.getAnnotationRenderingCoordinator();
        List<Annotation> annotations = this.d.getAnnotations();
        annotations.getClass();
        Function0<Unit> function0 = new Function0() { // from class: com.pspdfkit.internal.jg$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return jg.a(parentView, this, q30Var);
            }
        };
        annotationRenderingCoordinator.getClass();
        Iterator<T> it = annotations.iterator();
        while (it.hasNext()) {
            annotationRenderingCoordinator.b((Annotation) it.next());
        }
        annotationRenderingCoordinator.a((List<? extends Annotation>) annotations, true, function0);
    }

    @Override // com.pspdfkit.internal.gu
    public final boolean c() throws InterruptedException {
        a(true);
        return false;
    }

    @Override // com.pspdfkit.internal.gu
    public final boolean d() throws InterruptedException {
        a(true);
        this.a.b(this);
        return false;
    }

    @Override // com.pspdfkit.internal.gu
    public final int f() {
        return 21;
    }

    @Override // com.pspdfkit.internal.gu
    public final void g() throws InterruptedException {
        a(false);
        this.a.c(this);
    }

    @Override // com.pspdfkit.internal.d3
    public final AnnotationTool h() {
        return this.q;
    }

    @Override // com.pspdfkit.internal.d3
    public final AnnotationToolVariant i() {
        return this.r;
    }

    public final void m() throws InterruptedException {
        i4 annotationRenderingCoordinator;
        o3 annotationProvider;
        if (this.d.getAnnotations().isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList(this.d.getAnnotations());
        ArrayList arrayList2 = new ArrayList(this.d.getShapes());
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if ((arrayList.get(i) instanceof InkAnnotation) && (arrayList2.get(i) instanceof kk)) {
                Object obj = arrayList.get(i);
                obj.getClass();
                InkAnnotation inkAnnotation = (InkAnnotation) obj;
                Object obj2 = arrayList2.get(i);
                obj2.getClass();
                kk kkVar = (kk) obj2;
                if (((mk) kkVar.a).t) {
                    ArrayList arrayListA = kkVar.a(this.e, this.g);
                    if (arrayListA.isEmpty()) {
                        lm lmVarJ = j();
                        if (lmVarJ != null && (annotationProvider = lmVarJ.getAnnotationProvider()) != null) {
                            BuildersKt__BuildersKt.runBlocking$default(null, new ig(annotationProvider, inkAnnotation, null), 1, null);
                        }
                    } else {
                        if (!Intrinsics.areEqual(inkAnnotation.getLines(), arrayListA)) {
                            arrayList4.add(new AnnotationPropertyEdit(inkAnnotation, 100, inkAnnotation.getLines(), arrayListA));
                        }
                        inkAnnotation.setLines(arrayListA);
                    }
                    arrayList3.add(inkAnnotation);
                }
            }
        }
        if (!arrayList4.isEmpty()) {
            this.a.c.a(new CompoundEdit(arrayList4));
        }
        au auVarL = l();
        if (auVarL == null || (annotationRenderingCoordinator = auVarL.getAnnotationRenderingCoordinator()) == null) {
            return;
        }
        annotationRenderingCoordinator.a((List<? extends Annotation>) arrayList3, false, (Function0<Unit>) null);
    }

    @Override // com.pspdfkit.annotations.AnnotationProvider.OnAnnotationUpdatedListener
    public final void onAnnotationCreated(Annotation annotation) {
        annotation.getClass();
        onAnnotationUpdated(annotation);
    }

    @Override // com.pspdfkit.annotations.AnnotationProvider.OnAnnotationUpdatedListener
    public final void onAnnotationRemoved(Annotation annotation) {
        annotation.getClass();
        if (annotation.getPageIndex() == k() && annotation.getType() == AnnotationType.INK) {
            j10 j10Var = this.d;
            j10Var.n.removeAll(Arrays.asList(annotation));
            j10Var.c();
            q30 q30Var = this.b;
            if (q30Var != null) {
                q30Var.c();
            }
        }
    }

    @Override // com.pspdfkit.annotations.AnnotationProvider.OnAnnotationUpdatedListener
    public final void onAnnotationUpdated(Annotation annotation) {
        i4 annotationRenderingCoordinator;
        annotation.getClass();
        if (annotation.getPageIndex() == k() && a(annotation)) {
            j10 j10Var = this.d;
            j10Var.getClass();
            Annotation annotation2 = new Annotation[]{annotation}[0];
            if (!j10Var.n.contains(annotation2)) {
                j10Var.n.add(annotation2);
            }
            j10Var.c();
            List<? extends Annotation> listListOf = CollectionsKt.listOf(annotation);
            au auVarL = l();
            if (auVarL != null && (annotationRenderingCoordinator = auVarL.getAnnotationRenderingCoordinator()) != null) {
                listListOf.getClass();
                Iterator<T> it = listListOf.iterator();
                while (it.hasNext()) {
                    annotationRenderingCoordinator.a((Annotation) it.next());
                }
                annotationRenderingCoordinator.a(listListOf, false, (Function0<Unit>) null);
            }
            q30 q30Var = this.b;
            if (q30Var != null) {
                q30Var.c();
            }
        }
    }

    @Override // com.pspdfkit.annotations.AnnotationProvider.OnAnnotationUpdatedListener
    public final void onAnnotationZOrderChanged(int i, List<? extends Annotation> list, List<? extends Annotation> list2) {
        list.getClass();
        list2.getClass();
    }

    /* JADX WARN: Code duplicated, block: B:102:0x0158 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:104:0x0148 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:107:0x01a5 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:109:0x0195 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:10:0x0015  */
    /* JADX WARN: Code duplicated, block: B:35:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:38:0x00c0  */
    /* JADX WARN: Code duplicated, block: B:39:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:42:0x00f6  */
    /* JADX WARN: Code duplicated, block: B:46:0x0104  */
    /* JADX WARN: Code duplicated, block: B:48:0x0108  */
    /* JADX WARN: Code duplicated, block: B:49:0x010c  */
    /* JADX WARN: Code duplicated, block: B:52:0x011d A[LOOP:2: B:51:0x011b->B:52:0x011d, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:54:0x0133 A[LOOP:1: B:47:0x0106->B:54:0x0133, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:55:0x0139  */
    /* JADX WARN: Code duplicated, block: B:57:0x013e  */
    /* JADX WARN: Code duplicated, block: B:60:0x014e  */
    /* JADX WARN: Code duplicated, block: B:71:0x0180  */
    /* JADX WARN: Code duplicated, block: B:75:0x019b  */
    /* JADX WARN: Code duplicated, block: B:95:0x00fe A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:97:0x00f0 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:99:0x013c A[EDGE_INSN: B:99:0x013c->B:56:0x013c BREAK  A[LOOP:1: B:47:0x0106->B:54:0x0133], SYNTHETIC] */
    @Override // com.pspdfkit.internal.gu
    public final boolean a(MotionEvent motionEvent) throws InterruptedException {
        j10 j10Var;
        float f;
        float f2;
        float f3;
        float f4;
        float fMax;
        float f5;
        float f6;
        float fSqrt;
        int iMin;
        ArrayList arrayList;
        boolean zA;
        j10 j10Var2;
        int i;
        float f7;
        float f8;
        float f9;
        int size;
        int i2;
        int actionMasked = motionEvent.getActionMasked();
        boolean z = true;
        if (actionMasked == 0) {
            z = true;
            if (!br.a(motionEvent, this.l, this.m)) {
                return false;
            }
            a(motionEvent.getX(), motionEvent.getY());
        } else if (actionMasked == 1) {
            z = true;
            this.k = false;
            this.d.setForceHighQualityDrawing(false);
            for (r4 r4Var : this.d.getShapes()) {
                if (r4Var instanceof kk) {
                    kk kkVar = (kk) r4Var;
                    kkVar.e();
                    ((mk) kkVar.a).i();
                }
            }
            j10Var = this.d;
            if (j10Var.getParent() != null && j10Var.getLocalVisibleRect(j10Var.j)) {
                j10Var.j();
                j10Var.g();
                j10Var.invalidate();
            }
            m();
        } else {
            if (actionMasked == 2) {
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                au auVarL = l();
                if (auVarL != null) {
                    if (ip.b(x, auVarL.getWidth()) && ip.b(y, auVarL.getHeight())) {
                        if (this.j) {
                            a(x, y);
                        } else {
                            float fMax2 = Math.max(this.n, Math.min(x, auVarL.getWidth() - this.n));
                            float fMax3 = Math.max(this.n, Math.min(y, auVarL.getHeight() - this.n));
                            float fAbs = Math.abs(fMax2 - this.h);
                            float fAbs2 = Math.abs(fMax3 - this.i);
                            if (!this.j) {
                            }
                            float f10 = this.h;
                            f = this.g;
                            f2 = f10 / f;
                            f3 = this.i / f;
                            float f11 = fMax2 / f;
                            float f12 = fMax3 / f;
                            f4 = 0.0f;
                            if (f <= 0.0f) {
                                f = 1.0f;
                            }
                            fMax = Math.max(this.n / f, 0.5f);
                            f5 = f11 - f2;
                            f6 = f12 - f3;
                            fSqrt = (float) Math.sqrt((f6 * f6) + (f5 * f5));
                            if (fSqrt < 1.0f) {
                                z = true;
                            } else {
                                iMin = Math.min(Math.max(1, (int) (fSqrt / Math.max(Math.min(0.4f * fMax, 3.0f), 0.5f))), 64);
                                List<r4> shapes = this.d.getShapes();
                                shapes.getClass();
                                arrayList = new ArrayList();
                                for (Object obj : shapes) {
                                    if (obj instanceof gg) {
                                        arrayList.add(obj);
                                    }
                                }
                                if (iMin >= 0) {
                                    i = 0;
                                    zA = false;
                                    while (true) {
                                        if (iMin == 0) {
                                            f7 = f4;
                                        } else {
                                            f7 = i / iMin;
                                        }
                                        f8 = (f7 * f5) + f2;
                                        f9 = (f7 * f6) + f3;
                                        size = arrayList.size();
                                        for (i2 = 0; i2 < size; i2++) {
                                            zA |= ((gg) arrayList.get(i2)).a(f8, f9, fMax);
                                        }
                                        if (i != iMin) {
                                            break;
                                            break;
                                        }
                                        i++;
                                        z = z;
                                        f4 = 0.0f;
                                    }
                                } else {
                                    z = true;
                                    zA = false;
                                }
                                if (zA) {
                                    for (r4 r4Var2 : this.d.getShapes()) {
                                        if (r4Var2 instanceof kk) {
                                            ((kk) r4Var2).e();
                                        }
                                    }
                                    j10Var2 = this.d;
                                    if (j10Var2.getParent() != null) {
                                        j10Var2.j();
                                        j10Var2.g();
                                        j10Var2.invalidate();
                                    }
                                }
                            }
                            this.h = fMax2;
                            this.i = fMax3;
                            if (this.j) {
                                this.k = false;
                            }
                        }
                    } else if (!this.j) {
                        this.j = true;
                        float fMax4 = Math.max(this.n, Math.min(x, auVarL.getWidth() - this.n));
                        float fMax5 = Math.max(this.n, Math.min(y, auVarL.getHeight() - this.n));
                        float fAbs3 = Math.abs(fMax4 - this.h);
                        float fAbs4 = Math.abs(fMax5 - this.i);
                        if (!this.j || fAbs3 > 4.0f || fAbs4 > 4.0f) {
                            float f13 = this.h;
                            f = this.g;
                            f2 = f13 / f;
                            f3 = this.i / f;
                            float f14 = fMax4 / f;
                            float f15 = fMax5 / f;
                            f4 = 0.0f;
                            if (f <= 0.0f) {
                                f = 1.0f;
                            }
                            fMax = Math.max(this.n / f, 0.5f);
                            f5 = f14 - f2;
                            f6 = f15 - f3;
                            fSqrt = (float) Math.sqrt((f6 * f6) + (f5 * f5));
                            if (fSqrt < 1.0f) {
                                z = true;
                            } else {
                                iMin = Math.min(Math.max(1, (int) (fSqrt / Math.max(Math.min(0.4f * fMax, 3.0f), 0.5f))), 64);
                                List<r4> shapes2 = this.d.getShapes();
                                shapes2.getClass();
                                arrayList = new ArrayList();
                                while (r12.hasNext()) {
                                    if (obj instanceof gg) {
                                        arrayList.add(obj);
                                    }
                                }
                                if (iMin >= 0) {
                                    i = 0;
                                    zA = false;
                                    while (true) {
                                        if (iMin == 0) {
                                            f7 = f4;
                                        } else {
                                            f7 = i / iMin;
                                        }
                                        f8 = (f7 * f5) + f2;
                                        f9 = (f7 * f6) + f3;
                                        size = arrayList.size();
                                        while (i2 < size) {
                                            zA |= ((gg) arrayList.get(i2)).a(f8, f9, fMax);
                                        }
                                        if (i != iMin) {
                                            break;
                                        }
                                        i++;
                                        z = z;
                                        f4 = 0.0f;
                                    }
                                } else {
                                    z = true;
                                    zA = false;
                                }
                                if (zA) {
                                    while (r2.hasNext()) {
                                        if (r4Var2 instanceof kk) {
                                            ((kk) r4Var2).e();
                                        }
                                    }
                                    j10Var2 = this.d;
                                    if (j10Var2.getParent() != null && j10Var2.getLocalVisibleRect(j10Var2.j)) {
                                        j10Var2.j();
                                        j10Var2.g();
                                        j10Var2.invalidate();
                                    }
                                }
                            }
                            this.h = fMax4;
                            this.i = fMax5;
                            if (this.j) {
                                this.k = false;
                            }
                        }
                    }
                }
            } else if (actionMasked == 3) {
                z = true;
                this.k = false;
                this.d.setForceHighQualityDrawing(false);
                while (r1.hasNext()) {
                    if (r4Var instanceof kk) {
                        kk kkVar2 = (kk) r4Var;
                        kkVar2.e();
                        ((mk) kkVar2.a).i();
                    }
                }
                j10Var = this.d;
                if (j10Var.getParent() != null) {
                    j10Var.j();
                    j10Var.g();
                    j10Var.invalidate();
                }
                m();
            }
            z = true;
        }
        q30 q30Var = this.b;
        if (q30Var != null) {
            q30Var.c();
        }
        return z;
    }

    @Override // com.pspdfkit.internal.gu
    public final void a(Matrix matrix) {
        m40 state;
        au auVarL = l();
        if (auVarL == null || (state = auVarL.getState()) == null) {
            return;
        }
        this.g = state.f;
        if (!Intrinsics.areEqual(this.e, matrix)) {
            this.e.set(matrix);
        }
        j10 j10Var = this.d;
        Matrix matrix2 = this.e;
        float f = this.g;
        j10Var.a.set(matrix2);
        j10Var.m = f;
        j10Var.b();
    }

    @Override // com.pspdfkit.internal.gu
    public final void a(Canvas canvas) {
        canvas.getClass();
        if (this.k) {
            float f = this.h;
            float f2 = this.i;
            int iSave = canvas.save();
            canvas.translate(f, f2);
            try {
                canvas.drawPath(this.f, this.c);
            } finally {
                canvas.restoreToCount(iSave);
            }
        }
    }

    public final void a(boolean z) throws InterruptedException {
        this.k = false;
        m();
        Job job = this.p;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.p = null;
        JobKt__JobKt.cancelChildren$default(this.o.getCoroutineContext(), (CancellationException) null, 1, (Object) null);
        this.a.f.removeOnAnnotationUpdatedListener(this);
        q30 q30Var = this.b;
        if (q30Var != null) {
            if (z) {
                q30Var.setRetainedPageModeHandler(this);
            } else {
                q30Var.e = null;
            }
            b(q30Var);
        }
    }

    public static boolean a(Annotation annotation) {
        return (annotation.getType() != AnnotationType.INK || annotation.hasFlag(AnnotationFlags.READONLY) || annotation.isLocked() || annotation.getHasLockedContents() || annotation.hasFlag(AnnotationFlags.HIDDEN) || annotation.hasFlag(AnnotationFlags.NOVIEW) || annotation.isReply()) ? false : true;
    }

    public static final Unit a(au auVar, jg jgVar, q30 q30Var) {
        if (auVar.v) {
            auVar.a(false);
            jgVar.getClass();
            if (q30Var != null) {
                q30Var.e = null;
            }
            auVar.removeView(jgVar.d);
        } else {
            auVar.removeView(jgVar.d);
            if (q30Var != null) {
                q30Var.e = null;
            }
            auVar.a((dt) null);
        }
        return Unit.INSTANCE;
    }

    public final void a(float f, float f2) {
        boolean zA = false;
        this.j = false;
        this.k = true;
        this.h = f;
        this.i = f2;
        float f3 = this.a.a.getResources().getDisplayMetrics().density;
        float f4 = 3 * f3;
        float fMax = Math.max(this.a.p.e * f3, 1 + f4);
        if (fMax != this.n) {
            this.n = fMax;
            this.f.reset();
            this.f.setFillType(Path.FillType.EVEN_ODD);
            Path path = this.f;
            float f5 = this.n;
            Path.Direction direction = Path.Direction.CW;
            path.addCircle(0.0f, 0.0f, f5, direction);
            this.f.addCircle(0.0f, 0.0f, this.n - f4, direction);
        }
        if (this.g < 3.0f) {
            this.d.setForceHighQualityDrawing(true);
        }
        float f6 = this.g;
        float f7 = f / f6;
        float f8 = f2 / f6;
        if (f6 <= 0.0f) {
            f6 = 1.0f;
        }
        float fMax2 = Math.max(this.n / f6, 0.5f);
        for (r4 r4Var : this.d.getShapes()) {
            if (r4Var instanceof gg) {
                zA |= ((gg) r4Var).a(f7, f8, fMax2);
            }
        }
        if (zA) {
            for (r4 r4Var2 : this.d.getShapes()) {
                if (r4Var2 instanceof kk) {
                    ((kk) r4Var2).e();
                }
            }
            j10 j10Var = this.d;
            if (j10Var.getParent() == null || !j10Var.getLocalVisibleRect(j10Var.j)) {
                return;
            }
            j10Var.j();
            j10Var.g();
            j10Var.invalidate();
        }
    }
}
