package com.pspdfkit.internal;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import androidx.core.content.ContextCompat;
import com.pspdfkit.R;
import com.pspdfkit.preferences.PSPDFKitPreferences;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

/* JADX INFO: loaded from: classes3.dex */
public final class n0 {
    public final List<Double> a;
    public final List<Double> b;
    public final int c;
    public final int d;
    public boolean e;
    public final Path f;
    public final Paint g;
    public PointF h;
    public PointF i;
    public final PSPDFKitPreferences j;

    public n0(Context context) {
        context.getClass();
        Resources.Theme theme = context.getTheme();
        TypedArray typedArrayObtainStyledAttributes = theme != null ? theme.obtainStyledAttributes(null, R.styleable.pspdf__HelperLine, R.attr.pspdf__helperLineStyle, R.style.PSPDFKit_HelperLine) : null;
        int color = typedArrayObtainStyledAttributes != null ? typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__HelperLine_pspdf__helperLineColor, ContextCompat.getColor(context, R.color.pspdf__errorContainerLight)) : ContextCompat.getColor(context, R.color.pspdf__errorContainerLight);
        this.a = CollectionsKt.listOf((Object[]) new Double[]{Double.valueOf(0.0d), Double.valueOf(45.0d), Double.valueOf(90.0d), Double.valueOf(135.0d), Double.valueOf(180.0d), Double.valueOf(225.0d), Double.valueOf(270.0d), Double.valueOf(315.0d), Double.valueOf(360.0d)});
        this.b = CollectionsKt.listOf((Object[]) new Double[]{Double.valueOf(0.0d), Double.valueOf(90.0d), Double.valueOf(180.0d), Double.valueOf(270.0d), Double.valueOf(360.0d)});
        this.c = 2500;
        this.d = context.getResources().getDimensionPixelSize(R.dimen.pspdf__measurement_snapping_threshold);
        this.f = new Path();
        Paint paint = new Paint();
        paint.setColor(color);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(context.getResources().getDimensionPixelSize(R.dimen.pspdf__shape_drawing_helpers_width));
        this.g = paint;
        PSPDFKitPreferences pSPDFKitPreferences = PSPDFKitPreferences.get(context);
        pSPDFKitPreferences.getClass();
        this.j = pSPDFKitPreferences;
    }

    public static double a(PointF pointF, PointF pointF2) {
        return Math.sqrt(Math.pow(pointF.y - pointF2.y, 2.0d) + Math.pow(pointF.x - pointF2.x, 2.0d));
    }

    public final void b(PointF pointF, PointF pointF2) {
        PointF pointF3;
        pointF.getClass();
        pointF2.getClass();
        if (this.j.isSmartGuidesEnabled().booleanValue()) {
            if (!this.e) {
                this.h = null;
                return;
            }
            double dAtan2 = Math.atan2(-(pointF2.y - pointF.y), pointF2.x - pointF.x);
            double degrees = Math.toDegrees(dAtan2 < 0.0d ? Math.abs(dAtan2) : 6.283185307179586d - dAtan2);
            Iterator<Double> it = this.a.iterator();
            while (it.hasNext()) {
                double dDoubleValue = it.next().doubleValue();
                double d = 5.0f;
                if (dDoubleValue < degrees + d && dDoubleValue > degrees - d) {
                    double dSqrt = Math.sqrt(Math.pow(pointF2.y - pointF.y, 2.0d) + Math.pow(pointF2.x - pointF.x, 2.0d));
                    double d2 = dDoubleValue * 0.017453292519943295d;
                    float fCos = pointF.x - ((float) (Math.cos(d2) * ((double) this.c)));
                    float fSin = pointF.y - ((float) (Math.sin(d2) * ((double) this.c)));
                    float fCos2 = pointF.x + ((float) ((((double) this.c) + dSqrt) * Math.cos(d2)));
                    float fSin2 = pointF.y + ((float) ((((double) this.c) + dSqrt) * Math.sin(d2)));
                    float f = fSin2 - fSin;
                    float f2 = fCos2 - fCos;
                    float fAbs = (float) (((double) Math.abs(((fCos2 * fSin) + ((pointF2.x * f) - (pointF2.y * f2))) - (fSin2 * fCos))) / Math.sqrt(Math.pow(f2, 2.0d) + Math.pow(f, 2.0d)));
                    this.f.reset();
                    if (fAbs < this.d) {
                        this.f.moveTo(fCos, fSin);
                        this.f.lineTo(fCos2, fSin2);
                        pointF3 = new PointF(pointF.x + ((float) (Math.cos(d2) * dSqrt)), pointF.y + ((float) (Math.sin(d2) * dSqrt)));
                    } else {
                        pointF3 = null;
                    }
                    this.h = pointF3;
                    return;
                }
                this.h = null;
                this.f.reset();
            }
        }
    }

    public final PointF a(PointF pointF, float f, float f2) {
        if (this.j.isSmartGuidesEnabled().booleanValue()) {
            PointF pointF2 = this.h;
            if (pointF2 != null && this.i != null) {
                pointF2.offset(f, f2);
                PointF pointF3 = this.i;
                pointF3.getClass();
                pointF3.offset(f, f2);
                if (a(pointF2, pointF) >= a(pointF3, pointF)) {
                    pointF2 = pointF3;
                }
                if (a(pointF2, pointF) <= this.d) {
                    return pointF2;
                }
            } else if (pointF2 != null) {
                pointF2.offset(f, f2);
                if (a(pointF2, pointF) <= this.d) {
                    return pointF2;
                }
            } else {
                PointF pointF4 = this.i;
                if (pointF4 != null) {
                    pointF4.offset(f, f2);
                    if (a(pointF4, pointF) <= this.d) {
                        return pointF4;
                    }
                }
            }
        }
        return pointF;
    }

    public final void a(PointF pointF, PointF pointF2, ArrayList arrayList) {
        PointF pointF3;
        arrayList.getClass();
        if (this.j.isSmartGuidesEnabled().booleanValue() && this.e && arrayList.size() > 2) {
            Iterator<Integer> it = new IntRange(0, arrayList.size() - 2).iterator();
            while (it.hasNext()) {
                PointF pointF4 = (PointF) arrayList.get(((IntIterator) it).nextInt());
                if (!Intrinsics.areEqual(pointF, pointF4)) {
                    double dAtan2 = Math.atan2(-(pointF4.y - pointF2.y), pointF4.x - pointF2.x);
                    double degrees = Math.toDegrees(dAtan2 < 0.0d ? Math.abs(dAtan2) : 6.283185307179586d - dAtan2);
                    Iterator<Double> it2 = this.b.iterator();
                    while (it2.hasNext()) {
                        double dDoubleValue = it2.next().doubleValue();
                        double d = 0.017453292519943295d * dDoubleValue;
                        double d2 = 5.0f;
                        if (dDoubleValue < degrees + d2 && dDoubleValue > degrees - d2) {
                            double dA = a(pointF2, pointF4);
                            float fCos = pointF4.x - ((float) (Math.cos(d) * dA));
                            float fSin = pointF4.y - ((float) (Math.sin(d) * dA));
                            if (a(new PointF(fCos, fSin), pointF2) < this.d) {
                                this.f.moveTo(pointF4.x, pointF4.y);
                                this.f.lineTo(fCos, fSin);
                                pointF3 = new PointF(fCos, fSin);
                            } else {
                                pointF3 = null;
                            }
                            this.i = pointF3;
                            return;
                        }
                    }
                }
            }
        }
    }
}
