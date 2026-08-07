package com.pspdfkit.internal;

import android.graphics.PointF;
import android.graphics.RectF;
import com.pspdfkit.utils.Size;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class ip {
    public static float a(float f, float f2, float f3, float f4) {
        float f5 = f - f3;
        float f6 = f2 - f4;
        return (f6 * f6) + (f5 * f5);
    }

    public static boolean a(float f, float f2) {
        return Math.abs(f - f2) < 1.0E-8f;
    }

    public static boolean b(float f, float f2) {
        return f >= 0.0f && f <= f2;
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0058  */
    public static RectF a(List<RectF> list) {
        if (list.isEmpty()) {
            throw new IllegalArgumentException("List of rects may not be empty.");
        }
        RectF rectF = new RectF(list.get(0));
        for (int i = 1; i < list.size(); i++) {
            RectF rectF2 = list.get(i);
            float f = rectF2.left;
            float f2 = rectF2.right;
            if (f < f2) {
                float f3 = rectF2.bottom;
                float f4 = rectF2.top;
                if (f3 < f4) {
                    float f5 = rectF.left;
                    float f6 = rectF.right;
                    if (f5 < f6) {
                        float f7 = rectF.bottom;
                        float f8 = rectF.top;
                        if (f7 < f8) {
                            if (f5 > f) {
                                rectF.left = f;
                            }
                            if (f8 < f4) {
                                rectF.top = f4;
                            }
                            if (f6 < f2) {
                                rectF.right = f2;
                            }
                            if (f7 > f3) {
                                rectF.bottom = f3;
                            }
                        } else {
                            rectF.left = f;
                            rectF.top = f4;
                            rectF.right = f2;
                            rectF.bottom = f3;
                        }
                    } else {
                        rectF.left = f;
                        rectF.top = f4;
                        rectF.right = f2;
                        rectF.bottom = f3;
                    }
                }
            }
        }
        return rectF;
    }

    public static float b(float... fArr) {
        float f = Float.MAX_VALUE;
        for (float f2 : fArr) {
            if (f2 < f) {
                f = f2;
            }
        }
        return f;
    }

    public static Size b(Size size, float f) {
        double radians = Math.toRadians(f);
        return new Size((float) (Math.abs(Math.sin(radians) * ((double) size.height)) + Math.abs(Math.cos(radians) * ((double) size.width))), (float) (Math.abs(Math.cos(radians) * ((double) size.height)) + Math.abs(Math.sin(radians) * ((double) size.width))));
    }

    public static float a(PointF pointF, RectF rectF) {
        float fMin = Math.min(Math.abs(pointF.x - rectF.left), Math.abs(pointF.x - rectF.right));
        float fMin2 = Math.min(Math.abs(pointF.y - rectF.top), Math.abs(pointF.y - rectF.bottom));
        if (rectF.contains(pointF.x, pointF.y)) {
            return Math.min(fMin, fMin2);
        }
        float f = pointF.x;
        if (f <= rectF.right && f >= rectF.left) {
            return fMin2;
        }
        float f2 = pointF.y;
        if (f2 > rectF.top && f2 < rectF.bottom) {
            return fMin;
        }
        return (float) Math.sqrt((fMin2 * fMin2) + (fMin * fMin));
    }

    public static PointF a(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8) {
        PointF pointF = new PointF();
        float f9 = f - f3;
        float f10 = f6 - f8;
        float f11 = f2 - f4;
        float f12 = f5 - f7;
        float f13 = (f9 * f10) - (f11 * f12);
        float f14 = (f * f4) - (f2 * f3);
        float f15 = (f5 * f8) - (f6 * f7);
        pointF.x = ((f12 * f14) - (f9 * f15)) / f13;
        pointF.y = ((f14 * f10) - (f11 * f15)) / f13;
        return pointF;
    }

    public static float a(float... fArr) {
        float f = Float.MIN_VALUE;
        for (float f2 : fArr) {
            if (f2 > f) {
                f = f2;
            }
        }
        return f;
    }

    public static int a(int... iArr) {
        int i = Integer.MIN_VALUE;
        for (int i2 : iArr) {
            if (i2 > i) {
                i = i2;
            }
        }
        return i;
    }

    public static ArrayList a(Size size, float f) {
        double radians = Math.toRadians(f);
        double dSqrt = Math.sqrt(Math.pow(((double) size.height) / 2.0d, 2.0d) + Math.pow(((double) size.width) / 2.0d, 2.0d));
        double dAtan2 = Math.atan2(((double) size.height) / 2.0d, ((double) size.width) / 2.0d);
        double d = (radians - 3.141592653589793d) + dAtan2;
        float fCos = (float) (Math.cos(d) * dSqrt);
        float fSin = (float) (Math.sin(d) * dSqrt);
        double d2 = radians - dAtan2;
        float fCos2 = (float) (Math.cos(d2) * dSqrt);
        float fSin2 = (float) (Math.sin(d2) * dSqrt);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new PointF(fCos, fSin));
        arrayList.add(new PointF(fCos2, fSin2));
        arrayList.add(new PointF(-fCos, -fSin));
        arrayList.add(new PointF(-fCos2, -fSin2));
        return arrayList;
    }
}
