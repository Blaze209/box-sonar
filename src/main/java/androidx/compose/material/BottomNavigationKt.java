package androidx.compose.material;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
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
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.util.ListUtilsKt;
import androidx.media3.common.C;
import androidx.profileinstaller.ProfileVerifier;
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
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: BottomNavigation.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000x\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a]\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\u001c\u0010\u000b\u001a\u0018\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00010\f¢\u0006\u0002\b\u000e¢\u0006\u0002\b\u000fH\u0007¢\u0006\u0004\b\u0010\u0010\u0011\u001aU\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\u001c\u0010\u000b\u001a\u0018\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00010\f¢\u0006\u0002\b\u000e¢\u0006\u0002\b\u000fH\u0007¢\u0006\u0004\b\u0012\u0010\u0013\u001a\u0091\u0001\u0010\u0014\u001a\u00020\u0001*\u00020\r2\u0006\u0010\u0015\u001a\u00020\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00010\u00182\u0011\u0010\u0019\u001a\r\u0012\u0004\u0012\u00020\u00010\u0018¢\u0006\u0002\b\u000e2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u001a\u001a\u00020\u00162\u0015\b\u0002\u0010\u001b\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0018¢\u0006\u0002\b\u000e2\b\b\u0002\u0010\u001c\u001a\u00020\u00162\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\u00072\b\b\u0002\u0010 \u001a\u00020\u0007H\u0007¢\u0006\u0004\b!\u0010\"\u001aO\u0010#\u001a\u00020\u00012\u0006\u0010$\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00162&\u0010\u000b\u001a\"\u0012\u0013\u0012\u00110&¢\u0006\f\b'\u0012\b\b(\u0012\u0004\b\b()\u0012\u0004\u0012\u00020\u00010\f¢\u0006\u0002\b\u000eH\u0003¢\u0006\u0004\b*\u0010+\u001a?\u0010,\u001a\u00020\u00012\u0011\u0010\u0019\u001a\r\u0012\u0004\u0012\u00020\u00010\u0018¢\u0006\u0002\b\u000e2\u0013\u0010\u001b\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0018¢\u0006\u0002\b\u000e2\b\b\u0001\u0010-\u001a\u00020&H\u0003¢\u0006\u0002\u0010.\u001a#\u0010/\u001a\u000200*\u0002012\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u000205H\u0002¢\u0006\u0004\b6\u00107\u001a5\u00108\u001a\u000200*\u0002012\u0006\u00109\u001a\u0002032\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u0002052\b\b\u0001\u0010-\u001a\u00020&H\u0002¢\u0006\u0004\b:\u0010;\"\u0014\u0010<\u001a\b\u0012\u0004\u0012\u00020&0=X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010>\u001a\u00020\nX\u0082\u0004¢\u0006\u0004\n\u0002\u0010?\"\u0010\u0010@\u001a\u00020\nX\u0082\u0004¢\u0006\u0004\n\u0002\u0010?\"\u0010\u0010A\u001a\u00020\nX\u0082\u0004¢\u0006\u0004\n\u0002\u0010?\"\u000e\u0010B\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006C²\u0006\n\u0010)\u001a\u00020&X\u008a\u0084\u0002"}, d2 = {"BottomNavigation", "", "windowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "modifier", "Landroidx/compose/ui/Modifier;", "backgroundColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "elevation", "Landroidx/compose/ui/unit/Dp;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/RowScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "BottomNavigation-_UMDTes", "(Landroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/ui/Modifier;JJFLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "BottomNavigation-PEIptTM", "(Landroidx/compose/ui/Modifier;JJFLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "BottomNavigationItem", "selected", "", ViewProps.ON_CLICK, "Lkotlin/Function0;", HubsObservability.HUB_ASSET_ICON, "enabled", "label", "alwaysShowLabel", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "selectedContentColor", "unselectedContentColor", "BottomNavigationItem-jY6E1Zs", "(Landroidx/compose/foundation/layout/RowScope;ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;JJLandroidx/compose/runtime/Composer;III)V", "BottomNavigationTransition", "activeColor", "inactiveColor", "", "Lkotlin/ParameterName;", "name", "animationProgress", "BottomNavigationTransition-Klgx-Pg", "(JJZLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;I)V", "BottomNavigationItemBaselineLayout", "iconPositionAnimationProgress", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;FLandroidx/compose/runtime/Composer;I)V", "placeIcon", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "iconPlaceable", "Landroidx/compose/ui/layout/Placeable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "placeIcon-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Placeable;J)Landroidx/compose/ui/layout/MeasureResult;", "placeLabelAndIcon", "labelPlaceable", "placeLabelAndIcon-DIyivk0", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;JF)Landroidx/compose/ui/layout/MeasureResult;", "BottomNavigationAnimationSpec", "Landroidx/compose/animation/core/TweenSpec;", "BottomNavigationHeight", "F", "BottomNavigationItemHorizontalPadding", "CombinedItemTextBaseline", "ZeroInsets", "material"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class BottomNavigationKt {
    private static final TweenSpec<Float> BottomNavigationAnimationSpec = new TweenSpec<>(300, 0, EasingKt.getFastOutSlowInEasing(), 2, null);
    private static final float BottomNavigationHeight = Dp.m9687constructorimpl(56);
    private static final float BottomNavigationItemHorizontalPadding;
    private static final float CombinedItemTextBaseline;
    private static final WindowInsets ZeroInsets;

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BottomNavigationItemBaselineLayout$lambda$2(Function2 function2, Function2 function3, float f, int i, Composer composer, int i2) {
        BottomNavigationItemBaselineLayout(function2, function3, f, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BottomNavigationItem_jY6E1Zs$lambda$2(RowScope rowScope, boolean z, Function0 function0, Function2 function2, Modifier modifier, boolean z2, Function2 function3, boolean z3, MutableInteractionSource mutableInteractionSource, long j, long j2, int i, int i2, int i3, Composer composer, int i4) {
        m2283BottomNavigationItemjY6E1Zs(rowScope, z, function0, function2, modifier, z2, function3, z3, mutableInteractionSource, j, j2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BottomNavigationTransition_Klgx_Pg$lambda$2(long j, long j2, boolean z, Function3 function3, int i, Composer composer, int i2) {
        m2284BottomNavigationTransitionKlgxPg(j, j2, z, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BottomNavigation_PEIptTM$lambda$0(Modifier modifier, long j, long j2, float f, Function3 function3, int i, int i2, Composer composer, int i3) {
        m2281BottomNavigationPEIptTM(modifier, j, j2, f, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BottomNavigation__UMDTes$lambda$1(WindowInsets windowInsets, Modifier modifier, long j, long j2, float f, Function3 function3, int i, int i2, Composer composer, int i3) {
        m2282BottomNavigation_UMDTes(windowInsets, modifier, j, j2, f, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:101:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:23:0x0044  */
    /* JADX WARN: Code duplicated, block: B:25:0x0048  */
    /* JADX WARN: Code duplicated, block: B:27:0x0050  */
    /* JADX WARN: Code duplicated, block: B:28:0x0053  */
    /* JADX WARN: Code duplicated, block: B:31:0x0059  */
    /* JADX WARN: Code duplicated, block: B:34:0x005f  */
    /* JADX WARN: Code duplicated, block: B:36:0x0063  */
    /* JADX WARN: Code duplicated, block: B:38:0x006b  */
    /* JADX WARN: Code duplicated, block: B:39:0x006e  */
    /* JADX WARN: Code duplicated, block: B:42:0x0074  */
    /* JADX WARN: Code duplicated, block: B:45:0x007a  */
    /* JADX WARN: Code duplicated, block: B:46:0x007d  */
    /* JADX WARN: Code duplicated, block: B:48:0x0081  */
    /* JADX WARN: Code duplicated, block: B:50:0x0089  */
    /* JADX WARN: Code duplicated, block: B:51:0x008c  */
    /* JADX WARN: Code duplicated, block: B:56:0x0097  */
    /* JADX WARN: Code duplicated, block: B:58:0x009d  */
    /* JADX WARN: Code duplicated, block: B:59:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:63:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:64:0x00af  */
    /* JADX WARN: Code duplicated, block: B:67:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:69:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:78:0x00da A[PHI: r3 r5 r6 r10
      0x00da: PHI (r3v21 int) = (r3v14 int), (r3v22 int), (r3v23 int) binds: [B:87:0x0106, B:76:0x00d6, B:77:0x00d8] A[DONT_GENERATE, DONT_INLINE]
      0x00da: PHI (r5v10 androidx.compose.ui.Modifier) = (r5v5 androidx.compose.ui.Modifier), (r5v2 androidx.compose.ui.Modifier), (r5v2 androidx.compose.ui.Modifier) binds: [B:87:0x0106, B:76:0x00d6, B:77:0x00d8] A[DONT_GENERATE, DONT_INLINE]
      0x00da: PHI (r6v12 long) = (r6v7 long), (r6v6 long), (r6v6 long) binds: [B:87:0x0106, B:76:0x00d6, B:77:0x00d8] A[DONT_GENERATE, DONT_INLINE]
      0x00da: PHI (r10v8 long) = (r10v4 long), (r10v2 long), (r10v2 long) binds: [B:87:0x0106, B:76:0x00d6, B:77:0x00d8] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:79:0x00e0 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:80:0x00e2  */
    /* JADX WARN: Code duplicated, block: B:83:0x00eb  */
    /* JADX WARN: Code duplicated, block: B:86:0x00fc  */
    /* JADX WARN: Code duplicated, block: B:88:0x0108  */
    /* JADX WARN: Code duplicated, block: B:91:0x011c  */
    /* JADX WARN: Code duplicated, block: B:94:0x015b  */
    /* JADX WARN: Code duplicated, block: B:96:0x0164  */
    /* JADX WARN: Code duplicated, block: B:99:0x0173  */
    /* JADX INFO: renamed from: BottomNavigation-_UMDTes, reason: not valid java name */
    public static final void m2282BottomNavigation_UMDTes(final WindowInsets windowInsets, Modifier modifier, long j, long j2, float f, final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        long primarySurface;
        long jM2360contentColorForek8zF_U;
        int i4;
        float f2;
        int i5;
        boolean z;
        Composer composer2;
        final Modifier modifier3;
        final long j3;
        final long j4;
        final float f3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        float fM2277getElevationD9Ej5fM;
        long j5;
        long j6;
        Modifier modifier4;
        int i6;
        Composer composerStartRestartGroup = composer.startRestartGroup(-636542119);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BottomNavigation)N(windowInsets,modifier,backgroundColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,elevation:c#ui.unit.Dp,content)112@4927L314,107@4782L459:BottomNavigation.kt#jmzs0o");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(windowInsets) ? 4 : 2) | i;
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
                    primarySurface = j;
                    int i8 = composerStartRestartGroup.changed(primarySurface) ? 256 : 128;
                    i3 |= i8;
                } else {
                    primarySurface = j;
                }
                i3 |= i8;
            } else {
                primarySurface = j;
            }
            if ((i & 3072) == 0) {
                if ((i2 & 8) == 0) {
                    jM2360contentColorForek8zF_U = j2;
                    int i9 = composerStartRestartGroup.changed(jM2360contentColorForek8zF_U) ? 2048 : 1024;
                    i3 |= i9;
                } else {
                    jM2360contentColorForek8zF_U = j2;
                }
                i3 |= i9;
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
                if ((196608 & i) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i6 = 131072;
                    } else {
                        i6 = 65536;
                    }
                    i3 |= i6;
                }
                if ((74899 & i3) != 74898) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "102@4589L6,103@4638L32");
                    if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                        if (i7 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if ((i2 & 4) != 0) {
                            primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                            i3 &= -897;
                        }
                        if ((i2 & 8) != 0) {
                            jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 6) & 14);
                            i3 &= -7169;
                        }
                        if (i4 != 0) {
                            fM2277getElevationD9Ej5fM = BottomNavigationDefaults.INSTANCE.m2277getElevationD9Ej5fM();
                            j5 = primarySurface;
                            j6 = jM2360contentColorForek8zF_U;
                            modifier4 = modifier2;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-636542119, i3, -1, "androidx.compose.material.BottomNavigation (BottomNavigation.kt:106)");
                        }
                        composer2 = composerStartRestartGroup;
                        SurfaceKt.m2584SurfaceFjzlyU(modifier4, null, j5, j6, null, fM2277getElevationD9Ej5fM, ComposableLambdaKt.rememberComposableLambda(807373717, true, new Function2() { // from class: androidx.compose.material.BottomNavigationKt$$ExternalSyntheticLambda9
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return BottomNavigationKt.BottomNavigation__UMDTes$lambda$0(windowInsets, function3, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54), composer2, ((i3 >> 3) & 14) | 1572864 | (i3 & 896) | (i3 & 7168) | ((i3 << 3) & 458752), 18);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier4;
                        j3 = j5;
                        j4 = j6;
                        f3 = fM2277getElevationD9Ej5fM;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        if ((i2 & 4) != 0) {
                            i3 &= -897;
                        }
                        if ((i2 & 8) != 0) {
                            i3 &= -7169;
                        }
                    }
                    j6 = jM2360contentColorForek8zF_U;
                    fM2277getElevationD9Ej5fM = f2;
                    modifier4 = modifier2;
                    j5 = primarySurface;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-636542119, i3, -1, "androidx.compose.material.BottomNavigation (BottomNavigation.kt:106)");
                    }
                    composer2 = composerStartRestartGroup;
                    SurfaceKt.m2584SurfaceFjzlyU(modifier4, null, j5, j6, null, fM2277getElevationD9Ej5fM, ComposableLambdaKt.rememberComposableLambda(807373717, true, new Function2() { // from class: androidx.compose.material.BottomNavigationKt$$ExternalSyntheticLambda9
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return BottomNavigationKt.BottomNavigation__UMDTes$lambda$0(windowInsets, function3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composer2, ((i3 >> 3) & 14) | 1572864 | (i3 & 896) | (i3 & 7168) | ((i3 << 3) & 458752), 18);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier4;
                    j3 = j5;
                    j4 = j6;
                    f3 = fM2277getElevationD9Ej5fM;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    modifier3 = modifier2;
                    j3 = primarySurface;
                    j4 = jM2360contentColorForek8zF_U;
                    f3 = f2;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.BottomNavigationKt$$ExternalSyntheticLambda10
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return BottomNavigationKt.BottomNavigation__UMDTes$lambda$1(windowInsets, modifier3, j3, j4, f3, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 24576;
            f2 = f;
            if ((196608 & i) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i6 = 131072;
                } else {
                    i6 = 65536;
                }
                i3 |= i6;
            }
            if ((74899 & i3) != 74898) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "102@4589L6,103@4638L32");
                if ((i & 1) != 0) {
                    if (i7 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if ((i2 & 4) != 0) {
                        primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                        i3 &= -897;
                    }
                    if ((i2 & 8) != 0) {
                        jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 6) & 14);
                        i3 &= -7169;
                    }
                    if (i4 != 0) {
                        fM2277getElevationD9Ej5fM = BottomNavigationDefaults.INSTANCE.m2277getElevationD9Ej5fM();
                        j5 = primarySurface;
                        j6 = jM2360contentColorForek8zF_U;
                        modifier4 = modifier2;
                    } else {
                        j6 = jM2360contentColorForek8zF_U;
                        fM2277getElevationD9Ej5fM = f2;
                        modifier4 = modifier2;
                        j5 = primarySurface;
                    }
                } else {
                    if (i7 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if ((i2 & 4) != 0) {
                        primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                        i3 &= -897;
                    }
                    if ((i2 & 8) != 0) {
                        jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 6) & 14);
                        i3 &= -7169;
                    }
                    if (i4 != 0) {
                        fM2277getElevationD9Ej5fM = BottomNavigationDefaults.INSTANCE.m2277getElevationD9Ej5fM();
                        j5 = primarySurface;
                        j6 = jM2360contentColorForek8zF_U;
                        modifier4 = modifier2;
                    } else {
                        j6 = jM2360contentColorForek8zF_U;
                        fM2277getElevationD9Ej5fM = f2;
                        modifier4 = modifier2;
                        j5 = primarySurface;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-636542119, i3, -1, "androidx.compose.material.BottomNavigation (BottomNavigation.kt:106)");
                }
                composer2 = composerStartRestartGroup;
                SurfaceKt.m2584SurfaceFjzlyU(modifier4, null, j5, j6, null, fM2277getElevationD9Ej5fM, ComposableLambdaKt.rememberComposableLambda(807373717, true, new Function2() { // from class: androidx.compose.material.BottomNavigationKt$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return BottomNavigationKt.BottomNavigation__UMDTes$lambda$0(windowInsets, function3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composer2, ((i3 >> 3) & 14) | 1572864 | (i3 & 896) | (i3 & 7168) | ((i3 << 3) & 458752), 18);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier4;
                j3 = j5;
                j4 = j6;
                f3 = fM2277getElevationD9Ej5fM;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier3 = modifier2;
                j3 = primarySurface;
                j4 = jM2360contentColorForek8zF_U;
                f3 = f2;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.BottomNavigationKt$$ExternalSyntheticLambda10
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return BottomNavigationKt.BottomNavigation__UMDTes$lambda$1(windowInsets, modifier3, j3, j4, f3, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 48;
        modifier2 = modifier;
        if ((i & 384) == 0) {
            if ((i2 & 4) == 0) {
                primarySurface = j;
                if (composerStartRestartGroup.changed(primarySurface)) {
                }
                i3 |= i8;
            } else {
                primarySurface = j;
            }
            i3 |= i8;
        } else {
            primarySurface = j;
        }
        if ((i & 3072) == 0) {
            if ((i2 & 8) == 0) {
                jM2360contentColorForek8zF_U = j2;
                if (composerStartRestartGroup.changed(jM2360contentColorForek8zF_U)) {
                }
                i3 |= i9;
            } else {
                jM2360contentColorForek8zF_U = j2;
            }
            i3 |= i9;
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
            if ((196608 & i) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i6 = 131072;
                } else {
                    i6 = 65536;
                }
                i3 |= i6;
            }
            if ((74899 & i3) != 74898) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "102@4589L6,103@4638L32");
                if ((i & 1) != 0) {
                    if (i7 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if ((i2 & 4) != 0) {
                        primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                        i3 &= -897;
                    }
                    if ((i2 & 8) != 0) {
                        jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 6) & 14);
                        i3 &= -7169;
                    }
                    if (i4 != 0) {
                        fM2277getElevationD9Ej5fM = BottomNavigationDefaults.INSTANCE.m2277getElevationD9Ej5fM();
                        j5 = primarySurface;
                        j6 = jM2360contentColorForek8zF_U;
                        modifier4 = modifier2;
                    } else {
                        j6 = jM2360contentColorForek8zF_U;
                        fM2277getElevationD9Ej5fM = f2;
                        modifier4 = modifier2;
                        j5 = primarySurface;
                    }
                } else {
                    if (i7 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if ((i2 & 4) != 0) {
                        primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                        i3 &= -897;
                    }
                    if ((i2 & 8) != 0) {
                        jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 6) & 14);
                        i3 &= -7169;
                    }
                    if (i4 != 0) {
                        fM2277getElevationD9Ej5fM = BottomNavigationDefaults.INSTANCE.m2277getElevationD9Ej5fM();
                        j5 = primarySurface;
                        j6 = jM2360contentColorForek8zF_U;
                        modifier4 = modifier2;
                    } else {
                        j6 = jM2360contentColorForek8zF_U;
                        fM2277getElevationD9Ej5fM = f2;
                        modifier4 = modifier2;
                        j5 = primarySurface;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-636542119, i3, -1, "androidx.compose.material.BottomNavigation (BottomNavigation.kt:106)");
                }
                composer2 = composerStartRestartGroup;
                SurfaceKt.m2584SurfaceFjzlyU(modifier4, null, j5, j6, null, fM2277getElevationD9Ej5fM, ComposableLambdaKt.rememberComposableLambda(807373717, true, new Function2() { // from class: androidx.compose.material.BottomNavigationKt$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return BottomNavigationKt.BottomNavigation__UMDTes$lambda$0(windowInsets, function3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composer2, ((i3 >> 3) & 14) | 1572864 | (i3 & 896) | (i3 & 7168) | ((i3 << 3) & 458752), 18);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier4;
                j3 = j5;
                j4 = j6;
                f3 = fM2277getElevationD9Ej5fM;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier3 = modifier2;
                j3 = primarySurface;
                j4 = jM2360contentColorForek8zF_U;
                f3 = f2;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.BottomNavigationKt$$ExternalSyntheticLambda10
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return BottomNavigationKt.BottomNavigation__UMDTes$lambda$1(windowInsets, modifier3, j3, j4, f3, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 24576;
        f2 = f;
        if ((196608 & i) == 0) {
            if (composerStartRestartGroup.changedInstance(function3)) {
                i6 = 131072;
            } else {
                i6 = 65536;
            }
            i3 |= i6;
        }
        if ((74899 & i3) != 74898) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "102@4589L6,103@4638L32");
            if ((i & 1) != 0) {
                if (i7 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if ((i2 & 4) != 0) {
                    primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                    i3 &= -897;
                }
                if ((i2 & 8) != 0) {
                    jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 6) & 14);
                    i3 &= -7169;
                }
                if (i4 != 0) {
                    fM2277getElevationD9Ej5fM = BottomNavigationDefaults.INSTANCE.m2277getElevationD9Ej5fM();
                    j5 = primarySurface;
                    j6 = jM2360contentColorForek8zF_U;
                    modifier4 = modifier2;
                } else {
                    j6 = jM2360contentColorForek8zF_U;
                    fM2277getElevationD9Ej5fM = f2;
                    modifier4 = modifier2;
                    j5 = primarySurface;
                }
            } else {
                if (i7 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if ((i2 & 4) != 0) {
                    primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                    i3 &= -897;
                }
                if ((i2 & 8) != 0) {
                    jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 6) & 14);
                    i3 &= -7169;
                }
                if (i4 != 0) {
                    fM2277getElevationD9Ej5fM = BottomNavigationDefaults.INSTANCE.m2277getElevationD9Ej5fM();
                    j5 = primarySurface;
                    j6 = jM2360contentColorForek8zF_U;
                    modifier4 = modifier2;
                } else {
                    j6 = jM2360contentColorForek8zF_U;
                    fM2277getElevationD9Ej5fM = f2;
                    modifier4 = modifier2;
                    j5 = primarySurface;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-636542119, i3, -1, "androidx.compose.material.BottomNavigation (BottomNavigation.kt:106)");
            }
            composer2 = composerStartRestartGroup;
            SurfaceKt.m2584SurfaceFjzlyU(modifier4, null, j5, j6, null, fM2277getElevationD9Ej5fM, ComposableLambdaKt.rememberComposableLambda(807373717, true, new Function2() { // from class: androidx.compose.material.BottomNavigationKt$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BottomNavigationKt.BottomNavigation__UMDTes$lambda$0(windowInsets, function3, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composer2, ((i3 >> 3) & 14) | 1572864 | (i3 & 896) | (i3 & 7168) | ((i3 << 3) & 458752), 18);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier4;
            j3 = j5;
            j4 = j6;
            f3 = fM2277getElevationD9Ej5fM;
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            modifier3 = modifier2;
            j3 = primarySurface;
            j4 = jM2360contentColorForek8zF_U;
            f3 = f2;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.BottomNavigationKt$$ExternalSyntheticLambda10
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BottomNavigationKt.BottomNavigation__UMDTes$lambda$1(windowInsets, modifier3, j3, j4, f3, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BottomNavigation__UMDTes$lambda$0(WindowInsets windowInsets, Function3 function3, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C113@4937L298:BottomNavigation.kt#jmzs0o");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(807373717, i, -1, "androidx.compose.material.BottomNavigation.<anonymous> (BottomNavigation.kt:113)");
            }
            Modifier modifierSelectableGroup = SelectableGroupKt.selectableGroup(SizeKt.m1251defaultMinSizeVpY3zN4$default(WindowInsetsPaddingKt.windowInsetsPadding(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), windowInsets), 0.0f, BottomNavigationHeight, 1, null));
            Arrangement.HorizontalOrVertical spaceBetween = Arrangement.INSTANCE.getSpaceBetween();
            ComposerKt.sourceInformationMarkerStart(composer, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(spaceBetween, Alignment.INSTANCE.getTop(), composer, 6);
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
            Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM6062constructorimpl.getInserting() || !Intrinsics.areEqual(composerM6062constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, -407735110, "C101@5232L9:Row.kt#2w3rfo");
            function3.invoke(RowScopeInstance.INSTANCE, composer, 6);
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

    /* JADX WARN: Code duplicated, block: B:47:0x0082  */
    /* JADX WARN: Code duplicated, block: B:49:0x008a  */
    /* JADX WARN: Code duplicated, block: B:50:0x008d  */
    /* JADX WARN: Code duplicated, block: B:52:0x0091  */
    /* JADX WARN: Code duplicated, block: B:55:0x0099  */
    /* JADX WARN: Code duplicated, block: B:56:0x009b  */
    /* JADX WARN: Code duplicated, block: B:59:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:71:0x00cd A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:72:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:73:0x00d4  */
    /* JADX WARN: Code duplicated, block: B:76:0x00d9  */
    /* JADX WARN: Code duplicated, block: B:79:0x00e9  */
    /* JADX WARN: Code duplicated, block: B:81:0x00f6  */
    /* JADX WARN: Code duplicated, block: B:82:0x0102  */
    /* JADX WARN: Code duplicated, block: B:86:0x0113  */
    /* JADX WARN: Code duplicated, block: B:89:0x013f  */
    /* JADX WARN: Code duplicated, block: B:91:0x0147  */
    /* JADX WARN: Code duplicated, block: B:94:0x0156  */
    /* JADX WARN: Code duplicated, block: B:96:? A[RETURN, SYNTHETIC] */
    /* JADX INFO: renamed from: BottomNavigation-PEIptTM, reason: not valid java name */
    public static final void m2281BottomNavigationPEIptTM(Modifier modifier, long j, long j2, float f, final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        long primarySurface;
        long jM2360contentColorForek8zF_U;
        float f2;
        boolean z;
        Composer composer2;
        final Modifier modifier3;
        final long j3;
        final long j4;
        final float f3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        long j5;
        float fM2277getElevationD9Ej5fM;
        long j6;
        int i4;
        Composer composerStartRestartGroup = composer.startRestartGroup(783675913);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BottomNavigation)N(modifier,backgroundColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,elevation:c#ui.unit.Dp,content)162@6934L89:BottomNavigation.kt#jmzs0o");
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
                primarySurface = j;
                int i6 = composerStartRestartGroup.changed(primarySurface) ? 32 : 16;
                i3 |= i6;
            } else {
                primarySurface = j;
            }
            i3 |= i6;
        } else {
            primarySurface = j;
        }
        if ((i & 384) == 0) {
            jM2360contentColorForek8zF_U = j2;
            i3 |= ((i2 & 4) == 0 && composerStartRestartGroup.changed(jM2360contentColorForek8zF_U)) ? 256 : 128;
        } else {
            jM2360contentColorForek8zF_U = j2;
        }
        int i7 = i2 & 8;
        if (i7 == 0) {
            if ((i & 3072) == 0) {
                f2 = f;
                i3 |= composerStartRestartGroup.changed(f2) ? 2048 : 1024;
            }
            if ((i & 24576) != 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i4 = 16384;
                } else {
                    i4 = 8192;
                }
                i3 |= i4;
            }
            if ((i3 & 9363) != 9362) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "157@6741L6,158@6790L32");
                int i8 = 6;
                if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                    if (i5 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if ((i2 & 2) != 0) {
                        primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                        i3 &= -113;
                    }
                    if ((i2 & 4) != 0) {
                        jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 3) & 14);
                        i3 &= -897;
                    }
                    if (i7 != 0) {
                        j5 = jM2360contentColorForek8zF_U;
                        fM2277getElevationD9Ej5fM = BottomNavigationDefaults.INSTANCE.m2277getElevationD9Ej5fM();
                    } else {
                        j5 = jM2360contentColorForek8zF_U;
                        fM2277getElevationD9Ej5fM = f2;
                    }
                    j6 = primarySurface;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    if ((i2 & 2) != 0) {
                        i3 &= -113;
                    }
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                    }
                    fM2277getElevationD9Ej5fM = f2;
                    i8 = 6;
                    j6 = primarySurface;
                    j5 = jM2360contentColorForek8zF_U;
                    companion = modifier2;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(783675913, i3, -1, "androidx.compose.material.BottomNavigation (BottomNavigation.kt:161)");
                }
                int i9 = i3 << 3;
                composer2 = composerStartRestartGroup;
                m2282BottomNavigation_UMDTes(ZeroInsets, companion, j6, j5, fM2277getElevationD9Ej5fM, function3, composer2, i8 | (i9 & 112) | (i9 & 896) | (i9 & 7168) | (57344 & i9) | (i9 & 458752), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = companion;
                j3 = j6;
                j4 = j5;
                f3 = fM2277getElevationD9Ej5fM;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier3 = modifier2;
                j3 = primarySurface;
                j4 = jM2360contentColorForek8zF_U;
                f3 = f2;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.BottomNavigationKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return BottomNavigationKt.BottomNavigation_PEIptTM$lambda$0(modifier3, j3, j4, f3, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 3072;
        f2 = f;
        if ((i & 24576) != 0) {
            if (composerStartRestartGroup.changedInstance(function3)) {
                i4 = 16384;
            } else {
                i4 = 8192;
            }
            i3 |= i4;
        }
        if ((i3 & 9363) != 9362) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "157@6741L6,158@6790L32");
            int i10 = 6;
            if ((i & 1) != 0) {
                if (i5 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if ((i2 & 2) != 0) {
                    primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                    i3 &= -113;
                }
                if ((i2 & 4) != 0) {
                    jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 3) & 14);
                    i3 &= -897;
                }
                if (i7 != 0) {
                    j5 = jM2360contentColorForek8zF_U;
                    fM2277getElevationD9Ej5fM = BottomNavigationDefaults.INSTANCE.m2277getElevationD9Ej5fM();
                } else {
                    j5 = jM2360contentColorForek8zF_U;
                    fM2277getElevationD9Ej5fM = f2;
                }
                j6 = primarySurface;
            } else {
                if (i5 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if ((i2 & 2) != 0) {
                    primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6));
                    i3 &= -113;
                }
                if ((i2 & 4) != 0) {
                    jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(primarySurface, composerStartRestartGroup, (i3 >> 3) & 14);
                    i3 &= -897;
                }
                if (i7 != 0) {
                    j5 = jM2360contentColorForek8zF_U;
                    fM2277getElevationD9Ej5fM = BottomNavigationDefaults.INSTANCE.m2277getElevationD9Ej5fM();
                } else {
                    j5 = jM2360contentColorForek8zF_U;
                    fM2277getElevationD9Ej5fM = f2;
                }
                j6 = primarySurface;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(783675913, i3, -1, "androidx.compose.material.BottomNavigation (BottomNavigation.kt:161)");
            }
            int i11 = i3 << 3;
            composer2 = composerStartRestartGroup;
            m2282BottomNavigation_UMDTes(ZeroInsets, companion, j6, j5, fM2277getElevationD9Ej5fM, function3, composer2, i10 | (i11 & 112) | (i11 & 896) | (i11 & 7168) | (57344 & i11) | (i11 & 458752), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = companion;
            j3 = j6;
            j4 = j5;
            f3 = fM2277getElevationD9Ej5fM;
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            modifier3 = modifier2;
            j3 = primarySurface;
            j4 = jM2360contentColorForek8zF_U;
            f3 = f2;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.BottomNavigationKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BottomNavigationKt.BottomNavigation_PEIptTM$lambda$0(modifier3, j3, j4, f3, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0121  */
    /* JADX WARN: Code duplicated, block: B:103:0x0129  */
    /* JADX WARN: Code duplicated, block: B:105:0x012d  */
    /* JADX WARN: Code duplicated, block: B:108:0x013f  */
    /* JADX WARN: Code duplicated, block: B:112:0x0147  */
    /* JADX WARN: Code duplicated, block: B:115:0x0150  */
    /* JADX WARN: Code duplicated, block: B:117:0x0161  */
    /* JADX WARN: Code duplicated, block: B:128:0x018f A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:129:0x0191  */
    /* JADX WARN: Code duplicated, block: B:130:0x0196  */
    /* JADX WARN: Code duplicated, block: B:132:0x0199  */
    /* JADX WARN: Code duplicated, block: B:134:0x019c  */
    /* JADX WARN: Code duplicated, block: B:135:0x019f  */
    /* JADX WARN: Code duplicated, block: B:137:0x01a3  */
    /* JADX WARN: Code duplicated, block: B:138:0x01a5  */
    /* JADX WARN: Code duplicated, block: B:140:0x01a9  */
    /* JADX WARN: Code duplicated, block: B:141:0x01ac  */
    /* JADX WARN: Code duplicated, block: B:144:0x01b2  */
    /* JADX WARN: Code duplicated, block: B:145:0x01d2  */
    /* JADX WARN: Code duplicated, block: B:148:0x01d8  */
    /* JADX WARN: Code duplicated, block: B:149:0x01fd  */
    /* JADX WARN: Code duplicated, block: B:152:0x020a  */
    /* JADX WARN: Code duplicated, block: B:155:0x0216  */
    /* JADX WARN: Code duplicated, block: B:156:0x0222  */
    /* JADX WARN: Code duplicated, block: B:159:0x02d2  */
    /* JADX WARN: Code duplicated, block: B:162:0x02de  */
    /* JADX WARN: Code duplicated, block: B:163:0x02e2  */
    /* JADX WARN: Code duplicated, block: B:166:0x0307  */
    /* JADX WARN: Code duplicated, block: B:168:0x0315  */
    /* JADX WARN: Code duplicated, block: B:171:0x038a  */
    /* JADX WARN: Code duplicated, block: B:173:0x0397  */
    /* JADX WARN: Code duplicated, block: B:176:0x03ad  */
    /* JADX WARN: Code duplicated, block: B:178:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:46:0x0084  */
    /* JADX WARN: Code duplicated, block: B:47:0x0086  */
    /* JADX WARN: Code duplicated, block: B:49:0x0089  */
    /* JADX WARN: Code duplicated, block: B:51:0x0091  */
    /* JADX WARN: Code duplicated, block: B:52:0x0094  */
    /* JADX WARN: Code duplicated, block: B:57:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:58:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:60:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:62:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:63:0x00b4  */
    /* JADX WARN: Code duplicated, block: B:67:0x00be  */
    /* JADX WARN: Code duplicated, block: B:68:0x00c3  */
    /* JADX WARN: Code duplicated, block: B:70:0x00c9  */
    /* JADX WARN: Code duplicated, block: B:72:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:73:0x00d2  */
    /* JADX WARN: Code duplicated, block: B:77:0x00dc  */
    /* JADX WARN: Code duplicated, block: B:78:0x00e1  */
    /* JADX WARN: Code duplicated, block: B:80:0x00e7  */
    /* JADX WARN: Code duplicated, block: B:82:0x00ed  */
    /* JADX WARN: Code duplicated, block: B:83:0x00f0  */
    /* JADX WARN: Code duplicated, block: B:87:0x00fa  */
    /* JADX WARN: Code duplicated, block: B:89:0x00fe  */
    /* JADX WARN: Code duplicated, block: B:91:0x0107  */
    /* JADX WARN: Code duplicated, block: B:92:0x010a  */
    /* JADX WARN: Code duplicated, block: B:95:0x0112  */
    /* JADX WARN: Code duplicated, block: B:98:0x0119  */
    /* JADX INFO: renamed from: BottomNavigationItem-jY6E1Zs, reason: not valid java name */
    public static final void m2283BottomNavigationItemjY6E1Zs(final RowScope rowScope, final boolean z, final Function0<Unit> function0, final Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, boolean z2, final Function2<? super Composer, ? super Integer, Unit> function3, boolean z3, MutableInteractionSource mutableInteractionSource, long j, long j2, Composer composer, final int i, final int i2, final int i3) {
        int i4;
        boolean z4;
        Function0<Unit> function1;
        Modifier modifier2;
        int i5;
        boolean z5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        boolean z6;
        Composer composer2;
        final Function2<? super Composer, ? super Integer, Unit> function4;
        final boolean z7;
        final MutableInteractionSource mutableInteractionSource2;
        final Modifier modifier3;
        final boolean z8;
        final long j3;
        final long j4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        ComposableLambda composableLambdaRememberComposableLambda;
        Modifier.Companion companion;
        final boolean z9;
        int i16;
        int currentCompositeKeyHash;
        Function0<ComposeUiNode> constructor;
        Composer composerM6062constructorimpl;
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash;
        int i17;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1744464261);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BottomNavigationItem)N(selected,onClick,icon,modifier,enabled,label,alwaysShowLabel,interactionSource,selectedContentColor:c#ui.graphics.Color,unselectedContentColor:c#ui.graphics.Color)221@10008L773:BottomNavigation.kt#jmzs0o");
        if ((i & 6) == 0) {
            i4 = (composerStartRestartGroup.changed(rowScope) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        if ((i & 48) == 0) {
            z4 = z;
            i4 |= composerStartRestartGroup.changed(z4) ? 32 : 16;
        } else {
            z4 = z;
        }
        if ((i & 384) == 0) {
            function1 = function0;
            i4 |= composerStartRestartGroup.changedInstance(function1) ? 256 : 128;
        } else {
            function1 = function0;
        }
        if ((i & 3072) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(function2) ? 2048 : 1024;
        }
        int i18 = i3 & 8;
        if (i18 == 0) {
            if ((i & 24576) == 0) {
                modifier2 = modifier;
                i4 |= composerStartRestartGroup.changed(modifier2) ? 16384 : 8192;
            }
            i5 = i3 & 16;
            if (i5 != 0) {
                if ((196608 & i) == 0) {
                    z5 = z2;
                    if (composerStartRestartGroup.changed(z5)) {
                        i6 = 131072;
                    } else {
                        i6 = 65536;
                    }
                    i4 |= i6;
                }
                i7 = i3 & 32;
                if (i7 != 0) {
                    i4 |= 1572864;
                } else if ((i & 1572864) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i8 = 1048576;
                    } else {
                        i8 = 524288;
                    }
                    i4 |= i8;
                }
                i9 = i3 & 64;
                if (i9 != 0) {
                    i4 |= 12582912;
                } else if ((i & 12582912) == 0) {
                    if (composerStartRestartGroup.changed(z3)) {
                        i10 = 8388608;
                    } else {
                        i10 = 4194304;
                    }
                    i4 |= i10;
                }
                i11 = i3 & 128;
                if (i11 != 0) {
                    i4 |= 100663296;
                } else if ((i & 100663296) == 0) {
                    if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                        i12 = 67108864;
                    } else {
                        i12 = 33554432;
                    }
                    i4 |= i12;
                }
                if ((i & 805306368) == 0) {
                    if ((i3 & 256) == 0) {
                        i13 = i11;
                        int i19 = composerStartRestartGroup.changed(j) ? C.BUFFER_FLAG_LAST_SAMPLE : 268435456;
                        i4 |= i19;
                    } else {
                        i13 = i11;
                    }
                    i4 |= i19;
                } else {
                    i13 = i11;
                }
                if ((i2 & 6) == 0) {
                    if ((i3 & 512) == 0 || !composerStartRestartGroup.changed(j2)) {
                        i17 = 2;
                    } else {
                        i17 = 4;
                    }
                    i14 = i2 | i17;
                } else {
                    i14 = i2;
                }
                i15 = i14;
                if ((i4 & 306783379) == 306783378 || (i15 & 3) != 2) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z6, i4 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "206@9325L7,207@9417L6");
                    composableLambdaRememberComposableLambda = null;
                    if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                        if (i18 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i5 != 0) {
                            z5 = true;
                        }
                        if (i7 != 0) {
                            function3 = null;
                        } else {
                            function3 = function3;
                        }
                        if (i9 != 0) {
                            z9 = true;
                        } else {
                            z9 = z3;
                        }
                        if (i13 != 0) {
                            mutableInteractionSource = null;
                        } else {
                            mutableInteractionSource = mutableInteractionSource;
                        }
                        if ((i3 & 256) != 0) {
                            ProvidableCompositionLocal<Color> localContentColor = ContentColorKt.getLocalContentColor();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                            Object objConsume = composerStartRestartGroup.consume(localContentColor);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            j = ((Color) objConsume).m6824unboximpl();
                            i4 &= -1879048193;
                        } else {
                            j = j;
                        }
                        if ((i3 & 512) != 0) {
                            j2 = Color.m6813copywmQWz5c$default(j, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                            i16 = i15 & (-15);
                        } else {
                            j2 = j2;
                            i16 = i15;
                        }
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        if ((i3 & 256) != 0) {
                            i4 &= -1879048193;
                        }
                        i16 = (i3 & 512) != 0 ? i15 & (-15) : i15;
                        companion = modifier2;
                        z9 = z3;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1744464261, i4, i16, "androidx.compose.material.BottomNavigationItem (BottomNavigation.kt:208)");
                    }
                    if (function3 == null) {
                        composerStartRestartGroup.startReplaceGroup(-229974730);
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-229974729);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "*211@9524L168");
                        composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(2120789583, true, new Function2() { // from class: androidx.compose.material.BottomNavigationKt$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return BottomNavigationKt.BottomNavigationItem_jY6E1Zs$lambda$0$0(function3, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                        composerStartRestartGroup.endReplaceGroup();
                    }
                    final ComposableLambda composableLambda = composableLambdaRememberComposableLambda;
                    Modifier modifier4 = companion;
                    Modifier modifierWeight$default = RowScope.weight$default(rowScope, SelectableKt.m1533selectableO2vRcR0(modifier4, z4, mutableInteractionSource, RippleKt.m2523rippleH2RKhps$default(false, 0.0f, j, 2, null), z5, Role.m8825boximpl(Role.INSTANCE.m8839getTabo7Vup1c()), function1), 1.0f, false, 2, null);
                    Alignment center = Alignment.INSTANCE.getCenter();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
                    int i20 = i16;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierWeight$default);
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
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1642075038, "C234@10470L305,234@10387L388:BottomNavigation.kt#jmzs0o");
                    m2284BottomNavigationTransitionKlgxPg(j, j2, z, ComposableLambdaKt.rememberComposableLambda(2011119551, true, new Function3() { // from class: androidx.compose.material.BottomNavigationKt$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return BottomNavigationKt.BottomNavigationItem_jY6E1Zs$lambda$1$0(z9, function2, composableLambda, ((Float) obj).floatValue(), (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i4 >> 27) & 14) | 3072 | ((i20 << 3) & 112) | ((i4 << 3) & 896));
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
                    modifier3 = modifier4;
                    function4 = function3;
                    z7 = z9;
                    mutableInteractionSource2 = mutableInteractionSource;
                    z8 = z5;
                    j4 = j2;
                    j3 = j;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    function4 = function3;
                    z7 = z3;
                    mutableInteractionSource2 = mutableInteractionSource;
                    modifier3 = modifier2;
                    z8 = z5;
                    j3 = j;
                    j4 = j2;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.BottomNavigationKt$$ExternalSyntheticLambda8
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return BottomNavigationKt.BottomNavigationItem_jY6E1Zs$lambda$2(rowScope, z, function0, function2, modifier3, z8, function4, z7, mutableInteractionSource2, j3, j4, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            z5 = z2;
            i7 = i3 & 32;
            if (i7 != 0) {
                i4 |= 1572864;
            } else if ((i & 1572864) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i8 = 1048576;
                } else {
                    i8 = 524288;
                }
                i4 |= i8;
            }
            i9 = i3 & 64;
            if (i9 != 0) {
                i4 |= 12582912;
            } else if ((i & 12582912) == 0) {
                if (composerStartRestartGroup.changed(z3)) {
                    i10 = 8388608;
                } else {
                    i10 = 4194304;
                }
                i4 |= i10;
            }
            i11 = i3 & 128;
            if (i11 != 0) {
                i4 |= 100663296;
            } else if ((i & 100663296) == 0) {
                if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                    i12 = 67108864;
                } else {
                    i12 = 33554432;
                }
                i4 |= i12;
            }
            if ((i & 805306368) == 0) {
                if ((i3 & 256) == 0) {
                    i13 = i11;
                    if (composerStartRestartGroup.changed(j)) {
                    }
                    i4 |= i19;
                } else {
                    i13 = i11;
                }
                i4 |= i19;
            } else {
                i13 = i11;
            }
            if ((i2 & 6) == 0) {
                if ((i3 & 512) == 0) {
                    i17 = 2;
                } else {
                    i17 = 2;
                }
                i14 = i2 | i17;
            } else {
                i14 = i2;
            }
            i15 = i14;
            if ((i4 & 306783379) == 306783378) {
                z6 = true;
            } else {
                z6 = true;
            }
            if (composerStartRestartGroup.shouldExecute(z6, i4 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "206@9325L7,207@9417L6");
                composableLambdaRememberComposableLambda = null;
                if ((i & 1) != 0) {
                    if (i18 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i5 != 0) {
                        z5 = true;
                    }
                    if (i7 != 0) {
                        function3 = null;
                    } else {
                        function3 = function3;
                    }
                    if (i9 != 0) {
                        z9 = true;
                    } else {
                        z9 = z3;
                    }
                    if (i13 != 0) {
                        mutableInteractionSource = null;
                    } else {
                        mutableInteractionSource = mutableInteractionSource;
                    }
                    if ((i3 & 256) != 0) {
                        ProvidableCompositionLocal<Color> localContentColor2 = ContentColorKt.getLocalContentColor();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object objConsume2 = composerStartRestartGroup.consume(localContentColor2);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        j = ((Color) objConsume2).m6824unboximpl();
                        i4 &= -1879048193;
                    } else {
                        j = j;
                    }
                    if ((i3 & 512) != 0) {
                        j2 = Color.m6813copywmQWz5c$default(j, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                        i16 = i15 & (-15);
                    } else {
                        j2 = j2;
                        i16 = i15;
                    }
                } else {
                    if (i18 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i5 != 0) {
                        z5 = true;
                    }
                    if (i7 != 0) {
                        function3 = null;
                    } else {
                        function3 = function3;
                    }
                    if (i9 != 0) {
                        z9 = true;
                    } else {
                        z9 = z3;
                    }
                    if (i13 != 0) {
                        mutableInteractionSource = null;
                    } else {
                        mutableInteractionSource = mutableInteractionSource;
                    }
                    if ((i3 & 256) != 0) {
                        ProvidableCompositionLocal<Color> localContentColor3 = ContentColorKt.getLocalContentColor();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object objConsume3 = composerStartRestartGroup.consume(localContentColor3);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        j = ((Color) objConsume3).m6824unboximpl();
                        i4 &= -1879048193;
                    } else {
                        j = j;
                    }
                    if ((i3 & 512) != 0) {
                        j2 = Color.m6813copywmQWz5c$default(j, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                        i16 = i15 & (-15);
                    } else {
                        j2 = j2;
                        i16 = i15;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1744464261, i4, i16, "androidx.compose.material.BottomNavigationItem (BottomNavigation.kt:208)");
                }
                if (function3 == null) {
                    composerStartRestartGroup.startReplaceGroup(-229974730);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(-229974729);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "*211@9524L168");
                    composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(2120789583, true, new Function2() { // from class: androidx.compose.material.BottomNavigationKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return BottomNavigationKt.BottomNavigationItem_jY6E1Zs$lambda$0$0(function3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54);
                    composerStartRestartGroup.endReplaceGroup();
                }
                final Function2 composableLambda2 = composableLambdaRememberComposableLambda;
                Modifier modifier5 = companion;
                Modifier modifierWeight$default2 = RowScope.weight$default(rowScope, SelectableKt.m1533selectableO2vRcR0(modifier5, z4, mutableInteractionSource, RippleKt.m2523rippleH2RKhps$default(false, 0.0f, j, 2, null), z5, Role.m8825boximpl(Role.INSTANCE.m8839getTabo7Vup1c()), function1), 1.0f, false, 2, null);
                Alignment center2 = Alignment.INSTANCE.getCenter();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(center2, false);
                int i21 = i16;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierWeight$default2);
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
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1642075038, "C234@10470L305,234@10387L388:BottomNavigation.kt#jmzs0o");
                m2284BottomNavigationTransitionKlgxPg(j, j2, z, ComposableLambdaKt.rememberComposableLambda(2011119551, true, new Function3() { // from class: androidx.compose.material.BottomNavigationKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return BottomNavigationKt.BottomNavigationItem_jY6E1Zs$lambda$1$0(z9, function2, composableLambda2, ((Float) obj).floatValue(), (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i4 >> 27) & 14) | 3072 | ((i21 << 3) & 112) | ((i4 << 3) & 896));
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
                modifier3 = modifier5;
                function4 = function3;
                z7 = z9;
                mutableInteractionSource2 = mutableInteractionSource;
                z8 = z5;
                j4 = j2;
                j3 = j;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                function4 = function3;
                z7 = z3;
                mutableInteractionSource2 = mutableInteractionSource;
                modifier3 = modifier2;
                z8 = z5;
                j3 = j;
                j4 = j2;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.BottomNavigationKt$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return BottomNavigationKt.BottomNavigationItem_jY6E1Zs$lambda$2(rowScope, z, function0, function2, modifier3, z8, function4, z7, mutableInteractionSource2, j3, j4, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i4 |= 24576;
        modifier2 = modifier;
        i5 = i3 & 16;
        if (i5 != 0) {
            if ((196608 & i) == 0) {
                z5 = z2;
                if (composerStartRestartGroup.changed(z5)) {
                    i6 = 131072;
                } else {
                    i6 = 65536;
                }
                i4 |= i6;
            }
            i7 = i3 & 32;
            if (i7 != 0) {
                i4 |= 1572864;
            } else if ((i & 1572864) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i8 = 1048576;
                } else {
                    i8 = 524288;
                }
                i4 |= i8;
            }
            i9 = i3 & 64;
            if (i9 != 0) {
                i4 |= 12582912;
            } else if ((i & 12582912) == 0) {
                if (composerStartRestartGroup.changed(z3)) {
                    i10 = 8388608;
                } else {
                    i10 = 4194304;
                }
                i4 |= i10;
            }
            i11 = i3 & 128;
            if (i11 != 0) {
                i4 |= 100663296;
            } else if ((i & 100663296) == 0) {
                if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                    i12 = 67108864;
                } else {
                    i12 = 33554432;
                }
                i4 |= i12;
            }
            if ((i & 805306368) == 0) {
                if ((i3 & 256) == 0) {
                    i13 = i11;
                    if (composerStartRestartGroup.changed(j)) {
                    }
                    i4 |= i19;
                } else {
                    i13 = i11;
                }
                i4 |= i19;
            } else {
                i13 = i11;
            }
            if ((i2 & 6) == 0) {
                if ((i3 & 512) == 0) {
                    i17 = 2;
                } else {
                    i17 = 2;
                }
                i14 = i2 | i17;
            } else {
                i14 = i2;
            }
            i15 = i14;
            if ((i4 & 306783379) == 306783378) {
                z6 = true;
            } else {
                z6 = true;
            }
            if (composerStartRestartGroup.shouldExecute(z6, i4 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "206@9325L7,207@9417L6");
                composableLambdaRememberComposableLambda = null;
                if ((i & 1) != 0) {
                    if (i18 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i5 != 0) {
                        z5 = true;
                    }
                    if (i7 != 0) {
                        function3 = null;
                    } else {
                        function3 = function3;
                    }
                    if (i9 != 0) {
                        z9 = true;
                    } else {
                        z9 = z3;
                    }
                    if (i13 != 0) {
                        mutableInteractionSource = null;
                    } else {
                        mutableInteractionSource = mutableInteractionSource;
                    }
                    if ((i3 & 256) != 0) {
                        ProvidableCompositionLocal<Color> localContentColor4 = ContentColorKt.getLocalContentColor();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object objConsume4 = composerStartRestartGroup.consume(localContentColor4);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        j = ((Color) objConsume4).m6824unboximpl();
                        i4 &= -1879048193;
                    } else {
                        j = j;
                    }
                    if ((i3 & 512) != 0) {
                        j2 = Color.m6813copywmQWz5c$default(j, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                        i16 = i15 & (-15);
                    } else {
                        j2 = j2;
                        i16 = i15;
                    }
                } else {
                    if (i18 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i5 != 0) {
                        z5 = true;
                    }
                    if (i7 != 0) {
                        function3 = null;
                    } else {
                        function3 = function3;
                    }
                    if (i9 != 0) {
                        z9 = true;
                    } else {
                        z9 = z3;
                    }
                    if (i13 != 0) {
                        mutableInteractionSource = null;
                    } else {
                        mutableInteractionSource = mutableInteractionSource;
                    }
                    if ((i3 & 256) != 0) {
                        ProvidableCompositionLocal<Color> localContentColor5 = ContentColorKt.getLocalContentColor();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object objConsume5 = composerStartRestartGroup.consume(localContentColor5);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        j = ((Color) objConsume5).m6824unboximpl();
                        i4 &= -1879048193;
                    } else {
                        j = j;
                    }
                    if ((i3 & 512) != 0) {
                        j2 = Color.m6813copywmQWz5c$default(j, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                        i16 = i15 & (-15);
                    } else {
                        j2 = j2;
                        i16 = i15;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1744464261, i4, i16, "androidx.compose.material.BottomNavigationItem (BottomNavigation.kt:208)");
                }
                if (function3 == null) {
                    composerStartRestartGroup.startReplaceGroup(-229974730);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(-229974729);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "*211@9524L168");
                    composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(2120789583, true, new Function2() { // from class: androidx.compose.material.BottomNavigationKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return BottomNavigationKt.BottomNavigationItem_jY6E1Zs$lambda$0$0(function3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54);
                    composerStartRestartGroup.endReplaceGroup();
                }
                final Function2 composableLambda3 = composableLambdaRememberComposableLambda;
                Modifier modifier6 = companion;
                Modifier modifierWeight$default3 = RowScope.weight$default(rowScope, SelectableKt.m1533selectableO2vRcR0(modifier6, z4, mutableInteractionSource, RippleKt.m2523rippleH2RKhps$default(false, 0.0f, j, 2, null), z5, Role.m8825boximpl(Role.INSTANCE.m8839getTabo7Vup1c()), function1), 1.0f, false, 2, null);
                Alignment center3 = Alignment.INSTANCE.getCenter();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(center3, false);
                int i22 = i16;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierWeight$default3);
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
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1642075038, "C234@10470L305,234@10387L388:BottomNavigation.kt#jmzs0o");
                m2284BottomNavigationTransitionKlgxPg(j, j2, z, ComposableLambdaKt.rememberComposableLambda(2011119551, true, new Function3() { // from class: androidx.compose.material.BottomNavigationKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return BottomNavigationKt.BottomNavigationItem_jY6E1Zs$lambda$1$0(z9, function2, composableLambda3, ((Float) obj).floatValue(), (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i4 >> 27) & 14) | 3072 | ((i22 << 3) & 112) | ((i4 << 3) & 896));
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
                modifier3 = modifier6;
                function4 = function3;
                z7 = z9;
                mutableInteractionSource2 = mutableInteractionSource;
                z8 = z5;
                j4 = j2;
                j3 = j;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                function4 = function3;
                z7 = z3;
                mutableInteractionSource2 = mutableInteractionSource;
                modifier3 = modifier2;
                z8 = z5;
                j3 = j;
                j4 = j2;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.BottomNavigationKt$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return BottomNavigationKt.BottomNavigationItem_jY6E1Zs$lambda$2(rowScope, z, function0, function2, modifier3, z8, function4, z7, mutableInteractionSource2, j3, j4, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        z5 = z2;
        i7 = i3 & 32;
        if (i7 != 0) {
            i4 |= 1572864;
        } else if ((i & 1572864) == 0) {
            if (composerStartRestartGroup.changedInstance(function3)) {
                i8 = 1048576;
            } else {
                i8 = 524288;
            }
            i4 |= i8;
        }
        i9 = i3 & 64;
        if (i9 != 0) {
            i4 |= 12582912;
        } else if ((i & 12582912) == 0) {
            if (composerStartRestartGroup.changed(z3)) {
                i10 = 8388608;
            } else {
                i10 = 4194304;
            }
            i4 |= i10;
        }
        i11 = i3 & 128;
        if (i11 != 0) {
            i4 |= 100663296;
        } else if ((i & 100663296) == 0) {
            if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                i12 = 67108864;
            } else {
                i12 = 33554432;
            }
            i4 |= i12;
        }
        if ((i & 805306368) == 0) {
            if ((i3 & 256) == 0) {
                i13 = i11;
                if (composerStartRestartGroup.changed(j)) {
                }
                i4 |= i19;
            } else {
                i13 = i11;
            }
            i4 |= i19;
        } else {
            i13 = i11;
        }
        if ((i2 & 6) == 0) {
            if ((i3 & 512) == 0) {
                i17 = 2;
            } else {
                i17 = 2;
            }
            i14 = i2 | i17;
        } else {
            i14 = i2;
        }
        i15 = i14;
        if ((i4 & 306783379) == 306783378) {
            z6 = true;
        } else {
            z6 = true;
        }
        if (composerStartRestartGroup.shouldExecute(z6, i4 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "206@9325L7,207@9417L6");
            composableLambdaRememberComposableLambda = null;
            if ((i & 1) != 0) {
                if (i18 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i5 != 0) {
                    z5 = true;
                }
                if (i7 != 0) {
                    function3 = null;
                } else {
                    function3 = function3;
                }
                if (i9 != 0) {
                    z9 = true;
                } else {
                    z9 = z3;
                }
                if (i13 != 0) {
                    mutableInteractionSource = null;
                } else {
                    mutableInteractionSource = mutableInteractionSource;
                }
                if ((i3 & 256) != 0) {
                    ProvidableCompositionLocal<Color> localContentColor6 = ContentColorKt.getLocalContentColor();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume6 = composerStartRestartGroup.consume(localContentColor6);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    j = ((Color) objConsume6).m6824unboximpl();
                    i4 &= -1879048193;
                } else {
                    j = j;
                }
                if ((i3 & 512) != 0) {
                    j2 = Color.m6813copywmQWz5c$default(j, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                    i16 = i15 & (-15);
                } else {
                    j2 = j2;
                    i16 = i15;
                }
            } else {
                if (i18 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i5 != 0) {
                    z5 = true;
                }
                if (i7 != 0) {
                    function3 = null;
                } else {
                    function3 = function3;
                }
                if (i9 != 0) {
                    z9 = true;
                } else {
                    z9 = z3;
                }
                if (i13 != 0) {
                    mutableInteractionSource = null;
                } else {
                    mutableInteractionSource = mutableInteractionSource;
                }
                if ((i3 & 256) != 0) {
                    ProvidableCompositionLocal<Color> localContentColor7 = ContentColorKt.getLocalContentColor();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume7 = composerStartRestartGroup.consume(localContentColor7);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    j = ((Color) objConsume7).m6824unboximpl();
                    i4 &= -1879048193;
                } else {
                    j = j;
                }
                if ((i3 & 512) != 0) {
                    j2 = Color.m6813copywmQWz5c$default(j, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                    i16 = i15 & (-15);
                } else {
                    j2 = j2;
                    i16 = i15;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1744464261, i4, i16, "androidx.compose.material.BottomNavigationItem (BottomNavigation.kt:208)");
            }
            if (function3 == null) {
                composerStartRestartGroup.startReplaceGroup(-229974730);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(-229974729);
                ComposerKt.sourceInformation(composerStartRestartGroup, "*211@9524L168");
                composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(2120789583, true, new Function2() { // from class: androidx.compose.material.BottomNavigationKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return BottomNavigationKt.BottomNavigationItem_jY6E1Zs$lambda$0$0(function3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54);
                composerStartRestartGroup.endReplaceGroup();
            }
            final Function2 composableLambda4 = composableLambdaRememberComposableLambda;
            Modifier modifier7 = companion;
            Modifier modifierWeight$default4 = RowScope.weight$default(rowScope, SelectableKt.m1533selectableO2vRcR0(modifier7, z4, mutableInteractionSource, RippleKt.m2523rippleH2RKhps$default(false, 0.0f, j, 2, null), z5, Role.m8825boximpl(Role.INSTANCE.m8839getTabo7Vup1c()), function1), 1.0f, false, 2, null);
            Alignment center4 = Alignment.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy4 = BoxKt.maybeCachedBoxMeasurePolicy(center4, false);
            int i23 = i16;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap4 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierWeight$default4);
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1642075038, "C234@10470L305,234@10387L388:BottomNavigation.kt#jmzs0o");
            m2284BottomNavigationTransitionKlgxPg(j, j2, z, ComposableLambdaKt.rememberComposableLambda(2011119551, true, new Function3() { // from class: androidx.compose.material.BottomNavigationKt$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return BottomNavigationKt.BottomNavigationItem_jY6E1Zs$lambda$1$0(z9, function2, composableLambda4, ((Float) obj).floatValue(), (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i4 >> 27) & 14) | 3072 | ((i23 << 3) & 112) | ((i4 << 3) & 896));
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
            modifier3 = modifier7;
            function4 = function3;
            z7 = z9;
            mutableInteractionSource2 = mutableInteractionSource;
            z8 = z5;
            j4 = j2;
            j3 = j;
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            function4 = function3;
            z7 = z3;
            mutableInteractionSource2 = mutableInteractionSource;
            modifier3 = modifier2;
            z8 = z5;
            j3 = j;
            j4 = j2;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.BottomNavigationKt$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BottomNavigationKt.BottomNavigationItem_jY6E1Zs$lambda$2(rowScope, z, function0, function2, modifier3, z8, function4, z7, mutableInteractionSource2, j3, j4, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BottomNavigationItem_jY6E1Zs$lambda$0$0(Function2 function2, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C212@9568L10,213@9638L40:BottomNavigation.kt#jmzs0o");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2120789583, i, -1, "androidx.compose.material.BottomNavigationItem.<anonymous>.<anonymous> (BottomNavigation.kt:212)");
            }
            TextKt.ProvideTextStyle(TextStyle.m9104copyp1EtxEg$default(MaterialTheme.INSTANCE.getTypography(composer, 6).getCaption(), 0L, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, TextAlign.INSTANCE.m9526getCentere0LSkKk(), 0, 0L, null, null, null, 0, 0, null, 16744447, null), function2, composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BottomNavigationItem_jY6E1Zs$lambda$1$0(boolean z, Function2 function2, Function2 function3, float f, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "CN(progress)238@10583L182:BottomNavigation.kt#jmzs0o");
        if ((i & 6) == 0) {
            i |= composer.changed(f) ? 4 : 2;
        }
        if (!composer.shouldExecute((i & 19) != 18, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2011119551, i, -1, "androidx.compose.material.BottomNavigationItem.<anonymous>.<anonymous> (BottomNavigation.kt:236)");
            }
            if (z) {
                f = 1.0f;
            }
            BottomNavigationItemBaselineLayout(function2, function3, f, composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: BottomNavigationTransition-Klgx-Pg, reason: not valid java name */
    private static final void m2284BottomNavigationTransitionKlgxPg(final long j, final long j2, final boolean z, final Function3<? super Float, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(616920545);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BottomNavigationTransition)N(activeColor:c#ui.graphics.Color,inactiveColor:c#ui.graphics.Color,selected,content)281@12195L141,291@12550L42,288@12411L181:BottomNavigation.kt#jmzs0o");
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
                ComposerKt.traceEventStart(616920545, i2, -1, "androidx.compose.material.BottomNavigationTransition (BottomNavigation.kt:279)");
            }
            final State<Float> stateAnimateFloatAsState = AnimateAsStateKt.animateFloatAsState(z ? 1.0f : 0.0f, BottomNavigationAnimationSpec, 0.0f, null, null, composerStartRestartGroup, 48, 28);
            long jM6865lerpjxsXWHM = ColorKt.m6865lerpjxsXWHM(j2, j, BottomNavigationTransition_Klgx_Pg$lambda$0(stateAnimateFloatAsState));
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m6804boximpl(Color.m6813copywmQWz5c$default(jM6865lerpjxsXWHM, 1.0f, 0.0f, 0.0f, 0.0f, 14, null))), ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.m6816getAlphaimpl(jM6865lerpjxsXWHM)))}, ComposableLambdaKt.rememberComposableLambda(343660833, true, new Function2() { // from class: androidx.compose.material.BottomNavigationKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BottomNavigationKt.BottomNavigationTransition_Klgx_Pg$lambda$1(function3, stateAnimateFloatAsState, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.BottomNavigationKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BottomNavigationKt.BottomNavigationTransition_Klgx_Pg$lambda$2(j, j2, z, function3, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BottomNavigationTransition_Klgx_Pg$lambda$1(Function3 function3, State state, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C292@12560L26:BottomNavigation.kt#jmzs0o");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(343660833, i, -1, "androidx.compose.material.BottomNavigationTransition.<anonymous> (BottomNavigation.kt:292)");
            }
            function3.invoke(Float.valueOf(BottomNavigationTransition_Klgx_Pg$lambda$0(state)), composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    private static final void BottomNavigationItemBaselineLayout(final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function3, final float f, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1481587758);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BottomNavigationItemBaselineLayout)N(icon,label,iconPositionAnimationProgress)323@13622L928,312@13264L1286:BottomNavigation.kt#jmzs0o");
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
                ComposerKt.traceEventStart(-1481587758, i2, -1, "androidx.compose.material.BottomNavigationItemBaselineLayout (BottomNavigation.kt:311)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2123325490, "CC(remember):BottomNavigation.kt#9igjgp");
            boolean z = ((i2 & 112) == 32) | ((i2 & 896) == 256);
            MeasurePolicy measurePolicyRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z || measurePolicyRememberedValue == Composer.INSTANCE.getEmpty()) {
                measurePolicyRememberedValue = new MeasurePolicy() { // from class: androidx.compose.material.BottomNavigationKt$BottomNavigationItemBaselineLayout$2$1
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
                                    return BottomNavigationKt.m2287placeIcon3p2s80s(measureScope, placeableMo8265measureBRTryo1, j);
                                }
                                Intrinsics.checkNotNull(placeableMo8265measureBRTryo0);
                                return BottomNavigationKt.m2288placeLabelAndIconDIyivk0(measureScope, placeableMo8265measureBRTryo0, placeableMo8265measureBRTryo1, j, f);
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1977638459, "C313@13281L41:BottomNavigation.kt#jmzs0o");
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -430660824, "C313@13314L6:BottomNavigation.kt#jmzs0o");
            function2.invoke(composerStartRestartGroup, Integer.valueOf(i2 & 14));
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (function3 != null) {
                composerStartRestartGroup.startReplaceGroup(1977704767);
                ComposerKt.sourceInformation(composerStartRestartGroup, "315@13364L240");
                Modifier modifierM1220paddingVpY3zN4$default = PaddingKt.m1220paddingVpY3zN4$default(AlphaKt.alpha(LayoutIdKt.layoutId(Modifier.INSTANCE, "label"), f), BottomNavigationItemHorizontalPadding, 0.0f, 2, null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1220paddingVpY3zN4$default);
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
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1599731230, "C320@13583L7:BottomNavigation.kt#jmzs0o");
                function3.invoke(composerStartRestartGroup, Integer.valueOf((i2 >> 3) & 14));
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            } else {
                composerStartRestartGroup.startReplaceGroup(1964452391);
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.BottomNavigationKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BottomNavigationKt.BottomNavigationItemBaselineLayout$lambda$2(function2, function3, f, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: placeIcon-3p2s80s, reason: not valid java name */
    public static final MeasureResult m2287placeIcon3p2s80s(MeasureScope measureScope, final Placeable placeable, long j) {
        int iM9656constrainHeightK40F9xA = ConstraintsKt.m9656constrainHeightK40F9xA(j, measureScope.mo748roundToPx0680j_4(BottomNavigationHeight));
        final int height = (iM9656constrainHeightK40F9xA - placeable.getHeight()) / 2;
        return MeasureScope.layout$default(measureScope, placeable.getWidth(), iM9656constrainHeightK40F9xA, null, new Function1() { // from class: androidx.compose.material.BottomNavigationKt$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BottomNavigationKt.placeIcon_3p2s80s$lambda$0(placeable, height, (Placeable.PlacementScope) obj);
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit placeIcon_3p2s80s$lambda$0(Placeable placeable, int i, Placeable.PlacementScope placementScope) {
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable, 0, i, 0.0f, 4, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: placeLabelAndIcon-DIyivk0, reason: not valid java name */
    public static final MeasureResult m2288placeLabelAndIconDIyivk0(MeasureScope measureScope, final Placeable placeable, final Placeable placeable2, long j, final float f) {
        int i = measureScope.mo748roundToPx0680j_4(CombinedItemTextBaseline) - placeable.get(AlignmentLineKt.getFirstBaseline());
        int height = placeable2.getHeight() + placeable.getHeight() + i;
        int iM9656constrainHeightK40F9xA = ConstraintsKt.m9656constrainHeightK40F9xA(j, Math.max(height, measureScope.mo748roundToPx0680j_4(BottomNavigationHeight)));
        final int iCoerceAtLeast = RangesKt.coerceAtLeast((iM9656constrainHeightK40F9xA - height) / 2, 0);
        int height2 = (iM9656constrainHeightK40F9xA - placeable2.getHeight()) / 2;
        final int height3 = placeable2.getHeight() + iCoerceAtLeast + i;
        int iMax = Math.max(placeable.getWidth(), placeable2.getWidth());
        final int width = (iMax - placeable.getWidth()) / 2;
        final int width2 = (iMax - placeable2.getWidth()) / 2;
        final int iRoundToInt = MathKt.roundToInt((height2 - iCoerceAtLeast) * (1 - f));
        return MeasureScope.layout$default(measureScope, iMax, iM9656constrainHeightK40F9xA, null, new Function1() { // from class: androidx.compose.material.BottomNavigationKt$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BottomNavigationKt.placeLabelAndIcon_DIyivk0$lambda$0(f, placeable, width, height3, iRoundToInt, placeable2, width2, iCoerceAtLeast, (Placeable.PlacementScope) obj);
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
        float f = 12;
        BottomNavigationItemHorizontalPadding = Dp.m9687constructorimpl(f);
        CombinedItemTextBaseline = Dp.m9687constructorimpl(f);
        float f2 = 0;
        ZeroInsets = WindowInsetsKt.m1292WindowInsetsa9UjIt4(Dp.m9687constructorimpl(f2), Dp.m9687constructorimpl(f2), Dp.m9687constructorimpl(f2), Dp.m9687constructorimpl(f2));
    }

    private static final float BottomNavigationTransition_Klgx_Pg$lambda$0(State<Float> state) {
        return state.getValue().floatValue();
    }
}
