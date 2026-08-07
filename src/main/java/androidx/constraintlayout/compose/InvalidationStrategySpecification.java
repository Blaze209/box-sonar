package androidx.constraintlayout.compose;

import androidx.compose.ui.unit.Constraints;
import kotlin.Metadata;

/* JADX INFO: compiled from: MotionLayout.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0007\b\u0000¢\u0006\u0002\u0010\u0002J0\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000eJ0\u0010\u000f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u000eR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0011"}, d2 = {"Landroidx/constraintlayout/compose/InvalidationStrategySpecification;", "", "()V", "heightRateCount", "", "widthRateCount", "shouldInvalidateOnFixedHeight", "", "oldConstraints", "Landroidx/compose/ui/unit/Constraints;", "newConstraints", "skipCount", "threshold", "shouldInvalidateOnFixedHeight-SulIKG4", "(JJII)Z", "shouldInvalidateOnFixedWidth", "shouldInvalidateOnFixedWidth-SulIKG4", "constraintlayout-compose_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class InvalidationStrategySpecification {
    public static final int $stable = 8;
    private int heightRateCount;
    private int widthRateCount;

    /* JADX INFO: renamed from: shouldInvalidateOnFixedWidth-SulIKG4, reason: not valid java name */
    public final boolean m10070shouldInvalidateOnFixedWidthSulIKG4(long oldConstraints, long newConstraints, int skipCount, int threshold) {
        if (Constraints.m9638getHasFixedWidthimpl(oldConstraints) && Constraints.m9638getHasFixedWidthimpl(newConstraints)) {
            int iAbs = Math.abs(Constraints.m9640getMaxWidthimpl(newConstraints) - Constraints.m9640getMaxWidthimpl(oldConstraints));
            if (iAbs >= threshold) {
                this.widthRateCount = 0;
                return true;
            }
            if (iAbs != 0) {
                int i = this.widthRateCount + 1;
                this.widthRateCount = i;
                if (i > skipCount) {
                    this.widthRateCount = 0;
                    return true;
                }
            }
        } else {
            this.widthRateCount = 0;
        }
        return false;
    }

    /* JADX INFO: renamed from: shouldInvalidateOnFixedHeight-SulIKG4, reason: not valid java name */
    public final boolean m10069shouldInvalidateOnFixedHeightSulIKG4(long oldConstraints, long newConstraints, int skipCount, int threshold) {
        if (Constraints.m9637getHasFixedHeightimpl(oldConstraints) && Constraints.m9637getHasFixedHeightimpl(newConstraints)) {
            int iAbs = Math.abs(Constraints.m9639getMaxHeightimpl(newConstraints) - Constraints.m9639getMaxHeightimpl(oldConstraints));
            if (iAbs >= threshold) {
                this.heightRateCount = 0;
                return true;
            }
            if (iAbs != 0) {
                int i = this.heightRateCount + 1;
                this.heightRateCount = i;
                if (i > skipCount) {
                    this.heightRateCount = 0;
                    return true;
                }
            }
        } else {
            this.heightRateCount = 0;
        }
        return false;
    }
}
