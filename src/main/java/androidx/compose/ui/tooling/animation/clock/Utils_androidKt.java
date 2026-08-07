package androidx.compose.ui.tooling.animation.clock;

import androidx.compose.animation.core.Animation;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationVector;
import androidx.compose.animation.core.InfiniteRepeatableSpec;
import androidx.compose.animation.core.InfiniteTransition;
import androidx.compose.animation.core.KeyframesSpec;
import androidx.compose.animation.core.RepeatableSpec;
import androidx.compose.animation.core.SnapSpec;
import androidx.compose.animation.core.StartOffset;
import androidx.compose.animation.core.StartOffsetType;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.animation.core.VectorizedDurationBasedAnimationSpec;
import androidx.compose.animation.tooling.TransitionInfo;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.tooling.animation.states.TargetState;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import androidx.exifinterface.media.ExifInterface;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Utils.android.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\\\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010$\u001a\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0000\u001a\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H\u0000\u001a&\u0010\n\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u000bR\u0006\u0012\u0002\b\u00030\f0\u0001*\u0006\u0012\u0002\b\u00030\fH\u0000\u001aB\u0010\r\u001a\u00020\u000e\"\u0004\b\u0000\u0010\u000f\"\b\b\u0001\u0010\u0010*\u00020\u0011\"\u0004\b\u0002\u0010\u0012*\u0018\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u00100\u000bR\b\u0012\u0004\u0012\u0002H\u00120\f2\b\b\u0002\u0010\u0013\u001a\u00020\u0006H\u0000\u001aH\u0010\r\u001a\u00020\u000e\"\u0004\b\u0000\u0010\u000f\"\b\b\u0001\u0010\u0010*\u00020\u0011*\u000e\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u00100\u00142\u0006\u0010\u0015\u001a\u00020\u00022\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u000f0\u00172\b\b\u0002\u0010\u0013\u001a\u00020\u0006H\u0000\u001a>\u0010\r\u001a\u00020\u000e\"\u0004\b\u0000\u0010\u000f\"\b\b\u0001\u0010\u0010*\u00020\u0011*\u0012\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u00100\u0018R\u00020\u00192\b\b\u0002\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u0006H\u0000\u001a5\u0010\u001b\u001a\n\u0012\u0004\u0012\u0002H\u000f\u0018\u00010\u001c\"\u0004\b\u0000\u0010\u000f2\u0006\u0010\u001d\u001a\u0002H\u000f2\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u001fH\u0000¢\u0006\u0002\u0010!\"\u001a\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004¨\u0006\"²\u0006\n\u0010#\u001a\u00020\u0006X\u008a\u0084\u0002²\u0006\u001c\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u0002H\u000f0%\"\u0004\b\u0000\u0010\u000fX\u008a\u0084\u0002²\u0006\u001c\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u0002H\u000f0%\"\u0004\b\u0000\u0010\u000fX\u008a\u0084\u0002"}, d2 = {"IGNORE_TRANSITIONS", "", "", "getIGNORE_TRANSITIONS", "()Ljava/util/List;", "nanosToMillis", "", "timeNs", "millisToNanos", "timeMs", "allAnimations", "Landroidx/compose/animation/core/Transition$TransitionAnimationState;", "Landroidx/compose/animation/core/Transition;", "createTransitionInfo", "Landroidx/compose/animation/tooling/TransitionInfo;", ExifInterface.GPS_DIRECTION_TRUE, ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Landroidx/compose/animation/core/AnimationVector;", ExifInterface.LATITUDE_SOUTH, "stepMs", "Landroidx/compose/animation/core/Animation;", "label", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "Landroidx/compose/animation/core/InfiniteTransition$TransitionAnimationState;", "Landroidx/compose/animation/core/InfiniteTransition;", "endTimeMs", "parseParametersToValue", "Landroidx/compose/ui/tooling/animation/states/TargetState;", "currentValue", "par1", "", "par2", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Landroidx/compose/ui/tooling/animation/states/TargetState;", "ui-tooling", "startTimeMs", "values", ""}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class Utils_androidKt {
    private static final List<String> IGNORE_TRANSITIONS = CollectionsKt.listOf("TransformOriginInterruptionHandling");

    public static final long millisToNanos(long j) {
        return j * 1000000;
    }

    public static final List<String> getIGNORE_TRANSITIONS() {
        return IGNORE_TRANSITIONS;
    }

    public static final long nanosToMillis(long j) {
        return (j + ((long) 999999)) / ((long) 1000000);
    }

    public static final List<Transition<?>.TransitionAnimationState<?, ?>> allAnimations(Transition<?> transition) {
        List<Transition<?>> transitions = transition.getTransitions();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = transitions.iterator();
        while (it.hasNext()) {
            CollectionsKt.addAll(arrayList, allAnimations((Transition) it.next()));
        }
        return CollectionsKt.plus((Collection) transition.getAnimations(), (Iterable) arrayList);
    }

    public static /* synthetic */ TransitionInfo createTransitionInfo$default(Transition.TransitionAnimationState transitionAnimationState, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = 1;
        }
        return createTransitionInfo(transitionAnimationState, j);
    }

    public static final <T, V extends AnimationVector, S> TransitionInfo createTransitionInfo(Transition<S>.TransitionAnimationState<T, V> transitionAnimationState, long j) {
        return createTransitionInfo(transitionAnimationState.getAnimation(), transitionAnimationState.getLabel(), transitionAnimationState.getAnimationSpec(), j);
    }

    public static /* synthetic */ TransitionInfo createTransitionInfo$default(Animation animation, String str, AnimationSpec animationSpec, long j, int i, Object obj) {
        if ((i & 4) != 0) {
            j = 1;
        }
        return createTransitionInfo(animation, str, animationSpec, j);
    }

    public static final <T, V extends AnimationVector> TransitionInfo createTransitionInfo(final Animation<T, V> animation, String str, final AnimationSpec<T> animationSpec, final long j) {
        final long jNanosToMillis = nanosToMillis(animation.getDurationNanos());
        final Lazy lazy = LazyKt.lazy(new Function0() { // from class: androidx.compose.ui.tooling.animation.clock.Utils_androidKt$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Long.valueOf(Utils_androidKt.createTransitionInfo$lambda$0(animationSpec));
            }
        });
        return new TransitionInfo(str, animationSpec.getClass().getName(), createTransitionInfo$lambda$1(lazy), jNanosToMillis, createTransitionInfo$lambda$3(LazyKt.lazy(new Function0() { // from class: androidx.compose.ui.tooling.animation.clock.Utils_androidKt$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Utils_androidKt.createTransitionInfo$lambda$2(animation, jNanosToMillis, j, lazy);
            }
        })));
    }

    private static final long createTransitionInfo$lambda$1(Lazy<Long> lazy) {
        return lazy.getValue().longValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long createTransitionInfo$lambda$0(AnimationSpec animationSpec) {
        Number numberValueOf;
        if (animationSpec instanceof TweenSpec) {
            numberValueOf = Integer.valueOf(((TweenSpec) animationSpec).getDelay());
        } else if (animationSpec instanceof SnapSpec) {
            numberValueOf = Integer.valueOf(((SnapSpec) animationSpec).getDelay());
        } else if (animationSpec instanceof KeyframesSpec) {
            numberValueOf = Integer.valueOf(((KeyframesSpec) animationSpec).getConfig().getDelayMillis());
        } else if (animationSpec instanceof RepeatableSpec) {
            RepeatableSpec repeatableSpec = (RepeatableSpec) animationSpec;
            if (StartOffsetType.m523equalsimpl0(StartOffset.m516getOffsetTypeEo1U57Q(repeatableSpec.getInitialStartOffset()), StartOffsetType.INSTANCE.m527getDelayEo1U57Q())) {
                numberValueOf = Integer.valueOf(StartOffset.m515getOffsetMillisimpl(repeatableSpec.getInitialStartOffset()));
            } else {
                numberValueOf = 0L;
            }
        } else if (animationSpec instanceof InfiniteRepeatableSpec) {
            InfiniteRepeatableSpec infiniteRepeatableSpec = (InfiniteRepeatableSpec) animationSpec;
            if (StartOffsetType.m523equalsimpl0(StartOffset.m516getOffsetTypeEo1U57Q(infiniteRepeatableSpec.getInitialStartOffset()), StartOffsetType.INSTANCE.m527getDelayEo1U57Q())) {
                numberValueOf = Integer.valueOf(StartOffset.m515getOffsetMillisimpl(infiniteRepeatableSpec.getInitialStartOffset()));
            } else {
                numberValueOf = 0L;
            }
        } else {
            numberValueOf = animationSpec instanceof VectorizedDurationBasedAnimationSpec ? Integer.valueOf(((VectorizedDurationBasedAnimationSpec) animationSpec).getDelayMillis()) : 0L;
        }
        return numberValueOf.longValue();
    }

    private static final <T> Map<Long, T> createTransitionInfo$lambda$3(Lazy<? extends Map<Long, T>> lazy) {
        return lazy.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map createTransitionInfo$lambda$2(Animation animation, long j, long j2, Lazy lazy) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(Long.valueOf(createTransitionInfo$lambda$1(lazy)), animation.getValueFromNanos(millisToNanos(createTransitionInfo$lambda$1(lazy))));
        linkedHashMap.put(Long.valueOf(j), animation.getValueFromNanos(millisToNanos(j)));
        long jCreateTransitionInfo$lambda$1 = createTransitionInfo$lambda$1(lazy);
        while (jCreateTransitionInfo$lambda$1 <= j) {
            linkedHashMap.put(Long.valueOf(jCreateTransitionInfo$lambda$1), animation.getValueFromNanos(millisToNanos(jCreateTransitionInfo$lambda$1)));
            jCreateTransitionInfo$lambda$1 += j2;
        }
        return linkedHashMap;
    }

    public static /* synthetic */ TransitionInfo createTransitionInfo$default(InfiniteTransition.TransitionAnimationState transitionAnimationState, long j, long j2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = 1;
        }
        return createTransitionInfo(transitionAnimationState, j, j2);
    }

    public static final <T, V extends AnimationVector> TransitionInfo createTransitionInfo(final InfiniteTransition.TransitionAnimationState<T, V> transitionAnimationState, final long j, final long j2) {
        final long j3 = 0;
        return new TransitionInfo(transitionAnimationState.getLabel(), transitionAnimationState.getAnimationSpec().getClass().getName(), 0L, j2, createTransitionInfo$lambda$5(LazyKt.lazy(new Function0() { // from class: androidx.compose.ui.tooling.animation.clock.Utils_androidKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Utils_androidKt.createTransitionInfo$lambda$4(j3, transitionAnimationState, j2, j);
            }
        })));
    }

    private static final <T> Map<Long, T> createTransitionInfo$lambda$5(Lazy<? extends Map<Long, T>> lazy) {
        return lazy.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map createTransitionInfo$lambda$4(long j, InfiniteTransition.TransitionAnimationState transitionAnimationState, long j2, long j3) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(Long.valueOf(j), transitionAnimationState.getAnimation().getValueFromNanos(millisToNanos(j)));
        linkedHashMap.put(Long.valueOf(j2), transitionAnimationState.getAnimation().getValueFromNanos(millisToNanos(j2)));
        while (j <= j2) {
            linkedHashMap.put(Long.valueOf(j), transitionAnimationState.getAnimation().getValueFromNanos(millisToNanos(j)));
            j += j3;
        }
        return linkedHashMap;
    }

    private static final boolean parseParametersToValue$parametersAreValid(Object obj, Object obj2) {
        return (obj == null || obj2 == null || obj.getClass() != obj2.getClass()) ? false : true;
    }

    private static final boolean parseParametersToValue$parametersHasTheSameType(Object obj, Object obj2, Object obj3) {
        return obj.getClass() == obj2.getClass() && obj.getClass() == obj3.getClass();
    }

    private static final Dp parseParametersToValue$getDp(Object obj) {
        Dp dpM9685boximpl = obj instanceof Dp ? (Dp) obj : null;
        if (dpM9685boximpl == null) {
            Float f = obj instanceof Float ? (Float) obj : null;
            dpM9685boximpl = f != null ? Dp.m9685boximpl(Dp.m9687constructorimpl(f.floatValue())) : null;
            if (dpM9685boximpl == null) {
                Double d = obj instanceof Double ? (Double) obj : null;
                dpM9685boximpl = d != null ? Dp.m9685boximpl(Dp.m9687constructorimpl((float) d.doubleValue())) : null;
                if (dpM9685boximpl == null) {
                    Integer num = obj instanceof Integer ? (Integer) obj : null;
                    if (num != null) {
                        return Dp.m9685boximpl(Dp.m9687constructorimpl(num.intValue()));
                    }
                    return null;
                }
            }
        }
        return dpM9685boximpl;
    }

    private static final <T> TargetState<Dp> parseParametersToValue$parseDp(T t, Object obj, Object obj2) {
        if ((t instanceof Dp) && obj2 != null) {
            if ((obj instanceof Dp) && (obj2 instanceof Dp)) {
                return new TargetState<>(obj, obj2);
            }
            Dp parametersToValue$getDp = parseParametersToValue$getDp(obj);
            Dp parametersToValue$getDp2 = parseParametersToValue$getDp(obj2);
            if (parametersToValue$getDp != null && parametersToValue$getDp2 != null) {
                return new TargetState<>(parametersToValue$getDp, parametersToValue$getDp2);
            }
        }
        return null;
    }

    public static final <T> TargetState<T> parseParametersToValue(T t, Object obj, Object obj2) {
        TargetState<T> targetState;
        if (t == null) {
            return null;
        }
        TargetState<T> targetState2 = (TargetState<T>) parseParametersToValue$parseDp(t, obj, obj2);
        if (targetState2 != null) {
            return targetState2;
        }
        if (!parseParametersToValue$parametersAreValid(obj, obj2)) {
            return null;
        }
        Intrinsics.checkNotNull(obj2);
        if (parseParametersToValue$parametersHasTheSameType(t, obj, obj2)) {
            return new TargetState<>(obj, obj2);
        }
        if ((obj instanceof List) && (obj2 instanceof List)) {
            try {
                if (t instanceof IntSize) {
                    Object obj3 = ((List) obj).get(0);
                    Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type kotlin.Int");
                    int iIntValue = ((Integer) obj3).intValue();
                    Object obj4 = ((List) obj).get(1);
                    Intrinsics.checkNotNull(obj4, "null cannot be cast to non-null type kotlin.Int");
                    IntSize intSizeM9850boximpl = IntSize.m9850boximpl(IntSize.m9853constructorimpl((((long) iIntValue) << 32) | (((long) ((Integer) obj4).intValue()) & 4294967295L)));
                    Object obj5 = ((List) obj2).get(0);
                    Intrinsics.checkNotNull(obj5, "null cannot be cast to non-null type kotlin.Int");
                    int iIntValue2 = ((Integer) obj5).intValue();
                    Object obj6 = ((List) obj2).get(1);
                    Intrinsics.checkNotNull(obj6, "null cannot be cast to non-null type kotlin.Int");
                    targetState = new TargetState<>(intSizeM9850boximpl, IntSize.m9850boximpl(IntSize.m9853constructorimpl((((long) ((Integer) obj6).intValue()) & 4294967295L) | (((long) iIntValue2) << 32))));
                } else if (t instanceof IntOffset) {
                    Object obj7 = ((List) obj).get(0);
                    Intrinsics.checkNotNull(obj7, "null cannot be cast to non-null type kotlin.Int");
                    int iIntValue3 = ((Integer) obj7).intValue();
                    Object obj8 = ((List) obj).get(1);
                    Intrinsics.checkNotNull(obj8, "null cannot be cast to non-null type kotlin.Int");
                    IntOffset intOffsetM9806boximpl = IntOffset.m9806boximpl(IntOffset.m9809constructorimpl((((long) iIntValue3) << 32) | (((long) ((Integer) obj8).intValue()) & 4294967295L)));
                    Object obj9 = ((List) obj2).get(0);
                    Intrinsics.checkNotNull(obj9, "null cannot be cast to non-null type kotlin.Int");
                    int iIntValue4 = ((Integer) obj9).intValue();
                    Object obj10 = ((List) obj2).get(1);
                    Intrinsics.checkNotNull(obj10, "null cannot be cast to non-null type kotlin.Int");
                    targetState = new TargetState<>(intOffsetM9806boximpl, IntOffset.m9806boximpl(IntOffset.m9809constructorimpl((((long) ((Integer) obj10).intValue()) & 4294967295L) | (((long) iIntValue4) << 32))));
                } else if (t instanceof Size) {
                    Object obj11 = ((List) obj).get(0);
                    Intrinsics.checkNotNull(obj11, "null cannot be cast to non-null type kotlin.Float");
                    float fFloatValue = ((Float) obj11).floatValue();
                    Object obj12 = ((List) obj).get(1);
                    Intrinsics.checkNotNull(obj12, "null cannot be cast to non-null type kotlin.Float");
                    Size sizeM6626boximpl = Size.m6626boximpl(Size.m6629constructorimpl((((long) Float.floatToRawIntBits(fFloatValue)) << 32) | (((long) Float.floatToRawIntBits(((Float) obj12).floatValue())) & 4294967295L)));
                    Object obj13 = ((List) obj2).get(0);
                    Intrinsics.checkNotNull(obj13, "null cannot be cast to non-null type kotlin.Float");
                    float fFloatValue2 = ((Float) obj13).floatValue();
                    Object obj14 = ((List) obj2).get(1);
                    Intrinsics.checkNotNull(obj14, "null cannot be cast to non-null type kotlin.Float");
                    targetState = new TargetState<>(sizeM6626boximpl, Size.m6626boximpl(Size.m6629constructorimpl((((long) Float.floatToRawIntBits(((Float) obj14).floatValue())) & 4294967295L) | (Float.floatToRawIntBits(fFloatValue2) << 32))));
                } else if (t instanceof Offset) {
                    Object obj15 = ((List) obj).get(0);
                    Intrinsics.checkNotNull(obj15, "null cannot be cast to non-null type kotlin.Float");
                    float fFloatValue3 = ((Float) obj15).floatValue();
                    Object obj16 = ((List) obj).get(1);
                    Intrinsics.checkNotNull(obj16, "null cannot be cast to non-null type kotlin.Float");
                    Offset offsetM6558boximpl = Offset.m6558boximpl(Offset.m6561constructorimpl((((long) Float.floatToRawIntBits(fFloatValue3)) << 32) | (((long) Float.floatToRawIntBits(((Float) obj16).floatValue())) & 4294967295L)));
                    Object obj17 = ((List) obj2).get(0);
                    Intrinsics.checkNotNull(obj17, "null cannot be cast to non-null type kotlin.Float");
                    float fFloatValue4 = ((Float) obj17).floatValue();
                    Object obj18 = ((List) obj2).get(1);
                    Intrinsics.checkNotNull(obj18, "null cannot be cast to non-null type kotlin.Float");
                    targetState = new TargetState<>(offsetM6558boximpl, Offset.m6558boximpl(Offset.m6561constructorimpl((((long) Float.floatToRawIntBits(((Float) obj18).floatValue())) & 4294967295L) | (Float.floatToRawIntBits(fFloatValue4) << 32))));
                } else if (t instanceof Rect) {
                    Object obj19 = ((List) obj).get(0);
                    Intrinsics.checkNotNull(obj19, "null cannot be cast to non-null type kotlin.Float");
                    float fFloatValue5 = ((Float) obj19).floatValue();
                    Object obj20 = ((List) obj).get(1);
                    Intrinsics.checkNotNull(obj20, "null cannot be cast to non-null type kotlin.Float");
                    float fFloatValue6 = ((Float) obj20).floatValue();
                    Object obj21 = ((List) obj).get(2);
                    Intrinsics.checkNotNull(obj21, "null cannot be cast to non-null type kotlin.Float");
                    float fFloatValue7 = ((Float) obj21).floatValue();
                    Object obj22 = ((List) obj).get(3);
                    Intrinsics.checkNotNull(obj22, "null cannot be cast to non-null type kotlin.Float");
                    Rect rect = new Rect(fFloatValue5, fFloatValue6, fFloatValue7, ((Float) obj22).floatValue());
                    Object obj23 = ((List) obj2).get(0);
                    Intrinsics.checkNotNull(obj23, "null cannot be cast to non-null type kotlin.Float");
                    float fFloatValue8 = ((Float) obj23).floatValue();
                    Object obj24 = ((List) obj2).get(1);
                    Intrinsics.checkNotNull(obj24, "null cannot be cast to non-null type kotlin.Float");
                    float fFloatValue9 = ((Float) obj24).floatValue();
                    Object obj25 = ((List) obj2).get(2);
                    Intrinsics.checkNotNull(obj25, "null cannot be cast to non-null type kotlin.Float");
                    float fFloatValue10 = ((Float) obj25).floatValue();
                    Object obj26 = ((List) obj2).get(3);
                    Intrinsics.checkNotNull(obj26, "null cannot be cast to non-null type kotlin.Float");
                    targetState = new TargetState<>(rect, new Rect(fFloatValue8, fFloatValue9, fFloatValue10, ((Float) obj26).floatValue()));
                } else if (t instanceof Color) {
                    Object obj27 = ((List) obj).get(0);
                    Intrinsics.checkNotNull(obj27, "null cannot be cast to non-null type kotlin.Float");
                    float fFloatValue11 = ((Float) obj27).floatValue();
                    Object obj28 = ((List) obj).get(1);
                    Intrinsics.checkNotNull(obj28, "null cannot be cast to non-null type kotlin.Float");
                    float fFloatValue12 = ((Float) obj28).floatValue();
                    Object obj29 = ((List) obj).get(2);
                    Intrinsics.checkNotNull(obj29, "null cannot be cast to non-null type kotlin.Float");
                    float fFloatValue13 = ((Float) obj29).floatValue();
                    Object obj30 = ((List) obj).get(3);
                    Intrinsics.checkNotNull(obj30, "null cannot be cast to non-null type kotlin.Float");
                    Color colorM6804boximpl = Color.m6804boximpl(ColorKt.Color$default(fFloatValue11, fFloatValue12, fFloatValue13, ((Float) obj30).floatValue(), null, 16, null));
                    Object obj31 = ((List) obj2).get(0);
                    Intrinsics.checkNotNull(obj31, "null cannot be cast to non-null type kotlin.Float");
                    float fFloatValue14 = ((Float) obj31).floatValue();
                    Object obj32 = ((List) obj2).get(1);
                    Intrinsics.checkNotNull(obj32, "null cannot be cast to non-null type kotlin.Float");
                    float fFloatValue15 = ((Float) obj32).floatValue();
                    Object obj33 = ((List) obj2).get(2);
                    Intrinsics.checkNotNull(obj33, "null cannot be cast to non-null type kotlin.Float");
                    float fFloatValue16 = ((Float) obj33).floatValue();
                    Object obj34 = ((List) obj2).get(3);
                    Intrinsics.checkNotNull(obj34, "null cannot be cast to non-null type kotlin.Float");
                    targetState = new TargetState<>(colorM6804boximpl, Color.m6804boximpl(ColorKt.Color$default(fFloatValue14, fFloatValue15, fFloatValue16, ((Float) obj34).floatValue(), null, 16, null)));
                } else if (t instanceof Dp) {
                    Object obj35 = ((List) obj).get(0);
                    Intrinsics.checkNotNull(obj35);
                    Object obj36 = ((List) obj2).get(0);
                    Intrinsics.checkNotNull(obj36);
                    targetState = (TargetState<T>) parseParametersToValue$parseDp(t, obj35, obj36);
                } else if (parseParametersToValue$parametersAreValid(((List) obj).get(0), ((List) obj2).get(0))) {
                    Object obj37 = ((List) obj).get(0);
                    Intrinsics.checkNotNull(obj37);
                    Object obj38 = ((List) obj2).get(0);
                    Intrinsics.checkNotNull(obj38);
                    if (parseParametersToValue$parametersHasTheSameType(t, obj37, obj38)) {
                        targetState = new TargetState<>(((List) obj).get(0), ((List) obj2).get(0));
                    }
                }
                Intrinsics.checkNotNull(targetState, "null cannot be cast to non-null type androidx.compose.ui.tooling.animation.states.TargetState<T of androidx.compose.ui.tooling.animation.clock.Utils_androidKt.parseParametersToValue>");
                return targetState;
            } catch (ClassCastException | IllegalArgumentException | IndexOutOfBoundsException | NullPointerException unused) {
            }
        }
        return null;
    }
}
