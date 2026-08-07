package androidx.compose.material;

import androidx.compose.animation.ColorVectorConverterKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TransitionKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.animation.core.TwoWayConverter;
import androidx.compose.foundation.IndicationNodeFactory;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
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
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.colorspace.ColorSpace;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.profileinstaller.ProfileVerifier;
import com.box.android.domain.metrics.hubs.HubsObservability;
import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Tab.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000n\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0087\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\u0015\b\u0002\u0010\t\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005¢\u0006\u0002\b\n2\u0015\b\u0002\u0010\u000b\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005¢\u0006\u0002\b\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000fH\u0007¢\u0006\u0004\b\u0011\u0010\u0012\u001a\u007f\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\u0011\u0010\t\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\n2\u0011\u0010\u000b\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\n2\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000fH\u0007¢\u0006\u0004\b\u0014\u0010\u0015\u001aw\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\u001c\u0010\u0016\u001a\u0018\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00010\u0017¢\u0006\u0002\b\n¢\u0006\u0002\b\u0019H\u0007¢\u0006\u0004\b\u001a\u0010\u001b\u001a:\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u0002\u001a\u00020\u00032\u0011\u0010\u0016\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\nH\u0003¢\u0006\u0004\b\u001f\u0010 \u001a7\u0010!\u001a\u00020\u00012\u0013\u0010\t\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005¢\u0006\u0002\b\n2\u0013\u0010\u000b\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005¢\u0006\u0002\b\nH\u0003¢\u0006\u0002\u0010\"\u001a\u001c\u0010#\u001a\u00020\u0001*\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(H\u0002\u001aD\u0010)\u001a\u00020\u0001*\u00020$2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020&2\u0006\u0010-\u001a\u00020&2\u0006\u0010.\u001a\u00020(2\u0006\u0010'\u001a\u00020(2\u0006\u0010/\u001a\u00020(2\u0006\u00100\u001a\u00020(H\u0002\"\u0010\u00101\u001a\u000202X\u0082\u0004¢\u0006\u0004\n\u0002\u00103\"\u0010\u00104\u001a\u000202X\u0082\u0004¢\u0006\u0004\n\u0002\u00103\"\u000e\u00105\u001a\u00020(X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u00106\u001a\u00020(X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u00107\u001a\u00020(X\u0082T¢\u0006\u0002\n\u0000\"\u0010\u00108\u001a\u000202X\u0082\u0004¢\u0006\u0004\n\u0002\u00103\"\u0010\u00109\u001a\u000202X\u0082\u0004¢\u0006\u0004\n\u0002\u00103\"\u0010\u0010:\u001a\u000202X\u0082\u0004¢\u0006\u0004\n\u0002\u00103\"\u0010\u0010;\u001a\u00020<X\u0082\u0004¢\u0006\u0004\n\u0002\u0010=\"\u0010\u0010>\u001a\u000202X\u0082\u0004¢\u0006\u0004\n\u0002\u00103¨\u0006?²\u0006\n\u0010@\u001a\u00020\u000fX\u008a\u0084\u0002"}, d2 = {"Tab", "", "selected", "", ViewProps.ON_CLICK, "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "text", "Landroidx/compose/runtime/Composable;", HubsObservability.HUB_ASSET_ICON, "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "selectedContentColor", "Landroidx/compose/ui/graphics/Color;", "unselectedContentColor", "Tab-0nD-MI0", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/interaction/MutableInteractionSource;JJLandroidx/compose/runtime/Composer;II)V", "LeadingIconTab", "LeadingIconTab-0nD-MI0", "(ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;JJLandroidx/compose/runtime/Composer;II)V", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Lkotlin/ExtensionFunctionType;", "Tab-EVJuX4I", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;JJLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "TabTransition", "activeColor", "inactiveColor", "TabTransition-Klgx-Pg", "(JJZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "TabBaselineLayout", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "placeTextOrIcon", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "textOrIconPlaceable", "Landroidx/compose/ui/layout/Placeable;", "tabHeight", "", "placeTextAndIcon", "density", "Landroidx/compose/ui/unit/Density;", "textPlaceable", "iconPlaceable", "tabWidth", "firstBaseline", "lastBaseline", "SmallTabHeight", "Landroidx/compose/ui/unit/Dp;", "F", "LargeTabHeight", "TabFadeInAnimationDuration", "TabFadeInAnimationDelay", "TabFadeOutAnimationDuration", "HorizontalTextPadding", "SingleLineTextBaselineWithIcon", "DoubleLineTextBaselineWithIcon", "IconDistanceFromBaseline", "Landroidx/compose/ui/unit/TextUnit;", "J", "TextDistanceFromLeadingIcon", "material", "color"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class TabKt {
    private static final int TabFadeInAnimationDelay = 100;
    private static final int TabFadeInAnimationDuration = 150;
    private static final int TabFadeOutAnimationDuration = 100;
    private static final float SmallTabHeight = Dp.m9687constructorimpl(48);
    private static final float LargeTabHeight = Dp.m9687constructorimpl(72);
    private static final float HorizontalTextPadding = Dp.m9687constructorimpl(16);
    private static final float SingleLineTextBaselineWithIcon = Dp.m9687constructorimpl(14);
    private static final float DoubleLineTextBaselineWithIcon = Dp.m9687constructorimpl(6);
    private static final long IconDistanceFromBaseline = TextUnitKt.getSp(20);
    private static final float TextDistanceFromLeadingIcon = Dp.m9687constructorimpl(8);

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LeadingIconTab_0nD_MI0$lambda$1(boolean z, Function0 function0, Function2 function2, Function2 function3, Modifier modifier, boolean z2, MutableInteractionSource mutableInteractionSource, long j, long j2, int i, int i2, Composer composer, int i3) {
        m2605LeadingIconTab0nDMI0(z, function0, function2, function3, modifier, z2, mutableInteractionSource, j, j2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TabBaselineLayout$lambda$2(Function2 function2, Function2 function3, int i, Composer composer, int i2) {
        TabBaselineLayout(function2, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TabTransition_Klgx_Pg$lambda$3(long j, long j2, boolean z, Function2 function2, int i, Composer composer, int i2) {
        m2608TabTransitionKlgxPg(j, j2, z, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Tab_0nD_MI0$lambda$2(boolean z, Function0 function0, Modifier modifier, boolean z2, Function2 function2, Function2 function3, MutableInteractionSource mutableInteractionSource, long j, long j2, int i, int i2, Composer composer, int i3) {
        m2606Tab0nDMI0(z, function0, modifier, z2, function2, function3, mutableInteractionSource, j, j2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Tab_EVJuX4I$lambda$1(boolean z, Function0 function0, Modifier modifier, boolean z2, MutableInteractionSource mutableInteractionSource, long j, long j2, Function3 function3, int i, int i2, Composer composer, int i3) {
        m2607TabEVJuX4I(z, function0, modifier, z2, mutableInteractionSource, j, j2, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0138  */
    /* JADX WARN: Code duplicated, block: B:111:0x015f A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:112:0x0161  */
    /* JADX WARN: Code duplicated, block: B:114:0x0168  */
    /* JADX WARN: Code duplicated, block: B:116:0x016b  */
    /* JADX WARN: Code duplicated, block: B:118:0x016f  */
    /* JADX WARN: Code duplicated, block: B:120:0x0173  */
    /* JADX WARN: Code duplicated, block: B:121:0x0176  */
    /* JADX WARN: Code duplicated, block: B:124:0x017c  */
    /* JADX WARN: Code duplicated, block: B:125:0x019c  */
    /* JADX WARN: Code duplicated, block: B:128:0x01a2  */
    /* JADX WARN: Code duplicated, block: B:129:0x01ce  */
    /* JADX WARN: Code duplicated, block: B:133:0x01e7  */
    /* JADX WARN: Code duplicated, block: B:136:0x01f4  */
    /* JADX WARN: Code duplicated, block: B:137:0x01fb  */
    /* JADX WARN: Code duplicated, block: B:140:0x0251  */
    /* JADX WARN: Code duplicated, block: B:142:0x0261  */
    /* JADX WARN: Code duplicated, block: B:145:0x0276  */
    /* JADX WARN: Code duplicated, block: B:147:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:30:0x0056  */
    /* JADX WARN: Code duplicated, block: B:31:0x0059  */
    /* JADX WARN: Code duplicated, block: B:33:0x005d  */
    /* JADX WARN: Code duplicated, block: B:35:0x0065  */
    /* JADX WARN: Code duplicated, block: B:36:0x0068  */
    /* JADX WARN: Code duplicated, block: B:41:0x0072  */
    /* JADX WARN: Code duplicated, block: B:42:0x0075  */
    /* JADX WARN: Code duplicated, block: B:44:0x0079  */
    /* JADX WARN: Code duplicated, block: B:46:0x0081  */
    /* JADX WARN: Code duplicated, block: B:47:0x0084  */
    /* JADX WARN: Code duplicated, block: B:52:0x0090  */
    /* JADX WARN: Code duplicated, block: B:53:0x0092  */
    /* JADX WARN: Code duplicated, block: B:55:0x0095  */
    /* JADX WARN: Code duplicated, block: B:57:0x009d  */
    /* JADX WARN: Code duplicated, block: B:58:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:63:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:64:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:66:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:68:0x00bd  */
    /* JADX WARN: Code duplicated, block: B:69:0x00c0  */
    /* JADX WARN: Code duplicated, block: B:73:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:75:0x00ce  */
    /* JADX WARN: Code duplicated, block: B:77:0x00d9  */
    /* JADX WARN: Code duplicated, block: B:78:0x00dc  */
    /* JADX WARN: Code duplicated, block: B:81:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:84:0x00f1  */
    /* JADX WARN: Code duplicated, block: B:86:0x00f9  */
    /* JADX WARN: Code duplicated, block: B:89:0x0102  */
    /* JADX WARN: Code duplicated, block: B:91:0x0107  */
    /* JADX WARN: Code duplicated, block: B:94:0x0118  */
    /* JADX WARN: Code duplicated, block: B:95:0x011a  */
    /* JADX WARN: Code duplicated, block: B:98:0x0123  */
    /* JADX INFO: renamed from: Tab-0nD-MI0, reason: not valid java name */
    public static final void m2606Tab0nDMI0(final boolean z, final Function0<Unit> function0, Modifier modifier, boolean z2, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function3, MutableInteractionSource mutableInteractionSource, long j, long j2, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        boolean z3;
        int i5;
        int i6;
        final Function2<? super Composer, ? super Integer, Unit> function4;
        int i7;
        int i8;
        final Function2<? super Composer, ? super Integer, Unit> function5;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        boolean z4;
        Composer composer2;
        final MutableInteractionSource mutableInteractionSource2;
        final Modifier modifier3;
        final boolean z5;
        final Function2<? super Composer, ? super Integer, Unit> function6;
        final Function2<? super Composer, ? super Integer, Unit> function7;
        final long j3;
        final long j4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        final ComposableLambda composableLambdaRememberComposableLambda;
        MutableInteractionSource mutableInteractionSource3;
        long jM6824unboximpl;
        long j5;
        long jM6813copywmQWz5c$default;
        int i16;
        boolean z6;
        long j6;
        int i17;
        int i18;
        Composer composerStartRestartGroup = composer.startRestartGroup(-610760526);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Tab)N(selected,onClick,modifier,enabled,text,icon,interactionSource,selectedContentColor:c#ui.graphics.Color,unselectedContentColor:c#ui.graphics.Color)113@4852L65,105@4682L235:Tab.kt#jmzs0o");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function0) ? 32 : 16;
        }
        int i19 = i2 & 4;
        if (i19 == 0) {
            if ((i & 384) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            i4 = i2 & 8;
            if (i4 != 0) {
                if ((i & 3072) == 0) {
                    z3 = z2;
                    if (composerStartRestartGroup.changed(z3)) {
                        i5 = 2048;
                    } else {
                        i5 = 1024;
                    }
                    i3 |= i5;
                }
                i6 = i2 & 16;
                if (i6 != 0) {
                    if ((i & 24576) == 0) {
                        function4 = function2;
                        if (composerStartRestartGroup.changedInstance(function4)) {
                            i7 = 16384;
                        } else {
                            i7 = 8192;
                        }
                        i3 |= i7;
                    }
                    i8 = i2 & 32;
                    if (i8 != 0) {
                        if ((196608 & i) == 0) {
                            function5 = function3;
                            if (composerStartRestartGroup.changedInstance(function5)) {
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
                            if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                                i11 = 1048576;
                            } else {
                                i11 = 524288;
                            }
                            i3 |= i11;
                        }
                        i12 = 12582912;
                        if ((i & 12582912) == 0) {
                            if ((i2 & 128) == 0) {
                                i18 = i3;
                                i14 = i19;
                                int i20 = composerStartRestartGroup.changed(j) ? 8388608 : 4194304;
                                i13 = i18 | i20;
                            } else {
                                i18 = i3;
                                i14 = i19;
                            }
                            i13 = i18 | i20;
                        } else {
                            i13 = i3;
                            i14 = i19;
                        }
                        if ((i & 100663296) == 0) {
                            int i21 = i13;
                            if ((i2 & 256) == 0 || !composerStartRestartGroup.changed(j2)) {
                                i17 = 33554432;
                            } else {
                                i17 = 67108864;
                            }
                            i13 = i21 | i17;
                        }
                        i15 = i13;
                        if ((i15 & 38347923) != 38347922) {
                            z4 = true;
                        } else {
                            z4 = false;
                        }
                        if (composerStartRestartGroup.shouldExecute(z4, i15 & 1)) {
                            composerStartRestartGroup.startDefaults();
                            ComposerKt.sourceInformation(composerStartRestartGroup, "95@4304L7,96@4396L6");
                            composableLambdaRememberComposableLambda = null;
                            if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                if (i14 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                if (i4 != 0) {
                                    z3 = true;
                                }
                                if (i6 != 0) {
                                    function4 = null;
                                }
                                if (i8 != 0) {
                                    function5 = null;
                                }
                                if (i10 != 0) {
                                    mutableInteractionSource3 = null;
                                } else {
                                    mutableInteractionSource3 = mutableInteractionSource;
                                }
                                if ((i2 & 128) != 0) {
                                    ProvidableCompositionLocal<Color> localContentColor = ContentColorKt.getLocalContentColor();
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                    Object objConsume = composerStartRestartGroup.consume(localContentColor);
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                    jM6824unboximpl = ((Color) objConsume).m6824unboximpl();
                                    i15 &= -29360129;
                                } else {
                                    jM6824unboximpl = j;
                                }
                                if ((i2 & 256) != 0) {
                                    long j7 = jM6824unboximpl;
                                    j5 = j7;
                                    i16 = i15 & (-234881025);
                                    jM6813copywmQWz5c$default = Color.m6813copywmQWz5c$default(j7, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                                } else {
                                    j5 = jM6824unboximpl;
                                    jM6813copywmQWz5c$default = j2;
                                    i16 = i15;
                                }
                                z6 = z3;
                                j6 = j5;
                            } else {
                                composerStartRestartGroup.skipToGroupEnd();
                                i16 = (i2 & 128) != 0 ? i15 & (-29360129) : i15;
                                if ((i2 & 256) != 0) {
                                    i16 &= -234881025;
                                }
                                mutableInteractionSource3 = mutableInteractionSource;
                                jM6813copywmQWz5c$default = j2;
                                i12 = 12582912;
                                z6 = z3;
                                j6 = j;
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-610760526, i16, -1, "androidx.compose.material.Tab (Tab.kt:97)");
                            }
                            if (function4 == null) {
                                composerStartRestartGroup.startReplaceGroup(-1684876703);
                            } else {
                                composerStartRestartGroup.startReplaceGroup(-1684876702);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "*100@4501L166");
                                composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1101313667, true, new Function2() { // from class: androidx.compose.material.TabKt$$ExternalSyntheticLambda3
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return TabKt.Tab_0nD_MI0$lambda$0$0(function4, (Composer) obj, ((Integer) obj2).intValue());
                                    }
                                }, composerStartRestartGroup, 54);
                            }
                            composerStartRestartGroup.endReplaceGroup();
                            int i22 = (i16 & 14) | i12 | (i16 & 112) | (i16 & 896) | (i16 & 7168);
                            int i23 = i16 >> 6;
                            composer2 = composerStartRestartGroup;
                            Modifier modifier4 = modifier2;
                            m2607TabEVJuX4I(z, function0, modifier4, z6, mutableInteractionSource3, j6, jM6813copywmQWz5c$default, ComposableLambdaKt.rememberComposableLambda(-1088373601, true, new Function3() { // from class: androidx.compose.material.TabKt$$ExternalSyntheticLambda4
                                @Override // kotlin.jvm.functions.Function3
                                public final Object invoke(Object obj, Object obj2, Object obj3) {
                                    return TabKt.Tab_0nD_MI0$lambda$1(composableLambdaRememberComposableLambda, function5, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                }
                            }, composerStartRestartGroup, 54), composer2, (57344 & i23) | i22 | (458752 & i23) | (i23 & 3670016), 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            function6 = function4;
                            function7 = function5;
                            modifier3 = modifier4;
                            z5 = z6;
                            mutableInteractionSource2 = mutableInteractionSource3;
                            j3 = j6;
                            j4 = jM6813copywmQWz5c$default;
                        } else {
                            composer2 = composerStartRestartGroup;
                            composer2.skipToGroupEnd();
                            mutableInteractionSource2 = mutableInteractionSource;
                            modifier3 = modifier2;
                            z5 = z3;
                            function6 = function4;
                            function7 = function5;
                            j3 = j;
                            j4 = j2;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.TabKt$$ExternalSyntheticLambda5
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return TabKt.Tab_0nD_MI0$lambda$2(z, function0, modifier3, z5, function6, function7, mutableInteractionSource2, j3, j4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                        }
                    }
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    function5 = function3;
                    i10 = i2 & 64;
                    if (i10 != 0) {
                        i3 |= 1572864;
                    } else if ((i & 1572864) == 0) {
                        if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                            i11 = 1048576;
                        } else {
                            i11 = 524288;
                        }
                        i3 |= i11;
                    }
                    i12 = 12582912;
                    if ((i & 12582912) == 0) {
                        if ((i2 & 128) == 0) {
                            i18 = i3;
                            i14 = i19;
                            if (composerStartRestartGroup.changed(j)) {
                            }
                            i13 = i18 | i20;
                        } else {
                            i18 = i3;
                            i14 = i19;
                        }
                        i13 = i18 | i20;
                    } else {
                        i13 = i3;
                        i14 = i19;
                    }
                    if ((i & 100663296) == 0) {
                        int i24 = i13;
                        if ((i2 & 256) == 0) {
                            i17 = 33554432;
                        } else {
                            i17 = 33554432;
                        }
                        i13 = i24 | i17;
                    }
                    i15 = i13;
                    if ((i15 & 38347923) != 38347922) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z4, i15 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "95@4304L7,96@4396L6");
                        composableLambdaRememberComposableLambda = null;
                        if ((i & 1) != 0) {
                            if (i14 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                z3 = true;
                            }
                            if (i6 != 0) {
                                function4 = null;
                            }
                            if (i8 != 0) {
                                function5 = null;
                            }
                            if (i10 != 0) {
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            if ((i2 & 128) != 0) {
                                ProvidableCompositionLocal<Color> localContentColor2 = ContentColorKt.getLocalContentColor();
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                Object objConsume2 = composerStartRestartGroup.consume(localContentColor2);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                jM6824unboximpl = ((Color) objConsume2).m6824unboximpl();
                                i15 &= -29360129;
                            } else {
                                jM6824unboximpl = j;
                            }
                            if ((i2 & 256) != 0) {
                                long j8 = jM6824unboximpl;
                                j5 = j8;
                                i16 = i15 & (-234881025);
                                jM6813copywmQWz5c$default = Color.m6813copywmQWz5c$default(j8, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                            } else {
                                j5 = jM6824unboximpl;
                                jM6813copywmQWz5c$default = j2;
                                i16 = i15;
                            }
                            z6 = z3;
                            j6 = j5;
                        } else {
                            if (i14 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                z3 = true;
                            }
                            if (i6 != 0) {
                                function4 = null;
                            }
                            if (i8 != 0) {
                                function5 = null;
                            }
                            if (i10 != 0) {
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            if ((i2 & 128) != 0) {
                                ProvidableCompositionLocal<Color> localContentColor3 = ContentColorKt.getLocalContentColor();
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                Object objConsume3 = composerStartRestartGroup.consume(localContentColor3);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                jM6824unboximpl = ((Color) objConsume3).m6824unboximpl();
                                i15 &= -29360129;
                            } else {
                                jM6824unboximpl = j;
                            }
                            if ((i2 & 256) != 0) {
                                long j9 = jM6824unboximpl;
                                j5 = j9;
                                i16 = i15 & (-234881025);
                                jM6813copywmQWz5c$default = Color.m6813copywmQWz5c$default(j9, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                            } else {
                                j5 = jM6824unboximpl;
                                jM6813copywmQWz5c$default = j2;
                                i16 = i15;
                            }
                            z6 = z3;
                            j6 = j5;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-610760526, i16, -1, "androidx.compose.material.Tab (Tab.kt:97)");
                        }
                        if (function4 == null) {
                            composerStartRestartGroup.startReplaceGroup(-1684876703);
                        } else {
                            composerStartRestartGroup.startReplaceGroup(-1684876702);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "*100@4501L166");
                            composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1101313667, true, new Function2() { // from class: androidx.compose.material.TabKt$$ExternalSyntheticLambda3
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return TabKt.Tab_0nD_MI0$lambda$0$0(function4, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composerStartRestartGroup, 54);
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        int i25 = (i16 & 14) | i12 | (i16 & 112) | (i16 & 896) | (i16 & 7168);
                        int i26 = i16 >> 6;
                        composer2 = composerStartRestartGroup;
                        Modifier modifier5 = modifier2;
                        m2607TabEVJuX4I(z, function0, modifier5, z6, mutableInteractionSource3, j6, jM6813copywmQWz5c$default, ComposableLambdaKt.rememberComposableLambda(-1088373601, true, new Function3() { // from class: androidx.compose.material.TabKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return TabKt.Tab_0nD_MI0$lambda$1(composableLambdaRememberComposableLambda, function5, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composerStartRestartGroup, 54), composer2, (57344 & i26) | i25 | (458752 & i26) | (i26 & 3670016), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        function6 = function4;
                        function7 = function5;
                        modifier3 = modifier5;
                        z5 = z6;
                        mutableInteractionSource2 = mutableInteractionSource3;
                        j3 = j6;
                        j4 = jM6813copywmQWz5c$default;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        mutableInteractionSource2 = mutableInteractionSource;
                        modifier3 = modifier2;
                        z5 = z3;
                        function6 = function4;
                        function7 = function5;
                        j3 = j;
                        j4 = j2;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.TabKt$$ExternalSyntheticLambda5
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return TabKt.Tab_0nD_MI0$lambda$2(z, function0, modifier3, z5, function6, function7, mutableInteractionSource2, j3, j4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= 24576;
                function4 = function2;
                i8 = i2 & 32;
                if (i8 != 0) {
                    if ((196608 & i) == 0) {
                        function5 = function3;
                        if (composerStartRestartGroup.changedInstance(function5)) {
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
                        if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                            i11 = 1048576;
                        } else {
                            i11 = 524288;
                        }
                        i3 |= i11;
                    }
                    i12 = 12582912;
                    if ((i & 12582912) == 0) {
                        if ((i2 & 128) == 0) {
                            i18 = i3;
                            i14 = i19;
                            if (composerStartRestartGroup.changed(j)) {
                            }
                            i13 = i18 | i20;
                        } else {
                            i18 = i3;
                            i14 = i19;
                        }
                        i13 = i18 | i20;
                    } else {
                        i13 = i3;
                        i14 = i19;
                    }
                    if ((i & 100663296) == 0) {
                        int i27 = i13;
                        if ((i2 & 256) == 0) {
                            i17 = 33554432;
                        } else {
                            i17 = 33554432;
                        }
                        i13 = i27 | i17;
                    }
                    i15 = i13;
                    if ((i15 & 38347923) != 38347922) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z4, i15 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "95@4304L7,96@4396L6");
                        composableLambdaRememberComposableLambda = null;
                        if ((i & 1) != 0) {
                            if (i14 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                z3 = true;
                            }
                            if (i6 != 0) {
                                function4 = null;
                            }
                            if (i8 != 0) {
                                function5 = null;
                            }
                            if (i10 != 0) {
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            if ((i2 & 128) != 0) {
                                ProvidableCompositionLocal<Color> localContentColor4 = ContentColorKt.getLocalContentColor();
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                Object objConsume4 = composerStartRestartGroup.consume(localContentColor4);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                jM6824unboximpl = ((Color) objConsume4).m6824unboximpl();
                                i15 &= -29360129;
                            } else {
                                jM6824unboximpl = j;
                            }
                            if ((i2 & 256) != 0) {
                                long j10 = jM6824unboximpl;
                                j5 = j10;
                                i16 = i15 & (-234881025);
                                jM6813copywmQWz5c$default = Color.m6813copywmQWz5c$default(j10, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                            } else {
                                j5 = jM6824unboximpl;
                                jM6813copywmQWz5c$default = j2;
                                i16 = i15;
                            }
                            z6 = z3;
                            j6 = j5;
                        } else {
                            if (i14 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                z3 = true;
                            }
                            if (i6 != 0) {
                                function4 = null;
                            }
                            if (i8 != 0) {
                                function5 = null;
                            }
                            if (i10 != 0) {
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            if ((i2 & 128) != 0) {
                                ProvidableCompositionLocal<Color> localContentColor5 = ContentColorKt.getLocalContentColor();
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                Object objConsume5 = composerStartRestartGroup.consume(localContentColor5);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                jM6824unboximpl = ((Color) objConsume5).m6824unboximpl();
                                i15 &= -29360129;
                            } else {
                                jM6824unboximpl = j;
                            }
                            if ((i2 & 256) != 0) {
                                long j11 = jM6824unboximpl;
                                j5 = j11;
                                i16 = i15 & (-234881025);
                                jM6813copywmQWz5c$default = Color.m6813copywmQWz5c$default(j11, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                            } else {
                                j5 = jM6824unboximpl;
                                jM6813copywmQWz5c$default = j2;
                                i16 = i15;
                            }
                            z6 = z3;
                            j6 = j5;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-610760526, i16, -1, "androidx.compose.material.Tab (Tab.kt:97)");
                        }
                        if (function4 == null) {
                            composerStartRestartGroup.startReplaceGroup(-1684876703);
                        } else {
                            composerStartRestartGroup.startReplaceGroup(-1684876702);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "*100@4501L166");
                            composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1101313667, true, new Function2() { // from class: androidx.compose.material.TabKt$$ExternalSyntheticLambda3
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return TabKt.Tab_0nD_MI0$lambda$0$0(function4, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composerStartRestartGroup, 54);
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        int i28 = (i16 & 14) | i12 | (i16 & 112) | (i16 & 896) | (i16 & 7168);
                        int i29 = i16 >> 6;
                        composer2 = composerStartRestartGroup;
                        Modifier modifier6 = modifier2;
                        m2607TabEVJuX4I(z, function0, modifier6, z6, mutableInteractionSource3, j6, jM6813copywmQWz5c$default, ComposableLambdaKt.rememberComposableLambda(-1088373601, true, new Function3() { // from class: androidx.compose.material.TabKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return TabKt.Tab_0nD_MI0$lambda$1(composableLambdaRememberComposableLambda, function5, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composerStartRestartGroup, 54), composer2, (57344 & i29) | i28 | (458752 & i29) | (i29 & 3670016), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        function6 = function4;
                        function7 = function5;
                        modifier3 = modifier6;
                        z5 = z6;
                        mutableInteractionSource2 = mutableInteractionSource3;
                        j3 = j6;
                        j4 = jM6813copywmQWz5c$default;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        mutableInteractionSource2 = mutableInteractionSource;
                        modifier3 = modifier2;
                        z5 = z3;
                        function6 = function4;
                        function7 = function5;
                        j3 = j;
                        j4 = j2;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.TabKt$$ExternalSyntheticLambda5
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return TabKt.Tab_0nD_MI0$lambda$2(z, function0, modifier3, z5, function6, function7, mutableInteractionSource2, j3, j4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                function5 = function3;
                i10 = i2 & 64;
                if (i10 != 0) {
                    i3 |= 1572864;
                } else if ((i & 1572864) == 0) {
                    if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                        i11 = 1048576;
                    } else {
                        i11 = 524288;
                    }
                    i3 |= i11;
                }
                i12 = 12582912;
                if ((i & 12582912) == 0) {
                    if ((i2 & 128) == 0) {
                        i18 = i3;
                        i14 = i19;
                        if (composerStartRestartGroup.changed(j)) {
                        }
                        i13 = i18 | i20;
                    } else {
                        i18 = i3;
                        i14 = i19;
                    }
                    i13 = i18 | i20;
                } else {
                    i13 = i3;
                    i14 = i19;
                }
                if ((i & 100663296) == 0) {
                    int i210 = i13;
                    if ((i2 & 256) == 0) {
                        i17 = 33554432;
                    } else {
                        i17 = 33554432;
                    }
                    i13 = i210 | i17;
                }
                i15 = i13;
                if ((i15 & 38347923) != 38347922) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z4, i15 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "95@4304L7,96@4396L6");
                    composableLambdaRememberComposableLambda = null;
                    if ((i & 1) != 0) {
                        if (i14 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        }
                        if (i6 != 0) {
                            function4 = null;
                        }
                        if (i8 != 0) {
                            function5 = null;
                        }
                        if (i10 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        if ((i2 & 128) != 0) {
                            ProvidableCompositionLocal<Color> localContentColor6 = ContentColorKt.getLocalContentColor();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                            Object objConsume6 = composerStartRestartGroup.consume(localContentColor6);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            jM6824unboximpl = ((Color) objConsume6).m6824unboximpl();
                            i15 &= -29360129;
                        } else {
                            jM6824unboximpl = j;
                        }
                        if ((i2 & 256) != 0) {
                            long j12 = jM6824unboximpl;
                            j5 = j12;
                            i16 = i15 & (-234881025);
                            jM6813copywmQWz5c$default = Color.m6813copywmQWz5c$default(j12, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                        } else {
                            j5 = jM6824unboximpl;
                            jM6813copywmQWz5c$default = j2;
                            i16 = i15;
                        }
                        z6 = z3;
                        j6 = j5;
                    } else {
                        if (i14 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        }
                        if (i6 != 0) {
                            function4 = null;
                        }
                        if (i8 != 0) {
                            function5 = null;
                        }
                        if (i10 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        if ((i2 & 128) != 0) {
                            ProvidableCompositionLocal<Color> localContentColor7 = ContentColorKt.getLocalContentColor();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                            Object objConsume7 = composerStartRestartGroup.consume(localContentColor7);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            jM6824unboximpl = ((Color) objConsume7).m6824unboximpl();
                            i15 &= -29360129;
                        } else {
                            jM6824unboximpl = j;
                        }
                        if ((i2 & 256) != 0) {
                            long j13 = jM6824unboximpl;
                            j5 = j13;
                            i16 = i15 & (-234881025);
                            jM6813copywmQWz5c$default = Color.m6813copywmQWz5c$default(j13, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                        } else {
                            j5 = jM6824unboximpl;
                            jM6813copywmQWz5c$default = j2;
                            i16 = i15;
                        }
                        z6 = z3;
                        j6 = j5;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-610760526, i16, -1, "androidx.compose.material.Tab (Tab.kt:97)");
                    }
                    if (function4 == null) {
                        composerStartRestartGroup.startReplaceGroup(-1684876703);
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-1684876702);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "*100@4501L166");
                        composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1101313667, true, new Function2() { // from class: androidx.compose.material.TabKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return TabKt.Tab_0nD_MI0$lambda$0$0(function4, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    int i211 = (i16 & 14) | i12 | (i16 & 112) | (i16 & 896) | (i16 & 7168);
                    int i212 = i16 >> 6;
                    composer2 = composerStartRestartGroup;
                    Modifier modifier7 = modifier2;
                    m2607TabEVJuX4I(z, function0, modifier7, z6, mutableInteractionSource3, j6, jM6813copywmQWz5c$default, ComposableLambdaKt.rememberComposableLambda(-1088373601, true, new Function3() { // from class: androidx.compose.material.TabKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return TabKt.Tab_0nD_MI0$lambda$1(composableLambdaRememberComposableLambda, function5, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54), composer2, (57344 & i212) | i211 | (458752 & i212) | (i212 & 3670016), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    function6 = function4;
                    function7 = function5;
                    modifier3 = modifier7;
                    z5 = z6;
                    mutableInteractionSource2 = mutableInteractionSource3;
                    j3 = j6;
                    j4 = jM6813copywmQWz5c$default;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    mutableInteractionSource2 = mutableInteractionSource;
                    modifier3 = modifier2;
                    z5 = z3;
                    function6 = function4;
                    function7 = function5;
                    j3 = j;
                    j4 = j2;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.TabKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return TabKt.Tab_0nD_MI0$lambda$2(z, function0, modifier3, z5, function6, function7, mutableInteractionSource2, j3, j4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 3072;
            z3 = z2;
            i6 = i2 & 16;
            if (i6 != 0) {
                if ((i & 24576) == 0) {
                    function4 = function2;
                    if (composerStartRestartGroup.changedInstance(function4)) {
                        i7 = 16384;
                    } else {
                        i7 = 8192;
                    }
                    i3 |= i7;
                }
                i8 = i2 & 32;
                if (i8 != 0) {
                    if ((196608 & i) == 0) {
                        function5 = function3;
                        if (composerStartRestartGroup.changedInstance(function5)) {
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
                        if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                            i11 = 1048576;
                        } else {
                            i11 = 524288;
                        }
                        i3 |= i11;
                    }
                    i12 = 12582912;
                    if ((i & 12582912) == 0) {
                        if ((i2 & 128) == 0) {
                            i18 = i3;
                            i14 = i19;
                            if (composerStartRestartGroup.changed(j)) {
                            }
                            i13 = i18 | i20;
                        } else {
                            i18 = i3;
                            i14 = i19;
                        }
                        i13 = i18 | i20;
                    } else {
                        i13 = i3;
                        i14 = i19;
                    }
                    if ((i & 100663296) == 0) {
                        int i213 = i13;
                        if ((i2 & 256) == 0) {
                            i17 = 33554432;
                        } else {
                            i17 = 33554432;
                        }
                        i13 = i213 | i17;
                    }
                    i15 = i13;
                    if ((i15 & 38347923) != 38347922) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z4, i15 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "95@4304L7,96@4396L6");
                        composableLambdaRememberComposableLambda = null;
                        if ((i & 1) != 0) {
                            if (i14 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                z3 = true;
                            }
                            if (i6 != 0) {
                                function4 = null;
                            }
                            if (i8 != 0) {
                                function5 = null;
                            }
                            if (i10 != 0) {
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            if ((i2 & 128) != 0) {
                                ProvidableCompositionLocal<Color> localContentColor8 = ContentColorKt.getLocalContentColor();
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                Object objConsume8 = composerStartRestartGroup.consume(localContentColor8);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                jM6824unboximpl = ((Color) objConsume8).m6824unboximpl();
                                i15 &= -29360129;
                            } else {
                                jM6824unboximpl = j;
                            }
                            if ((i2 & 256) != 0) {
                                long j14 = jM6824unboximpl;
                                j5 = j14;
                                i16 = i15 & (-234881025);
                                jM6813copywmQWz5c$default = Color.m6813copywmQWz5c$default(j14, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                            } else {
                                j5 = jM6824unboximpl;
                                jM6813copywmQWz5c$default = j2;
                                i16 = i15;
                            }
                            z6 = z3;
                            j6 = j5;
                        } else {
                            if (i14 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                z3 = true;
                            }
                            if (i6 != 0) {
                                function4 = null;
                            }
                            if (i8 != 0) {
                                function5 = null;
                            }
                            if (i10 != 0) {
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            if ((i2 & 128) != 0) {
                                ProvidableCompositionLocal<Color> localContentColor9 = ContentColorKt.getLocalContentColor();
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                Object objConsume9 = composerStartRestartGroup.consume(localContentColor9);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                jM6824unboximpl = ((Color) objConsume9).m6824unboximpl();
                                i15 &= -29360129;
                            } else {
                                jM6824unboximpl = j;
                            }
                            if ((i2 & 256) != 0) {
                                long j15 = jM6824unboximpl;
                                j5 = j15;
                                i16 = i15 & (-234881025);
                                jM6813copywmQWz5c$default = Color.m6813copywmQWz5c$default(j15, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                            } else {
                                j5 = jM6824unboximpl;
                                jM6813copywmQWz5c$default = j2;
                                i16 = i15;
                            }
                            z6 = z3;
                            j6 = j5;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-610760526, i16, -1, "androidx.compose.material.Tab (Tab.kt:97)");
                        }
                        if (function4 == null) {
                            composerStartRestartGroup.startReplaceGroup(-1684876703);
                        } else {
                            composerStartRestartGroup.startReplaceGroup(-1684876702);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "*100@4501L166");
                            composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1101313667, true, new Function2() { // from class: androidx.compose.material.TabKt$$ExternalSyntheticLambda3
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return TabKt.Tab_0nD_MI0$lambda$0$0(function4, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composerStartRestartGroup, 54);
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        int i214 = (i16 & 14) | i12 | (i16 & 112) | (i16 & 896) | (i16 & 7168);
                        int i215 = i16 >> 6;
                        composer2 = composerStartRestartGroup;
                        Modifier modifier8 = modifier2;
                        m2607TabEVJuX4I(z, function0, modifier8, z6, mutableInteractionSource3, j6, jM6813copywmQWz5c$default, ComposableLambdaKt.rememberComposableLambda(-1088373601, true, new Function3() { // from class: androidx.compose.material.TabKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return TabKt.Tab_0nD_MI0$lambda$1(composableLambdaRememberComposableLambda, function5, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composerStartRestartGroup, 54), composer2, (57344 & i215) | i214 | (458752 & i215) | (i215 & 3670016), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        function6 = function4;
                        function7 = function5;
                        modifier3 = modifier8;
                        z5 = z6;
                        mutableInteractionSource2 = mutableInteractionSource3;
                        j3 = j6;
                        j4 = jM6813copywmQWz5c$default;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        mutableInteractionSource2 = mutableInteractionSource;
                        modifier3 = modifier2;
                        z5 = z3;
                        function6 = function4;
                        function7 = function5;
                        j3 = j;
                        j4 = j2;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.TabKt$$ExternalSyntheticLambda5
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return TabKt.Tab_0nD_MI0$lambda$2(z, function0, modifier3, z5, function6, function7, mutableInteractionSource2, j3, j4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                function5 = function3;
                i10 = i2 & 64;
                if (i10 != 0) {
                    i3 |= 1572864;
                } else if ((i & 1572864) == 0) {
                    if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                        i11 = 1048576;
                    } else {
                        i11 = 524288;
                    }
                    i3 |= i11;
                }
                i12 = 12582912;
                if ((i & 12582912) == 0) {
                    if ((i2 & 128) == 0) {
                        i18 = i3;
                        i14 = i19;
                        if (composerStartRestartGroup.changed(j)) {
                        }
                        i13 = i18 | i20;
                    } else {
                        i18 = i3;
                        i14 = i19;
                    }
                    i13 = i18 | i20;
                } else {
                    i13 = i3;
                    i14 = i19;
                }
                if ((i & 100663296) == 0) {
                    int i216 = i13;
                    if ((i2 & 256) == 0) {
                        i17 = 33554432;
                    } else {
                        i17 = 33554432;
                    }
                    i13 = i216 | i17;
                }
                i15 = i13;
                if ((i15 & 38347923) != 38347922) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z4, i15 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "95@4304L7,96@4396L6");
                    composableLambdaRememberComposableLambda = null;
                    if ((i & 1) != 0) {
                        if (i14 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        }
                        if (i6 != 0) {
                            function4 = null;
                        }
                        if (i8 != 0) {
                            function5 = null;
                        }
                        if (i10 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        if ((i2 & 128) != 0) {
                            ProvidableCompositionLocal<Color> localContentColor10 = ContentColorKt.getLocalContentColor();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                            Object objConsume10 = composerStartRestartGroup.consume(localContentColor10);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            jM6824unboximpl = ((Color) objConsume10).m6824unboximpl();
                            i15 &= -29360129;
                        } else {
                            jM6824unboximpl = j;
                        }
                        if ((i2 & 256) != 0) {
                            long j16 = jM6824unboximpl;
                            j5 = j16;
                            i16 = i15 & (-234881025);
                            jM6813copywmQWz5c$default = Color.m6813copywmQWz5c$default(j16, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                        } else {
                            j5 = jM6824unboximpl;
                            jM6813copywmQWz5c$default = j2;
                            i16 = i15;
                        }
                        z6 = z3;
                        j6 = j5;
                    } else {
                        if (i14 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        }
                        if (i6 != 0) {
                            function4 = null;
                        }
                        if (i8 != 0) {
                            function5 = null;
                        }
                        if (i10 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        if ((i2 & 128) != 0) {
                            ProvidableCompositionLocal<Color> localContentColor11 = ContentColorKt.getLocalContentColor();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                            Object objConsume11 = composerStartRestartGroup.consume(localContentColor11);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            jM6824unboximpl = ((Color) objConsume11).m6824unboximpl();
                            i15 &= -29360129;
                        } else {
                            jM6824unboximpl = j;
                        }
                        if ((i2 & 256) != 0) {
                            long j17 = jM6824unboximpl;
                            j5 = j17;
                            i16 = i15 & (-234881025);
                            jM6813copywmQWz5c$default = Color.m6813copywmQWz5c$default(j17, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                        } else {
                            j5 = jM6824unboximpl;
                            jM6813copywmQWz5c$default = j2;
                            i16 = i15;
                        }
                        z6 = z3;
                        j6 = j5;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-610760526, i16, -1, "androidx.compose.material.Tab (Tab.kt:97)");
                    }
                    if (function4 == null) {
                        composerStartRestartGroup.startReplaceGroup(-1684876703);
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-1684876702);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "*100@4501L166");
                        composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1101313667, true, new Function2() { // from class: androidx.compose.material.TabKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return TabKt.Tab_0nD_MI0$lambda$0$0(function4, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    int i217 = (i16 & 14) | i12 | (i16 & 112) | (i16 & 896) | (i16 & 7168);
                    int i218 = i16 >> 6;
                    composer2 = composerStartRestartGroup;
                    Modifier modifier9 = modifier2;
                    m2607TabEVJuX4I(z, function0, modifier9, z6, mutableInteractionSource3, j6, jM6813copywmQWz5c$default, ComposableLambdaKt.rememberComposableLambda(-1088373601, true, new Function3() { // from class: androidx.compose.material.TabKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return TabKt.Tab_0nD_MI0$lambda$1(composableLambdaRememberComposableLambda, function5, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54), composer2, (57344 & i218) | i217 | (458752 & i218) | (i218 & 3670016), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    function6 = function4;
                    function7 = function5;
                    modifier3 = modifier9;
                    z5 = z6;
                    mutableInteractionSource2 = mutableInteractionSource3;
                    j3 = j6;
                    j4 = jM6813copywmQWz5c$default;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    mutableInteractionSource2 = mutableInteractionSource;
                    modifier3 = modifier2;
                    z5 = z3;
                    function6 = function4;
                    function7 = function5;
                    j3 = j;
                    j4 = j2;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.TabKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return TabKt.Tab_0nD_MI0$lambda$2(z, function0, modifier3, z5, function6, function7, mutableInteractionSource2, j3, j4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 24576;
            function4 = function2;
            i8 = i2 & 32;
            if (i8 != 0) {
                if ((196608 & i) == 0) {
                    function5 = function3;
                    if (composerStartRestartGroup.changedInstance(function5)) {
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
                    if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                        i11 = 1048576;
                    } else {
                        i11 = 524288;
                    }
                    i3 |= i11;
                }
                i12 = 12582912;
                if ((i & 12582912) == 0) {
                    if ((i2 & 128) == 0) {
                        i18 = i3;
                        i14 = i19;
                        if (composerStartRestartGroup.changed(j)) {
                        }
                        i13 = i18 | i20;
                    } else {
                        i18 = i3;
                        i14 = i19;
                    }
                    i13 = i18 | i20;
                } else {
                    i13 = i3;
                    i14 = i19;
                }
                if ((i & 100663296) == 0) {
                    int i219 = i13;
                    if ((i2 & 256) == 0) {
                        i17 = 33554432;
                    } else {
                        i17 = 33554432;
                    }
                    i13 = i219 | i17;
                }
                i15 = i13;
                if ((i15 & 38347923) != 38347922) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z4, i15 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "95@4304L7,96@4396L6");
                    composableLambdaRememberComposableLambda = null;
                    if ((i & 1) != 0) {
                        if (i14 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        }
                        if (i6 != 0) {
                            function4 = null;
                        }
                        if (i8 != 0) {
                            function5 = null;
                        }
                        if (i10 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        if ((i2 & 128) != 0) {
                            ProvidableCompositionLocal<Color> localContentColor12 = ContentColorKt.getLocalContentColor();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                            Object objConsume12 = composerStartRestartGroup.consume(localContentColor12);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            jM6824unboximpl = ((Color) objConsume12).m6824unboximpl();
                            i15 &= -29360129;
                        } else {
                            jM6824unboximpl = j;
                        }
                        if ((i2 & 256) != 0) {
                            long j18 = jM6824unboximpl;
                            j5 = j18;
                            i16 = i15 & (-234881025);
                            jM6813copywmQWz5c$default = Color.m6813copywmQWz5c$default(j18, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                        } else {
                            j5 = jM6824unboximpl;
                            jM6813copywmQWz5c$default = j2;
                            i16 = i15;
                        }
                        z6 = z3;
                        j6 = j5;
                    } else {
                        if (i14 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        }
                        if (i6 != 0) {
                            function4 = null;
                        }
                        if (i8 != 0) {
                            function5 = null;
                        }
                        if (i10 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        if ((i2 & 128) != 0) {
                            ProvidableCompositionLocal<Color> localContentColor13 = ContentColorKt.getLocalContentColor();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                            Object objConsume13 = composerStartRestartGroup.consume(localContentColor13);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            jM6824unboximpl = ((Color) objConsume13).m6824unboximpl();
                            i15 &= -29360129;
                        } else {
                            jM6824unboximpl = j;
                        }
                        if ((i2 & 256) != 0) {
                            long j19 = jM6824unboximpl;
                            j5 = j19;
                            i16 = i15 & (-234881025);
                            jM6813copywmQWz5c$default = Color.m6813copywmQWz5c$default(j19, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                        } else {
                            j5 = jM6824unboximpl;
                            jM6813copywmQWz5c$default = j2;
                            i16 = i15;
                        }
                        z6 = z3;
                        j6 = j5;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-610760526, i16, -1, "androidx.compose.material.Tab (Tab.kt:97)");
                    }
                    if (function4 == null) {
                        composerStartRestartGroup.startReplaceGroup(-1684876703);
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-1684876702);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "*100@4501L166");
                        composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1101313667, true, new Function2() { // from class: androidx.compose.material.TabKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return TabKt.Tab_0nD_MI0$lambda$0$0(function4, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    int i2110 = (i16 & 14) | i12 | (i16 & 112) | (i16 & 896) | (i16 & 7168);
                    int i2111 = i16 >> 6;
                    composer2 = composerStartRestartGroup;
                    Modifier modifier10 = modifier2;
                    m2607TabEVJuX4I(z, function0, modifier10, z6, mutableInteractionSource3, j6, jM6813copywmQWz5c$default, ComposableLambdaKt.rememberComposableLambda(-1088373601, true, new Function3() { // from class: androidx.compose.material.TabKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return TabKt.Tab_0nD_MI0$lambda$1(composableLambdaRememberComposableLambda, function5, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54), composer2, (57344 & i2111) | i2110 | (458752 & i2111) | (i2111 & 3670016), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    function6 = function4;
                    function7 = function5;
                    modifier3 = modifier10;
                    z5 = z6;
                    mutableInteractionSource2 = mutableInteractionSource3;
                    j3 = j6;
                    j4 = jM6813copywmQWz5c$default;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    mutableInteractionSource2 = mutableInteractionSource;
                    modifier3 = modifier2;
                    z5 = z3;
                    function6 = function4;
                    function7 = function5;
                    j3 = j;
                    j4 = j2;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.TabKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return TabKt.Tab_0nD_MI0$lambda$2(z, function0, modifier3, z5, function6, function7, mutableInteractionSource2, j3, j4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            function5 = function3;
            i10 = i2 & 64;
            if (i10 != 0) {
                i3 |= 1572864;
            } else if ((i & 1572864) == 0) {
                if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                    i11 = 1048576;
                } else {
                    i11 = 524288;
                }
                i3 |= i11;
            }
            i12 = 12582912;
            if ((i & 12582912) == 0) {
                if ((i2 & 128) == 0) {
                    i18 = i3;
                    i14 = i19;
                    if (composerStartRestartGroup.changed(j)) {
                    }
                    i13 = i18 | i20;
                } else {
                    i18 = i3;
                    i14 = i19;
                }
                i13 = i18 | i20;
            } else {
                i13 = i3;
                i14 = i19;
            }
            if ((i & 100663296) == 0) {
                int i2112 = i13;
                if ((i2 & 256) == 0) {
                    i17 = 33554432;
                } else {
                    i17 = 33554432;
                }
                i13 = i2112 | i17;
            }
            i15 = i13;
            if ((i15 & 38347923) != 38347922) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z4, i15 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "95@4304L7,96@4396L6");
                composableLambdaRememberComposableLambda = null;
                if ((i & 1) != 0) {
                    if (i14 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    }
                    if (i6 != 0) {
                        function4 = null;
                    }
                    if (i8 != 0) {
                        function5 = null;
                    }
                    if (i10 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    if ((i2 & 128) != 0) {
                        ProvidableCompositionLocal<Color> localContentColor14 = ContentColorKt.getLocalContentColor();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object objConsume14 = composerStartRestartGroup.consume(localContentColor14);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        jM6824unboximpl = ((Color) objConsume14).m6824unboximpl();
                        i15 &= -29360129;
                    } else {
                        jM6824unboximpl = j;
                    }
                    if ((i2 & 256) != 0) {
                        long j110 = jM6824unboximpl;
                        j5 = j110;
                        i16 = i15 & (-234881025);
                        jM6813copywmQWz5c$default = Color.m6813copywmQWz5c$default(j110, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                    } else {
                        j5 = jM6824unboximpl;
                        jM6813copywmQWz5c$default = j2;
                        i16 = i15;
                    }
                    z6 = z3;
                    j6 = j5;
                } else {
                    if (i14 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    }
                    if (i6 != 0) {
                        function4 = null;
                    }
                    if (i8 != 0) {
                        function5 = null;
                    }
                    if (i10 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    if ((i2 & 128) != 0) {
                        ProvidableCompositionLocal<Color> localContentColor15 = ContentColorKt.getLocalContentColor();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object objConsume15 = composerStartRestartGroup.consume(localContentColor15);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        jM6824unboximpl = ((Color) objConsume15).m6824unboximpl();
                        i15 &= -29360129;
                    } else {
                        jM6824unboximpl = j;
                    }
                    if ((i2 & 256) != 0) {
                        long j111 = jM6824unboximpl;
                        j5 = j111;
                        i16 = i15 & (-234881025);
                        jM6813copywmQWz5c$default = Color.m6813copywmQWz5c$default(j111, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                    } else {
                        j5 = jM6824unboximpl;
                        jM6813copywmQWz5c$default = j2;
                        i16 = i15;
                    }
                    z6 = z3;
                    j6 = j5;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-610760526, i16, -1, "androidx.compose.material.Tab (Tab.kt:97)");
                }
                if (function4 == null) {
                    composerStartRestartGroup.startReplaceGroup(-1684876703);
                } else {
                    composerStartRestartGroup.startReplaceGroup(-1684876702);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "*100@4501L166");
                    composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1101313667, true, new Function2() { // from class: androidx.compose.material.TabKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return TabKt.Tab_0nD_MI0$lambda$0$0(function4, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54);
                }
                composerStartRestartGroup.endReplaceGroup();
                int i2113 = (i16 & 14) | i12 | (i16 & 112) | (i16 & 896) | (i16 & 7168);
                int i2114 = i16 >> 6;
                composer2 = composerStartRestartGroup;
                Modifier modifier11 = modifier2;
                m2607TabEVJuX4I(z, function0, modifier11, z6, mutableInteractionSource3, j6, jM6813copywmQWz5c$default, ComposableLambdaKt.rememberComposableLambda(-1088373601, true, new Function3() { // from class: androidx.compose.material.TabKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return TabKt.Tab_0nD_MI0$lambda$1(composableLambdaRememberComposableLambda, function5, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), composer2, (57344 & i2114) | i2113 | (458752 & i2114) | (i2114 & 3670016), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                function6 = function4;
                function7 = function5;
                modifier3 = modifier11;
                z5 = z6;
                mutableInteractionSource2 = mutableInteractionSource3;
                j3 = j6;
                j4 = jM6813copywmQWz5c$default;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                mutableInteractionSource2 = mutableInteractionSource;
                modifier3 = modifier2;
                z5 = z3;
                function6 = function4;
                function7 = function5;
                j3 = j;
                j4 = j2;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.TabKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return TabKt.Tab_0nD_MI0$lambda$2(z, function0, modifier3, z5, function6, function7, mutableInteractionSource2, j3, j4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 384;
        modifier2 = modifier;
        i4 = i2 & 8;
        if (i4 != 0) {
            if ((i & 3072) == 0) {
                z3 = z2;
                if (composerStartRestartGroup.changed(z3)) {
                    i5 = 2048;
                } else {
                    i5 = 1024;
                }
                i3 |= i5;
            }
            i6 = i2 & 16;
            if (i6 != 0) {
                if ((i & 24576) == 0) {
                    function4 = function2;
                    if (composerStartRestartGroup.changedInstance(function4)) {
                        i7 = 16384;
                    } else {
                        i7 = 8192;
                    }
                    i3 |= i7;
                }
                i8 = i2 & 32;
                if (i8 != 0) {
                    if ((196608 & i) == 0) {
                        function5 = function3;
                        if (composerStartRestartGroup.changedInstance(function5)) {
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
                        if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                            i11 = 1048576;
                        } else {
                            i11 = 524288;
                        }
                        i3 |= i11;
                    }
                    i12 = 12582912;
                    if ((i & 12582912) == 0) {
                        if ((i2 & 128) == 0) {
                            i18 = i3;
                            i14 = i19;
                            if (composerStartRestartGroup.changed(j)) {
                            }
                            i13 = i18 | i20;
                        } else {
                            i18 = i3;
                            i14 = i19;
                        }
                        i13 = i18 | i20;
                    } else {
                        i13 = i3;
                        i14 = i19;
                    }
                    if ((i & 100663296) == 0) {
                        int i2115 = i13;
                        if ((i2 & 256) == 0) {
                            i17 = 33554432;
                        } else {
                            i17 = 33554432;
                        }
                        i13 = i2115 | i17;
                    }
                    i15 = i13;
                    if ((i15 & 38347923) != 38347922) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z4, i15 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "95@4304L7,96@4396L6");
                        composableLambdaRememberComposableLambda = null;
                        if ((i & 1) != 0) {
                            if (i14 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                z3 = true;
                            }
                            if (i6 != 0) {
                                function4 = null;
                            }
                            if (i8 != 0) {
                                function5 = null;
                            }
                            if (i10 != 0) {
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            if ((i2 & 128) != 0) {
                                ProvidableCompositionLocal<Color> localContentColor16 = ContentColorKt.getLocalContentColor();
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                Object objConsume16 = composerStartRestartGroup.consume(localContentColor16);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                jM6824unboximpl = ((Color) objConsume16).m6824unboximpl();
                                i15 &= -29360129;
                            } else {
                                jM6824unboximpl = j;
                            }
                            if ((i2 & 256) != 0) {
                                long j112 = jM6824unboximpl;
                                j5 = j112;
                                i16 = i15 & (-234881025);
                                jM6813copywmQWz5c$default = Color.m6813copywmQWz5c$default(j112, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                            } else {
                                j5 = jM6824unboximpl;
                                jM6813copywmQWz5c$default = j2;
                                i16 = i15;
                            }
                            z6 = z3;
                            j6 = j5;
                        } else {
                            if (i14 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                z3 = true;
                            }
                            if (i6 != 0) {
                                function4 = null;
                            }
                            if (i8 != 0) {
                                function5 = null;
                            }
                            if (i10 != 0) {
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            if ((i2 & 128) != 0) {
                                ProvidableCompositionLocal<Color> localContentColor17 = ContentColorKt.getLocalContentColor();
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                Object objConsume17 = composerStartRestartGroup.consume(localContentColor17);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                jM6824unboximpl = ((Color) objConsume17).m6824unboximpl();
                                i15 &= -29360129;
                            } else {
                                jM6824unboximpl = j;
                            }
                            if ((i2 & 256) != 0) {
                                long j113 = jM6824unboximpl;
                                j5 = j113;
                                i16 = i15 & (-234881025);
                                jM6813copywmQWz5c$default = Color.m6813copywmQWz5c$default(j113, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                            } else {
                                j5 = jM6824unboximpl;
                                jM6813copywmQWz5c$default = j2;
                                i16 = i15;
                            }
                            z6 = z3;
                            j6 = j5;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-610760526, i16, -1, "androidx.compose.material.Tab (Tab.kt:97)");
                        }
                        if (function4 == null) {
                            composerStartRestartGroup.startReplaceGroup(-1684876703);
                        } else {
                            composerStartRestartGroup.startReplaceGroup(-1684876702);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "*100@4501L166");
                            composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1101313667, true, new Function2() { // from class: androidx.compose.material.TabKt$$ExternalSyntheticLambda3
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return TabKt.Tab_0nD_MI0$lambda$0$0(function4, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composerStartRestartGroup, 54);
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        int i2116 = (i16 & 14) | i12 | (i16 & 112) | (i16 & 896) | (i16 & 7168);
                        int i2117 = i16 >> 6;
                        composer2 = composerStartRestartGroup;
                        Modifier modifier12 = modifier2;
                        m2607TabEVJuX4I(z, function0, modifier12, z6, mutableInteractionSource3, j6, jM6813copywmQWz5c$default, ComposableLambdaKt.rememberComposableLambda(-1088373601, true, new Function3() { // from class: androidx.compose.material.TabKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return TabKt.Tab_0nD_MI0$lambda$1(composableLambdaRememberComposableLambda, function5, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composerStartRestartGroup, 54), composer2, (57344 & i2117) | i2116 | (458752 & i2117) | (i2117 & 3670016), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        function6 = function4;
                        function7 = function5;
                        modifier3 = modifier12;
                        z5 = z6;
                        mutableInteractionSource2 = mutableInteractionSource3;
                        j3 = j6;
                        j4 = jM6813copywmQWz5c$default;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        mutableInteractionSource2 = mutableInteractionSource;
                        modifier3 = modifier2;
                        z5 = z3;
                        function6 = function4;
                        function7 = function5;
                        j3 = j;
                        j4 = j2;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.TabKt$$ExternalSyntheticLambda5
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return TabKt.Tab_0nD_MI0$lambda$2(z, function0, modifier3, z5, function6, function7, mutableInteractionSource2, j3, j4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                function5 = function3;
                i10 = i2 & 64;
                if (i10 != 0) {
                    i3 |= 1572864;
                } else if ((i & 1572864) == 0) {
                    if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                        i11 = 1048576;
                    } else {
                        i11 = 524288;
                    }
                    i3 |= i11;
                }
                i12 = 12582912;
                if ((i & 12582912) == 0) {
                    if ((i2 & 128) == 0) {
                        i18 = i3;
                        i14 = i19;
                        if (composerStartRestartGroup.changed(j)) {
                        }
                        i13 = i18 | i20;
                    } else {
                        i18 = i3;
                        i14 = i19;
                    }
                    i13 = i18 | i20;
                } else {
                    i13 = i3;
                    i14 = i19;
                }
                if ((i & 100663296) == 0) {
                    int i2118 = i13;
                    if ((i2 & 256) == 0) {
                        i17 = 33554432;
                    } else {
                        i17 = 33554432;
                    }
                    i13 = i2118 | i17;
                }
                i15 = i13;
                if ((i15 & 38347923) != 38347922) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z4, i15 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "95@4304L7,96@4396L6");
                    composableLambdaRememberComposableLambda = null;
                    if ((i & 1) != 0) {
                        if (i14 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        }
                        if (i6 != 0) {
                            function4 = null;
                        }
                        if (i8 != 0) {
                            function5 = null;
                        }
                        if (i10 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        if ((i2 & 128) != 0) {
                            ProvidableCompositionLocal<Color> localContentColor18 = ContentColorKt.getLocalContentColor();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                            Object objConsume18 = composerStartRestartGroup.consume(localContentColor18);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            jM6824unboximpl = ((Color) objConsume18).m6824unboximpl();
                            i15 &= -29360129;
                        } else {
                            jM6824unboximpl = j;
                        }
                        if ((i2 & 256) != 0) {
                            long j114 = jM6824unboximpl;
                            j5 = j114;
                            i16 = i15 & (-234881025);
                            jM6813copywmQWz5c$default = Color.m6813copywmQWz5c$default(j114, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                        } else {
                            j5 = jM6824unboximpl;
                            jM6813copywmQWz5c$default = j2;
                            i16 = i15;
                        }
                        z6 = z3;
                        j6 = j5;
                    } else {
                        if (i14 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        }
                        if (i6 != 0) {
                            function4 = null;
                        }
                        if (i8 != 0) {
                            function5 = null;
                        }
                        if (i10 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        if ((i2 & 128) != 0) {
                            ProvidableCompositionLocal<Color> localContentColor19 = ContentColorKt.getLocalContentColor();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                            Object objConsume19 = composerStartRestartGroup.consume(localContentColor19);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            jM6824unboximpl = ((Color) objConsume19).m6824unboximpl();
                            i15 &= -29360129;
                        } else {
                            jM6824unboximpl = j;
                        }
                        if ((i2 & 256) != 0) {
                            long j115 = jM6824unboximpl;
                            j5 = j115;
                            i16 = i15 & (-234881025);
                            jM6813copywmQWz5c$default = Color.m6813copywmQWz5c$default(j115, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                        } else {
                            j5 = jM6824unboximpl;
                            jM6813copywmQWz5c$default = j2;
                            i16 = i15;
                        }
                        z6 = z3;
                        j6 = j5;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-610760526, i16, -1, "androidx.compose.material.Tab (Tab.kt:97)");
                    }
                    if (function4 == null) {
                        composerStartRestartGroup.startReplaceGroup(-1684876703);
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-1684876702);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "*100@4501L166");
                        composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1101313667, true, new Function2() { // from class: androidx.compose.material.TabKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return TabKt.Tab_0nD_MI0$lambda$0$0(function4, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    int i2119 = (i16 & 14) | i12 | (i16 & 112) | (i16 & 896) | (i16 & 7168);
                    int i21110 = i16 >> 6;
                    composer2 = composerStartRestartGroup;
                    Modifier modifier13 = modifier2;
                    m2607TabEVJuX4I(z, function0, modifier13, z6, mutableInteractionSource3, j6, jM6813copywmQWz5c$default, ComposableLambdaKt.rememberComposableLambda(-1088373601, true, new Function3() { // from class: androidx.compose.material.TabKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return TabKt.Tab_0nD_MI0$lambda$1(composableLambdaRememberComposableLambda, function5, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54), composer2, (57344 & i21110) | i2119 | (458752 & i21110) | (i21110 & 3670016), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    function6 = function4;
                    function7 = function5;
                    modifier3 = modifier13;
                    z5 = z6;
                    mutableInteractionSource2 = mutableInteractionSource3;
                    j3 = j6;
                    j4 = jM6813copywmQWz5c$default;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    mutableInteractionSource2 = mutableInteractionSource;
                    modifier3 = modifier2;
                    z5 = z3;
                    function6 = function4;
                    function7 = function5;
                    j3 = j;
                    j4 = j2;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.TabKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return TabKt.Tab_0nD_MI0$lambda$2(z, function0, modifier3, z5, function6, function7, mutableInteractionSource2, j3, j4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 24576;
            function4 = function2;
            i8 = i2 & 32;
            if (i8 != 0) {
                if ((196608 & i) == 0) {
                    function5 = function3;
                    if (composerStartRestartGroup.changedInstance(function5)) {
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
                    if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                        i11 = 1048576;
                    } else {
                        i11 = 524288;
                    }
                    i3 |= i11;
                }
                i12 = 12582912;
                if ((i & 12582912) == 0) {
                    if ((i2 & 128) == 0) {
                        i18 = i3;
                        i14 = i19;
                        if (composerStartRestartGroup.changed(j)) {
                        }
                        i13 = i18 | i20;
                    } else {
                        i18 = i3;
                        i14 = i19;
                    }
                    i13 = i18 | i20;
                } else {
                    i13 = i3;
                    i14 = i19;
                }
                if ((i & 100663296) == 0) {
                    int i21111 = i13;
                    if ((i2 & 256) == 0) {
                        i17 = 33554432;
                    } else {
                        i17 = 33554432;
                    }
                    i13 = i21111 | i17;
                }
                i15 = i13;
                if ((i15 & 38347923) != 38347922) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z4, i15 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "95@4304L7,96@4396L6");
                    composableLambdaRememberComposableLambda = null;
                    if ((i & 1) != 0) {
                        if (i14 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        }
                        if (i6 != 0) {
                            function4 = null;
                        }
                        if (i8 != 0) {
                            function5 = null;
                        }
                        if (i10 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        if ((i2 & 128) != 0) {
                            ProvidableCompositionLocal<Color> localContentColor110 = ContentColorKt.getLocalContentColor();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                            Object objConsume110 = composerStartRestartGroup.consume(localContentColor110);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            jM6824unboximpl = ((Color) objConsume110).m6824unboximpl();
                            i15 &= -29360129;
                        } else {
                            jM6824unboximpl = j;
                        }
                        if ((i2 & 256) != 0) {
                            long j116 = jM6824unboximpl;
                            j5 = j116;
                            i16 = i15 & (-234881025);
                            jM6813copywmQWz5c$default = Color.m6813copywmQWz5c$default(j116, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                        } else {
                            j5 = jM6824unboximpl;
                            jM6813copywmQWz5c$default = j2;
                            i16 = i15;
                        }
                        z6 = z3;
                        j6 = j5;
                    } else {
                        if (i14 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        }
                        if (i6 != 0) {
                            function4 = null;
                        }
                        if (i8 != 0) {
                            function5 = null;
                        }
                        if (i10 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        if ((i2 & 128) != 0) {
                            ProvidableCompositionLocal<Color> localContentColor111 = ContentColorKt.getLocalContentColor();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                            Object objConsume111 = composerStartRestartGroup.consume(localContentColor111);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            jM6824unboximpl = ((Color) objConsume111).m6824unboximpl();
                            i15 &= -29360129;
                        } else {
                            jM6824unboximpl = j;
                        }
                        if ((i2 & 256) != 0) {
                            long j117 = jM6824unboximpl;
                            j5 = j117;
                            i16 = i15 & (-234881025);
                            jM6813copywmQWz5c$default = Color.m6813copywmQWz5c$default(j117, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                        } else {
                            j5 = jM6824unboximpl;
                            jM6813copywmQWz5c$default = j2;
                            i16 = i15;
                        }
                        z6 = z3;
                        j6 = j5;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-610760526, i16, -1, "androidx.compose.material.Tab (Tab.kt:97)");
                    }
                    if (function4 == null) {
                        composerStartRestartGroup.startReplaceGroup(-1684876703);
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-1684876702);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "*100@4501L166");
                        composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1101313667, true, new Function2() { // from class: androidx.compose.material.TabKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return TabKt.Tab_0nD_MI0$lambda$0$0(function4, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    int i21112 = (i16 & 14) | i12 | (i16 & 112) | (i16 & 896) | (i16 & 7168);
                    int i21113 = i16 >> 6;
                    composer2 = composerStartRestartGroup;
                    Modifier modifier14 = modifier2;
                    m2607TabEVJuX4I(z, function0, modifier14, z6, mutableInteractionSource3, j6, jM6813copywmQWz5c$default, ComposableLambdaKt.rememberComposableLambda(-1088373601, true, new Function3() { // from class: androidx.compose.material.TabKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return TabKt.Tab_0nD_MI0$lambda$1(composableLambdaRememberComposableLambda, function5, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54), composer2, (57344 & i21113) | i21112 | (458752 & i21113) | (i21113 & 3670016), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    function6 = function4;
                    function7 = function5;
                    modifier3 = modifier14;
                    z5 = z6;
                    mutableInteractionSource2 = mutableInteractionSource3;
                    j3 = j6;
                    j4 = jM6813copywmQWz5c$default;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    mutableInteractionSource2 = mutableInteractionSource;
                    modifier3 = modifier2;
                    z5 = z3;
                    function6 = function4;
                    function7 = function5;
                    j3 = j;
                    j4 = j2;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.TabKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return TabKt.Tab_0nD_MI0$lambda$2(z, function0, modifier3, z5, function6, function7, mutableInteractionSource2, j3, j4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            function5 = function3;
            i10 = i2 & 64;
            if (i10 != 0) {
                i3 |= 1572864;
            } else if ((i & 1572864) == 0) {
                if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                    i11 = 1048576;
                } else {
                    i11 = 524288;
                }
                i3 |= i11;
            }
            i12 = 12582912;
            if ((i & 12582912) == 0) {
                if ((i2 & 128) == 0) {
                    i18 = i3;
                    i14 = i19;
                    if (composerStartRestartGroup.changed(j)) {
                    }
                    i13 = i18 | i20;
                } else {
                    i18 = i3;
                    i14 = i19;
                }
                i13 = i18 | i20;
            } else {
                i13 = i3;
                i14 = i19;
            }
            if ((i & 100663296) == 0) {
                int i21114 = i13;
                if ((i2 & 256) == 0) {
                    i17 = 33554432;
                } else {
                    i17 = 33554432;
                }
                i13 = i21114 | i17;
            }
            i15 = i13;
            if ((i15 & 38347923) != 38347922) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z4, i15 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "95@4304L7,96@4396L6");
                composableLambdaRememberComposableLambda = null;
                if ((i & 1) != 0) {
                    if (i14 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    }
                    if (i6 != 0) {
                        function4 = null;
                    }
                    if (i8 != 0) {
                        function5 = null;
                    }
                    if (i10 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    if ((i2 & 128) != 0) {
                        ProvidableCompositionLocal<Color> localContentColor112 = ContentColorKt.getLocalContentColor();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object objConsume112 = composerStartRestartGroup.consume(localContentColor112);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        jM6824unboximpl = ((Color) objConsume112).m6824unboximpl();
                        i15 &= -29360129;
                    } else {
                        jM6824unboximpl = j;
                    }
                    if ((i2 & 256) != 0) {
                        long j118 = jM6824unboximpl;
                        j5 = j118;
                        i16 = i15 & (-234881025);
                        jM6813copywmQWz5c$default = Color.m6813copywmQWz5c$default(j118, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                    } else {
                        j5 = jM6824unboximpl;
                        jM6813copywmQWz5c$default = j2;
                        i16 = i15;
                    }
                    z6 = z3;
                    j6 = j5;
                } else {
                    if (i14 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    }
                    if (i6 != 0) {
                        function4 = null;
                    }
                    if (i8 != 0) {
                        function5 = null;
                    }
                    if (i10 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    if ((i2 & 128) != 0) {
                        ProvidableCompositionLocal<Color> localContentColor113 = ContentColorKt.getLocalContentColor();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object objConsume113 = composerStartRestartGroup.consume(localContentColor113);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        jM6824unboximpl = ((Color) objConsume113).m6824unboximpl();
                        i15 &= -29360129;
                    } else {
                        jM6824unboximpl = j;
                    }
                    if ((i2 & 256) != 0) {
                        long j119 = jM6824unboximpl;
                        j5 = j119;
                        i16 = i15 & (-234881025);
                        jM6813copywmQWz5c$default = Color.m6813copywmQWz5c$default(j119, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                    } else {
                        j5 = jM6824unboximpl;
                        jM6813copywmQWz5c$default = j2;
                        i16 = i15;
                    }
                    z6 = z3;
                    j6 = j5;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-610760526, i16, -1, "androidx.compose.material.Tab (Tab.kt:97)");
                }
                if (function4 == null) {
                    composerStartRestartGroup.startReplaceGroup(-1684876703);
                } else {
                    composerStartRestartGroup.startReplaceGroup(-1684876702);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "*100@4501L166");
                    composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1101313667, true, new Function2() { // from class: androidx.compose.material.TabKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return TabKt.Tab_0nD_MI0$lambda$0$0(function4, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54);
                }
                composerStartRestartGroup.endReplaceGroup();
                int i21115 = (i16 & 14) | i12 | (i16 & 112) | (i16 & 896) | (i16 & 7168);
                int i21116 = i16 >> 6;
                composer2 = composerStartRestartGroup;
                Modifier modifier15 = modifier2;
                m2607TabEVJuX4I(z, function0, modifier15, z6, mutableInteractionSource3, j6, jM6813copywmQWz5c$default, ComposableLambdaKt.rememberComposableLambda(-1088373601, true, new Function3() { // from class: androidx.compose.material.TabKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return TabKt.Tab_0nD_MI0$lambda$1(composableLambdaRememberComposableLambda, function5, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), composer2, (57344 & i21116) | i21115 | (458752 & i21116) | (i21116 & 3670016), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                function6 = function4;
                function7 = function5;
                modifier3 = modifier15;
                z5 = z6;
                mutableInteractionSource2 = mutableInteractionSource3;
                j3 = j6;
                j4 = jM6813copywmQWz5c$default;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                mutableInteractionSource2 = mutableInteractionSource;
                modifier3 = modifier2;
                z5 = z3;
                function6 = function4;
                function7 = function5;
                j3 = j;
                j4 = j2;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.TabKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return TabKt.Tab_0nD_MI0$lambda$2(z, function0, modifier3, z5, function6, function7, mutableInteractionSource2, j3, j4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 3072;
        z3 = z2;
        i6 = i2 & 16;
        if (i6 != 0) {
            if ((i & 24576) == 0) {
                function4 = function2;
                if (composerStartRestartGroup.changedInstance(function4)) {
                    i7 = 16384;
                } else {
                    i7 = 8192;
                }
                i3 |= i7;
            }
            i8 = i2 & 32;
            if (i8 != 0) {
                if ((196608 & i) == 0) {
                    function5 = function3;
                    if (composerStartRestartGroup.changedInstance(function5)) {
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
                    if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                        i11 = 1048576;
                    } else {
                        i11 = 524288;
                    }
                    i3 |= i11;
                }
                i12 = 12582912;
                if ((i & 12582912) == 0) {
                    if ((i2 & 128) == 0) {
                        i18 = i3;
                        i14 = i19;
                        if (composerStartRestartGroup.changed(j)) {
                        }
                        i13 = i18 | i20;
                    } else {
                        i18 = i3;
                        i14 = i19;
                    }
                    i13 = i18 | i20;
                } else {
                    i13 = i3;
                    i14 = i19;
                }
                if ((i & 100663296) == 0) {
                    int i21117 = i13;
                    if ((i2 & 256) == 0) {
                        i17 = 33554432;
                    } else {
                        i17 = 33554432;
                    }
                    i13 = i21117 | i17;
                }
                i15 = i13;
                if ((i15 & 38347923) != 38347922) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z4, i15 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "95@4304L7,96@4396L6");
                    composableLambdaRememberComposableLambda = null;
                    if ((i & 1) != 0) {
                        if (i14 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        }
                        if (i6 != 0) {
                            function4 = null;
                        }
                        if (i8 != 0) {
                            function5 = null;
                        }
                        if (i10 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        if ((i2 & 128) != 0) {
                            ProvidableCompositionLocal<Color> localContentColor114 = ContentColorKt.getLocalContentColor();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                            Object objConsume114 = composerStartRestartGroup.consume(localContentColor114);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            jM6824unboximpl = ((Color) objConsume114).m6824unboximpl();
                            i15 &= -29360129;
                        } else {
                            jM6824unboximpl = j;
                        }
                        if ((i2 & 256) != 0) {
                            long j1110 = jM6824unboximpl;
                            j5 = j1110;
                            i16 = i15 & (-234881025);
                            jM6813copywmQWz5c$default = Color.m6813copywmQWz5c$default(j1110, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                        } else {
                            j5 = jM6824unboximpl;
                            jM6813copywmQWz5c$default = j2;
                            i16 = i15;
                        }
                        z6 = z3;
                        j6 = j5;
                    } else {
                        if (i14 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        }
                        if (i6 != 0) {
                            function4 = null;
                        }
                        if (i8 != 0) {
                            function5 = null;
                        }
                        if (i10 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        if ((i2 & 128) != 0) {
                            ProvidableCompositionLocal<Color> localContentColor115 = ContentColorKt.getLocalContentColor();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                            Object objConsume115 = composerStartRestartGroup.consume(localContentColor115);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            jM6824unboximpl = ((Color) objConsume115).m6824unboximpl();
                            i15 &= -29360129;
                        } else {
                            jM6824unboximpl = j;
                        }
                        if ((i2 & 256) != 0) {
                            long j1111 = jM6824unboximpl;
                            j5 = j1111;
                            i16 = i15 & (-234881025);
                            jM6813copywmQWz5c$default = Color.m6813copywmQWz5c$default(j1111, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                        } else {
                            j5 = jM6824unboximpl;
                            jM6813copywmQWz5c$default = j2;
                            i16 = i15;
                        }
                        z6 = z3;
                        j6 = j5;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-610760526, i16, -1, "androidx.compose.material.Tab (Tab.kt:97)");
                    }
                    if (function4 == null) {
                        composerStartRestartGroup.startReplaceGroup(-1684876703);
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-1684876702);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "*100@4501L166");
                        composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1101313667, true, new Function2() { // from class: androidx.compose.material.TabKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return TabKt.Tab_0nD_MI0$lambda$0$0(function4, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    int i21118 = (i16 & 14) | i12 | (i16 & 112) | (i16 & 896) | (i16 & 7168);
                    int i21119 = i16 >> 6;
                    composer2 = composerStartRestartGroup;
                    Modifier modifier16 = modifier2;
                    m2607TabEVJuX4I(z, function0, modifier16, z6, mutableInteractionSource3, j6, jM6813copywmQWz5c$default, ComposableLambdaKt.rememberComposableLambda(-1088373601, true, new Function3() { // from class: androidx.compose.material.TabKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return TabKt.Tab_0nD_MI0$lambda$1(composableLambdaRememberComposableLambda, function5, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54), composer2, (57344 & i21119) | i21118 | (458752 & i21119) | (i21119 & 3670016), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    function6 = function4;
                    function7 = function5;
                    modifier3 = modifier16;
                    z5 = z6;
                    mutableInteractionSource2 = mutableInteractionSource3;
                    j3 = j6;
                    j4 = jM6813copywmQWz5c$default;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    mutableInteractionSource2 = mutableInteractionSource;
                    modifier3 = modifier2;
                    z5 = z3;
                    function6 = function4;
                    function7 = function5;
                    j3 = j;
                    j4 = j2;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.TabKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return TabKt.Tab_0nD_MI0$lambda$2(z, function0, modifier3, z5, function6, function7, mutableInteractionSource2, j3, j4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            function5 = function3;
            i10 = i2 & 64;
            if (i10 != 0) {
                i3 |= 1572864;
            } else if ((i & 1572864) == 0) {
                if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                    i11 = 1048576;
                } else {
                    i11 = 524288;
                }
                i3 |= i11;
            }
            i12 = 12582912;
            if ((i & 12582912) == 0) {
                if ((i2 & 128) == 0) {
                    i18 = i3;
                    i14 = i19;
                    if (composerStartRestartGroup.changed(j)) {
                    }
                    i13 = i18 | i20;
                } else {
                    i18 = i3;
                    i14 = i19;
                }
                i13 = i18 | i20;
            } else {
                i13 = i3;
                i14 = i19;
            }
            if ((i & 100663296) == 0) {
                int i211110 = i13;
                if ((i2 & 256) == 0) {
                    i17 = 33554432;
                } else {
                    i17 = 33554432;
                }
                i13 = i211110 | i17;
            }
            i15 = i13;
            if ((i15 & 38347923) != 38347922) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z4, i15 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "95@4304L7,96@4396L6");
                composableLambdaRememberComposableLambda = null;
                if ((i & 1) != 0) {
                    if (i14 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    }
                    if (i6 != 0) {
                        function4 = null;
                    }
                    if (i8 != 0) {
                        function5 = null;
                    }
                    if (i10 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    if ((i2 & 128) != 0) {
                        ProvidableCompositionLocal<Color> localContentColor116 = ContentColorKt.getLocalContentColor();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object objConsume116 = composerStartRestartGroup.consume(localContentColor116);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        jM6824unboximpl = ((Color) objConsume116).m6824unboximpl();
                        i15 &= -29360129;
                    } else {
                        jM6824unboximpl = j;
                    }
                    if ((i2 & 256) != 0) {
                        long j1112 = jM6824unboximpl;
                        j5 = j1112;
                        i16 = i15 & (-234881025);
                        jM6813copywmQWz5c$default = Color.m6813copywmQWz5c$default(j1112, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                    } else {
                        j5 = jM6824unboximpl;
                        jM6813copywmQWz5c$default = j2;
                        i16 = i15;
                    }
                    z6 = z3;
                    j6 = j5;
                } else {
                    if (i14 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    }
                    if (i6 != 0) {
                        function4 = null;
                    }
                    if (i8 != 0) {
                        function5 = null;
                    }
                    if (i10 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    if ((i2 & 128) != 0) {
                        ProvidableCompositionLocal<Color> localContentColor117 = ContentColorKt.getLocalContentColor();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object objConsume117 = composerStartRestartGroup.consume(localContentColor117);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        jM6824unboximpl = ((Color) objConsume117).m6824unboximpl();
                        i15 &= -29360129;
                    } else {
                        jM6824unboximpl = j;
                    }
                    if ((i2 & 256) != 0) {
                        long j1113 = jM6824unboximpl;
                        j5 = j1113;
                        i16 = i15 & (-234881025);
                        jM6813copywmQWz5c$default = Color.m6813copywmQWz5c$default(j1113, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                    } else {
                        j5 = jM6824unboximpl;
                        jM6813copywmQWz5c$default = j2;
                        i16 = i15;
                    }
                    z6 = z3;
                    j6 = j5;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-610760526, i16, -1, "androidx.compose.material.Tab (Tab.kt:97)");
                }
                if (function4 == null) {
                    composerStartRestartGroup.startReplaceGroup(-1684876703);
                } else {
                    composerStartRestartGroup.startReplaceGroup(-1684876702);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "*100@4501L166");
                    composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1101313667, true, new Function2() { // from class: androidx.compose.material.TabKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return TabKt.Tab_0nD_MI0$lambda$0$0(function4, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54);
                }
                composerStartRestartGroup.endReplaceGroup();
                int i211111 = (i16 & 14) | i12 | (i16 & 112) | (i16 & 896) | (i16 & 7168);
                int i211112 = i16 >> 6;
                composer2 = composerStartRestartGroup;
                Modifier modifier17 = modifier2;
                m2607TabEVJuX4I(z, function0, modifier17, z6, mutableInteractionSource3, j6, jM6813copywmQWz5c$default, ComposableLambdaKt.rememberComposableLambda(-1088373601, true, new Function3() { // from class: androidx.compose.material.TabKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return TabKt.Tab_0nD_MI0$lambda$1(composableLambdaRememberComposableLambda, function5, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), composer2, (57344 & i211112) | i211111 | (458752 & i211112) | (i211112 & 3670016), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                function6 = function4;
                function7 = function5;
                modifier3 = modifier17;
                z5 = z6;
                mutableInteractionSource2 = mutableInteractionSource3;
                j3 = j6;
                j4 = jM6813copywmQWz5c$default;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                mutableInteractionSource2 = mutableInteractionSource;
                modifier3 = modifier2;
                z5 = z3;
                function6 = function4;
                function7 = function5;
                j3 = j;
                j4 = j2;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.TabKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return TabKt.Tab_0nD_MI0$lambda$2(z, function0, modifier3, z5, function6, function7, mutableInteractionSource2, j3, j4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 24576;
        function4 = function2;
        i8 = i2 & 32;
        if (i8 != 0) {
            if ((196608 & i) == 0) {
                function5 = function3;
                if (composerStartRestartGroup.changedInstance(function5)) {
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
                if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                    i11 = 1048576;
                } else {
                    i11 = 524288;
                }
                i3 |= i11;
            }
            i12 = 12582912;
            if ((i & 12582912) == 0) {
                if ((i2 & 128) == 0) {
                    i18 = i3;
                    i14 = i19;
                    if (composerStartRestartGroup.changed(j)) {
                    }
                    i13 = i18 | i20;
                } else {
                    i18 = i3;
                    i14 = i19;
                }
                i13 = i18 | i20;
            } else {
                i13 = i3;
                i14 = i19;
            }
            if ((i & 100663296) == 0) {
                int i211113 = i13;
                if ((i2 & 256) == 0) {
                    i17 = 33554432;
                } else {
                    i17 = 33554432;
                }
                i13 = i211113 | i17;
            }
            i15 = i13;
            if ((i15 & 38347923) != 38347922) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z4, i15 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "95@4304L7,96@4396L6");
                composableLambdaRememberComposableLambda = null;
                if ((i & 1) != 0) {
                    if (i14 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    }
                    if (i6 != 0) {
                        function4 = null;
                    }
                    if (i8 != 0) {
                        function5 = null;
                    }
                    if (i10 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    if ((i2 & 128) != 0) {
                        ProvidableCompositionLocal<Color> localContentColor118 = ContentColorKt.getLocalContentColor();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object objConsume118 = composerStartRestartGroup.consume(localContentColor118);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        jM6824unboximpl = ((Color) objConsume118).m6824unboximpl();
                        i15 &= -29360129;
                    } else {
                        jM6824unboximpl = j;
                    }
                    if ((i2 & 256) != 0) {
                        long j1114 = jM6824unboximpl;
                        j5 = j1114;
                        i16 = i15 & (-234881025);
                        jM6813copywmQWz5c$default = Color.m6813copywmQWz5c$default(j1114, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                    } else {
                        j5 = jM6824unboximpl;
                        jM6813copywmQWz5c$default = j2;
                        i16 = i15;
                    }
                    z6 = z3;
                    j6 = j5;
                } else {
                    if (i14 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    }
                    if (i6 != 0) {
                        function4 = null;
                    }
                    if (i8 != 0) {
                        function5 = null;
                    }
                    if (i10 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    if ((i2 & 128) != 0) {
                        ProvidableCompositionLocal<Color> localContentColor119 = ContentColorKt.getLocalContentColor();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object objConsume119 = composerStartRestartGroup.consume(localContentColor119);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        jM6824unboximpl = ((Color) objConsume119).m6824unboximpl();
                        i15 &= -29360129;
                    } else {
                        jM6824unboximpl = j;
                    }
                    if ((i2 & 256) != 0) {
                        long j1115 = jM6824unboximpl;
                        j5 = j1115;
                        i16 = i15 & (-234881025);
                        jM6813copywmQWz5c$default = Color.m6813copywmQWz5c$default(j1115, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                    } else {
                        j5 = jM6824unboximpl;
                        jM6813copywmQWz5c$default = j2;
                        i16 = i15;
                    }
                    z6 = z3;
                    j6 = j5;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-610760526, i16, -1, "androidx.compose.material.Tab (Tab.kt:97)");
                }
                if (function4 == null) {
                    composerStartRestartGroup.startReplaceGroup(-1684876703);
                } else {
                    composerStartRestartGroup.startReplaceGroup(-1684876702);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "*100@4501L166");
                    composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1101313667, true, new Function2() { // from class: androidx.compose.material.TabKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return TabKt.Tab_0nD_MI0$lambda$0$0(function4, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54);
                }
                composerStartRestartGroup.endReplaceGroup();
                int i211114 = (i16 & 14) | i12 | (i16 & 112) | (i16 & 896) | (i16 & 7168);
                int i211115 = i16 >> 6;
                composer2 = composerStartRestartGroup;
                Modifier modifier18 = modifier2;
                m2607TabEVJuX4I(z, function0, modifier18, z6, mutableInteractionSource3, j6, jM6813copywmQWz5c$default, ComposableLambdaKt.rememberComposableLambda(-1088373601, true, new Function3() { // from class: androidx.compose.material.TabKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return TabKt.Tab_0nD_MI0$lambda$1(composableLambdaRememberComposableLambda, function5, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), composer2, (57344 & i211115) | i211114 | (458752 & i211115) | (i211115 & 3670016), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                function6 = function4;
                function7 = function5;
                modifier3 = modifier18;
                z5 = z6;
                mutableInteractionSource2 = mutableInteractionSource3;
                j3 = j6;
                j4 = jM6813copywmQWz5c$default;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                mutableInteractionSource2 = mutableInteractionSource;
                modifier3 = modifier2;
                z5 = z3;
                function6 = function4;
                function7 = function5;
                j3 = j;
                j4 = j2;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.TabKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return TabKt.Tab_0nD_MI0$lambda$2(z, function0, modifier3, z5, function6, function7, mutableInteractionSource2, j3, j4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        function5 = function3;
        i10 = i2 & 64;
        if (i10 != 0) {
            i3 |= 1572864;
        } else if ((i & 1572864) == 0) {
            if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                i11 = 1048576;
            } else {
                i11 = 524288;
            }
            i3 |= i11;
        }
        i12 = 12582912;
        if ((i & 12582912) == 0) {
            if ((i2 & 128) == 0) {
                i18 = i3;
                i14 = i19;
                if (composerStartRestartGroup.changed(j)) {
                }
                i13 = i18 | i20;
            } else {
                i18 = i3;
                i14 = i19;
            }
            i13 = i18 | i20;
        } else {
            i13 = i3;
            i14 = i19;
        }
        if ((i & 100663296) == 0) {
            int i211116 = i13;
            if ((i2 & 256) == 0) {
                i17 = 33554432;
            } else {
                i17 = 33554432;
            }
            i13 = i211116 | i17;
        }
        i15 = i13;
        if ((i15 & 38347923) != 38347922) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z4, i15 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "95@4304L7,96@4396L6");
            composableLambdaRememberComposableLambda = null;
            if ((i & 1) != 0) {
                if (i14 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i4 != 0) {
                    z3 = true;
                }
                if (i6 != 0) {
                    function4 = null;
                }
                if (i8 != 0) {
                    function5 = null;
                }
                if (i10 != 0) {
                    mutableInteractionSource3 = null;
                } else {
                    mutableInteractionSource3 = mutableInteractionSource;
                }
                if ((i2 & 128) != 0) {
                    ProvidableCompositionLocal<Color> localContentColor1110 = ContentColorKt.getLocalContentColor();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume1110 = composerStartRestartGroup.consume(localContentColor1110);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    jM6824unboximpl = ((Color) objConsume1110).m6824unboximpl();
                    i15 &= -29360129;
                } else {
                    jM6824unboximpl = j;
                }
                if ((i2 & 256) != 0) {
                    long j1116 = jM6824unboximpl;
                    j5 = j1116;
                    i16 = i15 & (-234881025);
                    jM6813copywmQWz5c$default = Color.m6813copywmQWz5c$default(j1116, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                } else {
                    j5 = jM6824unboximpl;
                    jM6813copywmQWz5c$default = j2;
                    i16 = i15;
                }
                z6 = z3;
                j6 = j5;
            } else {
                if (i14 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i4 != 0) {
                    z3 = true;
                }
                if (i6 != 0) {
                    function4 = null;
                }
                if (i8 != 0) {
                    function5 = null;
                }
                if (i10 != 0) {
                    mutableInteractionSource3 = null;
                } else {
                    mutableInteractionSource3 = mutableInteractionSource;
                }
                if ((i2 & 128) != 0) {
                    ProvidableCompositionLocal<Color> localContentColor1111 = ContentColorKt.getLocalContentColor();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume1111 = composerStartRestartGroup.consume(localContentColor1111);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    jM6824unboximpl = ((Color) objConsume1111).m6824unboximpl();
                    i15 &= -29360129;
                } else {
                    jM6824unboximpl = j;
                }
                if ((i2 & 256) != 0) {
                    long j1117 = jM6824unboximpl;
                    j5 = j1117;
                    i16 = i15 & (-234881025);
                    jM6813copywmQWz5c$default = Color.m6813copywmQWz5c$default(j1117, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                } else {
                    j5 = jM6824unboximpl;
                    jM6813copywmQWz5c$default = j2;
                    i16 = i15;
                }
                z6 = z3;
                j6 = j5;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-610760526, i16, -1, "androidx.compose.material.Tab (Tab.kt:97)");
            }
            if (function4 == null) {
                composerStartRestartGroup.startReplaceGroup(-1684876703);
            } else {
                composerStartRestartGroup.startReplaceGroup(-1684876702);
                ComposerKt.sourceInformation(composerStartRestartGroup, "*100@4501L166");
                composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1101313667, true, new Function2() { // from class: androidx.compose.material.TabKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return TabKt.Tab_0nD_MI0$lambda$0$0(function4, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54);
            }
            composerStartRestartGroup.endReplaceGroup();
            int i211117 = (i16 & 14) | i12 | (i16 & 112) | (i16 & 896) | (i16 & 7168);
            int i211118 = i16 >> 6;
            composer2 = composerStartRestartGroup;
            Modifier modifier19 = modifier2;
            m2607TabEVJuX4I(z, function0, modifier19, z6, mutableInteractionSource3, j6, jM6813copywmQWz5c$default, ComposableLambdaKt.rememberComposableLambda(-1088373601, true, new Function3() { // from class: androidx.compose.material.TabKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return TabKt.Tab_0nD_MI0$lambda$1(composableLambdaRememberComposableLambda, function5, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composer2, (57344 & i211118) | i211117 | (458752 & i211118) | (i211118 & 3670016), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            function6 = function4;
            function7 = function5;
            modifier3 = modifier19;
            z5 = z6;
            mutableInteractionSource2 = mutableInteractionSource3;
            j3 = j6;
            j4 = jM6813copywmQWz5c$default;
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            mutableInteractionSource2 = mutableInteractionSource;
            modifier3 = modifier2;
            z5 = z3;
            function6 = function4;
            function7 = function5;
            j3 = j;
            j4 = j2;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.TabKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TabKt.Tab_0nD_MI0$lambda$2(z, function0, modifier3, z5, function6, function7, mutableInteractionSource2, j3, j4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Tab_0nD_MI0$lambda$0$0(Function2 function2, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C101@4545L10,102@4614L39:Tab.kt#jmzs0o");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1101313667, i, -1, "androidx.compose.material.Tab.<anonymous>.<anonymous> (Tab.kt:101)");
            }
            TextKt.ProvideTextStyle(TextStyle.m9104copyp1EtxEg$default(MaterialTheme.INSTANCE.getTypography(composer, 6).getButton(), 0L, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, TextAlign.INSTANCE.m9526getCentere0LSkKk(), 0, 0L, null, null, null, 0, 0, null, 16744447, null), function2, composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Tab_0nD_MI0$lambda$1(Function2 function2, Function2 function3, ColumnScope columnScope, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C114@4862L49:Tab.kt#jmzs0o");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1088373601, i, -1, "androidx.compose.material.Tab.<anonymous> (Tab.kt:114)");
            }
            TabBaselineLayout(function2, function3, composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:104:0x0130 A[PHI: r7 r10 r14 r15 r20
      0x0130: PHI (r7v11 androidx.compose.ui.Modifier) = (r7v5 androidx.compose.ui.Modifier), (r7v2 androidx.compose.ui.Modifier) binds: [B:117:0x016b, B:103:0x012e] A[DONT_GENERATE, DONT_INLINE]
      0x0130: PHI (r10v14 boolean) = (r10v6 boolean), (r10v3 boolean) binds: [B:117:0x016b, B:103:0x012e] A[DONT_GENERATE, DONT_INLINE]
      0x0130: PHI (r14v9 androidx.compose.foundation.interaction.MutableInteractionSource) = 
      (r14v5 androidx.compose.foundation.interaction.MutableInteractionSource)
      (r14v3 androidx.compose.foundation.interaction.MutableInteractionSource)
     binds: [B:117:0x016b, B:103:0x012e] A[DONT_GENERATE, DONT_INLINE]
      0x0130: PHI (r15v13 int) = (r15v9 int), (r15v15 int) binds: [B:117:0x016b, B:103:0x012e] A[DONT_GENERATE, DONT_INLINE]
      0x0130: PHI (r20v4 long) = (r20v1 long), (r20v5 long) binds: [B:117:0x016b, B:103:0x012e] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:106:0x0135 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:107:0x0137  */
    /* JADX WARN: Code duplicated, block: B:109:0x013e  */
    /* JADX WARN: Code duplicated, block: B:111:0x0141  */
    /* JADX WARN: Code duplicated, block: B:114:0x0147  */
    /* JADX WARN: Code duplicated, block: B:115:0x0167  */
    /* JADX WARN: Code duplicated, block: B:118:0x016d  */
    /* JADX WARN: Code duplicated, block: B:121:0x018d  */
    /* JADX WARN: Code duplicated, block: B:124:0x01e5  */
    /* JADX WARN: Code duplicated, block: B:126:0x01f0  */
    /* JADX WARN: Code duplicated, block: B:129:0x0201  */
    /* JADX WARN: Code duplicated, block: B:131:? A[RETURN, SYNTHETIC] */
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
    /* JADX WARN: Code duplicated, block: B:70:0x00c1  */
    /* JADX WARN: Code duplicated, block: B:73:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:75:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:78:0x00db  */
    /* JADX WARN: Code duplicated, block: B:80:0x00e1  */
    /* JADX WARN: Code duplicated, block: B:83:0x00ea  */
    /* JADX WARN: Code duplicated, block: B:85:0x00ee  */
    /* JADX WARN: Code duplicated, block: B:88:0x00fa  */
    /* JADX WARN: Code duplicated, block: B:89:0x00fc  */
    /* JADX WARN: Code duplicated, block: B:92:0x0105  */
    /* JADX WARN: Code duplicated, block: B:94:0x0118  */
    /* JADX INFO: renamed from: LeadingIconTab-0nD-MI0, reason: not valid java name */
    public static final void m2605LeadingIconTab0nDMI0(final boolean z, final Function0<Unit> function0, final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function3, Modifier modifier, boolean z2, MutableInteractionSource mutableInteractionSource, long j, long j2, Composer composer, final int i, final int i2) {
        int i3;
        Function2<? super Composer, ? super Integer, Unit> function4;
        Modifier modifier2;
        int i4;
        boolean z3;
        int i5;
        int i6;
        MutableInteractionSource mutableInteractionSource2;
        int i7;
        int i8;
        boolean z4;
        Composer composer2;
        final long j3;
        final Modifier modifier3;
        final boolean z5;
        final MutableInteractionSource mutableInteractionSource3;
        final long j4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        long jM6824unboximpl;
        long jM6813copywmQWz5c$default;
        int i9;
        int i10;
        Composer composerStartRestartGroup = composer.startRestartGroup(-524682663);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(LeadingIconTab)N(selected,onClick,text,icon,modifier,enabled,interactionSource,selectedContentColor:c#ui.graphics.Color,unselectedContentColor:c#ui.graphics.Color)165@7275L921,165@7205L991:Tab.kt#jmzs0o");
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
        if ((i & 3072) == 0) {
            function4 = function3;
            i3 |= composerStartRestartGroup.changedInstance(function4) ? 2048 : 1024;
        } else {
            function4 = function3;
        }
        int i11 = i2 & 16;
        if (i11 == 0) {
            if ((i & 24576) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 16384 : 8192;
            }
            i4 = i2 & 32;
            if (i4 != 0) {
                if ((196608 & i) == 0) {
                    z3 = z2;
                    if (composerStartRestartGroup.changed(z3)) {
                        i5 = 131072;
                    } else {
                        i5 = 65536;
                    }
                    i3 |= i5;
                }
                i6 = i2 & 64;
                if (i6 != 0) {
                    if ((1572864 & i) == 0) {
                        mutableInteractionSource2 = mutableInteractionSource;
                        if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                            i7 = 1048576;
                        } else {
                            i7 = 524288;
                        }
                        i3 |= i7;
                    }
                    if ((12582912 & i) == 0) {
                        int i12 = i3;
                        if ((i2 & 128) == 0 || !composerStartRestartGroup.changed(j)) {
                            i10 = 4194304;
                        } else {
                            i10 = 8388608;
                        }
                        i8 = i12 | i10;
                    } else {
                        i8 = i3;
                    }
                    if ((i & 100663296) != 0) {
                        if ((i2 & 256) == 0 || !composerStartRestartGroup.changed(j2)) {
                            i9 = 33554432;
                        } else {
                            i9 = 67108864;
                        }
                        i8 |= i9;
                    }
                    if ((38347923 & i8) != 38347922) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z4, i8 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "157@6806L7,158@6898L6");
                        if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            if (i11 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                z3 = true;
                            }
                            if (i6 != 0) {
                                mutableInteractionSource2 = null;
                            }
                            if ((i2 & 128) != 0) {
                                ProvidableCompositionLocal<Color> localContentColor = ContentColorKt.getLocalContentColor();
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                Object objConsume = composerStartRestartGroup.consume(localContentColor);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                i8 &= -29360129;
                                jM6824unboximpl = ((Color) objConsume).m6824unboximpl();
                            } else {
                                jM6824unboximpl = j;
                            }
                            if ((i2 & 256) != 0) {
                                jM6813copywmQWz5c$default = Color.m6813copywmQWz5c$default(jM6824unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                                i8 &= -234881025;
                            }
                            final boolean z6 = z3;
                            final MutableInteractionSource mutableInteractionSource4 = mutableInteractionSource2;
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-524682663, i8, -1, "androidx.compose.material.LeadingIconTab (Tab.kt:159)");
                            }
                            final IndicationNodeFactory indicationNodeFactoryM2523rippleH2RKhps$default = RippleKt.m2523rippleH2RKhps$default(true, 0.0f, jM6824unboximpl, 2, null);
                            final Modifier modifier4 = modifier2;
                            final Function2<? super Composer, ? super Integer, Unit> function5 = function4;
                            int i13 = i8 >> 21;
                            long j5 = jM6824unboximpl;
                            m2608TabTransitionKlgxPg(j5, jM6813copywmQWz5c$default, z, ComposableLambdaKt.rememberComposableLambda(-1415722219, true, new Function2() { // from class: androidx.compose.material.TabKt$$ExternalSyntheticLambda6
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return TabKt.LeadingIconTab_0nD_MI0$lambda$0(modifier4, z, mutableInteractionSource4, indicationNodeFactoryM2523rippleH2RKhps$default, z6, function0, function5, function2, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i8 << 6) & 896) | (i13 & 112) | (i13 & 14) | 3072);
                            composer2 = composerStartRestartGroup;
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier3 = modifier4;
                            mutableInteractionSource3 = mutableInteractionSource4;
                            z5 = z6;
                            j4 = jM6813copywmQWz5c$default;
                            j3 = jM6824unboximpl;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i2 & 128) != 0) {
                                i8 &= -29360129;
                            }
                            if ((i2 & 256) != 0) {
                                i8 &= -234881025;
                            }
                            jM6824unboximpl = j;
                        }
                        jM6813copywmQWz5c$default = j2;
                        final boolean z7 = z3;
                        final MutableInteractionSource mutableInteractionSource5 = mutableInteractionSource2;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-524682663, i8, -1, "androidx.compose.material.LeadingIconTab (Tab.kt:159)");
                        }
                        final IndicationNodeFactory indicationNodeFactoryM2523rippleH2RKhps$default2 = RippleKt.m2523rippleH2RKhps$default(true, 0.0f, jM6824unboximpl, 2, null);
                        final Modifier modifier5 = modifier2;
                        final Function2 function6 = function4;
                        int i14 = i8 >> 21;
                        long j6 = jM6824unboximpl;
                        m2608TabTransitionKlgxPg(j6, jM6813copywmQWz5c$default, z, ComposableLambdaKt.rememberComposableLambda(-1415722219, true, new Function2() { // from class: androidx.compose.material.TabKt$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return TabKt.LeadingIconTab_0nD_MI0$lambda$0(modifier5, z, mutableInteractionSource5, indicationNodeFactoryM2523rippleH2RKhps$default2, z7, function0, function6, function2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i8 << 6) & 896) | (i14 & 112) | (i14 & 14) | 3072);
                        composer2 = composerStartRestartGroup;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier5;
                        mutableInteractionSource3 = mutableInteractionSource5;
                        z5 = z7;
                        j4 = jM6813copywmQWz5c$default;
                        j3 = jM6824unboximpl;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        j3 = j;
                        modifier3 = modifier2;
                        z5 = z3;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        j4 = j2;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.TabKt$$ExternalSyntheticLambda7
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return TabKt.LeadingIconTab_0nD_MI0$lambda$1(z, function0, function2, function3, modifier3, z5, mutableInteractionSource3, j3, j4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= 1572864;
                mutableInteractionSource2 = mutableInteractionSource;
                if ((12582912 & i) == 0) {
                    int i15 = i3;
                    if ((i2 & 128) == 0) {
                        i10 = 4194304;
                    } else {
                        i10 = 4194304;
                    }
                    i8 = i15 | i10;
                } else {
                    i8 = i3;
                }
                if ((i & 100663296) != 0) {
                    if ((i2 & 256) == 0) {
                        i9 = 33554432;
                    } else {
                        i9 = 33554432;
                    }
                    i8 |= i9;
                }
                if ((38347923 & i8) != 38347922) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z4, i8 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "157@6806L7,158@6898L6");
                    if ((i & 1) != 0) {
                        if (i11 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        }
                        if (i6 != 0) {
                            mutableInteractionSource2 = null;
                        }
                        if ((i2 & 128) != 0) {
                            ProvidableCompositionLocal<Color> localContentColor2 = ContentColorKt.getLocalContentColor();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                            Object objConsume2 = composerStartRestartGroup.consume(localContentColor2);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            i8 &= -29360129;
                            jM6824unboximpl = ((Color) objConsume2).m6824unboximpl();
                        } else {
                            jM6824unboximpl = j;
                        }
                        if ((i2 & 256) != 0) {
                            jM6813copywmQWz5c$default = Color.m6813copywmQWz5c$default(jM6824unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                            i8 &= -234881025;
                        } else {
                            jM6813copywmQWz5c$default = j2;
                        }
                    } else {
                        if (i11 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        }
                        if (i6 != 0) {
                            mutableInteractionSource2 = null;
                        }
                        if ((i2 & 128) != 0) {
                            ProvidableCompositionLocal<Color> localContentColor3 = ContentColorKt.getLocalContentColor();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                            Object objConsume3 = composerStartRestartGroup.consume(localContentColor3);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            i8 &= -29360129;
                            jM6824unboximpl = ((Color) objConsume3).m6824unboximpl();
                        } else {
                            jM6824unboximpl = j;
                        }
                        if ((i2 & 256) != 0) {
                            jM6813copywmQWz5c$default = Color.m6813copywmQWz5c$default(jM6824unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                            i8 &= -234881025;
                        } else {
                            jM6813copywmQWz5c$default = j2;
                        }
                    }
                    final boolean z8 = z3;
                    final MutableInteractionSource mutableInteractionSource6 = mutableInteractionSource2;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-524682663, i8, -1, "androidx.compose.material.LeadingIconTab (Tab.kt:159)");
                    }
                    final IndicationNodeFactory indicationNodeFactoryM2523rippleH2RKhps$default3 = RippleKt.m2523rippleH2RKhps$default(true, 0.0f, jM6824unboximpl, 2, null);
                    final Modifier modifier6 = modifier2;
                    final Function2 function7 = function4;
                    int i16 = i8 >> 21;
                    long j7 = jM6824unboximpl;
                    m2608TabTransitionKlgxPg(j7, jM6813copywmQWz5c$default, z, ComposableLambdaKt.rememberComposableLambda(-1415722219, true, new Function2() { // from class: androidx.compose.material.TabKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return TabKt.LeadingIconTab_0nD_MI0$lambda$0(modifier6, z, mutableInteractionSource6, indicationNodeFactoryM2523rippleH2RKhps$default3, z8, function0, function7, function2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i8 << 6) & 896) | (i16 & 112) | (i16 & 14) | 3072);
                    composer2 = composerStartRestartGroup;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier6;
                    mutableInteractionSource3 = mutableInteractionSource6;
                    z5 = z8;
                    j4 = jM6813copywmQWz5c$default;
                    j3 = jM6824unboximpl;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    j3 = j;
                    modifier3 = modifier2;
                    z5 = z3;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    j4 = j2;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.TabKt$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return TabKt.LeadingIconTab_0nD_MI0$lambda$1(z, function0, function2, function3, modifier3, z5, mutableInteractionSource3, j3, j4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            z3 = z2;
            i6 = i2 & 64;
            if (i6 != 0) {
                if ((1572864 & i) == 0) {
                    mutableInteractionSource2 = mutableInteractionSource;
                    if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                        i7 = 1048576;
                    } else {
                        i7 = 524288;
                    }
                    i3 |= i7;
                }
                if ((12582912 & i) == 0) {
                    int i17 = i3;
                    if ((i2 & 128) == 0) {
                        i10 = 4194304;
                    } else {
                        i10 = 4194304;
                    }
                    i8 = i17 | i10;
                } else {
                    i8 = i3;
                }
                if ((i & 100663296) != 0) {
                    if ((i2 & 256) == 0) {
                        i9 = 33554432;
                    } else {
                        i9 = 33554432;
                    }
                    i8 |= i9;
                }
                if ((38347923 & i8) != 38347922) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z4, i8 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "157@6806L7,158@6898L6");
                    if ((i & 1) != 0) {
                        if (i11 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        }
                        if (i6 != 0) {
                            mutableInteractionSource2 = null;
                        }
                        if ((i2 & 128) != 0) {
                            ProvidableCompositionLocal<Color> localContentColor4 = ContentColorKt.getLocalContentColor();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                            Object objConsume4 = composerStartRestartGroup.consume(localContentColor4);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            i8 &= -29360129;
                            jM6824unboximpl = ((Color) objConsume4).m6824unboximpl();
                        } else {
                            jM6824unboximpl = j;
                        }
                        if ((i2 & 256) != 0) {
                            jM6813copywmQWz5c$default = Color.m6813copywmQWz5c$default(jM6824unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                            i8 &= -234881025;
                        } else {
                            jM6813copywmQWz5c$default = j2;
                        }
                    } else {
                        if (i11 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        }
                        if (i6 != 0) {
                            mutableInteractionSource2 = null;
                        }
                        if ((i2 & 128) != 0) {
                            ProvidableCompositionLocal<Color> localContentColor5 = ContentColorKt.getLocalContentColor();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                            Object objConsume5 = composerStartRestartGroup.consume(localContentColor5);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            i8 &= -29360129;
                            jM6824unboximpl = ((Color) objConsume5).m6824unboximpl();
                        } else {
                            jM6824unboximpl = j;
                        }
                        if ((i2 & 256) != 0) {
                            jM6813copywmQWz5c$default = Color.m6813copywmQWz5c$default(jM6824unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                            i8 &= -234881025;
                        } else {
                            jM6813copywmQWz5c$default = j2;
                        }
                    }
                    final boolean z9 = z3;
                    final MutableInteractionSource mutableInteractionSource7 = mutableInteractionSource2;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-524682663, i8, -1, "androidx.compose.material.LeadingIconTab (Tab.kt:159)");
                    }
                    final IndicationNodeFactory indicationNodeFactoryM2523rippleH2RKhps$default4 = RippleKt.m2523rippleH2RKhps$default(true, 0.0f, jM6824unboximpl, 2, null);
                    final Modifier modifier7 = modifier2;
                    final Function2 function8 = function4;
                    int i18 = i8 >> 21;
                    long j8 = jM6824unboximpl;
                    m2608TabTransitionKlgxPg(j8, jM6813copywmQWz5c$default, z, ComposableLambdaKt.rememberComposableLambda(-1415722219, true, new Function2() { // from class: androidx.compose.material.TabKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return TabKt.LeadingIconTab_0nD_MI0$lambda$0(modifier7, z, mutableInteractionSource7, indicationNodeFactoryM2523rippleH2RKhps$default4, z9, function0, function8, function2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i8 << 6) & 896) | (i18 & 112) | (i18 & 14) | 3072);
                    composer2 = composerStartRestartGroup;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier7;
                    mutableInteractionSource3 = mutableInteractionSource7;
                    z5 = z9;
                    j4 = jM6813copywmQWz5c$default;
                    j3 = jM6824unboximpl;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    j3 = j;
                    modifier3 = modifier2;
                    z5 = z3;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    j4 = j2;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.TabKt$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return TabKt.LeadingIconTab_0nD_MI0$lambda$1(z, function0, function2, function3, modifier3, z5, mutableInteractionSource3, j3, j4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 1572864;
            mutableInteractionSource2 = mutableInteractionSource;
            if ((12582912 & i) == 0) {
                int i19 = i3;
                if ((i2 & 128) == 0) {
                    i10 = 4194304;
                } else {
                    i10 = 4194304;
                }
                i8 = i19 | i10;
            } else {
                i8 = i3;
            }
            if ((i & 100663296) != 0) {
                if ((i2 & 256) == 0) {
                    i9 = 33554432;
                } else {
                    i9 = 33554432;
                }
                i8 |= i9;
            }
            if ((38347923 & i8) != 38347922) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z4, i8 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "157@6806L7,158@6898L6");
                if ((i & 1) != 0) {
                    if (i11 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    }
                    if (i6 != 0) {
                        mutableInteractionSource2 = null;
                    }
                    if ((i2 & 128) != 0) {
                        ProvidableCompositionLocal<Color> localContentColor6 = ContentColorKt.getLocalContentColor();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object objConsume6 = composerStartRestartGroup.consume(localContentColor6);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        i8 &= -29360129;
                        jM6824unboximpl = ((Color) objConsume6).m6824unboximpl();
                    } else {
                        jM6824unboximpl = j;
                    }
                    if ((i2 & 256) != 0) {
                        jM6813copywmQWz5c$default = Color.m6813copywmQWz5c$default(jM6824unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                        i8 &= -234881025;
                    } else {
                        jM6813copywmQWz5c$default = j2;
                    }
                } else {
                    if (i11 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    }
                    if (i6 != 0) {
                        mutableInteractionSource2 = null;
                    }
                    if ((i2 & 128) != 0) {
                        ProvidableCompositionLocal<Color> localContentColor7 = ContentColorKt.getLocalContentColor();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object objConsume7 = composerStartRestartGroup.consume(localContentColor7);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        i8 &= -29360129;
                        jM6824unboximpl = ((Color) objConsume7).m6824unboximpl();
                    } else {
                        jM6824unboximpl = j;
                    }
                    if ((i2 & 256) != 0) {
                        jM6813copywmQWz5c$default = Color.m6813copywmQWz5c$default(jM6824unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                        i8 &= -234881025;
                    } else {
                        jM6813copywmQWz5c$default = j2;
                    }
                }
                final boolean z10 = z3;
                final MutableInteractionSource mutableInteractionSource8 = mutableInteractionSource2;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-524682663, i8, -1, "androidx.compose.material.LeadingIconTab (Tab.kt:159)");
                }
                final IndicationNodeFactory indicationNodeFactoryM2523rippleH2RKhps$default5 = RippleKt.m2523rippleH2RKhps$default(true, 0.0f, jM6824unboximpl, 2, null);
                final Modifier modifier8 = modifier2;
                final Function2 function9 = function4;
                int i110 = i8 >> 21;
                long j9 = jM6824unboximpl;
                m2608TabTransitionKlgxPg(j9, jM6813copywmQWz5c$default, z, ComposableLambdaKt.rememberComposableLambda(-1415722219, true, new Function2() { // from class: androidx.compose.material.TabKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return TabKt.LeadingIconTab_0nD_MI0$lambda$0(modifier8, z, mutableInteractionSource8, indicationNodeFactoryM2523rippleH2RKhps$default5, z10, function0, function9, function2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i8 << 6) & 896) | (i110 & 112) | (i110 & 14) | 3072);
                composer2 = composerStartRestartGroup;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier8;
                mutableInteractionSource3 = mutableInteractionSource8;
                z5 = z10;
                j4 = jM6813copywmQWz5c$default;
                j3 = jM6824unboximpl;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                j3 = j;
                modifier3 = modifier2;
                z5 = z3;
                mutableInteractionSource3 = mutableInteractionSource2;
                j4 = j2;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.TabKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return TabKt.LeadingIconTab_0nD_MI0$lambda$1(z, function0, function2, function3, modifier3, z5, mutableInteractionSource3, j3, j4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 24576;
        modifier2 = modifier;
        i4 = i2 & 32;
        if (i4 != 0) {
            if ((196608 & i) == 0) {
                z3 = z2;
                if (composerStartRestartGroup.changed(z3)) {
                    i5 = 131072;
                } else {
                    i5 = 65536;
                }
                i3 |= i5;
            }
            i6 = i2 & 64;
            if (i6 != 0) {
                if ((1572864 & i) == 0) {
                    mutableInteractionSource2 = mutableInteractionSource;
                    if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                        i7 = 1048576;
                    } else {
                        i7 = 524288;
                    }
                    i3 |= i7;
                }
                if ((12582912 & i) == 0) {
                    int i111 = i3;
                    if ((i2 & 128) == 0) {
                        i10 = 4194304;
                    } else {
                        i10 = 4194304;
                    }
                    i8 = i111 | i10;
                } else {
                    i8 = i3;
                }
                if ((i & 100663296) != 0) {
                    if ((i2 & 256) == 0) {
                        i9 = 33554432;
                    } else {
                        i9 = 33554432;
                    }
                    i8 |= i9;
                }
                if ((38347923 & i8) != 38347922) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z4, i8 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "157@6806L7,158@6898L6");
                    if ((i & 1) != 0) {
                        if (i11 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        }
                        if (i6 != 0) {
                            mutableInteractionSource2 = null;
                        }
                        if ((i2 & 128) != 0) {
                            ProvidableCompositionLocal<Color> localContentColor8 = ContentColorKt.getLocalContentColor();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                            Object objConsume8 = composerStartRestartGroup.consume(localContentColor8);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            i8 &= -29360129;
                            jM6824unboximpl = ((Color) objConsume8).m6824unboximpl();
                        } else {
                            jM6824unboximpl = j;
                        }
                        if ((i2 & 256) != 0) {
                            jM6813copywmQWz5c$default = Color.m6813copywmQWz5c$default(jM6824unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                            i8 &= -234881025;
                        } else {
                            jM6813copywmQWz5c$default = j2;
                        }
                    } else {
                        if (i11 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        }
                        if (i6 != 0) {
                            mutableInteractionSource2 = null;
                        }
                        if ((i2 & 128) != 0) {
                            ProvidableCompositionLocal<Color> localContentColor9 = ContentColorKt.getLocalContentColor();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                            Object objConsume9 = composerStartRestartGroup.consume(localContentColor9);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            i8 &= -29360129;
                            jM6824unboximpl = ((Color) objConsume9).m6824unboximpl();
                        } else {
                            jM6824unboximpl = j;
                        }
                        if ((i2 & 256) != 0) {
                            jM6813copywmQWz5c$default = Color.m6813copywmQWz5c$default(jM6824unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                            i8 &= -234881025;
                        } else {
                            jM6813copywmQWz5c$default = j2;
                        }
                    }
                    final boolean z11 = z3;
                    final MutableInteractionSource mutableInteractionSource9 = mutableInteractionSource2;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-524682663, i8, -1, "androidx.compose.material.LeadingIconTab (Tab.kt:159)");
                    }
                    final IndicationNodeFactory indicationNodeFactoryM2523rippleH2RKhps$default6 = RippleKt.m2523rippleH2RKhps$default(true, 0.0f, jM6824unboximpl, 2, null);
                    final Modifier modifier9 = modifier2;
                    final Function2 function10 = function4;
                    int i112 = i8 >> 21;
                    long j10 = jM6824unboximpl;
                    m2608TabTransitionKlgxPg(j10, jM6813copywmQWz5c$default, z, ComposableLambdaKt.rememberComposableLambda(-1415722219, true, new Function2() { // from class: androidx.compose.material.TabKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return TabKt.LeadingIconTab_0nD_MI0$lambda$0(modifier9, z, mutableInteractionSource9, indicationNodeFactoryM2523rippleH2RKhps$default6, z11, function0, function10, function2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i8 << 6) & 896) | (i112 & 112) | (i112 & 14) | 3072);
                    composer2 = composerStartRestartGroup;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier9;
                    mutableInteractionSource3 = mutableInteractionSource9;
                    z5 = z11;
                    j4 = jM6813copywmQWz5c$default;
                    j3 = jM6824unboximpl;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    j3 = j;
                    modifier3 = modifier2;
                    z5 = z3;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    j4 = j2;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.TabKt$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return TabKt.LeadingIconTab_0nD_MI0$lambda$1(z, function0, function2, function3, modifier3, z5, mutableInteractionSource3, j3, j4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 1572864;
            mutableInteractionSource2 = mutableInteractionSource;
            if ((12582912 & i) == 0) {
                int i113 = i3;
                if ((i2 & 128) == 0) {
                    i10 = 4194304;
                } else {
                    i10 = 4194304;
                }
                i8 = i113 | i10;
            } else {
                i8 = i3;
            }
            if ((i & 100663296) != 0) {
                if ((i2 & 256) == 0) {
                    i9 = 33554432;
                } else {
                    i9 = 33554432;
                }
                i8 |= i9;
            }
            if ((38347923 & i8) != 38347922) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z4, i8 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "157@6806L7,158@6898L6");
                if ((i & 1) != 0) {
                    if (i11 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    }
                    if (i6 != 0) {
                        mutableInteractionSource2 = null;
                    }
                    if ((i2 & 128) != 0) {
                        ProvidableCompositionLocal<Color> localContentColor10 = ContentColorKt.getLocalContentColor();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object objConsume10 = composerStartRestartGroup.consume(localContentColor10);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        i8 &= -29360129;
                        jM6824unboximpl = ((Color) objConsume10).m6824unboximpl();
                    } else {
                        jM6824unboximpl = j;
                    }
                    if ((i2 & 256) != 0) {
                        jM6813copywmQWz5c$default = Color.m6813copywmQWz5c$default(jM6824unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                        i8 &= -234881025;
                    } else {
                        jM6813copywmQWz5c$default = j2;
                    }
                } else {
                    if (i11 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    }
                    if (i6 != 0) {
                        mutableInteractionSource2 = null;
                    }
                    if ((i2 & 128) != 0) {
                        ProvidableCompositionLocal<Color> localContentColor11 = ContentColorKt.getLocalContentColor();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object objConsume11 = composerStartRestartGroup.consume(localContentColor11);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        i8 &= -29360129;
                        jM6824unboximpl = ((Color) objConsume11).m6824unboximpl();
                    } else {
                        jM6824unboximpl = j;
                    }
                    if ((i2 & 256) != 0) {
                        jM6813copywmQWz5c$default = Color.m6813copywmQWz5c$default(jM6824unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                        i8 &= -234881025;
                    } else {
                        jM6813copywmQWz5c$default = j2;
                    }
                }
                final boolean z12 = z3;
                final MutableInteractionSource mutableInteractionSource10 = mutableInteractionSource2;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-524682663, i8, -1, "androidx.compose.material.LeadingIconTab (Tab.kt:159)");
                }
                final IndicationNodeFactory indicationNodeFactoryM2523rippleH2RKhps$default7 = RippleKt.m2523rippleH2RKhps$default(true, 0.0f, jM6824unboximpl, 2, null);
                final Modifier modifier10 = modifier2;
                final Function2 function11 = function4;
                int i114 = i8 >> 21;
                long j11 = jM6824unboximpl;
                m2608TabTransitionKlgxPg(j11, jM6813copywmQWz5c$default, z, ComposableLambdaKt.rememberComposableLambda(-1415722219, true, new Function2() { // from class: androidx.compose.material.TabKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return TabKt.LeadingIconTab_0nD_MI0$lambda$0(modifier10, z, mutableInteractionSource10, indicationNodeFactoryM2523rippleH2RKhps$default7, z12, function0, function11, function2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i8 << 6) & 896) | (i114 & 112) | (i114 & 14) | 3072);
                composer2 = composerStartRestartGroup;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier10;
                mutableInteractionSource3 = mutableInteractionSource10;
                z5 = z12;
                j4 = jM6813copywmQWz5c$default;
                j3 = jM6824unboximpl;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                j3 = j;
                modifier3 = modifier2;
                z5 = z3;
                mutableInteractionSource3 = mutableInteractionSource2;
                j4 = j2;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.TabKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return TabKt.LeadingIconTab_0nD_MI0$lambda$1(z, function0, function2, function3, modifier3, z5, mutableInteractionSource3, j3, j4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        z3 = z2;
        i6 = i2 & 64;
        if (i6 != 0) {
            if ((1572864 & i) == 0) {
                mutableInteractionSource2 = mutableInteractionSource;
                if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                    i7 = 1048576;
                } else {
                    i7 = 524288;
                }
                i3 |= i7;
            }
            if ((12582912 & i) == 0) {
                int i115 = i3;
                if ((i2 & 128) == 0) {
                    i10 = 4194304;
                } else {
                    i10 = 4194304;
                }
                i8 = i115 | i10;
            } else {
                i8 = i3;
            }
            if ((i & 100663296) != 0) {
                if ((i2 & 256) == 0) {
                    i9 = 33554432;
                } else {
                    i9 = 33554432;
                }
                i8 |= i9;
            }
            if ((38347923 & i8) != 38347922) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z4, i8 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "157@6806L7,158@6898L6");
                if ((i & 1) != 0) {
                    if (i11 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    }
                    if (i6 != 0) {
                        mutableInteractionSource2 = null;
                    }
                    if ((i2 & 128) != 0) {
                        ProvidableCompositionLocal<Color> localContentColor12 = ContentColorKt.getLocalContentColor();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object objConsume12 = composerStartRestartGroup.consume(localContentColor12);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        i8 &= -29360129;
                        jM6824unboximpl = ((Color) objConsume12).m6824unboximpl();
                    } else {
                        jM6824unboximpl = j;
                    }
                    if ((i2 & 256) != 0) {
                        jM6813copywmQWz5c$default = Color.m6813copywmQWz5c$default(jM6824unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                        i8 &= -234881025;
                    } else {
                        jM6813copywmQWz5c$default = j2;
                    }
                } else {
                    if (i11 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    }
                    if (i6 != 0) {
                        mutableInteractionSource2 = null;
                    }
                    if ((i2 & 128) != 0) {
                        ProvidableCompositionLocal<Color> localContentColor13 = ContentColorKt.getLocalContentColor();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object objConsume13 = composerStartRestartGroup.consume(localContentColor13);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        i8 &= -29360129;
                        jM6824unboximpl = ((Color) objConsume13).m6824unboximpl();
                    } else {
                        jM6824unboximpl = j;
                    }
                    if ((i2 & 256) != 0) {
                        jM6813copywmQWz5c$default = Color.m6813copywmQWz5c$default(jM6824unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                        i8 &= -234881025;
                    } else {
                        jM6813copywmQWz5c$default = j2;
                    }
                }
                final boolean z13 = z3;
                final MutableInteractionSource mutableInteractionSource11 = mutableInteractionSource2;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-524682663, i8, -1, "androidx.compose.material.LeadingIconTab (Tab.kt:159)");
                }
                final IndicationNodeFactory indicationNodeFactoryM2523rippleH2RKhps$default8 = RippleKt.m2523rippleH2RKhps$default(true, 0.0f, jM6824unboximpl, 2, null);
                final Modifier modifier11 = modifier2;
                final Function2 function12 = function4;
                int i116 = i8 >> 21;
                long j12 = jM6824unboximpl;
                m2608TabTransitionKlgxPg(j12, jM6813copywmQWz5c$default, z, ComposableLambdaKt.rememberComposableLambda(-1415722219, true, new Function2() { // from class: androidx.compose.material.TabKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return TabKt.LeadingIconTab_0nD_MI0$lambda$0(modifier11, z, mutableInteractionSource11, indicationNodeFactoryM2523rippleH2RKhps$default8, z13, function0, function12, function2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i8 << 6) & 896) | (i116 & 112) | (i116 & 14) | 3072);
                composer2 = composerStartRestartGroup;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier11;
                mutableInteractionSource3 = mutableInteractionSource11;
                z5 = z13;
                j4 = jM6813copywmQWz5c$default;
                j3 = jM6824unboximpl;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                j3 = j;
                modifier3 = modifier2;
                z5 = z3;
                mutableInteractionSource3 = mutableInteractionSource2;
                j4 = j2;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.TabKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return TabKt.LeadingIconTab_0nD_MI0$lambda$1(z, function0, function2, function3, modifier3, z5, mutableInteractionSource3, j3, j4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 1572864;
        mutableInteractionSource2 = mutableInteractionSource;
        if ((12582912 & i) == 0) {
            int i117 = i3;
            if ((i2 & 128) == 0) {
                i10 = 4194304;
            } else {
                i10 = 4194304;
            }
            i8 = i117 | i10;
        } else {
            i8 = i3;
        }
        if ((i & 100663296) != 0) {
            if ((i2 & 256) == 0) {
                i9 = 33554432;
            } else {
                i9 = 33554432;
            }
            i8 |= i9;
        }
        if ((38347923 & i8) != 38347922) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z4, i8 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "157@6806L7,158@6898L6");
            if ((i & 1) != 0) {
                if (i11 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i4 != 0) {
                    z3 = true;
                }
                if (i6 != 0) {
                    mutableInteractionSource2 = null;
                }
                if ((i2 & 128) != 0) {
                    ProvidableCompositionLocal<Color> localContentColor14 = ContentColorKt.getLocalContentColor();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume14 = composerStartRestartGroup.consume(localContentColor14);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    i8 &= -29360129;
                    jM6824unboximpl = ((Color) objConsume14).m6824unboximpl();
                } else {
                    jM6824unboximpl = j;
                }
                if ((i2 & 256) != 0) {
                    jM6813copywmQWz5c$default = Color.m6813copywmQWz5c$default(jM6824unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                    i8 &= -234881025;
                } else {
                    jM6813copywmQWz5c$default = j2;
                }
            } else {
                if (i11 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i4 != 0) {
                    z3 = true;
                }
                if (i6 != 0) {
                    mutableInteractionSource2 = null;
                }
                if ((i2 & 128) != 0) {
                    ProvidableCompositionLocal<Color> localContentColor15 = ContentColorKt.getLocalContentColor();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume15 = composerStartRestartGroup.consume(localContentColor15);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    i8 &= -29360129;
                    jM6824unboximpl = ((Color) objConsume15).m6824unboximpl();
                } else {
                    jM6824unboximpl = j;
                }
                if ((i2 & 256) != 0) {
                    jM6813copywmQWz5c$default = Color.m6813copywmQWz5c$default(jM6824unboximpl, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                    i8 &= -234881025;
                } else {
                    jM6813copywmQWz5c$default = j2;
                }
            }
            final boolean z14 = z3;
            final MutableInteractionSource mutableInteractionSource12 = mutableInteractionSource2;
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-524682663, i8, -1, "androidx.compose.material.LeadingIconTab (Tab.kt:159)");
            }
            final IndicationNodeFactory indicationNodeFactoryM2523rippleH2RKhps$default9 = RippleKt.m2523rippleH2RKhps$default(true, 0.0f, jM6824unboximpl, 2, null);
            final Modifier modifier12 = modifier2;
            final Function2 function13 = function4;
            int i118 = i8 >> 21;
            long j13 = jM6824unboximpl;
            m2608TabTransitionKlgxPg(j13, jM6813copywmQWz5c$default, z, ComposableLambdaKt.rememberComposableLambda(-1415722219, true, new Function2() { // from class: androidx.compose.material.TabKt$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TabKt.LeadingIconTab_0nD_MI0$lambda$0(modifier12, z, mutableInteractionSource12, indicationNodeFactoryM2523rippleH2RKhps$default9, z14, function0, function13, function2, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i8 << 6) & 896) | (i118 & 112) | (i118 & 14) | 3072);
            composer2 = composerStartRestartGroup;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier12;
            mutableInteractionSource3 = mutableInteractionSource12;
            z5 = z14;
            j4 = jM6813copywmQWz5c$default;
            j3 = jM6824unboximpl;
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            j3 = j;
            modifier3 = modifier2;
            z5 = z3;
            mutableInteractionSource3 = mutableInteractionSource2;
            j4 = j2;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.TabKt$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TabKt.LeadingIconTab_0nD_MI0$lambda$1(z, function0, function2, function3, modifier3, z5, mutableInteractionSource3, j3, j4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LeadingIconTab_0nD_MI0$lambda$0(Modifier modifier, boolean z, MutableInteractionSource mutableInteractionSource, IndicationNodeFactory indicationNodeFactory, boolean z2, Function0 function0, Function2 function2, Function2 function3, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C166@7285L905:Tab.kt#jmzs0o");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1415722219, i, -1, "androidx.compose.material.LeadingIconTab.<anonymous> (Tab.kt:166)");
            }
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(PaddingKt.m1220paddingVpY3zN4$default(SelectableKt.m1533selectableO2vRcR0(SizeKt.m1252height3ABfNKs(modifier, SmallTabHeight), z, mutableInteractionSource, indicationNodeFactory, z2, Role.m8825boximpl(Role.INSTANCE.m8839getTabo7Vup1c()), function0), HorizontalTextPadding, 0.0f, 2, null), 0.0f, 1, null);
            Arrangement.HorizontalOrVertical center = Arrangement.INSTANCE.getCenter();
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(composer, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(center, centerVertically, composer, 54);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierFillMaxWidth$default);
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
            ComposerKt.sourceInformationMarkerStart(composer, 322948405, "C183@7959L6,184@7978L59,185@8076L10,186@8141L39:Tab.kt#jmzs0o");
            function2.invoke(composer, 0);
            SpacerKt.Spacer(SizeKt.m1263requiredWidth3ABfNKs(Modifier.INSTANCE, TextDistanceFromLeadingIcon), composer, 6);
            TextKt.ProvideTextStyle(TextStyle.m9104copyp1EtxEg$default(MaterialTheme.INSTANCE.getTypography(composer, 6).getButton(), 0L, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, TextAlign.INSTANCE.m9526getCentere0LSkKk(), 0, 0L, null, null, null, 0, 0, null, 16744447, null), function3, composer, 0);
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

    /* JADX WARN: Code duplicated, block: B:101:0x0125 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:102:0x0127  */
    /* JADX WARN: Code duplicated, block: B:104:0x012e  */
    /* JADX WARN: Code duplicated, block: B:106:0x0131  */
    /* JADX WARN: Code duplicated, block: B:109:0x0137  */
    /* JADX WARN: Code duplicated, block: B:110:0x0155  */
    /* JADX WARN: Code duplicated, block: B:113:0x015d  */
    /* JADX WARN: Code duplicated, block: B:114:0x017b  */
    /* JADX WARN: Code duplicated, block: B:117:0x0188  */
    /* JADX WARN: Code duplicated, block: B:120:0x01d6  */
    /* JADX WARN: Code duplicated, block: B:122:0x01e1  */
    /* JADX WARN: Code duplicated, block: B:125:0x01f0  */
    /* JADX WARN: Code duplicated, block: B:127:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:31:0x0057  */
    /* JADX WARN: Code duplicated, block: B:32:0x005a  */
    /* JADX WARN: Code duplicated, block: B:34:0x005e  */
    /* JADX WARN: Code duplicated, block: B:36:0x0066  */
    /* JADX WARN: Code duplicated, block: B:37:0x0069  */
    /* JADX WARN: Code duplicated, block: B:42:0x0073  */
    /* JADX WARN: Code duplicated, block: B:43:0x0076  */
    /* JADX WARN: Code duplicated, block: B:45:0x007a  */
    /* JADX WARN: Code duplicated, block: B:47:0x0082  */
    /* JADX WARN: Code duplicated, block: B:48:0x0085  */
    /* JADX WARN: Code duplicated, block: B:53:0x0090  */
    /* JADX WARN: Code duplicated, block: B:55:0x0094  */
    /* JADX WARN: Code duplicated, block: B:57:0x009c  */
    /* JADX WARN: Code duplicated, block: B:58:0x009f  */
    /* JADX WARN: Code duplicated, block: B:61:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:64:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:66:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:68:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:69:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:72:0x00c2  */
    /* JADX WARN: Code duplicated, block: B:75:0x00cc  */
    /* JADX WARN: Code duplicated, block: B:77:0x00d2  */
    /* JADX WARN: Code duplicated, block: B:78:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:82:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:83:0x00e8  */
    /* JADX WARN: Code duplicated, block: B:86:0x00f1  */
    /* JADX WARN: Code duplicated, block: B:88:0x0104  */
    /* JADX INFO: renamed from: Tab-EVJuX4I, reason: not valid java name */
    public static final void m2607TabEVJuX4I(final boolean z, final Function0<Unit> function0, Modifier modifier, boolean z2, MutableInteractionSource mutableInteractionSource, long j, long j2, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        boolean z3;
        int i5;
        int i6;
        MutableInteractionSource mutableInteractionSource2;
        int i7;
        long jM6824unboximpl;
        long j3;
        int i8;
        boolean z4;
        final Modifier modifier3;
        final boolean z5;
        final MutableInteractionSource mutableInteractionSource3;
        final long j4;
        final long j5;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i9;
        long j6;
        final Modifier modifier4;
        final boolean z6;
        long jM6813copywmQWz5c$default;
        int i10;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1847932236);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Tab)N(selected,onClick,modifier,enabled,interactionSource,selectedContentColor:c#ui.graphics.Color,unselectedContentColor:c#ui.graphics.Color,content)235@10460L602,235@10390L672:Tab.kt#jmzs0o");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function0) ? 32 : 16;
        }
        int i11 = i2 & 4;
        if (i11 == 0) {
            if ((i & 384) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            i4 = i2 & 8;
            if (i4 != 0) {
                if ((i & 3072) == 0) {
                    z3 = z2;
                    if (composerStartRestartGroup.changed(z3)) {
                        i5 = 2048;
                    } else {
                        i5 = 1024;
                    }
                    i3 |= i5;
                }
                i6 = i2 & 16;
                if (i6 != 0) {
                    if ((i & 24576) == 0) {
                        mutableInteractionSource2 = mutableInteractionSource;
                        if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                            i7 = 16384;
                        } else {
                            i7 = 8192;
                        }
                        i3 |= i7;
                    }
                    if ((196608 & i) == 0) {
                        if ((i2 & 32) == 0) {
                            jM6824unboximpl = j;
                            int i12 = composerStartRestartGroup.changed(jM6824unboximpl) ? 131072 : 65536;
                            i3 |= i12;
                        } else {
                            jM6824unboximpl = j;
                        }
                        i3 |= i12;
                    } else {
                        jM6824unboximpl = j;
                    }
                    if ((1572864 & i) == 0) {
                        if ((i2 & 64) == 0) {
                            j3 = j2;
                            int i13 = composerStartRestartGroup.changed(j3) ? 1048576 : 524288;
                            i3 |= i13;
                        } else {
                            j3 = j2;
                        }
                        i3 |= i13;
                    } else {
                        j3 = j2;
                    }
                    if ((i & 12582912) == 0) {
                        if (composerStartRestartGroup.changedInstance(function3)) {
                            i10 = 8388608;
                        } else {
                            i10 = 4194304;
                        }
                        i3 |= i10;
                    }
                    i8 = i3;
                    if ((i3 & 4793491) != 4793490) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z4, i8 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "226@9945L7,227@10037L6");
                        if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            if (i11 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                z3 = true;
                            }
                            if (i6 != 0) {
                                mutableInteractionSource2 = null;
                            }
                            if ((i2 & 32) != 0) {
                                ProvidableCompositionLocal<Color> localContentColor = ContentColorKt.getLocalContentColor();
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                Object objConsume = composerStartRestartGroup.consume(localContentColor);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                jM6824unboximpl = ((Color) objConsume).m6824unboximpl();
                                i9 = i8 & (-458753);
                            } else {
                                i9 = i8;
                            }
                            j6 = jM6824unboximpl;
                            if ((i2 & 64) != 0) {
                                i9 &= -3670017;
                                modifier4 = modifier2;
                                jM6813copywmQWz5c$default = Color.m6813copywmQWz5c$default(j6, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                                z6 = z3;
                            } else {
                                modifier4 = modifier2;
                                z6 = z3;
                            }
                            final MutableInteractionSource mutableInteractionSource4 = mutableInteractionSource2;
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1847932236, i9, -1, "androidx.compose.material.Tab (Tab.kt:229)");
                            }
                            long j7 = j6;
                            final IndicationNodeFactory indicationNodeFactoryM2523rippleH2RKhps$default = RippleKt.m2523rippleH2RKhps$default(true, 0.0f, j7, 2, null);
                            int i14 = i9 >> 15;
                            m2608TabTransitionKlgxPg(j7, jM6813copywmQWz5c$default, z, ComposableLambdaKt.rememberComposableLambda(-652402312, true, new Function2() { // from class: androidx.compose.material.TabKt$$ExternalSyntheticLambda8
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return TabKt.Tab_EVJuX4I$lambda$0(modifier4, z, mutableInteractionSource4, indicationNodeFactoryM2523rippleH2RKhps$default, z6, function0, function3, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i9 << 6) & 896) | (i14 & 112) | (i14 & 14) | 3072);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            j4 = j7;
                            mutableInteractionSource3 = mutableInteractionSource4;
                            j5 = jM6813copywmQWz5c$default;
                            modifier3 = modifier4;
                            z5 = z6;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            i9 = (i2 & 32) != 0 ? i8 & (-458753) : i8;
                            if ((i2 & 64) != 0) {
                                i9 &= -3670017;
                            }
                            z6 = z3;
                            j6 = jM6824unboximpl;
                            modifier4 = modifier2;
                        }
                        jM6813copywmQWz5c$default = j3;
                        final MutableInteractionSource mutableInteractionSource5 = mutableInteractionSource2;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1847932236, i9, -1, "androidx.compose.material.Tab (Tab.kt:229)");
                        }
                        long j8 = j6;
                        final IndicationNodeFactory indicationNodeFactoryM2523rippleH2RKhps$default2 = RippleKt.m2523rippleH2RKhps$default(true, 0.0f, j8, 2, null);
                        int i15 = i9 >> 15;
                        m2608TabTransitionKlgxPg(j8, jM6813copywmQWz5c$default, z, ComposableLambdaKt.rememberComposableLambda(-652402312, true, new Function2() { // from class: androidx.compose.material.TabKt$$ExternalSyntheticLambda8
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return TabKt.Tab_EVJuX4I$lambda$0(modifier4, z, mutableInteractionSource5, indicationNodeFactoryM2523rippleH2RKhps$default2, z6, function0, function3, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i9 << 6) & 896) | (i15 & 112) | (i15 & 14) | 3072);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        j4 = j8;
                        mutableInteractionSource3 = mutableInteractionSource5;
                        j5 = jM6813copywmQWz5c$default;
                        modifier3 = modifier4;
                        z5 = z6;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        modifier3 = modifier2;
                        z5 = z3;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        j4 = jM6824unboximpl;
                        j5 = j3;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.TabKt$$ExternalSyntheticLambda9
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return TabKt.Tab_EVJuX4I$lambda$1(z, function0, modifier3, z5, mutableInteractionSource3, j4, j5, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= 24576;
                mutableInteractionSource2 = mutableInteractionSource;
                if ((196608 & i) == 0) {
                    if ((i2 & 32) == 0) {
                        jM6824unboximpl = j;
                        if (composerStartRestartGroup.changed(jM6824unboximpl)) {
                        }
                        i3 |= i12;
                    } else {
                        jM6824unboximpl = j;
                    }
                    i3 |= i12;
                } else {
                    jM6824unboximpl = j;
                }
                if ((1572864 & i) == 0) {
                    if ((i2 & 64) == 0) {
                        j3 = j2;
                        if (composerStartRestartGroup.changed(j3)) {
                        }
                        i3 |= i13;
                    } else {
                        j3 = j2;
                    }
                    i3 |= i13;
                } else {
                    j3 = j2;
                }
                if ((i & 12582912) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i10 = 8388608;
                    } else {
                        i10 = 4194304;
                    }
                    i3 |= i10;
                }
                i8 = i3;
                if ((i3 & 4793491) != 4793490) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z4, i8 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "226@9945L7,227@10037L6");
                    if ((i & 1) != 0) {
                        if (i11 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        }
                        if (i6 != 0) {
                            mutableInteractionSource2 = null;
                        }
                        if ((i2 & 32) != 0) {
                            ProvidableCompositionLocal<Color> localContentColor2 = ContentColorKt.getLocalContentColor();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                            Object objConsume2 = composerStartRestartGroup.consume(localContentColor2);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            jM6824unboximpl = ((Color) objConsume2).m6824unboximpl();
                            i9 = i8 & (-458753);
                        } else {
                            i9 = i8;
                        }
                        j6 = jM6824unboximpl;
                        if ((i2 & 64) != 0) {
                            i9 &= -3670017;
                            modifier4 = modifier2;
                            jM6813copywmQWz5c$default = Color.m6813copywmQWz5c$default(j6, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                            z6 = z3;
                        } else {
                            modifier4 = modifier2;
                            z6 = z3;
                            jM6813copywmQWz5c$default = j3;
                        }
                    } else {
                        if (i11 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        }
                        if (i6 != 0) {
                            mutableInteractionSource2 = null;
                        }
                        if ((i2 & 32) != 0) {
                            ProvidableCompositionLocal<Color> localContentColor3 = ContentColorKt.getLocalContentColor();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                            Object objConsume3 = composerStartRestartGroup.consume(localContentColor3);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            jM6824unboximpl = ((Color) objConsume3).m6824unboximpl();
                            i9 = i8 & (-458753);
                        } else {
                            i9 = i8;
                        }
                        j6 = jM6824unboximpl;
                        if ((i2 & 64) != 0) {
                            i9 &= -3670017;
                            modifier4 = modifier2;
                            jM6813copywmQWz5c$default = Color.m6813copywmQWz5c$default(j6, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                            z6 = z3;
                        } else {
                            modifier4 = modifier2;
                            z6 = z3;
                            jM6813copywmQWz5c$default = j3;
                        }
                    }
                    final MutableInteractionSource mutableInteractionSource6 = mutableInteractionSource2;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1847932236, i9, -1, "androidx.compose.material.Tab (Tab.kt:229)");
                    }
                    long j9 = j6;
                    final IndicationNodeFactory indicationNodeFactoryM2523rippleH2RKhps$default3 = RippleKt.m2523rippleH2RKhps$default(true, 0.0f, j9, 2, null);
                    int i16 = i9 >> 15;
                    m2608TabTransitionKlgxPg(j9, jM6813copywmQWz5c$default, z, ComposableLambdaKt.rememberComposableLambda(-652402312, true, new Function2() { // from class: androidx.compose.material.TabKt$$ExternalSyntheticLambda8
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return TabKt.Tab_EVJuX4I$lambda$0(modifier4, z, mutableInteractionSource6, indicationNodeFactoryM2523rippleH2RKhps$default3, z6, function0, function3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i9 << 6) & 896) | (i16 & 112) | (i16 & 14) | 3072);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    j4 = j9;
                    mutableInteractionSource3 = mutableInteractionSource6;
                    j5 = jM6813copywmQWz5c$default;
                    modifier3 = modifier4;
                    z5 = z6;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier3 = modifier2;
                    z5 = z3;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    j4 = jM6824unboximpl;
                    j5 = j3;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.TabKt$$ExternalSyntheticLambda9
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return TabKt.Tab_EVJuX4I$lambda$1(z, function0, modifier3, z5, mutableInteractionSource3, j4, j5, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 3072;
            z3 = z2;
            i6 = i2 & 16;
            if (i6 != 0) {
                if ((i & 24576) == 0) {
                    mutableInteractionSource2 = mutableInteractionSource;
                    if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                        i7 = 16384;
                    } else {
                        i7 = 8192;
                    }
                    i3 |= i7;
                }
                if ((196608 & i) == 0) {
                    if ((i2 & 32) == 0) {
                        jM6824unboximpl = j;
                        if (composerStartRestartGroup.changed(jM6824unboximpl)) {
                        }
                        i3 |= i12;
                    } else {
                        jM6824unboximpl = j;
                    }
                    i3 |= i12;
                } else {
                    jM6824unboximpl = j;
                }
                if ((1572864 & i) == 0) {
                    if ((i2 & 64) == 0) {
                        j3 = j2;
                        if (composerStartRestartGroup.changed(j3)) {
                        }
                        i3 |= i13;
                    } else {
                        j3 = j2;
                    }
                    i3 |= i13;
                } else {
                    j3 = j2;
                }
                if ((i & 12582912) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i10 = 8388608;
                    } else {
                        i10 = 4194304;
                    }
                    i3 |= i10;
                }
                i8 = i3;
                if ((i3 & 4793491) != 4793490) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z4, i8 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "226@9945L7,227@10037L6");
                    if ((i & 1) != 0) {
                        if (i11 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        }
                        if (i6 != 0) {
                            mutableInteractionSource2 = null;
                        }
                        if ((i2 & 32) != 0) {
                            ProvidableCompositionLocal<Color> localContentColor4 = ContentColorKt.getLocalContentColor();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                            Object objConsume4 = composerStartRestartGroup.consume(localContentColor4);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            jM6824unboximpl = ((Color) objConsume4).m6824unboximpl();
                            i9 = i8 & (-458753);
                        } else {
                            i9 = i8;
                        }
                        j6 = jM6824unboximpl;
                        if ((i2 & 64) != 0) {
                            i9 &= -3670017;
                            modifier4 = modifier2;
                            jM6813copywmQWz5c$default = Color.m6813copywmQWz5c$default(j6, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                            z6 = z3;
                        } else {
                            modifier4 = modifier2;
                            z6 = z3;
                            jM6813copywmQWz5c$default = j3;
                        }
                    } else {
                        if (i11 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        }
                        if (i6 != 0) {
                            mutableInteractionSource2 = null;
                        }
                        if ((i2 & 32) != 0) {
                            ProvidableCompositionLocal<Color> localContentColor5 = ContentColorKt.getLocalContentColor();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                            Object objConsume5 = composerStartRestartGroup.consume(localContentColor5);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            jM6824unboximpl = ((Color) objConsume5).m6824unboximpl();
                            i9 = i8 & (-458753);
                        } else {
                            i9 = i8;
                        }
                        j6 = jM6824unboximpl;
                        if ((i2 & 64) != 0) {
                            i9 &= -3670017;
                            modifier4 = modifier2;
                            jM6813copywmQWz5c$default = Color.m6813copywmQWz5c$default(j6, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                            z6 = z3;
                        } else {
                            modifier4 = modifier2;
                            z6 = z3;
                            jM6813copywmQWz5c$default = j3;
                        }
                    }
                    final MutableInteractionSource mutableInteractionSource7 = mutableInteractionSource2;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1847932236, i9, -1, "androidx.compose.material.Tab (Tab.kt:229)");
                    }
                    long j10 = j6;
                    final IndicationNodeFactory indicationNodeFactoryM2523rippleH2RKhps$default4 = RippleKt.m2523rippleH2RKhps$default(true, 0.0f, j10, 2, null);
                    int i17 = i9 >> 15;
                    m2608TabTransitionKlgxPg(j10, jM6813copywmQWz5c$default, z, ComposableLambdaKt.rememberComposableLambda(-652402312, true, new Function2() { // from class: androidx.compose.material.TabKt$$ExternalSyntheticLambda8
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return TabKt.Tab_EVJuX4I$lambda$0(modifier4, z, mutableInteractionSource7, indicationNodeFactoryM2523rippleH2RKhps$default4, z6, function0, function3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i9 << 6) & 896) | (i17 & 112) | (i17 & 14) | 3072);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    j4 = j10;
                    mutableInteractionSource3 = mutableInteractionSource7;
                    j5 = jM6813copywmQWz5c$default;
                    modifier3 = modifier4;
                    z5 = z6;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier3 = modifier2;
                    z5 = z3;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    j4 = jM6824unboximpl;
                    j5 = j3;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.TabKt$$ExternalSyntheticLambda9
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return TabKt.Tab_EVJuX4I$lambda$1(z, function0, modifier3, z5, mutableInteractionSource3, j4, j5, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 24576;
            mutableInteractionSource2 = mutableInteractionSource;
            if ((196608 & i) == 0) {
                if ((i2 & 32) == 0) {
                    jM6824unboximpl = j;
                    if (composerStartRestartGroup.changed(jM6824unboximpl)) {
                    }
                    i3 |= i12;
                } else {
                    jM6824unboximpl = j;
                }
                i3 |= i12;
            } else {
                jM6824unboximpl = j;
            }
            if ((1572864 & i) == 0) {
                if ((i2 & 64) == 0) {
                    j3 = j2;
                    if (composerStartRestartGroup.changed(j3)) {
                    }
                    i3 |= i13;
                } else {
                    j3 = j2;
                }
                i3 |= i13;
            } else {
                j3 = j2;
            }
            if ((i & 12582912) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i10 = 8388608;
                } else {
                    i10 = 4194304;
                }
                i3 |= i10;
            }
            i8 = i3;
            if ((i3 & 4793491) != 4793490) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z4, i8 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "226@9945L7,227@10037L6");
                if ((i & 1) != 0) {
                    if (i11 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    }
                    if (i6 != 0) {
                        mutableInteractionSource2 = null;
                    }
                    if ((i2 & 32) != 0) {
                        ProvidableCompositionLocal<Color> localContentColor6 = ContentColorKt.getLocalContentColor();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object objConsume6 = composerStartRestartGroup.consume(localContentColor6);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        jM6824unboximpl = ((Color) objConsume6).m6824unboximpl();
                        i9 = i8 & (-458753);
                    } else {
                        i9 = i8;
                    }
                    j6 = jM6824unboximpl;
                    if ((i2 & 64) != 0) {
                        i9 &= -3670017;
                        modifier4 = modifier2;
                        jM6813copywmQWz5c$default = Color.m6813copywmQWz5c$default(j6, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                        z6 = z3;
                    } else {
                        modifier4 = modifier2;
                        z6 = z3;
                        jM6813copywmQWz5c$default = j3;
                    }
                } else {
                    if (i11 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    }
                    if (i6 != 0) {
                        mutableInteractionSource2 = null;
                    }
                    if ((i2 & 32) != 0) {
                        ProvidableCompositionLocal<Color> localContentColor7 = ContentColorKt.getLocalContentColor();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object objConsume7 = composerStartRestartGroup.consume(localContentColor7);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        jM6824unboximpl = ((Color) objConsume7).m6824unboximpl();
                        i9 = i8 & (-458753);
                    } else {
                        i9 = i8;
                    }
                    j6 = jM6824unboximpl;
                    if ((i2 & 64) != 0) {
                        i9 &= -3670017;
                        modifier4 = modifier2;
                        jM6813copywmQWz5c$default = Color.m6813copywmQWz5c$default(j6, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                        z6 = z3;
                    } else {
                        modifier4 = modifier2;
                        z6 = z3;
                        jM6813copywmQWz5c$default = j3;
                    }
                }
                final MutableInteractionSource mutableInteractionSource8 = mutableInteractionSource2;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1847932236, i9, -1, "androidx.compose.material.Tab (Tab.kt:229)");
                }
                long j11 = j6;
                final IndicationNodeFactory indicationNodeFactoryM2523rippleH2RKhps$default5 = RippleKt.m2523rippleH2RKhps$default(true, 0.0f, j11, 2, null);
                int i18 = i9 >> 15;
                m2608TabTransitionKlgxPg(j11, jM6813copywmQWz5c$default, z, ComposableLambdaKt.rememberComposableLambda(-652402312, true, new Function2() { // from class: androidx.compose.material.TabKt$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return TabKt.Tab_EVJuX4I$lambda$0(modifier4, z, mutableInteractionSource8, indicationNodeFactoryM2523rippleH2RKhps$default5, z6, function0, function3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i9 << 6) & 896) | (i18 & 112) | (i18 & 14) | 3072);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                j4 = j11;
                mutableInteractionSource3 = mutableInteractionSource8;
                j5 = jM6813copywmQWz5c$default;
                modifier3 = modifier4;
                z5 = z6;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                z5 = z3;
                mutableInteractionSource3 = mutableInteractionSource2;
                j4 = jM6824unboximpl;
                j5 = j3;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.TabKt$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return TabKt.Tab_EVJuX4I$lambda$1(z, function0, modifier3, z5, mutableInteractionSource3, j4, j5, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 384;
        modifier2 = modifier;
        i4 = i2 & 8;
        if (i4 != 0) {
            if ((i & 3072) == 0) {
                z3 = z2;
                if (composerStartRestartGroup.changed(z3)) {
                    i5 = 2048;
                } else {
                    i5 = 1024;
                }
                i3 |= i5;
            }
            i6 = i2 & 16;
            if (i6 != 0) {
                if ((i & 24576) == 0) {
                    mutableInteractionSource2 = mutableInteractionSource;
                    if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                        i7 = 16384;
                    } else {
                        i7 = 8192;
                    }
                    i3 |= i7;
                }
                if ((196608 & i) == 0) {
                    if ((i2 & 32) == 0) {
                        jM6824unboximpl = j;
                        if (composerStartRestartGroup.changed(jM6824unboximpl)) {
                        }
                        i3 |= i12;
                    } else {
                        jM6824unboximpl = j;
                    }
                    i3 |= i12;
                } else {
                    jM6824unboximpl = j;
                }
                if ((1572864 & i) == 0) {
                    if ((i2 & 64) == 0) {
                        j3 = j2;
                        if (composerStartRestartGroup.changed(j3)) {
                        }
                        i3 |= i13;
                    } else {
                        j3 = j2;
                    }
                    i3 |= i13;
                } else {
                    j3 = j2;
                }
                if ((i & 12582912) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i10 = 8388608;
                    } else {
                        i10 = 4194304;
                    }
                    i3 |= i10;
                }
                i8 = i3;
                if ((i3 & 4793491) != 4793490) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z4, i8 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "226@9945L7,227@10037L6");
                    if ((i & 1) != 0) {
                        if (i11 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        }
                        if (i6 != 0) {
                            mutableInteractionSource2 = null;
                        }
                        if ((i2 & 32) != 0) {
                            ProvidableCompositionLocal<Color> localContentColor8 = ContentColorKt.getLocalContentColor();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                            Object objConsume8 = composerStartRestartGroup.consume(localContentColor8);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            jM6824unboximpl = ((Color) objConsume8).m6824unboximpl();
                            i9 = i8 & (-458753);
                        } else {
                            i9 = i8;
                        }
                        j6 = jM6824unboximpl;
                        if ((i2 & 64) != 0) {
                            i9 &= -3670017;
                            modifier4 = modifier2;
                            jM6813copywmQWz5c$default = Color.m6813copywmQWz5c$default(j6, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                            z6 = z3;
                        } else {
                            modifier4 = modifier2;
                            z6 = z3;
                            jM6813copywmQWz5c$default = j3;
                        }
                    } else {
                        if (i11 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        }
                        if (i6 != 0) {
                            mutableInteractionSource2 = null;
                        }
                        if ((i2 & 32) != 0) {
                            ProvidableCompositionLocal<Color> localContentColor9 = ContentColorKt.getLocalContentColor();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                            Object objConsume9 = composerStartRestartGroup.consume(localContentColor9);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            jM6824unboximpl = ((Color) objConsume9).m6824unboximpl();
                            i9 = i8 & (-458753);
                        } else {
                            i9 = i8;
                        }
                        j6 = jM6824unboximpl;
                        if ((i2 & 64) != 0) {
                            i9 &= -3670017;
                            modifier4 = modifier2;
                            jM6813copywmQWz5c$default = Color.m6813copywmQWz5c$default(j6, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                            z6 = z3;
                        } else {
                            modifier4 = modifier2;
                            z6 = z3;
                            jM6813copywmQWz5c$default = j3;
                        }
                    }
                    final MutableInteractionSource mutableInteractionSource9 = mutableInteractionSource2;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1847932236, i9, -1, "androidx.compose.material.Tab (Tab.kt:229)");
                    }
                    long j12 = j6;
                    final IndicationNodeFactory indicationNodeFactoryM2523rippleH2RKhps$default6 = RippleKt.m2523rippleH2RKhps$default(true, 0.0f, j12, 2, null);
                    int i19 = i9 >> 15;
                    m2608TabTransitionKlgxPg(j12, jM6813copywmQWz5c$default, z, ComposableLambdaKt.rememberComposableLambda(-652402312, true, new Function2() { // from class: androidx.compose.material.TabKt$$ExternalSyntheticLambda8
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return TabKt.Tab_EVJuX4I$lambda$0(modifier4, z, mutableInteractionSource9, indicationNodeFactoryM2523rippleH2RKhps$default6, z6, function0, function3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i9 << 6) & 896) | (i19 & 112) | (i19 & 14) | 3072);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    j4 = j12;
                    mutableInteractionSource3 = mutableInteractionSource9;
                    j5 = jM6813copywmQWz5c$default;
                    modifier3 = modifier4;
                    z5 = z6;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier3 = modifier2;
                    z5 = z3;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    j4 = jM6824unboximpl;
                    j5 = j3;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.TabKt$$ExternalSyntheticLambda9
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return TabKt.Tab_EVJuX4I$lambda$1(z, function0, modifier3, z5, mutableInteractionSource3, j4, j5, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 24576;
            mutableInteractionSource2 = mutableInteractionSource;
            if ((196608 & i) == 0) {
                if ((i2 & 32) == 0) {
                    jM6824unboximpl = j;
                    if (composerStartRestartGroup.changed(jM6824unboximpl)) {
                    }
                    i3 |= i12;
                } else {
                    jM6824unboximpl = j;
                }
                i3 |= i12;
            } else {
                jM6824unboximpl = j;
            }
            if ((1572864 & i) == 0) {
                if ((i2 & 64) == 0) {
                    j3 = j2;
                    if (composerStartRestartGroup.changed(j3)) {
                    }
                    i3 |= i13;
                } else {
                    j3 = j2;
                }
                i3 |= i13;
            } else {
                j3 = j2;
            }
            if ((i & 12582912) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i10 = 8388608;
                } else {
                    i10 = 4194304;
                }
                i3 |= i10;
            }
            i8 = i3;
            if ((i3 & 4793491) != 4793490) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z4, i8 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "226@9945L7,227@10037L6");
                if ((i & 1) != 0) {
                    if (i11 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    }
                    if (i6 != 0) {
                        mutableInteractionSource2 = null;
                    }
                    if ((i2 & 32) != 0) {
                        ProvidableCompositionLocal<Color> localContentColor10 = ContentColorKt.getLocalContentColor();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object objConsume10 = composerStartRestartGroup.consume(localContentColor10);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        jM6824unboximpl = ((Color) objConsume10).m6824unboximpl();
                        i9 = i8 & (-458753);
                    } else {
                        i9 = i8;
                    }
                    j6 = jM6824unboximpl;
                    if ((i2 & 64) != 0) {
                        i9 &= -3670017;
                        modifier4 = modifier2;
                        jM6813copywmQWz5c$default = Color.m6813copywmQWz5c$default(j6, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                        z6 = z3;
                    } else {
                        modifier4 = modifier2;
                        z6 = z3;
                        jM6813copywmQWz5c$default = j3;
                    }
                } else {
                    if (i11 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    }
                    if (i6 != 0) {
                        mutableInteractionSource2 = null;
                    }
                    if ((i2 & 32) != 0) {
                        ProvidableCompositionLocal<Color> localContentColor11 = ContentColorKt.getLocalContentColor();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object objConsume11 = composerStartRestartGroup.consume(localContentColor11);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        jM6824unboximpl = ((Color) objConsume11).m6824unboximpl();
                        i9 = i8 & (-458753);
                    } else {
                        i9 = i8;
                    }
                    j6 = jM6824unboximpl;
                    if ((i2 & 64) != 0) {
                        i9 &= -3670017;
                        modifier4 = modifier2;
                        jM6813copywmQWz5c$default = Color.m6813copywmQWz5c$default(j6, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                        z6 = z3;
                    } else {
                        modifier4 = modifier2;
                        z6 = z3;
                        jM6813copywmQWz5c$default = j3;
                    }
                }
                final MutableInteractionSource mutableInteractionSource10 = mutableInteractionSource2;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1847932236, i9, -1, "androidx.compose.material.Tab (Tab.kt:229)");
                }
                long j13 = j6;
                final IndicationNodeFactory indicationNodeFactoryM2523rippleH2RKhps$default7 = RippleKt.m2523rippleH2RKhps$default(true, 0.0f, j13, 2, null);
                int i110 = i9 >> 15;
                m2608TabTransitionKlgxPg(j13, jM6813copywmQWz5c$default, z, ComposableLambdaKt.rememberComposableLambda(-652402312, true, new Function2() { // from class: androidx.compose.material.TabKt$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return TabKt.Tab_EVJuX4I$lambda$0(modifier4, z, mutableInteractionSource10, indicationNodeFactoryM2523rippleH2RKhps$default7, z6, function0, function3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i9 << 6) & 896) | (i110 & 112) | (i110 & 14) | 3072);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                j4 = j13;
                mutableInteractionSource3 = mutableInteractionSource10;
                j5 = jM6813copywmQWz5c$default;
                modifier3 = modifier4;
                z5 = z6;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                z5 = z3;
                mutableInteractionSource3 = mutableInteractionSource2;
                j4 = jM6824unboximpl;
                j5 = j3;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.TabKt$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return TabKt.Tab_EVJuX4I$lambda$1(z, function0, modifier3, z5, mutableInteractionSource3, j4, j5, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 3072;
        z3 = z2;
        i6 = i2 & 16;
        if (i6 != 0) {
            if ((i & 24576) == 0) {
                mutableInteractionSource2 = mutableInteractionSource;
                if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                    i7 = 16384;
                } else {
                    i7 = 8192;
                }
                i3 |= i7;
            }
            if ((196608 & i) == 0) {
                if ((i2 & 32) == 0) {
                    jM6824unboximpl = j;
                    if (composerStartRestartGroup.changed(jM6824unboximpl)) {
                    }
                    i3 |= i12;
                } else {
                    jM6824unboximpl = j;
                }
                i3 |= i12;
            } else {
                jM6824unboximpl = j;
            }
            if ((1572864 & i) == 0) {
                if ((i2 & 64) == 0) {
                    j3 = j2;
                    if (composerStartRestartGroup.changed(j3)) {
                    }
                    i3 |= i13;
                } else {
                    j3 = j2;
                }
                i3 |= i13;
            } else {
                j3 = j2;
            }
            if ((i & 12582912) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i10 = 8388608;
                } else {
                    i10 = 4194304;
                }
                i3 |= i10;
            }
            i8 = i3;
            if ((i3 & 4793491) != 4793490) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z4, i8 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "226@9945L7,227@10037L6");
                if ((i & 1) != 0) {
                    if (i11 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    }
                    if (i6 != 0) {
                        mutableInteractionSource2 = null;
                    }
                    if ((i2 & 32) != 0) {
                        ProvidableCompositionLocal<Color> localContentColor12 = ContentColorKt.getLocalContentColor();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object objConsume12 = composerStartRestartGroup.consume(localContentColor12);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        jM6824unboximpl = ((Color) objConsume12).m6824unboximpl();
                        i9 = i8 & (-458753);
                    } else {
                        i9 = i8;
                    }
                    j6 = jM6824unboximpl;
                    if ((i2 & 64) != 0) {
                        i9 &= -3670017;
                        modifier4 = modifier2;
                        jM6813copywmQWz5c$default = Color.m6813copywmQWz5c$default(j6, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                        z6 = z3;
                    } else {
                        modifier4 = modifier2;
                        z6 = z3;
                        jM6813copywmQWz5c$default = j3;
                    }
                } else {
                    if (i11 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    }
                    if (i6 != 0) {
                        mutableInteractionSource2 = null;
                    }
                    if ((i2 & 32) != 0) {
                        ProvidableCompositionLocal<Color> localContentColor13 = ContentColorKt.getLocalContentColor();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object objConsume13 = composerStartRestartGroup.consume(localContentColor13);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        jM6824unboximpl = ((Color) objConsume13).m6824unboximpl();
                        i9 = i8 & (-458753);
                    } else {
                        i9 = i8;
                    }
                    j6 = jM6824unboximpl;
                    if ((i2 & 64) != 0) {
                        i9 &= -3670017;
                        modifier4 = modifier2;
                        jM6813copywmQWz5c$default = Color.m6813copywmQWz5c$default(j6, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                        z6 = z3;
                    } else {
                        modifier4 = modifier2;
                        z6 = z3;
                        jM6813copywmQWz5c$default = j3;
                    }
                }
                final MutableInteractionSource mutableInteractionSource11 = mutableInteractionSource2;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1847932236, i9, -1, "androidx.compose.material.Tab (Tab.kt:229)");
                }
                long j14 = j6;
                final IndicationNodeFactory indicationNodeFactoryM2523rippleH2RKhps$default8 = RippleKt.m2523rippleH2RKhps$default(true, 0.0f, j14, 2, null);
                int i111 = i9 >> 15;
                m2608TabTransitionKlgxPg(j14, jM6813copywmQWz5c$default, z, ComposableLambdaKt.rememberComposableLambda(-652402312, true, new Function2() { // from class: androidx.compose.material.TabKt$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return TabKt.Tab_EVJuX4I$lambda$0(modifier4, z, mutableInteractionSource11, indicationNodeFactoryM2523rippleH2RKhps$default8, z6, function0, function3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i9 << 6) & 896) | (i111 & 112) | (i111 & 14) | 3072);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                j4 = j14;
                mutableInteractionSource3 = mutableInteractionSource11;
                j5 = jM6813copywmQWz5c$default;
                modifier3 = modifier4;
                z5 = z6;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                z5 = z3;
                mutableInteractionSource3 = mutableInteractionSource2;
                j4 = jM6824unboximpl;
                j5 = j3;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.TabKt$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return TabKt.Tab_EVJuX4I$lambda$1(z, function0, modifier3, z5, mutableInteractionSource3, j4, j5, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 24576;
        mutableInteractionSource2 = mutableInteractionSource;
        if ((196608 & i) == 0) {
            if ((i2 & 32) == 0) {
                jM6824unboximpl = j;
                if (composerStartRestartGroup.changed(jM6824unboximpl)) {
                }
                i3 |= i12;
            } else {
                jM6824unboximpl = j;
            }
            i3 |= i12;
        } else {
            jM6824unboximpl = j;
        }
        if ((1572864 & i) == 0) {
            if ((i2 & 64) == 0) {
                j3 = j2;
                if (composerStartRestartGroup.changed(j3)) {
                }
                i3 |= i13;
            } else {
                j3 = j2;
            }
            i3 |= i13;
        } else {
            j3 = j2;
        }
        if ((i & 12582912) == 0) {
            if (composerStartRestartGroup.changedInstance(function3)) {
                i10 = 8388608;
            } else {
                i10 = 4194304;
            }
            i3 |= i10;
        }
        i8 = i3;
        if ((i3 & 4793491) != 4793490) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z4, i8 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "226@9945L7,227@10037L6");
            if ((i & 1) != 0) {
                if (i11 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i4 != 0) {
                    z3 = true;
                }
                if (i6 != 0) {
                    mutableInteractionSource2 = null;
                }
                if ((i2 & 32) != 0) {
                    ProvidableCompositionLocal<Color> localContentColor14 = ContentColorKt.getLocalContentColor();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume14 = composerStartRestartGroup.consume(localContentColor14);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    jM6824unboximpl = ((Color) objConsume14).m6824unboximpl();
                    i9 = i8 & (-458753);
                } else {
                    i9 = i8;
                }
                j6 = jM6824unboximpl;
                if ((i2 & 64) != 0) {
                    i9 &= -3670017;
                    modifier4 = modifier2;
                    jM6813copywmQWz5c$default = Color.m6813copywmQWz5c$default(j6, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                    z6 = z3;
                } else {
                    modifier4 = modifier2;
                    z6 = z3;
                    jM6813copywmQWz5c$default = j3;
                }
            } else {
                if (i11 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i4 != 0) {
                    z3 = true;
                }
                if (i6 != 0) {
                    mutableInteractionSource2 = null;
                }
                if ((i2 & 32) != 0) {
                    ProvidableCompositionLocal<Color> localContentColor15 = ContentColorKt.getLocalContentColor();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume15 = composerStartRestartGroup.consume(localContentColor15);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    jM6824unboximpl = ((Color) objConsume15).m6824unboximpl();
                    i9 = i8 & (-458753);
                } else {
                    i9 = i8;
                }
                j6 = jM6824unboximpl;
                if ((i2 & 64) != 0) {
                    i9 &= -3670017;
                    modifier4 = modifier2;
                    jM6813copywmQWz5c$default = Color.m6813copywmQWz5c$default(j6, ContentAlpha.INSTANCE.getMedium(composerStartRestartGroup, 6), 0.0f, 0.0f, 0.0f, 14, null);
                    z6 = z3;
                } else {
                    modifier4 = modifier2;
                    z6 = z3;
                    jM6813copywmQWz5c$default = j3;
                }
            }
            final MutableInteractionSource mutableInteractionSource12 = mutableInteractionSource2;
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1847932236, i9, -1, "androidx.compose.material.Tab (Tab.kt:229)");
            }
            long j15 = j6;
            final IndicationNodeFactory indicationNodeFactoryM2523rippleH2RKhps$default9 = RippleKt.m2523rippleH2RKhps$default(true, 0.0f, j15, 2, null);
            int i112 = i9 >> 15;
            m2608TabTransitionKlgxPg(j15, jM6813copywmQWz5c$default, z, ComposableLambdaKt.rememberComposableLambda(-652402312, true, new Function2() { // from class: androidx.compose.material.TabKt$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TabKt.Tab_EVJuX4I$lambda$0(modifier4, z, mutableInteractionSource12, indicationNodeFactoryM2523rippleH2RKhps$default9, z6, function0, function3, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i9 << 6) & 896) | (i112 & 112) | (i112 & 14) | 3072);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            j4 = j15;
            mutableInteractionSource3 = mutableInteractionSource12;
            j5 = jM6813copywmQWz5c$default;
            modifier3 = modifier4;
            z5 = z6;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
            z5 = z3;
            mutableInteractionSource3 = mutableInteractionSource2;
            j4 = jM6824unboximpl;
            j5 = j3;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.TabKt$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TabKt.Tab_EVJuX4I$lambda$1(z, function0, modifier3, z5, mutableInteractionSource3, j4, j5, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Tab_EVJuX4I$lambda$0(Modifier modifier, boolean z, MutableInteractionSource mutableInteractionSource, IndicationNodeFactory indicationNodeFactory, boolean z2, Function0 function0, Function3 function3, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C236@10470L586:Tab.kt#jmzs0o");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-652402312, i, -1, "androidx.compose.material.Tab.<anonymous> (Tab.kt:236)");
            }
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(SelectableKt.m1533selectableO2vRcR0(modifier, z, mutableInteractionSource, indicationNodeFactory, z2, Role.m8825boximpl(Role.INSTANCE.m8839getTabo7Vup1c()), function0), 0.0f, 1, null);
            Alignment.Horizontal centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
            Arrangement.HorizontalOrVertical center = Arrangement.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart(composer, -483455358, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(center, centerHorizontally, composer, 54);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierFillMaxWidth$default);
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

    /* JADX INFO: renamed from: TabTransition-Klgx-Pg, reason: not valid java name */
    private static final void m2608TabTransitionKlgxPg(final long j, final long j2, boolean z, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i) {
        int i2;
        final boolean z2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1841653376);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(TabTransition)N(activeColor:c#ui.graphics.Color,inactiveColor:c#ui.graphics.Color,selected,content)267@11494L26,269@11557L549,284@12111L165:Tab.kt#jmzs0o");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(j) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(j2) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            z2 = z;
            i2 |= composerStartRestartGroup.changed(z2) ? 256 : 128;
        } else {
            z2 = z;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function2) ? 2048 : 1024;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 1171) != 1170, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1841653376, i2, -1, "androidx.compose.material.TabTransition (Tab.kt:266)");
            }
            int i3 = i2 >> 6;
            Transition transitionUpdateTransition = TransitionKt.updateTransition(Boolean.valueOf(z2), (String) null, composerStartRestartGroup, i3 & 14, 2);
            Function3 function3 = new Function3() { // from class: androidx.compose.material.TabKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return TabKt.TabTransition_Klgx_Pg$lambda$0((Transition.Segment) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            };
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1939694975, "CC(animateColor)P(2)67@3229L31,68@3296L58,70@3367L70:Transition.kt#xbi5r1");
            boolean zBooleanValue = ((Boolean) transitionUpdateTransition.getTargetState()).booleanValue();
            composerStartRestartGroup.startReplaceGroup(90393475);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CN(it):Tab.kt#jmzs0o");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(90393475, 0, -1, "androidx.compose.material.TabTransition.<anonymous> (Tab.kt:282)");
            }
            long j3 = zBooleanValue ? j : j2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composerStartRestartGroup.endReplaceGroup();
            ColorSpace colorSpaceM6818getColorSpaceimpl = Color.m6818getColorSpaceimpl(j3);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1918408359, "CC(remember):Transition.kt#9igjgp");
            boolean zChanged = composerStartRestartGroup.changed(colorSpaceM6818getColorSpaceimpl);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = (TwoWayConverter) ColorVectorConverterKt.getVectorConverter(Color.INSTANCE).invoke(colorSpaceM6818getColorSpaceimpl);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            TwoWayConverter twoWayConverter = (TwoWayConverter) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -142660079, "CC(animateValue)P(3,2)1833@77788L32,1834@77843L31,1835@77899L23,1837@77935L89:Transition.kt#pdpnli");
            boolean zBooleanValue2 = ((Boolean) transitionUpdateTransition.getCurrentState()).booleanValue();
            composerStartRestartGroup.startReplaceGroup(90393475);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CN(it):Tab.kt#jmzs0o");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(90393475, 0, -1, "androidx.compose.material.TabTransition.<anonymous> (Tab.kt:282)");
            }
            long j4 = zBooleanValue2 ? j : j2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composerStartRestartGroup.endReplaceGroup();
            Color colorM6804boximpl = Color.m6804boximpl(j4);
            boolean zBooleanValue3 = ((Boolean) transitionUpdateTransition.getTargetState()).booleanValue();
            composerStartRestartGroup.startReplaceGroup(90393475);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CN(it):Tab.kt#jmzs0o");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(90393475, 0, -1, "androidx.compose.material.TabTransition.<anonymous> (Tab.kt:282)");
            }
            long j5 = zBooleanValue3 ? j : j2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composerStartRestartGroup.endReplaceGroup();
            State stateCreateTransitionAnimation = TransitionKt.createTransitionAnimation(transitionUpdateTransition, colorM6804boximpl, Color.m6804boximpl(j5), (FiniteAnimationSpec) function3.invoke(transitionUpdateTransition.getSegment(), composerStartRestartGroup, 0), twoWayConverter, "ColorAnimation", composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m6804boximpl(Color.m6813copywmQWz5c$default(TabTransition_Klgx_Pg$lambda$2(stateCreateTransitionAnimation), 1.0f, 0.0f, 0.0f, 0.0f, 14, null))), ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.m6816getAlphaimpl(TabTransition_Klgx_Pg$lambda$2(stateCreateTransitionAnimation))))}, function2, composerStartRestartGroup, ProvidedValue.$stable | (i3 & 112));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.TabKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TabKt.TabTransition_Klgx_Pg$lambda$3(j, j2, z2, function2, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FiniteAnimationSpec TabTransition_Klgx_Pg$lambda$0(Transition.Segment segment, Composer composer, int i) {
        TweenSpec tweenSpecTween$default;
        composer.startReplaceGroup(297582231);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(297582231, i, -1, "androidx.compose.material.TabTransition.<anonymous> (Tab.kt:271)");
        }
        if (segment.isTransitioningTo(false, true)) {
            tweenSpecTween$default = AnimationSpecKt.tween(150, 100, EasingKt.getLinearEasing());
        } else {
            tweenSpecTween$default = AnimationSpecKt.tween$default(100, 0, EasingKt.getLinearEasing(), 2, null);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return tweenSpecTween$default;
    }

    private static final void TabBaselineLayout(final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function3, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(1466813041);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(TabBaselineLayout)N(text,icon)305@12918L1803,298@12674L2047:Tab.kt#jmzs0o");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(function2) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function3) ? 32 : 16;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1466813041, i2, -1, "androidx.compose.material.TabBaselineLayout (Tab.kt:297)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 858071932, "CC(remember):Tab.kt#9igjgp");
            int i3 = i2 & 14;
            boolean z = (i3 == 4) | ((i2 & 112) == 32);
            TabKt$TabBaselineLayout$2$1 tabKt$TabBaselineLayout$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (z || tabKt$TabBaselineLayout$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                tabKt$TabBaselineLayout$2$1RememberedValue = new TabKt$TabBaselineLayout$2$1(function2, function3);
                composerStartRestartGroup.updateRememberedValue(tabKt$TabBaselineLayout$2$1RememberedValue);
            }
            MeasurePolicy measurePolicy = (MeasurePolicy) tabKt$TabBaselineLayout$2$1RememberedValue;
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1044963090, "C:Tab.kt#jmzs0o");
            if (function2 == null) {
                composerStartRestartGroup.startReplaceGroup(-1057560344);
            } else {
                composerStartRestartGroup.startReplaceGroup(-1044948645);
                ComposerKt.sourceInformation(composerStartRestartGroup, "300@12723L85");
                Modifier modifierM1220paddingVpY3zN4$default = PaddingKt.m1220paddingVpY3zN4$default(LayoutIdKt.layoutId(Modifier.INSTANCE, "text"), HorizontalTextPadding, 0.0f, 2, null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1220paddingVpY3zN4$default);
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
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1022846780, "C300@12800L6:Tab.kt#jmzs0o");
                function2.invoke(composerStartRestartGroup, Integer.valueOf(i3));
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            }
            composerStartRestartGroup.endReplaceGroup();
            if (function3 != null) {
                composerStartRestartGroup.startReplaceGroup(-1044815097);
                ComposerKt.sourceInformation(composerStartRestartGroup, "303@12859L41");
                Modifier modifierLayoutId = LayoutIdKt.layoutId(Modifier.INSTANCE, HubsObservability.HUB_ASSET_ICON);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierLayoutId);
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
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1180634875, "C303@12892L6:Tab.kt#jmzs0o");
                function3.invoke(composerStartRestartGroup, Integer.valueOf((i2 >> 3) & 14));
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            } else {
                composerStartRestartGroup.startReplaceGroup(-1057560344);
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.TabKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TabKt.TabBaselineLayout$lambda$2(function2, function3, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void placeTextOrIcon(Placeable.PlacementScope placementScope, Placeable placeable, int i) {
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable, 0, (i - placeable.getHeight()) / 2, 0.0f, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void placeTextAndIcon(Placeable.PlacementScope placementScope, Density density, Placeable placeable, Placeable placeable2, int i, int i2, int i3, int i4) {
        float f;
        if (i3 == i4) {
            f = SingleLineTextBaselineWithIcon;
        } else {
            f = DoubleLineTextBaselineWithIcon;
        }
        int iMo748roundToPx0680j_4 = density.mo748roundToPx0680j_4(f) + density.mo748roundToPx0680j_4(TabRowDefaults.INSTANCE.m2616getIndicatorHeightD9Ej5fM());
        int height = (placeable2.getHeight() + density.mo747roundToPxR2X_6o(IconDistanceFromBaseline)) - i3;
        int i5 = (i2 - i4) - iMo748roundToPx0680j_4;
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable, (i - placeable.getWidth()) / 2, i5, 0.0f, 4, null);
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable2, (i - placeable2.getWidth()) / 2, i5 - height, 0.0f, 4, null);
    }

    private static final long TabTransition_Klgx_Pg$lambda$2(State<Color> state) {
        return state.getValue().m6824unboximpl();
    }
}
