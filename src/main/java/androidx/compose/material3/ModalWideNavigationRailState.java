package androidx.compose.material3;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.foundation.gestures.AnchoredDraggableKt;
import androidx.compose.foundation.gestures.AnchoredDraggableState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

/* JADX INFO: compiled from: WideNavigationRailState.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\b\u0001\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0017\u001a\u00020\u0018H\u0096@¢\u0006\u0002\u0010\u0019J\u000e\u0010\u001a\u001a\u00020\u0018H\u0096@¢\u0006\u0002\u0010\u0019J\u000e\u0010\u001b\u001a\u00020\u0018H\u0096@¢\u0006\u0002\u0010\u0019J\u0016\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u0012\u001a\u00020\fH\u0096@¢\u0006\u0002\u0010\u001dJ&\u0010!\u001a\u00020\u00182\u0006\u0010\u0012\u001a\u00020\f2\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0082@¢\u0006\u0002\u0010\"R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0011R\u0014\u0010\u0014\u001a\u00020\u00158VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0016R\u0011\u0010\u001e\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u001f\u0010 ¨\u0006#"}, d2 = {"Landroidx/compose/material3/ModalWideNavigationRailState;", "Landroidx/compose/material3/WideNavigationRailState;", "state", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "<init>", "(Landroidx/compose/material3/WideNavigationRailState;Landroidx/compose/animation/core/AnimationSpec;)V", "getAnimationSpec", "()Landroidx/compose/animation/core/AnimationSpec;", "anchoredDraggableState", "Landroidx/compose/foundation/gestures/AnchoredDraggableState;", "Landroidx/compose/material3/WideNavigationRailValue;", "getAnchoredDraggableState$material3", "()Landroidx/compose/foundation/gestures/AnchoredDraggableState;", "currentValue", "getCurrentValue", "()Landroidx/compose/material3/WideNavigationRailValue;", "targetValue", "getTargetValue", "isAnimating", "", "()Z", "expand", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "collapse", "toggle", "snapTo", "(Landroidx/compose/material3/WideNavigationRailValue;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "currentOffset", "getCurrentOffset", "()F", "animateTo", "(Landroidx/compose/material3/WideNavigationRailValue;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ModalWideNavigationRailState implements WideNavigationRailState {
    public static final int $stable = 8;
    private final /* synthetic */ WideNavigationRailState $$delegate_0;
    private final AnchoredDraggableState<WideNavigationRailValue> anchoredDraggableState;
    private final AnimationSpec<Float> animationSpec;

    public ModalWideNavigationRailState(WideNavigationRailState wideNavigationRailState, AnimationSpec<Float> animationSpec) {
        this.$$delegate_0 = wideNavigationRailState;
        this.animationSpec = animationSpec;
        this.anchoredDraggableState = new AnchoredDraggableState<>(wideNavigationRailState.getTargetValue());
    }

    public final AnimationSpec<Float> getAnimationSpec() {
        return this.animationSpec;
    }

    public final AnchoredDraggableState<WideNavigationRailValue> getAnchoredDraggableState$material3() {
        return this.anchoredDraggableState;
    }

    @Override // androidx.compose.material3.WideNavigationRailState
    public WideNavigationRailValue getCurrentValue() {
        return this.anchoredDraggableState.getSettledValue();
    }

    @Override // androidx.compose.material3.WideNavigationRailState
    public WideNavigationRailValue getTargetValue() {
        return this.anchoredDraggableState.getTargetValue();
    }

    @Override // androidx.compose.material3.WideNavigationRailState
    public boolean isAnimating() {
        return this.anchoredDraggableState.isAnimationRunning();
    }

    @Override // androidx.compose.material3.WideNavigationRailState
    public Object expand(Continuation<? super Unit> continuation) {
        Object objAnimateTo$default = animateTo$default(this, WideNavigationRailValue.Expanded, null, continuation, 2, null);
        return objAnimateTo$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objAnimateTo$default : Unit.INSTANCE;
    }

    @Override // androidx.compose.material3.WideNavigationRailState
    public Object collapse(Continuation<? super Unit> continuation) {
        Object objAnimateTo$default = animateTo$default(this, WideNavigationRailValue.Collapsed, null, continuation, 2, null);
        return objAnimateTo$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objAnimateTo$default : Unit.INSTANCE;
    }

    @Override // androidx.compose.material3.WideNavigationRailState
    public Object toggle(Continuation<? super Unit> continuation) {
        Object objAnimateTo$default = animateTo$default(this, WideNavigationRailStateKt.not(getTargetValue()), null, continuation, 2, null);
        return objAnimateTo$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objAnimateTo$default : Unit.INSTANCE;
    }

    @Override // androidx.compose.material3.WideNavigationRailState
    public Object snapTo(WideNavigationRailValue wideNavigationRailValue, Continuation<? super Unit> continuation) {
        Object objSnapTo = AnchoredDraggableKt.snapTo(this.anchoredDraggableState, wideNavigationRailValue, continuation);
        return objSnapTo == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objSnapTo : Unit.INSTANCE;
    }

    public final float getCurrentOffset() {
        return this.anchoredDraggableState.getOffset();
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ Object animateTo$default(ModalWideNavigationRailState modalWideNavigationRailState, WideNavigationRailValue wideNavigationRailValue, AnimationSpec animationSpec, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            animationSpec = modalWideNavigationRailState.animationSpec;
        }
        return modalWideNavigationRailState.animateTo(wideNavigationRailValue, animationSpec, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object animateTo(WideNavigationRailValue wideNavigationRailValue, AnimationSpec<Float> animationSpec, Continuation<? super Unit> continuation) {
        Object objAnimateTo = AnchoredDraggableKt.animateTo(this.anchoredDraggableState, wideNavigationRailValue, animationSpec, continuation);
        return objAnimateTo == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objAnimateTo : Unit.INSTANCE;
    }
}
