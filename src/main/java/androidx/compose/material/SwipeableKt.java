package androidx.compose.material;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.foundation.gestures.DraggableKt;
import androidx.compose.foundation.gestures.DraggableState;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Swipeable.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010\"\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\u001aZ\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u0002H\u00022\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062#\b\u0002\u0010\b\u001a\u001d\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\tH\u0007¢\u0006\u0002\u0010\u000e\u001aI\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u0010\u001a\u0002H\u00022\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00120\t2\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0001¢\u0006\u0002\u0010\u0013\u001a³\u0001\u0010\u0014\u001a\u00020\u0015\"\u0004\b\u0000\u0010\u0002*\u00020\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u0002H\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\r2\b\b\u0002\u0010\u001c\u001a\u00020\r2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e28\b\u0002\u0010\u001f\u001a2\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(!\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020#0 2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010%2\b\b\u0002\u0010&\u001a\u00020'H\u0007¢\u0006\u0004\b(\u0010)\u001a$\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00070+2\u0006\u0010,\u001a\u00020\u00072\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00070-H\u0002\u001aP\u0010.\u001a\u00020\u00072\u0006\u0010,\u001a\u00020\u00072\u0006\u0010/\u001a\u00020\u00072\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00070-2\u0018\u0010\u001f\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070 2\u0006\u00100\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\u0007H\u0002\u001a-\u00101\u001a\u0004\u0018\u00010\u0007\"\u0004\b\u0000\u0010\u0002*\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u0002H\u00020\u00182\u0006\u0010\u0016\u001a\u0002H\u0002H\u0002¢\u0006\u0002\u00102\"*\u00103\u001a\u000204\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00018@X\u0081\u0004¢\u0006\f\u0012\u0004\b5\u00106\u001a\u0004\b7\u00108\"\u000e\u00109\u001a\u00020:X\u0082T¢\u0006\u0002\n\u0000¨\u0006;"}, d2 = {"rememberSwipeableState", "Landroidx/compose/material/SwipeableState;", ExifInterface.GPS_DIRECTION_TRUE, "", "initialValue", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "confirmStateChange", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "newValue", "", "(Ljava/lang/Object;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material/SwipeableState;", "rememberSwipeableStateFor", "value", "onValueChange", "", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Landroidx/compose/animation/core/AnimationSpec;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material/SwipeableState;", "swipeable", "Landroidx/compose/ui/Modifier;", "state", "anchors", "", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "enabled", "reverseDirection", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "thresholds", "Lkotlin/Function2;", TypedValues.TransitionType.S_FROM, TypedValues.TransitionType.S_TO, "Landroidx/compose/material/ThresholdConfig;", "resistance", "Landroidx/compose/material/ResistanceConfig;", "velocityThreshold", "Landroidx/compose/ui/unit/Dp;", "swipeable-pPrIpRY", "(Landroidx/compose/ui/Modifier;Landroidx/compose/material/SwipeableState;Ljava/util/Map;Landroidx/compose/foundation/gestures/Orientation;ZZLandroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Landroidx/compose/material/ResistanceConfig;F)Landroidx/compose/ui/Modifier;", "findBounds", "", "offset", "", "computeTarget", "lastValue", "velocity", "getOffset", "(Ljava/util/Map;Ljava/lang/Object;)Ljava/lang/Float;", "PreUpPostDownNestedScrollConnection", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "getPreUpPostDownNestedScrollConnection$annotations", "(Landroidx/compose/material/SwipeableState;)V", "getPreUpPostDownNestedScrollConnection", "(Landroidx/compose/material/SwipeableState;)Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "SwipeableDeprecation", "", "material"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class SwipeableKt {
    private static final String SwipeableDeprecation = "Material's Swipeable has been replaced by Foundation's AnchoredDraggable APIs. Please see developer.android.com for an overview of the changes and a migration guide.";

    public static /* synthetic */ void getPreUpPostDownNestedScrollConnection$annotations(SwipeableState swipeableState) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean rememberSwipeableState$lambda$0$0(Object obj) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean rememberSwipeableStateFor$lambda$0$0(Object obj) {
        return true;
    }

    @Deprecated(message = SwipeableDeprecation)
    public static final <T> SwipeableState<T> rememberSwipeableState(final T t, final AnimationSpec<Float> animationSpec, final Function1<? super T, Boolean> function1, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, -1237755169, "C(rememberSwipeableState)N(initialValue,animationSpec,confirmStateChange)465@19542L8,473@19778L178,467@19586L370:Swipeable.kt#jmzs0o");
        if ((i2 & 2) != 0) {
            animationSpec = SwipeableDefaults.INSTANCE.getAnimationSpec();
        }
        if ((i2 & 4) != 0) {
            ComposerKt.sourceInformationMarkerStart(composer, 223228935, "CC(remember):Swipeable.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: androidx.compose.material.SwipeableKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return Boolean.valueOf(SwipeableKt.rememberSwipeableState$lambda$0$0(obj));
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            function1 = (Function1) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1237755169, i, -1, "androidx.compose.material.rememberSwipeableState (Swipeable.kt:466)");
        }
        Object[] objArr = new Object[0];
        Saver<SwipeableState<T>, T> Saver = SwipeableState.INSTANCE.Saver(animationSpec, function1);
        ComposerKt.sourceInformationMarkerStart(composer, 223236657, "CC(remember):Swipeable.kt#9igjgp");
        boolean z = true;
        boolean zChangedInstance = ((((i & 14) ^ 6) > 4 && composer.changedInstance(t)) || (i & 6) == 4) | composer.changedInstance(animationSpec);
        if ((((i & 896) ^ 384) <= 256 || !composer.changed(function1)) && (i & 384) != 256) {
            z = false;
        }
        boolean z2 = zChangedInstance | z;
        Object objRememberedValue2 = composer.rememberedValue();
        if (z2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue2 = new Function0() { // from class: androidx.compose.material.SwipeableKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return SwipeableKt.rememberSwipeableState$lambda$1$0(t, animationSpec, function1);
                }
            };
            composer.updateRememberedValue(objRememberedValue2);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        SwipeableState<T> swipeableState = (SwipeableState) RememberSaveableKt.m6247rememberSaveable(objArr, (Saver) Saver, (Function0) objRememberedValue2, composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return swipeableState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SwipeableState rememberSwipeableState$lambda$1$0(Object obj, AnimationSpec animationSpec, Function1 function1) {
        return new SwipeableState(obj, animationSpec, function1);
    }

    @Deprecated(message = SwipeableDeprecation)
    public static final <T> SwipeableState<T> rememberSwipeableStateFor(final T t, final Function1<? super T, Unit> function1, AnimationSpec<Float> animationSpec, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, 1156387078, "C(rememberSwipeableStateFor)N(value,onValueChange,animationSpec)498@20818L170,505@21019L34,506@21107L113,506@21058L162,511@21271L212,511@21225L258:Swipeable.kt#jmzs0o");
        if ((i2 & 4) != 0) {
            animationSpec = SwipeableDefaults.INSTANCE.getAnimationSpec();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1156387078, i, -1, "androidx.compose.material.rememberSwipeableStateFor (Swipeable.kt:497)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, -1108541392, "CC(remember):Swipeable.kt#9igjgp");
        Object objRememberedValue = composer.rememberedValue();
        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new SwipeableState(t, animationSpec, new Function1() { // from class: androidx.compose.material.SwipeableKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return Boolean.valueOf(SwipeableKt.rememberSwipeableStateFor$lambda$0$0(obj));
                }
            });
            composer.updateRememberedValue(objRememberedValue);
        }
        final SwipeableState<T> swipeableState = (SwipeableState) objRememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerStart(composer, -1108535096, "CC(remember):Swipeable.kt#9igjgp");
        Object objRememberedValue2 = composer.rememberedValue();
        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
            composer.updateRememberedValue(objRememberedValue2);
        }
        final MutableState mutableState = (MutableState) objRememberedValue2;
        ComposerKt.sourceInformationMarkerEnd(composer);
        Object value = mutableState.getValue();
        ComposerKt.sourceInformationMarkerStart(composer, -1108532201, "CC(remember):Swipeable.kt#9igjgp");
        int i3 = (i & 14) ^ 6;
        boolean z = (i3 > 4 && composer.changedInstance(t)) || (i & 6) == 4;
        SwipeableKt$rememberSwipeableStateFor$1$1 swipeableKt$rememberSwipeableStateFor$1$1RememberedValue = composer.rememberedValue();
        if (z || swipeableKt$rememberSwipeableStateFor$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
            swipeableKt$rememberSwipeableStateFor$1$1RememberedValue = new SwipeableKt$rememberSwipeableStateFor$1$1(t, swipeableState, null);
            composer.updateRememberedValue(swipeableKt$rememberSwipeableStateFor$1$1RememberedValue);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        int i4 = i & 8;
        EffectsKt.LaunchedEffect(t, value, (Function2) swipeableKt$rememberSwipeableStateFor$1$1RememberedValue, composer, i & 14);
        T currentValue = swipeableState.getCurrentValue();
        ComposerKt.sourceInformationMarkerStart(composer, -1108526854, "CC(remember):Swipeable.kt#9igjgp");
        boolean z2 = ((i3 > 4 && composer.changedInstance(t)) || (i & 6) == 4) | ((((i & 112) ^ 48) > 32 && composer.changed(function1)) || (i & 48) == 32);
        Object objRememberedValue3 = composer.rememberedValue();
        if (z2 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue3 = new Function1() { // from class: androidx.compose.material.SwipeableKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return SwipeableKt.rememberSwipeableStateFor$lambda$3$0(t, swipeableState, function1, mutableState, (DisposableEffectScope) obj);
                }
            };
            composer.updateRememberedValue(objRememberedValue3);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        EffectsKt.DisposableEffect(currentValue, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) objRememberedValue3, composer, i4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return swipeableState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult rememberSwipeableStateFor$lambda$3$0(Object obj, SwipeableState swipeableState, Function1 function1, MutableState mutableState, DisposableEffectScope disposableEffectScope) {
        if (!Intrinsics.areEqual(obj, swipeableState.getCurrentValue())) {
            function1.invoke(swipeableState.getCurrentValue());
            mutableState.setValue(Boolean.valueOf(!((Boolean) mutableState.getValue()).booleanValue()));
        }
        return new DisposableEffectResult() { // from class: androidx.compose.material.SwipeableKt$rememberSwipeableStateFor$lambda$3$0$$inlined$onDispose$1
            @Override // androidx.compose.runtime.DisposableEffectResult
            public void dispose() {
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FixedThreshold swipeable_pPrIpRY$lambda$0(Object obj, Object obj2) {
        return new FixedThreshold(Dp.m9687constructorimpl(56), null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Modifier swipeable_pPrIpRY$lambda$2(Map map, SwipeableState swipeableState, ResistanceConfig resistanceConfig, Function2 function2, float f, Orientation orientation, boolean z, MutableInteractionSource mutableInteractionSource, boolean z2, Modifier modifier, Composer composer, int i) {
        composer.startReplaceGroup(43594985);
        ComposerKt.sourceInformation(composer, "C589@25416L7,591@25497L495,591@25466L526,610@26281L55:Swipeable.kt#jmzs0o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(43594985, i, -1, "androidx.compose.material.swipeable.<anonymous> (Swipeable.kt:585)");
        }
        if (map.isEmpty()) {
            throw new IllegalArgumentException("You must have at least one anchor.".toString());
        }
        if (CollectionsKt.distinct(map.values()).size() != map.size()) {
            throw new IllegalArgumentException("You cannot have two anchors mapped to the same state.".toString());
        }
        ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localDensity);
        ComposerKt.sourceInformationMarkerEnd(composer);
        Density density = (Density) objConsume;
        swipeableState.ensureInit$material(map);
        ComposerKt.sourceInformationMarkerStart(composer, -1054880872, "CC(remember):Swipeable.kt#9igjgp");
        boolean zChanged = composer.changed(swipeableState) | composer.changedInstance(map) | composer.changed(resistanceConfig) | composer.changed(function2) | composer.changed(density) | composer.changed(f);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = (Function2) new SwipeableKt$swipeable$3$3$1(swipeableState, map, resistanceConfig, density, function2, f, null);
            composer.updateRememberedValue(objRememberedValue);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        EffectsKt.LaunchedEffect(map, swipeableState, (Function2) objRememberedValue, composer, 0);
        Modifier.Companion companion = Modifier.INSTANCE;
        boolean zIsAnimationRunning = swipeableState.isAnimationRunning();
        DraggableState draggableState = swipeableState.getDraggableState();
        Modifier.Companion companion2 = companion;
        ComposerKt.sourceInformationMarkerStart(composer, -1054856224, "CC(remember):Swipeable.kt#9igjgp");
        boolean zChanged2 = composer.changed(swipeableState);
        Object objRememberedValue2 = composer.rememberedValue();
        if (zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue2 = (Function3) new SwipeableKt$swipeable$3$4$1(swipeableState, null);
            composer.updateRememberedValue(objRememberedValue2);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        Modifier modifierDraggable$default = DraggableKt.draggable$default(companion2, draggableState, orientation, z, mutableInteractionSource, zIsAnimationRunning, null, (Function3) objRememberedValue2, z2, 32, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return modifierDraggable$default;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List<Float> findBounds(float f, Set<Float> set) {
        Object obj;
        Set<Float> set2 = set;
        ArrayList arrayList = new ArrayList();
        for (Object obj2 : set2) {
            if (((Number) obj2).floatValue() <= ((double) f) + 0.001d) {
                arrayList.add(obj2);
            }
        }
        ArrayList arrayList2 = arrayList;
        Object obj3 = null;
        if (!arrayList2.isEmpty()) {
            obj = arrayList2.get(0);
            float fFloatValue = ((Number) obj).floatValue();
            int lastIndex = CollectionsKt.getLastIndex(arrayList2);
            if (1 <= lastIndex) {
                int i = 1;
                while (true) {
                    Object obj4 = arrayList2.get(i);
                    float fFloatValue2 = ((Number) obj4).floatValue();
                    if (Float.compare(fFloatValue, fFloatValue2) < 0) {
                        obj = obj4;
                        fFloatValue = fFloatValue2;
                    }
                    if (i == lastIndex) {
                        break;
                    }
                    i++;
                }
            }
        } else {
            obj = null;
        }
        Float f2 = (Float) obj;
        ArrayList arrayList3 = new ArrayList();
        for (Object obj5 : set2) {
            if (((Number) obj5).floatValue() >= ((double) f) - 0.001d) {
                arrayList3.add(obj5);
            }
        }
        ArrayList arrayList4 = arrayList3;
        if (!arrayList4.isEmpty()) {
            Object obj6 = arrayList4.get(0);
            float fFloatValue3 = ((Number) obj6).floatValue();
            int lastIndex2 = CollectionsKt.getLastIndex(arrayList4);
            if (1 <= lastIndex2) {
                int i2 = 1;
                while (true) {
                    Object obj7 = arrayList4.get(i2);
                    float fFloatValue4 = ((Number) obj7).floatValue();
                    if (Float.compare(fFloatValue3, fFloatValue4) > 0) {
                        obj6 = obj7;
                        fFloatValue3 = fFloatValue4;
                    }
                    if (i2 == lastIndex2) {
                        break;
                    }
                    i2++;
                }
            }
            obj3 = obj6;
        }
        Float f3 = (Float) obj3;
        if (f2 == null) {
            return CollectionsKt.listOfNotNull(f3);
        }
        if (f3 == null) {
            return CollectionsKt.listOf(f2);
        }
        return Intrinsics.areEqual(f2, f3) ? CollectionsKt.listOf(f2) : CollectionsKt.listOf((Object[]) new Float[]{f2, f3});
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float computeTarget(float f, float f2, Set<Float> set, Function2<? super Float, ? super Float, Float> function2, float f3, float f4) {
        List<Float> listFindBounds = findBounds(f, set);
        int size = listFindBounds.size();
        if (size == 0) {
            return f2;
        }
        if (size == 1) {
            return listFindBounds.get(0).floatValue();
        }
        float fFloatValue = listFindBounds.get(0).floatValue();
        float fFloatValue2 = listFindBounds.get(1).floatValue();
        return (f2 > f ? f3 > (-f4) && f > function2.invoke(Float.valueOf(fFloatValue2), Float.valueOf(fFloatValue)).floatValue() : f3 >= f4 || f >= function2.invoke(Float.valueOf(fFloatValue), Float.valueOf(fFloatValue2)).floatValue()) ? fFloatValue2 : fFloatValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T> Float getOffset(Map<Float, ? extends T> map, T t) {
        T next;
        Iterator<T> it = map.entrySet().iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!Intrinsics.areEqual(((Map.Entry) next).getValue(), t));
        Map.Entry entry = (Map.Entry) next;
        if (entry != null) {
            return (Float) entry.getKey();
        }
        return null;
    }

    public static final <T> NestedScrollConnection getPreUpPostDownNestedScrollConnection(SwipeableState<T> swipeableState) {
        return new SwipeableKt$PreUpPostDownNestedScrollConnection$1(swipeableState);
    }

    @Deprecated(message = SwipeableDeprecation)
    /* JADX INFO: renamed from: swipeable-pPrIpRY, reason: not valid java name */
    public static final <T> Modifier m2594swipeablepPrIpRY(Modifier modifier, final SwipeableState<T> swipeableState, final Map<Float, ? extends T> map, final Orientation orientation, final boolean z, final boolean z2, final MutableInteractionSource mutableInteractionSource, final Function2<? super T, ? super T, ? extends ThresholdConfig> function2, final ResistanceConfig resistanceConfig, final float f) {
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.material.SwipeableKt$swipeable-pPrIpRY$$inlined$debugInspectorInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(InspectorInfo inspectorInfo) {
                invoke2(inspectorInfo);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(InspectorInfo inspectorInfo) {
                inspectorInfo.setName("swipeable");
                inspectorInfo.getProperties().set("state", swipeableState);
                inspectorInfo.getProperties().set("anchors", map);
                inspectorInfo.getProperties().set("orientation", orientation);
                inspectorInfo.getProperties().set("enabled", Boolean.valueOf(z));
                inspectorInfo.getProperties().set("reverseDirection", Boolean.valueOf(z2));
                inspectorInfo.getProperties().set("interactionSource", mutableInteractionSource);
                inspectorInfo.getProperties().set("thresholds", function2);
                inspectorInfo.getProperties().set("resistance", resistanceConfig);
                inspectorInfo.getProperties().set("velocityThreshold", Dp.m9685boximpl(f));
            }
        } : InspectableValueKt.getNoInspectorInfo(), new Function3() { // from class: androidx.compose.material.SwipeableKt$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return SwipeableKt.swipeable_pPrIpRY$lambda$2(map, swipeableState, resistanceConfig, function2, f, orientation, z, mutableInteractionSource, z2, (Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        });
    }
}
