package androidx.compose.material3;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.foundation.gestures.DraggableKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.layout.LayoutModifierKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.unit.Velocity;
import androidx.media3.extractor.ts.TsExtractor;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Ref;
import kotlin.math.MathKt;
import kotlinx.coroutines.CoroutineScope;
import sdk.pendo.io.actions.configurations.GuideCapping;

/* JADX INFO: compiled from: FloatingToolbar.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\n¢\u0006\u0004\b\u000b\u0010\fJ'\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ \u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0018\u001a\u00020\u001f2\u0006\u0010\u0019\u001a\u00020\u001fH\u0096@¢\u0006\u0004\b \u0010!J\f\u0010\"\u001a\u00020#*\u00020#H\u0016R\u0016\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006$"}, d2 = {"Landroidx/compose/material3/ExitAlwaysFloatingToolbarScrollBehavior;", "Landroidx/compose/material3/FloatingToolbarScrollBehavior;", "exitDirection", "Landroidx/compose/material3/FloatingToolbarExitDirection;", "state", "Landroidx/compose/material3/FloatingToolbarState;", "snapAnimationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "flingAnimationSpec", "Landroidx/compose/animation/core/DecayAnimationSpec;", "<init>", "(ILandroidx/compose/material3/FloatingToolbarState;Landroidx/compose/animation/core/AnimationSpec;Landroidx/compose/animation/core/DecayAnimationSpec;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getExitDirection-8LIK8-E", "()I", "I", "getState", "()Landroidx/compose/material3/FloatingToolbarState;", "getSnapAnimationSpec", "()Landroidx/compose/animation/core/AnimationSpec;", "getFlingAnimationSpec", "()Landroidx/compose/animation/core/DecayAnimationSpec;", "onPostScroll", "Landroidx/compose/ui/geometry/Offset;", GuideCapping.INSERT_CAPPING_CONSUMED, "available", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "onPostScroll-DzOQY0M", "(JJI)J", "onPostFling", "Landroidx/compose/ui/unit/Velocity;", "onPostFling-RZ2iAVY", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "floatingScrollBehavior", "Landroidx/compose/ui/Modifier;", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ExitAlwaysFloatingToolbarScrollBehavior implements FloatingToolbarScrollBehavior {
    public static final int $stable = 0;
    private final int exitDirection;
    private final DecayAnimationSpec<Float> flingAnimationSpec;
    private final AnimationSpec<Float> snapAnimationSpec;
    private final FloatingToolbarState state;

    public /* synthetic */ ExitAlwaysFloatingToolbarScrollBehavior(int i, FloatingToolbarState floatingToolbarState, AnimationSpec animationSpec, DecayAnimationSpec decayAnimationSpec, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, floatingToolbarState, animationSpec, decayAnimationSpec);
    }

    private ExitAlwaysFloatingToolbarScrollBehavior(int i, FloatingToolbarState floatingToolbarState, AnimationSpec<Float> animationSpec, DecayAnimationSpec<Float> decayAnimationSpec) {
        this.exitDirection = i;
        this.state = floatingToolbarState;
        this.snapAnimationSpec = animationSpec;
        this.flingAnimationSpec = decayAnimationSpec;
    }

    @Override // androidx.compose.material3.FloatingToolbarScrollBehavior
    /* JADX INFO: renamed from: getExitDirection-8LIK8-E, reason: not valid java name and from getter */
    public int getExitDirection() {
        return this.exitDirection;
    }

    @Override // androidx.compose.material3.FloatingToolbarScrollBehavior
    public FloatingToolbarState getState() {
        return this.state;
    }

    @Override // androidx.compose.material3.FloatingToolbarScrollBehavior
    public AnimationSpec<Float> getSnapAnimationSpec() {
        return this.snapAnimationSpec;
    }

    @Override // androidx.compose.material3.FloatingToolbarScrollBehavior
    public DecayAnimationSpec<Float> getFlingAnimationSpec() {
        return this.flingAnimationSpec;
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* JADX INFO: renamed from: onPostScroll-DzOQY0M */
    public long mo946onPostScrollDzOQY0M(long consumed, long available, int source) {
        FloatingToolbarState state = getState();
        int i = (int) (consumed & 4294967295L);
        state.setContentOffset(state.getContentOffset() + Float.intBitsToFloat(i));
        FloatingToolbarState state2 = getState();
        state2.setOffset(state2.getOffset() + Float.intBitsToFloat(i));
        return Offset.INSTANCE.m6585getZeroF1C5BW0();
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* JADX INFO: renamed from: onPostFling-RZ2iAVY */
    public Object mo945onPostFlingRZ2iAVY(long j, long j2, Continuation<? super Velocity> continuation) {
        ExitAlwaysFloatingToolbarScrollBehavior$onPostFling$1 exitAlwaysFloatingToolbarScrollBehavior$onPostFling$1;
        long j3;
        if (continuation instanceof ExitAlwaysFloatingToolbarScrollBehavior$onPostFling$1) {
            exitAlwaysFloatingToolbarScrollBehavior$onPostFling$1 = (ExitAlwaysFloatingToolbarScrollBehavior$onPostFling$1) continuation;
            if ((exitAlwaysFloatingToolbarScrollBehavior$onPostFling$1.label & Integer.MIN_VALUE) != 0) {
                exitAlwaysFloatingToolbarScrollBehavior$onPostFling$1.label -= Integer.MIN_VALUE;
            } else {
                exitAlwaysFloatingToolbarScrollBehavior$onPostFling$1 = new ExitAlwaysFloatingToolbarScrollBehavior$onPostFling$1(this, continuation);
            }
        } else {
            exitAlwaysFloatingToolbarScrollBehavior$onPostFling$1 = new ExitAlwaysFloatingToolbarScrollBehavior$onPostFling$1(this, continuation);
        }
        ExitAlwaysFloatingToolbarScrollBehavior$onPostFling$1 exitAlwaysFloatingToolbarScrollBehavior$onPostFling$2 = exitAlwaysFloatingToolbarScrollBehavior$onPostFling$1;
        Object obj = exitAlwaysFloatingToolbarScrollBehavior$onPostFling$2.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = exitAlwaysFloatingToolbarScrollBehavior$onPostFling$2.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (Velocity.m9926getYimpl(j2) > 0.0f && (getState().getOffset() == 0.0f || getState().getOffset() == getState().getOffsetLimit())) {
                getState().setContentOffset(0.0f);
            }
            exitAlwaysFloatingToolbarScrollBehavior$onPostFling$2.J$0 = j2;
            exitAlwaysFloatingToolbarScrollBehavior$onPostFling$2.label = 1;
            obj = super.mo945onPostFlingRZ2iAVY(j, j2, exitAlwaysFloatingToolbarScrollBehavior$onPostFling$2);
            if (obj != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        if (i == 1) {
            j2 = exitAlwaysFloatingToolbarScrollBehavior$onPostFling$2.J$0;
            ResultKt.throwOnFailure(obj);
        } else {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            j3 = exitAlwaysFloatingToolbarScrollBehavior$onPostFling$2.J$0;
            ResultKt.throwOnFailure(obj);
        }
        return Velocity.m9916boximpl(Velocity.m9929plusAH228Gc(j3, ((Velocity) obj).getPackedValue()));
        long packedValue = ((Velocity) obj).getPackedValue();
        FloatingToolbarState state = getState();
        float fM9926getYimpl = Velocity.m9926getYimpl(j2);
        AnimationSpec<Float> snapAnimationSpec = getSnapAnimationSpec();
        DecayAnimationSpec<Float> flingAnimationSpec = getFlingAnimationSpec();
        exitAlwaysFloatingToolbarScrollBehavior$onPostFling$2.J$0 = packedValue;
        exitAlwaysFloatingToolbarScrollBehavior$onPostFling$2.label = 2;
        obj = FloatingToolbarKt.settleFloatingToolbar(state, fM9926getYimpl, snapAnimationSpec, flingAnimationSpec, exitAlwaysFloatingToolbarScrollBehavior$onPostFling$2);
        if (obj != coroutine_suspended) {
            j3 = packedValue;
            return Velocity.m9916boximpl(Velocity.m9929plusAH228Gc(j3, ((Velocity) obj).getPackedValue()));
        }
        return coroutine_suspended;
    }

    @Override // androidx.compose.material3.FloatingToolbarScrollBehavior
    public Modifier floatingScrollBehavior(Modifier modifier) {
        Orientation orientation;
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        int exitDirection = getExitDirection();
        if (FloatingToolbarExitDirection.m3445equalsimpl0(exitDirection, FloatingToolbarExitDirection.INSTANCE.m3451getStart8LIK8E()) || FloatingToolbarExitDirection.m3445equalsimpl0(exitDirection, FloatingToolbarExitDirection.INSTANCE.m3450getEnd8LIK8E())) {
            orientation = Orientation.Horizontal;
        } else {
            orientation = Orientation.Vertical;
        }
        Orientation orientation2 = orientation;
        return OnGloballyPositionedModifierKt.onGloballyPositioned(DraggableKt.draggable$default(LayoutModifierKt.layout(modifier, new Function3() { // from class: androidx.compose.material3.ExitAlwaysFloatingToolbarScrollBehavior$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return ExitAlwaysFloatingToolbarScrollBehavior.floatingScrollBehavior$lambda$1(booleanRef, this, (MeasureScope) obj, (Measurable) obj2, (Constraints) obj3);
            }
        }), DraggableKt.DraggableState(new Function1() { // from class: androidx.compose.material3.ExitAlwaysFloatingToolbarScrollBehavior$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ExitAlwaysFloatingToolbarScrollBehavior.floatingScrollBehavior$lambda$0(this.f$0, booleanRef, ((Float) obj).floatValue());
            }
        }), orientation2, false, null, false, null, new AnonymousClass2(null), false, TsExtractor.TS_PACKET_SIZE, null), new Function1() { // from class: androidx.compose.material3.ExitAlwaysFloatingToolbarScrollBehavior$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ExitAlwaysFloatingToolbarScrollBehavior.floatingScrollBehavior$lambda$2(this.f$0, booleanRef, (LayoutCoordinates) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit floatingScrollBehavior$lambda$0(ExitAlwaysFloatingToolbarScrollBehavior exitAlwaysFloatingToolbarScrollBehavior, Ref.BooleanRef booleanRef, float f) {
        if (CollectionsKt.listOf((Object[]) new FloatingToolbarExitDirection[]{FloatingToolbarExitDirection.m3442boximpl(FloatingToolbarExitDirection.INSTANCE.m3451getStart8LIK8E()), FloatingToolbarExitDirection.m3442boximpl(FloatingToolbarExitDirection.INSTANCE.m3450getEnd8LIK8E())}).contains(FloatingToolbarExitDirection.m3442boximpl(exitAlwaysFloatingToolbarScrollBehavior.getExitDirection())) && booleanRef.element) {
            f = -f;
        }
        int exitDirection = exitAlwaysFloatingToolbarScrollBehavior.getExitDirection();
        if (FloatingToolbarExitDirection.m3445equalsimpl0(exitDirection, FloatingToolbarExitDirection.INSTANCE.m3451getStart8LIK8E()) || FloatingToolbarExitDirection.m3445equalsimpl0(exitDirection, FloatingToolbarExitDirection.INSTANCE.m3452getTop8LIK8E())) {
            FloatingToolbarState state = exitAlwaysFloatingToolbarScrollBehavior.getState();
            state.setOffset(state.getOffset() + f);
        } else if (FloatingToolbarExitDirection.m3445equalsimpl0(exitDirection, FloatingToolbarExitDirection.INSTANCE.m3450getEnd8LIK8E()) || FloatingToolbarExitDirection.m3445equalsimpl0(exitDirection, FloatingToolbarExitDirection.INSTANCE.m3449getBottom8LIK8E())) {
            FloatingToolbarState state2 = exitAlwaysFloatingToolbarScrollBehavior.getState();
            state2.setOffset(state2.getOffset() - f);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MeasureResult floatingScrollBehavior$lambda$1(Ref.BooleanRef booleanRef, final ExitAlwaysFloatingToolbarScrollBehavior exitAlwaysFloatingToolbarScrollBehavior, MeasureScope measureScope, Measurable measurable, Constraints constraints) {
        booleanRef.element = measureScope.getLayoutDirection() == LayoutDirection.Rtl;
        final Placeable placeableMo8265measureBRTryo0 = measurable.mo8265measureBRTryo0(constraints.getValue());
        final float offset = (CollectionsKt.listOf((Object[]) new FloatingToolbarExitDirection[]{FloatingToolbarExitDirection.m3442boximpl(FloatingToolbarExitDirection.INSTANCE.m3451getStart8LIK8E()), FloatingToolbarExitDirection.m3442boximpl(FloatingToolbarExitDirection.INSTANCE.m3450getEnd8LIK8E())}).contains(FloatingToolbarExitDirection.m3442boximpl(exitAlwaysFloatingToolbarScrollBehavior.getExitDirection())) && booleanRef.element) ? -exitAlwaysFloatingToolbarScrollBehavior.getState().getOffset() : exitAlwaysFloatingToolbarScrollBehavior.getState().getOffset();
        return MeasureScope.layout$default(measureScope, placeableMo8265measureBRTryo0.getWidth(), placeableMo8265measureBRTryo0.getHeight(), null, new Function1() { // from class: androidx.compose.material3.ExitAlwaysFloatingToolbarScrollBehavior$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ExitAlwaysFloatingToolbarScrollBehavior.floatingScrollBehavior$lambda$1$0(this.f$0, placeableMo8265measureBRTryo0, offset, (Placeable.PlacementScope) obj);
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit floatingScrollBehavior$lambda$1$0(ExitAlwaysFloatingToolbarScrollBehavior exitAlwaysFloatingToolbarScrollBehavior, Placeable placeable, float f, Placeable.PlacementScope placementScope) {
        int exitDirection = exitAlwaysFloatingToolbarScrollBehavior.getExitDirection();
        if (FloatingToolbarExitDirection.m3445equalsimpl0(exitDirection, FloatingToolbarExitDirection.INSTANCE.m3451getStart8LIK8E())) {
            Placeable.PlacementScope.placeWithLayer$default(placementScope, placeable, MathKt.roundToInt(f), 0, 0.0f, (Function1) null, 12, (Object) null);
        } else if (FloatingToolbarExitDirection.m3445equalsimpl0(exitDirection, FloatingToolbarExitDirection.INSTANCE.m3450getEnd8LIK8E())) {
            Placeable.PlacementScope.placeWithLayer$default(placementScope, placeable, -MathKt.roundToInt(f), 0, 0.0f, (Function1) null, 12, (Object) null);
        } else if (FloatingToolbarExitDirection.m3445equalsimpl0(exitDirection, FloatingToolbarExitDirection.INSTANCE.m3452getTop8LIK8E())) {
            Placeable.PlacementScope.placeWithLayer$default(placementScope, placeable, 0, MathKt.roundToInt(f), 0.0f, (Function1) null, 12, (Object) null);
        } else if (FloatingToolbarExitDirection.m3445equalsimpl0(exitDirection, FloatingToolbarExitDirection.INSTANCE.m3449getBottom8LIK8E())) {
            Placeable.PlacementScope.placeWithLayer$default(placementScope, placeable, 0, -MathKt.roundToInt(f), 0.0f, (Function1) null, 12, (Object) null);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: androidx.compose.material3.ExitAlwaysFloatingToolbarScrollBehavior$floatingScrollBehavior$2, reason: invalid class name */
    /* JADX INFO: compiled from: FloatingToolbar.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "velocity", ""}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.material3.ExitAlwaysFloatingToolbarScrollBehavior$floatingScrollBehavior$2", f = "FloatingToolbar.kt", i = {}, l = {708}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function3<CoroutineScope, Float, Continuation<? super Unit>, Object> {
        /* synthetic */ float F$0;
        int label;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(3, continuation);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Float f, Continuation<? super Unit> continuation) {
            return invoke(coroutineScope, f.floatValue(), continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, float f, Continuation<? super Unit> continuation) {
            AnonymousClass2 anonymousClass2 = ExitAlwaysFloatingToolbarScrollBehavior.this.new AnonymousClass2(continuation);
            anonymousClass2.F$0 = f;
            return anonymousClass2.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                float f = this.F$0;
                this.label = 1;
                if (FloatingToolbarKt.settleFloatingToolbar(ExitAlwaysFloatingToolbarScrollBehavior.this.getState(), f, ExitAlwaysFloatingToolbarScrollBehavior.this.getSnapAnimationSpec(), ExitAlwaysFloatingToolbarScrollBehavior.this.getFlingAnimationSpec(), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit floatingScrollBehavior$lambda$2(ExitAlwaysFloatingToolbarScrollBehavior exitAlwaysFloatingToolbarScrollBehavior, Ref.BooleanRef booleanRef, LayoutCoordinates layoutCoordinates) {
        float f;
        float fIntBitsToFloat;
        float f2;
        float fIntBitsToFloat2;
        float f3;
        long jPositionInParent = LayoutCoordinatesKt.positionInParent(layoutCoordinates);
        LayoutCoordinates parentLayoutCoordinates = layoutCoordinates.getParentLayoutCoordinates();
        long jMo8273getSizeYbymL2g = parentLayoutCoordinates != null ? parentLayoutCoordinates.mo8273getSizeYbymL2g() : IntSize.INSTANCE.m9863getZeroYbymL2g();
        int iMo8273getSizeYbymL2g = (int) (layoutCoordinates.mo8273getSizeYbymL2g() >> 32);
        int iMo8273getSizeYbymL2g2 = (int) (layoutCoordinates.mo8273getSizeYbymL2g() & 4294967295L);
        int exitDirection = exitAlwaysFloatingToolbarScrollBehavior.getExitDirection();
        if (FloatingToolbarExitDirection.m3445equalsimpl0(exitDirection, FloatingToolbarExitDirection.INSTANCE.m3451getStart8LIK8E())) {
            if (booleanRef.element) {
                f = (int) (jMo8273getSizeYbymL2g >> 32);
                fIntBitsToFloat = Float.intBitsToFloat((int) (jPositionInParent >> 32));
                f3 = f - fIntBitsToFloat;
            } else {
                f2 = iMo8273getSizeYbymL2g;
                fIntBitsToFloat2 = Float.intBitsToFloat((int) (jPositionInParent >> 32));
                f3 = f2 + fIntBitsToFloat2;
            }
        } else if (FloatingToolbarExitDirection.m3445equalsimpl0(exitDirection, FloatingToolbarExitDirection.INSTANCE.m3450getEnd8LIK8E())) {
            if (booleanRef.element) {
                f2 = iMo8273getSizeYbymL2g;
                fIntBitsToFloat2 = Float.intBitsToFloat((int) (jPositionInParent >> 32));
                f3 = f2 + fIntBitsToFloat2;
            } else {
                f = (int) (jMo8273getSizeYbymL2g >> 32);
                fIntBitsToFloat = Float.intBitsToFloat((int) (jPositionInParent >> 32));
                f3 = f - fIntBitsToFloat;
            }
        } else if (FloatingToolbarExitDirection.m3445equalsimpl0(exitDirection, FloatingToolbarExitDirection.INSTANCE.m3452getTop8LIK8E())) {
            f2 = iMo8273getSizeYbymL2g2;
            fIntBitsToFloat2 = Float.intBitsToFloat((int) (jPositionInParent & 4294967295L));
            f3 = f2 + fIntBitsToFloat2;
        } else {
            f = (int) (jMo8273getSizeYbymL2g & 4294967295L);
            fIntBitsToFloat = Float.intBitsToFloat((int) (jPositionInParent & 4294967295L));
            f3 = f - fIntBitsToFloat;
        }
        exitAlwaysFloatingToolbarScrollBehavior.getState().setOffsetLimit(-(f3 - exitAlwaysFloatingToolbarScrollBehavior.getState().getOffset()));
        return Unit.INSTANCE;
    }
}
