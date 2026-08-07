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

/* JADX INFO: compiled from: ModalBottomSheet.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0002\n\u0002\b\u0012\b\u0007\u0018\u0000 82\u00020\u0001:\u00018BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b0\u0007\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\b\b\u0002\u0010\f\u001a\u00020\b¢\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u001c\u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020\u0003H\u0007J\u000e\u0010&\u001a\u00020'H\u0086@¢\u0006\u0002\u0010(J\u0010\u0010)\u001a\u00020'H\u0080@¢\u0006\u0004\b*\u0010(J\u000e\u0010+\u001a\u00020'H\u0086@¢\u0006\u0002\u0010(J\u0010\u0010,\u001a\u00020'H\u0080@¢\u0006\u0004\b-\u0010(J\"\u0010.\u001a\u00020'2\u0006\u0010/\u001a\u00020\u00032\b\b\u0002\u00100\u001a\u00020\u000bH\u0080@¢\u0006\u0004\b1\u00102J\u0018\u00103\u001a\u00020'2\u0006\u0010/\u001a\u00020\u0003H\u0080@¢\u0006\u0004\b4\u00105J\r\u00106\u001a\u00020\u000bH\u0000¢\u0006\u0002\b7R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\f\u001a\u00020\bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\u0014X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0017\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u001a\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0019R\u001a\u0010\u001c\u001a\u00020\u000b8GX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0011\u0010#\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b#\u0010\u0012R\u0014\u0010$\u001a\u00020\b8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b%\u0010\u0012¨\u00069"}, d2 = {"Landroidx/compose/material/ModalBottomSheetState;", "", "initialValue", "Landroidx/compose/material/ModalBottomSheetValue;", "density", "Landroidx/compose/ui/unit/Density;", "confirmValueChange", "Lkotlin/Function1;", "", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "isSkipHalfExpanded", "<init>", "(Landroidx/compose/material/ModalBottomSheetValue;Landroidx/compose/ui/unit/Density;Lkotlin/jvm/functions/Function1;Landroidx/compose/animation/core/AnimationSpec;Z)V", "getAnimationSpec$material", "()Landroidx/compose/animation/core/AnimationSpec;", "isSkipHalfExpanded$material", "()Z", "anchoredDraggableState", "Landroidx/compose/material/AnchoredDraggableState;", "getAnchoredDraggableState$material", "()Landroidx/compose/material/AnchoredDraggableState;", "currentValue", "getCurrentValue", "()Landroidx/compose/material/ModalBottomSheetValue;", "targetValue", "getTargetValue", "progress", "getProgress$annotations", "()V", "getProgress", "()F", TypedValues.TransitionType.S_FROM, TypedValues.TransitionType.S_TO, "isVisible", "hasHalfExpandedState", "getHasHalfExpandedState$material", "show", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "halfExpand", "halfExpand$material", "hide", "expand", "expand$material", "animateTo", "target", "velocity", "animateTo$material", "(Landroidx/compose/material/ModalBottomSheetValue;FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "snapTo", "snapTo$material", "(Landroidx/compose/material/ModalBottomSheetValue;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requireOffset", "requireOffset$material", "Companion", "material"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ModalBottomSheetState {
    private final AnchoredDraggableState<ModalBottomSheetValue> anchoredDraggableState;
    private final AnimationSpec<Float> animationSpec;
    private final boolean isSkipHalfExpanded;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: compiled from: ModalBottomSheet.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ModalBottomSheetValue.values().length];
            try {
                iArr[ModalBottomSheetValue.Hidden.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean _init_$lambda$0(ModalBottomSheetValue modalBottomSheetValue) {
        return true;
    }

    @Deprecated(message = "Please use the progress function to query progress explicitly between targets.", replaceWith = @ReplaceWith(expression = "progress(from = , to = )", imports = {}))
    public static /* synthetic */ void getProgress$annotations() {
    }

    public ModalBottomSheetState(ModalBottomSheetValue modalBottomSheetValue, final Density density, Function1<? super ModalBottomSheetValue, Boolean> function1, AnimationSpec<Float> animationSpec, boolean z) {
        this.animationSpec = animationSpec;
        this.isSkipHalfExpanded = z;
        this.anchoredDraggableState = new AnchoredDraggableState<>(modalBottomSheetValue, new Function1() { // from class: androidx.compose.material.ModalBottomSheetState$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Float.valueOf(ModalBottomSheetState.anchoredDraggableState$lambda$0(density, ((Float) obj).floatValue()));
            }
        }, new Function0() { // from class: androidx.compose.material.ModalBottomSheetState$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Float.valueOf(ModalBottomSheetState.anchoredDraggableState$lambda$1(density));
            }
        }, animationSpec, function1);
        if (z && modalBottomSheetValue == ModalBottomSheetValue.HalfExpanded) {
            throw new IllegalArgumentException("The initial value must not be set to HalfExpanded if skipHalfExpanded is set to true.".toString());
        }
    }

    public /* synthetic */ ModalBottomSheetState(ModalBottomSheetValue modalBottomSheetValue, Density density, Function1 function1, AnimationSpec animationSpec, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(modalBottomSheetValue, density, (i & 4) != 0 ? new Function1() { // from class: androidx.compose.material.ModalBottomSheetState$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(ModalBottomSheetState._init_$lambda$0((ModalBottomSheetValue) obj));
            }
        } : function1, (i & 8) != 0 ? ModalBottomSheetDefaults.INSTANCE.getAnimationSpec() : animationSpec, (i & 16) != 0 ? false : z);
    }

    public final AnimationSpec<Float> getAnimationSpec$material() {
        return this.animationSpec;
    }

    /* JADX INFO: renamed from: isSkipHalfExpanded$material, reason: from getter */
    public final boolean getIsSkipHalfExpanded() {
        return this.isSkipHalfExpanded;
    }

    public final AnchoredDraggableState<ModalBottomSheetValue> getAnchoredDraggableState$material() {
        return this.anchoredDraggableState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float anchoredDraggableState$lambda$0(Density density, float f) {
        return density.mo754toPx0680j_4(ModalBottomSheetKt.ModalBottomSheetPositionalThreshold);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float anchoredDraggableState$lambda$1(Density density) {
        return density.mo754toPx0680j_4(ModalBottomSheetKt.ModalBottomSheetVelocityThreshold);
    }

    public final ModalBottomSheetValue getCurrentValue() {
        return this.anchoredDraggableState.getCurrentValue();
    }

    public final ModalBottomSheetValue getTargetValue() {
        return this.anchoredDraggableState.getTargetValue();
    }

    public final float getProgress() {
        return this.anchoredDraggableState.getProgress();
    }

    public final float progress(ModalBottomSheetValue from, ModalBottomSheetValue to) {
        float fPositionOf = this.anchoredDraggableState.getAnchors().positionOf(from);
        float fPositionOf2 = this.anchoredDraggableState.getAnchors().positionOf(to);
        float fCoerceIn = (RangesKt.coerceIn(this.anchoredDraggableState.getOffset(), Math.min(fPositionOf, fPositionOf2), Math.max(fPositionOf, fPositionOf2)) - fPositionOf) / (fPositionOf2 - fPositionOf);
        if (Float.isNaN(fCoerceIn)) {
            return 1.0f;
        }
        return Math.abs(fCoerceIn);
    }

    public final boolean isVisible() {
        return this.anchoredDraggableState.getCurrentValue() != ModalBottomSheetValue.Hidden;
    }

    public final boolean getHasHalfExpandedState$material() {
        return this.anchoredDraggableState.getAnchors().hasAnchorFor(ModalBottomSheetValue.HalfExpanded);
    }

    public final Object show(Continuation<? super Unit> continuation) {
        ModalBottomSheetValue modalBottomSheetValue;
        boolean zHasAnchorFor = this.anchoredDraggableState.getAnchors().hasAnchorFor(ModalBottomSheetValue.Expanded);
        if (WhenMappings.$EnumSwitchMapping$0[getCurrentValue().ordinal()] == 1) {
            modalBottomSheetValue = getHasHalfExpandedState$material() ? ModalBottomSheetValue.HalfExpanded : ModalBottomSheetValue.Expanded;
        } else {
            modalBottomSheetValue = zHasAnchorFor ? ModalBottomSheetValue.Expanded : ModalBottomSheetValue.Hidden;
        }
        Object objAnimateTo$material$default = animateTo$material$default(this, modalBottomSheetValue, 0.0f, continuation, 2, null);
        return objAnimateTo$material$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objAnimateTo$material$default : Unit.INSTANCE;
    }

    public final Object halfExpand$material(Continuation<? super Unit> continuation) {
        if (!getHasHalfExpandedState$material()) {
            return Unit.INSTANCE;
        }
        Object objAnimateTo$material$default = animateTo$material$default(this, ModalBottomSheetValue.HalfExpanded, 0.0f, continuation, 2, null);
        return objAnimateTo$material$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objAnimateTo$material$default : Unit.INSTANCE;
    }

    public final Object hide(Continuation<? super Unit> continuation) {
        Object objAnimateTo$material$default = animateTo$material$default(this, ModalBottomSheetValue.Hidden, 0.0f, continuation, 2, null);
        return objAnimateTo$material$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objAnimateTo$material$default : Unit.INSTANCE;
    }

    public final Object expand$material(Continuation<? super Unit> continuation) {
        if (!this.anchoredDraggableState.getAnchors().hasAnchorFor(ModalBottomSheetValue.Expanded)) {
            return Unit.INSTANCE;
        }
        Object objAnimateTo$material$default = animateTo$material$default(this, ModalBottomSheetValue.Expanded, 0.0f, continuation, 2, null);
        return objAnimateTo$material$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objAnimateTo$material$default : Unit.INSTANCE;
    }

    public static /* synthetic */ Object animateTo$material$default(ModalBottomSheetState modalBottomSheetState, ModalBottomSheetValue modalBottomSheetValue, float f, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            f = modalBottomSheetState.anchoredDraggableState.getLastVelocity();
        }
        return modalBottomSheetState.animateTo$material(modalBottomSheetValue, f, continuation);
    }

    public final Object animateTo$material(ModalBottomSheetValue modalBottomSheetValue, float f, Continuation<? super Unit> continuation) {
        Object objAnimateTo = AnchoredDraggableKt.animateTo(this.anchoredDraggableState, modalBottomSheetValue, f, continuation);
        return objAnimateTo == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objAnimateTo : Unit.INSTANCE;
    }

    public final Object snapTo$material(ModalBottomSheetValue modalBottomSheetValue, Continuation<? super Unit> continuation) {
        Object objSnapTo = AnchoredDraggableKt.snapTo(this.anchoredDraggableState, modalBottomSheetValue, continuation);
        return objSnapTo == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objSnapTo : Unit.INSTANCE;
    }

    public final float requireOffset$material() {
        return this.anchoredDraggableState.requireOffset();
    }

    /* JADX INFO: compiled from: ModalBottomSheet.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JB\u0010\u0004\u001a\f\u0012\u0004\u0012\u00020\u0006\u0012\u0002\b\u00030\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0010¨\u0006\u0011"}, d2 = {"Landroidx/compose/material/ModalBottomSheetState$Companion;", "", "<init>", "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/material/ModalBottomSheetState;", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "confirmValueChange", "Lkotlin/Function1;", "Landroidx/compose/material/ModalBottomSheetValue;", "", "skipHalfExpanded", "density", "Landroidx/compose/ui/unit/Density;", "material"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Saver<ModalBottomSheetState, ?> Saver(final AnimationSpec<Float> animationSpec, final Function1<? super ModalBottomSheetValue, Boolean> confirmValueChange, final boolean skipHalfExpanded, final Density density) {
            return SaverKt.Saver(new Function2() { // from class: androidx.compose.material.ModalBottomSheetState$Companion$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ModalBottomSheetState.Companion.Saver$lambda$0((SaverScope) obj, (ModalBottomSheetState) obj2);
                }
            }, new Function1() { // from class: androidx.compose.material.ModalBottomSheetState$Companion$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return ModalBottomSheetState.Companion.Saver$lambda$1(density, confirmValueChange, animationSpec, skipHalfExpanded, (ModalBottomSheetValue) obj);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final ModalBottomSheetValue Saver$lambda$0(SaverScope saverScope, ModalBottomSheetState modalBottomSheetState) {
            return modalBottomSheetState.getCurrentValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final ModalBottomSheetState Saver$lambda$1(Density density, Function1 function1, AnimationSpec animationSpec, boolean z, ModalBottomSheetValue modalBottomSheetValue) {
            return new ModalBottomSheetState(modalBottomSheetValue, density, function1, animationSpec, z);
        }
    }
}
