package androidx.constraintlayout.compose;

import androidx.compose.ui.unit.Dp;
import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;

/* JADX INFO: compiled from: ConstraintScopeCommon.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J.\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0007H&ø\u0001\u0000¢\u0006\u0004\b\t\u0010\nø\u0001\u0001\u0082\u0002\r\n\u0005\b¡\u001e0\u0001\n\u0004\b!0\u0001¨\u0006\u000bÀ\u0006\u0003"}, d2 = {"Landroidx/constraintlayout/compose/VerticalAnchorable;", "", "linkTo", "", "anchor", "Landroidx/constraintlayout/compose/ConstraintLayoutBaseScope$VerticalAnchor;", ViewProps.MARGIN, "Landroidx/compose/ui/unit/Dp;", "goneMargin", "linkTo-VpY3zN4", "(Landroidx/constraintlayout/compose/ConstraintLayoutBaseScope$VerticalAnchor;FF)V", "constraintlayout-compose_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface VerticalAnchorable {
    /* JADX INFO: renamed from: linkTo-VpY3zN4 */
    void mo9949linkToVpY3zN4(ConstraintLayoutBaseScope.VerticalAnchor anchor, float margin, float goneMargin);

    /* JADX INFO: compiled from: ConstraintScopeCommon.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
    }

    /* JADX INFO: renamed from: linkTo-VpY3zN4$default, reason: not valid java name */
    static /* synthetic */ void m10159linkToVpY3zN4$default(VerticalAnchorable verticalAnchorable, ConstraintLayoutBaseScope.VerticalAnchor verticalAnchor, float f, float f2, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: linkTo-VpY3zN4");
        }
        if ((i & 2) != 0) {
            f = Dp.m9687constructorimpl(0);
        }
        if ((i & 4) != 0) {
            f2 = Dp.m9687constructorimpl(0);
        }
        verticalAnchorable.mo9949linkToVpY3zN4(verticalAnchor, f, f2);
    }
}
