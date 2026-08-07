package androidx.constraintlayout.compose.carousel;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.foundation.gestures.DragScope;
import androidx.compose.foundation.gestures.DraggableKt;
import androidx.compose.foundation.gestures.DraggableState;
import androidx.compose.runtime.FloatState;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.runtime.saveable.SaverScope;
import androidx.exifinterface.media.ExifInterface;
import com.facebook.react.uimanager.ViewProps;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: compiled from: CarouselSwipeable.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0017\b\u0011\u0018\u0000 r*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001rBB\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012#\b\u0002\u0010\u0007\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\b¢\u0006\u0002\u0010\rJ$\u0010[\u001a\u00020\\2\u0006\u0010]\u001a\u00020\u00062\f\u0010^\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0082@¢\u0006\u0002\u0010_J&\u0010`\u001a\u00020\\2\u0006\u0010M\u001a\u00028\u00002\u000e\b\u0002\u0010a\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0086@¢\u0006\u0002\u0010bJ!\u0010c\u001a\u00020\\2\u0012\u0010d\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00028\u00000\u0011H\u0000¢\u0006\u0002\beJ\u000e\u0010f\u001a\u00020\u00062\u0006\u0010g\u001a\u00020\u0006J\u0016\u0010h\u001a\u00020\\2\u0006\u0010i\u001a\u00020\u0006H\u0086@¢\u0006\u0002\u0010jJ8\u0010k\u001a\u00020\\2\u0012\u0010l\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00028\u00000\u00112\u0012\u0010d\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00028\u00000\u0011H\u0080@¢\u0006\u0004\bm\u0010nJ\u0016\u0010o\u001a\u00020\\2\u0006\u0010]\u001a\u00020\u0006H\u0082@¢\u0006\u0002\u0010jJ\u0016\u0010p\u001a\u00020\\2\u0006\u0010M\u001a\u00028\u0000H\u0086@¢\u0006\u0002\u0010qR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000RC\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00028\u00000\u00112\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00028\u00000\u00118@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R/\u0010\u0007\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR+\u0010\u001f\u001a\u00028\u00002\u0006\u0010\u0010\u001a\u00028\u00008F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b$\u0010\u0018\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u0011\u0010%\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b&\u0010'R\u0014\u0010(\u001a\u00020)X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R+\u0010,\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\f8F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b0\u0010\u0018\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R \u00101\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00028\u00000\u001102X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u00103\u001a\u00020\u0006X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010'\"\u0004\b5\u00106R\u001a\u00107\u001a\u00020\u0006X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010'\"\u0004\b9\u00106R\u0011\u0010:\u001a\u00020;8F¢\u0006\u0006\u001a\u0004\b<\u0010=R\u000e\u0010>\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010?\u001a\u00020;8F¢\u0006\u0006\u001a\u0004\b@\u0010=R\u000e\u0010A\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010B\u001a\b\u0012\u0004\u0012\u00028\u00000C8F¢\u0006\u0006\u001a\u0004\bD\u0010ER/\u0010G\u001a\u0004\u0018\u00010F2\b\u0010\u0010\u001a\u0004\u0018\u00010F8@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\bL\u0010\u0018\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR\u0011\u0010M\u001a\u00028\u00008F¢\u0006\u0006\u001a\u0004\bN\u0010!RO\u0010P\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060O2\u0018\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060O8@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\bU\u0010\u0018\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010TR+\u0010V\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00068@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\bY\u0010Z\u001a\u0004\bW\u0010'\"\u0004\bX\u00106¨\u0006s"}, d2 = {"Landroidx/constraintlayout/compose/carousel/CarouselSwipeableState;", ExifInterface.GPS_DIRECTION_TRUE, "", "initialValue", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "confirmStateChange", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "newValue", "", "(Ljava/lang/Object;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function1;)V", "absoluteOffset", "Landroidx/compose/runtime/MutableFloatState;", "<set-?>", "", "anchors", "getAnchors$constraintlayout_compose_release", "()Ljava/util/Map;", "setAnchors$constraintlayout_compose_release", "(Ljava/util/Map;)V", "anchors$delegate", "Landroidx/compose/runtime/MutableState;", "getAnimationSpec$constraintlayout_compose_release", "()Landroidx/compose/animation/core/AnimationSpec;", "animationTarget", "Landroidx/compose/runtime/MutableState;", "getConfirmStateChange$constraintlayout_compose_release", "()Lkotlin/jvm/functions/Function1;", "currentValue", "getCurrentValue", "()Ljava/lang/Object;", "setCurrentValue", "(Ljava/lang/Object;)V", "currentValue$delegate", "direction", "getDirection", "()F", "draggableState", "Landroidx/compose/foundation/gestures/DraggableState;", "getDraggableState$constraintlayout_compose_release", "()Landroidx/compose/foundation/gestures/DraggableState;", "isAnimationRunning", "()Z", "setAnimationRunning", "(Z)V", "isAnimationRunning$delegate", "latestNonEmptyAnchorsFlow", "Lkotlinx/coroutines/flow/Flow;", "maxBound", "getMaxBound$constraintlayout_compose_release", "setMaxBound$constraintlayout_compose_release", "(F)V", "minBound", "getMinBound$constraintlayout_compose_release", "setMinBound$constraintlayout_compose_release", "offset", "Landroidx/compose/runtime/FloatState;", "getOffset", "()Landroidx/compose/runtime/FloatState;", "offsetState", ViewProps.OVERFLOW, "getOverflow", "overflowState", "progress", "Landroidx/constraintlayout/compose/carousel/SwipeProgress;", "getProgress", "()Landroidx/constraintlayout/compose/carousel/SwipeProgress;", "Landroidx/constraintlayout/compose/carousel/ResistanceConfig;", "resistance", "getResistance$constraintlayout_compose_release", "()Landroidx/constraintlayout/compose/carousel/ResistanceConfig;", "setResistance$constraintlayout_compose_release", "(Landroidx/constraintlayout/compose/carousel/ResistanceConfig;)V", "resistance$delegate", "targetValue", "getTargetValue", "Lkotlin/Function2;", "thresholds", "getThresholds$constraintlayout_compose_release", "()Lkotlin/jvm/functions/Function2;", "setThresholds$constraintlayout_compose_release", "(Lkotlin/jvm/functions/Function2;)V", "thresholds$delegate", "velocityThreshold", "getVelocityThreshold$constraintlayout_compose_release", "setVelocityThreshold$constraintlayout_compose_release", "velocityThreshold$delegate", "Landroidx/compose/runtime/MutableFloatState;", "animateInternalToOffset", "", "target", "spec", "(FLandroidx/compose/animation/core/AnimationSpec;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "animateTo", "anim", "(Ljava/lang/Object;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ensureInit", "newAnchors", "ensureInit$constraintlayout_compose_release", "performDrag", "delta", "performFling", "velocity", "(FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processNewAnchors", "oldAnchors", "processNewAnchors$constraintlayout_compose_release", "(Ljava/util/Map;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "snapInternalToOffset", "snapTo", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "constraintlayout-compose_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public class CarouselSwipeableState<T> {
    public static final int $stable = 0;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final MutableFloatState absoluteOffset;

    /* JADX INFO: renamed from: anchors$delegate, reason: from kotlin metadata */
    private final MutableState anchors;
    private final AnimationSpec<Float> animationSpec;
    private final MutableState<Float> animationTarget;
    private final Function1<T, Boolean> confirmStateChange;

    /* JADX INFO: renamed from: currentValue$delegate, reason: from kotlin metadata */
    private final MutableState currentValue;
    private final DraggableState draggableState;

    /* JADX INFO: renamed from: isAnimationRunning$delegate, reason: from kotlin metadata */
    private final MutableState isAnimationRunning;
    private final Flow<Map<Float, T>> latestNonEmptyAnchorsFlow;
    private float maxBound;
    private float minBound;
    private final MutableFloatState offsetState;
    private final MutableFloatState overflowState;

    /* JADX INFO: renamed from: resistance$delegate, reason: from kotlin metadata */
    private final MutableState resistance;

    /* JADX INFO: renamed from: thresholds$delegate, reason: from kotlin metadata */
    private final MutableState thresholds;

    /* JADX INFO: renamed from: velocityThreshold$delegate, reason: from kotlin metadata */
    private final MutableFloatState velocityThreshold;

    /* JADX WARN: Multi-variable type inference failed */
    public CarouselSwipeableState(T t, AnimationSpec<Float> animationSpec, Function1<? super T, Boolean> function1) {
        this.animationSpec = animationSpec;
        this.confirmStateChange = function1;
        this.currentValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(t, null, 2, null);
        this.isAnimationRunning = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
        this.offsetState = PrimitiveSnapshotStateKt.mutableFloatStateOf(0.0f);
        this.overflowState = PrimitiveSnapshotStateKt.mutableFloatStateOf(0.0f);
        this.absoluteOffset = PrimitiveSnapshotStateKt.mutableFloatStateOf(0.0f);
        this.animationTarget = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.anchors = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(MapsKt.emptyMap(), null, 2, null);
        final Flow flowSnapshotFlow = SnapshotStateKt.snapshotFlow(new Function0<Map<Float, ? extends T>>(this) { // from class: androidx.constraintlayout.compose.carousel.CarouselSwipeableState$latestNonEmptyAnchorsFlow$1
            final /* synthetic */ CarouselSwipeableState<T> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Map<Float, T> invoke() {
                return this.this$0.getAnchors$constraintlayout_compose_release();
            }
        });
        this.latestNonEmptyAnchorsFlow = FlowKt.take(new Flow<Map<Float, ? extends T>>() { // from class: androidx.constraintlayout.compose.carousel.CarouselSwipeableState$special$$inlined$filter$1

            /* JADX INFO: renamed from: androidx.constraintlayout.compose.carousel.CarouselSwipeableState$special$$inlined$filter$1$2, reason: invalid class name */
            /* JADX INFO: compiled from: Emitters.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$filter$$inlined$unsafeTransform$1$2"}, k = 3, mv = {1, 8, 0}, xi = 48)
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* JADX INFO: renamed from: androidx.constraintlayout.compose.carousel.CarouselSwipeableState$special$$inlined$filter$1$2$1, reason: invalid class name */
                /* JADX INFO: compiled from: Emitters.kt */
                @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
                @DebugMetadata(c = "androidx.constraintlayout.compose.carousel.CarouselSwipeableState$special$$inlined$filter$1$2", f = "CarouselSwipeable.kt", i = {}, l = {223}, m = "emit", n = {}, s = {})
                public static final class AnonymousClass1 extends ContinuationImpl {
                    Object L$0;
                    Object L$1;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.$this_unsafeFlow = flowCollector;
                }

                /* JADX WARN: Code duplicated, block: B:7:0x0014  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                public final Object emit(Object obj, Continuation continuation) {
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
                    Object obj2 = anonymousClass1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = anonymousClass1.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj2);
                        FlowCollector flowCollector = this.$this_unsafeFlow;
                        if (!((Map) obj).isEmpty()) {
                            anonymousClass1.label = 1;
                            if (flowCollector.emit(obj, anonymousClass1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj2);
                    }
                    return Unit.INSTANCE;
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector flowCollector, Continuation continuation) {
                Object objCollect = flowSnapshotFlow.collect(new AnonymousClass2(flowCollector), continuation);
                return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
            }
        }, 1);
        this.minBound = Float.NEGATIVE_INFINITY;
        this.maxBound = Float.POSITIVE_INFINITY;
        this.thresholds = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new Function2<Float, Float, Float>() { // from class: androidx.constraintlayout.compose.carousel.CarouselSwipeableState$thresholds$2
            public final Float invoke(float f, float f2) {
                return Float.valueOf(0.0f);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Float invoke(Float f, Float f2) {
                return invoke(f.floatValue(), f2.floatValue());
            }
        }, null, 2, null);
        this.velocityThreshold = PrimitiveSnapshotStateKt.mutableFloatStateOf(0.0f);
        this.resistance = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.draggableState = DraggableKt.DraggableState(new Function1<Float, Unit>(this) { // from class: androidx.constraintlayout.compose.carousel.CarouselSwipeableState$draggableState$1
            final /* synthetic */ CarouselSwipeableState<T> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Float f) {
                invoke(f.floatValue());
                return Unit.INSTANCE;
            }

            public final void invoke(float f) {
                float floatValue = ((CarouselSwipeableState) this.this$0).absoluteOffset.getFloatValue() + f;
                float fCoerceIn = RangesKt.coerceIn(floatValue, this.this$0.getMinBound(), this.this$0.getMaxBound());
                float f2 = floatValue - fCoerceIn;
                ResistanceConfig resistance$constraintlayout_compose_release = this.this$0.getResistance$constraintlayout_compose_release();
                ((CarouselSwipeableState) this.this$0).offsetState.setFloatValue(fCoerceIn + (resistance$constraintlayout_compose_release != null ? resistance$constraintlayout_compose_release.computeResistance(f2) : 0.0f));
                ((CarouselSwipeableState) this.this$0).overflowState.setFloatValue(f2);
                ((CarouselSwipeableState) this.this$0).absoluteOffset.setFloatValue(floatValue);
            }
        });
    }

    public /* synthetic */ CarouselSwipeableState(Object obj, SpringSpec<Float> springSpec, AnonymousClass1 anonymousClass1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(obj, (i & 2) != 0 ? SwipeableDefaults.INSTANCE.getAnimationSpec() : springSpec, (i & 4) != 0 ? new Function1<T, Boolean>() { // from class: androidx.constraintlayout.compose.carousel.CarouselSwipeableState.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(T t) {
                return true;
            }
        } : anonymousClass1);
    }

    public final AnimationSpec<Float> getAnimationSpec$constraintlayout_compose_release() {
        return this.animationSpec;
    }

    public final Function1<T, Boolean> getConfirmStateChange$constraintlayout_compose_release() {
        return this.confirmStateChange;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setCurrentValue(T t) {
        this.currentValue.setValue(t);
    }

    public final T getCurrentValue() {
        return this.currentValue.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setAnimationRunning(boolean z) {
        this.isAnimationRunning.setValue(Boolean.valueOf(z));
    }

    public final boolean isAnimationRunning() {
        return ((Boolean) this.isAnimationRunning.getValue()).booleanValue();
    }

    public final FloatState getOffset() {
        return this.offsetState;
    }

    public final FloatState getOverflow() {
        return this.overflowState;
    }

    public final Map<Float, T> getAnchors$constraintlayout_compose_release() {
        return (Map) this.anchors.getValue();
    }

    public final void setAnchors$constraintlayout_compose_release(Map<Float, ? extends T> map) {
        this.anchors.setValue(map);
    }

    /* JADX INFO: renamed from: getMinBound$constraintlayout_compose_release, reason: from getter */
    public final float getMinBound() {
        return this.minBound;
    }

    public final void setMinBound$constraintlayout_compose_release(float f) {
        this.minBound = f;
    }

    /* JADX INFO: renamed from: getMaxBound$constraintlayout_compose_release, reason: from getter */
    public final float getMaxBound() {
        return this.maxBound;
    }

    public final void setMaxBound$constraintlayout_compose_release(float f) {
        this.maxBound = f;
    }

    public final void ensureInit$constraintlayout_compose_release(Map<Float, ? extends T> newAnchors) {
        if (getAnchors$constraintlayout_compose_release().isEmpty()) {
            Float offset = CarouselSwipeableKt.getOffset(newAnchors, getCurrentValue());
            if (offset == null) {
                throw new IllegalArgumentException("The initial value must have an associated anchor.".toString());
            }
            this.offsetState.setFloatValue(offset.floatValue());
            this.absoluteOffset.setFloatValue(offset.floatValue());
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code duplicated, block: B:82:0x0219  */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00a9, code lost:
    
        if (snapInternalToOffset(r11, r0) == r1) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x01d4, code lost:
    
        if (r13 == r1) goto L81;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0, types: [androidx.constraintlayout.compose.carousel.CarouselSwipeableState, androidx.constraintlayout.compose.carousel.CarouselSwipeableState<T>, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r10v21 */
    /* JADX WARN: Type inference failed for: r10v23 */
    /* JADX WARN: Type inference failed for: r10v3, types: [androidx.constraintlayout.compose.carousel.CarouselSwipeableState] */
    /* JADX WARN: Type inference failed for: r10v32 */
    /* JADX WARN: Type inference failed for: r10v33 */
    /* JADX WARN: Type inference failed for: r10v4 */
    /* JADX WARN: Type inference failed for: r10v5, types: [androidx.constraintlayout.compose.carousel.CarouselSwipeableState, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r10v7, types: [androidx.constraintlayout.compose.carousel.CarouselSwipeableState] */
    /* JADX WARN: Type inference failed for: r11v10 */
    /* JADX WARN: Type inference failed for: r11v40, types: [float] */
    /* JADX WARN: Type inference failed for: r11v51 */
    /* JADX WARN: Type inference failed for: r11v52 */
    /* JADX WARN: Type inference failed for: r11v53 */
    /* JADX WARN: Type inference failed for: r11v54, types: [float] */
    /* JADX WARN: Type inference failed for: r11v65, types: [androidx.constraintlayout.compose.carousel.CarouselSwipeableState] */
    /* JADX WARN: Type inference failed for: r11v66 */
    /* JADX WARN: Type inference failed for: r11v70 */
    /* JADX WARN: Type inference failed for: r11v71 */
    /* JADX WARN: Type inference failed for: r11v81 */
    /* JADX WARN: Type inference failed for: r11v82 */
    /* JADX WARN: Type inference failed for: r11v83 */
    /* JADX WARN: Type inference failed for: r11v84 */
    /* JADX WARN: Type inference failed for: r11v85 */
    /* JADX WARN: Type inference failed for: r11v86 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object processNewAnchors$constraintlayout_compose_release(java.util.Map<java.lang.Float, ? extends T> r11, java.util.Map<java.lang.Float, ? extends T> r12, kotlin.coroutines.Continuation<? super kotlin.Unit> r13) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 644
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.compose.carousel.CarouselSwipeableState.processNewAnchors$constraintlayout_compose_release(java.util.Map, java.util.Map, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Function2<Float, Float, Float> getThresholds$constraintlayout_compose_release() {
        return (Function2) this.thresholds.getValue();
    }

    public final void setThresholds$constraintlayout_compose_release(Function2<? super Float, ? super Float, Float> function2) {
        this.thresholds.setValue(function2);
    }

    public final float getVelocityThreshold$constraintlayout_compose_release() {
        return this.velocityThreshold.getFloatValue();
    }

    public final void setVelocityThreshold$constraintlayout_compose_release(float f) {
        this.velocityThreshold.setFloatValue(f);
    }

    public final ResistanceConfig getResistance$constraintlayout_compose_release() {
        return (ResistanceConfig) this.resistance.getValue();
    }

    public final void setResistance$constraintlayout_compose_release(ResistanceConfig resistanceConfig) {
        this.resistance.setValue(resistanceConfig);
    }

    /* JADX INFO: renamed from: getDraggableState$constraintlayout_compose_release, reason: from getter */
    public final DraggableState getDraggableState() {
        return this.draggableState;
    }

    /* JADX INFO: renamed from: androidx.constraintlayout.compose.carousel.CarouselSwipeableState$snapInternalToOffset$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CarouselSwipeable.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/compose/foundation/gestures/DragScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.constraintlayout.compose.carousel.CarouselSwipeableState$snapInternalToOffset$2", f = "CarouselSwipeable.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C07902 extends SuspendLambda implements Function2<DragScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ float $target;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ CarouselSwipeableState<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C07902(float f, CarouselSwipeableState<T> carouselSwipeableState, Continuation<? super C07902> continuation) {
            super(2, continuation);
            this.$target = f;
            this.this$0 = carouselSwipeableState;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C07902 c07902 = new C07902(this.$target, this.this$0, continuation);
            c07902.L$0 = obj;
            return c07902;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(DragScope dragScope, Continuation<? super Unit> continuation) {
            return ((C07902) create(dragScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            ((DragScope) this.L$0).dragBy(this.$target - ((CarouselSwipeableState) this.this$0).absoluteOffset.getFloatValue());
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object snapInternalToOffset(float f, Continuation<? super Unit> continuation) {
        Object objDrag$default = DraggableState.drag$default(this.draggableState, null, new C07902(f, this, null), continuation, 1, null);
        return objDrag$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objDrag$default : Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: androidx.constraintlayout.compose.carousel.CarouselSwipeableState$animateInternalToOffset$2, reason: invalid class name */
    /* JADX INFO: compiled from: CarouselSwipeable.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/compose/foundation/gestures/DragScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "androidx.constraintlayout.compose.carousel.CarouselSwipeableState$animateInternalToOffset$2", f = "CarouselSwipeable.kt", i = {}, l = {209}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<DragScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ AnimationSpec<Float> $spec;
        final /* synthetic */ float $target;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ CarouselSwipeableState<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(CarouselSwipeableState<T> carouselSwipeableState, float f, AnimationSpec<Float> animationSpec, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.this$0 = carouselSwipeableState;
            this.$target = f;
            this.$spec = animationSpec;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.this$0, this.$target, this.$spec, continuation);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(DragScope dragScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(dragScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    final DragScope dragScope = (DragScope) this.L$0;
                    final Ref.FloatRef floatRef = new Ref.FloatRef();
                    floatRef.element = ((CarouselSwipeableState) this.this$0).absoluteOffset.getFloatValue();
                    ((CarouselSwipeableState) this.this$0).animationTarget.setValue(Boxing.boxFloat(this.$target));
                    this.this$0.setAnimationRunning(true);
                    this.label = 1;
                    if (Animatable.animateTo$default(AnimatableKt.Animatable$default(floatRef.element, 0.0f, 2, null), Boxing.boxFloat(this.$target), this.$spec, null, new Function1<Animatable<Float, AnimationVector1D>, Unit>() { // from class: androidx.constraintlayout.compose.carousel.CarouselSwipeableState.animateInternalToOffset.2.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Animatable<Float, AnimationVector1D> animatable) {
                            invoke2(animatable);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(Animatable<Float, AnimationVector1D> animatable) {
                            dragScope.dragBy(animatable.getValue().floatValue() - floatRef.element);
                            floatRef.element = animatable.getValue().floatValue();
                        }
                    }, this, 4, null) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                ((CarouselSwipeableState) this.this$0).animationTarget.setValue(null);
                this.this$0.setAnimationRunning(false);
                return Unit.INSTANCE;
            } catch (Throwable th) {
                ((CarouselSwipeableState) this.this$0).animationTarget.setValue(null);
                this.this$0.setAnimationRunning(false);
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object animateInternalToOffset(float f, AnimationSpec<Float> animationSpec, Continuation<? super Unit> continuation) {
        Object objDrag$default = DraggableState.drag$default(this.draggableState, null, new AnonymousClass2(this, f, animationSpec, null), continuation, 1, null);
        return objDrag$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objDrag$default : Unit.INSTANCE;
    }

    public final T getTargetValue() {
        float fComputeTarget;
        Float value = this.animationTarget.getValue();
        if (value != null) {
            fComputeTarget = value.floatValue();
        } else {
            float floatValue = getOffset().getFloatValue();
            Float offset = CarouselSwipeableKt.getOffset(getAnchors$constraintlayout_compose_release(), getCurrentValue());
            fComputeTarget = CarouselSwipeableKt.computeTarget(floatValue, offset != null ? offset.floatValue() : getOffset().getFloatValue(), getAnchors$constraintlayout_compose_release().keySet(), getThresholds$constraintlayout_compose_release(), 0.0f, Float.POSITIVE_INFINITY);
        }
        T t = getAnchors$constraintlayout_compose_release().get(Float.valueOf(fComputeTarget));
        return t == null ? getCurrentValue() : t;
    }

    public final SwipeProgress<T> getProgress() {
        Object currentValue;
        float floatValue;
        Object value;
        Pair pair;
        List listFindBounds = CarouselSwipeableKt.findBounds(getOffset().getFloatValue(), getAnchors$constraintlayout_compose_release().keySet());
        int size = listFindBounds.size();
        if (size == 0) {
            T currentValue2 = getCurrentValue();
            currentValue = getCurrentValue();
            floatValue = 1.0f;
            value = currentValue2;
        } else if (size == 1) {
            Object value2 = MapsKt.getValue(getAnchors$constraintlayout_compose_release(), listFindBounds.get(0));
            currentValue = MapsKt.getValue(getAnchors$constraintlayout_compose_release(), listFindBounds.get(0));
            floatValue = 1.0f;
            value = value2;
        } else {
            if (getDirection() > 0.0f) {
                pair = TuplesKt.to(listFindBounds.get(0), listFindBounds.get(1));
            } else {
                pair = TuplesKt.to(listFindBounds.get(1), listFindBounds.get(0));
            }
            float fFloatValue = ((Number) pair.component1()).floatValue();
            float fFloatValue2 = ((Number) pair.component2()).floatValue();
            value = MapsKt.getValue(getAnchors$constraintlayout_compose_release(), Float.valueOf(fFloatValue));
            currentValue = MapsKt.getValue(getAnchors$constraintlayout_compose_release(), Float.valueOf(fFloatValue2));
            floatValue = (getOffset().getFloatValue() - fFloatValue) / (fFloatValue2 - fFloatValue);
        }
        return new SwipeProgress<>(value, currentValue, floatValue);
    }

    public final float getDirection() {
        Float offset = CarouselSwipeableKt.getOffset(getAnchors$constraintlayout_compose_release(), getCurrentValue());
        if (offset == null) {
            return 0.0f;
        }
        return Math.signum(getOffset().getFloatValue() - offset.floatValue());
    }

    /* JADX INFO: renamed from: androidx.constraintlayout.compose.carousel.CarouselSwipeableState$snapTo$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CarouselSwipeable.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0007\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u0002H\u00020\u0004H\u008a@¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "anchors", "", "", "emit", "(Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    static final class C07912<T> implements FlowCollector {
        final /* synthetic */ T $targetValue;
        final /* synthetic */ CarouselSwipeableState<T> this$0;

        C07912(T t, CarouselSwipeableState<T> carouselSwipeableState) {
            this.$targetValue = t;
            this.this$0 = carouselSwipeableState;
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
            return emit((Map) obj, (Continuation<? super Unit>) continuation);
        }

        /* JADX WARN: Code duplicated, block: B:7:0x0014  */
        public final Object emit(Map<Float, ? extends T> map, Continuation<? super Unit> continuation) {
            CarouselSwipeableState$snapTo$2$emit$1 carouselSwipeableState$snapTo$2$emit$1;
            if (continuation instanceof CarouselSwipeableState$snapTo$2$emit$1) {
                carouselSwipeableState$snapTo$2$emit$1 = (CarouselSwipeableState$snapTo$2$emit$1) continuation;
                if ((carouselSwipeableState$snapTo$2$emit$1.label & Integer.MIN_VALUE) != 0) {
                    carouselSwipeableState$snapTo$2$emit$1.label -= Integer.MIN_VALUE;
                } else {
                    carouselSwipeableState$snapTo$2$emit$1 = new CarouselSwipeableState$snapTo$2$emit$1(this, continuation);
                }
            } else {
                carouselSwipeableState$snapTo$2$emit$1 = new CarouselSwipeableState$snapTo$2$emit$1(this, continuation);
            }
            Object obj = carouselSwipeableState$snapTo$2$emit$1.result;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = carouselSwipeableState$snapTo$2$emit$1.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Float offset = CarouselSwipeableKt.getOffset(map, this.$targetValue);
                if (offset == null) {
                    throw new IllegalArgumentException("The target value must have an associated anchor.".toString());
                }
                CarouselSwipeableState<T> carouselSwipeableState = this.this$0;
                float fFloatValue = offset.floatValue();
                carouselSwipeableState$snapTo$2$emit$1.L$0 = this;
                carouselSwipeableState$snapTo$2$emit$1.label = 1;
                if (carouselSwipeableState.snapInternalToOffset(fFloatValue, carouselSwipeableState$snapTo$2$emit$1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                this = (C07912) carouselSwipeableState$snapTo$2$emit$1.L$0;
                ResultKt.throwOnFailure(obj);
            }
            this.this$0.setCurrentValue(this.$targetValue);
            return Unit.INSTANCE;
        }
    }

    public final Object snapTo(T t, Continuation<? super Unit> continuation) {
        Object objCollect = this.latestNonEmptyAnchorsFlow.collect(new C07912(t, this), continuation);
        return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: androidx.constraintlayout.compose.carousel.CarouselSwipeableState$animateTo$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CarouselSwipeable.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0007\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u0002H\u00020\u0004H\u008a@¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "anchors", "", "", "emit", "(Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    static final class C07882<T> implements FlowCollector {
        final /* synthetic */ AnimationSpec<Float> $anim;
        final /* synthetic */ T $targetValue;
        final /* synthetic */ CarouselSwipeableState<T> this$0;

        C07882(T t, CarouselSwipeableState<T> carouselSwipeableState, AnimationSpec<Float> animationSpec) {
            this.$targetValue = t;
            this.this$0 = carouselSwipeableState;
            this.$anim = animationSpec;
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
            return emit((Map) obj, (Continuation<? super Unit>) continuation);
        }

        /* JADX WARN: Code duplicated, block: B:7:0x0014  */
        public final Object emit(Map<Float, ? extends T> map, Continuation<? super Unit> continuation) {
            CarouselSwipeableState$animateTo$2$emit$1 carouselSwipeableState$animateTo$2$emit$1;
            if (continuation instanceof CarouselSwipeableState$animateTo$2$emit$1) {
                carouselSwipeableState$animateTo$2$emit$1 = (CarouselSwipeableState$animateTo$2$emit$1) continuation;
                if ((carouselSwipeableState$animateTo$2$emit$1.label & Integer.MIN_VALUE) != 0) {
                    carouselSwipeableState$animateTo$2$emit$1.label -= Integer.MIN_VALUE;
                } else {
                    carouselSwipeableState$animateTo$2$emit$1 = new CarouselSwipeableState$animateTo$2$emit$1(this, continuation);
                }
            } else {
                carouselSwipeableState$animateTo$2$emit$1 = new CarouselSwipeableState$animateTo$2$emit$1(this, continuation);
            }
            Object obj = carouselSwipeableState$animateTo$2$emit$1.result;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = carouselSwipeableState$animateTo$2$emit$1.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    Float offset = CarouselSwipeableKt.getOffset(map, this.$targetValue);
                    if (offset == null) {
                        throw new IllegalArgumentException("The target value must have an associated anchor.".toString());
                    }
                    CarouselSwipeableState<T> carouselSwipeableState = this.this$0;
                    float fFloatValue = offset.floatValue();
                    AnimationSpec<Float> animationSpec = this.$anim;
                    carouselSwipeableState$animateTo$2$emit$1.L$0 = this;
                    carouselSwipeableState$animateTo$2$emit$1.L$1 = map;
                    carouselSwipeableState$animateTo$2$emit$1.label = 1;
                    if (carouselSwipeableState.animateInternalToOffset(fFloatValue, animationSpec, carouselSwipeableState$animateTo$2$emit$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    map = (Map) carouselSwipeableState$animateTo$2$emit$1.L$1;
                    this = (C07882) carouselSwipeableState$animateTo$2$emit$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                float floatValue = ((CarouselSwipeableState) this.this$0).absoluteOffset.getFloatValue();
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                for (Map.Entry<Float, ? extends T> entry : map.entrySet()) {
                    if (Math.abs(entry.getKey().floatValue() - floatValue) < 0.5f) {
                        linkedHashMap.put(entry.getKey(), entry.getValue());
                    }
                }
                Object objFirstOrNull = CollectionsKt.firstOrNull(linkedHashMap.values());
                if (objFirstOrNull == null) {
                    objFirstOrNull = this.this$0.getCurrentValue();
                }
                this.this$0.setCurrentValue(objFirstOrNull);
                return Unit.INSTANCE;
            } catch (Throwable th) {
                float floatValue2 = ((CarouselSwipeableState) this.this$0).absoluteOffset.getFloatValue();
                LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                for (Map.Entry<Float, ? extends T> entry2 : map.entrySet()) {
                    if (Math.abs(entry2.getKey().floatValue() - floatValue2) < 0.5f) {
                        linkedHashMap2.put(entry2.getKey(), entry2.getValue());
                    }
                }
                Object objFirstOrNull2 = CollectionsKt.firstOrNull(linkedHashMap2.values());
                if (objFirstOrNull2 == null) {
                    objFirstOrNull2 = this.this$0.getCurrentValue();
                }
                this.this$0.setCurrentValue(objFirstOrNull2);
                throw th;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object animateTo$default(CarouselSwipeableState carouselSwipeableState, Object obj, AnimationSpec animationSpec, Continuation continuation, int i, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: animateTo");
        }
        if ((i & 2) != 0) {
            animationSpec = carouselSwipeableState.animationSpec;
        }
        return carouselSwipeableState.animateTo(obj, animationSpec, continuation);
    }

    public final Object animateTo(T t, AnimationSpec<Float> animationSpec, Continuation<? super Unit> continuation) {
        Object objCollect = this.latestNonEmptyAnchorsFlow.collect(new C07882(t, this, animationSpec), continuation);
        return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
    }

    public final Object performFling(final float f, Continuation<? super Unit> continuation) {
        Object objCollect = this.latestNonEmptyAnchorsFlow.collect(new FlowCollector(this) { // from class: androidx.constraintlayout.compose.carousel.CarouselSwipeableState.performFling.2
            final /* synthetic */ CarouselSwipeableState<T> this$0;

            {
                this.this$0 = this;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation2) {
                return emit((Map) obj, (Continuation<? super Unit>) continuation2);
            }

            public final Object emit(Map<Float, ? extends T> map, Continuation<? super Unit> continuation2) {
                Float offset = CarouselSwipeableKt.getOffset(map, this.this$0.getCurrentValue());
                Intrinsics.checkNotNull(offset);
                float fFloatValue = offset.floatValue();
                T t = map.get(Boxing.boxFloat(CarouselSwipeableKt.computeTarget(this.this$0.getOffset().getFloatValue(), fFloatValue, map.keySet(), this.this$0.getThresholds$constraintlayout_compose_release(), f, this.this$0.getVelocityThreshold$constraintlayout_compose_release())));
                if (t != null && this.this$0.getConfirmStateChange$constraintlayout_compose_release().invoke(t).booleanValue()) {
                    Object objAnimateTo$default = CarouselSwipeableState.animateTo$default(this.this$0, t, null, continuation2, 2, null);
                    return objAnimateTo$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objAnimateTo$default : Unit.INSTANCE;
                }
                CarouselSwipeableState<T> carouselSwipeableState = this.this$0;
                Object objAnimateInternalToOffset = carouselSwipeableState.animateInternalToOffset(fFloatValue, carouselSwipeableState.getAnimationSpec$constraintlayout_compose_release(), continuation2);
                return objAnimateInternalToOffset == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objAnimateInternalToOffset : Unit.INSTANCE;
            }
        }, continuation);
        return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
    }

    public final float performDrag(float delta) {
        float fCoerceIn = RangesKt.coerceIn(this.absoluteOffset.getFloatValue() + delta, this.minBound, this.maxBound) - this.absoluteOffset.getFloatValue();
        if (Math.abs(fCoerceIn) > 0.0f) {
            this.draggableState.dispatchRawDelta(fCoerceIn);
        }
        return fCoerceIn;
    }

    /* JADX INFO: compiled from: CarouselSwipeable.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JD\u0010\u0003\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00060\u0005\u0012\u0004\u0012\u0002H\u00060\u0004\"\b\b\u0001\u0010\u0006*\u00020\u00012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u00020\f0\u000b¨\u0006\r"}, d2 = {"Landroidx/constraintlayout/compose/carousel/CarouselSwipeableState$Companion;", "", "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/constraintlayout/compose/carousel/CarouselSwipeableState;", ExifInterface.GPS_DIRECTION_TRUE, "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "confirmStateChange", "Lkotlin/Function1;", "", "constraintlayout-compose_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final <T> Saver<CarouselSwipeableState<T>, T> Saver(final AnimationSpec<Float> animationSpec, final Function1<? super T, Boolean> confirmStateChange) {
            return SaverKt.Saver(new Function2<SaverScope, CarouselSwipeableState<T>, T>() { // from class: androidx.constraintlayout.compose.carousel.CarouselSwipeableState$Companion$Saver$1
                @Override // kotlin.jvm.functions.Function2
                public final T invoke(SaverScope saverScope, CarouselSwipeableState<T> carouselSwipeableState) {
                    return carouselSwipeableState.getCurrentValue();
                }
            }, new Function1<T, CarouselSwipeableState<T>>() { // from class: androidx.constraintlayout.compose.carousel.CarouselSwipeableState$Companion$Saver$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final CarouselSwipeableState<T> invoke(T t) {
                    return new CarouselSwipeableState<>(t, animationSpec, confirmStateChange);
                }
            });
        }
    }
}
