package androidx.compose.ui.text.input;

import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import kotlin.Metadata;

/* JADX INFO: compiled from: EditingBuffer.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u001f\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"updateRangeAfterDelete", "Landroidx/compose/ui/text/TextRange;", "target", "deleted", "updateRangeAfterDelete-pWDy79M", "(JJ)J", "ui-text"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class EditingBufferKt {
    /* JADX INFO: renamed from: updateRangeAfterDelete-pWDy79M, reason: not valid java name */
    public static final long m9259updateRangeAfterDeletepWDy79M(long j, long j2) {
        int iM9087getLengthimpl;
        int iM9089getMinimpl = TextRange.m9089getMinimpl(j);
        int iM9088getMaximpl = TextRange.m9088getMaximpl(j);
        if (TextRange.m9093intersects5zctL8(j2, j)) {
            if (TextRange.m9081contains5zctL8(j2, j)) {
                iM9089getMinimpl = TextRange.m9089getMinimpl(j2);
                iM9088getMaximpl = iM9089getMinimpl;
            } else {
                if (TextRange.m9081contains5zctL8(j, j2)) {
                    iM9087getLengthimpl = TextRange.m9087getLengthimpl(j2);
                } else if (TextRange.m9082containsimpl(j2, iM9089getMinimpl)) {
                    iM9089getMinimpl = TextRange.m9089getMinimpl(j2);
                    iM9087getLengthimpl = TextRange.m9087getLengthimpl(j2);
                } else {
                    iM9088getMaximpl = TextRange.m9089getMinimpl(j2);
                }
                iM9088getMaximpl -= iM9087getLengthimpl;
            }
        } else if (iM9088getMaximpl > TextRange.m9089getMinimpl(j2)) {
            iM9089getMinimpl -= TextRange.m9087getLengthimpl(j2);
            iM9087getLengthimpl = TextRange.m9087getLengthimpl(j2);
            iM9088getMaximpl -= iM9087getLengthimpl;
        }
        return TextRangeKt.TextRange(iM9089getMinimpl, iM9088getMaximpl);
    }
}
