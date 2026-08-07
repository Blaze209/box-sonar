package androidx.graphics.shapes;

import androidx.collection.FloatFloatPair;
import external.sdk.pendo.io.mozilla.javascript.ES6Iterator;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Cubic.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000 C2\u00020\u0001:\u0001CB\u0013\b\u0000\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B9\b\u0010\u0012\n\u0010\u0006\u001a\u00060\u0007j\u0002`\b\u0012\n\u0010\t\u001a\u00060\u0007j\u0002`\b\u0012\n\u0010\n\u001a\u00060\u0007j\u0002`\b\u0012\n\u0010\u000b\u001a\u00060\u0007j\u0002`\b¢\u0006\u0004\b\u0004\u0010\fJ\u001b\u0010!\u001a\u00060\u0007j\u0002`\b2\u0006\u0010\"\u001a\u00020\u0010H\u0000¢\u0006\u0004\b#\u0010$J\r\u0010%\u001a\u00020&H\u0000¢\u0006\u0002\b'J\u0015\u0010(\u001a\u00020&2\u0006\u0010)\u001a\u00020\u0000H\u0000¢\u0006\u0002\b*J\u0010\u0010+\u001a\u00020&2\u0006\u0010,\u001a\u00020\u0010H\u0002J!\u0010-\u001a\u00020.2\b\b\u0002\u0010/\u001a\u00020\u00032\b\b\u0002\u00100\u001a\u00020&H\u0000¢\u0006\u0002\b1J\u001a\u00102\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u0000032\u0006\u0010\"\u001a\u00020\u0010J\u0006\u00104\u001a\u00020\u0000J\u0011\u00105\u001a\u00020\u00002\u0006\u00106\u001a\u00020\u0000H\u0086\u0002J\u0011\u00107\u001a\u00020\u00002\u0006\u00108\u001a\u00020\u0010H\u0086\u0002J\u0011\u00107\u001a\u00020\u00002\u0006\u00108\u001a\u000209H\u0086\u0002J\u0011\u0010:\u001a\u00020\u00002\u0006\u00108\u001a\u00020\u0010H\u0086\u0002J\u0011\u0010:\u001a\u00020\u00002\u0006\u00108\u001a\u000209H\u0086\u0002J\b\u0010;\u001a\u00020<H\u0016J\u0013\u0010=\u001a\u00020&2\b\u0010>\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\u000e\u0010?\u001a\u00020\u00002\u0006\u0010@\u001a\u00020AJ\b\u0010B\u001a\u000209H\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0012R\u0011\u0010\u0015\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0012R\u0011\u0010\u0017\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0012R\u0011\u0010\u0019\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0012R\u0011\u0010\u001b\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u0012R\u0011\u0010\u001d\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u0012R\u0011\u0010\u001f\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b \u0010\u0012¨\u0006D"}, d2 = {"Landroidx/graphics/shapes/Cubic;", "", "points", "", "<init>", "([F)V", "anchor0", "Landroidx/collection/FloatFloatPair;", "Landroidx/graphics/shapes/Point;", "control0", "control1", "anchor1", "(JJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getPoints$graphics_shapes", "()[F", "anchor0X", "", "getAnchor0X", "()F", "anchor0Y", "getAnchor0Y", "control0X", "getControl0X", "control0Y", "getControl0Y", "control1X", "getControl1X", "control1Y", "getControl1Y", "anchor1X", "getAnchor1X", "anchor1Y", "getAnchor1Y", "pointOnCurve", "t", "pointOnCurve-OOQOV4g$graphics_shapes", "(F)J", "zeroLength", "", "zeroLength$graphics_shapes", "convexTo", ES6Iterator.NEXT_METHOD, "convexTo$graphics_shapes", "zeroIsh", "value", "calculateBounds", "", "bounds", "approximate", "calculateBounds$graphics_shapes", "split", "Lkotlin/Pair;", "reverse", "plus", "o", "times", "x", "", "div", "toString", "", "equals", "other", "transformed", "f", "Landroidx/graphics/shapes/PointTransformer;", "hashCode", "Companion", "graphics-shapes"}, k = 1, mv = {2, 0, 0}, xi = 48)
public class Cubic {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final float[] points;

    /* JADX WARN: Multi-variable type inference failed */
    public Cubic() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public /* synthetic */ Cubic(long j, long j2, long j3, long j4, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3, j4);
    }

    @JvmStatic
    public static final Cubic circularArc(float f, float f2, float f3, float f4, float f5, float f6) {
        return INSTANCE.circularArc(f, f2, f3, f4, f5, f6);
    }

    @JvmStatic
    public static final Cubic straightLine(float f, float f2, float f3, float f4) {
        return INSTANCE.straightLine(f, f2, f3, f4);
    }

    public Cubic(float[] points) {
        Intrinsics.checkNotNullParameter(points, "points");
        this.points = points;
        if (points.length != 8) {
            throw new IllegalArgumentException("Points array size should be 8".toString());
        }
    }

    public /* synthetic */ Cubic(float[] fArr, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new float[8] : fArr);
    }

    /* JADX INFO: renamed from: getPoints$graphics_shapes, reason: from getter */
    public final float[] getPoints() {
        return this.points;
    }

    public final float getAnchor0X() {
        return this.points[0];
    }

    public final float getAnchor0Y() {
        return this.points[1];
    }

    public final float getControl0X() {
        return this.points[2];
    }

    public final float getControl0Y() {
        return this.points[3];
    }

    public final float getControl1X() {
        return this.points[4];
    }

    public final float getControl1Y() {
        return this.points[5];
    }

    public final float getAnchor1X() {
        return this.points[6];
    }

    public final float getAnchor1Y() {
        return this.points[7];
    }

    private Cubic(long j, long j2, long j3, long j4) {
        this(new float[]{PointKt.m10267getXDnnuFBc(j), PointKt.m10268getYDnnuFBc(j), PointKt.m10267getXDnnuFBc(j2), PointKt.m10268getYDnnuFBc(j2), PointKt.m10267getXDnnuFBc(j3), PointKt.m10268getYDnnuFBc(j3), PointKt.m10267getXDnnuFBc(j4), PointKt.m10268getYDnnuFBc(j4)});
    }

    /* JADX INFO: renamed from: pointOnCurve-OOQOV4g$graphics_shapes, reason: not valid java name */
    public final long m10255pointOnCurveOOQOV4g$graphics_shapes(float t) {
        float f = 1 - t;
        float f2 = f * f * f;
        float f3 = 3 * t;
        float f4 = f3 * f * f;
        float f5 = f3 * t * f;
        float f6 = t * t * t;
        return FloatFloatPair.m315constructorimpl((getAnchor0X() * f2) + (getControl0X() * f4) + (getControl1X() * f5) + (getAnchor1X() * f6), (getAnchor0Y() * f2) + (getControl0Y() * f4) + (getControl1Y() * f5) + (getAnchor1Y() * f6));
    }

    public final boolean zeroLength$graphics_shapes() {
        return Math.abs(getAnchor0X() - getAnchor1X()) < 1.0E-4f && Math.abs(getAnchor0Y() - getAnchor1Y()) < 1.0E-4f;
    }

    public final boolean convexTo$graphics_shapes(Cubic next) {
        Intrinsics.checkNotNullParameter(next, "next");
        return Utils.m10301convexb22R3LQ(FloatFloatPair.m315constructorimpl(getAnchor0X(), getAnchor0Y()), FloatFloatPair.m315constructorimpl(getAnchor1X(), getAnchor1Y()), FloatFloatPair.m315constructorimpl(next.getAnchor1X(), next.getAnchor1Y()));
    }

    private final boolean zeroIsh(float value) {
        return Math.abs(value) < 1.0E-4f;
    }

    public static /* synthetic */ void calculateBounds$graphics_shapes$default(Cubic cubic, float[] fArr, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: calculateBounds");
        }
        if ((i & 1) != 0) {
            fArr = new float[4];
        }
        if ((i & 2) != 0) {
            z = false;
        }
        cubic.calculateBounds$graphics_shapes(fArr, z);
    }

    /* JADX WARN: Code duplicated, block: B:50:0x01a4  */
    /* JADX WARN: Code duplicated, block: B:53:0x01aa  */
    /* JADX WARN: Code duplicated, block: B:63:0x01c9 A[PHI: r0 r7
      0x01c9: PHI (r0v2 float) = (r0v1 float), (r0v3 float) binds: [B:85:0x0218, B:62:0x01c7] A[DONT_GENERATE, DONT_INLINE]
      0x01c9: PHI (r7v14 float) = (r7v10 float), (r7v16 float) binds: [B:85:0x0218, B:62:0x01c7] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:64:0x01cb  */
    /* JADX WARN: Code duplicated, block: B:66:0x01d4  */
    /* JADX WARN: Code duplicated, block: B:72:0x01f2  */
    /* JADX WARN: Code duplicated, block: B:75:0x01f7  */
    /* JADX WARN: Code duplicated, block: B:87:0x021b A[PHI: r9 r15
      0x021b: PHI (r9v5 float) = (r9v2 float), (r9v3 float), (r9v3 float), (r9v2 float), (r9v2 float), (r9v2 float) binds: [B:65:0x01d2, B:77:0x0201, B:79:0x0205, B:51:0x01a6, B:54:0x01b0, B:56:0x01b4] A[DONT_GENERATE, DONT_INLINE]
      0x021b: PHI (r15v13 float) = (r15v9 float), (r15v10 float), (r15v10 float), (r15v9 float), (r15v9 float), (r15v9 float) binds: [B:65:0x01d2, B:77:0x0201, B:79:0x0205, B:51:0x01a6, B:54:0x01b0, B:56:0x01b4] A[DONT_GENERATE, DONT_INLINE]] */
    public final void calculateBounds$graphics_shapes(float[] bounds, boolean approximate) {
        char c;
        char c2;
        char c3;
        float f;
        float control0Y;
        float anchor0Y;
        float control0Y2;
        float f2;
        float fSqrt;
        float fSqrt2;
        float fM10268getYDnnuFBc;
        float f3;
        float fM10268getYDnnuFBc2;
        float f4;
        Intrinsics.checkNotNullParameter(bounds, "bounds");
        if (zeroLength$graphics_shapes()) {
            bounds[0] = getAnchor0X();
            bounds[1] = getAnchor0Y();
            bounds[2] = getAnchor0X();
            bounds[3] = getAnchor0Y();
            return;
        }
        float fMin = Math.min(getAnchor0X(), getAnchor1X());
        float fMin2 = Math.min(getAnchor0Y(), getAnchor1Y());
        float fMax = Math.max(getAnchor0X(), getAnchor1X());
        float fMax2 = Math.max(getAnchor0Y(), getAnchor1Y());
        if (approximate) {
            bounds[0] = Math.min(fMin, Math.min(getControl0X(), getControl1X()));
            bounds[1] = Math.min(fMin2, Math.min(getControl0Y(), getControl1Y()));
            bounds[2] = Math.max(fMax, Math.max(getControl0X(), getControl1X()));
            bounds[3] = Math.max(fMax2, Math.max(getControl0Y(), getControl1Y()));
            return;
        }
        float f5 = 3;
        float control0X = (((-getAnchor0X()) + (getControl0X() * f5)) - (getControl1X() * f5)) + getAnchor1X();
        float f6 = 2;
        float f7 = 4;
        float anchor0X = ((getAnchor0X() * f6) - (getControl0X() * f7)) + (getControl1X() * f6);
        float control0X2 = (-getAnchor0X()) + getControl0X();
        if (!zeroIsh(control0X)) {
            float f8 = (anchor0X * anchor0X) - ((f7 * control0X) * control0X2);
            if (f8 >= 0.0f) {
                float f9 = -anchor0X;
                c = 0;
                c2 = 3;
                double d = f8;
                c3 = 2;
                f = fMin2;
                float f10 = control0X * f6;
                float fSqrt3 = (((float) Math.sqrt(d)) + f9) / f10;
                if (0.0f <= fSqrt3 && fSqrt3 <= 1.0f) {
                    float fM10267getXDnnuFBc = PointKt.m10267getXDnnuFBc(m10255pointOnCurveOOQOV4g$graphics_shapes(fSqrt3));
                    if (fM10267getXDnnuFBc < fMin) {
                        fMin = fM10267getXDnnuFBc;
                    }
                    if (fM10267getXDnnuFBc > fMax) {
                        fMax = fM10267getXDnnuFBc;
                    }
                }
                float fSqrt4 = (f9 - ((float) Math.sqrt(d))) / f10;
                if (0.0f <= fSqrt4 && fSqrt4 <= 1.0f) {
                    float fM10267getXDnnuFBc2 = PointKt.m10267getXDnnuFBc(m10255pointOnCurveOOQOV4g$graphics_shapes(fSqrt4));
                    if (fM10267getXDnnuFBc2 < fMin) {
                        fMin = fM10267getXDnnuFBc2;
                    }
                    if (fM10267getXDnnuFBc2 > fMax) {
                        fMax = fM10267getXDnnuFBc2;
                    }
                }
            }
            control0Y = (((-getAnchor0Y()) + (getControl0Y() * f5)) - (f5 * getControl1Y())) + getAnchor1Y();
            anchor0Y = ((getAnchor0Y() * f6) - (getControl0Y() * f7)) + (getControl1Y() * f6);
            control0Y2 = (-getAnchor0Y()) + getControl0Y();
            if (zeroIsh(control0Y)) {
                f2 = (anchor0Y * anchor0Y) - ((f7 * control0Y) * control0Y2);
                if (f2 >= 0.0f) {
                    float f11 = -anchor0Y;
                    double d2 = f2;
                    float f12 = f6 * control0Y;
                    fSqrt = (((float) Math.sqrt(d2)) + f11) / f12;
                    if (0.0f <= fSqrt && fSqrt <= 1.0f) {
                        fM10268getYDnnuFBc2 = PointKt.m10268getYDnnuFBc(m10255pointOnCurveOOQOV4g$graphics_shapes(fSqrt));
                        if (fM10268getYDnnuFBc2 < f) {
                            f = fM10268getYDnnuFBc2;
                        }
                        if (fM10268getYDnnuFBc2 > fMax2) {
                            fMax2 = fM10268getYDnnuFBc2;
                        }
                    }
                    fSqrt2 = (f11 - ((float) Math.sqrt(d2))) / f12;
                    if (0.0f <= fSqrt2 || fSqrt2 > 1.0f) {
                        f3 = f;
                    } else {
                        fM10268getYDnnuFBc = PointKt.m10268getYDnnuFBc(m10255pointOnCurveOOQOV4g$graphics_shapes(fSqrt2));
                        f3 = fM10268getYDnnuFBc < f ? fM10268getYDnnuFBc : f;
                        if (fM10268getYDnnuFBc > fMax2) {
                            fMax2 = fM10268getYDnnuFBc;
                        }
                    }
                } else {
                    f3 = f;
                }
            } else if (anchor0Y == 0.0f) {
                f3 = f;
            } else {
                f4 = (f6 * control0Y2) / ((-2) * anchor0Y);
                if (0.0f <= f4 || f4 > 1.0f) {
                    f3 = f;
                } else {
                    fM10268getYDnnuFBc = PointKt.m10268getYDnnuFBc(m10255pointOnCurveOOQOV4g$graphics_shapes(f4));
                    f3 = fM10268getYDnnuFBc < f ? fM10268getYDnnuFBc : f;
                    if (fM10268getYDnnuFBc > fMax2) {
                        fMax2 = fM10268getYDnnuFBc;
                    }
                }
            }
            bounds[c] = fMin;
            bounds[1] = f3;
            bounds[c3] = fMax;
            bounds[c2] = fMax2;
        }
        if (anchor0X != 0.0f) {
            float f13 = (control0X2 * f6) / ((-2) * anchor0X);
            if (0.0f <= f13 && f13 <= 1.0f) {
                float fM10267getXDnnuFBc3 = PointKt.m10267getXDnnuFBc(m10255pointOnCurveOOQOV4g$graphics_shapes(f13));
                if (fM10267getXDnnuFBc3 < fMin) {
                    fMin = fM10267getXDnnuFBc3;
                }
                if (fM10267getXDnnuFBc3 > fMax) {
                    fMax = fM10267getXDnnuFBc3;
                }
            }
        }
        c = 0;
        c2 = 3;
        c3 = 2;
        f = fMin2;
        control0Y = (((-getAnchor0Y()) + (getControl0Y() * f5)) - (f5 * getControl1Y())) + getAnchor1Y();
        anchor0Y = ((getAnchor0Y() * f6) - (getControl0Y() * f7)) + (getControl1Y() * f6);
        control0Y2 = (-getAnchor0Y()) + getControl0Y();
        if (zeroIsh(control0Y)) {
            f2 = (anchor0Y * anchor0Y) - ((f7 * control0Y) * control0Y2);
            if (f2 >= 0.0f) {
                float f14 = -anchor0Y;
                double d3 = f2;
                float f15 = f6 * control0Y;
                fSqrt = (((float) Math.sqrt(d3)) + f14) / f15;
                if (0.0f <= fSqrt) {
                    fM10268getYDnnuFBc2 = PointKt.m10268getYDnnuFBc(m10255pointOnCurveOOQOV4g$graphics_shapes(fSqrt));
                    if (fM10268getYDnnuFBc2 < f) {
                        f = fM10268getYDnnuFBc2;
                    }
                    if (fM10268getYDnnuFBc2 > fMax2) {
                        fMax2 = fM10268getYDnnuFBc2;
                    }
                }
                fSqrt2 = (f14 - ((float) Math.sqrt(d3))) / f15;
                if (0.0f <= fSqrt2) {
                    f3 = f;
                } else {
                    f3 = f;
                }
            } else {
                f3 = f;
            }
        } else if (anchor0Y == 0.0f) {
            f3 = f;
        } else {
            f4 = (f6 * control0Y2) / ((-2) * anchor0Y);
            if (0.0f <= f4) {
                f3 = f;
            } else {
                f3 = f;
            }
        }
        bounds[c] = fMin;
        bounds[1] = f3;
        bounds[c3] = fMax;
        bounds[c2] = fMax2;
    }

    public final Pair<Cubic, Cubic> split(float t) {
        float f = 1 - t;
        long jM10255pointOnCurveOOQOV4g$graphics_shapes = m10255pointOnCurveOOQOV4g$graphics_shapes(t);
        float f2 = f * f;
        float f3 = 2 * f * t;
        float f4 = t * t;
        return TuplesKt.to(CubicKt.Cubic(getAnchor0X(), getAnchor0Y(), (getAnchor0X() * f) + (getControl0X() * t), (getAnchor0Y() * f) + (getControl0Y() * t), (getAnchor0X() * f2) + (getControl0X() * f3) + (getControl1X() * f4), (getAnchor0Y() * f2) + (getControl0Y() * f3) + (getControl1Y() * f4), PointKt.m10267getXDnnuFBc(jM10255pointOnCurveOOQOV4g$graphics_shapes), PointKt.m10268getYDnnuFBc(jM10255pointOnCurveOOQOV4g$graphics_shapes)), CubicKt.Cubic(PointKt.m10267getXDnnuFBc(jM10255pointOnCurveOOQOV4g$graphics_shapes), PointKt.m10268getYDnnuFBc(jM10255pointOnCurveOOQOV4g$graphics_shapes), (getControl0X() * f2) + (getControl1X() * f3) + (getAnchor1X() * f4), (getControl0Y() * f2) + (getControl1Y() * f3) + (getAnchor1Y() * f4), (getControl1X() * f) + (getAnchor1X() * t), (getControl1Y() * f) + (getAnchor1Y() * t), getAnchor1X(), getAnchor1Y()));
    }

    public final Cubic reverse() {
        return CubicKt.Cubic(getAnchor1X(), getAnchor1Y(), getControl1X(), getControl1Y(), getControl0X(), getControl0Y(), getAnchor0X(), getAnchor0Y());
    }

    public final Cubic plus(Cubic o) {
        Intrinsics.checkNotNullParameter(o, "o");
        float[] fArr = new float[8];
        for (int i = 0; i < 8; i++) {
            fArr[i] = this.points[i] + o.points[i];
        }
        return new Cubic(fArr);
    }

    public final Cubic times(float x) {
        float[] fArr = new float[8];
        for (int i = 0; i < 8; i++) {
            fArr[i] = this.points[i] * x;
        }
        return new Cubic(fArr);
    }

    public final Cubic times(int x) {
        return times(x);
    }

    public final Cubic div(float x) {
        return times(1.0f / x);
    }

    public final Cubic div(int x) {
        return div(x);
    }

    public String toString() {
        return "anchor0: (" + getAnchor0X() + ", " + getAnchor0Y() + ") control0: (" + getControl0X() + ", " + getControl0Y() + "), control1: (" + getControl1X() + ", " + getControl1Y() + "), anchor1: (" + getAnchor1X() + ", " + getAnchor1Y() + ')';
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof Cubic) {
            return Arrays.equals(this.points, ((Cubic) other).points);
        }
        return false;
    }

    public final Cubic transformed(PointTransformer f) {
        Intrinsics.checkNotNullParameter(f, "f");
        MutableCubic mutableCubic = new MutableCubic();
        ArraysKt.copyInto$default(this.points, mutableCubic.getPoints(), 0, 0, 0, 14, (Object) null);
        mutableCubic.transform(f);
        return mutableCubic;
    }

    public int hashCode() {
        return Arrays.hashCode(this.points);
    }

    /* JADX INFO: compiled from: Cubic.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007H\u0007J8\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007H\u0007J\u001d\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0001¢\u0006\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Landroidx/graphics/shapes/Cubic$Companion;", "", "<init>", "()V", "straightLine", "Landroidx/graphics/shapes/Cubic;", "x0", "", "y0", "x1", "y1", "circularArc", "centerX", "centerY", "empty", "empty$graphics_shapes", "graphics-shapes"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final Cubic straightLine(float x0, float y0, float x1, float y1) {
            return CubicKt.Cubic(x0, y0, Utils.interpolate(x0, x1, 0.33333334f), Utils.interpolate(y0, y1, 0.33333334f), Utils.interpolate(x0, x1, 0.6666667f), Utils.interpolate(y0, y1, 0.6666667f), x1, y1);
        }

        @JvmStatic
        public final Cubic circularArc(float centerX, float centerY, float x0, float y0, float x1, float y1) {
            float f = x0 - centerX;
            float f2 = y0 - centerY;
            long jDirectionVector = Utils.directionVector(f, f2);
            float f3 = x1 - centerX;
            float f4 = y1 - centerY;
            long jDirectionVector2 = Utils.directionVector(f3, f4);
            long jM10304rotate90DnnuFBc = Utils.m10304rotate90DnnuFBc(jDirectionVector);
            long jM10304rotate90DnnuFBc2 = Utils.m10304rotate90DnnuFBc(jDirectionVector2);
            boolean z = PointKt.m10262dotProduct5P9i7ZU(jM10304rotate90DnnuFBc, f3, f4) >= 0.0f;
            float fM10263dotProductybeJwSQ = PointKt.m10263dotProductybeJwSQ(jDirectionVector, jDirectionVector2);
            if (fM10263dotProductybeJwSQ > 0.999f) {
                return straightLine(x0, y0, x1, y1);
            }
            float f5 = 1;
            float f6 = f5 - fM10263dotProductybeJwSQ;
            float fDistance = ((((Utils.distance(f, f2) * 4.0f) / 3.0f) * (((float) Math.sqrt(2 * f6)) - ((float) Math.sqrt(f5 - (fM10263dotProductybeJwSQ * fM10263dotProductybeJwSQ))))) / f6) * (z ? 1.0f : -1.0f);
            return CubicKt.Cubic(x0, y0, (PointKt.m10267getXDnnuFBc(jM10304rotate90DnnuFBc) * fDistance) + x0, (PointKt.m10268getYDnnuFBc(jM10304rotate90DnnuFBc) * fDistance) + y0, x1 - (PointKt.m10267getXDnnuFBc(jM10304rotate90DnnuFBc2) * fDistance), y1 - (PointKt.m10268getYDnnuFBc(jM10304rotate90DnnuFBc2) * fDistance), x1, y1);
        }

        @JvmStatic
        public final Cubic empty$graphics_shapes(float x0, float y0) {
            return CubicKt.Cubic(x0, y0, x0, y0, x0, y0, x0, y0);
        }
    }
}
