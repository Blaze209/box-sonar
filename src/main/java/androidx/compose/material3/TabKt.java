package androidx.compose.material3;

import androidx.compose.animation.ColorVectorConverterKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TransitionKt;
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
import androidx.compose.material3.tokens.MotionSchemeKeyTokens;
import androidx.compose.material3.tokens.PrimaryNavigationTabTokens;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000p\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0087\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\u0015\b\u0002\u0010\t\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005¢\u0006\u0002\b\n2\u0015\b\u0002\u0010\u000b\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005¢\u0006\u0002\b\n2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\r2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0007¢\u0006\u0004\b\u0011\u0010\u0012\u001a\u007f\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\u0011\u0010\t\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\n2\u0011\u0010\u000b\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\n2\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\r2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0007¢\u0006\u0004\b\u0014\u0010\u0015\u001aw\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\r2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u001c\u0010\u0016\u001a\u0018\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00010\u0017¢\u0006\u0002\b\n¢\u0006\u0002\b\u0019H\u0007¢\u0006\u0004\b\u001a\u0010\u001b\u001a:\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\u00032\u0011\u0010\u0016\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\nH\u0003¢\u0006\u0004\b\u001f\u0010 \u001a7\u0010!\u001a\u00020\u00012\u0013\u0010\t\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005¢\u0006\u0002\b\n2\u0013\u0010\u000b\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005¢\u0006\u0002\b\nH\u0003¢\u0006\u0002\u0010\"\u001a\u001c\u0010#\u001a\u00020\u0001*\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(H\u0002\u001aD\u0010)\u001a\u00020\u0001*\u00020$2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020&2\u0006\u0010-\u001a\u00020&2\u0006\u0010.\u001a\u00020(2\u0006\u0010'\u001a\u00020(2\u0006\u0010/\u001a\u00020(2\u0006\u00100\u001a\u00020(H\u0002\"\u0010\u00101\u001a\u000202X\u0082\u0004¢\u0006\u0004\n\u0002\u00103\"\u0010\u00104\u001a\u000202X\u0082\u0004¢\u0006\u0004\n\u0002\u00103\"\u0016\u00105\u001a\u000202X\u0080\u0004¢\u0006\n\n\u0002\u00103\u001a\u0004\b6\u00107\"\u0010\u00108\u001a\u000202X\u0082\u0004¢\u0006\u0004\n\u0002\u00103\"\u0010\u00109\u001a\u000202X\u0082\u0004¢\u0006\u0004\n\u0002\u00103\"\u0010\u0010:\u001a\u00020;X\u0082\u0004¢\u0006\u0004\n\u0002\u0010<\"\u0010\u0010=\u001a\u000202X\u0082\u0004¢\u0006\u0004\n\u0002\u00103¨\u0006>²\u0006\n\u0010?\u001a\u00020\rX\u008a\u0084\u0002"}, d2 = {"Tab", "", "selected", "", ViewProps.ON_CLICK, "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "text", "Landroidx/compose/runtime/Composable;", HubsObservability.HUB_ASSET_ICON, "selectedContentColor", "Landroidx/compose/ui/graphics/Color;", "unselectedContentColor", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "Tab-wqdebIU", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;JJLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "LeadingIconTab", "LeadingIconTab-wqdebIU", "(ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;ZJJLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Lkotlin/ExtensionFunctionType;", "Tab-bogVsAg", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZJJLandroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "TabTransition", "activeColor", "inactiveColor", "TabTransition-Klgx-Pg", "(JJZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "TabBaselineLayout", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "placeTextOrIcon", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "textOrIconPlaceable", "Landroidx/compose/ui/layout/Placeable;", "tabHeight", "", "placeTextAndIcon", "density", "Landroidx/compose/ui/unit/Density;", "textPlaceable", "iconPlaceable", "tabWidth", "firstBaseline", "lastBaseline", "SmallTabHeight", "Landroidx/compose/ui/unit/Dp;", "F", "LargeTabHeight", "HorizontalTextPadding", "getHorizontalTextPadding", "()F", "SingleLineTextBaselineWithIcon", "DoubleLineTextBaselineWithIcon", "IconDistanceFromBaseline", "Landroidx/compose/ui/unit/TextUnit;", "J", "TextDistanceFromLeadingIcon", "material3", "color"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class TabKt {
    private static final float SmallTabHeight = PrimaryNavigationTabTokens.INSTANCE.m5711getContainerHeightD9Ej5fM();
    private static final float LargeTabHeight = Dp.m9687constructorimpl(72);
    private static final float HorizontalTextPadding = Dp.m9687constructorimpl(16);
    private static final float SingleLineTextBaselineWithIcon = Dp.m9687constructorimpl(14);
    private static final float DoubleLineTextBaselineWithIcon = Dp.m9687constructorimpl(6);
    private static final long IconDistanceFromBaseline = TextUnitKt.getSp(20);
    private static final float TextDistanceFromLeadingIcon = Dp.m9687constructorimpl(8);

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LeadingIconTab_wqdebIU$lambda$1(boolean z, Function0 function0, Function2 function2, Function2 function3, Modifier modifier, boolean z2, long j, long j2, MutableInteractionSource mutableInteractionSource, int i, int i2, Composer composer, int i3) {
        m4362LeadingIconTabwqdebIU(z, function0, function2, function3, modifier, z2, j, j2, mutableInteractionSource, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TabBaselineLayout$lambda$2(Function2 function2, Function2 function3, int i, Composer composer, int i2) {
        TabBaselineLayout(function2, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TabTransition_Klgx_Pg$lambda$3(long j, long j2, boolean z, Function2 function2, int i, Composer composer, int i2) {
        m4365TabTransitionKlgxPg(j, j2, z, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Tab_bogVsAg$lambda$1(boolean z, Function0 function0, Modifier modifier, boolean z2, long j, long j2, MutableInteractionSource mutableInteractionSource, Function3 function3, int i, int i2, Composer composer, int i3) {
        m4363TabbogVsAg(z, function0, modifier, z2, j, j2, mutableInteractionSource, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Tab_wqdebIU$lambda$2(boolean z, Function0 function0, Modifier modifier, boolean z2, Function2 function2, Function2 function3, long j, long j2, MutableInteractionSource mutableInteractionSource, int i, int i2, Composer composer, int i3) {
        m4364TabwqdebIU(z, function0, modifier, z2, function2, function3, j, j2, mutableInteractionSource, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0134  */
    /* JADX WARN: Code duplicated, block: B:111:0x0157 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:112:0x0159  */
    /* JADX WARN: Code duplicated, block: B:114:0x0160  */
    /* JADX WARN: Code duplicated, block: B:116:0x0163  */
    /* JADX WARN: Code duplicated, block: B:118:0x0167  */
    /* JADX WARN: Code duplicated, block: B:121:0x016d  */
    /* JADX WARN: Code duplicated, block: B:122:0x018b  */
    /* JADX WARN: Code duplicated, block: B:125:0x0191  */
    /* JADX WARN: Code duplicated, block: B:126:0x0197  */
    /* JADX WARN: Code duplicated, block: B:129:0x019f  */
    /* JADX WARN: Code duplicated, block: B:130:0x01a9  */
    /* JADX WARN: Code duplicated, block: B:133:0x01bb  */
    /* JADX WARN: Code duplicated, block: B:136:0x01c5  */
    /* JADX WARN: Code duplicated, block: B:137:0x01cc  */
    /* JADX WARN: Code duplicated, block: B:140:0x0224  */
    /* JADX WARN: Code duplicated, block: B:142:0x0233  */
    /* JADX WARN: Code duplicated, block: B:145:0x0248  */
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
    /* JADX WARN: Code duplicated, block: B:63:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:65:0x00af  */
    /* JADX WARN: Code duplicated, block: B:67:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:68:0x00bd  */
    /* JADX WARN: Code duplicated, block: B:71:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:74:0x00d2  */
    /* JADX WARN: Code duplicated, block: B:76:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:79:0x00e1  */
    /* JADX WARN: Code duplicated, block: B:81:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:84:0x00ed  */
    /* JADX WARN: Code duplicated, block: B:85:0x00f0  */
    /* JADX WARN: Code duplicated, block: B:87:0x00f4  */
    /* JADX WARN: Code duplicated, block: B:89:0x00fe  */
    /* JADX WARN: Code duplicated, block: B:90:0x0101  */
    /* JADX WARN: Code duplicated, block: B:95:0x0115  */
    /* JADX WARN: Code duplicated, block: B:96:0x0117  */
    /* JADX WARN: Code duplicated, block: B:99:0x0120  */
    /* JADX INFO: renamed from: Tab-wqdebIU, reason: not valid java name */
    public static final void m4364TabwqdebIU(final boolean z, final Function0<Unit> function0, Modifier modifier, boolean z2, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function3, long j, long j2, MutableInteractionSource mutableInteractionSource, Composer composer, final int i, final int i2) {
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
        long jM6824unboximpl;
        long j5;
        boolean z6;
        final ComposableLambda composableLambdaRememberComposableLambda;
        long j6;
        long j7;
        int i14;
        MutableInteractionSource mutableInteractionSource3;
        int i15;
        int i16;
        Composer composerStartRestartGroup = composer.startRestartGroup(1015017965);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Tab)N(selected,onClick,modifier,enabled,text,icon,selectedContentColor:c#ui.graphics.Color,unselectedContentColor:c#ui.graphics.Color,interactionSource)119@5177L65,111@4883L359:Tab.kt#uh7d8r");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function0) ? 32 : 16;
        }
        int i17 = i2 & 4;
        if (i17 == 0) {
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
                        if ((1572864 & i) == 0) {
                            if ((i2 & 64) == 0) {
                                i16 = i3;
                                i11 = i17;
                                int i18 = composerStartRestartGroup.changed(j) ? 1048576 : 524288;
                                i10 = i16 | i18;
                            } else {
                                i16 = i3;
                                i11 = i17;
                            }
                            i10 = i16 | i18;
                        } else {
                            i10 = i3;
                            i11 = i17;
                        }
                        if ((i & 12582912) != 0) {
                            if ((i2 & 128) == 0 || !composerStartRestartGroup.changed(j2)) {
                                i15 = 4194304;
                            } else {
                                i15 = 8388608;
                            }
                            i10 |= i15;
                        }
                        i12 = i2 & 256;
                        if (i12 != 0) {
                            if ((i & 100663296) == 0) {
                                if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                                    i13 = 67108864;
                                } else {
                                    i13 = 33554432;
                                }
                                i10 |= i13;
                            }
                            if ((i10 & 38347923) != 38347922) {
                                z4 = true;
                            } else {
                                z4 = false;
                            }
                            if (composerStartRestartGroup.shouldExecute(z4, i10 & 1)) {
                                composerStartRestartGroup.startDefaults();
                                ComposerKt.sourceInformation(composerStartRestartGroup, "97@4401L7");
                                if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                    if (i11 != 0) {
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
                                    if ((i2 & 64) != 0) {
                                        ProvidableCompositionLocal<Color> localContentColor = ContentColorKt.getLocalContentColor();
                                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                        Object objConsume = composerStartRestartGroup.consume(localContentColor);
                                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                        jM6824unboximpl = ((Color) objConsume).m6824unboximpl();
                                        i10 &= -3670017;
                                    } else {
                                        jM6824unboximpl = j;
                                    }
                                    if ((i2 & 128) != 0) {
                                        i10 &= -29360129;
                                        j5 = jM6824unboximpl;
                                    } else {
                                        j5 = j2;
                                    }
                                    z6 = z3;
                                    composableLambdaRememberComposableLambda = null;
                                    if (i12 != 0) {
                                        j6 = jM6824unboximpl;
                                        i14 = 1015017965;
                                        mutableInteractionSource3 = null;
                                        j7 = j5;
                                    } else {
                                        j6 = jM6824unboximpl;
                                        j7 = j5;
                                        i14 = 1015017965;
                                        mutableInteractionSource3 = mutableInteractionSource;
                                    }
                                } else {
                                    composerStartRestartGroup.skipToGroupEnd();
                                    if ((i2 & 64) != 0) {
                                        i10 &= -3670017;
                                    }
                                    if ((i2 & 128) != 0) {
                                        i10 &= -29360129;
                                    }
                                    j6 = j;
                                    mutableInteractionSource3 = mutableInteractionSource;
                                    z6 = z3;
                                    composableLambdaRememberComposableLambda = null;
                                    i14 = 1015017965;
                                    j7 = j2;
                                }
                                composerStartRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(i14, i10, -1, "androidx.compose.material3.Tab (Tab.kt:100)");
                                }
                                if (function4 == null) {
                                    composerStartRestartGroup.startReplaceGroup(1830887765);
                                } else {
                                    composerStartRestartGroup.startReplaceGroup(1830887766);
                                    ComposerKt.sourceInformation(composerStartRestartGroup, "*103@4621L247");
                                    composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-1745256900, true, new Function2() { // from class: androidx.compose.material3.TabKt$$ExternalSyntheticLambda2
                                        @Override // kotlin.jvm.functions.Function2
                                        public final Object invoke(Object obj, Object obj2) {
                                            return TabKt.Tab_wqdebIU$lambda$0$0(function4, (Composer) obj, ((Integer) obj2).intValue());
                                        }
                                    }, composerStartRestartGroup, 54);
                                }
                                composerStartRestartGroup.endReplaceGroup();
                                int i19 = i10 >> 6;
                                composer2 = composerStartRestartGroup;
                                m4363TabbogVsAg(z, function0, BadgeKt.badgeBounds(modifier2), z6, j6, j7, mutableInteractionSource3, ComposableLambdaKt.rememberComposableLambda(-906085472, true, new Function3() { // from class: androidx.compose.material3.TabKt$$ExternalSyntheticLambda3
                                    @Override // kotlin.jvm.functions.Function3
                                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                                        return TabKt.Tab_wqdebIU$lambda$1(composableLambdaRememberComposableLambda, function5, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                    }
                                }, composerStartRestartGroup, 54), composer2, (i10 & 14) | 12582912 | (i10 & 112) | (i10 & 7168) | (57344 & i19) | (458752 & i19) | (i19 & 3670016), 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                modifier3 = modifier2;
                                function6 = function4;
                                function7 = function5;
                                z5 = z6;
                                j3 = j6;
                                j4 = j7;
                                mutableInteractionSource2 = mutableInteractionSource3;
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
                                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TabKt$$ExternalSyntheticLambda4
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return TabKt.Tab_wqdebIU$lambda$2(z, function0, modifier3, z5, function6, function7, j3, j4, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                    }
                                });
                            }
                        }
                        i10 |= 100663296;
                        if ((i10 & 38347923) != 38347922) {
                            z4 = true;
                        } else {
                            z4 = false;
                        }
                        if (composerStartRestartGroup.shouldExecute(z4, i10 & 1)) {
                            composerStartRestartGroup.startDefaults();
                            ComposerKt.sourceInformation(composerStartRestartGroup, "97@4401L7");
                            if ((i & 1) != 0) {
                                if (i11 != 0) {
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
                                if ((i2 & 64) != 0) {
                                    ProvidableCompositionLocal<Color> localContentColor2 = ContentColorKt.getLocalContentColor();
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                    Object objConsume2 = composerStartRestartGroup.consume(localContentColor2);
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                    jM6824unboximpl = ((Color) objConsume2).m6824unboximpl();
                                    i10 &= -3670017;
                                } else {
                                    jM6824unboximpl = j;
                                }
                                if ((i2 & 128) != 0) {
                                    i10 &= -29360129;
                                    j5 = jM6824unboximpl;
                                } else {
                                    j5 = j2;
                                }
                                z6 = z3;
                                composableLambdaRememberComposableLambda = null;
                                if (i12 != 0) {
                                    j6 = jM6824unboximpl;
                                    i14 = 1015017965;
                                    mutableInteractionSource3 = null;
                                    j7 = j5;
                                } else {
                                    j6 = jM6824unboximpl;
                                    j7 = j5;
                                    i14 = 1015017965;
                                    mutableInteractionSource3 = mutableInteractionSource;
                                }
                            } else {
                                if (i11 != 0) {
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
                                if ((i2 & 64) != 0) {
                                    ProvidableCompositionLocal<Color> localContentColor3 = ContentColorKt.getLocalContentColor();
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                    Object objConsume3 = composerStartRestartGroup.consume(localContentColor3);
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                    jM6824unboximpl = ((Color) objConsume3).m6824unboximpl();
                                    i10 &= -3670017;
                                } else {
                                    jM6824unboximpl = j;
                                }
                                if ((i2 & 128) != 0) {
                                    i10 &= -29360129;
                                    j5 = jM6824unboximpl;
                                } else {
                                    j5 = j2;
                                }
                                z6 = z3;
                                composableLambdaRememberComposableLambda = null;
                                if (i12 != 0) {
                                    j6 = jM6824unboximpl;
                                    i14 = 1015017965;
                                    mutableInteractionSource3 = null;
                                    j7 = j5;
                                } else {
                                    j6 = jM6824unboximpl;
                                    j7 = j5;
                                    i14 = 1015017965;
                                    mutableInteractionSource3 = mutableInteractionSource;
                                }
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(i14, i10, -1, "androidx.compose.material3.Tab (Tab.kt:100)");
                            }
                            if (function4 == null) {
                                composerStartRestartGroup.startReplaceGroup(1830887765);
                            } else {
                                composerStartRestartGroup.startReplaceGroup(1830887766);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "*103@4621L247");
                                composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-1745256900, true, new Function2() { // from class: androidx.compose.material3.TabKt$$ExternalSyntheticLambda2
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return TabKt.Tab_wqdebIU$lambda$0$0(function4, (Composer) obj, ((Integer) obj2).intValue());
                                    }
                                }, composerStartRestartGroup, 54);
                            }
                            composerStartRestartGroup.endReplaceGroup();
                            int i110 = i10 >> 6;
                            composer2 = composerStartRestartGroup;
                            m4363TabbogVsAg(z, function0, BadgeKt.badgeBounds(modifier2), z6, j6, j7, mutableInteractionSource3, ComposableLambdaKt.rememberComposableLambda(-906085472, true, new Function3() { // from class: androidx.compose.material3.TabKt$$ExternalSyntheticLambda3
                                @Override // kotlin.jvm.functions.Function3
                                public final Object invoke(Object obj, Object obj2, Object obj3) {
                                    return TabKt.Tab_wqdebIU$lambda$1(composableLambdaRememberComposableLambda, function5, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                }
                            }, composerStartRestartGroup, 54), composer2, (i10 & 14) | 12582912 | (i10 & 112) | (i10 & 7168) | (57344 & i110) | (458752 & i110) | (i110 & 3670016), 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier3 = modifier2;
                            function6 = function4;
                            function7 = function5;
                            z5 = z6;
                            j3 = j6;
                            j4 = j7;
                            mutableInteractionSource2 = mutableInteractionSource3;
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
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TabKt$$ExternalSyntheticLambda4
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return TabKt.Tab_wqdebIU$lambda$2(z, function0, modifier3, z5, function6, function7, j3, j4, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                        }
                    }
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    function5 = function3;
                    if ((1572864 & i) == 0) {
                        if ((i2 & 64) == 0) {
                            i16 = i3;
                            i11 = i17;
                            if (composerStartRestartGroup.changed(j)) {
                            }
                            i10 = i16 | i18;
                        } else {
                            i16 = i3;
                            i11 = i17;
                        }
                        i10 = i16 | i18;
                    } else {
                        i10 = i3;
                        i11 = i17;
                    }
                    if ((i & 12582912) != 0) {
                        if ((i2 & 128) == 0) {
                            i15 = 4194304;
                        } else {
                            i15 = 4194304;
                        }
                        i10 |= i15;
                    }
                    i12 = i2 & 256;
                    if (i12 != 0) {
                        if ((i & 100663296) == 0) {
                            if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                                i13 = 67108864;
                            } else {
                                i13 = 33554432;
                            }
                            i10 |= i13;
                        }
                        if ((i10 & 38347923) != 38347922) {
                            z4 = true;
                        } else {
                            z4 = false;
                        }
                        if (composerStartRestartGroup.shouldExecute(z4, i10 & 1)) {
                            composerStartRestartGroup.startDefaults();
                            ComposerKt.sourceInformation(composerStartRestartGroup, "97@4401L7");
                            if ((i & 1) != 0) {
                                if (i11 != 0) {
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
                                if ((i2 & 64) != 0) {
                                    ProvidableCompositionLocal<Color> localContentColor4 = ContentColorKt.getLocalContentColor();
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                    Object objConsume4 = composerStartRestartGroup.consume(localContentColor4);
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                    jM6824unboximpl = ((Color) objConsume4).m6824unboximpl();
                                    i10 &= -3670017;
                                } else {
                                    jM6824unboximpl = j;
                                }
                                if ((i2 & 128) != 0) {
                                    i10 &= -29360129;
                                    j5 = jM6824unboximpl;
                                } else {
                                    j5 = j2;
                                }
                                z6 = z3;
                                composableLambdaRememberComposableLambda = null;
                                if (i12 != 0) {
                                    j6 = jM6824unboximpl;
                                    i14 = 1015017965;
                                    mutableInteractionSource3 = null;
                                    j7 = j5;
                                } else {
                                    j6 = jM6824unboximpl;
                                    j7 = j5;
                                    i14 = 1015017965;
                                    mutableInteractionSource3 = mutableInteractionSource;
                                }
                            } else {
                                if (i11 != 0) {
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
                                if ((i2 & 64) != 0) {
                                    ProvidableCompositionLocal<Color> localContentColor5 = ContentColorKt.getLocalContentColor();
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                    Object objConsume5 = composerStartRestartGroup.consume(localContentColor5);
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                    jM6824unboximpl = ((Color) objConsume5).m6824unboximpl();
                                    i10 &= -3670017;
                                } else {
                                    jM6824unboximpl = j;
                                }
                                if ((i2 & 128) != 0) {
                                    i10 &= -29360129;
                                    j5 = jM6824unboximpl;
                                } else {
                                    j5 = j2;
                                }
                                z6 = z3;
                                composableLambdaRememberComposableLambda = null;
                                if (i12 != 0) {
                                    j6 = jM6824unboximpl;
                                    i14 = 1015017965;
                                    mutableInteractionSource3 = null;
                                    j7 = j5;
                                } else {
                                    j6 = jM6824unboximpl;
                                    j7 = j5;
                                    i14 = 1015017965;
                                    mutableInteractionSource3 = mutableInteractionSource;
                                }
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(i14, i10, -1, "androidx.compose.material3.Tab (Tab.kt:100)");
                            }
                            if (function4 == null) {
                                composerStartRestartGroup.startReplaceGroup(1830887765);
                            } else {
                                composerStartRestartGroup.startReplaceGroup(1830887766);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "*103@4621L247");
                                composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-1745256900, true, new Function2() { // from class: androidx.compose.material3.TabKt$$ExternalSyntheticLambda2
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return TabKt.Tab_wqdebIU$lambda$0$0(function4, (Composer) obj, ((Integer) obj2).intValue());
                                    }
                                }, composerStartRestartGroup, 54);
                            }
                            composerStartRestartGroup.endReplaceGroup();
                            int i111 = i10 >> 6;
                            composer2 = composerStartRestartGroup;
                            m4363TabbogVsAg(z, function0, BadgeKt.badgeBounds(modifier2), z6, j6, j7, mutableInteractionSource3, ComposableLambdaKt.rememberComposableLambda(-906085472, true, new Function3() { // from class: androidx.compose.material3.TabKt$$ExternalSyntheticLambda3
                                @Override // kotlin.jvm.functions.Function3
                                public final Object invoke(Object obj, Object obj2, Object obj3) {
                                    return TabKt.Tab_wqdebIU$lambda$1(composableLambdaRememberComposableLambda, function5, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                }
                            }, composerStartRestartGroup, 54), composer2, (i10 & 14) | 12582912 | (i10 & 112) | (i10 & 7168) | (57344 & i111) | (458752 & i111) | (i111 & 3670016), 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier3 = modifier2;
                            function6 = function4;
                            function7 = function5;
                            z5 = z6;
                            j3 = j6;
                            j4 = j7;
                            mutableInteractionSource2 = mutableInteractionSource3;
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
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TabKt$$ExternalSyntheticLambda4
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return TabKt.Tab_wqdebIU$lambda$2(z, function0, modifier3, z5, function6, function7, j3, j4, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                        }
                    }
                    i10 |= 100663296;
                    if ((i10 & 38347923) != 38347922) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z4, i10 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "97@4401L7");
                        if ((i & 1) != 0) {
                            if (i11 != 0) {
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
                            if ((i2 & 64) != 0) {
                                ProvidableCompositionLocal<Color> localContentColor6 = ContentColorKt.getLocalContentColor();
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                Object objConsume6 = composerStartRestartGroup.consume(localContentColor6);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                jM6824unboximpl = ((Color) objConsume6).m6824unboximpl();
                                i10 &= -3670017;
                            } else {
                                jM6824unboximpl = j;
                            }
                            if ((i2 & 128) != 0) {
                                i10 &= -29360129;
                                j5 = jM6824unboximpl;
                            } else {
                                j5 = j2;
                            }
                            z6 = z3;
                            composableLambdaRememberComposableLambda = null;
                            if (i12 != 0) {
                                j6 = jM6824unboximpl;
                                i14 = 1015017965;
                                mutableInteractionSource3 = null;
                                j7 = j5;
                            } else {
                                j6 = jM6824unboximpl;
                                j7 = j5;
                                i14 = 1015017965;
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                        } else {
                            if (i11 != 0) {
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
                            if ((i2 & 64) != 0) {
                                ProvidableCompositionLocal<Color> localContentColor7 = ContentColorKt.getLocalContentColor();
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                Object objConsume7 = composerStartRestartGroup.consume(localContentColor7);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                jM6824unboximpl = ((Color) objConsume7).m6824unboximpl();
                                i10 &= -3670017;
                            } else {
                                jM6824unboximpl = j;
                            }
                            if ((i2 & 128) != 0) {
                                i10 &= -29360129;
                                j5 = jM6824unboximpl;
                            } else {
                                j5 = j2;
                            }
                            z6 = z3;
                            composableLambdaRememberComposableLambda = null;
                            if (i12 != 0) {
                                j6 = jM6824unboximpl;
                                i14 = 1015017965;
                                mutableInteractionSource3 = null;
                                j7 = j5;
                            } else {
                                j6 = jM6824unboximpl;
                                j7 = j5;
                                i14 = 1015017965;
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(i14, i10, -1, "androidx.compose.material3.Tab (Tab.kt:100)");
                        }
                        if (function4 == null) {
                            composerStartRestartGroup.startReplaceGroup(1830887765);
                        } else {
                            composerStartRestartGroup.startReplaceGroup(1830887766);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "*103@4621L247");
                            composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-1745256900, true, new Function2() { // from class: androidx.compose.material3.TabKt$$ExternalSyntheticLambda2
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return TabKt.Tab_wqdebIU$lambda$0$0(function4, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composerStartRestartGroup, 54);
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        int i112 = i10 >> 6;
                        composer2 = composerStartRestartGroup;
                        m4363TabbogVsAg(z, function0, BadgeKt.badgeBounds(modifier2), z6, j6, j7, mutableInteractionSource3, ComposableLambdaKt.rememberComposableLambda(-906085472, true, new Function3() { // from class: androidx.compose.material3.TabKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return TabKt.Tab_wqdebIU$lambda$1(composableLambdaRememberComposableLambda, function5, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composerStartRestartGroup, 54), composer2, (i10 & 14) | 12582912 | (i10 & 112) | (i10 & 7168) | (57344 & i112) | (458752 & i112) | (i112 & 3670016), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier2;
                        function6 = function4;
                        function7 = function5;
                        z5 = z6;
                        j3 = j6;
                        j4 = j7;
                        mutableInteractionSource2 = mutableInteractionSource3;
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
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TabKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return TabKt.Tab_wqdebIU$lambda$2(z, function0, modifier3, z5, function6, function7, j3, j4, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
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
                    if ((1572864 & i) == 0) {
                        if ((i2 & 64) == 0) {
                            i16 = i3;
                            i11 = i17;
                            if (composerStartRestartGroup.changed(j)) {
                            }
                            i10 = i16 | i18;
                        } else {
                            i16 = i3;
                            i11 = i17;
                        }
                        i10 = i16 | i18;
                    } else {
                        i10 = i3;
                        i11 = i17;
                    }
                    if ((i & 12582912) != 0) {
                        if ((i2 & 128) == 0) {
                            i15 = 4194304;
                        } else {
                            i15 = 4194304;
                        }
                        i10 |= i15;
                    }
                    i12 = i2 & 256;
                    if (i12 != 0) {
                        if ((i & 100663296) == 0) {
                            if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                                i13 = 67108864;
                            } else {
                                i13 = 33554432;
                            }
                            i10 |= i13;
                        }
                        if ((i10 & 38347923) != 38347922) {
                            z4 = true;
                        } else {
                            z4 = false;
                        }
                        if (composerStartRestartGroup.shouldExecute(z4, i10 & 1)) {
                            composerStartRestartGroup.startDefaults();
                            ComposerKt.sourceInformation(composerStartRestartGroup, "97@4401L7");
                            if ((i & 1) != 0) {
                                if (i11 != 0) {
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
                                if ((i2 & 64) != 0) {
                                    ProvidableCompositionLocal<Color> localContentColor8 = ContentColorKt.getLocalContentColor();
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                    Object objConsume8 = composerStartRestartGroup.consume(localContentColor8);
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                    jM6824unboximpl = ((Color) objConsume8).m6824unboximpl();
                                    i10 &= -3670017;
                                } else {
                                    jM6824unboximpl = j;
                                }
                                if ((i2 & 128) != 0) {
                                    i10 &= -29360129;
                                    j5 = jM6824unboximpl;
                                } else {
                                    j5 = j2;
                                }
                                z6 = z3;
                                composableLambdaRememberComposableLambda = null;
                                if (i12 != 0) {
                                    j6 = jM6824unboximpl;
                                    i14 = 1015017965;
                                    mutableInteractionSource3 = null;
                                    j7 = j5;
                                } else {
                                    j6 = jM6824unboximpl;
                                    j7 = j5;
                                    i14 = 1015017965;
                                    mutableInteractionSource3 = mutableInteractionSource;
                                }
                            } else {
                                if (i11 != 0) {
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
                                if ((i2 & 64) != 0) {
                                    ProvidableCompositionLocal<Color> localContentColor9 = ContentColorKt.getLocalContentColor();
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                    Object objConsume9 = composerStartRestartGroup.consume(localContentColor9);
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                    jM6824unboximpl = ((Color) objConsume9).m6824unboximpl();
                                    i10 &= -3670017;
                                } else {
                                    jM6824unboximpl = j;
                                }
                                if ((i2 & 128) != 0) {
                                    i10 &= -29360129;
                                    j5 = jM6824unboximpl;
                                } else {
                                    j5 = j2;
                                }
                                z6 = z3;
                                composableLambdaRememberComposableLambda = null;
                                if (i12 != 0) {
                                    j6 = jM6824unboximpl;
                                    i14 = 1015017965;
                                    mutableInteractionSource3 = null;
                                    j7 = j5;
                                } else {
                                    j6 = jM6824unboximpl;
                                    j7 = j5;
                                    i14 = 1015017965;
                                    mutableInteractionSource3 = mutableInteractionSource;
                                }
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(i14, i10, -1, "androidx.compose.material3.Tab (Tab.kt:100)");
                            }
                            if (function4 == null) {
                                composerStartRestartGroup.startReplaceGroup(1830887765);
                            } else {
                                composerStartRestartGroup.startReplaceGroup(1830887766);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "*103@4621L247");
                                composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-1745256900, true, new Function2() { // from class: androidx.compose.material3.TabKt$$ExternalSyntheticLambda2
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return TabKt.Tab_wqdebIU$lambda$0$0(function4, (Composer) obj, ((Integer) obj2).intValue());
                                    }
                                }, composerStartRestartGroup, 54);
                            }
                            composerStartRestartGroup.endReplaceGroup();
                            int i113 = i10 >> 6;
                            composer2 = composerStartRestartGroup;
                            m4363TabbogVsAg(z, function0, BadgeKt.badgeBounds(modifier2), z6, j6, j7, mutableInteractionSource3, ComposableLambdaKt.rememberComposableLambda(-906085472, true, new Function3() { // from class: androidx.compose.material3.TabKt$$ExternalSyntheticLambda3
                                @Override // kotlin.jvm.functions.Function3
                                public final Object invoke(Object obj, Object obj2, Object obj3) {
                                    return TabKt.Tab_wqdebIU$lambda$1(composableLambdaRememberComposableLambda, function5, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                }
                            }, composerStartRestartGroup, 54), composer2, (i10 & 14) | 12582912 | (i10 & 112) | (i10 & 7168) | (57344 & i113) | (458752 & i113) | (i113 & 3670016), 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier3 = modifier2;
                            function6 = function4;
                            function7 = function5;
                            z5 = z6;
                            j3 = j6;
                            j4 = j7;
                            mutableInteractionSource2 = mutableInteractionSource3;
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
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TabKt$$ExternalSyntheticLambda4
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return TabKt.Tab_wqdebIU$lambda$2(z, function0, modifier3, z5, function6, function7, j3, j4, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                        }
                    }
                    i10 |= 100663296;
                    if ((i10 & 38347923) != 38347922) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z4, i10 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "97@4401L7");
                        if ((i & 1) != 0) {
                            if (i11 != 0) {
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
                            if ((i2 & 64) != 0) {
                                ProvidableCompositionLocal<Color> localContentColor10 = ContentColorKt.getLocalContentColor();
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                Object objConsume10 = composerStartRestartGroup.consume(localContentColor10);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                jM6824unboximpl = ((Color) objConsume10).m6824unboximpl();
                                i10 &= -3670017;
                            } else {
                                jM6824unboximpl = j;
                            }
                            if ((i2 & 128) != 0) {
                                i10 &= -29360129;
                                j5 = jM6824unboximpl;
                            } else {
                                j5 = j2;
                            }
                            z6 = z3;
                            composableLambdaRememberComposableLambda = null;
                            if (i12 != 0) {
                                j6 = jM6824unboximpl;
                                i14 = 1015017965;
                                mutableInteractionSource3 = null;
                                j7 = j5;
                            } else {
                                j6 = jM6824unboximpl;
                                j7 = j5;
                                i14 = 1015017965;
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                        } else {
                            if (i11 != 0) {
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
                            if ((i2 & 64) != 0) {
                                ProvidableCompositionLocal<Color> localContentColor11 = ContentColorKt.getLocalContentColor();
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                Object objConsume11 = composerStartRestartGroup.consume(localContentColor11);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                jM6824unboximpl = ((Color) objConsume11).m6824unboximpl();
                                i10 &= -3670017;
                            } else {
                                jM6824unboximpl = j;
                            }
                            if ((i2 & 128) != 0) {
                                i10 &= -29360129;
                                j5 = jM6824unboximpl;
                            } else {
                                j5 = j2;
                            }
                            z6 = z3;
                            composableLambdaRememberComposableLambda = null;
                            if (i12 != 0) {
                                j6 = jM6824unboximpl;
                                i14 = 1015017965;
                                mutableInteractionSource3 = null;
                                j7 = j5;
                            } else {
                                j6 = jM6824unboximpl;
                                j7 = j5;
                                i14 = 1015017965;
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(i14, i10, -1, "androidx.compose.material3.Tab (Tab.kt:100)");
                        }
                        if (function4 == null) {
                            composerStartRestartGroup.startReplaceGroup(1830887765);
                        } else {
                            composerStartRestartGroup.startReplaceGroup(1830887766);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "*103@4621L247");
                            composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-1745256900, true, new Function2() { // from class: androidx.compose.material3.TabKt$$ExternalSyntheticLambda2
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return TabKt.Tab_wqdebIU$lambda$0$0(function4, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composerStartRestartGroup, 54);
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        int i114 = i10 >> 6;
                        composer2 = composerStartRestartGroup;
                        m4363TabbogVsAg(z, function0, BadgeKt.badgeBounds(modifier2), z6, j6, j7, mutableInteractionSource3, ComposableLambdaKt.rememberComposableLambda(-906085472, true, new Function3() { // from class: androidx.compose.material3.TabKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return TabKt.Tab_wqdebIU$lambda$1(composableLambdaRememberComposableLambda, function5, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composerStartRestartGroup, 54), composer2, (i10 & 14) | 12582912 | (i10 & 112) | (i10 & 7168) | (57344 & i114) | (458752 & i114) | (i114 & 3670016), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier2;
                        function6 = function4;
                        function7 = function5;
                        z5 = z6;
                        j3 = j6;
                        j4 = j7;
                        mutableInteractionSource2 = mutableInteractionSource3;
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
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TabKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return TabKt.Tab_wqdebIU$lambda$2(z, function0, modifier3, z5, function6, function7, j3, j4, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                function5 = function3;
                if ((1572864 & i) == 0) {
                    if ((i2 & 64) == 0) {
                        i16 = i3;
                        i11 = i17;
                        if (composerStartRestartGroup.changed(j)) {
                        }
                        i10 = i16 | i18;
                    } else {
                        i16 = i3;
                        i11 = i17;
                    }
                    i10 = i16 | i18;
                } else {
                    i10 = i3;
                    i11 = i17;
                }
                if ((i & 12582912) != 0) {
                    if ((i2 & 128) == 0) {
                        i15 = 4194304;
                    } else {
                        i15 = 4194304;
                    }
                    i10 |= i15;
                }
                i12 = i2 & 256;
                if (i12 != 0) {
                    if ((i & 100663296) == 0) {
                        if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                            i13 = 67108864;
                        } else {
                            i13 = 33554432;
                        }
                        i10 |= i13;
                    }
                    if ((i10 & 38347923) != 38347922) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z4, i10 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "97@4401L7");
                        if ((i & 1) != 0) {
                            if (i11 != 0) {
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
                            if ((i2 & 64) != 0) {
                                ProvidableCompositionLocal<Color> localContentColor12 = ContentColorKt.getLocalContentColor();
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                Object objConsume12 = composerStartRestartGroup.consume(localContentColor12);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                jM6824unboximpl = ((Color) objConsume12).m6824unboximpl();
                                i10 &= -3670017;
                            } else {
                                jM6824unboximpl = j;
                            }
                            if ((i2 & 128) != 0) {
                                i10 &= -29360129;
                                j5 = jM6824unboximpl;
                            } else {
                                j5 = j2;
                            }
                            z6 = z3;
                            composableLambdaRememberComposableLambda = null;
                            if (i12 != 0) {
                                j6 = jM6824unboximpl;
                                i14 = 1015017965;
                                mutableInteractionSource3 = null;
                                j7 = j5;
                            } else {
                                j6 = jM6824unboximpl;
                                j7 = j5;
                                i14 = 1015017965;
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                        } else {
                            if (i11 != 0) {
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
                            if ((i2 & 64) != 0) {
                                ProvidableCompositionLocal<Color> localContentColor13 = ContentColorKt.getLocalContentColor();
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                Object objConsume13 = composerStartRestartGroup.consume(localContentColor13);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                jM6824unboximpl = ((Color) objConsume13).m6824unboximpl();
                                i10 &= -3670017;
                            } else {
                                jM6824unboximpl = j;
                            }
                            if ((i2 & 128) != 0) {
                                i10 &= -29360129;
                                j5 = jM6824unboximpl;
                            } else {
                                j5 = j2;
                            }
                            z6 = z3;
                            composableLambdaRememberComposableLambda = null;
                            if (i12 != 0) {
                                j6 = jM6824unboximpl;
                                i14 = 1015017965;
                                mutableInteractionSource3 = null;
                                j7 = j5;
                            } else {
                                j6 = jM6824unboximpl;
                                j7 = j5;
                                i14 = 1015017965;
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(i14, i10, -1, "androidx.compose.material3.Tab (Tab.kt:100)");
                        }
                        if (function4 == null) {
                            composerStartRestartGroup.startReplaceGroup(1830887765);
                        } else {
                            composerStartRestartGroup.startReplaceGroup(1830887766);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "*103@4621L247");
                            composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-1745256900, true, new Function2() { // from class: androidx.compose.material3.TabKt$$ExternalSyntheticLambda2
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return TabKt.Tab_wqdebIU$lambda$0$0(function4, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composerStartRestartGroup, 54);
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        int i115 = i10 >> 6;
                        composer2 = composerStartRestartGroup;
                        m4363TabbogVsAg(z, function0, BadgeKt.badgeBounds(modifier2), z6, j6, j7, mutableInteractionSource3, ComposableLambdaKt.rememberComposableLambda(-906085472, true, new Function3() { // from class: androidx.compose.material3.TabKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return TabKt.Tab_wqdebIU$lambda$1(composableLambdaRememberComposableLambda, function5, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composerStartRestartGroup, 54), composer2, (i10 & 14) | 12582912 | (i10 & 112) | (i10 & 7168) | (57344 & i115) | (458752 & i115) | (i115 & 3670016), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier2;
                        function6 = function4;
                        function7 = function5;
                        z5 = z6;
                        j3 = j6;
                        j4 = j7;
                        mutableInteractionSource2 = mutableInteractionSource3;
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
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TabKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return TabKt.Tab_wqdebIU$lambda$2(z, function0, modifier3, z5, function6, function7, j3, j4, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i10 |= 100663296;
                if ((i10 & 38347923) != 38347922) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z4, i10 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "97@4401L7");
                    if ((i & 1) != 0) {
                        if (i11 != 0) {
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
                        if ((i2 & 64) != 0) {
                            ProvidableCompositionLocal<Color> localContentColor14 = ContentColorKt.getLocalContentColor();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                            Object objConsume14 = composerStartRestartGroup.consume(localContentColor14);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            jM6824unboximpl = ((Color) objConsume14).m6824unboximpl();
                            i10 &= -3670017;
                        } else {
                            jM6824unboximpl = j;
                        }
                        if ((i2 & 128) != 0) {
                            i10 &= -29360129;
                            j5 = jM6824unboximpl;
                        } else {
                            j5 = j2;
                        }
                        z6 = z3;
                        composableLambdaRememberComposableLambda = null;
                        if (i12 != 0) {
                            j6 = jM6824unboximpl;
                            i14 = 1015017965;
                            mutableInteractionSource3 = null;
                            j7 = j5;
                        } else {
                            j6 = jM6824unboximpl;
                            j7 = j5;
                            i14 = 1015017965;
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                    } else {
                        if (i11 != 0) {
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
                        if ((i2 & 64) != 0) {
                            ProvidableCompositionLocal<Color> localContentColor15 = ContentColorKt.getLocalContentColor();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                            Object objConsume15 = composerStartRestartGroup.consume(localContentColor15);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            jM6824unboximpl = ((Color) objConsume15).m6824unboximpl();
                            i10 &= -3670017;
                        } else {
                            jM6824unboximpl = j;
                        }
                        if ((i2 & 128) != 0) {
                            i10 &= -29360129;
                            j5 = jM6824unboximpl;
                        } else {
                            j5 = j2;
                        }
                        z6 = z3;
                        composableLambdaRememberComposableLambda = null;
                        if (i12 != 0) {
                            j6 = jM6824unboximpl;
                            i14 = 1015017965;
                            mutableInteractionSource3 = null;
                            j7 = j5;
                        } else {
                            j6 = jM6824unboximpl;
                            j7 = j5;
                            i14 = 1015017965;
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(i14, i10, -1, "androidx.compose.material3.Tab (Tab.kt:100)");
                    }
                    if (function4 == null) {
                        composerStartRestartGroup.startReplaceGroup(1830887765);
                    } else {
                        composerStartRestartGroup.startReplaceGroup(1830887766);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "*103@4621L247");
                        composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-1745256900, true, new Function2() { // from class: androidx.compose.material3.TabKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return TabKt.Tab_wqdebIU$lambda$0$0(function4, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    int i116 = i10 >> 6;
                    composer2 = composerStartRestartGroup;
                    m4363TabbogVsAg(z, function0, BadgeKt.badgeBounds(modifier2), z6, j6, j7, mutableInteractionSource3, ComposableLambdaKt.rememberComposableLambda(-906085472, true, new Function3() { // from class: androidx.compose.material3.TabKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return TabKt.Tab_wqdebIU$lambda$1(composableLambdaRememberComposableLambda, function5, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54), composer2, (i10 & 14) | 12582912 | (i10 & 112) | (i10 & 7168) | (57344 & i116) | (458752 & i116) | (i116 & 3670016), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                    function6 = function4;
                    function7 = function5;
                    z5 = z6;
                    j3 = j6;
                    j4 = j7;
                    mutableInteractionSource2 = mutableInteractionSource3;
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
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TabKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return TabKt.Tab_wqdebIU$lambda$2(z, function0, modifier3, z5, function6, function7, j3, j4, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
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
                    if ((1572864 & i) == 0) {
                        if ((i2 & 64) == 0) {
                            i16 = i3;
                            i11 = i17;
                            if (composerStartRestartGroup.changed(j)) {
                            }
                            i10 = i16 | i18;
                        } else {
                            i16 = i3;
                            i11 = i17;
                        }
                        i10 = i16 | i18;
                    } else {
                        i10 = i3;
                        i11 = i17;
                    }
                    if ((i & 12582912) != 0) {
                        if ((i2 & 128) == 0) {
                            i15 = 4194304;
                        } else {
                            i15 = 4194304;
                        }
                        i10 |= i15;
                    }
                    i12 = i2 & 256;
                    if (i12 != 0) {
                        if ((i & 100663296) == 0) {
                            if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                                i13 = 67108864;
                            } else {
                                i13 = 33554432;
                            }
                            i10 |= i13;
                        }
                        if ((i10 & 38347923) != 38347922) {
                            z4 = true;
                        } else {
                            z4 = false;
                        }
                        if (composerStartRestartGroup.shouldExecute(z4, i10 & 1)) {
                            composerStartRestartGroup.startDefaults();
                            ComposerKt.sourceInformation(composerStartRestartGroup, "97@4401L7");
                            if ((i & 1) != 0) {
                                if (i11 != 0) {
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
                                if ((i2 & 64) != 0) {
                                    ProvidableCompositionLocal<Color> localContentColor16 = ContentColorKt.getLocalContentColor();
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                    Object objConsume16 = composerStartRestartGroup.consume(localContentColor16);
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                    jM6824unboximpl = ((Color) objConsume16).m6824unboximpl();
                                    i10 &= -3670017;
                                } else {
                                    jM6824unboximpl = j;
                                }
                                if ((i2 & 128) != 0) {
                                    i10 &= -29360129;
                                    j5 = jM6824unboximpl;
                                } else {
                                    j5 = j2;
                                }
                                z6 = z3;
                                composableLambdaRememberComposableLambda = null;
                                if (i12 != 0) {
                                    j6 = jM6824unboximpl;
                                    i14 = 1015017965;
                                    mutableInteractionSource3 = null;
                                    j7 = j5;
                                } else {
                                    j6 = jM6824unboximpl;
                                    j7 = j5;
                                    i14 = 1015017965;
                                    mutableInteractionSource3 = mutableInteractionSource;
                                }
                            } else {
                                if (i11 != 0) {
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
                                if ((i2 & 64) != 0) {
                                    ProvidableCompositionLocal<Color> localContentColor17 = ContentColorKt.getLocalContentColor();
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                    Object objConsume17 = composerStartRestartGroup.consume(localContentColor17);
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                    jM6824unboximpl = ((Color) objConsume17).m6824unboximpl();
                                    i10 &= -3670017;
                                } else {
                                    jM6824unboximpl = j;
                                }
                                if ((i2 & 128) != 0) {
                                    i10 &= -29360129;
                                    j5 = jM6824unboximpl;
                                } else {
                                    j5 = j2;
                                }
                                z6 = z3;
                                composableLambdaRememberComposableLambda = null;
                                if (i12 != 0) {
                                    j6 = jM6824unboximpl;
                                    i14 = 1015017965;
                                    mutableInteractionSource3 = null;
                                    j7 = j5;
                                } else {
                                    j6 = jM6824unboximpl;
                                    j7 = j5;
                                    i14 = 1015017965;
                                    mutableInteractionSource3 = mutableInteractionSource;
                                }
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(i14, i10, -1, "androidx.compose.material3.Tab (Tab.kt:100)");
                            }
                            if (function4 == null) {
                                composerStartRestartGroup.startReplaceGroup(1830887765);
                            } else {
                                composerStartRestartGroup.startReplaceGroup(1830887766);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "*103@4621L247");
                                composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-1745256900, true, new Function2() { // from class: androidx.compose.material3.TabKt$$ExternalSyntheticLambda2
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return TabKt.Tab_wqdebIU$lambda$0$0(function4, (Composer) obj, ((Integer) obj2).intValue());
                                    }
                                }, composerStartRestartGroup, 54);
                            }
                            composerStartRestartGroup.endReplaceGroup();
                            int i117 = i10 >> 6;
                            composer2 = composerStartRestartGroup;
                            m4363TabbogVsAg(z, function0, BadgeKt.badgeBounds(modifier2), z6, j6, j7, mutableInteractionSource3, ComposableLambdaKt.rememberComposableLambda(-906085472, true, new Function3() { // from class: androidx.compose.material3.TabKt$$ExternalSyntheticLambda3
                                @Override // kotlin.jvm.functions.Function3
                                public final Object invoke(Object obj, Object obj2, Object obj3) {
                                    return TabKt.Tab_wqdebIU$lambda$1(composableLambdaRememberComposableLambda, function5, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                }
                            }, composerStartRestartGroup, 54), composer2, (i10 & 14) | 12582912 | (i10 & 112) | (i10 & 7168) | (57344 & i117) | (458752 & i117) | (i117 & 3670016), 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier3 = modifier2;
                            function6 = function4;
                            function7 = function5;
                            z5 = z6;
                            j3 = j6;
                            j4 = j7;
                            mutableInteractionSource2 = mutableInteractionSource3;
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
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TabKt$$ExternalSyntheticLambda4
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return TabKt.Tab_wqdebIU$lambda$2(z, function0, modifier3, z5, function6, function7, j3, j4, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                        }
                    }
                    i10 |= 100663296;
                    if ((i10 & 38347923) != 38347922) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z4, i10 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "97@4401L7");
                        if ((i & 1) != 0) {
                            if (i11 != 0) {
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
                            if ((i2 & 64) != 0) {
                                ProvidableCompositionLocal<Color> localContentColor18 = ContentColorKt.getLocalContentColor();
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                Object objConsume18 = composerStartRestartGroup.consume(localContentColor18);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                jM6824unboximpl = ((Color) objConsume18).m6824unboximpl();
                                i10 &= -3670017;
                            } else {
                                jM6824unboximpl = j;
                            }
                            if ((i2 & 128) != 0) {
                                i10 &= -29360129;
                                j5 = jM6824unboximpl;
                            } else {
                                j5 = j2;
                            }
                            z6 = z3;
                            composableLambdaRememberComposableLambda = null;
                            if (i12 != 0) {
                                j6 = jM6824unboximpl;
                                i14 = 1015017965;
                                mutableInteractionSource3 = null;
                                j7 = j5;
                            } else {
                                j6 = jM6824unboximpl;
                                j7 = j5;
                                i14 = 1015017965;
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                        } else {
                            if (i11 != 0) {
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
                            if ((i2 & 64) != 0) {
                                ProvidableCompositionLocal<Color> localContentColor19 = ContentColorKt.getLocalContentColor();
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                Object objConsume19 = composerStartRestartGroup.consume(localContentColor19);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                jM6824unboximpl = ((Color) objConsume19).m6824unboximpl();
                                i10 &= -3670017;
                            } else {
                                jM6824unboximpl = j;
                            }
                            if ((i2 & 128) != 0) {
                                i10 &= -29360129;
                                j5 = jM6824unboximpl;
                            } else {
                                j5 = j2;
                            }
                            z6 = z3;
                            composableLambdaRememberComposableLambda = null;
                            if (i12 != 0) {
                                j6 = jM6824unboximpl;
                                i14 = 1015017965;
                                mutableInteractionSource3 = null;
                                j7 = j5;
                            } else {
                                j6 = jM6824unboximpl;
                                j7 = j5;
                                i14 = 1015017965;
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(i14, i10, -1, "androidx.compose.material3.Tab (Tab.kt:100)");
                        }
                        if (function4 == null) {
                            composerStartRestartGroup.startReplaceGroup(1830887765);
                        } else {
                            composerStartRestartGroup.startReplaceGroup(1830887766);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "*103@4621L247");
                            composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-1745256900, true, new Function2() { // from class: androidx.compose.material3.TabKt$$ExternalSyntheticLambda2
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return TabKt.Tab_wqdebIU$lambda$0$0(function4, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composerStartRestartGroup, 54);
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        int i118 = i10 >> 6;
                        composer2 = composerStartRestartGroup;
                        m4363TabbogVsAg(z, function0, BadgeKt.badgeBounds(modifier2), z6, j6, j7, mutableInteractionSource3, ComposableLambdaKt.rememberComposableLambda(-906085472, true, new Function3() { // from class: androidx.compose.material3.TabKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return TabKt.Tab_wqdebIU$lambda$1(composableLambdaRememberComposableLambda, function5, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composerStartRestartGroup, 54), composer2, (i10 & 14) | 12582912 | (i10 & 112) | (i10 & 7168) | (57344 & i118) | (458752 & i118) | (i118 & 3670016), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier2;
                        function6 = function4;
                        function7 = function5;
                        z5 = z6;
                        j3 = j6;
                        j4 = j7;
                        mutableInteractionSource2 = mutableInteractionSource3;
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
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TabKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return TabKt.Tab_wqdebIU$lambda$2(z, function0, modifier3, z5, function6, function7, j3, j4, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                function5 = function3;
                if ((1572864 & i) == 0) {
                    if ((i2 & 64) == 0) {
                        i16 = i3;
                        i11 = i17;
                        if (composerStartRestartGroup.changed(j)) {
                        }
                        i10 = i16 | i18;
                    } else {
                        i16 = i3;
                        i11 = i17;
                    }
                    i10 = i16 | i18;
                } else {
                    i10 = i3;
                    i11 = i17;
                }
                if ((i & 12582912) != 0) {
                    if ((i2 & 128) == 0) {
                        i15 = 4194304;
                    } else {
                        i15 = 4194304;
                    }
                    i10 |= i15;
                }
                i12 = i2 & 256;
                if (i12 != 0) {
                    if ((i & 100663296) == 0) {
                        if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                            i13 = 67108864;
                        } else {
                            i13 = 33554432;
                        }
                        i10 |= i13;
                    }
                    if ((i10 & 38347923) != 38347922) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z4, i10 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "97@4401L7");
                        if ((i & 1) != 0) {
                            if (i11 != 0) {
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
                            if ((i2 & 64) != 0) {
                                ProvidableCompositionLocal<Color> localContentColor110 = ContentColorKt.getLocalContentColor();
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                Object objConsume110 = composerStartRestartGroup.consume(localContentColor110);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                jM6824unboximpl = ((Color) objConsume110).m6824unboximpl();
                                i10 &= -3670017;
                            } else {
                                jM6824unboximpl = j;
                            }
                            if ((i2 & 128) != 0) {
                                i10 &= -29360129;
                                j5 = jM6824unboximpl;
                            } else {
                                j5 = j2;
                            }
                            z6 = z3;
                            composableLambdaRememberComposableLambda = null;
                            if (i12 != 0) {
                                j6 = jM6824unboximpl;
                                i14 = 1015017965;
                                mutableInteractionSource3 = null;
                                j7 = j5;
                            } else {
                                j6 = jM6824unboximpl;
                                j7 = j5;
                                i14 = 1015017965;
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                        } else {
                            if (i11 != 0) {
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
                            if ((i2 & 64) != 0) {
                                ProvidableCompositionLocal<Color> localContentColor111 = ContentColorKt.getLocalContentColor();
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                Object objConsume111 = composerStartRestartGroup.consume(localContentColor111);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                jM6824unboximpl = ((Color) objConsume111).m6824unboximpl();
                                i10 &= -3670017;
                            } else {
                                jM6824unboximpl = j;
                            }
                            if ((i2 & 128) != 0) {
                                i10 &= -29360129;
                                j5 = jM6824unboximpl;
                            } else {
                                j5 = j2;
                            }
                            z6 = z3;
                            composableLambdaRememberComposableLambda = null;
                            if (i12 != 0) {
                                j6 = jM6824unboximpl;
                                i14 = 1015017965;
                                mutableInteractionSource3 = null;
                                j7 = j5;
                            } else {
                                j6 = jM6824unboximpl;
                                j7 = j5;
                                i14 = 1015017965;
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(i14, i10, -1, "androidx.compose.material3.Tab (Tab.kt:100)");
                        }
                        if (function4 == null) {
                            composerStartRestartGroup.startReplaceGroup(1830887765);
                        } else {
                            composerStartRestartGroup.startReplaceGroup(1830887766);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "*103@4621L247");
                            composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-1745256900, true, new Function2() { // from class: androidx.compose.material3.TabKt$$ExternalSyntheticLambda2
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return TabKt.Tab_wqdebIU$lambda$0$0(function4, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composerStartRestartGroup, 54);
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        int i119 = i10 >> 6;
                        composer2 = composerStartRestartGroup;
                        m4363TabbogVsAg(z, function0, BadgeKt.badgeBounds(modifier2), z6, j6, j7, mutableInteractionSource3, ComposableLambdaKt.rememberComposableLambda(-906085472, true, new Function3() { // from class: androidx.compose.material3.TabKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return TabKt.Tab_wqdebIU$lambda$1(composableLambdaRememberComposableLambda, function5, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composerStartRestartGroup, 54), composer2, (i10 & 14) | 12582912 | (i10 & 112) | (i10 & 7168) | (57344 & i119) | (458752 & i119) | (i119 & 3670016), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier2;
                        function6 = function4;
                        function7 = function5;
                        z5 = z6;
                        j3 = j6;
                        j4 = j7;
                        mutableInteractionSource2 = mutableInteractionSource3;
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
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TabKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return TabKt.Tab_wqdebIU$lambda$2(z, function0, modifier3, z5, function6, function7, j3, j4, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i10 |= 100663296;
                if ((i10 & 38347923) != 38347922) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z4, i10 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "97@4401L7");
                    if ((i & 1) != 0) {
                        if (i11 != 0) {
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
                        if ((i2 & 64) != 0) {
                            ProvidableCompositionLocal<Color> localContentColor112 = ContentColorKt.getLocalContentColor();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                            Object objConsume112 = composerStartRestartGroup.consume(localContentColor112);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            jM6824unboximpl = ((Color) objConsume112).m6824unboximpl();
                            i10 &= -3670017;
                        } else {
                            jM6824unboximpl = j;
                        }
                        if ((i2 & 128) != 0) {
                            i10 &= -29360129;
                            j5 = jM6824unboximpl;
                        } else {
                            j5 = j2;
                        }
                        z6 = z3;
                        composableLambdaRememberComposableLambda = null;
                        if (i12 != 0) {
                            j6 = jM6824unboximpl;
                            i14 = 1015017965;
                            mutableInteractionSource3 = null;
                            j7 = j5;
                        } else {
                            j6 = jM6824unboximpl;
                            j7 = j5;
                            i14 = 1015017965;
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                    } else {
                        if (i11 != 0) {
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
                        if ((i2 & 64) != 0) {
                            ProvidableCompositionLocal<Color> localContentColor113 = ContentColorKt.getLocalContentColor();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                            Object objConsume113 = composerStartRestartGroup.consume(localContentColor113);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            jM6824unboximpl = ((Color) objConsume113).m6824unboximpl();
                            i10 &= -3670017;
                        } else {
                            jM6824unboximpl = j;
                        }
                        if ((i2 & 128) != 0) {
                            i10 &= -29360129;
                            j5 = jM6824unboximpl;
                        } else {
                            j5 = j2;
                        }
                        z6 = z3;
                        composableLambdaRememberComposableLambda = null;
                        if (i12 != 0) {
                            j6 = jM6824unboximpl;
                            i14 = 1015017965;
                            mutableInteractionSource3 = null;
                            j7 = j5;
                        } else {
                            j6 = jM6824unboximpl;
                            j7 = j5;
                            i14 = 1015017965;
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(i14, i10, -1, "androidx.compose.material3.Tab (Tab.kt:100)");
                    }
                    if (function4 == null) {
                        composerStartRestartGroup.startReplaceGroup(1830887765);
                    } else {
                        composerStartRestartGroup.startReplaceGroup(1830887766);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "*103@4621L247");
                        composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-1745256900, true, new Function2() { // from class: androidx.compose.material3.TabKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return TabKt.Tab_wqdebIU$lambda$0$0(function4, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    int i1110 = i10 >> 6;
                    composer2 = composerStartRestartGroup;
                    m4363TabbogVsAg(z, function0, BadgeKt.badgeBounds(modifier2), z6, j6, j7, mutableInteractionSource3, ComposableLambdaKt.rememberComposableLambda(-906085472, true, new Function3() { // from class: androidx.compose.material3.TabKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return TabKt.Tab_wqdebIU$lambda$1(composableLambdaRememberComposableLambda, function5, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54), composer2, (i10 & 14) | 12582912 | (i10 & 112) | (i10 & 7168) | (57344 & i1110) | (458752 & i1110) | (i1110 & 3670016), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                    function6 = function4;
                    function7 = function5;
                    z5 = z6;
                    j3 = j6;
                    j4 = j7;
                    mutableInteractionSource2 = mutableInteractionSource3;
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
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TabKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return TabKt.Tab_wqdebIU$lambda$2(z, function0, modifier3, z5, function6, function7, j3, j4, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
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
                if ((1572864 & i) == 0) {
                    if ((i2 & 64) == 0) {
                        i16 = i3;
                        i11 = i17;
                        if (composerStartRestartGroup.changed(j)) {
                        }
                        i10 = i16 | i18;
                    } else {
                        i16 = i3;
                        i11 = i17;
                    }
                    i10 = i16 | i18;
                } else {
                    i10 = i3;
                    i11 = i17;
                }
                if ((i & 12582912) != 0) {
                    if ((i2 & 128) == 0) {
                        i15 = 4194304;
                    } else {
                        i15 = 4194304;
                    }
                    i10 |= i15;
                }
                i12 = i2 & 256;
                if (i12 != 0) {
                    if ((i & 100663296) == 0) {
                        if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                            i13 = 67108864;
                        } else {
                            i13 = 33554432;
                        }
                        i10 |= i13;
                    }
                    if ((i10 & 38347923) != 38347922) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z4, i10 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "97@4401L7");
                        if ((i & 1) != 0) {
                            if (i11 != 0) {
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
                            if ((i2 & 64) != 0) {
                                ProvidableCompositionLocal<Color> localContentColor114 = ContentColorKt.getLocalContentColor();
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                Object objConsume114 = composerStartRestartGroup.consume(localContentColor114);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                jM6824unboximpl = ((Color) objConsume114).m6824unboximpl();
                                i10 &= -3670017;
                            } else {
                                jM6824unboximpl = j;
                            }
                            if ((i2 & 128) != 0) {
                                i10 &= -29360129;
                                j5 = jM6824unboximpl;
                            } else {
                                j5 = j2;
                            }
                            z6 = z3;
                            composableLambdaRememberComposableLambda = null;
                            if (i12 != 0) {
                                j6 = jM6824unboximpl;
                                i14 = 1015017965;
                                mutableInteractionSource3 = null;
                                j7 = j5;
                            } else {
                                j6 = jM6824unboximpl;
                                j7 = j5;
                                i14 = 1015017965;
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                        } else {
                            if (i11 != 0) {
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
                            if ((i2 & 64) != 0) {
                                ProvidableCompositionLocal<Color> localContentColor115 = ContentColorKt.getLocalContentColor();
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                Object objConsume115 = composerStartRestartGroup.consume(localContentColor115);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                jM6824unboximpl = ((Color) objConsume115).m6824unboximpl();
                                i10 &= -3670017;
                            } else {
                                jM6824unboximpl = j;
                            }
                            if ((i2 & 128) != 0) {
                                i10 &= -29360129;
                                j5 = jM6824unboximpl;
                            } else {
                                j5 = j2;
                            }
                            z6 = z3;
                            composableLambdaRememberComposableLambda = null;
                            if (i12 != 0) {
                                j6 = jM6824unboximpl;
                                i14 = 1015017965;
                                mutableInteractionSource3 = null;
                                j7 = j5;
                            } else {
                                j6 = jM6824unboximpl;
                                j7 = j5;
                                i14 = 1015017965;
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(i14, i10, -1, "androidx.compose.material3.Tab (Tab.kt:100)");
                        }
                        if (function4 == null) {
                            composerStartRestartGroup.startReplaceGroup(1830887765);
                        } else {
                            composerStartRestartGroup.startReplaceGroup(1830887766);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "*103@4621L247");
                            composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-1745256900, true, new Function2() { // from class: androidx.compose.material3.TabKt$$ExternalSyntheticLambda2
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return TabKt.Tab_wqdebIU$lambda$0$0(function4, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composerStartRestartGroup, 54);
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        int i1111 = i10 >> 6;
                        composer2 = composerStartRestartGroup;
                        m4363TabbogVsAg(z, function0, BadgeKt.badgeBounds(modifier2), z6, j6, j7, mutableInteractionSource3, ComposableLambdaKt.rememberComposableLambda(-906085472, true, new Function3() { // from class: androidx.compose.material3.TabKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return TabKt.Tab_wqdebIU$lambda$1(composableLambdaRememberComposableLambda, function5, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composerStartRestartGroup, 54), composer2, (i10 & 14) | 12582912 | (i10 & 112) | (i10 & 7168) | (57344 & i1111) | (458752 & i1111) | (i1111 & 3670016), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier2;
                        function6 = function4;
                        function7 = function5;
                        z5 = z6;
                        j3 = j6;
                        j4 = j7;
                        mutableInteractionSource2 = mutableInteractionSource3;
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
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TabKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return TabKt.Tab_wqdebIU$lambda$2(z, function0, modifier3, z5, function6, function7, j3, j4, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i10 |= 100663296;
                if ((i10 & 38347923) != 38347922) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z4, i10 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "97@4401L7");
                    if ((i & 1) != 0) {
                        if (i11 != 0) {
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
                        if ((i2 & 64) != 0) {
                            ProvidableCompositionLocal<Color> localContentColor116 = ContentColorKt.getLocalContentColor();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                            Object objConsume116 = composerStartRestartGroup.consume(localContentColor116);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            jM6824unboximpl = ((Color) objConsume116).m6824unboximpl();
                            i10 &= -3670017;
                        } else {
                            jM6824unboximpl = j;
                        }
                        if ((i2 & 128) != 0) {
                            i10 &= -29360129;
                            j5 = jM6824unboximpl;
                        } else {
                            j5 = j2;
                        }
                        z6 = z3;
                        composableLambdaRememberComposableLambda = null;
                        if (i12 != 0) {
                            j6 = jM6824unboximpl;
                            i14 = 1015017965;
                            mutableInteractionSource3 = null;
                            j7 = j5;
                        } else {
                            j6 = jM6824unboximpl;
                            j7 = j5;
                            i14 = 1015017965;
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                    } else {
                        if (i11 != 0) {
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
                        if ((i2 & 64) != 0) {
                            ProvidableCompositionLocal<Color> localContentColor117 = ContentColorKt.getLocalContentColor();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                            Object objConsume117 = composerStartRestartGroup.consume(localContentColor117);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            jM6824unboximpl = ((Color) objConsume117).m6824unboximpl();
                            i10 &= -3670017;
                        } else {
                            jM6824unboximpl = j;
                        }
                        if ((i2 & 128) != 0) {
                            i10 &= -29360129;
                            j5 = jM6824unboximpl;
                        } else {
                            j5 = j2;
                        }
                        z6 = z3;
                        composableLambdaRememberComposableLambda = null;
                        if (i12 != 0) {
                            j6 = jM6824unboximpl;
                            i14 = 1015017965;
                            mutableInteractionSource3 = null;
                            j7 = j5;
                        } else {
                            j6 = jM6824unboximpl;
                            j7 = j5;
                            i14 = 1015017965;
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(i14, i10, -1, "androidx.compose.material3.Tab (Tab.kt:100)");
                    }
                    if (function4 == null) {
                        composerStartRestartGroup.startReplaceGroup(1830887765);
                    } else {
                        composerStartRestartGroup.startReplaceGroup(1830887766);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "*103@4621L247");
                        composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-1745256900, true, new Function2() { // from class: androidx.compose.material3.TabKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return TabKt.Tab_wqdebIU$lambda$0$0(function4, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    int i1112 = i10 >> 6;
                    composer2 = composerStartRestartGroup;
                    m4363TabbogVsAg(z, function0, BadgeKt.badgeBounds(modifier2), z6, j6, j7, mutableInteractionSource3, ComposableLambdaKt.rememberComposableLambda(-906085472, true, new Function3() { // from class: androidx.compose.material3.TabKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return TabKt.Tab_wqdebIU$lambda$1(composableLambdaRememberComposableLambda, function5, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54), composer2, (i10 & 14) | 12582912 | (i10 & 112) | (i10 & 7168) | (57344 & i1112) | (458752 & i1112) | (i1112 & 3670016), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                    function6 = function4;
                    function7 = function5;
                    z5 = z6;
                    j3 = j6;
                    j4 = j7;
                    mutableInteractionSource2 = mutableInteractionSource3;
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
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TabKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return TabKt.Tab_wqdebIU$lambda$2(z, function0, modifier3, z5, function6, function7, j3, j4, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            function5 = function3;
            if ((1572864 & i) == 0) {
                if ((i2 & 64) == 0) {
                    i16 = i3;
                    i11 = i17;
                    if (composerStartRestartGroup.changed(j)) {
                    }
                    i10 = i16 | i18;
                } else {
                    i16 = i3;
                    i11 = i17;
                }
                i10 = i16 | i18;
            } else {
                i10 = i3;
                i11 = i17;
            }
            if ((i & 12582912) != 0) {
                if ((i2 & 128) == 0) {
                    i15 = 4194304;
                } else {
                    i15 = 4194304;
                }
                i10 |= i15;
            }
            i12 = i2 & 256;
            if (i12 != 0) {
                if ((i & 100663296) == 0) {
                    if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                        i13 = 67108864;
                    } else {
                        i13 = 33554432;
                    }
                    i10 |= i13;
                }
                if ((i10 & 38347923) != 38347922) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z4, i10 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "97@4401L7");
                    if ((i & 1) != 0) {
                        if (i11 != 0) {
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
                        if ((i2 & 64) != 0) {
                            ProvidableCompositionLocal<Color> localContentColor118 = ContentColorKt.getLocalContentColor();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                            Object objConsume118 = composerStartRestartGroup.consume(localContentColor118);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            jM6824unboximpl = ((Color) objConsume118).m6824unboximpl();
                            i10 &= -3670017;
                        } else {
                            jM6824unboximpl = j;
                        }
                        if ((i2 & 128) != 0) {
                            i10 &= -29360129;
                            j5 = jM6824unboximpl;
                        } else {
                            j5 = j2;
                        }
                        z6 = z3;
                        composableLambdaRememberComposableLambda = null;
                        if (i12 != 0) {
                            j6 = jM6824unboximpl;
                            i14 = 1015017965;
                            mutableInteractionSource3 = null;
                            j7 = j5;
                        } else {
                            j6 = jM6824unboximpl;
                            j7 = j5;
                            i14 = 1015017965;
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                    } else {
                        if (i11 != 0) {
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
                        if ((i2 & 64) != 0) {
                            ProvidableCompositionLocal<Color> localContentColor119 = ContentColorKt.getLocalContentColor();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                            Object objConsume119 = composerStartRestartGroup.consume(localContentColor119);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            jM6824unboximpl = ((Color) objConsume119).m6824unboximpl();
                            i10 &= -3670017;
                        } else {
                            jM6824unboximpl = j;
                        }
                        if ((i2 & 128) != 0) {
                            i10 &= -29360129;
                            j5 = jM6824unboximpl;
                        } else {
                            j5 = j2;
                        }
                        z6 = z3;
                        composableLambdaRememberComposableLambda = null;
                        if (i12 != 0) {
                            j6 = jM6824unboximpl;
                            i14 = 1015017965;
                            mutableInteractionSource3 = null;
                            j7 = j5;
                        } else {
                            j6 = jM6824unboximpl;
                            j7 = j5;
                            i14 = 1015017965;
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(i14, i10, -1, "androidx.compose.material3.Tab (Tab.kt:100)");
                    }
                    if (function4 == null) {
                        composerStartRestartGroup.startReplaceGroup(1830887765);
                    } else {
                        composerStartRestartGroup.startReplaceGroup(1830887766);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "*103@4621L247");
                        composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-1745256900, true, new Function2() { // from class: androidx.compose.material3.TabKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return TabKt.Tab_wqdebIU$lambda$0$0(function4, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    int i1113 = i10 >> 6;
                    composer2 = composerStartRestartGroup;
                    m4363TabbogVsAg(z, function0, BadgeKt.badgeBounds(modifier2), z6, j6, j7, mutableInteractionSource3, ComposableLambdaKt.rememberComposableLambda(-906085472, true, new Function3() { // from class: androidx.compose.material3.TabKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return TabKt.Tab_wqdebIU$lambda$1(composableLambdaRememberComposableLambda, function5, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54), composer2, (i10 & 14) | 12582912 | (i10 & 112) | (i10 & 7168) | (57344 & i1113) | (458752 & i1113) | (i1113 & 3670016), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                    function6 = function4;
                    function7 = function5;
                    z5 = z6;
                    j3 = j6;
                    j4 = j7;
                    mutableInteractionSource2 = mutableInteractionSource3;
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
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TabKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return TabKt.Tab_wqdebIU$lambda$2(z, function0, modifier3, z5, function6, function7, j3, j4, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i10 |= 100663296;
            if ((i10 & 38347923) != 38347922) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z4, i10 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "97@4401L7");
                if ((i & 1) != 0) {
                    if (i11 != 0) {
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
                    if ((i2 & 64) != 0) {
                        ProvidableCompositionLocal<Color> localContentColor1110 = ContentColorKt.getLocalContentColor();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object objConsume1110 = composerStartRestartGroup.consume(localContentColor1110);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        jM6824unboximpl = ((Color) objConsume1110).m6824unboximpl();
                        i10 &= -3670017;
                    } else {
                        jM6824unboximpl = j;
                    }
                    if ((i2 & 128) != 0) {
                        i10 &= -29360129;
                        j5 = jM6824unboximpl;
                    } else {
                        j5 = j2;
                    }
                    z6 = z3;
                    composableLambdaRememberComposableLambda = null;
                    if (i12 != 0) {
                        j6 = jM6824unboximpl;
                        i14 = 1015017965;
                        mutableInteractionSource3 = null;
                        j7 = j5;
                    } else {
                        j6 = jM6824unboximpl;
                        j7 = j5;
                        i14 = 1015017965;
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                } else {
                    if (i11 != 0) {
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
                    if ((i2 & 64) != 0) {
                        ProvidableCompositionLocal<Color> localContentColor1111 = ContentColorKt.getLocalContentColor();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object objConsume1111 = composerStartRestartGroup.consume(localContentColor1111);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        jM6824unboximpl = ((Color) objConsume1111).m6824unboximpl();
                        i10 &= -3670017;
                    } else {
                        jM6824unboximpl = j;
                    }
                    if ((i2 & 128) != 0) {
                        i10 &= -29360129;
                        j5 = jM6824unboximpl;
                    } else {
                        j5 = j2;
                    }
                    z6 = z3;
                    composableLambdaRememberComposableLambda = null;
                    if (i12 != 0) {
                        j6 = jM6824unboximpl;
                        i14 = 1015017965;
                        mutableInteractionSource3 = null;
                        j7 = j5;
                    } else {
                        j6 = jM6824unboximpl;
                        j7 = j5;
                        i14 = 1015017965;
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(i14, i10, -1, "androidx.compose.material3.Tab (Tab.kt:100)");
                }
                if (function4 == null) {
                    composerStartRestartGroup.startReplaceGroup(1830887765);
                } else {
                    composerStartRestartGroup.startReplaceGroup(1830887766);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "*103@4621L247");
                    composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-1745256900, true, new Function2() { // from class: androidx.compose.material3.TabKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return TabKt.Tab_wqdebIU$lambda$0$0(function4, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54);
                }
                composerStartRestartGroup.endReplaceGroup();
                int i1114 = i10 >> 6;
                composer2 = composerStartRestartGroup;
                m4363TabbogVsAg(z, function0, BadgeKt.badgeBounds(modifier2), z6, j6, j7, mutableInteractionSource3, ComposableLambdaKt.rememberComposableLambda(-906085472, true, new Function3() { // from class: androidx.compose.material3.TabKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return TabKt.Tab_wqdebIU$lambda$1(composableLambdaRememberComposableLambda, function5, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), composer2, (i10 & 14) | 12582912 | (i10 & 112) | (i10 & 7168) | (57344 & i1114) | (458752 & i1114) | (i1114 & 3670016), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier2;
                function6 = function4;
                function7 = function5;
                z5 = z6;
                j3 = j6;
                j4 = j7;
                mutableInteractionSource2 = mutableInteractionSource3;
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
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TabKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return TabKt.Tab_wqdebIU$lambda$2(z, function0, modifier3, z5, function6, function7, j3, j4, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
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
                    if ((1572864 & i) == 0) {
                        if ((i2 & 64) == 0) {
                            i16 = i3;
                            i11 = i17;
                            if (composerStartRestartGroup.changed(j)) {
                            }
                            i10 = i16 | i18;
                        } else {
                            i16 = i3;
                            i11 = i17;
                        }
                        i10 = i16 | i18;
                    } else {
                        i10 = i3;
                        i11 = i17;
                    }
                    if ((i & 12582912) != 0) {
                        if ((i2 & 128) == 0) {
                            i15 = 4194304;
                        } else {
                            i15 = 4194304;
                        }
                        i10 |= i15;
                    }
                    i12 = i2 & 256;
                    if (i12 != 0) {
                        if ((i & 100663296) == 0) {
                            if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                                i13 = 67108864;
                            } else {
                                i13 = 33554432;
                            }
                            i10 |= i13;
                        }
                        if ((i10 & 38347923) != 38347922) {
                            z4 = true;
                        } else {
                            z4 = false;
                        }
                        if (composerStartRestartGroup.shouldExecute(z4, i10 & 1)) {
                            composerStartRestartGroup.startDefaults();
                            ComposerKt.sourceInformation(composerStartRestartGroup, "97@4401L7");
                            if ((i & 1) != 0) {
                                if (i11 != 0) {
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
                                if ((i2 & 64) != 0) {
                                    ProvidableCompositionLocal<Color> localContentColor1112 = ContentColorKt.getLocalContentColor();
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                    Object objConsume1112 = composerStartRestartGroup.consume(localContentColor1112);
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                    jM6824unboximpl = ((Color) objConsume1112).m6824unboximpl();
                                    i10 &= -3670017;
                                } else {
                                    jM6824unboximpl = j;
                                }
                                if ((i2 & 128) != 0) {
                                    i10 &= -29360129;
                                    j5 = jM6824unboximpl;
                                } else {
                                    j5 = j2;
                                }
                                z6 = z3;
                                composableLambdaRememberComposableLambda = null;
                                if (i12 != 0) {
                                    j6 = jM6824unboximpl;
                                    i14 = 1015017965;
                                    mutableInteractionSource3 = null;
                                    j7 = j5;
                                } else {
                                    j6 = jM6824unboximpl;
                                    j7 = j5;
                                    i14 = 1015017965;
                                    mutableInteractionSource3 = mutableInteractionSource;
                                }
                            } else {
                                if (i11 != 0) {
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
                                if ((i2 & 64) != 0) {
                                    ProvidableCompositionLocal<Color> localContentColor1113 = ContentColorKt.getLocalContentColor();
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                    Object objConsume1113 = composerStartRestartGroup.consume(localContentColor1113);
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                    jM6824unboximpl = ((Color) objConsume1113).m6824unboximpl();
                                    i10 &= -3670017;
                                } else {
                                    jM6824unboximpl = j;
                                }
                                if ((i2 & 128) != 0) {
                                    i10 &= -29360129;
                                    j5 = jM6824unboximpl;
                                } else {
                                    j5 = j2;
                                }
                                z6 = z3;
                                composableLambdaRememberComposableLambda = null;
                                if (i12 != 0) {
                                    j6 = jM6824unboximpl;
                                    i14 = 1015017965;
                                    mutableInteractionSource3 = null;
                                    j7 = j5;
                                } else {
                                    j6 = jM6824unboximpl;
                                    j7 = j5;
                                    i14 = 1015017965;
                                    mutableInteractionSource3 = mutableInteractionSource;
                                }
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(i14, i10, -1, "androidx.compose.material3.Tab (Tab.kt:100)");
                            }
                            if (function4 == null) {
                                composerStartRestartGroup.startReplaceGroup(1830887765);
                            } else {
                                composerStartRestartGroup.startReplaceGroup(1830887766);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "*103@4621L247");
                                composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-1745256900, true, new Function2() { // from class: androidx.compose.material3.TabKt$$ExternalSyntheticLambda2
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return TabKt.Tab_wqdebIU$lambda$0$0(function4, (Composer) obj, ((Integer) obj2).intValue());
                                    }
                                }, composerStartRestartGroup, 54);
                            }
                            composerStartRestartGroup.endReplaceGroup();
                            int i1115 = i10 >> 6;
                            composer2 = composerStartRestartGroup;
                            m4363TabbogVsAg(z, function0, BadgeKt.badgeBounds(modifier2), z6, j6, j7, mutableInteractionSource3, ComposableLambdaKt.rememberComposableLambda(-906085472, true, new Function3() { // from class: androidx.compose.material3.TabKt$$ExternalSyntheticLambda3
                                @Override // kotlin.jvm.functions.Function3
                                public final Object invoke(Object obj, Object obj2, Object obj3) {
                                    return TabKt.Tab_wqdebIU$lambda$1(composableLambdaRememberComposableLambda, function5, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                }
                            }, composerStartRestartGroup, 54), composer2, (i10 & 14) | 12582912 | (i10 & 112) | (i10 & 7168) | (57344 & i1115) | (458752 & i1115) | (i1115 & 3670016), 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier3 = modifier2;
                            function6 = function4;
                            function7 = function5;
                            z5 = z6;
                            j3 = j6;
                            j4 = j7;
                            mutableInteractionSource2 = mutableInteractionSource3;
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
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TabKt$$ExternalSyntheticLambda4
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return TabKt.Tab_wqdebIU$lambda$2(z, function0, modifier3, z5, function6, function7, j3, j4, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                        }
                    }
                    i10 |= 100663296;
                    if ((i10 & 38347923) != 38347922) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z4, i10 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "97@4401L7");
                        if ((i & 1) != 0) {
                            if (i11 != 0) {
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
                            if ((i2 & 64) != 0) {
                                ProvidableCompositionLocal<Color> localContentColor1114 = ContentColorKt.getLocalContentColor();
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                Object objConsume1114 = composerStartRestartGroup.consume(localContentColor1114);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                jM6824unboximpl = ((Color) objConsume1114).m6824unboximpl();
                                i10 &= -3670017;
                            } else {
                                jM6824unboximpl = j;
                            }
                            if ((i2 & 128) != 0) {
                                i10 &= -29360129;
                                j5 = jM6824unboximpl;
                            } else {
                                j5 = j2;
                            }
                            z6 = z3;
                            composableLambdaRememberComposableLambda = null;
                            if (i12 != 0) {
                                j6 = jM6824unboximpl;
                                i14 = 1015017965;
                                mutableInteractionSource3 = null;
                                j7 = j5;
                            } else {
                                j6 = jM6824unboximpl;
                                j7 = j5;
                                i14 = 1015017965;
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                        } else {
                            if (i11 != 0) {
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
                            if ((i2 & 64) != 0) {
                                ProvidableCompositionLocal<Color> localContentColor1115 = ContentColorKt.getLocalContentColor();
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                Object objConsume1115 = composerStartRestartGroup.consume(localContentColor1115);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                jM6824unboximpl = ((Color) objConsume1115).m6824unboximpl();
                                i10 &= -3670017;
                            } else {
                                jM6824unboximpl = j;
                            }
                            if ((i2 & 128) != 0) {
                                i10 &= -29360129;
                                j5 = jM6824unboximpl;
                            } else {
                                j5 = j2;
                            }
                            z6 = z3;
                            composableLambdaRememberComposableLambda = null;
                            if (i12 != 0) {
                                j6 = jM6824unboximpl;
                                i14 = 1015017965;
                                mutableInteractionSource3 = null;
                                j7 = j5;
                            } else {
                                j6 = jM6824unboximpl;
                                j7 = j5;
                                i14 = 1015017965;
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(i14, i10, -1, "androidx.compose.material3.Tab (Tab.kt:100)");
                        }
                        if (function4 == null) {
                            composerStartRestartGroup.startReplaceGroup(1830887765);
                        } else {
                            composerStartRestartGroup.startReplaceGroup(1830887766);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "*103@4621L247");
                            composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-1745256900, true, new Function2() { // from class: androidx.compose.material3.TabKt$$ExternalSyntheticLambda2
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return TabKt.Tab_wqdebIU$lambda$0$0(function4, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composerStartRestartGroup, 54);
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        int i1116 = i10 >> 6;
                        composer2 = composerStartRestartGroup;
                        m4363TabbogVsAg(z, function0, BadgeKt.badgeBounds(modifier2), z6, j6, j7, mutableInteractionSource3, ComposableLambdaKt.rememberComposableLambda(-906085472, true, new Function3() { // from class: androidx.compose.material3.TabKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return TabKt.Tab_wqdebIU$lambda$1(composableLambdaRememberComposableLambda, function5, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composerStartRestartGroup, 54), composer2, (i10 & 14) | 12582912 | (i10 & 112) | (i10 & 7168) | (57344 & i1116) | (458752 & i1116) | (i1116 & 3670016), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier2;
                        function6 = function4;
                        function7 = function5;
                        z5 = z6;
                        j3 = j6;
                        j4 = j7;
                        mutableInteractionSource2 = mutableInteractionSource3;
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
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TabKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return TabKt.Tab_wqdebIU$lambda$2(z, function0, modifier3, z5, function6, function7, j3, j4, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                function5 = function3;
                if ((1572864 & i) == 0) {
                    if ((i2 & 64) == 0) {
                        i16 = i3;
                        i11 = i17;
                        if (composerStartRestartGroup.changed(j)) {
                        }
                        i10 = i16 | i18;
                    } else {
                        i16 = i3;
                        i11 = i17;
                    }
                    i10 = i16 | i18;
                } else {
                    i10 = i3;
                    i11 = i17;
                }
                if ((i & 12582912) != 0) {
                    if ((i2 & 128) == 0) {
                        i15 = 4194304;
                    } else {
                        i15 = 4194304;
                    }
                    i10 |= i15;
                }
                i12 = i2 & 256;
                if (i12 != 0) {
                    if ((i & 100663296) == 0) {
                        if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                            i13 = 67108864;
                        } else {
                            i13 = 33554432;
                        }
                        i10 |= i13;
                    }
                    if ((i10 & 38347923) != 38347922) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z4, i10 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "97@4401L7");
                        if ((i & 1) != 0) {
                            if (i11 != 0) {
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
                            if ((i2 & 64) != 0) {
                                ProvidableCompositionLocal<Color> localContentColor1116 = ContentColorKt.getLocalContentColor();
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                Object objConsume1116 = composerStartRestartGroup.consume(localContentColor1116);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                jM6824unboximpl = ((Color) objConsume1116).m6824unboximpl();
                                i10 &= -3670017;
                            } else {
                                jM6824unboximpl = j;
                            }
                            if ((i2 & 128) != 0) {
                                i10 &= -29360129;
                                j5 = jM6824unboximpl;
                            } else {
                                j5 = j2;
                            }
                            z6 = z3;
                            composableLambdaRememberComposableLambda = null;
                            if (i12 != 0) {
                                j6 = jM6824unboximpl;
                                i14 = 1015017965;
                                mutableInteractionSource3 = null;
                                j7 = j5;
                            } else {
                                j6 = jM6824unboximpl;
                                j7 = j5;
                                i14 = 1015017965;
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                        } else {
                            if (i11 != 0) {
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
                            if ((i2 & 64) != 0) {
                                ProvidableCompositionLocal<Color> localContentColor1117 = ContentColorKt.getLocalContentColor();
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                Object objConsume1117 = composerStartRestartGroup.consume(localContentColor1117);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                jM6824unboximpl = ((Color) objConsume1117).m6824unboximpl();
                                i10 &= -3670017;
                            } else {
                                jM6824unboximpl = j;
                            }
                            if ((i2 & 128) != 0) {
                                i10 &= -29360129;
                                j5 = jM6824unboximpl;
                            } else {
                                j5 = j2;
                            }
                            z6 = z3;
                            composableLambdaRememberComposableLambda = null;
                            if (i12 != 0) {
                                j6 = jM6824unboximpl;
                                i14 = 1015017965;
                                mutableInteractionSource3 = null;
                                j7 = j5;
                            } else {
                                j6 = jM6824unboximpl;
                                j7 = j5;
                                i14 = 1015017965;
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(i14, i10, -1, "androidx.compose.material3.Tab (Tab.kt:100)");
                        }
                        if (function4 == null) {
                            composerStartRestartGroup.startReplaceGroup(1830887765);
                        } else {
                            composerStartRestartGroup.startReplaceGroup(1830887766);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "*103@4621L247");
                            composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-1745256900, true, new Function2() { // from class: androidx.compose.material3.TabKt$$ExternalSyntheticLambda2
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return TabKt.Tab_wqdebIU$lambda$0$0(function4, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composerStartRestartGroup, 54);
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        int i1117 = i10 >> 6;
                        composer2 = composerStartRestartGroup;
                        m4363TabbogVsAg(z, function0, BadgeKt.badgeBounds(modifier2), z6, j6, j7, mutableInteractionSource3, ComposableLambdaKt.rememberComposableLambda(-906085472, true, new Function3() { // from class: androidx.compose.material3.TabKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return TabKt.Tab_wqdebIU$lambda$1(composableLambdaRememberComposableLambda, function5, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composerStartRestartGroup, 54), composer2, (i10 & 14) | 12582912 | (i10 & 112) | (i10 & 7168) | (57344 & i1117) | (458752 & i1117) | (i1117 & 3670016), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier2;
                        function6 = function4;
                        function7 = function5;
                        z5 = z6;
                        j3 = j6;
                        j4 = j7;
                        mutableInteractionSource2 = mutableInteractionSource3;
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
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TabKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return TabKt.Tab_wqdebIU$lambda$2(z, function0, modifier3, z5, function6, function7, j3, j4, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i10 |= 100663296;
                if ((i10 & 38347923) != 38347922) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z4, i10 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "97@4401L7");
                    if ((i & 1) != 0) {
                        if (i11 != 0) {
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
                        if ((i2 & 64) != 0) {
                            ProvidableCompositionLocal<Color> localContentColor1118 = ContentColorKt.getLocalContentColor();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                            Object objConsume1118 = composerStartRestartGroup.consume(localContentColor1118);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            jM6824unboximpl = ((Color) objConsume1118).m6824unboximpl();
                            i10 &= -3670017;
                        } else {
                            jM6824unboximpl = j;
                        }
                        if ((i2 & 128) != 0) {
                            i10 &= -29360129;
                            j5 = jM6824unboximpl;
                        } else {
                            j5 = j2;
                        }
                        z6 = z3;
                        composableLambdaRememberComposableLambda = null;
                        if (i12 != 0) {
                            j6 = jM6824unboximpl;
                            i14 = 1015017965;
                            mutableInteractionSource3 = null;
                            j7 = j5;
                        } else {
                            j6 = jM6824unboximpl;
                            j7 = j5;
                            i14 = 1015017965;
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                    } else {
                        if (i11 != 0) {
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
                        if ((i2 & 64) != 0) {
                            ProvidableCompositionLocal<Color> localContentColor1119 = ContentColorKt.getLocalContentColor();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                            Object objConsume1119 = composerStartRestartGroup.consume(localContentColor1119);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            jM6824unboximpl = ((Color) objConsume1119).m6824unboximpl();
                            i10 &= -3670017;
                        } else {
                            jM6824unboximpl = j;
                        }
                        if ((i2 & 128) != 0) {
                            i10 &= -29360129;
                            j5 = jM6824unboximpl;
                        } else {
                            j5 = j2;
                        }
                        z6 = z3;
                        composableLambdaRememberComposableLambda = null;
                        if (i12 != 0) {
                            j6 = jM6824unboximpl;
                            i14 = 1015017965;
                            mutableInteractionSource3 = null;
                            j7 = j5;
                        } else {
                            j6 = jM6824unboximpl;
                            j7 = j5;
                            i14 = 1015017965;
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(i14, i10, -1, "androidx.compose.material3.Tab (Tab.kt:100)");
                    }
                    if (function4 == null) {
                        composerStartRestartGroup.startReplaceGroup(1830887765);
                    } else {
                        composerStartRestartGroup.startReplaceGroup(1830887766);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "*103@4621L247");
                        composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-1745256900, true, new Function2() { // from class: androidx.compose.material3.TabKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return TabKt.Tab_wqdebIU$lambda$0$0(function4, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    int i1118 = i10 >> 6;
                    composer2 = composerStartRestartGroup;
                    m4363TabbogVsAg(z, function0, BadgeKt.badgeBounds(modifier2), z6, j6, j7, mutableInteractionSource3, ComposableLambdaKt.rememberComposableLambda(-906085472, true, new Function3() { // from class: androidx.compose.material3.TabKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return TabKt.Tab_wqdebIU$lambda$1(composableLambdaRememberComposableLambda, function5, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54), composer2, (i10 & 14) | 12582912 | (i10 & 112) | (i10 & 7168) | (57344 & i1118) | (458752 & i1118) | (i1118 & 3670016), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                    function6 = function4;
                    function7 = function5;
                    z5 = z6;
                    j3 = j6;
                    j4 = j7;
                    mutableInteractionSource2 = mutableInteractionSource3;
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
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TabKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return TabKt.Tab_wqdebIU$lambda$2(z, function0, modifier3, z5, function6, function7, j3, j4, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
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
                if ((1572864 & i) == 0) {
                    if ((i2 & 64) == 0) {
                        i16 = i3;
                        i11 = i17;
                        if (composerStartRestartGroup.changed(j)) {
                        }
                        i10 = i16 | i18;
                    } else {
                        i16 = i3;
                        i11 = i17;
                    }
                    i10 = i16 | i18;
                } else {
                    i10 = i3;
                    i11 = i17;
                }
                if ((i & 12582912) != 0) {
                    if ((i2 & 128) == 0) {
                        i15 = 4194304;
                    } else {
                        i15 = 4194304;
                    }
                    i10 |= i15;
                }
                i12 = i2 & 256;
                if (i12 != 0) {
                    if ((i & 100663296) == 0) {
                        if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                            i13 = 67108864;
                        } else {
                            i13 = 33554432;
                        }
                        i10 |= i13;
                    }
                    if ((i10 & 38347923) != 38347922) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z4, i10 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "97@4401L7");
                        if ((i & 1) != 0) {
                            if (i11 != 0) {
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
                            if ((i2 & 64) != 0) {
                                ProvidableCompositionLocal<Color> localContentColor11110 = ContentColorKt.getLocalContentColor();
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                Object objConsume11110 = composerStartRestartGroup.consume(localContentColor11110);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                jM6824unboximpl = ((Color) objConsume11110).m6824unboximpl();
                                i10 &= -3670017;
                            } else {
                                jM6824unboximpl = j;
                            }
                            if ((i2 & 128) != 0) {
                                i10 &= -29360129;
                                j5 = jM6824unboximpl;
                            } else {
                                j5 = j2;
                            }
                            z6 = z3;
                            composableLambdaRememberComposableLambda = null;
                            if (i12 != 0) {
                                j6 = jM6824unboximpl;
                                i14 = 1015017965;
                                mutableInteractionSource3 = null;
                                j7 = j5;
                            } else {
                                j6 = jM6824unboximpl;
                                j7 = j5;
                                i14 = 1015017965;
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                        } else {
                            if (i11 != 0) {
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
                            if ((i2 & 64) != 0) {
                                ProvidableCompositionLocal<Color> localContentColor11111 = ContentColorKt.getLocalContentColor();
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                Object objConsume11111 = composerStartRestartGroup.consume(localContentColor11111);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                jM6824unboximpl = ((Color) objConsume11111).m6824unboximpl();
                                i10 &= -3670017;
                            } else {
                                jM6824unboximpl = j;
                            }
                            if ((i2 & 128) != 0) {
                                i10 &= -29360129;
                                j5 = jM6824unboximpl;
                            } else {
                                j5 = j2;
                            }
                            z6 = z3;
                            composableLambdaRememberComposableLambda = null;
                            if (i12 != 0) {
                                j6 = jM6824unboximpl;
                                i14 = 1015017965;
                                mutableInteractionSource3 = null;
                                j7 = j5;
                            } else {
                                j6 = jM6824unboximpl;
                                j7 = j5;
                                i14 = 1015017965;
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(i14, i10, -1, "androidx.compose.material3.Tab (Tab.kt:100)");
                        }
                        if (function4 == null) {
                            composerStartRestartGroup.startReplaceGroup(1830887765);
                        } else {
                            composerStartRestartGroup.startReplaceGroup(1830887766);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "*103@4621L247");
                            composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-1745256900, true, new Function2() { // from class: androidx.compose.material3.TabKt$$ExternalSyntheticLambda2
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return TabKt.Tab_wqdebIU$lambda$0$0(function4, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composerStartRestartGroup, 54);
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        int i1119 = i10 >> 6;
                        composer2 = composerStartRestartGroup;
                        m4363TabbogVsAg(z, function0, BadgeKt.badgeBounds(modifier2), z6, j6, j7, mutableInteractionSource3, ComposableLambdaKt.rememberComposableLambda(-906085472, true, new Function3() { // from class: androidx.compose.material3.TabKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return TabKt.Tab_wqdebIU$lambda$1(composableLambdaRememberComposableLambda, function5, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composerStartRestartGroup, 54), composer2, (i10 & 14) | 12582912 | (i10 & 112) | (i10 & 7168) | (57344 & i1119) | (458752 & i1119) | (i1119 & 3670016), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier2;
                        function6 = function4;
                        function7 = function5;
                        z5 = z6;
                        j3 = j6;
                        j4 = j7;
                        mutableInteractionSource2 = mutableInteractionSource3;
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
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TabKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return TabKt.Tab_wqdebIU$lambda$2(z, function0, modifier3, z5, function6, function7, j3, j4, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i10 |= 100663296;
                if ((i10 & 38347923) != 38347922) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z4, i10 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "97@4401L7");
                    if ((i & 1) != 0) {
                        if (i11 != 0) {
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
                        if ((i2 & 64) != 0) {
                            ProvidableCompositionLocal<Color> localContentColor11112 = ContentColorKt.getLocalContentColor();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                            Object objConsume11112 = composerStartRestartGroup.consume(localContentColor11112);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            jM6824unboximpl = ((Color) objConsume11112).m6824unboximpl();
                            i10 &= -3670017;
                        } else {
                            jM6824unboximpl = j;
                        }
                        if ((i2 & 128) != 0) {
                            i10 &= -29360129;
                            j5 = jM6824unboximpl;
                        } else {
                            j5 = j2;
                        }
                        z6 = z3;
                        composableLambdaRememberComposableLambda = null;
                        if (i12 != 0) {
                            j6 = jM6824unboximpl;
                            i14 = 1015017965;
                            mutableInteractionSource3 = null;
                            j7 = j5;
                        } else {
                            j6 = jM6824unboximpl;
                            j7 = j5;
                            i14 = 1015017965;
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                    } else {
                        if (i11 != 0) {
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
                        if ((i2 & 64) != 0) {
                            ProvidableCompositionLocal<Color> localContentColor11113 = ContentColorKt.getLocalContentColor();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                            Object objConsume11113 = composerStartRestartGroup.consume(localContentColor11113);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            jM6824unboximpl = ((Color) objConsume11113).m6824unboximpl();
                            i10 &= -3670017;
                        } else {
                            jM6824unboximpl = j;
                        }
                        if ((i2 & 128) != 0) {
                            i10 &= -29360129;
                            j5 = jM6824unboximpl;
                        } else {
                            j5 = j2;
                        }
                        z6 = z3;
                        composableLambdaRememberComposableLambda = null;
                        if (i12 != 0) {
                            j6 = jM6824unboximpl;
                            i14 = 1015017965;
                            mutableInteractionSource3 = null;
                            j7 = j5;
                        } else {
                            j6 = jM6824unboximpl;
                            j7 = j5;
                            i14 = 1015017965;
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(i14, i10, -1, "androidx.compose.material3.Tab (Tab.kt:100)");
                    }
                    if (function4 == null) {
                        composerStartRestartGroup.startReplaceGroup(1830887765);
                    } else {
                        composerStartRestartGroup.startReplaceGroup(1830887766);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "*103@4621L247");
                        composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-1745256900, true, new Function2() { // from class: androidx.compose.material3.TabKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return TabKt.Tab_wqdebIU$lambda$0$0(function4, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    int i11110 = i10 >> 6;
                    composer2 = composerStartRestartGroup;
                    m4363TabbogVsAg(z, function0, BadgeKt.badgeBounds(modifier2), z6, j6, j7, mutableInteractionSource3, ComposableLambdaKt.rememberComposableLambda(-906085472, true, new Function3() { // from class: androidx.compose.material3.TabKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return TabKt.Tab_wqdebIU$lambda$1(composableLambdaRememberComposableLambda, function5, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54), composer2, (i10 & 14) | 12582912 | (i10 & 112) | (i10 & 7168) | (57344 & i11110) | (458752 & i11110) | (i11110 & 3670016), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                    function6 = function4;
                    function7 = function5;
                    z5 = z6;
                    j3 = j6;
                    j4 = j7;
                    mutableInteractionSource2 = mutableInteractionSource3;
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
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TabKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return TabKt.Tab_wqdebIU$lambda$2(z, function0, modifier3, z5, function6, function7, j3, j4, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            function5 = function3;
            if ((1572864 & i) == 0) {
                if ((i2 & 64) == 0) {
                    i16 = i3;
                    i11 = i17;
                    if (composerStartRestartGroup.changed(j)) {
                    }
                    i10 = i16 | i18;
                } else {
                    i16 = i3;
                    i11 = i17;
                }
                i10 = i16 | i18;
            } else {
                i10 = i3;
                i11 = i17;
            }
            if ((i & 12582912) != 0) {
                if ((i2 & 128) == 0) {
                    i15 = 4194304;
                } else {
                    i15 = 4194304;
                }
                i10 |= i15;
            }
            i12 = i2 & 256;
            if (i12 != 0) {
                if ((i & 100663296) == 0) {
                    if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                        i13 = 67108864;
                    } else {
                        i13 = 33554432;
                    }
                    i10 |= i13;
                }
                if ((i10 & 38347923) != 38347922) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z4, i10 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "97@4401L7");
                    if ((i & 1) != 0) {
                        if (i11 != 0) {
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
                        if ((i2 & 64) != 0) {
                            ProvidableCompositionLocal<Color> localContentColor11114 = ContentColorKt.getLocalContentColor();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                            Object objConsume11114 = composerStartRestartGroup.consume(localContentColor11114);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            jM6824unboximpl = ((Color) objConsume11114).m6824unboximpl();
                            i10 &= -3670017;
                        } else {
                            jM6824unboximpl = j;
                        }
                        if ((i2 & 128) != 0) {
                            i10 &= -29360129;
                            j5 = jM6824unboximpl;
                        } else {
                            j5 = j2;
                        }
                        z6 = z3;
                        composableLambdaRememberComposableLambda = null;
                        if (i12 != 0) {
                            j6 = jM6824unboximpl;
                            i14 = 1015017965;
                            mutableInteractionSource3 = null;
                            j7 = j5;
                        } else {
                            j6 = jM6824unboximpl;
                            j7 = j5;
                            i14 = 1015017965;
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                    } else {
                        if (i11 != 0) {
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
                        if ((i2 & 64) != 0) {
                            ProvidableCompositionLocal<Color> localContentColor11115 = ContentColorKt.getLocalContentColor();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                            Object objConsume11115 = composerStartRestartGroup.consume(localContentColor11115);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            jM6824unboximpl = ((Color) objConsume11115).m6824unboximpl();
                            i10 &= -3670017;
                        } else {
                            jM6824unboximpl = j;
                        }
                        if ((i2 & 128) != 0) {
                            i10 &= -29360129;
                            j5 = jM6824unboximpl;
                        } else {
                            j5 = j2;
                        }
                        z6 = z3;
                        composableLambdaRememberComposableLambda = null;
                        if (i12 != 0) {
                            j6 = jM6824unboximpl;
                            i14 = 1015017965;
                            mutableInteractionSource3 = null;
                            j7 = j5;
                        } else {
                            j6 = jM6824unboximpl;
                            j7 = j5;
                            i14 = 1015017965;
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(i14, i10, -1, "androidx.compose.material3.Tab (Tab.kt:100)");
                    }
                    if (function4 == null) {
                        composerStartRestartGroup.startReplaceGroup(1830887765);
                    } else {
                        composerStartRestartGroup.startReplaceGroup(1830887766);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "*103@4621L247");
                        composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-1745256900, true, new Function2() { // from class: androidx.compose.material3.TabKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return TabKt.Tab_wqdebIU$lambda$0$0(function4, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    int i11111 = i10 >> 6;
                    composer2 = composerStartRestartGroup;
                    m4363TabbogVsAg(z, function0, BadgeKt.badgeBounds(modifier2), z6, j6, j7, mutableInteractionSource3, ComposableLambdaKt.rememberComposableLambda(-906085472, true, new Function3() { // from class: androidx.compose.material3.TabKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return TabKt.Tab_wqdebIU$lambda$1(composableLambdaRememberComposableLambda, function5, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54), composer2, (i10 & 14) | 12582912 | (i10 & 112) | (i10 & 7168) | (57344 & i11111) | (458752 & i11111) | (i11111 & 3670016), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                    function6 = function4;
                    function7 = function5;
                    z5 = z6;
                    j3 = j6;
                    j4 = j7;
                    mutableInteractionSource2 = mutableInteractionSource3;
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
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TabKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return TabKt.Tab_wqdebIU$lambda$2(z, function0, modifier3, z5, function6, function7, j3, j4, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i10 |= 100663296;
            if ((i10 & 38347923) != 38347922) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z4, i10 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "97@4401L7");
                if ((i & 1) != 0) {
                    if (i11 != 0) {
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
                    if ((i2 & 64) != 0) {
                        ProvidableCompositionLocal<Color> localContentColor11116 = ContentColorKt.getLocalContentColor();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object objConsume11116 = composerStartRestartGroup.consume(localContentColor11116);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        jM6824unboximpl = ((Color) objConsume11116).m6824unboximpl();
                        i10 &= -3670017;
                    } else {
                        jM6824unboximpl = j;
                    }
                    if ((i2 & 128) != 0) {
                        i10 &= -29360129;
                        j5 = jM6824unboximpl;
                    } else {
                        j5 = j2;
                    }
                    z6 = z3;
                    composableLambdaRememberComposableLambda = null;
                    if (i12 != 0) {
                        j6 = jM6824unboximpl;
                        i14 = 1015017965;
                        mutableInteractionSource3 = null;
                        j7 = j5;
                    } else {
                        j6 = jM6824unboximpl;
                        j7 = j5;
                        i14 = 1015017965;
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                } else {
                    if (i11 != 0) {
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
                    if ((i2 & 64) != 0) {
                        ProvidableCompositionLocal<Color> localContentColor11117 = ContentColorKt.getLocalContentColor();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object objConsume11117 = composerStartRestartGroup.consume(localContentColor11117);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        jM6824unboximpl = ((Color) objConsume11117).m6824unboximpl();
                        i10 &= -3670017;
                    } else {
                        jM6824unboximpl = j;
                    }
                    if ((i2 & 128) != 0) {
                        i10 &= -29360129;
                        j5 = jM6824unboximpl;
                    } else {
                        j5 = j2;
                    }
                    z6 = z3;
                    composableLambdaRememberComposableLambda = null;
                    if (i12 != 0) {
                        j6 = jM6824unboximpl;
                        i14 = 1015017965;
                        mutableInteractionSource3 = null;
                        j7 = j5;
                    } else {
                        j6 = jM6824unboximpl;
                        j7 = j5;
                        i14 = 1015017965;
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(i14, i10, -1, "androidx.compose.material3.Tab (Tab.kt:100)");
                }
                if (function4 == null) {
                    composerStartRestartGroup.startReplaceGroup(1830887765);
                } else {
                    composerStartRestartGroup.startReplaceGroup(1830887766);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "*103@4621L247");
                    composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-1745256900, true, new Function2() { // from class: androidx.compose.material3.TabKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return TabKt.Tab_wqdebIU$lambda$0$0(function4, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54);
                }
                composerStartRestartGroup.endReplaceGroup();
                int i11112 = i10 >> 6;
                composer2 = composerStartRestartGroup;
                m4363TabbogVsAg(z, function0, BadgeKt.badgeBounds(modifier2), z6, j6, j7, mutableInteractionSource3, ComposableLambdaKt.rememberComposableLambda(-906085472, true, new Function3() { // from class: androidx.compose.material3.TabKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return TabKt.Tab_wqdebIU$lambda$1(composableLambdaRememberComposableLambda, function5, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), composer2, (i10 & 14) | 12582912 | (i10 & 112) | (i10 & 7168) | (57344 & i11112) | (458752 & i11112) | (i11112 & 3670016), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier2;
                function6 = function4;
                function7 = function5;
                z5 = z6;
                j3 = j6;
                j4 = j7;
                mutableInteractionSource2 = mutableInteractionSource3;
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
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TabKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return TabKt.Tab_wqdebIU$lambda$2(z, function0, modifier3, z5, function6, function7, j3, j4, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
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
                if ((1572864 & i) == 0) {
                    if ((i2 & 64) == 0) {
                        i16 = i3;
                        i11 = i17;
                        if (composerStartRestartGroup.changed(j)) {
                        }
                        i10 = i16 | i18;
                    } else {
                        i16 = i3;
                        i11 = i17;
                    }
                    i10 = i16 | i18;
                } else {
                    i10 = i3;
                    i11 = i17;
                }
                if ((i & 12582912) != 0) {
                    if ((i2 & 128) == 0) {
                        i15 = 4194304;
                    } else {
                        i15 = 4194304;
                    }
                    i10 |= i15;
                }
                i12 = i2 & 256;
                if (i12 != 0) {
                    if ((i & 100663296) == 0) {
                        if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                            i13 = 67108864;
                        } else {
                            i13 = 33554432;
                        }
                        i10 |= i13;
                    }
                    if ((i10 & 38347923) != 38347922) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z4, i10 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "97@4401L7");
                        if ((i & 1) != 0) {
                            if (i11 != 0) {
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
                            if ((i2 & 64) != 0) {
                                ProvidableCompositionLocal<Color> localContentColor11118 = ContentColorKt.getLocalContentColor();
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                Object objConsume11118 = composerStartRestartGroup.consume(localContentColor11118);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                jM6824unboximpl = ((Color) objConsume11118).m6824unboximpl();
                                i10 &= -3670017;
                            } else {
                                jM6824unboximpl = j;
                            }
                            if ((i2 & 128) != 0) {
                                i10 &= -29360129;
                                j5 = jM6824unboximpl;
                            } else {
                                j5 = j2;
                            }
                            z6 = z3;
                            composableLambdaRememberComposableLambda = null;
                            if (i12 != 0) {
                                j6 = jM6824unboximpl;
                                i14 = 1015017965;
                                mutableInteractionSource3 = null;
                                j7 = j5;
                            } else {
                                j6 = jM6824unboximpl;
                                j7 = j5;
                                i14 = 1015017965;
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                        } else {
                            if (i11 != 0) {
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
                            if ((i2 & 64) != 0) {
                                ProvidableCompositionLocal<Color> localContentColor11119 = ContentColorKt.getLocalContentColor();
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                Object objConsume11119 = composerStartRestartGroup.consume(localContentColor11119);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                jM6824unboximpl = ((Color) objConsume11119).m6824unboximpl();
                                i10 &= -3670017;
                            } else {
                                jM6824unboximpl = j;
                            }
                            if ((i2 & 128) != 0) {
                                i10 &= -29360129;
                                j5 = jM6824unboximpl;
                            } else {
                                j5 = j2;
                            }
                            z6 = z3;
                            composableLambdaRememberComposableLambda = null;
                            if (i12 != 0) {
                                j6 = jM6824unboximpl;
                                i14 = 1015017965;
                                mutableInteractionSource3 = null;
                                j7 = j5;
                            } else {
                                j6 = jM6824unboximpl;
                                j7 = j5;
                                i14 = 1015017965;
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(i14, i10, -1, "androidx.compose.material3.Tab (Tab.kt:100)");
                        }
                        if (function4 == null) {
                            composerStartRestartGroup.startReplaceGroup(1830887765);
                        } else {
                            composerStartRestartGroup.startReplaceGroup(1830887766);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "*103@4621L247");
                            composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-1745256900, true, new Function2() { // from class: androidx.compose.material3.TabKt$$ExternalSyntheticLambda2
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return TabKt.Tab_wqdebIU$lambda$0$0(function4, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composerStartRestartGroup, 54);
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        int i11113 = i10 >> 6;
                        composer2 = composerStartRestartGroup;
                        m4363TabbogVsAg(z, function0, BadgeKt.badgeBounds(modifier2), z6, j6, j7, mutableInteractionSource3, ComposableLambdaKt.rememberComposableLambda(-906085472, true, new Function3() { // from class: androidx.compose.material3.TabKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return TabKt.Tab_wqdebIU$lambda$1(composableLambdaRememberComposableLambda, function5, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composerStartRestartGroup, 54), composer2, (i10 & 14) | 12582912 | (i10 & 112) | (i10 & 7168) | (57344 & i11113) | (458752 & i11113) | (i11113 & 3670016), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier2;
                        function6 = function4;
                        function7 = function5;
                        z5 = z6;
                        j3 = j6;
                        j4 = j7;
                        mutableInteractionSource2 = mutableInteractionSource3;
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
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TabKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return TabKt.Tab_wqdebIU$lambda$2(z, function0, modifier3, z5, function6, function7, j3, j4, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i10 |= 100663296;
                if ((i10 & 38347923) != 38347922) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z4, i10 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "97@4401L7");
                    if ((i & 1) != 0) {
                        if (i11 != 0) {
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
                        if ((i2 & 64) != 0) {
                            ProvidableCompositionLocal<Color> localContentColor111110 = ContentColorKt.getLocalContentColor();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                            Object objConsume111110 = composerStartRestartGroup.consume(localContentColor111110);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            jM6824unboximpl = ((Color) objConsume111110).m6824unboximpl();
                            i10 &= -3670017;
                        } else {
                            jM6824unboximpl = j;
                        }
                        if ((i2 & 128) != 0) {
                            i10 &= -29360129;
                            j5 = jM6824unboximpl;
                        } else {
                            j5 = j2;
                        }
                        z6 = z3;
                        composableLambdaRememberComposableLambda = null;
                        if (i12 != 0) {
                            j6 = jM6824unboximpl;
                            i14 = 1015017965;
                            mutableInteractionSource3 = null;
                            j7 = j5;
                        } else {
                            j6 = jM6824unboximpl;
                            j7 = j5;
                            i14 = 1015017965;
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                    } else {
                        if (i11 != 0) {
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
                        if ((i2 & 64) != 0) {
                            ProvidableCompositionLocal<Color> localContentColor111111 = ContentColorKt.getLocalContentColor();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                            Object objConsume111111 = composerStartRestartGroup.consume(localContentColor111111);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            jM6824unboximpl = ((Color) objConsume111111).m6824unboximpl();
                            i10 &= -3670017;
                        } else {
                            jM6824unboximpl = j;
                        }
                        if ((i2 & 128) != 0) {
                            i10 &= -29360129;
                            j5 = jM6824unboximpl;
                        } else {
                            j5 = j2;
                        }
                        z6 = z3;
                        composableLambdaRememberComposableLambda = null;
                        if (i12 != 0) {
                            j6 = jM6824unboximpl;
                            i14 = 1015017965;
                            mutableInteractionSource3 = null;
                            j7 = j5;
                        } else {
                            j6 = jM6824unboximpl;
                            j7 = j5;
                            i14 = 1015017965;
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(i14, i10, -1, "androidx.compose.material3.Tab (Tab.kt:100)");
                    }
                    if (function4 == null) {
                        composerStartRestartGroup.startReplaceGroup(1830887765);
                    } else {
                        composerStartRestartGroup.startReplaceGroup(1830887766);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "*103@4621L247");
                        composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-1745256900, true, new Function2() { // from class: androidx.compose.material3.TabKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return TabKt.Tab_wqdebIU$lambda$0$0(function4, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    int i11114 = i10 >> 6;
                    composer2 = composerStartRestartGroup;
                    m4363TabbogVsAg(z, function0, BadgeKt.badgeBounds(modifier2), z6, j6, j7, mutableInteractionSource3, ComposableLambdaKt.rememberComposableLambda(-906085472, true, new Function3() { // from class: androidx.compose.material3.TabKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return TabKt.Tab_wqdebIU$lambda$1(composableLambdaRememberComposableLambda, function5, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54), composer2, (i10 & 14) | 12582912 | (i10 & 112) | (i10 & 7168) | (57344 & i11114) | (458752 & i11114) | (i11114 & 3670016), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                    function6 = function4;
                    function7 = function5;
                    z5 = z6;
                    j3 = j6;
                    j4 = j7;
                    mutableInteractionSource2 = mutableInteractionSource3;
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
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TabKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return TabKt.Tab_wqdebIU$lambda$2(z, function0, modifier3, z5, function6, function7, j3, j4, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            function5 = function3;
            if ((1572864 & i) == 0) {
                if ((i2 & 64) == 0) {
                    i16 = i3;
                    i11 = i17;
                    if (composerStartRestartGroup.changed(j)) {
                    }
                    i10 = i16 | i18;
                } else {
                    i16 = i3;
                    i11 = i17;
                }
                i10 = i16 | i18;
            } else {
                i10 = i3;
                i11 = i17;
            }
            if ((i & 12582912) != 0) {
                if ((i2 & 128) == 0) {
                    i15 = 4194304;
                } else {
                    i15 = 4194304;
                }
                i10 |= i15;
            }
            i12 = i2 & 256;
            if (i12 != 0) {
                if ((i & 100663296) == 0) {
                    if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                        i13 = 67108864;
                    } else {
                        i13 = 33554432;
                    }
                    i10 |= i13;
                }
                if ((i10 & 38347923) != 38347922) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z4, i10 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "97@4401L7");
                    if ((i & 1) != 0) {
                        if (i11 != 0) {
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
                        if ((i2 & 64) != 0) {
                            ProvidableCompositionLocal<Color> localContentColor111112 = ContentColorKt.getLocalContentColor();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                            Object objConsume111112 = composerStartRestartGroup.consume(localContentColor111112);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            jM6824unboximpl = ((Color) objConsume111112).m6824unboximpl();
                            i10 &= -3670017;
                        } else {
                            jM6824unboximpl = j;
                        }
                        if ((i2 & 128) != 0) {
                            i10 &= -29360129;
                            j5 = jM6824unboximpl;
                        } else {
                            j5 = j2;
                        }
                        z6 = z3;
                        composableLambdaRememberComposableLambda = null;
                        if (i12 != 0) {
                            j6 = jM6824unboximpl;
                            i14 = 1015017965;
                            mutableInteractionSource3 = null;
                            j7 = j5;
                        } else {
                            j6 = jM6824unboximpl;
                            j7 = j5;
                            i14 = 1015017965;
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                    } else {
                        if (i11 != 0) {
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
                        if ((i2 & 64) != 0) {
                            ProvidableCompositionLocal<Color> localContentColor111113 = ContentColorKt.getLocalContentColor();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                            Object objConsume111113 = composerStartRestartGroup.consume(localContentColor111113);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            jM6824unboximpl = ((Color) objConsume111113).m6824unboximpl();
                            i10 &= -3670017;
                        } else {
                            jM6824unboximpl = j;
                        }
                        if ((i2 & 128) != 0) {
                            i10 &= -29360129;
                            j5 = jM6824unboximpl;
                        } else {
                            j5 = j2;
                        }
                        z6 = z3;
                        composableLambdaRememberComposableLambda = null;
                        if (i12 != 0) {
                            j6 = jM6824unboximpl;
                            i14 = 1015017965;
                            mutableInteractionSource3 = null;
                            j7 = j5;
                        } else {
                            j6 = jM6824unboximpl;
                            j7 = j5;
                            i14 = 1015017965;
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(i14, i10, -1, "androidx.compose.material3.Tab (Tab.kt:100)");
                    }
                    if (function4 == null) {
                        composerStartRestartGroup.startReplaceGroup(1830887765);
                    } else {
                        composerStartRestartGroup.startReplaceGroup(1830887766);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "*103@4621L247");
                        composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-1745256900, true, new Function2() { // from class: androidx.compose.material3.TabKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return TabKt.Tab_wqdebIU$lambda$0$0(function4, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    int i11115 = i10 >> 6;
                    composer2 = composerStartRestartGroup;
                    m4363TabbogVsAg(z, function0, BadgeKt.badgeBounds(modifier2), z6, j6, j7, mutableInteractionSource3, ComposableLambdaKt.rememberComposableLambda(-906085472, true, new Function3() { // from class: androidx.compose.material3.TabKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return TabKt.Tab_wqdebIU$lambda$1(composableLambdaRememberComposableLambda, function5, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54), composer2, (i10 & 14) | 12582912 | (i10 & 112) | (i10 & 7168) | (57344 & i11115) | (458752 & i11115) | (i11115 & 3670016), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                    function6 = function4;
                    function7 = function5;
                    z5 = z6;
                    j3 = j6;
                    j4 = j7;
                    mutableInteractionSource2 = mutableInteractionSource3;
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
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TabKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return TabKt.Tab_wqdebIU$lambda$2(z, function0, modifier3, z5, function6, function7, j3, j4, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i10 |= 100663296;
            if ((i10 & 38347923) != 38347922) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z4, i10 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "97@4401L7");
                if ((i & 1) != 0) {
                    if (i11 != 0) {
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
                    if ((i2 & 64) != 0) {
                        ProvidableCompositionLocal<Color> localContentColor111114 = ContentColorKt.getLocalContentColor();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object objConsume111114 = composerStartRestartGroup.consume(localContentColor111114);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        jM6824unboximpl = ((Color) objConsume111114).m6824unboximpl();
                        i10 &= -3670017;
                    } else {
                        jM6824unboximpl = j;
                    }
                    if ((i2 & 128) != 0) {
                        i10 &= -29360129;
                        j5 = jM6824unboximpl;
                    } else {
                        j5 = j2;
                    }
                    z6 = z3;
                    composableLambdaRememberComposableLambda = null;
                    if (i12 != 0) {
                        j6 = jM6824unboximpl;
                        i14 = 1015017965;
                        mutableInteractionSource3 = null;
                        j7 = j5;
                    } else {
                        j6 = jM6824unboximpl;
                        j7 = j5;
                        i14 = 1015017965;
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                } else {
                    if (i11 != 0) {
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
                    if ((i2 & 64) != 0) {
                        ProvidableCompositionLocal<Color> localContentColor111115 = ContentColorKt.getLocalContentColor();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object objConsume111115 = composerStartRestartGroup.consume(localContentColor111115);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        jM6824unboximpl = ((Color) objConsume111115).m6824unboximpl();
                        i10 &= -3670017;
                    } else {
                        jM6824unboximpl = j;
                    }
                    if ((i2 & 128) != 0) {
                        i10 &= -29360129;
                        j5 = jM6824unboximpl;
                    } else {
                        j5 = j2;
                    }
                    z6 = z3;
                    composableLambdaRememberComposableLambda = null;
                    if (i12 != 0) {
                        j6 = jM6824unboximpl;
                        i14 = 1015017965;
                        mutableInteractionSource3 = null;
                        j7 = j5;
                    } else {
                        j6 = jM6824unboximpl;
                        j7 = j5;
                        i14 = 1015017965;
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(i14, i10, -1, "androidx.compose.material3.Tab (Tab.kt:100)");
                }
                if (function4 == null) {
                    composerStartRestartGroup.startReplaceGroup(1830887765);
                } else {
                    composerStartRestartGroup.startReplaceGroup(1830887766);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "*103@4621L247");
                    composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-1745256900, true, new Function2() { // from class: androidx.compose.material3.TabKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return TabKt.Tab_wqdebIU$lambda$0$0(function4, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54);
                }
                composerStartRestartGroup.endReplaceGroup();
                int i11116 = i10 >> 6;
                composer2 = composerStartRestartGroup;
                m4363TabbogVsAg(z, function0, BadgeKt.badgeBounds(modifier2), z6, j6, j7, mutableInteractionSource3, ComposableLambdaKt.rememberComposableLambda(-906085472, true, new Function3() { // from class: androidx.compose.material3.TabKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return TabKt.Tab_wqdebIU$lambda$1(composableLambdaRememberComposableLambda, function5, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), composer2, (i10 & 14) | 12582912 | (i10 & 112) | (i10 & 7168) | (57344 & i11116) | (458752 & i11116) | (i11116 & 3670016), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier2;
                function6 = function4;
                function7 = function5;
                z5 = z6;
                j3 = j6;
                j4 = j7;
                mutableInteractionSource2 = mutableInteractionSource3;
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
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TabKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return TabKt.Tab_wqdebIU$lambda$2(z, function0, modifier3, z5, function6, function7, j3, j4, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
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
            if ((1572864 & i) == 0) {
                if ((i2 & 64) == 0) {
                    i16 = i3;
                    i11 = i17;
                    if (composerStartRestartGroup.changed(j)) {
                    }
                    i10 = i16 | i18;
                } else {
                    i16 = i3;
                    i11 = i17;
                }
                i10 = i16 | i18;
            } else {
                i10 = i3;
                i11 = i17;
            }
            if ((i & 12582912) != 0) {
                if ((i2 & 128) == 0) {
                    i15 = 4194304;
                } else {
                    i15 = 4194304;
                }
                i10 |= i15;
            }
            i12 = i2 & 256;
            if (i12 != 0) {
                if ((i & 100663296) == 0) {
                    if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                        i13 = 67108864;
                    } else {
                        i13 = 33554432;
                    }
                    i10 |= i13;
                }
                if ((i10 & 38347923) != 38347922) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z4, i10 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "97@4401L7");
                    if ((i & 1) != 0) {
                        if (i11 != 0) {
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
                        if ((i2 & 64) != 0) {
                            ProvidableCompositionLocal<Color> localContentColor111116 = ContentColorKt.getLocalContentColor();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                            Object objConsume111116 = composerStartRestartGroup.consume(localContentColor111116);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            jM6824unboximpl = ((Color) objConsume111116).m6824unboximpl();
                            i10 &= -3670017;
                        } else {
                            jM6824unboximpl = j;
                        }
                        if ((i2 & 128) != 0) {
                            i10 &= -29360129;
                            j5 = jM6824unboximpl;
                        } else {
                            j5 = j2;
                        }
                        z6 = z3;
                        composableLambdaRememberComposableLambda = null;
                        if (i12 != 0) {
                            j6 = jM6824unboximpl;
                            i14 = 1015017965;
                            mutableInteractionSource3 = null;
                            j7 = j5;
                        } else {
                            j6 = jM6824unboximpl;
                            j7 = j5;
                            i14 = 1015017965;
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                    } else {
                        if (i11 != 0) {
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
                        if ((i2 & 64) != 0) {
                            ProvidableCompositionLocal<Color> localContentColor111117 = ContentColorKt.getLocalContentColor();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                            Object objConsume111117 = composerStartRestartGroup.consume(localContentColor111117);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            jM6824unboximpl = ((Color) objConsume111117).m6824unboximpl();
                            i10 &= -3670017;
                        } else {
                            jM6824unboximpl = j;
                        }
                        if ((i2 & 128) != 0) {
                            i10 &= -29360129;
                            j5 = jM6824unboximpl;
                        } else {
                            j5 = j2;
                        }
                        z6 = z3;
                        composableLambdaRememberComposableLambda = null;
                        if (i12 != 0) {
                            j6 = jM6824unboximpl;
                            i14 = 1015017965;
                            mutableInteractionSource3 = null;
                            j7 = j5;
                        } else {
                            j6 = jM6824unboximpl;
                            j7 = j5;
                            i14 = 1015017965;
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(i14, i10, -1, "androidx.compose.material3.Tab (Tab.kt:100)");
                    }
                    if (function4 == null) {
                        composerStartRestartGroup.startReplaceGroup(1830887765);
                    } else {
                        composerStartRestartGroup.startReplaceGroup(1830887766);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "*103@4621L247");
                        composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-1745256900, true, new Function2() { // from class: androidx.compose.material3.TabKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return TabKt.Tab_wqdebIU$lambda$0$0(function4, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    int i11117 = i10 >> 6;
                    composer2 = composerStartRestartGroup;
                    m4363TabbogVsAg(z, function0, BadgeKt.badgeBounds(modifier2), z6, j6, j7, mutableInteractionSource3, ComposableLambdaKt.rememberComposableLambda(-906085472, true, new Function3() { // from class: androidx.compose.material3.TabKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return TabKt.Tab_wqdebIU$lambda$1(composableLambdaRememberComposableLambda, function5, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54), composer2, (i10 & 14) | 12582912 | (i10 & 112) | (i10 & 7168) | (57344 & i11117) | (458752 & i11117) | (i11117 & 3670016), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                    function6 = function4;
                    function7 = function5;
                    z5 = z6;
                    j3 = j6;
                    j4 = j7;
                    mutableInteractionSource2 = mutableInteractionSource3;
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
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TabKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return TabKt.Tab_wqdebIU$lambda$2(z, function0, modifier3, z5, function6, function7, j3, j4, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i10 |= 100663296;
            if ((i10 & 38347923) != 38347922) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z4, i10 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "97@4401L7");
                if ((i & 1) != 0) {
                    if (i11 != 0) {
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
                    if ((i2 & 64) != 0) {
                        ProvidableCompositionLocal<Color> localContentColor111118 = ContentColorKt.getLocalContentColor();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object objConsume111118 = composerStartRestartGroup.consume(localContentColor111118);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        jM6824unboximpl = ((Color) objConsume111118).m6824unboximpl();
                        i10 &= -3670017;
                    } else {
                        jM6824unboximpl = j;
                    }
                    if ((i2 & 128) != 0) {
                        i10 &= -29360129;
                        j5 = jM6824unboximpl;
                    } else {
                        j5 = j2;
                    }
                    z6 = z3;
                    composableLambdaRememberComposableLambda = null;
                    if (i12 != 0) {
                        j6 = jM6824unboximpl;
                        i14 = 1015017965;
                        mutableInteractionSource3 = null;
                        j7 = j5;
                    } else {
                        j6 = jM6824unboximpl;
                        j7 = j5;
                        i14 = 1015017965;
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                } else {
                    if (i11 != 0) {
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
                    if ((i2 & 64) != 0) {
                        ProvidableCompositionLocal<Color> localContentColor111119 = ContentColorKt.getLocalContentColor();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object objConsume111119 = composerStartRestartGroup.consume(localContentColor111119);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        jM6824unboximpl = ((Color) objConsume111119).m6824unboximpl();
                        i10 &= -3670017;
                    } else {
                        jM6824unboximpl = j;
                    }
                    if ((i2 & 128) != 0) {
                        i10 &= -29360129;
                        j5 = jM6824unboximpl;
                    } else {
                        j5 = j2;
                    }
                    z6 = z3;
                    composableLambdaRememberComposableLambda = null;
                    if (i12 != 0) {
                        j6 = jM6824unboximpl;
                        i14 = 1015017965;
                        mutableInteractionSource3 = null;
                        j7 = j5;
                    } else {
                        j6 = jM6824unboximpl;
                        j7 = j5;
                        i14 = 1015017965;
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(i14, i10, -1, "androidx.compose.material3.Tab (Tab.kt:100)");
                }
                if (function4 == null) {
                    composerStartRestartGroup.startReplaceGroup(1830887765);
                } else {
                    composerStartRestartGroup.startReplaceGroup(1830887766);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "*103@4621L247");
                    composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-1745256900, true, new Function2() { // from class: androidx.compose.material3.TabKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return TabKt.Tab_wqdebIU$lambda$0$0(function4, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54);
                }
                composerStartRestartGroup.endReplaceGroup();
                int i11118 = i10 >> 6;
                composer2 = composerStartRestartGroup;
                m4363TabbogVsAg(z, function0, BadgeKt.badgeBounds(modifier2), z6, j6, j7, mutableInteractionSource3, ComposableLambdaKt.rememberComposableLambda(-906085472, true, new Function3() { // from class: androidx.compose.material3.TabKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return TabKt.Tab_wqdebIU$lambda$1(composableLambdaRememberComposableLambda, function5, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), composer2, (i10 & 14) | 12582912 | (i10 & 112) | (i10 & 7168) | (57344 & i11118) | (458752 & i11118) | (i11118 & 3670016), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier2;
                function6 = function4;
                function7 = function5;
                z5 = z6;
                j3 = j6;
                j4 = j7;
                mutableInteractionSource2 = mutableInteractionSource3;
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
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TabKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return TabKt.Tab_wqdebIU$lambda$2(z, function0, modifier3, z5, function6, function7, j3, j4, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        function5 = function3;
        if ((1572864 & i) == 0) {
            if ((i2 & 64) == 0) {
                i16 = i3;
                i11 = i17;
                if (composerStartRestartGroup.changed(j)) {
                }
                i10 = i16 | i18;
            } else {
                i16 = i3;
                i11 = i17;
            }
            i10 = i16 | i18;
        } else {
            i10 = i3;
            i11 = i17;
        }
        if ((i & 12582912) != 0) {
            if ((i2 & 128) == 0) {
                i15 = 4194304;
            } else {
                i15 = 4194304;
            }
            i10 |= i15;
        }
        i12 = i2 & 256;
        if (i12 != 0) {
            if ((i & 100663296) == 0) {
                if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                    i13 = 67108864;
                } else {
                    i13 = 33554432;
                }
                i10 |= i13;
            }
            if ((i10 & 38347923) != 38347922) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z4, i10 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "97@4401L7");
                if ((i & 1) != 0) {
                    if (i11 != 0) {
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
                    if ((i2 & 64) != 0) {
                        ProvidableCompositionLocal<Color> localContentColor1111110 = ContentColorKt.getLocalContentColor();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object objConsume1111110 = composerStartRestartGroup.consume(localContentColor1111110);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        jM6824unboximpl = ((Color) objConsume1111110).m6824unboximpl();
                        i10 &= -3670017;
                    } else {
                        jM6824unboximpl = j;
                    }
                    if ((i2 & 128) != 0) {
                        i10 &= -29360129;
                        j5 = jM6824unboximpl;
                    } else {
                        j5 = j2;
                    }
                    z6 = z3;
                    composableLambdaRememberComposableLambda = null;
                    if (i12 != 0) {
                        j6 = jM6824unboximpl;
                        i14 = 1015017965;
                        mutableInteractionSource3 = null;
                        j7 = j5;
                    } else {
                        j6 = jM6824unboximpl;
                        j7 = j5;
                        i14 = 1015017965;
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                } else {
                    if (i11 != 0) {
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
                    if ((i2 & 64) != 0) {
                        ProvidableCompositionLocal<Color> localContentColor1111111 = ContentColorKt.getLocalContentColor();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object objConsume1111111 = composerStartRestartGroup.consume(localContentColor1111111);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        jM6824unboximpl = ((Color) objConsume1111111).m6824unboximpl();
                        i10 &= -3670017;
                    } else {
                        jM6824unboximpl = j;
                    }
                    if ((i2 & 128) != 0) {
                        i10 &= -29360129;
                        j5 = jM6824unboximpl;
                    } else {
                        j5 = j2;
                    }
                    z6 = z3;
                    composableLambdaRememberComposableLambda = null;
                    if (i12 != 0) {
                        j6 = jM6824unboximpl;
                        i14 = 1015017965;
                        mutableInteractionSource3 = null;
                        j7 = j5;
                    } else {
                        j6 = jM6824unboximpl;
                        j7 = j5;
                        i14 = 1015017965;
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(i14, i10, -1, "androidx.compose.material3.Tab (Tab.kt:100)");
                }
                if (function4 == null) {
                    composerStartRestartGroup.startReplaceGroup(1830887765);
                } else {
                    composerStartRestartGroup.startReplaceGroup(1830887766);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "*103@4621L247");
                    composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-1745256900, true, new Function2() { // from class: androidx.compose.material3.TabKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return TabKt.Tab_wqdebIU$lambda$0$0(function4, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54);
                }
                composerStartRestartGroup.endReplaceGroup();
                int i11119 = i10 >> 6;
                composer2 = composerStartRestartGroup;
                m4363TabbogVsAg(z, function0, BadgeKt.badgeBounds(modifier2), z6, j6, j7, mutableInteractionSource3, ComposableLambdaKt.rememberComposableLambda(-906085472, true, new Function3() { // from class: androidx.compose.material3.TabKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return TabKt.Tab_wqdebIU$lambda$1(composableLambdaRememberComposableLambda, function5, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), composer2, (i10 & 14) | 12582912 | (i10 & 112) | (i10 & 7168) | (57344 & i11119) | (458752 & i11119) | (i11119 & 3670016), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier2;
                function6 = function4;
                function7 = function5;
                z5 = z6;
                j3 = j6;
                j4 = j7;
                mutableInteractionSource2 = mutableInteractionSource3;
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
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TabKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return TabKt.Tab_wqdebIU$lambda$2(z, function0, modifier3, z5, function6, function7, j3, j4, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i10 |= 100663296;
        if ((i10 & 38347923) != 38347922) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z4, i10 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "97@4401L7");
            if ((i & 1) != 0) {
                if (i11 != 0) {
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
                if ((i2 & 64) != 0) {
                    ProvidableCompositionLocal<Color> localContentColor1111112 = ContentColorKt.getLocalContentColor();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume1111112 = composerStartRestartGroup.consume(localContentColor1111112);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    jM6824unboximpl = ((Color) objConsume1111112).m6824unboximpl();
                    i10 &= -3670017;
                } else {
                    jM6824unboximpl = j;
                }
                if ((i2 & 128) != 0) {
                    i10 &= -29360129;
                    j5 = jM6824unboximpl;
                } else {
                    j5 = j2;
                }
                z6 = z3;
                composableLambdaRememberComposableLambda = null;
                if (i12 != 0) {
                    j6 = jM6824unboximpl;
                    i14 = 1015017965;
                    mutableInteractionSource3 = null;
                    j7 = j5;
                } else {
                    j6 = jM6824unboximpl;
                    j7 = j5;
                    i14 = 1015017965;
                    mutableInteractionSource3 = mutableInteractionSource;
                }
            } else {
                if (i11 != 0) {
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
                if ((i2 & 64) != 0) {
                    ProvidableCompositionLocal<Color> localContentColor1111113 = ContentColorKt.getLocalContentColor();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume1111113 = composerStartRestartGroup.consume(localContentColor1111113);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    jM6824unboximpl = ((Color) objConsume1111113).m6824unboximpl();
                    i10 &= -3670017;
                } else {
                    jM6824unboximpl = j;
                }
                if ((i2 & 128) != 0) {
                    i10 &= -29360129;
                    j5 = jM6824unboximpl;
                } else {
                    j5 = j2;
                }
                z6 = z3;
                composableLambdaRememberComposableLambda = null;
                if (i12 != 0) {
                    j6 = jM6824unboximpl;
                    i14 = 1015017965;
                    mutableInteractionSource3 = null;
                    j7 = j5;
                } else {
                    j6 = jM6824unboximpl;
                    j7 = j5;
                    i14 = 1015017965;
                    mutableInteractionSource3 = mutableInteractionSource;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(i14, i10, -1, "androidx.compose.material3.Tab (Tab.kt:100)");
            }
            if (function4 == null) {
                composerStartRestartGroup.startReplaceGroup(1830887765);
            } else {
                composerStartRestartGroup.startReplaceGroup(1830887766);
                ComposerKt.sourceInformation(composerStartRestartGroup, "*103@4621L247");
                composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-1745256900, true, new Function2() { // from class: androidx.compose.material3.TabKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return TabKt.Tab_wqdebIU$lambda$0$0(function4, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54);
            }
            composerStartRestartGroup.endReplaceGroup();
            int i111110 = i10 >> 6;
            composer2 = composerStartRestartGroup;
            m4363TabbogVsAg(z, function0, BadgeKt.badgeBounds(modifier2), z6, j6, j7, mutableInteractionSource3, ComposableLambdaKt.rememberComposableLambda(-906085472, true, new Function3() { // from class: androidx.compose.material3.TabKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return TabKt.Tab_wqdebIU$lambda$1(composableLambdaRememberComposableLambda, function5, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composer2, (i10 & 14) | 12582912 | (i10 & 112) | (i10 & 7168) | (57344 & i111110) | (458752 & i111110) | (i111110 & 3670016), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier2;
            function6 = function4;
            function7 = function5;
            z5 = z6;
            j3 = j6;
            j4 = j7;
            mutableInteractionSource2 = mutableInteractionSource3;
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TabKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TabKt.Tab_wqdebIU$lambda$2(z, function0, modifier3, z5, function6, function7, j3, j4, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Tab_wqdebIU$lambda$0$0(Function2 function2, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C105@4712L5,108@4815L39:Tab.kt#uh7d8r");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1745256900, i, -1, "androidx.compose.material3.Tab.<anonymous>.<anonymous> (Tab.kt:104)");
            }
            TextKt.ProvideTextStyle(TextStyle.m9104copyp1EtxEg$default(TypographyKt.getValue(PrimaryNavigationTabTokens.INSTANCE.getLabelTextFont(), composer, 6), 0L, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, TextAlign.INSTANCE.m9526getCentere0LSkKk(), 0, 0L, null, null, null, 0, 0, null, 16744447, null), function2, composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Tab_wqdebIU$lambda$1(Function2 function2, Function2 function3, ColumnScope columnScope, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C120@5187L49:Tab.kt#uh7d8r");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-906085472, i, -1, "androidx.compose.material3.Tab.<anonymous> (Tab.kt:120)");
            }
            TabBaselineLayout(function2, function3, composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:104:0x0135 A[PHI: r7 r10 r11 r14 r18
      0x0135: PHI (r7v9 androidx.compose.ui.Modifier) = (r7v4 androidx.compose.ui.Modifier), (r7v2 androidx.compose.ui.Modifier) binds: [B:117:0x0171, B:103:0x0133] A[DONT_GENERATE, DONT_INLINE]
      0x0135: PHI (r10v11 boolean) = (r10v4 boolean), (r10v3 boolean) binds: [B:117:0x0171, B:103:0x0133] A[DONT_GENERATE, DONT_INLINE]
      0x0135: PHI (r11v24 int) = (r11v15 int), (r11v26 int) binds: [B:117:0x0171, B:103:0x0133] A[DONT_GENERATE, DONT_INLINE]
      0x0135: PHI (r14v7 long) = (r14v4 long), (r14v1 long) binds: [B:117:0x0171, B:103:0x0133] A[DONT_GENERATE, DONT_INLINE]
      0x0135: PHI (r18v10 long) = (r18v7 long), (r18v11 long) binds: [B:117:0x0171, B:103:0x0133] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:106:0x013a A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:107:0x013c  */
    /* JADX WARN: Code duplicated, block: B:109:0x0143  */
    /* JADX WARN: Code duplicated, block: B:112:0x0148  */
    /* JADX WARN: Code duplicated, block: B:115:0x0169  */
    /* JADX WARN: Code duplicated, block: B:116:0x016f  */
    /* JADX WARN: Code duplicated, block: B:118:0x0173  */
    /* JADX WARN: Code duplicated, block: B:121:0x017f  */
    /* JADX WARN: Code duplicated, block: B:124:0x01d8  */
    /* JADX WARN: Code duplicated, block: B:126:0x01e1  */
    /* JADX WARN: Code duplicated, block: B:129:0x01f2  */
    /* JADX WARN: Code duplicated, block: B:131:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:46:0x0082  */
    /* JADX WARN: Code duplicated, block: B:47:0x0084  */
    /* JADX WARN: Code duplicated, block: B:49:0x0087  */
    /* JADX WARN: Code duplicated, block: B:51:0x008f  */
    /* JADX WARN: Code duplicated, block: B:52:0x0092  */
    /* JADX WARN: Code duplicated, block: B:57:0x009d  */
    /* JADX WARN: Code duplicated, block: B:59:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:62:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:64:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:67:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:69:0x00bf  */
    /* JADX WARN: Code duplicated, block: B:72:0x00c8  */
    /* JADX WARN: Code duplicated, block: B:74:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:77:0x00d9  */
    /* JADX WARN: Code duplicated, block: B:78:0x00dc  */
    /* JADX WARN: Code duplicated, block: B:80:0x00e0  */
    /* JADX WARN: Code duplicated, block: B:82:0x00ea  */
    /* JADX WARN: Code duplicated, block: B:83:0x00ed  */
    /* JADX WARN: Code duplicated, block: B:88:0x0101  */
    /* JADX WARN: Code duplicated, block: B:89:0x0103  */
    /* JADX WARN: Code duplicated, block: B:92:0x010c  */
    /* JADX WARN: Code duplicated, block: B:94:0x011e  */
    /* JADX INFO: renamed from: LeadingIconTab-wqdebIU, reason: not valid java name */
    public static final void m4362LeadingIconTabwqdebIU(final boolean z, final Function0<Unit> function0, final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function3, Modifier modifier, boolean z2, long j, long j2, MutableInteractionSource mutableInteractionSource, Composer composer, final int i, final int i2) {
        int i3;
        Function2<? super Composer, ? super Integer, Unit> function4;
        Modifier modifier2;
        int i4;
        boolean z3;
        int i5;
        long jM6824unboximpl;
        int i6;
        int i7;
        int i8;
        boolean z4;
        Composer composer2;
        final MutableInteractionSource mutableInteractionSource2;
        final Modifier modifier3;
        final boolean z5;
        final long j3;
        final long j4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        long j5;
        final MutableInteractionSource mutableInteractionSource3;
        int i9;
        int i10;
        int i11;
        Composer composerStartRestartGroup = composer.startRestartGroup(-611535578);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(LeadingIconTab)N(selected,onClick,text,icon,modifier,enabled,selectedContentColor:c#ui.graphics.Color,unselectedContentColor:c#ui.graphics.Color,interactionSource)170@7524L952,170@7454L1022:Tab.kt#uh7d8r");
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
        int i12 = i2 & 16;
        if (i12 == 0) {
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
                if ((1572864 & i) == 0) {
                    jM6824unboximpl = j;
                    if ((i2 & 64) == 0 || !composerStartRestartGroup.changed(jM6824unboximpl)) {
                        i11 = 524288;
                    } else {
                        i11 = 1048576;
                    }
                    i3 |= i11;
                } else {
                    jM6824unboximpl = j;
                }
                if ((12582912 & i) == 0) {
                    int i13 = i3;
                    if ((i2 & 128) == 0 || !composerStartRestartGroup.changed(j2)) {
                        i10 = 4194304;
                    } else {
                        i10 = 8388608;
                    }
                    i6 = i13 | i10;
                } else {
                    i6 = i3;
                }
                i7 = i2 & 256;
                if (i7 != 0) {
                    if ((i & 100663296) == 0) {
                        if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                            i8 = 67108864;
                        } else {
                            i8 = 33554432;
                        }
                        i6 |= i8;
                    }
                    if ((i6 & 38347923) != 38347922) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z4, i6 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "161@7032L7");
                        if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            if (i12 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                z3 = true;
                            }
                            if ((i2 & 64) != 0) {
                                ProvidableCompositionLocal<Color> localContentColor = ContentColorKt.getLocalContentColor();
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                Object objConsume = composerStartRestartGroup.consume(localContentColor);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                jM6824unboximpl = ((Color) objConsume).m6824unboximpl();
                                i6 &= -3670017;
                            }
                            if ((i2 & 128) != 0) {
                                i6 &= -29360129;
                                j5 = jM6824unboximpl;
                            } else {
                                j5 = j2;
                            }
                            if (i7 != 0) {
                                mutableInteractionSource3 = null;
                            }
                            final boolean z6 = z3;
                            i9 = i6;
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-611535578, i9, -1, "androidx.compose.material3.LeadingIconTab (Tab.kt:164)");
                            }
                            final IndicationNodeFactory indicationNodeFactoryM4031rippleH2RKhps$default = RippleKt.m4031rippleH2RKhps$default(true, 0.0f, jM6824unboximpl, 2, null);
                            final Modifier modifier4 = modifier2;
                            final Function2<? super Composer, ? super Integer, Unit> function5 = function4;
                            int i14 = i9 >> 18;
                            m4365TabTransitionKlgxPg(jM6824unboximpl, j5, z, ComposableLambdaKt.rememberComposableLambda(1831009258, true, new Function2() { // from class: androidx.compose.material3.TabKt$$ExternalSyntheticLambda5
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return TabKt.LeadingIconTab_wqdebIU$lambda$0(modifier4, z, mutableInteractionSource3, indicationNodeFactoryM4031rippleH2RKhps$default, z6, function0, function5, function2, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i9 << 6) & 896) | (i14 & 112) | (i14 & 14) | 3072);
                            composer2 = composerStartRestartGroup;
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier3 = modifier4;
                            mutableInteractionSource2 = mutableInteractionSource3;
                            z5 = z6;
                            j3 = j5;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i2 & 64) != 0) {
                                i6 &= -3670017;
                            }
                            if ((i2 & 128) != 0) {
                                i6 &= -29360129;
                            }
                            j5 = j2;
                        }
                        mutableInteractionSource3 = mutableInteractionSource;
                        final boolean z7 = z3;
                        i9 = i6;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-611535578, i9, -1, "androidx.compose.material3.LeadingIconTab (Tab.kt:164)");
                        }
                        final IndicationNodeFactory indicationNodeFactoryM4031rippleH2RKhps$default2 = RippleKt.m4031rippleH2RKhps$default(true, 0.0f, jM6824unboximpl, 2, null);
                        final Modifier modifier5 = modifier2;
                        final Function2 function6 = function4;
                        int i15 = i9 >> 18;
                        m4365TabTransitionKlgxPg(jM6824unboximpl, j5, z, ComposableLambdaKt.rememberComposableLambda(1831009258, true, new Function2() { // from class: androidx.compose.material3.TabKt$$ExternalSyntheticLambda5
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return TabKt.LeadingIconTab_wqdebIU$lambda$0(modifier5, z, mutableInteractionSource3, indicationNodeFactoryM4031rippleH2RKhps$default2, z7, function0, function6, function2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i9 << 6) & 896) | (i15 & 112) | (i15 & 14) | 3072);
                        composer2 = composerStartRestartGroup;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier5;
                        mutableInteractionSource2 = mutableInteractionSource3;
                        z5 = z7;
                        j3 = j5;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        mutableInteractionSource2 = mutableInteractionSource;
                        modifier3 = modifier2;
                        z5 = z3;
                        j3 = j2;
                    }
                    j4 = jM6824unboximpl;
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TabKt$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return TabKt.LeadingIconTab_wqdebIU$lambda$1(z, function0, function2, function3, modifier3, z5, j4, j3, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i6 |= 100663296;
                if ((i6 & 38347923) != 38347922) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z4, i6 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "161@7032L7");
                    if ((i & 1) != 0) {
                        if (i12 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        }
                        if ((i2 & 64) != 0) {
                            ProvidableCompositionLocal<Color> localContentColor2 = ContentColorKt.getLocalContentColor();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                            Object objConsume2 = composerStartRestartGroup.consume(localContentColor2);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            jM6824unboximpl = ((Color) objConsume2).m6824unboximpl();
                            i6 &= -3670017;
                        }
                        if ((i2 & 128) != 0) {
                            i6 &= -29360129;
                            j5 = jM6824unboximpl;
                        } else {
                            j5 = j2;
                        }
                        if (i7 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                    } else {
                        if (i12 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        }
                        if ((i2 & 64) != 0) {
                            ProvidableCompositionLocal<Color> localContentColor3 = ContentColorKt.getLocalContentColor();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                            Object objConsume3 = composerStartRestartGroup.consume(localContentColor3);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            jM6824unboximpl = ((Color) objConsume3).m6824unboximpl();
                            i6 &= -3670017;
                        }
                        if ((i2 & 128) != 0) {
                            i6 &= -29360129;
                            j5 = jM6824unboximpl;
                        } else {
                            j5 = j2;
                        }
                        if (i7 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                    }
                    final boolean z8 = z3;
                    i9 = i6;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-611535578, i9, -1, "androidx.compose.material3.LeadingIconTab (Tab.kt:164)");
                    }
                    final IndicationNodeFactory indicationNodeFactoryM4031rippleH2RKhps$default3 = RippleKt.m4031rippleH2RKhps$default(true, 0.0f, jM6824unboximpl, 2, null);
                    final Modifier modifier6 = modifier2;
                    final Function2 function7 = function4;
                    int i16 = i9 >> 18;
                    m4365TabTransitionKlgxPg(jM6824unboximpl, j5, z, ComposableLambdaKt.rememberComposableLambda(1831009258, true, new Function2() { // from class: androidx.compose.material3.TabKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return TabKt.LeadingIconTab_wqdebIU$lambda$0(modifier6, z, mutableInteractionSource3, indicationNodeFactoryM4031rippleH2RKhps$default3, z8, function0, function7, function2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i9 << 6) & 896) | (i16 & 112) | (i16 & 14) | 3072);
                    composer2 = composerStartRestartGroup;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier6;
                    mutableInteractionSource2 = mutableInteractionSource3;
                    z5 = z8;
                    j3 = j5;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    mutableInteractionSource2 = mutableInteractionSource;
                    modifier3 = modifier2;
                    z5 = z3;
                    j3 = j2;
                }
                j4 = jM6824unboximpl;
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TabKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return TabKt.LeadingIconTab_wqdebIU$lambda$1(z, function0, function2, function3, modifier3, z5, j4, j3, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            z3 = z2;
            if ((1572864 & i) == 0) {
                jM6824unboximpl = j;
                if ((i2 & 64) == 0) {
                    i11 = 524288;
                } else {
                    i11 = 524288;
                }
                i3 |= i11;
            } else {
                jM6824unboximpl = j;
            }
            if ((12582912 & i) == 0) {
                int i17 = i3;
                if ((i2 & 128) == 0) {
                    i10 = 4194304;
                } else {
                    i10 = 4194304;
                }
                i6 = i17 | i10;
            } else {
                i6 = i3;
            }
            i7 = i2 & 256;
            if (i7 != 0) {
                if ((i & 100663296) == 0) {
                    if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                        i8 = 67108864;
                    } else {
                        i8 = 33554432;
                    }
                    i6 |= i8;
                }
                if ((i6 & 38347923) != 38347922) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z4, i6 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "161@7032L7");
                    if ((i & 1) != 0) {
                        if (i12 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        }
                        if ((i2 & 64) != 0) {
                            ProvidableCompositionLocal<Color> localContentColor4 = ContentColorKt.getLocalContentColor();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                            Object objConsume4 = composerStartRestartGroup.consume(localContentColor4);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            jM6824unboximpl = ((Color) objConsume4).m6824unboximpl();
                            i6 &= -3670017;
                        }
                        if ((i2 & 128) != 0) {
                            i6 &= -29360129;
                            j5 = jM6824unboximpl;
                        } else {
                            j5 = j2;
                        }
                        if (i7 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                    } else {
                        if (i12 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        }
                        if ((i2 & 64) != 0) {
                            ProvidableCompositionLocal<Color> localContentColor5 = ContentColorKt.getLocalContentColor();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                            Object objConsume5 = composerStartRestartGroup.consume(localContentColor5);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            jM6824unboximpl = ((Color) objConsume5).m6824unboximpl();
                            i6 &= -3670017;
                        }
                        if ((i2 & 128) != 0) {
                            i6 &= -29360129;
                            j5 = jM6824unboximpl;
                        } else {
                            j5 = j2;
                        }
                        if (i7 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                    }
                    final boolean z9 = z3;
                    i9 = i6;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-611535578, i9, -1, "androidx.compose.material3.LeadingIconTab (Tab.kt:164)");
                    }
                    final IndicationNodeFactory indicationNodeFactoryM4031rippleH2RKhps$default4 = RippleKt.m4031rippleH2RKhps$default(true, 0.0f, jM6824unboximpl, 2, null);
                    final Modifier modifier7 = modifier2;
                    final Function2 function8 = function4;
                    int i18 = i9 >> 18;
                    m4365TabTransitionKlgxPg(jM6824unboximpl, j5, z, ComposableLambdaKt.rememberComposableLambda(1831009258, true, new Function2() { // from class: androidx.compose.material3.TabKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return TabKt.LeadingIconTab_wqdebIU$lambda$0(modifier7, z, mutableInteractionSource3, indicationNodeFactoryM4031rippleH2RKhps$default4, z9, function0, function8, function2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i9 << 6) & 896) | (i18 & 112) | (i18 & 14) | 3072);
                    composer2 = composerStartRestartGroup;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier7;
                    mutableInteractionSource2 = mutableInteractionSource3;
                    z5 = z9;
                    j3 = j5;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    mutableInteractionSource2 = mutableInteractionSource;
                    modifier3 = modifier2;
                    z5 = z3;
                    j3 = j2;
                }
                j4 = jM6824unboximpl;
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TabKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return TabKt.LeadingIconTab_wqdebIU$lambda$1(z, function0, function2, function3, modifier3, z5, j4, j3, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i6 |= 100663296;
            if ((i6 & 38347923) != 38347922) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z4, i6 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "161@7032L7");
                if ((i & 1) != 0) {
                    if (i12 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    }
                    if ((i2 & 64) != 0) {
                        ProvidableCompositionLocal<Color> localContentColor6 = ContentColorKt.getLocalContentColor();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object objConsume6 = composerStartRestartGroup.consume(localContentColor6);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        jM6824unboximpl = ((Color) objConsume6).m6824unboximpl();
                        i6 &= -3670017;
                    }
                    if ((i2 & 128) != 0) {
                        i6 &= -29360129;
                        j5 = jM6824unboximpl;
                    } else {
                        j5 = j2;
                    }
                    if (i7 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                } else {
                    if (i12 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    }
                    if ((i2 & 64) != 0) {
                        ProvidableCompositionLocal<Color> localContentColor7 = ContentColorKt.getLocalContentColor();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object objConsume7 = composerStartRestartGroup.consume(localContentColor7);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        jM6824unboximpl = ((Color) objConsume7).m6824unboximpl();
                        i6 &= -3670017;
                    }
                    if ((i2 & 128) != 0) {
                        i6 &= -29360129;
                        j5 = jM6824unboximpl;
                    } else {
                        j5 = j2;
                    }
                    if (i7 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                }
                final boolean z10 = z3;
                i9 = i6;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-611535578, i9, -1, "androidx.compose.material3.LeadingIconTab (Tab.kt:164)");
                }
                final IndicationNodeFactory indicationNodeFactoryM4031rippleH2RKhps$default5 = RippleKt.m4031rippleH2RKhps$default(true, 0.0f, jM6824unboximpl, 2, null);
                final Modifier modifier8 = modifier2;
                final Function2 function9 = function4;
                int i19 = i9 >> 18;
                m4365TabTransitionKlgxPg(jM6824unboximpl, j5, z, ComposableLambdaKt.rememberComposableLambda(1831009258, true, new Function2() { // from class: androidx.compose.material3.TabKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return TabKt.LeadingIconTab_wqdebIU$lambda$0(modifier8, z, mutableInteractionSource3, indicationNodeFactoryM4031rippleH2RKhps$default5, z10, function0, function9, function2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i9 << 6) & 896) | (i19 & 112) | (i19 & 14) | 3072);
                composer2 = composerStartRestartGroup;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier8;
                mutableInteractionSource2 = mutableInteractionSource3;
                z5 = z10;
                j3 = j5;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                mutableInteractionSource2 = mutableInteractionSource;
                modifier3 = modifier2;
                z5 = z3;
                j3 = j2;
            }
            j4 = jM6824unboximpl;
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TabKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return TabKt.LeadingIconTab_wqdebIU$lambda$1(z, function0, function2, function3, modifier3, z5, j4, j3, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
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
            if ((1572864 & i) == 0) {
                jM6824unboximpl = j;
                if ((i2 & 64) == 0) {
                    i11 = 524288;
                } else {
                    i11 = 524288;
                }
                i3 |= i11;
            } else {
                jM6824unboximpl = j;
            }
            if ((12582912 & i) == 0) {
                int i110 = i3;
                if ((i2 & 128) == 0) {
                    i10 = 4194304;
                } else {
                    i10 = 4194304;
                }
                i6 = i110 | i10;
            } else {
                i6 = i3;
            }
            i7 = i2 & 256;
            if (i7 != 0) {
                if ((i & 100663296) == 0) {
                    if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                        i8 = 67108864;
                    } else {
                        i8 = 33554432;
                    }
                    i6 |= i8;
                }
                if ((i6 & 38347923) != 38347922) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z4, i6 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "161@7032L7");
                    if ((i & 1) != 0) {
                        if (i12 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        }
                        if ((i2 & 64) != 0) {
                            ProvidableCompositionLocal<Color> localContentColor8 = ContentColorKt.getLocalContentColor();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                            Object objConsume8 = composerStartRestartGroup.consume(localContentColor8);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            jM6824unboximpl = ((Color) objConsume8).m6824unboximpl();
                            i6 &= -3670017;
                        }
                        if ((i2 & 128) != 0) {
                            i6 &= -29360129;
                            j5 = jM6824unboximpl;
                        } else {
                            j5 = j2;
                        }
                        if (i7 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                    } else {
                        if (i12 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        }
                        if ((i2 & 64) != 0) {
                            ProvidableCompositionLocal<Color> localContentColor9 = ContentColorKt.getLocalContentColor();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                            Object objConsume9 = composerStartRestartGroup.consume(localContentColor9);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            jM6824unboximpl = ((Color) objConsume9).m6824unboximpl();
                            i6 &= -3670017;
                        }
                        if ((i2 & 128) != 0) {
                            i6 &= -29360129;
                            j5 = jM6824unboximpl;
                        } else {
                            j5 = j2;
                        }
                        if (i7 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                    }
                    final boolean z11 = z3;
                    i9 = i6;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-611535578, i9, -1, "androidx.compose.material3.LeadingIconTab (Tab.kt:164)");
                    }
                    final IndicationNodeFactory indicationNodeFactoryM4031rippleH2RKhps$default6 = RippleKt.m4031rippleH2RKhps$default(true, 0.0f, jM6824unboximpl, 2, null);
                    final Modifier modifier9 = modifier2;
                    final Function2 function10 = function4;
                    int i111 = i9 >> 18;
                    m4365TabTransitionKlgxPg(jM6824unboximpl, j5, z, ComposableLambdaKt.rememberComposableLambda(1831009258, true, new Function2() { // from class: androidx.compose.material3.TabKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return TabKt.LeadingIconTab_wqdebIU$lambda$0(modifier9, z, mutableInteractionSource3, indicationNodeFactoryM4031rippleH2RKhps$default6, z11, function0, function10, function2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i9 << 6) & 896) | (i111 & 112) | (i111 & 14) | 3072);
                    composer2 = composerStartRestartGroup;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier9;
                    mutableInteractionSource2 = mutableInteractionSource3;
                    z5 = z11;
                    j3 = j5;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    mutableInteractionSource2 = mutableInteractionSource;
                    modifier3 = modifier2;
                    z5 = z3;
                    j3 = j2;
                }
                j4 = jM6824unboximpl;
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TabKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return TabKt.LeadingIconTab_wqdebIU$lambda$1(z, function0, function2, function3, modifier3, z5, j4, j3, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i6 |= 100663296;
            if ((i6 & 38347923) != 38347922) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z4, i6 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "161@7032L7");
                if ((i & 1) != 0) {
                    if (i12 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    }
                    if ((i2 & 64) != 0) {
                        ProvidableCompositionLocal<Color> localContentColor10 = ContentColorKt.getLocalContentColor();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object objConsume10 = composerStartRestartGroup.consume(localContentColor10);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        jM6824unboximpl = ((Color) objConsume10).m6824unboximpl();
                        i6 &= -3670017;
                    }
                    if ((i2 & 128) != 0) {
                        i6 &= -29360129;
                        j5 = jM6824unboximpl;
                    } else {
                        j5 = j2;
                    }
                    if (i7 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                } else {
                    if (i12 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    }
                    if ((i2 & 64) != 0) {
                        ProvidableCompositionLocal<Color> localContentColor11 = ContentColorKt.getLocalContentColor();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object objConsume11 = composerStartRestartGroup.consume(localContentColor11);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        jM6824unboximpl = ((Color) objConsume11).m6824unboximpl();
                        i6 &= -3670017;
                    }
                    if ((i2 & 128) != 0) {
                        i6 &= -29360129;
                        j5 = jM6824unboximpl;
                    } else {
                        j5 = j2;
                    }
                    if (i7 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                }
                final boolean z12 = z3;
                i9 = i6;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-611535578, i9, -1, "androidx.compose.material3.LeadingIconTab (Tab.kt:164)");
                }
                final IndicationNodeFactory indicationNodeFactoryM4031rippleH2RKhps$default7 = RippleKt.m4031rippleH2RKhps$default(true, 0.0f, jM6824unboximpl, 2, null);
                final Modifier modifier10 = modifier2;
                final Function2 function11 = function4;
                int i112 = i9 >> 18;
                m4365TabTransitionKlgxPg(jM6824unboximpl, j5, z, ComposableLambdaKt.rememberComposableLambda(1831009258, true, new Function2() { // from class: androidx.compose.material3.TabKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return TabKt.LeadingIconTab_wqdebIU$lambda$0(modifier10, z, mutableInteractionSource3, indicationNodeFactoryM4031rippleH2RKhps$default7, z12, function0, function11, function2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i9 << 6) & 896) | (i112 & 112) | (i112 & 14) | 3072);
                composer2 = composerStartRestartGroup;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier10;
                mutableInteractionSource2 = mutableInteractionSource3;
                z5 = z12;
                j3 = j5;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                mutableInteractionSource2 = mutableInteractionSource;
                modifier3 = modifier2;
                z5 = z3;
                j3 = j2;
            }
            j4 = jM6824unboximpl;
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TabKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return TabKt.LeadingIconTab_wqdebIU$lambda$1(z, function0, function2, function3, modifier3, z5, j4, j3, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        z3 = z2;
        if ((1572864 & i) == 0) {
            jM6824unboximpl = j;
            if ((i2 & 64) == 0) {
                i11 = 524288;
            } else {
                i11 = 524288;
            }
            i3 |= i11;
        } else {
            jM6824unboximpl = j;
        }
        if ((12582912 & i) == 0) {
            int i113 = i3;
            if ((i2 & 128) == 0) {
                i10 = 4194304;
            } else {
                i10 = 4194304;
            }
            i6 = i113 | i10;
        } else {
            i6 = i3;
        }
        i7 = i2 & 256;
        if (i7 != 0) {
            if ((i & 100663296) == 0) {
                if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                    i8 = 67108864;
                } else {
                    i8 = 33554432;
                }
                i6 |= i8;
            }
            if ((i6 & 38347923) != 38347922) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z4, i6 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "161@7032L7");
                if ((i & 1) != 0) {
                    if (i12 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    }
                    if ((i2 & 64) != 0) {
                        ProvidableCompositionLocal<Color> localContentColor12 = ContentColorKt.getLocalContentColor();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object objConsume12 = composerStartRestartGroup.consume(localContentColor12);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        jM6824unboximpl = ((Color) objConsume12).m6824unboximpl();
                        i6 &= -3670017;
                    }
                    if ((i2 & 128) != 0) {
                        i6 &= -29360129;
                        j5 = jM6824unboximpl;
                    } else {
                        j5 = j2;
                    }
                    if (i7 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                } else {
                    if (i12 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    }
                    if ((i2 & 64) != 0) {
                        ProvidableCompositionLocal<Color> localContentColor13 = ContentColorKt.getLocalContentColor();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object objConsume13 = composerStartRestartGroup.consume(localContentColor13);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        jM6824unboximpl = ((Color) objConsume13).m6824unboximpl();
                        i6 &= -3670017;
                    }
                    if ((i2 & 128) != 0) {
                        i6 &= -29360129;
                        j5 = jM6824unboximpl;
                    } else {
                        j5 = j2;
                    }
                    if (i7 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                }
                final boolean z13 = z3;
                i9 = i6;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-611535578, i9, -1, "androidx.compose.material3.LeadingIconTab (Tab.kt:164)");
                }
                final IndicationNodeFactory indicationNodeFactoryM4031rippleH2RKhps$default8 = RippleKt.m4031rippleH2RKhps$default(true, 0.0f, jM6824unboximpl, 2, null);
                final Modifier modifier11 = modifier2;
                final Function2 function12 = function4;
                int i114 = i9 >> 18;
                m4365TabTransitionKlgxPg(jM6824unboximpl, j5, z, ComposableLambdaKt.rememberComposableLambda(1831009258, true, new Function2() { // from class: androidx.compose.material3.TabKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return TabKt.LeadingIconTab_wqdebIU$lambda$0(modifier11, z, mutableInteractionSource3, indicationNodeFactoryM4031rippleH2RKhps$default8, z13, function0, function12, function2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i9 << 6) & 896) | (i114 & 112) | (i114 & 14) | 3072);
                composer2 = composerStartRestartGroup;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier11;
                mutableInteractionSource2 = mutableInteractionSource3;
                z5 = z13;
                j3 = j5;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                mutableInteractionSource2 = mutableInteractionSource;
                modifier3 = modifier2;
                z5 = z3;
                j3 = j2;
            }
            j4 = jM6824unboximpl;
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TabKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return TabKt.LeadingIconTab_wqdebIU$lambda$1(z, function0, function2, function3, modifier3, z5, j4, j3, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i6 |= 100663296;
        if ((i6 & 38347923) != 38347922) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z4, i6 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "161@7032L7");
            if ((i & 1) != 0) {
                if (i12 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i4 != 0) {
                    z3 = true;
                }
                if ((i2 & 64) != 0) {
                    ProvidableCompositionLocal<Color> localContentColor14 = ContentColorKt.getLocalContentColor();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume14 = composerStartRestartGroup.consume(localContentColor14);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    jM6824unboximpl = ((Color) objConsume14).m6824unboximpl();
                    i6 &= -3670017;
                }
                if ((i2 & 128) != 0) {
                    i6 &= -29360129;
                    j5 = jM6824unboximpl;
                } else {
                    j5 = j2;
                }
                if (i7 != 0) {
                    mutableInteractionSource3 = null;
                } else {
                    mutableInteractionSource3 = mutableInteractionSource;
                }
            } else {
                if (i12 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i4 != 0) {
                    z3 = true;
                }
                if ((i2 & 64) != 0) {
                    ProvidableCompositionLocal<Color> localContentColor15 = ContentColorKt.getLocalContentColor();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume15 = composerStartRestartGroup.consume(localContentColor15);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    jM6824unboximpl = ((Color) objConsume15).m6824unboximpl();
                    i6 &= -3670017;
                }
                if ((i2 & 128) != 0) {
                    i6 &= -29360129;
                    j5 = jM6824unboximpl;
                } else {
                    j5 = j2;
                }
                if (i7 != 0) {
                    mutableInteractionSource3 = null;
                } else {
                    mutableInteractionSource3 = mutableInteractionSource;
                }
            }
            final boolean z14 = z3;
            i9 = i6;
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-611535578, i9, -1, "androidx.compose.material3.LeadingIconTab (Tab.kt:164)");
            }
            final IndicationNodeFactory indicationNodeFactoryM4031rippleH2RKhps$default9 = RippleKt.m4031rippleH2RKhps$default(true, 0.0f, jM6824unboximpl, 2, null);
            final Modifier modifier12 = modifier2;
            final Function2 function13 = function4;
            int i115 = i9 >> 18;
            m4365TabTransitionKlgxPg(jM6824unboximpl, j5, z, ComposableLambdaKt.rememberComposableLambda(1831009258, true, new Function2() { // from class: androidx.compose.material3.TabKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TabKt.LeadingIconTab_wqdebIU$lambda$0(modifier12, z, mutableInteractionSource3, indicationNodeFactoryM4031rippleH2RKhps$default9, z14, function0, function13, function2, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i9 << 6) & 896) | (i115 & 112) | (i115 & 14) | 3072);
            composer2 = composerStartRestartGroup;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier12;
            mutableInteractionSource2 = mutableInteractionSource3;
            z5 = z14;
            j3 = j5;
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            mutableInteractionSource2 = mutableInteractionSource;
            modifier3 = modifier2;
            z5 = z3;
            j3 = j2;
        }
        j4 = jM6824unboximpl;
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TabKt$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TabKt.LeadingIconTab_wqdebIU$lambda$1(z, function0, function2, function3, modifier3, z5, j4, j3, mutableInteractionSource2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LeadingIconTab_wqdebIU$lambda$0(Modifier modifier, boolean z, MutableInteractionSource mutableInteractionSource, IndicationNodeFactory indicationNodeFactory, boolean z2, Function0 function0, Function2 function2, Function2 function3, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C171@7534L936:Tab.kt#uh7d8r");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1831009258, i, -1, "androidx.compose.material3.LeadingIconTab.<anonymous> (Tab.kt:171)");
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
            ComposerKt.sourceInformationMarkerStart(composer, -337008199, "C188@8208L6,189@8227L59,191@8368L5,192@8421L39:Tab.kt#uh7d8r");
            function2.invoke(composer, 0);
            SpacerKt.Spacer(SizeKt.m1263requiredWidth3ABfNKs(Modifier.INSTANCE, TextDistanceFromLeadingIcon), composer, 6);
            TextKt.ProvideTextStyle(TextStyle.m9104copyp1EtxEg$default(TypographyKt.getValue(PrimaryNavigationTabTokens.INSTANCE.getLabelTextFont(), composer, 6), 0L, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, TextAlign.INSTANCE.m9526getCentere0LSkKk(), 0, 0L, null, null, null, 0, 0, null, 16744447, null), function3, composer, 0);
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

    /* JADX WARN: Code duplicated, block: B:100:0x0122 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:101:0x0124  */
    /* JADX WARN: Code duplicated, block: B:103:0x012b  */
    /* JADX WARN: Code duplicated, block: B:106:0x0130  */
    /* JADX WARN: Code duplicated, block: B:107:0x014e  */
    /* JADX WARN: Code duplicated, block: B:110:0x0154  */
    /* JADX WARN: Code duplicated, block: B:112:0x0158  */
    /* JADX WARN: Code duplicated, block: B:115:0x0169  */
    /* JADX WARN: Code duplicated, block: B:118:0x01b5  */
    /* JADX WARN: Code duplicated, block: B:120:0x01be  */
    /* JADX WARN: Code duplicated, block: B:123:0x01cd  */
    /* JADX WARN: Code duplicated, block: B:125:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:31:0x0057  */
    /* JADX WARN: Code duplicated, block: B:32:0x005a  */
    /* JADX WARN: Code duplicated, block: B:34:0x005e  */
    /* JADX WARN: Code duplicated, block: B:36:0x0066  */
    /* JADX WARN: Code duplicated, block: B:37:0x0069  */
    /* JADX WARN: Code duplicated, block: B:42:0x0073  */
    /* JADX WARN: Code duplicated, block: B:44:0x0077  */
    /* JADX WARN: Code duplicated, block: B:46:0x007f  */
    /* JADX WARN: Code duplicated, block: B:47:0x0082  */
    /* JADX WARN: Code duplicated, block: B:50:0x0088  */
    /* JADX WARN: Code duplicated, block: B:53:0x008f  */
    /* JADX WARN: Code duplicated, block: B:55:0x0093  */
    /* JADX WARN: Code duplicated, block: B:57:0x009b  */
    /* JADX WARN: Code duplicated, block: B:58:0x009e  */
    /* JADX WARN: Code duplicated, block: B:61:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:64:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:65:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:67:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:69:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:70:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:75:0x00cb  */
    /* JADX WARN: Code duplicated, block: B:77:0x00d1  */
    /* JADX WARN: Code duplicated, block: B:78:0x00d4  */
    /* JADX WARN: Code duplicated, block: B:82:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:83:0x00e7  */
    /* JADX WARN: Code duplicated, block: B:86:0x00f0  */
    /* JADX WARN: Code duplicated, block: B:88:0x0102  */
    /* JADX WARN: Code duplicated, block: B:98:0x011a A[PHI: r0 r4 r8 r9 r12
      0x011a: PHI (r0v28 int) = (r0v14 int), (r0v32 int), (r0v33 int) binds: [B:111:0x0156, B:96:0x0117, B:97:0x0119] A[DONT_GENERATE, DONT_INLINE]
      0x011a: PHI (r4v8 androidx.compose.ui.Modifier) = (r4v5 androidx.compose.ui.Modifier), (r4v2 androidx.compose.ui.Modifier), (r4v2 androidx.compose.ui.Modifier) binds: [B:111:0x0156, B:96:0x0117, B:97:0x0119] A[DONT_GENERATE, DONT_INLINE]
      0x011a: PHI (r8v9 boolean) = (r8v3 boolean), (r8v2 boolean), (r8v2 boolean) binds: [B:111:0x0156, B:96:0x0117, B:97:0x0119] A[DONT_GENERATE, DONT_INLINE]
      0x011a: PHI (r9v12 long) = (r9v9 long), (r9v6 long), (r9v6 long) binds: [B:111:0x0156, B:96:0x0117, B:97:0x0119] A[DONT_GENERATE, DONT_INLINE]
      0x011a: PHI (r12v9 long) = (r12v5 long), (r12v3 long), (r12v3 long) binds: [B:111:0x0156, B:96:0x0117, B:97:0x0119] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX INFO: renamed from: Tab-bogVsAg, reason: not valid java name */
    public static final void m4363TabbogVsAg(final boolean z, final Function0<Unit> function0, Modifier modifier, boolean z2, long j, long j2, MutableInteractionSource mutableInteractionSource, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        boolean z3;
        int i5;
        long jM6824unboximpl;
        long j3;
        int i6;
        final MutableInteractionSource mutableInteractionSource2;
        int i7;
        int i8;
        boolean z4;
        final Modifier modifier3;
        final boolean z5;
        final long j4;
        final long j5;
        final MutableInteractionSource mutableInteractionSource3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i9;
        final Modifier modifier4;
        long j6;
        int i10;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1573136853);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Tab)N(selected,onClick,modifier,enabled,selectedContentColor:c#ui.graphics.Color,unselectedContentColor:c#ui.graphics.Color,interactionSource,content)243@10768L602,243@10698L672:Tab.kt#uh7d8r");
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
                if ((i & 24576) == 0) {
                    if ((i2 & 16) == 0) {
                        jM6824unboximpl = j;
                        int i12 = composerStartRestartGroup.changed(jM6824unboximpl) ? 16384 : 8192;
                        i3 |= i12;
                    } else {
                        jM6824unboximpl = j;
                    }
                    i3 |= i12;
                } else {
                    jM6824unboximpl = j;
                }
                if ((196608 & i) == 0) {
                    if ((i2 & 32) == 0) {
                        j3 = j2;
                        int i13 = composerStartRestartGroup.changed(j3) ? 131072 : 65536;
                        i3 |= i13;
                    } else {
                        j3 = j2;
                    }
                    i3 |= i13;
                } else {
                    j3 = j2;
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
                        ComposerKt.sourceInformation(composerStartRestartGroup, "233@10230L7");
                        if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            if (i11 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                z3 = true;
                            }
                            if ((i2 & 16) != 0) {
                                ProvidableCompositionLocal<Color> localContentColor = ContentColorKt.getLocalContentColor();
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                Object objConsume = composerStartRestartGroup.consume(localContentColor);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                jM6824unboximpl = ((Color) objConsume).m6824unboximpl();
                                i9 = i8 & (-57345);
                            } else {
                                i9 = i8;
                            }
                            if ((i2 & 32) != 0) {
                                i9 &= -458753;
                                j3 = jM6824unboximpl;
                            }
                            if (i6 != 0) {
                                modifier4 = modifier2;
                                j6 = j3;
                                mutableInteractionSource2 = null;
                            }
                            final boolean z6 = z3;
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1573136853, i9, -1, "androidx.compose.material3.Tab (Tab.kt:237)");
                            }
                            final IndicationNodeFactory indicationNodeFactoryM4031rippleH2RKhps$default = RippleKt.m4031rippleH2RKhps$default(true, 0.0f, jM6824unboximpl, 2, null);
                            int i14 = i9 >> 12;
                            m4365TabTransitionKlgxPg(jM6824unboximpl, j6, z, ComposableLambdaKt.rememberComposableLambda(1128552423, true, new Function2() { // from class: androidx.compose.material3.TabKt$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return TabKt.Tab_bogVsAg$lambda$0(modifier4, z, mutableInteractionSource2, indicationNodeFactoryM4031rippleH2RKhps$default, z6, function0, function3, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composerStartRestartGroup, 54), composerStartRestartGroup, (i14 & 112) | (i14 & 14) | 3072 | ((i9 << 6) & 896));
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            j4 = j6;
                            modifier3 = modifier4;
                            z5 = z6;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            i9 = (i2 & 16) != 0 ? i8 & (-57345) : i8;
                            if ((i2 & 32) != 0) {
                                i9 &= -458753;
                            }
                        }
                        modifier4 = modifier2;
                        j6 = j3;
                        final boolean z7 = z3;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1573136853, i9, -1, "androidx.compose.material3.Tab (Tab.kt:237)");
                        }
                        final IndicationNodeFactory indicationNodeFactoryM4031rippleH2RKhps$default2 = RippleKt.m4031rippleH2RKhps$default(true, 0.0f, jM6824unboximpl, 2, null);
                        int i15 = i9 >> 12;
                        m4365TabTransitionKlgxPg(jM6824unboximpl, j6, z, ComposableLambdaKt.rememberComposableLambda(1128552423, true, new Function2() { // from class: androidx.compose.material3.TabKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return TabKt.Tab_bogVsAg$lambda$0(modifier4, z, mutableInteractionSource2, indicationNodeFactoryM4031rippleH2RKhps$default2, z7, function0, function3, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, (i15 & 112) | (i15 & 14) | 3072 | ((i9 << 6) & 896));
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        j4 = j6;
                        modifier3 = modifier4;
                        z5 = z7;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        modifier3 = modifier2;
                        z5 = z3;
                        j4 = j3;
                    }
                    j5 = jM6824unboximpl;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TabKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return TabKt.Tab_bogVsAg$lambda$1(z, function0, modifier3, z5, j5, j4, mutableInteractionSource3, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= 1572864;
                mutableInteractionSource2 = mutableInteractionSource;
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
                    ComposerKt.sourceInformation(composerStartRestartGroup, "233@10230L7");
                    if ((i & 1) != 0) {
                        if (i11 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        }
                        if ((i2 & 16) != 0) {
                            ProvidableCompositionLocal<Color> localContentColor2 = ContentColorKt.getLocalContentColor();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                            Object objConsume2 = composerStartRestartGroup.consume(localContentColor2);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            jM6824unboximpl = ((Color) objConsume2).m6824unboximpl();
                            i9 = i8 & (-57345);
                        } else {
                            i9 = i8;
                        }
                        if ((i2 & 32) != 0) {
                            i9 &= -458753;
                            j3 = jM6824unboximpl;
                        }
                        if (i6 != 0) {
                            modifier4 = modifier2;
                            j6 = j3;
                            mutableInteractionSource2 = null;
                        } else {
                            modifier4 = modifier2;
                            j6 = j3;
                        }
                    } else {
                        if (i11 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        }
                        if ((i2 & 16) != 0) {
                            ProvidableCompositionLocal<Color> localContentColor3 = ContentColorKt.getLocalContentColor();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                            Object objConsume3 = composerStartRestartGroup.consume(localContentColor3);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            jM6824unboximpl = ((Color) objConsume3).m6824unboximpl();
                            i9 = i8 & (-57345);
                        } else {
                            i9 = i8;
                        }
                        if ((i2 & 32) != 0) {
                            i9 &= -458753;
                            j3 = jM6824unboximpl;
                        }
                        if (i6 != 0) {
                            modifier4 = modifier2;
                            j6 = j3;
                            mutableInteractionSource2 = null;
                        } else {
                            modifier4 = modifier2;
                            j6 = j3;
                        }
                    }
                    final boolean z8 = z3;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1573136853, i9, -1, "androidx.compose.material3.Tab (Tab.kt:237)");
                    }
                    final IndicationNodeFactory indicationNodeFactoryM4031rippleH2RKhps$default3 = RippleKt.m4031rippleH2RKhps$default(true, 0.0f, jM6824unboximpl, 2, null);
                    int i16 = i9 >> 12;
                    m4365TabTransitionKlgxPg(jM6824unboximpl, j6, z, ComposableLambdaKt.rememberComposableLambda(1128552423, true, new Function2() { // from class: androidx.compose.material3.TabKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return TabKt.Tab_bogVsAg$lambda$0(modifier4, z, mutableInteractionSource2, indicationNodeFactoryM4031rippleH2RKhps$default3, z8, function0, function3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, (i16 & 112) | (i16 & 14) | 3072 | ((i9 << 6) & 896));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    j4 = j6;
                    modifier3 = modifier4;
                    z5 = z8;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier3 = modifier2;
                    z5 = z3;
                    j4 = j3;
                }
                j5 = jM6824unboximpl;
                mutableInteractionSource3 = mutableInteractionSource2;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TabKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return TabKt.Tab_bogVsAg$lambda$1(z, function0, modifier3, z5, j5, j4, mutableInteractionSource3, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 3072;
            z3 = z2;
            if ((i & 24576) == 0) {
                if ((i2 & 16) == 0) {
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
            if ((196608 & i) == 0) {
                if ((i2 & 32) == 0) {
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
                    ComposerKt.sourceInformation(composerStartRestartGroup, "233@10230L7");
                    if ((i & 1) != 0) {
                        if (i11 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        }
                        if ((i2 & 16) != 0) {
                            ProvidableCompositionLocal<Color> localContentColor4 = ContentColorKt.getLocalContentColor();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                            Object objConsume4 = composerStartRestartGroup.consume(localContentColor4);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            jM6824unboximpl = ((Color) objConsume4).m6824unboximpl();
                            i9 = i8 & (-57345);
                        } else {
                            i9 = i8;
                        }
                        if ((i2 & 32) != 0) {
                            i9 &= -458753;
                            j3 = jM6824unboximpl;
                        }
                        if (i6 != 0) {
                            modifier4 = modifier2;
                            j6 = j3;
                            mutableInteractionSource2 = null;
                        } else {
                            modifier4 = modifier2;
                            j6 = j3;
                        }
                    } else {
                        if (i11 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        }
                        if ((i2 & 16) != 0) {
                            ProvidableCompositionLocal<Color> localContentColor5 = ContentColorKt.getLocalContentColor();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                            Object objConsume5 = composerStartRestartGroup.consume(localContentColor5);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            jM6824unboximpl = ((Color) objConsume5).m6824unboximpl();
                            i9 = i8 & (-57345);
                        } else {
                            i9 = i8;
                        }
                        if ((i2 & 32) != 0) {
                            i9 &= -458753;
                            j3 = jM6824unboximpl;
                        }
                        if (i6 != 0) {
                            modifier4 = modifier2;
                            j6 = j3;
                            mutableInteractionSource2 = null;
                        } else {
                            modifier4 = modifier2;
                            j6 = j3;
                        }
                    }
                    final boolean z9 = z3;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1573136853, i9, -1, "androidx.compose.material3.Tab (Tab.kt:237)");
                    }
                    final IndicationNodeFactory indicationNodeFactoryM4031rippleH2RKhps$default4 = RippleKt.m4031rippleH2RKhps$default(true, 0.0f, jM6824unboximpl, 2, null);
                    int i17 = i9 >> 12;
                    m4365TabTransitionKlgxPg(jM6824unboximpl, j6, z, ComposableLambdaKt.rememberComposableLambda(1128552423, true, new Function2() { // from class: androidx.compose.material3.TabKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return TabKt.Tab_bogVsAg$lambda$0(modifier4, z, mutableInteractionSource2, indicationNodeFactoryM4031rippleH2RKhps$default4, z9, function0, function3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, (i17 & 112) | (i17 & 14) | 3072 | ((i9 << 6) & 896));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    j4 = j6;
                    modifier3 = modifier4;
                    z5 = z9;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier3 = modifier2;
                    z5 = z3;
                    j4 = j3;
                }
                j5 = jM6824unboximpl;
                mutableInteractionSource3 = mutableInteractionSource2;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TabKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return TabKt.Tab_bogVsAg$lambda$1(z, function0, modifier3, z5, j5, j4, mutableInteractionSource3, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 1572864;
            mutableInteractionSource2 = mutableInteractionSource;
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
                ComposerKt.sourceInformation(composerStartRestartGroup, "233@10230L7");
                if ((i & 1) != 0) {
                    if (i11 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    }
                    if ((i2 & 16) != 0) {
                        ProvidableCompositionLocal<Color> localContentColor6 = ContentColorKt.getLocalContentColor();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object objConsume6 = composerStartRestartGroup.consume(localContentColor6);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        jM6824unboximpl = ((Color) objConsume6).m6824unboximpl();
                        i9 = i8 & (-57345);
                    } else {
                        i9 = i8;
                    }
                    if ((i2 & 32) != 0) {
                        i9 &= -458753;
                        j3 = jM6824unboximpl;
                    }
                    if (i6 != 0) {
                        modifier4 = modifier2;
                        j6 = j3;
                        mutableInteractionSource2 = null;
                    } else {
                        modifier4 = modifier2;
                        j6 = j3;
                    }
                } else {
                    if (i11 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    }
                    if ((i2 & 16) != 0) {
                        ProvidableCompositionLocal<Color> localContentColor7 = ContentColorKt.getLocalContentColor();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object objConsume7 = composerStartRestartGroup.consume(localContentColor7);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        jM6824unboximpl = ((Color) objConsume7).m6824unboximpl();
                        i9 = i8 & (-57345);
                    } else {
                        i9 = i8;
                    }
                    if ((i2 & 32) != 0) {
                        i9 &= -458753;
                        j3 = jM6824unboximpl;
                    }
                    if (i6 != 0) {
                        modifier4 = modifier2;
                        j6 = j3;
                        mutableInteractionSource2 = null;
                    } else {
                        modifier4 = modifier2;
                        j6 = j3;
                    }
                }
                final boolean z10 = z3;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1573136853, i9, -1, "androidx.compose.material3.Tab (Tab.kt:237)");
                }
                final IndicationNodeFactory indicationNodeFactoryM4031rippleH2RKhps$default5 = RippleKt.m4031rippleH2RKhps$default(true, 0.0f, jM6824unboximpl, 2, null);
                int i18 = i9 >> 12;
                m4365TabTransitionKlgxPg(jM6824unboximpl, j6, z, ComposableLambdaKt.rememberComposableLambda(1128552423, true, new Function2() { // from class: androidx.compose.material3.TabKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return TabKt.Tab_bogVsAg$lambda$0(modifier4, z, mutableInteractionSource2, indicationNodeFactoryM4031rippleH2RKhps$default5, z10, function0, function3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, (i18 & 112) | (i18 & 14) | 3072 | ((i9 << 6) & 896));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                j4 = j6;
                modifier3 = modifier4;
                z5 = z10;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                z5 = z3;
                j4 = j3;
            }
            j5 = jM6824unboximpl;
            mutableInteractionSource3 = mutableInteractionSource2;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TabKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return TabKt.Tab_bogVsAg$lambda$1(z, function0, modifier3, z5, j5, j4, mutableInteractionSource3, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
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
            if ((i & 24576) == 0) {
                if ((i2 & 16) == 0) {
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
            if ((196608 & i) == 0) {
                if ((i2 & 32) == 0) {
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
                    ComposerKt.sourceInformation(composerStartRestartGroup, "233@10230L7");
                    if ((i & 1) != 0) {
                        if (i11 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        }
                        if ((i2 & 16) != 0) {
                            ProvidableCompositionLocal<Color> localContentColor8 = ContentColorKt.getLocalContentColor();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                            Object objConsume8 = composerStartRestartGroup.consume(localContentColor8);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            jM6824unboximpl = ((Color) objConsume8).m6824unboximpl();
                            i9 = i8 & (-57345);
                        } else {
                            i9 = i8;
                        }
                        if ((i2 & 32) != 0) {
                            i9 &= -458753;
                            j3 = jM6824unboximpl;
                        }
                        if (i6 != 0) {
                            modifier4 = modifier2;
                            j6 = j3;
                            mutableInteractionSource2 = null;
                        } else {
                            modifier4 = modifier2;
                            j6 = j3;
                        }
                    } else {
                        if (i11 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            z3 = true;
                        }
                        if ((i2 & 16) != 0) {
                            ProvidableCompositionLocal<Color> localContentColor9 = ContentColorKt.getLocalContentColor();
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                            Object objConsume9 = composerStartRestartGroup.consume(localContentColor9);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            jM6824unboximpl = ((Color) objConsume9).m6824unboximpl();
                            i9 = i8 & (-57345);
                        } else {
                            i9 = i8;
                        }
                        if ((i2 & 32) != 0) {
                            i9 &= -458753;
                            j3 = jM6824unboximpl;
                        }
                        if (i6 != 0) {
                            modifier4 = modifier2;
                            j6 = j3;
                            mutableInteractionSource2 = null;
                        } else {
                            modifier4 = modifier2;
                            j6 = j3;
                        }
                    }
                    final boolean z11 = z3;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1573136853, i9, -1, "androidx.compose.material3.Tab (Tab.kt:237)");
                    }
                    final IndicationNodeFactory indicationNodeFactoryM4031rippleH2RKhps$default6 = RippleKt.m4031rippleH2RKhps$default(true, 0.0f, jM6824unboximpl, 2, null);
                    int i19 = i9 >> 12;
                    m4365TabTransitionKlgxPg(jM6824unboximpl, j6, z, ComposableLambdaKt.rememberComposableLambda(1128552423, true, new Function2() { // from class: androidx.compose.material3.TabKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return TabKt.Tab_bogVsAg$lambda$0(modifier4, z, mutableInteractionSource2, indicationNodeFactoryM4031rippleH2RKhps$default6, z11, function0, function3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, (i19 & 112) | (i19 & 14) | 3072 | ((i9 << 6) & 896));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    j4 = j6;
                    modifier3 = modifier4;
                    z5 = z11;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier3 = modifier2;
                    z5 = z3;
                    j4 = j3;
                }
                j5 = jM6824unboximpl;
                mutableInteractionSource3 = mutableInteractionSource2;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TabKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return TabKt.Tab_bogVsAg$lambda$1(z, function0, modifier3, z5, j5, j4, mutableInteractionSource3, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 1572864;
            mutableInteractionSource2 = mutableInteractionSource;
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
                ComposerKt.sourceInformation(composerStartRestartGroup, "233@10230L7");
                if ((i & 1) != 0) {
                    if (i11 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    }
                    if ((i2 & 16) != 0) {
                        ProvidableCompositionLocal<Color> localContentColor10 = ContentColorKt.getLocalContentColor();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object objConsume10 = composerStartRestartGroup.consume(localContentColor10);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        jM6824unboximpl = ((Color) objConsume10).m6824unboximpl();
                        i9 = i8 & (-57345);
                    } else {
                        i9 = i8;
                    }
                    if ((i2 & 32) != 0) {
                        i9 &= -458753;
                        j3 = jM6824unboximpl;
                    }
                    if (i6 != 0) {
                        modifier4 = modifier2;
                        j6 = j3;
                        mutableInteractionSource2 = null;
                    } else {
                        modifier4 = modifier2;
                        j6 = j3;
                    }
                } else {
                    if (i11 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    }
                    if ((i2 & 16) != 0) {
                        ProvidableCompositionLocal<Color> localContentColor11 = ContentColorKt.getLocalContentColor();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object objConsume11 = composerStartRestartGroup.consume(localContentColor11);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        jM6824unboximpl = ((Color) objConsume11).m6824unboximpl();
                        i9 = i8 & (-57345);
                    } else {
                        i9 = i8;
                    }
                    if ((i2 & 32) != 0) {
                        i9 &= -458753;
                        j3 = jM6824unboximpl;
                    }
                    if (i6 != 0) {
                        modifier4 = modifier2;
                        j6 = j3;
                        mutableInteractionSource2 = null;
                    } else {
                        modifier4 = modifier2;
                        j6 = j3;
                    }
                }
                final boolean z12 = z3;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1573136853, i9, -1, "androidx.compose.material3.Tab (Tab.kt:237)");
                }
                final IndicationNodeFactory indicationNodeFactoryM4031rippleH2RKhps$default7 = RippleKt.m4031rippleH2RKhps$default(true, 0.0f, jM6824unboximpl, 2, null);
                int i110 = i9 >> 12;
                m4365TabTransitionKlgxPg(jM6824unboximpl, j6, z, ComposableLambdaKt.rememberComposableLambda(1128552423, true, new Function2() { // from class: androidx.compose.material3.TabKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return TabKt.Tab_bogVsAg$lambda$0(modifier4, z, mutableInteractionSource2, indicationNodeFactoryM4031rippleH2RKhps$default7, z12, function0, function3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, (i110 & 112) | (i110 & 14) | 3072 | ((i9 << 6) & 896));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                j4 = j6;
                modifier3 = modifier4;
                z5 = z12;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                z5 = z3;
                j4 = j3;
            }
            j5 = jM6824unboximpl;
            mutableInteractionSource3 = mutableInteractionSource2;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TabKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return TabKt.Tab_bogVsAg$lambda$1(z, function0, modifier3, z5, j5, j4, mutableInteractionSource3, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 3072;
        z3 = z2;
        if ((i & 24576) == 0) {
            if ((i2 & 16) == 0) {
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
        if ((196608 & i) == 0) {
            if ((i2 & 32) == 0) {
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
                ComposerKt.sourceInformation(composerStartRestartGroup, "233@10230L7");
                if ((i & 1) != 0) {
                    if (i11 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    }
                    if ((i2 & 16) != 0) {
                        ProvidableCompositionLocal<Color> localContentColor12 = ContentColorKt.getLocalContentColor();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object objConsume12 = composerStartRestartGroup.consume(localContentColor12);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        jM6824unboximpl = ((Color) objConsume12).m6824unboximpl();
                        i9 = i8 & (-57345);
                    } else {
                        i9 = i8;
                    }
                    if ((i2 & 32) != 0) {
                        i9 &= -458753;
                        j3 = jM6824unboximpl;
                    }
                    if (i6 != 0) {
                        modifier4 = modifier2;
                        j6 = j3;
                        mutableInteractionSource2 = null;
                    } else {
                        modifier4 = modifier2;
                        j6 = j3;
                    }
                } else {
                    if (i11 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    }
                    if ((i2 & 16) != 0) {
                        ProvidableCompositionLocal<Color> localContentColor13 = ContentColorKt.getLocalContentColor();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object objConsume13 = composerStartRestartGroup.consume(localContentColor13);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        jM6824unboximpl = ((Color) objConsume13).m6824unboximpl();
                        i9 = i8 & (-57345);
                    } else {
                        i9 = i8;
                    }
                    if ((i2 & 32) != 0) {
                        i9 &= -458753;
                        j3 = jM6824unboximpl;
                    }
                    if (i6 != 0) {
                        modifier4 = modifier2;
                        j6 = j3;
                        mutableInteractionSource2 = null;
                    } else {
                        modifier4 = modifier2;
                        j6 = j3;
                    }
                }
                final boolean z13 = z3;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1573136853, i9, -1, "androidx.compose.material3.Tab (Tab.kt:237)");
                }
                final IndicationNodeFactory indicationNodeFactoryM4031rippleH2RKhps$default8 = RippleKt.m4031rippleH2RKhps$default(true, 0.0f, jM6824unboximpl, 2, null);
                int i111 = i9 >> 12;
                m4365TabTransitionKlgxPg(jM6824unboximpl, j6, z, ComposableLambdaKt.rememberComposableLambda(1128552423, true, new Function2() { // from class: androidx.compose.material3.TabKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return TabKt.Tab_bogVsAg$lambda$0(modifier4, z, mutableInteractionSource2, indicationNodeFactoryM4031rippleH2RKhps$default8, z13, function0, function3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, (i111 & 112) | (i111 & 14) | 3072 | ((i9 << 6) & 896));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                j4 = j6;
                modifier3 = modifier4;
                z5 = z13;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                z5 = z3;
                j4 = j3;
            }
            j5 = jM6824unboximpl;
            mutableInteractionSource3 = mutableInteractionSource2;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TabKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return TabKt.Tab_bogVsAg$lambda$1(z, function0, modifier3, z5, j5, j4, mutableInteractionSource3, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 1572864;
        mutableInteractionSource2 = mutableInteractionSource;
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
            ComposerKt.sourceInformation(composerStartRestartGroup, "233@10230L7");
            if ((i & 1) != 0) {
                if (i11 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i4 != 0) {
                    z3 = true;
                }
                if ((i2 & 16) != 0) {
                    ProvidableCompositionLocal<Color> localContentColor14 = ContentColorKt.getLocalContentColor();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume14 = composerStartRestartGroup.consume(localContentColor14);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    jM6824unboximpl = ((Color) objConsume14).m6824unboximpl();
                    i9 = i8 & (-57345);
                } else {
                    i9 = i8;
                }
                if ((i2 & 32) != 0) {
                    i9 &= -458753;
                    j3 = jM6824unboximpl;
                }
                if (i6 != 0) {
                    modifier4 = modifier2;
                    j6 = j3;
                    mutableInteractionSource2 = null;
                } else {
                    modifier4 = modifier2;
                    j6 = j3;
                }
            } else {
                if (i11 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i4 != 0) {
                    z3 = true;
                }
                if ((i2 & 16) != 0) {
                    ProvidableCompositionLocal<Color> localContentColor15 = ContentColorKt.getLocalContentColor();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume15 = composerStartRestartGroup.consume(localContentColor15);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    jM6824unboximpl = ((Color) objConsume15).m6824unboximpl();
                    i9 = i8 & (-57345);
                } else {
                    i9 = i8;
                }
                if ((i2 & 32) != 0) {
                    i9 &= -458753;
                    j3 = jM6824unboximpl;
                }
                if (i6 != 0) {
                    modifier4 = modifier2;
                    j6 = j3;
                    mutableInteractionSource2 = null;
                } else {
                    modifier4 = modifier2;
                    j6 = j3;
                }
            }
            final boolean z14 = z3;
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1573136853, i9, -1, "androidx.compose.material3.Tab (Tab.kt:237)");
            }
            final IndicationNodeFactory indicationNodeFactoryM4031rippleH2RKhps$default9 = RippleKt.m4031rippleH2RKhps$default(true, 0.0f, jM6824unboximpl, 2, null);
            int i112 = i9 >> 12;
            m4365TabTransitionKlgxPg(jM6824unboximpl, j6, z, ComposableLambdaKt.rememberComposableLambda(1128552423, true, new Function2() { // from class: androidx.compose.material3.TabKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TabKt.Tab_bogVsAg$lambda$0(modifier4, z, mutableInteractionSource2, indicationNodeFactoryM4031rippleH2RKhps$default9, z14, function0, function3, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, (i112 & 112) | (i112 & 14) | 3072 | ((i9 << 6) & 896));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            j4 = j6;
            modifier3 = modifier4;
            z5 = z14;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
            z5 = z3;
            j4 = j3;
        }
        j5 = jM6824unboximpl;
        mutableInteractionSource3 = mutableInteractionSource2;
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TabKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TabKt.Tab_bogVsAg$lambda$1(z, function0, modifier3, z5, j5, j4, mutableInteractionSource3, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Tab_bogVsAg$lambda$0(Modifier modifier, boolean z, MutableInteractionSource mutableInteractionSource, IndicationNodeFactory indicationNodeFactory, boolean z2, Function0 function0, Function3 function3, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C244@10778L586:Tab.kt#uh7d8r");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1128552423, i, -1, "androidx.compose.material3.Tab.<anonymous> (Tab.kt:244)");
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
    private static final void m4365TabTransitionKlgxPg(final long j, final long j2, boolean z, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i) {
        int i2;
        final boolean z2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-833145221);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(TabTransition)N(activeColor:c#ui.graphics.Color,inactiveColor:c#ui.graphics.Color,selected,content)275@11802L26,278@11937L416,291@12358L77:Tab.kt#uh7d8r");
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
                ComposerKt.traceEventStart(-833145221, i2, -1, "androidx.compose.material3.TabTransition (Tab.kt:274)");
            }
            int i3 = i2 >> 6;
            Transition transitionUpdateTransition = TransitionKt.updateTransition(Boolean.valueOf(z2), (String) null, composerStartRestartGroup, i3 & 14, 2);
            Function3 function3 = new Function3() { // from class: androidx.compose.material3.TabKt$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return TabKt.TabTransition_Klgx_Pg$lambda$0((Transition.Segment) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            };
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1939694975, "CC(animateColor)P(2)67@3229L31,68@3296L58,70@3367L70:Transition.kt#xbi5r1");
            boolean zBooleanValue = ((Boolean) transitionUpdateTransition.getTargetState()).booleanValue();
            composerStartRestartGroup.startReplaceGroup(-1069234984);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CN(it):Tab.kt#uh7d8r");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1069234984, 0, -1, "androidx.compose.material3.TabTransition.<anonymous> (Tab.kt:289)");
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
            composerStartRestartGroup.startReplaceGroup(-1069234984);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CN(it):Tab.kt#uh7d8r");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1069234984, 0, -1, "androidx.compose.material3.TabTransition.<anonymous> (Tab.kt:289)");
            }
            long j4 = zBooleanValue2 ? j : j2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composerStartRestartGroup.endReplaceGroup();
            Color colorM6804boximpl = Color.m6804boximpl(j4);
            boolean zBooleanValue3 = ((Boolean) transitionUpdateTransition.getTargetState()).booleanValue();
            composerStartRestartGroup.startReplaceGroup(-1069234984);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CN(it):Tab.kt#uh7d8r");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1069234984, 0, -1, "androidx.compose.material3.TabTransition.<anonymous> (Tab.kt:289)");
            }
            long j5 = zBooleanValue3 ? j : j2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composerStartRestartGroup.endReplaceGroup();
            State stateCreateTransitionAnimation = TransitionKt.createTransitionAnimation(transitionUpdateTransition, colorM6804boximpl, Color.m6804boximpl(j5), (FiniteAnimationSpec) function3.invoke(transitionUpdateTransition.getSegment(), composerStartRestartGroup, 0), twoWayConverter, "ColorAnimation", composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m6804boximpl(TabTransition_Klgx_Pg$lambda$2(stateCreateTransitionAnimation))), function2, composerStartRestartGroup, ProvidedValue.$stable | (i3 & 112));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TabKt$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TabKt.TabTransition_Klgx_Pg$lambda$3(j, j2, z2, function2, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FiniteAnimationSpec TabTransition_Klgx_Pg$lambda$0(Transition.Segment segment, Composer composer, int i) {
        FiniteAnimationSpec finiteAnimationSpecValue;
        composer.startReplaceGroup(1058649156);
        ComposerKt.sourceInformation(composer, "C:Tab.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1058649156, i, -1, "androidx.compose.material3.TabTransition.<anonymous> (Tab.kt:280)");
        }
        if (segment.isTransitioningTo(false, true)) {
            composer.startReplaceGroup(272207019);
            ComposerKt.sourceInformation(composer, "282@12122L7");
            finiteAnimationSpecValue = MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultEffects, composer, 6);
            composer.endReplaceGroup();
        } else {
            composer.startReplaceGroup(272326989);
            ComposerKt.sourceInformation(composer, "285@12241L7");
            finiteAnimationSpecValue = MotionSchemeKt.value(MotionSchemeKeyTokens.FastEffects, composer, 6);
            composer.endReplaceGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return finiteAnimationSpecValue;
    }

    private static final void TabBaselineLayout(final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function3, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1349901398);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(TabBaselineLayout)N(text,icon)308@13077L2044,301@12833L2288:Tab.kt#uh7d8r");
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
                ComposerKt.traceEventStart(-1349901398, i2, -1, "androidx.compose.material3.TabBaselineLayout (Tab.kt:300)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -175107226, "CC(remember):Tab.kt#9igjgp");
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 870346887, "C:Tab.kt#uh7d8r");
            if (function2 == null) {
                composerStartRestartGroup.startReplaceGroup(857591905);
            } else {
                composerStartRestartGroup.startReplaceGroup(870361332);
                ComposerKt.sourceInformation(composerStartRestartGroup, "303@12882L85");
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
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1556388667, "C303@12959L6:Tab.kt#uh7d8r");
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
                composerStartRestartGroup.startReplaceGroup(870494880);
                ComposerKt.sourceInformation(composerStartRestartGroup, "306@13018L41");
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
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1144843236, "C306@13051L6:Tab.kt#uh7d8r");
                function3.invoke(composerStartRestartGroup, Integer.valueOf((i2 >> 3) & 14));
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            } else {
                composerStartRestartGroup.startReplaceGroup(857591905);
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TabKt$$ExternalSyntheticLambda9
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
        int iMo748roundToPx0680j_4 = density.mo748roundToPx0680j_4(f) + density.mo748roundToPx0680j_4(PrimaryNavigationTabTokens.INSTANCE.m5709getActiveIndicatorHeightD9Ej5fM());
        int height = (placeable2.getHeight() + density.mo747roundToPxR2X_6o(IconDistanceFromBaseline)) - i3;
        int i5 = (i2 - i4) - iMo748roundToPx0680j_4;
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable, (i - placeable.getWidth()) / 2, i5, 0.0f, 4, null);
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable2, (i - placeable2.getWidth()) / 2, i5 - height, 0.0f, 4, null);
    }

    public static final float getHorizontalTextPadding() {
        return HorizontalTextPadding;
    }

    private static final long TabTransition_Klgx_Pg$lambda$2(State<Color> state) {
        return state.getValue().m6824unboximpl();
    }
}
