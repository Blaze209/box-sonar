package com.pspdfkit.internal;

import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import android.view.View;
import android.widget.Scroller;
import com.pspdfkit.R;
import com.pspdfkit.configuration.page.PageScrollDirection;
import com.pspdfkit.configuration.page.PageScrollMode;
import com.pspdfkit.internal.views.document.DocumentView;
import com.pspdfkit.utils.Size;
import java.util.ArrayList;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes3.dex */
public final class sb extends ln {
    public final Scroller G;
    public float H;
    public float I;
    public float J;
    public final float K;
    public final float L;
    public int M;
    public int N;
    public int O;
    public float P;
    public float Q;
    public final int[] R;

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
    public sb(DocumentView documentView, int i, int i2, float f, float f2, int i3, boolean z, zt ztVar, PageScrollDirection pageScrollDirection) {
        super(documentView, i, i2, f, f2, i3, z, ztVar, PageScrollMode.CONTINUOUS, pageScrollDirection);
        pageScrollDirection.getClass();
        this.G = new Scroller(documentView.getContext());
        this.H = 1.0f;
        this.w = new b80(documentView, this);
        int i4 = 0;
        if (this.p == -1) {
            this.p = 0;
        }
        this.H = 1.0f;
        i();
        int i5 = this.j.s;
        int[] iArr = new int[i5];
        this.R = iArr;
        iArr[0] = 0;
        int i6 = i5 - 1;
        int i7 = a.a[pageScrollDirection.ordinal()];
        int i8 = 1;
        if (i7 == 1) {
            ArrayList arrayList = this.k;
            int size = arrayList.size();
            int i9 = 0;
            while (i9 < size) {
                Object obj = arrayList.get(i9);
                i9++;
                Size size2 = (Size) obj;
                if (size2.width > this.J) {
                    this.J = size2.height * 1.0f;
                }
            }
            this.I *= 1.0f;
            this.O = (i2 - ((int) this.J)) / 2;
            while (i8 < i5) {
                int i10 = i8 - 1;
                int iB = ztVar.b(i10);
                int[] iArr2 = this.R;
                iArr2[i8] = (int) (iArr2[i10] + ((Size) this.k.get(iB)).width + i3);
                i8++;
            }
            this.L = this.J;
            float f3 = (this.R[i6] + ((Size) this.k.get(i6)).width) * 1.0f;
            this.K = f3;
            this.I = f3;
            int iK = ((k(0) - documentView.getWidth()) / 2) + (-c(0));
            this.N = iK;
            this.G.startScroll(iK, this.O, 0, 0, 0);
            return;
        }
        if (i7 != 2) {
            throw new NoWhenBranchMatchedException();
        }
        TypedArray typedArrayObtainStyledAttributes = documentView.getContext().getTheme().obtainStyledAttributes(null, R.styleable.pspdf__ToolbarCoordinatorLayout, R.attr.pspdf__toolbarCoordinatorLayoutStyle, R.style.PSPDFKit_ToolbarCoordinatorLayout);
        typedArrayObtainStyledAttributes.getClass();
        typedArrayObtainStyledAttributes.recycle();
        ArrayList arrayList2 = this.k;
        int size3 = arrayList2.size();
        while (i4 < size3) {
            Object obj2 = arrayList2.get(i4);
            i4++;
            float f4 = ((Size) obj2).width;
            if (f4 > this.I) {
                this.I = f4 * 1.0f;
            }
        }
        this.N = (i - ((int) this.I)) / 2;
        while (true) {
            int[] iArr3 = this.R;
            if (i8 >= i5) {
                float f5 = (iArr3[i6] + ((Size) this.k.get(i6)).height) * 1.0f;
                this.L = f5;
                this.K = this.I;
                this.J = f5;
                return;
            }
            int i11 = i8 - 1;
            iArr3[i8] = iArr3[i11] + ((int) ((Size) this.k.get(i11)).height) + i3;
            i8++;
        }
    }

    @Override // com.pspdfkit.internal.ln
    public final boolean a() {
        int iMax;
        this.a.m();
        if (!this.G.computeScrollOffset()) {
            return false;
        }
        if (!this.m || (this.H >= 1.0f && this.n)) {
            int currX = this.G.getCurrX();
            int iQ = q();
            PageScrollDirection pageScrollDirection = this.g;
            int[] iArr = a.a;
            int i = iArr[pageScrollDirection.ordinal()];
            if (i == 1) {
                float f = this.I;
                float f2 = this.h;
                iMax = f > f2 ? 0 : (int) ((f2 - f) / 2.0f);
            } else {
                if (i != 2) {
                    throw new NoWhenBranchMatchedException();
                }
                iMax = Math.max(0, this.h - ((int) this.I));
            }
            this.N = Math.max(iQ, Math.min(currX, iMax));
            int currY = this.G.getCurrY();
            int iR = r();
            int dimensionPixelSize = this.a.getContext().getResources().getDimensionPixelSize(R.dimen.pspdf__continuousLayoutPageDragDownDistance);
            int i2 = iArr[this.g.ordinal()];
            if (i2 == 1) {
                dimensionPixelSize = Math.max(dimensionPixelSize, this.i - ((int) this.J));
            } else {
                if (i2 != 2) {
                    throw new NoWhenBranchMatchedException();
                }
                float f3 = this.J;
                float f4 = this.i;
                if (f3 <= f4) {
                    dimensionPixelSize = (int) ((f4 - f3) / 2.0f);
                }
            }
            this.O = Math.max(iR, Math.min(currY, dimensionPixelSize));
        } else {
            this.N = this.G.getCurrX();
            this.O = this.G.getCurrY();
        }
        int iB = b(0, 0);
        if (iB != this.p && this.H >= 1.0f) {
            this.a.f(iB);
            this.p = iB;
        }
        int childCount = this.a.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            au auVarA = this.a.a(i3);
            auVarA.getClass();
            if (auVarA.isLayoutRequested()) {
                b(auVarA);
            }
            a(auVarA);
        }
        return true;
    }

    @Override // com.pspdfkit.internal.ln
    public final int b(int i, int i2) {
        PageScrollDirection pageScrollDirection = this.g;
        int[] iArr = a.a;
        int i3 = iArr[pageScrollDirection.ordinal()];
        int lastIndex = 0;
        if (i3 != 1) {
            if (i3 != 2) {
                throw new NoWhenBranchMatchedException();
            }
            if (d(0) >= 0) {
                return 0;
            }
            int iB = b(ArraysKt.getLastIndex(this.R)) + d(ArraysKt.getLastIndex(this.R));
            int i4 = this.i;
            if (iB <= i4) {
                return ArraysKt.getLastIndex(this.R);
            }
            int i5 = (i4 / 2) + i2;
            if (i5 < d(0)) {
                return 0;
            }
            int lastIndex2 = ArraysKt.getLastIndex(this.R);
            int length = this.R.length - 1;
            while (lastIndex < length) {
                if (d(lastIndex) <= i5 && i5 < d(lastIndex + 1)) {
                    return lastIndex;
                }
                lastIndex++;
            }
            return lastIndex2;
        }
        zt ztVar = this.f;
        int i6 = iArr[this.g.ordinal()];
        if (i6 == 1) {
            int iB2 = this.f.b(0);
            int iB3 = this.f.b(ArraysKt.getLastIndex(this.R));
            if (c(iB2) < 0) {
                int iK = k(iB3) + c(iB3);
                int i7 = this.h;
                if (iK <= i7) {
                    lastIndex = ArraysKt.getLastIndex(this.R);
                } else {
                    int i8 = (i7 / 2) + i;
                    if (i8 >= c(iB2)) {
                        int lastIndex3 = ArraysKt.getLastIndex(this.R);
                        int length2 = this.R.length - 1;
                        while (lastIndex < length2) {
                            int iB4 = this.f.b(lastIndex);
                            int i9 = lastIndex + 1;
                            int iB5 = this.f.b(i9);
                            if (c(iB4) > i8 || i8 >= c(iB5)) {
                                lastIndex = i9;
                            }
                        }
                        lastIndex = lastIndex3;
                    }
                }
            }
        } else {
            if (i6 != 2) {
                throw new NoWhenBranchMatchedException();
            }
            lastIndex = b(i, i2);
        }
        return ztVar.b(lastIndex);
    }

    @Override // com.pspdfkit.internal.ln
    public final int c(int i) {
        int i2 = a.a[this.g.ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                throw new NoWhenBranchMatchedException();
            }
            return Math.max((int) ((this.I - (((Size) this.k.get(i)).width * this.H)) / 2), 0) + this.N;
        }
        int iA = this.f.a(i);
        int i3 = this.R[iA];
        int i4 = iA * this.d;
        return (int) (((i3 - i4) * this.H) + i4 + this.N);
    }

    @Override // com.pspdfkit.internal.ln
    public final int d(int i) {
        int i2 = a.a[this.g.ordinal()];
        if (i2 == 1) {
            return Math.max((int) ((this.J - (((Size) this.k.get(i)).height * this.H)) / 2), 0) + this.O;
        }
        if (i2 != 2) {
            throw new NoWhenBranchMatchedException();
        }
        int i3 = this.R[i];
        int i4 = i * this.d;
        return (int) (((i3 - i4) * this.H) + i4 + this.O);
    }

    @Override // com.pspdfkit.internal.ln
    public final int e(int i) {
        return -1;
    }

    @Override // com.pspdfkit.internal.ln
    public final Size f(int i) {
        return (Size) this.k.get(i);
    }

    @Override // com.pspdfkit.internal.ln
    public final RectF g() {
        RectF rectF = new RectF();
        rectF.left = this.a.getScrollX() - this.N;
        float scrollY = this.a.getScrollY() - this.O;
        rectF.top = scrollY;
        rectF.right = rectF.left + this.h;
        rectF.bottom = scrollY + this.i;
        return rectF;
    }

    @Override // com.pspdfkit.internal.ln
    public final float h(int i) {
        return this.H;
    }

    @Override // com.pspdfkit.internal.ln
    public final void i(int i) {
        a(i, Math.abs(i - this.p) <= 2);
    }

    @Override // com.pspdfkit.internal.ln
    public final void j(int i) {
        this.G.forceFinished(true);
        int i2 = a.a[this.g.ordinal()];
        if (i2 == 1) {
            this.G.startScroll(this.N, this.O, -(((k(i) - this.a.getWidth()) / 2) + c(i)), 0, 0);
            this.N = this.G.getFinalX();
        } else {
            if (i2 != 2) {
                throw new NoWhenBranchMatchedException();
            }
            this.G.startScroll(this.N, this.O, 0, -(((b(i) - this.a.getHeight()) / 2) + d(i)), 0);
            this.O = this.G.getFinalY();
        }
        a();
        this.a.invalidate();
    }

    public final int k(int i) {
        return (int) (((Size) this.k.get(i)).width * this.H);
    }

    @Override // com.pspdfkit.internal.ln
    public final void l() {
        if (Math.abs(this.H - 1.0f) < 0.1f) {
            this.H = 1.0f;
            this.I = this.K;
            this.J = this.L;
        }
        int childCount = this.a.getChildCount();
        for (int i = 0; i < childCount; i++) {
            au auVarA = this.a.a(i);
            auVarA.getClass();
            b(auVarA);
            a(auVarA);
            auVarA.postInvalidateOnAnimation();
        }
        if (this.H < 1.0f) {
            this.a.postDelayed(new Runnable() { // from class: com.pspdfkit.internal.sb$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    sb.a(this.f$0);
                }
            }, 50L);
            this.m = true;
        } else {
            if (this.n) {
                return;
            }
            this.m = false;
        }
    }

    @Override // com.pspdfkit.internal.ln
    public final void o() {
        int i;
        PageScrollDirection pageScrollDirection = this.g;
        if (pageScrollDirection == PageScrollDirection.HORIZONTAL) {
            float f = this.J;
            int i2 = this.i;
            if (f <= i2) {
                int i3 = (i2 - ((int) f)) / 2;
                if (i3 != this.O) {
                    this.G.forceFinished(true);
                    Scroller scroller = this.G;
                    int i4 = this.N;
                    int i5 = this.O;
                    scroller.startScroll(i4, i5, 0, i3 - i5, 150);
                    this.a.postInvalidateOnAnimation();
                    return;
                }
                return;
            }
        }
        if (pageScrollDirection == PageScrollDirection.VERTICAL) {
            float f2 = this.I;
            int i6 = this.h;
            if (f2 > i6 || (i = (i6 - ((int) f2)) / 2) == this.N) {
                return;
            }
            this.G.forceFinished(true);
            Scroller scroller2 = this.G;
            int i7 = this.N;
            scroller2.startScroll(i7, this.O, i - i7, 0, 150);
            this.a.postInvalidateOnAnimation();
        }
    }

    public final int q() {
        int i = a.a[this.g.ordinal()];
        if (i != 1) {
            if (i == 2) {
                return Math.min(0, this.h - ((int) this.I));
            }
            throw new NoWhenBranchMatchedException();
        }
        float f = this.I;
        float f2 = this.h;
        float f3 = f2 - f;
        return f > f2 ? (int) f3 : (int) (f3 / 2.0f);
    }

    public final int r() {
        int i = a.a[this.g.ordinal()];
        if (i == 1) {
            return Math.min(0, this.i - ((int) this.J));
        }
        if (i != 2) {
            throw new NoWhenBranchMatchedException();
        }
        float f = this.J;
        float f2 = this.i;
        float f3 = f2 - f;
        return f > f2 ? (int) f3 : (int) (f3 / 2.0f);
    }

    @Override // com.pspdfkit.internal.ln
    public final int e() {
        return -this.O;
    }

    public final void f(int i, int i2) {
        float fMax = i;
        float fMax2 = i2;
        float f = this.H * 2.5f;
        if (this.g == PageScrollDirection.HORIZONTAL) {
            int i3 = (int) ((f / (f - 1)) * this.O);
            int i4 = this.i;
            int i5 = i4 - i3;
            fMax2 = i3 >= i5 ? i4 / 2.0f : Math.max(i3, Math.min(i2, i5));
        } else {
            int i6 = (int) ((f / (f - 1)) * this.N);
            int i7 = this.h;
            int i8 = i7 - i6;
            fMax = i6 >= i8 ? i7 / 2.0f : Math.max(i6, Math.min(i, i8));
        }
        h().a(fMax, fMax2, this.H, f, 300L);
    }

    @Override // com.pspdfkit.internal.ln
    public final void k() {
        j();
        this.o = false;
        this.n = true;
        this.G.forceFinished(true);
    }

    @Override // com.pspdfkit.internal.ln
    public final boolean c(final int i, final int i2) {
        int i3;
        int i4;
        m40 state;
        au auVarB = this.a.b(b(i - (this.h / 2), i2 - (this.i / 2)));
        if (auVarB != null && (state = auVarB.getState()) != null) {
            int i5 = state.b;
            if (this.H == 1.0f) {
                return a(CollectionsKt.listOfNotNull(o70.a(auVarB, (this.a.getScrollX() + i) - c(i5), (this.a.getScrollY() + i2) - d(i5))), new Function0() { // from class: com.pspdfkit.internal.sb$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return sb.a(this.f$0, i, i2);
                    }
                });
            }
        }
        float f = this.H;
        if (f == 1.0f) {
            f(i, i2);
            return true;
        }
        float f2 = i;
        float f3 = i2;
        if (this.g == PageScrollDirection.HORIZONTAL) {
            int i6 = this.i;
            float f4 = this.J;
            int i7 = (int) (f4 / f);
            int i8 = (i6 - i7) / 2;
            int i9 = i7 + i8;
            int i10 = this.O;
            int i11 = ((int) f4) + i10;
            int i12 = ((i9 + i10) - i8) - i11;
            if (i12 != 0) {
                i4 = ((i9 * i10) - (i8 * i11)) / i12;
            } else {
                i4 = (i8 + i9) / 2;
            }
            f3 = i4;
        } else {
            int i13 = this.h;
            float f5 = this.I;
            int i14 = (int) (f5 / f);
            int i15 = (i13 - i14) / 2;
            int i16 = i14 + i15;
            int i17 = this.N;
            int i18 = ((int) f5) + i17;
            int i19 = ((i16 + i17) - i15) - i18;
            if (i19 != 0) {
                i3 = ((i16 * i17) - (i15 * i18)) / i19;
            } else {
                i3 = (i15 + i16) / 2;
            }
            f2 = i3;
        }
        h().a(f2, f3, this.H, 1.0f, 300L);
        return true;
    }

    @Override // com.pspdfkit.internal.ln
    public final int f() {
        return (-r()) + this.i;
    }

    @Override // com.pspdfkit.internal.ln
    public final void d(int i, int i2) {
        this.G.forceFinished(true);
        boolean z = this.g == PageScrollDirection.HORIZONTAL;
        if (!z && this.h >= this.I) {
            i = 0;
        }
        if (z && this.i >= this.J) {
            i2 = 0;
        }
        this.G.startScroll(this.N, this.O, -i, -i2, 0);
        this.a.postInvalidateOnAnimation();
    }

    @Override // com.pspdfkit.internal.ln
    public final int d() {
        return (-q()) + this.h;
    }

    @Override // com.pspdfkit.internal.ln
    public final int a(int i) {
        return this.h;
    }

    @Override // com.pspdfkit.internal.ln
    public final boolean a(float f, float f2, float f3) {
        this.m = true;
        float fMax = Math.max(this.b, Math.min(f * this.H, this.c));
        float f4 = this.H;
        if (fMax == f4) {
            return true;
        }
        float f5 = fMax / f4;
        this.H = fMax;
        int i = a.a[this.g.ordinal()];
        if (i == 1) {
            float f6 = this.I;
            float f7 = (this.j.s - 1) * this.d;
            this.I = ((f6 - f7) * f5) + f7;
            this.J *= f5;
        } else if (i == 2) {
            float f8 = this.J;
            float f9 = (this.j.s - 1) * this.d;
            this.I *= f5;
            this.J = ((f8 - f9) * f5) + f9;
        } else {
            throw new NoWhenBranchMatchedException();
        }
        PointF pointF = new PointF(f2, f3);
        this.a.a(this.M, this.v);
        l4.a(this.v, pointF);
        int iA = (int) (s60.a(this.v) * (pointF.x - this.u.x));
        int i2 = -((int) (s60.a(this.v) * (pointF.y - this.u.y)));
        this.G.forceFinished(true);
        this.G.startScroll(this.N, this.O, iA, i2, 0);
        int childCount = this.a.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            au auVarA = this.a.a(i3);
            auVarA.getClass();
            b(auVarA);
            a(auVarA);
            auVarA.postInvalidateOnAnimation();
        }
        return true;
    }

    @Override // com.pspdfkit.internal.ln
    public final int b() {
        return this.i;
    }

    @Override // com.pspdfkit.internal.ln
    public final int b(int i) {
        return (int) (((Size) this.k.get(i)).height * this.H);
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
        return -this.N;
    }

    @Override // com.pspdfkit.internal.ln
    public final void b(int i, int i2, int i3, float f, long j) {
        a(i, i2, i3, f, j, 0L);
    }

    @Override // com.pspdfkit.internal.ln
    public final void b(RectF rectF, int i, long j) {
        rectF.getClass();
        if (rectF.width() == 0.0f) {
            return;
        }
        int iC = c(i);
        int iD = d(i);
        RectF rectF2 = new RectF(0.0f, 0.0f, this.h, this.i);
        rectF.offset(iC, iD);
        h().a(rectF2, rectF, this.H, j);
    }

    @Override // com.pspdfkit.internal.ln
    public final void b(RectF rectF) {
        if (rectF.width() == 0.0f) {
            return;
        }
        RectF rectF2 = new RectF(0.0f, 0.0f, this.h, this.i);
        rectF.offset(this.N, this.O);
        h().a(rectF2, rectF, this.H, 0L);
    }

    @Override // com.pspdfkit.internal.ln
    public final boolean a(int i, int i2, boolean z) {
        if (this.o && !z) {
            return false;
        }
        this.G.forceFinished(true);
        if (this.g == PageScrollDirection.HORIZONTAL) {
            if (this.i > this.J && i != 0 && i2 != 0) {
                i2 = 0;
            }
        } else if (this.h > this.I && i != 0 && i2 != 0) {
            i = 0;
        }
        Scroller scroller = this.G;
        scroller.getClass();
        scroller.fling(this.N, this.O, -i, -i2, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
        this.a.postInvalidateOnAnimation();
        return true;
    }

    @Override // com.pspdfkit.internal.ln
    public final boolean a(float f, float f2) {
        this.o = true;
        this.m = true;
        this.P = f;
        this.Q = f2;
        this.M = this.p;
        this.u.set(f, f2);
        this.a.a(this.M, this.v);
        l4.a(this.v, this.u);
        return true;
    }

    @Override // com.pspdfkit.internal.ln
    public final void a(final int i, final int i2, final int i3, final float f, final long j, long j2) {
        long j3;
        if (this.p != i3) {
            j(i3);
            j3 = j2;
        } else {
            j3 = 0;
        }
        this.a.postDelayed(new Runnable() { // from class: com.pspdfkit.internal.sb$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                sb.a(i, i2, this, i3, f, j);
            }
        }, j3);
    }

    @Override // com.pspdfkit.internal.ln
    public final void a(final RectF rectF, final int i, final long j) {
        rectF.getClass();
        if (this.p != i) {
            j(i);
            this.a.post(new Runnable() { // from class: com.pspdfkit.internal.sb$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    sb.a(rectF, this, i, j);
                }
            });
            return;
        }
        RectF rectF2 = new RectF();
        Matrix matrixA = a(i, (Matrix) null);
        rectF2.set(rectF);
        matrixA.mapRect(rectF2);
        b(rectF2, i, j);
    }

    @Override // com.pspdfkit.internal.ln
    public final void a(int i, boolean z) {
        this.G.forceFinished(true);
        int i2 = a.a[this.g.ordinal()];
        if (i2 == 1) {
            this.G.startScroll(this.N, this.O, -c(i), 0, z ? 150 : 0);
            if (!z) {
                this.N = this.G.getFinalX();
            }
        } else if (i2 == 2) {
            this.G.startScroll(this.N, this.O, 0, -d(i), z ? 150 : 0);
        } else {
            throw new NoWhenBranchMatchedException();
        }
        this.a.postInvalidateOnAnimation();
    }

    @Override // com.pspdfkit.internal.ln
    public final RectF a(RectF rectF) {
        float f;
        float fMin;
        float f2;
        RectF rectF2 = new RectF(rectF);
        int iB = b(this.p);
        int iK = k(this.p);
        if (this.g == PageScrollDirection.HORIZONTAL) {
            float f3 = iB;
            float fHeight = rectF2.height();
            float f4 = rectF2.top;
            if (f3 < fHeight) {
                f = -(((rectF2.height() - f3) / 2.0f) + f4);
            } else {
                f = -Math.min(f4, Math.max(rectF2.bottom - f3, 0.0f));
            }
            float f5 = this.I;
            float f6 = rectF2.right;
            if (f5 < f6) {
                f2 = f5 - f6;
            } else {
                fMin = Math.min(rectF2.left - this.N, 0.0f);
                f2 = -fMin;
            }
        } else {
            float f7 = this.J;
            float f8 = rectF2.bottom;
            f = f7 < f8 ? f7 - f8 : -Math.min(rectF2.top - this.O, 0.0f);
            float f9 = iK;
            float fWidth = rectF2.width();
            float f10 = rectF2.left;
            if (f9 < fWidth) {
                f2 = -(((rectF2.width() - f9) / 2.0f) + f10);
            } else {
                fMin = Math.min(f10, Math.max(rectF2.right - f9, 0.0f));
                f2 = -fMin;
            }
        }
        rectF2.offset(f2, f);
        return rectF2;
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
    public final void a(boolean z) {
        super.a(z);
        if (z) {
            this.m = false;
            this.n = false;
            n();
        }
    }

    public static final Unit a(sb sbVar, int i, int i2) {
        sbVar.f(i, i2);
        return Unit.INSTANCE;
    }

    public static final void a(sb sbVar) {
        sbVar.c((int) sbVar.P, (int) sbVar.Q);
    }

    @Override // com.pspdfkit.internal.ln
    public final void a(int i, int i2, int i3, float f, long j) {
        a(i, i2, i3, this.H * f, j, 0L);
    }

    public static final void a(int i, int i2, sb sbVar, int i3, float f, long j) {
        PointF pointF = new PointF(i, i2);
        s60.a(pointF, sbVar.a(i3, (Matrix) null));
        float f2 = f / sbVar.H;
        int i4 = (int) (sbVar.h / f2);
        int i5 = (int) (sbVar.i / f2);
        float f3 = pointF.x;
        float f4 = i4 / 2.0f;
        float f5 = pointF.y;
        float f6 = i5 / 2.0f;
        sbVar.b(new RectF(f3 - f4, f5 - f6, f3 + f4, f5 + f6), i3, j);
    }

    public static final void a(RectF rectF, sb sbVar, int i, long j) {
        RectF rectF2 = new RectF();
        Matrix matrixA = sbVar.a(i, (Matrix) null);
        rectF2.set(rectF);
        matrixA.mapRect(rectF2);
        sbVar.b(rectF2, i, j);
    }

    @Override // com.pspdfkit.internal.ln
    public final void a(int i, int i2, int i3) {
        this.G.startScroll(this.N, this.O, (this.h / 2) + (-i), (this.i / 2) + (-i2), i3);
        this.a.postInvalidateOnAnimation();
    }

    @Override // com.pspdfkit.internal.ln
    public final void a(RectF rectF, int i) {
        int i2;
        int i3;
        float fWidth = (this.H * this.h) / rectF.width();
        float fC = c(i) - this.a.getScrollX();
        int i4 = (int) (rectF.left + fC);
        int i5 = (int) (rectF.right + fC);
        int i6 = this.h;
        int i7 = (i5 - i4) - i6;
        if (i7 != 0) {
            i2 = (0 - (i4 * i6)) / i7;
        } else {
            i2 = (i4 + i5) / 2;
        }
        float fD = d(i) - this.a.getScrollY();
        int i8 = (int) (rectF.top + fD);
        int i9 = (int) (rectF.bottom + fD);
        int i10 = this.i;
        int i11 = (i9 - i8) - i10;
        if (i11 != 0) {
            i3 = (0 - (i8 * i10)) / i11;
        } else {
            i3 = (i8 + i9) / 2;
        }
        h().a(i2, i3, this.H, fWidth, 300L);
    }

    @Override // com.pspdfkit.internal.ln
    public final void a(RectF rectF, int i, long j, boolean z) {
        rectF.getClass();
        RectF rectF2 = new RectF(rectF);
        a(i, (Matrix) null).mapRect(rectF2);
        RectF rectFG = g(this.p);
        rectF2.offset(c(i) - c(this.p), d(i) - d(this.p));
        if (z || !rectFG.contains(rectF2)) {
            float fWidth = rectFG.width() / rectF2.width();
            float fHeight = rectFG.height() / rectF2.height();
            float f = this.H;
            a((int) rectF.centerX(), (int) rectF.centerY(), i, Math.max(Math.max(this.b, 1.0f), Math.min(Math.min(f, Math.min(fWidth * f, fHeight * f)), this.c)), j, 100L);
        }
    }
}
