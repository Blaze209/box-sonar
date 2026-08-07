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
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.selection.SelectableKt;
import androidx.compose.material3.internal.MappedInteractionSource;
import androidx.compose.material3.internal.ProvideContentColorTextStyleKt;
import androidx.compose.material3.tokens.MotionSchemeKeyTokens;
import androidx.compose.material3.tokens.NavigationBarTokens;
import androidx.compose.material3.tokens.NavigationBarVerticalItemTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotIntStateKt;
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
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.OnRemeasuredModifierKt;
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
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.util.ListUtilsKt;
import androidx.media3.common.C;
import androidx.profileinstaller.ProfileVerifier;
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

/* JADX INFO: compiled from: NavigationBar.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\u001a_\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\u001c\u0010\u000b\u001a\u0018\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00010\f¢\u0006\u0002\b\u000e¢\u0006\u0002\b\u000fH\u0007¢\u0006\u0004\b\u0010\u0010\u0011\u001a\u0085\u0001\u0010\u0012\u001a\u00020\u0001*\u00020\r2\u0006\u0010\u0013\u001a\u00020\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00010\u00162\u0011\u0010\u0017\u001a\r\u0012\u0004\u0012\u00020\u00010\u0016¢\u0006\u0002\b\u000e2\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0018\u001a\u00020\u00142\u0015\b\u0002\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0016¢\u0006\u0002\b\u000e2\b\b\u0002\u0010\u001a\u001a\u00020\u00142\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0007¢\u0006\u0002\u0010\u001f\u001a\u007f\u0010 \u001a\u00020\u00012\u0011\u0010!\u001a\r\u0012\u0004\u0012\u00020\u00010\u0016¢\u0006\u0002\b\u000e2\u0011\u0010\"\u001a\r\u0012\u0004\u0012\u00020\u00010\u0016¢\u0006\u0002\b\u000e2\u0011\u0010\u0017\u001a\r\u0012\u0004\u0012\u00020\u00010\u0016¢\u0006\u0002\b\u000e2\u0013\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0016¢\u0006\u0002\b\u000e2\u0006\u0010\u001a\u001a\u00020\u00142\f\u0010#\u001a\b\u0012\u0004\u0012\u00020$0\u00162\f\u0010%\u001a\b\u0012\u0004\u0012\u00020$0\u0016H\u0003¢\u0006\u0002\u0010&\u001a5\u0010'\u001a\u00020(*\u00020)2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020+2\b\u0010-\u001a\u0004\u0018\u00010+2\u0006\u0010.\u001a\u00020/H\u0002¢\u0006\u0004\b0\u00101\u001aM\u00102\u001a\u00020(*\u00020)2\u0006\u00103\u001a\u00020+2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020+2\b\u0010-\u001a\u0004\u0018\u00010+2\u0006\u0010.\u001a\u00020/2\u0006\u0010\u001a\u001a\u00020\u00142\u0006\u00104\u001a\u00020$H\u0002¢\u0006\u0004\b5\u00106\"\u000e\u00107\u001a\u000208X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u00109\u001a\u000208X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010:\u001a\u000208X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010;\u001a\u000208X\u0082T¢\u0006\u0002\n\u0000\"\u0010\u0010<\u001a\u00020\bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010=\"\u0016\u0010>\u001a\u00020\bX\u0080\u0004¢\u0006\n\n\u0002\u0010=\u001a\u0004\b?\u0010@\"\u0016\u0010A\u001a\u00020\bX\u0080\u0004¢\u0006\n\n\u0002\u0010=\u001a\u0004\bB\u0010@\"\u0010\u0010C\u001a\u00020\bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010=\"\u0016\u0010D\u001a\u00020\bX\u0080\u0004¢\u0006\n\n\u0002\u0010=\u001a\u0004\bE\u0010@\"\u0010\u0010F\u001a\u00020\bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010=\"\u0016\u0010G\u001a\u00020\bX\u0080\u0004¢\u0006\n\n\u0002\u0010=\u001a\u0004\bH\u0010@\"\"\u0010I\u001a\b\u0012\u0004\u0012\u00020K0J8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bL\u0010M\u001a\u0004\bN\u0010O¨\u0006P²\u0006\n\u0010Q\u001a\u00020\u0005X\u008a\u0084\u0002²\u0006\n\u0010R\u001a\u00020\u0005X\u008a\u0084\u0002²\u0006\n\u0010S\u001a\u00020TX\u008a\u008e\u0002"}, d2 = {"NavigationBar", "", "modifier", "Landroidx/compose/ui/Modifier;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "tonalElevation", "Landroidx/compose/ui/unit/Dp;", "windowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/RowScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "NavigationBar-HsRjFd4", "(Landroidx/compose/ui/Modifier;JJFLandroidx/compose/foundation/layout/WindowInsets;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "NavigationBarItem", "selected", "", ViewProps.ON_CLICK, "Lkotlin/Function0;", "icon", "enabled", "label", "alwaysShowLabel", "colors", "Landroidx/compose/material3/NavigationBarItemColors;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "(Landroidx/compose/foundation/layout/RowScope;ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;ZLandroidx/compose/material3/NavigationBarItemColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "NavigationBarItemLayout", NavigationBarKt.IndicatorRippleLayoutIdTag, NavigationBarKt.IndicatorLayoutIdTag, "alphaAnimationProgress", "", "sizeAnimationProgress", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "placeIcon", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "iconPlaceable", "Landroidx/compose/ui/layout/Placeable;", "indicatorRipplePlaceable", "indicatorPlaceable", "constraints", "Landroidx/compose/ui/unit/Constraints;", "placeIcon-X9ElhV4", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;J)Landroidx/compose/ui/layout/MeasureResult;", "placeLabelAndIcon", "labelPlaceable", "animationProgress", "placeLabelAndIcon-zUg2_y0", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;JZF)Landroidx/compose/ui/layout/MeasureResult;", "IndicatorRippleLayoutIdTag", "", "IndicatorLayoutIdTag", "IconLayoutIdTag", "LabelLayoutIdTag", "NavigationBarHeight", "F", "NavigationBarItemHorizontalPadding", "getNavigationBarItemHorizontalPadding", "()F", "NavigationBarIndicatorToLabelPadding", "getNavigationBarIndicatorToLabelPadding", "IndicatorHorizontalPadding", "IndicatorVerticalPadding", "getIndicatorVerticalPadding", "IndicatorVerticalOffset", "NavigationBarItemToIconMinimumPadding", "getNavigationBarItemToIconMinimumPadding", "LocalNavigationBarOverride", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/compose/material3/NavigationBarOverride;", "getLocalNavigationBarOverride$annotations", "()V", "getLocalNavigationBarOverride", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "material3", "iconColor", "textColor", "itemWidth", ""}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class NavigationBarKt {
    private static final String IconLayoutIdTag = "icon";
    private static final float IndicatorHorizontalPadding;
    private static final String IndicatorLayoutIdTag = "indicator";
    private static final String IndicatorRippleLayoutIdTag = "indicatorRipple";
    private static final float IndicatorVerticalPadding;
    private static final String LabelLayoutIdTag = "label";
    private static final float NavigationBarHeight = NavigationBarTokens.INSTANCE.m5555getTallContainerHeightD9Ej5fM();
    private static final float NavigationBarItemHorizontalPadding = Dp.m9687constructorimpl(8);
    private static final float NavigationBarIndicatorToLabelPadding = Dp.m9687constructorimpl(4);
    private static final float IndicatorVerticalOffset = Dp.m9687constructorimpl(12);
    private static final float NavigationBarItemToIconMinimumPadding = Dp.m9687constructorimpl(44);
    private static final ProvidableCompositionLocal<NavigationBarOverride> LocalNavigationBarOverride = CompositionLocalKt.compositionLocalOf$default(null, new Function0() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return NavigationBarKt.LocalNavigationBarOverride$lambda$0();
        }
    }, 1, null);

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NavigationBarItem$lambda$8(RowScope rowScope, boolean z, Function0 function0, Function2 function2, Modifier modifier, boolean z2, Function2 function3, boolean z3, NavigationBarItemColors navigationBarItemColors, MutableInteractionSource mutableInteractionSource, int i, int i2, Composer composer, int i3) {
        NavigationBarItem(rowScope, z, function0, function2, modifier, z2, function3, z3, navigationBarItemColors, mutableInteractionSource, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NavigationBarItemLayout$lambda$2(Function2 function2, Function2 function3, Function2 function4, Function2 function5, boolean z, Function0 function0, Function0 function1, int i, Composer composer, int i2) {
        NavigationBarItemLayout(function2, function3, function4, function5, z, function0, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NavigationBar_HsRjFd4$lambda$1(Modifier modifier, long j, long j2, float f, WindowInsets windowInsets, Function3 function3, int i, int i2, Composer composer, int i3) {
        m3841NavigationBarHsRjFd4(modifier, j, j2, f, windowInsets, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ void getLocalNavigationBarOverride$annotations() {
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0130  */
    /* JADX WARN: Code duplicated, block: B:102:0x0141  */
    /* JADX WARN: Code duplicated, block: B:105:0x014c  */
    /* JADX WARN: Code duplicated, block: B:108:0x0179  */
    /* JADX WARN: Code duplicated, block: B:110:0x0185  */
    /* JADX WARN: Code duplicated, block: B:113:0x0193  */
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
    /* JADX WARN: Code duplicated, block: B:98:0x0125  */
    /* JADX INFO: renamed from: NavigationBar-HsRjFd4, reason: not valid java name */
    public static final void m3841NavigationBarHsRjFd4(Modifier modifier, long j, long j2, float f, WindowInsets windowInsets, final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        long containerColor;
        long jM3050contentColorFor4WTKRHQ;
        float fM3822getElevationD9Ej5fM;
        WindowInsets windowInsets2;
        Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function4;
        boolean z;
        Modifier modifier3;
        final long j3;
        final long j4;
        final float f2;
        final WindowInsets windowInsets3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        WindowInsets windowInsets4;
        long j5;
        long j6;
        float f3;
        int i4;
        Composer composerStartRestartGroup = composer.startRestartGroup(1054099326);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(NavigationBar)N(modifier,containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,tonalElevation:c#ui.unit.Dp,windowInsets,content)121@5752L7,*130@6086L15:NavigationBar.kt#uh7d8r");
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
                jM3050contentColorFor4WTKRHQ = j2;
                int i7 = composerStartRestartGroup.changed(jM3050contentColorFor4WTKRHQ) ? 256 : 128;
                i3 |= i7;
            } else {
                jM3050contentColorFor4WTKRHQ = j2;
            }
            i3 |= i7;
        } else {
            jM3050contentColorFor4WTKRHQ = j2;
        }
        int i8 = i2 & 8;
        if (i8 == 0) {
            if ((i & 3072) == 0) {
                fM3822getElevationD9Ej5fM = f;
                i3 |= composerStartRestartGroup.changed(fM3822getElevationD9Ej5fM) ? 2048 : 1024;
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
                function4 = function3;
                if (composerStartRestartGroup.changedInstance(function4)) {
                    i4 = 131072;
                } else {
                    i4 = 65536;
                }
                i3 |= i4;
            } else {
                function4 = function3;
            }
            if ((74899 & i3) != 74898) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "115@5438L14,116@5494L11,118@5652L12");
                if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                    if (i5 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if ((i2 & 2) != 0) {
                        containerColor = NavigationBarDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        i3 &= -113;
                    }
                    if ((i2 & 4) != 0) {
                        jM3050contentColorFor4WTKRHQ = ColorSchemeKt.m3050contentColorFor4WTKRHQ(MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6), containerColor);
                        i3 &= -897;
                    }
                    if (i8 != 0) {
                        fM3822getElevationD9Ej5fM = NavigationBarDefaults.INSTANCE.m3822getElevationD9Ej5fM();
                    }
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                        modifier3 = companion;
                        windowInsets4 = NavigationBarDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                        j5 = containerColor;
                        j6 = jM3050contentColorFor4WTKRHQ;
                        f3 = fM3822getElevationD9Ej5fM;
                    } else {
                        modifier3 = companion;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1054099326, i3, -1, "androidx.compose.material3.NavigationBar (NavigationBar.kt:120)");
                    }
                    ProvidableCompositionLocal<NavigationBarOverride> providableCompositionLocal = LocalNavigationBarOverride;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume = composerStartRestartGroup.consume(providableCompositionLocal);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ((NavigationBarOverride) objConsume).NavigationBar(new NavigationBarOverrideScope(modifier3, j5, j6, f3, windowInsets4, function4, null), composerStartRestartGroup, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    j3 = j5;
                    j4 = j6;
                    f2 = f3;
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
                j6 = jM3050contentColorFor4WTKRHQ;
                f3 = fM3822getElevationD9Ej5fM;
                windowInsets4 = windowInsets2;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1054099326, i3, -1, "androidx.compose.material3.NavigationBar (NavigationBar.kt:120)");
                }
                ProvidableCompositionLocal<NavigationBarOverride> providableCompositionLocal2 = LocalNavigationBarOverride;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume2 = composerStartRestartGroup.consume(providableCompositionLocal2);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ((NavigationBarOverride) objConsume2).NavigationBar(new NavigationBarOverrideScope(modifier3, j5, j6, f3, windowInsets4, function4, null), composerStartRestartGroup, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                j3 = j5;
                j4 = j6;
                f2 = f3;
                windowInsets3 = windowInsets4;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                j3 = containerColor;
                j4 = jM3050contentColorFor4WTKRHQ;
                f2 = fM3822getElevationD9Ej5fM;
                windowInsets3 = windowInsets2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final Modifier modifier4 = modifier3;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda10
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return NavigationBarKt.NavigationBar_HsRjFd4$lambda$1(modifier4, j3, j4, f2, windowInsets3, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 3072;
        fM3822getElevationD9Ej5fM = f;
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
            function4 = function3;
            if (composerStartRestartGroup.changedInstance(function4)) {
                i4 = 131072;
            } else {
                i4 = 65536;
            }
            i3 |= i4;
        } else {
            function4 = function3;
        }
        if ((74899 & i3) != 74898) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "115@5438L14,116@5494L11,118@5652L12");
            if ((i & 1) != 0) {
                if (i5 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if ((i2 & 2) != 0) {
                    containerColor = NavigationBarDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                    i3 &= -113;
                }
                if ((i2 & 4) != 0) {
                    jM3050contentColorFor4WTKRHQ = ColorSchemeKt.m3050contentColorFor4WTKRHQ(MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6), containerColor);
                    i3 &= -897;
                }
                if (i8 != 0) {
                    fM3822getElevationD9Ej5fM = NavigationBarDefaults.INSTANCE.m3822getElevationD9Ej5fM();
                }
                if ((i2 & 16) != 0) {
                    i3 &= -57345;
                    modifier3 = companion;
                    windowInsets4 = NavigationBarDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                    j5 = containerColor;
                    j6 = jM3050contentColorFor4WTKRHQ;
                    f3 = fM3822getElevationD9Ej5fM;
                } else {
                    modifier3 = companion;
                    j5 = containerColor;
                    j6 = jM3050contentColorFor4WTKRHQ;
                    f3 = fM3822getElevationD9Ej5fM;
                    windowInsets4 = windowInsets2;
                }
            } else {
                if (i5 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if ((i2 & 2) != 0) {
                    containerColor = NavigationBarDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                    i3 &= -113;
                }
                if ((i2 & 4) != 0) {
                    jM3050contentColorFor4WTKRHQ = ColorSchemeKt.m3050contentColorFor4WTKRHQ(MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6), containerColor);
                    i3 &= -897;
                }
                if (i8 != 0) {
                    fM3822getElevationD9Ej5fM = NavigationBarDefaults.INSTANCE.m3822getElevationD9Ej5fM();
                }
                if ((i2 & 16) != 0) {
                    i3 &= -57345;
                    modifier3 = companion;
                    windowInsets4 = NavigationBarDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                    j5 = containerColor;
                    j6 = jM3050contentColorFor4WTKRHQ;
                    f3 = fM3822getElevationD9Ej5fM;
                } else {
                    modifier3 = companion;
                    j5 = containerColor;
                    j6 = jM3050contentColorFor4WTKRHQ;
                    f3 = fM3822getElevationD9Ej5fM;
                    windowInsets4 = windowInsets2;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1054099326, i3, -1, "androidx.compose.material3.NavigationBar (NavigationBar.kt:120)");
            }
            ProvidableCompositionLocal<NavigationBarOverride> providableCompositionLocal3 = LocalNavigationBarOverride;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume3 = composerStartRestartGroup.consume(providableCompositionLocal3);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ((NavigationBarOverride) objConsume3).NavigationBar(new NavigationBarOverrideScope(modifier3, j5, j6, f3, windowInsets4, function4, null), composerStartRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            j3 = j5;
            j4 = j6;
            f2 = f3;
            windowInsets3 = windowInsets4;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
            j3 = containerColor;
            j4 = jM3050contentColorFor4WTKRHQ;
            f2 = fM3822getElevationD9Ej5fM;
            windowInsets3 = windowInsets2;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda10
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return NavigationBarKt.NavigationBar_HsRjFd4$lambda$1(modifier5, j3, j4, f2, windowInsets3, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX WARN: Code duplicated, block: B:102:0x0127  */
    /* JADX WARN: Code duplicated, block: B:104:0x0137  */
    /* JADX WARN: Code duplicated, block: B:111:0x0159 A[PHI: r1 r3 r5 r6 r13 r15
      0x0159: PHI (r1v57 androidx.compose.material3.NavigationBarItemColors) = 
      (r1v25 androidx.compose.material3.NavigationBarItemColors)
      (r1v58 androidx.compose.material3.NavigationBarItemColors)
      (r1v60 androidx.compose.material3.NavigationBarItemColors)
     binds: [B:126:0x0186, B:110:0x0150, B:109:0x0145] A[DONT_GENERATE, DONT_INLINE]
      0x0159: PHI (r3v37 boolean) = (r3v8 boolean), (r3v38 boolean), (r3v39 boolean) binds: [B:126:0x0186, B:110:0x0150, B:109:0x0145] A[DONT_GENERATE, DONT_INLINE]
      0x0159: PHI (r5v29 kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) = 
      (r5v5 kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>)
      (r5v30 kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>)
      (r5v31 kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>)
     binds: [B:126:0x0186, B:110:0x0150, B:109:0x0145] A[DONT_GENERATE, DONT_INLINE]
      0x0159: PHI (r6v23 boolean) = (r6v8 boolean), (r6v24 boolean), (r6v25 boolean) binds: [B:126:0x0186, B:110:0x0150, B:109:0x0145] A[DONT_GENERATE, DONT_INLINE]
      0x0159: PHI (r13v9 androidx.compose.ui.Modifier) = (r13v6 androidx.compose.ui.Modifier), (r13v10 androidx.compose.ui.Modifier), (r13v11 androidx.compose.ui.Modifier) binds: [B:126:0x0186, B:110:0x0150, B:109:0x0145] A[DONT_GENERATE, DONT_INLINE]
      0x0159: PHI (r15v7 int) = (r15v5 int), (r15v8 int), (r15v9 int) binds: [B:126:0x0186, B:110:0x0150, B:109:0x0145] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:112:0x015c A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:113:0x015e  */
    /* JADX WARN: Code duplicated, block: B:115:0x0165  */
    /* JADX WARN: Code duplicated, block: B:117:0x0168  */
    /* JADX WARN: Code duplicated, block: B:119:0x016b  */
    /* JADX WARN: Code duplicated, block: B:120:0x016d  */
    /* JADX WARN: Code duplicated, block: B:123:0x0173  */
    /* JADX WARN: Code duplicated, block: B:124:0x017c  */
    /* JADX WARN: Code duplicated, block: B:127:0x0188  */
    /* JADX WARN: Code duplicated, block: B:130:0x0192  */
    /* JADX WARN: Code duplicated, block: B:133:0x019f  */
    /* JADX WARN: Code duplicated, block: B:135:0x01bc  */
    /* JADX WARN: Code duplicated, block: B:137:0x01ce  */
    /* JADX WARN: Code duplicated, block: B:140:0x01f8  */
    /* JADX WARN: Code duplicated, block: B:141:0x0207  */
    /* JADX WARN: Code duplicated, block: B:144:0x024a  */
    /* JADX WARN: Code duplicated, block: B:147:0x02aa  */
    /* JADX WARN: Code duplicated, block: B:150:0x02fe  */
    /* JADX WARN: Code duplicated, block: B:153:0x030a  */
    /* JADX WARN: Code duplicated, block: B:154:0x030e  */
    /* JADX WARN: Code duplicated, block: B:157:0x0333  */
    /* JADX WARN: Code duplicated, block: B:159:0x0341  */
    /* JADX WARN: Code duplicated, block: B:162:0x036e  */
    /* JADX WARN: Code duplicated, block: B:163:0x0371  */
    /* JADX WARN: Code duplicated, block: B:166:0x0395  */
    /* JADX WARN: Code duplicated, block: B:167:0x0398  */
    /* JADX WARN: Code duplicated, block: B:170:0x03d9  */
    /* JADX WARN: Code duplicated, block: B:172:0x03e1  */
    /* JADX WARN: Code duplicated, block: B:175:0x0403  */
    /* JADX WARN: Code duplicated, block: B:177:0x040b  */
    /* JADX WARN: Code duplicated, block: B:180:0x044a  */
    /* JADX WARN: Code duplicated, block: B:182:0x0452  */
    /* JADX WARN: Code duplicated, block: B:185:0x046f  */
    /* JADX WARN: Code duplicated, block: B:187:0x0477  */
    /* JADX WARN: Code duplicated, block: B:190:0x04b3  */
    /* JADX WARN: Code duplicated, block: B:192:0x04c1  */
    /* JADX WARN: Code duplicated, block: B:195:0x04d4  */
    /* JADX WARN: Code duplicated, block: B:197:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:44:0x007c  */
    /* JADX WARN: Code duplicated, block: B:45:0x007e  */
    /* JADX WARN: Code duplicated, block: B:47:0x0081  */
    /* JADX WARN: Code duplicated, block: B:49:0x0089  */
    /* JADX WARN: Code duplicated, block: B:50:0x008c  */
    /* JADX WARN: Code duplicated, block: B:55:0x0098  */
    /* JADX WARN: Code duplicated, block: B:56:0x009a  */
    /* JADX WARN: Code duplicated, block: B:58:0x009d  */
    /* JADX WARN: Code duplicated, block: B:60:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:61:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:66:0x00b4  */
    /* JADX WARN: Code duplicated, block: B:67:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:69:0x00bf  */
    /* JADX WARN: Code duplicated, block: B:71:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:72:0x00c8  */
    /* JADX WARN: Code duplicated, block: B:76:0x00d2  */
    /* JADX WARN: Code duplicated, block: B:78:0x00d6  */
    /* JADX WARN: Code duplicated, block: B:81:0x00e1 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:84:0x00e8  */
    /* JADX WARN: Code duplicated, block: B:87:0x00f0  */
    /* JADX WARN: Code duplicated, block: B:88:0x00f3  */
    /* JADX WARN: Code duplicated, block: B:90:0x00f7  */
    /* JADX WARN: Code duplicated, block: B:92:0x0101  */
    /* JADX WARN: Code duplicated, block: B:93:0x0104  */
    /* JADX WARN: Code duplicated, block: B:98:0x011b  */
    /* JADX WARN: Code duplicated, block: B:99:0x011d  */
    public static final void NavigationBarItem(final RowScope rowScope, final boolean z, final Function0<Unit> function0, final Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, boolean z2, Function2<? super Composer, ? super Integer, Unit> function3, boolean z3, NavigationBarItemColors navigationBarItemColors, MutableInteractionSource mutableInteractionSource, Composer composer, final int i, final int i2) {
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
        int i12;
        boolean z5;
        final boolean z6;
        final NavigationBarItemColors navigationBarItemColors2;
        final MutableInteractionSource mutableInteractionSource2;
        Composer composer2;
        final boolean z7;
        final Function2<? super Composer, ? super Integer, Unit> function5;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        boolean z8;
        NavigationBarItemColors navigationBarItemColorsColors;
        int i13;
        final boolean z9;
        int i14;
        final NavigationBarItemColors navigationBarItemColors3;
        Modifier modifier3;
        final boolean z10;
        final Function2<? super Composer, ? super Integer, Unit> function6;
        MutableInteractionSource mutableInteractionSource3;
        MutableInteractionSource mutableInteractionSource4;
        final FiniteAnimationSpec finiteAnimationSpecValue;
        NavigationBarItemColors navigationBarItemColors4;
        Function2<? super Composer, ? super Integer, Unit> function7;
        ComposableLambda composableLambda;
        Object objRememberedValue;
        final MutableIntState mutableIntState;
        MutableInteractionSource mutableInteractionSource5;
        Object objRememberedValue2;
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
        Object objRememberedValue3;
        Function0 function1;
        boolean zChanged2;
        Object objRememberedValue4;
        boolean zChanged3;
        Object objRememberedValue5;
        boolean zChanged4;
        Object objRememberedValue6;
        Object objRememberedValue7;
        Composer composerStartRestartGroup = composer.startRestartGroup(974293026);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(NavigationBarItem)N(selected,onClick,icon,modifier,enabled,label,alwaysShowLabel,colors,interactionSource)212@9724L14,214@9780L618,244@11048L33,258@11490L24,246@11087L3247:NavigationBar.kt#uh7d8r");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(rowScope) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(z) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function0) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function2) ? 2048 : 1024;
        }
        int i15 = i2 & 8;
        if (i15 == 0) {
            if ((i & 24576) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 16384 : 8192;
            }
            i4 = i2 & 16;
            if (i4 != 0) {
                if ((196608 & i) == 0) {
                    z4 = z2;
                    if (composerStartRestartGroup.changed(z4)) {
                        i5 = 131072;
                    } else {
                        i5 = 65536;
                    }
                    i3 |= i5;
                }
                i6 = i2 & 32;
                if (i6 != 0) {
                    if ((1572864 & i) == 0) {
                        function4 = function3;
                        if (composerStartRestartGroup.changedInstance(function4)) {
                            i7 = 1048576;
                        } else {
                            i7 = 524288;
                        }
                        i3 |= i7;
                    }
                    i8 = i2 & 64;
                    if (i8 != 0) {
                        i3 |= 12582912;
                    } else if ((i & 12582912) == 0) {
                        if (composerStartRestartGroup.changed(z3)) {
                            i9 = 8388608;
                        } else {
                            i9 = 4194304;
                        }
                        i3 |= i9;
                    }
                    if ((i & 100663296) != 0) {
                        i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(navigationBarItemColors)) ? 33554432 : 67108864;
                    }
                    i10 = i2 & 256;
                    if (i10 != 0) {
                        if ((i & 805306368) == 0) {
                            if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                                i11 = C.BUFFER_FLAG_LAST_SAMPLE;
                            } else {
                                i11 = 268435456;
                            }
                            i3 |= i11;
                        }
                        i12 = i3;
                        if ((i3 & 306783379) != 306783378) {
                            z5 = true;
                        } else {
                            z5 = false;
                        }
                        if (composerStartRestartGroup.shouldExecute(z5, i12 & 1)) {
                            composerStartRestartGroup.startDefaults();
                            ComposerKt.sourceInformation(composerStartRestartGroup, "206@9394L8");
                            if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                if (i15 != 0) {
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
                                    navigationBarItemColorsColors = NavigationBarItemDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                                    i13 = i12 & (-234881025);
                                } else {
                                    navigationBarItemColorsColors = navigationBarItemColors;
                                    i13 = i12;
                                }
                                z9 = z8;
                                i14 = i13;
                                navigationBarItemColors3 = navigationBarItemColorsColors;
                                modifier3 = modifier2;
                                z10 = z4;
                                function6 = function4;
                                if (i10 != 0) {
                                    mutableInteractionSource3 = null;
                                }
                                composerStartRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(974293026, i14, -1, "androidx.compose.material3.NavigationBarItem (NavigationBar.kt:208)");
                                }
                                if (mutableInteractionSource3 == null) {
                                    composerStartRestartGroup.startReplaceGroup(-224975399);
                                    ComposerKt.sourceInformation(composerStartRestartGroup, "210@9546L39");
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -7257271, "CC(remember):NavigationBar.kt#9igjgp");
                                    objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                                    if (objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                                        objRememberedValue7 = InteractionSourceKt.MutableInteractionSource();
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                                    }
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                    composerStartRestartGroup.endReplaceGroup();
                                    mutableInteractionSource4 = (MutableInteractionSource) objRememberedValue7;
                                } else {
                                    composerStartRestartGroup.startReplaceGroup(-7257922);
                                    composerStartRestartGroup.endReplaceGroup();
                                    mutableInteractionSource4 = mutableInteractionSource3;
                                }
                                finiteAnimationSpecValue = MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultEffects, composerStartRestartGroup, 6);
                                boolean z11 = z9;
                                ComposableLambda composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-876637252, true, new Function2() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda12
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return NavigationBarKt.NavigationBarItem$lambda$1(navigationBarItemColors3, z, z10, finiteAnimationSpecValue, function6, z9, function2, (Composer) obj, ((Integer) obj2).intValue());
                                    }
                                }, composerStartRestartGroup, 54);
                                if (function6 == null) {
                                    composerStartRestartGroup.startReplaceGroup(-224048562);
                                    composerStartRestartGroup.endReplaceGroup();
                                    navigationBarItemColors4 = navigationBarItemColors3;
                                    function7 = function6;
                                    composableLambda = null;
                                } else {
                                    composerStartRestartGroup.startReplaceGroup(-224048561);
                                    ComposerKt.sourceInformation(composerStartRestartGroup, "*229@10494L521");
                                    final NavigationBarItemColors navigationBarItemColors5 = navigationBarItemColors3;
                                    final boolean z12 = z10;
                                    final Function2<? super Composer, ? super Integer, Unit> function8 = function6;
                                    navigationBarItemColors4 = navigationBarItemColors5;
                                    function7 = function8;
                                    ComposableLambda composableLambdaRememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(802208206, true, new Function2() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda13
                                        @Override // kotlin.jvm.functions.Function2
                                        public final Object invoke(Object obj, Object obj2) {
                                            return NavigationBarKt.NavigationBarItem$lambda$2$0(navigationBarItemColors5, z, z12, finiteAnimationSpecValue, function8, (Composer) obj, ((Integer) obj2).intValue());
                                        }
                                    }, composerStartRestartGroup, 54);
                                    composerStartRestartGroup.endReplaceGroup();
                                    composableLambda = composableLambdaRememberComposableLambda2;
                                }
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -7209213, "CC(remember):NavigationBar.kt#9igjgp");
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue = SnapshotIntStateKt.mutableIntStateOf(0);
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                mutableIntState = (MutableIntState) objRememberedValue;
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                boolean z13 = z10;
                                Modifier modifier4 = modifier3;
                                mutableInteractionSource5 = mutableInteractionSource4;
                                Modifier modifierWeight$default = RowScope.weight$default(rowScope, SizeKt.m1251defaultMinSizeVpY3zN4$default(SelectableKt.m1533selectableO2vRcR0(modifier4, z, mutableInteractionSource5, null, z13, Role.m8825boximpl(Role.INSTANCE.m8839getTabo7Vup1c()), function0), 0.0f, NavigationBarHeight, 1, null), 1.0f, false, 2, null);
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -7195078, "CC(remember):NavigationBar.kt#9igjgp");
                                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue2 = new Function1() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda14
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj) {
                                            return NavigationBarKt.NavigationBarItem$lambda$6$0(mutableIntState, (IntSize) obj);
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                Modifier modifierOnSizeChanged = OnRemeasuredModifierKt.onSizeChanged(modifierWeight$default, (Function1) objRememberedValue2);
                                Alignment center = Alignment.INSTANCE.getCenter();
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, true);
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                                CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierOnSizeChanged);
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
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1565189072, "C266@11902L7,263@11672L252,272@12214L7,269@11987L249,277@12496L7,278@12539L274,286@12864L146,293@13225L273,301@13547L404,318@14216L32,319@14286L31,312@13961L367:NavigationBar.kt#uh7d8r");
                                if (z) {
                                    f = 1.0f;
                                } else {
                                    f = 0.0f;
                                }
                                final NavigationBarItemColors navigationBarItemColors6 = navigationBarItemColors4;
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
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1196463086, "CC(remember):NavigationBar.kt#9igjgp");
                                zChanged = composerStartRestartGroup.changed(density);
                                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                                if (!zChanged || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda15
                                        @Override // kotlin.jvm.functions.Function0
                                        public final Object invoke() {
                                            return NavigationBarKt.NavigationBarItem$lambda$7$0$0(density, mutableIntState);
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                                }
                                function1 = (Function0) objRememberedValue3;
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1196473358, "CC(remember):NavigationBar.kt#9igjgp");
                                zChanged2 = composerStartRestartGroup.changed(mutableInteractionSource5) | composerStartRestartGroup.changed(function1);
                                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                                if (!zChanged2 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue4 = new MappedInteractionSource(mutableInteractionSource5, function1);
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                                }
                                final MappedInteractionSource mappedInteractionSource = (MappedInteractionSource) objRememberedValue4;
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                ComposableLambda composableLambdaRememberComposableLambda3 = ComposableLambdaKt.rememberComposableLambda(-2082182507, true, new Function2() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda16
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return NavigationBarKt.NavigationBarItem$lambda$7$2(mappedInteractionSource, (Composer) obj, ((Integer) obj2).intValue());
                                    }
                                }, composerStartRestartGroup, 54);
                                ComposableLambda composableLambdaRememberComposableLambda4 = ComposableLambdaKt.rememberComposableLambda(-799524251, true, new Function2() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda1
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return NavigationBarKt.NavigationBarItem$lambda$7$3(stateAnimateFloatAsState, navigationBarItemColors6, (Composer) obj, ((Integer) obj2).intValue());
                                    }
                                }, composerStartRestartGroup, 54);
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1196516508, "CC(remember):NavigationBar.kt#9igjgp");
                                zChanged3 = composerStartRestartGroup.changed(stateAnimateFloatAsState);
                                objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                                if (!zChanged3 || objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue5 = new Function0() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda2
                                        @Override // kotlin.jvm.functions.Function0
                                        public final Object invoke() {
                                            return Float.valueOf(NavigationBarKt.NavigationBarItem$lambda$7$4$0(stateAnimateFloatAsState));
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                                }
                                Function0 function9 = (Function0) objRememberedValue5;
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1196518747, "CC(remember):NavigationBar.kt#9igjgp");
                                zChanged4 = composerStartRestartGroup.changed(stateAnimateFloatAsState2);
                                objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                                if (!zChanged4 || objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue6 = new Function0() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda3
                                        @Override // kotlin.jvm.functions.Function0
                                        public final Object invoke() {
                                            return Float.valueOf(NavigationBarKt.NavigationBarItem$lambda$7$5$0(stateAnimateFloatAsState2));
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                NavigationBarItemLayout(composableLambdaRememberComposableLambda3, composableLambdaRememberComposableLambda4, composableLambdaRememberComposableLambda, composableLambda, z11, function9, (Function0) objRememberedValue6, composerStartRestartGroup, ((i14 >> 9) & 57344) | 438);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                composerStartRestartGroup.endNode();
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                navigationBarItemColors2 = navigationBarItemColors6;
                                composer2 = composerStartRestartGroup;
                                z7 = z13;
                                mutableInteractionSource2 = mutableInteractionSource3;
                                modifier2 = modifier4;
                                z6 = z11;
                                function5 = function7;
                            } else {
                                composerStartRestartGroup.skipToGroupEnd();
                                if ((i2 & 128) != 0) {
                                    z9 = z3;
                                    i14 = i12 & (-234881025);
                                    modifier3 = modifier2;
                                    z10 = z4;
                                    function6 = function4;
                                    navigationBarItemColors3 = navigationBarItemColors;
                                } else {
                                    z9 = z3;
                                    navigationBarItemColors3 = navigationBarItemColors;
                                    i14 = i12;
                                    modifier3 = modifier2;
                                    z10 = z4;
                                    function6 = function4;
                                }
                            }
                            mutableInteractionSource3 = mutableInteractionSource;
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(974293026, i14, -1, "androidx.compose.material3.NavigationBarItem (NavigationBar.kt:208)");
                            }
                            if (mutableInteractionSource3 == null) {
                                composerStartRestartGroup.startReplaceGroup(-224975399);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "210@9546L39");
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -7257271, "CC(remember):NavigationBar.kt#9igjgp");
                                objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue7 = InteractionSourceKt.MutableInteractionSource();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                composerStartRestartGroup.endReplaceGroup();
                                mutableInteractionSource4 = (MutableInteractionSource) objRememberedValue7;
                            } else {
                                composerStartRestartGroup.startReplaceGroup(-7257922);
                                composerStartRestartGroup.endReplaceGroup();
                                mutableInteractionSource4 = mutableInteractionSource3;
                            }
                            finiteAnimationSpecValue = MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultEffects, composerStartRestartGroup, 6);
                            boolean z14 = z9;
                            ComposableLambda composableLambdaRememberComposableLambda5 = ComposableLambdaKt.rememberComposableLambda(-876637252, true, new Function2() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda12
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return NavigationBarKt.NavigationBarItem$lambda$1(navigationBarItemColors3, z, z10, finiteAnimationSpecValue, function6, z9, function2, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composerStartRestartGroup, 54);
                            if (function6 == null) {
                                composerStartRestartGroup.startReplaceGroup(-224048562);
                                composerStartRestartGroup.endReplaceGroup();
                                navigationBarItemColors4 = navigationBarItemColors3;
                                function7 = function6;
                                composableLambda = null;
                            } else {
                                composerStartRestartGroup.startReplaceGroup(-224048561);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "*229@10494L521");
                                final NavigationBarItemColors navigationBarItemColors7 = navigationBarItemColors3;
                                final boolean z15 = z10;
                                final Function2 function10 = function6;
                                navigationBarItemColors4 = navigationBarItemColors7;
                                function7 = function10;
                                ComposableLambda composableLambdaRememberComposableLambda6 = ComposableLambdaKt.rememberComposableLambda(802208206, true, new Function2() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda13
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return NavigationBarKt.NavigationBarItem$lambda$2$0(navigationBarItemColors7, z, z15, finiteAnimationSpecValue, function10, (Composer) obj, ((Integer) obj2).intValue());
                                    }
                                }, composerStartRestartGroup, 54);
                                composerStartRestartGroup.endReplaceGroup();
                                composableLambda = composableLambdaRememberComposableLambda6;
                            }
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -7209213, "CC(remember):NavigationBar.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = SnapshotIntStateKt.mutableIntStateOf(0);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            mutableIntState = (MutableIntState) objRememberedValue;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            boolean z16 = z10;
                            Modifier modifier5 = modifier3;
                            mutableInteractionSource5 = mutableInteractionSource4;
                            Modifier modifierWeight$default2 = RowScope.weight$default(rowScope, SizeKt.m1251defaultMinSizeVpY3zN4$default(SelectableKt.m1533selectableO2vRcR0(modifier5, z, mutableInteractionSource5, null, z16, Role.m8825boximpl(Role.INSTANCE.m8839getTabo7Vup1c()), function0), 0.0f, NavigationBarHeight, 1, null), 1.0f, false, 2, null);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -7195078, "CC(remember):NavigationBar.kt#9igjgp");
                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue2 = new Function1() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda14
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return NavigationBarKt.NavigationBarItem$lambda$6$0(mutableIntState, (IntSize) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            Modifier modifierOnSizeChanged2 = OnRemeasuredModifierKt.onSizeChanged(modifierWeight$default2, (Function1) objRememberedValue2);
                            Alignment center2 = Alignment.INSTANCE.getCenter();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(center2, true);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierOnSizeChanged2);
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
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1565189072, "C266@11902L7,263@11672L252,272@12214L7,269@11987L249,277@12496L7,278@12539L274,286@12864L146,293@13225L273,301@13547L404,318@14216L32,319@14286L31,312@13961L367:NavigationBar.kt#uh7d8r");
                            if (z) {
                                f = 1.0f;
                            } else {
                                f = 0.0f;
                            }
                            final NavigationBarItemColors navigationBarItemColors8 = navigationBarItemColors4;
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
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1196463086, "CC(remember):NavigationBar.kt#9igjgp");
                            zChanged = composerStartRestartGroup.changed(density);
                            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                            if (!zChanged) {
                                objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda15
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return NavigationBarKt.NavigationBarItem$lambda$7$0$0(density, mutableIntState);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            } else {
                                objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda15
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return NavigationBarKt.NavigationBarItem$lambda$7$0$0(density, mutableIntState);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            }
                            function1 = (Function0) objRememberedValue3;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1196473358, "CC(remember):NavigationBar.kt#9igjgp");
                            zChanged2 = composerStartRestartGroup.changed(mutableInteractionSource5) | composerStartRestartGroup.changed(function1);
                            objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                            if (!zChanged2) {
                                objRememberedValue4 = new MappedInteractionSource(mutableInteractionSource5, function1);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                            } else {
                                objRememberedValue4 = new MappedInteractionSource(mutableInteractionSource5, function1);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                            }
                            final MappedInteractionSource mappedInteractionSource2 = (MappedInteractionSource) objRememberedValue4;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ComposableLambda composableLambdaRememberComposableLambda7 = ComposableLambdaKt.rememberComposableLambda(-2082182507, true, new Function2() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda16
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return NavigationBarKt.NavigationBarItem$lambda$7$2(mappedInteractionSource2, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composerStartRestartGroup, 54);
                            ComposableLambda composableLambdaRememberComposableLambda8 = ComposableLambdaKt.rememberComposableLambda(-799524251, true, new Function2() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda1
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return NavigationBarKt.NavigationBarItem$lambda$7$3(stateAnimateFloatAsState, navigationBarItemColors8, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composerStartRestartGroup, 54);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1196516508, "CC(remember):NavigationBar.kt#9igjgp");
                            zChanged3 = composerStartRestartGroup.changed(stateAnimateFloatAsState);
                            objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                            if (!zChanged3) {
                                objRememberedValue5 = new Function0() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda2
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return Float.valueOf(NavigationBarKt.NavigationBarItem$lambda$7$4$0(stateAnimateFloatAsState));
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                            } else {
                                objRememberedValue5 = new Function0() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda2
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return Float.valueOf(NavigationBarKt.NavigationBarItem$lambda$7$4$0(stateAnimateFloatAsState));
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                            }
                            Function0 function11 = (Function0) objRememberedValue5;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1196518747, "CC(remember):NavigationBar.kt#9igjgp");
                            zChanged4 = composerStartRestartGroup.changed(stateAnimateFloatAsState2);
                            objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                            if (!zChanged4) {
                                objRememberedValue6 = new Function0() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda3
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return Float.valueOf(NavigationBarKt.NavigationBarItem$lambda$7$5$0(stateAnimateFloatAsState2));
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                            } else {
                                objRememberedValue6 = new Function0() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda3
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return Float.valueOf(NavigationBarKt.NavigationBarItem$lambda$7$5$0(stateAnimateFloatAsState2));
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            NavigationBarItemLayout(composableLambdaRememberComposableLambda7, composableLambdaRememberComposableLambda8, composableLambdaRememberComposableLambda5, composableLambda, z14, function11, (Function0) objRememberedValue6, composerStartRestartGroup, ((i14 >> 9) & 57344) | 438);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            composerStartRestartGroup.endNode();
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            navigationBarItemColors2 = navigationBarItemColors8;
                            composer2 = composerStartRestartGroup;
                            z7 = z16;
                            mutableInteractionSource2 = mutableInteractionSource3;
                            modifier2 = modifier5;
                            z6 = z14;
                            function5 = function7;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            z6 = z3;
                            navigationBarItemColors2 = navigationBarItemColors;
                            mutableInteractionSource2 = mutableInteractionSource;
                            composer2 = composerStartRestartGroup;
                            z7 = z4;
                            function5 = function4;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda4
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return NavigationBarKt.NavigationBarItem$lambda$8(rowScope, z, function0, function2, modifier2, z7, function5, z6, navigationBarItemColors2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                        }
                    }
                    i3 |= 805306368;
                    i12 = i3;
                    if ((i3 & 306783379) != 306783378) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z5, i12 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "206@9394L8");
                        if ((i & 1) != 0) {
                            if (i15 != 0) {
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
                                navigationBarItemColorsColors = NavigationBarItemDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                                i13 = i12 & (-234881025);
                            } else {
                                navigationBarItemColorsColors = navigationBarItemColors;
                                i13 = i12;
                            }
                            z9 = z8;
                            i14 = i13;
                            navigationBarItemColors3 = navigationBarItemColorsColors;
                            modifier3 = modifier2;
                            z10 = z4;
                            function6 = function4;
                            if (i10 != 0) {
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                        } else {
                            if (i15 != 0) {
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
                                navigationBarItemColorsColors = NavigationBarItemDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                                i13 = i12 & (-234881025);
                            } else {
                                navigationBarItemColorsColors = navigationBarItemColors;
                                i13 = i12;
                            }
                            z9 = z8;
                            i14 = i13;
                            navigationBarItemColors3 = navigationBarItemColorsColors;
                            modifier3 = modifier2;
                            z10 = z4;
                            function6 = function4;
                            if (i10 != 0) {
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(974293026, i14, -1, "androidx.compose.material3.NavigationBarItem (NavigationBar.kt:208)");
                        }
                        if (mutableInteractionSource3 == null) {
                            composerStartRestartGroup.startReplaceGroup(-224975399);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "210@9546L39");
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -7257271, "CC(remember):NavigationBar.kt#9igjgp");
                            objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue7 = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            composerStartRestartGroup.endReplaceGroup();
                            mutableInteractionSource4 = (MutableInteractionSource) objRememberedValue7;
                        } else {
                            composerStartRestartGroup.startReplaceGroup(-7257922);
                            composerStartRestartGroup.endReplaceGroup();
                            mutableInteractionSource4 = mutableInteractionSource3;
                        }
                        finiteAnimationSpecValue = MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultEffects, composerStartRestartGroup, 6);
                        boolean z17 = z9;
                        ComposableLambda composableLambdaRememberComposableLambda9 = ComposableLambdaKt.rememberComposableLambda(-876637252, true, new Function2() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda12
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return NavigationBarKt.NavigationBarItem$lambda$1(navigationBarItemColors3, z, z10, finiteAnimationSpecValue, function6, z9, function2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                        if (function6 == null) {
                            composerStartRestartGroup.startReplaceGroup(-224048562);
                            composerStartRestartGroup.endReplaceGroup();
                            navigationBarItemColors4 = navigationBarItemColors3;
                            function7 = function6;
                            composableLambda = null;
                        } else {
                            composerStartRestartGroup.startReplaceGroup(-224048561);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "*229@10494L521");
                            final NavigationBarItemColors navigationBarItemColors9 = navigationBarItemColors3;
                            final boolean z18 = z10;
                            final Function2 function12 = function6;
                            navigationBarItemColors4 = navigationBarItemColors9;
                            function7 = function12;
                            ComposableLambda composableLambdaRememberComposableLambda10 = ComposableLambdaKt.rememberComposableLambda(802208206, true, new Function2() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda13
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return NavigationBarKt.NavigationBarItem$lambda$2$0(navigationBarItemColors9, z, z18, finiteAnimationSpecValue, function12, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composerStartRestartGroup, 54);
                            composerStartRestartGroup.endReplaceGroup();
                            composableLambda = composableLambdaRememberComposableLambda10;
                        }
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -7209213, "CC(remember):NavigationBar.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = SnapshotIntStateKt.mutableIntStateOf(0);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        mutableIntState = (MutableIntState) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        boolean z19 = z10;
                        Modifier modifier6 = modifier3;
                        mutableInteractionSource5 = mutableInteractionSource4;
                        Modifier modifierWeight$default3 = RowScope.weight$default(rowScope, SizeKt.m1251defaultMinSizeVpY3zN4$default(SelectableKt.m1533selectableO2vRcR0(modifier6, z, mutableInteractionSource5, null, z19, Role.m8825boximpl(Role.INSTANCE.m8839getTabo7Vup1c()), function0), 0.0f, NavigationBarHeight, 1, null), 1.0f, false, 2, null);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -7195078, "CC(remember):NavigationBar.kt#9igjgp");
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue2 = new Function1() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda14
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return NavigationBarKt.NavigationBarItem$lambda$6$0(mutableIntState, (IntSize) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        Modifier modifierOnSizeChanged3 = OnRemeasuredModifierKt.onSizeChanged(modifierWeight$default3, (Function1) objRememberedValue2);
                        Alignment center3 = Alignment.INSTANCE.getCenter();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(center3, true);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                        CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierOnSizeChanged3);
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
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1565189072, "C266@11902L7,263@11672L252,272@12214L7,269@11987L249,277@12496L7,278@12539L274,286@12864L146,293@13225L273,301@13547L404,318@14216L32,319@14286L31,312@13961L367:NavigationBar.kt#uh7d8r");
                        if (z) {
                            f = 1.0f;
                        } else {
                            f = 0.0f;
                        }
                        final NavigationBarItemColors navigationBarItemColors10 = navigationBarItemColors4;
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
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1196463086, "CC(remember):NavigationBar.kt#9igjgp");
                        zChanged = composerStartRestartGroup.changed(density);
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged) {
                            objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda15
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return NavigationBarKt.NavigationBarItem$lambda$7$0$0(density, mutableIntState);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        } else {
                            objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda15
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return NavigationBarKt.NavigationBarItem$lambda$7$0$0(density, mutableIntState);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        function1 = (Function0) objRememberedValue3;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1196473358, "CC(remember):NavigationBar.kt#9igjgp");
                        zChanged2 = composerStartRestartGroup.changed(mutableInteractionSource5) | composerStartRestartGroup.changed(function1);
                        objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged2) {
                            objRememberedValue4 = new MappedInteractionSource(mutableInteractionSource5, function1);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        } else {
                            objRememberedValue4 = new MappedInteractionSource(mutableInteractionSource5, function1);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        }
                        final MappedInteractionSource mappedInteractionSource3 = (MappedInteractionSource) objRememberedValue4;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposableLambda composableLambdaRememberComposableLambda11 = ComposableLambdaKt.rememberComposableLambda(-2082182507, true, new Function2() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda16
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return NavigationBarKt.NavigationBarItem$lambda$7$2(mappedInteractionSource3, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                        ComposableLambda composableLambdaRememberComposableLambda12 = ComposableLambdaKt.rememberComposableLambda(-799524251, true, new Function2() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return NavigationBarKt.NavigationBarItem$lambda$7$3(stateAnimateFloatAsState, navigationBarItemColors10, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1196516508, "CC(remember):NavigationBar.kt#9igjgp");
                        zChanged3 = composerStartRestartGroup.changed(stateAnimateFloatAsState);
                        objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged3) {
                            objRememberedValue5 = new Function0() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda2
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return Float.valueOf(NavigationBarKt.NavigationBarItem$lambda$7$4$0(stateAnimateFloatAsState));
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                        } else {
                            objRememberedValue5 = new Function0() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda2
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return Float.valueOf(NavigationBarKt.NavigationBarItem$lambda$7$4$0(stateAnimateFloatAsState));
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                        }
                        Function0 function13 = (Function0) objRememberedValue5;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1196518747, "CC(remember):NavigationBar.kt#9igjgp");
                        zChanged4 = composerStartRestartGroup.changed(stateAnimateFloatAsState2);
                        objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged4) {
                            objRememberedValue6 = new Function0() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda3
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return Float.valueOf(NavigationBarKt.NavigationBarItem$lambda$7$5$0(stateAnimateFloatAsState2));
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                        } else {
                            objRememberedValue6 = new Function0() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda3
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return Float.valueOf(NavigationBarKt.NavigationBarItem$lambda$7$5$0(stateAnimateFloatAsState2));
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        NavigationBarItemLayout(composableLambdaRememberComposableLambda11, composableLambdaRememberComposableLambda12, composableLambdaRememberComposableLambda9, composableLambda, z17, function13, (Function0) objRememberedValue6, composerStartRestartGroup, ((i14 >> 9) & 57344) | 438);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        navigationBarItemColors2 = navigationBarItemColors10;
                        composer2 = composerStartRestartGroup;
                        z7 = z19;
                        mutableInteractionSource2 = mutableInteractionSource3;
                        modifier2 = modifier6;
                        z6 = z17;
                        function5 = function7;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        z6 = z3;
                        navigationBarItemColors2 = navigationBarItemColors;
                        mutableInteractionSource2 = mutableInteractionSource;
                        composer2 = composerStartRestartGroup;
                        z7 = z4;
                        function5 = function4;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return NavigationBarKt.NavigationBarItem$lambda$8(rowScope, z, function0, function2, modifier2, z7, function5, z6, navigationBarItemColors2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= 1572864;
                function4 = function3;
                i8 = i2 & 64;
                if (i8 != 0) {
                    i3 |= 12582912;
                } else if ((i & 12582912) == 0) {
                    if (composerStartRestartGroup.changed(z3)) {
                        i9 = 8388608;
                    } else {
                        i9 = 4194304;
                    }
                    i3 |= i9;
                }
                if ((i & 100663296) != 0) {
                    i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(navigationBarItemColors)) ? 33554432 : 67108864;
                }
                i10 = i2 & 256;
                if (i10 != 0) {
                    if ((i & 805306368) == 0) {
                        if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                            i11 = C.BUFFER_FLAG_LAST_SAMPLE;
                        } else {
                            i11 = 268435456;
                        }
                        i3 |= i11;
                    }
                    i12 = i3;
                    if ((i3 & 306783379) != 306783378) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z5, i12 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "206@9394L8");
                        if ((i & 1) != 0) {
                            if (i15 != 0) {
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
                                navigationBarItemColorsColors = NavigationBarItemDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                                i13 = i12 & (-234881025);
                            } else {
                                navigationBarItemColorsColors = navigationBarItemColors;
                                i13 = i12;
                            }
                            z9 = z8;
                            i14 = i13;
                            navigationBarItemColors3 = navigationBarItemColorsColors;
                            modifier3 = modifier2;
                            z10 = z4;
                            function6 = function4;
                            if (i10 != 0) {
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                        } else {
                            if (i15 != 0) {
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
                                navigationBarItemColorsColors = NavigationBarItemDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                                i13 = i12 & (-234881025);
                            } else {
                                navigationBarItemColorsColors = navigationBarItemColors;
                                i13 = i12;
                            }
                            z9 = z8;
                            i14 = i13;
                            navigationBarItemColors3 = navigationBarItemColorsColors;
                            modifier3 = modifier2;
                            z10 = z4;
                            function6 = function4;
                            if (i10 != 0) {
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(974293026, i14, -1, "androidx.compose.material3.NavigationBarItem (NavigationBar.kt:208)");
                        }
                        if (mutableInteractionSource3 == null) {
                            composerStartRestartGroup.startReplaceGroup(-224975399);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "210@9546L39");
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -7257271, "CC(remember):NavigationBar.kt#9igjgp");
                            objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue7 = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            composerStartRestartGroup.endReplaceGroup();
                            mutableInteractionSource4 = (MutableInteractionSource) objRememberedValue7;
                        } else {
                            composerStartRestartGroup.startReplaceGroup(-7257922);
                            composerStartRestartGroup.endReplaceGroup();
                            mutableInteractionSource4 = mutableInteractionSource3;
                        }
                        finiteAnimationSpecValue = MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultEffects, composerStartRestartGroup, 6);
                        boolean z110 = z9;
                        ComposableLambda composableLambdaRememberComposableLambda13 = ComposableLambdaKt.rememberComposableLambda(-876637252, true, new Function2() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda12
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return NavigationBarKt.NavigationBarItem$lambda$1(navigationBarItemColors3, z, z10, finiteAnimationSpecValue, function6, z9, function2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                        if (function6 == null) {
                            composerStartRestartGroup.startReplaceGroup(-224048562);
                            composerStartRestartGroup.endReplaceGroup();
                            navigationBarItemColors4 = navigationBarItemColors3;
                            function7 = function6;
                            composableLambda = null;
                        } else {
                            composerStartRestartGroup.startReplaceGroup(-224048561);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "*229@10494L521");
                            final NavigationBarItemColors navigationBarItemColors11 = navigationBarItemColors3;
                            final boolean z111 = z10;
                            final Function2 function14 = function6;
                            navigationBarItemColors4 = navigationBarItemColors11;
                            function7 = function14;
                            ComposableLambda composableLambdaRememberComposableLambda14 = ComposableLambdaKt.rememberComposableLambda(802208206, true, new Function2() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda13
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return NavigationBarKt.NavigationBarItem$lambda$2$0(navigationBarItemColors11, z, z111, finiteAnimationSpecValue, function14, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composerStartRestartGroup, 54);
                            composerStartRestartGroup.endReplaceGroup();
                            composableLambda = composableLambdaRememberComposableLambda14;
                        }
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -7209213, "CC(remember):NavigationBar.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = SnapshotIntStateKt.mutableIntStateOf(0);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        mutableIntState = (MutableIntState) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        boolean z112 = z10;
                        Modifier modifier7 = modifier3;
                        mutableInteractionSource5 = mutableInteractionSource4;
                        Modifier modifierWeight$default4 = RowScope.weight$default(rowScope, SizeKt.m1251defaultMinSizeVpY3zN4$default(SelectableKt.m1533selectableO2vRcR0(modifier7, z, mutableInteractionSource5, null, z112, Role.m8825boximpl(Role.INSTANCE.m8839getTabo7Vup1c()), function0), 0.0f, NavigationBarHeight, 1, null), 1.0f, false, 2, null);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -7195078, "CC(remember):NavigationBar.kt#9igjgp");
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue2 = new Function1() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda14
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return NavigationBarKt.NavigationBarItem$lambda$6$0(mutableIntState, (IntSize) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        Modifier modifierOnSizeChanged4 = OnRemeasuredModifierKt.onSizeChanged(modifierWeight$default4, (Function1) objRememberedValue2);
                        Alignment center4 = Alignment.INSTANCE.getCenter();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy4 = BoxKt.maybeCachedBoxMeasurePolicy(center4, true);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                        CompositionLocalMap currentCompositionLocalMap4 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierOnSizeChanged4);
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
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1565189072, "C266@11902L7,263@11672L252,272@12214L7,269@11987L249,277@12496L7,278@12539L274,286@12864L146,293@13225L273,301@13547L404,318@14216L32,319@14286L31,312@13961L367:NavigationBar.kt#uh7d8r");
                        if (z) {
                            f = 1.0f;
                        } else {
                            f = 0.0f;
                        }
                        final NavigationBarItemColors navigationBarItemColors12 = navigationBarItemColors4;
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
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1196463086, "CC(remember):NavigationBar.kt#9igjgp");
                        zChanged = composerStartRestartGroup.changed(density);
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged) {
                            objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda15
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return NavigationBarKt.NavigationBarItem$lambda$7$0$0(density, mutableIntState);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        } else {
                            objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda15
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return NavigationBarKt.NavigationBarItem$lambda$7$0$0(density, mutableIntState);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        function1 = (Function0) objRememberedValue3;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1196473358, "CC(remember):NavigationBar.kt#9igjgp");
                        zChanged2 = composerStartRestartGroup.changed(mutableInteractionSource5) | composerStartRestartGroup.changed(function1);
                        objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged2) {
                            objRememberedValue4 = new MappedInteractionSource(mutableInteractionSource5, function1);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        } else {
                            objRememberedValue4 = new MappedInteractionSource(mutableInteractionSource5, function1);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        }
                        final MappedInteractionSource mappedInteractionSource4 = (MappedInteractionSource) objRememberedValue4;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposableLambda composableLambdaRememberComposableLambda15 = ComposableLambdaKt.rememberComposableLambda(-2082182507, true, new Function2() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda16
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return NavigationBarKt.NavigationBarItem$lambda$7$2(mappedInteractionSource4, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                        ComposableLambda composableLambdaRememberComposableLambda16 = ComposableLambdaKt.rememberComposableLambda(-799524251, true, new Function2() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return NavigationBarKt.NavigationBarItem$lambda$7$3(stateAnimateFloatAsState, navigationBarItemColors12, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1196516508, "CC(remember):NavigationBar.kt#9igjgp");
                        zChanged3 = composerStartRestartGroup.changed(stateAnimateFloatAsState);
                        objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged3) {
                            objRememberedValue5 = new Function0() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda2
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return Float.valueOf(NavigationBarKt.NavigationBarItem$lambda$7$4$0(stateAnimateFloatAsState));
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                        } else {
                            objRememberedValue5 = new Function0() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda2
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return Float.valueOf(NavigationBarKt.NavigationBarItem$lambda$7$4$0(stateAnimateFloatAsState));
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                        }
                        Function0 function15 = (Function0) objRememberedValue5;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1196518747, "CC(remember):NavigationBar.kt#9igjgp");
                        zChanged4 = composerStartRestartGroup.changed(stateAnimateFloatAsState2);
                        objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged4) {
                            objRememberedValue6 = new Function0() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda3
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return Float.valueOf(NavigationBarKt.NavigationBarItem$lambda$7$5$0(stateAnimateFloatAsState2));
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                        } else {
                            objRememberedValue6 = new Function0() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda3
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return Float.valueOf(NavigationBarKt.NavigationBarItem$lambda$7$5$0(stateAnimateFloatAsState2));
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        NavigationBarItemLayout(composableLambdaRememberComposableLambda15, composableLambdaRememberComposableLambda16, composableLambdaRememberComposableLambda13, composableLambda, z110, function15, (Function0) objRememberedValue6, composerStartRestartGroup, ((i14 >> 9) & 57344) | 438);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        navigationBarItemColors2 = navigationBarItemColors12;
                        composer2 = composerStartRestartGroup;
                        z7 = z112;
                        mutableInteractionSource2 = mutableInteractionSource3;
                        modifier2 = modifier7;
                        z6 = z110;
                        function5 = function7;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        z6 = z3;
                        navigationBarItemColors2 = navigationBarItemColors;
                        mutableInteractionSource2 = mutableInteractionSource;
                        composer2 = composerStartRestartGroup;
                        z7 = z4;
                        function5 = function4;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return NavigationBarKt.NavigationBarItem$lambda$8(rowScope, z, function0, function2, modifier2, z7, function5, z6, navigationBarItemColors2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= 805306368;
                i12 = i3;
                if ((i3 & 306783379) != 306783378) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z5, i12 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "206@9394L8");
                    if ((i & 1) != 0) {
                        if (i15 != 0) {
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
                            navigationBarItemColorsColors = NavigationBarItemDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                            i13 = i12 & (-234881025);
                        } else {
                            navigationBarItemColorsColors = navigationBarItemColors;
                            i13 = i12;
                        }
                        z9 = z8;
                        i14 = i13;
                        navigationBarItemColors3 = navigationBarItemColorsColors;
                        modifier3 = modifier2;
                        z10 = z4;
                        function6 = function4;
                        if (i10 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                    } else {
                        if (i15 != 0) {
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
                            navigationBarItemColorsColors = NavigationBarItemDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                            i13 = i12 & (-234881025);
                        } else {
                            navigationBarItemColorsColors = navigationBarItemColors;
                            i13 = i12;
                        }
                        z9 = z8;
                        i14 = i13;
                        navigationBarItemColors3 = navigationBarItemColorsColors;
                        modifier3 = modifier2;
                        z10 = z4;
                        function6 = function4;
                        if (i10 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(974293026, i14, -1, "androidx.compose.material3.NavigationBarItem (NavigationBar.kt:208)");
                    }
                    if (mutableInteractionSource3 == null) {
                        composerStartRestartGroup.startReplaceGroup(-224975399);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "210@9546L39");
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -7257271, "CC(remember):NavigationBar.kt#9igjgp");
                        objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue7 = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.endReplaceGroup();
                        mutableInteractionSource4 = (MutableInteractionSource) objRememberedValue7;
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-7257922);
                        composerStartRestartGroup.endReplaceGroup();
                        mutableInteractionSource4 = mutableInteractionSource3;
                    }
                    finiteAnimationSpecValue = MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultEffects, composerStartRestartGroup, 6);
                    boolean z113 = z9;
                    ComposableLambda composableLambdaRememberComposableLambda17 = ComposableLambdaKt.rememberComposableLambda(-876637252, true, new Function2() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda12
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return NavigationBarKt.NavigationBarItem$lambda$1(navigationBarItemColors3, z, z10, finiteAnimationSpecValue, function6, z9, function2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54);
                    if (function6 == null) {
                        composerStartRestartGroup.startReplaceGroup(-224048562);
                        composerStartRestartGroup.endReplaceGroup();
                        navigationBarItemColors4 = navigationBarItemColors3;
                        function7 = function6;
                        composableLambda = null;
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-224048561);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "*229@10494L521");
                        final NavigationBarItemColors navigationBarItemColors13 = navigationBarItemColors3;
                        final boolean z114 = z10;
                        final Function2 function16 = function6;
                        navigationBarItemColors4 = navigationBarItemColors13;
                        function7 = function16;
                        ComposableLambda composableLambdaRememberComposableLambda18 = ComposableLambdaKt.rememberComposableLambda(802208206, true, new Function2() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda13
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return NavigationBarKt.NavigationBarItem$lambda$2$0(navigationBarItemColors13, z, z114, finiteAnimationSpecValue, function16, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                        composerStartRestartGroup.endReplaceGroup();
                        composableLambda = composableLambdaRememberComposableLambda18;
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -7209213, "CC(remember):NavigationBar.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = SnapshotIntStateKt.mutableIntStateOf(0);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    mutableIntState = (MutableIntState) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    boolean z115 = z10;
                    Modifier modifier8 = modifier3;
                    mutableInteractionSource5 = mutableInteractionSource4;
                    Modifier modifierWeight$default5 = RowScope.weight$default(rowScope, SizeKt.m1251defaultMinSizeVpY3zN4$default(SelectableKt.m1533selectableO2vRcR0(modifier8, z, mutableInteractionSource5, null, z115, Role.m8825boximpl(Role.INSTANCE.m8839getTabo7Vup1c()), function0), 0.0f, NavigationBarHeight, 1, null), 1.0f, false, 2, null);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -7195078, "CC(remember):NavigationBar.kt#9igjgp");
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = new Function1() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda14
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return NavigationBarKt.NavigationBarItem$lambda$6$0(mutableIntState, (IntSize) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Modifier modifierOnSizeChanged5 = OnRemeasuredModifierKt.onSizeChanged(modifierWeight$default5, (Function1) objRememberedValue2);
                    Alignment center5 = Alignment.INSTANCE.getCenter();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy5 = BoxKt.maybeCachedBoxMeasurePolicy(center5, true);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap5 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier5 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierOnSizeChanged5);
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
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1565189072, "C266@11902L7,263@11672L252,272@12214L7,269@11987L249,277@12496L7,278@12539L274,286@12864L146,293@13225L273,301@13547L404,318@14216L32,319@14286L31,312@13961L367:NavigationBar.kt#uh7d8r");
                    if (z) {
                        f = 1.0f;
                    } else {
                        f = 0.0f;
                    }
                    final NavigationBarItemColors navigationBarItemColors14 = navigationBarItemColors4;
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
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1196463086, "CC(remember):NavigationBar.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(density);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda15
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return NavigationBarKt.NavigationBarItem$lambda$7$0$0(density, mutableIntState);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda15
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return NavigationBarKt.NavigationBarItem$lambda$7$0$0(density, mutableIntState);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    function1 = (Function0) objRememberedValue3;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1196473358, "CC(remember):NavigationBar.kt#9igjgp");
                    zChanged2 = composerStartRestartGroup.changed(mutableInteractionSource5) | composerStartRestartGroup.changed(function1);
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged2) {
                        objRememberedValue4 = new MappedInteractionSource(mutableInteractionSource5, function1);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    } else {
                        objRememberedValue4 = new MappedInteractionSource(mutableInteractionSource5, function1);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    final MappedInteractionSource mappedInteractionSource5 = (MappedInteractionSource) objRememberedValue4;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposableLambda composableLambdaRememberComposableLambda19 = ComposableLambdaKt.rememberComposableLambda(-2082182507, true, new Function2() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda16
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return NavigationBarKt.NavigationBarItem$lambda$7$2(mappedInteractionSource5, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54);
                    ComposableLambda composableLambdaRememberComposableLambda110 = ComposableLambdaKt.rememberComposableLambda(-799524251, true, new Function2() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return NavigationBarKt.NavigationBarItem$lambda$7$3(stateAnimateFloatAsState, navigationBarItemColors14, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1196516508, "CC(remember):NavigationBar.kt#9igjgp");
                    zChanged3 = composerStartRestartGroup.changed(stateAnimateFloatAsState);
                    objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged3) {
                        objRememberedValue5 = new Function0() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Float.valueOf(NavigationBarKt.NavigationBarItem$lambda$7$4$0(stateAnimateFloatAsState));
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                    } else {
                        objRememberedValue5 = new Function0() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Float.valueOf(NavigationBarKt.NavigationBarItem$lambda$7$4$0(stateAnimateFloatAsState));
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                    }
                    Function0 function17 = (Function0) objRememberedValue5;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1196518747, "CC(remember):NavigationBar.kt#9igjgp");
                    zChanged4 = composerStartRestartGroup.changed(stateAnimateFloatAsState2);
                    objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged4) {
                        objRememberedValue6 = new Function0() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Float.valueOf(NavigationBarKt.NavigationBarItem$lambda$7$5$0(stateAnimateFloatAsState2));
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                    } else {
                        objRememberedValue6 = new Function0() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Float.valueOf(NavigationBarKt.NavigationBarItem$lambda$7$5$0(stateAnimateFloatAsState2));
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    NavigationBarItemLayout(composableLambdaRememberComposableLambda19, composableLambdaRememberComposableLambda110, composableLambdaRememberComposableLambda17, composableLambda, z113, function17, (Function0) objRememberedValue6, composerStartRestartGroup, ((i14 >> 9) & 57344) | 438);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    navigationBarItemColors2 = navigationBarItemColors14;
                    composer2 = composerStartRestartGroup;
                    z7 = z115;
                    mutableInteractionSource2 = mutableInteractionSource3;
                    modifier2 = modifier8;
                    z6 = z113;
                    function5 = function7;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    z6 = z3;
                    navigationBarItemColors2 = navigationBarItemColors;
                    mutableInteractionSource2 = mutableInteractionSource;
                    composer2 = composerStartRestartGroup;
                    z7 = z4;
                    function5 = function4;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return NavigationBarKt.NavigationBarItem$lambda$8(rowScope, z, function0, function2, modifier2, z7, function5, z6, navigationBarItemColors2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            z4 = z2;
            i6 = i2 & 32;
            if (i6 != 0) {
                if ((1572864 & i) == 0) {
                    function4 = function3;
                    if (composerStartRestartGroup.changedInstance(function4)) {
                        i7 = 1048576;
                    } else {
                        i7 = 524288;
                    }
                    i3 |= i7;
                }
                i8 = i2 & 64;
                if (i8 != 0) {
                    i3 |= 12582912;
                } else if ((i & 12582912) == 0) {
                    if (composerStartRestartGroup.changed(z3)) {
                        i9 = 8388608;
                    } else {
                        i9 = 4194304;
                    }
                    i3 |= i9;
                }
                if ((i & 100663296) != 0) {
                    i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(navigationBarItemColors)) ? 33554432 : 67108864;
                }
                i10 = i2 & 256;
                if (i10 != 0) {
                    if ((i & 805306368) == 0) {
                        if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                            i11 = C.BUFFER_FLAG_LAST_SAMPLE;
                        } else {
                            i11 = 268435456;
                        }
                        i3 |= i11;
                    }
                    i12 = i3;
                    if ((i3 & 306783379) != 306783378) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z5, i12 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "206@9394L8");
                        if ((i & 1) != 0) {
                            if (i15 != 0) {
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
                                navigationBarItemColorsColors = NavigationBarItemDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                                i13 = i12 & (-234881025);
                            } else {
                                navigationBarItemColorsColors = navigationBarItemColors;
                                i13 = i12;
                            }
                            z9 = z8;
                            i14 = i13;
                            navigationBarItemColors3 = navigationBarItemColorsColors;
                            modifier3 = modifier2;
                            z10 = z4;
                            function6 = function4;
                            if (i10 != 0) {
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                        } else {
                            if (i15 != 0) {
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
                                navigationBarItemColorsColors = NavigationBarItemDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                                i13 = i12 & (-234881025);
                            } else {
                                navigationBarItemColorsColors = navigationBarItemColors;
                                i13 = i12;
                            }
                            z9 = z8;
                            i14 = i13;
                            navigationBarItemColors3 = navigationBarItemColorsColors;
                            modifier3 = modifier2;
                            z10 = z4;
                            function6 = function4;
                            if (i10 != 0) {
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(974293026, i14, -1, "androidx.compose.material3.NavigationBarItem (NavigationBar.kt:208)");
                        }
                        if (mutableInteractionSource3 == null) {
                            composerStartRestartGroup.startReplaceGroup(-224975399);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "210@9546L39");
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -7257271, "CC(remember):NavigationBar.kt#9igjgp");
                            objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue7 = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            composerStartRestartGroup.endReplaceGroup();
                            mutableInteractionSource4 = (MutableInteractionSource) objRememberedValue7;
                        } else {
                            composerStartRestartGroup.startReplaceGroup(-7257922);
                            composerStartRestartGroup.endReplaceGroup();
                            mutableInteractionSource4 = mutableInteractionSource3;
                        }
                        finiteAnimationSpecValue = MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultEffects, composerStartRestartGroup, 6);
                        boolean z116 = z9;
                        ComposableLambda composableLambdaRememberComposableLambda111 = ComposableLambdaKt.rememberComposableLambda(-876637252, true, new Function2() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda12
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return NavigationBarKt.NavigationBarItem$lambda$1(navigationBarItemColors3, z, z10, finiteAnimationSpecValue, function6, z9, function2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                        if (function6 == null) {
                            composerStartRestartGroup.startReplaceGroup(-224048562);
                            composerStartRestartGroup.endReplaceGroup();
                            navigationBarItemColors4 = navigationBarItemColors3;
                            function7 = function6;
                            composableLambda = null;
                        } else {
                            composerStartRestartGroup.startReplaceGroup(-224048561);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "*229@10494L521");
                            final NavigationBarItemColors navigationBarItemColors15 = navigationBarItemColors3;
                            final boolean z117 = z10;
                            final Function2 function18 = function6;
                            navigationBarItemColors4 = navigationBarItemColors15;
                            function7 = function18;
                            ComposableLambda composableLambdaRememberComposableLambda112 = ComposableLambdaKt.rememberComposableLambda(802208206, true, new Function2() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda13
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return NavigationBarKt.NavigationBarItem$lambda$2$0(navigationBarItemColors15, z, z117, finiteAnimationSpecValue, function18, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composerStartRestartGroup, 54);
                            composerStartRestartGroup.endReplaceGroup();
                            composableLambda = composableLambdaRememberComposableLambda112;
                        }
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -7209213, "CC(remember):NavigationBar.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = SnapshotIntStateKt.mutableIntStateOf(0);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        mutableIntState = (MutableIntState) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        boolean z118 = z10;
                        Modifier modifier9 = modifier3;
                        mutableInteractionSource5 = mutableInteractionSource4;
                        Modifier modifierWeight$default6 = RowScope.weight$default(rowScope, SizeKt.m1251defaultMinSizeVpY3zN4$default(SelectableKt.m1533selectableO2vRcR0(modifier9, z, mutableInteractionSource5, null, z118, Role.m8825boximpl(Role.INSTANCE.m8839getTabo7Vup1c()), function0), 0.0f, NavigationBarHeight, 1, null), 1.0f, false, 2, null);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -7195078, "CC(remember):NavigationBar.kt#9igjgp");
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue2 = new Function1() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda14
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return NavigationBarKt.NavigationBarItem$lambda$6$0(mutableIntState, (IntSize) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        Modifier modifierOnSizeChanged6 = OnRemeasuredModifierKt.onSizeChanged(modifierWeight$default6, (Function1) objRememberedValue2);
                        Alignment center6 = Alignment.INSTANCE.getCenter();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy6 = BoxKt.maybeCachedBoxMeasurePolicy(center6, true);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                        CompositionLocalMap currentCompositionLocalMap6 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier6 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierOnSizeChanged6);
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
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1565189072, "C266@11902L7,263@11672L252,272@12214L7,269@11987L249,277@12496L7,278@12539L274,286@12864L146,293@13225L273,301@13547L404,318@14216L32,319@14286L31,312@13961L367:NavigationBar.kt#uh7d8r");
                        if (z) {
                            f = 1.0f;
                        } else {
                            f = 0.0f;
                        }
                        final NavigationBarItemColors navigationBarItemColors16 = navigationBarItemColors4;
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
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1196463086, "CC(remember):NavigationBar.kt#9igjgp");
                        zChanged = composerStartRestartGroup.changed(density);
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged) {
                            objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda15
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return NavigationBarKt.NavigationBarItem$lambda$7$0$0(density, mutableIntState);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        } else {
                            objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda15
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return NavigationBarKt.NavigationBarItem$lambda$7$0$0(density, mutableIntState);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        function1 = (Function0) objRememberedValue3;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1196473358, "CC(remember):NavigationBar.kt#9igjgp");
                        zChanged2 = composerStartRestartGroup.changed(mutableInteractionSource5) | composerStartRestartGroup.changed(function1);
                        objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged2) {
                            objRememberedValue4 = new MappedInteractionSource(mutableInteractionSource5, function1);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        } else {
                            objRememberedValue4 = new MappedInteractionSource(mutableInteractionSource5, function1);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        }
                        final MappedInteractionSource mappedInteractionSource6 = (MappedInteractionSource) objRememberedValue4;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposableLambda composableLambdaRememberComposableLambda113 = ComposableLambdaKt.rememberComposableLambda(-2082182507, true, new Function2() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda16
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return NavigationBarKt.NavigationBarItem$lambda$7$2(mappedInteractionSource6, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                        ComposableLambda composableLambdaRememberComposableLambda114 = ComposableLambdaKt.rememberComposableLambda(-799524251, true, new Function2() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return NavigationBarKt.NavigationBarItem$lambda$7$3(stateAnimateFloatAsState, navigationBarItemColors16, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1196516508, "CC(remember):NavigationBar.kt#9igjgp");
                        zChanged3 = composerStartRestartGroup.changed(stateAnimateFloatAsState);
                        objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged3) {
                            objRememberedValue5 = new Function0() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda2
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return Float.valueOf(NavigationBarKt.NavigationBarItem$lambda$7$4$0(stateAnimateFloatAsState));
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                        } else {
                            objRememberedValue5 = new Function0() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda2
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return Float.valueOf(NavigationBarKt.NavigationBarItem$lambda$7$4$0(stateAnimateFloatAsState));
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                        }
                        Function0 function19 = (Function0) objRememberedValue5;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1196518747, "CC(remember):NavigationBar.kt#9igjgp");
                        zChanged4 = composerStartRestartGroup.changed(stateAnimateFloatAsState2);
                        objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged4) {
                            objRememberedValue6 = new Function0() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda3
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return Float.valueOf(NavigationBarKt.NavigationBarItem$lambda$7$5$0(stateAnimateFloatAsState2));
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                        } else {
                            objRememberedValue6 = new Function0() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda3
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return Float.valueOf(NavigationBarKt.NavigationBarItem$lambda$7$5$0(stateAnimateFloatAsState2));
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        NavigationBarItemLayout(composableLambdaRememberComposableLambda113, composableLambdaRememberComposableLambda114, composableLambdaRememberComposableLambda111, composableLambda, z116, function19, (Function0) objRememberedValue6, composerStartRestartGroup, ((i14 >> 9) & 57344) | 438);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        navigationBarItemColors2 = navigationBarItemColors16;
                        composer2 = composerStartRestartGroup;
                        z7 = z118;
                        mutableInteractionSource2 = mutableInteractionSource3;
                        modifier2 = modifier9;
                        z6 = z116;
                        function5 = function7;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        z6 = z3;
                        navigationBarItemColors2 = navigationBarItemColors;
                        mutableInteractionSource2 = mutableInteractionSource;
                        composer2 = composerStartRestartGroup;
                        z7 = z4;
                        function5 = function4;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return NavigationBarKt.NavigationBarItem$lambda$8(rowScope, z, function0, function2, modifier2, z7, function5, z6, navigationBarItemColors2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= 805306368;
                i12 = i3;
                if ((i3 & 306783379) != 306783378) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z5, i12 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "206@9394L8");
                    if ((i & 1) != 0) {
                        if (i15 != 0) {
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
                            navigationBarItemColorsColors = NavigationBarItemDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                            i13 = i12 & (-234881025);
                        } else {
                            navigationBarItemColorsColors = navigationBarItemColors;
                            i13 = i12;
                        }
                        z9 = z8;
                        i14 = i13;
                        navigationBarItemColors3 = navigationBarItemColorsColors;
                        modifier3 = modifier2;
                        z10 = z4;
                        function6 = function4;
                        if (i10 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                    } else {
                        if (i15 != 0) {
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
                            navigationBarItemColorsColors = NavigationBarItemDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                            i13 = i12 & (-234881025);
                        } else {
                            navigationBarItemColorsColors = navigationBarItemColors;
                            i13 = i12;
                        }
                        z9 = z8;
                        i14 = i13;
                        navigationBarItemColors3 = navigationBarItemColorsColors;
                        modifier3 = modifier2;
                        z10 = z4;
                        function6 = function4;
                        if (i10 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(974293026, i14, -1, "androidx.compose.material3.NavigationBarItem (NavigationBar.kt:208)");
                    }
                    if (mutableInteractionSource3 == null) {
                        composerStartRestartGroup.startReplaceGroup(-224975399);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "210@9546L39");
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -7257271, "CC(remember):NavigationBar.kt#9igjgp");
                        objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue7 = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.endReplaceGroup();
                        mutableInteractionSource4 = (MutableInteractionSource) objRememberedValue7;
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-7257922);
                        composerStartRestartGroup.endReplaceGroup();
                        mutableInteractionSource4 = mutableInteractionSource3;
                    }
                    finiteAnimationSpecValue = MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultEffects, composerStartRestartGroup, 6);
                    boolean z119 = z9;
                    ComposableLambda composableLambdaRememberComposableLambda115 = ComposableLambdaKt.rememberComposableLambda(-876637252, true, new Function2() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda12
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return NavigationBarKt.NavigationBarItem$lambda$1(navigationBarItemColors3, z, z10, finiteAnimationSpecValue, function6, z9, function2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54);
                    if (function6 == null) {
                        composerStartRestartGroup.startReplaceGroup(-224048562);
                        composerStartRestartGroup.endReplaceGroup();
                        navigationBarItemColors4 = navigationBarItemColors3;
                        function7 = function6;
                        composableLambda = null;
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-224048561);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "*229@10494L521");
                        final NavigationBarItemColors navigationBarItemColors17 = navigationBarItemColors3;
                        final boolean z1110 = z10;
                        final Function2 function110 = function6;
                        navigationBarItemColors4 = navigationBarItemColors17;
                        function7 = function110;
                        ComposableLambda composableLambdaRememberComposableLambda116 = ComposableLambdaKt.rememberComposableLambda(802208206, true, new Function2() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda13
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return NavigationBarKt.NavigationBarItem$lambda$2$0(navigationBarItemColors17, z, z1110, finiteAnimationSpecValue, function110, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                        composerStartRestartGroup.endReplaceGroup();
                        composableLambda = composableLambdaRememberComposableLambda116;
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -7209213, "CC(remember):NavigationBar.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = SnapshotIntStateKt.mutableIntStateOf(0);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    mutableIntState = (MutableIntState) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    boolean z1111 = z10;
                    Modifier modifier10 = modifier3;
                    mutableInteractionSource5 = mutableInteractionSource4;
                    Modifier modifierWeight$default7 = RowScope.weight$default(rowScope, SizeKt.m1251defaultMinSizeVpY3zN4$default(SelectableKt.m1533selectableO2vRcR0(modifier10, z, mutableInteractionSource5, null, z1111, Role.m8825boximpl(Role.INSTANCE.m8839getTabo7Vup1c()), function0), 0.0f, NavigationBarHeight, 1, null), 1.0f, false, 2, null);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -7195078, "CC(remember):NavigationBar.kt#9igjgp");
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = new Function1() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda14
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return NavigationBarKt.NavigationBarItem$lambda$6$0(mutableIntState, (IntSize) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Modifier modifierOnSizeChanged7 = OnRemeasuredModifierKt.onSizeChanged(modifierWeight$default7, (Function1) objRememberedValue2);
                    Alignment center7 = Alignment.INSTANCE.getCenter();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy7 = BoxKt.maybeCachedBoxMeasurePolicy(center7, true);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap7 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier7 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierOnSizeChanged7);
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
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1565189072, "C266@11902L7,263@11672L252,272@12214L7,269@11987L249,277@12496L7,278@12539L274,286@12864L146,293@13225L273,301@13547L404,318@14216L32,319@14286L31,312@13961L367:NavigationBar.kt#uh7d8r");
                    if (z) {
                        f = 1.0f;
                    } else {
                        f = 0.0f;
                    }
                    final NavigationBarItemColors navigationBarItemColors18 = navigationBarItemColors4;
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
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1196463086, "CC(remember):NavigationBar.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(density);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda15
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return NavigationBarKt.NavigationBarItem$lambda$7$0$0(density, mutableIntState);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda15
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return NavigationBarKt.NavigationBarItem$lambda$7$0$0(density, mutableIntState);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    function1 = (Function0) objRememberedValue3;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1196473358, "CC(remember):NavigationBar.kt#9igjgp");
                    zChanged2 = composerStartRestartGroup.changed(mutableInteractionSource5) | composerStartRestartGroup.changed(function1);
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged2) {
                        objRememberedValue4 = new MappedInteractionSource(mutableInteractionSource5, function1);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    } else {
                        objRememberedValue4 = new MappedInteractionSource(mutableInteractionSource5, function1);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    final MappedInteractionSource mappedInteractionSource7 = (MappedInteractionSource) objRememberedValue4;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposableLambda composableLambdaRememberComposableLambda117 = ComposableLambdaKt.rememberComposableLambda(-2082182507, true, new Function2() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda16
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return NavigationBarKt.NavigationBarItem$lambda$7$2(mappedInteractionSource7, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54);
                    ComposableLambda composableLambdaRememberComposableLambda118 = ComposableLambdaKt.rememberComposableLambda(-799524251, true, new Function2() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return NavigationBarKt.NavigationBarItem$lambda$7$3(stateAnimateFloatAsState, navigationBarItemColors18, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1196516508, "CC(remember):NavigationBar.kt#9igjgp");
                    zChanged3 = composerStartRestartGroup.changed(stateAnimateFloatAsState);
                    objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged3) {
                        objRememberedValue5 = new Function0() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Float.valueOf(NavigationBarKt.NavigationBarItem$lambda$7$4$0(stateAnimateFloatAsState));
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                    } else {
                        objRememberedValue5 = new Function0() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Float.valueOf(NavigationBarKt.NavigationBarItem$lambda$7$4$0(stateAnimateFloatAsState));
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                    }
                    Function0 function111 = (Function0) objRememberedValue5;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1196518747, "CC(remember):NavigationBar.kt#9igjgp");
                    zChanged4 = composerStartRestartGroup.changed(stateAnimateFloatAsState2);
                    objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged4) {
                        objRememberedValue6 = new Function0() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Float.valueOf(NavigationBarKt.NavigationBarItem$lambda$7$5$0(stateAnimateFloatAsState2));
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                    } else {
                        objRememberedValue6 = new Function0() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Float.valueOf(NavigationBarKt.NavigationBarItem$lambda$7$5$0(stateAnimateFloatAsState2));
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    NavigationBarItemLayout(composableLambdaRememberComposableLambda117, composableLambdaRememberComposableLambda118, composableLambdaRememberComposableLambda115, composableLambda, z119, function111, (Function0) objRememberedValue6, composerStartRestartGroup, ((i14 >> 9) & 57344) | 438);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    navigationBarItemColors2 = navigationBarItemColors18;
                    composer2 = composerStartRestartGroup;
                    z7 = z1111;
                    mutableInteractionSource2 = mutableInteractionSource3;
                    modifier2 = modifier10;
                    z6 = z119;
                    function5 = function7;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    z6 = z3;
                    navigationBarItemColors2 = navigationBarItemColors;
                    mutableInteractionSource2 = mutableInteractionSource;
                    composer2 = composerStartRestartGroup;
                    z7 = z4;
                    function5 = function4;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return NavigationBarKt.NavigationBarItem$lambda$8(rowScope, z, function0, function2, modifier2, z7, function5, z6, navigationBarItemColors2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 1572864;
            function4 = function3;
            i8 = i2 & 64;
            if (i8 != 0) {
                i3 |= 12582912;
            } else if ((i & 12582912) == 0) {
                if (composerStartRestartGroup.changed(z3)) {
                    i9 = 8388608;
                } else {
                    i9 = 4194304;
                }
                i3 |= i9;
            }
            if ((i & 100663296) != 0) {
                i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(navigationBarItemColors)) ? 33554432 : 67108864;
            }
            i10 = i2 & 256;
            if (i10 != 0) {
                if ((i & 805306368) == 0) {
                    if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                        i11 = C.BUFFER_FLAG_LAST_SAMPLE;
                    } else {
                        i11 = 268435456;
                    }
                    i3 |= i11;
                }
                i12 = i3;
                if ((i3 & 306783379) != 306783378) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z5, i12 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "206@9394L8");
                    if ((i & 1) != 0) {
                        if (i15 != 0) {
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
                            navigationBarItemColorsColors = NavigationBarItemDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                            i13 = i12 & (-234881025);
                        } else {
                            navigationBarItemColorsColors = navigationBarItemColors;
                            i13 = i12;
                        }
                        z9 = z8;
                        i14 = i13;
                        navigationBarItemColors3 = navigationBarItemColorsColors;
                        modifier3 = modifier2;
                        z10 = z4;
                        function6 = function4;
                        if (i10 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                    } else {
                        if (i15 != 0) {
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
                            navigationBarItemColorsColors = NavigationBarItemDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                            i13 = i12 & (-234881025);
                        } else {
                            navigationBarItemColorsColors = navigationBarItemColors;
                            i13 = i12;
                        }
                        z9 = z8;
                        i14 = i13;
                        navigationBarItemColors3 = navigationBarItemColorsColors;
                        modifier3 = modifier2;
                        z10 = z4;
                        function6 = function4;
                        if (i10 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(974293026, i14, -1, "androidx.compose.material3.NavigationBarItem (NavigationBar.kt:208)");
                    }
                    if (mutableInteractionSource3 == null) {
                        composerStartRestartGroup.startReplaceGroup(-224975399);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "210@9546L39");
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -7257271, "CC(remember):NavigationBar.kt#9igjgp");
                        objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue7 = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.endReplaceGroup();
                        mutableInteractionSource4 = (MutableInteractionSource) objRememberedValue7;
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-7257922);
                        composerStartRestartGroup.endReplaceGroup();
                        mutableInteractionSource4 = mutableInteractionSource3;
                    }
                    finiteAnimationSpecValue = MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultEffects, composerStartRestartGroup, 6);
                    boolean z1112 = z9;
                    ComposableLambda composableLambdaRememberComposableLambda119 = ComposableLambdaKt.rememberComposableLambda(-876637252, true, new Function2() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda12
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return NavigationBarKt.NavigationBarItem$lambda$1(navigationBarItemColors3, z, z10, finiteAnimationSpecValue, function6, z9, function2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54);
                    if (function6 == null) {
                        composerStartRestartGroup.startReplaceGroup(-224048562);
                        composerStartRestartGroup.endReplaceGroup();
                        navigationBarItemColors4 = navigationBarItemColors3;
                        function7 = function6;
                        composableLambda = null;
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-224048561);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "*229@10494L521");
                        final NavigationBarItemColors navigationBarItemColors19 = navigationBarItemColors3;
                        final boolean z1113 = z10;
                        final Function2 function112 = function6;
                        navigationBarItemColors4 = navigationBarItemColors19;
                        function7 = function112;
                        ComposableLambda composableLambdaRememberComposableLambda1110 = ComposableLambdaKt.rememberComposableLambda(802208206, true, new Function2() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda13
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return NavigationBarKt.NavigationBarItem$lambda$2$0(navigationBarItemColors19, z, z1113, finiteAnimationSpecValue, function112, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                        composerStartRestartGroup.endReplaceGroup();
                        composableLambda = composableLambdaRememberComposableLambda1110;
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -7209213, "CC(remember):NavigationBar.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = SnapshotIntStateKt.mutableIntStateOf(0);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    mutableIntState = (MutableIntState) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    boolean z1114 = z10;
                    Modifier modifier11 = modifier3;
                    mutableInteractionSource5 = mutableInteractionSource4;
                    Modifier modifierWeight$default8 = RowScope.weight$default(rowScope, SizeKt.m1251defaultMinSizeVpY3zN4$default(SelectableKt.m1533selectableO2vRcR0(modifier11, z, mutableInteractionSource5, null, z1114, Role.m8825boximpl(Role.INSTANCE.m8839getTabo7Vup1c()), function0), 0.0f, NavigationBarHeight, 1, null), 1.0f, false, 2, null);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -7195078, "CC(remember):NavigationBar.kt#9igjgp");
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = new Function1() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda14
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return NavigationBarKt.NavigationBarItem$lambda$6$0(mutableIntState, (IntSize) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Modifier modifierOnSizeChanged8 = OnRemeasuredModifierKt.onSizeChanged(modifierWeight$default8, (Function1) objRememberedValue2);
                    Alignment center8 = Alignment.INSTANCE.getCenter();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy8 = BoxKt.maybeCachedBoxMeasurePolicy(center8, true);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap8 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier8 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierOnSizeChanged8);
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
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1565189072, "C266@11902L7,263@11672L252,272@12214L7,269@11987L249,277@12496L7,278@12539L274,286@12864L146,293@13225L273,301@13547L404,318@14216L32,319@14286L31,312@13961L367:NavigationBar.kt#uh7d8r");
                    if (z) {
                        f = 1.0f;
                    } else {
                        f = 0.0f;
                    }
                    final NavigationBarItemColors navigationBarItemColors110 = navigationBarItemColors4;
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
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1196463086, "CC(remember):NavigationBar.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(density);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda15
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return NavigationBarKt.NavigationBarItem$lambda$7$0$0(density, mutableIntState);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda15
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return NavigationBarKt.NavigationBarItem$lambda$7$0$0(density, mutableIntState);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    function1 = (Function0) objRememberedValue3;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1196473358, "CC(remember):NavigationBar.kt#9igjgp");
                    zChanged2 = composerStartRestartGroup.changed(mutableInteractionSource5) | composerStartRestartGroup.changed(function1);
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged2) {
                        objRememberedValue4 = new MappedInteractionSource(mutableInteractionSource5, function1);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    } else {
                        objRememberedValue4 = new MappedInteractionSource(mutableInteractionSource5, function1);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    final MappedInteractionSource mappedInteractionSource8 = (MappedInteractionSource) objRememberedValue4;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposableLambda composableLambdaRememberComposableLambda1111 = ComposableLambdaKt.rememberComposableLambda(-2082182507, true, new Function2() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda16
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return NavigationBarKt.NavigationBarItem$lambda$7$2(mappedInteractionSource8, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54);
                    ComposableLambda composableLambdaRememberComposableLambda1112 = ComposableLambdaKt.rememberComposableLambda(-799524251, true, new Function2() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return NavigationBarKt.NavigationBarItem$lambda$7$3(stateAnimateFloatAsState, navigationBarItemColors110, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1196516508, "CC(remember):NavigationBar.kt#9igjgp");
                    zChanged3 = composerStartRestartGroup.changed(stateAnimateFloatAsState);
                    objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged3) {
                        objRememberedValue5 = new Function0() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Float.valueOf(NavigationBarKt.NavigationBarItem$lambda$7$4$0(stateAnimateFloatAsState));
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                    } else {
                        objRememberedValue5 = new Function0() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Float.valueOf(NavigationBarKt.NavigationBarItem$lambda$7$4$0(stateAnimateFloatAsState));
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                    }
                    Function0 function113 = (Function0) objRememberedValue5;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1196518747, "CC(remember):NavigationBar.kt#9igjgp");
                    zChanged4 = composerStartRestartGroup.changed(stateAnimateFloatAsState2);
                    objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged4) {
                        objRememberedValue6 = new Function0() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Float.valueOf(NavigationBarKt.NavigationBarItem$lambda$7$5$0(stateAnimateFloatAsState2));
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                    } else {
                        objRememberedValue6 = new Function0() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Float.valueOf(NavigationBarKt.NavigationBarItem$lambda$7$5$0(stateAnimateFloatAsState2));
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    NavigationBarItemLayout(composableLambdaRememberComposableLambda1111, composableLambdaRememberComposableLambda1112, composableLambdaRememberComposableLambda119, composableLambda, z1112, function113, (Function0) objRememberedValue6, composerStartRestartGroup, ((i14 >> 9) & 57344) | 438);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    navigationBarItemColors2 = navigationBarItemColors110;
                    composer2 = composerStartRestartGroup;
                    z7 = z1114;
                    mutableInteractionSource2 = mutableInteractionSource3;
                    modifier2 = modifier11;
                    z6 = z1112;
                    function5 = function7;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    z6 = z3;
                    navigationBarItemColors2 = navigationBarItemColors;
                    mutableInteractionSource2 = mutableInteractionSource;
                    composer2 = composerStartRestartGroup;
                    z7 = z4;
                    function5 = function4;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return NavigationBarKt.NavigationBarItem$lambda$8(rowScope, z, function0, function2, modifier2, z7, function5, z6, navigationBarItemColors2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 805306368;
            i12 = i3;
            if ((i3 & 306783379) != 306783378) {
                z5 = true;
            } else {
                z5 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z5, i12 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "206@9394L8");
                if ((i & 1) != 0) {
                    if (i15 != 0) {
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
                        navigationBarItemColorsColors = NavigationBarItemDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                        i13 = i12 & (-234881025);
                    } else {
                        navigationBarItemColorsColors = navigationBarItemColors;
                        i13 = i12;
                    }
                    z9 = z8;
                    i14 = i13;
                    navigationBarItemColors3 = navigationBarItemColorsColors;
                    modifier3 = modifier2;
                    z10 = z4;
                    function6 = function4;
                    if (i10 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                } else {
                    if (i15 != 0) {
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
                        navigationBarItemColorsColors = NavigationBarItemDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                        i13 = i12 & (-234881025);
                    } else {
                        navigationBarItemColorsColors = navigationBarItemColors;
                        i13 = i12;
                    }
                    z9 = z8;
                    i14 = i13;
                    navigationBarItemColors3 = navigationBarItemColorsColors;
                    modifier3 = modifier2;
                    z10 = z4;
                    function6 = function4;
                    if (i10 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(974293026, i14, -1, "androidx.compose.material3.NavigationBarItem (NavigationBar.kt:208)");
                }
                if (mutableInteractionSource3 == null) {
                    composerStartRestartGroup.startReplaceGroup(-224975399);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "210@9546L39");
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -7257271, "CC(remember):NavigationBar.kt#9igjgp");
                    objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue7 = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endReplaceGroup();
                    mutableInteractionSource4 = (MutableInteractionSource) objRememberedValue7;
                } else {
                    composerStartRestartGroup.startReplaceGroup(-7257922);
                    composerStartRestartGroup.endReplaceGroup();
                    mutableInteractionSource4 = mutableInteractionSource3;
                }
                finiteAnimationSpecValue = MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultEffects, composerStartRestartGroup, 6);
                boolean z1115 = z9;
                ComposableLambda composableLambdaRememberComposableLambda1113 = ComposableLambdaKt.rememberComposableLambda(-876637252, true, new Function2() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda12
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return NavigationBarKt.NavigationBarItem$lambda$1(navigationBarItemColors3, z, z10, finiteAnimationSpecValue, function6, z9, function2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54);
                if (function6 == null) {
                    composerStartRestartGroup.startReplaceGroup(-224048562);
                    composerStartRestartGroup.endReplaceGroup();
                    navigationBarItemColors4 = navigationBarItemColors3;
                    function7 = function6;
                    composableLambda = null;
                } else {
                    composerStartRestartGroup.startReplaceGroup(-224048561);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "*229@10494L521");
                    final NavigationBarItemColors navigationBarItemColors111 = navigationBarItemColors3;
                    final boolean z1116 = z10;
                    final Function2 function114 = function6;
                    navigationBarItemColors4 = navigationBarItemColors111;
                    function7 = function114;
                    ComposableLambda composableLambdaRememberComposableLambda1114 = ComposableLambdaKt.rememberComposableLambda(802208206, true, new Function2() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda13
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return NavigationBarKt.NavigationBarItem$lambda$2$0(navigationBarItemColors111, z, z1116, finiteAnimationSpecValue, function114, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54);
                    composerStartRestartGroup.endReplaceGroup();
                    composableLambda = composableLambdaRememberComposableLambda1114;
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -7209213, "CC(remember):NavigationBar.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = SnapshotIntStateKt.mutableIntStateOf(0);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                mutableIntState = (MutableIntState) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                boolean z1117 = z10;
                Modifier modifier12 = modifier3;
                mutableInteractionSource5 = mutableInteractionSource4;
                Modifier modifierWeight$default9 = RowScope.weight$default(rowScope, SizeKt.m1251defaultMinSizeVpY3zN4$default(SelectableKt.m1533selectableO2vRcR0(modifier12, z, mutableInteractionSource5, null, z1117, Role.m8825boximpl(Role.INSTANCE.m8839getTabo7Vup1c()), function0), 0.0f, NavigationBarHeight, 1, null), 1.0f, false, 2, null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -7195078, "CC(remember):NavigationBar.kt#9igjgp");
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new Function1() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda14
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return NavigationBarKt.NavigationBarItem$lambda$6$0(mutableIntState, (IntSize) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifierOnSizeChanged9 = OnRemeasuredModifierKt.onSizeChanged(modifierWeight$default9, (Function1) objRememberedValue2);
                Alignment center9 = Alignment.INSTANCE.getCenter();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy9 = BoxKt.maybeCachedBoxMeasurePolicy(center9, true);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap9 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier9 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierOnSizeChanged9);
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
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1565189072, "C266@11902L7,263@11672L252,272@12214L7,269@11987L249,277@12496L7,278@12539L274,286@12864L146,293@13225L273,301@13547L404,318@14216L32,319@14286L31,312@13961L367:NavigationBar.kt#uh7d8r");
                if (z) {
                    f = 1.0f;
                } else {
                    f = 0.0f;
                }
                final NavigationBarItemColors navigationBarItemColors112 = navigationBarItemColors4;
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
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1196463086, "CC(remember):NavigationBar.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(density);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda15
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return NavigationBarKt.NavigationBarItem$lambda$7$0$0(density, mutableIntState);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda15
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return NavigationBarKt.NavigationBarItem$lambda$7$0$0(density, mutableIntState);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                function1 = (Function0) objRememberedValue3;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1196473358, "CC(remember):NavigationBar.kt#9igjgp");
                zChanged2 = composerStartRestartGroup.changed(mutableInteractionSource5) | composerStartRestartGroup.changed(function1);
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (!zChanged2) {
                    objRememberedValue4 = new MappedInteractionSource(mutableInteractionSource5, function1);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                } else {
                    objRememberedValue4 = new MappedInteractionSource(mutableInteractionSource5, function1);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                final MappedInteractionSource mappedInteractionSource9 = (MappedInteractionSource) objRememberedValue4;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposableLambda composableLambdaRememberComposableLambda1115 = ComposableLambdaKt.rememberComposableLambda(-2082182507, true, new Function2() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda16
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return NavigationBarKt.NavigationBarItem$lambda$7$2(mappedInteractionSource9, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54);
                ComposableLambda composableLambdaRememberComposableLambda1116 = ComposableLambdaKt.rememberComposableLambda(-799524251, true, new Function2() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return NavigationBarKt.NavigationBarItem$lambda$7$3(stateAnimateFloatAsState, navigationBarItemColors112, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1196516508, "CC(remember):NavigationBar.kt#9igjgp");
                zChanged3 = composerStartRestartGroup.changed(stateAnimateFloatAsState);
                objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                if (!zChanged3) {
                    objRememberedValue5 = new Function0() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return Float.valueOf(NavigationBarKt.NavigationBarItem$lambda$7$4$0(stateAnimateFloatAsState));
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                } else {
                    objRememberedValue5 = new Function0() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return Float.valueOf(NavigationBarKt.NavigationBarItem$lambda$7$4$0(stateAnimateFloatAsState));
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                }
                Function0 function115 = (Function0) objRememberedValue5;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1196518747, "CC(remember):NavigationBar.kt#9igjgp");
                zChanged4 = composerStartRestartGroup.changed(stateAnimateFloatAsState2);
                objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                if (!zChanged4) {
                    objRememberedValue6 = new Function0() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return Float.valueOf(NavigationBarKt.NavigationBarItem$lambda$7$5$0(stateAnimateFloatAsState2));
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                } else {
                    objRememberedValue6 = new Function0() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return Float.valueOf(NavigationBarKt.NavigationBarItem$lambda$7$5$0(stateAnimateFloatAsState2));
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                NavigationBarItemLayout(composableLambdaRememberComposableLambda1115, composableLambdaRememberComposableLambda1116, composableLambdaRememberComposableLambda1113, composableLambda, z1115, function115, (Function0) objRememberedValue6, composerStartRestartGroup, ((i14 >> 9) & 57344) | 438);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                navigationBarItemColors2 = navigationBarItemColors112;
                composer2 = composerStartRestartGroup;
                z7 = z1117;
                mutableInteractionSource2 = mutableInteractionSource3;
                modifier2 = modifier12;
                z6 = z1115;
                function5 = function7;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                z6 = z3;
                navigationBarItemColors2 = navigationBarItemColors;
                mutableInteractionSource2 = mutableInteractionSource;
                composer2 = composerStartRestartGroup;
                z7 = z4;
                function5 = function4;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return NavigationBarKt.NavigationBarItem$lambda$8(rowScope, z, function0, function2, modifier2, z7, function5, z6, navigationBarItemColors2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 24576;
        modifier2 = modifier;
        i4 = i2 & 16;
        if (i4 != 0) {
            if ((196608 & i) == 0) {
                z4 = z2;
                if (composerStartRestartGroup.changed(z4)) {
                    i5 = 131072;
                } else {
                    i5 = 65536;
                }
                i3 |= i5;
            }
            i6 = i2 & 32;
            if (i6 != 0) {
                if ((1572864 & i) == 0) {
                    function4 = function3;
                    if (composerStartRestartGroup.changedInstance(function4)) {
                        i7 = 1048576;
                    } else {
                        i7 = 524288;
                    }
                    i3 |= i7;
                }
                i8 = i2 & 64;
                if (i8 != 0) {
                    i3 |= 12582912;
                } else if ((i & 12582912) == 0) {
                    if (composerStartRestartGroup.changed(z3)) {
                        i9 = 8388608;
                    } else {
                        i9 = 4194304;
                    }
                    i3 |= i9;
                }
                if ((i & 100663296) != 0) {
                    i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(navigationBarItemColors)) ? 33554432 : 67108864;
                }
                i10 = i2 & 256;
                if (i10 != 0) {
                    if ((i & 805306368) == 0) {
                        if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                            i11 = C.BUFFER_FLAG_LAST_SAMPLE;
                        } else {
                            i11 = 268435456;
                        }
                        i3 |= i11;
                    }
                    i12 = i3;
                    if ((i3 & 306783379) != 306783378) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z5, i12 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "206@9394L8");
                        if ((i & 1) != 0) {
                            if (i15 != 0) {
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
                                navigationBarItemColorsColors = NavigationBarItemDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                                i13 = i12 & (-234881025);
                            } else {
                                navigationBarItemColorsColors = navigationBarItemColors;
                                i13 = i12;
                            }
                            z9 = z8;
                            i14 = i13;
                            navigationBarItemColors3 = navigationBarItemColorsColors;
                            modifier3 = modifier2;
                            z10 = z4;
                            function6 = function4;
                            if (i10 != 0) {
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                        } else {
                            if (i15 != 0) {
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
                                navigationBarItemColorsColors = NavigationBarItemDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                                i13 = i12 & (-234881025);
                            } else {
                                navigationBarItemColorsColors = navigationBarItemColors;
                                i13 = i12;
                            }
                            z9 = z8;
                            i14 = i13;
                            navigationBarItemColors3 = navigationBarItemColorsColors;
                            modifier3 = modifier2;
                            z10 = z4;
                            function6 = function4;
                            if (i10 != 0) {
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(974293026, i14, -1, "androidx.compose.material3.NavigationBarItem (NavigationBar.kt:208)");
                        }
                        if (mutableInteractionSource3 == null) {
                            composerStartRestartGroup.startReplaceGroup(-224975399);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "210@9546L39");
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -7257271, "CC(remember):NavigationBar.kt#9igjgp");
                            objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue7 = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            composerStartRestartGroup.endReplaceGroup();
                            mutableInteractionSource4 = (MutableInteractionSource) objRememberedValue7;
                        } else {
                            composerStartRestartGroup.startReplaceGroup(-7257922);
                            composerStartRestartGroup.endReplaceGroup();
                            mutableInteractionSource4 = mutableInteractionSource3;
                        }
                        finiteAnimationSpecValue = MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultEffects, composerStartRestartGroup, 6);
                        boolean z1118 = z9;
                        ComposableLambda composableLambdaRememberComposableLambda1117 = ComposableLambdaKt.rememberComposableLambda(-876637252, true, new Function2() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda12
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return NavigationBarKt.NavigationBarItem$lambda$1(navigationBarItemColors3, z, z10, finiteAnimationSpecValue, function6, z9, function2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                        if (function6 == null) {
                            composerStartRestartGroup.startReplaceGroup(-224048562);
                            composerStartRestartGroup.endReplaceGroup();
                            navigationBarItemColors4 = navigationBarItemColors3;
                            function7 = function6;
                            composableLambda = null;
                        } else {
                            composerStartRestartGroup.startReplaceGroup(-224048561);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "*229@10494L521");
                            final NavigationBarItemColors navigationBarItemColors113 = navigationBarItemColors3;
                            final boolean z1119 = z10;
                            final Function2 function116 = function6;
                            navigationBarItemColors4 = navigationBarItemColors113;
                            function7 = function116;
                            ComposableLambda composableLambdaRememberComposableLambda1118 = ComposableLambdaKt.rememberComposableLambda(802208206, true, new Function2() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda13
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return NavigationBarKt.NavigationBarItem$lambda$2$0(navigationBarItemColors113, z, z1119, finiteAnimationSpecValue, function116, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composerStartRestartGroup, 54);
                            composerStartRestartGroup.endReplaceGroup();
                            composableLambda = composableLambdaRememberComposableLambda1118;
                        }
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -7209213, "CC(remember):NavigationBar.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = SnapshotIntStateKt.mutableIntStateOf(0);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        mutableIntState = (MutableIntState) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        boolean z11110 = z10;
                        Modifier modifier13 = modifier3;
                        mutableInteractionSource5 = mutableInteractionSource4;
                        Modifier modifierWeight$default10 = RowScope.weight$default(rowScope, SizeKt.m1251defaultMinSizeVpY3zN4$default(SelectableKt.m1533selectableO2vRcR0(modifier13, z, mutableInteractionSource5, null, z11110, Role.m8825boximpl(Role.INSTANCE.m8839getTabo7Vup1c()), function0), 0.0f, NavigationBarHeight, 1, null), 1.0f, false, 2, null);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -7195078, "CC(remember):NavigationBar.kt#9igjgp");
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue2 = new Function1() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda14
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return NavigationBarKt.NavigationBarItem$lambda$6$0(mutableIntState, (IntSize) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        Modifier modifierOnSizeChanged10 = OnRemeasuredModifierKt.onSizeChanged(modifierWeight$default10, (Function1) objRememberedValue2);
                        Alignment center10 = Alignment.INSTANCE.getCenter();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy10 = BoxKt.maybeCachedBoxMeasurePolicy(center10, true);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                        CompositionLocalMap currentCompositionLocalMap10 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier10 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierOnSizeChanged10);
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
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1565189072, "C266@11902L7,263@11672L252,272@12214L7,269@11987L249,277@12496L7,278@12539L274,286@12864L146,293@13225L273,301@13547L404,318@14216L32,319@14286L31,312@13961L367:NavigationBar.kt#uh7d8r");
                        if (z) {
                            f = 1.0f;
                        } else {
                            f = 0.0f;
                        }
                        final NavigationBarItemColors navigationBarItemColors114 = navigationBarItemColors4;
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
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1196463086, "CC(remember):NavigationBar.kt#9igjgp");
                        zChanged = composerStartRestartGroup.changed(density);
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged) {
                            objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda15
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return NavigationBarKt.NavigationBarItem$lambda$7$0$0(density, mutableIntState);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        } else {
                            objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda15
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return NavigationBarKt.NavigationBarItem$lambda$7$0$0(density, mutableIntState);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        function1 = (Function0) objRememberedValue3;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1196473358, "CC(remember):NavigationBar.kt#9igjgp");
                        zChanged2 = composerStartRestartGroup.changed(mutableInteractionSource5) | composerStartRestartGroup.changed(function1);
                        objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged2) {
                            objRememberedValue4 = new MappedInteractionSource(mutableInteractionSource5, function1);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        } else {
                            objRememberedValue4 = new MappedInteractionSource(mutableInteractionSource5, function1);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        }
                        final MappedInteractionSource mappedInteractionSource10 = (MappedInteractionSource) objRememberedValue4;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposableLambda composableLambdaRememberComposableLambda1119 = ComposableLambdaKt.rememberComposableLambda(-2082182507, true, new Function2() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda16
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return NavigationBarKt.NavigationBarItem$lambda$7$2(mappedInteractionSource10, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                        ComposableLambda composableLambdaRememberComposableLambda11110 = ComposableLambdaKt.rememberComposableLambda(-799524251, true, new Function2() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return NavigationBarKt.NavigationBarItem$lambda$7$3(stateAnimateFloatAsState, navigationBarItemColors114, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1196516508, "CC(remember):NavigationBar.kt#9igjgp");
                        zChanged3 = composerStartRestartGroup.changed(stateAnimateFloatAsState);
                        objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged3) {
                            objRememberedValue5 = new Function0() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda2
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return Float.valueOf(NavigationBarKt.NavigationBarItem$lambda$7$4$0(stateAnimateFloatAsState));
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                        } else {
                            objRememberedValue5 = new Function0() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda2
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return Float.valueOf(NavigationBarKt.NavigationBarItem$lambda$7$4$0(stateAnimateFloatAsState));
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                        }
                        Function0 function117 = (Function0) objRememberedValue5;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1196518747, "CC(remember):NavigationBar.kt#9igjgp");
                        zChanged4 = composerStartRestartGroup.changed(stateAnimateFloatAsState2);
                        objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged4) {
                            objRememberedValue6 = new Function0() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda3
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return Float.valueOf(NavigationBarKt.NavigationBarItem$lambda$7$5$0(stateAnimateFloatAsState2));
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                        } else {
                            objRememberedValue6 = new Function0() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda3
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return Float.valueOf(NavigationBarKt.NavigationBarItem$lambda$7$5$0(stateAnimateFloatAsState2));
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        NavigationBarItemLayout(composableLambdaRememberComposableLambda1119, composableLambdaRememberComposableLambda11110, composableLambdaRememberComposableLambda1117, composableLambda, z1118, function117, (Function0) objRememberedValue6, composerStartRestartGroup, ((i14 >> 9) & 57344) | 438);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        navigationBarItemColors2 = navigationBarItemColors114;
                        composer2 = composerStartRestartGroup;
                        z7 = z11110;
                        mutableInteractionSource2 = mutableInteractionSource3;
                        modifier2 = modifier13;
                        z6 = z1118;
                        function5 = function7;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        z6 = z3;
                        navigationBarItemColors2 = navigationBarItemColors;
                        mutableInteractionSource2 = mutableInteractionSource;
                        composer2 = composerStartRestartGroup;
                        z7 = z4;
                        function5 = function4;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return NavigationBarKt.NavigationBarItem$lambda$8(rowScope, z, function0, function2, modifier2, z7, function5, z6, navigationBarItemColors2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= 805306368;
                i12 = i3;
                if ((i3 & 306783379) != 306783378) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z5, i12 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "206@9394L8");
                    if ((i & 1) != 0) {
                        if (i15 != 0) {
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
                            navigationBarItemColorsColors = NavigationBarItemDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                            i13 = i12 & (-234881025);
                        } else {
                            navigationBarItemColorsColors = navigationBarItemColors;
                            i13 = i12;
                        }
                        z9 = z8;
                        i14 = i13;
                        navigationBarItemColors3 = navigationBarItemColorsColors;
                        modifier3 = modifier2;
                        z10 = z4;
                        function6 = function4;
                        if (i10 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                    } else {
                        if (i15 != 0) {
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
                            navigationBarItemColorsColors = NavigationBarItemDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                            i13 = i12 & (-234881025);
                        } else {
                            navigationBarItemColorsColors = navigationBarItemColors;
                            i13 = i12;
                        }
                        z9 = z8;
                        i14 = i13;
                        navigationBarItemColors3 = navigationBarItemColorsColors;
                        modifier3 = modifier2;
                        z10 = z4;
                        function6 = function4;
                        if (i10 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(974293026, i14, -1, "androidx.compose.material3.NavigationBarItem (NavigationBar.kt:208)");
                    }
                    if (mutableInteractionSource3 == null) {
                        composerStartRestartGroup.startReplaceGroup(-224975399);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "210@9546L39");
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -7257271, "CC(remember):NavigationBar.kt#9igjgp");
                        objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue7 = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.endReplaceGroup();
                        mutableInteractionSource4 = (MutableInteractionSource) objRememberedValue7;
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-7257922);
                        composerStartRestartGroup.endReplaceGroup();
                        mutableInteractionSource4 = mutableInteractionSource3;
                    }
                    finiteAnimationSpecValue = MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultEffects, composerStartRestartGroup, 6);
                    boolean z11111 = z9;
                    ComposableLambda composableLambdaRememberComposableLambda11111 = ComposableLambdaKt.rememberComposableLambda(-876637252, true, new Function2() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda12
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return NavigationBarKt.NavigationBarItem$lambda$1(navigationBarItemColors3, z, z10, finiteAnimationSpecValue, function6, z9, function2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54);
                    if (function6 == null) {
                        composerStartRestartGroup.startReplaceGroup(-224048562);
                        composerStartRestartGroup.endReplaceGroup();
                        navigationBarItemColors4 = navigationBarItemColors3;
                        function7 = function6;
                        composableLambda = null;
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-224048561);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "*229@10494L521");
                        final NavigationBarItemColors navigationBarItemColors115 = navigationBarItemColors3;
                        final boolean z11112 = z10;
                        final Function2 function118 = function6;
                        navigationBarItemColors4 = navigationBarItemColors115;
                        function7 = function118;
                        ComposableLambda composableLambdaRememberComposableLambda11112 = ComposableLambdaKt.rememberComposableLambda(802208206, true, new Function2() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda13
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return NavigationBarKt.NavigationBarItem$lambda$2$0(navigationBarItemColors115, z, z11112, finiteAnimationSpecValue, function118, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                        composerStartRestartGroup.endReplaceGroup();
                        composableLambda = composableLambdaRememberComposableLambda11112;
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -7209213, "CC(remember):NavigationBar.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = SnapshotIntStateKt.mutableIntStateOf(0);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    mutableIntState = (MutableIntState) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    boolean z11113 = z10;
                    Modifier modifier14 = modifier3;
                    mutableInteractionSource5 = mutableInteractionSource4;
                    Modifier modifierWeight$default11 = RowScope.weight$default(rowScope, SizeKt.m1251defaultMinSizeVpY3zN4$default(SelectableKt.m1533selectableO2vRcR0(modifier14, z, mutableInteractionSource5, null, z11113, Role.m8825boximpl(Role.INSTANCE.m8839getTabo7Vup1c()), function0), 0.0f, NavigationBarHeight, 1, null), 1.0f, false, 2, null);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -7195078, "CC(remember):NavigationBar.kt#9igjgp");
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = new Function1() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda14
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return NavigationBarKt.NavigationBarItem$lambda$6$0(mutableIntState, (IntSize) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Modifier modifierOnSizeChanged11 = OnRemeasuredModifierKt.onSizeChanged(modifierWeight$default11, (Function1) objRememberedValue2);
                    Alignment center11 = Alignment.INSTANCE.getCenter();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy11 = BoxKt.maybeCachedBoxMeasurePolicy(center11, true);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap11 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier11 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierOnSizeChanged11);
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
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1565189072, "C266@11902L7,263@11672L252,272@12214L7,269@11987L249,277@12496L7,278@12539L274,286@12864L146,293@13225L273,301@13547L404,318@14216L32,319@14286L31,312@13961L367:NavigationBar.kt#uh7d8r");
                    if (z) {
                        f = 1.0f;
                    } else {
                        f = 0.0f;
                    }
                    final NavigationBarItemColors navigationBarItemColors116 = navigationBarItemColors4;
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
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1196463086, "CC(remember):NavigationBar.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(density);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda15
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return NavigationBarKt.NavigationBarItem$lambda$7$0$0(density, mutableIntState);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda15
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return NavigationBarKt.NavigationBarItem$lambda$7$0$0(density, mutableIntState);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    function1 = (Function0) objRememberedValue3;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1196473358, "CC(remember):NavigationBar.kt#9igjgp");
                    zChanged2 = composerStartRestartGroup.changed(mutableInteractionSource5) | composerStartRestartGroup.changed(function1);
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged2) {
                        objRememberedValue4 = new MappedInteractionSource(mutableInteractionSource5, function1);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    } else {
                        objRememberedValue4 = new MappedInteractionSource(mutableInteractionSource5, function1);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    final MappedInteractionSource mappedInteractionSource11 = (MappedInteractionSource) objRememberedValue4;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposableLambda composableLambdaRememberComposableLambda11113 = ComposableLambdaKt.rememberComposableLambda(-2082182507, true, new Function2() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda16
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return NavigationBarKt.NavigationBarItem$lambda$7$2(mappedInteractionSource11, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54);
                    ComposableLambda composableLambdaRememberComposableLambda11114 = ComposableLambdaKt.rememberComposableLambda(-799524251, true, new Function2() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return NavigationBarKt.NavigationBarItem$lambda$7$3(stateAnimateFloatAsState, navigationBarItemColors116, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1196516508, "CC(remember):NavigationBar.kt#9igjgp");
                    zChanged3 = composerStartRestartGroup.changed(stateAnimateFloatAsState);
                    objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged3) {
                        objRememberedValue5 = new Function0() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Float.valueOf(NavigationBarKt.NavigationBarItem$lambda$7$4$0(stateAnimateFloatAsState));
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                    } else {
                        objRememberedValue5 = new Function0() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Float.valueOf(NavigationBarKt.NavigationBarItem$lambda$7$4$0(stateAnimateFloatAsState));
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                    }
                    Function0 function119 = (Function0) objRememberedValue5;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1196518747, "CC(remember):NavigationBar.kt#9igjgp");
                    zChanged4 = composerStartRestartGroup.changed(stateAnimateFloatAsState2);
                    objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged4) {
                        objRememberedValue6 = new Function0() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Float.valueOf(NavigationBarKt.NavigationBarItem$lambda$7$5$0(stateAnimateFloatAsState2));
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                    } else {
                        objRememberedValue6 = new Function0() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Float.valueOf(NavigationBarKt.NavigationBarItem$lambda$7$5$0(stateAnimateFloatAsState2));
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    NavigationBarItemLayout(composableLambdaRememberComposableLambda11113, composableLambdaRememberComposableLambda11114, composableLambdaRememberComposableLambda11111, composableLambda, z11111, function119, (Function0) objRememberedValue6, composerStartRestartGroup, ((i14 >> 9) & 57344) | 438);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    navigationBarItemColors2 = navigationBarItemColors116;
                    composer2 = composerStartRestartGroup;
                    z7 = z11113;
                    mutableInteractionSource2 = mutableInteractionSource3;
                    modifier2 = modifier14;
                    z6 = z11111;
                    function5 = function7;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    z6 = z3;
                    navigationBarItemColors2 = navigationBarItemColors;
                    mutableInteractionSource2 = mutableInteractionSource;
                    composer2 = composerStartRestartGroup;
                    z7 = z4;
                    function5 = function4;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return NavigationBarKt.NavigationBarItem$lambda$8(rowScope, z, function0, function2, modifier2, z7, function5, z6, navigationBarItemColors2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 1572864;
            function4 = function3;
            i8 = i2 & 64;
            if (i8 != 0) {
                i3 |= 12582912;
            } else if ((i & 12582912) == 0) {
                if (composerStartRestartGroup.changed(z3)) {
                    i9 = 8388608;
                } else {
                    i9 = 4194304;
                }
                i3 |= i9;
            }
            if ((i & 100663296) != 0) {
                i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(navigationBarItemColors)) ? 33554432 : 67108864;
            }
            i10 = i2 & 256;
            if (i10 != 0) {
                if ((i & 805306368) == 0) {
                    if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                        i11 = C.BUFFER_FLAG_LAST_SAMPLE;
                    } else {
                        i11 = 268435456;
                    }
                    i3 |= i11;
                }
                i12 = i3;
                if ((i3 & 306783379) != 306783378) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z5, i12 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "206@9394L8");
                    if ((i & 1) != 0) {
                        if (i15 != 0) {
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
                            navigationBarItemColorsColors = NavigationBarItemDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                            i13 = i12 & (-234881025);
                        } else {
                            navigationBarItemColorsColors = navigationBarItemColors;
                            i13 = i12;
                        }
                        z9 = z8;
                        i14 = i13;
                        navigationBarItemColors3 = navigationBarItemColorsColors;
                        modifier3 = modifier2;
                        z10 = z4;
                        function6 = function4;
                        if (i10 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                    } else {
                        if (i15 != 0) {
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
                            navigationBarItemColorsColors = NavigationBarItemDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                            i13 = i12 & (-234881025);
                        } else {
                            navigationBarItemColorsColors = navigationBarItemColors;
                            i13 = i12;
                        }
                        z9 = z8;
                        i14 = i13;
                        navigationBarItemColors3 = navigationBarItemColorsColors;
                        modifier3 = modifier2;
                        z10 = z4;
                        function6 = function4;
                        if (i10 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(974293026, i14, -1, "androidx.compose.material3.NavigationBarItem (NavigationBar.kt:208)");
                    }
                    if (mutableInteractionSource3 == null) {
                        composerStartRestartGroup.startReplaceGroup(-224975399);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "210@9546L39");
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -7257271, "CC(remember):NavigationBar.kt#9igjgp");
                        objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue7 = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.endReplaceGroup();
                        mutableInteractionSource4 = (MutableInteractionSource) objRememberedValue7;
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-7257922);
                        composerStartRestartGroup.endReplaceGroup();
                        mutableInteractionSource4 = mutableInteractionSource3;
                    }
                    finiteAnimationSpecValue = MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultEffects, composerStartRestartGroup, 6);
                    boolean z11114 = z9;
                    ComposableLambda composableLambdaRememberComposableLambda11115 = ComposableLambdaKt.rememberComposableLambda(-876637252, true, new Function2() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda12
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return NavigationBarKt.NavigationBarItem$lambda$1(navigationBarItemColors3, z, z10, finiteAnimationSpecValue, function6, z9, function2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54);
                    if (function6 == null) {
                        composerStartRestartGroup.startReplaceGroup(-224048562);
                        composerStartRestartGroup.endReplaceGroup();
                        navigationBarItemColors4 = navigationBarItemColors3;
                        function7 = function6;
                        composableLambda = null;
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-224048561);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "*229@10494L521");
                        final NavigationBarItemColors navigationBarItemColors117 = navigationBarItemColors3;
                        final boolean z11115 = z10;
                        final Function2 function1110 = function6;
                        navigationBarItemColors4 = navigationBarItemColors117;
                        function7 = function1110;
                        ComposableLambda composableLambdaRememberComposableLambda11116 = ComposableLambdaKt.rememberComposableLambda(802208206, true, new Function2() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda13
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return NavigationBarKt.NavigationBarItem$lambda$2$0(navigationBarItemColors117, z, z11115, finiteAnimationSpecValue, function1110, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                        composerStartRestartGroup.endReplaceGroup();
                        composableLambda = composableLambdaRememberComposableLambda11116;
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -7209213, "CC(remember):NavigationBar.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = SnapshotIntStateKt.mutableIntStateOf(0);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    mutableIntState = (MutableIntState) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    boolean z11116 = z10;
                    Modifier modifier15 = modifier3;
                    mutableInteractionSource5 = mutableInteractionSource4;
                    Modifier modifierWeight$default12 = RowScope.weight$default(rowScope, SizeKt.m1251defaultMinSizeVpY3zN4$default(SelectableKt.m1533selectableO2vRcR0(modifier15, z, mutableInteractionSource5, null, z11116, Role.m8825boximpl(Role.INSTANCE.m8839getTabo7Vup1c()), function0), 0.0f, NavigationBarHeight, 1, null), 1.0f, false, 2, null);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -7195078, "CC(remember):NavigationBar.kt#9igjgp");
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = new Function1() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda14
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return NavigationBarKt.NavigationBarItem$lambda$6$0(mutableIntState, (IntSize) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Modifier modifierOnSizeChanged12 = OnRemeasuredModifierKt.onSizeChanged(modifierWeight$default12, (Function1) objRememberedValue2);
                    Alignment center12 = Alignment.INSTANCE.getCenter();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy12 = BoxKt.maybeCachedBoxMeasurePolicy(center12, true);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap12 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier12 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierOnSizeChanged12);
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
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1565189072, "C266@11902L7,263@11672L252,272@12214L7,269@11987L249,277@12496L7,278@12539L274,286@12864L146,293@13225L273,301@13547L404,318@14216L32,319@14286L31,312@13961L367:NavigationBar.kt#uh7d8r");
                    if (z) {
                        f = 1.0f;
                    } else {
                        f = 0.0f;
                    }
                    final NavigationBarItemColors navigationBarItemColors118 = navigationBarItemColors4;
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
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1196463086, "CC(remember):NavigationBar.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(density);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda15
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return NavigationBarKt.NavigationBarItem$lambda$7$0$0(density, mutableIntState);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda15
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return NavigationBarKt.NavigationBarItem$lambda$7$0$0(density, mutableIntState);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    function1 = (Function0) objRememberedValue3;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1196473358, "CC(remember):NavigationBar.kt#9igjgp");
                    zChanged2 = composerStartRestartGroup.changed(mutableInteractionSource5) | composerStartRestartGroup.changed(function1);
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged2) {
                        objRememberedValue4 = new MappedInteractionSource(mutableInteractionSource5, function1);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    } else {
                        objRememberedValue4 = new MappedInteractionSource(mutableInteractionSource5, function1);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    final MappedInteractionSource mappedInteractionSource12 = (MappedInteractionSource) objRememberedValue4;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposableLambda composableLambdaRememberComposableLambda11117 = ComposableLambdaKt.rememberComposableLambda(-2082182507, true, new Function2() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda16
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return NavigationBarKt.NavigationBarItem$lambda$7$2(mappedInteractionSource12, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54);
                    ComposableLambda composableLambdaRememberComposableLambda11118 = ComposableLambdaKt.rememberComposableLambda(-799524251, true, new Function2() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return NavigationBarKt.NavigationBarItem$lambda$7$3(stateAnimateFloatAsState, navigationBarItemColors118, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1196516508, "CC(remember):NavigationBar.kt#9igjgp");
                    zChanged3 = composerStartRestartGroup.changed(stateAnimateFloatAsState);
                    objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged3) {
                        objRememberedValue5 = new Function0() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Float.valueOf(NavigationBarKt.NavigationBarItem$lambda$7$4$0(stateAnimateFloatAsState));
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                    } else {
                        objRememberedValue5 = new Function0() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Float.valueOf(NavigationBarKt.NavigationBarItem$lambda$7$4$0(stateAnimateFloatAsState));
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                    }
                    Function0 function1111 = (Function0) objRememberedValue5;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1196518747, "CC(remember):NavigationBar.kt#9igjgp");
                    zChanged4 = composerStartRestartGroup.changed(stateAnimateFloatAsState2);
                    objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged4) {
                        objRememberedValue6 = new Function0() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Float.valueOf(NavigationBarKt.NavigationBarItem$lambda$7$5$0(stateAnimateFloatAsState2));
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                    } else {
                        objRememberedValue6 = new Function0() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Float.valueOf(NavigationBarKt.NavigationBarItem$lambda$7$5$0(stateAnimateFloatAsState2));
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    NavigationBarItemLayout(composableLambdaRememberComposableLambda11117, composableLambdaRememberComposableLambda11118, composableLambdaRememberComposableLambda11115, composableLambda, z11114, function1111, (Function0) objRememberedValue6, composerStartRestartGroup, ((i14 >> 9) & 57344) | 438);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    navigationBarItemColors2 = navigationBarItemColors118;
                    composer2 = composerStartRestartGroup;
                    z7 = z11116;
                    mutableInteractionSource2 = mutableInteractionSource3;
                    modifier2 = modifier15;
                    z6 = z11114;
                    function5 = function7;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    z6 = z3;
                    navigationBarItemColors2 = navigationBarItemColors;
                    mutableInteractionSource2 = mutableInteractionSource;
                    composer2 = composerStartRestartGroup;
                    z7 = z4;
                    function5 = function4;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return NavigationBarKt.NavigationBarItem$lambda$8(rowScope, z, function0, function2, modifier2, z7, function5, z6, navigationBarItemColors2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 805306368;
            i12 = i3;
            if ((i3 & 306783379) != 306783378) {
                z5 = true;
            } else {
                z5 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z5, i12 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "206@9394L8");
                if ((i & 1) != 0) {
                    if (i15 != 0) {
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
                        navigationBarItemColorsColors = NavigationBarItemDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                        i13 = i12 & (-234881025);
                    } else {
                        navigationBarItemColorsColors = navigationBarItemColors;
                        i13 = i12;
                    }
                    z9 = z8;
                    i14 = i13;
                    navigationBarItemColors3 = navigationBarItemColorsColors;
                    modifier3 = modifier2;
                    z10 = z4;
                    function6 = function4;
                    if (i10 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                } else {
                    if (i15 != 0) {
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
                        navigationBarItemColorsColors = NavigationBarItemDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                        i13 = i12 & (-234881025);
                    } else {
                        navigationBarItemColorsColors = navigationBarItemColors;
                        i13 = i12;
                    }
                    z9 = z8;
                    i14 = i13;
                    navigationBarItemColors3 = navigationBarItemColorsColors;
                    modifier3 = modifier2;
                    z10 = z4;
                    function6 = function4;
                    if (i10 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(974293026, i14, -1, "androidx.compose.material3.NavigationBarItem (NavigationBar.kt:208)");
                }
                if (mutableInteractionSource3 == null) {
                    composerStartRestartGroup.startReplaceGroup(-224975399);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "210@9546L39");
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -7257271, "CC(remember):NavigationBar.kt#9igjgp");
                    objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue7 = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endReplaceGroup();
                    mutableInteractionSource4 = (MutableInteractionSource) objRememberedValue7;
                } else {
                    composerStartRestartGroup.startReplaceGroup(-7257922);
                    composerStartRestartGroup.endReplaceGroup();
                    mutableInteractionSource4 = mutableInteractionSource3;
                }
                finiteAnimationSpecValue = MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultEffects, composerStartRestartGroup, 6);
                boolean z11117 = z9;
                ComposableLambda composableLambdaRememberComposableLambda11119 = ComposableLambdaKt.rememberComposableLambda(-876637252, true, new Function2() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda12
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return NavigationBarKt.NavigationBarItem$lambda$1(navigationBarItemColors3, z, z10, finiteAnimationSpecValue, function6, z9, function2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54);
                if (function6 == null) {
                    composerStartRestartGroup.startReplaceGroup(-224048562);
                    composerStartRestartGroup.endReplaceGroup();
                    navigationBarItemColors4 = navigationBarItemColors3;
                    function7 = function6;
                    composableLambda = null;
                } else {
                    composerStartRestartGroup.startReplaceGroup(-224048561);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "*229@10494L521");
                    final NavigationBarItemColors navigationBarItemColors119 = navigationBarItemColors3;
                    final boolean z11118 = z10;
                    final Function2 function1112 = function6;
                    navigationBarItemColors4 = navigationBarItemColors119;
                    function7 = function1112;
                    ComposableLambda composableLambdaRememberComposableLambda111110 = ComposableLambdaKt.rememberComposableLambda(802208206, true, new Function2() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda13
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return NavigationBarKt.NavigationBarItem$lambda$2$0(navigationBarItemColors119, z, z11118, finiteAnimationSpecValue, function1112, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54);
                    composerStartRestartGroup.endReplaceGroup();
                    composableLambda = composableLambdaRememberComposableLambda111110;
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -7209213, "CC(remember):NavigationBar.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = SnapshotIntStateKt.mutableIntStateOf(0);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                mutableIntState = (MutableIntState) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                boolean z11119 = z10;
                Modifier modifier16 = modifier3;
                mutableInteractionSource5 = mutableInteractionSource4;
                Modifier modifierWeight$default13 = RowScope.weight$default(rowScope, SizeKt.m1251defaultMinSizeVpY3zN4$default(SelectableKt.m1533selectableO2vRcR0(modifier16, z, mutableInteractionSource5, null, z11119, Role.m8825boximpl(Role.INSTANCE.m8839getTabo7Vup1c()), function0), 0.0f, NavigationBarHeight, 1, null), 1.0f, false, 2, null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -7195078, "CC(remember):NavigationBar.kt#9igjgp");
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new Function1() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda14
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return NavigationBarKt.NavigationBarItem$lambda$6$0(mutableIntState, (IntSize) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifierOnSizeChanged13 = OnRemeasuredModifierKt.onSizeChanged(modifierWeight$default13, (Function1) objRememberedValue2);
                Alignment center13 = Alignment.INSTANCE.getCenter();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy13 = BoxKt.maybeCachedBoxMeasurePolicy(center13, true);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap13 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier13 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierOnSizeChanged13);
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
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1565189072, "C266@11902L7,263@11672L252,272@12214L7,269@11987L249,277@12496L7,278@12539L274,286@12864L146,293@13225L273,301@13547L404,318@14216L32,319@14286L31,312@13961L367:NavigationBar.kt#uh7d8r");
                if (z) {
                    f = 1.0f;
                } else {
                    f = 0.0f;
                }
                final NavigationBarItemColors navigationBarItemColors1110 = navigationBarItemColors4;
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
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1196463086, "CC(remember):NavigationBar.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(density);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda15
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return NavigationBarKt.NavigationBarItem$lambda$7$0$0(density, mutableIntState);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda15
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return NavigationBarKt.NavigationBarItem$lambda$7$0$0(density, mutableIntState);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                function1 = (Function0) objRememberedValue3;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1196473358, "CC(remember):NavigationBar.kt#9igjgp");
                zChanged2 = composerStartRestartGroup.changed(mutableInteractionSource5) | composerStartRestartGroup.changed(function1);
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (!zChanged2) {
                    objRememberedValue4 = new MappedInteractionSource(mutableInteractionSource5, function1);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                } else {
                    objRememberedValue4 = new MappedInteractionSource(mutableInteractionSource5, function1);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                final MappedInteractionSource mappedInteractionSource13 = (MappedInteractionSource) objRememberedValue4;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposableLambda composableLambdaRememberComposableLambda111111 = ComposableLambdaKt.rememberComposableLambda(-2082182507, true, new Function2() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda16
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return NavigationBarKt.NavigationBarItem$lambda$7$2(mappedInteractionSource13, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54);
                ComposableLambda composableLambdaRememberComposableLambda111112 = ComposableLambdaKt.rememberComposableLambda(-799524251, true, new Function2() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return NavigationBarKt.NavigationBarItem$lambda$7$3(stateAnimateFloatAsState, navigationBarItemColors1110, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1196516508, "CC(remember):NavigationBar.kt#9igjgp");
                zChanged3 = composerStartRestartGroup.changed(stateAnimateFloatAsState);
                objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                if (!zChanged3) {
                    objRememberedValue5 = new Function0() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return Float.valueOf(NavigationBarKt.NavigationBarItem$lambda$7$4$0(stateAnimateFloatAsState));
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                } else {
                    objRememberedValue5 = new Function0() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return Float.valueOf(NavigationBarKt.NavigationBarItem$lambda$7$4$0(stateAnimateFloatAsState));
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                }
                Function0 function1113 = (Function0) objRememberedValue5;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1196518747, "CC(remember):NavigationBar.kt#9igjgp");
                zChanged4 = composerStartRestartGroup.changed(stateAnimateFloatAsState2);
                objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                if (!zChanged4) {
                    objRememberedValue6 = new Function0() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return Float.valueOf(NavigationBarKt.NavigationBarItem$lambda$7$5$0(stateAnimateFloatAsState2));
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                } else {
                    objRememberedValue6 = new Function0() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return Float.valueOf(NavigationBarKt.NavigationBarItem$lambda$7$5$0(stateAnimateFloatAsState2));
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                NavigationBarItemLayout(composableLambdaRememberComposableLambda111111, composableLambdaRememberComposableLambda111112, composableLambdaRememberComposableLambda11119, composableLambda, z11117, function1113, (Function0) objRememberedValue6, composerStartRestartGroup, ((i14 >> 9) & 57344) | 438);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                navigationBarItemColors2 = navigationBarItemColors1110;
                composer2 = composerStartRestartGroup;
                z7 = z11119;
                mutableInteractionSource2 = mutableInteractionSource3;
                modifier2 = modifier16;
                z6 = z11117;
                function5 = function7;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                z6 = z3;
                navigationBarItemColors2 = navigationBarItemColors;
                mutableInteractionSource2 = mutableInteractionSource;
                composer2 = composerStartRestartGroup;
                z7 = z4;
                function5 = function4;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return NavigationBarKt.NavigationBarItem$lambda$8(rowScope, z, function0, function2, modifier2, z7, function5, z6, navigationBarItemColors2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        z4 = z2;
        i6 = i2 & 32;
        if (i6 != 0) {
            if ((1572864 & i) == 0) {
                function4 = function3;
                if (composerStartRestartGroup.changedInstance(function4)) {
                    i7 = 1048576;
                } else {
                    i7 = 524288;
                }
                i3 |= i7;
            }
            i8 = i2 & 64;
            if (i8 != 0) {
                i3 |= 12582912;
            } else if ((i & 12582912) == 0) {
                if (composerStartRestartGroup.changed(z3)) {
                    i9 = 8388608;
                } else {
                    i9 = 4194304;
                }
                i3 |= i9;
            }
            if ((i & 100663296) != 0) {
                i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(navigationBarItemColors)) ? 33554432 : 67108864;
            }
            i10 = i2 & 256;
            if (i10 != 0) {
                if ((i & 805306368) == 0) {
                    if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                        i11 = C.BUFFER_FLAG_LAST_SAMPLE;
                    } else {
                        i11 = 268435456;
                    }
                    i3 |= i11;
                }
                i12 = i3;
                if ((i3 & 306783379) != 306783378) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z5, i12 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "206@9394L8");
                    if ((i & 1) != 0) {
                        if (i15 != 0) {
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
                            navigationBarItemColorsColors = NavigationBarItemDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                            i13 = i12 & (-234881025);
                        } else {
                            navigationBarItemColorsColors = navigationBarItemColors;
                            i13 = i12;
                        }
                        z9 = z8;
                        i14 = i13;
                        navigationBarItemColors3 = navigationBarItemColorsColors;
                        modifier3 = modifier2;
                        z10 = z4;
                        function6 = function4;
                        if (i10 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                    } else {
                        if (i15 != 0) {
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
                            navigationBarItemColorsColors = NavigationBarItemDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                            i13 = i12 & (-234881025);
                        } else {
                            navigationBarItemColorsColors = navigationBarItemColors;
                            i13 = i12;
                        }
                        z9 = z8;
                        i14 = i13;
                        navigationBarItemColors3 = navigationBarItemColorsColors;
                        modifier3 = modifier2;
                        z10 = z4;
                        function6 = function4;
                        if (i10 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(974293026, i14, -1, "androidx.compose.material3.NavigationBarItem (NavigationBar.kt:208)");
                    }
                    if (mutableInteractionSource3 == null) {
                        composerStartRestartGroup.startReplaceGroup(-224975399);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "210@9546L39");
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -7257271, "CC(remember):NavigationBar.kt#9igjgp");
                        objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue7 = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.endReplaceGroup();
                        mutableInteractionSource4 = (MutableInteractionSource) objRememberedValue7;
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-7257922);
                        composerStartRestartGroup.endReplaceGroup();
                        mutableInteractionSource4 = mutableInteractionSource3;
                    }
                    finiteAnimationSpecValue = MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultEffects, composerStartRestartGroup, 6);
                    boolean z111110 = z9;
                    ComposableLambda composableLambdaRememberComposableLambda111113 = ComposableLambdaKt.rememberComposableLambda(-876637252, true, new Function2() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda12
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return NavigationBarKt.NavigationBarItem$lambda$1(navigationBarItemColors3, z, z10, finiteAnimationSpecValue, function6, z9, function2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54);
                    if (function6 == null) {
                        composerStartRestartGroup.startReplaceGroup(-224048562);
                        composerStartRestartGroup.endReplaceGroup();
                        navigationBarItemColors4 = navigationBarItemColors3;
                        function7 = function6;
                        composableLambda = null;
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-224048561);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "*229@10494L521");
                        final NavigationBarItemColors navigationBarItemColors1111 = navigationBarItemColors3;
                        final boolean z111111 = z10;
                        final Function2 function1114 = function6;
                        navigationBarItemColors4 = navigationBarItemColors1111;
                        function7 = function1114;
                        ComposableLambda composableLambdaRememberComposableLambda111114 = ComposableLambdaKt.rememberComposableLambda(802208206, true, new Function2() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda13
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return NavigationBarKt.NavigationBarItem$lambda$2$0(navigationBarItemColors1111, z, z111111, finiteAnimationSpecValue, function1114, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                        composerStartRestartGroup.endReplaceGroup();
                        composableLambda = composableLambdaRememberComposableLambda111114;
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -7209213, "CC(remember):NavigationBar.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = SnapshotIntStateKt.mutableIntStateOf(0);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    mutableIntState = (MutableIntState) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    boolean z111112 = z10;
                    Modifier modifier17 = modifier3;
                    mutableInteractionSource5 = mutableInteractionSource4;
                    Modifier modifierWeight$default14 = RowScope.weight$default(rowScope, SizeKt.m1251defaultMinSizeVpY3zN4$default(SelectableKt.m1533selectableO2vRcR0(modifier17, z, mutableInteractionSource5, null, z111112, Role.m8825boximpl(Role.INSTANCE.m8839getTabo7Vup1c()), function0), 0.0f, NavigationBarHeight, 1, null), 1.0f, false, 2, null);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -7195078, "CC(remember):NavigationBar.kt#9igjgp");
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = new Function1() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda14
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return NavigationBarKt.NavigationBarItem$lambda$6$0(mutableIntState, (IntSize) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Modifier modifierOnSizeChanged14 = OnRemeasuredModifierKt.onSizeChanged(modifierWeight$default14, (Function1) objRememberedValue2);
                    Alignment center14 = Alignment.INSTANCE.getCenter();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy14 = BoxKt.maybeCachedBoxMeasurePolicy(center14, true);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap14 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier14 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierOnSizeChanged14);
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
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1565189072, "C266@11902L7,263@11672L252,272@12214L7,269@11987L249,277@12496L7,278@12539L274,286@12864L146,293@13225L273,301@13547L404,318@14216L32,319@14286L31,312@13961L367:NavigationBar.kt#uh7d8r");
                    if (z) {
                        f = 1.0f;
                    } else {
                        f = 0.0f;
                    }
                    final NavigationBarItemColors navigationBarItemColors1112 = navigationBarItemColors4;
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
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1196463086, "CC(remember):NavigationBar.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(density);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda15
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return NavigationBarKt.NavigationBarItem$lambda$7$0$0(density, mutableIntState);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda15
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return NavigationBarKt.NavigationBarItem$lambda$7$0$0(density, mutableIntState);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    function1 = (Function0) objRememberedValue3;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1196473358, "CC(remember):NavigationBar.kt#9igjgp");
                    zChanged2 = composerStartRestartGroup.changed(mutableInteractionSource5) | composerStartRestartGroup.changed(function1);
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged2) {
                        objRememberedValue4 = new MappedInteractionSource(mutableInteractionSource5, function1);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    } else {
                        objRememberedValue4 = new MappedInteractionSource(mutableInteractionSource5, function1);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    final MappedInteractionSource mappedInteractionSource14 = (MappedInteractionSource) objRememberedValue4;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposableLambda composableLambdaRememberComposableLambda111115 = ComposableLambdaKt.rememberComposableLambda(-2082182507, true, new Function2() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda16
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return NavigationBarKt.NavigationBarItem$lambda$7$2(mappedInteractionSource14, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54);
                    ComposableLambda composableLambdaRememberComposableLambda111116 = ComposableLambdaKt.rememberComposableLambda(-799524251, true, new Function2() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return NavigationBarKt.NavigationBarItem$lambda$7$3(stateAnimateFloatAsState, navigationBarItemColors1112, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1196516508, "CC(remember):NavigationBar.kt#9igjgp");
                    zChanged3 = composerStartRestartGroup.changed(stateAnimateFloatAsState);
                    objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged3) {
                        objRememberedValue5 = new Function0() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Float.valueOf(NavigationBarKt.NavigationBarItem$lambda$7$4$0(stateAnimateFloatAsState));
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                    } else {
                        objRememberedValue5 = new Function0() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Float.valueOf(NavigationBarKt.NavigationBarItem$lambda$7$4$0(stateAnimateFloatAsState));
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                    }
                    Function0 function1115 = (Function0) objRememberedValue5;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1196518747, "CC(remember):NavigationBar.kt#9igjgp");
                    zChanged4 = composerStartRestartGroup.changed(stateAnimateFloatAsState2);
                    objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged4) {
                        objRememberedValue6 = new Function0() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Float.valueOf(NavigationBarKt.NavigationBarItem$lambda$7$5$0(stateAnimateFloatAsState2));
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                    } else {
                        objRememberedValue6 = new Function0() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Float.valueOf(NavigationBarKt.NavigationBarItem$lambda$7$5$0(stateAnimateFloatAsState2));
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    NavigationBarItemLayout(composableLambdaRememberComposableLambda111115, composableLambdaRememberComposableLambda111116, composableLambdaRememberComposableLambda111113, composableLambda, z111110, function1115, (Function0) objRememberedValue6, composerStartRestartGroup, ((i14 >> 9) & 57344) | 438);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    navigationBarItemColors2 = navigationBarItemColors1112;
                    composer2 = composerStartRestartGroup;
                    z7 = z111112;
                    mutableInteractionSource2 = mutableInteractionSource3;
                    modifier2 = modifier17;
                    z6 = z111110;
                    function5 = function7;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    z6 = z3;
                    navigationBarItemColors2 = navigationBarItemColors;
                    mutableInteractionSource2 = mutableInteractionSource;
                    composer2 = composerStartRestartGroup;
                    z7 = z4;
                    function5 = function4;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return NavigationBarKt.NavigationBarItem$lambda$8(rowScope, z, function0, function2, modifier2, z7, function5, z6, navigationBarItemColors2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 805306368;
            i12 = i3;
            if ((i3 & 306783379) != 306783378) {
                z5 = true;
            } else {
                z5 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z5, i12 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "206@9394L8");
                if ((i & 1) != 0) {
                    if (i15 != 0) {
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
                        navigationBarItemColorsColors = NavigationBarItemDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                        i13 = i12 & (-234881025);
                    } else {
                        navigationBarItemColorsColors = navigationBarItemColors;
                        i13 = i12;
                    }
                    z9 = z8;
                    i14 = i13;
                    navigationBarItemColors3 = navigationBarItemColorsColors;
                    modifier3 = modifier2;
                    z10 = z4;
                    function6 = function4;
                    if (i10 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                } else {
                    if (i15 != 0) {
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
                        navigationBarItemColorsColors = NavigationBarItemDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                        i13 = i12 & (-234881025);
                    } else {
                        navigationBarItemColorsColors = navigationBarItemColors;
                        i13 = i12;
                    }
                    z9 = z8;
                    i14 = i13;
                    navigationBarItemColors3 = navigationBarItemColorsColors;
                    modifier3 = modifier2;
                    z10 = z4;
                    function6 = function4;
                    if (i10 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(974293026, i14, -1, "androidx.compose.material3.NavigationBarItem (NavigationBar.kt:208)");
                }
                if (mutableInteractionSource3 == null) {
                    composerStartRestartGroup.startReplaceGroup(-224975399);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "210@9546L39");
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -7257271, "CC(remember):NavigationBar.kt#9igjgp");
                    objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue7 = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endReplaceGroup();
                    mutableInteractionSource4 = (MutableInteractionSource) objRememberedValue7;
                } else {
                    composerStartRestartGroup.startReplaceGroup(-7257922);
                    composerStartRestartGroup.endReplaceGroup();
                    mutableInteractionSource4 = mutableInteractionSource3;
                }
                finiteAnimationSpecValue = MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultEffects, composerStartRestartGroup, 6);
                boolean z111113 = z9;
                ComposableLambda composableLambdaRememberComposableLambda111117 = ComposableLambdaKt.rememberComposableLambda(-876637252, true, new Function2() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda12
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return NavigationBarKt.NavigationBarItem$lambda$1(navigationBarItemColors3, z, z10, finiteAnimationSpecValue, function6, z9, function2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54);
                if (function6 == null) {
                    composerStartRestartGroup.startReplaceGroup(-224048562);
                    composerStartRestartGroup.endReplaceGroup();
                    navigationBarItemColors4 = navigationBarItemColors3;
                    function7 = function6;
                    composableLambda = null;
                } else {
                    composerStartRestartGroup.startReplaceGroup(-224048561);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "*229@10494L521");
                    final NavigationBarItemColors navigationBarItemColors1113 = navigationBarItemColors3;
                    final boolean z111114 = z10;
                    final Function2 function1116 = function6;
                    navigationBarItemColors4 = navigationBarItemColors1113;
                    function7 = function1116;
                    ComposableLambda composableLambdaRememberComposableLambda111118 = ComposableLambdaKt.rememberComposableLambda(802208206, true, new Function2() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda13
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return NavigationBarKt.NavigationBarItem$lambda$2$0(navigationBarItemColors1113, z, z111114, finiteAnimationSpecValue, function1116, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54);
                    composerStartRestartGroup.endReplaceGroup();
                    composableLambda = composableLambdaRememberComposableLambda111118;
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -7209213, "CC(remember):NavigationBar.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = SnapshotIntStateKt.mutableIntStateOf(0);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                mutableIntState = (MutableIntState) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                boolean z111115 = z10;
                Modifier modifier18 = modifier3;
                mutableInteractionSource5 = mutableInteractionSource4;
                Modifier modifierWeight$default15 = RowScope.weight$default(rowScope, SizeKt.m1251defaultMinSizeVpY3zN4$default(SelectableKt.m1533selectableO2vRcR0(modifier18, z, mutableInteractionSource5, null, z111115, Role.m8825boximpl(Role.INSTANCE.m8839getTabo7Vup1c()), function0), 0.0f, NavigationBarHeight, 1, null), 1.0f, false, 2, null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -7195078, "CC(remember):NavigationBar.kt#9igjgp");
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new Function1() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda14
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return NavigationBarKt.NavigationBarItem$lambda$6$0(mutableIntState, (IntSize) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifierOnSizeChanged15 = OnRemeasuredModifierKt.onSizeChanged(modifierWeight$default15, (Function1) objRememberedValue2);
                Alignment center15 = Alignment.INSTANCE.getCenter();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy15 = BoxKt.maybeCachedBoxMeasurePolicy(center15, true);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap15 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier15 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierOnSizeChanged15);
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
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1565189072, "C266@11902L7,263@11672L252,272@12214L7,269@11987L249,277@12496L7,278@12539L274,286@12864L146,293@13225L273,301@13547L404,318@14216L32,319@14286L31,312@13961L367:NavigationBar.kt#uh7d8r");
                if (z) {
                    f = 1.0f;
                } else {
                    f = 0.0f;
                }
                final NavigationBarItemColors navigationBarItemColors1114 = navigationBarItemColors4;
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
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1196463086, "CC(remember):NavigationBar.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(density);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda15
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return NavigationBarKt.NavigationBarItem$lambda$7$0$0(density, mutableIntState);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda15
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return NavigationBarKt.NavigationBarItem$lambda$7$0$0(density, mutableIntState);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                function1 = (Function0) objRememberedValue3;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1196473358, "CC(remember):NavigationBar.kt#9igjgp");
                zChanged2 = composerStartRestartGroup.changed(mutableInteractionSource5) | composerStartRestartGroup.changed(function1);
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (!zChanged2) {
                    objRememberedValue4 = new MappedInteractionSource(mutableInteractionSource5, function1);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                } else {
                    objRememberedValue4 = new MappedInteractionSource(mutableInteractionSource5, function1);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                final MappedInteractionSource mappedInteractionSource15 = (MappedInteractionSource) objRememberedValue4;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposableLambda composableLambdaRememberComposableLambda111119 = ComposableLambdaKt.rememberComposableLambda(-2082182507, true, new Function2() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda16
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return NavigationBarKt.NavigationBarItem$lambda$7$2(mappedInteractionSource15, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54);
                ComposableLambda composableLambdaRememberComposableLambda1111110 = ComposableLambdaKt.rememberComposableLambda(-799524251, true, new Function2() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return NavigationBarKt.NavigationBarItem$lambda$7$3(stateAnimateFloatAsState, navigationBarItemColors1114, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1196516508, "CC(remember):NavigationBar.kt#9igjgp");
                zChanged3 = composerStartRestartGroup.changed(stateAnimateFloatAsState);
                objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                if (!zChanged3) {
                    objRememberedValue5 = new Function0() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return Float.valueOf(NavigationBarKt.NavigationBarItem$lambda$7$4$0(stateAnimateFloatAsState));
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                } else {
                    objRememberedValue5 = new Function0() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return Float.valueOf(NavigationBarKt.NavigationBarItem$lambda$7$4$0(stateAnimateFloatAsState));
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                }
                Function0 function1117 = (Function0) objRememberedValue5;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1196518747, "CC(remember):NavigationBar.kt#9igjgp");
                zChanged4 = composerStartRestartGroup.changed(stateAnimateFloatAsState2);
                objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                if (!zChanged4) {
                    objRememberedValue6 = new Function0() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return Float.valueOf(NavigationBarKt.NavigationBarItem$lambda$7$5$0(stateAnimateFloatAsState2));
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                } else {
                    objRememberedValue6 = new Function0() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return Float.valueOf(NavigationBarKt.NavigationBarItem$lambda$7$5$0(stateAnimateFloatAsState2));
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                NavigationBarItemLayout(composableLambdaRememberComposableLambda111119, composableLambdaRememberComposableLambda1111110, composableLambdaRememberComposableLambda111117, composableLambda, z111113, function1117, (Function0) objRememberedValue6, composerStartRestartGroup, ((i14 >> 9) & 57344) | 438);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                navigationBarItemColors2 = navigationBarItemColors1114;
                composer2 = composerStartRestartGroup;
                z7 = z111115;
                mutableInteractionSource2 = mutableInteractionSource3;
                modifier2 = modifier18;
                z6 = z111113;
                function5 = function7;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                z6 = z3;
                navigationBarItemColors2 = navigationBarItemColors;
                mutableInteractionSource2 = mutableInteractionSource;
                composer2 = composerStartRestartGroup;
                z7 = z4;
                function5 = function4;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return NavigationBarKt.NavigationBarItem$lambda$8(rowScope, z, function0, function2, modifier2, z7, function5, z6, navigationBarItemColors2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 1572864;
        function4 = function3;
        i8 = i2 & 64;
        if (i8 != 0) {
            i3 |= 12582912;
        } else if ((i & 12582912) == 0) {
            if (composerStartRestartGroup.changed(z3)) {
                i9 = 8388608;
            } else {
                i9 = 4194304;
            }
            i3 |= i9;
        }
        if ((i & 100663296) != 0) {
            i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(navigationBarItemColors)) ? 33554432 : 67108864;
        }
        i10 = i2 & 256;
        if (i10 != 0) {
            if ((i & 805306368) == 0) {
                if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                    i11 = C.BUFFER_FLAG_LAST_SAMPLE;
                } else {
                    i11 = 268435456;
                }
                i3 |= i11;
            }
            i12 = i3;
            if ((i3 & 306783379) != 306783378) {
                z5 = true;
            } else {
                z5 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z5, i12 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "206@9394L8");
                if ((i & 1) != 0) {
                    if (i15 != 0) {
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
                        navigationBarItemColorsColors = NavigationBarItemDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                        i13 = i12 & (-234881025);
                    } else {
                        navigationBarItemColorsColors = navigationBarItemColors;
                        i13 = i12;
                    }
                    z9 = z8;
                    i14 = i13;
                    navigationBarItemColors3 = navigationBarItemColorsColors;
                    modifier3 = modifier2;
                    z10 = z4;
                    function6 = function4;
                    if (i10 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                } else {
                    if (i15 != 0) {
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
                        navigationBarItemColorsColors = NavigationBarItemDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                        i13 = i12 & (-234881025);
                    } else {
                        navigationBarItemColorsColors = navigationBarItemColors;
                        i13 = i12;
                    }
                    z9 = z8;
                    i14 = i13;
                    navigationBarItemColors3 = navigationBarItemColorsColors;
                    modifier3 = modifier2;
                    z10 = z4;
                    function6 = function4;
                    if (i10 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(974293026, i14, -1, "androidx.compose.material3.NavigationBarItem (NavigationBar.kt:208)");
                }
                if (mutableInteractionSource3 == null) {
                    composerStartRestartGroup.startReplaceGroup(-224975399);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "210@9546L39");
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -7257271, "CC(remember):NavigationBar.kt#9igjgp");
                    objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue7 = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endReplaceGroup();
                    mutableInteractionSource4 = (MutableInteractionSource) objRememberedValue7;
                } else {
                    composerStartRestartGroup.startReplaceGroup(-7257922);
                    composerStartRestartGroup.endReplaceGroup();
                    mutableInteractionSource4 = mutableInteractionSource3;
                }
                finiteAnimationSpecValue = MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultEffects, composerStartRestartGroup, 6);
                boolean z111116 = z9;
                ComposableLambda composableLambdaRememberComposableLambda1111111 = ComposableLambdaKt.rememberComposableLambda(-876637252, true, new Function2() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda12
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return NavigationBarKt.NavigationBarItem$lambda$1(navigationBarItemColors3, z, z10, finiteAnimationSpecValue, function6, z9, function2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54);
                if (function6 == null) {
                    composerStartRestartGroup.startReplaceGroup(-224048562);
                    composerStartRestartGroup.endReplaceGroup();
                    navigationBarItemColors4 = navigationBarItemColors3;
                    function7 = function6;
                    composableLambda = null;
                } else {
                    composerStartRestartGroup.startReplaceGroup(-224048561);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "*229@10494L521");
                    final NavigationBarItemColors navigationBarItemColors1115 = navigationBarItemColors3;
                    final boolean z111117 = z10;
                    final Function2 function1118 = function6;
                    navigationBarItemColors4 = navigationBarItemColors1115;
                    function7 = function1118;
                    ComposableLambda composableLambdaRememberComposableLambda1111112 = ComposableLambdaKt.rememberComposableLambda(802208206, true, new Function2() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda13
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return NavigationBarKt.NavigationBarItem$lambda$2$0(navigationBarItemColors1115, z, z111117, finiteAnimationSpecValue, function1118, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54);
                    composerStartRestartGroup.endReplaceGroup();
                    composableLambda = composableLambdaRememberComposableLambda1111112;
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -7209213, "CC(remember):NavigationBar.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = SnapshotIntStateKt.mutableIntStateOf(0);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                mutableIntState = (MutableIntState) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                boolean z111118 = z10;
                Modifier modifier19 = modifier3;
                mutableInteractionSource5 = mutableInteractionSource4;
                Modifier modifierWeight$default16 = RowScope.weight$default(rowScope, SizeKt.m1251defaultMinSizeVpY3zN4$default(SelectableKt.m1533selectableO2vRcR0(modifier19, z, mutableInteractionSource5, null, z111118, Role.m8825boximpl(Role.INSTANCE.m8839getTabo7Vup1c()), function0), 0.0f, NavigationBarHeight, 1, null), 1.0f, false, 2, null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -7195078, "CC(remember):NavigationBar.kt#9igjgp");
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new Function1() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda14
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return NavigationBarKt.NavigationBarItem$lambda$6$0(mutableIntState, (IntSize) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifierOnSizeChanged16 = OnRemeasuredModifierKt.onSizeChanged(modifierWeight$default16, (Function1) objRememberedValue2);
                Alignment center16 = Alignment.INSTANCE.getCenter();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy16 = BoxKt.maybeCachedBoxMeasurePolicy(center16, true);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap16 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier16 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierOnSizeChanged16);
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
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1565189072, "C266@11902L7,263@11672L252,272@12214L7,269@11987L249,277@12496L7,278@12539L274,286@12864L146,293@13225L273,301@13547L404,318@14216L32,319@14286L31,312@13961L367:NavigationBar.kt#uh7d8r");
                if (z) {
                    f = 1.0f;
                } else {
                    f = 0.0f;
                }
                final NavigationBarItemColors navigationBarItemColors1116 = navigationBarItemColors4;
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
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1196463086, "CC(remember):NavigationBar.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(density);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda15
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return NavigationBarKt.NavigationBarItem$lambda$7$0$0(density, mutableIntState);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda15
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return NavigationBarKt.NavigationBarItem$lambda$7$0$0(density, mutableIntState);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                function1 = (Function0) objRememberedValue3;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1196473358, "CC(remember):NavigationBar.kt#9igjgp");
                zChanged2 = composerStartRestartGroup.changed(mutableInteractionSource5) | composerStartRestartGroup.changed(function1);
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (!zChanged2) {
                    objRememberedValue4 = new MappedInteractionSource(mutableInteractionSource5, function1);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                } else {
                    objRememberedValue4 = new MappedInteractionSource(mutableInteractionSource5, function1);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                final MappedInteractionSource mappedInteractionSource16 = (MappedInteractionSource) objRememberedValue4;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposableLambda composableLambdaRememberComposableLambda1111113 = ComposableLambdaKt.rememberComposableLambda(-2082182507, true, new Function2() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda16
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return NavigationBarKt.NavigationBarItem$lambda$7$2(mappedInteractionSource16, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54);
                ComposableLambda composableLambdaRememberComposableLambda1111114 = ComposableLambdaKt.rememberComposableLambda(-799524251, true, new Function2() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return NavigationBarKt.NavigationBarItem$lambda$7$3(stateAnimateFloatAsState, navigationBarItemColors1116, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1196516508, "CC(remember):NavigationBar.kt#9igjgp");
                zChanged3 = composerStartRestartGroup.changed(stateAnimateFloatAsState);
                objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                if (!zChanged3) {
                    objRememberedValue5 = new Function0() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return Float.valueOf(NavigationBarKt.NavigationBarItem$lambda$7$4$0(stateAnimateFloatAsState));
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                } else {
                    objRememberedValue5 = new Function0() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return Float.valueOf(NavigationBarKt.NavigationBarItem$lambda$7$4$0(stateAnimateFloatAsState));
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                }
                Function0 function1119 = (Function0) objRememberedValue5;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1196518747, "CC(remember):NavigationBar.kt#9igjgp");
                zChanged4 = composerStartRestartGroup.changed(stateAnimateFloatAsState2);
                objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                if (!zChanged4) {
                    objRememberedValue6 = new Function0() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return Float.valueOf(NavigationBarKt.NavigationBarItem$lambda$7$5$0(stateAnimateFloatAsState2));
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                } else {
                    objRememberedValue6 = new Function0() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return Float.valueOf(NavigationBarKt.NavigationBarItem$lambda$7$5$0(stateAnimateFloatAsState2));
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                NavigationBarItemLayout(composableLambdaRememberComposableLambda1111113, composableLambdaRememberComposableLambda1111114, composableLambdaRememberComposableLambda1111111, composableLambda, z111116, function1119, (Function0) objRememberedValue6, composerStartRestartGroup, ((i14 >> 9) & 57344) | 438);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                navigationBarItemColors2 = navigationBarItemColors1116;
                composer2 = composerStartRestartGroup;
                z7 = z111118;
                mutableInteractionSource2 = mutableInteractionSource3;
                modifier2 = modifier19;
                z6 = z111116;
                function5 = function7;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                z6 = z3;
                navigationBarItemColors2 = navigationBarItemColors;
                mutableInteractionSource2 = mutableInteractionSource;
                composer2 = composerStartRestartGroup;
                z7 = z4;
                function5 = function4;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return NavigationBarKt.NavigationBarItem$lambda$8(rowScope, z, function0, function2, modifier2, z7, function5, z6, navigationBarItemColors2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 805306368;
        i12 = i3;
        if ((i3 & 306783379) != 306783378) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z5, i12 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "206@9394L8");
            if ((i & 1) != 0) {
                if (i15 != 0) {
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
                    navigationBarItemColorsColors = NavigationBarItemDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                    i13 = i12 & (-234881025);
                } else {
                    navigationBarItemColorsColors = navigationBarItemColors;
                    i13 = i12;
                }
                z9 = z8;
                i14 = i13;
                navigationBarItemColors3 = navigationBarItemColorsColors;
                modifier3 = modifier2;
                z10 = z4;
                function6 = function4;
                if (i10 != 0) {
                    mutableInteractionSource3 = null;
                } else {
                    mutableInteractionSource3 = mutableInteractionSource;
                }
            } else {
                if (i15 != 0) {
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
                    navigationBarItemColorsColors = NavigationBarItemDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                    i13 = i12 & (-234881025);
                } else {
                    navigationBarItemColorsColors = navigationBarItemColors;
                    i13 = i12;
                }
                z9 = z8;
                i14 = i13;
                navigationBarItemColors3 = navigationBarItemColorsColors;
                modifier3 = modifier2;
                z10 = z4;
                function6 = function4;
                if (i10 != 0) {
                    mutableInteractionSource3 = null;
                } else {
                    mutableInteractionSource3 = mutableInteractionSource;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(974293026, i14, -1, "androidx.compose.material3.NavigationBarItem (NavigationBar.kt:208)");
            }
            if (mutableInteractionSource3 == null) {
                composerStartRestartGroup.startReplaceGroup(-224975399);
                ComposerKt.sourceInformation(composerStartRestartGroup, "210@9546L39");
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -7257271, "CC(remember):NavigationBar.kt#9igjgp");
                objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue7 = InteractionSourceKt.MutableInteractionSource();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endReplaceGroup();
                mutableInteractionSource4 = (MutableInteractionSource) objRememberedValue7;
            } else {
                composerStartRestartGroup.startReplaceGroup(-7257922);
                composerStartRestartGroup.endReplaceGroup();
                mutableInteractionSource4 = mutableInteractionSource3;
            }
            finiteAnimationSpecValue = MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultEffects, composerStartRestartGroup, 6);
            boolean z111119 = z9;
            ComposableLambda composableLambdaRememberComposableLambda1111115 = ComposableLambdaKt.rememberComposableLambda(-876637252, true, new Function2() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda12
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return NavigationBarKt.NavigationBarItem$lambda$1(navigationBarItemColors3, z, z10, finiteAnimationSpecValue, function6, z9, function2, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54);
            if (function6 == null) {
                composerStartRestartGroup.startReplaceGroup(-224048562);
                composerStartRestartGroup.endReplaceGroup();
                navigationBarItemColors4 = navigationBarItemColors3;
                function7 = function6;
                composableLambda = null;
            } else {
                composerStartRestartGroup.startReplaceGroup(-224048561);
                ComposerKt.sourceInformation(composerStartRestartGroup, "*229@10494L521");
                final NavigationBarItemColors navigationBarItemColors1117 = navigationBarItemColors3;
                final boolean z1111110 = z10;
                final Function2 function11110 = function6;
                navigationBarItemColors4 = navigationBarItemColors1117;
                function7 = function11110;
                ComposableLambda composableLambdaRememberComposableLambda1111116 = ComposableLambdaKt.rememberComposableLambda(802208206, true, new Function2() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda13
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return NavigationBarKt.NavigationBarItem$lambda$2$0(navigationBarItemColors1117, z, z1111110, finiteAnimationSpecValue, function11110, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54);
                composerStartRestartGroup.endReplaceGroup();
                composableLambda = composableLambdaRememberComposableLambda1111116;
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -7209213, "CC(remember):NavigationBar.kt#9igjgp");
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = SnapshotIntStateKt.mutableIntStateOf(0);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            mutableIntState = (MutableIntState) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            boolean z1111111 = z10;
            Modifier modifier110 = modifier3;
            mutableInteractionSource5 = mutableInteractionSource4;
            Modifier modifierWeight$default17 = RowScope.weight$default(rowScope, SizeKt.m1251defaultMinSizeVpY3zN4$default(SelectableKt.m1533selectableO2vRcR0(modifier110, z, mutableInteractionSource5, null, z1111111, Role.m8825boximpl(Role.INSTANCE.m8839getTabo7Vup1c()), function0), 0.0f, NavigationBarHeight, 1, null), 1.0f, false, 2, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -7195078, "CC(remember):NavigationBar.kt#9igjgp");
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function1() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda14
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return NavigationBarKt.NavigationBarItem$lambda$6$0(mutableIntState, (IntSize) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierOnSizeChanged17 = OnRemeasuredModifierKt.onSizeChanged(modifierWeight$default17, (Function1) objRememberedValue2);
            Alignment center17 = Alignment.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy17 = BoxKt.maybeCachedBoxMeasurePolicy(center17, true);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap17 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier17 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierOnSizeChanged17);
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
            BoxScopeInstance boxScopeInstance17 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1565189072, "C266@11902L7,263@11672L252,272@12214L7,269@11987L249,277@12496L7,278@12539L274,286@12864L146,293@13225L273,301@13547L404,318@14216L32,319@14286L31,312@13961L367:NavigationBar.kt#uh7d8r");
            if (z) {
                f = 1.0f;
            } else {
                f = 0.0f;
            }
            final NavigationBarItemColors navigationBarItemColors1118 = navigationBarItemColors4;
            stateAnimateFloatAsState = AnimateAsStateKt.animateFloatAsState(f, MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultEffects, composerStartRestartGroup, 6), 0.0f, null, null, composerStartRestartGroup, 0, 28);
            if (z) {
                f2 = 1.0f;
            } else {
                f2 = 0.0f;
            }
            stateAnimateFloatAsState2 = AnimateAsStateKt.animateFloatAsState(f2, MotionSchemeKt.value(MotionSchemeKeyTokens.FastSpatial, composerStartRestartGroup, 6), 0.0f, null, null, composerStartRestartGroup, 0, 28);
            ProvidableCompositionLocal<Density> localDensity17 = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume17 = composerStartRestartGroup.consume(localDensity17);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            density = (Density) objConsume17;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1196463086, "CC(remember):NavigationBar.kt#9igjgp");
            zChanged = composerStartRestartGroup.changed(density);
            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (!zChanged) {
                objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda15
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return NavigationBarKt.NavigationBarItem$lambda$7$0$0(density, mutableIntState);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            } else {
                objRememberedValue3 = new Function0() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda15
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return NavigationBarKt.NavigationBarItem$lambda$7$0$0(density, mutableIntState);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            function1 = (Function0) objRememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1196473358, "CC(remember):NavigationBar.kt#9igjgp");
            zChanged2 = composerStartRestartGroup.changed(mutableInteractionSource5) | composerStartRestartGroup.changed(function1);
            objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (!zChanged2) {
                objRememberedValue4 = new MappedInteractionSource(mutableInteractionSource5, function1);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            } else {
                objRememberedValue4 = new MappedInteractionSource(mutableInteractionSource5, function1);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            final MappedInteractionSource mappedInteractionSource17 = (MappedInteractionSource) objRememberedValue4;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposableLambda composableLambdaRememberComposableLambda1111117 = ComposableLambdaKt.rememberComposableLambda(-2082182507, true, new Function2() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda16
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return NavigationBarKt.NavigationBarItem$lambda$7$2(mappedInteractionSource17, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54);
            ComposableLambda composableLambdaRememberComposableLambda1111118 = ComposableLambdaKt.rememberComposableLambda(-799524251, true, new Function2() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return NavigationBarKt.NavigationBarItem$lambda$7$3(stateAnimateFloatAsState, navigationBarItemColors1118, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1196516508, "CC(remember):NavigationBar.kt#9igjgp");
            zChanged3 = composerStartRestartGroup.changed(stateAnimateFloatAsState);
            objRememberedValue5 = composerStartRestartGroup.rememberedValue();
            if (!zChanged3) {
                objRememberedValue5 = new Function0() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Float.valueOf(NavigationBarKt.NavigationBarItem$lambda$7$4$0(stateAnimateFloatAsState));
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
            } else {
                objRememberedValue5 = new Function0() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Float.valueOf(NavigationBarKt.NavigationBarItem$lambda$7$4$0(stateAnimateFloatAsState));
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
            }
            Function0 function11111 = (Function0) objRememberedValue5;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1196518747, "CC(remember):NavigationBar.kt#9igjgp");
            zChanged4 = composerStartRestartGroup.changed(stateAnimateFloatAsState2);
            objRememberedValue6 = composerStartRestartGroup.rememberedValue();
            if (!zChanged4) {
                objRememberedValue6 = new Function0() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Float.valueOf(NavigationBarKt.NavigationBarItem$lambda$7$5$0(stateAnimateFloatAsState2));
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
            } else {
                objRememberedValue6 = new Function0() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Float.valueOf(NavigationBarKt.NavigationBarItem$lambda$7$5$0(stateAnimateFloatAsState2));
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            NavigationBarItemLayout(composableLambdaRememberComposableLambda1111117, composableLambdaRememberComposableLambda1111118, composableLambdaRememberComposableLambda1111115, composableLambda, z111119, function11111, (Function0) objRememberedValue6, composerStartRestartGroup, ((i14 >> 9) & 57344) | 438);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            navigationBarItemColors2 = navigationBarItemColors1118;
            composer2 = composerStartRestartGroup;
            z7 = z1111111;
            mutableInteractionSource2 = mutableInteractionSource3;
            modifier2 = modifier110;
            z6 = z111119;
            function5 = function7;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            z6 = z3;
            navigationBarItemColors2 = navigationBarItemColors;
            mutableInteractionSource2 = mutableInteractionSource;
            composer2 = composerStartRestartGroup;
            z7 = z4;
            function5 = function4;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return NavigationBarKt.NavigationBarItem$lambda$8(rowScope, z, function0, function2, modifier2, z7, function5, z6, navigationBarItemColors2, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NavigationBarItem$lambda$1(NavigationBarItemColors navigationBarItemColors, boolean z, boolean z2, FiniteAnimationSpec finiteAnimationSpec, Function2 function2, boolean z3, Function2 function3, Composer composer, int i) {
        Modifier.Companion companionClearAndSetSemantics;
        ComposerKt.sourceInformation(composer, "C216@9827L186,222@10195L193:NavigationBar.kt#uh7d8r");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-876637252, i, -1, "androidx.compose.material3.NavigationBarItem.<anonymous> (NavigationBar.kt:215)");
            }
            State<Color> stateM437animateColorAsStateeuL9pac = SingleValueAnimationKt.m437animateColorAsStateeuL9pac(navigationBarItemColors.m3833iconColorWaAFU9c$material3(z, z2), finiteAnimationSpec, null, null, composer, 0, 12);
            if (function2 == null || !(z3 || z)) {
                composer.startReplaceGroup(-634793532);
                composer.endReplaceGroup();
                companionClearAndSetSemantics = Modifier.INSTANCE;
            } else {
                composer.startReplaceGroup(-634794445);
                ComposerKt.sourceInformation(composer, "222@10260L2");
                Modifier.Companion companion = Modifier.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composer, -634793794, "CC(remember):NavigationBar.kt#9igjgp");
                Object objRememberedValue = composer.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function1() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda11
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return NavigationBarKt.NavigationBarItem$lambda$1$1$0((SemanticsPropertyReceiver) obj);
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
            ComposerKt.sourceInformationMarkerStart(composer, 192646451, "C223@10296L78:NavigationBar.kt#uh7d8r");
            CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m6804boximpl(NavigationBarItem$lambda$1$0(stateM437animateColorAsStateeuL9pac))), (Function2<? super Composer, ? super Integer, Unit>) function3, composer, ProvidedValue.$stable);
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
    public static final Unit NavigationBarItem$lambda$1$1$0(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NavigationBarItem$lambda$2$0(NavigationBarItemColors navigationBarItemColors, boolean z, boolean z2, FiniteAnimationSpec finiteAnimationSpec, Function2 function2, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C230@10558L5,232@10617L198,236@10832L169:NavigationBar.kt#uh7d8r");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(802208206, i, -1, "androidx.compose.material3.NavigationBarItem.<anonymous>.<anonymous> (NavigationBar.kt:230)");
            }
            ProvideContentColorTextStyleKt.m4997ProvideContentColorTextStyle3JVO9M(NavigationBarItem$lambda$2$0$0(SingleValueAnimationKt.m437animateColorAsStateeuL9pac(navigationBarItemColors.m3834textColorWaAFU9c$material3(z, z2), finiteAnimationSpec, null, null, composer, 0, 12)), TypographyKt.getValue(NavigationBarTokens.INSTANCE.getLabelTextFont(), composer, 6), function2, composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    private static final int NavigationBarItem$lambda$4(MutableIntState mutableIntState) {
        return mutableIntState.getIntValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NavigationBarItem$lambda$6$0(MutableIntState mutableIntState, IntSize intSize) {
        mutableIntState.setIntValue((int) (intSize.m9862unboximpl() >> 32));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Offset NavigationBarItem$lambda$7$0$0(Density density, MutableIntState mutableIntState) {
        float fNavigationBarItem$lambda$4 = (NavigationBarItem$lambda$4(mutableIntState) - density.mo748roundToPx0680j_4(NavigationBarVerticalItemTokens.INSTANCE.m5557getActiveIndicatorWidthD9Ej5fM())) / 2;
        return Offset.m6558boximpl(Offset.m6561constructorimpl((((long) Float.floatToRawIntBits(density.mo754toPx0680j_4(IndicatorVerticalOffset))) & 4294967295L) | (Float.floatToRawIntBits(fNavigationBarItem$lambda$4) << 32)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NavigationBarItem$lambda$7$2(MappedInteractionSource mappedInteractionSource, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C296@13389L5,294@13243L241:NavigationBar.kt#uh7d8r");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2082182507, i, -1, "androidx.compose.material3.NavigationBarItem.<anonymous>.<anonymous> (NavigationBar.kt:294)");
            }
            BoxKt.Box(IndicationKt.indication(ClipKt.clip(LayoutIdKt.layoutId(Modifier.INSTANCE, IndicatorRippleLayoutIdTag), ShapesKt.getValue(NavigationBarTokens.INSTANCE.getItemActiveIndicatorShape(), composer, 6)), mappedInteractionSource, RippleKt.m4031rippleH2RKhps$default(false, 0.0f, 0L, 7, null)), composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NavigationBarItem$lambda$7$3(final State state, NavigationBarItemColors navigationBarItemColors, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C304@13669L40,307@13887L5,302@13565L372:NavigationBar.kt#uh7d8r");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-799524251, i, -1, "androidx.compose.material3.NavigationBarItem.<anonymous>.<anonymous> (NavigationBar.kt:302)");
            }
            Modifier modifierLayoutId = LayoutIdKt.layoutId(Modifier.INSTANCE, IndicatorLayoutIdTag);
            ComposerKt.sourceInformationMarkerStart(composer, 456344717, "CC(remember):NavigationBar.kt#9igjgp");
            boolean zChanged = composer.changed(state);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return NavigationBarKt.NavigationBarItem$lambda$7$3$0$0(state, (GraphicsLayerScope) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            BoxKt.Box(BackgroundKt.m588backgroundbw27NRU(GraphicsLayerModifierKt.graphicsLayer(modifierLayoutId, (Function1) objRememberedValue), navigationBarItemColors.getSelectedIndicatorColor(), ShapesKt.getValue(NavigationBarTokens.INSTANCE.getItemActiveIndicatorShape(), composer, 6)), composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NavigationBarItem$lambda$7$3$0$0(State state, GraphicsLayerScope graphicsLayerScope) {
        graphicsLayerScope.setAlpha(((Number) state.getValue()).floatValue());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float NavigationBarItem$lambda$7$4$0(State state) {
        return ((Number) state.getValue()).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float NavigationBarItem$lambda$7$5$0(State state) {
        return ((Number) state.getValue()).floatValue();
    }

    private static final void NavigationBarItemLayout(final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function3, final Function2<? super Composer, ? super Integer, Unit> function4, final Function2<? super Composer, ? super Integer, Unit> function5, final boolean z, final Function0<Float> function0, final Function0<Float> function1, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1019541078);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(NavigationBarItemLayout)N(indicatorRipple,indicator,icon,label,alwaysShowLabel,alphaAnimationProgress,sizeAnimationProgress)577@25586L1844,559@25065L2365:NavigationBar.kt#uh7d8r");
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
                ComposerKt.traceEventStart(-1019541078, i2, -1, "androidx.compose.material3.NavigationBarItemLayout (NavigationBar.kt:558)");
            }
            Modifier modifierBadgeBounds = BadgeKt.badgeBounds(Modifier.INSTANCE);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -526404226, "CC(remember):NavigationBar.kt#9igjgp");
            int i3 = 57344 & i2;
            boolean z2 = ((3670016 & i2) == 1048576) | ((i2 & 7168) == 2048) | (i3 == 16384);
            MeasurePolicy measurePolicyRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z2 || measurePolicyRememberedValue == Composer.INSTANCE.getEmpty()) {
                measurePolicyRememberedValue = new MeasurePolicy() { // from class: androidx.compose.material3.NavigationBarKt$NavigationBarItemLayout$1$1
                    @Override // androidx.compose.ui.layout.MeasurePolicy
                    /* JADX INFO: renamed from: measure-3p2s80s */
                    public final MeasureResult mo344measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
                        Placeable placeableMo8265measureBRTryo0;
                        Measurable measurable;
                        float fCoerceAtLeast = RangesKt.coerceAtLeast(function1.invoke().floatValue(), 0.0f);
                        long jM9630copyZbe2FdA$default = Constraints.m9630copyZbe2FdA$default(j, 0, 0, 0, 0, 10, null);
                        List<? extends Measurable> list2 = list;
                        int size = list2.size();
                        for (int i4 = 0; i4 < size; i4++) {
                            Measurable measurable2 = list.get(i4);
                            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable2), HubsObservability.HUB_ASSET_ICON)) {
                                Placeable placeableMo8265measureBRTryo1 = measurable2.mo8265measureBRTryo0(jM9630copyZbe2FdA$default);
                                float f = 2;
                                int width = placeableMo8265measureBRTryo1.getWidth() + measureScope.mo748roundToPx0680j_4(Dp.m9687constructorimpl(NavigationBarKt.IndicatorHorizontalPadding * f));
                                int iRoundToInt = MathKt.roundToInt(width * fCoerceAtLeast);
                                int height = placeableMo8265measureBRTryo1.getHeight() + measureScope.mo748roundToPx0680j_4(Dp.m9687constructorimpl(NavigationBarKt.getIndicatorVerticalPadding() * f));
                                int size2 = list2.size();
                                for (int i5 = 0; i5 < size2; i5++) {
                                    Measurable measurable3 = list.get(i5);
                                    if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable3), "indicatorRipple")) {
                                        Placeable placeableMo8265measureBRTryo2 = measurable3.mo8265measureBRTryo0(Constraints.INSTANCE.m9650fixedJhjzzOo(width, height));
                                        int size3 = list2.size();
                                        int i6 = 0;
                                        while (true) {
                                            placeableMo8265measureBRTryo0 = null;
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
                                        }
                                        if (function5 == null) {
                                            return NavigationBarKt.m3844placeIconX9ElhV4(measureScope, placeableMo8265measureBRTryo1, placeableMo8265measureBRTryo2, placeableMo8265measureBRTryo3, j);
                                        }
                                        Intrinsics.checkNotNull(placeableMo8265measureBRTryo0);
                                        return NavigationBarKt.m3845placeLabelAndIconzUg2_y0(measureScope, placeableMo8265measureBRTryo0, placeableMo8265measureBRTryo1, placeableMo8265measureBRTryo2, placeableMo8265measureBRTryo3, j, z, fCoerceAtLeast);
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -660603938, "C562@25148L17,563@25178L11,565@25203L50:NavigationBar.kt#uh7d8r");
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1252746358, "C565@25245L6:NavigationBar.kt#uh7d8r");
            function4.invoke(composerStartRestartGroup, Integer.valueOf((i4 >> 6) & 14));
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (function5 != null) {
                composerStartRestartGroup.startReplaceGroup(-660471321);
                ComposerKt.sourceInformation(composerStartRestartGroup, "569@25379L109,568@25304L250");
                Modifier modifierLayoutId2 = LayoutIdKt.layoutId(Modifier.INSTANCE, "label");
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1641265262, "CC(remember):NavigationBar.kt#9igjgp");
                boolean z3 = (i3 == 16384) | ((i4 & 458752) == 131072);
                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (z3 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function1() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return NavigationBarKt.NavigationBarItemLayout$lambda$1$1$0(z, function0, (GraphicsLayerScope) obj);
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
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 874979034, "C573@25529L7:NavigationBar.kt#uh7d8r");
                function5.invoke(composerStartRestartGroup, Integer.valueOf((i4 >> 9) & 14));
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            } else {
                composerStartRestartGroup.startReplaceGroup(-685564767);
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return NavigationBarKt.NavigationBarItemLayout$lambda$2(function2, function3, function4, function5, z, function0, function1, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NavigationBarItemLayout$lambda$1$1$0(boolean z, Function0 function0, GraphicsLayerScope graphicsLayerScope) {
        graphicsLayerScope.setAlpha(z ? 1.0f : ((Number) function0.invoke()).floatValue());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: placeIcon-X9ElhV4, reason: not valid java name */
    public static final MeasureResult m3844placeIconX9ElhV4(MeasureScope measureScope, final Placeable placeable, final Placeable placeable2, final Placeable placeable3, long j) {
        int iM9640getMaxWidthimpl;
        if (Constraints.m9640getMaxWidthimpl(j) == Integer.MAX_VALUE) {
            iM9640getMaxWidthimpl = placeable.getWidth() + (measureScope.mo748roundToPx0680j_4(NavigationBarItemToIconMinimumPadding) * 2);
        } else {
            iM9640getMaxWidthimpl = Constraints.m9640getMaxWidthimpl(j);
        }
        final int i = iM9640getMaxWidthimpl;
        final int iM9656constrainHeightK40F9xA = ConstraintsKt.m9656constrainHeightK40F9xA(j, measureScope.mo748roundToPx0680j_4(NavigationBarHeight));
        final int width = (i - placeable.getWidth()) / 2;
        final int height = (iM9656constrainHeightK40F9xA - placeable.getHeight()) / 2;
        final int width2 = (i - placeable2.getWidth()) / 2;
        final int height2 = (iM9656constrainHeightK40F9xA - placeable2.getHeight()) / 2;
        return MeasureScope.layout$default(measureScope, i, iM9656constrainHeightK40F9xA, null, new Function1() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return NavigationBarKt.placeIcon_X9ElhV4$lambda$0(placeable3, placeable, width, height, placeable2, width2, height2, i, iM9656constrainHeightK40F9xA, (Placeable.PlacementScope) obj);
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
    public static final MeasureResult m3845placeLabelAndIconzUg2_y0(final MeasureScope measureScope, final Placeable placeable, final Placeable placeable2, final Placeable placeable3, final Placeable placeable4, long j, final boolean z, final float f) {
        int iM9640getMaxWidthimpl;
        float height = placeable2.getHeight();
        float f2 = IndicatorVerticalPadding;
        float f3 = height + measureScope.mo754toPx0680j_4(f2);
        float f4 = NavigationBarIndicatorToLabelPadding;
        float f5 = f3 + measureScope.mo754toPx0680j_4(f4) + placeable.getHeight();
        float f6 = 2;
        final float fCoerceAtLeast = RangesKt.coerceAtLeast((Constraints.m9641getMinHeightimpl(j) - f5) / f6, measureScope.mo754toPx0680j_4(f2));
        float f7 = f5 + (fCoerceAtLeast * f6);
        final float height2 = ((z ? fCoerceAtLeast : (f7 - placeable2.getHeight()) / f6) - fCoerceAtLeast) * (1 - f);
        final float height3 = placeable2.getHeight() + fCoerceAtLeast + measureScope.mo754toPx0680j_4(f2) + measureScope.mo754toPx0680j_4(f4);
        if (Constraints.m9640getMaxWidthimpl(j) == Integer.MAX_VALUE) {
            iM9640getMaxWidthimpl = placeable2.getWidth() + (measureScope.mo748roundToPx0680j_4(NavigationBarItemToIconMinimumPadding) * 2);
        } else {
            iM9640getMaxWidthimpl = Constraints.m9640getMaxWidthimpl(j);
        }
        final int i = iM9640getMaxWidthimpl;
        final int width = (i - placeable.getWidth()) / 2;
        final int width2 = (i - placeable2.getWidth()) / 2;
        final int width3 = (i - placeable3.getWidth()) / 2;
        final float f8 = fCoerceAtLeast - measureScope.mo754toPx0680j_4(f2);
        return MeasureScope.layout$default(measureScope, i, MathKt.roundToInt(f7), null, new Function1() { // from class: androidx.compose.material3.NavigationBarKt$$ExternalSyntheticLambda8
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return NavigationBarKt.placeLabelAndIcon_zUg2_y0$lambda$0(placeable4, z, f, placeable, width, height3, height2, placeable2, width2, fCoerceAtLeast, placeable3, width3, f8, i, measureScope, (Placeable.PlacementScope) obj);
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit placeLabelAndIcon_zUg2_y0$lambda$0(Placeable placeable, boolean z, float f, Placeable placeable2, int i, float f2, float f3, Placeable placeable3, int i2, float f4, Placeable placeable4, int i3, float f5, int i4, MeasureScope measureScope, Placeable.PlacementScope placementScope) {
        if (placeable != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable, (i4 - placeable.getWidth()) / 2, MathKt.roundToInt((f4 - measureScope.mo748roundToPx0680j_4(IndicatorVerticalPadding)) + f3), 0.0f, 4, null);
        }
        if (z || f != 0.0f) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable2, i, MathKt.roundToInt(f2 + f3), 0.0f, 4, null);
        }
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable3, i2, MathKt.roundToInt(f4 + f3), 0.0f, 4, null);
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable4, i3, MathKt.roundToInt(f5 + f3), 0.0f, 4, null);
        return Unit.INSTANCE;
    }

    static {
        float f = 2;
        IndicatorHorizontalPadding = Dp.m9687constructorimpl(Dp.m9687constructorimpl(NavigationBarVerticalItemTokens.INSTANCE.m5557getActiveIndicatorWidthD9Ej5fM() - NavigationBarVerticalItemTokens.INSTANCE.m5559getIconSizeD9Ej5fM()) / f);
        IndicatorVerticalPadding = Dp.m9687constructorimpl(Dp.m9687constructorimpl(NavigationBarVerticalItemTokens.INSTANCE.m5556getActiveIndicatorHeightD9Ej5fM() - NavigationBarVerticalItemTokens.INSTANCE.m5559getIconSizeD9Ej5fM()) / f);
    }

    public static final float getNavigationBarItemHorizontalPadding() {
        return NavigationBarItemHorizontalPadding;
    }

    public static final float getNavigationBarIndicatorToLabelPadding() {
        return NavigationBarIndicatorToLabelPadding;
    }

    public static final float getIndicatorVerticalPadding() {
        return IndicatorVerticalPadding;
    }

    public static final float getNavigationBarItemToIconMinimumPadding() {
        return NavigationBarItemToIconMinimumPadding;
    }

    public static final ProvidableCompositionLocal<NavigationBarOverride> getLocalNavigationBarOverride() {
        return LocalNavigationBarOverride;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final NavigationBarOverride LocalNavigationBarOverride$lambda$0() {
        return DefaultNavigationBarOverride.INSTANCE;
    }

    private static final long NavigationBarItem$lambda$1$0(State<Color> state) {
        return state.getValue().m6824unboximpl();
    }

    private static final long NavigationBarItem$lambda$2$0$0(State<Color> state) {
        return state.getValue().m6824unboximpl();
    }
}
