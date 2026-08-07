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
@Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ'\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000b\u0010\fJ \u0010\r\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u000eH\u0096@¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"androidx/compose/material3/EnterAlwaysScrollBehavior$nestedScrollConnection$1", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "onPreScroll", "Landroidx/compose/ui/geometry/Offset;", "available", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "onPreScroll-OzD1aCk", "(JI)J", "onPostScroll", GuideCapping.INSERT_CAPPING_CONSUMED, "onPostScroll-DzOQY0M", "(JJI)J", "onPostFling", "Landroidx/compose/ui/unit/Velocity;", "onPostFling-RZ2iAVY", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class EnterAlwaysScrollBehavior$nestedScrollConnection$1 implements NestedScrollConnection {
    final /* synthetic */ EnterAlwaysScrollBehavior this$0;

    EnterAlwaysScrollBehavior$nestedScrollConnection$1(EnterAlwaysScrollBehavior enterAlwaysScrollBehavior) {
        this.this$0 = enterAlwaysScrollBehavior;
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* JADX INFO: renamed from: onPreScroll-OzD1aCk */
    public long mo1299onPreScrollOzD1aCk(long available, int source) {
        if (!this.this$0.getCanScroll().invoke().booleanValue()) {
            return Offset.INSTANCE.m6585getZeroF1C5BW0();
        }
        float heightOffset = this.this$0.getState().getHeightOffset();
        TopAppBarState state = this.this$0.getState();
        state.setHeightOffset(state.getHeightOffset() + Float.intBitsToFloat((int) (4294967295L & available)));
        if (heightOffset != this.this$0.getState().getHeightOffset()) {
            return Offset.m6563copydBAh8RU$default(available, 0.0f, 0.0f, 2, null);
        }
        return Offset.INSTANCE.m6585getZeroF1C5BW0();
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* JADX INFO: renamed from: onPostScroll-DzOQY0M */
    public long mo946onPostScrollDzOQY0M(long consumed, long available, int source) {
        if (!this.this$0.getCanScroll().invoke().booleanValue()) {
            return Offset.INSTANCE.m6585getZeroF1C5BW0();
        }
        TopAppBarState state = this.this$0.getState();
        state.setContentOffset(state.getContentOffset() + Float.intBitsToFloat((int) (consumed & 4294967295L)));
        return Offset.INSTANCE.m6585getZeroF1C5BW0();
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* JADX INFO: renamed from: onPostFling-RZ2iAVY */
    public Object mo945onPostFlingRZ2iAVY(long j, long j2, Continuation<? super Velocity> continuation) {
        EnterAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$1 enterAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$1;
        long j3;
        if (continuation instanceof EnterAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$1) {
            enterAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$1 = (EnterAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$1) continuation;
            if ((enterAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$1.label & Integer.MIN_VALUE) != 0) {
                enterAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$1.label -= Integer.MIN_VALUE;
            } else {
                enterAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$1 = new EnterAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$1(this, continuation);
            }
        } else {
            enterAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$1 = new EnterAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$1(this, continuation);
        }
        EnterAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$1 enterAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$2 = enterAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$1;
        Object objMo945onPostFlingRZ2iAVY = enterAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$2.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = enterAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$2.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objMo945onPostFlingRZ2iAVY);
            if (Velocity.m9926getYimpl(j2) > 0.0f && (this.this$0.getState().getHeightOffset() == 0.0f || this.this$0.getState().getHeightOffset() == this.this$0.getState().getHeightOffsetLimit())) {
                this.this$0.getState().setContentOffset(0.0f);
            }
            enterAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$2.J$0 = j2;
            enterAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$2.label = 1;
            objMo945onPostFlingRZ2iAVY = super.mo945onPostFlingRZ2iAVY(j, j2, enterAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$2);
            if (objMo945onPostFlingRZ2iAVY != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        if (i == 1) {
            j2 = enterAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$2.J$0;
            ResultKt.throwOnFailure(objMo945onPostFlingRZ2iAVY);
        } else {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            j3 = enterAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$2.J$0;
            ResultKt.throwOnFailure(objMo945onPostFlingRZ2iAVY);
        }
        return Velocity.m9916boximpl(Velocity.m9929plusAH228Gc(j3, ((Velocity) objMo945onPostFlingRZ2iAVY).getPackedValue()));
        long packedValue = ((Velocity) objMo945onPostFlingRZ2iAVY).getPackedValue();
        TopAppBarState state = this.this$0.getState();
        float fM9926getYimpl = Velocity.m9926getYimpl(j2);
        DecayAnimationSpec<Float> flingAnimationSpec = this.this$0.getFlingAnimationSpec();
        AnimationSpec<Float> snapAnimationSpec = this.this$0.getSnapAnimationSpec();
        enterAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$2.J$0 = packedValue;
        enterAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$2.label = 2;
        objMo945onPostFlingRZ2iAVY = AppBarKt.settleAppBar(state, fM9926getYimpl, flingAnimationSpec, snapAnimationSpec, enterAlwaysScrollBehavior$nestedScrollConnection$1$onPostFling$2);
        if (objMo945onPostFlingRZ2iAVY != coroutine_suspended) {
            j3 = packedValue;
            return Velocity.m9916boximpl(Velocity.m9929plusAH228Gc(j3, ((Velocity) objMo945onPostFlingRZ2iAVY).getPackedValue()));
        }
        return coroutine_suspended;
    }
}
