package com.pspdfkit.internal;

import android.graphics.PointF;
import android.graphics.RectF;

/* JADX INFO: loaded from: classes3.dex */
public final class ui {
    public static boolean a(PointF pointF, PointF pointF2, float f, PointF pointF3, PointF pointF4, float f2) {
        pointF.getClass();
        pointF2.getClass();
        float f3 = pointF.x;
        float f4 = pointF2.x;
        float f5 = pointF3.x;
        float f6 = pointF4.x;
        float f7 = pointF.y;
        float f8 = pointF2.y;
        float f9 = pointF3.y;
        float f10 = pointF4.y;
        float f11 = f + f2;
        float f12 = f3 - f4;
        float f13 = f9 - f10;
        float f14 = f7 - f8;
        float f15 = f5 - f6;
        float f16 = (f12 * f13) - (f14 * f15);
        if (Math.abs(f16) < 1.0E-5f) {
            return false;
        }
        float f17 = (f3 * f8) - (f7 * f4);
        float f18 = (f5 * f10) - (f9 * f6);
        float f19 = ((f15 * f17) - (f12 * f18)) / f16;
        float f20 = ((f17 * f13) - (f14 * f18)) / f16;
        return f19 >= Math.min(f3, f4) - f11 && f19 <= Math.max(f3, f4) + f11 && f19 >= Math.min(f5, f6) - f11 && f19 <= Math.max(f5, f6) + f11 && f20 >= Math.min(f7, f8) - f11 && f20 <= Math.max(f7, f8) + f11 && f20 >= Math.min(f9, f10) - f11 && f20 <= Math.max(f9, f10) + f11;
    }

    public static boolean a(RectF rectF, float f, PointF pointF, PointF pointF2) {
        float f2 = f + 1.0f;
        if (rectF.width() == 0.0f || rectF.top - rectF.bottom == 0.0f || (pointF.x == pointF2.x && pointF.y == pointF2.y)) {
            return false;
        }
        PointF pointF3 = new PointF(rectF.centerX(), rectF.centerY());
        PointF pointF4 = new PointF(pointF.x - pointF3.x, pointF.y - pointF3.y);
        PointF pointF5 = new PointF(pointF2.x - pointF3.x, pointF2.y - pointF3.y);
        float f3 = f / 2.0f;
        float fWidth = (rectF.width() + f3) / 2.0f;
        float f4 = ((rectF.top - rectF.bottom) + f3) / 2.0f;
        double d = 2;
        float fPow = ((((float) Math.pow(pointF5.y - pointF4.y, d)) / f4) / f4) + ((((float) Math.pow(pointF5.x - pointF4.x, d)) / fWidth) / fWidth);
        float f5 = pointF4.x;
        float f6 = (((pointF5.x - f5) * (f5 * 2.0f)) / fWidth) / fWidth;
        float f7 = pointF4.y;
        float f8 = ((((pointF5.y - f7) * (f7 * 2.0f)) / f4) / f4) + f6;
        float fPow2 = (f8 * f8) - ((4.0f * fPow) * ((((((float) Math.pow(pointF4.y, d)) / f4) / f4) + ((((float) Math.pow(f5, d)) / fWidth) / fWidth)) - 1.0f));
        if (fPow2 == 0.0f) {
            float f9 = ((-f8) / 2.0f) / fPow;
            return (-f2) <= f9 && f9 <= f2 + 1.0f;
        }
        if (fPow2 > 0.0f) {
            float f10 = -f8;
            double d2 = fPow2;
            float fSqrt = ((((float) Math.sqrt(d2)) + f10) / 2.0f) / fPow;
            float fSqrt2 = ((f10 - ((float) Math.sqrt(d2))) / 2.0f) / fPow;
            float f11 = -f2;
            if ((f11 <= fSqrt && fSqrt <= f2 + 1.0f) || (f11 <= fSqrt2 && fSqrt2 <= f2 + 1.0f)) {
                return true;
            }
        }
        return false;
    }
}
