package androidx.compose.material;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsKt;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
import androidx.compose.foundation.selection.SelectableGroupKt;
import androidx.compose.foundation.selection.SelectableKt;
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
import androidx.compose.ui.draw.AlphaKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.layout.AlignmentLineKt;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.util.ListUtilsKt;
import androidx.media3.common.C;
import androidx.profileinstaller.ProfileVerifier;
import com.box.android.domain.analytics.BoxAnalyticsParams;
import com.box.android.domain.metrics.hubs.HubsObservability;
import com.facebook.react.uimanager.ViewProps;
import external.sdk.pendo.io.mozilla.javascript.Token;
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

/* JADX INFO: compiled from: NavigationRail.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000x\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\u001a\u007f\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\n2 \b\u0002\u0010\u000b\u001a\u001a\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0001\u0018\u00010\f¢\u0006\u0002\b\u000e¢\u0006\u0002\b\u000f2\u001c\u0010\u0010\u001a\u0018\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00010\f¢\u0006\u0002\b\u000e¢\u0006\u0002\b\u000fH\u0007¢\u0006\u0004\b\u0011\u0010\u0012\u001aw\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\n2 \b\u0002\u0010\u000b\u001a\u001a\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0001\u0018\u00010\f¢\u0006\u0002\b\u000e¢\u0006\u0002\b\u000f2\u001c\u0010\u0010\u001a\u0018\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00010\f¢\u0006\u0002\b\u000e¢\u0006\u0002\b\u000fH\u0007¢\u0006\u0004\b\u0013\u0010\u0014\u001a\u008d\u0001\u0010\u0015\u001a\u00020\u00012\u0006\u0010\u0016\u001a\u00020\u00172\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00010\u00192\u0011\u0010\u001a\u001a\r\u0012\u0004\u0012\u00020\u00010\u0019¢\u0006\u0002\b\u000e2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u001b\u001a\u00020\u00172\u0015\b\u0002\u0010\u001c\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0019¢\u0006\u0002\b\u000e2\b\b\u0002\u0010\u001d\u001a\u00020\u00172\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020\u00072\b\b\u0002\u0010!\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\"\u0010#\u001aO\u0010$\u001a\u00020\u00012\u0006\u0010%\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00172&\u0010\u0010\u001a\"\u0012\u0013\u0012\u00110'¢\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(*\u0012\u0004\u0012\u00020\u00010\f¢\u0006\u0002\b\u000eH\u0003¢\u0006\u0004\b+\u0010,\u001a?\u0010-\u001a\u00020\u00012\u0011\u0010\u001a\u001a\r\u0012\u0004\u0012\u00020\u00010\u0019¢\u0006\u0002\b\u000e2\u0013\u0010\u001c\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0019¢\u0006\u0002\b\u000e2\b\b\u0001\u0010.\u001a\u00020'H\u0003¢\u0006\u0002\u0010/\u001a#\u00100\u001a\u000201*\u0002022\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u000206H\u0002¢\u0006\u0004\b7\u00108\u001a5\u00109\u001a\u000201*\u0002022\u0006\u0010:\u001a\u0002042\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u0002062\b\b\u0001\u0010.\u001a\u00020'H\u0002¢\u0006\u0004\b;\u0010<\"\u0014\u0010=\u001a\b\u0012\u0004\u0012\u00020'0>X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010?\u001a\u00020\nX\u0082\u0004¢\u0006\u0004\n\u0002\u0010@\"\u0010\u0010A\u001a\u00020\nX\u0082\u0004¢\u0006\u0004\n\u0002\u0010@\"\u0010\u0010B\u001a\u00020\nX\u0082\u0004¢\u0006\u0004\n\u0002\u0010@\"\u0010\u0010C\u001a\u00020\nX\u0082\u0004¢\u0006\u0004\n\u0002\u0010@\"\u0010\u0010D\u001a\u00020\nX\u0082\u0004¢\u0006\u0004\n\u0002\u0010@\"\u0010\u0010E\u001a\u00020\nX\u0082\u0004¢\u0006\u0004\n\u0002\u0010@\"\u000e\u0010F\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006G²\u0006\n\u0010*\u001a\u00020'X\u008a\u0084\u0002"}, d2 = {"NavigationRail", "", "windowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "modifier", "Landroidx/compose/ui/Modifier;", "backgroundColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "elevation", "Landroidx/compose/ui/unit/Dp;", BoxAnalyticsParams.CTA_LOCATION_HEADER, "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "content", "NavigationRail-afqeVBk", "(Landroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/ui/Modifier;JJFLkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "NavigationRail-HsRjFd4", "(Landroidx/compose/ui/Modifier;JJFLkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "NavigationRailItem", "selected", "", ViewProps.ON_CLICK, "Lkotlin/Function0;", HubsObservability.HUB_ASSET_ICON, "enabled", "label", "alwaysShowLabel", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "selectedContentColor", "unselectedContentColor", "NavigationRailItem-0S3VyRs", "(ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;JJLandroidx/compose/runtime/Composer;II)V", "NavigationRailTransition", "activeColor", "inactiveColor", "", "Lkotlin/ParameterName;", "name", "animationProgress", "NavigationRailTransition-Klgx-Pg", "(JJZLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;I)V", "NavigationRailItemBaselineLayout", "iconPositionAnimationProgress", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;FLandroidx/compose/runtime/Composer;I)V", "placeIcon", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "iconPlaceable", "Landroidx/compose/ui/layout/Placeable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "placeIcon-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Placeable;J)Landroidx/compose/ui/layout/MeasureResult;", "placeLabelAndIcon", "labelPlaceable", "placeLabelAndIcon-DIyivk0", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;JF)Landroidx/compose/ui/layout/MeasureResult;", "NavigationRailAnimationSpec", "Landroidx/compose/animation/core/TweenSpec;", "NavigationRailItemSize", "F", "NavigationRailItemCompactSize", "NavigationRailPadding", "HeaderPadding", "ItemLabelBaselineBottomOffset", "ItemIconTopOffset", "ZeroInsets", "material"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class NavigationRailKt {
    private static final float HeaderPadding;
    private static final float NavigationRailPadding;
    private static final TweenSpec<Float> NavigationRailAnimationSpec = new TweenSpec<>(300, 0, EasingKt.getFastOutSlowInEasing(), 2, null);
    private static final float NavigationRailItemSize = Dp.m9687constructorimpl(72);
    private static final float NavigationRailItemCompactSize = Dp.m9687constructorimpl(56);
    private static final float ItemLabelBaselineBottomOffset = Dp.m9687constructorimpl(16);
    private static final float ItemIconTopOffset = Dp.m9687constructorimpl(14);
    private static final WindowInsets ZeroInsets = WindowInsetsKt.m1293WindowInsetsa9UjIt4$default(Dp.m9687constructorimpl(0), 0.0f, 0.0f, 0.0f, 14, null);

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NavigationRailItemBaselineLayout$lambda$2(Function2 function2, Function2 function3, float f, int i, Composer composer, int i2) {
        NavigationRailItemBaselineLayout(function2, function3, f, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NavigationRailItem_0S3VyRs$lambda$2(boolean z, Function0 function0, Function2 function2, Modifier modifier, boolean z2, Function2 function3, boolean z3, MutableInteractionSource mutableInteractionSource, long j, long j2, int i, int i2, Composer composer, int i3) {
        m2475NavigationRailItem0S3VyRs(z, function0, function2, modifier, z2, function3, z3, mutableInteractionSource, j, j2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NavigationRailTransition_Klgx_Pg$lambda$2(long j, long j2, boolean z, Function3 function3, int i, Composer composer, int i2) {
        m2476NavigationRailTransitionKlgxPg(j, j2, z, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NavigationRail_HsRjFd4$lambda$0(Modifier modifier, long j, long j2, float f, Function3 function3, Function3 function4, int i, int i2, Composer composer, int i3) {
        m2473NavigationRailHsRjFd4(modifier, j, j2, f, function3, function4, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NavigationRail_afqeVBk$lambda$1(WindowInsets windowInsets, Modifier modifier, long j, long j2, float f, Function3 function3, Function3 function4, int i, int i2, Composer composer, int i3) {
        m2474NavigationRailafqeVBk(windowInsets, modifier, j, j2, f, function3, function4, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0138  */
    /* JADX WARN: Code duplicated, block: B:102:0x013b  */
    /* JADX WARN: Code duplicated, block: B:103:0x0148  */
    /* JADX WARN: Code duplicated, block: B:106:0x015f  */
    /* JADX WARN: Code duplicated, block: B:109:0x0199  */
    /* JADX WARN: Code duplicated, block: B:111:0x01a2  */
    /* JADX WARN: Code duplicated, block: B:114:0x01b3  */
    /* JADX WARN: Code duplicated, block: B:116:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:23:0x0044  */
    /* JADX WARN: Code duplicated, block: B:25:0x0048  */
    /* JADX WARN: Code duplicated, block: B:27:0x0050  */
    /* JADX WARN: Code duplicated, block: B:28:0x0053  */
    /* JADX WARN: Code duplicated, block: B:31:0x0059  */
    /* JADX WARN: Code duplicated, block: B:34:0x005f  */
    /* JADX WARN: Code duplicated, block: B:39:0x006e  */
    /* JADX WARN: Code duplicated, block: B:41:0x0072  */
    /* JADX WARN: Code duplicated, block: B:44:0x0078  */
    /* JADX WARN: Code duplicated, block: B:45:0x007b  */
    /* JADX WARN: Code duplicated, block: B:47:0x007f  */
    /* JADX WARN: Code duplicated, block: B:49:0x0087  */
    /* JADX WARN: Code duplicated, block: B:50:0x008a  */
    /* JADX WARN: Code duplicated, block: B:55:0x0096  */
    /* JADX WARN: Code duplicated, block: B:56:0x0098  */
    /* JADX WARN: Code duplicated, block: B:58:0x009b  */
    /* JADX WARN: Code duplicated, block: B:60:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:61:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:66:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:68:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:69:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:73:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:74:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:77:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:79:0x00e4  */
    /* JADX WARN: Code duplicated, block: B:89:0x0107 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:90:0x0109  */
    /* JADX WARN: Code duplicated, block: B:91:0x010e  */
    /* JADX WARN: Code duplicated, block: B:94:0x0114  */
    /* JADX WARN: Code duplicated, block: B:97:0x0125  */
    /* JADX WARN: Code duplicated, block: B:99:0x0131  */
    /* JADX INFO: renamed from: NavigationRail-afqeVBk, reason: not valid java name */
    public static final void m2474NavigationRailafqeVBk(final WindowInsets windowInsets, Modifier modifier, long j, long j2, float f, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function4, Composer composer, final int i, final int i2) {
        int i3;
        long jM2346getSurface0d7_KjU;
        long jM2360contentColorForek8zF_U;
        int i4;
        float f2;
        int i5;
        int i6;
        Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function5;
        int i7;
        boolean z;
        Composer composer2;
        final Modifier modifier2;
        final long j3;
        final long j4;
        final float f3;
        final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function6;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        float fM2464getElevationD9Ej5fM;
        float f4;
        long j5;
        int i8;
        Modifier modifier3;
        long j6;
        int i9;
        int i10;
        Composer composerStartRestartGroup = composer.startRestartGroup(-171916405);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(NavigationRail)N(windowInsets,modifier,backgroundColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,elevation:c#ui.unit.Dp,header,content)114@5148L442,109@5003L587:NavigationRail.kt#jmzs0o");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(windowInsets) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i11 = i2 & 2;
        if (i11 == 0) {
            if ((i & 48) == 0) {
                i3 |= composerStartRestartGroup.changed(modifier) ? 32 : 16;
            }
            if ((i & 384) == 0) {
                if ((i2 & 4) == 0) {
                    jM2346getSurface0d7_KjU = j;
                    int i12 = composerStartRestartGroup.changed(jM2346getSurface0d7_KjU) ? 256 : 128;
                    i3 |= i12;
                } else {
                    jM2346getSurface0d7_KjU = j;
                }
                i3 |= i12;
            } else {
                jM2346getSurface0d7_KjU = j;
            }
            if ((i & 3072) == 0) {
                jM2360contentColorForek8zF_U = j2;
                if ((i2 & 8) == 0 || !composerStartRestartGroup.changed(jM2360contentColorForek8zF_U)) {
                    i10 = 1024;
                } else {
                    i10 = 2048;
                }
                i3 |= i10;
            } else {
                jM2360contentColorForek8zF_U = j2;
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
                i6 = i2 & 32;
                if (i6 != 0) {
                    if ((196608 & i) == 0) {
                        function5 = function3;
                        if (composerStartRestartGroup.changedInstance(function5)) {
                            i7 = 131072;
                        } else {
                            i7 = 65536;
                        }
                        i3 |= i7;
                    }
                    if ((i & 1572864) == 0) {
                        if (composerStartRestartGroup.changedInstance(function4)) {
                            i9 = 1048576;
                        } else {
                            i9 = 524288;
                        }
                        i3 |= i9;
                    }
                    if ((i3 & 599187) != 599186) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "103@4758L6,104@4800L32");
                        if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            if (i11 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if ((i2 & 4) != 0) {
                                jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                                i3 &= -897;
                            }
                            if ((i2 & 8) != 0) {
                                jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 6) & 14);
                                i3 &= -7169;
                            }
                            if (i4 != 0) {
                                fM2464getElevationD9Ej5fM = NavigationRailDefaults.INSTANCE.m2464getElevationD9Ej5fM();
                            } else {
                                fM2464getElevationD9Ej5fM = f2;
                            }
                            if (i6 != 0) {
                                function6 = null;
                                long j7 = jM2360contentColorForek8zF_U;
                                modifier3 = companion;
                                j6 = j7;
                                f4 = fM2464getElevationD9Ej5fM;
                                j5 = jM2346getSurface0d7_KjU;
                                i8 = -171916405;
                            } else {
                                f4 = fM2464getElevationD9Ej5fM;
                                j5 = jM2346getSurface0d7_KjU;
                                function6 = function5;
                                i8 = -171916405;
                                long j8 = jM2360contentColorForek8zF_U;
                                modifier3 = companion;
                                j6 = j8;
                            }
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i2 & 4) != 0) {
                                i3 &= -897;
                            }
                            if ((i2 & 8) != 0) {
                                i3 &= -7169;
                            }
                            f4 = f2;
                            function6 = function5;
                            i8 = -171916405;
                            j5 = jM2346getSurface0d7_KjU;
                            j6 = jM2360contentColorForek8zF_U;
                            modifier3 = modifier;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(i8, i3, -1, "androidx.compose.material.NavigationRail (NavigationRail.kt:108)");
                        }
                        composer2 = composerStartRestartGroup;
                        SurfaceKt.m2584SurfaceFjzlyU(modifier3, null, j5, j6, null, f4, ComposableLambdaKt.rememberComposableLambda(366031815, true, new Function2() { // from class: androidx.compose.material.NavigationRailKt$$ExternalSyntheticLambda8
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return NavigationRailKt.NavigationRail_afqeVBk$lambda$0(windowInsets, function6, function4, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54), composer2, 1572864 | ((i3 >> 3) & 14) | (i3 & 896) | (i3 & 7168) | ((i3 << 3) & 458752), 18);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier2 = modifier3;
                        j3 = j5;
                        j4 = j6;
                        f3 = f4;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        modifier2 = modifier;
                        j3 = jM2346getSurface0d7_KjU;
                        j4 = jM2360contentColorForek8zF_U;
                        f3 = f2;
                        function6 = function5;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.NavigationRailKt$$ExternalSyntheticLambda9
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return NavigationRailKt.NavigationRail_afqeVBk$lambda$1(windowInsets, modifier2, j3, j4, f3, function6, function4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                function5 = function3;
                if ((i & 1572864) == 0) {
                    if (composerStartRestartGroup.changedInstance(function4)) {
                        i9 = 1048576;
                    } else {
                        i9 = 524288;
                    }
                    i3 |= i9;
                }
                if ((i3 & 599187) != 599186) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "103@4758L6,104@4800L32");
                    if ((i & 1) != 0) {
                        if (i11 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i2 & 4) != 0) {
                            jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                            i3 &= -897;
                        }
                        if ((i2 & 8) != 0) {
                            jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 6) & 14);
                            i3 &= -7169;
                        }
                        if (i4 != 0) {
                            fM2464getElevationD9Ej5fM = NavigationRailDefaults.INSTANCE.m2464getElevationD9Ej5fM();
                        } else {
                            fM2464getElevationD9Ej5fM = f2;
                        }
                        if (i6 != 0) {
                            function6 = null;
                            long j9 = jM2360contentColorForek8zF_U;
                            modifier3 = companion;
                            j6 = j9;
                            f4 = fM2464getElevationD9Ej5fM;
                            j5 = jM2346getSurface0d7_KjU;
                            i8 = -171916405;
                        } else {
                            f4 = fM2464getElevationD9Ej5fM;
                            j5 = jM2346getSurface0d7_KjU;
                            function6 = function5;
                            i8 = -171916405;
                            long j10 = jM2360contentColorForek8zF_U;
                            modifier3 = companion;
                            j6 = j10;
                        }
                    } else {
                        if (i11 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i2 & 4) != 0) {
                            jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                            i3 &= -897;
                        }
                        if ((i2 & 8) != 0) {
                            jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 6) & 14);
                            i3 &= -7169;
                        }
                        if (i4 != 0) {
                            fM2464getElevationD9Ej5fM = NavigationRailDefaults.INSTANCE.m2464getElevationD9Ej5fM();
                        } else {
                            fM2464getElevationD9Ej5fM = f2;
                        }
                        if (i6 != 0) {
                            function6 = null;
                            long j11 = jM2360contentColorForek8zF_U;
                            modifier3 = companion;
                            j6 = j11;
                            f4 = fM2464getElevationD9Ej5fM;
                            j5 = jM2346getSurface0d7_KjU;
                            i8 = -171916405;
                        } else {
                            f4 = fM2464getElevationD9Ej5fM;
                            j5 = jM2346getSurface0d7_KjU;
                            function6 = function5;
                            i8 = -171916405;
                            long j12 = jM2360contentColorForek8zF_U;
                            modifier3 = companion;
                            j6 = j12;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(i8, i3, -1, "androidx.compose.material.NavigationRail (NavigationRail.kt:108)");
                    }
                    composer2 = composerStartRestartGroup;
                    SurfaceKt.m2584SurfaceFjzlyU(modifier3, null, j5, j6, null, f4, ComposableLambdaKt.rememberComposableLambda(366031815, true, new Function2() { // from class: androidx.compose.material.NavigationRailKt$$ExternalSyntheticLambda8
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return NavigationRailKt.NavigationRail_afqeVBk$lambda$0(windowInsets, function6, function4, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composer2, 1572864 | ((i3 >> 3) & 14) | (i3 & 896) | (i3 & 7168) | ((i3 << 3) & 458752), 18);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier2 = modifier3;
                    j3 = j5;
                    j4 = j6;
                    f3 = f4;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    modifier2 = modifier;
                    j3 = jM2346getSurface0d7_KjU;
                    j4 = jM2360contentColorForek8zF_U;
                    f3 = f2;
                    function6 = function5;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.NavigationRailKt$$ExternalSyntheticLambda9
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return NavigationRailKt.NavigationRail_afqeVBk$lambda$1(windowInsets, modifier2, j3, j4, f3, function6, function4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 24576;
            f2 = f;
            i6 = i2 & 32;
            if (i6 != 0) {
                if ((196608 & i) == 0) {
                    function5 = function3;
                    if (composerStartRestartGroup.changedInstance(function5)) {
                        i7 = 131072;
                    } else {
                        i7 = 65536;
                    }
                    i3 |= i7;
                }
                if ((i & 1572864) == 0) {
                    if (composerStartRestartGroup.changedInstance(function4)) {
                        i9 = 1048576;
                    } else {
                        i9 = 524288;
                    }
                    i3 |= i9;
                }
                if ((i3 & 599187) != 599186) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "103@4758L6,104@4800L32");
                    if ((i & 1) != 0) {
                        if (i11 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i2 & 4) != 0) {
                            jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                            i3 &= -897;
                        }
                        if ((i2 & 8) != 0) {
                            jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 6) & 14);
                            i3 &= -7169;
                        }
                        if (i4 != 0) {
                            fM2464getElevationD9Ej5fM = NavigationRailDefaults.INSTANCE.m2464getElevationD9Ej5fM();
                        } else {
                            fM2464getElevationD9Ej5fM = f2;
                        }
                        if (i6 != 0) {
                            function6 = null;
                            long j13 = jM2360contentColorForek8zF_U;
                            modifier3 = companion;
                            j6 = j13;
                            f4 = fM2464getElevationD9Ej5fM;
                            j5 = jM2346getSurface0d7_KjU;
                            i8 = -171916405;
                        } else {
                            f4 = fM2464getElevationD9Ej5fM;
                            j5 = jM2346getSurface0d7_KjU;
                            function6 = function5;
                            i8 = -171916405;
                            long j14 = jM2360contentColorForek8zF_U;
                            modifier3 = companion;
                            j6 = j14;
                        }
                    } else {
                        if (i11 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i2 & 4) != 0) {
                            jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                            i3 &= -897;
                        }
                        if ((i2 & 8) != 0) {
                            jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 6) & 14);
                            i3 &= -7169;
                        }
                        if (i4 != 0) {
                            fM2464getElevationD9Ej5fM = NavigationRailDefaults.INSTANCE.m2464getElevationD9Ej5fM();
                        } else {
                            fM2464getElevationD9Ej5fM = f2;
                        }
                        if (i6 != 0) {
                            function6 = null;
                            long j15 = jM2360contentColorForek8zF_U;
                            modifier3 = companion;
                            j6 = j15;
                            f4 = fM2464getElevationD9Ej5fM;
                            j5 = jM2346getSurface0d7_KjU;
                            i8 = -171916405;
                        } else {
                            f4 = fM2464getElevationD9Ej5fM;
                            j5 = jM2346getSurface0d7_KjU;
                            function6 = function5;
                            i8 = -171916405;
                            long j16 = jM2360contentColorForek8zF_U;
                            modifier3 = companion;
                            j6 = j16;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(i8, i3, -1, "androidx.compose.material.NavigationRail (NavigationRail.kt:108)");
                    }
                    composer2 = composerStartRestartGroup;
                    SurfaceKt.m2584SurfaceFjzlyU(modifier3, null, j5, j6, null, f4, ComposableLambdaKt.rememberComposableLambda(366031815, true, new Function2() { // from class: androidx.compose.material.NavigationRailKt$$ExternalSyntheticLambda8
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return NavigationRailKt.NavigationRail_afqeVBk$lambda$0(windowInsets, function6, function4, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composer2, 1572864 | ((i3 >> 3) & 14) | (i3 & 896) | (i3 & 7168) | ((i3 << 3) & 458752), 18);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier2 = modifier3;
                    j3 = j5;
                    j4 = j6;
                    f3 = f4;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    modifier2 = modifier;
                    j3 = jM2346getSurface0d7_KjU;
                    j4 = jM2360contentColorForek8zF_U;
                    f3 = f2;
                    function6 = function5;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.NavigationRailKt$$ExternalSyntheticLambda9
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return NavigationRailKt.NavigationRail_afqeVBk$lambda$1(windowInsets, modifier2, j3, j4, f3, function6, function4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            function5 = function3;
            if ((i & 1572864) == 0) {
                if (composerStartRestartGroup.changedInstance(function4)) {
                    i9 = 1048576;
                } else {
                    i9 = 524288;
                }
                i3 |= i9;
            }
            if ((i3 & 599187) != 599186) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "103@4758L6,104@4800L32");
                if ((i & 1) != 0) {
                    if (i11 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if ((i2 & 4) != 0) {
                        jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                        i3 &= -897;
                    }
                    if ((i2 & 8) != 0) {
                        jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 6) & 14);
                        i3 &= -7169;
                    }
                    if (i4 != 0) {
                        fM2464getElevationD9Ej5fM = NavigationRailDefaults.INSTANCE.m2464getElevationD9Ej5fM();
                    } else {
                        fM2464getElevationD9Ej5fM = f2;
                    }
                    if (i6 != 0) {
                        function6 = null;
                        long j17 = jM2360contentColorForek8zF_U;
                        modifier3 = companion;
                        j6 = j17;
                        f4 = fM2464getElevationD9Ej5fM;
                        j5 = jM2346getSurface0d7_KjU;
                        i8 = -171916405;
                    } else {
                        f4 = fM2464getElevationD9Ej5fM;
                        j5 = jM2346getSurface0d7_KjU;
                        function6 = function5;
                        i8 = -171916405;
                        long j18 = jM2360contentColorForek8zF_U;
                        modifier3 = companion;
                        j6 = j18;
                    }
                } else {
                    if (i11 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if ((i2 & 4) != 0) {
                        jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                        i3 &= -897;
                    }
                    if ((i2 & 8) != 0) {
                        jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 6) & 14);
                        i3 &= -7169;
                    }
                    if (i4 != 0) {
                        fM2464getElevationD9Ej5fM = NavigationRailDefaults.INSTANCE.m2464getElevationD9Ej5fM();
                    } else {
                        fM2464getElevationD9Ej5fM = f2;
                    }
                    if (i6 != 0) {
                        function6 = null;
                        long j19 = jM2360contentColorForek8zF_U;
                        modifier3 = companion;
                        j6 = j19;
                        f4 = fM2464getElevationD9Ej5fM;
                        j5 = jM2346getSurface0d7_KjU;
                        i8 = -171916405;
                    } else {
                        f4 = fM2464getElevationD9Ej5fM;
                        j5 = jM2346getSurface0d7_KjU;
                        function6 = function5;
                        i8 = -171916405;
                        long j110 = jM2360contentColorForek8zF_U;
                        modifier3 = companion;
                        j6 = j110;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(i8, i3, -1, "androidx.compose.material.NavigationRail (NavigationRail.kt:108)");
                }
                composer2 = composerStartRestartGroup;
                SurfaceKt.m2584SurfaceFjzlyU(modifier3, null, j5, j6, null, f4, ComposableLambdaKt.rememberComposableLambda(366031815, true, new Function2() { // from class: androidx.compose.material.NavigationRailKt$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return NavigationRailKt.NavigationRail_afqeVBk$lambda$0(windowInsets, function6, function4, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composer2, 1572864 | ((i3 >> 3) & 14) | (i3 & 896) | (i3 & 7168) | ((i3 << 3) & 458752), 18);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier2 = modifier3;
                j3 = j5;
                j4 = j6;
                f3 = f4;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier2 = modifier;
                j3 = jM2346getSurface0d7_KjU;
                j4 = jM2360contentColorForek8zF_U;
                f3 = f2;
                function6 = function5;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.NavigationRailKt$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return NavigationRailKt.NavigationRail_afqeVBk$lambda$1(windowInsets, modifier2, j3, j4, f3, function6, function4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 48;
        if ((i & 384) == 0) {
            if ((i2 & 4) == 0) {
                jM2346getSurface0d7_KjU = j;
                if (composerStartRestartGroup.changed(jM2346getSurface0d7_KjU)) {
                }
                i3 |= i12;
            } else {
                jM2346getSurface0d7_KjU = j;
            }
            i3 |= i12;
        } else {
            jM2346getSurface0d7_KjU = j;
        }
        if ((i & 3072) == 0) {
            jM2360contentColorForek8zF_U = j2;
            if ((i2 & 8) == 0) {
                i10 = 1024;
            } else {
                i10 = 1024;
            }
            i3 |= i10;
        } else {
            jM2360contentColorForek8zF_U = j2;
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
            i6 = i2 & 32;
            if (i6 != 0) {
                if ((196608 & i) == 0) {
                    function5 = function3;
                    if (composerStartRestartGroup.changedInstance(function5)) {
                        i7 = 131072;
                    } else {
                        i7 = 65536;
                    }
                    i3 |= i7;
                }
                if ((i & 1572864) == 0) {
                    if (composerStartRestartGroup.changedInstance(function4)) {
                        i9 = 1048576;
                    } else {
                        i9 = 524288;
                    }
                    i3 |= i9;
                }
                if ((i3 & 599187) != 599186) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "103@4758L6,104@4800L32");
                    if ((i & 1) != 0) {
                        if (i11 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i2 & 4) != 0) {
                            jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                            i3 &= -897;
                        }
                        if ((i2 & 8) != 0) {
                            jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 6) & 14);
                            i3 &= -7169;
                        }
                        if (i4 != 0) {
                            fM2464getElevationD9Ej5fM = NavigationRailDefaults.INSTANCE.m2464getElevationD9Ej5fM();
                        } else {
                            fM2464getElevationD9Ej5fM = f2;
                        }
                        if (i6 != 0) {
                            function6 = null;
                            long j111 = jM2360contentColorForek8zF_U;
                            modifier3 = companion;
                            j6 = j111;
                            f4 = fM2464getElevationD9Ej5fM;
                            j5 = jM2346getSurface0d7_KjU;
                            i8 = -171916405;
                        } else {
                            f4 = fM2464getElevationD9Ej5fM;
                            j5 = jM2346getSurface0d7_KjU;
                            function6 = function5;
                            i8 = -171916405;
                            long j112 = jM2360contentColorForek8zF_U;
                            modifier3 = companion;
                            j6 = j112;
                        }
                    } else {
                        if (i11 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if ((i2 & 4) != 0) {
                            jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                            i3 &= -897;
                        }
                        if ((i2 & 8) != 0) {
                            jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 6) & 14);
                            i3 &= -7169;
                        }
                        if (i4 != 0) {
                            fM2464getElevationD9Ej5fM = NavigationRailDefaults.INSTANCE.m2464getElevationD9Ej5fM();
                        } else {
                            fM2464getElevationD9Ej5fM = f2;
                        }
                        if (i6 != 0) {
                            function6 = null;
                            long j113 = jM2360contentColorForek8zF_U;
                            modifier3 = companion;
                            j6 = j113;
                            f4 = fM2464getElevationD9Ej5fM;
                            j5 = jM2346getSurface0d7_KjU;
                            i8 = -171916405;
                        } else {
                            f4 = fM2464getElevationD9Ej5fM;
                            j5 = jM2346getSurface0d7_KjU;
                            function6 = function5;
                            i8 = -171916405;
                            long j114 = jM2360contentColorForek8zF_U;
                            modifier3 = companion;
                            j6 = j114;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(i8, i3, -1, "androidx.compose.material.NavigationRail (NavigationRail.kt:108)");
                    }
                    composer2 = composerStartRestartGroup;
                    SurfaceKt.m2584SurfaceFjzlyU(modifier3, null, j5, j6, null, f4, ComposableLambdaKt.rememberComposableLambda(366031815, true, new Function2() { // from class: androidx.compose.material.NavigationRailKt$$ExternalSyntheticLambda8
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return NavigationRailKt.NavigationRail_afqeVBk$lambda$0(windowInsets, function6, function4, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composer2, 1572864 | ((i3 >> 3) & 14) | (i3 & 896) | (i3 & 7168) | ((i3 << 3) & 458752), 18);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier2 = modifier3;
                    j3 = j5;
                    j4 = j6;
                    f3 = f4;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    modifier2 = modifier;
                    j3 = jM2346getSurface0d7_KjU;
                    j4 = jM2360contentColorForek8zF_U;
                    f3 = f2;
                    function6 = function5;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.NavigationRailKt$$ExternalSyntheticLambda9
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return NavigationRailKt.NavigationRail_afqeVBk$lambda$1(windowInsets, modifier2, j3, j4, f3, function6, function4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            function5 = function3;
            if ((i & 1572864) == 0) {
                if (composerStartRestartGroup.changedInstance(function4)) {
                    i9 = 1048576;
                } else {
                    i9 = 524288;
                }
                i3 |= i9;
            }
            if ((i3 & 599187) != 599186) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "103@4758L6,104@4800L32");
                if ((i & 1) != 0) {
                    if (i11 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if ((i2 & 4) != 0) {
                        jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                        i3 &= -897;
                    }
                    if ((i2 & 8) != 0) {
                        jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 6) & 14);
                        i3 &= -7169;
                    }
                    if (i4 != 0) {
                        fM2464getElevationD9Ej5fM = NavigationRailDefaults.INSTANCE.m2464getElevationD9Ej5fM();
                    } else {
                        fM2464getElevationD9Ej5fM = f2;
                    }
                    if (i6 != 0) {
                        function6 = null;
                        long j115 = jM2360contentColorForek8zF_U;
                        modifier3 = companion;
                        j6 = j115;
                        f4 = fM2464getElevationD9Ej5fM;
                        j5 = jM2346getSurface0d7_KjU;
                        i8 = -171916405;
                    } else {
                        f4 = fM2464getElevationD9Ej5fM;
                        j5 = jM2346getSurface0d7_KjU;
                        function6 = function5;
                        i8 = -171916405;
                        long j116 = jM2360contentColorForek8zF_U;
                        modifier3 = companion;
                        j6 = j116;
                    }
                } else {
                    if (i11 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if ((i2 & 4) != 0) {
                        jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                        i3 &= -897;
                    }
                    if ((i2 & 8) != 0) {
                        jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 6) & 14);
                        i3 &= -7169;
                    }
                    if (i4 != 0) {
                        fM2464getElevationD9Ej5fM = NavigationRailDefaults.INSTANCE.m2464getElevationD9Ej5fM();
                    } else {
                        fM2464getElevationD9Ej5fM = f2;
                    }
                    if (i6 != 0) {
                        function6 = null;
                        long j117 = jM2360contentColorForek8zF_U;
                        modifier3 = companion;
                        j6 = j117;
                        f4 = fM2464getElevationD9Ej5fM;
                        j5 = jM2346getSurface0d7_KjU;
                        i8 = -171916405;
                    } else {
                        f4 = fM2464getElevationD9Ej5fM;
                        j5 = jM2346getSurface0d7_KjU;
                        function6 = function5;
                        i8 = -171916405;
                        long j118 = jM2360contentColorForek8zF_U;
                        modifier3 = companion;
                        j6 = j118;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(i8, i3, -1, "androidx.compose.material.NavigationRail (NavigationRail.kt:108)");
                }
                composer2 = composerStartRestartGroup;
                SurfaceKt.m2584SurfaceFjzlyU(modifier3, null, j5, j6, null, f4, ComposableLambdaKt.rememberComposableLambda(366031815, true, new Function2() { // from class: androidx.compose.material.NavigationRailKt$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return NavigationRailKt.NavigationRail_afqeVBk$lambda$0(windowInsets, function6, function4, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composer2, 1572864 | ((i3 >> 3) & 14) | (i3 & 896) | (i3 & 7168) | ((i3 << 3) & 458752), 18);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier2 = modifier3;
                j3 = j5;
                j4 = j6;
                f3 = f4;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier2 = modifier;
                j3 = jM2346getSurface0d7_KjU;
                j4 = jM2360contentColorForek8zF_U;
                f3 = f2;
                function6 = function5;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.NavigationRailKt$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return NavigationRailKt.NavigationRail_afqeVBk$lambda$1(windowInsets, modifier2, j3, j4, f3, function6, function4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 24576;
        f2 = f;
        i6 = i2 & 32;
        if (i6 != 0) {
            if ((196608 & i) == 0) {
                function5 = function3;
                if (composerStartRestartGroup.changedInstance(function5)) {
                    i7 = 131072;
                } else {
                    i7 = 65536;
                }
                i3 |= i7;
            }
            if ((i & 1572864) == 0) {
                if (composerStartRestartGroup.changedInstance(function4)) {
                    i9 = 1048576;
                } else {
                    i9 = 524288;
                }
                i3 |= i9;
            }
            if ((i3 & 599187) != 599186) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "103@4758L6,104@4800L32");
                if ((i & 1) != 0) {
                    if (i11 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if ((i2 & 4) != 0) {
                        jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                        i3 &= -897;
                    }
                    if ((i2 & 8) != 0) {
                        jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 6) & 14);
                        i3 &= -7169;
                    }
                    if (i4 != 0) {
                        fM2464getElevationD9Ej5fM = NavigationRailDefaults.INSTANCE.m2464getElevationD9Ej5fM();
                    } else {
                        fM2464getElevationD9Ej5fM = f2;
                    }
                    if (i6 != 0) {
                        function6 = null;
                        long j119 = jM2360contentColorForek8zF_U;
                        modifier3 = companion;
                        j6 = j119;
                        f4 = fM2464getElevationD9Ej5fM;
                        j5 = jM2346getSurface0d7_KjU;
                        i8 = -171916405;
                    } else {
                        f4 = fM2464getElevationD9Ej5fM;
                        j5 = jM2346getSurface0d7_KjU;
                        function6 = function5;
                        i8 = -171916405;
                        long j1110 = jM2360contentColorForek8zF_U;
                        modifier3 = companion;
                        j6 = j1110;
                    }
                } else {
                    if (i11 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if ((i2 & 4) != 0) {
                        jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                        i3 &= -897;
                    }
                    if ((i2 & 8) != 0) {
                        jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 6) & 14);
                        i3 &= -7169;
                    }
                    if (i4 != 0) {
                        fM2464getElevationD9Ej5fM = NavigationRailDefaults.INSTANCE.m2464getElevationD9Ej5fM();
                    } else {
                        fM2464getElevationD9Ej5fM = f2;
                    }
                    if (i6 != 0) {
                        function6 = null;
                        long j1111 = jM2360contentColorForek8zF_U;
                        modifier3 = companion;
                        j6 = j1111;
                        f4 = fM2464getElevationD9Ej5fM;
                        j5 = jM2346getSurface0d7_KjU;
                        i8 = -171916405;
                    } else {
                        f4 = fM2464getElevationD9Ej5fM;
                        j5 = jM2346getSurface0d7_KjU;
                        function6 = function5;
                        i8 = -171916405;
                        long j1112 = jM2360contentColorForek8zF_U;
                        modifier3 = companion;
                        j6 = j1112;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(i8, i3, -1, "androidx.compose.material.NavigationRail (NavigationRail.kt:108)");
                }
                composer2 = composerStartRestartGroup;
                SurfaceKt.m2584SurfaceFjzlyU(modifier3, null, j5, j6, null, f4, ComposableLambdaKt.rememberComposableLambda(366031815, true, new Function2() { // from class: androidx.compose.material.NavigationRailKt$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return NavigationRailKt.NavigationRail_afqeVBk$lambda$0(windowInsets, function6, function4, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composer2, 1572864 | ((i3 >> 3) & 14) | (i3 & 896) | (i3 & 7168) | ((i3 << 3) & 458752), 18);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier2 = modifier3;
                j3 = j5;
                j4 = j6;
                f3 = f4;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier2 = modifier;
                j3 = jM2346getSurface0d7_KjU;
                j4 = jM2360contentColorForek8zF_U;
                f3 = f2;
                function6 = function5;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.NavigationRailKt$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return NavigationRailKt.NavigationRail_afqeVBk$lambda$1(windowInsets, modifier2, j3, j4, f3, function6, function4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        function5 = function3;
        if ((i & 1572864) == 0) {
            if (composerStartRestartGroup.changedInstance(function4)) {
                i9 = 1048576;
            } else {
                i9 = 524288;
            }
            i3 |= i9;
        }
        if ((i3 & 599187) != 599186) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "103@4758L6,104@4800L32");
            if ((i & 1) != 0) {
                if (i11 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier;
                }
                if ((i2 & 4) != 0) {
                    jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                    i3 &= -897;
                }
                if ((i2 & 8) != 0) {
                    jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 6) & 14);
                    i3 &= -7169;
                }
                if (i4 != 0) {
                    fM2464getElevationD9Ej5fM = NavigationRailDefaults.INSTANCE.m2464getElevationD9Ej5fM();
                } else {
                    fM2464getElevationD9Ej5fM = f2;
                }
                if (i6 != 0) {
                    function6 = null;
                    long j1113 = jM2360contentColorForek8zF_U;
                    modifier3 = companion;
                    j6 = j1113;
                    f4 = fM2464getElevationD9Ej5fM;
                    j5 = jM2346getSurface0d7_KjU;
                    i8 = -171916405;
                } else {
                    f4 = fM2464getElevationD9Ej5fM;
                    j5 = jM2346getSurface0d7_KjU;
                    function6 = function5;
                    i8 = -171916405;
                    long j1114 = jM2360contentColorForek8zF_U;
                    modifier3 = companion;
                    j6 = j1114;
                }
            } else {
                if (i11 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier;
                }
                if ((i2 & 4) != 0) {
                    jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                    i3 &= -897;
                }
                if ((i2 & 8) != 0) {
                    jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 6) & 14);
                    i3 &= -7169;
                }
                if (i4 != 0) {
                    fM2464getElevationD9Ej5fM = NavigationRailDefaults.INSTANCE.m2464getElevationD9Ej5fM();
                } else {
                    fM2464getElevationD9Ej5fM = f2;
                }
                if (i6 != 0) {
                    function6 = null;
                    long j1115 = jM2360contentColorForek8zF_U;
                    modifier3 = companion;
                    j6 = j1115;
                    f4 = fM2464getElevationD9Ej5fM;
                    j5 = jM2346getSurface0d7_KjU;
                    i8 = -171916405;
                } else {
                    f4 = fM2464getElevationD9Ej5fM;
                    j5 = jM2346getSurface0d7_KjU;
                    function6 = function5;
                    i8 = -171916405;
                    long j1116 = jM2360contentColorForek8zF_U;
                    modifier3 = companion;
                    j6 = j1116;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(i8, i3, -1, "androidx.compose.material.NavigationRail (NavigationRail.kt:108)");
            }
            composer2 = composerStartRestartGroup;
            SurfaceKt.m2584SurfaceFjzlyU(modifier3, null, j5, j6, null, f4, ComposableLambdaKt.rememberComposableLambda(366031815, true, new Function2() { // from class: androidx.compose.material.NavigationRailKt$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return NavigationRailKt.NavigationRail_afqeVBk$lambda$0(windowInsets, function6, function4, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composer2, 1572864 | ((i3 >> 3) & 14) | (i3 & 896) | (i3 & 7168) | ((i3 << 3) & 458752), 18);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier3;
            j3 = j5;
            j4 = j6;
            f3 = f4;
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            modifier2 = modifier;
            j3 = jM2346getSurface0d7_KjU;
            j4 = jM2360contentColorForek8zF_U;
            f3 = f2;
            function6 = function5;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.NavigationRailKt$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return NavigationRailKt.NavigationRail_afqeVBk$lambda$1(windowInsets, modifier2, j3, j4, f3, function6, function4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NavigationRail_afqeVBk$lambda$0(WindowInsets windowInsets, Function3 function3, Function3 function4, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C115@5158L426:NavigationRail.kt#jmzs0o");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(366031815, i, -1, "androidx.compose.material.NavigationRail.<anonymous> (NavigationRail.kt:115)");
            }
            Modifier modifierSelectableGroup = SelectableGroupKt.selectableGroup(PaddingKt.m1220paddingVpY3zN4$default(WindowInsetsPaddingKt.windowInsetsPadding(SizeKt.fillMaxHeight$default(Modifier.INSTANCE, 0.0f, 1, null), windowInsets), 0.0f, NavigationRailPadding, 1, null));
            Alignment.Horizontal centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
            ComposerKt.sourceInformationMarkerStart(composer, -483455358, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), centerHorizontally, composer, 48);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierSelectableGroup);
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
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, -1703433687, "C126@5565L9:NavigationRail.kt#jmzs0o");
            if (function3 == null) {
                composer.startReplaceGroup(-1708832431);
            } else {
                composer.startReplaceGroup(-1703415150);
                ComposerKt.sourceInformation(composer, "123@5475L8,124@5500L38");
                function3.invoke(columnScopeInstance, composer, 6);
                SpacerKt.Spacer(SizeKt.m1252height3ABfNKs(Modifier.INSTANCE, HeaderPadding), composer, 6);
            }
            composer.endReplaceGroup();
            function4.invoke(columnScopeInstance, composer, 6);
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

    /* JADX WARN: Code duplicated, block: B:101:0x0147  */
    /* JADX WARN: Code duplicated, block: B:104:0x0177  */
    /* JADX WARN: Code duplicated, block: B:106:0x0182  */
    /* JADX WARN: Code duplicated, block: B:109:0x0192  */
    /* JADX WARN: Code duplicated, block: B:111:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:48:0x0084  */
    /* JADX WARN: Code duplicated, block: B:49:0x0087  */
    /* JADX WARN: Code duplicated, block: B:51:0x008b  */
    /* JADX WARN: Code duplicated, block: B:53:0x0093  */
    /* JADX WARN: Code duplicated, block: B:54:0x0096  */
    /* JADX WARN: Code duplicated, block: B:59:0x00a1  */
    /* JADX WARN: Code duplicated, block: B:61:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:62:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:64:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:67:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:68:0x00bd  */
    /* JADX WARN: Code duplicated, block: B:71:0x00c6  */
    /* JADX WARN: Code duplicated, block: B:73:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:84:0x00f5 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:85:0x00f7  */
    /* JADX WARN: Code duplicated, block: B:86:0x00fc  */
    /* JADX WARN: Code duplicated, block: B:89:0x0101  */
    /* JADX WARN: Code duplicated, block: B:92:0x0112  */
    /* JADX WARN: Code duplicated, block: B:94:0x011f  */
    /* JADX WARN: Code duplicated, block: B:96:0x0128  */
    /* JADX WARN: Code duplicated, block: B:97:0x0133  */
    /* JADX INFO: renamed from: NavigationRail-HsRjFd4, reason: not valid java name */
    public static final void m2473NavigationRailHsRjFd4(Modifier modifier, long j, long j2, float f, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function4, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        long jM2346getSurface0d7_KjU;
        long j3;
        float fM2464getElevationD9Ej5fM;
        int i4;
        Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function5;
        int i5;
        boolean z;
        Composer composer2;
        final Modifier modifier3;
        final long j4;
        final long j5;
        final float f2;
        final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function6;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function7;
        int i6;
        int i7;
        Composer composerStartRestartGroup = composer.startRestartGroup(-2116369751);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(NavigationRail)N(modifier,backgroundColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,elevation:c#ui.unit.Dp,header,content)173@7644L95:NavigationRail.kt#jmzs0o");
        int i8 = i2 & 1;
        if (i8 != 0) {
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
                jM2346getSurface0d7_KjU = j;
                int i9 = composerStartRestartGroup.changed(jM2346getSurface0d7_KjU) ? 32 : 16;
                i3 |= i9;
            } else {
                jM2346getSurface0d7_KjU = j;
            }
            i3 |= i9;
        } else {
            jM2346getSurface0d7_KjU = j;
        }
        if ((i & 384) == 0) {
            if ((i2 & 4) == 0) {
                j3 = j2;
                int i10 = composerStartRestartGroup.changed(j3) ? 256 : 128;
                i3 |= i10;
            } else {
                j3 = j2;
            }
            i3 |= i10;
        } else {
            j3 = j2;
        }
        int i11 = i2 & 8;
        if (i11 == 0) {
            if ((i & 3072) == 0) {
                fM2464getElevationD9Ej5fM = f;
                i3 |= composerStartRestartGroup.changed(fM2464getElevationD9Ej5fM) ? 2048 : 1024;
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
                if ((196608 & i) != 0) {
                    if (composerStartRestartGroup.changedInstance(function4)) {
                        i7 = 131072;
                    } else {
                        i7 = 65536;
                    }
                    i3 |= i7;
                }
                if ((74899 & i3) != 74898) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "167@7399L6,168@7441L32");
                    if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                        if (i8 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if ((i2 & 2) != 0) {
                            i3 &= -113;
                            jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                        }
                        if ((i2 & 4) != 0) {
                            long jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 3) & 14);
                            i3 &= -897;
                            j3 = jM2360contentColorForek8zF_U;
                        }
                        if (i11 != 0) {
                            fM2464getElevationD9Ej5fM = NavigationRailDefaults.INSTANCE.m2464getElevationD9Ej5fM();
                        }
                        if (i4 != 0) {
                            function7 = null;
                            i6 = -2116369751;
                        } else {
                            function7 = function5;
                            i6 = -2116369751;
                        }
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        if ((i2 & 2) != 0) {
                            i3 &= -113;
                        }
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                        }
                        fM2464getElevationD9Ej5fM = fM2464getElevationD9Ej5fM;
                        function7 = function5;
                        i6 = -2116369751;
                        companion = modifier2;
                        jM2346getSurface0d7_KjU = jM2346getSurface0d7_KjU;
                    }
                    long j6 = j3;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(i6, i3, -1, "androidx.compose.material.NavigationRail (NavigationRail.kt:172)");
                    }
                    int i12 = i3 << 3;
                    composer2 = composerStartRestartGroup;
                    m2474NavigationRailafqeVBk(ZeroInsets, companion, jM2346getSurface0d7_KjU, j6, fM2464getElevationD9Ej5fM, function7, function4, composer2, 6 | (i12 & 112) | (i12 & 896) | (i12 & 7168) | (57344 & i12) | (458752 & i12) | (i12 & 3670016), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = companion;
                    j4 = jM2346getSurface0d7_KjU;
                    j5 = j6;
                    f2 = fM2464getElevationD9Ej5fM;
                    function6 = function7;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    modifier3 = modifier2;
                    j4 = jM2346getSurface0d7_KjU;
                    j5 = j3;
                    f2 = fM2464getElevationD9Ej5fM;
                    function6 = function5;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.NavigationRailKt$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return NavigationRailKt.NavigationRail_HsRjFd4$lambda$0(modifier3, j4, j5, f2, function6, function4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 24576;
            function5 = function3;
            if ((196608 & i) != 0) {
                if (composerStartRestartGroup.changedInstance(function4)) {
                    i7 = 131072;
                } else {
                    i7 = 65536;
                }
                i3 |= i7;
            }
            if ((74899 & i3) != 74898) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "167@7399L6,168@7441L32");
                if ((i & 1) != 0) {
                    if (i8 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if ((i2 & 2) != 0) {
                        i3 &= -113;
                        jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                    }
                    if ((i2 & 4) != 0) {
                        long jM2360contentColorForek8zF_U2 = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 3) & 14);
                        i3 &= -897;
                        j3 = jM2360contentColorForek8zF_U2;
                    }
                    if (i11 != 0) {
                        fM2464getElevationD9Ej5fM = NavigationRailDefaults.INSTANCE.m2464getElevationD9Ej5fM();
                    }
                    if (i4 != 0) {
                        function7 = null;
                        i6 = -2116369751;
                    } else {
                        function7 = function5;
                        i6 = -2116369751;
                    }
                } else {
                    if (i8 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if ((i2 & 2) != 0) {
                        i3 &= -113;
                        jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                    }
                    if ((i2 & 4) != 0) {
                        long jM2360contentColorForek8zF_U3 = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 3) & 14);
                        i3 &= -897;
                        j3 = jM2360contentColorForek8zF_U3;
                    }
                    if (i11 != 0) {
                        fM2464getElevationD9Ej5fM = NavigationRailDefaults.INSTANCE.m2464getElevationD9Ej5fM();
                    }
                    if (i4 != 0) {
                        function7 = null;
                        i6 = -2116369751;
                    } else {
                        function7 = function5;
                        i6 = -2116369751;
                    }
                }
                long j7 = j3;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(i6, i3, -1, "androidx.compose.material.NavigationRail (NavigationRail.kt:172)");
                }
                int i13 = i3 << 3;
                composer2 = composerStartRestartGroup;
                m2474NavigationRailafqeVBk(ZeroInsets, companion, jM2346getSurface0d7_KjU, j7, fM2464getElevationD9Ej5fM, function7, function4, composer2, 6 | (i13 & 112) | (i13 & 896) | (i13 & 7168) | (57344 & i13) | (458752 & i13) | (i13 & 3670016), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = companion;
                j4 = jM2346getSurface0d7_KjU;
                j5 = j7;
                f2 = fM2464getElevationD9Ej5fM;
                function6 = function7;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier3 = modifier2;
                j4 = jM2346getSurface0d7_KjU;
                j5 = j3;
                f2 = fM2464getElevationD9Ej5fM;
                function6 = function5;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.NavigationRailKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return NavigationRailKt.NavigationRail_HsRjFd4$lambda$0(modifier3, j4, j5, f2, function6, function4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 3072;
        fM2464getElevationD9Ej5fM = f;
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
            if ((196608 & i) != 0) {
                if (composerStartRestartGroup.changedInstance(function4)) {
                    i7 = 131072;
                } else {
                    i7 = 65536;
                }
                i3 |= i7;
            }
            if ((74899 & i3) != 74898) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "167@7399L6,168@7441L32");
                if ((i & 1) != 0) {
                    if (i8 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if ((i2 & 2) != 0) {
                        i3 &= -113;
                        jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                    }
                    if ((i2 & 4) != 0) {
                        long jM2360contentColorForek8zF_U4 = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 3) & 14);
                        i3 &= -897;
                        j3 = jM2360contentColorForek8zF_U4;
                    }
                    if (i11 != 0) {
                        fM2464getElevationD9Ej5fM = NavigationRailDefaults.INSTANCE.m2464getElevationD9Ej5fM();
                    }
                    if (i4 != 0) {
                        function7 = null;
                        i6 = -2116369751;
                    } else {
                        function7 = function5;
                        i6 = -2116369751;
                    }
                } else {
                    if (i8 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if ((i2 & 2) != 0) {
                        i3 &= -113;
                        jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                    }
                    if ((i2 & 4) != 0) {
                        long jM2360contentColorForek8zF_U5 = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 3) & 14);
                        i3 &= -897;
                        j3 = jM2360contentColorForek8zF_U5;
                    }
                    if (i11 != 0) {
                        fM2464getElevationD9Ej5fM = NavigationRailDefaults.INSTANCE.m2464getElevationD9Ej5fM();
                    }
                    if (i4 != 0) {
                        function7 = null;
                        i6 = -2116369751;
                    } else {
                        function7 = function5;
                        i6 = -2116369751;
                    }
                }
                long j8 = j3;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(i6, i3, -1, "androidx.compose.material.NavigationRail (NavigationRail.kt:172)");
                }
                int i14 = i3 << 3;
                composer2 = composerStartRestartGroup;
                m2474NavigationRailafqeVBk(ZeroInsets, companion, jM2346getSurface0d7_KjU, j8, fM2464getElevationD9Ej5fM, function7, function4, composer2, 6 | (i14 & 112) | (i14 & 896) | (i14 & 7168) | (57344 & i14) | (458752 & i14) | (i14 & 3670016), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = companion;
                j4 = jM2346getSurface0d7_KjU;
                j5 = j8;
                f2 = fM2464getElevationD9Ej5fM;
                function6 = function7;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier3 = modifier2;
                j4 = jM2346getSurface0d7_KjU;
                j5 = j3;
                f2 = fM2464getElevationD9Ej5fM;
                function6 = function5;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.NavigationRailKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return NavigationRailKt.NavigationRail_HsRjFd4$lambda$0(modifier3, j4, j5, f2, function6, function4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 24576;
        function5 = function3;
        if ((196608 & i) != 0) {
            if (composerStartRestartGroup.changedInstance(function4)) {
                i7 = 131072;
            } else {
                i7 = 65536;
            }
            i3 |= i7;
        }
        if ((74899 & i3) != 74898) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "167@7399L6,168@7441L32");
            if ((i & 1) != 0) {
                if (i8 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if ((i2 & 2) != 0) {
                    i3 &= -113;
                    jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                }
                if ((i2 & 4) != 0) {
                    long jM2360contentColorForek8zF_U6 = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 3) & 14);
                    i3 &= -897;
                    j3 = jM2360contentColorForek8zF_U6;
                }
                if (i11 != 0) {
                    fM2464getElevationD9Ej5fM = NavigationRailDefaults.INSTANCE.m2464getElevationD9Ej5fM();
                }
                if (i4 != 0) {
                    function7 = null;
                    i6 = -2116369751;
                } else {
                    function7 = function5;
                    i6 = -2116369751;
                }
            } else {
                if (i8 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if ((i2 & 2) != 0) {
                    i3 &= -113;
                    jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                }
                if ((i2 & 4) != 0) {
                    long jM2360contentColorForek8zF_U7 = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 3) & 14);
                    i3 &= -897;
                    j3 = jM2360contentColorForek8zF_U7;
                }
                if (i11 != 0) {
                    fM2464getElevationD9Ej5fM = NavigationRailDefaults.INSTANCE.m2464getElevationD9Ej5fM();
                }
                if (i4 != 0) {
                    function7 = null;
                    i6 = -2116369751;
                } else {
                    function7 = function5;
                    i6 = -2116369751;
                }
            }
            long j9 = j3;
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(i6, i3, -1, "androidx.compose.material.NavigationRail (NavigationRail.kt:172)");
            }
            int i15 = i3 << 3;
            composer2 = composerStartRestartGroup;
            m2474NavigationRailafqeVBk(ZeroInsets, companion, jM2346getSurface0d7_KjU, j9, fM2464getElevationD9Ej5fM, function7, function4, composer2, 6 | (i15 & 112) | (i15 & 896) | (i15 & 7168) | (57344 & i15) | (458752 & i15) | (i15 & 3670016), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = companion;
            j4 = jM2346getSurface0d7_KjU;
            j5 = j9;
            f2 = fM2464getElevationD9Ej5fM;
            function6 = function7;
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            modifier3 = modifier2;
            j4 = jM2346getSurface0d7_KjU;
            j5 = j3;
            f2 = fM2464getElevationD9Ej5fM;
            function6 = function5;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.NavigationRailKt$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return NavigationRailKt.NavigationRail_HsRjFd4$lambda$0(modifier3, j4, j5, f2, function6, function4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX WARN: Code duplicated, block: B:102:0x0131  */
    /* JADX WARN: Code duplicated, block: B:103:0x0133  */
    /* JADX WARN: Code duplicated, block: B:106:0x013c  */
    /* JADX WARN: Code duplicated, block: B:108:0x0151  */
    /* JADX WARN: Code duplicated, block: B:119:0x0173 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:120:0x0175  */
    /* JADX WARN: Code duplicated, block: B:122:0x017c  */
    /* JADX WARN: Code duplicated, block: B:124:0x017f  */
    /* JADX WARN: Code duplicated, block: B:126:0x0183  */
    /* JADX WARN: Code duplicated, block: B:128:0x0186  */
    /* JADX WARN: Code duplicated, block: B:129:0x0189  */
    /* JADX WARN: Code duplicated, block: B:132:0x018f  */
    /* JADX WARN: Code duplicated, block: B:133:0x019c  */
    /* JADX WARN: Code duplicated, block: B:136:0x01a4  */
    /* JADX WARN: Code duplicated, block: B:137:0x01e3  */
    /* JADX WARN: Code duplicated, block: B:140:0x01ee  */
    /* JADX WARN: Code duplicated, block: B:143:0x01fb  */
    /* JADX WARN: Code duplicated, block: B:144:0x0202  */
    /* JADX WARN: Code duplicated, block: B:147:0x0224  */
    /* JADX WARN: Code duplicated, block: B:148:0x0227  */
    /* JADX WARN: Code duplicated, block: B:151:0x02a5  */
    /* JADX WARN: Code duplicated, block: B:154:0x02b1  */
    /* JADX WARN: Code duplicated, block: B:155:0x02b5  */
    /* JADX WARN: Code duplicated, block: B:158:0x02da  */
    /* JADX WARN: Code duplicated, block: B:160:0x02e8  */
    /* JADX WARN: Code duplicated, block: B:163:0x035b  */
    /* JADX WARN: Code duplicated, block: B:165:0x0367  */
    /* JADX WARN: Code duplicated, block: B:168:0x037b  */
    /* JADX WARN: Code duplicated, block: B:170:? A[RETURN, SYNTHETIC] */
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
    /* JADX WARN: Code duplicated, block: B:60:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:61:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:63:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:65:0x00b4  */
    /* JADX WARN: Code duplicated, block: B:66:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:71:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:72:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:74:0x00cb  */
    /* JADX WARN: Code duplicated, block: B:76:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:77:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:82:0x00e7  */
    /* JADX WARN: Code duplicated, block: B:84:0x00ef  */
    /* JADX WARN: Code duplicated, block: B:87:0x00f8  */
    /* JADX WARN: Code duplicated, block: B:89:0x00fd  */
    /* JADX WARN: Code duplicated, block: B:92:0x0109  */
    /* JADX WARN: Code duplicated, block: B:94:0x0111  */
    /* JADX WARN: Code duplicated, block: B:97:0x011a  */
    /* JADX WARN: Code duplicated, block: B:99:0x011f  */
    /* JADX INFO: renamed from: NavigationRailItem-0S3VyRs, reason: not valid java name */
    public static final void m2475NavigationRailItem0S3VyRs(final boolean z, final Function0<Unit> function0, final Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, boolean z2, Function2<? super Composer, ? super Integer, Unit> function3, boolean z3, MutableInteractionSource mutableInteractionSource, long j, long j2, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        boolean z4;
        int i5;
        int i6;
        final Function2<? super Composer, ? super Integer, Unit> function4;
        int i7;
        int i8;
        final boolean z5;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        boolean z6;
        Composer composer2;
        final MutableInteractionSource mutableInteractionSource2;
        final boolean z7;
        final Function2<? super Composer, ? super Integer, Unit> function5;
        final long j3;
        final long j4;
        final Modifier modifier3;
        final boolean z8;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        ComposableLambda composableLambdaRememberComposableLambda;
        MutableInteractionSource mutableInteractionSource3;
        long jM2342getPrimary0d7_KjU;
        int i14;
        long jM6813copywmQWz5c$default;
        float f;
        int currentCompositeKeyHash;
        Function0<ComposeUiNode> constructor;
        Composer composerM6062constructorimpl;
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash;
        int i15;
        int i16;
        Composer composerStartRestartGroup = composer.startRestartGroup(83562179);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(NavigationRailItem)N(selected,onClick,icon,modifier,enabled,label,alwaysShowLabel,interactionSource,selectedContentColor:c#ui.graphics.Color,unselectedContentColor:c#ui.graphics.Color)227@10507L773:NavigationRail.kt#jmzs0o");
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
        int i17 = i2 & 8;
        if (i17 == 0) {
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
                        if ((1572864 & i) == 0) {
                            z5 = z3;
                            if (composerStartRestartGroup.changed(z5)) {
                                i9 = 1048576;
                            } else {
                                i9 = 524288;
                            }
                            i3 |= i9;
                        }
                        i10 = i2 & 128;
                        if (i10 != 0) {
                            if ((i & 12582912) == 0) {
                                if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                                    i11 = 8388608;
                                } else {
                                    i11 = 4194304;
                                }
                                i3 |= i11;
                            }
                            if ((i & 100663296) == 0) {
                                int i18 = i3;
                                if ((i2 & 256) == 0 || !composerStartRestartGroup.changed(j)) {
                                    i16 = 33554432;
                                } else {
                                    i16 = 67108864;
                                }
                                i12 = i18 | i16;
                            } else {
                                i12 = i3;
                            }
                            if ((i & 805306368) == 0) {
                                int i19 = i12;
                                if ((i2 & 512) == 0 || !composerStartRestartGroup.changed(j2)) {
                                    i15 = 268435456;
                                } else {
                                    i15 = C.BUFFER_FLAG_LAST_SAMPLE;
                                }
                                i12 = i19 | i15;
                            }
                            i13 = i12;
                            if ((i13 & 306783379) != 306783378) {
                                z6 = true;
                            } else {
                                z6 = false;
                            }
                            if (composerStartRestartGroup.shouldExecute(z6, i13 & 1)) {
                                composerStartRestartGroup.startDefaults();
                                ComposerKt.sourceInformation(composerStartRestartGroup, "209@9518L6,210@9588L7,210@9622L6");
                                composableLambdaRememberComposableLambda = null;
                                if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                    if (i17 != 0) {
                                        modifier2 = Modifier.INSTANCE;
                                    }
                                    if (i4 != 0) {
                                        z4 = true;
                                    }
                                    if (i6 != 0) {
                                        function4 = null;
                                    }
                                    if (i8 != 0) {
                                        z5 = true;
                                    }
                                    if (i10 != 0) {
                                        mutableInteractionSource3 = null;
                                    } else {
                                        mutableInteractionSource3 = mutableInteractionSource;
                                    }
                                    if ((i2 & 256) != 0) {
                                        jM2342getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2342getPrimary0d7_KjU();
                                        i14 = i13 & (-234881025);
                                    } else {
                                        jM2342getPrimary0d7_KjU = j;
                                        i14 = i13;
                                    }
                                    if ((i2 & 512) != 0) {
                                        ProvidableCompositionLocal<Color> localContentColor = ContentColorKt.getLocalContentColor();
                                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                        Object objConsume = composerStartRestartGroup.consume(localContentColor);
                                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                        jM6813copywmQWz5c$default = Color.m6813copywmQWz5c$default(((Color) objConsume).m6824unboximpl(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                                        i14 &= -1879048193;
                                    } else {
                                        jM6813copywmQWz5c$default = j2;
                                    }
                                } else {
                                    composerStartRestartGroup.skipToGroupEnd();
                                    int i20 = (i2 & 256) != 0 ? i13 & (-234881025) : i13;
                                    if ((i2 & 512) != 0) {
                                        i20 &= -1879048193;
                                    }
                                    jM2342getPrimary0d7_KjU = j;
                                    jM6813copywmQWz5c$default = j2;
                                    i14 = i20;
                                    mutableInteractionSource3 = mutableInteractionSource;
                                }
                                composerStartRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(83562179, i14, -1, "androidx.compose.material.NavigationRailItem (NavigationRail.kt:211)");
                                }
                                if (function4 == null) {
                                    composerStartRestartGroup.startReplaceGroup(-1679616946);
                                } else {
                                    composerStartRestartGroup.startReplaceGroup(-1679616945);
                                    ComposerKt.sourceInformation(composerStartRestartGroup, "*214@9729L168");
                                    composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-674640273, true, new Function2() { // from class: androidx.compose.material.NavigationRailKt$$ExternalSyntheticLambda4
                                        @Override // kotlin.jvm.functions.Function2
                                        public final Object invoke(Object obj, Object obj2) {
                                            return NavigationRailKt.NavigationRailItem_0S3VyRs$lambda$0$0(function4, (Composer) obj, ((Integer) obj2).intValue());
                                        }
                                    }, composerStartRestartGroup, 54);
                                }
                                composerStartRestartGroup.endReplaceGroup();
                                final ComposableLambda composableLambda = composableLambdaRememberComposableLambda;
                                if (function4 == null) {
                                    f = NavigationRailItemCompactSize;
                                } else {
                                    f = NavigationRailItemSize;
                                }
                                MutableInteractionSource mutableInteractionSource4 = mutableInteractionSource3;
                                boolean z9 = z4;
                                Modifier modifierM1266size3ABfNKs = SizeKt.m1266size3ABfNKs(SelectableKt.m1533selectableO2vRcR0(modifier2, z, mutableInteractionSource4, RippleKt.m2523rippleH2RKhps$default(false, 0.0f, jM2342getPrimary0d7_KjU, 2, null), z9, Role.m8825boximpl(Role.INSTANCE.m8839getTabo7Vup1c()), function0), f);
                                Alignment center = Alignment.INSTANCE.getCenter();
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                                CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1266size3ABfNKs);
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
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 415492902, "C240@10971L303,240@10890L384:NavigationRail.kt#jmzs0o");
                                int i21 = i14 >> 24;
                                m2476NavigationRailTransitionKlgxPg(jM2342getPrimary0d7_KjU, jM6813copywmQWz5c$default, z, ComposableLambdaKt.rememberComposableLambda(317431928, true, new Function3() { // from class: androidx.compose.material.NavigationRailKt$$ExternalSyntheticLambda5
                                    @Override // kotlin.jvm.functions.Function3
                                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                                        return NavigationRailKt.NavigationRailItem_0S3VyRs$lambda$1$0(z5, function2, composableLambda, ((Float) obj).floatValue(), (Composer) obj2, ((Integer) obj3).intValue());
                                    }
                                }, composerStartRestartGroup, 54), composerStartRestartGroup, (i21 & 112) | (i21 & 14) | 3072 | ((i14 << 6) & 896));
                                composer2 = composerStartRestartGroup;
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                composer2.endNode();
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                mutableInteractionSource2 = mutableInteractionSource4;
                                function5 = function4;
                                z7 = z9;
                                j4 = jM6813copywmQWz5c$default;
                                j3 = jM2342getPrimary0d7_KjU;
                            } else {
                                composer2 = composerStartRestartGroup;
                                composer2.skipToGroupEnd();
                                mutableInteractionSource2 = mutableInteractionSource;
                                z7 = z4;
                                function5 = function4;
                                j3 = j;
                                j4 = j2;
                            }
                            modifier3 = modifier2;
                            z8 = z5;
                            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup != null) {
                                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.NavigationRailKt$$ExternalSyntheticLambda6
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return NavigationRailKt.NavigationRailItem_0S3VyRs$lambda$2(z, function0, function2, modifier3, z7, function5, z8, mutableInteractionSource2, j3, j4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                    }
                                });
                            }
                        }
                        i3 |= 12582912;
                        if ((i & 100663296) == 0) {
                            int i110 = i3;
                            if ((i2 & 256) == 0) {
                                i16 = 33554432;
                            } else {
                                i16 = 33554432;
                            }
                            i12 = i110 | i16;
                        } else {
                            i12 = i3;
                        }
                        if ((i & 805306368) == 0) {
                            int i111 = i12;
                            if ((i2 & 512) == 0) {
                                i15 = 268435456;
                            } else {
                                i15 = 268435456;
                            }
                            i12 = i111 | i15;
                        }
                        i13 = i12;
                        if ((i13 & 306783379) != 306783378) {
                            z6 = true;
                        } else {
                            z6 = false;
                        }
                        if (composerStartRestartGroup.shouldExecute(z6, i13 & 1)) {
                            composerStartRestartGroup.startDefaults();
                            ComposerKt.sourceInformation(composerStartRestartGroup, "209@9518L6,210@9588L7,210@9622L6");
                            composableLambdaRememberComposableLambda = null;
                            if ((i & 1) != 0) {
                                if (i17 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                if (i4 != 0) {
                                    z4 = true;
                                }
                                if (i6 != 0) {
                                    function4 = null;
                                }
                                if (i8 != 0) {
                                    z5 = true;
                                }
                                if (i10 != 0) {
                                    mutableInteractionSource3 = null;
                                } else {
                                    mutableInteractionSource3 = mutableInteractionSource;
                                }
                                if ((i2 & 256) != 0) {
                                    jM2342getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2342getPrimary0d7_KjU();
                                    i14 = i13 & (-234881025);
                                } else {
                                    jM2342getPrimary0d7_KjU = j;
                                    i14 = i13;
                                }
                                if ((i2 & 512) != 0) {
                                    ProvidableCompositionLocal<Color> localContentColor2 = ContentColorKt.getLocalContentColor();
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                    Object objConsume2 = composerStartRestartGroup.consume(localContentColor2);
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                    jM6813copywmQWz5c$default = Color.m6813copywmQWz5c$default(((Color) objConsume2).m6824unboximpl(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                                    i14 &= -1879048193;
                                } else {
                                    jM6813copywmQWz5c$default = j2;
                                }
                            } else {
                                if (i17 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                if (i4 != 0) {
                                    z4 = true;
                                }
                                if (i6 != 0) {
                                    function4 = null;
                                }
                                if (i8 != 0) {
                                    z5 = true;
                                }
                                if (i10 != 0) {
                                    mutableInteractionSource3 = null;
                                } else {
                                    mutableInteractionSource3 = mutableInteractionSource;
                                }
                                if ((i2 & 256) != 0) {
                                    jM2342getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2342getPrimary0d7_KjU();
                                    i14 = i13 & (-234881025);
                                } else {
                                    jM2342getPrimary0d7_KjU = j;
                                    i14 = i13;
                                }
                                if ((i2 & 512) != 0) {
                                    ProvidableCompositionLocal<Color> localContentColor3 = ContentColorKt.getLocalContentColor();
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                    Object objConsume3 = composerStartRestartGroup.consume(localContentColor3);
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                    jM6813copywmQWz5c$default = Color.m6813copywmQWz5c$default(((Color) objConsume3).m6824unboximpl(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                                    i14 &= -1879048193;
                                } else {
                                    jM6813copywmQWz5c$default = j2;
                                }
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(83562179, i14, -1, "androidx.compose.material.NavigationRailItem (NavigationRail.kt:211)");
                            }
                            if (function4 == null) {
                                composerStartRestartGroup.startReplaceGroup(-1679616946);
                            } else {
                                composerStartRestartGroup.startReplaceGroup(-1679616945);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "*214@9729L168");
                                composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-674640273, true, new Function2() { // from class: androidx.compose.material.NavigationRailKt$$ExternalSyntheticLambda4
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return NavigationRailKt.NavigationRailItem_0S3VyRs$lambda$0$0(function4, (Composer) obj, ((Integer) obj2).intValue());
                                    }
                                }, composerStartRestartGroup, 54);
                            }
                            composerStartRestartGroup.endReplaceGroup();
                            final Function2 composableLambda2 = composableLambdaRememberComposableLambda;
                            if (function4 == null) {
                                f = NavigationRailItemCompactSize;
                            } else {
                                f = NavigationRailItemSize;
                            }
                            MutableInteractionSource mutableInteractionSource5 = mutableInteractionSource3;
                            boolean z10 = z4;
                            Modifier modifierM1266size3ABfNKs2 = SizeKt.m1266size3ABfNKs(SelectableKt.m1533selectableO2vRcR0(modifier2, z, mutableInteractionSource5, RippleKt.m2523rippleH2RKhps$default(false, 0.0f, jM2342getPrimary0d7_KjU, 2, null), z10, Role.m8825boximpl(Role.INSTANCE.m8839getTabo7Vup1c()), function0), f);
                            Alignment center2 = Alignment.INSTANCE.getCenter();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(center2, false);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1266size3ABfNKs2);
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
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 415492902, "C240@10971L303,240@10890L384:NavigationRail.kt#jmzs0o");
                            int i22 = i14 >> 24;
                            m2476NavigationRailTransitionKlgxPg(jM2342getPrimary0d7_KjU, jM6813copywmQWz5c$default, z, ComposableLambdaKt.rememberComposableLambda(317431928, true, new Function3() { // from class: androidx.compose.material.NavigationRailKt$$ExternalSyntheticLambda5
                                @Override // kotlin.jvm.functions.Function3
                                public final Object invoke(Object obj, Object obj2, Object obj3) {
                                    return NavigationRailKt.NavigationRailItem_0S3VyRs$lambda$1$0(z5, function2, composableLambda2, ((Float) obj).floatValue(), (Composer) obj2, ((Integer) obj3).intValue());
                                }
                            }, composerStartRestartGroup, 54), composerStartRestartGroup, (i22 & 112) | (i22 & 14) | 3072 | ((i14 << 6) & 896));
                            composer2 = composerStartRestartGroup;
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            composer2.endNode();
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            mutableInteractionSource2 = mutableInteractionSource5;
                            function5 = function4;
                            z7 = z10;
                            j4 = jM6813copywmQWz5c$default;
                            j3 = jM2342getPrimary0d7_KjU;
                        } else {
                            composer2 = composerStartRestartGroup;
                            composer2.skipToGroupEnd();
                            mutableInteractionSource2 = mutableInteractionSource;
                            z7 = z4;
                            function5 = function4;
                            j3 = j;
                            j4 = j2;
                        }
                        modifier3 = modifier2;
                        z8 = z5;
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.NavigationRailKt$$ExternalSyntheticLambda6
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return NavigationRailKt.NavigationRailItem_0S3VyRs$lambda$2(z, function0, function2, modifier3, z7, function5, z8, mutableInteractionSource2, j3, j4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                        }
                    }
                    i3 |= 1572864;
                    z5 = z3;
                    i10 = i2 & 128;
                    if (i10 != 0) {
                        if ((i & 12582912) == 0) {
                            if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                                i11 = 8388608;
                            } else {
                                i11 = 4194304;
                            }
                            i3 |= i11;
                        }
                        if ((i & 100663296) == 0) {
                            int i112 = i3;
                            if ((i2 & 256) == 0) {
                                i16 = 33554432;
                            } else {
                                i16 = 33554432;
                            }
                            i12 = i112 | i16;
                        } else {
                            i12 = i3;
                        }
                        if ((i & 805306368) == 0) {
                            int i113 = i12;
                            if ((i2 & 512) == 0) {
                                i15 = 268435456;
                            } else {
                                i15 = 268435456;
                            }
                            i12 = i113 | i15;
                        }
                        i13 = i12;
                        if ((i13 & 306783379) != 306783378) {
                            z6 = true;
                        } else {
                            z6 = false;
                        }
                        if (composerStartRestartGroup.shouldExecute(z6, i13 & 1)) {
                            composerStartRestartGroup.startDefaults();
                            ComposerKt.sourceInformation(composerStartRestartGroup, "209@9518L6,210@9588L7,210@9622L6");
                            composableLambdaRememberComposableLambda = null;
                            if ((i & 1) != 0) {
                                if (i17 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                if (i4 != 0) {
                                    z4 = true;
                                }
                                if (i6 != 0) {
                                    function4 = null;
                                }
                                if (i8 != 0) {
                                    z5 = true;
                                }
                                if (i10 != 0) {
                                    mutableInteractionSource3 = null;
                                } else {
                                    mutableInteractionSource3 = mutableInteractionSource;
                                }
                                if ((i2 & 256) != 0) {
                                    jM2342getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2342getPrimary0d7_KjU();
                                    i14 = i13 & (-234881025);
                                } else {
                                    jM2342getPrimary0d7_KjU = j;
                                    i14 = i13;
                                }
                                if ((i2 & 512) != 0) {
                                    ProvidableCompositionLocal<Color> localContentColor4 = ContentColorKt.getLocalContentColor();
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                    Object objConsume4 = composerStartRestartGroup.consume(localContentColor4);
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                    jM6813copywmQWz5c$default = Color.m6813copywmQWz5c$default(((Color) objConsume4).m6824unboximpl(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                                    i14 &= -1879048193;
                                } else {
                                    jM6813copywmQWz5c$default = j2;
                                }
                            } else {
                                if (i17 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                if (i4 != 0) {
                                    z4 = true;
                                }
                                if (i6 != 0) {
                                    function4 = null;
                                }
                                if (i8 != 0) {
                                    z5 = true;
                                }
                                if (i10 != 0) {
                                    mutableInteractionSource3 = null;
                                } else {
                                    mutableInteractionSource3 = mutableInteractionSource;
                                }
                                if ((i2 & 256) != 0) {
                                    jM2342getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2342getPrimary0d7_KjU();
                                    i14 = i13 & (-234881025);
                                } else {
                                    jM2342getPrimary0d7_KjU = j;
                                    i14 = i13;
                                }
                                if ((i2 & 512) != 0) {
                                    ProvidableCompositionLocal<Color> localContentColor5 = ContentColorKt.getLocalContentColor();
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                    Object objConsume5 = composerStartRestartGroup.consume(localContentColor5);
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                    jM6813copywmQWz5c$default = Color.m6813copywmQWz5c$default(((Color) objConsume5).m6824unboximpl(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                                    i14 &= -1879048193;
                                } else {
                                    jM6813copywmQWz5c$default = j2;
                                }
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(83562179, i14, -1, "androidx.compose.material.NavigationRailItem (NavigationRail.kt:211)");
                            }
                            if (function4 == null) {
                                composerStartRestartGroup.startReplaceGroup(-1679616946);
                            } else {
                                composerStartRestartGroup.startReplaceGroup(-1679616945);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "*214@9729L168");
                                composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-674640273, true, new Function2() { // from class: androidx.compose.material.NavigationRailKt$$ExternalSyntheticLambda4
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return NavigationRailKt.NavigationRailItem_0S3VyRs$lambda$0$0(function4, (Composer) obj, ((Integer) obj2).intValue());
                                    }
                                }, composerStartRestartGroup, 54);
                            }
                            composerStartRestartGroup.endReplaceGroup();
                            final Function2 composableLambda3 = composableLambdaRememberComposableLambda;
                            if (function4 == null) {
                                f = NavigationRailItemCompactSize;
                            } else {
                                f = NavigationRailItemSize;
                            }
                            MutableInteractionSource mutableInteractionSource6 = mutableInteractionSource3;
                            boolean z11 = z4;
                            Modifier modifierM1266size3ABfNKs3 = SizeKt.m1266size3ABfNKs(SelectableKt.m1533selectableO2vRcR0(modifier2, z, mutableInteractionSource6, RippleKt.m2523rippleH2RKhps$default(false, 0.0f, jM2342getPrimary0d7_KjU, 2, null), z11, Role.m8825boximpl(Role.INSTANCE.m8839getTabo7Vup1c()), function0), f);
                            Alignment center3 = Alignment.INSTANCE.getCenter();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(center3, false);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                            CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                            Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1266size3ABfNKs3);
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
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 415492902, "C240@10971L303,240@10890L384:NavigationRail.kt#jmzs0o");
                            int i23 = i14 >> 24;
                            m2476NavigationRailTransitionKlgxPg(jM2342getPrimary0d7_KjU, jM6813copywmQWz5c$default, z, ComposableLambdaKt.rememberComposableLambda(317431928, true, new Function3() { // from class: androidx.compose.material.NavigationRailKt$$ExternalSyntheticLambda5
                                @Override // kotlin.jvm.functions.Function3
                                public final Object invoke(Object obj, Object obj2, Object obj3) {
                                    return NavigationRailKt.NavigationRailItem_0S3VyRs$lambda$1$0(z5, function2, composableLambda3, ((Float) obj).floatValue(), (Composer) obj2, ((Integer) obj3).intValue());
                                }
                            }, composerStartRestartGroup, 54), composerStartRestartGroup, (i23 & 112) | (i23 & 14) | 3072 | ((i14 << 6) & 896));
                            composer2 = composerStartRestartGroup;
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            composer2.endNode();
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            mutableInteractionSource2 = mutableInteractionSource6;
                            function5 = function4;
                            z7 = z11;
                            j4 = jM6813copywmQWz5c$default;
                            j3 = jM2342getPrimary0d7_KjU;
                        } else {
                            composer2 = composerStartRestartGroup;
                            composer2.skipToGroupEnd();
                            mutableInteractionSource2 = mutableInteractionSource;
                            z7 = z4;
                            function5 = function4;
                            j3 = j;
                            j4 = j2;
                        }
                        modifier3 = modifier2;
                        z8 = z5;
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.NavigationRailKt$$ExternalSyntheticLambda6
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return NavigationRailKt.NavigationRailItem_0S3VyRs$lambda$2(z, function0, function2, modifier3, z7, function5, z8, mutableInteractionSource2, j3, j4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                        }
                    }
                    i3 |= 12582912;
                    if ((i & 100663296) == 0) {
                        int i114 = i3;
                        if ((i2 & 256) == 0) {
                            i16 = 33554432;
                        } else {
                            i16 = 33554432;
                        }
                        i12 = i114 | i16;
                    } else {
                        i12 = i3;
                    }
                    if ((i & 805306368) == 0) {
                        int i115 = i12;
                        if ((i2 & 512) == 0) {
                            i15 = 268435456;
                        } else {
                            i15 = 268435456;
                        }
                        i12 = i115 | i15;
                    }
                    i13 = i12;
                    if ((i13 & 306783379) != 306783378) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z6, i13 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "209@9518L6,210@9588L7,210@9622L6");
                        composableLambdaRememberComposableLambda = null;
                        if ((i & 1) != 0) {
                            if (i17 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                z4 = true;
                            }
                            if (i6 != 0) {
                                function4 = null;
                            }
                            if (i8 != 0) {
                                z5 = true;
                            }
                            if (i10 != 0) {
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            if ((i2 & 256) != 0) {
                                jM2342getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2342getPrimary0d7_KjU();
                                i14 = i13 & (-234881025);
                            } else {
                                jM2342getPrimary0d7_KjU = j;
                                i14 = i13;
                            }
                            if ((i2 & 512) != 0) {
                                ProvidableCompositionLocal<Color> localContentColor6 = ContentColorKt.getLocalContentColor();
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                Object objConsume6 = composerStartRestartGroup.consume(localContentColor6);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                jM6813copywmQWz5c$default = Color.m6813copywmQWz5c$default(((Color) objConsume6).m6824unboximpl(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                                i14 &= -1879048193;
                            } else {
                                jM6813copywmQWz5c$default = j2;
                            }
                        } else {
                            if (i17 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                z4 = true;
                            }
                            if (i6 != 0) {
                                function4 = null;
                            }
                            if (i8 != 0) {
                                z5 = true;
                            }
                            if (i10 != 0) {
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            if ((i2 & 256) != 0) {
                                jM2342getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2342getPrimary0d7_KjU();
                                i14 = i13 & (-234881025);
                            } else {
                                jM2342getPrimary0d7_KjU = j;
                                i14 = i13;
                            }
                            if ((i2 & 512) != 0) {
                                ProvidableCompositionLocal<Color> localContentColor7 = ContentColorKt.getLocalContentColor();
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                Object objConsume7 = composerStartRestartGroup.consume(localContentColor7);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                jM6813copywmQWz5c$default = Color.m6813copywmQWz5c$default(((Color) objConsume7).m6824unboximpl(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                                i14 &= -1879048193;
                            } else {
                                jM6813copywmQWz5c$default = j2;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(83562179, i14, -1, "androidx.compose.material.NavigationRailItem (NavigationRail.kt:211)");
                        }
                        if (function4 == null) {
                            composerStartRestartGroup.startReplaceGroup(-1679616946);
                        } else {
                            composerStartRestartGroup.startReplaceGroup(-1679616945);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "*214@9729L168");
                            composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-674640273, true, new Function2() { // from class: androidx.compose.material.NavigationRailKt$$ExternalSyntheticLambda4
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return NavigationRailKt.NavigationRailItem_0S3VyRs$lambda$0$0(function4, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composerStartRestartGroup, 54);
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        final Function2 composableLambda4 = composableLambdaRememberComposableLambda;
                        if (function4 == null) {
                            f = NavigationRailItemCompactSize;
                        } else {
                            f = NavigationRailItemSize;
                        }
                        MutableInteractionSource mutableInteractionSource7 = mutableInteractionSource3;
                        boolean z12 = z4;
                        Modifier modifierM1266size3ABfNKs4 = SizeKt.m1266size3ABfNKs(SelectableKt.m1533selectableO2vRcR0(modifier2, z, mutableInteractionSource7, RippleKt.m2523rippleH2RKhps$default(false, 0.0f, jM2342getPrimary0d7_KjU, 2, null), z12, Role.m8825boximpl(Role.INSTANCE.m8839getTabo7Vup1c()), function0), f);
                        Alignment center4 = Alignment.INSTANCE.getCenter();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy4 = BoxKt.maybeCachedBoxMeasurePolicy(center4, false);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                        CompositionLocalMap currentCompositionLocalMap4 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1266size3ABfNKs4);
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
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 415492902, "C240@10971L303,240@10890L384:NavigationRail.kt#jmzs0o");
                        int i24 = i14 >> 24;
                        m2476NavigationRailTransitionKlgxPg(jM2342getPrimary0d7_KjU, jM6813copywmQWz5c$default, z, ComposableLambdaKt.rememberComposableLambda(317431928, true, new Function3() { // from class: androidx.compose.material.NavigationRailKt$$ExternalSyntheticLambda5
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return NavigationRailKt.NavigationRailItem_0S3VyRs$lambda$1$0(z5, function2, composableLambda4, ((Float) obj).floatValue(), (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, (i24 & 112) | (i24 & 14) | 3072 | ((i14 << 6) & 896));
                        composer2 = composerStartRestartGroup;
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        composer2.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        mutableInteractionSource2 = mutableInteractionSource7;
                        function5 = function4;
                        z7 = z12;
                        j4 = jM6813copywmQWz5c$default;
                        j3 = jM2342getPrimary0d7_KjU;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        mutableInteractionSource2 = mutableInteractionSource;
                        z7 = z4;
                        function5 = function4;
                        j3 = j;
                        j4 = j2;
                    }
                    modifier3 = modifier2;
                    z8 = z5;
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.NavigationRailKt$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return NavigationRailKt.NavigationRailItem_0S3VyRs$lambda$2(z, function0, function2, modifier3, z7, function5, z8, mutableInteractionSource2, j3, j4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                function4 = function3;
                i8 = i2 & 64;
                if (i8 != 0) {
                    if ((1572864 & i) == 0) {
                        z5 = z3;
                        if (composerStartRestartGroup.changed(z5)) {
                            i9 = 1048576;
                        } else {
                            i9 = 524288;
                        }
                        i3 |= i9;
                    }
                    i10 = i2 & 128;
                    if (i10 != 0) {
                        if ((i & 12582912) == 0) {
                            if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                                i11 = 8388608;
                            } else {
                                i11 = 4194304;
                            }
                            i3 |= i11;
                        }
                        if ((i & 100663296) == 0) {
                            int i116 = i3;
                            if ((i2 & 256) == 0) {
                                i16 = 33554432;
                            } else {
                                i16 = 33554432;
                            }
                            i12 = i116 | i16;
                        } else {
                            i12 = i3;
                        }
                        if ((i & 805306368) == 0) {
                            int i117 = i12;
                            if ((i2 & 512) == 0) {
                                i15 = 268435456;
                            } else {
                                i15 = 268435456;
                            }
                            i12 = i117 | i15;
                        }
                        i13 = i12;
                        if ((i13 & 306783379) != 306783378) {
                            z6 = true;
                        } else {
                            z6 = false;
                        }
                        if (composerStartRestartGroup.shouldExecute(z6, i13 & 1)) {
                            composerStartRestartGroup.startDefaults();
                            ComposerKt.sourceInformation(composerStartRestartGroup, "209@9518L6,210@9588L7,210@9622L6");
                            composableLambdaRememberComposableLambda = null;
                            if ((i & 1) != 0) {
                                if (i17 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                if (i4 != 0) {
                                    z4 = true;
                                }
                                if (i6 != 0) {
                                    function4 = null;
                                }
                                if (i8 != 0) {
                                    z5 = true;
                                }
                                if (i10 != 0) {
                                    mutableInteractionSource3 = null;
                                } else {
                                    mutableInteractionSource3 = mutableInteractionSource;
                                }
                                if ((i2 & 256) != 0) {
                                    jM2342getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2342getPrimary0d7_KjU();
                                    i14 = i13 & (-234881025);
                                } else {
                                    jM2342getPrimary0d7_KjU = j;
                                    i14 = i13;
                                }
                                if ((i2 & 512) != 0) {
                                    ProvidableCompositionLocal<Color> localContentColor8 = ContentColorKt.getLocalContentColor();
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                    Object objConsume8 = composerStartRestartGroup.consume(localContentColor8);
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                    jM6813copywmQWz5c$default = Color.m6813copywmQWz5c$default(((Color) objConsume8).m6824unboximpl(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                                    i14 &= -1879048193;
                                } else {
                                    jM6813copywmQWz5c$default = j2;
                                }
                            } else {
                                if (i17 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                if (i4 != 0) {
                                    z4 = true;
                                }
                                if (i6 != 0) {
                                    function4 = null;
                                }
                                if (i8 != 0) {
                                    z5 = true;
                                }
                                if (i10 != 0) {
                                    mutableInteractionSource3 = null;
                                } else {
                                    mutableInteractionSource3 = mutableInteractionSource;
                                }
                                if ((i2 & 256) != 0) {
                                    jM2342getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2342getPrimary0d7_KjU();
                                    i14 = i13 & (-234881025);
                                } else {
                                    jM2342getPrimary0d7_KjU = j;
                                    i14 = i13;
                                }
                                if ((i2 & 512) != 0) {
                                    ProvidableCompositionLocal<Color> localContentColor9 = ContentColorKt.getLocalContentColor();
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                    Object objConsume9 = composerStartRestartGroup.consume(localContentColor9);
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                    jM6813copywmQWz5c$default = Color.m6813copywmQWz5c$default(((Color) objConsume9).m6824unboximpl(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                                    i14 &= -1879048193;
                                } else {
                                    jM6813copywmQWz5c$default = j2;
                                }
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(83562179, i14, -1, "androidx.compose.material.NavigationRailItem (NavigationRail.kt:211)");
                            }
                            if (function4 == null) {
                                composerStartRestartGroup.startReplaceGroup(-1679616946);
                            } else {
                                composerStartRestartGroup.startReplaceGroup(-1679616945);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "*214@9729L168");
                                composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-674640273, true, new Function2() { // from class: androidx.compose.material.NavigationRailKt$$ExternalSyntheticLambda4
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return NavigationRailKt.NavigationRailItem_0S3VyRs$lambda$0$0(function4, (Composer) obj, ((Integer) obj2).intValue());
                                    }
                                }, composerStartRestartGroup, 54);
                            }
                            composerStartRestartGroup.endReplaceGroup();
                            final Function2 composableLambda5 = composableLambdaRememberComposableLambda;
                            if (function4 == null) {
                                f = NavigationRailItemCompactSize;
                            } else {
                                f = NavigationRailItemSize;
                            }
                            MutableInteractionSource mutableInteractionSource8 = mutableInteractionSource3;
                            boolean z13 = z4;
                            Modifier modifierM1266size3ABfNKs5 = SizeKt.m1266size3ABfNKs(SelectableKt.m1533selectableO2vRcR0(modifier2, z, mutableInteractionSource8, RippleKt.m2523rippleH2RKhps$default(false, 0.0f, jM2342getPrimary0d7_KjU, 2, null), z13, Role.m8825boximpl(Role.INSTANCE.m8839getTabo7Vup1c()), function0), f);
                            Alignment center5 = Alignment.INSTANCE.getCenter();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy5 = BoxKt.maybeCachedBoxMeasurePolicy(center5, false);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                            CompositionLocalMap currentCompositionLocalMap5 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                            Modifier modifierMaterializeModifier5 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1266size3ABfNKs5);
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
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 415492902, "C240@10971L303,240@10890L384:NavigationRail.kt#jmzs0o");
                            int i25 = i14 >> 24;
                            m2476NavigationRailTransitionKlgxPg(jM2342getPrimary0d7_KjU, jM6813copywmQWz5c$default, z, ComposableLambdaKt.rememberComposableLambda(317431928, true, new Function3() { // from class: androidx.compose.material.NavigationRailKt$$ExternalSyntheticLambda5
                                @Override // kotlin.jvm.functions.Function3
                                public final Object invoke(Object obj, Object obj2, Object obj3) {
                                    return NavigationRailKt.NavigationRailItem_0S3VyRs$lambda$1$0(z5, function2, composableLambda5, ((Float) obj).floatValue(), (Composer) obj2, ((Integer) obj3).intValue());
                                }
                            }, composerStartRestartGroup, 54), composerStartRestartGroup, (i25 & 112) | (i25 & 14) | 3072 | ((i14 << 6) & 896));
                            composer2 = composerStartRestartGroup;
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            composer2.endNode();
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            mutableInteractionSource2 = mutableInteractionSource8;
                            function5 = function4;
                            z7 = z13;
                            j4 = jM6813copywmQWz5c$default;
                            j3 = jM2342getPrimary0d7_KjU;
                        } else {
                            composer2 = composerStartRestartGroup;
                            composer2.skipToGroupEnd();
                            mutableInteractionSource2 = mutableInteractionSource;
                            z7 = z4;
                            function5 = function4;
                            j3 = j;
                            j4 = j2;
                        }
                        modifier3 = modifier2;
                        z8 = z5;
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.NavigationRailKt$$ExternalSyntheticLambda6
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return NavigationRailKt.NavigationRailItem_0S3VyRs$lambda$2(z, function0, function2, modifier3, z7, function5, z8, mutableInteractionSource2, j3, j4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                        }
                    }
                    i3 |= 12582912;
                    if ((i & 100663296) == 0) {
                        int i118 = i3;
                        if ((i2 & 256) == 0) {
                            i16 = 33554432;
                        } else {
                            i16 = 33554432;
                        }
                        i12 = i118 | i16;
                    } else {
                        i12 = i3;
                    }
                    if ((i & 805306368) == 0) {
                        int i119 = i12;
                        if ((i2 & 512) == 0) {
                            i15 = 268435456;
                        } else {
                            i15 = 268435456;
                        }
                        i12 = i119 | i15;
                    }
                    i13 = i12;
                    if ((i13 & 306783379) != 306783378) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z6, i13 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "209@9518L6,210@9588L7,210@9622L6");
                        composableLambdaRememberComposableLambda = null;
                        if ((i & 1) != 0) {
                            if (i17 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                z4 = true;
                            }
                            if (i6 != 0) {
                                function4 = null;
                            }
                            if (i8 != 0) {
                                z5 = true;
                            }
                            if (i10 != 0) {
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            if ((i2 & 256) != 0) {
                                jM2342getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2342getPrimary0d7_KjU();
                                i14 = i13 & (-234881025);
                            } else {
                                jM2342getPrimary0d7_KjU = j;
                                i14 = i13;
                            }
                            if ((i2 & 512) != 0) {
                                ProvidableCompositionLocal<Color> localContentColor10 = ContentColorKt.getLocalContentColor();
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                Object objConsume10 = composerStartRestartGroup.consume(localContentColor10);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                jM6813copywmQWz5c$default = Color.m6813copywmQWz5c$default(((Color) objConsume10).m6824unboximpl(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                                i14 &= -1879048193;
                            } else {
                                jM6813copywmQWz5c$default = j2;
                            }
                        } else {
                            if (i17 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                z4 = true;
                            }
                            if (i6 != 0) {
                                function4 = null;
                            }
                            if (i8 != 0) {
                                z5 = true;
                            }
                            if (i10 != 0) {
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            if ((i2 & 256) != 0) {
                                jM2342getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2342getPrimary0d7_KjU();
                                i14 = i13 & (-234881025);
                            } else {
                                jM2342getPrimary0d7_KjU = j;
                                i14 = i13;
                            }
                            if ((i2 & 512) != 0) {
                                ProvidableCompositionLocal<Color> localContentColor11 = ContentColorKt.getLocalContentColor();
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                Object objConsume11 = composerStartRestartGroup.consume(localContentColor11);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                jM6813copywmQWz5c$default = Color.m6813copywmQWz5c$default(((Color) objConsume11).m6824unboximpl(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                                i14 &= -1879048193;
                            } else {
                                jM6813copywmQWz5c$default = j2;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(83562179, i14, -1, "androidx.compose.material.NavigationRailItem (NavigationRail.kt:211)");
                        }
                        if (function4 == null) {
                            composerStartRestartGroup.startReplaceGroup(-1679616946);
                        } else {
                            composerStartRestartGroup.startReplaceGroup(-1679616945);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "*214@9729L168");
                            composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-674640273, true, new Function2() { // from class: androidx.compose.material.NavigationRailKt$$ExternalSyntheticLambda4
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return NavigationRailKt.NavigationRailItem_0S3VyRs$lambda$0$0(function4, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composerStartRestartGroup, 54);
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        final Function2 composableLambda6 = composableLambdaRememberComposableLambda;
                        if (function4 == null) {
                            f = NavigationRailItemCompactSize;
                        } else {
                            f = NavigationRailItemSize;
                        }
                        MutableInteractionSource mutableInteractionSource9 = mutableInteractionSource3;
                        boolean z14 = z4;
                        Modifier modifierM1266size3ABfNKs6 = SizeKt.m1266size3ABfNKs(SelectableKt.m1533selectableO2vRcR0(modifier2, z, mutableInteractionSource9, RippleKt.m2523rippleH2RKhps$default(false, 0.0f, jM2342getPrimary0d7_KjU, 2, null), z14, Role.m8825boximpl(Role.INSTANCE.m8839getTabo7Vup1c()), function0), f);
                        Alignment center6 = Alignment.INSTANCE.getCenter();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy6 = BoxKt.maybeCachedBoxMeasurePolicy(center6, false);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                        CompositionLocalMap currentCompositionLocalMap6 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier6 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1266size3ABfNKs6);
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
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 415492902, "C240@10971L303,240@10890L384:NavigationRail.kt#jmzs0o");
                        int i26 = i14 >> 24;
                        m2476NavigationRailTransitionKlgxPg(jM2342getPrimary0d7_KjU, jM6813copywmQWz5c$default, z, ComposableLambdaKt.rememberComposableLambda(317431928, true, new Function3() { // from class: androidx.compose.material.NavigationRailKt$$ExternalSyntheticLambda5
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return NavigationRailKt.NavigationRailItem_0S3VyRs$lambda$1$0(z5, function2, composableLambda6, ((Float) obj).floatValue(), (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, (i26 & 112) | (i26 & 14) | 3072 | ((i14 << 6) & 896));
                        composer2 = composerStartRestartGroup;
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        composer2.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        mutableInteractionSource2 = mutableInteractionSource9;
                        function5 = function4;
                        z7 = z14;
                        j4 = jM6813copywmQWz5c$default;
                        j3 = jM2342getPrimary0d7_KjU;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        mutableInteractionSource2 = mutableInteractionSource;
                        z7 = z4;
                        function5 = function4;
                        j3 = j;
                        j4 = j2;
                    }
                    modifier3 = modifier2;
                    z8 = z5;
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.NavigationRailKt$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return NavigationRailKt.NavigationRailItem_0S3VyRs$lambda$2(z, function0, function2, modifier3, z7, function5, z8, mutableInteractionSource2, j3, j4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= 1572864;
                z5 = z3;
                i10 = i2 & 128;
                if (i10 != 0) {
                    if ((i & 12582912) == 0) {
                        if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                            i11 = 8388608;
                        } else {
                            i11 = 4194304;
                        }
                        i3 |= i11;
                    }
                    if ((i & 100663296) == 0) {
                        int i1110 = i3;
                        if ((i2 & 256) == 0) {
                            i16 = 33554432;
                        } else {
                            i16 = 33554432;
                        }
                        i12 = i1110 | i16;
                    } else {
                        i12 = i3;
                    }
                    if ((i & 805306368) == 0) {
                        int i1111 = i12;
                        if ((i2 & 512) == 0) {
                            i15 = 268435456;
                        } else {
                            i15 = 268435456;
                        }
                        i12 = i1111 | i15;
                    }
                    i13 = i12;
                    if ((i13 & 306783379) != 306783378) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z6, i13 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "209@9518L6,210@9588L7,210@9622L6");
                        composableLambdaRememberComposableLambda = null;
                        if ((i & 1) != 0) {
                            if (i17 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                z4 = true;
                            }
                            if (i6 != 0) {
                                function4 = null;
                            }
                            if (i8 != 0) {
                                z5 = true;
                            }
                            if (i10 != 0) {
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            if ((i2 & 256) != 0) {
                                jM2342getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2342getPrimary0d7_KjU();
                                i14 = i13 & (-234881025);
                            } else {
                                jM2342getPrimary0d7_KjU = j;
                                i14 = i13;
                            }
                            if ((i2 & 512) != 0) {
                                ProvidableCompositionLocal<Color> localContentColor12 = ContentColorKt.getLocalContentColor();
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                Object objConsume12 = composerStartRestartGroup.consume(localContentColor12);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                jM6813copywmQWz5c$default = Color.m6813copywmQWz5c$default(((Color) objConsume12).m6824unboximpl(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                                i14 &= -1879048193;
                            } else {
                                jM6813copywmQWz5c$default = j2;
                            }
                        } else {
                            if (i17 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                z4 = true;
                            }
                            if (i6 != 0) {
                                function4 = null;
                            }
                            if (i8 != 0) {
                                z5 = true;
                            }
                            if (i10 != 0) {
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            if ((i2 & 256) != 0) {
                                jM2342getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2342getPrimary0d7_KjU();
                                i14 = i13 & (-234881025);
                            } else {
                                jM2342getPrimary0d7_KjU = j;
                                i14 = i13;
                            }
                            if ((i2 & 512) != 0) {
                                ProvidableCompositionLocal<Color> localContentColor13 = ContentColorKt.getLocalContentColor();
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                Object objConsume13 = composerStartRestartGroup.consume(localContentColor13);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                jM6813copywmQWz5c$default = Color.m6813copywmQWz5c$default(((Color) objConsume13).m6824unboximpl(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                                i14 &= -1879048193;
                            } else {
                                jM6813copywmQWz5c$default = j2;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(83562179, i14, -1, "androidx.compose.material.NavigationRailItem (NavigationRail.kt:211)");
                        }
                        if (function4 == null) {
                            composerStartRestartGroup.startReplaceGroup(-1679616946);
                        } else {
                            composerStartRestartGroup.startReplaceGroup(-1679616945);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "*214@9729L168");
                            composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-674640273, true, new Function2() { // from class: androidx.compose.material.NavigationRailKt$$ExternalSyntheticLambda4
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return NavigationRailKt.NavigationRailItem_0S3VyRs$lambda$0$0(function4, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composerStartRestartGroup, 54);
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        final Function2 composableLambda7 = composableLambdaRememberComposableLambda;
                        if (function4 == null) {
                            f = NavigationRailItemCompactSize;
                        } else {
                            f = NavigationRailItemSize;
                        }
                        MutableInteractionSource mutableInteractionSource10 = mutableInteractionSource3;
                        boolean z15 = z4;
                        Modifier modifierM1266size3ABfNKs7 = SizeKt.m1266size3ABfNKs(SelectableKt.m1533selectableO2vRcR0(modifier2, z, mutableInteractionSource10, RippleKt.m2523rippleH2RKhps$default(false, 0.0f, jM2342getPrimary0d7_KjU, 2, null), z15, Role.m8825boximpl(Role.INSTANCE.m8839getTabo7Vup1c()), function0), f);
                        Alignment center7 = Alignment.INSTANCE.getCenter();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy7 = BoxKt.maybeCachedBoxMeasurePolicy(center7, false);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                        CompositionLocalMap currentCompositionLocalMap7 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier7 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1266size3ABfNKs7);
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
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 415492902, "C240@10971L303,240@10890L384:NavigationRail.kt#jmzs0o");
                        int i27 = i14 >> 24;
                        m2476NavigationRailTransitionKlgxPg(jM2342getPrimary0d7_KjU, jM6813copywmQWz5c$default, z, ComposableLambdaKt.rememberComposableLambda(317431928, true, new Function3() { // from class: androidx.compose.material.NavigationRailKt$$ExternalSyntheticLambda5
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return NavigationRailKt.NavigationRailItem_0S3VyRs$lambda$1$0(z5, function2, composableLambda7, ((Float) obj).floatValue(), (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, (i27 & 112) | (i27 & 14) | 3072 | ((i14 << 6) & 896));
                        composer2 = composerStartRestartGroup;
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        composer2.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        mutableInteractionSource2 = mutableInteractionSource10;
                        function5 = function4;
                        z7 = z15;
                        j4 = jM6813copywmQWz5c$default;
                        j3 = jM2342getPrimary0d7_KjU;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        mutableInteractionSource2 = mutableInteractionSource;
                        z7 = z4;
                        function5 = function4;
                        j3 = j;
                        j4 = j2;
                    }
                    modifier3 = modifier2;
                    z8 = z5;
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.NavigationRailKt$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return NavigationRailKt.NavigationRailItem_0S3VyRs$lambda$2(z, function0, function2, modifier3, z7, function5, z8, mutableInteractionSource2, j3, j4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= 12582912;
                if ((i & 100663296) == 0) {
                    int i1112 = i3;
                    if ((i2 & 256) == 0) {
                        i16 = 33554432;
                    } else {
                        i16 = 33554432;
                    }
                    i12 = i1112 | i16;
                } else {
                    i12 = i3;
                }
                if ((i & 805306368) == 0) {
                    int i1113 = i12;
                    if ((i2 & 512) == 0) {
                        i15 = 268435456;
                    } else {
                        i15 = 268435456;
                    }
                    i12 = i1113 | i15;
                }
                i13 = i12;
                if ((i13 & 306783379) != 306783378) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z6, i13 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "209@9518L6,210@9588L7,210@9622L6");
                    composableLambdaRememberComposableLambda = null;
                    if ((i & 1) != 0) {
                        if (i17 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            z4 = true;
                        }
                        if (i6 != 0) {
                            function4 = null;
                        }
                        if (i8 != 0) {
                            z5 = true;
                        }
                        if (i10 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        if ((i2 & 256) != 0) {
                            jM2342getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2342getPrimary0d7_KjU();
                            i14 = i13 & (-234881025);
                        } else {
                            jM2342getPrimary0d7_KjU = j;
                            i14 = i13;
                        }
                        if ((i2 & 512) != 0) {
                            ProvidableCompositionLocal<Color> localContentColor14 = ContentColorKt.getLocalContentColor();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                            Object objConsume14 = composerStartRestartGroup.consume(localContentColor14);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            jM6813copywmQWz5c$default = Color.m6813copywmQWz5c$default(((Color) objConsume14).m6824unboximpl(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                            i14 &= -1879048193;
                        } else {
                            jM6813copywmQWz5c$default = j2;
                        }
                    } else {
                        if (i17 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            z4 = true;
                        }
                        if (i6 != 0) {
                            function4 = null;
                        }
                        if (i8 != 0) {
                            z5 = true;
                        }
                        if (i10 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        if ((i2 & 256) != 0) {
                            jM2342getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2342getPrimary0d7_KjU();
                            i14 = i13 & (-234881025);
                        } else {
                            jM2342getPrimary0d7_KjU = j;
                            i14 = i13;
                        }
                        if ((i2 & 512) != 0) {
                            ProvidableCompositionLocal<Color> localContentColor15 = ContentColorKt.getLocalContentColor();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                            Object objConsume15 = composerStartRestartGroup.consume(localContentColor15);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            jM6813copywmQWz5c$default = Color.m6813copywmQWz5c$default(((Color) objConsume15).m6824unboximpl(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                            i14 &= -1879048193;
                        } else {
                            jM6813copywmQWz5c$default = j2;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(83562179, i14, -1, "androidx.compose.material.NavigationRailItem (NavigationRail.kt:211)");
                    }
                    if (function4 == null) {
                        composerStartRestartGroup.startReplaceGroup(-1679616946);
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-1679616945);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "*214@9729L168");
                        composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-674640273, true, new Function2() { // from class: androidx.compose.material.NavigationRailKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return NavigationRailKt.NavigationRailItem_0S3VyRs$lambda$0$0(function4, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    final Function2 composableLambda8 = composableLambdaRememberComposableLambda;
                    if (function4 == null) {
                        f = NavigationRailItemCompactSize;
                    } else {
                        f = NavigationRailItemSize;
                    }
                    MutableInteractionSource mutableInteractionSource11 = mutableInteractionSource3;
                    boolean z16 = z4;
                    Modifier modifierM1266size3ABfNKs8 = SizeKt.m1266size3ABfNKs(SelectableKt.m1533selectableO2vRcR0(modifier2, z, mutableInteractionSource11, RippleKt.m2523rippleH2RKhps$default(false, 0.0f, jM2342getPrimary0d7_KjU, 2, null), z16, Role.m8825boximpl(Role.INSTANCE.m8839getTabo7Vup1c()), function0), f);
                    Alignment center8 = Alignment.INSTANCE.getCenter();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy8 = BoxKt.maybeCachedBoxMeasurePolicy(center8, false);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap8 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier8 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1266size3ABfNKs8);
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
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 415492902, "C240@10971L303,240@10890L384:NavigationRail.kt#jmzs0o");
                    int i28 = i14 >> 24;
                    m2476NavigationRailTransitionKlgxPg(jM2342getPrimary0d7_KjU, jM6813copywmQWz5c$default, z, ComposableLambdaKt.rememberComposableLambda(317431928, true, new Function3() { // from class: androidx.compose.material.NavigationRailKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return NavigationRailKt.NavigationRailItem_0S3VyRs$lambda$1$0(z5, function2, composableLambda8, ((Float) obj).floatValue(), (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, (i28 & 112) | (i28 & 14) | 3072 | ((i14 << 6) & 896));
                    composer2 = composerStartRestartGroup;
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    mutableInteractionSource2 = mutableInteractionSource11;
                    function5 = function4;
                    z7 = z16;
                    j4 = jM6813copywmQWz5c$default;
                    j3 = jM2342getPrimary0d7_KjU;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    mutableInteractionSource2 = mutableInteractionSource;
                    z7 = z4;
                    function5 = function4;
                    j3 = j;
                    j4 = j2;
                }
                modifier3 = modifier2;
                z8 = z5;
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.NavigationRailKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return NavigationRailKt.NavigationRailItem_0S3VyRs$lambda$2(z, function0, function2, modifier3, z7, function5, z8, mutableInteractionSource2, j3, j4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
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
                    if ((1572864 & i) == 0) {
                        z5 = z3;
                        if (composerStartRestartGroup.changed(z5)) {
                            i9 = 1048576;
                        } else {
                            i9 = 524288;
                        }
                        i3 |= i9;
                    }
                    i10 = i2 & 128;
                    if (i10 != 0) {
                        if ((i & 12582912) == 0) {
                            if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                                i11 = 8388608;
                            } else {
                                i11 = 4194304;
                            }
                            i3 |= i11;
                        }
                        if ((i & 100663296) == 0) {
                            int i1114 = i3;
                            if ((i2 & 256) == 0) {
                                i16 = 33554432;
                            } else {
                                i16 = 33554432;
                            }
                            i12 = i1114 | i16;
                        } else {
                            i12 = i3;
                        }
                        if ((i & 805306368) == 0) {
                            int i1115 = i12;
                            if ((i2 & 512) == 0) {
                                i15 = 268435456;
                            } else {
                                i15 = 268435456;
                            }
                            i12 = i1115 | i15;
                        }
                        i13 = i12;
                        if ((i13 & 306783379) != 306783378) {
                            z6 = true;
                        } else {
                            z6 = false;
                        }
                        if (composerStartRestartGroup.shouldExecute(z6, i13 & 1)) {
                            composerStartRestartGroup.startDefaults();
                            ComposerKt.sourceInformation(composerStartRestartGroup, "209@9518L6,210@9588L7,210@9622L6");
                            composableLambdaRememberComposableLambda = null;
                            if ((i & 1) != 0) {
                                if (i17 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                if (i4 != 0) {
                                    z4 = true;
                                }
                                if (i6 != 0) {
                                    function4 = null;
                                }
                                if (i8 != 0) {
                                    z5 = true;
                                }
                                if (i10 != 0) {
                                    mutableInteractionSource3 = null;
                                } else {
                                    mutableInteractionSource3 = mutableInteractionSource;
                                }
                                if ((i2 & 256) != 0) {
                                    jM2342getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2342getPrimary0d7_KjU();
                                    i14 = i13 & (-234881025);
                                } else {
                                    jM2342getPrimary0d7_KjU = j;
                                    i14 = i13;
                                }
                                if ((i2 & 512) != 0) {
                                    ProvidableCompositionLocal<Color> localContentColor16 = ContentColorKt.getLocalContentColor();
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                    Object objConsume16 = composerStartRestartGroup.consume(localContentColor16);
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                    jM6813copywmQWz5c$default = Color.m6813copywmQWz5c$default(((Color) objConsume16).m6824unboximpl(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                                    i14 &= -1879048193;
                                } else {
                                    jM6813copywmQWz5c$default = j2;
                                }
                            } else {
                                if (i17 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                if (i4 != 0) {
                                    z4 = true;
                                }
                                if (i6 != 0) {
                                    function4 = null;
                                }
                                if (i8 != 0) {
                                    z5 = true;
                                }
                                if (i10 != 0) {
                                    mutableInteractionSource3 = null;
                                } else {
                                    mutableInteractionSource3 = mutableInteractionSource;
                                }
                                if ((i2 & 256) != 0) {
                                    jM2342getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2342getPrimary0d7_KjU();
                                    i14 = i13 & (-234881025);
                                } else {
                                    jM2342getPrimary0d7_KjU = j;
                                    i14 = i13;
                                }
                                if ((i2 & 512) != 0) {
                                    ProvidableCompositionLocal<Color> localContentColor17 = ContentColorKt.getLocalContentColor();
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                    Object objConsume17 = composerStartRestartGroup.consume(localContentColor17);
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                    jM6813copywmQWz5c$default = Color.m6813copywmQWz5c$default(((Color) objConsume17).m6824unboximpl(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                                    i14 &= -1879048193;
                                } else {
                                    jM6813copywmQWz5c$default = j2;
                                }
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(83562179, i14, -1, "androidx.compose.material.NavigationRailItem (NavigationRail.kt:211)");
                            }
                            if (function4 == null) {
                                composerStartRestartGroup.startReplaceGroup(-1679616946);
                            } else {
                                composerStartRestartGroup.startReplaceGroup(-1679616945);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "*214@9729L168");
                                composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-674640273, true, new Function2() { // from class: androidx.compose.material.NavigationRailKt$$ExternalSyntheticLambda4
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return NavigationRailKt.NavigationRailItem_0S3VyRs$lambda$0$0(function4, (Composer) obj, ((Integer) obj2).intValue());
                                    }
                                }, composerStartRestartGroup, 54);
                            }
                            composerStartRestartGroup.endReplaceGroup();
                            final Function2 composableLambda9 = composableLambdaRememberComposableLambda;
                            if (function4 == null) {
                                f = NavigationRailItemCompactSize;
                            } else {
                                f = NavigationRailItemSize;
                            }
                            MutableInteractionSource mutableInteractionSource12 = mutableInteractionSource3;
                            boolean z17 = z4;
                            Modifier modifierM1266size3ABfNKs9 = SizeKt.m1266size3ABfNKs(SelectableKt.m1533selectableO2vRcR0(modifier2, z, mutableInteractionSource12, RippleKt.m2523rippleH2RKhps$default(false, 0.0f, jM2342getPrimary0d7_KjU, 2, null), z17, Role.m8825boximpl(Role.INSTANCE.m8839getTabo7Vup1c()), function0), f);
                            Alignment center9 = Alignment.INSTANCE.getCenter();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy9 = BoxKt.maybeCachedBoxMeasurePolicy(center9, false);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                            CompositionLocalMap currentCompositionLocalMap9 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                            Modifier modifierMaterializeModifier9 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1266size3ABfNKs9);
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
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 415492902, "C240@10971L303,240@10890L384:NavigationRail.kt#jmzs0o");
                            int i29 = i14 >> 24;
                            m2476NavigationRailTransitionKlgxPg(jM2342getPrimary0d7_KjU, jM6813copywmQWz5c$default, z, ComposableLambdaKt.rememberComposableLambda(317431928, true, new Function3() { // from class: androidx.compose.material.NavigationRailKt$$ExternalSyntheticLambda5
                                @Override // kotlin.jvm.functions.Function3
                                public final Object invoke(Object obj, Object obj2, Object obj3) {
                                    return NavigationRailKt.NavigationRailItem_0S3VyRs$lambda$1$0(z5, function2, composableLambda9, ((Float) obj).floatValue(), (Composer) obj2, ((Integer) obj3).intValue());
                                }
                            }, composerStartRestartGroup, 54), composerStartRestartGroup, (i29 & 112) | (i29 & 14) | 3072 | ((i14 << 6) & 896));
                            composer2 = composerStartRestartGroup;
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            composer2.endNode();
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            mutableInteractionSource2 = mutableInteractionSource12;
                            function5 = function4;
                            z7 = z17;
                            j4 = jM6813copywmQWz5c$default;
                            j3 = jM2342getPrimary0d7_KjU;
                        } else {
                            composer2 = composerStartRestartGroup;
                            composer2.skipToGroupEnd();
                            mutableInteractionSource2 = mutableInteractionSource;
                            z7 = z4;
                            function5 = function4;
                            j3 = j;
                            j4 = j2;
                        }
                        modifier3 = modifier2;
                        z8 = z5;
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.NavigationRailKt$$ExternalSyntheticLambda6
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return NavigationRailKt.NavigationRailItem_0S3VyRs$lambda$2(z, function0, function2, modifier3, z7, function5, z8, mutableInteractionSource2, j3, j4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                        }
                    }
                    i3 |= 12582912;
                    if ((i & 100663296) == 0) {
                        int i1116 = i3;
                        if ((i2 & 256) == 0) {
                            i16 = 33554432;
                        } else {
                            i16 = 33554432;
                        }
                        i12 = i1116 | i16;
                    } else {
                        i12 = i3;
                    }
                    if ((i & 805306368) == 0) {
                        int i1117 = i12;
                        if ((i2 & 512) == 0) {
                            i15 = 268435456;
                        } else {
                            i15 = 268435456;
                        }
                        i12 = i1117 | i15;
                    }
                    i13 = i12;
                    if ((i13 & 306783379) != 306783378) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z6, i13 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "209@9518L6,210@9588L7,210@9622L6");
                        composableLambdaRememberComposableLambda = null;
                        if ((i & 1) != 0) {
                            if (i17 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                z4 = true;
                            }
                            if (i6 != 0) {
                                function4 = null;
                            }
                            if (i8 != 0) {
                                z5 = true;
                            }
                            if (i10 != 0) {
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            if ((i2 & 256) != 0) {
                                jM2342getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2342getPrimary0d7_KjU();
                                i14 = i13 & (-234881025);
                            } else {
                                jM2342getPrimary0d7_KjU = j;
                                i14 = i13;
                            }
                            if ((i2 & 512) != 0) {
                                ProvidableCompositionLocal<Color> localContentColor18 = ContentColorKt.getLocalContentColor();
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                Object objConsume18 = composerStartRestartGroup.consume(localContentColor18);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                jM6813copywmQWz5c$default = Color.m6813copywmQWz5c$default(((Color) objConsume18).m6824unboximpl(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                                i14 &= -1879048193;
                            } else {
                                jM6813copywmQWz5c$default = j2;
                            }
                        } else {
                            if (i17 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                z4 = true;
                            }
                            if (i6 != 0) {
                                function4 = null;
                            }
                            if (i8 != 0) {
                                z5 = true;
                            }
                            if (i10 != 0) {
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            if ((i2 & 256) != 0) {
                                jM2342getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2342getPrimary0d7_KjU();
                                i14 = i13 & (-234881025);
                            } else {
                                jM2342getPrimary0d7_KjU = j;
                                i14 = i13;
                            }
                            if ((i2 & 512) != 0) {
                                ProvidableCompositionLocal<Color> localContentColor19 = ContentColorKt.getLocalContentColor();
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                Object objConsume19 = composerStartRestartGroup.consume(localContentColor19);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                jM6813copywmQWz5c$default = Color.m6813copywmQWz5c$default(((Color) objConsume19).m6824unboximpl(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                                i14 &= -1879048193;
                            } else {
                                jM6813copywmQWz5c$default = j2;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(83562179, i14, -1, "androidx.compose.material.NavigationRailItem (NavigationRail.kt:211)");
                        }
                        if (function4 == null) {
                            composerStartRestartGroup.startReplaceGroup(-1679616946);
                        } else {
                            composerStartRestartGroup.startReplaceGroup(-1679616945);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "*214@9729L168");
                            composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-674640273, true, new Function2() { // from class: androidx.compose.material.NavigationRailKt$$ExternalSyntheticLambda4
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return NavigationRailKt.NavigationRailItem_0S3VyRs$lambda$0$0(function4, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composerStartRestartGroup, 54);
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        final Function2 composableLambda10 = composableLambdaRememberComposableLambda;
                        if (function4 == null) {
                            f = NavigationRailItemCompactSize;
                        } else {
                            f = NavigationRailItemSize;
                        }
                        MutableInteractionSource mutableInteractionSource13 = mutableInteractionSource3;
                        boolean z18 = z4;
                        Modifier modifierM1266size3ABfNKs10 = SizeKt.m1266size3ABfNKs(SelectableKt.m1533selectableO2vRcR0(modifier2, z, mutableInteractionSource13, RippleKt.m2523rippleH2RKhps$default(false, 0.0f, jM2342getPrimary0d7_KjU, 2, null), z18, Role.m8825boximpl(Role.INSTANCE.m8839getTabo7Vup1c()), function0), f);
                        Alignment center10 = Alignment.INSTANCE.getCenter();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy10 = BoxKt.maybeCachedBoxMeasurePolicy(center10, false);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                        CompositionLocalMap currentCompositionLocalMap10 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier10 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1266size3ABfNKs10);
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
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 415492902, "C240@10971L303,240@10890L384:NavigationRail.kt#jmzs0o");
                        int i210 = i14 >> 24;
                        m2476NavigationRailTransitionKlgxPg(jM2342getPrimary0d7_KjU, jM6813copywmQWz5c$default, z, ComposableLambdaKt.rememberComposableLambda(317431928, true, new Function3() { // from class: androidx.compose.material.NavigationRailKt$$ExternalSyntheticLambda5
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return NavigationRailKt.NavigationRailItem_0S3VyRs$lambda$1$0(z5, function2, composableLambda10, ((Float) obj).floatValue(), (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, (i210 & 112) | (i210 & 14) | 3072 | ((i14 << 6) & 896));
                        composer2 = composerStartRestartGroup;
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        composer2.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        mutableInteractionSource2 = mutableInteractionSource13;
                        function5 = function4;
                        z7 = z18;
                        j4 = jM6813copywmQWz5c$default;
                        j3 = jM2342getPrimary0d7_KjU;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        mutableInteractionSource2 = mutableInteractionSource;
                        z7 = z4;
                        function5 = function4;
                        j3 = j;
                        j4 = j2;
                    }
                    modifier3 = modifier2;
                    z8 = z5;
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.NavigationRailKt$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return NavigationRailKt.NavigationRailItem_0S3VyRs$lambda$2(z, function0, function2, modifier3, z7, function5, z8, mutableInteractionSource2, j3, j4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= 1572864;
                z5 = z3;
                i10 = i2 & 128;
                if (i10 != 0) {
                    if ((i & 12582912) == 0) {
                        if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                            i11 = 8388608;
                        } else {
                            i11 = 4194304;
                        }
                        i3 |= i11;
                    }
                    if ((i & 100663296) == 0) {
                        int i1118 = i3;
                        if ((i2 & 256) == 0) {
                            i16 = 33554432;
                        } else {
                            i16 = 33554432;
                        }
                        i12 = i1118 | i16;
                    } else {
                        i12 = i3;
                    }
                    if ((i & 805306368) == 0) {
                        int i1119 = i12;
                        if ((i2 & 512) == 0) {
                            i15 = 268435456;
                        } else {
                            i15 = 268435456;
                        }
                        i12 = i1119 | i15;
                    }
                    i13 = i12;
                    if ((i13 & 306783379) != 306783378) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z6, i13 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "209@9518L6,210@9588L7,210@9622L6");
                        composableLambdaRememberComposableLambda = null;
                        if ((i & 1) != 0) {
                            if (i17 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                z4 = true;
                            }
                            if (i6 != 0) {
                                function4 = null;
                            }
                            if (i8 != 0) {
                                z5 = true;
                            }
                            if (i10 != 0) {
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            if ((i2 & 256) != 0) {
                                jM2342getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2342getPrimary0d7_KjU();
                                i14 = i13 & (-234881025);
                            } else {
                                jM2342getPrimary0d7_KjU = j;
                                i14 = i13;
                            }
                            if ((i2 & 512) != 0) {
                                ProvidableCompositionLocal<Color> localContentColor110 = ContentColorKt.getLocalContentColor();
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                Object objConsume110 = composerStartRestartGroup.consume(localContentColor110);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                jM6813copywmQWz5c$default = Color.m6813copywmQWz5c$default(((Color) objConsume110).m6824unboximpl(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                                i14 &= -1879048193;
                            } else {
                                jM6813copywmQWz5c$default = j2;
                            }
                        } else {
                            if (i17 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                z4 = true;
                            }
                            if (i6 != 0) {
                                function4 = null;
                            }
                            if (i8 != 0) {
                                z5 = true;
                            }
                            if (i10 != 0) {
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            if ((i2 & 256) != 0) {
                                jM2342getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2342getPrimary0d7_KjU();
                                i14 = i13 & (-234881025);
                            } else {
                                jM2342getPrimary0d7_KjU = j;
                                i14 = i13;
                            }
                            if ((i2 & 512) != 0) {
                                ProvidableCompositionLocal<Color> localContentColor111 = ContentColorKt.getLocalContentColor();
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                Object objConsume111 = composerStartRestartGroup.consume(localContentColor111);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                jM6813copywmQWz5c$default = Color.m6813copywmQWz5c$default(((Color) objConsume111).m6824unboximpl(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                                i14 &= -1879048193;
                            } else {
                                jM6813copywmQWz5c$default = j2;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(83562179, i14, -1, "androidx.compose.material.NavigationRailItem (NavigationRail.kt:211)");
                        }
                        if (function4 == null) {
                            composerStartRestartGroup.startReplaceGroup(-1679616946);
                        } else {
                            composerStartRestartGroup.startReplaceGroup(-1679616945);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "*214@9729L168");
                            composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-674640273, true, new Function2() { // from class: androidx.compose.material.NavigationRailKt$$ExternalSyntheticLambda4
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return NavigationRailKt.NavigationRailItem_0S3VyRs$lambda$0$0(function4, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composerStartRestartGroup, 54);
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        final Function2 composableLambda11 = composableLambdaRememberComposableLambda;
                        if (function4 == null) {
                            f = NavigationRailItemCompactSize;
                        } else {
                            f = NavigationRailItemSize;
                        }
                        MutableInteractionSource mutableInteractionSource14 = mutableInteractionSource3;
                        boolean z19 = z4;
                        Modifier modifierM1266size3ABfNKs11 = SizeKt.m1266size3ABfNKs(SelectableKt.m1533selectableO2vRcR0(modifier2, z, mutableInteractionSource14, RippleKt.m2523rippleH2RKhps$default(false, 0.0f, jM2342getPrimary0d7_KjU, 2, null), z19, Role.m8825boximpl(Role.INSTANCE.m8839getTabo7Vup1c()), function0), f);
                        Alignment center11 = Alignment.INSTANCE.getCenter();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy11 = BoxKt.maybeCachedBoxMeasurePolicy(center11, false);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                        CompositionLocalMap currentCompositionLocalMap11 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier11 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1266size3ABfNKs11);
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
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 415492902, "C240@10971L303,240@10890L384:NavigationRail.kt#jmzs0o");
                        int i211 = i14 >> 24;
                        m2476NavigationRailTransitionKlgxPg(jM2342getPrimary0d7_KjU, jM6813copywmQWz5c$default, z, ComposableLambdaKt.rememberComposableLambda(317431928, true, new Function3() { // from class: androidx.compose.material.NavigationRailKt$$ExternalSyntheticLambda5
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return NavigationRailKt.NavigationRailItem_0S3VyRs$lambda$1$0(z5, function2, composableLambda11, ((Float) obj).floatValue(), (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, (i211 & 112) | (i211 & 14) | 3072 | ((i14 << 6) & 896));
                        composer2 = composerStartRestartGroup;
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        composer2.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        mutableInteractionSource2 = mutableInteractionSource14;
                        function5 = function4;
                        z7 = z19;
                        j4 = jM6813copywmQWz5c$default;
                        j3 = jM2342getPrimary0d7_KjU;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        mutableInteractionSource2 = mutableInteractionSource;
                        z7 = z4;
                        function5 = function4;
                        j3 = j;
                        j4 = j2;
                    }
                    modifier3 = modifier2;
                    z8 = z5;
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.NavigationRailKt$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return NavigationRailKt.NavigationRailItem_0S3VyRs$lambda$2(z, function0, function2, modifier3, z7, function5, z8, mutableInteractionSource2, j3, j4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= 12582912;
                if ((i & 100663296) == 0) {
                    int i11110 = i3;
                    if ((i2 & 256) == 0) {
                        i16 = 33554432;
                    } else {
                        i16 = 33554432;
                    }
                    i12 = i11110 | i16;
                } else {
                    i12 = i3;
                }
                if ((i & 805306368) == 0) {
                    int i11111 = i12;
                    if ((i2 & 512) == 0) {
                        i15 = 268435456;
                    } else {
                        i15 = 268435456;
                    }
                    i12 = i11111 | i15;
                }
                i13 = i12;
                if ((i13 & 306783379) != 306783378) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z6, i13 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "209@9518L6,210@9588L7,210@9622L6");
                    composableLambdaRememberComposableLambda = null;
                    if ((i & 1) != 0) {
                        if (i17 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            z4 = true;
                        }
                        if (i6 != 0) {
                            function4 = null;
                        }
                        if (i8 != 0) {
                            z5 = true;
                        }
                        if (i10 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        if ((i2 & 256) != 0) {
                            jM2342getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2342getPrimary0d7_KjU();
                            i14 = i13 & (-234881025);
                        } else {
                            jM2342getPrimary0d7_KjU = j;
                            i14 = i13;
                        }
                        if ((i2 & 512) != 0) {
                            ProvidableCompositionLocal<Color> localContentColor112 = ContentColorKt.getLocalContentColor();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                            Object objConsume112 = composerStartRestartGroup.consume(localContentColor112);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            jM6813copywmQWz5c$default = Color.m6813copywmQWz5c$default(((Color) objConsume112).m6824unboximpl(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                            i14 &= -1879048193;
                        } else {
                            jM6813copywmQWz5c$default = j2;
                        }
                    } else {
                        if (i17 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            z4 = true;
                        }
                        if (i6 != 0) {
                            function4 = null;
                        }
                        if (i8 != 0) {
                            z5 = true;
                        }
                        if (i10 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        if ((i2 & 256) != 0) {
                            jM2342getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2342getPrimary0d7_KjU();
                            i14 = i13 & (-234881025);
                        } else {
                            jM2342getPrimary0d7_KjU = j;
                            i14 = i13;
                        }
                        if ((i2 & 512) != 0) {
                            ProvidableCompositionLocal<Color> localContentColor113 = ContentColorKt.getLocalContentColor();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                            Object objConsume113 = composerStartRestartGroup.consume(localContentColor113);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            jM6813copywmQWz5c$default = Color.m6813copywmQWz5c$default(((Color) objConsume113).m6824unboximpl(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                            i14 &= -1879048193;
                        } else {
                            jM6813copywmQWz5c$default = j2;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(83562179, i14, -1, "androidx.compose.material.NavigationRailItem (NavigationRail.kt:211)");
                    }
                    if (function4 == null) {
                        composerStartRestartGroup.startReplaceGroup(-1679616946);
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-1679616945);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "*214@9729L168");
                        composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-674640273, true, new Function2() { // from class: androidx.compose.material.NavigationRailKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return NavigationRailKt.NavigationRailItem_0S3VyRs$lambda$0$0(function4, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    final Function2 composableLambda12 = composableLambdaRememberComposableLambda;
                    if (function4 == null) {
                        f = NavigationRailItemCompactSize;
                    } else {
                        f = NavigationRailItemSize;
                    }
                    MutableInteractionSource mutableInteractionSource15 = mutableInteractionSource3;
                    boolean z110 = z4;
                    Modifier modifierM1266size3ABfNKs12 = SizeKt.m1266size3ABfNKs(SelectableKt.m1533selectableO2vRcR0(modifier2, z, mutableInteractionSource15, RippleKt.m2523rippleH2RKhps$default(false, 0.0f, jM2342getPrimary0d7_KjU, 2, null), z110, Role.m8825boximpl(Role.INSTANCE.m8839getTabo7Vup1c()), function0), f);
                    Alignment center12 = Alignment.INSTANCE.getCenter();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy12 = BoxKt.maybeCachedBoxMeasurePolicy(center12, false);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap12 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier12 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1266size3ABfNKs12);
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
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 415492902, "C240@10971L303,240@10890L384:NavigationRail.kt#jmzs0o");
                    int i212 = i14 >> 24;
                    m2476NavigationRailTransitionKlgxPg(jM2342getPrimary0d7_KjU, jM6813copywmQWz5c$default, z, ComposableLambdaKt.rememberComposableLambda(317431928, true, new Function3() { // from class: androidx.compose.material.NavigationRailKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return NavigationRailKt.NavigationRailItem_0S3VyRs$lambda$1$0(z5, function2, composableLambda12, ((Float) obj).floatValue(), (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, (i212 & 112) | (i212 & 14) | 3072 | ((i14 << 6) & 896));
                    composer2 = composerStartRestartGroup;
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    mutableInteractionSource2 = mutableInteractionSource15;
                    function5 = function4;
                    z7 = z110;
                    j4 = jM6813copywmQWz5c$default;
                    j3 = jM2342getPrimary0d7_KjU;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    mutableInteractionSource2 = mutableInteractionSource;
                    z7 = z4;
                    function5 = function4;
                    j3 = j;
                    j4 = j2;
                }
                modifier3 = modifier2;
                z8 = z5;
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.NavigationRailKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return NavigationRailKt.NavigationRailItem_0S3VyRs$lambda$2(z, function0, function2, modifier3, z7, function5, z8, mutableInteractionSource2, j3, j4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            function4 = function3;
            i8 = i2 & 64;
            if (i8 != 0) {
                if ((1572864 & i) == 0) {
                    z5 = z3;
                    if (composerStartRestartGroup.changed(z5)) {
                        i9 = 1048576;
                    } else {
                        i9 = 524288;
                    }
                    i3 |= i9;
                }
                i10 = i2 & 128;
                if (i10 != 0) {
                    if ((i & 12582912) == 0) {
                        if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                            i11 = 8388608;
                        } else {
                            i11 = 4194304;
                        }
                        i3 |= i11;
                    }
                    if ((i & 100663296) == 0) {
                        int i11112 = i3;
                        if ((i2 & 256) == 0) {
                            i16 = 33554432;
                        } else {
                            i16 = 33554432;
                        }
                        i12 = i11112 | i16;
                    } else {
                        i12 = i3;
                    }
                    if ((i & 805306368) == 0) {
                        int i11113 = i12;
                        if ((i2 & 512) == 0) {
                            i15 = 268435456;
                        } else {
                            i15 = 268435456;
                        }
                        i12 = i11113 | i15;
                    }
                    i13 = i12;
                    if ((i13 & 306783379) != 306783378) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z6, i13 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "209@9518L6,210@9588L7,210@9622L6");
                        composableLambdaRememberComposableLambda = null;
                        if ((i & 1) != 0) {
                            if (i17 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                z4 = true;
                            }
                            if (i6 != 0) {
                                function4 = null;
                            }
                            if (i8 != 0) {
                                z5 = true;
                            }
                            if (i10 != 0) {
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            if ((i2 & 256) != 0) {
                                jM2342getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2342getPrimary0d7_KjU();
                                i14 = i13 & (-234881025);
                            } else {
                                jM2342getPrimary0d7_KjU = j;
                                i14 = i13;
                            }
                            if ((i2 & 512) != 0) {
                                ProvidableCompositionLocal<Color> localContentColor114 = ContentColorKt.getLocalContentColor();
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                Object objConsume114 = composerStartRestartGroup.consume(localContentColor114);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                jM6813copywmQWz5c$default = Color.m6813copywmQWz5c$default(((Color) objConsume114).m6824unboximpl(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                                i14 &= -1879048193;
                            } else {
                                jM6813copywmQWz5c$default = j2;
                            }
                        } else {
                            if (i17 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                z4 = true;
                            }
                            if (i6 != 0) {
                                function4 = null;
                            }
                            if (i8 != 0) {
                                z5 = true;
                            }
                            if (i10 != 0) {
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            if ((i2 & 256) != 0) {
                                jM2342getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2342getPrimary0d7_KjU();
                                i14 = i13 & (-234881025);
                            } else {
                                jM2342getPrimary0d7_KjU = j;
                                i14 = i13;
                            }
                            if ((i2 & 512) != 0) {
                                ProvidableCompositionLocal<Color> localContentColor115 = ContentColorKt.getLocalContentColor();
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                Object objConsume115 = composerStartRestartGroup.consume(localContentColor115);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                jM6813copywmQWz5c$default = Color.m6813copywmQWz5c$default(((Color) objConsume115).m6824unboximpl(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                                i14 &= -1879048193;
                            } else {
                                jM6813copywmQWz5c$default = j2;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(83562179, i14, -1, "androidx.compose.material.NavigationRailItem (NavigationRail.kt:211)");
                        }
                        if (function4 == null) {
                            composerStartRestartGroup.startReplaceGroup(-1679616946);
                        } else {
                            composerStartRestartGroup.startReplaceGroup(-1679616945);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "*214@9729L168");
                            composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-674640273, true, new Function2() { // from class: androidx.compose.material.NavigationRailKt$$ExternalSyntheticLambda4
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return NavigationRailKt.NavigationRailItem_0S3VyRs$lambda$0$0(function4, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composerStartRestartGroup, 54);
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        final Function2 composableLambda13 = composableLambdaRememberComposableLambda;
                        if (function4 == null) {
                            f = NavigationRailItemCompactSize;
                        } else {
                            f = NavigationRailItemSize;
                        }
                        MutableInteractionSource mutableInteractionSource16 = mutableInteractionSource3;
                        boolean z111 = z4;
                        Modifier modifierM1266size3ABfNKs13 = SizeKt.m1266size3ABfNKs(SelectableKt.m1533selectableO2vRcR0(modifier2, z, mutableInteractionSource16, RippleKt.m2523rippleH2RKhps$default(false, 0.0f, jM2342getPrimary0d7_KjU, 2, null), z111, Role.m8825boximpl(Role.INSTANCE.m8839getTabo7Vup1c()), function0), f);
                        Alignment center13 = Alignment.INSTANCE.getCenter();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy13 = BoxKt.maybeCachedBoxMeasurePolicy(center13, false);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                        CompositionLocalMap currentCompositionLocalMap13 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier13 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1266size3ABfNKs13);
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
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 415492902, "C240@10971L303,240@10890L384:NavigationRail.kt#jmzs0o");
                        int i213 = i14 >> 24;
                        m2476NavigationRailTransitionKlgxPg(jM2342getPrimary0d7_KjU, jM6813copywmQWz5c$default, z, ComposableLambdaKt.rememberComposableLambda(317431928, true, new Function3() { // from class: androidx.compose.material.NavigationRailKt$$ExternalSyntheticLambda5
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return NavigationRailKt.NavigationRailItem_0S3VyRs$lambda$1$0(z5, function2, composableLambda13, ((Float) obj).floatValue(), (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, (i213 & 112) | (i213 & 14) | 3072 | ((i14 << 6) & 896));
                        composer2 = composerStartRestartGroup;
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        composer2.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        mutableInteractionSource2 = mutableInteractionSource16;
                        function5 = function4;
                        z7 = z111;
                        j4 = jM6813copywmQWz5c$default;
                        j3 = jM2342getPrimary0d7_KjU;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        mutableInteractionSource2 = mutableInteractionSource;
                        z7 = z4;
                        function5 = function4;
                        j3 = j;
                        j4 = j2;
                    }
                    modifier3 = modifier2;
                    z8 = z5;
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.NavigationRailKt$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return NavigationRailKt.NavigationRailItem_0S3VyRs$lambda$2(z, function0, function2, modifier3, z7, function5, z8, mutableInteractionSource2, j3, j4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= 12582912;
                if ((i & 100663296) == 0) {
                    int i11114 = i3;
                    if ((i2 & 256) == 0) {
                        i16 = 33554432;
                    } else {
                        i16 = 33554432;
                    }
                    i12 = i11114 | i16;
                } else {
                    i12 = i3;
                }
                if ((i & 805306368) == 0) {
                    int i11115 = i12;
                    if ((i2 & 512) == 0) {
                        i15 = 268435456;
                    } else {
                        i15 = 268435456;
                    }
                    i12 = i11115 | i15;
                }
                i13 = i12;
                if ((i13 & 306783379) != 306783378) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z6, i13 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "209@9518L6,210@9588L7,210@9622L6");
                    composableLambdaRememberComposableLambda = null;
                    if ((i & 1) != 0) {
                        if (i17 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            z4 = true;
                        }
                        if (i6 != 0) {
                            function4 = null;
                        }
                        if (i8 != 0) {
                            z5 = true;
                        }
                        if (i10 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        if ((i2 & 256) != 0) {
                            jM2342getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2342getPrimary0d7_KjU();
                            i14 = i13 & (-234881025);
                        } else {
                            jM2342getPrimary0d7_KjU = j;
                            i14 = i13;
                        }
                        if ((i2 & 512) != 0) {
                            ProvidableCompositionLocal<Color> localContentColor116 = ContentColorKt.getLocalContentColor();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                            Object objConsume116 = composerStartRestartGroup.consume(localContentColor116);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            jM6813copywmQWz5c$default = Color.m6813copywmQWz5c$default(((Color) objConsume116).m6824unboximpl(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                            i14 &= -1879048193;
                        } else {
                            jM6813copywmQWz5c$default = j2;
                        }
                    } else {
                        if (i17 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            z4 = true;
                        }
                        if (i6 != 0) {
                            function4 = null;
                        }
                        if (i8 != 0) {
                            z5 = true;
                        }
                        if (i10 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        if ((i2 & 256) != 0) {
                            jM2342getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2342getPrimary0d7_KjU();
                            i14 = i13 & (-234881025);
                        } else {
                            jM2342getPrimary0d7_KjU = j;
                            i14 = i13;
                        }
                        if ((i2 & 512) != 0) {
                            ProvidableCompositionLocal<Color> localContentColor117 = ContentColorKt.getLocalContentColor();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                            Object objConsume117 = composerStartRestartGroup.consume(localContentColor117);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            jM6813copywmQWz5c$default = Color.m6813copywmQWz5c$default(((Color) objConsume117).m6824unboximpl(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                            i14 &= -1879048193;
                        } else {
                            jM6813copywmQWz5c$default = j2;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(83562179, i14, -1, "androidx.compose.material.NavigationRailItem (NavigationRail.kt:211)");
                    }
                    if (function4 == null) {
                        composerStartRestartGroup.startReplaceGroup(-1679616946);
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-1679616945);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "*214@9729L168");
                        composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-674640273, true, new Function2() { // from class: androidx.compose.material.NavigationRailKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return NavigationRailKt.NavigationRailItem_0S3VyRs$lambda$0$0(function4, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    final Function2 composableLambda14 = composableLambdaRememberComposableLambda;
                    if (function4 == null) {
                        f = NavigationRailItemCompactSize;
                    } else {
                        f = NavigationRailItemSize;
                    }
                    MutableInteractionSource mutableInteractionSource17 = mutableInteractionSource3;
                    boolean z112 = z4;
                    Modifier modifierM1266size3ABfNKs14 = SizeKt.m1266size3ABfNKs(SelectableKt.m1533selectableO2vRcR0(modifier2, z, mutableInteractionSource17, RippleKt.m2523rippleH2RKhps$default(false, 0.0f, jM2342getPrimary0d7_KjU, 2, null), z112, Role.m8825boximpl(Role.INSTANCE.m8839getTabo7Vup1c()), function0), f);
                    Alignment center14 = Alignment.INSTANCE.getCenter();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy14 = BoxKt.maybeCachedBoxMeasurePolicy(center14, false);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap14 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier14 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1266size3ABfNKs14);
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
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 415492902, "C240@10971L303,240@10890L384:NavigationRail.kt#jmzs0o");
                    int i214 = i14 >> 24;
                    m2476NavigationRailTransitionKlgxPg(jM2342getPrimary0d7_KjU, jM6813copywmQWz5c$default, z, ComposableLambdaKt.rememberComposableLambda(317431928, true, new Function3() { // from class: androidx.compose.material.NavigationRailKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return NavigationRailKt.NavigationRailItem_0S3VyRs$lambda$1$0(z5, function2, composableLambda14, ((Float) obj).floatValue(), (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, (i214 & 112) | (i214 & 14) | 3072 | ((i14 << 6) & 896));
                    composer2 = composerStartRestartGroup;
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    mutableInteractionSource2 = mutableInteractionSource17;
                    function5 = function4;
                    z7 = z112;
                    j4 = jM6813copywmQWz5c$default;
                    j3 = jM2342getPrimary0d7_KjU;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    mutableInteractionSource2 = mutableInteractionSource;
                    z7 = z4;
                    function5 = function4;
                    j3 = j;
                    j4 = j2;
                }
                modifier3 = modifier2;
                z8 = z5;
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.NavigationRailKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return NavigationRailKt.NavigationRailItem_0S3VyRs$lambda$2(z, function0, function2, modifier3, z7, function5, z8, mutableInteractionSource2, j3, j4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 1572864;
            z5 = z3;
            i10 = i2 & 128;
            if (i10 != 0) {
                if ((i & 12582912) == 0) {
                    if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                        i11 = 8388608;
                    } else {
                        i11 = 4194304;
                    }
                    i3 |= i11;
                }
                if ((i & 100663296) == 0) {
                    int i11116 = i3;
                    if ((i2 & 256) == 0) {
                        i16 = 33554432;
                    } else {
                        i16 = 33554432;
                    }
                    i12 = i11116 | i16;
                } else {
                    i12 = i3;
                }
                if ((i & 805306368) == 0) {
                    int i11117 = i12;
                    if ((i2 & 512) == 0) {
                        i15 = 268435456;
                    } else {
                        i15 = 268435456;
                    }
                    i12 = i11117 | i15;
                }
                i13 = i12;
                if ((i13 & 306783379) != 306783378) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z6, i13 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "209@9518L6,210@9588L7,210@9622L6");
                    composableLambdaRememberComposableLambda = null;
                    if ((i & 1) != 0) {
                        if (i17 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            z4 = true;
                        }
                        if (i6 != 0) {
                            function4 = null;
                        }
                        if (i8 != 0) {
                            z5 = true;
                        }
                        if (i10 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        if ((i2 & 256) != 0) {
                            jM2342getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2342getPrimary0d7_KjU();
                            i14 = i13 & (-234881025);
                        } else {
                            jM2342getPrimary0d7_KjU = j;
                            i14 = i13;
                        }
                        if ((i2 & 512) != 0) {
                            ProvidableCompositionLocal<Color> localContentColor118 = ContentColorKt.getLocalContentColor();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                            Object objConsume118 = composerStartRestartGroup.consume(localContentColor118);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            jM6813copywmQWz5c$default = Color.m6813copywmQWz5c$default(((Color) objConsume118).m6824unboximpl(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                            i14 &= -1879048193;
                        } else {
                            jM6813copywmQWz5c$default = j2;
                        }
                    } else {
                        if (i17 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            z4 = true;
                        }
                        if (i6 != 0) {
                            function4 = null;
                        }
                        if (i8 != 0) {
                            z5 = true;
                        }
                        if (i10 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        if ((i2 & 256) != 0) {
                            jM2342getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2342getPrimary0d7_KjU();
                            i14 = i13 & (-234881025);
                        } else {
                            jM2342getPrimary0d7_KjU = j;
                            i14 = i13;
                        }
                        if ((i2 & 512) != 0) {
                            ProvidableCompositionLocal<Color> localContentColor119 = ContentColorKt.getLocalContentColor();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                            Object objConsume119 = composerStartRestartGroup.consume(localContentColor119);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            jM6813copywmQWz5c$default = Color.m6813copywmQWz5c$default(((Color) objConsume119).m6824unboximpl(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                            i14 &= -1879048193;
                        } else {
                            jM6813copywmQWz5c$default = j2;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(83562179, i14, -1, "androidx.compose.material.NavigationRailItem (NavigationRail.kt:211)");
                    }
                    if (function4 == null) {
                        composerStartRestartGroup.startReplaceGroup(-1679616946);
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-1679616945);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "*214@9729L168");
                        composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-674640273, true, new Function2() { // from class: androidx.compose.material.NavigationRailKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return NavigationRailKt.NavigationRailItem_0S3VyRs$lambda$0$0(function4, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    final Function2 composableLambda15 = composableLambdaRememberComposableLambda;
                    if (function4 == null) {
                        f = NavigationRailItemCompactSize;
                    } else {
                        f = NavigationRailItemSize;
                    }
                    MutableInteractionSource mutableInteractionSource18 = mutableInteractionSource3;
                    boolean z113 = z4;
                    Modifier modifierM1266size3ABfNKs15 = SizeKt.m1266size3ABfNKs(SelectableKt.m1533selectableO2vRcR0(modifier2, z, mutableInteractionSource18, RippleKt.m2523rippleH2RKhps$default(false, 0.0f, jM2342getPrimary0d7_KjU, 2, null), z113, Role.m8825boximpl(Role.INSTANCE.m8839getTabo7Vup1c()), function0), f);
                    Alignment center15 = Alignment.INSTANCE.getCenter();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy15 = BoxKt.maybeCachedBoxMeasurePolicy(center15, false);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap15 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier15 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1266size3ABfNKs15);
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
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 415492902, "C240@10971L303,240@10890L384:NavigationRail.kt#jmzs0o");
                    int i215 = i14 >> 24;
                    m2476NavigationRailTransitionKlgxPg(jM2342getPrimary0d7_KjU, jM6813copywmQWz5c$default, z, ComposableLambdaKt.rememberComposableLambda(317431928, true, new Function3() { // from class: androidx.compose.material.NavigationRailKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return NavigationRailKt.NavigationRailItem_0S3VyRs$lambda$1$0(z5, function2, composableLambda15, ((Float) obj).floatValue(), (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, (i215 & 112) | (i215 & 14) | 3072 | ((i14 << 6) & 896));
                    composer2 = composerStartRestartGroup;
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    mutableInteractionSource2 = mutableInteractionSource18;
                    function5 = function4;
                    z7 = z113;
                    j4 = jM6813copywmQWz5c$default;
                    j3 = jM2342getPrimary0d7_KjU;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    mutableInteractionSource2 = mutableInteractionSource;
                    z7 = z4;
                    function5 = function4;
                    j3 = j;
                    j4 = j2;
                }
                modifier3 = modifier2;
                z8 = z5;
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.NavigationRailKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return NavigationRailKt.NavigationRailItem_0S3VyRs$lambda$2(z, function0, function2, modifier3, z7, function5, z8, mutableInteractionSource2, j3, j4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 12582912;
            if ((i & 100663296) == 0) {
                int i11118 = i3;
                if ((i2 & 256) == 0) {
                    i16 = 33554432;
                } else {
                    i16 = 33554432;
                }
                i12 = i11118 | i16;
            } else {
                i12 = i3;
            }
            if ((i & 805306368) == 0) {
                int i11119 = i12;
                if ((i2 & 512) == 0) {
                    i15 = 268435456;
                } else {
                    i15 = 268435456;
                }
                i12 = i11119 | i15;
            }
            i13 = i12;
            if ((i13 & 306783379) != 306783378) {
                z6 = true;
            } else {
                z6 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z6, i13 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "209@9518L6,210@9588L7,210@9622L6");
                composableLambdaRememberComposableLambda = null;
                if ((i & 1) != 0) {
                    if (i17 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        z4 = true;
                    }
                    if (i6 != 0) {
                        function4 = null;
                    }
                    if (i8 != 0) {
                        z5 = true;
                    }
                    if (i10 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    if ((i2 & 256) != 0) {
                        jM2342getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2342getPrimary0d7_KjU();
                        i14 = i13 & (-234881025);
                    } else {
                        jM2342getPrimary0d7_KjU = j;
                        i14 = i13;
                    }
                    if ((i2 & 512) != 0) {
                        ProvidableCompositionLocal<Color> localContentColor1110 = ContentColorKt.getLocalContentColor();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object objConsume1110 = composerStartRestartGroup.consume(localContentColor1110);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        jM6813copywmQWz5c$default = Color.m6813copywmQWz5c$default(((Color) objConsume1110).m6824unboximpl(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                        i14 &= -1879048193;
                    } else {
                        jM6813copywmQWz5c$default = j2;
                    }
                } else {
                    if (i17 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        z4 = true;
                    }
                    if (i6 != 0) {
                        function4 = null;
                    }
                    if (i8 != 0) {
                        z5 = true;
                    }
                    if (i10 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    if ((i2 & 256) != 0) {
                        jM2342getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2342getPrimary0d7_KjU();
                        i14 = i13 & (-234881025);
                    } else {
                        jM2342getPrimary0d7_KjU = j;
                        i14 = i13;
                    }
                    if ((i2 & 512) != 0) {
                        ProvidableCompositionLocal<Color> localContentColor1111 = ContentColorKt.getLocalContentColor();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object objConsume1111 = composerStartRestartGroup.consume(localContentColor1111);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        jM6813copywmQWz5c$default = Color.m6813copywmQWz5c$default(((Color) objConsume1111).m6824unboximpl(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                        i14 &= -1879048193;
                    } else {
                        jM6813copywmQWz5c$default = j2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(83562179, i14, -1, "androidx.compose.material.NavigationRailItem (NavigationRail.kt:211)");
                }
                if (function4 == null) {
                    composerStartRestartGroup.startReplaceGroup(-1679616946);
                } else {
                    composerStartRestartGroup.startReplaceGroup(-1679616945);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "*214@9729L168");
                    composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-674640273, true, new Function2() { // from class: androidx.compose.material.NavigationRailKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return NavigationRailKt.NavigationRailItem_0S3VyRs$lambda$0$0(function4, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54);
                }
                composerStartRestartGroup.endReplaceGroup();
                final Function2 composableLambda16 = composableLambdaRememberComposableLambda;
                if (function4 == null) {
                    f = NavigationRailItemCompactSize;
                } else {
                    f = NavigationRailItemSize;
                }
                MutableInteractionSource mutableInteractionSource19 = mutableInteractionSource3;
                boolean z114 = z4;
                Modifier modifierM1266size3ABfNKs16 = SizeKt.m1266size3ABfNKs(SelectableKt.m1533selectableO2vRcR0(modifier2, z, mutableInteractionSource19, RippleKt.m2523rippleH2RKhps$default(false, 0.0f, jM2342getPrimary0d7_KjU, 2, null), z114, Role.m8825boximpl(Role.INSTANCE.m8839getTabo7Vup1c()), function0), f);
                Alignment center16 = Alignment.INSTANCE.getCenter();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy16 = BoxKt.maybeCachedBoxMeasurePolicy(center16, false);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap16 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier16 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1266size3ABfNKs16);
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
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 415492902, "C240@10971L303,240@10890L384:NavigationRail.kt#jmzs0o");
                int i216 = i14 >> 24;
                m2476NavigationRailTransitionKlgxPg(jM2342getPrimary0d7_KjU, jM6813copywmQWz5c$default, z, ComposableLambdaKt.rememberComposableLambda(317431928, true, new Function3() { // from class: androidx.compose.material.NavigationRailKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return NavigationRailKt.NavigationRailItem_0S3VyRs$lambda$1$0(z5, function2, composableLambda16, ((Float) obj).floatValue(), (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, (i216 & 112) | (i216 & 14) | 3072 | ((i14 << 6) & 896));
                composer2 = composerStartRestartGroup;
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                mutableInteractionSource2 = mutableInteractionSource19;
                function5 = function4;
                z7 = z114;
                j4 = jM6813copywmQWz5c$default;
                j3 = jM2342getPrimary0d7_KjU;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                mutableInteractionSource2 = mutableInteractionSource;
                z7 = z4;
                function5 = function4;
                j3 = j;
                j4 = j2;
            }
            modifier3 = modifier2;
            z8 = z5;
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.NavigationRailKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return NavigationRailKt.NavigationRailItem_0S3VyRs$lambda$2(z, function0, function2, modifier3, z7, function5, z8, mutableInteractionSource2, j3, j4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
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
                    if ((1572864 & i) == 0) {
                        z5 = z3;
                        if (composerStartRestartGroup.changed(z5)) {
                            i9 = 1048576;
                        } else {
                            i9 = 524288;
                        }
                        i3 |= i9;
                    }
                    i10 = i2 & 128;
                    if (i10 != 0) {
                        if ((i & 12582912) == 0) {
                            if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                                i11 = 8388608;
                            } else {
                                i11 = 4194304;
                            }
                            i3 |= i11;
                        }
                        if ((i & 100663296) == 0) {
                            int i111110 = i3;
                            if ((i2 & 256) == 0) {
                                i16 = 33554432;
                            } else {
                                i16 = 33554432;
                            }
                            i12 = i111110 | i16;
                        } else {
                            i12 = i3;
                        }
                        if ((i & 805306368) == 0) {
                            int i111111 = i12;
                            if ((i2 & 512) == 0) {
                                i15 = 268435456;
                            } else {
                                i15 = 268435456;
                            }
                            i12 = i111111 | i15;
                        }
                        i13 = i12;
                        if ((i13 & 306783379) != 306783378) {
                            z6 = true;
                        } else {
                            z6 = false;
                        }
                        if (composerStartRestartGroup.shouldExecute(z6, i13 & 1)) {
                            composerStartRestartGroup.startDefaults();
                            ComposerKt.sourceInformation(composerStartRestartGroup, "209@9518L6,210@9588L7,210@9622L6");
                            composableLambdaRememberComposableLambda = null;
                            if ((i & 1) != 0) {
                                if (i17 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                if (i4 != 0) {
                                    z4 = true;
                                }
                                if (i6 != 0) {
                                    function4 = null;
                                }
                                if (i8 != 0) {
                                    z5 = true;
                                }
                                if (i10 != 0) {
                                    mutableInteractionSource3 = null;
                                } else {
                                    mutableInteractionSource3 = mutableInteractionSource;
                                }
                                if ((i2 & 256) != 0) {
                                    jM2342getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2342getPrimary0d7_KjU();
                                    i14 = i13 & (-234881025);
                                } else {
                                    jM2342getPrimary0d7_KjU = j;
                                    i14 = i13;
                                }
                                if ((i2 & 512) != 0) {
                                    ProvidableCompositionLocal<Color> localContentColor1112 = ContentColorKt.getLocalContentColor();
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                    Object objConsume1112 = composerStartRestartGroup.consume(localContentColor1112);
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                    jM6813copywmQWz5c$default = Color.m6813copywmQWz5c$default(((Color) objConsume1112).m6824unboximpl(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                                    i14 &= -1879048193;
                                } else {
                                    jM6813copywmQWz5c$default = j2;
                                }
                            } else {
                                if (i17 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                if (i4 != 0) {
                                    z4 = true;
                                }
                                if (i6 != 0) {
                                    function4 = null;
                                }
                                if (i8 != 0) {
                                    z5 = true;
                                }
                                if (i10 != 0) {
                                    mutableInteractionSource3 = null;
                                } else {
                                    mutableInteractionSource3 = mutableInteractionSource;
                                }
                                if ((i2 & 256) != 0) {
                                    jM2342getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2342getPrimary0d7_KjU();
                                    i14 = i13 & (-234881025);
                                } else {
                                    jM2342getPrimary0d7_KjU = j;
                                    i14 = i13;
                                }
                                if ((i2 & 512) != 0) {
                                    ProvidableCompositionLocal<Color> localContentColor1113 = ContentColorKt.getLocalContentColor();
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                    Object objConsume1113 = composerStartRestartGroup.consume(localContentColor1113);
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                    jM6813copywmQWz5c$default = Color.m6813copywmQWz5c$default(((Color) objConsume1113).m6824unboximpl(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                                    i14 &= -1879048193;
                                } else {
                                    jM6813copywmQWz5c$default = j2;
                                }
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(83562179, i14, -1, "androidx.compose.material.NavigationRailItem (NavigationRail.kt:211)");
                            }
                            if (function4 == null) {
                                composerStartRestartGroup.startReplaceGroup(-1679616946);
                            } else {
                                composerStartRestartGroup.startReplaceGroup(-1679616945);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "*214@9729L168");
                                composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-674640273, true, new Function2() { // from class: androidx.compose.material.NavigationRailKt$$ExternalSyntheticLambda4
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return NavigationRailKt.NavigationRailItem_0S3VyRs$lambda$0$0(function4, (Composer) obj, ((Integer) obj2).intValue());
                                    }
                                }, composerStartRestartGroup, 54);
                            }
                            composerStartRestartGroup.endReplaceGroup();
                            final Function2 composableLambda17 = composableLambdaRememberComposableLambda;
                            if (function4 == null) {
                                f = NavigationRailItemCompactSize;
                            } else {
                                f = NavigationRailItemSize;
                            }
                            MutableInteractionSource mutableInteractionSource110 = mutableInteractionSource3;
                            boolean z115 = z4;
                            Modifier modifierM1266size3ABfNKs17 = SizeKt.m1266size3ABfNKs(SelectableKt.m1533selectableO2vRcR0(modifier2, z, mutableInteractionSource110, RippleKt.m2523rippleH2RKhps$default(false, 0.0f, jM2342getPrimary0d7_KjU, 2, null), z115, Role.m8825boximpl(Role.INSTANCE.m8839getTabo7Vup1c()), function0), f);
                            Alignment center17 = Alignment.INSTANCE.getCenter();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy17 = BoxKt.maybeCachedBoxMeasurePolicy(center17, false);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                            CompositionLocalMap currentCompositionLocalMap17 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                            Modifier modifierMaterializeModifier17 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1266size3ABfNKs17);
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
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 415492902, "C240@10971L303,240@10890L384:NavigationRail.kt#jmzs0o");
                            int i217 = i14 >> 24;
                            m2476NavigationRailTransitionKlgxPg(jM2342getPrimary0d7_KjU, jM6813copywmQWz5c$default, z, ComposableLambdaKt.rememberComposableLambda(317431928, true, new Function3() { // from class: androidx.compose.material.NavigationRailKt$$ExternalSyntheticLambda5
                                @Override // kotlin.jvm.functions.Function3
                                public final Object invoke(Object obj, Object obj2, Object obj3) {
                                    return NavigationRailKt.NavigationRailItem_0S3VyRs$lambda$1$0(z5, function2, composableLambda17, ((Float) obj).floatValue(), (Composer) obj2, ((Integer) obj3).intValue());
                                }
                            }, composerStartRestartGroup, 54), composerStartRestartGroup, (i217 & 112) | (i217 & 14) | 3072 | ((i14 << 6) & 896));
                            composer2 = composerStartRestartGroup;
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            composer2.endNode();
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            mutableInteractionSource2 = mutableInteractionSource110;
                            function5 = function4;
                            z7 = z115;
                            j4 = jM6813copywmQWz5c$default;
                            j3 = jM2342getPrimary0d7_KjU;
                        } else {
                            composer2 = composerStartRestartGroup;
                            composer2.skipToGroupEnd();
                            mutableInteractionSource2 = mutableInteractionSource;
                            z7 = z4;
                            function5 = function4;
                            j3 = j;
                            j4 = j2;
                        }
                        modifier3 = modifier2;
                        z8 = z5;
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.NavigationRailKt$$ExternalSyntheticLambda6
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return NavigationRailKt.NavigationRailItem_0S3VyRs$lambda$2(z, function0, function2, modifier3, z7, function5, z8, mutableInteractionSource2, j3, j4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                        }
                    }
                    i3 |= 12582912;
                    if ((i & 100663296) == 0) {
                        int i111112 = i3;
                        if ((i2 & 256) == 0) {
                            i16 = 33554432;
                        } else {
                            i16 = 33554432;
                        }
                        i12 = i111112 | i16;
                    } else {
                        i12 = i3;
                    }
                    if ((i & 805306368) == 0) {
                        int i111113 = i12;
                        if ((i2 & 512) == 0) {
                            i15 = 268435456;
                        } else {
                            i15 = 268435456;
                        }
                        i12 = i111113 | i15;
                    }
                    i13 = i12;
                    if ((i13 & 306783379) != 306783378) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z6, i13 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "209@9518L6,210@9588L7,210@9622L6");
                        composableLambdaRememberComposableLambda = null;
                        if ((i & 1) != 0) {
                            if (i17 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                z4 = true;
                            }
                            if (i6 != 0) {
                                function4 = null;
                            }
                            if (i8 != 0) {
                                z5 = true;
                            }
                            if (i10 != 0) {
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            if ((i2 & 256) != 0) {
                                jM2342getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2342getPrimary0d7_KjU();
                                i14 = i13 & (-234881025);
                            } else {
                                jM2342getPrimary0d7_KjU = j;
                                i14 = i13;
                            }
                            if ((i2 & 512) != 0) {
                                ProvidableCompositionLocal<Color> localContentColor1114 = ContentColorKt.getLocalContentColor();
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                Object objConsume1114 = composerStartRestartGroup.consume(localContentColor1114);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                jM6813copywmQWz5c$default = Color.m6813copywmQWz5c$default(((Color) objConsume1114).m6824unboximpl(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                                i14 &= -1879048193;
                            } else {
                                jM6813copywmQWz5c$default = j2;
                            }
                        } else {
                            if (i17 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                z4 = true;
                            }
                            if (i6 != 0) {
                                function4 = null;
                            }
                            if (i8 != 0) {
                                z5 = true;
                            }
                            if (i10 != 0) {
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            if ((i2 & 256) != 0) {
                                jM2342getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2342getPrimary0d7_KjU();
                                i14 = i13 & (-234881025);
                            } else {
                                jM2342getPrimary0d7_KjU = j;
                                i14 = i13;
                            }
                            if ((i2 & 512) != 0) {
                                ProvidableCompositionLocal<Color> localContentColor1115 = ContentColorKt.getLocalContentColor();
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                Object objConsume1115 = composerStartRestartGroup.consume(localContentColor1115);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                jM6813copywmQWz5c$default = Color.m6813copywmQWz5c$default(((Color) objConsume1115).m6824unboximpl(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                                i14 &= -1879048193;
                            } else {
                                jM6813copywmQWz5c$default = j2;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(83562179, i14, -1, "androidx.compose.material.NavigationRailItem (NavigationRail.kt:211)");
                        }
                        if (function4 == null) {
                            composerStartRestartGroup.startReplaceGroup(-1679616946);
                        } else {
                            composerStartRestartGroup.startReplaceGroup(-1679616945);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "*214@9729L168");
                            composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-674640273, true, new Function2() { // from class: androidx.compose.material.NavigationRailKt$$ExternalSyntheticLambda4
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return NavigationRailKt.NavigationRailItem_0S3VyRs$lambda$0$0(function4, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composerStartRestartGroup, 54);
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        final Function2 composableLambda18 = composableLambdaRememberComposableLambda;
                        if (function4 == null) {
                            f = NavigationRailItemCompactSize;
                        } else {
                            f = NavigationRailItemSize;
                        }
                        MutableInteractionSource mutableInteractionSource111 = mutableInteractionSource3;
                        boolean z116 = z4;
                        Modifier modifierM1266size3ABfNKs18 = SizeKt.m1266size3ABfNKs(SelectableKt.m1533selectableO2vRcR0(modifier2, z, mutableInteractionSource111, RippleKt.m2523rippleH2RKhps$default(false, 0.0f, jM2342getPrimary0d7_KjU, 2, null), z116, Role.m8825boximpl(Role.INSTANCE.m8839getTabo7Vup1c()), function0), f);
                        Alignment center18 = Alignment.INSTANCE.getCenter();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy18 = BoxKt.maybeCachedBoxMeasurePolicy(center18, false);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                        CompositionLocalMap currentCompositionLocalMap18 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier18 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1266size3ABfNKs18);
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
                        Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy18, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap18, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (!composerM6062constructorimpl.getInserting()) {
                            composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        } else {
                            composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        }
                        Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier18, ComposeUiNode.INSTANCE.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance18 = BoxScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 415492902, "C240@10971L303,240@10890L384:NavigationRail.kt#jmzs0o");
                        int i218 = i14 >> 24;
                        m2476NavigationRailTransitionKlgxPg(jM2342getPrimary0d7_KjU, jM6813copywmQWz5c$default, z, ComposableLambdaKt.rememberComposableLambda(317431928, true, new Function3() { // from class: androidx.compose.material.NavigationRailKt$$ExternalSyntheticLambda5
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return NavigationRailKt.NavigationRailItem_0S3VyRs$lambda$1$0(z5, function2, composableLambda18, ((Float) obj).floatValue(), (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, (i218 & 112) | (i218 & 14) | 3072 | ((i14 << 6) & 896));
                        composer2 = composerStartRestartGroup;
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        composer2.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        mutableInteractionSource2 = mutableInteractionSource111;
                        function5 = function4;
                        z7 = z116;
                        j4 = jM6813copywmQWz5c$default;
                        j3 = jM2342getPrimary0d7_KjU;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        mutableInteractionSource2 = mutableInteractionSource;
                        z7 = z4;
                        function5 = function4;
                        j3 = j;
                        j4 = j2;
                    }
                    modifier3 = modifier2;
                    z8 = z5;
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.NavigationRailKt$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return NavigationRailKt.NavigationRailItem_0S3VyRs$lambda$2(z, function0, function2, modifier3, z7, function5, z8, mutableInteractionSource2, j3, j4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= 1572864;
                z5 = z3;
                i10 = i2 & 128;
                if (i10 != 0) {
                    if ((i & 12582912) == 0) {
                        if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                            i11 = 8388608;
                        } else {
                            i11 = 4194304;
                        }
                        i3 |= i11;
                    }
                    if ((i & 100663296) == 0) {
                        int i111114 = i3;
                        if ((i2 & 256) == 0) {
                            i16 = 33554432;
                        } else {
                            i16 = 33554432;
                        }
                        i12 = i111114 | i16;
                    } else {
                        i12 = i3;
                    }
                    if ((i & 805306368) == 0) {
                        int i111115 = i12;
                        if ((i2 & 512) == 0) {
                            i15 = 268435456;
                        } else {
                            i15 = 268435456;
                        }
                        i12 = i111115 | i15;
                    }
                    i13 = i12;
                    if ((i13 & 306783379) != 306783378) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z6, i13 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "209@9518L6,210@9588L7,210@9622L6");
                        composableLambdaRememberComposableLambda = null;
                        if ((i & 1) != 0) {
                            if (i17 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                z4 = true;
                            }
                            if (i6 != 0) {
                                function4 = null;
                            }
                            if (i8 != 0) {
                                z5 = true;
                            }
                            if (i10 != 0) {
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            if ((i2 & 256) != 0) {
                                jM2342getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2342getPrimary0d7_KjU();
                                i14 = i13 & (-234881025);
                            } else {
                                jM2342getPrimary0d7_KjU = j;
                                i14 = i13;
                            }
                            if ((i2 & 512) != 0) {
                                ProvidableCompositionLocal<Color> localContentColor1116 = ContentColorKt.getLocalContentColor();
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                Object objConsume1116 = composerStartRestartGroup.consume(localContentColor1116);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                jM6813copywmQWz5c$default = Color.m6813copywmQWz5c$default(((Color) objConsume1116).m6824unboximpl(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                                i14 &= -1879048193;
                            } else {
                                jM6813copywmQWz5c$default = j2;
                            }
                        } else {
                            if (i17 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                z4 = true;
                            }
                            if (i6 != 0) {
                                function4 = null;
                            }
                            if (i8 != 0) {
                                z5 = true;
                            }
                            if (i10 != 0) {
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            if ((i2 & 256) != 0) {
                                jM2342getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2342getPrimary0d7_KjU();
                                i14 = i13 & (-234881025);
                            } else {
                                jM2342getPrimary0d7_KjU = j;
                                i14 = i13;
                            }
                            if ((i2 & 512) != 0) {
                                ProvidableCompositionLocal<Color> localContentColor1117 = ContentColorKt.getLocalContentColor();
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                Object objConsume1117 = composerStartRestartGroup.consume(localContentColor1117);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                jM6813copywmQWz5c$default = Color.m6813copywmQWz5c$default(((Color) objConsume1117).m6824unboximpl(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                                i14 &= -1879048193;
                            } else {
                                jM6813copywmQWz5c$default = j2;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(83562179, i14, -1, "androidx.compose.material.NavigationRailItem (NavigationRail.kt:211)");
                        }
                        if (function4 == null) {
                            composerStartRestartGroup.startReplaceGroup(-1679616946);
                        } else {
                            composerStartRestartGroup.startReplaceGroup(-1679616945);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "*214@9729L168");
                            composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-674640273, true, new Function2() { // from class: androidx.compose.material.NavigationRailKt$$ExternalSyntheticLambda4
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return NavigationRailKt.NavigationRailItem_0S3VyRs$lambda$0$0(function4, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composerStartRestartGroup, 54);
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        final Function2 composableLambda19 = composableLambdaRememberComposableLambda;
                        if (function4 == null) {
                            f = NavigationRailItemCompactSize;
                        } else {
                            f = NavigationRailItemSize;
                        }
                        MutableInteractionSource mutableInteractionSource112 = mutableInteractionSource3;
                        boolean z117 = z4;
                        Modifier modifierM1266size3ABfNKs19 = SizeKt.m1266size3ABfNKs(SelectableKt.m1533selectableO2vRcR0(modifier2, z, mutableInteractionSource112, RippleKt.m2523rippleH2RKhps$default(false, 0.0f, jM2342getPrimary0d7_KjU, 2, null), z117, Role.m8825boximpl(Role.INSTANCE.m8839getTabo7Vup1c()), function0), f);
                        Alignment center19 = Alignment.INSTANCE.getCenter();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy19 = BoxKt.maybeCachedBoxMeasurePolicy(center19, false);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                        CompositionLocalMap currentCompositionLocalMap19 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier19 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1266size3ABfNKs19);
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
                        Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy19, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
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
                        BoxScopeInstance boxScopeInstance19 = BoxScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 415492902, "C240@10971L303,240@10890L384:NavigationRail.kt#jmzs0o");
                        int i219 = i14 >> 24;
                        m2476NavigationRailTransitionKlgxPg(jM2342getPrimary0d7_KjU, jM6813copywmQWz5c$default, z, ComposableLambdaKt.rememberComposableLambda(317431928, true, new Function3() { // from class: androidx.compose.material.NavigationRailKt$$ExternalSyntheticLambda5
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return NavigationRailKt.NavigationRailItem_0S3VyRs$lambda$1$0(z5, function2, composableLambda19, ((Float) obj).floatValue(), (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, (i219 & 112) | (i219 & 14) | 3072 | ((i14 << 6) & 896));
                        composer2 = composerStartRestartGroup;
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        composer2.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        mutableInteractionSource2 = mutableInteractionSource112;
                        function5 = function4;
                        z7 = z117;
                        j4 = jM6813copywmQWz5c$default;
                        j3 = jM2342getPrimary0d7_KjU;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        mutableInteractionSource2 = mutableInteractionSource;
                        z7 = z4;
                        function5 = function4;
                        j3 = j;
                        j4 = j2;
                    }
                    modifier3 = modifier2;
                    z8 = z5;
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.NavigationRailKt$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return NavigationRailKt.NavigationRailItem_0S3VyRs$lambda$2(z, function0, function2, modifier3, z7, function5, z8, mutableInteractionSource2, j3, j4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= 12582912;
                if ((i & 100663296) == 0) {
                    int i111116 = i3;
                    if ((i2 & 256) == 0) {
                        i16 = 33554432;
                    } else {
                        i16 = 33554432;
                    }
                    i12 = i111116 | i16;
                } else {
                    i12 = i3;
                }
                if ((i & 805306368) == 0) {
                    int i111117 = i12;
                    if ((i2 & 512) == 0) {
                        i15 = 268435456;
                    } else {
                        i15 = 268435456;
                    }
                    i12 = i111117 | i15;
                }
                i13 = i12;
                if ((i13 & 306783379) != 306783378) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z6, i13 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "209@9518L6,210@9588L7,210@9622L6");
                    composableLambdaRememberComposableLambda = null;
                    if ((i & 1) != 0) {
                        if (i17 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            z4 = true;
                        }
                        if (i6 != 0) {
                            function4 = null;
                        }
                        if (i8 != 0) {
                            z5 = true;
                        }
                        if (i10 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        if ((i2 & 256) != 0) {
                            jM2342getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2342getPrimary0d7_KjU();
                            i14 = i13 & (-234881025);
                        } else {
                            jM2342getPrimary0d7_KjU = j;
                            i14 = i13;
                        }
                        if ((i2 & 512) != 0) {
                            ProvidableCompositionLocal<Color> localContentColor1118 = ContentColorKt.getLocalContentColor();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                            Object objConsume1118 = composerStartRestartGroup.consume(localContentColor1118);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            jM6813copywmQWz5c$default = Color.m6813copywmQWz5c$default(((Color) objConsume1118).m6824unboximpl(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                            i14 &= -1879048193;
                        } else {
                            jM6813copywmQWz5c$default = j2;
                        }
                    } else {
                        if (i17 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            z4 = true;
                        }
                        if (i6 != 0) {
                            function4 = null;
                        }
                        if (i8 != 0) {
                            z5 = true;
                        }
                        if (i10 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        if ((i2 & 256) != 0) {
                            jM2342getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2342getPrimary0d7_KjU();
                            i14 = i13 & (-234881025);
                        } else {
                            jM2342getPrimary0d7_KjU = j;
                            i14 = i13;
                        }
                        if ((i2 & 512) != 0) {
                            ProvidableCompositionLocal<Color> localContentColor1119 = ContentColorKt.getLocalContentColor();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                            Object objConsume1119 = composerStartRestartGroup.consume(localContentColor1119);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            jM6813copywmQWz5c$default = Color.m6813copywmQWz5c$default(((Color) objConsume1119).m6824unboximpl(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                            i14 &= -1879048193;
                        } else {
                            jM6813copywmQWz5c$default = j2;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(83562179, i14, -1, "androidx.compose.material.NavigationRailItem (NavigationRail.kt:211)");
                    }
                    if (function4 == null) {
                        composerStartRestartGroup.startReplaceGroup(-1679616946);
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-1679616945);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "*214@9729L168");
                        composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-674640273, true, new Function2() { // from class: androidx.compose.material.NavigationRailKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return NavigationRailKt.NavigationRailItem_0S3VyRs$lambda$0$0(function4, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    final Function2 composableLambda110 = composableLambdaRememberComposableLambda;
                    if (function4 == null) {
                        f = NavigationRailItemCompactSize;
                    } else {
                        f = NavigationRailItemSize;
                    }
                    MutableInteractionSource mutableInteractionSource113 = mutableInteractionSource3;
                    boolean z118 = z4;
                    Modifier modifierM1266size3ABfNKs110 = SizeKt.m1266size3ABfNKs(SelectableKt.m1533selectableO2vRcR0(modifier2, z, mutableInteractionSource113, RippleKt.m2523rippleH2RKhps$default(false, 0.0f, jM2342getPrimary0d7_KjU, 2, null), z118, Role.m8825boximpl(Role.INSTANCE.m8839getTabo7Vup1c()), function0), f);
                    Alignment center110 = Alignment.INSTANCE.getCenter();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy110 = BoxKt.maybeCachedBoxMeasurePolicy(center110, false);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap110 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier110 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1266size3ABfNKs110);
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
                    Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy110, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap110, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (!composerM6062constructorimpl.getInserting()) {
                        composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    } else {
                        composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier110, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance110 = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 415492902, "C240@10971L303,240@10890L384:NavigationRail.kt#jmzs0o");
                    int i2110 = i14 >> 24;
                    m2476NavigationRailTransitionKlgxPg(jM2342getPrimary0d7_KjU, jM6813copywmQWz5c$default, z, ComposableLambdaKt.rememberComposableLambda(317431928, true, new Function3() { // from class: androidx.compose.material.NavigationRailKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return NavigationRailKt.NavigationRailItem_0S3VyRs$lambda$1$0(z5, function2, composableLambda110, ((Float) obj).floatValue(), (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, (i2110 & 112) | (i2110 & 14) | 3072 | ((i14 << 6) & 896));
                    composer2 = composerStartRestartGroup;
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    mutableInteractionSource2 = mutableInteractionSource113;
                    function5 = function4;
                    z7 = z118;
                    j4 = jM6813copywmQWz5c$default;
                    j3 = jM2342getPrimary0d7_KjU;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    mutableInteractionSource2 = mutableInteractionSource;
                    z7 = z4;
                    function5 = function4;
                    j3 = j;
                    j4 = j2;
                }
                modifier3 = modifier2;
                z8 = z5;
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.NavigationRailKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return NavigationRailKt.NavigationRailItem_0S3VyRs$lambda$2(z, function0, function2, modifier3, z7, function5, z8, mutableInteractionSource2, j3, j4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            function4 = function3;
            i8 = i2 & 64;
            if (i8 != 0) {
                if ((1572864 & i) == 0) {
                    z5 = z3;
                    if (composerStartRestartGroup.changed(z5)) {
                        i9 = 1048576;
                    } else {
                        i9 = 524288;
                    }
                    i3 |= i9;
                }
                i10 = i2 & 128;
                if (i10 != 0) {
                    if ((i & 12582912) == 0) {
                        if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                            i11 = 8388608;
                        } else {
                            i11 = 4194304;
                        }
                        i3 |= i11;
                    }
                    if ((i & 100663296) == 0) {
                        int i111118 = i3;
                        if ((i2 & 256) == 0) {
                            i16 = 33554432;
                        } else {
                            i16 = 33554432;
                        }
                        i12 = i111118 | i16;
                    } else {
                        i12 = i3;
                    }
                    if ((i & 805306368) == 0) {
                        int i111119 = i12;
                        if ((i2 & 512) == 0) {
                            i15 = 268435456;
                        } else {
                            i15 = 268435456;
                        }
                        i12 = i111119 | i15;
                    }
                    i13 = i12;
                    if ((i13 & 306783379) != 306783378) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z6, i13 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "209@9518L6,210@9588L7,210@9622L6");
                        composableLambdaRememberComposableLambda = null;
                        if ((i & 1) != 0) {
                            if (i17 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                z4 = true;
                            }
                            if (i6 != 0) {
                                function4 = null;
                            }
                            if (i8 != 0) {
                                z5 = true;
                            }
                            if (i10 != 0) {
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            if ((i2 & 256) != 0) {
                                jM2342getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2342getPrimary0d7_KjU();
                                i14 = i13 & (-234881025);
                            } else {
                                jM2342getPrimary0d7_KjU = j;
                                i14 = i13;
                            }
                            if ((i2 & 512) != 0) {
                                ProvidableCompositionLocal<Color> localContentColor11110 = ContentColorKt.getLocalContentColor();
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                Object objConsume11110 = composerStartRestartGroup.consume(localContentColor11110);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                jM6813copywmQWz5c$default = Color.m6813copywmQWz5c$default(((Color) objConsume11110).m6824unboximpl(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                                i14 &= -1879048193;
                            } else {
                                jM6813copywmQWz5c$default = j2;
                            }
                        } else {
                            if (i17 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                z4 = true;
                            }
                            if (i6 != 0) {
                                function4 = null;
                            }
                            if (i8 != 0) {
                                z5 = true;
                            }
                            if (i10 != 0) {
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            if ((i2 & 256) != 0) {
                                jM2342getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2342getPrimary0d7_KjU();
                                i14 = i13 & (-234881025);
                            } else {
                                jM2342getPrimary0d7_KjU = j;
                                i14 = i13;
                            }
                            if ((i2 & 512) != 0) {
                                ProvidableCompositionLocal<Color> localContentColor11111 = ContentColorKt.getLocalContentColor();
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                Object objConsume11111 = composerStartRestartGroup.consume(localContentColor11111);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                jM6813copywmQWz5c$default = Color.m6813copywmQWz5c$default(((Color) objConsume11111).m6824unboximpl(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                                i14 &= -1879048193;
                            } else {
                                jM6813copywmQWz5c$default = j2;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(83562179, i14, -1, "androidx.compose.material.NavigationRailItem (NavigationRail.kt:211)");
                        }
                        if (function4 == null) {
                            composerStartRestartGroup.startReplaceGroup(-1679616946);
                        } else {
                            composerStartRestartGroup.startReplaceGroup(-1679616945);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "*214@9729L168");
                            composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-674640273, true, new Function2() { // from class: androidx.compose.material.NavigationRailKt$$ExternalSyntheticLambda4
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return NavigationRailKt.NavigationRailItem_0S3VyRs$lambda$0$0(function4, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composerStartRestartGroup, 54);
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        final Function2 composableLambda111 = composableLambdaRememberComposableLambda;
                        if (function4 == null) {
                            f = NavigationRailItemCompactSize;
                        } else {
                            f = NavigationRailItemSize;
                        }
                        MutableInteractionSource mutableInteractionSource114 = mutableInteractionSource3;
                        boolean z119 = z4;
                        Modifier modifierM1266size3ABfNKs111 = SizeKt.m1266size3ABfNKs(SelectableKt.m1533selectableO2vRcR0(modifier2, z, mutableInteractionSource114, RippleKt.m2523rippleH2RKhps$default(false, 0.0f, jM2342getPrimary0d7_KjU, 2, null), z119, Role.m8825boximpl(Role.INSTANCE.m8839getTabo7Vup1c()), function0), f);
                        Alignment center111 = Alignment.INSTANCE.getCenter();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy111 = BoxKt.maybeCachedBoxMeasurePolicy(center111, false);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                        CompositionLocalMap currentCompositionLocalMap111 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier111 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1266size3ABfNKs111);
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
                        Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy111, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap111, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (!composerM6062constructorimpl.getInserting()) {
                            composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        } else {
                            composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        }
                        Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier111, ComposeUiNode.INSTANCE.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance111 = BoxScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 415492902, "C240@10971L303,240@10890L384:NavigationRail.kt#jmzs0o");
                        int i2111 = i14 >> 24;
                        m2476NavigationRailTransitionKlgxPg(jM2342getPrimary0d7_KjU, jM6813copywmQWz5c$default, z, ComposableLambdaKt.rememberComposableLambda(317431928, true, new Function3() { // from class: androidx.compose.material.NavigationRailKt$$ExternalSyntheticLambda5
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return NavigationRailKt.NavigationRailItem_0S3VyRs$lambda$1$0(z5, function2, composableLambda111, ((Float) obj).floatValue(), (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, (i2111 & 112) | (i2111 & 14) | 3072 | ((i14 << 6) & 896));
                        composer2 = composerStartRestartGroup;
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        composer2.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        mutableInteractionSource2 = mutableInteractionSource114;
                        function5 = function4;
                        z7 = z119;
                        j4 = jM6813copywmQWz5c$default;
                        j3 = jM2342getPrimary0d7_KjU;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        mutableInteractionSource2 = mutableInteractionSource;
                        z7 = z4;
                        function5 = function4;
                        j3 = j;
                        j4 = j2;
                    }
                    modifier3 = modifier2;
                    z8 = z5;
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.NavigationRailKt$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return NavigationRailKt.NavigationRailItem_0S3VyRs$lambda$2(z, function0, function2, modifier3, z7, function5, z8, mutableInteractionSource2, j3, j4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= 12582912;
                if ((i & 100663296) == 0) {
                    int i1111110 = i3;
                    if ((i2 & 256) == 0) {
                        i16 = 33554432;
                    } else {
                        i16 = 33554432;
                    }
                    i12 = i1111110 | i16;
                } else {
                    i12 = i3;
                }
                if ((i & 805306368) == 0) {
                    int i1111111 = i12;
                    if ((i2 & 512) == 0) {
                        i15 = 268435456;
                    } else {
                        i15 = 268435456;
                    }
                    i12 = i1111111 | i15;
                }
                i13 = i12;
                if ((i13 & 306783379) != 306783378) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z6, i13 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "209@9518L6,210@9588L7,210@9622L6");
                    composableLambdaRememberComposableLambda = null;
                    if ((i & 1) != 0) {
                        if (i17 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            z4 = true;
                        }
                        if (i6 != 0) {
                            function4 = null;
                        }
                        if (i8 != 0) {
                            z5 = true;
                        }
                        if (i10 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        if ((i2 & 256) != 0) {
                            jM2342getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2342getPrimary0d7_KjU();
                            i14 = i13 & (-234881025);
                        } else {
                            jM2342getPrimary0d7_KjU = j;
                            i14 = i13;
                        }
                        if ((i2 & 512) != 0) {
                            ProvidableCompositionLocal<Color> localContentColor11112 = ContentColorKt.getLocalContentColor();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                            Object objConsume11112 = composerStartRestartGroup.consume(localContentColor11112);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            jM6813copywmQWz5c$default = Color.m6813copywmQWz5c$default(((Color) objConsume11112).m6824unboximpl(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                            i14 &= -1879048193;
                        } else {
                            jM6813copywmQWz5c$default = j2;
                        }
                    } else {
                        if (i17 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            z4 = true;
                        }
                        if (i6 != 0) {
                            function4 = null;
                        }
                        if (i8 != 0) {
                            z5 = true;
                        }
                        if (i10 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        if ((i2 & 256) != 0) {
                            jM2342getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2342getPrimary0d7_KjU();
                            i14 = i13 & (-234881025);
                        } else {
                            jM2342getPrimary0d7_KjU = j;
                            i14 = i13;
                        }
                        if ((i2 & 512) != 0) {
                            ProvidableCompositionLocal<Color> localContentColor11113 = ContentColorKt.getLocalContentColor();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                            Object objConsume11113 = composerStartRestartGroup.consume(localContentColor11113);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            jM6813copywmQWz5c$default = Color.m6813copywmQWz5c$default(((Color) objConsume11113).m6824unboximpl(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                            i14 &= -1879048193;
                        } else {
                            jM6813copywmQWz5c$default = j2;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(83562179, i14, -1, "androidx.compose.material.NavigationRailItem (NavigationRail.kt:211)");
                    }
                    if (function4 == null) {
                        composerStartRestartGroup.startReplaceGroup(-1679616946);
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-1679616945);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "*214@9729L168");
                        composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-674640273, true, new Function2() { // from class: androidx.compose.material.NavigationRailKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return NavigationRailKt.NavigationRailItem_0S3VyRs$lambda$0$0(function4, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    final Function2 composableLambda112 = composableLambdaRememberComposableLambda;
                    if (function4 == null) {
                        f = NavigationRailItemCompactSize;
                    } else {
                        f = NavigationRailItemSize;
                    }
                    MutableInteractionSource mutableInteractionSource115 = mutableInteractionSource3;
                    boolean z1110 = z4;
                    Modifier modifierM1266size3ABfNKs112 = SizeKt.m1266size3ABfNKs(SelectableKt.m1533selectableO2vRcR0(modifier2, z, mutableInteractionSource115, RippleKt.m2523rippleH2RKhps$default(false, 0.0f, jM2342getPrimary0d7_KjU, 2, null), z1110, Role.m8825boximpl(Role.INSTANCE.m8839getTabo7Vup1c()), function0), f);
                    Alignment center112 = Alignment.INSTANCE.getCenter();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy112 = BoxKt.maybeCachedBoxMeasurePolicy(center112, false);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap112 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier112 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1266size3ABfNKs112);
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
                    Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy112, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
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
                    BoxScopeInstance boxScopeInstance112 = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 415492902, "C240@10971L303,240@10890L384:NavigationRail.kt#jmzs0o");
                    int i2112 = i14 >> 24;
                    m2476NavigationRailTransitionKlgxPg(jM2342getPrimary0d7_KjU, jM6813copywmQWz5c$default, z, ComposableLambdaKt.rememberComposableLambda(317431928, true, new Function3() { // from class: androidx.compose.material.NavigationRailKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return NavigationRailKt.NavigationRailItem_0S3VyRs$lambda$1$0(z5, function2, composableLambda112, ((Float) obj).floatValue(), (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, (i2112 & 112) | (i2112 & 14) | 3072 | ((i14 << 6) & 896));
                    composer2 = composerStartRestartGroup;
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    mutableInteractionSource2 = mutableInteractionSource115;
                    function5 = function4;
                    z7 = z1110;
                    j4 = jM6813copywmQWz5c$default;
                    j3 = jM2342getPrimary0d7_KjU;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    mutableInteractionSource2 = mutableInteractionSource;
                    z7 = z4;
                    function5 = function4;
                    j3 = j;
                    j4 = j2;
                }
                modifier3 = modifier2;
                z8 = z5;
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.NavigationRailKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return NavigationRailKt.NavigationRailItem_0S3VyRs$lambda$2(z, function0, function2, modifier3, z7, function5, z8, mutableInteractionSource2, j3, j4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 1572864;
            z5 = z3;
            i10 = i2 & 128;
            if (i10 != 0) {
                if ((i & 12582912) == 0) {
                    if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                        i11 = 8388608;
                    } else {
                        i11 = 4194304;
                    }
                    i3 |= i11;
                }
                if ((i & 100663296) == 0) {
                    int i1111112 = i3;
                    if ((i2 & 256) == 0) {
                        i16 = 33554432;
                    } else {
                        i16 = 33554432;
                    }
                    i12 = i1111112 | i16;
                } else {
                    i12 = i3;
                }
                if ((i & 805306368) == 0) {
                    int i1111113 = i12;
                    if ((i2 & 512) == 0) {
                        i15 = 268435456;
                    } else {
                        i15 = 268435456;
                    }
                    i12 = i1111113 | i15;
                }
                i13 = i12;
                if ((i13 & 306783379) != 306783378) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z6, i13 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "209@9518L6,210@9588L7,210@9622L6");
                    composableLambdaRememberComposableLambda = null;
                    if ((i & 1) != 0) {
                        if (i17 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            z4 = true;
                        }
                        if (i6 != 0) {
                            function4 = null;
                        }
                        if (i8 != 0) {
                            z5 = true;
                        }
                        if (i10 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        if ((i2 & 256) != 0) {
                            jM2342getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2342getPrimary0d7_KjU();
                            i14 = i13 & (-234881025);
                        } else {
                            jM2342getPrimary0d7_KjU = j;
                            i14 = i13;
                        }
                        if ((i2 & 512) != 0) {
                            ProvidableCompositionLocal<Color> localContentColor11114 = ContentColorKt.getLocalContentColor();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                            Object objConsume11114 = composerStartRestartGroup.consume(localContentColor11114);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            jM6813copywmQWz5c$default = Color.m6813copywmQWz5c$default(((Color) objConsume11114).m6824unboximpl(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                            i14 &= -1879048193;
                        } else {
                            jM6813copywmQWz5c$default = j2;
                        }
                    } else {
                        if (i17 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            z4 = true;
                        }
                        if (i6 != 0) {
                            function4 = null;
                        }
                        if (i8 != 0) {
                            z5 = true;
                        }
                        if (i10 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        if ((i2 & 256) != 0) {
                            jM2342getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2342getPrimary0d7_KjU();
                            i14 = i13 & (-234881025);
                        } else {
                            jM2342getPrimary0d7_KjU = j;
                            i14 = i13;
                        }
                        if ((i2 & 512) != 0) {
                            ProvidableCompositionLocal<Color> localContentColor11115 = ContentColorKt.getLocalContentColor();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                            Object objConsume11115 = composerStartRestartGroup.consume(localContentColor11115);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            jM6813copywmQWz5c$default = Color.m6813copywmQWz5c$default(((Color) objConsume11115).m6824unboximpl(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                            i14 &= -1879048193;
                        } else {
                            jM6813copywmQWz5c$default = j2;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(83562179, i14, -1, "androidx.compose.material.NavigationRailItem (NavigationRail.kt:211)");
                    }
                    if (function4 == null) {
                        composerStartRestartGroup.startReplaceGroup(-1679616946);
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-1679616945);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "*214@9729L168");
                        composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-674640273, true, new Function2() { // from class: androidx.compose.material.NavigationRailKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return NavigationRailKt.NavigationRailItem_0S3VyRs$lambda$0$0(function4, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    final Function2 composableLambda113 = composableLambdaRememberComposableLambda;
                    if (function4 == null) {
                        f = NavigationRailItemCompactSize;
                    } else {
                        f = NavigationRailItemSize;
                    }
                    MutableInteractionSource mutableInteractionSource116 = mutableInteractionSource3;
                    boolean z1111 = z4;
                    Modifier modifierM1266size3ABfNKs113 = SizeKt.m1266size3ABfNKs(SelectableKt.m1533selectableO2vRcR0(modifier2, z, mutableInteractionSource116, RippleKt.m2523rippleH2RKhps$default(false, 0.0f, jM2342getPrimary0d7_KjU, 2, null), z1111, Role.m8825boximpl(Role.INSTANCE.m8839getTabo7Vup1c()), function0), f);
                    Alignment center113 = Alignment.INSTANCE.getCenter();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy113 = BoxKt.maybeCachedBoxMeasurePolicy(center113, false);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap113 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier113 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1266size3ABfNKs113);
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
                    Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy113, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap113, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (!composerM6062constructorimpl.getInserting()) {
                        composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    } else {
                        composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier113, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance113 = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 415492902, "C240@10971L303,240@10890L384:NavigationRail.kt#jmzs0o");
                    int i2113 = i14 >> 24;
                    m2476NavigationRailTransitionKlgxPg(jM2342getPrimary0d7_KjU, jM6813copywmQWz5c$default, z, ComposableLambdaKt.rememberComposableLambda(317431928, true, new Function3() { // from class: androidx.compose.material.NavigationRailKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return NavigationRailKt.NavigationRailItem_0S3VyRs$lambda$1$0(z5, function2, composableLambda113, ((Float) obj).floatValue(), (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, (i2113 & 112) | (i2113 & 14) | 3072 | ((i14 << 6) & 896));
                    composer2 = composerStartRestartGroup;
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    mutableInteractionSource2 = mutableInteractionSource116;
                    function5 = function4;
                    z7 = z1111;
                    j4 = jM6813copywmQWz5c$default;
                    j3 = jM2342getPrimary0d7_KjU;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    mutableInteractionSource2 = mutableInteractionSource;
                    z7 = z4;
                    function5 = function4;
                    j3 = j;
                    j4 = j2;
                }
                modifier3 = modifier2;
                z8 = z5;
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.NavigationRailKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return NavigationRailKt.NavigationRailItem_0S3VyRs$lambda$2(z, function0, function2, modifier3, z7, function5, z8, mutableInteractionSource2, j3, j4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 12582912;
            if ((i & 100663296) == 0) {
                int i1111114 = i3;
                if ((i2 & 256) == 0) {
                    i16 = 33554432;
                } else {
                    i16 = 33554432;
                }
                i12 = i1111114 | i16;
            } else {
                i12 = i3;
            }
            if ((i & 805306368) == 0) {
                int i1111115 = i12;
                if ((i2 & 512) == 0) {
                    i15 = 268435456;
                } else {
                    i15 = 268435456;
                }
                i12 = i1111115 | i15;
            }
            i13 = i12;
            if ((i13 & 306783379) != 306783378) {
                z6 = true;
            } else {
                z6 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z6, i13 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "209@9518L6,210@9588L7,210@9622L6");
                composableLambdaRememberComposableLambda = null;
                if ((i & 1) != 0) {
                    if (i17 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        z4 = true;
                    }
                    if (i6 != 0) {
                        function4 = null;
                    }
                    if (i8 != 0) {
                        z5 = true;
                    }
                    if (i10 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    if ((i2 & 256) != 0) {
                        jM2342getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2342getPrimary0d7_KjU();
                        i14 = i13 & (-234881025);
                    } else {
                        jM2342getPrimary0d7_KjU = j;
                        i14 = i13;
                    }
                    if ((i2 & 512) != 0) {
                        ProvidableCompositionLocal<Color> localContentColor11116 = ContentColorKt.getLocalContentColor();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object objConsume11116 = composerStartRestartGroup.consume(localContentColor11116);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        jM6813copywmQWz5c$default = Color.m6813copywmQWz5c$default(((Color) objConsume11116).m6824unboximpl(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                        i14 &= -1879048193;
                    } else {
                        jM6813copywmQWz5c$default = j2;
                    }
                } else {
                    if (i17 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        z4 = true;
                    }
                    if (i6 != 0) {
                        function4 = null;
                    }
                    if (i8 != 0) {
                        z5 = true;
                    }
                    if (i10 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    if ((i2 & 256) != 0) {
                        jM2342getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2342getPrimary0d7_KjU();
                        i14 = i13 & (-234881025);
                    } else {
                        jM2342getPrimary0d7_KjU = j;
                        i14 = i13;
                    }
                    if ((i2 & 512) != 0) {
                        ProvidableCompositionLocal<Color> localContentColor11117 = ContentColorKt.getLocalContentColor();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object objConsume11117 = composerStartRestartGroup.consume(localContentColor11117);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        jM6813copywmQWz5c$default = Color.m6813copywmQWz5c$default(((Color) objConsume11117).m6824unboximpl(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                        i14 &= -1879048193;
                    } else {
                        jM6813copywmQWz5c$default = j2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(83562179, i14, -1, "androidx.compose.material.NavigationRailItem (NavigationRail.kt:211)");
                }
                if (function4 == null) {
                    composerStartRestartGroup.startReplaceGroup(-1679616946);
                } else {
                    composerStartRestartGroup.startReplaceGroup(-1679616945);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "*214@9729L168");
                    composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-674640273, true, new Function2() { // from class: androidx.compose.material.NavigationRailKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return NavigationRailKt.NavigationRailItem_0S3VyRs$lambda$0$0(function4, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54);
                }
                composerStartRestartGroup.endReplaceGroup();
                final Function2 composableLambda114 = composableLambdaRememberComposableLambda;
                if (function4 == null) {
                    f = NavigationRailItemCompactSize;
                } else {
                    f = NavigationRailItemSize;
                }
                MutableInteractionSource mutableInteractionSource117 = mutableInteractionSource3;
                boolean z1112 = z4;
                Modifier modifierM1266size3ABfNKs114 = SizeKt.m1266size3ABfNKs(SelectableKt.m1533selectableO2vRcR0(modifier2, z, mutableInteractionSource117, RippleKt.m2523rippleH2RKhps$default(false, 0.0f, jM2342getPrimary0d7_KjU, 2, null), z1112, Role.m8825boximpl(Role.INSTANCE.m8839getTabo7Vup1c()), function0), f);
                Alignment center114 = Alignment.INSTANCE.getCenter();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy114 = BoxKt.maybeCachedBoxMeasurePolicy(center114, false);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap114 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier114 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1266size3ABfNKs114);
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
                Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy114, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap114, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!composerM6062constructorimpl.getInserting()) {
                    composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                } else {
                    composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier114, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance114 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 415492902, "C240@10971L303,240@10890L384:NavigationRail.kt#jmzs0o");
                int i2114 = i14 >> 24;
                m2476NavigationRailTransitionKlgxPg(jM2342getPrimary0d7_KjU, jM6813copywmQWz5c$default, z, ComposableLambdaKt.rememberComposableLambda(317431928, true, new Function3() { // from class: androidx.compose.material.NavigationRailKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return NavigationRailKt.NavigationRailItem_0S3VyRs$lambda$1$0(z5, function2, composableLambda114, ((Float) obj).floatValue(), (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, (i2114 & 112) | (i2114 & 14) | 3072 | ((i14 << 6) & 896));
                composer2 = composerStartRestartGroup;
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                mutableInteractionSource2 = mutableInteractionSource117;
                function5 = function4;
                z7 = z1112;
                j4 = jM6813copywmQWz5c$default;
                j3 = jM2342getPrimary0d7_KjU;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                mutableInteractionSource2 = mutableInteractionSource;
                z7 = z4;
                function5 = function4;
                j3 = j;
                j4 = j2;
            }
            modifier3 = modifier2;
            z8 = z5;
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.NavigationRailKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return NavigationRailKt.NavigationRailItem_0S3VyRs$lambda$2(z, function0, function2, modifier3, z7, function5, z8, mutableInteractionSource2, j3, j4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
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
                if ((1572864 & i) == 0) {
                    z5 = z3;
                    if (composerStartRestartGroup.changed(z5)) {
                        i9 = 1048576;
                    } else {
                        i9 = 524288;
                    }
                    i3 |= i9;
                }
                i10 = i2 & 128;
                if (i10 != 0) {
                    if ((i & 12582912) == 0) {
                        if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                            i11 = 8388608;
                        } else {
                            i11 = 4194304;
                        }
                        i3 |= i11;
                    }
                    if ((i & 100663296) == 0) {
                        int i1111116 = i3;
                        if ((i2 & 256) == 0) {
                            i16 = 33554432;
                        } else {
                            i16 = 33554432;
                        }
                        i12 = i1111116 | i16;
                    } else {
                        i12 = i3;
                    }
                    if ((i & 805306368) == 0) {
                        int i1111117 = i12;
                        if ((i2 & 512) == 0) {
                            i15 = 268435456;
                        } else {
                            i15 = 268435456;
                        }
                        i12 = i1111117 | i15;
                    }
                    i13 = i12;
                    if ((i13 & 306783379) != 306783378) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z6, i13 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "209@9518L6,210@9588L7,210@9622L6");
                        composableLambdaRememberComposableLambda = null;
                        if ((i & 1) != 0) {
                            if (i17 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                z4 = true;
                            }
                            if (i6 != 0) {
                                function4 = null;
                            }
                            if (i8 != 0) {
                                z5 = true;
                            }
                            if (i10 != 0) {
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            if ((i2 & 256) != 0) {
                                jM2342getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2342getPrimary0d7_KjU();
                                i14 = i13 & (-234881025);
                            } else {
                                jM2342getPrimary0d7_KjU = j;
                                i14 = i13;
                            }
                            if ((i2 & 512) != 0) {
                                ProvidableCompositionLocal<Color> localContentColor11118 = ContentColorKt.getLocalContentColor();
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                Object objConsume11118 = composerStartRestartGroup.consume(localContentColor11118);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                jM6813copywmQWz5c$default = Color.m6813copywmQWz5c$default(((Color) objConsume11118).m6824unboximpl(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                                i14 &= -1879048193;
                            } else {
                                jM6813copywmQWz5c$default = j2;
                            }
                        } else {
                            if (i17 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                z4 = true;
                            }
                            if (i6 != 0) {
                                function4 = null;
                            }
                            if (i8 != 0) {
                                z5 = true;
                            }
                            if (i10 != 0) {
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            if ((i2 & 256) != 0) {
                                jM2342getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2342getPrimary0d7_KjU();
                                i14 = i13 & (-234881025);
                            } else {
                                jM2342getPrimary0d7_KjU = j;
                                i14 = i13;
                            }
                            if ((i2 & 512) != 0) {
                                ProvidableCompositionLocal<Color> localContentColor11119 = ContentColorKt.getLocalContentColor();
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                Object objConsume11119 = composerStartRestartGroup.consume(localContentColor11119);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                jM6813copywmQWz5c$default = Color.m6813copywmQWz5c$default(((Color) objConsume11119).m6824unboximpl(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                                i14 &= -1879048193;
                            } else {
                                jM6813copywmQWz5c$default = j2;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(83562179, i14, -1, "androidx.compose.material.NavigationRailItem (NavigationRail.kt:211)");
                        }
                        if (function4 == null) {
                            composerStartRestartGroup.startReplaceGroup(-1679616946);
                        } else {
                            composerStartRestartGroup.startReplaceGroup(-1679616945);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "*214@9729L168");
                            composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-674640273, true, new Function2() { // from class: androidx.compose.material.NavigationRailKt$$ExternalSyntheticLambda4
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return NavigationRailKt.NavigationRailItem_0S3VyRs$lambda$0$0(function4, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composerStartRestartGroup, 54);
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        final Function2 composableLambda115 = composableLambdaRememberComposableLambda;
                        if (function4 == null) {
                            f = NavigationRailItemCompactSize;
                        } else {
                            f = NavigationRailItemSize;
                        }
                        MutableInteractionSource mutableInteractionSource118 = mutableInteractionSource3;
                        boolean z1113 = z4;
                        Modifier modifierM1266size3ABfNKs115 = SizeKt.m1266size3ABfNKs(SelectableKt.m1533selectableO2vRcR0(modifier2, z, mutableInteractionSource118, RippleKt.m2523rippleH2RKhps$default(false, 0.0f, jM2342getPrimary0d7_KjU, 2, null), z1113, Role.m8825boximpl(Role.INSTANCE.m8839getTabo7Vup1c()), function0), f);
                        Alignment center115 = Alignment.INSTANCE.getCenter();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy115 = BoxKt.maybeCachedBoxMeasurePolicy(center115, false);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                        CompositionLocalMap currentCompositionLocalMap115 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier115 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1266size3ABfNKs115);
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
                        Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy115, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
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
                        BoxScopeInstance boxScopeInstance115 = BoxScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 415492902, "C240@10971L303,240@10890L384:NavigationRail.kt#jmzs0o");
                        int i2115 = i14 >> 24;
                        m2476NavigationRailTransitionKlgxPg(jM2342getPrimary0d7_KjU, jM6813copywmQWz5c$default, z, ComposableLambdaKt.rememberComposableLambda(317431928, true, new Function3() { // from class: androidx.compose.material.NavigationRailKt$$ExternalSyntheticLambda5
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return NavigationRailKt.NavigationRailItem_0S3VyRs$lambda$1$0(z5, function2, composableLambda115, ((Float) obj).floatValue(), (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, (i2115 & 112) | (i2115 & 14) | 3072 | ((i14 << 6) & 896));
                        composer2 = composerStartRestartGroup;
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        composer2.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        mutableInteractionSource2 = mutableInteractionSource118;
                        function5 = function4;
                        z7 = z1113;
                        j4 = jM6813copywmQWz5c$default;
                        j3 = jM2342getPrimary0d7_KjU;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        mutableInteractionSource2 = mutableInteractionSource;
                        z7 = z4;
                        function5 = function4;
                        j3 = j;
                        j4 = j2;
                    }
                    modifier3 = modifier2;
                    z8 = z5;
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.NavigationRailKt$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return NavigationRailKt.NavigationRailItem_0S3VyRs$lambda$2(z, function0, function2, modifier3, z7, function5, z8, mutableInteractionSource2, j3, j4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= 12582912;
                if ((i & 100663296) == 0) {
                    int i1111118 = i3;
                    if ((i2 & 256) == 0) {
                        i16 = 33554432;
                    } else {
                        i16 = 33554432;
                    }
                    i12 = i1111118 | i16;
                } else {
                    i12 = i3;
                }
                if ((i & 805306368) == 0) {
                    int i1111119 = i12;
                    if ((i2 & 512) == 0) {
                        i15 = 268435456;
                    } else {
                        i15 = 268435456;
                    }
                    i12 = i1111119 | i15;
                }
                i13 = i12;
                if ((i13 & 306783379) != 306783378) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z6, i13 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "209@9518L6,210@9588L7,210@9622L6");
                    composableLambdaRememberComposableLambda = null;
                    if ((i & 1) != 0) {
                        if (i17 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            z4 = true;
                        }
                        if (i6 != 0) {
                            function4 = null;
                        }
                        if (i8 != 0) {
                            z5 = true;
                        }
                        if (i10 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        if ((i2 & 256) != 0) {
                            jM2342getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2342getPrimary0d7_KjU();
                            i14 = i13 & (-234881025);
                        } else {
                            jM2342getPrimary0d7_KjU = j;
                            i14 = i13;
                        }
                        if ((i2 & 512) != 0) {
                            ProvidableCompositionLocal<Color> localContentColor111110 = ContentColorKt.getLocalContentColor();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                            Object objConsume111110 = composerStartRestartGroup.consume(localContentColor111110);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            jM6813copywmQWz5c$default = Color.m6813copywmQWz5c$default(((Color) objConsume111110).m6824unboximpl(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                            i14 &= -1879048193;
                        } else {
                            jM6813copywmQWz5c$default = j2;
                        }
                    } else {
                        if (i17 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            z4 = true;
                        }
                        if (i6 != 0) {
                            function4 = null;
                        }
                        if (i8 != 0) {
                            z5 = true;
                        }
                        if (i10 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        if ((i2 & 256) != 0) {
                            jM2342getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2342getPrimary0d7_KjU();
                            i14 = i13 & (-234881025);
                        } else {
                            jM2342getPrimary0d7_KjU = j;
                            i14 = i13;
                        }
                        if ((i2 & 512) != 0) {
                            ProvidableCompositionLocal<Color> localContentColor111111 = ContentColorKt.getLocalContentColor();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                            Object objConsume111111 = composerStartRestartGroup.consume(localContentColor111111);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            jM6813copywmQWz5c$default = Color.m6813copywmQWz5c$default(((Color) objConsume111111).m6824unboximpl(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                            i14 &= -1879048193;
                        } else {
                            jM6813copywmQWz5c$default = j2;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(83562179, i14, -1, "androidx.compose.material.NavigationRailItem (NavigationRail.kt:211)");
                    }
                    if (function4 == null) {
                        composerStartRestartGroup.startReplaceGroup(-1679616946);
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-1679616945);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "*214@9729L168");
                        composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-674640273, true, new Function2() { // from class: androidx.compose.material.NavigationRailKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return NavigationRailKt.NavigationRailItem_0S3VyRs$lambda$0$0(function4, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    final Function2 composableLambda116 = composableLambdaRememberComposableLambda;
                    if (function4 == null) {
                        f = NavigationRailItemCompactSize;
                    } else {
                        f = NavigationRailItemSize;
                    }
                    MutableInteractionSource mutableInteractionSource119 = mutableInteractionSource3;
                    boolean z1114 = z4;
                    Modifier modifierM1266size3ABfNKs116 = SizeKt.m1266size3ABfNKs(SelectableKt.m1533selectableO2vRcR0(modifier2, z, mutableInteractionSource119, RippleKt.m2523rippleH2RKhps$default(false, 0.0f, jM2342getPrimary0d7_KjU, 2, null), z1114, Role.m8825boximpl(Role.INSTANCE.m8839getTabo7Vup1c()), function0), f);
                    Alignment center116 = Alignment.INSTANCE.getCenter();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy116 = BoxKt.maybeCachedBoxMeasurePolicy(center116, false);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap116 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier116 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1266size3ABfNKs116);
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
                    Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy116, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap116, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (!composerM6062constructorimpl.getInserting()) {
                        composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    } else {
                        composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier116, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance116 = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 415492902, "C240@10971L303,240@10890L384:NavigationRail.kt#jmzs0o");
                    int i2116 = i14 >> 24;
                    m2476NavigationRailTransitionKlgxPg(jM2342getPrimary0d7_KjU, jM6813copywmQWz5c$default, z, ComposableLambdaKt.rememberComposableLambda(317431928, true, new Function3() { // from class: androidx.compose.material.NavigationRailKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return NavigationRailKt.NavigationRailItem_0S3VyRs$lambda$1$0(z5, function2, composableLambda116, ((Float) obj).floatValue(), (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, (i2116 & 112) | (i2116 & 14) | 3072 | ((i14 << 6) & 896));
                    composer2 = composerStartRestartGroup;
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    mutableInteractionSource2 = mutableInteractionSource119;
                    function5 = function4;
                    z7 = z1114;
                    j4 = jM6813copywmQWz5c$default;
                    j3 = jM2342getPrimary0d7_KjU;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    mutableInteractionSource2 = mutableInteractionSource;
                    z7 = z4;
                    function5 = function4;
                    j3 = j;
                    j4 = j2;
                }
                modifier3 = modifier2;
                z8 = z5;
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.NavigationRailKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return NavigationRailKt.NavigationRailItem_0S3VyRs$lambda$2(z, function0, function2, modifier3, z7, function5, z8, mutableInteractionSource2, j3, j4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 1572864;
            z5 = z3;
            i10 = i2 & 128;
            if (i10 != 0) {
                if ((i & 12582912) == 0) {
                    if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                        i11 = 8388608;
                    } else {
                        i11 = 4194304;
                    }
                    i3 |= i11;
                }
                if ((i & 100663296) == 0) {
                    int i11111110 = i3;
                    if ((i2 & 256) == 0) {
                        i16 = 33554432;
                    } else {
                        i16 = 33554432;
                    }
                    i12 = i11111110 | i16;
                } else {
                    i12 = i3;
                }
                if ((i & 805306368) == 0) {
                    int i11111111 = i12;
                    if ((i2 & 512) == 0) {
                        i15 = 268435456;
                    } else {
                        i15 = 268435456;
                    }
                    i12 = i11111111 | i15;
                }
                i13 = i12;
                if ((i13 & 306783379) != 306783378) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z6, i13 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "209@9518L6,210@9588L7,210@9622L6");
                    composableLambdaRememberComposableLambda = null;
                    if ((i & 1) != 0) {
                        if (i17 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            z4 = true;
                        }
                        if (i6 != 0) {
                            function4 = null;
                        }
                        if (i8 != 0) {
                            z5 = true;
                        }
                        if (i10 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        if ((i2 & 256) != 0) {
                            jM2342getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2342getPrimary0d7_KjU();
                            i14 = i13 & (-234881025);
                        } else {
                            jM2342getPrimary0d7_KjU = j;
                            i14 = i13;
                        }
                        if ((i2 & 512) != 0) {
                            ProvidableCompositionLocal<Color> localContentColor111112 = ContentColorKt.getLocalContentColor();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                            Object objConsume111112 = composerStartRestartGroup.consume(localContentColor111112);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            jM6813copywmQWz5c$default = Color.m6813copywmQWz5c$default(((Color) objConsume111112).m6824unboximpl(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                            i14 &= -1879048193;
                        } else {
                            jM6813copywmQWz5c$default = j2;
                        }
                    } else {
                        if (i17 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            z4 = true;
                        }
                        if (i6 != 0) {
                            function4 = null;
                        }
                        if (i8 != 0) {
                            z5 = true;
                        }
                        if (i10 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        if ((i2 & 256) != 0) {
                            jM2342getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2342getPrimary0d7_KjU();
                            i14 = i13 & (-234881025);
                        } else {
                            jM2342getPrimary0d7_KjU = j;
                            i14 = i13;
                        }
                        if ((i2 & 512) != 0) {
                            ProvidableCompositionLocal<Color> localContentColor111113 = ContentColorKt.getLocalContentColor();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                            Object objConsume111113 = composerStartRestartGroup.consume(localContentColor111113);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            jM6813copywmQWz5c$default = Color.m6813copywmQWz5c$default(((Color) objConsume111113).m6824unboximpl(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                            i14 &= -1879048193;
                        } else {
                            jM6813copywmQWz5c$default = j2;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(83562179, i14, -1, "androidx.compose.material.NavigationRailItem (NavigationRail.kt:211)");
                    }
                    if (function4 == null) {
                        composerStartRestartGroup.startReplaceGroup(-1679616946);
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-1679616945);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "*214@9729L168");
                        composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-674640273, true, new Function2() { // from class: androidx.compose.material.NavigationRailKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return NavigationRailKt.NavigationRailItem_0S3VyRs$lambda$0$0(function4, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    final Function2 composableLambda117 = composableLambdaRememberComposableLambda;
                    if (function4 == null) {
                        f = NavigationRailItemCompactSize;
                    } else {
                        f = NavigationRailItemSize;
                    }
                    MutableInteractionSource mutableInteractionSource1110 = mutableInteractionSource3;
                    boolean z1115 = z4;
                    Modifier modifierM1266size3ABfNKs117 = SizeKt.m1266size3ABfNKs(SelectableKt.m1533selectableO2vRcR0(modifier2, z, mutableInteractionSource1110, RippleKt.m2523rippleH2RKhps$default(false, 0.0f, jM2342getPrimary0d7_KjU, 2, null), z1115, Role.m8825boximpl(Role.INSTANCE.m8839getTabo7Vup1c()), function0), f);
                    Alignment center117 = Alignment.INSTANCE.getCenter();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy117 = BoxKt.maybeCachedBoxMeasurePolicy(center117, false);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap117 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier117 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1266size3ABfNKs117);
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
                    Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy117, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap117, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (!composerM6062constructorimpl.getInserting()) {
                        composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    } else {
                        composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier117, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance117 = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 415492902, "C240@10971L303,240@10890L384:NavigationRail.kt#jmzs0o");
                    int i2117 = i14 >> 24;
                    m2476NavigationRailTransitionKlgxPg(jM2342getPrimary0d7_KjU, jM6813copywmQWz5c$default, z, ComposableLambdaKt.rememberComposableLambda(317431928, true, new Function3() { // from class: androidx.compose.material.NavigationRailKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return NavigationRailKt.NavigationRailItem_0S3VyRs$lambda$1$0(z5, function2, composableLambda117, ((Float) obj).floatValue(), (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, (i2117 & 112) | (i2117 & 14) | 3072 | ((i14 << 6) & 896));
                    composer2 = composerStartRestartGroup;
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    mutableInteractionSource2 = mutableInteractionSource1110;
                    function5 = function4;
                    z7 = z1115;
                    j4 = jM6813copywmQWz5c$default;
                    j3 = jM2342getPrimary0d7_KjU;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    mutableInteractionSource2 = mutableInteractionSource;
                    z7 = z4;
                    function5 = function4;
                    j3 = j;
                    j4 = j2;
                }
                modifier3 = modifier2;
                z8 = z5;
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.NavigationRailKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return NavigationRailKt.NavigationRailItem_0S3VyRs$lambda$2(z, function0, function2, modifier3, z7, function5, z8, mutableInteractionSource2, j3, j4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 12582912;
            if ((i & 100663296) == 0) {
                int i11111112 = i3;
                if ((i2 & 256) == 0) {
                    i16 = 33554432;
                } else {
                    i16 = 33554432;
                }
                i12 = i11111112 | i16;
            } else {
                i12 = i3;
            }
            if ((i & 805306368) == 0) {
                int i11111113 = i12;
                if ((i2 & 512) == 0) {
                    i15 = 268435456;
                } else {
                    i15 = 268435456;
                }
                i12 = i11111113 | i15;
            }
            i13 = i12;
            if ((i13 & 306783379) != 306783378) {
                z6 = true;
            } else {
                z6 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z6, i13 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "209@9518L6,210@9588L7,210@9622L6");
                composableLambdaRememberComposableLambda = null;
                if ((i & 1) != 0) {
                    if (i17 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        z4 = true;
                    }
                    if (i6 != 0) {
                        function4 = null;
                    }
                    if (i8 != 0) {
                        z5 = true;
                    }
                    if (i10 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    if ((i2 & 256) != 0) {
                        jM2342getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2342getPrimary0d7_KjU();
                        i14 = i13 & (-234881025);
                    } else {
                        jM2342getPrimary0d7_KjU = j;
                        i14 = i13;
                    }
                    if ((i2 & 512) != 0) {
                        ProvidableCompositionLocal<Color> localContentColor111114 = ContentColorKt.getLocalContentColor();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object objConsume111114 = composerStartRestartGroup.consume(localContentColor111114);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        jM6813copywmQWz5c$default = Color.m6813copywmQWz5c$default(((Color) objConsume111114).m6824unboximpl(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                        i14 &= -1879048193;
                    } else {
                        jM6813copywmQWz5c$default = j2;
                    }
                } else {
                    if (i17 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        z4 = true;
                    }
                    if (i6 != 0) {
                        function4 = null;
                    }
                    if (i8 != 0) {
                        z5 = true;
                    }
                    if (i10 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    if ((i2 & 256) != 0) {
                        jM2342getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2342getPrimary0d7_KjU();
                        i14 = i13 & (-234881025);
                    } else {
                        jM2342getPrimary0d7_KjU = j;
                        i14 = i13;
                    }
                    if ((i2 & 512) != 0) {
                        ProvidableCompositionLocal<Color> localContentColor111115 = ContentColorKt.getLocalContentColor();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object objConsume111115 = composerStartRestartGroup.consume(localContentColor111115);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        jM6813copywmQWz5c$default = Color.m6813copywmQWz5c$default(((Color) objConsume111115).m6824unboximpl(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                        i14 &= -1879048193;
                    } else {
                        jM6813copywmQWz5c$default = j2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(83562179, i14, -1, "androidx.compose.material.NavigationRailItem (NavigationRail.kt:211)");
                }
                if (function4 == null) {
                    composerStartRestartGroup.startReplaceGroup(-1679616946);
                } else {
                    composerStartRestartGroup.startReplaceGroup(-1679616945);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "*214@9729L168");
                    composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-674640273, true, new Function2() { // from class: androidx.compose.material.NavigationRailKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return NavigationRailKt.NavigationRailItem_0S3VyRs$lambda$0$0(function4, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54);
                }
                composerStartRestartGroup.endReplaceGroup();
                final Function2 composableLambda118 = composableLambdaRememberComposableLambda;
                if (function4 == null) {
                    f = NavigationRailItemCompactSize;
                } else {
                    f = NavigationRailItemSize;
                }
                MutableInteractionSource mutableInteractionSource1111 = mutableInteractionSource3;
                boolean z1116 = z4;
                Modifier modifierM1266size3ABfNKs118 = SizeKt.m1266size3ABfNKs(SelectableKt.m1533selectableO2vRcR0(modifier2, z, mutableInteractionSource1111, RippleKt.m2523rippleH2RKhps$default(false, 0.0f, jM2342getPrimary0d7_KjU, 2, null), z1116, Role.m8825boximpl(Role.INSTANCE.m8839getTabo7Vup1c()), function0), f);
                Alignment center118 = Alignment.INSTANCE.getCenter();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy118 = BoxKt.maybeCachedBoxMeasurePolicy(center118, false);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap118 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier118 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1266size3ABfNKs118);
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
                Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy118, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap118, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!composerM6062constructorimpl.getInserting()) {
                    composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                } else {
                    composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier118, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance118 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 415492902, "C240@10971L303,240@10890L384:NavigationRail.kt#jmzs0o");
                int i2118 = i14 >> 24;
                m2476NavigationRailTransitionKlgxPg(jM2342getPrimary0d7_KjU, jM6813copywmQWz5c$default, z, ComposableLambdaKt.rememberComposableLambda(317431928, true, new Function3() { // from class: androidx.compose.material.NavigationRailKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return NavigationRailKt.NavigationRailItem_0S3VyRs$lambda$1$0(z5, function2, composableLambda118, ((Float) obj).floatValue(), (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, (i2118 & 112) | (i2118 & 14) | 3072 | ((i14 << 6) & 896));
                composer2 = composerStartRestartGroup;
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                mutableInteractionSource2 = mutableInteractionSource1111;
                function5 = function4;
                z7 = z1116;
                j4 = jM6813copywmQWz5c$default;
                j3 = jM2342getPrimary0d7_KjU;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                mutableInteractionSource2 = mutableInteractionSource;
                z7 = z4;
                function5 = function4;
                j3 = j;
                j4 = j2;
            }
            modifier3 = modifier2;
            z8 = z5;
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.NavigationRailKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return NavigationRailKt.NavigationRailItem_0S3VyRs$lambda$2(z, function0, function2, modifier3, z7, function5, z8, mutableInteractionSource2, j3, j4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        function4 = function3;
        i8 = i2 & 64;
        if (i8 != 0) {
            if ((1572864 & i) == 0) {
                z5 = z3;
                if (composerStartRestartGroup.changed(z5)) {
                    i9 = 1048576;
                } else {
                    i9 = 524288;
                }
                i3 |= i9;
            }
            i10 = i2 & 128;
            if (i10 != 0) {
                if ((i & 12582912) == 0) {
                    if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                        i11 = 8388608;
                    } else {
                        i11 = 4194304;
                    }
                    i3 |= i11;
                }
                if ((i & 100663296) == 0) {
                    int i11111114 = i3;
                    if ((i2 & 256) == 0) {
                        i16 = 33554432;
                    } else {
                        i16 = 33554432;
                    }
                    i12 = i11111114 | i16;
                } else {
                    i12 = i3;
                }
                if ((i & 805306368) == 0) {
                    int i11111115 = i12;
                    if ((i2 & 512) == 0) {
                        i15 = 268435456;
                    } else {
                        i15 = 268435456;
                    }
                    i12 = i11111115 | i15;
                }
                i13 = i12;
                if ((i13 & 306783379) != 306783378) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z6, i13 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "209@9518L6,210@9588L7,210@9622L6");
                    composableLambdaRememberComposableLambda = null;
                    if ((i & 1) != 0) {
                        if (i17 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            z4 = true;
                        }
                        if (i6 != 0) {
                            function4 = null;
                        }
                        if (i8 != 0) {
                            z5 = true;
                        }
                        if (i10 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        if ((i2 & 256) != 0) {
                            jM2342getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2342getPrimary0d7_KjU();
                            i14 = i13 & (-234881025);
                        } else {
                            jM2342getPrimary0d7_KjU = j;
                            i14 = i13;
                        }
                        if ((i2 & 512) != 0) {
                            ProvidableCompositionLocal<Color> localContentColor111116 = ContentColorKt.getLocalContentColor();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                            Object objConsume111116 = composerStartRestartGroup.consume(localContentColor111116);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            jM6813copywmQWz5c$default = Color.m6813copywmQWz5c$default(((Color) objConsume111116).m6824unboximpl(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                            i14 &= -1879048193;
                        } else {
                            jM6813copywmQWz5c$default = j2;
                        }
                    } else {
                        if (i17 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            z4 = true;
                        }
                        if (i6 != 0) {
                            function4 = null;
                        }
                        if (i8 != 0) {
                            z5 = true;
                        }
                        if (i10 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        if ((i2 & 256) != 0) {
                            jM2342getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2342getPrimary0d7_KjU();
                            i14 = i13 & (-234881025);
                        } else {
                            jM2342getPrimary0d7_KjU = j;
                            i14 = i13;
                        }
                        if ((i2 & 512) != 0) {
                            ProvidableCompositionLocal<Color> localContentColor111117 = ContentColorKt.getLocalContentColor();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                            Object objConsume111117 = composerStartRestartGroup.consume(localContentColor111117);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            jM6813copywmQWz5c$default = Color.m6813copywmQWz5c$default(((Color) objConsume111117).m6824unboximpl(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                            i14 &= -1879048193;
                        } else {
                            jM6813copywmQWz5c$default = j2;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(83562179, i14, -1, "androidx.compose.material.NavigationRailItem (NavigationRail.kt:211)");
                    }
                    if (function4 == null) {
                        composerStartRestartGroup.startReplaceGroup(-1679616946);
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-1679616945);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "*214@9729L168");
                        composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-674640273, true, new Function2() { // from class: androidx.compose.material.NavigationRailKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return NavigationRailKt.NavigationRailItem_0S3VyRs$lambda$0$0(function4, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    final Function2 composableLambda119 = composableLambdaRememberComposableLambda;
                    if (function4 == null) {
                        f = NavigationRailItemCompactSize;
                    } else {
                        f = NavigationRailItemSize;
                    }
                    MutableInteractionSource mutableInteractionSource1112 = mutableInteractionSource3;
                    boolean z1117 = z4;
                    Modifier modifierM1266size3ABfNKs119 = SizeKt.m1266size3ABfNKs(SelectableKt.m1533selectableO2vRcR0(modifier2, z, mutableInteractionSource1112, RippleKt.m2523rippleH2RKhps$default(false, 0.0f, jM2342getPrimary0d7_KjU, 2, null), z1117, Role.m8825boximpl(Role.INSTANCE.m8839getTabo7Vup1c()), function0), f);
                    Alignment center119 = Alignment.INSTANCE.getCenter();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy119 = BoxKt.maybeCachedBoxMeasurePolicy(center119, false);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap119 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier119 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1266size3ABfNKs119);
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
                    Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy119, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap119, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (!composerM6062constructorimpl.getInserting()) {
                        composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    } else {
                        composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier119, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance119 = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 415492902, "C240@10971L303,240@10890L384:NavigationRail.kt#jmzs0o");
                    int i2119 = i14 >> 24;
                    m2476NavigationRailTransitionKlgxPg(jM2342getPrimary0d7_KjU, jM6813copywmQWz5c$default, z, ComposableLambdaKt.rememberComposableLambda(317431928, true, new Function3() { // from class: androidx.compose.material.NavigationRailKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return NavigationRailKt.NavigationRailItem_0S3VyRs$lambda$1$0(z5, function2, composableLambda119, ((Float) obj).floatValue(), (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, (i2119 & 112) | (i2119 & 14) | 3072 | ((i14 << 6) & 896));
                    composer2 = composerStartRestartGroup;
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    mutableInteractionSource2 = mutableInteractionSource1112;
                    function5 = function4;
                    z7 = z1117;
                    j4 = jM6813copywmQWz5c$default;
                    j3 = jM2342getPrimary0d7_KjU;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    mutableInteractionSource2 = mutableInteractionSource;
                    z7 = z4;
                    function5 = function4;
                    j3 = j;
                    j4 = j2;
                }
                modifier3 = modifier2;
                z8 = z5;
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.NavigationRailKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return NavigationRailKt.NavigationRailItem_0S3VyRs$lambda$2(z, function0, function2, modifier3, z7, function5, z8, mutableInteractionSource2, j3, j4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 12582912;
            if ((i & 100663296) == 0) {
                int i11111116 = i3;
                if ((i2 & 256) == 0) {
                    i16 = 33554432;
                } else {
                    i16 = 33554432;
                }
                i12 = i11111116 | i16;
            } else {
                i12 = i3;
            }
            if ((i & 805306368) == 0) {
                int i11111117 = i12;
                if ((i2 & 512) == 0) {
                    i15 = 268435456;
                } else {
                    i15 = 268435456;
                }
                i12 = i11111117 | i15;
            }
            i13 = i12;
            if ((i13 & 306783379) != 306783378) {
                z6 = true;
            } else {
                z6 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z6, i13 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "209@9518L6,210@9588L7,210@9622L6");
                composableLambdaRememberComposableLambda = null;
                if ((i & 1) != 0) {
                    if (i17 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        z4 = true;
                    }
                    if (i6 != 0) {
                        function4 = null;
                    }
                    if (i8 != 0) {
                        z5 = true;
                    }
                    if (i10 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    if ((i2 & 256) != 0) {
                        jM2342getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2342getPrimary0d7_KjU();
                        i14 = i13 & (-234881025);
                    } else {
                        jM2342getPrimary0d7_KjU = j;
                        i14 = i13;
                    }
                    if ((i2 & 512) != 0) {
                        ProvidableCompositionLocal<Color> localContentColor111118 = ContentColorKt.getLocalContentColor();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object objConsume111118 = composerStartRestartGroup.consume(localContentColor111118);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        jM6813copywmQWz5c$default = Color.m6813copywmQWz5c$default(((Color) objConsume111118).m6824unboximpl(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                        i14 &= -1879048193;
                    } else {
                        jM6813copywmQWz5c$default = j2;
                    }
                } else {
                    if (i17 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        z4 = true;
                    }
                    if (i6 != 0) {
                        function4 = null;
                    }
                    if (i8 != 0) {
                        z5 = true;
                    }
                    if (i10 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    if ((i2 & 256) != 0) {
                        jM2342getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2342getPrimary0d7_KjU();
                        i14 = i13 & (-234881025);
                    } else {
                        jM2342getPrimary0d7_KjU = j;
                        i14 = i13;
                    }
                    if ((i2 & 512) != 0) {
                        ProvidableCompositionLocal<Color> localContentColor111119 = ContentColorKt.getLocalContentColor();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object objConsume111119 = composerStartRestartGroup.consume(localContentColor111119);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        jM6813copywmQWz5c$default = Color.m6813copywmQWz5c$default(((Color) objConsume111119).m6824unboximpl(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                        i14 &= -1879048193;
                    } else {
                        jM6813copywmQWz5c$default = j2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(83562179, i14, -1, "androidx.compose.material.NavigationRailItem (NavigationRail.kt:211)");
                }
                if (function4 == null) {
                    composerStartRestartGroup.startReplaceGroup(-1679616946);
                } else {
                    composerStartRestartGroup.startReplaceGroup(-1679616945);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "*214@9729L168");
                    composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-674640273, true, new Function2() { // from class: androidx.compose.material.NavigationRailKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return NavigationRailKt.NavigationRailItem_0S3VyRs$lambda$0$0(function4, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54);
                }
                composerStartRestartGroup.endReplaceGroup();
                final Function2 composableLambda1110 = composableLambdaRememberComposableLambda;
                if (function4 == null) {
                    f = NavigationRailItemCompactSize;
                } else {
                    f = NavigationRailItemSize;
                }
                MutableInteractionSource mutableInteractionSource1113 = mutableInteractionSource3;
                boolean z1118 = z4;
                Modifier modifierM1266size3ABfNKs1110 = SizeKt.m1266size3ABfNKs(SelectableKt.m1533selectableO2vRcR0(modifier2, z, mutableInteractionSource1113, RippleKt.m2523rippleH2RKhps$default(false, 0.0f, jM2342getPrimary0d7_KjU, 2, null), z1118, Role.m8825boximpl(Role.INSTANCE.m8839getTabo7Vup1c()), function0), f);
                Alignment center1110 = Alignment.INSTANCE.getCenter();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy1110 = BoxKt.maybeCachedBoxMeasurePolicy(center1110, false);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap1110 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier1110 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1266size3ABfNKs1110);
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
                Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy1110, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap1110, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!composerM6062constructorimpl.getInserting()) {
                    composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                } else {
                    composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier1110, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance1110 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 415492902, "C240@10971L303,240@10890L384:NavigationRail.kt#jmzs0o");
                int i21110 = i14 >> 24;
                m2476NavigationRailTransitionKlgxPg(jM2342getPrimary0d7_KjU, jM6813copywmQWz5c$default, z, ComposableLambdaKt.rememberComposableLambda(317431928, true, new Function3() { // from class: androidx.compose.material.NavigationRailKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return NavigationRailKt.NavigationRailItem_0S3VyRs$lambda$1$0(z5, function2, composableLambda1110, ((Float) obj).floatValue(), (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, (i21110 & 112) | (i21110 & 14) | 3072 | ((i14 << 6) & 896));
                composer2 = composerStartRestartGroup;
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                mutableInteractionSource2 = mutableInteractionSource1113;
                function5 = function4;
                z7 = z1118;
                j4 = jM6813copywmQWz5c$default;
                j3 = jM2342getPrimary0d7_KjU;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                mutableInteractionSource2 = mutableInteractionSource;
                z7 = z4;
                function5 = function4;
                j3 = j;
                j4 = j2;
            }
            modifier3 = modifier2;
            z8 = z5;
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.NavigationRailKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return NavigationRailKt.NavigationRailItem_0S3VyRs$lambda$2(z, function0, function2, modifier3, z7, function5, z8, mutableInteractionSource2, j3, j4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 1572864;
        z5 = z3;
        i10 = i2 & 128;
        if (i10 != 0) {
            if ((i & 12582912) == 0) {
                if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                    i11 = 8388608;
                } else {
                    i11 = 4194304;
                }
                i3 |= i11;
            }
            if ((i & 100663296) == 0) {
                int i11111118 = i3;
                if ((i2 & 256) == 0) {
                    i16 = 33554432;
                } else {
                    i16 = 33554432;
                }
                i12 = i11111118 | i16;
            } else {
                i12 = i3;
            }
            if ((i & 805306368) == 0) {
                int i11111119 = i12;
                if ((i2 & 512) == 0) {
                    i15 = 268435456;
                } else {
                    i15 = 268435456;
                }
                i12 = i11111119 | i15;
            }
            i13 = i12;
            if ((i13 & 306783379) != 306783378) {
                z6 = true;
            } else {
                z6 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z6, i13 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "209@9518L6,210@9588L7,210@9622L6");
                composableLambdaRememberComposableLambda = null;
                if ((i & 1) != 0) {
                    if (i17 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        z4 = true;
                    }
                    if (i6 != 0) {
                        function4 = null;
                    }
                    if (i8 != 0) {
                        z5 = true;
                    }
                    if (i10 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    if ((i2 & 256) != 0) {
                        jM2342getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2342getPrimary0d7_KjU();
                        i14 = i13 & (-234881025);
                    } else {
                        jM2342getPrimary0d7_KjU = j;
                        i14 = i13;
                    }
                    if ((i2 & 512) != 0) {
                        ProvidableCompositionLocal<Color> localContentColor1111110 = ContentColorKt.getLocalContentColor();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object objConsume1111110 = composerStartRestartGroup.consume(localContentColor1111110);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        jM6813copywmQWz5c$default = Color.m6813copywmQWz5c$default(((Color) objConsume1111110).m6824unboximpl(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                        i14 &= -1879048193;
                    } else {
                        jM6813copywmQWz5c$default = j2;
                    }
                } else {
                    if (i17 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        z4 = true;
                    }
                    if (i6 != 0) {
                        function4 = null;
                    }
                    if (i8 != 0) {
                        z5 = true;
                    }
                    if (i10 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    if ((i2 & 256) != 0) {
                        jM2342getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2342getPrimary0d7_KjU();
                        i14 = i13 & (-234881025);
                    } else {
                        jM2342getPrimary0d7_KjU = j;
                        i14 = i13;
                    }
                    if ((i2 & 512) != 0) {
                        ProvidableCompositionLocal<Color> localContentColor1111111 = ContentColorKt.getLocalContentColor();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object objConsume1111111 = composerStartRestartGroup.consume(localContentColor1111111);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        jM6813copywmQWz5c$default = Color.m6813copywmQWz5c$default(((Color) objConsume1111111).m6824unboximpl(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                        i14 &= -1879048193;
                    } else {
                        jM6813copywmQWz5c$default = j2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(83562179, i14, -1, "androidx.compose.material.NavigationRailItem (NavigationRail.kt:211)");
                }
                if (function4 == null) {
                    composerStartRestartGroup.startReplaceGroup(-1679616946);
                } else {
                    composerStartRestartGroup.startReplaceGroup(-1679616945);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "*214@9729L168");
                    composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-674640273, true, new Function2() { // from class: androidx.compose.material.NavigationRailKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return NavigationRailKt.NavigationRailItem_0S3VyRs$lambda$0$0(function4, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54);
                }
                composerStartRestartGroup.endReplaceGroup();
                final Function2 composableLambda1111 = composableLambdaRememberComposableLambda;
                if (function4 == null) {
                    f = NavigationRailItemCompactSize;
                } else {
                    f = NavigationRailItemSize;
                }
                MutableInteractionSource mutableInteractionSource1114 = mutableInteractionSource3;
                boolean z1119 = z4;
                Modifier modifierM1266size3ABfNKs1111 = SizeKt.m1266size3ABfNKs(SelectableKt.m1533selectableO2vRcR0(modifier2, z, mutableInteractionSource1114, RippleKt.m2523rippleH2RKhps$default(false, 0.0f, jM2342getPrimary0d7_KjU, 2, null), z1119, Role.m8825boximpl(Role.INSTANCE.m8839getTabo7Vup1c()), function0), f);
                Alignment center1111 = Alignment.INSTANCE.getCenter();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy1111 = BoxKt.maybeCachedBoxMeasurePolicy(center1111, false);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap1111 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier1111 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1266size3ABfNKs1111);
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
                Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy1111, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap1111, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (!composerM6062constructorimpl.getInserting()) {
                    composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                } else {
                    composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier1111, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance1111 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 415492902, "C240@10971L303,240@10890L384:NavigationRail.kt#jmzs0o");
                int i21111 = i14 >> 24;
                m2476NavigationRailTransitionKlgxPg(jM2342getPrimary0d7_KjU, jM6813copywmQWz5c$default, z, ComposableLambdaKt.rememberComposableLambda(317431928, true, new Function3() { // from class: androidx.compose.material.NavigationRailKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return NavigationRailKt.NavigationRailItem_0S3VyRs$lambda$1$0(z5, function2, composableLambda1111, ((Float) obj).floatValue(), (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, (i21111 & 112) | (i21111 & 14) | 3072 | ((i14 << 6) & 896));
                composer2 = composerStartRestartGroup;
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                mutableInteractionSource2 = mutableInteractionSource1114;
                function5 = function4;
                z7 = z1119;
                j4 = jM6813copywmQWz5c$default;
                j3 = jM2342getPrimary0d7_KjU;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                mutableInteractionSource2 = mutableInteractionSource;
                z7 = z4;
                function5 = function4;
                j3 = j;
                j4 = j2;
            }
            modifier3 = modifier2;
            z8 = z5;
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.NavigationRailKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return NavigationRailKt.NavigationRailItem_0S3VyRs$lambda$2(z, function0, function2, modifier3, z7, function5, z8, mutableInteractionSource2, j3, j4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 12582912;
        if ((i & 100663296) == 0) {
            int i111111110 = i3;
            if ((i2 & 256) == 0) {
                i16 = 33554432;
            } else {
                i16 = 33554432;
            }
            i12 = i111111110 | i16;
        } else {
            i12 = i3;
        }
        if ((i & 805306368) == 0) {
            int i111111111 = i12;
            if ((i2 & 512) == 0) {
                i15 = 268435456;
            } else {
                i15 = 268435456;
            }
            i12 = i111111111 | i15;
        }
        i13 = i12;
        if ((i13 & 306783379) != 306783378) {
            z6 = true;
        } else {
            z6 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z6, i13 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "209@9518L6,210@9588L7,210@9622L6");
            composableLambdaRememberComposableLambda = null;
            if ((i & 1) != 0) {
                if (i17 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i4 != 0) {
                    z4 = true;
                }
                if (i6 != 0) {
                    function4 = null;
                }
                if (i8 != 0) {
                    z5 = true;
                }
                if (i10 != 0) {
                    mutableInteractionSource3 = null;
                } else {
                    mutableInteractionSource3 = mutableInteractionSource;
                }
                if ((i2 & 256) != 0) {
                    jM2342getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2342getPrimary0d7_KjU();
                    i14 = i13 & (-234881025);
                } else {
                    jM2342getPrimary0d7_KjU = j;
                    i14 = i13;
                }
                if ((i2 & 512) != 0) {
                    ProvidableCompositionLocal<Color> localContentColor1111112 = ContentColorKt.getLocalContentColor();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume1111112 = composerStartRestartGroup.consume(localContentColor1111112);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    jM6813copywmQWz5c$default = Color.m6813copywmQWz5c$default(((Color) objConsume1111112).m6824unboximpl(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                    i14 &= -1879048193;
                } else {
                    jM6813copywmQWz5c$default = j2;
                }
            } else {
                if (i17 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i4 != 0) {
                    z4 = true;
                }
                if (i6 != 0) {
                    function4 = null;
                }
                if (i8 != 0) {
                    z5 = true;
                }
                if (i10 != 0) {
                    mutableInteractionSource3 = null;
                } else {
                    mutableInteractionSource3 = mutableInteractionSource;
                }
                if ((i2 & 256) != 0) {
                    jM2342getPrimary0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2342getPrimary0d7_KjU();
                    i14 = i13 & (-234881025);
                } else {
                    jM2342getPrimary0d7_KjU = j;
                    i14 = i13;
                }
                if ((i2 & 512) != 0) {
                    ProvidableCompositionLocal<Color> localContentColor1111113 = ContentColorKt.getLocalContentColor();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume1111113 = composerStartRestartGroup.consume(localContentColor1111113);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    jM6813copywmQWz5c$default = Color.m6813copywmQWz5c$default(((Color) objConsume1111113).m6824unboximpl(), ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                    i14 &= -1879048193;
                } else {
                    jM6813copywmQWz5c$default = j2;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(83562179, i14, -1, "androidx.compose.material.NavigationRailItem (NavigationRail.kt:211)");
            }
            if (function4 == null) {
                composerStartRestartGroup.startReplaceGroup(-1679616946);
            } else {
                composerStartRestartGroup.startReplaceGroup(-1679616945);
                ComposerKt.sourceInformation(composerStartRestartGroup, "*214@9729L168");
                composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-674640273, true, new Function2() { // from class: androidx.compose.material.NavigationRailKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return NavigationRailKt.NavigationRailItem_0S3VyRs$lambda$0$0(function4, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54);
            }
            composerStartRestartGroup.endReplaceGroup();
            final Function2 composableLambda1112 = composableLambdaRememberComposableLambda;
            if (function4 == null) {
                f = NavigationRailItemCompactSize;
            } else {
                f = NavigationRailItemSize;
            }
            MutableInteractionSource mutableInteractionSource1115 = mutableInteractionSource3;
            boolean z11110 = z4;
            Modifier modifierM1266size3ABfNKs1112 = SizeKt.m1266size3ABfNKs(SelectableKt.m1533selectableO2vRcR0(modifier2, z, mutableInteractionSource1115, RippleKt.m2523rippleH2RKhps$default(false, 0.0f, jM2342getPrimary0d7_KjU, 2, null), z11110, Role.m8825boximpl(Role.INSTANCE.m8839getTabo7Vup1c()), function0), f);
            Alignment center1112 = Alignment.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy1112 = BoxKt.maybeCachedBoxMeasurePolicy(center1112, false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap1112 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier1112 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1266size3ABfNKs1112);
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
            Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy1112, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap1112, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (!composerM6062constructorimpl.getInserting()) {
                composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            } else {
                composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier1112, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance1112 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 415492902, "C240@10971L303,240@10890L384:NavigationRail.kt#jmzs0o");
            int i21112 = i14 >> 24;
            m2476NavigationRailTransitionKlgxPg(jM2342getPrimary0d7_KjU, jM6813copywmQWz5c$default, z, ComposableLambdaKt.rememberComposableLambda(317431928, true, new Function3() { // from class: androidx.compose.material.NavigationRailKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return NavigationRailKt.NavigationRailItem_0S3VyRs$lambda$1$0(z5, function2, composableLambda1112, ((Float) obj).floatValue(), (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, (i21112 & 112) | (i21112 & 14) | 3072 | ((i14 << 6) & 896));
            composer2 = composerStartRestartGroup;
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            mutableInteractionSource2 = mutableInteractionSource1115;
            function5 = function4;
            z7 = z11110;
            j4 = jM6813copywmQWz5c$default;
            j3 = jM2342getPrimary0d7_KjU;
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            mutableInteractionSource2 = mutableInteractionSource;
            z7 = z4;
            function5 = function4;
            j3 = j;
            j4 = j2;
        }
        modifier3 = modifier2;
        z8 = z5;
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.NavigationRailKt$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return NavigationRailKt.NavigationRailItem_0S3VyRs$lambda$2(z, function0, function2, modifier3, z7, function5, z8, mutableInteractionSource2, j3, j4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NavigationRailItem_0S3VyRs$lambda$0$0(Function2 function2, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C215@9773L10,216@9843L40:NavigationRail.kt#jmzs0o");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-674640273, i, -1, "androidx.compose.material.NavigationRailItem.<anonymous>.<anonymous> (NavigationRail.kt:215)");
            }
            TextKt.ProvideTextStyle(TextStyle.m9104copyp1EtxEg$default(MaterialTheme.INSTANCE.getTypography(composer, 6).getCaption(), 0L, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, TextAlign.INSTANCE.m9526getCentere0LSkKk(), 0, 0L, null, null, null, 0, 0, null, 16744447, null), function2, composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NavigationRailItem_0S3VyRs$lambda$1$0(boolean z, Function2 function2, Function2 function3, float f, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "CN(progress)244@11084L180:NavigationRail.kt#jmzs0o");
        if ((i & 6) == 0) {
            i |= composer.changed(f) ? 4 : 2;
        }
        if (!composer.shouldExecute((i & 19) != 18, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(317431928, i, -1, "androidx.compose.material.NavigationRailItem.<anonymous>.<anonymous> (NavigationRail.kt:242)");
            }
            if (z) {
                f = 1.0f;
            }
            NavigationRailItemBaselineLayout(function2, function3, f, composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: NavigationRailTransition-Klgx-Pg, reason: not valid java name */
    private static final void m2476NavigationRailTransitionKlgxPg(final long j, final long j2, final boolean z, final Function3<? super Float, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(140356545);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(NavigationRailTransition)N(activeColor:c#ui.graphics.Color,inactiveColor:c#ui.graphics.Color,selected,content)287@12657L139,297@13010L42,294@12871L181:NavigationRail.kt#jmzs0o");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(j) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(j2) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changed(z) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function3) ? 2048 : 1024;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 1171) != 1170, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(140356545, i2, -1, "androidx.compose.material.NavigationRailTransition (NavigationRail.kt:285)");
            }
            final State<Float> stateAnimateFloatAsState = AnimateAsStateKt.animateFloatAsState(z ? 1.0f : 0.0f, NavigationRailAnimationSpec, 0.0f, null, null, composerStartRestartGroup, 48, 28);
            long jM6865lerpjxsXWHM = ColorKt.m6865lerpjxsXWHM(j2, j, NavigationRailTransition_Klgx_Pg$lambda$0(stateAnimateFloatAsState));
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m6804boximpl(Color.m6813copywmQWz5c$default(jM6865lerpjxsXWHM, 1.0f, 0.0f, 0.0f, 0.0f, 14, null))), ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.m6816getAlphaimpl(jM6865lerpjxsXWHM)))}, ComposableLambdaKt.rememberComposableLambda(1330097921, true, new Function2() { // from class: androidx.compose.material.NavigationRailKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return NavigationRailKt.NavigationRailTransition_Klgx_Pg$lambda$1(function3, stateAnimateFloatAsState, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.NavigationRailKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return NavigationRailKt.NavigationRailTransition_Klgx_Pg$lambda$2(j, j2, z, function3, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NavigationRailTransition_Klgx_Pg$lambda$1(Function3 function3, State state, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C298@13020L26:NavigationRail.kt#jmzs0o");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1330097921, i, -1, "androidx.compose.material.NavigationRailTransition.<anonymous> (NavigationRail.kt:298)");
            }
            function3.invoke(Float.valueOf(NavigationRailTransition_Klgx_Pg$lambda$0(state)), composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    private static final void NavigationRailItemBaselineLayout(final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function3, final float f, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1276874318);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(NavigationRailItemBaselineLayout)N(icon,label,iconPositionAnimationProgress)323@13918L928,318@13720L1126:NavigationRail.kt#jmzs0o");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(function2) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function3) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changed(f) ? 256 : 128;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & Token.DOTQUERY) != 146, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1276874318, i2, -1, "androidx.compose.material.NavigationRailItemBaselineLayout (NavigationRail.kt:317)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1284440530, "CC(remember):NavigationRail.kt#9igjgp");
            boolean z = ((i2 & 112) == 32) | ((i2 & 896) == 256);
            MeasurePolicy measurePolicyRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z || measurePolicyRememberedValue == Composer.INSTANCE.getEmpty()) {
                measurePolicyRememberedValue = new MeasurePolicy() { // from class: androidx.compose.material.NavigationRailKt$NavigationRailItemBaselineLayout$2$1
                    @Override // androidx.compose.ui.layout.MeasurePolicy
                    /* JADX INFO: renamed from: measure-3p2s80s */
                    public final MeasureResult mo344measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
                        Placeable placeableMo8265measureBRTryo0;
                        List<? extends Measurable> list2 = list;
                        int size = list2.size();
                        int i3 = 0;
                        for (int i4 = 0; i4 < size; i4++) {
                            Measurable measurable = list.get(i4);
                            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable), HubsObservability.HUB_ASSET_ICON)) {
                                Placeable placeableMo8265measureBRTryo1 = measurable.mo8265measureBRTryo0(j);
                                if (function3 != null) {
                                    int size2 = list2.size();
                                    while (true) {
                                        if (i3 < size2) {
                                            Measurable measurable2 = list.get(i3);
                                            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable2), "label")) {
                                                placeableMo8265measureBRTryo0 = measurable2.mo8265measureBRTryo0(Constraints.m9630copyZbe2FdA$default(j, 0, 0, 0, 0, 11, null));
                                                break;
                                            }
                                            i3++;
                                        } else {
                                            ListUtilsKt.throwNoSuchElementException("Collection contains no element matching the predicate.");
                                            throw new KotlinNothingValueException();
                                        }
                                    }
                                } else {
                                    placeableMo8265measureBRTryo0 = null;
                                }
                                if (function3 == null) {
                                    return NavigationRailKt.m2479placeIcon3p2s80s(measureScope, placeableMo8265measureBRTryo1, j);
                                }
                                Intrinsics.checkNotNull(placeableMo8265measureBRTryo0);
                                return NavigationRailKt.m2480placeLabelAndIconDIyivk0(measureScope, placeableMo8265measureBRTryo0, placeableMo8265measureBRTryo1, j, f);
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
            Modifier.Companion companion = Modifier.INSTANCE;
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
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
            Updater.m6070setimpl(composerM6062constructorimpl, measurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM6062constructorimpl.getInserting() || !Intrinsics.areEqual(composerM6062constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1177287557, "C319@13737L41:NavigationRail.kt#jmzs0o");
            Modifier modifierLayoutId = LayoutIdKt.layoutId(Modifier.INSTANCE, HubsObservability.HUB_ASSET_ICON);
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -491319352, "C319@13770L6:NavigationRail.kt#jmzs0o");
            function2.invoke(composerStartRestartGroup, Integer.valueOf(i2 & 14));
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (function3 != null) {
                composerStartRestartGroup.startReplaceGroup(-1177221249);
                ComposerKt.sourceInformation(composerStartRestartGroup, "321@13820L80");
                Modifier modifierAlpha = AlphaKt.alpha(LayoutIdKt.layoutId(Modifier.INSTANCE, "label"), f);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierAlpha);
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
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1391280638, "C321@13891L7:NavigationRail.kt#jmzs0o");
                function3.invoke(composerStartRestartGroup, Integer.valueOf((i2 >> 3) & 14));
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            } else {
                composerStartRestartGroup.startReplaceGroup(-1190921017);
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.NavigationRailKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return NavigationRailKt.NavigationRailItemBaselineLayout$lambda$2(function2, function3, f, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: placeIcon-3p2s80s, reason: not valid java name */
    public static final MeasureResult m2479placeIcon3p2s80s(MeasureScope measureScope, final Placeable placeable, long j) {
        final int iMax = Math.max(0, (Constraints.m9640getMaxWidthimpl(j) - placeable.getWidth()) / 2);
        final int iMax2 = Math.max(0, (Constraints.m9639getMaxHeightimpl(j) - placeable.getHeight()) / 2);
        return MeasureScope.layout$default(measureScope, Constraints.m9640getMaxWidthimpl(j), Constraints.m9639getMaxHeightimpl(j), null, new Function1() { // from class: androidx.compose.material.NavigationRailKt$$ExternalSyntheticLambda10
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return NavigationRailKt.placeIcon_3p2s80s$lambda$0(placeable, iMax, iMax2, (Placeable.PlacementScope) obj);
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit placeIcon_3p2s80s$lambda$0(Placeable placeable, int i, int i2, Placeable.PlacementScope placementScope) {
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable, i, i2, 0.0f, 4, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: placeLabelAndIcon-DIyivk0, reason: not valid java name */
    public static final MeasureResult m2480placeLabelAndIconDIyivk0(MeasureScope measureScope, final Placeable placeable, final Placeable placeable2, long j, final float f) {
        final int iM9639getMaxHeightimpl = (Constraints.m9639getMaxHeightimpl(j) - placeable.get(AlignmentLineKt.getLastBaseline())) - measureScope.mo748roundToPx0680j_4(ItemLabelBaselineBottomOffset);
        final int iM9640getMaxWidthimpl = (Constraints.m9640getMaxWidthimpl(j) - placeable.getWidth()) / 2;
        final int i = measureScope.mo748roundToPx0680j_4(ItemIconTopOffset);
        int iM9639getMaxHeightimpl2 = (Constraints.m9639getMaxHeightimpl(j) - placeable2.getHeight()) / 2;
        final int iM9640getMaxWidthimpl2 = (Constraints.m9640getMaxWidthimpl(j) - placeable2.getWidth()) / 2;
        final int iRoundToInt = MathKt.roundToInt((iM9639getMaxHeightimpl2 - i) * (1 - f));
        return MeasureScope.layout$default(measureScope, Constraints.m9640getMaxWidthimpl(j), Constraints.m9639getMaxHeightimpl(j), null, new Function1() { // from class: androidx.compose.material.NavigationRailKt$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return NavigationRailKt.placeLabelAndIcon_DIyivk0$lambda$0(f, placeable, iM9640getMaxWidthimpl, iM9639getMaxHeightimpl, iRoundToInt, placeable2, iM9640getMaxWidthimpl2, i, (Placeable.PlacementScope) obj);
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit placeLabelAndIcon_DIyivk0$lambda$0(float f, Placeable placeable, int i, int i2, int i3, Placeable placeable2, int i4, int i5, Placeable.PlacementScope placementScope) {
        Placeable.PlacementScope placementScope2;
        if (f == 0.0f) {
            placementScope2 = placementScope;
        } else {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable, i, i2 + i3, 0.0f, 4, null);
            placementScope2 = placementScope;
        }
        Placeable.PlacementScope.placeRelative$default(placementScope2, placeable2, i4, i5 + i3, 0.0f, 4, null);
        return Unit.INSTANCE;
    }

    static {
        float f = 8;
        NavigationRailPadding = Dp.m9687constructorimpl(f);
        HeaderPadding = Dp.m9687constructorimpl(f);
    }

    private static final float NavigationRailTransition_Klgx_Pg$lambda$0(State<Float> state) {
        return state.getValue().floatValue();
    }
}
