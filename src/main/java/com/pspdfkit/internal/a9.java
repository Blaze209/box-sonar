package com.pspdfkit.internal;

import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.ranges.IntProgression;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes3.dex */
public final class a9 {
    public static final Path a(ArrayList arrayList, float f, Path path, boolean z) {
        float f2;
        arrayList.getClass();
        Path path2 = path == null ? new Path() : path;
        path2.reset();
        float f3 = 4.25f * f;
        float f4 = 1.75f * f3;
        int i = 0;
        int i2 = 1;
        boolean z2 = z && arrayList.size() >= 3;
        if (arrayList.isEmpty()) {
            f2 = 0.0f;
        } else {
            PointF pointF = (PointF) arrayList.get(0);
            int size = arrayList.size() + 1;
            int i3 = 1;
            f2 = 0.0f;
            while (i3 < size) {
                PointF pointF2 = (PointF) (i3 == arrayList.size() ? arrayList.get(0) : arrayList.get(i3));
                f2 += (pointF.x * pointF2.y) - (pointF.y * pointF2.x);
                i3++;
                pointF = pointF2;
            }
        }
        boolean z3 = f2 >= 0.0f;
        ArrayList arrayList2 = new ArrayList();
        int size2 = z2 ? arrayList.size() + 1 : arrayList.size();
        while (i2 < size2) {
            PointF pointF3 = (PointF) arrayList.get(i2 - 1);
            PointF pointF4 = (PointF) (i2 == arrayList.size() ? arrayList.get(i) : arrayList.get(i2));
            if (!a(pointF3, pointF4)) {
                int iSqrt = (int) (((float) Math.sqrt(ip.a(pointF3.x, pointF3.y, pointF4.x, pointF4.y))) / f4);
                float f5 = pointF4.x;
                float f6 = pointF3.x;
                float f7 = iSqrt + 1;
                float f8 = (f5 - f6) / f7;
                float f9 = pointF4.y;
                float f10 = pointF3.y;
                float f11 = (f9 - f10) / f7;
                int i4 = iSqrt + 2;
                for (int i5 = i; i5 < i4; i5++) {
                    arrayList2.add(new PointF(f6, f10));
                    f6 += f8;
                    f10 += f11;
                }
            }
            i2++;
            i = 0;
        }
        return a(arrayList2, f3, z3, z2, path2);
    }

    public static final Path a(ArrayList arrayList, float f, boolean z, boolean z2, Path path) {
        float f2;
        int i;
        float fAbs;
        IntProgression intProgressionReversed;
        int i2;
        boolean z3;
        int i3;
        ArrayList arrayList2 = arrayList;
        float f3 = f;
        int size = arrayList2.size();
        if (size >= 2) {
            PointF pointF = (PointF) CollectionsKt.last((List) arrayList2);
            int i4 = 0;
            while (i4 < size) {
                PointF pointF2 = (PointF) arrayList2.get(i4);
                if (a(pointF2, pointF)) {
                    i4++;
                } else {
                    PointF pointF3 = (PointF) arrayList2.get((i4 + 1) % size);
                    int i5 = i4;
                    while (a(pointF2, pointF3)) {
                        int i6 = i5 + 1;
                        if (i4 != i6 % size) {
                            PointF pointF4 = (PointF) arrayList2.get((i5 + 2) % size);
                            i5 = i6;
                            pointF3 = pointF4;
                        }
                    }
                    if (z2 || !(a(pointF2, (PointF) CollectionsKt.first((List) arrayList2)) || a(pointF2, (PointF) CollectionsKt.last((List) arrayList2)))) {
                        float fA = a(pointF2, pointF, f3, z);
                        float fA2 = a(pointF2, pointF3, f3, !z);
                        if (Float.isNaN(fA) && Float.isNaN(fA2)) {
                            i4 = i5 + 1;
                            path.lineTo(pointF3.x, pointF3.y);
                        } else {
                            if (Float.isNaN(fA)) {
                                fA = fA2 + 3.1415927f;
                            }
                            if (Float.isNaN(fA2)) {
                                fA2 = fA + 3.1415927f;
                            }
                            float f4 = z ? fA : fA2;
                            float f5 = fA - fA2;
                            if (z) {
                                f2 = f5 > 0.0f ? (6.2831855f - fA) + fA2 : fA2 - fA;
                            } else {
                                f2 = f5 > 0.0f ? f5 : (6.2831855f - fA2) + fA;
                            }
                            float f6 = f2 + 0.3f;
                            if (!z) {
                                if (Math.abs(f6) <= 1.5707964f) {
                                    fAbs = f6;
                                } else {
                                    fAbs = f6 / (Math.abs(f6) <= 1.5707964f ? 1 : (int) (Math.abs(f6) / 1.5707964f));
                                }
                                boolean z4 = fAbs > 0.0f;
                                float f7 = fAbs / 2.0f;
                                int iAbs = Math.abs(f6) <= 1.5707964f ? 1 : (int) (Math.abs(f6) / 1.5707964f);
                                PointF pointF5 = pointF2;
                                double d = f7;
                                float fAbs2 = (float) Math.abs(((((double) 1.0f) - Math.cos(d)) * ((double) 1.3333334f)) / Math.sin(d));
                                if (z) {
                                    intProgressionReversed = RangesKt.until(0, iAbs);
                                } else {
                                    intProgressionReversed = RangesKt.reversed(RangesKt.until(0, iAbs));
                                }
                                int first = intProgressionReversed.getFirst();
                                int last = intProgressionReversed.getLast();
                                int step = intProgressionReversed.getStep();
                                if ((step > 0 && first <= last) || (step < 0 && last <= first)) {
                                    int i7 = first;
                                    boolean z5 = true;
                                    while (true) {
                                        i = i5;
                                        double d2 = (i7 * fAbs) + f4;
                                        float fCos = (float) Math.cos(d2);
                                        double d3 = ((i7 + 1) * fAbs) + f4;
                                        float fCos2 = (float) Math.cos(d3);
                                        float fSin = (float) Math.sin(d2);
                                        float fSin2 = (float) Math.sin(d3);
                                        pointF2 = pointF5;
                                        float f8 = pointF2.x;
                                        float f9 = (f * fCos) + f8;
                                        float f10 = pointF2.y;
                                        float f11 = (f * fSin) + f10;
                                        float f12 = fAbs2 * fSin;
                                        float f13 = ((z4 ? fCos - f12 : f12 + fCos) * f) + f8;
                                        float f14 = fCos * fAbs2;
                                        float f15 = z4 ? ((f14 + fSin) * f) + f10 : ((fSin - f14) * f) + f10;
                                        float f16 = fAbs2 * fSin2;
                                        float f17 = ((z4 ? f16 + fCos2 : fCos2 - f16) * f) + f8;
                                        float f18 = fAbs2 * fCos2;
                                        float f19 = ((z4 ? fSin2 - f18 : f18 + fSin2) * f) + f10;
                                        float f20 = (fCos2 * f) + f8;
                                        float f21 = (fSin2 * f) + f10;
                                        if (z) {
                                            if (z5) {
                                                if (path.isEmpty()) {
                                                    path.moveTo(f9, f11);
                                                } else {
                                                    path.lineTo(f9, f11);
                                                }
                                                i2 = last;
                                                z3 = false;
                                            } else {
                                                i2 = last;
                                                z3 = z5;
                                            }
                                            i3 = i7;
                                            path.cubicTo(f13, f15, f17, f19, f20, f21);
                                        } else {
                                            i2 = last;
                                            float f22 = f15;
                                            int i8 = i7;
                                            if (z5) {
                                                if (path.isEmpty()) {
                                                    path.moveTo(f20, f21);
                                                } else {
                                                    path.lineTo(f20, f21);
                                                }
                                                z3 = false;
                                            } else {
                                                z3 = z5;
                                            }
                                            i3 = i8;
                                            path.cubicTo(f17, f19, f13, f22, f9, f11);
                                        }
                                        z5 = z3;
                                        if (i3 == i2) {
                                            break;
                                        }
                                        i7 = i3 + step;
                                        last = i2;
                                        pointF5 = pointF2;
                                        i5 = i;
                                    }
                                } else {
                                    i = i5;
                                    pointF2 = pointF5;
                                }
                            } else {
                                i = i5;
                                float f23 = pointF2.x;
                                float f24 = pointF2.y;
                                path.arcTo(new RectF(f23 - f, f24 - f, f23 + f, f24 + f), (float) Math.toDegrees(f4), (float) Math.toDegrees(f6));
                            }
                            i4 = i + 1;
                            arrayList2 = arrayList;
                            f3 = f;
                            pointF = pointF2;
                        }
                    } else {
                        i = i5;
                        i4 = i + 1;
                        arrayList2 = arrayList;
                        f3 = f;
                        pointF = pointF2;
                    }
                }
            }
            if (z2 && size >= 3) {
                path.close();
            }
        }
        return path;
    }

    public static final float a(PointF pointF, PointF pointF2, float f, boolean z) {
        float f2 = pointF.x - pointF2.x;
        float f3 = pointF.y - pointF2.y;
        double dAcos = Math.acos((Math.sqrt((f3 * f3) + (f2 * f2)) * ((double) 0.5f)) / ((double) f));
        double dAtan2 = Math.atan2(pointF2.y - pointF.y, pointF2.x - pointF.x);
        if (dAtan2 < 0.0d) {
            dAtan2 += (double) 6.2831855f;
        }
        return (float) (z ? dAtan2 + dAcos : dAtan2 - dAcos);
    }

    public static boolean a(PointF pointF, PointF pointF2) {
        return Math.abs(pointF.x - pointF2.x) <= 0.01f && Math.abs(pointF.y - pointF2.y) <= 0.01f;
    }
}
