package androidx.compose.material;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.foundation.gestures.Orientation;
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

/* JADX INFO: compiled from: BackdropScaffold.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 12\u00020\u0001:\u00011BA\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t0\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\u0006\u0010\u0017\u001a\u00020\u0006J\u000e\u0010\u001b\u001a\u00020\u001cH\u0086@¢\u0006\u0002\u0010\u001dJ\u000e\u0010\u001e\u001a\u00020\u001cH\u0086@¢\u0006\u0002\u0010\u001dJ\u0018\u0010\u001f\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u0003H\u0007J\b\u0010,\u001a\u00020'H\u0002R\u001d\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0015\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0014R\u0011\u0010\u0018\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u001a\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0019R\u001a\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00030#X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u001c\u0010&\u001a\u0004\u0018\u00010'X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u0014\u0010-\u001a\u00020.X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u00100¨\u00062"}, d2 = {"Landroidx/compose/material/BackdropScaffoldState;", "", "initialValue", "Landroidx/compose/material/BackdropValue;", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "confirmValueChange", "Lkotlin/Function1;", "", "snackbarHostState", "Landroidx/compose/material/SnackbarHostState;", "<init>", "(Landroidx/compose/material/BackdropValue;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function1;Landroidx/compose/material/SnackbarHostState;)V", "getConfirmValueChange", "()Lkotlin/jvm/functions/Function1;", "getSnackbarHostState", "()Landroidx/compose/material/SnackbarHostState;", "currentValue", "getCurrentValue", "()Landroidx/compose/material/BackdropValue;", "targetValue", "getTargetValue", "requireOffset", "isRevealed", "()Z", "isConcealed", "reveal", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "conceal", "progress", TypedValues.TransitionType.S_FROM, TypedValues.TransitionType.S_TO, "anchoredDraggableState", "Landroidx/compose/material/AnchoredDraggableState;", "getAnchoredDraggableState$material", "()Landroidx/compose/material/AnchoredDraggableState;", "density", "Landroidx/compose/ui/unit/Density;", "getDensity$material", "()Landroidx/compose/ui/unit/Density;", "setDensity$material", "(Landroidx/compose/ui/unit/Density;)V", "requireDensity", "nestedScrollConnection", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "getNestedScrollConnection$material", "()Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "Companion", "material"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class BackdropScaffoldState {
    public static final int $stable = 0;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final AnchoredDraggableState<BackdropValue> anchoredDraggableState;
    private final Function1<BackdropValue, Boolean> confirmValueChange;
    private Density density;
    private final NestedScrollConnection nestedScrollConnection;
    private final SnackbarHostState snackbarHostState;

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean _init_$lambda$0(BackdropValue backdropValue) {
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Deprecated(message = "This constructor is deprecated. Density must be provided by the component. Please use the constructor that provides a [Density].", replaceWith = @ReplaceWith(expression = "\n            BackdropScaffoldState(\n                initialValue = initialValue,\n                density = LocalDensity.current,\n                animationSpec = animationSpec,\n                confirmValueChange = confirmValueChange\n            )\n            ", imports = {}))
    public BackdropScaffoldState(BackdropValue backdropValue, AnimationSpec<Float> animationSpec, Function1<? super BackdropValue, Boolean> function1, SnackbarHostState snackbarHostState) {
        this.confirmValueChange = function1;
        this.snackbarHostState = snackbarHostState;
        AnchoredDraggableState<BackdropValue> anchoredDraggableState = new AnchoredDraggableState<>(backdropValue, new Function1() { // from class: androidx.compose.material.BackdropScaffoldState$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Float.valueOf(BackdropScaffoldState.anchoredDraggableState$lambda$0(this.f$0, ((Float) obj).floatValue()));
            }
        }, new Function0() { // from class: androidx.compose.material.BackdropScaffoldState$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Float.valueOf(BackdropScaffoldState.anchoredDraggableState$lambda$1(this.f$0));
            }
        }, animationSpec, function1);
        this.anchoredDraggableState = anchoredDraggableState;
        this.nestedScrollConnection = BackdropScaffoldKt.ConsumeSwipeNestedScrollConnection(anchoredDraggableState, Orientation.Vertical);
    }

    public /* synthetic */ BackdropScaffoldState(BackdropValue backdropValue, AnimationSpec animationSpec, Function1 function1, SnackbarHostState snackbarHostState, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(backdropValue, (i & 2) != 0 ? BackdropScaffoldDefaults.INSTANCE.getAnimationSpec() : animationSpec, (i & 4) != 0 ? new Function1() { // from class: androidx.compose.material.BackdropScaffoldState$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(BackdropScaffoldState._init_$lambda$0((BackdropValue) obj));
            }
        } : function1, (i & 8) != 0 ? new SnackbarHostState() : snackbarHostState);
    }

    public final Function1<BackdropValue, Boolean> getConfirmValueChange() {
        return this.confirmValueChange;
    }

    public final SnackbarHostState getSnackbarHostState() {
        return this.snackbarHostState;
    }

    public final BackdropValue getCurrentValue() {
        return this.anchoredDraggableState.getCurrentValue();
    }

    public final BackdropValue getTargetValue() {
        return this.anchoredDraggableState.getTargetValue();
    }

    public final float requireOffset() {
        return this.anchoredDraggableState.requireOffset();
    }

    public final boolean isRevealed() {
        return this.anchoredDraggableState.getCurrentValue() == BackdropValue.Revealed;
    }

    public final boolean isConcealed() {
        return this.anchoredDraggableState.getCurrentValue() == BackdropValue.Concealed;
    }

    public final Object reveal(Continuation<? super Unit> continuation) {
        Object objAnimateTo$default = AnchoredDraggableKt.animateTo$default(this.anchoredDraggableState, BackdropValue.Revealed, 0.0f, continuation, 2, null);
        return objAnimateTo$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objAnimateTo$default : Unit.INSTANCE;
    }

    public final Object conceal(Continuation<? super Unit> continuation) {
        Object objAnimateTo$default = AnchoredDraggableKt.animateTo$default(this.anchoredDraggableState, BackdropValue.Concealed, 0.0f, continuation, 2, null);
        return objAnimateTo$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objAnimateTo$default : Unit.INSTANCE;
    }

    public final float progress(BackdropValue from, BackdropValue to) {
        float fPositionOf = this.anchoredDraggableState.getAnchors().positionOf(from);
        float fPositionOf2 = this.anchoredDraggableState.getAnchors().positionOf(to);
        float fCoerceIn = (RangesKt.coerceIn(this.anchoredDraggableState.getOffset(), Math.min(fPositionOf, fPositionOf2), Math.max(fPositionOf, fPositionOf2)) - fPositionOf) / (fPositionOf2 - fPositionOf);
        if (Float.isNaN(fCoerceIn)) {
            return 1.0f;
        }
        return Math.abs(fCoerceIn);
    }

    public final AnchoredDraggableState<BackdropValue> getAnchoredDraggableState$material() {
        return this.anchoredDraggableState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float anchoredDraggableState$lambda$0(BackdropScaffoldState backdropScaffoldState, float f) {
        return backdropScaffoldState.requireDensity().mo754toPx0680j_4(BackdropScaffoldKt.PositionalThreshold);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float anchoredDraggableState$lambda$1(BackdropScaffoldState backdropScaffoldState) {
        return backdropScaffoldState.requireDensity().mo754toPx0680j_4(BackdropScaffoldKt.VelocityThreshold);
    }

    /* JADX INFO: renamed from: getDensity$material, reason: from getter */
    public final Density getDensity() {
        return this.density;
    }

    public final void setDensity$material(Density density) {
        this.density = density;
    }

    private final Density requireDensity() {
        Density density = this.density;
        if (density != null) {
            return density;
        }
        throw new IllegalArgumentException(("The density on BackdropScaffoldState (" + this + ") was not set. Did you use BackdropScaffoldState with the BackdropScaffold composable?").toString());
    }

    /* JADX INFO: renamed from: getNestedScrollConnection$material, reason: from getter */
    public final NestedScrollConnection getNestedScrollConnection() {
        return this.nestedScrollConnection;
    }

    /* JADX INFO: compiled from: BackdropScaffold.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JB\u0010\u0004\u001a\f\u0012\u0004\u0012\u00020\u0006\u0012\u0002\b\u00030\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011¨\u0006\u0012"}, d2 = {"Landroidx/compose/material/BackdropScaffoldState$Companion;", "", "<init>", "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/material/BackdropScaffoldState;", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "confirmStateChange", "Lkotlin/Function1;", "Landroidx/compose/material/BackdropValue;", "", "snackbarHostState", "Landroidx/compose/material/SnackbarHostState;", "density", "Landroidx/compose/ui/unit/Density;", "material"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Saver<BackdropScaffoldState, ?> Saver(final AnimationSpec<Float> animationSpec, final Function1<? super BackdropValue, Boolean> confirmStateChange, final SnackbarHostState snackbarHostState, final Density density) {
            return SaverKt.Saver(new Function2() { // from class: androidx.compose.material.BackdropScaffoldState$Companion$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BackdropScaffoldState.Companion.Saver$lambda$0((SaverScope) obj, (BackdropScaffoldState) obj2);
                }
            }, new Function1() { // from class: androidx.compose.material.BackdropScaffoldState$Companion$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return BackdropScaffoldState.Companion.Saver$lambda$1(density, animationSpec, confirmStateChange, snackbarHostState, (BackdropValue) obj);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final BackdropValue Saver$lambda$0(SaverScope saverScope, BackdropScaffoldState backdropScaffoldState) {
            return backdropScaffoldState.getAnchoredDraggableState$material().getCurrentValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final BackdropScaffoldState Saver$lambda$1(Density density, AnimationSpec animationSpec, Function1 function1, SnackbarHostState snackbarHostState, BackdropValue backdropValue) {
            return BackdropScaffoldKt.BackdropScaffoldState(backdropValue, density, animationSpec, function1, snackbarHostState);
        }
    }
}
