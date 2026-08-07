package androidx.compose.material;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.runtime.saveable.SaverScope;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
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
import org.apache.hc.core5.http.HeaderElements;

/* JADX INFO: compiled from: Drawer.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 >2\u00020\u0001:\u0001>B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b0\u0007\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u0018\u001a\u00020\u000bH\u0000¢\u0006\u0002\b\u0019J\u0018\u0010 \u001a\u00020\u000b2\u0006\u0010$\u001a\u00020\u00032\u0006\u0010%\u001a\u00020\u0003H\u0007J\u000e\u0010&\u001a\u00020'H\u0086@¢\u0006\u0002\u0010(J\u000e\u0010)\u001a\u00020'H\u0086@¢\u0006\u0002\u0010(J\u000e\u0010*\u001a\u00020'H\u0086@¢\u0006\u0002\u0010(J\"\u0010+\u001a\u00020'2\u0006\u0010,\u001a\u00020\u00032\b\b\u0002\u0010-\u001a\u00020\u000bH\u0080@¢\u0006\u0004\b.\u0010/J\u0018\u00100\u001a\u00020'2\u0006\u0010,\u001a\u00020\u0003H\u0080@¢\u0006\u0004\b1\u00102J\u0015\u0010\u0006\u001a\u00020\b2\u0006\u00103\u001a\u00020\u0003H\u0000¢\u0006\u0002\b4R\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u000fX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0015\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u001a\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0014R\u0011\u0010\u001c\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u001e\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001dR\u0011\u0010\u001f\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u001dR\u001a\u0010 \u001a\u00020\u000b8GX\u0087\u0004¢\u0006\f\u0012\u0004\b!\u0010\"\u001a\u0004\b#\u0010\u0017R\u0014\u00105\u001a\u00020\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b5\u0010\u001dR\u0014\u00106\u001a\u000207X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b8\u00109R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=¨\u0006?"}, d2 = {"Landroidx/compose/material/BottomDrawerState;", "", "initialValue", "Landroidx/compose/material/BottomDrawerValue;", "density", "Landroidx/compose/ui/unit/Density;", "confirmStateChange", "Lkotlin/Function1;", "", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "<init>", "(Landroidx/compose/material/BottomDrawerValue;Landroidx/compose/ui/unit/Density;Lkotlin/jvm/functions/Function1;Landroidx/compose/animation/core/AnimationSpec;)V", "anchoredDraggableState", "Landroidx/compose/material/AnchoredDraggableState;", "getAnchoredDraggableState$material", "()Landroidx/compose/material/AnchoredDraggableState;", "targetValue", "getTargetValue", "()Landroidx/compose/material/BottomDrawerValue;", "offset", "getOffset", "()F", "requireOffset", "requireOffset$material", "currentValue", "getCurrentValue", "isOpen", "()Z", "isClosed", "isExpanded", "progress", "getProgress$annotations", "()V", "getProgress", TypedValues.TransitionType.S_FROM, TypedValues.TransitionType.S_TO, "open", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", HeaderElements.CLOSE, "expand", "animateTo", "target", "velocity", "animateTo$material", "(Landroidx/compose/material/BottomDrawerValue;FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "snapTo", "snapTo$material", "(Landroidx/compose/material/BottomDrawerValue;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "value", "confirmStateChange$material", "isOpenEnabled", "nestedScrollConnection", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "getNestedScrollConnection$material", "()Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "getDensity$material", "()Landroidx/compose/ui/unit/Density;", "setDensity$material", "(Landroidx/compose/ui/unit/Density;)V", "Companion", "material"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class BottomDrawerState {
    private final AnchoredDraggableState<BottomDrawerValue> anchoredDraggableState;
    private Density density;
    private final NestedScrollConnection nestedScrollConnection;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean _init_$lambda$0(BottomDrawerValue bottomDrawerValue) {
        return true;
    }

    @Deprecated(message = "Please use the progress function to query progress explicitly between targets.", replaceWith = @ReplaceWith(expression = "progress(from = , to = )", imports = {}))
    public static /* synthetic */ void getProgress$annotations() {
    }

    public BottomDrawerState(BottomDrawerValue bottomDrawerValue, final Density density, Function1<? super BottomDrawerValue, Boolean> function1, AnimationSpec<Float> animationSpec) {
        AnchoredDraggableState<BottomDrawerValue> anchoredDraggableState = new AnchoredDraggableState<>(bottomDrawerValue, new Function1() { // from class: androidx.compose.material.BottomDrawerState$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Float.valueOf(BottomDrawerState.anchoredDraggableState$lambda$0(density, ((Float) obj).floatValue()));
            }
        }, new Function0() { // from class: androidx.compose.material.BottomDrawerState$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Float.valueOf(BottomDrawerState.anchoredDraggableState$lambda$1(density));
            }
        }, animationSpec, function1);
        this.anchoredDraggableState = anchoredDraggableState;
        this.nestedScrollConnection = DrawerKt.ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection(anchoredDraggableState);
    }

    public /* synthetic */ BottomDrawerState(BottomDrawerValue bottomDrawerValue, Density density, Function1 function1, TweenSpec<Float> tweenSpec, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(bottomDrawerValue, density, (i & 4) != 0 ? new Function1() { // from class: androidx.compose.material.BottomDrawerState$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(BottomDrawerState._init_$lambda$0((BottomDrawerValue) obj));
            }
        } : function1, (i & 8) != 0 ? DrawerDefaults.INSTANCE.getAnimationSpec() : tweenSpec);
    }

    public final AnchoredDraggableState<BottomDrawerValue> getAnchoredDraggableState$material() {
        return this.anchoredDraggableState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float anchoredDraggableState$lambda$0(Density density, float f) {
        return density.mo754toPx0680j_4(DrawerKt.DrawerPositionalThreshold);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float anchoredDraggableState$lambda$1(Density density) {
        return density.mo754toPx0680j_4(DrawerKt.DrawerVelocityThreshold);
    }

    public final BottomDrawerValue getTargetValue() {
        return this.anchoredDraggableState.getTargetValue();
    }

    public final float getOffset() {
        return this.anchoredDraggableState.getOffset();
    }

    public final float requireOffset$material() {
        return this.anchoredDraggableState.requireOffset();
    }

    public final BottomDrawerValue getCurrentValue() {
        return this.anchoredDraggableState.getCurrentValue();
    }

    public final boolean isOpen() {
        return this.anchoredDraggableState.getCurrentValue() != BottomDrawerValue.Closed;
    }

    public final boolean isClosed() {
        return this.anchoredDraggableState.getCurrentValue() == BottomDrawerValue.Closed;
    }

    public final boolean isExpanded() {
        return this.anchoredDraggableState.getCurrentValue() == BottomDrawerValue.Expanded;
    }

    public final float getProgress() {
        return this.anchoredDraggableState.getProgress();
    }

    public final float progress(BottomDrawerValue from, BottomDrawerValue to) {
        float fPositionOf = this.anchoredDraggableState.getAnchors().positionOf(from);
        float fPositionOf2 = this.anchoredDraggableState.getAnchors().positionOf(to);
        float fCoerceIn = (RangesKt.coerceIn(this.anchoredDraggableState.getOffset(), Math.min(fPositionOf, fPositionOf2), Math.max(fPositionOf, fPositionOf2)) - fPositionOf) / (fPositionOf2 - fPositionOf);
        if (Float.isNaN(fCoerceIn)) {
            return 1.0f;
        }
        return Math.abs(fCoerceIn);
    }

    public final Object open(Continuation<? super Unit> continuation) {
        Object objAnimateTo$default = AnchoredDraggableKt.animateTo$default(this.anchoredDraggableState, isOpenEnabled() ? BottomDrawerValue.Open : BottomDrawerValue.Expanded, 0.0f, continuation, 2, null);
        return objAnimateTo$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objAnimateTo$default : Unit.INSTANCE;
    }

    public final Object close(Continuation<? super Unit> continuation) {
        Object objAnimateTo$default = AnchoredDraggableKt.animateTo$default(this.anchoredDraggableState, BottomDrawerValue.Closed, 0.0f, continuation, 2, null);
        return objAnimateTo$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objAnimateTo$default : Unit.INSTANCE;
    }

    public final Object expand(Continuation<? super Unit> continuation) {
        Object objAnimateTo$default = AnchoredDraggableKt.animateTo$default(this.anchoredDraggableState, BottomDrawerValue.Expanded, 0.0f, continuation, 2, null);
        return objAnimateTo$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objAnimateTo$default : Unit.INSTANCE;
    }

    public static /* synthetic */ Object animateTo$material$default(BottomDrawerState bottomDrawerState, BottomDrawerValue bottomDrawerValue, float f, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            f = bottomDrawerState.anchoredDraggableState.getLastVelocity();
        }
        return bottomDrawerState.animateTo$material(bottomDrawerValue, f, continuation);
    }

    public final Object animateTo$material(BottomDrawerValue bottomDrawerValue, float f, Continuation<? super Unit> continuation) {
        Object objAnimateTo = AnchoredDraggableKt.animateTo(this.anchoredDraggableState, bottomDrawerValue, f, continuation);
        return objAnimateTo == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objAnimateTo : Unit.INSTANCE;
    }

    public final Object snapTo$material(BottomDrawerValue bottomDrawerValue, Continuation<? super Unit> continuation) {
        Object objSnapTo = AnchoredDraggableKt.snapTo(this.anchoredDraggableState, bottomDrawerValue, continuation);
        return objSnapTo == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objSnapTo : Unit.INSTANCE;
    }

    public final boolean confirmStateChange$material(BottomDrawerValue value) {
        return this.anchoredDraggableState.getConfirmValueChange$material().invoke(value).booleanValue();
    }

    private final boolean isOpenEnabled() {
        return this.anchoredDraggableState.getAnchors().hasAnchorFor(BottomDrawerValue.Open);
    }

    /* JADX INFO: renamed from: getNestedScrollConnection$material, reason: from getter */
    public final NestedScrollConnection getNestedScrollConnection() {
        return this.nestedScrollConnection;
    }

    /* JADX INFO: renamed from: getDensity$material, reason: from getter */
    public final Density getDensity() {
        return this.density;
    }

    public final void setDensity$material(Density density) {
        this.density = density;
    }

    /* JADX INFO: compiled from: Drawer.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J<\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00052\u0006\u0010\b\u001a\u00020\t2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\f0\u000b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e¨\u0006\u0010"}, d2 = {"Landroidx/compose/material/BottomDrawerState$Companion;", "", "<init>", "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/material/BottomDrawerState;", "Landroidx/compose/material/BottomDrawerValue;", "density", "Landroidx/compose/ui/unit/Density;", "confirmStateChange", "Lkotlin/Function1;", "", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "material"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Saver<BottomDrawerState, BottomDrawerValue> Saver(final Density density, final Function1<? super BottomDrawerValue, Boolean> confirmStateChange, final AnimationSpec<Float> animationSpec) {
            return SaverKt.Saver(new Function2() { // from class: androidx.compose.material.BottomDrawerState$Companion$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BottomDrawerState.Companion.Saver$lambda$0((SaverScope) obj, (BottomDrawerState) obj2);
                }
            }, new Function1() { // from class: androidx.compose.material.BottomDrawerState$Companion$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return BottomDrawerState.Companion.Saver$lambda$1(density, confirmStateChange, animationSpec, (BottomDrawerValue) obj);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final BottomDrawerValue Saver$lambda$0(SaverScope saverScope, BottomDrawerState bottomDrawerState) {
            return bottomDrawerState.getAnchoredDraggableState$material().getCurrentValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final BottomDrawerState Saver$lambda$1(Density density, Function1 function1, AnimationSpec animationSpec, BottomDrawerValue bottomDrawerValue) {
            return new BottomDrawerState(bottomDrawerValue, density, function1, animationSpec);
        }
    }
}
