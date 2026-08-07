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
import com.pspdfkit.document.PageBinding;
import com.pspdfkit.internal.views.document.DocumentView;
import com.pspdfkit.utils.Size;
import java.util.ArrayList;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes3.dex */
public final class xe extends ln {
    public final boolean G;
    public final int H;
    public float I;
    public int J;
    public int K;
    public final OverScroller L;
    public final Scroller M;
    public int N;
    public int O;
    public boolean P;
    public int[] Q;
    public boolean R;
    public boolean S;

    /* JADX WARN: Enum visitor error
    jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r0v1 com.pspdfkit.internal.xe$a[], still in use, count: 1, list:
      (r0v1 com.pspdfkit.internal.xe$a[]) from 0x0024: INVOKE (r0v1 com.pspdfkit.internal.xe$a[]) STATIC call: kotlin.enums.EnumEntriesKt.enumEntries(java.lang.Enum[]):kotlin.enums.EnumEntries A[MD:<E extends java.lang.Enum<E>>:(E extends java.lang.Enum<E>[]):kotlin.enums.EnumEntries<E extends java.lang.Enum<E>> (m)]
    	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:164)
    	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:129)
    	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:101)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:100)
    	at jadx.core.utils.InsnRemover.removeAllAndUnbind(InsnRemover.java:257)
    	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:187)
    	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:102)
     */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    public static final class a {
        LEFT,
        RIGHT,
        CENTER_SINGLE;

        static {
            EnumEntriesKt.enumEntries(aVarArr);
        }

        public a() {
            super(str, i);
        }

        public static a valueOf(String str) {
            return (a) Enum.valueOf(a.class, str);
        }

        public static a[] values() {
            return (a[]) d.clone();
        }
    }

    public static final /* synthetic */ class b {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[a.values().length];
            try {
                iArr[0] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a aVar = a.LEFT;
                iArr[2] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a aVar2 = a.LEFT;
                iArr[1] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[PageScrollDirection.values().length];
            try {
                iArr2[PageScrollDirection.HORIZONTAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[PageScrollDirection.VERTICAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            a = iArr2;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public xe(DocumentView documentView, int i, int i2, float f, float f2, int i3, boolean z, boolean z2, boolean z3, zt ztVar, PageScrollDirection pageScrollDirection) {
        int iA;
        int iCoerceAtLeast;
        super(documentView, i, i2, f, f2, i3, z, ztVar, PageScrollMode.PER_PAGE, pageScrollDirection);
        pageScrollDirection.getClass();
        this.G = z2;
        if (z3) {
            Context context = documentView.getContext();
            context.getClass();
            iA = (int) un.a(context, 1, 8);
        } else {
            iA = 0;
        }
        this.H = iA;
        this.I = 1.0f;
        this.Q = new int[0];
        i();
        Context context2 = documentView.getContext();
        context2.getClass();
        this.L = new OverScroller(context2);
        this.M = new Scroller(context2);
        this.w = new b80(documentView, this);
        int iOrdinal = k(n(ztVar.a(this.p))).ordinal();
        if (iOrdinal == 0) {
            iCoerceAtLeast = RangesKt.coerceAtLeast((int) (((i - (m(this.p) * 1.0f)) - iA) / 2.0f), 0);
        } else if (iOrdinal == 1) {
            iCoerceAtLeast = 0;
        } else {
            if (iOrdinal != 2) {
                throw new NoWhenBranchMatchedException();
            }
            iCoerceAtLeast = RangesKt.coerceAtLeast((i - q(this.p)) / 2, 0);
        }
        this.J = iCoerceAtLeast;
        int iL = (int) (l(this.p) * 1.0f);
        this.K = RangesKt.coerceAtLeast((i2 - iL) / 2, 0) + ((iL - b(this.p)) / 2);
        y();
    }

    @Override // com.pspdfkit.internal.ln
    public final int a(int i) {
        a aVarK = k(this.f.a(i));
        a aVar = a.CENTER_SINGLE;
        int i2 = this.h;
        return aVarK == aVar ? i2 : (i2 - this.H) / 2;
    }

    public final pu b(int i, int i2, int i3) {
        au auVarB = this.a.b(i);
        if (auVarB == null) {
            return null;
        }
        int scrollX = (this.a.getScrollX() + i2) - c(i);
        int scrollY = (this.a.getScrollY() + i3) - d(i);
        if (scrollX < 0 || scrollX > auVarB.getWidth() || scrollY < 0 || scrollY > auVarB.getHeight()) {
            return null;
        }
        return o70.a(auVarB, scrollX, scrollY);
    }

    @Override // com.pspdfkit.internal.ln
    public final boolean c(int i, int i2) {
        pu puVarB;
        if (!w(n(this.f.a(o(this.f.b(f(this.a.getScrollX(), this.a.getScrollY()))))))) {
            return false;
        }
        final Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = i;
        final Ref.IntRef intRef2 = new Ref.IntRef();
        intRef2.element = i2;
        this.n = false;
        int iE = e(this.p);
        float f = this.I;
        if (f == 1.0f) {
            int i3 = this.p;
            int i4 = intRef.element;
            int i5 = intRef2.element;
            List listCreateListBuilder = CollectionsKt.createListBuilder();
            pu puVarB2 = b(i3, i4, i5);
            if (puVarB2 != null) {
                listCreateListBuilder.add(puVarB2);
            }
            if (iE != -1 && (puVarB = b(iE, i4, i5)) != null) {
                listCreateListBuilder.add(puVarB);
            }
            return a(CollectionsKt.build(listCreateListBuilder), new Function0() { // from class: com.pspdfkit.internal.xe$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return xe.a(this.f$0, intRef, intRef2);
                }
            });
        }
        if (f == 1.0f) {
            g(intRef.element, intRef2.element);
            return true;
        }
        int iM = m(this.p) + (v(this.p) ? 0 : this.H);
        int iL = l(this.p);
        int i6 = this.J;
        int i7 = this.K;
        float f2 = (this.h - iM) / 2.0f;
        float f3 = (this.i - iL) / 2.0f;
        int i8 = (int) f2;
        float f4 = iM;
        int i9 = (int) (f2 + f4);
        float f5 = this.I;
        int i10 = (int) ((f4 * f5) + i6);
        int i11 = ((i9 + i6) - i8) - i10;
        int i12 = i11 != 0 ? ((i9 * i6) - (i8 * i10)) / i11 : (i8 + i9) / 2;
        int i13 = (int) f3;
        float f6 = iL;
        int i14 = (int) (f3 + f6);
        int i15 = (int) ((f6 * f5) + i7);
        int i16 = ((i14 + i7) - i13) - i15;
        h().a(i12, iL > this.i ? intRef2.element : i16 != 0 ? ((i14 * i7) - (i13 * i15)) / i16 : (i13 + i14) / 2, this.I, 1.0f, 300L);
        return true;
    }

    @Override // com.pspdfkit.internal.ln
    public final int d() {
        int i = b.a[this.g.ordinal()];
        if (i != 1) {
            if (i == 2) {
                return this.h + (this.I > 1.0f ? r() - u() : 0);
            }
            throw new NoWhenBranchMatchedException();
        }
        float f = this.I;
        if (f < 1.0f) {
            return 0;
        }
        int i2 = this.h;
        return f == 1.0f ? s() + i2 : (r() + i2) - u();
    }

    @Override // com.pspdfkit.internal.ln
    public final int e() {
        int i = b.a[this.g.ordinal()];
        if (i == 1) {
            if (this.I > 1.0f) {
                return -this.K;
            }
            return 0;
        }
        if (i != 2) {
            throw new NoWhenBranchMatchedException();
        }
        float f = this.I;
        if (f < 1.0f) {
            return 0;
        }
        return f == 1.0f ? Math.max(this.a.getScrollY(), 0) : -this.K;
    }

    public final int f(int i, int i2) {
        int i3 = this.g == PageScrollDirection.HORIZONTAL ? (this.h / 2) + i : i2 + (this.i / 2);
        int iA = this.f.a(this.p);
        int length = this.Q.length;
        for (int i4 = 0; i4 < length; i4++) {
            if (i4 != ArraysKt.getLastIndex(this.Q)) {
                int[] iArr = this.Q;
                if (iArr[i4] > i3 || i3 >= iArr[i4 + 1]) {
                }
            }
            iA = i4;
            break;
        }
        return n(iA);
    }

    public final void g(int i, int i2) {
        float f = this.I * 2.5f;
        float f2 = f / (f - 1);
        int i3 = (int) (this.J * f2);
        int i4 = this.h;
        int i5 = i4 - i3;
        int iMax = i3 >= i5 ? i4 / 2 : Math.max(i3, Math.min(i, i5));
        int i6 = (int) (this.K * f2);
        int i7 = this.i;
        int i8 = i7 - i6;
        h().a(iMax, i6 >= i8 ? i7 / 2 : Math.max(i6, Math.min(i2, i8)), this.I, f, 300L);
    }

    @Override // com.pspdfkit.internal.ln
    public final float h(int i) {
        if (u(i)) {
            return this.I;
        }
        return 1.0f;
    }

    @Override // com.pspdfkit.internal.ln
    public final void i(int i) {
        a(i, Math.abs(i - this.p) <= 4);
    }

    public final a k(int i) {
        a aVar;
        boolean z;
        int iB = this.f.b(i);
        if (this.j.getPageBinding() != PageBinding.RIGHT_EDGE) {
            return p(iB);
        }
        int i2 = this.j.s % 2;
        boolean z2 = this.G;
        boolean z3 = false;
        if (i2 == 0) {
            if (z2) {
                aVar = i % 2 == 0 ? a.LEFT : a.RIGHT;
                z = false;
            } else {
                a aVar2 = i % 2 == 1 ? a.LEFT : a.RIGHT;
                boolean z4 = iB == 0;
                z3 = iB == this.a.getPageCount() - 1;
                aVar = aVar2;
                z = z3;
                z3 = z4;
            }
        } else if (z2) {
            a aVar3 = i % 2 == 1 ? a.LEFT : a.RIGHT;
            z = iB == this.a.getPageCount() - 1;
            aVar = aVar3;
        } else {
            aVar = i % 2 == 0 ? a.LEFT : a.RIGHT;
            z = false;
            z3 = iB == 0;
        }
        return (z3 || z) ? a.CENTER_SINGLE : aVar;
    }

    @Override // com.pspdfkit.internal.ln
    public final void l() {
        this.m = false;
        this.P = true;
        n();
    }

    @Override // com.pspdfkit.internal.ln
    public final void m() {
        if (this.e) {
            int size = this.k.size();
            for (int i = 0; i < size; i++) {
                if (p(i) == a.RIGHT) {
                    int i2 = i - 1;
                    Size size2 = (Size) this.k.get(i2);
                    Size size3 = (Size) this.k.get(i);
                    boolean z = (size2.width + size3.width) + ((float) this.H) >= ((float) this.h);
                    float f = size2.height;
                    float f2 = size3.height;
                    boolean z2 = f == f2;
                    if (!z && !z2) {
                        Pair pair = f > f2 ? TuplesKt.to(Integer.valueOf(i2), Integer.valueOf(i)) : TuplesKt.to(Integer.valueOf(i), Integer.valueOf(i2));
                        int iIntValue = ((Number) pair.component1()).intValue();
                        int iIntValue2 = ((Number) pair.component2()).intValue();
                        int i3 = (int) (((this.h - this.H) / 2) - ((Size) this.k.get(iIntValue)).width);
                        Size size4 = (Size) this.k.get(iIntValue2);
                        float f3 = size4.height;
                        float f4 = size4.width;
                        float f5 = f3 / f4;
                        float f6 = f4 + i3;
                        this.k.set(iIntValue2, new Size(f6, f5 * f6));
                    }
                }
            }
        }
    }

    public final int n(int i) {
        return k(i) == a.RIGHT ? i - 1 : i;
    }

    public final int o(int i) {
        return p(i) == a.RIGHT ? i - 1 : i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final a p(int i) {
        int i2 = i % 2;
        boolean z = this.G;
        a aVar = i2 == (!z ? 1 : 0) ? a.LEFT : a.RIGHT;
        boolean z2 = false;
        Object[] objArr = i == 0 && !z;
        if (i == this.a.getPageCount() - 1 && aVar == a.LEFT) {
            z2 = true;
        }
        return (objArr == true || z2) ? a.CENTER_SINGLE : aVar;
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0037 A[RETURN] */
    public final int q() {
        int iO = o(this.p);
        int iE = e(iO);
        if (iE != -1 && this.I > 1.01f) {
            if (this.J <= 0) {
                if (q(iO) <= (this.h / 2) + (-this.J)) {
                    return iE;
                }
            } else if (q(iO) + this.J <= this.h / 2) {
                return iE;
            }
        }
        return iO;
    }

    public final int r(int i) {
        int iA = this.f.a(i);
        boolean zU = u(i);
        int iL = (int) (l(i) * (zU ? this.I : 1.0f));
        return t(iA) + (zU ? this.K : RangesKt.coerceAtLeast((this.i - iL) / 2, 0)) + ((iL - b(i)) / 2);
    }

    public final int s() {
        int i = b.a[this.g.ordinal()];
        if (i == 1) {
            return s(this.j.s - 1);
        }
        if (i == 2) {
            return 0;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final int t() {
        int i = b.a[this.g.ordinal()];
        if (i == 1) {
            return 0;
        }
        if (i == 2) {
            return t(this.j.s - 1);
        }
        throw new NoWhenBranchMatchedException();
    }

    public final int u() {
        return Math.min((int) ((this.h - (m(this.p) * this.I)) - (v(this.p) ? 0 : this.H)), 0);
    }

    public final Point v() {
        int iMax;
        int iMax2;
        int iM = ((int) (m(this.p) * this.I)) + (v(this.p) ? 0 : this.H);
        int iL = (int) (l(this.p) * this.I);
        int i = this.h;
        if (iM <= i) {
            iMax = (i - iM) / 2;
        } else {
            iMax = Math.max(u(), Math.min(this.J, r()));
        }
        int i2 = this.i;
        if (iL <= i2) {
            iMax2 = (i2 - iL) / 2;
        } else {
            iMax2 = Math.max(Math.min((int) (i2 - (l(this.p) * this.I)), 0), Math.min(this.K, Math.max((int) (this.i - (l(this.p) * this.I)), 0)));
        }
        return new Point(iMax, iMax2);
    }

    public final boolean w(int i) {
        return s(i) - this.a.getScrollX() == 0 && t(i) - this.a.getScrollY() == 0;
    }

    public final void x() {
        if (w()) {
            return;
        }
        if (this.I < 1.0f) {
            h().a(this.h / 2.0f, this.i / 2.0f, this.I, 1.0f, 150L);
            return;
        }
        int i = this.J;
        int i2 = this.K;
        Point pointV = v();
        this.M.startScroll(i, i2, pointV.x - i, pointV.y - i2, 0);
        this.a.postInvalidateOnAnimation();
    }

    public final void y() {
        int i;
        int i2 = this.j.s;
        int[] iArr = new int[i2];
        this.Q = iArr;
        int i3 = b.a[this.g.ordinal()];
        int i4 = 2;
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
            if (i2 > 1) {
                if (this.G) {
                    iArr[1] = 0;
                } else {
                    i4 = 1;
                }
                while (i4 < i2) {
                    iArr[i4] = iArr[Math.max(i4 - 2, 0)] + i + this.d;
                    i4++;
                }
            }
        }
        x(this.p);
    }

    @Override // com.pspdfkit.internal.ln
    public final void o() {
        if ((a() && w()) || this.m || this.n) {
            return;
        }
        int iN = n(f(this.a.getScrollX(), this.a.getScrollY()));
        if (!w(iN)) {
            this.L.startScroll(this.a.getScrollX(), this.a.getScrollY(), s(iN) - this.a.getScrollX(), t(iN) - this.a.getScrollY(), 150);
            this.a.postInvalidateOnAnimation();
        }
        x();
    }

    public final int l(int i) {
        float fMax;
        int iO = o(i);
        int iE = e(iO);
        ArrayList arrayList = this.k;
        if (iE != -1) {
            fMax = Math.max(((Size) arrayList.get(iO)).height, ((Size) this.k.get(iE)).height);
        } else {
            fMax = ((Size) arrayList.get(iO)).height;
        }
        return (int) fMax;
    }

    @Override // com.pspdfkit.internal.ln
    public final void a(RectF rectF, int i) {
        int i2;
        int i3;
        int iA = this.f.a(i);
        boolean z = k(iA) == a.RIGHT;
        int iC = c(i) - s(iA);
        int i4 = z ? this.H : 0;
        int iD = d(i) - t(iA);
        float f = iC - i4;
        int i5 = (int) (rectF.left + f);
        int i6 = (int) (rectF.right + f);
        int i7 = this.h;
        int i8 = (i6 - i5) - i7;
        if (i8 != 0) {
            i2 = (0 - (i5 * i7)) / i8;
        } else {
            i2 = (i5 + i6) / 2;
        }
        float f2 = iD;
        int i9 = (int) (rectF.top + f2);
        int i10 = (int) (rectF.bottom + f2);
        int i11 = this.i;
        int i12 = (i10 - i9) - i11;
        if (i12 != 0) {
            i3 = (0 - (i9 * i11)) / i12;
        } else {
            i3 = (i9 + i10) / 2;
        }
        float fWidth = (this.I * i7) / rectF.width();
        h().a(i2 + (z ? this.H / fWidth : 0.0f), i3, this.I, fWidth, 300L);
    }

    public final int s(int i) {
        int i2 = b.a[this.g.ordinal()];
        if (i2 == 1) {
            return this.Q[i];
        }
        if (i2 == 2) {
            return 0;
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.pspdfkit.internal.ln
    public final void p() {
        i();
        y();
    }

    public final int t(int i) {
        int i2 = b.a[this.g.ordinal()];
        if (i2 == 1) {
            return 0;
        }
        if (i2 == 2) {
            return this.Q[i];
        }
        throw new NoWhenBranchMatchedException();
    }

    public final boolean w() {
        int i = this.J;
        int i2 = this.K;
        Point pointV = v();
        return this.I >= 1.0f && !(i != pointV.x || i2 != pointV.y);
    }

    public final boolean u(int i) {
        int i2 = this.p;
        return i == i2 || i == e(i2);
    }

    @Override // com.pspdfkit.internal.ln
    public final int b(int i, int i2) {
        return o(this.f.b(f(i, i2)));
    }

    public final void b(RectF rectF, int i, long j, boolean z) {
        int iA = this.f.a(i);
        RectF rectF2 = new RectF(0.0f, 0.0f, this.h, this.i);
        rectF.offset(c(i) - s(iA), d(i) - t(iA));
        if (z) {
            ff.b(rectF, new RectF(Math.min(this.J, 0), Math.min(this.K, 0), Math.max((int) (m(i) * this.I), this.h), Math.max((int) (l(i) * this.I), this.i)));
        }
        h().a(rectF2, rectF, this.I, j);
    }

    @Override // com.pspdfkit.internal.ln
    public final int d(int i) {
        if (this.g == PageScrollDirection.VERTICAL) {
            int iL = l(i);
            int iO = o(this.p);
            if (i < iO && iO != -1 && iL > this.i) {
                return r(i) - (iL - this.i);
            }
        }
        return r(i);
    }

    public final int q(int i) {
        return (int) (((Size) this.k.get(i)).width * (u(i) ? this.I : 1.0f));
    }

    @Override // com.pspdfkit.internal.ln
    public final int e(int i) {
        if (i == -1) {
            return -1;
        }
        if (p(i) == a.LEFT) {
            return i + 1;
        }
        if (p(i) == a.RIGHT) {
            return i - 1;
        }
        return -1;
    }

    public final int r() {
        return Math.max((int) ((this.h - (m(this.p) * this.I)) - (v(this.p) ? 0 : this.H)), 0);
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0040  */
    /* JADX WARN: Code duplicated, block: B:17:0x0046  */
    /* JADX WARN: Code duplicated, block: B:18:0x005b  */
    /* JADX WARN: Code duplicated, block: B:20:0x0071  */
    /* JADX WARN: Code duplicated, block: B:21:0x0073  */
    /* JADX WARN: Code duplicated, block: B:24:0x0085  */
    /* JADX WARN: Code duplicated, block: B:25:0x0087  */
    /* JADX WARN: Code duplicated, block: B:28:0x008c  */
    /* JADX WARN: Code duplicated, block: B:29:0x008e  */
    @Override // com.pspdfkit.internal.ln
    public final void d(int i, int i2) {
        int i3;
        int i4;
        int iL;
        int i5;
        int i6;
        int i7 = this.g == PageScrollDirection.HORIZONTAL ? i : i2;
        if ((!this.R || i7 >= 0) && (!this.S || i7 <= 0)) {
            if (!w(n(this.f.a(o(this.f.b(f(this.a.getScrollX(), this.a.getScrollY()))))))) {
                if (w()) {
                    this.L.startScroll(this.a.getScrollX(), this.a.getScrollY(), i, i2, 0);
                } else {
                    int iM = (int) (m(this.p) * this.I);
                    if (v(this.p)) {
                        i3 = 0;
                    } else {
                        i3 = this.H;
                    }
                    i4 = iM + i3;
                    iL = (int) (l(this.p) * this.I);
                    if (i4 < this.h) {
                        i5 = 0;
                    } else {
                        i5 = i;
                    }
                    if (iL < this.i) {
                        i6 = 0;
                    } else {
                        i6 = i2;
                    }
                    this.M.startScroll(this.J, this.K, -i5, -i6, 0);
                }
            } else {
                int iM2 = (int) (m(this.p) * this.I);
                if (v(this.p)) {
                    i3 = 0;
                } else {
                    i3 = this.H;
                }
                i4 = iM2 + i3;
                iL = (int) (l(this.p) * this.I);
                if (i4 < this.h) {
                    i5 = 0;
                } else {
                    i5 = i;
                }
                if (iL < this.i) {
                    i6 = 0;
                } else {
                    i6 = i2;
                }
                this.M.startScroll(this.J, this.K, -i5, -i6, 0);
            }
        } else if (w()) {
            this.L.startScroll(this.a.getScrollX(), this.a.getScrollY(), i, i2, 0);
        } else {
            int iM3 = (int) (m(this.p) * this.I);
            if (v(this.p)) {
                i3 = 0;
            } else {
                i3 = this.H;
            }
            i4 = iM3 + i3;
            iL = (int) (l(this.p) * this.I);
            if (i4 < this.h) {
                i5 = 0;
            } else {
                i5 = i;
            }
            if (iL < this.i) {
                i6 = 0;
            } else {
                i6 = i2;
            }
            this.M.startScroll(this.J, this.K, -i5, -i6, 0);
        }
        this.a.postInvalidateOnAnimation();
    }

    @Override // com.pspdfkit.internal.ln
    public final int f() {
        int i = b.a[this.g.ordinal()];
        if (i == 1) {
            int i2 = this.i;
            return i2 + (this.I > 1.0f ? Math.max((int) (i2 - (l(this.p) * this.I)), 0) - Math.min((int) (this.i - (l(this.p) * this.I)), 0) : 0);
        }
        if (i == 2) {
            float f = this.I;
            if (f < 1.0f) {
                return 0;
            }
            int i3 = this.i;
            if (f == 1.0f) {
                return t() + i3;
            }
            return (Math.max((int) (i3 - (l(this.p) * this.I)), 0) + i3) - Math.min((int) (this.i - (l(this.p) * this.I)), 0);
        }
        throw new NoWhenBranchMatchedException();
    }

    public final void x(int i) {
        boolean zU = u(i);
        if (!zU) {
            this.I = 1.0f;
            int iN = n(this.f.a(i));
            int iB = this.f.b(iN);
            int iO = o(i);
            int iE = e(iO);
            if (iE != -1 && b(iO) < b(iE)) {
                iO = iE;
            }
            this.J = c(iB) - s(iN);
            this.K = d(iO) - t(iO);
        }
        int i2 = this.p;
        this.p = i;
        if (zU) {
            return;
        }
        au auVarB = this.a.b(i2);
        if (auVarB != null) {
            b(auVarB);
            a(auVarB);
        }
        au auVarB2 = this.a.b(e(i2));
        if (auVarB2 != null) {
            b(auVarB2);
            a(auVarB2);
        }
    }

    public final boolean v(int i) {
        return e(i) == -1;
    }

    public final int m(int i) {
        int iO = o(i);
        int iE = e(iO);
        ArrayList arrayList = this.k;
        if (iE != -1) {
            return (int) (((Size) arrayList.get(iO)).width + ((Size) this.k.get(iE)).width);
        }
        return (int) ((Size) arrayList.get(iO)).width;
    }

    @Override // com.pspdfkit.internal.ln
    public final void a(final x70 x70Var) {
        x70Var.getClass();
        this.l = x70Var;
        a(x70Var.b, false);
        this.A.add(new Function0() { // from class: com.pspdfkit.internal.xe$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return xe.a(x70Var, this);
            }
        });
    }

    @Override // com.pspdfkit.internal.ln
    public final int b() {
        return this.i;
    }

    @Override // com.pspdfkit.internal.ln
    public final void b(RectF rectF) {
        b(rectF, this.p, 0L, false);
    }

    @Override // com.pspdfkit.internal.ln
    public final int b(int i) {
        return (int) (((Size) this.k.get(i)).height * (u(i) ? this.I : 1.0f));
    }

    @Override // com.pspdfkit.internal.ln
    public final void k() {
        j();
        this.o = false;
        this.n = true;
        this.L.forceFinished(true);
        this.N = this.a.getScrollX();
        this.O = this.a.getScrollY();
        this.M.forceFinished(true);
        boolean z = this.g == PageScrollDirection.HORIZONTAL;
        this.R = !z ? this.K < 0 : this.J < 0;
        int i = this.p;
        if (z) {
            this.S = (((int) (((float) m(i)) * this.I)) + (v(this.p) ? 0 : this.H)) + this.J <= this.h;
        } else {
            this.S = ((int) (((float) l(i)) * this.I)) + this.K <= this.i;
        }
    }

    @Override // com.pspdfkit.internal.ln
    public final Size f(int i) {
        return (Size) this.k.get(i);
    }

    @Override // com.pspdfkit.internal.ln
    public final void b(au auVar) {
        auVar.getClass();
        m40 state = auVar.getState();
        if (state == null) {
            return;
        }
        int i = state.b;
        auVar.measure(View.MeasureSpec.makeMeasureSpec(q(i), 1073741824), View.MeasureSpec.makeMeasureSpec(b(i), 1073741824));
    }

    @Override // com.pspdfkit.internal.ln
    public final void b(RectF rectF, int i, long j) {
        rectF.getClass();
        b(rectF, i, 0L, true);
    }

    @Override // com.pspdfkit.internal.ln
    public final int c(int i) {
        int iCoerceAtLeast;
        int iA = this.f.a(i);
        boolean zU = u(i);
        int iOrdinal = k(iA).ordinal();
        if (iOrdinal != 0) {
            if (iOrdinal == 1) {
                int i2 = iA - 1;
                int iB = this.f.b(i2);
                iCoerceAtLeast = q(iB) + (c(iB) - s(i2)) + this.H;
            } else {
                if (iOrdinal != 2) {
                    throw new NoWhenBranchMatchedException();
                }
                if (zU) {
                    iCoerceAtLeast = this.J;
                } else {
                    iCoerceAtLeast = RangesKt.coerceAtLeast((this.h - q(i)) / 2, 0);
                }
            }
        } else if (zU) {
            iCoerceAtLeast = this.J;
        } else {
            iCoerceAtLeast = RangesKt.coerceAtLeast((int) (((this.h - (m(i) * 1.0f)) - this.H) / 2.0f), 0);
        }
        return s(iA) + iCoerceAtLeast;
    }

    @Override // com.pspdfkit.internal.ln
    public final int c() {
        int i = b.a[this.g.ordinal()];
        if (i != 1) {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            if (this.I > 1.0f) {
                return -this.J;
            }
            return 0;
        }
        float f = this.I;
        if (f < 1.0f) {
            return 0;
        }
        if (f == 1.0f) {
            return Math.max(this.a.getScrollX(), 0);
        }
        return -this.J;
    }

    @Override // com.pspdfkit.internal.ln
    public final boolean a() {
        if ((!this.m || this.P) && this.n) {
            this.P = false;
            this.p = q();
        }
        if (this.L.computeScrollOffset()) {
            int iMax = Math.max(0, Math.min(this.L.getCurrX(), s()));
            int iMax2 = Math.max(0, Math.min(this.L.getCurrY(), t()));
            this.a.scrollTo(iMax, iMax2);
            this.a.f(o(this.f.b(f(iMax, iMax2))));
            return true;
        }
        int iO = o(this.f.b(f(this.a.getScrollX(), this.a.getScrollY())));
        int iN = n(this.f.a(iO));
        int iE = e(iO);
        int i = this.p;
        boolean z = i == iO;
        boolean z2 = iE != -1 && i == iE;
        boolean zW = w(iN);
        if (zW && !z && !z2) {
            x(iO);
            this.a.m();
            this.a.postInvalidateOnAnimation();
            return false;
        }
        this.a.m();
        if (this.M.computeScrollOffset() && (zW || this.m)) {
            boolean z3 = this.m;
            Scroller scroller = this.M;
            if (z3) {
                this.J = scroller.getCurrX();
                this.K = this.M.getCurrY();
            } else {
                this.J = Math.max(u(), Math.min(scroller.getCurrX(), r()));
                this.K = Math.max(Math.min((int) (this.i - (l(this.p) * this.I)), 0), Math.min(this.M.getCurrY(), Math.max((int) (this.i - (l(this.p) * this.I)), 0)));
            }
            au auVarB = this.a.b(this.p);
            if (auVarB != null) {
                a(auVarB);
            }
            au auVarB2 = this.a.b(e(this.p));
            if (auVarB2 != null) {
                a(auVarB2);
            }
            return true;
        }
        if (!this.m && this.P) {
            this.P = false;
            this.p = q();
        }
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:22:0x004e  */
    /* JADX WARN: Code duplicated, block: B:53:0x00f9  */
    /* JADX WARN: Code duplicated, block: B:55:0x0111  */
    /* JADX WARN: Code duplicated, block: B:56:0x0113  */
    /* JADX WARN: Code duplicated, block: B:59:0x0125  */
    /* JADX WARN: Code duplicated, block: B:62:0x012a  */
    @Override // com.pspdfkit.internal.ln
    public final boolean a(int i, int i2, boolean z) {
        int i3;
        int i4;
        int iL;
        if (this.o && !z) {
            return false;
        }
        boolean z2 = this.g == PageScrollDirection.HORIZONTAL;
        int i5 = z2 ? i : i2;
        if ((!this.R || i5 >= 0) && (!this.S || i5 <= 0)) {
            if (!w(n(this.f.a(o(this.f.b(f(this.a.getScrollX(), this.a.getScrollY()))))))) {
                if (!w() && Math.abs(i) >= 2000) {
                    int i6 = this.j.s;
                    int iF = f(this.N, this.O);
                    int iS = z2 ? s(iF) : t(iF);
                    OverScroller overScroller = this.L;
                    int currX = (z2 ? overScroller.getCurrX() : overScroller.getCurrY()) - iS;
                    float f = this.a.getResources().getDisplayMetrics().density;
                    boolean z3 = Math.signum((float) currX) == Math.signum((float) i5);
                    boolean z4 = ((float) Math.abs(currX)) < ((float) 32) * f;
                    if (!z3 || z4) {
                        i5 = 0;
                    }
                    int iMax = Math.max(0, Math.min((((int) Math.signum(i5)) * 2) + iF, i6 - 1));
                    this.L.startScroll(this.a.getScrollX(), this.a.getScrollY(), z2 ? s(iMax) - this.a.getScrollX() : 0, z2 ? 0 : t(iMax) - this.a.getScrollY(), 150);
                } else {
                    this.M.forceFinished(true);
                    int iM = (int) (m(this.p) * this.I);
                    if (v(this.p)) {
                        i3 = 0;
                    } else {
                        i3 = this.H;
                    }
                    i4 = iM + i3;
                    iL = (int) (l(this.p) * this.I);
                    if (i4 < this.h) {
                        i = 0;
                    }
                    if (iL < this.i) {
                        i2 = 0;
                    }
                    Scroller scroller = this.M;
                    int i7 = this.J;
                    int i8 = this.K;
                    scroller.getClass();
                    scroller.fling(i7, i8, -i, -i2, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
                }
            } else {
                this.M.forceFinished(true);
                int iM2 = (int) (m(this.p) * this.I);
                if (v(this.p)) {
                    i3 = 0;
                } else {
                    i3 = this.H;
                }
                i4 = iM2 + i3;
                iL = (int) (l(this.p) * this.I);
                if (i4 < this.h) {
                    i = 0;
                }
                if (iL < this.i) {
                    i2 = 0;
                }
                Scroller scroller2 = this.M;
                int i9 = this.J;
                int i10 = this.K;
                scroller2.getClass();
                scroller2.fling(i9, i10, -i, -i2, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
            }
        } else if (!w()) {
            this.M.forceFinished(true);
            int iM3 = (int) (m(this.p) * this.I);
            if (v(this.p)) {
                i3 = 0;
            } else {
                i3 = this.H;
            }
            i4 = iM3 + i3;
            iL = (int) (l(this.p) * this.I);
            if (i4 < this.h) {
                i = 0;
            }
            if (iL < this.i) {
                i2 = 0;
            }
            Scroller scroller3 = this.M;
            int i11 = this.J;
            int i12 = this.K;
            scroller3.getClass();
            scroller3.fling(i11, i12, -i, -i2, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
        } else {
            this.M.forceFinished(true);
            int iM4 = (int) (m(this.p) * this.I);
            if (v(this.p)) {
                i3 = 0;
            } else {
                i3 = this.H;
            }
            i4 = iM4 + i3;
            iL = (int) (l(this.p) * this.I);
            if (i4 < this.h) {
                i = 0;
            }
            if (iL < this.i) {
                i2 = 0;
            }
            Scroller scroller4 = this.M;
            int i13 = this.J;
            int i14 = this.K;
            scroller4.getClass();
            scroller4.fling(i13, i14, -i, -i2, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }
        this.a.postInvalidateOnAnimation();
        return true;
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
    public final void a(final RectF rectF, final int i, final long j) {
        long j2;
        rectF.getClass();
        int iE = e(this.p);
        if (this.p == i || i == iE) {
            j2 = 0;
        } else {
            a(i, false);
            j2 = 500;
        }
        this.a.postDelayed(new Runnable() { // from class: com.pspdfkit.internal.xe$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                xe.a(rectF, this, i, j);
            }
        }, j2);
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
        auVar.layout(iC, iD, q(i) + iC, b(i) + iD);
    }

    @Override // com.pspdfkit.internal.ln
    public final void a(int i, boolean z) {
        x(i);
        int iN = n(this.f.a(i));
        if (!w(iN)) {
            int currX = this.L.getCurrX();
            int currY = this.L.getCurrY();
            this.L.startScroll(currX, currY, Math.max(0, Math.min(s(iN), s())) - currX, Math.max(0, Math.min(t(iN), t())) - currY, z ? 150 : 0);
            DocumentView documentView = this.a;
            if (z) {
                documentView.postInvalidateOnAnimation();
                return;
            } else {
                documentView.invalidate();
                return;
            }
        }
        x();
    }

    @Override // com.pspdfkit.internal.ln
    public final void a(boolean z) {
        super.a(z);
        if (z) {
            this.m = h().k;
            this.n = false;
            this.P = true;
            n();
        }
    }

    public static final Unit a(xe xeVar, Ref.IntRef intRef, Ref.IntRef intRef2) {
        xeVar.g(intRef.element, intRef2.element);
        return Unit.INSTANCE;
    }

    @Override // com.pspdfkit.internal.ln
    public final boolean a(float f, float f2, float f3) {
        float fMax = Math.max(this.b, Math.min(f * this.I, this.c));
        if (fMax == this.I) {
            return true;
        }
        this.I = fMax;
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
        au auVarB2 = this.a.b(e(this.p));
        if (auVarB2 != null) {
            b(auVarB2);
            a(auVarB2);
            this.a.postInvalidateOnAnimation();
        }
        this.M.startScroll(this.J, this.K, iA, i, 0);
        return true;
    }

    @Override // com.pspdfkit.internal.ln
    public final void a(int i, int i2, int i3, float f, long j) {
        a(i, i2, i3, this.I * f, j, 500L);
    }

    @Override // com.pspdfkit.internal.ln
    public final void a(final int i, final int i2, final int i3, final float f, final long j, long j2) {
        long j3;
        if (u(i3)) {
            j3 = 0;
        } else {
            a(i3, false);
            j3 = j2;
        }
        this.a.postDelayed(new Runnable() { // from class: com.pspdfkit.internal.xe$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                xe.a(i, i2, this, i3, f, j);
            }
        }, j3);
    }

    public static final void a(int i, int i2, xe xeVar, int i3, float f, long j) {
        PointF pointF = new PointF(i, i2);
        s60.a(pointF, xeVar.a(i3, (Matrix) null));
        float f2 = f / xeVar.I;
        float f3 = xeVar.h / f2;
        float f4 = xeVar.i / f2;
        float f5 = pointF.x;
        float f6 = 2;
        float f7 = f3 / f6;
        float f8 = pointF.y;
        float f9 = f4 / f6;
        xeVar.b(new RectF(f5 - f7, f8 - f9, f5 + f7, f8 + f9), i3, j, true);
    }

    public static final void a(RectF rectF, xe xeVar, int i, long j) {
        RectF rectF2 = new RectF();
        Matrix matrixA = xeVar.a(i, (Matrix) null);
        rectF2.set(rectF);
        matrixA.mapRect(rectF2);
        xeVar.b(rectF2, i, j, true);
    }

    @Override // com.pspdfkit.internal.ln
    public final void a(int i, int i2, int i3) {
        this.M.startScroll(this.J, this.K, (this.h / 2) + (-i), (this.i / 2) + (-i2), i3);
        this.a.postInvalidateOnAnimation();
    }

    @Override // com.pspdfkit.internal.ln
    public final void a(RectF rectF, int i, long j, boolean z) {
        rectF.getClass();
        RectF rectF2 = new RectF(rectF);
        a(i, (Matrix) null).mapRect(rectF2);
        RectF rectFG = g(i);
        if (!z && u(i) && rectFG.contains(rectF2)) {
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
        int i = this.p;
        int iL = (int) (l(i) * this.I);
        int iM = (int) (m(i) * this.I);
        float f3 = iL;
        float fHeight = rectF.height();
        float f4 = rectF2.top;
        if (f3 < fHeight) {
            f = -(((rectF.height() - f3) / 2) + f4);
        } else {
            f = -Math.min(f4, Math.max(rectF.bottom - f3, 0.0f));
        }
        float f5 = iM;
        float fWidth = rectF.width();
        float f6 = rectF2.left;
        if (f5 < fWidth) {
            f2 = -(((rectF.width() - f5) / 2) + f6);
        } else {
            f2 = -Math.min(f6, Math.max(rectF.right - f5, 0.0f));
        }
        rectF2.offset(f2, f);
        return rectF2;
    }

    public static final Unit a(x70 x70Var, xe xeVar) {
        xe xeVar2;
        float f = x70Var.c;
        xeVar.getClass();
        if (f == 1.0f) {
            xeVar2 = xeVar;
        } else {
            RectF rectF = x70Var.a;
            PointF pointF = new PointF(rectF.centerX(), rectF.centerY());
            s60.a(pointF, xeVar.a(x70Var.b, (Matrix) null));
            float f2 = xeVar.h;
            float f3 = x70Var.c;
            float f4 = xeVar.i / f3;
            float f5 = pointF.x;
            float f6 = 2;
            float f7 = (f2 / f3) / f6;
            float f8 = pointF.y;
            float f9 = f4 / f6;
            xeVar2 = xeVar;
            xeVar2.b(xeVar.a(new RectF(f5 - f7, f8 - f9, f5 + f7, f8 + f9)), xeVar.p, 0L, false);
        }
        if (xeVar2.l == x70Var) {
            xeVar2.l = null;
            xeVar2.a.o();
        }
        return Unit.INSTANCE;
    }

    @Override // com.pspdfkit.internal.ln
    public final void a(int i, int i2) {
        this.J = (i / 2) + this.J;
        this.K = (i2 / 2) + this.K;
    }
}
