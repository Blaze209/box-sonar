package androidx.graphics.shapes;

import androidx.collection.FloatFloatPair;
import androidx.media3.exoplayer.upstream.CmcdData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PolygonMeasure.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\n\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0007H\u0016J\u001f\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Landroidx/graphics/shapes/LengthMeasurer;", "Landroidx/graphics/shapes/Measurer;", "<init>", "()V", "segments", "", "measureCubic", "", "c", "Landroidx/graphics/shapes/Cubic;", "findCubicCutPoint", CmcdData.OBJECT_TYPE_MANIFEST, "closestProgressTo", "Landroidx/collection/FloatFloatPair;", "cubic", "threshold", "closestProgressTo-XgqJiTY", "(Landroidx/graphics/shapes/Cubic;F)J", "graphics-shapes"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class LengthMeasurer implements Measurer {
    private final int segments = 3;

    @Override // androidx.graphics.shapes.Measurer
    public float measureCubic(Cubic c) {
        Intrinsics.checkNotNullParameter(c, "c");
        return Float.intBitsToFloat((int) (m10257closestProgressToXgqJiTY(c, Float.POSITIVE_INFINITY) & 4294967295L));
    }

    @Override // androidx.graphics.shapes.Measurer
    public float findCubicCutPoint(Cubic c, float m) {
        Intrinsics.checkNotNullParameter(c, "c");
        return Float.intBitsToFloat((int) (m10257closestProgressToXgqJiTY(c, m) >> 32));
    }

    /* JADX INFO: renamed from: closestProgressTo-XgqJiTY, reason: not valid java name */
    private final long m10257closestProgressToXgqJiTY(Cubic cubic, float threshold) {
        long jM315constructorimpl = FloatFloatPair.m315constructorimpl(cubic.getAnchor0X(), cubic.getAnchor0Y());
        int i = this.segments;
        float f = 0.0f;
        int i2 = 1;
        if (1 <= i) {
            float f2 = threshold;
            while (true) {
                float f3 = i2 / this.segments;
                long jM10255pointOnCurveOOQOV4g$graphics_shapes = cubic.m10255pointOnCurveOOQOV4g$graphics_shapes(f3);
                float fM10265getDistanceDnnuFBc = PointKt.m10265getDistanceDnnuFBc(PointKt.m10270minusybeJwSQ(jM10255pointOnCurveOOQOV4g$graphics_shapes, jM315constructorimpl));
                if (fM10265getDistanceDnnuFBc >= f2) {
                    return FloatFloatPair.m315constructorimpl(f3 - ((1.0f - (f2 / fM10265getDistanceDnnuFBc)) / this.segments), threshold);
                }
                f2 -= fM10265getDistanceDnnuFBc;
                f += fM10265getDistanceDnnuFBc;
                if (i2 != i) {
                    i2++;
                    jM315constructorimpl = jM10255pointOnCurveOOQOV4g$graphics_shapes;
                }
            }
        }
        return FloatFloatPair.m315constructorimpl(1.0f, f);
    }
}
