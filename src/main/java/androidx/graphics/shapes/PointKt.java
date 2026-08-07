package androidx.graphics.shapes;

import androidx.collection.FloatFloatPair;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Point.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a/\u0010\t\u001a\u00060\u0001j\u0002`\u0004*\u00060\u0001j\u0002`\u00042\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003H\u0000¢\u0006\u0004\b\n\u0010\u000b\u001a\u0017\u0010\f\u001a\u00020\u0003*\u00060\u0001j\u0002`\u0004H\u0000¢\u0006\u0004\b\r\u0010\u0006\u001a\u0017\u0010\u000e\u001a\u00020\u0003*\u00060\u0001j\u0002`\u0004H\u0000¢\u0006\u0004\b\u000f\u0010\u0006\u001a#\u0010\u0010\u001a\u00020\u0003*\u00060\u0001j\u0002`\u00042\n\u0010\u0011\u001a\u00060\u0001j\u0002`\u0004H\u0000¢\u0006\u0004\b\u0012\u0010\u0013\u001a'\u0010\u0010\u001a\u00020\u0003*\u00060\u0001j\u0002`\u00042\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0003H\u0000¢\u0006\u0004\b\u0016\u0010\u0017\u001a#\u0010\u0018\u001a\u00020\u0019*\u00060\u0001j\u0002`\u00042\n\u0010\u0011\u001a\u00060\u0001j\u0002`\u0004H\u0000¢\u0006\u0004\b\u001a\u0010\u001b\u001a\u001b\u0010\u001c\u001a\u00060\u0001j\u0002`\u0004*\u00060\u0001j\u0002`\u0004H\u0000¢\u0006\u0004\b\u001d\u0010\u001e\u001a\u001c\u0010\u001f\u001a\u00060\u0001j\u0002`\u0004*\u00060\u0001j\u0002`\u0004H\u0080\u0002¢\u0006\u0004\b \u0010\u001e\u001a(\u0010!\u001a\u00060\u0001j\u0002`\u0004*\u00060\u0001j\u0002`\u00042\n\u0010\u0011\u001a\u00060\u0001j\u0002`\u0004H\u0080\u0002¢\u0006\u0004\b\"\u0010#\u001a(\u0010$\u001a\u00060\u0001j\u0002`\u0004*\u00060\u0001j\u0002`\u00042\n\u0010\u0011\u001a\u00060\u0001j\u0002`\u0004H\u0080\u0002¢\u0006\u0004\b%\u0010#\u001a$\u0010&\u001a\u00060\u0001j\u0002`\u0004*\u00060\u0001j\u0002`\u00042\u0006\u0010'\u001a\u00020\u0003H\u0080\u0002¢\u0006\u0004\b(\u0010)\u001a$\u0010*\u001a\u00060\u0001j\u0002`\u0004*\u00060\u0001j\u0002`\u00042\u0006\u0010'\u001a\u00020\u0003H\u0080\u0002¢\u0006\u0004\b+\u0010)\u001a$\u0010,\u001a\u00060\u0001j\u0002`\u0004*\u00060\u0001j\u0002`\u00042\u0006\u0010'\u001a\u00020\u0003H\u0080\u0002¢\u0006\u0004\b-\u0010)\u001a3\u0010.\u001a\u00060\u0001j\u0002`\u00042\n\u0010/\u001a\u00060\u0001j\u0002`\u00042\n\u00100\u001a\u00060\u0001j\u0002`\u00042\u0006\u00101\u001a\u00020\u0003H\u0000¢\u0006\u0004\b2\u00103\u001a#\u00104\u001a\u00060\u0001j\u0002`\u0004*\u00060\u0001j\u0002`\u00042\u0006\u00105\u001a\u000206H\u0000¢\u0006\u0004\b7\u00108\"\u001c\u0010\u0002\u001a\u00020\u0003*\u00060\u0001j\u0002`\u00048@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\"\u001c\u0010\u0007\u001a\u00020\u0003*\u00060\u0001j\u0002`\u00048@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006*\f\b\u0000\u0010\u0000\"\u00020\u00012\u00020\u0001¨\u00069"}, d2 = {"Point", "Landroidx/collection/FloatFloatPair;", "x", "", "Landroidx/graphics/shapes/Point;", "getX-DnnuFBc", "(J)F", "y", "getY-DnnuFBc", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "copy-5P9i7ZU", "(JFF)J", "getDistance", "getDistance-DnnuFBc", "getDistanceSquared", "getDistanceSquared-DnnuFBc", "dotProduct", "other", "dotProduct-ybeJwSQ", "(JJ)F", "otherX", "otherY", "dotProduct-5P9i7ZU", "(JFF)F", "clockwise", "", "clockwise-ybeJwSQ", "(JJ)Z", "getDirection", "getDirection-DnnuFBc", "(J)J", "unaryMinus", "unaryMinus-DnnuFBc", "minus", "minus-ybeJwSQ", "(JJ)J", "plus", "plus-ybeJwSQ", "times", "operand", "times-so9K2fw", "(JF)J", "div", "div-so9K2fw", "rem", "rem-so9K2fw", "interpolate", "start", "stop", "fraction", "interpolate-dLqxh1s", "(JJF)J", "transformed", "f", "Landroidx/graphics/shapes/PointTransformer;", "transformed-so9K2fw", "(JLandroidx/graphics/shapes/PointTransformer;)J", "graphics-shapes"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class PointKt {
    /* JADX INFO: renamed from: copy-5P9i7ZU, reason: not valid java name */
    public static final long m10259copy5P9i7ZU(long j, float f, float f2) {
        return FloatFloatPair.m315constructorimpl(f, f2);
    }

    /* JADX INFO: renamed from: getDistance-DnnuFBc, reason: not valid java name */
    public static final float m10265getDistanceDnnuFBc(long j) {
        return (float) Math.sqrt((m10267getXDnnuFBc(j) * m10267getXDnnuFBc(j)) + (m10268getYDnnuFBc(j) * m10268getYDnnuFBc(j)));
    }

    /* JADX INFO: renamed from: getDistanceSquared-DnnuFBc, reason: not valid java name */
    public static final float m10266getDistanceSquaredDnnuFBc(long j) {
        return (m10267getXDnnuFBc(j) * m10267getXDnnuFBc(j)) + (m10268getYDnnuFBc(j) * m10268getYDnnuFBc(j));
    }

    /* JADX INFO: renamed from: dotProduct-ybeJwSQ, reason: not valid java name */
    public static final float m10263dotProductybeJwSQ(long j, long j2) {
        return (m10267getXDnnuFBc(j) * m10267getXDnnuFBc(j2)) + (m10268getYDnnuFBc(j) * m10268getYDnnuFBc(j2));
    }

    /* JADX INFO: renamed from: dotProduct-5P9i7ZU, reason: not valid java name */
    public static final float m10262dotProduct5P9i7ZU(long j, float f, float f2) {
        return (m10267getXDnnuFBc(j) * f) + (m10268getYDnnuFBc(j) * f2);
    }

    /* JADX INFO: renamed from: clockwise-ybeJwSQ, reason: not valid java name */
    public static final boolean m10258clockwiseybeJwSQ(long j, long j2) {
        return (m10267getXDnnuFBc(j) * m10268getYDnnuFBc(j2)) - (m10268getYDnnuFBc(j) * m10267getXDnnuFBc(j2)) > 0.0f;
    }

    /* JADX INFO: renamed from: getDirection-DnnuFBc, reason: not valid java name */
    public static final long m10264getDirectionDnnuFBc(long j) {
        float fM10265getDistanceDnnuFBc = m10265getDistanceDnnuFBc(j);
        if (fM10265getDistanceDnnuFBc <= 0.0f) {
            throw new IllegalArgumentException("Can't get the direction of a 0-length vector".toString());
        }
        return m10261divso9K2fw(j, fM10265getDistanceDnnuFBc);
    }

    /* JADX INFO: renamed from: unaryMinus-DnnuFBc, reason: not valid java name */
    public static final long m10275unaryMinusDnnuFBc(long j) {
        return FloatFloatPair.m315constructorimpl(-m10267getXDnnuFBc(j), -m10268getYDnnuFBc(j));
    }

    /* JADX INFO: renamed from: minus-ybeJwSQ, reason: not valid java name */
    public static final long m10270minusybeJwSQ(long j, long j2) {
        return FloatFloatPair.m315constructorimpl(m10267getXDnnuFBc(j) - m10267getXDnnuFBc(j2), m10268getYDnnuFBc(j) - m10268getYDnnuFBc(j2));
    }

    /* JADX INFO: renamed from: plus-ybeJwSQ, reason: not valid java name */
    public static final long m10271plusybeJwSQ(long j, long j2) {
        return FloatFloatPair.m315constructorimpl(m10267getXDnnuFBc(j) + m10267getXDnnuFBc(j2), m10268getYDnnuFBc(j) + m10268getYDnnuFBc(j2));
    }

    /* JADX INFO: renamed from: times-so9K2fw, reason: not valid java name */
    public static final long m10273timesso9K2fw(long j, float f) {
        return FloatFloatPair.m315constructorimpl(m10267getXDnnuFBc(j) * f, m10268getYDnnuFBc(j) * f);
    }

    /* JADX INFO: renamed from: div-so9K2fw, reason: not valid java name */
    public static final long m10261divso9K2fw(long j, float f) {
        return FloatFloatPair.m315constructorimpl(m10267getXDnnuFBc(j) / f, m10268getYDnnuFBc(j) / f);
    }

    /* JADX INFO: renamed from: rem-so9K2fw, reason: not valid java name */
    public static final long m10272remso9K2fw(long j, float f) {
        return FloatFloatPair.m315constructorimpl(m10267getXDnnuFBc(j) % f, m10268getYDnnuFBc(j) % f);
    }

    /* JADX INFO: renamed from: interpolate-dLqxh1s, reason: not valid java name */
    public static final long m10269interpolatedLqxh1s(long j, long j2, float f) {
        return FloatFloatPair.m315constructorimpl(Utils.interpolate(m10267getXDnnuFBc(j), m10267getXDnnuFBc(j2), f), Utils.interpolate(m10268getYDnnuFBc(j), m10268getYDnnuFBc(j2), f));
    }

    /* JADX INFO: renamed from: transformed-so9K2fw, reason: not valid java name */
    public static final long m10274transformedso9K2fw(long j, PointTransformer f) {
        Intrinsics.checkNotNullParameter(f, "f");
        long jMo5000transformXgqJiTY = f.mo5000transformXgqJiTY(m10267getXDnnuFBc(j), m10268getYDnnuFBc(j));
        return FloatFloatPair.m315constructorimpl(Float.intBitsToFloat((int) (jMo5000transformXgqJiTY >> 32)), Float.intBitsToFloat((int) (jMo5000transformXgqJiTY & 4294967295L)));
    }

    /* JADX INFO: renamed from: getX-DnnuFBc, reason: not valid java name */
    public static final float m10267getXDnnuFBc(long j) {
        return Float.intBitsToFloat((int) (j >> 32));
    }

    /* JADX INFO: renamed from: getY-DnnuFBc, reason: not valid java name */
    public static final float m10268getYDnnuFBc(long j) {
        return Float.intBitsToFloat((int) (j & 4294967295L));
    }

    /* JADX INFO: renamed from: copy-5P9i7ZU$default, reason: not valid java name */
    public static /* synthetic */ long m10260copy5P9i7ZU$default(long j, float f, float f2, int i, Object obj) {
        if ((i & 1) != 0) {
            f = Float.intBitsToFloat((int) (j >> 32));
        }
        if ((i & 2) != 0) {
            f2 = Float.intBitsToFloat((int) (4294967295L & j));
        }
        return m10259copy5P9i7ZU(j, f, f2);
    }
}
