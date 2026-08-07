package androidx.compose.foundation.text.modifiers;

import androidx.compose.foundation.text.TextDelegateKt;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Constraints;
import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: LayoutUtils.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\u001a/\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0000¢\u0006\u0004\b\t\u0010\n\u001a/\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0000¢\u0006\u0004\b\r\u0010\u000e\u001a'\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\fH\u0000¢\u0006\u0004\b\u0011\u0010\u0012\"\u0018\u0010\u0013\u001a\u00020\u0004*\u00020\u00068@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"finalConstraints", "Landroidx/compose/ui/unit/Constraints;", "constraints", "softWrap", "", ViewProps.OVERFLOW, "Landroidx/compose/ui/text/style/TextOverflow;", "maxIntrinsicWidth", "", "finalConstraints-tfFHcEY", "(JZIF)J", "finalMaxWidth", "", "finalMaxWidth-tfFHcEY", "(JZIF)I", "finalMaxLines", "maxLinesIn", "finalMaxLines-xdlQI24", "(ZII)I", "isEllipsis", "isEllipsis-MW5-ApA", "(I)Z", "foundation"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class LayoutUtilsKt {
    /* JADX INFO: renamed from: finalConstraints-tfFHcEY, reason: not valid java name */
    public static final long m2074finalConstraintstfFHcEY(long j, boolean z, int i, float f) {
        return Constraints.INSTANCE.m9649fitPrioritizingWidthZbe2FdA(0, m2076finalMaxWidthtfFHcEY(j, z, i, f), 0, Constraints.m9639getMaxHeightimpl(j));
    }

    /* JADX INFO: renamed from: finalMaxWidth-tfFHcEY, reason: not valid java name */
    public static final int m2076finalMaxWidthtfFHcEY(long j, boolean z, int i, float f) {
        int iM9640getMaxWidthimpl = ((z || m2077isEllipsisMW5ApA(i)) && Constraints.m9636getHasBoundedWidthimpl(j)) ? Constraints.m9640getMaxWidthimpl(j) : Integer.MAX_VALUE;
        return Constraints.m9642getMinWidthimpl(j) == iM9640getMaxWidthimpl ? iM9640getMaxWidthimpl : RangesKt.coerceIn(TextDelegateKt.ceilToIntPx(f), Constraints.m9642getMinWidthimpl(j), iM9640getMaxWidthimpl);
    }

    /* JADX INFO: renamed from: finalMaxLines-xdlQI24, reason: not valid java name */
    public static final int m2075finalMaxLinesxdlQI24(boolean z, int i, int i2) {
        if (z || !m2077isEllipsisMW5ApA(i)) {
            return RangesKt.coerceAtLeast(i2, 1);
        }
        return 1;
    }

    /* JADX INFO: renamed from: isEllipsis-MW5-ApA, reason: not valid java name */
    public static final boolean m2077isEllipsisMW5ApA(int i) {
        return TextOverflow.m9574equalsimpl0(i, TextOverflow.INSTANCE.m9584getEllipsisgIe3tQ8()) || TextOverflow.m9574equalsimpl0(i, TextOverflow.INSTANCE.m9586getStartEllipsisgIe3tQ8()) || TextOverflow.m9574equalsimpl0(i, TextOverflow.INSTANCE.m9585getMiddleEllipsisgIe3tQ8());
    }
}
