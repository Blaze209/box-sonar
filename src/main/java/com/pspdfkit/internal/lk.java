package com.pspdfkit.internal;

import android.graphics.Path;
import android.graphics.PointF;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function4;

/* JADX INFO: loaded from: classes3.dex */
public final class lk {
    @JvmStatic
    public static final void a(final Path path, List<? extends PointF> list) {
        int i;
        double[] dArr;
        float f;
        float f2;
        path.getClass();
        list.getClass();
        if (list.size() < 2) {
            throw new IllegalArgumentException("Error building spline for ink annotation. At least two knot points required.");
        }
        int i2 = 0;
        PointF pointF = list.get(0);
        path.moveTo(pointF.x, pointF.y);
        Function4 function4 = new Function4() { // from class: com.pspdfkit.internal.lk$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return lk.a(path, (PointF) obj, (PointF) obj2, (PointF) obj3, (PointF) obj4);
            }
        };
        if (list.size() < 2) {
            throw new IllegalArgumentException("Error building spline for ink annotation. At least two knot points required.");
        }
        int size = list.size();
        int i3 = size - 1;
        if (i3 == 1) {
            float f3 = 2;
            float f4 = ((list.get(0).x * f3) + list.get(1).x) / 3.0f;
            float f5 = ((list.get(0).y * f3) + list.get(1).y) / 3.0f;
            function4.invoke(list.get(0), new PointF(f4, f5), new PointF((f3 * f4) - list.get(0).x, (f3 * f5) - list.get(0).y), list.get(1));
            return;
        }
        double[] dArr2 = new double[i3];
        double[] dArr3 = new double[i3];
        int i4 = size - 2;
        int i5 = 1;
        while (true) {
            i = 4;
            if (i5 >= i4) {
                break;
            }
            int i6 = i5 + 1;
            dArr2[i5] = (2 * list.get(i6).x) + (4 * list.get(i5).x);
            i5 = i6;
        }
        float f6 = 2;
        dArr2[0] = (list.get(1).x * f6) + list.get(0).x;
        float f7 = 8;
        double d = 2.0d;
        dArr2[i4] = ((double) ((list.get(i4).x * f7) + list.get(i3).x)) / 2.0d;
        double[] dArrA = a(dArr2, dArr3);
        int i7 = 1;
        while (i7 < i4) {
            int i8 = i7 + 1;
            dArr2[i7] = (list.get(i8).y * f6) + (i * list.get(i7).y);
            function4 = function4;
            i7 = i8;
            d = d;
            i = 4;
        }
        double d2 = d;
        Function4 function5 = function4;
        dArr2[0] = (list.get(1).y * f6) + list.get(0).y;
        dArr2[i4] = ((double) ((f7 * list.get(i4).y) + list.get(i3).y)) / d2;
        double[] dArrA2 = a(dArr2, dArr3);
        while (i2 < i3) {
            float f8 = (float) dArrA[i2];
            float f9 = (float) dArrA2[i2];
            if (i2 < i4) {
                int i9 = i2 + 1;
                f2 = (float) (((double) (list.get(i9).x * f6)) - dArrA[i9]);
                f = (float) (((double) (list.get(i9).y * f6)) - dArrA2[i9]);
                dArr = dArrA2;
            } else {
                double d3 = 2;
                float f10 = (float) ((((double) list.get(i3).x) + dArrA[i4]) / d3);
                dArr = dArrA2;
                f = (float) ((((double) list.get(i3).y) + dArr[i4]) / d3);
                f2 = f10;
            }
            int i10 = i2 + 1;
            function5.invoke(list.get(i2), new PointF(f8, f9), new PointF(f2, f), list.get(i10));
            i2 = i10;
            dArrA2 = dArr;
            i3 = i3;
        }
    }

    public static final Unit a(Path path, PointF pointF, PointF pointF2, PointF pointF3, PointF pointF4) {
        pointF.getClass();
        pointF2.getClass();
        pointF3.getClass();
        pointF4.getClass();
        path.cubicTo(pointF2.x, pointF2.y, pointF3.x, pointF3.y, pointF4.x, pointF4.y);
        return Unit.INSTANCE;
    }

    public static double[] a(double[] dArr, double[] dArr2) {
        int length = dArr.length;
        double[] dArr3 = new double[length];
        double d = 2.0d;
        dArr3[0] = dArr[0] / 2.0d;
        int i = 1;
        while (i < length) {
            double d2 = ((double) 1) / d;
            dArr2[i] = d2;
            d = (i < length + (-1) ? 4.0d : 3.5d) - d2;
            dArr3[i] = (dArr[i] - dArr3[i - 1]) / d;
            i++;
        }
        for (int i2 = 1; i2 < length; i2++) {
            int i3 = length - i2;
            int i4 = i3 - 1;
            dArr3[i4] = dArr3[i4] - (dArr2[i3] * dArr3[i3]);
        }
        return dArr3;
    }
}
