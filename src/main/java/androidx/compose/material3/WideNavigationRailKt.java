package androidx.compose.material3;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.gestures.AnchoredDraggableDefaults;
import androidx.compose.foundation.gestures.AnchoredDraggableKt;
import androidx.compose.foundation.gestures.AnchoredDraggableState;
import androidx.compose.foundation.gestures.DraggableAnchorsConfig;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.TargetedFlingBehavior;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
import androidx.compose.foundation.selection.SelectableGroupKt;
import androidx.compose.material3.internal.DraggableAnchorsKt;
import androidx.compose.material3.internal.Strings;
import androidx.compose.material3.internal.Strings_androidKt;
import androidx.compose.material3.tokens.MotionSchemeKeyTokens;
import androidx.compose.material3.tokens.NavigationRailBaselineItemTokens;
import androidx.compose.material3.tokens.NavigationRailCollapsedTokens;
import androidx.compose.material3.tokens.NavigationRailExpandedTokens;
import androidx.compose.material3.tokens.NavigationRailHorizontalItemTokens;
import androidx.compose.material3.tokens.NavigationRailVerticalItemTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.TransformOriginKt;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.util.MathHelpersKt;
import androidx.media3.common.C;
import androidx.profileinstaller.ProfileVerifier;
import com.box.android.domain.analytics.BoxAnalyticsParams;
import com.box.android.domain.metrics.hubs.HubsObservability;
import com.facebook.react.uimanager.ViewProps;
import external.sdk.pendo.io.mozilla.javascript.Token;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: WideNavigationRail.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000¼\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\u001as\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0015\b\u0002\u0010\n\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b¢\u0006\u0002\b\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u0011\u0010\u0011\u001a\r\u0012\u0004\u0012\u00020\u00010\u000b¢\u0006\u0002\b\fH\u0007¢\u0006\u0002\u0010\u0012\u001am\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00072\u0013\u0010\n\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b¢\u0006\u0002\b\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0011\u0010\u0011\u001a\r\u0012\u0004\u0012\u00020\u00010\u000b¢\u0006\u0002\b\fH\u0003¢\u0006\u0002\u0010\u0017\u001a\u009d\u0001\u0010\u0018\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0019\u001a\u00020\u00152\b\b\u0002\u0010\u001a\u001a\u00020\u00072\b\b\u0002\u0010\u001b\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0015\b\u0002\u0010\n\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b¢\u0006\u0002\b\f2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\u0011\u0010\u0011\u001a\r\u0012\u0004\u0012\u00020\u00010\u000b¢\u0006\u0002\b\fH\u0007¢\u0006\u0004\b \u0010!\u001a\u0089\u0001\u0010\"\u001a\u00020\u00012\u0006\u0010#\u001a\u00020\u00152\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00010\u000b2\u0011\u0010%\u001a\r\u0012\u0004\u0012\u00020\u00010\u000b¢\u0006\u0002\b\f2\u0013\u0010&\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b¢\u0006\u0002\b\f2\u0006\u0010'\u001a\u00020\u00152\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010(\u001a\u00020\u00152\b\b\u0002\u0010)\u001a\u00020*2\b\b\u0002\u0010\b\u001a\u00020+2\n\b\u0002\u0010,\u001a\u0004\u0018\u00010-H\u0007¢\u0006\u0004\b.\u0010/\u001a\u008b\u0001\u0010\"\u001a\u00020\u00012\u0006\u0010#\u001a\u00020\u00152\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00010\u000b2\u0011\u0010%\u001a\r\u0012\u0004\u0012\u00020\u00010\u000b¢\u0006\u0002\b\f2\u0013\u0010&\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b¢\u0006\u0002\b\f2\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010(\u001a\u00020\u00152\b\b\u0002\u0010'\u001a\u00020\u00152\b\b\u0002\u0010)\u001a\u00020*2\b\b\u0002\u0010\b\u001a\u00020+2\n\b\u0002\u0010,\u001a\u0004\u0018\u00010-H\u0007¢\u0006\u0004\b.\u00100\u001aÁ\u0001\u00101\u001a\u00020\u00012\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u00102\u001a\u00020\u00152\u0012\u00103\u001a\u000e\u0012\u0004\u0012\u000205\u0012\u0004\u0012\u000206042\u0006\u00107\u001a\u0002082\u001c\u00109\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010;\u0012\u0006\u0012\u0004\u0018\u00010<0:2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010=\u001a\u00020>2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010?\u001a\u00020\u001d2\u0013\u0010\n\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b¢\u0006\u0002\b\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010@\u001a\u00020\u00152\u0006\u0010\u000f\u001a\u00020\u00102\u0011\u0010\u0011\u001a\r\u0012\u0004\u0012\u00020\u00010\u000b¢\u0006\u0002\b\fH\u0003¢\u0006\u0004\bA\u0010B\u001a\u001c\u0010C\u001a\u000205*\u00020D2\u0006\u0010E\u001a\u0002052\u0006\u0010F\u001a\u00020\u0015H\u0002\u001a\u0014\u0010G\u001a\u000205*\u00020D2\u0006\u0010E\u001a\u000205H\u0002\u001a=\u0010H\u001a\u00020\u00012\u0006\u0010I\u001a\u00020J2\u001c\u0010K\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010;\u0012\u0006\u0012\u0004\u0018\u00010<0:2\u0006\u0010L\u001a\u00020\u0015H\u0003¢\u0006\u0004\bM\u0010N\"\u0016\u0010O\u001a\u00020\u001dX\u0080\u0004¢\u0006\n\n\u0002\u0010R\u001a\u0004\bP\u0010Q\"\u0010\u0010S\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0004\n\u0002\u0010R\"\u0010\u0010T\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0004\n\u0002\u0010R\"\u0010\u0010U\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0004\n\u0002\u0010R\"\u0010\u0010V\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0004\n\u0002\u0010R\"\u0010\u0010W\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0004\n\u0002\u0010R\"\u0010\u0010X\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0004\n\u0002\u0010R\"\u0010\u0010Y\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0004\n\u0002\u0010R\"\u0010\u0010Z\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0004\n\u0002\u0010R\"\u0010\u0010[\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0004\n\u0002\u0010R\"\u0010\u0010\\\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0004\n\u0002\u0010R\"\u0010\u0010]\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0004\n\u0002\u0010R\"\u0010\u0010^\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0004\n\u0002\u0010R\"\u000e\u0010_\u001a\u000205X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010`\u001a\u00020aX\u0082T¢\u0006\u0002\n\u0000\"\"\u0010b\u001a\b\u0012\u0004\u0012\u00020d0c8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\be\u0010f\u001a\u0004\bg\u0010h\"\"\u0010i\u001a\b\u0012\u0004\u0012\u00020j0c8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bk\u0010f\u001a\u0004\bl\u0010h¨\u0006m²\u0006\n\u0010n\u001a\u00020oX\u008a\u008e\u0002²\u0006\n\u0010p\u001a\u00020oX\u008a\u008e\u0002²\u0006\n\u0010q\u001a\u00020\u001dX\u008a\u0084\u0002²\u0006\n\u0010r\u001a\u00020\u001dX\u008a\u0084\u0002²\u0006\n\u0010s\u001a\u00020\u001dX\u008a\u0084\u0002²\u0006\n\u0010t\u001a\u00020\u001dX\u008a\u0084\u0002²\u0006\n\u0010u\u001a\u000205X\u008a\u0084\u0002²\u0006\n\u0010v\u001a\u00020\u0015X\u008a\u008e\u0002"}, d2 = {"WideNavigationRail", "", "modifier", "Landroidx/compose/ui/Modifier;", "state", "Landroidx/compose/material3/WideNavigationRailState;", "shape", "Landroidx/compose/ui/graphics/Shape;", "colors", "Landroidx/compose/material3/WideNavigationRailColors;", "header", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "windowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "arrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "content", "(Landroidx/compose/ui/Modifier;Landroidx/compose/material3/WideNavigationRailState;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/WideNavigationRailColors;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/foundation/layout/Arrangement$Vertical;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "WideNavigationRailLayout", "isModal", "", "expanded", "(Landroidx/compose/ui/Modifier;ZZLandroidx/compose/material3/WideNavigationRailColors;Landroidx/compose/ui/graphics/Shape;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/foundation/layout/Arrangement$Vertical;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "ModalWideNavigationRail", "hideOnCollapse", "collapsedShape", "expandedShape", "expandedHeaderTopPadding", "Landroidx/compose/ui/unit/Dp;", "expandedProperties", "Landroidx/compose/material3/ModalWideNavigationRailProperties;", "ModalWideNavigationRail-k3FuEkE", "(Landroidx/compose/ui/Modifier;Landroidx/compose/material3/WideNavigationRailState;ZLandroidx/compose/ui/graphics/Shape;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/WideNavigationRailColors;Lkotlin/jvm/functions/Function2;FLandroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/material3/ModalWideNavigationRailProperties;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "WideNavigationRailItem", "selected", ViewProps.ON_CLICK, HubsObservability.HUB_ASSET_ICON, "label", "railExpanded", "enabled", "iconPosition", "Landroidx/compose/material3/NavigationItemIconPosition;", "Landroidx/compose/material3/NavigationItemColors;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "WideNavigationRailItem-pli-t6k", "(ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/Modifier;ZILandroidx/compose/material3/NavigationItemColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "(ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;ZZILandroidx/compose/material3/NavigationItemColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "ModalWideNavigationRailContent", "isStandaloneModal", "predictiveBackProgress", "Landroidx/compose/animation/core/Animatable;", "", "Landroidx/compose/animation/core/AnimationVector1D;", "predictiveBackState", "Landroidx/compose/material3/RailPredictiveBackState;", "modalAnimateToDismiss", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "railState", "Landroidx/compose/material3/ModalWideNavigationRailState;", "openModalRailMaxWidth", "gesturesEnabled", "ModalWideNavigationRailContent-pU6N4AM", "(ZZLandroidx/compose/animation/core/Animatable;Landroidx/compose/material3/RailPredictiveBackState;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/ModalWideNavigationRailState;Landroidx/compose/material3/WideNavigationRailColors;Landroidx/compose/ui/graphics/Shape;FLkotlin/jvm/functions/Function2;Landroidx/compose/foundation/layout/WindowInsets;ZLandroidx/compose/foundation/layout/Arrangement$Vertical;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "calculatePredictiveBackScaleX", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "progress", "swipeEdgeMatchesRail", "calculatePredictiveBackScaleY", "Scrim", "color", "Landroidx/compose/ui/graphics/Color;", "onDismissRequest", ViewProps.VISIBLE, "Scrim-3J-VO9M", "(JLkotlin/jvm/functions/Function1;ZLandroidx/compose/runtime/Composer;I)V", "WNRItemNoLabelIndicatorPadding", "getWNRItemNoLabelIndicatorPadding", "()F", "F", "ItemHorizontalPadding", "WNRVerticalPadding", "WNRHeaderPadding", "CollapsedRailWidth", "ExpandedRailMinWidth", "ExpandedRailMaxWidth", "TopIconItemMinHeight", "ItemTopIconIndicatorVerticalPadding", "ItemTopIconIndicatorHorizontalPadding", "ItemStartIconIndicatorVerticalPadding", "PredictiveBackMaxScaleXDistance", "PredictiveBackMaxScaleYDistance", "PredictiveBackPivotFractionY", "HeaderLayoutIdTag", "", "LocalWideNavigationRailOverride", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/compose/material3/WideNavigationRailOverride;", "getLocalWideNavigationRailOverride$annotations", "()V", "getLocalWideNavigationRailOverride", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "LocalModalWideNavigationRailOverride", "Landroidx/compose/material3/ModalWideNavigationRailOverride;", "getLocalModalWideNavigationRailOverride$annotations", "getLocalModalWideNavigationRailOverride", "material3", "currentWidth", "", "actualMaxExpandedWidth", ViewProps.MIN_WIDTH, "widthFullRange", "itemVerticalSpacedBy", "itemMinHeight", "alpha", BoxAnalyticsParams.ACTION_DISMISS}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class WideNavigationRailKt {
    private static final String HeaderLayoutIdTag = "header";
    private static final float ItemStartIconIndicatorVerticalPadding;
    private static final float ItemTopIconIndicatorHorizontalPadding;
    private static final float ItemTopIconIndicatorVerticalPadding;
    private static final float PredictiveBackPivotFractionY = 0.5f;
    private static final float WNRItemNoLabelIndicatorPadding;
    private static final float ItemHorizontalPadding = Dp.m9687constructorimpl(20);
    private static final float WNRVerticalPadding = NavigationRailCollapsedTokens.INSTANCE.m5577getTopSpaceD9Ej5fM();
    private static final float WNRHeaderPadding = NavigationRailBaselineItemTokens.INSTANCE.m5571getHeaderSpaceMinimumD9Ej5fM();
    private static final float CollapsedRailWidth = NavigationRailCollapsedTokens.INSTANCE.m5574getContainerWidthD9Ej5fM();
    private static final float ExpandedRailMinWidth = NavigationRailExpandedTokens.INSTANCE.m5580getContainerWidthMinimumD9Ej5fM();
    private static final float ExpandedRailMaxWidth = NavigationRailExpandedTokens.INSTANCE.m5579getContainerWidthMaximumD9Ej5fM();
    private static final float TopIconItemMinHeight = NavigationRailBaselineItemTokens.INSTANCE.m5569getContainerHeightD9Ej5fM();
    private static final float PredictiveBackMaxScaleXDistance = Dp.m9687constructorimpl(24);
    private static final float PredictiveBackMaxScaleYDistance = Dp.m9687constructorimpl(48);
    private static final ProvidableCompositionLocal<WideNavigationRailOverride> LocalWideNavigationRailOverride = CompositionLocalKt.compositionLocalOf$default(null, new Function0() { // from class: androidx.compose.material3.WideNavigationRailKt$$ExternalSyntheticLambda20
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return WideNavigationRailKt.LocalWideNavigationRailOverride$lambda$0();
        }
    }, 1, null);
    private static final ProvidableCompositionLocal<ModalWideNavigationRailOverride> LocalModalWideNavigationRailOverride = CompositionLocalKt.compositionLocalOf$default(null, new Function0() { // from class: androidx.compose.material3.WideNavigationRailKt$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return WideNavigationRailKt.LocalModalWideNavigationRailOverride$lambda$0();
        }
    }, 1, null);

    /* JADX INFO: Access modifiers changed from: private */
    public static final float ModalWideNavigationRailContent_pU6N4AM$lambda$0$0(float f) {
        return f * 0.5f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ModalWideNavigationRailContent_pU6N4AM$lambda$6(boolean z, boolean z2, Animatable animatable, RailPredictiveBackState railPredictiveBackState, Function1 function1, Modifier modifier, ModalWideNavigationRailState modalWideNavigationRailState, WideNavigationRailColors wideNavigationRailColors, Shape shape, float f, Function2 function2, WindowInsets windowInsets, boolean z3, Arrangement.Vertical vertical, Function2 function3, int i, int i2, Composer composer, int i3) {
        m4843ModalWideNavigationRailContentpU6N4AM(z, z2, animatable, railPredictiveBackState, function1, modifier, modalWideNavigationRailState, wideNavigationRailColors, shape, f, function2, windowInsets, z3, vertical, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ModalWideNavigationRail_k3FuEkE$lambda$1(Modifier modifier, WideNavigationRailState wideNavigationRailState, boolean z, Shape shape, Shape shape2, WideNavigationRailColors wideNavigationRailColors, Function2 function2, float f, WindowInsets windowInsets, Arrangement.Vertical vertical, ModalWideNavigationRailProperties modalWideNavigationRailProperties, Function2 function3, int i, int i2, int i3, Composer composer, int i4) {
        m4842ModalWideNavigationRailk3FuEkE(modifier, wideNavigationRailState, z, shape, shape2, wideNavigationRailColors, function2, f, windowInsets, vertical, modalWideNavigationRailProperties, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Scrim_3J_VO9M$lambda$8(long j, Function1 function1, boolean z, int i, Composer composer, int i2) {
        m4844Scrim3JVO9M(j, function1, z, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit WideNavigationRail$lambda$1(Modifier modifier, WideNavigationRailState wideNavigationRailState, Shape shape, WideNavigationRailColors wideNavigationRailColors, Function2 function2, WindowInsets windowInsets, Arrangement.Vertical vertical, Function2 function3, int i, int i2, Composer composer, int i3) {
        WideNavigationRail(modifier, wideNavigationRailState, shape, wideNavigationRailColors, function2, windowInsets, vertical, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit WideNavigationRailItem_pli_t6k$lambda$1(boolean z, Function0 function0, Function2 function2, Function2 function3, boolean z2, Modifier modifier, boolean z3, int i, NavigationItemColors navigationItemColors, MutableInteractionSource mutableInteractionSource, int i2, int i3, Composer composer, int i4) {
        m4846WideNavigationRailItemplit6k(z, (Function0<Unit>) function0, (Function2<? super Composer, ? super Integer, Unit>) function2, (Function2<? super Composer, ? super Integer, Unit>) function3, z2, modifier, z3, i, navigationItemColors, mutableInteractionSource, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit WideNavigationRailItem_pli_t6k$lambda$2(boolean z, Function0 function0, Function2 function2, Function2 function3, Modifier modifier, boolean z2, boolean z3, int i, NavigationItemColors navigationItemColors, MutableInteractionSource mutableInteractionSource, int i2, int i3, Composer composer, int i4) {
        m4845WideNavigationRailItemplit6k(z, function0, function2, function3, modifier, z2, z3, i, navigationItemColors, mutableInteractionSource, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit WideNavigationRailLayout$lambda$11(Modifier modifier, boolean z, boolean z2, WideNavigationRailColors wideNavigationRailColors, Shape shape, Function2 function2, WindowInsets windowInsets, Arrangement.Vertical vertical, Function2 function3, int i, Composer composer, int i2) {
        WideNavigationRailLayout(modifier, z, z2, wideNavigationRailColors, shape, function2, windowInsets, vertical, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static /* synthetic */ void getLocalModalWideNavigationRailOverride$annotations() {
    }

    public static /* synthetic */ void getLocalWideNavigationRailOverride$annotations() {
    }

    /* JADX WARN: Code duplicated, block: B:117:0x014d A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:118:0x014f  */
    /* JADX WARN: Code duplicated, block: B:119:0x0154  */
    /* JADX WARN: Code duplicated, block: B:122:0x015a  */
    /* JADX WARN: Code duplicated, block: B:125:0x0166  */
    /* JADX WARN: Code duplicated, block: B:128:0x0173  */
    /* JADX WARN: Code duplicated, block: B:130:0x017e  */
    /* JADX WARN: Code duplicated, block: B:133:0x0183  */
    /* JADX WARN: Code duplicated, block: B:136:0x0191  */
    /* JADX WARN: Code duplicated, block: B:137:0x01a6  */
    /* JADX WARN: Code duplicated, block: B:140:0x01b3  */
    /* JADX WARN: Code duplicated, block: B:143:0x01e0  */
    /* JADX WARN: Code duplicated, block: B:145:0x01f2  */
    /* JADX WARN: Code duplicated, block: B:148:0x0204  */
    /* JADX WARN: Code duplicated, block: B:150:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:23:0x004a  */
    /* JADX WARN: Code duplicated, block: B:60:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:62:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:64:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:65:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:68:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:71:0x00c0  */
    /* JADX WARN: Code duplicated, block: B:73:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:75:0x00cc  */
    /* JADX WARN: Code duplicated, block: B:76:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:79:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:82:0x00dc  */
    /* JADX WARN: Code duplicated, block: B:84:0x00e4  */
    /* JADX WARN: Code duplicated, block: B:85:0x00e7  */
    /* JADX WARN: Code duplicated, block: B:87:0x00eb  */
    /* JADX WARN: Code duplicated, block: B:90:0x00f7  */
    /* JADX WARN: Code duplicated, block: B:91:0x00f9  */
    /* JADX WARN: Code duplicated, block: B:94:0x0102  */
    public static final void WideNavigationRail(Modifier modifier, WideNavigationRailState wideNavigationRailState, Shape shape, WideNavigationRailColors wideNavigationRailColors, Function2<? super Composer, ? super Integer, Unit> function2, WindowInsets windowInsets, Arrangement.Vertical vertical, final Function2<? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        Shape shape2;
        WideNavigationRailColors wideNavigationRailColorsColors;
        Function2<? super Composer, ? super Integer, Unit> function4;
        WindowInsets windowInsets2;
        Arrangement.Vertical vertical2;
        Function2<? super Composer, ? super Integer, Unit> function5;
        boolean z;
        final WideNavigationRailState wideNavigationRailState2;
        Composer composer2;
        final Modifier modifier3;
        final Shape shape3;
        final WideNavigationRailColors wideNavigationRailColors2;
        final Function2<? super Composer, ? super Integer, Unit> function6;
        final WindowInsets windowInsets3;
        final Arrangement.Vertical vertical3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        WideNavigationRailState wideNavigationRailState3;
        Modifier modifier4;
        Arrangement.Vertical arrangement;
        Shape shape4;
        WideNavigationRailColors wideNavigationRailColors3;
        Function2<? super Composer, ? super Integer, Unit> function7;
        WindowInsets windowInsets4;
        int i4;
        int i5;
        WideNavigationRailState wideNavigationRailStateRememberWideNavigationRailState = wideNavigationRailState;
        Composer composerStartRestartGroup = composer.startRestartGroup(164193188);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(WideNavigationRail)N(modifier,state,shape,colors,header,windowInsets,arrangement,content)176@8813L7,*187@9180L20:WideNavigationRail.kt#uh7d8r");
        int i6 = i2 & 1;
        if (i6 != 0) {
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
            if ((i2 & 2) != 0) {
                i5 = 16;
            } else {
                if ((i & 64) == 0 ? composerStartRestartGroup.changed(wideNavigationRailStateRememberWideNavigationRailState) : composerStartRestartGroup.changedInstance(wideNavigationRailStateRememberWideNavigationRailState)) {
                    i5 = 32;
                } else {
                    i5 = 16;
                }
            }
            i3 |= i5;
        }
        if ((i & 384) == 0) {
            if ((i2 & 4) == 0) {
                shape2 = shape;
                int i7 = composerStartRestartGroup.changed(shape2) ? 256 : 128;
                i3 |= i7;
            } else {
                shape2 = shape;
            }
            i3 |= i7;
        } else {
            shape2 = shape;
        }
        if ((i & 3072) == 0) {
            if ((i2 & 8) == 0) {
                wideNavigationRailColorsColors = wideNavigationRailColors;
                int i8 = composerStartRestartGroup.changed(wideNavigationRailColorsColors) ? 2048 : 1024;
                i3 |= i8;
            } else {
                wideNavigationRailColorsColors = wideNavigationRailColors;
            }
            i3 |= i8;
        } else {
            wideNavigationRailColorsColors = wideNavigationRailColors;
        }
        int i9 = i2 & 16;
        if (i9 == 0) {
            if ((i & 24576) == 0) {
                function4 = function2;
                i3 |= composerStartRestartGroup.changedInstance(function4) ? 16384 : 8192;
            }
            if ((196608 & i) == 0) {
                if ((i2 & 32) == 0) {
                    windowInsets2 = windowInsets;
                    int i10 = composerStartRestartGroup.changed(windowInsets2) ? 131072 : 65536;
                    i3 |= i10;
                } else {
                    windowInsets2 = windowInsets;
                }
                i3 |= i10;
            } else {
                windowInsets2 = windowInsets;
            }
            if ((1572864 & i) == 0) {
                if ((i2 & 64) == 0) {
                    vertical2 = vertical;
                    int i11 = composerStartRestartGroup.changed(vertical2) ? 1048576 : 524288;
                    i3 |= i11;
                } else {
                    vertical2 = vertical;
                }
                i3 |= i11;
            } else {
                vertical2 = vertical;
            }
            if ((12582912 & i) == 0) {
                function5 = function3;
                if (composerStartRestartGroup.changedInstance(function5)) {
                    i4 = 8388608;
                } else {
                    i4 = 4194304;
                }
                i3 |= i4;
            } else {
                function5 = function3;
            }
            if ((4793491 & i3) != 4793490) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "168@8367L33,169@8448L5,170@8521L8,172@8637L12");
                if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                    if (i6 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if ((i2 & 2) != 0) {
                        wideNavigationRailStateRememberWideNavigationRailState = WideNavigationRailStateKt.rememberWideNavigationRailState(null, composerStartRestartGroup, 0, 1);
                        i3 &= -113;
                    }
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                        shape2 = WideNavigationRailDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                        wideNavigationRailColorsColors = WideNavigationRailDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                    }
                    if (i9 != 0) {
                        function4 = null;
                    }
                    if ((i2 & 32) != 0) {
                        windowInsets2 = WideNavigationRailDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                        i3 &= -458753;
                    }
                    if ((i2 & 64) != 0) {
                        i3 &= -3670017;
                        wideNavigationRailState3 = wideNavigationRailStateRememberWideNavigationRailState;
                        arrangement = WideNavigationRailDefaults.INSTANCE.getArrangement();
                        modifier4 = companion;
                        shape4 = shape2;
                        wideNavigationRailColors3 = wideNavigationRailColorsColors;
                        function7 = function4;
                        windowInsets4 = windowInsets2;
                    } else {
                        wideNavigationRailState3 = wideNavigationRailStateRememberWideNavigationRailState;
                        modifier4 = companion;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(164193188, i3, -1, "androidx.compose.material3.WideNavigationRail (WideNavigationRail.kt:175)");
                    }
                    ProvidableCompositionLocal<WideNavigationRailOverride> providableCompositionLocal = LocalWideNavigationRailOverride;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume = composerStartRestartGroup.consume(providableCompositionLocal);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ((WideNavigationRailOverride) objConsume).WideNavigationRail(new WideNavigationRailOverrideScope(modifier4, wideNavigationRailState3, shape4, wideNavigationRailColors3, function7, windowInsets4, arrangement, function5), composerStartRestartGroup, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    composer2 = composerStartRestartGroup;
                    modifier3 = modifier4;
                    wideNavigationRailState2 = wideNavigationRailState3;
                    shape3 = shape4;
                    wideNavigationRailColors2 = wideNavigationRailColors3;
                    function6 = function7;
                    windowInsets3 = windowInsets4;
                    vertical3 = arrangement;
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
                    if ((i2 & 64) != 0) {
                        i3 &= -3670017;
                    }
                    wideNavigationRailState3 = wideNavigationRailStateRememberWideNavigationRailState;
                    modifier4 = modifier2;
                }
                shape4 = shape2;
                wideNavigationRailColors3 = wideNavigationRailColorsColors;
                function7 = function4;
                windowInsets4 = windowInsets2;
                arrangement = vertical2;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(164193188, i3, -1, "androidx.compose.material3.WideNavigationRail (WideNavigationRail.kt:175)");
                }
                ProvidableCompositionLocal<WideNavigationRailOverride> providableCompositionLocal2 = LocalWideNavigationRailOverride;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume2 = composerStartRestartGroup.consume(providableCompositionLocal2);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ((WideNavigationRailOverride) objConsume2).WideNavigationRail(new WideNavigationRailOverrideScope(modifier4, wideNavigationRailState3, shape4, wideNavigationRailColors3, function7, windowInsets4, arrangement, function5), composerStartRestartGroup, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer2 = composerStartRestartGroup;
                modifier3 = modifier4;
                wideNavigationRailState2 = wideNavigationRailState3;
                shape3 = shape4;
                wideNavigationRailColors2 = wideNavigationRailColors3;
                function6 = function7;
                windowInsets3 = windowInsets4;
                vertical3 = arrangement;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                wideNavigationRailState2 = wideNavigationRailStateRememberWideNavigationRailState;
                composer2 = composerStartRestartGroup;
                modifier3 = modifier2;
                shape3 = shape2;
                wideNavigationRailColors2 = wideNavigationRailColorsColors;
                function6 = function4;
                windowInsets3 = windowInsets2;
                vertical3 = vertical2;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.WideNavigationRailKt$$ExternalSyntheticLambda18
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return WideNavigationRailKt.WideNavigationRail$lambda$1(modifier3, wideNavigationRailState2, shape3, wideNavigationRailColors2, function6, windowInsets3, vertical3, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 24576;
        function4 = function2;
        if ((196608 & i) == 0) {
            if ((i2 & 32) == 0) {
                windowInsets2 = windowInsets;
                if (composerStartRestartGroup.changed(windowInsets2)) {
                }
                i3 |= i10;
            } else {
                windowInsets2 = windowInsets;
            }
            i3 |= i10;
        } else {
            windowInsets2 = windowInsets;
        }
        if ((1572864 & i) == 0) {
            if ((i2 & 64) == 0) {
                vertical2 = vertical;
                if (composerStartRestartGroup.changed(vertical2)) {
                }
                i3 |= i11;
            } else {
                vertical2 = vertical;
            }
            i3 |= i11;
        } else {
            vertical2 = vertical;
        }
        if ((12582912 & i) == 0) {
            function5 = function3;
            if (composerStartRestartGroup.changedInstance(function5)) {
                i4 = 8388608;
            } else {
                i4 = 4194304;
            }
            i3 |= i4;
        } else {
            function5 = function3;
        }
        if ((4793491 & i3) != 4793490) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "168@8367L33,169@8448L5,170@8521L8,172@8637L12");
            if ((i & 1) != 0) {
                if (i6 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if ((i2 & 2) != 0) {
                    wideNavigationRailStateRememberWideNavigationRailState = WideNavigationRailStateKt.rememberWideNavigationRailState(null, composerStartRestartGroup, 0, 1);
                    i3 &= -113;
                }
                if ((i2 & 4) != 0) {
                    i3 &= -897;
                    shape2 = WideNavigationRailDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                }
                if ((i2 & 8) != 0) {
                    i3 &= -7169;
                    wideNavigationRailColorsColors = WideNavigationRailDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                }
                if (i9 != 0) {
                    function4 = null;
                }
                if ((i2 & 32) != 0) {
                    windowInsets2 = WideNavigationRailDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                    i3 &= -458753;
                }
                if ((i2 & 64) != 0) {
                    i3 &= -3670017;
                    wideNavigationRailState3 = wideNavigationRailStateRememberWideNavigationRailState;
                    arrangement = WideNavigationRailDefaults.INSTANCE.getArrangement();
                    modifier4 = companion;
                    shape4 = shape2;
                    wideNavigationRailColors3 = wideNavigationRailColorsColors;
                    function7 = function4;
                    windowInsets4 = windowInsets2;
                } else {
                    wideNavigationRailState3 = wideNavigationRailStateRememberWideNavigationRailState;
                    modifier4 = companion;
                    shape4 = shape2;
                    wideNavigationRailColors3 = wideNavigationRailColorsColors;
                    function7 = function4;
                    windowInsets4 = windowInsets2;
                    arrangement = vertical2;
                }
            } else {
                if (i6 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if ((i2 & 2) != 0) {
                    wideNavigationRailStateRememberWideNavigationRailState = WideNavigationRailStateKt.rememberWideNavigationRailState(null, composerStartRestartGroup, 0, 1);
                    i3 &= -113;
                }
                if ((i2 & 4) != 0) {
                    i3 &= -897;
                    shape2 = WideNavigationRailDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                }
                if ((i2 & 8) != 0) {
                    i3 &= -7169;
                    wideNavigationRailColorsColors = WideNavigationRailDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                }
                if (i9 != 0) {
                    function4 = null;
                }
                if ((i2 & 32) != 0) {
                    windowInsets2 = WideNavigationRailDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                    i3 &= -458753;
                }
                if ((i2 & 64) != 0) {
                    i3 &= -3670017;
                    wideNavigationRailState3 = wideNavigationRailStateRememberWideNavigationRailState;
                    arrangement = WideNavigationRailDefaults.INSTANCE.getArrangement();
                    modifier4 = companion;
                    shape4 = shape2;
                    wideNavigationRailColors3 = wideNavigationRailColorsColors;
                    function7 = function4;
                    windowInsets4 = windowInsets2;
                } else {
                    wideNavigationRailState3 = wideNavigationRailStateRememberWideNavigationRailState;
                    modifier4 = companion;
                    shape4 = shape2;
                    wideNavigationRailColors3 = wideNavigationRailColorsColors;
                    function7 = function4;
                    windowInsets4 = windowInsets2;
                    arrangement = vertical2;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(164193188, i3, -1, "androidx.compose.material3.WideNavigationRail (WideNavigationRail.kt:175)");
            }
            ProvidableCompositionLocal<WideNavigationRailOverride> providableCompositionLocal3 = LocalWideNavigationRailOverride;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume3 = composerStartRestartGroup.consume(providableCompositionLocal3);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ((WideNavigationRailOverride) objConsume3).WideNavigationRail(new WideNavigationRailOverrideScope(modifier4, wideNavigationRailState3, shape4, wideNavigationRailColors3, function7, windowInsets4, arrangement, function5), composerStartRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer2 = composerStartRestartGroup;
            modifier3 = modifier4;
            wideNavigationRailState2 = wideNavigationRailState3;
            shape3 = shape4;
            wideNavigationRailColors2 = wideNavigationRailColors3;
            function6 = function7;
            windowInsets3 = windowInsets4;
            vertical3 = arrangement;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            wideNavigationRailState2 = wideNavigationRailStateRememberWideNavigationRailState;
            composer2 = composerStartRestartGroup;
            modifier3 = modifier2;
            shape3 = shape2;
            wideNavigationRailColors2 = wideNavigationRailColorsColors;
            function6 = function4;
            windowInsets3 = windowInsets2;
            vertical3 = vertical2;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.WideNavigationRailKt$$ExternalSyntheticLambda18
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return WideNavigationRailKt.WideNavigationRail$lambda$1(modifier3, wideNavigationRailState2, shape3, wideNavigationRailColors2, function6, windowInsets3, vertical3, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void WideNavigationRailLayout(final Modifier modifier, final boolean z, final boolean z2, final WideNavigationRailColors wideNavigationRailColors, final Shape shape, final Function2<? super Composer, ? super Integer, Unit> function2, final WindowInsets windowInsets, final Arrangement.Vertical vertical, final Function2<? super Composer, ? super Integer, Unit> function3, Composer composer, final int i) {
        int i2;
        WideNavigationRailColors wideNavigationRailColors2;
        float fM9701unboximpl;
        float fM9687constructorimpl;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1004308036);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(WideNavigationRailLayout)N(modifier,isModal,expanded,colors,shape,header,windowInsets,arrangement,content)226@10292L33,227@10360L33,229@10469L7,236@10735L11,237@10810L11,239@10850L195,244@11080L195,249@11316L170,254@11520L154,264@11920L9209,259@11680L9449:WideNavigationRail.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(z) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changed(z2) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            wideNavigationRailColors2 = wideNavigationRailColors;
            i2 |= composerStartRestartGroup.changed(wideNavigationRailColors2) ? 2048 : 1024;
        } else {
            wideNavigationRailColors2 = wideNavigationRailColors;
        }
        if ((i & 24576) == 0) {
            i2 |= composerStartRestartGroup.changed(shape) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function2) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(windowInsets) ? 1048576 : 524288;
        }
        if ((i & 12582912) == 0) {
            i2 |= composerStartRestartGroup.changed(vertical) ? 8388608 : 4194304;
        }
        if ((100663296 & i) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function3) ? 67108864 : 33554432;
        }
        if (!composerStartRestartGroup.shouldExecute((38347923 & i2) != 38347922, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1004308036, i2, -1, "androidx.compose.material3.WideNavigationRailLayout (WideNavigationRail.kt:225)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1227629597, "CC(remember):WideNavigationRail.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = SnapshotIntStateKt.mutableIntStateOf(0);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            final MutableIntState mutableIntState = (MutableIntState) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1227631773, "CC(remember):WideNavigationRail.kt#9igjgp");
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = SnapshotIntStateKt.mutableIntStateOf(0);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            final MutableIntState mutableIntState2 = (MutableIntState) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ProvidableCompositionLocal<Dp> localMinimumInteractiveComponentSize = InteractiveComponentSizeKt.getLocalMinimumInteractiveComponentSize();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composerStartRestartGroup.consume(localMinimumInteractiveComponentSize);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (!Dp.m9692equalsimpl0(((Dp) objConsume).m9701unboximpl(), Dp.INSTANCE.m9707getUnspecifiedD9Ej5fM())) {
                composerStartRestartGroup.startReplaceGroup(-597950974);
                ComposerKt.sourceInformation(composerStartRestartGroup, "232@10581L7");
                ProvidableCompositionLocal<Dp> localMinimumInteractiveComponentSize2 = InteractiveComponentSizeKt.getLocalMinimumInteractiveComponentSize();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume2 = composerStartRestartGroup.consume(localMinimumInteractiveComponentSize2);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                fM9701unboximpl = ((Dp) objConsume2).m9701unboximpl();
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(-597985942);
                composerStartRestartGroup.endReplaceGroup();
                fM9701unboximpl = Dp.m9687constructorimpl(0);
            }
            final float f = fM9701unboximpl;
            FiniteAnimationSpec finiteAnimationSpecValue = MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultSpatial, composerStartRestartGroup, 6);
            FiniteAnimationSpec finiteAnimationSpecValue2 = MotionSchemeKt.value(MotionSchemeKeyTokens.FastSpatial, composerStartRestartGroup, 6);
            final State<Dp> stateM464animateDpAsStateAjpBEmI = AnimateAsStateKt.m464animateDpAsStateAjpBEmI(!z2 ? CollapsedRailWidth : ExpandedRailMinWidth, !z ? finiteAnimationSpecValue : finiteAnimationSpecValue2, null, null, composerStartRestartGroup, 0, 12);
            float f2 = !z2 ? CollapsedRailWidth : ExpandedRailMaxWidth;
            if (!z) {
                finiteAnimationSpecValue2 = finiteAnimationSpecValue;
            }
            final State<Dp> stateM464animateDpAsStateAjpBEmI2 = AnimateAsStateKt.m464animateDpAsStateAjpBEmI(f2, finiteAnimationSpecValue2, null, null, composerStartRestartGroup, 0, 12);
            if (!z2) {
                fM9687constructorimpl = NavigationRailCollapsedTokens.INSTANCE.m5575getItemVerticalSpaceD9Ej5fM();
            } else {
                fM9687constructorimpl = Dp.m9687constructorimpl(0);
            }
            FiniteAnimationSpec finiteAnimationSpec = finiteAnimationSpecValue;
            final State<Dp> stateM464animateDpAsStateAjpBEmI3 = AnimateAsStateKt.m464animateDpAsStateAjpBEmI(fM9687constructorimpl, finiteAnimationSpec, null, null, composerStartRestartGroup, 0, 12);
            final State<Dp> stateM464animateDpAsStateAjpBEmI4 = AnimateAsStateKt.m464animateDpAsStateAjpBEmI(!z2 ? TopIconItemMinHeight : f, finiteAnimationSpec, null, null, composerStartRestartGroup, 0, 12);
            int i3 = i2;
            SurfaceKt.m4323SurfaceT9BRK9s(modifier, shape, !z ? wideNavigationRailColors2.getContainerColor() : wideNavigationRailColors2.getModalContainerColor(), !z ? wideNavigationRailColors2.getContentColor() : wideNavigationRailColors2.getModalContentColor(), 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(-1489314345, true, new Function2() { // from class: androidx.compose.material3.WideNavigationRailKt$$ExternalSyntheticLambda15
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return WideNavigationRailKt.WideNavigationRailLayout$lambda$10(windowInsets, function2, z2, f, stateM464animateDpAsStateAjpBEmI, stateM464animateDpAsStateAjpBEmI4, stateM464animateDpAsStateAjpBEmI2, mutableIntState2, mutableIntState, vertical, stateM464animateDpAsStateAjpBEmI3, function3, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, (i3 & 14) | 12582912 | ((i3 >> 9) & 112), 112);
            composerStartRestartGroup = composerStartRestartGroup;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.WideNavigationRailKt$$ExternalSyntheticLambda16
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return WideNavigationRailKt.WideNavigationRailLayout$lambda$11(modifier, z, z2, wideNavigationRailColors, shape, function2, windowInsets, vertical, function3, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int WideNavigationRailLayout$lambda$1(MutableIntState mutableIntState) {
        return mutableIntState.getIntValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int WideNavigationRailLayout$lambda$4(MutableIntState mutableIntState) {
        return mutableIntState.getIntValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit WideNavigationRailLayout$lambda$10$0$0(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.setTraversalGroup(semanticsPropertyReceiver, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit WideNavigationRailLayout$lambda$10(WindowInsets windowInsets, Function2 function2, boolean z, float f, State state, State state2, State state3, MutableIntState mutableIntState, MutableIntState mutableIntState2, Arrangement.Vertical vertical, State state4, Function2 function3, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C272@12239L27,265@11930L9193:WideNavigationRail.kt#uh7d8r");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1489314345, i, -1, "androidx.compose.material3.WideNavigationRailLayout.<anonymous> (WideNavigationRail.kt:265)");
            }
            Modifier modifierSelectableGroup = SelectableGroupKt.selectableGroup(PaddingKt.m1222paddingqDBjuR0$default(SizeKt.m1273widthInVpY3zN4$default(WindowInsetsPaddingKt.windowInsetsPadding(SizeKt.fillMaxHeight$default(Modifier.INSTANCE, 0.0f, 1, null), windowInsets), 0.0f, ExpandedRailMaxWidth, 1, null), 0.0f, WNRVerticalPadding, 0.0f, 0.0f, 13, null));
            ComposerKt.sourceInformationMarkerStart(composer, -1006965742, "CC(remember):WideNavigationRail.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: androidx.compose.material3.WideNavigationRailKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return WideNavigationRailKt.WideNavigationRailLayout$lambda$10$0$0((SemanticsPropertyReceiver) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            Modifier modifierSemantics$default = SemanticsModifierKt.semantics$default(modifierSelectableGroup, false, (Function1) objRememberedValue, 1, null);
            WideNavigationRailKt$WideNavigationRailLayout$1$2 wideNavigationRailKt$WideNavigationRailLayout$1$2 = new WideNavigationRailKt$WideNavigationRailLayout$1$2(function2, z, f, state, state2, state3, mutableIntState, mutableIntState2, vertical, state4);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierSemantics$default);
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
            Updater.m6070setimpl(composerM6062constructorimpl, wideNavigationRailKt$WideNavigationRailLayout$1$2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM6062constructorimpl.getInserting() || !Intrinsics.areEqual(composerM6062constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 1714873591, "C277@12439L9:WideNavigationRail.kt#uh7d8r");
            if (function2 != null) {
                composer.startReplaceGroup(1714892004);
                ComposerKt.sourceInformation(composer, "275@12350L54");
                Modifier modifierLayoutId = LayoutIdKt.layoutId(Modifier.INSTANCE, "header");
                ComposerKt.sourceInformationMarkerStart(composer, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
                CompositionLocalMap currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer, modifierLayoutId);
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
                ComposerKt.sourceInformationMarkerStart(composer, 310577628, "C275@12394L8:WideNavigationRail.kt#uh7d8r");
                function2.invoke(composer, 0);
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
                composer.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
            } else {
                composer.startReplaceGroup(1702658722);
            }
            composer.endReplaceGroup();
            function3.invoke(composer, 0);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:101:0x011e  */
    /* JADX WARN: Code duplicated, block: B:109:0x0134  */
    /* JADX WARN: Code duplicated, block: B:112:0x013a  */
    /* JADX WARN: Code duplicated, block: B:113:0x0141  */
    /* JADX WARN: Code duplicated, block: B:115:0x0145  */
    /* JADX WARN: Code duplicated, block: B:117:0x014f  */
    /* JADX WARN: Code duplicated, block: B:118:0x0152  */
    /* JADX WARN: Code duplicated, block: B:120:0x0157  */
    /* JADX WARN: Code duplicated, block: B:123:0x0163  */
    /* JADX WARN: Code duplicated, block: B:125:0x0169  */
    /* JADX WARN: Code duplicated, block: B:126:0x016c  */
    /* JADX WARN: Code duplicated, block: B:134:0x0188  */
    /* JADX WARN: Code duplicated, block: B:137:0x0191  */
    /* JADX WARN: Code duplicated, block: B:161:0x01eb A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:162:0x01ed  */
    /* JADX WARN: Code duplicated, block: B:163:0x01f2  */
    /* JADX WARN: Code duplicated, block: B:166:0x01fa  */
    /* JADX WARN: Code duplicated, block: B:167:0x0202  */
    /* JADX WARN: Code duplicated, block: B:169:0x0206  */
    /* JADX WARN: Code duplicated, block: B:172:0x020c  */
    /* JADX WARN: Code duplicated, block: B:173:0x0215  */
    /* JADX WARN: Code duplicated, block: B:176:0x021a  */
    /* JADX WARN: Code duplicated, block: B:177:0x0223  */
    /* JADX WARN: Code duplicated, block: B:180:0x0228  */
    /* JADX WARN: Code duplicated, block: B:181:0x0234  */
    /* JADX WARN: Code duplicated, block: B:184:0x0239  */
    /* JADX WARN: Code duplicated, block: B:186:0x023c  */
    /* JADX WARN: Code duplicated, block: B:187:0x0243  */
    /* JADX WARN: Code duplicated, block: B:190:0x0248  */
    /* JADX WARN: Code duplicated, block: B:191:0x0253  */
    /* JADX WARN: Code duplicated, block: B:194:0x0259  */
    /* JADX WARN: Code duplicated, block: B:195:0x0264  */
    /* JADX WARN: Code duplicated, block: B:197:0x0268  */
    /* JADX WARN: Code duplicated, block: B:198:0x027f  */
    /* JADX WARN: Code duplicated, block: B:202:0x029e  */
    /* JADX WARN: Code duplicated, block: B:205:0x02d0  */
    /* JADX WARN: Code duplicated, block: B:207:0x02eb  */
    /* JADX WARN: Code duplicated, block: B:210:0x0305  */
    /* JADX WARN: Code duplicated, block: B:212:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:23:0x004c  */
    /* JADX WARN: Code duplicated, block: B:38:0x006f  */
    /* JADX WARN: Code duplicated, block: B:40:0x0073  */
    /* JADX WARN: Code duplicated, block: B:42:0x007b  */
    /* JADX WARN: Code duplicated, block: B:43:0x007e  */
    /* JADX WARN: Code duplicated, block: B:46:0x0084  */
    /* JADX WARN: Code duplicated, block: B:49:0x008a  */
    /* JADX WARN: Code duplicated, block: B:51:0x008e  */
    /* JADX WARN: Code duplicated, block: B:53:0x0096  */
    /* JADX WARN: Code duplicated, block: B:54:0x0099  */
    /* JADX WARN: Code duplicated, block: B:57:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:60:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:65:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:67:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:70:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:71:0x00c9  */
    /* JADX WARN: Code duplicated, block: B:73:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:75:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:76:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:80:0x00e2  */
    /* JADX WARN: Code duplicated, block: B:81:0x00e7  */
    /* JADX WARN: Code duplicated, block: B:83:0x00ed  */
    /* JADX WARN: Code duplicated, block: B:85:0x00f3  */
    /* JADX WARN: Code duplicated, block: B:86:0x00f6  */
    /* JADX WARN: Code duplicated, block: B:90:0x0100  */
    /* JADX WARN: Code duplicated, block: B:98:0x0116  */
    /* JADX INFO: renamed from: ModalWideNavigationRail-k3FuEkE, reason: not valid java name */
    public static final void m4842ModalWideNavigationRailk3FuEkE(Modifier modifier, WideNavigationRailState wideNavigationRailState, boolean z, Shape shape, Shape shape2, WideNavigationRailColors wideNavigationRailColors, Function2<? super Composer, ? super Integer, Unit> function2, float f, WindowInsets windowInsets, Arrangement.Vertical vertical, ModalWideNavigationRailProperties modalWideNavigationRailProperties, final Function2<? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2, final int i3) {
        Modifier modifier2;
        int i4;
        boolean z2;
        Shape shape3;
        Shape shape4;
        int i5;
        Function2<? super Composer, ? super Integer, Unit> function4;
        int i6;
        int i7;
        float f2;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        boolean z3;
        final WindowInsets windowInsets2;
        final Function2<? super Composer, ? super Integer, Unit> function5;
        final Modifier modifier3;
        final float f3;
        final boolean z4;
        final Shape shape5;
        final Shape shape6;
        final WideNavigationRailState wideNavigationRailState2;
        final WideNavigationRailColors wideNavigationRailColors2;
        final Arrangement.Vertical vertical2;
        final ModalWideNavigationRailProperties modalWideNavigationRailProperties2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        WideNavigationRailState wideNavigationRailStateRememberWideNavigationRailState;
        Shape modalCollapsedShape;
        Shape modalExpandedShape;
        WideNavigationRailColors wideNavigationRailColorsColors;
        Function2<? super Composer, ? super Integer, Unit> function6;
        float fM9687constructorimpl;
        WindowInsets windowInsets3;
        Arrangement.Vertical arrangement;
        ModalWideNavigationRailProperties modalExpandedProperties;
        boolean z5;
        Shape shape7;
        WideNavigationRailColors wideNavigationRailColors3;
        int i13;
        int i14;
        int i15;
        Composer composerStartRestartGroup = composer.startRestartGroup(-38559147);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ModalWideNavigationRail)N(modifier,state,hideOnCollapse,collapsedShape,expandedShape,colors,header,expandedHeaderTopPadding:c#ui.unit.Dp,windowInsets,arrangement,expandedProperties,content)507@25293L7,*507@25310L25:WideNavigationRail.kt#uh7d8r");
        int i16 = i3 & 1;
        if (i16 != 0) {
            i4 = i | 6;
            modifier2 = modifier;
        } else if ((i & 6) == 0) {
            modifier2 = modifier;
            i4 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i;
        } else {
            modifier2 = modifier;
            i4 = i;
        }
        if ((i & 48) == 0) {
            if ((i3 & 2) != 0) {
                i15 = 16;
            } else {
                if ((i & 64) == 0 ? composerStartRestartGroup.changed(wideNavigationRailState) : composerStartRestartGroup.changedInstance(wideNavigationRailState)) {
                    i15 = 32;
                } else {
                    i15 = 16;
                }
            }
            i4 |= i15;
        }
        int i17 = i3 & 4;
        if (i17 == 0) {
            if ((i & 384) == 0) {
                z2 = z;
                i4 |= composerStartRestartGroup.changed(z2) ? 256 : 128;
            }
            if ((i & 3072) == 0) {
                if ((i3 & 8) == 0) {
                    shape3 = shape;
                    int i18 = composerStartRestartGroup.changed(shape3) ? 2048 : 1024;
                    i4 |= i18;
                } else {
                    shape3 = shape;
                }
                i4 |= i18;
            } else {
                shape3 = shape;
            }
            if ((i & 24576) == 0) {
                if ((i3 & 16) == 0) {
                    shape4 = shape2;
                    int i19 = composerStartRestartGroup.changed(shape4) ? 16384 : 8192;
                    i4 |= i19;
                } else {
                    shape4 = shape2;
                }
                i4 |= i19;
            } else {
                shape4 = shape2;
            }
            if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) != 0) {
                if ((i3 & 32) == 0 || !composerStartRestartGroup.changed(wideNavigationRailColors)) {
                    i14 = 65536;
                } else {
                    i14 = 131072;
                }
                i4 |= i14;
            }
            i5 = i3 & 64;
            if (i5 != 0) {
                i4 |= 1572864;
                function4 = function2;
            } else {
                function4 = function2;
                if ((i & 1572864) == 0) {
                    if (composerStartRestartGroup.changedInstance(function4)) {
                        i6 = 1048576;
                    } else {
                        i6 = 524288;
                    }
                    i4 |= i6;
                }
            }
            i7 = i3 & 128;
            if (i7 != 0) {
                i4 |= 12582912;
                f2 = f;
            } else {
                f2 = f;
                if ((i & 12582912) == 0) {
                    if (composerStartRestartGroup.changed(f2)) {
                        i8 = 8388608;
                    } else {
                        i8 = 4194304;
                    }
                    i4 |= i8;
                }
            }
            if ((i & 100663296) != 0) {
                i4 |= ((i3 & 256) == 0 || !composerStartRestartGroup.changed(windowInsets)) ? 33554432 : 67108864;
            }
            if ((i & 805306368) != 0) {
                i4 |= ((i3 & 512) == 0 || !composerStartRestartGroup.changed(vertical)) ? 268435456 : C.BUFFER_FLAG_LAST_SAMPLE;
            }
            i9 = i3 & 1024;
            if (i9 != 0) {
                i10 = i2 | 6;
            } else if ((i2 & 6) == 0) {
                if (composerStartRestartGroup.changed(modalWideNavigationRailProperties)) {
                    i11 = 4;
                } else {
                    i11 = 2;
                }
                i10 = i2 | i11;
            } else {
                i10 = i2;
            }
            if ((i2 & 48) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i13 = 32;
                } else {
                    i13 = 16;
                }
                i10 |= i13;
            }
            i12 = i10;
            if ((i4 & 306783379) == 306783378 || (i12 & 19) != 18) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i4 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "479@23989L33,481@24116L19,482@24191L18,483@24277L8,486@24434L12");
                if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                    if (i16 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if ((i3 & 2) != 0) {
                        wideNavigationRailStateRememberWideNavigationRailState = WideNavigationRailStateKt.rememberWideNavigationRailState(null, composerStartRestartGroup, 0, 1);
                        i4 &= -113;
                    } else {
                        wideNavigationRailStateRememberWideNavigationRailState = wideNavigationRailState;
                    }
                    if (i17 != 0) {
                        z2 = false;
                    }
                    if ((i3 & 8) != 0) {
                        modalCollapsedShape = WideNavigationRailDefaults.INSTANCE.getModalCollapsedShape(composerStartRestartGroup, 6);
                        i4 &= -7169;
                    } else {
                        modalCollapsedShape = shape3;
                    }
                    if ((i3 & 16) != 0) {
                        modalExpandedShape = WideNavigationRailDefaults.INSTANCE.getModalExpandedShape(composerStartRestartGroup, 6);
                        i4 &= -57345;
                    } else {
                        modalExpandedShape = shape4;
                    }
                    if ((i3 & 32) != 0) {
                        wideNavigationRailColorsColors = WideNavigationRailDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                        i4 &= -458753;
                    } else {
                        wideNavigationRailColorsColors = wideNavigationRailColors;
                    }
                    function6 = i5 == 0 ? function4 : null;
                    if (i7 != 0) {
                        fM9687constructorimpl = Dp.m9687constructorimpl(0);
                    } else {
                        fM9687constructorimpl = f2;
                    }
                    if ((i3 & 256) != 0) {
                        windowInsets3 = WideNavigationRailDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                        i4 &= -234881025;
                    } else {
                        windowInsets3 = windowInsets;
                    }
                    if ((i3 & 512) != 0) {
                        arrangement = WideNavigationRailDefaults.INSTANCE.getArrangement();
                        i4 &= -1879048193;
                    } else {
                        arrangement = vertical;
                    }
                    if (i9 != 0) {
                        modalExpandedProperties = WideNavigationRailDefaults.INSTANCE.getModalExpandedProperties();
                    } else {
                        modalExpandedProperties = modalWideNavigationRailProperties;
                    }
                    z5 = z2;
                    shape7 = modalExpandedShape;
                    wideNavigationRailColors3 = wideNavigationRailColorsColors;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    if ((i3 & 2) != 0) {
                        i4 &= -113;
                    }
                    if ((i3 & 8) != 0) {
                        i4 &= -7169;
                    }
                    if ((i3 & 16) != 0) {
                        i4 &= -57345;
                    }
                    if ((i3 & 32) != 0) {
                        i4 &= -458753;
                    }
                    if ((i3 & 256) != 0) {
                        i4 &= -234881025;
                    }
                    if ((i3 & 512) != 0) {
                        i4 &= -1879048193;
                    }
                    wideNavigationRailStateRememberWideNavigationRailState = wideNavigationRailState;
                    wideNavigationRailColors3 = wideNavigationRailColors;
                    windowInsets3 = windowInsets;
                    arrangement = vertical;
                    modalExpandedProperties = modalWideNavigationRailProperties;
                    function6 = function4;
                    companion = modifier2;
                    fM9687constructorimpl = f2;
                    z5 = z2;
                    modalCollapsedShape = shape3;
                    shape7 = shape4;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-38559147, i4, i12, "androidx.compose.material3.ModalWideNavigationRail (WideNavigationRail.kt:491)");
                }
                ModalWideNavigationRailOverrideScope modalWideNavigationRailOverrideScope = new ModalWideNavigationRailOverrideScope(companion, wideNavigationRailStateRememberWideNavigationRailState, z5, modalCollapsedShape, shape7, wideNavigationRailColors3, function6, fM9687constructorimpl, windowInsets3, arrangement, modalExpandedProperties, function3, null);
                ProvidableCompositionLocal<ModalWideNavigationRailOverride> providableCompositionLocal = LocalModalWideNavigationRailOverride;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume = composerStartRestartGroup.consume(providableCompositionLocal);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ((ModalWideNavigationRailOverride) objConsume).ModalWideNavigationRail(modalWideNavigationRailOverrideScope, composerStartRestartGroup, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = companion;
                wideNavigationRailState2 = wideNavigationRailStateRememberWideNavigationRailState;
                z4 = z5;
                shape5 = modalCollapsedShape;
                shape6 = shape7;
                wideNavigationRailColors2 = wideNavigationRailColors3;
                function5 = function6;
                f3 = fM9687constructorimpl;
                windowInsets2 = windowInsets3;
                vertical2 = arrangement;
                modalWideNavigationRailProperties2 = modalExpandedProperties;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                windowInsets2 = windowInsets;
                function5 = function4;
                modifier3 = modifier2;
                f3 = f2;
                z4 = z2;
                shape5 = shape3;
                shape6 = shape4;
                wideNavigationRailState2 = wideNavigationRailState;
                wideNavigationRailColors2 = wideNavigationRailColors;
                vertical2 = vertical;
                modalWideNavigationRailProperties2 = modalWideNavigationRailProperties;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.WideNavigationRailKt$$ExternalSyntheticLambda13
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return WideNavigationRailKt.ModalWideNavigationRail_k3FuEkE$lambda$1(modifier3, wideNavigationRailState2, z4, shape5, shape6, wideNavigationRailColors2, function5, f3, windowInsets2, vertical2, modalWideNavigationRailProperties2, function3, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i4 |= 384;
        z2 = z;
        if ((i & 3072) == 0) {
            if ((i3 & 8) == 0) {
                shape3 = shape;
                if (composerStartRestartGroup.changed(shape3)) {
                }
                i4 |= i18;
            } else {
                shape3 = shape;
            }
            i4 |= i18;
        } else {
            shape3 = shape;
        }
        if ((i & 24576) == 0) {
            if ((i3 & 16) == 0) {
                shape4 = shape2;
                if (composerStartRestartGroup.changed(shape4)) {
                }
                i4 |= i19;
            } else {
                shape4 = shape2;
            }
            i4 |= i19;
        } else {
            shape4 = shape2;
        }
        if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) != 0) {
            if ((i3 & 32) == 0) {
                i14 = 65536;
            } else {
                i14 = 65536;
            }
            i4 |= i14;
        }
        i5 = i3 & 64;
        if (i5 != 0) {
            i4 |= 1572864;
            function4 = function2;
        } else {
            function4 = function2;
            if ((i & 1572864) == 0) {
                if (composerStartRestartGroup.changedInstance(function4)) {
                    i6 = 1048576;
                } else {
                    i6 = 524288;
                }
                i4 |= i6;
            }
        }
        i7 = i3 & 128;
        if (i7 != 0) {
            i4 |= 12582912;
            f2 = f;
        } else {
            f2 = f;
            if ((i & 12582912) == 0) {
                if (composerStartRestartGroup.changed(f2)) {
                    i8 = 8388608;
                } else {
                    i8 = 4194304;
                }
                i4 |= i8;
            }
        }
        if ((i & 100663296) != 0) {
            i4 |= ((i3 & 256) == 0 || !composerStartRestartGroup.changed(windowInsets)) ? 33554432 : 67108864;
        }
        if ((i & 805306368) != 0) {
            i4 |= ((i3 & 512) == 0 || !composerStartRestartGroup.changed(vertical)) ? 268435456 : C.BUFFER_FLAG_LAST_SAMPLE;
        }
        i9 = i3 & 1024;
        if (i9 != 0) {
            i10 = i2 | 6;
        } else if ((i2 & 6) == 0) {
            if (composerStartRestartGroup.changed(modalWideNavigationRailProperties)) {
                i11 = 4;
            } else {
                i11 = 2;
            }
            i10 = i2 | i11;
        } else {
            i10 = i2;
        }
        if ((i2 & 48) == 0) {
            if (composerStartRestartGroup.changedInstance(function3)) {
                i13 = 32;
            } else {
                i13 = 16;
            }
            i10 |= i13;
        }
        i12 = i10;
        if ((i4 & 306783379) == 306783378) {
            z3 = true;
        } else {
            z3 = true;
        }
        if (composerStartRestartGroup.shouldExecute(z3, i4 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "479@23989L33,481@24116L19,482@24191L18,483@24277L8,486@24434L12");
            if ((i & 1) != 0) {
                if (i16 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if ((i3 & 2) != 0) {
                    wideNavigationRailStateRememberWideNavigationRailState = WideNavigationRailStateKt.rememberWideNavigationRailState(null, composerStartRestartGroup, 0, 1);
                    i4 &= -113;
                } else {
                    wideNavigationRailStateRememberWideNavigationRailState = wideNavigationRailState;
                }
                if (i17 != 0) {
                    z2 = false;
                }
                if ((i3 & 8) != 0) {
                    modalCollapsedShape = WideNavigationRailDefaults.INSTANCE.getModalCollapsedShape(composerStartRestartGroup, 6);
                    i4 &= -7169;
                } else {
                    modalCollapsedShape = shape3;
                }
                if ((i3 & 16) != 0) {
                    modalExpandedShape = WideNavigationRailDefaults.INSTANCE.getModalExpandedShape(composerStartRestartGroup, 6);
                    i4 &= -57345;
                } else {
                    modalExpandedShape = shape4;
                }
                if ((i3 & 32) != 0) {
                    wideNavigationRailColorsColors = WideNavigationRailDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                    i4 &= -458753;
                } else {
                    wideNavigationRailColorsColors = wideNavigationRailColors;
                }
                if (i5 == 0) {
                }
                if (i7 != 0) {
                    fM9687constructorimpl = Dp.m9687constructorimpl(0);
                } else {
                    fM9687constructorimpl = f2;
                }
                if ((i3 & 256) != 0) {
                    windowInsets3 = WideNavigationRailDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                    i4 &= -234881025;
                } else {
                    windowInsets3 = windowInsets;
                }
                if ((i3 & 512) != 0) {
                    arrangement = WideNavigationRailDefaults.INSTANCE.getArrangement();
                    i4 &= -1879048193;
                } else {
                    arrangement = vertical;
                }
                if (i9 != 0) {
                    modalExpandedProperties = WideNavigationRailDefaults.INSTANCE.getModalExpandedProperties();
                } else {
                    modalExpandedProperties = modalWideNavigationRailProperties;
                }
                z5 = z2;
                shape7 = modalExpandedShape;
                wideNavigationRailColors3 = wideNavigationRailColorsColors;
            } else {
                if (i16 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if ((i3 & 2) != 0) {
                    wideNavigationRailStateRememberWideNavigationRailState = WideNavigationRailStateKt.rememberWideNavigationRailState(null, composerStartRestartGroup, 0, 1);
                    i4 &= -113;
                } else {
                    wideNavigationRailStateRememberWideNavigationRailState = wideNavigationRailState;
                }
                if (i17 != 0) {
                    z2 = false;
                }
                if ((i3 & 8) != 0) {
                    modalCollapsedShape = WideNavigationRailDefaults.INSTANCE.getModalCollapsedShape(composerStartRestartGroup, 6);
                    i4 &= -7169;
                } else {
                    modalCollapsedShape = shape3;
                }
                if ((i3 & 16) != 0) {
                    modalExpandedShape = WideNavigationRailDefaults.INSTANCE.getModalExpandedShape(composerStartRestartGroup, 6);
                    i4 &= -57345;
                } else {
                    modalExpandedShape = shape4;
                }
                if ((i3 & 32) != 0) {
                    wideNavigationRailColorsColors = WideNavigationRailDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                    i4 &= -458753;
                } else {
                    wideNavigationRailColorsColors = wideNavigationRailColors;
                }
                if (i5 == 0) {
                }
                if (i7 != 0) {
                    fM9687constructorimpl = Dp.m9687constructorimpl(0);
                } else {
                    fM9687constructorimpl = f2;
                }
                if ((i3 & 256) != 0) {
                    windowInsets3 = WideNavigationRailDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                    i4 &= -234881025;
                } else {
                    windowInsets3 = windowInsets;
                }
                if ((i3 & 512) != 0) {
                    arrangement = WideNavigationRailDefaults.INSTANCE.getArrangement();
                    i4 &= -1879048193;
                } else {
                    arrangement = vertical;
                }
                if (i9 != 0) {
                    modalExpandedProperties = WideNavigationRailDefaults.INSTANCE.getModalExpandedProperties();
                } else {
                    modalExpandedProperties = modalWideNavigationRailProperties;
                }
                z5 = z2;
                shape7 = modalExpandedShape;
                wideNavigationRailColors3 = wideNavigationRailColorsColors;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-38559147, i4, i12, "androidx.compose.material3.ModalWideNavigationRail (WideNavigationRail.kt:491)");
            }
            ModalWideNavigationRailOverrideScope modalWideNavigationRailOverrideScope2 = new ModalWideNavigationRailOverrideScope(companion, wideNavigationRailStateRememberWideNavigationRailState, z5, modalCollapsedShape, shape7, wideNavigationRailColors3, function6, fM9687constructorimpl, windowInsets3, arrangement, modalExpandedProperties, function3, null);
            ProvidableCompositionLocal<ModalWideNavigationRailOverride> providableCompositionLocal2 = LocalModalWideNavigationRailOverride;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume2 = composerStartRestartGroup.consume(providableCompositionLocal2);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ((ModalWideNavigationRailOverride) objConsume2).ModalWideNavigationRail(modalWideNavigationRailOverrideScope2, composerStartRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = companion;
            wideNavigationRailState2 = wideNavigationRailStateRememberWideNavigationRailState;
            z4 = z5;
            shape5 = modalCollapsedShape;
            shape6 = shape7;
            wideNavigationRailColors2 = wideNavigationRailColors3;
            function5 = function6;
            f3 = fM9687constructorimpl;
            windowInsets2 = windowInsets3;
            vertical2 = arrangement;
            modalWideNavigationRailProperties2 = modalExpandedProperties;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            windowInsets2 = windowInsets;
            function5 = function4;
            modifier3 = modifier2;
            f3 = f2;
            z4 = z2;
            shape5 = shape3;
            shape6 = shape4;
            wideNavigationRailState2 = wideNavigationRailState;
            wideNavigationRailColors2 = wideNavigationRailColors;
            vertical2 = vertical;
            modalWideNavigationRailProperties2 = modalWideNavigationRailProperties;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.WideNavigationRailKt$$ExternalSyntheticLambda13
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return WideNavigationRailKt.ModalWideNavigationRail_k3FuEkE$lambda$1(modifier3, wideNavigationRailState2, z4, shape5, shape6, wideNavigationRailColors2, function5, f3, windowInsets2, vertical2, modalWideNavigationRailProperties2, function3, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0120  */
    /* JADX WARN: Code duplicated, block: B:103:0x0133  */
    /* JADX WARN: Code duplicated, block: B:113:0x014c A[PHI: r0 r7 r9 r10 r15
      0x014c: PHI (r0v23 int) = (r0v12 int), (r0v27 int), (r0v28 int) binds: [B:127:0x0180, B:111:0x0148, B:112:0x014a] A[DONT_GENERATE, DONT_INLINE]
      0x014c: PHI (r7v39 androidx.compose.ui.Modifier) = (r7v6 androidx.compose.ui.Modifier), (r7v3 androidx.compose.ui.Modifier), (r7v3 androidx.compose.ui.Modifier) binds: [B:127:0x0180, B:111:0x0148, B:112:0x014a] A[DONT_GENERATE, DONT_INLINE]
      0x014c: PHI (r9v15 boolean) = (r9v6 boolean), (r9v3 boolean), (r9v3 boolean) binds: [B:127:0x0180, B:111:0x0148, B:112:0x014a] A[DONT_GENERATE, DONT_INLINE]
      0x014c: PHI (r10v14 int) = (r10v10 int), (r10v7 int), (r10v7 int) binds: [B:127:0x0180, B:111:0x0148, B:112:0x014a] A[DONT_GENERATE, DONT_INLINE]
      0x014c: PHI (r15v8 androidx.compose.material3.NavigationItemColors) = 
      (r15v4 androidx.compose.material3.NavigationItemColors)
      (r15v3 androidx.compose.material3.NavigationItemColors)
      (r15v3 androidx.compose.material3.NavigationItemColors)
     binds: [B:127:0x0180, B:111:0x0148, B:112:0x014a] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:115:0x0157 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:116:0x0159  */
    /* JADX WARN: Code duplicated, block: B:118:0x0160  */
    /* JADX WARN: Code duplicated, block: B:121:0x0166  */
    /* JADX WARN: Code duplicated, block: B:122:0x0170  */
    /* JADX WARN: Code duplicated, block: B:125:0x0176  */
    /* JADX WARN: Code duplicated, block: B:128:0x0182  */
    /* JADX WARN: Code duplicated, block: B:131:0x018d  */
    /* JADX WARN: Code duplicated, block: B:133:0x0199  */
    /* JADX WARN: Code duplicated, block: B:135:0x01b8  */
    /* JADX WARN: Code duplicated, block: B:137:0x01ca  */
    /* JADX WARN: Code duplicated, block: B:140:0x024f  */
    /* JADX WARN: Code duplicated, block: B:142:0x025c  */
    /* JADX WARN: Code duplicated, block: B:145:0x026d  */
    /* JADX WARN: Code duplicated, block: B:147:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:53:0x0094  */
    /* JADX WARN: Code duplicated, block: B:54:0x0096  */
    /* JADX WARN: Code duplicated, block: B:56:0x0099  */
    /* JADX WARN: Code duplicated, block: B:58:0x00a1  */
    /* JADX WARN: Code duplicated, block: B:59:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:64:0x00af  */
    /* JADX WARN: Code duplicated, block: B:66:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:68:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:69:0x00be  */
    /* JADX WARN: Code duplicated, block: B:72:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:75:0x00cb  */
    /* JADX WARN: Code duplicated, block: B:77:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:79:0x00d7  */
    /* JADX WARN: Code duplicated, block: B:80:0x00da  */
    /* JADX WARN: Code duplicated, block: B:83:0x00e1  */
    /* JADX WARN: Code duplicated, block: B:86:0x00e9  */
    /* JADX WARN: Code duplicated, block: B:87:0x00ec  */
    /* JADX WARN: Code duplicated, block: B:89:0x00f0  */
    /* JADX WARN: Code duplicated, block: B:91:0x00fa  */
    /* JADX WARN: Code duplicated, block: B:92:0x00fd  */
    /* JADX WARN: Code duplicated, block: B:97:0x0114  */
    /* JADX WARN: Code duplicated, block: B:98:0x0117  */
    /* JADX INFO: renamed from: WideNavigationRailItem-pli-t6k, reason: not valid java name */
    public static final void m4846WideNavigationRailItemplit6k(final boolean z, final Function0<Unit> function0, final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function3, final boolean z2, Modifier modifier, boolean z3, int i, NavigationItemColors navigationItemColors, MutableInteractionSource mutableInteractionSource, Composer composer, final int i2, final int i3) {
        int i4;
        Function2<? super Composer, ? super Integer, Unit> function4;
        Function2<? super Composer, ? super Integer, Unit> function5;
        Modifier modifier2;
        int i5;
        boolean z4;
        int i6;
        int iM4835iconPositionFors8pcRp0;
        NavigationItemColors navigationItemColorsColors;
        int i7;
        int i8;
        int i9;
        boolean z5;
        Composer composer2;
        final Modifier modifier3;
        final boolean z6;
        final int i10;
        final NavigationItemColors navigationItemColors2;
        final MutableInteractionSource mutableInteractionSource2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i11;
        int i12;
        MutableInteractionSource mutableInteractionSource3;
        MutableInteractionSource mutableInteractionSource4;
        Object objRememberedValue;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1894733304);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(WideNavigationRailItem)N(selected,onClick,icon,label,railExpanded,modifier,enabled,iconPosition:c#material3.NavigationItemIconPosition,colors,interactionSource)712@34524L5,714@34697L5,715@34787L5,708@34344L1318:WideNavigationRail.kt#uh7d8r");
        if ((i2 & 6) == 0) {
            i4 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i2;
        } else {
            i4 = i2;
        }
        if ((i2 & 48) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(function0) ? 32 : 16;
        }
        if ((i2 & 384) == 0) {
            function4 = function2;
            i4 |= composerStartRestartGroup.changedInstance(function4) ? 256 : 128;
        } else {
            function4 = function2;
        }
        if ((i2 & 3072) == 0) {
            function5 = function3;
            i4 |= composerStartRestartGroup.changedInstance(function5) ? 2048 : 1024;
        } else {
            function5 = function3;
        }
        if ((i2 & 24576) == 0) {
            i4 |= composerStartRestartGroup.changed(z2) ? 16384 : 8192;
        }
        int i13 = i3 & 32;
        if (i13 == 0) {
            if ((196608 & i2) == 0) {
                modifier2 = modifier;
                i4 |= composerStartRestartGroup.changed(modifier2) ? 131072 : 65536;
            }
            i5 = i3 & 64;
            if (i5 != 0) {
                if ((1572864 & i2) == 0) {
                    z4 = z3;
                    if (composerStartRestartGroup.changed(z4)) {
                        i6 = 1048576;
                    } else {
                        i6 = 524288;
                    }
                    i4 |= i6;
                }
                if ((12582912 & i2) == 0) {
                    if ((i3 & 128) == 0) {
                        iM4835iconPositionFors8pcRp0 = i;
                        int i14 = composerStartRestartGroup.changed(iM4835iconPositionFors8pcRp0) ? 8388608 : 4194304;
                        i4 |= i14;
                    } else {
                        iM4835iconPositionFors8pcRp0 = i;
                    }
                    i4 |= i14;
                } else {
                    iM4835iconPositionFors8pcRp0 = i;
                }
                if ((100663296 & i2) == 0) {
                    if ((i3 & 256) == 0) {
                        navigationItemColorsColors = navigationItemColors;
                        int i15 = composerStartRestartGroup.changed(navigationItemColorsColors) ? 67108864 : 33554432;
                        i4 |= i15;
                    } else {
                        navigationItemColorsColors = navigationItemColors;
                    }
                    i4 |= i15;
                } else {
                    navigationItemColorsColors = navigationItemColors;
                }
                i7 = i3 & 512;
                if (i7 != 0) {
                    if ((i2 & 805306368) == 0) {
                        if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                            i8 = C.BUFFER_FLAG_LAST_SAMPLE;
                        } else {
                            i8 = 268435456;
                        }
                        i4 |= i8;
                    }
                    i9 = i4;
                    if ((i4 & 306783379) != 306783378) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z5, i9 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "702@34147L8");
                        if ((i2 & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            if (i13 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i5 != 0) {
                                z4 = true;
                            }
                            if ((i3 & 128) != 0) {
                                i11 = i9 & (-29360129);
                                iM4835iconPositionFors8pcRp0 = WideNavigationRailItemDefaults.INSTANCE.m4835iconPositionFors8pcRp0(z2);
                            } else {
                                i11 = i9;
                            }
                            if ((i3 & 256) != 0) {
                                i11 &= -234881025;
                                navigationItemColorsColors = WideNavigationRailItemDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                            }
                            i12 = i11;
                            if (i7 != 0) {
                                mutableInteractionSource3 = null;
                            }
                            Modifier modifier4 = modifier2;
                            boolean z7 = z4;
                            int i16 = iM4835iconPositionFors8pcRp0;
                            NavigationItemColors navigationItemColors3 = navigationItemColorsColors;
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1894733304, i12, -1, "androidx.compose.material3.WideNavigationRailItem (WideNavigationRail.kt:704)");
                            }
                            if (mutableInteractionSource3 == null) {
                                composerStartRestartGroup.startReplaceGroup(-1539084813);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "706@34299L39");
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 227446767, "CC(remember):WideNavigationRail.kt#9igjgp");
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                composerStartRestartGroup.endReplaceGroup();
                                mutableInteractionSource4 = (MutableInteractionSource) objRememberedValue;
                            } else {
                                composerStartRestartGroup.startReplaceGroup(227446116);
                                composerStartRestartGroup.endReplaceGroup();
                                mutableInteractionSource4 = mutableInteractionSource3;
                            }
                            int i17 = i12 << 3;
                            composer2 = composerStartRestartGroup;
                            NavigationItemKt.m3902AnimatedNavigationItemDQd_Gtc(z, function0, function4, ShapesKt.getValue(NavigationRailBaselineItemTokens.INSTANCE.getActiveIndicatorShape(), composerStartRestartGroup, 6), NavigationRailVerticalItemTokens.INSTANCE.m5589getActiveIndicatorWidthD9Ej5fM(), TypographyKt.getValue(NavigationRailVerticalItemTokens.INSTANCE.getLabelTextFont(), composerStartRestartGroup, 6), TypographyKt.getValue(NavigationRailHorizontalItemTokens.INSTANCE.getLabelTextFont(), composerStartRestartGroup, 6), ItemTopIconIndicatorHorizontalPadding, ItemTopIconIndicatorVerticalPadding, NavigationRailVerticalItemTokens.INSTANCE.m5590getIconLabelSpaceD9Ej5fM(), NavigationRailHorizontalItemTokens.INSTANCE.m5584getFullWidthLeadingSpaceD9Ej5fM(), ItemStartIconIndicatorVerticalPadding, WNRItemNoLabelIndicatorPadding, NavigationRailHorizontalItemTokens.INSTANCE.m5586getIconLabelSpaceD9Ej5fM(), ItemHorizontalPadding, navigationItemColors3, modifier4, z7, function5, i16, mutableInteractionSource4, composer2, (i12 & 14) | 918577152 | (i12 & 112) | (i12 & 896), ((i12 >> 9) & 458752) | 28086 | (3670016 & i17) | (i17 & 29360128) | ((i12 << 15) & 234881024) | ((i12 << 6) & C.ENCODING_PCM_DOUBLE), 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            mutableInteractionSource2 = mutableInteractionSource3;
                            navigationItemColors2 = navigationItemColors3;
                            modifier3 = modifier4;
                            z6 = z7;
                            i10 = i16;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            i12 = (i3 & 128) != 0 ? i9 & (-29360129) : i9;
                            if ((i3 & 256) != 0) {
                                i12 &= -234881025;
                            }
                        }
                        mutableInteractionSource3 = mutableInteractionSource;
                        Modifier modifier5 = modifier2;
                        boolean z8 = z4;
                        int i18 = iM4835iconPositionFors8pcRp0;
                        NavigationItemColors navigationItemColors4 = navigationItemColorsColors;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1894733304, i12, -1, "androidx.compose.material3.WideNavigationRailItem (WideNavigationRail.kt:704)");
                        }
                        if (mutableInteractionSource3 == null) {
                            composerStartRestartGroup.startReplaceGroup(-1539084813);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "706@34299L39");
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 227446767, "CC(remember):WideNavigationRail.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            composerStartRestartGroup.endReplaceGroup();
                            mutableInteractionSource4 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            composerStartRestartGroup.startReplaceGroup(227446116);
                            composerStartRestartGroup.endReplaceGroup();
                            mutableInteractionSource4 = mutableInteractionSource3;
                        }
                        int i19 = i12 << 3;
                        composer2 = composerStartRestartGroup;
                        NavigationItemKt.m3902AnimatedNavigationItemDQd_Gtc(z, function0, function4, ShapesKt.getValue(NavigationRailBaselineItemTokens.INSTANCE.getActiveIndicatorShape(), composerStartRestartGroup, 6), NavigationRailVerticalItemTokens.INSTANCE.m5589getActiveIndicatorWidthD9Ej5fM(), TypographyKt.getValue(NavigationRailVerticalItemTokens.INSTANCE.getLabelTextFont(), composerStartRestartGroup, 6), TypographyKt.getValue(NavigationRailHorizontalItemTokens.INSTANCE.getLabelTextFont(), composerStartRestartGroup, 6), ItemTopIconIndicatorHorizontalPadding, ItemTopIconIndicatorVerticalPadding, NavigationRailVerticalItemTokens.INSTANCE.m5590getIconLabelSpaceD9Ej5fM(), NavigationRailHorizontalItemTokens.INSTANCE.m5584getFullWidthLeadingSpaceD9Ej5fM(), ItemStartIconIndicatorVerticalPadding, WNRItemNoLabelIndicatorPadding, NavigationRailHorizontalItemTokens.INSTANCE.m5586getIconLabelSpaceD9Ej5fM(), ItemHorizontalPadding, navigationItemColors4, modifier5, z8, function5, i18, mutableInteractionSource4, composer2, (i12 & 14) | 918577152 | (i12 & 112) | (i12 & 896), ((i12 >> 9) & 458752) | 28086 | (3670016 & i19) | (i19 & 29360128) | ((i12 << 15) & 234881024) | ((i12 << 6) & C.ENCODING_PCM_DOUBLE), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        mutableInteractionSource2 = mutableInteractionSource3;
                        navigationItemColors2 = navigationItemColors4;
                        modifier3 = modifier5;
                        z6 = z8;
                        i10 = i18;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        modifier3 = modifier2;
                        z6 = z4;
                        i10 = iM4835iconPositionFors8pcRp0;
                        navigationItemColors2 = navigationItemColorsColors;
                        mutableInteractionSource2 = mutableInteractionSource;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.WideNavigationRailKt$$ExternalSyntheticLambda11
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return WideNavigationRailKt.WideNavigationRailItem_pli_t6k$lambda$1(z, function0, function2, function3, z2, modifier3, z6, i10, navigationItemColors2, mutableInteractionSource2, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i4 |= 805306368;
                i9 = i4;
                if ((i4 & 306783379) != 306783378) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z5, i9 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "702@34147L8");
                    if ((i2 & 1) != 0) {
                        if (i13 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i5 != 0) {
                            z4 = true;
                        }
                        if ((i3 & 128) != 0) {
                            i11 = i9 & (-29360129);
                            iM4835iconPositionFors8pcRp0 = WideNavigationRailItemDefaults.INSTANCE.m4835iconPositionFors8pcRp0(z2);
                        } else {
                            i11 = i9;
                        }
                        if ((i3 & 256) != 0) {
                            i11 &= -234881025;
                            navigationItemColorsColors = WideNavigationRailItemDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                        }
                        i12 = i11;
                        if (i7 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                    } else {
                        if (i13 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i5 != 0) {
                            z4 = true;
                        }
                        if ((i3 & 128) != 0) {
                            i11 = i9 & (-29360129);
                            iM4835iconPositionFors8pcRp0 = WideNavigationRailItemDefaults.INSTANCE.m4835iconPositionFors8pcRp0(z2);
                        } else {
                            i11 = i9;
                        }
                        if ((i3 & 256) != 0) {
                            i11 &= -234881025;
                            navigationItemColorsColors = WideNavigationRailItemDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                        }
                        i12 = i11;
                        if (i7 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                    }
                    Modifier modifier6 = modifier2;
                    boolean z9 = z4;
                    int i110 = iM4835iconPositionFors8pcRp0;
                    NavigationItemColors navigationItemColors5 = navigationItemColorsColors;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1894733304, i12, -1, "androidx.compose.material3.WideNavigationRailItem (WideNavigationRail.kt:704)");
                    }
                    if (mutableInteractionSource3 == null) {
                        composerStartRestartGroup.startReplaceGroup(-1539084813);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "706@34299L39");
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 227446767, "CC(remember):WideNavigationRail.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.endReplaceGroup();
                        mutableInteractionSource4 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        composerStartRestartGroup.startReplaceGroup(227446116);
                        composerStartRestartGroup.endReplaceGroup();
                        mutableInteractionSource4 = mutableInteractionSource3;
                    }
                    int i111 = i12 << 3;
                    composer2 = composerStartRestartGroup;
                    NavigationItemKt.m3902AnimatedNavigationItemDQd_Gtc(z, function0, function4, ShapesKt.getValue(NavigationRailBaselineItemTokens.INSTANCE.getActiveIndicatorShape(), composerStartRestartGroup, 6), NavigationRailVerticalItemTokens.INSTANCE.m5589getActiveIndicatorWidthD9Ej5fM(), TypographyKt.getValue(NavigationRailVerticalItemTokens.INSTANCE.getLabelTextFont(), composerStartRestartGroup, 6), TypographyKt.getValue(NavigationRailHorizontalItemTokens.INSTANCE.getLabelTextFont(), composerStartRestartGroup, 6), ItemTopIconIndicatorHorizontalPadding, ItemTopIconIndicatorVerticalPadding, NavigationRailVerticalItemTokens.INSTANCE.m5590getIconLabelSpaceD9Ej5fM(), NavigationRailHorizontalItemTokens.INSTANCE.m5584getFullWidthLeadingSpaceD9Ej5fM(), ItemStartIconIndicatorVerticalPadding, WNRItemNoLabelIndicatorPadding, NavigationRailHorizontalItemTokens.INSTANCE.m5586getIconLabelSpaceD9Ej5fM(), ItemHorizontalPadding, navigationItemColors5, modifier6, z9, function5, i110, mutableInteractionSource4, composer2, (i12 & 14) | 918577152 | (i12 & 112) | (i12 & 896), ((i12 >> 9) & 458752) | 28086 | (3670016 & i111) | (i111 & 29360128) | ((i12 << 15) & 234881024) | ((i12 << 6) & C.ENCODING_PCM_DOUBLE), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    mutableInteractionSource2 = mutableInteractionSource3;
                    navigationItemColors2 = navigationItemColors5;
                    modifier3 = modifier6;
                    z6 = z9;
                    i10 = i110;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    modifier3 = modifier2;
                    z6 = z4;
                    i10 = iM4835iconPositionFors8pcRp0;
                    navigationItemColors2 = navigationItemColorsColors;
                    mutableInteractionSource2 = mutableInteractionSource;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.WideNavigationRailKt$$ExternalSyntheticLambda11
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return WideNavigationRailKt.WideNavigationRailItem_pli_t6k$lambda$1(z, function0, function2, function3, z2, modifier3, z6, i10, navigationItemColors2, mutableInteractionSource2, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i4 |= 1572864;
            z4 = z3;
            if ((12582912 & i2) == 0) {
                if ((i3 & 128) == 0) {
                    iM4835iconPositionFors8pcRp0 = i;
                    if (composerStartRestartGroup.changed(iM4835iconPositionFors8pcRp0)) {
                    }
                    i4 |= i14;
                } else {
                    iM4835iconPositionFors8pcRp0 = i;
                }
                i4 |= i14;
            } else {
                iM4835iconPositionFors8pcRp0 = i;
            }
            if ((100663296 & i2) == 0) {
                if ((i3 & 256) == 0) {
                    navigationItemColorsColors = navigationItemColors;
                    if (composerStartRestartGroup.changed(navigationItemColorsColors)) {
                    }
                    i4 |= i15;
                } else {
                    navigationItemColorsColors = navigationItemColors;
                }
                i4 |= i15;
            } else {
                navigationItemColorsColors = navigationItemColors;
            }
            i7 = i3 & 512;
            if (i7 != 0) {
                if ((i2 & 805306368) == 0) {
                    if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                        i8 = C.BUFFER_FLAG_LAST_SAMPLE;
                    } else {
                        i8 = 268435456;
                    }
                    i4 |= i8;
                }
                i9 = i4;
                if ((i4 & 306783379) != 306783378) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z5, i9 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "702@34147L8");
                    if ((i2 & 1) != 0) {
                        if (i13 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i5 != 0) {
                            z4 = true;
                        }
                        if ((i3 & 128) != 0) {
                            i11 = i9 & (-29360129);
                            iM4835iconPositionFors8pcRp0 = WideNavigationRailItemDefaults.INSTANCE.m4835iconPositionFors8pcRp0(z2);
                        } else {
                            i11 = i9;
                        }
                        if ((i3 & 256) != 0) {
                            i11 &= -234881025;
                            navigationItemColorsColors = WideNavigationRailItemDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                        }
                        i12 = i11;
                        if (i7 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                    } else {
                        if (i13 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i5 != 0) {
                            z4 = true;
                        }
                        if ((i3 & 128) != 0) {
                            i11 = i9 & (-29360129);
                            iM4835iconPositionFors8pcRp0 = WideNavigationRailItemDefaults.INSTANCE.m4835iconPositionFors8pcRp0(z2);
                        } else {
                            i11 = i9;
                        }
                        if ((i3 & 256) != 0) {
                            i11 &= -234881025;
                            navigationItemColorsColors = WideNavigationRailItemDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                        }
                        i12 = i11;
                        if (i7 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                    }
                    Modifier modifier7 = modifier2;
                    boolean z10 = z4;
                    int i112 = iM4835iconPositionFors8pcRp0;
                    NavigationItemColors navigationItemColors6 = navigationItemColorsColors;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1894733304, i12, -1, "androidx.compose.material3.WideNavigationRailItem (WideNavigationRail.kt:704)");
                    }
                    if (mutableInteractionSource3 == null) {
                        composerStartRestartGroup.startReplaceGroup(-1539084813);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "706@34299L39");
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 227446767, "CC(remember):WideNavigationRail.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.endReplaceGroup();
                        mutableInteractionSource4 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        composerStartRestartGroup.startReplaceGroup(227446116);
                        composerStartRestartGroup.endReplaceGroup();
                        mutableInteractionSource4 = mutableInteractionSource3;
                    }
                    int i113 = i12 << 3;
                    composer2 = composerStartRestartGroup;
                    NavigationItemKt.m3902AnimatedNavigationItemDQd_Gtc(z, function0, function4, ShapesKt.getValue(NavigationRailBaselineItemTokens.INSTANCE.getActiveIndicatorShape(), composerStartRestartGroup, 6), NavigationRailVerticalItemTokens.INSTANCE.m5589getActiveIndicatorWidthD9Ej5fM(), TypographyKt.getValue(NavigationRailVerticalItemTokens.INSTANCE.getLabelTextFont(), composerStartRestartGroup, 6), TypographyKt.getValue(NavigationRailHorizontalItemTokens.INSTANCE.getLabelTextFont(), composerStartRestartGroup, 6), ItemTopIconIndicatorHorizontalPadding, ItemTopIconIndicatorVerticalPadding, NavigationRailVerticalItemTokens.INSTANCE.m5590getIconLabelSpaceD9Ej5fM(), NavigationRailHorizontalItemTokens.INSTANCE.m5584getFullWidthLeadingSpaceD9Ej5fM(), ItemStartIconIndicatorVerticalPadding, WNRItemNoLabelIndicatorPadding, NavigationRailHorizontalItemTokens.INSTANCE.m5586getIconLabelSpaceD9Ej5fM(), ItemHorizontalPadding, navigationItemColors6, modifier7, z10, function5, i112, mutableInteractionSource4, composer2, (i12 & 14) | 918577152 | (i12 & 112) | (i12 & 896), ((i12 >> 9) & 458752) | 28086 | (3670016 & i113) | (i113 & 29360128) | ((i12 << 15) & 234881024) | ((i12 << 6) & C.ENCODING_PCM_DOUBLE), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    mutableInteractionSource2 = mutableInteractionSource3;
                    navigationItemColors2 = navigationItemColors6;
                    modifier3 = modifier7;
                    z6 = z10;
                    i10 = i112;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    modifier3 = modifier2;
                    z6 = z4;
                    i10 = iM4835iconPositionFors8pcRp0;
                    navigationItemColors2 = navigationItemColorsColors;
                    mutableInteractionSource2 = mutableInteractionSource;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.WideNavigationRailKt$$ExternalSyntheticLambda11
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return WideNavigationRailKt.WideNavigationRailItem_pli_t6k$lambda$1(z, function0, function2, function3, z2, modifier3, z6, i10, navigationItemColors2, mutableInteractionSource2, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i4 |= 805306368;
            i9 = i4;
            if ((i4 & 306783379) != 306783378) {
                z5 = true;
            } else {
                z5 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z5, i9 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "702@34147L8");
                if ((i2 & 1) != 0) {
                    if (i13 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i5 != 0) {
                        z4 = true;
                    }
                    if ((i3 & 128) != 0) {
                        i11 = i9 & (-29360129);
                        iM4835iconPositionFors8pcRp0 = WideNavigationRailItemDefaults.INSTANCE.m4835iconPositionFors8pcRp0(z2);
                    } else {
                        i11 = i9;
                    }
                    if ((i3 & 256) != 0) {
                        i11 &= -234881025;
                        navigationItemColorsColors = WideNavigationRailItemDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                    }
                    i12 = i11;
                    if (i7 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                } else {
                    if (i13 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i5 != 0) {
                        z4 = true;
                    }
                    if ((i3 & 128) != 0) {
                        i11 = i9 & (-29360129);
                        iM4835iconPositionFors8pcRp0 = WideNavigationRailItemDefaults.INSTANCE.m4835iconPositionFors8pcRp0(z2);
                    } else {
                        i11 = i9;
                    }
                    if ((i3 & 256) != 0) {
                        i11 &= -234881025;
                        navigationItemColorsColors = WideNavigationRailItemDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                    }
                    i12 = i11;
                    if (i7 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                }
                Modifier modifier8 = modifier2;
                boolean z11 = z4;
                int i114 = iM4835iconPositionFors8pcRp0;
                NavigationItemColors navigationItemColors7 = navigationItemColorsColors;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1894733304, i12, -1, "androidx.compose.material3.WideNavigationRailItem (WideNavigationRail.kt:704)");
                }
                if (mutableInteractionSource3 == null) {
                    composerStartRestartGroup.startReplaceGroup(-1539084813);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "706@34299L39");
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 227446767, "CC(remember):WideNavigationRail.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endReplaceGroup();
                    mutableInteractionSource4 = (MutableInteractionSource) objRememberedValue;
                } else {
                    composerStartRestartGroup.startReplaceGroup(227446116);
                    composerStartRestartGroup.endReplaceGroup();
                    mutableInteractionSource4 = mutableInteractionSource3;
                }
                int i115 = i12 << 3;
                composer2 = composerStartRestartGroup;
                NavigationItemKt.m3902AnimatedNavigationItemDQd_Gtc(z, function0, function4, ShapesKt.getValue(NavigationRailBaselineItemTokens.INSTANCE.getActiveIndicatorShape(), composerStartRestartGroup, 6), NavigationRailVerticalItemTokens.INSTANCE.m5589getActiveIndicatorWidthD9Ej5fM(), TypographyKt.getValue(NavigationRailVerticalItemTokens.INSTANCE.getLabelTextFont(), composerStartRestartGroup, 6), TypographyKt.getValue(NavigationRailHorizontalItemTokens.INSTANCE.getLabelTextFont(), composerStartRestartGroup, 6), ItemTopIconIndicatorHorizontalPadding, ItemTopIconIndicatorVerticalPadding, NavigationRailVerticalItemTokens.INSTANCE.m5590getIconLabelSpaceD9Ej5fM(), NavigationRailHorizontalItemTokens.INSTANCE.m5584getFullWidthLeadingSpaceD9Ej5fM(), ItemStartIconIndicatorVerticalPadding, WNRItemNoLabelIndicatorPadding, NavigationRailHorizontalItemTokens.INSTANCE.m5586getIconLabelSpaceD9Ej5fM(), ItemHorizontalPadding, navigationItemColors7, modifier8, z11, function5, i114, mutableInteractionSource4, composer2, (i12 & 14) | 918577152 | (i12 & 112) | (i12 & 896), ((i12 >> 9) & 458752) | 28086 | (3670016 & i115) | (i115 & 29360128) | ((i12 << 15) & 234881024) | ((i12 << 6) & C.ENCODING_PCM_DOUBLE), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                mutableInteractionSource2 = mutableInteractionSource3;
                navigationItemColors2 = navigationItemColors7;
                modifier3 = modifier8;
                z6 = z11;
                i10 = i114;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier3 = modifier2;
                z6 = z4;
                i10 = iM4835iconPositionFors8pcRp0;
                navigationItemColors2 = navigationItemColorsColors;
                mutableInteractionSource2 = mutableInteractionSource;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.WideNavigationRailKt$$ExternalSyntheticLambda11
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return WideNavigationRailKt.WideNavigationRailItem_pli_t6k$lambda$1(z, function0, function2, function3, z2, modifier3, z6, i10, navigationItemColors2, mutableInteractionSource2, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        modifier2 = modifier;
        i5 = i3 & 64;
        if (i5 != 0) {
            if ((1572864 & i2) == 0) {
                z4 = z3;
                if (composerStartRestartGroup.changed(z4)) {
                    i6 = 1048576;
                } else {
                    i6 = 524288;
                }
                i4 |= i6;
            }
            if ((12582912 & i2) == 0) {
                if ((i3 & 128) == 0) {
                    iM4835iconPositionFors8pcRp0 = i;
                    if (composerStartRestartGroup.changed(iM4835iconPositionFors8pcRp0)) {
                    }
                    i4 |= i14;
                } else {
                    iM4835iconPositionFors8pcRp0 = i;
                }
                i4 |= i14;
            } else {
                iM4835iconPositionFors8pcRp0 = i;
            }
            if ((100663296 & i2) == 0) {
                if ((i3 & 256) == 0) {
                    navigationItemColorsColors = navigationItemColors;
                    if (composerStartRestartGroup.changed(navigationItemColorsColors)) {
                    }
                    i4 |= i15;
                } else {
                    navigationItemColorsColors = navigationItemColors;
                }
                i4 |= i15;
            } else {
                navigationItemColorsColors = navigationItemColors;
            }
            i7 = i3 & 512;
            if (i7 != 0) {
                if ((i2 & 805306368) == 0) {
                    if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                        i8 = C.BUFFER_FLAG_LAST_SAMPLE;
                    } else {
                        i8 = 268435456;
                    }
                    i4 |= i8;
                }
                i9 = i4;
                if ((i4 & 306783379) != 306783378) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z5, i9 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "702@34147L8");
                    if ((i2 & 1) != 0) {
                        if (i13 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i5 != 0) {
                            z4 = true;
                        }
                        if ((i3 & 128) != 0) {
                            i11 = i9 & (-29360129);
                            iM4835iconPositionFors8pcRp0 = WideNavigationRailItemDefaults.INSTANCE.m4835iconPositionFors8pcRp0(z2);
                        } else {
                            i11 = i9;
                        }
                        if ((i3 & 256) != 0) {
                            i11 &= -234881025;
                            navigationItemColorsColors = WideNavigationRailItemDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                        }
                        i12 = i11;
                        if (i7 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                    } else {
                        if (i13 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i5 != 0) {
                            z4 = true;
                        }
                        if ((i3 & 128) != 0) {
                            i11 = i9 & (-29360129);
                            iM4835iconPositionFors8pcRp0 = WideNavigationRailItemDefaults.INSTANCE.m4835iconPositionFors8pcRp0(z2);
                        } else {
                            i11 = i9;
                        }
                        if ((i3 & 256) != 0) {
                            i11 &= -234881025;
                            navigationItemColorsColors = WideNavigationRailItemDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                        }
                        i12 = i11;
                        if (i7 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                    }
                    Modifier modifier9 = modifier2;
                    boolean z12 = z4;
                    int i116 = iM4835iconPositionFors8pcRp0;
                    NavigationItemColors navigationItemColors8 = navigationItemColorsColors;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1894733304, i12, -1, "androidx.compose.material3.WideNavigationRailItem (WideNavigationRail.kt:704)");
                    }
                    if (mutableInteractionSource3 == null) {
                        composerStartRestartGroup.startReplaceGroup(-1539084813);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "706@34299L39");
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 227446767, "CC(remember):WideNavigationRail.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.endReplaceGroup();
                        mutableInteractionSource4 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        composerStartRestartGroup.startReplaceGroup(227446116);
                        composerStartRestartGroup.endReplaceGroup();
                        mutableInteractionSource4 = mutableInteractionSource3;
                    }
                    int i117 = i12 << 3;
                    composer2 = composerStartRestartGroup;
                    NavigationItemKt.m3902AnimatedNavigationItemDQd_Gtc(z, function0, function4, ShapesKt.getValue(NavigationRailBaselineItemTokens.INSTANCE.getActiveIndicatorShape(), composerStartRestartGroup, 6), NavigationRailVerticalItemTokens.INSTANCE.m5589getActiveIndicatorWidthD9Ej5fM(), TypographyKt.getValue(NavigationRailVerticalItemTokens.INSTANCE.getLabelTextFont(), composerStartRestartGroup, 6), TypographyKt.getValue(NavigationRailHorizontalItemTokens.INSTANCE.getLabelTextFont(), composerStartRestartGroup, 6), ItemTopIconIndicatorHorizontalPadding, ItemTopIconIndicatorVerticalPadding, NavigationRailVerticalItemTokens.INSTANCE.m5590getIconLabelSpaceD9Ej5fM(), NavigationRailHorizontalItemTokens.INSTANCE.m5584getFullWidthLeadingSpaceD9Ej5fM(), ItemStartIconIndicatorVerticalPadding, WNRItemNoLabelIndicatorPadding, NavigationRailHorizontalItemTokens.INSTANCE.m5586getIconLabelSpaceD9Ej5fM(), ItemHorizontalPadding, navigationItemColors8, modifier9, z12, function5, i116, mutableInteractionSource4, composer2, (i12 & 14) | 918577152 | (i12 & 112) | (i12 & 896), ((i12 >> 9) & 458752) | 28086 | (3670016 & i117) | (i117 & 29360128) | ((i12 << 15) & 234881024) | ((i12 << 6) & C.ENCODING_PCM_DOUBLE), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    mutableInteractionSource2 = mutableInteractionSource3;
                    navigationItemColors2 = navigationItemColors8;
                    modifier3 = modifier9;
                    z6 = z12;
                    i10 = i116;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    modifier3 = modifier2;
                    z6 = z4;
                    i10 = iM4835iconPositionFors8pcRp0;
                    navigationItemColors2 = navigationItemColorsColors;
                    mutableInteractionSource2 = mutableInteractionSource;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.WideNavigationRailKt$$ExternalSyntheticLambda11
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return WideNavigationRailKt.WideNavigationRailItem_pli_t6k$lambda$1(z, function0, function2, function3, z2, modifier3, z6, i10, navigationItemColors2, mutableInteractionSource2, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i4 |= 805306368;
            i9 = i4;
            if ((i4 & 306783379) != 306783378) {
                z5 = true;
            } else {
                z5 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z5, i9 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "702@34147L8");
                if ((i2 & 1) != 0) {
                    if (i13 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i5 != 0) {
                        z4 = true;
                    }
                    if ((i3 & 128) != 0) {
                        i11 = i9 & (-29360129);
                        iM4835iconPositionFors8pcRp0 = WideNavigationRailItemDefaults.INSTANCE.m4835iconPositionFors8pcRp0(z2);
                    } else {
                        i11 = i9;
                    }
                    if ((i3 & 256) != 0) {
                        i11 &= -234881025;
                        navigationItemColorsColors = WideNavigationRailItemDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                    }
                    i12 = i11;
                    if (i7 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                } else {
                    if (i13 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i5 != 0) {
                        z4 = true;
                    }
                    if ((i3 & 128) != 0) {
                        i11 = i9 & (-29360129);
                        iM4835iconPositionFors8pcRp0 = WideNavigationRailItemDefaults.INSTANCE.m4835iconPositionFors8pcRp0(z2);
                    } else {
                        i11 = i9;
                    }
                    if ((i3 & 256) != 0) {
                        i11 &= -234881025;
                        navigationItemColorsColors = WideNavigationRailItemDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                    }
                    i12 = i11;
                    if (i7 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                }
                Modifier modifier10 = modifier2;
                boolean z13 = z4;
                int i118 = iM4835iconPositionFors8pcRp0;
                NavigationItemColors navigationItemColors9 = navigationItemColorsColors;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1894733304, i12, -1, "androidx.compose.material3.WideNavigationRailItem (WideNavigationRail.kt:704)");
                }
                if (mutableInteractionSource3 == null) {
                    composerStartRestartGroup.startReplaceGroup(-1539084813);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "706@34299L39");
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 227446767, "CC(remember):WideNavigationRail.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endReplaceGroup();
                    mutableInteractionSource4 = (MutableInteractionSource) objRememberedValue;
                } else {
                    composerStartRestartGroup.startReplaceGroup(227446116);
                    composerStartRestartGroup.endReplaceGroup();
                    mutableInteractionSource4 = mutableInteractionSource3;
                }
                int i119 = i12 << 3;
                composer2 = composerStartRestartGroup;
                NavigationItemKt.m3902AnimatedNavigationItemDQd_Gtc(z, function0, function4, ShapesKt.getValue(NavigationRailBaselineItemTokens.INSTANCE.getActiveIndicatorShape(), composerStartRestartGroup, 6), NavigationRailVerticalItemTokens.INSTANCE.m5589getActiveIndicatorWidthD9Ej5fM(), TypographyKt.getValue(NavigationRailVerticalItemTokens.INSTANCE.getLabelTextFont(), composerStartRestartGroup, 6), TypographyKt.getValue(NavigationRailHorizontalItemTokens.INSTANCE.getLabelTextFont(), composerStartRestartGroup, 6), ItemTopIconIndicatorHorizontalPadding, ItemTopIconIndicatorVerticalPadding, NavigationRailVerticalItemTokens.INSTANCE.m5590getIconLabelSpaceD9Ej5fM(), NavigationRailHorizontalItemTokens.INSTANCE.m5584getFullWidthLeadingSpaceD9Ej5fM(), ItemStartIconIndicatorVerticalPadding, WNRItemNoLabelIndicatorPadding, NavigationRailHorizontalItemTokens.INSTANCE.m5586getIconLabelSpaceD9Ej5fM(), ItemHorizontalPadding, navigationItemColors9, modifier10, z13, function5, i118, mutableInteractionSource4, composer2, (i12 & 14) | 918577152 | (i12 & 112) | (i12 & 896), ((i12 >> 9) & 458752) | 28086 | (3670016 & i119) | (i119 & 29360128) | ((i12 << 15) & 234881024) | ((i12 << 6) & C.ENCODING_PCM_DOUBLE), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                mutableInteractionSource2 = mutableInteractionSource3;
                navigationItemColors2 = navigationItemColors9;
                modifier3 = modifier10;
                z6 = z13;
                i10 = i118;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier3 = modifier2;
                z6 = z4;
                i10 = iM4835iconPositionFors8pcRp0;
                navigationItemColors2 = navigationItemColorsColors;
                mutableInteractionSource2 = mutableInteractionSource;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.WideNavigationRailKt$$ExternalSyntheticLambda11
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return WideNavigationRailKt.WideNavigationRailItem_pli_t6k$lambda$1(z, function0, function2, function3, z2, modifier3, z6, i10, navigationItemColors2, mutableInteractionSource2, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i4 |= 1572864;
        z4 = z3;
        if ((12582912 & i2) == 0) {
            if ((i3 & 128) == 0) {
                iM4835iconPositionFors8pcRp0 = i;
                if (composerStartRestartGroup.changed(iM4835iconPositionFors8pcRp0)) {
                }
                i4 |= i14;
            } else {
                iM4835iconPositionFors8pcRp0 = i;
            }
            i4 |= i14;
        } else {
            iM4835iconPositionFors8pcRp0 = i;
        }
        if ((100663296 & i2) == 0) {
            if ((i3 & 256) == 0) {
                navigationItemColorsColors = navigationItemColors;
                if (composerStartRestartGroup.changed(navigationItemColorsColors)) {
                }
                i4 |= i15;
            } else {
                navigationItemColorsColors = navigationItemColors;
            }
            i4 |= i15;
        } else {
            navigationItemColorsColors = navigationItemColors;
        }
        i7 = i3 & 512;
        if (i7 != 0) {
            if ((i2 & 805306368) == 0) {
                if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                    i8 = C.BUFFER_FLAG_LAST_SAMPLE;
                } else {
                    i8 = 268435456;
                }
                i4 |= i8;
            }
            i9 = i4;
            if ((i4 & 306783379) != 306783378) {
                z5 = true;
            } else {
                z5 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z5, i9 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "702@34147L8");
                if ((i2 & 1) != 0) {
                    if (i13 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i5 != 0) {
                        z4 = true;
                    }
                    if ((i3 & 128) != 0) {
                        i11 = i9 & (-29360129);
                        iM4835iconPositionFors8pcRp0 = WideNavigationRailItemDefaults.INSTANCE.m4835iconPositionFors8pcRp0(z2);
                    } else {
                        i11 = i9;
                    }
                    if ((i3 & 256) != 0) {
                        i11 &= -234881025;
                        navigationItemColorsColors = WideNavigationRailItemDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                    }
                    i12 = i11;
                    if (i7 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                } else {
                    if (i13 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i5 != 0) {
                        z4 = true;
                    }
                    if ((i3 & 128) != 0) {
                        i11 = i9 & (-29360129);
                        iM4835iconPositionFors8pcRp0 = WideNavigationRailItemDefaults.INSTANCE.m4835iconPositionFors8pcRp0(z2);
                    } else {
                        i11 = i9;
                    }
                    if ((i3 & 256) != 0) {
                        i11 &= -234881025;
                        navigationItemColorsColors = WideNavigationRailItemDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                    }
                    i12 = i11;
                    if (i7 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                }
                Modifier modifier11 = modifier2;
                boolean z14 = z4;
                int i1110 = iM4835iconPositionFors8pcRp0;
                NavigationItemColors navigationItemColors10 = navigationItemColorsColors;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1894733304, i12, -1, "androidx.compose.material3.WideNavigationRailItem (WideNavigationRail.kt:704)");
                }
                if (mutableInteractionSource3 == null) {
                    composerStartRestartGroup.startReplaceGroup(-1539084813);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "706@34299L39");
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 227446767, "CC(remember):WideNavigationRail.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endReplaceGroup();
                    mutableInteractionSource4 = (MutableInteractionSource) objRememberedValue;
                } else {
                    composerStartRestartGroup.startReplaceGroup(227446116);
                    composerStartRestartGroup.endReplaceGroup();
                    mutableInteractionSource4 = mutableInteractionSource3;
                }
                int i1111 = i12 << 3;
                composer2 = composerStartRestartGroup;
                NavigationItemKt.m3902AnimatedNavigationItemDQd_Gtc(z, function0, function4, ShapesKt.getValue(NavigationRailBaselineItemTokens.INSTANCE.getActiveIndicatorShape(), composerStartRestartGroup, 6), NavigationRailVerticalItemTokens.INSTANCE.m5589getActiveIndicatorWidthD9Ej5fM(), TypographyKt.getValue(NavigationRailVerticalItemTokens.INSTANCE.getLabelTextFont(), composerStartRestartGroup, 6), TypographyKt.getValue(NavigationRailHorizontalItemTokens.INSTANCE.getLabelTextFont(), composerStartRestartGroup, 6), ItemTopIconIndicatorHorizontalPadding, ItemTopIconIndicatorVerticalPadding, NavigationRailVerticalItemTokens.INSTANCE.m5590getIconLabelSpaceD9Ej5fM(), NavigationRailHorizontalItemTokens.INSTANCE.m5584getFullWidthLeadingSpaceD9Ej5fM(), ItemStartIconIndicatorVerticalPadding, WNRItemNoLabelIndicatorPadding, NavigationRailHorizontalItemTokens.INSTANCE.m5586getIconLabelSpaceD9Ej5fM(), ItemHorizontalPadding, navigationItemColors10, modifier11, z14, function5, i1110, mutableInteractionSource4, composer2, (i12 & 14) | 918577152 | (i12 & 112) | (i12 & 896), ((i12 >> 9) & 458752) | 28086 | (3670016 & i1111) | (i1111 & 29360128) | ((i12 << 15) & 234881024) | ((i12 << 6) & C.ENCODING_PCM_DOUBLE), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                mutableInteractionSource2 = mutableInteractionSource3;
                navigationItemColors2 = navigationItemColors10;
                modifier3 = modifier11;
                z6 = z14;
                i10 = i1110;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier3 = modifier2;
                z6 = z4;
                i10 = iM4835iconPositionFors8pcRp0;
                navigationItemColors2 = navigationItemColorsColors;
                mutableInteractionSource2 = mutableInteractionSource;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.WideNavigationRailKt$$ExternalSyntheticLambda11
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return WideNavigationRailKt.WideNavigationRailItem_pli_t6k$lambda$1(z, function0, function2, function3, z2, modifier3, z6, i10, navigationItemColors2, mutableInteractionSource2, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i4 |= 805306368;
        i9 = i4;
        if ((i4 & 306783379) != 306783378) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z5, i9 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "702@34147L8");
            if ((i2 & 1) != 0) {
                if (i13 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i5 != 0) {
                    z4 = true;
                }
                if ((i3 & 128) != 0) {
                    i11 = i9 & (-29360129);
                    iM4835iconPositionFors8pcRp0 = WideNavigationRailItemDefaults.INSTANCE.m4835iconPositionFors8pcRp0(z2);
                } else {
                    i11 = i9;
                }
                if ((i3 & 256) != 0) {
                    i11 &= -234881025;
                    navigationItemColorsColors = WideNavigationRailItemDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                }
                i12 = i11;
                if (i7 != 0) {
                    mutableInteractionSource3 = null;
                } else {
                    mutableInteractionSource3 = mutableInteractionSource;
                }
            } else {
                if (i13 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i5 != 0) {
                    z4 = true;
                }
                if ((i3 & 128) != 0) {
                    i11 = i9 & (-29360129);
                    iM4835iconPositionFors8pcRp0 = WideNavigationRailItemDefaults.INSTANCE.m4835iconPositionFors8pcRp0(z2);
                } else {
                    i11 = i9;
                }
                if ((i3 & 256) != 0) {
                    i11 &= -234881025;
                    navigationItemColorsColors = WideNavigationRailItemDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                }
                i12 = i11;
                if (i7 != 0) {
                    mutableInteractionSource3 = null;
                } else {
                    mutableInteractionSource3 = mutableInteractionSource;
                }
            }
            Modifier modifier12 = modifier2;
            boolean z15 = z4;
            int i1112 = iM4835iconPositionFors8pcRp0;
            NavigationItemColors navigationItemColors11 = navigationItemColorsColors;
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1894733304, i12, -1, "androidx.compose.material3.WideNavigationRailItem (WideNavigationRail.kt:704)");
            }
            if (mutableInteractionSource3 == null) {
                composerStartRestartGroup.startReplaceGroup(-1539084813);
                ComposerKt.sourceInformation(composerStartRestartGroup, "706@34299L39");
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 227446767, "CC(remember):WideNavigationRail.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endReplaceGroup();
                mutableInteractionSource4 = (MutableInteractionSource) objRememberedValue;
            } else {
                composerStartRestartGroup.startReplaceGroup(227446116);
                composerStartRestartGroup.endReplaceGroup();
                mutableInteractionSource4 = mutableInteractionSource3;
            }
            int i1113 = i12 << 3;
            composer2 = composerStartRestartGroup;
            NavigationItemKt.m3902AnimatedNavigationItemDQd_Gtc(z, function0, function4, ShapesKt.getValue(NavigationRailBaselineItemTokens.INSTANCE.getActiveIndicatorShape(), composerStartRestartGroup, 6), NavigationRailVerticalItemTokens.INSTANCE.m5589getActiveIndicatorWidthD9Ej5fM(), TypographyKt.getValue(NavigationRailVerticalItemTokens.INSTANCE.getLabelTextFont(), composerStartRestartGroup, 6), TypographyKt.getValue(NavigationRailHorizontalItemTokens.INSTANCE.getLabelTextFont(), composerStartRestartGroup, 6), ItemTopIconIndicatorHorizontalPadding, ItemTopIconIndicatorVerticalPadding, NavigationRailVerticalItemTokens.INSTANCE.m5590getIconLabelSpaceD9Ej5fM(), NavigationRailHorizontalItemTokens.INSTANCE.m5584getFullWidthLeadingSpaceD9Ej5fM(), ItemStartIconIndicatorVerticalPadding, WNRItemNoLabelIndicatorPadding, NavigationRailHorizontalItemTokens.INSTANCE.m5586getIconLabelSpaceD9Ej5fM(), ItemHorizontalPadding, navigationItemColors11, modifier12, z15, function5, i1112, mutableInteractionSource4, composer2, (i12 & 14) | 918577152 | (i12 & 112) | (i12 & 896), ((i12 >> 9) & 458752) | 28086 | (3670016 & i1113) | (i1113 & 29360128) | ((i12 << 15) & 234881024) | ((i12 << 6) & C.ENCODING_PCM_DOUBLE), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            mutableInteractionSource2 = mutableInteractionSource3;
            navigationItemColors2 = navigationItemColors11;
            modifier3 = modifier12;
            z6 = z15;
            i10 = i1112;
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            modifier3 = modifier2;
            z6 = z4;
            i10 = iM4835iconPositionFors8pcRp0;
            navigationItemColors2 = navigationItemColorsColors;
            mutableInteractionSource2 = mutableInteractionSource;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.WideNavigationRailKt$$ExternalSyntheticLambda11
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return WideNavigationRailKt.WideNavigationRailItem_pli_t6k$lambda$1(z, function0, function2, function3, z2, modifier3, z6, i10, navigationItemColors2, mutableInteractionSource2, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0122  */
    /* JADX WARN: Code duplicated, block: B:102:0x0125  */
    /* JADX WARN: Code duplicated, block: B:105:0x012f  */
    /* JADX WARN: Code duplicated, block: B:107:0x0141  */
    /* JADX WARN: Code duplicated, block: B:119:0x0166 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:120:0x0168  */
    /* JADX WARN: Code duplicated, block: B:123:0x0170  */
    /* JADX WARN: Code duplicated, block: B:125:0x0174  */
    /* JADX WARN: Code duplicated, block: B:128:0x017a  */
    /* JADX WARN: Code duplicated, block: B:129:0x0184  */
    /* JADX WARN: Code duplicated, block: B:132:0x018a  */
    /* JADX WARN: Code duplicated, block: B:133:0x0194  */
    /* JADX WARN: Code duplicated, block: B:135:0x0198  */
    /* JADX WARN: Code duplicated, block: B:136:0x019e  */
    /* JADX WARN: Code duplicated, block: B:140:0x01af  */
    /* JADX WARN: Code duplicated, block: B:143:0x01e9  */
    /* JADX WARN: Code duplicated, block: B:145:0x01f9  */
    /* JADX WARN: Code duplicated, block: B:148:0x020c  */
    /* JADX WARN: Code duplicated, block: B:150:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:46:0x0082  */
    /* JADX WARN: Code duplicated, block: B:47:0x0084  */
    /* JADX WARN: Code duplicated, block: B:49:0x0087  */
    /* JADX WARN: Code duplicated, block: B:51:0x008f  */
    /* JADX WARN: Code duplicated, block: B:52:0x0092  */
    /* JADX WARN: Code duplicated, block: B:57:0x009e  */
    /* JADX WARN: Code duplicated, block: B:58:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:60:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:62:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:63:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:68:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:70:0x00bd  */
    /* JADX WARN: Code duplicated, block: B:72:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:73:0x00c8  */
    /* JADX WARN: Code duplicated, block: B:76:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:79:0x00d7  */
    /* JADX WARN: Code duplicated, block: B:81:0x00db  */
    /* JADX WARN: Code duplicated, block: B:84:0x00e6 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:87:0x00ed  */
    /* JADX WARN: Code duplicated, block: B:90:0x00f5  */
    /* JADX WARN: Code duplicated, block: B:91:0x00f8  */
    /* JADX WARN: Code duplicated, block: B:93:0x00fc  */
    /* JADX WARN: Code duplicated, block: B:95:0x0106  */
    /* JADX WARN: Code duplicated, block: B:96:0x0109  */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Deprecated in favor of function with required railExpanded parameter")
    /* JADX INFO: renamed from: WideNavigationRailItem-pli-t6k, reason: not valid java name */
    public static final /* synthetic */ void m4845WideNavigationRailItemplit6k(final boolean z, final Function0 function0, final Function2 function2, final Function2 function3, Modifier modifier, boolean z2, boolean z3, int i, NavigationItemColors navigationItemColors, MutableInteractionSource mutableInteractionSource, Composer composer, final int i2, final int i3) {
        int i4;
        Function2 function4;
        Function2 function5;
        Modifier modifier2;
        int i5;
        boolean z4;
        int i6;
        int i7;
        boolean z5;
        int i8;
        int iM4835iconPositionFors8pcRp0;
        int i9;
        int i10;
        int i11;
        boolean z6;
        Composer composer2;
        final NavigationItemColors navigationItemColors2;
        final Modifier modifier3;
        final boolean z7;
        final boolean z8;
        final int i12;
        final MutableInteractionSource mutableInteractionSource2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        boolean z9;
        int i13;
        NavigationItemColors navigationItemColorsColors;
        MutableInteractionSource mutableInteractionSource3;
        int i14;
        Modifier modifier4;
        Composer composerStartRestartGroup = composer.startRestartGroup(1198748736);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(WideNavigationRailItem)N(selected,onClick,icon,label,modifier,enabled,railExpanded,iconPosition:c#material3.NavigationItemIconPosition,colors,interactionSource)787@38477L215:WideNavigationRail.kt#uh7d8r");
        if ((i2 & 6) == 0) {
            i4 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i2;
        } else {
            i4 = i2;
        }
        if ((i2 & 48) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(function0) ? 32 : 16;
        }
        if ((i2 & 384) == 0) {
            function4 = function2;
            i4 |= composerStartRestartGroup.changedInstance(function4) ? 256 : 128;
        } else {
            function4 = function2;
        }
        if ((i2 & 3072) == 0) {
            function5 = function3;
            i4 |= composerStartRestartGroup.changedInstance(function5) ? 2048 : 1024;
        } else {
            function5 = function3;
        }
        int i15 = i3 & 16;
        if (i15 == 0) {
            if ((i2 & 24576) == 0) {
                modifier2 = modifier;
                i4 |= composerStartRestartGroup.changed(modifier2) ? 16384 : 8192;
            }
            i5 = i3 & 32;
            if (i5 != 0) {
                if ((196608 & i2) == 0) {
                    z4 = z2;
                    if (composerStartRestartGroup.changed(z4)) {
                        i6 = 131072;
                    } else {
                        i6 = 65536;
                    }
                    i4 |= i6;
                }
                i7 = i3 & 64;
                if (i7 != 0) {
                    if ((1572864 & i2) == 0) {
                        z5 = z3;
                        if (composerStartRestartGroup.changed(z5)) {
                            i8 = 1048576;
                        } else {
                            i8 = 524288;
                        }
                        i4 |= i8;
                    }
                    if ((12582912 & i2) == 0) {
                        if ((i3 & 128) == 0) {
                            iM4835iconPositionFors8pcRp0 = i;
                            int i16 = composerStartRestartGroup.changed(iM4835iconPositionFors8pcRp0) ? 8388608 : 4194304;
                            i4 |= i16;
                        } else {
                            iM4835iconPositionFors8pcRp0 = i;
                        }
                        i4 |= i16;
                    } else {
                        iM4835iconPositionFors8pcRp0 = i;
                    }
                    if ((i2 & 100663296) != 0) {
                        i4 |= ((i3 & 256) == 0 || !composerStartRestartGroup.changed(navigationItemColors)) ? 33554432 : 67108864;
                    }
                    i9 = i3 & 512;
                    if (i9 != 0) {
                        if ((i2 & 805306368) == 0) {
                            if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                                i10 = C.BUFFER_FLAG_LAST_SAMPLE;
                            } else {
                                i10 = 268435456;
                            }
                            i4 |= i10;
                        }
                        i11 = i4;
                        if ((i4 & 306783379) != 306783378) {
                            z6 = true;
                        } else {
                            z6 = false;
                        }
                        if (composerStartRestartGroup.shouldExecute(z6, i11 & 1)) {
                            composerStartRestartGroup.startDefaults();
                            ComposerKt.sourceInformation(composerStartRestartGroup, "784@38402L8");
                            if ((i2 & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                if (i15 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                z9 = i5 == 0 ? z4 : true;
                                if (i7 != 0) {
                                    z5 = false;
                                }
                                if ((i3 & 128) != 0) {
                                    i13 = i11 & (-29360129);
                                    iM4835iconPositionFors8pcRp0 = WideNavigationRailItemDefaults.INSTANCE.m4835iconPositionFors8pcRp0(z5);
                                } else {
                                    i13 = i11;
                                }
                                if ((i3 & 256) != 0) {
                                    navigationItemColorsColors = WideNavigationRailItemDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                                    i13 = (-234881025) & i13;
                                } else {
                                    navigationItemColorsColors = navigationItemColors;
                                }
                                if (i9 != 0) {
                                    mutableInteractionSource3 = null;
                                } else {
                                    mutableInteractionSource3 = mutableInteractionSource;
                                }
                                i14 = i13;
                                modifier4 = modifier2;
                            } else {
                                composerStartRestartGroup.skipToGroupEnd();
                                i14 = (i3 & 128) != 0 ? i11 & (-29360129) : i11;
                                if ((i3 & 256) != 0) {
                                    i14 &= -234881025;
                                }
                                navigationItemColorsColors = navigationItemColors;
                                mutableInteractionSource3 = mutableInteractionSource;
                                modifier4 = modifier2;
                                z9 = z4;
                            }
                            boolean z10 = z5;
                            int i17 = iM4835iconPositionFors8pcRp0;
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1198748736, i14, -1, "androidx.compose.material3.WideNavigationRailItem (WideNavigationRail.kt:787)");
                            }
                            int i18 = i14 << 3;
                            composer2 = composerStartRestartGroup;
                            m4846WideNavigationRailItemplit6k(z, (Function0<Unit>) function0, (Function2<? super Composer, ? super Integer, Unit>) function4, (Function2<? super Composer, ? super Integer, Unit>) function5, z10, modifier4, z9, i17, navigationItemColorsColors, mutableInteractionSource3, composer2, (i14 & 8190) | ((i14 >> 6) & 57344) | (458752 & i18) | (i18 & 3670016) | (29360128 & i14) | (234881024 & i14) | (i14 & C.ENCODING_PCM_DOUBLE), 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            z8 = z10;
                            modifier3 = modifier4;
                            z7 = z9;
                            i12 = i17;
                            navigationItemColors2 = navigationItemColorsColors;
                            mutableInteractionSource2 = mutableInteractionSource3;
                        } else {
                            composer2 = composerStartRestartGroup;
                            composer2.skipToGroupEnd();
                            navigationItemColors2 = navigationItemColors;
                            modifier3 = modifier2;
                            z7 = z4;
                            z8 = z5;
                            i12 = iM4835iconPositionFors8pcRp0;
                            mutableInteractionSource2 = mutableInteractionSource;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.WideNavigationRailKt$$ExternalSyntheticLambda19
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return WideNavigationRailKt.WideNavigationRailItem_pli_t6k$lambda$2(z, function0, function2, function3, modifier3, z7, z8, i12, navigationItemColors2, mutableInteractionSource2, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                        }
                    }
                    i4 |= 805306368;
                    i11 = i4;
                    if ((i4 & 306783379) != 306783378) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z6, i11 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "784@38402L8");
                        if ((i2 & 1) != 0) {
                            if (i15 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i5 == 0) {
                            }
                            if (i7 != 0) {
                                z5 = false;
                            }
                            if ((i3 & 128) != 0) {
                                i13 = i11 & (-29360129);
                                iM4835iconPositionFors8pcRp0 = WideNavigationRailItemDefaults.INSTANCE.m4835iconPositionFors8pcRp0(z5);
                            } else {
                                i13 = i11;
                            }
                            if ((i3 & 256) != 0) {
                                navigationItemColorsColors = WideNavigationRailItemDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                                i13 = (-234881025) & i13;
                            } else {
                                navigationItemColorsColors = navigationItemColors;
                            }
                            if (i9 != 0) {
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            i14 = i13;
                            modifier4 = modifier2;
                        } else {
                            if (i15 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i5 == 0) {
                            }
                            if (i7 != 0) {
                                z5 = false;
                            }
                            if ((i3 & 128) != 0) {
                                i13 = i11 & (-29360129);
                                iM4835iconPositionFors8pcRp0 = WideNavigationRailItemDefaults.INSTANCE.m4835iconPositionFors8pcRp0(z5);
                            } else {
                                i13 = i11;
                            }
                            if ((i3 & 256) != 0) {
                                navigationItemColorsColors = WideNavigationRailItemDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                                i13 = (-234881025) & i13;
                            } else {
                                navigationItemColorsColors = navigationItemColors;
                            }
                            if (i9 != 0) {
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            i14 = i13;
                            modifier4 = modifier2;
                        }
                        boolean z11 = z5;
                        int i19 = iM4835iconPositionFors8pcRp0;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1198748736, i14, -1, "androidx.compose.material3.WideNavigationRailItem (WideNavigationRail.kt:787)");
                        }
                        int i110 = i14 << 3;
                        composer2 = composerStartRestartGroup;
                        m4846WideNavigationRailItemplit6k(z, (Function0<Unit>) function0, (Function2<? super Composer, ? super Integer, Unit>) function4, (Function2<? super Composer, ? super Integer, Unit>) function5, z11, modifier4, z9, i19, navigationItemColorsColors, mutableInteractionSource3, composer2, (i14 & 8190) | ((i14 >> 6) & 57344) | (458752 & i110) | (i110 & 3670016) | (29360128 & i14) | (234881024 & i14) | (i14 & C.ENCODING_PCM_DOUBLE), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        z8 = z11;
                        modifier3 = modifier4;
                        z7 = z9;
                        i12 = i19;
                        navigationItemColors2 = navigationItemColorsColors;
                        mutableInteractionSource2 = mutableInteractionSource3;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        navigationItemColors2 = navigationItemColors;
                        modifier3 = modifier2;
                        z7 = z4;
                        z8 = z5;
                        i12 = iM4835iconPositionFors8pcRp0;
                        mutableInteractionSource2 = mutableInteractionSource;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.WideNavigationRailKt$$ExternalSyntheticLambda19
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return WideNavigationRailKt.WideNavigationRailItem_pli_t6k$lambda$2(z, function0, function2, function3, modifier3, z7, z8, i12, navigationItemColors2, mutableInteractionSource2, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i4 |= 1572864;
                z5 = z3;
                if ((12582912 & i2) == 0) {
                    if ((i3 & 128) == 0) {
                        iM4835iconPositionFors8pcRp0 = i;
                        if (composerStartRestartGroup.changed(iM4835iconPositionFors8pcRp0)) {
                        }
                        i4 |= i16;
                    } else {
                        iM4835iconPositionFors8pcRp0 = i;
                    }
                    i4 |= i16;
                } else {
                    iM4835iconPositionFors8pcRp0 = i;
                }
                if ((i2 & 100663296) != 0) {
                    i4 |= ((i3 & 256) == 0 || !composerStartRestartGroup.changed(navigationItemColors)) ? 33554432 : 67108864;
                }
                i9 = i3 & 512;
                if (i9 != 0) {
                    if ((i2 & 805306368) == 0) {
                        if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                            i10 = C.BUFFER_FLAG_LAST_SAMPLE;
                        } else {
                            i10 = 268435456;
                        }
                        i4 |= i10;
                    }
                    i11 = i4;
                    if ((i4 & 306783379) != 306783378) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z6, i11 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "784@38402L8");
                        if ((i2 & 1) != 0) {
                            if (i15 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i5 == 0) {
                            }
                            if (i7 != 0) {
                                z5 = false;
                            }
                            if ((i3 & 128) != 0) {
                                i13 = i11 & (-29360129);
                                iM4835iconPositionFors8pcRp0 = WideNavigationRailItemDefaults.INSTANCE.m4835iconPositionFors8pcRp0(z5);
                            } else {
                                i13 = i11;
                            }
                            if ((i3 & 256) != 0) {
                                navigationItemColorsColors = WideNavigationRailItemDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                                i13 = (-234881025) & i13;
                            } else {
                                navigationItemColorsColors = navigationItemColors;
                            }
                            if (i9 != 0) {
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            i14 = i13;
                            modifier4 = modifier2;
                        } else {
                            if (i15 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i5 == 0) {
                            }
                            if (i7 != 0) {
                                z5 = false;
                            }
                            if ((i3 & 128) != 0) {
                                i13 = i11 & (-29360129);
                                iM4835iconPositionFors8pcRp0 = WideNavigationRailItemDefaults.INSTANCE.m4835iconPositionFors8pcRp0(z5);
                            } else {
                                i13 = i11;
                            }
                            if ((i3 & 256) != 0) {
                                navigationItemColorsColors = WideNavigationRailItemDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                                i13 = (-234881025) & i13;
                            } else {
                                navigationItemColorsColors = navigationItemColors;
                            }
                            if (i9 != 0) {
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            i14 = i13;
                            modifier4 = modifier2;
                        }
                        boolean z12 = z5;
                        int i111 = iM4835iconPositionFors8pcRp0;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1198748736, i14, -1, "androidx.compose.material3.WideNavigationRailItem (WideNavigationRail.kt:787)");
                        }
                        int i112 = i14 << 3;
                        composer2 = composerStartRestartGroup;
                        m4846WideNavigationRailItemplit6k(z, (Function0<Unit>) function0, (Function2<? super Composer, ? super Integer, Unit>) function4, (Function2<? super Composer, ? super Integer, Unit>) function5, z12, modifier4, z9, i111, navigationItemColorsColors, mutableInteractionSource3, composer2, (i14 & 8190) | ((i14 >> 6) & 57344) | (458752 & i112) | (i112 & 3670016) | (29360128 & i14) | (234881024 & i14) | (i14 & C.ENCODING_PCM_DOUBLE), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        z8 = z12;
                        modifier3 = modifier4;
                        z7 = z9;
                        i12 = i111;
                        navigationItemColors2 = navigationItemColorsColors;
                        mutableInteractionSource2 = mutableInteractionSource3;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        navigationItemColors2 = navigationItemColors;
                        modifier3 = modifier2;
                        z7 = z4;
                        z8 = z5;
                        i12 = iM4835iconPositionFors8pcRp0;
                        mutableInteractionSource2 = mutableInteractionSource;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.WideNavigationRailKt$$ExternalSyntheticLambda19
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return WideNavigationRailKt.WideNavigationRailItem_pli_t6k$lambda$2(z, function0, function2, function3, modifier3, z7, z8, i12, navigationItemColors2, mutableInteractionSource2, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i4 |= 805306368;
                i11 = i4;
                if ((i4 & 306783379) != 306783378) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z6, i11 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "784@38402L8");
                    if ((i2 & 1) != 0) {
                        if (i15 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i5 == 0) {
                        }
                        if (i7 != 0) {
                            z5 = false;
                        }
                        if ((i3 & 128) != 0) {
                            i13 = i11 & (-29360129);
                            iM4835iconPositionFors8pcRp0 = WideNavigationRailItemDefaults.INSTANCE.m4835iconPositionFors8pcRp0(z5);
                        } else {
                            i13 = i11;
                        }
                        if ((i3 & 256) != 0) {
                            navigationItemColorsColors = WideNavigationRailItemDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                            i13 = (-234881025) & i13;
                        } else {
                            navigationItemColorsColors = navigationItemColors;
                        }
                        if (i9 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        i14 = i13;
                        modifier4 = modifier2;
                    } else {
                        if (i15 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i5 == 0) {
                        }
                        if (i7 != 0) {
                            z5 = false;
                        }
                        if ((i3 & 128) != 0) {
                            i13 = i11 & (-29360129);
                            iM4835iconPositionFors8pcRp0 = WideNavigationRailItemDefaults.INSTANCE.m4835iconPositionFors8pcRp0(z5);
                        } else {
                            i13 = i11;
                        }
                        if ((i3 & 256) != 0) {
                            navigationItemColorsColors = WideNavigationRailItemDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                            i13 = (-234881025) & i13;
                        } else {
                            navigationItemColorsColors = navigationItemColors;
                        }
                        if (i9 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        i14 = i13;
                        modifier4 = modifier2;
                    }
                    boolean z13 = z5;
                    int i113 = iM4835iconPositionFors8pcRp0;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1198748736, i14, -1, "androidx.compose.material3.WideNavigationRailItem (WideNavigationRail.kt:787)");
                    }
                    int i114 = i14 << 3;
                    composer2 = composerStartRestartGroup;
                    m4846WideNavigationRailItemplit6k(z, (Function0<Unit>) function0, (Function2<? super Composer, ? super Integer, Unit>) function4, (Function2<? super Composer, ? super Integer, Unit>) function5, z13, modifier4, z9, i113, navigationItemColorsColors, mutableInteractionSource3, composer2, (i14 & 8190) | ((i14 >> 6) & 57344) | (458752 & i114) | (i114 & 3670016) | (29360128 & i14) | (234881024 & i14) | (i14 & C.ENCODING_PCM_DOUBLE), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z8 = z13;
                    modifier3 = modifier4;
                    z7 = z9;
                    i12 = i113;
                    navigationItemColors2 = navigationItemColorsColors;
                    mutableInteractionSource2 = mutableInteractionSource3;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    navigationItemColors2 = navigationItemColors;
                    modifier3 = modifier2;
                    z7 = z4;
                    z8 = z5;
                    i12 = iM4835iconPositionFors8pcRp0;
                    mutableInteractionSource2 = mutableInteractionSource;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.WideNavigationRailKt$$ExternalSyntheticLambda19
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return WideNavigationRailKt.WideNavigationRailItem_pli_t6k$lambda$2(z, function0, function2, function3, modifier3, z7, z8, i12, navigationItemColors2, mutableInteractionSource2, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            z4 = z2;
            i7 = i3 & 64;
            if (i7 != 0) {
                if ((1572864 & i2) == 0) {
                    z5 = z3;
                    if (composerStartRestartGroup.changed(z5)) {
                        i8 = 1048576;
                    } else {
                        i8 = 524288;
                    }
                    i4 |= i8;
                }
                if ((12582912 & i2) == 0) {
                    if ((i3 & 128) == 0) {
                        iM4835iconPositionFors8pcRp0 = i;
                        if (composerStartRestartGroup.changed(iM4835iconPositionFors8pcRp0)) {
                        }
                        i4 |= i16;
                    } else {
                        iM4835iconPositionFors8pcRp0 = i;
                    }
                    i4 |= i16;
                } else {
                    iM4835iconPositionFors8pcRp0 = i;
                }
                if ((i2 & 100663296) != 0) {
                    i4 |= ((i3 & 256) == 0 || !composerStartRestartGroup.changed(navigationItemColors)) ? 33554432 : 67108864;
                }
                i9 = i3 & 512;
                if (i9 != 0) {
                    if ((i2 & 805306368) == 0) {
                        if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                            i10 = C.BUFFER_FLAG_LAST_SAMPLE;
                        } else {
                            i10 = 268435456;
                        }
                        i4 |= i10;
                    }
                    i11 = i4;
                    if ((i4 & 306783379) != 306783378) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z6, i11 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "784@38402L8");
                        if ((i2 & 1) != 0) {
                            if (i15 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i5 == 0) {
                            }
                            if (i7 != 0) {
                                z5 = false;
                            }
                            if ((i3 & 128) != 0) {
                                i13 = i11 & (-29360129);
                                iM4835iconPositionFors8pcRp0 = WideNavigationRailItemDefaults.INSTANCE.m4835iconPositionFors8pcRp0(z5);
                            } else {
                                i13 = i11;
                            }
                            if ((i3 & 256) != 0) {
                                navigationItemColorsColors = WideNavigationRailItemDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                                i13 = (-234881025) & i13;
                            } else {
                                navigationItemColorsColors = navigationItemColors;
                            }
                            if (i9 != 0) {
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            i14 = i13;
                            modifier4 = modifier2;
                        } else {
                            if (i15 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i5 == 0) {
                            }
                            if (i7 != 0) {
                                z5 = false;
                            }
                            if ((i3 & 128) != 0) {
                                i13 = i11 & (-29360129);
                                iM4835iconPositionFors8pcRp0 = WideNavigationRailItemDefaults.INSTANCE.m4835iconPositionFors8pcRp0(z5);
                            } else {
                                i13 = i11;
                            }
                            if ((i3 & 256) != 0) {
                                navigationItemColorsColors = WideNavigationRailItemDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                                i13 = (-234881025) & i13;
                            } else {
                                navigationItemColorsColors = navigationItemColors;
                            }
                            if (i9 != 0) {
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            i14 = i13;
                            modifier4 = modifier2;
                        }
                        boolean z14 = z5;
                        int i115 = iM4835iconPositionFors8pcRp0;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1198748736, i14, -1, "androidx.compose.material3.WideNavigationRailItem (WideNavigationRail.kt:787)");
                        }
                        int i116 = i14 << 3;
                        composer2 = composerStartRestartGroup;
                        m4846WideNavigationRailItemplit6k(z, (Function0<Unit>) function0, (Function2<? super Composer, ? super Integer, Unit>) function4, (Function2<? super Composer, ? super Integer, Unit>) function5, z14, modifier4, z9, i115, navigationItemColorsColors, mutableInteractionSource3, composer2, (i14 & 8190) | ((i14 >> 6) & 57344) | (458752 & i116) | (i116 & 3670016) | (29360128 & i14) | (234881024 & i14) | (i14 & C.ENCODING_PCM_DOUBLE), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        z8 = z14;
                        modifier3 = modifier4;
                        z7 = z9;
                        i12 = i115;
                        navigationItemColors2 = navigationItemColorsColors;
                        mutableInteractionSource2 = mutableInteractionSource3;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        navigationItemColors2 = navigationItemColors;
                        modifier3 = modifier2;
                        z7 = z4;
                        z8 = z5;
                        i12 = iM4835iconPositionFors8pcRp0;
                        mutableInteractionSource2 = mutableInteractionSource;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.WideNavigationRailKt$$ExternalSyntheticLambda19
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return WideNavigationRailKt.WideNavigationRailItem_pli_t6k$lambda$2(z, function0, function2, function3, modifier3, z7, z8, i12, navigationItemColors2, mutableInteractionSource2, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i4 |= 805306368;
                i11 = i4;
                if ((i4 & 306783379) != 306783378) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z6, i11 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "784@38402L8");
                    if ((i2 & 1) != 0) {
                        if (i15 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i5 == 0) {
                        }
                        if (i7 != 0) {
                            z5 = false;
                        }
                        if ((i3 & 128) != 0) {
                            i13 = i11 & (-29360129);
                            iM4835iconPositionFors8pcRp0 = WideNavigationRailItemDefaults.INSTANCE.m4835iconPositionFors8pcRp0(z5);
                        } else {
                            i13 = i11;
                        }
                        if ((i3 & 256) != 0) {
                            navigationItemColorsColors = WideNavigationRailItemDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                            i13 = (-234881025) & i13;
                        } else {
                            navigationItemColorsColors = navigationItemColors;
                        }
                        if (i9 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        i14 = i13;
                        modifier4 = modifier2;
                    } else {
                        if (i15 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i5 == 0) {
                        }
                        if (i7 != 0) {
                            z5 = false;
                        }
                        if ((i3 & 128) != 0) {
                            i13 = i11 & (-29360129);
                            iM4835iconPositionFors8pcRp0 = WideNavigationRailItemDefaults.INSTANCE.m4835iconPositionFors8pcRp0(z5);
                        } else {
                            i13 = i11;
                        }
                        if ((i3 & 256) != 0) {
                            navigationItemColorsColors = WideNavigationRailItemDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                            i13 = (-234881025) & i13;
                        } else {
                            navigationItemColorsColors = navigationItemColors;
                        }
                        if (i9 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        i14 = i13;
                        modifier4 = modifier2;
                    }
                    boolean z15 = z5;
                    int i117 = iM4835iconPositionFors8pcRp0;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1198748736, i14, -1, "androidx.compose.material3.WideNavigationRailItem (WideNavigationRail.kt:787)");
                    }
                    int i118 = i14 << 3;
                    composer2 = composerStartRestartGroup;
                    m4846WideNavigationRailItemplit6k(z, (Function0<Unit>) function0, (Function2<? super Composer, ? super Integer, Unit>) function4, (Function2<? super Composer, ? super Integer, Unit>) function5, z15, modifier4, z9, i117, navigationItemColorsColors, mutableInteractionSource3, composer2, (i14 & 8190) | ((i14 >> 6) & 57344) | (458752 & i118) | (i118 & 3670016) | (29360128 & i14) | (234881024 & i14) | (i14 & C.ENCODING_PCM_DOUBLE), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z8 = z15;
                    modifier3 = modifier4;
                    z7 = z9;
                    i12 = i117;
                    navigationItemColors2 = navigationItemColorsColors;
                    mutableInteractionSource2 = mutableInteractionSource3;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    navigationItemColors2 = navigationItemColors;
                    modifier3 = modifier2;
                    z7 = z4;
                    z8 = z5;
                    i12 = iM4835iconPositionFors8pcRp0;
                    mutableInteractionSource2 = mutableInteractionSource;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.WideNavigationRailKt$$ExternalSyntheticLambda19
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return WideNavigationRailKt.WideNavigationRailItem_pli_t6k$lambda$2(z, function0, function2, function3, modifier3, z7, z8, i12, navigationItemColors2, mutableInteractionSource2, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i4 |= 1572864;
            z5 = z3;
            if ((12582912 & i2) == 0) {
                if ((i3 & 128) == 0) {
                    iM4835iconPositionFors8pcRp0 = i;
                    if (composerStartRestartGroup.changed(iM4835iconPositionFors8pcRp0)) {
                    }
                    i4 |= i16;
                } else {
                    iM4835iconPositionFors8pcRp0 = i;
                }
                i4 |= i16;
            } else {
                iM4835iconPositionFors8pcRp0 = i;
            }
            if ((i2 & 100663296) != 0) {
                i4 |= ((i3 & 256) == 0 || !composerStartRestartGroup.changed(navigationItemColors)) ? 33554432 : 67108864;
            }
            i9 = i3 & 512;
            if (i9 != 0) {
                if ((i2 & 805306368) == 0) {
                    if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                        i10 = C.BUFFER_FLAG_LAST_SAMPLE;
                    } else {
                        i10 = 268435456;
                    }
                    i4 |= i10;
                }
                i11 = i4;
                if ((i4 & 306783379) != 306783378) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z6, i11 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "784@38402L8");
                    if ((i2 & 1) != 0) {
                        if (i15 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i5 == 0) {
                        }
                        if (i7 != 0) {
                            z5 = false;
                        }
                        if ((i3 & 128) != 0) {
                            i13 = i11 & (-29360129);
                            iM4835iconPositionFors8pcRp0 = WideNavigationRailItemDefaults.INSTANCE.m4835iconPositionFors8pcRp0(z5);
                        } else {
                            i13 = i11;
                        }
                        if ((i3 & 256) != 0) {
                            navigationItemColorsColors = WideNavigationRailItemDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                            i13 = (-234881025) & i13;
                        } else {
                            navigationItemColorsColors = navigationItemColors;
                        }
                        if (i9 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        i14 = i13;
                        modifier4 = modifier2;
                    } else {
                        if (i15 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i5 == 0) {
                        }
                        if (i7 != 0) {
                            z5 = false;
                        }
                        if ((i3 & 128) != 0) {
                            i13 = i11 & (-29360129);
                            iM4835iconPositionFors8pcRp0 = WideNavigationRailItemDefaults.INSTANCE.m4835iconPositionFors8pcRp0(z5);
                        } else {
                            i13 = i11;
                        }
                        if ((i3 & 256) != 0) {
                            navigationItemColorsColors = WideNavigationRailItemDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                            i13 = (-234881025) & i13;
                        } else {
                            navigationItemColorsColors = navigationItemColors;
                        }
                        if (i9 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        i14 = i13;
                        modifier4 = modifier2;
                    }
                    boolean z16 = z5;
                    int i119 = iM4835iconPositionFors8pcRp0;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1198748736, i14, -1, "androidx.compose.material3.WideNavigationRailItem (WideNavigationRail.kt:787)");
                    }
                    int i1110 = i14 << 3;
                    composer2 = composerStartRestartGroup;
                    m4846WideNavigationRailItemplit6k(z, (Function0<Unit>) function0, (Function2<? super Composer, ? super Integer, Unit>) function4, (Function2<? super Composer, ? super Integer, Unit>) function5, z16, modifier4, z9, i119, navigationItemColorsColors, mutableInteractionSource3, composer2, (i14 & 8190) | ((i14 >> 6) & 57344) | (458752 & i1110) | (i1110 & 3670016) | (29360128 & i14) | (234881024 & i14) | (i14 & C.ENCODING_PCM_DOUBLE), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z8 = z16;
                    modifier3 = modifier4;
                    z7 = z9;
                    i12 = i119;
                    navigationItemColors2 = navigationItemColorsColors;
                    mutableInteractionSource2 = mutableInteractionSource3;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    navigationItemColors2 = navigationItemColors;
                    modifier3 = modifier2;
                    z7 = z4;
                    z8 = z5;
                    i12 = iM4835iconPositionFors8pcRp0;
                    mutableInteractionSource2 = mutableInteractionSource;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.WideNavigationRailKt$$ExternalSyntheticLambda19
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return WideNavigationRailKt.WideNavigationRailItem_pli_t6k$lambda$2(z, function0, function2, function3, modifier3, z7, z8, i12, navigationItemColors2, mutableInteractionSource2, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i4 |= 805306368;
            i11 = i4;
            if ((i4 & 306783379) != 306783378) {
                z6 = true;
            } else {
                z6 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z6, i11 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "784@38402L8");
                if ((i2 & 1) != 0) {
                    if (i15 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i5 == 0) {
                    }
                    if (i7 != 0) {
                        z5 = false;
                    }
                    if ((i3 & 128) != 0) {
                        i13 = i11 & (-29360129);
                        iM4835iconPositionFors8pcRp0 = WideNavigationRailItemDefaults.INSTANCE.m4835iconPositionFors8pcRp0(z5);
                    } else {
                        i13 = i11;
                    }
                    if ((i3 & 256) != 0) {
                        navigationItemColorsColors = WideNavigationRailItemDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                        i13 = (-234881025) & i13;
                    } else {
                        navigationItemColorsColors = navigationItemColors;
                    }
                    if (i9 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    i14 = i13;
                    modifier4 = modifier2;
                } else {
                    if (i15 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i5 == 0) {
                    }
                    if (i7 != 0) {
                        z5 = false;
                    }
                    if ((i3 & 128) != 0) {
                        i13 = i11 & (-29360129);
                        iM4835iconPositionFors8pcRp0 = WideNavigationRailItemDefaults.INSTANCE.m4835iconPositionFors8pcRp0(z5);
                    } else {
                        i13 = i11;
                    }
                    if ((i3 & 256) != 0) {
                        navigationItemColorsColors = WideNavigationRailItemDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                        i13 = (-234881025) & i13;
                    } else {
                        navigationItemColorsColors = navigationItemColors;
                    }
                    if (i9 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    i14 = i13;
                    modifier4 = modifier2;
                }
                boolean z17 = z5;
                int i1111 = iM4835iconPositionFors8pcRp0;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1198748736, i14, -1, "androidx.compose.material3.WideNavigationRailItem (WideNavigationRail.kt:787)");
                }
                int i1112 = i14 << 3;
                composer2 = composerStartRestartGroup;
                m4846WideNavigationRailItemplit6k(z, (Function0<Unit>) function0, (Function2<? super Composer, ? super Integer, Unit>) function4, (Function2<? super Composer, ? super Integer, Unit>) function5, z17, modifier4, z9, i1111, navigationItemColorsColors, mutableInteractionSource3, composer2, (i14 & 8190) | ((i14 >> 6) & 57344) | (458752 & i1112) | (i1112 & 3670016) | (29360128 & i14) | (234881024 & i14) | (i14 & C.ENCODING_PCM_DOUBLE), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z8 = z17;
                modifier3 = modifier4;
                z7 = z9;
                i12 = i1111;
                navigationItemColors2 = navigationItemColorsColors;
                mutableInteractionSource2 = mutableInteractionSource3;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                navigationItemColors2 = navigationItemColors;
                modifier3 = modifier2;
                z7 = z4;
                z8 = z5;
                i12 = iM4835iconPositionFors8pcRp0;
                mutableInteractionSource2 = mutableInteractionSource;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.WideNavigationRailKt$$ExternalSyntheticLambda19
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return WideNavigationRailKt.WideNavigationRailItem_pli_t6k$lambda$2(z, function0, function2, function3, modifier3, z7, z8, i12, navigationItemColors2, mutableInteractionSource2, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i4 |= 24576;
        modifier2 = modifier;
        i5 = i3 & 32;
        if (i5 != 0) {
            if ((196608 & i2) == 0) {
                z4 = z2;
                if (composerStartRestartGroup.changed(z4)) {
                    i6 = 131072;
                } else {
                    i6 = 65536;
                }
                i4 |= i6;
            }
            i7 = i3 & 64;
            if (i7 != 0) {
                if ((1572864 & i2) == 0) {
                    z5 = z3;
                    if (composerStartRestartGroup.changed(z5)) {
                        i8 = 1048576;
                    } else {
                        i8 = 524288;
                    }
                    i4 |= i8;
                }
                if ((12582912 & i2) == 0) {
                    if ((i3 & 128) == 0) {
                        iM4835iconPositionFors8pcRp0 = i;
                        if (composerStartRestartGroup.changed(iM4835iconPositionFors8pcRp0)) {
                        }
                        i4 |= i16;
                    } else {
                        iM4835iconPositionFors8pcRp0 = i;
                    }
                    i4 |= i16;
                } else {
                    iM4835iconPositionFors8pcRp0 = i;
                }
                if ((i2 & 100663296) != 0) {
                    i4 |= ((i3 & 256) == 0 || !composerStartRestartGroup.changed(navigationItemColors)) ? 33554432 : 67108864;
                }
                i9 = i3 & 512;
                if (i9 != 0) {
                    if ((i2 & 805306368) == 0) {
                        if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                            i10 = C.BUFFER_FLAG_LAST_SAMPLE;
                        } else {
                            i10 = 268435456;
                        }
                        i4 |= i10;
                    }
                    i11 = i4;
                    if ((i4 & 306783379) != 306783378) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z6, i11 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "784@38402L8");
                        if ((i2 & 1) != 0) {
                            if (i15 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i5 == 0) {
                            }
                            if (i7 != 0) {
                                z5 = false;
                            }
                            if ((i3 & 128) != 0) {
                                i13 = i11 & (-29360129);
                                iM4835iconPositionFors8pcRp0 = WideNavigationRailItemDefaults.INSTANCE.m4835iconPositionFors8pcRp0(z5);
                            } else {
                                i13 = i11;
                            }
                            if ((i3 & 256) != 0) {
                                navigationItemColorsColors = WideNavigationRailItemDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                                i13 = (-234881025) & i13;
                            } else {
                                navigationItemColorsColors = navigationItemColors;
                            }
                            if (i9 != 0) {
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            i14 = i13;
                            modifier4 = modifier2;
                        } else {
                            if (i15 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i5 == 0) {
                            }
                            if (i7 != 0) {
                                z5 = false;
                            }
                            if ((i3 & 128) != 0) {
                                i13 = i11 & (-29360129);
                                iM4835iconPositionFors8pcRp0 = WideNavigationRailItemDefaults.INSTANCE.m4835iconPositionFors8pcRp0(z5);
                            } else {
                                i13 = i11;
                            }
                            if ((i3 & 256) != 0) {
                                navigationItemColorsColors = WideNavigationRailItemDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                                i13 = (-234881025) & i13;
                            } else {
                                navigationItemColorsColors = navigationItemColors;
                            }
                            if (i9 != 0) {
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            i14 = i13;
                            modifier4 = modifier2;
                        }
                        boolean z18 = z5;
                        int i1113 = iM4835iconPositionFors8pcRp0;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1198748736, i14, -1, "androidx.compose.material3.WideNavigationRailItem (WideNavigationRail.kt:787)");
                        }
                        int i1114 = i14 << 3;
                        composer2 = composerStartRestartGroup;
                        m4846WideNavigationRailItemplit6k(z, (Function0<Unit>) function0, (Function2<? super Composer, ? super Integer, Unit>) function4, (Function2<? super Composer, ? super Integer, Unit>) function5, z18, modifier4, z9, i1113, navigationItemColorsColors, mutableInteractionSource3, composer2, (i14 & 8190) | ((i14 >> 6) & 57344) | (458752 & i1114) | (i1114 & 3670016) | (29360128 & i14) | (234881024 & i14) | (i14 & C.ENCODING_PCM_DOUBLE), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        z8 = z18;
                        modifier3 = modifier4;
                        z7 = z9;
                        i12 = i1113;
                        navigationItemColors2 = navigationItemColorsColors;
                        mutableInteractionSource2 = mutableInteractionSource3;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        navigationItemColors2 = navigationItemColors;
                        modifier3 = modifier2;
                        z7 = z4;
                        z8 = z5;
                        i12 = iM4835iconPositionFors8pcRp0;
                        mutableInteractionSource2 = mutableInteractionSource;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.WideNavigationRailKt$$ExternalSyntheticLambda19
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return WideNavigationRailKt.WideNavigationRailItem_pli_t6k$lambda$2(z, function0, function2, function3, modifier3, z7, z8, i12, navigationItemColors2, mutableInteractionSource2, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i4 |= 805306368;
                i11 = i4;
                if ((i4 & 306783379) != 306783378) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z6, i11 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "784@38402L8");
                    if ((i2 & 1) != 0) {
                        if (i15 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i5 == 0) {
                        }
                        if (i7 != 0) {
                            z5 = false;
                        }
                        if ((i3 & 128) != 0) {
                            i13 = i11 & (-29360129);
                            iM4835iconPositionFors8pcRp0 = WideNavigationRailItemDefaults.INSTANCE.m4835iconPositionFors8pcRp0(z5);
                        } else {
                            i13 = i11;
                        }
                        if ((i3 & 256) != 0) {
                            navigationItemColorsColors = WideNavigationRailItemDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                            i13 = (-234881025) & i13;
                        } else {
                            navigationItemColorsColors = navigationItemColors;
                        }
                        if (i9 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        i14 = i13;
                        modifier4 = modifier2;
                    } else {
                        if (i15 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i5 == 0) {
                        }
                        if (i7 != 0) {
                            z5 = false;
                        }
                        if ((i3 & 128) != 0) {
                            i13 = i11 & (-29360129);
                            iM4835iconPositionFors8pcRp0 = WideNavigationRailItemDefaults.INSTANCE.m4835iconPositionFors8pcRp0(z5);
                        } else {
                            i13 = i11;
                        }
                        if ((i3 & 256) != 0) {
                            navigationItemColorsColors = WideNavigationRailItemDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                            i13 = (-234881025) & i13;
                        } else {
                            navigationItemColorsColors = navigationItemColors;
                        }
                        if (i9 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        i14 = i13;
                        modifier4 = modifier2;
                    }
                    boolean z19 = z5;
                    int i1115 = iM4835iconPositionFors8pcRp0;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1198748736, i14, -1, "androidx.compose.material3.WideNavigationRailItem (WideNavigationRail.kt:787)");
                    }
                    int i1116 = i14 << 3;
                    composer2 = composerStartRestartGroup;
                    m4846WideNavigationRailItemplit6k(z, (Function0<Unit>) function0, (Function2<? super Composer, ? super Integer, Unit>) function4, (Function2<? super Composer, ? super Integer, Unit>) function5, z19, modifier4, z9, i1115, navigationItemColorsColors, mutableInteractionSource3, composer2, (i14 & 8190) | ((i14 >> 6) & 57344) | (458752 & i1116) | (i1116 & 3670016) | (29360128 & i14) | (234881024 & i14) | (i14 & C.ENCODING_PCM_DOUBLE), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z8 = z19;
                    modifier3 = modifier4;
                    z7 = z9;
                    i12 = i1115;
                    navigationItemColors2 = navigationItemColorsColors;
                    mutableInteractionSource2 = mutableInteractionSource3;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    navigationItemColors2 = navigationItemColors;
                    modifier3 = modifier2;
                    z7 = z4;
                    z8 = z5;
                    i12 = iM4835iconPositionFors8pcRp0;
                    mutableInteractionSource2 = mutableInteractionSource;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.WideNavigationRailKt$$ExternalSyntheticLambda19
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return WideNavigationRailKt.WideNavigationRailItem_pli_t6k$lambda$2(z, function0, function2, function3, modifier3, z7, z8, i12, navigationItemColors2, mutableInteractionSource2, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i4 |= 1572864;
            z5 = z3;
            if ((12582912 & i2) == 0) {
                if ((i3 & 128) == 0) {
                    iM4835iconPositionFors8pcRp0 = i;
                    if (composerStartRestartGroup.changed(iM4835iconPositionFors8pcRp0)) {
                    }
                    i4 |= i16;
                } else {
                    iM4835iconPositionFors8pcRp0 = i;
                }
                i4 |= i16;
            } else {
                iM4835iconPositionFors8pcRp0 = i;
            }
            if ((i2 & 100663296) != 0) {
                i4 |= ((i3 & 256) == 0 || !composerStartRestartGroup.changed(navigationItemColors)) ? 33554432 : 67108864;
            }
            i9 = i3 & 512;
            if (i9 != 0) {
                if ((i2 & 805306368) == 0) {
                    if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                        i10 = C.BUFFER_FLAG_LAST_SAMPLE;
                    } else {
                        i10 = 268435456;
                    }
                    i4 |= i10;
                }
                i11 = i4;
                if ((i4 & 306783379) != 306783378) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z6, i11 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "784@38402L8");
                    if ((i2 & 1) != 0) {
                        if (i15 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i5 == 0) {
                        }
                        if (i7 != 0) {
                            z5 = false;
                        }
                        if ((i3 & 128) != 0) {
                            i13 = i11 & (-29360129);
                            iM4835iconPositionFors8pcRp0 = WideNavigationRailItemDefaults.INSTANCE.m4835iconPositionFors8pcRp0(z5);
                        } else {
                            i13 = i11;
                        }
                        if ((i3 & 256) != 0) {
                            navigationItemColorsColors = WideNavigationRailItemDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                            i13 = (-234881025) & i13;
                        } else {
                            navigationItemColorsColors = navigationItemColors;
                        }
                        if (i9 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        i14 = i13;
                        modifier4 = modifier2;
                    } else {
                        if (i15 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i5 == 0) {
                        }
                        if (i7 != 0) {
                            z5 = false;
                        }
                        if ((i3 & 128) != 0) {
                            i13 = i11 & (-29360129);
                            iM4835iconPositionFors8pcRp0 = WideNavigationRailItemDefaults.INSTANCE.m4835iconPositionFors8pcRp0(z5);
                        } else {
                            i13 = i11;
                        }
                        if ((i3 & 256) != 0) {
                            navigationItemColorsColors = WideNavigationRailItemDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                            i13 = (-234881025) & i13;
                        } else {
                            navigationItemColorsColors = navigationItemColors;
                        }
                        if (i9 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        i14 = i13;
                        modifier4 = modifier2;
                    }
                    boolean z110 = z5;
                    int i1117 = iM4835iconPositionFors8pcRp0;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1198748736, i14, -1, "androidx.compose.material3.WideNavigationRailItem (WideNavigationRail.kt:787)");
                    }
                    int i1118 = i14 << 3;
                    composer2 = composerStartRestartGroup;
                    m4846WideNavigationRailItemplit6k(z, (Function0<Unit>) function0, (Function2<? super Composer, ? super Integer, Unit>) function4, (Function2<? super Composer, ? super Integer, Unit>) function5, z110, modifier4, z9, i1117, navigationItemColorsColors, mutableInteractionSource3, composer2, (i14 & 8190) | ((i14 >> 6) & 57344) | (458752 & i1118) | (i1118 & 3670016) | (29360128 & i14) | (234881024 & i14) | (i14 & C.ENCODING_PCM_DOUBLE), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z8 = z110;
                    modifier3 = modifier4;
                    z7 = z9;
                    i12 = i1117;
                    navigationItemColors2 = navigationItemColorsColors;
                    mutableInteractionSource2 = mutableInteractionSource3;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    navigationItemColors2 = navigationItemColors;
                    modifier3 = modifier2;
                    z7 = z4;
                    z8 = z5;
                    i12 = iM4835iconPositionFors8pcRp0;
                    mutableInteractionSource2 = mutableInteractionSource;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.WideNavigationRailKt$$ExternalSyntheticLambda19
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return WideNavigationRailKt.WideNavigationRailItem_pli_t6k$lambda$2(z, function0, function2, function3, modifier3, z7, z8, i12, navigationItemColors2, mutableInteractionSource2, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i4 |= 805306368;
            i11 = i4;
            if ((i4 & 306783379) != 306783378) {
                z6 = true;
            } else {
                z6 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z6, i11 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "784@38402L8");
                if ((i2 & 1) != 0) {
                    if (i15 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i5 == 0) {
                    }
                    if (i7 != 0) {
                        z5 = false;
                    }
                    if ((i3 & 128) != 0) {
                        i13 = i11 & (-29360129);
                        iM4835iconPositionFors8pcRp0 = WideNavigationRailItemDefaults.INSTANCE.m4835iconPositionFors8pcRp0(z5);
                    } else {
                        i13 = i11;
                    }
                    if ((i3 & 256) != 0) {
                        navigationItemColorsColors = WideNavigationRailItemDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                        i13 = (-234881025) & i13;
                    } else {
                        navigationItemColorsColors = navigationItemColors;
                    }
                    if (i9 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    i14 = i13;
                    modifier4 = modifier2;
                } else {
                    if (i15 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i5 == 0) {
                    }
                    if (i7 != 0) {
                        z5 = false;
                    }
                    if ((i3 & 128) != 0) {
                        i13 = i11 & (-29360129);
                        iM4835iconPositionFors8pcRp0 = WideNavigationRailItemDefaults.INSTANCE.m4835iconPositionFors8pcRp0(z5);
                    } else {
                        i13 = i11;
                    }
                    if ((i3 & 256) != 0) {
                        navigationItemColorsColors = WideNavigationRailItemDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                        i13 = (-234881025) & i13;
                    } else {
                        navigationItemColorsColors = navigationItemColors;
                    }
                    if (i9 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    i14 = i13;
                    modifier4 = modifier2;
                }
                boolean z111 = z5;
                int i1119 = iM4835iconPositionFors8pcRp0;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1198748736, i14, -1, "androidx.compose.material3.WideNavigationRailItem (WideNavigationRail.kt:787)");
                }
                int i11110 = i14 << 3;
                composer2 = composerStartRestartGroup;
                m4846WideNavigationRailItemplit6k(z, (Function0<Unit>) function0, (Function2<? super Composer, ? super Integer, Unit>) function4, (Function2<? super Composer, ? super Integer, Unit>) function5, z111, modifier4, z9, i1119, navigationItemColorsColors, mutableInteractionSource3, composer2, (i14 & 8190) | ((i14 >> 6) & 57344) | (458752 & i11110) | (i11110 & 3670016) | (29360128 & i14) | (234881024 & i14) | (i14 & C.ENCODING_PCM_DOUBLE), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z8 = z111;
                modifier3 = modifier4;
                z7 = z9;
                i12 = i1119;
                navigationItemColors2 = navigationItemColorsColors;
                mutableInteractionSource2 = mutableInteractionSource3;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                navigationItemColors2 = navigationItemColors;
                modifier3 = modifier2;
                z7 = z4;
                z8 = z5;
                i12 = iM4835iconPositionFors8pcRp0;
                mutableInteractionSource2 = mutableInteractionSource;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.WideNavigationRailKt$$ExternalSyntheticLambda19
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return WideNavigationRailKt.WideNavigationRailItem_pli_t6k$lambda$2(z, function0, function2, function3, modifier3, z7, z8, i12, navigationItemColors2, mutableInteractionSource2, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        z4 = z2;
        i7 = i3 & 64;
        if (i7 != 0) {
            if ((1572864 & i2) == 0) {
                z5 = z3;
                if (composerStartRestartGroup.changed(z5)) {
                    i8 = 1048576;
                } else {
                    i8 = 524288;
                }
                i4 |= i8;
            }
            if ((12582912 & i2) == 0) {
                if ((i3 & 128) == 0) {
                    iM4835iconPositionFors8pcRp0 = i;
                    if (composerStartRestartGroup.changed(iM4835iconPositionFors8pcRp0)) {
                    }
                    i4 |= i16;
                } else {
                    iM4835iconPositionFors8pcRp0 = i;
                }
                i4 |= i16;
            } else {
                iM4835iconPositionFors8pcRp0 = i;
            }
            if ((i2 & 100663296) != 0) {
                i4 |= ((i3 & 256) == 0 || !composerStartRestartGroup.changed(navigationItemColors)) ? 33554432 : 67108864;
            }
            i9 = i3 & 512;
            if (i9 != 0) {
                if ((i2 & 805306368) == 0) {
                    if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                        i10 = C.BUFFER_FLAG_LAST_SAMPLE;
                    } else {
                        i10 = 268435456;
                    }
                    i4 |= i10;
                }
                i11 = i4;
                if ((i4 & 306783379) != 306783378) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z6, i11 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "784@38402L8");
                    if ((i2 & 1) != 0) {
                        if (i15 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i5 == 0) {
                        }
                        if (i7 != 0) {
                            z5 = false;
                        }
                        if ((i3 & 128) != 0) {
                            i13 = i11 & (-29360129);
                            iM4835iconPositionFors8pcRp0 = WideNavigationRailItemDefaults.INSTANCE.m4835iconPositionFors8pcRp0(z5);
                        } else {
                            i13 = i11;
                        }
                        if ((i3 & 256) != 0) {
                            navigationItemColorsColors = WideNavigationRailItemDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                            i13 = (-234881025) & i13;
                        } else {
                            navigationItemColorsColors = navigationItemColors;
                        }
                        if (i9 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        i14 = i13;
                        modifier4 = modifier2;
                    } else {
                        if (i15 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i5 == 0) {
                        }
                        if (i7 != 0) {
                            z5 = false;
                        }
                        if ((i3 & 128) != 0) {
                            i13 = i11 & (-29360129);
                            iM4835iconPositionFors8pcRp0 = WideNavigationRailItemDefaults.INSTANCE.m4835iconPositionFors8pcRp0(z5);
                        } else {
                            i13 = i11;
                        }
                        if ((i3 & 256) != 0) {
                            navigationItemColorsColors = WideNavigationRailItemDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                            i13 = (-234881025) & i13;
                        } else {
                            navigationItemColorsColors = navigationItemColors;
                        }
                        if (i9 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        i14 = i13;
                        modifier4 = modifier2;
                    }
                    boolean z112 = z5;
                    int i11111 = iM4835iconPositionFors8pcRp0;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1198748736, i14, -1, "androidx.compose.material3.WideNavigationRailItem (WideNavigationRail.kt:787)");
                    }
                    int i11112 = i14 << 3;
                    composer2 = composerStartRestartGroup;
                    m4846WideNavigationRailItemplit6k(z, (Function0<Unit>) function0, (Function2<? super Composer, ? super Integer, Unit>) function4, (Function2<? super Composer, ? super Integer, Unit>) function5, z112, modifier4, z9, i11111, navigationItemColorsColors, mutableInteractionSource3, composer2, (i14 & 8190) | ((i14 >> 6) & 57344) | (458752 & i11112) | (i11112 & 3670016) | (29360128 & i14) | (234881024 & i14) | (i14 & C.ENCODING_PCM_DOUBLE), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z8 = z112;
                    modifier3 = modifier4;
                    z7 = z9;
                    i12 = i11111;
                    navigationItemColors2 = navigationItemColorsColors;
                    mutableInteractionSource2 = mutableInteractionSource3;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    navigationItemColors2 = navigationItemColors;
                    modifier3 = modifier2;
                    z7 = z4;
                    z8 = z5;
                    i12 = iM4835iconPositionFors8pcRp0;
                    mutableInteractionSource2 = mutableInteractionSource;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.WideNavigationRailKt$$ExternalSyntheticLambda19
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return WideNavigationRailKt.WideNavigationRailItem_pli_t6k$lambda$2(z, function0, function2, function3, modifier3, z7, z8, i12, navigationItemColors2, mutableInteractionSource2, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i4 |= 805306368;
            i11 = i4;
            if ((i4 & 306783379) != 306783378) {
                z6 = true;
            } else {
                z6 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z6, i11 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "784@38402L8");
                if ((i2 & 1) != 0) {
                    if (i15 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i5 == 0) {
                    }
                    if (i7 != 0) {
                        z5 = false;
                    }
                    if ((i3 & 128) != 0) {
                        i13 = i11 & (-29360129);
                        iM4835iconPositionFors8pcRp0 = WideNavigationRailItemDefaults.INSTANCE.m4835iconPositionFors8pcRp0(z5);
                    } else {
                        i13 = i11;
                    }
                    if ((i3 & 256) != 0) {
                        navigationItemColorsColors = WideNavigationRailItemDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                        i13 = (-234881025) & i13;
                    } else {
                        navigationItemColorsColors = navigationItemColors;
                    }
                    if (i9 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    i14 = i13;
                    modifier4 = modifier2;
                } else {
                    if (i15 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i5 == 0) {
                    }
                    if (i7 != 0) {
                        z5 = false;
                    }
                    if ((i3 & 128) != 0) {
                        i13 = i11 & (-29360129);
                        iM4835iconPositionFors8pcRp0 = WideNavigationRailItemDefaults.INSTANCE.m4835iconPositionFors8pcRp0(z5);
                    } else {
                        i13 = i11;
                    }
                    if ((i3 & 256) != 0) {
                        navigationItemColorsColors = WideNavigationRailItemDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                        i13 = (-234881025) & i13;
                    } else {
                        navigationItemColorsColors = navigationItemColors;
                    }
                    if (i9 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    i14 = i13;
                    modifier4 = modifier2;
                }
                boolean z113 = z5;
                int i11113 = iM4835iconPositionFors8pcRp0;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1198748736, i14, -1, "androidx.compose.material3.WideNavigationRailItem (WideNavigationRail.kt:787)");
                }
                int i11114 = i14 << 3;
                composer2 = composerStartRestartGroup;
                m4846WideNavigationRailItemplit6k(z, (Function0<Unit>) function0, (Function2<? super Composer, ? super Integer, Unit>) function4, (Function2<? super Composer, ? super Integer, Unit>) function5, z113, modifier4, z9, i11113, navigationItemColorsColors, mutableInteractionSource3, composer2, (i14 & 8190) | ((i14 >> 6) & 57344) | (458752 & i11114) | (i11114 & 3670016) | (29360128 & i14) | (234881024 & i14) | (i14 & C.ENCODING_PCM_DOUBLE), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z8 = z113;
                modifier3 = modifier4;
                z7 = z9;
                i12 = i11113;
                navigationItemColors2 = navigationItemColorsColors;
                mutableInteractionSource2 = mutableInteractionSource3;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                navigationItemColors2 = navigationItemColors;
                modifier3 = modifier2;
                z7 = z4;
                z8 = z5;
                i12 = iM4835iconPositionFors8pcRp0;
                mutableInteractionSource2 = mutableInteractionSource;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.WideNavigationRailKt$$ExternalSyntheticLambda19
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return WideNavigationRailKt.WideNavigationRailItem_pli_t6k$lambda$2(z, function0, function2, function3, modifier3, z7, z8, i12, navigationItemColors2, mutableInteractionSource2, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i4 |= 1572864;
        z5 = z3;
        if ((12582912 & i2) == 0) {
            if ((i3 & 128) == 0) {
                iM4835iconPositionFors8pcRp0 = i;
                if (composerStartRestartGroup.changed(iM4835iconPositionFors8pcRp0)) {
                }
                i4 |= i16;
            } else {
                iM4835iconPositionFors8pcRp0 = i;
            }
            i4 |= i16;
        } else {
            iM4835iconPositionFors8pcRp0 = i;
        }
        if ((i2 & 100663296) != 0) {
            i4 |= ((i3 & 256) == 0 || !composerStartRestartGroup.changed(navigationItemColors)) ? 33554432 : 67108864;
        }
        i9 = i3 & 512;
        if (i9 != 0) {
            if ((i2 & 805306368) == 0) {
                if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                    i10 = C.BUFFER_FLAG_LAST_SAMPLE;
                } else {
                    i10 = 268435456;
                }
                i4 |= i10;
            }
            i11 = i4;
            if ((i4 & 306783379) != 306783378) {
                z6 = true;
            } else {
                z6 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z6, i11 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "784@38402L8");
                if ((i2 & 1) != 0) {
                    if (i15 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i5 == 0) {
                    }
                    if (i7 != 0) {
                        z5 = false;
                    }
                    if ((i3 & 128) != 0) {
                        i13 = i11 & (-29360129);
                        iM4835iconPositionFors8pcRp0 = WideNavigationRailItemDefaults.INSTANCE.m4835iconPositionFors8pcRp0(z5);
                    } else {
                        i13 = i11;
                    }
                    if ((i3 & 256) != 0) {
                        navigationItemColorsColors = WideNavigationRailItemDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                        i13 = (-234881025) & i13;
                    } else {
                        navigationItemColorsColors = navigationItemColors;
                    }
                    if (i9 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    i14 = i13;
                    modifier4 = modifier2;
                } else {
                    if (i15 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i5 == 0) {
                    }
                    if (i7 != 0) {
                        z5 = false;
                    }
                    if ((i3 & 128) != 0) {
                        i13 = i11 & (-29360129);
                        iM4835iconPositionFors8pcRp0 = WideNavigationRailItemDefaults.INSTANCE.m4835iconPositionFors8pcRp0(z5);
                    } else {
                        i13 = i11;
                    }
                    if ((i3 & 256) != 0) {
                        navigationItemColorsColors = WideNavigationRailItemDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                        i13 = (-234881025) & i13;
                    } else {
                        navigationItemColorsColors = navigationItemColors;
                    }
                    if (i9 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    i14 = i13;
                    modifier4 = modifier2;
                }
                boolean z114 = z5;
                int i11115 = iM4835iconPositionFors8pcRp0;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1198748736, i14, -1, "androidx.compose.material3.WideNavigationRailItem (WideNavigationRail.kt:787)");
                }
                int i11116 = i14 << 3;
                composer2 = composerStartRestartGroup;
                m4846WideNavigationRailItemplit6k(z, (Function0<Unit>) function0, (Function2<? super Composer, ? super Integer, Unit>) function4, (Function2<? super Composer, ? super Integer, Unit>) function5, z114, modifier4, z9, i11115, navigationItemColorsColors, mutableInteractionSource3, composer2, (i14 & 8190) | ((i14 >> 6) & 57344) | (458752 & i11116) | (i11116 & 3670016) | (29360128 & i14) | (234881024 & i14) | (i14 & C.ENCODING_PCM_DOUBLE), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z8 = z114;
                modifier3 = modifier4;
                z7 = z9;
                i12 = i11115;
                navigationItemColors2 = navigationItemColorsColors;
                mutableInteractionSource2 = mutableInteractionSource3;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                navigationItemColors2 = navigationItemColors;
                modifier3 = modifier2;
                z7 = z4;
                z8 = z5;
                i12 = iM4835iconPositionFors8pcRp0;
                mutableInteractionSource2 = mutableInteractionSource;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.WideNavigationRailKt$$ExternalSyntheticLambda19
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return WideNavigationRailKt.WideNavigationRailItem_pli_t6k$lambda$2(z, function0, function2, function3, modifier3, z7, z8, i12, navigationItemColors2, mutableInteractionSource2, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i4 |= 805306368;
        i11 = i4;
        if ((i4 & 306783379) != 306783378) {
            z6 = true;
        } else {
            z6 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z6, i11 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "784@38402L8");
            if ((i2 & 1) != 0) {
                if (i15 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i5 == 0) {
                }
                if (i7 != 0) {
                    z5 = false;
                }
                if ((i3 & 128) != 0) {
                    i13 = i11 & (-29360129);
                    iM4835iconPositionFors8pcRp0 = WideNavigationRailItemDefaults.INSTANCE.m4835iconPositionFors8pcRp0(z5);
                } else {
                    i13 = i11;
                }
                if ((i3 & 256) != 0) {
                    navigationItemColorsColors = WideNavigationRailItemDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                    i13 = (-234881025) & i13;
                } else {
                    navigationItemColorsColors = navigationItemColors;
                }
                if (i9 != 0) {
                    mutableInteractionSource3 = null;
                } else {
                    mutableInteractionSource3 = mutableInteractionSource;
                }
                i14 = i13;
                modifier4 = modifier2;
            } else {
                if (i15 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i5 == 0) {
                }
                if (i7 != 0) {
                    z5 = false;
                }
                if ((i3 & 128) != 0) {
                    i13 = i11 & (-29360129);
                    iM4835iconPositionFors8pcRp0 = WideNavigationRailItemDefaults.INSTANCE.m4835iconPositionFors8pcRp0(z5);
                } else {
                    i13 = i11;
                }
                if ((i3 & 256) != 0) {
                    navigationItemColorsColors = WideNavigationRailItemDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                    i13 = (-234881025) & i13;
                } else {
                    navigationItemColorsColors = navigationItemColors;
                }
                if (i9 != 0) {
                    mutableInteractionSource3 = null;
                } else {
                    mutableInteractionSource3 = mutableInteractionSource;
                }
                i14 = i13;
                modifier4 = modifier2;
            }
            boolean z115 = z5;
            int i11117 = iM4835iconPositionFors8pcRp0;
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1198748736, i14, -1, "androidx.compose.material3.WideNavigationRailItem (WideNavigationRail.kt:787)");
            }
            int i11118 = i14 << 3;
            composer2 = composerStartRestartGroup;
            m4846WideNavigationRailItemplit6k(z, (Function0<Unit>) function0, (Function2<? super Composer, ? super Integer, Unit>) function4, (Function2<? super Composer, ? super Integer, Unit>) function5, z115, modifier4, z9, i11117, navigationItemColorsColors, mutableInteractionSource3, composer2, (i14 & 8190) | ((i14 >> 6) & 57344) | (458752 & i11118) | (i11118 & 3670016) | (29360128 & i14) | (234881024 & i14) | (i14 & C.ENCODING_PCM_DOUBLE), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            z8 = z115;
            modifier3 = modifier4;
            z7 = z9;
            i12 = i11117;
            navigationItemColors2 = navigationItemColorsColors;
            mutableInteractionSource2 = mutableInteractionSource3;
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            navigationItemColors2 = navigationItemColors;
            modifier3 = modifier2;
            z7 = z4;
            z8 = z5;
            i12 = iM4835iconPositionFors8pcRp0;
            mutableInteractionSource2 = mutableInteractionSource;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.WideNavigationRailKt$$ExternalSyntheticLambda19
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return WideNavigationRailKt.WideNavigationRailItem_pli_t6k$lambda$2(z, function0, function2, function3, modifier3, z7, z8, i12, navigationItemColors2, mutableInteractionSource2, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: ModalWideNavigationRailContent-pU6N4AM, reason: not valid java name */
    public static final void m4843ModalWideNavigationRailContentpU6N4AM(final boolean z, final boolean z2, final Animatable<Float, AnimationVector1D> animatable, final RailPredictiveBackState railPredictiveBackState, final Function1<? super Continuation<? super Unit>, ? extends Object> function1, final Modifier modifier, final ModalWideNavigationRailState modalWideNavigationRailState, final WideNavigationRailColors wideNavigationRailColors, final Shape shape, final float f, final Function2<? super Composer, ? super Integer, Unit> function2, final WindowInsets windowInsets, final boolean z3, final Arrangement.Vertical vertical, final Function2<? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        int i3;
        WideNavigationRailColors wideNavigationRailColors2;
        int i4;
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1166168276);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ModalWideNavigationRailContent)N(expanded,isStandaloneModal,predictiveBackProgress,predictiveBackState,modalAnimateToDismiss,modifier,railState,colors,shape,openModalRailMaxWidth:c#ui.unit.Dp,header,windowInsets,gesturesEnabled,arrangement,content)1185@56457L7,1186@56512L55,1190@56746L31,1188@56643L198,1195@56879L579,1218@57743L29,1219@57804L904,1238@58801L627,1260@59712L1311,1210@57464L3559:WideNavigationRail.kt#uh7d8r");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(z2) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= (i & 512) == 0 ? composerStartRestartGroup.changed(animatable) : composerStartRestartGroup.changedInstance(animatable) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i3 |= composerStartRestartGroup.changed(railPredictiveBackState) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function1) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i3 |= composerStartRestartGroup.changed(modifier) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(modalWideNavigationRailState) ? 1048576 : 524288;
        }
        if ((i & 12582912) == 0) {
            wideNavigationRailColors2 = wideNavigationRailColors;
            i3 |= composerStartRestartGroup.changed(wideNavigationRailColors2) ? 8388608 : 4194304;
        } else {
            wideNavigationRailColors2 = wideNavigationRailColors;
        }
        if ((i & 100663296) == 0) {
            i3 |= composerStartRestartGroup.changed(shape) ? 67108864 : 33554432;
        }
        if ((i & 805306368) == 0) {
            i3 |= composerStartRestartGroup.changed(f) ? C.BUFFER_FLAG_LAST_SAMPLE : 268435456;
        }
        if ((i2 & 6) == 0) {
            i4 = i2 | (composerStartRestartGroup.changedInstance(function2) ? 4 : 2);
        } else {
            i4 = i2;
        }
        if ((i2 & 48) == 0) {
            i4 |= composerStartRestartGroup.changed(windowInsets) ? 32 : 16;
        }
        if ((i2 & 384) == 0) {
            i4 |= composerStartRestartGroup.changed(z3) ? 256 : 128;
        }
        if ((i2 & 3072) == 0) {
            i4 |= composerStartRestartGroup.changed(vertical) ? 2048 : 1024;
        }
        if ((i2 & 24576) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(function3) ? 16384 : 8192;
        }
        int i5 = i4;
        if (!composerStartRestartGroup.shouldExecute(((i3 & 306783379) == 306783378 && (i5 & 9363) == 9362) ? false : true, i3 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1166168276, i3, i5, "androidx.compose.material3.ModalWideNavigationRailContent (WideNavigationRail.kt:1184)");
            }
            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composerStartRestartGroup.consume(localLayoutDirection);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final boolean z4 = objConsume == LayoutDirection.Rtl;
            Strings.Companion companion = Strings.INSTANCE;
            final String strM5086getString2EP1pXo = Strings_androidKt.m5086getString2EP1pXo(Strings.m5002constructorimpl(R.string.m3c_wide_navigation_rail_pane_title), composerStartRestartGroup, 0);
            AnchoredDraggableDefaults anchoredDraggableDefaults = AnchoredDraggableDefaults.INSTANCE;
            AnchoredDraggableState<WideNavigationRailValue> anchoredDraggableState$material3 = modalWideNavigationRailState.getAnchoredDraggableState$material3();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 298780395, "CC(remember):WideNavigationRail.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: androidx.compose.material3.WideNavigationRailKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return Float.valueOf(WideNavigationRailKt.ModalWideNavigationRailContent_pU6N4AM$lambda$0$0(((Float) obj).floatValue()));
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            TargetedFlingBehavior targetedFlingBehaviorFlingBehavior = anchoredDraggableDefaults.flingBehavior(anchoredDraggableState$material3, (Function1) objRememberedValue, modalWideNavigationRailState.getAnimationSpec(), composerStartRestartGroup, (AnchoredDraggableDefaults.$stable << 9) | 48, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 298785199, "CC(remember):WideNavigationRail.kt#9igjgp");
            boolean zChanged = composerStartRestartGroup.changed(targetedFlingBehaviorFlingBehavior);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new WideNavigationRailKt$ModalWideNavigationRailContent$railFlingBehavior$1$1(targetedFlingBehaviorFlingBehavior, function1);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            WideNavigationRailKt$ModalWideNavigationRailContent$railFlingBehavior$1$1 wideNavigationRailKt$ModalWideNavigationRailContent$railFlingBehavior$1$1 = (WideNavigationRailKt$ModalWideNavigationRailContent$railFlingBehavior$1$1) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            long modalContainerColor = wideNavigationRailColors2.getModalContainerColor();
            long modalContentColor = wideNavigationRailColors2.getModalContentColor();
            Modifier modifierFillMaxHeight$default = SizeKt.fillMaxHeight$default(SizeKt.m1273widthInVpY3zN4$default(modifier, 0.0f, f, 1, null), 0.0f, 1, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 298812297, "CC(remember):WideNavigationRail.kt#9igjgp");
            boolean zChanged2 = composerStartRestartGroup.changed(strM5086getString2EP1pXo);
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (zChanged2 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new Function1() { // from class: androidx.compose.material3.WideNavigationRailKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return WideNavigationRailKt.ModalWideNavigationRailContent_pU6N4AM$lambda$2$0(strM5086getString2EP1pXo, (SemanticsPropertyReceiver) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierSemantics$default = SemanticsModifierKt.semantics$default(modifierFillMaxHeight$default, false, (Function1) objRememberedValue3, 1, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 298815124, "CC(remember):WideNavigationRail.kt#9igjgp");
            boolean zChangedInstance = ((i3 & 7168) == 2048) | ((i3 & 896) == 256 || ((i3 & 512) != 0 && composerStartRestartGroup.changedInstance(animatable))) | composerStartRestartGroup.changedInstance(modalWideNavigationRailState) | composerStartRestartGroup.changed(z4);
            Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue4 = new Function1() { // from class: androidx.compose.material3.WideNavigationRailKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return WideNavigationRailKt.ModalWideNavigationRailContent_pU6N4AM$lambda$3$0(animatable, modalWideNavigationRailState, railPredictiveBackState, z4, (GraphicsLayerScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierGraphicsLayer = GraphicsLayerModifierKt.graphicsLayer(modifierSemantics$default, (Function1) objRememberedValue4);
            AnchoredDraggableState<WideNavigationRailValue> anchoredDraggableState$material4 = modalWideNavigationRailState.getAnchoredDraggableState$material3();
            Orientation orientation = Orientation.Horizontal;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 298846751, "CC(remember):WideNavigationRail.kt#9igjgp");
            boolean zChangedInstance2 = ((i3 & 112) == 32) | composerStartRestartGroup.changedInstance(modalWideNavigationRailState);
            Object objRememberedValue5 = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance2 || objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue5 = new Function2() { // from class: androidx.compose.material3.WideNavigationRailKt$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return WideNavigationRailKt.ModalWideNavigationRailContent_pU6N4AM$lambda$4$0(z2, modalWideNavigationRailState, (IntSize) obj, (Constraints) obj2);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierAnchoredDraggable$default = AnchoredDraggableKt.anchoredDraggable$default(DraggableAnchorsKt.draggableAnchors(modifierGraphicsLayer, anchoredDraggableState$material4, orientation, (Function2) objRememberedValue5), modalWideNavigationRailState.getAnchoredDraggableState$material3(), Orientation.Horizontal, z3, null, null, wideNavigationRailKt$ModalWideNavigationRailContent$railFlingBehavior$1$1, 24, null);
            composer2 = composerStartRestartGroup;
            final WideNavigationRailColors wideNavigationRailColors3 = wideNavigationRailColors2;
            SurfaceKt.m4323SurfaceT9BRK9s(modifierAnchoredDraggable$default, shape, modalContainerColor, modalContentColor, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(-616565625, true, new Function2() { // from class: androidx.compose.material3.WideNavigationRailKt$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return WideNavigationRailKt.ModalWideNavigationRailContent_pU6N4AM$lambda$5(animatable, railPredictiveBackState, z4, z, wideNavigationRailColors3, shape, function2, windowInsets, vertical, function3, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer2, 54), composer2, ((i3 >> 21) & 112) | 12582912, 112);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.WideNavigationRailKt$$ExternalSyntheticLambda10
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return WideNavigationRailKt.ModalWideNavigationRailContent_pU6N4AM$lambda$6(z, z2, animatable, railPredictiveBackState, function1, modifier, modalWideNavigationRailState, wideNavigationRailColors, shape, f, function2, windowInsets, z3, vertical, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ModalWideNavigationRailContent_pU6N4AM$lambda$2$0(String str, SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.setPaneTitle(semanticsPropertyReceiver, str);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ModalWideNavigationRailContent_pU6N4AM$lambda$3$0(Animatable animatable, ModalWideNavigationRailState modalWideNavigationRailState, RailPredictiveBackState railPredictiveBackState, boolean z, GraphicsLayerScope graphicsLayerScope) {
        float fFloatValue = ((Number) animatable.getValue()).floatValue();
        if (fFloatValue <= 0.0f) {
            return Unit.INSTANCE;
        }
        float currentOffset = modalWideNavigationRailState.getCurrentOffset();
        float fIntBitsToFloat = Float.intBitsToFloat((int) (graphicsLayerScope.getSize() >> 32));
        if (!Float.isNaN(currentOffset) && !Float.isNaN(fIntBitsToFloat) && fIntBitsToFloat != 0.0f) {
            graphicsLayerScope.setScaleX(calculatePredictiveBackScaleX(graphicsLayerScope, fFloatValue, railPredictiveBackState.getSwipeEdgeMatchesRail()));
            graphicsLayerScope.setScaleY(calculatePredictiveBackScaleY(graphicsLayerScope, fFloatValue));
            graphicsLayerScope.mo7017setTransformOrigin__ExYCQ(TransformOriginKt.TransformOrigin(z ? 1.0f : 0.0f, 0.5f));
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Pair ModalWideNavigationRailContent_pU6N4AM$lambda$4$0(boolean z, ModalWideNavigationRailState modalWideNavigationRailState, IntSize intSize, Constraints constraints) {
        final float f = 0.0f;
        final float f2 = z ? -((int) (intSize.m9862unboximpl() >> 32)) : 0.0f;
        return TuplesKt.to(AnchoredDraggableKt.DraggableAnchors(new Function1() { // from class: androidx.compose.material3.WideNavigationRailKt$$ExternalSyntheticLambda14
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return WideNavigationRailKt.ModalWideNavigationRailContent_pU6N4AM$lambda$4$0$0(f2, f, (DraggableAnchorsConfig) obj);
            }
        }), modalWideNavigationRailState.getTargetValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ModalWideNavigationRailContent_pU6N4AM$lambda$4$0$0(float f, float f2, DraggableAnchorsConfig draggableAnchorsConfig) {
        draggableAnchorsConfig.at(WideNavigationRailValue.Collapsed, f);
        draggableAnchorsConfig.at(WideNavigationRailValue.Expanded, f2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ModalWideNavigationRailContent_pU6N4AM$lambda$5(final Animatable animatable, final RailPredictiveBackState railPredictiveBackState, final boolean z, boolean z2, WideNavigationRailColors wideNavigationRailColors, Shape shape, Function2 function2, WindowInsets windowInsets, Arrangement.Vertical vertical, Function2 function3, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C1263@59810L939,1261@59722L1295:WideNavigationRail.kt#uh7d8r");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-616565625, i, -1, "androidx.compose.material3.ModalWideNavigationRailContent.<anonymous> (WideNavigationRail.kt:1261)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 185925298, "CC(remember):WideNavigationRail.kt#9igjgp");
            boolean zChangedInstance = composer.changedInstance(animatable) | composer.changed(railPredictiveBackState) | composer.changed(z);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: androidx.compose.material3.WideNavigationRailKt$$ExternalSyntheticLambda12
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return WideNavigationRailKt.ModalWideNavigationRailContent_pU6N4AM$lambda$5$0$0(animatable, railPredictiveBackState, z, (GraphicsLayerScope) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            WideNavigationRailLayout(GraphicsLayerModifierKt.graphicsLayer(companion, (Function1) objRememberedValue), true, z2, wideNavigationRailColors, shape, function2, windowInsets, vertical, function3, composer, 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ModalWideNavigationRailContent_pU6N4AM$lambda$5$0$0(Animatable animatable, RailPredictiveBackState railPredictiveBackState, boolean z, GraphicsLayerScope graphicsLayerScope) {
        float fFloatValue = ((Number) animatable.getValue()).floatValue();
        if (fFloatValue <= 0.0f) {
            return Unit.INSTANCE;
        }
        float fCalculatePredictiveBackScaleX = calculatePredictiveBackScaleX(graphicsLayerScope, fFloatValue, railPredictiveBackState.getSwipeEdgeMatchesRail());
        graphicsLayerScope.setScaleX(fCalculatePredictiveBackScaleX == 0.0f ? 1.0f : calculatePredictiveBackScaleY(graphicsLayerScope, fFloatValue) / fCalculatePredictiveBackScaleX);
        graphicsLayerScope.mo7017setTransformOrigin__ExYCQ(TransformOriginKt.TransformOrigin(z ? 0.0f : 1.0f, 0.5f));
        return Unit.INSTANCE;
    }

    private static final float calculatePredictiveBackScaleX(GraphicsLayerScope graphicsLayerScope, float f, boolean z) {
        float fIntBitsToFloat = Float.intBitsToFloat((int) (graphicsLayerScope.getSize() >> 32));
        if (Float.isNaN(fIntBitsToFloat) || fIntBitsToFloat == 0.0f) {
            return 1.0f;
        }
        return (((z ? 1.0f : -1.0f) * MathHelpersKt.lerp(0.0f, Math.min(graphicsLayerScope.mo754toPx0680j_4(PredictiveBackMaxScaleXDistance), fIntBitsToFloat), f)) / fIntBitsToFloat) + 1.0f;
    }

    private static final float calculatePredictiveBackScaleY(GraphicsLayerScope graphicsLayerScope, float f) {
        float fIntBitsToFloat = Float.intBitsToFloat((int) (graphicsLayerScope.getSize() & 4294967295L));
        if (Float.isNaN(fIntBitsToFloat) || fIntBitsToFloat == 0.0f) {
            return 1.0f;
        }
        return 1.0f - (MathHelpersKt.lerp(0.0f, Math.min(graphicsLayerScope.mo754toPx0680j_4(PredictiveBackMaxScaleYDistance), fIntBitsToFloat), f) / fIntBitsToFloat);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: Scrim-3J-VO9M, reason: not valid java name */
    public static final void m4844Scrim3JVO9M(final long j, final Function1<? super Continuation<? super Unit>, ? extends Object> function1, final boolean z, Composer composer, final int i) {
        int i2;
        Modifier.Companion companionSemantics;
        Composer composerStartRestartGroup = composer.startRestartGroup(144695261);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Scrim)N(color:c#ui.graphics.Color,onDismissRequest,visible):WideNavigationRail.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(j) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function1) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changed(z) ? 256 : 128;
        }
        if (composerStartRestartGroup.shouldExecute((i2 & Token.DOTQUERY) != 146, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(144695261, i2, -1, "androidx.compose.material3.Scrim (WideNavigationRail.kt:1319)");
            }
            if (j != 16) {
                composerStartRestartGroup.startReplaceGroup(-1530502131);
                ComposerKt.sourceInformation(composerStartRestartGroup, "1325@62158L7,1322@61927L253,1327@62204L34,1328@62268L28,1342@62850L79,1342@62796L133,1346@62963L35,1346@62939L59");
                int i3 = i2;
                final State<Float> stateAnimateFloatAsState = AnimateAsStateKt.animateFloatAsState(z ? 1.0f : 0.0f, MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultEffects, composerStartRestartGroup, 6), 0.0f, null, null, composerStartRestartGroup, 0, 28);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1613205855, "CC(remember):WideNavigationRail.kt#9igjgp");
                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                final MutableState mutableState = (MutableState) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Strings.Companion companion = Strings.INSTANCE;
                final String strM5086getString2EP1pXo = Strings_androidKt.m5086getString2EP1pXo(Strings.m5002constructorimpl(R.string.m3c_wide_navigation_rail_close_rail), composerStartRestartGroup, 0);
                if (z) {
                    composerStartRestartGroup.startReplaceGroup(-1530067263);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "1331@62411L40,1332@62508L219");
                    Modifier.Companion companion2 = Modifier.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1613212485, "CC(remember):WideNavigationRail.kt#9igjgp");
                    WideNavigationRailKt$Scrim$dismissModalRail$1$1 wideNavigationRailKt$Scrim$dismissModalRail$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (wideNavigationRailKt$Scrim$dismissModalRail$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                        wideNavigationRailKt$Scrim$dismissModalRail$1$1RememberedValue = new WideNavigationRailKt$Scrim$dismissModalRail$1$1(mutableState);
                        composerStartRestartGroup.updateRememberedValue(wideNavigationRailKt$Scrim$dismissModalRail$1$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Modifier modifierPointerInput = SuspendingPointerInputFilterKt.pointerInput(companion2, function1, (PointerInputEventHandler) wideNavigationRailKt$Scrim$dismissModalRail$1$1RememberedValue);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1613215768, "CC(remember):WideNavigationRail.kt#9igjgp");
                    boolean zChanged = composerStartRestartGroup.changed(strM5086getString2EP1pXo);
                    Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (zChanged || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = new Function1() { // from class: androidx.compose.material3.WideNavigationRailKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return WideNavigationRailKt.Scrim_3J_VO9M$lambda$5$0(strM5086getString2EP1pXo, mutableState, (SemanticsPropertyReceiver) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    companionSemantics = SemanticsModifierKt.semantics(modifierPointerInput, true, (Function1) objRememberedValue2);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(-1529687203);
                    composerStartRestartGroup.endReplaceGroup();
                    companionSemantics = Modifier.INSTANCE;
                }
                Modifier modifierThen = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null).then(companionSemantics);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1613226572, "CC(remember):WideNavigationRail.kt#9igjgp");
                boolean zChanged2 = ((i3 & 14) == 4) | composerStartRestartGroup.changed(stateAnimateFloatAsState);
                Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (zChanged2 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue3 = new Function1() { // from class: androidx.compose.material3.WideNavigationRailKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return WideNavigationRailKt.Scrim_3J_VO9M$lambda$6$0(j, stateAnimateFloatAsState, (DrawScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                CanvasKt.Canvas(modifierThen, (Function1) objRememberedValue3, composerStartRestartGroup, 0);
                Boolean boolValueOf = Boolean.valueOf(Scrim_3J_VO9M$lambda$2(mutableState));
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1613230144, "CC(remember):WideNavigationRail.kt#9igjgp");
                boolean zChangedInstance = composerStartRestartGroup.changedInstance(function1);
                WideNavigationRailKt$Scrim$2$1 wideNavigationRailKt$Scrim$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (zChangedInstance || wideNavigationRailKt$Scrim$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                    wideNavigationRailKt$Scrim$2$1RememberedValue = new WideNavigationRailKt$Scrim$2$1(function1, mutableState, null);
                    composerStartRestartGroup.updateRememberedValue(wideNavigationRailKt$Scrim$2$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.LaunchedEffect(boolValueOf, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) wideNavigationRailKt$Scrim$2$1RememberedValue, composerStartRestartGroup, 0);
            } else {
                composerStartRestartGroup.startReplaceGroup(-1591934459);
            }
            composerStartRestartGroup.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.WideNavigationRailKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return WideNavigationRailKt.Scrim_3J_VO9M$lambda$8(j, function1, z, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean Scrim_3J_VO9M$lambda$2(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Scrim_3J_VO9M$lambda$3(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Scrim_3J_VO9M$lambda$5$0(String str, final MutableState mutableState, SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.setContentDescription(semanticsPropertyReceiver, str);
        SemanticsPropertiesKt.onClick$default(semanticsPropertyReceiver, null, new Function0() { // from class: androidx.compose.material3.WideNavigationRailKt$$ExternalSyntheticLambda17
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(WideNavigationRailKt.Scrim_3J_VO9M$lambda$5$0$0(mutableState));
            }
        }, 1, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean Scrim_3J_VO9M$lambda$5$0$0(MutableState mutableState) {
        Scrim_3J_VO9M$lambda$3(mutableState, true);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Scrim_3J_VO9M$lambda$6$0(long j, State state, DrawScope drawScope) {
        DrawScope.m7389drawRectnJ9OG0$default(drawScope, j, 0L, 0L, RangesKt.coerceIn(Scrim_3J_VO9M$lambda$0(state), 0.0f, 1.0f), null, null, 0, 118, null);
        return Unit.INSTANCE;
    }

    public static final float getWNRItemNoLabelIndicatorPadding() {
        return WNRItemNoLabelIndicatorPadding;
    }

    static {
        float f = 2;
        WNRItemNoLabelIndicatorPadding = Dp.m9687constructorimpl(Dp.m9687constructorimpl(NavigationRailVerticalItemTokens.INSTANCE.m5589getActiveIndicatorWidthD9Ej5fM() - NavigationRailBaselineItemTokens.INSTANCE.m5572getIconSizeD9Ej5fM()) / f);
        ItemTopIconIndicatorVerticalPadding = Dp.m9687constructorimpl(Dp.m9687constructorimpl(NavigationRailVerticalItemTokens.INSTANCE.m5588getActiveIndicatorHeightD9Ej5fM() - NavigationRailBaselineItemTokens.INSTANCE.m5572getIconSizeD9Ej5fM()) / f);
        ItemTopIconIndicatorHorizontalPadding = Dp.m9687constructorimpl(Dp.m9687constructorimpl(NavigationRailVerticalItemTokens.INSTANCE.m5589getActiveIndicatorWidthD9Ej5fM() - NavigationRailBaselineItemTokens.INSTANCE.m5572getIconSizeD9Ej5fM()) / f);
        ItemStartIconIndicatorVerticalPadding = Dp.m9687constructorimpl(Dp.m9687constructorimpl(NavigationRailHorizontalItemTokens.INSTANCE.m5583getActiveIndicatorHeightD9Ej5fM() - NavigationRailBaselineItemTokens.INSTANCE.m5572getIconSizeD9Ej5fM()) / f);
    }

    public static final ProvidableCompositionLocal<WideNavigationRailOverride> getLocalWideNavigationRailOverride() {
        return LocalWideNavigationRailOverride;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WideNavigationRailOverride LocalWideNavigationRailOverride$lambda$0() {
        return DefaultWideNavigationRailOverride.INSTANCE;
    }

    public static final ProvidableCompositionLocal<ModalWideNavigationRailOverride> getLocalModalWideNavigationRailOverride() {
        return LocalModalWideNavigationRailOverride;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ModalWideNavigationRailOverride LocalModalWideNavigationRailOverride$lambda$0() {
        return DefaultModalWideNavigationRailOverride.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float WideNavigationRailLayout$lambda$6(State<Dp> state) {
        return state.getValue().m9701unboximpl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float WideNavigationRailLayout$lambda$7(State<Dp> state) {
        return state.getValue().m9701unboximpl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float WideNavigationRailLayout$lambda$8(State<Dp> state) {
        return state.getValue().m9701unboximpl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float WideNavigationRailLayout$lambda$9(State<Dp> state) {
        return state.getValue().m9701unboximpl();
    }

    private static final float Scrim_3J_VO9M$lambda$0(State<Float> state) {
        return state.getValue().floatValue();
    }
}
