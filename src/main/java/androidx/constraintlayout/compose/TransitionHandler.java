package androidx.constraintlayout.compose;

import androidx.compose.runtime.MonotonicFrameClockKt;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.unit.Velocity;
import androidx.constraintlayout.motion.widget.Key;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: TransitionHandler.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0001\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010J\u001b\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016J\u0006\u0010\u0017\u001a\u00020\fJ\u0018\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u000eø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001bJ\u000e\u0010\u001c\u001a\u00020\u0012H\u0086@¢\u0006\u0002\u0010\u001dR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001e"}, d2 = {"Landroidx/constraintlayout/compose/TransitionHandler;", "", "motionMeasurer", "Landroidx/constraintlayout/compose/MotionMeasurer;", Key.MOTIONPROGRESS, "Landroidx/compose/runtime/MutableFloatState;", "(Landroidx/constraintlayout/compose/MotionMeasurer;Landroidx/compose/runtime/MutableFloatState;)V", "transition", "Landroidx/constraintlayout/core/state/Transition;", "getTransition", "()Landroidx/constraintlayout/core/state/Transition;", "onAcceptFirstDownForOnSwipe", "", "offset", "Landroidx/compose/ui/geometry/Offset;", "onAcceptFirstDownForOnSwipe-k-4lQ0M", "(J)Z", "onTouchUp", "", "velocity", "Landroidx/compose/ui/unit/Velocity;", "onTouchUp-sF-c-tU", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "pendingProgressWhileTouchUp", "updateProgressOnDrag", "dragAmount", "updateProgressOnDrag-k-4lQ0M", "(J)V", "updateProgressWhileTouchUp", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "constraintlayout-compose_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class TransitionHandler {
    public static final int $stable = 8;
    private final MotionMeasurer motionMeasurer;
    private final MutableFloatState motionProgress;

    /* JADX INFO: renamed from: androidx.constraintlayout.compose.TransitionHandler$updateProgressWhileTouchUp$1, reason: invalid class name */
    /* JADX INFO: compiled from: TransitionHandler.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.constraintlayout.compose.TransitionHandler", f = "TransitionHandler.kt", i = {0}, l = {74}, m = "updateProgressWhileTouchUp", n = {"this"}, s = {"L$0"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TransitionHandler.this.updateProgressWhileTouchUp(this);
        }
    }

    public TransitionHandler(MotionMeasurer motionMeasurer, MutableFloatState mutableFloatState) {
        this.motionMeasurer = motionMeasurer;
        this.motionProgress = mutableFloatState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final androidx.constraintlayout.core.state.Transition getTransition() {
        return this.motionMeasurer.getTransition();
    }

    /* JADX INFO: renamed from: onAcceptFirstDownForOnSwipe-k-4lQ0M, reason: not valid java name */
    public final boolean m10156onAcceptFirstDownForOnSwipek4lQ0M(long offset) {
        return getTransition().isFirstDownAccepted(Offset.m6569getXimpl(offset), Offset.m6570getYimpl(offset));
    }

    /* JADX INFO: renamed from: updateProgressOnDrag-k-4lQ0M, reason: not valid java name */
    public final void m10158updateProgressOnDragk4lQ0M(long dragAmount) {
        this.motionProgress.setFloatValue(RangesKt.coerceIn(this.motionProgress.getFloatValue() + getTransition().dragToProgress(this.motionProgress.getFloatValue(), this.motionMeasurer.getLayoutCurrentWidth(), this.motionMeasurer.getLayoutCurrentHeight(), Offset.m6569getXimpl(dragAmount), Offset.m6570getYimpl(dragAmount)), 0.0f, 1.0f));
    }

    /* JADX INFO: renamed from: onTouchUp-sF-c-tU, reason: not valid java name */
    public final Object m10157onTouchUpsFctU(final long j, Continuation<? super Unit> continuation) {
        Object objWithFrameNanos = MonotonicFrameClockKt.withFrameNanos(new Function1<Long, Unit>() { // from class: androidx.constraintlayout.compose.TransitionHandler$onTouchUp$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Long l) {
                invoke(l.longValue());
                return Unit.INSTANCE;
            }

            public final void invoke(long j2) {
                this.this$0.getTransition().setTouchUp(this.this$0.motionProgress.getFloatValue(), j2, Velocity.m9925getXimpl(j), Velocity.m9926getYimpl(j));
            }
        }, continuation);
        return objWithFrameNanos == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithFrameNanos : Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object updateProgressWhileTouchUp(Continuation<? super Unit> continuation) {
        AnonymousClass1 anonymousClass1;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        Object objWithFrameNanos = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objWithFrameNanos);
            Function1<Long, Float> function1 = new Function1<Long, Float>() { // from class: androidx.constraintlayout.compose.TransitionHandler$updateProgressWhileTouchUp$newProgress$1
                {
                    super(1);
                }

                public final Float invoke(long j) {
                    return Float.valueOf(this.this$0.getTransition().getTouchUpProgress(j));
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Float invoke(Long l) {
                    return invoke(l.longValue());
                }
            };
            anonymousClass1.L$0 = this;
            anonymousClass1.label = 1;
            objWithFrameNanos = MonotonicFrameClockKt.withFrameNanos(function1, anonymousClass1);
            if (objWithFrameNanos == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            this = (TransitionHandler) anonymousClass1.L$0;
            ResultKt.throwOnFailure(objWithFrameNanos);
        }
        this.motionProgress.setFloatValue(((Number) objWithFrameNanos).floatValue());
        return Unit.INSTANCE;
    }

    public final boolean pendingProgressWhileTouchUp() {
        return getTransition().isTouchNotDone(this.motionProgress.getFloatValue());
    }
}
