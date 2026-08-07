package androidx.compose.material3;

import androidx.compose.animation.SingleValueAnimationKt;
import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.IndicationKt;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.selection.SelectableKt;
import androidx.compose.material3.internal.MappedInteractionSource;
import androidx.compose.material3.internal.ProvideContentColorTextStyleKt;
import androidx.compose.material3.tokens.MotionSchemeKeyTokens;
import androidx.compose.material3.tokens.NavigationRailBaselineItemTokens;
import androidx.compose.material3.tokens.NavigationRailCollapsedTokens;
import androidx.compose.material3.tokens.NavigationRailVerticalItemTokens;
import androidx.compose.material3.tokens.ShapeKeyTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.util.ListUtilsKt;
import androidx.profileinstaller.ProfileVerifier;
import com.box.android.domain.analytics.BoxAnalyticsParams;
import com.box.android.domain.metrics.hubs.HubsObservability;
import com.facebook.react.uimanager.ViewProps;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: NavigationRail.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u001aw\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052 \b\u0002\u0010\u0007\u001a\u001a\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0001\u0018\u00010\b¢\u0006\u0002\b\n¢\u0006\u0002\b\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\u001c\u0010\u000e\u001a\u0018\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\b¢\u0006\u0002\b\n¢\u0006\u0002\b\u000bH\u0007¢\u0006\u0004\b\u000f\u0010\u0010\u001a\u0081\u0001\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00010\u00152\u0011\u0010\u0016\u001a\r\u0012\u0004\u0012\u00020\u00010\u0015¢\u0006\u0002\b\n2\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0017\u001a\u00020\u00132\u0015\b\u0002\u0010\u0018\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0015¢\u0006\u0002\b\n2\b\b\u0002\u0010\u0019\u001a\u00020\u00132\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0007¢\u0006\u0002\u0010\u001e\u001a\u007f\u0010\u001f\u001a\u00020\u00012\u0011\u0010 \u001a\r\u0012\u0004\u0012\u00020\u00010\u0015¢\u0006\u0002\b\n2\u0011\u0010!\u001a\r\u0012\u0004\u0012\u00020\u00010\u0015¢\u0006\u0002\b\n2\u0011\u0010\u0016\u001a\r\u0012\u0004\u0012\u00020\u00010\u0015¢\u0006\u0002\b\n2\u0013\u0010\u0018\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0015¢\u0006\u0002\b\n2\u0006\u0010\u0019\u001a\u00020\u00132\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020#0\u00152\f\u0010$\u001a\b\u0012\u0004\u0012\u00020#0\u0015H\u0003¢\u0006\u0002\u0010%\u001a5\u0010&\u001a\u00020'*\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020*2\b\u0010,\u001a\u0004\u0018\u00010*2\u0006\u0010-\u001a\u00020.H\u0002¢\u0006\u0004\b/\u00100\u001aM\u00101\u001a\u00020'*\u00020(2\u0006\u00102\u001a\u00020*2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020*2\b\u0010,\u001a\u0004\u0018\u00010*2\u0006\u0010-\u001a\u00020.2\u0006\u0010\u0019\u001a\u00020\u00132\u0006\u00103\u001a\u00020#H\u0002¢\u0006\u0004\b4\u00105\"\u000e\u00106\u001a\u000207X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u00108\u001a\u000207X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u00109\u001a\u000207X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010:\u001a\u000207X\u0082T¢\u0006\u0002\n\u0000\"\u0016\u0010;\u001a\u00020<X\u0080\u0004¢\u0006\n\n\u0002\u0010?\u001a\u0004\b=\u0010>\"\u0010\u0010@\u001a\u00020<X\u0082\u0004¢\u0006\u0004\n\u0002\u0010?\"\u0016\u0010A\u001a\u00020<X\u0080\u0004¢\u0006\n\n\u0002\u0010?\u001a\u0004\bB\u0010>\"\u0016\u0010C\u001a\u00020<X\u0080\u0004¢\u0006\n\n\u0002\u0010?\u001a\u0004\bD\u0010>\"\u0016\u0010E\u001a\u00020<X\u0080\u0004¢\u0006\n\n\u0002\u0010?\u001a\u0004\bF\u0010>\"\u0010\u0010G\u001a\u00020<X\u0082\u0004¢\u0006\u0004\n\u0002\u0010?\"\u0010\u0010H\u001a\u00020<X\u0082\u0004¢\u0006\u0004\n\u0002\u0010?\"\u0010\u0010I\u001a\u00020<X\u0082\u0004¢\u0006\u0004\n\u0002\u0010?\"\"\u0010J\u001a\b\u0012\u0004\u0012\u00020L0K8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bM\u0010N\u001a\u0004\bO\u0010P¨\u0006Q²\u0006\n\u0010R\u001a\u00020\u0005X\u008a\u0084\u0002²\u0006\n\u0010S\u001a\u00020\u0005X\u008a\u0084\u0002"}, d2 = {"NavigationRail", "", "modifier", "Landroidx/compose/ui/Modifier;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", BoxAnalyticsParams.CTA_LOCATION_HEADER, "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "windowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "content", "NavigationRail-qi6gXK8", "(Landroidx/compose/ui/Modifier;JJLkotlin/jvm/functions/Function3;Landroidx/compose/foundation/layout/WindowInsets;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "NavigationRailItem", "selected", "", ViewProps.ON_CLICK, "Lkotlin/Function0;", "icon", "enabled", "label", "alwaysShowLabel", "colors", "Landroidx/compose/material3/NavigationRailItemColors;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "(ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;ZLandroidx/compose/material3/NavigationRailItemColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "NavigationRailItemLayout", NavigationRailKt.IndicatorRippleLayoutIdTag, NavigationRailKt.IndicatorLayoutIdTag, "alphaAnimationProgress", "", "sizeAnimationProgress", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "placeIcon", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "iconPlaceable", "Landroidx/compose/ui/layout/Placeable;", "indicatorRipplePlaceable", "indicatorPlaceable", "constraints", "Landroidx/compose/ui/unit/Constraints;", "placeIcon-X9ElhV4", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;J)Landroidx/compose/ui/layout/MeasureResult;", "placeLabelAndIcon", "labelPlaceable", "animationProgress", "placeLabelAndIcon-zUg2_y0", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;JZF)Landroidx/compose/ui/layout/MeasureResult;", "IndicatorRippleLayoutIdTag", "", "IndicatorLayoutIdTag", "IconLayoutIdTag", "LabelLayoutIdTag", "NavigationRailVerticalPadding", "Landroidx/compose/ui/unit/Dp;", "getNavigationRailVerticalPadding", "()F", "F", "NavigationRailHeaderPadding", "NavigationRailItemWidth", "getNavigationRailItemWidth", "NavigationRailItemHeight", "getNavigationRailItemHeight", "NavigationRailItemVerticalPadding", "getNavigationRailItemVerticalPadding", "IndicatorHorizontalPadding", "IndicatorVerticalPaddingWithLabel", "IndicatorVerticalPaddingNoLabel", "LocalNavigationRailOverride", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/compose/material3/NavigationRailOverride;", "getLocalNavigationRailOverride$annotations", "()V", "getLocalNavigationRailOverride", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "material3", "iconColor", "textColor"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class NavigationRailKt {
    private static final String IconLayoutIdTag = "icon";
    private static final float IndicatorHorizontalPadding;
    private static final String IndicatorLayoutIdTag = "indicator";
    private static final String IndicatorRippleLayoutIdTag = "indicatorRipple";
    private static final float IndicatorVerticalPaddingNoLabel;
    private static final float IndicatorVerticalPaddingWithLabel;
    private static final String LabelLayoutIdTag = "label";
    private static final float NavigationRailItemVerticalPadding;
    private static final float NavigationRailVerticalPadding;
    private static final float NavigationRailHeaderPadding = Dp.m9687constructorimpl(8);
    private static final float NavigationRailItemWidth = NavigationRailCollapsedTokens.INSTANCE.m5576getNarrowContainerWidthD9Ej5fM();
    private static final float NavigationRailItemHeight = NavigationRailVerticalItemTokens.INSTANCE.m5589getActiveIndicatorWidthD9Ej5fM();
    private static final ProvidableCompositionLocal<NavigationRailOverride> LocalNavigationRailOverride = CompositionLocalKt.compositionLocalOf$default(null, new Function0() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda15
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return NavigationRailKt.LocalNavigationRailOverride$lambda$0();
        }
    }, 1, null);

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NavigationRailItem$lambda$4(boolean z, Function0 function0, Function2 function2, Modifier modifier, boolean z2, Function2 function3, boolean z3, NavigationRailItemColors navigationRailItemColors, MutableInteractionSource mutableInteractionSource, int i, int i2, Composer composer, int i3) {
        NavigationRailItem(z, function0, function2, modifier, z2, function3, z3, navigationRailItemColors, mutableInteractionSource, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NavigationRailItemLayout$lambda$2(Function2 function2, Function2 function3, Function2 function4, Function2 function5, boolean z, Function0 function0, Function0 function1, int i, Composer composer, int i2) {
        NavigationRailItemLayout(function2, function3, function4, function5, z, function0, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NavigationRail_qi6gXK8$lambda$1(Modifier modifier, long j, long j2, Function3 function3, WindowInsets windowInsets, Function3 function4, int i, int i2, Composer composer, int i3) {
        m3935NavigationRailqi6gXK8(modifier, j, j2, function3, windowInsets, function4, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ void getLocalNavigationRailOverride$annotations() {
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0129  */
    /* JADX WARN: Code duplicated, block: B:102:0x013a  */
    /* JADX WARN: Code duplicated, block: B:105:0x0145  */
    /* JADX WARN: Code duplicated, block: B:108:0x0172  */
    /* JADX WARN: Code duplicated, block: B:110:0x017e  */
    /* JADX WARN: Code duplicated, block: B:113:0x018c  */
    /* JADX WARN: Code duplicated, block: B:115:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:48:0x0084  */
    /* JADX WARN: Code duplicated, block: B:50:0x0088  */
    /* JADX WARN: Code duplicated, block: B:52:0x0090  */
    /* JADX WARN: Code duplicated, block: B:53:0x0093  */
    /* JADX WARN: Code duplicated, block: B:56:0x0099  */
    /* JADX WARN: Code duplicated, block: B:59:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:61:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:62:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:64:0x00af  */
    /* JADX WARN: Code duplicated, block: B:67:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:68:0x00bd  */
    /* JADX WARN: Code duplicated, block: B:71:0x00c6  */
    /* JADX WARN: Code duplicated, block: B:88:0x00fd A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:89:0x00ff  */
    /* JADX WARN: Code duplicated, block: B:90:0x0104  */
    /* JADX WARN: Code duplicated, block: B:93:0x010a  */
    /* JADX WARN: Code duplicated, block: B:96:0x0116  */
    /* JADX WARN: Code duplicated, block: B:98:0x0123  */
    /* JADX INFO: renamed from: NavigationRail-qi6gXK8, reason: not valid java name */
    public static final void m3935NavigationRailqi6gXK8(Modifier modifier, long j, long j2, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, WindowInsets windowInsets, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function4, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        long containerColor;
        long jM3051contentColorForek8zF_U;
        Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function5;
        WindowInsets windowInsets2;
        Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function6;
        boolean z;
        Modifier modifier3;
        final long j3;
        final long j4;
        final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function7;
        final WindowInsets windowInsets3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        WindowInsets windowInsets4;
        long j5;
        long j6;
        Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function8;
        int i4;
        Composer composerStartRestartGroup = composer.startRestartGroup(331386280);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(NavigationRail)N(modifier,containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,header,windowInsets,content)129@6135L7,*138@6454L16:NavigationRail.kt#uh7d8r");
        int i5 = i2 & 1;
        if (i5 != 0) {
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
                containerColor = j;
                int i6 = composerStartRestartGroup.changed(containerColor) ? 32 : 16;
                i3 |= i6;
            } else {
                containerColor = j;
            }
            i3 |= i6;
        } else {
            containerColor = j;
        }
        if ((i & 384) == 0) {
            if ((i2 & 4) == 0) {
                jM3051contentColorForek8zF_U = j2;
                int i7 = composerStartRestartGroup.changed(jM3051contentColorForek8zF_U) ? 256 : 128;
                i3 |= i7;
            } else {
                jM3051contentColorForek8zF_U = j2;
            }
            i3 |= i7;
        } else {
            jM3051contentColorForek8zF_U = j2;
        }
        int i8 = i2 & 8;
        if (i8 == 0) {
            if ((i & 3072) == 0) {
                function5 = function3;
                i3 |= composerStartRestartGroup.changedInstance(function5) ? 2048 : 1024;
            }
            if ((i & 24576) == 0) {
                if ((i2 & 16) == 0) {
                    windowInsets2 = windowInsets;
                    int i9 = composerStartRestartGroup.changed(windowInsets2) ? 16384 : 8192;
                    i3 |= i9;
                } else {
                    windowInsets2 = windowInsets;
                }
                i3 |= i9;
            } else {
                windowInsets2 = windowInsets;
            }
            if ((196608 & i) == 0) {
                function6 = function4;
                if (composerStartRestartGroup.changedInstance(function6)) {
                    i4 = 131072;
                } else {
                    i4 = 65536;
                }
                i3 |= i4;
            } else {
                function6 = function4;
            }
            if ((74899 & i3) != 74898) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "123@5842L14,124@5884L31,126@6031L12");
                if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                    if (i5 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if ((i2 & 2) != 0) {
                        containerColor = NavigationRailDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        i3 &= -113;
                    }
                    if ((i2 & 4) != 0) {
                        jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i3 >> 3) & 14);
                        i3 &= -897;
                    }
                    if (i8 != 0) {
                        function5 = null;
                    }
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                        modifier3 = companion;
                        windowInsets4 = NavigationRailDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                        j5 = containerColor;
                        j6 = jM3051contentColorForek8zF_U;
                        function8 = function5;
                    } else {
                        modifier3 = companion;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(331386280, i3, -1, "androidx.compose.material3.NavigationRail (NavigationRail.kt:128)");
                    }
                    ProvidableCompositionLocal<NavigationRailOverride> providableCompositionLocal = LocalNavigationRailOverride;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume = composerStartRestartGroup.consume(providableCompositionLocal);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ((NavigationRailOverride) objConsume).NavigationRail(new NavigationRailOverrideScope(modifier3, j5, j6, function8, windowInsets4, function6, null), composerStartRestartGroup, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    j3 = j5;
                    j4 = j6;
                    function7 = function8;
                    windowInsets3 = windowInsets4;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    if ((i2 & 2) != 0) {
                        i3 &= -113;
                    }
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                    }
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                    }
                    modifier3 = modifier2;
                }
                j5 = containerColor;
                j6 = jM3051contentColorForek8zF_U;
                function8 = function5;
                windowInsets4 = windowInsets2;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(331386280, i3, -1, "androidx.compose.material3.NavigationRail (NavigationRail.kt:128)");
                }
                ProvidableCompositionLocal<NavigationRailOverride> providableCompositionLocal2 = LocalNavigationRailOverride;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume2 = composerStartRestartGroup.consume(providableCompositionLocal2);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ((NavigationRailOverride) objConsume2).NavigationRail(new NavigationRailOverrideScope(modifier3, j5, j6, function8, windowInsets4, function6, null), composerStartRestartGroup, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                j3 = j5;
                j4 = j6;
                function7 = function8;
                windowInsets3 = windowInsets4;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                j3 = containerColor;
                j4 = jM3051contentColorForek8zF_U;
                function7 = function5;
                windowInsets3 = windowInsets2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final Modifier modifier4 = modifier3;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return NavigationRailKt.NavigationRail_qi6gXK8$lambda$1(modifier4, j3, j4, function7, windowInsets3, function4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 3072;
        function5 = function3;
        if ((i & 24576) == 0) {
            if ((i2 & 16) == 0) {
                windowInsets2 = windowInsets;
                if (composerStartRestartGroup.changed(windowInsets2)) {
                }
                i3 |= i9;
            } else {
                windowInsets2 = windowInsets;
            }
            i3 |= i9;
        } else {
            windowInsets2 = windowInsets;
        }
        if ((196608 & i) == 0) {
            function6 = function4;
            if (composerStartRestartGroup.changedInstance(function6)) {
                i4 = 131072;
            } else {
                i4 = 65536;
            }
            i3 |= i4;
        } else {
            function6 = function4;
        }
        if ((74899 & i3) != 74898) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "123@5842L14,124@5884L31,126@6031L12");
            if ((i & 1) != 0) {
                if (i5 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if ((i2 & 2) != 0) {
                    containerColor = NavigationRailDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                    i3 &= -113;
                }
                if ((i2 & 4) != 0) {
                    jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i3 >> 3) & 14);
                    i3 &= -897;
                }
                if (i8 != 0) {
                    function5 = null;
                }
                if ((i2 & 16) != 0) {
                    i3 &= -57345;
                    modifier3 = companion;
                    windowInsets4 = NavigationRailDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                    j5 = containerColor;
                    j6 = jM3051contentColorForek8zF_U;
                    function8 = function5;
                } else {
                    modifier3 = companion;
                    j5 = containerColor;
                    j6 = jM3051contentColorForek8zF_U;
                    function8 = function5;
                    windowInsets4 = windowInsets2;
                }
            } else {
                if (i5 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if ((i2 & 2) != 0) {
                    containerColor = NavigationRailDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                    i3 &= -113;
                }
                if ((i2 & 4) != 0) {
                    jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(containerColor, composerStartRestartGroup, (i3 >> 3) & 14);
                    i3 &= -897;
                }
                if (i8 != 0) {
                    function5 = null;
                }
                if ((i2 & 16) != 0) {
                    i3 &= -57345;
                    modifier3 = companion;
                    windowInsets4 = NavigationRailDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                    j5 = containerColor;
                    j6 = jM3051contentColorForek8zF_U;
                    function8 = function5;
                } else {
                    modifier3 = companion;
                    j5 = containerColor;
                    j6 = jM3051contentColorForek8zF_U;
                    function8 = function5;
                    windowInsets4 = windowInsets2;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(331386280, i3, -1, "androidx.compose.material3.NavigationRail (NavigationRail.kt:128)");
            }
            ProvidableCompositionLocal<NavigationRailOverride> providableCompositionLocal3 = LocalNavigationRailOverride;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume3 = composerStartRestartGroup.consume(providableCompositionLocal3);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ((NavigationRailOverride) objConsume3).NavigationRail(new NavigationRailOverrideScope(modifier3, j5, j6, function8, windowInsets4, function6, null), composerStartRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            j3 = j5;
            j4 = j6;
            function7 = function8;
            windowInsets3 = windowInsets4;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
            j3 = containerColor;
            j4 = jM3051contentColorForek8zF_U;
            function7 = function5;
            windowInsets3 = windowInsets2;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return NavigationRailKt.NavigationRail_qi6gXK8$lambda$1(modifier5, j3, j4, function7, windowInsets3, function4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX WARN: Code duplicated, block: B:104:0x013a A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:105:0x013c  */
    /* JADX WARN: Code duplicated, block: B:107:0x0143  */
    /* JADX WARN: Code duplicated, block: B:109:0x0146  */
    /* JADX WARN: Code duplicated, block: B:111:0x0149  */
    /* JADX WARN: Code duplicated, block: B:112:0x014b  */
    /* JADX WARN: Code duplicated, block: B:115:0x0151  */
    /* JADX WARN: Code duplicated, block: B:116:0x0159  */
    /* JADX WARN: Code duplicated, block: B:119:0x0162  */
    /* JADX WARN: Code duplicated, block: B:120:0x0164  */
    /* JADX WARN: Code duplicated, block: B:124:0x0170  */
    /* JADX WARN: Code duplicated, block: B:127:0x017d  */
    /* JADX WARN: Code duplicated, block: B:129:0x019a  */
    /* JADX WARN: Code duplicated, block: B:131:0x01ac  */
    /* JADX WARN: Code duplicated, block: B:134:0x01d7  */
    /* JADX WARN: Code duplicated, block: B:135:0x01e7  */
    /* JADX WARN: Code duplicated, block: B:138:0x0287  */
    /* JADX WARN: Code duplicated, block: B:141:0x0293  */
    /* JADX WARN: Code duplicated, block: B:142:0x0297  */
    /* JADX WARN: Code duplicated, block: B:145:0x02bc  */
    /* JADX WARN: Code duplicated, block: B:147:0x02ca  */
    /* JADX WARN: Code duplicated, block: B:150:0x02f7  */
    /* JADX WARN: Code duplicated, block: B:151:0x02fa  */
    /* JADX WARN: Code duplicated, block: B:154:0x031e  */
    /* JADX WARN: Code duplicated, block: B:155:0x0321  */
    /* JADX WARN: Code duplicated, block: B:158:0x0365  */
    /* JADX WARN: Code duplicated, block: B:160:0x036d  */
    /* JADX WARN: Code duplicated, block: B:163:0x038f  */
    /* JADX WARN: Code duplicated, block: B:165:0x0397  */
    /* JADX WARN: Code duplicated, block: B:168:0x03a9  */
    /* JADX WARN: Code duplicated, block: B:169:0x03c3  */
    /* JADX WARN: Code duplicated, block: B:172:0x0407  */
    /* JADX WARN: Code duplicated, block: B:174:0x040f  */
    /* JADX WARN: Code duplicated, block: B:177:0x042c  */
    /* JADX WARN: Code duplicated, block: B:179:0x0434  */
    /* JADX WARN: Code duplicated, block: B:182:0x046f  */
    /* JADX WARN: Code duplicated, block: B:184:0x047d  */
    /* JADX WARN: Code duplicated, block: B:187:0x048f  */
    /* JADX WARN: Code duplicated, block: B:189:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:37:0x0068  */
    /* JADX WARN: Code duplicated, block: B:38:0x006b  */
    /* JADX WARN: Code duplicated, block: B:40:0x006f  */
    /* JADX WARN: Code duplicated, block: B:42:0x0077  */
    /* JADX WARN: Code duplicated, block: B:43:0x007a  */
    /* JADX WARN: Code duplicated, block: B:48:0x0086  */
    /* JADX WARN: Code duplicated, block: B:49:0x0088  */
    /* JADX WARN: Code duplicated, block: B:51:0x008b  */
    /* JADX WARN: Code duplicated, block: B:53:0x0093  */
    /* JADX WARN: Code duplicated, block: B:54:0x0096  */
    /* JADX WARN: Code duplicated, block: B:59:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:60:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:62:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:64:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:65:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:69:0x00c0  */
    /* JADX WARN: Code duplicated, block: B:71:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:74:0x00cf A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:77:0x00d6  */
    /* JADX WARN: Code duplicated, block: B:80:0x00de  */
    /* JADX WARN: Code duplicated, block: B:81:0x00e1  */
    /* JADX WARN: Code duplicated, block: B:83:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:85:0x00ef  */
    /* JADX WARN: Code duplicated, block: B:86:0x00f2  */
    /* JADX WARN: Code duplicated, block: B:91:0x0105  */
    /* JADX WARN: Code duplicated, block: B:92:0x0107  */
    /* JADX WARN: Code duplicated, block: B:95:0x0110  */
    /* JADX WARN: Code duplicated, block: B:97:0x0120  */
    /* JADX WARN: Type inference failed for: r7v20 */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v5, types: [boolean, int] */
    public static final void NavigationRailItem(final boolean z, final Function0<Unit> function0, final Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, boolean z2, Function2<? super Composer, ? super Integer, Unit> function3, boolean z3, NavigationRailItemColors navigationRailItemColors, MutableInteractionSource mutableInteractionSource, Composer composer, final int i, final int i2) {
        int i3;
        final Modifier modifier2;
        int i4;
        boolean z4;
        int i5;
        int i6;
        Function2<? super Composer, ? super Integer, Unit> function4;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        boolean z5;
        final boolean z6;
        final MutableInteractionSource mutableInteractionSource2;
        final boolean z7;
        Composer composer2;
        final Function2<? super Composer, ? super Integer, Unit> function5;
        final NavigationRailItemColors navigationRailItemColors2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        boolean z8;
        NavigationRailItemColors navigationRailItemColorsColors;
        int i12;
        final NavigationRailItemColors navigationRailItemColors3;
        Modifier modifier3;
        final boolean z9;
        final Function2<? super Composer, ? super Integer, Unit> function6;
        MutableInteractionSource mutableInteractionSource3;
        final boolean z10;
        MutableInteractionSource mutableInteractionSource4;
        final FiniteAnimationSpec finiteAnimationSpecValue;
        NavigationRailItemColors navigationRailItemColors4;
        Function2<? super Composer, ? super Integer, Unit> function7;
        ?? r7;
        ComposableLambda composableLambda;
        MutableInteractionSource mutableInteractionSource5;
        int currentCompositeKeyHash;
        Function0<ComposeUiNode> constructor;
        Composer composerM6062constructorimpl;
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash;
        float f;
        final State<Float> stateAnimateFloatAsState;
        float f2;
        final State<Float> stateAnimateFloatAsState2;
        final Density density;
        boolean zChanged;
        Object objRememberedValue;
        Function0 function1;
        boolean zChanged2;
        Object objRememberedValue2;
        final Shape value;
        boolean zChanged3;
        Object objRememberedValue3;
        boolean zChanged4;
        Object objRememberedValue4;
        Object objRememberedValue5;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1620317701);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(NavigationRailItem)N(selected,onClick,icon,modifier,enabled,label,alwaysShowLabel,colors,interactionSource)216@9866L14,218@9922L618,248@11186L3338:NavigationRail.kt#uh7d8r");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function0) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function2) ? 256 : 128;
        }
        int i13 = i2 & 8;
        if (i13 == 0) {
            if ((i & 3072) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 2048 : 1024;
            }
            i4 = i2 & 16;
            if (i4 != 0) {
                if ((i & 24576) == 0) {
                    z4 = z2;
                    if (composerStartRestartGroup.changed(z4)) {
                        i5 = 16384;
                    } else {
                        i5 = 8192;
                    }
                    i3 |= i5;
                }
                i6 = i2 & 32;
                if (i6 != 0) {
                    if ((196608 & i) == 0) {
                        function4 = function3;
                        if (composerStartRestartGroup.changedInstance(function4)) {
                            i7 = 131072;
                        } else {
                            i7 = 65536;
                        }
                        i3 |= i7;
                    }
                    i8 = i2 & 64;
                    if (i8 != 0) {
                        i3 |= 1572864;
                    } else if ((i & 1572864) == 0) {
                        if (composerStartRestartGroup.changed(z3)) {
                            i9 = 1048576;
                        } else {
                            i9 = 524288;
                        }
                        i3 |= i9;
                    }
                    if ((i & 12582912) != 0) {
                        i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(navigationRailItemColors)) ? 4194304 : 8388608;
                    }
                    i10 = i2 & 256;
                    if (i10 != 0) {
                        if ((i & 100663296) == 0) {
                            if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                                i11 = 67108864;
                            } else {
                                i11 = 33554432;
                            }
                            i3 |= i11;
                        }
                        if ((i3 & 38347923) != 38347922) {
                            z5 = true;
                        } else {
                            z5 = false;
                        }
                        if (composerStartRestartGroup.shouldExecute(z5, i3 & 1)) {
                            composerStartRestartGroup.startDefaults();
                            ComposerKt.sourceInformation(composerStartRestartGroup, "210@9536L8");
                            if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                if (i13 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                if (i4 != 0) {
                                    z4 = true;
                                }
                                if (i6 != 0) {
                                    function4 = null;
                                }
                                if (i8 != 0) {
                                    z8 = true;
                                } else {
                                    z8 = z3;
                                }
                                if ((i2 & 128) != 0) {
                                    navigationRailItemColorsColors = NavigationRailItemDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                                    i3 &= -29360129;
                                } else {
                                    navigationRailItemColorsColors = navigationRailItemColors;
                                }
                                i12 = i3;
                                navigationRailItemColors3 = navigationRailItemColorsColors;
                                modifier3 = modifier2;
                                z9 = z4;
                                function6 = function4;
                                if (i10 != 0) {
                                    mutableInteractionSource3 = null;
                                } else {
                                    mutableInteractionSource3 = mutableInteractionSource;
                                }
                                z10 = z8;
                            } else {
                                composerStartRestartGroup.skipToGroupEnd();
                                if ((i2 & 128) != 0) {
                                    i3 &= -29360129;
                                }
                                navigationRailItemColors3 = navigationRailItemColors;
                                i12 = i3;
                                modifier3 = modifier2;
                                z9 = z4;
                                function6 = function4;
                                z10 = z3;
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1620317701, i12, -1, "androidx.compose.material3.NavigationRailItem (NavigationRail.kt:212)");
                            }
                            if (mutableInteractionSource3 == null) {
                                composerStartRestartGroup.startReplaceGroup(253276704);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "214@9688L39");
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1947832866, "CC(remember):NavigationRail.kt#9igjgp");
                                objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue5 = InteractionSourceKt.MutableInteractionSource();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                composerStartRestartGroup.endReplaceGroup();
                                mutableInteractionSource4 = (MutableInteractionSource) objRememberedValue5;
                            } else {
                                composerStartRestartGroup.startReplaceGroup(1947832215);
                                composerStartRestartGroup.endReplaceGroup();
                                mutableInteractionSource4 = mutableInteractionSource3;
                            }
                            finiteAnimationSpecValue = MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultEffects, composerStartRestartGroup, 6);
                            boolean z11 = z10;
                            ComposableLambda composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(206057749, true, new Function2() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda7
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return NavigationRailKt.NavigationRailItem$lambda$1(navigationRailItemColors3, z, z9, finiteAnimationSpecValue, function6, z10, function2, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composerStartRestartGroup, 54);
                            if (function6 == null) {
                                composerStartRestartGroup.startReplaceGroup(254203944);
                                composerStartRestartGroup.endReplaceGroup();
                                navigationRailItemColors4 = navigationRailItemColors3;
                                function7 = function6;
                                r7 = 1;
                                composableLambda = null;
                            } else {
                                composerStartRestartGroup.startReplaceGroup(254203945);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "*233@10636L534");
                                final NavigationRailItemColors navigationRailItemColors5 = navigationRailItemColors3;
                                final boolean z12 = z9;
                                final Function2<? super Composer, ? super Integer, Unit> function8 = function6;
                                navigationRailItemColors4 = navigationRailItemColors5;
                                function7 = function8;
                                r7 = 1;
                                ComposableLambda composableLambdaRememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(-2056532825, true, new Function2() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda8
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return NavigationRailKt.NavigationRailItem$lambda$2$0(navigationRailItemColors5, z, z12, finiteAnimationSpecValue, function8, (Composer) obj, ((Integer) obj2).intValue());
                                    }
                                }, composerStartRestartGroup, 54);
                                composerStartRestartGroup.endReplaceGroup();
                                composableLambda = composableLambdaRememberComposableLambda2;
                            }
                            boolean z13 = z9;
                            Modifier modifier4 = modifier3;
                            mutableInteractionSource5 = mutableInteractionSource4;
                            Modifier modifierM1273widthInVpY3zN4$default = SizeKt.m1273widthInVpY3zN4$default(SizeKt.m1251defaultMinSizeVpY3zN4$default(SelectableKt.m1533selectableO2vRcR0(modifier4, z, mutableInteractionSource5, null, z13, Role.m8825boximpl(Role.INSTANCE.m8839getTabo7Vup1c()), function0), 0.0f, NavigationRailItemHeight, r7, null), NavigationRailItemWidth, 0.0f, 2, null);
                            Alignment center = Alignment.INSTANCE.getCenter();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, r7);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1273widthInVpY3zN4$default);
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
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1826936439, "C267@11982L7,264@11752L252,273@12294L7,270@12067L249,279@12577L7,280@12620L315,289@12986L146,303@13569L237,311@13855L285,325@14406L32,326@14476L31,319@14150L368:NavigationRail.kt#uh7d8r");
                            if (z) {
                                f = 1.0f;
                            } else {
                                f = 0.0f;
                            }
                            final NavigationRailItemColors navigationRailItemColors6 = navigationRailItemColors4;
                            stateAnimateFloatAsState = AnimateAsStateKt.animateFloatAsState(f, MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultEffects, composerStartRestartGroup, 6), 0.0f, null, null, composerStartRestartGroup, 0, 28);
                            if (z) {
                                f2 = 1.0f;
                            } else {
                                f2 = 0.0f;
                            }
                            stateAnimateFloatAsState2 = AnimateAsStateKt.animateFloatAsState(f2, MotionSchemeKt.value(MotionSchemeKeyTokens.FastSpatial, composerStartRestartGroup, 6), 0.0f, null, null, composerStartRestartGroup, 0, 28);
                            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                            Object objConsume = composerStartRestartGroup.consume(localDensity);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            density = (Density) objConsume;
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -474548400, "CC(remember):NavigationRail.kt#9igjgp");
                            zChanged = composerStartRestartGroup.changed(density);
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (!zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = new Function0() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda9
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return NavigationRailKt.NavigationRailItem$lambda$3$0$0(density);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            function1 = (Function0) objRememberedValue;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -474536857, "CC(remember):NavigationRail.kt#9igjgp");
                            zChanged2 = composerStartRestartGroup.changed(mutableInteractionSource5) | composerStartRestartGroup.changed(function1);
                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (!zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue2 = new MappedInteractionSource(mutableInteractionSource5, function1);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            }
                            final MappedInteractionSource mappedInteractionSource = (MappedInteractionSource) objRememberedValue2;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            if (function7 != null) {
                                composerStartRestartGroup.startReplaceGroup(-1825536046);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "295@13266L5");
                                value = ShapesKt.getValue(NavigationRailBaselineItemTokens.INSTANCE.getActiveIndicatorShape(), composerStartRestartGroup, 6);
                                composerStartRestartGroup.endReplaceGroup();
                            } else {
                                composerStartRestartGroup.startReplaceGroup(-1825440690);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "297@13335L5");
                                value = ShapesKt.getValue(ShapeKeyTokens.CornerFull, composerStartRestartGroup, 6);
                                composerStartRestartGroup.endReplaceGroup();
                            }
                            ComposableLambda composableLambdaRememberComposableLambda3 = ComposableLambdaKt.rememberComposableLambda(455696046, true, new Function2() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda10
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return NavigationRailKt.NavigationRailItem$lambda$3$2(value, mappedInteractionSource, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composerStartRestartGroup, 54);
                            ComposableLambda composableLambdaRememberComposableLambda4 = ComposableLambdaKt.rememberComposableLambda(2137606782, true, new Function2() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda11
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return NavigationRailKt.NavigationRailItem$lambda$3$3(stateAnimateFloatAsState, navigationRailItemColors6, value, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composerStartRestartGroup, 54);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -474491531, "CC(remember):NavigationRail.kt#9igjgp");
                            zChanged3 = composerStartRestartGroup.changed(stateAnimateFloatAsState);
                            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                            if (!zChanged3 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda12
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return Float.valueOf(NavigationRailKt.NavigationRailItem$lambda$3$4$0(stateAnimateFloatAsState));
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            }
                            Function0 function9 = (Function0) objRememberedValue3;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -474489292, "CC(remember):NavigationRail.kt#9igjgp");
                            zChanged4 = composerStartRestartGroup.changed(stateAnimateFloatAsState2);
                            objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                            if (!zChanged4 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue4 = new Function0() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda13
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return Float.valueOf(NavigationRailKt.NavigationRailItem$lambda$3$5$0(stateAnimateFloatAsState2));
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            NavigationRailItemLayout(composableLambdaRememberComposableLambda3, composableLambdaRememberComposableLambda4, composableLambdaRememberComposableLambda, composableLambda, z11, function9, (Function0) objRememberedValue4, composerStartRestartGroup, (57344 & (i12 >> 6)) | 438);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            composerStartRestartGroup.endNode();
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            navigationRailItemColors2 = navigationRailItemColors6;
                            composer2 = composerStartRestartGroup;
                            z6 = z11;
                            z7 = z13;
                            mutableInteractionSource2 = mutableInteractionSource3;
                            modifier2 = modifier4;
                            function5 = function7;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            z6 = z3;
                            mutableInteractionSource2 = mutableInteractionSource;
                            z7 = z4;
                            composer2 = composerStartRestartGroup;
                            function5 = function4;
                            navigationRailItemColors2 = navigationRailItemColors;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda14
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return NavigationRailKt.NavigationRailItem$lambda$4(z, function0, function2, modifier2, z7, function5, z6, navigationRailItemColors2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                        }
                    }
                    i3 |= 100663296;
                    if ((i3 & 38347923) != 38347922) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z5, i3 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "210@9536L8");
                        if ((i & 1) != 0) {
                            if (i13 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                z4 = true;
                            }
                            if (i6 != 0) {
                                function4 = null;
                            }
                            if (i8 != 0) {
                                z8 = true;
                            } else {
                                z8 = z3;
                            }
                            if ((i2 & 128) != 0) {
                                navigationRailItemColorsColors = NavigationRailItemDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                                i3 &= -29360129;
                            } else {
                                navigationRailItemColorsColors = navigationRailItemColors;
                            }
                            i12 = i3;
                            navigationRailItemColors3 = navigationRailItemColorsColors;
                            modifier3 = modifier2;
                            z9 = z4;
                            function6 = function4;
                            if (i10 != 0) {
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            z10 = z8;
                        } else {
                            if (i13 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                z4 = true;
                            }
                            if (i6 != 0) {
                                function4 = null;
                            }
                            if (i8 != 0) {
                                z8 = true;
                            } else {
                                z8 = z3;
                            }
                            if ((i2 & 128) != 0) {
                                navigationRailItemColorsColors = NavigationRailItemDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                                i3 &= -29360129;
                            } else {
                                navigationRailItemColorsColors = navigationRailItemColors;
                            }
                            i12 = i3;
                            navigationRailItemColors3 = navigationRailItemColorsColors;
                            modifier3 = modifier2;
                            z9 = z4;
                            function6 = function4;
                            if (i10 != 0) {
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            z10 = z8;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1620317701, i12, -1, "androidx.compose.material3.NavigationRailItem (NavigationRail.kt:212)");
                        }
                        if (mutableInteractionSource3 == null) {
                            composerStartRestartGroup.startReplaceGroup(253276704);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "214@9688L39");
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1947832866, "CC(remember):NavigationRail.kt#9igjgp");
                            objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue5 = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            composerStartRestartGroup.endReplaceGroup();
                            mutableInteractionSource4 = (MutableInteractionSource) objRememberedValue5;
                        } else {
                            composerStartRestartGroup.startReplaceGroup(1947832215);
                            composerStartRestartGroup.endReplaceGroup();
                            mutableInteractionSource4 = mutableInteractionSource3;
                        }
                        finiteAnimationSpecValue = MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultEffects, composerStartRestartGroup, 6);
                        boolean z14 = z10;
                        ComposableLambda composableLambdaRememberComposableLambda5 = ComposableLambdaKt.rememberComposableLambda(206057749, true, new Function2() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda7
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return NavigationRailKt.NavigationRailItem$lambda$1(navigationRailItemColors3, z, z9, finiteAnimationSpecValue, function6, z10, function2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                        if (function6 == null) {
                            composerStartRestartGroup.startReplaceGroup(254203944);
                            composerStartRestartGroup.endReplaceGroup();
                            navigationRailItemColors4 = navigationRailItemColors3;
                            function7 = function6;
                            r7 = 1;
                            composableLambda = null;
                        } else {
                            composerStartRestartGroup.startReplaceGroup(254203945);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "*233@10636L534");
                            final NavigationRailItemColors navigationRailItemColors7 = navigationRailItemColors3;
                            final boolean z15 = z9;
                            final Function2 function10 = function6;
                            navigationRailItemColors4 = navigationRailItemColors7;
                            function7 = function10;
                            r7 = 1;
                            ComposableLambda composableLambdaRememberComposableLambda6 = ComposableLambdaKt.rememberComposableLambda(-2056532825, true, new Function2() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda8
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return NavigationRailKt.NavigationRailItem$lambda$2$0(navigationRailItemColors7, z, z15, finiteAnimationSpecValue, function10, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composerStartRestartGroup, 54);
                            composerStartRestartGroup.endReplaceGroup();
                            composableLambda = composableLambdaRememberComposableLambda6;
                        }
                        boolean z16 = z9;
                        Modifier modifier5 = modifier3;
                        mutableInteractionSource5 = mutableInteractionSource4;
                        Modifier modifierM1273widthInVpY3zN4$default2 = SizeKt.m1273widthInVpY3zN4$default(SizeKt.m1251defaultMinSizeVpY3zN4$default(SelectableKt.m1533selectableO2vRcR0(modifier5, z, mutableInteractionSource5, null, z16, Role.m8825boximpl(Role.INSTANCE.m8839getTabo7Vup1c()), function0), 0.0f, NavigationRailItemHeight, r7, null), NavigationRailItemWidth, 0.0f, 2, null);
                        Alignment center2 = Alignment.INSTANCE.getCenter();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(center2, r7);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                        CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1273widthInVpY3zN4$default2);
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
                        Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (!composerM6062constructorimpl.getInserting()) {
                            composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        } else {
                            composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        }
                        Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1826936439, "C267@11982L7,264@11752L252,273@12294L7,270@12067L249,279@12577L7,280@12620L315,289@12986L146,303@13569L237,311@13855L285,325@14406L32,326@14476L31,319@14150L368:NavigationRail.kt#uh7d8r");
                        if (z) {
                            f = 1.0f;
                        } else {
                            f = 0.0f;
                        }
                        final NavigationRailItemColors navigationRailItemColors8 = navigationRailItemColors4;
                        stateAnimateFloatAsState = AnimateAsStateKt.animateFloatAsState(f, MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultEffects, composerStartRestartGroup, 6), 0.0f, null, null, composerStartRestartGroup, 0, 28);
                        if (z) {
                            f2 = 1.0f;
                        } else {
                            f2 = 0.0f;
                        }
                        stateAnimateFloatAsState2 = AnimateAsStateKt.animateFloatAsState(f2, MotionSchemeKt.value(MotionSchemeKeyTokens.FastSpatial, composerStartRestartGroup, 6), 0.0f, null, null, composerStartRestartGroup, 0, 28);
                        ProvidableCompositionLocal<Density> localDensity2 = CompositionLocalsKt.getLocalDensity();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object objConsume2 = composerStartRestartGroup.consume(localDensity2);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        density = (Density) objConsume2;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -474548400, "CC(remember):NavigationRail.kt#9igjgp");
                        zChanged = composerStartRestartGroup.changed(density);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!zChanged) {
                            objRememberedValue = new Function0() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda9
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return NavigationRailKt.NavigationRailItem$lambda$3$0$0(density);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = new Function0() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda9
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return NavigationRailKt.NavigationRailItem$lambda$3$0$0(density);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        function1 = (Function0) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -474536857, "CC(remember):NavigationRail.kt#9igjgp");
                        zChanged2 = composerStartRestartGroup.changed(mutableInteractionSource5) | composerStartRestartGroup.changed(function1);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged2) {
                            objRememberedValue2 = new MappedInteractionSource(mutableInteractionSource5, function1);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        } else {
                            objRememberedValue2 = new MappedInteractionSource(mutableInteractionSource5, function1);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        final MappedInteractionSource mappedInteractionSource2 = (MappedInteractionSource) objRememberedValue2;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if (function7 != null) {
                            composerStartRestartGroup.startReplaceGroup(-1825536046);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "295@13266L5");
                            value = ShapesKt.getValue(NavigationRailBaselineItemTokens.INSTANCE.getActiveIndicatorShape(), composerStartRestartGroup, 6);
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            composerStartRestartGroup.startReplaceGroup(-1825440690);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "297@13335L5");
                            value = ShapesKt.getValue(ShapeKeyTokens.CornerFull, composerStartRestartGroup, 6);
                            composerStartRestartGroup.endReplaceGroup();
                        }
                        ComposableLambda composableLambdaRememberComposableLambda7 = ComposableLambdaKt.rememberComposableLambda(455696046, true, new Function2() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda10
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return NavigationRailKt.NavigationRailItem$lambda$3$2(value, mappedInteractionSource2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                        ComposableLambda composableLambdaRememberComposableLambda8 = ComposableLambdaKt.rememberComposableLambda(2137606782, true, new Function2() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda11
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return NavigationRailKt.NavigationRailItem$lambda$3$3(stateAnimateFloatAsState, navigationRailItemColors8, value, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -474491531, "CC(remember):NavigationRail.kt#9igjgp");
                        zChanged3 = composerStartRestartGroup.changed(stateAnimateFloatAsState);
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged3) {
                            objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda12
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return Float.valueOf(NavigationRailKt.NavigationRailItem$lambda$3$4$0(stateAnimateFloatAsState));
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        } else {
                            objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda12
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return Float.valueOf(NavigationRailKt.NavigationRailItem$lambda$3$4$0(stateAnimateFloatAsState));
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        Function0 function11 = (Function0) objRememberedValue3;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -474489292, "CC(remember):NavigationRail.kt#9igjgp");
                        zChanged4 = composerStartRestartGroup.changed(stateAnimateFloatAsState2);
                        objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged4) {
                            objRememberedValue4 = new Function0() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda13
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return Float.valueOf(NavigationRailKt.NavigationRailItem$lambda$3$5$0(stateAnimateFloatAsState2));
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        } else {
                            objRememberedValue4 = new Function0() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda13
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return Float.valueOf(NavigationRailKt.NavigationRailItem$lambda$3$5$0(stateAnimateFloatAsState2));
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        NavigationRailItemLayout(composableLambdaRememberComposableLambda7, composableLambdaRememberComposableLambda8, composableLambdaRememberComposableLambda5, composableLambda, z14, function11, (Function0) objRememberedValue4, composerStartRestartGroup, (57344 & (i12 >> 6)) | 438);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        navigationRailItemColors2 = navigationRailItemColors8;
                        composer2 = composerStartRestartGroup;
                        z6 = z14;
                        z7 = z16;
                        mutableInteractionSource2 = mutableInteractionSource3;
                        modifier2 = modifier5;
                        function5 = function7;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        z6 = z3;
                        mutableInteractionSource2 = mutableInteractionSource;
                        z7 = z4;
                        composer2 = composerStartRestartGroup;
                        function5 = function4;
                        navigationRailItemColors2 = navigationRailItemColors;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda14
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return NavigationRailKt.NavigationRailItem$lambda$4(z, function0, function2, modifier2, z7, function5, z6, navigationRailItemColors2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                function4 = function3;
                i8 = i2 & 64;
                if (i8 != 0) {
                    i3 |= 1572864;
                } else if ((i & 1572864) == 0) {
                    if (composerStartRestartGroup.changed(z3)) {
                        i9 = 1048576;
                    } else {
                        i9 = 524288;
                    }
                    i3 |= i9;
                }
                if ((i & 12582912) != 0) {
                    i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(navigationRailItemColors)) ? 4194304 : 8388608;
                }
                i10 = i2 & 256;
                if (i10 != 0) {
                    if ((i & 100663296) == 0) {
                        if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                            i11 = 67108864;
                        } else {
                            i11 = 33554432;
                        }
                        i3 |= i11;
                    }
                    if ((i3 & 38347923) != 38347922) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z5, i3 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "210@9536L8");
                        if ((i & 1) != 0) {
                            if (i13 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                z4 = true;
                            }
                            if (i6 != 0) {
                                function4 = null;
                            }
                            if (i8 != 0) {
                                z8 = true;
                            } else {
                                z8 = z3;
                            }
                            if ((i2 & 128) != 0) {
                                navigationRailItemColorsColors = NavigationRailItemDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                                i3 &= -29360129;
                            } else {
                                navigationRailItemColorsColors = navigationRailItemColors;
                            }
                            i12 = i3;
                            navigationRailItemColors3 = navigationRailItemColorsColors;
                            modifier3 = modifier2;
                            z9 = z4;
                            function6 = function4;
                            if (i10 != 0) {
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            z10 = z8;
                        } else {
                            if (i13 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                z4 = true;
                            }
                            if (i6 != 0) {
                                function4 = null;
                            }
                            if (i8 != 0) {
                                z8 = true;
                            } else {
                                z8 = z3;
                            }
                            if ((i2 & 128) != 0) {
                                navigationRailItemColorsColors = NavigationRailItemDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                                i3 &= -29360129;
                            } else {
                                navigationRailItemColorsColors = navigationRailItemColors;
                            }
                            i12 = i3;
                            navigationRailItemColors3 = navigationRailItemColorsColors;
                            modifier3 = modifier2;
                            z9 = z4;
                            function6 = function4;
                            if (i10 != 0) {
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            z10 = z8;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1620317701, i12, -1, "androidx.compose.material3.NavigationRailItem (NavigationRail.kt:212)");
                        }
                        if (mutableInteractionSource3 == null) {
                            composerStartRestartGroup.startReplaceGroup(253276704);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "214@9688L39");
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1947832866, "CC(remember):NavigationRail.kt#9igjgp");
                            objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue5 = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            composerStartRestartGroup.endReplaceGroup();
                            mutableInteractionSource4 = (MutableInteractionSource) objRememberedValue5;
                        } else {
                            composerStartRestartGroup.startReplaceGroup(1947832215);
                            composerStartRestartGroup.endReplaceGroup();
                            mutableInteractionSource4 = mutableInteractionSource3;
                        }
                        finiteAnimationSpecValue = MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultEffects, composerStartRestartGroup, 6);
                        boolean z17 = z10;
                        ComposableLambda composableLambdaRememberComposableLambda9 = ComposableLambdaKt.rememberComposableLambda(206057749, true, new Function2() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda7
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return NavigationRailKt.NavigationRailItem$lambda$1(navigationRailItemColors3, z, z9, finiteAnimationSpecValue, function6, z10, function2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                        if (function6 == null) {
                            composerStartRestartGroup.startReplaceGroup(254203944);
                            composerStartRestartGroup.endReplaceGroup();
                            navigationRailItemColors4 = navigationRailItemColors3;
                            function7 = function6;
                            r7 = 1;
                            composableLambda = null;
                        } else {
                            composerStartRestartGroup.startReplaceGroup(254203945);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "*233@10636L534");
                            final NavigationRailItemColors navigationRailItemColors9 = navigationRailItemColors3;
                            final boolean z18 = z9;
                            final Function2 function12 = function6;
                            navigationRailItemColors4 = navigationRailItemColors9;
                            function7 = function12;
                            r7 = 1;
                            ComposableLambda composableLambdaRememberComposableLambda10 = ComposableLambdaKt.rememberComposableLambda(-2056532825, true, new Function2() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda8
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return NavigationRailKt.NavigationRailItem$lambda$2$0(navigationRailItemColors9, z, z18, finiteAnimationSpecValue, function12, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composerStartRestartGroup, 54);
                            composerStartRestartGroup.endReplaceGroup();
                            composableLambda = composableLambdaRememberComposableLambda10;
                        }
                        boolean z19 = z9;
                        Modifier modifier6 = modifier3;
                        mutableInteractionSource5 = mutableInteractionSource4;
                        Modifier modifierM1273widthInVpY3zN4$default3 = SizeKt.m1273widthInVpY3zN4$default(SizeKt.m1251defaultMinSizeVpY3zN4$default(SelectableKt.m1533selectableO2vRcR0(modifier6, z, mutableInteractionSource5, null, z19, Role.m8825boximpl(Role.INSTANCE.m8839getTabo7Vup1c()), function0), 0.0f, NavigationRailItemHeight, r7, null), NavigationRailItemWidth, 0.0f, 2, null);
                        Alignment center3 = Alignment.INSTANCE.getCenter();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(center3, r7);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                        CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1273widthInVpY3zN4$default3);
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
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1826936439, "C267@11982L7,264@11752L252,273@12294L7,270@12067L249,279@12577L7,280@12620L315,289@12986L146,303@13569L237,311@13855L285,325@14406L32,326@14476L31,319@14150L368:NavigationRail.kt#uh7d8r");
                        if (z) {
                            f = 1.0f;
                        } else {
                            f = 0.0f;
                        }
                        final NavigationRailItemColors navigationRailItemColors10 = navigationRailItemColors4;
                        stateAnimateFloatAsState = AnimateAsStateKt.animateFloatAsState(f, MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultEffects, composerStartRestartGroup, 6), 0.0f, null, null, composerStartRestartGroup, 0, 28);
                        if (z) {
                            f2 = 1.0f;
                        } else {
                            f2 = 0.0f;
                        }
                        stateAnimateFloatAsState2 = AnimateAsStateKt.animateFloatAsState(f2, MotionSchemeKt.value(MotionSchemeKeyTokens.FastSpatial, composerStartRestartGroup, 6), 0.0f, null, null, composerStartRestartGroup, 0, 28);
                        ProvidableCompositionLocal<Density> localDensity3 = CompositionLocalsKt.getLocalDensity();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object objConsume3 = composerStartRestartGroup.consume(localDensity3);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        density = (Density) objConsume3;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -474548400, "CC(remember):NavigationRail.kt#9igjgp");
                        zChanged = composerStartRestartGroup.changed(density);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!zChanged) {
                            objRememberedValue = new Function0() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda9
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return NavigationRailKt.NavigationRailItem$lambda$3$0$0(density);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = new Function0() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda9
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return NavigationRailKt.NavigationRailItem$lambda$3$0$0(density);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        function1 = (Function0) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -474536857, "CC(remember):NavigationRail.kt#9igjgp");
                        zChanged2 = composerStartRestartGroup.changed(mutableInteractionSource5) | composerStartRestartGroup.changed(function1);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged2) {
                            objRememberedValue2 = new MappedInteractionSource(mutableInteractionSource5, function1);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        } else {
                            objRememberedValue2 = new MappedInteractionSource(mutableInteractionSource5, function1);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        final MappedInteractionSource mappedInteractionSource3 = (MappedInteractionSource) objRememberedValue2;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if (function7 != null) {
                            composerStartRestartGroup.startReplaceGroup(-1825536046);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "295@13266L5");
                            value = ShapesKt.getValue(NavigationRailBaselineItemTokens.INSTANCE.getActiveIndicatorShape(), composerStartRestartGroup, 6);
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            composerStartRestartGroup.startReplaceGroup(-1825440690);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "297@13335L5");
                            value = ShapesKt.getValue(ShapeKeyTokens.CornerFull, composerStartRestartGroup, 6);
                            composerStartRestartGroup.endReplaceGroup();
                        }
                        ComposableLambda composableLambdaRememberComposableLambda11 = ComposableLambdaKt.rememberComposableLambda(455696046, true, new Function2() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda10
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return NavigationRailKt.NavigationRailItem$lambda$3$2(value, mappedInteractionSource3, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                        ComposableLambda composableLambdaRememberComposableLambda12 = ComposableLambdaKt.rememberComposableLambda(2137606782, true, new Function2() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda11
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return NavigationRailKt.NavigationRailItem$lambda$3$3(stateAnimateFloatAsState, navigationRailItemColors10, value, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -474491531, "CC(remember):NavigationRail.kt#9igjgp");
                        zChanged3 = composerStartRestartGroup.changed(stateAnimateFloatAsState);
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged3) {
                            objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda12
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return Float.valueOf(NavigationRailKt.NavigationRailItem$lambda$3$4$0(stateAnimateFloatAsState));
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        } else {
                            objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda12
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return Float.valueOf(NavigationRailKt.NavigationRailItem$lambda$3$4$0(stateAnimateFloatAsState));
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        Function0 function13 = (Function0) objRememberedValue3;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -474489292, "CC(remember):NavigationRail.kt#9igjgp");
                        zChanged4 = composerStartRestartGroup.changed(stateAnimateFloatAsState2);
                        objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged4) {
                            objRememberedValue4 = new Function0() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda13
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return Float.valueOf(NavigationRailKt.NavigationRailItem$lambda$3$5$0(stateAnimateFloatAsState2));
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        } else {
                            objRememberedValue4 = new Function0() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda13
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return Float.valueOf(NavigationRailKt.NavigationRailItem$lambda$3$5$0(stateAnimateFloatAsState2));
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        NavigationRailItemLayout(composableLambdaRememberComposableLambda11, composableLambdaRememberComposableLambda12, composableLambdaRememberComposableLambda9, composableLambda, z17, function13, (Function0) objRememberedValue4, composerStartRestartGroup, (57344 & (i12 >> 6)) | 438);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        navigationRailItemColors2 = navigationRailItemColors10;
                        composer2 = composerStartRestartGroup;
                        z6 = z17;
                        z7 = z19;
                        mutableInteractionSource2 = mutableInteractionSource3;
                        modifier2 = modifier6;
                        function5 = function7;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        z6 = z3;
                        mutableInteractionSource2 = mutableInteractionSource;
                        z7 = z4;
                        composer2 = composerStartRestartGroup;
                        function5 = function4;
                        navigationRailItemColors2 = navigationRailItemColors;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda14
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return NavigationRailKt.NavigationRailItem$lambda$4(z, function0, function2, modifier2, z7, function5, z6, navigationRailItemColors2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= 100663296;
                if ((i3 & 38347923) != 38347922) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z5, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "210@9536L8");
                    if ((i & 1) != 0) {
                        if (i13 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            z4 = true;
                        }
                        if (i6 != 0) {
                            function4 = null;
                        }
                        if (i8 != 0) {
                            z8 = true;
                        } else {
                            z8 = z3;
                        }
                        if ((i2 & 128) != 0) {
                            navigationRailItemColorsColors = NavigationRailItemDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            navigationRailItemColorsColors = navigationRailItemColors;
                        }
                        i12 = i3;
                        navigationRailItemColors3 = navigationRailItemColorsColors;
                        modifier3 = modifier2;
                        z9 = z4;
                        function6 = function4;
                        if (i10 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        z10 = z8;
                    } else {
                        if (i13 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            z4 = true;
                        }
                        if (i6 != 0) {
                            function4 = null;
                        }
                        if (i8 != 0) {
                            z8 = true;
                        } else {
                            z8 = z3;
                        }
                        if ((i2 & 128) != 0) {
                            navigationRailItemColorsColors = NavigationRailItemDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            navigationRailItemColorsColors = navigationRailItemColors;
                        }
                        i12 = i3;
                        navigationRailItemColors3 = navigationRailItemColorsColors;
                        modifier3 = modifier2;
                        z9 = z4;
                        function6 = function4;
                        if (i10 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        z10 = z8;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1620317701, i12, -1, "androidx.compose.material3.NavigationRailItem (NavigationRail.kt:212)");
                    }
                    if (mutableInteractionSource3 == null) {
                        composerStartRestartGroup.startReplaceGroup(253276704);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "214@9688L39");
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1947832866, "CC(remember):NavigationRail.kt#9igjgp");
                        objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue5 = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.endReplaceGroup();
                        mutableInteractionSource4 = (MutableInteractionSource) objRememberedValue5;
                    } else {
                        composerStartRestartGroup.startReplaceGroup(1947832215);
                        composerStartRestartGroup.endReplaceGroup();
                        mutableInteractionSource4 = mutableInteractionSource3;
                    }
                    finiteAnimationSpecValue = MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultEffects, composerStartRestartGroup, 6);
                    boolean z110 = z10;
                    ComposableLambda composableLambdaRememberComposableLambda13 = ComposableLambdaKt.rememberComposableLambda(206057749, true, new Function2() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return NavigationRailKt.NavigationRailItem$lambda$1(navigationRailItemColors3, z, z9, finiteAnimationSpecValue, function6, z10, function2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54);
                    if (function6 == null) {
                        composerStartRestartGroup.startReplaceGroup(254203944);
                        composerStartRestartGroup.endReplaceGroup();
                        navigationRailItemColors4 = navigationRailItemColors3;
                        function7 = function6;
                        r7 = 1;
                        composableLambda = null;
                    } else {
                        composerStartRestartGroup.startReplaceGroup(254203945);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "*233@10636L534");
                        final NavigationRailItemColors navigationRailItemColors11 = navigationRailItemColors3;
                        final boolean z111 = z9;
                        final Function2 function14 = function6;
                        navigationRailItemColors4 = navigationRailItemColors11;
                        function7 = function14;
                        r7 = 1;
                        ComposableLambda composableLambdaRememberComposableLambda14 = ComposableLambdaKt.rememberComposableLambda(-2056532825, true, new Function2() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda8
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return NavigationRailKt.NavigationRailItem$lambda$2$0(navigationRailItemColors11, z, z111, finiteAnimationSpecValue, function14, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                        composerStartRestartGroup.endReplaceGroup();
                        composableLambda = composableLambdaRememberComposableLambda14;
                    }
                    boolean z112 = z9;
                    Modifier modifier7 = modifier3;
                    mutableInteractionSource5 = mutableInteractionSource4;
                    Modifier modifierM1273widthInVpY3zN4$default4 = SizeKt.m1273widthInVpY3zN4$default(SizeKt.m1251defaultMinSizeVpY3zN4$default(SelectableKt.m1533selectableO2vRcR0(modifier7, z, mutableInteractionSource5, null, z112, Role.m8825boximpl(Role.INSTANCE.m8839getTabo7Vup1c()), function0), 0.0f, NavigationRailItemHeight, r7, null), NavigationRailItemWidth, 0.0f, 2, null);
                    Alignment center4 = Alignment.INSTANCE.getCenter();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy4 = BoxKt.maybeCachedBoxMeasurePolicy(center4, r7);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap4 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1273widthInVpY3zN4$default4);
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
                    BoxScopeInstance boxScopeInstance4 = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1826936439, "C267@11982L7,264@11752L252,273@12294L7,270@12067L249,279@12577L7,280@12620L315,289@12986L146,303@13569L237,311@13855L285,325@14406L32,326@14476L31,319@14150L368:NavigationRail.kt#uh7d8r");
                    if (z) {
                        f = 1.0f;
                    } else {
                        f = 0.0f;
                    }
                    final NavigationRailItemColors navigationRailItemColors12 = navigationRailItemColors4;
                    stateAnimateFloatAsState = AnimateAsStateKt.animateFloatAsState(f, MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultEffects, composerStartRestartGroup, 6), 0.0f, null, null, composerStartRestartGroup, 0, 28);
                    if (z) {
                        f2 = 1.0f;
                    } else {
                        f2 = 0.0f;
                    }
                    stateAnimateFloatAsState2 = AnimateAsStateKt.animateFloatAsState(f2, MotionSchemeKt.value(MotionSchemeKeyTokens.FastSpatial, composerStartRestartGroup, 6), 0.0f, null, null, composerStartRestartGroup, 0, 28);
                    ProvidableCompositionLocal<Density> localDensity4 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume4 = composerStartRestartGroup.consume(localDensity4);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    density = (Density) objConsume4;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -474548400, "CC(remember):NavigationRail.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(density);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue = new Function0() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda9
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return NavigationRailKt.NavigationRailItem$lambda$3$0$0(density);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new Function0() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda9
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return NavigationRailKt.NavigationRailItem$lambda$3$0$0(density);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    function1 = (Function0) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -474536857, "CC(remember):NavigationRail.kt#9igjgp");
                    zChanged2 = composerStartRestartGroup.changed(mutableInteractionSource5) | composerStartRestartGroup.changed(function1);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged2) {
                        objRememberedValue2 = new MappedInteractionSource(mutableInteractionSource5, function1);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new MappedInteractionSource(mutableInteractionSource5, function1);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    final MappedInteractionSource mappedInteractionSource4 = (MappedInteractionSource) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (function7 != null) {
                        composerStartRestartGroup.startReplaceGroup(-1825536046);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "295@13266L5");
                        value = ShapesKt.getValue(NavigationRailBaselineItemTokens.INSTANCE.getActiveIndicatorShape(), composerStartRestartGroup, 6);
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-1825440690);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "297@13335L5");
                        value = ShapesKt.getValue(ShapeKeyTokens.CornerFull, composerStartRestartGroup, 6);
                        composerStartRestartGroup.endReplaceGroup();
                    }
                    ComposableLambda composableLambdaRememberComposableLambda15 = ComposableLambdaKt.rememberComposableLambda(455696046, true, new Function2() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda10
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return NavigationRailKt.NavigationRailItem$lambda$3$2(value, mappedInteractionSource4, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54);
                    ComposableLambda composableLambdaRememberComposableLambda16 = ComposableLambdaKt.rememberComposableLambda(2137606782, true, new Function2() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda11
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return NavigationRailKt.NavigationRailItem$lambda$3$3(stateAnimateFloatAsState, navigationRailItemColors12, value, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -474491531, "CC(remember):NavigationRail.kt#9igjgp");
                    zChanged3 = composerStartRestartGroup.changed(stateAnimateFloatAsState);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged3) {
                        objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda12
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Float.valueOf(NavigationRailKt.NavigationRailItem$lambda$3$4$0(stateAnimateFloatAsState));
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda12
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Float.valueOf(NavigationRailKt.NavigationRailItem$lambda$3$4$0(stateAnimateFloatAsState));
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    Function0 function15 = (Function0) objRememberedValue3;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -474489292, "CC(remember):NavigationRail.kt#9igjgp");
                    zChanged4 = composerStartRestartGroup.changed(stateAnimateFloatAsState2);
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged4) {
                        objRememberedValue4 = new Function0() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda13
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Float.valueOf(NavigationRailKt.NavigationRailItem$lambda$3$5$0(stateAnimateFloatAsState2));
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    } else {
                        objRememberedValue4 = new Function0() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda13
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Float.valueOf(NavigationRailKt.NavigationRailItem$lambda$3$5$0(stateAnimateFloatAsState2));
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    NavigationRailItemLayout(composableLambdaRememberComposableLambda15, composableLambdaRememberComposableLambda16, composableLambdaRememberComposableLambda13, composableLambda, z110, function15, (Function0) objRememberedValue4, composerStartRestartGroup, (57344 & (i12 >> 6)) | 438);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    navigationRailItemColors2 = navigationRailItemColors12;
                    composer2 = composerStartRestartGroup;
                    z6 = z110;
                    z7 = z112;
                    mutableInteractionSource2 = mutableInteractionSource3;
                    modifier2 = modifier7;
                    function5 = function7;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    z6 = z3;
                    mutableInteractionSource2 = mutableInteractionSource;
                    z7 = z4;
                    composer2 = composerStartRestartGroup;
                    function5 = function4;
                    navigationRailItemColors2 = navigationRailItemColors;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda14
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return NavigationRailKt.NavigationRailItem$lambda$4(z, function0, function2, modifier2, z7, function5, z6, navigationRailItemColors2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 24576;
            z4 = z2;
            i6 = i2 & 32;
            if (i6 != 0) {
                if ((196608 & i) == 0) {
                    function4 = function3;
                    if (composerStartRestartGroup.changedInstance(function4)) {
                        i7 = 131072;
                    } else {
                        i7 = 65536;
                    }
                    i3 |= i7;
                }
                i8 = i2 & 64;
                if (i8 != 0) {
                    i3 |= 1572864;
                } else if ((i & 1572864) == 0) {
                    if (composerStartRestartGroup.changed(z3)) {
                        i9 = 1048576;
                    } else {
                        i9 = 524288;
                    }
                    i3 |= i9;
                }
                if ((i & 12582912) != 0) {
                    i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(navigationRailItemColors)) ? 4194304 : 8388608;
                }
                i10 = i2 & 256;
                if (i10 != 0) {
                    if ((i & 100663296) == 0) {
                        if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                            i11 = 67108864;
                        } else {
                            i11 = 33554432;
                        }
                        i3 |= i11;
                    }
                    if ((i3 & 38347923) != 38347922) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z5, i3 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "210@9536L8");
                        if ((i & 1) != 0) {
                            if (i13 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                z4 = true;
                            }
                            if (i6 != 0) {
                                function4 = null;
                            }
                            if (i8 != 0) {
                                z8 = true;
                            } else {
                                z8 = z3;
                            }
                            if ((i2 & 128) != 0) {
                                navigationRailItemColorsColors = NavigationRailItemDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                                i3 &= -29360129;
                            } else {
                                navigationRailItemColorsColors = navigationRailItemColors;
                            }
                            i12 = i3;
                            navigationRailItemColors3 = navigationRailItemColorsColors;
                            modifier3 = modifier2;
                            z9 = z4;
                            function6 = function4;
                            if (i10 != 0) {
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            z10 = z8;
                        } else {
                            if (i13 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                z4 = true;
                            }
                            if (i6 != 0) {
                                function4 = null;
                            }
                            if (i8 != 0) {
                                z8 = true;
                            } else {
                                z8 = z3;
                            }
                            if ((i2 & 128) != 0) {
                                navigationRailItemColorsColors = NavigationRailItemDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                                i3 &= -29360129;
                            } else {
                                navigationRailItemColorsColors = navigationRailItemColors;
                            }
                            i12 = i3;
                            navigationRailItemColors3 = navigationRailItemColorsColors;
                            modifier3 = modifier2;
                            z9 = z4;
                            function6 = function4;
                            if (i10 != 0) {
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            z10 = z8;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1620317701, i12, -1, "androidx.compose.material3.NavigationRailItem (NavigationRail.kt:212)");
                        }
                        if (mutableInteractionSource3 == null) {
                            composerStartRestartGroup.startReplaceGroup(253276704);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "214@9688L39");
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1947832866, "CC(remember):NavigationRail.kt#9igjgp");
                            objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue5 = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            composerStartRestartGroup.endReplaceGroup();
                            mutableInteractionSource4 = (MutableInteractionSource) objRememberedValue5;
                        } else {
                            composerStartRestartGroup.startReplaceGroup(1947832215);
                            composerStartRestartGroup.endReplaceGroup();
                            mutableInteractionSource4 = mutableInteractionSource3;
                        }
                        finiteAnimationSpecValue = MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultEffects, composerStartRestartGroup, 6);
                        boolean z113 = z10;
                        ComposableLambda composableLambdaRememberComposableLambda17 = ComposableLambdaKt.rememberComposableLambda(206057749, true, new Function2() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda7
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return NavigationRailKt.NavigationRailItem$lambda$1(navigationRailItemColors3, z, z9, finiteAnimationSpecValue, function6, z10, function2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                        if (function6 == null) {
                            composerStartRestartGroup.startReplaceGroup(254203944);
                            composerStartRestartGroup.endReplaceGroup();
                            navigationRailItemColors4 = navigationRailItemColors3;
                            function7 = function6;
                            r7 = 1;
                            composableLambda = null;
                        } else {
                            composerStartRestartGroup.startReplaceGroup(254203945);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "*233@10636L534");
                            final NavigationRailItemColors navigationRailItemColors13 = navigationRailItemColors3;
                            final boolean z114 = z9;
                            final Function2 function16 = function6;
                            navigationRailItemColors4 = navigationRailItemColors13;
                            function7 = function16;
                            r7 = 1;
                            ComposableLambda composableLambdaRememberComposableLambda18 = ComposableLambdaKt.rememberComposableLambda(-2056532825, true, new Function2() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda8
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return NavigationRailKt.NavigationRailItem$lambda$2$0(navigationRailItemColors13, z, z114, finiteAnimationSpecValue, function16, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composerStartRestartGroup, 54);
                            composerStartRestartGroup.endReplaceGroup();
                            composableLambda = composableLambdaRememberComposableLambda18;
                        }
                        boolean z115 = z9;
                        Modifier modifier8 = modifier3;
                        mutableInteractionSource5 = mutableInteractionSource4;
                        Modifier modifierM1273widthInVpY3zN4$default5 = SizeKt.m1273widthInVpY3zN4$default(SizeKt.m1251defaultMinSizeVpY3zN4$default(SelectableKt.m1533selectableO2vRcR0(modifier8, z, mutableInteractionSource5, null, z115, Role.m8825boximpl(Role.INSTANCE.m8839getTabo7Vup1c()), function0), 0.0f, NavigationRailItemHeight, r7, null), NavigationRailItemWidth, 0.0f, 2, null);
                        Alignment center5 = Alignment.INSTANCE.getCenter();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy5 = BoxKt.maybeCachedBoxMeasurePolicy(center5, r7);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                        CompositionLocalMap currentCompositionLocalMap5 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier5 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1273widthInVpY3zN4$default5);
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
                        BoxScopeInstance boxScopeInstance5 = BoxScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1826936439, "C267@11982L7,264@11752L252,273@12294L7,270@12067L249,279@12577L7,280@12620L315,289@12986L146,303@13569L237,311@13855L285,325@14406L32,326@14476L31,319@14150L368:NavigationRail.kt#uh7d8r");
                        if (z) {
                            f = 1.0f;
                        } else {
                            f = 0.0f;
                        }
                        final NavigationRailItemColors navigationRailItemColors14 = navigationRailItemColors4;
                        stateAnimateFloatAsState = AnimateAsStateKt.animateFloatAsState(f, MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultEffects, composerStartRestartGroup, 6), 0.0f, null, null, composerStartRestartGroup, 0, 28);
                        if (z) {
                            f2 = 1.0f;
                        } else {
                            f2 = 0.0f;
                        }
                        stateAnimateFloatAsState2 = AnimateAsStateKt.animateFloatAsState(f2, MotionSchemeKt.value(MotionSchemeKeyTokens.FastSpatial, composerStartRestartGroup, 6), 0.0f, null, null, composerStartRestartGroup, 0, 28);
                        ProvidableCompositionLocal<Density> localDensity5 = CompositionLocalsKt.getLocalDensity();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object objConsume5 = composerStartRestartGroup.consume(localDensity5);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        density = (Density) objConsume5;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -474548400, "CC(remember):NavigationRail.kt#9igjgp");
                        zChanged = composerStartRestartGroup.changed(density);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!zChanged) {
                            objRememberedValue = new Function0() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda9
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return NavigationRailKt.NavigationRailItem$lambda$3$0$0(density);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = new Function0() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda9
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return NavigationRailKt.NavigationRailItem$lambda$3$0$0(density);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        function1 = (Function0) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -474536857, "CC(remember):NavigationRail.kt#9igjgp");
                        zChanged2 = composerStartRestartGroup.changed(mutableInteractionSource5) | composerStartRestartGroup.changed(function1);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged2) {
                            objRememberedValue2 = new MappedInteractionSource(mutableInteractionSource5, function1);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        } else {
                            objRememberedValue2 = new MappedInteractionSource(mutableInteractionSource5, function1);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        final MappedInteractionSource mappedInteractionSource5 = (MappedInteractionSource) objRememberedValue2;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if (function7 != null) {
                            composerStartRestartGroup.startReplaceGroup(-1825536046);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "295@13266L5");
                            value = ShapesKt.getValue(NavigationRailBaselineItemTokens.INSTANCE.getActiveIndicatorShape(), composerStartRestartGroup, 6);
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            composerStartRestartGroup.startReplaceGroup(-1825440690);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "297@13335L5");
                            value = ShapesKt.getValue(ShapeKeyTokens.CornerFull, composerStartRestartGroup, 6);
                            composerStartRestartGroup.endReplaceGroup();
                        }
                        ComposableLambda composableLambdaRememberComposableLambda19 = ComposableLambdaKt.rememberComposableLambda(455696046, true, new Function2() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda10
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return NavigationRailKt.NavigationRailItem$lambda$3$2(value, mappedInteractionSource5, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                        ComposableLambda composableLambdaRememberComposableLambda110 = ComposableLambdaKt.rememberComposableLambda(2137606782, true, new Function2() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda11
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return NavigationRailKt.NavigationRailItem$lambda$3$3(stateAnimateFloatAsState, navigationRailItemColors14, value, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -474491531, "CC(remember):NavigationRail.kt#9igjgp");
                        zChanged3 = composerStartRestartGroup.changed(stateAnimateFloatAsState);
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged3) {
                            objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda12
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return Float.valueOf(NavigationRailKt.NavigationRailItem$lambda$3$4$0(stateAnimateFloatAsState));
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        } else {
                            objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda12
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return Float.valueOf(NavigationRailKt.NavigationRailItem$lambda$3$4$0(stateAnimateFloatAsState));
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        Function0 function17 = (Function0) objRememberedValue3;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -474489292, "CC(remember):NavigationRail.kt#9igjgp");
                        zChanged4 = composerStartRestartGroup.changed(stateAnimateFloatAsState2);
                        objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged4) {
                            objRememberedValue4 = new Function0() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda13
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return Float.valueOf(NavigationRailKt.NavigationRailItem$lambda$3$5$0(stateAnimateFloatAsState2));
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        } else {
                            objRememberedValue4 = new Function0() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda13
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return Float.valueOf(NavigationRailKt.NavigationRailItem$lambda$3$5$0(stateAnimateFloatAsState2));
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        NavigationRailItemLayout(composableLambdaRememberComposableLambda19, composableLambdaRememberComposableLambda110, composableLambdaRememberComposableLambda17, composableLambda, z113, function17, (Function0) objRememberedValue4, composerStartRestartGroup, (57344 & (i12 >> 6)) | 438);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        navigationRailItemColors2 = navigationRailItemColors14;
                        composer2 = composerStartRestartGroup;
                        z6 = z113;
                        z7 = z115;
                        mutableInteractionSource2 = mutableInteractionSource3;
                        modifier2 = modifier8;
                        function5 = function7;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        z6 = z3;
                        mutableInteractionSource2 = mutableInteractionSource;
                        z7 = z4;
                        composer2 = composerStartRestartGroup;
                        function5 = function4;
                        navigationRailItemColors2 = navigationRailItemColors;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda14
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return NavigationRailKt.NavigationRailItem$lambda$4(z, function0, function2, modifier2, z7, function5, z6, navigationRailItemColors2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= 100663296;
                if ((i3 & 38347923) != 38347922) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z5, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "210@9536L8");
                    if ((i & 1) != 0) {
                        if (i13 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            z4 = true;
                        }
                        if (i6 != 0) {
                            function4 = null;
                        }
                        if (i8 != 0) {
                            z8 = true;
                        } else {
                            z8 = z3;
                        }
                        if ((i2 & 128) != 0) {
                            navigationRailItemColorsColors = NavigationRailItemDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            navigationRailItemColorsColors = navigationRailItemColors;
                        }
                        i12 = i3;
                        navigationRailItemColors3 = navigationRailItemColorsColors;
                        modifier3 = modifier2;
                        z9 = z4;
                        function6 = function4;
                        if (i10 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        z10 = z8;
                    } else {
                        if (i13 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            z4 = true;
                        }
                        if (i6 != 0) {
                            function4 = null;
                        }
                        if (i8 != 0) {
                            z8 = true;
                        } else {
                            z8 = z3;
                        }
                        if ((i2 & 128) != 0) {
                            navigationRailItemColorsColors = NavigationRailItemDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            navigationRailItemColorsColors = navigationRailItemColors;
                        }
                        i12 = i3;
                        navigationRailItemColors3 = navigationRailItemColorsColors;
                        modifier3 = modifier2;
                        z9 = z4;
                        function6 = function4;
                        if (i10 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        z10 = z8;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1620317701, i12, -1, "androidx.compose.material3.NavigationRailItem (NavigationRail.kt:212)");
                    }
                    if (mutableInteractionSource3 == null) {
                        composerStartRestartGroup.startReplaceGroup(253276704);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "214@9688L39");
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1947832866, "CC(remember):NavigationRail.kt#9igjgp");
                        objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue5 = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.endReplaceGroup();
                        mutableInteractionSource4 = (MutableInteractionSource) objRememberedValue5;
                    } else {
                        composerStartRestartGroup.startReplaceGroup(1947832215);
                        composerStartRestartGroup.endReplaceGroup();
                        mutableInteractionSource4 = mutableInteractionSource3;
                    }
                    finiteAnimationSpecValue = MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultEffects, composerStartRestartGroup, 6);
                    boolean z116 = z10;
                    ComposableLambda composableLambdaRememberComposableLambda111 = ComposableLambdaKt.rememberComposableLambda(206057749, true, new Function2() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return NavigationRailKt.NavigationRailItem$lambda$1(navigationRailItemColors3, z, z9, finiteAnimationSpecValue, function6, z10, function2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54);
                    if (function6 == null) {
                        composerStartRestartGroup.startReplaceGroup(254203944);
                        composerStartRestartGroup.endReplaceGroup();
                        navigationRailItemColors4 = navigationRailItemColors3;
                        function7 = function6;
                        r7 = 1;
                        composableLambda = null;
                    } else {
                        composerStartRestartGroup.startReplaceGroup(254203945);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "*233@10636L534");
                        final NavigationRailItemColors navigationRailItemColors15 = navigationRailItemColors3;
                        final boolean z117 = z9;
                        final Function2 function18 = function6;
                        navigationRailItemColors4 = navigationRailItemColors15;
                        function7 = function18;
                        r7 = 1;
                        ComposableLambda composableLambdaRememberComposableLambda112 = ComposableLambdaKt.rememberComposableLambda(-2056532825, true, new Function2() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda8
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return NavigationRailKt.NavigationRailItem$lambda$2$0(navigationRailItemColors15, z, z117, finiteAnimationSpecValue, function18, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                        composerStartRestartGroup.endReplaceGroup();
                        composableLambda = composableLambdaRememberComposableLambda112;
                    }
                    boolean z118 = z9;
                    Modifier modifier9 = modifier3;
                    mutableInteractionSource5 = mutableInteractionSource4;
                    Modifier modifierM1273widthInVpY3zN4$default6 = SizeKt.m1273widthInVpY3zN4$default(SizeKt.m1251defaultMinSizeVpY3zN4$default(SelectableKt.m1533selectableO2vRcR0(modifier9, z, mutableInteractionSource5, null, z118, Role.m8825boximpl(Role.INSTANCE.m8839getTabo7Vup1c()), function0), 0.0f, NavigationRailItemHeight, r7, null), NavigationRailItemWidth, 0.0f, 2, null);
                    Alignment center6 = Alignment.INSTANCE.getCenter();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy6 = BoxKt.maybeCachedBoxMeasurePolicy(center6, r7);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap6 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier6 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1273widthInVpY3zN4$default6);
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
                    Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy6, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap6, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (!composerM6062constructorimpl.getInserting()) {
                        composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    } else {
                        composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier6, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance6 = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1826936439, "C267@11982L7,264@11752L252,273@12294L7,270@12067L249,279@12577L7,280@12620L315,289@12986L146,303@13569L237,311@13855L285,325@14406L32,326@14476L31,319@14150L368:NavigationRail.kt#uh7d8r");
                    if (z) {
                        f = 1.0f;
                    } else {
                        f = 0.0f;
                    }
                    final NavigationRailItemColors navigationRailItemColors16 = navigationRailItemColors4;
                    stateAnimateFloatAsState = AnimateAsStateKt.animateFloatAsState(f, MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultEffects, composerStartRestartGroup, 6), 0.0f, null, null, composerStartRestartGroup, 0, 28);
                    if (z) {
                        f2 = 1.0f;
                    } else {
                        f2 = 0.0f;
                    }
                    stateAnimateFloatAsState2 = AnimateAsStateKt.animateFloatAsState(f2, MotionSchemeKt.value(MotionSchemeKeyTokens.FastSpatial, composerStartRestartGroup, 6), 0.0f, null, null, composerStartRestartGroup, 0, 28);
                    ProvidableCompositionLocal<Density> localDensity6 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume6 = composerStartRestartGroup.consume(localDensity6);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    density = (Density) objConsume6;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -474548400, "CC(remember):NavigationRail.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(density);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue = new Function0() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda9
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return NavigationRailKt.NavigationRailItem$lambda$3$0$0(density);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new Function0() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda9
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return NavigationRailKt.NavigationRailItem$lambda$3$0$0(density);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    function1 = (Function0) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -474536857, "CC(remember):NavigationRail.kt#9igjgp");
                    zChanged2 = composerStartRestartGroup.changed(mutableInteractionSource5) | composerStartRestartGroup.changed(function1);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged2) {
                        objRememberedValue2 = new MappedInteractionSource(mutableInteractionSource5, function1);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new MappedInteractionSource(mutableInteractionSource5, function1);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    final MappedInteractionSource mappedInteractionSource6 = (MappedInteractionSource) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (function7 != null) {
                        composerStartRestartGroup.startReplaceGroup(-1825536046);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "295@13266L5");
                        value = ShapesKt.getValue(NavigationRailBaselineItemTokens.INSTANCE.getActiveIndicatorShape(), composerStartRestartGroup, 6);
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-1825440690);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "297@13335L5");
                        value = ShapesKt.getValue(ShapeKeyTokens.CornerFull, composerStartRestartGroup, 6);
                        composerStartRestartGroup.endReplaceGroup();
                    }
                    ComposableLambda composableLambdaRememberComposableLambda113 = ComposableLambdaKt.rememberComposableLambda(455696046, true, new Function2() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda10
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return NavigationRailKt.NavigationRailItem$lambda$3$2(value, mappedInteractionSource6, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54);
                    ComposableLambda composableLambdaRememberComposableLambda114 = ComposableLambdaKt.rememberComposableLambda(2137606782, true, new Function2() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda11
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return NavigationRailKt.NavigationRailItem$lambda$3$3(stateAnimateFloatAsState, navigationRailItemColors16, value, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -474491531, "CC(remember):NavigationRail.kt#9igjgp");
                    zChanged3 = composerStartRestartGroup.changed(stateAnimateFloatAsState);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged3) {
                        objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda12
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Float.valueOf(NavigationRailKt.NavigationRailItem$lambda$3$4$0(stateAnimateFloatAsState));
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda12
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Float.valueOf(NavigationRailKt.NavigationRailItem$lambda$3$4$0(stateAnimateFloatAsState));
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    Function0 function19 = (Function0) objRememberedValue3;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -474489292, "CC(remember):NavigationRail.kt#9igjgp");
                    zChanged4 = composerStartRestartGroup.changed(stateAnimateFloatAsState2);
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged4) {
                        objRememberedValue4 = new Function0() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda13
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Float.valueOf(NavigationRailKt.NavigationRailItem$lambda$3$5$0(stateAnimateFloatAsState2));
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    } else {
                        objRememberedValue4 = new Function0() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda13
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Float.valueOf(NavigationRailKt.NavigationRailItem$lambda$3$5$0(stateAnimateFloatAsState2));
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    NavigationRailItemLayout(composableLambdaRememberComposableLambda113, composableLambdaRememberComposableLambda114, composableLambdaRememberComposableLambda111, composableLambda, z116, function19, (Function0) objRememberedValue4, composerStartRestartGroup, (57344 & (i12 >> 6)) | 438);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    navigationRailItemColors2 = navigationRailItemColors16;
                    composer2 = composerStartRestartGroup;
                    z6 = z116;
                    z7 = z118;
                    mutableInteractionSource2 = mutableInteractionSource3;
                    modifier2 = modifier9;
                    function5 = function7;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    z6 = z3;
                    mutableInteractionSource2 = mutableInteractionSource;
                    z7 = z4;
                    composer2 = composerStartRestartGroup;
                    function5 = function4;
                    navigationRailItemColors2 = navigationRailItemColors;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda14
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return NavigationRailKt.NavigationRailItem$lambda$4(z, function0, function2, modifier2, z7, function5, z6, navigationRailItemColors2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            function4 = function3;
            i8 = i2 & 64;
            if (i8 != 0) {
                i3 |= 1572864;
            } else if ((i & 1572864) == 0) {
                if (composerStartRestartGroup.changed(z3)) {
                    i9 = 1048576;
                } else {
                    i9 = 524288;
                }
                i3 |= i9;
            }
            if ((i & 12582912) != 0) {
                i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(navigationRailItemColors)) ? 4194304 : 8388608;
            }
            i10 = i2 & 256;
            if (i10 != 0) {
                if ((i & 100663296) == 0) {
                    if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                        i11 = 67108864;
                    } else {
                        i11 = 33554432;
                    }
                    i3 |= i11;
                }
                if ((i3 & 38347923) != 38347922) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z5, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "210@9536L8");
                    if ((i & 1) != 0) {
                        if (i13 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            z4 = true;
                        }
                        if (i6 != 0) {
                            function4 = null;
                        }
                        if (i8 != 0) {
                            z8 = true;
                        } else {
                            z8 = z3;
                        }
                        if ((i2 & 128) != 0) {
                            navigationRailItemColorsColors = NavigationRailItemDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            navigationRailItemColorsColors = navigationRailItemColors;
                        }
                        i12 = i3;
                        navigationRailItemColors3 = navigationRailItemColorsColors;
                        modifier3 = modifier2;
                        z9 = z4;
                        function6 = function4;
                        if (i10 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        z10 = z8;
                    } else {
                        if (i13 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            z4 = true;
                        }
                        if (i6 != 0) {
                            function4 = null;
                        }
                        if (i8 != 0) {
                            z8 = true;
                        } else {
                            z8 = z3;
                        }
                        if ((i2 & 128) != 0) {
                            navigationRailItemColorsColors = NavigationRailItemDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            navigationRailItemColorsColors = navigationRailItemColors;
                        }
                        i12 = i3;
                        navigationRailItemColors3 = navigationRailItemColorsColors;
                        modifier3 = modifier2;
                        z9 = z4;
                        function6 = function4;
                        if (i10 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        z10 = z8;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1620317701, i12, -1, "androidx.compose.material3.NavigationRailItem (NavigationRail.kt:212)");
                    }
                    if (mutableInteractionSource3 == null) {
                        composerStartRestartGroup.startReplaceGroup(253276704);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "214@9688L39");
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1947832866, "CC(remember):NavigationRail.kt#9igjgp");
                        objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue5 = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.endReplaceGroup();
                        mutableInteractionSource4 = (MutableInteractionSource) objRememberedValue5;
                    } else {
                        composerStartRestartGroup.startReplaceGroup(1947832215);
                        composerStartRestartGroup.endReplaceGroup();
                        mutableInteractionSource4 = mutableInteractionSource3;
                    }
                    finiteAnimationSpecValue = MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultEffects, composerStartRestartGroup, 6);
                    boolean z119 = z10;
                    ComposableLambda composableLambdaRememberComposableLambda115 = ComposableLambdaKt.rememberComposableLambda(206057749, true, new Function2() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return NavigationRailKt.NavigationRailItem$lambda$1(navigationRailItemColors3, z, z9, finiteAnimationSpecValue, function6, z10, function2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54);
                    if (function6 == null) {
                        composerStartRestartGroup.startReplaceGroup(254203944);
                        composerStartRestartGroup.endReplaceGroup();
                        navigationRailItemColors4 = navigationRailItemColors3;
                        function7 = function6;
                        r7 = 1;
                        composableLambda = null;
                    } else {
                        composerStartRestartGroup.startReplaceGroup(254203945);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "*233@10636L534");
                        final NavigationRailItemColors navigationRailItemColors17 = navigationRailItemColors3;
                        final boolean z1110 = z9;
                        final Function2 function110 = function6;
                        navigationRailItemColors4 = navigationRailItemColors17;
                        function7 = function110;
                        r7 = 1;
                        ComposableLambda composableLambdaRememberComposableLambda116 = ComposableLambdaKt.rememberComposableLambda(-2056532825, true, new Function2() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda8
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return NavigationRailKt.NavigationRailItem$lambda$2$0(navigationRailItemColors17, z, z1110, finiteAnimationSpecValue, function110, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                        composerStartRestartGroup.endReplaceGroup();
                        composableLambda = composableLambdaRememberComposableLambda116;
                    }
                    boolean z1111 = z9;
                    Modifier modifier10 = modifier3;
                    mutableInteractionSource5 = mutableInteractionSource4;
                    Modifier modifierM1273widthInVpY3zN4$default7 = SizeKt.m1273widthInVpY3zN4$default(SizeKt.m1251defaultMinSizeVpY3zN4$default(SelectableKt.m1533selectableO2vRcR0(modifier10, z, mutableInteractionSource5, null, z1111, Role.m8825boximpl(Role.INSTANCE.m8839getTabo7Vup1c()), function0), 0.0f, NavigationRailItemHeight, r7, null), NavigationRailItemWidth, 0.0f, 2, null);
                    Alignment center7 = Alignment.INSTANCE.getCenter();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy7 = BoxKt.maybeCachedBoxMeasurePolicy(center7, r7);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap7 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier7 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1273widthInVpY3zN4$default7);
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
                    BoxScopeInstance boxScopeInstance7 = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1826936439, "C267@11982L7,264@11752L252,273@12294L7,270@12067L249,279@12577L7,280@12620L315,289@12986L146,303@13569L237,311@13855L285,325@14406L32,326@14476L31,319@14150L368:NavigationRail.kt#uh7d8r");
                    if (z) {
                        f = 1.0f;
                    } else {
                        f = 0.0f;
                    }
                    final NavigationRailItemColors navigationRailItemColors18 = navigationRailItemColors4;
                    stateAnimateFloatAsState = AnimateAsStateKt.animateFloatAsState(f, MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultEffects, composerStartRestartGroup, 6), 0.0f, null, null, composerStartRestartGroup, 0, 28);
                    if (z) {
                        f2 = 1.0f;
                    } else {
                        f2 = 0.0f;
                    }
                    stateAnimateFloatAsState2 = AnimateAsStateKt.animateFloatAsState(f2, MotionSchemeKt.value(MotionSchemeKeyTokens.FastSpatial, composerStartRestartGroup, 6), 0.0f, null, null, composerStartRestartGroup, 0, 28);
                    ProvidableCompositionLocal<Density> localDensity7 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume7 = composerStartRestartGroup.consume(localDensity7);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    density = (Density) objConsume7;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -474548400, "CC(remember):NavigationRail.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(density);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue = new Function0() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda9
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return NavigationRailKt.NavigationRailItem$lambda$3$0$0(density);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new Function0() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda9
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return NavigationRailKt.NavigationRailItem$lambda$3$0$0(density);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    function1 = (Function0) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -474536857, "CC(remember):NavigationRail.kt#9igjgp");
                    zChanged2 = composerStartRestartGroup.changed(mutableInteractionSource5) | composerStartRestartGroup.changed(function1);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged2) {
                        objRememberedValue2 = new MappedInteractionSource(mutableInteractionSource5, function1);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new MappedInteractionSource(mutableInteractionSource5, function1);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    final MappedInteractionSource mappedInteractionSource7 = (MappedInteractionSource) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (function7 != null) {
                        composerStartRestartGroup.startReplaceGroup(-1825536046);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "295@13266L5");
                        value = ShapesKt.getValue(NavigationRailBaselineItemTokens.INSTANCE.getActiveIndicatorShape(), composerStartRestartGroup, 6);
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-1825440690);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "297@13335L5");
                        value = ShapesKt.getValue(ShapeKeyTokens.CornerFull, composerStartRestartGroup, 6);
                        composerStartRestartGroup.endReplaceGroup();
                    }
                    ComposableLambda composableLambdaRememberComposableLambda117 = ComposableLambdaKt.rememberComposableLambda(455696046, true, new Function2() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda10
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return NavigationRailKt.NavigationRailItem$lambda$3$2(value, mappedInteractionSource7, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54);
                    ComposableLambda composableLambdaRememberComposableLambda118 = ComposableLambdaKt.rememberComposableLambda(2137606782, true, new Function2() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda11
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return NavigationRailKt.NavigationRailItem$lambda$3$3(stateAnimateFloatAsState, navigationRailItemColors18, value, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -474491531, "CC(remember):NavigationRail.kt#9igjgp");
                    zChanged3 = composerStartRestartGroup.changed(stateAnimateFloatAsState);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged3) {
                        objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda12
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Float.valueOf(NavigationRailKt.NavigationRailItem$lambda$3$4$0(stateAnimateFloatAsState));
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda12
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Float.valueOf(NavigationRailKt.NavigationRailItem$lambda$3$4$0(stateAnimateFloatAsState));
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    Function0 function111 = (Function0) objRememberedValue3;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -474489292, "CC(remember):NavigationRail.kt#9igjgp");
                    zChanged4 = composerStartRestartGroup.changed(stateAnimateFloatAsState2);
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged4) {
                        objRememberedValue4 = new Function0() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda13
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Float.valueOf(NavigationRailKt.NavigationRailItem$lambda$3$5$0(stateAnimateFloatAsState2));
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    } else {
                        objRememberedValue4 = new Function0() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda13
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Float.valueOf(NavigationRailKt.NavigationRailItem$lambda$3$5$0(stateAnimateFloatAsState2));
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    NavigationRailItemLayout(composableLambdaRememberComposableLambda117, composableLambdaRememberComposableLambda118, composableLambdaRememberComposableLambda115, composableLambda, z119, function111, (Function0) objRememberedValue4, composerStartRestartGroup, (57344 & (i12 >> 6)) | 438);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    navigationRailItemColors2 = navigationRailItemColors18;
                    composer2 = composerStartRestartGroup;
                    z6 = z119;
                    z7 = z1111;
                    mutableInteractionSource2 = mutableInteractionSource3;
                    modifier2 = modifier10;
                    function5 = function7;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    z6 = z3;
                    mutableInteractionSource2 = mutableInteractionSource;
                    z7 = z4;
                    composer2 = composerStartRestartGroup;
                    function5 = function4;
                    navigationRailItemColors2 = navigationRailItemColors;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda14
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return NavigationRailKt.NavigationRailItem$lambda$4(z, function0, function2, modifier2, z7, function5, z6, navigationRailItemColors2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 100663296;
            if ((i3 & 38347923) != 38347922) {
                z5 = true;
            } else {
                z5 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z5, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "210@9536L8");
                if ((i & 1) != 0) {
                    if (i13 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        z4 = true;
                    }
                    if (i6 != 0) {
                        function4 = null;
                    }
                    if (i8 != 0) {
                        z8 = true;
                    } else {
                        z8 = z3;
                    }
                    if ((i2 & 128) != 0) {
                        navigationRailItemColorsColors = NavigationRailItemDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                        i3 &= -29360129;
                    } else {
                        navigationRailItemColorsColors = navigationRailItemColors;
                    }
                    i12 = i3;
                    navigationRailItemColors3 = navigationRailItemColorsColors;
                    modifier3 = modifier2;
                    z9 = z4;
                    function6 = function4;
                    if (i10 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    z10 = z8;
                } else {
                    if (i13 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        z4 = true;
                    }
                    if (i6 != 0) {
                        function4 = null;
                    }
                    if (i8 != 0) {
                        z8 = true;
                    } else {
                        z8 = z3;
                    }
                    if ((i2 & 128) != 0) {
                        navigationRailItemColorsColors = NavigationRailItemDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                        i3 &= -29360129;
                    } else {
                        navigationRailItemColorsColors = navigationRailItemColors;
                    }
                    i12 = i3;
                    navigationRailItemColors3 = navigationRailItemColorsColors;
                    modifier3 = modifier2;
                    z9 = z4;
                    function6 = function4;
                    if (i10 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    z10 = z8;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1620317701, i12, -1, "androidx.compose.material3.NavigationRailItem (NavigationRail.kt:212)");
                }
                if (mutableInteractionSource3 == null) {
                    composerStartRestartGroup.startReplaceGroup(253276704);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "214@9688L39");
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1947832866, "CC(remember):NavigationRail.kt#9igjgp");
                    objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue5 = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endReplaceGroup();
                    mutableInteractionSource4 = (MutableInteractionSource) objRememberedValue5;
                } else {
                    composerStartRestartGroup.startReplaceGroup(1947832215);
                    composerStartRestartGroup.endReplaceGroup();
                    mutableInteractionSource4 = mutableInteractionSource3;
                }
                finiteAnimationSpecValue = MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultEffects, composerStartRestartGroup, 6);
                boolean z1112 = z10;
                ComposableLambda composableLambdaRememberComposableLambda119 = ComposableLambdaKt.rememberComposableLambda(206057749, true, new Function2() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return NavigationRailKt.NavigationRailItem$lambda$1(navigationRailItemColors3, z, z9, finiteAnimationSpecValue, function6, z10, function2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54);
                if (function6 == null) {
                    composerStartRestartGroup.startReplaceGroup(254203944);
                    composerStartRestartGroup.endReplaceGroup();
                    navigationRailItemColors4 = navigationRailItemColors3;
                    function7 = function6;
                    r7 = 1;
                    composableLambda = null;
                } else {
                    composerStartRestartGroup.startReplaceGroup(254203945);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "*233@10636L534");
                    final NavigationRailItemColors navigationRailItemColors19 = navigationRailItemColors3;
                    final boolean z1113 = z9;
                    final Function2 function112 = function6;
                    navigationRailItemColors4 = navigationRailItemColors19;
                    function7 = function112;
                    r7 = 1;
                    ComposableLambda composableLambdaRememberComposableLambda1110 = ComposableLambdaKt.rememberComposableLambda(-2056532825, true, new Function2() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda8
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return NavigationRailKt.NavigationRailItem$lambda$2$0(navigationRailItemColors19, z, z1113, finiteAnimationSpecValue, function112, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54);
                    composerStartRestartGroup.endReplaceGroup();
                    composableLambda = composableLambdaRememberComposableLambda1110;
                }
                boolean z1114 = z9;
                Modifier modifier11 = modifier3;
                mutableInteractionSource5 = mutableInteractionSource4;
                Modifier modifierM1273widthInVpY3zN4$default8 = SizeKt.m1273widthInVpY3zN4$default(SizeKt.m1251defaultMinSizeVpY3zN4$default(SelectableKt.m1533selectableO2vRcR0(modifier11, z, mutableInteractionSource5, null, z1114, Role.m8825boximpl(Role.INSTANCE.m8839getTabo7Vup1c()), function0), 0.0f, NavigationRailItemHeight, r7, null), NavigationRailItemWidth, 0.0f, 2, null);
                Alignment center8 = Alignment.INSTANCE.getCenter();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy8 = BoxKt.maybeCachedBoxMeasurePolicy(center8, r7);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap8 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier8 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1273widthInVpY3zN4$default8);
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
                Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy8, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap8, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!composerM6062constructorimpl.getInserting()) {
                    composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                } else {
                    composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier8, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance8 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1826936439, "C267@11982L7,264@11752L252,273@12294L7,270@12067L249,279@12577L7,280@12620L315,289@12986L146,303@13569L237,311@13855L285,325@14406L32,326@14476L31,319@14150L368:NavigationRail.kt#uh7d8r");
                if (z) {
                    f = 1.0f;
                } else {
                    f = 0.0f;
                }
                final NavigationRailItemColors navigationRailItemColors110 = navigationRailItemColors4;
                stateAnimateFloatAsState = AnimateAsStateKt.animateFloatAsState(f, MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultEffects, composerStartRestartGroup, 6), 0.0f, null, null, composerStartRestartGroup, 0, 28);
                if (z) {
                    f2 = 1.0f;
                } else {
                    f2 = 0.0f;
                }
                stateAnimateFloatAsState2 = AnimateAsStateKt.animateFloatAsState(f2, MotionSchemeKt.value(MotionSchemeKeyTokens.FastSpatial, composerStartRestartGroup, 6), 0.0f, null, null, composerStartRestartGroup, 0, 28);
                ProvidableCompositionLocal<Density> localDensity8 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume8 = composerStartRestartGroup.consume(localDensity8);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                density = (Density) objConsume8;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -474548400, "CC(remember):NavigationRail.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(density);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue = new Function0() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda9
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return NavigationRailKt.NavigationRailItem$lambda$3$0$0(density);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new Function0() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda9
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return NavigationRailKt.NavigationRailItem$lambda$3$0$0(density);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                function1 = (Function0) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -474536857, "CC(remember):NavigationRail.kt#9igjgp");
                zChanged2 = composerStartRestartGroup.changed(mutableInteractionSource5) | composerStartRestartGroup.changed(function1);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!zChanged2) {
                    objRememberedValue2 = new MappedInteractionSource(mutableInteractionSource5, function1);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = new MappedInteractionSource(mutableInteractionSource5, function1);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                final MappedInteractionSource mappedInteractionSource8 = (MappedInteractionSource) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (function7 != null) {
                    composerStartRestartGroup.startReplaceGroup(-1825536046);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "295@13266L5");
                    value = ShapesKt.getValue(NavigationRailBaselineItemTokens.INSTANCE.getActiveIndicatorShape(), composerStartRestartGroup, 6);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(-1825440690);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "297@13335L5");
                    value = ShapesKt.getValue(ShapeKeyTokens.CornerFull, composerStartRestartGroup, 6);
                    composerStartRestartGroup.endReplaceGroup();
                }
                ComposableLambda composableLambdaRememberComposableLambda1111 = ComposableLambdaKt.rememberComposableLambda(455696046, true, new Function2() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda10
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return NavigationRailKt.NavigationRailItem$lambda$3$2(value, mappedInteractionSource8, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54);
                ComposableLambda composableLambdaRememberComposableLambda1112 = ComposableLambdaKt.rememberComposableLambda(2137606782, true, new Function2() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda11
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return NavigationRailKt.NavigationRailItem$lambda$3$3(stateAnimateFloatAsState, navigationRailItemColors110, value, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -474491531, "CC(remember):NavigationRail.kt#9igjgp");
                zChanged3 = composerStartRestartGroup.changed(stateAnimateFloatAsState);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (!zChanged3) {
                    objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda12
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return Float.valueOf(NavigationRailKt.NavigationRailItem$lambda$3$4$0(stateAnimateFloatAsState));
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda12
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return Float.valueOf(NavigationRailKt.NavigationRailItem$lambda$3$4$0(stateAnimateFloatAsState));
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                Function0 function113 = (Function0) objRememberedValue3;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -474489292, "CC(remember):NavigationRail.kt#9igjgp");
                zChanged4 = composerStartRestartGroup.changed(stateAnimateFloatAsState2);
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (!zChanged4) {
                    objRememberedValue4 = new Function0() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda13
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return Float.valueOf(NavigationRailKt.NavigationRailItem$lambda$3$5$0(stateAnimateFloatAsState2));
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                } else {
                    objRememberedValue4 = new Function0() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda13
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return Float.valueOf(NavigationRailKt.NavigationRailItem$lambda$3$5$0(stateAnimateFloatAsState2));
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                NavigationRailItemLayout(composableLambdaRememberComposableLambda1111, composableLambdaRememberComposableLambda1112, composableLambdaRememberComposableLambda119, composableLambda, z1112, function113, (Function0) objRememberedValue4, composerStartRestartGroup, (57344 & (i12 >> 6)) | 438);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                navigationRailItemColors2 = navigationRailItemColors110;
                composer2 = composerStartRestartGroup;
                z6 = z1112;
                z7 = z1114;
                mutableInteractionSource2 = mutableInteractionSource3;
                modifier2 = modifier11;
                function5 = function7;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                z6 = z3;
                mutableInteractionSource2 = mutableInteractionSource;
                z7 = z4;
                composer2 = composerStartRestartGroup;
                function5 = function4;
                navigationRailItemColors2 = navigationRailItemColors;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda14
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return NavigationRailKt.NavigationRailItem$lambda$4(z, function0, function2, modifier2, z7, function5, z6, navigationRailItemColors2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 3072;
        modifier2 = modifier;
        i4 = i2 & 16;
        if (i4 != 0) {
            if ((i & 24576) == 0) {
                z4 = z2;
                if (composerStartRestartGroup.changed(z4)) {
                    i5 = 16384;
                } else {
                    i5 = 8192;
                }
                i3 |= i5;
            }
            i6 = i2 & 32;
            if (i6 != 0) {
                if ((196608 & i) == 0) {
                    function4 = function3;
                    if (composerStartRestartGroup.changedInstance(function4)) {
                        i7 = 131072;
                    } else {
                        i7 = 65536;
                    }
                    i3 |= i7;
                }
                i8 = i2 & 64;
                if (i8 != 0) {
                    i3 |= 1572864;
                } else if ((i & 1572864) == 0) {
                    if (composerStartRestartGroup.changed(z3)) {
                        i9 = 1048576;
                    } else {
                        i9 = 524288;
                    }
                    i3 |= i9;
                }
                if ((i & 12582912) != 0) {
                    i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(navigationRailItemColors)) ? 4194304 : 8388608;
                }
                i10 = i2 & 256;
                if (i10 != 0) {
                    if ((i & 100663296) == 0) {
                        if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                            i11 = 67108864;
                        } else {
                            i11 = 33554432;
                        }
                        i3 |= i11;
                    }
                    if ((i3 & 38347923) != 38347922) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z5, i3 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "210@9536L8");
                        if ((i & 1) != 0) {
                            if (i13 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                z4 = true;
                            }
                            if (i6 != 0) {
                                function4 = null;
                            }
                            if (i8 != 0) {
                                z8 = true;
                            } else {
                                z8 = z3;
                            }
                            if ((i2 & 128) != 0) {
                                navigationRailItemColorsColors = NavigationRailItemDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                                i3 &= -29360129;
                            } else {
                                navigationRailItemColorsColors = navigationRailItemColors;
                            }
                            i12 = i3;
                            navigationRailItemColors3 = navigationRailItemColorsColors;
                            modifier3 = modifier2;
                            z9 = z4;
                            function6 = function4;
                            if (i10 != 0) {
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            z10 = z8;
                        } else {
                            if (i13 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                z4 = true;
                            }
                            if (i6 != 0) {
                                function4 = null;
                            }
                            if (i8 != 0) {
                                z8 = true;
                            } else {
                                z8 = z3;
                            }
                            if ((i2 & 128) != 0) {
                                navigationRailItemColorsColors = NavigationRailItemDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                                i3 &= -29360129;
                            } else {
                                navigationRailItemColorsColors = navigationRailItemColors;
                            }
                            i12 = i3;
                            navigationRailItemColors3 = navigationRailItemColorsColors;
                            modifier3 = modifier2;
                            z9 = z4;
                            function6 = function4;
                            if (i10 != 0) {
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            z10 = z8;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1620317701, i12, -1, "androidx.compose.material3.NavigationRailItem (NavigationRail.kt:212)");
                        }
                        if (mutableInteractionSource3 == null) {
                            composerStartRestartGroup.startReplaceGroup(253276704);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "214@9688L39");
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1947832866, "CC(remember):NavigationRail.kt#9igjgp");
                            objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue5 = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            composerStartRestartGroup.endReplaceGroup();
                            mutableInteractionSource4 = (MutableInteractionSource) objRememberedValue5;
                        } else {
                            composerStartRestartGroup.startReplaceGroup(1947832215);
                            composerStartRestartGroup.endReplaceGroup();
                            mutableInteractionSource4 = mutableInteractionSource3;
                        }
                        finiteAnimationSpecValue = MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultEffects, composerStartRestartGroup, 6);
                        boolean z1115 = z10;
                        ComposableLambda composableLambdaRememberComposableLambda1113 = ComposableLambdaKt.rememberComposableLambda(206057749, true, new Function2() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda7
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return NavigationRailKt.NavigationRailItem$lambda$1(navigationRailItemColors3, z, z9, finiteAnimationSpecValue, function6, z10, function2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                        if (function6 == null) {
                            composerStartRestartGroup.startReplaceGroup(254203944);
                            composerStartRestartGroup.endReplaceGroup();
                            navigationRailItemColors4 = navigationRailItemColors3;
                            function7 = function6;
                            r7 = 1;
                            composableLambda = null;
                        } else {
                            composerStartRestartGroup.startReplaceGroup(254203945);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "*233@10636L534");
                            final NavigationRailItemColors navigationRailItemColors111 = navigationRailItemColors3;
                            final boolean z1116 = z9;
                            final Function2 function114 = function6;
                            navigationRailItemColors4 = navigationRailItemColors111;
                            function7 = function114;
                            r7 = 1;
                            ComposableLambda composableLambdaRememberComposableLambda1114 = ComposableLambdaKt.rememberComposableLambda(-2056532825, true, new Function2() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda8
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return NavigationRailKt.NavigationRailItem$lambda$2$0(navigationRailItemColors111, z, z1116, finiteAnimationSpecValue, function114, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composerStartRestartGroup, 54);
                            composerStartRestartGroup.endReplaceGroup();
                            composableLambda = composableLambdaRememberComposableLambda1114;
                        }
                        boolean z1117 = z9;
                        Modifier modifier12 = modifier3;
                        mutableInteractionSource5 = mutableInteractionSource4;
                        Modifier modifierM1273widthInVpY3zN4$default9 = SizeKt.m1273widthInVpY3zN4$default(SizeKt.m1251defaultMinSizeVpY3zN4$default(SelectableKt.m1533selectableO2vRcR0(modifier12, z, mutableInteractionSource5, null, z1117, Role.m8825boximpl(Role.INSTANCE.m8839getTabo7Vup1c()), function0), 0.0f, NavigationRailItemHeight, r7, null), NavigationRailItemWidth, 0.0f, 2, null);
                        Alignment center9 = Alignment.INSTANCE.getCenter();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy9 = BoxKt.maybeCachedBoxMeasurePolicy(center9, r7);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                        CompositionLocalMap currentCompositionLocalMap9 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier9 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1273widthInVpY3zN4$default9);
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
                        BoxScopeInstance boxScopeInstance9 = BoxScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1826936439, "C267@11982L7,264@11752L252,273@12294L7,270@12067L249,279@12577L7,280@12620L315,289@12986L146,303@13569L237,311@13855L285,325@14406L32,326@14476L31,319@14150L368:NavigationRail.kt#uh7d8r");
                        if (z) {
                            f = 1.0f;
                        } else {
                            f = 0.0f;
                        }
                        final NavigationRailItemColors navigationRailItemColors112 = navigationRailItemColors4;
                        stateAnimateFloatAsState = AnimateAsStateKt.animateFloatAsState(f, MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultEffects, composerStartRestartGroup, 6), 0.0f, null, null, composerStartRestartGroup, 0, 28);
                        if (z) {
                            f2 = 1.0f;
                        } else {
                            f2 = 0.0f;
                        }
                        stateAnimateFloatAsState2 = AnimateAsStateKt.animateFloatAsState(f2, MotionSchemeKt.value(MotionSchemeKeyTokens.FastSpatial, composerStartRestartGroup, 6), 0.0f, null, null, composerStartRestartGroup, 0, 28);
                        ProvidableCompositionLocal<Density> localDensity9 = CompositionLocalsKt.getLocalDensity();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object objConsume9 = composerStartRestartGroup.consume(localDensity9);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        density = (Density) objConsume9;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -474548400, "CC(remember):NavigationRail.kt#9igjgp");
                        zChanged = composerStartRestartGroup.changed(density);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!zChanged) {
                            objRememberedValue = new Function0() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda9
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return NavigationRailKt.NavigationRailItem$lambda$3$0$0(density);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = new Function0() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda9
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return NavigationRailKt.NavigationRailItem$lambda$3$0$0(density);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        function1 = (Function0) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -474536857, "CC(remember):NavigationRail.kt#9igjgp");
                        zChanged2 = composerStartRestartGroup.changed(mutableInteractionSource5) | composerStartRestartGroup.changed(function1);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged2) {
                            objRememberedValue2 = new MappedInteractionSource(mutableInteractionSource5, function1);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        } else {
                            objRememberedValue2 = new MappedInteractionSource(mutableInteractionSource5, function1);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        final MappedInteractionSource mappedInteractionSource9 = (MappedInteractionSource) objRememberedValue2;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if (function7 != null) {
                            composerStartRestartGroup.startReplaceGroup(-1825536046);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "295@13266L5");
                            value = ShapesKt.getValue(NavigationRailBaselineItemTokens.INSTANCE.getActiveIndicatorShape(), composerStartRestartGroup, 6);
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            composerStartRestartGroup.startReplaceGroup(-1825440690);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "297@13335L5");
                            value = ShapesKt.getValue(ShapeKeyTokens.CornerFull, composerStartRestartGroup, 6);
                            composerStartRestartGroup.endReplaceGroup();
                        }
                        ComposableLambda composableLambdaRememberComposableLambda1115 = ComposableLambdaKt.rememberComposableLambda(455696046, true, new Function2() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda10
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return NavigationRailKt.NavigationRailItem$lambda$3$2(value, mappedInteractionSource9, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                        ComposableLambda composableLambdaRememberComposableLambda1116 = ComposableLambdaKt.rememberComposableLambda(2137606782, true, new Function2() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda11
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return NavigationRailKt.NavigationRailItem$lambda$3$3(stateAnimateFloatAsState, navigationRailItemColors112, value, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -474491531, "CC(remember):NavigationRail.kt#9igjgp");
                        zChanged3 = composerStartRestartGroup.changed(stateAnimateFloatAsState);
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged3) {
                            objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda12
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return Float.valueOf(NavigationRailKt.NavigationRailItem$lambda$3$4$0(stateAnimateFloatAsState));
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        } else {
                            objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda12
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return Float.valueOf(NavigationRailKt.NavigationRailItem$lambda$3$4$0(stateAnimateFloatAsState));
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        Function0 function115 = (Function0) objRememberedValue3;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -474489292, "CC(remember):NavigationRail.kt#9igjgp");
                        zChanged4 = composerStartRestartGroup.changed(stateAnimateFloatAsState2);
                        objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged4) {
                            objRememberedValue4 = new Function0() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda13
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return Float.valueOf(NavigationRailKt.NavigationRailItem$lambda$3$5$0(stateAnimateFloatAsState2));
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        } else {
                            objRememberedValue4 = new Function0() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda13
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return Float.valueOf(NavigationRailKt.NavigationRailItem$lambda$3$5$0(stateAnimateFloatAsState2));
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        NavigationRailItemLayout(composableLambdaRememberComposableLambda1115, composableLambdaRememberComposableLambda1116, composableLambdaRememberComposableLambda1113, composableLambda, z1115, function115, (Function0) objRememberedValue4, composerStartRestartGroup, (57344 & (i12 >> 6)) | 438);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        navigationRailItemColors2 = navigationRailItemColors112;
                        composer2 = composerStartRestartGroup;
                        z6 = z1115;
                        z7 = z1117;
                        mutableInteractionSource2 = mutableInteractionSource3;
                        modifier2 = modifier12;
                        function5 = function7;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        z6 = z3;
                        mutableInteractionSource2 = mutableInteractionSource;
                        z7 = z4;
                        composer2 = composerStartRestartGroup;
                        function5 = function4;
                        navigationRailItemColors2 = navigationRailItemColors;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda14
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return NavigationRailKt.NavigationRailItem$lambda$4(z, function0, function2, modifier2, z7, function5, z6, navigationRailItemColors2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= 100663296;
                if ((i3 & 38347923) != 38347922) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z5, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "210@9536L8");
                    if ((i & 1) != 0) {
                        if (i13 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            z4 = true;
                        }
                        if (i6 != 0) {
                            function4 = null;
                        }
                        if (i8 != 0) {
                            z8 = true;
                        } else {
                            z8 = z3;
                        }
                        if ((i2 & 128) != 0) {
                            navigationRailItemColorsColors = NavigationRailItemDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            navigationRailItemColorsColors = navigationRailItemColors;
                        }
                        i12 = i3;
                        navigationRailItemColors3 = navigationRailItemColorsColors;
                        modifier3 = modifier2;
                        z9 = z4;
                        function6 = function4;
                        if (i10 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        z10 = z8;
                    } else {
                        if (i13 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            z4 = true;
                        }
                        if (i6 != 0) {
                            function4 = null;
                        }
                        if (i8 != 0) {
                            z8 = true;
                        } else {
                            z8 = z3;
                        }
                        if ((i2 & 128) != 0) {
                            navigationRailItemColorsColors = NavigationRailItemDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            navigationRailItemColorsColors = navigationRailItemColors;
                        }
                        i12 = i3;
                        navigationRailItemColors3 = navigationRailItemColorsColors;
                        modifier3 = modifier2;
                        z9 = z4;
                        function6 = function4;
                        if (i10 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        z10 = z8;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1620317701, i12, -1, "androidx.compose.material3.NavigationRailItem (NavigationRail.kt:212)");
                    }
                    if (mutableInteractionSource3 == null) {
                        composerStartRestartGroup.startReplaceGroup(253276704);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "214@9688L39");
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1947832866, "CC(remember):NavigationRail.kt#9igjgp");
                        objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue5 = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.endReplaceGroup();
                        mutableInteractionSource4 = (MutableInteractionSource) objRememberedValue5;
                    } else {
                        composerStartRestartGroup.startReplaceGroup(1947832215);
                        composerStartRestartGroup.endReplaceGroup();
                        mutableInteractionSource4 = mutableInteractionSource3;
                    }
                    finiteAnimationSpecValue = MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultEffects, composerStartRestartGroup, 6);
                    boolean z1118 = z10;
                    ComposableLambda composableLambdaRememberComposableLambda1117 = ComposableLambdaKt.rememberComposableLambda(206057749, true, new Function2() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return NavigationRailKt.NavigationRailItem$lambda$1(navigationRailItemColors3, z, z9, finiteAnimationSpecValue, function6, z10, function2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54);
                    if (function6 == null) {
                        composerStartRestartGroup.startReplaceGroup(254203944);
                        composerStartRestartGroup.endReplaceGroup();
                        navigationRailItemColors4 = navigationRailItemColors3;
                        function7 = function6;
                        r7 = 1;
                        composableLambda = null;
                    } else {
                        composerStartRestartGroup.startReplaceGroup(254203945);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "*233@10636L534");
                        final NavigationRailItemColors navigationRailItemColors113 = navigationRailItemColors3;
                        final boolean z1119 = z9;
                        final Function2 function116 = function6;
                        navigationRailItemColors4 = navigationRailItemColors113;
                        function7 = function116;
                        r7 = 1;
                        ComposableLambda composableLambdaRememberComposableLambda1118 = ComposableLambdaKt.rememberComposableLambda(-2056532825, true, new Function2() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda8
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return NavigationRailKt.NavigationRailItem$lambda$2$0(navigationRailItemColors113, z, z1119, finiteAnimationSpecValue, function116, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                        composerStartRestartGroup.endReplaceGroup();
                        composableLambda = composableLambdaRememberComposableLambda1118;
                    }
                    boolean z11110 = z9;
                    Modifier modifier13 = modifier3;
                    mutableInteractionSource5 = mutableInteractionSource4;
                    Modifier modifierM1273widthInVpY3zN4$default10 = SizeKt.m1273widthInVpY3zN4$default(SizeKt.m1251defaultMinSizeVpY3zN4$default(SelectableKt.m1533selectableO2vRcR0(modifier13, z, mutableInteractionSource5, null, z11110, Role.m8825boximpl(Role.INSTANCE.m8839getTabo7Vup1c()), function0), 0.0f, NavigationRailItemHeight, r7, null), NavigationRailItemWidth, 0.0f, 2, null);
                    Alignment center10 = Alignment.INSTANCE.getCenter();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy10 = BoxKt.maybeCachedBoxMeasurePolicy(center10, r7);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap10 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier10 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1273widthInVpY3zN4$default10);
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
                    BoxScopeInstance boxScopeInstance10 = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1826936439, "C267@11982L7,264@11752L252,273@12294L7,270@12067L249,279@12577L7,280@12620L315,289@12986L146,303@13569L237,311@13855L285,325@14406L32,326@14476L31,319@14150L368:NavigationRail.kt#uh7d8r");
                    if (z) {
                        f = 1.0f;
                    } else {
                        f = 0.0f;
                    }
                    final NavigationRailItemColors navigationRailItemColors114 = navigationRailItemColors4;
                    stateAnimateFloatAsState = AnimateAsStateKt.animateFloatAsState(f, MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultEffects, composerStartRestartGroup, 6), 0.0f, null, null, composerStartRestartGroup, 0, 28);
                    if (z) {
                        f2 = 1.0f;
                    } else {
                        f2 = 0.0f;
                    }
                    stateAnimateFloatAsState2 = AnimateAsStateKt.animateFloatAsState(f2, MotionSchemeKt.value(MotionSchemeKeyTokens.FastSpatial, composerStartRestartGroup, 6), 0.0f, null, null, composerStartRestartGroup, 0, 28);
                    ProvidableCompositionLocal<Density> localDensity10 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume10 = composerStartRestartGroup.consume(localDensity10);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    density = (Density) objConsume10;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -474548400, "CC(remember):NavigationRail.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(density);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue = new Function0() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda9
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return NavigationRailKt.NavigationRailItem$lambda$3$0$0(density);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new Function0() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda9
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return NavigationRailKt.NavigationRailItem$lambda$3$0$0(density);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    function1 = (Function0) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -474536857, "CC(remember):NavigationRail.kt#9igjgp");
                    zChanged2 = composerStartRestartGroup.changed(mutableInteractionSource5) | composerStartRestartGroup.changed(function1);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged2) {
                        objRememberedValue2 = new MappedInteractionSource(mutableInteractionSource5, function1);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new MappedInteractionSource(mutableInteractionSource5, function1);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    final MappedInteractionSource mappedInteractionSource10 = (MappedInteractionSource) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (function7 != null) {
                        composerStartRestartGroup.startReplaceGroup(-1825536046);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "295@13266L5");
                        value = ShapesKt.getValue(NavigationRailBaselineItemTokens.INSTANCE.getActiveIndicatorShape(), composerStartRestartGroup, 6);
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-1825440690);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "297@13335L5");
                        value = ShapesKt.getValue(ShapeKeyTokens.CornerFull, composerStartRestartGroup, 6);
                        composerStartRestartGroup.endReplaceGroup();
                    }
                    ComposableLambda composableLambdaRememberComposableLambda1119 = ComposableLambdaKt.rememberComposableLambda(455696046, true, new Function2() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda10
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return NavigationRailKt.NavigationRailItem$lambda$3$2(value, mappedInteractionSource10, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54);
                    ComposableLambda composableLambdaRememberComposableLambda11110 = ComposableLambdaKt.rememberComposableLambda(2137606782, true, new Function2() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda11
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return NavigationRailKt.NavigationRailItem$lambda$3$3(stateAnimateFloatAsState, navigationRailItemColors114, value, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -474491531, "CC(remember):NavigationRail.kt#9igjgp");
                    zChanged3 = composerStartRestartGroup.changed(stateAnimateFloatAsState);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged3) {
                        objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda12
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Float.valueOf(NavigationRailKt.NavigationRailItem$lambda$3$4$0(stateAnimateFloatAsState));
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda12
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Float.valueOf(NavigationRailKt.NavigationRailItem$lambda$3$4$0(stateAnimateFloatAsState));
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    Function0 function117 = (Function0) objRememberedValue3;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -474489292, "CC(remember):NavigationRail.kt#9igjgp");
                    zChanged4 = composerStartRestartGroup.changed(stateAnimateFloatAsState2);
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged4) {
                        objRememberedValue4 = new Function0() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda13
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Float.valueOf(NavigationRailKt.NavigationRailItem$lambda$3$5$0(stateAnimateFloatAsState2));
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    } else {
                        objRememberedValue4 = new Function0() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda13
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Float.valueOf(NavigationRailKt.NavigationRailItem$lambda$3$5$0(stateAnimateFloatAsState2));
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    NavigationRailItemLayout(composableLambdaRememberComposableLambda1119, composableLambdaRememberComposableLambda11110, composableLambdaRememberComposableLambda1117, composableLambda, z1118, function117, (Function0) objRememberedValue4, composerStartRestartGroup, (57344 & (i12 >> 6)) | 438);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    navigationRailItemColors2 = navigationRailItemColors114;
                    composer2 = composerStartRestartGroup;
                    z6 = z1118;
                    z7 = z11110;
                    mutableInteractionSource2 = mutableInteractionSource3;
                    modifier2 = modifier13;
                    function5 = function7;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    z6 = z3;
                    mutableInteractionSource2 = mutableInteractionSource;
                    z7 = z4;
                    composer2 = composerStartRestartGroup;
                    function5 = function4;
                    navigationRailItemColors2 = navigationRailItemColors;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda14
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return NavigationRailKt.NavigationRailItem$lambda$4(z, function0, function2, modifier2, z7, function5, z6, navigationRailItemColors2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            function4 = function3;
            i8 = i2 & 64;
            if (i8 != 0) {
                i3 |= 1572864;
            } else if ((i & 1572864) == 0) {
                if (composerStartRestartGroup.changed(z3)) {
                    i9 = 1048576;
                } else {
                    i9 = 524288;
                }
                i3 |= i9;
            }
            if ((i & 12582912) != 0) {
                i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(navigationRailItemColors)) ? 4194304 : 8388608;
            }
            i10 = i2 & 256;
            if (i10 != 0) {
                if ((i & 100663296) == 0) {
                    if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                        i11 = 67108864;
                    } else {
                        i11 = 33554432;
                    }
                    i3 |= i11;
                }
                if ((i3 & 38347923) != 38347922) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z5, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "210@9536L8");
                    if ((i & 1) != 0) {
                        if (i13 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            z4 = true;
                        }
                        if (i6 != 0) {
                            function4 = null;
                        }
                        if (i8 != 0) {
                            z8 = true;
                        } else {
                            z8 = z3;
                        }
                        if ((i2 & 128) != 0) {
                            navigationRailItemColorsColors = NavigationRailItemDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            navigationRailItemColorsColors = navigationRailItemColors;
                        }
                        i12 = i3;
                        navigationRailItemColors3 = navigationRailItemColorsColors;
                        modifier3 = modifier2;
                        z9 = z4;
                        function6 = function4;
                        if (i10 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        z10 = z8;
                    } else {
                        if (i13 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            z4 = true;
                        }
                        if (i6 != 0) {
                            function4 = null;
                        }
                        if (i8 != 0) {
                            z8 = true;
                        } else {
                            z8 = z3;
                        }
                        if ((i2 & 128) != 0) {
                            navigationRailItemColorsColors = NavigationRailItemDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            navigationRailItemColorsColors = navigationRailItemColors;
                        }
                        i12 = i3;
                        navigationRailItemColors3 = navigationRailItemColorsColors;
                        modifier3 = modifier2;
                        z9 = z4;
                        function6 = function4;
                        if (i10 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        z10 = z8;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1620317701, i12, -1, "androidx.compose.material3.NavigationRailItem (NavigationRail.kt:212)");
                    }
                    if (mutableInteractionSource3 == null) {
                        composerStartRestartGroup.startReplaceGroup(253276704);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "214@9688L39");
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1947832866, "CC(remember):NavigationRail.kt#9igjgp");
                        objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue5 = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.endReplaceGroup();
                        mutableInteractionSource4 = (MutableInteractionSource) objRememberedValue5;
                    } else {
                        composerStartRestartGroup.startReplaceGroup(1947832215);
                        composerStartRestartGroup.endReplaceGroup();
                        mutableInteractionSource4 = mutableInteractionSource3;
                    }
                    finiteAnimationSpecValue = MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultEffects, composerStartRestartGroup, 6);
                    boolean z11111 = z10;
                    ComposableLambda composableLambdaRememberComposableLambda11111 = ComposableLambdaKt.rememberComposableLambda(206057749, true, new Function2() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return NavigationRailKt.NavigationRailItem$lambda$1(navigationRailItemColors3, z, z9, finiteAnimationSpecValue, function6, z10, function2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54);
                    if (function6 == null) {
                        composerStartRestartGroup.startReplaceGroup(254203944);
                        composerStartRestartGroup.endReplaceGroup();
                        navigationRailItemColors4 = navigationRailItemColors3;
                        function7 = function6;
                        r7 = 1;
                        composableLambda = null;
                    } else {
                        composerStartRestartGroup.startReplaceGroup(254203945);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "*233@10636L534");
                        final NavigationRailItemColors navigationRailItemColors115 = navigationRailItemColors3;
                        final boolean z11112 = z9;
                        final Function2 function118 = function6;
                        navigationRailItemColors4 = navigationRailItemColors115;
                        function7 = function118;
                        r7 = 1;
                        ComposableLambda composableLambdaRememberComposableLambda11112 = ComposableLambdaKt.rememberComposableLambda(-2056532825, true, new Function2() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda8
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return NavigationRailKt.NavigationRailItem$lambda$2$0(navigationRailItemColors115, z, z11112, finiteAnimationSpecValue, function118, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                        composerStartRestartGroup.endReplaceGroup();
                        composableLambda = composableLambdaRememberComposableLambda11112;
                    }
                    boolean z11113 = z9;
                    Modifier modifier14 = modifier3;
                    mutableInteractionSource5 = mutableInteractionSource4;
                    Modifier modifierM1273widthInVpY3zN4$default11 = SizeKt.m1273widthInVpY3zN4$default(SizeKt.m1251defaultMinSizeVpY3zN4$default(SelectableKt.m1533selectableO2vRcR0(modifier14, z, mutableInteractionSource5, null, z11113, Role.m8825boximpl(Role.INSTANCE.m8839getTabo7Vup1c()), function0), 0.0f, NavigationRailItemHeight, r7, null), NavigationRailItemWidth, 0.0f, 2, null);
                    Alignment center11 = Alignment.INSTANCE.getCenter();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy11 = BoxKt.maybeCachedBoxMeasurePolicy(center11, r7);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap11 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier11 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1273widthInVpY3zN4$default11);
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
                    Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap11, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (!composerM6062constructorimpl.getInserting()) {
                        composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    } else {
                        composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier11, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance11 = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1826936439, "C267@11982L7,264@11752L252,273@12294L7,270@12067L249,279@12577L7,280@12620L315,289@12986L146,303@13569L237,311@13855L285,325@14406L32,326@14476L31,319@14150L368:NavigationRail.kt#uh7d8r");
                    if (z) {
                        f = 1.0f;
                    } else {
                        f = 0.0f;
                    }
                    final NavigationRailItemColors navigationRailItemColors116 = navigationRailItemColors4;
                    stateAnimateFloatAsState = AnimateAsStateKt.animateFloatAsState(f, MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultEffects, composerStartRestartGroup, 6), 0.0f, null, null, composerStartRestartGroup, 0, 28);
                    if (z) {
                        f2 = 1.0f;
                    } else {
                        f2 = 0.0f;
                    }
                    stateAnimateFloatAsState2 = AnimateAsStateKt.animateFloatAsState(f2, MotionSchemeKt.value(MotionSchemeKeyTokens.FastSpatial, composerStartRestartGroup, 6), 0.0f, null, null, composerStartRestartGroup, 0, 28);
                    ProvidableCompositionLocal<Density> localDensity11 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume11 = composerStartRestartGroup.consume(localDensity11);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    density = (Density) objConsume11;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -474548400, "CC(remember):NavigationRail.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(density);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue = new Function0() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda9
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return NavigationRailKt.NavigationRailItem$lambda$3$0$0(density);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new Function0() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda9
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return NavigationRailKt.NavigationRailItem$lambda$3$0$0(density);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    function1 = (Function0) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -474536857, "CC(remember):NavigationRail.kt#9igjgp");
                    zChanged2 = composerStartRestartGroup.changed(mutableInteractionSource5) | composerStartRestartGroup.changed(function1);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged2) {
                        objRememberedValue2 = new MappedInteractionSource(mutableInteractionSource5, function1);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new MappedInteractionSource(mutableInteractionSource5, function1);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    final MappedInteractionSource mappedInteractionSource11 = (MappedInteractionSource) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (function7 != null) {
                        composerStartRestartGroup.startReplaceGroup(-1825536046);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "295@13266L5");
                        value = ShapesKt.getValue(NavigationRailBaselineItemTokens.INSTANCE.getActiveIndicatorShape(), composerStartRestartGroup, 6);
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-1825440690);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "297@13335L5");
                        value = ShapesKt.getValue(ShapeKeyTokens.CornerFull, composerStartRestartGroup, 6);
                        composerStartRestartGroup.endReplaceGroup();
                    }
                    ComposableLambda composableLambdaRememberComposableLambda11113 = ComposableLambdaKt.rememberComposableLambda(455696046, true, new Function2() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda10
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return NavigationRailKt.NavigationRailItem$lambda$3$2(value, mappedInteractionSource11, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54);
                    ComposableLambda composableLambdaRememberComposableLambda11114 = ComposableLambdaKt.rememberComposableLambda(2137606782, true, new Function2() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda11
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return NavigationRailKt.NavigationRailItem$lambda$3$3(stateAnimateFloatAsState, navigationRailItemColors116, value, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -474491531, "CC(remember):NavigationRail.kt#9igjgp");
                    zChanged3 = composerStartRestartGroup.changed(stateAnimateFloatAsState);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged3) {
                        objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda12
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Float.valueOf(NavigationRailKt.NavigationRailItem$lambda$3$4$0(stateAnimateFloatAsState));
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda12
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Float.valueOf(NavigationRailKt.NavigationRailItem$lambda$3$4$0(stateAnimateFloatAsState));
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    Function0 function119 = (Function0) objRememberedValue3;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -474489292, "CC(remember):NavigationRail.kt#9igjgp");
                    zChanged4 = composerStartRestartGroup.changed(stateAnimateFloatAsState2);
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged4) {
                        objRememberedValue4 = new Function0() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda13
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Float.valueOf(NavigationRailKt.NavigationRailItem$lambda$3$5$0(stateAnimateFloatAsState2));
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    } else {
                        objRememberedValue4 = new Function0() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda13
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Float.valueOf(NavigationRailKt.NavigationRailItem$lambda$3$5$0(stateAnimateFloatAsState2));
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    NavigationRailItemLayout(composableLambdaRememberComposableLambda11113, composableLambdaRememberComposableLambda11114, composableLambdaRememberComposableLambda11111, composableLambda, z11111, function119, (Function0) objRememberedValue4, composerStartRestartGroup, (57344 & (i12 >> 6)) | 438);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    navigationRailItemColors2 = navigationRailItemColors116;
                    composer2 = composerStartRestartGroup;
                    z6 = z11111;
                    z7 = z11113;
                    mutableInteractionSource2 = mutableInteractionSource3;
                    modifier2 = modifier14;
                    function5 = function7;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    z6 = z3;
                    mutableInteractionSource2 = mutableInteractionSource;
                    z7 = z4;
                    composer2 = composerStartRestartGroup;
                    function5 = function4;
                    navigationRailItemColors2 = navigationRailItemColors;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda14
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return NavigationRailKt.NavigationRailItem$lambda$4(z, function0, function2, modifier2, z7, function5, z6, navigationRailItemColors2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 100663296;
            if ((i3 & 38347923) != 38347922) {
                z5 = true;
            } else {
                z5 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z5, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "210@9536L8");
                if ((i & 1) != 0) {
                    if (i13 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        z4 = true;
                    }
                    if (i6 != 0) {
                        function4 = null;
                    }
                    if (i8 != 0) {
                        z8 = true;
                    } else {
                        z8 = z3;
                    }
                    if ((i2 & 128) != 0) {
                        navigationRailItemColorsColors = NavigationRailItemDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                        i3 &= -29360129;
                    } else {
                        navigationRailItemColorsColors = navigationRailItemColors;
                    }
                    i12 = i3;
                    navigationRailItemColors3 = navigationRailItemColorsColors;
                    modifier3 = modifier2;
                    z9 = z4;
                    function6 = function4;
                    if (i10 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    z10 = z8;
                } else {
                    if (i13 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        z4 = true;
                    }
                    if (i6 != 0) {
                        function4 = null;
                    }
                    if (i8 != 0) {
                        z8 = true;
                    } else {
                        z8 = z3;
                    }
                    if ((i2 & 128) != 0) {
                        navigationRailItemColorsColors = NavigationRailItemDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                        i3 &= -29360129;
                    } else {
                        navigationRailItemColorsColors = navigationRailItemColors;
                    }
                    i12 = i3;
                    navigationRailItemColors3 = navigationRailItemColorsColors;
                    modifier3 = modifier2;
                    z9 = z4;
                    function6 = function4;
                    if (i10 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    z10 = z8;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1620317701, i12, -1, "androidx.compose.material3.NavigationRailItem (NavigationRail.kt:212)");
                }
                if (mutableInteractionSource3 == null) {
                    composerStartRestartGroup.startReplaceGroup(253276704);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "214@9688L39");
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1947832866, "CC(remember):NavigationRail.kt#9igjgp");
                    objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue5 = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endReplaceGroup();
                    mutableInteractionSource4 = (MutableInteractionSource) objRememberedValue5;
                } else {
                    composerStartRestartGroup.startReplaceGroup(1947832215);
                    composerStartRestartGroup.endReplaceGroup();
                    mutableInteractionSource4 = mutableInteractionSource3;
                }
                finiteAnimationSpecValue = MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultEffects, composerStartRestartGroup, 6);
                boolean z11114 = z10;
                ComposableLambda composableLambdaRememberComposableLambda11115 = ComposableLambdaKt.rememberComposableLambda(206057749, true, new Function2() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return NavigationRailKt.NavigationRailItem$lambda$1(navigationRailItemColors3, z, z9, finiteAnimationSpecValue, function6, z10, function2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54);
                if (function6 == null) {
                    composerStartRestartGroup.startReplaceGroup(254203944);
                    composerStartRestartGroup.endReplaceGroup();
                    navigationRailItemColors4 = navigationRailItemColors3;
                    function7 = function6;
                    r7 = 1;
                    composableLambda = null;
                } else {
                    composerStartRestartGroup.startReplaceGroup(254203945);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "*233@10636L534");
                    final NavigationRailItemColors navigationRailItemColors117 = navigationRailItemColors3;
                    final boolean z11115 = z9;
                    final Function2 function1110 = function6;
                    navigationRailItemColors4 = navigationRailItemColors117;
                    function7 = function1110;
                    r7 = 1;
                    ComposableLambda composableLambdaRememberComposableLambda11116 = ComposableLambdaKt.rememberComposableLambda(-2056532825, true, new Function2() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda8
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return NavigationRailKt.NavigationRailItem$lambda$2$0(navigationRailItemColors117, z, z11115, finiteAnimationSpecValue, function1110, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54);
                    composerStartRestartGroup.endReplaceGroup();
                    composableLambda = composableLambdaRememberComposableLambda11116;
                }
                boolean z11116 = z9;
                Modifier modifier15 = modifier3;
                mutableInteractionSource5 = mutableInteractionSource4;
                Modifier modifierM1273widthInVpY3zN4$default12 = SizeKt.m1273widthInVpY3zN4$default(SizeKt.m1251defaultMinSizeVpY3zN4$default(SelectableKt.m1533selectableO2vRcR0(modifier15, z, mutableInteractionSource5, null, z11116, Role.m8825boximpl(Role.INSTANCE.m8839getTabo7Vup1c()), function0), 0.0f, NavigationRailItemHeight, r7, null), NavigationRailItemWidth, 0.0f, 2, null);
                Alignment center12 = Alignment.INSTANCE.getCenter();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy12 = BoxKt.maybeCachedBoxMeasurePolicy(center12, r7);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap12 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier12 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1273widthInVpY3zN4$default12);
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
                Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy12, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap12, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!composerM6062constructorimpl.getInserting()) {
                    composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                } else {
                    composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier12, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance12 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1826936439, "C267@11982L7,264@11752L252,273@12294L7,270@12067L249,279@12577L7,280@12620L315,289@12986L146,303@13569L237,311@13855L285,325@14406L32,326@14476L31,319@14150L368:NavigationRail.kt#uh7d8r");
                if (z) {
                    f = 1.0f;
                } else {
                    f = 0.0f;
                }
                final NavigationRailItemColors navigationRailItemColors118 = navigationRailItemColors4;
                stateAnimateFloatAsState = AnimateAsStateKt.animateFloatAsState(f, MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultEffects, composerStartRestartGroup, 6), 0.0f, null, null, composerStartRestartGroup, 0, 28);
                if (z) {
                    f2 = 1.0f;
                } else {
                    f2 = 0.0f;
                }
                stateAnimateFloatAsState2 = AnimateAsStateKt.animateFloatAsState(f2, MotionSchemeKt.value(MotionSchemeKeyTokens.FastSpatial, composerStartRestartGroup, 6), 0.0f, null, null, composerStartRestartGroup, 0, 28);
                ProvidableCompositionLocal<Density> localDensity12 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume12 = composerStartRestartGroup.consume(localDensity12);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                density = (Density) objConsume12;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -474548400, "CC(remember):NavigationRail.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(density);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue = new Function0() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda9
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return NavigationRailKt.NavigationRailItem$lambda$3$0$0(density);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new Function0() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda9
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return NavigationRailKt.NavigationRailItem$lambda$3$0$0(density);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                function1 = (Function0) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -474536857, "CC(remember):NavigationRail.kt#9igjgp");
                zChanged2 = composerStartRestartGroup.changed(mutableInteractionSource5) | composerStartRestartGroup.changed(function1);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!zChanged2) {
                    objRememberedValue2 = new MappedInteractionSource(mutableInteractionSource5, function1);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = new MappedInteractionSource(mutableInteractionSource5, function1);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                final MappedInteractionSource mappedInteractionSource12 = (MappedInteractionSource) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (function7 != null) {
                    composerStartRestartGroup.startReplaceGroup(-1825536046);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "295@13266L5");
                    value = ShapesKt.getValue(NavigationRailBaselineItemTokens.INSTANCE.getActiveIndicatorShape(), composerStartRestartGroup, 6);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(-1825440690);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "297@13335L5");
                    value = ShapesKt.getValue(ShapeKeyTokens.CornerFull, composerStartRestartGroup, 6);
                    composerStartRestartGroup.endReplaceGroup();
                }
                ComposableLambda composableLambdaRememberComposableLambda11117 = ComposableLambdaKt.rememberComposableLambda(455696046, true, new Function2() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda10
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return NavigationRailKt.NavigationRailItem$lambda$3$2(value, mappedInteractionSource12, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54);
                ComposableLambda composableLambdaRememberComposableLambda11118 = ComposableLambdaKt.rememberComposableLambda(2137606782, true, new Function2() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda11
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return NavigationRailKt.NavigationRailItem$lambda$3$3(stateAnimateFloatAsState, navigationRailItemColors118, value, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -474491531, "CC(remember):NavigationRail.kt#9igjgp");
                zChanged3 = composerStartRestartGroup.changed(stateAnimateFloatAsState);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (!zChanged3) {
                    objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda12
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return Float.valueOf(NavigationRailKt.NavigationRailItem$lambda$3$4$0(stateAnimateFloatAsState));
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda12
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return Float.valueOf(NavigationRailKt.NavigationRailItem$lambda$3$4$0(stateAnimateFloatAsState));
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                Function0 function1111 = (Function0) objRememberedValue3;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -474489292, "CC(remember):NavigationRail.kt#9igjgp");
                zChanged4 = composerStartRestartGroup.changed(stateAnimateFloatAsState2);
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (!zChanged4) {
                    objRememberedValue4 = new Function0() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda13
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return Float.valueOf(NavigationRailKt.NavigationRailItem$lambda$3$5$0(stateAnimateFloatAsState2));
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                } else {
                    objRememberedValue4 = new Function0() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda13
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return Float.valueOf(NavigationRailKt.NavigationRailItem$lambda$3$5$0(stateAnimateFloatAsState2));
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                NavigationRailItemLayout(composableLambdaRememberComposableLambda11117, composableLambdaRememberComposableLambda11118, composableLambdaRememberComposableLambda11115, composableLambda, z11114, function1111, (Function0) objRememberedValue4, composerStartRestartGroup, (57344 & (i12 >> 6)) | 438);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                navigationRailItemColors2 = navigationRailItemColors118;
                composer2 = composerStartRestartGroup;
                z6 = z11114;
                z7 = z11116;
                mutableInteractionSource2 = mutableInteractionSource3;
                modifier2 = modifier15;
                function5 = function7;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                z6 = z3;
                mutableInteractionSource2 = mutableInteractionSource;
                z7 = z4;
                composer2 = composerStartRestartGroup;
                function5 = function4;
                navigationRailItemColors2 = navigationRailItemColors;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda14
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return NavigationRailKt.NavigationRailItem$lambda$4(z, function0, function2, modifier2, z7, function5, z6, navigationRailItemColors2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 24576;
        z4 = z2;
        i6 = i2 & 32;
        if (i6 != 0) {
            if ((196608 & i) == 0) {
                function4 = function3;
                if (composerStartRestartGroup.changedInstance(function4)) {
                    i7 = 131072;
                } else {
                    i7 = 65536;
                }
                i3 |= i7;
            }
            i8 = i2 & 64;
            if (i8 != 0) {
                i3 |= 1572864;
            } else if ((i & 1572864) == 0) {
                if (composerStartRestartGroup.changed(z3)) {
                    i9 = 1048576;
                } else {
                    i9 = 524288;
                }
                i3 |= i9;
            }
            if ((i & 12582912) != 0) {
                i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(navigationRailItemColors)) ? 4194304 : 8388608;
            }
            i10 = i2 & 256;
            if (i10 != 0) {
                if ((i & 100663296) == 0) {
                    if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                        i11 = 67108864;
                    } else {
                        i11 = 33554432;
                    }
                    i3 |= i11;
                }
                if ((i3 & 38347923) != 38347922) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z5, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "210@9536L8");
                    if ((i & 1) != 0) {
                        if (i13 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            z4 = true;
                        }
                        if (i6 != 0) {
                            function4 = null;
                        }
                        if (i8 != 0) {
                            z8 = true;
                        } else {
                            z8 = z3;
                        }
                        if ((i2 & 128) != 0) {
                            navigationRailItemColorsColors = NavigationRailItemDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            navigationRailItemColorsColors = navigationRailItemColors;
                        }
                        i12 = i3;
                        navigationRailItemColors3 = navigationRailItemColorsColors;
                        modifier3 = modifier2;
                        z9 = z4;
                        function6 = function4;
                        if (i10 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        z10 = z8;
                    } else {
                        if (i13 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            z4 = true;
                        }
                        if (i6 != 0) {
                            function4 = null;
                        }
                        if (i8 != 0) {
                            z8 = true;
                        } else {
                            z8 = z3;
                        }
                        if ((i2 & 128) != 0) {
                            navigationRailItemColorsColors = NavigationRailItemDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                            i3 &= -29360129;
                        } else {
                            navigationRailItemColorsColors = navigationRailItemColors;
                        }
                        i12 = i3;
                        navigationRailItemColors3 = navigationRailItemColorsColors;
                        modifier3 = modifier2;
                        z9 = z4;
                        function6 = function4;
                        if (i10 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        z10 = z8;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1620317701, i12, -1, "androidx.compose.material3.NavigationRailItem (NavigationRail.kt:212)");
                    }
                    if (mutableInteractionSource3 == null) {
                        composerStartRestartGroup.startReplaceGroup(253276704);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "214@9688L39");
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1947832866, "CC(remember):NavigationRail.kt#9igjgp");
                        objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue5 = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.endReplaceGroup();
                        mutableInteractionSource4 = (MutableInteractionSource) objRememberedValue5;
                    } else {
                        composerStartRestartGroup.startReplaceGroup(1947832215);
                        composerStartRestartGroup.endReplaceGroup();
                        mutableInteractionSource4 = mutableInteractionSource3;
                    }
                    finiteAnimationSpecValue = MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultEffects, composerStartRestartGroup, 6);
                    boolean z11117 = z10;
                    ComposableLambda composableLambdaRememberComposableLambda11119 = ComposableLambdaKt.rememberComposableLambda(206057749, true, new Function2() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return NavigationRailKt.NavigationRailItem$lambda$1(navigationRailItemColors3, z, z9, finiteAnimationSpecValue, function6, z10, function2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54);
                    if (function6 == null) {
                        composerStartRestartGroup.startReplaceGroup(254203944);
                        composerStartRestartGroup.endReplaceGroup();
                        navigationRailItemColors4 = navigationRailItemColors3;
                        function7 = function6;
                        r7 = 1;
                        composableLambda = null;
                    } else {
                        composerStartRestartGroup.startReplaceGroup(254203945);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "*233@10636L534");
                        final NavigationRailItemColors navigationRailItemColors119 = navigationRailItemColors3;
                        final boolean z11118 = z9;
                        final Function2 function1112 = function6;
                        navigationRailItemColors4 = navigationRailItemColors119;
                        function7 = function1112;
                        r7 = 1;
                        ComposableLambda composableLambdaRememberComposableLambda111110 = ComposableLambdaKt.rememberComposableLambda(-2056532825, true, new Function2() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda8
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return NavigationRailKt.NavigationRailItem$lambda$2$0(navigationRailItemColors119, z, z11118, finiteAnimationSpecValue, function1112, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                        composerStartRestartGroup.endReplaceGroup();
                        composableLambda = composableLambdaRememberComposableLambda111110;
                    }
                    boolean z11119 = z9;
                    Modifier modifier16 = modifier3;
                    mutableInteractionSource5 = mutableInteractionSource4;
                    Modifier modifierM1273widthInVpY3zN4$default13 = SizeKt.m1273widthInVpY3zN4$default(SizeKt.m1251defaultMinSizeVpY3zN4$default(SelectableKt.m1533selectableO2vRcR0(modifier16, z, mutableInteractionSource5, null, z11119, Role.m8825boximpl(Role.INSTANCE.m8839getTabo7Vup1c()), function0), 0.0f, NavigationRailItemHeight, r7, null), NavigationRailItemWidth, 0.0f, 2, null);
                    Alignment center13 = Alignment.INSTANCE.getCenter();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy13 = BoxKt.maybeCachedBoxMeasurePolicy(center13, r7);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap13 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier13 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1273widthInVpY3zN4$default13);
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
                    BoxScopeInstance boxScopeInstance13 = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1826936439, "C267@11982L7,264@11752L252,273@12294L7,270@12067L249,279@12577L7,280@12620L315,289@12986L146,303@13569L237,311@13855L285,325@14406L32,326@14476L31,319@14150L368:NavigationRail.kt#uh7d8r");
                    if (z) {
                        f = 1.0f;
                    } else {
                        f = 0.0f;
                    }
                    final NavigationRailItemColors navigationRailItemColors1110 = navigationRailItemColors4;
                    stateAnimateFloatAsState = AnimateAsStateKt.animateFloatAsState(f, MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultEffects, composerStartRestartGroup, 6), 0.0f, null, null, composerStartRestartGroup, 0, 28);
                    if (z) {
                        f2 = 1.0f;
                    } else {
                        f2 = 0.0f;
                    }
                    stateAnimateFloatAsState2 = AnimateAsStateKt.animateFloatAsState(f2, MotionSchemeKt.value(MotionSchemeKeyTokens.FastSpatial, composerStartRestartGroup, 6), 0.0f, null, null, composerStartRestartGroup, 0, 28);
                    ProvidableCompositionLocal<Density> localDensity13 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume13 = composerStartRestartGroup.consume(localDensity13);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    density = (Density) objConsume13;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -474548400, "CC(remember):NavigationRail.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(density);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue = new Function0() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda9
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return NavigationRailKt.NavigationRailItem$lambda$3$0$0(density);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new Function0() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda9
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return NavigationRailKt.NavigationRailItem$lambda$3$0$0(density);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    function1 = (Function0) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -474536857, "CC(remember):NavigationRail.kt#9igjgp");
                    zChanged2 = composerStartRestartGroup.changed(mutableInteractionSource5) | composerStartRestartGroup.changed(function1);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged2) {
                        objRememberedValue2 = new MappedInteractionSource(mutableInteractionSource5, function1);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new MappedInteractionSource(mutableInteractionSource5, function1);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    final MappedInteractionSource mappedInteractionSource13 = (MappedInteractionSource) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (function7 != null) {
                        composerStartRestartGroup.startReplaceGroup(-1825536046);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "295@13266L5");
                        value = ShapesKt.getValue(NavigationRailBaselineItemTokens.INSTANCE.getActiveIndicatorShape(), composerStartRestartGroup, 6);
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-1825440690);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "297@13335L5");
                        value = ShapesKt.getValue(ShapeKeyTokens.CornerFull, composerStartRestartGroup, 6);
                        composerStartRestartGroup.endReplaceGroup();
                    }
                    ComposableLambda composableLambdaRememberComposableLambda111111 = ComposableLambdaKt.rememberComposableLambda(455696046, true, new Function2() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda10
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return NavigationRailKt.NavigationRailItem$lambda$3$2(value, mappedInteractionSource13, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54);
                    ComposableLambda composableLambdaRememberComposableLambda111112 = ComposableLambdaKt.rememberComposableLambda(2137606782, true, new Function2() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda11
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return NavigationRailKt.NavigationRailItem$lambda$3$3(stateAnimateFloatAsState, navigationRailItemColors1110, value, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -474491531, "CC(remember):NavigationRail.kt#9igjgp");
                    zChanged3 = composerStartRestartGroup.changed(stateAnimateFloatAsState);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged3) {
                        objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda12
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Float.valueOf(NavigationRailKt.NavigationRailItem$lambda$3$4$0(stateAnimateFloatAsState));
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda12
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Float.valueOf(NavigationRailKt.NavigationRailItem$lambda$3$4$0(stateAnimateFloatAsState));
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    Function0 function1113 = (Function0) objRememberedValue3;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -474489292, "CC(remember):NavigationRail.kt#9igjgp");
                    zChanged4 = composerStartRestartGroup.changed(stateAnimateFloatAsState2);
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged4) {
                        objRememberedValue4 = new Function0() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda13
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Float.valueOf(NavigationRailKt.NavigationRailItem$lambda$3$5$0(stateAnimateFloatAsState2));
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    } else {
                        objRememberedValue4 = new Function0() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda13
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Float.valueOf(NavigationRailKt.NavigationRailItem$lambda$3$5$0(stateAnimateFloatAsState2));
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    NavigationRailItemLayout(composableLambdaRememberComposableLambda111111, composableLambdaRememberComposableLambda111112, composableLambdaRememberComposableLambda11119, composableLambda, z11117, function1113, (Function0) objRememberedValue4, composerStartRestartGroup, (57344 & (i12 >> 6)) | 438);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    navigationRailItemColors2 = navigationRailItemColors1110;
                    composer2 = composerStartRestartGroup;
                    z6 = z11117;
                    z7 = z11119;
                    mutableInteractionSource2 = mutableInteractionSource3;
                    modifier2 = modifier16;
                    function5 = function7;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    z6 = z3;
                    mutableInteractionSource2 = mutableInteractionSource;
                    z7 = z4;
                    composer2 = composerStartRestartGroup;
                    function5 = function4;
                    navigationRailItemColors2 = navigationRailItemColors;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda14
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return NavigationRailKt.NavigationRailItem$lambda$4(z, function0, function2, modifier2, z7, function5, z6, navigationRailItemColors2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 100663296;
            if ((i3 & 38347923) != 38347922) {
                z5 = true;
            } else {
                z5 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z5, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "210@9536L8");
                if ((i & 1) != 0) {
                    if (i13 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        z4 = true;
                    }
                    if (i6 != 0) {
                        function4 = null;
                    }
                    if (i8 != 0) {
                        z8 = true;
                    } else {
                        z8 = z3;
                    }
                    if ((i2 & 128) != 0) {
                        navigationRailItemColorsColors = NavigationRailItemDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                        i3 &= -29360129;
                    } else {
                        navigationRailItemColorsColors = navigationRailItemColors;
                    }
                    i12 = i3;
                    navigationRailItemColors3 = navigationRailItemColorsColors;
                    modifier3 = modifier2;
                    z9 = z4;
                    function6 = function4;
                    if (i10 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    z10 = z8;
                } else {
                    if (i13 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        z4 = true;
                    }
                    if (i6 != 0) {
                        function4 = null;
                    }
                    if (i8 != 0) {
                        z8 = true;
                    } else {
                        z8 = z3;
                    }
                    if ((i2 & 128) != 0) {
                        navigationRailItemColorsColors = NavigationRailItemDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                        i3 &= -29360129;
                    } else {
                        navigationRailItemColorsColors = navigationRailItemColors;
                    }
                    i12 = i3;
                    navigationRailItemColors3 = navigationRailItemColorsColors;
                    modifier3 = modifier2;
                    z9 = z4;
                    function6 = function4;
                    if (i10 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    z10 = z8;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1620317701, i12, -1, "androidx.compose.material3.NavigationRailItem (NavigationRail.kt:212)");
                }
                if (mutableInteractionSource3 == null) {
                    composerStartRestartGroup.startReplaceGroup(253276704);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "214@9688L39");
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1947832866, "CC(remember):NavigationRail.kt#9igjgp");
                    objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue5 = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endReplaceGroup();
                    mutableInteractionSource4 = (MutableInteractionSource) objRememberedValue5;
                } else {
                    composerStartRestartGroup.startReplaceGroup(1947832215);
                    composerStartRestartGroup.endReplaceGroup();
                    mutableInteractionSource4 = mutableInteractionSource3;
                }
                finiteAnimationSpecValue = MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultEffects, composerStartRestartGroup, 6);
                boolean z111110 = z10;
                ComposableLambda composableLambdaRememberComposableLambda111113 = ComposableLambdaKt.rememberComposableLambda(206057749, true, new Function2() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return NavigationRailKt.NavigationRailItem$lambda$1(navigationRailItemColors3, z, z9, finiteAnimationSpecValue, function6, z10, function2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54);
                if (function6 == null) {
                    composerStartRestartGroup.startReplaceGroup(254203944);
                    composerStartRestartGroup.endReplaceGroup();
                    navigationRailItemColors4 = navigationRailItemColors3;
                    function7 = function6;
                    r7 = 1;
                    composableLambda = null;
                } else {
                    composerStartRestartGroup.startReplaceGroup(254203945);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "*233@10636L534");
                    final NavigationRailItemColors navigationRailItemColors1111 = navigationRailItemColors3;
                    final boolean z111111 = z9;
                    final Function2 function1114 = function6;
                    navigationRailItemColors4 = navigationRailItemColors1111;
                    function7 = function1114;
                    r7 = 1;
                    ComposableLambda composableLambdaRememberComposableLambda111114 = ComposableLambdaKt.rememberComposableLambda(-2056532825, true, new Function2() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda8
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return NavigationRailKt.NavigationRailItem$lambda$2$0(navigationRailItemColors1111, z, z111111, finiteAnimationSpecValue, function1114, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54);
                    composerStartRestartGroup.endReplaceGroup();
                    composableLambda = composableLambdaRememberComposableLambda111114;
                }
                boolean z111112 = z9;
                Modifier modifier17 = modifier3;
                mutableInteractionSource5 = mutableInteractionSource4;
                Modifier modifierM1273widthInVpY3zN4$default14 = SizeKt.m1273widthInVpY3zN4$default(SizeKt.m1251defaultMinSizeVpY3zN4$default(SelectableKt.m1533selectableO2vRcR0(modifier17, z, mutableInteractionSource5, null, z111112, Role.m8825boximpl(Role.INSTANCE.m8839getTabo7Vup1c()), function0), 0.0f, NavigationRailItemHeight, r7, null), NavigationRailItemWidth, 0.0f, 2, null);
                Alignment center14 = Alignment.INSTANCE.getCenter();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy14 = BoxKt.maybeCachedBoxMeasurePolicy(center14, r7);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap14 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier14 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1273widthInVpY3zN4$default14);
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
                Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy14, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap14, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!composerM6062constructorimpl.getInserting()) {
                    composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                } else {
                    composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier14, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance14 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1826936439, "C267@11982L7,264@11752L252,273@12294L7,270@12067L249,279@12577L7,280@12620L315,289@12986L146,303@13569L237,311@13855L285,325@14406L32,326@14476L31,319@14150L368:NavigationRail.kt#uh7d8r");
                if (z) {
                    f = 1.0f;
                } else {
                    f = 0.0f;
                }
                final NavigationRailItemColors navigationRailItemColors1112 = navigationRailItemColors4;
                stateAnimateFloatAsState = AnimateAsStateKt.animateFloatAsState(f, MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultEffects, composerStartRestartGroup, 6), 0.0f, null, null, composerStartRestartGroup, 0, 28);
                if (z) {
                    f2 = 1.0f;
                } else {
                    f2 = 0.0f;
                }
                stateAnimateFloatAsState2 = AnimateAsStateKt.animateFloatAsState(f2, MotionSchemeKt.value(MotionSchemeKeyTokens.FastSpatial, composerStartRestartGroup, 6), 0.0f, null, null, composerStartRestartGroup, 0, 28);
                ProvidableCompositionLocal<Density> localDensity14 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume14 = composerStartRestartGroup.consume(localDensity14);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                density = (Density) objConsume14;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -474548400, "CC(remember):NavigationRail.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(density);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue = new Function0() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda9
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return NavigationRailKt.NavigationRailItem$lambda$3$0$0(density);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new Function0() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda9
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return NavigationRailKt.NavigationRailItem$lambda$3$0$0(density);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                function1 = (Function0) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -474536857, "CC(remember):NavigationRail.kt#9igjgp");
                zChanged2 = composerStartRestartGroup.changed(mutableInteractionSource5) | composerStartRestartGroup.changed(function1);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!zChanged2) {
                    objRememberedValue2 = new MappedInteractionSource(mutableInteractionSource5, function1);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = new MappedInteractionSource(mutableInteractionSource5, function1);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                final MappedInteractionSource mappedInteractionSource14 = (MappedInteractionSource) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (function7 != null) {
                    composerStartRestartGroup.startReplaceGroup(-1825536046);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "295@13266L5");
                    value = ShapesKt.getValue(NavigationRailBaselineItemTokens.INSTANCE.getActiveIndicatorShape(), composerStartRestartGroup, 6);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(-1825440690);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "297@13335L5");
                    value = ShapesKt.getValue(ShapeKeyTokens.CornerFull, composerStartRestartGroup, 6);
                    composerStartRestartGroup.endReplaceGroup();
                }
                ComposableLambda composableLambdaRememberComposableLambda111115 = ComposableLambdaKt.rememberComposableLambda(455696046, true, new Function2() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda10
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return NavigationRailKt.NavigationRailItem$lambda$3$2(value, mappedInteractionSource14, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54);
                ComposableLambda composableLambdaRememberComposableLambda111116 = ComposableLambdaKt.rememberComposableLambda(2137606782, true, new Function2() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda11
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return NavigationRailKt.NavigationRailItem$lambda$3$3(stateAnimateFloatAsState, navigationRailItemColors1112, value, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -474491531, "CC(remember):NavigationRail.kt#9igjgp");
                zChanged3 = composerStartRestartGroup.changed(stateAnimateFloatAsState);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (!zChanged3) {
                    objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda12
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return Float.valueOf(NavigationRailKt.NavigationRailItem$lambda$3$4$0(stateAnimateFloatAsState));
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda12
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return Float.valueOf(NavigationRailKt.NavigationRailItem$lambda$3$4$0(stateAnimateFloatAsState));
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                Function0 function1115 = (Function0) objRememberedValue3;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -474489292, "CC(remember):NavigationRail.kt#9igjgp");
                zChanged4 = composerStartRestartGroup.changed(stateAnimateFloatAsState2);
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (!zChanged4) {
                    objRememberedValue4 = new Function0() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda13
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return Float.valueOf(NavigationRailKt.NavigationRailItem$lambda$3$5$0(stateAnimateFloatAsState2));
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                } else {
                    objRememberedValue4 = new Function0() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda13
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return Float.valueOf(NavigationRailKt.NavigationRailItem$lambda$3$5$0(stateAnimateFloatAsState2));
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                NavigationRailItemLayout(composableLambdaRememberComposableLambda111115, composableLambdaRememberComposableLambda111116, composableLambdaRememberComposableLambda111113, composableLambda, z111110, function1115, (Function0) objRememberedValue4, composerStartRestartGroup, (57344 & (i12 >> 6)) | 438);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                navigationRailItemColors2 = navigationRailItemColors1112;
                composer2 = composerStartRestartGroup;
                z6 = z111110;
                z7 = z111112;
                mutableInteractionSource2 = mutableInteractionSource3;
                modifier2 = modifier17;
                function5 = function7;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                z6 = z3;
                mutableInteractionSource2 = mutableInteractionSource;
                z7 = z4;
                composer2 = composerStartRestartGroup;
                function5 = function4;
                navigationRailItemColors2 = navigationRailItemColors;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda14
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return NavigationRailKt.NavigationRailItem$lambda$4(z, function0, function2, modifier2, z7, function5, z6, navigationRailItemColors2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        function4 = function3;
        i8 = i2 & 64;
        if (i8 != 0) {
            i3 |= 1572864;
        } else if ((i & 1572864) == 0) {
            if (composerStartRestartGroup.changed(z3)) {
                i9 = 1048576;
            } else {
                i9 = 524288;
            }
            i3 |= i9;
        }
        if ((i & 12582912) != 0) {
            i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(navigationRailItemColors)) ? 4194304 : 8388608;
        }
        i10 = i2 & 256;
        if (i10 != 0) {
            if ((i & 100663296) == 0) {
                if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                    i11 = 67108864;
                } else {
                    i11 = 33554432;
                }
                i3 |= i11;
            }
            if ((i3 & 38347923) != 38347922) {
                z5 = true;
            } else {
                z5 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z5, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "210@9536L8");
                if ((i & 1) != 0) {
                    if (i13 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        z4 = true;
                    }
                    if (i6 != 0) {
                        function4 = null;
                    }
                    if (i8 != 0) {
                        z8 = true;
                    } else {
                        z8 = z3;
                    }
                    if ((i2 & 128) != 0) {
                        navigationRailItemColorsColors = NavigationRailItemDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                        i3 &= -29360129;
                    } else {
                        navigationRailItemColorsColors = navigationRailItemColors;
                    }
                    i12 = i3;
                    navigationRailItemColors3 = navigationRailItemColorsColors;
                    modifier3 = modifier2;
                    z9 = z4;
                    function6 = function4;
                    if (i10 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    z10 = z8;
                } else {
                    if (i13 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        z4 = true;
                    }
                    if (i6 != 0) {
                        function4 = null;
                    }
                    if (i8 != 0) {
                        z8 = true;
                    } else {
                        z8 = z3;
                    }
                    if ((i2 & 128) != 0) {
                        navigationRailItemColorsColors = NavigationRailItemDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                        i3 &= -29360129;
                    } else {
                        navigationRailItemColorsColors = navigationRailItemColors;
                    }
                    i12 = i3;
                    navigationRailItemColors3 = navigationRailItemColorsColors;
                    modifier3 = modifier2;
                    z9 = z4;
                    function6 = function4;
                    if (i10 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    z10 = z8;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1620317701, i12, -1, "androidx.compose.material3.NavigationRailItem (NavigationRail.kt:212)");
                }
                if (mutableInteractionSource3 == null) {
                    composerStartRestartGroup.startReplaceGroup(253276704);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "214@9688L39");
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1947832866, "CC(remember):NavigationRail.kt#9igjgp");
                    objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue5 = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endReplaceGroup();
                    mutableInteractionSource4 = (MutableInteractionSource) objRememberedValue5;
                } else {
                    composerStartRestartGroup.startReplaceGroup(1947832215);
                    composerStartRestartGroup.endReplaceGroup();
                    mutableInteractionSource4 = mutableInteractionSource3;
                }
                finiteAnimationSpecValue = MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultEffects, composerStartRestartGroup, 6);
                boolean z111113 = z10;
                ComposableLambda composableLambdaRememberComposableLambda111117 = ComposableLambdaKt.rememberComposableLambda(206057749, true, new Function2() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return NavigationRailKt.NavigationRailItem$lambda$1(navigationRailItemColors3, z, z9, finiteAnimationSpecValue, function6, z10, function2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54);
                if (function6 == null) {
                    composerStartRestartGroup.startReplaceGroup(254203944);
                    composerStartRestartGroup.endReplaceGroup();
                    navigationRailItemColors4 = navigationRailItemColors3;
                    function7 = function6;
                    r7 = 1;
                    composableLambda = null;
                } else {
                    composerStartRestartGroup.startReplaceGroup(254203945);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "*233@10636L534");
                    final NavigationRailItemColors navigationRailItemColors1113 = navigationRailItemColors3;
                    final boolean z111114 = z9;
                    final Function2 function1116 = function6;
                    navigationRailItemColors4 = navigationRailItemColors1113;
                    function7 = function1116;
                    r7 = 1;
                    ComposableLambda composableLambdaRememberComposableLambda111118 = ComposableLambdaKt.rememberComposableLambda(-2056532825, true, new Function2() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda8
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return NavigationRailKt.NavigationRailItem$lambda$2$0(navigationRailItemColors1113, z, z111114, finiteAnimationSpecValue, function1116, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54);
                    composerStartRestartGroup.endReplaceGroup();
                    composableLambda = composableLambdaRememberComposableLambda111118;
                }
                boolean z111115 = z9;
                Modifier modifier18 = modifier3;
                mutableInteractionSource5 = mutableInteractionSource4;
                Modifier modifierM1273widthInVpY3zN4$default15 = SizeKt.m1273widthInVpY3zN4$default(SizeKt.m1251defaultMinSizeVpY3zN4$default(SelectableKt.m1533selectableO2vRcR0(modifier18, z, mutableInteractionSource5, null, z111115, Role.m8825boximpl(Role.INSTANCE.m8839getTabo7Vup1c()), function0), 0.0f, NavigationRailItemHeight, r7, null), NavigationRailItemWidth, 0.0f, 2, null);
                Alignment center15 = Alignment.INSTANCE.getCenter();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy15 = BoxKt.maybeCachedBoxMeasurePolicy(center15, r7);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap15 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier15 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1273widthInVpY3zN4$default15);
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
                Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap15, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!composerM6062constructorimpl.getInserting()) {
                    composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                } else {
                    composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier15, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance15 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1826936439, "C267@11982L7,264@11752L252,273@12294L7,270@12067L249,279@12577L7,280@12620L315,289@12986L146,303@13569L237,311@13855L285,325@14406L32,326@14476L31,319@14150L368:NavigationRail.kt#uh7d8r");
                if (z) {
                    f = 1.0f;
                } else {
                    f = 0.0f;
                }
                final NavigationRailItemColors navigationRailItemColors1114 = navigationRailItemColors4;
                stateAnimateFloatAsState = AnimateAsStateKt.animateFloatAsState(f, MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultEffects, composerStartRestartGroup, 6), 0.0f, null, null, composerStartRestartGroup, 0, 28);
                if (z) {
                    f2 = 1.0f;
                } else {
                    f2 = 0.0f;
                }
                stateAnimateFloatAsState2 = AnimateAsStateKt.animateFloatAsState(f2, MotionSchemeKt.value(MotionSchemeKeyTokens.FastSpatial, composerStartRestartGroup, 6), 0.0f, null, null, composerStartRestartGroup, 0, 28);
                ProvidableCompositionLocal<Density> localDensity15 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume15 = composerStartRestartGroup.consume(localDensity15);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                density = (Density) objConsume15;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -474548400, "CC(remember):NavigationRail.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(density);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue = new Function0() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda9
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return NavigationRailKt.NavigationRailItem$lambda$3$0$0(density);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new Function0() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda9
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return NavigationRailKt.NavigationRailItem$lambda$3$0$0(density);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                function1 = (Function0) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -474536857, "CC(remember):NavigationRail.kt#9igjgp");
                zChanged2 = composerStartRestartGroup.changed(mutableInteractionSource5) | composerStartRestartGroup.changed(function1);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!zChanged2) {
                    objRememberedValue2 = new MappedInteractionSource(mutableInteractionSource5, function1);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = new MappedInteractionSource(mutableInteractionSource5, function1);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                final MappedInteractionSource mappedInteractionSource15 = (MappedInteractionSource) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (function7 != null) {
                    composerStartRestartGroup.startReplaceGroup(-1825536046);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "295@13266L5");
                    value = ShapesKt.getValue(NavigationRailBaselineItemTokens.INSTANCE.getActiveIndicatorShape(), composerStartRestartGroup, 6);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(-1825440690);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "297@13335L5");
                    value = ShapesKt.getValue(ShapeKeyTokens.CornerFull, composerStartRestartGroup, 6);
                    composerStartRestartGroup.endReplaceGroup();
                }
                ComposableLambda composableLambdaRememberComposableLambda111119 = ComposableLambdaKt.rememberComposableLambda(455696046, true, new Function2() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda10
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return NavigationRailKt.NavigationRailItem$lambda$3$2(value, mappedInteractionSource15, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54);
                ComposableLambda composableLambdaRememberComposableLambda1111110 = ComposableLambdaKt.rememberComposableLambda(2137606782, true, new Function2() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda11
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return NavigationRailKt.NavigationRailItem$lambda$3$3(stateAnimateFloatAsState, navigationRailItemColors1114, value, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -474491531, "CC(remember):NavigationRail.kt#9igjgp");
                zChanged3 = composerStartRestartGroup.changed(stateAnimateFloatAsState);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (!zChanged3) {
                    objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda12
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return Float.valueOf(NavigationRailKt.NavigationRailItem$lambda$3$4$0(stateAnimateFloatAsState));
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda12
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return Float.valueOf(NavigationRailKt.NavigationRailItem$lambda$3$4$0(stateAnimateFloatAsState));
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                Function0 function1117 = (Function0) objRememberedValue3;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -474489292, "CC(remember):NavigationRail.kt#9igjgp");
                zChanged4 = composerStartRestartGroup.changed(stateAnimateFloatAsState2);
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (!zChanged4) {
                    objRememberedValue4 = new Function0() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda13
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return Float.valueOf(NavigationRailKt.NavigationRailItem$lambda$3$5$0(stateAnimateFloatAsState2));
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                } else {
                    objRememberedValue4 = new Function0() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda13
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return Float.valueOf(NavigationRailKt.NavigationRailItem$lambda$3$5$0(stateAnimateFloatAsState2));
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                NavigationRailItemLayout(composableLambdaRememberComposableLambda111119, composableLambdaRememberComposableLambda1111110, composableLambdaRememberComposableLambda111117, composableLambda, z111113, function1117, (Function0) objRememberedValue4, composerStartRestartGroup, (57344 & (i12 >> 6)) | 438);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                navigationRailItemColors2 = navigationRailItemColors1114;
                composer2 = composerStartRestartGroup;
                z6 = z111113;
                z7 = z111115;
                mutableInteractionSource2 = mutableInteractionSource3;
                modifier2 = modifier18;
                function5 = function7;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                z6 = z3;
                mutableInteractionSource2 = mutableInteractionSource;
                z7 = z4;
                composer2 = composerStartRestartGroup;
                function5 = function4;
                navigationRailItemColors2 = navigationRailItemColors;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda14
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return NavigationRailKt.NavigationRailItem$lambda$4(z, function0, function2, modifier2, z7, function5, z6, navigationRailItemColors2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 100663296;
        if ((i3 & 38347923) != 38347922) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z5, i3 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "210@9536L8");
            if ((i & 1) != 0) {
                if (i13 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i4 != 0) {
                    z4 = true;
                }
                if (i6 != 0) {
                    function4 = null;
                }
                if (i8 != 0) {
                    z8 = true;
                } else {
                    z8 = z3;
                }
                if ((i2 & 128) != 0) {
                    navigationRailItemColorsColors = NavigationRailItemDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                    i3 &= -29360129;
                } else {
                    navigationRailItemColorsColors = navigationRailItemColors;
                }
                i12 = i3;
                navigationRailItemColors3 = navigationRailItemColorsColors;
                modifier3 = modifier2;
                z9 = z4;
                function6 = function4;
                if (i10 != 0) {
                    mutableInteractionSource3 = null;
                } else {
                    mutableInteractionSource3 = mutableInteractionSource;
                }
                z10 = z8;
            } else {
                if (i13 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i4 != 0) {
                    z4 = true;
                }
                if (i6 != 0) {
                    function4 = null;
                }
                if (i8 != 0) {
                    z8 = true;
                } else {
                    z8 = z3;
                }
                if ((i2 & 128) != 0) {
                    navigationRailItemColorsColors = NavigationRailItemDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                    i3 &= -29360129;
                } else {
                    navigationRailItemColorsColors = navigationRailItemColors;
                }
                i12 = i3;
                navigationRailItemColors3 = navigationRailItemColorsColors;
                modifier3 = modifier2;
                z9 = z4;
                function6 = function4;
                if (i10 != 0) {
                    mutableInteractionSource3 = null;
                } else {
                    mutableInteractionSource3 = mutableInteractionSource;
                }
                z10 = z8;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1620317701, i12, -1, "androidx.compose.material3.NavigationRailItem (NavigationRail.kt:212)");
            }
            if (mutableInteractionSource3 == null) {
                composerStartRestartGroup.startReplaceGroup(253276704);
                ComposerKt.sourceInformation(composerStartRestartGroup, "214@9688L39");
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1947832866, "CC(remember):NavigationRail.kt#9igjgp");
                objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue5 = InteractionSourceKt.MutableInteractionSource();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endReplaceGroup();
                mutableInteractionSource4 = (MutableInteractionSource) objRememberedValue5;
            } else {
                composerStartRestartGroup.startReplaceGroup(1947832215);
                composerStartRestartGroup.endReplaceGroup();
                mutableInteractionSource4 = mutableInteractionSource3;
            }
            finiteAnimationSpecValue = MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultEffects, composerStartRestartGroup, 6);
            boolean z111116 = z10;
            ComposableLambda composableLambdaRememberComposableLambda1111111 = ComposableLambdaKt.rememberComposableLambda(206057749, true, new Function2() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return NavigationRailKt.NavigationRailItem$lambda$1(navigationRailItemColors3, z, z9, finiteAnimationSpecValue, function6, z10, function2, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54);
            if (function6 == null) {
                composerStartRestartGroup.startReplaceGroup(254203944);
                composerStartRestartGroup.endReplaceGroup();
                navigationRailItemColors4 = navigationRailItemColors3;
                function7 = function6;
                r7 = 1;
                composableLambda = null;
            } else {
                composerStartRestartGroup.startReplaceGroup(254203945);
                ComposerKt.sourceInformation(composerStartRestartGroup, "*233@10636L534");
                final NavigationRailItemColors navigationRailItemColors1115 = navigationRailItemColors3;
                final boolean z111117 = z9;
                final Function2 function1118 = function6;
                navigationRailItemColors4 = navigationRailItemColors1115;
                function7 = function1118;
                r7 = 1;
                ComposableLambda composableLambdaRememberComposableLambda1111112 = ComposableLambdaKt.rememberComposableLambda(-2056532825, true, new Function2() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return NavigationRailKt.NavigationRailItem$lambda$2$0(navigationRailItemColors1115, z, z111117, finiteAnimationSpecValue, function1118, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54);
                composerStartRestartGroup.endReplaceGroup();
                composableLambda = composableLambdaRememberComposableLambda1111112;
            }
            boolean z111118 = z9;
            Modifier modifier19 = modifier3;
            mutableInteractionSource5 = mutableInteractionSource4;
            Modifier modifierM1273widthInVpY3zN4$default16 = SizeKt.m1273widthInVpY3zN4$default(SizeKt.m1251defaultMinSizeVpY3zN4$default(SelectableKt.m1533selectableO2vRcR0(modifier19, z, mutableInteractionSource5, null, z111118, Role.m8825boximpl(Role.INSTANCE.m8839getTabo7Vup1c()), function0), 0.0f, NavigationRailItemHeight, r7, null), NavigationRailItemWidth, 0.0f, 2, null);
            Alignment center16 = Alignment.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy16 = BoxKt.maybeCachedBoxMeasurePolicy(center16, r7);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap16 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier16 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1273widthInVpY3zN4$default16);
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
            Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy16, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
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
            BoxScopeInstance boxScopeInstance16 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1826936439, "C267@11982L7,264@11752L252,273@12294L7,270@12067L249,279@12577L7,280@12620L315,289@12986L146,303@13569L237,311@13855L285,325@14406L32,326@14476L31,319@14150L368:NavigationRail.kt#uh7d8r");
            if (z) {
                f = 1.0f;
            } else {
                f = 0.0f;
            }
            final NavigationRailItemColors navigationRailItemColors1116 = navigationRailItemColors4;
            stateAnimateFloatAsState = AnimateAsStateKt.animateFloatAsState(f, MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultEffects, composerStartRestartGroup, 6), 0.0f, null, null, composerStartRestartGroup, 0, 28);
            if (z) {
                f2 = 1.0f;
            } else {
                f2 = 0.0f;
            }
            stateAnimateFloatAsState2 = AnimateAsStateKt.animateFloatAsState(f2, MotionSchemeKt.value(MotionSchemeKeyTokens.FastSpatial, composerStartRestartGroup, 6), 0.0f, null, null, composerStartRestartGroup, 0, 28);
            ProvidableCompositionLocal<Density> localDensity16 = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume16 = composerStartRestartGroup.consume(localDensity16);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            density = (Density) objConsume16;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -474548400, "CC(remember):NavigationRail.kt#9igjgp");
            zChanged = composerStartRestartGroup.changed(density);
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (!zChanged) {
                objRememberedValue = new Function0() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return NavigationRailKt.NavigationRailItem$lambda$3$0$0(density);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            } else {
                objRememberedValue = new Function0() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return NavigationRailKt.NavigationRailItem$lambda$3$0$0(density);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            function1 = (Function0) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -474536857, "CC(remember):NavigationRail.kt#9igjgp");
            zChanged2 = composerStartRestartGroup.changed(mutableInteractionSource5) | composerStartRestartGroup.changed(function1);
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (!zChanged2) {
                objRememberedValue2 = new MappedInteractionSource(mutableInteractionSource5, function1);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            } else {
                objRememberedValue2 = new MappedInteractionSource(mutableInteractionSource5, function1);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            final MappedInteractionSource mappedInteractionSource16 = (MappedInteractionSource) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (function7 != null) {
                composerStartRestartGroup.startReplaceGroup(-1825536046);
                ComposerKt.sourceInformation(composerStartRestartGroup, "295@13266L5");
                value = ShapesKt.getValue(NavigationRailBaselineItemTokens.INSTANCE.getActiveIndicatorShape(), composerStartRestartGroup, 6);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(-1825440690);
                ComposerKt.sourceInformation(composerStartRestartGroup, "297@13335L5");
                value = ShapesKt.getValue(ShapeKeyTokens.CornerFull, composerStartRestartGroup, 6);
                composerStartRestartGroup.endReplaceGroup();
            }
            ComposableLambda composableLambdaRememberComposableLambda1111113 = ComposableLambdaKt.rememberComposableLambda(455696046, true, new Function2() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda10
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return NavigationRailKt.NavigationRailItem$lambda$3$2(value, mappedInteractionSource16, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54);
            ComposableLambda composableLambdaRememberComposableLambda1111114 = ComposableLambdaKt.rememberComposableLambda(2137606782, true, new Function2() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda11
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return NavigationRailKt.NavigationRailItem$lambda$3$3(stateAnimateFloatAsState, navigationRailItemColors1116, value, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -474491531, "CC(remember):NavigationRail.kt#9igjgp");
            zChanged3 = composerStartRestartGroup.changed(stateAnimateFloatAsState);
            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (!zChanged3) {
                objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda12
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Float.valueOf(NavigationRailKt.NavigationRailItem$lambda$3$4$0(stateAnimateFloatAsState));
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            } else {
                objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda12
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Float.valueOf(NavigationRailKt.NavigationRailItem$lambda$3$4$0(stateAnimateFloatAsState));
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            Function0 function1119 = (Function0) objRememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -474489292, "CC(remember):NavigationRail.kt#9igjgp");
            zChanged4 = composerStartRestartGroup.changed(stateAnimateFloatAsState2);
            objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (!zChanged4) {
                objRememberedValue4 = new Function0() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda13
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Float.valueOf(NavigationRailKt.NavigationRailItem$lambda$3$5$0(stateAnimateFloatAsState2));
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            } else {
                objRememberedValue4 = new Function0() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda13
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Float.valueOf(NavigationRailKt.NavigationRailItem$lambda$3$5$0(stateAnimateFloatAsState2));
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            NavigationRailItemLayout(composableLambdaRememberComposableLambda1111113, composableLambdaRememberComposableLambda1111114, composableLambdaRememberComposableLambda1111111, composableLambda, z111116, function1119, (Function0) objRememberedValue4, composerStartRestartGroup, (57344 & (i12 >> 6)) | 438);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            navigationRailItemColors2 = navigationRailItemColors1116;
            composer2 = composerStartRestartGroup;
            z6 = z111116;
            z7 = z111118;
            mutableInteractionSource2 = mutableInteractionSource3;
            modifier2 = modifier19;
            function5 = function7;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            z6 = z3;
            mutableInteractionSource2 = mutableInteractionSource;
            z7 = z4;
            composer2 = composerStartRestartGroup;
            function5 = function4;
            navigationRailItemColors2 = navigationRailItemColors;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda14
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return NavigationRailKt.NavigationRailItem$lambda$4(z, function0, function2, modifier2, z7, function5, z6, navigationRailItemColors2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NavigationRailItem$lambda$1(NavigationRailItemColors navigationRailItemColors, boolean z, boolean z2, FiniteAnimationSpec finiteAnimationSpec, Function2 function2, boolean z3, Function2 function3, Composer composer, int i) {
        Modifier.Companion companionClearAndSetSemantics;
        ComposerKt.sourceInformation(composer, "C220@9969L186,226@10337L193:NavigationRail.kt#uh7d8r");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(206057749, i, -1, "androidx.compose.material3.NavigationRailItem.<anonymous> (NavigationRail.kt:219)");
            }
            State<Color> stateM437animateColorAsStateeuL9pac = SingleValueAnimationKt.m437animateColorAsStateeuL9pac(navigationRailItemColors.m3925iconColorWaAFU9c$material3(z, z2), finiteAnimationSpec, null, null, composer, 0, 12);
            if (function2 == null || !(z3 || z)) {
                composer.startReplaceGroup(453016797);
                composer.endReplaceGroup();
                companionClearAndSetSemantics = Modifier.INSTANCE;
            } else {
                composer.startReplaceGroup(453015884);
                ComposerKt.sourceInformation(composer, "226@10402L2");
                Modifier.Companion companion = Modifier.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composer, 453016535, "CC(remember):NavigationRail.kt#9igjgp");
                Object objRememberedValue = composer.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function1() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return NavigationRailKt.NavigationRailItem$lambda$1$1$0((SemanticsPropertyReceiver) obj);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                companionClearAndSetSemantics = SemanticsModifierKt.clearAndSetSemantics(companion, (Function1) objRememberedValue);
                composer.endReplaceGroup();
            }
            ComposerKt.sourceInformationMarkerStart(composer, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, companionClearAndSetSemantics);
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
            ComposerKt.sourceInformationMarkerStart(composer, -911361862, "C227@10438L78:NavigationRail.kt#uh7d8r");
            CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m6804boximpl(NavigationRailItem$lambda$1$0(stateM437animateColorAsStateeuL9pac))), (Function2<? super Composer, ? super Integer, Unit>) function3, composer, ProvidedValue.$stable);
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
    public static final Unit NavigationRailItem$lambda$1$1$0(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NavigationRailItem$lambda$2$0(NavigationRailItemColors navigationRailItemColors, boolean z, boolean z2, FiniteAnimationSpec finiteAnimationSpec, Function2 function2, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C234@10713L5,236@10772L198,240@10987L169:NavigationRail.kt#uh7d8r");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2056532825, i, -1, "androidx.compose.material3.NavigationRailItem.<anonymous>.<anonymous> (NavigationRail.kt:234)");
            }
            ProvideContentColorTextStyleKt.m4997ProvideContentColorTextStyle3JVO9M(NavigationRailItem$lambda$2$0$0(SingleValueAnimationKt.m437animateColorAsStateeuL9pac(navigationRailItemColors.m3926textColorWaAFU9c$material3(z, z2), finiteAnimationSpec, null, null, composer, 0, 12)), TypographyKt.getValue(NavigationRailVerticalItemTokens.INSTANCE.getLabelTextFont(), composer, 6), function2, composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Offset NavigationRailItem$lambda$3$0$0(Density density) {
        return Offset.m6558boximpl(Offset.m6561constructorimpl((((long) Float.floatToRawIntBits((density.mo748roundToPx0680j_4(NavigationRailItemWidth) - density.mo748roundToPx0680j_4(NavigationRailVerticalItemTokens.INSTANCE.m5589getActiveIndicatorWidthD9Ej5fM())) / 2)) << 32) | (((long) Float.floatToRawIntBits(0.0f)) & 4294967295L)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NavigationRailItem$lambda$3$2(Shape shape, MappedInteractionSource mappedInteractionSource, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C304@13587L205:NavigationRail.kt#uh7d8r");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(455696046, i, -1, "androidx.compose.material3.NavigationRailItem.<anonymous>.<anonymous> (NavigationRail.kt:304)");
            }
            BoxKt.Box(IndicationKt.indication(ClipKt.clip(LayoutIdKt.layoutId(Modifier.INSTANCE, IndicatorRippleLayoutIdTag), shape), mappedInteractionSource, RippleKt.m4031rippleH2RKhps$default(false, 0.0f, 0L, 7, null)), composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NavigationRailItem$lambda$3$3(final State state, NavigationRailItemColors navigationRailItemColors, Shape shape, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C314@13977L40,312@13873L253:NavigationRail.kt#uh7d8r");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2137606782, i, -1, "androidx.compose.material3.NavigationRailItem.<anonymous>.<anonymous> (NavigationRail.kt:312)");
            }
            Modifier modifierLayoutId = LayoutIdKt.layoutId(Modifier.INSTANCE, IndicatorLayoutIdTag);
            ComposerKt.sourceInformationMarkerStart(composer, 1245753958, "CC(remember):NavigationRail.kt#9igjgp");
            boolean zChanged = composer.changed(state);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return NavigationRailKt.NavigationRailItem$lambda$3$3$0$0(state, (GraphicsLayerScope) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            BoxKt.Box(BackgroundKt.m588backgroundbw27NRU(GraphicsLayerModifierKt.graphicsLayer(modifierLayoutId, (Function1) objRememberedValue), navigationRailItemColors.getSelectedIndicatorColor(), shape), composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NavigationRailItem$lambda$3$3$0$0(State state, GraphicsLayerScope graphicsLayerScope) {
        graphicsLayerScope.setAlpha(((Number) state.getValue()).floatValue());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float NavigationRailItem$lambda$3$4$0(State state) {
        return ((Number) state.getValue()).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float NavigationRailItem$lambda$3$5$0(State state) {
        return ((Number) state.getValue()).floatValue();
    }

    private static final void NavigationRailItemLayout(final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function3, final Function2<? super Composer, ? super Integer, Unit> function4, final Function2<? super Composer, ? super Integer, Unit> function5, final boolean z, final Function0<Float> function0, final Function0<Float> function1, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-759267492);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(NavigationRailItemLayout)N(indicatorRipple,indicator,icon,label,alwaysShowLabel,alphaAnimationProgress,sizeAnimationProgress)582@25968L2050,564@25447L2571:NavigationRail.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(function2) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function3) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function4) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function5) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= composerStartRestartGroup.changed(z) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function0) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function1) ? 1048576 : 524288;
        }
        if (!composerStartRestartGroup.shouldExecute((599187 & i2) != 599186, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-759267492, i2, -1, "androidx.compose.material3.NavigationRailItemLayout (NavigationRail.kt:563)");
            }
            Modifier modifierBadgeBounds = BadgeKt.badgeBounds(Modifier.INSTANCE);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 488408990, "CC(remember):NavigationRail.kt#9igjgp");
            int i3 = 57344 & i2;
            boolean z2 = ((3670016 & i2) == 1048576) | ((i2 & 7168) == 2048) | (i3 == 16384);
            MeasurePolicy measurePolicyRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z2 || measurePolicyRememberedValue == Composer.INSTANCE.getEmpty()) {
                measurePolicyRememberedValue = new MeasurePolicy() { // from class: androidx.compose.material3.NavigationRailKt$NavigationRailItemLayout$1$1
                    @Override // androidx.compose.ui.layout.MeasurePolicy
                    /* JADX INFO: renamed from: measure-3p2s80s */
                    public final MeasureResult mo344measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
                        Measurable measurable;
                        Placeable placeableMo8265measureBRTryo0;
                        float fCoerceAtLeast = RangesKt.coerceAtLeast(function1.invoke().floatValue(), 0.0f);
                        long jM9630copyZbe2FdA$default = Constraints.m9630copyZbe2FdA$default(j, 0, 0, 0, 0, 10, null);
                        List<? extends Measurable> list2 = list;
                        int size = list2.size();
                        for (int i4 = 0; i4 < size; i4++) {
                            Measurable measurable2 = list.get(i4);
                            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable2), HubsObservability.HUB_ASSET_ICON)) {
                                Placeable placeableMo8265measureBRTryo1 = measurable2.mo8265measureBRTryo0(jM9630copyZbe2FdA$default);
                                float f = 2;
                                int width = placeableMo8265measureBRTryo1.getWidth() + measureScope.mo748roundToPx0680j_4(Dp.m9687constructorimpl(NavigationRailKt.IndicatorHorizontalPadding * f));
                                int iRoundToInt = MathKt.roundToInt(width * fCoerceAtLeast);
                                int height = placeableMo8265measureBRTryo1.getHeight() + measureScope.mo748roundToPx0680j_4(Dp.m9687constructorimpl((function5 == null ? NavigationRailKt.IndicatorVerticalPaddingNoLabel : NavigationRailKt.IndicatorVerticalPaddingWithLabel) * f));
                                int size2 = list2.size();
                                for (int i5 = 0; i5 < size2; i5++) {
                                    Measurable measurable3 = list.get(i5);
                                    if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable3), "indicatorRipple")) {
                                        Placeable placeableMo8265measureBRTryo2 = measurable3.mo8265measureBRTryo0(Constraints.INSTANCE.m9650fixedJhjzzOo(width, height));
                                        int size3 = list2.size();
                                        int i6 = 0;
                                        while (true) {
                                            if (i6 >= size3) {
                                                measurable = null;
                                                break;
                                            }
                                            measurable = list.get(i6);
                                            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable), "indicator")) {
                                                break;
                                            }
                                            i6++;
                                        }
                                        Measurable measurable4 = measurable;
                                        Placeable placeableMo8265measureBRTryo3 = measurable4 != null ? measurable4.mo8265measureBRTryo0(Constraints.INSTANCE.m9650fixedJhjzzOo(iRoundToInt, height)) : null;
                                        if (function5 != null) {
                                            int size4 = list2.size();
                                            int i7 = 0;
                                            while (true) {
                                                if (i7 < size4) {
                                                    Measurable measurable5 = list.get(i7);
                                                    if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable5), "label")) {
                                                        placeableMo8265measureBRTryo0 = measurable5.mo8265measureBRTryo0(jM9630copyZbe2FdA$default);
                                                        break;
                                                    }
                                                    i7++;
                                                } else {
                                                    ListUtilsKt.throwNoSuchElementException("Collection contains no element matching the predicate.");
                                                    throw new KotlinNothingValueException();
                                                }
                                            }
                                        } else {
                                            placeableMo8265measureBRTryo0 = null;
                                        }
                                        if (function5 == null) {
                                            return NavigationRailKt.m3938placeIconX9ElhV4(measureScope, placeableMo8265measureBRTryo1, placeableMo8265measureBRTryo2, placeableMo8265measureBRTryo3, j);
                                        }
                                        Intrinsics.checkNotNull(placeableMo8265measureBRTryo0);
                                        return NavigationRailKt.m3939placeLabelAndIconzUg2_y0(measureScope, placeableMo8265measureBRTryo0, placeableMo8265measureBRTryo1, placeableMo8265measureBRTryo2, placeableMo8265measureBRTryo3, j, z, fCoerceAtLeast);
                                    }
                                }
                                ListUtilsKt.throwNoSuchElementException("Collection contains no element matching the predicate.");
                                throw new KotlinNothingValueException();
                            }
                        }
                        ListUtilsKt.throwNoSuchElementException("Collection contains no element matching the predicate.");
                        throw new KotlinNothingValueException();
                    }
                };
                composerStartRestartGroup.updateRememberedValue(measurePolicyRememberedValue);
            }
            MeasurePolicy measurePolicy = (MeasurePolicy) measurePolicyRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierBadgeBounds);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            int i4 = i2;
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
            Updater.m6070setimpl(composerM6062constructorimpl, measurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM6062constructorimpl.getInserting() || !Intrinsics.areEqual(composerM6062constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 772983468, "C567@25530L17,568@25560L11,570@25585L50:NavigationRail.kt#uh7d8r");
            function2.invoke(composerStartRestartGroup, Integer.valueOf(i4 & 14));
            function3.invoke(composerStartRestartGroup, Integer.valueOf((i4 >> 3) & 14));
            Modifier modifierLayoutId = LayoutIdKt.layoutId(Modifier.INSTANCE, "icon");
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierLayoutId);
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
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
            Composer composerM6062constructorimpl2 = Updater.m6062constructorimpl(composerStartRestartGroup);
            Updater.m6070setimpl(composerM6062constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM6062constructorimpl2.getInserting() || !Intrinsics.areEqual(composerM6062constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                composerM6062constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                composerM6062constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.m6070setimpl(composerM6062constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1280363716, "C570@25627L6:NavigationRail.kt#uh7d8r");
            function4.invoke(composerStartRestartGroup, Integer.valueOf((i4 >> 6) & 14));
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (function5 != null) {
                composerStartRestartGroup.startReplaceGroup(773116085);
                ComposerKt.sourceInformation(composerStartRestartGroup, "574@25761L109,573@25686L250");
                Modifier modifierLayoutId2 = LayoutIdKt.layoutId(Modifier.INSTANCE, "label");
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 579131360, "CC(remember):NavigationRail.kt#9igjgp");
                boolean z3 = (i3 == 16384) | ((i4 & 458752) == 131072);
                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (z3 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function1() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return NavigationRailKt.NavigationRailItemLayout$lambda$1$1$0(z, function0, (GraphicsLayerScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifierGraphicsLayer = GraphicsLayerModifierKt.graphicsLayer(modifierLayoutId2, (Function1) objRememberedValue);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierGraphicsLayer);
                Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
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
                Composer composerM6062constructorimpl3 = Updater.m6062constructorimpl(composerStartRestartGroup);
                Updater.m6070setimpl(composerM6062constructorimpl3, measurePolicyMaybeCachedBoxMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (composerM6062constructorimpl3.getInserting() || !Intrinsics.areEqual(composerM6062constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                    composerM6062constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                    composerM6062constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                }
                Updater.m6070setimpl(composerM6062constructorimpl3, modifierMaterializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -995857944, "C578@25911L7:NavigationRail.kt#uh7d8r");
                function5.invoke(composerStartRestartGroup, Integer.valueOf((i4 >> 9) & 14));
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            } else {
                composerStartRestartGroup.startReplaceGroup(747643695);
            }
            composerStartRestartGroup.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return NavigationRailKt.NavigationRailItemLayout$lambda$2(function2, function3, function4, function5, z, function0, function1, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NavigationRailItemLayout$lambda$1$1$0(boolean z, Function0 function0, GraphicsLayerScope graphicsLayerScope) {
        graphicsLayerScope.setAlpha(z ? 1.0f : ((Number) function0.invoke()).floatValue());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: placeIcon-X9ElhV4, reason: not valid java name */
    public static final MeasureResult m3938placeIconX9ElhV4(MeasureScope measureScope, final Placeable placeable, final Placeable placeable2, final Placeable placeable3, long j) {
        final int iM9657constrainWidthK40F9xA = ConstraintsKt.m9657constrainWidthK40F9xA(j, Math.max(placeable.getWidth(), Math.max(placeable2.getWidth(), placeable3 != null ? placeable3.getWidth() : 0)));
        final int iM9656constrainHeightK40F9xA = ConstraintsKt.m9656constrainHeightK40F9xA(j, measureScope.mo748roundToPx0680j_4(NavigationRailItemHeight));
        final int width = (iM9657constrainWidthK40F9xA - placeable.getWidth()) / 2;
        final int height = (iM9656constrainHeightK40F9xA - placeable.getHeight()) / 2;
        final int width2 = (iM9657constrainWidthK40F9xA - placeable2.getWidth()) / 2;
        final int height2 = (iM9656constrainHeightK40F9xA - placeable2.getHeight()) / 2;
        return MeasureScope.layout$default(measureScope, iM9657constrainWidthK40F9xA, iM9656constrainHeightK40F9xA, null, new Function1() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return NavigationRailKt.placeIcon_X9ElhV4$lambda$0(placeable3, placeable, width, height, placeable2, width2, height2, iM9657constrainWidthK40F9xA, iM9656constrainHeightK40F9xA, (Placeable.PlacementScope) obj);
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit placeIcon_X9ElhV4$lambda$0(Placeable placeable, Placeable placeable2, int i, int i2, Placeable placeable3, int i3, int i4, int i5, int i6, Placeable.PlacementScope placementScope) {
        if (placeable != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable, (i5 - placeable.getWidth()) / 2, (i6 - placeable.getHeight()) / 2, 0.0f, 4, null);
        }
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable2, i, i2, 0.0f, 4, null);
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable3, i3, i4, 0.0f, 4, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: placeLabelAndIcon-zUg2_y0, reason: not valid java name */
    public static final MeasureResult m3939placeLabelAndIconzUg2_y0(final MeasureScope measureScope, final Placeable placeable, final Placeable placeable2, final Placeable placeable3, final Placeable placeable4, long j, final boolean z, final float f) {
        float height = placeable2.getHeight();
        float f2 = IndicatorVerticalPaddingWithLabel;
        float f3 = height + measureScope.mo754toPx0680j_4(f2);
        float f4 = NavigationRailItemVerticalPadding;
        float f5 = f3 + measureScope.mo754toPx0680j_4(f4) + placeable.getHeight();
        float f6 = 2;
        final float fCoerceAtLeast = RangesKt.coerceAtLeast((Constraints.m9641getMinHeightimpl(j) - f5) / f6, measureScope.mo754toPx0680j_4(f2));
        float f7 = f5 + (fCoerceAtLeast * f6);
        final float height2 = ((z ? fCoerceAtLeast : (f7 - placeable2.getHeight()) / f6) - fCoerceAtLeast) * (1 - f);
        final float height3 = placeable2.getHeight() + fCoerceAtLeast + measureScope.mo754toPx0680j_4(f2) + measureScope.mo754toPx0680j_4(f4);
        final int iM9657constrainWidthK40F9xA = ConstraintsKt.m9657constrainWidthK40F9xA(j, Math.max(placeable2.getWidth(), Math.max(placeable.getWidth(), placeable4 != null ? placeable4.getWidth() : 0)));
        final int width = (iM9657constrainWidthK40F9xA - placeable.getWidth()) / 2;
        final int width2 = (iM9657constrainWidthK40F9xA - placeable2.getWidth()) / 2;
        final int width3 = (iM9657constrainWidthK40F9xA - placeable3.getWidth()) / 2;
        final float f8 = fCoerceAtLeast - measureScope.mo754toPx0680j_4(f2);
        return MeasureScope.layout$default(measureScope, iM9657constrainWidthK40F9xA, MathKt.roundToInt(f7), null, new Function1() { // from class: androidx.compose.material3.NavigationRailKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return NavigationRailKt.placeLabelAndIcon_zUg2_y0$lambda$0(placeable4, z, f, placeable, width, height3, height2, placeable2, width2, fCoerceAtLeast, placeable3, width3, f8, iM9657constrainWidthK40F9xA, measureScope, (Placeable.PlacementScope) obj);
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit placeLabelAndIcon_zUg2_y0$lambda$0(Placeable placeable, boolean z, float f, Placeable placeable2, int i, float f2, float f3, Placeable placeable3, int i2, float f4, Placeable placeable4, int i3, float f5, int i4, MeasureScope measureScope, Placeable.PlacementScope placementScope) {
        if (placeable != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable, (i4 - placeable.getWidth()) / 2, MathKt.roundToInt((f4 - measureScope.mo754toPx0680j_4(IndicatorVerticalPaddingWithLabel)) + f3), 0.0f, 4, null);
        }
        if (z || f != 0.0f) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable2, i, MathKt.roundToInt(f2 + f3), 0.0f, 4, null);
        }
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable3, i2, MathKt.roundToInt(f4 + f3), 0.0f, 4, null);
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable4, i3, MathKt.roundToInt(f5 + f3), 0.0f, 4, null);
        return Unit.INSTANCE;
    }

    public static final float getNavigationRailVerticalPadding() {
        return NavigationRailVerticalPadding;
    }

    public static final float getNavigationRailItemWidth() {
        return NavigationRailItemWidth;
    }

    public static final float getNavigationRailItemHeight() {
        return NavigationRailItemHeight;
    }

    public static final float getNavigationRailItemVerticalPadding() {
        return NavigationRailItemVerticalPadding;
    }

    public static final ProvidableCompositionLocal<NavigationRailOverride> getLocalNavigationRailOverride() {
        return LocalNavigationRailOverride;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final NavigationRailOverride LocalNavigationRailOverride$lambda$0() {
        return DefaultNavigationRailOverride.INSTANCE;
    }

    private static final long NavigationRailItem$lambda$1$0(State<Color> state) {
        return state.getValue().m6824unboximpl();
    }

    private static final long NavigationRailItem$lambda$2$0$0(State<Color> state) {
        return state.getValue().m6824unboximpl();
    }

    static {
        float f = 4;
        NavigationRailVerticalPadding = Dp.m9687constructorimpl(f);
        NavigationRailItemVerticalPadding = Dp.m9687constructorimpl(f);
        float f2 = 2;
        IndicatorHorizontalPadding = Dp.m9687constructorimpl(Dp.m9687constructorimpl(NavigationRailVerticalItemTokens.INSTANCE.m5589getActiveIndicatorWidthD9Ej5fM() - NavigationRailBaselineItemTokens.INSTANCE.m5572getIconSizeD9Ej5fM()) / f2);
        IndicatorVerticalPaddingWithLabel = Dp.m9687constructorimpl(Dp.m9687constructorimpl(NavigationRailVerticalItemTokens.INSTANCE.m5588getActiveIndicatorHeightD9Ej5fM() - NavigationRailBaselineItemTokens.INSTANCE.m5572getIconSizeD9Ej5fM()) / f2);
        IndicatorVerticalPaddingNoLabel = Dp.m9687constructorimpl(Dp.m9687constructorimpl(NavigationRailVerticalItemTokens.INSTANCE.m5589getActiveIndicatorWidthD9Ej5fM() - NavigationRailBaselineItemTokens.INSTANCE.m5572getIconSizeD9Ej5fM()) / f2);
    }
}
