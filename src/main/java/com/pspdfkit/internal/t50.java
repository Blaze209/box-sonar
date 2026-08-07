package com.pspdfkit.internal;

import com.pspdfkit.utils.PdfLog;
import java.util.List;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.IntRange;

/* JADX INFO: loaded from: classes3.dex */
public final class t50 {
    public i50 a;
    public float b;
    public boolean c = true;
    public int[] d = new int[0];
    public a[] e = new a[0];
    public IntRange[] f;
    public int g;

    public static final class a {
        public final int a;

        public a(int i, int i2, int i3, int i4) {
            this.a = (-(i + i3)) + i2 + i4;
        }
    }

    public t50(i50 i50Var, float f) {
        this.a = i50Var;
        this.b = f;
    }

    public final int a(int i) {
        if (this.c) {
            b();
        }
        return this.d[i];
    }

    public final a b(int i) {
        if (this.c) {
            b();
        }
        return this.e[i];
    }

    public final int c(int i) {
        if (this.c) {
            b();
        }
        IntRange[] intRangeArr = this.f;
        IntRange[] intRangeArr2 = null;
        if (intRangeArr == null) {
            Intrinsics.throwUninitializedPropertyAccessException("lineStarts");
            intRangeArr = null;
        }
        int last = ((IntRange) ArraysKt.last(intRangeArr)).getLast();
        IntRange[] intRangeArr3 = this.f;
        if (i > last) {
            if (intRangeArr3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("lineStarts");
            } else {
                intRangeArr2 = intRangeArr3;
            }
            return ArraysKt.getLastIndex(intRangeArr2);
        }
        if (intRangeArr3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("lineStarts");
        } else {
            intRangeArr2 = intRangeArr3;
        }
        int length = intRangeArr2.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (intRangeArr2[i2].contains(i)) {
                return i2;
            }
        }
        return -1;
    }

    public final a[] a() {
        int i = this.g + 1;
        this.g = i;
        int i2 = 0;
        PdfLog.d("Nutri.TextMetrics", "calculateHeightMetrics " + i + " " + this, new Object[0]);
        int size = this.a.e.f.a.size();
        if (size == 0) {
            this.f = new IntRange[0];
            return new a[0];
        }
        if (size != 1) {
            qn qnVarC = this.a.c(0);
            int size2 = this.a.e.f.a.size();
            IntRange[] intRangeArr = new IntRange[size2];
            for (int i3 = 0; i3 < size2; i3++) {
                intRangeArr[i3] = new IntRange(0, 0);
            }
            this.f = intRangeArr;
            int size3 = this.a.e.f.a.size();
            a[] aVarArr = new a[size3];
            int iIntValue = 0;
            float f = 0.0f;
            while (i2 < size3) {
                IntRange[] intRangeArr2 = this.f;
                if (intRangeArr2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("lineStarts");
                    intRangeArr2 = null;
                }
                intRangeArr2[i2] = new IntRange(iIntValue, (((Number) qnVarC.d.getValue()).intValue() + iIntValue) - 1);
                int i4 = i2 + 1;
                qn qnVar = (qn) CollectionsKt.getOrNull(this.a.e.f.a, i4);
                float f2 = qnVar != null ? (qnVar.g - qnVarC.h) / 2.0f : 0.0f;
                float f3 = this.b;
                a aVar = new a(MathKt.roundToInt((-qnVarC.b.b) * f3), MathKt.roundToInt(qnVarC.b.a * f3), MathKt.roundToInt((-f) * f3), MathKt.roundToInt(f3 * f2));
                iIntValue += ((Number) qnVarC.d.getValue()).intValue();
                if (qnVar != null) {
                    qnVarC = qnVar;
                    f = f2;
                }
                aVarArr[i2] = aVar;
                i2 = i4;
            }
            return aVarArr;
        }
        this.f = new IntRange[]{new IntRange(0, ((String) this.a.e.i.getValue()).length() - 1)};
        qn qnVarC2 = this.a.c(0);
        float f4 = this.b;
        return new a[]{new a(MathKt.roundToInt((-qnVarC2.b.b) * f4), MathKt.roundToInt(qnVarC2.b.a * f4), MathKt.roundToInt((-0.0f) * f4), MathKt.roundToInt(f4 * 0.0f))};
    }

    public final void b() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.c = false;
        this.e = a();
        int length = ((String) this.a.e.i.getValue()).length();
        int[] iArr = this.d;
        if (iArr.length < length) {
            iArr = new int[length * 2];
        }
        this.d = iArr;
        int length2 = 0;
        for (qn qnVar : this.a.e.f.a) {
            uf ufVar = (uf) CollectionsKt.firstOrNull((List) qnVar.a);
            if (ufVar != null) {
                int iRoundToInt = MathKt.roundToInt(ufVar.b.a * this.b);
                for (uf ufVar2 : qnVar.a) {
                    int iRoundToInt2 = MathKt.roundToInt((ufVar2.b.a + ufVar2.c.a) * this.b);
                    this.d[length2] = iRoundToInt2 - iRoundToInt;
                    int length3 = ufVar2.d.length();
                    for (int i = 1; i < length3; i++) {
                        this.d[length2 + i] = 0;
                    }
                    length2 += ufVar2.d.length();
                    iRoundToInt = iRoundToInt2;
                }
            }
        }
        PdfLog.d("Nutri.TextMetrics", "TextMetrics width calculation took " + (System.currentTimeMillis() - jCurrentTimeMillis) + " ms", new Object[0]);
    }
}
