package androidx.graphics.shapes;

import androidx.collection.FloatList;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: FloatMapping.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\u001a \u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0000\u001a \u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0003H\u0000\u001a\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\bH\u0000\u001a\u0018\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0003H\u0000¨\u0006\u0011"}, d2 = {"progressInRange", "", "progress", "", "progressFrom", "progressTo", "linearMap", "xValues", "Landroidx/collection/FloatList;", "yValues", "x", "validateProgress", "", "p", "progressDistance", "p1", "p2", "graphics-shapes"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class FloatMappingKt {
    public static final boolean progressInRange(float f, float f2, float f3) {
        if (f3 >= f2) {
            return f2 <= f && f <= f3;
        }
        return f >= f2 || f <= f3;
    }

    public static final void validateProgress(FloatList p) {
        Intrinsics.checkNotNullParameter(p, "p");
        float fLast = p.last();
        int i = p._size;
        int i2 = 0;
        int i3 = 0;
        while (i2 < i) {
            float f = p.get(i2);
            if (f < 0.0f || f >= 1.0f) {
                throw new IllegalArgumentException(("FloatMapping - Progress outside of range: " + FloatList.joinToString$default(p, null, null, null, 0, null, 31, null)).toString());
            }
            if (progressDistance(f, fLast) <= 1.0E-4f) {
                throw new IllegalArgumentException(("FloatMapping - Progress repeats a value: " + FloatList.joinToString$default(p, null, null, null, 0, null, 31, null)).toString());
            }
            if (f < fLast && (i3 = i3 + 1) > 1) {
                throw new IllegalArgumentException(("FloatMapping - Progress wraps more than once: " + FloatList.joinToString$default(p, null, null, null, 0, null, 31, null)).toString());
            }
            i2++;
            i = i;
            p = p;
            fLast = f;
        }
    }

    public static final float progressDistance(float f, float f2) {
        float fAbs = Math.abs(f - f2);
        return Math.min(fAbs, 1.0f - fAbs);
    }

    public static final float linearMap(FloatList xValues, FloatList yValues, float f) {
        Intrinsics.checkNotNullParameter(xValues, "xValues");
        Intrinsics.checkNotNullParameter(yValues, "yValues");
        if (0.0f > f || f > 1.0f) {
            throw new IllegalArgumentException(("Invalid progress: " + f).toString());
        }
        Iterator<Integer> it = RangesKt.until(0, xValues._size).iterator();
        while (it.hasNext()) {
            int iNextInt = ((IntIterator) it).nextInt();
            int i = iNextInt + 1;
            if (progressInRange(f, xValues.get(iNextInt), xValues.get(i % xValues._size))) {
                int i2 = i % xValues._size;
                float fPositiveModulo = Utils.positiveModulo(xValues.get(i2) - xValues.get(iNextInt), 1.0f);
                return Utils.positiveModulo(yValues.get(iNextInt) + (Utils.positiveModulo(yValues.get(i2) - yValues.get(iNextInt), 1.0f) * (fPositiveModulo < 0.001f ? 0.5f : Utils.positiveModulo(f - xValues.get(iNextInt), 1.0f) / fPositiveModulo)), 1.0f);
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }
}
