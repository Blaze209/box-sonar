package androidx.compose.material3;

import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.SingleValueAnimationKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.MutableTransitionState;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TransitionKt;
import androidx.compose.animation.core.TwoWayConverter;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.HoverableKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.interaction.HoverInteractionKt;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.IntrinsicKt;
import androidx.compose.foundation.layout.IntrinsicSize;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.material3.internal.AnimatedShapeKt;
import androidx.compose.material3.tokens.ListTokens;
import androidx.compose.material3.tokens.MotionSchemeKeyTokens;
import androidx.compose.material3.tokens.SegmentedMenuTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.TransformOrigin;
import androidx.compose.ui.graphics.TransformOriginKt;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.InspectionModeKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntRect;
import androidx.media3.common.C;
import androidx.media3.exoplayer.analytics.AnalyticsListener;
import androidx.profileinstaller.ProfileVerifier;
import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Menu.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000ª\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u000e\n\u0002\b\u000b\u001a\u007f\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u001c\u0010\u0011\u001a\u0018\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00010\u0012¢\u0006\u0002\b\u0014¢\u0006\u0002\b\u0015H\u0007¢\u0006\u0004\b\u0016\u0010\u0017\u001a\u0098\u0001\u0010\u0018\u001a\u00020\u00012\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00010\u001a2\u0011\u0010\u001b\u001a\r\u0012\u0004\u0012\u00020\u00010\u001a¢\u0006\u0002\b\u00142\u0006\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0015\b\u0002\u0010\u001e\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u001a¢\u0006\u0002\b\u00142\u0015\b\u0002\u0010\u001f\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u001a¢\u0006\u0002\b\u00142\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020#2\b\b\u0002\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0007¢\u0006\u0002\u0010$\u001a½\u0001\u0010\u0018\u001a\u00020\u00012\u0006\u0010%\u001a\u00020!2\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u00010\u00122\u0011\u0010\u001b\u001a\r\u0012\u0004\u0012\u00020\u00010\u001a¢\u0006\u0002\b\u00142\u0006\u0010\u0002\u001a\u00020'2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0015\b\u0002\u0010\u001e\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u001a¢\u0006\u0002\b\u00142\u0015\b\u0002\u0010(\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u001a¢\u0006\u0002\b\u00142\u0015\b\u0002\u0010\u001f\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u001a¢\u0006\u0002\b\u00142\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020#2\b\b\u0002\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0007¢\u0006\u0002\u0010)\u001a·\u0001\u0010\u0018\u001a\u00020\u00012\u0006\u0010*\u001a\u00020!2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00010\u001a2\u0011\u0010\u001b\u001a\r\u0012\u0004\u0012\u00020\u00010\u001a¢\u0006\u0002\b\u00142\u0006\u0010\u0002\u001a\u00020'2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0015\b\u0002\u0010\u001e\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u001a¢\u0006\u0002\b\u00142\u0015\b\u0002\u0010(\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u001a¢\u0006\u0002\b\u00142\u0015\b\u0002\u0010\u001f\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u001a¢\u0006\u0002\b\u00142\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020#2\b\b\u0002\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0007¢\u0006\u0002\u0010+\u001a\u0083\u0001\u0010,\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010-\u001a\b\u0012\u0004\u0012\u00020!0.2\f\u0010/\u001a\b\u0012\u0004\u0012\u000201002\u0006\u00102\u001a\u0002032\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u001c\u0010\u0011\u001a\u0018\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00010\u0012¢\u0006\u0002\b\u0014¢\u0006\u0002\b\u0015H\u0001¢\u0006\u0004\b4\u00105\u001a§\u0001\u00106\u001a\u00020\u00012\u0006\u0010*\u001a\u00020!2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00010\u001a2\u0011\u0010\u001b\u001a\r\u0012\u0004\u0012\u00020\u00010\u001a¢\u0006\u0002\b\u00142\u0006\u0010\u0004\u001a\u00020\u00052\u0013\u0010\u001e\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u001a¢\u0006\u0002\b\u00142\u0013\u00107\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u001a¢\u0006\u0002\b\u00142\u0013\u0010\u001f\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u001a¢\u0006\u0002\b\u00142\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010\u0002\u001a\u00020'2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0001¢\u0006\u0002\u00108\u001a\u0082\u0001\u00106\u001a\u00020\u00012\u0011\u0010\u001b\u001a\r\u0012\u0004\u0012\u00020\u00010\u001a¢\u0006\u0002\b\u00142\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00010\u001a2\u0006\u0010\u0004\u001a\u00020\u00052\u0013\u0010\u001e\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u001a¢\u0006\u0002\b\u00142\u0013\u0010\u001f\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u001a¢\u0006\u0002\b\u00142\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0001¢\u0006\u0002\u0010@\u001a\u001d\u0010A\u001a\u0002012\u0006\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020CH\u0000¢\u0006\u0002\u0010E\u001a+\u0010F\u001a\u00020\u001d2\u0006\u0010\u0002\u001a\u00020'2\u0006\u0010*\u001a\u00020!2\f\u0010G\u001a\b\u0012\u0004\u0012\u00020I0HH\u0003¢\u0006\u0002\u0010J\u001a3\u0010F\u001a\u00020\u001d2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010K\u001a\u00020!2\u0006\u0010L\u001a\u00020!2\f\u0010G\u001a\b\u0012\u0004\u0012\u00020I0HH\u0003¢\u0006\u0002\u0010M\u001a+\u0010N\u001a\u00020\u00012\u001c\u0010\u0011\u001a\u0018\u0012\u0004\u0012\u00020O\u0012\u0004\u0012\u00020\u00010\u0012¢\u0006\u0002\b\u0014¢\u0006\u0002\b\u0015H\u0003¢\u0006\u0002\u0010P\"\u001e\u00109\u001a\u00020!*\u00020'8@X\u0080\u0004¢\u0006\f\u0012\u0004\b:\u0010;\u001a\u0004\b<\u0010=\"\u001e\u00109\u001a\u00020!*\u00020\u00038@X\u0080\u0004¢\u0006\f\u0012\u0004\b:\u0010>\u001a\u0004\b<\u0010?\"\u0016\u0010Q\u001a\u00020\tX\u0080\u0004¢\u0006\n\n\u0002\u0010T\u001a\u0004\bR\u0010S\"\u0016\u0010U\u001a\u00020\tX\u0080\u0004¢\u0006\n\n\u0002\u0010T\u001a\u0004\bV\u0010S\"\u0010\u0010W\u001a\u00020\tX\u0082\u0004¢\u0006\u0004\n\u0002\u0010T\"\u0016\u0010X\u001a\u00020\tX\u0080\u0004¢\u0006\n\n\u0002\u0010T\u001a\u0004\bY\u0010S\"\u0016\u0010Z\u001a\u00020\tX\u0080\u0004¢\u0006\n\n\u0002\u0010T\u001a\u0004\b[\u0010S\"\u000e\u0010\\\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010]\u001a\u00020\tX\u0082\u0004¢\u0006\u0004\n\u0002\u0010T\"\u0016\u0010^\u001a\u00020\tX\u0080\u0004¢\u0006\n\n\u0002\u0010T\u001a\u0004\b_\u0010S\"\u0016\u0010`\u001a\u00020\tX\u0080\u0004¢\u0006\n\n\u0002\u0010T\u001a\u0004\ba\u0010S\"\u0016\u0010b\u001a\u00020\tX\u0080\u0004¢\u0006\n\n\u0002\u0010T\u001a\u0004\bc\u0010S\"\u0016\u0010d\u001a\u00020\tX\u0080\u0004¢\u0006\n\n\u0002\u0010T\u001a\u0004\be\u0010S\"\u000e\u0010f\u001a\u00020gX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010h\u001a\u00020gX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010i\u001a\u00020gX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010j\u001a\u00020gX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010k\u001a\u00020IX\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010l\u001a\u00020IX\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010m\u001a\u00020IX\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010n\u001a\u00020IX\u0080T¢\u0006\u0002\n\u0000¨\u0006o²\u0006\n\u0010L\u001a\u00020!X\u008a\u0084\u0002²\u0006\n\u0010K\u001a\u00020!X\u008a\u008e\u0002²\u0006\n\u0010p\u001a\u00020IX\u008a\u0084\u0002²\u0006\n\u0010q\u001a\u00020IX\u008a\u0084\u0002²\u0006\n\u0010r\u001a\u00020\u0007X\u008a\u0084\u0002"}, d2 = {"DropdownMenuGroup", "", "shapes", "Landroidx/compose/material3/MenuGroupShapes;", "modifier", "Landroidx/compose/ui/Modifier;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "tonalElevation", "Landroidx/compose/ui/unit/Dp;", "shadowElevation", androidx.compose.material.OutlinedTextFieldKt.BorderId, "Landroidx/compose/foundation/BorderStroke;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "DropdownMenuGroup-BfByrIA", "(Landroidx/compose/material3/MenuGroupShapes;Landroidx/compose/ui/Modifier;JFFLandroidx/compose/foundation/BorderStroke;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "DropdownMenuItem", ViewProps.ON_CLICK, "Lkotlin/Function0;", "text", "shape", "Landroidx/compose/ui/graphics/Shape;", MenuKt.LeadingIconLayoutId, MenuKt.TrailingIconLayoutId, "enabled", "", "colors", "Landroidx/compose/material3/MenuItemColors;", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/material3/MenuItemColors;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "checked", "onCheckedChange", "Landroidx/compose/material3/MenuItemShapes;", "checkedLeadingIcon", "(ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Landroidx/compose/material3/MenuItemShapes;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/material3/MenuItemColors;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;III)V", "selected", "(ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/material3/MenuItemShapes;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/material3/MenuItemColors;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;III)V", "DropdownMenuContent", "expandedState", "Landroidx/compose/animation/core/MutableTransitionState;", "transformOriginState", "Landroidx/compose/runtime/MutableState;", "Landroidx/compose/ui/graphics/TransformOrigin;", "scrollState", "Landroidx/compose/foundation/ScrollState;", "DropdownMenuContent-Qj0Zi0g", "(Landroidx/compose/ui/Modifier;Landroidx/compose/animation/core/MutableTransitionState;Landroidx/compose/runtime/MutableState;Landroidx/compose/foundation/ScrollState;Landroidx/compose/ui/graphics/Shape;JFFLandroidx/compose/foundation/BorderStroke;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;I)V", "DropdownMenuItemContent", "selectedLeadingIcon", "(ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/material3/MenuItemColors;Landroidx/compose/material3/MenuItemShapes;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "hasRoundedCornerShapes", "getHasRoundedCornerShapes$annotations", "(Landroidx/compose/material3/MenuItemShapes;)V", "getHasRoundedCornerShapes", "(Landroidx/compose/material3/MenuItemShapes;)Z", "(Landroidx/compose/material3/MenuGroupShapes;)V", "(Landroidx/compose/material3/MenuGroupShapes;)Z", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/material3/MenuItemColors;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;I)V", "calculateTransformOrigin", "anchorBounds", "Landroidx/compose/ui/unit/IntRect;", "menuBounds", "(Landroidx/compose/ui/unit/IntRect;Landroidx/compose/ui/unit/IntRect;)J", "shapeByInteraction", "animationSpec", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "", "(Landroidx/compose/material3/MenuItemShapes;ZLandroidx/compose/animation/core/FiniteAnimationSpec;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "hasBeenHovered", "hovered", "(Landroidx/compose/material3/MenuGroupShapes;ZZLandroidx/compose/animation/core/FiniteAnimationSpec;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "WrappedLeadingIcon", "Landroidx/compose/foundation/layout/BoxScope;", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;I)V", "MenuVerticalMargin", "getMenuVerticalMargin", "()F", "F", "MenuHorizontalMargin", "getMenuHorizontalMargin", "MenuListItemContainerHeight", "DropdownMenuItemHorizontalPadding", "getDropdownMenuItemHorizontalPadding", "DropdownMenuGroupVerticalPadding", "getDropdownMenuGroupVerticalPadding", "DropdownMenuSelectableItemPadding", "DropdownMenuIconTextPadding", "DropdownMenuVerticalPadding", "getDropdownMenuVerticalPadding", "DropdownMenuItemDefaultMinWidth", "getDropdownMenuItemDefaultMinWidth", "DropdownMenuItemDefaultMaxWidth", "getDropdownMenuItemDefaultMaxWidth", "DropdownMenuGroupDefaultMinHeight", "getDropdownMenuGroupDefaultMinHeight", "LeadingIconLayoutId", "", "TextLayoutId", "TrailingIconLayoutId", "GhostLeadingIconLayoutId", "ExpandedScaleTarget", "ClosedScaleTarget", "ExpandedAlphaTarget", "ClosedAlphaTarget", "material3", "scale", "alpha", "animatedContainerColor"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class MenuKt {
    public static final float ClosedAlphaTarget = 0.0f;
    public static final float ClosedScaleTarget = 0.8f;
    private static final float DropdownMenuIconTextPadding;
    private static final float DropdownMenuVerticalPadding;
    public static final float ExpandedAlphaTarget = 1.0f;
    public static final float ExpandedScaleTarget = 1.0f;
    private static final String GhostLeadingIconLayoutId = "ghostLeadingIcon";
    private static final String LeadingIconLayoutId = "leadingIcon";
    private static final float MenuHorizontalMargin;
    private static final float MenuListItemContainerHeight;
    private static final float MenuVerticalMargin;
    private static final String TextLayoutId = "text";
    private static final String TrailingIconLayoutId = "trailingIcon";
    private static final float DropdownMenuItemHorizontalPadding = Dp.m9687constructorimpl(12);
    private static final float DropdownMenuGroupVerticalPadding = Dp.m9687constructorimpl(2);
    private static final PaddingValues DropdownMenuSelectableItemPadding = PaddingKt.m1213PaddingValuesYgX7TsA$default(Dp.m9687constructorimpl(4), 0.0f, 2, null);
    private static final float DropdownMenuItemDefaultMinWidth = Dp.m9687constructorimpl(112);
    private static final float DropdownMenuItemDefaultMaxWidth = Dp.m9687constructorimpl(280);
    private static final float DropdownMenuGroupDefaultMinHeight = Dp.m9687constructorimpl(32);

    /* JADX INFO: Access modifiers changed from: private */
    public static final FiniteAnimationSpec DropdownMenuContent_Qj0Zi0g$lambda$0(FiniteAnimationSpec finiteAnimationSpec, Transition.Segment segment, Composer composer, int i) {
        composer.startReplaceGroup(-745957716);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-745957716, i, -1, "androidx.compose.material3.DropdownMenuContent.<anonymous> (Menu.kt:842)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return finiteAnimationSpec;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FiniteAnimationSpec DropdownMenuContent_Qj0Zi0g$lambda$3(FiniteAnimationSpec finiteAnimationSpec, Transition.Segment segment, Composer composer, int i) {
        composer.startReplaceGroup(2839488);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2839488, i, -1, "androidx.compose.material3.DropdownMenuContent.<anonymous> (Menu.kt:847)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return finiteAnimationSpec;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DropdownMenuContent_Qj0Zi0g$lambda$8(Modifier modifier, MutableTransitionState mutableTransitionState, MutableState mutableState, ScrollState scrollState, Shape shape, long j, float f, float f2, BorderStroke borderStroke, Function3 function3, int i, Composer composer, int i2) {
        m3796DropdownMenuContentQj0Zi0g(modifier, mutableTransitionState, mutableState, scrollState, shape, j, f, f2, borderStroke, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DropdownMenuGroup_BfByrIA$lambda$6(MenuGroupShapes menuGroupShapes, Modifier modifier, long j, float f, float f2, BorderStroke borderStroke, PaddingValues paddingValues, MutableInteractionSource mutableInteractionSource, Function3 function3, int i, int i2, Composer composer, int i3) {
        m3797DropdownMenuGroupBfByrIA(menuGroupShapes, modifier, j, f, f2, borderStroke, paddingValues, mutableInteractionSource, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DropdownMenuItem$lambda$1(Function0 function0, Function2 function2, Shape shape, Modifier modifier, Function2 function3, Function2 function4, boolean z, MenuItemColors menuItemColors, PaddingValues paddingValues, MutableInteractionSource mutableInteractionSource, int i, int i2, Composer composer, int i3) {
        DropdownMenuItem(function0, function2, shape, modifier, function3, function4, z, menuItemColors, paddingValues, mutableInteractionSource, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DropdownMenuItem$lambda$4(boolean z, Function1 function1, Function2 function2, MenuItemShapes menuItemShapes, Modifier modifier, Function2 function3, Function2 function4, Function2 function5, boolean z2, MenuItemColors menuItemColors, PaddingValues paddingValues, MutableInteractionSource mutableInteractionSource, int i, int i2, int i3, Composer composer, int i4) {
        DropdownMenuItem(z, (Function1<? super Boolean, Unit>) function1, (Function2<? super Composer, ? super Integer, Unit>) function2, menuItemShapes, modifier, (Function2<? super Composer, ? super Integer, Unit>) function3, (Function2<? super Composer, ? super Integer, Unit>) function4, (Function2<? super Composer, ? super Integer, Unit>) function5, z2, menuItemColors, paddingValues, mutableInteractionSource, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DropdownMenuItem$lambda$6(boolean z, Function0 function0, Function2 function2, MenuItemShapes menuItemShapes, Modifier modifier, Function2 function3, Function2 function4, Function2 function5, boolean z2, MenuItemColors menuItemColors, PaddingValues paddingValues, MutableInteractionSource mutableInteractionSource, int i, int i2, int i3, Composer composer, int i4) {
        DropdownMenuItem(z, (Function0<Unit>) function0, (Function2<? super Composer, ? super Integer, Unit>) function2, menuItemShapes, modifier, (Function2<? super Composer, ? super Integer, Unit>) function3, (Function2<? super Composer, ? super Integer, Unit>) function4, (Function2<? super Composer, ? super Integer, Unit>) function5, z2, menuItemColors, paddingValues, mutableInteractionSource, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DropdownMenuItemContent$lambda$3(boolean z, Function0 function0, Function2 function2, Modifier modifier, Function2 function3, Function2 function4, Function2 function5, boolean z2, MenuItemColors menuItemColors, MenuItemShapes menuItemShapes, PaddingValues paddingValues, MutableInteractionSource mutableInteractionSource, int i, int i2, Composer composer, int i3) {
        DropdownMenuItemContent(z, function0, function2, modifier, function3, function4, function5, z2, menuItemColors, menuItemShapes, paddingValues, mutableInteractionSource, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DropdownMenuItemContent$lambda$5(Function2 function2, Function0 function0, Modifier modifier, Function2 function3, Function2 function4, boolean z, MenuItemColors menuItemColors, PaddingValues paddingValues, MutableInteractionSource mutableInteractionSource, int i, Composer composer, int i2) {
        DropdownMenuItemContent(function2, function0, modifier, function3, function4, z, menuItemColors, paddingValues, mutableInteractionSource, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit WrappedLeadingIcon$lambda$0(Function3 function3, int i, Composer composer, int i2) {
        WrappedLeadingIcon(function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static /* synthetic */ void getHasRoundedCornerShapes$annotations(MenuGroupShapes menuGroupShapes) {
    }

    public static /* synthetic */ void getHasRoundedCornerShapes$annotations(MenuItemShapes menuItemShapes) {
    }

    /* JADX WARN: Code duplicated, block: B:100:0x012d  */
    /* JADX WARN: Code duplicated, block: B:107:0x0141 A[PHI: r0 r4 r5 r6 r7 r13 r15
      0x0141: PHI (r0v24 androidx.compose.foundation.BorderStroke) = (r0v13 androidx.compose.foundation.BorderStroke), (r0v27 androidx.compose.foundation.BorderStroke) binds: [B:123:0x0182, B:106:0x013d] A[DONT_GENERATE, DONT_INLINE]
      0x0141: PHI (r4v20 int) = (r4v16 int), (r4v22 int) binds: [B:123:0x0182, B:106:0x013d] A[DONT_GENERATE, DONT_INLINE]
      0x0141: PHI (r5v9 androidx.compose.foundation.layout.PaddingValues) = (r5v4 androidx.compose.foundation.layout.PaddingValues), (r5v10 androidx.compose.foundation.layout.PaddingValues) binds: [B:123:0x0182, B:106:0x013d] A[DONT_GENERATE, DONT_INLINE]
      0x0141: PHI (r6v9 androidx.compose.ui.Modifier) = (r6v5 androidx.compose.ui.Modifier), (r6v2 androidx.compose.ui.Modifier) binds: [B:123:0x0182, B:106:0x013d] A[DONT_GENERATE, DONT_INLINE]
      0x0141: PHI (r7v19 long) = (r7v9 long), (r7v6 long) binds: [B:123:0x0182, B:106:0x013d] A[DONT_GENERATE, DONT_INLINE]
      0x0141: PHI (r13v18 float) = (r13v4 float), (r13v2 float) binds: [B:123:0x0182, B:106:0x013d] A[DONT_GENERATE, DONT_INLINE]
      0x0141: PHI (r15v7 float) = (r15v3 float), (r15v2 float) binds: [B:123:0x0182, B:106:0x013d] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:108:0x014c A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:109:0x014e  */
    /* JADX WARN: Code duplicated, block: B:112:0x0157  */
    /* JADX WARN: Code duplicated, block: B:114:0x0161  */
    /* JADX WARN: Code duplicated, block: B:116:0x016a  */
    /* JADX WARN: Code duplicated, block: B:118:0x0173  */
    /* JADX WARN: Code duplicated, block: B:119:0x0175  */
    /* JADX WARN: Code duplicated, block: B:121:0x0179  */
    /* JADX WARN: Code duplicated, block: B:122:0x0180  */
    /* JADX WARN: Code duplicated, block: B:124:0x0184  */
    /* JADX WARN: Code duplicated, block: B:127:0x0196  */
    /* JADX WARN: Code duplicated, block: B:130:0x01a3  */
    /* JADX WARN: Code duplicated, block: B:132:0x01c0  */
    /* JADX WARN: Code duplicated, block: B:134:0x01d0  */
    /* JADX WARN: Code duplicated, block: B:137:0x01f8  */
    /* JADX WARN: Code duplicated, block: B:140:0x020f  */
    /* JADX WARN: Code duplicated, block: B:143:0x0275  */
    /* JADX WARN: Code duplicated, block: B:145:0x0283  */
    /* JADX WARN: Code duplicated, block: B:148:0x0298  */
    /* JADX WARN: Code duplicated, block: B:150:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:23:0x0048  */
    /* JADX WARN: Code duplicated, block: B:25:0x004c  */
    /* JADX WARN: Code duplicated, block: B:27:0x0054  */
    /* JADX WARN: Code duplicated, block: B:28:0x0057  */
    /* JADX WARN: Code duplicated, block: B:31:0x005d  */
    /* JADX WARN: Code duplicated, block: B:34:0x0063  */
    /* JADX WARN: Code duplicated, block: B:35:0x0066  */
    /* JADX WARN: Code duplicated, block: B:37:0x006a  */
    /* JADX WARN: Code duplicated, block: B:39:0x0072  */
    /* JADX WARN: Code duplicated, block: B:40:0x0075  */
    /* JADX WARN: Code duplicated, block: B:45:0x007f  */
    /* JADX WARN: Code duplicated, block: B:46:0x0082  */
    /* JADX WARN: Code duplicated, block: B:48:0x0086  */
    /* JADX WARN: Code duplicated, block: B:50:0x008e  */
    /* JADX WARN: Code duplicated, block: B:51:0x0091  */
    /* JADX WARN: Code duplicated, block: B:56:0x009e  */
    /* JADX WARN: Code duplicated, block: B:57:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:59:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:61:0x00af  */
    /* JADX WARN: Code duplicated, block: B:62:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:66:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:67:0x00c1  */
    /* JADX WARN: Code duplicated, block: B:69:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:71:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:72:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:76:0x00da  */
    /* JADX WARN: Code duplicated, block: B:77:0x00dd  */
    /* JADX WARN: Code duplicated, block: B:79:0x00e1  */
    /* JADX WARN: Code duplicated, block: B:81:0x00eb  */
    /* JADX WARN: Code duplicated, block: B:82:0x00ee  */
    /* JADX WARN: Code duplicated, block: B:87:0x00fd  */
    /* JADX WARN: Code duplicated, block: B:89:0x0103  */
    /* JADX WARN: Code duplicated, block: B:90:0x0106  */
    /* JADX WARN: Code duplicated, block: B:94:0x0114  */
    /* JADX WARN: Code duplicated, block: B:95:0x0116  */
    /* JADX WARN: Code duplicated, block: B:98:0x011f  */
    /* JADX INFO: renamed from: DropdownMenuGroup-BfByrIA, reason: not valid java name */
    public static final void m3797DropdownMenuGroupBfByrIA(final MenuGroupShapes menuGroupShapes, Modifier modifier, long j, float f, float f2, BorderStroke borderStroke, PaddingValues paddingValues, MutableInteractionSource mutableInteractionSource, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        int i3;
        final Modifier modifier2;
        long groupStandardContainerColor;
        int i4;
        float fM3754getTonalElevationD9Ej5fM;
        int i5;
        int i6;
        float fM3753getShadowElevationD9Ej5fM;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        boolean z;
        Composer composer2;
        final MutableInteractionSource mutableInteractionSource2;
        final Modifier modifier3;
        final long j2;
        final float f3;
        final float f4;
        final BorderStroke borderStroke2;
        final PaddingValues paddingValues2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        BorderStroke borderStroke3;
        final PaddingValues dropdownMenuGroupContentPadding;
        float f5;
        long j3;
        int i14;
        float f6;
        MutableInteractionSource mutableInteractionSource3;
        MutableInteractionSource mutableInteractionSource4;
        State<Boolean> stateCollectIsHoveredAsState;
        Object objRememberedValue;
        MutableState mutableState;
        Object objRememberedValue2;
        int i15;
        Composer composerStartRestartGroup = composer.startRestartGroup(1580422941);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(DropdownMenuGroup)N(shapes,modifier,containerColor:c#ui.graphics.Color,tonalElevation:c#ui.unit.Dp,shadowElevation:c#ui.unit.Dp,border,contentPadding,interactionSource,content)240@11856L25,241@11908L34,246@12053L14,247@12089L62,256@12419L86,249@12157L348:Menu.kt#uh7d8r");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(menuGroupShapes) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i16 = i2 & 2;
        if (i16 == 0) {
            if ((i & 48) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            if ((i & 384) == 0) {
                if ((i2 & 4) == 0) {
                    groupStandardContainerColor = j;
                    int i17 = composerStartRestartGroup.changed(groupStandardContainerColor) ? 256 : 128;
                    i3 |= i17;
                } else {
                    groupStandardContainerColor = j;
                }
                i3 |= i17;
            } else {
                groupStandardContainerColor = j;
            }
            i4 = i2 & 8;
            if (i4 != 0) {
                if ((i & 3072) == 0) {
                    fM3754getTonalElevationD9Ej5fM = f;
                    if (composerStartRestartGroup.changed(fM3754getTonalElevationD9Ej5fM)) {
                        i5 = 2048;
                    } else {
                        i5 = 1024;
                    }
                    i3 |= i5;
                }
                i6 = i2 & 16;
                if (i6 != 0) {
                    if ((i & 24576) == 0) {
                        fM3753getShadowElevationD9Ej5fM = f2;
                        if (composerStartRestartGroup.changed(fM3753getShadowElevationD9Ej5fM)) {
                            i7 = 16384;
                        } else {
                            i7 = 8192;
                        }
                        i3 |= i7;
                    }
                    i8 = i2 & 32;
                    if (i8 != 0) {
                        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    } else if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                        if (composerStartRestartGroup.changed(borderStroke)) {
                            i9 = 131072;
                        } else {
                            i9 = 65536;
                        }
                        i3 |= i9;
                    }
                    i10 = i2 & 64;
                    if (i10 != 0) {
                        i3 |= 1572864;
                    } else if ((i & 1572864) == 0) {
                        if (composerStartRestartGroup.changed(paddingValues)) {
                            i11 = 1048576;
                        } else {
                            i11 = 524288;
                        }
                        i3 |= i11;
                    }
                    i12 = i2 & 128;
                    if (i12 != 0) {
                        if ((i & 12582912) == 0) {
                            if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                                i13 = 8388608;
                            } else {
                                i13 = 4194304;
                            }
                            i3 |= i13;
                        }
                        if ((i & 100663296) == 0) {
                            if (composerStartRestartGroup.changedInstance(function3)) {
                                i15 = 67108864;
                            } else {
                                i15 = 33554432;
                            }
                            i3 |= i15;
                        }
                        if ((i3 & 38347923) != 38347922) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                            composerStartRestartGroup.startDefaults();
                            ComposerKt.sourceInformation(composerStartRestartGroup, "230@11333L27");
                            if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                if (i16 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                if ((i2 & 4) != 0) {
                                    groupStandardContainerColor = MenuDefaults.INSTANCE.getGroupStandardContainerColor(composerStartRestartGroup, 6);
                                    i3 &= -897;
                                }
                                if (i4 != 0) {
                                    fM3754getTonalElevationD9Ej5fM = MenuDefaults.INSTANCE.m3754getTonalElevationD9Ej5fM();
                                }
                                if (i6 != 0) {
                                    fM3753getShadowElevationD9Ej5fM = MenuDefaults.INSTANCE.m3753getShadowElevationD9Ej5fM();
                                }
                                if (i8 != 0) {
                                    borderStroke3 = null;
                                } else {
                                    borderStroke3 = borderStroke;
                                }
                                if (i10 != 0) {
                                    dropdownMenuGroupContentPadding = MenuDefaults.INSTANCE.getDropdownMenuGroupContentPadding();
                                } else {
                                    dropdownMenuGroupContentPadding = paddingValues;
                                }
                                if (i12 != 0) {
                                    f5 = fM3753getShadowElevationD9Ej5fM;
                                    j3 = groupStandardContainerColor;
                                    i14 = i3;
                                    f6 = fM3754getTonalElevationD9Ej5fM;
                                    mutableInteractionSource3 = null;
                                }
                                composerStartRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1580422941, i14, -1, "androidx.compose.material3.DropdownMenuGroup (Menu.kt:237)");
                                }
                                if (mutableInteractionSource3 == null) {
                                    composerStartRestartGroup.startReplaceGroup(948907198);
                                    ComposerKt.sourceInformation(composerStartRestartGroup, "239@11779L39");
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1631958076, "CC(remember):Menu.kt#9igjgp");
                                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                        objRememberedValue2 = InteractionSourceKt.MutableInteractionSource();
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                                    }
                                    mutableInteractionSource4 = (MutableInteractionSource) objRememberedValue2;
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                    composerStartRestartGroup.endReplaceGroup();
                                } else {
                                    composerStartRestartGroup.startReplaceGroup(-1631958727);
                                    composerStartRestartGroup.endReplaceGroup();
                                    mutableInteractionSource4 = mutableInteractionSource3;
                                }
                                stateCollectIsHoveredAsState = HoverInteractionKt.collectIsHoveredAsState(mutableInteractionSource4, composerStartRestartGroup, 0);
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1631953953, "CC(remember):Menu.kt#9igjgp");
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                mutableState = (MutableState) objRememberedValue;
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                if (DropdownMenuGroup_BfByrIA$lambda$1(stateCollectIsHoveredAsState)) {
                                    DropdownMenuGroup_BfByrIA$lambda$4(mutableState, true);
                                }
                                int i18 = i14 << 3;
                                BorderStroke borderStroke4 = borderStroke3;
                                composer2 = composerStartRestartGroup;
                                SurfaceKt.m4323SurfaceT9BRK9s(HoverableKt.hoverable$default(Modifier.INSTANCE, mutableInteractionSource4, false, 2, null), shapeByInteraction(menuGroupShapes, DropdownMenuGroup_BfByrIA$lambda$3(mutableState), DropdownMenuGroup_BfByrIA$lambda$1(stateCollectIsHoveredAsState), MotionSchemeKt.value(MotionSchemeKeyTokens.FastSpatial, composerStartRestartGroup, 6), composerStartRestartGroup, i14 & 14), j3, 0L, f6, f5, borderStroke4, ComposableLambdaKt.rememberComposableLambda(-295285640, true, new Function2() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda0
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return MenuKt.DropdownMenuGroup_BfByrIA$lambda$5(modifier2, dropdownMenuGroupContentPadding, function3, (Composer) obj, ((Integer) obj2).intValue());
                                    }
                                }, composerStartRestartGroup, 54), composer2, (i14 & 896) | 12582912 | (57344 & i18) | (458752 & i18) | (i18 & 3670016), 8);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                mutableInteractionSource2 = mutableInteractionSource3;
                                paddingValues2 = dropdownMenuGroupContentPadding;
                                modifier3 = modifier2;
                                j2 = j3;
                                f3 = f6;
                                f4 = f5;
                                borderStroke2 = borderStroke4;
                            } else {
                                composerStartRestartGroup.skipToGroupEnd();
                                if ((i2 & 4) != 0) {
                                    i3 &= -897;
                                }
                                borderStroke3 = borderStroke;
                                dropdownMenuGroupContentPadding = paddingValues;
                            }
                            f5 = fM3753getShadowElevationD9Ej5fM;
                            j3 = groupStandardContainerColor;
                            i14 = i3;
                            f6 = fM3754getTonalElevationD9Ej5fM;
                            mutableInteractionSource3 = mutableInteractionSource;
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1580422941, i14, -1, "androidx.compose.material3.DropdownMenuGroup (Menu.kt:237)");
                            }
                            if (mutableInteractionSource3 == null) {
                                composerStartRestartGroup.startReplaceGroup(948907198);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "239@11779L39");
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1631958076, "CC(remember):Menu.kt#9igjgp");
                                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue2 = InteractionSourceKt.MutableInteractionSource();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                                }
                                mutableInteractionSource4 = (MutableInteractionSource) objRememberedValue2;
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                composerStartRestartGroup.endReplaceGroup();
                            } else {
                                composerStartRestartGroup.startReplaceGroup(-1631958727);
                                composerStartRestartGroup.endReplaceGroup();
                                mutableInteractionSource4 = mutableInteractionSource3;
                            }
                            stateCollectIsHoveredAsState = HoverInteractionKt.collectIsHoveredAsState(mutableInteractionSource4, composerStartRestartGroup, 0);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1631953953, "CC(remember):Menu.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            mutableState = (MutableState) objRememberedValue;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            if (DropdownMenuGroup_BfByrIA$lambda$1(stateCollectIsHoveredAsState)) {
                                DropdownMenuGroup_BfByrIA$lambda$4(mutableState, true);
                            }
                            int i19 = i14 << 3;
                            BorderStroke borderStroke5 = borderStroke3;
                            composer2 = composerStartRestartGroup;
                            SurfaceKt.m4323SurfaceT9BRK9s(HoverableKt.hoverable$default(Modifier.INSTANCE, mutableInteractionSource4, false, 2, null), shapeByInteraction(menuGroupShapes, DropdownMenuGroup_BfByrIA$lambda$3(mutableState), DropdownMenuGroup_BfByrIA$lambda$1(stateCollectIsHoveredAsState), MotionSchemeKt.value(MotionSchemeKeyTokens.FastSpatial, composerStartRestartGroup, 6), composerStartRestartGroup, i14 & 14), j3, 0L, f6, f5, borderStroke5, ComposableLambdaKt.rememberComposableLambda(-295285640, true, new Function2() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return MenuKt.DropdownMenuGroup_BfByrIA$lambda$5(modifier2, dropdownMenuGroupContentPadding, function3, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composerStartRestartGroup, 54), composer2, (i14 & 896) | 12582912 | (57344 & i19) | (458752 & i19) | (i19 & 3670016), 8);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            mutableInteractionSource2 = mutableInteractionSource3;
                            paddingValues2 = dropdownMenuGroupContentPadding;
                            modifier3 = modifier2;
                            j2 = j3;
                            f3 = f6;
                            f4 = f5;
                            borderStroke2 = borderStroke5;
                        } else {
                            composer2 = composerStartRestartGroup;
                            composer2.skipToGroupEnd();
                            mutableInteractionSource2 = mutableInteractionSource;
                            modifier3 = modifier2;
                            j2 = groupStandardContainerColor;
                            f3 = fM3754getTonalElevationD9Ej5fM;
                            f4 = fM3753getShadowElevationD9Ej5fM;
                            borderStroke2 = borderStroke;
                            paddingValues2 = paddingValues;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda11
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return MenuKt.DropdownMenuGroup_BfByrIA$lambda$6(menuGroupShapes, modifier3, j2, f3, f4, borderStroke2, paddingValues2, mutableInteractionSource2, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                        }
                    }
                    i3 |= 12582912;
                    if ((i & 100663296) == 0) {
                        if (composerStartRestartGroup.changedInstance(function3)) {
                            i15 = 67108864;
                        } else {
                            i15 = 33554432;
                        }
                        i3 |= i15;
                    }
                    if ((i3 & 38347923) != 38347922) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "230@11333L27");
                        if ((i & 1) != 0) {
                            if (i16 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if ((i2 & 4) != 0) {
                                groupStandardContainerColor = MenuDefaults.INSTANCE.getGroupStandardContainerColor(composerStartRestartGroup, 6);
                                i3 &= -897;
                            }
                            if (i4 != 0) {
                                fM3754getTonalElevationD9Ej5fM = MenuDefaults.INSTANCE.m3754getTonalElevationD9Ej5fM();
                            }
                            if (i6 != 0) {
                                fM3753getShadowElevationD9Ej5fM = MenuDefaults.INSTANCE.m3753getShadowElevationD9Ej5fM();
                            }
                            if (i8 != 0) {
                                borderStroke3 = null;
                            } else {
                                borderStroke3 = borderStroke;
                            }
                            if (i10 != 0) {
                                dropdownMenuGroupContentPadding = MenuDefaults.INSTANCE.getDropdownMenuGroupContentPadding();
                            } else {
                                dropdownMenuGroupContentPadding = paddingValues;
                            }
                            if (i12 != 0) {
                                f5 = fM3753getShadowElevationD9Ej5fM;
                                j3 = groupStandardContainerColor;
                                i14 = i3;
                                f6 = fM3754getTonalElevationD9Ej5fM;
                                mutableInteractionSource3 = null;
                            } else {
                                f5 = fM3753getShadowElevationD9Ej5fM;
                                j3 = groupStandardContainerColor;
                                i14 = i3;
                                f6 = fM3754getTonalElevationD9Ej5fM;
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                        } else {
                            if (i16 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if ((i2 & 4) != 0) {
                                groupStandardContainerColor = MenuDefaults.INSTANCE.getGroupStandardContainerColor(composerStartRestartGroup, 6);
                                i3 &= -897;
                            }
                            if (i4 != 0) {
                                fM3754getTonalElevationD9Ej5fM = MenuDefaults.INSTANCE.m3754getTonalElevationD9Ej5fM();
                            }
                            if (i6 != 0) {
                                fM3753getShadowElevationD9Ej5fM = MenuDefaults.INSTANCE.m3753getShadowElevationD9Ej5fM();
                            }
                            if (i8 != 0) {
                                borderStroke3 = null;
                            } else {
                                borderStroke3 = borderStroke;
                            }
                            if (i10 != 0) {
                                dropdownMenuGroupContentPadding = MenuDefaults.INSTANCE.getDropdownMenuGroupContentPadding();
                            } else {
                                dropdownMenuGroupContentPadding = paddingValues;
                            }
                            if (i12 != 0) {
                                f5 = fM3753getShadowElevationD9Ej5fM;
                                j3 = groupStandardContainerColor;
                                i14 = i3;
                                f6 = fM3754getTonalElevationD9Ej5fM;
                                mutableInteractionSource3 = null;
                            } else {
                                f5 = fM3753getShadowElevationD9Ej5fM;
                                j3 = groupStandardContainerColor;
                                i14 = i3;
                                f6 = fM3754getTonalElevationD9Ej5fM;
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1580422941, i14, -1, "androidx.compose.material3.DropdownMenuGroup (Menu.kt:237)");
                        }
                        if (mutableInteractionSource3 == null) {
                            composerStartRestartGroup.startReplaceGroup(948907198);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "239@11779L39");
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1631958076, "CC(remember):Menu.kt#9igjgp");
                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue2 = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            }
                            mutableInteractionSource4 = (MutableInteractionSource) objRememberedValue2;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            composerStartRestartGroup.startReplaceGroup(-1631958727);
                            composerStartRestartGroup.endReplaceGroup();
                            mutableInteractionSource4 = mutableInteractionSource3;
                        }
                        stateCollectIsHoveredAsState = HoverInteractionKt.collectIsHoveredAsState(mutableInteractionSource4, composerStartRestartGroup, 0);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1631953953, "CC(remember):Menu.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        mutableState = (MutableState) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if (DropdownMenuGroup_BfByrIA$lambda$1(stateCollectIsHoveredAsState)) {
                            DropdownMenuGroup_BfByrIA$lambda$4(mutableState, true);
                        }
                        int i110 = i14 << 3;
                        BorderStroke borderStroke6 = borderStroke3;
                        composer2 = composerStartRestartGroup;
                        SurfaceKt.m4323SurfaceT9BRK9s(HoverableKt.hoverable$default(Modifier.INSTANCE, mutableInteractionSource4, false, 2, null), shapeByInteraction(menuGroupShapes, DropdownMenuGroup_BfByrIA$lambda$3(mutableState), DropdownMenuGroup_BfByrIA$lambda$1(stateCollectIsHoveredAsState), MotionSchemeKt.value(MotionSchemeKeyTokens.FastSpatial, composerStartRestartGroup, 6), composerStartRestartGroup, i14 & 14), j3, 0L, f6, f5, borderStroke6, ComposableLambdaKt.rememberComposableLambda(-295285640, true, new Function2() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return MenuKt.DropdownMenuGroup_BfByrIA$lambda$5(modifier2, dropdownMenuGroupContentPadding, function3, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54), composer2, (i14 & 896) | 12582912 | (57344 & i110) | (458752 & i110) | (i110 & 3670016), 8);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        mutableInteractionSource2 = mutableInteractionSource3;
                        paddingValues2 = dropdownMenuGroupContentPadding;
                        modifier3 = modifier2;
                        j2 = j3;
                        f3 = f6;
                        f4 = f5;
                        borderStroke2 = borderStroke6;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        mutableInteractionSource2 = mutableInteractionSource;
                        modifier3 = modifier2;
                        j2 = groupStandardContainerColor;
                        f3 = fM3754getTonalElevationD9Ej5fM;
                        f4 = fM3753getShadowElevationD9Ej5fM;
                        borderStroke2 = borderStroke;
                        paddingValues2 = paddingValues;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda11
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return MenuKt.DropdownMenuGroup_BfByrIA$lambda$6(menuGroupShapes, modifier3, j2, f3, f4, borderStroke2, paddingValues2, mutableInteractionSource2, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= 24576;
                fM3753getShadowElevationD9Ej5fM = f2;
                i8 = i2 & 32;
                if (i8 != 0) {
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    if (composerStartRestartGroup.changed(borderStroke)) {
                        i9 = 131072;
                    } else {
                        i9 = 65536;
                    }
                    i3 |= i9;
                }
                i10 = i2 & 64;
                if (i10 != 0) {
                    i3 |= 1572864;
                } else if ((i & 1572864) == 0) {
                    if (composerStartRestartGroup.changed(paddingValues)) {
                        i11 = 1048576;
                    } else {
                        i11 = 524288;
                    }
                    i3 |= i11;
                }
                i12 = i2 & 128;
                if (i12 != 0) {
                    if ((i & 12582912) == 0) {
                        if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                            i13 = 8388608;
                        } else {
                            i13 = 4194304;
                        }
                        i3 |= i13;
                    }
                    if ((i & 100663296) == 0) {
                        if (composerStartRestartGroup.changedInstance(function3)) {
                            i15 = 67108864;
                        } else {
                            i15 = 33554432;
                        }
                        i3 |= i15;
                    }
                    if ((i3 & 38347923) != 38347922) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "230@11333L27");
                        if ((i & 1) != 0) {
                            if (i16 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if ((i2 & 4) != 0) {
                                groupStandardContainerColor = MenuDefaults.INSTANCE.getGroupStandardContainerColor(composerStartRestartGroup, 6);
                                i3 &= -897;
                            }
                            if (i4 != 0) {
                                fM3754getTonalElevationD9Ej5fM = MenuDefaults.INSTANCE.m3754getTonalElevationD9Ej5fM();
                            }
                            if (i6 != 0) {
                                fM3753getShadowElevationD9Ej5fM = MenuDefaults.INSTANCE.m3753getShadowElevationD9Ej5fM();
                            }
                            if (i8 != 0) {
                                borderStroke3 = null;
                            } else {
                                borderStroke3 = borderStroke;
                            }
                            if (i10 != 0) {
                                dropdownMenuGroupContentPadding = MenuDefaults.INSTANCE.getDropdownMenuGroupContentPadding();
                            } else {
                                dropdownMenuGroupContentPadding = paddingValues;
                            }
                            if (i12 != 0) {
                                f5 = fM3753getShadowElevationD9Ej5fM;
                                j3 = groupStandardContainerColor;
                                i14 = i3;
                                f6 = fM3754getTonalElevationD9Ej5fM;
                                mutableInteractionSource3 = null;
                            } else {
                                f5 = fM3753getShadowElevationD9Ej5fM;
                                j3 = groupStandardContainerColor;
                                i14 = i3;
                                f6 = fM3754getTonalElevationD9Ej5fM;
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                        } else {
                            if (i16 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if ((i2 & 4) != 0) {
                                groupStandardContainerColor = MenuDefaults.INSTANCE.getGroupStandardContainerColor(composerStartRestartGroup, 6);
                                i3 &= -897;
                            }
                            if (i4 != 0) {
                                fM3754getTonalElevationD9Ej5fM = MenuDefaults.INSTANCE.m3754getTonalElevationD9Ej5fM();
                            }
                            if (i6 != 0) {
                                fM3753getShadowElevationD9Ej5fM = MenuDefaults.INSTANCE.m3753getShadowElevationD9Ej5fM();
                            }
                            if (i8 != 0) {
                                borderStroke3 = null;
                            } else {
                                borderStroke3 = borderStroke;
                            }
                            if (i10 != 0) {
                                dropdownMenuGroupContentPadding = MenuDefaults.INSTANCE.getDropdownMenuGroupContentPadding();
                            } else {
                                dropdownMenuGroupContentPadding = paddingValues;
                            }
                            if (i12 != 0) {
                                f5 = fM3753getShadowElevationD9Ej5fM;
                                j3 = groupStandardContainerColor;
                                i14 = i3;
                                f6 = fM3754getTonalElevationD9Ej5fM;
                                mutableInteractionSource3 = null;
                            } else {
                                f5 = fM3753getShadowElevationD9Ej5fM;
                                j3 = groupStandardContainerColor;
                                i14 = i3;
                                f6 = fM3754getTonalElevationD9Ej5fM;
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1580422941, i14, -1, "androidx.compose.material3.DropdownMenuGroup (Menu.kt:237)");
                        }
                        if (mutableInteractionSource3 == null) {
                            composerStartRestartGroup.startReplaceGroup(948907198);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "239@11779L39");
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1631958076, "CC(remember):Menu.kt#9igjgp");
                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue2 = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            }
                            mutableInteractionSource4 = (MutableInteractionSource) objRememberedValue2;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            composerStartRestartGroup.startReplaceGroup(-1631958727);
                            composerStartRestartGroup.endReplaceGroup();
                            mutableInteractionSource4 = mutableInteractionSource3;
                        }
                        stateCollectIsHoveredAsState = HoverInteractionKt.collectIsHoveredAsState(mutableInteractionSource4, composerStartRestartGroup, 0);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1631953953, "CC(remember):Menu.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        mutableState = (MutableState) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if (DropdownMenuGroup_BfByrIA$lambda$1(stateCollectIsHoveredAsState)) {
                            DropdownMenuGroup_BfByrIA$lambda$4(mutableState, true);
                        }
                        int i111 = i14 << 3;
                        BorderStroke borderStroke7 = borderStroke3;
                        composer2 = composerStartRestartGroup;
                        SurfaceKt.m4323SurfaceT9BRK9s(HoverableKt.hoverable$default(Modifier.INSTANCE, mutableInteractionSource4, false, 2, null), shapeByInteraction(menuGroupShapes, DropdownMenuGroup_BfByrIA$lambda$3(mutableState), DropdownMenuGroup_BfByrIA$lambda$1(stateCollectIsHoveredAsState), MotionSchemeKt.value(MotionSchemeKeyTokens.FastSpatial, composerStartRestartGroup, 6), composerStartRestartGroup, i14 & 14), j3, 0L, f6, f5, borderStroke7, ComposableLambdaKt.rememberComposableLambda(-295285640, true, new Function2() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return MenuKt.DropdownMenuGroup_BfByrIA$lambda$5(modifier2, dropdownMenuGroupContentPadding, function3, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54), composer2, (i14 & 896) | 12582912 | (57344 & i111) | (458752 & i111) | (i111 & 3670016), 8);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        mutableInteractionSource2 = mutableInteractionSource3;
                        paddingValues2 = dropdownMenuGroupContentPadding;
                        modifier3 = modifier2;
                        j2 = j3;
                        f3 = f6;
                        f4 = f5;
                        borderStroke2 = borderStroke7;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        mutableInteractionSource2 = mutableInteractionSource;
                        modifier3 = modifier2;
                        j2 = groupStandardContainerColor;
                        f3 = fM3754getTonalElevationD9Ej5fM;
                        f4 = fM3753getShadowElevationD9Ej5fM;
                        borderStroke2 = borderStroke;
                        paddingValues2 = paddingValues;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda11
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return MenuKt.DropdownMenuGroup_BfByrIA$lambda$6(menuGroupShapes, modifier3, j2, f3, f4, borderStroke2, paddingValues2, mutableInteractionSource2, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= 12582912;
                if ((i & 100663296) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i15 = 67108864;
                    } else {
                        i15 = 33554432;
                    }
                    i3 |= i15;
                }
                if ((i3 & 38347923) != 38347922) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "230@11333L27");
                    if ((i & 1) != 0) {
                        if (i16 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if ((i2 & 4) != 0) {
                            groupStandardContainerColor = MenuDefaults.INSTANCE.getGroupStandardContainerColor(composerStartRestartGroup, 6);
                            i3 &= -897;
                        }
                        if (i4 != 0) {
                            fM3754getTonalElevationD9Ej5fM = MenuDefaults.INSTANCE.m3754getTonalElevationD9Ej5fM();
                        }
                        if (i6 != 0) {
                            fM3753getShadowElevationD9Ej5fM = MenuDefaults.INSTANCE.m3753getShadowElevationD9Ej5fM();
                        }
                        if (i8 != 0) {
                            borderStroke3 = null;
                        } else {
                            borderStroke3 = borderStroke;
                        }
                        if (i10 != 0) {
                            dropdownMenuGroupContentPadding = MenuDefaults.INSTANCE.getDropdownMenuGroupContentPadding();
                        } else {
                            dropdownMenuGroupContentPadding = paddingValues;
                        }
                        if (i12 != 0) {
                            f5 = fM3753getShadowElevationD9Ej5fM;
                            j3 = groupStandardContainerColor;
                            i14 = i3;
                            f6 = fM3754getTonalElevationD9Ej5fM;
                            mutableInteractionSource3 = null;
                        } else {
                            f5 = fM3753getShadowElevationD9Ej5fM;
                            j3 = groupStandardContainerColor;
                            i14 = i3;
                            f6 = fM3754getTonalElevationD9Ej5fM;
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                    } else {
                        if (i16 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if ((i2 & 4) != 0) {
                            groupStandardContainerColor = MenuDefaults.INSTANCE.getGroupStandardContainerColor(composerStartRestartGroup, 6);
                            i3 &= -897;
                        }
                        if (i4 != 0) {
                            fM3754getTonalElevationD9Ej5fM = MenuDefaults.INSTANCE.m3754getTonalElevationD9Ej5fM();
                        }
                        if (i6 != 0) {
                            fM3753getShadowElevationD9Ej5fM = MenuDefaults.INSTANCE.m3753getShadowElevationD9Ej5fM();
                        }
                        if (i8 != 0) {
                            borderStroke3 = null;
                        } else {
                            borderStroke3 = borderStroke;
                        }
                        if (i10 != 0) {
                            dropdownMenuGroupContentPadding = MenuDefaults.INSTANCE.getDropdownMenuGroupContentPadding();
                        } else {
                            dropdownMenuGroupContentPadding = paddingValues;
                        }
                        if (i12 != 0) {
                            f5 = fM3753getShadowElevationD9Ej5fM;
                            j3 = groupStandardContainerColor;
                            i14 = i3;
                            f6 = fM3754getTonalElevationD9Ej5fM;
                            mutableInteractionSource3 = null;
                        } else {
                            f5 = fM3753getShadowElevationD9Ej5fM;
                            j3 = groupStandardContainerColor;
                            i14 = i3;
                            f6 = fM3754getTonalElevationD9Ej5fM;
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1580422941, i14, -1, "androidx.compose.material3.DropdownMenuGroup (Menu.kt:237)");
                    }
                    if (mutableInteractionSource3 == null) {
                        composerStartRestartGroup.startReplaceGroup(948907198);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "239@11779L39");
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1631958076, "CC(remember):Menu.kt#9igjgp");
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue2 = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        mutableInteractionSource4 = (MutableInteractionSource) objRememberedValue2;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-1631958727);
                        composerStartRestartGroup.endReplaceGroup();
                        mutableInteractionSource4 = mutableInteractionSource3;
                    }
                    stateCollectIsHoveredAsState = HoverInteractionKt.collectIsHoveredAsState(mutableInteractionSource4, composerStartRestartGroup, 0);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1631953953, "CC(remember):Menu.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    mutableState = (MutableState) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (DropdownMenuGroup_BfByrIA$lambda$1(stateCollectIsHoveredAsState)) {
                        DropdownMenuGroup_BfByrIA$lambda$4(mutableState, true);
                    }
                    int i112 = i14 << 3;
                    BorderStroke borderStroke8 = borderStroke3;
                    composer2 = composerStartRestartGroup;
                    SurfaceKt.m4323SurfaceT9BRK9s(HoverableKt.hoverable$default(Modifier.INSTANCE, mutableInteractionSource4, false, 2, null), shapeByInteraction(menuGroupShapes, DropdownMenuGroup_BfByrIA$lambda$3(mutableState), DropdownMenuGroup_BfByrIA$lambda$1(stateCollectIsHoveredAsState), MotionSchemeKt.value(MotionSchemeKeyTokens.FastSpatial, composerStartRestartGroup, 6), composerStartRestartGroup, i14 & 14), j3, 0L, f6, f5, borderStroke8, ComposableLambdaKt.rememberComposableLambda(-295285640, true, new Function2() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return MenuKt.DropdownMenuGroup_BfByrIA$lambda$5(modifier2, dropdownMenuGroupContentPadding, function3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composer2, (i14 & 896) | 12582912 | (57344 & i112) | (458752 & i112) | (i112 & 3670016), 8);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    mutableInteractionSource2 = mutableInteractionSource3;
                    paddingValues2 = dropdownMenuGroupContentPadding;
                    modifier3 = modifier2;
                    j2 = j3;
                    f3 = f6;
                    f4 = f5;
                    borderStroke2 = borderStroke8;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    mutableInteractionSource2 = mutableInteractionSource;
                    modifier3 = modifier2;
                    j2 = groupStandardContainerColor;
                    f3 = fM3754getTonalElevationD9Ej5fM;
                    f4 = fM3753getShadowElevationD9Ej5fM;
                    borderStroke2 = borderStroke;
                    paddingValues2 = paddingValues;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda11
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return MenuKt.DropdownMenuGroup_BfByrIA$lambda$6(menuGroupShapes, modifier3, j2, f3, f4, borderStroke2, paddingValues2, mutableInteractionSource2, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 3072;
            fM3754getTonalElevationD9Ej5fM = f;
            i6 = i2 & 16;
            if (i6 != 0) {
                if ((i & 24576) == 0) {
                    fM3753getShadowElevationD9Ej5fM = f2;
                    if (composerStartRestartGroup.changed(fM3753getShadowElevationD9Ej5fM)) {
                        i7 = 16384;
                    } else {
                        i7 = 8192;
                    }
                    i3 |= i7;
                }
                i8 = i2 & 32;
                if (i8 != 0) {
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    if (composerStartRestartGroup.changed(borderStroke)) {
                        i9 = 131072;
                    } else {
                        i9 = 65536;
                    }
                    i3 |= i9;
                }
                i10 = i2 & 64;
                if (i10 != 0) {
                    i3 |= 1572864;
                } else if ((i & 1572864) == 0) {
                    if (composerStartRestartGroup.changed(paddingValues)) {
                        i11 = 1048576;
                    } else {
                        i11 = 524288;
                    }
                    i3 |= i11;
                }
                i12 = i2 & 128;
                if (i12 != 0) {
                    if ((i & 12582912) == 0) {
                        if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                            i13 = 8388608;
                        } else {
                            i13 = 4194304;
                        }
                        i3 |= i13;
                    }
                    if ((i & 100663296) == 0) {
                        if (composerStartRestartGroup.changedInstance(function3)) {
                            i15 = 67108864;
                        } else {
                            i15 = 33554432;
                        }
                        i3 |= i15;
                    }
                    if ((i3 & 38347923) != 38347922) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "230@11333L27");
                        if ((i & 1) != 0) {
                            if (i16 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if ((i2 & 4) != 0) {
                                groupStandardContainerColor = MenuDefaults.INSTANCE.getGroupStandardContainerColor(composerStartRestartGroup, 6);
                                i3 &= -897;
                            }
                            if (i4 != 0) {
                                fM3754getTonalElevationD9Ej5fM = MenuDefaults.INSTANCE.m3754getTonalElevationD9Ej5fM();
                            }
                            if (i6 != 0) {
                                fM3753getShadowElevationD9Ej5fM = MenuDefaults.INSTANCE.m3753getShadowElevationD9Ej5fM();
                            }
                            if (i8 != 0) {
                                borderStroke3 = null;
                            } else {
                                borderStroke3 = borderStroke;
                            }
                            if (i10 != 0) {
                                dropdownMenuGroupContentPadding = MenuDefaults.INSTANCE.getDropdownMenuGroupContentPadding();
                            } else {
                                dropdownMenuGroupContentPadding = paddingValues;
                            }
                            if (i12 != 0) {
                                f5 = fM3753getShadowElevationD9Ej5fM;
                                j3 = groupStandardContainerColor;
                                i14 = i3;
                                f6 = fM3754getTonalElevationD9Ej5fM;
                                mutableInteractionSource3 = null;
                            } else {
                                f5 = fM3753getShadowElevationD9Ej5fM;
                                j3 = groupStandardContainerColor;
                                i14 = i3;
                                f6 = fM3754getTonalElevationD9Ej5fM;
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                        } else {
                            if (i16 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if ((i2 & 4) != 0) {
                                groupStandardContainerColor = MenuDefaults.INSTANCE.getGroupStandardContainerColor(composerStartRestartGroup, 6);
                                i3 &= -897;
                            }
                            if (i4 != 0) {
                                fM3754getTonalElevationD9Ej5fM = MenuDefaults.INSTANCE.m3754getTonalElevationD9Ej5fM();
                            }
                            if (i6 != 0) {
                                fM3753getShadowElevationD9Ej5fM = MenuDefaults.INSTANCE.m3753getShadowElevationD9Ej5fM();
                            }
                            if (i8 != 0) {
                                borderStroke3 = null;
                            } else {
                                borderStroke3 = borderStroke;
                            }
                            if (i10 != 0) {
                                dropdownMenuGroupContentPadding = MenuDefaults.INSTANCE.getDropdownMenuGroupContentPadding();
                            } else {
                                dropdownMenuGroupContentPadding = paddingValues;
                            }
                            if (i12 != 0) {
                                f5 = fM3753getShadowElevationD9Ej5fM;
                                j3 = groupStandardContainerColor;
                                i14 = i3;
                                f6 = fM3754getTonalElevationD9Ej5fM;
                                mutableInteractionSource3 = null;
                            } else {
                                f5 = fM3753getShadowElevationD9Ej5fM;
                                j3 = groupStandardContainerColor;
                                i14 = i3;
                                f6 = fM3754getTonalElevationD9Ej5fM;
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1580422941, i14, -1, "androidx.compose.material3.DropdownMenuGroup (Menu.kt:237)");
                        }
                        if (mutableInteractionSource3 == null) {
                            composerStartRestartGroup.startReplaceGroup(948907198);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "239@11779L39");
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1631958076, "CC(remember):Menu.kt#9igjgp");
                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue2 = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            }
                            mutableInteractionSource4 = (MutableInteractionSource) objRememberedValue2;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            composerStartRestartGroup.startReplaceGroup(-1631958727);
                            composerStartRestartGroup.endReplaceGroup();
                            mutableInteractionSource4 = mutableInteractionSource3;
                        }
                        stateCollectIsHoveredAsState = HoverInteractionKt.collectIsHoveredAsState(mutableInteractionSource4, composerStartRestartGroup, 0);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1631953953, "CC(remember):Menu.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        mutableState = (MutableState) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if (DropdownMenuGroup_BfByrIA$lambda$1(stateCollectIsHoveredAsState)) {
                            DropdownMenuGroup_BfByrIA$lambda$4(mutableState, true);
                        }
                        int i113 = i14 << 3;
                        BorderStroke borderStroke9 = borderStroke3;
                        composer2 = composerStartRestartGroup;
                        SurfaceKt.m4323SurfaceT9BRK9s(HoverableKt.hoverable$default(Modifier.INSTANCE, mutableInteractionSource4, false, 2, null), shapeByInteraction(menuGroupShapes, DropdownMenuGroup_BfByrIA$lambda$3(mutableState), DropdownMenuGroup_BfByrIA$lambda$1(stateCollectIsHoveredAsState), MotionSchemeKt.value(MotionSchemeKeyTokens.FastSpatial, composerStartRestartGroup, 6), composerStartRestartGroup, i14 & 14), j3, 0L, f6, f5, borderStroke9, ComposableLambdaKt.rememberComposableLambda(-295285640, true, new Function2() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return MenuKt.DropdownMenuGroup_BfByrIA$lambda$5(modifier2, dropdownMenuGroupContentPadding, function3, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54), composer2, (i14 & 896) | 12582912 | (57344 & i113) | (458752 & i113) | (i113 & 3670016), 8);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        mutableInteractionSource2 = mutableInteractionSource3;
                        paddingValues2 = dropdownMenuGroupContentPadding;
                        modifier3 = modifier2;
                        j2 = j3;
                        f3 = f6;
                        f4 = f5;
                        borderStroke2 = borderStroke9;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        mutableInteractionSource2 = mutableInteractionSource;
                        modifier3 = modifier2;
                        j2 = groupStandardContainerColor;
                        f3 = fM3754getTonalElevationD9Ej5fM;
                        f4 = fM3753getShadowElevationD9Ej5fM;
                        borderStroke2 = borderStroke;
                        paddingValues2 = paddingValues;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda11
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return MenuKt.DropdownMenuGroup_BfByrIA$lambda$6(menuGroupShapes, modifier3, j2, f3, f4, borderStroke2, paddingValues2, mutableInteractionSource2, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= 12582912;
                if ((i & 100663296) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i15 = 67108864;
                    } else {
                        i15 = 33554432;
                    }
                    i3 |= i15;
                }
                if ((i3 & 38347923) != 38347922) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "230@11333L27");
                    if ((i & 1) != 0) {
                        if (i16 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if ((i2 & 4) != 0) {
                            groupStandardContainerColor = MenuDefaults.INSTANCE.getGroupStandardContainerColor(composerStartRestartGroup, 6);
                            i3 &= -897;
                        }
                        if (i4 != 0) {
                            fM3754getTonalElevationD9Ej5fM = MenuDefaults.INSTANCE.m3754getTonalElevationD9Ej5fM();
                        }
                        if (i6 != 0) {
                            fM3753getShadowElevationD9Ej5fM = MenuDefaults.INSTANCE.m3753getShadowElevationD9Ej5fM();
                        }
                        if (i8 != 0) {
                            borderStroke3 = null;
                        } else {
                            borderStroke3 = borderStroke;
                        }
                        if (i10 != 0) {
                            dropdownMenuGroupContentPadding = MenuDefaults.INSTANCE.getDropdownMenuGroupContentPadding();
                        } else {
                            dropdownMenuGroupContentPadding = paddingValues;
                        }
                        if (i12 != 0) {
                            f5 = fM3753getShadowElevationD9Ej5fM;
                            j3 = groupStandardContainerColor;
                            i14 = i3;
                            f6 = fM3754getTonalElevationD9Ej5fM;
                            mutableInteractionSource3 = null;
                        } else {
                            f5 = fM3753getShadowElevationD9Ej5fM;
                            j3 = groupStandardContainerColor;
                            i14 = i3;
                            f6 = fM3754getTonalElevationD9Ej5fM;
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                    } else {
                        if (i16 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if ((i2 & 4) != 0) {
                            groupStandardContainerColor = MenuDefaults.INSTANCE.getGroupStandardContainerColor(composerStartRestartGroup, 6);
                            i3 &= -897;
                        }
                        if (i4 != 0) {
                            fM3754getTonalElevationD9Ej5fM = MenuDefaults.INSTANCE.m3754getTonalElevationD9Ej5fM();
                        }
                        if (i6 != 0) {
                            fM3753getShadowElevationD9Ej5fM = MenuDefaults.INSTANCE.m3753getShadowElevationD9Ej5fM();
                        }
                        if (i8 != 0) {
                            borderStroke3 = null;
                        } else {
                            borderStroke3 = borderStroke;
                        }
                        if (i10 != 0) {
                            dropdownMenuGroupContentPadding = MenuDefaults.INSTANCE.getDropdownMenuGroupContentPadding();
                        } else {
                            dropdownMenuGroupContentPadding = paddingValues;
                        }
                        if (i12 != 0) {
                            f5 = fM3753getShadowElevationD9Ej5fM;
                            j3 = groupStandardContainerColor;
                            i14 = i3;
                            f6 = fM3754getTonalElevationD9Ej5fM;
                            mutableInteractionSource3 = null;
                        } else {
                            f5 = fM3753getShadowElevationD9Ej5fM;
                            j3 = groupStandardContainerColor;
                            i14 = i3;
                            f6 = fM3754getTonalElevationD9Ej5fM;
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1580422941, i14, -1, "androidx.compose.material3.DropdownMenuGroup (Menu.kt:237)");
                    }
                    if (mutableInteractionSource3 == null) {
                        composerStartRestartGroup.startReplaceGroup(948907198);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "239@11779L39");
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1631958076, "CC(remember):Menu.kt#9igjgp");
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue2 = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        mutableInteractionSource4 = (MutableInteractionSource) objRememberedValue2;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-1631958727);
                        composerStartRestartGroup.endReplaceGroup();
                        mutableInteractionSource4 = mutableInteractionSource3;
                    }
                    stateCollectIsHoveredAsState = HoverInteractionKt.collectIsHoveredAsState(mutableInteractionSource4, composerStartRestartGroup, 0);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1631953953, "CC(remember):Menu.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    mutableState = (MutableState) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (DropdownMenuGroup_BfByrIA$lambda$1(stateCollectIsHoveredAsState)) {
                        DropdownMenuGroup_BfByrIA$lambda$4(mutableState, true);
                    }
                    int i114 = i14 << 3;
                    BorderStroke borderStroke10 = borderStroke3;
                    composer2 = composerStartRestartGroup;
                    SurfaceKt.m4323SurfaceT9BRK9s(HoverableKt.hoverable$default(Modifier.INSTANCE, mutableInteractionSource4, false, 2, null), shapeByInteraction(menuGroupShapes, DropdownMenuGroup_BfByrIA$lambda$3(mutableState), DropdownMenuGroup_BfByrIA$lambda$1(stateCollectIsHoveredAsState), MotionSchemeKt.value(MotionSchemeKeyTokens.FastSpatial, composerStartRestartGroup, 6), composerStartRestartGroup, i14 & 14), j3, 0L, f6, f5, borderStroke10, ComposableLambdaKt.rememberComposableLambda(-295285640, true, new Function2() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return MenuKt.DropdownMenuGroup_BfByrIA$lambda$5(modifier2, dropdownMenuGroupContentPadding, function3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composer2, (i14 & 896) | 12582912 | (57344 & i114) | (458752 & i114) | (i114 & 3670016), 8);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    mutableInteractionSource2 = mutableInteractionSource3;
                    paddingValues2 = dropdownMenuGroupContentPadding;
                    modifier3 = modifier2;
                    j2 = j3;
                    f3 = f6;
                    f4 = f5;
                    borderStroke2 = borderStroke10;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    mutableInteractionSource2 = mutableInteractionSource;
                    modifier3 = modifier2;
                    j2 = groupStandardContainerColor;
                    f3 = fM3754getTonalElevationD9Ej5fM;
                    f4 = fM3753getShadowElevationD9Ej5fM;
                    borderStroke2 = borderStroke;
                    paddingValues2 = paddingValues;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda11
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return MenuKt.DropdownMenuGroup_BfByrIA$lambda$6(menuGroupShapes, modifier3, j2, f3, f4, borderStroke2, paddingValues2, mutableInteractionSource2, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 24576;
            fM3753getShadowElevationD9Ej5fM = f2;
            i8 = i2 & 32;
            if (i8 != 0) {
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            } else if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                if (composerStartRestartGroup.changed(borderStroke)) {
                    i9 = 131072;
                } else {
                    i9 = 65536;
                }
                i3 |= i9;
            }
            i10 = i2 & 64;
            if (i10 != 0) {
                i3 |= 1572864;
            } else if ((i & 1572864) == 0) {
                if (composerStartRestartGroup.changed(paddingValues)) {
                    i11 = 1048576;
                } else {
                    i11 = 524288;
                }
                i3 |= i11;
            }
            i12 = i2 & 128;
            if (i12 != 0) {
                if ((i & 12582912) == 0) {
                    if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                        i13 = 8388608;
                    } else {
                        i13 = 4194304;
                    }
                    i3 |= i13;
                }
                if ((i & 100663296) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i15 = 67108864;
                    } else {
                        i15 = 33554432;
                    }
                    i3 |= i15;
                }
                if ((i3 & 38347923) != 38347922) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "230@11333L27");
                    if ((i & 1) != 0) {
                        if (i16 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if ((i2 & 4) != 0) {
                            groupStandardContainerColor = MenuDefaults.INSTANCE.getGroupStandardContainerColor(composerStartRestartGroup, 6);
                            i3 &= -897;
                        }
                        if (i4 != 0) {
                            fM3754getTonalElevationD9Ej5fM = MenuDefaults.INSTANCE.m3754getTonalElevationD9Ej5fM();
                        }
                        if (i6 != 0) {
                            fM3753getShadowElevationD9Ej5fM = MenuDefaults.INSTANCE.m3753getShadowElevationD9Ej5fM();
                        }
                        if (i8 != 0) {
                            borderStroke3 = null;
                        } else {
                            borderStroke3 = borderStroke;
                        }
                        if (i10 != 0) {
                            dropdownMenuGroupContentPadding = MenuDefaults.INSTANCE.getDropdownMenuGroupContentPadding();
                        } else {
                            dropdownMenuGroupContentPadding = paddingValues;
                        }
                        if (i12 != 0) {
                            f5 = fM3753getShadowElevationD9Ej5fM;
                            j3 = groupStandardContainerColor;
                            i14 = i3;
                            f6 = fM3754getTonalElevationD9Ej5fM;
                            mutableInteractionSource3 = null;
                        } else {
                            f5 = fM3753getShadowElevationD9Ej5fM;
                            j3 = groupStandardContainerColor;
                            i14 = i3;
                            f6 = fM3754getTonalElevationD9Ej5fM;
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                    } else {
                        if (i16 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if ((i2 & 4) != 0) {
                            groupStandardContainerColor = MenuDefaults.INSTANCE.getGroupStandardContainerColor(composerStartRestartGroup, 6);
                            i3 &= -897;
                        }
                        if (i4 != 0) {
                            fM3754getTonalElevationD9Ej5fM = MenuDefaults.INSTANCE.m3754getTonalElevationD9Ej5fM();
                        }
                        if (i6 != 0) {
                            fM3753getShadowElevationD9Ej5fM = MenuDefaults.INSTANCE.m3753getShadowElevationD9Ej5fM();
                        }
                        if (i8 != 0) {
                            borderStroke3 = null;
                        } else {
                            borderStroke3 = borderStroke;
                        }
                        if (i10 != 0) {
                            dropdownMenuGroupContentPadding = MenuDefaults.INSTANCE.getDropdownMenuGroupContentPadding();
                        } else {
                            dropdownMenuGroupContentPadding = paddingValues;
                        }
                        if (i12 != 0) {
                            f5 = fM3753getShadowElevationD9Ej5fM;
                            j3 = groupStandardContainerColor;
                            i14 = i3;
                            f6 = fM3754getTonalElevationD9Ej5fM;
                            mutableInteractionSource3 = null;
                        } else {
                            f5 = fM3753getShadowElevationD9Ej5fM;
                            j3 = groupStandardContainerColor;
                            i14 = i3;
                            f6 = fM3754getTonalElevationD9Ej5fM;
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1580422941, i14, -1, "androidx.compose.material3.DropdownMenuGroup (Menu.kt:237)");
                    }
                    if (mutableInteractionSource3 == null) {
                        composerStartRestartGroup.startReplaceGroup(948907198);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "239@11779L39");
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1631958076, "CC(remember):Menu.kt#9igjgp");
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue2 = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        mutableInteractionSource4 = (MutableInteractionSource) objRememberedValue2;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-1631958727);
                        composerStartRestartGroup.endReplaceGroup();
                        mutableInteractionSource4 = mutableInteractionSource3;
                    }
                    stateCollectIsHoveredAsState = HoverInteractionKt.collectIsHoveredAsState(mutableInteractionSource4, composerStartRestartGroup, 0);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1631953953, "CC(remember):Menu.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    mutableState = (MutableState) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (DropdownMenuGroup_BfByrIA$lambda$1(stateCollectIsHoveredAsState)) {
                        DropdownMenuGroup_BfByrIA$lambda$4(mutableState, true);
                    }
                    int i115 = i14 << 3;
                    BorderStroke borderStroke11 = borderStroke3;
                    composer2 = composerStartRestartGroup;
                    SurfaceKt.m4323SurfaceT9BRK9s(HoverableKt.hoverable$default(Modifier.INSTANCE, mutableInteractionSource4, false, 2, null), shapeByInteraction(menuGroupShapes, DropdownMenuGroup_BfByrIA$lambda$3(mutableState), DropdownMenuGroup_BfByrIA$lambda$1(stateCollectIsHoveredAsState), MotionSchemeKt.value(MotionSchemeKeyTokens.FastSpatial, composerStartRestartGroup, 6), composerStartRestartGroup, i14 & 14), j3, 0L, f6, f5, borderStroke11, ComposableLambdaKt.rememberComposableLambda(-295285640, true, new Function2() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return MenuKt.DropdownMenuGroup_BfByrIA$lambda$5(modifier2, dropdownMenuGroupContentPadding, function3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composer2, (i14 & 896) | 12582912 | (57344 & i115) | (458752 & i115) | (i115 & 3670016), 8);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    mutableInteractionSource2 = mutableInteractionSource3;
                    paddingValues2 = dropdownMenuGroupContentPadding;
                    modifier3 = modifier2;
                    j2 = j3;
                    f3 = f6;
                    f4 = f5;
                    borderStroke2 = borderStroke11;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    mutableInteractionSource2 = mutableInteractionSource;
                    modifier3 = modifier2;
                    j2 = groupStandardContainerColor;
                    f3 = fM3754getTonalElevationD9Ej5fM;
                    f4 = fM3753getShadowElevationD9Ej5fM;
                    borderStroke2 = borderStroke;
                    paddingValues2 = paddingValues;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda11
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return MenuKt.DropdownMenuGroup_BfByrIA$lambda$6(menuGroupShapes, modifier3, j2, f3, f4, borderStroke2, paddingValues2, mutableInteractionSource2, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 12582912;
            if ((i & 100663296) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i15 = 67108864;
                } else {
                    i15 = 33554432;
                }
                i3 |= i15;
            }
            if ((i3 & 38347923) != 38347922) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "230@11333L27");
                if ((i & 1) != 0) {
                    if (i16 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if ((i2 & 4) != 0) {
                        groupStandardContainerColor = MenuDefaults.INSTANCE.getGroupStandardContainerColor(composerStartRestartGroup, 6);
                        i3 &= -897;
                    }
                    if (i4 != 0) {
                        fM3754getTonalElevationD9Ej5fM = MenuDefaults.INSTANCE.m3754getTonalElevationD9Ej5fM();
                    }
                    if (i6 != 0) {
                        fM3753getShadowElevationD9Ej5fM = MenuDefaults.INSTANCE.m3753getShadowElevationD9Ej5fM();
                    }
                    if (i8 != 0) {
                        borderStroke3 = null;
                    } else {
                        borderStroke3 = borderStroke;
                    }
                    if (i10 != 0) {
                        dropdownMenuGroupContentPadding = MenuDefaults.INSTANCE.getDropdownMenuGroupContentPadding();
                    } else {
                        dropdownMenuGroupContentPadding = paddingValues;
                    }
                    if (i12 != 0) {
                        f5 = fM3753getShadowElevationD9Ej5fM;
                        j3 = groupStandardContainerColor;
                        i14 = i3;
                        f6 = fM3754getTonalElevationD9Ej5fM;
                        mutableInteractionSource3 = null;
                    } else {
                        f5 = fM3753getShadowElevationD9Ej5fM;
                        j3 = groupStandardContainerColor;
                        i14 = i3;
                        f6 = fM3754getTonalElevationD9Ej5fM;
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                } else {
                    if (i16 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if ((i2 & 4) != 0) {
                        groupStandardContainerColor = MenuDefaults.INSTANCE.getGroupStandardContainerColor(composerStartRestartGroup, 6);
                        i3 &= -897;
                    }
                    if (i4 != 0) {
                        fM3754getTonalElevationD9Ej5fM = MenuDefaults.INSTANCE.m3754getTonalElevationD9Ej5fM();
                    }
                    if (i6 != 0) {
                        fM3753getShadowElevationD9Ej5fM = MenuDefaults.INSTANCE.m3753getShadowElevationD9Ej5fM();
                    }
                    if (i8 != 0) {
                        borderStroke3 = null;
                    } else {
                        borderStroke3 = borderStroke;
                    }
                    if (i10 != 0) {
                        dropdownMenuGroupContentPadding = MenuDefaults.INSTANCE.getDropdownMenuGroupContentPadding();
                    } else {
                        dropdownMenuGroupContentPadding = paddingValues;
                    }
                    if (i12 != 0) {
                        f5 = fM3753getShadowElevationD9Ej5fM;
                        j3 = groupStandardContainerColor;
                        i14 = i3;
                        f6 = fM3754getTonalElevationD9Ej5fM;
                        mutableInteractionSource3 = null;
                    } else {
                        f5 = fM3753getShadowElevationD9Ej5fM;
                        j3 = groupStandardContainerColor;
                        i14 = i3;
                        f6 = fM3754getTonalElevationD9Ej5fM;
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1580422941, i14, -1, "androidx.compose.material3.DropdownMenuGroup (Menu.kt:237)");
                }
                if (mutableInteractionSource3 == null) {
                    composerStartRestartGroup.startReplaceGroup(948907198);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "239@11779L39");
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1631958076, "CC(remember):Menu.kt#9igjgp");
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    mutableInteractionSource4 = (MutableInteractionSource) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(-1631958727);
                    composerStartRestartGroup.endReplaceGroup();
                    mutableInteractionSource4 = mutableInteractionSource3;
                }
                stateCollectIsHoveredAsState = HoverInteractionKt.collectIsHoveredAsState(mutableInteractionSource4, composerStartRestartGroup, 0);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1631953953, "CC(remember):Menu.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                mutableState = (MutableState) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (DropdownMenuGroup_BfByrIA$lambda$1(stateCollectIsHoveredAsState)) {
                    DropdownMenuGroup_BfByrIA$lambda$4(mutableState, true);
                }
                int i116 = i14 << 3;
                BorderStroke borderStroke12 = borderStroke3;
                composer2 = composerStartRestartGroup;
                SurfaceKt.m4323SurfaceT9BRK9s(HoverableKt.hoverable$default(Modifier.INSTANCE, mutableInteractionSource4, false, 2, null), shapeByInteraction(menuGroupShapes, DropdownMenuGroup_BfByrIA$lambda$3(mutableState), DropdownMenuGroup_BfByrIA$lambda$1(stateCollectIsHoveredAsState), MotionSchemeKt.value(MotionSchemeKeyTokens.FastSpatial, composerStartRestartGroup, 6), composerStartRestartGroup, i14 & 14), j3, 0L, f6, f5, borderStroke12, ComposableLambdaKt.rememberComposableLambda(-295285640, true, new Function2() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return MenuKt.DropdownMenuGroup_BfByrIA$lambda$5(modifier2, dropdownMenuGroupContentPadding, function3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composer2, (i14 & 896) | 12582912 | (57344 & i116) | (458752 & i116) | (i116 & 3670016), 8);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                mutableInteractionSource2 = mutableInteractionSource3;
                paddingValues2 = dropdownMenuGroupContentPadding;
                modifier3 = modifier2;
                j2 = j3;
                f3 = f6;
                f4 = f5;
                borderStroke2 = borderStroke12;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                mutableInteractionSource2 = mutableInteractionSource;
                modifier3 = modifier2;
                j2 = groupStandardContainerColor;
                f3 = fM3754getTonalElevationD9Ej5fM;
                f4 = fM3753getShadowElevationD9Ej5fM;
                borderStroke2 = borderStroke;
                paddingValues2 = paddingValues;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda11
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return MenuKt.DropdownMenuGroup_BfByrIA$lambda$6(menuGroupShapes, modifier3, j2, f3, f4, borderStroke2, paddingValues2, mutableInteractionSource2, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 48;
        modifier2 = modifier;
        if ((i & 384) == 0) {
            if ((i2 & 4) == 0) {
                groupStandardContainerColor = j;
                if (composerStartRestartGroup.changed(groupStandardContainerColor)) {
                }
                i3 |= i17;
            } else {
                groupStandardContainerColor = j;
            }
            i3 |= i17;
        } else {
            groupStandardContainerColor = j;
        }
        i4 = i2 & 8;
        if (i4 != 0) {
            if ((i & 3072) == 0) {
                fM3754getTonalElevationD9Ej5fM = f;
                if (composerStartRestartGroup.changed(fM3754getTonalElevationD9Ej5fM)) {
                    i5 = 2048;
                } else {
                    i5 = 1024;
                }
                i3 |= i5;
            }
            i6 = i2 & 16;
            if (i6 != 0) {
                if ((i & 24576) == 0) {
                    fM3753getShadowElevationD9Ej5fM = f2;
                    if (composerStartRestartGroup.changed(fM3753getShadowElevationD9Ej5fM)) {
                        i7 = 16384;
                    } else {
                        i7 = 8192;
                    }
                    i3 |= i7;
                }
                i8 = i2 & 32;
                if (i8 != 0) {
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    if (composerStartRestartGroup.changed(borderStroke)) {
                        i9 = 131072;
                    } else {
                        i9 = 65536;
                    }
                    i3 |= i9;
                }
                i10 = i2 & 64;
                if (i10 != 0) {
                    i3 |= 1572864;
                } else if ((i & 1572864) == 0) {
                    if (composerStartRestartGroup.changed(paddingValues)) {
                        i11 = 1048576;
                    } else {
                        i11 = 524288;
                    }
                    i3 |= i11;
                }
                i12 = i2 & 128;
                if (i12 != 0) {
                    if ((i & 12582912) == 0) {
                        if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                            i13 = 8388608;
                        } else {
                            i13 = 4194304;
                        }
                        i3 |= i13;
                    }
                    if ((i & 100663296) == 0) {
                        if (composerStartRestartGroup.changedInstance(function3)) {
                            i15 = 67108864;
                        } else {
                            i15 = 33554432;
                        }
                        i3 |= i15;
                    }
                    if ((i3 & 38347923) != 38347922) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "230@11333L27");
                        if ((i & 1) != 0) {
                            if (i16 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if ((i2 & 4) != 0) {
                                groupStandardContainerColor = MenuDefaults.INSTANCE.getGroupStandardContainerColor(composerStartRestartGroup, 6);
                                i3 &= -897;
                            }
                            if (i4 != 0) {
                                fM3754getTonalElevationD9Ej5fM = MenuDefaults.INSTANCE.m3754getTonalElevationD9Ej5fM();
                            }
                            if (i6 != 0) {
                                fM3753getShadowElevationD9Ej5fM = MenuDefaults.INSTANCE.m3753getShadowElevationD9Ej5fM();
                            }
                            if (i8 != 0) {
                                borderStroke3 = null;
                            } else {
                                borderStroke3 = borderStroke;
                            }
                            if (i10 != 0) {
                                dropdownMenuGroupContentPadding = MenuDefaults.INSTANCE.getDropdownMenuGroupContentPadding();
                            } else {
                                dropdownMenuGroupContentPadding = paddingValues;
                            }
                            if (i12 != 0) {
                                f5 = fM3753getShadowElevationD9Ej5fM;
                                j3 = groupStandardContainerColor;
                                i14 = i3;
                                f6 = fM3754getTonalElevationD9Ej5fM;
                                mutableInteractionSource3 = null;
                            } else {
                                f5 = fM3753getShadowElevationD9Ej5fM;
                                j3 = groupStandardContainerColor;
                                i14 = i3;
                                f6 = fM3754getTonalElevationD9Ej5fM;
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                        } else {
                            if (i16 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if ((i2 & 4) != 0) {
                                groupStandardContainerColor = MenuDefaults.INSTANCE.getGroupStandardContainerColor(composerStartRestartGroup, 6);
                                i3 &= -897;
                            }
                            if (i4 != 0) {
                                fM3754getTonalElevationD9Ej5fM = MenuDefaults.INSTANCE.m3754getTonalElevationD9Ej5fM();
                            }
                            if (i6 != 0) {
                                fM3753getShadowElevationD9Ej5fM = MenuDefaults.INSTANCE.m3753getShadowElevationD9Ej5fM();
                            }
                            if (i8 != 0) {
                                borderStroke3 = null;
                            } else {
                                borderStroke3 = borderStroke;
                            }
                            if (i10 != 0) {
                                dropdownMenuGroupContentPadding = MenuDefaults.INSTANCE.getDropdownMenuGroupContentPadding();
                            } else {
                                dropdownMenuGroupContentPadding = paddingValues;
                            }
                            if (i12 != 0) {
                                f5 = fM3753getShadowElevationD9Ej5fM;
                                j3 = groupStandardContainerColor;
                                i14 = i3;
                                f6 = fM3754getTonalElevationD9Ej5fM;
                                mutableInteractionSource3 = null;
                            } else {
                                f5 = fM3753getShadowElevationD9Ej5fM;
                                j3 = groupStandardContainerColor;
                                i14 = i3;
                                f6 = fM3754getTonalElevationD9Ej5fM;
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1580422941, i14, -1, "androidx.compose.material3.DropdownMenuGroup (Menu.kt:237)");
                        }
                        if (mutableInteractionSource3 == null) {
                            composerStartRestartGroup.startReplaceGroup(948907198);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "239@11779L39");
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1631958076, "CC(remember):Menu.kt#9igjgp");
                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue2 = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            }
                            mutableInteractionSource4 = (MutableInteractionSource) objRememberedValue2;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            composerStartRestartGroup.startReplaceGroup(-1631958727);
                            composerStartRestartGroup.endReplaceGroup();
                            mutableInteractionSource4 = mutableInteractionSource3;
                        }
                        stateCollectIsHoveredAsState = HoverInteractionKt.collectIsHoveredAsState(mutableInteractionSource4, composerStartRestartGroup, 0);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1631953953, "CC(remember):Menu.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        mutableState = (MutableState) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if (DropdownMenuGroup_BfByrIA$lambda$1(stateCollectIsHoveredAsState)) {
                            DropdownMenuGroup_BfByrIA$lambda$4(mutableState, true);
                        }
                        int i117 = i14 << 3;
                        BorderStroke borderStroke13 = borderStroke3;
                        composer2 = composerStartRestartGroup;
                        SurfaceKt.m4323SurfaceT9BRK9s(HoverableKt.hoverable$default(Modifier.INSTANCE, mutableInteractionSource4, false, 2, null), shapeByInteraction(menuGroupShapes, DropdownMenuGroup_BfByrIA$lambda$3(mutableState), DropdownMenuGroup_BfByrIA$lambda$1(stateCollectIsHoveredAsState), MotionSchemeKt.value(MotionSchemeKeyTokens.FastSpatial, composerStartRestartGroup, 6), composerStartRestartGroup, i14 & 14), j3, 0L, f6, f5, borderStroke13, ComposableLambdaKt.rememberComposableLambda(-295285640, true, new Function2() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return MenuKt.DropdownMenuGroup_BfByrIA$lambda$5(modifier2, dropdownMenuGroupContentPadding, function3, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54), composer2, (i14 & 896) | 12582912 | (57344 & i117) | (458752 & i117) | (i117 & 3670016), 8);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        mutableInteractionSource2 = mutableInteractionSource3;
                        paddingValues2 = dropdownMenuGroupContentPadding;
                        modifier3 = modifier2;
                        j2 = j3;
                        f3 = f6;
                        f4 = f5;
                        borderStroke2 = borderStroke13;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        mutableInteractionSource2 = mutableInteractionSource;
                        modifier3 = modifier2;
                        j2 = groupStandardContainerColor;
                        f3 = fM3754getTonalElevationD9Ej5fM;
                        f4 = fM3753getShadowElevationD9Ej5fM;
                        borderStroke2 = borderStroke;
                        paddingValues2 = paddingValues;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda11
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return MenuKt.DropdownMenuGroup_BfByrIA$lambda$6(menuGroupShapes, modifier3, j2, f3, f4, borderStroke2, paddingValues2, mutableInteractionSource2, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= 12582912;
                if ((i & 100663296) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i15 = 67108864;
                    } else {
                        i15 = 33554432;
                    }
                    i3 |= i15;
                }
                if ((i3 & 38347923) != 38347922) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "230@11333L27");
                    if ((i & 1) != 0) {
                        if (i16 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if ((i2 & 4) != 0) {
                            groupStandardContainerColor = MenuDefaults.INSTANCE.getGroupStandardContainerColor(composerStartRestartGroup, 6);
                            i3 &= -897;
                        }
                        if (i4 != 0) {
                            fM3754getTonalElevationD9Ej5fM = MenuDefaults.INSTANCE.m3754getTonalElevationD9Ej5fM();
                        }
                        if (i6 != 0) {
                            fM3753getShadowElevationD9Ej5fM = MenuDefaults.INSTANCE.m3753getShadowElevationD9Ej5fM();
                        }
                        if (i8 != 0) {
                            borderStroke3 = null;
                        } else {
                            borderStroke3 = borderStroke;
                        }
                        if (i10 != 0) {
                            dropdownMenuGroupContentPadding = MenuDefaults.INSTANCE.getDropdownMenuGroupContentPadding();
                        } else {
                            dropdownMenuGroupContentPadding = paddingValues;
                        }
                        if (i12 != 0) {
                            f5 = fM3753getShadowElevationD9Ej5fM;
                            j3 = groupStandardContainerColor;
                            i14 = i3;
                            f6 = fM3754getTonalElevationD9Ej5fM;
                            mutableInteractionSource3 = null;
                        } else {
                            f5 = fM3753getShadowElevationD9Ej5fM;
                            j3 = groupStandardContainerColor;
                            i14 = i3;
                            f6 = fM3754getTonalElevationD9Ej5fM;
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                    } else {
                        if (i16 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if ((i2 & 4) != 0) {
                            groupStandardContainerColor = MenuDefaults.INSTANCE.getGroupStandardContainerColor(composerStartRestartGroup, 6);
                            i3 &= -897;
                        }
                        if (i4 != 0) {
                            fM3754getTonalElevationD9Ej5fM = MenuDefaults.INSTANCE.m3754getTonalElevationD9Ej5fM();
                        }
                        if (i6 != 0) {
                            fM3753getShadowElevationD9Ej5fM = MenuDefaults.INSTANCE.m3753getShadowElevationD9Ej5fM();
                        }
                        if (i8 != 0) {
                            borderStroke3 = null;
                        } else {
                            borderStroke3 = borderStroke;
                        }
                        if (i10 != 0) {
                            dropdownMenuGroupContentPadding = MenuDefaults.INSTANCE.getDropdownMenuGroupContentPadding();
                        } else {
                            dropdownMenuGroupContentPadding = paddingValues;
                        }
                        if (i12 != 0) {
                            f5 = fM3753getShadowElevationD9Ej5fM;
                            j3 = groupStandardContainerColor;
                            i14 = i3;
                            f6 = fM3754getTonalElevationD9Ej5fM;
                            mutableInteractionSource3 = null;
                        } else {
                            f5 = fM3753getShadowElevationD9Ej5fM;
                            j3 = groupStandardContainerColor;
                            i14 = i3;
                            f6 = fM3754getTonalElevationD9Ej5fM;
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1580422941, i14, -1, "androidx.compose.material3.DropdownMenuGroup (Menu.kt:237)");
                    }
                    if (mutableInteractionSource3 == null) {
                        composerStartRestartGroup.startReplaceGroup(948907198);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "239@11779L39");
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1631958076, "CC(remember):Menu.kt#9igjgp");
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue2 = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        mutableInteractionSource4 = (MutableInteractionSource) objRememberedValue2;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-1631958727);
                        composerStartRestartGroup.endReplaceGroup();
                        mutableInteractionSource4 = mutableInteractionSource3;
                    }
                    stateCollectIsHoveredAsState = HoverInteractionKt.collectIsHoveredAsState(mutableInteractionSource4, composerStartRestartGroup, 0);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1631953953, "CC(remember):Menu.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    mutableState = (MutableState) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (DropdownMenuGroup_BfByrIA$lambda$1(stateCollectIsHoveredAsState)) {
                        DropdownMenuGroup_BfByrIA$lambda$4(mutableState, true);
                    }
                    int i118 = i14 << 3;
                    BorderStroke borderStroke14 = borderStroke3;
                    composer2 = composerStartRestartGroup;
                    SurfaceKt.m4323SurfaceT9BRK9s(HoverableKt.hoverable$default(Modifier.INSTANCE, mutableInteractionSource4, false, 2, null), shapeByInteraction(menuGroupShapes, DropdownMenuGroup_BfByrIA$lambda$3(mutableState), DropdownMenuGroup_BfByrIA$lambda$1(stateCollectIsHoveredAsState), MotionSchemeKt.value(MotionSchemeKeyTokens.FastSpatial, composerStartRestartGroup, 6), composerStartRestartGroup, i14 & 14), j3, 0L, f6, f5, borderStroke14, ComposableLambdaKt.rememberComposableLambda(-295285640, true, new Function2() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return MenuKt.DropdownMenuGroup_BfByrIA$lambda$5(modifier2, dropdownMenuGroupContentPadding, function3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composer2, (i14 & 896) | 12582912 | (57344 & i118) | (458752 & i118) | (i118 & 3670016), 8);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    mutableInteractionSource2 = mutableInteractionSource3;
                    paddingValues2 = dropdownMenuGroupContentPadding;
                    modifier3 = modifier2;
                    j2 = j3;
                    f3 = f6;
                    f4 = f5;
                    borderStroke2 = borderStroke14;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    mutableInteractionSource2 = mutableInteractionSource;
                    modifier3 = modifier2;
                    j2 = groupStandardContainerColor;
                    f3 = fM3754getTonalElevationD9Ej5fM;
                    f4 = fM3753getShadowElevationD9Ej5fM;
                    borderStroke2 = borderStroke;
                    paddingValues2 = paddingValues;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda11
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return MenuKt.DropdownMenuGroup_BfByrIA$lambda$6(menuGroupShapes, modifier3, j2, f3, f4, borderStroke2, paddingValues2, mutableInteractionSource2, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 24576;
            fM3753getShadowElevationD9Ej5fM = f2;
            i8 = i2 & 32;
            if (i8 != 0) {
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            } else if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                if (composerStartRestartGroup.changed(borderStroke)) {
                    i9 = 131072;
                } else {
                    i9 = 65536;
                }
                i3 |= i9;
            }
            i10 = i2 & 64;
            if (i10 != 0) {
                i3 |= 1572864;
            } else if ((i & 1572864) == 0) {
                if (composerStartRestartGroup.changed(paddingValues)) {
                    i11 = 1048576;
                } else {
                    i11 = 524288;
                }
                i3 |= i11;
            }
            i12 = i2 & 128;
            if (i12 != 0) {
                if ((i & 12582912) == 0) {
                    if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                        i13 = 8388608;
                    } else {
                        i13 = 4194304;
                    }
                    i3 |= i13;
                }
                if ((i & 100663296) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i15 = 67108864;
                    } else {
                        i15 = 33554432;
                    }
                    i3 |= i15;
                }
                if ((i3 & 38347923) != 38347922) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "230@11333L27");
                    if ((i & 1) != 0) {
                        if (i16 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if ((i2 & 4) != 0) {
                            groupStandardContainerColor = MenuDefaults.INSTANCE.getGroupStandardContainerColor(composerStartRestartGroup, 6);
                            i3 &= -897;
                        }
                        if (i4 != 0) {
                            fM3754getTonalElevationD9Ej5fM = MenuDefaults.INSTANCE.m3754getTonalElevationD9Ej5fM();
                        }
                        if (i6 != 0) {
                            fM3753getShadowElevationD9Ej5fM = MenuDefaults.INSTANCE.m3753getShadowElevationD9Ej5fM();
                        }
                        if (i8 != 0) {
                            borderStroke3 = null;
                        } else {
                            borderStroke3 = borderStroke;
                        }
                        if (i10 != 0) {
                            dropdownMenuGroupContentPadding = MenuDefaults.INSTANCE.getDropdownMenuGroupContentPadding();
                        } else {
                            dropdownMenuGroupContentPadding = paddingValues;
                        }
                        if (i12 != 0) {
                            f5 = fM3753getShadowElevationD9Ej5fM;
                            j3 = groupStandardContainerColor;
                            i14 = i3;
                            f6 = fM3754getTonalElevationD9Ej5fM;
                            mutableInteractionSource3 = null;
                        } else {
                            f5 = fM3753getShadowElevationD9Ej5fM;
                            j3 = groupStandardContainerColor;
                            i14 = i3;
                            f6 = fM3754getTonalElevationD9Ej5fM;
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                    } else {
                        if (i16 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if ((i2 & 4) != 0) {
                            groupStandardContainerColor = MenuDefaults.INSTANCE.getGroupStandardContainerColor(composerStartRestartGroup, 6);
                            i3 &= -897;
                        }
                        if (i4 != 0) {
                            fM3754getTonalElevationD9Ej5fM = MenuDefaults.INSTANCE.m3754getTonalElevationD9Ej5fM();
                        }
                        if (i6 != 0) {
                            fM3753getShadowElevationD9Ej5fM = MenuDefaults.INSTANCE.m3753getShadowElevationD9Ej5fM();
                        }
                        if (i8 != 0) {
                            borderStroke3 = null;
                        } else {
                            borderStroke3 = borderStroke;
                        }
                        if (i10 != 0) {
                            dropdownMenuGroupContentPadding = MenuDefaults.INSTANCE.getDropdownMenuGroupContentPadding();
                        } else {
                            dropdownMenuGroupContentPadding = paddingValues;
                        }
                        if (i12 != 0) {
                            f5 = fM3753getShadowElevationD9Ej5fM;
                            j3 = groupStandardContainerColor;
                            i14 = i3;
                            f6 = fM3754getTonalElevationD9Ej5fM;
                            mutableInteractionSource3 = null;
                        } else {
                            f5 = fM3753getShadowElevationD9Ej5fM;
                            j3 = groupStandardContainerColor;
                            i14 = i3;
                            f6 = fM3754getTonalElevationD9Ej5fM;
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1580422941, i14, -1, "androidx.compose.material3.DropdownMenuGroup (Menu.kt:237)");
                    }
                    if (mutableInteractionSource3 == null) {
                        composerStartRestartGroup.startReplaceGroup(948907198);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "239@11779L39");
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1631958076, "CC(remember):Menu.kt#9igjgp");
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue2 = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        mutableInteractionSource4 = (MutableInteractionSource) objRememberedValue2;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-1631958727);
                        composerStartRestartGroup.endReplaceGroup();
                        mutableInteractionSource4 = mutableInteractionSource3;
                    }
                    stateCollectIsHoveredAsState = HoverInteractionKt.collectIsHoveredAsState(mutableInteractionSource4, composerStartRestartGroup, 0);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1631953953, "CC(remember):Menu.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    mutableState = (MutableState) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (DropdownMenuGroup_BfByrIA$lambda$1(stateCollectIsHoveredAsState)) {
                        DropdownMenuGroup_BfByrIA$lambda$4(mutableState, true);
                    }
                    int i119 = i14 << 3;
                    BorderStroke borderStroke15 = borderStroke3;
                    composer2 = composerStartRestartGroup;
                    SurfaceKt.m4323SurfaceT9BRK9s(HoverableKt.hoverable$default(Modifier.INSTANCE, mutableInteractionSource4, false, 2, null), shapeByInteraction(menuGroupShapes, DropdownMenuGroup_BfByrIA$lambda$3(mutableState), DropdownMenuGroup_BfByrIA$lambda$1(stateCollectIsHoveredAsState), MotionSchemeKt.value(MotionSchemeKeyTokens.FastSpatial, composerStartRestartGroup, 6), composerStartRestartGroup, i14 & 14), j3, 0L, f6, f5, borderStroke15, ComposableLambdaKt.rememberComposableLambda(-295285640, true, new Function2() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return MenuKt.DropdownMenuGroup_BfByrIA$lambda$5(modifier2, dropdownMenuGroupContentPadding, function3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composer2, (i14 & 896) | 12582912 | (57344 & i119) | (458752 & i119) | (i119 & 3670016), 8);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    mutableInteractionSource2 = mutableInteractionSource3;
                    paddingValues2 = dropdownMenuGroupContentPadding;
                    modifier3 = modifier2;
                    j2 = j3;
                    f3 = f6;
                    f4 = f5;
                    borderStroke2 = borderStroke15;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    mutableInteractionSource2 = mutableInteractionSource;
                    modifier3 = modifier2;
                    j2 = groupStandardContainerColor;
                    f3 = fM3754getTonalElevationD9Ej5fM;
                    f4 = fM3753getShadowElevationD9Ej5fM;
                    borderStroke2 = borderStroke;
                    paddingValues2 = paddingValues;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda11
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return MenuKt.DropdownMenuGroup_BfByrIA$lambda$6(menuGroupShapes, modifier3, j2, f3, f4, borderStroke2, paddingValues2, mutableInteractionSource2, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 12582912;
            if ((i & 100663296) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i15 = 67108864;
                } else {
                    i15 = 33554432;
                }
                i3 |= i15;
            }
            if ((i3 & 38347923) != 38347922) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "230@11333L27");
                if ((i & 1) != 0) {
                    if (i16 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if ((i2 & 4) != 0) {
                        groupStandardContainerColor = MenuDefaults.INSTANCE.getGroupStandardContainerColor(composerStartRestartGroup, 6);
                        i3 &= -897;
                    }
                    if (i4 != 0) {
                        fM3754getTonalElevationD9Ej5fM = MenuDefaults.INSTANCE.m3754getTonalElevationD9Ej5fM();
                    }
                    if (i6 != 0) {
                        fM3753getShadowElevationD9Ej5fM = MenuDefaults.INSTANCE.m3753getShadowElevationD9Ej5fM();
                    }
                    if (i8 != 0) {
                        borderStroke3 = null;
                    } else {
                        borderStroke3 = borderStroke;
                    }
                    if (i10 != 0) {
                        dropdownMenuGroupContentPadding = MenuDefaults.INSTANCE.getDropdownMenuGroupContentPadding();
                    } else {
                        dropdownMenuGroupContentPadding = paddingValues;
                    }
                    if (i12 != 0) {
                        f5 = fM3753getShadowElevationD9Ej5fM;
                        j3 = groupStandardContainerColor;
                        i14 = i3;
                        f6 = fM3754getTonalElevationD9Ej5fM;
                        mutableInteractionSource3 = null;
                    } else {
                        f5 = fM3753getShadowElevationD9Ej5fM;
                        j3 = groupStandardContainerColor;
                        i14 = i3;
                        f6 = fM3754getTonalElevationD9Ej5fM;
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                } else {
                    if (i16 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if ((i2 & 4) != 0) {
                        groupStandardContainerColor = MenuDefaults.INSTANCE.getGroupStandardContainerColor(composerStartRestartGroup, 6);
                        i3 &= -897;
                    }
                    if (i4 != 0) {
                        fM3754getTonalElevationD9Ej5fM = MenuDefaults.INSTANCE.m3754getTonalElevationD9Ej5fM();
                    }
                    if (i6 != 0) {
                        fM3753getShadowElevationD9Ej5fM = MenuDefaults.INSTANCE.m3753getShadowElevationD9Ej5fM();
                    }
                    if (i8 != 0) {
                        borderStroke3 = null;
                    } else {
                        borderStroke3 = borderStroke;
                    }
                    if (i10 != 0) {
                        dropdownMenuGroupContentPadding = MenuDefaults.INSTANCE.getDropdownMenuGroupContentPadding();
                    } else {
                        dropdownMenuGroupContentPadding = paddingValues;
                    }
                    if (i12 != 0) {
                        f5 = fM3753getShadowElevationD9Ej5fM;
                        j3 = groupStandardContainerColor;
                        i14 = i3;
                        f6 = fM3754getTonalElevationD9Ej5fM;
                        mutableInteractionSource3 = null;
                    } else {
                        f5 = fM3753getShadowElevationD9Ej5fM;
                        j3 = groupStandardContainerColor;
                        i14 = i3;
                        f6 = fM3754getTonalElevationD9Ej5fM;
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1580422941, i14, -1, "androidx.compose.material3.DropdownMenuGroup (Menu.kt:237)");
                }
                if (mutableInteractionSource3 == null) {
                    composerStartRestartGroup.startReplaceGroup(948907198);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "239@11779L39");
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1631958076, "CC(remember):Menu.kt#9igjgp");
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    mutableInteractionSource4 = (MutableInteractionSource) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(-1631958727);
                    composerStartRestartGroup.endReplaceGroup();
                    mutableInteractionSource4 = mutableInteractionSource3;
                }
                stateCollectIsHoveredAsState = HoverInteractionKt.collectIsHoveredAsState(mutableInteractionSource4, composerStartRestartGroup, 0);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1631953953, "CC(remember):Menu.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                mutableState = (MutableState) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (DropdownMenuGroup_BfByrIA$lambda$1(stateCollectIsHoveredAsState)) {
                    DropdownMenuGroup_BfByrIA$lambda$4(mutableState, true);
                }
                int i1110 = i14 << 3;
                BorderStroke borderStroke16 = borderStroke3;
                composer2 = composerStartRestartGroup;
                SurfaceKt.m4323SurfaceT9BRK9s(HoverableKt.hoverable$default(Modifier.INSTANCE, mutableInteractionSource4, false, 2, null), shapeByInteraction(menuGroupShapes, DropdownMenuGroup_BfByrIA$lambda$3(mutableState), DropdownMenuGroup_BfByrIA$lambda$1(stateCollectIsHoveredAsState), MotionSchemeKt.value(MotionSchemeKeyTokens.FastSpatial, composerStartRestartGroup, 6), composerStartRestartGroup, i14 & 14), j3, 0L, f6, f5, borderStroke16, ComposableLambdaKt.rememberComposableLambda(-295285640, true, new Function2() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return MenuKt.DropdownMenuGroup_BfByrIA$lambda$5(modifier2, dropdownMenuGroupContentPadding, function3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composer2, (i14 & 896) | 12582912 | (57344 & i1110) | (458752 & i1110) | (i1110 & 3670016), 8);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                mutableInteractionSource2 = mutableInteractionSource3;
                paddingValues2 = dropdownMenuGroupContentPadding;
                modifier3 = modifier2;
                j2 = j3;
                f3 = f6;
                f4 = f5;
                borderStroke2 = borderStroke16;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                mutableInteractionSource2 = mutableInteractionSource;
                modifier3 = modifier2;
                j2 = groupStandardContainerColor;
                f3 = fM3754getTonalElevationD9Ej5fM;
                f4 = fM3753getShadowElevationD9Ej5fM;
                borderStroke2 = borderStroke;
                paddingValues2 = paddingValues;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda11
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return MenuKt.DropdownMenuGroup_BfByrIA$lambda$6(menuGroupShapes, modifier3, j2, f3, f4, borderStroke2, paddingValues2, mutableInteractionSource2, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 3072;
        fM3754getTonalElevationD9Ej5fM = f;
        i6 = i2 & 16;
        if (i6 != 0) {
            if ((i & 24576) == 0) {
                fM3753getShadowElevationD9Ej5fM = f2;
                if (composerStartRestartGroup.changed(fM3753getShadowElevationD9Ej5fM)) {
                    i7 = 16384;
                } else {
                    i7 = 8192;
                }
                i3 |= i7;
            }
            i8 = i2 & 32;
            if (i8 != 0) {
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            } else if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                if (composerStartRestartGroup.changed(borderStroke)) {
                    i9 = 131072;
                } else {
                    i9 = 65536;
                }
                i3 |= i9;
            }
            i10 = i2 & 64;
            if (i10 != 0) {
                i3 |= 1572864;
            } else if ((i & 1572864) == 0) {
                if (composerStartRestartGroup.changed(paddingValues)) {
                    i11 = 1048576;
                } else {
                    i11 = 524288;
                }
                i3 |= i11;
            }
            i12 = i2 & 128;
            if (i12 != 0) {
                if ((i & 12582912) == 0) {
                    if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                        i13 = 8388608;
                    } else {
                        i13 = 4194304;
                    }
                    i3 |= i13;
                }
                if ((i & 100663296) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i15 = 67108864;
                    } else {
                        i15 = 33554432;
                    }
                    i3 |= i15;
                }
                if ((i3 & 38347923) != 38347922) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "230@11333L27");
                    if ((i & 1) != 0) {
                        if (i16 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if ((i2 & 4) != 0) {
                            groupStandardContainerColor = MenuDefaults.INSTANCE.getGroupStandardContainerColor(composerStartRestartGroup, 6);
                            i3 &= -897;
                        }
                        if (i4 != 0) {
                            fM3754getTonalElevationD9Ej5fM = MenuDefaults.INSTANCE.m3754getTonalElevationD9Ej5fM();
                        }
                        if (i6 != 0) {
                            fM3753getShadowElevationD9Ej5fM = MenuDefaults.INSTANCE.m3753getShadowElevationD9Ej5fM();
                        }
                        if (i8 != 0) {
                            borderStroke3 = null;
                        } else {
                            borderStroke3 = borderStroke;
                        }
                        if (i10 != 0) {
                            dropdownMenuGroupContentPadding = MenuDefaults.INSTANCE.getDropdownMenuGroupContentPadding();
                        } else {
                            dropdownMenuGroupContentPadding = paddingValues;
                        }
                        if (i12 != 0) {
                            f5 = fM3753getShadowElevationD9Ej5fM;
                            j3 = groupStandardContainerColor;
                            i14 = i3;
                            f6 = fM3754getTonalElevationD9Ej5fM;
                            mutableInteractionSource3 = null;
                        } else {
                            f5 = fM3753getShadowElevationD9Ej5fM;
                            j3 = groupStandardContainerColor;
                            i14 = i3;
                            f6 = fM3754getTonalElevationD9Ej5fM;
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                    } else {
                        if (i16 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if ((i2 & 4) != 0) {
                            groupStandardContainerColor = MenuDefaults.INSTANCE.getGroupStandardContainerColor(composerStartRestartGroup, 6);
                            i3 &= -897;
                        }
                        if (i4 != 0) {
                            fM3754getTonalElevationD9Ej5fM = MenuDefaults.INSTANCE.m3754getTonalElevationD9Ej5fM();
                        }
                        if (i6 != 0) {
                            fM3753getShadowElevationD9Ej5fM = MenuDefaults.INSTANCE.m3753getShadowElevationD9Ej5fM();
                        }
                        if (i8 != 0) {
                            borderStroke3 = null;
                        } else {
                            borderStroke3 = borderStroke;
                        }
                        if (i10 != 0) {
                            dropdownMenuGroupContentPadding = MenuDefaults.INSTANCE.getDropdownMenuGroupContentPadding();
                        } else {
                            dropdownMenuGroupContentPadding = paddingValues;
                        }
                        if (i12 != 0) {
                            f5 = fM3753getShadowElevationD9Ej5fM;
                            j3 = groupStandardContainerColor;
                            i14 = i3;
                            f6 = fM3754getTonalElevationD9Ej5fM;
                            mutableInteractionSource3 = null;
                        } else {
                            f5 = fM3753getShadowElevationD9Ej5fM;
                            j3 = groupStandardContainerColor;
                            i14 = i3;
                            f6 = fM3754getTonalElevationD9Ej5fM;
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1580422941, i14, -1, "androidx.compose.material3.DropdownMenuGroup (Menu.kt:237)");
                    }
                    if (mutableInteractionSource3 == null) {
                        composerStartRestartGroup.startReplaceGroup(948907198);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "239@11779L39");
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1631958076, "CC(remember):Menu.kt#9igjgp");
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue2 = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        mutableInteractionSource4 = (MutableInteractionSource) objRememberedValue2;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-1631958727);
                        composerStartRestartGroup.endReplaceGroup();
                        mutableInteractionSource4 = mutableInteractionSource3;
                    }
                    stateCollectIsHoveredAsState = HoverInteractionKt.collectIsHoveredAsState(mutableInteractionSource4, composerStartRestartGroup, 0);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1631953953, "CC(remember):Menu.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    mutableState = (MutableState) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (DropdownMenuGroup_BfByrIA$lambda$1(stateCollectIsHoveredAsState)) {
                        DropdownMenuGroup_BfByrIA$lambda$4(mutableState, true);
                    }
                    int i1111 = i14 << 3;
                    BorderStroke borderStroke17 = borderStroke3;
                    composer2 = composerStartRestartGroup;
                    SurfaceKt.m4323SurfaceT9BRK9s(HoverableKt.hoverable$default(Modifier.INSTANCE, mutableInteractionSource4, false, 2, null), shapeByInteraction(menuGroupShapes, DropdownMenuGroup_BfByrIA$lambda$3(mutableState), DropdownMenuGroup_BfByrIA$lambda$1(stateCollectIsHoveredAsState), MotionSchemeKt.value(MotionSchemeKeyTokens.FastSpatial, composerStartRestartGroup, 6), composerStartRestartGroup, i14 & 14), j3, 0L, f6, f5, borderStroke17, ComposableLambdaKt.rememberComposableLambda(-295285640, true, new Function2() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return MenuKt.DropdownMenuGroup_BfByrIA$lambda$5(modifier2, dropdownMenuGroupContentPadding, function3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composer2, (i14 & 896) | 12582912 | (57344 & i1111) | (458752 & i1111) | (i1111 & 3670016), 8);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    mutableInteractionSource2 = mutableInteractionSource3;
                    paddingValues2 = dropdownMenuGroupContentPadding;
                    modifier3 = modifier2;
                    j2 = j3;
                    f3 = f6;
                    f4 = f5;
                    borderStroke2 = borderStroke17;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    mutableInteractionSource2 = mutableInteractionSource;
                    modifier3 = modifier2;
                    j2 = groupStandardContainerColor;
                    f3 = fM3754getTonalElevationD9Ej5fM;
                    f4 = fM3753getShadowElevationD9Ej5fM;
                    borderStroke2 = borderStroke;
                    paddingValues2 = paddingValues;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda11
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return MenuKt.DropdownMenuGroup_BfByrIA$lambda$6(menuGroupShapes, modifier3, j2, f3, f4, borderStroke2, paddingValues2, mutableInteractionSource2, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 12582912;
            if ((i & 100663296) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i15 = 67108864;
                } else {
                    i15 = 33554432;
                }
                i3 |= i15;
            }
            if ((i3 & 38347923) != 38347922) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "230@11333L27");
                if ((i & 1) != 0) {
                    if (i16 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if ((i2 & 4) != 0) {
                        groupStandardContainerColor = MenuDefaults.INSTANCE.getGroupStandardContainerColor(composerStartRestartGroup, 6);
                        i3 &= -897;
                    }
                    if (i4 != 0) {
                        fM3754getTonalElevationD9Ej5fM = MenuDefaults.INSTANCE.m3754getTonalElevationD9Ej5fM();
                    }
                    if (i6 != 0) {
                        fM3753getShadowElevationD9Ej5fM = MenuDefaults.INSTANCE.m3753getShadowElevationD9Ej5fM();
                    }
                    if (i8 != 0) {
                        borderStroke3 = null;
                    } else {
                        borderStroke3 = borderStroke;
                    }
                    if (i10 != 0) {
                        dropdownMenuGroupContentPadding = MenuDefaults.INSTANCE.getDropdownMenuGroupContentPadding();
                    } else {
                        dropdownMenuGroupContentPadding = paddingValues;
                    }
                    if (i12 != 0) {
                        f5 = fM3753getShadowElevationD9Ej5fM;
                        j3 = groupStandardContainerColor;
                        i14 = i3;
                        f6 = fM3754getTonalElevationD9Ej5fM;
                        mutableInteractionSource3 = null;
                    } else {
                        f5 = fM3753getShadowElevationD9Ej5fM;
                        j3 = groupStandardContainerColor;
                        i14 = i3;
                        f6 = fM3754getTonalElevationD9Ej5fM;
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                } else {
                    if (i16 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if ((i2 & 4) != 0) {
                        groupStandardContainerColor = MenuDefaults.INSTANCE.getGroupStandardContainerColor(composerStartRestartGroup, 6);
                        i3 &= -897;
                    }
                    if (i4 != 0) {
                        fM3754getTonalElevationD9Ej5fM = MenuDefaults.INSTANCE.m3754getTonalElevationD9Ej5fM();
                    }
                    if (i6 != 0) {
                        fM3753getShadowElevationD9Ej5fM = MenuDefaults.INSTANCE.m3753getShadowElevationD9Ej5fM();
                    }
                    if (i8 != 0) {
                        borderStroke3 = null;
                    } else {
                        borderStroke3 = borderStroke;
                    }
                    if (i10 != 0) {
                        dropdownMenuGroupContentPadding = MenuDefaults.INSTANCE.getDropdownMenuGroupContentPadding();
                    } else {
                        dropdownMenuGroupContentPadding = paddingValues;
                    }
                    if (i12 != 0) {
                        f5 = fM3753getShadowElevationD9Ej5fM;
                        j3 = groupStandardContainerColor;
                        i14 = i3;
                        f6 = fM3754getTonalElevationD9Ej5fM;
                        mutableInteractionSource3 = null;
                    } else {
                        f5 = fM3753getShadowElevationD9Ej5fM;
                        j3 = groupStandardContainerColor;
                        i14 = i3;
                        f6 = fM3754getTonalElevationD9Ej5fM;
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1580422941, i14, -1, "androidx.compose.material3.DropdownMenuGroup (Menu.kt:237)");
                }
                if (mutableInteractionSource3 == null) {
                    composerStartRestartGroup.startReplaceGroup(948907198);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "239@11779L39");
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1631958076, "CC(remember):Menu.kt#9igjgp");
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    mutableInteractionSource4 = (MutableInteractionSource) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(-1631958727);
                    composerStartRestartGroup.endReplaceGroup();
                    mutableInteractionSource4 = mutableInteractionSource3;
                }
                stateCollectIsHoveredAsState = HoverInteractionKt.collectIsHoveredAsState(mutableInteractionSource4, composerStartRestartGroup, 0);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1631953953, "CC(remember):Menu.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                mutableState = (MutableState) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (DropdownMenuGroup_BfByrIA$lambda$1(stateCollectIsHoveredAsState)) {
                    DropdownMenuGroup_BfByrIA$lambda$4(mutableState, true);
                }
                int i1112 = i14 << 3;
                BorderStroke borderStroke18 = borderStroke3;
                composer2 = composerStartRestartGroup;
                SurfaceKt.m4323SurfaceT9BRK9s(HoverableKt.hoverable$default(Modifier.INSTANCE, mutableInteractionSource4, false, 2, null), shapeByInteraction(menuGroupShapes, DropdownMenuGroup_BfByrIA$lambda$3(mutableState), DropdownMenuGroup_BfByrIA$lambda$1(stateCollectIsHoveredAsState), MotionSchemeKt.value(MotionSchemeKeyTokens.FastSpatial, composerStartRestartGroup, 6), composerStartRestartGroup, i14 & 14), j3, 0L, f6, f5, borderStroke18, ComposableLambdaKt.rememberComposableLambda(-295285640, true, new Function2() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return MenuKt.DropdownMenuGroup_BfByrIA$lambda$5(modifier2, dropdownMenuGroupContentPadding, function3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composer2, (i14 & 896) | 12582912 | (57344 & i1112) | (458752 & i1112) | (i1112 & 3670016), 8);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                mutableInteractionSource2 = mutableInteractionSource3;
                paddingValues2 = dropdownMenuGroupContentPadding;
                modifier3 = modifier2;
                j2 = j3;
                f3 = f6;
                f4 = f5;
                borderStroke2 = borderStroke18;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                mutableInteractionSource2 = mutableInteractionSource;
                modifier3 = modifier2;
                j2 = groupStandardContainerColor;
                f3 = fM3754getTonalElevationD9Ej5fM;
                f4 = fM3753getShadowElevationD9Ej5fM;
                borderStroke2 = borderStroke;
                paddingValues2 = paddingValues;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda11
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return MenuKt.DropdownMenuGroup_BfByrIA$lambda$6(menuGroupShapes, modifier3, j2, f3, f4, borderStroke2, paddingValues2, mutableInteractionSource2, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 24576;
        fM3753getShadowElevationD9Ej5fM = f2;
        i8 = i2 & 32;
        if (i8 != 0) {
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        } else if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            if (composerStartRestartGroup.changed(borderStroke)) {
                i9 = 131072;
            } else {
                i9 = 65536;
            }
            i3 |= i9;
        }
        i10 = i2 & 64;
        if (i10 != 0) {
            i3 |= 1572864;
        } else if ((i & 1572864) == 0) {
            if (composerStartRestartGroup.changed(paddingValues)) {
                i11 = 1048576;
            } else {
                i11 = 524288;
            }
            i3 |= i11;
        }
        i12 = i2 & 128;
        if (i12 != 0) {
            if ((i & 12582912) == 0) {
                if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                    i13 = 8388608;
                } else {
                    i13 = 4194304;
                }
                i3 |= i13;
            }
            if ((i & 100663296) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i15 = 67108864;
                } else {
                    i15 = 33554432;
                }
                i3 |= i15;
            }
            if ((i3 & 38347923) != 38347922) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "230@11333L27");
                if ((i & 1) != 0) {
                    if (i16 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if ((i2 & 4) != 0) {
                        groupStandardContainerColor = MenuDefaults.INSTANCE.getGroupStandardContainerColor(composerStartRestartGroup, 6);
                        i3 &= -897;
                    }
                    if (i4 != 0) {
                        fM3754getTonalElevationD9Ej5fM = MenuDefaults.INSTANCE.m3754getTonalElevationD9Ej5fM();
                    }
                    if (i6 != 0) {
                        fM3753getShadowElevationD9Ej5fM = MenuDefaults.INSTANCE.m3753getShadowElevationD9Ej5fM();
                    }
                    if (i8 != 0) {
                        borderStroke3 = null;
                    } else {
                        borderStroke3 = borderStroke;
                    }
                    if (i10 != 0) {
                        dropdownMenuGroupContentPadding = MenuDefaults.INSTANCE.getDropdownMenuGroupContentPadding();
                    } else {
                        dropdownMenuGroupContentPadding = paddingValues;
                    }
                    if (i12 != 0) {
                        f5 = fM3753getShadowElevationD9Ej5fM;
                        j3 = groupStandardContainerColor;
                        i14 = i3;
                        f6 = fM3754getTonalElevationD9Ej5fM;
                        mutableInteractionSource3 = null;
                    } else {
                        f5 = fM3753getShadowElevationD9Ej5fM;
                        j3 = groupStandardContainerColor;
                        i14 = i3;
                        f6 = fM3754getTonalElevationD9Ej5fM;
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                } else {
                    if (i16 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if ((i2 & 4) != 0) {
                        groupStandardContainerColor = MenuDefaults.INSTANCE.getGroupStandardContainerColor(composerStartRestartGroup, 6);
                        i3 &= -897;
                    }
                    if (i4 != 0) {
                        fM3754getTonalElevationD9Ej5fM = MenuDefaults.INSTANCE.m3754getTonalElevationD9Ej5fM();
                    }
                    if (i6 != 0) {
                        fM3753getShadowElevationD9Ej5fM = MenuDefaults.INSTANCE.m3753getShadowElevationD9Ej5fM();
                    }
                    if (i8 != 0) {
                        borderStroke3 = null;
                    } else {
                        borderStroke3 = borderStroke;
                    }
                    if (i10 != 0) {
                        dropdownMenuGroupContentPadding = MenuDefaults.INSTANCE.getDropdownMenuGroupContentPadding();
                    } else {
                        dropdownMenuGroupContentPadding = paddingValues;
                    }
                    if (i12 != 0) {
                        f5 = fM3753getShadowElevationD9Ej5fM;
                        j3 = groupStandardContainerColor;
                        i14 = i3;
                        f6 = fM3754getTonalElevationD9Ej5fM;
                        mutableInteractionSource3 = null;
                    } else {
                        f5 = fM3753getShadowElevationD9Ej5fM;
                        j3 = groupStandardContainerColor;
                        i14 = i3;
                        f6 = fM3754getTonalElevationD9Ej5fM;
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1580422941, i14, -1, "androidx.compose.material3.DropdownMenuGroup (Menu.kt:237)");
                }
                if (mutableInteractionSource3 == null) {
                    composerStartRestartGroup.startReplaceGroup(948907198);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "239@11779L39");
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1631958076, "CC(remember):Menu.kt#9igjgp");
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    mutableInteractionSource4 = (MutableInteractionSource) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(-1631958727);
                    composerStartRestartGroup.endReplaceGroup();
                    mutableInteractionSource4 = mutableInteractionSource3;
                }
                stateCollectIsHoveredAsState = HoverInteractionKt.collectIsHoveredAsState(mutableInteractionSource4, composerStartRestartGroup, 0);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1631953953, "CC(remember):Menu.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                mutableState = (MutableState) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (DropdownMenuGroup_BfByrIA$lambda$1(stateCollectIsHoveredAsState)) {
                    DropdownMenuGroup_BfByrIA$lambda$4(mutableState, true);
                }
                int i1113 = i14 << 3;
                BorderStroke borderStroke19 = borderStroke3;
                composer2 = composerStartRestartGroup;
                SurfaceKt.m4323SurfaceT9BRK9s(HoverableKt.hoverable$default(Modifier.INSTANCE, mutableInteractionSource4, false, 2, null), shapeByInteraction(menuGroupShapes, DropdownMenuGroup_BfByrIA$lambda$3(mutableState), DropdownMenuGroup_BfByrIA$lambda$1(stateCollectIsHoveredAsState), MotionSchemeKt.value(MotionSchemeKeyTokens.FastSpatial, composerStartRestartGroup, 6), composerStartRestartGroup, i14 & 14), j3, 0L, f6, f5, borderStroke19, ComposableLambdaKt.rememberComposableLambda(-295285640, true, new Function2() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return MenuKt.DropdownMenuGroup_BfByrIA$lambda$5(modifier2, dropdownMenuGroupContentPadding, function3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composer2, (i14 & 896) | 12582912 | (57344 & i1113) | (458752 & i1113) | (i1113 & 3670016), 8);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                mutableInteractionSource2 = mutableInteractionSource3;
                paddingValues2 = dropdownMenuGroupContentPadding;
                modifier3 = modifier2;
                j2 = j3;
                f3 = f6;
                f4 = f5;
                borderStroke2 = borderStroke19;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                mutableInteractionSource2 = mutableInteractionSource;
                modifier3 = modifier2;
                j2 = groupStandardContainerColor;
                f3 = fM3754getTonalElevationD9Ej5fM;
                f4 = fM3753getShadowElevationD9Ej5fM;
                borderStroke2 = borderStroke;
                paddingValues2 = paddingValues;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda11
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return MenuKt.DropdownMenuGroup_BfByrIA$lambda$6(menuGroupShapes, modifier3, j2, f3, f4, borderStroke2, paddingValues2, mutableInteractionSource2, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 12582912;
        if ((i & 100663296) == 0) {
            if (composerStartRestartGroup.changedInstance(function3)) {
                i15 = 67108864;
            } else {
                i15 = 33554432;
            }
            i3 |= i15;
        }
        if ((i3 & 38347923) != 38347922) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "230@11333L27");
            if ((i & 1) != 0) {
                if (i16 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if ((i2 & 4) != 0) {
                    groupStandardContainerColor = MenuDefaults.INSTANCE.getGroupStandardContainerColor(composerStartRestartGroup, 6);
                    i3 &= -897;
                }
                if (i4 != 0) {
                    fM3754getTonalElevationD9Ej5fM = MenuDefaults.INSTANCE.m3754getTonalElevationD9Ej5fM();
                }
                if (i6 != 0) {
                    fM3753getShadowElevationD9Ej5fM = MenuDefaults.INSTANCE.m3753getShadowElevationD9Ej5fM();
                }
                if (i8 != 0) {
                    borderStroke3 = null;
                } else {
                    borderStroke3 = borderStroke;
                }
                if (i10 != 0) {
                    dropdownMenuGroupContentPadding = MenuDefaults.INSTANCE.getDropdownMenuGroupContentPadding();
                } else {
                    dropdownMenuGroupContentPadding = paddingValues;
                }
                if (i12 != 0) {
                    f5 = fM3753getShadowElevationD9Ej5fM;
                    j3 = groupStandardContainerColor;
                    i14 = i3;
                    f6 = fM3754getTonalElevationD9Ej5fM;
                    mutableInteractionSource3 = null;
                } else {
                    f5 = fM3753getShadowElevationD9Ej5fM;
                    j3 = groupStandardContainerColor;
                    i14 = i3;
                    f6 = fM3754getTonalElevationD9Ej5fM;
                    mutableInteractionSource3 = mutableInteractionSource;
                }
            } else {
                if (i16 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if ((i2 & 4) != 0) {
                    groupStandardContainerColor = MenuDefaults.INSTANCE.getGroupStandardContainerColor(composerStartRestartGroup, 6);
                    i3 &= -897;
                }
                if (i4 != 0) {
                    fM3754getTonalElevationD9Ej5fM = MenuDefaults.INSTANCE.m3754getTonalElevationD9Ej5fM();
                }
                if (i6 != 0) {
                    fM3753getShadowElevationD9Ej5fM = MenuDefaults.INSTANCE.m3753getShadowElevationD9Ej5fM();
                }
                if (i8 != 0) {
                    borderStroke3 = null;
                } else {
                    borderStroke3 = borderStroke;
                }
                if (i10 != 0) {
                    dropdownMenuGroupContentPadding = MenuDefaults.INSTANCE.getDropdownMenuGroupContentPadding();
                } else {
                    dropdownMenuGroupContentPadding = paddingValues;
                }
                if (i12 != 0) {
                    f5 = fM3753getShadowElevationD9Ej5fM;
                    j3 = groupStandardContainerColor;
                    i14 = i3;
                    f6 = fM3754getTonalElevationD9Ej5fM;
                    mutableInteractionSource3 = null;
                } else {
                    f5 = fM3753getShadowElevationD9Ej5fM;
                    j3 = groupStandardContainerColor;
                    i14 = i3;
                    f6 = fM3754getTonalElevationD9Ej5fM;
                    mutableInteractionSource3 = mutableInteractionSource;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1580422941, i14, -1, "androidx.compose.material3.DropdownMenuGroup (Menu.kt:237)");
            }
            if (mutableInteractionSource3 == null) {
                composerStartRestartGroup.startReplaceGroup(948907198);
                ComposerKt.sourceInformation(composerStartRestartGroup, "239@11779L39");
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1631958076, "CC(remember):Menu.kt#9igjgp");
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = InteractionSourceKt.MutableInteractionSource();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                mutableInteractionSource4 = (MutableInteractionSource) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(-1631958727);
                composerStartRestartGroup.endReplaceGroup();
                mutableInteractionSource4 = mutableInteractionSource3;
            }
            stateCollectIsHoveredAsState = HoverInteractionKt.collectIsHoveredAsState(mutableInteractionSource4, composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1631953953, "CC(remember):Menu.kt#9igjgp");
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            mutableState = (MutableState) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (DropdownMenuGroup_BfByrIA$lambda$1(stateCollectIsHoveredAsState)) {
                DropdownMenuGroup_BfByrIA$lambda$4(mutableState, true);
            }
            int i1114 = i14 << 3;
            BorderStroke borderStroke110 = borderStroke3;
            composer2 = composerStartRestartGroup;
            SurfaceKt.m4323SurfaceT9BRK9s(HoverableKt.hoverable$default(Modifier.INSTANCE, mutableInteractionSource4, false, 2, null), shapeByInteraction(menuGroupShapes, DropdownMenuGroup_BfByrIA$lambda$3(mutableState), DropdownMenuGroup_BfByrIA$lambda$1(stateCollectIsHoveredAsState), MotionSchemeKt.value(MotionSchemeKeyTokens.FastSpatial, composerStartRestartGroup, 6), composerStartRestartGroup, i14 & 14), j3, 0L, f6, f5, borderStroke110, ComposableLambdaKt.rememberComposableLambda(-295285640, true, new Function2() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return MenuKt.DropdownMenuGroup_BfByrIA$lambda$5(modifier2, dropdownMenuGroupContentPadding, function3, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composer2, (i14 & 896) | 12582912 | (57344 & i1114) | (458752 & i1114) | (i1114 & 3670016), 8);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            mutableInteractionSource2 = mutableInteractionSource3;
            paddingValues2 = dropdownMenuGroupContentPadding;
            modifier3 = modifier2;
            j2 = j3;
            f3 = f6;
            f4 = f5;
            borderStroke2 = borderStroke110;
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            mutableInteractionSource2 = mutableInteractionSource;
            modifier3 = modifier2;
            j2 = groupStandardContainerColor;
            f3 = fM3754getTonalElevationD9Ej5fM;
            f4 = fM3753getShadowElevationD9Ej5fM;
            borderStroke2 = borderStroke;
            paddingValues2 = paddingValues;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda11
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return MenuKt.DropdownMenuGroup_BfByrIA$lambda$6(menuGroupShapes, modifier3, j2, f3, f4, borderStroke2, paddingValues2, mutableInteractionSource2, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final boolean DropdownMenuGroup_BfByrIA$lambda$3(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void DropdownMenuGroup_BfByrIA$lambda$4(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DropdownMenuGroup_BfByrIA$lambda$5(Modifier modifier, PaddingValues paddingValues, Function3 function3, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C257@12429L70:Menu.kt#uh7d8r");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-295285640, i, -1, "androidx.compose.material3.DropdownMenuGroup.<anonymous> (Menu.kt:257)");
            }
            Modifier modifierPadding = PaddingKt.padding(modifier, paddingValues);
            ComposerKt.sourceInformationMarkerStart(composer, -483455358, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer, 0);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierPadding);
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

    /* JADX WARN: Code duplicated, block: B:104:0x012d  */
    /* JADX WARN: Code duplicated, block: B:105:0x012f  */
    /* JADX WARN: Code duplicated, block: B:108:0x0138  */
    /* JADX WARN: Code duplicated, block: B:110:0x0148  */
    /* JADX WARN: Code duplicated, block: B:118:0x0170 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:119:0x0172  */
    /* JADX WARN: Code duplicated, block: B:121:0x0179  */
    /* JADX WARN: Code duplicated, block: B:123:0x017c  */
    /* JADX WARN: Code duplicated, block: B:125:0x017f  */
    /* JADX WARN: Code duplicated, block: B:128:0x0184  */
    /* JADX WARN: Code duplicated, block: B:129:0x018e  */
    /* JADX WARN: Code duplicated, block: B:131:0x0194  */
    /* JADX WARN: Code duplicated, block: B:132:0x019b  */
    /* JADX WARN: Code duplicated, block: B:134:0x019f  */
    /* JADX WARN: Code duplicated, block: B:135:0x01a4  */
    /* JADX WARN: Code duplicated, block: B:139:0x01b4  */
    /* JADX WARN: Code duplicated, block: B:142:0x01d1  */
    /* JADX WARN: Code duplicated, block: B:145:0x022b  */
    /* JADX WARN: Code duplicated, block: B:147:0x023c  */
    /* JADX WARN: Code duplicated, block: B:150:0x0251  */
    /* JADX WARN: Code duplicated, block: B:152:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:38:0x006b  */
    /* JADX WARN: Code duplicated, block: B:39:0x006e  */
    /* JADX WARN: Code duplicated, block: B:41:0x0072  */
    /* JADX WARN: Code duplicated, block: B:43:0x007a  */
    /* JADX WARN: Code duplicated, block: B:44:0x007d  */
    /* JADX WARN: Code duplicated, block: B:49:0x0089  */
    /* JADX WARN: Code duplicated, block: B:50:0x008b  */
    /* JADX WARN: Code duplicated, block: B:52:0x008e  */
    /* JADX WARN: Code duplicated, block: B:54:0x0096  */
    /* JADX WARN: Code duplicated, block: B:55:0x0099  */
    /* JADX WARN: Code duplicated, block: B:60:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:61:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:63:0x00aa  */
    /* JADX WARN: Code duplicated, block: B:65:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:66:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:71:0x00c2  */
    /* JADX WARN: Code duplicated, block: B:73:0x00c6  */
    /* JADX WARN: Code duplicated, block: B:76:0x00d1 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:79:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:82:0x00e0  */
    /* JADX WARN: Code duplicated, block: B:83:0x00e3  */
    /* JADX WARN: Code duplicated, block: B:85:0x00e7  */
    /* JADX WARN: Code duplicated, block: B:87:0x00f1  */
    /* JADX WARN: Code duplicated, block: B:88:0x00f4  */
    /* JADX WARN: Code duplicated, block: B:93:0x0103  */
    /* JADX WARN: Code duplicated, block: B:94:0x0106  */
    /* JADX WARN: Code duplicated, block: B:96:0x010a  */
    /* JADX WARN: Code duplicated, block: B:98:0x0114  */
    /* JADX WARN: Code duplicated, block: B:99:0x0117  */
    public static final void DropdownMenuItem(final Function0<Unit> function0, final Function2<? super Composer, ? super Integer, Unit> function2, final Shape shape, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function3, Function2<? super Composer, ? super Integer, Unit> function4, boolean z, MenuItemColors menuItemColors, PaddingValues paddingValues, MutableInteractionSource mutableInteractionSource, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        Function2<? super Composer, ? super Integer, Unit> function5;
        int i5;
        int i6;
        Function2<? super Composer, ? super Integer, Unit> function6;
        int i7;
        int i8;
        boolean z2;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        boolean z3;
        Composer composer2;
        final MenuItemColors menuItemColors2;
        final MutableInteractionSource mutableInteractionSource2;
        final Modifier modifier3;
        final Function2<? super Composer, ? super Integer, Unit> function7;
        final Function2<? super Composer, ? super Integer, Unit> function8;
        final boolean z4;
        final PaddingValues paddingValues2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        MenuItemColors menuItemColorsItemColors;
        int i15;
        PaddingValues dropdownMenuItemContentPadding;
        MutableInteractionSource mutableInteractionSource3;
        PaddingValues paddingValues3;
        Object objRememberedValue;
        Composer composerStartRestartGroup = composer.startRestartGroup(70219170);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(DropdownMenuItem)N(onClick,text,shape,modifier,leadingIcon,trailingIcon,enabled,colors,contentPadding,interactionSource)344@16668L22,350@16882L25,340@16531L471:Menu.kt#uh7d8r");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(function0) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function2) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changed(shape) ? 256 : 128;
        }
        int i16 = i2 & 8;
        if (i16 == 0) {
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
                    i8 = i2 & 64;
                    if (i8 != 0) {
                        if ((1572864 & i) == 0) {
                            z2 = z;
                            if (composerStartRestartGroup.changed(z2)) {
                                i9 = 1048576;
                            } else {
                                i9 = 524288;
                            }
                            i3 |= i9;
                        }
                        if ((i & 12582912) != 0) {
                            i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(menuItemColors)) ? 4194304 : 8388608;
                        }
                        i10 = i2 & 256;
                        if (i10 != 0) {
                            if ((i & 100663296) == 0) {
                                if (composerStartRestartGroup.changed(paddingValues)) {
                                    i11 = 67108864;
                                } else {
                                    i11 = 33554432;
                                }
                                i3 |= i11;
                            }
                            i12 = i2 & 512;
                            if (i12 != 0) {
                                if ((i & 805306368) == 0) {
                                    if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                                        i13 = C.BUFFER_FLAG_LAST_SAMPLE;
                                    } else {
                                        i13 = 268435456;
                                    }
                                    i3 |= i13;
                                }
                                i14 = i3;
                                if ((i3 & 306783379) != 306783378) {
                                    z3 = true;
                                } else {
                                    z3 = false;
                                }
                                if (composerStartRestartGroup.shouldExecute(z3, i14 & 1)) {
                                    composerStartRestartGroup.startDefaults();
                                    ComposerKt.sourceInformation(composerStartRestartGroup, "336@16371L12");
                                    if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                        if (i16 != 0) {
                                            modifier2 = Modifier.INSTANCE;
                                        }
                                        if (i4 != 0) {
                                            function5 = null;
                                        }
                                        if (i6 != 0) {
                                            function6 = null;
                                        }
                                        if (i8 != 0) {
                                            z2 = true;
                                        }
                                        if ((i2 & 128) != 0) {
                                            menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                                            i15 = i14 & (-29360129);
                                        } else {
                                            menuItemColorsItemColors = menuItemColors;
                                            i15 = i14;
                                        }
                                        if (i10 != 0) {
                                            dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                                        } else {
                                            dropdownMenuItemContentPadding = paddingValues;
                                        }
                                        if (i12 != 0) {
                                            mutableInteractionSource3 = null;
                                        } else {
                                            mutableInteractionSource3 = mutableInteractionSource;
                                        }
                                        paddingValues3 = dropdownMenuItemContentPadding;
                                    } else {
                                        composerStartRestartGroup.skipToGroupEnd();
                                        if ((i2 & 128) != 0) {
                                            menuItemColorsItemColors = menuItemColors;
                                            paddingValues3 = paddingValues;
                                            mutableInteractionSource3 = mutableInteractionSource;
                                            i15 = i14 & (-29360129);
                                        } else {
                                            menuItemColorsItemColors = menuItemColors;
                                            paddingValues3 = paddingValues;
                                            mutableInteractionSource3 = mutableInteractionSource;
                                            i15 = i14;
                                        }
                                    }
                                    Function2<? super Composer, ? super Integer, Unit> function9 = function5;
                                    Function2<? super Composer, ? super Integer, Unit> function10 = function6;
                                    boolean z5 = z2;
                                    composerStartRestartGroup.endDefaults();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(70219170, i15, -1, "androidx.compose.material3.DropdownMenuItem (Menu.kt:339)");
                                    }
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1238834984, "CC(remember):Menu.kt#9igjgp");
                                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                        objRememberedValue = new Function1() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda29
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Object invoke(Object obj) {
                                                return MenuKt.DropdownMenuItem$lambda$0$0((SemanticsPropertyReceiver) obj);
                                            }
                                        };
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                    }
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                    composer2 = composerStartRestartGroup;
                                    int i17 = i15 << 3;
                                    DropdownMenuItemContent(false, function0, function2, SemanticsModifierKt.semantics$default(modifier2, false, (Function1) objRememberedValue, 1, null), function9, null, function10, z5, menuItemColorsItemColors, MenuDefaults.INSTANCE.itemShapes(shape, null, composerStartRestartGroup, ((i15 >> 6) & 14) | 384, 2), paddingValues3, mutableInteractionSource3, composer2, (i17 & 112) | 196614 | (i17 & 896) | (57344 & i15) | (3670016 & i17) | (29360128 & i17) | (i17 & 234881024), (i15 >> 24) & 126);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    modifier3 = modifier2;
                                    function7 = function9;
                                    function8 = function10;
                                    z4 = z5;
                                    menuItemColors2 = menuItemColorsItemColors;
                                    paddingValues2 = paddingValues3;
                                    mutableInteractionSource2 = mutableInteractionSource3;
                                } else {
                                    composer2 = composerStartRestartGroup;
                                    composer2.skipToGroupEnd();
                                    menuItemColors2 = menuItemColors;
                                    mutableInteractionSource2 = mutableInteractionSource;
                                    modifier3 = modifier2;
                                    function7 = function5;
                                    function8 = function6;
                                    z4 = z2;
                                    paddingValues2 = paddingValues;
                                }
                                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                                if (scopeUpdateScopeEndRestartGroup != null) {
                                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda30
                                        @Override // kotlin.jvm.functions.Function2
                                        public final Object invoke(Object obj, Object obj2) {
                                            return MenuKt.DropdownMenuItem$lambda$1(function0, function2, shape, modifier3, function7, function8, z4, menuItemColors2, paddingValues2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                        }
                                    });
                                }
                            }
                            i3 |= 805306368;
                            i14 = i3;
                            if ((i3 & 306783379) != 306783378) {
                                z3 = true;
                            } else {
                                z3 = false;
                            }
                            if (composerStartRestartGroup.shouldExecute(z3, i14 & 1)) {
                                composerStartRestartGroup.startDefaults();
                                ComposerKt.sourceInformation(composerStartRestartGroup, "336@16371L12");
                                if ((i & 1) != 0) {
                                    if (i16 != 0) {
                                        modifier2 = Modifier.INSTANCE;
                                    }
                                    if (i4 != 0) {
                                        function5 = null;
                                    }
                                    if (i6 != 0) {
                                        function6 = null;
                                    }
                                    if (i8 != 0) {
                                        z2 = true;
                                    }
                                    if ((i2 & 128) != 0) {
                                        menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                                        i15 = i14 & (-29360129);
                                    } else {
                                        menuItemColorsItemColors = menuItemColors;
                                        i15 = i14;
                                    }
                                    if (i10 != 0) {
                                        dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                                    } else {
                                        dropdownMenuItemContentPadding = paddingValues;
                                    }
                                    if (i12 != 0) {
                                        mutableInteractionSource3 = null;
                                    } else {
                                        mutableInteractionSource3 = mutableInteractionSource;
                                    }
                                    paddingValues3 = dropdownMenuItemContentPadding;
                                } else {
                                    if (i16 != 0) {
                                        modifier2 = Modifier.INSTANCE;
                                    }
                                    if (i4 != 0) {
                                        function5 = null;
                                    }
                                    if (i6 != 0) {
                                        function6 = null;
                                    }
                                    if (i8 != 0) {
                                        z2 = true;
                                    }
                                    if ((i2 & 128) != 0) {
                                        menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                                        i15 = i14 & (-29360129);
                                    } else {
                                        menuItemColorsItemColors = menuItemColors;
                                        i15 = i14;
                                    }
                                    if (i10 != 0) {
                                        dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                                    } else {
                                        dropdownMenuItemContentPadding = paddingValues;
                                    }
                                    if (i12 != 0) {
                                        mutableInteractionSource3 = null;
                                    } else {
                                        mutableInteractionSource3 = mutableInteractionSource;
                                    }
                                    paddingValues3 = dropdownMenuItemContentPadding;
                                }
                                Function2<? super Composer, ? super Integer, Unit> function11 = function5;
                                Function2<? super Composer, ? super Integer, Unit> function12 = function6;
                                boolean z6 = z2;
                                composerStartRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(70219170, i15, -1, "androidx.compose.material3.DropdownMenuItem (Menu.kt:339)");
                                }
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1238834984, "CC(remember):Menu.kt#9igjgp");
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue = new Function1() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda29
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj) {
                                            return MenuKt.DropdownMenuItem$lambda$0$0((SemanticsPropertyReceiver) obj);
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                composer2 = composerStartRestartGroup;
                                int i18 = i15 << 3;
                                DropdownMenuItemContent(false, function0, function2, SemanticsModifierKt.semantics$default(modifier2, false, (Function1) objRememberedValue, 1, null), function11, null, function12, z6, menuItemColorsItemColors, MenuDefaults.INSTANCE.itemShapes(shape, null, composerStartRestartGroup, ((i15 >> 6) & 14) | 384, 2), paddingValues3, mutableInteractionSource3, composer2, (i18 & 112) | 196614 | (i18 & 896) | (57344 & i15) | (3670016 & i18) | (29360128 & i18) | (i18 & 234881024), (i15 >> 24) & 126);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                modifier3 = modifier2;
                                function7 = function11;
                                function8 = function12;
                                z4 = z6;
                                menuItemColors2 = menuItemColorsItemColors;
                                paddingValues2 = paddingValues3;
                                mutableInteractionSource2 = mutableInteractionSource3;
                            } else {
                                composer2 = composerStartRestartGroup;
                                composer2.skipToGroupEnd();
                                menuItemColors2 = menuItemColors;
                                mutableInteractionSource2 = mutableInteractionSource;
                                modifier3 = modifier2;
                                function7 = function5;
                                function8 = function6;
                                z4 = z2;
                                paddingValues2 = paddingValues;
                            }
                            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup != null) {
                                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda30
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return MenuKt.DropdownMenuItem$lambda$1(function0, function2, shape, modifier3, function7, function8, z4, menuItemColors2, paddingValues2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                    }
                                });
                            }
                        }
                        i3 |= 100663296;
                        i12 = i2 & 512;
                        if (i12 != 0) {
                            if ((i & 805306368) == 0) {
                                if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                                    i13 = C.BUFFER_FLAG_LAST_SAMPLE;
                                } else {
                                    i13 = 268435456;
                                }
                                i3 |= i13;
                            }
                            i14 = i3;
                            if ((i3 & 306783379) != 306783378) {
                                z3 = true;
                            } else {
                                z3 = false;
                            }
                            if (composerStartRestartGroup.shouldExecute(z3, i14 & 1)) {
                                composerStartRestartGroup.startDefaults();
                                ComposerKt.sourceInformation(composerStartRestartGroup, "336@16371L12");
                                if ((i & 1) != 0) {
                                    if (i16 != 0) {
                                        modifier2 = Modifier.INSTANCE;
                                    }
                                    if (i4 != 0) {
                                        function5 = null;
                                    }
                                    if (i6 != 0) {
                                        function6 = null;
                                    }
                                    if (i8 != 0) {
                                        z2 = true;
                                    }
                                    if ((i2 & 128) != 0) {
                                        menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                                        i15 = i14 & (-29360129);
                                    } else {
                                        menuItemColorsItemColors = menuItemColors;
                                        i15 = i14;
                                    }
                                    if (i10 != 0) {
                                        dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                                    } else {
                                        dropdownMenuItemContentPadding = paddingValues;
                                    }
                                    if (i12 != 0) {
                                        mutableInteractionSource3 = null;
                                    } else {
                                        mutableInteractionSource3 = mutableInteractionSource;
                                    }
                                    paddingValues3 = dropdownMenuItemContentPadding;
                                } else {
                                    if (i16 != 0) {
                                        modifier2 = Modifier.INSTANCE;
                                    }
                                    if (i4 != 0) {
                                        function5 = null;
                                    }
                                    if (i6 != 0) {
                                        function6 = null;
                                    }
                                    if (i8 != 0) {
                                        z2 = true;
                                    }
                                    if ((i2 & 128) != 0) {
                                        menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                                        i15 = i14 & (-29360129);
                                    } else {
                                        menuItemColorsItemColors = menuItemColors;
                                        i15 = i14;
                                    }
                                    if (i10 != 0) {
                                        dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                                    } else {
                                        dropdownMenuItemContentPadding = paddingValues;
                                    }
                                    if (i12 != 0) {
                                        mutableInteractionSource3 = null;
                                    } else {
                                        mutableInteractionSource3 = mutableInteractionSource;
                                    }
                                    paddingValues3 = dropdownMenuItemContentPadding;
                                }
                                Function2<? super Composer, ? super Integer, Unit> function13 = function5;
                                Function2<? super Composer, ? super Integer, Unit> function14 = function6;
                                boolean z7 = z2;
                                composerStartRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(70219170, i15, -1, "androidx.compose.material3.DropdownMenuItem (Menu.kt:339)");
                                }
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1238834984, "CC(remember):Menu.kt#9igjgp");
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue = new Function1() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda29
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj) {
                                            return MenuKt.DropdownMenuItem$lambda$0$0((SemanticsPropertyReceiver) obj);
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                composer2 = composerStartRestartGroup;
                                int i19 = i15 << 3;
                                DropdownMenuItemContent(false, function0, function2, SemanticsModifierKt.semantics$default(modifier2, false, (Function1) objRememberedValue, 1, null), function13, null, function14, z7, menuItemColorsItemColors, MenuDefaults.INSTANCE.itemShapes(shape, null, composerStartRestartGroup, ((i15 >> 6) & 14) | 384, 2), paddingValues3, mutableInteractionSource3, composer2, (i19 & 112) | 196614 | (i19 & 896) | (57344 & i15) | (3670016 & i19) | (29360128 & i19) | (i19 & 234881024), (i15 >> 24) & 126);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                modifier3 = modifier2;
                                function7 = function13;
                                function8 = function14;
                                z4 = z7;
                                menuItemColors2 = menuItemColorsItemColors;
                                paddingValues2 = paddingValues3;
                                mutableInteractionSource2 = mutableInteractionSource3;
                            } else {
                                composer2 = composerStartRestartGroup;
                                composer2.skipToGroupEnd();
                                menuItemColors2 = menuItemColors;
                                mutableInteractionSource2 = mutableInteractionSource;
                                modifier3 = modifier2;
                                function7 = function5;
                                function8 = function6;
                                z4 = z2;
                                paddingValues2 = paddingValues;
                            }
                            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup != null) {
                                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda30
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return MenuKt.DropdownMenuItem$lambda$1(function0, function2, shape, modifier3, function7, function8, z4, menuItemColors2, paddingValues2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                    }
                                });
                            }
                        }
                        i3 |= 805306368;
                        i14 = i3;
                        if ((i3 & 306783379) != 306783378) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        if (composerStartRestartGroup.shouldExecute(z3, i14 & 1)) {
                            composerStartRestartGroup.startDefaults();
                            ComposerKt.sourceInformation(composerStartRestartGroup, "336@16371L12");
                            if ((i & 1) != 0) {
                                if (i16 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                if (i4 != 0) {
                                    function5 = null;
                                }
                                if (i6 != 0) {
                                    function6 = null;
                                }
                                if (i8 != 0) {
                                    z2 = true;
                                }
                                if ((i2 & 128) != 0) {
                                    menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                                    i15 = i14 & (-29360129);
                                } else {
                                    menuItemColorsItemColors = menuItemColors;
                                    i15 = i14;
                                }
                                if (i10 != 0) {
                                    dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                                } else {
                                    dropdownMenuItemContentPadding = paddingValues;
                                }
                                if (i12 != 0) {
                                    mutableInteractionSource3 = null;
                                } else {
                                    mutableInteractionSource3 = mutableInteractionSource;
                                }
                                paddingValues3 = dropdownMenuItemContentPadding;
                            } else {
                                if (i16 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                if (i4 != 0) {
                                    function5 = null;
                                }
                                if (i6 != 0) {
                                    function6 = null;
                                }
                                if (i8 != 0) {
                                    z2 = true;
                                }
                                if ((i2 & 128) != 0) {
                                    menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                                    i15 = i14 & (-29360129);
                                } else {
                                    menuItemColorsItemColors = menuItemColors;
                                    i15 = i14;
                                }
                                if (i10 != 0) {
                                    dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                                } else {
                                    dropdownMenuItemContentPadding = paddingValues;
                                }
                                if (i12 != 0) {
                                    mutableInteractionSource3 = null;
                                } else {
                                    mutableInteractionSource3 = mutableInteractionSource;
                                }
                                paddingValues3 = dropdownMenuItemContentPadding;
                            }
                            Function2<? super Composer, ? super Integer, Unit> function15 = function5;
                            Function2<? super Composer, ? super Integer, Unit> function16 = function6;
                            boolean z8 = z2;
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(70219170, i15, -1, "androidx.compose.material3.DropdownMenuItem (Menu.kt:339)");
                            }
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1238834984, "CC(remember):Menu.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = new Function1() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda29
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return MenuKt.DropdownMenuItem$lambda$0$0((SemanticsPropertyReceiver) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            composer2 = composerStartRestartGroup;
                            int i110 = i15 << 3;
                            DropdownMenuItemContent(false, function0, function2, SemanticsModifierKt.semantics$default(modifier2, false, (Function1) objRememberedValue, 1, null), function15, null, function16, z8, menuItemColorsItemColors, MenuDefaults.INSTANCE.itemShapes(shape, null, composerStartRestartGroup, ((i15 >> 6) & 14) | 384, 2), paddingValues3, mutableInteractionSource3, composer2, (i110 & 112) | 196614 | (i110 & 896) | (57344 & i15) | (3670016 & i110) | (29360128 & i110) | (i110 & 234881024), (i15 >> 24) & 126);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier3 = modifier2;
                            function7 = function15;
                            function8 = function16;
                            z4 = z8;
                            menuItemColors2 = menuItemColorsItemColors;
                            paddingValues2 = paddingValues3;
                            mutableInteractionSource2 = mutableInteractionSource3;
                        } else {
                            composer2 = composerStartRestartGroup;
                            composer2.skipToGroupEnd();
                            menuItemColors2 = menuItemColors;
                            mutableInteractionSource2 = mutableInteractionSource;
                            modifier3 = modifier2;
                            function7 = function5;
                            function8 = function6;
                            z4 = z2;
                            paddingValues2 = paddingValues;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda30
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return MenuKt.DropdownMenuItem$lambda$1(function0, function2, shape, modifier3, function7, function8, z4, menuItemColors2, paddingValues2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                        }
                    }
                    i3 |= 1572864;
                    z2 = z;
                    if ((i & 12582912) != 0) {
                        i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(menuItemColors)) ? 4194304 : 8388608;
                    }
                    i10 = i2 & 256;
                    if (i10 != 0) {
                        if ((i & 100663296) == 0) {
                            if (composerStartRestartGroup.changed(paddingValues)) {
                                i11 = 67108864;
                            } else {
                                i11 = 33554432;
                            }
                            i3 |= i11;
                        }
                        i12 = i2 & 512;
                        if (i12 != 0) {
                            if ((i & 805306368) == 0) {
                                if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                                    i13 = C.BUFFER_FLAG_LAST_SAMPLE;
                                } else {
                                    i13 = 268435456;
                                }
                                i3 |= i13;
                            }
                            i14 = i3;
                            if ((i3 & 306783379) != 306783378) {
                                z3 = true;
                            } else {
                                z3 = false;
                            }
                            if (composerStartRestartGroup.shouldExecute(z3, i14 & 1)) {
                                composerStartRestartGroup.startDefaults();
                                ComposerKt.sourceInformation(composerStartRestartGroup, "336@16371L12");
                                if ((i & 1) != 0) {
                                    if (i16 != 0) {
                                        modifier2 = Modifier.INSTANCE;
                                    }
                                    if (i4 != 0) {
                                        function5 = null;
                                    }
                                    if (i6 != 0) {
                                        function6 = null;
                                    }
                                    if (i8 != 0) {
                                        z2 = true;
                                    }
                                    if ((i2 & 128) != 0) {
                                        menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                                        i15 = i14 & (-29360129);
                                    } else {
                                        menuItemColorsItemColors = menuItemColors;
                                        i15 = i14;
                                    }
                                    if (i10 != 0) {
                                        dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                                    } else {
                                        dropdownMenuItemContentPadding = paddingValues;
                                    }
                                    if (i12 != 0) {
                                        mutableInteractionSource3 = null;
                                    } else {
                                        mutableInteractionSource3 = mutableInteractionSource;
                                    }
                                    paddingValues3 = dropdownMenuItemContentPadding;
                                } else {
                                    if (i16 != 0) {
                                        modifier2 = Modifier.INSTANCE;
                                    }
                                    if (i4 != 0) {
                                        function5 = null;
                                    }
                                    if (i6 != 0) {
                                        function6 = null;
                                    }
                                    if (i8 != 0) {
                                        z2 = true;
                                    }
                                    if ((i2 & 128) != 0) {
                                        menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                                        i15 = i14 & (-29360129);
                                    } else {
                                        menuItemColorsItemColors = menuItemColors;
                                        i15 = i14;
                                    }
                                    if (i10 != 0) {
                                        dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                                    } else {
                                        dropdownMenuItemContentPadding = paddingValues;
                                    }
                                    if (i12 != 0) {
                                        mutableInteractionSource3 = null;
                                    } else {
                                        mutableInteractionSource3 = mutableInteractionSource;
                                    }
                                    paddingValues3 = dropdownMenuItemContentPadding;
                                }
                                Function2<? super Composer, ? super Integer, Unit> function17 = function5;
                                Function2<? super Composer, ? super Integer, Unit> function18 = function6;
                                boolean z9 = z2;
                                composerStartRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(70219170, i15, -1, "androidx.compose.material3.DropdownMenuItem (Menu.kt:339)");
                                }
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1238834984, "CC(remember):Menu.kt#9igjgp");
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue = new Function1() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda29
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj) {
                                            return MenuKt.DropdownMenuItem$lambda$0$0((SemanticsPropertyReceiver) obj);
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                composer2 = composerStartRestartGroup;
                                int i111 = i15 << 3;
                                DropdownMenuItemContent(false, function0, function2, SemanticsModifierKt.semantics$default(modifier2, false, (Function1) objRememberedValue, 1, null), function17, null, function18, z9, menuItemColorsItemColors, MenuDefaults.INSTANCE.itemShapes(shape, null, composerStartRestartGroup, ((i15 >> 6) & 14) | 384, 2), paddingValues3, mutableInteractionSource3, composer2, (i111 & 112) | 196614 | (i111 & 896) | (57344 & i15) | (3670016 & i111) | (29360128 & i111) | (i111 & 234881024), (i15 >> 24) & 126);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                modifier3 = modifier2;
                                function7 = function17;
                                function8 = function18;
                                z4 = z9;
                                menuItemColors2 = menuItemColorsItemColors;
                                paddingValues2 = paddingValues3;
                                mutableInteractionSource2 = mutableInteractionSource3;
                            } else {
                                composer2 = composerStartRestartGroup;
                                composer2.skipToGroupEnd();
                                menuItemColors2 = menuItemColors;
                                mutableInteractionSource2 = mutableInteractionSource;
                                modifier3 = modifier2;
                                function7 = function5;
                                function8 = function6;
                                z4 = z2;
                                paddingValues2 = paddingValues;
                            }
                            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup != null) {
                                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda30
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return MenuKt.DropdownMenuItem$lambda$1(function0, function2, shape, modifier3, function7, function8, z4, menuItemColors2, paddingValues2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                    }
                                });
                            }
                        }
                        i3 |= 805306368;
                        i14 = i3;
                        if ((i3 & 306783379) != 306783378) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        if (composerStartRestartGroup.shouldExecute(z3, i14 & 1)) {
                            composerStartRestartGroup.startDefaults();
                            ComposerKt.sourceInformation(composerStartRestartGroup, "336@16371L12");
                            if ((i & 1) != 0) {
                                if (i16 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                if (i4 != 0) {
                                    function5 = null;
                                }
                                if (i6 != 0) {
                                    function6 = null;
                                }
                                if (i8 != 0) {
                                    z2 = true;
                                }
                                if ((i2 & 128) != 0) {
                                    menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                                    i15 = i14 & (-29360129);
                                } else {
                                    menuItemColorsItemColors = menuItemColors;
                                    i15 = i14;
                                }
                                if (i10 != 0) {
                                    dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                                } else {
                                    dropdownMenuItemContentPadding = paddingValues;
                                }
                                if (i12 != 0) {
                                    mutableInteractionSource3 = null;
                                } else {
                                    mutableInteractionSource3 = mutableInteractionSource;
                                }
                                paddingValues3 = dropdownMenuItemContentPadding;
                            } else {
                                if (i16 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                if (i4 != 0) {
                                    function5 = null;
                                }
                                if (i6 != 0) {
                                    function6 = null;
                                }
                                if (i8 != 0) {
                                    z2 = true;
                                }
                                if ((i2 & 128) != 0) {
                                    menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                                    i15 = i14 & (-29360129);
                                } else {
                                    menuItemColorsItemColors = menuItemColors;
                                    i15 = i14;
                                }
                                if (i10 != 0) {
                                    dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                                } else {
                                    dropdownMenuItemContentPadding = paddingValues;
                                }
                                if (i12 != 0) {
                                    mutableInteractionSource3 = null;
                                } else {
                                    mutableInteractionSource3 = mutableInteractionSource;
                                }
                                paddingValues3 = dropdownMenuItemContentPadding;
                            }
                            Function2<? super Composer, ? super Integer, Unit> function19 = function5;
                            Function2<? super Composer, ? super Integer, Unit> function110 = function6;
                            boolean z10 = z2;
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(70219170, i15, -1, "androidx.compose.material3.DropdownMenuItem (Menu.kt:339)");
                            }
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1238834984, "CC(remember):Menu.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = new Function1() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda29
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return MenuKt.DropdownMenuItem$lambda$0$0((SemanticsPropertyReceiver) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            composer2 = composerStartRestartGroup;
                            int i112 = i15 << 3;
                            DropdownMenuItemContent(false, function0, function2, SemanticsModifierKt.semantics$default(modifier2, false, (Function1) objRememberedValue, 1, null), function19, null, function110, z10, menuItemColorsItemColors, MenuDefaults.INSTANCE.itemShapes(shape, null, composerStartRestartGroup, ((i15 >> 6) & 14) | 384, 2), paddingValues3, mutableInteractionSource3, composer2, (i112 & 112) | 196614 | (i112 & 896) | (57344 & i15) | (3670016 & i112) | (29360128 & i112) | (i112 & 234881024), (i15 >> 24) & 126);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier3 = modifier2;
                            function7 = function19;
                            function8 = function110;
                            z4 = z10;
                            menuItemColors2 = menuItemColorsItemColors;
                            paddingValues2 = paddingValues3;
                            mutableInteractionSource2 = mutableInteractionSource3;
                        } else {
                            composer2 = composerStartRestartGroup;
                            composer2.skipToGroupEnd();
                            menuItemColors2 = menuItemColors;
                            mutableInteractionSource2 = mutableInteractionSource;
                            modifier3 = modifier2;
                            function7 = function5;
                            function8 = function6;
                            z4 = z2;
                            paddingValues2 = paddingValues;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda30
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return MenuKt.DropdownMenuItem$lambda$1(function0, function2, shape, modifier3, function7, function8, z4, menuItemColors2, paddingValues2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                        }
                    }
                    i3 |= 100663296;
                    i12 = i2 & 512;
                    if (i12 != 0) {
                        if ((i & 805306368) == 0) {
                            if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                                i13 = C.BUFFER_FLAG_LAST_SAMPLE;
                            } else {
                                i13 = 268435456;
                            }
                            i3 |= i13;
                        }
                        i14 = i3;
                        if ((i3 & 306783379) != 306783378) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        if (composerStartRestartGroup.shouldExecute(z3, i14 & 1)) {
                            composerStartRestartGroup.startDefaults();
                            ComposerKt.sourceInformation(composerStartRestartGroup, "336@16371L12");
                            if ((i & 1) != 0) {
                                if (i16 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                if (i4 != 0) {
                                    function5 = null;
                                }
                                if (i6 != 0) {
                                    function6 = null;
                                }
                                if (i8 != 0) {
                                    z2 = true;
                                }
                                if ((i2 & 128) != 0) {
                                    menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                                    i15 = i14 & (-29360129);
                                } else {
                                    menuItemColorsItemColors = menuItemColors;
                                    i15 = i14;
                                }
                                if (i10 != 0) {
                                    dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                                } else {
                                    dropdownMenuItemContentPadding = paddingValues;
                                }
                                if (i12 != 0) {
                                    mutableInteractionSource3 = null;
                                } else {
                                    mutableInteractionSource3 = mutableInteractionSource;
                                }
                                paddingValues3 = dropdownMenuItemContentPadding;
                            } else {
                                if (i16 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                if (i4 != 0) {
                                    function5 = null;
                                }
                                if (i6 != 0) {
                                    function6 = null;
                                }
                                if (i8 != 0) {
                                    z2 = true;
                                }
                                if ((i2 & 128) != 0) {
                                    menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                                    i15 = i14 & (-29360129);
                                } else {
                                    menuItemColorsItemColors = menuItemColors;
                                    i15 = i14;
                                }
                                if (i10 != 0) {
                                    dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                                } else {
                                    dropdownMenuItemContentPadding = paddingValues;
                                }
                                if (i12 != 0) {
                                    mutableInteractionSource3 = null;
                                } else {
                                    mutableInteractionSource3 = mutableInteractionSource;
                                }
                                paddingValues3 = dropdownMenuItemContentPadding;
                            }
                            Function2<? super Composer, ? super Integer, Unit> function111 = function5;
                            Function2<? super Composer, ? super Integer, Unit> function112 = function6;
                            boolean z11 = z2;
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(70219170, i15, -1, "androidx.compose.material3.DropdownMenuItem (Menu.kt:339)");
                            }
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1238834984, "CC(remember):Menu.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = new Function1() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda29
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return MenuKt.DropdownMenuItem$lambda$0$0((SemanticsPropertyReceiver) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            composer2 = composerStartRestartGroup;
                            int i113 = i15 << 3;
                            DropdownMenuItemContent(false, function0, function2, SemanticsModifierKt.semantics$default(modifier2, false, (Function1) objRememberedValue, 1, null), function111, null, function112, z11, menuItemColorsItemColors, MenuDefaults.INSTANCE.itemShapes(shape, null, composerStartRestartGroup, ((i15 >> 6) & 14) | 384, 2), paddingValues3, mutableInteractionSource3, composer2, (i113 & 112) | 196614 | (i113 & 896) | (57344 & i15) | (3670016 & i113) | (29360128 & i113) | (i113 & 234881024), (i15 >> 24) & 126);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier3 = modifier2;
                            function7 = function111;
                            function8 = function112;
                            z4 = z11;
                            menuItemColors2 = menuItemColorsItemColors;
                            paddingValues2 = paddingValues3;
                            mutableInteractionSource2 = mutableInteractionSource3;
                        } else {
                            composer2 = composerStartRestartGroup;
                            composer2.skipToGroupEnd();
                            menuItemColors2 = menuItemColors;
                            mutableInteractionSource2 = mutableInteractionSource;
                            modifier3 = modifier2;
                            function7 = function5;
                            function8 = function6;
                            z4 = z2;
                            paddingValues2 = paddingValues;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda30
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return MenuKt.DropdownMenuItem$lambda$1(function0, function2, shape, modifier3, function7, function8, z4, menuItemColors2, paddingValues2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                        }
                    }
                    i3 |= 805306368;
                    i14 = i3;
                    if ((i3 & 306783379) != 306783378) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z3, i14 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "336@16371L12");
                        if ((i & 1) != 0) {
                            if (i16 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                function5 = null;
                            }
                            if (i6 != 0) {
                                function6 = null;
                            }
                            if (i8 != 0) {
                                z2 = true;
                            }
                            if ((i2 & 128) != 0) {
                                menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                                i15 = i14 & (-29360129);
                            } else {
                                menuItemColorsItemColors = menuItemColors;
                                i15 = i14;
                            }
                            if (i10 != 0) {
                                dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                            } else {
                                dropdownMenuItemContentPadding = paddingValues;
                            }
                            if (i12 != 0) {
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            paddingValues3 = dropdownMenuItemContentPadding;
                        } else {
                            if (i16 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                function5 = null;
                            }
                            if (i6 != 0) {
                                function6 = null;
                            }
                            if (i8 != 0) {
                                z2 = true;
                            }
                            if ((i2 & 128) != 0) {
                                menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                                i15 = i14 & (-29360129);
                            } else {
                                menuItemColorsItemColors = menuItemColors;
                                i15 = i14;
                            }
                            if (i10 != 0) {
                                dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                            } else {
                                dropdownMenuItemContentPadding = paddingValues;
                            }
                            if (i12 != 0) {
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            paddingValues3 = dropdownMenuItemContentPadding;
                        }
                        Function2<? super Composer, ? super Integer, Unit> function113 = function5;
                        Function2<? super Composer, ? super Integer, Unit> function114 = function6;
                        boolean z12 = z2;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(70219170, i15, -1, "androidx.compose.material3.DropdownMenuItem (Menu.kt:339)");
                        }
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1238834984, "CC(remember):Menu.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new Function1() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda29
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return MenuKt.DropdownMenuItem$lambda$0$0((SemanticsPropertyReceiver) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composer2 = composerStartRestartGroup;
                        int i114 = i15 << 3;
                        DropdownMenuItemContent(false, function0, function2, SemanticsModifierKt.semantics$default(modifier2, false, (Function1) objRememberedValue, 1, null), function113, null, function114, z12, menuItemColorsItemColors, MenuDefaults.INSTANCE.itemShapes(shape, null, composerStartRestartGroup, ((i15 >> 6) & 14) | 384, 2), paddingValues3, mutableInteractionSource3, composer2, (i114 & 112) | 196614 | (i114 & 896) | (57344 & i15) | (3670016 & i114) | (29360128 & i114) | (i114 & 234881024), (i15 >> 24) & 126);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier2;
                        function7 = function113;
                        function8 = function114;
                        z4 = z12;
                        menuItemColors2 = menuItemColorsItemColors;
                        paddingValues2 = paddingValues3;
                        mutableInteractionSource2 = mutableInteractionSource3;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        menuItemColors2 = menuItemColors;
                        mutableInteractionSource2 = mutableInteractionSource;
                        modifier3 = modifier2;
                        function7 = function5;
                        function8 = function6;
                        z4 = z2;
                        paddingValues2 = paddingValues;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda30
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return MenuKt.DropdownMenuItem$lambda$1(function0, function2, shape, modifier3, function7, function8, z4, menuItemColors2, paddingValues2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                function6 = function4;
                i8 = i2 & 64;
                if (i8 != 0) {
                    if ((1572864 & i) == 0) {
                        z2 = z;
                        if (composerStartRestartGroup.changed(z2)) {
                            i9 = 1048576;
                        } else {
                            i9 = 524288;
                        }
                        i3 |= i9;
                    }
                    if ((i & 12582912) != 0) {
                        i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(menuItemColors)) ? 4194304 : 8388608;
                    }
                    i10 = i2 & 256;
                    if (i10 != 0) {
                        if ((i & 100663296) == 0) {
                            if (composerStartRestartGroup.changed(paddingValues)) {
                                i11 = 67108864;
                            } else {
                                i11 = 33554432;
                            }
                            i3 |= i11;
                        }
                        i12 = i2 & 512;
                        if (i12 != 0) {
                            if ((i & 805306368) == 0) {
                                if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                                    i13 = C.BUFFER_FLAG_LAST_SAMPLE;
                                } else {
                                    i13 = 268435456;
                                }
                                i3 |= i13;
                            }
                            i14 = i3;
                            if ((i3 & 306783379) != 306783378) {
                                z3 = true;
                            } else {
                                z3 = false;
                            }
                            if (composerStartRestartGroup.shouldExecute(z3, i14 & 1)) {
                                composerStartRestartGroup.startDefaults();
                                ComposerKt.sourceInformation(composerStartRestartGroup, "336@16371L12");
                                if ((i & 1) != 0) {
                                    if (i16 != 0) {
                                        modifier2 = Modifier.INSTANCE;
                                    }
                                    if (i4 != 0) {
                                        function5 = null;
                                    }
                                    if (i6 != 0) {
                                        function6 = null;
                                    }
                                    if (i8 != 0) {
                                        z2 = true;
                                    }
                                    if ((i2 & 128) != 0) {
                                        menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                                        i15 = i14 & (-29360129);
                                    } else {
                                        menuItemColorsItemColors = menuItemColors;
                                        i15 = i14;
                                    }
                                    if (i10 != 0) {
                                        dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                                    } else {
                                        dropdownMenuItemContentPadding = paddingValues;
                                    }
                                    if (i12 != 0) {
                                        mutableInteractionSource3 = null;
                                    } else {
                                        mutableInteractionSource3 = mutableInteractionSource;
                                    }
                                    paddingValues3 = dropdownMenuItemContentPadding;
                                } else {
                                    if (i16 != 0) {
                                        modifier2 = Modifier.INSTANCE;
                                    }
                                    if (i4 != 0) {
                                        function5 = null;
                                    }
                                    if (i6 != 0) {
                                        function6 = null;
                                    }
                                    if (i8 != 0) {
                                        z2 = true;
                                    }
                                    if ((i2 & 128) != 0) {
                                        menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                                        i15 = i14 & (-29360129);
                                    } else {
                                        menuItemColorsItemColors = menuItemColors;
                                        i15 = i14;
                                    }
                                    if (i10 != 0) {
                                        dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                                    } else {
                                        dropdownMenuItemContentPadding = paddingValues;
                                    }
                                    if (i12 != 0) {
                                        mutableInteractionSource3 = null;
                                    } else {
                                        mutableInteractionSource3 = mutableInteractionSource;
                                    }
                                    paddingValues3 = dropdownMenuItemContentPadding;
                                }
                                Function2<? super Composer, ? super Integer, Unit> function115 = function5;
                                Function2<? super Composer, ? super Integer, Unit> function116 = function6;
                                boolean z13 = z2;
                                composerStartRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(70219170, i15, -1, "androidx.compose.material3.DropdownMenuItem (Menu.kt:339)");
                                }
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1238834984, "CC(remember):Menu.kt#9igjgp");
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue = new Function1() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda29
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj) {
                                            return MenuKt.DropdownMenuItem$lambda$0$0((SemanticsPropertyReceiver) obj);
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                composer2 = composerStartRestartGroup;
                                int i115 = i15 << 3;
                                DropdownMenuItemContent(false, function0, function2, SemanticsModifierKt.semantics$default(modifier2, false, (Function1) objRememberedValue, 1, null), function115, null, function116, z13, menuItemColorsItemColors, MenuDefaults.INSTANCE.itemShapes(shape, null, composerStartRestartGroup, ((i15 >> 6) & 14) | 384, 2), paddingValues3, mutableInteractionSource3, composer2, (i115 & 112) | 196614 | (i115 & 896) | (57344 & i15) | (3670016 & i115) | (29360128 & i115) | (i115 & 234881024), (i15 >> 24) & 126);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                modifier3 = modifier2;
                                function7 = function115;
                                function8 = function116;
                                z4 = z13;
                                menuItemColors2 = menuItemColorsItemColors;
                                paddingValues2 = paddingValues3;
                                mutableInteractionSource2 = mutableInteractionSource3;
                            } else {
                                composer2 = composerStartRestartGroup;
                                composer2.skipToGroupEnd();
                                menuItemColors2 = menuItemColors;
                                mutableInteractionSource2 = mutableInteractionSource;
                                modifier3 = modifier2;
                                function7 = function5;
                                function8 = function6;
                                z4 = z2;
                                paddingValues2 = paddingValues;
                            }
                            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup != null) {
                                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda30
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return MenuKt.DropdownMenuItem$lambda$1(function0, function2, shape, modifier3, function7, function8, z4, menuItemColors2, paddingValues2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                    }
                                });
                            }
                        }
                        i3 |= 805306368;
                        i14 = i3;
                        if ((i3 & 306783379) != 306783378) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        if (composerStartRestartGroup.shouldExecute(z3, i14 & 1)) {
                            composerStartRestartGroup.startDefaults();
                            ComposerKt.sourceInformation(composerStartRestartGroup, "336@16371L12");
                            if ((i & 1) != 0) {
                                if (i16 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                if (i4 != 0) {
                                    function5 = null;
                                }
                                if (i6 != 0) {
                                    function6 = null;
                                }
                                if (i8 != 0) {
                                    z2 = true;
                                }
                                if ((i2 & 128) != 0) {
                                    menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                                    i15 = i14 & (-29360129);
                                } else {
                                    menuItemColorsItemColors = menuItemColors;
                                    i15 = i14;
                                }
                                if (i10 != 0) {
                                    dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                                } else {
                                    dropdownMenuItemContentPadding = paddingValues;
                                }
                                if (i12 != 0) {
                                    mutableInteractionSource3 = null;
                                } else {
                                    mutableInteractionSource3 = mutableInteractionSource;
                                }
                                paddingValues3 = dropdownMenuItemContentPadding;
                            } else {
                                if (i16 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                if (i4 != 0) {
                                    function5 = null;
                                }
                                if (i6 != 0) {
                                    function6 = null;
                                }
                                if (i8 != 0) {
                                    z2 = true;
                                }
                                if ((i2 & 128) != 0) {
                                    menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                                    i15 = i14 & (-29360129);
                                } else {
                                    menuItemColorsItemColors = menuItemColors;
                                    i15 = i14;
                                }
                                if (i10 != 0) {
                                    dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                                } else {
                                    dropdownMenuItemContentPadding = paddingValues;
                                }
                                if (i12 != 0) {
                                    mutableInteractionSource3 = null;
                                } else {
                                    mutableInteractionSource3 = mutableInteractionSource;
                                }
                                paddingValues3 = dropdownMenuItemContentPadding;
                            }
                            Function2<? super Composer, ? super Integer, Unit> function117 = function5;
                            Function2<? super Composer, ? super Integer, Unit> function118 = function6;
                            boolean z14 = z2;
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(70219170, i15, -1, "androidx.compose.material3.DropdownMenuItem (Menu.kt:339)");
                            }
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1238834984, "CC(remember):Menu.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = new Function1() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda29
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return MenuKt.DropdownMenuItem$lambda$0$0((SemanticsPropertyReceiver) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            composer2 = composerStartRestartGroup;
                            int i116 = i15 << 3;
                            DropdownMenuItemContent(false, function0, function2, SemanticsModifierKt.semantics$default(modifier2, false, (Function1) objRememberedValue, 1, null), function117, null, function118, z14, menuItemColorsItemColors, MenuDefaults.INSTANCE.itemShapes(shape, null, composerStartRestartGroup, ((i15 >> 6) & 14) | 384, 2), paddingValues3, mutableInteractionSource3, composer2, (i116 & 112) | 196614 | (i116 & 896) | (57344 & i15) | (3670016 & i116) | (29360128 & i116) | (i116 & 234881024), (i15 >> 24) & 126);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier3 = modifier2;
                            function7 = function117;
                            function8 = function118;
                            z4 = z14;
                            menuItemColors2 = menuItemColorsItemColors;
                            paddingValues2 = paddingValues3;
                            mutableInteractionSource2 = mutableInteractionSource3;
                        } else {
                            composer2 = composerStartRestartGroup;
                            composer2.skipToGroupEnd();
                            menuItemColors2 = menuItemColors;
                            mutableInteractionSource2 = mutableInteractionSource;
                            modifier3 = modifier2;
                            function7 = function5;
                            function8 = function6;
                            z4 = z2;
                            paddingValues2 = paddingValues;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda30
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return MenuKt.DropdownMenuItem$lambda$1(function0, function2, shape, modifier3, function7, function8, z4, menuItemColors2, paddingValues2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                        }
                    }
                    i3 |= 100663296;
                    i12 = i2 & 512;
                    if (i12 != 0) {
                        if ((i & 805306368) == 0) {
                            if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                                i13 = C.BUFFER_FLAG_LAST_SAMPLE;
                            } else {
                                i13 = 268435456;
                            }
                            i3 |= i13;
                        }
                        i14 = i3;
                        if ((i3 & 306783379) != 306783378) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        if (composerStartRestartGroup.shouldExecute(z3, i14 & 1)) {
                            composerStartRestartGroup.startDefaults();
                            ComposerKt.sourceInformation(composerStartRestartGroup, "336@16371L12");
                            if ((i & 1) != 0) {
                                if (i16 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                if (i4 != 0) {
                                    function5 = null;
                                }
                                if (i6 != 0) {
                                    function6 = null;
                                }
                                if (i8 != 0) {
                                    z2 = true;
                                }
                                if ((i2 & 128) != 0) {
                                    menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                                    i15 = i14 & (-29360129);
                                } else {
                                    menuItemColorsItemColors = menuItemColors;
                                    i15 = i14;
                                }
                                if (i10 != 0) {
                                    dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                                } else {
                                    dropdownMenuItemContentPadding = paddingValues;
                                }
                                if (i12 != 0) {
                                    mutableInteractionSource3 = null;
                                } else {
                                    mutableInteractionSource3 = mutableInteractionSource;
                                }
                                paddingValues3 = dropdownMenuItemContentPadding;
                            } else {
                                if (i16 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                if (i4 != 0) {
                                    function5 = null;
                                }
                                if (i6 != 0) {
                                    function6 = null;
                                }
                                if (i8 != 0) {
                                    z2 = true;
                                }
                                if ((i2 & 128) != 0) {
                                    menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                                    i15 = i14 & (-29360129);
                                } else {
                                    menuItemColorsItemColors = menuItemColors;
                                    i15 = i14;
                                }
                                if (i10 != 0) {
                                    dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                                } else {
                                    dropdownMenuItemContentPadding = paddingValues;
                                }
                                if (i12 != 0) {
                                    mutableInteractionSource3 = null;
                                } else {
                                    mutableInteractionSource3 = mutableInteractionSource;
                                }
                                paddingValues3 = dropdownMenuItemContentPadding;
                            }
                            Function2<? super Composer, ? super Integer, Unit> function119 = function5;
                            Function2<? super Composer, ? super Integer, Unit> function1110 = function6;
                            boolean z15 = z2;
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(70219170, i15, -1, "androidx.compose.material3.DropdownMenuItem (Menu.kt:339)");
                            }
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1238834984, "CC(remember):Menu.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = new Function1() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda29
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return MenuKt.DropdownMenuItem$lambda$0$0((SemanticsPropertyReceiver) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            composer2 = composerStartRestartGroup;
                            int i117 = i15 << 3;
                            DropdownMenuItemContent(false, function0, function2, SemanticsModifierKt.semantics$default(modifier2, false, (Function1) objRememberedValue, 1, null), function119, null, function1110, z15, menuItemColorsItemColors, MenuDefaults.INSTANCE.itemShapes(shape, null, composerStartRestartGroup, ((i15 >> 6) & 14) | 384, 2), paddingValues3, mutableInteractionSource3, composer2, (i117 & 112) | 196614 | (i117 & 896) | (57344 & i15) | (3670016 & i117) | (29360128 & i117) | (i117 & 234881024), (i15 >> 24) & 126);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier3 = modifier2;
                            function7 = function119;
                            function8 = function1110;
                            z4 = z15;
                            menuItemColors2 = menuItemColorsItemColors;
                            paddingValues2 = paddingValues3;
                            mutableInteractionSource2 = mutableInteractionSource3;
                        } else {
                            composer2 = composerStartRestartGroup;
                            composer2.skipToGroupEnd();
                            menuItemColors2 = menuItemColors;
                            mutableInteractionSource2 = mutableInteractionSource;
                            modifier3 = modifier2;
                            function7 = function5;
                            function8 = function6;
                            z4 = z2;
                            paddingValues2 = paddingValues;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda30
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return MenuKt.DropdownMenuItem$lambda$1(function0, function2, shape, modifier3, function7, function8, z4, menuItemColors2, paddingValues2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                        }
                    }
                    i3 |= 805306368;
                    i14 = i3;
                    if ((i3 & 306783379) != 306783378) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z3, i14 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "336@16371L12");
                        if ((i & 1) != 0) {
                            if (i16 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                function5 = null;
                            }
                            if (i6 != 0) {
                                function6 = null;
                            }
                            if (i8 != 0) {
                                z2 = true;
                            }
                            if ((i2 & 128) != 0) {
                                menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                                i15 = i14 & (-29360129);
                            } else {
                                menuItemColorsItemColors = menuItemColors;
                                i15 = i14;
                            }
                            if (i10 != 0) {
                                dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                            } else {
                                dropdownMenuItemContentPadding = paddingValues;
                            }
                            if (i12 != 0) {
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            paddingValues3 = dropdownMenuItemContentPadding;
                        } else {
                            if (i16 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                function5 = null;
                            }
                            if (i6 != 0) {
                                function6 = null;
                            }
                            if (i8 != 0) {
                                z2 = true;
                            }
                            if ((i2 & 128) != 0) {
                                menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                                i15 = i14 & (-29360129);
                            } else {
                                menuItemColorsItemColors = menuItemColors;
                                i15 = i14;
                            }
                            if (i10 != 0) {
                                dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                            } else {
                                dropdownMenuItemContentPadding = paddingValues;
                            }
                            if (i12 != 0) {
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            paddingValues3 = dropdownMenuItemContentPadding;
                        }
                        Function2<? super Composer, ? super Integer, Unit> function1111 = function5;
                        Function2<? super Composer, ? super Integer, Unit> function1112 = function6;
                        boolean z16 = z2;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(70219170, i15, -1, "androidx.compose.material3.DropdownMenuItem (Menu.kt:339)");
                        }
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1238834984, "CC(remember):Menu.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new Function1() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda29
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return MenuKt.DropdownMenuItem$lambda$0$0((SemanticsPropertyReceiver) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composer2 = composerStartRestartGroup;
                        int i118 = i15 << 3;
                        DropdownMenuItemContent(false, function0, function2, SemanticsModifierKt.semantics$default(modifier2, false, (Function1) objRememberedValue, 1, null), function1111, null, function1112, z16, menuItemColorsItemColors, MenuDefaults.INSTANCE.itemShapes(shape, null, composerStartRestartGroup, ((i15 >> 6) & 14) | 384, 2), paddingValues3, mutableInteractionSource3, composer2, (i118 & 112) | 196614 | (i118 & 896) | (57344 & i15) | (3670016 & i118) | (29360128 & i118) | (i118 & 234881024), (i15 >> 24) & 126);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier2;
                        function7 = function1111;
                        function8 = function1112;
                        z4 = z16;
                        menuItemColors2 = menuItemColorsItemColors;
                        paddingValues2 = paddingValues3;
                        mutableInteractionSource2 = mutableInteractionSource3;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        menuItemColors2 = menuItemColors;
                        mutableInteractionSource2 = mutableInteractionSource;
                        modifier3 = modifier2;
                        function7 = function5;
                        function8 = function6;
                        z4 = z2;
                        paddingValues2 = paddingValues;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda30
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return MenuKt.DropdownMenuItem$lambda$1(function0, function2, shape, modifier3, function7, function8, z4, menuItemColors2, paddingValues2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= 1572864;
                z2 = z;
                if ((i & 12582912) != 0) {
                    i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(menuItemColors)) ? 4194304 : 8388608;
                }
                i10 = i2 & 256;
                if (i10 != 0) {
                    if ((i & 100663296) == 0) {
                        if (composerStartRestartGroup.changed(paddingValues)) {
                            i11 = 67108864;
                        } else {
                            i11 = 33554432;
                        }
                        i3 |= i11;
                    }
                    i12 = i2 & 512;
                    if (i12 != 0) {
                        if ((i & 805306368) == 0) {
                            if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                                i13 = C.BUFFER_FLAG_LAST_SAMPLE;
                            } else {
                                i13 = 268435456;
                            }
                            i3 |= i13;
                        }
                        i14 = i3;
                        if ((i3 & 306783379) != 306783378) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        if (composerStartRestartGroup.shouldExecute(z3, i14 & 1)) {
                            composerStartRestartGroup.startDefaults();
                            ComposerKt.sourceInformation(composerStartRestartGroup, "336@16371L12");
                            if ((i & 1) != 0) {
                                if (i16 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                if (i4 != 0) {
                                    function5 = null;
                                }
                                if (i6 != 0) {
                                    function6 = null;
                                }
                                if (i8 != 0) {
                                    z2 = true;
                                }
                                if ((i2 & 128) != 0) {
                                    menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                                    i15 = i14 & (-29360129);
                                } else {
                                    menuItemColorsItemColors = menuItemColors;
                                    i15 = i14;
                                }
                                if (i10 != 0) {
                                    dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                                } else {
                                    dropdownMenuItemContentPadding = paddingValues;
                                }
                                if (i12 != 0) {
                                    mutableInteractionSource3 = null;
                                } else {
                                    mutableInteractionSource3 = mutableInteractionSource;
                                }
                                paddingValues3 = dropdownMenuItemContentPadding;
                            } else {
                                if (i16 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                if (i4 != 0) {
                                    function5 = null;
                                }
                                if (i6 != 0) {
                                    function6 = null;
                                }
                                if (i8 != 0) {
                                    z2 = true;
                                }
                                if ((i2 & 128) != 0) {
                                    menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                                    i15 = i14 & (-29360129);
                                } else {
                                    menuItemColorsItemColors = menuItemColors;
                                    i15 = i14;
                                }
                                if (i10 != 0) {
                                    dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                                } else {
                                    dropdownMenuItemContentPadding = paddingValues;
                                }
                                if (i12 != 0) {
                                    mutableInteractionSource3 = null;
                                } else {
                                    mutableInteractionSource3 = mutableInteractionSource;
                                }
                                paddingValues3 = dropdownMenuItemContentPadding;
                            }
                            Function2<? super Composer, ? super Integer, Unit> function1113 = function5;
                            Function2<? super Composer, ? super Integer, Unit> function1114 = function6;
                            boolean z17 = z2;
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(70219170, i15, -1, "androidx.compose.material3.DropdownMenuItem (Menu.kt:339)");
                            }
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1238834984, "CC(remember):Menu.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = new Function1() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda29
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return MenuKt.DropdownMenuItem$lambda$0$0((SemanticsPropertyReceiver) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            composer2 = composerStartRestartGroup;
                            int i119 = i15 << 3;
                            DropdownMenuItemContent(false, function0, function2, SemanticsModifierKt.semantics$default(modifier2, false, (Function1) objRememberedValue, 1, null), function1113, null, function1114, z17, menuItemColorsItemColors, MenuDefaults.INSTANCE.itemShapes(shape, null, composerStartRestartGroup, ((i15 >> 6) & 14) | 384, 2), paddingValues3, mutableInteractionSource3, composer2, (i119 & 112) | 196614 | (i119 & 896) | (57344 & i15) | (3670016 & i119) | (29360128 & i119) | (i119 & 234881024), (i15 >> 24) & 126);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier3 = modifier2;
                            function7 = function1113;
                            function8 = function1114;
                            z4 = z17;
                            menuItemColors2 = menuItemColorsItemColors;
                            paddingValues2 = paddingValues3;
                            mutableInteractionSource2 = mutableInteractionSource3;
                        } else {
                            composer2 = composerStartRestartGroup;
                            composer2.skipToGroupEnd();
                            menuItemColors2 = menuItemColors;
                            mutableInteractionSource2 = mutableInteractionSource;
                            modifier3 = modifier2;
                            function7 = function5;
                            function8 = function6;
                            z4 = z2;
                            paddingValues2 = paddingValues;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda30
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return MenuKt.DropdownMenuItem$lambda$1(function0, function2, shape, modifier3, function7, function8, z4, menuItemColors2, paddingValues2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                        }
                    }
                    i3 |= 805306368;
                    i14 = i3;
                    if ((i3 & 306783379) != 306783378) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z3, i14 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "336@16371L12");
                        if ((i & 1) != 0) {
                            if (i16 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                function5 = null;
                            }
                            if (i6 != 0) {
                                function6 = null;
                            }
                            if (i8 != 0) {
                                z2 = true;
                            }
                            if ((i2 & 128) != 0) {
                                menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                                i15 = i14 & (-29360129);
                            } else {
                                menuItemColorsItemColors = menuItemColors;
                                i15 = i14;
                            }
                            if (i10 != 0) {
                                dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                            } else {
                                dropdownMenuItemContentPadding = paddingValues;
                            }
                            if (i12 != 0) {
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            paddingValues3 = dropdownMenuItemContentPadding;
                        } else {
                            if (i16 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                function5 = null;
                            }
                            if (i6 != 0) {
                                function6 = null;
                            }
                            if (i8 != 0) {
                                z2 = true;
                            }
                            if ((i2 & 128) != 0) {
                                menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                                i15 = i14 & (-29360129);
                            } else {
                                menuItemColorsItemColors = menuItemColors;
                                i15 = i14;
                            }
                            if (i10 != 0) {
                                dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                            } else {
                                dropdownMenuItemContentPadding = paddingValues;
                            }
                            if (i12 != 0) {
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            paddingValues3 = dropdownMenuItemContentPadding;
                        }
                        Function2<? super Composer, ? super Integer, Unit> function1115 = function5;
                        Function2<? super Composer, ? super Integer, Unit> function1116 = function6;
                        boolean z18 = z2;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(70219170, i15, -1, "androidx.compose.material3.DropdownMenuItem (Menu.kt:339)");
                        }
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1238834984, "CC(remember):Menu.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new Function1() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda29
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return MenuKt.DropdownMenuItem$lambda$0$0((SemanticsPropertyReceiver) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composer2 = composerStartRestartGroup;
                        int i1110 = i15 << 3;
                        DropdownMenuItemContent(false, function0, function2, SemanticsModifierKt.semantics$default(modifier2, false, (Function1) objRememberedValue, 1, null), function1115, null, function1116, z18, menuItemColorsItemColors, MenuDefaults.INSTANCE.itemShapes(shape, null, composerStartRestartGroup, ((i15 >> 6) & 14) | 384, 2), paddingValues3, mutableInteractionSource3, composer2, (i1110 & 112) | 196614 | (i1110 & 896) | (57344 & i15) | (3670016 & i1110) | (29360128 & i1110) | (i1110 & 234881024), (i15 >> 24) & 126);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier2;
                        function7 = function1115;
                        function8 = function1116;
                        z4 = z18;
                        menuItemColors2 = menuItemColorsItemColors;
                        paddingValues2 = paddingValues3;
                        mutableInteractionSource2 = mutableInteractionSource3;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        menuItemColors2 = menuItemColors;
                        mutableInteractionSource2 = mutableInteractionSource;
                        modifier3 = modifier2;
                        function7 = function5;
                        function8 = function6;
                        z4 = z2;
                        paddingValues2 = paddingValues;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda30
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return MenuKt.DropdownMenuItem$lambda$1(function0, function2, shape, modifier3, function7, function8, z4, menuItemColors2, paddingValues2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= 100663296;
                i12 = i2 & 512;
                if (i12 != 0) {
                    if ((i & 805306368) == 0) {
                        if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                            i13 = C.BUFFER_FLAG_LAST_SAMPLE;
                        } else {
                            i13 = 268435456;
                        }
                        i3 |= i13;
                    }
                    i14 = i3;
                    if ((i3 & 306783379) != 306783378) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z3, i14 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "336@16371L12");
                        if ((i & 1) != 0) {
                            if (i16 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                function5 = null;
                            }
                            if (i6 != 0) {
                                function6 = null;
                            }
                            if (i8 != 0) {
                                z2 = true;
                            }
                            if ((i2 & 128) != 0) {
                                menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                                i15 = i14 & (-29360129);
                            } else {
                                menuItemColorsItemColors = menuItemColors;
                                i15 = i14;
                            }
                            if (i10 != 0) {
                                dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                            } else {
                                dropdownMenuItemContentPadding = paddingValues;
                            }
                            if (i12 != 0) {
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            paddingValues3 = dropdownMenuItemContentPadding;
                        } else {
                            if (i16 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                function5 = null;
                            }
                            if (i6 != 0) {
                                function6 = null;
                            }
                            if (i8 != 0) {
                                z2 = true;
                            }
                            if ((i2 & 128) != 0) {
                                menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                                i15 = i14 & (-29360129);
                            } else {
                                menuItemColorsItemColors = menuItemColors;
                                i15 = i14;
                            }
                            if (i10 != 0) {
                                dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                            } else {
                                dropdownMenuItemContentPadding = paddingValues;
                            }
                            if (i12 != 0) {
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            paddingValues3 = dropdownMenuItemContentPadding;
                        }
                        Function2<? super Composer, ? super Integer, Unit> function1117 = function5;
                        Function2<? super Composer, ? super Integer, Unit> function1118 = function6;
                        boolean z19 = z2;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(70219170, i15, -1, "androidx.compose.material3.DropdownMenuItem (Menu.kt:339)");
                        }
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1238834984, "CC(remember):Menu.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new Function1() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda29
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return MenuKt.DropdownMenuItem$lambda$0$0((SemanticsPropertyReceiver) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composer2 = composerStartRestartGroup;
                        int i1111 = i15 << 3;
                        DropdownMenuItemContent(false, function0, function2, SemanticsModifierKt.semantics$default(modifier2, false, (Function1) objRememberedValue, 1, null), function1117, null, function1118, z19, menuItemColorsItemColors, MenuDefaults.INSTANCE.itemShapes(shape, null, composerStartRestartGroup, ((i15 >> 6) & 14) | 384, 2), paddingValues3, mutableInteractionSource3, composer2, (i1111 & 112) | 196614 | (i1111 & 896) | (57344 & i15) | (3670016 & i1111) | (29360128 & i1111) | (i1111 & 234881024), (i15 >> 24) & 126);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier2;
                        function7 = function1117;
                        function8 = function1118;
                        z4 = z19;
                        menuItemColors2 = menuItemColorsItemColors;
                        paddingValues2 = paddingValues3;
                        mutableInteractionSource2 = mutableInteractionSource3;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        menuItemColors2 = menuItemColors;
                        mutableInteractionSource2 = mutableInteractionSource;
                        modifier3 = modifier2;
                        function7 = function5;
                        function8 = function6;
                        z4 = z2;
                        paddingValues2 = paddingValues;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda30
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return MenuKt.DropdownMenuItem$lambda$1(function0, function2, shape, modifier3, function7, function8, z4, menuItemColors2, paddingValues2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= 805306368;
                i14 = i3;
                if ((i3 & 306783379) != 306783378) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i14 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "336@16371L12");
                    if ((i & 1) != 0) {
                        if (i16 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            function5 = null;
                        }
                        if (i6 != 0) {
                            function6 = null;
                        }
                        if (i8 != 0) {
                            z2 = true;
                        }
                        if ((i2 & 128) != 0) {
                            menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                            i15 = i14 & (-29360129);
                        } else {
                            menuItemColorsItemColors = menuItemColors;
                            i15 = i14;
                        }
                        if (i10 != 0) {
                            dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                        } else {
                            dropdownMenuItemContentPadding = paddingValues;
                        }
                        if (i12 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        paddingValues3 = dropdownMenuItemContentPadding;
                    } else {
                        if (i16 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            function5 = null;
                        }
                        if (i6 != 0) {
                            function6 = null;
                        }
                        if (i8 != 0) {
                            z2 = true;
                        }
                        if ((i2 & 128) != 0) {
                            menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                            i15 = i14 & (-29360129);
                        } else {
                            menuItemColorsItemColors = menuItemColors;
                            i15 = i14;
                        }
                        if (i10 != 0) {
                            dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                        } else {
                            dropdownMenuItemContentPadding = paddingValues;
                        }
                        if (i12 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        paddingValues3 = dropdownMenuItemContentPadding;
                    }
                    Function2<? super Composer, ? super Integer, Unit> function1119 = function5;
                    Function2<? super Composer, ? super Integer, Unit> function11110 = function6;
                    boolean z110 = z2;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(70219170, i15, -1, "androidx.compose.material3.DropdownMenuItem (Menu.kt:339)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1238834984, "CC(remember):Menu.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new Function1() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda29
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return MenuKt.DropdownMenuItem$lambda$0$0((SemanticsPropertyReceiver) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composer2 = composerStartRestartGroup;
                    int i1112 = i15 << 3;
                    DropdownMenuItemContent(false, function0, function2, SemanticsModifierKt.semantics$default(modifier2, false, (Function1) objRememberedValue, 1, null), function1119, null, function11110, z110, menuItemColorsItemColors, MenuDefaults.INSTANCE.itemShapes(shape, null, composerStartRestartGroup, ((i15 >> 6) & 14) | 384, 2), paddingValues3, mutableInteractionSource3, composer2, (i1112 & 112) | 196614 | (i1112 & 896) | (57344 & i15) | (3670016 & i1112) | (29360128 & i1112) | (i1112 & 234881024), (i15 >> 24) & 126);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                    function7 = function1119;
                    function8 = function11110;
                    z4 = z110;
                    menuItemColors2 = menuItemColorsItemColors;
                    paddingValues2 = paddingValues3;
                    mutableInteractionSource2 = mutableInteractionSource3;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    menuItemColors2 = menuItemColors;
                    mutableInteractionSource2 = mutableInteractionSource;
                    modifier3 = modifier2;
                    function7 = function5;
                    function8 = function6;
                    z4 = z2;
                    paddingValues2 = paddingValues;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda30
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return MenuKt.DropdownMenuItem$lambda$1(function0, function2, shape, modifier3, function7, function8, z4, menuItemColors2, paddingValues2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
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
                i8 = i2 & 64;
                if (i8 != 0) {
                    if ((1572864 & i) == 0) {
                        z2 = z;
                        if (composerStartRestartGroup.changed(z2)) {
                            i9 = 1048576;
                        } else {
                            i9 = 524288;
                        }
                        i3 |= i9;
                    }
                    if ((i & 12582912) != 0) {
                        i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(menuItemColors)) ? 4194304 : 8388608;
                    }
                    i10 = i2 & 256;
                    if (i10 != 0) {
                        if ((i & 100663296) == 0) {
                            if (composerStartRestartGroup.changed(paddingValues)) {
                                i11 = 67108864;
                            } else {
                                i11 = 33554432;
                            }
                            i3 |= i11;
                        }
                        i12 = i2 & 512;
                        if (i12 != 0) {
                            if ((i & 805306368) == 0) {
                                if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                                    i13 = C.BUFFER_FLAG_LAST_SAMPLE;
                                } else {
                                    i13 = 268435456;
                                }
                                i3 |= i13;
                            }
                            i14 = i3;
                            if ((i3 & 306783379) != 306783378) {
                                z3 = true;
                            } else {
                                z3 = false;
                            }
                            if (composerStartRestartGroup.shouldExecute(z3, i14 & 1)) {
                                composerStartRestartGroup.startDefaults();
                                ComposerKt.sourceInformation(composerStartRestartGroup, "336@16371L12");
                                if ((i & 1) != 0) {
                                    if (i16 != 0) {
                                        modifier2 = Modifier.INSTANCE;
                                    }
                                    if (i4 != 0) {
                                        function5 = null;
                                    }
                                    if (i6 != 0) {
                                        function6 = null;
                                    }
                                    if (i8 != 0) {
                                        z2 = true;
                                    }
                                    if ((i2 & 128) != 0) {
                                        menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                                        i15 = i14 & (-29360129);
                                    } else {
                                        menuItemColorsItemColors = menuItemColors;
                                        i15 = i14;
                                    }
                                    if (i10 != 0) {
                                        dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                                    } else {
                                        dropdownMenuItemContentPadding = paddingValues;
                                    }
                                    if (i12 != 0) {
                                        mutableInteractionSource3 = null;
                                    } else {
                                        mutableInteractionSource3 = mutableInteractionSource;
                                    }
                                    paddingValues3 = dropdownMenuItemContentPadding;
                                } else {
                                    if (i16 != 0) {
                                        modifier2 = Modifier.INSTANCE;
                                    }
                                    if (i4 != 0) {
                                        function5 = null;
                                    }
                                    if (i6 != 0) {
                                        function6 = null;
                                    }
                                    if (i8 != 0) {
                                        z2 = true;
                                    }
                                    if ((i2 & 128) != 0) {
                                        menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                                        i15 = i14 & (-29360129);
                                    } else {
                                        menuItemColorsItemColors = menuItemColors;
                                        i15 = i14;
                                    }
                                    if (i10 != 0) {
                                        dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                                    } else {
                                        dropdownMenuItemContentPadding = paddingValues;
                                    }
                                    if (i12 != 0) {
                                        mutableInteractionSource3 = null;
                                    } else {
                                        mutableInteractionSource3 = mutableInteractionSource;
                                    }
                                    paddingValues3 = dropdownMenuItemContentPadding;
                                }
                                Function2<? super Composer, ? super Integer, Unit> function11111 = function5;
                                Function2<? super Composer, ? super Integer, Unit> function11112 = function6;
                                boolean z111 = z2;
                                composerStartRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(70219170, i15, -1, "androidx.compose.material3.DropdownMenuItem (Menu.kt:339)");
                                }
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1238834984, "CC(remember):Menu.kt#9igjgp");
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue = new Function1() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda29
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj) {
                                            return MenuKt.DropdownMenuItem$lambda$0$0((SemanticsPropertyReceiver) obj);
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                composer2 = composerStartRestartGroup;
                                int i1113 = i15 << 3;
                                DropdownMenuItemContent(false, function0, function2, SemanticsModifierKt.semantics$default(modifier2, false, (Function1) objRememberedValue, 1, null), function11111, null, function11112, z111, menuItemColorsItemColors, MenuDefaults.INSTANCE.itemShapes(shape, null, composerStartRestartGroup, ((i15 >> 6) & 14) | 384, 2), paddingValues3, mutableInteractionSource3, composer2, (i1113 & 112) | 196614 | (i1113 & 896) | (57344 & i15) | (3670016 & i1113) | (29360128 & i1113) | (i1113 & 234881024), (i15 >> 24) & 126);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                modifier3 = modifier2;
                                function7 = function11111;
                                function8 = function11112;
                                z4 = z111;
                                menuItemColors2 = menuItemColorsItemColors;
                                paddingValues2 = paddingValues3;
                                mutableInteractionSource2 = mutableInteractionSource3;
                            } else {
                                composer2 = composerStartRestartGroup;
                                composer2.skipToGroupEnd();
                                menuItemColors2 = menuItemColors;
                                mutableInteractionSource2 = mutableInteractionSource;
                                modifier3 = modifier2;
                                function7 = function5;
                                function8 = function6;
                                z4 = z2;
                                paddingValues2 = paddingValues;
                            }
                            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup != null) {
                                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda30
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return MenuKt.DropdownMenuItem$lambda$1(function0, function2, shape, modifier3, function7, function8, z4, menuItemColors2, paddingValues2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                    }
                                });
                            }
                        }
                        i3 |= 805306368;
                        i14 = i3;
                        if ((i3 & 306783379) != 306783378) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        if (composerStartRestartGroup.shouldExecute(z3, i14 & 1)) {
                            composerStartRestartGroup.startDefaults();
                            ComposerKt.sourceInformation(composerStartRestartGroup, "336@16371L12");
                            if ((i & 1) != 0) {
                                if (i16 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                if (i4 != 0) {
                                    function5 = null;
                                }
                                if (i6 != 0) {
                                    function6 = null;
                                }
                                if (i8 != 0) {
                                    z2 = true;
                                }
                                if ((i2 & 128) != 0) {
                                    menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                                    i15 = i14 & (-29360129);
                                } else {
                                    menuItemColorsItemColors = menuItemColors;
                                    i15 = i14;
                                }
                                if (i10 != 0) {
                                    dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                                } else {
                                    dropdownMenuItemContentPadding = paddingValues;
                                }
                                if (i12 != 0) {
                                    mutableInteractionSource3 = null;
                                } else {
                                    mutableInteractionSource3 = mutableInteractionSource;
                                }
                                paddingValues3 = dropdownMenuItemContentPadding;
                            } else {
                                if (i16 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                if (i4 != 0) {
                                    function5 = null;
                                }
                                if (i6 != 0) {
                                    function6 = null;
                                }
                                if (i8 != 0) {
                                    z2 = true;
                                }
                                if ((i2 & 128) != 0) {
                                    menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                                    i15 = i14 & (-29360129);
                                } else {
                                    menuItemColorsItemColors = menuItemColors;
                                    i15 = i14;
                                }
                                if (i10 != 0) {
                                    dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                                } else {
                                    dropdownMenuItemContentPadding = paddingValues;
                                }
                                if (i12 != 0) {
                                    mutableInteractionSource3 = null;
                                } else {
                                    mutableInteractionSource3 = mutableInteractionSource;
                                }
                                paddingValues3 = dropdownMenuItemContentPadding;
                            }
                            Function2<? super Composer, ? super Integer, Unit> function11113 = function5;
                            Function2<? super Composer, ? super Integer, Unit> function11114 = function6;
                            boolean z112 = z2;
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(70219170, i15, -1, "androidx.compose.material3.DropdownMenuItem (Menu.kt:339)");
                            }
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1238834984, "CC(remember):Menu.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = new Function1() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda29
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return MenuKt.DropdownMenuItem$lambda$0$0((SemanticsPropertyReceiver) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            composer2 = composerStartRestartGroup;
                            int i1114 = i15 << 3;
                            DropdownMenuItemContent(false, function0, function2, SemanticsModifierKt.semantics$default(modifier2, false, (Function1) objRememberedValue, 1, null), function11113, null, function11114, z112, menuItemColorsItemColors, MenuDefaults.INSTANCE.itemShapes(shape, null, composerStartRestartGroup, ((i15 >> 6) & 14) | 384, 2), paddingValues3, mutableInteractionSource3, composer2, (i1114 & 112) | 196614 | (i1114 & 896) | (57344 & i15) | (3670016 & i1114) | (29360128 & i1114) | (i1114 & 234881024), (i15 >> 24) & 126);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier3 = modifier2;
                            function7 = function11113;
                            function8 = function11114;
                            z4 = z112;
                            menuItemColors2 = menuItemColorsItemColors;
                            paddingValues2 = paddingValues3;
                            mutableInteractionSource2 = mutableInteractionSource3;
                        } else {
                            composer2 = composerStartRestartGroup;
                            composer2.skipToGroupEnd();
                            menuItemColors2 = menuItemColors;
                            mutableInteractionSource2 = mutableInteractionSource;
                            modifier3 = modifier2;
                            function7 = function5;
                            function8 = function6;
                            z4 = z2;
                            paddingValues2 = paddingValues;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda30
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return MenuKt.DropdownMenuItem$lambda$1(function0, function2, shape, modifier3, function7, function8, z4, menuItemColors2, paddingValues2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                        }
                    }
                    i3 |= 100663296;
                    i12 = i2 & 512;
                    if (i12 != 0) {
                        if ((i & 805306368) == 0) {
                            if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                                i13 = C.BUFFER_FLAG_LAST_SAMPLE;
                            } else {
                                i13 = 268435456;
                            }
                            i3 |= i13;
                        }
                        i14 = i3;
                        if ((i3 & 306783379) != 306783378) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        if (composerStartRestartGroup.shouldExecute(z3, i14 & 1)) {
                            composerStartRestartGroup.startDefaults();
                            ComposerKt.sourceInformation(composerStartRestartGroup, "336@16371L12");
                            if ((i & 1) != 0) {
                                if (i16 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                if (i4 != 0) {
                                    function5 = null;
                                }
                                if (i6 != 0) {
                                    function6 = null;
                                }
                                if (i8 != 0) {
                                    z2 = true;
                                }
                                if ((i2 & 128) != 0) {
                                    menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                                    i15 = i14 & (-29360129);
                                } else {
                                    menuItemColorsItemColors = menuItemColors;
                                    i15 = i14;
                                }
                                if (i10 != 0) {
                                    dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                                } else {
                                    dropdownMenuItemContentPadding = paddingValues;
                                }
                                if (i12 != 0) {
                                    mutableInteractionSource3 = null;
                                } else {
                                    mutableInteractionSource3 = mutableInteractionSource;
                                }
                                paddingValues3 = dropdownMenuItemContentPadding;
                            } else {
                                if (i16 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                if (i4 != 0) {
                                    function5 = null;
                                }
                                if (i6 != 0) {
                                    function6 = null;
                                }
                                if (i8 != 0) {
                                    z2 = true;
                                }
                                if ((i2 & 128) != 0) {
                                    menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                                    i15 = i14 & (-29360129);
                                } else {
                                    menuItemColorsItemColors = menuItemColors;
                                    i15 = i14;
                                }
                                if (i10 != 0) {
                                    dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                                } else {
                                    dropdownMenuItemContentPadding = paddingValues;
                                }
                                if (i12 != 0) {
                                    mutableInteractionSource3 = null;
                                } else {
                                    mutableInteractionSource3 = mutableInteractionSource;
                                }
                                paddingValues3 = dropdownMenuItemContentPadding;
                            }
                            Function2<? super Composer, ? super Integer, Unit> function11115 = function5;
                            Function2<? super Composer, ? super Integer, Unit> function11116 = function6;
                            boolean z113 = z2;
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(70219170, i15, -1, "androidx.compose.material3.DropdownMenuItem (Menu.kt:339)");
                            }
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1238834984, "CC(remember):Menu.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = new Function1() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda29
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return MenuKt.DropdownMenuItem$lambda$0$0((SemanticsPropertyReceiver) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            composer2 = composerStartRestartGroup;
                            int i1115 = i15 << 3;
                            DropdownMenuItemContent(false, function0, function2, SemanticsModifierKt.semantics$default(modifier2, false, (Function1) objRememberedValue, 1, null), function11115, null, function11116, z113, menuItemColorsItemColors, MenuDefaults.INSTANCE.itemShapes(shape, null, composerStartRestartGroup, ((i15 >> 6) & 14) | 384, 2), paddingValues3, mutableInteractionSource3, composer2, (i1115 & 112) | 196614 | (i1115 & 896) | (57344 & i15) | (3670016 & i1115) | (29360128 & i1115) | (i1115 & 234881024), (i15 >> 24) & 126);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier3 = modifier2;
                            function7 = function11115;
                            function8 = function11116;
                            z4 = z113;
                            menuItemColors2 = menuItemColorsItemColors;
                            paddingValues2 = paddingValues3;
                            mutableInteractionSource2 = mutableInteractionSource3;
                        } else {
                            composer2 = composerStartRestartGroup;
                            composer2.skipToGroupEnd();
                            menuItemColors2 = menuItemColors;
                            mutableInteractionSource2 = mutableInteractionSource;
                            modifier3 = modifier2;
                            function7 = function5;
                            function8 = function6;
                            z4 = z2;
                            paddingValues2 = paddingValues;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda30
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return MenuKt.DropdownMenuItem$lambda$1(function0, function2, shape, modifier3, function7, function8, z4, menuItemColors2, paddingValues2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                        }
                    }
                    i3 |= 805306368;
                    i14 = i3;
                    if ((i3 & 306783379) != 306783378) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z3, i14 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "336@16371L12");
                        if ((i & 1) != 0) {
                            if (i16 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                function5 = null;
                            }
                            if (i6 != 0) {
                                function6 = null;
                            }
                            if (i8 != 0) {
                                z2 = true;
                            }
                            if ((i2 & 128) != 0) {
                                menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                                i15 = i14 & (-29360129);
                            } else {
                                menuItemColorsItemColors = menuItemColors;
                                i15 = i14;
                            }
                            if (i10 != 0) {
                                dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                            } else {
                                dropdownMenuItemContentPadding = paddingValues;
                            }
                            if (i12 != 0) {
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            paddingValues3 = dropdownMenuItemContentPadding;
                        } else {
                            if (i16 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                function5 = null;
                            }
                            if (i6 != 0) {
                                function6 = null;
                            }
                            if (i8 != 0) {
                                z2 = true;
                            }
                            if ((i2 & 128) != 0) {
                                menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                                i15 = i14 & (-29360129);
                            } else {
                                menuItemColorsItemColors = menuItemColors;
                                i15 = i14;
                            }
                            if (i10 != 0) {
                                dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                            } else {
                                dropdownMenuItemContentPadding = paddingValues;
                            }
                            if (i12 != 0) {
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            paddingValues3 = dropdownMenuItemContentPadding;
                        }
                        Function2<? super Composer, ? super Integer, Unit> function11117 = function5;
                        Function2<? super Composer, ? super Integer, Unit> function11118 = function6;
                        boolean z114 = z2;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(70219170, i15, -1, "androidx.compose.material3.DropdownMenuItem (Menu.kt:339)");
                        }
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1238834984, "CC(remember):Menu.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new Function1() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda29
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return MenuKt.DropdownMenuItem$lambda$0$0((SemanticsPropertyReceiver) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composer2 = composerStartRestartGroup;
                        int i1116 = i15 << 3;
                        DropdownMenuItemContent(false, function0, function2, SemanticsModifierKt.semantics$default(modifier2, false, (Function1) objRememberedValue, 1, null), function11117, null, function11118, z114, menuItemColorsItemColors, MenuDefaults.INSTANCE.itemShapes(shape, null, composerStartRestartGroup, ((i15 >> 6) & 14) | 384, 2), paddingValues3, mutableInteractionSource3, composer2, (i1116 & 112) | 196614 | (i1116 & 896) | (57344 & i15) | (3670016 & i1116) | (29360128 & i1116) | (i1116 & 234881024), (i15 >> 24) & 126);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier2;
                        function7 = function11117;
                        function8 = function11118;
                        z4 = z114;
                        menuItemColors2 = menuItemColorsItemColors;
                        paddingValues2 = paddingValues3;
                        mutableInteractionSource2 = mutableInteractionSource3;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        menuItemColors2 = menuItemColors;
                        mutableInteractionSource2 = mutableInteractionSource;
                        modifier3 = modifier2;
                        function7 = function5;
                        function8 = function6;
                        z4 = z2;
                        paddingValues2 = paddingValues;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda30
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return MenuKt.DropdownMenuItem$lambda$1(function0, function2, shape, modifier3, function7, function8, z4, menuItemColors2, paddingValues2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= 1572864;
                z2 = z;
                if ((i & 12582912) != 0) {
                    i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(menuItemColors)) ? 4194304 : 8388608;
                }
                i10 = i2 & 256;
                if (i10 != 0) {
                    if ((i & 100663296) == 0) {
                        if (composerStartRestartGroup.changed(paddingValues)) {
                            i11 = 67108864;
                        } else {
                            i11 = 33554432;
                        }
                        i3 |= i11;
                    }
                    i12 = i2 & 512;
                    if (i12 != 0) {
                        if ((i & 805306368) == 0) {
                            if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                                i13 = C.BUFFER_FLAG_LAST_SAMPLE;
                            } else {
                                i13 = 268435456;
                            }
                            i3 |= i13;
                        }
                        i14 = i3;
                        if ((i3 & 306783379) != 306783378) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        if (composerStartRestartGroup.shouldExecute(z3, i14 & 1)) {
                            composerStartRestartGroup.startDefaults();
                            ComposerKt.sourceInformation(composerStartRestartGroup, "336@16371L12");
                            if ((i & 1) != 0) {
                                if (i16 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                if (i4 != 0) {
                                    function5 = null;
                                }
                                if (i6 != 0) {
                                    function6 = null;
                                }
                                if (i8 != 0) {
                                    z2 = true;
                                }
                                if ((i2 & 128) != 0) {
                                    menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                                    i15 = i14 & (-29360129);
                                } else {
                                    menuItemColorsItemColors = menuItemColors;
                                    i15 = i14;
                                }
                                if (i10 != 0) {
                                    dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                                } else {
                                    dropdownMenuItemContentPadding = paddingValues;
                                }
                                if (i12 != 0) {
                                    mutableInteractionSource3 = null;
                                } else {
                                    mutableInteractionSource3 = mutableInteractionSource;
                                }
                                paddingValues3 = dropdownMenuItemContentPadding;
                            } else {
                                if (i16 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                if (i4 != 0) {
                                    function5 = null;
                                }
                                if (i6 != 0) {
                                    function6 = null;
                                }
                                if (i8 != 0) {
                                    z2 = true;
                                }
                                if ((i2 & 128) != 0) {
                                    menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                                    i15 = i14 & (-29360129);
                                } else {
                                    menuItemColorsItemColors = menuItemColors;
                                    i15 = i14;
                                }
                                if (i10 != 0) {
                                    dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                                } else {
                                    dropdownMenuItemContentPadding = paddingValues;
                                }
                                if (i12 != 0) {
                                    mutableInteractionSource3 = null;
                                } else {
                                    mutableInteractionSource3 = mutableInteractionSource;
                                }
                                paddingValues3 = dropdownMenuItemContentPadding;
                            }
                            Function2<? super Composer, ? super Integer, Unit> function11119 = function5;
                            Function2<? super Composer, ? super Integer, Unit> function111110 = function6;
                            boolean z115 = z2;
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(70219170, i15, -1, "androidx.compose.material3.DropdownMenuItem (Menu.kt:339)");
                            }
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1238834984, "CC(remember):Menu.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = new Function1() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda29
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return MenuKt.DropdownMenuItem$lambda$0$0((SemanticsPropertyReceiver) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            composer2 = composerStartRestartGroup;
                            int i1117 = i15 << 3;
                            DropdownMenuItemContent(false, function0, function2, SemanticsModifierKt.semantics$default(modifier2, false, (Function1) objRememberedValue, 1, null), function11119, null, function111110, z115, menuItemColorsItemColors, MenuDefaults.INSTANCE.itemShapes(shape, null, composerStartRestartGroup, ((i15 >> 6) & 14) | 384, 2), paddingValues3, mutableInteractionSource3, composer2, (i1117 & 112) | 196614 | (i1117 & 896) | (57344 & i15) | (3670016 & i1117) | (29360128 & i1117) | (i1117 & 234881024), (i15 >> 24) & 126);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier3 = modifier2;
                            function7 = function11119;
                            function8 = function111110;
                            z4 = z115;
                            menuItemColors2 = menuItemColorsItemColors;
                            paddingValues2 = paddingValues3;
                            mutableInteractionSource2 = mutableInteractionSource3;
                        } else {
                            composer2 = composerStartRestartGroup;
                            composer2.skipToGroupEnd();
                            menuItemColors2 = menuItemColors;
                            mutableInteractionSource2 = mutableInteractionSource;
                            modifier3 = modifier2;
                            function7 = function5;
                            function8 = function6;
                            z4 = z2;
                            paddingValues2 = paddingValues;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda30
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return MenuKt.DropdownMenuItem$lambda$1(function0, function2, shape, modifier3, function7, function8, z4, menuItemColors2, paddingValues2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                        }
                    }
                    i3 |= 805306368;
                    i14 = i3;
                    if ((i3 & 306783379) != 306783378) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z3, i14 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "336@16371L12");
                        if ((i & 1) != 0) {
                            if (i16 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                function5 = null;
                            }
                            if (i6 != 0) {
                                function6 = null;
                            }
                            if (i8 != 0) {
                                z2 = true;
                            }
                            if ((i2 & 128) != 0) {
                                menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                                i15 = i14 & (-29360129);
                            } else {
                                menuItemColorsItemColors = menuItemColors;
                                i15 = i14;
                            }
                            if (i10 != 0) {
                                dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                            } else {
                                dropdownMenuItemContentPadding = paddingValues;
                            }
                            if (i12 != 0) {
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            paddingValues3 = dropdownMenuItemContentPadding;
                        } else {
                            if (i16 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                function5 = null;
                            }
                            if (i6 != 0) {
                                function6 = null;
                            }
                            if (i8 != 0) {
                                z2 = true;
                            }
                            if ((i2 & 128) != 0) {
                                menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                                i15 = i14 & (-29360129);
                            } else {
                                menuItemColorsItemColors = menuItemColors;
                                i15 = i14;
                            }
                            if (i10 != 0) {
                                dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                            } else {
                                dropdownMenuItemContentPadding = paddingValues;
                            }
                            if (i12 != 0) {
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            paddingValues3 = dropdownMenuItemContentPadding;
                        }
                        Function2<? super Composer, ? super Integer, Unit> function111111 = function5;
                        Function2<? super Composer, ? super Integer, Unit> function111112 = function6;
                        boolean z116 = z2;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(70219170, i15, -1, "androidx.compose.material3.DropdownMenuItem (Menu.kt:339)");
                        }
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1238834984, "CC(remember):Menu.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new Function1() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda29
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return MenuKt.DropdownMenuItem$lambda$0$0((SemanticsPropertyReceiver) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composer2 = composerStartRestartGroup;
                        int i1118 = i15 << 3;
                        DropdownMenuItemContent(false, function0, function2, SemanticsModifierKt.semantics$default(modifier2, false, (Function1) objRememberedValue, 1, null), function111111, null, function111112, z116, menuItemColorsItemColors, MenuDefaults.INSTANCE.itemShapes(shape, null, composerStartRestartGroup, ((i15 >> 6) & 14) | 384, 2), paddingValues3, mutableInteractionSource3, composer2, (i1118 & 112) | 196614 | (i1118 & 896) | (57344 & i15) | (3670016 & i1118) | (29360128 & i1118) | (i1118 & 234881024), (i15 >> 24) & 126);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier2;
                        function7 = function111111;
                        function8 = function111112;
                        z4 = z116;
                        menuItemColors2 = menuItemColorsItemColors;
                        paddingValues2 = paddingValues3;
                        mutableInteractionSource2 = mutableInteractionSource3;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        menuItemColors2 = menuItemColors;
                        mutableInteractionSource2 = mutableInteractionSource;
                        modifier3 = modifier2;
                        function7 = function5;
                        function8 = function6;
                        z4 = z2;
                        paddingValues2 = paddingValues;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda30
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return MenuKt.DropdownMenuItem$lambda$1(function0, function2, shape, modifier3, function7, function8, z4, menuItemColors2, paddingValues2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= 100663296;
                i12 = i2 & 512;
                if (i12 != 0) {
                    if ((i & 805306368) == 0) {
                        if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                            i13 = C.BUFFER_FLAG_LAST_SAMPLE;
                        } else {
                            i13 = 268435456;
                        }
                        i3 |= i13;
                    }
                    i14 = i3;
                    if ((i3 & 306783379) != 306783378) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z3, i14 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "336@16371L12");
                        if ((i & 1) != 0) {
                            if (i16 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                function5 = null;
                            }
                            if (i6 != 0) {
                                function6 = null;
                            }
                            if (i8 != 0) {
                                z2 = true;
                            }
                            if ((i2 & 128) != 0) {
                                menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                                i15 = i14 & (-29360129);
                            } else {
                                menuItemColorsItemColors = menuItemColors;
                                i15 = i14;
                            }
                            if (i10 != 0) {
                                dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                            } else {
                                dropdownMenuItemContentPadding = paddingValues;
                            }
                            if (i12 != 0) {
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            paddingValues3 = dropdownMenuItemContentPadding;
                        } else {
                            if (i16 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                function5 = null;
                            }
                            if (i6 != 0) {
                                function6 = null;
                            }
                            if (i8 != 0) {
                                z2 = true;
                            }
                            if ((i2 & 128) != 0) {
                                menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                                i15 = i14 & (-29360129);
                            } else {
                                menuItemColorsItemColors = menuItemColors;
                                i15 = i14;
                            }
                            if (i10 != 0) {
                                dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                            } else {
                                dropdownMenuItemContentPadding = paddingValues;
                            }
                            if (i12 != 0) {
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            paddingValues3 = dropdownMenuItemContentPadding;
                        }
                        Function2<? super Composer, ? super Integer, Unit> function111113 = function5;
                        Function2<? super Composer, ? super Integer, Unit> function111114 = function6;
                        boolean z117 = z2;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(70219170, i15, -1, "androidx.compose.material3.DropdownMenuItem (Menu.kt:339)");
                        }
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1238834984, "CC(remember):Menu.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new Function1() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda29
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return MenuKt.DropdownMenuItem$lambda$0$0((SemanticsPropertyReceiver) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composer2 = composerStartRestartGroup;
                        int i1119 = i15 << 3;
                        DropdownMenuItemContent(false, function0, function2, SemanticsModifierKt.semantics$default(modifier2, false, (Function1) objRememberedValue, 1, null), function111113, null, function111114, z117, menuItemColorsItemColors, MenuDefaults.INSTANCE.itemShapes(shape, null, composerStartRestartGroup, ((i15 >> 6) & 14) | 384, 2), paddingValues3, mutableInteractionSource3, composer2, (i1119 & 112) | 196614 | (i1119 & 896) | (57344 & i15) | (3670016 & i1119) | (29360128 & i1119) | (i1119 & 234881024), (i15 >> 24) & 126);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier2;
                        function7 = function111113;
                        function8 = function111114;
                        z4 = z117;
                        menuItemColors2 = menuItemColorsItemColors;
                        paddingValues2 = paddingValues3;
                        mutableInteractionSource2 = mutableInteractionSource3;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        menuItemColors2 = menuItemColors;
                        mutableInteractionSource2 = mutableInteractionSource;
                        modifier3 = modifier2;
                        function7 = function5;
                        function8 = function6;
                        z4 = z2;
                        paddingValues2 = paddingValues;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda30
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return MenuKt.DropdownMenuItem$lambda$1(function0, function2, shape, modifier3, function7, function8, z4, menuItemColors2, paddingValues2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= 805306368;
                i14 = i3;
                if ((i3 & 306783379) != 306783378) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i14 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "336@16371L12");
                    if ((i & 1) != 0) {
                        if (i16 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            function5 = null;
                        }
                        if (i6 != 0) {
                            function6 = null;
                        }
                        if (i8 != 0) {
                            z2 = true;
                        }
                        if ((i2 & 128) != 0) {
                            menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                            i15 = i14 & (-29360129);
                        } else {
                            menuItemColorsItemColors = menuItemColors;
                            i15 = i14;
                        }
                        if (i10 != 0) {
                            dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                        } else {
                            dropdownMenuItemContentPadding = paddingValues;
                        }
                        if (i12 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        paddingValues3 = dropdownMenuItemContentPadding;
                    } else {
                        if (i16 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            function5 = null;
                        }
                        if (i6 != 0) {
                            function6 = null;
                        }
                        if (i8 != 0) {
                            z2 = true;
                        }
                        if ((i2 & 128) != 0) {
                            menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                            i15 = i14 & (-29360129);
                        } else {
                            menuItemColorsItemColors = menuItemColors;
                            i15 = i14;
                        }
                        if (i10 != 0) {
                            dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                        } else {
                            dropdownMenuItemContentPadding = paddingValues;
                        }
                        if (i12 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        paddingValues3 = dropdownMenuItemContentPadding;
                    }
                    Function2<? super Composer, ? super Integer, Unit> function111115 = function5;
                    Function2<? super Composer, ? super Integer, Unit> function111116 = function6;
                    boolean z118 = z2;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(70219170, i15, -1, "androidx.compose.material3.DropdownMenuItem (Menu.kt:339)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1238834984, "CC(remember):Menu.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new Function1() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda29
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return MenuKt.DropdownMenuItem$lambda$0$0((SemanticsPropertyReceiver) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composer2 = composerStartRestartGroup;
                    int i11110 = i15 << 3;
                    DropdownMenuItemContent(false, function0, function2, SemanticsModifierKt.semantics$default(modifier2, false, (Function1) objRememberedValue, 1, null), function111115, null, function111116, z118, menuItemColorsItemColors, MenuDefaults.INSTANCE.itemShapes(shape, null, composerStartRestartGroup, ((i15 >> 6) & 14) | 384, 2), paddingValues3, mutableInteractionSource3, composer2, (i11110 & 112) | 196614 | (i11110 & 896) | (57344 & i15) | (3670016 & i11110) | (29360128 & i11110) | (i11110 & 234881024), (i15 >> 24) & 126);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                    function7 = function111115;
                    function8 = function111116;
                    z4 = z118;
                    menuItemColors2 = menuItemColorsItemColors;
                    paddingValues2 = paddingValues3;
                    mutableInteractionSource2 = mutableInteractionSource3;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    menuItemColors2 = menuItemColors;
                    mutableInteractionSource2 = mutableInteractionSource;
                    modifier3 = modifier2;
                    function7 = function5;
                    function8 = function6;
                    z4 = z2;
                    paddingValues2 = paddingValues;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda30
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return MenuKt.DropdownMenuItem$lambda$1(function0, function2, shape, modifier3, function7, function8, z4, menuItemColors2, paddingValues2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            function6 = function4;
            i8 = i2 & 64;
            if (i8 != 0) {
                if ((1572864 & i) == 0) {
                    z2 = z;
                    if (composerStartRestartGroup.changed(z2)) {
                        i9 = 1048576;
                    } else {
                        i9 = 524288;
                    }
                    i3 |= i9;
                }
                if ((i & 12582912) != 0) {
                    i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(menuItemColors)) ? 4194304 : 8388608;
                }
                i10 = i2 & 256;
                if (i10 != 0) {
                    if ((i & 100663296) == 0) {
                        if (composerStartRestartGroup.changed(paddingValues)) {
                            i11 = 67108864;
                        } else {
                            i11 = 33554432;
                        }
                        i3 |= i11;
                    }
                    i12 = i2 & 512;
                    if (i12 != 0) {
                        if ((i & 805306368) == 0) {
                            if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                                i13 = C.BUFFER_FLAG_LAST_SAMPLE;
                            } else {
                                i13 = 268435456;
                            }
                            i3 |= i13;
                        }
                        i14 = i3;
                        if ((i3 & 306783379) != 306783378) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        if (composerStartRestartGroup.shouldExecute(z3, i14 & 1)) {
                            composerStartRestartGroup.startDefaults();
                            ComposerKt.sourceInformation(composerStartRestartGroup, "336@16371L12");
                            if ((i & 1) != 0) {
                                if (i16 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                if (i4 != 0) {
                                    function5 = null;
                                }
                                if (i6 != 0) {
                                    function6 = null;
                                }
                                if (i8 != 0) {
                                    z2 = true;
                                }
                                if ((i2 & 128) != 0) {
                                    menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                                    i15 = i14 & (-29360129);
                                } else {
                                    menuItemColorsItemColors = menuItemColors;
                                    i15 = i14;
                                }
                                if (i10 != 0) {
                                    dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                                } else {
                                    dropdownMenuItemContentPadding = paddingValues;
                                }
                                if (i12 != 0) {
                                    mutableInteractionSource3 = null;
                                } else {
                                    mutableInteractionSource3 = mutableInteractionSource;
                                }
                                paddingValues3 = dropdownMenuItemContentPadding;
                            } else {
                                if (i16 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                if (i4 != 0) {
                                    function5 = null;
                                }
                                if (i6 != 0) {
                                    function6 = null;
                                }
                                if (i8 != 0) {
                                    z2 = true;
                                }
                                if ((i2 & 128) != 0) {
                                    menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                                    i15 = i14 & (-29360129);
                                } else {
                                    menuItemColorsItemColors = menuItemColors;
                                    i15 = i14;
                                }
                                if (i10 != 0) {
                                    dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                                } else {
                                    dropdownMenuItemContentPadding = paddingValues;
                                }
                                if (i12 != 0) {
                                    mutableInteractionSource3 = null;
                                } else {
                                    mutableInteractionSource3 = mutableInteractionSource;
                                }
                                paddingValues3 = dropdownMenuItemContentPadding;
                            }
                            Function2<? super Composer, ? super Integer, Unit> function111117 = function5;
                            Function2<? super Composer, ? super Integer, Unit> function111118 = function6;
                            boolean z119 = z2;
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(70219170, i15, -1, "androidx.compose.material3.DropdownMenuItem (Menu.kt:339)");
                            }
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1238834984, "CC(remember):Menu.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = new Function1() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda29
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return MenuKt.DropdownMenuItem$lambda$0$0((SemanticsPropertyReceiver) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            composer2 = composerStartRestartGroup;
                            int i11111 = i15 << 3;
                            DropdownMenuItemContent(false, function0, function2, SemanticsModifierKt.semantics$default(modifier2, false, (Function1) objRememberedValue, 1, null), function111117, null, function111118, z119, menuItemColorsItemColors, MenuDefaults.INSTANCE.itemShapes(shape, null, composerStartRestartGroup, ((i15 >> 6) & 14) | 384, 2), paddingValues3, mutableInteractionSource3, composer2, (i11111 & 112) | 196614 | (i11111 & 896) | (57344 & i15) | (3670016 & i11111) | (29360128 & i11111) | (i11111 & 234881024), (i15 >> 24) & 126);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier3 = modifier2;
                            function7 = function111117;
                            function8 = function111118;
                            z4 = z119;
                            menuItemColors2 = menuItemColorsItemColors;
                            paddingValues2 = paddingValues3;
                            mutableInteractionSource2 = mutableInteractionSource3;
                        } else {
                            composer2 = composerStartRestartGroup;
                            composer2.skipToGroupEnd();
                            menuItemColors2 = menuItemColors;
                            mutableInteractionSource2 = mutableInteractionSource;
                            modifier3 = modifier2;
                            function7 = function5;
                            function8 = function6;
                            z4 = z2;
                            paddingValues2 = paddingValues;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda30
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return MenuKt.DropdownMenuItem$lambda$1(function0, function2, shape, modifier3, function7, function8, z4, menuItemColors2, paddingValues2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                        }
                    }
                    i3 |= 805306368;
                    i14 = i3;
                    if ((i3 & 306783379) != 306783378) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z3, i14 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "336@16371L12");
                        if ((i & 1) != 0) {
                            if (i16 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                function5 = null;
                            }
                            if (i6 != 0) {
                                function6 = null;
                            }
                            if (i8 != 0) {
                                z2 = true;
                            }
                            if ((i2 & 128) != 0) {
                                menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                                i15 = i14 & (-29360129);
                            } else {
                                menuItemColorsItemColors = menuItemColors;
                                i15 = i14;
                            }
                            if (i10 != 0) {
                                dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                            } else {
                                dropdownMenuItemContentPadding = paddingValues;
                            }
                            if (i12 != 0) {
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            paddingValues3 = dropdownMenuItemContentPadding;
                        } else {
                            if (i16 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                function5 = null;
                            }
                            if (i6 != 0) {
                                function6 = null;
                            }
                            if (i8 != 0) {
                                z2 = true;
                            }
                            if ((i2 & 128) != 0) {
                                menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                                i15 = i14 & (-29360129);
                            } else {
                                menuItemColorsItemColors = menuItemColors;
                                i15 = i14;
                            }
                            if (i10 != 0) {
                                dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                            } else {
                                dropdownMenuItemContentPadding = paddingValues;
                            }
                            if (i12 != 0) {
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            paddingValues3 = dropdownMenuItemContentPadding;
                        }
                        Function2<? super Composer, ? super Integer, Unit> function111119 = function5;
                        Function2<? super Composer, ? super Integer, Unit> function1111110 = function6;
                        boolean z1110 = z2;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(70219170, i15, -1, "androidx.compose.material3.DropdownMenuItem (Menu.kt:339)");
                        }
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1238834984, "CC(remember):Menu.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new Function1() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda29
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return MenuKt.DropdownMenuItem$lambda$0$0((SemanticsPropertyReceiver) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composer2 = composerStartRestartGroup;
                        int i11112 = i15 << 3;
                        DropdownMenuItemContent(false, function0, function2, SemanticsModifierKt.semantics$default(modifier2, false, (Function1) objRememberedValue, 1, null), function111119, null, function1111110, z1110, menuItemColorsItemColors, MenuDefaults.INSTANCE.itemShapes(shape, null, composerStartRestartGroup, ((i15 >> 6) & 14) | 384, 2), paddingValues3, mutableInteractionSource3, composer2, (i11112 & 112) | 196614 | (i11112 & 896) | (57344 & i15) | (3670016 & i11112) | (29360128 & i11112) | (i11112 & 234881024), (i15 >> 24) & 126);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier2;
                        function7 = function111119;
                        function8 = function1111110;
                        z4 = z1110;
                        menuItemColors2 = menuItemColorsItemColors;
                        paddingValues2 = paddingValues3;
                        mutableInteractionSource2 = mutableInteractionSource3;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        menuItemColors2 = menuItemColors;
                        mutableInteractionSource2 = mutableInteractionSource;
                        modifier3 = modifier2;
                        function7 = function5;
                        function8 = function6;
                        z4 = z2;
                        paddingValues2 = paddingValues;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda30
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return MenuKt.DropdownMenuItem$lambda$1(function0, function2, shape, modifier3, function7, function8, z4, menuItemColors2, paddingValues2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= 100663296;
                i12 = i2 & 512;
                if (i12 != 0) {
                    if ((i & 805306368) == 0) {
                        if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                            i13 = C.BUFFER_FLAG_LAST_SAMPLE;
                        } else {
                            i13 = 268435456;
                        }
                        i3 |= i13;
                    }
                    i14 = i3;
                    if ((i3 & 306783379) != 306783378) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z3, i14 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "336@16371L12");
                        if ((i & 1) != 0) {
                            if (i16 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                function5 = null;
                            }
                            if (i6 != 0) {
                                function6 = null;
                            }
                            if (i8 != 0) {
                                z2 = true;
                            }
                            if ((i2 & 128) != 0) {
                                menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                                i15 = i14 & (-29360129);
                            } else {
                                menuItemColorsItemColors = menuItemColors;
                                i15 = i14;
                            }
                            if (i10 != 0) {
                                dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                            } else {
                                dropdownMenuItemContentPadding = paddingValues;
                            }
                            if (i12 != 0) {
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            paddingValues3 = dropdownMenuItemContentPadding;
                        } else {
                            if (i16 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                function5 = null;
                            }
                            if (i6 != 0) {
                                function6 = null;
                            }
                            if (i8 != 0) {
                                z2 = true;
                            }
                            if ((i2 & 128) != 0) {
                                menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                                i15 = i14 & (-29360129);
                            } else {
                                menuItemColorsItemColors = menuItemColors;
                                i15 = i14;
                            }
                            if (i10 != 0) {
                                dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                            } else {
                                dropdownMenuItemContentPadding = paddingValues;
                            }
                            if (i12 != 0) {
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            paddingValues3 = dropdownMenuItemContentPadding;
                        }
                        Function2<? super Composer, ? super Integer, Unit> function1111111 = function5;
                        Function2<? super Composer, ? super Integer, Unit> function1111112 = function6;
                        boolean z1111 = z2;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(70219170, i15, -1, "androidx.compose.material3.DropdownMenuItem (Menu.kt:339)");
                        }
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1238834984, "CC(remember):Menu.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new Function1() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda29
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return MenuKt.DropdownMenuItem$lambda$0$0((SemanticsPropertyReceiver) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composer2 = composerStartRestartGroup;
                        int i11113 = i15 << 3;
                        DropdownMenuItemContent(false, function0, function2, SemanticsModifierKt.semantics$default(modifier2, false, (Function1) objRememberedValue, 1, null), function1111111, null, function1111112, z1111, menuItemColorsItemColors, MenuDefaults.INSTANCE.itemShapes(shape, null, composerStartRestartGroup, ((i15 >> 6) & 14) | 384, 2), paddingValues3, mutableInteractionSource3, composer2, (i11113 & 112) | 196614 | (i11113 & 896) | (57344 & i15) | (3670016 & i11113) | (29360128 & i11113) | (i11113 & 234881024), (i15 >> 24) & 126);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier2;
                        function7 = function1111111;
                        function8 = function1111112;
                        z4 = z1111;
                        menuItemColors2 = menuItemColorsItemColors;
                        paddingValues2 = paddingValues3;
                        mutableInteractionSource2 = mutableInteractionSource3;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        menuItemColors2 = menuItemColors;
                        mutableInteractionSource2 = mutableInteractionSource;
                        modifier3 = modifier2;
                        function7 = function5;
                        function8 = function6;
                        z4 = z2;
                        paddingValues2 = paddingValues;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda30
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return MenuKt.DropdownMenuItem$lambda$1(function0, function2, shape, modifier3, function7, function8, z4, menuItemColors2, paddingValues2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= 805306368;
                i14 = i3;
                if ((i3 & 306783379) != 306783378) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i14 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "336@16371L12");
                    if ((i & 1) != 0) {
                        if (i16 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            function5 = null;
                        }
                        if (i6 != 0) {
                            function6 = null;
                        }
                        if (i8 != 0) {
                            z2 = true;
                        }
                        if ((i2 & 128) != 0) {
                            menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                            i15 = i14 & (-29360129);
                        } else {
                            menuItemColorsItemColors = menuItemColors;
                            i15 = i14;
                        }
                        if (i10 != 0) {
                            dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                        } else {
                            dropdownMenuItemContentPadding = paddingValues;
                        }
                        if (i12 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        paddingValues3 = dropdownMenuItemContentPadding;
                    } else {
                        if (i16 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            function5 = null;
                        }
                        if (i6 != 0) {
                            function6 = null;
                        }
                        if (i8 != 0) {
                            z2 = true;
                        }
                        if ((i2 & 128) != 0) {
                            menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                            i15 = i14 & (-29360129);
                        } else {
                            menuItemColorsItemColors = menuItemColors;
                            i15 = i14;
                        }
                        if (i10 != 0) {
                            dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                        } else {
                            dropdownMenuItemContentPadding = paddingValues;
                        }
                        if (i12 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        paddingValues3 = dropdownMenuItemContentPadding;
                    }
                    Function2<? super Composer, ? super Integer, Unit> function1111113 = function5;
                    Function2<? super Composer, ? super Integer, Unit> function1111114 = function6;
                    boolean z1112 = z2;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(70219170, i15, -1, "androidx.compose.material3.DropdownMenuItem (Menu.kt:339)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1238834984, "CC(remember):Menu.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new Function1() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda29
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return MenuKt.DropdownMenuItem$lambda$0$0((SemanticsPropertyReceiver) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composer2 = composerStartRestartGroup;
                    int i11114 = i15 << 3;
                    DropdownMenuItemContent(false, function0, function2, SemanticsModifierKt.semantics$default(modifier2, false, (Function1) objRememberedValue, 1, null), function1111113, null, function1111114, z1112, menuItemColorsItemColors, MenuDefaults.INSTANCE.itemShapes(shape, null, composerStartRestartGroup, ((i15 >> 6) & 14) | 384, 2), paddingValues3, mutableInteractionSource3, composer2, (i11114 & 112) | 196614 | (i11114 & 896) | (57344 & i15) | (3670016 & i11114) | (29360128 & i11114) | (i11114 & 234881024), (i15 >> 24) & 126);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                    function7 = function1111113;
                    function8 = function1111114;
                    z4 = z1112;
                    menuItemColors2 = menuItemColorsItemColors;
                    paddingValues2 = paddingValues3;
                    mutableInteractionSource2 = mutableInteractionSource3;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    menuItemColors2 = menuItemColors;
                    mutableInteractionSource2 = mutableInteractionSource;
                    modifier3 = modifier2;
                    function7 = function5;
                    function8 = function6;
                    z4 = z2;
                    paddingValues2 = paddingValues;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda30
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return MenuKt.DropdownMenuItem$lambda$1(function0, function2, shape, modifier3, function7, function8, z4, menuItemColors2, paddingValues2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 1572864;
            z2 = z;
            if ((i & 12582912) != 0) {
                i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(menuItemColors)) ? 4194304 : 8388608;
            }
            i10 = i2 & 256;
            if (i10 != 0) {
                if ((i & 100663296) == 0) {
                    if (composerStartRestartGroup.changed(paddingValues)) {
                        i11 = 67108864;
                    } else {
                        i11 = 33554432;
                    }
                    i3 |= i11;
                }
                i12 = i2 & 512;
                if (i12 != 0) {
                    if ((i & 805306368) == 0) {
                        if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                            i13 = C.BUFFER_FLAG_LAST_SAMPLE;
                        } else {
                            i13 = 268435456;
                        }
                        i3 |= i13;
                    }
                    i14 = i3;
                    if ((i3 & 306783379) != 306783378) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z3, i14 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "336@16371L12");
                        if ((i & 1) != 0) {
                            if (i16 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                function5 = null;
                            }
                            if (i6 != 0) {
                                function6 = null;
                            }
                            if (i8 != 0) {
                                z2 = true;
                            }
                            if ((i2 & 128) != 0) {
                                menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                                i15 = i14 & (-29360129);
                            } else {
                                menuItemColorsItemColors = menuItemColors;
                                i15 = i14;
                            }
                            if (i10 != 0) {
                                dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                            } else {
                                dropdownMenuItemContentPadding = paddingValues;
                            }
                            if (i12 != 0) {
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            paddingValues3 = dropdownMenuItemContentPadding;
                        } else {
                            if (i16 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                function5 = null;
                            }
                            if (i6 != 0) {
                                function6 = null;
                            }
                            if (i8 != 0) {
                                z2 = true;
                            }
                            if ((i2 & 128) != 0) {
                                menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                                i15 = i14 & (-29360129);
                            } else {
                                menuItemColorsItemColors = menuItemColors;
                                i15 = i14;
                            }
                            if (i10 != 0) {
                                dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                            } else {
                                dropdownMenuItemContentPadding = paddingValues;
                            }
                            if (i12 != 0) {
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            paddingValues3 = dropdownMenuItemContentPadding;
                        }
                        Function2<? super Composer, ? super Integer, Unit> function1111115 = function5;
                        Function2<? super Composer, ? super Integer, Unit> function1111116 = function6;
                        boolean z1113 = z2;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(70219170, i15, -1, "androidx.compose.material3.DropdownMenuItem (Menu.kt:339)");
                        }
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1238834984, "CC(remember):Menu.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new Function1() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda29
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return MenuKt.DropdownMenuItem$lambda$0$0((SemanticsPropertyReceiver) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composer2 = composerStartRestartGroup;
                        int i11115 = i15 << 3;
                        DropdownMenuItemContent(false, function0, function2, SemanticsModifierKt.semantics$default(modifier2, false, (Function1) objRememberedValue, 1, null), function1111115, null, function1111116, z1113, menuItemColorsItemColors, MenuDefaults.INSTANCE.itemShapes(shape, null, composerStartRestartGroup, ((i15 >> 6) & 14) | 384, 2), paddingValues3, mutableInteractionSource3, composer2, (i11115 & 112) | 196614 | (i11115 & 896) | (57344 & i15) | (3670016 & i11115) | (29360128 & i11115) | (i11115 & 234881024), (i15 >> 24) & 126);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier2;
                        function7 = function1111115;
                        function8 = function1111116;
                        z4 = z1113;
                        menuItemColors2 = menuItemColorsItemColors;
                        paddingValues2 = paddingValues3;
                        mutableInteractionSource2 = mutableInteractionSource3;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        menuItemColors2 = menuItemColors;
                        mutableInteractionSource2 = mutableInteractionSource;
                        modifier3 = modifier2;
                        function7 = function5;
                        function8 = function6;
                        z4 = z2;
                        paddingValues2 = paddingValues;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda30
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return MenuKt.DropdownMenuItem$lambda$1(function0, function2, shape, modifier3, function7, function8, z4, menuItemColors2, paddingValues2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= 805306368;
                i14 = i3;
                if ((i3 & 306783379) != 306783378) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i14 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "336@16371L12");
                    if ((i & 1) != 0) {
                        if (i16 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            function5 = null;
                        }
                        if (i6 != 0) {
                            function6 = null;
                        }
                        if (i8 != 0) {
                            z2 = true;
                        }
                        if ((i2 & 128) != 0) {
                            menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                            i15 = i14 & (-29360129);
                        } else {
                            menuItemColorsItemColors = menuItemColors;
                            i15 = i14;
                        }
                        if (i10 != 0) {
                            dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                        } else {
                            dropdownMenuItemContentPadding = paddingValues;
                        }
                        if (i12 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        paddingValues3 = dropdownMenuItemContentPadding;
                    } else {
                        if (i16 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            function5 = null;
                        }
                        if (i6 != 0) {
                            function6 = null;
                        }
                        if (i8 != 0) {
                            z2 = true;
                        }
                        if ((i2 & 128) != 0) {
                            menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                            i15 = i14 & (-29360129);
                        } else {
                            menuItemColorsItemColors = menuItemColors;
                            i15 = i14;
                        }
                        if (i10 != 0) {
                            dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                        } else {
                            dropdownMenuItemContentPadding = paddingValues;
                        }
                        if (i12 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        paddingValues3 = dropdownMenuItemContentPadding;
                    }
                    Function2<? super Composer, ? super Integer, Unit> function1111117 = function5;
                    Function2<? super Composer, ? super Integer, Unit> function1111118 = function6;
                    boolean z1114 = z2;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(70219170, i15, -1, "androidx.compose.material3.DropdownMenuItem (Menu.kt:339)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1238834984, "CC(remember):Menu.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new Function1() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda29
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return MenuKt.DropdownMenuItem$lambda$0$0((SemanticsPropertyReceiver) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composer2 = composerStartRestartGroup;
                    int i11116 = i15 << 3;
                    DropdownMenuItemContent(false, function0, function2, SemanticsModifierKt.semantics$default(modifier2, false, (Function1) objRememberedValue, 1, null), function1111117, null, function1111118, z1114, menuItemColorsItemColors, MenuDefaults.INSTANCE.itemShapes(shape, null, composerStartRestartGroup, ((i15 >> 6) & 14) | 384, 2), paddingValues3, mutableInteractionSource3, composer2, (i11116 & 112) | 196614 | (i11116 & 896) | (57344 & i15) | (3670016 & i11116) | (29360128 & i11116) | (i11116 & 234881024), (i15 >> 24) & 126);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                    function7 = function1111117;
                    function8 = function1111118;
                    z4 = z1114;
                    menuItemColors2 = menuItemColorsItemColors;
                    paddingValues2 = paddingValues3;
                    mutableInteractionSource2 = mutableInteractionSource3;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    menuItemColors2 = menuItemColors;
                    mutableInteractionSource2 = mutableInteractionSource;
                    modifier3 = modifier2;
                    function7 = function5;
                    function8 = function6;
                    z4 = z2;
                    paddingValues2 = paddingValues;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda30
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return MenuKt.DropdownMenuItem$lambda$1(function0, function2, shape, modifier3, function7, function8, z4, menuItemColors2, paddingValues2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 100663296;
            i12 = i2 & 512;
            if (i12 != 0) {
                if ((i & 805306368) == 0) {
                    if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                        i13 = C.BUFFER_FLAG_LAST_SAMPLE;
                    } else {
                        i13 = 268435456;
                    }
                    i3 |= i13;
                }
                i14 = i3;
                if ((i3 & 306783379) != 306783378) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i14 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "336@16371L12");
                    if ((i & 1) != 0) {
                        if (i16 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            function5 = null;
                        }
                        if (i6 != 0) {
                            function6 = null;
                        }
                        if (i8 != 0) {
                            z2 = true;
                        }
                        if ((i2 & 128) != 0) {
                            menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                            i15 = i14 & (-29360129);
                        } else {
                            menuItemColorsItemColors = menuItemColors;
                            i15 = i14;
                        }
                        if (i10 != 0) {
                            dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                        } else {
                            dropdownMenuItemContentPadding = paddingValues;
                        }
                        if (i12 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        paddingValues3 = dropdownMenuItemContentPadding;
                    } else {
                        if (i16 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            function5 = null;
                        }
                        if (i6 != 0) {
                            function6 = null;
                        }
                        if (i8 != 0) {
                            z2 = true;
                        }
                        if ((i2 & 128) != 0) {
                            menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                            i15 = i14 & (-29360129);
                        } else {
                            menuItemColorsItemColors = menuItemColors;
                            i15 = i14;
                        }
                        if (i10 != 0) {
                            dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                        } else {
                            dropdownMenuItemContentPadding = paddingValues;
                        }
                        if (i12 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        paddingValues3 = dropdownMenuItemContentPadding;
                    }
                    Function2<? super Composer, ? super Integer, Unit> function1111119 = function5;
                    Function2<? super Composer, ? super Integer, Unit> function11111110 = function6;
                    boolean z1115 = z2;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(70219170, i15, -1, "androidx.compose.material3.DropdownMenuItem (Menu.kt:339)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1238834984, "CC(remember):Menu.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new Function1() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda29
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return MenuKt.DropdownMenuItem$lambda$0$0((SemanticsPropertyReceiver) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composer2 = composerStartRestartGroup;
                    int i11117 = i15 << 3;
                    DropdownMenuItemContent(false, function0, function2, SemanticsModifierKt.semantics$default(modifier2, false, (Function1) objRememberedValue, 1, null), function1111119, null, function11111110, z1115, menuItemColorsItemColors, MenuDefaults.INSTANCE.itemShapes(shape, null, composerStartRestartGroup, ((i15 >> 6) & 14) | 384, 2), paddingValues3, mutableInteractionSource3, composer2, (i11117 & 112) | 196614 | (i11117 & 896) | (57344 & i15) | (3670016 & i11117) | (29360128 & i11117) | (i11117 & 234881024), (i15 >> 24) & 126);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                    function7 = function1111119;
                    function8 = function11111110;
                    z4 = z1115;
                    menuItemColors2 = menuItemColorsItemColors;
                    paddingValues2 = paddingValues3;
                    mutableInteractionSource2 = mutableInteractionSource3;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    menuItemColors2 = menuItemColors;
                    mutableInteractionSource2 = mutableInteractionSource;
                    modifier3 = modifier2;
                    function7 = function5;
                    function8 = function6;
                    z4 = z2;
                    paddingValues2 = paddingValues;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda30
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return MenuKt.DropdownMenuItem$lambda$1(function0, function2, shape, modifier3, function7, function8, z4, menuItemColors2, paddingValues2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 805306368;
            i14 = i3;
            if ((i3 & 306783379) != 306783378) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i14 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "336@16371L12");
                if ((i & 1) != 0) {
                    if (i16 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        function5 = null;
                    }
                    if (i6 != 0) {
                        function6 = null;
                    }
                    if (i8 != 0) {
                        z2 = true;
                    }
                    if ((i2 & 128) != 0) {
                        menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                        i15 = i14 & (-29360129);
                    } else {
                        menuItemColorsItemColors = menuItemColors;
                        i15 = i14;
                    }
                    if (i10 != 0) {
                        dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                    } else {
                        dropdownMenuItemContentPadding = paddingValues;
                    }
                    if (i12 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    paddingValues3 = dropdownMenuItemContentPadding;
                } else {
                    if (i16 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        function5 = null;
                    }
                    if (i6 != 0) {
                        function6 = null;
                    }
                    if (i8 != 0) {
                        z2 = true;
                    }
                    if ((i2 & 128) != 0) {
                        menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                        i15 = i14 & (-29360129);
                    } else {
                        menuItemColorsItemColors = menuItemColors;
                        i15 = i14;
                    }
                    if (i10 != 0) {
                        dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                    } else {
                        dropdownMenuItemContentPadding = paddingValues;
                    }
                    if (i12 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    paddingValues3 = dropdownMenuItemContentPadding;
                }
                Function2<? super Composer, ? super Integer, Unit> function11111111 = function5;
                Function2<? super Composer, ? super Integer, Unit> function11111112 = function6;
                boolean z1116 = z2;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(70219170, i15, -1, "androidx.compose.material3.DropdownMenuItem (Menu.kt:339)");
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1238834984, "CC(remember):Menu.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function1() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda29
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return MenuKt.DropdownMenuItem$lambda$0$0((SemanticsPropertyReceiver) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composer2 = composerStartRestartGroup;
                int i11118 = i15 << 3;
                DropdownMenuItemContent(false, function0, function2, SemanticsModifierKt.semantics$default(modifier2, false, (Function1) objRememberedValue, 1, null), function11111111, null, function11111112, z1116, menuItemColorsItemColors, MenuDefaults.INSTANCE.itemShapes(shape, null, composerStartRestartGroup, ((i15 >> 6) & 14) | 384, 2), paddingValues3, mutableInteractionSource3, composer2, (i11118 & 112) | 196614 | (i11118 & 896) | (57344 & i15) | (3670016 & i11118) | (29360128 & i11118) | (i11118 & 234881024), (i15 >> 24) & 126);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier2;
                function7 = function11111111;
                function8 = function11111112;
                z4 = z1116;
                menuItemColors2 = menuItemColorsItemColors;
                paddingValues2 = paddingValues3;
                mutableInteractionSource2 = mutableInteractionSource3;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                menuItemColors2 = menuItemColors;
                mutableInteractionSource2 = mutableInteractionSource;
                modifier3 = modifier2;
                function7 = function5;
                function8 = function6;
                z4 = z2;
                paddingValues2 = paddingValues;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda30
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return MenuKt.DropdownMenuItem$lambda$1(function0, function2, shape, modifier3, function7, function8, z4, menuItemColors2, paddingValues2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
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
                i8 = i2 & 64;
                if (i8 != 0) {
                    if ((1572864 & i) == 0) {
                        z2 = z;
                        if (composerStartRestartGroup.changed(z2)) {
                            i9 = 1048576;
                        } else {
                            i9 = 524288;
                        }
                        i3 |= i9;
                    }
                    if ((i & 12582912) != 0) {
                        i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(menuItemColors)) ? 4194304 : 8388608;
                    }
                    i10 = i2 & 256;
                    if (i10 != 0) {
                        if ((i & 100663296) == 0) {
                            if (composerStartRestartGroup.changed(paddingValues)) {
                                i11 = 67108864;
                            } else {
                                i11 = 33554432;
                            }
                            i3 |= i11;
                        }
                        i12 = i2 & 512;
                        if (i12 != 0) {
                            if ((i & 805306368) == 0) {
                                if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                                    i13 = C.BUFFER_FLAG_LAST_SAMPLE;
                                } else {
                                    i13 = 268435456;
                                }
                                i3 |= i13;
                            }
                            i14 = i3;
                            if ((i3 & 306783379) != 306783378) {
                                z3 = true;
                            } else {
                                z3 = false;
                            }
                            if (composerStartRestartGroup.shouldExecute(z3, i14 & 1)) {
                                composerStartRestartGroup.startDefaults();
                                ComposerKt.sourceInformation(composerStartRestartGroup, "336@16371L12");
                                if ((i & 1) != 0) {
                                    if (i16 != 0) {
                                        modifier2 = Modifier.INSTANCE;
                                    }
                                    if (i4 != 0) {
                                        function5 = null;
                                    }
                                    if (i6 != 0) {
                                        function6 = null;
                                    }
                                    if (i8 != 0) {
                                        z2 = true;
                                    }
                                    if ((i2 & 128) != 0) {
                                        menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                                        i15 = i14 & (-29360129);
                                    } else {
                                        menuItemColorsItemColors = menuItemColors;
                                        i15 = i14;
                                    }
                                    if (i10 != 0) {
                                        dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                                    } else {
                                        dropdownMenuItemContentPadding = paddingValues;
                                    }
                                    if (i12 != 0) {
                                        mutableInteractionSource3 = null;
                                    } else {
                                        mutableInteractionSource3 = mutableInteractionSource;
                                    }
                                    paddingValues3 = dropdownMenuItemContentPadding;
                                } else {
                                    if (i16 != 0) {
                                        modifier2 = Modifier.INSTANCE;
                                    }
                                    if (i4 != 0) {
                                        function5 = null;
                                    }
                                    if (i6 != 0) {
                                        function6 = null;
                                    }
                                    if (i8 != 0) {
                                        z2 = true;
                                    }
                                    if ((i2 & 128) != 0) {
                                        menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                                        i15 = i14 & (-29360129);
                                    } else {
                                        menuItemColorsItemColors = menuItemColors;
                                        i15 = i14;
                                    }
                                    if (i10 != 0) {
                                        dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                                    } else {
                                        dropdownMenuItemContentPadding = paddingValues;
                                    }
                                    if (i12 != 0) {
                                        mutableInteractionSource3 = null;
                                    } else {
                                        mutableInteractionSource3 = mutableInteractionSource;
                                    }
                                    paddingValues3 = dropdownMenuItemContentPadding;
                                }
                                Function2<? super Composer, ? super Integer, Unit> function11111113 = function5;
                                Function2<? super Composer, ? super Integer, Unit> function11111114 = function6;
                                boolean z1117 = z2;
                                composerStartRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(70219170, i15, -1, "androidx.compose.material3.DropdownMenuItem (Menu.kt:339)");
                                }
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1238834984, "CC(remember):Menu.kt#9igjgp");
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue = new Function1() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda29
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj) {
                                            return MenuKt.DropdownMenuItem$lambda$0$0((SemanticsPropertyReceiver) obj);
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                composer2 = composerStartRestartGroup;
                                int i11119 = i15 << 3;
                                DropdownMenuItemContent(false, function0, function2, SemanticsModifierKt.semantics$default(modifier2, false, (Function1) objRememberedValue, 1, null), function11111113, null, function11111114, z1117, menuItemColorsItemColors, MenuDefaults.INSTANCE.itemShapes(shape, null, composerStartRestartGroup, ((i15 >> 6) & 14) | 384, 2), paddingValues3, mutableInteractionSource3, composer2, (i11119 & 112) | 196614 | (i11119 & 896) | (57344 & i15) | (3670016 & i11119) | (29360128 & i11119) | (i11119 & 234881024), (i15 >> 24) & 126);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                modifier3 = modifier2;
                                function7 = function11111113;
                                function8 = function11111114;
                                z4 = z1117;
                                menuItemColors2 = menuItemColorsItemColors;
                                paddingValues2 = paddingValues3;
                                mutableInteractionSource2 = mutableInteractionSource3;
                            } else {
                                composer2 = composerStartRestartGroup;
                                composer2.skipToGroupEnd();
                                menuItemColors2 = menuItemColors;
                                mutableInteractionSource2 = mutableInteractionSource;
                                modifier3 = modifier2;
                                function7 = function5;
                                function8 = function6;
                                z4 = z2;
                                paddingValues2 = paddingValues;
                            }
                            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup != null) {
                                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda30
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return MenuKt.DropdownMenuItem$lambda$1(function0, function2, shape, modifier3, function7, function8, z4, menuItemColors2, paddingValues2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                    }
                                });
                            }
                        }
                        i3 |= 805306368;
                        i14 = i3;
                        if ((i3 & 306783379) != 306783378) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        if (composerStartRestartGroup.shouldExecute(z3, i14 & 1)) {
                            composerStartRestartGroup.startDefaults();
                            ComposerKt.sourceInformation(composerStartRestartGroup, "336@16371L12");
                            if ((i & 1) != 0) {
                                if (i16 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                if (i4 != 0) {
                                    function5 = null;
                                }
                                if (i6 != 0) {
                                    function6 = null;
                                }
                                if (i8 != 0) {
                                    z2 = true;
                                }
                                if ((i2 & 128) != 0) {
                                    menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                                    i15 = i14 & (-29360129);
                                } else {
                                    menuItemColorsItemColors = menuItemColors;
                                    i15 = i14;
                                }
                                if (i10 != 0) {
                                    dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                                } else {
                                    dropdownMenuItemContentPadding = paddingValues;
                                }
                                if (i12 != 0) {
                                    mutableInteractionSource3 = null;
                                } else {
                                    mutableInteractionSource3 = mutableInteractionSource;
                                }
                                paddingValues3 = dropdownMenuItemContentPadding;
                            } else {
                                if (i16 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                if (i4 != 0) {
                                    function5 = null;
                                }
                                if (i6 != 0) {
                                    function6 = null;
                                }
                                if (i8 != 0) {
                                    z2 = true;
                                }
                                if ((i2 & 128) != 0) {
                                    menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                                    i15 = i14 & (-29360129);
                                } else {
                                    menuItemColorsItemColors = menuItemColors;
                                    i15 = i14;
                                }
                                if (i10 != 0) {
                                    dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                                } else {
                                    dropdownMenuItemContentPadding = paddingValues;
                                }
                                if (i12 != 0) {
                                    mutableInteractionSource3 = null;
                                } else {
                                    mutableInteractionSource3 = mutableInteractionSource;
                                }
                                paddingValues3 = dropdownMenuItemContentPadding;
                            }
                            Function2<? super Composer, ? super Integer, Unit> function11111115 = function5;
                            Function2<? super Composer, ? super Integer, Unit> function11111116 = function6;
                            boolean z1118 = z2;
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(70219170, i15, -1, "androidx.compose.material3.DropdownMenuItem (Menu.kt:339)");
                            }
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1238834984, "CC(remember):Menu.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = new Function1() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda29
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return MenuKt.DropdownMenuItem$lambda$0$0((SemanticsPropertyReceiver) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            composer2 = composerStartRestartGroup;
                            int i111110 = i15 << 3;
                            DropdownMenuItemContent(false, function0, function2, SemanticsModifierKt.semantics$default(modifier2, false, (Function1) objRememberedValue, 1, null), function11111115, null, function11111116, z1118, menuItemColorsItemColors, MenuDefaults.INSTANCE.itemShapes(shape, null, composerStartRestartGroup, ((i15 >> 6) & 14) | 384, 2), paddingValues3, mutableInteractionSource3, composer2, (i111110 & 112) | 196614 | (i111110 & 896) | (57344 & i15) | (3670016 & i111110) | (29360128 & i111110) | (i111110 & 234881024), (i15 >> 24) & 126);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier3 = modifier2;
                            function7 = function11111115;
                            function8 = function11111116;
                            z4 = z1118;
                            menuItemColors2 = menuItemColorsItemColors;
                            paddingValues2 = paddingValues3;
                            mutableInteractionSource2 = mutableInteractionSource3;
                        } else {
                            composer2 = composerStartRestartGroup;
                            composer2.skipToGroupEnd();
                            menuItemColors2 = menuItemColors;
                            mutableInteractionSource2 = mutableInteractionSource;
                            modifier3 = modifier2;
                            function7 = function5;
                            function8 = function6;
                            z4 = z2;
                            paddingValues2 = paddingValues;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda30
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return MenuKt.DropdownMenuItem$lambda$1(function0, function2, shape, modifier3, function7, function8, z4, menuItemColors2, paddingValues2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                        }
                    }
                    i3 |= 100663296;
                    i12 = i2 & 512;
                    if (i12 != 0) {
                        if ((i & 805306368) == 0) {
                            if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                                i13 = C.BUFFER_FLAG_LAST_SAMPLE;
                            } else {
                                i13 = 268435456;
                            }
                            i3 |= i13;
                        }
                        i14 = i3;
                        if ((i3 & 306783379) != 306783378) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        if (composerStartRestartGroup.shouldExecute(z3, i14 & 1)) {
                            composerStartRestartGroup.startDefaults();
                            ComposerKt.sourceInformation(composerStartRestartGroup, "336@16371L12");
                            if ((i & 1) != 0) {
                                if (i16 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                if (i4 != 0) {
                                    function5 = null;
                                }
                                if (i6 != 0) {
                                    function6 = null;
                                }
                                if (i8 != 0) {
                                    z2 = true;
                                }
                                if ((i2 & 128) != 0) {
                                    menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                                    i15 = i14 & (-29360129);
                                } else {
                                    menuItemColorsItemColors = menuItemColors;
                                    i15 = i14;
                                }
                                if (i10 != 0) {
                                    dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                                } else {
                                    dropdownMenuItemContentPadding = paddingValues;
                                }
                                if (i12 != 0) {
                                    mutableInteractionSource3 = null;
                                } else {
                                    mutableInteractionSource3 = mutableInteractionSource;
                                }
                                paddingValues3 = dropdownMenuItemContentPadding;
                            } else {
                                if (i16 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                if (i4 != 0) {
                                    function5 = null;
                                }
                                if (i6 != 0) {
                                    function6 = null;
                                }
                                if (i8 != 0) {
                                    z2 = true;
                                }
                                if ((i2 & 128) != 0) {
                                    menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                                    i15 = i14 & (-29360129);
                                } else {
                                    menuItemColorsItemColors = menuItemColors;
                                    i15 = i14;
                                }
                                if (i10 != 0) {
                                    dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                                } else {
                                    dropdownMenuItemContentPadding = paddingValues;
                                }
                                if (i12 != 0) {
                                    mutableInteractionSource3 = null;
                                } else {
                                    mutableInteractionSource3 = mutableInteractionSource;
                                }
                                paddingValues3 = dropdownMenuItemContentPadding;
                            }
                            Function2<? super Composer, ? super Integer, Unit> function11111117 = function5;
                            Function2<? super Composer, ? super Integer, Unit> function11111118 = function6;
                            boolean z1119 = z2;
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(70219170, i15, -1, "androidx.compose.material3.DropdownMenuItem (Menu.kt:339)");
                            }
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1238834984, "CC(remember):Menu.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = new Function1() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda29
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return MenuKt.DropdownMenuItem$lambda$0$0((SemanticsPropertyReceiver) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            composer2 = composerStartRestartGroup;
                            int i111111 = i15 << 3;
                            DropdownMenuItemContent(false, function0, function2, SemanticsModifierKt.semantics$default(modifier2, false, (Function1) objRememberedValue, 1, null), function11111117, null, function11111118, z1119, menuItemColorsItemColors, MenuDefaults.INSTANCE.itemShapes(shape, null, composerStartRestartGroup, ((i15 >> 6) & 14) | 384, 2), paddingValues3, mutableInteractionSource3, composer2, (i111111 & 112) | 196614 | (i111111 & 896) | (57344 & i15) | (3670016 & i111111) | (29360128 & i111111) | (i111111 & 234881024), (i15 >> 24) & 126);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier3 = modifier2;
                            function7 = function11111117;
                            function8 = function11111118;
                            z4 = z1119;
                            menuItemColors2 = menuItemColorsItemColors;
                            paddingValues2 = paddingValues3;
                            mutableInteractionSource2 = mutableInteractionSource3;
                        } else {
                            composer2 = composerStartRestartGroup;
                            composer2.skipToGroupEnd();
                            menuItemColors2 = menuItemColors;
                            mutableInteractionSource2 = mutableInteractionSource;
                            modifier3 = modifier2;
                            function7 = function5;
                            function8 = function6;
                            z4 = z2;
                            paddingValues2 = paddingValues;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda30
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return MenuKt.DropdownMenuItem$lambda$1(function0, function2, shape, modifier3, function7, function8, z4, menuItemColors2, paddingValues2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                        }
                    }
                    i3 |= 805306368;
                    i14 = i3;
                    if ((i3 & 306783379) != 306783378) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z3, i14 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "336@16371L12");
                        if ((i & 1) != 0) {
                            if (i16 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                function5 = null;
                            }
                            if (i6 != 0) {
                                function6 = null;
                            }
                            if (i8 != 0) {
                                z2 = true;
                            }
                            if ((i2 & 128) != 0) {
                                menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                                i15 = i14 & (-29360129);
                            } else {
                                menuItemColorsItemColors = menuItemColors;
                                i15 = i14;
                            }
                            if (i10 != 0) {
                                dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                            } else {
                                dropdownMenuItemContentPadding = paddingValues;
                            }
                            if (i12 != 0) {
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            paddingValues3 = dropdownMenuItemContentPadding;
                        } else {
                            if (i16 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                function5 = null;
                            }
                            if (i6 != 0) {
                                function6 = null;
                            }
                            if (i8 != 0) {
                                z2 = true;
                            }
                            if ((i2 & 128) != 0) {
                                menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                                i15 = i14 & (-29360129);
                            } else {
                                menuItemColorsItemColors = menuItemColors;
                                i15 = i14;
                            }
                            if (i10 != 0) {
                                dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                            } else {
                                dropdownMenuItemContentPadding = paddingValues;
                            }
                            if (i12 != 0) {
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            paddingValues3 = dropdownMenuItemContentPadding;
                        }
                        Function2<? super Composer, ? super Integer, Unit> function11111119 = function5;
                        Function2<? super Composer, ? super Integer, Unit> function111111110 = function6;
                        boolean z11110 = z2;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(70219170, i15, -1, "androidx.compose.material3.DropdownMenuItem (Menu.kt:339)");
                        }
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1238834984, "CC(remember):Menu.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new Function1() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda29
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return MenuKt.DropdownMenuItem$lambda$0$0((SemanticsPropertyReceiver) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composer2 = composerStartRestartGroup;
                        int i111112 = i15 << 3;
                        DropdownMenuItemContent(false, function0, function2, SemanticsModifierKt.semantics$default(modifier2, false, (Function1) objRememberedValue, 1, null), function11111119, null, function111111110, z11110, menuItemColorsItemColors, MenuDefaults.INSTANCE.itemShapes(shape, null, composerStartRestartGroup, ((i15 >> 6) & 14) | 384, 2), paddingValues3, mutableInteractionSource3, composer2, (i111112 & 112) | 196614 | (i111112 & 896) | (57344 & i15) | (3670016 & i111112) | (29360128 & i111112) | (i111112 & 234881024), (i15 >> 24) & 126);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier2;
                        function7 = function11111119;
                        function8 = function111111110;
                        z4 = z11110;
                        menuItemColors2 = menuItemColorsItemColors;
                        paddingValues2 = paddingValues3;
                        mutableInteractionSource2 = mutableInteractionSource3;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        menuItemColors2 = menuItemColors;
                        mutableInteractionSource2 = mutableInteractionSource;
                        modifier3 = modifier2;
                        function7 = function5;
                        function8 = function6;
                        z4 = z2;
                        paddingValues2 = paddingValues;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda30
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return MenuKt.DropdownMenuItem$lambda$1(function0, function2, shape, modifier3, function7, function8, z4, menuItemColors2, paddingValues2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= 1572864;
                z2 = z;
                if ((i & 12582912) != 0) {
                    i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(menuItemColors)) ? 4194304 : 8388608;
                }
                i10 = i2 & 256;
                if (i10 != 0) {
                    if ((i & 100663296) == 0) {
                        if (composerStartRestartGroup.changed(paddingValues)) {
                            i11 = 67108864;
                        } else {
                            i11 = 33554432;
                        }
                        i3 |= i11;
                    }
                    i12 = i2 & 512;
                    if (i12 != 0) {
                        if ((i & 805306368) == 0) {
                            if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                                i13 = C.BUFFER_FLAG_LAST_SAMPLE;
                            } else {
                                i13 = 268435456;
                            }
                            i3 |= i13;
                        }
                        i14 = i3;
                        if ((i3 & 306783379) != 306783378) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        if (composerStartRestartGroup.shouldExecute(z3, i14 & 1)) {
                            composerStartRestartGroup.startDefaults();
                            ComposerKt.sourceInformation(composerStartRestartGroup, "336@16371L12");
                            if ((i & 1) != 0) {
                                if (i16 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                if (i4 != 0) {
                                    function5 = null;
                                }
                                if (i6 != 0) {
                                    function6 = null;
                                }
                                if (i8 != 0) {
                                    z2 = true;
                                }
                                if ((i2 & 128) != 0) {
                                    menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                                    i15 = i14 & (-29360129);
                                } else {
                                    menuItemColorsItemColors = menuItemColors;
                                    i15 = i14;
                                }
                                if (i10 != 0) {
                                    dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                                } else {
                                    dropdownMenuItemContentPadding = paddingValues;
                                }
                                if (i12 != 0) {
                                    mutableInteractionSource3 = null;
                                } else {
                                    mutableInteractionSource3 = mutableInteractionSource;
                                }
                                paddingValues3 = dropdownMenuItemContentPadding;
                            } else {
                                if (i16 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                if (i4 != 0) {
                                    function5 = null;
                                }
                                if (i6 != 0) {
                                    function6 = null;
                                }
                                if (i8 != 0) {
                                    z2 = true;
                                }
                                if ((i2 & 128) != 0) {
                                    menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                                    i15 = i14 & (-29360129);
                                } else {
                                    menuItemColorsItemColors = menuItemColors;
                                    i15 = i14;
                                }
                                if (i10 != 0) {
                                    dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                                } else {
                                    dropdownMenuItemContentPadding = paddingValues;
                                }
                                if (i12 != 0) {
                                    mutableInteractionSource3 = null;
                                } else {
                                    mutableInteractionSource3 = mutableInteractionSource;
                                }
                                paddingValues3 = dropdownMenuItemContentPadding;
                            }
                            Function2<? super Composer, ? super Integer, Unit> function111111111 = function5;
                            Function2<? super Composer, ? super Integer, Unit> function111111112 = function6;
                            boolean z11111 = z2;
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(70219170, i15, -1, "androidx.compose.material3.DropdownMenuItem (Menu.kt:339)");
                            }
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1238834984, "CC(remember):Menu.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = new Function1() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda29
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return MenuKt.DropdownMenuItem$lambda$0$0((SemanticsPropertyReceiver) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            composer2 = composerStartRestartGroup;
                            int i111113 = i15 << 3;
                            DropdownMenuItemContent(false, function0, function2, SemanticsModifierKt.semantics$default(modifier2, false, (Function1) objRememberedValue, 1, null), function111111111, null, function111111112, z11111, menuItemColorsItemColors, MenuDefaults.INSTANCE.itemShapes(shape, null, composerStartRestartGroup, ((i15 >> 6) & 14) | 384, 2), paddingValues3, mutableInteractionSource3, composer2, (i111113 & 112) | 196614 | (i111113 & 896) | (57344 & i15) | (3670016 & i111113) | (29360128 & i111113) | (i111113 & 234881024), (i15 >> 24) & 126);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier3 = modifier2;
                            function7 = function111111111;
                            function8 = function111111112;
                            z4 = z11111;
                            menuItemColors2 = menuItemColorsItemColors;
                            paddingValues2 = paddingValues3;
                            mutableInteractionSource2 = mutableInteractionSource3;
                        } else {
                            composer2 = composerStartRestartGroup;
                            composer2.skipToGroupEnd();
                            menuItemColors2 = menuItemColors;
                            mutableInteractionSource2 = mutableInteractionSource;
                            modifier3 = modifier2;
                            function7 = function5;
                            function8 = function6;
                            z4 = z2;
                            paddingValues2 = paddingValues;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda30
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return MenuKt.DropdownMenuItem$lambda$1(function0, function2, shape, modifier3, function7, function8, z4, menuItemColors2, paddingValues2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                        }
                    }
                    i3 |= 805306368;
                    i14 = i3;
                    if ((i3 & 306783379) != 306783378) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z3, i14 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "336@16371L12");
                        if ((i & 1) != 0) {
                            if (i16 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                function5 = null;
                            }
                            if (i6 != 0) {
                                function6 = null;
                            }
                            if (i8 != 0) {
                                z2 = true;
                            }
                            if ((i2 & 128) != 0) {
                                menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                                i15 = i14 & (-29360129);
                            } else {
                                menuItemColorsItemColors = menuItemColors;
                                i15 = i14;
                            }
                            if (i10 != 0) {
                                dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                            } else {
                                dropdownMenuItemContentPadding = paddingValues;
                            }
                            if (i12 != 0) {
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            paddingValues3 = dropdownMenuItemContentPadding;
                        } else {
                            if (i16 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                function5 = null;
                            }
                            if (i6 != 0) {
                                function6 = null;
                            }
                            if (i8 != 0) {
                                z2 = true;
                            }
                            if ((i2 & 128) != 0) {
                                menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                                i15 = i14 & (-29360129);
                            } else {
                                menuItemColorsItemColors = menuItemColors;
                                i15 = i14;
                            }
                            if (i10 != 0) {
                                dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                            } else {
                                dropdownMenuItemContentPadding = paddingValues;
                            }
                            if (i12 != 0) {
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            paddingValues3 = dropdownMenuItemContentPadding;
                        }
                        Function2<? super Composer, ? super Integer, Unit> function111111113 = function5;
                        Function2<? super Composer, ? super Integer, Unit> function111111114 = function6;
                        boolean z11112 = z2;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(70219170, i15, -1, "androidx.compose.material3.DropdownMenuItem (Menu.kt:339)");
                        }
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1238834984, "CC(remember):Menu.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new Function1() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda29
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return MenuKt.DropdownMenuItem$lambda$0$0((SemanticsPropertyReceiver) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composer2 = composerStartRestartGroup;
                        int i111114 = i15 << 3;
                        DropdownMenuItemContent(false, function0, function2, SemanticsModifierKt.semantics$default(modifier2, false, (Function1) objRememberedValue, 1, null), function111111113, null, function111111114, z11112, menuItemColorsItemColors, MenuDefaults.INSTANCE.itemShapes(shape, null, composerStartRestartGroup, ((i15 >> 6) & 14) | 384, 2), paddingValues3, mutableInteractionSource3, composer2, (i111114 & 112) | 196614 | (i111114 & 896) | (57344 & i15) | (3670016 & i111114) | (29360128 & i111114) | (i111114 & 234881024), (i15 >> 24) & 126);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier2;
                        function7 = function111111113;
                        function8 = function111111114;
                        z4 = z11112;
                        menuItemColors2 = menuItemColorsItemColors;
                        paddingValues2 = paddingValues3;
                        mutableInteractionSource2 = mutableInteractionSource3;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        menuItemColors2 = menuItemColors;
                        mutableInteractionSource2 = mutableInteractionSource;
                        modifier3 = modifier2;
                        function7 = function5;
                        function8 = function6;
                        z4 = z2;
                        paddingValues2 = paddingValues;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda30
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return MenuKt.DropdownMenuItem$lambda$1(function0, function2, shape, modifier3, function7, function8, z4, menuItemColors2, paddingValues2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= 100663296;
                i12 = i2 & 512;
                if (i12 != 0) {
                    if ((i & 805306368) == 0) {
                        if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                            i13 = C.BUFFER_FLAG_LAST_SAMPLE;
                        } else {
                            i13 = 268435456;
                        }
                        i3 |= i13;
                    }
                    i14 = i3;
                    if ((i3 & 306783379) != 306783378) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z3, i14 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "336@16371L12");
                        if ((i & 1) != 0) {
                            if (i16 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                function5 = null;
                            }
                            if (i6 != 0) {
                                function6 = null;
                            }
                            if (i8 != 0) {
                                z2 = true;
                            }
                            if ((i2 & 128) != 0) {
                                menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                                i15 = i14 & (-29360129);
                            } else {
                                menuItemColorsItemColors = menuItemColors;
                                i15 = i14;
                            }
                            if (i10 != 0) {
                                dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                            } else {
                                dropdownMenuItemContentPadding = paddingValues;
                            }
                            if (i12 != 0) {
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            paddingValues3 = dropdownMenuItemContentPadding;
                        } else {
                            if (i16 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                function5 = null;
                            }
                            if (i6 != 0) {
                                function6 = null;
                            }
                            if (i8 != 0) {
                                z2 = true;
                            }
                            if ((i2 & 128) != 0) {
                                menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                                i15 = i14 & (-29360129);
                            } else {
                                menuItemColorsItemColors = menuItemColors;
                                i15 = i14;
                            }
                            if (i10 != 0) {
                                dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                            } else {
                                dropdownMenuItemContentPadding = paddingValues;
                            }
                            if (i12 != 0) {
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            paddingValues3 = dropdownMenuItemContentPadding;
                        }
                        Function2<? super Composer, ? super Integer, Unit> function111111115 = function5;
                        Function2<? super Composer, ? super Integer, Unit> function111111116 = function6;
                        boolean z11113 = z2;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(70219170, i15, -1, "androidx.compose.material3.DropdownMenuItem (Menu.kt:339)");
                        }
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1238834984, "CC(remember):Menu.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new Function1() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda29
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return MenuKt.DropdownMenuItem$lambda$0$0((SemanticsPropertyReceiver) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composer2 = composerStartRestartGroup;
                        int i111115 = i15 << 3;
                        DropdownMenuItemContent(false, function0, function2, SemanticsModifierKt.semantics$default(modifier2, false, (Function1) objRememberedValue, 1, null), function111111115, null, function111111116, z11113, menuItemColorsItemColors, MenuDefaults.INSTANCE.itemShapes(shape, null, composerStartRestartGroup, ((i15 >> 6) & 14) | 384, 2), paddingValues3, mutableInteractionSource3, composer2, (i111115 & 112) | 196614 | (i111115 & 896) | (57344 & i15) | (3670016 & i111115) | (29360128 & i111115) | (i111115 & 234881024), (i15 >> 24) & 126);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier2;
                        function7 = function111111115;
                        function8 = function111111116;
                        z4 = z11113;
                        menuItemColors2 = menuItemColorsItemColors;
                        paddingValues2 = paddingValues3;
                        mutableInteractionSource2 = mutableInteractionSource3;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        menuItemColors2 = menuItemColors;
                        mutableInteractionSource2 = mutableInteractionSource;
                        modifier3 = modifier2;
                        function7 = function5;
                        function8 = function6;
                        z4 = z2;
                        paddingValues2 = paddingValues;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda30
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return MenuKt.DropdownMenuItem$lambda$1(function0, function2, shape, modifier3, function7, function8, z4, menuItemColors2, paddingValues2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= 805306368;
                i14 = i3;
                if ((i3 & 306783379) != 306783378) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i14 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "336@16371L12");
                    if ((i & 1) != 0) {
                        if (i16 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            function5 = null;
                        }
                        if (i6 != 0) {
                            function6 = null;
                        }
                        if (i8 != 0) {
                            z2 = true;
                        }
                        if ((i2 & 128) != 0) {
                            menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                            i15 = i14 & (-29360129);
                        } else {
                            menuItemColorsItemColors = menuItemColors;
                            i15 = i14;
                        }
                        if (i10 != 0) {
                            dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                        } else {
                            dropdownMenuItemContentPadding = paddingValues;
                        }
                        if (i12 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        paddingValues3 = dropdownMenuItemContentPadding;
                    } else {
                        if (i16 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            function5 = null;
                        }
                        if (i6 != 0) {
                            function6 = null;
                        }
                        if (i8 != 0) {
                            z2 = true;
                        }
                        if ((i2 & 128) != 0) {
                            menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                            i15 = i14 & (-29360129);
                        } else {
                            menuItemColorsItemColors = menuItemColors;
                            i15 = i14;
                        }
                        if (i10 != 0) {
                            dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                        } else {
                            dropdownMenuItemContentPadding = paddingValues;
                        }
                        if (i12 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        paddingValues3 = dropdownMenuItemContentPadding;
                    }
                    Function2<? super Composer, ? super Integer, Unit> function111111117 = function5;
                    Function2<? super Composer, ? super Integer, Unit> function111111118 = function6;
                    boolean z11114 = z2;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(70219170, i15, -1, "androidx.compose.material3.DropdownMenuItem (Menu.kt:339)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1238834984, "CC(remember):Menu.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new Function1() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda29
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return MenuKt.DropdownMenuItem$lambda$0$0((SemanticsPropertyReceiver) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composer2 = composerStartRestartGroup;
                    int i111116 = i15 << 3;
                    DropdownMenuItemContent(false, function0, function2, SemanticsModifierKt.semantics$default(modifier2, false, (Function1) objRememberedValue, 1, null), function111111117, null, function111111118, z11114, menuItemColorsItemColors, MenuDefaults.INSTANCE.itemShapes(shape, null, composerStartRestartGroup, ((i15 >> 6) & 14) | 384, 2), paddingValues3, mutableInteractionSource3, composer2, (i111116 & 112) | 196614 | (i111116 & 896) | (57344 & i15) | (3670016 & i111116) | (29360128 & i111116) | (i111116 & 234881024), (i15 >> 24) & 126);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                    function7 = function111111117;
                    function8 = function111111118;
                    z4 = z11114;
                    menuItemColors2 = menuItemColorsItemColors;
                    paddingValues2 = paddingValues3;
                    mutableInteractionSource2 = mutableInteractionSource3;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    menuItemColors2 = menuItemColors;
                    mutableInteractionSource2 = mutableInteractionSource;
                    modifier3 = modifier2;
                    function7 = function5;
                    function8 = function6;
                    z4 = z2;
                    paddingValues2 = paddingValues;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda30
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return MenuKt.DropdownMenuItem$lambda$1(function0, function2, shape, modifier3, function7, function8, z4, menuItemColors2, paddingValues2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            function6 = function4;
            i8 = i2 & 64;
            if (i8 != 0) {
                if ((1572864 & i) == 0) {
                    z2 = z;
                    if (composerStartRestartGroup.changed(z2)) {
                        i9 = 1048576;
                    } else {
                        i9 = 524288;
                    }
                    i3 |= i9;
                }
                if ((i & 12582912) != 0) {
                    i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(menuItemColors)) ? 4194304 : 8388608;
                }
                i10 = i2 & 256;
                if (i10 != 0) {
                    if ((i & 100663296) == 0) {
                        if (composerStartRestartGroup.changed(paddingValues)) {
                            i11 = 67108864;
                        } else {
                            i11 = 33554432;
                        }
                        i3 |= i11;
                    }
                    i12 = i2 & 512;
                    if (i12 != 0) {
                        if ((i & 805306368) == 0) {
                            if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                                i13 = C.BUFFER_FLAG_LAST_SAMPLE;
                            } else {
                                i13 = 268435456;
                            }
                            i3 |= i13;
                        }
                        i14 = i3;
                        if ((i3 & 306783379) != 306783378) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        if (composerStartRestartGroup.shouldExecute(z3, i14 & 1)) {
                            composerStartRestartGroup.startDefaults();
                            ComposerKt.sourceInformation(composerStartRestartGroup, "336@16371L12");
                            if ((i & 1) != 0) {
                                if (i16 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                if (i4 != 0) {
                                    function5 = null;
                                }
                                if (i6 != 0) {
                                    function6 = null;
                                }
                                if (i8 != 0) {
                                    z2 = true;
                                }
                                if ((i2 & 128) != 0) {
                                    menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                                    i15 = i14 & (-29360129);
                                } else {
                                    menuItemColorsItemColors = menuItemColors;
                                    i15 = i14;
                                }
                                if (i10 != 0) {
                                    dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                                } else {
                                    dropdownMenuItemContentPadding = paddingValues;
                                }
                                if (i12 != 0) {
                                    mutableInteractionSource3 = null;
                                } else {
                                    mutableInteractionSource3 = mutableInteractionSource;
                                }
                                paddingValues3 = dropdownMenuItemContentPadding;
                            } else {
                                if (i16 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                if (i4 != 0) {
                                    function5 = null;
                                }
                                if (i6 != 0) {
                                    function6 = null;
                                }
                                if (i8 != 0) {
                                    z2 = true;
                                }
                                if ((i2 & 128) != 0) {
                                    menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                                    i15 = i14 & (-29360129);
                                } else {
                                    menuItemColorsItemColors = menuItemColors;
                                    i15 = i14;
                                }
                                if (i10 != 0) {
                                    dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                                } else {
                                    dropdownMenuItemContentPadding = paddingValues;
                                }
                                if (i12 != 0) {
                                    mutableInteractionSource3 = null;
                                } else {
                                    mutableInteractionSource3 = mutableInteractionSource;
                                }
                                paddingValues3 = dropdownMenuItemContentPadding;
                            }
                            Function2<? super Composer, ? super Integer, Unit> function111111119 = function5;
                            Function2<? super Composer, ? super Integer, Unit> function1111111110 = function6;
                            boolean z11115 = z2;
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(70219170, i15, -1, "androidx.compose.material3.DropdownMenuItem (Menu.kt:339)");
                            }
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1238834984, "CC(remember):Menu.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = new Function1() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda29
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return MenuKt.DropdownMenuItem$lambda$0$0((SemanticsPropertyReceiver) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            composer2 = composerStartRestartGroup;
                            int i111117 = i15 << 3;
                            DropdownMenuItemContent(false, function0, function2, SemanticsModifierKt.semantics$default(modifier2, false, (Function1) objRememberedValue, 1, null), function111111119, null, function1111111110, z11115, menuItemColorsItemColors, MenuDefaults.INSTANCE.itemShapes(shape, null, composerStartRestartGroup, ((i15 >> 6) & 14) | 384, 2), paddingValues3, mutableInteractionSource3, composer2, (i111117 & 112) | 196614 | (i111117 & 896) | (57344 & i15) | (3670016 & i111117) | (29360128 & i111117) | (i111117 & 234881024), (i15 >> 24) & 126);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier3 = modifier2;
                            function7 = function111111119;
                            function8 = function1111111110;
                            z4 = z11115;
                            menuItemColors2 = menuItemColorsItemColors;
                            paddingValues2 = paddingValues3;
                            mutableInteractionSource2 = mutableInteractionSource3;
                        } else {
                            composer2 = composerStartRestartGroup;
                            composer2.skipToGroupEnd();
                            menuItemColors2 = menuItemColors;
                            mutableInteractionSource2 = mutableInteractionSource;
                            modifier3 = modifier2;
                            function7 = function5;
                            function8 = function6;
                            z4 = z2;
                            paddingValues2 = paddingValues;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda30
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return MenuKt.DropdownMenuItem$lambda$1(function0, function2, shape, modifier3, function7, function8, z4, menuItemColors2, paddingValues2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                        }
                    }
                    i3 |= 805306368;
                    i14 = i3;
                    if ((i3 & 306783379) != 306783378) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z3, i14 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "336@16371L12");
                        if ((i & 1) != 0) {
                            if (i16 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                function5 = null;
                            }
                            if (i6 != 0) {
                                function6 = null;
                            }
                            if (i8 != 0) {
                                z2 = true;
                            }
                            if ((i2 & 128) != 0) {
                                menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                                i15 = i14 & (-29360129);
                            } else {
                                menuItemColorsItemColors = menuItemColors;
                                i15 = i14;
                            }
                            if (i10 != 0) {
                                dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                            } else {
                                dropdownMenuItemContentPadding = paddingValues;
                            }
                            if (i12 != 0) {
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            paddingValues3 = dropdownMenuItemContentPadding;
                        } else {
                            if (i16 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                function5 = null;
                            }
                            if (i6 != 0) {
                                function6 = null;
                            }
                            if (i8 != 0) {
                                z2 = true;
                            }
                            if ((i2 & 128) != 0) {
                                menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                                i15 = i14 & (-29360129);
                            } else {
                                menuItemColorsItemColors = menuItemColors;
                                i15 = i14;
                            }
                            if (i10 != 0) {
                                dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                            } else {
                                dropdownMenuItemContentPadding = paddingValues;
                            }
                            if (i12 != 0) {
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            paddingValues3 = dropdownMenuItemContentPadding;
                        }
                        Function2<? super Composer, ? super Integer, Unit> function1111111111 = function5;
                        Function2<? super Composer, ? super Integer, Unit> function1111111112 = function6;
                        boolean z11116 = z2;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(70219170, i15, -1, "androidx.compose.material3.DropdownMenuItem (Menu.kt:339)");
                        }
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1238834984, "CC(remember):Menu.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new Function1() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda29
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return MenuKt.DropdownMenuItem$lambda$0$0((SemanticsPropertyReceiver) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composer2 = composerStartRestartGroup;
                        int i111118 = i15 << 3;
                        DropdownMenuItemContent(false, function0, function2, SemanticsModifierKt.semantics$default(modifier2, false, (Function1) objRememberedValue, 1, null), function1111111111, null, function1111111112, z11116, menuItemColorsItemColors, MenuDefaults.INSTANCE.itemShapes(shape, null, composerStartRestartGroup, ((i15 >> 6) & 14) | 384, 2), paddingValues3, mutableInteractionSource3, composer2, (i111118 & 112) | 196614 | (i111118 & 896) | (57344 & i15) | (3670016 & i111118) | (29360128 & i111118) | (i111118 & 234881024), (i15 >> 24) & 126);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier2;
                        function7 = function1111111111;
                        function8 = function1111111112;
                        z4 = z11116;
                        menuItemColors2 = menuItemColorsItemColors;
                        paddingValues2 = paddingValues3;
                        mutableInteractionSource2 = mutableInteractionSource3;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        menuItemColors2 = menuItemColors;
                        mutableInteractionSource2 = mutableInteractionSource;
                        modifier3 = modifier2;
                        function7 = function5;
                        function8 = function6;
                        z4 = z2;
                        paddingValues2 = paddingValues;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda30
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return MenuKt.DropdownMenuItem$lambda$1(function0, function2, shape, modifier3, function7, function8, z4, menuItemColors2, paddingValues2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= 100663296;
                i12 = i2 & 512;
                if (i12 != 0) {
                    if ((i & 805306368) == 0) {
                        if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                            i13 = C.BUFFER_FLAG_LAST_SAMPLE;
                        } else {
                            i13 = 268435456;
                        }
                        i3 |= i13;
                    }
                    i14 = i3;
                    if ((i3 & 306783379) != 306783378) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z3, i14 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "336@16371L12");
                        if ((i & 1) != 0) {
                            if (i16 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                function5 = null;
                            }
                            if (i6 != 0) {
                                function6 = null;
                            }
                            if (i8 != 0) {
                                z2 = true;
                            }
                            if ((i2 & 128) != 0) {
                                menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                                i15 = i14 & (-29360129);
                            } else {
                                menuItemColorsItemColors = menuItemColors;
                                i15 = i14;
                            }
                            if (i10 != 0) {
                                dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                            } else {
                                dropdownMenuItemContentPadding = paddingValues;
                            }
                            if (i12 != 0) {
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            paddingValues3 = dropdownMenuItemContentPadding;
                        } else {
                            if (i16 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                function5 = null;
                            }
                            if (i6 != 0) {
                                function6 = null;
                            }
                            if (i8 != 0) {
                                z2 = true;
                            }
                            if ((i2 & 128) != 0) {
                                menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                                i15 = i14 & (-29360129);
                            } else {
                                menuItemColorsItemColors = menuItemColors;
                                i15 = i14;
                            }
                            if (i10 != 0) {
                                dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                            } else {
                                dropdownMenuItemContentPadding = paddingValues;
                            }
                            if (i12 != 0) {
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            paddingValues3 = dropdownMenuItemContentPadding;
                        }
                        Function2<? super Composer, ? super Integer, Unit> function1111111113 = function5;
                        Function2<? super Composer, ? super Integer, Unit> function1111111114 = function6;
                        boolean z11117 = z2;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(70219170, i15, -1, "androidx.compose.material3.DropdownMenuItem (Menu.kt:339)");
                        }
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1238834984, "CC(remember):Menu.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new Function1() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda29
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return MenuKt.DropdownMenuItem$lambda$0$0((SemanticsPropertyReceiver) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composer2 = composerStartRestartGroup;
                        int i111119 = i15 << 3;
                        DropdownMenuItemContent(false, function0, function2, SemanticsModifierKt.semantics$default(modifier2, false, (Function1) objRememberedValue, 1, null), function1111111113, null, function1111111114, z11117, menuItemColorsItemColors, MenuDefaults.INSTANCE.itemShapes(shape, null, composerStartRestartGroup, ((i15 >> 6) & 14) | 384, 2), paddingValues3, mutableInteractionSource3, composer2, (i111119 & 112) | 196614 | (i111119 & 896) | (57344 & i15) | (3670016 & i111119) | (29360128 & i111119) | (i111119 & 234881024), (i15 >> 24) & 126);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier2;
                        function7 = function1111111113;
                        function8 = function1111111114;
                        z4 = z11117;
                        menuItemColors2 = menuItemColorsItemColors;
                        paddingValues2 = paddingValues3;
                        mutableInteractionSource2 = mutableInteractionSource3;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        menuItemColors2 = menuItemColors;
                        mutableInteractionSource2 = mutableInteractionSource;
                        modifier3 = modifier2;
                        function7 = function5;
                        function8 = function6;
                        z4 = z2;
                        paddingValues2 = paddingValues;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda30
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return MenuKt.DropdownMenuItem$lambda$1(function0, function2, shape, modifier3, function7, function8, z4, menuItemColors2, paddingValues2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= 805306368;
                i14 = i3;
                if ((i3 & 306783379) != 306783378) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i14 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "336@16371L12");
                    if ((i & 1) != 0) {
                        if (i16 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            function5 = null;
                        }
                        if (i6 != 0) {
                            function6 = null;
                        }
                        if (i8 != 0) {
                            z2 = true;
                        }
                        if ((i2 & 128) != 0) {
                            menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                            i15 = i14 & (-29360129);
                        } else {
                            menuItemColorsItemColors = menuItemColors;
                            i15 = i14;
                        }
                        if (i10 != 0) {
                            dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                        } else {
                            dropdownMenuItemContentPadding = paddingValues;
                        }
                        if (i12 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        paddingValues3 = dropdownMenuItemContentPadding;
                    } else {
                        if (i16 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            function5 = null;
                        }
                        if (i6 != 0) {
                            function6 = null;
                        }
                        if (i8 != 0) {
                            z2 = true;
                        }
                        if ((i2 & 128) != 0) {
                            menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                            i15 = i14 & (-29360129);
                        } else {
                            menuItemColorsItemColors = menuItemColors;
                            i15 = i14;
                        }
                        if (i10 != 0) {
                            dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                        } else {
                            dropdownMenuItemContentPadding = paddingValues;
                        }
                        if (i12 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        paddingValues3 = dropdownMenuItemContentPadding;
                    }
                    Function2<? super Composer, ? super Integer, Unit> function1111111115 = function5;
                    Function2<? super Composer, ? super Integer, Unit> function1111111116 = function6;
                    boolean z11118 = z2;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(70219170, i15, -1, "androidx.compose.material3.DropdownMenuItem (Menu.kt:339)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1238834984, "CC(remember):Menu.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new Function1() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda29
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return MenuKt.DropdownMenuItem$lambda$0$0((SemanticsPropertyReceiver) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composer2 = composerStartRestartGroup;
                    int i1111110 = i15 << 3;
                    DropdownMenuItemContent(false, function0, function2, SemanticsModifierKt.semantics$default(modifier2, false, (Function1) objRememberedValue, 1, null), function1111111115, null, function1111111116, z11118, menuItemColorsItemColors, MenuDefaults.INSTANCE.itemShapes(shape, null, composerStartRestartGroup, ((i15 >> 6) & 14) | 384, 2), paddingValues3, mutableInteractionSource3, composer2, (i1111110 & 112) | 196614 | (i1111110 & 896) | (57344 & i15) | (3670016 & i1111110) | (29360128 & i1111110) | (i1111110 & 234881024), (i15 >> 24) & 126);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                    function7 = function1111111115;
                    function8 = function1111111116;
                    z4 = z11118;
                    menuItemColors2 = menuItemColorsItemColors;
                    paddingValues2 = paddingValues3;
                    mutableInteractionSource2 = mutableInteractionSource3;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    menuItemColors2 = menuItemColors;
                    mutableInteractionSource2 = mutableInteractionSource;
                    modifier3 = modifier2;
                    function7 = function5;
                    function8 = function6;
                    z4 = z2;
                    paddingValues2 = paddingValues;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda30
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return MenuKt.DropdownMenuItem$lambda$1(function0, function2, shape, modifier3, function7, function8, z4, menuItemColors2, paddingValues2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 1572864;
            z2 = z;
            if ((i & 12582912) != 0) {
                i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(menuItemColors)) ? 4194304 : 8388608;
            }
            i10 = i2 & 256;
            if (i10 != 0) {
                if ((i & 100663296) == 0) {
                    if (composerStartRestartGroup.changed(paddingValues)) {
                        i11 = 67108864;
                    } else {
                        i11 = 33554432;
                    }
                    i3 |= i11;
                }
                i12 = i2 & 512;
                if (i12 != 0) {
                    if ((i & 805306368) == 0) {
                        if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                            i13 = C.BUFFER_FLAG_LAST_SAMPLE;
                        } else {
                            i13 = 268435456;
                        }
                        i3 |= i13;
                    }
                    i14 = i3;
                    if ((i3 & 306783379) != 306783378) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z3, i14 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "336@16371L12");
                        if ((i & 1) != 0) {
                            if (i16 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                function5 = null;
                            }
                            if (i6 != 0) {
                                function6 = null;
                            }
                            if (i8 != 0) {
                                z2 = true;
                            }
                            if ((i2 & 128) != 0) {
                                menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                                i15 = i14 & (-29360129);
                            } else {
                                menuItemColorsItemColors = menuItemColors;
                                i15 = i14;
                            }
                            if (i10 != 0) {
                                dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                            } else {
                                dropdownMenuItemContentPadding = paddingValues;
                            }
                            if (i12 != 0) {
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            paddingValues3 = dropdownMenuItemContentPadding;
                        } else {
                            if (i16 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                function5 = null;
                            }
                            if (i6 != 0) {
                                function6 = null;
                            }
                            if (i8 != 0) {
                                z2 = true;
                            }
                            if ((i2 & 128) != 0) {
                                menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                                i15 = i14 & (-29360129);
                            } else {
                                menuItemColorsItemColors = menuItemColors;
                                i15 = i14;
                            }
                            if (i10 != 0) {
                                dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                            } else {
                                dropdownMenuItemContentPadding = paddingValues;
                            }
                            if (i12 != 0) {
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            paddingValues3 = dropdownMenuItemContentPadding;
                        }
                        Function2<? super Composer, ? super Integer, Unit> function1111111117 = function5;
                        Function2<? super Composer, ? super Integer, Unit> function1111111118 = function6;
                        boolean z11119 = z2;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(70219170, i15, -1, "androidx.compose.material3.DropdownMenuItem (Menu.kt:339)");
                        }
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1238834984, "CC(remember):Menu.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new Function1() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda29
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return MenuKt.DropdownMenuItem$lambda$0$0((SemanticsPropertyReceiver) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composer2 = composerStartRestartGroup;
                        int i1111111 = i15 << 3;
                        DropdownMenuItemContent(false, function0, function2, SemanticsModifierKt.semantics$default(modifier2, false, (Function1) objRememberedValue, 1, null), function1111111117, null, function1111111118, z11119, menuItemColorsItemColors, MenuDefaults.INSTANCE.itemShapes(shape, null, composerStartRestartGroup, ((i15 >> 6) & 14) | 384, 2), paddingValues3, mutableInteractionSource3, composer2, (i1111111 & 112) | 196614 | (i1111111 & 896) | (57344 & i15) | (3670016 & i1111111) | (29360128 & i1111111) | (i1111111 & 234881024), (i15 >> 24) & 126);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier2;
                        function7 = function1111111117;
                        function8 = function1111111118;
                        z4 = z11119;
                        menuItemColors2 = menuItemColorsItemColors;
                        paddingValues2 = paddingValues3;
                        mutableInteractionSource2 = mutableInteractionSource3;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        menuItemColors2 = menuItemColors;
                        mutableInteractionSource2 = mutableInteractionSource;
                        modifier3 = modifier2;
                        function7 = function5;
                        function8 = function6;
                        z4 = z2;
                        paddingValues2 = paddingValues;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda30
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return MenuKt.DropdownMenuItem$lambda$1(function0, function2, shape, modifier3, function7, function8, z4, menuItemColors2, paddingValues2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= 805306368;
                i14 = i3;
                if ((i3 & 306783379) != 306783378) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i14 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "336@16371L12");
                    if ((i & 1) != 0) {
                        if (i16 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            function5 = null;
                        }
                        if (i6 != 0) {
                            function6 = null;
                        }
                        if (i8 != 0) {
                            z2 = true;
                        }
                        if ((i2 & 128) != 0) {
                            menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                            i15 = i14 & (-29360129);
                        } else {
                            menuItemColorsItemColors = menuItemColors;
                            i15 = i14;
                        }
                        if (i10 != 0) {
                            dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                        } else {
                            dropdownMenuItemContentPadding = paddingValues;
                        }
                        if (i12 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        paddingValues3 = dropdownMenuItemContentPadding;
                    } else {
                        if (i16 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            function5 = null;
                        }
                        if (i6 != 0) {
                            function6 = null;
                        }
                        if (i8 != 0) {
                            z2 = true;
                        }
                        if ((i2 & 128) != 0) {
                            menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                            i15 = i14 & (-29360129);
                        } else {
                            menuItemColorsItemColors = menuItemColors;
                            i15 = i14;
                        }
                        if (i10 != 0) {
                            dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                        } else {
                            dropdownMenuItemContentPadding = paddingValues;
                        }
                        if (i12 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        paddingValues3 = dropdownMenuItemContentPadding;
                    }
                    Function2<? super Composer, ? super Integer, Unit> function1111111119 = function5;
                    Function2<? super Composer, ? super Integer, Unit> function11111111110 = function6;
                    boolean z111110 = z2;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(70219170, i15, -1, "androidx.compose.material3.DropdownMenuItem (Menu.kt:339)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1238834984, "CC(remember):Menu.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new Function1() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda29
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return MenuKt.DropdownMenuItem$lambda$0$0((SemanticsPropertyReceiver) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composer2 = composerStartRestartGroup;
                    int i1111112 = i15 << 3;
                    DropdownMenuItemContent(false, function0, function2, SemanticsModifierKt.semantics$default(modifier2, false, (Function1) objRememberedValue, 1, null), function1111111119, null, function11111111110, z111110, menuItemColorsItemColors, MenuDefaults.INSTANCE.itemShapes(shape, null, composerStartRestartGroup, ((i15 >> 6) & 14) | 384, 2), paddingValues3, mutableInteractionSource3, composer2, (i1111112 & 112) | 196614 | (i1111112 & 896) | (57344 & i15) | (3670016 & i1111112) | (29360128 & i1111112) | (i1111112 & 234881024), (i15 >> 24) & 126);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                    function7 = function1111111119;
                    function8 = function11111111110;
                    z4 = z111110;
                    menuItemColors2 = menuItemColorsItemColors;
                    paddingValues2 = paddingValues3;
                    mutableInteractionSource2 = mutableInteractionSource3;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    menuItemColors2 = menuItemColors;
                    mutableInteractionSource2 = mutableInteractionSource;
                    modifier3 = modifier2;
                    function7 = function5;
                    function8 = function6;
                    z4 = z2;
                    paddingValues2 = paddingValues;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda30
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return MenuKt.DropdownMenuItem$lambda$1(function0, function2, shape, modifier3, function7, function8, z4, menuItemColors2, paddingValues2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 100663296;
            i12 = i2 & 512;
            if (i12 != 0) {
                if ((i & 805306368) == 0) {
                    if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                        i13 = C.BUFFER_FLAG_LAST_SAMPLE;
                    } else {
                        i13 = 268435456;
                    }
                    i3 |= i13;
                }
                i14 = i3;
                if ((i3 & 306783379) != 306783378) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i14 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "336@16371L12");
                    if ((i & 1) != 0) {
                        if (i16 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            function5 = null;
                        }
                        if (i6 != 0) {
                            function6 = null;
                        }
                        if (i8 != 0) {
                            z2 = true;
                        }
                        if ((i2 & 128) != 0) {
                            menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                            i15 = i14 & (-29360129);
                        } else {
                            menuItemColorsItemColors = menuItemColors;
                            i15 = i14;
                        }
                        if (i10 != 0) {
                            dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                        } else {
                            dropdownMenuItemContentPadding = paddingValues;
                        }
                        if (i12 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        paddingValues3 = dropdownMenuItemContentPadding;
                    } else {
                        if (i16 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            function5 = null;
                        }
                        if (i6 != 0) {
                            function6 = null;
                        }
                        if (i8 != 0) {
                            z2 = true;
                        }
                        if ((i2 & 128) != 0) {
                            menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                            i15 = i14 & (-29360129);
                        } else {
                            menuItemColorsItemColors = menuItemColors;
                            i15 = i14;
                        }
                        if (i10 != 0) {
                            dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                        } else {
                            dropdownMenuItemContentPadding = paddingValues;
                        }
                        if (i12 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        paddingValues3 = dropdownMenuItemContentPadding;
                    }
                    Function2<? super Composer, ? super Integer, Unit> function11111111111 = function5;
                    Function2<? super Composer, ? super Integer, Unit> function11111111112 = function6;
                    boolean z111111 = z2;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(70219170, i15, -1, "androidx.compose.material3.DropdownMenuItem (Menu.kt:339)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1238834984, "CC(remember):Menu.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new Function1() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda29
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return MenuKt.DropdownMenuItem$lambda$0$0((SemanticsPropertyReceiver) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composer2 = composerStartRestartGroup;
                    int i1111113 = i15 << 3;
                    DropdownMenuItemContent(false, function0, function2, SemanticsModifierKt.semantics$default(modifier2, false, (Function1) objRememberedValue, 1, null), function11111111111, null, function11111111112, z111111, menuItemColorsItemColors, MenuDefaults.INSTANCE.itemShapes(shape, null, composerStartRestartGroup, ((i15 >> 6) & 14) | 384, 2), paddingValues3, mutableInteractionSource3, composer2, (i1111113 & 112) | 196614 | (i1111113 & 896) | (57344 & i15) | (3670016 & i1111113) | (29360128 & i1111113) | (i1111113 & 234881024), (i15 >> 24) & 126);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                    function7 = function11111111111;
                    function8 = function11111111112;
                    z4 = z111111;
                    menuItemColors2 = menuItemColorsItemColors;
                    paddingValues2 = paddingValues3;
                    mutableInteractionSource2 = mutableInteractionSource3;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    menuItemColors2 = menuItemColors;
                    mutableInteractionSource2 = mutableInteractionSource;
                    modifier3 = modifier2;
                    function7 = function5;
                    function8 = function6;
                    z4 = z2;
                    paddingValues2 = paddingValues;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda30
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return MenuKt.DropdownMenuItem$lambda$1(function0, function2, shape, modifier3, function7, function8, z4, menuItemColors2, paddingValues2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 805306368;
            i14 = i3;
            if ((i3 & 306783379) != 306783378) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i14 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "336@16371L12");
                if ((i & 1) != 0) {
                    if (i16 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        function5 = null;
                    }
                    if (i6 != 0) {
                        function6 = null;
                    }
                    if (i8 != 0) {
                        z2 = true;
                    }
                    if ((i2 & 128) != 0) {
                        menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                        i15 = i14 & (-29360129);
                    } else {
                        menuItemColorsItemColors = menuItemColors;
                        i15 = i14;
                    }
                    if (i10 != 0) {
                        dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                    } else {
                        dropdownMenuItemContentPadding = paddingValues;
                    }
                    if (i12 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    paddingValues3 = dropdownMenuItemContentPadding;
                } else {
                    if (i16 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        function5 = null;
                    }
                    if (i6 != 0) {
                        function6 = null;
                    }
                    if (i8 != 0) {
                        z2 = true;
                    }
                    if ((i2 & 128) != 0) {
                        menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                        i15 = i14 & (-29360129);
                    } else {
                        menuItemColorsItemColors = menuItemColors;
                        i15 = i14;
                    }
                    if (i10 != 0) {
                        dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                    } else {
                        dropdownMenuItemContentPadding = paddingValues;
                    }
                    if (i12 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    paddingValues3 = dropdownMenuItemContentPadding;
                }
                Function2<? super Composer, ? super Integer, Unit> function11111111113 = function5;
                Function2<? super Composer, ? super Integer, Unit> function11111111114 = function6;
                boolean z111112 = z2;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(70219170, i15, -1, "androidx.compose.material3.DropdownMenuItem (Menu.kt:339)");
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1238834984, "CC(remember):Menu.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function1() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda29
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return MenuKt.DropdownMenuItem$lambda$0$0((SemanticsPropertyReceiver) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composer2 = composerStartRestartGroup;
                int i1111114 = i15 << 3;
                DropdownMenuItemContent(false, function0, function2, SemanticsModifierKt.semantics$default(modifier2, false, (Function1) objRememberedValue, 1, null), function11111111113, null, function11111111114, z111112, menuItemColorsItemColors, MenuDefaults.INSTANCE.itemShapes(shape, null, composerStartRestartGroup, ((i15 >> 6) & 14) | 384, 2), paddingValues3, mutableInteractionSource3, composer2, (i1111114 & 112) | 196614 | (i1111114 & 896) | (57344 & i15) | (3670016 & i1111114) | (29360128 & i1111114) | (i1111114 & 234881024), (i15 >> 24) & 126);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier2;
                function7 = function11111111113;
                function8 = function11111111114;
                z4 = z111112;
                menuItemColors2 = menuItemColorsItemColors;
                paddingValues2 = paddingValues3;
                mutableInteractionSource2 = mutableInteractionSource3;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                menuItemColors2 = menuItemColors;
                mutableInteractionSource2 = mutableInteractionSource;
                modifier3 = modifier2;
                function7 = function5;
                function8 = function6;
                z4 = z2;
                paddingValues2 = paddingValues;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda30
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return MenuKt.DropdownMenuItem$lambda$1(function0, function2, shape, modifier3, function7, function8, z4, menuItemColors2, paddingValues2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
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
            i8 = i2 & 64;
            if (i8 != 0) {
                if ((1572864 & i) == 0) {
                    z2 = z;
                    if (composerStartRestartGroup.changed(z2)) {
                        i9 = 1048576;
                    } else {
                        i9 = 524288;
                    }
                    i3 |= i9;
                }
                if ((i & 12582912) != 0) {
                    i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(menuItemColors)) ? 4194304 : 8388608;
                }
                i10 = i2 & 256;
                if (i10 != 0) {
                    if ((i & 100663296) == 0) {
                        if (composerStartRestartGroup.changed(paddingValues)) {
                            i11 = 67108864;
                        } else {
                            i11 = 33554432;
                        }
                        i3 |= i11;
                    }
                    i12 = i2 & 512;
                    if (i12 != 0) {
                        if ((i & 805306368) == 0) {
                            if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                                i13 = C.BUFFER_FLAG_LAST_SAMPLE;
                            } else {
                                i13 = 268435456;
                            }
                            i3 |= i13;
                        }
                        i14 = i3;
                        if ((i3 & 306783379) != 306783378) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        if (composerStartRestartGroup.shouldExecute(z3, i14 & 1)) {
                            composerStartRestartGroup.startDefaults();
                            ComposerKt.sourceInformation(composerStartRestartGroup, "336@16371L12");
                            if ((i & 1) != 0) {
                                if (i16 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                if (i4 != 0) {
                                    function5 = null;
                                }
                                if (i6 != 0) {
                                    function6 = null;
                                }
                                if (i8 != 0) {
                                    z2 = true;
                                }
                                if ((i2 & 128) != 0) {
                                    menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                                    i15 = i14 & (-29360129);
                                } else {
                                    menuItemColorsItemColors = menuItemColors;
                                    i15 = i14;
                                }
                                if (i10 != 0) {
                                    dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                                } else {
                                    dropdownMenuItemContentPadding = paddingValues;
                                }
                                if (i12 != 0) {
                                    mutableInteractionSource3 = null;
                                } else {
                                    mutableInteractionSource3 = mutableInteractionSource;
                                }
                                paddingValues3 = dropdownMenuItemContentPadding;
                            } else {
                                if (i16 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                if (i4 != 0) {
                                    function5 = null;
                                }
                                if (i6 != 0) {
                                    function6 = null;
                                }
                                if (i8 != 0) {
                                    z2 = true;
                                }
                                if ((i2 & 128) != 0) {
                                    menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                                    i15 = i14 & (-29360129);
                                } else {
                                    menuItemColorsItemColors = menuItemColors;
                                    i15 = i14;
                                }
                                if (i10 != 0) {
                                    dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                                } else {
                                    dropdownMenuItemContentPadding = paddingValues;
                                }
                                if (i12 != 0) {
                                    mutableInteractionSource3 = null;
                                } else {
                                    mutableInteractionSource3 = mutableInteractionSource;
                                }
                                paddingValues3 = dropdownMenuItemContentPadding;
                            }
                            Function2<? super Composer, ? super Integer, Unit> function11111111115 = function5;
                            Function2<? super Composer, ? super Integer, Unit> function11111111116 = function6;
                            boolean z111113 = z2;
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(70219170, i15, -1, "androidx.compose.material3.DropdownMenuItem (Menu.kt:339)");
                            }
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1238834984, "CC(remember):Menu.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = new Function1() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda29
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return MenuKt.DropdownMenuItem$lambda$0$0((SemanticsPropertyReceiver) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            composer2 = composerStartRestartGroup;
                            int i1111115 = i15 << 3;
                            DropdownMenuItemContent(false, function0, function2, SemanticsModifierKt.semantics$default(modifier2, false, (Function1) objRememberedValue, 1, null), function11111111115, null, function11111111116, z111113, menuItemColorsItemColors, MenuDefaults.INSTANCE.itemShapes(shape, null, composerStartRestartGroup, ((i15 >> 6) & 14) | 384, 2), paddingValues3, mutableInteractionSource3, composer2, (i1111115 & 112) | 196614 | (i1111115 & 896) | (57344 & i15) | (3670016 & i1111115) | (29360128 & i1111115) | (i1111115 & 234881024), (i15 >> 24) & 126);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier3 = modifier2;
                            function7 = function11111111115;
                            function8 = function11111111116;
                            z4 = z111113;
                            menuItemColors2 = menuItemColorsItemColors;
                            paddingValues2 = paddingValues3;
                            mutableInteractionSource2 = mutableInteractionSource3;
                        } else {
                            composer2 = composerStartRestartGroup;
                            composer2.skipToGroupEnd();
                            menuItemColors2 = menuItemColors;
                            mutableInteractionSource2 = mutableInteractionSource;
                            modifier3 = modifier2;
                            function7 = function5;
                            function8 = function6;
                            z4 = z2;
                            paddingValues2 = paddingValues;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda30
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return MenuKt.DropdownMenuItem$lambda$1(function0, function2, shape, modifier3, function7, function8, z4, menuItemColors2, paddingValues2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                        }
                    }
                    i3 |= 805306368;
                    i14 = i3;
                    if ((i3 & 306783379) != 306783378) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z3, i14 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "336@16371L12");
                        if ((i & 1) != 0) {
                            if (i16 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                function5 = null;
                            }
                            if (i6 != 0) {
                                function6 = null;
                            }
                            if (i8 != 0) {
                                z2 = true;
                            }
                            if ((i2 & 128) != 0) {
                                menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                                i15 = i14 & (-29360129);
                            } else {
                                menuItemColorsItemColors = menuItemColors;
                                i15 = i14;
                            }
                            if (i10 != 0) {
                                dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                            } else {
                                dropdownMenuItemContentPadding = paddingValues;
                            }
                            if (i12 != 0) {
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            paddingValues3 = dropdownMenuItemContentPadding;
                        } else {
                            if (i16 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                function5 = null;
                            }
                            if (i6 != 0) {
                                function6 = null;
                            }
                            if (i8 != 0) {
                                z2 = true;
                            }
                            if ((i2 & 128) != 0) {
                                menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                                i15 = i14 & (-29360129);
                            } else {
                                menuItemColorsItemColors = menuItemColors;
                                i15 = i14;
                            }
                            if (i10 != 0) {
                                dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                            } else {
                                dropdownMenuItemContentPadding = paddingValues;
                            }
                            if (i12 != 0) {
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            paddingValues3 = dropdownMenuItemContentPadding;
                        }
                        Function2<? super Composer, ? super Integer, Unit> function11111111117 = function5;
                        Function2<? super Composer, ? super Integer, Unit> function11111111118 = function6;
                        boolean z111114 = z2;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(70219170, i15, -1, "androidx.compose.material3.DropdownMenuItem (Menu.kt:339)");
                        }
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1238834984, "CC(remember):Menu.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new Function1() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda29
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return MenuKt.DropdownMenuItem$lambda$0$0((SemanticsPropertyReceiver) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composer2 = composerStartRestartGroup;
                        int i1111116 = i15 << 3;
                        DropdownMenuItemContent(false, function0, function2, SemanticsModifierKt.semantics$default(modifier2, false, (Function1) objRememberedValue, 1, null), function11111111117, null, function11111111118, z111114, menuItemColorsItemColors, MenuDefaults.INSTANCE.itemShapes(shape, null, composerStartRestartGroup, ((i15 >> 6) & 14) | 384, 2), paddingValues3, mutableInteractionSource3, composer2, (i1111116 & 112) | 196614 | (i1111116 & 896) | (57344 & i15) | (3670016 & i1111116) | (29360128 & i1111116) | (i1111116 & 234881024), (i15 >> 24) & 126);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier2;
                        function7 = function11111111117;
                        function8 = function11111111118;
                        z4 = z111114;
                        menuItemColors2 = menuItemColorsItemColors;
                        paddingValues2 = paddingValues3;
                        mutableInteractionSource2 = mutableInteractionSource3;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        menuItemColors2 = menuItemColors;
                        mutableInteractionSource2 = mutableInteractionSource;
                        modifier3 = modifier2;
                        function7 = function5;
                        function8 = function6;
                        z4 = z2;
                        paddingValues2 = paddingValues;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda30
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return MenuKt.DropdownMenuItem$lambda$1(function0, function2, shape, modifier3, function7, function8, z4, menuItemColors2, paddingValues2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= 100663296;
                i12 = i2 & 512;
                if (i12 != 0) {
                    if ((i & 805306368) == 0) {
                        if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                            i13 = C.BUFFER_FLAG_LAST_SAMPLE;
                        } else {
                            i13 = 268435456;
                        }
                        i3 |= i13;
                    }
                    i14 = i3;
                    if ((i3 & 306783379) != 306783378) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z3, i14 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "336@16371L12");
                        if ((i & 1) != 0) {
                            if (i16 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                function5 = null;
                            }
                            if (i6 != 0) {
                                function6 = null;
                            }
                            if (i8 != 0) {
                                z2 = true;
                            }
                            if ((i2 & 128) != 0) {
                                menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                                i15 = i14 & (-29360129);
                            } else {
                                menuItemColorsItemColors = menuItemColors;
                                i15 = i14;
                            }
                            if (i10 != 0) {
                                dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                            } else {
                                dropdownMenuItemContentPadding = paddingValues;
                            }
                            if (i12 != 0) {
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            paddingValues3 = dropdownMenuItemContentPadding;
                        } else {
                            if (i16 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                function5 = null;
                            }
                            if (i6 != 0) {
                                function6 = null;
                            }
                            if (i8 != 0) {
                                z2 = true;
                            }
                            if ((i2 & 128) != 0) {
                                menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                                i15 = i14 & (-29360129);
                            } else {
                                menuItemColorsItemColors = menuItemColors;
                                i15 = i14;
                            }
                            if (i10 != 0) {
                                dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                            } else {
                                dropdownMenuItemContentPadding = paddingValues;
                            }
                            if (i12 != 0) {
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            paddingValues3 = dropdownMenuItemContentPadding;
                        }
                        Function2<? super Composer, ? super Integer, Unit> function11111111119 = function5;
                        Function2<? super Composer, ? super Integer, Unit> function111111111110 = function6;
                        boolean z111115 = z2;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(70219170, i15, -1, "androidx.compose.material3.DropdownMenuItem (Menu.kt:339)");
                        }
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1238834984, "CC(remember):Menu.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new Function1() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda29
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return MenuKt.DropdownMenuItem$lambda$0$0((SemanticsPropertyReceiver) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composer2 = composerStartRestartGroup;
                        int i1111117 = i15 << 3;
                        DropdownMenuItemContent(false, function0, function2, SemanticsModifierKt.semantics$default(modifier2, false, (Function1) objRememberedValue, 1, null), function11111111119, null, function111111111110, z111115, menuItemColorsItemColors, MenuDefaults.INSTANCE.itemShapes(shape, null, composerStartRestartGroup, ((i15 >> 6) & 14) | 384, 2), paddingValues3, mutableInteractionSource3, composer2, (i1111117 & 112) | 196614 | (i1111117 & 896) | (57344 & i15) | (3670016 & i1111117) | (29360128 & i1111117) | (i1111117 & 234881024), (i15 >> 24) & 126);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier2;
                        function7 = function11111111119;
                        function8 = function111111111110;
                        z4 = z111115;
                        menuItemColors2 = menuItemColorsItemColors;
                        paddingValues2 = paddingValues3;
                        mutableInteractionSource2 = mutableInteractionSource3;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        menuItemColors2 = menuItemColors;
                        mutableInteractionSource2 = mutableInteractionSource;
                        modifier3 = modifier2;
                        function7 = function5;
                        function8 = function6;
                        z4 = z2;
                        paddingValues2 = paddingValues;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda30
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return MenuKt.DropdownMenuItem$lambda$1(function0, function2, shape, modifier3, function7, function8, z4, menuItemColors2, paddingValues2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= 805306368;
                i14 = i3;
                if ((i3 & 306783379) != 306783378) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i14 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "336@16371L12");
                    if ((i & 1) != 0) {
                        if (i16 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            function5 = null;
                        }
                        if (i6 != 0) {
                            function6 = null;
                        }
                        if (i8 != 0) {
                            z2 = true;
                        }
                        if ((i2 & 128) != 0) {
                            menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                            i15 = i14 & (-29360129);
                        } else {
                            menuItemColorsItemColors = menuItemColors;
                            i15 = i14;
                        }
                        if (i10 != 0) {
                            dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                        } else {
                            dropdownMenuItemContentPadding = paddingValues;
                        }
                        if (i12 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        paddingValues3 = dropdownMenuItemContentPadding;
                    } else {
                        if (i16 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            function5 = null;
                        }
                        if (i6 != 0) {
                            function6 = null;
                        }
                        if (i8 != 0) {
                            z2 = true;
                        }
                        if ((i2 & 128) != 0) {
                            menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                            i15 = i14 & (-29360129);
                        } else {
                            menuItemColorsItemColors = menuItemColors;
                            i15 = i14;
                        }
                        if (i10 != 0) {
                            dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                        } else {
                            dropdownMenuItemContentPadding = paddingValues;
                        }
                        if (i12 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        paddingValues3 = dropdownMenuItemContentPadding;
                    }
                    Function2<? super Composer, ? super Integer, Unit> function111111111111 = function5;
                    Function2<? super Composer, ? super Integer, Unit> function111111111112 = function6;
                    boolean z111116 = z2;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(70219170, i15, -1, "androidx.compose.material3.DropdownMenuItem (Menu.kt:339)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1238834984, "CC(remember):Menu.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new Function1() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda29
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return MenuKt.DropdownMenuItem$lambda$0$0((SemanticsPropertyReceiver) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composer2 = composerStartRestartGroup;
                    int i1111118 = i15 << 3;
                    DropdownMenuItemContent(false, function0, function2, SemanticsModifierKt.semantics$default(modifier2, false, (Function1) objRememberedValue, 1, null), function111111111111, null, function111111111112, z111116, menuItemColorsItemColors, MenuDefaults.INSTANCE.itemShapes(shape, null, composerStartRestartGroup, ((i15 >> 6) & 14) | 384, 2), paddingValues3, mutableInteractionSource3, composer2, (i1111118 & 112) | 196614 | (i1111118 & 896) | (57344 & i15) | (3670016 & i1111118) | (29360128 & i1111118) | (i1111118 & 234881024), (i15 >> 24) & 126);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                    function7 = function111111111111;
                    function8 = function111111111112;
                    z4 = z111116;
                    menuItemColors2 = menuItemColorsItemColors;
                    paddingValues2 = paddingValues3;
                    mutableInteractionSource2 = mutableInteractionSource3;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    menuItemColors2 = menuItemColors;
                    mutableInteractionSource2 = mutableInteractionSource;
                    modifier3 = modifier2;
                    function7 = function5;
                    function8 = function6;
                    z4 = z2;
                    paddingValues2 = paddingValues;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda30
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return MenuKt.DropdownMenuItem$lambda$1(function0, function2, shape, modifier3, function7, function8, z4, menuItemColors2, paddingValues2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 1572864;
            z2 = z;
            if ((i & 12582912) != 0) {
                i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(menuItemColors)) ? 4194304 : 8388608;
            }
            i10 = i2 & 256;
            if (i10 != 0) {
                if ((i & 100663296) == 0) {
                    if (composerStartRestartGroup.changed(paddingValues)) {
                        i11 = 67108864;
                    } else {
                        i11 = 33554432;
                    }
                    i3 |= i11;
                }
                i12 = i2 & 512;
                if (i12 != 0) {
                    if ((i & 805306368) == 0) {
                        if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                            i13 = C.BUFFER_FLAG_LAST_SAMPLE;
                        } else {
                            i13 = 268435456;
                        }
                        i3 |= i13;
                    }
                    i14 = i3;
                    if ((i3 & 306783379) != 306783378) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z3, i14 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "336@16371L12");
                        if ((i & 1) != 0) {
                            if (i16 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                function5 = null;
                            }
                            if (i6 != 0) {
                                function6 = null;
                            }
                            if (i8 != 0) {
                                z2 = true;
                            }
                            if ((i2 & 128) != 0) {
                                menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                                i15 = i14 & (-29360129);
                            } else {
                                menuItemColorsItemColors = menuItemColors;
                                i15 = i14;
                            }
                            if (i10 != 0) {
                                dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                            } else {
                                dropdownMenuItemContentPadding = paddingValues;
                            }
                            if (i12 != 0) {
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            paddingValues3 = dropdownMenuItemContentPadding;
                        } else {
                            if (i16 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                function5 = null;
                            }
                            if (i6 != 0) {
                                function6 = null;
                            }
                            if (i8 != 0) {
                                z2 = true;
                            }
                            if ((i2 & 128) != 0) {
                                menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                                i15 = i14 & (-29360129);
                            } else {
                                menuItemColorsItemColors = menuItemColors;
                                i15 = i14;
                            }
                            if (i10 != 0) {
                                dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                            } else {
                                dropdownMenuItemContentPadding = paddingValues;
                            }
                            if (i12 != 0) {
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            paddingValues3 = dropdownMenuItemContentPadding;
                        }
                        Function2<? super Composer, ? super Integer, Unit> function111111111113 = function5;
                        Function2<? super Composer, ? super Integer, Unit> function111111111114 = function6;
                        boolean z111117 = z2;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(70219170, i15, -1, "androidx.compose.material3.DropdownMenuItem (Menu.kt:339)");
                        }
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1238834984, "CC(remember):Menu.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new Function1() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda29
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return MenuKt.DropdownMenuItem$lambda$0$0((SemanticsPropertyReceiver) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composer2 = composerStartRestartGroup;
                        int i1111119 = i15 << 3;
                        DropdownMenuItemContent(false, function0, function2, SemanticsModifierKt.semantics$default(modifier2, false, (Function1) objRememberedValue, 1, null), function111111111113, null, function111111111114, z111117, menuItemColorsItemColors, MenuDefaults.INSTANCE.itemShapes(shape, null, composerStartRestartGroup, ((i15 >> 6) & 14) | 384, 2), paddingValues3, mutableInteractionSource3, composer2, (i1111119 & 112) | 196614 | (i1111119 & 896) | (57344 & i15) | (3670016 & i1111119) | (29360128 & i1111119) | (i1111119 & 234881024), (i15 >> 24) & 126);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier2;
                        function7 = function111111111113;
                        function8 = function111111111114;
                        z4 = z111117;
                        menuItemColors2 = menuItemColorsItemColors;
                        paddingValues2 = paddingValues3;
                        mutableInteractionSource2 = mutableInteractionSource3;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        menuItemColors2 = menuItemColors;
                        mutableInteractionSource2 = mutableInteractionSource;
                        modifier3 = modifier2;
                        function7 = function5;
                        function8 = function6;
                        z4 = z2;
                        paddingValues2 = paddingValues;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda30
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return MenuKt.DropdownMenuItem$lambda$1(function0, function2, shape, modifier3, function7, function8, z4, menuItemColors2, paddingValues2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= 805306368;
                i14 = i3;
                if ((i3 & 306783379) != 306783378) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i14 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "336@16371L12");
                    if ((i & 1) != 0) {
                        if (i16 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            function5 = null;
                        }
                        if (i6 != 0) {
                            function6 = null;
                        }
                        if (i8 != 0) {
                            z2 = true;
                        }
                        if ((i2 & 128) != 0) {
                            menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                            i15 = i14 & (-29360129);
                        } else {
                            menuItemColorsItemColors = menuItemColors;
                            i15 = i14;
                        }
                        if (i10 != 0) {
                            dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                        } else {
                            dropdownMenuItemContentPadding = paddingValues;
                        }
                        if (i12 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        paddingValues3 = dropdownMenuItemContentPadding;
                    } else {
                        if (i16 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            function5 = null;
                        }
                        if (i6 != 0) {
                            function6 = null;
                        }
                        if (i8 != 0) {
                            z2 = true;
                        }
                        if ((i2 & 128) != 0) {
                            menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                            i15 = i14 & (-29360129);
                        } else {
                            menuItemColorsItemColors = menuItemColors;
                            i15 = i14;
                        }
                        if (i10 != 0) {
                            dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                        } else {
                            dropdownMenuItemContentPadding = paddingValues;
                        }
                        if (i12 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        paddingValues3 = dropdownMenuItemContentPadding;
                    }
                    Function2<? super Composer, ? super Integer, Unit> function111111111115 = function5;
                    Function2<? super Composer, ? super Integer, Unit> function111111111116 = function6;
                    boolean z111118 = z2;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(70219170, i15, -1, "androidx.compose.material3.DropdownMenuItem (Menu.kt:339)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1238834984, "CC(remember):Menu.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new Function1() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda29
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return MenuKt.DropdownMenuItem$lambda$0$0((SemanticsPropertyReceiver) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composer2 = composerStartRestartGroup;
                    int i11111110 = i15 << 3;
                    DropdownMenuItemContent(false, function0, function2, SemanticsModifierKt.semantics$default(modifier2, false, (Function1) objRememberedValue, 1, null), function111111111115, null, function111111111116, z111118, menuItemColorsItemColors, MenuDefaults.INSTANCE.itemShapes(shape, null, composerStartRestartGroup, ((i15 >> 6) & 14) | 384, 2), paddingValues3, mutableInteractionSource3, composer2, (i11111110 & 112) | 196614 | (i11111110 & 896) | (57344 & i15) | (3670016 & i11111110) | (29360128 & i11111110) | (i11111110 & 234881024), (i15 >> 24) & 126);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                    function7 = function111111111115;
                    function8 = function111111111116;
                    z4 = z111118;
                    menuItemColors2 = menuItemColorsItemColors;
                    paddingValues2 = paddingValues3;
                    mutableInteractionSource2 = mutableInteractionSource3;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    menuItemColors2 = menuItemColors;
                    mutableInteractionSource2 = mutableInteractionSource;
                    modifier3 = modifier2;
                    function7 = function5;
                    function8 = function6;
                    z4 = z2;
                    paddingValues2 = paddingValues;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda30
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return MenuKt.DropdownMenuItem$lambda$1(function0, function2, shape, modifier3, function7, function8, z4, menuItemColors2, paddingValues2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 100663296;
            i12 = i2 & 512;
            if (i12 != 0) {
                if ((i & 805306368) == 0) {
                    if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                        i13 = C.BUFFER_FLAG_LAST_SAMPLE;
                    } else {
                        i13 = 268435456;
                    }
                    i3 |= i13;
                }
                i14 = i3;
                if ((i3 & 306783379) != 306783378) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i14 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "336@16371L12");
                    if ((i & 1) != 0) {
                        if (i16 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            function5 = null;
                        }
                        if (i6 != 0) {
                            function6 = null;
                        }
                        if (i8 != 0) {
                            z2 = true;
                        }
                        if ((i2 & 128) != 0) {
                            menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                            i15 = i14 & (-29360129);
                        } else {
                            menuItemColorsItemColors = menuItemColors;
                            i15 = i14;
                        }
                        if (i10 != 0) {
                            dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                        } else {
                            dropdownMenuItemContentPadding = paddingValues;
                        }
                        if (i12 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        paddingValues3 = dropdownMenuItemContentPadding;
                    } else {
                        if (i16 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            function5 = null;
                        }
                        if (i6 != 0) {
                            function6 = null;
                        }
                        if (i8 != 0) {
                            z2 = true;
                        }
                        if ((i2 & 128) != 0) {
                            menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                            i15 = i14 & (-29360129);
                        } else {
                            menuItemColorsItemColors = menuItemColors;
                            i15 = i14;
                        }
                        if (i10 != 0) {
                            dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                        } else {
                            dropdownMenuItemContentPadding = paddingValues;
                        }
                        if (i12 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        paddingValues3 = dropdownMenuItemContentPadding;
                    }
                    Function2<? super Composer, ? super Integer, Unit> function111111111117 = function5;
                    Function2<? super Composer, ? super Integer, Unit> function111111111118 = function6;
                    boolean z111119 = z2;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(70219170, i15, -1, "androidx.compose.material3.DropdownMenuItem (Menu.kt:339)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1238834984, "CC(remember):Menu.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new Function1() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda29
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return MenuKt.DropdownMenuItem$lambda$0$0((SemanticsPropertyReceiver) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composer2 = composerStartRestartGroup;
                    int i11111111 = i15 << 3;
                    DropdownMenuItemContent(false, function0, function2, SemanticsModifierKt.semantics$default(modifier2, false, (Function1) objRememberedValue, 1, null), function111111111117, null, function111111111118, z111119, menuItemColorsItemColors, MenuDefaults.INSTANCE.itemShapes(shape, null, composerStartRestartGroup, ((i15 >> 6) & 14) | 384, 2), paddingValues3, mutableInteractionSource3, composer2, (i11111111 & 112) | 196614 | (i11111111 & 896) | (57344 & i15) | (3670016 & i11111111) | (29360128 & i11111111) | (i11111111 & 234881024), (i15 >> 24) & 126);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                    function7 = function111111111117;
                    function8 = function111111111118;
                    z4 = z111119;
                    menuItemColors2 = menuItemColorsItemColors;
                    paddingValues2 = paddingValues3;
                    mutableInteractionSource2 = mutableInteractionSource3;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    menuItemColors2 = menuItemColors;
                    mutableInteractionSource2 = mutableInteractionSource;
                    modifier3 = modifier2;
                    function7 = function5;
                    function8 = function6;
                    z4 = z2;
                    paddingValues2 = paddingValues;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda30
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return MenuKt.DropdownMenuItem$lambda$1(function0, function2, shape, modifier3, function7, function8, z4, menuItemColors2, paddingValues2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 805306368;
            i14 = i3;
            if ((i3 & 306783379) != 306783378) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i14 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "336@16371L12");
                if ((i & 1) != 0) {
                    if (i16 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        function5 = null;
                    }
                    if (i6 != 0) {
                        function6 = null;
                    }
                    if (i8 != 0) {
                        z2 = true;
                    }
                    if ((i2 & 128) != 0) {
                        menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                        i15 = i14 & (-29360129);
                    } else {
                        menuItemColorsItemColors = menuItemColors;
                        i15 = i14;
                    }
                    if (i10 != 0) {
                        dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                    } else {
                        dropdownMenuItemContentPadding = paddingValues;
                    }
                    if (i12 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    paddingValues3 = dropdownMenuItemContentPadding;
                } else {
                    if (i16 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        function5 = null;
                    }
                    if (i6 != 0) {
                        function6 = null;
                    }
                    if (i8 != 0) {
                        z2 = true;
                    }
                    if ((i2 & 128) != 0) {
                        menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                        i15 = i14 & (-29360129);
                    } else {
                        menuItemColorsItemColors = menuItemColors;
                        i15 = i14;
                    }
                    if (i10 != 0) {
                        dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                    } else {
                        dropdownMenuItemContentPadding = paddingValues;
                    }
                    if (i12 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    paddingValues3 = dropdownMenuItemContentPadding;
                }
                Function2<? super Composer, ? super Integer, Unit> function111111111119 = function5;
                Function2<? super Composer, ? super Integer, Unit> function1111111111110 = function6;
                boolean z1111110 = z2;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(70219170, i15, -1, "androidx.compose.material3.DropdownMenuItem (Menu.kt:339)");
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1238834984, "CC(remember):Menu.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function1() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda29
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return MenuKt.DropdownMenuItem$lambda$0$0((SemanticsPropertyReceiver) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composer2 = composerStartRestartGroup;
                int i11111112 = i15 << 3;
                DropdownMenuItemContent(false, function0, function2, SemanticsModifierKt.semantics$default(modifier2, false, (Function1) objRememberedValue, 1, null), function111111111119, null, function1111111111110, z1111110, menuItemColorsItemColors, MenuDefaults.INSTANCE.itemShapes(shape, null, composerStartRestartGroup, ((i15 >> 6) & 14) | 384, 2), paddingValues3, mutableInteractionSource3, composer2, (i11111112 & 112) | 196614 | (i11111112 & 896) | (57344 & i15) | (3670016 & i11111112) | (29360128 & i11111112) | (i11111112 & 234881024), (i15 >> 24) & 126);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier2;
                function7 = function111111111119;
                function8 = function1111111111110;
                z4 = z1111110;
                menuItemColors2 = menuItemColorsItemColors;
                paddingValues2 = paddingValues3;
                mutableInteractionSource2 = mutableInteractionSource3;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                menuItemColors2 = menuItemColors;
                mutableInteractionSource2 = mutableInteractionSource;
                modifier3 = modifier2;
                function7 = function5;
                function8 = function6;
                z4 = z2;
                paddingValues2 = paddingValues;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda30
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return MenuKt.DropdownMenuItem$lambda$1(function0, function2, shape, modifier3, function7, function8, z4, menuItemColors2, paddingValues2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        function6 = function4;
        i8 = i2 & 64;
        if (i8 != 0) {
            if ((1572864 & i) == 0) {
                z2 = z;
                if (composerStartRestartGroup.changed(z2)) {
                    i9 = 1048576;
                } else {
                    i9 = 524288;
                }
                i3 |= i9;
            }
            if ((i & 12582912) != 0) {
                i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(menuItemColors)) ? 4194304 : 8388608;
            }
            i10 = i2 & 256;
            if (i10 != 0) {
                if ((i & 100663296) == 0) {
                    if (composerStartRestartGroup.changed(paddingValues)) {
                        i11 = 67108864;
                    } else {
                        i11 = 33554432;
                    }
                    i3 |= i11;
                }
                i12 = i2 & 512;
                if (i12 != 0) {
                    if ((i & 805306368) == 0) {
                        if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                            i13 = C.BUFFER_FLAG_LAST_SAMPLE;
                        } else {
                            i13 = 268435456;
                        }
                        i3 |= i13;
                    }
                    i14 = i3;
                    if ((i3 & 306783379) != 306783378) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z3, i14 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "336@16371L12");
                        if ((i & 1) != 0) {
                            if (i16 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                function5 = null;
                            }
                            if (i6 != 0) {
                                function6 = null;
                            }
                            if (i8 != 0) {
                                z2 = true;
                            }
                            if ((i2 & 128) != 0) {
                                menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                                i15 = i14 & (-29360129);
                            } else {
                                menuItemColorsItemColors = menuItemColors;
                                i15 = i14;
                            }
                            if (i10 != 0) {
                                dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                            } else {
                                dropdownMenuItemContentPadding = paddingValues;
                            }
                            if (i12 != 0) {
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            paddingValues3 = dropdownMenuItemContentPadding;
                        } else {
                            if (i16 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                function5 = null;
                            }
                            if (i6 != 0) {
                                function6 = null;
                            }
                            if (i8 != 0) {
                                z2 = true;
                            }
                            if ((i2 & 128) != 0) {
                                menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                                i15 = i14 & (-29360129);
                            } else {
                                menuItemColorsItemColors = menuItemColors;
                                i15 = i14;
                            }
                            if (i10 != 0) {
                                dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                            } else {
                                dropdownMenuItemContentPadding = paddingValues;
                            }
                            if (i12 != 0) {
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            paddingValues3 = dropdownMenuItemContentPadding;
                        }
                        Function2<? super Composer, ? super Integer, Unit> function1111111111111 = function5;
                        Function2<? super Composer, ? super Integer, Unit> function1111111111112 = function6;
                        boolean z1111111 = z2;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(70219170, i15, -1, "androidx.compose.material3.DropdownMenuItem (Menu.kt:339)");
                        }
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1238834984, "CC(remember):Menu.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new Function1() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda29
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return MenuKt.DropdownMenuItem$lambda$0$0((SemanticsPropertyReceiver) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composer2 = composerStartRestartGroup;
                        int i11111113 = i15 << 3;
                        DropdownMenuItemContent(false, function0, function2, SemanticsModifierKt.semantics$default(modifier2, false, (Function1) objRememberedValue, 1, null), function1111111111111, null, function1111111111112, z1111111, menuItemColorsItemColors, MenuDefaults.INSTANCE.itemShapes(shape, null, composerStartRestartGroup, ((i15 >> 6) & 14) | 384, 2), paddingValues3, mutableInteractionSource3, composer2, (i11111113 & 112) | 196614 | (i11111113 & 896) | (57344 & i15) | (3670016 & i11111113) | (29360128 & i11111113) | (i11111113 & 234881024), (i15 >> 24) & 126);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier2;
                        function7 = function1111111111111;
                        function8 = function1111111111112;
                        z4 = z1111111;
                        menuItemColors2 = menuItemColorsItemColors;
                        paddingValues2 = paddingValues3;
                        mutableInteractionSource2 = mutableInteractionSource3;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        menuItemColors2 = menuItemColors;
                        mutableInteractionSource2 = mutableInteractionSource;
                        modifier3 = modifier2;
                        function7 = function5;
                        function8 = function6;
                        z4 = z2;
                        paddingValues2 = paddingValues;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda30
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return MenuKt.DropdownMenuItem$lambda$1(function0, function2, shape, modifier3, function7, function8, z4, menuItemColors2, paddingValues2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= 805306368;
                i14 = i3;
                if ((i3 & 306783379) != 306783378) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i14 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "336@16371L12");
                    if ((i & 1) != 0) {
                        if (i16 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            function5 = null;
                        }
                        if (i6 != 0) {
                            function6 = null;
                        }
                        if (i8 != 0) {
                            z2 = true;
                        }
                        if ((i2 & 128) != 0) {
                            menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                            i15 = i14 & (-29360129);
                        } else {
                            menuItemColorsItemColors = menuItemColors;
                            i15 = i14;
                        }
                        if (i10 != 0) {
                            dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                        } else {
                            dropdownMenuItemContentPadding = paddingValues;
                        }
                        if (i12 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        paddingValues3 = dropdownMenuItemContentPadding;
                    } else {
                        if (i16 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            function5 = null;
                        }
                        if (i6 != 0) {
                            function6 = null;
                        }
                        if (i8 != 0) {
                            z2 = true;
                        }
                        if ((i2 & 128) != 0) {
                            menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                            i15 = i14 & (-29360129);
                        } else {
                            menuItemColorsItemColors = menuItemColors;
                            i15 = i14;
                        }
                        if (i10 != 0) {
                            dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                        } else {
                            dropdownMenuItemContentPadding = paddingValues;
                        }
                        if (i12 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        paddingValues3 = dropdownMenuItemContentPadding;
                    }
                    Function2<? super Composer, ? super Integer, Unit> function1111111111113 = function5;
                    Function2<? super Composer, ? super Integer, Unit> function1111111111114 = function6;
                    boolean z1111112 = z2;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(70219170, i15, -1, "androidx.compose.material3.DropdownMenuItem (Menu.kt:339)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1238834984, "CC(remember):Menu.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new Function1() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda29
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return MenuKt.DropdownMenuItem$lambda$0$0((SemanticsPropertyReceiver) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composer2 = composerStartRestartGroup;
                    int i11111114 = i15 << 3;
                    DropdownMenuItemContent(false, function0, function2, SemanticsModifierKt.semantics$default(modifier2, false, (Function1) objRememberedValue, 1, null), function1111111111113, null, function1111111111114, z1111112, menuItemColorsItemColors, MenuDefaults.INSTANCE.itemShapes(shape, null, composerStartRestartGroup, ((i15 >> 6) & 14) | 384, 2), paddingValues3, mutableInteractionSource3, composer2, (i11111114 & 112) | 196614 | (i11111114 & 896) | (57344 & i15) | (3670016 & i11111114) | (29360128 & i11111114) | (i11111114 & 234881024), (i15 >> 24) & 126);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                    function7 = function1111111111113;
                    function8 = function1111111111114;
                    z4 = z1111112;
                    menuItemColors2 = menuItemColorsItemColors;
                    paddingValues2 = paddingValues3;
                    mutableInteractionSource2 = mutableInteractionSource3;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    menuItemColors2 = menuItemColors;
                    mutableInteractionSource2 = mutableInteractionSource;
                    modifier3 = modifier2;
                    function7 = function5;
                    function8 = function6;
                    z4 = z2;
                    paddingValues2 = paddingValues;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda30
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return MenuKt.DropdownMenuItem$lambda$1(function0, function2, shape, modifier3, function7, function8, z4, menuItemColors2, paddingValues2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 100663296;
            i12 = i2 & 512;
            if (i12 != 0) {
                if ((i & 805306368) == 0) {
                    if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                        i13 = C.BUFFER_FLAG_LAST_SAMPLE;
                    } else {
                        i13 = 268435456;
                    }
                    i3 |= i13;
                }
                i14 = i3;
                if ((i3 & 306783379) != 306783378) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i14 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "336@16371L12");
                    if ((i & 1) != 0) {
                        if (i16 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            function5 = null;
                        }
                        if (i6 != 0) {
                            function6 = null;
                        }
                        if (i8 != 0) {
                            z2 = true;
                        }
                        if ((i2 & 128) != 0) {
                            menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                            i15 = i14 & (-29360129);
                        } else {
                            menuItemColorsItemColors = menuItemColors;
                            i15 = i14;
                        }
                        if (i10 != 0) {
                            dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                        } else {
                            dropdownMenuItemContentPadding = paddingValues;
                        }
                        if (i12 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        paddingValues3 = dropdownMenuItemContentPadding;
                    } else {
                        if (i16 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            function5 = null;
                        }
                        if (i6 != 0) {
                            function6 = null;
                        }
                        if (i8 != 0) {
                            z2 = true;
                        }
                        if ((i2 & 128) != 0) {
                            menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                            i15 = i14 & (-29360129);
                        } else {
                            menuItemColorsItemColors = menuItemColors;
                            i15 = i14;
                        }
                        if (i10 != 0) {
                            dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                        } else {
                            dropdownMenuItemContentPadding = paddingValues;
                        }
                        if (i12 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        paddingValues3 = dropdownMenuItemContentPadding;
                    }
                    Function2<? super Composer, ? super Integer, Unit> function1111111111115 = function5;
                    Function2<? super Composer, ? super Integer, Unit> function1111111111116 = function6;
                    boolean z1111113 = z2;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(70219170, i15, -1, "androidx.compose.material3.DropdownMenuItem (Menu.kt:339)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1238834984, "CC(remember):Menu.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new Function1() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda29
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return MenuKt.DropdownMenuItem$lambda$0$0((SemanticsPropertyReceiver) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composer2 = composerStartRestartGroup;
                    int i11111115 = i15 << 3;
                    DropdownMenuItemContent(false, function0, function2, SemanticsModifierKt.semantics$default(modifier2, false, (Function1) objRememberedValue, 1, null), function1111111111115, null, function1111111111116, z1111113, menuItemColorsItemColors, MenuDefaults.INSTANCE.itemShapes(shape, null, composerStartRestartGroup, ((i15 >> 6) & 14) | 384, 2), paddingValues3, mutableInteractionSource3, composer2, (i11111115 & 112) | 196614 | (i11111115 & 896) | (57344 & i15) | (3670016 & i11111115) | (29360128 & i11111115) | (i11111115 & 234881024), (i15 >> 24) & 126);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                    function7 = function1111111111115;
                    function8 = function1111111111116;
                    z4 = z1111113;
                    menuItemColors2 = menuItemColorsItemColors;
                    paddingValues2 = paddingValues3;
                    mutableInteractionSource2 = mutableInteractionSource3;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    menuItemColors2 = menuItemColors;
                    mutableInteractionSource2 = mutableInteractionSource;
                    modifier3 = modifier2;
                    function7 = function5;
                    function8 = function6;
                    z4 = z2;
                    paddingValues2 = paddingValues;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda30
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return MenuKt.DropdownMenuItem$lambda$1(function0, function2, shape, modifier3, function7, function8, z4, menuItemColors2, paddingValues2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 805306368;
            i14 = i3;
            if ((i3 & 306783379) != 306783378) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i14 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "336@16371L12");
                if ((i & 1) != 0) {
                    if (i16 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        function5 = null;
                    }
                    if (i6 != 0) {
                        function6 = null;
                    }
                    if (i8 != 0) {
                        z2 = true;
                    }
                    if ((i2 & 128) != 0) {
                        menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                        i15 = i14 & (-29360129);
                    } else {
                        menuItemColorsItemColors = menuItemColors;
                        i15 = i14;
                    }
                    if (i10 != 0) {
                        dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                    } else {
                        dropdownMenuItemContentPadding = paddingValues;
                    }
                    if (i12 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    paddingValues3 = dropdownMenuItemContentPadding;
                } else {
                    if (i16 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        function5 = null;
                    }
                    if (i6 != 0) {
                        function6 = null;
                    }
                    if (i8 != 0) {
                        z2 = true;
                    }
                    if ((i2 & 128) != 0) {
                        menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                        i15 = i14 & (-29360129);
                    } else {
                        menuItemColorsItemColors = menuItemColors;
                        i15 = i14;
                    }
                    if (i10 != 0) {
                        dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                    } else {
                        dropdownMenuItemContentPadding = paddingValues;
                    }
                    if (i12 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    paddingValues3 = dropdownMenuItemContentPadding;
                }
                Function2<? super Composer, ? super Integer, Unit> function1111111111117 = function5;
                Function2<? super Composer, ? super Integer, Unit> function1111111111118 = function6;
                boolean z1111114 = z2;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(70219170, i15, -1, "androidx.compose.material3.DropdownMenuItem (Menu.kt:339)");
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1238834984, "CC(remember):Menu.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function1() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda29
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return MenuKt.DropdownMenuItem$lambda$0$0((SemanticsPropertyReceiver) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composer2 = composerStartRestartGroup;
                int i11111116 = i15 << 3;
                DropdownMenuItemContent(false, function0, function2, SemanticsModifierKt.semantics$default(modifier2, false, (Function1) objRememberedValue, 1, null), function1111111111117, null, function1111111111118, z1111114, menuItemColorsItemColors, MenuDefaults.INSTANCE.itemShapes(shape, null, composerStartRestartGroup, ((i15 >> 6) & 14) | 384, 2), paddingValues3, mutableInteractionSource3, composer2, (i11111116 & 112) | 196614 | (i11111116 & 896) | (57344 & i15) | (3670016 & i11111116) | (29360128 & i11111116) | (i11111116 & 234881024), (i15 >> 24) & 126);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier2;
                function7 = function1111111111117;
                function8 = function1111111111118;
                z4 = z1111114;
                menuItemColors2 = menuItemColorsItemColors;
                paddingValues2 = paddingValues3;
                mutableInteractionSource2 = mutableInteractionSource3;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                menuItemColors2 = menuItemColors;
                mutableInteractionSource2 = mutableInteractionSource;
                modifier3 = modifier2;
                function7 = function5;
                function8 = function6;
                z4 = z2;
                paddingValues2 = paddingValues;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda30
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return MenuKt.DropdownMenuItem$lambda$1(function0, function2, shape, modifier3, function7, function8, z4, menuItemColors2, paddingValues2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 1572864;
        z2 = z;
        if ((i & 12582912) != 0) {
            i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(menuItemColors)) ? 4194304 : 8388608;
        }
        i10 = i2 & 256;
        if (i10 != 0) {
            if ((i & 100663296) == 0) {
                if (composerStartRestartGroup.changed(paddingValues)) {
                    i11 = 67108864;
                } else {
                    i11 = 33554432;
                }
                i3 |= i11;
            }
            i12 = i2 & 512;
            if (i12 != 0) {
                if ((i & 805306368) == 0) {
                    if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                        i13 = C.BUFFER_FLAG_LAST_SAMPLE;
                    } else {
                        i13 = 268435456;
                    }
                    i3 |= i13;
                }
                i14 = i3;
                if ((i3 & 306783379) != 306783378) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i14 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "336@16371L12");
                    if ((i & 1) != 0) {
                        if (i16 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            function5 = null;
                        }
                        if (i6 != 0) {
                            function6 = null;
                        }
                        if (i8 != 0) {
                            z2 = true;
                        }
                        if ((i2 & 128) != 0) {
                            menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                            i15 = i14 & (-29360129);
                        } else {
                            menuItemColorsItemColors = menuItemColors;
                            i15 = i14;
                        }
                        if (i10 != 0) {
                            dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                        } else {
                            dropdownMenuItemContentPadding = paddingValues;
                        }
                        if (i12 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        paddingValues3 = dropdownMenuItemContentPadding;
                    } else {
                        if (i16 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            function5 = null;
                        }
                        if (i6 != 0) {
                            function6 = null;
                        }
                        if (i8 != 0) {
                            z2 = true;
                        }
                        if ((i2 & 128) != 0) {
                            menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                            i15 = i14 & (-29360129);
                        } else {
                            menuItemColorsItemColors = menuItemColors;
                            i15 = i14;
                        }
                        if (i10 != 0) {
                            dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                        } else {
                            dropdownMenuItemContentPadding = paddingValues;
                        }
                        if (i12 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        paddingValues3 = dropdownMenuItemContentPadding;
                    }
                    Function2<? super Composer, ? super Integer, Unit> function1111111111119 = function5;
                    Function2<? super Composer, ? super Integer, Unit> function11111111111110 = function6;
                    boolean z1111115 = z2;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(70219170, i15, -1, "androidx.compose.material3.DropdownMenuItem (Menu.kt:339)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1238834984, "CC(remember):Menu.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new Function1() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda29
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return MenuKt.DropdownMenuItem$lambda$0$0((SemanticsPropertyReceiver) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composer2 = composerStartRestartGroup;
                    int i11111117 = i15 << 3;
                    DropdownMenuItemContent(false, function0, function2, SemanticsModifierKt.semantics$default(modifier2, false, (Function1) objRememberedValue, 1, null), function1111111111119, null, function11111111111110, z1111115, menuItemColorsItemColors, MenuDefaults.INSTANCE.itemShapes(shape, null, composerStartRestartGroup, ((i15 >> 6) & 14) | 384, 2), paddingValues3, mutableInteractionSource3, composer2, (i11111117 & 112) | 196614 | (i11111117 & 896) | (57344 & i15) | (3670016 & i11111117) | (29360128 & i11111117) | (i11111117 & 234881024), (i15 >> 24) & 126);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                    function7 = function1111111111119;
                    function8 = function11111111111110;
                    z4 = z1111115;
                    menuItemColors2 = menuItemColorsItemColors;
                    paddingValues2 = paddingValues3;
                    mutableInteractionSource2 = mutableInteractionSource3;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    menuItemColors2 = menuItemColors;
                    mutableInteractionSource2 = mutableInteractionSource;
                    modifier3 = modifier2;
                    function7 = function5;
                    function8 = function6;
                    z4 = z2;
                    paddingValues2 = paddingValues;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda30
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return MenuKt.DropdownMenuItem$lambda$1(function0, function2, shape, modifier3, function7, function8, z4, menuItemColors2, paddingValues2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 805306368;
            i14 = i3;
            if ((i3 & 306783379) != 306783378) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i14 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "336@16371L12");
                if ((i & 1) != 0) {
                    if (i16 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        function5 = null;
                    }
                    if (i6 != 0) {
                        function6 = null;
                    }
                    if (i8 != 0) {
                        z2 = true;
                    }
                    if ((i2 & 128) != 0) {
                        menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                        i15 = i14 & (-29360129);
                    } else {
                        menuItemColorsItemColors = menuItemColors;
                        i15 = i14;
                    }
                    if (i10 != 0) {
                        dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                    } else {
                        dropdownMenuItemContentPadding = paddingValues;
                    }
                    if (i12 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    paddingValues3 = dropdownMenuItemContentPadding;
                } else {
                    if (i16 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        function5 = null;
                    }
                    if (i6 != 0) {
                        function6 = null;
                    }
                    if (i8 != 0) {
                        z2 = true;
                    }
                    if ((i2 & 128) != 0) {
                        menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                        i15 = i14 & (-29360129);
                    } else {
                        menuItemColorsItemColors = menuItemColors;
                        i15 = i14;
                    }
                    if (i10 != 0) {
                        dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                    } else {
                        dropdownMenuItemContentPadding = paddingValues;
                    }
                    if (i12 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    paddingValues3 = dropdownMenuItemContentPadding;
                }
                Function2<? super Composer, ? super Integer, Unit> function11111111111111 = function5;
                Function2<? super Composer, ? super Integer, Unit> function11111111111112 = function6;
                boolean z1111116 = z2;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(70219170, i15, -1, "androidx.compose.material3.DropdownMenuItem (Menu.kt:339)");
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1238834984, "CC(remember):Menu.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function1() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda29
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return MenuKt.DropdownMenuItem$lambda$0$0((SemanticsPropertyReceiver) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composer2 = composerStartRestartGroup;
                int i11111118 = i15 << 3;
                DropdownMenuItemContent(false, function0, function2, SemanticsModifierKt.semantics$default(modifier2, false, (Function1) objRememberedValue, 1, null), function11111111111111, null, function11111111111112, z1111116, menuItemColorsItemColors, MenuDefaults.INSTANCE.itemShapes(shape, null, composerStartRestartGroup, ((i15 >> 6) & 14) | 384, 2), paddingValues3, mutableInteractionSource3, composer2, (i11111118 & 112) | 196614 | (i11111118 & 896) | (57344 & i15) | (3670016 & i11111118) | (29360128 & i11111118) | (i11111118 & 234881024), (i15 >> 24) & 126);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier2;
                function7 = function11111111111111;
                function8 = function11111111111112;
                z4 = z1111116;
                menuItemColors2 = menuItemColorsItemColors;
                paddingValues2 = paddingValues3;
                mutableInteractionSource2 = mutableInteractionSource3;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                menuItemColors2 = menuItemColors;
                mutableInteractionSource2 = mutableInteractionSource;
                modifier3 = modifier2;
                function7 = function5;
                function8 = function6;
                z4 = z2;
                paddingValues2 = paddingValues;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda30
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return MenuKt.DropdownMenuItem$lambda$1(function0, function2, shape, modifier3, function7, function8, z4, menuItemColors2, paddingValues2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 100663296;
        i12 = i2 & 512;
        if (i12 != 0) {
            if ((i & 805306368) == 0) {
                if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                    i13 = C.BUFFER_FLAG_LAST_SAMPLE;
                } else {
                    i13 = 268435456;
                }
                i3 |= i13;
            }
            i14 = i3;
            if ((i3 & 306783379) != 306783378) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i14 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "336@16371L12");
                if ((i & 1) != 0) {
                    if (i16 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        function5 = null;
                    }
                    if (i6 != 0) {
                        function6 = null;
                    }
                    if (i8 != 0) {
                        z2 = true;
                    }
                    if ((i2 & 128) != 0) {
                        menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                        i15 = i14 & (-29360129);
                    } else {
                        menuItemColorsItemColors = menuItemColors;
                        i15 = i14;
                    }
                    if (i10 != 0) {
                        dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                    } else {
                        dropdownMenuItemContentPadding = paddingValues;
                    }
                    if (i12 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    paddingValues3 = dropdownMenuItemContentPadding;
                } else {
                    if (i16 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        function5 = null;
                    }
                    if (i6 != 0) {
                        function6 = null;
                    }
                    if (i8 != 0) {
                        z2 = true;
                    }
                    if ((i2 & 128) != 0) {
                        menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                        i15 = i14 & (-29360129);
                    } else {
                        menuItemColorsItemColors = menuItemColors;
                        i15 = i14;
                    }
                    if (i10 != 0) {
                        dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                    } else {
                        dropdownMenuItemContentPadding = paddingValues;
                    }
                    if (i12 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    paddingValues3 = dropdownMenuItemContentPadding;
                }
                Function2<? super Composer, ? super Integer, Unit> function11111111111113 = function5;
                Function2<? super Composer, ? super Integer, Unit> function11111111111114 = function6;
                boolean z1111117 = z2;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(70219170, i15, -1, "androidx.compose.material3.DropdownMenuItem (Menu.kt:339)");
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1238834984, "CC(remember):Menu.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function1() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda29
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return MenuKt.DropdownMenuItem$lambda$0$0((SemanticsPropertyReceiver) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composer2 = composerStartRestartGroup;
                int i11111119 = i15 << 3;
                DropdownMenuItemContent(false, function0, function2, SemanticsModifierKt.semantics$default(modifier2, false, (Function1) objRememberedValue, 1, null), function11111111111113, null, function11111111111114, z1111117, menuItemColorsItemColors, MenuDefaults.INSTANCE.itemShapes(shape, null, composerStartRestartGroup, ((i15 >> 6) & 14) | 384, 2), paddingValues3, mutableInteractionSource3, composer2, (i11111119 & 112) | 196614 | (i11111119 & 896) | (57344 & i15) | (3670016 & i11111119) | (29360128 & i11111119) | (i11111119 & 234881024), (i15 >> 24) & 126);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier2;
                function7 = function11111111111113;
                function8 = function11111111111114;
                z4 = z1111117;
                menuItemColors2 = menuItemColorsItemColors;
                paddingValues2 = paddingValues3;
                mutableInteractionSource2 = mutableInteractionSource3;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                menuItemColors2 = menuItemColors;
                mutableInteractionSource2 = mutableInteractionSource;
                modifier3 = modifier2;
                function7 = function5;
                function8 = function6;
                z4 = z2;
                paddingValues2 = paddingValues;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda30
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return MenuKt.DropdownMenuItem$lambda$1(function0, function2, shape, modifier3, function7, function8, z4, menuItemColors2, paddingValues2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 805306368;
        i14 = i3;
        if ((i3 & 306783379) != 306783378) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z3, i14 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "336@16371L12");
            if ((i & 1) != 0) {
                if (i16 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i4 != 0) {
                    function5 = null;
                }
                if (i6 != 0) {
                    function6 = null;
                }
                if (i8 != 0) {
                    z2 = true;
                }
                if ((i2 & 128) != 0) {
                    menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                    i15 = i14 & (-29360129);
                } else {
                    menuItemColorsItemColors = menuItemColors;
                    i15 = i14;
                }
                if (i10 != 0) {
                    dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                } else {
                    dropdownMenuItemContentPadding = paddingValues;
                }
                if (i12 != 0) {
                    mutableInteractionSource3 = null;
                } else {
                    mutableInteractionSource3 = mutableInteractionSource;
                }
                paddingValues3 = dropdownMenuItemContentPadding;
            } else {
                if (i16 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i4 != 0) {
                    function5 = null;
                }
                if (i6 != 0) {
                    function6 = null;
                }
                if (i8 != 0) {
                    z2 = true;
                }
                if ((i2 & 128) != 0) {
                    menuItemColorsItemColors = MenuDefaults.INSTANCE.itemColors(composerStartRestartGroup, 6);
                    i15 = i14 & (-29360129);
                } else {
                    menuItemColorsItemColors = menuItemColors;
                    i15 = i14;
                }
                if (i10 != 0) {
                    dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                } else {
                    dropdownMenuItemContentPadding = paddingValues;
                }
                if (i12 != 0) {
                    mutableInteractionSource3 = null;
                } else {
                    mutableInteractionSource3 = mutableInteractionSource;
                }
                paddingValues3 = dropdownMenuItemContentPadding;
            }
            Function2<? super Composer, ? super Integer, Unit> function11111111111115 = function5;
            Function2<? super Composer, ? super Integer, Unit> function11111111111116 = function6;
            boolean z1111118 = z2;
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(70219170, i15, -1, "androidx.compose.material3.DropdownMenuItem (Menu.kt:339)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1238834984, "CC(remember):Menu.kt#9igjgp");
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda29
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return MenuKt.DropdownMenuItem$lambda$0$0((SemanticsPropertyReceiver) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composer2 = composerStartRestartGroup;
            int i111111110 = i15 << 3;
            DropdownMenuItemContent(false, function0, function2, SemanticsModifierKt.semantics$default(modifier2, false, (Function1) objRememberedValue, 1, null), function11111111111115, null, function11111111111116, z1111118, menuItemColorsItemColors, MenuDefaults.INSTANCE.itemShapes(shape, null, composerStartRestartGroup, ((i15 >> 6) & 14) | 384, 2), paddingValues3, mutableInteractionSource3, composer2, (i111111110 & 112) | 196614 | (i111111110 & 896) | (57344 & i15) | (3670016 & i111111110) | (29360128 & i111111110) | (i111111110 & 234881024), (i15 >> 24) & 126);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier2;
            function7 = function11111111111115;
            function8 = function11111111111116;
            z4 = z1111118;
            menuItemColors2 = menuItemColorsItemColors;
            paddingValues2 = paddingValues3;
            mutableInteractionSource2 = mutableInteractionSource3;
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            menuItemColors2 = menuItemColors;
            mutableInteractionSource2 = mutableInteractionSource;
            modifier3 = modifier2;
            function7 = function5;
            function8 = function6;
            z4 = z2;
            paddingValues2 = paddingValues;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda30
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return MenuKt.DropdownMenuItem$lambda$1(function0, function2, shape, modifier3, function7, function8, z4, menuItemColors2, paddingValues2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DropdownMenuItem$lambda$0$0(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.m8851setRolekuIjeqM(semanticsPropertyReceiver, Role.INSTANCE.m8832getButtono7Vup1c());
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0125  */
    /* JADX WARN: Code duplicated, block: B:102:0x012b  */
    /* JADX WARN: Code duplicated, block: B:103:0x012e  */
    /* JADX WARN: Code duplicated, block: B:105:0x0133  */
    /* JADX WARN: Code duplicated, block: B:108:0x0139  */
    /* JADX WARN: Code duplicated, block: B:109:0x013e  */
    /* JADX WARN: Code duplicated, block: B:111:0x0146  */
    /* JADX WARN: Code duplicated, block: B:113:0x014c  */
    /* JADX WARN: Code duplicated, block: B:114:0x014f  */
    /* JADX WARN: Code duplicated, block: B:122:0x016c  */
    /* JADX WARN: Code duplicated, block: B:125:0x0175  */
    /* JADX WARN: Code duplicated, block: B:134:0x01a9 A[PHI: r3 r5 r6 r7 r8 r10 r11 r13
      0x01a9: PHI (r3v15 androidx.compose.ui.Modifier) = (r3v10 androidx.compose.ui.Modifier), (r3v18 androidx.compose.ui.Modifier), (r3v20 androidx.compose.ui.Modifier) binds: [B:155:0x0200, B:133:0x019f, B:132:0x0192] A[DONT_GENERATE, DONT_INLINE]
      0x01a9: PHI (r5v9 kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) = 
      (r5v4 kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>)
      (r5v1 kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>)
      (r5v1 kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>)
     binds: [B:155:0x0200, B:133:0x019f, B:132:0x0192] A[DONT_GENERATE, DONT_INLINE]
      0x01a9: PHI (r6v9 kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) = 
      (r6v5 kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>)
      (r6v10 kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>)
      (r6v12 kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>)
     binds: [B:155:0x0200, B:133:0x019f, B:132:0x0192] A[DONT_GENERATE, DONT_INLINE]
      0x01a9: PHI (r7v8 boolean) = (r7v5 boolean), (r7v9 boolean), (r7v10 boolean) binds: [B:155:0x0200, B:133:0x019f, B:132:0x0192] A[DONT_GENERATE, DONT_INLINE]
      0x01a9: PHI (r8v9 kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) = 
      (r8v4 kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>)
      (r8v1 kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>)
      (r8v1 kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>)
     binds: [B:155:0x0200, B:133:0x019f, B:132:0x0192] A[DONT_GENERATE, DONT_INLINE]
      0x01a9: PHI (r10v7 androidx.compose.foundation.layout.PaddingValues) = 
      (r10v4 androidx.compose.foundation.layout.PaddingValues)
      (r10v8 androidx.compose.foundation.layout.PaddingValues)
      (r10v9 androidx.compose.foundation.layout.PaddingValues)
     binds: [B:155:0x0200, B:133:0x019f, B:132:0x0192] A[DONT_GENERATE, DONT_INLINE]
      0x01a9: PHI (r11v10 androidx.compose.material3.MenuItemColors) = 
      (r11v5 androidx.compose.material3.MenuItemColors)
      (r11v11 androidx.compose.material3.MenuItemColors)
      (r11v12 androidx.compose.material3.MenuItemColors)
     binds: [B:155:0x0200, B:133:0x019f, B:132:0x0192] A[DONT_GENERATE, DONT_INLINE]
      0x01a9: PHI (r13v11 int) = (r13v5 int), (r13v12 int), (r13v13 int) binds: [B:155:0x0200, B:133:0x019f, B:132:0x0192] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:135:0x01ac A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:136:0x01ae  */
    /* JADX WARN: Code duplicated, block: B:137:0x01b3  */
    /* JADX WARN: Code duplicated, block: B:139:0x01b6  */
    /* JADX WARN: Code duplicated, block: B:141:0x01b9  */
    /* JADX WARN: Code duplicated, block: B:143:0x01bc  */
    /* JADX WARN: Code duplicated, block: B:145:0x01bf  */
    /* JADX WARN: Code duplicated, block: B:146:0x01c1  */
    /* JADX WARN: Code duplicated, block: B:149:0x01c7  */
    /* JADX WARN: Code duplicated, block: B:150:0x01ee  */
    /* JADX WARN: Code duplicated, block: B:152:0x01f4  */
    /* JADX WARN: Code duplicated, block: B:153:0x01fb  */
    /* JADX WARN: Code duplicated, block: B:156:0x0202  */
    /* JADX WARN: Code duplicated, block: B:159:0x020c  */
    /* JADX WARN: Code duplicated, block: B:162:0x0228  */
    /* JADX WARN: Code duplicated, block: B:165:0x024c  */
    /* JADX WARN: Code duplicated, block: B:166:0x024e  */
    /* JADX WARN: Code duplicated, block: B:169:0x0254  */
    /* JADX WARN: Code duplicated, block: B:170:0x0256  */
    /* JADX WARN: Code duplicated, block: B:173:0x025e  */
    /* JADX WARN: Code duplicated, block: B:175:0x0266  */
    /* JADX WARN: Code duplicated, block: B:178:0x02b4  */
    /* JADX WARN: Code duplicated, block: B:180:0x02c3  */
    /* JADX WARN: Code duplicated, block: B:183:0x02da  */
    /* JADX WARN: Code duplicated, block: B:185:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:46:0x0082  */
    /* JADX WARN: Code duplicated, block: B:47:0x0087  */
    /* JADX WARN: Code duplicated, block: B:49:0x008d  */
    /* JADX WARN: Code duplicated, block: B:51:0x0093  */
    /* JADX WARN: Code duplicated, block: B:52:0x0096  */
    /* JADX WARN: Code duplicated, block: B:56:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:57:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:59:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:61:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:62:0x00b4  */
    /* JADX WARN: Code duplicated, block: B:66:0x00be  */
    /* JADX WARN: Code duplicated, block: B:67:0x00c3  */
    /* JADX WARN: Code duplicated, block: B:69:0x00c9  */
    /* JADX WARN: Code duplicated, block: B:71:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:72:0x00d2  */
    /* JADX WARN: Code duplicated, block: B:76:0x00dc  */
    /* JADX WARN: Code duplicated, block: B:77:0x00e1  */
    /* JADX WARN: Code duplicated, block: B:79:0x00e7  */
    /* JADX WARN: Code duplicated, block: B:81:0x00ed  */
    /* JADX WARN: Code duplicated, block: B:82:0x00f0  */
    /* JADX WARN: Code duplicated, block: B:86:0x00fa  */
    /* JADX WARN: Code duplicated, block: B:94:0x0110  */
    /* JADX WARN: Code duplicated, block: B:97:0x0116  */
    /* JADX WARN: Code duplicated, block: B:98:0x011d  */
    public static final void DropdownMenuItem(final boolean z, final Function1<? super Boolean, Unit> function1, final Function2<? super Composer, ? super Integer, Unit> function2, final MenuItemShapes menuItemShapes, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function3, Function2<? super Composer, ? super Integer, Unit> function4, Function2<? super Composer, ? super Integer, Unit> function5, boolean z2, MenuItemColors menuItemColors, PaddingValues paddingValues, MutableInteractionSource mutableInteractionSource, Composer composer, final int i, final int i2, final int i3) {
        int i4;
        Modifier modifier2;
        int i5;
        Function2<? super Composer, ? super Integer, Unit> function6;
        int i6;
        int i7;
        Function2<? super Composer, ? super Integer, Unit> function7;
        int i8;
        int i9;
        Function2<? super Composer, ? super Integer, Unit> function8;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        boolean z3;
        final MenuItemColors menuItemColors2;
        final PaddingValues paddingValues2;
        final Function2<? super Composer, ? super Integer, Unit> function9;
        final Function2<? super Composer, ? super Integer, Unit> function10;
        final Function2<? super Composer, ? super Integer, Unit> function11;
        final Modifier modifier3;
        final boolean z4;
        final MutableInteractionSource mutableInteractionSource2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        boolean z5;
        MenuItemColors menuItemColorsM3756selectableItemColorsHlaysQ4;
        int i22;
        PaddingValues dropdownMenuItemContentPadding;
        boolean z6;
        Function2<? super Composer, ? super Integer, Unit> function12;
        PaddingValues paddingValues3;
        MutableInteractionSource mutableInteractionSource3;
        Object objRememberedValue;
        boolean z7;
        boolean z8;
        boolean z9;
        Object objRememberedValue2;
        Composer composerStartRestartGroup = composer.startRestartGroup(1967931105);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(DropdownMenuItem)N(checked,onCheckedChange,text,shapes,modifier,leadingIcon,checkedLeadingIcon,trailingIcon,enabled,colors,contentPadding,interactionSource)408@19759L24,407@19690L29,404@19598L479:Menu.kt#uh7d8r");
        if ((i & 6) == 0) {
            i4 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        if ((i & 48) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(function1) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(function2) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i4 |= composerStartRestartGroup.changed(menuItemShapes) ? 2048 : 1024;
        }
        int i23 = i3 & 16;
        if (i23 == 0) {
            if ((i & 24576) == 0) {
                modifier2 = modifier;
                i4 |= composerStartRestartGroup.changed(modifier2) ? 16384 : 8192;
            }
            i5 = i3 & 32;
            if (i5 != 0) {
                i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                function6 = function3;
            } else {
                function6 = function3;
                if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    if (composerStartRestartGroup.changedInstance(function6)) {
                        i6 = 131072;
                    } else {
                        i6 = 65536;
                    }
                    i4 |= i6;
                }
            }
            i7 = i3 & 64;
            if (i7 != 0) {
                i4 |= 1572864;
                function7 = function4;
            } else {
                function7 = function4;
                if ((i & 1572864) == 0) {
                    if (composerStartRestartGroup.changedInstance(function7)) {
                        i8 = 1048576;
                    } else {
                        i8 = 524288;
                    }
                    i4 |= i8;
                }
            }
            i9 = i3 & 128;
            if (i9 != 0) {
                i4 |= 12582912;
                function8 = function5;
            } else {
                function8 = function5;
                if ((i & 12582912) == 0) {
                    if (composerStartRestartGroup.changedInstance(function8)) {
                        i10 = 8388608;
                    } else {
                        i10 = 4194304;
                    }
                    i4 |= i10;
                }
            }
            i11 = i3 & 256;
            if (i11 != 0) {
                i4 |= 100663296;
            } else if ((i & 100663296) == 0) {
                if (composerStartRestartGroup.changed(z2)) {
                    i12 = 67108864;
                } else {
                    i12 = 33554432;
                }
                i4 |= i12;
            }
            if ((i & 805306368) != 0) {
                i4 |= ((i3 & 512) == 0 || !composerStartRestartGroup.changed(menuItemColors)) ? 268435456 : C.BUFFER_FLAG_LAST_SAMPLE;
            }
            i13 = i3 & 1024;
            if (i13 != 0) {
                i15 = i2 | 6;
                i14 = i13;
            } else {
                i14 = i13;
                if ((i2 & 6) == 0) {
                    if (composerStartRestartGroup.changed(paddingValues)) {
                        i16 = 4;
                    } else {
                        i16 = 2;
                    }
                    i15 = i2 | i16;
                } else {
                    i15 = i2;
                }
            }
            i17 = i3 & 2048;
            if (i17 != 0) {
                i15 |= 48;
                i18 = i17;
            } else {
                i18 = i17;
                if ((i2 & 48) == 0) {
                    if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                        i19 = 32;
                    } else {
                        i19 = 16;
                    }
                    i15 |= i19;
                }
            }
            i20 = i15;
            i21 = i4;
            if ((i4 & 306783379) == 306783378 || (i20 & 19) != 18) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i21 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "400@19428L22");
                if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                    if (i23 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i5 != 0) {
                        function6 = null;
                    }
                    if (i7 != 0) {
                        function7 = null;
                    }
                    if (i9 != 0) {
                        function8 = null;
                    }
                    if (i11 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    if ((i3 & 512) != 0) {
                        menuItemColorsM3756selectableItemColorsHlaysQ4 = MenuDefaults.INSTANCE.m3756selectableItemColorsHlaysQ4(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 48, 2047);
                        i22 = i21 & (-1879048193);
                    } else {
                        menuItemColorsM3756selectableItemColorsHlaysQ4 = menuItemColors;
                        i22 = i21;
                    }
                    if (i14 != 0) {
                        dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                    } else {
                        dropdownMenuItemContentPadding = paddingValues;
                    }
                    z6 = z5;
                    function12 = function8;
                    paddingValues3 = dropdownMenuItemContentPadding;
                    if (i18 != 0) {
                        mutableInteractionSource3 = null;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1967931105, i22, i20, "androidx.compose.material3.DropdownMenuItem (Menu.kt:403)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1396205497, "CC(remember):Menu.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new Function1() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda10
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return MenuKt.DropdownMenuItem$lambda$2$0((SemanticsPropertyReceiver) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Modifier modifierSemantics$default = SemanticsModifierKt.semantics$default(companion, false, (Function1) objRememberedValue, 1, null);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1396203294, "CC(remember):Menu.kt#9igjgp");
                    if ((i22 & 112) == 32) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                    if ((i22 & 14) == 4) {
                        z8 = true;
                    } else {
                        z8 = false;
                    }
                    z9 = z7 | z8;
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!z9 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = new Function0() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda12
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return MenuKt.DropdownMenuItem$lambda$3$0(function1, z);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    int i24 = i22 >> 3;
                    Modifier modifier4 = companion;
                    Function2<? super Composer, ? super Integer, Unit> function13 = function6;
                    Function2<? super Composer, ? super Integer, Unit> function14 = function7;
                    MenuItemColors menuItemColors3 = menuItemColorsM3756selectableItemColorsHlaysQ4;
                    MutableInteractionSource mutableInteractionSource4 = mutableInteractionSource3;
                    DropdownMenuItemContent(z, (Function0) objRememberedValue2, function2, modifierSemantics$default, function13, function14, function12, z6, menuItemColors3, menuItemShapes, paddingValues3, mutableInteractionSource4, composerStartRestartGroup, ((i22 << 18) & C.ENCODING_PCM_DOUBLE) | (i22 & 910) | (i24 & 57344) | (i24 & 458752) | (i24 & 3670016) | (i24 & 29360128) | (i24 & 234881024), i20 & 126);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z4 = z6;
                    function10 = function14;
                    mutableInteractionSource2 = mutableInteractionSource4;
                    modifier3 = modifier4;
                    paddingValues2 = paddingValues3;
                    menuItemColors2 = menuItemColors3;
                    function11 = function12;
                    function9 = function13;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    if ((i3 & 512) != 0) {
                        Modifier modifier5 = modifier2;
                        i22 = i21 & (-1879048193);
                        companion = modifier5;
                        z6 = z2;
                        menuItemColorsM3756selectableItemColorsHlaysQ4 = menuItemColors;
                        paddingValues3 = paddingValues;
                        function12 = function8;
                    } else {
                        z6 = z2;
                        menuItemColorsM3756selectableItemColorsHlaysQ4 = menuItemColors;
                        paddingValues3 = paddingValues;
                        function12 = function8;
                        companion = modifier2;
                        i22 = i21;
                    }
                }
                mutableInteractionSource3 = mutableInteractionSource;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1967931105, i22, i20, "androidx.compose.material3.DropdownMenuItem (Menu.kt:403)");
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1396205497, "CC(remember):Menu.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function1() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda10
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return MenuKt.DropdownMenuItem$lambda$2$0((SemanticsPropertyReceiver) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifierSemantics$default2 = SemanticsModifierKt.semantics$default(companion, false, (Function1) objRememberedValue, 1, null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1396203294, "CC(remember):Menu.kt#9igjgp");
                if ((i22 & 112) == 32) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                if ((i22 & 14) == 4) {
                    z8 = true;
                } else {
                    z8 = false;
                }
                z9 = z7 | z8;
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!z9) {
                    objRememberedValue2 = new Function0() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda12
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return MenuKt.DropdownMenuItem$lambda$3$0(function1, z);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = new Function0() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda12
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return MenuKt.DropdownMenuItem$lambda$3$0(function1, z);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                int i25 = i22 >> 3;
                Modifier modifier6 = companion;
                Function2<? super Composer, ? super Integer, Unit> function15 = function6;
                Function2<? super Composer, ? super Integer, Unit> function16 = function7;
                MenuItemColors menuItemColors4 = menuItemColorsM3756selectableItemColorsHlaysQ4;
                MutableInteractionSource mutableInteractionSource5 = mutableInteractionSource3;
                DropdownMenuItemContent(z, (Function0) objRememberedValue2, function2, modifierSemantics$default2, function15, function16, function12, z6, menuItemColors4, menuItemShapes, paddingValues3, mutableInteractionSource5, composerStartRestartGroup, ((i22 << 18) & C.ENCODING_PCM_DOUBLE) | (i22 & 910) | (i25 & 57344) | (i25 & 458752) | (i25 & 3670016) | (i25 & 29360128) | (i25 & 234881024), i20 & 126);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z4 = z6;
                function10 = function16;
                mutableInteractionSource2 = mutableInteractionSource5;
                modifier3 = modifier6;
                paddingValues2 = paddingValues3;
                menuItemColors2 = menuItemColors4;
                function11 = function12;
                function9 = function15;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                menuItemColors2 = menuItemColors;
                paddingValues2 = paddingValues;
                function9 = function6;
                function10 = function7;
                function11 = function8;
                modifier3 = modifier2;
                z4 = z2;
                mutableInteractionSource2 = mutableInteractionSource;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda13
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return MenuKt.DropdownMenuItem$lambda$4(z, function1, function2, menuItemShapes, modifier3, function9, function10, function11, z4, menuItemColors2, paddingValues2, mutableInteractionSource2, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i4 |= 24576;
        modifier2 = modifier;
        i5 = i3 & 32;
        if (i5 != 0) {
            i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            function6 = function3;
        } else {
            function6 = function3;
            if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                if (composerStartRestartGroup.changedInstance(function6)) {
                    i6 = 131072;
                } else {
                    i6 = 65536;
                }
                i4 |= i6;
            }
        }
        i7 = i3 & 64;
        if (i7 != 0) {
            i4 |= 1572864;
            function7 = function4;
        } else {
            function7 = function4;
            if ((i & 1572864) == 0) {
                if (composerStartRestartGroup.changedInstance(function7)) {
                    i8 = 1048576;
                } else {
                    i8 = 524288;
                }
                i4 |= i8;
            }
        }
        i9 = i3 & 128;
        if (i9 != 0) {
            i4 |= 12582912;
            function8 = function5;
        } else {
            function8 = function5;
            if ((i & 12582912) == 0) {
                if (composerStartRestartGroup.changedInstance(function8)) {
                    i10 = 8388608;
                } else {
                    i10 = 4194304;
                }
                i4 |= i10;
            }
        }
        i11 = i3 & 256;
        if (i11 != 0) {
            i4 |= 100663296;
        } else if ((i & 100663296) == 0) {
            if (composerStartRestartGroup.changed(z2)) {
                i12 = 67108864;
            } else {
                i12 = 33554432;
            }
            i4 |= i12;
        }
        if ((i & 805306368) != 0) {
            i4 |= ((i3 & 512) == 0 || !composerStartRestartGroup.changed(menuItemColors)) ? 268435456 : C.BUFFER_FLAG_LAST_SAMPLE;
        }
        i13 = i3 & 1024;
        if (i13 != 0) {
            i15 = i2 | 6;
            i14 = i13;
        } else {
            i14 = i13;
            if ((i2 & 6) == 0) {
                if (composerStartRestartGroup.changed(paddingValues)) {
                    i16 = 4;
                } else {
                    i16 = 2;
                }
                i15 = i2 | i16;
            } else {
                i15 = i2;
            }
        }
        i17 = i3 & 2048;
        if (i17 != 0) {
            i15 |= 48;
            i18 = i17;
        } else {
            i18 = i17;
            if ((i2 & 48) == 0) {
                if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                    i19 = 32;
                } else {
                    i19 = 16;
                }
                i15 |= i19;
            }
        }
        i20 = i15;
        i21 = i4;
        if ((i4 & 306783379) == 306783378) {
            z3 = true;
        } else {
            z3 = true;
        }
        if (composerStartRestartGroup.shouldExecute(z3, i21 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "400@19428L22");
            if ((i & 1) != 0) {
                if (i23 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i5 != 0) {
                    function6 = null;
                }
                if (i7 != 0) {
                    function7 = null;
                }
                if (i9 != 0) {
                    function8 = null;
                }
                if (i11 != 0) {
                    z5 = true;
                } else {
                    z5 = z2;
                }
                if ((i3 & 512) != 0) {
                    menuItemColorsM3756selectableItemColorsHlaysQ4 = MenuDefaults.INSTANCE.m3756selectableItemColorsHlaysQ4(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 48, 2047);
                    i22 = i21 & (-1879048193);
                } else {
                    menuItemColorsM3756selectableItemColorsHlaysQ4 = menuItemColors;
                    i22 = i21;
                }
                if (i14 != 0) {
                    dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                } else {
                    dropdownMenuItemContentPadding = paddingValues;
                }
                z6 = z5;
                function12 = function8;
                paddingValues3 = dropdownMenuItemContentPadding;
                if (i18 != 0) {
                    mutableInteractionSource3 = null;
                } else {
                    mutableInteractionSource3 = mutableInteractionSource;
                }
            } else {
                if (i23 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i5 != 0) {
                    function6 = null;
                }
                if (i7 != 0) {
                    function7 = null;
                }
                if (i9 != 0) {
                    function8 = null;
                }
                if (i11 != 0) {
                    z5 = true;
                } else {
                    z5 = z2;
                }
                if ((i3 & 512) != 0) {
                    menuItemColorsM3756selectableItemColorsHlaysQ4 = MenuDefaults.INSTANCE.m3756selectableItemColorsHlaysQ4(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 48, 2047);
                    i22 = i21 & (-1879048193);
                } else {
                    menuItemColorsM3756selectableItemColorsHlaysQ4 = menuItemColors;
                    i22 = i21;
                }
                if (i14 != 0) {
                    dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                } else {
                    dropdownMenuItemContentPadding = paddingValues;
                }
                z6 = z5;
                function12 = function8;
                paddingValues3 = dropdownMenuItemContentPadding;
                if (i18 != 0) {
                    mutableInteractionSource3 = null;
                } else {
                    mutableInteractionSource3 = mutableInteractionSource;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1967931105, i22, i20, "androidx.compose.material3.DropdownMenuItem (Menu.kt:403)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1396205497, "CC(remember):Menu.kt#9igjgp");
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda10
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return MenuKt.DropdownMenuItem$lambda$2$0((SemanticsPropertyReceiver) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierSemantics$default3 = SemanticsModifierKt.semantics$default(companion, false, (Function1) objRememberedValue, 1, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1396203294, "CC(remember):Menu.kt#9igjgp");
            if ((i22 & 112) == 32) {
                z7 = true;
            } else {
                z7 = false;
            }
            if ((i22 & 14) == 4) {
                z8 = true;
            } else {
                z8 = false;
            }
            z9 = z7 | z8;
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (!z9) {
                objRememberedValue2 = new Function0() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda12
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return MenuKt.DropdownMenuItem$lambda$3$0(function1, z);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            } else {
                objRememberedValue2 = new Function0() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda12
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return MenuKt.DropdownMenuItem$lambda$3$0(function1, z);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            int i26 = i22 >> 3;
            Modifier modifier7 = companion;
            Function2<? super Composer, ? super Integer, Unit> function17 = function6;
            Function2<? super Composer, ? super Integer, Unit> function18 = function7;
            MenuItemColors menuItemColors5 = menuItemColorsM3756selectableItemColorsHlaysQ4;
            MutableInteractionSource mutableInteractionSource6 = mutableInteractionSource3;
            DropdownMenuItemContent(z, (Function0) objRememberedValue2, function2, modifierSemantics$default3, function17, function18, function12, z6, menuItemColors5, menuItemShapes, paddingValues3, mutableInteractionSource6, composerStartRestartGroup, ((i22 << 18) & C.ENCODING_PCM_DOUBLE) | (i22 & 910) | (i26 & 57344) | (i26 & 458752) | (i26 & 3670016) | (i26 & 29360128) | (i26 & 234881024), i20 & 126);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            z4 = z6;
            function10 = function18;
            mutableInteractionSource2 = mutableInteractionSource6;
            modifier3 = modifier7;
            paddingValues2 = paddingValues3;
            menuItemColors2 = menuItemColors5;
            function11 = function12;
            function9 = function17;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            menuItemColors2 = menuItemColors;
            paddingValues2 = paddingValues;
            function9 = function6;
            function10 = function7;
            function11 = function8;
            modifier3 = modifier2;
            z4 = z2;
            mutableInteractionSource2 = mutableInteractionSource;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda13
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return MenuKt.DropdownMenuItem$lambda$4(z, function1, function2, menuItemShapes, modifier3, function9, function10, function11, z4, menuItemColors2, paddingValues2, mutableInteractionSource2, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DropdownMenuItem$lambda$3$0(Function1 function1, boolean z) {
        function1.invoke(Boolean.valueOf(!z));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DropdownMenuItem$lambda$2$0(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.m8851setRolekuIjeqM(semanticsPropertyReceiver, Role.INSTANCE.m8834getCheckboxo7Vup1c());
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0127  */
    /* JADX WARN: Code duplicated, block: B:102:0x012f  */
    /* JADX WARN: Code duplicated, block: B:104:0x0135  */
    /* JADX WARN: Code duplicated, block: B:105:0x0138  */
    /* JADX WARN: Code duplicated, block: B:107:0x013d  */
    /* JADX WARN: Code duplicated, block: B:110:0x0143  */
    /* JADX WARN: Code duplicated, block: B:111:0x0148  */
    /* JADX WARN: Code duplicated, block: B:113:0x0150  */
    /* JADX WARN: Code duplicated, block: B:115:0x0156  */
    /* JADX WARN: Code duplicated, block: B:116:0x0159  */
    /* JADX WARN: Code duplicated, block: B:120:0x0169  */
    /* JADX WARN: Code duplicated, block: B:124:0x0172  */
    /* JADX WARN: Code duplicated, block: B:127:0x017b  */
    /* JADX WARN: Code duplicated, block: B:129:0x018b  */
    /* JADX WARN: Code duplicated, block: B:136:0x01ad A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:137:0x01af  */
    /* JADX WARN: Code duplicated, block: B:138:0x01b4  */
    /* JADX WARN: Code duplicated, block: B:140:0x01b7  */
    /* JADX WARN: Code duplicated, block: B:141:0x01b9  */
    /* JADX WARN: Code duplicated, block: B:143:0x01bd  */
    /* JADX WARN: Code duplicated, block: B:145:0x01c0  */
    /* JADX WARN: Code duplicated, block: B:147:0x01c3  */
    /* JADX WARN: Code duplicated, block: B:148:0x01c5  */
    /* JADX WARN: Code duplicated, block: B:151:0x01cb  */
    /* JADX WARN: Code duplicated, block: B:152:0x01f4  */
    /* JADX WARN: Code duplicated, block: B:154:0x01f9  */
    /* JADX WARN: Code duplicated, block: B:155:0x0200  */
    /* JADX WARN: Code duplicated, block: B:157:0x0204  */
    /* JADX WARN: Code duplicated, block: B:158:0x0209  */
    /* JADX WARN: Code duplicated, block: B:162:0x0220  */
    /* JADX WARN: Code duplicated, block: B:165:0x023c  */
    /* JADX WARN: Code duplicated, block: B:168:0x0288  */
    /* JADX WARN: Code duplicated, block: B:170:0x029b  */
    /* JADX WARN: Code duplicated, block: B:173:0x02b2  */
    /* JADX WARN: Code duplicated, block: B:175:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:47:0x0087  */
    /* JADX WARN: Code duplicated, block: B:48:0x008c  */
    /* JADX WARN: Code duplicated, block: B:50:0x0092  */
    /* JADX WARN: Code duplicated, block: B:52:0x0098  */
    /* JADX WARN: Code duplicated, block: B:53:0x009b  */
    /* JADX WARN: Code duplicated, block: B:57:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:58:0x00aa  */
    /* JADX WARN: Code duplicated, block: B:60:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:62:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:63:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:67:0x00c3  */
    /* JADX WARN: Code duplicated, block: B:68:0x00c8  */
    /* JADX WARN: Code duplicated, block: B:70:0x00ce  */
    /* JADX WARN: Code duplicated, block: B:72:0x00d4  */
    /* JADX WARN: Code duplicated, block: B:73:0x00d7  */
    /* JADX WARN: Code duplicated, block: B:77:0x00e1  */
    /* JADX WARN: Code duplicated, block: B:78:0x00e4  */
    /* JADX WARN: Code duplicated, block: B:80:0x00e8  */
    /* JADX WARN: Code duplicated, block: B:82:0x00f2  */
    /* JADX WARN: Code duplicated, block: B:83:0x00f5  */
    /* JADX WARN: Code duplicated, block: B:88:0x0104  */
    /* JADX WARN: Code duplicated, block: B:90:0x0108  */
    /* JADX WARN: Code duplicated, block: B:93:0x0113 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:96:0x011a  */
    /* JADX WARN: Code duplicated, block: B:99:0x0120  */
    public static final void DropdownMenuItem(final boolean z, final Function0<Unit> function0, final Function2<? super Composer, ? super Integer, Unit> function2, final MenuItemShapes menuItemShapes, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function3, Function2<? super Composer, ? super Integer, Unit> function4, Function2<? super Composer, ? super Integer, Unit> function5, boolean z2, MenuItemColors menuItemColors, PaddingValues paddingValues, MutableInteractionSource mutableInteractionSource, Composer composer, final int i, final int i2, final int i3) {
        int i4;
        Function0<Unit> function1;
        Function2<? super Composer, ? super Integer, Unit> function6;
        MenuItemShapes menuItemShapes2;
        Modifier modifier2;
        int i5;
        int i6;
        int i7;
        Function2<? super Composer, ? super Integer, Unit> function7;
        int i8;
        int i9;
        final Function2<? super Composer, ? super Integer, Unit> function8;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        boolean z3;
        Composer composer2;
        final Function2<? super Composer, ? super Integer, Unit> function9;
        final boolean z4;
        final MenuItemColors menuItemColors2;
        final PaddingValues paddingValues2;
        final Function2<? super Composer, ? super Integer, Unit> function10;
        final Modifier modifier3;
        final MutableInteractionSource mutableInteractionSource2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        Function2<? super Composer, ? super Integer, Unit> function11;
        boolean z5;
        Composer composer3;
        MenuItemColors menuItemColorsM3756selectableItemColorsHlaysQ4;
        PaddingValues dropdownMenuItemContentPadding;
        MutableInteractionSource mutableInteractionSource3;
        Function2<? super Composer, ? super Integer, Unit> function12;
        boolean z6;
        Function2<? super Composer, ? super Integer, Unit> function13;
        Function2<? super Composer, ? super Integer, Unit> function14;
        PaddingValues paddingValues3;
        Object objRememberedValue;
        Composer composerStartRestartGroup = composer.startRestartGroup(-151119870);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(DropdownMenuItem)N(selected,onClick,text,shapes,modifier,leadingIcon,checkedLeadingIcon,trailingIcon,enabled,colors,contentPadding,interactionSource)472@22769L27,468@22629L461:Menu.kt#uh7d8r");
        if ((i & 6) == 0) {
            i4 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        if ((i & 48) == 0) {
            function1 = function0;
            i4 |= composerStartRestartGroup.changedInstance(function1) ? 32 : 16;
        } else {
            function1 = function0;
        }
        if ((i & 384) == 0) {
            function6 = function2;
            i4 |= composerStartRestartGroup.changedInstance(function6) ? 256 : 128;
        } else {
            function6 = function2;
        }
        if ((i & 3072) == 0) {
            menuItemShapes2 = menuItemShapes;
            i4 |= composerStartRestartGroup.changed(menuItemShapes2) ? 2048 : 1024;
        } else {
            menuItemShapes2 = menuItemShapes;
        }
        int i21 = i3 & 16;
        if (i21 == 0) {
            if ((i & 24576) == 0) {
                modifier2 = modifier;
                i4 |= composerStartRestartGroup.changed(modifier2) ? 16384 : 8192;
            }
            i5 = i3 & 32;
            if (i5 != 0) {
                i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            } else if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i6 = 131072;
                } else {
                    i6 = 65536;
                }
                i4 |= i6;
            }
            i7 = i3 & 64;
            if (i7 != 0) {
                i4 |= 1572864;
                function7 = function4;
            } else {
                function7 = function4;
                if ((i & 1572864) == 0) {
                    if (composerStartRestartGroup.changedInstance(function7)) {
                        i8 = 1048576;
                    } else {
                        i8 = 524288;
                    }
                    i4 |= i8;
                }
            }
            i9 = i3 & 128;
            if (i9 != 0) {
                i4 |= 12582912;
                function8 = function5;
            } else {
                function8 = function5;
                if ((i & 12582912) == 0) {
                    if (composerStartRestartGroup.changedInstance(function8)) {
                        i10 = 8388608;
                    } else {
                        i10 = 4194304;
                    }
                    i4 |= i10;
                }
            }
            i11 = i3 & 256;
            if (i11 != 0) {
                if ((i & 100663296) == 0) {
                    if (composerStartRestartGroup.changed(z2)) {
                        i12 = 67108864;
                    } else {
                        i12 = 33554432;
                    }
                    i4 |= i12;
                }
                if ((i & 805306368) != 0) {
                    i4 |= ((i3 & 512) == 0 || !composerStartRestartGroup.changed(menuItemColors)) ? 268435456 : C.BUFFER_FLAG_LAST_SAMPLE;
                }
                i13 = i3 & 1024;
                if (i13 != 0) {
                    i15 = i2 | 6;
                    i14 = i13;
                } else {
                    i14 = i13;
                    if ((i2 & 6) == 0) {
                        if (composerStartRestartGroup.changed(paddingValues)) {
                            i16 = 4;
                        } else {
                            i16 = 2;
                        }
                        i15 = i2 | i16;
                    } else {
                        i15 = i2;
                    }
                }
                i17 = i3 & 2048;
                if (i17 != 0) {
                    i15 |= 48;
                    i18 = i17;
                } else {
                    i18 = i17;
                    if ((i2 & 48) == 0) {
                        if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                            i19 = 32;
                        } else {
                            i19 = 16;
                        }
                        i15 |= i19;
                    }
                }
                i20 = i15;
                if ((i4 & 306783379) == 306783378 || (i20 & 19) != 18) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i4 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "464@22459L22");
                    if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                        if (i21 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i5 != 0) {
                            function11 = null;
                        } else {
                            function11 = function3;
                        }
                        if (i7 != 0) {
                            function7 = null;
                        }
                        if (i9 != 0) {
                            function8 = null;
                        }
                        if (i11 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        if ((i3 & 512) != 0) {
                            menuItemColorsM3756selectableItemColorsHlaysQ4 = MenuDefaults.INSTANCE.m3756selectableItemColorsHlaysQ4(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 48, 2047);
                            composer3 = composerStartRestartGroup;
                            i4 &= -1879048193;
                        } else {
                            composer3 = composerStartRestartGroup;
                            menuItemColorsM3756selectableItemColorsHlaysQ4 = menuItemColors;
                        }
                        if (i14 != 0) {
                            dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                        } else {
                            dropdownMenuItemContentPadding = paddingValues;
                        }
                        if (i18 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        function12 = function7;
                        z6 = z5;
                        function13 = function8;
                        function14 = function11;
                        paddingValues3 = dropdownMenuItemContentPadding;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        if ((i3 & 512) != 0) {
                            i4 &= -1879048193;
                        }
                        function14 = function3;
                        z6 = z2;
                        menuItemColorsM3756selectableItemColorsHlaysQ4 = menuItemColors;
                        paddingValues3 = paddingValues;
                        mutableInteractionSource3 = mutableInteractionSource;
                        function12 = function7;
                        function13 = function8;
                        companion = modifier2;
                        composer3 = composerStartRestartGroup;
                    }
                    composer3.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-151119870, i4, i20, "androidx.compose.material3.DropdownMenuItem (Menu.kt:467)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composer3, 802715709, "CC(remember):Menu.kt#9igjgp");
                    objRememberedValue = composer3.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new Function1() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return MenuKt.DropdownMenuItem$lambda$5$0((SemanticsPropertyReceiver) obj);
                            }
                        };
                        composer3.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    int i22 = i4 >> 3;
                    Composer composer4 = composer3;
                    DropdownMenuItemContent(z, function1, function6, SemanticsModifierKt.semantics$default(companion, false, (Function1) objRememberedValue, 1, null), function14, function12, function13, z6, menuItemColorsM3756selectableItemColorsHlaysQ4, menuItemShapes2, paddingValues3, mutableInteractionSource3, composer4, (i4 & AnalyticsListener.EVENT_DRM_SESSION_ACQUIRED) | (57344 & i22) | (458752 & i22) | (3670016 & i22) | (29360128 & i22) | (i22 & 234881024) | (1879048192 & (i4 << 18)), i20 & 126);
                    composer2 = composer4;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = companion;
                    function9 = function14;
                    function10 = function12;
                    function8 = function13;
                    z4 = z6;
                    menuItemColors2 = menuItemColorsM3756selectableItemColorsHlaysQ4;
                    paddingValues2 = paddingValues3;
                    mutableInteractionSource2 = mutableInteractionSource3;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    function9 = function3;
                    z4 = z2;
                    menuItemColors2 = menuItemColors;
                    paddingValues2 = paddingValues;
                    function10 = function7;
                    modifier3 = modifier2;
                    mutableInteractionSource2 = mutableInteractionSource;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return MenuKt.DropdownMenuItem$lambda$6(z, function0, function2, menuItemShapes, modifier3, function9, function10, function8, z4, menuItemColors2, paddingValues2, mutableInteractionSource2, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i4 |= 100663296;
            if ((i & 805306368) != 0) {
                i4 |= ((i3 & 512) == 0 || !composerStartRestartGroup.changed(menuItemColors)) ? 268435456 : C.BUFFER_FLAG_LAST_SAMPLE;
            }
            i13 = i3 & 1024;
            if (i13 != 0) {
                i15 = i2 | 6;
                i14 = i13;
            } else {
                i14 = i13;
                if ((i2 & 6) == 0) {
                    if (composerStartRestartGroup.changed(paddingValues)) {
                        i16 = 4;
                    } else {
                        i16 = 2;
                    }
                    i15 = i2 | i16;
                } else {
                    i15 = i2;
                }
            }
            i17 = i3 & 2048;
            if (i17 != 0) {
                i15 |= 48;
                i18 = i17;
            } else {
                i18 = i17;
                if ((i2 & 48) == 0) {
                    if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                        i19 = 32;
                    } else {
                        i19 = 16;
                    }
                    i15 |= i19;
                }
            }
            i20 = i15;
            if ((i4 & 306783379) == 306783378) {
                z3 = true;
            } else {
                z3 = true;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i4 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "464@22459L22");
                if ((i & 1) != 0) {
                    if (i21 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i5 != 0) {
                        function11 = null;
                    } else {
                        function11 = function3;
                    }
                    if (i7 != 0) {
                        function7 = null;
                    }
                    if (i9 != 0) {
                        function8 = null;
                    }
                    if (i11 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    if ((i3 & 512) != 0) {
                        menuItemColorsM3756selectableItemColorsHlaysQ4 = MenuDefaults.INSTANCE.m3756selectableItemColorsHlaysQ4(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 48, 2047);
                        composer3 = composerStartRestartGroup;
                        i4 &= -1879048193;
                    } else {
                        composer3 = composerStartRestartGroup;
                        menuItemColorsM3756selectableItemColorsHlaysQ4 = menuItemColors;
                    }
                    if (i14 != 0) {
                        dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                    } else {
                        dropdownMenuItemContentPadding = paddingValues;
                    }
                    if (i18 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    function12 = function7;
                    z6 = z5;
                    function13 = function8;
                    function14 = function11;
                    paddingValues3 = dropdownMenuItemContentPadding;
                } else {
                    if (i21 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i5 != 0) {
                        function11 = null;
                    } else {
                        function11 = function3;
                    }
                    if (i7 != 0) {
                        function7 = null;
                    }
                    if (i9 != 0) {
                        function8 = null;
                    }
                    if (i11 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    if ((i3 & 512) != 0) {
                        menuItemColorsM3756selectableItemColorsHlaysQ4 = MenuDefaults.INSTANCE.m3756selectableItemColorsHlaysQ4(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 48, 2047);
                        composer3 = composerStartRestartGroup;
                        i4 &= -1879048193;
                    } else {
                        composer3 = composerStartRestartGroup;
                        menuItemColorsM3756selectableItemColorsHlaysQ4 = menuItemColors;
                    }
                    if (i14 != 0) {
                        dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                    } else {
                        dropdownMenuItemContentPadding = paddingValues;
                    }
                    if (i18 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    function12 = function7;
                    z6 = z5;
                    function13 = function8;
                    function14 = function11;
                    paddingValues3 = dropdownMenuItemContentPadding;
                }
                composer3.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-151119870, i4, i20, "androidx.compose.material3.DropdownMenuItem (Menu.kt:467)");
                }
                ComposerKt.sourceInformationMarkerStart(composer3, 802715709, "CC(remember):Menu.kt#9igjgp");
                objRememberedValue = composer3.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function1() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return MenuKt.DropdownMenuItem$lambda$5$0((SemanticsPropertyReceiver) obj);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer3);
                int i23 = i4 >> 3;
                Composer composer5 = composer3;
                DropdownMenuItemContent(z, function1, function6, SemanticsModifierKt.semantics$default(companion, false, (Function1) objRememberedValue, 1, null), function14, function12, function13, z6, menuItemColorsM3756selectableItemColorsHlaysQ4, menuItemShapes2, paddingValues3, mutableInteractionSource3, composer5, (i4 & AnalyticsListener.EVENT_DRM_SESSION_ACQUIRED) | (57344 & i23) | (458752 & i23) | (3670016 & i23) | (29360128 & i23) | (i23 & 234881024) | (1879048192 & (i4 << 18)), i20 & 126);
                composer2 = composer5;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = companion;
                function9 = function14;
                function10 = function12;
                function8 = function13;
                z4 = z6;
                menuItemColors2 = menuItemColorsM3756selectableItemColorsHlaysQ4;
                paddingValues2 = paddingValues3;
                mutableInteractionSource2 = mutableInteractionSource3;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                function9 = function3;
                z4 = z2;
                menuItemColors2 = menuItemColors;
                paddingValues2 = paddingValues;
                function10 = function7;
                modifier3 = modifier2;
                mutableInteractionSource2 = mutableInteractionSource;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return MenuKt.DropdownMenuItem$lambda$6(z, function0, function2, menuItemShapes, modifier3, function9, function10, function8, z4, menuItemColors2, paddingValues2, mutableInteractionSource2, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i4 |= 24576;
        modifier2 = modifier;
        i5 = i3 & 32;
        if (i5 != 0) {
            i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        } else if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            if (composerStartRestartGroup.changedInstance(function3)) {
                i6 = 131072;
            } else {
                i6 = 65536;
            }
            i4 |= i6;
        }
        i7 = i3 & 64;
        if (i7 != 0) {
            i4 |= 1572864;
            function7 = function4;
        } else {
            function7 = function4;
            if ((i & 1572864) == 0) {
                if (composerStartRestartGroup.changedInstance(function7)) {
                    i8 = 1048576;
                } else {
                    i8 = 524288;
                }
                i4 |= i8;
            }
        }
        i9 = i3 & 128;
        if (i9 != 0) {
            i4 |= 12582912;
            function8 = function5;
        } else {
            function8 = function5;
            if ((i & 12582912) == 0) {
                if (composerStartRestartGroup.changedInstance(function8)) {
                    i10 = 8388608;
                } else {
                    i10 = 4194304;
                }
                i4 |= i10;
            }
        }
        i11 = i3 & 256;
        if (i11 != 0) {
            if ((i & 100663296) == 0) {
                if (composerStartRestartGroup.changed(z2)) {
                    i12 = 67108864;
                } else {
                    i12 = 33554432;
                }
                i4 |= i12;
            }
            if ((i & 805306368) != 0) {
                i4 |= ((i3 & 512) == 0 || !composerStartRestartGroup.changed(menuItemColors)) ? 268435456 : C.BUFFER_FLAG_LAST_SAMPLE;
            }
            i13 = i3 & 1024;
            if (i13 != 0) {
                i15 = i2 | 6;
                i14 = i13;
            } else {
                i14 = i13;
                if ((i2 & 6) == 0) {
                    if (composerStartRestartGroup.changed(paddingValues)) {
                        i16 = 4;
                    } else {
                        i16 = 2;
                    }
                    i15 = i2 | i16;
                } else {
                    i15 = i2;
                }
            }
            i17 = i3 & 2048;
            if (i17 != 0) {
                i15 |= 48;
                i18 = i17;
            } else {
                i18 = i17;
                if ((i2 & 48) == 0) {
                    if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                        i19 = 32;
                    } else {
                        i19 = 16;
                    }
                    i15 |= i19;
                }
            }
            i20 = i15;
            if ((i4 & 306783379) == 306783378) {
                z3 = true;
            } else {
                z3 = true;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i4 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "464@22459L22");
                if ((i & 1) != 0) {
                    if (i21 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i5 != 0) {
                        function11 = null;
                    } else {
                        function11 = function3;
                    }
                    if (i7 != 0) {
                        function7 = null;
                    }
                    if (i9 != 0) {
                        function8 = null;
                    }
                    if (i11 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    if ((i3 & 512) != 0) {
                        menuItemColorsM3756selectableItemColorsHlaysQ4 = MenuDefaults.INSTANCE.m3756selectableItemColorsHlaysQ4(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 48, 2047);
                        composer3 = composerStartRestartGroup;
                        i4 &= -1879048193;
                    } else {
                        composer3 = composerStartRestartGroup;
                        menuItemColorsM3756selectableItemColorsHlaysQ4 = menuItemColors;
                    }
                    if (i14 != 0) {
                        dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                    } else {
                        dropdownMenuItemContentPadding = paddingValues;
                    }
                    if (i18 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    function12 = function7;
                    z6 = z5;
                    function13 = function8;
                    function14 = function11;
                    paddingValues3 = dropdownMenuItemContentPadding;
                } else {
                    if (i21 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i5 != 0) {
                        function11 = null;
                    } else {
                        function11 = function3;
                    }
                    if (i7 != 0) {
                        function7 = null;
                    }
                    if (i9 != 0) {
                        function8 = null;
                    }
                    if (i11 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    if ((i3 & 512) != 0) {
                        menuItemColorsM3756selectableItemColorsHlaysQ4 = MenuDefaults.INSTANCE.m3756selectableItemColorsHlaysQ4(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 48, 2047);
                        composer3 = composerStartRestartGroup;
                        i4 &= -1879048193;
                    } else {
                        composer3 = composerStartRestartGroup;
                        menuItemColorsM3756selectableItemColorsHlaysQ4 = menuItemColors;
                    }
                    if (i14 != 0) {
                        dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                    } else {
                        dropdownMenuItemContentPadding = paddingValues;
                    }
                    if (i18 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    function12 = function7;
                    z6 = z5;
                    function13 = function8;
                    function14 = function11;
                    paddingValues3 = dropdownMenuItemContentPadding;
                }
                composer3.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-151119870, i4, i20, "androidx.compose.material3.DropdownMenuItem (Menu.kt:467)");
                }
                ComposerKt.sourceInformationMarkerStart(composer3, 802715709, "CC(remember):Menu.kt#9igjgp");
                objRememberedValue = composer3.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function1() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return MenuKt.DropdownMenuItem$lambda$5$0((SemanticsPropertyReceiver) obj);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer3);
                int i24 = i4 >> 3;
                Composer composer6 = composer3;
                DropdownMenuItemContent(z, function1, function6, SemanticsModifierKt.semantics$default(companion, false, (Function1) objRememberedValue, 1, null), function14, function12, function13, z6, menuItemColorsM3756selectableItemColorsHlaysQ4, menuItemShapes2, paddingValues3, mutableInteractionSource3, composer6, (i4 & AnalyticsListener.EVENT_DRM_SESSION_ACQUIRED) | (57344 & i24) | (458752 & i24) | (3670016 & i24) | (29360128 & i24) | (i24 & 234881024) | (1879048192 & (i4 << 18)), i20 & 126);
                composer2 = composer6;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = companion;
                function9 = function14;
                function10 = function12;
                function8 = function13;
                z4 = z6;
                menuItemColors2 = menuItemColorsM3756selectableItemColorsHlaysQ4;
                paddingValues2 = paddingValues3;
                mutableInteractionSource2 = mutableInteractionSource3;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                function9 = function3;
                z4 = z2;
                menuItemColors2 = menuItemColors;
                paddingValues2 = paddingValues;
                function10 = function7;
                modifier3 = modifier2;
                mutableInteractionSource2 = mutableInteractionSource;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return MenuKt.DropdownMenuItem$lambda$6(z, function0, function2, menuItemShapes, modifier3, function9, function10, function8, z4, menuItemColors2, paddingValues2, mutableInteractionSource2, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i4 |= 100663296;
        if ((i & 805306368) != 0) {
            i4 |= ((i3 & 512) == 0 || !composerStartRestartGroup.changed(menuItemColors)) ? 268435456 : C.BUFFER_FLAG_LAST_SAMPLE;
        }
        i13 = i3 & 1024;
        if (i13 != 0) {
            i15 = i2 | 6;
            i14 = i13;
        } else {
            i14 = i13;
            if ((i2 & 6) == 0) {
                if (composerStartRestartGroup.changed(paddingValues)) {
                    i16 = 4;
                } else {
                    i16 = 2;
                }
                i15 = i2 | i16;
            } else {
                i15 = i2;
            }
        }
        i17 = i3 & 2048;
        if (i17 != 0) {
            i15 |= 48;
            i18 = i17;
        } else {
            i18 = i17;
            if ((i2 & 48) == 0) {
                if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                    i19 = 32;
                } else {
                    i19 = 16;
                }
                i15 |= i19;
            }
        }
        i20 = i15;
        if ((i4 & 306783379) == 306783378) {
            z3 = true;
        } else {
            z3 = true;
        }
        if (composerStartRestartGroup.shouldExecute(z3, i4 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "464@22459L22");
            if ((i & 1) != 0) {
                if (i21 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i5 != 0) {
                    function11 = null;
                } else {
                    function11 = function3;
                }
                if (i7 != 0) {
                    function7 = null;
                }
                if (i9 != 0) {
                    function8 = null;
                }
                if (i11 != 0) {
                    z5 = true;
                } else {
                    z5 = z2;
                }
                if ((i3 & 512) != 0) {
                    menuItemColorsM3756selectableItemColorsHlaysQ4 = MenuDefaults.INSTANCE.m3756selectableItemColorsHlaysQ4(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 48, 2047);
                    composer3 = composerStartRestartGroup;
                    i4 &= -1879048193;
                } else {
                    composer3 = composerStartRestartGroup;
                    menuItemColorsM3756selectableItemColorsHlaysQ4 = menuItemColors;
                }
                if (i14 != 0) {
                    dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                } else {
                    dropdownMenuItemContentPadding = paddingValues;
                }
                if (i18 != 0) {
                    mutableInteractionSource3 = null;
                } else {
                    mutableInteractionSource3 = mutableInteractionSource;
                }
                function12 = function7;
                z6 = z5;
                function13 = function8;
                function14 = function11;
                paddingValues3 = dropdownMenuItemContentPadding;
            } else {
                if (i21 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i5 != 0) {
                    function11 = null;
                } else {
                    function11 = function3;
                }
                if (i7 != 0) {
                    function7 = null;
                }
                if (i9 != 0) {
                    function8 = null;
                }
                if (i11 != 0) {
                    z5 = true;
                } else {
                    z5 = z2;
                }
                if ((i3 & 512) != 0) {
                    menuItemColorsM3756selectableItemColorsHlaysQ4 = MenuDefaults.INSTANCE.m3756selectableItemColorsHlaysQ4(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, 48, 2047);
                    composer3 = composerStartRestartGroup;
                    i4 &= -1879048193;
                } else {
                    composer3 = composerStartRestartGroup;
                    menuItemColorsM3756selectableItemColorsHlaysQ4 = menuItemColors;
                }
                if (i14 != 0) {
                    dropdownMenuItemContentPadding = MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding();
                } else {
                    dropdownMenuItemContentPadding = paddingValues;
                }
                if (i18 != 0) {
                    mutableInteractionSource3 = null;
                } else {
                    mutableInteractionSource3 = mutableInteractionSource;
                }
                function12 = function7;
                z6 = z5;
                function13 = function8;
                function14 = function11;
                paddingValues3 = dropdownMenuItemContentPadding;
            }
            composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-151119870, i4, i20, "androidx.compose.material3.DropdownMenuItem (Menu.kt:467)");
            }
            ComposerKt.sourceInformationMarkerStart(composer3, 802715709, "CC(remember):Menu.kt#9igjgp");
            objRememberedValue = composer3.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return MenuKt.DropdownMenuItem$lambda$5$0((SemanticsPropertyReceiver) obj);
                    }
                };
                composer3.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer3);
            int i25 = i4 >> 3;
            Composer composer7 = composer3;
            DropdownMenuItemContent(z, function1, function6, SemanticsModifierKt.semantics$default(companion, false, (Function1) objRememberedValue, 1, null), function14, function12, function13, z6, menuItemColorsM3756selectableItemColorsHlaysQ4, menuItemShapes2, paddingValues3, mutableInteractionSource3, composer7, (i4 & AnalyticsListener.EVENT_DRM_SESSION_ACQUIRED) | (57344 & i25) | (458752 & i25) | (3670016 & i25) | (29360128 & i25) | (i25 & 234881024) | (1879048192 & (i4 << 18)), i20 & 126);
            composer2 = composer7;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = companion;
            function9 = function14;
            function10 = function12;
            function8 = function13;
            z4 = z6;
            menuItemColors2 = menuItemColorsM3756selectableItemColorsHlaysQ4;
            paddingValues2 = paddingValues3;
            mutableInteractionSource2 = mutableInteractionSource3;
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            function9 = function3;
            z4 = z2;
            menuItemColors2 = menuItemColors;
            paddingValues2 = paddingValues;
            function10 = function7;
            modifier3 = modifier2;
            mutableInteractionSource2 = mutableInteractionSource;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return MenuKt.DropdownMenuItem$lambda$6(z, function0, function2, menuItemShapes, modifier3, function9, function10, function8, z4, menuItemColors2, paddingValues2, mutableInteractionSource2, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DropdownMenuItem$lambda$5$0(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.m8851setRolekuIjeqM(semanticsPropertyReceiver, Role.INSTANCE.m8837getRadioButtono7Vup1c());
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: DropdownMenuContent-Qj0Zi0g, reason: not valid java name */
    public static final void m3796DropdownMenuContentQj0Zi0g(final Modifier modifier, final MutableTransitionState<Boolean> mutableTransitionState, final MutableState<TransformOrigin> mutableState, final ScrollState scrollState, final Shape shape, final long j, final float f, final float f2, final BorderStroke borderStroke, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i) {
        int i2;
        Composer composer2;
        Object obj;
        Composer composerStartRestartGroup = composer.startRestartGroup(848986741);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(DropdownMenuContent)N(modifier,expandedState,transformOriginState,scrollState,shape,containerColor:c#ui.graphics.Color,tonalElevation:c#ui.unit.Dp,shadowElevation:c#ui.unit.Dp,border,content)837@37940L47,839@38123L14,840@38201L14,842@38252L146,847@38436L146,851@38627L7,854@38702L587,871@39461L277,852@38639L1099:Menu.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= (i & 64) == 0 ? composerStartRestartGroup.changed(mutableTransitionState) : composerStartRestartGroup.changedInstance(mutableTransitionState) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changed(mutableState) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changed(scrollState) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= composerStartRestartGroup.changed(shape) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(j) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(f) ? 1048576 : 524288;
        }
        if ((i & 12582912) == 0) {
            i2 |= composerStartRestartGroup.changed(f2) ? 8388608 : 4194304;
        }
        if ((i & 100663296) == 0) {
            i2 |= composerStartRestartGroup.changed(borderStroke) ? 67108864 : 33554432;
        }
        if ((i & 805306368) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function3) ? C.BUFFER_FLAG_LAST_SAMPLE : 268435456;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 306783379) != 306783378, i2 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(848986741, i2, -1, "androidx.compose.material3.DropdownMenuContent (Menu.kt:835)");
            }
            Transition transitionUpdateTransition = TransitionKt.updateTransition((MutableTransitionState) mutableTransitionState, "DropDownMenu", composerStartRestartGroup, MutableTransitionState.$stable | 48 | ((i2 >> 3) & 14), 0);
            final FiniteAnimationSpec finiteAnimationSpecValue = MotionSchemeKt.value(MotionSchemeKeyTokens.FastSpatial, composerStartRestartGroup, 6);
            final FiniteAnimationSpec finiteAnimationSpecValue2 = MotionSchemeKt.value(MotionSchemeKeyTokens.FastEffects, composerStartRestartGroup, 6);
            Function3 function4 = new Function3() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda14
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj2, Object obj3, Object obj4) {
                    return MenuKt.DropdownMenuContent_Qj0Zi0g$lambda$0(finiteAnimationSpecValue, (Transition.Segment) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                }
            };
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1338768149, "CC(animateFloat)P(2)1924@81822L78:Transition.kt#pdpnli");
            TwoWayConverter<Float, AnimationVector1D> vectorConverter = VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -142660079, "CC(animateValue)P(3,2)1833@77788L32,1834@77843L31,1835@77899L23,1837@77935L89:Transition.kt#pdpnli");
            boolean zBooleanValue = ((Boolean) transitionUpdateTransition.getCurrentState()).booleanValue();
            composerStartRestartGroup.startReplaceGroup(143964305);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CN(expanded):Menu.kt#uh7d8r");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(143964305, 0, -1, "androidx.compose.material3.DropdownMenuContent.<anonymous> (Menu.kt:843)");
            }
            float f3 = zBooleanValue ? 1.0f : 0.8f;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composerStartRestartGroup.endReplaceGroup();
            Float fValueOf = Float.valueOf(f3);
            boolean zBooleanValue2 = ((Boolean) transitionUpdateTransition.getTargetState()).booleanValue();
            composerStartRestartGroup.startReplaceGroup(143964305);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CN(expanded):Menu.kt#uh7d8r");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(143964305, 0, -1, "androidx.compose.material3.DropdownMenuContent.<anonymous> (Menu.kt:843)");
            }
            float f4 = zBooleanValue2 ? 1.0f : 0.8f;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composerStartRestartGroup.endReplaceGroup();
            final State stateCreateTransitionAnimation = TransitionKt.createTransitionAnimation(transitionUpdateTransition, fValueOf, Float.valueOf(f4), (FiniteAnimationSpec) function4.invoke(transitionUpdateTransition.getSegment(), composerStartRestartGroup, 0), vectorConverter, "FloatAnimation", composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Function3 function5 = new Function3() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda15
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj2, Object obj3, Object obj4) {
                    return MenuKt.DropdownMenuContent_Qj0Zi0g$lambda$3(finiteAnimationSpecValue2, (Transition.Segment) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                }
            };
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1338768149, "CC(animateFloat)P(2)1924@81822L78:Transition.kt#pdpnli");
            TwoWayConverter<Float, AnimationVector1D> vectorConverter2 = VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -142660079, "CC(animateValue)P(3,2)1833@77788L32,1834@77843L31,1835@77899L23,1837@77935L89:Transition.kt#pdpnli");
            boolean zBooleanValue3 = ((Boolean) transitionUpdateTransition.getCurrentState()).booleanValue();
            composerStartRestartGroup.startReplaceGroup(892761509);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CN(expanded):Menu.kt#uh7d8r");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(892761509, 0, -1, "androidx.compose.material3.DropdownMenuContent.<anonymous> (Menu.kt:848)");
            }
            float f5 = zBooleanValue3 ? 1.0f : 0.0f;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composerStartRestartGroup.endReplaceGroup();
            Float fValueOf2 = Float.valueOf(f5);
            boolean zBooleanValue4 = ((Boolean) transitionUpdateTransition.getTargetState()).booleanValue();
            composerStartRestartGroup.startReplaceGroup(892761509);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CN(expanded):Menu.kt#uh7d8r");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(892761509, 0, -1, "androidx.compose.material3.DropdownMenuContent.<anonymous> (Menu.kt:848)");
            }
            float f6 = zBooleanValue4 ? 1.0f : 0.0f;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composerStartRestartGroup.endReplaceGroup();
            final State stateCreateTransitionAnimation2 = TransitionKt.createTransitionAnimation(transitionUpdateTransition, fValueOf2, Float.valueOf(f6), (FiniteAnimationSpec) function5.invoke(transitionUpdateTransition.getSegment(), composerStartRestartGroup, 0), vectorConverter2, "FloatAnimation", composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ProvidableCompositionLocal<Boolean> localInspectionMode = InspectionModeKt.getLocalInspectionMode();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composerStartRestartGroup.consume(localInspectionMode);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final boolean zBooleanValue5 = ((Boolean) objConsume).booleanValue();
            Modifier.Companion companion = Modifier.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -167489024, "CC(remember):Menu.kt#9igjgp");
            boolean zChanged = composerStartRestartGroup.changed(zBooleanValue5) | composerStartRestartGroup.changed(stateCreateTransitionAnimation) | ((i2 & 112) == 32 || ((i2 & 64) != 0 && composerStartRestartGroup.changedInstance(mutableTransitionState))) | composerStartRestartGroup.changed(stateCreateTransitionAnimation2) | ((i2 & 896) == 256);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                obj = new Function1() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda16
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return MenuKt.DropdownMenuContent_Qj0Zi0g$lambda$6$0(zBooleanValue5, mutableTransitionState, mutableState, stateCreateTransitionAnimation, stateCreateTransitionAnimation2, (GraphicsLayerScope) obj2);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(obj);
            } else {
                obj = objRememberedValue;
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            int i3 = i2 >> 9;
            int i4 = i2 >> 6;
            SurfaceKt.m4323SurfaceT9BRK9s(GraphicsLayerModifierKt.graphicsLayer(companion, (Function1) obj), shape, j, 0L, f, f2, borderStroke, ComposableLambdaKt.rememberComposableLambda(-1463404422, true, new Function2() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda17
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    return MenuKt.DropdownMenuContent_Qj0Zi0g$lambda$7(modifier, scrollState, function3, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, (i3 & 896) | (i3 & 112) | 12582912 | (57344 & i4) | (458752 & i4) | (i4 & 3670016), 8);
            composer2 = composerStartRestartGroup;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda18
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    return MenuKt.DropdownMenuContent_Qj0Zi0g$lambda$8(modifier, mutableTransitionState, mutableState, scrollState, shape, j, f, f2, borderStroke, function3, i, (Composer) obj2, ((Integer) obj3).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DropdownMenuContent_Qj0Zi0g$lambda$6$0(boolean z, MutableTransitionState mutableTransitionState, MutableState mutableState, State state, State state2, GraphicsLayerScope graphicsLayerScope) {
        float fDropdownMenuContent_Qj0Zi0g$lambda$2;
        float fDropdownMenuContent_Qj0Zi0g$lambda$3 = 0.8f;
        float fDropdownMenuContent_Qj0Zi0g$lambda$5 = 1.0f;
        if (!z) {
            fDropdownMenuContent_Qj0Zi0g$lambda$2 = DropdownMenuContent_Qj0Zi0g$lambda$2(state);
        } else {
            fDropdownMenuContent_Qj0Zi0g$lambda$2 = ((Boolean) mutableTransitionState.getTargetState()).booleanValue() ? 1.0f : 0.8f;
        }
        graphicsLayerScope.setScaleX(fDropdownMenuContent_Qj0Zi0g$lambda$2);
        if (!z) {
            fDropdownMenuContent_Qj0Zi0g$lambda$3 = DropdownMenuContent_Qj0Zi0g$lambda$2(state);
        } else if (((Boolean) mutableTransitionState.getTargetState()).booleanValue()) {
            fDropdownMenuContent_Qj0Zi0g$lambda$3 = 1.0f;
        }
        graphicsLayerScope.setScaleY(fDropdownMenuContent_Qj0Zi0g$lambda$3);
        if (!z) {
            fDropdownMenuContent_Qj0Zi0g$lambda$5 = DropdownMenuContent_Qj0Zi0g$lambda$5(state2);
        } else if (!((Boolean) mutableTransitionState.getTargetState()).booleanValue()) {
            fDropdownMenuContent_Qj0Zi0g$lambda$5 = 0.0f;
        }
        graphicsLayerScope.setAlpha(fDropdownMenuContent_Qj0Zi0g$lambda$5);
        graphicsLayerScope.mo7017setTransformOrigin__ExYCQ(((TransformOrigin) mutableState.getValue()).getPackedValue());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DropdownMenuContent_Qj0Zi0g$lambda$7(Modifier modifier, ScrollState scrollState, Function3 function3, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C872@39471L261:Menu.kt#uh7d8r");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1463404422, i, -1, "androidx.compose.material3.DropdownMenuContent.<anonymous> (Menu.kt:872)");
            }
            Modifier modifierVerticalScroll$default = ScrollKt.verticalScroll$default(IntrinsicKt.width(PaddingKt.m1220paddingVpY3zN4$default(modifier, 0.0f, DropdownMenuVerticalPadding, 1, null), IntrinsicSize.Max), scrollState, false, null, false, 14, null);
            ComposerKt.sourceInformationMarkerStart(composer, -483455358, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer, 0);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierVerticalScroll$default);
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

    public static final void DropdownMenuItemContent(final boolean z, final Function0<Unit> function0, final Function2<? super Composer, ? super Integer, Unit> function2, final Modifier modifier, final Function2<? super Composer, ? super Integer, Unit> function3, final Function2<? super Composer, ? super Integer, Unit> function4, final Function2<? super Composer, ? super Integer, Unit> function5, final boolean z2, final MenuItemColors menuItemColors, final MenuItemShapes menuItemShapes, final PaddingValues paddingValues, final MutableInteractionSource mutableInteractionSource, Composer composer, final int i, final int i2) {
        int i3;
        Function2<? super Composer, ? super Integer, Unit> function6;
        int i4;
        Composer composer2;
        MutableInteractionSource mutableInteractionSource2;
        Composer composerStartRestartGroup = composer.startRestartGroup(2007477095);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(DropdownMenuItemContent)N(selected,onClick,text,modifier,leadingIcon,selectedLeadingIcon,trailingIcon,enabled,colors,shapes,contentPadding,interactionSource)903@40514L16,904@40592L14,905@40661L14,906@40739L14,910@40884L85,911@40990L47,924@41466L5714,916@41167L6013:Menu.kt#uh7d8r");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function0) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            function6 = function2;
            i3 |= composerStartRestartGroup.changedInstance(function6) ? 256 : 128;
        } else {
            function6 = function2;
        }
        if ((i & 3072) == 0) {
            i3 |= composerStartRestartGroup.changed(modifier) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function3) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function4) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function5) ? 1048576 : 524288;
        }
        if ((12582912 & i) == 0) {
            i3 |= composerStartRestartGroup.changed(z2) ? 8388608 : 4194304;
        }
        if ((100663296 & i) == 0) {
            i3 |= composerStartRestartGroup.changed(menuItemColors) ? 67108864 : 33554432;
        }
        if ((805306368 & i) == 0) {
            i3 |= composerStartRestartGroup.changed(menuItemShapes) ? C.BUFFER_FLAG_LAST_SAMPLE : 268435456;
        }
        if ((i2 & 6) == 0) {
            i4 = i2 | (composerStartRestartGroup.changed(paddingValues) ? 4 : 2);
        } else {
            i4 = i2;
        }
        if ((i2 & 48) == 0) {
            i4 |= composerStartRestartGroup.changed(mutableInteractionSource) ? 32 : 16;
        }
        int i5 = i4;
        if (!composerStartRestartGroup.shouldExecute(((i3 & 306783379) == 306783378 && (i5 & 19) == 18) ? false : true, i3 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2007477095, i3, i5, "androidx.compose.material3.DropdownMenuItemContent (Menu.kt:898)");
            }
            if (mutableInteractionSource == null) {
                composerStartRestartGroup.startReplaceGroup(1626028660);
                ComposerKt.sourceInformation(composerStartRestartGroup, "900@40337L39");
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 745189198, "CC(remember):Menu.kt#9igjgp");
                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endReplaceGroup();
                mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
            } else {
                composerStartRestartGroup.startReplaceGroup(745188547);
                composerStartRestartGroup.endReplaceGroup();
                mutableInteractionSource2 = mutableInteractionSource;
            }
            final FiniteAnimationSpec finiteAnimationSpecValue = MotionSchemeKt.value(MotionSchemeKeyTokens.FastSpatial, composerStartRestartGroup, 6);
            final FiniteAnimationSpec finiteAnimationSpecValue2 = MotionSchemeKt.value(MotionSchemeKeyTokens.FastEffects, composerStartRestartGroup, 6);
            FiniteAnimationSpec finiteAnimationSpecValue3 = MotionSchemeKt.value(MotionSchemeKeyTokens.FastSpatial, composerStartRestartGroup, 6);
            State<Color> stateM437animateColorAsStateeuL9pac = SingleValueAnimationKt.m437animateColorAsStateeuL9pac(menuItemColors.m3770containerColorWaAFU9c$material3(z2, z), MotionSchemeKt.value(MotionSchemeKeyTokens.FastEffects, composerStartRestartGroup, 6), null, null, composerStartRestartGroup, 0, 12);
            Shape shapeShapeByInteraction = shapeByInteraction(menuItemShapes, z, finiteAnimationSpecValue3, composerStartRestartGroup, ((i3 >> 27) & 14) | ((i3 << 3) & 112));
            final boolean z3 = (function3 == null && function4 == null) ? false : true;
            int i6 = i3;
            final Function2<? super Composer, ? super Integer, Unit> function7 = function6;
            final boolean z4 = function5 != null;
            SurfaceKt.m4324Surfaced85dljk(z, function0, PaddingKt.padding(SizeKt.fillMaxWidth$default(modifier, 0.0f, 1, null), DropdownMenuSelectableItemPadding), z2, shapeShapeByInteraction, DropdownMenuItemContent$lambda$1(stateM437animateColorAsStateeuL9pac), 0L, 0.0f, 0.0f, (BorderStroke) null, mutableInteractionSource2, ComposableLambdaKt.rememberComposableLambda(281271677, true, new Function2() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda19
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return MenuKt.DropdownMenuItemContent$lambda$2(paddingValues, function3, function4, function5, z3, menuItemColors, z2, z, z4, finiteAnimationSpecValue, finiteAnimationSpecValue2, function7, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, (i6 & 126) | ((i6 >> 12) & 7168), 48, 960);
            composer2 = composerStartRestartGroup;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda20
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return MenuKt.DropdownMenuItemContent$lambda$3(z, function0, function2, modifier, function3, function4, function5, z2, menuItemColors, menuItemShapes, paddingValues, mutableInteractionSource, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DropdownMenuItemContent$lambda$2(final PaddingValues paddingValues, final Function2 function2, final Function2 function3, final Function2 function4, final boolean z, final MenuItemColors menuItemColors, final boolean z2, final boolean z3, final boolean z4, final FiniteAnimationSpec finiteAnimationSpec, final FiniteAnimationSpec finiteAnimationSpec2, final Function2 function5, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C926@41542L10,926@41565L5609,926@41511L5663:Menu.kt#uh7d8r");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(281271677, i, -1, "androidx.compose.material3.DropdownMenuItemContent.<anonymous> (Menu.kt:926)");
            }
            TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composer, 6).getLabelLarge(), ComposableLambdaKt.rememberComposableLambda(1450245548, true, new Function2() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return MenuKt.DropdownMenuItemContent$lambda$2$0(paddingValues, function2, function3, function4, z, menuItemColors, z2, z3, z4, finiteAnimationSpec, finiteAnimationSpec2, function5, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DropdownMenuItemContent$lambda$2$0(PaddingValues paddingValues, Function2 function2, Function2 function3, final Function2 function4, final boolean z, MenuItemColors menuItemColors, boolean z2, final boolean z3, final boolean z4, final FiniteAnimationSpec finiteAnimationSpec, final FiniteAnimationSpec finiteAnimationSpec2, final Function2 function5, Composer composer, int i) {
        final Function2 function6;
        int i2;
        int i3;
        final Function2 function7;
        ComposerKt.sourceInformation(composer, "C927@41579L5585:Menu.kt#uh7d8r");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1450245548, i, -1, "androidx.compose.material3.DropdownMenuItemContent.<anonymous>.<anonymous> (Menu.kt:927)");
            }
            Modifier modifierPadding = PaddingKt.padding(SizeKt.m1270sizeInqDBjuR0$default(Modifier.INSTANCE, DropdownMenuItemDefaultMinWidth, SegmentedMenuTokens.INSTANCE.m5743getItemD9Ej5fM(), DropdownMenuItemDefaultMaxWidth, 0.0f, 8, null), paddingValues);
            DropdownMenuItemMeasurePolicy dropdownMenuItemMeasurePolicy = new DropdownMenuItemMeasurePolicy((function2 == null && function3 == null) ? false : true, function4 != null);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierPadding);
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
            Updater.m6070setimpl(composerM6062constructorimpl, dropdownMenuItemMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM6062constructorimpl.getInserting() || !Intrinsics.areEqual(composerM6062constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 2018378200, "C979@44606L985,977@44471L1120:Menu.kt#uh7d8r");
            if (!z) {
                function6 = function2;
                i2 = 1976575629;
                i3 = 54;
                function7 = function3;
                composer.startReplaceGroup(1976575629);
            } else {
                composer.startReplaceGroup(2018321345);
                ComposerKt.sourceInformation(composer, "939@42181L2246,937@42031L2396");
                i3 = 54;
                i2 = 1976575629;
                function6 = function2;
                function7 = function3;
                CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m6804boximpl(menuItemColors.m3785leadingIconColorWaAFU9c$material3(z2, z3))), ComposableLambdaKt.rememberComposableLambda(-365489702, true, new Function2() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda31
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return MenuKt.DropdownMenuItemContent$lambda$2$0$0$0(function7, function6, z3, finiteAnimationSpec, finiteAnimationSpec2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composer, 54), composer, ProvidedValue.$stable | 48);
            }
            composer.endReplaceGroup();
            CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m6804boximpl(menuItemColors.m3786textColorWaAFU9c$material3(z2, z3))), ComposableLambdaKt.rememberComposableLambda(1113206293, true, new Function2() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return MenuKt.DropdownMenuItemContent$lambda$2$0$0$1(z, z4, function5, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, i3), composer, ProvidedValue.$stable | 48);
            if (z4) {
                composer.startReplaceGroup(2021867032);
                ComposerKt.sourceInformation(composer, "1005@45811L494,1003@45660L645");
                CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m6804boximpl(menuItemColors.m3787trailingIconColorWaAFU9c$material3(z2, z3))), ComposableLambdaKt.rememberComposableLambda(1675717379, true, new Function2() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return MenuKt.DropdownMenuItemContent$lambda$2$0$0$2(function4, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composer, i3), composer, ProvidedValue.$stable | 48);
            } else {
                composer.startReplaceGroup(i2);
            }
            composer.endReplaceGroup();
            if (z) {
                composer.startReplaceGroup(2022657532);
                ComposerKt.sourceInformation(composer, "1020@46464L417");
                Modifier modifierLayoutId = LayoutIdKt.layoutId(Modifier.INSTANCE, GhostLeadingIconLayoutId);
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
                ComposerKt.sourceInformationMarkerStart(composer, -91065574, "C1021@46573L282,1021@46554L301:Menu.kt#uh7d8r");
                WrappedLeadingIcon(ComposableLambdaKt.rememberComposableLambda(574061470, true, new Function3() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return MenuKt.DropdownMenuItemContent$lambda$2$0$0$3$0(function6, function7, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composer, i3), composer, 6);
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
                composer.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
            } else {
                composer.startReplaceGroup(i2);
            }
            composer.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DropdownMenuItemContent$lambda$2$0$0$0(final Function2 function2, final Function2 function3, boolean z, FiniteAnimationSpec finiteAnimationSpec, FiniteAnimationSpec finiteAnimationSpec2, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C940@42211L2190:Menu.kt#uh7d8r");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-365489702, i, -1, "androidx.compose.material3.DropdownMenuItemContent.<anonymous>.<anonymous>.<anonymous>.<anonymous> (Menu.kt:940)");
            }
            Modifier modifierLayoutId = LayoutIdKt.layoutId(Modifier.INSTANCE, LeadingIconLayoutId);
            Alignment center = Alignment.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart(composer, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierLayoutId);
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
            Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM6062constructorimpl.getInserting() || !Intrinsics.areEqual(composerM6062constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, -1698913540, "C:Menu.kt#uh7d8r");
            if (function2 != null) {
                composer.startReplaceGroup(-1698885641);
                ComposerKt.sourceInformation(composer, "");
                if (function3 == null) {
                    composer.startReplaceGroup(-1698834398);
                    ComposerKt.sourceInformation(composer, "962@43778L132,946@42570L1340");
                    AnimatedVisibilityKt.AnimatedVisibility(z, (Modifier) null, EnterExitTransitionKt.expandHorizontally$default(finiteAnimationSpec, null, false, null, 14, null).plus(EnterExitTransitionKt.fadeIn$default(finiteAnimationSpec2, 0.0f, 2, null)), EnterExitTransitionKt.shrinkHorizontally$default(finiteAnimationSpec, null, false, null, 14, null).plus(EnterExitTransitionKt.fadeOut$default(finiteAnimationSpec2, 0.0f, 2, null)), (String) null, ComposableLambdaKt.rememberComposableLambda(-1105150970, true, new Function3() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda25
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return MenuKt.DropdownMenuItemContent$lambda$2$0$0$0$0$0(function2, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composer, 54), composer, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 18);
                    composer.endReplaceGroup();
                } else if (z) {
                    composer.startReplaceGroup(-1697446094);
                    ComposerKt.sourceInformation(composer, "966@44029L25,966@44010L44");
                    WrappedLeadingIcon(ComposableLambdaKt.rememberComposableLambda(875676055, true, new Function3() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda26
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return MenuKt.DropdownMenuItemContent$lambda$2$0$0$0$0$1(function2, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composer, 54), composer, 6);
                    composer.endReplaceGroup();
                } else {
                    composer.startReplaceGroup(-1697317382);
                    ComposerKt.sourceInformation(composer, "968@44159L17,968@44140L36");
                    WrappedLeadingIcon(ComposableLambdaKt.rememberComposableLambda(-782077065, true, new Function3() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda27
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return MenuKt.DropdownMenuItemContent$lambda$2$0$0$0$0$2(function3, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composer, 54), composer, 6);
                    composer.endReplaceGroup();
                }
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(-1697162599);
                ComposerKt.sourceInformation(composer, "971@44311L26,971@44292L45");
                WrappedLeadingIcon(ComposableLambdaKt.rememberComposableLambda(-113205134, true, new Function3() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda28
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return MenuKt.DropdownMenuItemContent$lambda$2$0$0$0$0$3(function3, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composer, 54), composer, 6);
                composer.endReplaceGroup();
            }
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
    public static final Unit DropdownMenuItemContent$lambda$2$0$0$0$0$0(final Function2 function2, AnimatedVisibilityScope animatedVisibilityScope, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C963@43843L25,963@43824L44:Menu.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1105150970, i, -1, "androidx.compose.material3.DropdownMenuItemContent.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (Menu.kt:963)");
        }
        WrappedLeadingIcon(ComposableLambdaKt.rememberComposableLambda(-1785376376, true, new Function3() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda8
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return MenuKt.DropdownMenuItemContent$lambda$2$0$0$0$0$0$0(function2, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        }, composer, 54), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DropdownMenuItemContent$lambda$2$0$0$0$0$0$0(Function2 function2, BoxScope boxScope, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C963@43845L21:Menu.kt#uh7d8r");
        if (composer.shouldExecute((i & 17) != 16, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1785376376, i, -1, "androidx.compose.material3.DropdownMenuItemContent.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (Menu.kt:963)");
            }
            function2.invoke(composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DropdownMenuItemContent$lambda$2$0$0$0$0$1(Function2 function2, BoxScope boxScope, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C966@44031L21:Menu.kt#uh7d8r");
        if (composer.shouldExecute((i & 17) != 16, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(875676055, i, -1, "androidx.compose.material3.DropdownMenuItemContent.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (Menu.kt:966)");
            }
            function2.invoke(composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DropdownMenuItemContent$lambda$2$0$0$0$0$2(Function2 function2, BoxScope boxScope, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C968@44161L13:Menu.kt#uh7d8r");
        if (composer.shouldExecute((i & 17) != 16, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-782077065, i, -1, "androidx.compose.material3.DropdownMenuItemContent.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (Menu.kt:968)");
            }
            function2.invoke(composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DropdownMenuItemContent$lambda$2$0$0$0$0$3(Function2 function2, BoxScope boxScope, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C971@44327L8:Menu.kt#uh7d8r");
        if (composer.shouldExecute((i & 17) != 16, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-113205134, i, -1, "androidx.compose.material3.DropdownMenuItemContent.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (Menu.kt:971)");
            }
            Intrinsics.checkNotNull(function2);
            function2.invoke(composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DropdownMenuItemContent$lambda$2$0$0$1(boolean z, boolean z2, Function2 function2, Composer composer, int i) {
        float fM9687constructorimpl;
        float fM9687constructorimpl2;
        ComposerKt.sourceInformation(composer, "C980@44632L937:Menu.kt#uh7d8r");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1113206293, i, -1, "androidx.compose.material3.DropdownMenuItemContent.<anonymous>.<anonymous>.<anonymous>.<anonymous> (Menu.kt:980)");
            }
            Modifier modifierLayoutId = LayoutIdKt.layoutId(Modifier.INSTANCE, "text");
            if (z) {
                fM9687constructorimpl = DropdownMenuIconTextPadding;
            } else {
                fM9687constructorimpl = Dp.m9687constructorimpl(0);
            }
            float f = fM9687constructorimpl;
            if (z2) {
                fM9687constructorimpl2 = DropdownMenuIconTextPadding;
            } else {
                fM9687constructorimpl2 = Dp.m9687constructorimpl(0);
            }
            Modifier modifierM1222paddingqDBjuR0$default = PaddingKt.m1222paddingqDBjuR0$default(modifierLayoutId, f, 0.0f, fM9687constructorimpl2, 0.0f, 10, null);
            Alignment centerStart = Alignment.INSTANCE.getCenterStart();
            ComposerKt.sourceInformationMarkerStart(composer, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(centerStart, false);
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
            Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM6062constructorimpl.getInserting() || !Intrinsics.areEqual(composerM6062constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, -1207652658, "C998@45537L6:Menu.kt#uh7d8r");
            function2.invoke(composer, 0);
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
    public static final Unit DropdownMenuItemContent$lambda$2$0$0$2(Function2 function2, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C1006@45841L438:Menu.kt#uh7d8r");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1675717379, i, -1, "androidx.compose.material3.DropdownMenuItemContent.<anonymous>.<anonymous>.<anonymous>.<anonymous> (Menu.kt:1006)");
            }
            Modifier modifierM1251defaultMinSizeVpY3zN4$default = SizeKt.m1251defaultMinSizeVpY3zN4$default(LayoutIdKt.layoutId(Modifier.INSTANCE, TrailingIconLayoutId), SegmentedMenuTokens.INSTANCE.m5749getItemTrailingIconSizeD9Ej5fM(), 0.0f, 2, null);
            Alignment center = Alignment.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart(composer, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierM1251defaultMinSizeVpY3zN4$default);
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
            Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM6062constructorimpl.getInserting() || !Intrinsics.areEqual(composerM6062constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, -1218946408, "C1013@46235L14:Menu.kt#uh7d8r");
            function2.invoke(composer, 0);
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
    public static final Unit DropdownMenuItemContent$lambda$2$0$0$3$0(Function2 function2, Function2 function3, BoxScope boxScope, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C:Menu.kt#uh7d8r");
        if (composer.shouldExecute((i & 17) != 16, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(574061470, i, -1, "androidx.compose.material3.DropdownMenuItemContent.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (Menu.kt:1022)");
            }
            if (function2 != null) {
                composer.startReplaceGroup(-694458737);
                ComposerKt.sourceInformation(composer, "1023@46670L13");
                function2.invoke(composer, 0);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(-694367938);
                ComposerKt.sourceInformation(composer, "1025@46783L8");
                Intrinsics.checkNotNull(function3);
                function3.invoke(composer, 0);
                composer.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    public static final boolean getHasRoundedCornerShapes(MenuItemShapes menuItemShapes) {
        return (menuItemShapes.getShape() instanceof RoundedCornerShape) && (menuItemShapes.getSelectedShape() instanceof RoundedCornerShape);
    }

    public static final boolean getHasRoundedCornerShapes(MenuGroupShapes menuGroupShapes) {
        return (menuGroupShapes.getShape() instanceof RoundedCornerShape) && (menuGroupShapes.getInactiveShape() instanceof RoundedCornerShape);
    }

    public static final void DropdownMenuItemContent(final Function2<? super Composer, ? super Integer, Unit> function2, final Function0<Unit> function0, final Modifier modifier, final Function2<? super Composer, ? super Integer, Unit> function3, final Function2<? super Composer, ? super Integer, Unit> function4, final boolean z, final MenuItemColors menuItemColors, final PaddingValues paddingValues, final MutableInteractionSource mutableInteractionSource, Composer composer, final int i) {
        Function2<? super Composer, ? super Integer, Unit> function5;
        int i2;
        Function0<Unit> function1;
        Function2<? super Composer, ? super Integer, Unit> function6;
        Function2<? super Composer, ? super Integer, Unit> function7;
        MenuItemColors menuItemColors2;
        MutableInteractionSource mutableInteractionSource2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1325192924);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(DropdownMenuItemContent)N(text,onClick,modifier,leadingIcon,trailingIcon,enabled,colors,contentPadding,interactionSource)1061@47930L2491:Menu.kt#uh7d8r");
        if ((i & 6) == 0) {
            function5 = function2;
            i2 = (composerStartRestartGroup.changedInstance(function5) ? 4 : 2) | i;
        } else {
            function5 = function2;
            i2 = i;
        }
        if ((i & 48) == 0) {
            function1 = function0;
            i2 |= composerStartRestartGroup.changedInstance(function1) ? 32 : 16;
        } else {
            function1 = function0;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changed(modifier) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            function6 = function3;
            i2 |= composerStartRestartGroup.changedInstance(function6) ? 2048 : 1024;
        } else {
            function6 = function3;
        }
        if ((i & 24576) == 0) {
            function7 = function4;
            i2 |= composerStartRestartGroup.changedInstance(function7) ? 16384 : 8192;
        } else {
            function7 = function4;
        }
        if ((196608 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(z) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            menuItemColors2 = menuItemColors;
            i2 |= composerStartRestartGroup.changed(menuItemColors2) ? 1048576 : 524288;
        } else {
            menuItemColors2 = menuItemColors;
        }
        if ((12582912 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(paddingValues) ? 8388608 : 4194304;
        }
        if ((100663296 & i) == 0) {
            mutableInteractionSource2 = mutableInteractionSource;
            i2 |= composerStartRestartGroup.changed(mutableInteractionSource2) ? 67108864 : 33554432;
        } else {
            mutableInteractionSource2 = mutableInteractionSource;
        }
        if (!composerStartRestartGroup.shouldExecute((38347923 & i2) != 38347922, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1325192924, i2, -1, "androidx.compose.material3.DropdownMenuItemContent (Menu.kt:1060)");
            }
            Modifier modifierPadding = PaddingKt.padding(SizeKt.m1270sizeInqDBjuR0$default(SizeKt.fillMaxWidth$default(ClickableKt.m628clickableO2vRcR0$default(modifier, mutableInteractionSource2, RippleKt.m4031rippleH2RKhps$default(true, 0.0f, 0L, 6, null), z, null, null, function1, 24, null), 0.0f, 1, null), DropdownMenuItemDefaultMinWidth, MenuListItemContainerHeight, DropdownMenuItemDefaultMaxWidth, 0.0f, 8, null), paddingValues);
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, composerStartRestartGroup, 48);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierPadding);
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
            Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM6062constructorimpl.getInserting() || !Intrinsics.areEqual(composerM6062constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -407735110, "C101@5232L9:Row.kt#2w3rfo");
            final RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 35357248, "C1081@48787L10,1081@48810L1605,1081@48756L1659:Menu.kt#uh7d8r");
            final Function2<? super Composer, ? super Integer, Unit> function8 = function5;
            final Function2<? super Composer, ? super Integer, Unit> function9 = function7;
            final MenuItemColors menuItemColors3 = menuItemColors2;
            final Function2<? super Composer, ? super Integer, Unit> function10 = function6;
            TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, 6).getLabelLarge(), ComposableLambdaKt.rememberComposableLambda(865999929, true, new Function2() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return MenuKt.DropdownMenuItemContent$lambda$4$0(function10, menuItemColors3, z, function9, rowScopeInstance, function8, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 48);
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return MenuKt.DropdownMenuItemContent$lambda$5(function2, function0, modifier, function3, function4, z, menuItemColors, paddingValues, mutableInteractionSource, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DropdownMenuItemContent$lambda$4$0(final Function2 function2, MenuItemColors menuItemColors, boolean z, final Function2 function3, final RowScope rowScope, final Function2 function4, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C1091@49270L764,1091@49191L843:Menu.kt#uh7d8r");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(865999929, i, -1, "androidx.compose.material3.DropdownMenuItemContent.<anonymous>.<anonymous> (Menu.kt:1082)");
            }
            if (function2 != null) {
                composer.startReplaceGroup(-864613344);
                ComposerKt.sourceInformation(composer, "1085@48991L173,1083@48867L297");
                CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m6804boximpl(MenuItemColors.m3767leadingIconColorWaAFU9c$material3$default(menuItemColors, z, false, 2, null))), ComposableLambdaKt.rememberComposableLambda(1241781204, true, new Function2() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda21
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return MenuKt.DropdownMenuItemContent$lambda$4$0$0(function2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composer, 54), composer, ProvidedValue.$stable | 48);
            } else {
                composer.startReplaceGroup(-913082743);
            }
            composer.endReplaceGroup();
            CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m6804boximpl(MenuItemColors.m3768textColorWaAFU9c$material3$default(menuItemColors, z, false, 2, null))), ComposableLambdaKt.rememberComposableLambda(-893579015, true, new Function2() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda23
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return MenuKt.DropdownMenuItemContent$lambda$4$0$1(rowScope, function2, function3, function4, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, ProvidedValue.$stable | 48);
            if (function3 != null) {
                composer.startReplaceGroup(-863399043);
                ComposerKt.sourceInformation(composer, "1115@50216L175,1113@50091L300");
                CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m6804boximpl(MenuItemColors.m3769trailingIconColorWaAFU9c$material3$default(menuItemColors, z, false, 2, null))), ComposableLambdaKt.rememberComposableLambda(-782441013, true, new Function2() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda24
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return MenuKt.DropdownMenuItemContent$lambda$4$0$2(function3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composer, 54), composer, ProvidedValue.$stable | 48);
            } else {
                composer.startReplaceGroup(-913082743);
            }
            composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DropdownMenuItemContent$lambda$4$0$0(Function2 function2, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C1086@49013L133:Menu.kt#uh7d8r");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1241781204, i, -1, "androidx.compose.material3.DropdownMenuItemContent.<anonymous>.<anonymous>.<anonymous> (Menu.kt:1086)");
            }
            Modifier modifierM1251defaultMinSizeVpY3zN4$default = SizeKt.m1251defaultMinSizeVpY3zN4$default(Modifier.INSTANCE, ListTokens.INSTANCE.m5519getItemLeadingIconSizeD9Ej5fM(), 0.0f, 2, null);
            ComposerKt.sourceInformationMarkerStart(composer, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierM1251defaultMinSizeVpY3zN4$default);
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
            Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM6062constructorimpl.getInserting() || !Intrinsics.areEqual(composerM6062constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, -1523115460, "C1087@49111L13:Menu.kt#uh7d8r");
            function2.invoke(composer, 0);
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
    public static final Unit DropdownMenuItemContent$lambda$4$0$1(RowScope rowScope, Function2 function2, Function2 function3, Function2 function4, Composer composer, int i) {
        float fM9687constructorimpl;
        float fM9687constructorimpl2;
        ComposerKt.sourceInformation(composer, "C1092@49288L732:Menu.kt#uh7d8r");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-893579015, i, -1, "androidx.compose.material3.DropdownMenuItemContent.<anonymous>.<anonymous>.<anonymous> (Menu.kt:1092)");
            }
            Modifier modifierWeight$default = RowScope.weight$default(rowScope, Modifier.INSTANCE, 1.0f, false, 2, null);
            if (function2 != null) {
                fM9687constructorimpl = DropdownMenuItemHorizontalPadding;
            } else {
                fM9687constructorimpl = Dp.m9687constructorimpl(0);
            }
            float f = fM9687constructorimpl;
            if (function3 != null) {
                fM9687constructorimpl2 = DropdownMenuItemHorizontalPadding;
            } else {
                fM9687constructorimpl2 = Dp.m9687constructorimpl(0);
            }
            Modifier modifierM1222paddingqDBjuR0$default = PaddingKt.m1222paddingqDBjuR0$default(modifierWeight$default, f, 0.0f, fM9687constructorimpl2, 0.0f, 10, null);
            ComposerKt.sourceInformationMarkerStart(composer, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
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
            Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM6062constructorimpl.getInserting() || !Intrinsics.areEqual(composerM6062constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, -192291042, "C1109@49996L6:Menu.kt#uh7d8r");
            function4.invoke(composer, 0);
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
    public static final Unit DropdownMenuItemContent$lambda$4$0$2(Function2 function2, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C1116@50238L135:Menu.kt#uh7d8r");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-782441013, i, -1, "androidx.compose.material3.DropdownMenuItemContent.<anonymous>.<anonymous>.<anonymous> (Menu.kt:1116)");
            }
            Modifier modifierM1251defaultMinSizeVpY3zN4$default = SizeKt.m1251defaultMinSizeVpY3zN4$default(Modifier.INSTANCE, ListTokens.INSTANCE.m5530getItemTrailingIconSizeD9Ej5fM(), 0.0f, 2, null);
            ComposerKt.sourceInformationMarkerStart(composer, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierM1251defaultMinSizeVpY3zN4$default);
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
            Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM6062constructorimpl.getInserting() || !Intrinsics.areEqual(composerM6062constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, -845165948, "C1117@50337L14:Menu.kt#uh7d8r");
            function2.invoke(composer, 0);
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

    /* JADX WARN: Code duplicated, block: B:14:0x0053  */
    /* JADX WARN: Code duplicated, block: B:4:0x000d  */
    public static final long calculateTransformOrigin(IntRect intRect, IntRect intRect2) {
        float fMax;
        float fMax2 = 1.0f;
        if (intRect2.getLeft() >= intRect.getRight()) {
            fMax = 0.0f;
        } else if (intRect2.getRight() <= intRect.getLeft()) {
            fMax = 1.0f;
        } else if (intRect2.getWidth() == 0) {
            fMax = 0.0f;
        } else {
            fMax = (((Math.max(intRect.getLeft(), intRect2.getLeft()) + Math.min(intRect.getRight(), intRect2.getRight())) / 2) - intRect2.getLeft()) / intRect2.getWidth();
        }
        if (intRect2.getTop() >= intRect.getBottom()) {
            fMax2 = 0.0f;
        } else if (intRect2.getBottom() > intRect.getTop()) {
            if (intRect2.getHeight() == 0) {
                fMax2 = 0.0f;
            } else {
                fMax2 = (((Math.max(intRect.getTop(), intRect2.getTop()) + Math.min(intRect.getBottom(), intRect2.getBottom())) / 2) - intRect2.getTop()) / intRect2.getHeight();
            }
        }
        return TransformOriginKt.TransformOrigin(fMax, fMax2);
    }

    private static final Shape shapeByInteraction(MenuItemShapes menuItemShapes, boolean z, FiniteAnimationSpec<Float> finiteAnimationSpec, Composer composer, int i) {
        Shape shape;
        composer.startReplaceGroup(1804150103);
        ComposerKt.sourceInformation(composer, "C(shapeByInteraction)N(shapes,selected,animationSpec):Menu.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1804150103, i, -1, "androidx.compose.material3.shapeByInteraction (Menu.kt:1159)");
        }
        if (z) {
            shape = menuItemShapes.getSelectedShape();
        } else {
            shape = menuItemShapes.getShape();
        }
        if (getHasRoundedCornerShapes(menuItemShapes)) {
            composer.startReplaceGroup(215284099);
            ComposerKt.sourceInformation(composer, "");
            composer.startMovableGroup(-1378528456, composer.joinKey(menuItemShapes.getShape(), menuItemShapes.getSelectedShape()));
            ComposerKt.sourceInformation(composer, "1169@51988L65");
            Intrinsics.checkNotNull(shape, "null cannot be cast to non-null type androidx.compose.foundation.shape.RoundedCornerShape");
            Shape shapeRememberAnimatedShape = AnimatedShapeKt.rememberAnimatedShape((RoundedCornerShape) shape, finiteAnimationSpec, composer, (i >> 3) & 112);
            composer.endMovableGroup();
            composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceGroup();
            return shapeRememberAnimatedShape;
        }
        composer.startReplaceGroup(163767307);
        composer.endReplaceGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return shape;
    }

    private static final Shape shapeByInteraction(MenuGroupShapes menuGroupShapes, boolean z, boolean z2, FiniteAnimationSpec<Float> finiteAnimationSpec, Composer composer, int i) {
        Shape shape;
        composer.startReplaceGroup(1230868161);
        ComposerKt.sourceInformation(composer, "C(shapeByInteraction)N(shapes,hasBeenHovered,hovered,animationSpec):Menu.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1230868161, i, -1, "androidx.compose.material3.shapeByInteraction (Menu.kt:1182)");
        }
        if (z && !z2) {
            shape = menuGroupShapes.getInactiveShape();
        } else {
            shape = menuGroupShapes.getShape();
        }
        if (getHasRoundedCornerShapes(menuGroupShapes)) {
            composer.startReplaceGroup(-1637034503);
            ComposerKt.sourceInformation(composer, "");
            composer.startMovableGroup(1748307970, composer.joinKey(menuGroupShapes.getShape(), menuGroupShapes.getInactiveShape()));
            ComposerKt.sourceInformation(composer, "1192@52569L65");
            Intrinsics.checkNotNull(shape, "null cannot be cast to non-null type androidx.compose.foundation.shape.RoundedCornerShape");
            Shape shapeRememberAnimatedShape = AnimatedShapeKt.rememberAnimatedShape((RoundedCornerShape) shape, finiteAnimationSpec, composer, (i >> 6) & 112);
            composer.endMovableGroup();
            composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceGroup();
            return shapeRememberAnimatedShape;
        }
        composer.startReplaceGroup(-1689127647);
        composer.endReplaceGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return shape;
    }

    private static final void WrappedLeadingIcon(final Function3<? super BoxScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1482876964);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(WrappedLeadingIcon)N(content)1200@52757L133:Menu.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(function3) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1482876964, i2, -1, "androidx.compose.material3.WrappedLeadingIcon (Menu.kt:1199)");
            }
            Modifier modifierM1251defaultMinSizeVpY3zN4$default = SizeKt.m1251defaultMinSizeVpY3zN4$default(Modifier.INSTANCE, SegmentedMenuTokens.INSTANCE.m5746getItemLeadingIconSizeD9Ej5fM(), 0.0f, 2, null);
            int i3 = ((i2 << 9) & 7168) | 6;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1251defaultMinSizeVpY3zN4$default);
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
            function3.invoke(BoxScopeInstance.INSTANCE, composerStartRestartGroup, Integer.valueOf(((i3 >> 6) & 112) | 6));
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.MenuKt$$ExternalSyntheticLambda22
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return MenuKt.WrappedLeadingIcon$lambda$0(function3, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final float getMenuVerticalMargin() {
        return MenuVerticalMargin;
    }

    public static final float getMenuHorizontalMargin() {
        return MenuHorizontalMargin;
    }

    public static final float getDropdownMenuItemHorizontalPadding() {
        return DropdownMenuItemHorizontalPadding;
    }

    public static final float getDropdownMenuGroupVerticalPadding() {
        return DropdownMenuGroupVerticalPadding;
    }

    public static final float getDropdownMenuVerticalPadding() {
        return DropdownMenuVerticalPadding;
    }

    public static final float getDropdownMenuItemDefaultMinWidth() {
        return DropdownMenuItemDefaultMinWidth;
    }

    public static final float getDropdownMenuItemDefaultMaxWidth() {
        return DropdownMenuItemDefaultMaxWidth;
    }

    public static final float getDropdownMenuGroupDefaultMinHeight() {
        return DropdownMenuGroupDefaultMinHeight;
    }

    private static final boolean DropdownMenuGroup_BfByrIA$lambda$1(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    private static final float DropdownMenuContent_Qj0Zi0g$lambda$2(State<Float> state) {
        return state.getValue().floatValue();
    }

    private static final float DropdownMenuContent_Qj0Zi0g$lambda$5(State<Float> state) {
        return state.getValue().floatValue();
    }

    private static final long DropdownMenuItemContent$lambda$1(State<Color> state) {
        return state.getValue().m6824unboximpl();
    }

    static {
        float f = 48;
        MenuVerticalMargin = Dp.m9687constructorimpl(f);
        float f2 = 8;
        MenuHorizontalMargin = Dp.m9687constructorimpl(f2);
        MenuListItemContainerHeight = Dp.m9687constructorimpl(f);
        DropdownMenuIconTextPadding = Dp.m9687constructorimpl(f2);
        DropdownMenuVerticalPadding = Dp.m9687constructorimpl(f2);
    }
}
