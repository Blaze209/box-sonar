package com.pspdfkit.internal;

import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.RectF;
import android.view.inputmethod.InputMethodManager;
import com.pspdfkit.configuration.page.PageScrollDirection;
import com.pspdfkit.configuration.page.PageScrollMode;
import com.pspdfkit.internal.views.document.DocumentView;
import com.pspdfkit.utils.Size;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Action;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ln {
    public final ArrayList A;
    public boolean B;
    public Point C;
    public Job D;
    public Runnable E;
    public long F;
    public final DocumentView a;
    public final float b;
    public final float c;
    public final int d;
    public final boolean e;
    public final zt f;
    public final PageScrollDirection g;
    public int h;
    public int i;
    public final lm j;
    public final ArrayList k;
    public x70 l;
    public boolean m;
    public boolean n;
    public boolean o;
    public int p;
    public int q;
    public int r;
    public int s;
    public int t;
    public final PointF u;
    public final Matrix v;
    public b80 w;
    public final Completable x;
    public final Action y;
    public Disposable z;

    public ln(DocumentView documentView, int i, int i2, float f, float f2, int i3, boolean z, zt ztVar, PageScrollMode pageScrollMode, PageScrollDirection pageScrollDirection) {
        pageScrollMode.getClass();
        pageScrollDirection.getClass();
        this.a = documentView;
        this.b = f;
        this.c = f2;
        this.d = i3;
        this.e = z;
        this.f = ztVar;
        this.g = pageScrollDirection;
        this.h = i;
        this.i = i2;
        lm document = documentView.getDocument();
        if (document == null) {
            throw new IllegalArgumentException("Required value was null.");
        }
        this.j = document;
        this.k = new ArrayList();
        this.u = new PointF();
        this.v = new Matrix();
        Completable completableTimer = Completable.timer(50L, TimeUnit.MILLISECONDS, AndroidSchedulers.mainThread());
        completableTimer.getClass();
        this.x = completableTimer;
        this.y = new Action() { // from class: com.pspdfkit.internal.ln$$ExternalSyntheticLambda0
            @Override // io.reactivex.rxjava3.functions.Action
            public final void run() {
                ln.b(this.f$0);
            }
        };
        this.A = new ArrayList();
        this.C = new Point();
    }

    public static final void b(ln lnVar) {
        lnVar.o();
    }

    public abstract int a(int i);

    public final Matrix a(int i, Matrix matrix) {
        if (matrix == null) {
            matrix = new Matrix();
        }
        matrix.reset();
        float fB = b(i);
        float f = fB / this.j.getPageSize(i).height;
        matrix.setScale(f, -f);
        matrix.postTranslate(0.0f, fB);
        return matrix;
    }

    public abstract RectF a(RectF rectF);

    public void a(int i, int i2) {
    }

    public abstract void a(int i, int i2, int i3);

    public abstract void a(int i, int i2, int i3, float f, long j);

    public abstract void a(int i, int i2, int i3, float f, long j, long j2);

    public abstract void a(int i, boolean z);

    public abstract void a(RectF rectF, int i);

    public abstract void a(RectF rectF, int i, long j);

    public abstract void a(RectF rectF, int i, long j, boolean z);

    public abstract void a(au auVar);

    public abstract boolean a();

    public abstract boolean a(float f, float f2);

    public abstract boolean a(float f, float f2, float f3);

    public abstract boolean a(int i, int i2, boolean z);

    public abstract int b();

    public abstract int b(int i);

    public abstract int b(int i, int i2);

    public abstract void b(RectF rectF);

    public abstract void b(RectF rectF, int i, long j);

    public abstract void b(au auVar);

    public abstract int c();

    public abstract int c(int i);

    public abstract boolean c(int i, int i2);

    public abstract int d();

    public abstract int d(int i);

    public abstract void d(int i, int i2);

    public abstract int e();

    public abstract int e(int i);

    public final void e(int i, int i2) {
        this.s = this.a.getLeft() - this.q;
        this.t = this.a.getTop() - this.r;
        this.q = this.a.getLeft();
        this.r = this.a.getTop();
        int i3 = this.h;
        int i4 = this.i;
        this.h = i;
        this.i = i2;
        a(i - i3, i2 - i4);
        p();
        Object systemService = this.a.getContext().getSystemService("input_method");
        systemService.getClass();
        if (((InputMethodManager) systemService).isActive()) {
            return;
        }
        this.a.post(new Runnable() { // from class: com.pspdfkit.internal.ln$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                ln.a(this.f$0);
            }
        });
    }

    public abstract int f();

    public abstract Size f(int i);

    public final RectF g(int i) {
        RectF rectF = new RectF();
        rectF.left = this.a.getScrollX() - c(i);
        float scrollY = this.a.getScrollY() - d(i);
        rectF.top = scrollY;
        rectF.right = rectF.left + this.h;
        rectF.bottom = scrollY + this.i;
        return rectF;
    }

    public abstract float h(int i);

    public final b80 h() {
        b80 b80Var = this.w;
        if (b80Var != null) {
            return b80Var;
        }
        Intrinsics.throwUninitializedPropertyAccessException("zoomer");
        return null;
    }

    public final void i() {
        int i = this.j.s;
        this.k.clear();
        for (int i2 = 0; i2 < i; i2++) {
            Size pageSize = this.j.getPageSize(i2);
            pageSize.getClass();
            float f = pageSize.width;
            float f2 = pageSize.height;
            int iA = a(i2);
            float fMin = this.e ? Math.min(iA / f, b() / f2) : iA / f;
            this.k.add(new Size(f * fMin, f2 * fMin));
        }
        m();
    }

    public abstract void i(int i);

    public void j(int i) {
        a(i, false);
    }

    public abstract void k();

    public abstract void l();

    public void m() {
    }

    public final void n() {
        yz.a(this.z);
        this.z = this.x.subscribe(this.y);
    }

    public abstract void o();

    public void p() {
        i();
    }

    public void b(int i, int i2, int i3, float f, long j) {
        a(i, i2, i3, f, j, 500L);
    }

    public final void j() {
        this.F++;
        Job job = this.D;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.D = null;
        Runnable runnable = this.E;
        if (runnable != null) {
            this.a.removeCallbacks(runnable);
        }
        this.E = null;
    }

    public RectF g() {
        return g(this.p);
    }

    public void a(boolean z) {
        if (z && this.B) {
            Point point = this.C;
            c(point.x, point.y);
        }
        this.B = false;
    }

    public static final void a(ln lnVar) {
        lnVar.s = lnVar.a.getLeft() - lnVar.q;
        lnVar.t = lnVar.a.getTop() - lnVar.r;
        RectF rectFG = lnVar.g();
        float f = rectFG.left + lnVar.s;
        rectFG.left = f;
        float f2 = rectFG.top + lnVar.t;
        rectFG.top = f2;
        rectFG.right = f + lnVar.h;
        rectFG.bottom = f2 + lnVar.i;
        lnVar.b(rectFG);
        lnVar.n = false;
        lnVar.n();
    }

    public void a(final x70 x70Var) {
        x70Var.getClass();
        this.l = x70Var;
        j(x70Var.b);
        this.A.add(new Function0() { // from class: com.pspdfkit.internal.ln$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ln.a(x70Var, this);
            }
        });
    }

    public static final Unit a(x70 x70Var, ln lnVar) {
        RectF rectF = x70Var.a;
        PointF pointF = new PointF(rectF.centerX(), rectF.centerY());
        s60.a(pointF, lnVar.a(x70Var.b, (Matrix) null));
        float f = lnVar.h;
        float f2 = x70Var.c;
        int i = (int) (f / f2);
        int i2 = (int) (lnVar.i / f2);
        float f3 = pointF.x;
        float f4 = i / 2.0f;
        float f5 = pointF.y;
        float f6 = i2 / 2.0f;
        lnVar.b(lnVar.a(new RectF(f3 - f4, f5 - f6, f3 + f4, f5 + f6)), x70Var.b, 0L);
        if (lnVar.l == x70Var) {
            lnVar.l = null;
            lnVar.a.o();
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [T, kotlinx.coroutines.Job] */
    public final boolean a(List<pu> list, final Function0<Unit> function0) {
        list.getClass();
        function0.getClass();
        if (list.isEmpty()) {
            function0.invoke();
            return true;
        }
        Job job = this.D;
        if (job != null && job.isActive()) {
            function0.invoke();
            return true;
        }
        j();
        final long j = this.F;
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        ExecutorCoroutineDispatcher executorCoroutineDispatcher = su.a;
        ?? Launch$default = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new ru(new Function1() { // from class: com.pspdfkit.internal.ln$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ln.a(this.f$0, objectRef, j, function0, (qu) obj);
            }
        }, list, null), 3, null);
        objectRef.element = Launch$default;
        this.D = Launch$default;
        Runnable runnable = new Runnable() { // from class: com.pspdfkit.internal.ln$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                ln.a(j, this, function0);
            }
        };
        this.E = runnable;
        this.a.postDelayed(runnable, 100L);
        return true;
    }

    public static final Unit a(ln lnVar, Ref.ObjectRef objectRef, long j, Function0 function0, qu quVar) {
        if (lnVar.D == objectRef.element) {
            lnVar.D = null;
        }
        Runnable runnable = lnVar.E;
        if (runnable != null) {
            lnVar.a.removeCallbacks(runnable);
        }
        lnVar.E = null;
        if (j != lnVar.F) {
            return Unit.INSTANCE;
        }
        if (quVar != null) {
            lnVar.a(quVar.b, quVar.a);
        } else {
            function0.invoke();
        }
        return Unit.INSTANCE;
    }

    public static final void a(long j, ln lnVar, Function0 function0) {
        long j2 = lnVar.F;
        if (j != j2) {
            return;
        }
        lnVar.F = j2 + 1;
        lnVar.E = null;
        function0.invoke();
    }
}
