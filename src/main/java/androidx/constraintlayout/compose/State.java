package androidx.constraintlayout.compose;

import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.constraintlayout.core.state.CorePixelDp;
import androidx.constraintlayout.core.state.HelperReference;
import androidx.constraintlayout.core.widgets.HelperWidget;
import com.facebook.react.uimanager.ViewProps;
import java.util.Iterator;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ConstraintLayout.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00060\u0001j\u0002`\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0012\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u0017\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001c\u001a\u00020\u001dH\u0000¢\u0006\u0002\b\u001eR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R$\u0010\b\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\u0011X\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001f"}, d2 = {"Landroidx/constraintlayout/compose/State;", "Landroidx/constraintlayout/core/state/State;", "Landroidx/constraintlayout/compose/SolverState;", "density", "Landroidx/compose/ui/unit/Density;", "(Landroidx/compose/ui/unit/Density;)V", "getDensity", "()Landroidx/compose/ui/unit/Density;", ViewProps.LAYOUT_DIRECTION, "Landroidx/compose/ui/unit/LayoutDirection;", "getLayoutDirection$annotations", "()V", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "setLayoutDirection", "(Landroidx/compose/ui/unit/LayoutDirection;)V", "rootIncomingConstraints", "Landroidx/compose/ui/unit/Constraints;", "getRootIncomingConstraints-msEJaDk", "()J", "setRootIncomingConstraints-BRTryo0", "(J)V", "J", "convertDimension", "", "value", "", "getKeyId", "helperWidget", "Landroidx/constraintlayout/core/widgets/HelperWidget;", "getKeyId$constraintlayout_compose_release", "constraintlayout-compose_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class State extends androidx.constraintlayout.core.state.State {
    public static final int $stable = 8;
    private final Density density;
    private long rootIncomingConstraints = ConstraintsKt.Constraints$default(0, 0, 0, 0, 15, null);
    private LayoutDirection layoutDirection = LayoutDirection.Ltr;

    @Deprecated(message = "Use #isLtr instead")
    public static /* synthetic */ void getLayoutDirection$annotations() {
    }

    public State(Density density) {
        this.density = density;
        setDpToPixel(new CorePixelDp() { // from class: androidx.constraintlayout.compose.State$$ExternalSyntheticLambda0
            @Override // androidx.constraintlayout.core.state.CorePixelDp
            public final float toPixels(float f) {
                return State._init_$lambda$0(this.f$0, f);
            }
        });
    }

    public final Density getDensity() {
        return this.density;
    }

    /* JADX INFO: renamed from: getRootIncomingConstraints-msEJaDk, reason: not valid java name and from getter */
    public final long getRootIncomingConstraints() {
        return this.rootIncomingConstraints;
    }

    /* JADX INFO: renamed from: setRootIncomingConstraints-BRTryo0, reason: not valid java name */
    public final void m10155setRootIncomingConstraintsBRTryo0(long j) {
        this.rootIncomingConstraints = j;
    }

    public final LayoutDirection getLayoutDirection() {
        return this.layoutDirection;
    }

    public final void setLayoutDirection(LayoutDirection layoutDirection) {
        this.layoutDirection = layoutDirection;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float _init_$lambda$0(State state, float f) {
        return state.density.getDensity() * f;
    }

    @Override // androidx.constraintlayout.core.state.State
    public int convertDimension(Object value) {
        if (value instanceof Dp) {
            return this.density.mo748roundToPx0680j_4(((Dp) value).m9701unboximpl());
        }
        return super.convertDimension(value);
    }

    public final Object getKeyId$constraintlayout_compose_release(HelperWidget helperWidget) {
        Object next;
        Iterator<T> it = this.mHelperReferences.entrySet().iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!Intrinsics.areEqual(((HelperReference) ((Map.Entry) next).getValue()).getHelperWidget(), helperWidget));
        Map.Entry entry = (Map.Entry) next;
        if (entry != null) {
            return entry.getKey();
        }
        return null;
    }
}
