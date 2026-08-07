package androidx.graphics.shapes;

import androidx.media3.exoplayer.upstream.CmcdData;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: SvgPathParser.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0002\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Landroidx/graphics/shapes/ArcConverter;", "", "<init>", "()V", "Companion", "graphics-shapes"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class ArcConverter {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: compiled from: SvgPathParser.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JT\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010JV\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\bH\u0002¨\u0006\u001b"}, d2 = {"Landroidx/graphics/shapes/ArcConverter$Companion;", "", "<init>", "()V", "arcToCubics", "", "Landroidx/graphics/shapes/Cubic;", "x0", "", "y0", "x1", "y1", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "b", "theta", "isMoreThanHalf", "", "isPositiveArc", "arcToBezier", "cx", "cy", "rx", "ry", "e1x", "e1y", "start", "sweep", "graphics-shapes"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final List<Cubic> arcToCubics(float x0, float y0, float x1, float y1, float a, float b, float theta, boolean isMoreThanHalf, boolean isPositiveArc) {
            double d;
            double d2;
            double d3 = (((double) theta) / ((double) 180)) * 3.141592653589793d;
            double dCos = Math.cos(d3);
            double dSin = Math.sin(d3);
            double d4 = y0;
            double d5 = a;
            double d6 = ((((double) x0) * dCos) + (d4 * dSin)) / d5;
            double d7 = (((double) (-x0)) * dSin) + (d4 * dCos);
            double d8 = b;
            double d9 = d7 / d8;
            double d10 = y1;
            double d11 = ((((double) x1) * dCos) + (d10 * dSin)) / d5;
            double d12 = ((((double) (-x1)) * dSin) + (d10 * dCos)) / d8;
            double d13 = d6 - d11;
            double d14 = d9 - d12;
            double d15 = 2;
            double d16 = (d6 + d11) / d15;
            double d17 = (d9 + d12) / d15;
            double d18 = (d13 * d13) + (d14 * d14);
            if (d18 == 0.0d) {
                return CollectionsKt.emptyList();
            }
            double d19 = (1.0d / d18) - 0.25d;
            if (d19 < 0.0d) {
                float fSqrt = (float) (Math.sqrt(d18) / 1.99999d);
                return arcToCubics(x0, y0, x1, y1, a * fSqrt, b * fSqrt, theta, isMoreThanHalf, isPositiveArc);
            }
            double dSqrt = Math.sqrt(d19);
            double d20 = d13 * dSqrt;
            double d21 = dSqrt * d14;
            if (isMoreThanHalf == isPositiveArc) {
                d = d16 - d21;
                d2 = d17 + d20;
            } else {
                d = d16 + d21;
                d2 = d17 - d20;
            }
            double dAtan2 = Math.atan2(d9 - d2, d6 - d);
            double dAtan3 = Math.atan2(d12 - d2, d11 - d) - dAtan2;
            if (isPositiveArc != (dAtan3 >= 0.0d)) {
                dAtan3 = dAtan3 > 0.0d ? dAtan3 - 6.283185307179586d : dAtan3 + 6.283185307179586d;
            }
            double d22 = d * d5;
            double d23 = d2 * d8;
            return arcToBezier((float) ((d22 * dCos) - (d23 * dSin)), (float) ((d22 * dSin) + (d23 * dCos)), a, b, x0, y0, (float) d3, (float) dAtan2, (float) dAtan3);
        }

        private final List<Cubic> arcToBezier(float cx, float cy, float rx, float ry, float e1x, float e1y, float theta, float start, float sweep) {
            ArrayList arrayList = new ArrayList();
            float f = 4;
            int iCeil = (int) Math.ceil(Math.abs(((double) (sweep * f)) / 3.141592653589793d));
            double d = theta;
            float fCos = (float) Math.cos(d);
            float fSin = (float) Math.sin(d);
            float f2 = start;
            double d2 = f2;
            float fCos2 = (float) Math.cos(d2);
            float fSin2 = (float) Math.sin(d2);
            float f3 = -rx;
            float f4 = f3 * fCos;
            float f5 = ry * fSin;
            float f6 = (f4 * fSin2) - (f5 * fCos2);
            float f7 = f3 * fSin;
            float f8 = ry * fCos;
            float f9 = (fSin2 * f7) + (fCos2 * f8);
            float f10 = sweep / iCeil;
            int i = 0;
            float f11 = e1x;
            float f12 = e1y;
            while (i < iCeil) {
                float f13 = f2 + f10;
                float f14 = f;
                int i2 = iCeil;
                double d3 = f13;
                float fSin3 = (float) Math.sin(d3);
                float fCos3 = (float) Math.cos(d3);
                float f15 = (cx + ((rx * fCos) * fCos3)) - (f5 * fSin3);
                float f16 = cy + (rx * fSin * fCos3) + (f8 * fSin3);
                float f17 = (f4 * fSin3) - (f5 * fCos3);
                float f18 = (f7 * fSin3) + (fCos3 * f8);
                float f19 = f13 - f2;
                float fTan = (float) Math.tan(f19 / 2);
                float f20 = 3;
                float fSin4 = (((float) Math.sin(f19)) * (((float) Math.sqrt(f14 + ((f20 * fTan) * fTan))) - 1)) / f20;
                arrayList.add(CubicKt.Cubic(f11, f12, f11 + (f6 * fSin4), f12 + (f9 * fSin4), f15 - (fSin4 * f17), f16 - (fSin4 * f18), f15, f16));
                i++;
                f = f14;
                f2 = f13;
                f6 = f17;
                f9 = f18;
                f11 = f15;
                f12 = f16;
                iCeil = i2;
            }
            return arrayList;
        }
    }
}
