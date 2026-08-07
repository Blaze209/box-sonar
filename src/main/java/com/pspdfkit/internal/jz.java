package com.pspdfkit.internal;

import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.RectF;
import android.util.Pair;
import com.pspdfkit.configuration.PdfConfiguration;
import com.pspdfkit.exceptions.NutrientException;

/* JADX INFO: loaded from: classes3.dex */
public final class jz {
    public final o4 a;
    public final float b;
    public final float c;
    public final Paint d;
    public Path e;
    public o4.b f;

    public jz(o4 o4Var, PdfConfiguration pdfConfiguration) {
        w4 w4Var = ca.a;
        if (w4Var == null) {
            throw new NutrientException("Make sure to call ConfigurationUtils#parseThemeConfigurations() before calling getAnnotationThemeConfiguration()");
        }
        this.a = o4Var;
        this.b = pdfConfiguration.getResizeGuideSnapAllowance();
        this.c = w4Var.i;
        Paint paint = new Paint();
        this.d = paint;
        paint.setColor(w4Var.h);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(w4Var.g);
        int size = pdfConfiguration.getGuideLineIntervals().size();
        float[] fArr = new float[size];
        for (int i = 0; i < size; i++) {
            fArr[i] = pdfConfiguration.getGuideLineIntervals().get(i).floatValue();
        }
        this.d.setPathEffect(new DashPathEffect(fArr, 0.0f));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static boolean a(o4.b bVar, mx mxVar, RectF rectF) {
        RectF rectF2 = mxVar.a;
        RectF rectF3 = mxVar.b;
        boolean z = false;
        switch (bVar.ordinal()) {
            case 0:
                if (mxVar.d() > rectF.top) {
                    float fB = mxVar.b();
                    float fD = mxVar.d();
                    float fC = mxVar.c();
                    float fA = mxVar.a();
                    float f = rectF.left;
                    float f2 = rectF.top;
                    PointF pointFA = ip.a(fB, fD, fC, fA, f, f2, rectF.right, f2);
                    rectF3.top = pointFA.y - rectF2.top;
                    rectF3.left = pointFA.x - rectF2.left;
                    return true;
                }
                return false;
            case 1:
            case 3:
            case 4:
            case 6:
                float fD2 = mxVar.d();
                float f3 = rectF.top;
                if (fD2 > f3) {
                    rectF3.top = f3 - rectF2.top;
                    z = true;
                }
                float fA2 = mxVar.a();
                float f4 = rectF.bottom;
                if (fA2 < f4) {
                    rectF3.bottom = f4 - rectF2.bottom;
                    z = true;
                }
                float fB2 = mxVar.b();
                float f5 = rectF.left;
                if (fB2 < f5) {
                    rectF3.left = f5 - rectF2.left;
                    z = true;
                }
                float fC2 = mxVar.c();
                float f6 = rectF.right;
                if (fC2 <= f6) {
                    return z;
                }
                rectF3.right = f6 - rectF2.right;
                return true;
            case 2:
                if (mxVar.d() > rectF.top) {
                    float fC3 = mxVar.c();
                    float fD3 = mxVar.d();
                    float fB3 = mxVar.b();
                    float fA3 = mxVar.a();
                    float f7 = rectF.left;
                    float f8 = rectF.top;
                    PointF pointFA2 = ip.a(fC3, fD3, fB3, fA3, f7, f8, rectF.right, f8);
                    rectF3.top = pointFA2.y - rectF2.top;
                    rectF3.right = pointFA2.x - rectF2.right;
                    return true;
                }
                return false;
            case 5:
                if (mxVar.a() < rectF.bottom) {
                    float fC4 = mxVar.c();
                    float fD4 = mxVar.d();
                    float fB4 = mxVar.b();
                    float fA4 = mxVar.a();
                    float f9 = rectF.left;
                    float f10 = rectF.bottom;
                    PointF pointFA3 = ip.a(fC4, fD4, fB4, fA4, f9, f10, rectF.right, f10);
                    rectF3.bottom = pointFA3.y - rectF2.bottom;
                    rectF3.left = pointFA3.x - rectF2.left;
                    return true;
                }
                return false;
            case 7:
                if (mxVar.a() < rectF.bottom) {
                    float fB5 = mxVar.b();
                    float fD5 = mxVar.d();
                    float fC5 = mxVar.c();
                    float fA5 = mxVar.a();
                    float f11 = rectF.left;
                    float f12 = rectF.bottom;
                    PointF pointFA4 = ip.a(fB5, fD5, fC5, fA5, f11, f12, rectF.right, f12);
                    rectF3.bottom = pointFA4.y - rectF2.bottom;
                    rectF3.right = pointFA4.x - rectF2.right;
                    return true;
                }
                return false;
            default:
                return false;
        }
    }

    /* JADX WARN: Code duplicated, block: B:33:0x0106  */
    public final void a() {
        Point point;
        Point point2;
        Object obj;
        Object obj2;
        int i;
        o4.b bVar = this.f;
        if (bVar == null) {
            return;
        }
        switch (bVar.ordinal()) {
            case 0:
                o4 o4Var = this.a;
                o4.b bVar2 = o4.b.BOTTOM_RIGHT;
                o4Var.getClass();
                point = (Point) o4Var.x.get(bVar2);
                o4 o4Var2 = this.a;
                o4.b bVar3 = o4.b.TOP_LEFT;
                o4Var2.getClass();
                point2 = (Point) o4Var2.x.get(bVar3);
                break;
            case 1:
            case 6:
                o4 o4Var3 = this.a;
                o4.b bVar4 = o4.b.CENTER_LEFT;
                o4Var3.getClass();
                point = (Point) o4Var3.x.get(bVar4);
                o4 o4Var4 = this.a;
                o4.b bVar5 = o4.b.CENTER_RIGHT;
                o4Var4.getClass();
                point2 = (Point) o4Var4.x.get(bVar5);
                break;
            case 2:
                o4 o4Var5 = this.a;
                o4.b bVar6 = o4.b.BOTTOM_LEFT;
                o4Var5.getClass();
                point = (Point) o4Var5.x.get(bVar6);
                o4 o4Var6 = this.a;
                o4.b bVar7 = o4.b.TOP_RIGHT;
                o4Var6.getClass();
                point2 = (Point) o4Var6.x.get(bVar7);
                break;
            case 3:
            case 4:
                o4 o4Var7 = this.a;
                o4.b bVar8 = o4.b.TOP_CENTER;
                o4Var7.getClass();
                point = (Point) o4Var7.x.get(bVar8);
                o4 o4Var8 = this.a;
                o4.b bVar9 = o4.b.BOTTOM_CENTER;
                o4Var8.getClass();
                point2 = (Point) o4Var8.x.get(bVar9);
                break;
            case 5:
                o4 o4Var9 = this.a;
                o4.b bVar10 = o4.b.TOP_RIGHT;
                o4Var9.getClass();
                point = (Point) o4Var9.x.get(bVar10);
                o4 o4Var10 = this.a;
                o4.b bVar11 = o4.b.BOTTOM_LEFT;
                o4Var10.getClass();
                point2 = (Point) o4Var10.x.get(bVar11);
                break;
            case 7:
                o4 o4Var11 = this.a;
                o4.b bVar12 = o4.b.TOP_LEFT;
                o4Var11.getClass();
                point = (Point) o4Var11.x.get(bVar12);
                o4 o4Var12 = this.a;
                o4.b bVar13 = o4.b.BOTTOM_RIGHT;
                o4Var12.getClass();
                point2 = (Point) o4Var12.x.get(bVar13);
                break;
            default:
                point = null;
                point2 = null;
                break;
        }
        Pair pair = (point == null || point2 == null) ? null : new Pair(point, point2);
        if (pair != null && (obj = pair.first) != null && (obj2 = pair.second) != null) {
            Point point3 = (Point) obj;
            int i2 = point3.x;
            int i3 = point3.y;
            Point point4 = (Point) obj2;
            int i4 = point4.x;
            int i5 = point4.y;
            o4.b bVar14 = this.f;
            if (bVar14 != null) {
                switch (bVar14.ordinal()) {
                    case 0:
                    case 7:
                        i = 4;
                        break;
                    case 1:
                    case 6:
                        i = 3;
                        break;
                    case 2:
                    case 5:
                        i = 5;
                        break;
                    case 3:
                    case 4:
                        i = 2;
                        break;
                    default:
                        i = 1;
                        break;
                }
            } else {
                i = 1;
            }
            int iA = y30.a(i);
            if (iA == 1) {
                float f = this.c;
                i3 = (int) (i3 - f);
                i5 = (int) (i5 + f);
            } else if (iA == 2) {
                float f2 = this.c;
                i2 = (int) (i2 - f2);
                i4 = (int) (i4 + f2);
            } else if (iA == 3 || iA == 4) {
                float f3 = (i5 - i3) / (i4 - i2);
                float f4 = this.c * (i2 >= i4 ? -1 : 1);
                int i6 = (int) (i2 - f4);
                i4 = (int) (f4 + i4);
                float f5 = i3;
                int i7 = (int) (((i6 - i2) * f3) + f5);
                i5 = (int) (((i4 - i2) * f3) + f5);
                i2 = i6;
                i3 = i7;
            }
            Path path = new Path();
            this.e = path;
            path.moveTo(i2, i3);
            this.e.lineTo(i4, i5);
        } else {
            this.f = null;
            this.e = null;
            this.a.invalidate();
        }
        this.a.invalidate();
    }
}
