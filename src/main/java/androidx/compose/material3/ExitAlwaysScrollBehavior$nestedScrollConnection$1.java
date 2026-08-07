package androidx.compose.material3;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.unit.Velocity;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import sdk.pendo.io.actions.configurations.GuideCapping;

/* JADX INFO: compiled from: AppBar.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J'\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ \u0010\n\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u000bH\u0096@¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"androidx/compose/material3/ExitAlwaysScrollBehavior$nestedScrollConnection$1", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "onPostScroll", "Landroidx/compose/ui/geometry/Offset;", GuideCapping.INSERT_CAPPING_CONSUMED, "available", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "onPostScroll-DzOQY0M", "(JJI)J", "onPostFling", "Landroidx/compose/ui/unit/Velocity;", "onPostFling-RZ2iAVY", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ExitAlwaysScrollBehavior$nestedScrollConnection$1 implements NestedScrollConnection {
    final /* synthetic */ ExitAlwaysScrollBehavior this$0;

    ExitAlwaysScrollBehavior$nestedScrollConnection$1(ExitAlwaysScrollBehavior exitAlwaysScrollBehavior) {
        this.this$0 = exitAlwaysScrollBehavior;
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* JADX INFO: renamed from: onPostScroll-DzOQY0M */
    public long mo946onPostScrollDzOQY0M(long consumed, long available, int source) {
        if (!this.this$0.getCanScroll().invoke().booleanValue()) {
            return Offset.INSTANCE.m6585getZeroF1C5BW0();
        }
        BottomAppBarState state = this.this$0.getState();
        int i = (int) (consumed & 4294967295L);
        state.setContentOffset(state.getContentOffset() + Float.intBitsToFloat(i));
        this.this$0.getState().setHeightOffset(this.this$0.getState().getHeightOffset() + Float.intBitsToFloat(i));
        return Offset.INSTANCE.m6585getZeroF1C5BW0();
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* JADX INFO: renamed from: onPostFling-RZ2iAVY */
    public Object mo945onPostFlingRZ2iAVY(long j, long j2, Continuation<? super Velocity> continuation) {
        ExitAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$1 exitAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$1;
        long j3;
        if (continuation instanceof ExitAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$1) {
            exitAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$1 = (ExitAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$1) continuation;
            if ((exitAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$1.label & Integer.MIN_VALUE) != 0) {
                exitAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$1.label -= Integer.MIN_VALUE;
            } else {
                exitAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$1 = new ExitAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$1(this, continuation);
            }
        } else {
            exitAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$1 = new ExitAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$1(this, continuation);
        }
        ExitAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$1 exitAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$2 = exitAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$1;
        Object objMo945onPostFlingRZ2iAVY = exitAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$2.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = exitAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$2.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objMo945onPostFlingRZ2iAVY);
            if (Velocity.m9926getYimpl(j2) > 0.0f && (this.this$0.getState().getHeightOffset() == 0.0f || this.this$0.getState().getHeightOffset() == this.this$0.getState().getHeightOffsetLimit())) {
                this.this$0.getState().setContentOffset(0.0f);
            }
            exitAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$2.J$0 = j2;
            exitAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$2.label = 1;
            objMo945onPostFlingRZ2iAVY = super.mo945onPostFlingRZ2iAVY(j, j2, exitAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$2);
            if (objMo945onPostFlingRZ2iAVY != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        if (i == 1) {
            j2 = exitAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$2.J$0;
            ResultKt.throwOnFailure(objMo945onPostFlingRZ2iAVY);
        } else {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            j3 = exitAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$2.J$0;
            ResultKt.throwOnFailure(objMo945onPostFlingRZ2iAVY);
        }
        return Velocity.m9916boximpl(Velocity.m9929plusAH228Gc(j3, ((Velocity) objMo945onPostFlingRZ2iAVY).getPackedValue()));
        long packedValue = ((Velocity) objMo945onPostFlingRZ2iAVY).getPackedValue();
        BottomAppBarState state = this.this$0.getState();
        float fM9926getYimpl = Velocity.m9926getYimpl(j2);
        DecayAnimationSpec<Float> flingAnimationSpec = this.this$0.getFlingAnimationSpec();
        AnimationSpec<Float> snapAnimationSpec = this.this$0.getSnapAnimationSpec();
        exitAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$2.J$0 = packedValue;
        exitAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$2.label = 2;
        objMo945onPostFlingRZ2iAVY = AppBarKt.settleAppBarBottom(state, fM9926getYimpl, flingAnimationSpec, snapAnimationSpec, exitAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$2);
        if (objMo945onPostFlingRZ2iAVY != coroutine_suspended) {
            j3 = packedValue;
            return Velocity.m9916boximpl(Velocity.m9929plusAH228Gc(j3, ((Velocity) objMo945onPostFlingRZ2iAVY).getPackedValue()));
        }
        return coroutine_suspended;
    }
}
