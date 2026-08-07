package com.pspdfkit.internal.jni;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import com.pspdfkit.datastructures.Range;
import com.pspdfkit.utils.Size;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public abstract class NativeConversionTest {

    public static final class CppProxy extends NativeConversionTest {
        private final AtomicBoolean destroyed = new AtomicBoolean(false);
        private final long nativeRef;

        private CppProxy(long j) {
            if (j == 0) {
                throw new RuntimeException("nativeRef is zero");
            }
            this.nativeRef = j;
        }

        public static native ArrayList<Integer> convertBoxedColor(ArrayList<Integer> arrayList);

        public static native ArrayList<Matrix> convertBoxedMatrix(ArrayList<Matrix> arrayList);

        public static native ArrayList<PointF> convertBoxedPoint(ArrayList<PointF> arrayList);

        public static native ArrayList<Range> convertBoxedRange(ArrayList<Range> arrayList);

        public static native ArrayList<RectF> convertBoxedRect(ArrayList<RectF> arrayList);

        public static native ArrayList<Size> convertBoxedSize(ArrayList<Size> arrayList);

        public static native Integer convertColor(Integer num);

        public static native Matrix convertMatrix(Matrix matrix);

        public static native PointF convertPoint(PointF pointF);

        public static native Range convertRange(Range range);

        public static native RectF convertRect(RectF rectF);

        public static native Size convertSize(Size size);

        private native void nativeDestroy(long j);

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

    public static ArrayList<Integer> convertBoxedColor(ArrayList<Integer> arrayList) {
        return CppProxy.convertBoxedColor(arrayList);
    }

    public static ArrayList<Matrix> convertBoxedMatrix(ArrayList<Matrix> arrayList) {
        return CppProxy.convertBoxedMatrix(arrayList);
    }

    public static ArrayList<PointF> convertBoxedPoint(ArrayList<PointF> arrayList) {
        return CppProxy.convertBoxedPoint(arrayList);
    }

    public static ArrayList<Range> convertBoxedRange(ArrayList<Range> arrayList) {
        return CppProxy.convertBoxedRange(arrayList);
    }

    public static ArrayList<RectF> convertBoxedRect(ArrayList<RectF> arrayList) {
        return CppProxy.convertBoxedRect(arrayList);
    }

    public static ArrayList<Size> convertBoxedSize(ArrayList<Size> arrayList) {
        return CppProxy.convertBoxedSize(arrayList);
    }

    public static Integer convertColor(Integer num) {
        return CppProxy.convertColor(num);
    }

    public static Matrix convertMatrix(Matrix matrix) {
        return CppProxy.convertMatrix(matrix);
    }

    public static PointF convertPoint(PointF pointF) {
        return CppProxy.convertPoint(pointF);
    }

    public static Range convertRange(Range range) {
        return CppProxy.convertRange(range);
    }

    public static RectF convertRect(RectF rectF) {
        return CppProxy.convertRect(rectF);
    }

    public static Size convertSize(Size size) {
        return CppProxy.convertSize(size);
    }
}
