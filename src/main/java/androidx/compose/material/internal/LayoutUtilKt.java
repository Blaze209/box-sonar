package androidx.compose.material.internal;

import kotlin.Metadata;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: LayoutUtil.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0000¨\u0006\u0003"}, d2 = {"subtractConstraintSafely", "", "other", "material"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class LayoutUtilKt {
    public static final int subtractConstraintSafely(int i, int i2) {
        return i == Integer.MAX_VALUE ? i : RangesKt.coerceAtLeast(i - i2, 0);
    }
}
