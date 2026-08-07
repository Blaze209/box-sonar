package androidx.compose.material;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.FocusableKt;
import androidx.compose.foundation.HoverableKt;
import androidx.compose.foundation.IndicationKt;
import androidx.compose.foundation.ProgressSemanticsKt;
import androidx.compose.foundation.gestures.DragGestureDetectorKt;
import androidx.compose.foundation.gestures.DragScope;
import androidx.compose.foundation.gestures.DraggableKt;
import androidx.compose.foundation.gestures.DraggableState;
import androidx.compose.foundation.gestures.ForEachGestureKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.foundation.interaction.DragInteraction;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.BoxWithConstraintsKt;
import androidx.compose.foundation.layout.BoxWithConstraintsScope;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ShadowKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.PointMode;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.input.key.Key;
import androidx.compose.ui.input.key.KeyEvent;
import androidx.compose.ui.input.key.KeyEventType;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import androidx.compose.ui.input.key.KeyInputModifierKt;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerEventKt;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.util.MathHelpersKt;
import androidx.media3.common.C;
import androidx.media3.exoplayer.upstream.CmcdData;
import androidx.profileinstaller.ProfileVerifier;
import androidx.window.core.layout.WindowSizeClass;
import external.sdk.pendo.io.mozilla.javascript.Token;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.ClosedFloatingPointRange;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KFunction;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: compiled from: Slider.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0098\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\u001a\u007f\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b2\b\b\u0003\u0010\f\u001a\u00020\r2\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u0013H\u0007¢\u0006\u0002\u0010\u0014\u001aj\u0010\u0015\u001a\u00020\u0007*\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\r2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\t2\u0018\u0010\u0017\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00050\u00182\u0014\u0010\u0019\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000f0\u0018H\u0002\u001a\u007f\u0010\u001a\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b2\u0018\u0010\u0004\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u000b\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b2\b\b\u0003\u0010\f\u001a\u00020\r2\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000f2\b\b\u0002\u0010\u0012\u001a\u00020\u0013H\u0007¢\u0006\u0002\u0010\u001b\u001aK\u0010\u001c\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\u00032\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00030\u001f2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010 \u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u0007H\u0003¢\u0006\u0002\u0010!\u001ak\u0010\"\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\t2\u0006\u0010#\u001a\u00020\u00032\u0006\u0010$\u001a\u00020\u00032\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00030\u001f2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010 \u001a\u00020\u00032\u0006\u0010%\u001a\u00020\u00112\u0006\u0010&\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010'\u001a\u00020\u00072\u0006\u0010(\u001a\u00020\u0007H\u0003¢\u0006\u0002\u0010)\u001aC\u0010*\u001a\u00020\u0001*\u00020+2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010,\u001a\u00020-2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\b\u001a\u00020\t2\u0006\u0010.\u001a\u00020-H\u0003¢\u0006\u0004\b/\u00100\u001aS\u00101\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\b\u001a\u00020\t2\u0006\u0010#\u001a\u00020\u00032\u0006\u0010$\u001a\u00020\u00032\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00030\u001f2\u0006\u00102\u001a\u00020\u00032\u0006\u00103\u001a\u00020\u0003H\u0003¢\u0006\u0002\u00104\u001a.\u00105\u001a\u00020\u00032\u0006\u00106\u001a\u00020\u00032\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00030\u001f2\u0006\u00107\u001a\u00020\u00032\u0006\u00108\u001a\u00020\u0003H\u0002\u001a2\u00109\u001a\u0010\u0012\u0004\u0012\u00020;\u0012\u0004\u0012\u00020\u0003\u0018\u00010:*\u00020<2\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020@H\u0082@¢\u0006\u0004\bA\u0010B\u001a\u0016\u0010C\u001a\b\u0012\u0004\u0012\u00020\u00030\u001f2\u0006\u0010\f\u001a\u00020\rH\u0002\u001a0\u0010D\u001a\u00020\u00032\u0006\u0010E\u001a\u00020\u00032\u0006\u0010F\u001a\u00020\u00032\u0006\u0010G\u001a\u00020\u00032\u0006\u0010H\u001a\u00020\u00032\u0006\u0010I\u001a\u00020\u0003H\u0002\u001a<\u0010D\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b2\u0006\u0010E\u001a\u00020\u00032\u0006\u0010F\u001a\u00020\u00032\f\u0010J\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b2\u0006\u0010H\u001a\u00020\u00032\u0006\u0010I\u001a\u00020\u0003H\u0002\u001a \u0010K\u001a\u00020\u00032\u0006\u0010L\u001a\u00020\u00032\u0006\u0010M\u001a\u00020\u00032\u0006\u0010N\u001a\u00020\u0003H\u0002\u001aS\u0010O\u001a\u00020\u00012\u0012\u0010P\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00052\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b2\f\u0010Q\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b2\f\u0010R\u001a\b\u0012\u0004\u0012\u00020\u00030S2\u0006\u0010\u0002\u001a\u00020\u0003H\u0003¢\u0006\u0002\u0010T\u001a\\\u0010U\u001a\u00020\u0007*\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00052\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000f2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b2\b\b\u0002\u0010\f\u001a\u00020\rH\u0002\u001aj\u0010V\u001a\u00020\u0007*\u00020\u00072\u0006\u0010W\u001a\u00020X2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u00108\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\t2\f\u0010Y\u001a\b\u0012\u0004\u0012\u00020\u00030\u00182\u0018\u0010Z\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00050\u00182\f\u0010[\u001a\b\u0012\u0004\u0012\u00020\u00030S2\u0006\u0010\b\u001a\u00020\tH\u0002\u001a.\u0010\\\u001a\u00020\u00012\u0006\u0010W\u001a\u00020X2\u0006\u00106\u001a\u00020\u00032\u0006\u0010]\u001a\u00020\u00032\u0006\u0010^\u001a\u00020\u0003H\u0082@¢\u0006\u0002\u0010_\u001a\u0098\u0001\u0010`\u001a\u00020\u0007*\u00020\u00072\u0006\u0010%\u001a\u00020\u00112\u0006\u0010&\u001a\u00020\u00112\f\u0010a\u001a\b\u0012\u0004\u0012\u00020\u00030\u00182\f\u0010b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00182\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\t2\u0006\u00108\u001a\u00020\u00032\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b2\u0018\u0010Z\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\u00050\u00182\u001e\u0010c\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010d0\u0018H\u0002\"\u0016\u0010e\u001a\u00020-X\u0080\u0004¢\u0006\n\n\u0002\u0010h\u001a\u0004\bf\u0010g\"\u0010\u0010i\u001a\u00020-X\u0082\u0004¢\u0006\u0004\n\u0002\u0010h\"\u0010\u0010j\u001a\u00020-X\u0082\u0004¢\u0006\u0004\n\u0002\u0010h\"\u0010\u0010k\u001a\u00020-X\u0082\u0004¢\u0006\u0004\n\u0002\u0010h\"\u0016\u0010l\u001a\u00020-X\u0080\u0004¢\u0006\n\n\u0002\u0010h\u001a\u0004\bm\u0010g\"\u0010\u0010n\u001a\u00020-X\u0082\u0004¢\u0006\u0004\n\u0002\u0010h\"\u0010\u0010o\u001a\u00020-X\u0082\u0004¢\u0006\u0004\n\u0002\u0010h\"\u000e\u0010p\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010q\u001a\b\u0012\u0004\u0012\u00020\u00030rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006s"}, d2 = {"Slider", "", "value", "", "onValueChange", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", "valueRange", "Lkotlin/ranges/ClosedFloatingPointRange;", "steps", "", "onValueChangeFinished", "Lkotlin/Function0;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "colors", "Landroidx/compose/material/SliderColors;", "(FLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLkotlin/ranges/ClosedFloatingPointRange;ILkotlin/jvm/functions/Function0;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/material/SliderColors;Landroidx/compose/runtime/Composer;II)V", "slideOnKeyEvents", "isRtl", "onValueChangeState", "Landroidx/compose/runtime/State;", "onValueChangeFinishedState", "RangeSlider", "(Lkotlin/ranges/ClosedFloatingPointRange;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLkotlin/ranges/ClosedFloatingPointRange;ILkotlin/jvm/functions/Function0;Landroidx/compose/material/SliderColors;Landroidx/compose/runtime/Composer;II)V", "SliderImpl", "positionFraction", "tickFractions", "", "width", "(ZFLjava/util/List;Landroidx/compose/material/SliderColors;FLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)V", "RangeSliderImpl", "positionFractionStart", "positionFractionEnd", "startInteractionSource", "endInteractionSource", "startThumbSemantics", "endThumbSemantics", "(ZFFLjava/util/List;Landroidx/compose/material/SliderColors;FLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "SliderThumb", "Landroidx/compose/foundation/layout/BoxScope;", "offset", "Landroidx/compose/ui/unit/Dp;", "thumbSize", "SliderThumb-PcYyNuk", "(Landroidx/compose/foundation/layout/BoxScope;Landroidx/compose/ui/Modifier;FLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/material/SliderColors;ZFLandroidx/compose/runtime/Composer;I)V", "Track", "thumbPx", "trackStrokeWidth", "(Landroidx/compose/ui/Modifier;Landroidx/compose/material/SliderColors;ZFFLjava/util/List;FFLandroidx/compose/runtime/Composer;I)V", "snapValueToTick", "current", "minPx", "maxPx", "awaitSlop", "Lkotlin/Pair;", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "id", "Landroidx/compose/ui/input/pointer/PointerId;", "type", "Landroidx/compose/ui/input/pointer/PointerType;", "awaitSlop-8vUncbI", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;JILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "stepsToTickFractions", "scale", "a1", "b1", "x1", "a2", "b2", "x", "calcFraction", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "b", "pos", "CorrectValueSideEffect", "scaleToOffset", "trackRange", "valueState", "Landroidx/compose/runtime/MutableState;", "(Lkotlin/jvm/functions/Function1;Lkotlin/ranges/ClosedFloatingPointRange;Lkotlin/ranges/ClosedFloatingPointRange;Landroidx/compose/runtime/MutableState;FLandroidx/compose/runtime/Composer;I)V", "sliderSemantics", "sliderTapModifier", "draggableState", "Landroidx/compose/foundation/gestures/DraggableState;", "rawOffset", "gestureEndAction", "pressOffset", "animateToTarget", "target", "velocity", "(Landroidx/compose/foundation/gestures/DraggableState;FFFLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "rangeSliderPressDragModifier", "rawOffsetStart", "rawOffsetEnd", "onDrag", "Lkotlin/Function2;", "ThumbRadius", "getThumbRadius", "()F", "F", "ThumbRippleRadius", "ThumbDefaultElevation", "ThumbPressedElevation", "TrackHeight", "getTrackHeight", "SliderHeight", "SliderMinWidth", "DefaultSliderConstraints", "SliderToTickAnimation", "Landroidx/compose/animation/core/TweenSpec;", "material"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class SliderKt {
    private static final Modifier DefaultSliderConstraints;
    private static final float SliderHeight;
    private static final float SliderMinWidth;
    private static final TweenSpec<Float> SliderToTickAnimation;
    private static final float ThumbRadius = Dp.m9687constructorimpl(10);
    private static final float ThumbRippleRadius = Dp.m9687constructorimpl(24);
    private static final float ThumbDefaultElevation = Dp.m9687constructorimpl(1);
    private static final float ThumbPressedElevation = Dp.m9687constructorimpl(6);
    private static final float TrackHeight = Dp.m9687constructorimpl(4);

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CorrectValueSideEffect$lambda$1(Function1 function1, ClosedFloatingPointRange closedFloatingPointRange, ClosedFloatingPointRange closedFloatingPointRange2, MutableState mutableState, float f, int i, Composer composer, int i2) {
        CorrectValueSideEffect(function1, closedFloatingPointRange, closedFloatingPointRange2, mutableState, f, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RangeSlider$lambda$5(ClosedFloatingPointRange closedFloatingPointRange, Function1 function1, Modifier modifier, boolean z, ClosedFloatingPointRange closedFloatingPointRange2, int i, Function0 function0, SliderColors sliderColors, int i2, int i3, Composer composer, int i4) {
        RangeSlider(closedFloatingPointRange, function1, modifier, z, closedFloatingPointRange2, i, function0, sliderColors, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RangeSliderImpl$lambda$1(boolean z, float f, float f2, List list, SliderColors sliderColors, float f3, MutableInteractionSource mutableInteractionSource, MutableInteractionSource mutableInteractionSource2, Modifier modifier, Modifier modifier2, Modifier modifier3, int i, int i2, Composer composer, int i3) {
        RangeSliderImpl(z, f, f2, list, sliderColors, f3, mutableInteractionSource, mutableInteractionSource2, modifier, modifier2, modifier3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Slider$lambda$4(float f, Function1 function1, Modifier modifier, boolean z, ClosedFloatingPointRange closedFloatingPointRange, int i, Function0 function0, MutableInteractionSource mutableInteractionSource, SliderColors sliderColors, int i2, int i3, Composer composer, int i4) {
        Slider(f, function1, modifier, z, closedFloatingPointRange, i, function0, mutableInteractionSource, sliderColors, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SliderImpl$lambda$1(boolean z, float f, List list, SliderColors sliderColors, float f2, MutableInteractionSource mutableInteractionSource, Modifier modifier, int i, Composer composer, int i2) {
        SliderImpl(z, f, list, sliderColors, f2, mutableInteractionSource, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SliderThumb_PcYyNuk$lambda$1(BoxScope boxScope, Modifier modifier, float f, MutableInteractionSource mutableInteractionSource, SliderColors sliderColors, boolean z, float f2, int i, Composer composer, int i2) {
        m2549SliderThumbPcYyNuk(boxScope, modifier, f, mutableInteractionSource, sliderColors, z, f2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Track$lambda$1(Modifier modifier, SliderColors sliderColors, boolean z, float f, float f2, List list, float f3, float f4, int i, Composer composer, int i2) {
        Track(modifier, sliderColors, z, f, f2, list, f3, f4, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    private static final float calcFraction(float f, float f2, float f3) {
        float f4 = f2 - f;
        float f5 = f4 == 0.0f ? 0.0f : (f3 - f) / f4;
        float f6 = f5 >= 0.0f ? f5 : 0.0f;
        if (f6 > 1.0f) {
            return 1.0f;
        }
        return f6;
    }

    /* JADX WARN: Failed to calculate best type for var: r46v3 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r46v3 ??, new type: boolean
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 6 more
     */
    /* JADX WARN: Failed to calculate best type for var: r46v3 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r46v3 ??, new type: boolean
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r46v4 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r46v4 ??, new type: boolean
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r46v6 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r46v6 ??, new type: boolean
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /*  JADX ERROR: Types fix failed
        jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r46v3 ??, new type: boolean
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryPossibleTypes(FixTypesVisitor.java:186)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:245)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
        Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
        	... 5 more
        */
    public static final void Slider(float r39, kotlin.jvm.functions.Function1<? super java.lang.Float, kotlin.Unit> r40, androidx.compose.ui.Modifier r41, boolean r42, kotlin.ranges.ClosedFloatingPointRange<java.lang.Float> r43, int r44, kotlin.jvm.functions.Function0<kotlin.Unit> r45, androidx.compose.foundation.interaction.MutableInteractionSource r46, androidx.compose.material.SliderColors r47, androidx.compose.runtime.Composer r48, int r49, int r50) {
        /*
            Method dump skipped, instruction units count: 820
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.SliderKt.Slider(float, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, kotlin.ranges.ClosedFloatingPointRange, int, kotlin.jvm.functions.Function0, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.material.SliderColors, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit Slider$lambda$3(final ClosedFloatingPointRange closedFloatingPointRange, float f, final List list, final Function0 function0, MutableInteractionSource mutableInteractionSource, boolean z, SliderColors sliderColors, final State state, BoxWithConstraintsScope boxWithConstraintsScope, Composer composer, int i) {
        BoxWithConstraintsScope boxWithConstraintsScope2;
        int i2;
        final SliderDraggableState sliderDraggableState;
        Ref.FloatRef floatRef;
        ComposerKt.sourceInformation(composer, "C195@9057L7,200@9218L7,211@9632L24,212@9681L54,213@9762L36,216@9841L420,225@10294L15,225@10271L83,228@10437L633,228@10399L671,259@11645L55,266@11999L210:Slider.kt#jmzs0o");
        if ((i & 6) == 0) {
            boxWithConstraintsScope2 = boxWithConstraintsScope;
            i2 = i | (composer.changed(boxWithConstraintsScope2) ? 4 : 2);
        } else {
            boxWithConstraintsScope2 = boxWithConstraintsScope;
            i2 = i;
        }
        if (!composer.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2085116814, i2, -1, "androidx.compose.material.Slider.<anonymous> (Slider.kt:195)");
            }
            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composer.consume(localLayoutDirection);
            ComposerKt.sourceInformationMarkerEnd(composer);
            boolean z2 = objConsume == LayoutDirection.Rtl;
            float fM9640getMaxWidthimpl = Constraints.m9640getMaxWidthimpl(boxWithConstraintsScope2.mo1099getConstraintsmsEJaDk());
            final Ref.FloatRef floatRef2 = new Ref.FloatRef();
            final Ref.FloatRef floatRef3 = new Ref.FloatRef();
            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume2 = composer.consume(localDensity);
            ComposerKt.sourceInformationMarkerEnd(composer);
            Density density = (Density) objConsume2;
            float f2 = ThumbRadius;
            floatRef2.element = Math.max(fM9640getMaxWidthimpl - density.mo754toPx0680j_4(f2), 0.0f);
            floatRef3.element = Math.min(density.mo754toPx0680j_4(f2), floatRef2.element);
            ComposerKt.sourceInformationMarkerStart(composer, 773894976, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart(composer, 683736516, "CC(remember):Effects.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composer);
                composer.updateRememberedValue(objRememberedValue);
            }
            final CoroutineScope coroutineScope = (CoroutineScope) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, -1952447580, "CC(remember):Slider.kt#9igjgp");
            Object objRememberedValue2 = composer.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = PrimitiveSnapshotStateKt.mutableFloatStateOf(Slider$lambda$3$scaleToOffset(closedFloatingPointRange, floatRef3, floatRef2, f));
                composer.updateRememberedValue(objRememberedValue2);
            }
            final MutableFloatState mutableFloatState = (MutableFloatState) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, -1952445006, "CC(remember):Slider.kt#9igjgp");
            Object objRememberedValue3 = composer.rememberedValue();
            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = PrimitiveSnapshotStateKt.mutableFloatStateOf(0.0f);
                composer.updateRememberedValue(objRememberedValue3);
            }
            final MutableFloatState mutableFloatState2 = (MutableFloatState) objRememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, -1952442094, "CC(remember):Slider.kt#9igjgp");
            boolean zChanged = composer.changed(floatRef3.element) | composer.changed(floatRef2.element) | composer.changed(closedFloatingPointRange);
            Object objRememberedValue4 = composer.rememberedValue();
            if (zChanged || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                Function1 function1 = new Function1() { // from class: androidx.compose.material.SliderKt$$ExternalSyntheticLambda10
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return SliderKt.Slider$lambda$3$3$0(mutableFloatState, mutableFloatState2, floatRef3, floatRef2, state, closedFloatingPointRange, ((Float) obj).floatValue());
                    }
                };
                floatRef3 = floatRef3;
                Object sliderDraggableState2 = new SliderDraggableState(function1);
                composer.updateRememberedValue(sliderDraggableState2);
                objRememberedValue4 = sliderDraggableState2;
            }
            SliderDraggableState sliderDraggableState3 = (SliderDraggableState) objRememberedValue4;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, -1952428003, "CC(remember):Slider.kt#9igjgp");
            boolean zChanged2 = composer.changed(closedFloatingPointRange) | composer.changed(floatRef3.element) | composer.changed(floatRef2.element);
            Object objRememberedValue5 = composer.rememberedValue();
            if (zChanged2 || objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue5 = (KFunction) new SliderKt$Slider$2$2$1(closedFloatingPointRange, floatRef3, floatRef2);
                composer.updateRememberedValue(objRememberedValue5);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            final Ref.FloatRef floatRef4 = floatRef3;
            CorrectValueSideEffect((Function1) ((KFunction) objRememberedValue5), closedFloatingPointRange, RangesKt.rangeTo(floatRef3.element, floatRef2.element), mutableFloatState, f, composer, 3072);
            ComposerKt.sourceInformationMarkerStart(composer, -1952422809, "CC(remember):Slider.kt#9igjgp");
            boolean zChangedInstance = composer.changedInstance(list) | composer.changed(floatRef4.element) | composer.changed(floatRef2.element) | composer.changedInstance(coroutineScope) | composer.changedInstance(sliderDraggableState3) | composer.changed(function0);
            Object objRememberedValue6 = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                sliderDraggableState = sliderDraggableState3;
                Object obj = new Function1() { // from class: androidx.compose.material.SliderKt$$ExternalSyntheticLambda12
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return SliderKt.Slider$lambda$3$5$0(mutableFloatState, list, floatRef4, floatRef2, coroutineScope, sliderDraggableState, function0, ((Float) obj2).floatValue());
                    }
                };
                floatRef = floatRef2;
                composer.updateRememberedValue(obj);
                objRememberedValue6 = obj;
            } else {
                sliderDraggableState = sliderDraggableState3;
                floatRef = floatRef2;
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            State stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState((Function1) objRememberedValue6, composer, 0);
            SliderDraggableState sliderDraggableState4 = sliderDraggableState;
            Modifier modifierSliderTapModifier = sliderTapModifier(Modifier.INSTANCE, sliderDraggableState4, mutableInteractionSource, fM9640getMaxWidthimpl, z2, mutableFloatState, stateRememberUpdatedState, mutableFloatState2, z);
            Modifier.Companion companion = Modifier.INSTANCE;
            Orientation orientation = Orientation.Horizontal;
            boolean zIsDragging = sliderDraggableState.isDragging();
            Modifier.Companion companion2 = companion;
            ComposerKt.sourceInformationMarkerStart(composer, -1952384731, "CC(remember):Slider.kt#9igjgp");
            boolean zChanged3 = composer.changed(stateRememberUpdatedState);
            Object objRememberedValue7 = composer.rememberedValue();
            if (zChanged3 || objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue7 = (Function3) new SliderKt$Slider$2$drag$1$1(stateRememberUpdatedState, null);
                composer.updateRememberedValue(objRememberedValue7);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            SliderImpl(z, calcFraction(((Number) closedFloatingPointRange.getStart()).floatValue(), ((Number) closedFloatingPointRange.getEndInclusive()).floatValue(), RangesKt.coerceIn(f, ((Number) closedFloatingPointRange.getStart()).floatValue(), ((Number) closedFloatingPointRange.getEndInclusive()).floatValue())), list, sliderColors, floatRef.element - floatRef4.element, mutableInteractionSource, modifierSliderTapModifier.then(DraggableKt.draggable$default(companion2, sliderDraggableState4, orientation, z, mutableInteractionSource, zIsDragging, null, (Function3) objRememberedValue7, z2, 32, null)), composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    private static final float Slider$lambda$3$scaleToUserValue(Ref.FloatRef floatRef, Ref.FloatRef floatRef2, ClosedFloatingPointRange<Float> closedFloatingPointRange, float f) {
        return scale(floatRef.element, floatRef2.element, f, closedFloatingPointRange.getStart().floatValue(), closedFloatingPointRange.getEndInclusive().floatValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float Slider$lambda$3$scaleToOffset(ClosedFloatingPointRange<Float> closedFloatingPointRange, Ref.FloatRef floatRef, Ref.FloatRef floatRef2, float f) {
        return scale(closedFloatingPointRange.getStart().floatValue(), closedFloatingPointRange.getEndInclusive().floatValue(), f, floatRef.element, floatRef2.element);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Slider$lambda$3$3$0(MutableFloatState mutableFloatState, MutableFloatState mutableFloatState2, Ref.FloatRef floatRef, Ref.FloatRef floatRef2, State state, ClosedFloatingPointRange closedFloatingPointRange, float f) {
        mutableFloatState.setFloatValue(mutableFloatState.getFloatValue() + f + mutableFloatState2.getFloatValue());
        mutableFloatState2.setFloatValue(0.0f);
        ((Function1) state.getValue()).invoke(Float.valueOf(Slider$lambda$3$scaleToUserValue(floatRef, floatRef2, closedFloatingPointRange, RangesKt.coerceIn(mutableFloatState.getFloatValue(), floatRef.element, floatRef2.element))));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Slider$lambda$3$5$0(MutableFloatState mutableFloatState, List list, Ref.FloatRef floatRef, Ref.FloatRef floatRef2, CoroutineScope coroutineScope, SliderDraggableState sliderDraggableState, Function0 function0, float f) {
        float floatValue = mutableFloatState.getFloatValue();
        float fSnapValueToTick = snapValueToTick(floatValue, list, floatRef.element, floatRef2.element);
        if (floatValue != fSnapValueToTick) {
            BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new SliderKt$Slider$2$gestureEndAction$1$1$1(sliderDraggableState, floatValue, fSnapValueToTick, f, function0, null), 3, null);
        } else if (!sliderDraggableState.isDragging() && function0 != null) {
            function0.invoke();
        }
        return Unit.INSTANCE;
    }

    private static final Modifier slideOnKeyEvents(Modifier modifier, final boolean z, final int i, final ClosedFloatingPointRange<Float> closedFloatingPointRange, final float f, final boolean z2, final State<? extends Function1<? super Float, Unit>> state, final State<? extends Function0<Unit>> state2) {
        if (i < 0) {
            throw new IllegalArgumentException("steps should be >= 0".toString());
        }
        return KeyInputModifierKt.onKeyEvent(modifier, new Function1<KeyEvent, Boolean>() { // from class: androidx.compose.material.SliderKt.slideOnKeyEvents.2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Boolean invoke(KeyEvent keyEvent) {
                return m2552invokeZmokQxo(keyEvent.m7966unboximpl());
            }

            /* JADX INFO: renamed from: invoke-ZmokQxo, reason: not valid java name */
            public final Boolean m2552invokeZmokQxo(android.view.KeyEvent keyEvent) {
                boolean z3 = false;
                if (!z) {
                    return false;
                }
                int iM7978getTypeZmokQxo = KeyEvent_androidKt.m7978getTypeZmokQxo(keyEvent);
                if (KeyEventType.m7970equalsimpl0(iM7978getTypeZmokQxo, KeyEventType.INSTANCE.m7974getKeyDownCS__XNY())) {
                    float fAbs = Math.abs(closedFloatingPointRange.getEndInclusive().floatValue() - closedFloatingPointRange.getStart().floatValue());
                    int i2 = i;
                    int i3 = i2 > 0 ? i2 + 1 : 100;
                    float f2 = fAbs / i3;
                    long jM7977getKeyZmokQxo = KeyEvent_androidKt.m7977getKeyZmokQxo(keyEvent);
                    if (Key.m7669equalsimpl0(jM7977getKeyZmokQxo, Key.INSTANCE.m7747getDirectionUpEK5gGoQ())) {
                        state.getValue().invoke(RangesKt.coerceIn(Float.valueOf(f + f2), closedFloatingPointRange));
                    } else if (Key.m7669equalsimpl0(jM7977getKeyZmokQxo, Key.INSTANCE.m7742getDirectionDownEK5gGoQ())) {
                        state.getValue().invoke(RangesKt.coerceIn(Float.valueOf(f - f2), closedFloatingPointRange));
                    } else {
                        if (Key.m7669equalsimpl0(jM7977getKeyZmokQxo, Key.INSTANCE.m7746getDirectionRightEK5gGoQ())) {
                            state.getValue().invoke(RangesKt.coerceIn(Float.valueOf(f + ((z2 ? -1 : 1) * f2)), closedFloatingPointRange));
                        } else if (Key.m7669equalsimpl0(jM7977getKeyZmokQxo, Key.INSTANCE.m7745getDirectionLeftEK5gGoQ())) {
                            state.getValue().invoke(RangesKt.coerceIn(Float.valueOf(f - ((z2 ? -1 : 1) * f2)), closedFloatingPointRange));
                        } else if (Key.m7669equalsimpl0(jM7977getKeyZmokQxo, Key.INSTANCE.m7821getMoveHomeEK5gGoQ())) {
                            state.getValue().invoke(closedFloatingPointRange.getStart());
                        } else if (Key.m7669equalsimpl0(jM7977getKeyZmokQxo, Key.INSTANCE.m7820getMoveEndEK5gGoQ())) {
                            state.getValue().invoke(closedFloatingPointRange.getEndInclusive());
                        } else if (Key.m7669equalsimpl0(jM7977getKeyZmokQxo, Key.INSTANCE.m7858getPageUpEK5gGoQ())) {
                            state.getValue().invoke(RangesKt.coerceIn(Float.valueOf(f - (RangesKt.coerceIn(i3 / 10, 1, 10) * f2)), closedFloatingPointRange));
                        } else if (Key.m7669equalsimpl0(jM7977getKeyZmokQxo, Key.INSTANCE.m7857getPageDownEK5gGoQ())) {
                            state.getValue().invoke(RangesKt.coerceIn(Float.valueOf(f + (RangesKt.coerceIn(i3 / 10, 1, 10) * f2)), closedFloatingPointRange));
                        }
                    }
                    z3 = true;
                } else if (KeyEventType.m7970equalsimpl0(iM7978getTypeZmokQxo, KeyEventType.INSTANCE.m7975getKeyUpCS__XNY())) {
                    long jM7977getKeyZmokQxo2 = KeyEvent_androidKt.m7977getKeyZmokQxo(keyEvent);
                    if (Key.m7669equalsimpl0(jM7977getKeyZmokQxo2, Key.INSTANCE.m7747getDirectionUpEK5gGoQ()) || Key.m7669equalsimpl0(jM7977getKeyZmokQxo2, Key.INSTANCE.m7742getDirectionDownEK5gGoQ()) || Key.m7669equalsimpl0(jM7977getKeyZmokQxo2, Key.INSTANCE.m7746getDirectionRightEK5gGoQ()) || Key.m7669equalsimpl0(jM7977getKeyZmokQxo2, Key.INSTANCE.m7745getDirectionLeftEK5gGoQ()) || Key.m7669equalsimpl0(jM7977getKeyZmokQxo2, Key.INSTANCE.m7821getMoveHomeEK5gGoQ()) || Key.m7669equalsimpl0(jM7977getKeyZmokQxo2, Key.INSTANCE.m7820getMoveEndEK5gGoQ()) || Key.m7669equalsimpl0(jM7977getKeyZmokQxo2, Key.INSTANCE.m7858getPageUpEK5gGoQ()) || Key.m7669equalsimpl0(jM7977getKeyZmokQxo2, Key.INSTANCE.m7857getPageDownEK5gGoQ())) {
                        Function0<Unit> value = state2.getValue();
                        if (value != null) {
                            value.invoke();
                        }
                        z3 = true;
                    }
                }
                return Boolean.valueOf(z3);
            }
        });
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0135  */
    /* JADX WARN: Code duplicated, block: B:102:0x013c  */
    /* JADX WARN: Code duplicated, block: B:103:0x013e  */
    /* JADX WARN: Code duplicated, block: B:106:0x0144  */
    /* JADX WARN: Code duplicated, block: B:107:0x014e  */
    /* JADX WARN: Code duplicated, block: B:109:0x0151  */
    /* JADX WARN: Code duplicated, block: B:110:0x0154  */
    /* JADX WARN: Code duplicated, block: B:112:0x0158  */
    /* JADX WARN: Code duplicated, block: B:115:0x015d  */
    /* JADX WARN: Code duplicated, block: B:116:0x018c  */
    /* JADX WARN: Code duplicated, block: B:120:0x01a0  */
    /* JADX WARN: Code duplicated, block: B:123:0x01bd  */
    /* JADX WARN: Code duplicated, block: B:126:0x01dd  */
    /* JADX WARN: Code duplicated, block: B:129:0x01ed  */
    /* JADX WARN: Code duplicated, block: B:131:0x0200  */
    /* JADX WARN: Code duplicated, block: B:134:0x0208  */
    /* JADX WARN: Code duplicated, block: B:136:0x0210  */
    /* JADX WARN: Code duplicated, block: B:139:0x0279  */
    /* JADX WARN: Code duplicated, block: B:141:0x0286  */
    /* JADX WARN: Code duplicated, block: B:143:0x0293  */
    /* JADX WARN: Code duplicated, block: B:146:0x02a5  */
    /* JADX WARN: Code duplicated, block: B:148:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:30:0x0058  */
    /* JADX WARN: Code duplicated, block: B:31:0x005b  */
    /* JADX WARN: Code duplicated, block: B:33:0x005f  */
    /* JADX WARN: Code duplicated, block: B:35:0x0067  */
    /* JADX WARN: Code duplicated, block: B:36:0x006a  */
    /* JADX WARN: Code duplicated, block: B:41:0x0074  */
    /* JADX WARN: Code duplicated, block: B:43:0x0078  */
    /* JADX WARN: Code duplicated, block: B:45:0x0080  */
    /* JADX WARN: Code duplicated, block: B:46:0x0083  */
    /* JADX WARN: Code duplicated, block: B:49:0x0089  */
    /* JADX WARN: Code duplicated, block: B:52:0x0091  */
    /* JADX WARN: Code duplicated, block: B:53:0x0096  */
    /* JADX WARN: Code duplicated, block: B:55:0x009c  */
    /* JADX WARN: Code duplicated, block: B:57:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:58:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:62:0x00af  */
    /* JADX WARN: Code duplicated, block: B:63:0x00b4  */
    /* JADX WARN: Code duplicated, block: B:65:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:67:0x00c0  */
    /* JADX WARN: Code duplicated, block: B:68:0x00c3  */
    /* JADX WARN: Code duplicated, block: B:72:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:74:0x00d1  */
    /* JADX WARN: Code duplicated, block: B:76:0x00d9  */
    /* JADX WARN: Code duplicated, block: B:77:0x00dc  */
    /* JADX WARN: Code duplicated, block: B:80:0x00e3  */
    /* JADX WARN: Code duplicated, block: B:83:0x00f2  */
    /* JADX WARN: Code duplicated, block: B:84:0x00f4  */
    /* JADX WARN: Code duplicated, block: B:87:0x00fe  */
    /* JADX WARN: Code duplicated, block: B:89:0x0110  */
    /* JADX WARN: Code duplicated, block: B:99:0x0133 A[DONT_INVERT] */
    public static final void RangeSlider(final ClosedFloatingPointRange<Float> closedFloatingPointRange, final Function1<? super ClosedFloatingPointRange<Float>, Unit> function1, Modifier modifier, boolean z, ClosedFloatingPointRange<Float> closedFloatingPointRange2, int i, Function0<Unit> function0, SliderColors sliderColors, Composer composer, final int i2, final int i3) {
        int i4;
        Modifier modifier2;
        int i5;
        int i6;
        ClosedFloatingPointRange<Float> closedFloatingPointRange3;
        int i7;
        int i8;
        int i9;
        int i10;
        final Function0<Unit> function2;
        int i11;
        SliderColors sliderColors2;
        boolean z2;
        Composer composer2;
        final Function0<Unit> function3;
        final Modifier modifier3;
        final int i12;
        final boolean z3;
        final SliderColors sliderColors3;
        final ClosedFloatingPointRange<Float> closedFloatingPointRange4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        final boolean z4;
        ClosedFloatingPointRange<Float> closedFloatingPointRangeRangeTo;
        int i13;
        boolean z5;
        Composer composer3;
        int i14;
        final SliderColors sliderColorsM2536colorsq0g_0yA;
        final int i15;
        Object objRememberedValue;
        final MutableInteractionSource mutableInteractionSource;
        Object objRememberedValue2;
        final MutableInteractionSource mutableInteractionSource2;
        boolean z6;
        Object objRememberedValue3;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1556183027);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(RangeSlider)N(value,onValueChange,modifier,enabled,valueRange,steps,onValueChangeFinished,colors)405@18059L39,406@18156L39,409@18277L35,410@18337L47,417@18596L5354,412@18390L5560:Slider.kt#jmzs0o");
        if ((i2 & 6) == 0) {
            i4 = (composerStartRestartGroup.changed(closedFloatingPointRange) ? 4 : 2) | i2;
        } else {
            i4 = i2;
        }
        if ((i2 & 48) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(function1) ? 32 : 16;
        }
        int i16 = i3 & 4;
        if (i16 == 0) {
            if ((i2 & 384) == 0) {
                modifier2 = modifier;
                i4 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            i5 = i3 & 8;
            if (i5 != 0) {
                if ((i2 & 3072) == 0) {
                    if (composerStartRestartGroup.changed(z)) {
                        i6 = 2048;
                    } else {
                        i6 = 1024;
                    }
                    i4 |= i6;
                }
                if ((i2 & 24576) == 0) {
                    if ((i3 & 16) == 0) {
                        closedFloatingPointRange3 = closedFloatingPointRange2;
                        int i17 = composerStartRestartGroup.changed(closedFloatingPointRange3) ? 16384 : 8192;
                        i4 |= i17;
                    } else {
                        closedFloatingPointRange3 = closedFloatingPointRange2;
                    }
                    i4 |= i17;
                } else {
                    closedFloatingPointRange3 = closedFloatingPointRange2;
                }
                i7 = i3 & 32;
                if (i7 != 0) {
                    i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    i8 = i;
                } else {
                    i8 = i;
                    if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                        if (composerStartRestartGroup.changed(i8)) {
                            i9 = 131072;
                        } else {
                            i9 = 65536;
                        }
                        i4 |= i9;
                    }
                }
                i10 = i3 & 64;
                if (i10 != 0) {
                    i4 |= 1572864;
                    function2 = function0;
                } else {
                    function2 = function0;
                    if ((i2 & 1572864) == 0) {
                        if (composerStartRestartGroup.changedInstance(function2)) {
                            i11 = 1048576;
                        } else {
                            i11 = 524288;
                        }
                        i4 |= i11;
                    }
                }
                if ((i2 & 12582912) == 0) {
                    if ((i3 & 128) == 0) {
                        sliderColors2 = sliderColors;
                        int i18 = composerStartRestartGroup.changed(sliderColors2) ? 8388608 : 4194304;
                        i4 |= i18;
                    } else {
                        sliderColors2 = sliderColors;
                    }
                    i4 |= i18;
                } else {
                    sliderColors2 = sliderColors;
                }
                if ((i4 & 4793491) != 4793490) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z2, i4 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "403@17986L8");
                    if ((i2 & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                        if (i16 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i5 != 0) {
                            z4 = true;
                        } else {
                            z4 = z;
                        }
                        if ((i3 & 16) != 0) {
                            closedFloatingPointRangeRangeTo = RangesKt.rangeTo(0.0f, 1.0f);
                            i4 &= -57345;
                        } else {
                            closedFloatingPointRangeRangeTo = closedFloatingPointRange3;
                        }
                        if (i7 != 0) {
                            i13 = 0;
                        } else {
                            i13 = i8;
                        }
                        if (i10 != 0) {
                            function2 = null;
                        }
                        if ((i3 & 128) != 0) {
                            i14 = 131072;
                            composer3 = composerStartRestartGroup;
                            i4 &= -29360129;
                            z5 = true;
                            sliderColorsM2536colorsq0g_0yA = SliderDefaults.INSTANCE.m2536colorsq0g_0yA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, 1023);
                        } else {
                            z5 = true;
                            composer3 = composerStartRestartGroup;
                            i14 = 131072;
                            sliderColorsM2536colorsq0g_0yA = sliderColors2;
                        }
                        i15 = i13;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        if ((i3 & 16) != 0) {
                            i4 &= -57345;
                        }
                        if ((i3 & 128) != 0) {
                            i4 &= -29360129;
                        }
                        z4 = z;
                        sliderColorsM2536colorsq0g_0yA = sliderColors2;
                        z5 = true;
                        closedFloatingPointRangeRangeTo = closedFloatingPointRange3;
                        i15 = i8;
                        composer3 = composerStartRestartGroup;
                        function2 = function2;
                        i14 = 131072;
                    }
                    composer3.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1556183027, i4, -1, "androidx.compose.material.RangeSlider (Slider.kt:404)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composer3, -843255532, "CC(remember):Slider.kt#9igjgp");
                    objRememberedValue = composer3.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                        composer3.updateRememberedValue(objRememberedValue);
                    }
                    mutableInteractionSource = (MutableInteractionSource) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerStart(composer3, -843252428, "CC(remember):Slider.kt#9igjgp");
                    objRememberedValue2 = composer3.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = InteractionSourceKt.MutableInteractionSource();
                        composer3.updateRememberedValue(objRememberedValue2);
                    }
                    mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    if (i15 >= 0) {
                        throw new IllegalArgumentException("steps should be >= 0".toString());
                    }
                    final State stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(function1, composer3, (i4 >> 3) & 14);
                    ComposerKt.sourceInformationMarkerStart(composer3, -843246628, "CC(remember):Slider.kt#9igjgp");
                    z6 = (458752 & i4) == i14 ? z5 : false;
                    objRememberedValue3 = composer3.rememberedValue();
                    if (!z6 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue3 = stepsToTickFractions(i15);
                        composer3.updateRememberedValue(objRememberedValue3);
                    }
                    final List list = (List) objRememberedValue3;
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    Modifier modifierMinimumInteractiveComponentSize = InteractiveComponentSizeKt.minimumInteractiveComponentSize(modifier2);
                    float f = ThumbRadius;
                    Modifier modifierM1262requiredSizeInqDBjuR0$default = SizeKt.m1262requiredSizeInqDBjuR0$default(modifierMinimumInteractiveComponentSize, Dp.m9687constructorimpl(4 * f), Dp.m9687constructorimpl(f * 2), 0.0f, 0.0f, 12, null);
                    Composer composer4 = composer3;
                    final ClosedFloatingPointRange<Float> closedFloatingPointRange5 = closedFloatingPointRangeRangeTo;
                    BoxWithConstraintsKt.BoxWithConstraints(modifierM1262requiredSizeInqDBjuR0$default, null, false, ComposableLambdaKt.rememberComposableLambda(652589923, z5, new Function3() { // from class: androidx.compose.material.SliderKt$$ExternalSyntheticLambda15
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return SliderKt.RangeSlider$lambda$4(closedFloatingPointRange5, closedFloatingPointRange, list, function2, stateRememberUpdatedState, mutableInteractionSource, mutableInteractionSource2, z4, i15, sliderColorsM2536colorsq0g_0yA, (BoxWithConstraintsScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composer4, 54), composer4, 3072, 6);
                    composer2 = composer4;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                    closedFloatingPointRange4 = closedFloatingPointRange5;
                    function3 = function2;
                    z3 = z4;
                    i12 = i15;
                    sliderColors3 = sliderColorsM2536colorsq0g_0yA;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    function3 = function2;
                    modifier3 = modifier2;
                    i12 = i8;
                    z3 = z;
                    sliderColors3 = sliderColors2;
                    closedFloatingPointRange4 = closedFloatingPointRange3;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.SliderKt$$ExternalSyntheticLambda16
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return SliderKt.RangeSlider$lambda$5(closedFloatingPointRange, function1, modifier3, z3, closedFloatingPointRange4, i12, function3, sliderColors3, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i4 |= 3072;
            if ((i2 & 24576) == 0) {
                if ((i3 & 16) == 0) {
                    closedFloatingPointRange3 = closedFloatingPointRange2;
                    if (composerStartRestartGroup.changed(closedFloatingPointRange3)) {
                    }
                    i4 |= i17;
                } else {
                    closedFloatingPointRange3 = closedFloatingPointRange2;
                }
                i4 |= i17;
            } else {
                closedFloatingPointRange3 = closedFloatingPointRange2;
            }
            i7 = i3 & 32;
            if (i7 != 0) {
                i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                i8 = i;
            } else {
                i8 = i;
                if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    if (composerStartRestartGroup.changed(i8)) {
                        i9 = 131072;
                    } else {
                        i9 = 65536;
                    }
                    i4 |= i9;
                }
            }
            i10 = i3 & 64;
            if (i10 != 0) {
                i4 |= 1572864;
                function2 = function0;
            } else {
                function2 = function0;
                if ((i2 & 1572864) == 0) {
                    if (composerStartRestartGroup.changedInstance(function2)) {
                        i11 = 1048576;
                    } else {
                        i11 = 524288;
                    }
                    i4 |= i11;
                }
            }
            if ((i2 & 12582912) == 0) {
                if ((i3 & 128) == 0) {
                    sliderColors2 = sliderColors;
                    if (composerStartRestartGroup.changed(sliderColors2)) {
                    }
                    i4 |= i18;
                } else {
                    sliderColors2 = sliderColors;
                }
                i4 |= i18;
            } else {
                sliderColors2 = sliderColors;
            }
            if ((i4 & 4793491) != 4793490) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z2, i4 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "403@17986L8");
                if ((i2 & 1) != 0) {
                    if (i16 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i5 != 0) {
                        z4 = true;
                    } else {
                        z4 = z;
                    }
                    if ((i3 & 16) != 0) {
                        closedFloatingPointRangeRangeTo = RangesKt.rangeTo(0.0f, 1.0f);
                        i4 &= -57345;
                    } else {
                        closedFloatingPointRangeRangeTo = closedFloatingPointRange3;
                    }
                    if (i7 != 0) {
                        i13 = 0;
                    } else {
                        i13 = i8;
                    }
                    if (i10 != 0) {
                        function2 = null;
                    }
                    if ((i3 & 128) != 0) {
                        i14 = 131072;
                        composer3 = composerStartRestartGroup;
                        i4 &= -29360129;
                        z5 = true;
                        sliderColorsM2536colorsq0g_0yA = SliderDefaults.INSTANCE.m2536colorsq0g_0yA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, 1023);
                    } else {
                        z5 = true;
                        composer3 = composerStartRestartGroup;
                        i14 = 131072;
                        sliderColorsM2536colorsq0g_0yA = sliderColors2;
                    }
                    i15 = i13;
                } else {
                    if (i16 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i5 != 0) {
                        z4 = true;
                    } else {
                        z4 = z;
                    }
                    if ((i3 & 16) != 0) {
                        closedFloatingPointRangeRangeTo = RangesKt.rangeTo(0.0f, 1.0f);
                        i4 &= -57345;
                    } else {
                        closedFloatingPointRangeRangeTo = closedFloatingPointRange3;
                    }
                    if (i7 != 0) {
                        i13 = 0;
                    } else {
                        i13 = i8;
                    }
                    if (i10 != 0) {
                        function2 = null;
                    }
                    if ((i3 & 128) != 0) {
                        i14 = 131072;
                        composer3 = composerStartRestartGroup;
                        i4 &= -29360129;
                        z5 = true;
                        sliderColorsM2536colorsq0g_0yA = SliderDefaults.INSTANCE.m2536colorsq0g_0yA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, 1023);
                    } else {
                        z5 = true;
                        composer3 = composerStartRestartGroup;
                        i14 = 131072;
                        sliderColorsM2536colorsq0g_0yA = sliderColors2;
                    }
                    i15 = i13;
                }
                composer3.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1556183027, i4, -1, "androidx.compose.material.RangeSlider (Slider.kt:404)");
                }
                ComposerKt.sourceInformationMarkerStart(composer3, -843255532, "CC(remember):Slider.kt#9igjgp");
                objRememberedValue = composer3.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                    composer3.updateRememberedValue(objRememberedValue);
                }
                mutableInteractionSource = (MutableInteractionSource) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerStart(composer3, -843252428, "CC(remember):Slider.kt#9igjgp");
                objRememberedValue2 = composer3.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = InteractionSourceKt.MutableInteractionSource();
                    composer3.updateRememberedValue(objRememberedValue2);
                }
                mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composer3);
                if (i15 >= 0) {
                    throw new IllegalArgumentException("steps should be >= 0".toString());
                }
                final State stateRememberUpdatedState2 = SnapshotStateKt.rememberUpdatedState(function1, composer3, (i4 >> 3) & 14);
                ComposerKt.sourceInformationMarkerStart(composer3, -843246628, "CC(remember):Slider.kt#9igjgp");
                if ((458752 & i4) == i14) {
                }
                objRememberedValue3 = composer3.rememberedValue();
                if (!z6) {
                    objRememberedValue3 = stepsToTickFractions(i15);
                    composer3.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = stepsToTickFractions(i15);
                    composer3.updateRememberedValue(objRememberedValue3);
                }
                final List list2 = (List) objRememberedValue3;
                ComposerKt.sourceInformationMarkerEnd(composer3);
                Modifier modifierMinimumInteractiveComponentSize2 = InteractiveComponentSizeKt.minimumInteractiveComponentSize(modifier2);
                float f2 = ThumbRadius;
                Modifier modifierM1262requiredSizeInqDBjuR0$default2 = SizeKt.m1262requiredSizeInqDBjuR0$default(modifierMinimumInteractiveComponentSize2, Dp.m9687constructorimpl(4 * f2), Dp.m9687constructorimpl(f2 * 2), 0.0f, 0.0f, 12, null);
                Composer composer5 = composer3;
                final ClosedFloatingPointRange closedFloatingPointRange6 = closedFloatingPointRangeRangeTo;
                BoxWithConstraintsKt.BoxWithConstraints(modifierM1262requiredSizeInqDBjuR0$default2, null, false, ComposableLambdaKt.rememberComposableLambda(652589923, z5, new Function3() { // from class: androidx.compose.material.SliderKt$$ExternalSyntheticLambda15
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return SliderKt.RangeSlider$lambda$4(closedFloatingPointRange6, closedFloatingPointRange, list2, function2, stateRememberUpdatedState2, mutableInteractionSource, mutableInteractionSource2, z4, i15, sliderColorsM2536colorsq0g_0yA, (BoxWithConstraintsScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composer5, 54), composer5, 3072, 6);
                composer2 = composer5;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier2;
                closedFloatingPointRange4 = closedFloatingPointRange6;
                function3 = function2;
                z3 = z4;
                i12 = i15;
                sliderColors3 = sliderColorsM2536colorsq0g_0yA;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                function3 = function2;
                modifier3 = modifier2;
                i12 = i8;
                z3 = z;
                sliderColors3 = sliderColors2;
                closedFloatingPointRange4 = closedFloatingPointRange3;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.SliderKt$$ExternalSyntheticLambda16
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return SliderKt.RangeSlider$lambda$5(closedFloatingPointRange, function1, modifier3, z3, closedFloatingPointRange4, i12, function3, sliderColors3, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i4 |= 384;
        modifier2 = modifier;
        i5 = i3 & 8;
        if (i5 != 0) {
            if ((i2 & 3072) == 0) {
                if (composerStartRestartGroup.changed(z)) {
                    i6 = 2048;
                } else {
                    i6 = 1024;
                }
                i4 |= i6;
            }
            if ((i2 & 24576) == 0) {
                if ((i3 & 16) == 0) {
                    closedFloatingPointRange3 = closedFloatingPointRange2;
                    if (composerStartRestartGroup.changed(closedFloatingPointRange3)) {
                    }
                    i4 |= i17;
                } else {
                    closedFloatingPointRange3 = closedFloatingPointRange2;
                }
                i4 |= i17;
            } else {
                closedFloatingPointRange3 = closedFloatingPointRange2;
            }
            i7 = i3 & 32;
            if (i7 != 0) {
                i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                i8 = i;
            } else {
                i8 = i;
                if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    if (composerStartRestartGroup.changed(i8)) {
                        i9 = 131072;
                    } else {
                        i9 = 65536;
                    }
                    i4 |= i9;
                }
            }
            i10 = i3 & 64;
            if (i10 != 0) {
                i4 |= 1572864;
                function2 = function0;
            } else {
                function2 = function0;
                if ((i2 & 1572864) == 0) {
                    if (composerStartRestartGroup.changedInstance(function2)) {
                        i11 = 1048576;
                    } else {
                        i11 = 524288;
                    }
                    i4 |= i11;
                }
            }
            if ((i2 & 12582912) == 0) {
                if ((i3 & 128) == 0) {
                    sliderColors2 = sliderColors;
                    if (composerStartRestartGroup.changed(sliderColors2)) {
                    }
                    i4 |= i18;
                } else {
                    sliderColors2 = sliderColors;
                }
                i4 |= i18;
            } else {
                sliderColors2 = sliderColors;
            }
            if ((i4 & 4793491) != 4793490) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z2, i4 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "403@17986L8");
                if ((i2 & 1) != 0) {
                    if (i16 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i5 != 0) {
                        z4 = true;
                    } else {
                        z4 = z;
                    }
                    if ((i3 & 16) != 0) {
                        closedFloatingPointRangeRangeTo = RangesKt.rangeTo(0.0f, 1.0f);
                        i4 &= -57345;
                    } else {
                        closedFloatingPointRangeRangeTo = closedFloatingPointRange3;
                    }
                    if (i7 != 0) {
                        i13 = 0;
                    } else {
                        i13 = i8;
                    }
                    if (i10 != 0) {
                        function2 = null;
                    }
                    if ((i3 & 128) != 0) {
                        i14 = 131072;
                        composer3 = composerStartRestartGroup;
                        i4 &= -29360129;
                        z5 = true;
                        sliderColorsM2536colorsq0g_0yA = SliderDefaults.INSTANCE.m2536colorsq0g_0yA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, 1023);
                    } else {
                        z5 = true;
                        composer3 = composerStartRestartGroup;
                        i14 = 131072;
                        sliderColorsM2536colorsq0g_0yA = sliderColors2;
                    }
                    i15 = i13;
                } else {
                    if (i16 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i5 != 0) {
                        z4 = true;
                    } else {
                        z4 = z;
                    }
                    if ((i3 & 16) != 0) {
                        closedFloatingPointRangeRangeTo = RangesKt.rangeTo(0.0f, 1.0f);
                        i4 &= -57345;
                    } else {
                        closedFloatingPointRangeRangeTo = closedFloatingPointRange3;
                    }
                    if (i7 != 0) {
                        i13 = 0;
                    } else {
                        i13 = i8;
                    }
                    if (i10 != 0) {
                        function2 = null;
                    }
                    if ((i3 & 128) != 0) {
                        i14 = 131072;
                        composer3 = composerStartRestartGroup;
                        i4 &= -29360129;
                        z5 = true;
                        sliderColorsM2536colorsq0g_0yA = SliderDefaults.INSTANCE.m2536colorsq0g_0yA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, 1023);
                    } else {
                        z5 = true;
                        composer3 = composerStartRestartGroup;
                        i14 = 131072;
                        sliderColorsM2536colorsq0g_0yA = sliderColors2;
                    }
                    i15 = i13;
                }
                composer3.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1556183027, i4, -1, "androidx.compose.material.RangeSlider (Slider.kt:404)");
                }
                ComposerKt.sourceInformationMarkerStart(composer3, -843255532, "CC(remember):Slider.kt#9igjgp");
                objRememberedValue = composer3.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                    composer3.updateRememberedValue(objRememberedValue);
                }
                mutableInteractionSource = (MutableInteractionSource) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerStart(composer3, -843252428, "CC(remember):Slider.kt#9igjgp");
                objRememberedValue2 = composer3.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = InteractionSourceKt.MutableInteractionSource();
                    composer3.updateRememberedValue(objRememberedValue2);
                }
                mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composer3);
                if (i15 >= 0) {
                    throw new IllegalArgumentException("steps should be >= 0".toString());
                }
                final State stateRememberUpdatedState3 = SnapshotStateKt.rememberUpdatedState(function1, composer3, (i4 >> 3) & 14);
                ComposerKt.sourceInformationMarkerStart(composer3, -843246628, "CC(remember):Slider.kt#9igjgp");
                if ((458752 & i4) == i14) {
                }
                objRememberedValue3 = composer3.rememberedValue();
                if (!z6) {
                    objRememberedValue3 = stepsToTickFractions(i15);
                    composer3.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = stepsToTickFractions(i15);
                    composer3.updateRememberedValue(objRememberedValue3);
                }
                final List list3 = (List) objRememberedValue3;
                ComposerKt.sourceInformationMarkerEnd(composer3);
                Modifier modifierMinimumInteractiveComponentSize3 = InteractiveComponentSizeKt.minimumInteractiveComponentSize(modifier2);
                float f3 = ThumbRadius;
                Modifier modifierM1262requiredSizeInqDBjuR0$default3 = SizeKt.m1262requiredSizeInqDBjuR0$default(modifierMinimumInteractiveComponentSize3, Dp.m9687constructorimpl(4 * f3), Dp.m9687constructorimpl(f3 * 2), 0.0f, 0.0f, 12, null);
                Composer composer6 = composer3;
                final ClosedFloatingPointRange closedFloatingPointRange7 = closedFloatingPointRangeRangeTo;
                BoxWithConstraintsKt.BoxWithConstraints(modifierM1262requiredSizeInqDBjuR0$default3, null, false, ComposableLambdaKt.rememberComposableLambda(652589923, z5, new Function3() { // from class: androidx.compose.material.SliderKt$$ExternalSyntheticLambda15
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return SliderKt.RangeSlider$lambda$4(closedFloatingPointRange7, closedFloatingPointRange, list3, function2, stateRememberUpdatedState3, mutableInteractionSource, mutableInteractionSource2, z4, i15, sliderColorsM2536colorsq0g_0yA, (BoxWithConstraintsScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composer6, 54), composer6, 3072, 6);
                composer2 = composer6;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier2;
                closedFloatingPointRange4 = closedFloatingPointRange7;
                function3 = function2;
                z3 = z4;
                i12 = i15;
                sliderColors3 = sliderColorsM2536colorsq0g_0yA;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                function3 = function2;
                modifier3 = modifier2;
                i12 = i8;
                z3 = z;
                sliderColors3 = sliderColors2;
                closedFloatingPointRange4 = closedFloatingPointRange3;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.SliderKt$$ExternalSyntheticLambda16
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return SliderKt.RangeSlider$lambda$5(closedFloatingPointRange, function1, modifier3, z3, closedFloatingPointRange4, i12, function3, sliderColors3, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i4 |= 3072;
        if ((i2 & 24576) == 0) {
            if ((i3 & 16) == 0) {
                closedFloatingPointRange3 = closedFloatingPointRange2;
                if (composerStartRestartGroup.changed(closedFloatingPointRange3)) {
                }
                i4 |= i17;
            } else {
                closedFloatingPointRange3 = closedFloatingPointRange2;
            }
            i4 |= i17;
        } else {
            closedFloatingPointRange3 = closedFloatingPointRange2;
        }
        i7 = i3 & 32;
        if (i7 != 0) {
            i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            i8 = i;
        } else {
            i8 = i;
            if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                if (composerStartRestartGroup.changed(i8)) {
                    i9 = 131072;
                } else {
                    i9 = 65536;
                }
                i4 |= i9;
            }
        }
        i10 = i3 & 64;
        if (i10 != 0) {
            i4 |= 1572864;
            function2 = function0;
        } else {
            function2 = function0;
            if ((i2 & 1572864) == 0) {
                if (composerStartRestartGroup.changedInstance(function2)) {
                    i11 = 1048576;
                } else {
                    i11 = 524288;
                }
                i4 |= i11;
            }
        }
        if ((i2 & 12582912) == 0) {
            if ((i3 & 128) == 0) {
                sliderColors2 = sliderColors;
                if (composerStartRestartGroup.changed(sliderColors2)) {
                }
                i4 |= i18;
            } else {
                sliderColors2 = sliderColors;
            }
            i4 |= i18;
        } else {
            sliderColors2 = sliderColors;
        }
        if ((i4 & 4793491) != 4793490) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z2, i4 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "403@17986L8");
            if ((i2 & 1) != 0) {
                if (i16 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i5 != 0) {
                    z4 = true;
                } else {
                    z4 = z;
                }
                if ((i3 & 16) != 0) {
                    closedFloatingPointRangeRangeTo = RangesKt.rangeTo(0.0f, 1.0f);
                    i4 &= -57345;
                } else {
                    closedFloatingPointRangeRangeTo = closedFloatingPointRange3;
                }
                if (i7 != 0) {
                    i13 = 0;
                } else {
                    i13 = i8;
                }
                if (i10 != 0) {
                    function2 = null;
                }
                if ((i3 & 128) != 0) {
                    i14 = 131072;
                    composer3 = composerStartRestartGroup;
                    i4 &= -29360129;
                    z5 = true;
                    sliderColorsM2536colorsq0g_0yA = SliderDefaults.INSTANCE.m2536colorsq0g_0yA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, 1023);
                } else {
                    z5 = true;
                    composer3 = composerStartRestartGroup;
                    i14 = 131072;
                    sliderColorsM2536colorsq0g_0yA = sliderColors2;
                }
                i15 = i13;
            } else {
                if (i16 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i5 != 0) {
                    z4 = true;
                } else {
                    z4 = z;
                }
                if ((i3 & 16) != 0) {
                    closedFloatingPointRangeRangeTo = RangesKt.rangeTo(0.0f, 1.0f);
                    i4 &= -57345;
                } else {
                    closedFloatingPointRangeRangeTo = closedFloatingPointRange3;
                }
                if (i7 != 0) {
                    i13 = 0;
                } else {
                    i13 = i8;
                }
                if (i10 != 0) {
                    function2 = null;
                }
                if ((i3 & 128) != 0) {
                    i14 = 131072;
                    composer3 = composerStartRestartGroup;
                    i4 &= -29360129;
                    z5 = true;
                    sliderColorsM2536colorsq0g_0yA = SliderDefaults.INSTANCE.m2536colorsq0g_0yA(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 6, 1023);
                } else {
                    z5 = true;
                    composer3 = composerStartRestartGroup;
                    i14 = 131072;
                    sliderColorsM2536colorsq0g_0yA = sliderColors2;
                }
                i15 = i13;
            }
            composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1556183027, i4, -1, "androidx.compose.material.RangeSlider (Slider.kt:404)");
            }
            ComposerKt.sourceInformationMarkerStart(composer3, -843255532, "CC(remember):Slider.kt#9igjgp");
            objRememberedValue = composer3.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                composer3.updateRememberedValue(objRememberedValue);
            }
            mutableInteractionSource = (MutableInteractionSource) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer3);
            ComposerKt.sourceInformationMarkerStart(composer3, -843252428, "CC(remember):Slider.kt#9igjgp");
            objRememberedValue2 = composer3.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = InteractionSourceKt.MutableInteractionSource();
                composer3.updateRememberedValue(objRememberedValue2);
            }
            mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composer3);
            if (i15 >= 0) {
                throw new IllegalArgumentException("steps should be >= 0".toString());
            }
            final State stateRememberUpdatedState4 = SnapshotStateKt.rememberUpdatedState(function1, composer3, (i4 >> 3) & 14);
            ComposerKt.sourceInformationMarkerStart(composer3, -843246628, "CC(remember):Slider.kt#9igjgp");
            if ((458752 & i4) == i14) {
            }
            objRememberedValue3 = composer3.rememberedValue();
            if (!z6) {
                objRememberedValue3 = stepsToTickFractions(i15);
                composer3.updateRememberedValue(objRememberedValue3);
            } else {
                objRememberedValue3 = stepsToTickFractions(i15);
                composer3.updateRememberedValue(objRememberedValue3);
            }
            final List list4 = (List) objRememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(composer3);
            Modifier modifierMinimumInteractiveComponentSize4 = InteractiveComponentSizeKt.minimumInteractiveComponentSize(modifier2);
            float f4 = ThumbRadius;
            Modifier modifierM1262requiredSizeInqDBjuR0$default4 = SizeKt.m1262requiredSizeInqDBjuR0$default(modifierMinimumInteractiveComponentSize4, Dp.m9687constructorimpl(4 * f4), Dp.m9687constructorimpl(f4 * 2), 0.0f, 0.0f, 12, null);
            Composer composer7 = composer3;
            final ClosedFloatingPointRange closedFloatingPointRange8 = closedFloatingPointRangeRangeTo;
            BoxWithConstraintsKt.BoxWithConstraints(modifierM1262requiredSizeInqDBjuR0$default4, null, false, ComposableLambdaKt.rememberComposableLambda(652589923, z5, new Function3() { // from class: androidx.compose.material.SliderKt$$ExternalSyntheticLambda15
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return SliderKt.RangeSlider$lambda$4(closedFloatingPointRange8, closedFloatingPointRange, list4, function2, stateRememberUpdatedState4, mutableInteractionSource, mutableInteractionSource2, z4, i15, sliderColorsM2536colorsq0g_0yA, (BoxWithConstraintsScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer7, 54), composer7, 3072, 6);
            composer2 = composer7;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier2;
            closedFloatingPointRange4 = closedFloatingPointRange8;
            function3 = function2;
            z3 = z4;
            i12 = i15;
            sliderColors3 = sliderColorsM2536colorsq0g_0yA;
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            function3 = function2;
            modifier3 = modifier2;
            i12 = i8;
            z3 = z;
            sliderColors3 = sliderColors2;
            closedFloatingPointRange4 = closedFloatingPointRange3;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.SliderKt$$ExternalSyntheticLambda16
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SliderKt.RangeSlider$lambda$5(closedFloatingPointRange, function1, modifier3, z3, closedFloatingPointRange4, i12, function3, sliderColors3, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit RangeSlider$lambda$4(ClosedFloatingPointRange closedFloatingPointRange, final ClosedFloatingPointRange closedFloatingPointRange2, final List list, final Function0 function0, final State state, MutableInteractionSource mutableInteractionSource, MutableInteractionSource mutableInteractionSource2, boolean z, int i, SliderColors sliderColors, BoxWithConstraintsScope boxWithConstraintsScope, Composer composer, int i2) {
        BoxWithConstraintsScope boxWithConstraintsScope2;
        int i3;
        final Ref.FloatRef floatRef;
        Object obj;
        final Ref.FloatRef floatRef2;
        MutableFloatState mutableFloatState;
        MutableFloatState mutableFloatState2;
        final MutableFloatState mutableFloatState3;
        final MutableFloatState mutableFloatState4;
        final State state2;
        final ClosedFloatingPointRange closedFloatingPointRange3 = closedFloatingPointRange;
        ComposerKt.sourceInformation(composer, "C418@18639L7,423@18800L7,434@19228L60,435@19316L67,438@19429L15,437@19393L165,445@19603L15,444@19567L170,452@19759L24,454@19867L1029,454@19827L1069,480@20978L985,480@20931L1032,525@23062L63,534@23393L65,540@23603L341:Slider.kt#jmzs0o");
        if ((i2 & 6) == 0) {
            boxWithConstraintsScope2 = boxWithConstraintsScope;
            i3 = i2 | (composer.changed(boxWithConstraintsScope2) ? 4 : 2);
        } else {
            boxWithConstraintsScope2 = boxWithConstraintsScope;
            i3 = i2;
        }
        if (!composer.shouldExecute((i3 & 19) != 18, i3 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(652589923, i3, -1, "androidx.compose.material.RangeSlider.<anonymous> (Slider.kt:418)");
            }
            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composer.consume(localLayoutDirection);
            ComposerKt.sourceInformationMarkerEnd(composer);
            boolean z2 = objConsume == LayoutDirection.Rtl;
            float fM9640getMaxWidthimpl = Constraints.m9640getMaxWidthimpl(boxWithConstraintsScope2.mo1099getConstraintsmsEJaDk());
            Ref.FloatRef floatRef3 = new Ref.FloatRef();
            Ref.FloatRef floatRef4 = new Ref.FloatRef();
            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume2 = composer.consume(localDensity);
            ComposerKt.sourceInformationMarkerEnd(composer);
            Density density = (Density) objConsume2;
            float f = ThumbRadius;
            floatRef3.element = fM9640getMaxWidthimpl - density.mo754toPx0680j_4(f);
            floatRef4.element = density.mo754toPx0680j_4(f);
            ComposerKt.sourceInformationMarkerStart(composer, 73711071, "CC(remember):Slider.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = PrimitiveSnapshotStateKt.mutableFloatStateOf(RangeSlider$lambda$4$scaleToOffset(closedFloatingPointRange3, floatRef4, floatRef3, ((Number) closedFloatingPointRange2.getStart()).floatValue()));
                composer.updateRememberedValue(objRememberedValue);
            }
            final MutableFloatState mutableFloatState5 = (MutableFloatState) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 73713894, "CC(remember):Slider.kt#9igjgp");
            Object objRememberedValue2 = composer.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = PrimitiveSnapshotStateKt.mutableFloatStateOf(RangeSlider$lambda$4$scaleToOffset(closedFloatingPointRange3, floatRef4, floatRef3, ((Number) closedFloatingPointRange2.getEndInclusive()).floatValue()));
                composer.updateRememberedValue(objRememberedValue2);
            }
            final MutableFloatState mutableFloatState6 = (MutableFloatState) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 73717458, "CC(remember):Slider.kt#9igjgp");
            boolean zChanged = composer.changed(closedFloatingPointRange3) | composer.changed(floatRef4.element) | composer.changed(floatRef3.element);
            Object objRememberedValue3 = composer.rememberedValue();
            if (zChanged || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = (KFunction) new SliderKt$RangeSlider$2$2$1(closedFloatingPointRange3, floatRef4, floatRef3);
                composer.updateRememberedValue(objRememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            CorrectValueSideEffect((Function1) ((KFunction) objRememberedValue3), closedFloatingPointRange3, RangesKt.rangeTo(floatRef4.element, floatRef3.element), mutableFloatState5, ((Number) closedFloatingPointRange2.getStart()).floatValue(), composer, 3072);
            ComposerKt.sourceInformationMarkerStart(composer, 73723026, "CC(remember):Slider.kt#9igjgp");
            boolean zChanged2 = composer.changed(closedFloatingPointRange3) | composer.changed(floatRef4.element) | composer.changed(floatRef3.element);
            Object objRememberedValue4 = composer.rememberedValue();
            if (zChanged2 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue4 = (KFunction) new SliderKt$RangeSlider$2$3$1(closedFloatingPointRange3, floatRef4, floatRef3);
                composer.updateRememberedValue(objRememberedValue4);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            CorrectValueSideEffect((Function1) ((KFunction) objRememberedValue4), closedFloatingPointRange3, RangesKt.rangeTo(floatRef4.element, floatRef3.element), mutableFloatState6, ((Number) closedFloatingPointRange2.getEndInclusive()).floatValue(), composer, 3072);
            boolean z3 = z2;
            ComposerKt.sourceInformationMarkerStart(composer, 773894976, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart(composer, 683736516, "CC(remember):Effects.kt#9igjgp");
            Object objRememberedValue5 = composer.rememberedValue();
            if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue5 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composer);
                composer.updateRememberedValue(objRememberedValue5);
            }
            final CoroutineScope coroutineScope = (CoroutineScope) objRememberedValue5;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 73732488, "CC(remember):Slider.kt#9igjgp");
            boolean zChangedInstance = composer.changedInstance(list) | composer.changed(floatRef4.element) | composer.changed(floatRef3.element) | composer.changed(function0) | composer.changedInstance(coroutineScope) | composer.changed(state) | composer.changed(closedFloatingPointRange3);
            Object objRememberedValue6 = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                floatRef = floatRef3;
                floatRef2 = floatRef4;
                obj = new Function1() { // from class: androidx.compose.material.SliderKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return SliderKt.RangeSlider$lambda$4$5$0(mutableFloatState5, mutableFloatState6, list, floatRef2, floatRef, function0, coroutineScope, state, closedFloatingPointRange3, ((Boolean) obj2).booleanValue());
                    }
                };
                mutableFloatState = mutableFloatState6;
                mutableFloatState2 = mutableFloatState5;
                closedFloatingPointRange3 = closedFloatingPointRange3;
                composer.updateRememberedValue(obj);
            } else {
                obj = objRememberedValue6;
                floatRef = floatRef3;
                floatRef2 = floatRef4;
                mutableFloatState2 = mutableFloatState5;
                mutableFloatState = mutableFloatState6;
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            State stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState((Function1) obj, composer, 0);
            ComposerKt.sourceInformationMarkerStart(composer, 73767996, "CC(remember):Slider.kt#9igjgp");
            boolean zChanged3 = composer.changed(closedFloatingPointRange3) | composer.changed(floatRef2.element) | composer.changed(floatRef.element) | composer.changed(closedFloatingPointRange2) | composer.changed(state);
            Object objRememberedValue7 = composer.rememberedValue();
            if (zChanged3 || objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                final ClosedFloatingPointRange closedFloatingPointRange4 = closedFloatingPointRange3;
                mutableFloatState3 = mutableFloatState2;
                mutableFloatState4 = mutableFloatState;
                Object obj2 = new Function2() { // from class: androidx.compose.material.SliderKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj3, Object obj4) {
                        return SliderKt.RangeSlider$lambda$4$6$0(mutableFloatState3, mutableFloatState4, closedFloatingPointRange2, floatRef2, floatRef, state, closedFloatingPointRange4, ((Boolean) obj3).booleanValue(), ((Float) obj4).floatValue());
                    }
                };
                state2 = state;
                composer.updateRememberedValue(obj2);
                objRememberedValue7 = obj2;
            } else {
                mutableFloatState3 = mutableFloatState2;
                mutableFloatState4 = mutableFloatState;
                state2 = state;
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            Ref.FloatRef floatRef5 = floatRef2;
            Modifier modifierRangeSliderPressDragModifier = rangeSliderPressDragModifier(Modifier.INSTANCE, mutableInteractionSource, mutableInteractionSource2, mutableFloatState3, mutableFloatState4, z, z3, fM9640getMaxWidthimpl, closedFloatingPointRange, stateRememberUpdatedState, SnapshotStateKt.rememberUpdatedState((Function2) objRememberedValue7, composer, 0));
            final float fCoerceIn = RangesKt.coerceIn(((Number) closedFloatingPointRange2.getStart()).floatValue(), ((Number) closedFloatingPointRange.getStart()).floatValue(), ((Number) closedFloatingPointRange2.getEndInclusive()).floatValue());
            final float fCoerceIn2 = RangesKt.coerceIn(((Number) closedFloatingPointRange2.getEndInclusive()).floatValue(), ((Number) closedFloatingPointRange2.getStart()).floatValue(), ((Number) closedFloatingPointRange.getEndInclusive()).floatValue());
            float fCalcFraction = calcFraction(((Number) closedFloatingPointRange.getStart()).floatValue(), ((Number) closedFloatingPointRange.getEndInclusive()).floatValue(), fCoerceIn);
            float fCalcFraction2 = calcFraction(((Number) closedFloatingPointRange.getStart()).floatValue(), ((Number) closedFloatingPointRange.getEndInclusive()).floatValue(), fCoerceIn2);
            float f2 = i;
            int iFloor = (int) Math.floor(f2 * fCalcFraction2);
            int iFloor2 = (int) Math.floor(f2 * (1.0f - fCalcFraction));
            Modifier.Companion companion = Modifier.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 73833762, "CC(remember):Slider.kt#9igjgp");
            boolean zChanged4 = composer.changed(state2) | composer.changed(fCoerceIn2);
            Object objRememberedValue8 = composer.rememberedValue();
            if (zChanged4 || objRememberedValue8 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue8 = new Function1() { // from class: androidx.compose.material.SliderKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj3) {
                        return SliderKt.RangeSlider$lambda$4$7$0(state2, fCoerceIn2, ((Float) obj3).floatValue());
                    }
                };
                composer.updateRememberedValue(objRememberedValue8);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            Modifier modifierSliderSemantics = sliderSemantics(companion, fCoerceIn, z, (Function1) objRememberedValue8, function0, RangesKt.rangeTo(((Number) closedFloatingPointRange.getStart()).floatValue(), fCoerceIn2), iFloor);
            Modifier.Companion companion2 = Modifier.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 73844356, "CC(remember):Slider.kt#9igjgp");
            boolean zChanged5 = composer.changed(state2) | composer.changed(fCoerceIn);
            Object objRememberedValue9 = composer.rememberedValue();
            if (zChanged5 || objRememberedValue9 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue9 = new Function1() { // from class: androidx.compose.material.SliderKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj3) {
                        return SliderKt.RangeSlider$lambda$4$8$0(state2, fCoerceIn, ((Float) obj3).floatValue());
                    }
                };
                composer.updateRememberedValue(objRememberedValue9);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            RangeSliderImpl(z, fCalcFraction, fCalcFraction2, list, sliderColors, floatRef.element - floatRef5.element, mutableInteractionSource, mutableInteractionSource2, modifierRangeSliderPressDragModifier, modifierSliderSemantics, sliderSemantics(companion2, fCoerceIn2, z, (Function1) objRememberedValue9, function0, RangesKt.rangeTo(fCoerceIn, ((Number) closedFloatingPointRange.getEndInclusive()).floatValue()), iFloor2), composer, 14155776, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ClosedFloatingPointRange<Float> RangeSlider$lambda$4$scaleToUserValue(Ref.FloatRef floatRef, Ref.FloatRef floatRef2, ClosedFloatingPointRange<Float> closedFloatingPointRange, ClosedFloatingPointRange<Float> closedFloatingPointRange2) {
        return scale(floatRef.element, floatRef2.element, closedFloatingPointRange2, closedFloatingPointRange.getStart().floatValue(), closedFloatingPointRange.getEndInclusive().floatValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float RangeSlider$lambda$4$scaleToOffset(ClosedFloatingPointRange<Float> closedFloatingPointRange, Ref.FloatRef floatRef, Ref.FloatRef floatRef2, float f) {
        return scale(closedFloatingPointRange.getStart().floatValue(), closedFloatingPointRange.getEndInclusive().floatValue(), f, floatRef.element, floatRef2.element);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RangeSlider$lambda$4$5$0(MutableFloatState mutableFloatState, MutableFloatState mutableFloatState2, List list, Ref.FloatRef floatRef, Ref.FloatRef floatRef2, Function0 function0, CoroutineScope coroutineScope, State state, ClosedFloatingPointRange closedFloatingPointRange, boolean z) {
        float floatValue = (z ? mutableFloatState : mutableFloatState2).getFloatValue();
        float fSnapValueToTick = snapValueToTick(floatValue, list, floatRef.element, floatRef2.element);
        if (floatValue != fSnapValueToTick) {
            BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new SliderKt$RangeSlider$2$gestureEndAction$1$1$1(floatValue, fSnapValueToTick, function0, z, mutableFloatState, mutableFloatState2, state, floatRef, floatRef2, closedFloatingPointRange, null), 3, null);
            return Unit.INSTANCE;
        }
        if (function0 != null) {
            function0.invoke();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit RangeSlider$lambda$4$6$0(MutableFloatState mutableFloatState, MutableFloatState mutableFloatState2, ClosedFloatingPointRange closedFloatingPointRange, Ref.FloatRef floatRef, Ref.FloatRef floatRef2, State state, ClosedFloatingPointRange closedFloatingPointRange2, boolean z, float f) {
        ClosedFloatingPointRange<Float> closedFloatingPointRangeRangeTo;
        if (z) {
            mutableFloatState.setFloatValue(mutableFloatState.getFloatValue() + f);
            mutableFloatState2.setFloatValue(RangeSlider$lambda$4$scaleToOffset(closedFloatingPointRange2, floatRef, floatRef2, ((Number) closedFloatingPointRange.getEndInclusive()).floatValue()));
            float floatValue = mutableFloatState2.getFloatValue();
            closedFloatingPointRangeRangeTo = RangesKt.rangeTo(RangesKt.coerceIn(mutableFloatState.getFloatValue(), floatRef.element, floatValue), floatValue);
        } else {
            mutableFloatState2.setFloatValue(mutableFloatState2.getFloatValue() + f);
            mutableFloatState.setFloatValue(RangeSlider$lambda$4$scaleToOffset(closedFloatingPointRange2, floatRef, floatRef2, ((Number) closedFloatingPointRange.getStart()).floatValue()));
            float floatValue2 = mutableFloatState.getFloatValue();
            closedFloatingPointRangeRangeTo = RangesKt.rangeTo(floatValue2, RangesKt.coerceIn(mutableFloatState2.getFloatValue(), floatValue2, floatRef2.element));
        }
        ((Function1) state.getValue()).invoke(RangeSlider$lambda$4$scaleToUserValue(floatRef, floatRef2, closedFloatingPointRange2, closedFloatingPointRangeRangeTo));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RangeSlider$lambda$4$7$0(State state, float f, float f2) {
        ((Function1) state.getValue()).invoke(RangesKt.rangeTo(f2, f));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RangeSlider$lambda$4$8$0(State state, float f, float f2) {
        ((Function1) state.getValue()).invoke(RangesKt.rangeTo(f, f2));
        return Unit.INSTANCE;
    }

    private static final void SliderImpl(final boolean z, final float f, final List<Float> list, final SliderColors sliderColors, final float f2, final MutableInteractionSource mutableInteractionSource, final Modifier modifier, Composer composer, final int i) {
        int i2;
        List<Float> list2;
        Composer composerStartRestartGroup = composer.startRestartGroup(1679682785);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SliderImpl)N(enabled,positionFraction,tickFractions,colors,width,interactionSource,modifier)684@29780L713:Slider.kt#jmzs0o");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(f) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            list2 = list;
            i2 |= composerStartRestartGroup.changedInstance(list2) ? 256 : 128;
        } else {
            list2 = list;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changed(sliderColors) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= composerStartRestartGroup.changed(f2) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(mutableInteractionSource) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(modifier) ? 1048576 : 524288;
        }
        int i3 = i2;
        if (!composerStartRestartGroup.shouldExecute((599187 & i3) != 599186, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1679682785, i3, -1, "androidx.compose.material.SliderImpl (Slider.kt:683)");
            }
            Modifier modifierThen = modifier.then(DefaultSliderConstraints);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierThen);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM6062constructorimpl = Updater.m6062constructorimpl(composerStartRestartGroup);
            Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM6062constructorimpl.getInserting() || !Intrinsics.areEqual(composerM6062constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2014920892, "C688@29940L7,697@30185L217,707@30411L76:Slider.kt#jmzs0o");
            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composerStartRestartGroup.consume(localDensity);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Density density = (Density) objConsume;
            float fMo754toPx0680j_4 = density.mo754toPx0680j_4(TrackHeight);
            float f3 = ThumbRadius;
            float fMo754toPx0680j_5 = density.mo754toPx0680j_4(f3);
            float fMo750toDpu2uoSUM = density.mo750toDpu2uoSUM(f2);
            float fM9687constructorimpl = Dp.m9687constructorimpl(f3 * 2);
            float fM9687constructorimpl2 = Dp.m9687constructorimpl(fMo750toDpu2uoSUM * f);
            int i4 = i3 >> 6;
            int i5 = i3 << 9;
            Track(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), sliderColors, z, 0.0f, f, list2, fMo754toPx0680j_5, fMo754toPx0680j_4, composerStartRestartGroup, (i4 & 112) | 3078 | ((i3 << 6) & 896) | (i5 & 57344) | (i5 & 458752));
            m2549SliderThumbPcYyNuk(boxScopeInstance, Modifier.INSTANCE, fM9687constructorimpl2, mutableInteractionSource, sliderColors, z, fM9687constructorimpl, composerStartRestartGroup, (i4 & 7168) | 1572918 | ((i3 << 3) & 57344) | ((i3 << 15) & 458752));
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.SliderKt$$ExternalSyntheticLambda13
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SliderKt.SliderImpl$lambda$1(z, f, list, sliderColors, f2, mutableInteractionSource, modifier, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final void RangeSliderImpl(final boolean z, final float f, final float f2, final List<Float> list, final SliderColors sliderColors, final float f3, final MutableInteractionSource mutableInteractionSource, final MutableInteractionSource mutableInteractionSource2, final Modifier modifier, final Modifier modifier2, Modifier modifier3, Composer composer, final int i, final int i2) {
        int i3;
        List<Float> list2;
        SliderColors sliderColors2;
        int i4;
        final Modifier modifier4;
        Composer composerStartRestartGroup = composer.startRestartGroup(-278895713);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(RangeSliderImpl)N(enabled,positionFractionStart,positionFractionEnd,tickFractions,colors,width,startInteractionSource,endInteractionSource,modifier,startThumbSemantics,endThumbSemantics)726@30939L35,727@31007L33,728@31045L1529:Slider.kt#jmzs0o");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(f) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changed(f2) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            list2 = list;
            i3 |= composerStartRestartGroup.changedInstance(list2) ? 2048 : 1024;
        } else {
            list2 = list;
        }
        if ((i & 24576) == 0) {
            sliderColors2 = sliderColors;
            i3 |= composerStartRestartGroup.changed(sliderColors2) ? 16384 : 8192;
        } else {
            sliderColors2 = sliderColors;
        }
        if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            i3 |= composerStartRestartGroup.changed(f3) ? 131072 : 65536;
        }
        if ((i & 1572864) == 0) {
            i3 |= composerStartRestartGroup.changed(mutableInteractionSource) ? 1048576 : 524288;
        }
        if ((i & 12582912) == 0) {
            i3 |= composerStartRestartGroup.changed(mutableInteractionSource2) ? 8388608 : 4194304;
        }
        if ((i & 100663296) == 0) {
            i3 |= composerStartRestartGroup.changed(modifier) ? 67108864 : 33554432;
        }
        if ((i & 805306368) == 0) {
            i3 |= composerStartRestartGroup.changed(modifier2) ? C.BUFFER_FLAG_LAST_SAMPLE : 268435456;
        }
        if ((i2 & 6) == 0) {
            i4 = i2 | (composerStartRestartGroup.changed(modifier3) ? 4 : 2);
        } else {
            i4 = i2;
        }
        if (!composerStartRestartGroup.shouldExecute(((i3 & 306783379) == 306783378 && (i4 & 3) == 2) ? false : true, i3 & 1)) {
            modifier4 = modifier3;
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-278895713, i3, i4, "androidx.compose.material.RangeSliderImpl (Slider.kt:724)");
            }
            final String strM2581getString4foXLRw = Strings_androidKt.m2581getString4foXLRw(Strings.INSTANCE.m2579getSliderRangeStartUdPEhr4(), composerStartRestartGroup, 6);
            final String strM2581getString4foXLRw2 = Strings_androidKt.m2581getString4foXLRw(Strings.INSTANCE.m2578getSliderRangeEndUdPEhr4(), composerStartRestartGroup, 6);
            Modifier modifierThen = modifier.then(DefaultSliderConstraints);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierThen);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM6062constructorimpl = Updater.m6062constructorimpl(composerStartRestartGroup);
            Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM6062constructorimpl.getInserting() || !Intrinsics.areEqual(composerM6062constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2114792334, "C732@31205L7,741@31513L268,753@31860L84,752@31791L389,765@32258L82,764@32189L379:Slider.kt#jmzs0o");
            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composerStartRestartGroup.consume(localDensity);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Density density = (Density) objConsume;
            float fMo754toPx0680j_4 = density.mo754toPx0680j_4(TrackHeight);
            float f4 = ThumbRadius;
            float fMo754toPx0680j_5 = density.mo754toPx0680j_4(f4);
            float fMo750toDpu2uoSUM = density.mo750toDpu2uoSUM(f3);
            float fM9687constructorimpl = Dp.m9687constructorimpl(f4 * 2);
            float fM9687constructorimpl2 = Dp.m9687constructorimpl(fMo750toDpu2uoSUM * f);
            float fM9687constructorimpl3 = Dp.m9687constructorimpl(fMo750toDpu2uoSUM * f2);
            Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(boxScopeInstance.align(Modifier.INSTANCE, Alignment.INSTANCE.getCenterStart()), 0.0f, 1, null);
            int i5 = i3 >> 9;
            int i6 = i3 << 6;
            int i7 = i3;
            Track(modifierFillMaxSize$default, sliderColors2, z, f, f2, list2, fMo754toPx0680j_5, fMo754toPx0680j_4, composerStartRestartGroup, (i6 & 458752) | (i6 & 896) | (i5 & 112) | (i6 & 7168) | (i6 & 57344));
            composerStartRestartGroup = composerStartRestartGroup;
            Modifier.Companion companion = Modifier.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1730810029, "CC(remember):Slider.kt#9igjgp");
            boolean zChanged = composerStartRestartGroup.changed(strM2581getString4foXLRw);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: androidx.compose.material.SliderKt$$ExternalSyntheticLambda18
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return SliderKt.RangeSliderImpl$lambda$0$1$0(strM2581getString4foXLRw, (SemanticsPropertyReceiver) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            int i8 = i7 & 57344;
            int i9 = (i7 << 15) & 458752;
            m2549SliderThumbPcYyNuk(boxScopeInstance, FocusableKt.focusable(SemanticsModifierKt.semantics(companion, true, (Function1) objRememberedValue), true, mutableInteractionSource).then(modifier2), fM9687constructorimpl2, mutableInteractionSource, sliderColors, z, fM9687constructorimpl, composerStartRestartGroup, (i5 & 7168) | 1572870 | i8 | i9);
            Modifier.Companion companion2 = Modifier.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1730822763, "CC(remember):Slider.kt#9igjgp");
            boolean zChanged2 = composerStartRestartGroup.changed(strM2581getString4foXLRw2);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function1() { // from class: androidx.compose.material.SliderKt$$ExternalSyntheticLambda19
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return SliderKt.RangeSliderImpl$lambda$0$2$0(strM2581getString4foXLRw2, (SemanticsPropertyReceiver) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            modifier4 = modifier3;
            m2549SliderThumbPcYyNuk(boxScopeInstance, FocusableKt.focusable(SemanticsModifierKt.semantics(companion2, true, (Function1) objRememberedValue2), true, mutableInteractionSource2).then(modifier4), fM9687constructorimpl3, mutableInteractionSource2, sliderColors, z, fM9687constructorimpl, composerStartRestartGroup, ((i7 >> 12) & 7168) | 1572870 | i8 | i9);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.SliderKt$$ExternalSyntheticLambda20
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SliderKt.RangeSliderImpl$lambda$1(z, f, f2, list, sliderColors, f3, mutableInteractionSource, mutableInteractionSource2, modifier, modifier2, modifier4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RangeSliderImpl$lambda$0$1$0(String str, SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.setContentDescription(semanticsPropertyReceiver, str);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RangeSliderImpl$lambda$0$2$0(String str, SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.setContentDescription(semanticsPropertyReceiver, str);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: SliderThumb-PcYyNuk, reason: not valid java name */
    private static final void m2549SliderThumbPcYyNuk(final BoxScope boxScope, final Modifier modifier, final float f, final MutableInteractionSource mutableInteractionSource, final SliderColors sliderColors, final boolean z, final float f2, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(428907178);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SliderThumb)N(modifier,offset:c#ui.unit.Dp,interactionSource,colors,enabled,thumbSize:c#ui.unit.Dp)788@32788L1539:Slider.kt#jmzs0o");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(boxScope) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(modifier) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changed(f) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changed(mutableInteractionSource) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= composerStartRestartGroup.changed(sliderColors) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(z) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(f2) ? 1048576 : 524288;
        }
        if (composerStartRestartGroup.shouldExecute((599187 & i2) != 599186, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(428907178, i2, -1, "androidx.compose.material.SliderThumb (Slider.kt:787)");
            }
            Modifier modifierAlign = boxScope.align(PaddingKt.m1222paddingqDBjuR0$default(Modifier.INSTANCE, f, 0.0f, 0.0f, 0.0f, 14, null), Alignment.INSTANCE.getCenterStart());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierAlign);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM6062constructorimpl = Updater.m6062constructorimpl(composerStartRestartGroup);
            Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM6062constructorimpl.getInserting() || !Intrinsics.areEqual(composerM6062constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -264746013, "C789@32884L46,790@32973L658,790@32939L692,818@34272L19,809@33821L500:Slider.kt#jmzs0o");
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2086750978, "CC(remember):Slider.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = SnapshotStateKt.mutableStateListOf();
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            SnapshotStateList snapshotStateList = (SnapshotStateList) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2086747518, "CC(remember):Slider.kt#9igjgp");
            boolean z2 = (i2 & 7168) == 2048;
            SliderKt$SliderThumb$1$1$1 sliderKt$SliderThumb$1$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (z2 || sliderKt$SliderThumb$1$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                sliderKt$SliderThumb$1$1$1RememberedValue = new SliderKt$SliderThumb$1$1$1(mutableInteractionSource, snapshotStateList, null);
                composerStartRestartGroup.updateRememberedValue(sliderKt$SliderThumb$1$1$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            int i3 = i2 >> 9;
            EffectsKt.LaunchedEffect(mutableInteractionSource, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) sliderKt$SliderThumb$1$1$1RememberedValue, composerStartRestartGroup, i3 & 14);
            float fM9687constructorimpl = !snapshotStateList.isEmpty() ? ThumbPressedElevation : ThumbDefaultElevation;
            Modifier modifierHoverable$default = HoverableKt.hoverable$default(IndicationKt.indication(SizeKt.m1268sizeVpY3zN4(modifier, f2, f2), mutableInteractionSource, RippleKt.m2523rippleH2RKhps$default(false, ThumbRippleRadius, 0L, 4, null)), mutableInteractionSource, false, 2, null);
            if (!z) {
                fM9687constructorimpl = Dp.m9687constructorimpl(0);
            }
            SpacerKt.Spacer(BackgroundKt.m588backgroundbw27NRU(ShadowKt.m6412shadows4CzXII$default(modifierHoverable$default, fM9687constructorimpl, RoundedCornerShapeKt.getCircleShape(), false, 0L, 0L, 24, null), sliderColors.thumbColor(z, composerStartRestartGroup, ((i2 >> 15) & 14) | (i3 & 112)).getValue().m6824unboximpl(), RoundedCornerShapeKt.getCircleShape()), composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.SliderKt$$ExternalSyntheticLambda17
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SliderKt.SliderThumb_PcYyNuk$lambda$1(boxScope, modifier, f, mutableInteractionSource, sliderColors, z, f2, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final void Track(final Modifier modifier, final SliderColors sliderColors, final boolean z, final float f, final float f2, final List<Float> list, final float f3, final float f4, Composer composer, final int i) {
        int i2;
        float f5;
        float f6;
        Composer composerStartRestartGroup = composer.startRestartGroup(1833126050);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Track)N(modifier,colors,enabled,positionFractionStart,positionFractionEnd,tickFractions,thumbPx,trackStrokeWidth)834@34621L35,835@34691L34,836@34761L34,837@34829L33,838@34884L1463,838@34867L1480:Slider.kt#jmzs0o");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(sliderColors) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changed(z) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changed(f) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            f5 = f2;
            i2 |= composerStartRestartGroup.changed(f5) ? 16384 : 8192;
        } else {
            f5 = f2;
        }
        if ((196608 & i) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(list) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            f6 = f3;
            i2 |= composerStartRestartGroup.changed(f6) ? 1048576 : 524288;
        } else {
            f6 = f3;
        }
        if ((12582912 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(f4) ? 8388608 : 4194304;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 4793491) != 4793490, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1833126050, i2, -1, "androidx.compose.material.Track (Slider.kt:833)");
            }
            int i3 = ((i2 >> 6) & 14) | 48 | ((i2 << 3) & 896);
            final State<Color> stateTrackColor = sliderColors.trackColor(z, false, composerStartRestartGroup, i3);
            final State<Color> stateTrackColor2 = sliderColors.trackColor(z, true, composerStartRestartGroup, i3);
            final State<Color> stateTickColor = sliderColors.tickColor(z, false, composerStartRestartGroup, i3);
            final State<Color> stateTickColor2 = sliderColors.tickColor(z, true, composerStartRestartGroup, i3);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 697561209, "CC(remember):Slider.kt#9igjgp");
            boolean zChanged = ((29360128 & i2) == 8388608) | ((3670016 & i2) == 1048576) | composerStartRestartGroup.changed(stateTrackColor) | ((57344 & i2) == 16384) | ((i2 & 7168) == 2048) | composerStartRestartGroup.changed(stateTrackColor2) | composerStartRestartGroup.changedInstance(list) | composerStartRestartGroup.changed(stateTickColor) | composerStartRestartGroup.changed(stateTickColor2);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                final float f7 = f6;
                final float f8 = f5;
                Object obj = new Function1() { // from class: androidx.compose.material.SliderKt$$ExternalSyntheticLambda21
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return SliderKt.Track$lambda$0$0(f7, stateTrackColor, f4, f8, f, stateTrackColor2, list, stateTickColor, stateTickColor2, (DrawScope) obj2);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(obj);
                objRememberedValue = obj;
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            CanvasKt.Canvas(modifier, (Function1) objRememberedValue, composerStartRestartGroup, i2 & 14);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.SliderKt$$ExternalSyntheticLambda22
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    return SliderKt.Track$lambda$1(modifier, sliderColors, z, f, f2, list, f3, f4, i, (Composer) obj2, ((Integer) obj3).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Track$lambda$0$0(float f, State state, float f2, float f3, float f4, State state2, List list, State state3, State state4, DrawScope drawScope) {
        boolean z = drawScope.getLayoutDirection() == LayoutDirection.Rtl;
        long j = 4294967295L;
        long jM6561constructorimpl = Offset.m6561constructorimpl((((long) Float.floatToRawIntBits(f)) << 32) | (((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (drawScope.mo7394getCenterF1C5BW0() & 4294967295L)))) & 4294967295L));
        float fIntBitsToFloat = Float.intBitsToFloat((int) (drawScope.mo7395getSizeNHjbRc() >> 32)) - f;
        long jM6561constructorimpl2 = Offset.m6561constructorimpl((((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (drawScope.mo7394getCenterF1C5BW0() & 4294967295L)))) & 4294967295L) | (((long) Float.floatToRawIntBits(fIntBitsToFloat)) << 32));
        long j2 = z ? jM6561constructorimpl2 : jM6561constructorimpl;
        long j3 = z ? jM6561constructorimpl : jM6561constructorimpl2;
        DrawScope.m7381drawLineNGM6Ib0$default(drawScope, ((Color) state.getValue()).m6824unboximpl(), j2, j3, f2, StrokeCap.INSTANCE.m7191getRoundKaPHkGw(), null, 0.0f, null, 0, WindowSizeClass.HEIGHT_DP_MEDIUM_LOWER_BOUND, null);
        long j4 = j3;
        int i = (int) (j2 >> 32);
        int i2 = (int) (j4 >> 32);
        float fIntBitsToFloat2 = Float.intBitsToFloat(i) + ((Float.intBitsToFloat(i2) - Float.intBitsToFloat(i)) * f3);
        DrawScope.m7381drawLineNGM6Ib0$default(drawScope, ((Color) state2.getValue()).m6824unboximpl(), Offset.m6561constructorimpl((((long) Float.floatToRawIntBits(Float.intBitsToFloat(i) + ((Float.intBitsToFloat(i2) - Float.intBitsToFloat(i)) * f4))) << 32) | (((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (drawScope.mo7394getCenterF1C5BW0() & 4294967295L)))) & 4294967295L)), Offset.m6561constructorimpl((((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (drawScope.mo7394getCenterF1C5BW0() & 4294967295L)))) & 4294967295L) | (((long) Float.floatToRawIntBits(fIntBitsToFloat2)) << 32)), f2, StrokeCap.INSTANCE.m7191getRoundKaPHkGw(), null, 0.0f, null, 0, WindowSizeClass.HEIGHT_DP_MEDIUM_LOWER_BOUND, null);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : list) {
            float fFloatValue = ((Number) obj).floatValue();
            Boolean boolValueOf = Boolean.valueOf(fFloatValue > f3 || fFloatValue < f4);
            Object obj2 = linkedHashMap.get(boolValueOf);
            if (obj2 == null) {
                obj2 = (List) new ArrayList();
                linkedHashMap.put(boolValueOf, obj2);
            }
            ((List) obj2).add(obj);
        }
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            boolean zBooleanValue = ((Boolean) entry.getKey()).booleanValue();
            List list2 = (List) entry.getValue();
            ArrayList arrayList = new ArrayList(list2.size());
            int size = list2.size();
            int i3 = 0;
            while (i3 < size) {
                ArrayList arrayList2 = arrayList;
                float fIntBitsToFloat3 = Float.intBitsToFloat((int) (OffsetKt.m6592lerpWko1d7g(j2, j4, ((Number) list2.get(i3)).floatValue()) >> 32));
                long j5 = j;
                arrayList.add(Offset.m6558boximpl(Offset.m6561constructorimpl((((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (drawScope.mo7394getCenterF1C5BW0() & j5)))) & j5) | (((long) Float.floatToRawIntBits(fIntBitsToFloat3)) << 32))));
                i3++;
                arrayList = arrayList2;
                j = j5;
            }
            long j6 = j;
            DrawScope.m7386drawPointsF8ZwMP8$default(drawScope, arrayList, PointMode.INSTANCE.m7136getPointsr_lszbg(), ((Color) (zBooleanValue ? state3 : state4).getValue()).m6824unboximpl(), f2, StrokeCap.INSTANCE.m7191getRoundKaPHkGw(), null, 0.0f, null, 0, WindowSizeClass.HEIGHT_DP_MEDIUM_LOWER_BOUND, null);
            j = j6;
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX INFO: renamed from: awaitSlop-8vUncbI, reason: not valid java name */
    public static final Object m2551awaitSlop8vUncbI(AwaitPointerEventScope awaitPointerEventScope, long j, int i, Continuation<? super Pair<PointerInputChange, Float>> continuation) {
        SliderKt$awaitSlop$1 sliderKt$awaitSlop$1;
        Ref.FloatRef floatRef;
        if (continuation instanceof SliderKt$awaitSlop$1) {
            sliderKt$awaitSlop$1 = (SliderKt$awaitSlop$1) continuation;
            if ((sliderKt$awaitSlop$1.label & Integer.MIN_VALUE) != 0) {
                sliderKt$awaitSlop$1.label -= Integer.MIN_VALUE;
            } else {
                sliderKt$awaitSlop$1 = new SliderKt$awaitSlop$1(continuation);
            }
        } else {
            sliderKt$awaitSlop$1 = new SliderKt$awaitSlop$1(continuation);
        }
        SliderKt$awaitSlop$1 sliderKt$awaitSlop$2 = sliderKt$awaitSlop$1;
        Object obj = sliderKt$awaitSlop$2.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = sliderKt$awaitSlop$2.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            final Ref.FloatRef floatRef2 = new Ref.FloatRef();
            Function2 function2 = new Function2() { // from class: androidx.compose.material.SliderKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    return SliderKt.awaitSlop_8vUncbI$lambda$0(floatRef2, (PointerInputChange) obj2, ((Float) obj3).floatValue());
                }
            };
            sliderKt$awaitSlop$2.L$0 = floatRef2;
            sliderKt$awaitSlop$2.label = 1;
            Object objM2382awaitHorizontalPointerSlopOrCancellationgDDlDlE = DragGestureDetectorCopyKt.m2382awaitHorizontalPointerSlopOrCancellationgDDlDlE(awaitPointerEventScope, j, i, function2, sliderKt$awaitSlop$2);
            if (objM2382awaitHorizontalPointerSlopOrCancellationgDDlDlE == coroutine_suspended) {
                return coroutine_suspended;
            }
            obj = objM2382awaitHorizontalPointerSlopOrCancellationgDDlDlE;
            floatRef = floatRef2;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            floatRef = (Ref.FloatRef) sliderKt$awaitSlop$2.L$0;
            ResultKt.throwOnFailure(obj);
        }
        PointerInputChange pointerInputChange = (PointerInputChange) obj;
        if (pointerInputChange != null) {
            return TuplesKt.to(pointerInputChange, Boxing.boxFloat(floatRef.element));
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit awaitSlop_8vUncbI$lambda$0(Ref.FloatRef floatRef, PointerInputChange pointerInputChange, float f) {
        pointerInputChange.consume();
        floatRef.element = f;
        return Unit.INSTANCE;
    }

    private static final List<Float> stepsToTickFractions(int i) {
        if (i == 0) {
            return CollectionsKt.emptyList();
        }
        int i2 = i + 2;
        ArrayList arrayList = new ArrayList(i2);
        for (int i3 = 0; i3 < i2; i3++) {
            arrayList.add(Float.valueOf(i3 / (i + 1)));
        }
        return arrayList;
    }

    private static final float scale(float f, float f2, float f3, float f4, float f5) {
        return MathHelpersKt.lerp(f4, f5, calcFraction(f, f2, f3));
    }

    private static final ClosedFloatingPointRange<Float> scale(float f, float f2, ClosedFloatingPointRange<Float> closedFloatingPointRange, float f3, float f4) {
        return RangesKt.rangeTo(scale(f, f2, closedFloatingPointRange.getStart().floatValue(), f3, f4), scale(f, f2, closedFloatingPointRange.getEndInclusive().floatValue(), f3, f4));
    }

    private static final void CorrectValueSideEffect(final Function1<? super Float, Float> function1, final ClosedFloatingPointRange<Float> closedFloatingPointRange, final ClosedFloatingPointRange<Float> closedFloatingPointRange2, final MutableState<Float> mutableState, final float f, Composer composer, final int i) {
        int i2;
        float f2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-743965752);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(CorrectValueSideEffect)N(scaleToOffset,valueRange,trackRange,valueState,value)928@38204L300,928@38193L311:Slider.kt#jmzs0o");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(function1) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(closedFloatingPointRange) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changed(closedFloatingPointRange2) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changed(mutableState) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            f2 = f;
            i2 |= composerStartRestartGroup.changed(f2) ? 16384 : 8192;
        } else {
            f2 = f;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 9363) != 9362, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-743965752, i2, -1, "androidx.compose.material.CorrectValueSideEffect (Slider.kt:927)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1986508652, "CC(remember):Slider.kt#9igjgp");
            boolean z = ((i2 & 112) == 32) | ((i2 & 14) == 4) | ((57344 & i2) == 16384) | ((i2 & 7168) == 2048) | ((i2 & 896) == 256);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                final float f3 = f2;
                Function0 function0 = new Function0() { // from class: androidx.compose.material.SliderKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return SliderKt.CorrectValueSideEffect$lambda$0$0(closedFloatingPointRange, function1, f3, mutableState, closedFloatingPointRange2);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(function0);
                objRememberedValue = function0;
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.SideEffect((Function0) objRememberedValue, composerStartRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.SliderKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SliderKt.CorrectValueSideEffect$lambda$1(function1, closedFloatingPointRange, closedFloatingPointRange2, mutableState, f, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit CorrectValueSideEffect$lambda$0$0(ClosedFloatingPointRange closedFloatingPointRange, Function1 function1, float f, MutableState mutableState, ClosedFloatingPointRange closedFloatingPointRange2) {
        float fFloatValue = (((Number) closedFloatingPointRange.getEndInclusive()).floatValue() - ((Number) closedFloatingPointRange.getStart()).floatValue()) / 1000;
        float fFloatValue2 = ((Number) function1.invoke(Float.valueOf(f))).floatValue();
        if (Math.abs(fFloatValue2 - ((Number) mutableState.getValue()).floatValue()) > fFloatValue && closedFloatingPointRange2.contains((Comparable) mutableState.getValue())) {
            mutableState.setValue(Float.valueOf(fFloatValue2));
        }
        return Unit.INSTANCE;
    }

    static /* synthetic */ Modifier sliderSemantics$default(Modifier modifier, float f, boolean z, Function1 function1, Function0 function0, ClosedFloatingPointRange closedFloatingPointRange, int i, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            function0 = null;
        }
        Function0 function2 = function0;
        if ((i2 & 16) != 0) {
            closedFloatingPointRange = RangesKt.rangeTo(0.0f, 1.0f);
        }
        ClosedFloatingPointRange closedFloatingPointRange2 = closedFloatingPointRange;
        if ((i2 & 32) != 0) {
            i = 0;
        }
        return sliderSemantics(modifier, f, z, function1, function2, closedFloatingPointRange2, i);
    }

    private static final Modifier sliderSemantics(Modifier modifier, float f, final boolean z, final Function1<? super Float, Unit> function1, final Function0<Unit> function0, final ClosedFloatingPointRange<Float> closedFloatingPointRange, final int i) {
        final float fCoerceIn = RangesKt.coerceIn(f, closedFloatingPointRange.getStart().floatValue(), closedFloatingPointRange.getEndInclusive().floatValue());
        return ProgressSemanticsKt.progressSemantics(SemanticsModifierKt.semantics$default(modifier, false, new Function1() { // from class: androidx.compose.material.SliderKt$$ExternalSyntheticLambda14
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return SliderKt.sliderSemantics$lambda$0(z, closedFloatingPointRange, i, fCoerceIn, function1, function0, (SemanticsPropertyReceiver) obj);
            }
        }, 1, null), f, closedFloatingPointRange, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit sliderSemantics$lambda$0(boolean z, final ClosedFloatingPointRange closedFloatingPointRange, final int i, final float f, final Function1 function1, final Function0 function0, SemanticsPropertyReceiver semanticsPropertyReceiver) {
        if (!z) {
            SemanticsPropertiesKt.disabled(semanticsPropertyReceiver);
        }
        SemanticsPropertiesKt.setProgress$default(semanticsPropertyReceiver, null, new Function1() { // from class: androidx.compose.material.SliderKt$$ExternalSyntheticLambda8
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(SliderKt.sliderSemantics$lambda$0$0(closedFloatingPointRange, i, f, function1, function0, ((Float) obj).floatValue()));
            }
        }, 1, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final boolean sliderSemantics$lambda$0$0(ClosedFloatingPointRange closedFloatingPointRange, int i, float f, Function1 function1, Function0 function0, float f2) {
        int i2;
        float fCoerceIn = RangesKt.coerceIn(f2, ((Number) closedFloatingPointRange.getStart()).floatValue(), ((Number) closedFloatingPointRange.getEndInclusive()).floatValue());
        if (i > 0 && (i2 = i + 1) >= 0) {
            float fAbs = fCoerceIn;
            float f3 = fAbs;
            int i3 = 0;
            while (true) {
                float fLerp = MathHelpersKt.lerp(((Number) closedFloatingPointRange.getStart()).floatValue(), ((Number) closedFloatingPointRange.getEndInclusive()).floatValue(), i3 / i2);
                float f4 = fLerp - fCoerceIn;
                if (Math.abs(f4) <= fAbs) {
                    fAbs = Math.abs(f4);
                    f3 = fLerp;
                }
                if (i3 == i2) {
                    break;
                }
                i3++;
            }
            fCoerceIn = f3;
        }
        if (fCoerceIn == f) {
            return false;
        }
        function1.invoke(Float.valueOf(fCoerceIn));
        if (function0 != null) {
            function0.invoke();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Modifier sliderTapModifier$lambda$1(boolean z, DraggableState draggableState, MutableInteractionSource mutableInteractionSource, float f, boolean z2, MutableState mutableState, State state, State state2, Modifier modifier, Composer composer, int i) {
        Modifier modifierPointerInput;
        composer.startReplaceGroup(1945228890);
        ComposerKt.sourceInformation(composer, "C:Slider.kt#jmzs0o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1945228890, i, -1, "androidx.compose.material.sliderTapModifier.<anonymous> (Slider.kt:1000)");
        }
        if (z) {
            composer.startReplaceGroup(-1679801122);
            ComposerKt.sourceInformation(composer, "1001@40932L24,1002@41035L983");
            ComposerKt.sourceInformationMarkerStart(composer, 773894976, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart(composer, 683736516, "CC(remember):Effects.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composer);
                composer.updateRememberedValue(objRememberedValue);
            }
            CoroutineScope coroutineScope = (CoroutineScope) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            Object[] objArr = {draggableState, mutableInteractionSource, Float.valueOf(f), Boolean.valueOf(z2)};
            ComposerKt.sourceInformationMarkerStart(composer, 1054195633, "CC(remember):Slider.kt#9igjgp");
            boolean zChanged = composer.changed(z2) | composer.changed(f) | composer.changed(mutableState) | composer.changed(state) | composer.changedInstance(coroutineScope) | composer.changedInstance(draggableState) | composer.changed(state2);
            Object objRememberedValue2 = composer.rememberedValue();
            if (zChanged || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = (PointerInputEventHandler) new SliderKt$sliderTapModifier$2$1$1(z2, f, mutableState, state, coroutineScope, draggableState, state2);
                composer.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            modifierPointerInput = SuspendingPointerInputFilterKt.pointerInput(modifier, objArr, (PointerInputEventHandler) objRememberedValue2);
            composer.endReplaceGroup();
        } else {
            composer.startReplaceGroup(-1678708124);
            composer.endReplaceGroup();
            modifierPointerInput = modifier;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return modifierPointerInput;
    }

    /* JADX INFO: renamed from: androidx.compose.material.SliderKt$animateToTarget$2, reason: invalid class name */
    /* JADX INFO: compiled from: Slider.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/DragScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.material.SliderKt$animateToTarget$2", f = "Slider.kt", i = {}, l = {1051}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function2<DragScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ float $current;
        final /* synthetic */ float $target;
        final /* synthetic */ float $velocity;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(float f, float f2, float f3, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$current = f;
            this.$target = f2;
            this.$velocity = f3;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$current, this.$target, this.$velocity, continuation);
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
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                final DragScope dragScope = (DragScope) this.L$0;
                final Ref.FloatRef floatRef = new Ref.FloatRef();
                floatRef.element = this.$current;
                this.label = 1;
                if (AnimatableKt.Animatable$default(this.$current, 0.0f, 2, null).animateTo(Boxing.boxFloat(this.$target), SliderKt.SliderToTickAnimation, Boxing.boxFloat(this.$velocity), new Function1() { // from class: androidx.compose.material.SliderKt$animateToTarget$2$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return SliderKt.AnonymousClass2.invokeSuspend$lambda$0(dragScope, floatRef, (Animatable) obj2);
                    }
                }, this) == coroutine_suspended) {
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

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invokeSuspend$lambda$0(DragScope dragScope, Ref.FloatRef floatRef, Animatable animatable) {
            dragScope.dragBy(((Number) animatable.getValue()).floatValue() - floatRef.element);
            floatRef.element = ((Number) animatable.getValue()).floatValue();
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object animateToTarget(DraggableState draggableState, float f, float f2, float f3, Continuation<? super Unit> continuation) {
        Object objDrag$default = DraggableState.drag$default(draggableState, null, new AnonymousClass2(f, f2, f3, null), continuation, 1, null);
        return objDrag$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objDrag$default : Unit.INSTANCE;
    }

    private static final Modifier rangeSliderPressDragModifier(Modifier modifier, final MutableInteractionSource mutableInteractionSource, final MutableInteractionSource mutableInteractionSource2, final State<Float> state, final State<Float> state2, boolean z, final boolean z2, final float f, ClosedFloatingPointRange<Float> closedFloatingPointRange, final State<? extends Function1<? super Boolean, Unit>> state3, final State<? extends Function2<? super Boolean, ? super Float, Unit>> state4) {
        return z ? SuspendingPointerInputFilterKt.pointerInput(modifier, new Object[]{mutableInteractionSource, mutableInteractionSource2, Float.valueOf(f), Boolean.valueOf(z2), closedFloatingPointRange}, new PointerInputEventHandler() { // from class: androidx.compose.material.SliderKt.rangeSliderPressDragModifier.1
            @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
            public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
                Object objCoroutineScope = CoroutineScopeKt.coroutineScope(new C00501(pointerInputScope, z2, f, new RangeSliderLogic(mutableInteractionSource, mutableInteractionSource2, state, state2, state4), state, state3, state2, state4, null), continuation);
                return objCoroutineScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCoroutineScope : Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: androidx.compose.material.SliderKt$rangeSliderPressDragModifier$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: Slider.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
            @DebugMetadata(c = "androidx.compose.material.SliderKt$rangeSliderPressDragModifier$1$1", f = "Slider.kt", i = {}, l = {1081}, m = "invokeSuspend", n = {}, s = {}, v = 1)
            static final class C00501 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ State<Function1<Boolean, Unit>> $gestureEndAction;
                final /* synthetic */ boolean $isRtl;
                final /* synthetic */ float $maxPx;
                final /* synthetic */ State<Function2<Boolean, Float, Unit>> $onDrag;
                final /* synthetic */ RangeSliderLogic $rangeSliderLogic;
                final /* synthetic */ State<Float> $rawOffsetEnd;
                final /* synthetic */ State<Float> $rawOffsetStart;
                final /* synthetic */ PointerInputScope $this_pointerInput;
                private /* synthetic */ Object L$0;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                C00501(PointerInputScope pointerInputScope, boolean z, float f, RangeSliderLogic rangeSliderLogic, State<Float> state, State<? extends Function1<? super Boolean, Unit>> state2, State<Float> state3, State<? extends Function2<? super Boolean, ? super Float, Unit>> state4, Continuation<? super C00501> continuation) {
                    super(2, continuation);
                    this.$this_pointerInput = pointerInputScope;
                    this.$isRtl = z;
                    this.$maxPx = f;
                    this.$rangeSliderLogic = rangeSliderLogic;
                    this.$rawOffsetStart = state;
                    this.$gestureEndAction = state2;
                    this.$rawOffsetEnd = state3;
                    this.$onDrag = state4;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    C00501 c00501 = new C00501(this.$this_pointerInput, this.$isRtl, this.$maxPx, this.$rangeSliderLogic, this.$rawOffsetStart, this.$gestureEndAction, this.$rawOffsetEnd, this.$onDrag, continuation);
                    c00501.L$0 = obj;
                    return c00501;
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((C00501) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                /* JADX INFO: renamed from: androidx.compose.material.SliderKt$rangeSliderPressDragModifier$1$1$1, reason: invalid class name and collision with other inner class name */
                /* JADX INFO: compiled from: Slider.kt */
                @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
                @DebugMetadata(c = "androidx.compose.material.SliderKt$rangeSliderPressDragModifier$1$1$1", f = "Slider.kt", i = {0, 1, 1, 1, 1, 1, 2, 2}, l = {1082, 1093, 1115}, m = "invokeSuspend", n = {"$this$awaitEachGesture", "$this$awaitEachGesture", "event", "interaction", "posX", "draggingStart", "interaction", "draggingStart"}, s = {"L$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1"}, v = 1)
                static final class C00511 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
                    final /* synthetic */ CoroutineScope $$this$coroutineScope;
                    final /* synthetic */ State<Function1<Boolean, Unit>> $gestureEndAction;
                    final /* synthetic */ boolean $isRtl;
                    final /* synthetic */ float $maxPx;
                    final /* synthetic */ State<Function2<Boolean, Float, Unit>> $onDrag;
                    final /* synthetic */ RangeSliderLogic $rangeSliderLogic;
                    final /* synthetic */ State<Float> $rawOffsetEnd;
                    final /* synthetic */ State<Float> $rawOffsetStart;
                    private /* synthetic */ Object L$0;
                    Object L$1;
                    Object L$2;
                    Object L$3;
                    Object L$4;
                    int label;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    C00511(boolean z, float f, RangeSliderLogic rangeSliderLogic, State<Float> state, CoroutineScope coroutineScope, State<? extends Function1<? super Boolean, Unit>> state2, State<Float> state3, State<? extends Function2<? super Boolean, ? super Float, Unit>> state4, Continuation<? super C00511> continuation) {
                        super(2, continuation);
                        this.$isRtl = z;
                        this.$maxPx = f;
                        this.$rangeSliderLogic = rangeSliderLogic;
                        this.$rawOffsetStart = state;
                        this.$$this$coroutineScope = coroutineScope;
                        this.$gestureEndAction = state2;
                        this.$rawOffsetEnd = state3;
                        this.$onDrag = state4;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        C00511 c00511 = new C00511(this.$isRtl, this.$maxPx, this.$rangeSliderLogic, this.$rawOffsetStart, this.$$this$coroutineScope, this.$gestureEndAction, this.$rawOffsetEnd, this.$onDrag, continuation);
                        c00511.L$0 = obj;
                        return c00511;
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
                        return ((C00511) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    /* JADX WARN: Code duplicated, block: B:36:0x00ee  */
                    /* JADX WARN: Code duplicated, block: B:54:0x018c  */
                    /* JADX WARN: Code duplicated, block: B:57:0x0196 A[Catch: CancellationException -> 0x01a8, TryCatch #0 {CancellationException -> 0x01a8, blocks: (B:8:0x001e, B:55:0x018e, B:57:0x0196, B:58:0x019e), top: B:65:0x001e }] */
                    /* JADX WARN: Code duplicated, block: B:58:0x019e A[Catch: CancellationException -> 0x01a8, TRY_LEAVE, TryCatch #0 {CancellationException -> 0x01a8, blocks: (B:8:0x001e, B:55:0x018e, B:57:0x0196, B:58:0x019e), top: B:65:0x001e }] */
                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        Object objAwaitFirstDown$default;
                        AwaitPointerEventScope awaitPointerEventScope;
                        PointerInputChange pointerInputChange;
                        Object objM2551awaitSlop8vUncbI;
                        Ref.FloatRef floatRef;
                        DragInteraction.Start start;
                        final Ref.BooleanRef booleanRef;
                        Pair pair;
                        Ref.BooleanRef booleanRef2;
                        DragInteraction.Start start2;
                        Object objM838horizontalDragjO51t88;
                        State<Float> state;
                        boolean z;
                        float fM2385pointerSlopE8SPZFQ;
                        DragInteraction.Cancel cancel;
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        int i = this.label;
                        if (i == 0) {
                            ResultKt.throwOnFailure(obj);
                            AwaitPointerEventScope awaitPointerEventScope2 = (AwaitPointerEventScope) this.L$0;
                            this.L$0 = awaitPointerEventScope2;
                            this.label = 1;
                            objAwaitFirstDown$default = TapGestureDetectorKt.awaitFirstDown$default(awaitPointerEventScope2, false, null, this, 2, null);
                            if (objAwaitFirstDown$default != coroutine_suspended) {
                                awaitPointerEventScope = awaitPointerEventScope2;
                            }
                            return coroutine_suspended;
                        }
                        if (i == 1) {
                            AwaitPointerEventScope awaitPointerEventScope3 = (AwaitPointerEventScope) this.L$0;
                            ResultKt.throwOnFailure(obj);
                            awaitPointerEventScope = awaitPointerEventScope3;
                            objAwaitFirstDown$default = obj;
                        } else {
                            if (i != 2) {
                                if (i != 3) {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                booleanRef2 = (Ref.BooleanRef) this.L$1;
                                start2 = (DragInteraction.Start) this.L$0;
                                try {
                                    ResultKt.throwOnFailure(obj);
                                    objM838horizontalDragjO51t88 = obj;
                                    if (((Boolean) objM838horizontalDragjO51t88).booleanValue()) {
                                        cancel = new DragInteraction.Stop(start2);
                                    } else {
                                        cancel = new DragInteraction.Cancel(start2);
                                    }
                                } catch (CancellationException unused) {
                                    cancel = new DragInteraction.Cancel(start2);
                                }
                                this.$gestureEndAction.getValue().invoke(Boxing.boxBoolean(booleanRef2.element));
                                BuildersKt__Builders_commonKt.launch$default(this.$$this$coroutineScope, null, null, new AnonymousClass2(this.$rangeSliderLogic, booleanRef2, cancel, null), 3, null);
                                return Unit.INSTANCE;
                            }
                            booleanRef = (Ref.BooleanRef) this.L$4;
                            Ref.FloatRef floatRef2 = (Ref.FloatRef) this.L$3;
                            start = (DragInteraction.Start) this.L$2;
                            pointerInputChange = (PointerInputChange) this.L$1;
                            awaitPointerEventScope = (AwaitPointerEventScope) this.L$0;
                            ResultKt.throwOnFailure(obj);
                            floatRef = floatRef2;
                            objM2551awaitSlop8vUncbI = obj;
                            pair = (Pair) objM2551awaitSlop8vUncbI;
                            if (pair != null) {
                                state = this.$rawOffsetEnd;
                                State<Float> state2 = this.$rawOffsetStart;
                                z = this.$isRtl;
                                fM2385pointerSlopE8SPZFQ = DragGestureDetectorCopyKt.m2385pointerSlopE8SPZFQ(awaitPointerEventScope.getViewConfiguration(), pointerInputChange.getType());
                                if (Math.abs(state.getValue().floatValue() - floatRef.element) < fM2385pointerSlopE8SPZFQ && Math.abs(state2.getValue().floatValue() - floatRef.element) < fM2385pointerSlopE8SPZFQ) {
                                    float fFloatValue = ((Number) pair.getSecond()).floatValue();
                                    booleanRef.element = z ? fFloatValue < 0.0f : fFloatValue >= 0.0f;
                                    floatRef.element += Float.intBitsToFloat((int) (PointerEventKt.positionChange((PointerInputChange) pair.getFirst()) >> 32));
                                }
                            }
                            this.$rangeSliderLogic.captureThumb(booleanRef.element, floatRef.element, start, this.$$this$coroutineScope);
                            try {
                                long id = pointerInputChange.getId();
                                final State<Function2<Boolean, Float, Unit>> state3 = this.$onDrag;
                                final boolean z2 = this.$isRtl;
                                this.L$0 = start;
                                this.L$1 = booleanRef;
                                this.L$2 = null;
                                this.L$3 = null;
                                this.L$4 = null;
                                this.label = 3;
                                objM838horizontalDragjO51t88 = DragGestureDetectorKt.m838horizontalDragjO51t88(awaitPointerEventScope, id, new Function1() { // from class: androidx.compose.material.SliderKt$rangeSliderPressDragModifier$1$1$1$$ExternalSyntheticLambda0
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj2) {
                                        return SliderKt.AnonymousClass1.C00501.C00511.invokeSuspend$lambda$1(state3, booleanRef, z2, (PointerInputChange) obj2);
                                    }
                                }, this);
                                if (objM838horizontalDragjO51t88 != coroutine_suspended) {
                                    booleanRef2 = booleanRef;
                                    start2 = start;
                                    if (((Boolean) objM838horizontalDragjO51t88).booleanValue()) {
                                        cancel = new DragInteraction.Stop(start2);
                                    } else {
                                        cancel = new DragInteraction.Cancel(start2);
                                    }
                                    this.$gestureEndAction.getValue().invoke(Boxing.boxBoolean(booleanRef2.element));
                                    BuildersKt__Builders_commonKt.launch$default(this.$$this$coroutineScope, null, null, new AnonymousClass2(this.$rangeSliderLogic, booleanRef2, cancel, null), 3, null);
                                    return Unit.INSTANCE;
                                }
                                return coroutine_suspended;
                            } catch (CancellationException unused2) {
                                booleanRef2 = booleanRef;
                                start2 = start;
                                cancel = new DragInteraction.Cancel(start2);
                            }
                        }
                        pointerInputChange = (PointerInputChange) objAwaitFirstDown$default;
                        DragInteraction.Start start3 = new DragInteraction.Start();
                        Ref.FloatRef floatRef3 = new Ref.FloatRef();
                        floatRef3.element = this.$isRtl ? this.$maxPx - Float.intBitsToFloat((int) (pointerInputChange.getPosition() >> 32)) : Float.intBitsToFloat((int) (pointerInputChange.getPosition() >> 32));
                        int iCompareOffsets = this.$rangeSliderLogic.compareOffsets(floatRef3.element);
                        Ref.BooleanRef booleanRef3 = new Ref.BooleanRef();
                        booleanRef3.element = iCompareOffsets == 0 ? this.$rawOffsetStart.getValue().floatValue() > floatRef3.element : iCompareOffsets < 0;
                        this.L$0 = awaitPointerEventScope;
                        this.L$1 = pointerInputChange;
                        this.L$2 = start3;
                        this.L$3 = floatRef3;
                        this.L$4 = booleanRef3;
                        this.label = 2;
                        objM2551awaitSlop8vUncbI = SliderKt.m2551awaitSlop8vUncbI(awaitPointerEventScope, pointerInputChange.getId(), pointerInputChange.getType(), this);
                        if (objM2551awaitSlop8vUncbI != coroutine_suspended) {
                            floatRef = floatRef3;
                            start = start3;
                            booleanRef = booleanRef3;
                            pair = (Pair) objM2551awaitSlop8vUncbI;
                            if (pair != null) {
                                state = this.$rawOffsetEnd;
                                State<Float> state4 = this.$rawOffsetStart;
                                z = this.$isRtl;
                                fM2385pointerSlopE8SPZFQ = DragGestureDetectorCopyKt.m2385pointerSlopE8SPZFQ(awaitPointerEventScope.getViewConfiguration(), pointerInputChange.getType());
                                if (Math.abs(state.getValue().floatValue() - floatRef.element) < fM2385pointerSlopE8SPZFQ) {
                                    float fFloatValue2 = ((Number) pair.getSecond()).floatValue();
                                    booleanRef.element = z ? fFloatValue2 < 0.0f : fFloatValue2 >= 0.0f;
                                    floatRef.element += Float.intBitsToFloat((int) (PointerEventKt.positionChange((PointerInputChange) pair.getFirst()) >> 32));
                                }
                            }
                            this.$rangeSliderLogic.captureThumb(booleanRef.element, floatRef.element, start, this.$$this$coroutineScope);
                            long id2 = pointerInputChange.getId();
                            final State state5 = this.$onDrag;
                            final boolean z3 = this.$isRtl;
                            this.L$0 = start;
                            this.L$1 = booleanRef;
                            this.L$2 = null;
                            this.L$3 = null;
                            this.L$4 = null;
                            this.label = 3;
                            objM838horizontalDragjO51t88 = DragGestureDetectorKt.m838horizontalDragjO51t88(awaitPointerEventScope, id2, new Function1() { // from class: androidx.compose.material.SliderKt$rangeSliderPressDragModifier$1$1$1$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj2) {
                                    return SliderKt.AnonymousClass1.C00501.C00511.invokeSuspend$lambda$1(state5, booleanRef, z3, (PointerInputChange) obj2);
                                }
                            }, this);
                            if (objM838horizontalDragjO51t88 != coroutine_suspended) {
                                booleanRef2 = booleanRef;
                                start2 = start;
                                if (((Boolean) objM838horizontalDragjO51t88).booleanValue()) {
                                    cancel = new DragInteraction.Stop(start2);
                                } else {
                                    cancel = new DragInteraction.Cancel(start2);
                                }
                                this.$gestureEndAction.getValue().invoke(Boxing.boxBoolean(booleanRef2.element));
                                BuildersKt__Builders_commonKt.launch$default(this.$$this$coroutineScope, null, null, new AnonymousClass2(this.$rangeSliderLogic, booleanRef2, cancel, null), 3, null);
                                return Unit.INSTANCE;
                            }
                        }
                        return coroutine_suspended;
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public static final Unit invokeSuspend$lambda$1(State state, Ref.BooleanRef booleanRef, boolean z, PointerInputChange pointerInputChange) {
                        float fIntBitsToFloat = Float.intBitsToFloat((int) (PointerEventKt.positionChange(pointerInputChange) >> 32));
                        Function2 function2 = (Function2) state.getValue();
                        Boolean boolValueOf = Boolean.valueOf(booleanRef.element);
                        if (z) {
                            fIntBitsToFloat = -fIntBitsToFloat;
                        }
                        function2.invoke(boolValueOf, Float.valueOf(fIntBitsToFloat));
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: androidx.compose.material.SliderKt$rangeSliderPressDragModifier$1$1$1$2, reason: invalid class name */
                    /* JADX INFO: compiled from: Slider.kt */
                    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
                    @DebugMetadata(c = "androidx.compose.material.SliderKt$rangeSliderPressDragModifier$1$1$1$2", f = "Slider.kt", i = {}, l = {1133}, m = "invokeSuspend", n = {}, s = {}, v = 1)
                    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                        final /* synthetic */ Ref.BooleanRef $draggingStart;
                        final /* synthetic */ DragInteraction $finishInteraction;
                        final /* synthetic */ RangeSliderLogic $rangeSliderLogic;
                        int label;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        AnonymousClass2(RangeSliderLogic rangeSliderLogic, Ref.BooleanRef booleanRef, DragInteraction dragInteraction, Continuation<? super AnonymousClass2> continuation) {
                            super(2, continuation);
                            this.$rangeSliderLogic = rangeSliderLogic;
                            this.$draggingStart = booleanRef;
                            this.$finishInteraction = dragInteraction;
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                            return new AnonymousClass2(this.$rangeSliderLogic, this.$draggingStart, this.$finishInteraction, continuation);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object obj) {
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            int i = this.label;
                            if (i == 0) {
                                ResultKt.throwOnFailure(obj);
                                this.label = 1;
                                if (this.$rangeSliderLogic.activeInteraction(this.$draggingStart.element).emit(this.$finishInteraction, this) == coroutine_suspended) {
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
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = this.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                        this.label = 1;
                        if (ForEachGestureKt.awaitEachGesture(this.$this_pointerInput, new C00511(this.$isRtl, this.$maxPx, this.$rangeSliderLogic, this.$rawOffsetStart, coroutineScope, this.$gestureEndAction, this.$rawOffsetEnd, this.$onDrag, null), this) == coroutine_suspended) {
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
        }) : modifier;
    }

    public static final float getThumbRadius() {
        return ThumbRadius;
    }

    public static final float getTrackHeight() {
        return TrackHeight;
    }

    private static final float snapValueToTick(float f, List<Float> list, float f2, float f3) {
        Float f4;
        if (list.isEmpty()) {
            f4 = null;
        } else {
            Float f5 = list.get(0);
            float fAbs = Math.abs(MathHelpersKt.lerp(f2, f3, f5.floatValue()) - f);
            int lastIndex = CollectionsKt.getLastIndex(list);
            int i = 1;
            if (1 <= lastIndex) {
                while (true) {
                    Float f6 = list.get(i);
                    float fAbs2 = Math.abs(MathHelpersKt.lerp(f2, f3, f6.floatValue()) - f);
                    if (Float.compare(fAbs, fAbs2) > 0) {
                        f5 = f6;
                        fAbs = fAbs2;
                    }
                    if (i == lastIndex) {
                        break;
                    }
                    i++;
                }
            }
            f4 = f5;
        }
        Float f7 = f4;
        return f7 != null ? MathHelpersKt.lerp(f2, f3, f7.floatValue()) : f;
    }

    private static final Modifier sliderTapModifier(Modifier modifier, final DraggableState draggableState, final MutableInteractionSource mutableInteractionSource, final float f, final boolean z, final State<Float> state, final State<? extends Function1<? super Float, Unit>> state2, final MutableState<Float> mutableState, final boolean z2) {
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.material.SliderKt$sliderTapModifier$$inlined$debugInspectorInfo$1
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
                inspectorInfo.setName("sliderTapModifier");
                inspectorInfo.getProperties().set("draggableState", draggableState);
                inspectorInfo.getProperties().set("interactionSource", mutableInteractionSource);
                inspectorInfo.getProperties().set("maxPx", Float.valueOf(f));
                inspectorInfo.getProperties().set("isRtl", Boolean.valueOf(z));
                inspectorInfo.getProperties().set("rawOffset", state);
                inspectorInfo.getProperties().set("gestureEndAction", state2);
                inspectorInfo.getProperties().set("pressOffset", mutableState);
                inspectorInfo.getProperties().set("enabled", Boolean.valueOf(z2));
            }
        } : InspectableValueKt.getNoInspectorInfo(), new Function3() { // from class: androidx.compose.material.SliderKt$$ExternalSyntheticLambda9
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return SliderKt.sliderTapModifier$lambda$1(z2, draggableState, mutableInteractionSource, f, z, mutableState, state, state2, (Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        });
    }

    static {
        float fM9687constructorimpl = Dp.m9687constructorimpl(48);
        SliderHeight = fM9687constructorimpl;
        float fM9687constructorimpl2 = Dp.m9687constructorimpl(Token.DOTDOT);
        SliderMinWidth = fM9687constructorimpl2;
        DefaultSliderConstraints = SizeKt.m1254heightInVpY3zN4$default(SizeKt.m1273widthInVpY3zN4$default(Modifier.INSTANCE, fM9687constructorimpl2, 0.0f, 2, null), 0.0f, fM9687constructorimpl, 1, null);
        SliderToTickAnimation = new TweenSpec<>(100, 0, null, 6, null);
    }
}
