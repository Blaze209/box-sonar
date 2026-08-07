package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.unit.Velocity;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import sdk.pendo.io.actions.configurations.GuideCapping;

/* JADX INFO: compiled from: Scrollable.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J'\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J \u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0010\u001a\u00020\u00172\u0006\u0010\u0011\u001a\u00020\u0017H\u0096@¢\u0006\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u001a"}, d2 = {"Landroidx/compose/foundation/gestures/ScrollableNestedScrollConnection;", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "scrollingLogic", "Landroidx/compose/foundation/gestures/ScrollLogic;", "enabled", "", "<init>", "(Landroidx/compose/foundation/gestures/ScrollLogic;Z)V", "getScrollingLogic", "()Landroidx/compose/foundation/gestures/ScrollLogic;", "getEnabled", "()Z", "setEnabled", "(Z)V", "onPostScroll", "Landroidx/compose/ui/geometry/Offset;", GuideCapping.INSERT_CAPPING_CONSUMED, "available", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "onPostScroll-DzOQY0M", "(JJI)J", "onPostFling", "Landroidx/compose/ui/unit/Velocity;", "onPostFling-RZ2iAVY", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ScrollableNestedScrollConnection implements NestedScrollConnection {
    public static final int $stable = 8;
    private boolean enabled;
    private final ScrollLogic scrollingLogic;

    public ScrollableNestedScrollConnection(ScrollLogic scrollLogic, boolean z) {
        this.scrollingLogic = scrollLogic;
        this.enabled = z;
    }

    public final ScrollLogic getScrollingLogic() {
        return this.scrollingLogic;
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    public final void setEnabled(boolean z) {
        this.enabled = z;
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* JADX INFO: renamed from: onPostScroll-DzOQY0M, reason: not valid java name */
    public long mo946onPostScrollDzOQY0M(long consumed, long available, int source) {
        if (this.enabled) {
            return this.scrollingLogic.mo933performRawScrollMKHz9U(available);
        }
        return Offset.INSTANCE.m6585getZeroF1C5BW0();
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* JADX INFO: renamed from: onPostFling-RZ2iAVY, reason: not valid java name */
    public Object mo945onPostFlingRZ2iAVY(long j, long j2, Continuation<? super Velocity> continuation) {
        ScrollableNestedScrollConnection$onPostFling$1 scrollableNestedScrollConnection$onPostFling$1;
        long jM9936getZero9UxMQ8M;
        long jM9936getZero9UxMQ8M2;
        if (continuation instanceof ScrollableNestedScrollConnection$onPostFling$1) {
            scrollableNestedScrollConnection$onPostFling$1 = (ScrollableNestedScrollConnection$onPostFling$1) continuation;
            if ((scrollableNestedScrollConnection$onPostFling$1.label & Integer.MIN_VALUE) != 0) {
                scrollableNestedScrollConnection$onPostFling$1.label -= Integer.MIN_VALUE;
            } else {
                scrollableNestedScrollConnection$onPostFling$1 = new ScrollableNestedScrollConnection$onPostFling$1(this, continuation);
            }
        } else {
            scrollableNestedScrollConnection$onPostFling$1 = new ScrollableNestedScrollConnection$onPostFling$1(this, continuation);
        }
        Object objMo932doFlingAnimationQWom1Mo = scrollableNestedScrollConnection$onPostFling$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = scrollableNestedScrollConnection$onPostFling$1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objMo932doFlingAnimationQWom1Mo);
            if (this.enabled) {
                if (this.scrollingLogic.isFlinging()) {
                    jM9936getZero9UxMQ8M2 = Velocity.INSTANCE.m9936getZero9UxMQ8M();
                } else {
                    ScrollLogic scrollLogic = this.scrollingLogic;
                    scrollableNestedScrollConnection$onPostFling$1.J$0 = j2;
                    scrollableNestedScrollConnection$onPostFling$1.label = 1;
                    objMo932doFlingAnimationQWom1Mo = scrollLogic.mo932doFlingAnimationQWom1Mo(j2, scrollableNestedScrollConnection$onPostFling$1);
                    if (objMo932doFlingAnimationQWom1Mo == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                jM9936getZero9UxMQ8M = Velocity.m9928minusAH228Gc(j2, jM9936getZero9UxMQ8M2);
            } else {
                jM9936getZero9UxMQ8M = Velocity.INSTANCE.m9936getZero9UxMQ8M();
            }
            return Velocity.m9916boximpl(jM9936getZero9UxMQ8M);
        }
        if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        long j3 = scrollableNestedScrollConnection$onPostFling$1.J$0;
        ResultKt.throwOnFailure(objMo932doFlingAnimationQWom1Mo);
        j2 = j3;
        jM9936getZero9UxMQ8M2 = ((Velocity) objMo932doFlingAnimationQWom1Mo).getPackedValue();
        jM9936getZero9UxMQ8M = Velocity.m9928minusAH228Gc(j2, jM9936getZero9UxMQ8M2);
        return Velocity.m9916boximpl(jM9936getZero9UxMQ8M);
    }
}
