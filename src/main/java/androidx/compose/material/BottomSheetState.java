package androidx.compose.material;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.runtime.saveable.SaverScope;
import androidx.compose.ui.unit.Density;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: BottomSheetScaffold.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0002\n\u0002\b\r\b\u0007\u0018\u0000 .2\u00020\u0001:\u0001.B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0014\b\u0002\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u001a\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\u00032\u0006\u0010 \u001a\u00020\u0003H\u0007J\u000e\u0010!\u001a\u00020\"H\u0086@¢\u0006\u0002\u0010#J\u000e\u0010$\u001a\u00020\"H\u0086@¢\u0006\u0002\u0010#J\u0006\u0010%\u001a\u00020\bJ\"\u0010&\u001a\u00020\"2\u0006\u0010'\u001a\u00020\u00032\b\b\u0002\u0010(\u001a\u00020\bH\u0080@¢\u0006\u0004\b)\u0010*J\u0018\u0010+\u001a\u00020\"2\u0006\u0010'\u001a\u00020\u0003H\u0080@¢\u0006\u0004\b,\u0010-R\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u000fX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0015\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0014R\u0011\u0010\u0017\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0019\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0018R\u001a\u0010\u001a\u001a\u00020\b8GX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e¨\u0006/"}, d2 = {"Landroidx/compose/material/BottomSheetState;", "", "initialValue", "Landroidx/compose/material/BottomSheetValue;", "density", "Landroidx/compose/ui/unit/Density;", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "confirmValueChange", "Lkotlin/Function1;", "", "<init>", "(Landroidx/compose/material/BottomSheetValue;Landroidx/compose/ui/unit/Density;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function1;)V", "anchoredDraggableState", "Landroidx/compose/material/AnchoredDraggableState;", "getAnchoredDraggableState$material", "()Landroidx/compose/material/AnchoredDraggableState;", "currentValue", "getCurrentValue", "()Landroidx/compose/material/BottomSheetValue;", "targetValue", "getTargetValue", "isExpanded", "()Z", "isCollapsed", "progress", "getProgress$annotations", "()V", "getProgress", "()F", TypedValues.TransitionType.S_FROM, TypedValues.TransitionType.S_TO, "expand", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "collapse", "requireOffset", "animateTo", "target", "velocity", "animateTo$material", "(Landroidx/compose/material/BottomSheetValue;FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "snapTo", "snapTo$material", "(Landroidx/compose/material/BottomSheetValue;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "material"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class BottomSheetState {
    public static final int $stable = 0;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final AnchoredDraggableState<BottomSheetValue> anchoredDraggableState;

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean _init_$lambda$0(BottomSheetValue bottomSheetValue) {
        return true;
    }

    @Deprecated(message = "Please use the progress function to query progress explicitly between targets.", replaceWith = @ReplaceWith(expression = "progress(from = , to = )", imports = {}))
    public static /* synthetic */ void getProgress$annotations() {
    }

    public BottomSheetState(BottomSheetValue bottomSheetValue, final Density density, AnimationSpec<Float> animationSpec, Function1<? super BottomSheetValue, Boolean> function1) {
        this.anchoredDraggableState = new AnchoredDraggableState<>(bottomSheetValue, new Function1() { // from class: androidx.compose.material.BottomSheetState$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Float.valueOf(BottomSheetState.anchoredDraggableState$lambda$0(density, ((Float) obj).floatValue()));
            }
        }, new Function0() { // from class: androidx.compose.material.BottomSheetState$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Float.valueOf(BottomSheetState.anchoredDraggableState$lambda$1(density));
            }
        }, animationSpec, function1);
    }

    public /* synthetic */ BottomSheetState(BottomSheetValue bottomSheetValue, Density density, AnimationSpec animationSpec, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(bottomSheetValue, density, (i & 4) != 0 ? BottomSheetScaffoldDefaults.INSTANCE.getAnimationSpec() : animationSpec, (i & 8) != 0 ? new Function1() { // from class: androidx.compose.material.BottomSheetState$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(BottomSheetState._init_$lambda$0((BottomSheetValue) obj));
            }
        } : function1);
    }

    public final AnchoredDraggableState<BottomSheetValue> getAnchoredDraggableState$material() {
        return this.anchoredDraggableState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float anchoredDraggableState$lambda$0(Density density, float f) {
        return density.mo754toPx0680j_4(BottomSheetScaffoldKt.BottomSheetScaffoldPositionalThreshold);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float anchoredDraggableState$lambda$1(Density density) {
        return density.mo754toPx0680j_4(BottomSheetScaffoldKt.BottomSheetScaffoldVelocityThreshold);
    }

    public final BottomSheetValue getCurrentValue() {
        return this.anchoredDraggableState.getCurrentValue();
    }

    public final BottomSheetValue getTargetValue() {
        return this.anchoredDraggableState.getTargetValue();
    }

    public final boolean isExpanded() {
        return this.anchoredDraggableState.getCurrentValue() == BottomSheetValue.Expanded;
    }

    public final boolean isCollapsed() {
        return this.anchoredDraggableState.getCurrentValue() == BottomSheetValue.Collapsed;
    }

    public final float getProgress() {
        return this.anchoredDraggableState.getProgress();
    }

    public final float progress(BottomSheetValue from, BottomSheetValue to) {
        float fPositionOf = this.anchoredDraggableState.getAnchors().positionOf(from);
        float fPositionOf2 = this.anchoredDraggableState.getAnchors().positionOf(to);
        float fCoerceIn = (RangesKt.coerceIn(this.anchoredDraggableState.getOffset(), Math.min(fPositionOf, fPositionOf2), Math.max(fPositionOf, fPositionOf2)) - fPositionOf) / (fPositionOf2 - fPositionOf);
        if (Float.isNaN(fCoerceIn)) {
            return 1.0f;
        }
        return Math.abs(fCoerceIn);
    }

    public final Object expand(Continuation<? super Unit> continuation) {
        BottomSheetValue bottomSheetValue;
        if (this.anchoredDraggableState.getAnchors().hasAnchorFor(BottomSheetValue.Expanded)) {
            bottomSheetValue = BottomSheetValue.Expanded;
        } else {
            bottomSheetValue = BottomSheetValue.Collapsed;
        }
        Object objAnimateTo$default = AnchoredDraggableKt.animateTo$default(this.anchoredDraggableState, bottomSheetValue, 0.0f, continuation, 2, null);
        return objAnimateTo$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objAnimateTo$default : Unit.INSTANCE;
    }

    public final Object collapse(Continuation<? super Unit> continuation) {
        Object objAnimateTo$default = AnchoredDraggableKt.animateTo$default(this.anchoredDraggableState, BottomSheetValue.Collapsed, 0.0f, continuation, 2, null);
        return objAnimateTo$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objAnimateTo$default : Unit.INSTANCE;
    }

    public final float requireOffset() {
        return this.anchoredDraggableState.requireOffset();
    }

    public static /* synthetic */ Object animateTo$material$default(BottomSheetState bottomSheetState, BottomSheetValue bottomSheetValue, float f, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            f = bottomSheetState.anchoredDraggableState.getLastVelocity();
        }
        return bottomSheetState.animateTo$material(bottomSheetValue, f, continuation);
    }

    public final Object animateTo$material(BottomSheetValue bottomSheetValue, float f, Continuation<? super Unit> continuation) {
        Object objAnimateTo = AnchoredDraggableKt.animateTo(this.anchoredDraggableState, bottomSheetValue, f, continuation);
        return objAnimateTo == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objAnimateTo : Unit.INSTANCE;
    }

    public final Object snapTo$material(BottomSheetValue bottomSheetValue, Continuation<? super Unit> continuation) {
        Object objSnapTo = AnchoredDraggableKt.snapTo(this.anchoredDraggableState, bottomSheetValue, continuation);
        return objSnapTo == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objSnapTo : Unit.INSTANCE;
    }

    /* JADX INFO: compiled from: BottomSheetScaffold.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J:\u0010\u0004\u001a\f\u0012\u0004\u0012\u00020\u0006\u0012\u0002\b\u00030\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b2\u0006\u0010\u000e\u001a\u00020\u000f¨\u0006\u0010"}, d2 = {"Landroidx/compose/material/BottomSheetState$Companion;", "", "<init>", "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/material/BottomSheetState;", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "confirmStateChange", "Lkotlin/Function1;", "Landroidx/compose/material/BottomSheetValue;", "", "density", "Landroidx/compose/ui/unit/Density;", "material"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Saver<BottomSheetState, ?> Saver(final AnimationSpec<Float> animationSpec, final Function1<? super BottomSheetValue, Boolean> confirmStateChange, final Density density) {
            return SaverKt.Saver(new Function2() { // from class: androidx.compose.material.BottomSheetState$Companion$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BottomSheetState.Companion.Saver$lambda$0((SaverScope) obj, (BottomSheetState) obj2);
                }
            }, new Function1() { // from class: androidx.compose.material.BottomSheetState$Companion$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return BottomSheetState.Companion.Saver$lambda$1(density, animationSpec, confirmStateChange, (BottomSheetValue) obj);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final BottomSheetValue Saver$lambda$0(SaverScope saverScope, BottomSheetState bottomSheetState) {
            return bottomSheetState.getAnchoredDraggableState$material().getCurrentValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final BottomSheetState Saver$lambda$1(Density density, AnimationSpec animationSpec, Function1 function1, BottomSheetValue bottomSheetValue) {
            return new BottomSheetState(bottomSheetValue, density, animationSpec, function1);
        }
    }
}
