package androidx.compose.material3;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.foundation.gestures.AnchoredDraggableKt;
import androidx.compose.foundation.gestures.AnchoredDraggableState;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.runtime.saveable.SaverScope;
import androidx.compose.ui.unit.Density;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: SheetDefaults.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0007\u0018\u0000 V2\u00020\u0001:\u0001VBU\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00030\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003¢\u0006\u0004\b\r\u0010\u000eBC\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00030\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003¢\u0006\u0004\b\r\u0010\u0011J\u0006\u0010!\u001a\u00020\u0006J\u000e\u0010&\u001a\u00020'H\u0086@¢\u0006\u0002\u0010(J\u000e\u0010)\u001a\u00020'H\u0086@¢\u0006\u0002\u0010(J\u000e\u0010*\u001a\u00020'H\u0086@¢\u0006\u0002\u0010(J\u000e\u0010+\u001a\u00020'H\u0086@¢\u0006\u0002\u0010(J&\u0010,\u001a\u00020'2\u0006\u0010\u001d\u001a\u00020\t2\f\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00060.H\u0080@¢\u0006\u0004\b/\u00100J\u0018\u00101\u001a\u00020'2\u0006\u0010\u001d\u001a\u00020\tH\u0080@¢\u0006\u0004\b2\u00103J\u0015\u0010B\u001a\u00020\u00062\u0006\u0010C\u001a\u00020\u0006H\u0000¢\u0006\u0002\bDJ \u0010E\u001a\u00020\u00062\u0006\u0010F\u001a\u00020G2\u0006\u0010H\u001a\u00020\u0006H\u0080@¢\u0006\u0004\bI\u0010JR\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R \u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00030\u000bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\f\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0013R\u0011\u0010\u001a\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u001d\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001cR\u0011\u0010\u001f\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0013R\u0011\u0010 \u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b \u0010\u0013R\u0011\u0010\"\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b#\u0010\u0013R\u0011\u0010$\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b%\u0010\u0013R \u00104\u001a\b\u0012\u0004\u0012\u00020\u000605X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R&\u0010:\u001a\b\u0012\u0004\u0012\u00020\t0;X\u0080\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b<\u0010=\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\u0014\u0010K\u001a\u00020\u00068@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bL\u0010MR \u0010N\u001a\b\u0012\u0004\u0012\u00020\u00060.X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010RR \u0010S\u001a\b\u0012\u0004\u0012\u00020\u00060.X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bT\u0010P\"\u0004\bU\u0010R¨\u0006W"}, d2 = {"Landroidx/compose/material3/SheetState;", "", "skipPartiallyExpanded", "", "positionalThreshold", "Lkotlin/Function0;", "", "velocityThreshold", "initialValue", "Landroidx/compose/material3/SheetValue;", "confirmValueChange", "Lkotlin/Function1;", "skipHiddenState", "<init>", "(ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/material3/SheetValue;Lkotlin/jvm/functions/Function1;Z)V", "density", "Landroidx/compose/ui/unit/Density;", "(ZLandroidx/compose/ui/unit/Density;Landroidx/compose/material3/SheetValue;Lkotlin/jvm/functions/Function1;Z)V", "getSkipPartiallyExpanded$material3", "()Z", "getPositionalThreshold$material3", "()Lkotlin/jvm/functions/Function0;", "getVelocityThreshold$material3", "getConfirmValueChange$material3", "()Lkotlin/jvm/functions/Function1;", "getSkipHiddenState$material3", "currentValue", "getCurrentValue", "()Landroidx/compose/material3/SheetValue;", "targetValue", "getTargetValue", "isVisible", "isAnimationRunning", "requireOffset", "hasExpandedState", "getHasExpandedState", "hasPartiallyExpandedState", "getHasPartiallyExpandedState", "expand", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "partialExpand", "show", "hide", "animateTo", "animationSpec", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "animateTo$material3", "(Landroidx/compose/material3/SheetValue;Landroidx/compose/animation/core/FiniteAnimationSpec;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "snapTo", "snapTo$material3", "(Landroidx/compose/material3/SheetValue;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "anchoredDraggableMotionSpec", "Landroidx/compose/animation/core/AnimationSpec;", "getAnchoredDraggableMotionSpec$material3", "()Landroidx/compose/animation/core/AnimationSpec;", "setAnchoredDraggableMotionSpec$material3", "(Landroidx/compose/animation/core/AnimationSpec;)V", "anchoredDraggableState", "Landroidx/compose/foundation/gestures/AnchoredDraggableState;", "getAnchoredDraggableState$material3$annotations", "()V", "getAnchoredDraggableState$material3", "()Landroidx/compose/foundation/gestures/AnchoredDraggableState;", "setAnchoredDraggableState$material3", "(Landroidx/compose/foundation/gestures/AnchoredDraggableState;)V", "newOffsetForDelta", "delta", "newOffsetForDelta$material3", "anchoredDrag", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "initialVelocity", "anchoredDrag$material3", "(Landroidx/compose/foundation/gestures/FlingBehavior;FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "offset", "getOffset$material3", "()F", "showMotionSpec", "getShowMotionSpec$material3", "()Landroidx/compose/animation/core/FiniteAnimationSpec;", "setShowMotionSpec$material3", "(Landroidx/compose/animation/core/FiniteAnimationSpec;)V", "hideMotionSpec", "getHideMotionSpec$material3", "setHideMotionSpec$material3", "Companion", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SheetState {
    public static final int $stable = 0;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private AnimationSpec<Float> anchoredDraggableMotionSpec;
    private AnchoredDraggableState<SheetValue> anchoredDraggableState;
    private final Function1<SheetValue, Boolean> confirmValueChange;
    private FiniteAnimationSpec<Float> hideMotionSpec;
    private final Function0<Float> positionalThreshold;
    private FiniteAnimationSpec<Float> showMotionSpec;
    private final boolean skipHiddenState;
    private final boolean skipPartiallyExpanded;
    private final Function0<Float> velocityThreshold;

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean _init_$lambda$0(SheetValue sheetValue) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean _init_$lambda$3(SheetValue sheetValue) {
        return true;
    }

    public static /* synthetic */ void getAnchoredDraggableState$material3$annotations() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SheetState(boolean z, Function0<Float> function0, Function0<Float> function1, SheetValue sheetValue, Function1<? super SheetValue, Boolean> function2, boolean z2) {
        this.skipPartiallyExpanded = z;
        this.positionalThreshold = function0;
        this.velocityThreshold = function1;
        this.confirmValueChange = function2;
        this.skipHiddenState = z2;
        if (z && sheetValue == SheetValue.PartiallyExpanded) {
            throw new IllegalArgumentException("The initial value must not be set to PartiallyExpanded if skipPartiallyExpanded is set to true.".toString());
        }
        if (z2 && sheetValue == SheetValue.Hidden) {
            throw new IllegalArgumentException("The initial value must not be set to Hidden if skipHiddenState is set to true.".toString());
        }
        this.anchoredDraggableMotionSpec = SheetDefaultsKt.getBottomSheetAnimationSpec();
        this.anchoredDraggableState = new AnchoredDraggableState<>(sheetValue, function2);
        this.showMotionSpec = AnimationSpecKt.snap$default(0, 1, null);
        this.hideMotionSpec = AnimationSpecKt.snap$default(0, 1, null);
    }

    /* JADX INFO: renamed from: getSkipPartiallyExpanded$material3, reason: from getter */
    public final boolean getSkipPartiallyExpanded() {
        return this.skipPartiallyExpanded;
    }

    public final Function0<Float> getPositionalThreshold$material3() {
        return this.positionalThreshold;
    }

    public final Function0<Float> getVelocityThreshold$material3() {
        return this.velocityThreshold;
    }

    public /* synthetic */ SheetState(boolean z, Function0 function0, Function0 function1, SheetValue sheetValue, Function1 function2, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, function0, function1, (i & 8) != 0 ? SheetValue.Hidden : sheetValue, (i & 16) != 0 ? new Function1() { // from class: androidx.compose.material3.SheetState$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(SheetState._init_$lambda$0((SheetValue) obj));
            }
        } : function2, (i & 32) != 0 ? false : z2);
    }

    public final Function1<SheetValue, Boolean> getConfirmValueChange$material3() {
        return this.confirmValueChange;
    }

    /* JADX INFO: renamed from: getSkipHiddenState$material3, reason: from getter */
    public final boolean getSkipHiddenState() {
        return this.skipHiddenState;
    }

    public final SheetValue getCurrentValue() {
        return this.anchoredDraggableState.getSettledValue();
    }

    public final SheetValue getTargetValue() {
        return this.anchoredDraggableState.getTargetValue();
    }

    public final boolean isVisible() {
        return this.anchoredDraggableState.getCurrentValue() != SheetValue.Hidden;
    }

    public final boolean isAnimationRunning() {
        return this.anchoredDraggableState.isAnimationRunning();
    }

    public final float requireOffset() {
        return this.anchoredDraggableState.requireOffset();
    }

    public final boolean getHasExpandedState() {
        return this.anchoredDraggableState.getAnchors().hasPositionFor(SheetValue.Expanded);
    }

    public final boolean getHasPartiallyExpandedState() {
        return this.anchoredDraggableState.getAnchors().hasPositionFor(SheetValue.PartiallyExpanded);
    }

    public final Object expand(Continuation<? super Unit> continuation) {
        if (!this.confirmValueChange.invoke(SheetValue.Expanded).booleanValue()) {
            return Unit.INSTANCE;
        }
        Object objAnimateTo$material3 = animateTo$material3(SheetValue.Expanded, this.showMotionSpec, continuation);
        return objAnimateTo$material3 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objAnimateTo$material3 : Unit.INSTANCE;
    }

    public final Object partialExpand(Continuation<? super Unit> continuation) {
        if (this.skipPartiallyExpanded) {
            throw new IllegalStateException("Attempted to animate to partial expanded when skipPartiallyExpanded was enabled. Set skipPartiallyExpanded to false to use this function.".toString());
        }
        if (!this.confirmValueChange.invoke(SheetValue.PartiallyExpanded).booleanValue()) {
            return Unit.INSTANCE;
        }
        Object objAnimateTo$material3 = animateTo$material3(SheetValue.PartiallyExpanded, this.hideMotionSpec, continuation);
        return objAnimateTo$material3 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objAnimateTo$material3 : Unit.INSTANCE;
    }

    public final Object show(Continuation<? super Unit> continuation) {
        SheetValue sheetValue = getHasPartiallyExpandedState() ? SheetValue.PartiallyExpanded : SheetValue.Expanded;
        if (!this.confirmValueChange.invoke(sheetValue).booleanValue()) {
            return Unit.INSTANCE;
        }
        Object objAnimateTo$material3 = animateTo$material3(sheetValue, this.showMotionSpec, continuation);
        return objAnimateTo$material3 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objAnimateTo$material3 : Unit.INSTANCE;
    }

    public final Object hide(Continuation<? super Unit> continuation) {
        if (this.skipHiddenState) {
            throw new IllegalStateException("Attempted to animate to hidden when skipHiddenState was enabled. Set skipHiddenState to false to use this function.".toString());
        }
        if (!this.confirmValueChange.invoke(SheetValue.Hidden).booleanValue()) {
            return Unit.INSTANCE;
        }
        Object objAnimateTo$material3 = animateTo$material3(SheetValue.Hidden, this.hideMotionSpec, continuation);
        return objAnimateTo$material3 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objAnimateTo$material3 : Unit.INSTANCE;
    }

    public final Object animateTo$material3(SheetValue sheetValue, FiniteAnimationSpec<Float> finiteAnimationSpec, Continuation<? super Unit> continuation) {
        Object objAnimateTo = AnchoredDraggableKt.animateTo(this.anchoredDraggableState, sheetValue, finiteAnimationSpec, continuation);
        return objAnimateTo == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objAnimateTo : Unit.INSTANCE;
    }

    public final Object snapTo$material3(SheetValue sheetValue, Continuation<? super Unit> continuation) {
        Object objSnapTo = AnchoredDraggableKt.snapTo(this.anchoredDraggableState, sheetValue, continuation);
        return objSnapTo == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objSnapTo : Unit.INSTANCE;
    }

    public final AnimationSpec<Float> getAnchoredDraggableMotionSpec$material3() {
        return this.anchoredDraggableMotionSpec;
    }

    public final void setAnchoredDraggableMotionSpec$material3(AnimationSpec<Float> animationSpec) {
        this.anchoredDraggableMotionSpec = animationSpec;
    }

    public final AnchoredDraggableState<SheetValue> getAnchoredDraggableState$material3() {
        return this.anchoredDraggableState;
    }

    public final void setAnchoredDraggableState$material3(AnchoredDraggableState<SheetValue> anchoredDraggableState) {
        this.anchoredDraggableState = anchoredDraggableState;
    }

    public final float newOffsetForDelta$material3(float delta) {
        return RangesKt.coerceIn((Float.isNaN(getOffset$material3()) ? 0.0f : getOffset$material3()) + delta, this.anchoredDraggableState.getAnchors().minPosition(), this.anchoredDraggableState.getAnchors().maxPosition());
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object anchoredDrag$material3(FlingBehavior flingBehavior, float f, Continuation<? super Float> continuation) {
        SheetState$anchoredDrag$1 sheetState$anchoredDrag$1;
        Ref.FloatRef floatRef;
        if (continuation instanceof SheetState$anchoredDrag$1) {
            sheetState$anchoredDrag$1 = (SheetState$anchoredDrag$1) continuation;
            if ((sheetState$anchoredDrag$1.label & Integer.MIN_VALUE) != 0) {
                sheetState$anchoredDrag$1.label -= Integer.MIN_VALUE;
            } else {
                sheetState$anchoredDrag$1 = new SheetState$anchoredDrag$1(this, continuation);
            }
        } else {
            sheetState$anchoredDrag$1 = new SheetState$anchoredDrag$1(this, continuation);
        }
        SheetState$anchoredDrag$1 sheetState$anchoredDrag$2 = sheetState$anchoredDrag$1;
        Object obj = sheetState$anchoredDrag$2.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = sheetState$anchoredDrag$2.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Ref.FloatRef floatRef2 = new Ref.FloatRef();
            AnchoredDraggableState<SheetValue> anchoredDraggableState = this.anchoredDraggableState;
            SheetState$anchoredDrag$2 sheetState$anchoredDrag$3 = new SheetState$anchoredDrag$2(floatRef2, flingBehavior, this, f, null);
            floatRef = floatRef2;
            sheetState$anchoredDrag$2.L$0 = floatRef;
            sheetState$anchoredDrag$2.label = 1;
            if (AnchoredDraggableState.anchoredDrag$default(anchoredDraggableState, null, sheetState$anchoredDrag$3, sheetState$anchoredDrag$2, 1, null) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            floatRef = (Ref.FloatRef) sheetState$anchoredDrag$2.L$0;
            ResultKt.throwOnFailure(obj);
        }
        return Boxing.boxFloat(floatRef.element);
    }

    public final float getOffset$material3() {
        return this.anchoredDraggableState.getOffset();
    }

    public final FiniteAnimationSpec<Float> getShowMotionSpec$material3() {
        return this.showMotionSpec;
    }

    public final void setShowMotionSpec$material3(FiniteAnimationSpec<Float> finiteAnimationSpec) {
        this.showMotionSpec = finiteAnimationSpec;
    }

    public final FiniteAnimationSpec<Float> getHideMotionSpec$material3() {
        return this.hideMotionSpec;
    }

    public final void setHideMotionSpec$material3(FiniteAnimationSpec<Float> finiteAnimationSpec) {
        this.hideMotionSpec = finiteAnimationSpec;
    }

    /* JADX INFO: compiled from: SheetDefaults.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JR\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00052\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\t0\u000f2\u0006\u0010\u0010\u001a\u00020\tJ@\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00052\u0006\u0010\b\u001a\u00020\t2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\t0\u000f2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0010\u001a\u00020\tH\u0007¨\u0006\u0013"}, d2 = {"Landroidx/compose/material3/SheetState$Companion;", "", "<init>", "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/material3/SheetState;", "Landroidx/compose/material3/SheetValue;", "skipPartiallyExpanded", "", "positionalThreshold", "Lkotlin/Function0;", "", "velocityThreshold", "confirmValueChange", "Lkotlin/Function1;", "skipHiddenState", "density", "Landroidx/compose/ui/unit/Density;", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Saver<SheetState, SheetValue> Saver(final boolean skipPartiallyExpanded, final Function0<Float> positionalThreshold, final Function0<Float> velocityThreshold, final Function1<? super SheetValue, Boolean> confirmValueChange, final boolean skipHiddenState) {
            return SaverKt.Saver(new Function2() { // from class: androidx.compose.material3.SheetState$Companion$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SheetState.Companion.Saver$lambda$0((SaverScope) obj, (SheetState) obj2);
                }
            }, new Function1() { // from class: androidx.compose.material3.SheetState$Companion$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return SheetState.Companion.Saver$lambda$1(skipPartiallyExpanded, positionalThreshold, velocityThreshold, confirmValueChange, skipHiddenState, (SheetValue) obj);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final SheetValue Saver$lambda$0(SaverScope saverScope, SheetState sheetState) {
            return sheetState.getCurrentValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final SheetState Saver$lambda$1(boolean z, Function0 function0, Function0 function1, Function1 function2, boolean z2, SheetValue sheetValue) {
            if (z && sheetValue == SheetValue.PartiallyExpanded) {
                sheetValue = SheetValue.Expanded;
            }
            return new SheetState(z, function0, function1, sheetValue, function2, z2);
        }

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility.")
        public final /* synthetic */ Saver Saver(boolean skipPartiallyExpanded, Function1 confirmValueChange, final Density density, boolean skipHiddenState) {
            return Saver(skipPartiallyExpanded, new Function0() { // from class: androidx.compose.material3.SheetState$Companion$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return Float.valueOf(SheetState.Companion.Saver$lambda$2(density));
                }
            }, new Function0() { // from class: androidx.compose.material3.SheetState$Companion$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return Float.valueOf(SheetState.Companion.Saver$lambda$3(density));
                }
            }, confirmValueChange, skipHiddenState);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final float Saver$lambda$2(Density density) {
            return density.mo754toPx0680j_4(BottomSheetDefaults.INSTANCE.m2814getPositionalThresholdD9Ej5fM$material3());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final float Saver$lambda$3(Density density) {
            return density.mo754toPx0680j_4(BottomSheetDefaults.INSTANCE.m2817getVelocityThresholdD9Ej5fM$material3());
        }
    }

    public /* synthetic */ SheetState(boolean z, Density density, SheetValue sheetValue, Function1 function1, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, density, (i & 4) != 0 ? SheetValue.Hidden : sheetValue, (i & 8) != 0 ? new Function1() { // from class: androidx.compose.material3.SheetState$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(SheetState._init_$lambda$3((SheetValue) obj));
            }
        } : function1, (i & 16) != 0 ? false : z2);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility.")
    public /* synthetic */ SheetState(boolean z, final Density density, SheetValue sheetValue, Function1 function1, boolean z2) {
        this(z, new Function0() { // from class: androidx.compose.material3.SheetState$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Float.valueOf(SheetState._init_$lambda$4(density));
            }
        }, new Function0() { // from class: androidx.compose.material3.SheetState$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Float.valueOf(SheetState._init_$lambda$5(density));
            }
        }, sheetValue, function1, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float _init_$lambda$4(Density density) {
        return density.mo754toPx0680j_4(BottomSheetDefaults.INSTANCE.m2814getPositionalThresholdD9Ej5fM$material3());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float _init_$lambda$5(Density density) {
        return density.mo754toPx0680j_4(BottomSheetDefaults.INSTANCE.m2817getVelocityThresholdD9Ej5fM$material3());
    }
}
