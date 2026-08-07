package dev.chrisbanes.haze;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: Utils.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a'\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0000¢\u0006\u0004\b\u0007\u0010\b\u001a\u001b\u0010\t\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\n\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u000b\u0010\f\u001a \u0010\r\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0001H\u0000\u001a(\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u00150\u0014\"\u0004\b\u0000\u0010\u00152\u000e\b\b\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u00150\u0017H\u0080\bø\u0001\u0000\u001a\u0011\u0010\u0018\u001a\u00020\u0003*\u00020\u0019H\u0000¢\u0006\u0002\u0010\u001a\"\u0019\u0010\u0010\u001a\u00020\u0003*\u00020\u00038À\u0002X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u001b"}, d2 = {"calculateLength", "", "start", "Landroidx/compose/ui/geometry/Offset;", "end", "size", "Landroidx/compose/ui/geometry/Size;", "calculateLength-wtYxqtY", "(JJJ)F", "expand", "expansion", "expand-TmRCtEA", "(JF)J", "lerp", "stop", "fraction", "orZero", "getOrZero-k-4lQ0M", "(J)J", "unsynchronizedLazy", "Lkotlin/Lazy;", ExifInterface.GPS_DIRECTION_TRUE, "initializer", "Lkotlin/Function0;", "positionOnScreenCatching", "Landroidx/compose/ui/layout/LayoutCoordinates;", "(Landroidx/compose/ui/layout/LayoutCoordinates;)J", "haze_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class UtilsKt {
    public static final float lerp(float f, float f2, float f3) {
        return f + (f3 * (f2 - f));
    }

    /* JADX INFO: renamed from: expand-TmRCtEA, reason: not valid java name */
    public static final long m14522expandTmRCtEA(long j, float f) {
        return SizeKt.Size(Size.m6638getWidthimpl(j) + f, Size.m6635getHeightimpl(j) + f);
    }

    public static final <T> Lazy<T> unsynchronizedLazy(Function0<? extends T> initializer) {
        Intrinsics.checkNotNullParameter(initializer, "initializer");
        return LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) initializer);
    }

    public static final long positionOnScreenCatching(LayoutCoordinates layoutCoordinates) {
        Intrinsics.checkNotNullParameter(layoutCoordinates, "<this>");
        try {
            return LayoutCoordinatesKt.positionOnScreen(layoutCoordinates);
        } catch (Throwable unused) {
            return Offset.INSTANCE.m6584getUnspecifiedF1C5BW0();
        }
    }

    /* JADX INFO: renamed from: calculateLength-wtYxqtY, reason: not valid java name */
    public static final float m14521calculateLengthwtYxqtY(long j, long j2, long j3) {
        return (float) Math.hypot(RangesKt.coerceAtMost(Offset.m6569getXimpl(j2), Size.m6638getWidthimpl(j3)) - Offset.m6569getXimpl(j), RangesKt.coerceAtMost(Offset.m6570getYimpl(j2), Size.m6635getHeightimpl(j3)) - Offset.m6570getYimpl(j));
    }

    /* JADX INFO: renamed from: getOrZero-k-4lQ0M, reason: not valid java name */
    public static final long m14523getOrZerok4lQ0M(long j) {
        return OffsetKt.m6588isSpecifiedk4lQ0M(j) ? j : Offset.INSTANCE.m6585getZeroF1C5BW0();
    }
}
