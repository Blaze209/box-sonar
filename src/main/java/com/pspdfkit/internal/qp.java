package com.pspdfkit.internal;

import android.graphics.PointF;
import com.pspdfkit.annotations.AnnotationType;
import com.pspdfkit.annotations.measurements.MeasurementMode;
import com.pspdfkit.annotations.measurements.Scale;
import com.pspdfkit.internal.jni.NativeMeasurementCalculator;
import com.pspdfkit.internal.jni.NativeMeasurementScale;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: loaded from: classes3.dex */
public final class qp {

    public static final /* synthetic */ class a {
        public static final /* synthetic */ int[] a;
        public static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[MeasurementMode.values().length];
            try {
                iArr[MeasurementMode.DISTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[MeasurementMode.PERIMETER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[MeasurementMode.AREA.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            a = iArr;
            int[] iArr2 = new int[AnnotationType.values().length];
            try {
                iArr2[AnnotationType.LINE.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[AnnotationType.POLYLINE.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[AnnotationType.POLYGON.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[AnnotationType.CIRCLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr2[AnnotationType.SQUARE.ordinal()] = 5;
            } catch (NoSuchFieldError unused8) {
            }
            b = iArr2;
        }
    }

    public static final rp a(xp xpVar, List<? extends PointF> list) {
        double measurementDistance;
        xpVar.getClass();
        list.getClass();
        if (list.isEmpty()) {
            return null;
        }
        Scale scale = xpVar.a;
        ArrayList arrayList = new ArrayList(list);
        NativeMeasurementScale nativeMeasurementScaleA = mr.a(scale);
        int i = a.a[xpVar.c.ordinal()];
        if (i == 1 || i == 2) {
            measurementDistance = NativeMeasurementCalculator.getMeasurementDistance(arrayList, nativeMeasurementScaleA);
        } else {
            if (i != 3) {
                throw new NoWhenBranchMatchedException();
            }
            measurementDistance = NativeMeasurementCalculator.getMeasurementArea(arrayList, nativeMeasurementScaleA);
        }
        if (Double.isNaN(measurementDistance)) {
            measurementDistance = 0.0d;
        }
        DecimalFormat decimalFormat = di.a;
        float f = (float) measurementDistance;
        return new rp(di.a.a(xpVar, f), f);
    }

    public static final String a(MeasurementMode measurementMode, Scale.UnitTo unitTo) {
        if (a.a[measurementMode.ordinal()] == 3) {
            return "\u2009" + unitTo + "²";
        }
        return "\u2009" + unitTo;
    }
}
