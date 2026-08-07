package com.pspdfkit.internal.jni;

import android.graphics.PointF;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public abstract class NativeMeasurementCalculator {

    public static final class CppProxy extends NativeMeasurementCalculator {
        private final AtomicBoolean destroyed = new AtomicBoolean(false);
        private final long nativeRef;

        private CppProxy(long j) {
            if (j == 0) {
                throw new RuntimeException("nativeRef is zero");
            }
            this.nativeRef = j;
        }

        public static native double getMeasurementArea(ArrayList<PointF> arrayList, NativeMeasurementScale nativeMeasurementScale);

        public static native NativeMeasurementCalibration getMeasurementCalibrationFromScale(PointF pointF, PointF pointF2, NativeMeasurementScale nativeMeasurementScale);

        public static native double getMeasurementCircularArea(double d, double d2, NativeMeasurementScale nativeMeasurementScale);

        public static native double getMeasurementDistance(ArrayList<PointF> arrayList, NativeMeasurementScale nativeMeasurementScale);

        public static native NativeMeasurementScale getMeasurementScaleFromCalibration(PointF pointF, PointF pointF2, NativeMeasurementCalibration nativeMeasurementCalibration, NativeMeasurementScale nativeMeasurementScale);

        public static native boolean isMeasurementScaleValid(NativeMeasurementScale nativeMeasurementScale);

        private native void nativeDestroy(long j);

        public static native Double parseNumberFromString(String str, String str2);

        public void _djinni_private_destroy() {
            if (this.destroyed.getAndSet(true)) {
                return;
            }
            nativeDestroy(this.nativeRef);
        }

        public void finalize() throws Throwable {
            _djinni_private_destroy();
            super.finalize();
        }
    }

    public static double getMeasurementArea(ArrayList<PointF> arrayList, NativeMeasurementScale nativeMeasurementScale) {
        return CppProxy.getMeasurementArea(arrayList, nativeMeasurementScale);
    }

    public static NativeMeasurementCalibration getMeasurementCalibrationFromScale(PointF pointF, PointF pointF2, NativeMeasurementScale nativeMeasurementScale) {
        return CppProxy.getMeasurementCalibrationFromScale(pointF, pointF2, nativeMeasurementScale);
    }

    public static double getMeasurementCircularArea(double d, double d2, NativeMeasurementScale nativeMeasurementScale) {
        return CppProxy.getMeasurementCircularArea(d, d2, nativeMeasurementScale);
    }

    public static double getMeasurementDistance(ArrayList<PointF> arrayList, NativeMeasurementScale nativeMeasurementScale) {
        return CppProxy.getMeasurementDistance(arrayList, nativeMeasurementScale);
    }

    public static NativeMeasurementScale getMeasurementScaleFromCalibration(PointF pointF, PointF pointF2, NativeMeasurementCalibration nativeMeasurementCalibration, NativeMeasurementScale nativeMeasurementScale) {
        return CppProxy.getMeasurementScaleFromCalibration(pointF, pointF2, nativeMeasurementCalibration, nativeMeasurementScale);
    }

    public static boolean isMeasurementScaleValid(NativeMeasurementScale nativeMeasurementScale) {
        return CppProxy.isMeasurementScaleValid(nativeMeasurementScale);
    }

    public static Double parseNumberFromString(String str, String str2) {
        return CppProxy.parseNumberFromString(str, str2);
    }
}
