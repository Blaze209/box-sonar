package com.pspdfkit.internal;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.RectF;
import android.view.View;
import android.widget.OverScroller;
import android.widget.Scroller;
import com.pspdfkit.configuration.page.PageScrollDirection;
import com.pspdfkit.configuration.page.PageScrollMode;
import com.pspdfkit.internal.views.document.DocumentView;
import com.pspdfkit.utils.Size;
import java.util.ArrayList;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes3.dex */
public final class d30 extends ln {
    public float G;
    public int H;
    public int I;
    public final OverScroller J;
    public final Scroller K;
    public int L;
    public int M;
    public int N;
    public int[] O;
    public boolean P;
    public boolean Q;

    public static final /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[PageScrollDirection.values().length];
            try {
                iArr[PageScrollDirection.HORIZONTAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PageScrollDirection.VERTICAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d30(DocumentView documentView, int i, int i2, float f, float f2, int i3, boolean z, zt ztVar, PageScrollDirection pageScrollDirection) {
        super(documentView, i, i2, f, f2, i3, z, ztVar, PageScrollMode.PER_PAGE, pageScrollDirection);
        pageScrollDirection.getClass();
        this.O = new int[0];
        i();
        Context context = documentView.getContext();
        context.getClass();
        this.J = new OverScroller(context);
        this.K = new Scroller(context);
        this.w = new b80(documentView, this);
        float f3 = 2;
        this.H = Math.max((int) ((this.h - (((Size) this.k.get(this.p)).width * 1.0f)) / f3), 0);
        this.I = Math.max((int) ((this.i - (((Size) this.k.get(this.p)).height * 1.0f)) / f3), 0);
        z();
    }

    @Override // com.pspdfkit.internal.ln
    public final int a(int i) {
        return this.h;
    }

    @Override // com.pspdfkit.internal.ln
    public final int b(int i, int i2) {
        int i3 = a.a[this.g.ordinal()];
        if (i3 == 1) {
            return this.f.b(f(i, i2));
        }
        if (i3 != 2) {
            throw new NoWhenBranchMatchedException();
        }
        int i4 = (this.i / 2) + i2;
        int i5 = this.p;
        int length = this.O.length;
        for (int i6 = 0; i6 < length; i6++) {
            int[] iArr = this.O;
            if (i6 == iArr.length - 1) {
                i5 = i6;
            } else if (iArr[i6] <= i4 && i4 < iArr[i6 + 1]) {
                return i6;
            }
        }
        return i5;
    }

    @Override // com.pspdfkit.internal.ln
    public final int c(int i) {
        int iMax;
        int iA = this.f.a(i);
        if (this.g == PageScrollDirection.HORIZONTAL) {
            int iA2 = this.f.a(this.p);
            int i2 = (int) (((Size) this.k.get(i)).width * 1.0f);
            if (iA >= iA2 || this.p == -1) {
                iMax = i == this.p ? this.H : Math.max((this.h - i2) / 2, 0);
            } else {
                int i3 = this.h;
                iMax = i3 > i2 ? (i3 - i2) / 2 : i3 - i2;
            }
        } else {
            iMax = i == this.p ? this.H : Math.max((int) ((this.h - (((Size) this.k.get(i)).width * 1.0f)) / 2), 0);
        }
        return l(iA) + iMax;
    }

    @Override // com.pspdfkit.internal.ln
    public final int d() {
        int i = a.a[this.g.ordinal()];
        if (i != 1) {
            if (i == 2) {
                return this.h + (this.G > 1.0f ? q() - u() : 0);
            }
            throw new NoWhenBranchMatchedException();
        }
        float f = this.G;
        if (f < 1.0f) {
            return 0;
        }
        int i2 = this.h;
        return f == 1.0f ? s() + i2 : (q() + i2) - u();
    }

    @Override // com.pspdfkit.internal.ln
    public final int e() {
        int i = a.a[this.g.ordinal()];
        if (i == 1) {
            if (this.G > 1.0f) {
                return -this.I;
            }
            return 0;
        }
        if (i != 2) {
            throw new NoWhenBranchMatchedException();
        }
        float f = this.G;
        if (f < 1.0f) {
            return 0;
        }
        return f == 1.0f ? Math.max(this.a.getScrollY(), 0) : -this.I;
    }

    @Override // com.pspdfkit.internal.ln
    public final int e(int i) {
        return -1;
    }

    public final int f(int i, int i2) {
        int i3 = a.a[this.g.ordinal()];
        if (i3 != 1) {
            if (i3 == 2) {
                return b(i, i2);
            }
            throw new NoWhenBranchMatchedException();
        }
        int i4 = (this.h / 2) + i;
        int iA = this.f.a(this.p);
        int length = this.O.length;
        for (int i5 = 0; i5 < length; i5++) {
            int[] iArr = this.O;
            if (i5 == iArr.length - 1) {
                iA = i5;
            } else if (iArr[i5] <= i4 && i4 < iArr[i5 + 1]) {
                return i5;
            }
        }
        return iA;
    }

    public final void g(int i, int i2) {
        float f = this.G * 2.5f;
        float f2 = f / (f - 1);
        int i3 = (int) (this.H * f2);
        int i4 = this.h;
        int i5 = i4 - i3;
        int iMax = i3 >= i5 ? i4 / 2 : Math.max(i3, Math.min(i, i5));
        int i6 = (int) (this.I * f2);
        int i7 = this.i;
        int i8 = i7 - i6;
        h().a(iMax, i6 >= i8 ? i7 / 2 : Math.max(i6, Math.min(i2, i8)), this.G, f, 300L);
    }

    @Override // com.pspdfkit.internal.ln
    public final float h(int i) {
        if (this.p == i) {
            return this.G;
        }
        return 1.0f;
    }

    @Override // com.pspdfkit.internal.ln
    public final void i(int i) {
        a(i, Math.abs(i - this.p) <= 2);
    }

    public final int k(int i) {
        int i2 = this.p;
        ArrayList arrayList = this.k;
        return i == i2 ? (int) (((Size) arrayList.get(i)).width * this.G) : (int) (((Size) arrayList.get(i)).width * 1.0f);
    }

    public final int l(int i) {
        int i2 = a.a[this.g.ordinal()];
        if (i2 == 1) {
            return this.O[i];
        }
        if (i2 == 2) {
            return 0;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final int m(int i) {
        int i2 = a.a[this.g.ordinal()];
        if (i2 == 1) {
            return 0;
        }
        if (i2 == 2) {
            return this.O[i];
        }
        throw new NoWhenBranchMatchedException();
    }

    public final boolean n(int i) {
        int iA = this.f.a(i);
        return l(iA) - this.a.getScrollX() == 0 && m(iA) - this.a.getScrollY() == 0;
    }

    @Override // com.pspdfkit.internal.ln
    public final void o() {
        if ((a() && x()) || this.m || this.n) {
            return;
        }
        int iB = b(this.a.getScrollX(), this.a.getScrollY());
        if (!n(iB)) {
            int iA = this.f.a(iB);
            this.J.startScroll(this.a.getScrollX(), this.a.getScrollY(), l(iA) - this.a.getScrollX(), m(iA) - this.a.getScrollY(), 150);
            this.a.postInvalidateOnAnimation();
        }
        y();
    }

    @Override // com.pspdfkit.internal.ln
    public final void p() {
        int i = this.p;
        i();
        z();
        a(i, false);
    }

    public final int q() {
        return Math.max(this.h - ((int) (((Size) this.k.get(this.p)).width * this.G)), 0);
    }

    public final int r() {
        return Math.max(this.i - ((int) (((Size) this.k.get(this.p)).height * this.G)), 0);
    }

    public final int s() {
        int i = a.a[this.g.ordinal()];
        if (i == 1) {
            return l(this.j.s - 1);
        }
        if (i == 2) {
            return 0;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final int t() {
        int i = a.a[this.g.ordinal()];
        if (i == 1) {
            return 0;
        }
        if (i == 2) {
            return m(this.j.s - 1);
        }
        throw new NoWhenBranchMatchedException();
    }

    public final int u() {
        return Math.min(this.h - ((int) (((Size) this.k.get(this.p)).width * this.G)), 0);
    }

    public final int v() {
        return Math.min(this.i - ((int) (((Size) this.k.get(this.p)).height * this.G)), 0);
    }

    public final Point w() {
        int iMax;
        int iMax2;
        int i = (int) (((Size) this.k.get(this.p)).width * this.G);
        int i2 = (int) (((Size) this.k.get(this.p)).height * this.G);
        int i3 = this.h;
        if (i <= i3) {
            iMax = (i3 - i) / 2;
        } else {
            iMax = Math.max(u(), Math.min(this.H, q()));
        }
        int i4 = this.i;
        if (i2 <= i4) {
            iMax2 = (i4 - i2) / 2;
        } else {
            iMax2 = Math.max(v(), Math.min(this.I, r()));
        }
        return new Point(iMax, iMax2);
    }

    public final boolean x() {
        Point pointW = w();
        return this.G + 0.01f >= 1.0f && !(Math.abs(pointW.x - this.H) > 1 || Math.abs(pointW.y - this.I) > 1);
    }

    public final void y() {
        if (x()) {
            return;
        }
        if (this.G + 0.01f >= 1.0f) {
            Point pointW = w();
            Scroller scroller = this.K;
            int i = this.H;
            int i2 = this.I;
            scroller.startScroll(i, i2, pointW.x - i, pointW.y - i2, 0);
            this.a.postInvalidateOnAnimation();
            return;
        }
        RectF rect = this.j.getPageSize(this.p).toRect();
        rect.getClass();
        if (!this.e) {
            RectF rectFG = g(this.p);
            s60.a(rectFG, a(this.p, (Matrix) null));
            float f = rect.left;
            float f2 = (rectFG.bottom + rectFG.top) / 2;
            float f3 = 1;
            rect = new RectF(f, f2 + f3, rect.right, f2 - f3);
        }
        a(rect, this.p, 150L);
    }

    public final void z() {
        int i;
        int i2 = this.j.s;
        int[] iArr = new int[i2];
        this.O = iArr;
        int i3 = a.a[this.g.ordinal()];
        if (i3 == 1) {
            i = this.h;
        } else {
            if (i3 != 2) {
                throw new NoWhenBranchMatchedException();
            }
            i = this.i;
        }
        if (i2 > 0) {
            iArr[0] = 0;
            for (int i4 = 1; i4 < i2; i4++) {
                iArr[i4] = iArr[i4 - 1] + i + this.d;
            }
        }
        o(this.p);
    }

    @Override // com.pspdfkit.internal.ln
    public final boolean a(int i, int i2, boolean z) {
        if (this.o && !z) {
            return false;
        }
        boolean z2 = this.g == PageScrollDirection.HORIZONTAL;
        int i3 = z2 ? i : i2;
        if (((!this.P || i3 >= 0) && ((!this.Q || i3 <= 0) && n(b(this.a.getScrollX(), this.a.getScrollY())))) || !x() || Math.abs(i3) < 2000) {
            this.K.forceFinished(true);
            if (k(this.p) < this.h) {
                i = 0;
            }
            if (b(this.p) < this.i) {
                i2 = 0;
            }
            Scroller scroller = this.K;
            int i4 = this.H;
            int i5 = this.I;
            scroller.getClass();
            scroller.fling(i4, i5, -i, -i2, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
        } else {
            int i6 = this.j.s;
            int iF = f(this.L, this.M);
            int iL = z2 ? l(iF) : m(iF);
            OverScroller overScroller = this.J;
            int currX = (z2 ? overScroller.getCurrX() : overScroller.getCurrY()) - iL;
            float f = this.a.getResources().getDisplayMetrics().density;
            boolean z3 = Math.signum((float) currX) == Math.signum((float) i3);
            boolean z4 = ((float) Math.abs(currX)) < ((float) 32) * f;
            if (!z3 || z4) {
                i3 = 0;
            }
            int iMax = Math.max(0, Math.min(iF + ((int) Math.signum(i3)), i6 - 1));
            this.J.startScroll(this.a.getScrollX(), this.a.getScrollY(), z2 ? l(iMax) - this.a.getScrollX() : 0, z2 ? 0 : m(iMax) - this.a.getScrollY(), 150);
        }
        this.a.postInvalidateOnAnimation();
        return true;
    }

    @Override // com.pspdfkit.internal.ln
    public final void l() {
        this.m = false;
        n();
    }

    @Override // com.pspdfkit.internal.ln
    public final void k() {
        j();
        this.o = false;
        this.n = true;
        this.J.forceFinished(true);
        this.L = this.a.getScrollX();
        this.M = this.a.getScrollY();
        this.K.forceFinished(true);
        boolean z = this.g == PageScrollDirection.HORIZONTAL;
        this.P = !z ? this.I < 0 : this.H < 0;
        ArrayList arrayList = this.k;
        int i = this.p;
        if (z) {
            this.Q = ((int) (((Size) arrayList.get(i)).width * this.G)) + this.H <= this.h;
        } else {
            this.Q = ((int) (((Size) arrayList.get(i)).height * this.G)) + this.I <= this.i;
        }
    }

    @Override // com.pspdfkit.internal.ln
    public final int d(int i) {
        int iMax;
        int iMax2;
        if (this.g == PageScrollDirection.HORIZONTAL) {
            int iA = this.f.a(i);
            if (i == this.p) {
                iMax2 = this.I;
            } else {
                iMax2 = Math.max((int) ((this.i - (((Size) this.k.get(i)).height * 1.0f)) / 2), 0);
            }
            iMax = iMax2;
            i = iA;
        } else {
            int i2 = (int) (((Size) this.k.get(i)).height * 1.0f);
            int i3 = this.p;
            if (i < i3) {
                int i4 = this.i;
                iMax = i4 > i2 ? (i4 - i2) / 2 : i4 - i2;
            } else if (i == i3) {
                iMax = this.I;
            } else {
                iMax = Math.max((this.i - i2) / 2, 0);
            }
        }
        return m(i) + iMax;
    }

    @Override // com.pspdfkit.internal.ln
    public final int b() {
        return this.i;
    }

    @Override // com.pspdfkit.internal.ln
    public final int b(int i) {
        int i2 = this.p;
        ArrayList arrayList = this.k;
        if (i == i2) {
            return (int) (((Size) arrayList.get(i)).height * this.G);
        }
        return (int) (((Size) arrayList.get(i)).height * 1.0f);
    }

    @Override // com.pspdfkit.internal.ln
    public final void b(RectF rectF, int i, long j) {
        rectF.getClass();
        b(rectF, this.p, 0L, true);
    }

    @Override // com.pspdfkit.internal.ln
    public final void b(RectF rectF) {
        b(rectF, this.p, 0L, false);
    }

    @Override // com.pspdfkit.internal.ln
    public final void b(au auVar) {
        auVar.getClass();
        m40 state = auVar.getState();
        if (state == null) {
            return;
        }
        int i = state.b;
        auVar.measure(View.MeasureSpec.makeMeasureSpec(k(i), 1073741824), View.MeasureSpec.makeMeasureSpec(b(i), 1073741824));
    }

    @Override // com.pspdfkit.internal.ln
    public final int c() {
        int i = a.a[this.g.ordinal()];
        if (i != 1) {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            if (this.G > 1.0f) {
                return -this.H;
            }
            return 0;
        }
        float f = this.G;
        if (f < 1.0f) {
            return 0;
        }
        if (f == 1.0f) {
            return Math.max(this.a.getScrollX(), 0);
        }
        return -this.H;
    }

    public final void o(int i) {
        int iMax = Math.max(0, i);
        int iA = this.f.a(iMax);
        if (this.G == 0.0f || this.p != iMax) {
            this.G = 1.0f;
        }
        this.H = c(iMax) - l(iA);
        this.I = d(iMax) - m(iA);
        this.p = iMax;
        au auVarB = this.a.b(this.N);
        if (auVarB != null) {
            b(auVarB);
            a(auVarB);
        }
        this.N = this.p;
    }

    public final void b(RectF rectF, int i, long j, boolean z) {
        RectF rectF2 = new RectF(0.0f, 0.0f, this.h, this.i);
        float f = rectF.left;
        int i2 = this.H;
        float f2 = i2;
        rectF.left = f + f2;
        rectF.right += f2;
        float f3 = rectF.top;
        float f4 = this.I;
        rectF.top = f3 + f4;
        rectF.bottom += f4;
        if (z) {
            ff.b(rectF, new RectF(Math.min(i2, 0), Math.min(this.I, 0), Math.max(k(i), this.h), Math.max(b(i), this.i)));
        }
        h().a(rectF2, rectF, this.G, j);
    }

    @Override // com.pspdfkit.internal.ln
    public final int f() {
        int i = a.a[this.g.ordinal()];
        if (i == 1) {
            return this.i + (this.G > 1.0f ? r() - v() : 0);
        }
        if (i == 2) {
            float f = this.G;
            if (f < 1.0f) {
                return 0;
            }
            int i2 = this.i;
            if (f == 1.0f) {
                return t() + i2;
            }
            return (r() + i2) - v();
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.pspdfkit.internal.ln
    public final void d(int i, int i2) {
        int i3 = this.g == PageScrollDirection.HORIZONTAL ? i : i2;
        if (((this.P && i3 < 0) || ((this.Q && i3 > 0) || !n(b(this.a.getScrollX(), this.a.getScrollY())))) && x()) {
            this.J.startScroll(this.a.getScrollX(), this.a.getScrollY(), i, i2, 0);
        } else {
            this.K.startScroll(this.H, this.I, -(k(this.p) < this.h ? 0 : i), -(b(this.p) < this.i ? 0 : i2), 0);
        }
        this.a.postInvalidateOnAnimation();
    }

    @Override // com.pspdfkit.internal.ln
    public final boolean c(int i, int i2) {
        int i3;
        int i4;
        final Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = i;
        final Ref.IntRef intRef2 = new Ref.IntRef();
        intRef2.element = i2;
        if (!n(b(this.a.getScrollX(), this.a.getScrollY()))) {
            return false;
        }
        this.n = false;
        au auVarB = this.a.b(this.p);
        if (auVarB != null && this.G == 1.0f) {
            return a(CollectionsKt.listOfNotNull(o70.a(auVarB, (this.a.getScrollX() + intRef.element) - c(this.p), (this.a.getScrollY() + intRef2.element) - d(this.p))), new Function0() { // from class: com.pspdfkit.internal.d30$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return d30.a(this.f$0, intRef, intRef2);
                }
            });
        }
        if (this.G == 1.0f) {
            g(intRef.element, intRef2.element);
            return true;
        }
        float f = ((Size) this.k.get(this.p)).width;
        float f2 = ((Size) this.k.get(this.p)).height;
        int i5 = this.H;
        int i6 = this.I;
        float f3 = 2;
        float f4 = (this.h - f) / f3;
        float f5 = (this.i - f2) / f3;
        int i7 = (int) f4;
        int i8 = (int) (f4 + f);
        float f6 = this.G;
        int i9 = (int) ((f * f6) + i5);
        int i10 = ((i8 + i5) - i7) - i9;
        if (i10 != 0) {
            i3 = ((i8 * i5) - (i7 * i9)) / i10;
        } else {
            i3 = (i7 + i8) / 2;
        }
        int i11 = (int) f5;
        int i12 = (int) (f5 + f2);
        int i13 = (int) ((f6 * f2) + i6);
        int i14 = ((i12 + i6) - i11) - i13;
        if (i14 != 0) {
            i4 = ((i12 * i6) - (i11 * i13)) / i14;
        } else {
            i4 = (i11 + i12) / 2;
        }
        b80 b80VarH = h();
        float f7 = i3;
        if (f2 > this.i) {
            i4 = intRef2.element;
        }
        b80VarH.a(f7, i4, this.G, 1.0f, 300L);
        return true;
    }

    @Override // com.pspdfkit.internal.ln
    public final Size f(int i) {
        return (Size) this.k.get(i);
    }

    @Override // com.pspdfkit.internal.ln
    public final boolean a(float f, float f2) {
        this.o = true;
        this.m = true;
        this.u.set(f, f2);
        this.a.a(this.p, this.v);
        l4.a(this.v, this.u);
        return this.m;
    }

    @Override // com.pspdfkit.internal.ln
    public final void a(final int i, final int i2, final int i3, final float f, final long j, long j2) {
        long j3;
        if (this.p != i3) {
            a(i3, false);
            j3 = j2;
        } else {
            j3 = 0;
        }
        this.a.postDelayed(new Runnable() { // from class: com.pspdfkit.internal.d30$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                d30.a(i, i2, this, i3, f, j);
            }
        }, j3);
    }

    @Override // com.pspdfkit.internal.ln
    public final void a(final RectF rectF, final int i, final long j) {
        rectF.getClass();
        if (this.p != i) {
            a(i, false);
        }
        this.a.post(new Runnable() { // from class: com.pspdfkit.internal.d30$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                d30.a(rectF, this, i, j);
            }
        });
    }

    @Override // com.pspdfkit.internal.ln
    public final void a(au auVar) {
        auVar.getClass();
        m40 state = auVar.getState();
        if (state == null) {
            return;
        }
        int i = state.b;
        int iC = c(i);
        int iD = d(i);
        auVar.layout(iC, iD, k(i) + iC, b(i) + iD);
    }

    @Override // com.pspdfkit.internal.ln
    public final void a(int i, boolean z) {
        o(i);
        int iA = this.f.a(i);
        if (!n(i)) {
            int currX = this.J.getCurrX();
            int currY = this.J.getCurrY();
            this.J.startScroll(currX, currY, Math.max(0, Math.min(l(iA), s())) - currX, Math.max(0, Math.min(m(iA), t())) - currY, z ? 150 : 0);
            DocumentView documentView = this.a;
            if (z) {
                documentView.postInvalidateOnAnimation();
                return;
            } else {
                documentView.invalidate();
                return;
            }
        }
        y();
    }

    @Override // com.pspdfkit.internal.ln
    public final void a(boolean z) {
        super.a(z);
        if (z) {
            if (!h().k) {
                this.m = false;
            }
            this.n = false;
            n();
        }
    }

    public static final Unit a(d30 d30Var, Ref.IntRef intRef, Ref.IntRef intRef2) {
        d30Var.g(intRef.element, intRef2.element);
        return Unit.INSTANCE;
    }

    @Override // com.pspdfkit.internal.ln
    public final boolean a() {
        if (this.J.computeScrollOffset()) {
            int iMax = Math.max(0, Math.min(this.J.getCurrX(), s()));
            int iMax2 = Math.max(0, Math.min(this.J.getCurrY(), t()));
            this.a.scrollTo(iMax, iMax2);
            this.a.f(b(iMax, iMax2));
            return true;
        }
        int iB = b(this.a.getScrollX(), this.a.getScrollY());
        boolean zN = n(iB);
        if (zN && this.p != iB) {
            o(iB);
            this.a.m();
            this.a.postInvalidateOnAnimation();
            return false;
        }
        this.a.m();
        if (!this.K.computeScrollOffset() || (!zN && !this.m)) {
            return false;
        }
        boolean z = this.m;
        Scroller scroller = this.K;
        if (z) {
            this.H = scroller.getCurrX();
            this.I = this.K.getCurrY();
        } else {
            this.H = Math.max(u(), Math.min(scroller.getCurrX(), q()));
            this.I = Math.max(v(), Math.min(this.K.getCurrY(), r()));
        }
        au auVarB = this.a.b(this.p);
        if (auVarB != null) {
            a(auVarB);
        }
        return true;
    }

    @Override // com.pspdfkit.internal.ln
    public final boolean a(float f, float f2, float f3) {
        float fMax = Math.max(this.b, Math.min(f * this.G, this.c));
        if (fMax == this.G) {
            return true;
        }
        this.G = fMax;
        PointF pointF = new PointF(f2, f3);
        this.a.a(this.p, this.v);
        l4.a(this.v, pointF);
        int iA = (int) (s60.a(this.v) * (pointF.x - this.u.x));
        int i = -((int) (s60.a(this.v) * (pointF.y - this.u.y)));
        au auVarB = this.a.b(this.p);
        if (auVarB != null) {
            b(auVarB);
            a(auVarB);
            this.a.postInvalidateOnAnimation();
        }
        this.K.startScroll(this.H, this.I, iA, i, 0);
        return true;
    }

    @Override // com.pspdfkit.internal.ln
    public final void a(int i, int i2, int i3, float f, long j) {
        a(i, i2, i3, this.G * f, j, 500L);
    }

    public static final void a(int i, int i2, d30 d30Var, int i3, float f, long j) {
        PointF pointF = new PointF(i, i2);
        s60.a(pointF, d30Var.a(i3, (Matrix) null));
        float f2 = f / d30Var.G;
        float f3 = d30Var.h / f2;
        float f4 = d30Var.i / f2;
        float f5 = pointF.x;
        float f6 = 2;
        float f7 = f3 / f6;
        float f8 = pointF.y;
        float f9 = f4 / f6;
        d30Var.b(new RectF(f5 - f7, f8 - f9, f5 + f7, f8 + f9), d30Var.p, j, true);
    }

    public static final void a(RectF rectF, d30 d30Var, int i, long j) {
        RectF rectF2 = new RectF();
        Matrix matrixA = d30Var.a(i, (Matrix) null);
        rectF2.set(rectF);
        matrixA.mapRect(rectF2);
        d30Var.b(rectF2, d30Var.p, j, true);
    }

    @Override // com.pspdfkit.internal.ln
    public final void a(int i, int i2, int i3) {
        this.K.startScroll(this.H, this.I, (this.h / 2) + (-i), (this.i / 2) + (-i2), i3);
        this.a.postInvalidateOnAnimation();
    }

    @Override // com.pspdfkit.internal.ln
    public final void a(RectF rectF, int i) {
        int i2;
        int i3;
        int i4 = (int) rectF.left;
        int i5 = this.H;
        int i6 = i4 + i5;
        int i7 = ((int) rectF.right) + i5;
        int i8 = this.h;
        int i9 = (i7 - i6) - i8;
        if (i9 != 0) {
            i2 = (0 - (i6 * i8)) / i9;
        } else {
            i2 = (i6 + i7) / 2;
        }
        int i10 = (int) rectF.top;
        int i11 = this.I;
        int i12 = i10 + i11;
        int i13 = ((int) rectF.bottom) + i11;
        int i14 = this.i;
        int i15 = (i13 - i12) - i14;
        if (i15 != 0) {
            i3 = (0 - (i12 * i14)) / i15;
        } else {
            i3 = (i12 + i13) / 2;
        }
        h().a(i2, i3, this.G, (this.G * i8) / rectF.width(), 300L);
    }

    @Override // com.pspdfkit.internal.ln
    public final void a(RectF rectF, int i, long j, boolean z) {
        rectF.getClass();
        RectF rectF2 = new RectF(rectF);
        a(i, (Matrix) null).mapRect(rectF2);
        RectF rectFG = g(this.p);
        int iMax = Math.max(0, this.p);
        if (!z && i == iMax && g(this.p).contains(rectF2)) {
            return;
        }
        float fWidth = rectFG.width() / rectF2.width();
        float fHeight = rectFG.height() / rectF2.height();
        float fH = h(i);
        a((int) rectF.centerX(), (int) rectF.centerY(), i, Math.max(Math.max(this.b, 1.0f), Math.min(Math.min(fH, Math.min(fWidth * fH, fHeight * fH)), this.c)), j, 100L);
    }

    @Override // com.pspdfkit.internal.ln
    public final RectF a(RectF rectF) {
        float f;
        float f2;
        RectF rectF2 = new RectF(rectF);
        int iB = b(this.p);
        int iK = k(this.p);
        float f3 = iB;
        float fHeight = rectF.height();
        float f4 = rectF2.top;
        if (f3 < fHeight) {
            f = -(((rectF.height() - f3) / 2) + f4);
        } else {
            f = -Math.min(f4, Math.max(rectF.bottom - f3, 0.0f));
        }
        float f5 = iK;
        float fWidth = rectF.width();
        float f6 = rectF2.left;
        if (f5 < fWidth) {
            f2 = -(((rectF.width() - f5) / 2) + f6);
        } else {
            f2 = -Math.min(f6, Math.max(rectF.right - f5, 0.0f));
        }
        rectF2.top += f;
        rectF2.bottom += f;
        rectF2.left += f2;
        rectF2.right += f2;
        return rectF2;
    }

    @Override // com.pspdfkit.internal.ln
    public final void a(int i, int i2) {
        this.H = (i / 2) + this.H;
        this.I = (i2 / 2) + this.I;
    }
}
