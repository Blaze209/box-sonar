package androidx.compose.material3;

import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.gestures.AnchoredDraggableKt;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
import androidx.compose.material3.internal.BackHandler_androidKt;
import androidx.compose.material3.internal.FloatProducer;
import androidx.compose.material3.internal.Strings;
import androidx.compose.material3.internal.Strings_androidKt;
import androidx.compose.material3.tokens.MotionSchemeKeyTokens;
import androidx.compose.material3.tokens.NavigationDrawerTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.focus.FocusRequesterModifierKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.TransformOriginKt;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.input.key.Key;
import androidx.compose.ui.input.key.KeyEvent;
import androidx.compose.ui.input.key.KeyEventType;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import androidx.compose.ui.input.key.KeyInputModifierKt;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.media3.exoplayer.upstream.CmcdData;
import androidx.media3.extractor.ts.PsExtractor;
import androidx.profileinstaller.ProfileVerifier;
import com.box.android.domain.metrics.hubs.HubsObservability;
import com.facebook.react.uimanager.ViewProps;
import external.sdk.pendo.io.mozilla.javascript.Token;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: NavigationDrawer.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a+\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005H\u0007¢\u0006\u0002\u0010\u0007\u001a]\u0010\b\u001a\u00020\t2\u0011\u0010\n\u001a\r\u0012\u0004\u0012\u00020\t0\u000b¢\u0006\u0002\b\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00012\b\b\u0002\u0010\u0010\u001a\u00020\u00062\b\b\u0002\u0010\u0011\u001a\u00020\u00122\u0011\u0010\u0013\u001a\r\u0012\u0004\u0012\u00020\t0\u000b¢\u0006\u0002\b\fH\u0007¢\u0006\u0004\b\u0014\u0010\u0015\u001aQ\u0010\u0016\u001a\u00020\t2\u0011\u0010\n\u001a\r\u0012\u0004\u0012\u00020\t0\u000b¢\u0006\u0002\b\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00012\b\b\u0002\u0010\u0010\u001a\u00020\u00062\u0011\u0010\u0013\u001a\r\u0012\u0004\u0012\u00020\t0\u000b¢\u0006\u0002\b\fH\u0007¢\u0006\u0002\u0010\u0017\u001a=\u0010\u0018\u001a\u00020\t2\u0011\u0010\n\u001a\r\u0012\u0004\u0012\u00020\t0\u000b¢\u0006\u0002\b\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\u0011\u0010\u0013\u001a\r\u0012\u0004\u0012\u00020\t0\u000b¢\u0006\u0002\b\fH\u0007¢\u0006\u0002\u0010\u0019\u001ai\u0010\u001a\u001a\u00020\t2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u00122\b\b\u0002\u0010\u001e\u001a\u00020\u00122\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"2\u001c\u0010\u0013\u001a\u0018\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\t0\u0005¢\u0006\u0002\b\f¢\u0006\u0002\b$H\u0007¢\u0006\u0004\b%\u0010&\u001aq\u0010\u001a\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00012\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u00122\b\b\u0002\u0010\u001e\u001a\u00020\u00122\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"2\u001c\u0010\u0013\u001a\u0018\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\t0\u0005¢\u0006\u0002\b\f¢\u0006\u0002\b$H\u0007¢\u0006\u0004\b'\u0010(\u001ai\u0010)\u001a\u00020\t2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u00122\b\b\u0002\u0010\u001e\u001a\u00020\u00122\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"2\u001c\u0010\u0013\u001a\u0018\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\t0\u0005¢\u0006\u0002\b\f¢\u0006\u0002\b$H\u0007¢\u0006\u0004\b*\u0010&\u001aq\u0010)\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00012\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u00122\b\b\u0002\u0010\u001e\u001a\u00020\u00122\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"2\u001c\u0010\u0013\u001a\u0018\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\t0\u0005¢\u0006\u0002\b\f¢\u0006\u0002\b$H\u0007¢\u0006\u0004\b+\u0010(\u001ai\u0010,\u001a\u00020\t2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u00122\b\b\u0002\u0010\u001e\u001a\u00020\u00122\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"2\u001c\u0010\u0013\u001a\u0018\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\t0\u0005¢\u0006\u0002\b\f¢\u0006\u0002\b$H\u0007¢\u0006\u0004\b-\u0010&\u001a{\u0010.\u001a\u00020\t2\b\u0010/\u001a\u0004\u0018\u0001002\u0006\u0010!\u001a\u00020\"2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u00122\b\b\u0002\u0010\u001e\u001a\u00020\u00122\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u00101\u001a\u0002022\u001c\u0010\u0013\u001a\u0018\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\t0\u0005¢\u0006\u0002\b\f¢\u0006\u0002\b$H\u0001¢\u0006\u0004\b3\u00104\u001a$\u00105\u001a\u00020\u000e*\u00020\u000e2\u0006\u00101\u001a\u0002022\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u00020\u0006H\u0002\u001a$\u00109\u001a\u00020\u000e*\u00020\u000e2\u0006\u00101\u001a\u0002022\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u00020\u0006H\u0002\u001a\u001c\u0010:\u001a\u00020\u000e*\u00020\u000e2\u0006\u0010/\u001a\u0002002\u0006\u00108\u001a\u00020\u0006H\u0002\u001a\u001c\u0010;\u001a\u00020\u000e*\u00020\u000e2\u0006\u0010/\u001a\u0002002\u0006\u00108\u001a\u00020\u0006H\u0002\u001a\u0014\u0010<\u001a\u000207*\u00020=2\u0006\u0010/\u001a\u000200H\u0002\u001a\u0014\u0010>\u001a\u000207*\u00020=2\u0006\u0010/\u001a\u000200H\u0002\u001a.\u0010?\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00012\u0017\u0010\u0013\u001a\u0013\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020\t0\u0005¢\u0006\u0002\b\fH\u0001¢\u0006\u0002\u0010@\u001a\u008e\u0001\u0010A\u001a\u00020\t2\u0011\u0010B\u001a\r\u0012\u0004\u0012\u00020\t0\u000b¢\u0006\u0002\b\f2\u0006\u0010C\u001a\u00020\u00062\f\u0010D\u001a\b\u0012\u0004\u0012\u00020\t0\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000e2\u0015\b\u0002\u0010E\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u000b¢\u0006\u0002\b\f2\u0015\b\u0002\u0010F\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u000b¢\u0006\u0002\b\f2\b\b\u0002\u0010G\u001a\u00020\u001c2\b\b\u0002\u0010H\u001a\u00020I2\n\b\u0002\u0010J\u001a\u0004\u0018\u00010KH\u0007¢\u0006\u0002\u0010L\u001a \u0010M\u001a\u0002072\u0006\u0010N\u001a\u0002072\u0006\u0010O\u001a\u0002072\u0006\u0010P\u001a\u000207H\u0002\u001a;\u0010Q\u001a\u00020\t2\u0006\u0010R\u001a\u00020\u00062\f\u0010S\u001a\b\u0012\u0004\u0012\u00020\t0\u000b2\f\u0010T\u001a\b\u0012\u0004\u0012\u0002070\u000b2\u0006\u0010U\u001a\u00020\u0012H\u0003¢\u0006\u0004\bV\u0010W\"\u000e\u0010X\u001a\u000207X\u0082D¢\u0006\u0002\n\u0000\"\u0010\u0010Y\u001a\u00020 X\u0082\u0004¢\u0006\u0004\n\u0002\u0010Z\"\u0010\u0010[\u001a\u00020 X\u0082\u0004¢\u0006\u0004\n\u0002\u0010Z\"\u0016\u0010\\\u001a\u00020 X\u0080\u0004¢\u0006\n\n\u0002\u0010Z\u001a\u0004\b]\u0010^\"\u0016\u0010_\u001a\u00020 X\u0080\u0004¢\u0006\n\n\u0002\u0010Z\u001a\u0004\b`\u0010^\"\u0016\u0010a\u001a\u00020 X\u0080\u0004¢\u0006\n\n\u0002\u0010Z\u001a\u0004\bb\u0010^\"\u0014\u0010c\u001a\b\u0012\u0004\u0012\u0002070dX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006e²\u0006\n\u0010f\u001a\u00020\u0006X\u008a\u008e\u0002²\u0006\n\u0010g\u001a\u000207X\u008a\u008e\u0002²\u0006\n\u0010f\u001a\u00020\u0006X\u008a\u008e\u0002"}, d2 = {"rememberDrawerState", "Landroidx/compose/material3/DrawerState;", "initialValue", "Landroidx/compose/material3/DrawerValue;", "confirmStateChange", "Lkotlin/Function1;", "", "(Landroidx/compose/material3/DrawerValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/DrawerState;", "ModalNavigationDrawer", "", "drawerContent", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "modifier", "Landroidx/compose/ui/Modifier;", "drawerState", "gesturesEnabled", "scrimColor", "Landroidx/compose/ui/graphics/Color;", "content", "ModalNavigationDrawer-FHprtrg", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/DrawerState;ZJLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "DismissibleNavigationDrawer", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/DrawerState;ZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "PermanentNavigationDrawer", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "ModalDrawerSheet", "drawerShape", "Landroidx/compose/ui/graphics/Shape;", "drawerContainerColor", "drawerContentColor", "drawerTonalElevation", "Landroidx/compose/ui/unit/Dp;", "windowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "Landroidx/compose/foundation/layout/ColumnScope;", "Lkotlin/ExtensionFunctionType;", "ModalDrawerSheet-afqeVBk", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;JJFLandroidx/compose/foundation/layout/WindowInsets;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "ModalDrawerSheet-Snr_uVM", "(Landroidx/compose/material3/DrawerState;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;JJFLandroidx/compose/foundation/layout/WindowInsets;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "DismissibleDrawerSheet", "DismissibleDrawerSheet-afqeVBk", "DismissibleDrawerSheet-Snr_uVM", "PermanentDrawerSheet", "PermanentDrawerSheet-afqeVBk", "DrawerSheet", "drawerPredictiveBackState", "Landroidx/compose/material3/DrawerPredictiveBackState;", "drawerOffset", "Landroidx/compose/material3/internal/FloatProducer;", "DrawerSheet-cm3T3N0", "(Landroidx/compose/material3/DrawerPredictiveBackState;Landroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;JJFLandroidx/compose/material3/internal/FloatProducer;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "horizontalScaleUp", "drawerWidth", "", "isRtl", "horizontalScaleDown", "predictiveBackDrawerContainer", "predictiveBackDrawerChild", "calculatePredictiveBackScaleX", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "calculatePredictiveBackScaleY", "DrawerPredictiveBackHandler", "(Landroidx/compose/material3/DrawerState;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;I)V", "NavigationDrawerItem", "label", "selected", ViewProps.ON_CLICK, HubsObservability.HUB_ASSET_ICON, "badge", "shape", "colors", "Landroidx/compose/material3/NavigationDrawerItemColors;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "(Lkotlin/jvm/functions/Function2;ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/NavigationDrawerItemColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "calculateFraction", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "b", "pos", "Scrim", "open", "onClose", "fraction", "color", "Scrim-Bx497Mc", "(ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;JLandroidx/compose/runtime/Composer;I)V", "DrawerPositionalThreshold", "DrawerVelocityThreshold", "F", "MinimumDrawerWidth", "PredictiveBackDrawerMaxScaleXDistanceGrow", "getPredictiveBackDrawerMaxScaleXDistanceGrow", "()F", "PredictiveBackDrawerMaxScaleXDistanceShrink", "getPredictiveBackDrawerMaxScaleXDistanceShrink", "PredictiveBackDrawerMaxScaleYDistance", "getPredictiveBackDrawerMaxScaleYDistance", "AnchoredDraggableDefaultAnimationSpec", "Landroidx/compose/animation/core/TweenSpec;", "material3", "anchorsInitialized", "minValue"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class NavigationDrawerKt {
    private static final float DrawerPositionalThreshold = 0.5f;
    private static final float DrawerVelocityThreshold = Dp.m9687constructorimpl(400);
    private static final float MinimumDrawerWidth = Dp.m9687constructorimpl(PsExtractor.VIDEO_STREAM_MASK);
    private static final float PredictiveBackDrawerMaxScaleXDistanceGrow = Dp.m9687constructorimpl(12);
    private static final float PredictiveBackDrawerMaxScaleXDistanceShrink = Dp.m9687constructorimpl(24);
    private static final float PredictiveBackDrawerMaxScaleYDistance = Dp.m9687constructorimpl(48);
    private static final TweenSpec<Float> AnchoredDraggableDefaultAnimationSpec = new TweenSpec<>(256, 0, null, 6, null);

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DismissibleDrawerSheet_Snr_uVM$lambda$1(DrawerState drawerState, Modifier modifier, Shape shape, long j, long j2, float f, WindowInsets windowInsets, Function3 function3, int i, int i2, Composer composer, int i3) {
        m3863DismissibleDrawerSheetSnr_uVM(drawerState, modifier, shape, j, j2, f, windowInsets, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DismissibleDrawerSheet_afqeVBk$lambda$0(Modifier modifier, Shape shape, long j, long j2, float f, WindowInsets windowInsets, Function3 function3, int i, int i2, Composer composer, int i3) {
        m3864DismissibleDrawerSheetafqeVBk(modifier, shape, j, j2, f, windowInsets, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DismissibleNavigationDrawer$lambda$7(Function2 function2, Modifier modifier, DrawerState drawerState, boolean z, Function2 function3, int i, int i2, Composer composer, int i3) {
        DismissibleNavigationDrawer(function2, modifier, drawerState, z, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DrawerPredictiveBackHandler$lambda$4(DrawerState drawerState, Function3 function3, int i, Composer composer, int i2) {
        DrawerPredictiveBackHandler(drawerState, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float DrawerSheet_cm3T3N0$lambda$0$0() {
        return 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DrawerSheet_cm3T3N0$lambda$3(DrawerPredictiveBackState drawerPredictiveBackState, WindowInsets windowInsets, Modifier modifier, Shape shape, long j, long j2, float f, FloatProducer floatProducer, Function3 function3, int i, int i2, Composer composer, int i3) {
        m3865DrawerSheetcm3T3N0(drawerPredictiveBackState, windowInsets, modifier, shape, j, j2, f, floatProducer, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ModalDrawerSheet_Snr_uVM$lambda$1(DrawerState drawerState, Modifier modifier, Shape shape, long j, long j2, float f, WindowInsets windowInsets, Function3 function3, int i, int i2, Composer composer, int i3) {
        m3866ModalDrawerSheetSnr_uVM(drawerState, modifier, shape, j, j2, f, windowInsets, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ModalDrawerSheet_afqeVBk$lambda$0(Modifier modifier, Shape shape, long j, long j2, float f, WindowInsets windowInsets, Function3 function3, int i, int i2, Composer composer, int i3) {
        m3867ModalDrawerSheetafqeVBk(modifier, shape, j, j2, f, windowInsets, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ModalNavigationDrawer_FHprtrg$lambda$10(Function2 function2, Modifier modifier, DrawerState drawerState, boolean z, long j, Function2 function3, int i, int i2, Composer composer, int i3) {
        m3868ModalNavigationDrawerFHprtrg(function2, modifier, drawerState, z, j, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NavigationDrawerItem$lambda$2(Function2 function2, boolean z, Function0 function0, Modifier modifier, Function2 function3, Function2 function4, Shape shape, NavigationDrawerItemColors navigationDrawerItemColors, MutableInteractionSource mutableInteractionSource, int i, int i2, Composer composer, int i3) {
        NavigationDrawerItem(function2, z, function0, modifier, function3, function4, shape, navigationDrawerItemColors, mutableInteractionSource, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PermanentDrawerSheet_afqeVBk$lambda$1(Modifier modifier, Shape shape, long j, long j2, float f, WindowInsets windowInsets, Function3 function3, int i, int i2, Composer composer, int i3) {
        m3869PermanentDrawerSheetafqeVBk(modifier, shape, j, j2, f, windowInsets, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PermanentNavigationDrawer$lambda$1(Function2 function2, Modifier modifier, Function2 function3, int i, int i2, Composer composer, int i3) {
        PermanentNavigationDrawer(function2, modifier, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Scrim_Bx497Mc$lambda$3(boolean z, Function0 function0, Function0 function1, long j, int i, Composer composer, int i2) {
        m3870ScrimBx497Mc(z, function0, function1, j, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean rememberDrawerState$lambda$0$0(DrawerValue drawerValue) {
        return true;
    }

    public static final DrawerState rememberDrawerState(final DrawerValue drawerValue, final Function1<? super DrawerValue, Boolean> function1, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, 2098699222, "C(rememberDrawerState)N(initialValue,confirmStateChange)311@12762L8,313@12864L61,313@12800L125:NavigationDrawer.kt#uh7d8r");
        if ((i2 & 2) != 0) {
            ComposerKt.sourceInformationMarkerStart(composer, -1784673346, "CC(remember):NavigationDrawer.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda37
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return Boolean.valueOf(NavigationDrawerKt.rememberDrawerState$lambda$0$0((DrawerValue) obj));
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            function1 = (Function1) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2098699222, i, -1, "androidx.compose.material3.rememberDrawerState (NavigationDrawer.kt:312)");
        }
        Object[] objArr = new Object[0];
        Saver<DrawerState, DrawerValue> Saver = DrawerState.INSTANCE.Saver(function1);
        ComposerKt.sourceInformationMarkerStart(composer, -1784670029, "CC(remember):NavigationDrawer.kt#9igjgp");
        boolean z = true;
        boolean z2 = (((i & 14) ^ 6) > 4 && composer.changed(drawerValue.ordinal())) || (i & 6) == 4;
        if ((((i & 112) ^ 48) <= 32 || !composer.changed(function1)) && (i & 48) != 32) {
            z = false;
        }
        boolean z3 = z2 | z;
        Object objRememberedValue2 = composer.rememberedValue();
        if (z3 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue2 = new Function0() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda38
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return NavigationDrawerKt.rememberDrawerState$lambda$1$0(drawerValue, function1);
                }
            };
            composer.updateRememberedValue(objRememberedValue2);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        DrawerState drawerState = (DrawerState) RememberSaveableKt.m6247rememberSaveable(objArr, (Saver) Saver, (Function0) objRememberedValue2, composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return drawerState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DrawerState rememberDrawerState$lambda$1$0(DrawerValue drawerValue, Function1 function1) {
        return new DrawerState(drawerValue, function1);
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0195  */
    /* JADX WARN: Code duplicated, block: B:103:0x01ae  */
    /* JADX WARN: Code duplicated, block: B:106:0x01b9  */
    /* JADX WARN: Code duplicated, block: B:110:0x01da  */
    /* JADX WARN: Code duplicated, block: B:113:0x020d  */
    /* JADX WARN: Code duplicated, block: B:117:0x0217  */
    /* JADX WARN: Code duplicated, block: B:119:0x021d A[PHI: r20
      0x021d: PHI (r20v7 androidx.compose.material3.DrawerState) = (r20v1 androidx.compose.material3.DrawerState), (r20v8 androidx.compose.material3.DrawerState) binds: [B:118:0x021b, B:116:0x0214] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:120:0x021f  */
    /* JADX WARN: Code duplicated, block: B:123:0x023a  */
    /* JADX WARN: Code duplicated, block: B:127:0x0246  */
    /* JADX WARN: Code duplicated, block: B:130:0x0275  */
    /* JADX WARN: Code duplicated, block: B:132:0x027b  */
    /* JADX WARN: Code duplicated, block: B:138:0x0288  */
    /* JADX WARN: Code duplicated, block: B:140:0x0290  */
    /* JADX WARN: Code duplicated, block: B:143:0x02be  */
    /* JADX WARN: Code duplicated, block: B:144:0x02c1  */
    /* JADX WARN: Code duplicated, block: B:147:0x0327  */
    /* JADX WARN: Code duplicated, block: B:150:0x0333  */
    /* JADX WARN: Code duplicated, block: B:151:0x0337  */
    /* JADX WARN: Code duplicated, block: B:154:0x035c  */
    /* JADX WARN: Code duplicated, block: B:156:0x036a  */
    /* JADX WARN: Code duplicated, block: B:159:0x03d4  */
    /* JADX WARN: Code duplicated, block: B:162:0x03e0  */
    /* JADX WARN: Code duplicated, block: B:163:0x03e4  */
    /* JADX WARN: Code duplicated, block: B:166:0x0409  */
    /* JADX WARN: Code duplicated, block: B:168:0x0417  */
    /* JADX WARN: Code duplicated, block: B:171:0x046f  */
    /* JADX WARN: Code duplicated, block: B:172:0x0471  */
    /* JADX WARN: Code duplicated, block: B:175:0x0476  */
    /* JADX WARN: Code duplicated, block: B:177:0x047c  */
    /* JADX WARN: Code duplicated, block: B:183:0x048f  */
    /* JADX WARN: Code duplicated, block: B:185:0x0497  */
    /* JADX WARN: Code duplicated, block: B:188:0x04b2  */
    /* JADX WARN: Code duplicated, block: B:190:0x04b8  */
    /* JADX WARN: Code duplicated, block: B:196:0x04c6  */
    /* JADX WARN: Code duplicated, block: B:198:0x04ce  */
    /* JADX WARN: Code duplicated, block: B:201:0x0500  */
    /* JADX WARN: Code duplicated, block: B:203:0x0506  */
    /* JADX WARN: Code duplicated, block: B:209:0x0513  */
    /* JADX WARN: Code duplicated, block: B:211:0x051b  */
    /* JADX WARN: Code duplicated, block: B:214:0x0538  */
    /* JADX WARN: Code duplicated, block: B:216:0x053e  */
    /* JADX WARN: Code duplicated, block: B:222:0x0551  */
    /* JADX WARN: Code duplicated, block: B:224:0x0559  */
    /* JADX WARN: Code duplicated, block: B:227:0x0575  */
    /* JADX WARN: Code duplicated, block: B:229:0x057b  */
    /* JADX WARN: Code duplicated, block: B:235:0x058d  */
    /* JADX WARN: Code duplicated, block: B:237:0x0595  */
    /* JADX WARN: Code duplicated, block: B:23:0x0045  */
    /* JADX WARN: Code duplicated, block: B:240:0x05b7  */
    /* JADX WARN: Code duplicated, block: B:242:0x05bd  */
    /* JADX WARN: Code duplicated, block: B:248:0x05cf  */
    /* JADX WARN: Code duplicated, block: B:250:0x05d7  */
    /* JADX WARN: Code duplicated, block: B:253:0x061c  */
    /* JADX WARN: Code duplicated, block: B:256:0x0628  */
    /* JADX WARN: Code duplicated, block: B:257:0x062c  */
    /* JADX WARN: Code duplicated, block: B:25:0x0049  */
    /* JADX WARN: Code duplicated, block: B:260:0x0651  */
    /* JADX WARN: Code duplicated, block: B:262:0x065f  */
    /* JADX WARN: Code duplicated, block: B:265:0x06a6  */
    /* JADX WARN: Code duplicated, block: B:267:0x06ae  */
    /* JADX WARN: Code duplicated, block: B:270:0x06be  */
    /* JADX WARN: Code duplicated, block: B:272:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:27:0x0051  */
    /* JADX WARN: Code duplicated, block: B:28:0x0054  */
    /* JADX WARN: Code duplicated, block: B:31:0x005a  */
    /* JADX WARN: Code duplicated, block: B:34:0x0060  */
    /* JADX WARN: Code duplicated, block: B:35:0x0063  */
    /* JADX WARN: Code duplicated, block: B:37:0x0067  */
    /* JADX WARN: Code duplicated, block: B:39:0x006f  */
    /* JADX WARN: Code duplicated, block: B:40:0x0072  */
    /* JADX WARN: Code duplicated, block: B:45:0x007c  */
    /* JADX WARN: Code duplicated, block: B:47:0x0082  */
    /* JADX WARN: Code duplicated, block: B:50:0x008b  */
    /* JADX WARN: Code duplicated, block: B:52:0x008f  */
    /* JADX WARN: Code duplicated, block: B:55:0x0096  */
    /* JADX WARN: Code duplicated, block: B:57:0x009c  */
    /* JADX WARN: Code duplicated, block: B:58:0x009f  */
    /* JADX WARN: Code duplicated, block: B:62:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:63:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:66:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:68:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:78:0x00e1 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:79:0x00e3  */
    /* JADX WARN: Code duplicated, block: B:80:0x00e8  */
    /* JADX WARN: Code duplicated, block: B:83:0x00ed  */
    /* JADX WARN: Code duplicated, block: B:85:0x00f8  */
    /* JADX WARN: Code duplicated, block: B:86:0x00fa  */
    /* JADX WARN: Code duplicated, block: B:89:0x0100  */
    /* JADX WARN: Code duplicated, block: B:90:0x0109  */
    /* JADX WARN: Code duplicated, block: B:93:0x0113  */
    /* JADX WARN: Code duplicated, block: B:96:0x0138  */
    /* JADX WARN: Code duplicated, block: B:99:0x0183  */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /* JADX INFO: renamed from: ModalNavigationDrawer-FHprtrg, reason: not valid java name */
    public static final void m3868ModalNavigationDrawerFHprtrg(Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, DrawerState drawerState, boolean z, long j, final Function2<? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        DrawerState drawerStateRememberDrawerState;
        int i4;
        int i5;
        long j2;
        boolean z2;
        Function2<? super Composer, ? super Integer, Unit> function4;
        final boolean z3;
        Modifier modifier3;
        final DrawerState drawerState2;
        final long j3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        boolean z4;
        long scrimColor;
        Object objRememberedValue;
        final CoroutineScope coroutineScope;
        final String strM5086getString2EP1pXo;
        final Density density;
        Object objRememberedValue2;
        MutableState mutableState;
        boolean zChanged;
        Object objRememberedValue3;
        float f;
        final MutableFloatState mutableFloatState;
        Object objRememberedValue4;
        FocusRequester focusRequester;
        final FiniteAnimationSpec finiteAnimationSpecValue;
        final FiniteAnimationSpec finiteAnimationSpecValue2;
        final FiniteAnimationSpec finiteAnimationSpecValue3;
        int i6;
        final DrawerState drawerState3;
        boolean z5;
        boolean zChanged2;
        Object objRememberedValue5;
        boolean z6;
        NavigationDrawerKt$ModalNavigationDrawer$2$1 navigationDrawerKt$ModalNavigationDrawer$2$1RememberedValue;
        Object objConsume;
        boolean z7;
        final boolean z8;
        int currentCompositeKeyHash;
        Function0<ComposeUiNode> constructor;
        Composer composerM6062constructorimpl;
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash;
        int currentCompositeKeyHash2;
        Function0<ComposeUiNode> constructor2;
        Composer composerM6062constructorimpl2;
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2;
        boolean z9;
        boolean zChangedInstance;
        Object objRememberedValue6;
        boolean zChanged3;
        Object objRememberedValue7;
        boolean z10;
        Object objRememberedValue8;
        boolean zChanged4;
        Object objRememberedValue9;
        boolean zChangedInstance2;
        Object objRememberedValue10;
        boolean zChanged5;
        NavigationDrawerKt$ModalNavigationDrawer$3$7$1 navigationDrawerKt$ModalNavigationDrawer$3$7$1RememberedValue;
        int currentCompositeKeyHash3;
        Function0<ComposeUiNode> constructor3;
        Composer composerM6062constructorimpl3;
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3;
        int i7;
        int i8;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1907430816);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ModalNavigationDrawer)N(drawerContent,modifier,drawerState,gesturesEnabled,scrimColor:c#ui.graphics.Color,content)346@14219L24,347@14269L33,348@14334L7,349@14372L34,350@14427L45,352@14520L29,356@14730L7,357@14824L7,358@14916L7,360@14940L229,360@14929L240,367@15210L178,367@15175L213,374@15427L7,375@15462L4084:NavigationDrawer.kt#uh7d8r");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(function2) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i9 = i2 & 2;
        if (i9 == 0) {
            if ((i & 48) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            if ((i & 384) == 0) {
                if ((i2 & 4) == 0) {
                    drawerStateRememberDrawerState = drawerState;
                    int i10 = composerStartRestartGroup.changed(drawerStateRememberDrawerState) ? 256 : 128;
                    i3 |= i10;
                } else {
                    drawerStateRememberDrawerState = drawerState;
                }
                i3 |= i10;
            } else {
                drawerStateRememberDrawerState = drawerState;
            }
            i4 = i2 & 8;
            if (i4 != 0) {
                if ((i & 3072) == 0) {
                    if (composerStartRestartGroup.changed(z)) {
                        i5 = 2048;
                    } else {
                        i5 = 1024;
                    }
                    i3 |= i5;
                }
                if ((i & 24576) == 0) {
                    j2 = j;
                    if ((i2 & 16) == 0 || !composerStartRestartGroup.changed(j2)) {
                        i8 = 8192;
                    } else {
                        i8 = 16384;
                    }
                    i3 |= i8;
                } else {
                    j2 = j;
                }
                if ((196608 & i) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i7 = 131072;
                    } else {
                        i7 = 65536;
                    }
                    i3 |= i7;
                }
                if ((74899 & i3) != 74898) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z2, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "341@14033L39,343@14150L10");
                    if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                        if (i9 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                            drawerStateRememberDrawerState = rememberDrawerState(DrawerValue.Closed, null, composerStartRestartGroup, 6, 2);
                        }
                        if (i4 != 0) {
                            z4 = true;
                        } else {
                            z4 = z;
                        }
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                            scrimColor = DrawerDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                        } else {
                            scrimColor = j2;
                        }
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                        }
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                        }
                        companion = modifier2;
                        scrimColor = j2;
                        z4 = z;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1907430816, i3, -1, "androidx.compose.material3.ModalNavigationDrawer (NavigationDrawer.kt:345)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 773894976, "CC(rememberCoroutineScope)N(getContext)608@27648L68:Effects.kt#9igjgp");
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 683737348, "CC(remember):Effects.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    coroutineScope = (CoroutineScope) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Strings.Companion companion2 = Strings.INSTANCE;
                    strM5086getString2EP1pXo = Strings_androidKt.m5086getString2EP1pXo(Strings.m5002constructorimpl(androidx.compose.ui.R.string.navigation_menu), composerStartRestartGroup, 0);
                    ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume2 = composerStartRestartGroup.consume(localDensity);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    density = (Density) objConsume2;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 910036450, "CC(remember):NavigationDrawer.kt#9igjgp");
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    mutableState = (MutableState) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 910038221, "CC(remember):NavigationDrawer.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(density);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        f = 0.0f;
                    } else {
                        f = 0.0f;
                        if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        }
                        mutableFloatState = (MutableFloatState) objRememberedValue3;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 910041181, "CC(remember):NavigationDrawer.kt#9igjgp");
                        objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue4 = new FocusRequester();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        }
                        focusRequester = (FocusRequester) objRememberedValue4;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        finiteAnimationSpecValue = MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultSpatial, composerStartRestartGroup, 6);
                        long j4 = scrimColor;
                        finiteAnimationSpecValue2 = MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultSpatial, composerStartRestartGroup, 6);
                        finiteAnimationSpecValue3 = MotionSchemeKt.value(MotionSchemeKeyTokens.FastEffects, composerStartRestartGroup, 6);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 910054821, "CC(remember):NavigationDrawer.kt#9igjgp");
                        i6 = (i3 & 896) ^ 384;
                        if (i6 > 256 || !composerStartRestartGroup.changed(drawerStateRememberDrawerState)) {
                            drawerState3 = drawerStateRememberDrawerState;
                            if ((i3 & 384) != 256) {
                                z5 = false;
                            }
                            zChanged2 = z5 | composerStartRestartGroup.changed(density) | composerStartRestartGroup.changedInstance(finiteAnimationSpecValue2) | composerStartRestartGroup.changedInstance(finiteAnimationSpecValue3) | composerStartRestartGroup.changedInstance(finiteAnimationSpecValue);
                            objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                            if (!zChanged2 || objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue5 = new Function0() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda2
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return NavigationDrawerKt.ModalNavigationDrawer_FHprtrg$lambda$7$0(drawerState3, density, finiteAnimationSpecValue2, finiteAnimationSpecValue3, finiteAnimationSpecValue);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            EffectsKt.SideEffect((Function0) objRememberedValue5, composerStartRestartGroup, 0);
                            Boolean boolValueOf = Boolean.valueOf(drawerState3.isOpen());
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 910063410, "CC(remember):NavigationDrawer.kt#9igjgp");
                            z6 = (i6 <= 256 && composerStartRestartGroup.changed(drawerState3)) || (i3 & 384) == 256;
                            navigationDrawerKt$ModalNavigationDrawer$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                            if (!z6 || navigationDrawerKt$ModalNavigationDrawer$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                                navigationDrawerKt$ModalNavigationDrawer$2$1RememberedValue = new NavigationDrawerKt$ModalNavigationDrawer$2$1(drawerState3, focusRequester, null);
                                composerStartRestartGroup.updateRememberedValue(navigationDrawerKt$ModalNavigationDrawer$2$1RememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            EffectsKt.LaunchedEffect(boolValueOf, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) navigationDrawerKt$ModalNavigationDrawer$2$1RememberedValue, composerStartRestartGroup, 0);
                            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                            objConsume = composerStartRestartGroup.consume(localLayoutDirection);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            if (objConsume == LayoutDirection.Rtl) {
                                z7 = true;
                            } else {
                                z7 = false;
                            }
                            z8 = z4;
                            Modifier modifierAnchoredDraggable$default = AnchoredDraggableKt.anchoredDraggable$default(SizeKt.fillMaxSize$default(companion, f, 1, null), drawerState3.getAnchoredDraggableState$material3(), z7, Orientation.Horizontal, z8, (MutableInteractionSource) null, (OverscrollEffect) null, (FlingBehavior) null, 112, (Object) null);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                            modifier3 = companion;
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierAnchoredDraggable$default);
                            constructor = ComposeUiNode.INSTANCE.getConstructor();
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
                            composerM6062constructorimpl = Updater.m6062constructorimpl(composerStartRestartGroup);
                            Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                            setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                            if (!composerM6062constructorimpl.getInserting() || !Intrinsics.areEqual(composerM6062constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                            }
                            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 101899237, "C385@15772L17,388@15866L183,393@16074L70,386@15798L389,399@16296L601,411@16929L452,422@17414L501,435@17979L1561,396@16196L3344:NavigationDrawer.kt#uh7d8r");
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                            Modifier.Companion companion3 = Modifier.INSTANCE;
                            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                            currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion3);
                            constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            composerStartRestartGroup.startReusableNode();
                            if (composerStartRestartGroup.getInserting()) {
                                composerStartRestartGroup.createNode(constructor2);
                            } else {
                                composerStartRestartGroup.useNode();
                            }
                            composerM6062constructorimpl2 = Updater.m6062constructorimpl(composerStartRestartGroup);
                            Updater.m6070setimpl(composerM6062constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m6070setimpl(composerM6062constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                            setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                            if (!composerM6062constructorimpl2.getInserting() || !Intrinsics.areEqual(composerM6062constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                                composerM6062constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                                composerM6062constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                            }
                            Updater.m6070setimpl(composerM6062constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                            BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 343987054, "C385@15778L9:NavigationDrawer.kt#uh7d8r");
                            function3.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 15) & 14));
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            composerStartRestartGroup.endNode();
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            boolean zIsOpen = drawerState3.isOpen();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2081496477, "CC(remember):NavigationDrawer.kt#9igjgp");
                            if ((i3 & 7168) == 2048) {
                                z9 = true;
                            } else {
                                z9 = false;
                            }
                            zChangedInstance = z9 | ((i6 <= 256 && composerStartRestartGroup.changed(drawerState3)) || (i3 & 384) == 256) | composerStartRestartGroup.changedInstance(coroutineScope);
                            objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                            if (!zChangedInstance || objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue6 = new Function0() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda3
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return NavigationDrawerKt.ModalNavigationDrawer_FHprtrg$lambda$9$1$0(z8, drawerState3, coroutineScope);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                            }
                            Function0 function0 = (Function0) objRememberedValue6;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2081503020, "CC(remember):NavigationDrawer.kt#9igjgp");
                            zChanged3 = composerStartRestartGroup.changed(mutableFloatState) | ((i6 <= 256 && composerStartRestartGroup.changed(drawerState3)) || (i3 & 384) == 256);
                            objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                            if (!zChanged3 || objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                                final float f2 = 0.0f;
                                objRememberedValue7 = new Function0() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda4
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return Float.valueOf(NavigationDrawerKt.ModalNavigationDrawer_FHprtrg$lambda$9$2$0(f2, drawerState3, mutableFloatState));
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            m3870ScrimBx497Mc(zIsOpen, function0, (Function0) objRememberedValue7, j4, composerStartRestartGroup, (i3 >> 3) & 7168);
                            Modifier.Companion companion4 = Modifier.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2081510655, "CC(remember):NavigationDrawer.kt#9igjgp");
                            z10 = (i6 <= 256 && composerStartRestartGroup.changed(drawerState3)) || (i3 & 384) == 256;
                            objRememberedValue8 = composerStartRestartGroup.rememberedValue();
                            if (!z10 || objRememberedValue8 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue8 = new Function1() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda5
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return NavigationDrawerKt.ModalNavigationDrawer_FHprtrg$lambda$9$3$0(drawerState3, (Density) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            Modifier modifierOffset = OffsetKt.offset(companion4, (Function1) objRememberedValue8);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2081530762, "CC(remember):NavigationDrawer.kt#9igjgp");
                            zChanged4 = composerStartRestartGroup.changed(strM5086getString2EP1pXo) | ((i6 <= 256 && composerStartRestartGroup.changed(drawerState3)) || (i3 & 384) == 256) | composerStartRestartGroup.changedInstance(coroutineScope);
                            objRememberedValue9 = composerStartRestartGroup.rememberedValue();
                            if (!zChanged4 || objRememberedValue9 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue9 = new Function1() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda6
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return NavigationDrawerKt.ModalNavigationDrawer_FHprtrg$lambda$9$4$0(strM5086getString2EP1pXo, drawerState3, coroutineScope, (SemanticsPropertyReceiver) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue9);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            Modifier modifierSemantics$default = SemanticsModifierKt.semantics$default(modifierOffset, false, (Function1) objRememberedValue9, 1, null);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2081546331, "CC(remember):NavigationDrawer.kt#9igjgp");
                            zChangedInstance2 = ((i6 <= 256 && composerStartRestartGroup.changed(drawerState3)) || (i3 & 384) == 256) | composerStartRestartGroup.changedInstance(coroutineScope);
                            objRememberedValue10 = composerStartRestartGroup.rememberedValue();
                            if (!zChangedInstance2 || objRememberedValue10 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue10 = (Function1) new Function1<KeyEvent, Boolean>() { // from class: androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$3$6$1
                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Boolean invoke(KeyEvent keyEvent) {
                                        return m3874invokeZmokQxo(keyEvent.m7966unboximpl());
                                    }

                                    /* JADX INFO: renamed from: invoke-ZmokQxo, reason: not valid java name */
                                    public final Boolean m3874invokeZmokQxo(android.view.KeyEvent keyEvent) {
                                        if (drawerState3.isOpen() && KeyEventType.m7970equalsimpl0(KeyEvent_androidKt.m7978getTypeZmokQxo(keyEvent), KeyEventType.INSTANCE.m7975getKeyUpCS__XNY()) && Key.m7669equalsimpl0(KeyEvent_androidKt.m7977getKeyZmokQxo(keyEvent), Key.INSTANCE.m7758getEscapeEK5gGoQ())) {
                                            BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new AnonymousClass1(drawerState3, null), 3, null);
                                            return true;
                                        }
                                        return false;
                                    }

                                    /* JADX INFO: renamed from: androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$3$6$1$1, reason: invalid class name */
                                    /* JADX INFO: compiled from: NavigationDrawer.kt */
                                    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
                                    @DebugMetadata(c = "androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$3$6$1$1", f = "NavigationDrawer.kt", i = {}, l = {430}, m = "invokeSuspend", n = {}, s = {}, v = 1)
                                    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                        final /* synthetic */ DrawerState $drawerState;
                                        int label;

                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        AnonymousClass1(DrawerState drawerState, Continuation<? super AnonymousClass1> continuation) {
                                            super(2, continuation);
                                            this.$drawerState = drawerState;
                                        }

                                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                            return new AnonymousClass1(this.$drawerState, continuation);
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                        }

                                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                        public final Object invokeSuspend(Object obj) {
                                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                            int i = this.label;
                                            if (i == 0) {
                                                ResultKt.throwOnFailure(obj);
                                                this.label = 1;
                                                if (this.$drawerState.close(this) == coroutine_suspended) {
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
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue10);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            Modifier modifierFocusRequester = FocusRequesterModifierKt.focusRequester(KeyInputModifierKt.onKeyEvent(modifierSemantics$default, (Function1) objRememberedValue10), focusRequester);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2081565471, "CC(remember):NavigationDrawer.kt#9igjgp");
                            zChanged5 = composerStartRestartGroup.changed(mutableFloatState) | ((i6 <= 256 && composerStartRestartGroup.changed(drawerState3)) || (i3 & 384) == 256);
                            navigationDrawerKt$ModalNavigationDrawer$3$7$1RememberedValue = composerStartRestartGroup.rememberedValue();
                            if (!zChanged5 || navigationDrawerKt$ModalNavigationDrawer$3$7$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                                navigationDrawerKt$ModalNavigationDrawer$3$7$1RememberedValue = new NavigationDrawerKt$ModalNavigationDrawer$3$7$1(drawerState3, 0.0f, mutableState, mutableFloatState);
                                composerStartRestartGroup.updateRememberedValue(navigationDrawerKt$ModalNavigationDrawer$3$7$1RememberedValue);
                            }
                            MeasurePolicy measurePolicy = (MeasurePolicy) navigationDrawerKt$ModalNavigationDrawer$3$7$1RememberedValue;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            int i11 = i3 & 14;
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                            currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                            CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                            Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFocusRequester);
                            constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                            int i12 = ((i11 << 6) & 896) | 6;
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            composerStartRestartGroup.startReusableNode();
                            if (composerStartRestartGroup.getInserting()) {
                                composerStartRestartGroup.createNode(constructor3);
                            } else {
                                composerStartRestartGroup.useNode();
                            }
                            composerM6062constructorimpl3 = Updater.m6062constructorimpl(composerStartRestartGroup);
                            Updater.m6070setimpl(composerM6062constructorimpl3, measurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m6070setimpl(composerM6062constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                            setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                            if (!composerM6062constructorimpl3.getInserting() || !Intrinsics.areEqual(composerM6062constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                                composerM6062constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                                composerM6062constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                            }
                            Updater.m6070setimpl(composerM6062constructorimpl3, modifierMaterializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
                            function4 = function2;
                            function4.invoke(composerStartRestartGroup, Integer.valueOf((i12 >> 6) & 14));
                            composerStartRestartGroup.endNode();
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            composerStartRestartGroup.endNode();
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            drawerState2 = drawerState3;
                            j3 = j4;
                            z3 = z8;
                        } else {
                            drawerState3 = drawerStateRememberDrawerState;
                        }
                        z5 = true;
                        zChanged2 = z5 | composerStartRestartGroup.changed(density) | composerStartRestartGroup.changedInstance(finiteAnimationSpecValue2) | composerStartRestartGroup.changedInstance(finiteAnimationSpecValue3) | composerStartRestartGroup.changedInstance(finiteAnimationSpecValue);
                        objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged2) {
                            objRememberedValue5 = new Function0() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda2
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return NavigationDrawerKt.ModalNavigationDrawer_FHprtrg$lambda$7$0(drawerState3, density, finiteAnimationSpecValue2, finiteAnimationSpecValue3, finiteAnimationSpecValue);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                        } else {
                            objRememberedValue5 = new Function0() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda2
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return NavigationDrawerKt.ModalNavigationDrawer_FHprtrg$lambda$7$0(drawerState3, density, finiteAnimationSpecValue2, finiteAnimationSpecValue3, finiteAnimationSpecValue);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        EffectsKt.SideEffect((Function0) objRememberedValue5, composerStartRestartGroup, 0);
                        Boolean boolValueOf2 = Boolean.valueOf(drawerState3.isOpen());
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 910063410, "CC(remember):NavigationDrawer.kt#9igjgp");
                        if (i6 <= 256) {
                        }
                        navigationDrawerKt$ModalNavigationDrawer$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!z6) {
                            navigationDrawerKt$ModalNavigationDrawer$2$1RememberedValue = new NavigationDrawerKt$ModalNavigationDrawer$2$1(drawerState3, focusRequester, null);
                            composerStartRestartGroup.updateRememberedValue(navigationDrawerKt$ModalNavigationDrawer$2$1RememberedValue);
                        } else {
                            navigationDrawerKt$ModalNavigationDrawer$2$1RememberedValue = new NavigationDrawerKt$ModalNavigationDrawer$2$1(drawerState3, focusRequester, null);
                            composerStartRestartGroup.updateRememberedValue(navigationDrawerKt$ModalNavigationDrawer$2$1RememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        EffectsKt.LaunchedEffect(boolValueOf2, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) navigationDrawerKt$ModalNavigationDrawer$2$1RememberedValue, composerStartRestartGroup, 0);
                        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection2 = CompositionLocalsKt.getLocalLayoutDirection();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        objConsume = composerStartRestartGroup.consume(localLayoutDirection2);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if (objConsume == LayoutDirection.Rtl) {
                            z7 = true;
                        } else {
                            z7 = false;
                        }
                        z8 = z4;
                        Modifier modifierAnchoredDraggable$default2 = AnchoredDraggableKt.anchoredDraggable$default(SizeKt.fillMaxSize$default(companion, f, 1, null), drawerState3.getAnchoredDraggableState$material3(), z7, Orientation.Horizontal, z8, (MutableInteractionSource) null, (OverscrollEffect) null, (FlingBehavior) null, 112, (Object) null);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                        modifier3 = companion;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                        CompositionLocalMap currentCompositionLocalMap4 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierAnchoredDraggable$default2);
                        constructor = ComposeUiNode.INSTANCE.getConstructor();
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
                        composerM6062constructorimpl = Updater.m6062constructorimpl(composerStartRestartGroup);
                        Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (!composerM6062constructorimpl.getInserting()) {
                            composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        } else {
                            composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        }
                        Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier4, ComposeUiNode.INSTANCE.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 101899237, "C385@15772L17,388@15866L183,393@16074L70,386@15798L389,399@16296L601,411@16929L452,422@17414L501,435@17979L1561,396@16196L3344:NavigationDrawer.kt#uh7d8r");
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                        Modifier.Companion companion5 = Modifier.INSTANCE;
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy4 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                        currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                        CompositionLocalMap currentCompositionLocalMap5 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier5 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion5);
                        constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                        if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startReusableNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.createNode(constructor2);
                        } else {
                            composerStartRestartGroup.useNode();
                        }
                        composerM6062constructorimpl2 = Updater.m6062constructorimpl(composerStartRestartGroup);
                        Updater.m6070setimpl(composerM6062constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy4, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m6070setimpl(composerM6062constructorimpl2, currentCompositionLocalMap5, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (!composerM6062constructorimpl2.getInserting()) {
                            composerM6062constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                            composerM6062constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                        } else {
                            composerM6062constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                            composerM6062constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                        }
                        Updater.m6070setimpl(composerM6062constructorimpl2, modifierMaterializeModifier5, ComposeUiNode.INSTANCE.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance4 = BoxScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 343987054, "C385@15778L9:NavigationDrawer.kt#uh7d8r");
                        function3.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 15) & 14));
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        boolean zIsOpen2 = drawerState3.isOpen();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2081496477, "CC(remember):NavigationDrawer.kt#9igjgp");
                        if ((i3 & 7168) == 2048) {
                            z9 = true;
                        } else {
                            z9 = false;
                        }
                        zChangedInstance = z9 | ((i6 <= 256 && composerStartRestartGroup.changed(drawerState3)) || (i3 & 384) == 256) | composerStartRestartGroup.changedInstance(coroutineScope);
                        objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                        if (!zChangedInstance) {
                            objRememberedValue6 = new Function0() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda3
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return NavigationDrawerKt.ModalNavigationDrawer_FHprtrg$lambda$9$1$0(z8, drawerState3, coroutineScope);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                        } else {
                            objRememberedValue6 = new Function0() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda3
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return NavigationDrawerKt.ModalNavigationDrawer_FHprtrg$lambda$9$1$0(z8, drawerState3, coroutineScope);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                        }
                        Function0 function1 = (Function0) objRememberedValue6;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2081503020, "CC(remember):NavigationDrawer.kt#9igjgp");
                        zChanged3 = composerStartRestartGroup.changed(mutableFloatState) | ((i6 <= 256 && composerStartRestartGroup.changed(drawerState3)) || (i3 & 384) == 256);
                        objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged3) {
                            final float f3 = 0.0f;
                            objRememberedValue7 = new Function0() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda4
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return Float.valueOf(NavigationDrawerKt.ModalNavigationDrawer_FHprtrg$lambda$9$2$0(f3, drawerState3, mutableFloatState));
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                        } else {
                            final float f4 = 0.0f;
                            objRememberedValue7 = new Function0() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda4
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return Float.valueOf(NavigationDrawerKt.ModalNavigationDrawer_FHprtrg$lambda$9$2$0(f4, drawerState3, mutableFloatState));
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        m3870ScrimBx497Mc(zIsOpen2, function1, (Function0) objRememberedValue7, j4, composerStartRestartGroup, (i3 >> 3) & 7168);
                        Modifier.Companion companion6 = Modifier.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2081510655, "CC(remember):NavigationDrawer.kt#9igjgp");
                        if (i6 <= 256) {
                        }
                        objRememberedValue8 = composerStartRestartGroup.rememberedValue();
                        if (!z10) {
                            objRememberedValue8 = new Function1() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda5
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return NavigationDrawerKt.ModalNavigationDrawer_FHprtrg$lambda$9$3$0(drawerState3, (Density) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                        } else {
                            objRememberedValue8 = new Function1() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda5
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return NavigationDrawerKt.ModalNavigationDrawer_FHprtrg$lambda$9$3$0(drawerState3, (Density) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        Modifier modifierOffset2 = OffsetKt.offset(companion6, (Function1) objRememberedValue8);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2081530762, "CC(remember):NavigationDrawer.kt#9igjgp");
                        zChanged4 = composerStartRestartGroup.changed(strM5086getString2EP1pXo) | ((i6 <= 256 && composerStartRestartGroup.changed(drawerState3)) || (i3 & 384) == 256) | composerStartRestartGroup.changedInstance(coroutineScope);
                        objRememberedValue9 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged4) {
                            objRememberedValue9 = new Function1() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda6
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return NavigationDrawerKt.ModalNavigationDrawer_FHprtrg$lambda$9$4$0(strM5086getString2EP1pXo, drawerState3, coroutineScope, (SemanticsPropertyReceiver) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue9);
                        } else {
                            objRememberedValue9 = new Function1() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda6
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return NavigationDrawerKt.ModalNavigationDrawer_FHprtrg$lambda$9$4$0(strM5086getString2EP1pXo, drawerState3, coroutineScope, (SemanticsPropertyReceiver) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue9);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        Modifier modifierSemantics$default2 = SemanticsModifierKt.semantics$default(modifierOffset2, false, (Function1) objRememberedValue9, 1, null);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2081546331, "CC(remember):NavigationDrawer.kt#9igjgp");
                        zChangedInstance2 = ((i6 <= 256 && composerStartRestartGroup.changed(drawerState3)) || (i3 & 384) == 256) | composerStartRestartGroup.changedInstance(coroutineScope);
                        objRememberedValue10 = composerStartRestartGroup.rememberedValue();
                        if (!zChangedInstance2) {
                            objRememberedValue10 = (Function1) new Function1<KeyEvent, Boolean>() { // from class: androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$3$6$1
                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Boolean invoke(KeyEvent keyEvent) {
                                    return m3874invokeZmokQxo(keyEvent.m7966unboximpl());
                                }

                                /* JADX INFO: renamed from: invoke-ZmokQxo, reason: not valid java name */
                                public final Boolean m3874invokeZmokQxo(android.view.KeyEvent keyEvent) {
                                    if (drawerState3.isOpen() && KeyEventType.m7970equalsimpl0(KeyEvent_androidKt.m7978getTypeZmokQxo(keyEvent), KeyEventType.INSTANCE.m7975getKeyUpCS__XNY()) && Key.m7669equalsimpl0(KeyEvent_androidKt.m7977getKeyZmokQxo(keyEvent), Key.INSTANCE.m7758getEscapeEK5gGoQ())) {
                                        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new AnonymousClass1(drawerState3, null), 3, null);
                                        return true;
                                    }
                                    return false;
                                }

                                /* JADX INFO: renamed from: androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$3$6$1$1, reason: invalid class name */
                                /* JADX INFO: compiled from: NavigationDrawer.kt */
                                @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
                                @DebugMetadata(c = "androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$3$6$1$1", f = "NavigationDrawer.kt", i = {}, l = {430}, m = "invokeSuspend", n = {}, s = {}, v = 1)
                                static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                    final /* synthetic */ DrawerState $drawerState;
                                    int label;

                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    AnonymousClass1(DrawerState drawerState, Continuation<? super AnonymousClass1> continuation) {
                                        super(2, continuation);
                                        this.$drawerState = drawerState;
                                    }

                                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                        return new AnonymousClass1(this.$drawerState, continuation);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                        return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                    }

                                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                    public final Object invokeSuspend(Object obj) {
                                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                        int i = this.label;
                                        if (i == 0) {
                                            ResultKt.throwOnFailure(obj);
                                            this.label = 1;
                                            if (this.$drawerState.close(this) == coroutine_suspended) {
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
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue10);
                        } else {
                            objRememberedValue10 = (Function1) new Function1<KeyEvent, Boolean>() { // from class: androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$3$6$1
                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Boolean invoke(KeyEvent keyEvent) {
                                    return m3874invokeZmokQxo(keyEvent.m7966unboximpl());
                                }

                                /* JADX INFO: renamed from: invoke-ZmokQxo, reason: not valid java name */
                                public final Boolean m3874invokeZmokQxo(android.view.KeyEvent keyEvent) {
                                    if (drawerState3.isOpen() && KeyEventType.m7970equalsimpl0(KeyEvent_androidKt.m7978getTypeZmokQxo(keyEvent), KeyEventType.INSTANCE.m7975getKeyUpCS__XNY()) && Key.m7669equalsimpl0(KeyEvent_androidKt.m7977getKeyZmokQxo(keyEvent), Key.INSTANCE.m7758getEscapeEK5gGoQ())) {
                                        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new AnonymousClass1(drawerState3, null), 3, null);
                                        return true;
                                    }
                                    return false;
                                }

                                /* JADX INFO: renamed from: androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$3$6$1$1, reason: invalid class name */
                                /* JADX INFO: compiled from: NavigationDrawer.kt */
                                @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
                                @DebugMetadata(c = "androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$3$6$1$1", f = "NavigationDrawer.kt", i = {}, l = {430}, m = "invokeSuspend", n = {}, s = {}, v = 1)
                                static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                    final /* synthetic */ DrawerState $drawerState;
                                    int label;

                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    AnonymousClass1(DrawerState drawerState, Continuation<? super AnonymousClass1> continuation) {
                                        super(2, continuation);
                                        this.$drawerState = drawerState;
                                    }

                                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                        return new AnonymousClass1(this.$drawerState, continuation);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                        return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                    }

                                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                    public final Object invokeSuspend(Object obj) {
                                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                        int i = this.label;
                                        if (i == 0) {
                                            ResultKt.throwOnFailure(obj);
                                            this.label = 1;
                                            if (this.$drawerState.close(this) == coroutine_suspended) {
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
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue10);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        Modifier modifierFocusRequester2 = FocusRequesterModifierKt.focusRequester(KeyInputModifierKt.onKeyEvent(modifierSemantics$default2, (Function1) objRememberedValue10), focusRequester);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2081565471, "CC(remember):NavigationDrawer.kt#9igjgp");
                        zChanged5 = composerStartRestartGroup.changed(mutableFloatState) | ((i6 <= 256 && composerStartRestartGroup.changed(drawerState3)) || (i3 & 384) == 256);
                        navigationDrawerKt$ModalNavigationDrawer$3$7$1RememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!zChanged5) {
                            navigationDrawerKt$ModalNavigationDrawer$3$7$1RememberedValue = new NavigationDrawerKt$ModalNavigationDrawer$3$7$1(drawerState3, 0.0f, mutableState, mutableFloatState);
                            composerStartRestartGroup.updateRememberedValue(navigationDrawerKt$ModalNavigationDrawer$3$7$1RememberedValue);
                        } else {
                            navigationDrawerKt$ModalNavigationDrawer$3$7$1RememberedValue = new NavigationDrawerKt$ModalNavigationDrawer$3$7$1(drawerState3, 0.0f, mutableState, mutableFloatState);
                            composerStartRestartGroup.updateRememberedValue(navigationDrawerKt$ModalNavigationDrawer$3$7$1RememberedValue);
                        }
                        MeasurePolicy measurePolicy2 = (MeasurePolicy) navigationDrawerKt$ModalNavigationDrawer$3$7$1RememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        int i13 = i3 & 14;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                        currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                        CompositionLocalMap currentCompositionLocalMap6 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier6 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFocusRequester2);
                        constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                        int i14 = ((i13 << 6) & 896) | 6;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                        if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startReusableNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.createNode(constructor3);
                        } else {
                            composerStartRestartGroup.useNode();
                        }
                        composerM6062constructorimpl3 = Updater.m6062constructorimpl(composerStartRestartGroup);
                        Updater.m6070setimpl(composerM6062constructorimpl3, measurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m6070setimpl(composerM6062constructorimpl3, currentCompositionLocalMap6, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (!composerM6062constructorimpl3.getInserting()) {
                            composerM6062constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                            composerM6062constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                        } else {
                            composerM6062constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                            composerM6062constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                        }
                        Updater.m6070setimpl(composerM6062constructorimpl3, modifierMaterializeModifier6, ComposeUiNode.INSTANCE.getSetModifier());
                        function4 = function2;
                        function4.invoke(composerStartRestartGroup, Integer.valueOf((i14 >> 6) & 14));
                        composerStartRestartGroup.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        drawerState2 = drawerState3;
                        j3 = j4;
                        z3 = z8;
                    }
                    objRememberedValue3 = PrimitiveSnapshotStateKt.mutableFloatStateOf(f);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    mutableFloatState = (MutableFloatState) objRememberedValue3;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 910041181, "CC(remember):NavigationDrawer.kt#9igjgp");
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue4 = new FocusRequester();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    focusRequester = (FocusRequester) objRememberedValue4;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    finiteAnimationSpecValue = MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultSpatial, composerStartRestartGroup, 6);
                    long j5 = scrimColor;
                    finiteAnimationSpecValue2 = MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultSpatial, composerStartRestartGroup, 6);
                    finiteAnimationSpecValue3 = MotionSchemeKt.value(MotionSchemeKeyTokens.FastEffects, composerStartRestartGroup, 6);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 910054821, "CC(remember):NavigationDrawer.kt#9igjgp");
                    i6 = (i3 & 896) ^ 384;
                    if (i6 > 256) {
                        drawerState3 = drawerStateRememberDrawerState;
                        if ((i3 & 384) != 256) {
                            z5 = true;
                        } else {
                            z5 = false;
                        }
                    } else {
                        drawerState3 = drawerStateRememberDrawerState;
                        if ((i3 & 384) != 256) {
                            z5 = true;
                        } else {
                            z5 = false;
                        }
                    }
                    zChanged2 = z5 | composerStartRestartGroup.changed(density) | composerStartRestartGroup.changedInstance(finiteAnimationSpecValue2) | composerStartRestartGroup.changedInstance(finiteAnimationSpecValue3) | composerStartRestartGroup.changedInstance(finiteAnimationSpecValue);
                    objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged2) {
                        objRememberedValue5 = new Function0() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return NavigationDrawerKt.ModalNavigationDrawer_FHprtrg$lambda$7$0(drawerState3, density, finiteAnimationSpecValue2, finiteAnimationSpecValue3, finiteAnimationSpecValue);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                    } else {
                        objRememberedValue5 = new Function0() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return NavigationDrawerKt.ModalNavigationDrawer_FHprtrg$lambda$7$0(drawerState3, density, finiteAnimationSpecValue2, finiteAnimationSpecValue3, finiteAnimationSpecValue);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    EffectsKt.SideEffect((Function0) objRememberedValue5, composerStartRestartGroup, 0);
                    Boolean boolValueOf3 = Boolean.valueOf(drawerState3.isOpen());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 910063410, "CC(remember):NavigationDrawer.kt#9igjgp");
                    if (i6 <= 256) {
                    }
                    navigationDrawerKt$ModalNavigationDrawer$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z6) {
                        navigationDrawerKt$ModalNavigationDrawer$2$1RememberedValue = new NavigationDrawerKt$ModalNavigationDrawer$2$1(drawerState3, focusRequester, null);
                        composerStartRestartGroup.updateRememberedValue(navigationDrawerKt$ModalNavigationDrawer$2$1RememberedValue);
                    } else {
                        navigationDrawerKt$ModalNavigationDrawer$2$1RememberedValue = new NavigationDrawerKt$ModalNavigationDrawer$2$1(drawerState3, focusRequester, null);
                        composerStartRestartGroup.updateRememberedValue(navigationDrawerKt$ModalNavigationDrawer$2$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    EffectsKt.LaunchedEffect(boolValueOf3, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) navigationDrawerKt$ModalNavigationDrawer$2$1RememberedValue, composerStartRestartGroup, 0);
                    ProvidableCompositionLocal<LayoutDirection> localLayoutDirection3 = CompositionLocalsKt.getLocalLayoutDirection();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    objConsume = composerStartRestartGroup.consume(localLayoutDirection3);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (objConsume == LayoutDirection.Rtl) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                    z8 = z4;
                    Modifier modifierAnchoredDraggable$default3 = AnchoredDraggableKt.anchoredDraggable$default(SizeKt.fillMaxSize$default(companion, f, 1, null), drawerState3.getAnchoredDraggableState$material3(), z7, Orientation.Horizontal, z8, (MutableInteractionSource) null, (OverscrollEffect) null, (FlingBehavior) null, 112, (Object) null);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy5 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                    modifier3 = companion;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap7 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier7 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierAnchoredDraggable$default3);
                    constructor = ComposeUiNode.INSTANCE.getConstructor();
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
                    composerM6062constructorimpl = Updater.m6062constructorimpl(composerStartRestartGroup);
                    Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy5, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap7, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (!composerM6062constructorimpl.getInserting()) {
                        composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    } else {
                        composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier7, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance5 = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 101899237, "C385@15772L17,388@15866L183,393@16074L70,386@15798L389,399@16296L601,411@16929L452,422@17414L501,435@17979L1561,396@16196L3344:NavigationDrawer.kt#uh7d8r");
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                    Modifier.Companion companion7 = Modifier.INSTANCE;
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy6 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                    currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap8 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier8 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion7);
                    constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                    if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor2);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    composerM6062constructorimpl2 = Updater.m6062constructorimpl(composerStartRestartGroup);
                    Updater.m6070setimpl(composerM6062constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy6, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m6070setimpl(composerM6062constructorimpl2, currentCompositionLocalMap8, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (!composerM6062constructorimpl2.getInserting()) {
                        composerM6062constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                        composerM6062constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                    } else {
                        composerM6062constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                        composerM6062constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                    }
                    Updater.m6070setimpl(composerM6062constructorimpl2, modifierMaterializeModifier8, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance6 = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 343987054, "C385@15778L9:NavigationDrawer.kt#uh7d8r");
                    function3.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 15) & 14));
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    boolean zIsOpen3 = drawerState3.isOpen();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2081496477, "CC(remember):NavigationDrawer.kt#9igjgp");
                    if ((i3 & 7168) == 2048) {
                        z9 = true;
                    } else {
                        z9 = false;
                    }
                    zChangedInstance = z9 | ((i6 <= 256 && composerStartRestartGroup.changed(drawerState3)) || (i3 & 384) == 256) | composerStartRestartGroup.changedInstance(coroutineScope);
                    objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                    if (!zChangedInstance) {
                        objRememberedValue6 = new Function0() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return NavigationDrawerKt.ModalNavigationDrawer_FHprtrg$lambda$9$1$0(z8, drawerState3, coroutineScope);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                    } else {
                        objRememberedValue6 = new Function0() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return NavigationDrawerKt.ModalNavigationDrawer_FHprtrg$lambda$9$1$0(z8, drawerState3, coroutineScope);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                    }
                    Function0 function5 = (Function0) objRememberedValue6;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2081503020, "CC(remember):NavigationDrawer.kt#9igjgp");
                    zChanged3 = composerStartRestartGroup.changed(mutableFloatState) | ((i6 <= 256 && composerStartRestartGroup.changed(drawerState3)) || (i3 & 384) == 256);
                    objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged3) {
                        final float f5 = 0.0f;
                        objRememberedValue7 = new Function0() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Float.valueOf(NavigationDrawerKt.ModalNavigationDrawer_FHprtrg$lambda$9$2$0(f5, drawerState3, mutableFloatState));
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                    } else {
                        final float f6 = 0.0f;
                        objRememberedValue7 = new Function0() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Float.valueOf(NavigationDrawerKt.ModalNavigationDrawer_FHprtrg$lambda$9$2$0(f6, drawerState3, mutableFloatState));
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    m3870ScrimBx497Mc(zIsOpen3, function5, (Function0) objRememberedValue7, j5, composerStartRestartGroup, (i3 >> 3) & 7168);
                    Modifier.Companion companion8 = Modifier.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2081510655, "CC(remember):NavigationDrawer.kt#9igjgp");
                    if (i6 <= 256) {
                    }
                    objRememberedValue8 = composerStartRestartGroup.rememberedValue();
                    if (!z10) {
                        objRememberedValue8 = new Function1() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda5
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return NavigationDrawerKt.ModalNavigationDrawer_FHprtrg$lambda$9$3$0(drawerState3, (Density) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                    } else {
                        objRememberedValue8 = new Function1() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda5
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return NavigationDrawerKt.ModalNavigationDrawer_FHprtrg$lambda$9$3$0(drawerState3, (Density) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Modifier modifierOffset3 = OffsetKt.offset(companion8, (Function1) objRememberedValue8);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2081530762, "CC(remember):NavigationDrawer.kt#9igjgp");
                    zChanged4 = composerStartRestartGroup.changed(strM5086getString2EP1pXo) | ((i6 <= 256 && composerStartRestartGroup.changed(drawerState3)) || (i3 & 384) == 256) | composerStartRestartGroup.changedInstance(coroutineScope);
                    objRememberedValue9 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged4) {
                        objRememberedValue9 = new Function1() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return NavigationDrawerKt.ModalNavigationDrawer_FHprtrg$lambda$9$4$0(strM5086getString2EP1pXo, drawerState3, coroutineScope, (SemanticsPropertyReceiver) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue9);
                    } else {
                        objRememberedValue9 = new Function1() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return NavigationDrawerKt.ModalNavigationDrawer_FHprtrg$lambda$9$4$0(strM5086getString2EP1pXo, drawerState3, coroutineScope, (SemanticsPropertyReceiver) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue9);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Modifier modifierSemantics$default3 = SemanticsModifierKt.semantics$default(modifierOffset3, false, (Function1) objRememberedValue9, 1, null);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2081546331, "CC(remember):NavigationDrawer.kt#9igjgp");
                    zChangedInstance2 = ((i6 <= 256 && composerStartRestartGroup.changed(drawerState3)) || (i3 & 384) == 256) | composerStartRestartGroup.changedInstance(coroutineScope);
                    objRememberedValue10 = composerStartRestartGroup.rememberedValue();
                    if (!zChangedInstance2) {
                        objRememberedValue10 = (Function1) new Function1<KeyEvent, Boolean>() { // from class: androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$3$6$1
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Boolean invoke(KeyEvent keyEvent) {
                                return m3874invokeZmokQxo(keyEvent.m7966unboximpl());
                            }

                            /* JADX INFO: renamed from: invoke-ZmokQxo, reason: not valid java name */
                            public final Boolean m3874invokeZmokQxo(android.view.KeyEvent keyEvent) {
                                if (drawerState3.isOpen() && KeyEventType.m7970equalsimpl0(KeyEvent_androidKt.m7978getTypeZmokQxo(keyEvent), KeyEventType.INSTANCE.m7975getKeyUpCS__XNY()) && Key.m7669equalsimpl0(KeyEvent_androidKt.m7977getKeyZmokQxo(keyEvent), Key.INSTANCE.m7758getEscapeEK5gGoQ())) {
                                    BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new AnonymousClass1(drawerState3, null), 3, null);
                                    return true;
                                }
                                return false;
                            }

                            /* JADX INFO: renamed from: androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$3$6$1$1, reason: invalid class name */
                            /* JADX INFO: compiled from: NavigationDrawer.kt */
                            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
                            @DebugMetadata(c = "androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$3$6$1$1", f = "NavigationDrawer.kt", i = {}, l = {430}, m = "invokeSuspend", n = {}, s = {}, v = 1)
                            static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                final /* synthetic */ DrawerState $drawerState;
                                int label;

                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                AnonymousClass1(DrawerState drawerState, Continuation<? super AnonymousClass1> continuation) {
                                    super(2, continuation);
                                    this.$drawerState = drawerState;
                                }

                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                    return new AnonymousClass1(this.$drawerState, continuation);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                    return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                }

                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                public final Object invokeSuspend(Object obj) {
                                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                    int i = this.label;
                                    if (i == 0) {
                                        ResultKt.throwOnFailure(obj);
                                        this.label = 1;
                                        if (this.$drawerState.close(this) == coroutine_suspended) {
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
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue10);
                    } else {
                        objRememberedValue10 = (Function1) new Function1<KeyEvent, Boolean>() { // from class: androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$3$6$1
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Boolean invoke(KeyEvent keyEvent) {
                                return m3874invokeZmokQxo(keyEvent.m7966unboximpl());
                            }

                            /* JADX INFO: renamed from: invoke-ZmokQxo, reason: not valid java name */
                            public final Boolean m3874invokeZmokQxo(android.view.KeyEvent keyEvent) {
                                if (drawerState3.isOpen() && KeyEventType.m7970equalsimpl0(KeyEvent_androidKt.m7978getTypeZmokQxo(keyEvent), KeyEventType.INSTANCE.m7975getKeyUpCS__XNY()) && Key.m7669equalsimpl0(KeyEvent_androidKt.m7977getKeyZmokQxo(keyEvent), Key.INSTANCE.m7758getEscapeEK5gGoQ())) {
                                    BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new AnonymousClass1(drawerState3, null), 3, null);
                                    return true;
                                }
                                return false;
                            }

                            /* JADX INFO: renamed from: androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$3$6$1$1, reason: invalid class name */
                            /* JADX INFO: compiled from: NavigationDrawer.kt */
                            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
                            @DebugMetadata(c = "androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$3$6$1$1", f = "NavigationDrawer.kt", i = {}, l = {430}, m = "invokeSuspend", n = {}, s = {}, v = 1)
                            static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                final /* synthetic */ DrawerState $drawerState;
                                int label;

                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                AnonymousClass1(DrawerState drawerState, Continuation<? super AnonymousClass1> continuation) {
                                    super(2, continuation);
                                    this.$drawerState = drawerState;
                                }

                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                    return new AnonymousClass1(this.$drawerState, continuation);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                    return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                }

                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                public final Object invokeSuspend(Object obj) {
                                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                    int i = this.label;
                                    if (i == 0) {
                                        ResultKt.throwOnFailure(obj);
                                        this.label = 1;
                                        if (this.$drawerState.close(this) == coroutine_suspended) {
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
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue10);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Modifier modifierFocusRequester3 = FocusRequesterModifierKt.focusRequester(KeyInputModifierKt.onKeyEvent(modifierSemantics$default3, (Function1) objRememberedValue10), focusRequester);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2081565471, "CC(remember):NavigationDrawer.kt#9igjgp");
                    zChanged5 = composerStartRestartGroup.changed(mutableFloatState) | ((i6 <= 256 && composerStartRestartGroup.changed(drawerState3)) || (i3 & 384) == 256);
                    navigationDrawerKt$ModalNavigationDrawer$3$7$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!zChanged5) {
                        navigationDrawerKt$ModalNavigationDrawer$3$7$1RememberedValue = new NavigationDrawerKt$ModalNavigationDrawer$3$7$1(drawerState3, 0.0f, mutableState, mutableFloatState);
                        composerStartRestartGroup.updateRememberedValue(navigationDrawerKt$ModalNavigationDrawer$3$7$1RememberedValue);
                    } else {
                        navigationDrawerKt$ModalNavigationDrawer$3$7$1RememberedValue = new NavigationDrawerKt$ModalNavigationDrawer$3$7$1(drawerState3, 0.0f, mutableState, mutableFloatState);
                        composerStartRestartGroup.updateRememberedValue(navigationDrawerKt$ModalNavigationDrawer$3$7$1RememberedValue);
                    }
                    MeasurePolicy measurePolicy3 = (MeasurePolicy) navigationDrawerKt$ModalNavigationDrawer$3$7$1RememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    int i15 = i3 & 14;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                    currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap9 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier9 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFocusRequester3);
                    constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                    int i16 = ((i15 << 6) & 896) | 6;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                    if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor3);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    composerM6062constructorimpl3 = Updater.m6062constructorimpl(composerStartRestartGroup);
                    Updater.m6070setimpl(composerM6062constructorimpl3, measurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m6070setimpl(composerM6062constructorimpl3, currentCompositionLocalMap9, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (!composerM6062constructorimpl3.getInserting()) {
                        composerM6062constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                        composerM6062constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                    } else {
                        composerM6062constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                        composerM6062constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                    }
                    Updater.m6070setimpl(composerM6062constructorimpl3, modifierMaterializeModifier9, ComposeUiNode.INSTANCE.getSetModifier());
                    function4 = function2;
                    function4.invoke(composerStartRestartGroup, Integer.valueOf((i16 >> 6) & 14));
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    drawerState2 = drawerState3;
                    j3 = j5;
                    z3 = z8;
                } else {
                    function4 = function2;
                    composerStartRestartGroup.skipToGroupEnd();
                    z3 = z;
                    modifier3 = modifier2;
                    drawerState2 = drawerStateRememberDrawerState;
                    j3 = j2;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    final Function2<? super Composer, ? super Integer, Unit> function6 = function4;
                    final Modifier modifier4 = modifier3;
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return NavigationDrawerKt.ModalNavigationDrawer_FHprtrg$lambda$10(function6, modifier4, drawerState2, z3, j3, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 3072;
            if ((i & 24576) == 0) {
                j2 = j;
                if ((i2 & 16) == 0) {
                    i8 = 8192;
                } else {
                    i8 = 8192;
                }
                i3 |= i8;
            } else {
                j2 = j;
            }
            if ((196608 & i) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i7 = 131072;
                } else {
                    i7 = 65536;
                }
                i3 |= i7;
            }
            if ((74899 & i3) != 74898) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z2, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "341@14033L39,343@14150L10");
                if ((i & 1) != 0) {
                    if (i9 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                        drawerStateRememberDrawerState = rememberDrawerState(DrawerValue.Closed, null, composerStartRestartGroup, 6, 2);
                    }
                    if (i4 != 0) {
                        z4 = true;
                    } else {
                        z4 = z;
                    }
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                        scrimColor = DrawerDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                    } else {
                        scrimColor = j2;
                    }
                } else {
                    if (i9 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                        drawerStateRememberDrawerState = rememberDrawerState(DrawerValue.Closed, null, composerStartRestartGroup, 6, 2);
                    }
                    if (i4 != 0) {
                        z4 = true;
                    } else {
                        z4 = z;
                    }
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                        scrimColor = DrawerDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                    } else {
                        scrimColor = j2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1907430816, i3, -1, "androidx.compose.material3.ModalNavigationDrawer (NavigationDrawer.kt:345)");
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 773894976, "CC(rememberCoroutineScope)N(getContext)608@27648L68:Effects.kt#9igjgp");
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 683737348, "CC(remember):Effects.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                coroutineScope = (CoroutineScope) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Strings.Companion companion9 = Strings.INSTANCE;
                strM5086getString2EP1pXo = Strings_androidKt.m5086getString2EP1pXo(Strings.m5002constructorimpl(androidx.compose.ui.R.string.navigation_menu), composerStartRestartGroup, 0);
                ProvidableCompositionLocal<Density> localDensity2 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume3 = composerStartRestartGroup.consume(localDensity2);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                density = (Density) objConsume3;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 910036450, "CC(remember):NavigationDrawer.kt#9igjgp");
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                mutableState = (MutableState) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 910038221, "CC(remember):NavigationDrawer.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(density);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (zChanged) {
                    f = 0.0f;
                    if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    }
                    mutableFloatState = (MutableFloatState) objRememberedValue3;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 910041181, "CC(remember):NavigationDrawer.kt#9igjgp");
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue4 = new FocusRequester();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    focusRequester = (FocusRequester) objRememberedValue4;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    finiteAnimationSpecValue = MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultSpatial, composerStartRestartGroup, 6);
                    long j6 = scrimColor;
                    finiteAnimationSpecValue2 = MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultSpatial, composerStartRestartGroup, 6);
                    finiteAnimationSpecValue3 = MotionSchemeKt.value(MotionSchemeKeyTokens.FastEffects, composerStartRestartGroup, 6);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 910054821, "CC(remember):NavigationDrawer.kt#9igjgp");
                    i6 = (i3 & 896) ^ 384;
                    if (i6 > 256) {
                        drawerState3 = drawerStateRememberDrawerState;
                        if ((i3 & 384) != 256) {
                            z5 = true;
                        } else {
                            z5 = false;
                        }
                    } else {
                        drawerState3 = drawerStateRememberDrawerState;
                        if ((i3 & 384) != 256) {
                            z5 = true;
                        } else {
                            z5 = false;
                        }
                    }
                    zChanged2 = z5 | composerStartRestartGroup.changed(density) | composerStartRestartGroup.changedInstance(finiteAnimationSpecValue2) | composerStartRestartGroup.changedInstance(finiteAnimationSpecValue3) | composerStartRestartGroup.changedInstance(finiteAnimationSpecValue);
                    objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged2) {
                        objRememberedValue5 = new Function0() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return NavigationDrawerKt.ModalNavigationDrawer_FHprtrg$lambda$7$0(drawerState3, density, finiteAnimationSpecValue2, finiteAnimationSpecValue3, finiteAnimationSpecValue);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                    } else {
                        objRememberedValue5 = new Function0() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return NavigationDrawerKt.ModalNavigationDrawer_FHprtrg$lambda$7$0(drawerState3, density, finiteAnimationSpecValue2, finiteAnimationSpecValue3, finiteAnimationSpecValue);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    EffectsKt.SideEffect((Function0) objRememberedValue5, composerStartRestartGroup, 0);
                    Boolean boolValueOf4 = Boolean.valueOf(drawerState3.isOpen());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 910063410, "CC(remember):NavigationDrawer.kt#9igjgp");
                    if (i6 <= 256) {
                    }
                    navigationDrawerKt$ModalNavigationDrawer$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z6) {
                        navigationDrawerKt$ModalNavigationDrawer$2$1RememberedValue = new NavigationDrawerKt$ModalNavigationDrawer$2$1(drawerState3, focusRequester, null);
                        composerStartRestartGroup.updateRememberedValue(navigationDrawerKt$ModalNavigationDrawer$2$1RememberedValue);
                    } else {
                        navigationDrawerKt$ModalNavigationDrawer$2$1RememberedValue = new NavigationDrawerKt$ModalNavigationDrawer$2$1(drawerState3, focusRequester, null);
                        composerStartRestartGroup.updateRememberedValue(navigationDrawerKt$ModalNavigationDrawer$2$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    EffectsKt.LaunchedEffect(boolValueOf4, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) navigationDrawerKt$ModalNavigationDrawer$2$1RememberedValue, composerStartRestartGroup, 0);
                    ProvidableCompositionLocal<LayoutDirection> localLayoutDirection4 = CompositionLocalsKt.getLocalLayoutDirection();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    objConsume = composerStartRestartGroup.consume(localLayoutDirection4);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (objConsume == LayoutDirection.Rtl) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                    z8 = z4;
                    Modifier modifierAnchoredDraggable$default4 = AnchoredDraggableKt.anchoredDraggable$default(SizeKt.fillMaxSize$default(companion, f, 1, null), drawerState3.getAnchoredDraggableState$material3(), z7, Orientation.Horizontal, z8, (MutableInteractionSource) null, (OverscrollEffect) null, (FlingBehavior) null, 112, (Object) null);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy7 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                    modifier3 = companion;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap10 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier10 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierAnchoredDraggable$default4);
                    constructor = ComposeUiNode.INSTANCE.getConstructor();
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
                    composerM6062constructorimpl = Updater.m6062constructorimpl(composerStartRestartGroup);
                    Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy7, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap10, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (!composerM6062constructorimpl.getInserting()) {
                        composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    } else {
                        composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier10, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance7 = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 101899237, "C385@15772L17,388@15866L183,393@16074L70,386@15798L389,399@16296L601,411@16929L452,422@17414L501,435@17979L1561,396@16196L3344:NavigationDrawer.kt#uh7d8r");
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                    Modifier.Companion companion10 = Modifier.INSTANCE;
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy8 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                    currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap11 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier11 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion10);
                    constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                    if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor2);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    composerM6062constructorimpl2 = Updater.m6062constructorimpl(composerStartRestartGroup);
                    Updater.m6070setimpl(composerM6062constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy8, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m6070setimpl(composerM6062constructorimpl2, currentCompositionLocalMap11, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (!composerM6062constructorimpl2.getInserting()) {
                        composerM6062constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                        composerM6062constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                    } else {
                        composerM6062constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                        composerM6062constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                    }
                    Updater.m6070setimpl(composerM6062constructorimpl2, modifierMaterializeModifier11, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance8 = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 343987054, "C385@15778L9:NavigationDrawer.kt#uh7d8r");
                    function3.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 15) & 14));
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    boolean zIsOpen4 = drawerState3.isOpen();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2081496477, "CC(remember):NavigationDrawer.kt#9igjgp");
                    if ((i3 & 7168) == 2048) {
                        z9 = true;
                    } else {
                        z9 = false;
                    }
                    zChangedInstance = z9 | ((i6 <= 256 && composerStartRestartGroup.changed(drawerState3)) || (i3 & 384) == 256) | composerStartRestartGroup.changedInstance(coroutineScope);
                    objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                    if (!zChangedInstance) {
                        objRememberedValue6 = new Function0() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return NavigationDrawerKt.ModalNavigationDrawer_FHprtrg$lambda$9$1$0(z8, drawerState3, coroutineScope);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                    } else {
                        objRememberedValue6 = new Function0() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return NavigationDrawerKt.ModalNavigationDrawer_FHprtrg$lambda$9$1$0(z8, drawerState3, coroutineScope);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                    }
                    Function0 function7 = (Function0) objRememberedValue6;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2081503020, "CC(remember):NavigationDrawer.kt#9igjgp");
                    zChanged3 = composerStartRestartGroup.changed(mutableFloatState) | ((i6 <= 256 && composerStartRestartGroup.changed(drawerState3)) || (i3 & 384) == 256);
                    objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged3) {
                        final float f7 = 0.0f;
                        objRememberedValue7 = new Function0() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Float.valueOf(NavigationDrawerKt.ModalNavigationDrawer_FHprtrg$lambda$9$2$0(f7, drawerState3, mutableFloatState));
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                    } else {
                        final float f8 = 0.0f;
                        objRememberedValue7 = new Function0() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Float.valueOf(NavigationDrawerKt.ModalNavigationDrawer_FHprtrg$lambda$9$2$0(f8, drawerState3, mutableFloatState));
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    m3870ScrimBx497Mc(zIsOpen4, function7, (Function0) objRememberedValue7, j6, composerStartRestartGroup, (i3 >> 3) & 7168);
                    Modifier.Companion companion11 = Modifier.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2081510655, "CC(remember):NavigationDrawer.kt#9igjgp");
                    if (i6 <= 256) {
                    }
                    objRememberedValue8 = composerStartRestartGroup.rememberedValue();
                    if (!z10) {
                        objRememberedValue8 = new Function1() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda5
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return NavigationDrawerKt.ModalNavigationDrawer_FHprtrg$lambda$9$3$0(drawerState3, (Density) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                    } else {
                        objRememberedValue8 = new Function1() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda5
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return NavigationDrawerKt.ModalNavigationDrawer_FHprtrg$lambda$9$3$0(drawerState3, (Density) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Modifier modifierOffset4 = OffsetKt.offset(companion11, (Function1) objRememberedValue8);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2081530762, "CC(remember):NavigationDrawer.kt#9igjgp");
                    zChanged4 = composerStartRestartGroup.changed(strM5086getString2EP1pXo) | ((i6 <= 256 && composerStartRestartGroup.changed(drawerState3)) || (i3 & 384) == 256) | composerStartRestartGroup.changedInstance(coroutineScope);
                    objRememberedValue9 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged4) {
                        objRememberedValue9 = new Function1() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return NavigationDrawerKt.ModalNavigationDrawer_FHprtrg$lambda$9$4$0(strM5086getString2EP1pXo, drawerState3, coroutineScope, (SemanticsPropertyReceiver) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue9);
                    } else {
                        objRememberedValue9 = new Function1() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return NavigationDrawerKt.ModalNavigationDrawer_FHprtrg$lambda$9$4$0(strM5086getString2EP1pXo, drawerState3, coroutineScope, (SemanticsPropertyReceiver) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue9);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Modifier modifierSemantics$default4 = SemanticsModifierKt.semantics$default(modifierOffset4, false, (Function1) objRememberedValue9, 1, null);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2081546331, "CC(remember):NavigationDrawer.kt#9igjgp");
                    zChangedInstance2 = ((i6 <= 256 && composerStartRestartGroup.changed(drawerState3)) || (i3 & 384) == 256) | composerStartRestartGroup.changedInstance(coroutineScope);
                    objRememberedValue10 = composerStartRestartGroup.rememberedValue();
                    if (!zChangedInstance2) {
                        objRememberedValue10 = (Function1) new Function1<KeyEvent, Boolean>() { // from class: androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$3$6$1
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Boolean invoke(KeyEvent keyEvent) {
                                return m3874invokeZmokQxo(keyEvent.m7966unboximpl());
                            }

                            /* JADX INFO: renamed from: invoke-ZmokQxo, reason: not valid java name */
                            public final Boolean m3874invokeZmokQxo(android.view.KeyEvent keyEvent) {
                                if (drawerState3.isOpen() && KeyEventType.m7970equalsimpl0(KeyEvent_androidKt.m7978getTypeZmokQxo(keyEvent), KeyEventType.INSTANCE.m7975getKeyUpCS__XNY()) && Key.m7669equalsimpl0(KeyEvent_androidKt.m7977getKeyZmokQxo(keyEvent), Key.INSTANCE.m7758getEscapeEK5gGoQ())) {
                                    BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new AnonymousClass1(drawerState3, null), 3, null);
                                    return true;
                                }
                                return false;
                            }

                            /* JADX INFO: renamed from: androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$3$6$1$1, reason: invalid class name */
                            /* JADX INFO: compiled from: NavigationDrawer.kt */
                            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
                            @DebugMetadata(c = "androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$3$6$1$1", f = "NavigationDrawer.kt", i = {}, l = {430}, m = "invokeSuspend", n = {}, s = {}, v = 1)
                            static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                final /* synthetic */ DrawerState $drawerState;
                                int label;

                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                AnonymousClass1(DrawerState drawerState, Continuation<? super AnonymousClass1> continuation) {
                                    super(2, continuation);
                                    this.$drawerState = drawerState;
                                }

                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                    return new AnonymousClass1(this.$drawerState, continuation);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                    return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                }

                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                public final Object invokeSuspend(Object obj) {
                                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                    int i = this.label;
                                    if (i == 0) {
                                        ResultKt.throwOnFailure(obj);
                                        this.label = 1;
                                        if (this.$drawerState.close(this) == coroutine_suspended) {
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
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue10);
                    } else {
                        objRememberedValue10 = (Function1) new Function1<KeyEvent, Boolean>() { // from class: androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$3$6$1
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Boolean invoke(KeyEvent keyEvent) {
                                return m3874invokeZmokQxo(keyEvent.m7966unboximpl());
                            }

                            /* JADX INFO: renamed from: invoke-ZmokQxo, reason: not valid java name */
                            public final Boolean m3874invokeZmokQxo(android.view.KeyEvent keyEvent) {
                                if (drawerState3.isOpen() && KeyEventType.m7970equalsimpl0(KeyEvent_androidKt.m7978getTypeZmokQxo(keyEvent), KeyEventType.INSTANCE.m7975getKeyUpCS__XNY()) && Key.m7669equalsimpl0(KeyEvent_androidKt.m7977getKeyZmokQxo(keyEvent), Key.INSTANCE.m7758getEscapeEK5gGoQ())) {
                                    BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new AnonymousClass1(drawerState3, null), 3, null);
                                    return true;
                                }
                                return false;
                            }

                            /* JADX INFO: renamed from: androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$3$6$1$1, reason: invalid class name */
                            /* JADX INFO: compiled from: NavigationDrawer.kt */
                            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
                            @DebugMetadata(c = "androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$3$6$1$1", f = "NavigationDrawer.kt", i = {}, l = {430}, m = "invokeSuspend", n = {}, s = {}, v = 1)
                            static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                final /* synthetic */ DrawerState $drawerState;
                                int label;

                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                AnonymousClass1(DrawerState drawerState, Continuation<? super AnonymousClass1> continuation) {
                                    super(2, continuation);
                                    this.$drawerState = drawerState;
                                }

                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                    return new AnonymousClass1(this.$drawerState, continuation);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                    return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                }

                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                public final Object invokeSuspend(Object obj) {
                                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                    int i = this.label;
                                    if (i == 0) {
                                        ResultKt.throwOnFailure(obj);
                                        this.label = 1;
                                        if (this.$drawerState.close(this) == coroutine_suspended) {
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
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue10);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Modifier modifierFocusRequester4 = FocusRequesterModifierKt.focusRequester(KeyInputModifierKt.onKeyEvent(modifierSemantics$default4, (Function1) objRememberedValue10), focusRequester);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2081565471, "CC(remember):NavigationDrawer.kt#9igjgp");
                    zChanged5 = composerStartRestartGroup.changed(mutableFloatState) | ((i6 <= 256 && composerStartRestartGroup.changed(drawerState3)) || (i3 & 384) == 256);
                    navigationDrawerKt$ModalNavigationDrawer$3$7$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!zChanged5) {
                        navigationDrawerKt$ModalNavigationDrawer$3$7$1RememberedValue = new NavigationDrawerKt$ModalNavigationDrawer$3$7$1(drawerState3, 0.0f, mutableState, mutableFloatState);
                        composerStartRestartGroup.updateRememberedValue(navigationDrawerKt$ModalNavigationDrawer$3$7$1RememberedValue);
                    } else {
                        navigationDrawerKt$ModalNavigationDrawer$3$7$1RememberedValue = new NavigationDrawerKt$ModalNavigationDrawer$3$7$1(drawerState3, 0.0f, mutableState, mutableFloatState);
                        composerStartRestartGroup.updateRememberedValue(navigationDrawerKt$ModalNavigationDrawer$3$7$1RememberedValue);
                    }
                    MeasurePolicy measurePolicy4 = (MeasurePolicy) navigationDrawerKt$ModalNavigationDrawer$3$7$1RememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    int i17 = i3 & 14;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                    currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap12 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier12 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFocusRequester4);
                    constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                    int i18 = ((i17 << 6) & 896) | 6;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                    if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor3);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    composerM6062constructorimpl3 = Updater.m6062constructorimpl(composerStartRestartGroup);
                    Updater.m6070setimpl(composerM6062constructorimpl3, measurePolicy4, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m6070setimpl(composerM6062constructorimpl3, currentCompositionLocalMap12, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (!composerM6062constructorimpl3.getInserting()) {
                        composerM6062constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                        composerM6062constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                    } else {
                        composerM6062constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                        composerM6062constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                    }
                    Updater.m6070setimpl(composerM6062constructorimpl3, modifierMaterializeModifier12, ComposeUiNode.INSTANCE.getSetModifier());
                    function4 = function2;
                    function4.invoke(composerStartRestartGroup, Integer.valueOf((i18 >> 6) & 14));
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    drawerState2 = drawerState3;
                    j3 = j6;
                    z3 = z8;
                } else {
                    f = 0.0f;
                }
                objRememberedValue3 = PrimitiveSnapshotStateKt.mutableFloatStateOf(f);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                mutableFloatState = (MutableFloatState) objRememberedValue3;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 910041181, "CC(remember):NavigationDrawer.kt#9igjgp");
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue4 = new FocusRequester();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                focusRequester = (FocusRequester) objRememberedValue4;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                finiteAnimationSpecValue = MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultSpatial, composerStartRestartGroup, 6);
                long j7 = scrimColor;
                finiteAnimationSpecValue2 = MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultSpatial, composerStartRestartGroup, 6);
                finiteAnimationSpecValue3 = MotionSchemeKt.value(MotionSchemeKeyTokens.FastEffects, composerStartRestartGroup, 6);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 910054821, "CC(remember):NavigationDrawer.kt#9igjgp");
                i6 = (i3 & 896) ^ 384;
                if (i6 > 256) {
                    drawerState3 = drawerStateRememberDrawerState;
                    if ((i3 & 384) != 256) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                } else {
                    drawerState3 = drawerStateRememberDrawerState;
                    if ((i3 & 384) != 256) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                }
                zChanged2 = z5 | composerStartRestartGroup.changed(density) | composerStartRestartGroup.changedInstance(finiteAnimationSpecValue2) | composerStartRestartGroup.changedInstance(finiteAnimationSpecValue3) | composerStartRestartGroup.changedInstance(finiteAnimationSpecValue);
                objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                if (!zChanged2) {
                    objRememberedValue5 = new Function0() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return NavigationDrawerKt.ModalNavigationDrawer_FHprtrg$lambda$7$0(drawerState3, density, finiteAnimationSpecValue2, finiteAnimationSpecValue3, finiteAnimationSpecValue);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                } else {
                    objRememberedValue5 = new Function0() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return NavigationDrawerKt.ModalNavigationDrawer_FHprtrg$lambda$7$0(drawerState3, density, finiteAnimationSpecValue2, finiteAnimationSpecValue3, finiteAnimationSpecValue);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.SideEffect((Function0) objRememberedValue5, composerStartRestartGroup, 0);
                Boolean boolValueOf5 = Boolean.valueOf(drawerState3.isOpen());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 910063410, "CC(remember):NavigationDrawer.kt#9igjgp");
                if (i6 <= 256) {
                }
                navigationDrawerKt$ModalNavigationDrawer$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z6) {
                    navigationDrawerKt$ModalNavigationDrawer$2$1RememberedValue = new NavigationDrawerKt$ModalNavigationDrawer$2$1(drawerState3, focusRequester, null);
                    composerStartRestartGroup.updateRememberedValue(navigationDrawerKt$ModalNavigationDrawer$2$1RememberedValue);
                } else {
                    navigationDrawerKt$ModalNavigationDrawer$2$1RememberedValue = new NavigationDrawerKt$ModalNavigationDrawer$2$1(drawerState3, focusRequester, null);
                    composerStartRestartGroup.updateRememberedValue(navigationDrawerKt$ModalNavigationDrawer$2$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.LaunchedEffect(boolValueOf5, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) navigationDrawerKt$ModalNavigationDrawer$2$1RememberedValue, composerStartRestartGroup, 0);
                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection5 = CompositionLocalsKt.getLocalLayoutDirection();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                objConsume = composerStartRestartGroup.consume(localLayoutDirection5);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (objConsume == LayoutDirection.Rtl) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                z8 = z4;
                Modifier modifierAnchoredDraggable$default5 = AnchoredDraggableKt.anchoredDraggable$default(SizeKt.fillMaxSize$default(companion, f, 1, null), drawerState3.getAnchoredDraggableState$material3(), z7, Orientation.Horizontal, z8, (MutableInteractionSource) null, (OverscrollEffect) null, (FlingBehavior) null, 112, (Object) null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy9 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                modifier3 = companion;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap13 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier13 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierAnchoredDraggable$default5);
                constructor = ComposeUiNode.INSTANCE.getConstructor();
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
                composerM6062constructorimpl = Updater.m6062constructorimpl(composerStartRestartGroup);
                Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy9, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap13, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!composerM6062constructorimpl.getInserting()) {
                    composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                } else {
                    composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier13, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance9 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 101899237, "C385@15772L17,388@15866L183,393@16074L70,386@15798L389,399@16296L601,411@16929L452,422@17414L501,435@17979L1561,396@16196L3344:NavigationDrawer.kt#uh7d8r");
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                Modifier.Companion companion12 = Modifier.INSTANCE;
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy10 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap14 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier14 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion12);
                constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor2);
                } else {
                    composerStartRestartGroup.useNode();
                }
                composerM6062constructorimpl2 = Updater.m6062constructorimpl(composerStartRestartGroup);
                Updater.m6070setimpl(composerM6062constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy10, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl2, currentCompositionLocalMap14, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!composerM6062constructorimpl2.getInserting()) {
                    composerM6062constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    composerM6062constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                } else {
                    composerM6062constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    composerM6062constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                }
                Updater.m6070setimpl(composerM6062constructorimpl2, modifierMaterializeModifier14, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance10 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 343987054, "C385@15778L9:NavigationDrawer.kt#uh7d8r");
                function3.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 15) & 14));
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                boolean zIsOpen5 = drawerState3.isOpen();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2081496477, "CC(remember):NavigationDrawer.kt#9igjgp");
                if ((i3 & 7168) == 2048) {
                    z9 = true;
                } else {
                    z9 = false;
                }
                zChangedInstance = z9 | ((i6 <= 256 && composerStartRestartGroup.changed(drawerState3)) || (i3 & 384) == 256) | composerStartRestartGroup.changedInstance(coroutineScope);
                objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                if (!zChangedInstance) {
                    objRememberedValue6 = new Function0() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return NavigationDrawerKt.ModalNavigationDrawer_FHprtrg$lambda$9$1$0(z8, drawerState3, coroutineScope);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                } else {
                    objRememberedValue6 = new Function0() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return NavigationDrawerKt.ModalNavigationDrawer_FHprtrg$lambda$9$1$0(z8, drawerState3, coroutineScope);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                }
                Function0 function8 = (Function0) objRememberedValue6;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2081503020, "CC(remember):NavigationDrawer.kt#9igjgp");
                zChanged3 = composerStartRestartGroup.changed(mutableFloatState) | ((i6 <= 256 && composerStartRestartGroup.changed(drawerState3)) || (i3 & 384) == 256);
                objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                if (!zChanged3) {
                    final float f9 = 0.0f;
                    objRememberedValue7 = new Function0() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return Float.valueOf(NavigationDrawerKt.ModalNavigationDrawer_FHprtrg$lambda$9$2$0(f9, drawerState3, mutableFloatState));
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                } else {
                    final float f10 = 0.0f;
                    objRememberedValue7 = new Function0() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return Float.valueOf(NavigationDrawerKt.ModalNavigationDrawer_FHprtrg$lambda$9$2$0(f10, drawerState3, mutableFloatState));
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                m3870ScrimBx497Mc(zIsOpen5, function8, (Function0) objRememberedValue7, j7, composerStartRestartGroup, (i3 >> 3) & 7168);
                Modifier.Companion companion13 = Modifier.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2081510655, "CC(remember):NavigationDrawer.kt#9igjgp");
                if (i6 <= 256) {
                }
                objRememberedValue8 = composerStartRestartGroup.rememberedValue();
                if (!z10) {
                    objRememberedValue8 = new Function1() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return NavigationDrawerKt.ModalNavigationDrawer_FHprtrg$lambda$9$3$0(drawerState3, (Density) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                } else {
                    objRememberedValue8 = new Function1() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return NavigationDrawerKt.ModalNavigationDrawer_FHprtrg$lambda$9$3$0(drawerState3, (Density) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifierOffset5 = OffsetKt.offset(companion13, (Function1) objRememberedValue8);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2081530762, "CC(remember):NavigationDrawer.kt#9igjgp");
                zChanged4 = composerStartRestartGroup.changed(strM5086getString2EP1pXo) | ((i6 <= 256 && composerStartRestartGroup.changed(drawerState3)) || (i3 & 384) == 256) | composerStartRestartGroup.changedInstance(coroutineScope);
                objRememberedValue9 = composerStartRestartGroup.rememberedValue();
                if (!zChanged4) {
                    objRememberedValue9 = new Function1() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return NavigationDrawerKt.ModalNavigationDrawer_FHprtrg$lambda$9$4$0(strM5086getString2EP1pXo, drawerState3, coroutineScope, (SemanticsPropertyReceiver) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue9);
                } else {
                    objRememberedValue9 = new Function1() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return NavigationDrawerKt.ModalNavigationDrawer_FHprtrg$lambda$9$4$0(strM5086getString2EP1pXo, drawerState3, coroutineScope, (SemanticsPropertyReceiver) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue9);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifierSemantics$default5 = SemanticsModifierKt.semantics$default(modifierOffset5, false, (Function1) objRememberedValue9, 1, null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2081546331, "CC(remember):NavigationDrawer.kt#9igjgp");
                zChangedInstance2 = ((i6 <= 256 && composerStartRestartGroup.changed(drawerState3)) || (i3 & 384) == 256) | composerStartRestartGroup.changedInstance(coroutineScope);
                objRememberedValue10 = composerStartRestartGroup.rememberedValue();
                if (!zChangedInstance2) {
                    objRememberedValue10 = (Function1) new Function1<KeyEvent, Boolean>() { // from class: androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$3$6$1
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Boolean invoke(KeyEvent keyEvent) {
                            return m3874invokeZmokQxo(keyEvent.m7966unboximpl());
                        }

                        /* JADX INFO: renamed from: invoke-ZmokQxo, reason: not valid java name */
                        public final Boolean m3874invokeZmokQxo(android.view.KeyEvent keyEvent) {
                            if (drawerState3.isOpen() && KeyEventType.m7970equalsimpl0(KeyEvent_androidKt.m7978getTypeZmokQxo(keyEvent), KeyEventType.INSTANCE.m7975getKeyUpCS__XNY()) && Key.m7669equalsimpl0(KeyEvent_androidKt.m7977getKeyZmokQxo(keyEvent), Key.INSTANCE.m7758getEscapeEK5gGoQ())) {
                                BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new AnonymousClass1(drawerState3, null), 3, null);
                                return true;
                            }
                            return false;
                        }

                        /* JADX INFO: renamed from: androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$3$6$1$1, reason: invalid class name */
                        /* JADX INFO: compiled from: NavigationDrawer.kt */
                        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
                        @DebugMetadata(c = "androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$3$6$1$1", f = "NavigationDrawer.kt", i = {}, l = {430}, m = "invokeSuspend", n = {}, s = {}, v = 1)
                        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                            final /* synthetic */ DrawerState $drawerState;
                            int label;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            AnonymousClass1(DrawerState drawerState, Continuation<? super AnonymousClass1> continuation) {
                                super(2, continuation);
                                this.$drawerState = drawerState;
                            }

                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                return new AnonymousClass1(this.$drawerState, continuation);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                            }

                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            public final Object invokeSuspend(Object obj) {
                                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                int i = this.label;
                                if (i == 0) {
                                    ResultKt.throwOnFailure(obj);
                                    this.label = 1;
                                    if (this.$drawerState.close(this) == coroutine_suspended) {
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
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue10);
                } else {
                    objRememberedValue10 = (Function1) new Function1<KeyEvent, Boolean>() { // from class: androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$3$6$1
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Boolean invoke(KeyEvent keyEvent) {
                            return m3874invokeZmokQxo(keyEvent.m7966unboximpl());
                        }

                        /* JADX INFO: renamed from: invoke-ZmokQxo, reason: not valid java name */
                        public final Boolean m3874invokeZmokQxo(android.view.KeyEvent keyEvent) {
                            if (drawerState3.isOpen() && KeyEventType.m7970equalsimpl0(KeyEvent_androidKt.m7978getTypeZmokQxo(keyEvent), KeyEventType.INSTANCE.m7975getKeyUpCS__XNY()) && Key.m7669equalsimpl0(KeyEvent_androidKt.m7977getKeyZmokQxo(keyEvent), Key.INSTANCE.m7758getEscapeEK5gGoQ())) {
                                BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new AnonymousClass1(drawerState3, null), 3, null);
                                return true;
                            }
                            return false;
                        }

                        /* JADX INFO: renamed from: androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$3$6$1$1, reason: invalid class name */
                        /* JADX INFO: compiled from: NavigationDrawer.kt */
                        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
                        @DebugMetadata(c = "androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$3$6$1$1", f = "NavigationDrawer.kt", i = {}, l = {430}, m = "invokeSuspend", n = {}, s = {}, v = 1)
                        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                            final /* synthetic */ DrawerState $drawerState;
                            int label;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            AnonymousClass1(DrawerState drawerState, Continuation<? super AnonymousClass1> continuation) {
                                super(2, continuation);
                                this.$drawerState = drawerState;
                            }

                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                return new AnonymousClass1(this.$drawerState, continuation);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                            }

                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            public final Object invokeSuspend(Object obj) {
                                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                int i = this.label;
                                if (i == 0) {
                                    ResultKt.throwOnFailure(obj);
                                    this.label = 1;
                                    if (this.$drawerState.close(this) == coroutine_suspended) {
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
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue10);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifierFocusRequester5 = FocusRequesterModifierKt.focusRequester(KeyInputModifierKt.onKeyEvent(modifierSemantics$default5, (Function1) objRememberedValue10), focusRequester);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2081565471, "CC(remember):NavigationDrawer.kt#9igjgp");
                zChanged5 = composerStartRestartGroup.changed(mutableFloatState) | ((i6 <= 256 && composerStartRestartGroup.changed(drawerState3)) || (i3 & 384) == 256);
                navigationDrawerKt$ModalNavigationDrawer$3$7$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChanged5) {
                    navigationDrawerKt$ModalNavigationDrawer$3$7$1RememberedValue = new NavigationDrawerKt$ModalNavigationDrawer$3$7$1(drawerState3, 0.0f, mutableState, mutableFloatState);
                    composerStartRestartGroup.updateRememberedValue(navigationDrawerKt$ModalNavigationDrawer$3$7$1RememberedValue);
                } else {
                    navigationDrawerKt$ModalNavigationDrawer$3$7$1RememberedValue = new NavigationDrawerKt$ModalNavigationDrawer$3$7$1(drawerState3, 0.0f, mutableState, mutableFloatState);
                    composerStartRestartGroup.updateRememberedValue(navigationDrawerKt$ModalNavigationDrawer$3$7$1RememberedValue);
                }
                MeasurePolicy measurePolicy5 = (MeasurePolicy) navigationDrawerKt$ModalNavigationDrawer$3$7$1RememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                int i19 = i3 & 14;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap15 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier15 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFocusRequester5);
                constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                int i110 = ((i19 << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor3);
                } else {
                    composerStartRestartGroup.useNode();
                }
                composerM6062constructorimpl3 = Updater.m6062constructorimpl(composerStartRestartGroup);
                Updater.m6070setimpl(composerM6062constructorimpl3, measurePolicy5, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl3, currentCompositionLocalMap15, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!composerM6062constructorimpl3.getInserting()) {
                    composerM6062constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                    composerM6062constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                } else {
                    composerM6062constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                    composerM6062constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                }
                Updater.m6070setimpl(composerM6062constructorimpl3, modifierMaterializeModifier15, ComposeUiNode.INSTANCE.getSetModifier());
                function4 = function2;
                function4.invoke(composerStartRestartGroup, Integer.valueOf((i110 >> 6) & 14));
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                drawerState2 = drawerState3;
                j3 = j7;
                z3 = z8;
            } else {
                function4 = function2;
                composerStartRestartGroup.skipToGroupEnd();
                z3 = z;
                modifier3 = modifier2;
                drawerState2 = drawerStateRememberDrawerState;
                j3 = j2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final Function2 function9 = function4;
                final Modifier modifier5 = modifier3;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return NavigationDrawerKt.ModalNavigationDrawer_FHprtrg$lambda$10(function9, modifier5, drawerState2, z3, j3, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 48;
        modifier2 = modifier;
        if ((i & 384) == 0) {
            if ((i2 & 4) == 0) {
                drawerStateRememberDrawerState = drawerState;
                if (composerStartRestartGroup.changed(drawerStateRememberDrawerState)) {
                }
                i3 |= i10;
            } else {
                drawerStateRememberDrawerState = drawerState;
            }
            i3 |= i10;
        } else {
            drawerStateRememberDrawerState = drawerState;
        }
        i4 = i2 & 8;
        if (i4 != 0) {
            if ((i & 3072) == 0) {
                if (composerStartRestartGroup.changed(z)) {
                    i5 = 2048;
                } else {
                    i5 = 1024;
                }
                i3 |= i5;
            }
            if ((i & 24576) == 0) {
                j2 = j;
                if ((i2 & 16) == 0) {
                    i8 = 8192;
                } else {
                    i8 = 8192;
                }
                i3 |= i8;
            } else {
                j2 = j;
            }
            if ((196608 & i) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i7 = 131072;
                } else {
                    i7 = 65536;
                }
                i3 |= i7;
            }
            if ((74899 & i3) != 74898) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z2, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "341@14033L39,343@14150L10");
                if ((i & 1) != 0) {
                    if (i9 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                        drawerStateRememberDrawerState = rememberDrawerState(DrawerValue.Closed, null, composerStartRestartGroup, 6, 2);
                    }
                    if (i4 != 0) {
                        z4 = true;
                    } else {
                        z4 = z;
                    }
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                        scrimColor = DrawerDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                    } else {
                        scrimColor = j2;
                    }
                } else {
                    if (i9 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                        drawerStateRememberDrawerState = rememberDrawerState(DrawerValue.Closed, null, composerStartRestartGroup, 6, 2);
                    }
                    if (i4 != 0) {
                        z4 = true;
                    } else {
                        z4 = z;
                    }
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                        scrimColor = DrawerDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                    } else {
                        scrimColor = j2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1907430816, i3, -1, "androidx.compose.material3.ModalNavigationDrawer (NavigationDrawer.kt:345)");
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 773894976, "CC(rememberCoroutineScope)N(getContext)608@27648L68:Effects.kt#9igjgp");
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 683737348, "CC(remember):Effects.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                coroutineScope = (CoroutineScope) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Strings.Companion companion14 = Strings.INSTANCE;
                strM5086getString2EP1pXo = Strings_androidKt.m5086getString2EP1pXo(Strings.m5002constructorimpl(androidx.compose.ui.R.string.navigation_menu), composerStartRestartGroup, 0);
                ProvidableCompositionLocal<Density> localDensity3 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume4 = composerStartRestartGroup.consume(localDensity3);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                density = (Density) objConsume4;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 910036450, "CC(remember):NavigationDrawer.kt#9igjgp");
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                mutableState = (MutableState) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 910038221, "CC(remember):NavigationDrawer.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(density);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (zChanged) {
                    f = 0.0f;
                    if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    }
                    mutableFloatState = (MutableFloatState) objRememberedValue3;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 910041181, "CC(remember):NavigationDrawer.kt#9igjgp");
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue4 = new FocusRequester();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    focusRequester = (FocusRequester) objRememberedValue4;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    finiteAnimationSpecValue = MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultSpatial, composerStartRestartGroup, 6);
                    long j8 = scrimColor;
                    finiteAnimationSpecValue2 = MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultSpatial, composerStartRestartGroup, 6);
                    finiteAnimationSpecValue3 = MotionSchemeKt.value(MotionSchemeKeyTokens.FastEffects, composerStartRestartGroup, 6);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 910054821, "CC(remember):NavigationDrawer.kt#9igjgp");
                    i6 = (i3 & 896) ^ 384;
                    if (i6 > 256) {
                        drawerState3 = drawerStateRememberDrawerState;
                        if ((i3 & 384) != 256) {
                            z5 = true;
                        } else {
                            z5 = false;
                        }
                    } else {
                        drawerState3 = drawerStateRememberDrawerState;
                        if ((i3 & 384) != 256) {
                            z5 = true;
                        } else {
                            z5 = false;
                        }
                    }
                    zChanged2 = z5 | composerStartRestartGroup.changed(density) | composerStartRestartGroup.changedInstance(finiteAnimationSpecValue2) | composerStartRestartGroup.changedInstance(finiteAnimationSpecValue3) | composerStartRestartGroup.changedInstance(finiteAnimationSpecValue);
                    objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged2) {
                        objRememberedValue5 = new Function0() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return NavigationDrawerKt.ModalNavigationDrawer_FHprtrg$lambda$7$0(drawerState3, density, finiteAnimationSpecValue2, finiteAnimationSpecValue3, finiteAnimationSpecValue);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                    } else {
                        objRememberedValue5 = new Function0() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return NavigationDrawerKt.ModalNavigationDrawer_FHprtrg$lambda$7$0(drawerState3, density, finiteAnimationSpecValue2, finiteAnimationSpecValue3, finiteAnimationSpecValue);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    EffectsKt.SideEffect((Function0) objRememberedValue5, composerStartRestartGroup, 0);
                    Boolean boolValueOf6 = Boolean.valueOf(drawerState3.isOpen());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 910063410, "CC(remember):NavigationDrawer.kt#9igjgp");
                    if (i6 <= 256) {
                    }
                    navigationDrawerKt$ModalNavigationDrawer$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z6) {
                        navigationDrawerKt$ModalNavigationDrawer$2$1RememberedValue = new NavigationDrawerKt$ModalNavigationDrawer$2$1(drawerState3, focusRequester, null);
                        composerStartRestartGroup.updateRememberedValue(navigationDrawerKt$ModalNavigationDrawer$2$1RememberedValue);
                    } else {
                        navigationDrawerKt$ModalNavigationDrawer$2$1RememberedValue = new NavigationDrawerKt$ModalNavigationDrawer$2$1(drawerState3, focusRequester, null);
                        composerStartRestartGroup.updateRememberedValue(navigationDrawerKt$ModalNavigationDrawer$2$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    EffectsKt.LaunchedEffect(boolValueOf6, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) navigationDrawerKt$ModalNavigationDrawer$2$1RememberedValue, composerStartRestartGroup, 0);
                    ProvidableCompositionLocal<LayoutDirection> localLayoutDirection6 = CompositionLocalsKt.getLocalLayoutDirection();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    objConsume = composerStartRestartGroup.consume(localLayoutDirection6);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (objConsume == LayoutDirection.Rtl) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                    z8 = z4;
                    Modifier modifierAnchoredDraggable$default6 = AnchoredDraggableKt.anchoredDraggable$default(SizeKt.fillMaxSize$default(companion, f, 1, null), drawerState3.getAnchoredDraggableState$material3(), z7, Orientation.Horizontal, z8, (MutableInteractionSource) null, (OverscrollEffect) null, (FlingBehavior) null, 112, (Object) null);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy11 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                    modifier3 = companion;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap16 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier16 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierAnchoredDraggable$default6);
                    constructor = ComposeUiNode.INSTANCE.getConstructor();
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
                    composerM6062constructorimpl = Updater.m6062constructorimpl(composerStartRestartGroup);
                    Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy11, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap16, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (!composerM6062constructorimpl.getInserting()) {
                        composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    } else {
                        composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier16, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance11 = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 101899237, "C385@15772L17,388@15866L183,393@16074L70,386@15798L389,399@16296L601,411@16929L452,422@17414L501,435@17979L1561,396@16196L3344:NavigationDrawer.kt#uh7d8r");
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                    Modifier.Companion companion15 = Modifier.INSTANCE;
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy12 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                    currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap17 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier17 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion15);
                    constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                    if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor2);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    composerM6062constructorimpl2 = Updater.m6062constructorimpl(composerStartRestartGroup);
                    Updater.m6070setimpl(composerM6062constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy12, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m6070setimpl(composerM6062constructorimpl2, currentCompositionLocalMap17, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (!composerM6062constructorimpl2.getInserting()) {
                        composerM6062constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                        composerM6062constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                    } else {
                        composerM6062constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                        composerM6062constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                    }
                    Updater.m6070setimpl(composerM6062constructorimpl2, modifierMaterializeModifier17, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance12 = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 343987054, "C385@15778L9:NavigationDrawer.kt#uh7d8r");
                    function3.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 15) & 14));
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    boolean zIsOpen6 = drawerState3.isOpen();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2081496477, "CC(remember):NavigationDrawer.kt#9igjgp");
                    if ((i3 & 7168) == 2048) {
                        z9 = true;
                    } else {
                        z9 = false;
                    }
                    zChangedInstance = z9 | ((i6 <= 256 && composerStartRestartGroup.changed(drawerState3)) || (i3 & 384) == 256) | composerStartRestartGroup.changedInstance(coroutineScope);
                    objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                    if (!zChangedInstance) {
                        objRememberedValue6 = new Function0() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return NavigationDrawerKt.ModalNavigationDrawer_FHprtrg$lambda$9$1$0(z8, drawerState3, coroutineScope);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                    } else {
                        objRememberedValue6 = new Function0() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return NavigationDrawerKt.ModalNavigationDrawer_FHprtrg$lambda$9$1$0(z8, drawerState3, coroutineScope);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                    }
                    Function0 function10 = (Function0) objRememberedValue6;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2081503020, "CC(remember):NavigationDrawer.kt#9igjgp");
                    zChanged3 = composerStartRestartGroup.changed(mutableFloatState) | ((i6 <= 256 && composerStartRestartGroup.changed(drawerState3)) || (i3 & 384) == 256);
                    objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged3) {
                        final float f11 = 0.0f;
                        objRememberedValue7 = new Function0() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Float.valueOf(NavigationDrawerKt.ModalNavigationDrawer_FHprtrg$lambda$9$2$0(f11, drawerState3, mutableFloatState));
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                    } else {
                        final float f12 = 0.0f;
                        objRememberedValue7 = new Function0() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Float.valueOf(NavigationDrawerKt.ModalNavigationDrawer_FHprtrg$lambda$9$2$0(f12, drawerState3, mutableFloatState));
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    m3870ScrimBx497Mc(zIsOpen6, function10, (Function0) objRememberedValue7, j8, composerStartRestartGroup, (i3 >> 3) & 7168);
                    Modifier.Companion companion16 = Modifier.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2081510655, "CC(remember):NavigationDrawer.kt#9igjgp");
                    if (i6 <= 256) {
                    }
                    objRememberedValue8 = composerStartRestartGroup.rememberedValue();
                    if (!z10) {
                        objRememberedValue8 = new Function1() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda5
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return NavigationDrawerKt.ModalNavigationDrawer_FHprtrg$lambda$9$3$0(drawerState3, (Density) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                    } else {
                        objRememberedValue8 = new Function1() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda5
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return NavigationDrawerKt.ModalNavigationDrawer_FHprtrg$lambda$9$3$0(drawerState3, (Density) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Modifier modifierOffset6 = OffsetKt.offset(companion16, (Function1) objRememberedValue8);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2081530762, "CC(remember):NavigationDrawer.kt#9igjgp");
                    zChanged4 = composerStartRestartGroup.changed(strM5086getString2EP1pXo) | ((i6 <= 256 && composerStartRestartGroup.changed(drawerState3)) || (i3 & 384) == 256) | composerStartRestartGroup.changedInstance(coroutineScope);
                    objRememberedValue9 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged4) {
                        objRememberedValue9 = new Function1() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return NavigationDrawerKt.ModalNavigationDrawer_FHprtrg$lambda$9$4$0(strM5086getString2EP1pXo, drawerState3, coroutineScope, (SemanticsPropertyReceiver) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue9);
                    } else {
                        objRememberedValue9 = new Function1() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return NavigationDrawerKt.ModalNavigationDrawer_FHprtrg$lambda$9$4$0(strM5086getString2EP1pXo, drawerState3, coroutineScope, (SemanticsPropertyReceiver) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue9);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Modifier modifierSemantics$default6 = SemanticsModifierKt.semantics$default(modifierOffset6, false, (Function1) objRememberedValue9, 1, null);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2081546331, "CC(remember):NavigationDrawer.kt#9igjgp");
                    zChangedInstance2 = ((i6 <= 256 && composerStartRestartGroup.changed(drawerState3)) || (i3 & 384) == 256) | composerStartRestartGroup.changedInstance(coroutineScope);
                    objRememberedValue10 = composerStartRestartGroup.rememberedValue();
                    if (!zChangedInstance2) {
                        objRememberedValue10 = (Function1) new Function1<KeyEvent, Boolean>() { // from class: androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$3$6$1
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Boolean invoke(KeyEvent keyEvent) {
                                return m3874invokeZmokQxo(keyEvent.m7966unboximpl());
                            }

                            /* JADX INFO: renamed from: invoke-ZmokQxo, reason: not valid java name */
                            public final Boolean m3874invokeZmokQxo(android.view.KeyEvent keyEvent) {
                                if (drawerState3.isOpen() && KeyEventType.m7970equalsimpl0(KeyEvent_androidKt.m7978getTypeZmokQxo(keyEvent), KeyEventType.INSTANCE.m7975getKeyUpCS__XNY()) && Key.m7669equalsimpl0(KeyEvent_androidKt.m7977getKeyZmokQxo(keyEvent), Key.INSTANCE.m7758getEscapeEK5gGoQ())) {
                                    BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new AnonymousClass1(drawerState3, null), 3, null);
                                    return true;
                                }
                                return false;
                            }

                            /* JADX INFO: renamed from: androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$3$6$1$1, reason: invalid class name */
                            /* JADX INFO: compiled from: NavigationDrawer.kt */
                            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
                            @DebugMetadata(c = "androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$3$6$1$1", f = "NavigationDrawer.kt", i = {}, l = {430}, m = "invokeSuspend", n = {}, s = {}, v = 1)
                            static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                final /* synthetic */ DrawerState $drawerState;
                                int label;

                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                AnonymousClass1(DrawerState drawerState, Continuation<? super AnonymousClass1> continuation) {
                                    super(2, continuation);
                                    this.$drawerState = drawerState;
                                }

                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                    return new AnonymousClass1(this.$drawerState, continuation);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                    return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                }

                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                public final Object invokeSuspend(Object obj) {
                                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                    int i = this.label;
                                    if (i == 0) {
                                        ResultKt.throwOnFailure(obj);
                                        this.label = 1;
                                        if (this.$drawerState.close(this) == coroutine_suspended) {
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
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue10);
                    } else {
                        objRememberedValue10 = (Function1) new Function1<KeyEvent, Boolean>() { // from class: androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$3$6$1
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Boolean invoke(KeyEvent keyEvent) {
                                return m3874invokeZmokQxo(keyEvent.m7966unboximpl());
                            }

                            /* JADX INFO: renamed from: invoke-ZmokQxo, reason: not valid java name */
                            public final Boolean m3874invokeZmokQxo(android.view.KeyEvent keyEvent) {
                                if (drawerState3.isOpen() && KeyEventType.m7970equalsimpl0(KeyEvent_androidKt.m7978getTypeZmokQxo(keyEvent), KeyEventType.INSTANCE.m7975getKeyUpCS__XNY()) && Key.m7669equalsimpl0(KeyEvent_androidKt.m7977getKeyZmokQxo(keyEvent), Key.INSTANCE.m7758getEscapeEK5gGoQ())) {
                                    BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new AnonymousClass1(drawerState3, null), 3, null);
                                    return true;
                                }
                                return false;
                            }

                            /* JADX INFO: renamed from: androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$3$6$1$1, reason: invalid class name */
                            /* JADX INFO: compiled from: NavigationDrawer.kt */
                            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
                            @DebugMetadata(c = "androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$3$6$1$1", f = "NavigationDrawer.kt", i = {}, l = {430}, m = "invokeSuspend", n = {}, s = {}, v = 1)
                            static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                final /* synthetic */ DrawerState $drawerState;
                                int label;

                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                AnonymousClass1(DrawerState drawerState, Continuation<? super AnonymousClass1> continuation) {
                                    super(2, continuation);
                                    this.$drawerState = drawerState;
                                }

                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                    return new AnonymousClass1(this.$drawerState, continuation);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                    return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                }

                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                public final Object invokeSuspend(Object obj) {
                                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                    int i = this.label;
                                    if (i == 0) {
                                        ResultKt.throwOnFailure(obj);
                                        this.label = 1;
                                        if (this.$drawerState.close(this) == coroutine_suspended) {
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
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue10);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Modifier modifierFocusRequester6 = FocusRequesterModifierKt.focusRequester(KeyInputModifierKt.onKeyEvent(modifierSemantics$default6, (Function1) objRememberedValue10), focusRequester);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2081565471, "CC(remember):NavigationDrawer.kt#9igjgp");
                    zChanged5 = composerStartRestartGroup.changed(mutableFloatState) | ((i6 <= 256 && composerStartRestartGroup.changed(drawerState3)) || (i3 & 384) == 256);
                    navigationDrawerKt$ModalNavigationDrawer$3$7$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!zChanged5) {
                        navigationDrawerKt$ModalNavigationDrawer$3$7$1RememberedValue = new NavigationDrawerKt$ModalNavigationDrawer$3$7$1(drawerState3, 0.0f, mutableState, mutableFloatState);
                        composerStartRestartGroup.updateRememberedValue(navigationDrawerKt$ModalNavigationDrawer$3$7$1RememberedValue);
                    } else {
                        navigationDrawerKt$ModalNavigationDrawer$3$7$1RememberedValue = new NavigationDrawerKt$ModalNavigationDrawer$3$7$1(drawerState3, 0.0f, mutableState, mutableFloatState);
                        composerStartRestartGroup.updateRememberedValue(navigationDrawerKt$ModalNavigationDrawer$3$7$1RememberedValue);
                    }
                    MeasurePolicy measurePolicy6 = (MeasurePolicy) navigationDrawerKt$ModalNavigationDrawer$3$7$1RememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    int i111 = i3 & 14;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                    currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap18 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier18 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFocusRequester6);
                    constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                    int i112 = ((i111 << 6) & 896) | 6;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                    if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor3);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    composerM6062constructorimpl3 = Updater.m6062constructorimpl(composerStartRestartGroup);
                    Updater.m6070setimpl(composerM6062constructorimpl3, measurePolicy6, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m6070setimpl(composerM6062constructorimpl3, currentCompositionLocalMap18, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (!composerM6062constructorimpl3.getInserting()) {
                        composerM6062constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                        composerM6062constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                    } else {
                        composerM6062constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                        composerM6062constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                    }
                    Updater.m6070setimpl(composerM6062constructorimpl3, modifierMaterializeModifier18, ComposeUiNode.INSTANCE.getSetModifier());
                    function4 = function2;
                    function4.invoke(composerStartRestartGroup, Integer.valueOf((i112 >> 6) & 14));
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    drawerState2 = drawerState3;
                    j3 = j8;
                    z3 = z8;
                } else {
                    f = 0.0f;
                }
                objRememberedValue3 = PrimitiveSnapshotStateKt.mutableFloatStateOf(f);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                mutableFloatState = (MutableFloatState) objRememberedValue3;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 910041181, "CC(remember):NavigationDrawer.kt#9igjgp");
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue4 = new FocusRequester();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                focusRequester = (FocusRequester) objRememberedValue4;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                finiteAnimationSpecValue = MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultSpatial, composerStartRestartGroup, 6);
                long j9 = scrimColor;
                finiteAnimationSpecValue2 = MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultSpatial, composerStartRestartGroup, 6);
                finiteAnimationSpecValue3 = MotionSchemeKt.value(MotionSchemeKeyTokens.FastEffects, composerStartRestartGroup, 6);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 910054821, "CC(remember):NavigationDrawer.kt#9igjgp");
                i6 = (i3 & 896) ^ 384;
                if (i6 > 256) {
                    drawerState3 = drawerStateRememberDrawerState;
                    if ((i3 & 384) != 256) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                } else {
                    drawerState3 = drawerStateRememberDrawerState;
                    if ((i3 & 384) != 256) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                }
                zChanged2 = z5 | composerStartRestartGroup.changed(density) | composerStartRestartGroup.changedInstance(finiteAnimationSpecValue2) | composerStartRestartGroup.changedInstance(finiteAnimationSpecValue3) | composerStartRestartGroup.changedInstance(finiteAnimationSpecValue);
                objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                if (!zChanged2) {
                    objRememberedValue5 = new Function0() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return NavigationDrawerKt.ModalNavigationDrawer_FHprtrg$lambda$7$0(drawerState3, density, finiteAnimationSpecValue2, finiteAnimationSpecValue3, finiteAnimationSpecValue);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                } else {
                    objRememberedValue5 = new Function0() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return NavigationDrawerKt.ModalNavigationDrawer_FHprtrg$lambda$7$0(drawerState3, density, finiteAnimationSpecValue2, finiteAnimationSpecValue3, finiteAnimationSpecValue);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.SideEffect((Function0) objRememberedValue5, composerStartRestartGroup, 0);
                Boolean boolValueOf7 = Boolean.valueOf(drawerState3.isOpen());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 910063410, "CC(remember):NavigationDrawer.kt#9igjgp");
                if (i6 <= 256) {
                }
                navigationDrawerKt$ModalNavigationDrawer$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z6) {
                    navigationDrawerKt$ModalNavigationDrawer$2$1RememberedValue = new NavigationDrawerKt$ModalNavigationDrawer$2$1(drawerState3, focusRequester, null);
                    composerStartRestartGroup.updateRememberedValue(navigationDrawerKt$ModalNavigationDrawer$2$1RememberedValue);
                } else {
                    navigationDrawerKt$ModalNavigationDrawer$2$1RememberedValue = new NavigationDrawerKt$ModalNavigationDrawer$2$1(drawerState3, focusRequester, null);
                    composerStartRestartGroup.updateRememberedValue(navigationDrawerKt$ModalNavigationDrawer$2$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.LaunchedEffect(boolValueOf7, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) navigationDrawerKt$ModalNavigationDrawer$2$1RememberedValue, composerStartRestartGroup, 0);
                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection7 = CompositionLocalsKt.getLocalLayoutDirection();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                objConsume = composerStartRestartGroup.consume(localLayoutDirection7);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (objConsume == LayoutDirection.Rtl) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                z8 = z4;
                Modifier modifierAnchoredDraggable$default7 = AnchoredDraggableKt.anchoredDraggable$default(SizeKt.fillMaxSize$default(companion, f, 1, null), drawerState3.getAnchoredDraggableState$material3(), z7, Orientation.Horizontal, z8, (MutableInteractionSource) null, (OverscrollEffect) null, (FlingBehavior) null, 112, (Object) null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy13 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                modifier3 = companion;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap19 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier19 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierAnchoredDraggable$default7);
                constructor = ComposeUiNode.INSTANCE.getConstructor();
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
                composerM6062constructorimpl = Updater.m6062constructorimpl(composerStartRestartGroup);
                Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy13, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap19, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!composerM6062constructorimpl.getInserting()) {
                    composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                } else {
                    composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier19, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance13 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 101899237, "C385@15772L17,388@15866L183,393@16074L70,386@15798L389,399@16296L601,411@16929L452,422@17414L501,435@17979L1561,396@16196L3344:NavigationDrawer.kt#uh7d8r");
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                Modifier.Companion companion17 = Modifier.INSTANCE;
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy14 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap110 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier110 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion17);
                constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor2);
                } else {
                    composerStartRestartGroup.useNode();
                }
                composerM6062constructorimpl2 = Updater.m6062constructorimpl(composerStartRestartGroup);
                Updater.m6070setimpl(composerM6062constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy14, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl2, currentCompositionLocalMap110, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!composerM6062constructorimpl2.getInserting()) {
                    composerM6062constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    composerM6062constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                } else {
                    composerM6062constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    composerM6062constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                }
                Updater.m6070setimpl(composerM6062constructorimpl2, modifierMaterializeModifier110, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance14 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 343987054, "C385@15778L9:NavigationDrawer.kt#uh7d8r");
                function3.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 15) & 14));
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                boolean zIsOpen7 = drawerState3.isOpen();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2081496477, "CC(remember):NavigationDrawer.kt#9igjgp");
                if ((i3 & 7168) == 2048) {
                    z9 = true;
                } else {
                    z9 = false;
                }
                zChangedInstance = z9 | ((i6 <= 256 && composerStartRestartGroup.changed(drawerState3)) || (i3 & 384) == 256) | composerStartRestartGroup.changedInstance(coroutineScope);
                objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                if (!zChangedInstance) {
                    objRememberedValue6 = new Function0() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return NavigationDrawerKt.ModalNavigationDrawer_FHprtrg$lambda$9$1$0(z8, drawerState3, coroutineScope);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                } else {
                    objRememberedValue6 = new Function0() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return NavigationDrawerKt.ModalNavigationDrawer_FHprtrg$lambda$9$1$0(z8, drawerState3, coroutineScope);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                }
                Function0 function11 = (Function0) objRememberedValue6;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2081503020, "CC(remember):NavigationDrawer.kt#9igjgp");
                zChanged3 = composerStartRestartGroup.changed(mutableFloatState) | ((i6 <= 256 && composerStartRestartGroup.changed(drawerState3)) || (i3 & 384) == 256);
                objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                if (!zChanged3) {
                    final float f13 = 0.0f;
                    objRememberedValue7 = new Function0() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return Float.valueOf(NavigationDrawerKt.ModalNavigationDrawer_FHprtrg$lambda$9$2$0(f13, drawerState3, mutableFloatState));
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                } else {
                    final float f14 = 0.0f;
                    objRememberedValue7 = new Function0() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return Float.valueOf(NavigationDrawerKt.ModalNavigationDrawer_FHprtrg$lambda$9$2$0(f14, drawerState3, mutableFloatState));
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                m3870ScrimBx497Mc(zIsOpen7, function11, (Function0) objRememberedValue7, j9, composerStartRestartGroup, (i3 >> 3) & 7168);
                Modifier.Companion companion18 = Modifier.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2081510655, "CC(remember):NavigationDrawer.kt#9igjgp");
                if (i6 <= 256) {
                }
                objRememberedValue8 = composerStartRestartGroup.rememberedValue();
                if (!z10) {
                    objRememberedValue8 = new Function1() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return NavigationDrawerKt.ModalNavigationDrawer_FHprtrg$lambda$9$3$0(drawerState3, (Density) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                } else {
                    objRememberedValue8 = new Function1() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return NavigationDrawerKt.ModalNavigationDrawer_FHprtrg$lambda$9$3$0(drawerState3, (Density) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifierOffset7 = OffsetKt.offset(companion18, (Function1) objRememberedValue8);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2081530762, "CC(remember):NavigationDrawer.kt#9igjgp");
                zChanged4 = composerStartRestartGroup.changed(strM5086getString2EP1pXo) | ((i6 <= 256 && composerStartRestartGroup.changed(drawerState3)) || (i3 & 384) == 256) | composerStartRestartGroup.changedInstance(coroutineScope);
                objRememberedValue9 = composerStartRestartGroup.rememberedValue();
                if (!zChanged4) {
                    objRememberedValue9 = new Function1() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return NavigationDrawerKt.ModalNavigationDrawer_FHprtrg$lambda$9$4$0(strM5086getString2EP1pXo, drawerState3, coroutineScope, (SemanticsPropertyReceiver) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue9);
                } else {
                    objRememberedValue9 = new Function1() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return NavigationDrawerKt.ModalNavigationDrawer_FHprtrg$lambda$9$4$0(strM5086getString2EP1pXo, drawerState3, coroutineScope, (SemanticsPropertyReceiver) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue9);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifierSemantics$default7 = SemanticsModifierKt.semantics$default(modifierOffset7, false, (Function1) objRememberedValue9, 1, null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2081546331, "CC(remember):NavigationDrawer.kt#9igjgp");
                zChangedInstance2 = ((i6 <= 256 && composerStartRestartGroup.changed(drawerState3)) || (i3 & 384) == 256) | composerStartRestartGroup.changedInstance(coroutineScope);
                objRememberedValue10 = composerStartRestartGroup.rememberedValue();
                if (!zChangedInstance2) {
                    objRememberedValue10 = (Function1) new Function1<KeyEvent, Boolean>() { // from class: androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$3$6$1
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Boolean invoke(KeyEvent keyEvent) {
                            return m3874invokeZmokQxo(keyEvent.m7966unboximpl());
                        }

                        /* JADX INFO: renamed from: invoke-ZmokQxo, reason: not valid java name */
                        public final Boolean m3874invokeZmokQxo(android.view.KeyEvent keyEvent) {
                            if (drawerState3.isOpen() && KeyEventType.m7970equalsimpl0(KeyEvent_androidKt.m7978getTypeZmokQxo(keyEvent), KeyEventType.INSTANCE.m7975getKeyUpCS__XNY()) && Key.m7669equalsimpl0(KeyEvent_androidKt.m7977getKeyZmokQxo(keyEvent), Key.INSTANCE.m7758getEscapeEK5gGoQ())) {
                                BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new AnonymousClass1(drawerState3, null), 3, null);
                                return true;
                            }
                            return false;
                        }

                        /* JADX INFO: renamed from: androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$3$6$1$1, reason: invalid class name */
                        /* JADX INFO: compiled from: NavigationDrawer.kt */
                        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
                        @DebugMetadata(c = "androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$3$6$1$1", f = "NavigationDrawer.kt", i = {}, l = {430}, m = "invokeSuspend", n = {}, s = {}, v = 1)
                        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                            final /* synthetic */ DrawerState $drawerState;
                            int label;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            AnonymousClass1(DrawerState drawerState, Continuation<? super AnonymousClass1> continuation) {
                                super(2, continuation);
                                this.$drawerState = drawerState;
                            }

                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                return new AnonymousClass1(this.$drawerState, continuation);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                            }

                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            public final Object invokeSuspend(Object obj) {
                                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                int i = this.label;
                                if (i == 0) {
                                    ResultKt.throwOnFailure(obj);
                                    this.label = 1;
                                    if (this.$drawerState.close(this) == coroutine_suspended) {
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
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue10);
                } else {
                    objRememberedValue10 = (Function1) new Function1<KeyEvent, Boolean>() { // from class: androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$3$6$1
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Boolean invoke(KeyEvent keyEvent) {
                            return m3874invokeZmokQxo(keyEvent.m7966unboximpl());
                        }

                        /* JADX INFO: renamed from: invoke-ZmokQxo, reason: not valid java name */
                        public final Boolean m3874invokeZmokQxo(android.view.KeyEvent keyEvent) {
                            if (drawerState3.isOpen() && KeyEventType.m7970equalsimpl0(KeyEvent_androidKt.m7978getTypeZmokQxo(keyEvent), KeyEventType.INSTANCE.m7975getKeyUpCS__XNY()) && Key.m7669equalsimpl0(KeyEvent_androidKt.m7977getKeyZmokQxo(keyEvent), Key.INSTANCE.m7758getEscapeEK5gGoQ())) {
                                BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new AnonymousClass1(drawerState3, null), 3, null);
                                return true;
                            }
                            return false;
                        }

                        /* JADX INFO: renamed from: androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$3$6$1$1, reason: invalid class name */
                        /* JADX INFO: compiled from: NavigationDrawer.kt */
                        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
                        @DebugMetadata(c = "androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$3$6$1$1", f = "NavigationDrawer.kt", i = {}, l = {430}, m = "invokeSuspend", n = {}, s = {}, v = 1)
                        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                            final /* synthetic */ DrawerState $drawerState;
                            int label;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            AnonymousClass1(DrawerState drawerState, Continuation<? super AnonymousClass1> continuation) {
                                super(2, continuation);
                                this.$drawerState = drawerState;
                            }

                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                return new AnonymousClass1(this.$drawerState, continuation);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                            }

                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            public final Object invokeSuspend(Object obj) {
                                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                int i = this.label;
                                if (i == 0) {
                                    ResultKt.throwOnFailure(obj);
                                    this.label = 1;
                                    if (this.$drawerState.close(this) == coroutine_suspended) {
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
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue10);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifierFocusRequester7 = FocusRequesterModifierKt.focusRequester(KeyInputModifierKt.onKeyEvent(modifierSemantics$default7, (Function1) objRememberedValue10), focusRequester);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2081565471, "CC(remember):NavigationDrawer.kt#9igjgp");
                zChanged5 = composerStartRestartGroup.changed(mutableFloatState) | ((i6 <= 256 && composerStartRestartGroup.changed(drawerState3)) || (i3 & 384) == 256);
                navigationDrawerKt$ModalNavigationDrawer$3$7$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChanged5) {
                    navigationDrawerKt$ModalNavigationDrawer$3$7$1RememberedValue = new NavigationDrawerKt$ModalNavigationDrawer$3$7$1(drawerState3, 0.0f, mutableState, mutableFloatState);
                    composerStartRestartGroup.updateRememberedValue(navigationDrawerKt$ModalNavigationDrawer$3$7$1RememberedValue);
                } else {
                    navigationDrawerKt$ModalNavigationDrawer$3$7$1RememberedValue = new NavigationDrawerKt$ModalNavigationDrawer$3$7$1(drawerState3, 0.0f, mutableState, mutableFloatState);
                    composerStartRestartGroup.updateRememberedValue(navigationDrawerKt$ModalNavigationDrawer$3$7$1RememberedValue);
                }
                MeasurePolicy measurePolicy7 = (MeasurePolicy) navigationDrawerKt$ModalNavigationDrawer$3$7$1RememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                int i113 = i3 & 14;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap111 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier111 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFocusRequester7);
                constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                int i114 = ((i113 << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor3);
                } else {
                    composerStartRestartGroup.useNode();
                }
                composerM6062constructorimpl3 = Updater.m6062constructorimpl(composerStartRestartGroup);
                Updater.m6070setimpl(composerM6062constructorimpl3, measurePolicy7, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl3, currentCompositionLocalMap111, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!composerM6062constructorimpl3.getInserting()) {
                    composerM6062constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                    composerM6062constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                } else {
                    composerM6062constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                    composerM6062constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                }
                Updater.m6070setimpl(composerM6062constructorimpl3, modifierMaterializeModifier111, ComposeUiNode.INSTANCE.getSetModifier());
                function4 = function2;
                function4.invoke(composerStartRestartGroup, Integer.valueOf((i114 >> 6) & 14));
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                drawerState2 = drawerState3;
                j3 = j9;
                z3 = z8;
            } else {
                function4 = function2;
                composerStartRestartGroup.skipToGroupEnd();
                z3 = z;
                modifier3 = modifier2;
                drawerState2 = drawerStateRememberDrawerState;
                j3 = j2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final Function2 function12 = function4;
                final Modifier modifier6 = modifier3;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return NavigationDrawerKt.ModalNavigationDrawer_FHprtrg$lambda$10(function12, modifier6, drawerState2, z3, j3, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 3072;
        if ((i & 24576) == 0) {
            j2 = j;
            if ((i2 & 16) == 0) {
                i8 = 8192;
            } else {
                i8 = 8192;
            }
            i3 |= i8;
        } else {
            j2 = j;
        }
        if ((196608 & i) == 0) {
            if (composerStartRestartGroup.changedInstance(function3)) {
                i7 = 131072;
            } else {
                i7 = 65536;
            }
            i3 |= i7;
        }
        if ((74899 & i3) != 74898) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z2, i3 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "341@14033L39,343@14150L10");
            if ((i & 1) != 0) {
                if (i9 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if ((i2 & 4) != 0) {
                    i3 &= -897;
                    drawerStateRememberDrawerState = rememberDrawerState(DrawerValue.Closed, null, composerStartRestartGroup, 6, 2);
                }
                if (i4 != 0) {
                    z4 = true;
                } else {
                    z4 = z;
                }
                if ((i2 & 16) != 0) {
                    i3 &= -57345;
                    scrimColor = DrawerDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                } else {
                    scrimColor = j2;
                }
            } else {
                if (i9 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if ((i2 & 4) != 0) {
                    i3 &= -897;
                    drawerStateRememberDrawerState = rememberDrawerState(DrawerValue.Closed, null, composerStartRestartGroup, 6, 2);
                }
                if (i4 != 0) {
                    z4 = true;
                } else {
                    z4 = z;
                }
                if ((i2 & 16) != 0) {
                    i3 &= -57345;
                    scrimColor = DrawerDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                } else {
                    scrimColor = j2;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1907430816, i3, -1, "androidx.compose.material3.ModalNavigationDrawer (NavigationDrawer.kt:345)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 773894976, "CC(rememberCoroutineScope)N(getContext)608@27648L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 683737348, "CC(remember):Effects.kt#9igjgp");
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            coroutineScope = (CoroutineScope) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Strings.Companion companion19 = Strings.INSTANCE;
            strM5086getString2EP1pXo = Strings_androidKt.m5086getString2EP1pXo(Strings.m5002constructorimpl(androidx.compose.ui.R.string.navigation_menu), composerStartRestartGroup, 0);
            ProvidableCompositionLocal<Density> localDensity4 = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume5 = composerStartRestartGroup.consume(localDensity4);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            density = (Density) objConsume5;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 910036450, "CC(remember):NavigationDrawer.kt#9igjgp");
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            mutableState = (MutableState) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 910038221, "CC(remember):NavigationDrawer.kt#9igjgp");
            zChanged = composerStartRestartGroup.changed(density);
            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (zChanged) {
                f = 0.0f;
                if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                }
                mutableFloatState = (MutableFloatState) objRememberedValue3;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 910041181, "CC(remember):NavigationDrawer.kt#9igjgp");
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue4 = new FocusRequester();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                focusRequester = (FocusRequester) objRememberedValue4;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                finiteAnimationSpecValue = MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultSpatial, composerStartRestartGroup, 6);
                long j10 = scrimColor;
                finiteAnimationSpecValue2 = MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultSpatial, composerStartRestartGroup, 6);
                finiteAnimationSpecValue3 = MotionSchemeKt.value(MotionSchemeKeyTokens.FastEffects, composerStartRestartGroup, 6);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 910054821, "CC(remember):NavigationDrawer.kt#9igjgp");
                i6 = (i3 & 896) ^ 384;
                if (i6 > 256) {
                    drawerState3 = drawerStateRememberDrawerState;
                    if ((i3 & 384) != 256) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                } else {
                    drawerState3 = drawerStateRememberDrawerState;
                    if ((i3 & 384) != 256) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                }
                zChanged2 = z5 | composerStartRestartGroup.changed(density) | composerStartRestartGroup.changedInstance(finiteAnimationSpecValue2) | composerStartRestartGroup.changedInstance(finiteAnimationSpecValue3) | composerStartRestartGroup.changedInstance(finiteAnimationSpecValue);
                objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                if (!zChanged2) {
                    objRememberedValue5 = new Function0() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return NavigationDrawerKt.ModalNavigationDrawer_FHprtrg$lambda$7$0(drawerState3, density, finiteAnimationSpecValue2, finiteAnimationSpecValue3, finiteAnimationSpecValue);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                } else {
                    objRememberedValue5 = new Function0() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return NavigationDrawerKt.ModalNavigationDrawer_FHprtrg$lambda$7$0(drawerState3, density, finiteAnimationSpecValue2, finiteAnimationSpecValue3, finiteAnimationSpecValue);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.SideEffect((Function0) objRememberedValue5, composerStartRestartGroup, 0);
                Boolean boolValueOf8 = Boolean.valueOf(drawerState3.isOpen());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 910063410, "CC(remember):NavigationDrawer.kt#9igjgp");
                if (i6 <= 256) {
                }
                navigationDrawerKt$ModalNavigationDrawer$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z6) {
                    navigationDrawerKt$ModalNavigationDrawer$2$1RememberedValue = new NavigationDrawerKt$ModalNavigationDrawer$2$1(drawerState3, focusRequester, null);
                    composerStartRestartGroup.updateRememberedValue(navigationDrawerKt$ModalNavigationDrawer$2$1RememberedValue);
                } else {
                    navigationDrawerKt$ModalNavigationDrawer$2$1RememberedValue = new NavigationDrawerKt$ModalNavigationDrawer$2$1(drawerState3, focusRequester, null);
                    composerStartRestartGroup.updateRememberedValue(navigationDrawerKt$ModalNavigationDrawer$2$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.LaunchedEffect(boolValueOf8, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) navigationDrawerKt$ModalNavigationDrawer$2$1RememberedValue, composerStartRestartGroup, 0);
                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection8 = CompositionLocalsKt.getLocalLayoutDirection();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                objConsume = composerStartRestartGroup.consume(localLayoutDirection8);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (objConsume == LayoutDirection.Rtl) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                z8 = z4;
                Modifier modifierAnchoredDraggable$default8 = AnchoredDraggableKt.anchoredDraggable$default(SizeKt.fillMaxSize$default(companion, f, 1, null), drawerState3.getAnchoredDraggableState$material3(), z7, Orientation.Horizontal, z8, (MutableInteractionSource) null, (OverscrollEffect) null, (FlingBehavior) null, 112, (Object) null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy15 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                modifier3 = companion;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap112 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier112 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierAnchoredDraggable$default8);
                constructor = ComposeUiNode.INSTANCE.getConstructor();
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
                composerM6062constructorimpl = Updater.m6062constructorimpl(composerStartRestartGroup);
                Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy15, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap112, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!composerM6062constructorimpl.getInserting()) {
                    composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                } else {
                    composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier112, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance15 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 101899237, "C385@15772L17,388@15866L183,393@16074L70,386@15798L389,399@16296L601,411@16929L452,422@17414L501,435@17979L1561,396@16196L3344:NavigationDrawer.kt#uh7d8r");
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                Modifier.Companion companion110 = Modifier.INSTANCE;
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy16 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap113 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier113 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion110);
                constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor2);
                } else {
                    composerStartRestartGroup.useNode();
                }
                composerM6062constructorimpl2 = Updater.m6062constructorimpl(composerStartRestartGroup);
                Updater.m6070setimpl(composerM6062constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy16, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl2, currentCompositionLocalMap113, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!composerM6062constructorimpl2.getInserting()) {
                    composerM6062constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    composerM6062constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                } else {
                    composerM6062constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    composerM6062constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                }
                Updater.m6070setimpl(composerM6062constructorimpl2, modifierMaterializeModifier113, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance16 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 343987054, "C385@15778L9:NavigationDrawer.kt#uh7d8r");
                function3.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 15) & 14));
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                boolean zIsOpen8 = drawerState3.isOpen();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2081496477, "CC(remember):NavigationDrawer.kt#9igjgp");
                if ((i3 & 7168) == 2048) {
                    z9 = true;
                } else {
                    z9 = false;
                }
                zChangedInstance = z9 | ((i6 <= 256 && composerStartRestartGroup.changed(drawerState3)) || (i3 & 384) == 256) | composerStartRestartGroup.changedInstance(coroutineScope);
                objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                if (!zChangedInstance) {
                    objRememberedValue6 = new Function0() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return NavigationDrawerKt.ModalNavigationDrawer_FHprtrg$lambda$9$1$0(z8, drawerState3, coroutineScope);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                } else {
                    objRememberedValue6 = new Function0() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return NavigationDrawerKt.ModalNavigationDrawer_FHprtrg$lambda$9$1$0(z8, drawerState3, coroutineScope);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                }
                Function0 function13 = (Function0) objRememberedValue6;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2081503020, "CC(remember):NavigationDrawer.kt#9igjgp");
                zChanged3 = composerStartRestartGroup.changed(mutableFloatState) | ((i6 <= 256 && composerStartRestartGroup.changed(drawerState3)) || (i3 & 384) == 256);
                objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                if (!zChanged3) {
                    final float f15 = 0.0f;
                    objRememberedValue7 = new Function0() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return Float.valueOf(NavigationDrawerKt.ModalNavigationDrawer_FHprtrg$lambda$9$2$0(f15, drawerState3, mutableFloatState));
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                } else {
                    final float f16 = 0.0f;
                    objRememberedValue7 = new Function0() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return Float.valueOf(NavigationDrawerKt.ModalNavigationDrawer_FHprtrg$lambda$9$2$0(f16, drawerState3, mutableFloatState));
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                m3870ScrimBx497Mc(zIsOpen8, function13, (Function0) objRememberedValue7, j10, composerStartRestartGroup, (i3 >> 3) & 7168);
                Modifier.Companion companion111 = Modifier.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2081510655, "CC(remember):NavigationDrawer.kt#9igjgp");
                if (i6 <= 256) {
                }
                objRememberedValue8 = composerStartRestartGroup.rememberedValue();
                if (!z10) {
                    objRememberedValue8 = new Function1() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return NavigationDrawerKt.ModalNavigationDrawer_FHprtrg$lambda$9$3$0(drawerState3, (Density) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                } else {
                    objRememberedValue8 = new Function1() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return NavigationDrawerKt.ModalNavigationDrawer_FHprtrg$lambda$9$3$0(drawerState3, (Density) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifierOffset8 = OffsetKt.offset(companion111, (Function1) objRememberedValue8);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2081530762, "CC(remember):NavigationDrawer.kt#9igjgp");
                zChanged4 = composerStartRestartGroup.changed(strM5086getString2EP1pXo) | ((i6 <= 256 && composerStartRestartGroup.changed(drawerState3)) || (i3 & 384) == 256) | composerStartRestartGroup.changedInstance(coroutineScope);
                objRememberedValue9 = composerStartRestartGroup.rememberedValue();
                if (!zChanged4) {
                    objRememberedValue9 = new Function1() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return NavigationDrawerKt.ModalNavigationDrawer_FHprtrg$lambda$9$4$0(strM5086getString2EP1pXo, drawerState3, coroutineScope, (SemanticsPropertyReceiver) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue9);
                } else {
                    objRememberedValue9 = new Function1() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return NavigationDrawerKt.ModalNavigationDrawer_FHprtrg$lambda$9$4$0(strM5086getString2EP1pXo, drawerState3, coroutineScope, (SemanticsPropertyReceiver) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue9);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifierSemantics$default8 = SemanticsModifierKt.semantics$default(modifierOffset8, false, (Function1) objRememberedValue9, 1, null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2081546331, "CC(remember):NavigationDrawer.kt#9igjgp");
                zChangedInstance2 = ((i6 <= 256 && composerStartRestartGroup.changed(drawerState3)) || (i3 & 384) == 256) | composerStartRestartGroup.changedInstance(coroutineScope);
                objRememberedValue10 = composerStartRestartGroup.rememberedValue();
                if (!zChangedInstance2) {
                    objRememberedValue10 = (Function1) new Function1<KeyEvent, Boolean>() { // from class: androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$3$6$1
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Boolean invoke(KeyEvent keyEvent) {
                            return m3874invokeZmokQxo(keyEvent.m7966unboximpl());
                        }

                        /* JADX INFO: renamed from: invoke-ZmokQxo, reason: not valid java name */
                        public final Boolean m3874invokeZmokQxo(android.view.KeyEvent keyEvent) {
                            if (drawerState3.isOpen() && KeyEventType.m7970equalsimpl0(KeyEvent_androidKt.m7978getTypeZmokQxo(keyEvent), KeyEventType.INSTANCE.m7975getKeyUpCS__XNY()) && Key.m7669equalsimpl0(KeyEvent_androidKt.m7977getKeyZmokQxo(keyEvent), Key.INSTANCE.m7758getEscapeEK5gGoQ())) {
                                BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new AnonymousClass1(drawerState3, null), 3, null);
                                return true;
                            }
                            return false;
                        }

                        /* JADX INFO: renamed from: androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$3$6$1$1, reason: invalid class name */
                        /* JADX INFO: compiled from: NavigationDrawer.kt */
                        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
                        @DebugMetadata(c = "androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$3$6$1$1", f = "NavigationDrawer.kt", i = {}, l = {430}, m = "invokeSuspend", n = {}, s = {}, v = 1)
                        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                            final /* synthetic */ DrawerState $drawerState;
                            int label;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            AnonymousClass1(DrawerState drawerState, Continuation<? super AnonymousClass1> continuation) {
                                super(2, continuation);
                                this.$drawerState = drawerState;
                            }

                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                return new AnonymousClass1(this.$drawerState, continuation);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                            }

                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            public final Object invokeSuspend(Object obj) {
                                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                int i = this.label;
                                if (i == 0) {
                                    ResultKt.throwOnFailure(obj);
                                    this.label = 1;
                                    if (this.$drawerState.close(this) == coroutine_suspended) {
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
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue10);
                } else {
                    objRememberedValue10 = (Function1) new Function1<KeyEvent, Boolean>() { // from class: androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$3$6$1
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Boolean invoke(KeyEvent keyEvent) {
                            return m3874invokeZmokQxo(keyEvent.m7966unboximpl());
                        }

                        /* JADX INFO: renamed from: invoke-ZmokQxo, reason: not valid java name */
                        public final Boolean m3874invokeZmokQxo(android.view.KeyEvent keyEvent) {
                            if (drawerState3.isOpen() && KeyEventType.m7970equalsimpl0(KeyEvent_androidKt.m7978getTypeZmokQxo(keyEvent), KeyEventType.INSTANCE.m7975getKeyUpCS__XNY()) && Key.m7669equalsimpl0(KeyEvent_androidKt.m7977getKeyZmokQxo(keyEvent), Key.INSTANCE.m7758getEscapeEK5gGoQ())) {
                                BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new AnonymousClass1(drawerState3, null), 3, null);
                                return true;
                            }
                            return false;
                        }

                        /* JADX INFO: renamed from: androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$3$6$1$1, reason: invalid class name */
                        /* JADX INFO: compiled from: NavigationDrawer.kt */
                        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
                        @DebugMetadata(c = "androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$3$6$1$1", f = "NavigationDrawer.kt", i = {}, l = {430}, m = "invokeSuspend", n = {}, s = {}, v = 1)
                        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                            final /* synthetic */ DrawerState $drawerState;
                            int label;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            AnonymousClass1(DrawerState drawerState, Continuation<? super AnonymousClass1> continuation) {
                                super(2, continuation);
                                this.$drawerState = drawerState;
                            }

                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                return new AnonymousClass1(this.$drawerState, continuation);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                            }

                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            public final Object invokeSuspend(Object obj) {
                                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                int i = this.label;
                                if (i == 0) {
                                    ResultKt.throwOnFailure(obj);
                                    this.label = 1;
                                    if (this.$drawerState.close(this) == coroutine_suspended) {
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
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue10);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifierFocusRequester8 = FocusRequesterModifierKt.focusRequester(KeyInputModifierKt.onKeyEvent(modifierSemantics$default8, (Function1) objRememberedValue10), focusRequester);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2081565471, "CC(remember):NavigationDrawer.kt#9igjgp");
                zChanged5 = composerStartRestartGroup.changed(mutableFloatState) | ((i6 <= 256 && composerStartRestartGroup.changed(drawerState3)) || (i3 & 384) == 256);
                navigationDrawerKt$ModalNavigationDrawer$3$7$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChanged5) {
                    navigationDrawerKt$ModalNavigationDrawer$3$7$1RememberedValue = new NavigationDrawerKt$ModalNavigationDrawer$3$7$1(drawerState3, 0.0f, mutableState, mutableFloatState);
                    composerStartRestartGroup.updateRememberedValue(navigationDrawerKt$ModalNavigationDrawer$3$7$1RememberedValue);
                } else {
                    navigationDrawerKt$ModalNavigationDrawer$3$7$1RememberedValue = new NavigationDrawerKt$ModalNavigationDrawer$3$7$1(drawerState3, 0.0f, mutableState, mutableFloatState);
                    composerStartRestartGroup.updateRememberedValue(navigationDrawerKt$ModalNavigationDrawer$3$7$1RememberedValue);
                }
                MeasurePolicy measurePolicy8 = (MeasurePolicy) navigationDrawerKt$ModalNavigationDrawer$3$7$1RememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                int i115 = i3 & 14;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap114 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier114 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFocusRequester8);
                constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                int i116 = ((i115 << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor3);
                } else {
                    composerStartRestartGroup.useNode();
                }
                composerM6062constructorimpl3 = Updater.m6062constructorimpl(composerStartRestartGroup);
                Updater.m6070setimpl(composerM6062constructorimpl3, measurePolicy8, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl3, currentCompositionLocalMap114, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!composerM6062constructorimpl3.getInserting()) {
                    composerM6062constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                    composerM6062constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                } else {
                    composerM6062constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                    composerM6062constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                }
                Updater.m6070setimpl(composerM6062constructorimpl3, modifierMaterializeModifier114, ComposeUiNode.INSTANCE.getSetModifier());
                function4 = function2;
                function4.invoke(composerStartRestartGroup, Integer.valueOf((i116 >> 6) & 14));
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                drawerState2 = drawerState3;
                j3 = j10;
                z3 = z8;
            } else {
                f = 0.0f;
            }
            objRememberedValue3 = PrimitiveSnapshotStateKt.mutableFloatStateOf(f);
            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            mutableFloatState = (MutableFloatState) objRememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 910041181, "CC(remember):NavigationDrawer.kt#9igjgp");
            objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue4 = new FocusRequester();
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            focusRequester = (FocusRequester) objRememberedValue4;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            finiteAnimationSpecValue = MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultSpatial, composerStartRestartGroup, 6);
            long j11 = scrimColor;
            finiteAnimationSpecValue2 = MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultSpatial, composerStartRestartGroup, 6);
            finiteAnimationSpecValue3 = MotionSchemeKt.value(MotionSchemeKeyTokens.FastEffects, composerStartRestartGroup, 6);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 910054821, "CC(remember):NavigationDrawer.kt#9igjgp");
            i6 = (i3 & 896) ^ 384;
            if (i6 > 256) {
                drawerState3 = drawerStateRememberDrawerState;
                if ((i3 & 384) != 256) {
                    z5 = true;
                } else {
                    z5 = false;
                }
            } else {
                drawerState3 = drawerStateRememberDrawerState;
                if ((i3 & 384) != 256) {
                    z5 = true;
                } else {
                    z5 = false;
                }
            }
            zChanged2 = z5 | composerStartRestartGroup.changed(density) | composerStartRestartGroup.changedInstance(finiteAnimationSpecValue2) | composerStartRestartGroup.changedInstance(finiteAnimationSpecValue3) | composerStartRestartGroup.changedInstance(finiteAnimationSpecValue);
            objRememberedValue5 = composerStartRestartGroup.rememberedValue();
            if (!zChanged2) {
                objRememberedValue5 = new Function0() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return NavigationDrawerKt.ModalNavigationDrawer_FHprtrg$lambda$7$0(drawerState3, density, finiteAnimationSpecValue2, finiteAnimationSpecValue3, finiteAnimationSpecValue);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
            } else {
                objRememberedValue5 = new Function0() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return NavigationDrawerKt.ModalNavigationDrawer_FHprtrg$lambda$7$0(drawerState3, density, finiteAnimationSpecValue2, finiteAnimationSpecValue3, finiteAnimationSpecValue);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.SideEffect((Function0) objRememberedValue5, composerStartRestartGroup, 0);
            Boolean boolValueOf9 = Boolean.valueOf(drawerState3.isOpen());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 910063410, "CC(remember):NavigationDrawer.kt#9igjgp");
            if (i6 <= 256) {
            }
            navigationDrawerKt$ModalNavigationDrawer$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (!z6) {
                navigationDrawerKt$ModalNavigationDrawer$2$1RememberedValue = new NavigationDrawerKt$ModalNavigationDrawer$2$1(drawerState3, focusRequester, null);
                composerStartRestartGroup.updateRememberedValue(navigationDrawerKt$ModalNavigationDrawer$2$1RememberedValue);
            } else {
                navigationDrawerKt$ModalNavigationDrawer$2$1RememberedValue = new NavigationDrawerKt$ModalNavigationDrawer$2$1(drawerState3, focusRequester, null);
                composerStartRestartGroup.updateRememberedValue(navigationDrawerKt$ModalNavigationDrawer$2$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(boolValueOf9, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) navigationDrawerKt$ModalNavigationDrawer$2$1RememberedValue, composerStartRestartGroup, 0);
            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection9 = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            objConsume = composerStartRestartGroup.consume(localLayoutDirection9);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (objConsume == LayoutDirection.Rtl) {
                z7 = true;
            } else {
                z7 = false;
            }
            z8 = z4;
            Modifier modifierAnchoredDraggable$default9 = AnchoredDraggableKt.anchoredDraggable$default(SizeKt.fillMaxSize$default(companion, f, 1, null), drawerState3.getAnchoredDraggableState$material3(), z7, Orientation.Horizontal, z8, (MutableInteractionSource) null, (OverscrollEffect) null, (FlingBehavior) null, 112, (Object) null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy17 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            modifier3 = companion;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap115 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier115 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierAnchoredDraggable$default9);
            constructor = ComposeUiNode.INSTANCE.getConstructor();
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
            composerM6062constructorimpl = Updater.m6062constructorimpl(composerStartRestartGroup);
            Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy17, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap115, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (!composerM6062constructorimpl.getInserting()) {
                composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            } else {
                composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier115, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance17 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 101899237, "C385@15772L17,388@15866L183,393@16074L70,386@15798L389,399@16296L601,411@16929L452,422@17414L501,435@17979L1561,396@16196L3344:NavigationDrawer.kt#uh7d8r");
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            Modifier.Companion companion112 = Modifier.INSTANCE;
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy18 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap116 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier116 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion112);
            constructor2 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor2);
            } else {
                composerStartRestartGroup.useNode();
            }
            composerM6062constructorimpl2 = Updater.m6062constructorimpl(composerStartRestartGroup);
            Updater.m6070setimpl(composerM6062constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy18, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl2, currentCompositionLocalMap116, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (!composerM6062constructorimpl2.getInserting()) {
                composerM6062constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                composerM6062constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            } else {
                composerM6062constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                composerM6062constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.m6070setimpl(composerM6062constructorimpl2, modifierMaterializeModifier116, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance18 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 343987054, "C385@15778L9:NavigationDrawer.kt#uh7d8r");
            function3.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 15) & 14));
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            boolean zIsOpen9 = drawerState3.isOpen();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2081496477, "CC(remember):NavigationDrawer.kt#9igjgp");
            if ((i3 & 7168) == 2048) {
                z9 = true;
            } else {
                z9 = false;
            }
            zChangedInstance = z9 | ((i6 <= 256 && composerStartRestartGroup.changed(drawerState3)) || (i3 & 384) == 256) | composerStartRestartGroup.changedInstance(coroutineScope);
            objRememberedValue6 = composerStartRestartGroup.rememberedValue();
            if (!zChangedInstance) {
                objRememberedValue6 = new Function0() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return NavigationDrawerKt.ModalNavigationDrawer_FHprtrg$lambda$9$1$0(z8, drawerState3, coroutineScope);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
            } else {
                objRememberedValue6 = new Function0() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return NavigationDrawerKt.ModalNavigationDrawer_FHprtrg$lambda$9$1$0(z8, drawerState3, coroutineScope);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
            }
            Function0 function14 = (Function0) objRememberedValue6;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2081503020, "CC(remember):NavigationDrawer.kt#9igjgp");
            zChanged3 = composerStartRestartGroup.changed(mutableFloatState) | ((i6 <= 256 && composerStartRestartGroup.changed(drawerState3)) || (i3 & 384) == 256);
            objRememberedValue7 = composerStartRestartGroup.rememberedValue();
            if (!zChanged3) {
                final float f17 = 0.0f;
                objRememberedValue7 = new Function0() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Float.valueOf(NavigationDrawerKt.ModalNavigationDrawer_FHprtrg$lambda$9$2$0(f17, drawerState3, mutableFloatState));
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
            } else {
                final float f18 = 0.0f;
                objRememberedValue7 = new Function0() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Float.valueOf(NavigationDrawerKt.ModalNavigationDrawer_FHprtrg$lambda$9$2$0(f18, drawerState3, mutableFloatState));
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            m3870ScrimBx497Mc(zIsOpen9, function14, (Function0) objRememberedValue7, j11, composerStartRestartGroup, (i3 >> 3) & 7168);
            Modifier.Companion companion113 = Modifier.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2081510655, "CC(remember):NavigationDrawer.kt#9igjgp");
            if (i6 <= 256) {
            }
            objRememberedValue8 = composerStartRestartGroup.rememberedValue();
            if (!z10) {
                objRememberedValue8 = new Function1() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return NavigationDrawerKt.ModalNavigationDrawer_FHprtrg$lambda$9$3$0(drawerState3, (Density) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
            } else {
                objRememberedValue8 = new Function1() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return NavigationDrawerKt.ModalNavigationDrawer_FHprtrg$lambda$9$3$0(drawerState3, (Density) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierOffset9 = OffsetKt.offset(companion113, (Function1) objRememberedValue8);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2081530762, "CC(remember):NavigationDrawer.kt#9igjgp");
            zChanged4 = composerStartRestartGroup.changed(strM5086getString2EP1pXo) | ((i6 <= 256 && composerStartRestartGroup.changed(drawerState3)) || (i3 & 384) == 256) | composerStartRestartGroup.changedInstance(coroutineScope);
            objRememberedValue9 = composerStartRestartGroup.rememberedValue();
            if (!zChanged4) {
                objRememberedValue9 = new Function1() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return NavigationDrawerKt.ModalNavigationDrawer_FHprtrg$lambda$9$4$0(strM5086getString2EP1pXo, drawerState3, coroutineScope, (SemanticsPropertyReceiver) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue9);
            } else {
                objRememberedValue9 = new Function1() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return NavigationDrawerKt.ModalNavigationDrawer_FHprtrg$lambda$9$4$0(strM5086getString2EP1pXo, drawerState3, coroutineScope, (SemanticsPropertyReceiver) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue9);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierSemantics$default9 = SemanticsModifierKt.semantics$default(modifierOffset9, false, (Function1) objRememberedValue9, 1, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2081546331, "CC(remember):NavigationDrawer.kt#9igjgp");
            zChangedInstance2 = ((i6 <= 256 && composerStartRestartGroup.changed(drawerState3)) || (i3 & 384) == 256) | composerStartRestartGroup.changedInstance(coroutineScope);
            objRememberedValue10 = composerStartRestartGroup.rememberedValue();
            if (!zChangedInstance2) {
                objRememberedValue10 = (Function1) new Function1<KeyEvent, Boolean>() { // from class: androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$3$6$1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Boolean invoke(KeyEvent keyEvent) {
                        return m3874invokeZmokQxo(keyEvent.m7966unboximpl());
                    }

                    /* JADX INFO: renamed from: invoke-ZmokQxo, reason: not valid java name */
                    public final Boolean m3874invokeZmokQxo(android.view.KeyEvent keyEvent) {
                        if (drawerState3.isOpen() && KeyEventType.m7970equalsimpl0(KeyEvent_androidKt.m7978getTypeZmokQxo(keyEvent), KeyEventType.INSTANCE.m7975getKeyUpCS__XNY()) && Key.m7669equalsimpl0(KeyEvent_androidKt.m7977getKeyZmokQxo(keyEvent), Key.INSTANCE.m7758getEscapeEK5gGoQ())) {
                            BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new AnonymousClass1(drawerState3, null), 3, null);
                            return true;
                        }
                        return false;
                    }

                    /* JADX INFO: renamed from: androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$3$6$1$1, reason: invalid class name */
                    /* JADX INFO: compiled from: NavigationDrawer.kt */
                    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
                    @DebugMetadata(c = "androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$3$6$1$1", f = "NavigationDrawer.kt", i = {}, l = {430}, m = "invokeSuspend", n = {}, s = {}, v = 1)
                    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                        final /* synthetic */ DrawerState $drawerState;
                        int label;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        AnonymousClass1(DrawerState drawerState, Continuation<? super AnonymousClass1> continuation) {
                            super(2, continuation);
                            this.$drawerState = drawerState;
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                            return new AnonymousClass1(this.$drawerState, continuation);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object obj) {
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            int i = this.label;
                            if (i == 0) {
                                ResultKt.throwOnFailure(obj);
                                this.label = 1;
                                if (this.$drawerState.close(this) == coroutine_suspended) {
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
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue10);
            } else {
                objRememberedValue10 = (Function1) new Function1<KeyEvent, Boolean>() { // from class: androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$3$6$1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Boolean invoke(KeyEvent keyEvent) {
                        return m3874invokeZmokQxo(keyEvent.m7966unboximpl());
                    }

                    /* JADX INFO: renamed from: invoke-ZmokQxo, reason: not valid java name */
                    public final Boolean m3874invokeZmokQxo(android.view.KeyEvent keyEvent) {
                        if (drawerState3.isOpen() && KeyEventType.m7970equalsimpl0(KeyEvent_androidKt.m7978getTypeZmokQxo(keyEvent), KeyEventType.INSTANCE.m7975getKeyUpCS__XNY()) && Key.m7669equalsimpl0(KeyEvent_androidKt.m7977getKeyZmokQxo(keyEvent), Key.INSTANCE.m7758getEscapeEK5gGoQ())) {
                            BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new AnonymousClass1(drawerState3, null), 3, null);
                            return true;
                        }
                        return false;
                    }

                    /* JADX INFO: renamed from: androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$3$6$1$1, reason: invalid class name */
                    /* JADX INFO: compiled from: NavigationDrawer.kt */
                    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
                    @DebugMetadata(c = "androidx.compose.material3.NavigationDrawerKt$ModalNavigationDrawer$3$6$1$1", f = "NavigationDrawer.kt", i = {}, l = {430}, m = "invokeSuspend", n = {}, s = {}, v = 1)
                    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                        final /* synthetic */ DrawerState $drawerState;
                        int label;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        AnonymousClass1(DrawerState drawerState, Continuation<? super AnonymousClass1> continuation) {
                            super(2, continuation);
                            this.$drawerState = drawerState;
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                            return new AnonymousClass1(this.$drawerState, continuation);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object obj) {
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            int i = this.label;
                            if (i == 0) {
                                ResultKt.throwOnFailure(obj);
                                this.label = 1;
                                if (this.$drawerState.close(this) == coroutine_suspended) {
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
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue10);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierFocusRequester9 = FocusRequesterModifierKt.focusRequester(KeyInputModifierKt.onKeyEvent(modifierSemantics$default9, (Function1) objRememberedValue10), focusRequester);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2081565471, "CC(remember):NavigationDrawer.kt#9igjgp");
            zChanged5 = composerStartRestartGroup.changed(mutableFloatState) | ((i6 <= 256 && composerStartRestartGroup.changed(drawerState3)) || (i3 & 384) == 256);
            navigationDrawerKt$ModalNavigationDrawer$3$7$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (!zChanged5) {
                navigationDrawerKt$ModalNavigationDrawer$3$7$1RememberedValue = new NavigationDrawerKt$ModalNavigationDrawer$3$7$1(drawerState3, 0.0f, mutableState, mutableFloatState);
                composerStartRestartGroup.updateRememberedValue(navigationDrawerKt$ModalNavigationDrawer$3$7$1RememberedValue);
            } else {
                navigationDrawerKt$ModalNavigationDrawer$3$7$1RememberedValue = new NavigationDrawerKt$ModalNavigationDrawer$3$7$1(drawerState3, 0.0f, mutableState, mutableFloatState);
                composerStartRestartGroup.updateRememberedValue(navigationDrawerKt$ModalNavigationDrawer$3$7$1RememberedValue);
            }
            MeasurePolicy measurePolicy9 = (MeasurePolicy) navigationDrawerKt$ModalNavigationDrawer$3$7$1RememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            int i117 = i3 & 14;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap117 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier117 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFocusRequester9);
            constructor3 = ComposeUiNode.INSTANCE.getConstructor();
            int i118 = ((i117 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor3);
            } else {
                composerStartRestartGroup.useNode();
            }
            composerM6062constructorimpl3 = Updater.m6062constructorimpl(composerStartRestartGroup);
            Updater.m6070setimpl(composerM6062constructorimpl3, measurePolicy9, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl3, currentCompositionLocalMap117, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (!composerM6062constructorimpl3.getInserting()) {
                composerM6062constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                composerM6062constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
            } else {
                composerM6062constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                composerM6062constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
            }
            Updater.m6070setimpl(composerM6062constructorimpl3, modifierMaterializeModifier117, ComposeUiNode.INSTANCE.getSetModifier());
            function4 = function2;
            function4.invoke(composerStartRestartGroup, Integer.valueOf((i118 >> 6) & 14));
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            drawerState2 = drawerState3;
            j3 = j11;
            z3 = z8;
        } else {
            function4 = function2;
            composerStartRestartGroup.skipToGroupEnd();
            z3 = z;
            modifier3 = modifier2;
            drawerState2 = drawerStateRememberDrawerState;
            j3 = j2;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Function2 function15 = function4;
            final Modifier modifier7 = modifier3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return NavigationDrawerKt.ModalNavigationDrawer_FHprtrg$lambda$10(function15, modifier7, drawerState2, z3, j3, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean ModalNavigationDrawer_FHprtrg$lambda$1(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ModalNavigationDrawer_FHprtrg$lambda$2(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float ModalNavigationDrawer_FHprtrg$lambda$4(MutableFloatState mutableFloatState) {
        return mutableFloatState.getFloatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ModalNavigationDrawer_FHprtrg$lambda$7$0(DrawerState drawerState, Density density, FiniteAnimationSpec finiteAnimationSpec, FiniteAnimationSpec finiteAnimationSpec2, FiniteAnimationSpec finiteAnimationSpec3) {
        drawerState.setDensity$material3(density);
        drawerState.setOpenDrawerMotionSpec$material3(finiteAnimationSpec);
        drawerState.setCloseDrawerMotionSpec$material3(finiteAnimationSpec2);
        drawerState.setAnchoredDraggableMotionSpec$material3(finiteAnimationSpec3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ModalNavigationDrawer_FHprtrg$lambda$9$1$0(boolean z, DrawerState drawerState, CoroutineScope coroutineScope) {
        if (z && drawerState.getConfirmStateChange$material3().invoke(DrawerValue.Closed).booleanValue()) {
            BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new NavigationDrawerKt$ModalNavigationDrawer$3$2$1$1(drawerState, null), 3, null);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float ModalNavigationDrawer_FHprtrg$lambda$9$2$0(float f, DrawerState drawerState, MutableFloatState mutableFloatState) {
        return calculateFraction(ModalNavigationDrawer_FHprtrg$lambda$4(mutableFloatState), f, drawerState.requireOffset$material3());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IntOffset ModalNavigationDrawer_FHprtrg$lambda$9$3$0(DrawerState drawerState, Density density) {
        int iRoundToInt;
        float currentOffset = drawerState.getCurrentOffset();
        if (Float.isNaN(currentOffset)) {
            iRoundToInt = drawerState.isOpen() ? 0 : -density.mo748roundToPx0680j_4(DrawerDefaults.INSTANCE.m3296getMaximumDrawerWidthD9Ej5fM());
        } else {
            iRoundToInt = MathKt.roundToInt(currentOffset);
        }
        return IntOffset.m9806boximpl(IntOffset.m9809constructorimpl((((long) iRoundToInt) << 32) | (((long) 0) & 4294967295L)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ModalNavigationDrawer_FHprtrg$lambda$9$4$0(String str, final DrawerState drawerState, final CoroutineScope coroutineScope, SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.setPaneTitle(semanticsPropertyReceiver, str);
        if (drawerState.isOpen()) {
            SemanticsPropertiesKt.dismiss$default(semanticsPropertyReceiver, null, new Function0() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda16
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return Boolean.valueOf(NavigationDrawerKt.ModalNavigationDrawer_FHprtrg$lambda$9$4$0$0(drawerState, coroutineScope));
                }
            }, 1, null);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean ModalNavigationDrawer_FHprtrg$lambda$9$4$0$0(DrawerState drawerState, CoroutineScope coroutineScope) {
        if (!drawerState.getConfirmStateChange$material3().invoke(DrawerValue.Closed).booleanValue()) {
            return true;
        }
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new NavigationDrawerKt$ModalNavigationDrawer$3$5$1$1$1(drawerState, null), 3, null);
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:104:0x01bd  */
    /* JADX WARN: Code duplicated, block: B:106:0x01c5  */
    /* JADX WARN: Code duplicated, block: B:109:0x01f6  */
    /* JADX WARN: Code duplicated, block: B:112:0x022f  */
    /* JADX WARN: Code duplicated, block: B:113:0x0232  */
    /* JADX WARN: Code duplicated, block: B:116:0x0288  */
    /* JADX WARN: Code duplicated, block: B:119:0x0294  */
    /* JADX WARN: Code duplicated, block: B:120:0x0298  */
    /* JADX WARN: Code duplicated, block: B:123:0x02bd  */
    /* JADX WARN: Code duplicated, block: B:125:0x02cb  */
    /* JADX WARN: Code duplicated, block: B:128:0x0300  */
    /* JADX WARN: Code duplicated, block: B:130:0x0306  */
    /* JADX WARN: Code duplicated, block: B:136:0x0313  */
    /* JADX WARN: Code duplicated, block: B:138:0x031b  */
    /* JADX WARN: Code duplicated, block: B:141:0x0358  */
    /* JADX WARN: Code duplicated, block: B:144:0x0364  */
    /* JADX WARN: Code duplicated, block: B:145:0x0368  */
    /* JADX WARN: Code duplicated, block: B:148:0x038d  */
    /* JADX WARN: Code duplicated, block: B:150:0x039b  */
    /* JADX WARN: Code duplicated, block: B:153:0x03cc  */
    /* JADX WARN: Code duplicated, block: B:155:0x03d2  */
    /* JADX WARN: Code duplicated, block: B:161:0x03e5  */
    /* JADX WARN: Code duplicated, block: B:163:0x03ed  */
    /* JADX WARN: Code duplicated, block: B:166:0x040b  */
    /* JADX WARN: Code duplicated, block: B:168:0x0411  */
    /* JADX WARN: Code duplicated, block: B:174:0x0423  */
    /* JADX WARN: Code duplicated, block: B:176:0x042b  */
    /* JADX WARN: Code duplicated, block: B:179:0x047c  */
    /* JADX WARN: Code duplicated, block: B:182:0x0488  */
    /* JADX WARN: Code duplicated, block: B:183:0x048c  */
    /* JADX WARN: Code duplicated, block: B:186:0x04b1  */
    /* JADX WARN: Code duplicated, block: B:188:0x04bf  */
    /* JADX WARN: Code duplicated, block: B:191:0x0540  */
    /* JADX WARN: Code duplicated, block: B:194:0x054c  */
    /* JADX WARN: Code duplicated, block: B:195:0x0550  */
    /* JADX WARN: Code duplicated, block: B:198:0x0575  */
    /* JADX WARN: Code duplicated, block: B:200:0x0583  */
    /* JADX WARN: Code duplicated, block: B:203:0x05ef  */
    /* JADX WARN: Code duplicated, block: B:205:0x05f7  */
    /* JADX WARN: Code duplicated, block: B:208:0x0603  */
    /* JADX WARN: Code duplicated, block: B:210:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:23:0x0047  */
    /* JADX WARN: Code duplicated, block: B:25:0x004b  */
    /* JADX WARN: Code duplicated, block: B:27:0x0053  */
    /* JADX WARN: Code duplicated, block: B:28:0x0055  */
    /* JADX WARN: Code duplicated, block: B:31:0x005b  */
    /* JADX WARN: Code duplicated, block: B:34:0x0061  */
    /* JADX WARN: Code duplicated, block: B:35:0x0064  */
    /* JADX WARN: Code duplicated, block: B:37:0x0068  */
    /* JADX WARN: Code duplicated, block: B:39:0x0070  */
    /* JADX WARN: Code duplicated, block: B:40:0x0073  */
    /* JADX WARN: Code duplicated, block: B:45:0x007d  */
    /* JADX WARN: Code duplicated, block: B:47:0x0083  */
    /* JADX WARN: Code duplicated, block: B:48:0x0086  */
    /* JADX WARN: Code duplicated, block: B:52:0x008f  */
    /* JADX WARN: Code duplicated, block: B:53:0x0091  */
    /* JADX WARN: Code duplicated, block: B:56:0x009a  */
    /* JADX WARN: Code duplicated, block: B:58:0x00aa  */
    /* JADX WARN: Code duplicated, block: B:64:0x00ba A[PHI: r3 r8 r9
      0x00ba: PHI (r3v14 int) = (r3v11 int), (r3v9 int), (r3v15 int) binds: [B:70:0x00d3, B:62:0x00b6, B:63:0x00b8] A[DONT_GENERATE, DONT_INLINE]
      0x00ba: PHI (r8v24 androidx.compose.ui.Modifier) = (r8v4 androidx.compose.ui.Modifier), (r8v2 androidx.compose.ui.Modifier), (r8v2 androidx.compose.ui.Modifier) binds: [B:70:0x00d3, B:62:0x00b6, B:63:0x00b8] A[DONT_GENERATE, DONT_INLINE]
      0x00ba: PHI (r9v12 androidx.compose.material3.DrawerState) = 
      (r9v9 androidx.compose.material3.DrawerState)
      (r9v6 androidx.compose.material3.DrawerState)
      (r9v6 androidx.compose.material3.DrawerState)
     binds: [B:70:0x00d3, B:62:0x00b6, B:63:0x00b8] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:65:0x00bf A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:66:0x00c1  */
    /* JADX WARN: Code duplicated, block: B:69:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:71:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:74:0x00e2  */
    /* JADX WARN: Code duplicated, block: B:77:0x00fc  */
    /* JADX WARN: Code duplicated, block: B:80:0x0135  */
    /* JADX WARN: Code duplicated, block: B:83:0x015a  */
    /* JADX WARN: Code duplicated, block: B:85:0x0160  */
    /* JADX WARN: Code duplicated, block: B:91:0x0180  */
    /* JADX WARN: Code duplicated, block: B:93:0x0188  */
    /* JADX WARN: Code duplicated, block: B:96:0x01aa  */
    /* JADX WARN: Code duplicated, block: B:98:0x01b0  */
    public static final void DismissibleNavigationDrawer(final Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, DrawerState drawerState, boolean z, Function2<? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        final DrawerState drawerStateRememberDrawerState;
        int i4;
        boolean z2;
        int i5;
        boolean z3;
        final boolean z4;
        final DrawerState drawerState2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier modifier3;
        boolean z5;
        Object objRememberedValue;
        MutableState mutableState;
        final Density density;
        Object objRememberedValue2;
        FocusRequester focusRequester;
        final FiniteAnimationSpec finiteAnimationSpecValue;
        final FiniteAnimationSpec finiteAnimationSpecValue2;
        boolean zChanged;
        Object objRememberedValue3;
        boolean z6;
        NavigationDrawerKt$DismissibleNavigationDrawer$2$1 navigationDrawerKt$DismissibleNavigationDrawer$2$1RememberedValue;
        Object objRememberedValue4;
        final CoroutineScope coroutineScope;
        final String strM5086getString2EP1pXo;
        Object objConsume;
        boolean z7;
        int currentCompositeKeyHash;
        Function0<ComposeUiNode> constructor;
        Composer composerM6062constructorimpl;
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash;
        boolean z8;
        NavigationDrawerKt$DismissibleNavigationDrawer$3$2$1 navigationDrawerKt$DismissibleNavigationDrawer$3$2$1RememberedValue;
        int currentCompositeKeyHash2;
        Function0<ComposeUiNode> constructor2;
        Composer composerM6062constructorimpl2;
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2;
        boolean zChanged2;
        Object objRememberedValue5;
        boolean zChangedInstance;
        Object objRememberedValue6;
        int currentCompositeKeyHash3;
        Function0<ComposeUiNode> constructor3;
        Composer composerM6062constructorimpl3;
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3;
        int currentCompositeKeyHash4;
        Function0<ComposeUiNode> constructor4;
        Composer composerM6062constructorimpl4;
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4;
        int i6;
        final Function2<? super Composer, ? super Integer, Unit> function4 = function3;
        Composer composerStartRestartGroup = composer.startRestartGroup(1150092038);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(DismissibleNavigationDrawer)N(drawerContent,modifier,drawerState,gesturesEnabled,content)498@20874L34,499@20940L7,500@20973L29,503@21162L7,504@21254L7,506@21278L155,506@21267L166,512@21474L178,512@21439L213,519@21670L24,520@21720L33,522@21792L7,523@21827L3133:NavigationDrawer.kt#uh7d8r");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(function2) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i7 = i2 & 2;
        if (i7 == 0) {
            if ((i & 48) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            if ((i & 384) == 0) {
                if ((i2 & 4) == 0) {
                    drawerStateRememberDrawerState = drawerState;
                    int i8 = composerStartRestartGroup.changed(drawerStateRememberDrawerState) ? 256 : 128;
                    i3 |= i8;
                } else {
                    drawerStateRememberDrawerState = drawerState;
                }
                i3 |= i8;
            } else {
                drawerStateRememberDrawerState = drawerState;
            }
            i4 = i2 & 8;
            if (i4 != 0) {
                if ((i & 3072) == 0) {
                    z2 = z;
                    if (composerStartRestartGroup.changed(z2)) {
                        i5 = 2048;
                    } else {
                        i5 = 1024;
                    }
                    i3 |= i5;
                }
                if ((i & 24576) == 0) {
                    if (composerStartRestartGroup.changedInstance(function4)) {
                        i6 = 16384;
                    } else {
                        i6 = 8192;
                    }
                    i3 |= i6;
                }
                if ((i3 & 9363) != 9362) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "494@20725L39");
                    if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                        if (i7 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                            drawerStateRememberDrawerState = rememberDrawerState(DrawerValue.Closed, null, composerStartRestartGroup, 6, 2);
                        }
                        if (i4 != 0) {
                            modifier3 = modifier2;
                            z5 = true;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1150092038, i3, -1, "androidx.compose.material3.DismissibleNavigationDrawer (NavigationDrawer.kt:497)");
                        }
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1431862792, "CC(remember):NavigationDrawer.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        mutableState = (MutableState) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object objConsume2 = composerStartRestartGroup.consume(localDensity);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        density = (Density) objConsume2;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1431865955, "CC(remember):NavigationDrawer.kt#9igjgp");
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue2 = new FocusRequester();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        focusRequester = (FocusRequester) objRememberedValue2;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        finiteAnimationSpecValue = MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultSpatial, composerStartRestartGroup, 6);
                        finiteAnimationSpecValue2 = MotionSchemeKt.value(MotionSchemeKeyTokens.FastEffects, composerStartRestartGroup, 6);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1431875841, "CC(remember):NavigationDrawer.kt#9igjgp");
                        int i9 = (i3 & 896) ^ 384;
                        zChanged = ((i9 <= 256 && composerStartRestartGroup.changed(drawerStateRememberDrawerState)) || (i3 & 384) == 256) | composerStartRestartGroup.changed(density) | composerStartRestartGroup.changedInstance(finiteAnimationSpecValue) | composerStartRestartGroup.changedInstance(finiteAnimationSpecValue2);
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda29
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return NavigationDrawerKt.DismissibleNavigationDrawer$lambda$4$0(drawerStateRememberDrawerState, density, finiteAnimationSpecValue, finiteAnimationSpecValue2);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        EffectsKt.SideEffect((Function0) objRememberedValue3, composerStartRestartGroup, 0);
                        Boolean boolValueOf = Boolean.valueOf(drawerStateRememberDrawerState.isOpen());
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1431882136, "CC(remember):NavigationDrawer.kt#9igjgp");
                        z6 = (i9 <= 256 && composerStartRestartGroup.changed(drawerStateRememberDrawerState)) || (i3 & 384) == 256;
                        navigationDrawerKt$DismissibleNavigationDrawer$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!z6 || navigationDrawerKt$DismissibleNavigationDrawer$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                            navigationDrawerKt$DismissibleNavigationDrawer$2$1RememberedValue = new NavigationDrawerKt$DismissibleNavigationDrawer$2$1(drawerStateRememberDrawerState, focusRequester, null);
                            composerStartRestartGroup.updateRememberedValue(navigationDrawerKt$DismissibleNavigationDrawer$2$1RememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        EffectsKt.LaunchedEffect(boolValueOf, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) navigationDrawerKt$DismissibleNavigationDrawer$2$1RememberedValue, composerStartRestartGroup, 0);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 773894976, "CC(rememberCoroutineScope)N(getContext)608@27648L68:Effects.kt#9igjgp");
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 683737348, "CC(remember):Effects.kt#9igjgp");
                        objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue4 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        }
                        coroutineScope = (CoroutineScope) objRememberedValue4;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        Strings.Companion companion = Strings.INSTANCE;
                        strM5086getString2EP1pXo = Strings_androidKt.m5086getString2EP1pXo(Strings.m5002constructorimpl(androidx.compose.ui.R.string.navigation_menu), composerStartRestartGroup, 0);
                        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        objConsume = composerStartRestartGroup.consume(localLayoutDirection);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if (objConsume == LayoutDirection.Rtl) {
                            z7 = true;
                        } else {
                            z7 = false;
                        }
                        Modifier modifierAnchoredDraggable$default = AnchoredDraggableKt.anchoredDraggable$default(modifier3, drawerStateRememberDrawerState.getAnchoredDraggableState$material3(), z7, Orientation.Horizontal, z5, (MutableInteractionSource) null, (OverscrollEffect) null, (FlingBehavior) null, 112, (Object) null);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                        CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierAnchoredDraggable$default);
                        constructor = ComposeUiNode.INSTANCE.getConstructor();
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
                        composerM6062constructorimpl = Updater.m6062constructorimpl(composerStartRestartGroup);
                        Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (!composerM6062constructorimpl.getInserting() || !Intrinsics.areEqual(composerM6062constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                            composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        }
                        Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -901198438, "C563@23432L1522,531@22077L2877:NavigationDrawer.kt#uh7d8r");
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1691596898, "CC(remember):NavigationDrawer.kt#9igjgp");
                        z8 = (i9 <= 256 && composerStartRestartGroup.changed(drawerStateRememberDrawerState)) || (i3 & 384) == 256;
                        navigationDrawerKt$DismissibleNavigationDrawer$3$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!z8 || navigationDrawerKt$DismissibleNavigationDrawer$3$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                            navigationDrawerKt$DismissibleNavigationDrawer$3$2$1RememberedValue = new NavigationDrawerKt$DismissibleNavigationDrawer$3$2$1(drawerStateRememberDrawerState, mutableState);
                            composerStartRestartGroup.updateRememberedValue(navigationDrawerKt$DismissibleNavigationDrawer$3$2$1RememberedValue);
                        }
                        MeasurePolicy measurePolicy = (MeasurePolicy) navigationDrawerKt$DismissibleNavigationDrawer$3$2$1RememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                        Modifier.Companion companion2 = Modifier.INSTANCE;
                        currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                        CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion2);
                        constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                        if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startReusableNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.createNode(constructor2);
                        } else {
                            composerStartRestartGroup.useNode();
                        }
                        composerM6062constructorimpl2 = Updater.m6062constructorimpl(composerStartRestartGroup);
                        Updater.m6070setimpl(composerM6062constructorimpl2, measurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m6070setimpl(composerM6062constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (!composerM6062constructorimpl2.getInserting() || !Intrinsics.areEqual(composerM6062constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                            composerM6062constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                            composerM6062constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                        }
                        Updater.m6070setimpl(composerM6062constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1778140254, "C534@22169L492,545@22698L545,533@22125L1248,561@23390L17:NavigationDrawer.kt#uh7d8r");
                        Modifier.Companion companion3 = Modifier.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2020850001, "CC(remember):NavigationDrawer.kt#9igjgp");
                        zChanged2 = composerStartRestartGroup.changed(strM5086getString2EP1pXo) | ((i9 <= 256 && composerStartRestartGroup.changed(drawerStateRememberDrawerState)) || (i3 & 384) == 256) | composerStartRestartGroup.changedInstance(coroutineScope);
                        objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged2 || objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue5 = new Function1() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda30
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return NavigationDrawerKt.DismissibleNavigationDrawer$lambda$6$0$0$0(strM5086getString2EP1pXo, drawerStateRememberDrawerState, coroutineScope, (SemanticsPropertyReceiver) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        Modifier modifierSemantics$default = SemanticsModifierKt.semantics$default(companion3, false, (Function1) objRememberedValue5, 1, null);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2020833020, "CC(remember):NavigationDrawer.kt#9igjgp");
                        zChangedInstance = composerStartRestartGroup.changedInstance(coroutineScope) | ((i9 <= 256 && composerStartRestartGroup.changed(drawerStateRememberDrawerState)) || (i3 & 384) == 256);
                        objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                        if (!zChangedInstance || objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue6 = (Function1) new Function1<KeyEvent, Boolean>() { // from class: androidx.compose.material3.NavigationDrawerKt$DismissibleNavigationDrawer$3$1$2$1
                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Boolean invoke(KeyEvent keyEvent) {
                                    return m3871invokeZmokQxo(keyEvent.m7966unboximpl());
                                }

                                /* JADX INFO: renamed from: invoke-ZmokQxo, reason: not valid java name */
                                public final Boolean m3871invokeZmokQxo(android.view.KeyEvent keyEvent) {
                                    if (drawerStateRememberDrawerState.isOpen() && KeyEventType.m7970equalsimpl0(KeyEvent_androidKt.m7978getTypeZmokQxo(keyEvent), KeyEventType.INSTANCE.m7975getKeyUpCS__XNY()) && Key.m7669equalsimpl0(KeyEvent_androidKt.m7977getKeyZmokQxo(keyEvent), Key.INSTANCE.m7758getEscapeEK5gGoQ())) {
                                        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new AnonymousClass1(drawerStateRememberDrawerState, null), 3, null);
                                        return true;
                                    }
                                    return false;
                                }

                                /* JADX INFO: renamed from: androidx.compose.material3.NavigationDrawerKt$DismissibleNavigationDrawer$3$1$2$1$1, reason: invalid class name */
                                /* JADX INFO: compiled from: NavigationDrawer.kt */
                                @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
                                @DebugMetadata(c = "androidx.compose.material3.NavigationDrawerKt$DismissibleNavigationDrawer$3$1$2$1$1", f = "NavigationDrawer.kt", i = {}, l = {553}, m = "invokeSuspend", n = {}, s = {}, v = 1)
                                static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                    final /* synthetic */ DrawerState $drawerState;
                                    int label;

                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    AnonymousClass1(DrawerState drawerState, Continuation<? super AnonymousClass1> continuation) {
                                        super(2, continuation);
                                        this.$drawerState = drawerState;
                                    }

                                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                        return new AnonymousClass1(this.$drawerState, continuation);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                        return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                    }

                                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                    public final Object invokeSuspend(Object obj) {
                                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                        int i = this.label;
                                        if (i == 0) {
                                            ResultKt.throwOnFailure(obj);
                                            this.label = 1;
                                            if (this.$drawerState.close(this) == coroutine_suspended) {
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
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        Modifier modifierFocusRequester = FocusRequesterModifierKt.focusRequester(KeyInputModifierKt.onKeyEvent(modifierSemantics$default, (Function1) objRememberedValue6), focusRequester);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                        currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                        CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFocusRequester);
                        constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                        if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startReusableNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.createNode(constructor3);
                        } else {
                            composerStartRestartGroup.useNode();
                        }
                        composerM6062constructorimpl3 = Updater.m6062constructorimpl(composerStartRestartGroup);
                        Updater.m6070setimpl(composerM6062constructorimpl3, measurePolicyMaybeCachedBoxMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m6070setimpl(composerM6062constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (!composerM6062constructorimpl3.getInserting() || !Intrinsics.areEqual(composerM6062constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                            composerM6062constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                            composerM6062constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                        }
                        Updater.m6070setimpl(composerM6062constructorimpl3, modifierMaterializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1897277909, "C559@23340L15:NavigationDrawer.kt#uh7d8r");
                        function2.invoke(composerStartRestartGroup, Integer.valueOf(i3 & 14));
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                        Modifier.Companion companion4 = Modifier.INSTANCE;
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                        currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                        CompositionLocalMap currentCompositionLocalMap4 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion4);
                        constructor4 = ComposeUiNode.INSTANCE.getConstructor();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                        if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composerStartRestartGroup.startReusableNode();
                        if (composerStartRestartGroup.getInserting()) {
                            composerStartRestartGroup.createNode(constructor4);
                        } else {
                            composerStartRestartGroup.useNode();
                        }
                        composerM6062constructorimpl4 = Updater.m6062constructorimpl(composerStartRestartGroup);
                        Updater.m6070setimpl(composerM6062constructorimpl4, measurePolicyMaybeCachedBoxMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m6070setimpl(composerM6062constructorimpl4, currentCompositionLocalMap4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        setCompositeKeyHash4 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (!composerM6062constructorimpl4.getInserting() || !Intrinsics.areEqual(composerM6062constructorimpl4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                            composerM6062constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                            composerM6062constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
                        }
                        Updater.m6070setimpl(composerM6062constructorimpl4, modifierMaterializeModifier4, ComposeUiNode.INSTANCE.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -272067686, "C561@23396L9:NavigationDrawer.kt#uh7d8r");
                        function4 = function3;
                        function4.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 12) & 14));
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier2 = modifier3;
                        z4 = z5;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                        }
                    }
                    modifier3 = modifier2;
                    z5 = z2;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1150092038, i3, -1, "androidx.compose.material3.DismissibleNavigationDrawer (NavigationDrawer.kt:497)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1431862792, "CC(remember):NavigationDrawer.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    mutableState = (MutableState) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ProvidableCompositionLocal<Density> localDensity2 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume3 = composerStartRestartGroup.consume(localDensity2);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    density = (Density) objConsume3;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1431865955, "CC(remember):NavigationDrawer.kt#9igjgp");
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = new FocusRequester();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    focusRequester = (FocusRequester) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    finiteAnimationSpecValue = MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultSpatial, composerStartRestartGroup, 6);
                    finiteAnimationSpecValue2 = MotionSchemeKt.value(MotionSchemeKeyTokens.FastEffects, composerStartRestartGroup, 6);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1431875841, "CC(remember):NavigationDrawer.kt#9igjgp");
                    int i10 = (i3 & 896) ^ 384;
                    zChanged = ((i10 <= 256 && composerStartRestartGroup.changed(drawerStateRememberDrawerState)) || (i3 & 384) == 256) | composerStartRestartGroup.changed(density) | composerStartRestartGroup.changedInstance(finiteAnimationSpecValue) | composerStartRestartGroup.changedInstance(finiteAnimationSpecValue2);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda29
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return NavigationDrawerKt.DismissibleNavigationDrawer$lambda$4$0(drawerStateRememberDrawerState, density, finiteAnimationSpecValue, finiteAnimationSpecValue2);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda29
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return NavigationDrawerKt.DismissibleNavigationDrawer$lambda$4$0(drawerStateRememberDrawerState, density, finiteAnimationSpecValue, finiteAnimationSpecValue2);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    EffectsKt.SideEffect((Function0) objRememberedValue3, composerStartRestartGroup, 0);
                    Boolean boolValueOf2 = Boolean.valueOf(drawerStateRememberDrawerState.isOpen());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1431882136, "CC(remember):NavigationDrawer.kt#9igjgp");
                    if (i10 <= 256) {
                    }
                    navigationDrawerKt$DismissibleNavigationDrawer$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z6) {
                        navigationDrawerKt$DismissibleNavigationDrawer$2$1RememberedValue = new NavigationDrawerKt$DismissibleNavigationDrawer$2$1(drawerStateRememberDrawerState, focusRequester, null);
                        composerStartRestartGroup.updateRememberedValue(navigationDrawerKt$DismissibleNavigationDrawer$2$1RememberedValue);
                    } else {
                        navigationDrawerKt$DismissibleNavigationDrawer$2$1RememberedValue = new NavigationDrawerKt$DismissibleNavigationDrawer$2$1(drawerStateRememberDrawerState, focusRequester, null);
                        composerStartRestartGroup.updateRememberedValue(navigationDrawerKt$DismissibleNavigationDrawer$2$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    EffectsKt.LaunchedEffect(boolValueOf2, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) navigationDrawerKt$DismissibleNavigationDrawer$2$1RememberedValue, composerStartRestartGroup, 0);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 773894976, "CC(rememberCoroutineScope)N(getContext)608@27648L68:Effects.kt#9igjgp");
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 683737348, "CC(remember):Effects.kt#9igjgp");
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue4 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    coroutineScope = (CoroutineScope) objRememberedValue4;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Strings.Companion companion5 = Strings.INSTANCE;
                    strM5086getString2EP1pXo = Strings_androidKt.m5086getString2EP1pXo(Strings.m5002constructorimpl(androidx.compose.ui.R.string.navigation_menu), composerStartRestartGroup, 0);
                    ProvidableCompositionLocal<LayoutDirection> localLayoutDirection2 = CompositionLocalsKt.getLocalLayoutDirection();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    objConsume = composerStartRestartGroup.consume(localLayoutDirection2);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (objConsume == LayoutDirection.Rtl) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                    Modifier modifierAnchoredDraggable$default2 = AnchoredDraggableKt.anchoredDraggable$default(modifier3, drawerStateRememberDrawerState.getAnchoredDraggableState$material3(), z7, Orientation.Horizontal, z5, (MutableInteractionSource) null, (OverscrollEffect) null, (FlingBehavior) null, 112, (Object) null);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy4 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap5 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier5 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierAnchoredDraggable$default2);
                    constructor = ComposeUiNode.INSTANCE.getConstructor();
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
                    composerM6062constructorimpl = Updater.m6062constructorimpl(composerStartRestartGroup);
                    Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy4, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap5, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (!composerM6062constructorimpl.getInserting()) {
                        composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    } else {
                        composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier5, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance4 = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -901198438, "C563@23432L1522,531@22077L2877:NavigationDrawer.kt#uh7d8r");
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1691596898, "CC(remember):NavigationDrawer.kt#9igjgp");
                    if (i10 <= 256) {
                    }
                    navigationDrawerKt$DismissibleNavigationDrawer$3$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z8) {
                        navigationDrawerKt$DismissibleNavigationDrawer$3$2$1RememberedValue = new NavigationDrawerKt$DismissibleNavigationDrawer$3$2$1(drawerStateRememberDrawerState, mutableState);
                        composerStartRestartGroup.updateRememberedValue(navigationDrawerKt$DismissibleNavigationDrawer$3$2$1RememberedValue);
                    } else {
                        navigationDrawerKt$DismissibleNavigationDrawer$3$2$1RememberedValue = new NavigationDrawerKt$DismissibleNavigationDrawer$3$2$1(drawerStateRememberDrawerState, mutableState);
                        composerStartRestartGroup.updateRememberedValue(navigationDrawerKt$DismissibleNavigationDrawer$3$2$1RememberedValue);
                    }
                    MeasurePolicy measurePolicy2 = (MeasurePolicy) navigationDrawerKt$DismissibleNavigationDrawer$3$2$1RememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                    Modifier.Companion companion6 = Modifier.INSTANCE;
                    currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap6 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier6 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion6);
                    constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                    if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor2);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    composerM6062constructorimpl2 = Updater.m6062constructorimpl(composerStartRestartGroup);
                    Updater.m6070setimpl(composerM6062constructorimpl2, measurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m6070setimpl(composerM6062constructorimpl2, currentCompositionLocalMap6, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (!composerM6062constructorimpl2.getInserting()) {
                        composerM6062constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                        composerM6062constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                    } else {
                        composerM6062constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                        composerM6062constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                    }
                    Updater.m6070setimpl(composerM6062constructorimpl2, modifierMaterializeModifier6, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1778140254, "C534@22169L492,545@22698L545,533@22125L1248,561@23390L17:NavigationDrawer.kt#uh7d8r");
                    Modifier.Companion companion7 = Modifier.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2020850001, "CC(remember):NavigationDrawer.kt#9igjgp");
                    zChanged2 = composerStartRestartGroup.changed(strM5086getString2EP1pXo) | ((i10 <= 256 && composerStartRestartGroup.changed(drawerStateRememberDrawerState)) || (i3 & 384) == 256) | composerStartRestartGroup.changedInstance(coroutineScope);
                    objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged2) {
                        objRememberedValue5 = new Function1() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda30
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return NavigationDrawerKt.DismissibleNavigationDrawer$lambda$6$0$0$0(strM5086getString2EP1pXo, drawerStateRememberDrawerState, coroutineScope, (SemanticsPropertyReceiver) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                    } else {
                        objRememberedValue5 = new Function1() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda30
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return NavigationDrawerKt.DismissibleNavigationDrawer$lambda$6$0$0$0(strM5086getString2EP1pXo, drawerStateRememberDrawerState, coroutineScope, (SemanticsPropertyReceiver) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Modifier modifierSemantics$default2 = SemanticsModifierKt.semantics$default(companion7, false, (Function1) objRememberedValue5, 1, null);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2020833020, "CC(remember):NavigationDrawer.kt#9igjgp");
                    zChangedInstance = composerStartRestartGroup.changedInstance(coroutineScope) | ((i10 <= 256 && composerStartRestartGroup.changed(drawerStateRememberDrawerState)) || (i3 & 384) == 256);
                    objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                    if (!zChangedInstance) {
                        objRememberedValue6 = (Function1) new Function1<KeyEvent, Boolean>() { // from class: androidx.compose.material3.NavigationDrawerKt$DismissibleNavigationDrawer$3$1$2$1
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Boolean invoke(KeyEvent keyEvent) {
                                return m3871invokeZmokQxo(keyEvent.m7966unboximpl());
                            }

                            /* JADX INFO: renamed from: invoke-ZmokQxo, reason: not valid java name */
                            public final Boolean m3871invokeZmokQxo(android.view.KeyEvent keyEvent) {
                                if (drawerStateRememberDrawerState.isOpen() && KeyEventType.m7970equalsimpl0(KeyEvent_androidKt.m7978getTypeZmokQxo(keyEvent), KeyEventType.INSTANCE.m7975getKeyUpCS__XNY()) && Key.m7669equalsimpl0(KeyEvent_androidKt.m7977getKeyZmokQxo(keyEvent), Key.INSTANCE.m7758getEscapeEK5gGoQ())) {
                                    BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new AnonymousClass1(drawerStateRememberDrawerState, null), 3, null);
                                    return true;
                                }
                                return false;
                            }

                            /* JADX INFO: renamed from: androidx.compose.material3.NavigationDrawerKt$DismissibleNavigationDrawer$3$1$2$1$1, reason: invalid class name */
                            /* JADX INFO: compiled from: NavigationDrawer.kt */
                            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
                            @DebugMetadata(c = "androidx.compose.material3.NavigationDrawerKt$DismissibleNavigationDrawer$3$1$2$1$1", f = "NavigationDrawer.kt", i = {}, l = {553}, m = "invokeSuspend", n = {}, s = {}, v = 1)
                            static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                final /* synthetic */ DrawerState $drawerState;
                                int label;

                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                AnonymousClass1(DrawerState drawerState, Continuation<? super AnonymousClass1> continuation) {
                                    super(2, continuation);
                                    this.$drawerState = drawerState;
                                }

                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                    return new AnonymousClass1(this.$drawerState, continuation);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                    return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                }

                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                public final Object invokeSuspend(Object obj) {
                                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                    int i = this.label;
                                    if (i == 0) {
                                        ResultKt.throwOnFailure(obj);
                                        this.label = 1;
                                        if (this.$drawerState.close(this) == coroutine_suspended) {
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
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                    } else {
                        objRememberedValue6 = (Function1) new Function1<KeyEvent, Boolean>() { // from class: androidx.compose.material3.NavigationDrawerKt$DismissibleNavigationDrawer$3$1$2$1
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Boolean invoke(KeyEvent keyEvent) {
                                return m3871invokeZmokQxo(keyEvent.m7966unboximpl());
                            }

                            /* JADX INFO: renamed from: invoke-ZmokQxo, reason: not valid java name */
                            public final Boolean m3871invokeZmokQxo(android.view.KeyEvent keyEvent) {
                                if (drawerStateRememberDrawerState.isOpen() && KeyEventType.m7970equalsimpl0(KeyEvent_androidKt.m7978getTypeZmokQxo(keyEvent), KeyEventType.INSTANCE.m7975getKeyUpCS__XNY()) && Key.m7669equalsimpl0(KeyEvent_androidKt.m7977getKeyZmokQxo(keyEvent), Key.INSTANCE.m7758getEscapeEK5gGoQ())) {
                                    BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new AnonymousClass1(drawerStateRememberDrawerState, null), 3, null);
                                    return true;
                                }
                                return false;
                            }

                            /* JADX INFO: renamed from: androidx.compose.material3.NavigationDrawerKt$DismissibleNavigationDrawer$3$1$2$1$1, reason: invalid class name */
                            /* JADX INFO: compiled from: NavigationDrawer.kt */
                            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
                            @DebugMetadata(c = "androidx.compose.material3.NavigationDrawerKt$DismissibleNavigationDrawer$3$1$2$1$1", f = "NavigationDrawer.kt", i = {}, l = {553}, m = "invokeSuspend", n = {}, s = {}, v = 1)
                            static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                final /* synthetic */ DrawerState $drawerState;
                                int label;

                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                AnonymousClass1(DrawerState drawerState, Continuation<? super AnonymousClass1> continuation) {
                                    super(2, continuation);
                                    this.$drawerState = drawerState;
                                }

                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                    return new AnonymousClass1(this.$drawerState, continuation);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                    return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                }

                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                public final Object invokeSuspend(Object obj) {
                                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                    int i = this.label;
                                    if (i == 0) {
                                        ResultKt.throwOnFailure(obj);
                                        this.label = 1;
                                        if (this.$drawerState.close(this) == coroutine_suspended) {
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
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Modifier modifierFocusRequester2 = FocusRequesterModifierKt.focusRequester(KeyInputModifierKt.onKeyEvent(modifierSemantics$default2, (Function1) objRememberedValue6), focusRequester);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy5 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                    currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap7 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier7 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFocusRequester2);
                    constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                    if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor3);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    composerM6062constructorimpl3 = Updater.m6062constructorimpl(composerStartRestartGroup);
                    Updater.m6070setimpl(composerM6062constructorimpl3, measurePolicyMaybeCachedBoxMeasurePolicy5, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m6070setimpl(composerM6062constructorimpl3, currentCompositionLocalMap7, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (!composerM6062constructorimpl3.getInserting()) {
                        composerM6062constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                        composerM6062constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                    } else {
                        composerM6062constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                        composerM6062constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                    }
                    Updater.m6070setimpl(composerM6062constructorimpl3, modifierMaterializeModifier7, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance5 = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1897277909, "C559@23340L15:NavigationDrawer.kt#uh7d8r");
                    function2.invoke(composerStartRestartGroup, Integer.valueOf(i3 & 14));
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                    Modifier.Companion companion8 = Modifier.INSTANCE;
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy6 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                    currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap8 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier8 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion8);
                    constructor4 = ComposeUiNode.INSTANCE.getConstructor();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                    if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor4);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    composerM6062constructorimpl4 = Updater.m6062constructorimpl(composerStartRestartGroup);
                    Updater.m6070setimpl(composerM6062constructorimpl4, measurePolicyMaybeCachedBoxMeasurePolicy6, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m6070setimpl(composerM6062constructorimpl4, currentCompositionLocalMap8, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    setCompositeKeyHash4 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (!composerM6062constructorimpl4.getInserting()) {
                        composerM6062constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                        composerM6062constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
                    } else {
                        composerM6062constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                        composerM6062constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
                    }
                    Updater.m6070setimpl(composerM6062constructorimpl4, modifierMaterializeModifier8, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance6 = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -272067686, "C561@23396L9:NavigationDrawer.kt#uh7d8r");
                    function4 = function3;
                    function4.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 12) & 14));
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier2 = modifier3;
                    z4 = z5;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    z4 = z2;
                }
                drawerState2 = drawerStateRememberDrawerState;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    final Modifier modifier4 = modifier2;
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda31
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return NavigationDrawerKt.DismissibleNavigationDrawer$lambda$7(function2, modifier4, drawerState2, z4, function4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 3072;
            z2 = z;
            if ((i & 24576) == 0) {
                if (composerStartRestartGroup.changedInstance(function4)) {
                    i6 = 16384;
                } else {
                    i6 = 8192;
                }
                i3 |= i6;
            }
            if ((i3 & 9363) != 9362) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "494@20725L39");
                if ((i & 1) != 0) {
                    if (i7 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                        drawerStateRememberDrawerState = rememberDrawerState(DrawerValue.Closed, null, composerStartRestartGroup, 6, 2);
                    }
                    if (i4 != 0) {
                        modifier3 = modifier2;
                        z5 = true;
                    } else {
                        modifier3 = modifier2;
                        z5 = z2;
                    }
                } else {
                    if (i7 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                        drawerStateRememberDrawerState = rememberDrawerState(DrawerValue.Closed, null, composerStartRestartGroup, 6, 2);
                    }
                    if (i4 != 0) {
                        modifier3 = modifier2;
                        z5 = true;
                    } else {
                        modifier3 = modifier2;
                        z5 = z2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1150092038, i3, -1, "androidx.compose.material3.DismissibleNavigationDrawer (NavigationDrawer.kt:497)");
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1431862792, "CC(remember):NavigationDrawer.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                mutableState = (MutableState) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ProvidableCompositionLocal<Density> localDensity3 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume4 = composerStartRestartGroup.consume(localDensity3);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                density = (Density) objConsume4;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1431865955, "CC(remember):NavigationDrawer.kt#9igjgp");
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new FocusRequester();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                focusRequester = (FocusRequester) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                finiteAnimationSpecValue = MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultSpatial, composerStartRestartGroup, 6);
                finiteAnimationSpecValue2 = MotionSchemeKt.value(MotionSchemeKeyTokens.FastEffects, composerStartRestartGroup, 6);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1431875841, "CC(remember):NavigationDrawer.kt#9igjgp");
                int i11 = (i3 & 896) ^ 384;
                zChanged = ((i11 <= 256 && composerStartRestartGroup.changed(drawerStateRememberDrawerState)) || (i3 & 384) == 256) | composerStartRestartGroup.changed(density) | composerStartRestartGroup.changedInstance(finiteAnimationSpecValue) | composerStartRestartGroup.changedInstance(finiteAnimationSpecValue2);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda29
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return NavigationDrawerKt.DismissibleNavigationDrawer$lambda$4$0(drawerStateRememberDrawerState, density, finiteAnimationSpecValue, finiteAnimationSpecValue2);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda29
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return NavigationDrawerKt.DismissibleNavigationDrawer$lambda$4$0(drawerStateRememberDrawerState, density, finiteAnimationSpecValue, finiteAnimationSpecValue2);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.SideEffect((Function0) objRememberedValue3, composerStartRestartGroup, 0);
                Boolean boolValueOf3 = Boolean.valueOf(drawerStateRememberDrawerState.isOpen());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1431882136, "CC(remember):NavigationDrawer.kt#9igjgp");
                if (i11 <= 256) {
                }
                navigationDrawerKt$DismissibleNavigationDrawer$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z6) {
                    navigationDrawerKt$DismissibleNavigationDrawer$2$1RememberedValue = new NavigationDrawerKt$DismissibleNavigationDrawer$2$1(drawerStateRememberDrawerState, focusRequester, null);
                    composerStartRestartGroup.updateRememberedValue(navigationDrawerKt$DismissibleNavigationDrawer$2$1RememberedValue);
                } else {
                    navigationDrawerKt$DismissibleNavigationDrawer$2$1RememberedValue = new NavigationDrawerKt$DismissibleNavigationDrawer$2$1(drawerStateRememberDrawerState, focusRequester, null);
                    composerStartRestartGroup.updateRememberedValue(navigationDrawerKt$DismissibleNavigationDrawer$2$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.LaunchedEffect(boolValueOf3, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) navigationDrawerKt$DismissibleNavigationDrawer$2$1RememberedValue, composerStartRestartGroup, 0);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 773894976, "CC(rememberCoroutineScope)N(getContext)608@27648L68:Effects.kt#9igjgp");
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 683737348, "CC(remember):Effects.kt#9igjgp");
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue4 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                coroutineScope = (CoroutineScope) objRememberedValue4;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Strings.Companion companion9 = Strings.INSTANCE;
                strM5086getString2EP1pXo = Strings_androidKt.m5086getString2EP1pXo(Strings.m5002constructorimpl(androidx.compose.ui.R.string.navigation_menu), composerStartRestartGroup, 0);
                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection3 = CompositionLocalsKt.getLocalLayoutDirection();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                objConsume = composerStartRestartGroup.consume(localLayoutDirection3);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (objConsume == LayoutDirection.Rtl) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                Modifier modifierAnchoredDraggable$default3 = AnchoredDraggableKt.anchoredDraggable$default(modifier3, drawerStateRememberDrawerState.getAnchoredDraggableState$material3(), z7, Orientation.Horizontal, z5, (MutableInteractionSource) null, (OverscrollEffect) null, (FlingBehavior) null, 112, (Object) null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy7 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap9 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier9 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierAnchoredDraggable$default3);
                constructor = ComposeUiNode.INSTANCE.getConstructor();
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
                composerM6062constructorimpl = Updater.m6062constructorimpl(composerStartRestartGroup);
                Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy7, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap9, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!composerM6062constructorimpl.getInserting()) {
                    composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                } else {
                    composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier9, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance7 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -901198438, "C563@23432L1522,531@22077L2877:NavigationDrawer.kt#uh7d8r");
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1691596898, "CC(remember):NavigationDrawer.kt#9igjgp");
                if (i11 <= 256) {
                }
                navigationDrawerKt$DismissibleNavigationDrawer$3$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z8) {
                    navigationDrawerKt$DismissibleNavigationDrawer$3$2$1RememberedValue = new NavigationDrawerKt$DismissibleNavigationDrawer$3$2$1(drawerStateRememberDrawerState, mutableState);
                    composerStartRestartGroup.updateRememberedValue(navigationDrawerKt$DismissibleNavigationDrawer$3$2$1RememberedValue);
                } else {
                    navigationDrawerKt$DismissibleNavigationDrawer$3$2$1RememberedValue = new NavigationDrawerKt$DismissibleNavigationDrawer$3$2$1(drawerStateRememberDrawerState, mutableState);
                    composerStartRestartGroup.updateRememberedValue(navigationDrawerKt$DismissibleNavigationDrawer$3$2$1RememberedValue);
                }
                MeasurePolicy measurePolicy3 = (MeasurePolicy) navigationDrawerKt$DismissibleNavigationDrawer$3$2$1RememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                Modifier.Companion companion10 = Modifier.INSTANCE;
                currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap10 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier10 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion10);
                constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor2);
                } else {
                    composerStartRestartGroup.useNode();
                }
                composerM6062constructorimpl2 = Updater.m6062constructorimpl(composerStartRestartGroup);
                Updater.m6070setimpl(composerM6062constructorimpl2, measurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl2, currentCompositionLocalMap10, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!composerM6062constructorimpl2.getInserting()) {
                    composerM6062constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    composerM6062constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                } else {
                    composerM6062constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    composerM6062constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                }
                Updater.m6070setimpl(composerM6062constructorimpl2, modifierMaterializeModifier10, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1778140254, "C534@22169L492,545@22698L545,533@22125L1248,561@23390L17:NavigationDrawer.kt#uh7d8r");
                Modifier.Companion companion11 = Modifier.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2020850001, "CC(remember):NavigationDrawer.kt#9igjgp");
                zChanged2 = composerStartRestartGroup.changed(strM5086getString2EP1pXo) | ((i11 <= 256 && composerStartRestartGroup.changed(drawerStateRememberDrawerState)) || (i3 & 384) == 256) | composerStartRestartGroup.changedInstance(coroutineScope);
                objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                if (!zChanged2) {
                    objRememberedValue5 = new Function1() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda30
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return NavigationDrawerKt.DismissibleNavigationDrawer$lambda$6$0$0$0(strM5086getString2EP1pXo, drawerStateRememberDrawerState, coroutineScope, (SemanticsPropertyReceiver) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                } else {
                    objRememberedValue5 = new Function1() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda30
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return NavigationDrawerKt.DismissibleNavigationDrawer$lambda$6$0$0$0(strM5086getString2EP1pXo, drawerStateRememberDrawerState, coroutineScope, (SemanticsPropertyReceiver) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifierSemantics$default3 = SemanticsModifierKt.semantics$default(companion11, false, (Function1) objRememberedValue5, 1, null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2020833020, "CC(remember):NavigationDrawer.kt#9igjgp");
                zChangedInstance = composerStartRestartGroup.changedInstance(coroutineScope) | ((i11 <= 256 && composerStartRestartGroup.changed(drawerStateRememberDrawerState)) || (i3 & 384) == 256);
                objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                if (!zChangedInstance) {
                    objRememberedValue6 = (Function1) new Function1<KeyEvent, Boolean>() { // from class: androidx.compose.material3.NavigationDrawerKt$DismissibleNavigationDrawer$3$1$2$1
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Boolean invoke(KeyEvent keyEvent) {
                            return m3871invokeZmokQxo(keyEvent.m7966unboximpl());
                        }

                        /* JADX INFO: renamed from: invoke-ZmokQxo, reason: not valid java name */
                        public final Boolean m3871invokeZmokQxo(android.view.KeyEvent keyEvent) {
                            if (drawerStateRememberDrawerState.isOpen() && KeyEventType.m7970equalsimpl0(KeyEvent_androidKt.m7978getTypeZmokQxo(keyEvent), KeyEventType.INSTANCE.m7975getKeyUpCS__XNY()) && Key.m7669equalsimpl0(KeyEvent_androidKt.m7977getKeyZmokQxo(keyEvent), Key.INSTANCE.m7758getEscapeEK5gGoQ())) {
                                BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new AnonymousClass1(drawerStateRememberDrawerState, null), 3, null);
                                return true;
                            }
                            return false;
                        }

                        /* JADX INFO: renamed from: androidx.compose.material3.NavigationDrawerKt$DismissibleNavigationDrawer$3$1$2$1$1, reason: invalid class name */
                        /* JADX INFO: compiled from: NavigationDrawer.kt */
                        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
                        @DebugMetadata(c = "androidx.compose.material3.NavigationDrawerKt$DismissibleNavigationDrawer$3$1$2$1$1", f = "NavigationDrawer.kt", i = {}, l = {553}, m = "invokeSuspend", n = {}, s = {}, v = 1)
                        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                            final /* synthetic */ DrawerState $drawerState;
                            int label;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            AnonymousClass1(DrawerState drawerState, Continuation<? super AnonymousClass1> continuation) {
                                super(2, continuation);
                                this.$drawerState = drawerState;
                            }

                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                return new AnonymousClass1(this.$drawerState, continuation);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                            }

                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            public final Object invokeSuspend(Object obj) {
                                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                int i = this.label;
                                if (i == 0) {
                                    ResultKt.throwOnFailure(obj);
                                    this.label = 1;
                                    if (this.$drawerState.close(this) == coroutine_suspended) {
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
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                } else {
                    objRememberedValue6 = (Function1) new Function1<KeyEvent, Boolean>() { // from class: androidx.compose.material3.NavigationDrawerKt$DismissibleNavigationDrawer$3$1$2$1
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Boolean invoke(KeyEvent keyEvent) {
                            return m3871invokeZmokQxo(keyEvent.m7966unboximpl());
                        }

                        /* JADX INFO: renamed from: invoke-ZmokQxo, reason: not valid java name */
                        public final Boolean m3871invokeZmokQxo(android.view.KeyEvent keyEvent) {
                            if (drawerStateRememberDrawerState.isOpen() && KeyEventType.m7970equalsimpl0(KeyEvent_androidKt.m7978getTypeZmokQxo(keyEvent), KeyEventType.INSTANCE.m7975getKeyUpCS__XNY()) && Key.m7669equalsimpl0(KeyEvent_androidKt.m7977getKeyZmokQxo(keyEvent), Key.INSTANCE.m7758getEscapeEK5gGoQ())) {
                                BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new AnonymousClass1(drawerStateRememberDrawerState, null), 3, null);
                                return true;
                            }
                            return false;
                        }

                        /* JADX INFO: renamed from: androidx.compose.material3.NavigationDrawerKt$DismissibleNavigationDrawer$3$1$2$1$1, reason: invalid class name */
                        /* JADX INFO: compiled from: NavigationDrawer.kt */
                        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
                        @DebugMetadata(c = "androidx.compose.material3.NavigationDrawerKt$DismissibleNavigationDrawer$3$1$2$1$1", f = "NavigationDrawer.kt", i = {}, l = {553}, m = "invokeSuspend", n = {}, s = {}, v = 1)
                        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                            final /* synthetic */ DrawerState $drawerState;
                            int label;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            AnonymousClass1(DrawerState drawerState, Continuation<? super AnonymousClass1> continuation) {
                                super(2, continuation);
                                this.$drawerState = drawerState;
                            }

                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                return new AnonymousClass1(this.$drawerState, continuation);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                            }

                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            public final Object invokeSuspend(Object obj) {
                                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                int i = this.label;
                                if (i == 0) {
                                    ResultKt.throwOnFailure(obj);
                                    this.label = 1;
                                    if (this.$drawerState.close(this) == coroutine_suspended) {
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
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifierFocusRequester3 = FocusRequesterModifierKt.focusRequester(KeyInputModifierKt.onKeyEvent(modifierSemantics$default3, (Function1) objRememberedValue6), focusRequester);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy8 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap11 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier11 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFocusRequester3);
                constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor3);
                } else {
                    composerStartRestartGroup.useNode();
                }
                composerM6062constructorimpl3 = Updater.m6062constructorimpl(composerStartRestartGroup);
                Updater.m6070setimpl(composerM6062constructorimpl3, measurePolicyMaybeCachedBoxMeasurePolicy8, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl3, currentCompositionLocalMap11, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!composerM6062constructorimpl3.getInserting()) {
                    composerM6062constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                    composerM6062constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                } else {
                    composerM6062constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                    composerM6062constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                }
                Updater.m6070setimpl(composerM6062constructorimpl3, modifierMaterializeModifier11, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance8 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1897277909, "C559@23340L15:NavigationDrawer.kt#uh7d8r");
                function2.invoke(composerStartRestartGroup, Integer.valueOf(i3 & 14));
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                Modifier.Companion companion12 = Modifier.INSTANCE;
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy9 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap12 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier12 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion12);
                constructor4 = ComposeUiNode.INSTANCE.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor4);
                } else {
                    composerStartRestartGroup.useNode();
                }
                composerM6062constructorimpl4 = Updater.m6062constructorimpl(composerStartRestartGroup);
                Updater.m6070setimpl(composerM6062constructorimpl4, measurePolicyMaybeCachedBoxMeasurePolicy9, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl4, currentCompositionLocalMap12, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                setCompositeKeyHash4 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!composerM6062constructorimpl4.getInserting()) {
                    composerM6062constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                    composerM6062constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
                } else {
                    composerM6062constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                    composerM6062constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
                }
                Updater.m6070setimpl(composerM6062constructorimpl4, modifierMaterializeModifier12, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance9 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -272067686, "C561@23396L9:NavigationDrawer.kt#uh7d8r");
                function4 = function3;
                function4.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 12) & 14));
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier2 = modifier3;
                z4 = z5;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                z4 = z2;
            }
            drawerState2 = drawerStateRememberDrawerState;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final Modifier modifier5 = modifier2;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda31
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return NavigationDrawerKt.DismissibleNavigationDrawer$lambda$7(function2, modifier5, drawerState2, z4, function4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 48;
        modifier2 = modifier;
        if ((i & 384) == 0) {
            if ((i2 & 4) == 0) {
                drawerStateRememberDrawerState = drawerState;
                if (composerStartRestartGroup.changed(drawerStateRememberDrawerState)) {
                }
                i3 |= i8;
            } else {
                drawerStateRememberDrawerState = drawerState;
            }
            i3 |= i8;
        } else {
            drawerStateRememberDrawerState = drawerState;
        }
        i4 = i2 & 8;
        if (i4 != 0) {
            if ((i & 3072) == 0) {
                z2 = z;
                if (composerStartRestartGroup.changed(z2)) {
                    i5 = 2048;
                } else {
                    i5 = 1024;
                }
                i3 |= i5;
            }
            if ((i & 24576) == 0) {
                if (composerStartRestartGroup.changedInstance(function4)) {
                    i6 = 16384;
                } else {
                    i6 = 8192;
                }
                i3 |= i6;
            }
            if ((i3 & 9363) != 9362) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "494@20725L39");
                if ((i & 1) != 0) {
                    if (i7 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                        drawerStateRememberDrawerState = rememberDrawerState(DrawerValue.Closed, null, composerStartRestartGroup, 6, 2);
                    }
                    if (i4 != 0) {
                        modifier3 = modifier2;
                        z5 = true;
                    } else {
                        modifier3 = modifier2;
                        z5 = z2;
                    }
                } else {
                    if (i7 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                        drawerStateRememberDrawerState = rememberDrawerState(DrawerValue.Closed, null, composerStartRestartGroup, 6, 2);
                    }
                    if (i4 != 0) {
                        modifier3 = modifier2;
                        z5 = true;
                    } else {
                        modifier3 = modifier2;
                        z5 = z2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1150092038, i3, -1, "androidx.compose.material3.DismissibleNavigationDrawer (NavigationDrawer.kt:497)");
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1431862792, "CC(remember):NavigationDrawer.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                mutableState = (MutableState) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ProvidableCompositionLocal<Density> localDensity4 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume5 = composerStartRestartGroup.consume(localDensity4);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                density = (Density) objConsume5;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1431865955, "CC(remember):NavigationDrawer.kt#9igjgp");
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new FocusRequester();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                focusRequester = (FocusRequester) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                finiteAnimationSpecValue = MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultSpatial, composerStartRestartGroup, 6);
                finiteAnimationSpecValue2 = MotionSchemeKt.value(MotionSchemeKeyTokens.FastEffects, composerStartRestartGroup, 6);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1431875841, "CC(remember):NavigationDrawer.kt#9igjgp");
                int i12 = (i3 & 896) ^ 384;
                zChanged = ((i12 <= 256 && composerStartRestartGroup.changed(drawerStateRememberDrawerState)) || (i3 & 384) == 256) | composerStartRestartGroup.changed(density) | composerStartRestartGroup.changedInstance(finiteAnimationSpecValue) | composerStartRestartGroup.changedInstance(finiteAnimationSpecValue2);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda29
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return NavigationDrawerKt.DismissibleNavigationDrawer$lambda$4$0(drawerStateRememberDrawerState, density, finiteAnimationSpecValue, finiteAnimationSpecValue2);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda29
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return NavigationDrawerKt.DismissibleNavigationDrawer$lambda$4$0(drawerStateRememberDrawerState, density, finiteAnimationSpecValue, finiteAnimationSpecValue2);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.SideEffect((Function0) objRememberedValue3, composerStartRestartGroup, 0);
                Boolean boolValueOf4 = Boolean.valueOf(drawerStateRememberDrawerState.isOpen());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1431882136, "CC(remember):NavigationDrawer.kt#9igjgp");
                if (i12 <= 256) {
                }
                navigationDrawerKt$DismissibleNavigationDrawer$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z6) {
                    navigationDrawerKt$DismissibleNavigationDrawer$2$1RememberedValue = new NavigationDrawerKt$DismissibleNavigationDrawer$2$1(drawerStateRememberDrawerState, focusRequester, null);
                    composerStartRestartGroup.updateRememberedValue(navigationDrawerKt$DismissibleNavigationDrawer$2$1RememberedValue);
                } else {
                    navigationDrawerKt$DismissibleNavigationDrawer$2$1RememberedValue = new NavigationDrawerKt$DismissibleNavigationDrawer$2$1(drawerStateRememberDrawerState, focusRequester, null);
                    composerStartRestartGroup.updateRememberedValue(navigationDrawerKt$DismissibleNavigationDrawer$2$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.LaunchedEffect(boolValueOf4, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) navigationDrawerKt$DismissibleNavigationDrawer$2$1RememberedValue, composerStartRestartGroup, 0);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 773894976, "CC(rememberCoroutineScope)N(getContext)608@27648L68:Effects.kt#9igjgp");
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 683737348, "CC(remember):Effects.kt#9igjgp");
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue4 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                coroutineScope = (CoroutineScope) objRememberedValue4;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Strings.Companion companion13 = Strings.INSTANCE;
                strM5086getString2EP1pXo = Strings_androidKt.m5086getString2EP1pXo(Strings.m5002constructorimpl(androidx.compose.ui.R.string.navigation_menu), composerStartRestartGroup, 0);
                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection4 = CompositionLocalsKt.getLocalLayoutDirection();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                objConsume = composerStartRestartGroup.consume(localLayoutDirection4);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (objConsume == LayoutDirection.Rtl) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                Modifier modifierAnchoredDraggable$default4 = AnchoredDraggableKt.anchoredDraggable$default(modifier3, drawerStateRememberDrawerState.getAnchoredDraggableState$material3(), z7, Orientation.Horizontal, z5, (MutableInteractionSource) null, (OverscrollEffect) null, (FlingBehavior) null, 112, (Object) null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy10 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap13 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier13 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierAnchoredDraggable$default4);
                constructor = ComposeUiNode.INSTANCE.getConstructor();
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
                composerM6062constructorimpl = Updater.m6062constructorimpl(composerStartRestartGroup);
                Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy10, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap13, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!composerM6062constructorimpl.getInserting()) {
                    composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                } else {
                    composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier13, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance10 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -901198438, "C563@23432L1522,531@22077L2877:NavigationDrawer.kt#uh7d8r");
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1691596898, "CC(remember):NavigationDrawer.kt#9igjgp");
                if (i12 <= 256) {
                }
                navigationDrawerKt$DismissibleNavigationDrawer$3$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z8) {
                    navigationDrawerKt$DismissibleNavigationDrawer$3$2$1RememberedValue = new NavigationDrawerKt$DismissibleNavigationDrawer$3$2$1(drawerStateRememberDrawerState, mutableState);
                    composerStartRestartGroup.updateRememberedValue(navigationDrawerKt$DismissibleNavigationDrawer$3$2$1RememberedValue);
                } else {
                    navigationDrawerKt$DismissibleNavigationDrawer$3$2$1RememberedValue = new NavigationDrawerKt$DismissibleNavigationDrawer$3$2$1(drawerStateRememberDrawerState, mutableState);
                    composerStartRestartGroup.updateRememberedValue(navigationDrawerKt$DismissibleNavigationDrawer$3$2$1RememberedValue);
                }
                MeasurePolicy measurePolicy4 = (MeasurePolicy) navigationDrawerKt$DismissibleNavigationDrawer$3$2$1RememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                Modifier.Companion companion14 = Modifier.INSTANCE;
                currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap14 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier14 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion14);
                constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor2);
                } else {
                    composerStartRestartGroup.useNode();
                }
                composerM6062constructorimpl2 = Updater.m6062constructorimpl(composerStartRestartGroup);
                Updater.m6070setimpl(composerM6062constructorimpl2, measurePolicy4, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl2, currentCompositionLocalMap14, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!composerM6062constructorimpl2.getInserting()) {
                    composerM6062constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    composerM6062constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                } else {
                    composerM6062constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    composerM6062constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                }
                Updater.m6070setimpl(composerM6062constructorimpl2, modifierMaterializeModifier14, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1778140254, "C534@22169L492,545@22698L545,533@22125L1248,561@23390L17:NavigationDrawer.kt#uh7d8r");
                Modifier.Companion companion15 = Modifier.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2020850001, "CC(remember):NavigationDrawer.kt#9igjgp");
                zChanged2 = composerStartRestartGroup.changed(strM5086getString2EP1pXo) | ((i12 <= 256 && composerStartRestartGroup.changed(drawerStateRememberDrawerState)) || (i3 & 384) == 256) | composerStartRestartGroup.changedInstance(coroutineScope);
                objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                if (!zChanged2) {
                    objRememberedValue5 = new Function1() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda30
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return NavigationDrawerKt.DismissibleNavigationDrawer$lambda$6$0$0$0(strM5086getString2EP1pXo, drawerStateRememberDrawerState, coroutineScope, (SemanticsPropertyReceiver) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                } else {
                    objRememberedValue5 = new Function1() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda30
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return NavigationDrawerKt.DismissibleNavigationDrawer$lambda$6$0$0$0(strM5086getString2EP1pXo, drawerStateRememberDrawerState, coroutineScope, (SemanticsPropertyReceiver) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifierSemantics$default4 = SemanticsModifierKt.semantics$default(companion15, false, (Function1) objRememberedValue5, 1, null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2020833020, "CC(remember):NavigationDrawer.kt#9igjgp");
                zChangedInstance = composerStartRestartGroup.changedInstance(coroutineScope) | ((i12 <= 256 && composerStartRestartGroup.changed(drawerStateRememberDrawerState)) || (i3 & 384) == 256);
                objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                if (!zChangedInstance) {
                    objRememberedValue6 = (Function1) new Function1<KeyEvent, Boolean>() { // from class: androidx.compose.material3.NavigationDrawerKt$DismissibleNavigationDrawer$3$1$2$1
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Boolean invoke(KeyEvent keyEvent) {
                            return m3871invokeZmokQxo(keyEvent.m7966unboximpl());
                        }

                        /* JADX INFO: renamed from: invoke-ZmokQxo, reason: not valid java name */
                        public final Boolean m3871invokeZmokQxo(android.view.KeyEvent keyEvent) {
                            if (drawerStateRememberDrawerState.isOpen() && KeyEventType.m7970equalsimpl0(KeyEvent_androidKt.m7978getTypeZmokQxo(keyEvent), KeyEventType.INSTANCE.m7975getKeyUpCS__XNY()) && Key.m7669equalsimpl0(KeyEvent_androidKt.m7977getKeyZmokQxo(keyEvent), Key.INSTANCE.m7758getEscapeEK5gGoQ())) {
                                BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new AnonymousClass1(drawerStateRememberDrawerState, null), 3, null);
                                return true;
                            }
                            return false;
                        }

                        /* JADX INFO: renamed from: androidx.compose.material3.NavigationDrawerKt$DismissibleNavigationDrawer$3$1$2$1$1, reason: invalid class name */
                        /* JADX INFO: compiled from: NavigationDrawer.kt */
                        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
                        @DebugMetadata(c = "androidx.compose.material3.NavigationDrawerKt$DismissibleNavigationDrawer$3$1$2$1$1", f = "NavigationDrawer.kt", i = {}, l = {553}, m = "invokeSuspend", n = {}, s = {}, v = 1)
                        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                            final /* synthetic */ DrawerState $drawerState;
                            int label;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            AnonymousClass1(DrawerState drawerState, Continuation<? super AnonymousClass1> continuation) {
                                super(2, continuation);
                                this.$drawerState = drawerState;
                            }

                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                return new AnonymousClass1(this.$drawerState, continuation);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                            }

                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            public final Object invokeSuspend(Object obj) {
                                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                int i = this.label;
                                if (i == 0) {
                                    ResultKt.throwOnFailure(obj);
                                    this.label = 1;
                                    if (this.$drawerState.close(this) == coroutine_suspended) {
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
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                } else {
                    objRememberedValue6 = (Function1) new Function1<KeyEvent, Boolean>() { // from class: androidx.compose.material3.NavigationDrawerKt$DismissibleNavigationDrawer$3$1$2$1
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Boolean invoke(KeyEvent keyEvent) {
                            return m3871invokeZmokQxo(keyEvent.m7966unboximpl());
                        }

                        /* JADX INFO: renamed from: invoke-ZmokQxo, reason: not valid java name */
                        public final Boolean m3871invokeZmokQxo(android.view.KeyEvent keyEvent) {
                            if (drawerStateRememberDrawerState.isOpen() && KeyEventType.m7970equalsimpl0(KeyEvent_androidKt.m7978getTypeZmokQxo(keyEvent), KeyEventType.INSTANCE.m7975getKeyUpCS__XNY()) && Key.m7669equalsimpl0(KeyEvent_androidKt.m7977getKeyZmokQxo(keyEvent), Key.INSTANCE.m7758getEscapeEK5gGoQ())) {
                                BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new AnonymousClass1(drawerStateRememberDrawerState, null), 3, null);
                                return true;
                            }
                            return false;
                        }

                        /* JADX INFO: renamed from: androidx.compose.material3.NavigationDrawerKt$DismissibleNavigationDrawer$3$1$2$1$1, reason: invalid class name */
                        /* JADX INFO: compiled from: NavigationDrawer.kt */
                        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
                        @DebugMetadata(c = "androidx.compose.material3.NavigationDrawerKt$DismissibleNavigationDrawer$3$1$2$1$1", f = "NavigationDrawer.kt", i = {}, l = {553}, m = "invokeSuspend", n = {}, s = {}, v = 1)
                        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                            final /* synthetic */ DrawerState $drawerState;
                            int label;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            AnonymousClass1(DrawerState drawerState, Continuation<? super AnonymousClass1> continuation) {
                                super(2, continuation);
                                this.$drawerState = drawerState;
                            }

                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                return new AnonymousClass1(this.$drawerState, continuation);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                            }

                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            public final Object invokeSuspend(Object obj) {
                                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                int i = this.label;
                                if (i == 0) {
                                    ResultKt.throwOnFailure(obj);
                                    this.label = 1;
                                    if (this.$drawerState.close(this) == coroutine_suspended) {
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
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifierFocusRequester4 = FocusRequesterModifierKt.focusRequester(KeyInputModifierKt.onKeyEvent(modifierSemantics$default4, (Function1) objRememberedValue6), focusRequester);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy11 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap15 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier15 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFocusRequester4);
                constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor3);
                } else {
                    composerStartRestartGroup.useNode();
                }
                composerM6062constructorimpl3 = Updater.m6062constructorimpl(composerStartRestartGroup);
                Updater.m6070setimpl(composerM6062constructorimpl3, measurePolicyMaybeCachedBoxMeasurePolicy11, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl3, currentCompositionLocalMap15, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!composerM6062constructorimpl3.getInserting()) {
                    composerM6062constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                    composerM6062constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                } else {
                    composerM6062constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                    composerM6062constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                }
                Updater.m6070setimpl(composerM6062constructorimpl3, modifierMaterializeModifier15, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance11 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1897277909, "C559@23340L15:NavigationDrawer.kt#uh7d8r");
                function2.invoke(composerStartRestartGroup, Integer.valueOf(i3 & 14));
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                Modifier.Companion companion16 = Modifier.INSTANCE;
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy12 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap16 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier16 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion16);
                constructor4 = ComposeUiNode.INSTANCE.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor4);
                } else {
                    composerStartRestartGroup.useNode();
                }
                composerM6062constructorimpl4 = Updater.m6062constructorimpl(composerStartRestartGroup);
                Updater.m6070setimpl(composerM6062constructorimpl4, measurePolicyMaybeCachedBoxMeasurePolicy12, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl4, currentCompositionLocalMap16, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                setCompositeKeyHash4 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!composerM6062constructorimpl4.getInserting()) {
                    composerM6062constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                    composerM6062constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
                } else {
                    composerM6062constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                    composerM6062constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
                }
                Updater.m6070setimpl(composerM6062constructorimpl4, modifierMaterializeModifier16, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance12 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -272067686, "C561@23396L9:NavigationDrawer.kt#uh7d8r");
                function4 = function3;
                function4.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 12) & 14));
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier2 = modifier3;
                z4 = z5;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                z4 = z2;
            }
            drawerState2 = drawerStateRememberDrawerState;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final Modifier modifier6 = modifier2;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda31
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return NavigationDrawerKt.DismissibleNavigationDrawer$lambda$7(function2, modifier6, drawerState2, z4, function4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 3072;
        z2 = z;
        if ((i & 24576) == 0) {
            if (composerStartRestartGroup.changedInstance(function4)) {
                i6 = 16384;
            } else {
                i6 = 8192;
            }
            i3 |= i6;
        }
        if ((i3 & 9363) != 9362) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "494@20725L39");
            if ((i & 1) != 0) {
                if (i7 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if ((i2 & 4) != 0) {
                    i3 &= -897;
                    drawerStateRememberDrawerState = rememberDrawerState(DrawerValue.Closed, null, composerStartRestartGroup, 6, 2);
                }
                if (i4 != 0) {
                    modifier3 = modifier2;
                    z5 = true;
                } else {
                    modifier3 = modifier2;
                    z5 = z2;
                }
            } else {
                if (i7 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if ((i2 & 4) != 0) {
                    i3 &= -897;
                    drawerStateRememberDrawerState = rememberDrawerState(DrawerValue.Closed, null, composerStartRestartGroup, 6, 2);
                }
                if (i4 != 0) {
                    modifier3 = modifier2;
                    z5 = true;
                } else {
                    modifier3 = modifier2;
                    z5 = z2;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1150092038, i3, -1, "androidx.compose.material3.DismissibleNavigationDrawer (NavigationDrawer.kt:497)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1431862792, "CC(remember):NavigationDrawer.kt#9igjgp");
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            mutableState = (MutableState) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ProvidableCompositionLocal<Density> localDensity5 = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume6 = composerStartRestartGroup.consume(localDensity5);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            density = (Density) objConsume6;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1431865955, "CC(remember):NavigationDrawer.kt#9igjgp");
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new FocusRequester();
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            focusRequester = (FocusRequester) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            finiteAnimationSpecValue = MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultSpatial, composerStartRestartGroup, 6);
            finiteAnimationSpecValue2 = MotionSchemeKt.value(MotionSchemeKeyTokens.FastEffects, composerStartRestartGroup, 6);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1431875841, "CC(remember):NavigationDrawer.kt#9igjgp");
            int i13 = (i3 & 896) ^ 384;
            zChanged = ((i13 <= 256 && composerStartRestartGroup.changed(drawerStateRememberDrawerState)) || (i3 & 384) == 256) | composerStartRestartGroup.changed(density) | composerStartRestartGroup.changedInstance(finiteAnimationSpecValue) | composerStartRestartGroup.changedInstance(finiteAnimationSpecValue2);
            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (!zChanged) {
                objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda29
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return NavigationDrawerKt.DismissibleNavigationDrawer$lambda$4$0(drawerStateRememberDrawerState, density, finiteAnimationSpecValue, finiteAnimationSpecValue2);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            } else {
                objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda29
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return NavigationDrawerKt.DismissibleNavigationDrawer$lambda$4$0(drawerStateRememberDrawerState, density, finiteAnimationSpecValue, finiteAnimationSpecValue2);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.SideEffect((Function0) objRememberedValue3, composerStartRestartGroup, 0);
            Boolean boolValueOf5 = Boolean.valueOf(drawerStateRememberDrawerState.isOpen());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1431882136, "CC(remember):NavigationDrawer.kt#9igjgp");
            if (i13 <= 256) {
            }
            navigationDrawerKt$DismissibleNavigationDrawer$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (!z6) {
                navigationDrawerKt$DismissibleNavigationDrawer$2$1RememberedValue = new NavigationDrawerKt$DismissibleNavigationDrawer$2$1(drawerStateRememberDrawerState, focusRequester, null);
                composerStartRestartGroup.updateRememberedValue(navigationDrawerKt$DismissibleNavigationDrawer$2$1RememberedValue);
            } else {
                navigationDrawerKt$DismissibleNavigationDrawer$2$1RememberedValue = new NavigationDrawerKt$DismissibleNavigationDrawer$2$1(drawerStateRememberDrawerState, focusRequester, null);
                composerStartRestartGroup.updateRememberedValue(navigationDrawerKt$DismissibleNavigationDrawer$2$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(boolValueOf5, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) navigationDrawerKt$DismissibleNavigationDrawer$2$1RememberedValue, composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 773894976, "CC(rememberCoroutineScope)N(getContext)608@27648L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 683737348, "CC(remember):Effects.kt#9igjgp");
            objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue4 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            coroutineScope = (CoroutineScope) objRememberedValue4;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Strings.Companion companion17 = Strings.INSTANCE;
            strM5086getString2EP1pXo = Strings_androidKt.m5086getString2EP1pXo(Strings.m5002constructorimpl(androidx.compose.ui.R.string.navigation_menu), composerStartRestartGroup, 0);
            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection5 = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            objConsume = composerStartRestartGroup.consume(localLayoutDirection5);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (objConsume == LayoutDirection.Rtl) {
                z7 = true;
            } else {
                z7 = false;
            }
            Modifier modifierAnchoredDraggable$default5 = AnchoredDraggableKt.anchoredDraggable$default(modifier3, drawerStateRememberDrawerState.getAnchoredDraggableState$material3(), z7, Orientation.Horizontal, z5, (MutableInteractionSource) null, (OverscrollEffect) null, (FlingBehavior) null, 112, (Object) null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy13 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap17 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier17 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierAnchoredDraggable$default5);
            constructor = ComposeUiNode.INSTANCE.getConstructor();
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
            composerM6062constructorimpl = Updater.m6062constructorimpl(composerStartRestartGroup);
            Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy13, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap17, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (!composerM6062constructorimpl.getInserting()) {
                composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            } else {
                composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier17, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance13 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -901198438, "C563@23432L1522,531@22077L2877:NavigationDrawer.kt#uh7d8r");
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1691596898, "CC(remember):NavigationDrawer.kt#9igjgp");
            if (i13 <= 256) {
            }
            navigationDrawerKt$DismissibleNavigationDrawer$3$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (!z8) {
                navigationDrawerKt$DismissibleNavigationDrawer$3$2$1RememberedValue = new NavigationDrawerKt$DismissibleNavigationDrawer$3$2$1(drawerStateRememberDrawerState, mutableState);
                composerStartRestartGroup.updateRememberedValue(navigationDrawerKt$DismissibleNavigationDrawer$3$2$1RememberedValue);
            } else {
                navigationDrawerKt$DismissibleNavigationDrawer$3$2$1RememberedValue = new NavigationDrawerKt$DismissibleNavigationDrawer$3$2$1(drawerStateRememberDrawerState, mutableState);
                composerStartRestartGroup.updateRememberedValue(navigationDrawerKt$DismissibleNavigationDrawer$3$2$1RememberedValue);
            }
            MeasurePolicy measurePolicy5 = (MeasurePolicy) navigationDrawerKt$DismissibleNavigationDrawer$3$2$1RememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            Modifier.Companion companion18 = Modifier.INSTANCE;
            currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap18 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier18 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion18);
            constructor2 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor2);
            } else {
                composerStartRestartGroup.useNode();
            }
            composerM6062constructorimpl2 = Updater.m6062constructorimpl(composerStartRestartGroup);
            Updater.m6070setimpl(composerM6062constructorimpl2, measurePolicy5, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl2, currentCompositionLocalMap18, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (!composerM6062constructorimpl2.getInserting()) {
                composerM6062constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                composerM6062constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            } else {
                composerM6062constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                composerM6062constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.m6070setimpl(composerM6062constructorimpl2, modifierMaterializeModifier18, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1778140254, "C534@22169L492,545@22698L545,533@22125L1248,561@23390L17:NavigationDrawer.kt#uh7d8r");
            Modifier.Companion companion19 = Modifier.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2020850001, "CC(remember):NavigationDrawer.kt#9igjgp");
            zChanged2 = composerStartRestartGroup.changed(strM5086getString2EP1pXo) | ((i13 <= 256 && composerStartRestartGroup.changed(drawerStateRememberDrawerState)) || (i3 & 384) == 256) | composerStartRestartGroup.changedInstance(coroutineScope);
            objRememberedValue5 = composerStartRestartGroup.rememberedValue();
            if (!zChanged2) {
                objRememberedValue5 = new Function1() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda30
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return NavigationDrawerKt.DismissibleNavigationDrawer$lambda$6$0$0$0(strM5086getString2EP1pXo, drawerStateRememberDrawerState, coroutineScope, (SemanticsPropertyReceiver) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
            } else {
                objRememberedValue5 = new Function1() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda30
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return NavigationDrawerKt.DismissibleNavigationDrawer$lambda$6$0$0$0(strM5086getString2EP1pXo, drawerStateRememberDrawerState, coroutineScope, (SemanticsPropertyReceiver) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierSemantics$default5 = SemanticsModifierKt.semantics$default(companion19, false, (Function1) objRememberedValue5, 1, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2020833020, "CC(remember):NavigationDrawer.kt#9igjgp");
            zChangedInstance = composerStartRestartGroup.changedInstance(coroutineScope) | ((i13 <= 256 && composerStartRestartGroup.changed(drawerStateRememberDrawerState)) || (i3 & 384) == 256);
            objRememberedValue6 = composerStartRestartGroup.rememberedValue();
            if (!zChangedInstance) {
                objRememberedValue6 = (Function1) new Function1<KeyEvent, Boolean>() { // from class: androidx.compose.material3.NavigationDrawerKt$DismissibleNavigationDrawer$3$1$2$1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Boolean invoke(KeyEvent keyEvent) {
                        return m3871invokeZmokQxo(keyEvent.m7966unboximpl());
                    }

                    /* JADX INFO: renamed from: invoke-ZmokQxo, reason: not valid java name */
                    public final Boolean m3871invokeZmokQxo(android.view.KeyEvent keyEvent) {
                        if (drawerStateRememberDrawerState.isOpen() && KeyEventType.m7970equalsimpl0(KeyEvent_androidKt.m7978getTypeZmokQxo(keyEvent), KeyEventType.INSTANCE.m7975getKeyUpCS__XNY()) && Key.m7669equalsimpl0(KeyEvent_androidKt.m7977getKeyZmokQxo(keyEvent), Key.INSTANCE.m7758getEscapeEK5gGoQ())) {
                            BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new AnonymousClass1(drawerStateRememberDrawerState, null), 3, null);
                            return true;
                        }
                        return false;
                    }

                    /* JADX INFO: renamed from: androidx.compose.material3.NavigationDrawerKt$DismissibleNavigationDrawer$3$1$2$1$1, reason: invalid class name */
                    /* JADX INFO: compiled from: NavigationDrawer.kt */
                    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
                    @DebugMetadata(c = "androidx.compose.material3.NavigationDrawerKt$DismissibleNavigationDrawer$3$1$2$1$1", f = "NavigationDrawer.kt", i = {}, l = {553}, m = "invokeSuspend", n = {}, s = {}, v = 1)
                    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                        final /* synthetic */ DrawerState $drawerState;
                        int label;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        AnonymousClass1(DrawerState drawerState, Continuation<? super AnonymousClass1> continuation) {
                            super(2, continuation);
                            this.$drawerState = drawerState;
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                            return new AnonymousClass1(this.$drawerState, continuation);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object obj) {
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            int i = this.label;
                            if (i == 0) {
                                ResultKt.throwOnFailure(obj);
                                this.label = 1;
                                if (this.$drawerState.close(this) == coroutine_suspended) {
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
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
            } else {
                objRememberedValue6 = (Function1) new Function1<KeyEvent, Boolean>() { // from class: androidx.compose.material3.NavigationDrawerKt$DismissibleNavigationDrawer$3$1$2$1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Boolean invoke(KeyEvent keyEvent) {
                        return m3871invokeZmokQxo(keyEvent.m7966unboximpl());
                    }

                    /* JADX INFO: renamed from: invoke-ZmokQxo, reason: not valid java name */
                    public final Boolean m3871invokeZmokQxo(android.view.KeyEvent keyEvent) {
                        if (drawerStateRememberDrawerState.isOpen() && KeyEventType.m7970equalsimpl0(KeyEvent_androidKt.m7978getTypeZmokQxo(keyEvent), KeyEventType.INSTANCE.m7975getKeyUpCS__XNY()) && Key.m7669equalsimpl0(KeyEvent_androidKt.m7977getKeyZmokQxo(keyEvent), Key.INSTANCE.m7758getEscapeEK5gGoQ())) {
                            BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new AnonymousClass1(drawerStateRememberDrawerState, null), 3, null);
                            return true;
                        }
                        return false;
                    }

                    /* JADX INFO: renamed from: androidx.compose.material3.NavigationDrawerKt$DismissibleNavigationDrawer$3$1$2$1$1, reason: invalid class name */
                    /* JADX INFO: compiled from: NavigationDrawer.kt */
                    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
                    @DebugMetadata(c = "androidx.compose.material3.NavigationDrawerKt$DismissibleNavigationDrawer$3$1$2$1$1", f = "NavigationDrawer.kt", i = {}, l = {553}, m = "invokeSuspend", n = {}, s = {}, v = 1)
                    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                        final /* synthetic */ DrawerState $drawerState;
                        int label;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        AnonymousClass1(DrawerState drawerState, Continuation<? super AnonymousClass1> continuation) {
                            super(2, continuation);
                            this.$drawerState = drawerState;
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                            return new AnonymousClass1(this.$drawerState, continuation);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object obj) {
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            int i = this.label;
                            if (i == 0) {
                                ResultKt.throwOnFailure(obj);
                                this.label = 1;
                                if (this.$drawerState.close(this) == coroutine_suspended) {
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
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierFocusRequester5 = FocusRequesterModifierKt.focusRequester(KeyInputModifierKt.onKeyEvent(modifierSemantics$default5, (Function1) objRememberedValue6), focusRequester);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy14 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap19 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier19 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFocusRequester5);
            constructor3 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor3);
            } else {
                composerStartRestartGroup.useNode();
            }
            composerM6062constructorimpl3 = Updater.m6062constructorimpl(composerStartRestartGroup);
            Updater.m6070setimpl(composerM6062constructorimpl3, measurePolicyMaybeCachedBoxMeasurePolicy14, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl3, currentCompositionLocalMap19, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (!composerM6062constructorimpl3.getInserting()) {
                composerM6062constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                composerM6062constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
            } else {
                composerM6062constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                composerM6062constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
            }
            Updater.m6070setimpl(composerM6062constructorimpl3, modifierMaterializeModifier19, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance14 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1897277909, "C559@23340L15:NavigationDrawer.kt#uh7d8r");
            function2.invoke(composerStartRestartGroup, Integer.valueOf(i3 & 14));
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            Modifier.Companion companion110 = Modifier.INSTANCE;
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy15 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap110 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier110 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion110);
            constructor4 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor4);
            } else {
                composerStartRestartGroup.useNode();
            }
            composerM6062constructorimpl4 = Updater.m6062constructorimpl(composerStartRestartGroup);
            Updater.m6070setimpl(composerM6062constructorimpl4, measurePolicyMaybeCachedBoxMeasurePolicy15, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl4, currentCompositionLocalMap110, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            setCompositeKeyHash4 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (!composerM6062constructorimpl4.getInserting()) {
                composerM6062constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                composerM6062constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
            } else {
                composerM6062constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                composerM6062constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
            }
            Updater.m6070setimpl(composerM6062constructorimpl4, modifierMaterializeModifier110, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance15 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -272067686, "C561@23396L9:NavigationDrawer.kt#uh7d8r");
            function4 = function3;
            function4.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 12) & 14));
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier3;
            z4 = z5;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            z4 = z2;
        }
        drawerState2 = drawerStateRememberDrawerState;
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier7 = modifier2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda31
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return NavigationDrawerKt.DismissibleNavigationDrawer$lambda$7(function2, modifier7, drawerState2, z4, function4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean DismissibleNavigationDrawer$lambda$1(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void DismissibleNavigationDrawer$lambda$2(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DismissibleNavigationDrawer$lambda$4$0(DrawerState drawerState, Density density, FiniteAnimationSpec finiteAnimationSpec, FiniteAnimationSpec finiteAnimationSpec2) {
        drawerState.setDensity$material3(density);
        drawerState.setOpenDrawerMotionSpec$material3(finiteAnimationSpec);
        drawerState.setCloseDrawerMotionSpec$material3(finiteAnimationSpec2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DismissibleNavigationDrawer$lambda$6$0$0$0(String str, final DrawerState drawerState, final CoroutineScope coroutineScope, SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.setPaneTitle(semanticsPropertyReceiver, str);
        if (drawerState.isOpen()) {
            SemanticsPropertiesKt.dismiss$default(semanticsPropertyReceiver, null, new Function0() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda12
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return Boolean.valueOf(NavigationDrawerKt.DismissibleNavigationDrawer$lambda$6$0$0$0$0(drawerState, coroutineScope));
                }
            }, 1, null);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean DismissibleNavigationDrawer$lambda$6$0$0$0$0(DrawerState drawerState, CoroutineScope coroutineScope) {
        if (!drawerState.getConfirmStateChange$material3().invoke(DrawerValue.Closed).booleanValue()) {
            return true;
        }
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new NavigationDrawerKt$DismissibleNavigationDrawer$3$1$1$1$1$1(drawerState, null), 3, null);
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0044  */
    /* JADX WARN: Code duplicated, block: B:25:0x004a  */
    /* JADX WARN: Code duplicated, block: B:26:0x004d  */
    /* JADX WARN: Code duplicated, block: B:30:0x0058  */
    /* JADX WARN: Code duplicated, block: B:31:0x005a  */
    /* JADX WARN: Code duplicated, block: B:34:0x0063 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:35:0x0065  */
    /* JADX WARN: Code duplicated, block: B:36:0x006a  */
    /* JADX WARN: Code duplicated, block: B:39:0x0071  */
    /* JADX WARN: Code duplicated, block: B:42:0x00bf  */
    /* JADX WARN: Code duplicated, block: B:45:0x00cb  */
    /* JADX WARN: Code duplicated, block: B:46:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:51:0x0102  */
    /* JADX WARN: Code duplicated, block: B:54:0x016f  */
    /* JADX WARN: Code duplicated, block: B:57:0x017b  */
    /* JADX WARN: Code duplicated, block: B:58:0x017f  */
    /* JADX WARN: Code duplicated, block: B:63:0x01b2  */
    /* JADX WARN: Code duplicated, block: B:66:0x0212  */
    /* JADX WARN: Code duplicated, block: B:67:0x0216  */
    /* JADX WARN: Code duplicated, block: B:70:0x0220  */
    /* JADX WARN: Code duplicated, block: B:72:? A[RETURN, SYNTHETIC] */
    public static final void PermanentNavigationDrawer(final Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, final Function2<? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        boolean z;
        Modifier.Companion companion;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int currentCompositeKeyHash;
        Function0<ComposeUiNode> constructor;
        Composer composerM6062constructorimpl;
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash;
        int currentCompositeKeyHash2;
        Function0<ComposeUiNode> constructor2;
        Composer composerM6062constructorimpl2;
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2;
        int i4;
        Composer composerStartRestartGroup = composer.startRestartGroup(89297160);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(PermanentNavigationDrawer)N(drawerContent,modifier,content)620@25950L85:NavigationDrawer.kt#uh7d8r");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(function2) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i5 = i2 & 2;
        if (i5 == 0) {
            if ((i & 48) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            if ((i & 384) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i4 = 256;
                } else {
                    i4 = 128;
                }
                i3 |= i4;
            }
            if ((i3 & Token.DOTQUERY) != 146) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                companion = modifier2;
            } else {
                if (i5 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(89297160, i3, -1, "androidx.compose.material3.PermanentNavigationDrawer (NavigationDrawer.kt:619)");
                }
                Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(companion, 0.0f, 1, null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
                MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.INSTANCE.getTop(), composerStartRestartGroup, 0);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxSize$default);
                constructor = ComposeUiNode.INSTANCE.getConstructor();
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
                composerM6062constructorimpl = Updater.m6062constructorimpl(composerStartRestartGroup);
                Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!composerM6062constructorimpl.getInserting() || !Intrinsics.areEqual(composerM6062constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                    composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -407735110, "C101@5232L9:Row.kt#2w3rfo");
                RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -688649266, "C621@25988L15,622@26012L17:NavigationDrawer.kt#uh7d8r");
                function2.invoke(composerStartRestartGroup, Integer.valueOf(i3 & 14));
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                Modifier.Companion companion2 = Modifier.INSTANCE;
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion2);
                constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor2);
                } else {
                    composerStartRestartGroup.useNode();
                }
                composerM6062constructorimpl2 = Updater.m6062constructorimpl(composerStartRestartGroup);
                Updater.m6070setimpl(composerM6062constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!composerM6062constructorimpl2.getInserting() || !Intrinsics.areEqual(composerM6062constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                    composerM6062constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    composerM6062constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                }
                Updater.m6070setimpl(composerM6062constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1964035624, "C622@26018L9:NavigationDrawer.kt#uh7d8r");
                function3.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 6) & 14));
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
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
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final Modifier modifier3 = companion;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda22
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return NavigationDrawerKt.PermanentNavigationDrawer$lambda$1(function2, modifier3, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 48;
        modifier2 = modifier;
        if ((i & 384) == 0) {
            if (composerStartRestartGroup.changedInstance(function3)) {
                i4 = 256;
            } else {
                i4 = 128;
            }
            i3 |= i4;
        }
        if ((i3 & Token.DOTQUERY) != 146) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
            companion = modifier2;
        } else {
            if (i5 != 0) {
                companion = Modifier.INSTANCE;
            } else {
                companion = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(89297160, i3, -1, "androidx.compose.material3.PermanentNavigationDrawer (NavigationDrawer.kt:619)");
            }
            Modifier modifierFillMaxSize$default2 = SizeKt.fillMaxSize$default(companion, 0.0f, 1, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy2 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.INSTANCE.getTop(), composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxSize$default2);
            constructor = ComposeUiNode.INSTANCE.getConstructor();
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
            composerM6062constructorimpl = Updater.m6062constructorimpl(composerStartRestartGroup);
            Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyRowMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (!composerM6062constructorimpl.getInserting()) {
                composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            } else {
                composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -407735110, "C101@5232L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -688649266, "C621@25988L15,622@26012L17:NavigationDrawer.kt#uh7d8r");
            function2.invoke(composerStartRestartGroup, Integer.valueOf(i3 & 14));
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            Modifier.Companion companion3 = Modifier.INSTANCE;
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap4 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion3);
            constructor2 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor2);
            } else {
                composerStartRestartGroup.useNode();
            }
            composerM6062constructorimpl2 = Updater.m6062constructorimpl(composerStartRestartGroup);
            Updater.m6070setimpl(composerM6062constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl2, currentCompositionLocalMap4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (!composerM6062constructorimpl2.getInserting()) {
                composerM6062constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                composerM6062constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            } else {
                composerM6062constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                composerM6062constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.m6070setimpl(composerM6062constructorimpl2, modifierMaterializeModifier4, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1964035624, "C622@26018L9:NavigationDrawer.kt#uh7d8r");
            function3.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 6) & 14));
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
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
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier4 = companion;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda22
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return NavigationDrawerKt.PermanentNavigationDrawer$lambda$1(function2, modifier4, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0121 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:102:0x0123  */
    /* JADX WARN: Code duplicated, block: B:103:0x0128  */
    /* JADX WARN: Code duplicated, block: B:106:0x012d  */
    /* JADX WARN: Code duplicated, block: B:109:0x013a  */
    /* JADX WARN: Code duplicated, block: B:112:0x0147  */
    /* JADX WARN: Code duplicated, block: B:114:0x0154  */
    /* JADX WARN: Code duplicated, block: B:117:0x015f  */
    /* JADX WARN: Code duplicated, block: B:118:0x0174  */
    /* JADX WARN: Code duplicated, block: B:121:0x0189  */
    /* JADX WARN: Code duplicated, block: B:124:0x01c0  */
    /* JADX WARN: Code duplicated, block: B:126:0x01cc  */
    /* JADX WARN: Code duplicated, block: B:129:0x01dd  */
    /* JADX WARN: Code duplicated, block: B:131:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:59:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:61:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:63:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:64:0x00af  */
    /* JADX WARN: Code duplicated, block: B:67:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:70:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:72:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:73:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:75:0x00cb  */
    /* JADX WARN: Code duplicated, block: B:78:0x00d6  */
    /* JADX WARN: Code duplicated, block: B:79:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:82:0x00e1  */
    /* JADX INFO: renamed from: ModalDrawerSheet-afqeVBk, reason: not valid java name */
    public static final void m3867ModalDrawerSheetafqeVBk(Modifier modifier, Shape shape, long j, long j2, float f, WindowInsets windowInsets, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        Shape shape2;
        long modalContainerColor;
        long j3;
        float fM3297getModalDrawerElevationD9Ej5fM;
        WindowInsets windowInsets2;
        boolean z;
        Composer composer2;
        final Modifier modifier3;
        final Shape shape3;
        final long j4;
        final long j5;
        final float f2;
        final WindowInsets windowInsets3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i4;
        Modifier.Companion companion;
        Shape shape4;
        long j6;
        float f3;
        int i5;
        Modifier modifier4;
        long j7;
        int i6;
        Composer composerStartRestartGroup = composer.startRestartGroup(1922633461);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ModalDrawerSheet)N(modifier,drawerShape,drawerContainerColor:c#ui.graphics.Color,drawerContentColor:c#ui.graphics.Color,drawerTonalElevation:c#ui.unit.Dp,windowInsets,content)656@27710L343:NavigationDrawer.kt#uh7d8r");
        int i7 = i2 & 1;
        if (i7 != 0) {
            i3 = i | 6;
            modifier2 = modifier;
        } else if ((i & 6) == 0) {
            modifier2 = modifier;
            i3 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i;
        } else {
            modifier2 = modifier;
            i3 = i;
        }
        if ((i & 48) == 0) {
            if ((i2 & 2) == 0) {
                shape2 = shape;
                int i8 = composerStartRestartGroup.changed(shape2) ? 32 : 16;
                i3 |= i8;
            } else {
                shape2 = shape;
            }
            i3 |= i8;
        } else {
            shape2 = shape;
        }
        if ((i & 384) == 0) {
            if ((i2 & 4) == 0) {
                modalContainerColor = j;
                int i9 = composerStartRestartGroup.changed(modalContainerColor) ? 256 : 128;
                i3 |= i9;
            } else {
                modalContainerColor = j;
            }
            i3 |= i9;
        } else {
            modalContainerColor = j;
        }
        if ((i & 3072) == 0) {
            if ((i2 & 8) == 0) {
                j3 = j2;
                int i10 = composerStartRestartGroup.changed(j3) ? 2048 : 1024;
                i3 |= i10;
            } else {
                j3 = j2;
            }
            i3 |= i10;
        } else {
            j3 = j2;
        }
        int i11 = i2 & 16;
        if (i11 == 0) {
            if ((i & 24576) == 0) {
                fM3297getModalDrawerElevationD9Ej5fM = f;
                i3 |= composerStartRestartGroup.changed(fM3297getModalDrawerElevationD9Ej5fM) ? 16384 : 8192;
            }
            if ((196608 & i) == 0) {
                if ((i2 & 32) == 0) {
                    windowInsets2 = windowInsets;
                    int i12 = composerStartRestartGroup.changed(windowInsets2) ? 131072 : 65536;
                    i3 |= i12;
                } else {
                    windowInsets2 = windowInsets;
                }
                i3 |= i12;
            } else {
                windowInsets2 = windowInsets;
            }
            if ((1572864 & i) != 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i6 = 1048576;
                } else {
                    i6 = 524288;
                }
                i3 |= i6;
            }
            if ((599187 & i3) != 599186) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "649@27375L5,650@27431L19,651@27484L37,653@27639L12");
                i4 = 6;
                if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                    if (i7 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if ((i2 & 2) != 0) {
                        i3 &= -113;
                        shape2 = DrawerDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                    }
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                        modalContainerColor = DrawerDefaults.INSTANCE.getModalContainerColor(composerStartRestartGroup, 6);
                    }
                    if ((i2 & 8) != 0) {
                        long jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(modalContainerColor, composerStartRestartGroup, (i3 >> 6) & 14);
                        i3 &= -7169;
                        j3 = jM3051contentColorForek8zF_U;
                    }
                    if (i11 != 0) {
                        fM3297getModalDrawerElevationD9Ej5fM = DrawerDefaults.INSTANCE.m3297getModalDrawerElevationD9Ej5fM();
                    }
                    if ((i2 & 32) != 0) {
                        i3 &= -458753;
                        modifier4 = companion;
                        shape4 = shape2;
                        j6 = j3;
                        f3 = fM3297getModalDrawerElevationD9Ej5fM;
                        i4 = 6;
                        windowInsets2 = DrawerDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                        j7 = modalContainerColor;
                        i5 = 1922633461;
                    } else {
                        shape4 = shape2;
                        j6 = j3;
                        f3 = fM3297getModalDrawerElevationD9Ej5fM;
                        i5 = 1922633461;
                        modifier4 = companion;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(i5, i3, -1, "androidx.compose.material3.ModalDrawerSheet (NavigationDrawer.kt:655)");
                    }
                    int i13 = ((i3 >> 12) & 112) | i4;
                    int i14 = i3 << 6;
                    composer2 = composerStartRestartGroup;
                    m3865DrawerSheetcm3T3N0(null, windowInsets2, modifier4, shape4, j7, j6, f3, null, function3, composer2, i13 | (i14 & 896) | (i14 & 7168) | (57344 & i14) | (458752 & i14) | (3670016 & i14) | (i14 & 234881024), 128);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    windowInsets3 = windowInsets2;
                    modifier3 = modifier4;
                    shape3 = shape4;
                    j4 = j7;
                    j5 = j6;
                    f2 = f3;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    if ((i2 & 2) != 0) {
                        i3 &= -113;
                    }
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                    }
                    if ((i2 & 32) != 0) {
                        i3 &= -458753;
                    }
                    shape4 = shape2;
                    j6 = j3;
                    f3 = fM3297getModalDrawerElevationD9Ej5fM;
                    i5 = 1922633461;
                    modifier4 = modifier2;
                }
                j7 = modalContainerColor;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(i5, i3, -1, "androidx.compose.material3.ModalDrawerSheet (NavigationDrawer.kt:655)");
                }
                int i15 = ((i3 >> 12) & 112) | i4;
                int i16 = i3 << 6;
                composer2 = composerStartRestartGroup;
                m3865DrawerSheetcm3T3N0(null, windowInsets2, modifier4, shape4, j7, j6, f3, null, function3, composer2, i15 | (i16 & 896) | (i16 & 7168) | (57344 & i16) | (458752 & i16) | (3670016 & i16) | (i16 & 234881024), 128);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                windowInsets3 = windowInsets2;
                modifier3 = modifier4;
                shape3 = shape4;
                j4 = j7;
                j5 = j6;
                f2 = f3;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier3 = modifier2;
                shape3 = shape2;
                j4 = modalContainerColor;
                j5 = j3;
                f2 = fM3297getModalDrawerElevationD9Ej5fM;
                windowInsets3 = windowInsets2;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda21
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return NavigationDrawerKt.ModalDrawerSheet_afqeVBk$lambda$0(modifier3, shape3, j4, j5, f2, windowInsets3, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 24576;
        fM3297getModalDrawerElevationD9Ej5fM = f;
        if ((196608 & i) == 0) {
            if ((i2 & 32) == 0) {
                windowInsets2 = windowInsets;
                if (composerStartRestartGroup.changed(windowInsets2)) {
                }
                i3 |= i12;
            } else {
                windowInsets2 = windowInsets;
            }
            i3 |= i12;
        } else {
            windowInsets2 = windowInsets;
        }
        if ((1572864 & i) != 0) {
            if (composerStartRestartGroup.changedInstance(function3)) {
                i6 = 1048576;
            } else {
                i6 = 524288;
            }
            i3 |= i6;
        }
        if ((599187 & i3) != 599186) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "649@27375L5,650@27431L19,651@27484L37,653@27639L12");
            i4 = 6;
            if ((i & 1) != 0) {
                if (i7 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if ((i2 & 2) != 0) {
                    i3 &= -113;
                    shape2 = DrawerDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                }
                if ((i2 & 4) != 0) {
                    i3 &= -897;
                    modalContainerColor = DrawerDefaults.INSTANCE.getModalContainerColor(composerStartRestartGroup, 6);
                }
                if ((i2 & 8) != 0) {
                    long jM3051contentColorForek8zF_U2 = ColorSchemeKt.m3051contentColorForek8zF_U(modalContainerColor, composerStartRestartGroup, (i3 >> 6) & 14);
                    i3 &= -7169;
                    j3 = jM3051contentColorForek8zF_U2;
                }
                if (i11 != 0) {
                    fM3297getModalDrawerElevationD9Ej5fM = DrawerDefaults.INSTANCE.m3297getModalDrawerElevationD9Ej5fM();
                }
                if ((i2 & 32) != 0) {
                    i3 &= -458753;
                    modifier4 = companion;
                    shape4 = shape2;
                    j6 = j3;
                    f3 = fM3297getModalDrawerElevationD9Ej5fM;
                    i4 = 6;
                    windowInsets2 = DrawerDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                    j7 = modalContainerColor;
                    i5 = 1922633461;
                } else {
                    shape4 = shape2;
                    j6 = j3;
                    f3 = fM3297getModalDrawerElevationD9Ej5fM;
                    i5 = 1922633461;
                    modifier4 = companion;
                    j7 = modalContainerColor;
                }
            } else {
                if (i7 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if ((i2 & 2) != 0) {
                    i3 &= -113;
                    shape2 = DrawerDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                }
                if ((i2 & 4) != 0) {
                    i3 &= -897;
                    modalContainerColor = DrawerDefaults.INSTANCE.getModalContainerColor(composerStartRestartGroup, 6);
                }
                if ((i2 & 8) != 0) {
                    long jM3051contentColorForek8zF_U3 = ColorSchemeKt.m3051contentColorForek8zF_U(modalContainerColor, composerStartRestartGroup, (i3 >> 6) & 14);
                    i3 &= -7169;
                    j3 = jM3051contentColorForek8zF_U3;
                }
                if (i11 != 0) {
                    fM3297getModalDrawerElevationD9Ej5fM = DrawerDefaults.INSTANCE.m3297getModalDrawerElevationD9Ej5fM();
                }
                if ((i2 & 32) != 0) {
                    i3 &= -458753;
                    modifier4 = companion;
                    shape4 = shape2;
                    j6 = j3;
                    f3 = fM3297getModalDrawerElevationD9Ej5fM;
                    i4 = 6;
                    windowInsets2 = DrawerDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                    j7 = modalContainerColor;
                    i5 = 1922633461;
                } else {
                    shape4 = shape2;
                    j6 = j3;
                    f3 = fM3297getModalDrawerElevationD9Ej5fM;
                    i5 = 1922633461;
                    modifier4 = companion;
                    j7 = modalContainerColor;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(i5, i3, -1, "androidx.compose.material3.ModalDrawerSheet (NavigationDrawer.kt:655)");
            }
            int i17 = ((i3 >> 12) & 112) | i4;
            int i18 = i3 << 6;
            composer2 = composerStartRestartGroup;
            m3865DrawerSheetcm3T3N0(null, windowInsets2, modifier4, shape4, j7, j6, f3, null, function3, composer2, i17 | (i18 & 896) | (i18 & 7168) | (57344 & i18) | (458752 & i18) | (3670016 & i18) | (i18 & 234881024), 128);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            windowInsets3 = windowInsets2;
            modifier3 = modifier4;
            shape3 = shape4;
            j4 = j7;
            j5 = j6;
            f2 = f3;
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            modifier3 = modifier2;
            shape3 = shape2;
            j4 = modalContainerColor;
            j5 = j3;
            f2 = fM3297getModalDrawerElevationD9Ej5fM;
            windowInsets3 = windowInsets2;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda21
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return NavigationDrawerKt.ModalDrawerSheet_afqeVBk$lambda$0(modifier3, shape3, j4, j5, f2, windowInsets3, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX WARN: Code duplicated, block: B:107:0x0129 A[PHI: r1 r3 r4 r5 r7 r13
      0x0129: PHI (r1v24 int) = (r1v17 int), (r1v28 int), (r1v29 int) binds: [B:122:0x016e, B:105:0x0126, B:106:0x0128] A[DONT_GENERATE, DONT_INLINE]
      0x0129: PHI (r3v9 androidx.compose.ui.Modifier) = (r3v5 androidx.compose.ui.Modifier), (r3v2 androidx.compose.ui.Modifier), (r3v2 androidx.compose.ui.Modifier) binds: [B:122:0x016e, B:105:0x0126, B:106:0x0128] A[DONT_GENERATE, DONT_INLINE]
      0x0129: PHI (r4v13 androidx.compose.ui.graphics.Shape) = 
      (r4v9 androidx.compose.ui.graphics.Shape)
      (r4v6 androidx.compose.ui.graphics.Shape)
      (r4v6 androidx.compose.ui.graphics.Shape)
     binds: [B:122:0x016e, B:105:0x0126, B:106:0x0128] A[DONT_GENERATE, DONT_INLINE]
      0x0129: PHI (r5v5 long) = (r5v3 long), (r5v2 long), (r5v2 long) binds: [B:122:0x016e, B:105:0x0126, B:106:0x0128] A[DONT_GENERATE, DONT_INLINE]
      0x0129: PHI (r7v5 long) = (r7v3 long), (r7v2 long), (r7v2 long) binds: [B:122:0x016e, B:105:0x0126, B:106:0x0128] A[DONT_GENERATE, DONT_INLINE]
      0x0129: PHI (r13v9 float) = (r13v5 float), (r13v3 float), (r13v3 float) binds: [B:122:0x016e, B:105:0x0126, B:106:0x0128] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:108:0x0131 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:109:0x0133  */
    /* JADX WARN: Code duplicated, block: B:112:0x013f  */
    /* JADX WARN: Code duplicated, block: B:115:0x014c  */
    /* JADX WARN: Code duplicated, block: B:118:0x0158  */
    /* JADX WARN: Code duplicated, block: B:120:0x0165  */
    /* JADX WARN: Code duplicated, block: B:123:0x0170  */
    /* JADX WARN: Code duplicated, block: B:126:0x0188  */
    /* JADX WARN: Code duplicated, block: B:129:0x01af  */
    /* JADX WARN: Code duplicated, block: B:131:0x01b4  */
    /* JADX WARN: Code duplicated, block: B:134:0x01c3  */
    /* JADX WARN: Code duplicated, block: B:136:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:23:0x0042  */
    /* JADX WARN: Code duplicated, block: B:25:0x0046  */
    /* JADX WARN: Code duplicated, block: B:27:0x004e  */
    /* JADX WARN: Code duplicated, block: B:28:0x0051  */
    /* JADX WARN: Code duplicated, block: B:31:0x0057  */
    /* JADX WARN: Code duplicated, block: B:34:0x005d  */
    /* JADX WARN: Code duplicated, block: B:36:0x0061  */
    /* JADX WARN: Code duplicated, block: B:38:0x0069  */
    /* JADX WARN: Code duplicated, block: B:39:0x006c  */
    /* JADX WARN: Code duplicated, block: B:42:0x0072  */
    /* JADX WARN: Code duplicated, block: B:45:0x0078  */
    /* JADX WARN: Code duplicated, block: B:47:0x007c  */
    /* JADX WARN: Code duplicated, block: B:49:0x0084  */
    /* JADX WARN: Code duplicated, block: B:50:0x0087  */
    /* JADX WARN: Code duplicated, block: B:53:0x008d  */
    /* JADX WARN: Code duplicated, block: B:56:0x0095  */
    /* JADX WARN: Code duplicated, block: B:57:0x0097  */
    /* JADX WARN: Code duplicated, block: B:59:0x009a  */
    /* JADX WARN: Code duplicated, block: B:61:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:62:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:67:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:69:0x00b4  */
    /* JADX WARN: Code duplicated, block: B:71:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:72:0x00bf  */
    /* JADX WARN: Code duplicated, block: B:75:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:78:0x00cc  */
    /* JADX WARN: Code duplicated, block: B:80:0x00d4  */
    /* JADX WARN: Code duplicated, block: B:81:0x00d7  */
    /* JADX WARN: Code duplicated, block: B:83:0x00dc  */
    /* JADX WARN: Code duplicated, block: B:86:0x00eb  */
    /* JADX WARN: Code duplicated, block: B:87:0x00ed  */
    /* JADX WARN: Code duplicated, block: B:90:0x00f6  */
    /* JADX WARN: Code duplicated, block: B:92:0x0108  */
    /* JADX INFO: renamed from: ModalDrawerSheet-Snr_uVM, reason: not valid java name */
    public static final void m3866ModalDrawerSheetSnr_uVM(final DrawerState drawerState, Modifier modifier, Shape shape, long j, long j2, float f, WindowInsets windowInsets, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        Shape shape2;
        long modalContainerColor;
        long jM3051contentColorForek8zF_U;
        int i4;
        float fM3297getModalDrawerElevationD9Ej5fM;
        int i5;
        WindowInsets windowInsets2;
        Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function4;
        boolean z;
        final Modifier modifier3;
        final Shape shape3;
        final long j3;
        final long j4;
        final float f2;
        final WindowInsets windowInsets3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i6;
        final WindowInsets windowInsets4;
        int i7;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1620540727);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ModalDrawerSheet)N(drawerState,modifier,drawerShape,drawerContainerColor:c#ui.graphics.Color,drawerContentColor:c#ui.graphics.Color,drawerTonalElevation:c#ui.unit.Dp,windowInsets,content)700@29823L519,700@29782L560:NavigationDrawer.kt#uh7d8r");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(drawerState) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i8 = i2 & 2;
        if (i8 == 0) {
            if ((i & 48) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            if ((i & 384) == 0) {
                if ((i2 & 4) == 0) {
                    shape2 = shape;
                    int i9 = composerStartRestartGroup.changed(shape2) ? 256 : 128;
                    i3 |= i9;
                } else {
                    shape2 = shape;
                }
                i3 |= i9;
            } else {
                shape2 = shape;
            }
            if ((i & 3072) == 0) {
                if ((i2 & 8) == 0) {
                    modalContainerColor = j;
                    int i10 = composerStartRestartGroup.changed(modalContainerColor) ? 2048 : 1024;
                    i3 |= i10;
                } else {
                    modalContainerColor = j;
                }
                i3 |= i10;
            } else {
                modalContainerColor = j;
            }
            if ((i & 24576) == 0) {
                if ((i2 & 16) == 0) {
                    jM3051contentColorForek8zF_U = j2;
                    int i11 = composerStartRestartGroup.changed(jM3051contentColorForek8zF_U) ? 16384 : 8192;
                    i3 |= i11;
                } else {
                    jM3051contentColorForek8zF_U = j2;
                }
                i3 |= i11;
            } else {
                jM3051contentColorForek8zF_U = j2;
            }
            i4 = i2 & 32;
            if (i4 != 0) {
                if ((196608 & i) == 0) {
                    fM3297getModalDrawerElevationD9Ej5fM = f;
                    if (composerStartRestartGroup.changed(fM3297getModalDrawerElevationD9Ej5fM)) {
                        i5 = 131072;
                    } else {
                        i5 = 65536;
                    }
                    i3 |= i5;
                }
                if ((1572864 & i) == 0) {
                    if ((i2 & 64) == 0) {
                        windowInsets2 = windowInsets;
                        int i12 = composerStartRestartGroup.changed(windowInsets2) ? 1048576 : 524288;
                        i3 |= i12;
                    } else {
                        windowInsets2 = windowInsets;
                    }
                    i3 |= i12;
                } else {
                    windowInsets2 = windowInsets;
                }
                if ((12582912 & i) == 0) {
                    function4 = function3;
                    if (composerStartRestartGroup.changedInstance(function4)) {
                        i7 = 8388608;
                    } else {
                        i7 = 4194304;
                    }
                    i3 |= i7;
                } else {
                    function4 = function3;
                }
                if ((i3 & 4793491) != 4793490) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "693@29447L5,694@29503L19,695@29556L37,697@29711L12");
                    if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                        if (i8 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                            shape2 = DrawerDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                        }
                        if ((i2 & 8) != 0) {
                            modalContainerColor = DrawerDefaults.INSTANCE.getModalContainerColor(composerStartRestartGroup, 6);
                            i3 &= -7169;
                        }
                        if ((i2 & 16) != 0) {
                            jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(modalContainerColor, composerStartRestartGroup, (i3 >> 9) & 14);
                            i3 &= -57345;
                        }
                        if (i4 != 0) {
                            fM3297getModalDrawerElevationD9Ej5fM = DrawerDefaults.INSTANCE.m3297getModalDrawerElevationD9Ej5fM();
                        }
                        if ((i2 & 64) != 0) {
                            modifier3 = modifier2;
                            shape3 = shape2;
                            j3 = modalContainerColor;
                            j4 = jM3051contentColorForek8zF_U;
                            f2 = fM3297getModalDrawerElevationD9Ej5fM;
                            i6 = i3 & (-3670017);
                            windowInsets4 = DrawerDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1620540727, i6, -1, "androidx.compose.material3.ModalDrawerSheet (NavigationDrawer.kt:699)");
                        }
                        final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function5 = function4;
                        DrawerPredictiveBackHandler(drawerState, ComposableLambdaKt.rememberComposableLambda(797187326, true, new Function3() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda13
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return NavigationDrawerKt.ModalDrawerSheet_Snr_uVM$lambda$0(windowInsets4, modifier3, shape3, j3, j4, f2, drawerState, function5, (DrawerPredictiveBackState) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, (i6 & 14) | 48);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        windowInsets3 = windowInsets4;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                        }
                        if ((i2 & 8) != 0) {
                            i3 &= -7169;
                        }
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                        }
                        if ((i2 & 64) != 0) {
                            i3 &= -3670017;
                        }
                    }
                    modifier3 = modifier2;
                    shape3 = shape2;
                    j3 = modalContainerColor;
                    j4 = jM3051contentColorForek8zF_U;
                    f2 = fM3297getModalDrawerElevationD9Ej5fM;
                    i6 = i3;
                    windowInsets4 = windowInsets2;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1620540727, i6, -1, "androidx.compose.material3.ModalDrawerSheet (NavigationDrawer.kt:699)");
                    }
                    final Function3 function6 = function4;
                    DrawerPredictiveBackHandler(drawerState, ComposableLambdaKt.rememberComposableLambda(797187326, true, new Function3() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda13
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return NavigationDrawerKt.ModalDrawerSheet_Snr_uVM$lambda$0(windowInsets4, modifier3, shape3, j3, j4, f2, drawerState, function6, (DrawerPredictiveBackState) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, (i6 & 14) | 48);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    windowInsets3 = windowInsets4;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier3 = modifier2;
                    shape3 = shape2;
                    j3 = modalContainerColor;
                    j4 = jM3051contentColorForek8zF_U;
                    f2 = fM3297getModalDrawerElevationD9Ej5fM;
                    windowInsets3 = windowInsets2;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda14
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return NavigationDrawerKt.ModalDrawerSheet_Snr_uVM$lambda$1(drawerState, modifier3, shape3, j3, j4, f2, windowInsets3, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            fM3297getModalDrawerElevationD9Ej5fM = f;
            if ((1572864 & i) == 0) {
                if ((i2 & 64) == 0) {
                    windowInsets2 = windowInsets;
                    if (composerStartRestartGroup.changed(windowInsets2)) {
                    }
                    i3 |= i12;
                } else {
                    windowInsets2 = windowInsets;
                }
                i3 |= i12;
            } else {
                windowInsets2 = windowInsets;
            }
            if ((12582912 & i) == 0) {
                function4 = function3;
                if (composerStartRestartGroup.changedInstance(function4)) {
                    i7 = 8388608;
                } else {
                    i7 = 4194304;
                }
                i3 |= i7;
            } else {
                function4 = function3;
            }
            if ((i3 & 4793491) != 4793490) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "693@29447L5,694@29503L19,695@29556L37,697@29711L12");
                if ((i & 1) != 0) {
                    if (i8 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                        shape2 = DrawerDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                    }
                    if ((i2 & 8) != 0) {
                        modalContainerColor = DrawerDefaults.INSTANCE.getModalContainerColor(composerStartRestartGroup, 6);
                        i3 &= -7169;
                    }
                    if ((i2 & 16) != 0) {
                        jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(modalContainerColor, composerStartRestartGroup, (i3 >> 9) & 14);
                        i3 &= -57345;
                    }
                    if (i4 != 0) {
                        fM3297getModalDrawerElevationD9Ej5fM = DrawerDefaults.INSTANCE.m3297getModalDrawerElevationD9Ej5fM();
                    }
                    if ((i2 & 64) != 0) {
                        modifier3 = modifier2;
                        shape3 = shape2;
                        j3 = modalContainerColor;
                        j4 = jM3051contentColorForek8zF_U;
                        f2 = fM3297getModalDrawerElevationD9Ej5fM;
                        i6 = i3 & (-3670017);
                        windowInsets4 = DrawerDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                    } else {
                        modifier3 = modifier2;
                        shape3 = shape2;
                        j3 = modalContainerColor;
                        j4 = jM3051contentColorForek8zF_U;
                        f2 = fM3297getModalDrawerElevationD9Ej5fM;
                        i6 = i3;
                        windowInsets4 = windowInsets2;
                    }
                } else {
                    if (i8 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                        shape2 = DrawerDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                    }
                    if ((i2 & 8) != 0) {
                        modalContainerColor = DrawerDefaults.INSTANCE.getModalContainerColor(composerStartRestartGroup, 6);
                        i3 &= -7169;
                    }
                    if ((i2 & 16) != 0) {
                        jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(modalContainerColor, composerStartRestartGroup, (i3 >> 9) & 14);
                        i3 &= -57345;
                    }
                    if (i4 != 0) {
                        fM3297getModalDrawerElevationD9Ej5fM = DrawerDefaults.INSTANCE.m3297getModalDrawerElevationD9Ej5fM();
                    }
                    if ((i2 & 64) != 0) {
                        modifier3 = modifier2;
                        shape3 = shape2;
                        j3 = modalContainerColor;
                        j4 = jM3051contentColorForek8zF_U;
                        f2 = fM3297getModalDrawerElevationD9Ej5fM;
                        i6 = i3 & (-3670017);
                        windowInsets4 = DrawerDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                    } else {
                        modifier3 = modifier2;
                        shape3 = shape2;
                        j3 = modalContainerColor;
                        j4 = jM3051contentColorForek8zF_U;
                        f2 = fM3297getModalDrawerElevationD9Ej5fM;
                        i6 = i3;
                        windowInsets4 = windowInsets2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1620540727, i6, -1, "androidx.compose.material3.ModalDrawerSheet (NavigationDrawer.kt:699)");
                }
                final Function3 function7 = function4;
                DrawerPredictiveBackHandler(drawerState, ComposableLambdaKt.rememberComposableLambda(797187326, true, new Function3() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda13
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return NavigationDrawerKt.ModalDrawerSheet_Snr_uVM$lambda$0(windowInsets4, modifier3, shape3, j3, j4, f2, drawerState, function7, (DrawerPredictiveBackState) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, (i6 & 14) | 48);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                windowInsets3 = windowInsets4;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                shape3 = shape2;
                j3 = modalContainerColor;
                j4 = jM3051contentColorForek8zF_U;
                f2 = fM3297getModalDrawerElevationD9Ej5fM;
                windowInsets3 = windowInsets2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda14
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return NavigationDrawerKt.ModalDrawerSheet_Snr_uVM$lambda$1(drawerState, modifier3, shape3, j3, j4, f2, windowInsets3, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 48;
        modifier2 = modifier;
        if ((i & 384) == 0) {
            if ((i2 & 4) == 0) {
                shape2 = shape;
                if (composerStartRestartGroup.changed(shape2)) {
                }
                i3 |= i9;
            } else {
                shape2 = shape;
            }
            i3 |= i9;
        } else {
            shape2 = shape;
        }
        if ((i & 3072) == 0) {
            if ((i2 & 8) == 0) {
                modalContainerColor = j;
                if (composerStartRestartGroup.changed(modalContainerColor)) {
                }
                i3 |= i10;
            } else {
                modalContainerColor = j;
            }
            i3 |= i10;
        } else {
            modalContainerColor = j;
        }
        if ((i & 24576) == 0) {
            if ((i2 & 16) == 0) {
                jM3051contentColorForek8zF_U = j2;
                if (composerStartRestartGroup.changed(jM3051contentColorForek8zF_U)) {
                }
                i3 |= i11;
            } else {
                jM3051contentColorForek8zF_U = j2;
            }
            i3 |= i11;
        } else {
            jM3051contentColorForek8zF_U = j2;
        }
        i4 = i2 & 32;
        if (i4 != 0) {
            if ((196608 & i) == 0) {
                fM3297getModalDrawerElevationD9Ej5fM = f;
                if (composerStartRestartGroup.changed(fM3297getModalDrawerElevationD9Ej5fM)) {
                    i5 = 131072;
                } else {
                    i5 = 65536;
                }
                i3 |= i5;
            }
            if ((1572864 & i) == 0) {
                if ((i2 & 64) == 0) {
                    windowInsets2 = windowInsets;
                    if (composerStartRestartGroup.changed(windowInsets2)) {
                    }
                    i3 |= i12;
                } else {
                    windowInsets2 = windowInsets;
                }
                i3 |= i12;
            } else {
                windowInsets2 = windowInsets;
            }
            if ((12582912 & i) == 0) {
                function4 = function3;
                if (composerStartRestartGroup.changedInstance(function4)) {
                    i7 = 8388608;
                } else {
                    i7 = 4194304;
                }
                i3 |= i7;
            } else {
                function4 = function3;
            }
            if ((i3 & 4793491) != 4793490) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "693@29447L5,694@29503L19,695@29556L37,697@29711L12");
                if ((i & 1) != 0) {
                    if (i8 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                        shape2 = DrawerDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                    }
                    if ((i2 & 8) != 0) {
                        modalContainerColor = DrawerDefaults.INSTANCE.getModalContainerColor(composerStartRestartGroup, 6);
                        i3 &= -7169;
                    }
                    if ((i2 & 16) != 0) {
                        jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(modalContainerColor, composerStartRestartGroup, (i3 >> 9) & 14);
                        i3 &= -57345;
                    }
                    if (i4 != 0) {
                        fM3297getModalDrawerElevationD9Ej5fM = DrawerDefaults.INSTANCE.m3297getModalDrawerElevationD9Ej5fM();
                    }
                    if ((i2 & 64) != 0) {
                        modifier3 = modifier2;
                        shape3 = shape2;
                        j3 = modalContainerColor;
                        j4 = jM3051contentColorForek8zF_U;
                        f2 = fM3297getModalDrawerElevationD9Ej5fM;
                        i6 = i3 & (-3670017);
                        windowInsets4 = DrawerDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                    } else {
                        modifier3 = modifier2;
                        shape3 = shape2;
                        j3 = modalContainerColor;
                        j4 = jM3051contentColorForek8zF_U;
                        f2 = fM3297getModalDrawerElevationD9Ej5fM;
                        i6 = i3;
                        windowInsets4 = windowInsets2;
                    }
                } else {
                    if (i8 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                        shape2 = DrawerDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                    }
                    if ((i2 & 8) != 0) {
                        modalContainerColor = DrawerDefaults.INSTANCE.getModalContainerColor(composerStartRestartGroup, 6);
                        i3 &= -7169;
                    }
                    if ((i2 & 16) != 0) {
                        jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(modalContainerColor, composerStartRestartGroup, (i3 >> 9) & 14);
                        i3 &= -57345;
                    }
                    if (i4 != 0) {
                        fM3297getModalDrawerElevationD9Ej5fM = DrawerDefaults.INSTANCE.m3297getModalDrawerElevationD9Ej5fM();
                    }
                    if ((i2 & 64) != 0) {
                        modifier3 = modifier2;
                        shape3 = shape2;
                        j3 = modalContainerColor;
                        j4 = jM3051contentColorForek8zF_U;
                        f2 = fM3297getModalDrawerElevationD9Ej5fM;
                        i6 = i3 & (-3670017);
                        windowInsets4 = DrawerDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                    } else {
                        modifier3 = modifier2;
                        shape3 = shape2;
                        j3 = modalContainerColor;
                        j4 = jM3051contentColorForek8zF_U;
                        f2 = fM3297getModalDrawerElevationD9Ej5fM;
                        i6 = i3;
                        windowInsets4 = windowInsets2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1620540727, i6, -1, "androidx.compose.material3.ModalDrawerSheet (NavigationDrawer.kt:699)");
                }
                final Function3 function8 = function4;
                DrawerPredictiveBackHandler(drawerState, ComposableLambdaKt.rememberComposableLambda(797187326, true, new Function3() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda13
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return NavigationDrawerKt.ModalDrawerSheet_Snr_uVM$lambda$0(windowInsets4, modifier3, shape3, j3, j4, f2, drawerState, function8, (DrawerPredictiveBackState) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, (i6 & 14) | 48);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                windowInsets3 = windowInsets4;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                shape3 = shape2;
                j3 = modalContainerColor;
                j4 = jM3051contentColorForek8zF_U;
                f2 = fM3297getModalDrawerElevationD9Ej5fM;
                windowInsets3 = windowInsets2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda14
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return NavigationDrawerKt.ModalDrawerSheet_Snr_uVM$lambda$1(drawerState, modifier3, shape3, j3, j4, f2, windowInsets3, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        fM3297getModalDrawerElevationD9Ej5fM = f;
        if ((1572864 & i) == 0) {
            if ((i2 & 64) == 0) {
                windowInsets2 = windowInsets;
                if (composerStartRestartGroup.changed(windowInsets2)) {
                }
                i3 |= i12;
            } else {
                windowInsets2 = windowInsets;
            }
            i3 |= i12;
        } else {
            windowInsets2 = windowInsets;
        }
        if ((12582912 & i) == 0) {
            function4 = function3;
            if (composerStartRestartGroup.changedInstance(function4)) {
                i7 = 8388608;
            } else {
                i7 = 4194304;
            }
            i3 |= i7;
        } else {
            function4 = function3;
        }
        if ((i3 & 4793491) != 4793490) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "693@29447L5,694@29503L19,695@29556L37,697@29711L12");
            if ((i & 1) != 0) {
                if (i8 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if ((i2 & 4) != 0) {
                    i3 &= -897;
                    shape2 = DrawerDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                }
                if ((i2 & 8) != 0) {
                    modalContainerColor = DrawerDefaults.INSTANCE.getModalContainerColor(composerStartRestartGroup, 6);
                    i3 &= -7169;
                }
                if ((i2 & 16) != 0) {
                    jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(modalContainerColor, composerStartRestartGroup, (i3 >> 9) & 14);
                    i3 &= -57345;
                }
                if (i4 != 0) {
                    fM3297getModalDrawerElevationD9Ej5fM = DrawerDefaults.INSTANCE.m3297getModalDrawerElevationD9Ej5fM();
                }
                if ((i2 & 64) != 0) {
                    modifier3 = modifier2;
                    shape3 = shape2;
                    j3 = modalContainerColor;
                    j4 = jM3051contentColorForek8zF_U;
                    f2 = fM3297getModalDrawerElevationD9Ej5fM;
                    i6 = i3 & (-3670017);
                    windowInsets4 = DrawerDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                } else {
                    modifier3 = modifier2;
                    shape3 = shape2;
                    j3 = modalContainerColor;
                    j4 = jM3051contentColorForek8zF_U;
                    f2 = fM3297getModalDrawerElevationD9Ej5fM;
                    i6 = i3;
                    windowInsets4 = windowInsets2;
                }
            } else {
                if (i8 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if ((i2 & 4) != 0) {
                    i3 &= -897;
                    shape2 = DrawerDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                }
                if ((i2 & 8) != 0) {
                    modalContainerColor = DrawerDefaults.INSTANCE.getModalContainerColor(composerStartRestartGroup, 6);
                    i3 &= -7169;
                }
                if ((i2 & 16) != 0) {
                    jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(modalContainerColor, composerStartRestartGroup, (i3 >> 9) & 14);
                    i3 &= -57345;
                }
                if (i4 != 0) {
                    fM3297getModalDrawerElevationD9Ej5fM = DrawerDefaults.INSTANCE.m3297getModalDrawerElevationD9Ej5fM();
                }
                if ((i2 & 64) != 0) {
                    modifier3 = modifier2;
                    shape3 = shape2;
                    j3 = modalContainerColor;
                    j4 = jM3051contentColorForek8zF_U;
                    f2 = fM3297getModalDrawerElevationD9Ej5fM;
                    i6 = i3 & (-3670017);
                    windowInsets4 = DrawerDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                } else {
                    modifier3 = modifier2;
                    shape3 = shape2;
                    j3 = modalContainerColor;
                    j4 = jM3051contentColorForek8zF_U;
                    f2 = fM3297getModalDrawerElevationD9Ej5fM;
                    i6 = i3;
                    windowInsets4 = windowInsets2;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1620540727, i6, -1, "androidx.compose.material3.ModalDrawerSheet (NavigationDrawer.kt:699)");
            }
            final Function3 function9 = function4;
            DrawerPredictiveBackHandler(drawerState, ComposableLambdaKt.rememberComposableLambda(797187326, true, new Function3() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda13
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return NavigationDrawerKt.ModalDrawerSheet_Snr_uVM$lambda$0(windowInsets4, modifier3, shape3, j3, j4, f2, drawerState, function9, (DrawerPredictiveBackState) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, (i6 & 14) | 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            windowInsets3 = windowInsets4;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
            shape3 = shape2;
            j3 = modalContainerColor;
            j4 = jM3051contentColorForek8zF_U;
            f2 = fM3297getModalDrawerElevationD9Ej5fM;
            windowInsets3 = windowInsets2;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda14
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return NavigationDrawerKt.ModalDrawerSheet_Snr_uVM$lambda$1(drawerState, modifier3, shape3, j3, j4, f2, windowInsets3, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ModalDrawerSheet_Snr_uVM$lambda$0(WindowInsets windowInsets, Modifier modifier, Shape shape, long j, long j2, float f, final DrawerState drawerState, Function3 function3, DrawerPredictiveBackState drawerPredictiveBackState, Composer composer, int i) {
        DrawerPredictiveBackState drawerPredictiveBackState2;
        int i2;
        ComposerKt.sourceInformation(composer, "CN(drawerPredictiveBackState)709@30249L45,701@29862L474:NavigationDrawer.kt#uh7d8r");
        if ((i & 6) == 0) {
            drawerPredictiveBackState2 = drawerPredictiveBackState;
            i2 = i | (composer.changed(drawerPredictiveBackState2) ? 4 : 2);
        } else {
            drawerPredictiveBackState2 = drawerPredictiveBackState;
            i2 = i;
        }
        if (!composer.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(797187326, i2, -1, "androidx.compose.material3.ModalDrawerSheet.<anonymous> (NavigationDrawer.kt:701)");
            }
            ComposerKt.sourceInformationMarkerStart(composer, 1592855275, "CC(remember):NavigationDrawer.kt#9igjgp");
            boolean zChanged = composer.changed(drawerState);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new FloatProducer() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda1
                    @Override // androidx.compose.material3.internal.FloatProducer
                    public final float invoke() {
                        return NavigationDrawerKt.ModalDrawerSheet_Snr_uVM$lambda$0$0$0(drawerState);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            m3865DrawerSheetcm3T3N0(drawerPredictiveBackState2, windowInsets, modifier, shape, j, j2, f, (FloatProducer) objRememberedValue, function3, composer, i2 & 14, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float ModalDrawerSheet_Snr_uVM$lambda$0$0$0(DrawerState drawerState) {
        return drawerState.getAnchoredDraggableState$material3().getOffset();
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0126  */
    /* JADX WARN: Code duplicated, block: B:103:0x012f  */
    /* JADX WARN: Code duplicated, block: B:106:0x013b  */
    /* JADX WARN: Code duplicated, block: B:108:0x0148  */
    /* JADX WARN: Code duplicated, block: B:111:0x0153  */
    /* JADX WARN: Code duplicated, block: B:112:0x0164  */
    /* JADX WARN: Code duplicated, block: B:116:0x0178  */
    /* JADX WARN: Code duplicated, block: B:119:0x01af  */
    /* JADX WARN: Code duplicated, block: B:121:0x01bb  */
    /* JADX WARN: Code duplicated, block: B:124:0x01cc  */
    /* JADX WARN: Code duplicated, block: B:126:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:26:0x004e  */
    /* JADX WARN: Code duplicated, block: B:28:0x0052  */
    /* JADX WARN: Code duplicated, block: B:30:0x005a  */
    /* JADX WARN: Code duplicated, block: B:31:0x005d  */
    /* JADX WARN: Code duplicated, block: B:34:0x0063  */
    /* JADX WARN: Code duplicated, block: B:37:0x0069  */
    /* JADX WARN: Code duplicated, block: B:42:0x0078  */
    /* JADX WARN: Code duplicated, block: B:44:0x007c  */
    /* JADX WARN: Code duplicated, block: B:47:0x0082  */
    /* JADX WARN: Code duplicated, block: B:48:0x0085  */
    /* JADX WARN: Code duplicated, block: B:50:0x0089  */
    /* JADX WARN: Code duplicated, block: B:52:0x0091  */
    /* JADX WARN: Code duplicated, block: B:53:0x0094  */
    /* JADX WARN: Code duplicated, block: B:58:0x009f  */
    /* JADX WARN: Code duplicated, block: B:60:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:62:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:63:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:66:0x00b4  */
    /* JADX WARN: Code duplicated, block: B:69:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:71:0x00c3  */
    /* JADX WARN: Code duplicated, block: B:72:0x00c6  */
    /* JADX WARN: Code duplicated, block: B:74:0x00cb  */
    /* JADX WARN: Code duplicated, block: B:77:0x00d9  */
    /* JADX WARN: Code duplicated, block: B:78:0x00db  */
    /* JADX WARN: Code duplicated, block: B:81:0x00e4  */
    /* JADX WARN: Code duplicated, block: B:83:0x00f4  */
    /* JADX WARN: Code duplicated, block: B:96:0x011c A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:97:0x011e  */
    /* JADX WARN: Code duplicated, block: B:98:0x0123  */
    /* JADX INFO: renamed from: DismissibleDrawerSheet-afqeVBk, reason: not valid java name */
    public static final void m3864DismissibleDrawerSheetafqeVBk(Modifier modifier, Shape shape, long j, long j2, float f, WindowInsets windowInsets, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        Shape rectangleShape;
        long standardContainerColor;
        long jM3051contentColorForek8zF_U;
        int i4;
        float fM3295getDismissibleDrawerElevationD9Ej5fM;
        int i5;
        WindowInsets windowInsets2;
        boolean z;
        Composer composer2;
        final Modifier modifier3;
        final Shape shape2;
        final long j3;
        final long j4;
        final float f2;
        final WindowInsets windowInsets3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        WindowInsets windowInsets4;
        int i6;
        int i7;
        int i8;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1496398234);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(DismissibleDrawerSheet)N(modifier,drawerShape,drawerContainerColor:c#ui.graphics.Color,drawerContentColor:c#ui.graphics.Color,drawerTonalElevation:c#ui.unit.Dp,windowInsets,content)745@32050L343:NavigationDrawer.kt#uh7d8r");
        int i9 = i2 & 1;
        if (i9 != 0) {
            i3 = i | 6;
            modifier2 = modifier;
        } else if ((i & 6) == 0) {
            modifier2 = modifier;
            i3 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i;
        } else {
            modifier2 = modifier;
            i3 = i;
        }
        int i10 = i2 & 2;
        if (i10 == 0) {
            if ((i & 48) == 0) {
                rectangleShape = shape;
                i3 |= composerStartRestartGroup.changed(rectangleShape) ? 32 : 16;
            }
            if ((i & 384) == 0) {
                if ((i2 & 4) == 0) {
                    standardContainerColor = j;
                    int i11 = composerStartRestartGroup.changed(standardContainerColor) ? 256 : 128;
                    i3 |= i11;
                } else {
                    standardContainerColor = j;
                }
                i3 |= i11;
            } else {
                standardContainerColor = j;
            }
            if ((i & 3072) == 0) {
                jM3051contentColorForek8zF_U = j2;
                if ((i2 & 8) == 0 || !composerStartRestartGroup.changed(jM3051contentColorForek8zF_U)) {
                    i8 = 1024;
                } else {
                    i8 = 2048;
                }
                i3 |= i8;
            } else {
                jM3051contentColorForek8zF_U = j2;
            }
            i4 = i2 & 16;
            if (i4 != 0) {
                if ((i & 24576) == 0) {
                    fM3295getDismissibleDrawerElevationD9Ej5fM = f;
                    if (composerStartRestartGroup.changed(fM3295getDismissibleDrawerElevationD9Ej5fM)) {
                        i5 = 16384;
                    } else {
                        i5 = 8192;
                    }
                    i3 |= i5;
                }
                if ((196608 & i) == 0) {
                    if ((i2 & 32) == 0) {
                        windowInsets2 = windowInsets;
                        int i12 = composerStartRestartGroup.changed(windowInsets2) ? 131072 : 65536;
                        i3 |= i12;
                    } else {
                        windowInsets2 = windowInsets;
                    }
                    i3 |= i12;
                } else {
                    windowInsets2 = windowInsets;
                }
                if ((1572864 & i) != 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i7 = 1048576;
                    } else {
                        i7 = 524288;
                    }
                    i3 |= i7;
                }
                if ((i3 & 599187) != 599186) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "739@31762L22,740@31818L37,742@31979L12");
                    if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                        if (i9 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i10 != 0) {
                            rectangleShape = RectangleShapeKt.getRectangleShape();
                        }
                        if ((i2 & 4) != 0) {
                            standardContainerColor = DrawerDefaults.INSTANCE.getStandardContainerColor(composerStartRestartGroup, 6);
                            i3 &= -897;
                        }
                        if ((i2 & 8) != 0) {
                            jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(standardContainerColor, composerStartRestartGroup, (i3 >> 6) & 14);
                            i3 &= -7169;
                        }
                        if (i4 != 0) {
                            fM3295getDismissibleDrawerElevationD9Ej5fM = DrawerDefaults.INSTANCE.m3295getDismissibleDrawerElevationD9Ej5fM();
                        }
                        if ((i2 & 32) != 0) {
                            i3 &= -458753;
                            windowInsets4 = DrawerDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                        } else {
                            windowInsets4 = windowInsets2;
                        }
                        i6 = -1496398234;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                        }
                        if ((i2 & 8) != 0) {
                            i3 &= -7169;
                        }
                        if ((i2 & 32) != 0) {
                            i3 &= -458753;
                        }
                        standardContainerColor = standardContainerColor;
                        jM3051contentColorForek8zF_U = jM3051contentColorForek8zF_U;
                        fM3295getDismissibleDrawerElevationD9Ej5fM = fM3295getDismissibleDrawerElevationD9Ej5fM;
                        windowInsets4 = windowInsets2;
                        i6 = -1496398234;
                        companion = modifier2;
                        rectangleShape = rectangleShape;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(i6, i3, -1, "androidx.compose.material3.DismissibleDrawerSheet (NavigationDrawer.kt:744)");
                    }
                    int i13 = i3 << 6;
                    composer2 = composerStartRestartGroup;
                    m3865DrawerSheetcm3T3N0(null, windowInsets4, companion, rectangleShape, standardContainerColor, jM3051contentColorForek8zF_U, fM3295getDismissibleDrawerElevationD9Ej5fM, null, function3, composer2, ((i3 >> 12) & 112) | 6 | (i13 & 896) | (i13 & 7168) | (57344 & i13) | (458752 & i13) | (3670016 & i13) | (i13 & 234881024), 128);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    windowInsets3 = windowInsets4;
                    modifier3 = companion;
                    shape2 = rectangleShape;
                    j3 = standardContainerColor;
                    j4 = jM3051contentColorForek8zF_U;
                    f2 = fM3295getDismissibleDrawerElevationD9Ej5fM;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    modifier3 = modifier2;
                    shape2 = rectangleShape;
                    j3 = standardContainerColor;
                    j4 = jM3051contentColorForek8zF_U;
                    f2 = fM3295getDismissibleDrawerElevationD9Ej5fM;
                    windowInsets3 = windowInsets2;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return NavigationDrawerKt.DismissibleDrawerSheet_afqeVBk$lambda$0(modifier3, shape2, j3, j4, f2, windowInsets3, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 24576;
            fM3295getDismissibleDrawerElevationD9Ej5fM = f;
            if ((196608 & i) == 0) {
                if ((i2 & 32) == 0) {
                    windowInsets2 = windowInsets;
                    if (composerStartRestartGroup.changed(windowInsets2)) {
                    }
                    i3 |= i12;
                } else {
                    windowInsets2 = windowInsets;
                }
                i3 |= i12;
            } else {
                windowInsets2 = windowInsets;
            }
            if ((1572864 & i) != 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i7 = 1048576;
                } else {
                    i7 = 524288;
                }
                i3 |= i7;
            }
            if ((i3 & 599187) != 599186) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "739@31762L22,740@31818L37,742@31979L12");
                if ((i & 1) != 0) {
                    if (i9 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i10 != 0) {
                        rectangleShape = RectangleShapeKt.getRectangleShape();
                    }
                    if ((i2 & 4) != 0) {
                        standardContainerColor = DrawerDefaults.INSTANCE.getStandardContainerColor(composerStartRestartGroup, 6);
                        i3 &= -897;
                    }
                    if ((i2 & 8) != 0) {
                        jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(standardContainerColor, composerStartRestartGroup, (i3 >> 6) & 14);
                        i3 &= -7169;
                    }
                    if (i4 != 0) {
                        fM3295getDismissibleDrawerElevationD9Ej5fM = DrawerDefaults.INSTANCE.m3295getDismissibleDrawerElevationD9Ej5fM();
                    }
                    if ((i2 & 32) != 0) {
                        i3 &= -458753;
                        windowInsets4 = DrawerDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                    } else {
                        windowInsets4 = windowInsets2;
                    }
                    i6 = -1496398234;
                } else {
                    if (i9 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i10 != 0) {
                        rectangleShape = RectangleShapeKt.getRectangleShape();
                    }
                    if ((i2 & 4) != 0) {
                        standardContainerColor = DrawerDefaults.INSTANCE.getStandardContainerColor(composerStartRestartGroup, 6);
                        i3 &= -897;
                    }
                    if ((i2 & 8) != 0) {
                        jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(standardContainerColor, composerStartRestartGroup, (i3 >> 6) & 14);
                        i3 &= -7169;
                    }
                    if (i4 != 0) {
                        fM3295getDismissibleDrawerElevationD9Ej5fM = DrawerDefaults.INSTANCE.m3295getDismissibleDrawerElevationD9Ej5fM();
                    }
                    if ((i2 & 32) != 0) {
                        i3 &= -458753;
                        windowInsets4 = DrawerDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                    } else {
                        windowInsets4 = windowInsets2;
                    }
                    i6 = -1496398234;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(i6, i3, -1, "androidx.compose.material3.DismissibleDrawerSheet (NavigationDrawer.kt:744)");
                }
                int i14 = i3 << 6;
                composer2 = composerStartRestartGroup;
                m3865DrawerSheetcm3T3N0(null, windowInsets4, companion, rectangleShape, standardContainerColor, jM3051contentColorForek8zF_U, fM3295getDismissibleDrawerElevationD9Ej5fM, null, function3, composer2, ((i3 >> 12) & 112) | 6 | (i14 & 896) | (i14 & 7168) | (57344 & i14) | (458752 & i14) | (3670016 & i14) | (i14 & 234881024), 128);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                windowInsets3 = windowInsets4;
                modifier3 = companion;
                shape2 = rectangleShape;
                j3 = standardContainerColor;
                j4 = jM3051contentColorForek8zF_U;
                f2 = fM3295getDismissibleDrawerElevationD9Ej5fM;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier3 = modifier2;
                shape2 = rectangleShape;
                j3 = standardContainerColor;
                j4 = jM3051contentColorForek8zF_U;
                f2 = fM3295getDismissibleDrawerElevationD9Ej5fM;
                windowInsets3 = windowInsets2;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return NavigationDrawerKt.DismissibleDrawerSheet_afqeVBk$lambda$0(modifier3, shape2, j3, j4, f2, windowInsets3, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 48;
        rectangleShape = shape;
        if ((i & 384) == 0) {
            if ((i2 & 4) == 0) {
                standardContainerColor = j;
                if (composerStartRestartGroup.changed(standardContainerColor)) {
                }
                i3 |= i11;
            } else {
                standardContainerColor = j;
            }
            i3 |= i11;
        } else {
            standardContainerColor = j;
        }
        if ((i & 3072) == 0) {
            jM3051contentColorForek8zF_U = j2;
            if ((i2 & 8) == 0) {
                i8 = 1024;
            } else {
                i8 = 1024;
            }
            i3 |= i8;
        } else {
            jM3051contentColorForek8zF_U = j2;
        }
        i4 = i2 & 16;
        if (i4 != 0) {
            if ((i & 24576) == 0) {
                fM3295getDismissibleDrawerElevationD9Ej5fM = f;
                if (composerStartRestartGroup.changed(fM3295getDismissibleDrawerElevationD9Ej5fM)) {
                    i5 = 16384;
                } else {
                    i5 = 8192;
                }
                i3 |= i5;
            }
            if ((196608 & i) == 0) {
                if ((i2 & 32) == 0) {
                    windowInsets2 = windowInsets;
                    if (composerStartRestartGroup.changed(windowInsets2)) {
                    }
                    i3 |= i12;
                } else {
                    windowInsets2 = windowInsets;
                }
                i3 |= i12;
            } else {
                windowInsets2 = windowInsets;
            }
            if ((1572864 & i) != 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i7 = 1048576;
                } else {
                    i7 = 524288;
                }
                i3 |= i7;
            }
            if ((i3 & 599187) != 599186) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "739@31762L22,740@31818L37,742@31979L12");
                if ((i & 1) != 0) {
                    if (i9 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i10 != 0) {
                        rectangleShape = RectangleShapeKt.getRectangleShape();
                    }
                    if ((i2 & 4) != 0) {
                        standardContainerColor = DrawerDefaults.INSTANCE.getStandardContainerColor(composerStartRestartGroup, 6);
                        i3 &= -897;
                    }
                    if ((i2 & 8) != 0) {
                        jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(standardContainerColor, composerStartRestartGroup, (i3 >> 6) & 14);
                        i3 &= -7169;
                    }
                    if (i4 != 0) {
                        fM3295getDismissibleDrawerElevationD9Ej5fM = DrawerDefaults.INSTANCE.m3295getDismissibleDrawerElevationD9Ej5fM();
                    }
                    if ((i2 & 32) != 0) {
                        i3 &= -458753;
                        windowInsets4 = DrawerDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                    } else {
                        windowInsets4 = windowInsets2;
                    }
                    i6 = -1496398234;
                } else {
                    if (i9 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i10 != 0) {
                        rectangleShape = RectangleShapeKt.getRectangleShape();
                    }
                    if ((i2 & 4) != 0) {
                        standardContainerColor = DrawerDefaults.INSTANCE.getStandardContainerColor(composerStartRestartGroup, 6);
                        i3 &= -897;
                    }
                    if ((i2 & 8) != 0) {
                        jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(standardContainerColor, composerStartRestartGroup, (i3 >> 6) & 14);
                        i3 &= -7169;
                    }
                    if (i4 != 0) {
                        fM3295getDismissibleDrawerElevationD9Ej5fM = DrawerDefaults.INSTANCE.m3295getDismissibleDrawerElevationD9Ej5fM();
                    }
                    if ((i2 & 32) != 0) {
                        i3 &= -458753;
                        windowInsets4 = DrawerDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                    } else {
                        windowInsets4 = windowInsets2;
                    }
                    i6 = -1496398234;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(i6, i3, -1, "androidx.compose.material3.DismissibleDrawerSheet (NavigationDrawer.kt:744)");
                }
                int i15 = i3 << 6;
                composer2 = composerStartRestartGroup;
                m3865DrawerSheetcm3T3N0(null, windowInsets4, companion, rectangleShape, standardContainerColor, jM3051contentColorForek8zF_U, fM3295getDismissibleDrawerElevationD9Ej5fM, null, function3, composer2, ((i3 >> 12) & 112) | 6 | (i15 & 896) | (i15 & 7168) | (57344 & i15) | (458752 & i15) | (3670016 & i15) | (i15 & 234881024), 128);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                windowInsets3 = windowInsets4;
                modifier3 = companion;
                shape2 = rectangleShape;
                j3 = standardContainerColor;
                j4 = jM3051contentColorForek8zF_U;
                f2 = fM3295getDismissibleDrawerElevationD9Ej5fM;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier3 = modifier2;
                shape2 = rectangleShape;
                j3 = standardContainerColor;
                j4 = jM3051contentColorForek8zF_U;
                f2 = fM3295getDismissibleDrawerElevationD9Ej5fM;
                windowInsets3 = windowInsets2;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return NavigationDrawerKt.DismissibleDrawerSheet_afqeVBk$lambda$0(modifier3, shape2, j3, j4, f2, windowInsets3, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 24576;
        fM3295getDismissibleDrawerElevationD9Ej5fM = f;
        if ((196608 & i) == 0) {
            if ((i2 & 32) == 0) {
                windowInsets2 = windowInsets;
                if (composerStartRestartGroup.changed(windowInsets2)) {
                }
                i3 |= i12;
            } else {
                windowInsets2 = windowInsets;
            }
            i3 |= i12;
        } else {
            windowInsets2 = windowInsets;
        }
        if ((1572864 & i) != 0) {
            if (composerStartRestartGroup.changedInstance(function3)) {
                i7 = 1048576;
            } else {
                i7 = 524288;
            }
            i3 |= i7;
        }
        if ((i3 & 599187) != 599186) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "739@31762L22,740@31818L37,742@31979L12");
            if ((i & 1) != 0) {
                if (i9 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i10 != 0) {
                    rectangleShape = RectangleShapeKt.getRectangleShape();
                }
                if ((i2 & 4) != 0) {
                    standardContainerColor = DrawerDefaults.INSTANCE.getStandardContainerColor(composerStartRestartGroup, 6);
                    i3 &= -897;
                }
                if ((i2 & 8) != 0) {
                    jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(standardContainerColor, composerStartRestartGroup, (i3 >> 6) & 14);
                    i3 &= -7169;
                }
                if (i4 != 0) {
                    fM3295getDismissibleDrawerElevationD9Ej5fM = DrawerDefaults.INSTANCE.m3295getDismissibleDrawerElevationD9Ej5fM();
                }
                if ((i2 & 32) != 0) {
                    i3 &= -458753;
                    windowInsets4 = DrawerDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                } else {
                    windowInsets4 = windowInsets2;
                }
                i6 = -1496398234;
            } else {
                if (i9 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i10 != 0) {
                    rectangleShape = RectangleShapeKt.getRectangleShape();
                }
                if ((i2 & 4) != 0) {
                    standardContainerColor = DrawerDefaults.INSTANCE.getStandardContainerColor(composerStartRestartGroup, 6);
                    i3 &= -897;
                }
                if ((i2 & 8) != 0) {
                    jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(standardContainerColor, composerStartRestartGroup, (i3 >> 6) & 14);
                    i3 &= -7169;
                }
                if (i4 != 0) {
                    fM3295getDismissibleDrawerElevationD9Ej5fM = DrawerDefaults.INSTANCE.m3295getDismissibleDrawerElevationD9Ej5fM();
                }
                if ((i2 & 32) != 0) {
                    i3 &= -458753;
                    windowInsets4 = DrawerDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                } else {
                    windowInsets4 = windowInsets2;
                }
                i6 = -1496398234;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(i6, i3, -1, "androidx.compose.material3.DismissibleDrawerSheet (NavigationDrawer.kt:744)");
            }
            int i16 = i3 << 6;
            composer2 = composerStartRestartGroup;
            m3865DrawerSheetcm3T3N0(null, windowInsets4, companion, rectangleShape, standardContainerColor, jM3051contentColorForek8zF_U, fM3295getDismissibleDrawerElevationD9Ej5fM, null, function3, composer2, ((i3 >> 12) & 112) | 6 | (i16 & 896) | (i16 & 7168) | (57344 & i16) | (458752 & i16) | (3670016 & i16) | (i16 & 234881024), 128);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            windowInsets3 = windowInsets4;
            modifier3 = companion;
            shape2 = rectangleShape;
            j3 = standardContainerColor;
            j4 = jM3051contentColorForek8zF_U;
            f2 = fM3295getDismissibleDrawerElevationD9Ej5fM;
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            modifier3 = modifier2;
            shape2 = rectangleShape;
            j3 = standardContainerColor;
            j4 = jM3051contentColorForek8zF_U;
            f2 = fM3295getDismissibleDrawerElevationD9Ej5fM;
            windowInsets3 = windowInsets2;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return NavigationDrawerKt.DismissibleDrawerSheet_afqeVBk$lambda$0(modifier3, shape2, j3, j4, f2, windowInsets3, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX WARN: Code duplicated, block: B:102:0x0121 A[PHI: r1 r3 r5 r6 r10 r13
      0x0121: PHI (r1v23 int) = (r1v17 int), (r1v26 int), (r1v27 int) binds: [B:116:0x015e, B:100:0x011e, B:101:0x0120] A[DONT_GENERATE, DONT_INLINE]
      0x0121: PHI (r3v9 androidx.compose.ui.Modifier) = (r3v5 androidx.compose.ui.Modifier), (r3v2 androidx.compose.ui.Modifier), (r3v2 androidx.compose.ui.Modifier) binds: [B:116:0x015e, B:100:0x011e, B:101:0x0120] A[DONT_GENERATE, DONT_INLINE]
      0x0121: PHI (r5v5 androidx.compose.ui.graphics.Shape) = 
      (r5v3 androidx.compose.ui.graphics.Shape)
      (r5v2 androidx.compose.ui.graphics.Shape)
      (r5v2 androidx.compose.ui.graphics.Shape)
     binds: [B:116:0x015e, B:100:0x011e, B:101:0x0120] A[DONT_GENERATE, DONT_INLINE]
      0x0121: PHI (r6v13 long) = (r6v9 long), (r6v6 long), (r6v6 long) binds: [B:116:0x015e, B:100:0x011e, B:101:0x0120] A[DONT_GENERATE, DONT_INLINE]
      0x0121: PHI (r10v12 float) = (r10v5 float), (r10v3 float), (r10v3 float) binds: [B:116:0x015e, B:100:0x011e, B:101:0x0120] A[DONT_GENERATE, DONT_INLINE]
      0x0121: PHI (r13v7 long) = (r13v3 long), (r13v1 long), (r13v1 long) binds: [B:116:0x015e, B:100:0x011e, B:101:0x0120] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:103:0x0129 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:104:0x012b  */
    /* JADX WARN: Code duplicated, block: B:106:0x0132  */
    /* JADX WARN: Code duplicated, block: B:109:0x013c  */
    /* JADX WARN: Code duplicated, block: B:112:0x0148  */
    /* JADX WARN: Code duplicated, block: B:114:0x0155  */
    /* JADX WARN: Code duplicated, block: B:117:0x0160  */
    /* JADX WARN: Code duplicated, block: B:120:0x0177  */
    /* JADX WARN: Code duplicated, block: B:123:0x019f  */
    /* JADX WARN: Code duplicated, block: B:125:0x01a4  */
    /* JADX WARN: Code duplicated, block: B:128:0x01b3  */
    /* JADX WARN: Code duplicated, block: B:130:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:23:0x0042  */
    /* JADX WARN: Code duplicated, block: B:24:0x0045  */
    /* JADX WARN: Code duplicated, block: B:26:0x0049  */
    /* JADX WARN: Code duplicated, block: B:28:0x0051  */
    /* JADX WARN: Code duplicated, block: B:29:0x0054  */
    /* JADX WARN: Code duplicated, block: B:34:0x005e  */
    /* JADX WARN: Code duplicated, block: B:36:0x0062  */
    /* JADX WARN: Code duplicated, block: B:38:0x006a  */
    /* JADX WARN: Code duplicated, block: B:39:0x006d  */
    /* JADX WARN: Code duplicated, block: B:42:0x0073  */
    /* JADX WARN: Code duplicated, block: B:45:0x0079  */
    /* JADX WARN: Code duplicated, block: B:47:0x007f  */
    /* JADX WARN: Code duplicated, block: B:50:0x0088  */
    /* JADX WARN: Code duplicated, block: B:52:0x008c  */
    /* JADX WARN: Code duplicated, block: B:55:0x0094  */
    /* JADX WARN: Code duplicated, block: B:56:0x0096  */
    /* JADX WARN: Code duplicated, block: B:58:0x0099  */
    /* JADX WARN: Code duplicated, block: B:60:0x00a1  */
    /* JADX WARN: Code duplicated, block: B:61:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:66:0x00af  */
    /* JADX WARN: Code duplicated, block: B:68:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:70:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:71:0x00be  */
    /* JADX WARN: Code duplicated, block: B:74:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:77:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:79:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:80:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:84:0x00e9  */
    /* JADX WARN: Code duplicated, block: B:85:0x00eb  */
    /* JADX WARN: Code duplicated, block: B:88:0x00f4  */
    /* JADX WARN: Code duplicated, block: B:90:0x0106  */
    /* JADX INFO: renamed from: DismissibleDrawerSheet-Snr_uVM, reason: not valid java name */
    public static final void m3863DismissibleDrawerSheetSnr_uVM(final DrawerState drawerState, Modifier modifier, Shape shape, long j, long j2, float f, WindowInsets windowInsets, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        Shape rectangleShape;
        int i5;
        long standardContainerColor;
        long jM3051contentColorForek8zF_U;
        int i6;
        float fM3295getDismissibleDrawerElevationD9Ej5fM;
        int i7;
        WindowInsets windowInsets2;
        boolean z;
        final Modifier modifier3;
        final Shape shape2;
        final long j3;
        final float f2;
        final long j4;
        final WindowInsets windowInsets3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i8;
        final WindowInsets windowInsets4;
        int i9;
        int i10;
        Composer composerStartRestartGroup = composer.startRestartGroup(496605370);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(DismissibleDrawerSheet)N(drawerState,modifier,drawerShape,drawerContainerColor:c#ui.graphics.Color,drawerContentColor:c#ui.graphics.Color,drawerTonalElevation:c#ui.unit.Dp,windowInsets,content)789@34190L519,789@34149L560:NavigationDrawer.kt#uh7d8r");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(drawerState) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i11 = i2 & 2;
        if (i11 == 0) {
            if ((i & 48) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            i4 = i2 & 4;
            if (i4 != 0) {
                if ((i & 384) == 0) {
                    rectangleShape = shape;
                    if (composerStartRestartGroup.changed(rectangleShape)) {
                        i5 = 256;
                    } else {
                        i5 = 128;
                    }
                    i3 |= i5;
                }
                if ((i & 3072) == 0) {
                    if ((i2 & 8) == 0) {
                        standardContainerColor = j;
                        int i12 = composerStartRestartGroup.changed(standardContainerColor) ? 2048 : 1024;
                        i3 |= i12;
                    } else {
                        standardContainerColor = j;
                    }
                    i3 |= i12;
                } else {
                    standardContainerColor = j;
                }
                if ((i & 24576) == 0) {
                    jM3051contentColorForek8zF_U = j2;
                    if ((i2 & 16) == 0 || !composerStartRestartGroup.changed(jM3051contentColorForek8zF_U)) {
                        i10 = 8192;
                    } else {
                        i10 = 16384;
                    }
                    i3 |= i10;
                } else {
                    jM3051contentColorForek8zF_U = j2;
                }
                i6 = i2 & 32;
                if (i6 != 0) {
                    if ((196608 & i) == 0) {
                        fM3295getDismissibleDrawerElevationD9Ej5fM = f;
                        if (composerStartRestartGroup.changed(fM3295getDismissibleDrawerElevationD9Ej5fM)) {
                            i7 = 131072;
                        } else {
                            i7 = 65536;
                        }
                        i3 |= i7;
                    }
                    if ((1572864 & i) == 0) {
                        if ((i2 & 64) == 0) {
                            windowInsets2 = windowInsets;
                            int i13 = composerStartRestartGroup.changed(windowInsets2) ? 1048576 : 524288;
                            i3 |= i13;
                        } else {
                            windowInsets2 = windowInsets;
                        }
                        i3 |= i13;
                    } else {
                        windowInsets2 = windowInsets;
                    }
                    if ((i & 12582912) == 0) {
                        if (composerStartRestartGroup.changedInstance(function3)) {
                            i9 = 8388608;
                        } else {
                            i9 = 4194304;
                        }
                        i3 |= i9;
                    }
                    if ((i3 & 4793491) != 4793490) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "783@33861L22,784@33917L37,786@34078L12");
                        if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            if (i11 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                rectangleShape = RectangleShapeKt.getRectangleShape();
                            }
                            if ((i2 & 8) != 0) {
                                standardContainerColor = DrawerDefaults.INSTANCE.getStandardContainerColor(composerStartRestartGroup, 6);
                                i3 &= -7169;
                            }
                            if ((i2 & 16) != 0) {
                                jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(standardContainerColor, composerStartRestartGroup, (i3 >> 9) & 14);
                                i3 &= -57345;
                            }
                            if (i6 != 0) {
                                fM3295getDismissibleDrawerElevationD9Ej5fM = DrawerDefaults.INSTANCE.m3295getDismissibleDrawerElevationD9Ej5fM();
                            }
                            if ((i2 & 64) != 0) {
                                modifier3 = modifier2;
                                shape2 = rectangleShape;
                                j3 = standardContainerColor;
                                f2 = fM3295getDismissibleDrawerElevationD9Ej5fM;
                                j4 = jM3051contentColorForek8zF_U;
                                i8 = i3 & (-3670017);
                                windowInsets4 = DrawerDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(496605370, i8, -1, "androidx.compose.material3.DismissibleDrawerSheet (NavigationDrawer.kt:788)");
                            }
                            DrawerPredictiveBackHandler(drawerState, ComposableLambdaKt.rememberComposableLambda(1623455535, true, new Function3() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda24
                                @Override // kotlin.jvm.functions.Function3
                                public final Object invoke(Object obj, Object obj2, Object obj3) {
                                    return NavigationDrawerKt.DismissibleDrawerSheet_Snr_uVM$lambda$0(windowInsets4, modifier3, shape2, j3, j4, f2, drawerState, function3, (DrawerPredictiveBackState) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                }
                            }, composerStartRestartGroup, 54), composerStartRestartGroup, (i8 & 14) | 48);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            windowInsets3 = windowInsets4;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i2 & 8) != 0) {
                                i3 &= -7169;
                            }
                            if ((i2 & 16) != 0) {
                                i3 &= -57345;
                            }
                            if ((i2 & 64) != 0) {
                                i3 &= -3670017;
                            }
                        }
                        modifier3 = modifier2;
                        shape2 = rectangleShape;
                        j3 = standardContainerColor;
                        f2 = fM3295getDismissibleDrawerElevationD9Ej5fM;
                        j4 = jM3051contentColorForek8zF_U;
                        i8 = i3;
                        windowInsets4 = windowInsets2;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(496605370, i8, -1, "androidx.compose.material3.DismissibleDrawerSheet (NavigationDrawer.kt:788)");
                        }
                        DrawerPredictiveBackHandler(drawerState, ComposableLambdaKt.rememberComposableLambda(1623455535, true, new Function3() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda24
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return NavigationDrawerKt.DismissibleDrawerSheet_Snr_uVM$lambda$0(windowInsets4, modifier3, shape2, j3, j4, f2, drawerState, function3, (DrawerPredictiveBackState) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, (i8 & 14) | 48);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        windowInsets3 = windowInsets4;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        modifier3 = modifier2;
                        shape2 = rectangleShape;
                        j3 = standardContainerColor;
                        f2 = fM3295getDismissibleDrawerElevationD9Ej5fM;
                        j4 = jM3051contentColorForek8zF_U;
                        windowInsets3 = windowInsets2;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda25
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return NavigationDrawerKt.DismissibleDrawerSheet_Snr_uVM$lambda$1(drawerState, modifier3, shape2, j3, j4, f2, windowInsets3, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                fM3295getDismissibleDrawerElevationD9Ej5fM = f;
                if ((1572864 & i) == 0) {
                    if ((i2 & 64) == 0) {
                        windowInsets2 = windowInsets;
                        if (composerStartRestartGroup.changed(windowInsets2)) {
                        }
                        i3 |= i13;
                    } else {
                        windowInsets2 = windowInsets;
                    }
                    i3 |= i13;
                } else {
                    windowInsets2 = windowInsets;
                }
                if ((i & 12582912) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i9 = 8388608;
                    } else {
                        i9 = 4194304;
                    }
                    i3 |= i9;
                }
                if ((i3 & 4793491) != 4793490) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "783@33861L22,784@33917L37,786@34078L12");
                    if ((i & 1) != 0) {
                        if (i11 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            rectangleShape = RectangleShapeKt.getRectangleShape();
                        }
                        if ((i2 & 8) != 0) {
                            standardContainerColor = DrawerDefaults.INSTANCE.getStandardContainerColor(composerStartRestartGroup, 6);
                            i3 &= -7169;
                        }
                        if ((i2 & 16) != 0) {
                            jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(standardContainerColor, composerStartRestartGroup, (i3 >> 9) & 14);
                            i3 &= -57345;
                        }
                        if (i6 != 0) {
                            fM3295getDismissibleDrawerElevationD9Ej5fM = DrawerDefaults.INSTANCE.m3295getDismissibleDrawerElevationD9Ej5fM();
                        }
                        if ((i2 & 64) != 0) {
                            modifier3 = modifier2;
                            shape2 = rectangleShape;
                            j3 = standardContainerColor;
                            f2 = fM3295getDismissibleDrawerElevationD9Ej5fM;
                            j4 = jM3051contentColorForek8zF_U;
                            i8 = i3 & (-3670017);
                            windowInsets4 = DrawerDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                        } else {
                            modifier3 = modifier2;
                            shape2 = rectangleShape;
                            j3 = standardContainerColor;
                            f2 = fM3295getDismissibleDrawerElevationD9Ej5fM;
                            j4 = jM3051contentColorForek8zF_U;
                            i8 = i3;
                            windowInsets4 = windowInsets2;
                        }
                    } else {
                        if (i11 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            rectangleShape = RectangleShapeKt.getRectangleShape();
                        }
                        if ((i2 & 8) != 0) {
                            standardContainerColor = DrawerDefaults.INSTANCE.getStandardContainerColor(composerStartRestartGroup, 6);
                            i3 &= -7169;
                        }
                        if ((i2 & 16) != 0) {
                            jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(standardContainerColor, composerStartRestartGroup, (i3 >> 9) & 14);
                            i3 &= -57345;
                        }
                        if (i6 != 0) {
                            fM3295getDismissibleDrawerElevationD9Ej5fM = DrawerDefaults.INSTANCE.m3295getDismissibleDrawerElevationD9Ej5fM();
                        }
                        if ((i2 & 64) != 0) {
                            modifier3 = modifier2;
                            shape2 = rectangleShape;
                            j3 = standardContainerColor;
                            f2 = fM3295getDismissibleDrawerElevationD9Ej5fM;
                            j4 = jM3051contentColorForek8zF_U;
                            i8 = i3 & (-3670017);
                            windowInsets4 = DrawerDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                        } else {
                            modifier3 = modifier2;
                            shape2 = rectangleShape;
                            j3 = standardContainerColor;
                            f2 = fM3295getDismissibleDrawerElevationD9Ej5fM;
                            j4 = jM3051contentColorForek8zF_U;
                            i8 = i3;
                            windowInsets4 = windowInsets2;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(496605370, i8, -1, "androidx.compose.material3.DismissibleDrawerSheet (NavigationDrawer.kt:788)");
                    }
                    DrawerPredictiveBackHandler(drawerState, ComposableLambdaKt.rememberComposableLambda(1623455535, true, new Function3() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda24
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return NavigationDrawerKt.DismissibleDrawerSheet_Snr_uVM$lambda$0(windowInsets4, modifier3, shape2, j3, j4, f2, drawerState, function3, (DrawerPredictiveBackState) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, (i8 & 14) | 48);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    windowInsets3 = windowInsets4;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier3 = modifier2;
                    shape2 = rectangleShape;
                    j3 = standardContainerColor;
                    f2 = fM3295getDismissibleDrawerElevationD9Ej5fM;
                    j4 = jM3051contentColorForek8zF_U;
                    windowInsets3 = windowInsets2;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda25
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return NavigationDrawerKt.DismissibleDrawerSheet_Snr_uVM$lambda$1(drawerState, modifier3, shape2, j3, j4, f2, windowInsets3, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 384;
            rectangleShape = shape;
            if ((i & 3072) == 0) {
                if ((i2 & 8) == 0) {
                    standardContainerColor = j;
                    if (composerStartRestartGroup.changed(standardContainerColor)) {
                    }
                    i3 |= i12;
                } else {
                    standardContainerColor = j;
                }
                i3 |= i12;
            } else {
                standardContainerColor = j;
            }
            if ((i & 24576) == 0) {
                jM3051contentColorForek8zF_U = j2;
                if ((i2 & 16) == 0) {
                    i10 = 8192;
                } else {
                    i10 = 8192;
                }
                i3 |= i10;
            } else {
                jM3051contentColorForek8zF_U = j2;
            }
            i6 = i2 & 32;
            if (i6 != 0) {
                if ((196608 & i) == 0) {
                    fM3295getDismissibleDrawerElevationD9Ej5fM = f;
                    if (composerStartRestartGroup.changed(fM3295getDismissibleDrawerElevationD9Ej5fM)) {
                        i7 = 131072;
                    } else {
                        i7 = 65536;
                    }
                    i3 |= i7;
                }
                if ((1572864 & i) == 0) {
                    if ((i2 & 64) == 0) {
                        windowInsets2 = windowInsets;
                        if (composerStartRestartGroup.changed(windowInsets2)) {
                        }
                        i3 |= i13;
                    } else {
                        windowInsets2 = windowInsets;
                    }
                    i3 |= i13;
                } else {
                    windowInsets2 = windowInsets;
                }
                if ((i & 12582912) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i9 = 8388608;
                    } else {
                        i9 = 4194304;
                    }
                    i3 |= i9;
                }
                if ((i3 & 4793491) != 4793490) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "783@33861L22,784@33917L37,786@34078L12");
                    if ((i & 1) != 0) {
                        if (i11 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            rectangleShape = RectangleShapeKt.getRectangleShape();
                        }
                        if ((i2 & 8) != 0) {
                            standardContainerColor = DrawerDefaults.INSTANCE.getStandardContainerColor(composerStartRestartGroup, 6);
                            i3 &= -7169;
                        }
                        if ((i2 & 16) != 0) {
                            jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(standardContainerColor, composerStartRestartGroup, (i3 >> 9) & 14);
                            i3 &= -57345;
                        }
                        if (i6 != 0) {
                            fM3295getDismissibleDrawerElevationD9Ej5fM = DrawerDefaults.INSTANCE.m3295getDismissibleDrawerElevationD9Ej5fM();
                        }
                        if ((i2 & 64) != 0) {
                            modifier3 = modifier2;
                            shape2 = rectangleShape;
                            j3 = standardContainerColor;
                            f2 = fM3295getDismissibleDrawerElevationD9Ej5fM;
                            j4 = jM3051contentColorForek8zF_U;
                            i8 = i3 & (-3670017);
                            windowInsets4 = DrawerDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                        } else {
                            modifier3 = modifier2;
                            shape2 = rectangleShape;
                            j3 = standardContainerColor;
                            f2 = fM3295getDismissibleDrawerElevationD9Ej5fM;
                            j4 = jM3051contentColorForek8zF_U;
                            i8 = i3;
                            windowInsets4 = windowInsets2;
                        }
                    } else {
                        if (i11 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            rectangleShape = RectangleShapeKt.getRectangleShape();
                        }
                        if ((i2 & 8) != 0) {
                            standardContainerColor = DrawerDefaults.INSTANCE.getStandardContainerColor(composerStartRestartGroup, 6);
                            i3 &= -7169;
                        }
                        if ((i2 & 16) != 0) {
                            jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(standardContainerColor, composerStartRestartGroup, (i3 >> 9) & 14);
                            i3 &= -57345;
                        }
                        if (i6 != 0) {
                            fM3295getDismissibleDrawerElevationD9Ej5fM = DrawerDefaults.INSTANCE.m3295getDismissibleDrawerElevationD9Ej5fM();
                        }
                        if ((i2 & 64) != 0) {
                            modifier3 = modifier2;
                            shape2 = rectangleShape;
                            j3 = standardContainerColor;
                            f2 = fM3295getDismissibleDrawerElevationD9Ej5fM;
                            j4 = jM3051contentColorForek8zF_U;
                            i8 = i3 & (-3670017);
                            windowInsets4 = DrawerDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                        } else {
                            modifier3 = modifier2;
                            shape2 = rectangleShape;
                            j3 = standardContainerColor;
                            f2 = fM3295getDismissibleDrawerElevationD9Ej5fM;
                            j4 = jM3051contentColorForek8zF_U;
                            i8 = i3;
                            windowInsets4 = windowInsets2;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(496605370, i8, -1, "androidx.compose.material3.DismissibleDrawerSheet (NavigationDrawer.kt:788)");
                    }
                    DrawerPredictiveBackHandler(drawerState, ComposableLambdaKt.rememberComposableLambda(1623455535, true, new Function3() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda24
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return NavigationDrawerKt.DismissibleDrawerSheet_Snr_uVM$lambda$0(windowInsets4, modifier3, shape2, j3, j4, f2, drawerState, function3, (DrawerPredictiveBackState) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, (i8 & 14) | 48);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    windowInsets3 = windowInsets4;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier3 = modifier2;
                    shape2 = rectangleShape;
                    j3 = standardContainerColor;
                    f2 = fM3295getDismissibleDrawerElevationD9Ej5fM;
                    j4 = jM3051contentColorForek8zF_U;
                    windowInsets3 = windowInsets2;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda25
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return NavigationDrawerKt.DismissibleDrawerSheet_Snr_uVM$lambda$1(drawerState, modifier3, shape2, j3, j4, f2, windowInsets3, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            fM3295getDismissibleDrawerElevationD9Ej5fM = f;
            if ((1572864 & i) == 0) {
                if ((i2 & 64) == 0) {
                    windowInsets2 = windowInsets;
                    if (composerStartRestartGroup.changed(windowInsets2)) {
                    }
                    i3 |= i13;
                } else {
                    windowInsets2 = windowInsets;
                }
                i3 |= i13;
            } else {
                windowInsets2 = windowInsets;
            }
            if ((i & 12582912) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i9 = 8388608;
                } else {
                    i9 = 4194304;
                }
                i3 |= i9;
            }
            if ((i3 & 4793491) != 4793490) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "783@33861L22,784@33917L37,786@34078L12");
                if ((i & 1) != 0) {
                    if (i11 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        rectangleShape = RectangleShapeKt.getRectangleShape();
                    }
                    if ((i2 & 8) != 0) {
                        standardContainerColor = DrawerDefaults.INSTANCE.getStandardContainerColor(composerStartRestartGroup, 6);
                        i3 &= -7169;
                    }
                    if ((i2 & 16) != 0) {
                        jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(standardContainerColor, composerStartRestartGroup, (i3 >> 9) & 14);
                        i3 &= -57345;
                    }
                    if (i6 != 0) {
                        fM3295getDismissibleDrawerElevationD9Ej5fM = DrawerDefaults.INSTANCE.m3295getDismissibleDrawerElevationD9Ej5fM();
                    }
                    if ((i2 & 64) != 0) {
                        modifier3 = modifier2;
                        shape2 = rectangleShape;
                        j3 = standardContainerColor;
                        f2 = fM3295getDismissibleDrawerElevationD9Ej5fM;
                        j4 = jM3051contentColorForek8zF_U;
                        i8 = i3 & (-3670017);
                        windowInsets4 = DrawerDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                    } else {
                        modifier3 = modifier2;
                        shape2 = rectangleShape;
                        j3 = standardContainerColor;
                        f2 = fM3295getDismissibleDrawerElevationD9Ej5fM;
                        j4 = jM3051contentColorForek8zF_U;
                        i8 = i3;
                        windowInsets4 = windowInsets2;
                    }
                } else {
                    if (i11 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        rectangleShape = RectangleShapeKt.getRectangleShape();
                    }
                    if ((i2 & 8) != 0) {
                        standardContainerColor = DrawerDefaults.INSTANCE.getStandardContainerColor(composerStartRestartGroup, 6);
                        i3 &= -7169;
                    }
                    if ((i2 & 16) != 0) {
                        jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(standardContainerColor, composerStartRestartGroup, (i3 >> 9) & 14);
                        i3 &= -57345;
                    }
                    if (i6 != 0) {
                        fM3295getDismissibleDrawerElevationD9Ej5fM = DrawerDefaults.INSTANCE.m3295getDismissibleDrawerElevationD9Ej5fM();
                    }
                    if ((i2 & 64) != 0) {
                        modifier3 = modifier2;
                        shape2 = rectangleShape;
                        j3 = standardContainerColor;
                        f2 = fM3295getDismissibleDrawerElevationD9Ej5fM;
                        j4 = jM3051contentColorForek8zF_U;
                        i8 = i3 & (-3670017);
                        windowInsets4 = DrawerDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                    } else {
                        modifier3 = modifier2;
                        shape2 = rectangleShape;
                        j3 = standardContainerColor;
                        f2 = fM3295getDismissibleDrawerElevationD9Ej5fM;
                        j4 = jM3051contentColorForek8zF_U;
                        i8 = i3;
                        windowInsets4 = windowInsets2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(496605370, i8, -1, "androidx.compose.material3.DismissibleDrawerSheet (NavigationDrawer.kt:788)");
                }
                DrawerPredictiveBackHandler(drawerState, ComposableLambdaKt.rememberComposableLambda(1623455535, true, new Function3() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda24
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return NavigationDrawerKt.DismissibleDrawerSheet_Snr_uVM$lambda$0(windowInsets4, modifier3, shape2, j3, j4, f2, drawerState, function3, (DrawerPredictiveBackState) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, (i8 & 14) | 48);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                windowInsets3 = windowInsets4;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                shape2 = rectangleShape;
                j3 = standardContainerColor;
                f2 = fM3295getDismissibleDrawerElevationD9Ej5fM;
                j4 = jM3051contentColorForek8zF_U;
                windowInsets3 = windowInsets2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda25
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return NavigationDrawerKt.DismissibleDrawerSheet_Snr_uVM$lambda$1(drawerState, modifier3, shape2, j3, j4, f2, windowInsets3, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 48;
        modifier2 = modifier;
        i4 = i2 & 4;
        if (i4 != 0) {
            if ((i & 384) == 0) {
                rectangleShape = shape;
                if (composerStartRestartGroup.changed(rectangleShape)) {
                    i5 = 256;
                } else {
                    i5 = 128;
                }
                i3 |= i5;
            }
            if ((i & 3072) == 0) {
                if ((i2 & 8) == 0) {
                    standardContainerColor = j;
                    if (composerStartRestartGroup.changed(standardContainerColor)) {
                    }
                    i3 |= i12;
                } else {
                    standardContainerColor = j;
                }
                i3 |= i12;
            } else {
                standardContainerColor = j;
            }
            if ((i & 24576) == 0) {
                jM3051contentColorForek8zF_U = j2;
                if ((i2 & 16) == 0) {
                    i10 = 8192;
                } else {
                    i10 = 8192;
                }
                i3 |= i10;
            } else {
                jM3051contentColorForek8zF_U = j2;
            }
            i6 = i2 & 32;
            if (i6 != 0) {
                if ((196608 & i) == 0) {
                    fM3295getDismissibleDrawerElevationD9Ej5fM = f;
                    if (composerStartRestartGroup.changed(fM3295getDismissibleDrawerElevationD9Ej5fM)) {
                        i7 = 131072;
                    } else {
                        i7 = 65536;
                    }
                    i3 |= i7;
                }
                if ((1572864 & i) == 0) {
                    if ((i2 & 64) == 0) {
                        windowInsets2 = windowInsets;
                        if (composerStartRestartGroup.changed(windowInsets2)) {
                        }
                        i3 |= i13;
                    } else {
                        windowInsets2 = windowInsets;
                    }
                    i3 |= i13;
                } else {
                    windowInsets2 = windowInsets;
                }
                if ((i & 12582912) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i9 = 8388608;
                    } else {
                        i9 = 4194304;
                    }
                    i3 |= i9;
                }
                if ((i3 & 4793491) != 4793490) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "783@33861L22,784@33917L37,786@34078L12");
                    if ((i & 1) != 0) {
                        if (i11 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            rectangleShape = RectangleShapeKt.getRectangleShape();
                        }
                        if ((i2 & 8) != 0) {
                            standardContainerColor = DrawerDefaults.INSTANCE.getStandardContainerColor(composerStartRestartGroup, 6);
                            i3 &= -7169;
                        }
                        if ((i2 & 16) != 0) {
                            jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(standardContainerColor, composerStartRestartGroup, (i3 >> 9) & 14);
                            i3 &= -57345;
                        }
                        if (i6 != 0) {
                            fM3295getDismissibleDrawerElevationD9Ej5fM = DrawerDefaults.INSTANCE.m3295getDismissibleDrawerElevationD9Ej5fM();
                        }
                        if ((i2 & 64) != 0) {
                            modifier3 = modifier2;
                            shape2 = rectangleShape;
                            j3 = standardContainerColor;
                            f2 = fM3295getDismissibleDrawerElevationD9Ej5fM;
                            j4 = jM3051contentColorForek8zF_U;
                            i8 = i3 & (-3670017);
                            windowInsets4 = DrawerDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                        } else {
                            modifier3 = modifier2;
                            shape2 = rectangleShape;
                            j3 = standardContainerColor;
                            f2 = fM3295getDismissibleDrawerElevationD9Ej5fM;
                            j4 = jM3051contentColorForek8zF_U;
                            i8 = i3;
                            windowInsets4 = windowInsets2;
                        }
                    } else {
                        if (i11 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            rectangleShape = RectangleShapeKt.getRectangleShape();
                        }
                        if ((i2 & 8) != 0) {
                            standardContainerColor = DrawerDefaults.INSTANCE.getStandardContainerColor(composerStartRestartGroup, 6);
                            i3 &= -7169;
                        }
                        if ((i2 & 16) != 0) {
                            jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(standardContainerColor, composerStartRestartGroup, (i3 >> 9) & 14);
                            i3 &= -57345;
                        }
                        if (i6 != 0) {
                            fM3295getDismissibleDrawerElevationD9Ej5fM = DrawerDefaults.INSTANCE.m3295getDismissibleDrawerElevationD9Ej5fM();
                        }
                        if ((i2 & 64) != 0) {
                            modifier3 = modifier2;
                            shape2 = rectangleShape;
                            j3 = standardContainerColor;
                            f2 = fM3295getDismissibleDrawerElevationD9Ej5fM;
                            j4 = jM3051contentColorForek8zF_U;
                            i8 = i3 & (-3670017);
                            windowInsets4 = DrawerDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                        } else {
                            modifier3 = modifier2;
                            shape2 = rectangleShape;
                            j3 = standardContainerColor;
                            f2 = fM3295getDismissibleDrawerElevationD9Ej5fM;
                            j4 = jM3051contentColorForek8zF_U;
                            i8 = i3;
                            windowInsets4 = windowInsets2;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(496605370, i8, -1, "androidx.compose.material3.DismissibleDrawerSheet (NavigationDrawer.kt:788)");
                    }
                    DrawerPredictiveBackHandler(drawerState, ComposableLambdaKt.rememberComposableLambda(1623455535, true, new Function3() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda24
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return NavigationDrawerKt.DismissibleDrawerSheet_Snr_uVM$lambda$0(windowInsets4, modifier3, shape2, j3, j4, f2, drawerState, function3, (DrawerPredictiveBackState) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, (i8 & 14) | 48);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    windowInsets3 = windowInsets4;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier3 = modifier2;
                    shape2 = rectangleShape;
                    j3 = standardContainerColor;
                    f2 = fM3295getDismissibleDrawerElevationD9Ej5fM;
                    j4 = jM3051contentColorForek8zF_U;
                    windowInsets3 = windowInsets2;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda25
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return NavigationDrawerKt.DismissibleDrawerSheet_Snr_uVM$lambda$1(drawerState, modifier3, shape2, j3, j4, f2, windowInsets3, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            fM3295getDismissibleDrawerElevationD9Ej5fM = f;
            if ((1572864 & i) == 0) {
                if ((i2 & 64) == 0) {
                    windowInsets2 = windowInsets;
                    if (composerStartRestartGroup.changed(windowInsets2)) {
                    }
                    i3 |= i13;
                } else {
                    windowInsets2 = windowInsets;
                }
                i3 |= i13;
            } else {
                windowInsets2 = windowInsets;
            }
            if ((i & 12582912) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i9 = 8388608;
                } else {
                    i9 = 4194304;
                }
                i3 |= i9;
            }
            if ((i3 & 4793491) != 4793490) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "783@33861L22,784@33917L37,786@34078L12");
                if ((i & 1) != 0) {
                    if (i11 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        rectangleShape = RectangleShapeKt.getRectangleShape();
                    }
                    if ((i2 & 8) != 0) {
                        standardContainerColor = DrawerDefaults.INSTANCE.getStandardContainerColor(composerStartRestartGroup, 6);
                        i3 &= -7169;
                    }
                    if ((i2 & 16) != 0) {
                        jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(standardContainerColor, composerStartRestartGroup, (i3 >> 9) & 14);
                        i3 &= -57345;
                    }
                    if (i6 != 0) {
                        fM3295getDismissibleDrawerElevationD9Ej5fM = DrawerDefaults.INSTANCE.m3295getDismissibleDrawerElevationD9Ej5fM();
                    }
                    if ((i2 & 64) != 0) {
                        modifier3 = modifier2;
                        shape2 = rectangleShape;
                        j3 = standardContainerColor;
                        f2 = fM3295getDismissibleDrawerElevationD9Ej5fM;
                        j4 = jM3051contentColorForek8zF_U;
                        i8 = i3 & (-3670017);
                        windowInsets4 = DrawerDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                    } else {
                        modifier3 = modifier2;
                        shape2 = rectangleShape;
                        j3 = standardContainerColor;
                        f2 = fM3295getDismissibleDrawerElevationD9Ej5fM;
                        j4 = jM3051contentColorForek8zF_U;
                        i8 = i3;
                        windowInsets4 = windowInsets2;
                    }
                } else {
                    if (i11 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        rectangleShape = RectangleShapeKt.getRectangleShape();
                    }
                    if ((i2 & 8) != 0) {
                        standardContainerColor = DrawerDefaults.INSTANCE.getStandardContainerColor(composerStartRestartGroup, 6);
                        i3 &= -7169;
                    }
                    if ((i2 & 16) != 0) {
                        jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(standardContainerColor, composerStartRestartGroup, (i3 >> 9) & 14);
                        i3 &= -57345;
                    }
                    if (i6 != 0) {
                        fM3295getDismissibleDrawerElevationD9Ej5fM = DrawerDefaults.INSTANCE.m3295getDismissibleDrawerElevationD9Ej5fM();
                    }
                    if ((i2 & 64) != 0) {
                        modifier3 = modifier2;
                        shape2 = rectangleShape;
                        j3 = standardContainerColor;
                        f2 = fM3295getDismissibleDrawerElevationD9Ej5fM;
                        j4 = jM3051contentColorForek8zF_U;
                        i8 = i3 & (-3670017);
                        windowInsets4 = DrawerDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                    } else {
                        modifier3 = modifier2;
                        shape2 = rectangleShape;
                        j3 = standardContainerColor;
                        f2 = fM3295getDismissibleDrawerElevationD9Ej5fM;
                        j4 = jM3051contentColorForek8zF_U;
                        i8 = i3;
                        windowInsets4 = windowInsets2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(496605370, i8, -1, "androidx.compose.material3.DismissibleDrawerSheet (NavigationDrawer.kt:788)");
                }
                DrawerPredictiveBackHandler(drawerState, ComposableLambdaKt.rememberComposableLambda(1623455535, true, new Function3() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda24
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return NavigationDrawerKt.DismissibleDrawerSheet_Snr_uVM$lambda$0(windowInsets4, modifier3, shape2, j3, j4, f2, drawerState, function3, (DrawerPredictiveBackState) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, (i8 & 14) | 48);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                windowInsets3 = windowInsets4;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                shape2 = rectangleShape;
                j3 = standardContainerColor;
                f2 = fM3295getDismissibleDrawerElevationD9Ej5fM;
                j4 = jM3051contentColorForek8zF_U;
                windowInsets3 = windowInsets2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda25
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return NavigationDrawerKt.DismissibleDrawerSheet_Snr_uVM$lambda$1(drawerState, modifier3, shape2, j3, j4, f2, windowInsets3, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 384;
        rectangleShape = shape;
        if ((i & 3072) == 0) {
            if ((i2 & 8) == 0) {
                standardContainerColor = j;
                if (composerStartRestartGroup.changed(standardContainerColor)) {
                }
                i3 |= i12;
            } else {
                standardContainerColor = j;
            }
            i3 |= i12;
        } else {
            standardContainerColor = j;
        }
        if ((i & 24576) == 0) {
            jM3051contentColorForek8zF_U = j2;
            if ((i2 & 16) == 0) {
                i10 = 8192;
            } else {
                i10 = 8192;
            }
            i3 |= i10;
        } else {
            jM3051contentColorForek8zF_U = j2;
        }
        i6 = i2 & 32;
        if (i6 != 0) {
            if ((196608 & i) == 0) {
                fM3295getDismissibleDrawerElevationD9Ej5fM = f;
                if (composerStartRestartGroup.changed(fM3295getDismissibleDrawerElevationD9Ej5fM)) {
                    i7 = 131072;
                } else {
                    i7 = 65536;
                }
                i3 |= i7;
            }
            if ((1572864 & i) == 0) {
                if ((i2 & 64) == 0) {
                    windowInsets2 = windowInsets;
                    if (composerStartRestartGroup.changed(windowInsets2)) {
                    }
                    i3 |= i13;
                } else {
                    windowInsets2 = windowInsets;
                }
                i3 |= i13;
            } else {
                windowInsets2 = windowInsets;
            }
            if ((i & 12582912) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i9 = 8388608;
                } else {
                    i9 = 4194304;
                }
                i3 |= i9;
            }
            if ((i3 & 4793491) != 4793490) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "783@33861L22,784@33917L37,786@34078L12");
                if ((i & 1) != 0) {
                    if (i11 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        rectangleShape = RectangleShapeKt.getRectangleShape();
                    }
                    if ((i2 & 8) != 0) {
                        standardContainerColor = DrawerDefaults.INSTANCE.getStandardContainerColor(composerStartRestartGroup, 6);
                        i3 &= -7169;
                    }
                    if ((i2 & 16) != 0) {
                        jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(standardContainerColor, composerStartRestartGroup, (i3 >> 9) & 14);
                        i3 &= -57345;
                    }
                    if (i6 != 0) {
                        fM3295getDismissibleDrawerElevationD9Ej5fM = DrawerDefaults.INSTANCE.m3295getDismissibleDrawerElevationD9Ej5fM();
                    }
                    if ((i2 & 64) != 0) {
                        modifier3 = modifier2;
                        shape2 = rectangleShape;
                        j3 = standardContainerColor;
                        f2 = fM3295getDismissibleDrawerElevationD9Ej5fM;
                        j4 = jM3051contentColorForek8zF_U;
                        i8 = i3 & (-3670017);
                        windowInsets4 = DrawerDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                    } else {
                        modifier3 = modifier2;
                        shape2 = rectangleShape;
                        j3 = standardContainerColor;
                        f2 = fM3295getDismissibleDrawerElevationD9Ej5fM;
                        j4 = jM3051contentColorForek8zF_U;
                        i8 = i3;
                        windowInsets4 = windowInsets2;
                    }
                } else {
                    if (i11 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        rectangleShape = RectangleShapeKt.getRectangleShape();
                    }
                    if ((i2 & 8) != 0) {
                        standardContainerColor = DrawerDefaults.INSTANCE.getStandardContainerColor(composerStartRestartGroup, 6);
                        i3 &= -7169;
                    }
                    if ((i2 & 16) != 0) {
                        jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(standardContainerColor, composerStartRestartGroup, (i3 >> 9) & 14);
                        i3 &= -57345;
                    }
                    if (i6 != 0) {
                        fM3295getDismissibleDrawerElevationD9Ej5fM = DrawerDefaults.INSTANCE.m3295getDismissibleDrawerElevationD9Ej5fM();
                    }
                    if ((i2 & 64) != 0) {
                        modifier3 = modifier2;
                        shape2 = rectangleShape;
                        j3 = standardContainerColor;
                        f2 = fM3295getDismissibleDrawerElevationD9Ej5fM;
                        j4 = jM3051contentColorForek8zF_U;
                        i8 = i3 & (-3670017);
                        windowInsets4 = DrawerDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                    } else {
                        modifier3 = modifier2;
                        shape2 = rectangleShape;
                        j3 = standardContainerColor;
                        f2 = fM3295getDismissibleDrawerElevationD9Ej5fM;
                        j4 = jM3051contentColorForek8zF_U;
                        i8 = i3;
                        windowInsets4 = windowInsets2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(496605370, i8, -1, "androidx.compose.material3.DismissibleDrawerSheet (NavigationDrawer.kt:788)");
                }
                DrawerPredictiveBackHandler(drawerState, ComposableLambdaKt.rememberComposableLambda(1623455535, true, new Function3() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda24
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return NavigationDrawerKt.DismissibleDrawerSheet_Snr_uVM$lambda$0(windowInsets4, modifier3, shape2, j3, j4, f2, drawerState, function3, (DrawerPredictiveBackState) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, (i8 & 14) | 48);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                windowInsets3 = windowInsets4;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                shape2 = rectangleShape;
                j3 = standardContainerColor;
                f2 = fM3295getDismissibleDrawerElevationD9Ej5fM;
                j4 = jM3051contentColorForek8zF_U;
                windowInsets3 = windowInsets2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda25
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return NavigationDrawerKt.DismissibleDrawerSheet_Snr_uVM$lambda$1(drawerState, modifier3, shape2, j3, j4, f2, windowInsets3, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        fM3295getDismissibleDrawerElevationD9Ej5fM = f;
        if ((1572864 & i) == 0) {
            if ((i2 & 64) == 0) {
                windowInsets2 = windowInsets;
                if (composerStartRestartGroup.changed(windowInsets2)) {
                }
                i3 |= i13;
            } else {
                windowInsets2 = windowInsets;
            }
            i3 |= i13;
        } else {
            windowInsets2 = windowInsets;
        }
        if ((i & 12582912) == 0) {
            if (composerStartRestartGroup.changedInstance(function3)) {
                i9 = 8388608;
            } else {
                i9 = 4194304;
            }
            i3 |= i9;
        }
        if ((i3 & 4793491) != 4793490) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "783@33861L22,784@33917L37,786@34078L12");
            if ((i & 1) != 0) {
                if (i11 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i4 != 0) {
                    rectangleShape = RectangleShapeKt.getRectangleShape();
                }
                if ((i2 & 8) != 0) {
                    standardContainerColor = DrawerDefaults.INSTANCE.getStandardContainerColor(composerStartRestartGroup, 6);
                    i3 &= -7169;
                }
                if ((i2 & 16) != 0) {
                    jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(standardContainerColor, composerStartRestartGroup, (i3 >> 9) & 14);
                    i3 &= -57345;
                }
                if (i6 != 0) {
                    fM3295getDismissibleDrawerElevationD9Ej5fM = DrawerDefaults.INSTANCE.m3295getDismissibleDrawerElevationD9Ej5fM();
                }
                if ((i2 & 64) != 0) {
                    modifier3 = modifier2;
                    shape2 = rectangleShape;
                    j3 = standardContainerColor;
                    f2 = fM3295getDismissibleDrawerElevationD9Ej5fM;
                    j4 = jM3051contentColorForek8zF_U;
                    i8 = i3 & (-3670017);
                    windowInsets4 = DrawerDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                } else {
                    modifier3 = modifier2;
                    shape2 = rectangleShape;
                    j3 = standardContainerColor;
                    f2 = fM3295getDismissibleDrawerElevationD9Ej5fM;
                    j4 = jM3051contentColorForek8zF_U;
                    i8 = i3;
                    windowInsets4 = windowInsets2;
                }
            } else {
                if (i11 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i4 != 0) {
                    rectangleShape = RectangleShapeKt.getRectangleShape();
                }
                if ((i2 & 8) != 0) {
                    standardContainerColor = DrawerDefaults.INSTANCE.getStandardContainerColor(composerStartRestartGroup, 6);
                    i3 &= -7169;
                }
                if ((i2 & 16) != 0) {
                    jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(standardContainerColor, composerStartRestartGroup, (i3 >> 9) & 14);
                    i3 &= -57345;
                }
                if (i6 != 0) {
                    fM3295getDismissibleDrawerElevationD9Ej5fM = DrawerDefaults.INSTANCE.m3295getDismissibleDrawerElevationD9Ej5fM();
                }
                if ((i2 & 64) != 0) {
                    modifier3 = modifier2;
                    shape2 = rectangleShape;
                    j3 = standardContainerColor;
                    f2 = fM3295getDismissibleDrawerElevationD9Ej5fM;
                    j4 = jM3051contentColorForek8zF_U;
                    i8 = i3 & (-3670017);
                    windowInsets4 = DrawerDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                } else {
                    modifier3 = modifier2;
                    shape2 = rectangleShape;
                    j3 = standardContainerColor;
                    f2 = fM3295getDismissibleDrawerElevationD9Ej5fM;
                    j4 = jM3051contentColorForek8zF_U;
                    i8 = i3;
                    windowInsets4 = windowInsets2;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(496605370, i8, -1, "androidx.compose.material3.DismissibleDrawerSheet (NavigationDrawer.kt:788)");
            }
            DrawerPredictiveBackHandler(drawerState, ComposableLambdaKt.rememberComposableLambda(1623455535, true, new Function3() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda24
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return NavigationDrawerKt.DismissibleDrawerSheet_Snr_uVM$lambda$0(windowInsets4, modifier3, shape2, j3, j4, f2, drawerState, function3, (DrawerPredictiveBackState) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, (i8 & 14) | 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            windowInsets3 = windowInsets4;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
            shape2 = rectangleShape;
            j3 = standardContainerColor;
            f2 = fM3295getDismissibleDrawerElevationD9Ej5fM;
            j4 = jM3051contentColorForek8zF_U;
            windowInsets3 = windowInsets2;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda25
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return NavigationDrawerKt.DismissibleDrawerSheet_Snr_uVM$lambda$1(drawerState, modifier3, shape2, j3, j4, f2, windowInsets3, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DismissibleDrawerSheet_Snr_uVM$lambda$0(WindowInsets windowInsets, Modifier modifier, Shape shape, long j, long j2, float f, final DrawerState drawerState, Function3 function3, DrawerPredictiveBackState drawerPredictiveBackState, Composer composer, int i) {
        DrawerPredictiveBackState drawerPredictiveBackState2;
        int i2;
        ComposerKt.sourceInformation(composer, "CN(drawerPredictiveBackState)798@34616L45,790@34229L474:NavigationDrawer.kt#uh7d8r");
        if ((i & 6) == 0) {
            drawerPredictiveBackState2 = drawerPredictiveBackState;
            i2 = i | (composer.changed(drawerPredictiveBackState2) ? 4 : 2);
        } else {
            drawerPredictiveBackState2 = drawerPredictiveBackState;
            i2 = i;
        }
        if (!composer.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1623455535, i2, -1, "androidx.compose.material3.DismissibleDrawerSheet.<anonymous> (NavigationDrawer.kt:790)");
            }
            ComposerKt.sourceInformationMarkerStart(composer, 1067654364, "CC(remember):NavigationDrawer.kt#9igjgp");
            boolean zChanged = composer.changed(drawerState);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new FloatProducer() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda35
                    @Override // androidx.compose.material3.internal.FloatProducer
                    public final float invoke() {
                        return NavigationDrawerKt.DismissibleDrawerSheet_Snr_uVM$lambda$0$0$0(drawerState);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            m3865DrawerSheetcm3T3N0(drawerPredictiveBackState2, windowInsets, modifier, shape, j, j2, f, (FloatProducer) objRememberedValue, function3, composer, i2 & 14, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float DismissibleDrawerSheet_Snr_uVM$lambda$0$0$0(DrawerState drawerState) {
        return drawerState.getAnchoredDraggableState$material3().getOffset();
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0129  */
    /* JADX WARN: Code duplicated, block: B:101:0x012e  */
    /* JADX WARN: Code duplicated, block: B:104:0x0133  */
    /* JADX WARN: Code duplicated, block: B:105:0x013c  */
    /* JADX WARN: Code duplicated, block: B:108:0x0141  */
    /* JADX WARN: Code duplicated, block: B:110:0x014d  */
    /* JADX WARN: Code duplicated, block: B:111:0x0154  */
    /* JADX WARN: Code duplicated, block: B:114:0x0159  */
    /* JADX WARN: Code duplicated, block: B:115:0x016b  */
    /* JADX WARN: Code duplicated, block: B:118:0x017d  */
    /* JADX WARN: Code duplicated, block: B:121:0x01a2  */
    /* JADX WARN: Code duplicated, block: B:123:0x01aa  */
    /* JADX WARN: Code duplicated, block: B:126:0x01ec  */
    /* JADX WARN: Code duplicated, block: B:128:0x01f8  */
    /* JADX WARN: Code duplicated, block: B:131:0x020a  */
    /* JADX WARN: Code duplicated, block: B:133:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:26:0x004e  */
    /* JADX WARN: Code duplicated, block: B:28:0x0052  */
    /* JADX WARN: Code duplicated, block: B:30:0x005a  */
    /* JADX WARN: Code duplicated, block: B:31:0x005d  */
    /* JADX WARN: Code duplicated, block: B:34:0x0063  */
    /* JADX WARN: Code duplicated, block: B:37:0x0069  */
    /* JADX WARN: Code duplicated, block: B:42:0x0078  */
    /* JADX WARN: Code duplicated, block: B:44:0x007c  */
    /* JADX WARN: Code duplicated, block: B:47:0x0082  */
    /* JADX WARN: Code duplicated, block: B:48:0x0085  */
    /* JADX WARN: Code duplicated, block: B:50:0x0089  */
    /* JADX WARN: Code duplicated, block: B:52:0x0091  */
    /* JADX WARN: Code duplicated, block: B:53:0x0094  */
    /* JADX WARN: Code duplicated, block: B:58:0x009f  */
    /* JADX WARN: Code duplicated, block: B:60:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:62:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:63:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:66:0x00b4  */
    /* JADX WARN: Code duplicated, block: B:69:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:71:0x00c3  */
    /* JADX WARN: Code duplicated, block: B:72:0x00c6  */
    /* JADX WARN: Code duplicated, block: B:74:0x00cb  */
    /* JADX WARN: Code duplicated, block: B:77:0x00da  */
    /* JADX WARN: Code duplicated, block: B:78:0x00dc  */
    /* JADX WARN: Code duplicated, block: B:81:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:83:0x00f5  */
    /* JADX WARN: Code duplicated, block: B:96:0x011e A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:97:0x0120  */
    /* JADX WARN: Code duplicated, block: B:98:0x0125  */
    /* JADX INFO: renamed from: PermanentDrawerSheet-afqeVBk, reason: not valid java name */
    public static final void m3869PermanentDrawerSheetafqeVBk(Modifier modifier, Shape shape, long j, long j2, float f, WindowInsets windowInsets, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        int i3;
        Shape shape2;
        long j3;
        long jM3051contentColorForek8zF_U;
        int i4;
        float f2;
        int i5;
        WindowInsets windowInsets2;
        Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function4;
        boolean z;
        Composer composer2;
        final Modifier modifier2;
        final Shape shape3;
        final long j4;
        final long j5;
        final float f3;
        final WindowInsets windowInsets3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        Shape rectangleShape;
        long standardContainerColor;
        float fM3298getPermanentDrawerElevationD9Ej5fM;
        float f4;
        long j6;
        WindowInsets windowInsets4;
        Shape shape4;
        int i6;
        final String strM5086getString2EP1pXo;
        boolean zChanged;
        Object objRememberedValue;
        int i7;
        int i8;
        Composer composerStartRestartGroup = composer.startRestartGroup(1877158612);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(PermanentDrawerSheet)N(modifier,drawerShape,drawerContainerColor:c#ui.graphics.Color,drawerContentColor:c#ui.graphics.Color,drawerTonalElevation:c#ui.unit.Dp,windowInsets,content)830@36188L33,834@36356L30,831@36226L384:NavigationDrawer.kt#uh7d8r");
        int i9 = i2 & 1;
        if (i9 != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i10 = i2 & 2;
        if (i10 == 0) {
            if ((i & 48) == 0) {
                shape2 = shape;
                i3 |= composerStartRestartGroup.changed(shape2) ? 32 : 16;
            }
            if ((i & 384) == 0) {
                if ((i2 & 4) == 0) {
                    j3 = j;
                    int i11 = composerStartRestartGroup.changed(j3) ? 256 : 128;
                    i3 |= i11;
                } else {
                    j3 = j;
                }
                i3 |= i11;
            } else {
                j3 = j;
            }
            if ((i & 3072) == 0) {
                jM3051contentColorForek8zF_U = j2;
                if ((i2 & 8) == 0 || !composerStartRestartGroup.changed(jM3051contentColorForek8zF_U)) {
                    i8 = 1024;
                } else {
                    i8 = 2048;
                }
                i3 |= i8;
            } else {
                jM3051contentColorForek8zF_U = j2;
            }
            i4 = i2 & 16;
            if (i4 != 0) {
                if ((i & 24576) == 0) {
                    f2 = f;
                    if (composerStartRestartGroup.changed(f2)) {
                        i5 = 16384;
                    } else {
                        i5 = 8192;
                    }
                    i3 |= i5;
                }
                if ((196608 & i) == 0) {
                    if ((i2 & 32) == 0) {
                        windowInsets2 = windowInsets;
                        int i12 = composerStartRestartGroup.changed(windowInsets2) ? 131072 : 65536;
                        i3 |= i12;
                    } else {
                        windowInsets2 = windowInsets;
                    }
                    i3 |= i12;
                } else {
                    windowInsets2 = windowInsets;
                }
                if ((1572864 & i) == 0) {
                    function4 = function3;
                    if (composerStartRestartGroup.changedInstance(function4)) {
                        i7 = 1048576;
                    } else {
                        i7 = 524288;
                    }
                    i3 |= i7;
                } else {
                    function4 = function3;
                }
                if ((i3 & 599187) != 599186) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "824@35881L22,825@35937L37,827@36096L12");
                    if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                        if (i9 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i10 != 0) {
                            rectangleShape = RectangleShapeKt.getRectangleShape();
                        } else {
                            rectangleShape = shape2;
                        }
                        if ((i2 & 4) != 0) {
                            standardContainerColor = DrawerDefaults.INSTANCE.getStandardContainerColor(composerStartRestartGroup, 6);
                            i3 &= -897;
                        } else {
                            standardContainerColor = j3;
                        }
                        if ((i2 & 8) != 0) {
                            jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(standardContainerColor, composerStartRestartGroup, (i3 >> 6) & 14);
                            i3 &= -7169;
                        }
                        if (i4 != 0) {
                            fM3298getPermanentDrawerElevationD9Ej5fM = DrawerDefaults.INSTANCE.m3298getPermanentDrawerElevationD9Ej5fM();
                        } else {
                            fM3298getPermanentDrawerElevationD9Ej5fM = f2;
                        }
                        if ((i2 & 32) != 0) {
                            i3 &= -458753;
                            shape4 = rectangleShape;
                            f4 = fM3298getPermanentDrawerElevationD9Ej5fM;
                            j6 = jM3051contentColorForek8zF_U;
                            i6 = 1877158612;
                            windowInsets4 = DrawerDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                        } else {
                            f4 = fM3298getPermanentDrawerElevationD9Ej5fM;
                            j6 = jM3051contentColorForek8zF_U;
                            windowInsets4 = windowInsets2;
                            shape4 = rectangleShape;
                            i6 = 1877158612;
                        }
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                        }
                        if ((i2 & 8) != 0) {
                            i3 &= -7169;
                        }
                        if ((i2 & 32) != 0) {
                            i3 &= -458753;
                        }
                        companion = modifier;
                        j6 = jM3051contentColorForek8zF_U;
                        f4 = f2;
                        windowInsets4 = windowInsets2;
                        i6 = 1877158612;
                        shape4 = shape2;
                        standardContainerColor = j3;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(i6, i3, -1, "androidx.compose.material3.PermanentDrawerSheet (NavigationDrawer.kt:829)");
                    }
                    Strings.Companion companion2 = Strings.INSTANCE;
                    strM5086getString2EP1pXo = Strings_androidKt.m5086getString2EP1pXo(Strings.m5002constructorimpl(androidx.compose.ui.R.string.navigation_menu), composerStartRestartGroup, 0);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 63181874, "CC(remember):NavigationDrawer.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(strM5086getString2EP1pXo);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new Function1() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda27
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return NavigationDrawerKt.PermanentDrawerSheet_afqeVBk$lambda$0$0(strM5086getString2EP1pXo, (SemanticsPropertyReceiver) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    int i13 = i3 << 6;
                    composer2 = composerStartRestartGroup;
                    Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function5 = function4;
                    long j7 = standardContainerColor;
                    m3865DrawerSheetcm3T3N0(null, windowInsets4, SemanticsModifierKt.semantics$default(companion, false, (Function1) objRememberedValue, 1, null), shape4, j7, j6, f4, null, function5, composer2, ((i3 >> 12) & 112) | 6 | (i13 & 7168) | (57344 & i13) | (458752 & i13) | (3670016 & i13) | (i13 & 234881024), 128);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier2 = companion;
                    windowInsets3 = windowInsets4;
                    shape3 = shape4;
                    j4 = j7;
                    j5 = j6;
                    f3 = f4;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    modifier2 = modifier;
                    shape3 = shape2;
                    j4 = j3;
                    j5 = jM3051contentColorForek8zF_U;
                    f3 = f2;
                    windowInsets3 = windowInsets2;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda28
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return NavigationDrawerKt.PermanentDrawerSheet_afqeVBk$lambda$1(modifier2, shape3, j4, j5, f3, windowInsets3, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 24576;
            f2 = f;
            if ((196608 & i) == 0) {
                if ((i2 & 32) == 0) {
                    windowInsets2 = windowInsets;
                    if (composerStartRestartGroup.changed(windowInsets2)) {
                    }
                    i3 |= i12;
                } else {
                    windowInsets2 = windowInsets;
                }
                i3 |= i12;
            } else {
                windowInsets2 = windowInsets;
            }
            if ((1572864 & i) == 0) {
                function4 = function3;
                if (composerStartRestartGroup.changedInstance(function4)) {
                    i7 = 1048576;
                } else {
                    i7 = 524288;
                }
                i3 |= i7;
            } else {
                function4 = function3;
            }
            if ((i3 & 599187) != 599186) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "824@35881L22,825@35937L37,827@36096L12");
                if ((i & 1) != 0) {
                    if (i9 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i10 != 0) {
                        rectangleShape = RectangleShapeKt.getRectangleShape();
                    } else {
                        rectangleShape = shape2;
                    }
                    if ((i2 & 4) != 0) {
                        standardContainerColor = DrawerDefaults.INSTANCE.getStandardContainerColor(composerStartRestartGroup, 6);
                        i3 &= -897;
                    } else {
                        standardContainerColor = j3;
                    }
                    if ((i2 & 8) != 0) {
                        jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(standardContainerColor, composerStartRestartGroup, (i3 >> 6) & 14);
                        i3 &= -7169;
                    }
                    if (i4 != 0) {
                        fM3298getPermanentDrawerElevationD9Ej5fM = DrawerDefaults.INSTANCE.m3298getPermanentDrawerElevationD9Ej5fM();
                    } else {
                        fM3298getPermanentDrawerElevationD9Ej5fM = f2;
                    }
                    if ((i2 & 32) != 0) {
                        i3 &= -458753;
                        shape4 = rectangleShape;
                        f4 = fM3298getPermanentDrawerElevationD9Ej5fM;
                        j6 = jM3051contentColorForek8zF_U;
                        i6 = 1877158612;
                        windowInsets4 = DrawerDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                    } else {
                        f4 = fM3298getPermanentDrawerElevationD9Ej5fM;
                        j6 = jM3051contentColorForek8zF_U;
                        windowInsets4 = windowInsets2;
                        shape4 = rectangleShape;
                        i6 = 1877158612;
                    }
                } else {
                    if (i9 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i10 != 0) {
                        rectangleShape = RectangleShapeKt.getRectangleShape();
                    } else {
                        rectangleShape = shape2;
                    }
                    if ((i2 & 4) != 0) {
                        standardContainerColor = DrawerDefaults.INSTANCE.getStandardContainerColor(composerStartRestartGroup, 6);
                        i3 &= -897;
                    } else {
                        standardContainerColor = j3;
                    }
                    if ((i2 & 8) != 0) {
                        jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(standardContainerColor, composerStartRestartGroup, (i3 >> 6) & 14);
                        i3 &= -7169;
                    }
                    if (i4 != 0) {
                        fM3298getPermanentDrawerElevationD9Ej5fM = DrawerDefaults.INSTANCE.m3298getPermanentDrawerElevationD9Ej5fM();
                    } else {
                        fM3298getPermanentDrawerElevationD9Ej5fM = f2;
                    }
                    if ((i2 & 32) != 0) {
                        i3 &= -458753;
                        shape4 = rectangleShape;
                        f4 = fM3298getPermanentDrawerElevationD9Ej5fM;
                        j6 = jM3051contentColorForek8zF_U;
                        i6 = 1877158612;
                        windowInsets4 = DrawerDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                    } else {
                        f4 = fM3298getPermanentDrawerElevationD9Ej5fM;
                        j6 = jM3051contentColorForek8zF_U;
                        windowInsets4 = windowInsets2;
                        shape4 = rectangleShape;
                        i6 = 1877158612;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(i6, i3, -1, "androidx.compose.material3.PermanentDrawerSheet (NavigationDrawer.kt:829)");
                }
                Strings.Companion companion3 = Strings.INSTANCE;
                strM5086getString2EP1pXo = Strings_androidKt.m5086getString2EP1pXo(Strings.m5002constructorimpl(androidx.compose.ui.R.string.navigation_menu), composerStartRestartGroup, 0);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 63181874, "CC(remember):NavigationDrawer.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(strM5086getString2EP1pXo);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue = new Function1() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda27
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return NavigationDrawerKt.PermanentDrawerSheet_afqeVBk$lambda$0$0(strM5086getString2EP1pXo, (SemanticsPropertyReceiver) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new Function1() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda27
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return NavigationDrawerKt.PermanentDrawerSheet_afqeVBk$lambda$0$0(strM5086getString2EP1pXo, (SemanticsPropertyReceiver) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                int i14 = i3 << 6;
                composer2 = composerStartRestartGroup;
                Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function6 = function4;
                long j8 = standardContainerColor;
                m3865DrawerSheetcm3T3N0(null, windowInsets4, SemanticsModifierKt.semantics$default(companion, false, (Function1) objRememberedValue, 1, null), shape4, j8, j6, f4, null, function6, composer2, ((i3 >> 12) & 112) | 6 | (i14 & 7168) | (57344 & i14) | (458752 & i14) | (3670016 & i14) | (i14 & 234881024), 128);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier2 = companion;
                windowInsets3 = windowInsets4;
                shape3 = shape4;
                j4 = j8;
                j5 = j6;
                f3 = f4;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier2 = modifier;
                shape3 = shape2;
                j4 = j3;
                j5 = jM3051contentColorForek8zF_U;
                f3 = f2;
                windowInsets3 = windowInsets2;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda28
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return NavigationDrawerKt.PermanentDrawerSheet_afqeVBk$lambda$1(modifier2, shape3, j4, j5, f3, windowInsets3, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 48;
        shape2 = shape;
        if ((i & 384) == 0) {
            if ((i2 & 4) == 0) {
                j3 = j;
                if (composerStartRestartGroup.changed(j3)) {
                }
                i3 |= i11;
            } else {
                j3 = j;
            }
            i3 |= i11;
        } else {
            j3 = j;
        }
        if ((i & 3072) == 0) {
            jM3051contentColorForek8zF_U = j2;
            if ((i2 & 8) == 0) {
                i8 = 1024;
            } else {
                i8 = 1024;
            }
            i3 |= i8;
        } else {
            jM3051contentColorForek8zF_U = j2;
        }
        i4 = i2 & 16;
        if (i4 != 0) {
            if ((i & 24576) == 0) {
                f2 = f;
                if (composerStartRestartGroup.changed(f2)) {
                    i5 = 16384;
                } else {
                    i5 = 8192;
                }
                i3 |= i5;
            }
            if ((196608 & i) == 0) {
                if ((i2 & 32) == 0) {
                    windowInsets2 = windowInsets;
                    if (composerStartRestartGroup.changed(windowInsets2)) {
                    }
                    i3 |= i12;
                } else {
                    windowInsets2 = windowInsets;
                }
                i3 |= i12;
            } else {
                windowInsets2 = windowInsets;
            }
            if ((1572864 & i) == 0) {
                function4 = function3;
                if (composerStartRestartGroup.changedInstance(function4)) {
                    i7 = 1048576;
                } else {
                    i7 = 524288;
                }
                i3 |= i7;
            } else {
                function4 = function3;
            }
            if ((i3 & 599187) != 599186) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "824@35881L22,825@35937L37,827@36096L12");
                if ((i & 1) != 0) {
                    if (i9 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i10 != 0) {
                        rectangleShape = RectangleShapeKt.getRectangleShape();
                    } else {
                        rectangleShape = shape2;
                    }
                    if ((i2 & 4) != 0) {
                        standardContainerColor = DrawerDefaults.INSTANCE.getStandardContainerColor(composerStartRestartGroup, 6);
                        i3 &= -897;
                    } else {
                        standardContainerColor = j3;
                    }
                    if ((i2 & 8) != 0) {
                        jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(standardContainerColor, composerStartRestartGroup, (i3 >> 6) & 14);
                        i3 &= -7169;
                    }
                    if (i4 != 0) {
                        fM3298getPermanentDrawerElevationD9Ej5fM = DrawerDefaults.INSTANCE.m3298getPermanentDrawerElevationD9Ej5fM();
                    } else {
                        fM3298getPermanentDrawerElevationD9Ej5fM = f2;
                    }
                    if ((i2 & 32) != 0) {
                        i3 &= -458753;
                        shape4 = rectangleShape;
                        f4 = fM3298getPermanentDrawerElevationD9Ej5fM;
                        j6 = jM3051contentColorForek8zF_U;
                        i6 = 1877158612;
                        windowInsets4 = DrawerDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                    } else {
                        f4 = fM3298getPermanentDrawerElevationD9Ej5fM;
                        j6 = jM3051contentColorForek8zF_U;
                        windowInsets4 = windowInsets2;
                        shape4 = rectangleShape;
                        i6 = 1877158612;
                    }
                } else {
                    if (i9 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i10 != 0) {
                        rectangleShape = RectangleShapeKt.getRectangleShape();
                    } else {
                        rectangleShape = shape2;
                    }
                    if ((i2 & 4) != 0) {
                        standardContainerColor = DrawerDefaults.INSTANCE.getStandardContainerColor(composerStartRestartGroup, 6);
                        i3 &= -897;
                    } else {
                        standardContainerColor = j3;
                    }
                    if ((i2 & 8) != 0) {
                        jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(standardContainerColor, composerStartRestartGroup, (i3 >> 6) & 14);
                        i3 &= -7169;
                    }
                    if (i4 != 0) {
                        fM3298getPermanentDrawerElevationD9Ej5fM = DrawerDefaults.INSTANCE.m3298getPermanentDrawerElevationD9Ej5fM();
                    } else {
                        fM3298getPermanentDrawerElevationD9Ej5fM = f2;
                    }
                    if ((i2 & 32) != 0) {
                        i3 &= -458753;
                        shape4 = rectangleShape;
                        f4 = fM3298getPermanentDrawerElevationD9Ej5fM;
                        j6 = jM3051contentColorForek8zF_U;
                        i6 = 1877158612;
                        windowInsets4 = DrawerDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                    } else {
                        f4 = fM3298getPermanentDrawerElevationD9Ej5fM;
                        j6 = jM3051contentColorForek8zF_U;
                        windowInsets4 = windowInsets2;
                        shape4 = rectangleShape;
                        i6 = 1877158612;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(i6, i3, -1, "androidx.compose.material3.PermanentDrawerSheet (NavigationDrawer.kt:829)");
                }
                Strings.Companion companion4 = Strings.INSTANCE;
                strM5086getString2EP1pXo = Strings_androidKt.m5086getString2EP1pXo(Strings.m5002constructorimpl(androidx.compose.ui.R.string.navigation_menu), composerStartRestartGroup, 0);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 63181874, "CC(remember):NavigationDrawer.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(strM5086getString2EP1pXo);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue = new Function1() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda27
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return NavigationDrawerKt.PermanentDrawerSheet_afqeVBk$lambda$0$0(strM5086getString2EP1pXo, (SemanticsPropertyReceiver) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new Function1() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda27
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return NavigationDrawerKt.PermanentDrawerSheet_afqeVBk$lambda$0$0(strM5086getString2EP1pXo, (SemanticsPropertyReceiver) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                int i15 = i3 << 6;
                composer2 = composerStartRestartGroup;
                Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function7 = function4;
                long j9 = standardContainerColor;
                m3865DrawerSheetcm3T3N0(null, windowInsets4, SemanticsModifierKt.semantics$default(companion, false, (Function1) objRememberedValue, 1, null), shape4, j9, j6, f4, null, function7, composer2, ((i3 >> 12) & 112) | 6 | (i15 & 7168) | (57344 & i15) | (458752 & i15) | (3670016 & i15) | (i15 & 234881024), 128);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier2 = companion;
                windowInsets3 = windowInsets4;
                shape3 = shape4;
                j4 = j9;
                j5 = j6;
                f3 = f4;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier2 = modifier;
                shape3 = shape2;
                j4 = j3;
                j5 = jM3051contentColorForek8zF_U;
                f3 = f2;
                windowInsets3 = windowInsets2;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda28
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return NavigationDrawerKt.PermanentDrawerSheet_afqeVBk$lambda$1(modifier2, shape3, j4, j5, f3, windowInsets3, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 24576;
        f2 = f;
        if ((196608 & i) == 0) {
            if ((i2 & 32) == 0) {
                windowInsets2 = windowInsets;
                if (composerStartRestartGroup.changed(windowInsets2)) {
                }
                i3 |= i12;
            } else {
                windowInsets2 = windowInsets;
            }
            i3 |= i12;
        } else {
            windowInsets2 = windowInsets;
        }
        if ((1572864 & i) == 0) {
            function4 = function3;
            if (composerStartRestartGroup.changedInstance(function4)) {
                i7 = 1048576;
            } else {
                i7 = 524288;
            }
            i3 |= i7;
        } else {
            function4 = function3;
        }
        if ((i3 & 599187) != 599186) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "824@35881L22,825@35937L37,827@36096L12");
            if ((i & 1) != 0) {
                if (i9 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier;
                }
                if (i10 != 0) {
                    rectangleShape = RectangleShapeKt.getRectangleShape();
                } else {
                    rectangleShape = shape2;
                }
                if ((i2 & 4) != 0) {
                    standardContainerColor = DrawerDefaults.INSTANCE.getStandardContainerColor(composerStartRestartGroup, 6);
                    i3 &= -897;
                } else {
                    standardContainerColor = j3;
                }
                if ((i2 & 8) != 0) {
                    jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(standardContainerColor, composerStartRestartGroup, (i3 >> 6) & 14);
                    i3 &= -7169;
                }
                if (i4 != 0) {
                    fM3298getPermanentDrawerElevationD9Ej5fM = DrawerDefaults.INSTANCE.m3298getPermanentDrawerElevationD9Ej5fM();
                } else {
                    fM3298getPermanentDrawerElevationD9Ej5fM = f2;
                }
                if ((i2 & 32) != 0) {
                    i3 &= -458753;
                    shape4 = rectangleShape;
                    f4 = fM3298getPermanentDrawerElevationD9Ej5fM;
                    j6 = jM3051contentColorForek8zF_U;
                    i6 = 1877158612;
                    windowInsets4 = DrawerDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                } else {
                    f4 = fM3298getPermanentDrawerElevationD9Ej5fM;
                    j6 = jM3051contentColorForek8zF_U;
                    windowInsets4 = windowInsets2;
                    shape4 = rectangleShape;
                    i6 = 1877158612;
                }
            } else {
                if (i9 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier;
                }
                if (i10 != 0) {
                    rectangleShape = RectangleShapeKt.getRectangleShape();
                } else {
                    rectangleShape = shape2;
                }
                if ((i2 & 4) != 0) {
                    standardContainerColor = DrawerDefaults.INSTANCE.getStandardContainerColor(composerStartRestartGroup, 6);
                    i3 &= -897;
                } else {
                    standardContainerColor = j3;
                }
                if ((i2 & 8) != 0) {
                    jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(standardContainerColor, composerStartRestartGroup, (i3 >> 6) & 14);
                    i3 &= -7169;
                }
                if (i4 != 0) {
                    fM3298getPermanentDrawerElevationD9Ej5fM = DrawerDefaults.INSTANCE.m3298getPermanentDrawerElevationD9Ej5fM();
                } else {
                    fM3298getPermanentDrawerElevationD9Ej5fM = f2;
                }
                if ((i2 & 32) != 0) {
                    i3 &= -458753;
                    shape4 = rectangleShape;
                    f4 = fM3298getPermanentDrawerElevationD9Ej5fM;
                    j6 = jM3051contentColorForek8zF_U;
                    i6 = 1877158612;
                    windowInsets4 = DrawerDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                } else {
                    f4 = fM3298getPermanentDrawerElevationD9Ej5fM;
                    j6 = jM3051contentColorForek8zF_U;
                    windowInsets4 = windowInsets2;
                    shape4 = rectangleShape;
                    i6 = 1877158612;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(i6, i3, -1, "androidx.compose.material3.PermanentDrawerSheet (NavigationDrawer.kt:829)");
            }
            Strings.Companion companion5 = Strings.INSTANCE;
            strM5086getString2EP1pXo = Strings_androidKt.m5086getString2EP1pXo(Strings.m5002constructorimpl(androidx.compose.ui.R.string.navigation_menu), composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 63181874, "CC(remember):NavigationDrawer.kt#9igjgp");
            zChanged = composerStartRestartGroup.changed(strM5086getString2EP1pXo);
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (!zChanged) {
                objRememberedValue = new Function1() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda27
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return NavigationDrawerKt.PermanentDrawerSheet_afqeVBk$lambda$0$0(strM5086getString2EP1pXo, (SemanticsPropertyReceiver) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            } else {
                objRememberedValue = new Function1() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda27
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return NavigationDrawerKt.PermanentDrawerSheet_afqeVBk$lambda$0$0(strM5086getString2EP1pXo, (SemanticsPropertyReceiver) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            int i16 = i3 << 6;
            composer2 = composerStartRestartGroup;
            Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function8 = function4;
            long j10 = standardContainerColor;
            m3865DrawerSheetcm3T3N0(null, windowInsets4, SemanticsModifierKt.semantics$default(companion, false, (Function1) objRememberedValue, 1, null), shape4, j10, j6, f4, null, function8, composer2, ((i3 >> 12) & 112) | 6 | (i16 & 7168) | (57344 & i16) | (458752 & i16) | (3670016 & i16) | (i16 & 234881024), 128);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = companion;
            windowInsets3 = windowInsets4;
            shape3 = shape4;
            j4 = j10;
            j5 = j6;
            f3 = f4;
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            modifier2 = modifier;
            shape3 = shape2;
            j4 = j3;
            j5 = jM3051contentColorForek8zF_U;
            f3 = f2;
            windowInsets3 = windowInsets2;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda28
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return NavigationDrawerKt.PermanentDrawerSheet_afqeVBk$lambda$1(modifier2, shape3, j4, j5, f3, windowInsets3, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PermanentDrawerSheet_afqeVBk$lambda$0$0(String str, SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.setPaneTitle(semanticsPropertyReceiver, str);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0131  */
    /* JADX WARN: Code duplicated, block: B:115:0x0164 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:116:0x0166  */
    /* JADX WARN: Code duplicated, block: B:118:0x016d  */
    /* JADX WARN: Code duplicated, block: B:121:0x0176  */
    /* JADX WARN: Code duplicated, block: B:122:0x017f  */
    /* JADX WARN: Code duplicated, block: B:125:0x0185  */
    /* JADX WARN: Code duplicated, block: B:127:0x0191  */
    /* JADX WARN: Code duplicated, block: B:128:0x0198  */
    /* JADX WARN: Code duplicated, block: B:131:0x019e  */
    /* JADX WARN: Code duplicated, block: B:133:0x01b4  */
    /* JADX WARN: Code duplicated, block: B:135:0x01c4  */
    /* JADX WARN: Code duplicated, block: B:139:0x01da  */
    /* JADX WARN: Code duplicated, block: B:142:0x0217  */
    /* JADX WARN: Code duplicated, block: B:143:0x0219  */
    /* JADX WARN: Code duplicated, block: B:145:0x021c  */
    /* JADX WARN: Code duplicated, block: B:146:0x0225  */
    /* JADX WARN: Code duplicated, block: B:149:0x0299  */
    /* JADX WARN: Code duplicated, block: B:151:0x02a7  */
    /* JADX WARN: Code duplicated, block: B:154:0x02ba  */
    /* JADX WARN: Code duplicated, block: B:156:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:31:0x005b  */
    /* JADX WARN: Code duplicated, block: B:32:0x005e  */
    /* JADX WARN: Code duplicated, block: B:34:0x0062  */
    /* JADX WARN: Code duplicated, block: B:36:0x006a  */
    /* JADX WARN: Code duplicated, block: B:37:0x006d  */
    /* JADX WARN: Code duplicated, block: B:42:0x0077  */
    /* JADX WARN: Code duplicated, block: B:44:0x007b  */
    /* JADX WARN: Code duplicated, block: B:46:0x0083  */
    /* JADX WARN: Code duplicated, block: B:47:0x0086  */
    /* JADX WARN: Code duplicated, block: B:50:0x008c  */
    /* JADX WARN: Code duplicated, block: B:53:0x0093  */
    /* JADX WARN: Code duplicated, block: B:55:0x0097  */
    /* JADX WARN: Code duplicated, block: B:57:0x009f  */
    /* JADX WARN: Code duplicated, block: B:58:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:61:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:64:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:65:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:67:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:69:0x00c2  */
    /* JADX WARN: Code duplicated, block: B:70:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:74:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:76:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:78:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:79:0x00dd  */
    /* JADX WARN: Code duplicated, block: B:81:0x00e3  */
    /* JADX WARN: Code duplicated, block: B:82:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:86:0x00ee  */
    /* JADX WARN: Code duplicated, block: B:88:0x00f6  */
    /* JADX WARN: Code duplicated, block: B:89:0x00f9  */
    /* JADX WARN: Code duplicated, block: B:91:0x00fe  */
    /* JADX WARN: Code duplicated, block: B:94:0x010f  */
    /* JADX WARN: Code duplicated, block: B:95:0x0111  */
    /* JADX WARN: Code duplicated, block: B:98:0x011b  */
    /* JADX INFO: renamed from: DrawerSheet-cm3T3N0, reason: not valid java name */
    public static final void m3865DrawerSheetcm3T3N0(final DrawerPredictiveBackState drawerPredictiveBackState, final WindowInsets windowInsets, Modifier modifier, Shape shape, long j, long j2, float f, FloatProducer floatProducer, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        int i3;
        WindowInsets windowInsets2;
        Modifier modifier2;
        int i4;
        Shape rectangleShape;
        int i5;
        long standardContainerColor;
        long jM3051contentColorForek8zF_U;
        int i6;
        int i7;
        int i8;
        boolean z;
        Composer composer2;
        final Modifier modifier3;
        final Shape shape2;
        final long j3;
        final long j4;
        final float f2;
        final FloatProducer floatProducer2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i9;
        float fM3298getPermanentDrawerElevationD9Ej5fM;
        FloatProducer floatProducer3;
        float f3;
        long j5;
        Object objRememberedValue;
        Object objConsume;
        boolean z2;
        Modifier.Companion companionPredictiveBackDrawerContainer;
        int i10;
        int i11;
        boolean zChangedInstance;
        Composer composerStartRestartGroup = composer.startRestartGroup(1560288494);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(DrawerSheet)N(drawerPredictiveBackState,windowInsets,modifier,drawerShape,drawerContainerColor:c#ui.graphics.Color,drawerContentColor:c#ui.graphics.Color,drawerTonalElevation:c#ui.unit.Dp,drawerOffset,content)855@37175L7,858@37332L7,884@38535L867,865@37597L1805:NavigationDrawer.kt#uh7d8r");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(drawerPredictiveBackState) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            windowInsets2 = windowInsets;
            i3 |= composerStartRestartGroup.changed(windowInsets2) ? 32 : 16;
        } else {
            windowInsets2 = windowInsets;
        }
        int i12 = i2 & 4;
        if (i12 == 0) {
            if ((i & 384) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            i4 = i2 & 8;
            if (i4 != 0) {
                if ((i & 3072) == 0) {
                    rectangleShape = shape;
                    if (composerStartRestartGroup.changed(rectangleShape)) {
                        i5 = 2048;
                    } else {
                        i5 = 1024;
                    }
                    i3 |= i5;
                }
                if ((i & 24576) == 0) {
                    if ((i2 & 16) == 0) {
                        standardContainerColor = j;
                        int i13 = composerStartRestartGroup.changed(standardContainerColor) ? 16384 : 8192;
                        i3 |= i13;
                    } else {
                        standardContainerColor = j;
                    }
                    i3 |= i13;
                } else {
                    standardContainerColor = j;
                }
                if ((196608 & i) == 0) {
                    if ((i2 & 32) == 0) {
                        jM3051contentColorForek8zF_U = j2;
                        int i14 = composerStartRestartGroup.changed(jM3051contentColorForek8zF_U) ? 131072 : 65536;
                        i3 |= i14;
                    } else {
                        jM3051contentColorForek8zF_U = j2;
                    }
                    i3 |= i14;
                } else {
                    jM3051contentColorForek8zF_U = j2;
                }
                i6 = i2 & 64;
                if (i6 != 0) {
                    i3 |= 1572864;
                } else if ((i & 1572864) == 0) {
                    if (composerStartRestartGroup.changed(f)) {
                        i7 = 1048576;
                    } else {
                        i7 = 524288;
                    }
                    i3 |= i7;
                }
                if ((i & 12582912) == 0) {
                    if ((i2 & 128) != 0) {
                        i11 = 4194304;
                    } else {
                        if ((16777216 & i) == 0) {
                            zChangedInstance = composerStartRestartGroup.changed(floatProducer);
                        } else {
                            zChangedInstance = composerStartRestartGroup.changedInstance(floatProducer);
                        }
                        if (zChangedInstance) {
                            i11 = 8388608;
                        } else {
                            i11 = 4194304;
                        }
                    }
                    i3 |= i11;
                }
                if ((100663296 & i) != 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i10 = 67108864;
                    } else {
                        i10 = 33554432;
                    }
                    i3 |= i10;
                }
                i8 = i3;
                if ((i3 & 38347923) != 38347922) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i8 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "849@36868L22,850@36924L37,852@37069L20");
                    if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                        if (i12 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            rectangleShape = RectangleShapeKt.getRectangleShape();
                        }
                        if ((i2 & 16) != 0) {
                            standardContainerColor = DrawerDefaults.INSTANCE.getStandardContainerColor(composerStartRestartGroup, 6);
                            i9 = i8 & (-57345);
                        } else {
                            i9 = i8;
                        }
                        if ((i2 & 32) != 0) {
                            jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(standardContainerColor, composerStartRestartGroup, (i9 >> 12) & 14);
                            i9 &= -458753;
                        }
                        if (i6 != 0) {
                            fM3298getPermanentDrawerElevationD9Ej5fM = DrawerDefaults.INSTANCE.m3298getPermanentDrawerElevationD9Ej5fM();
                        } else {
                            fM3298getPermanentDrawerElevationD9Ej5fM = f;
                        }
                        if ((i2 & 128) != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 493670338, "CC(remember):NavigationDrawer.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = new FloatProducer() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda8
                                    @Override // androidx.compose.material3.internal.FloatProducer
                                    public final float invoke() {
                                        return NavigationDrawerKt.DrawerSheet_cm3T3N0$lambda$0$0();
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            floatProducer3 = (FloatProducer) objRememberedValue;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            i9 &= -29360129;
                        } else {
                            floatProducer3 = floatProducer;
                        }
                        f3 = fM3298getPermanentDrawerElevationD9Ej5fM;
                        j5 = standardContainerColor;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        i9 = (i2 & 16) != 0 ? i8 & (-57345) : i8;
                        if ((i2 & 32) != 0) {
                            i9 &= -458753;
                        }
                        if ((i2 & 128) != 0) {
                            i9 &= -29360129;
                        }
                        f3 = f;
                        j5 = standardContainerColor;
                        floatProducer3 = floatProducer;
                    }
                    long j6 = jM3051contentColorForek8zF_U;
                    Shape shape3 = rectangleShape;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1560288494, i9, -1, "androidx.compose.material3.DrawerSheet (NavigationDrawer.kt:854)");
                    }
                    ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume2 = composerStartRestartGroup.consume(localDensity);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    final float fM5562getContainerWidthD9Ej5fM = NavigationDrawerTokens.INSTANCE.m5562getContainerWidthD9Ej5fM();
                    final float fMo754toPx0680j_4 = ((Density) objConsume2).mo754toPx0680j_4(fM5562getContainerWidthD9Ej5fM);
                    ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    objConsume = composerStartRestartGroup.consume(localLayoutDirection);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (objConsume == LayoutDirection.Rtl) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (drawerPredictiveBackState != null) {
                        companionPredictiveBackDrawerContainer = predictiveBackDrawerContainer(Modifier.INSTANCE, drawerPredictiveBackState, z2);
                    } else {
                        companionPredictiveBackDrawerContainer = Modifier.INSTANCE;
                    }
                    Modifier modifier4 = modifier2;
                    final FloatProducer floatProducer4 = floatProducer3;
                    final WindowInsets windowInsets3 = windowInsets2;
                    final boolean z3 = z2;
                    int i15 = i9 >> 6;
                    composer2 = composerStartRestartGroup;
                    SurfaceKt.m4323SurfaceT9BRK9s(SizeKt.fillMaxHeight$default(horizontalScaleUp(SizeKt.m1270sizeInqDBjuR0$default(modifier4, MinimumDrawerWidth, 0.0f, fM5562getContainerWidthD9Ej5fM, 0.0f, 10, null), floatProducer3, fMo754toPx0680j_4, z2).then(companionPredictiveBackDrawerContainer), 0.0f, 1, null), shape3, j5, j6, f3, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(-315420087, true, new Function2() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda9
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return NavigationDrawerKt.DrawerSheet_cm3T3N0$lambda$2(drawerPredictiveBackState, z3, fM5562getContainerWidthD9Ej5fM, floatProducer4, fMo754toPx0680j_4, windowInsets3, function3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composer2, (i15 & 112) | 12582912 | (i15 & 896) | (i15 & 7168) | (i15 & 57344), 96);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    floatProducer2 = floatProducer3;
                    shape2 = shape3;
                    j3 = j5;
                    j4 = j6;
                    f2 = f3;
                    modifier3 = modifier4;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    modifier3 = modifier2;
                    shape2 = rectangleShape;
                    j3 = standardContainerColor;
                    j4 = jM3051contentColorForek8zF_U;
                    f2 = f;
                    floatProducer2 = floatProducer;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda10
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return NavigationDrawerKt.DrawerSheet_cm3T3N0$lambda$3(drawerPredictiveBackState, windowInsets, modifier3, shape2, j3, j4, f2, floatProducer2, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 3072;
            rectangleShape = shape;
            if ((i & 24576) == 0) {
                if ((i2 & 16) == 0) {
                    standardContainerColor = j;
                    if (composerStartRestartGroup.changed(standardContainerColor)) {
                    }
                    i3 |= i13;
                } else {
                    standardContainerColor = j;
                }
                i3 |= i13;
            } else {
                standardContainerColor = j;
            }
            if ((196608 & i) == 0) {
                if ((i2 & 32) == 0) {
                    jM3051contentColorForek8zF_U = j2;
                    if (composerStartRestartGroup.changed(jM3051contentColorForek8zF_U)) {
                    }
                    i3 |= i14;
                } else {
                    jM3051contentColorForek8zF_U = j2;
                }
                i3 |= i14;
            } else {
                jM3051contentColorForek8zF_U = j2;
            }
            i6 = i2 & 64;
            if (i6 != 0) {
                i3 |= 1572864;
            } else if ((i & 1572864) == 0) {
                if (composerStartRestartGroup.changed(f)) {
                    i7 = 1048576;
                } else {
                    i7 = 524288;
                }
                i3 |= i7;
            }
            if ((i & 12582912) == 0) {
                if ((i2 & 128) != 0) {
                    i11 = 4194304;
                } else {
                    if ((16777216 & i) == 0) {
                        zChangedInstance = composerStartRestartGroup.changed(floatProducer);
                    } else {
                        zChangedInstance = composerStartRestartGroup.changedInstance(floatProducer);
                    }
                    if (zChangedInstance) {
                        i11 = 8388608;
                    } else {
                        i11 = 4194304;
                    }
                }
                i3 |= i11;
            }
            if ((100663296 & i) != 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i10 = 67108864;
                } else {
                    i10 = 33554432;
                }
                i3 |= i10;
            }
            i8 = i3;
            if ((i3 & 38347923) != 38347922) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i8 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "849@36868L22,850@36924L37,852@37069L20");
                if ((i & 1) != 0) {
                    if (i12 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        rectangleShape = RectangleShapeKt.getRectangleShape();
                    }
                    if ((i2 & 16) != 0) {
                        standardContainerColor = DrawerDefaults.INSTANCE.getStandardContainerColor(composerStartRestartGroup, 6);
                        i9 = i8 & (-57345);
                    } else {
                        i9 = i8;
                    }
                    if ((i2 & 32) != 0) {
                        jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(standardContainerColor, composerStartRestartGroup, (i9 >> 12) & 14);
                        i9 &= -458753;
                    }
                    if (i6 != 0) {
                        fM3298getPermanentDrawerElevationD9Ej5fM = DrawerDefaults.INSTANCE.m3298getPermanentDrawerElevationD9Ej5fM();
                    } else {
                        fM3298getPermanentDrawerElevationD9Ej5fM = f;
                    }
                    if ((i2 & 128) != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 493670338, "CC(remember):NavigationDrawer.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new FloatProducer() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda8
                                @Override // androidx.compose.material3.internal.FloatProducer
                                public final float invoke() {
                                    return NavigationDrawerKt.DrawerSheet_cm3T3N0$lambda$0$0();
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        floatProducer3 = (FloatProducer) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        i9 &= -29360129;
                    } else {
                        floatProducer3 = floatProducer;
                    }
                    f3 = fM3298getPermanentDrawerElevationD9Ej5fM;
                    j5 = standardContainerColor;
                } else {
                    if (i12 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        rectangleShape = RectangleShapeKt.getRectangleShape();
                    }
                    if ((i2 & 16) != 0) {
                        standardContainerColor = DrawerDefaults.INSTANCE.getStandardContainerColor(composerStartRestartGroup, 6);
                        i9 = i8 & (-57345);
                    } else {
                        i9 = i8;
                    }
                    if ((i2 & 32) != 0) {
                        jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(standardContainerColor, composerStartRestartGroup, (i9 >> 12) & 14);
                        i9 &= -458753;
                    }
                    if (i6 != 0) {
                        fM3298getPermanentDrawerElevationD9Ej5fM = DrawerDefaults.INSTANCE.m3298getPermanentDrawerElevationD9Ej5fM();
                    } else {
                        fM3298getPermanentDrawerElevationD9Ej5fM = f;
                    }
                    if ((i2 & 128) != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 493670338, "CC(remember):NavigationDrawer.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new FloatProducer() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda8
                                @Override // androidx.compose.material3.internal.FloatProducer
                                public final float invoke() {
                                    return NavigationDrawerKt.DrawerSheet_cm3T3N0$lambda$0$0();
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        floatProducer3 = (FloatProducer) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        i9 &= -29360129;
                    } else {
                        floatProducer3 = floatProducer;
                    }
                    f3 = fM3298getPermanentDrawerElevationD9Ej5fM;
                    j5 = standardContainerColor;
                }
                long j7 = jM3051contentColorForek8zF_U;
                Shape shape4 = rectangleShape;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1560288494, i9, -1, "androidx.compose.material3.DrawerSheet (NavigationDrawer.kt:854)");
                }
                ProvidableCompositionLocal<Density> localDensity2 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume3 = composerStartRestartGroup.consume(localDensity2);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                final float fM5562getContainerWidthD9Ej5fM2 = NavigationDrawerTokens.INSTANCE.m5562getContainerWidthD9Ej5fM();
                final float fMo754toPx0680j_5 = ((Density) objConsume3).mo754toPx0680j_4(fM5562getContainerWidthD9Ej5fM2);
                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection2 = CompositionLocalsKt.getLocalLayoutDirection();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                objConsume = composerStartRestartGroup.consume(localLayoutDirection2);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (objConsume == LayoutDirection.Rtl) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (drawerPredictiveBackState != null) {
                    companionPredictiveBackDrawerContainer = predictiveBackDrawerContainer(Modifier.INSTANCE, drawerPredictiveBackState, z2);
                } else {
                    companionPredictiveBackDrawerContainer = Modifier.INSTANCE;
                }
                Modifier modifier5 = modifier2;
                final FloatProducer floatProducer5 = floatProducer3;
                final WindowInsets windowInsets4 = windowInsets2;
                final boolean z4 = z2;
                int i16 = i9 >> 6;
                composer2 = composerStartRestartGroup;
                SurfaceKt.m4323SurfaceT9BRK9s(SizeKt.fillMaxHeight$default(horizontalScaleUp(SizeKt.m1270sizeInqDBjuR0$default(modifier5, MinimumDrawerWidth, 0.0f, fM5562getContainerWidthD9Ej5fM2, 0.0f, 10, null), floatProducer3, fMo754toPx0680j_5, z2).then(companionPredictiveBackDrawerContainer), 0.0f, 1, null), shape4, j5, j7, f3, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(-315420087, true, new Function2() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return NavigationDrawerKt.DrawerSheet_cm3T3N0$lambda$2(drawerPredictiveBackState, z4, fM5562getContainerWidthD9Ej5fM2, floatProducer5, fMo754toPx0680j_5, windowInsets4, function3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composer2, (i16 & 112) | 12582912 | (i16 & 896) | (i16 & 7168) | (i16 & 57344), 96);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                floatProducer2 = floatProducer3;
                shape2 = shape4;
                j3 = j5;
                j4 = j7;
                f2 = f3;
                modifier3 = modifier5;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier3 = modifier2;
                shape2 = rectangleShape;
                j3 = standardContainerColor;
                j4 = jM3051contentColorForek8zF_U;
                f2 = f;
                floatProducer2 = floatProducer;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda10
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return NavigationDrawerKt.DrawerSheet_cm3T3N0$lambda$3(drawerPredictiveBackState, windowInsets, modifier3, shape2, j3, j4, f2, floatProducer2, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 384;
        modifier2 = modifier;
        i4 = i2 & 8;
        if (i4 != 0) {
            if ((i & 3072) == 0) {
                rectangleShape = shape;
                if (composerStartRestartGroup.changed(rectangleShape)) {
                    i5 = 2048;
                } else {
                    i5 = 1024;
                }
                i3 |= i5;
            }
            if ((i & 24576) == 0) {
                if ((i2 & 16) == 0) {
                    standardContainerColor = j;
                    if (composerStartRestartGroup.changed(standardContainerColor)) {
                    }
                    i3 |= i13;
                } else {
                    standardContainerColor = j;
                }
                i3 |= i13;
            } else {
                standardContainerColor = j;
            }
            if ((196608 & i) == 0) {
                if ((i2 & 32) == 0) {
                    jM3051contentColorForek8zF_U = j2;
                    if (composerStartRestartGroup.changed(jM3051contentColorForek8zF_U)) {
                    }
                    i3 |= i14;
                } else {
                    jM3051contentColorForek8zF_U = j2;
                }
                i3 |= i14;
            } else {
                jM3051contentColorForek8zF_U = j2;
            }
            i6 = i2 & 64;
            if (i6 != 0) {
                i3 |= 1572864;
            } else if ((i & 1572864) == 0) {
                if (composerStartRestartGroup.changed(f)) {
                    i7 = 1048576;
                } else {
                    i7 = 524288;
                }
                i3 |= i7;
            }
            if ((i & 12582912) == 0) {
                if ((i2 & 128) != 0) {
                    i11 = 4194304;
                } else {
                    if ((16777216 & i) == 0) {
                        zChangedInstance = composerStartRestartGroup.changed(floatProducer);
                    } else {
                        zChangedInstance = composerStartRestartGroup.changedInstance(floatProducer);
                    }
                    if (zChangedInstance) {
                        i11 = 8388608;
                    } else {
                        i11 = 4194304;
                    }
                }
                i3 |= i11;
            }
            if ((100663296 & i) != 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i10 = 67108864;
                } else {
                    i10 = 33554432;
                }
                i3 |= i10;
            }
            i8 = i3;
            if ((i3 & 38347923) != 38347922) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i8 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "849@36868L22,850@36924L37,852@37069L20");
                if ((i & 1) != 0) {
                    if (i12 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        rectangleShape = RectangleShapeKt.getRectangleShape();
                    }
                    if ((i2 & 16) != 0) {
                        standardContainerColor = DrawerDefaults.INSTANCE.getStandardContainerColor(composerStartRestartGroup, 6);
                        i9 = i8 & (-57345);
                    } else {
                        i9 = i8;
                    }
                    if ((i2 & 32) != 0) {
                        jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(standardContainerColor, composerStartRestartGroup, (i9 >> 12) & 14);
                        i9 &= -458753;
                    }
                    if (i6 != 0) {
                        fM3298getPermanentDrawerElevationD9Ej5fM = DrawerDefaults.INSTANCE.m3298getPermanentDrawerElevationD9Ej5fM();
                    } else {
                        fM3298getPermanentDrawerElevationD9Ej5fM = f;
                    }
                    if ((i2 & 128) != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 493670338, "CC(remember):NavigationDrawer.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new FloatProducer() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda8
                                @Override // androidx.compose.material3.internal.FloatProducer
                                public final float invoke() {
                                    return NavigationDrawerKt.DrawerSheet_cm3T3N0$lambda$0$0();
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        floatProducer3 = (FloatProducer) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        i9 &= -29360129;
                    } else {
                        floatProducer3 = floatProducer;
                    }
                    f3 = fM3298getPermanentDrawerElevationD9Ej5fM;
                    j5 = standardContainerColor;
                } else {
                    if (i12 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        rectangleShape = RectangleShapeKt.getRectangleShape();
                    }
                    if ((i2 & 16) != 0) {
                        standardContainerColor = DrawerDefaults.INSTANCE.getStandardContainerColor(composerStartRestartGroup, 6);
                        i9 = i8 & (-57345);
                    } else {
                        i9 = i8;
                    }
                    if ((i2 & 32) != 0) {
                        jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(standardContainerColor, composerStartRestartGroup, (i9 >> 12) & 14);
                        i9 &= -458753;
                    }
                    if (i6 != 0) {
                        fM3298getPermanentDrawerElevationD9Ej5fM = DrawerDefaults.INSTANCE.m3298getPermanentDrawerElevationD9Ej5fM();
                    } else {
                        fM3298getPermanentDrawerElevationD9Ej5fM = f;
                    }
                    if ((i2 & 128) != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 493670338, "CC(remember):NavigationDrawer.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new FloatProducer() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda8
                                @Override // androidx.compose.material3.internal.FloatProducer
                                public final float invoke() {
                                    return NavigationDrawerKt.DrawerSheet_cm3T3N0$lambda$0$0();
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        floatProducer3 = (FloatProducer) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        i9 &= -29360129;
                    } else {
                        floatProducer3 = floatProducer;
                    }
                    f3 = fM3298getPermanentDrawerElevationD9Ej5fM;
                    j5 = standardContainerColor;
                }
                long j8 = jM3051contentColorForek8zF_U;
                Shape shape5 = rectangleShape;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1560288494, i9, -1, "androidx.compose.material3.DrawerSheet (NavigationDrawer.kt:854)");
                }
                ProvidableCompositionLocal<Density> localDensity3 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume4 = composerStartRestartGroup.consume(localDensity3);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                final float fM5562getContainerWidthD9Ej5fM3 = NavigationDrawerTokens.INSTANCE.m5562getContainerWidthD9Ej5fM();
                final float fMo754toPx0680j_6 = ((Density) objConsume4).mo754toPx0680j_4(fM5562getContainerWidthD9Ej5fM3);
                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection3 = CompositionLocalsKt.getLocalLayoutDirection();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                objConsume = composerStartRestartGroup.consume(localLayoutDirection3);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (objConsume == LayoutDirection.Rtl) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (drawerPredictiveBackState != null) {
                    companionPredictiveBackDrawerContainer = predictiveBackDrawerContainer(Modifier.INSTANCE, drawerPredictiveBackState, z2);
                } else {
                    companionPredictiveBackDrawerContainer = Modifier.INSTANCE;
                }
                Modifier modifier6 = modifier2;
                final FloatProducer floatProducer6 = floatProducer3;
                final WindowInsets windowInsets5 = windowInsets2;
                final boolean z5 = z2;
                int i17 = i9 >> 6;
                composer2 = composerStartRestartGroup;
                SurfaceKt.m4323SurfaceT9BRK9s(SizeKt.fillMaxHeight$default(horizontalScaleUp(SizeKt.m1270sizeInqDBjuR0$default(modifier6, MinimumDrawerWidth, 0.0f, fM5562getContainerWidthD9Ej5fM3, 0.0f, 10, null), floatProducer3, fMo754toPx0680j_6, z2).then(companionPredictiveBackDrawerContainer), 0.0f, 1, null), shape5, j5, j8, f3, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(-315420087, true, new Function2() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return NavigationDrawerKt.DrawerSheet_cm3T3N0$lambda$2(drawerPredictiveBackState, z5, fM5562getContainerWidthD9Ej5fM3, floatProducer6, fMo754toPx0680j_6, windowInsets5, function3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composer2, (i17 & 112) | 12582912 | (i17 & 896) | (i17 & 7168) | (i17 & 57344), 96);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                floatProducer2 = floatProducer3;
                shape2 = shape5;
                j3 = j5;
                j4 = j8;
                f2 = f3;
                modifier3 = modifier6;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier3 = modifier2;
                shape2 = rectangleShape;
                j3 = standardContainerColor;
                j4 = jM3051contentColorForek8zF_U;
                f2 = f;
                floatProducer2 = floatProducer;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda10
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return NavigationDrawerKt.DrawerSheet_cm3T3N0$lambda$3(drawerPredictiveBackState, windowInsets, modifier3, shape2, j3, j4, f2, floatProducer2, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 3072;
        rectangleShape = shape;
        if ((i & 24576) == 0) {
            if ((i2 & 16) == 0) {
                standardContainerColor = j;
                if (composerStartRestartGroup.changed(standardContainerColor)) {
                }
                i3 |= i13;
            } else {
                standardContainerColor = j;
            }
            i3 |= i13;
        } else {
            standardContainerColor = j;
        }
        if ((196608 & i) == 0) {
            if ((i2 & 32) == 0) {
                jM3051contentColorForek8zF_U = j2;
                if (composerStartRestartGroup.changed(jM3051contentColorForek8zF_U)) {
                }
                i3 |= i14;
            } else {
                jM3051contentColorForek8zF_U = j2;
            }
            i3 |= i14;
        } else {
            jM3051contentColorForek8zF_U = j2;
        }
        i6 = i2 & 64;
        if (i6 != 0) {
            i3 |= 1572864;
        } else if ((i & 1572864) == 0) {
            if (composerStartRestartGroup.changed(f)) {
                i7 = 1048576;
            } else {
                i7 = 524288;
            }
            i3 |= i7;
        }
        if ((i & 12582912) == 0) {
            if ((i2 & 128) != 0) {
                i11 = 4194304;
            } else {
                if ((16777216 & i) == 0) {
                    zChangedInstance = composerStartRestartGroup.changed(floatProducer);
                } else {
                    zChangedInstance = composerStartRestartGroup.changedInstance(floatProducer);
                }
                if (zChangedInstance) {
                    i11 = 8388608;
                } else {
                    i11 = 4194304;
                }
            }
            i3 |= i11;
        }
        if ((100663296 & i) != 0) {
            if (composerStartRestartGroup.changedInstance(function3)) {
                i10 = 67108864;
            } else {
                i10 = 33554432;
            }
            i3 |= i10;
        }
        i8 = i3;
        if ((i3 & 38347923) != 38347922) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i8 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "849@36868L22,850@36924L37,852@37069L20");
            if ((i & 1) != 0) {
                if (i12 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i4 != 0) {
                    rectangleShape = RectangleShapeKt.getRectangleShape();
                }
                if ((i2 & 16) != 0) {
                    standardContainerColor = DrawerDefaults.INSTANCE.getStandardContainerColor(composerStartRestartGroup, 6);
                    i9 = i8 & (-57345);
                } else {
                    i9 = i8;
                }
                if ((i2 & 32) != 0) {
                    jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(standardContainerColor, composerStartRestartGroup, (i9 >> 12) & 14);
                    i9 &= -458753;
                }
                if (i6 != 0) {
                    fM3298getPermanentDrawerElevationD9Ej5fM = DrawerDefaults.INSTANCE.m3298getPermanentDrawerElevationD9Ej5fM();
                } else {
                    fM3298getPermanentDrawerElevationD9Ej5fM = f;
                }
                if ((i2 & 128) != 0) {
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 493670338, "CC(remember):NavigationDrawer.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new FloatProducer() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda8
                            @Override // androidx.compose.material3.internal.FloatProducer
                            public final float invoke() {
                                return NavigationDrawerKt.DrawerSheet_cm3T3N0$lambda$0$0();
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    floatProducer3 = (FloatProducer) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    i9 &= -29360129;
                } else {
                    floatProducer3 = floatProducer;
                }
                f3 = fM3298getPermanentDrawerElevationD9Ej5fM;
                j5 = standardContainerColor;
            } else {
                if (i12 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i4 != 0) {
                    rectangleShape = RectangleShapeKt.getRectangleShape();
                }
                if ((i2 & 16) != 0) {
                    standardContainerColor = DrawerDefaults.INSTANCE.getStandardContainerColor(composerStartRestartGroup, 6);
                    i9 = i8 & (-57345);
                } else {
                    i9 = i8;
                }
                if ((i2 & 32) != 0) {
                    jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(standardContainerColor, composerStartRestartGroup, (i9 >> 12) & 14);
                    i9 &= -458753;
                }
                if (i6 != 0) {
                    fM3298getPermanentDrawerElevationD9Ej5fM = DrawerDefaults.INSTANCE.m3298getPermanentDrawerElevationD9Ej5fM();
                } else {
                    fM3298getPermanentDrawerElevationD9Ej5fM = f;
                }
                if ((i2 & 128) != 0) {
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 493670338, "CC(remember):NavigationDrawer.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new FloatProducer() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda8
                            @Override // androidx.compose.material3.internal.FloatProducer
                            public final float invoke() {
                                return NavigationDrawerKt.DrawerSheet_cm3T3N0$lambda$0$0();
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    floatProducer3 = (FloatProducer) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    i9 &= -29360129;
                } else {
                    floatProducer3 = floatProducer;
                }
                f3 = fM3298getPermanentDrawerElevationD9Ej5fM;
                j5 = standardContainerColor;
            }
            long j9 = jM3051contentColorForek8zF_U;
            Shape shape6 = rectangleShape;
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1560288494, i9, -1, "androidx.compose.material3.DrawerSheet (NavigationDrawer.kt:854)");
            }
            ProvidableCompositionLocal<Density> localDensity4 = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume5 = composerStartRestartGroup.consume(localDensity4);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final float fM5562getContainerWidthD9Ej5fM4 = NavigationDrawerTokens.INSTANCE.m5562getContainerWidthD9Ej5fM();
            final float fMo754toPx0680j_7 = ((Density) objConsume5).mo754toPx0680j_4(fM5562getContainerWidthD9Ej5fM4);
            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection4 = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            objConsume = composerStartRestartGroup.consume(localLayoutDirection4);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (objConsume == LayoutDirection.Rtl) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (drawerPredictiveBackState != null) {
                companionPredictiveBackDrawerContainer = predictiveBackDrawerContainer(Modifier.INSTANCE, drawerPredictiveBackState, z2);
            } else {
                companionPredictiveBackDrawerContainer = Modifier.INSTANCE;
            }
            Modifier modifier7 = modifier2;
            final FloatProducer floatProducer7 = floatProducer3;
            final WindowInsets windowInsets6 = windowInsets2;
            final boolean z6 = z2;
            int i18 = i9 >> 6;
            composer2 = composerStartRestartGroup;
            SurfaceKt.m4323SurfaceT9BRK9s(SizeKt.fillMaxHeight$default(horizontalScaleUp(SizeKt.m1270sizeInqDBjuR0$default(modifier7, MinimumDrawerWidth, 0.0f, fM5562getContainerWidthD9Ej5fM4, 0.0f, 10, null), floatProducer3, fMo754toPx0680j_7, z2).then(companionPredictiveBackDrawerContainer), 0.0f, 1, null), shape6, j5, j9, f3, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(-315420087, true, new Function2() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return NavigationDrawerKt.DrawerSheet_cm3T3N0$lambda$2(drawerPredictiveBackState, z6, fM5562getContainerWidthD9Ej5fM4, floatProducer7, fMo754toPx0680j_7, windowInsets6, function3, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composer2, (i18 & 112) | 12582912 | (i18 & 896) | (i18 & 7168) | (i18 & 57344), 96);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            floatProducer2 = floatProducer3;
            shape2 = shape6;
            j3 = j5;
            j4 = j9;
            f2 = f3;
            modifier3 = modifier7;
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            modifier3 = modifier2;
            shape2 = rectangleShape;
            j3 = standardContainerColor;
            j4 = jM3051contentColorForek8zF_U;
            f2 = f;
            floatProducer2 = floatProducer;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda10
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return NavigationDrawerKt.DrawerSheet_cm3T3N0$lambda$3(drawerPredictiveBackState, windowInsets, modifier3, shape2, j3, j4, f2, floatProducer2, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DrawerSheet_cm3T3N0$lambda$2(DrawerPredictiveBackState drawerPredictiveBackState, boolean z, float f, FloatProducer floatProducer, float f2, WindowInsets windowInsets, Function3 function3, Composer composer, int i) {
        Modifier.Companion companionPredictiveBackDrawerChild;
        ComposerKt.sourceInformation(composer, "C889@38755L641:NavigationDrawer.kt#uh7d8r");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-315420087, i, -1, "androidx.compose.material3.DrawerSheet.<anonymous> (NavigationDrawer.kt:885)");
            }
            if (drawerPredictiveBackState != null) {
                companionPredictiveBackDrawerChild = predictiveBackDrawerChild(Modifier.INSTANCE, drawerPredictiveBackState, z);
            } else {
                companionPredictiveBackDrawerChild = Modifier.INSTANCE;
            }
            Modifier modifierWindowInsetsPadding = WindowInsetsPaddingKt.windowInsetsPadding(horizontalScaleDown(SizeKt.m1270sizeInqDBjuR0$default(Modifier.INSTANCE, MinimumDrawerWidth, 0.0f, f, 0.0f, 10, null), floatProducer, f2, z).then(companionPredictiveBackDrawerChild), windowInsets);
            ComposerKt.sourceInformationMarkerStart(composer, -483455358, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer, 0);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierWindowInsetsPadding);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor);
            } else {
                composer.useNode();
            }
            Composer composerM6062constructorimpl = Updater.m6062constructorimpl(composer);
            Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM6062constructorimpl.getInserting() || !Intrinsics.areEqual(composerM6062constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, -384672921, "C89@4556L9:Column.kt#2w3rfo");
            function3.invoke(ColumnScopeInstance.INSTANCE, composer, 6);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    private static final Modifier horizontalScaleUp(Modifier modifier, final FloatProducer floatProducer, final float f, final boolean z) {
        return GraphicsLayerModifierKt.graphicsLayer(modifier, new Function1() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda17
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return NavigationDrawerKt.horizontalScaleUp$lambda$0(floatProducer, f, z, (GraphicsLayerScope) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit horizontalScaleUp$lambda$0(FloatProducer floatProducer, float f, boolean z, GraphicsLayerScope graphicsLayerScope) {
        float fInvoke = floatProducer.invoke();
        graphicsLayerScope.setScaleX(fInvoke > 0.0f ? (fInvoke / f) + 1.0f : 1.0f);
        graphicsLayerScope.mo7017setTransformOrigin__ExYCQ(TransformOriginKt.TransformOrigin(z ? 0.0f : 1.0f, 0.5f));
        return Unit.INSTANCE;
    }

    private static final Modifier horizontalScaleDown(Modifier modifier, final FloatProducer floatProducer, final float f, final boolean z) {
        return GraphicsLayerModifierKt.graphicsLayer(modifier, new Function1() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda36
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return NavigationDrawerKt.horizontalScaleDown$lambda$0(floatProducer, f, z, (GraphicsLayerScope) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit horizontalScaleDown$lambda$0(FloatProducer floatProducer, float f, boolean z, GraphicsLayerScope graphicsLayerScope) {
        float fInvoke = floatProducer.invoke();
        graphicsLayerScope.setScaleX(fInvoke > 0.0f ? 1 / ((fInvoke / f) + 1.0f) : 1.0f);
        graphicsLayerScope.mo7017setTransformOrigin__ExYCQ(TransformOriginKt.TransformOrigin(z ? 0.0f : 1.0f, 0.0f));
        return Unit.INSTANCE;
    }

    private static final Modifier predictiveBackDrawerContainer(Modifier modifier, final DrawerPredictiveBackState drawerPredictiveBackState, final boolean z) {
        return GraphicsLayerModifierKt.graphicsLayer(modifier, new Function1() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda26
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return NavigationDrawerKt.predictiveBackDrawerContainer$lambda$0(drawerPredictiveBackState, z, (GraphicsLayerScope) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit predictiveBackDrawerContainer$lambda$0(DrawerPredictiveBackState drawerPredictiveBackState, boolean z, GraphicsLayerScope graphicsLayerScope) {
        graphicsLayerScope.setScaleX(calculatePredictiveBackScaleX(graphicsLayerScope, drawerPredictiveBackState));
        graphicsLayerScope.setScaleY(calculatePredictiveBackScaleY(graphicsLayerScope, drawerPredictiveBackState));
        graphicsLayerScope.mo7017setTransformOrigin__ExYCQ(TransformOriginKt.TransformOrigin(z ? 1.0f : 0.0f, 0.5f));
        return Unit.INSTANCE;
    }

    private static final Modifier predictiveBackDrawerChild(Modifier modifier, final DrawerPredictiveBackState drawerPredictiveBackState, final boolean z) {
        return GraphicsLayerModifierKt.graphicsLayer(modifier, new Function1() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda15
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return NavigationDrawerKt.predictiveBackDrawerChild$lambda$0(drawerPredictiveBackState, z, (GraphicsLayerScope) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit predictiveBackDrawerChild$lambda$0(DrawerPredictiveBackState drawerPredictiveBackState, boolean z, GraphicsLayerScope graphicsLayerScope) {
        float fCalculatePredictiveBackScaleX = calculatePredictiveBackScaleX(graphicsLayerScope, drawerPredictiveBackState);
        graphicsLayerScope.setScaleX(fCalculatePredictiveBackScaleX == 0.0f ? 1.0f : calculatePredictiveBackScaleY(graphicsLayerScope, drawerPredictiveBackState) / fCalculatePredictiveBackScaleX);
        graphicsLayerScope.mo7017setTransformOrigin__ExYCQ(TransformOriginKt.TransformOrigin(z ? 0.0f : 1.0f, 0.0f));
        return Unit.INSTANCE;
    }

    private static final float calculatePredictiveBackScaleX(GraphicsLayerScope graphicsLayerScope, DrawerPredictiveBackState drawerPredictiveBackState) {
        float fIntBitsToFloat = Float.intBitsToFloat((int) (graphicsLayerScope.getSize() >> 32));
        if (Float.isNaN(fIntBitsToFloat) || fIntBitsToFloat == 0.0f) {
            return 1.0f;
        }
        return ((drawerPredictiveBackState.getScaleXDistance() * (drawerPredictiveBackState.getSwipeEdgeMatchesDrawer() ? 1 : -1)) / fIntBitsToFloat) + 1.0f;
    }

    private static final float calculatePredictiveBackScaleY(GraphicsLayerScope graphicsLayerScope, DrawerPredictiveBackState drawerPredictiveBackState) {
        float fIntBitsToFloat = Float.intBitsToFloat((int) (graphicsLayerScope.getSize() & 4294967295L));
        if (Float.isNaN(fIntBitsToFloat) || fIntBitsToFloat == 0.0f) {
            return 1.0f;
        }
        return 1.0f - (drawerPredictiveBackState.getScaleYDistance() / fIntBitsToFloat);
    }

    public static final void DrawerPredictiveBackHandler(final DrawerState drawerState, final Function3<? super DrawerPredictiveBackState, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i) {
        int i2;
        DrawerPredictiveBackState drawerPredictiveBackState;
        String str;
        NavigationDrawerKt$DrawerPredictiveBackHandler$2$1 navigationDrawerKt$DrawerPredictiveBackHandler$2$1;
        Composer composerStartRestartGroup = composer.startRestartGroup(-383087355);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(DrawerPredictiveBackHandler)N(drawerState,content)1000@42941L40,1001@42998L24,1002@43060L7,1006@43222L7,1012@43535L1297,1012@43483L1349,1044@44875L99,1044@44838L136,1050@44980L34:NavigationDrawer.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(drawerState) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function3) ? 32 : 16;
        }
        int i3 = i2;
        if (!composerStartRestartGroup.shouldExecute((i3 & 19) != 18, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-383087355, i3, -1, "androidx.compose.material3.DrawerPredictiveBackHandler (NavigationDrawer.kt:999)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1220244621, "CC(remember):NavigationDrawer.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new DrawerPredictiveBackState();
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            DrawerPredictiveBackState drawerPredictiveBackState2 = (DrawerPredictiveBackState) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 773894976, "CC(rememberCoroutineScope)N(getContext)608@27648L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 683737348, "CC(remember):Effects.kt#9igjgp");
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            CoroutineScope coroutineScope = (CoroutineScope) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composerStartRestartGroup.consume(localLayoutDirection);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            boolean z = objConsume == LayoutDirection.Rtl;
            Ref.FloatRef floatRef = new Ref.FloatRef();
            Ref.FloatRef floatRef2 = new Ref.FloatRef();
            Ref.FloatRef floatRef3 = new Ref.FloatRef();
            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume2 = composerStartRestartGroup.consume(localDensity);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Density density = (Density) objConsume2;
            floatRef.element = density.mo754toPx0680j_4(PredictiveBackDrawerMaxScaleXDistanceGrow);
            floatRef2.element = density.mo754toPx0680j_4(PredictiveBackDrawerMaxScaleXDistanceShrink);
            floatRef3.element = density.mo754toPx0680j_4(PredictiveBackDrawerMaxScaleYDistance);
            boolean zIsOpen = drawerState.isOpen();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1220264886, "CC(remember):NavigationDrawer.kt#9igjgp");
            int i4 = i3 & 14;
            boolean zChanged = composerStartRestartGroup.changed(z) | composerStartRestartGroup.changed(floatRef.element) | composerStartRestartGroup.changed(floatRef2.element) | composerStartRestartGroup.changed(floatRef3.element) | composerStartRestartGroup.changedInstance(coroutineScope) | (i4 == 4);
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                drawerPredictiveBackState = drawerPredictiveBackState2;
                str = "CC(remember):NavigationDrawer.kt#9igjgp";
                navigationDrawerKt$DrawerPredictiveBackHandler$2$1 = new NavigationDrawerKt$DrawerPredictiveBackHandler$2$1(drawerPredictiveBackState, coroutineScope, drawerState, z, floatRef, floatRef2, floatRef3, null);
                composerStartRestartGroup.updateRememberedValue(navigationDrawerKt$DrawerPredictiveBackHandler$2$1);
            } else {
                str = "CC(remember):NavigationDrawer.kt#9igjgp";
                drawerPredictiveBackState = drawerPredictiveBackState2;
                navigationDrawerKt$DrawerPredictiveBackHandler$2$1 = objRememberedValue3;
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            BackHandler_androidKt.PredictiveBackHandler(zIsOpen, (Function2) navigationDrawerKt$DrawerPredictiveBackHandler$2$1, composerStartRestartGroup, 0, 0);
            Boolean boolValueOf = Boolean.valueOf(drawerState.isClosed());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1220306568, str);
            boolean z2 = i4 == 4;
            NavigationDrawerKt$DrawerPredictiveBackHandler$3$1 navigationDrawerKt$DrawerPredictiveBackHandler$3$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (z2 || navigationDrawerKt$DrawerPredictiveBackHandler$3$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                navigationDrawerKt$DrawerPredictiveBackHandler$3$1RememberedValue = new NavigationDrawerKt$DrawerPredictiveBackHandler$3$1(drawerState, drawerPredictiveBackState, null);
                composerStartRestartGroup.updateRememberedValue(navigationDrawerKt$DrawerPredictiveBackHandler$3$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(boolValueOf, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) navigationDrawerKt$DrawerPredictiveBackHandler$3$1RememberedValue, composerStartRestartGroup, 0);
            function3.invoke(drawerPredictiveBackState, composerStartRestartGroup, Integer.valueOf((i3 & 112) | 6));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda11
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return NavigationDrawerKt.DrawerPredictiveBackHandler$lambda$4(drawerState, function3, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX WARN: Code duplicated, block: B:108:0x0148 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:109:0x014a  */
    /* JADX WARN: Code duplicated, block: B:110:0x014f  */
    /* JADX WARN: Code duplicated, block: B:112:0x0152  */
    /* JADX WARN: Code duplicated, block: B:113:0x0155  */
    /* JADX WARN: Code duplicated, block: B:115:0x0159  */
    /* JADX WARN: Code duplicated, block: B:116:0x015c  */
    /* JADX WARN: Code duplicated, block: B:119:0x0162  */
    /* JADX WARN: Code duplicated, block: B:120:0x0172  */
    /* JADX WARN: Code duplicated, block: B:123:0x017a  */
    /* JADX WARN: Code duplicated, block: B:124:0x01b3  */
    /* JADX WARN: Code duplicated, block: B:126:0x01bd  */
    /* JADX WARN: Code duplicated, block: B:127:0x01bf  */
    /* JADX WARN: Code duplicated, block: B:131:0x01cf  */
    /* JADX WARN: Code duplicated, block: B:134:0x01ec  */
    /* JADX WARN: Code duplicated, block: B:137:0x0274  */
    /* JADX WARN: Code duplicated, block: B:139:0x0282  */
    /* JADX WARN: Code duplicated, block: B:142:0x0295  */
    /* JADX WARN: Code duplicated, block: B:144:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:38:0x006d  */
    /* JADX WARN: Code duplicated, block: B:39:0x0070  */
    /* JADX WARN: Code duplicated, block: B:41:0x0074  */
    /* JADX WARN: Code duplicated, block: B:43:0x007c  */
    /* JADX WARN: Code duplicated, block: B:44:0x007f  */
    /* JADX WARN: Code duplicated, block: B:49:0x008b  */
    /* JADX WARN: Code duplicated, block: B:50:0x008d  */
    /* JADX WARN: Code duplicated, block: B:52:0x0090  */
    /* JADX WARN: Code duplicated, block: B:54:0x0098  */
    /* JADX WARN: Code duplicated, block: B:55:0x009b  */
    /* JADX WARN: Code duplicated, block: B:60:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:62:0x00aa  */
    /* JADX WARN: Code duplicated, block: B:64:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:65:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:68:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:71:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:73:0x00c8  */
    /* JADX WARN: Code duplicated, block: B:76:0x00d3 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:79:0x00da  */
    /* JADX WARN: Code duplicated, block: B:82:0x00e2  */
    /* JADX WARN: Code duplicated, block: B:83:0x00e7  */
    /* JADX WARN: Code duplicated, block: B:85:0x00ed  */
    /* JADX WARN: Code duplicated, block: B:87:0x00f3  */
    /* JADX WARN: Code duplicated, block: B:88:0x00f6  */
    /* JADX WARN: Code duplicated, block: B:92:0x0107  */
    /* JADX WARN: Code duplicated, block: B:93:0x0109  */
    /* JADX WARN: Code duplicated, block: B:96:0x0112  */
    /* JADX WARN: Code duplicated, block: B:98:0x0125  */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v5, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r2v9 */
    public static final void NavigationDrawerItem(final Function2<? super Composer, ? super Integer, Unit> function2, final boolean z, final Function0<Unit> function0, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function3, Function2<? super Composer, ? super Integer, Unit> function4, Shape shape, NavigationDrawerItemColors navigationDrawerItemColors, MutableInteractionSource mutableInteractionSource, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        Function2<? super Composer, ? super Integer, Unit> function5;
        int i5;
        int i6;
        Function2<? super Composer, ? super Integer, Unit> function6;
        int i7;
        Shape shape2;
        int i8;
        int i9;
        boolean z2;
        Composer composer2;
        final NavigationDrawerItemColors navigationDrawerItemColors2;
        final Modifier modifier3;
        final Function2<? super Composer, ? super Integer, Unit> function7;
        final Function2<? super Composer, ? super Integer, Unit> function8;
        final Shape shape3;
        final MutableInteractionSource mutableInteractionSource2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        Function2<? super Composer, ? super Integer, Unit> function9;
        Function2<? super Composer, ? super Integer, Unit> function10;
        Shape value;
        int i10;
        boolean z3;
        boolean z4;
        NavigationDrawerItemColors navigationDrawerItemColorsM3849colorsoq7We08;
        MutableInteractionSource mutableInteractionSource3;
        NavigationDrawerItemColors navigationDrawerItemColors3;
        Modifier modifier4;
        ?? r2;
        Object objRememberedValue;
        Composer composerStartRestartGroup = composer.startRestartGroup(-583709666);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(NavigationDrawerItem)N(label,selected,onClick,modifier,icon,badge,shape,colors,interactionSource)1141@48903L19,1145@49080L24,1147@49165L885,1136@48771L1279:NavigationDrawer.kt#uh7d8r");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(function2) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(z) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function0) ? 256 : 128;
        }
        int i11 = i2 & 8;
        if (i11 == 0) {
            if ((i & 3072) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 2048 : 1024;
            }
            i4 = i2 & 16;
            if (i4 != 0) {
                if ((i & 24576) == 0) {
                    function5 = function3;
                    if (composerStartRestartGroup.changedInstance(function5)) {
                        i5 = 16384;
                    } else {
                        i5 = 8192;
                    }
                    i3 |= i5;
                }
                i6 = i2 & 32;
                if (i6 != 0) {
                    if ((196608 & i) == 0) {
                        function6 = function4;
                        if (composerStartRestartGroup.changedInstance(function6)) {
                            i7 = 131072;
                        } else {
                            i7 = 65536;
                        }
                        i3 |= i7;
                    }
                    if ((1572864 & i) == 0) {
                        if ((i2 & 64) == 0) {
                            shape2 = shape;
                            int i12 = composerStartRestartGroup.changed(shape2) ? 1048576 : 524288;
                            i3 |= i12;
                        } else {
                            shape2 = shape;
                        }
                        i3 |= i12;
                    } else {
                        shape2 = shape;
                    }
                    if ((i & 12582912) != 0) {
                        i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(navigationDrawerItemColors)) ? 4194304 : 8388608;
                    }
                    i8 = i2 & 256;
                    if (i8 != 0) {
                        i3 |= 100663296;
                    } else if ((i & 100663296) == 0) {
                        if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                            i9 = 67108864;
                        } else {
                            i9 = 33554432;
                        }
                        i3 |= i9;
                    }
                    if ((i3 & 38347923) != 38347922) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z2, i3 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "1132@48619L5,1133@48696L8");
                        if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            if (i11 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier2;
                            }
                            if (i4 != 0) {
                                function9 = null;
                            } else {
                                function9 = function5;
                            }
                            if (i6 != 0) {
                                function10 = null;
                            } else {
                                function10 = function6;
                            }
                            if ((i2 & 64) != 0) {
                                i3 &= -3670017;
                                value = ShapesKt.getValue(NavigationDrawerTokens.INSTANCE.getActiveIndicatorShape(), composerStartRestartGroup, 6);
                            } else {
                                value = shape2;
                            }
                            i10 = i3;
                            if ((i2 & 128) != 0) {
                                z4 = false;
                                z3 = true;
                                navigationDrawerItemColorsM3849colorsoq7We08 = NavigationDrawerItemDefaults.INSTANCE.m3849colorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, 255);
                                i3 = i10 & (-29360129);
                            } else {
                                z3 = true;
                                z4 = false;
                                navigationDrawerItemColorsM3849colorsoq7We08 = navigationDrawerItemColors;
                                i3 = i10;
                            }
                            if (i8 != 0) {
                                composerStartRestartGroup = composerStartRestartGroup;
                                mutableInteractionSource3 = null;
                            } else {
                                composerStartRestartGroup = composerStartRestartGroup;
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            navigationDrawerItemColors3 = navigationDrawerItemColorsM3849colorsoq7We08;
                            function5 = function9;
                            modifier4 = companion;
                            r2 = z3;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i2 & 64) != 0) {
                                i3 &= -3670017;
                            }
                            if ((i2 & 128) != 0) {
                                i3 &= -29360129;
                            }
                            mutableInteractionSource3 = mutableInteractionSource;
                            r2 = 1;
                            modifier4 = modifier2;
                            function10 = function6;
                            value = shape2;
                            z4 = false;
                            navigationDrawerItemColors3 = navigationDrawerItemColors;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-583709666, i3, -1, "androidx.compose.material3.NavigationDrawerItem (NavigationDrawer.kt:1135)");
                        }
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1695745329, "CC(remember):NavigationDrawer.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new Function1() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda18
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return NavigationDrawerKt.NavigationDrawerItem$lambda$0$0((SemanticsPropertyReceiver) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        int i13 = i3 >> 3;
                        final NavigationDrawerItemColors navigationDrawerItemColors4 = navigationDrawerItemColors3;
                        final Function2<? super Composer, ? super Integer, Unit> function11 = function5;
                        final Function2<? super Composer, ? super Integer, Unit> function12 = function10;
                        Modifier modifier5 = modifier4;
                        Shape shape4 = value;
                        SurfaceKt.m4324Surfaced85dljk(z, function0, SizeKt.fillMaxWidth$default(SizeKt.m1254heightInVpY3zN4$default(SemanticsModifierKt.semantics$default(modifier4, z4, (Function1) objRememberedValue, r2, null), NavigationDrawerTokens.INSTANCE.m5560getActiveIndicatorHeightD9Ej5fM(), 0.0f, 2, null), 0.0f, r2, null), false, shape4, navigationDrawerItemColors3.containerColor(z, composerStartRestartGroup, (i13 & 14) | ((i3 >> 18) & 112)).getValue().m6824unboximpl(), 0L, 0.0f, 0.0f, (BorderStroke) null, mutableInteractionSource3, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(-1173018444, r2, new Function2() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda19
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return NavigationDrawerKt.NavigationDrawerItem$lambda$1(function11, navigationDrawerItemColors4, z, function12, function2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, (i13 & 126) | ((i3 >> 6) & 57344), ((i3 >> 24) & 14) | 48, 968);
                        composer2 = composerStartRestartGroup;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        shape3 = shape4;
                        mutableInteractionSource2 = mutableInteractionSource3;
                        navigationDrawerItemColors2 = navigationDrawerItemColors4;
                        modifier3 = modifier5;
                        function7 = function11;
                        function8 = function10;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        navigationDrawerItemColors2 = navigationDrawerItemColors;
                        modifier3 = modifier2;
                        function7 = function5;
                        function8 = function6;
                        shape3 = shape2;
                        mutableInteractionSource2 = mutableInteractionSource;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda20
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return NavigationDrawerKt.NavigationDrawerItem$lambda$2(function2, z, function0, modifier3, function7, function8, shape3, navigationDrawerItemColors2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                function6 = function4;
                if ((1572864 & i) == 0) {
                    if ((i2 & 64) == 0) {
                        shape2 = shape;
                        if (composerStartRestartGroup.changed(shape2)) {
                        }
                        i3 |= i12;
                    } else {
                        shape2 = shape;
                    }
                    i3 |= i12;
                } else {
                    shape2 = shape;
                }
                if ((i & 12582912) != 0) {
                    i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(navigationDrawerItemColors)) ? 4194304 : 8388608;
                }
                i8 = i2 & 256;
                if (i8 != 0) {
                    i3 |= 100663296;
                } else if ((i & 100663296) == 0) {
                    if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                        i9 = 67108864;
                    } else {
                        i9 = 33554432;
                    }
                    i3 |= i9;
                }
                if ((i3 & 38347923) != 38347922) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z2, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "1132@48619L5,1133@48696L8");
                    if ((i & 1) != 0) {
                        if (i11 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i4 != 0) {
                            function9 = null;
                        } else {
                            function9 = function5;
                        }
                        if (i6 != 0) {
                            function10 = null;
                        } else {
                            function10 = function6;
                        }
                        if ((i2 & 64) != 0) {
                            i3 &= -3670017;
                            value = ShapesKt.getValue(NavigationDrawerTokens.INSTANCE.getActiveIndicatorShape(), composerStartRestartGroup, 6);
                        } else {
                            value = shape2;
                        }
                        i10 = i3;
                        if ((i2 & 128) != 0) {
                            z4 = false;
                            z3 = true;
                            navigationDrawerItemColorsM3849colorsoq7We08 = NavigationDrawerItemDefaults.INSTANCE.m3849colorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, 255);
                            i3 = i10 & (-29360129);
                        } else {
                            z3 = true;
                            z4 = false;
                            navigationDrawerItemColorsM3849colorsoq7We08 = navigationDrawerItemColors;
                            i3 = i10;
                        }
                        if (i8 != 0) {
                            composerStartRestartGroup = composerStartRestartGroup;
                            mutableInteractionSource3 = null;
                        } else {
                            composerStartRestartGroup = composerStartRestartGroup;
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        navigationDrawerItemColors3 = navigationDrawerItemColorsM3849colorsoq7We08;
                        function5 = function9;
                        modifier4 = companion;
                        r2 = z3;
                    } else {
                        if (i11 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i4 != 0) {
                            function9 = null;
                        } else {
                            function9 = function5;
                        }
                        if (i6 != 0) {
                            function10 = null;
                        } else {
                            function10 = function6;
                        }
                        if ((i2 & 64) != 0) {
                            i3 &= -3670017;
                            value = ShapesKt.getValue(NavigationDrawerTokens.INSTANCE.getActiveIndicatorShape(), composerStartRestartGroup, 6);
                        } else {
                            value = shape2;
                        }
                        i10 = i3;
                        if ((i2 & 128) != 0) {
                            z4 = false;
                            z3 = true;
                            navigationDrawerItemColorsM3849colorsoq7We08 = NavigationDrawerItemDefaults.INSTANCE.m3849colorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, 255);
                            i3 = i10 & (-29360129);
                        } else {
                            z3 = true;
                            z4 = false;
                            navigationDrawerItemColorsM3849colorsoq7We08 = navigationDrawerItemColors;
                            i3 = i10;
                        }
                        if (i8 != 0) {
                            composerStartRestartGroup = composerStartRestartGroup;
                            mutableInteractionSource3 = null;
                        } else {
                            composerStartRestartGroup = composerStartRestartGroup;
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        navigationDrawerItemColors3 = navigationDrawerItemColorsM3849colorsoq7We08;
                        function5 = function9;
                        modifier4 = companion;
                        r2 = z3;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-583709666, i3, -1, "androidx.compose.material3.NavigationDrawerItem (NavigationDrawer.kt:1135)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1695745329, "CC(remember):NavigationDrawer.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new Function1() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda18
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return NavigationDrawerKt.NavigationDrawerItem$lambda$0$0((SemanticsPropertyReceiver) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    int i14 = i3 >> 3;
                    final NavigationDrawerItemColors navigationDrawerItemColors5 = navigationDrawerItemColors3;
                    final Function2 function13 = function5;
                    final Function2 function14 = function10;
                    Modifier modifier6 = modifier4;
                    Shape shape5 = value;
                    SurfaceKt.m4324Surfaced85dljk(z, function0, SizeKt.fillMaxWidth$default(SizeKt.m1254heightInVpY3zN4$default(SemanticsModifierKt.semantics$default(modifier4, z4, (Function1) objRememberedValue, r2, null), NavigationDrawerTokens.INSTANCE.m5560getActiveIndicatorHeightD9Ej5fM(), 0.0f, 2, null), 0.0f, r2, null), false, shape5, navigationDrawerItemColors3.containerColor(z, composerStartRestartGroup, (i14 & 14) | ((i3 >> 18) & 112)).getValue().m6824unboximpl(), 0L, 0.0f, 0.0f, (BorderStroke) null, mutableInteractionSource3, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(-1173018444, r2, new Function2() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda19
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return NavigationDrawerKt.NavigationDrawerItem$lambda$1(function13, navigationDrawerItemColors5, z, function14, function2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, (i14 & 126) | ((i3 >> 6) & 57344), ((i3 >> 24) & 14) | 48, 968);
                    composer2 = composerStartRestartGroup;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    shape3 = shape5;
                    mutableInteractionSource2 = mutableInteractionSource3;
                    navigationDrawerItemColors2 = navigationDrawerItemColors5;
                    modifier3 = modifier6;
                    function7 = function13;
                    function8 = function10;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    navigationDrawerItemColors2 = navigationDrawerItemColors;
                    modifier3 = modifier2;
                    function7 = function5;
                    function8 = function6;
                    shape3 = shape2;
                    mutableInteractionSource2 = mutableInteractionSource;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda20
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return NavigationDrawerKt.NavigationDrawerItem$lambda$2(function2, z, function0, modifier3, function7, function8, shape3, navigationDrawerItemColors2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 24576;
            function5 = function3;
            i6 = i2 & 32;
            if (i6 != 0) {
                if ((196608 & i) == 0) {
                    function6 = function4;
                    if (composerStartRestartGroup.changedInstance(function6)) {
                        i7 = 131072;
                    } else {
                        i7 = 65536;
                    }
                    i3 |= i7;
                }
                if ((1572864 & i) == 0) {
                    if ((i2 & 64) == 0) {
                        shape2 = shape;
                        if (composerStartRestartGroup.changed(shape2)) {
                        }
                        i3 |= i12;
                    } else {
                        shape2 = shape;
                    }
                    i3 |= i12;
                } else {
                    shape2 = shape;
                }
                if ((i & 12582912) != 0) {
                    i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(navigationDrawerItemColors)) ? 4194304 : 8388608;
                }
                i8 = i2 & 256;
                if (i8 != 0) {
                    i3 |= 100663296;
                } else if ((i & 100663296) == 0) {
                    if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                        i9 = 67108864;
                    } else {
                        i9 = 33554432;
                    }
                    i3 |= i9;
                }
                if ((i3 & 38347923) != 38347922) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z2, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "1132@48619L5,1133@48696L8");
                    if ((i & 1) != 0) {
                        if (i11 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i4 != 0) {
                            function9 = null;
                        } else {
                            function9 = function5;
                        }
                        if (i6 != 0) {
                            function10 = null;
                        } else {
                            function10 = function6;
                        }
                        if ((i2 & 64) != 0) {
                            i3 &= -3670017;
                            value = ShapesKt.getValue(NavigationDrawerTokens.INSTANCE.getActiveIndicatorShape(), composerStartRestartGroup, 6);
                        } else {
                            value = shape2;
                        }
                        i10 = i3;
                        if ((i2 & 128) != 0) {
                            z4 = false;
                            z3 = true;
                            navigationDrawerItemColorsM3849colorsoq7We08 = NavigationDrawerItemDefaults.INSTANCE.m3849colorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, 255);
                            i3 = i10 & (-29360129);
                        } else {
                            z3 = true;
                            z4 = false;
                            navigationDrawerItemColorsM3849colorsoq7We08 = navigationDrawerItemColors;
                            i3 = i10;
                        }
                        if (i8 != 0) {
                            composerStartRestartGroup = composerStartRestartGroup;
                            mutableInteractionSource3 = null;
                        } else {
                            composerStartRestartGroup = composerStartRestartGroup;
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        navigationDrawerItemColors3 = navigationDrawerItemColorsM3849colorsoq7We08;
                        function5 = function9;
                        modifier4 = companion;
                        r2 = z3;
                    } else {
                        if (i11 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i4 != 0) {
                            function9 = null;
                        } else {
                            function9 = function5;
                        }
                        if (i6 != 0) {
                            function10 = null;
                        } else {
                            function10 = function6;
                        }
                        if ((i2 & 64) != 0) {
                            i3 &= -3670017;
                            value = ShapesKt.getValue(NavigationDrawerTokens.INSTANCE.getActiveIndicatorShape(), composerStartRestartGroup, 6);
                        } else {
                            value = shape2;
                        }
                        i10 = i3;
                        if ((i2 & 128) != 0) {
                            z4 = false;
                            z3 = true;
                            navigationDrawerItemColorsM3849colorsoq7We08 = NavigationDrawerItemDefaults.INSTANCE.m3849colorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, 255);
                            i3 = i10 & (-29360129);
                        } else {
                            z3 = true;
                            z4 = false;
                            navigationDrawerItemColorsM3849colorsoq7We08 = navigationDrawerItemColors;
                            i3 = i10;
                        }
                        if (i8 != 0) {
                            composerStartRestartGroup = composerStartRestartGroup;
                            mutableInteractionSource3 = null;
                        } else {
                            composerStartRestartGroup = composerStartRestartGroup;
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        navigationDrawerItemColors3 = navigationDrawerItemColorsM3849colorsoq7We08;
                        function5 = function9;
                        modifier4 = companion;
                        r2 = z3;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-583709666, i3, -1, "androidx.compose.material3.NavigationDrawerItem (NavigationDrawer.kt:1135)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1695745329, "CC(remember):NavigationDrawer.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new Function1() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda18
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return NavigationDrawerKt.NavigationDrawerItem$lambda$0$0((SemanticsPropertyReceiver) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    int i15 = i3 >> 3;
                    final NavigationDrawerItemColors navigationDrawerItemColors6 = navigationDrawerItemColors3;
                    final Function2 function15 = function5;
                    final Function2 function16 = function10;
                    Modifier modifier7 = modifier4;
                    Shape shape6 = value;
                    SurfaceKt.m4324Surfaced85dljk(z, function0, SizeKt.fillMaxWidth$default(SizeKt.m1254heightInVpY3zN4$default(SemanticsModifierKt.semantics$default(modifier4, z4, (Function1) objRememberedValue, r2, null), NavigationDrawerTokens.INSTANCE.m5560getActiveIndicatorHeightD9Ej5fM(), 0.0f, 2, null), 0.0f, r2, null), false, shape6, navigationDrawerItemColors3.containerColor(z, composerStartRestartGroup, (i15 & 14) | ((i3 >> 18) & 112)).getValue().m6824unboximpl(), 0L, 0.0f, 0.0f, (BorderStroke) null, mutableInteractionSource3, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(-1173018444, r2, new Function2() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda19
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return NavigationDrawerKt.NavigationDrawerItem$lambda$1(function15, navigationDrawerItemColors6, z, function16, function2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, (i15 & 126) | ((i3 >> 6) & 57344), ((i3 >> 24) & 14) | 48, 968);
                    composer2 = composerStartRestartGroup;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    shape3 = shape6;
                    mutableInteractionSource2 = mutableInteractionSource3;
                    navigationDrawerItemColors2 = navigationDrawerItemColors6;
                    modifier3 = modifier7;
                    function7 = function15;
                    function8 = function10;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    navigationDrawerItemColors2 = navigationDrawerItemColors;
                    modifier3 = modifier2;
                    function7 = function5;
                    function8 = function6;
                    shape3 = shape2;
                    mutableInteractionSource2 = mutableInteractionSource;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda20
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return NavigationDrawerKt.NavigationDrawerItem$lambda$2(function2, z, function0, modifier3, function7, function8, shape3, navigationDrawerItemColors2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            function6 = function4;
            if ((1572864 & i) == 0) {
                if ((i2 & 64) == 0) {
                    shape2 = shape;
                    if (composerStartRestartGroup.changed(shape2)) {
                    }
                    i3 |= i12;
                } else {
                    shape2 = shape;
                }
                i3 |= i12;
            } else {
                shape2 = shape;
            }
            if ((i & 12582912) != 0) {
                i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(navigationDrawerItemColors)) ? 4194304 : 8388608;
            }
            i8 = i2 & 256;
            if (i8 != 0) {
                i3 |= 100663296;
            } else if ((i & 100663296) == 0) {
                if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                    i9 = 67108864;
                } else {
                    i9 = 33554432;
                }
                i3 |= i9;
            }
            if ((i3 & 38347923) != 38347922) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z2, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "1132@48619L5,1133@48696L8");
                if ((i & 1) != 0) {
                    if (i11 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i4 != 0) {
                        function9 = null;
                    } else {
                        function9 = function5;
                    }
                    if (i6 != 0) {
                        function10 = null;
                    } else {
                        function10 = function6;
                    }
                    if ((i2 & 64) != 0) {
                        i3 &= -3670017;
                        value = ShapesKt.getValue(NavigationDrawerTokens.INSTANCE.getActiveIndicatorShape(), composerStartRestartGroup, 6);
                    } else {
                        value = shape2;
                    }
                    i10 = i3;
                    if ((i2 & 128) != 0) {
                        z4 = false;
                        z3 = true;
                        navigationDrawerItemColorsM3849colorsoq7We08 = NavigationDrawerItemDefaults.INSTANCE.m3849colorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, 255);
                        i3 = i10 & (-29360129);
                    } else {
                        z3 = true;
                        z4 = false;
                        navigationDrawerItemColorsM3849colorsoq7We08 = navigationDrawerItemColors;
                        i3 = i10;
                    }
                    if (i8 != 0) {
                        composerStartRestartGroup = composerStartRestartGroup;
                        mutableInteractionSource3 = null;
                    } else {
                        composerStartRestartGroup = composerStartRestartGroup;
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    navigationDrawerItemColors3 = navigationDrawerItemColorsM3849colorsoq7We08;
                    function5 = function9;
                    modifier4 = companion;
                    r2 = z3;
                } else {
                    if (i11 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i4 != 0) {
                        function9 = null;
                    } else {
                        function9 = function5;
                    }
                    if (i6 != 0) {
                        function10 = null;
                    } else {
                        function10 = function6;
                    }
                    if ((i2 & 64) != 0) {
                        i3 &= -3670017;
                        value = ShapesKt.getValue(NavigationDrawerTokens.INSTANCE.getActiveIndicatorShape(), composerStartRestartGroup, 6);
                    } else {
                        value = shape2;
                    }
                    i10 = i3;
                    if ((i2 & 128) != 0) {
                        z4 = false;
                        z3 = true;
                        navigationDrawerItemColorsM3849colorsoq7We08 = NavigationDrawerItemDefaults.INSTANCE.m3849colorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, 255);
                        i3 = i10 & (-29360129);
                    } else {
                        z3 = true;
                        z4 = false;
                        navigationDrawerItemColorsM3849colorsoq7We08 = navigationDrawerItemColors;
                        i3 = i10;
                    }
                    if (i8 != 0) {
                        composerStartRestartGroup = composerStartRestartGroup;
                        mutableInteractionSource3 = null;
                    } else {
                        composerStartRestartGroup = composerStartRestartGroup;
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    navigationDrawerItemColors3 = navigationDrawerItemColorsM3849colorsoq7We08;
                    function5 = function9;
                    modifier4 = companion;
                    r2 = z3;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-583709666, i3, -1, "androidx.compose.material3.NavigationDrawerItem (NavigationDrawer.kt:1135)");
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1695745329, "CC(remember):NavigationDrawer.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function1() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda18
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return NavigationDrawerKt.NavigationDrawerItem$lambda$0$0((SemanticsPropertyReceiver) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                int i16 = i3 >> 3;
                final NavigationDrawerItemColors navigationDrawerItemColors7 = navigationDrawerItemColors3;
                final Function2 function17 = function5;
                final Function2 function18 = function10;
                Modifier modifier8 = modifier4;
                Shape shape7 = value;
                SurfaceKt.m4324Surfaced85dljk(z, function0, SizeKt.fillMaxWidth$default(SizeKt.m1254heightInVpY3zN4$default(SemanticsModifierKt.semantics$default(modifier4, z4, (Function1) objRememberedValue, r2, null), NavigationDrawerTokens.INSTANCE.m5560getActiveIndicatorHeightD9Ej5fM(), 0.0f, 2, null), 0.0f, r2, null), false, shape7, navigationDrawerItemColors3.containerColor(z, composerStartRestartGroup, (i16 & 14) | ((i3 >> 18) & 112)).getValue().m6824unboximpl(), 0L, 0.0f, 0.0f, (BorderStroke) null, mutableInteractionSource3, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(-1173018444, r2, new Function2() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda19
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return NavigationDrawerKt.NavigationDrawerItem$lambda$1(function17, navigationDrawerItemColors7, z, function18, function2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, (i16 & 126) | ((i3 >> 6) & 57344), ((i3 >> 24) & 14) | 48, 968);
                composer2 = composerStartRestartGroup;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                shape3 = shape7;
                mutableInteractionSource2 = mutableInteractionSource3;
                navigationDrawerItemColors2 = navigationDrawerItemColors7;
                modifier3 = modifier8;
                function7 = function17;
                function8 = function10;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                navigationDrawerItemColors2 = navigationDrawerItemColors;
                modifier3 = modifier2;
                function7 = function5;
                function8 = function6;
                shape3 = shape2;
                mutableInteractionSource2 = mutableInteractionSource;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda20
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return NavigationDrawerKt.NavigationDrawerItem$lambda$2(function2, z, function0, modifier3, function7, function8, shape3, navigationDrawerItemColors2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 3072;
        modifier2 = modifier;
        i4 = i2 & 16;
        if (i4 != 0) {
            if ((i & 24576) == 0) {
                function5 = function3;
                if (composerStartRestartGroup.changedInstance(function5)) {
                    i5 = 16384;
                } else {
                    i5 = 8192;
                }
                i3 |= i5;
            }
            i6 = i2 & 32;
            if (i6 != 0) {
                if ((196608 & i) == 0) {
                    function6 = function4;
                    if (composerStartRestartGroup.changedInstance(function6)) {
                        i7 = 131072;
                    } else {
                        i7 = 65536;
                    }
                    i3 |= i7;
                }
                if ((1572864 & i) == 0) {
                    if ((i2 & 64) == 0) {
                        shape2 = shape;
                        if (composerStartRestartGroup.changed(shape2)) {
                        }
                        i3 |= i12;
                    } else {
                        shape2 = shape;
                    }
                    i3 |= i12;
                } else {
                    shape2 = shape;
                }
                if ((i & 12582912) != 0) {
                    i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(navigationDrawerItemColors)) ? 4194304 : 8388608;
                }
                i8 = i2 & 256;
                if (i8 != 0) {
                    i3 |= 100663296;
                } else if ((i & 100663296) == 0) {
                    if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                        i9 = 67108864;
                    } else {
                        i9 = 33554432;
                    }
                    i3 |= i9;
                }
                if ((i3 & 38347923) != 38347922) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z2, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "1132@48619L5,1133@48696L8");
                    if ((i & 1) != 0) {
                        if (i11 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i4 != 0) {
                            function9 = null;
                        } else {
                            function9 = function5;
                        }
                        if (i6 != 0) {
                            function10 = null;
                        } else {
                            function10 = function6;
                        }
                        if ((i2 & 64) != 0) {
                            i3 &= -3670017;
                            value = ShapesKt.getValue(NavigationDrawerTokens.INSTANCE.getActiveIndicatorShape(), composerStartRestartGroup, 6);
                        } else {
                            value = shape2;
                        }
                        i10 = i3;
                        if ((i2 & 128) != 0) {
                            z4 = false;
                            z3 = true;
                            navigationDrawerItemColorsM3849colorsoq7We08 = NavigationDrawerItemDefaults.INSTANCE.m3849colorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, 255);
                            i3 = i10 & (-29360129);
                        } else {
                            z3 = true;
                            z4 = false;
                            navigationDrawerItemColorsM3849colorsoq7We08 = navigationDrawerItemColors;
                            i3 = i10;
                        }
                        if (i8 != 0) {
                            composerStartRestartGroup = composerStartRestartGroup;
                            mutableInteractionSource3 = null;
                        } else {
                            composerStartRestartGroup = composerStartRestartGroup;
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        navigationDrawerItemColors3 = navigationDrawerItemColorsM3849colorsoq7We08;
                        function5 = function9;
                        modifier4 = companion;
                        r2 = z3;
                    } else {
                        if (i11 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i4 != 0) {
                            function9 = null;
                        } else {
                            function9 = function5;
                        }
                        if (i6 != 0) {
                            function10 = null;
                        } else {
                            function10 = function6;
                        }
                        if ((i2 & 64) != 0) {
                            i3 &= -3670017;
                            value = ShapesKt.getValue(NavigationDrawerTokens.INSTANCE.getActiveIndicatorShape(), composerStartRestartGroup, 6);
                        } else {
                            value = shape2;
                        }
                        i10 = i3;
                        if ((i2 & 128) != 0) {
                            z4 = false;
                            z3 = true;
                            navigationDrawerItemColorsM3849colorsoq7We08 = NavigationDrawerItemDefaults.INSTANCE.m3849colorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, 255);
                            i3 = i10 & (-29360129);
                        } else {
                            z3 = true;
                            z4 = false;
                            navigationDrawerItemColorsM3849colorsoq7We08 = navigationDrawerItemColors;
                            i3 = i10;
                        }
                        if (i8 != 0) {
                            composerStartRestartGroup = composerStartRestartGroup;
                            mutableInteractionSource3 = null;
                        } else {
                            composerStartRestartGroup = composerStartRestartGroup;
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        navigationDrawerItemColors3 = navigationDrawerItemColorsM3849colorsoq7We08;
                        function5 = function9;
                        modifier4 = companion;
                        r2 = z3;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-583709666, i3, -1, "androidx.compose.material3.NavigationDrawerItem (NavigationDrawer.kt:1135)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1695745329, "CC(remember):NavigationDrawer.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new Function1() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda18
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return NavigationDrawerKt.NavigationDrawerItem$lambda$0$0((SemanticsPropertyReceiver) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    int i17 = i3 >> 3;
                    final NavigationDrawerItemColors navigationDrawerItemColors8 = navigationDrawerItemColors3;
                    final Function2 function19 = function5;
                    final Function2 function110 = function10;
                    Modifier modifier9 = modifier4;
                    Shape shape8 = value;
                    SurfaceKt.m4324Surfaced85dljk(z, function0, SizeKt.fillMaxWidth$default(SizeKt.m1254heightInVpY3zN4$default(SemanticsModifierKt.semantics$default(modifier4, z4, (Function1) objRememberedValue, r2, null), NavigationDrawerTokens.INSTANCE.m5560getActiveIndicatorHeightD9Ej5fM(), 0.0f, 2, null), 0.0f, r2, null), false, shape8, navigationDrawerItemColors3.containerColor(z, composerStartRestartGroup, (i17 & 14) | ((i3 >> 18) & 112)).getValue().m6824unboximpl(), 0L, 0.0f, 0.0f, (BorderStroke) null, mutableInteractionSource3, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(-1173018444, r2, new Function2() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda19
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return NavigationDrawerKt.NavigationDrawerItem$lambda$1(function19, navigationDrawerItemColors8, z, function110, function2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, (i17 & 126) | ((i3 >> 6) & 57344), ((i3 >> 24) & 14) | 48, 968);
                    composer2 = composerStartRestartGroup;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    shape3 = shape8;
                    mutableInteractionSource2 = mutableInteractionSource3;
                    navigationDrawerItemColors2 = navigationDrawerItemColors8;
                    modifier3 = modifier9;
                    function7 = function19;
                    function8 = function10;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    navigationDrawerItemColors2 = navigationDrawerItemColors;
                    modifier3 = modifier2;
                    function7 = function5;
                    function8 = function6;
                    shape3 = shape2;
                    mutableInteractionSource2 = mutableInteractionSource;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda20
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return NavigationDrawerKt.NavigationDrawerItem$lambda$2(function2, z, function0, modifier3, function7, function8, shape3, navigationDrawerItemColors2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            function6 = function4;
            if ((1572864 & i) == 0) {
                if ((i2 & 64) == 0) {
                    shape2 = shape;
                    if (composerStartRestartGroup.changed(shape2)) {
                    }
                    i3 |= i12;
                } else {
                    shape2 = shape;
                }
                i3 |= i12;
            } else {
                shape2 = shape;
            }
            if ((i & 12582912) != 0) {
                i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(navigationDrawerItemColors)) ? 4194304 : 8388608;
            }
            i8 = i2 & 256;
            if (i8 != 0) {
                i3 |= 100663296;
            } else if ((i & 100663296) == 0) {
                if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                    i9 = 67108864;
                } else {
                    i9 = 33554432;
                }
                i3 |= i9;
            }
            if ((i3 & 38347923) != 38347922) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z2, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "1132@48619L5,1133@48696L8");
                if ((i & 1) != 0) {
                    if (i11 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i4 != 0) {
                        function9 = null;
                    } else {
                        function9 = function5;
                    }
                    if (i6 != 0) {
                        function10 = null;
                    } else {
                        function10 = function6;
                    }
                    if ((i2 & 64) != 0) {
                        i3 &= -3670017;
                        value = ShapesKt.getValue(NavigationDrawerTokens.INSTANCE.getActiveIndicatorShape(), composerStartRestartGroup, 6);
                    } else {
                        value = shape2;
                    }
                    i10 = i3;
                    if ((i2 & 128) != 0) {
                        z4 = false;
                        z3 = true;
                        navigationDrawerItemColorsM3849colorsoq7We08 = NavigationDrawerItemDefaults.INSTANCE.m3849colorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, 255);
                        i3 = i10 & (-29360129);
                    } else {
                        z3 = true;
                        z4 = false;
                        navigationDrawerItemColorsM3849colorsoq7We08 = navigationDrawerItemColors;
                        i3 = i10;
                    }
                    if (i8 != 0) {
                        composerStartRestartGroup = composerStartRestartGroup;
                        mutableInteractionSource3 = null;
                    } else {
                        composerStartRestartGroup = composerStartRestartGroup;
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    navigationDrawerItemColors3 = navigationDrawerItemColorsM3849colorsoq7We08;
                    function5 = function9;
                    modifier4 = companion;
                    r2 = z3;
                } else {
                    if (i11 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i4 != 0) {
                        function9 = null;
                    } else {
                        function9 = function5;
                    }
                    if (i6 != 0) {
                        function10 = null;
                    } else {
                        function10 = function6;
                    }
                    if ((i2 & 64) != 0) {
                        i3 &= -3670017;
                        value = ShapesKt.getValue(NavigationDrawerTokens.INSTANCE.getActiveIndicatorShape(), composerStartRestartGroup, 6);
                    } else {
                        value = shape2;
                    }
                    i10 = i3;
                    if ((i2 & 128) != 0) {
                        z4 = false;
                        z3 = true;
                        navigationDrawerItemColorsM3849colorsoq7We08 = NavigationDrawerItemDefaults.INSTANCE.m3849colorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, 255);
                        i3 = i10 & (-29360129);
                    } else {
                        z3 = true;
                        z4 = false;
                        navigationDrawerItemColorsM3849colorsoq7We08 = navigationDrawerItemColors;
                        i3 = i10;
                    }
                    if (i8 != 0) {
                        composerStartRestartGroup = composerStartRestartGroup;
                        mutableInteractionSource3 = null;
                    } else {
                        composerStartRestartGroup = composerStartRestartGroup;
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    navigationDrawerItemColors3 = navigationDrawerItemColorsM3849colorsoq7We08;
                    function5 = function9;
                    modifier4 = companion;
                    r2 = z3;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-583709666, i3, -1, "androidx.compose.material3.NavigationDrawerItem (NavigationDrawer.kt:1135)");
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1695745329, "CC(remember):NavigationDrawer.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function1() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda18
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return NavigationDrawerKt.NavigationDrawerItem$lambda$0$0((SemanticsPropertyReceiver) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                int i18 = i3 >> 3;
                final NavigationDrawerItemColors navigationDrawerItemColors9 = navigationDrawerItemColors3;
                final Function2 function111 = function5;
                final Function2 function112 = function10;
                Modifier modifier10 = modifier4;
                Shape shape9 = value;
                SurfaceKt.m4324Surfaced85dljk(z, function0, SizeKt.fillMaxWidth$default(SizeKt.m1254heightInVpY3zN4$default(SemanticsModifierKt.semantics$default(modifier4, z4, (Function1) objRememberedValue, r2, null), NavigationDrawerTokens.INSTANCE.m5560getActiveIndicatorHeightD9Ej5fM(), 0.0f, 2, null), 0.0f, r2, null), false, shape9, navigationDrawerItemColors3.containerColor(z, composerStartRestartGroup, (i18 & 14) | ((i3 >> 18) & 112)).getValue().m6824unboximpl(), 0L, 0.0f, 0.0f, (BorderStroke) null, mutableInteractionSource3, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(-1173018444, r2, new Function2() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda19
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return NavigationDrawerKt.NavigationDrawerItem$lambda$1(function111, navigationDrawerItemColors9, z, function112, function2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, (i18 & 126) | ((i3 >> 6) & 57344), ((i3 >> 24) & 14) | 48, 968);
                composer2 = composerStartRestartGroup;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                shape3 = shape9;
                mutableInteractionSource2 = mutableInteractionSource3;
                navigationDrawerItemColors2 = navigationDrawerItemColors9;
                modifier3 = modifier10;
                function7 = function111;
                function8 = function10;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                navigationDrawerItemColors2 = navigationDrawerItemColors;
                modifier3 = modifier2;
                function7 = function5;
                function8 = function6;
                shape3 = shape2;
                mutableInteractionSource2 = mutableInteractionSource;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda20
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return NavigationDrawerKt.NavigationDrawerItem$lambda$2(function2, z, function0, modifier3, function7, function8, shape3, navigationDrawerItemColors2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 24576;
        function5 = function3;
        i6 = i2 & 32;
        if (i6 != 0) {
            if ((196608 & i) == 0) {
                function6 = function4;
                if (composerStartRestartGroup.changedInstance(function6)) {
                    i7 = 131072;
                } else {
                    i7 = 65536;
                }
                i3 |= i7;
            }
            if ((1572864 & i) == 0) {
                if ((i2 & 64) == 0) {
                    shape2 = shape;
                    if (composerStartRestartGroup.changed(shape2)) {
                    }
                    i3 |= i12;
                } else {
                    shape2 = shape;
                }
                i3 |= i12;
            } else {
                shape2 = shape;
            }
            if ((i & 12582912) != 0) {
                i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(navigationDrawerItemColors)) ? 4194304 : 8388608;
            }
            i8 = i2 & 256;
            if (i8 != 0) {
                i3 |= 100663296;
            } else if ((i & 100663296) == 0) {
                if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                    i9 = 67108864;
                } else {
                    i9 = 33554432;
                }
                i3 |= i9;
            }
            if ((i3 & 38347923) != 38347922) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z2, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "1132@48619L5,1133@48696L8");
                if ((i & 1) != 0) {
                    if (i11 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i4 != 0) {
                        function9 = null;
                    } else {
                        function9 = function5;
                    }
                    if (i6 != 0) {
                        function10 = null;
                    } else {
                        function10 = function6;
                    }
                    if ((i2 & 64) != 0) {
                        i3 &= -3670017;
                        value = ShapesKt.getValue(NavigationDrawerTokens.INSTANCE.getActiveIndicatorShape(), composerStartRestartGroup, 6);
                    } else {
                        value = shape2;
                    }
                    i10 = i3;
                    if ((i2 & 128) != 0) {
                        z4 = false;
                        z3 = true;
                        navigationDrawerItemColorsM3849colorsoq7We08 = NavigationDrawerItemDefaults.INSTANCE.m3849colorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, 255);
                        i3 = i10 & (-29360129);
                    } else {
                        z3 = true;
                        z4 = false;
                        navigationDrawerItemColorsM3849colorsoq7We08 = navigationDrawerItemColors;
                        i3 = i10;
                    }
                    if (i8 != 0) {
                        composerStartRestartGroup = composerStartRestartGroup;
                        mutableInteractionSource3 = null;
                    } else {
                        composerStartRestartGroup = composerStartRestartGroup;
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    navigationDrawerItemColors3 = navigationDrawerItemColorsM3849colorsoq7We08;
                    function5 = function9;
                    modifier4 = companion;
                    r2 = z3;
                } else {
                    if (i11 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i4 != 0) {
                        function9 = null;
                    } else {
                        function9 = function5;
                    }
                    if (i6 != 0) {
                        function10 = null;
                    } else {
                        function10 = function6;
                    }
                    if ((i2 & 64) != 0) {
                        i3 &= -3670017;
                        value = ShapesKt.getValue(NavigationDrawerTokens.INSTANCE.getActiveIndicatorShape(), composerStartRestartGroup, 6);
                    } else {
                        value = shape2;
                    }
                    i10 = i3;
                    if ((i2 & 128) != 0) {
                        z4 = false;
                        z3 = true;
                        navigationDrawerItemColorsM3849colorsoq7We08 = NavigationDrawerItemDefaults.INSTANCE.m3849colorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, 255);
                        i3 = i10 & (-29360129);
                    } else {
                        z3 = true;
                        z4 = false;
                        navigationDrawerItemColorsM3849colorsoq7We08 = navigationDrawerItemColors;
                        i3 = i10;
                    }
                    if (i8 != 0) {
                        composerStartRestartGroup = composerStartRestartGroup;
                        mutableInteractionSource3 = null;
                    } else {
                        composerStartRestartGroup = composerStartRestartGroup;
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    navigationDrawerItemColors3 = navigationDrawerItemColorsM3849colorsoq7We08;
                    function5 = function9;
                    modifier4 = companion;
                    r2 = z3;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-583709666, i3, -1, "androidx.compose.material3.NavigationDrawerItem (NavigationDrawer.kt:1135)");
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1695745329, "CC(remember):NavigationDrawer.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function1() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda18
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return NavigationDrawerKt.NavigationDrawerItem$lambda$0$0((SemanticsPropertyReceiver) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                int i19 = i3 >> 3;
                final NavigationDrawerItemColors navigationDrawerItemColors10 = navigationDrawerItemColors3;
                final Function2 function113 = function5;
                final Function2 function114 = function10;
                Modifier modifier11 = modifier4;
                Shape shape10 = value;
                SurfaceKt.m4324Surfaced85dljk(z, function0, SizeKt.fillMaxWidth$default(SizeKt.m1254heightInVpY3zN4$default(SemanticsModifierKt.semantics$default(modifier4, z4, (Function1) objRememberedValue, r2, null), NavigationDrawerTokens.INSTANCE.m5560getActiveIndicatorHeightD9Ej5fM(), 0.0f, 2, null), 0.0f, r2, null), false, shape10, navigationDrawerItemColors3.containerColor(z, composerStartRestartGroup, (i19 & 14) | ((i3 >> 18) & 112)).getValue().m6824unboximpl(), 0L, 0.0f, 0.0f, (BorderStroke) null, mutableInteractionSource3, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(-1173018444, r2, new Function2() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda19
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return NavigationDrawerKt.NavigationDrawerItem$lambda$1(function113, navigationDrawerItemColors10, z, function114, function2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, (i19 & 126) | ((i3 >> 6) & 57344), ((i3 >> 24) & 14) | 48, 968);
                composer2 = composerStartRestartGroup;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                shape3 = shape10;
                mutableInteractionSource2 = mutableInteractionSource3;
                navigationDrawerItemColors2 = navigationDrawerItemColors10;
                modifier3 = modifier11;
                function7 = function113;
                function8 = function10;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                navigationDrawerItemColors2 = navigationDrawerItemColors;
                modifier3 = modifier2;
                function7 = function5;
                function8 = function6;
                shape3 = shape2;
                mutableInteractionSource2 = mutableInteractionSource;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda20
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return NavigationDrawerKt.NavigationDrawerItem$lambda$2(function2, z, function0, modifier3, function7, function8, shape3, navigationDrawerItemColors2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        function6 = function4;
        if ((1572864 & i) == 0) {
            if ((i2 & 64) == 0) {
                shape2 = shape;
                if (composerStartRestartGroup.changed(shape2)) {
                }
                i3 |= i12;
            } else {
                shape2 = shape;
            }
            i3 |= i12;
        } else {
            shape2 = shape;
        }
        if ((i & 12582912) != 0) {
            i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(navigationDrawerItemColors)) ? 4194304 : 8388608;
        }
        i8 = i2 & 256;
        if (i8 != 0) {
            i3 |= 100663296;
        } else if ((i & 100663296) == 0) {
            if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                i9 = 67108864;
            } else {
                i9 = 33554432;
            }
            i3 |= i9;
        }
        if ((i3 & 38347923) != 38347922) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z2, i3 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "1132@48619L5,1133@48696L8");
            if ((i & 1) != 0) {
                if (i11 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i4 != 0) {
                    function9 = null;
                } else {
                    function9 = function5;
                }
                if (i6 != 0) {
                    function10 = null;
                } else {
                    function10 = function6;
                }
                if ((i2 & 64) != 0) {
                    i3 &= -3670017;
                    value = ShapesKt.getValue(NavigationDrawerTokens.INSTANCE.getActiveIndicatorShape(), composerStartRestartGroup, 6);
                } else {
                    value = shape2;
                }
                i10 = i3;
                if ((i2 & 128) != 0) {
                    z4 = false;
                    z3 = true;
                    navigationDrawerItemColorsM3849colorsoq7We08 = NavigationDrawerItemDefaults.INSTANCE.m3849colorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, 255);
                    i3 = i10 & (-29360129);
                } else {
                    z3 = true;
                    z4 = false;
                    navigationDrawerItemColorsM3849colorsoq7We08 = navigationDrawerItemColors;
                    i3 = i10;
                }
                if (i8 != 0) {
                    composerStartRestartGroup = composerStartRestartGroup;
                    mutableInteractionSource3 = null;
                } else {
                    composerStartRestartGroup = composerStartRestartGroup;
                    mutableInteractionSource3 = mutableInteractionSource;
                }
                navigationDrawerItemColors3 = navigationDrawerItemColorsM3849colorsoq7We08;
                function5 = function9;
                modifier4 = companion;
                r2 = z3;
            } else {
                if (i11 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i4 != 0) {
                    function9 = null;
                } else {
                    function9 = function5;
                }
                if (i6 != 0) {
                    function10 = null;
                } else {
                    function10 = function6;
                }
                if ((i2 & 64) != 0) {
                    i3 &= -3670017;
                    value = ShapesKt.getValue(NavigationDrawerTokens.INSTANCE.getActiveIndicatorShape(), composerStartRestartGroup, 6);
                } else {
                    value = shape2;
                }
                i10 = i3;
                if ((i2 & 128) != 0) {
                    z4 = false;
                    z3 = true;
                    navigationDrawerItemColorsM3849colorsoq7We08 = NavigationDrawerItemDefaults.INSTANCE.m3849colorsoq7We08(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 100663296, 255);
                    i3 = i10 & (-29360129);
                } else {
                    z3 = true;
                    z4 = false;
                    navigationDrawerItemColorsM3849colorsoq7We08 = navigationDrawerItemColors;
                    i3 = i10;
                }
                if (i8 != 0) {
                    composerStartRestartGroup = composerStartRestartGroup;
                    mutableInteractionSource3 = null;
                } else {
                    composerStartRestartGroup = composerStartRestartGroup;
                    mutableInteractionSource3 = mutableInteractionSource;
                }
                navigationDrawerItemColors3 = navigationDrawerItemColorsM3849colorsoq7We08;
                function5 = function9;
                modifier4 = companion;
                r2 = z3;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-583709666, i3, -1, "androidx.compose.material3.NavigationDrawerItem (NavigationDrawer.kt:1135)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1695745329, "CC(remember):NavigationDrawer.kt#9igjgp");
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda18
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return NavigationDrawerKt.NavigationDrawerItem$lambda$0$0((SemanticsPropertyReceiver) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            int i110 = i3 >> 3;
            final NavigationDrawerItemColors navigationDrawerItemColors11 = navigationDrawerItemColors3;
            final Function2 function115 = function5;
            final Function2 function116 = function10;
            Modifier modifier12 = modifier4;
            Shape shape11 = value;
            SurfaceKt.m4324Surfaced85dljk(z, function0, SizeKt.fillMaxWidth$default(SizeKt.m1254heightInVpY3zN4$default(SemanticsModifierKt.semantics$default(modifier4, z4, (Function1) objRememberedValue, r2, null), NavigationDrawerTokens.INSTANCE.m5560getActiveIndicatorHeightD9Ej5fM(), 0.0f, 2, null), 0.0f, r2, null), false, shape11, navigationDrawerItemColors3.containerColor(z, composerStartRestartGroup, (i110 & 14) | ((i3 >> 18) & 112)).getValue().m6824unboximpl(), 0L, 0.0f, 0.0f, (BorderStroke) null, mutableInteractionSource3, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(-1173018444, r2, new Function2() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda19
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return NavigationDrawerKt.NavigationDrawerItem$lambda$1(function115, navigationDrawerItemColors11, z, function116, function2, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, (i110 & 126) | ((i3 >> 6) & 57344), ((i3 >> 24) & 14) | 48, 968);
            composer2 = composerStartRestartGroup;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            shape3 = shape11;
            mutableInteractionSource2 = mutableInteractionSource3;
            navigationDrawerItemColors2 = navigationDrawerItemColors11;
            modifier3 = modifier12;
            function7 = function115;
            function8 = function10;
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            navigationDrawerItemColors2 = navigationDrawerItemColors;
            modifier3 = modifier2;
            function7 = function5;
            function8 = function6;
            shape3 = shape2;
            mutableInteractionSource2 = mutableInteractionSource;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda20
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return NavigationDrawerKt.NavigationDrawerItem$lambda$2(function2, z, function0, modifier3, function7, function8, shape3, navigationDrawerItemColors2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NavigationDrawerItem$lambda$0$0(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.m8851setRolekuIjeqM(semanticsPropertyReceiver, Role.INSTANCE.m8839getTabo7Vup1c());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NavigationDrawerItem$lambda$1(Function2 function2, NavigationDrawerItemColors navigationDrawerItemColors, boolean z, Function2 function3, Function2 function4, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C1148@49175L869:NavigationDrawer.kt#uh7d8r");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1173018444, i, -1, "androidx.compose.material3.NavigationDrawerItem.<anonymous> (NavigationDrawer.kt:1148)");
            }
            Modifier modifierM1222paddingqDBjuR0$default = PaddingKt.m1222paddingqDBjuR0$default(Modifier.INSTANCE, Dp.m9687constructorimpl(16), 0.0f, Dp.m9687constructorimpl(24), 0.0f, 10, null);
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(composer, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, composer, 48);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierM1222paddingqDBjuR0$default);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor);
            } else {
                composer.useNode();
            }
            Composer composerM6062constructorimpl = Updater.m6062constructorimpl(composer);
            Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM6062constructorimpl.getInserting() || !Intrinsics.areEqual(composerM6062constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, -407735110, "C101@5232L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, -2013922645, "C1157@49574L203:NavigationDrawer.kt#uh7d8r");
            if (function2 == null) {
                composer.startReplaceGroup(-2062873134);
            } else {
                composer.startReplaceGroup(-2013920011);
                ComposerKt.sourceInformation(composer, "1153@49381L19,1154@49423L78,1155@49518L29");
                CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m6804boximpl(navigationDrawerItemColors.iconColor(z, composer, 0).getValue().m6824unboximpl())), (Function2<? super Composer, ? super Integer, Unit>) function2, composer, ProvidedValue.$stable);
                SpacerKt.Spacer(SizeKt.m1271width3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(12)), composer, 6);
            }
            composer.endReplaceGroup();
            Modifier modifierWeight$default = RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null);
            ComposerKt.sourceInformationMarkerStart(composer, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer, modifierWeight$default);
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor2);
            } else {
                composer.useNode();
            }
            Composer composerM6062constructorimpl2 = Updater.m6062constructorimpl(composer);
            Updater.m6070setimpl(composerM6062constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM6062constructorimpl2.getInserting() || !Intrinsics.areEqual(composerM6062constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                composerM6062constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                composerM6062constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.m6070setimpl(composerM6062constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, -1767721817, "C1158@49641L19,1159@49683L80:NavigationDrawer.kt#uh7d8r");
            CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m6804boximpl(navigationDrawerItemColors.textColor(z, composer, 0).getValue().m6824unboximpl())), (Function2<? super Composer, ? super Integer, Unit>) function4, composer, ProvidedValue.$stable);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            if (function3 != null) {
                composer.startReplaceGroup(-2013454639);
                ComposerKt.sourceInformation(composer, "1162@49827L29,1163@49897L20,1164@49940L80");
                SpacerKt.Spacer(SizeKt.m1271width3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(12)), composer, 6);
                CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m6804boximpl(navigationDrawerItemColors.badgeColor(z, composer, 0).getValue().m6824unboximpl())), (Function2<? super Composer, ? super Integer, Unit>) function3, composer, ProvidedValue.$stable);
            } else {
                composer.startReplaceGroup(-2062873134);
            }
            composer.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float calculateFraction(float f, float f2, float f3) {
        return RangesKt.coerceIn((f3 - f) / (f2 - f), 0.0f, 1.0f);
    }

    /* JADX INFO: renamed from: Scrim-Bx497Mc, reason: not valid java name */
    private static final void m3870ScrimBx497Mc(final boolean z, final Function0<Unit> function0, final Function0<Float> function1, final long j, Composer composer, final int i) {
        int i2;
        Modifier.Companion companionSemantics;
        Composer composerStartRestartGroup = composer.startRestartGroup(2106487387);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Scrim)N(open,onClose,fraction,color:c#ui.graphics.Color)1343@56877L30,1358@57375L39,1358@57324L90:NavigationDrawer.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function0) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function1) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changed(j) ? 2048 : 1024;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 1171) != 1170, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2106487387, i2, -1, "androidx.compose.material3.Scrim (NavigationDrawer.kt:1342)");
            }
            Strings.Companion companion = Strings.INSTANCE;
            final String strM5086getString2EP1pXo = Strings_androidKt.m5086getString2EP1pXo(Strings.m5002constructorimpl(androidx.compose.ui.R.string.close_drawer), composerStartRestartGroup, 0);
            if (z) {
                composerStartRestartGroup.startReplaceGroup(598773053);
                ComposerKt.sourceInformation(composerStartRestartGroup, "1346@56995L35,1347@57083L187");
                Modifier.Companion companion2 = Modifier.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1404789726, "CC(remember):NavigationDrawer.kt#9igjgp");
                int i3 = i2 & 112;
                boolean z2 = i3 == 32;
                NavigationDrawerKt$Scrim$dismissDrawer$1$1 navigationDrawerKt$Scrim$dismissDrawer$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (z2 || navigationDrawerKt$Scrim$dismissDrawer$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                    navigationDrawerKt$Scrim$dismissDrawer$1$1RememberedValue = new NavigationDrawerKt$Scrim$dismissDrawer$1$1(function0);
                    composerStartRestartGroup.updateRememberedValue(navigationDrawerKt$Scrim$dismissDrawer$1$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifierPointerInput = SuspendingPointerInputFilterKt.pointerInput(companion2, function0, (PointerInputEventHandler) navigationDrawerKt$Scrim$dismissDrawer$1$1RememberedValue);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1404792694, "CC(remember):NavigationDrawer.kt#9igjgp");
                boolean zChanged = (i3 == 32) | composerStartRestartGroup.changed(strM5086getString2EP1pXo);
                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function1() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda32
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return NavigationDrawerKt.Scrim_Bx497Mc$lambda$1$0(strM5086getString2EP1pXo, function0, (SemanticsPropertyReceiver) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                companionSemantics = SemanticsModifierKt.semantics(modifierPointerInput, true, (Function1) objRememberedValue);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(599097127);
                composerStartRestartGroup.endReplaceGroup();
                companionSemantics = Modifier.INSTANCE;
            }
            Modifier modifierThen = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null).then(companionSemantics);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1404801890, "CC(remember):NavigationDrawer.kt#9igjgp");
            boolean z3 = ((i2 & 7168) == 2048) | ((i2 & 896) == 256);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (z3 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function1() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda33
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return NavigationDrawerKt.Scrim_Bx497Mc$lambda$2$0(j, function1, (DrawScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            CanvasKt.Canvas(modifierThen, (Function1) objRememberedValue2, composerStartRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda34
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return NavigationDrawerKt.Scrim_Bx497Mc$lambda$3(z, function0, function1, j, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Scrim_Bx497Mc$lambda$1$0(String str, final Function0 function0, SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.setContentDescription(semanticsPropertyReceiver, str);
        SemanticsPropertiesKt.onClick$default(semanticsPropertyReceiver, null, new Function0() { // from class: androidx.compose.material3.NavigationDrawerKt$$ExternalSyntheticLambda23
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(NavigationDrawerKt.Scrim_Bx497Mc$lambda$1$0$0(function0));
            }
        }, 1, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean Scrim_Bx497Mc$lambda$1$0$0(Function0 function0) {
        function0.invoke();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Scrim_Bx497Mc$lambda$2$0(long j, Function0 function0, DrawScope drawScope) {
        DrawScope.m7389drawRectnJ9OG0$default(drawScope, j, 0L, 0L, ((Number) function0.invoke()).floatValue(), null, null, 0, 118, null);
        return Unit.INSTANCE;
    }

    public static final float getPredictiveBackDrawerMaxScaleXDistanceGrow() {
        return PredictiveBackDrawerMaxScaleXDistanceGrow;
    }

    public static final float getPredictiveBackDrawerMaxScaleXDistanceShrink() {
        return PredictiveBackDrawerMaxScaleXDistanceShrink;
    }

    public static final float getPredictiveBackDrawerMaxScaleYDistance() {
        return PredictiveBackDrawerMaxScaleYDistance;
    }
}
