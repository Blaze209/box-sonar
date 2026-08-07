package androidx.compose.material3;

import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.material3.tokens.NavigationBarHorizontalItemTokens;
import androidx.compose.material3.tokens.NavigationBarTokens;
import androidx.compose.material3.tokens.NavigationBarVerticalItemTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Dp;
import androidx.profileinstaller.ProfileVerifier;
import com.box.android.domain.metrics.hubs.HubsObservability;
import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: ShortNavigationBar.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\u001aT\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\u0011\u0010\u000b\u001a\r\u0012\u0004\u0012\u00020\u00010\f¢\u0006\u0002\b\rH\u0007¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u0081\u0001\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00010\f2\u0011\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00010\f¢\u0006\u0002\b\r2\u0013\u0010\u0015\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\f¢\u0006\u0002\b\r2\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0016\u001a\u00020\u00122\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0007¢\u0006\u0004\b\u001d\u0010\u001e\u001a\u0018\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020'2\u0006\u0010)\u001a\u00020'H\u0002\"\"\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0016\u0010*\u001a\u00020+X\u0080\u0004¢\u0006\n\n\u0002\u0010.\u001a\u0004\b,\u0010-\"\u0016\u0010/\u001a\u00020+X\u0080\u0004¢\u0006\n\n\u0002\u0010.\u001a\u0004\b0\u0010-\"\u0016\u00101\u001a\u00020+X\u0080\u0004¢\u0006\n\n\u0002\u0010.\u001a\u0004\b2\u0010-\"\u0016\u00103\u001a\u00020+X\u0080\u0004¢\u0006\n\n\u0002\u0010.\u001a\u0004\b4\u0010-\"\u0016\u00105\u001a\u00020+X\u0080\u0004¢\u0006\n\n\u0002\u0010.\u001a\u0004\b6\u0010-\"\u0016\u00107\u001a\u00020+X\u0080\u0004¢\u0006\n\n\u0002\u0010.\u001a\u0004\b8\u0010-\"\u0016\u00109\u001a\u00020+X\u0080\u0004¢\u0006\n\n\u0002\u0010.\u001a\u0004\b:\u0010-¨\u0006;"}, d2 = {"ShortNavigationBar", "", "modifier", "Landroidx/compose/ui/Modifier;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "windowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "arrangement", "Landroidx/compose/material3/ShortNavigationBarArrangement;", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "ShortNavigationBar-kQ6Tpik", "(Landroidx/compose/ui/Modifier;JJLandroidx/compose/foundation/layout/WindowInsets;ILkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "ShortNavigationBarItem", "selected", "", ViewProps.ON_CLICK, HubsObservability.HUB_ASSET_ICON, "label", "enabled", "iconPosition", "Landroidx/compose/material3/NavigationItemIconPosition;", "colors", "Landroidx/compose/material3/NavigationItemColors;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "ShortNavigationBarItem-6ZDA4I0", "(ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;ZILandroidx/compose/material3/NavigationItemColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "LocalShortNavigationBarOverride", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/compose/material3/ShortNavigationBarOverride;", "getLocalShortNavigationBarOverride$annotations", "()V", "getLocalShortNavigationBarOverride", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "calculateCenteredContentHorizontalPadding", "", "itemsCount", "barWidth", "TopIconItemVerticalPadding", "Landroidx/compose/ui/unit/Dp;", "getTopIconItemVerticalPadding", "()F", "F", "TopIconIndicatorVerticalPadding", "getTopIconIndicatorVerticalPadding", "TopIconIndicatorHorizontalPadding", "getTopIconIndicatorHorizontalPadding", "StartIconIndicatorVerticalPadding", "getStartIconIndicatorVerticalPadding", "TopIconIndicatorToLabelPadding", "getTopIconIndicatorToLabelPadding", "StartIconIndicatorHorizontalPadding", "getStartIconIndicatorHorizontalPadding", "StartIconToLabelPadding", "getStartIconToLabelPadding", "material3"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ShortNavigationBarKt {
    private static final float StartIconIndicatorVerticalPadding;
    private static final float TopIconIndicatorHorizontalPadding;
    private static final float TopIconIndicatorVerticalPadding;
    private static final ProvidableCompositionLocal<ShortNavigationBarOverride> LocalShortNavigationBarOverride = CompositionLocalKt.compositionLocalOf$default(null, new Function0() { // from class: androidx.compose.material3.ShortNavigationBarKt$$ExternalSyntheticLambda2
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return ShortNavigationBarKt.LocalShortNavigationBarOverride$lambda$0();
        }
    }, 1, null);
    private static final float TopIconItemVerticalPadding = NavigationBarVerticalItemTokens.INSTANCE.m5558getContainerBetweenSpaceD9Ej5fM();
    private static final float TopIconIndicatorToLabelPadding = Dp.m9687constructorimpl(4);
    private static final float StartIconIndicatorHorizontalPadding = NavigationBarHorizontalItemTokens.INSTANCE.m5548getActiveIndicatorLeadingSpaceD9Ej5fM();
    private static final float StartIconToLabelPadding = NavigationBarTokens.INSTANCE.m5553getItemActiveIndicatorIconLabelSpaceD9Ej5fM();

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ShortNavigationBarItem_6ZDA4I0$lambda$1(boolean z, Function0 function0, Function2 function2, Function2 function3, Modifier modifier, boolean z2, int i, NavigationItemColors navigationItemColors, MutableInteractionSource mutableInteractionSource, int i2, int i3, Composer composer, int i4) {
        m4175ShortNavigationBarItem6ZDA4I0(z, function0, function2, function3, modifier, z2, i, navigationItemColors, mutableInteractionSource, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ShortNavigationBar_kQ6Tpik$lambda$1(Modifier modifier, long j, long j2, WindowInsets windowInsets, int i, Function2 function2, int i2, int i3, Composer composer, int i4) {
        m4174ShortNavigationBarkQ6Tpik(modifier, j, j2, windowInsets, i, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ void getLocalShortNavigationBarOverride$annotations() {
    }

    /* JADX WARN: Code duplicated, block: B:108:0x014a  */
    /* JADX WARN: Code duplicated, block: B:111:0x0177  */
    /* JADX INFO: renamed from: ShortNavigationBar-kQ6Tpik, reason: not valid java name */
    public static final void m4174ShortNavigationBarkQ6Tpik(Modifier modifier, long j, long j2, WindowInsets windowInsets, int i, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i2, final int i3) {
        Modifier modifier2;
        int i4;
        long containerColor;
        long contentColor;
        WindowInsets windowInsets2;
        int i5;
        Function2<? super Composer, ? super Integer, Unit> function3;
        Modifier modifier3;
        final long j3;
        final long j4;
        final WindowInsets windowInsets3;
        final int i6;
        int iM4172getArrangementLnnQw40;
        long j5;
        WindowInsets windowInsets4;
        Composer composerStartRestartGroup = composer.startRestartGroup(552087412);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ShortNavigationBar)N(modifier,containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,windowInsets,arrangement:c#material3.ShortNavigationBarArrangement,content)103@4941L7,*112@5274L20:ShortNavigationBar.kt#uh7d8r");
        int i7 = i3 & 1;
        if (i7 != 0) {
            i4 = i2 | 6;
            modifier2 = modifier;
        } else if ((i2 & 6) == 0) {
            modifier2 = modifier;
            i4 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i2;
        } else {
            modifier2 = modifier;
            i4 = i2;
        }
        if ((i2 & 48) == 0) {
            if ((i3 & 2) == 0) {
                containerColor = j;
                int i8 = composerStartRestartGroup.changed(containerColor) ? 32 : 16;
                i4 |= i8;
            } else {
                containerColor = j;
            }
            i4 |= i8;
        } else {
            containerColor = j;
        }
        if ((i2 & 384) == 0) {
            if ((i3 & 4) == 0) {
                contentColor = j2;
                int i9 = composerStartRestartGroup.changed(contentColor) ? 256 : 128;
                i4 |= i9;
            } else {
                contentColor = j2;
            }
            i4 |= i9;
        } else {
            contentColor = j2;
        }
        if ((i2 & 3072) == 0) {
            if ((i3 & 8) == 0) {
                windowInsets2 = windowInsets;
                int i10 = composerStartRestartGroup.changed(windowInsets2) ? 2048 : 1024;
                i4 |= i10;
            } else {
                windowInsets2 = windowInsets;
            }
            i4 |= i10;
        } else {
            windowInsets2 = windowInsets;
        }
        if ((i2 & 24576) == 0) {
            if ((i3 & 16) == 0) {
                i5 = i;
                int i11 = composerStartRestartGroup.changed(i5) ? 16384 : 8192;
                i4 |= i11;
            } else {
                i5 = i;
            }
            i4 |= i11;
        } else {
            i5 = i;
        }
        if ((196608 & i2) == 0) {
            function3 = function2;
            i4 |= composerStartRestartGroup.changedInstance(function3) ? 131072 : 65536;
        } else {
            function3 = function2;
        }
        if (composerStartRestartGroup.shouldExecute((74899 & i4) != 74898, i4 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "97@4613L14,98@4682L12,99@4756L12");
            if ((i2 & 1) != 0 && !composerStartRestartGroup.getDefaultsInvalid()) {
                composerStartRestartGroup.skipToGroupEnd();
                if ((i3 & 2) != 0) {
                    i4 &= -113;
                }
                if ((i3 & 4) != 0) {
                    i4 &= -897;
                }
                if ((i3 & 8) != 0) {
                    i4 &= -7169;
                }
                if ((i3 & 16) != 0) {
                    i4 &= -57345;
                }
                modifier3 = modifier2;
            } else {
                Modifier.Companion companion = i7 != 0 ? Modifier.INSTANCE : modifier2;
                if ((i3 & 2) != 0) {
                    containerColor = ShortNavigationBarDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                    i4 &= -113;
                }
                if ((i3 & 4) != 0) {
                    contentColor = ShortNavigationBarDefaults.INSTANCE.getContentColor(composerStartRestartGroup, 6);
                    i4 &= -897;
                }
                if ((i3 & 8) != 0) {
                    i4 &= -7169;
                    windowInsets2 = ShortNavigationBarDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, 6);
                }
                if ((i3 & 16) != 0) {
                    i4 &= -57345;
                    modifier3 = companion;
                    iM4172getArrangementLnnQw40 = ShortNavigationBarDefaults.INSTANCE.m4172getArrangementLnnQw40();
                    j5 = contentColor;
                    windowInsets4 = windowInsets2;
                } else {
                    modifier3 = companion;
                }
                long j6 = containerColor;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(552087412, i4, -1, "androidx.compose.material3.ShortNavigationBar (ShortNavigationBar.kt:102)");
                }
                ProvidableCompositionLocal<ShortNavigationBarOverride> providableCompositionLocal = LocalShortNavigationBarOverride;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume = composerStartRestartGroup.consume(providableCompositionLocal);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ((ShortNavigationBarOverride) objConsume).ShortNavigationBar(new ShortNavigationBarOverrideScope(modifier3, j6, j5, windowInsets4, iM4172getArrangementLnnQw40, function3, null), composerStartRestartGroup, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                j3 = j6;
                j4 = j5;
                windowInsets3 = windowInsets4;
                i6 = iM4172getArrangementLnnQw40;
            }
            j5 = contentColor;
            windowInsets4 = windowInsets2;
            iM4172getArrangementLnnQw40 = i5;
            long j7 = containerColor;
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(552087412, i4, -1, "androidx.compose.material3.ShortNavigationBar (ShortNavigationBar.kt:102)");
            }
            ProvidableCompositionLocal<ShortNavigationBarOverride> providableCompositionLocal2 = LocalShortNavigationBarOverride;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume2 = composerStartRestartGroup.consume(providableCompositionLocal2);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ((ShortNavigationBarOverride) objConsume2).ShortNavigationBar(new ShortNavigationBarOverrideScope(modifier3, j7, j5, windowInsets4, iM4172getArrangementLnnQw40, function3, null), composerStartRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            j3 = j7;
            j4 = j5;
            windowInsets3 = windowInsets4;
            i6 = iM4172getArrangementLnnQw40;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
            j3 = containerColor;
            j4 = contentColor;
            windowInsets3 = windowInsets2;
            i6 = i5;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier4 = modifier3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ShortNavigationBarKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ShortNavigationBarKt.ShortNavigationBar_kQ6Tpik$lambda$1(modifier4, j3, j4, windowInsets3, i6, function2, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX WARN: Code duplicated, block: B:102:0x013d A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:103:0x013f  */
    /* JADX WARN: Code duplicated, block: B:105:0x0146  */
    /* JADX WARN: Code duplicated, block: B:107:0x014a  */
    /* JADX WARN: Code duplicated, block: B:110:0x0155  */
    /* JADX WARN: Code duplicated, block: B:111:0x015f  */
    /* JADX WARN: Code duplicated, block: B:113:0x0163  */
    /* JADX WARN: Code duplicated, block: B:114:0x0165  */
    /* JADX WARN: Code duplicated, block: B:117:0x0171  */
    /* JADX WARN: Code duplicated, block: B:119:0x017c  */
    /* JADX WARN: Code duplicated, block: B:121:0x019b  */
    /* JADX WARN: Code duplicated, block: B:123:0x01ad  */
    /* JADX WARN: Code duplicated, block: B:126:0x01c4  */
    /* JADX WARN: Code duplicated, block: B:127:0x01c7  */
    /* JADX WARN: Code duplicated, block: B:130:0x01cd  */
    /* JADX WARN: Code duplicated, block: B:131:0x01d0  */
    /* JADX WARN: Code duplicated, block: B:134:0x022a  */
    /* JADX WARN: Code duplicated, block: B:136:0x0237  */
    /* JADX WARN: Code duplicated, block: B:139:0x0247  */
    /* JADX WARN: Code duplicated, block: B:141:? A[RETURN, SYNTHETIC] */
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
    /* JADX WARN: Code duplicated, block: B:66:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:68:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:70:0x00bf  */
    /* JADX WARN: Code duplicated, block: B:71:0x00c2  */
    /* JADX WARN: Code duplicated, block: B:74:0x00c9  */
    /* JADX WARN: Code duplicated, block: B:77:0x00d1  */
    /* JADX WARN: Code duplicated, block: B:78:0x00d4  */
    /* JADX WARN: Code duplicated, block: B:80:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:82:0x00e2  */
    /* JADX WARN: Code duplicated, block: B:83:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:88:0x00fc  */
    /* JADX WARN: Code duplicated, block: B:89:0x00ff  */
    /* JADX WARN: Code duplicated, block: B:92:0x0108  */
    /* JADX WARN: Code duplicated, block: B:94:0x0118  */
    /* JADX INFO: renamed from: ShortNavigationBarItem-6ZDA4I0, reason: not valid java name */
    public static final void m4175ShortNavigationBarItem6ZDA4I0(final boolean z, final Function0<Unit> function0, final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function3, Modifier modifier, boolean z2, int i, NavigationItemColors navigationItemColors, MutableInteractionSource mutableInteractionSource, Composer composer, final int i2, final int i3) {
        int i4;
        final Modifier modifier2;
        int i5;
        boolean z3;
        int i6;
        int i7;
        int iM3895getTopxw1Ddg;
        int i8;
        NavigationItemColors navigationItemColorsColors;
        int i9;
        int i10;
        int i11;
        boolean z4;
        Composer composer2;
        final boolean z5;
        final int i12;
        final NavigationItemColors navigationItemColors2;
        final MutableInteractionSource mutableInteractionSource2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i13;
        MutableInteractionSource mutableInteractionSource3;
        Modifier modifier3;
        boolean z6;
        NavigationItemColors navigationItemColors3;
        MutableInteractionSource mutableInteractionSource4;
        boolean zM3890equalsimpl0;
        float f;
        float f2;
        Object objRememberedValue;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1164996656);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ShortNavigationBarItem)N(selected,onClick,icon,label,modifier,enabled,iconPosition:c#material3.NavigationItemIconPosition,colors,interactionSource)243@10657L5,244@10734L5,239@10505L842:ShortNavigationBar.kt#uh7d8r");
        if ((i2 & 6) == 0) {
            i4 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i2;
        } else {
            i4 = i2;
        }
        if ((i2 & 48) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(function0) ? 32 : 16;
        }
        if ((i2 & 384) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(function2) ? 256 : 128;
        }
        if ((i2 & 3072) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(function3) ? 2048 : 1024;
        }
        int i14 = i3 & 16;
        if (i14 == 0) {
            if ((i2 & 24576) == 0) {
                modifier2 = modifier;
                i4 |= composerStartRestartGroup.changed(modifier2) ? 16384 : 8192;
            }
            i5 = i3 & 32;
            if (i5 != 0) {
                if ((196608 & i2) == 0) {
                    z3 = z2;
                    if (composerStartRestartGroup.changed(z3)) {
                        i6 = 131072;
                    } else {
                        i6 = 65536;
                    }
                    i4 |= i6;
                }
                i7 = i3 & 64;
                if (i7 != 0) {
                    if ((1572864 & i2) == 0) {
                        iM3895getTopxw1Ddg = i;
                        if (composerStartRestartGroup.changed(iM3895getTopxw1Ddg)) {
                            i8 = 1048576;
                        } else {
                            i8 = 524288;
                        }
                        i4 |= i8;
                    }
                    if ((12582912 & i2) == 0) {
                        if ((i3 & 128) == 0) {
                            navigationItemColorsColors = navigationItemColors;
                            int i15 = composerStartRestartGroup.changed(navigationItemColorsColors) ? 8388608 : 4194304;
                            i4 |= i15;
                        } else {
                            navigationItemColorsColors = navigationItemColors;
                        }
                        i4 |= i15;
                    } else {
                        navigationItemColorsColors = navigationItemColors;
                    }
                    i9 = i3 & 256;
                    if (i9 != 0) {
                        if ((i2 & 100663296) == 0) {
                            if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                                i10 = 67108864;
                            } else {
                                i10 = 33554432;
                            }
                            i4 |= i10;
                        }
                        i11 = i4;
                        if ((i4 & 38347923) != 38347922) {
                            z4 = true;
                        } else {
                            z4 = false;
                        }
                        if (composerStartRestartGroup.shouldExecute(z4, i11 & 1)) {
                            composerStartRestartGroup.startDefaults();
                            ComposerKt.sourceInformation(composerStartRestartGroup, "219@9856L8");
                            if ((i2 & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                if (i14 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                if (i5 != 0) {
                                    z3 = true;
                                }
                                if (i7 != 0) {
                                    iM3895getTopxw1Ddg = NavigationItemIconPosition.INSTANCE.m3895getTopxw1Ddg();
                                }
                                if ((i3 & 128) != 0) {
                                    i13 = i11 & (-29360129);
                                    navigationItemColorsColors = ShortNavigationBarItemDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                                } else {
                                    i13 = i11;
                                }
                                if (i9 != 0) {
                                    mutableInteractionSource3 = null;
                                } else {
                                    mutableInteractionSource3 = mutableInteractionSource;
                                }
                            } else {
                                composerStartRestartGroup.skipToGroupEnd();
                                if ((i3 & 128) != 0) {
                                    i13 = i11 & (-29360129);
                                    modifier3 = modifier2;
                                    z6 = z3;
                                    navigationItemColors3 = navigationItemColorsColors;
                                    mutableInteractionSource3 = mutableInteractionSource;
                                } else {
                                    mutableInteractionSource3 = mutableInteractionSource;
                                    i13 = i11;
                                }
                                composerStartRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1164996656, i13, -1, "androidx.compose.material3.ShortNavigationBarItem (ShortNavigationBar.kt:221)");
                                }
                                if (mutableInteractionSource3 == null) {
                                    composerStartRestartGroup.startReplaceGroup(1215846219);
                                    ComposerKt.sourceInformation(composerStartRestartGroup, "223@10008L39");
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1424694167, "CC(remember):ShortNavigationBar.kt#9igjgp");
                                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                    }
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                    composerStartRestartGroup.endReplaceGroup();
                                    mutableInteractionSource4 = (MutableInteractionSource) objRememberedValue;
                                } else {
                                    composerStartRestartGroup.startReplaceGroup(1424693516);
                                    composerStartRestartGroup.endReplaceGroup();
                                    mutableInteractionSource4 = mutableInteractionSource3;
                                }
                                zM3890equalsimpl0 = NavigationItemIconPosition.m3890equalsimpl0(iM3895getTopxw1Ddg, NavigationItemIconPosition.INSTANCE.m3895getTopxw1Ddg());
                                if (zM3890equalsimpl0) {
                                    f = TopIconIndicatorHorizontalPadding;
                                } else {
                                    f = StartIconIndicatorHorizontalPadding;
                                }
                                float f3 = f;
                                if (zM3890equalsimpl0) {
                                    f2 = TopIconIndicatorVerticalPadding;
                                } else {
                                    f2 = StartIconIndicatorVerticalPadding;
                                }
                                int i16 = i13 >> 6;
                                composer2 = composerStartRestartGroup;
                                int i17 = iM3895getTopxw1Ddg;
                                NavigationItemKt.m3905NavigationItem8Df7sds(z, function0, function2, TypographyKt.getValue(NavigationBarTokens.INSTANCE.getLabelTextFont(), composerStartRestartGroup, 6), ShapesKt.getValue(NavigationBarTokens.INSTANCE.getItemActiveIndicatorShape(), composerStartRestartGroup, 6), NavigationBarVerticalItemTokens.INSTANCE.m5557getActiveIndicatorWidthD9Ej5fM(), f3, f2, TopIconIndicatorToLabelPadding, StartIconToLabelPadding, TopIconItemVerticalPadding, navigationItemColors3, modifier3, z6, function3, i17, mutableInteractionSource4, composer2, (i13 & 14) | 906166272 | (i13 & 112) | (i13 & 896), 6 | ((i13 >> 18) & 112) | (i16 & 896) | (i16 & 7168) | ((i13 << 3) & 57344) | ((i13 >> 3) & 458752));
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                mutableInteractionSource2 = mutableInteractionSource3;
                                navigationItemColors2 = navigationItemColors3;
                                modifier2 = modifier3;
                                z5 = z6;
                                i12 = i17;
                            }
                            modifier3 = modifier2;
                            z6 = z3;
                            navigationItemColors3 = navigationItemColorsColors;
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1164996656, i13, -1, "androidx.compose.material3.ShortNavigationBarItem (ShortNavigationBar.kt:221)");
                            }
                            if (mutableInteractionSource3 == null) {
                                composerStartRestartGroup.startReplaceGroup(1215846219);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "223@10008L39");
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1424694167, "CC(remember):ShortNavigationBar.kt#9igjgp");
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                composerStartRestartGroup.endReplaceGroup();
                                mutableInteractionSource4 = (MutableInteractionSource) objRememberedValue;
                            } else {
                                composerStartRestartGroup.startReplaceGroup(1424693516);
                                composerStartRestartGroup.endReplaceGroup();
                                mutableInteractionSource4 = mutableInteractionSource3;
                            }
                            zM3890equalsimpl0 = NavigationItemIconPosition.m3890equalsimpl0(iM3895getTopxw1Ddg, NavigationItemIconPosition.INSTANCE.m3895getTopxw1Ddg());
                            if (zM3890equalsimpl0) {
                                f = TopIconIndicatorHorizontalPadding;
                            } else {
                                f = StartIconIndicatorHorizontalPadding;
                            }
                            float f4 = f;
                            if (zM3890equalsimpl0) {
                                f2 = TopIconIndicatorVerticalPadding;
                            } else {
                                f2 = StartIconIndicatorVerticalPadding;
                            }
                            int i18 = i13 >> 6;
                            composer2 = composerStartRestartGroup;
                            int i19 = iM3895getTopxw1Ddg;
                            NavigationItemKt.m3905NavigationItem8Df7sds(z, function0, function2, TypographyKt.getValue(NavigationBarTokens.INSTANCE.getLabelTextFont(), composerStartRestartGroup, 6), ShapesKt.getValue(NavigationBarTokens.INSTANCE.getItemActiveIndicatorShape(), composerStartRestartGroup, 6), NavigationBarVerticalItemTokens.INSTANCE.m5557getActiveIndicatorWidthD9Ej5fM(), f4, f2, TopIconIndicatorToLabelPadding, StartIconToLabelPadding, TopIconItemVerticalPadding, navigationItemColors3, modifier3, z6, function3, i19, mutableInteractionSource4, composer2, (i13 & 14) | 906166272 | (i13 & 112) | (i13 & 896), 6 | ((i13 >> 18) & 112) | (i18 & 896) | (i18 & 7168) | ((i13 << 3) & 57344) | ((i13 >> 3) & 458752));
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            mutableInteractionSource2 = mutableInteractionSource3;
                            navigationItemColors2 = navigationItemColors3;
                            modifier2 = modifier3;
                            z5 = z6;
                            i12 = i19;
                        } else {
                            composer2 = composerStartRestartGroup;
                            composer2.skipToGroupEnd();
                            z5 = z3;
                            i12 = iM3895getTopxw1Ddg;
                            navigationItemColors2 = navigationItemColorsColors;
                            mutableInteractionSource2 = mutableInteractionSource;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ShortNavigationBarKt$$ExternalSyntheticLambda1
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return ShortNavigationBarKt.ShortNavigationBarItem_6ZDA4I0$lambda$1(z, function0, function2, function3, modifier2, z5, i12, navigationItemColors2, mutableInteractionSource2, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                        }
                    }
                    i4 |= 100663296;
                    i11 = i4;
                    if ((i4 & 38347923) != 38347922) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z4, i11 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "219@9856L8");
                        if ((i2 & 1) != 0) {
                            if (i14 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i5 != 0) {
                                z3 = true;
                            }
                            if (i7 != 0) {
                                iM3895getTopxw1Ddg = NavigationItemIconPosition.INSTANCE.m3895getTopxw1Ddg();
                            }
                            if ((i3 & 128) != 0) {
                                i13 = i11 & (-29360129);
                                navigationItemColorsColors = ShortNavigationBarItemDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                            } else {
                                i13 = i11;
                            }
                            if (i9 != 0) {
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            modifier3 = modifier2;
                            z6 = z3;
                            navigationItemColors3 = navigationItemColorsColors;
                        } else {
                            if (i14 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i5 != 0) {
                                z3 = true;
                            }
                            if (i7 != 0) {
                                iM3895getTopxw1Ddg = NavigationItemIconPosition.INSTANCE.m3895getTopxw1Ddg();
                            }
                            if ((i3 & 128) != 0) {
                                i13 = i11 & (-29360129);
                                navigationItemColorsColors = ShortNavigationBarItemDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                            } else {
                                i13 = i11;
                            }
                            if (i9 != 0) {
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            modifier3 = modifier2;
                            z6 = z3;
                            navigationItemColors3 = navigationItemColorsColors;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1164996656, i13, -1, "androidx.compose.material3.ShortNavigationBarItem (ShortNavigationBar.kt:221)");
                        }
                        if (mutableInteractionSource3 == null) {
                            composerStartRestartGroup.startReplaceGroup(1215846219);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "223@10008L39");
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1424694167, "CC(remember):ShortNavigationBar.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            composerStartRestartGroup.endReplaceGroup();
                            mutableInteractionSource4 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            composerStartRestartGroup.startReplaceGroup(1424693516);
                            composerStartRestartGroup.endReplaceGroup();
                            mutableInteractionSource4 = mutableInteractionSource3;
                        }
                        zM3890equalsimpl0 = NavigationItemIconPosition.m3890equalsimpl0(iM3895getTopxw1Ddg, NavigationItemIconPosition.INSTANCE.m3895getTopxw1Ddg());
                        if (zM3890equalsimpl0) {
                            f = TopIconIndicatorHorizontalPadding;
                        } else {
                            f = StartIconIndicatorHorizontalPadding;
                        }
                        float f5 = f;
                        if (zM3890equalsimpl0) {
                            f2 = TopIconIndicatorVerticalPadding;
                        } else {
                            f2 = StartIconIndicatorVerticalPadding;
                        }
                        int i110 = i13 >> 6;
                        composer2 = composerStartRestartGroup;
                        int i111 = iM3895getTopxw1Ddg;
                        NavigationItemKt.m3905NavigationItem8Df7sds(z, function0, function2, TypographyKt.getValue(NavigationBarTokens.INSTANCE.getLabelTextFont(), composerStartRestartGroup, 6), ShapesKt.getValue(NavigationBarTokens.INSTANCE.getItemActiveIndicatorShape(), composerStartRestartGroup, 6), NavigationBarVerticalItemTokens.INSTANCE.m5557getActiveIndicatorWidthD9Ej5fM(), f5, f2, TopIconIndicatorToLabelPadding, StartIconToLabelPadding, TopIconItemVerticalPadding, navigationItemColors3, modifier3, z6, function3, i111, mutableInteractionSource4, composer2, (i13 & 14) | 906166272 | (i13 & 112) | (i13 & 896), 6 | ((i13 >> 18) & 112) | (i110 & 896) | (i110 & 7168) | ((i13 << 3) & 57344) | ((i13 >> 3) & 458752));
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        mutableInteractionSource2 = mutableInteractionSource3;
                        navigationItemColors2 = navigationItemColors3;
                        modifier2 = modifier3;
                        z5 = z6;
                        i12 = i111;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        z5 = z3;
                        i12 = iM3895getTopxw1Ddg;
                        navigationItemColors2 = navigationItemColorsColors;
                        mutableInteractionSource2 = mutableInteractionSource;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ShortNavigationBarKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return ShortNavigationBarKt.ShortNavigationBarItem_6ZDA4I0$lambda$1(z, function0, function2, function3, modifier2, z5, i12, navigationItemColors2, mutableInteractionSource2, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i4 |= 1572864;
                iM3895getTopxw1Ddg = i;
                if ((12582912 & i2) == 0) {
                    if ((i3 & 128) == 0) {
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
                i9 = i3 & 256;
                if (i9 != 0) {
                    if ((i2 & 100663296) == 0) {
                        if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                            i10 = 67108864;
                        } else {
                            i10 = 33554432;
                        }
                        i4 |= i10;
                    }
                    i11 = i4;
                    if ((i4 & 38347923) != 38347922) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z4, i11 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "219@9856L8");
                        if ((i2 & 1) != 0) {
                            if (i14 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i5 != 0) {
                                z3 = true;
                            }
                            if (i7 != 0) {
                                iM3895getTopxw1Ddg = NavigationItemIconPosition.INSTANCE.m3895getTopxw1Ddg();
                            }
                            if ((i3 & 128) != 0) {
                                i13 = i11 & (-29360129);
                                navigationItemColorsColors = ShortNavigationBarItemDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                            } else {
                                i13 = i11;
                            }
                            if (i9 != 0) {
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            modifier3 = modifier2;
                            z6 = z3;
                            navigationItemColors3 = navigationItemColorsColors;
                        } else {
                            if (i14 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i5 != 0) {
                                z3 = true;
                            }
                            if (i7 != 0) {
                                iM3895getTopxw1Ddg = NavigationItemIconPosition.INSTANCE.m3895getTopxw1Ddg();
                            }
                            if ((i3 & 128) != 0) {
                                i13 = i11 & (-29360129);
                                navigationItemColorsColors = ShortNavigationBarItemDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                            } else {
                                i13 = i11;
                            }
                            if (i9 != 0) {
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            modifier3 = modifier2;
                            z6 = z3;
                            navigationItemColors3 = navigationItemColorsColors;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1164996656, i13, -1, "androidx.compose.material3.ShortNavigationBarItem (ShortNavigationBar.kt:221)");
                        }
                        if (mutableInteractionSource3 == null) {
                            composerStartRestartGroup.startReplaceGroup(1215846219);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "223@10008L39");
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1424694167, "CC(remember):ShortNavigationBar.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            composerStartRestartGroup.endReplaceGroup();
                            mutableInteractionSource4 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            composerStartRestartGroup.startReplaceGroup(1424693516);
                            composerStartRestartGroup.endReplaceGroup();
                            mutableInteractionSource4 = mutableInteractionSource3;
                        }
                        zM3890equalsimpl0 = NavigationItemIconPosition.m3890equalsimpl0(iM3895getTopxw1Ddg, NavigationItemIconPosition.INSTANCE.m3895getTopxw1Ddg());
                        if (zM3890equalsimpl0) {
                            f = TopIconIndicatorHorizontalPadding;
                        } else {
                            f = StartIconIndicatorHorizontalPadding;
                        }
                        float f6 = f;
                        if (zM3890equalsimpl0) {
                            f2 = TopIconIndicatorVerticalPadding;
                        } else {
                            f2 = StartIconIndicatorVerticalPadding;
                        }
                        int i112 = i13 >> 6;
                        composer2 = composerStartRestartGroup;
                        int i113 = iM3895getTopxw1Ddg;
                        NavigationItemKt.m3905NavigationItem8Df7sds(z, function0, function2, TypographyKt.getValue(NavigationBarTokens.INSTANCE.getLabelTextFont(), composerStartRestartGroup, 6), ShapesKt.getValue(NavigationBarTokens.INSTANCE.getItemActiveIndicatorShape(), composerStartRestartGroup, 6), NavigationBarVerticalItemTokens.INSTANCE.m5557getActiveIndicatorWidthD9Ej5fM(), f6, f2, TopIconIndicatorToLabelPadding, StartIconToLabelPadding, TopIconItemVerticalPadding, navigationItemColors3, modifier3, z6, function3, i113, mutableInteractionSource4, composer2, (i13 & 14) | 906166272 | (i13 & 112) | (i13 & 896), 6 | ((i13 >> 18) & 112) | (i112 & 896) | (i112 & 7168) | ((i13 << 3) & 57344) | ((i13 >> 3) & 458752));
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        mutableInteractionSource2 = mutableInteractionSource3;
                        navigationItemColors2 = navigationItemColors3;
                        modifier2 = modifier3;
                        z5 = z6;
                        i12 = i113;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        z5 = z3;
                        i12 = iM3895getTopxw1Ddg;
                        navigationItemColors2 = navigationItemColorsColors;
                        mutableInteractionSource2 = mutableInteractionSource;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ShortNavigationBarKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return ShortNavigationBarKt.ShortNavigationBarItem_6ZDA4I0$lambda$1(z, function0, function2, function3, modifier2, z5, i12, navigationItemColors2, mutableInteractionSource2, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i4 |= 100663296;
                i11 = i4;
                if ((i4 & 38347923) != 38347922) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z4, i11 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "219@9856L8");
                    if ((i2 & 1) != 0) {
                        if (i14 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i5 != 0) {
                            z3 = true;
                        }
                        if (i7 != 0) {
                            iM3895getTopxw1Ddg = NavigationItemIconPosition.INSTANCE.m3895getTopxw1Ddg();
                        }
                        if ((i3 & 128) != 0) {
                            i13 = i11 & (-29360129);
                            navigationItemColorsColors = ShortNavigationBarItemDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                        } else {
                            i13 = i11;
                        }
                        if (i9 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        modifier3 = modifier2;
                        z6 = z3;
                        navigationItemColors3 = navigationItemColorsColors;
                    } else {
                        if (i14 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i5 != 0) {
                            z3 = true;
                        }
                        if (i7 != 0) {
                            iM3895getTopxw1Ddg = NavigationItemIconPosition.INSTANCE.m3895getTopxw1Ddg();
                        }
                        if ((i3 & 128) != 0) {
                            i13 = i11 & (-29360129);
                            navigationItemColorsColors = ShortNavigationBarItemDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                        } else {
                            i13 = i11;
                        }
                        if (i9 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        modifier3 = modifier2;
                        z6 = z3;
                        navigationItemColors3 = navigationItemColorsColors;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1164996656, i13, -1, "androidx.compose.material3.ShortNavigationBarItem (ShortNavigationBar.kt:221)");
                    }
                    if (mutableInteractionSource3 == null) {
                        composerStartRestartGroup.startReplaceGroup(1215846219);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "223@10008L39");
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1424694167, "CC(remember):ShortNavigationBar.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.endReplaceGroup();
                        mutableInteractionSource4 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        composerStartRestartGroup.startReplaceGroup(1424693516);
                        composerStartRestartGroup.endReplaceGroup();
                        mutableInteractionSource4 = mutableInteractionSource3;
                    }
                    zM3890equalsimpl0 = NavigationItemIconPosition.m3890equalsimpl0(iM3895getTopxw1Ddg, NavigationItemIconPosition.INSTANCE.m3895getTopxw1Ddg());
                    if (zM3890equalsimpl0) {
                        f = TopIconIndicatorHorizontalPadding;
                    } else {
                        f = StartIconIndicatorHorizontalPadding;
                    }
                    float f7 = f;
                    if (zM3890equalsimpl0) {
                        f2 = TopIconIndicatorVerticalPadding;
                    } else {
                        f2 = StartIconIndicatorVerticalPadding;
                    }
                    int i114 = i13 >> 6;
                    composer2 = composerStartRestartGroup;
                    int i115 = iM3895getTopxw1Ddg;
                    NavigationItemKt.m3905NavigationItem8Df7sds(z, function0, function2, TypographyKt.getValue(NavigationBarTokens.INSTANCE.getLabelTextFont(), composerStartRestartGroup, 6), ShapesKt.getValue(NavigationBarTokens.INSTANCE.getItemActiveIndicatorShape(), composerStartRestartGroup, 6), NavigationBarVerticalItemTokens.INSTANCE.m5557getActiveIndicatorWidthD9Ej5fM(), f7, f2, TopIconIndicatorToLabelPadding, StartIconToLabelPadding, TopIconItemVerticalPadding, navigationItemColors3, modifier3, z6, function3, i115, mutableInteractionSource4, composer2, (i13 & 14) | 906166272 | (i13 & 112) | (i13 & 896), 6 | ((i13 >> 18) & 112) | (i114 & 896) | (i114 & 7168) | ((i13 << 3) & 57344) | ((i13 >> 3) & 458752));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    mutableInteractionSource2 = mutableInteractionSource3;
                    navigationItemColors2 = navigationItemColors3;
                    modifier2 = modifier3;
                    z5 = z6;
                    i12 = i115;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    z5 = z3;
                    i12 = iM3895getTopxw1Ddg;
                    navigationItemColors2 = navigationItemColorsColors;
                    mutableInteractionSource2 = mutableInteractionSource;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ShortNavigationBarKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ShortNavigationBarKt.ShortNavigationBarItem_6ZDA4I0$lambda$1(z, function0, function2, function3, modifier2, z5, i12, navigationItemColors2, mutableInteractionSource2, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            z3 = z2;
            i7 = i3 & 64;
            if (i7 != 0) {
                if ((1572864 & i2) == 0) {
                    iM3895getTopxw1Ddg = i;
                    if (composerStartRestartGroup.changed(iM3895getTopxw1Ddg)) {
                        i8 = 1048576;
                    } else {
                        i8 = 524288;
                    }
                    i4 |= i8;
                }
                if ((12582912 & i2) == 0) {
                    if ((i3 & 128) == 0) {
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
                i9 = i3 & 256;
                if (i9 != 0) {
                    if ((i2 & 100663296) == 0) {
                        if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                            i10 = 67108864;
                        } else {
                            i10 = 33554432;
                        }
                        i4 |= i10;
                    }
                    i11 = i4;
                    if ((i4 & 38347923) != 38347922) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z4, i11 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "219@9856L8");
                        if ((i2 & 1) != 0) {
                            if (i14 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i5 != 0) {
                                z3 = true;
                            }
                            if (i7 != 0) {
                                iM3895getTopxw1Ddg = NavigationItemIconPosition.INSTANCE.m3895getTopxw1Ddg();
                            }
                            if ((i3 & 128) != 0) {
                                i13 = i11 & (-29360129);
                                navigationItemColorsColors = ShortNavigationBarItemDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                            } else {
                                i13 = i11;
                            }
                            if (i9 != 0) {
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            modifier3 = modifier2;
                            z6 = z3;
                            navigationItemColors3 = navigationItemColorsColors;
                        } else {
                            if (i14 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i5 != 0) {
                                z3 = true;
                            }
                            if (i7 != 0) {
                                iM3895getTopxw1Ddg = NavigationItemIconPosition.INSTANCE.m3895getTopxw1Ddg();
                            }
                            if ((i3 & 128) != 0) {
                                i13 = i11 & (-29360129);
                                navigationItemColorsColors = ShortNavigationBarItemDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                            } else {
                                i13 = i11;
                            }
                            if (i9 != 0) {
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            modifier3 = modifier2;
                            z6 = z3;
                            navigationItemColors3 = navigationItemColorsColors;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1164996656, i13, -1, "androidx.compose.material3.ShortNavigationBarItem (ShortNavigationBar.kt:221)");
                        }
                        if (mutableInteractionSource3 == null) {
                            composerStartRestartGroup.startReplaceGroup(1215846219);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "223@10008L39");
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1424694167, "CC(remember):ShortNavigationBar.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            composerStartRestartGroup.endReplaceGroup();
                            mutableInteractionSource4 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            composerStartRestartGroup.startReplaceGroup(1424693516);
                            composerStartRestartGroup.endReplaceGroup();
                            mutableInteractionSource4 = mutableInteractionSource3;
                        }
                        zM3890equalsimpl0 = NavigationItemIconPosition.m3890equalsimpl0(iM3895getTopxw1Ddg, NavigationItemIconPosition.INSTANCE.m3895getTopxw1Ddg());
                        if (zM3890equalsimpl0) {
                            f = TopIconIndicatorHorizontalPadding;
                        } else {
                            f = StartIconIndicatorHorizontalPadding;
                        }
                        float f8 = f;
                        if (zM3890equalsimpl0) {
                            f2 = TopIconIndicatorVerticalPadding;
                        } else {
                            f2 = StartIconIndicatorVerticalPadding;
                        }
                        int i116 = i13 >> 6;
                        composer2 = composerStartRestartGroup;
                        int i117 = iM3895getTopxw1Ddg;
                        NavigationItemKt.m3905NavigationItem8Df7sds(z, function0, function2, TypographyKt.getValue(NavigationBarTokens.INSTANCE.getLabelTextFont(), composerStartRestartGroup, 6), ShapesKt.getValue(NavigationBarTokens.INSTANCE.getItemActiveIndicatorShape(), composerStartRestartGroup, 6), NavigationBarVerticalItemTokens.INSTANCE.m5557getActiveIndicatorWidthD9Ej5fM(), f8, f2, TopIconIndicatorToLabelPadding, StartIconToLabelPadding, TopIconItemVerticalPadding, navigationItemColors3, modifier3, z6, function3, i117, mutableInteractionSource4, composer2, (i13 & 14) | 906166272 | (i13 & 112) | (i13 & 896), 6 | ((i13 >> 18) & 112) | (i116 & 896) | (i116 & 7168) | ((i13 << 3) & 57344) | ((i13 >> 3) & 458752));
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        mutableInteractionSource2 = mutableInteractionSource3;
                        navigationItemColors2 = navigationItemColors3;
                        modifier2 = modifier3;
                        z5 = z6;
                        i12 = i117;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        z5 = z3;
                        i12 = iM3895getTopxw1Ddg;
                        navigationItemColors2 = navigationItemColorsColors;
                        mutableInteractionSource2 = mutableInteractionSource;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ShortNavigationBarKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return ShortNavigationBarKt.ShortNavigationBarItem_6ZDA4I0$lambda$1(z, function0, function2, function3, modifier2, z5, i12, navigationItemColors2, mutableInteractionSource2, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i4 |= 100663296;
                i11 = i4;
                if ((i4 & 38347923) != 38347922) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z4, i11 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "219@9856L8");
                    if ((i2 & 1) != 0) {
                        if (i14 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i5 != 0) {
                            z3 = true;
                        }
                        if (i7 != 0) {
                            iM3895getTopxw1Ddg = NavigationItemIconPosition.INSTANCE.m3895getTopxw1Ddg();
                        }
                        if ((i3 & 128) != 0) {
                            i13 = i11 & (-29360129);
                            navigationItemColorsColors = ShortNavigationBarItemDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                        } else {
                            i13 = i11;
                        }
                        if (i9 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        modifier3 = modifier2;
                        z6 = z3;
                        navigationItemColors3 = navigationItemColorsColors;
                    } else {
                        if (i14 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i5 != 0) {
                            z3 = true;
                        }
                        if (i7 != 0) {
                            iM3895getTopxw1Ddg = NavigationItemIconPosition.INSTANCE.m3895getTopxw1Ddg();
                        }
                        if ((i3 & 128) != 0) {
                            i13 = i11 & (-29360129);
                            navigationItemColorsColors = ShortNavigationBarItemDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                        } else {
                            i13 = i11;
                        }
                        if (i9 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        modifier3 = modifier2;
                        z6 = z3;
                        navigationItemColors3 = navigationItemColorsColors;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1164996656, i13, -1, "androidx.compose.material3.ShortNavigationBarItem (ShortNavigationBar.kt:221)");
                    }
                    if (mutableInteractionSource3 == null) {
                        composerStartRestartGroup.startReplaceGroup(1215846219);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "223@10008L39");
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1424694167, "CC(remember):ShortNavigationBar.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.endReplaceGroup();
                        mutableInteractionSource4 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        composerStartRestartGroup.startReplaceGroup(1424693516);
                        composerStartRestartGroup.endReplaceGroup();
                        mutableInteractionSource4 = mutableInteractionSource3;
                    }
                    zM3890equalsimpl0 = NavigationItemIconPosition.m3890equalsimpl0(iM3895getTopxw1Ddg, NavigationItemIconPosition.INSTANCE.m3895getTopxw1Ddg());
                    if (zM3890equalsimpl0) {
                        f = TopIconIndicatorHorizontalPadding;
                    } else {
                        f = StartIconIndicatorHorizontalPadding;
                    }
                    float f9 = f;
                    if (zM3890equalsimpl0) {
                        f2 = TopIconIndicatorVerticalPadding;
                    } else {
                        f2 = StartIconIndicatorVerticalPadding;
                    }
                    int i118 = i13 >> 6;
                    composer2 = composerStartRestartGroup;
                    int i119 = iM3895getTopxw1Ddg;
                    NavigationItemKt.m3905NavigationItem8Df7sds(z, function0, function2, TypographyKt.getValue(NavigationBarTokens.INSTANCE.getLabelTextFont(), composerStartRestartGroup, 6), ShapesKt.getValue(NavigationBarTokens.INSTANCE.getItemActiveIndicatorShape(), composerStartRestartGroup, 6), NavigationBarVerticalItemTokens.INSTANCE.m5557getActiveIndicatorWidthD9Ej5fM(), f9, f2, TopIconIndicatorToLabelPadding, StartIconToLabelPadding, TopIconItemVerticalPadding, navigationItemColors3, modifier3, z6, function3, i119, mutableInteractionSource4, composer2, (i13 & 14) | 906166272 | (i13 & 112) | (i13 & 896), 6 | ((i13 >> 18) & 112) | (i118 & 896) | (i118 & 7168) | ((i13 << 3) & 57344) | ((i13 >> 3) & 458752));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    mutableInteractionSource2 = mutableInteractionSource3;
                    navigationItemColors2 = navigationItemColors3;
                    modifier2 = modifier3;
                    z5 = z6;
                    i12 = i119;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    z5 = z3;
                    i12 = iM3895getTopxw1Ddg;
                    navigationItemColors2 = navigationItemColorsColors;
                    mutableInteractionSource2 = mutableInteractionSource;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ShortNavigationBarKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ShortNavigationBarKt.ShortNavigationBarItem_6ZDA4I0$lambda$1(z, function0, function2, function3, modifier2, z5, i12, navigationItemColors2, mutableInteractionSource2, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i4 |= 1572864;
            iM3895getTopxw1Ddg = i;
            if ((12582912 & i2) == 0) {
                if ((i3 & 128) == 0) {
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
            i9 = i3 & 256;
            if (i9 != 0) {
                if ((i2 & 100663296) == 0) {
                    if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                        i10 = 67108864;
                    } else {
                        i10 = 33554432;
                    }
                    i4 |= i10;
                }
                i11 = i4;
                if ((i4 & 38347923) != 38347922) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z4, i11 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "219@9856L8");
                    if ((i2 & 1) != 0) {
                        if (i14 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i5 != 0) {
                            z3 = true;
                        }
                        if (i7 != 0) {
                            iM3895getTopxw1Ddg = NavigationItemIconPosition.INSTANCE.m3895getTopxw1Ddg();
                        }
                        if ((i3 & 128) != 0) {
                            i13 = i11 & (-29360129);
                            navigationItemColorsColors = ShortNavigationBarItemDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                        } else {
                            i13 = i11;
                        }
                        if (i9 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        modifier3 = modifier2;
                        z6 = z3;
                        navigationItemColors3 = navigationItemColorsColors;
                    } else {
                        if (i14 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i5 != 0) {
                            z3 = true;
                        }
                        if (i7 != 0) {
                            iM3895getTopxw1Ddg = NavigationItemIconPosition.INSTANCE.m3895getTopxw1Ddg();
                        }
                        if ((i3 & 128) != 0) {
                            i13 = i11 & (-29360129);
                            navigationItemColorsColors = ShortNavigationBarItemDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                        } else {
                            i13 = i11;
                        }
                        if (i9 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        modifier3 = modifier2;
                        z6 = z3;
                        navigationItemColors3 = navigationItemColorsColors;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1164996656, i13, -1, "androidx.compose.material3.ShortNavigationBarItem (ShortNavigationBar.kt:221)");
                    }
                    if (mutableInteractionSource3 == null) {
                        composerStartRestartGroup.startReplaceGroup(1215846219);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "223@10008L39");
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1424694167, "CC(remember):ShortNavigationBar.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.endReplaceGroup();
                        mutableInteractionSource4 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        composerStartRestartGroup.startReplaceGroup(1424693516);
                        composerStartRestartGroup.endReplaceGroup();
                        mutableInteractionSource4 = mutableInteractionSource3;
                    }
                    zM3890equalsimpl0 = NavigationItemIconPosition.m3890equalsimpl0(iM3895getTopxw1Ddg, NavigationItemIconPosition.INSTANCE.m3895getTopxw1Ddg());
                    if (zM3890equalsimpl0) {
                        f = TopIconIndicatorHorizontalPadding;
                    } else {
                        f = StartIconIndicatorHorizontalPadding;
                    }
                    float f10 = f;
                    if (zM3890equalsimpl0) {
                        f2 = TopIconIndicatorVerticalPadding;
                    } else {
                        f2 = StartIconIndicatorVerticalPadding;
                    }
                    int i1110 = i13 >> 6;
                    composer2 = composerStartRestartGroup;
                    int i1111 = iM3895getTopxw1Ddg;
                    NavigationItemKt.m3905NavigationItem8Df7sds(z, function0, function2, TypographyKt.getValue(NavigationBarTokens.INSTANCE.getLabelTextFont(), composerStartRestartGroup, 6), ShapesKt.getValue(NavigationBarTokens.INSTANCE.getItemActiveIndicatorShape(), composerStartRestartGroup, 6), NavigationBarVerticalItemTokens.INSTANCE.m5557getActiveIndicatorWidthD9Ej5fM(), f10, f2, TopIconIndicatorToLabelPadding, StartIconToLabelPadding, TopIconItemVerticalPadding, navigationItemColors3, modifier3, z6, function3, i1111, mutableInteractionSource4, composer2, (i13 & 14) | 906166272 | (i13 & 112) | (i13 & 896), 6 | ((i13 >> 18) & 112) | (i1110 & 896) | (i1110 & 7168) | ((i13 << 3) & 57344) | ((i13 >> 3) & 458752));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    mutableInteractionSource2 = mutableInteractionSource3;
                    navigationItemColors2 = navigationItemColors3;
                    modifier2 = modifier3;
                    z5 = z6;
                    i12 = i1111;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    z5 = z3;
                    i12 = iM3895getTopxw1Ddg;
                    navigationItemColors2 = navigationItemColorsColors;
                    mutableInteractionSource2 = mutableInteractionSource;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ShortNavigationBarKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ShortNavigationBarKt.ShortNavigationBarItem_6ZDA4I0$lambda$1(z, function0, function2, function3, modifier2, z5, i12, navigationItemColors2, mutableInteractionSource2, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i4 |= 100663296;
            i11 = i4;
            if ((i4 & 38347923) != 38347922) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z4, i11 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "219@9856L8");
                if ((i2 & 1) != 0) {
                    if (i14 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i5 != 0) {
                        z3 = true;
                    }
                    if (i7 != 0) {
                        iM3895getTopxw1Ddg = NavigationItemIconPosition.INSTANCE.m3895getTopxw1Ddg();
                    }
                    if ((i3 & 128) != 0) {
                        i13 = i11 & (-29360129);
                        navigationItemColorsColors = ShortNavigationBarItemDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                    } else {
                        i13 = i11;
                    }
                    if (i9 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    modifier3 = modifier2;
                    z6 = z3;
                    navigationItemColors3 = navigationItemColorsColors;
                } else {
                    if (i14 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i5 != 0) {
                        z3 = true;
                    }
                    if (i7 != 0) {
                        iM3895getTopxw1Ddg = NavigationItemIconPosition.INSTANCE.m3895getTopxw1Ddg();
                    }
                    if ((i3 & 128) != 0) {
                        i13 = i11 & (-29360129);
                        navigationItemColorsColors = ShortNavigationBarItemDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                    } else {
                        i13 = i11;
                    }
                    if (i9 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    modifier3 = modifier2;
                    z6 = z3;
                    navigationItemColors3 = navigationItemColorsColors;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1164996656, i13, -1, "androidx.compose.material3.ShortNavigationBarItem (ShortNavigationBar.kt:221)");
                }
                if (mutableInteractionSource3 == null) {
                    composerStartRestartGroup.startReplaceGroup(1215846219);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "223@10008L39");
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1424694167, "CC(remember):ShortNavigationBar.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endReplaceGroup();
                    mutableInteractionSource4 = (MutableInteractionSource) objRememberedValue;
                } else {
                    composerStartRestartGroup.startReplaceGroup(1424693516);
                    composerStartRestartGroup.endReplaceGroup();
                    mutableInteractionSource4 = mutableInteractionSource3;
                }
                zM3890equalsimpl0 = NavigationItemIconPosition.m3890equalsimpl0(iM3895getTopxw1Ddg, NavigationItemIconPosition.INSTANCE.m3895getTopxw1Ddg());
                if (zM3890equalsimpl0) {
                    f = TopIconIndicatorHorizontalPadding;
                } else {
                    f = StartIconIndicatorHorizontalPadding;
                }
                float f11 = f;
                if (zM3890equalsimpl0) {
                    f2 = TopIconIndicatorVerticalPadding;
                } else {
                    f2 = StartIconIndicatorVerticalPadding;
                }
                int i1112 = i13 >> 6;
                composer2 = composerStartRestartGroup;
                int i1113 = iM3895getTopxw1Ddg;
                NavigationItemKt.m3905NavigationItem8Df7sds(z, function0, function2, TypographyKt.getValue(NavigationBarTokens.INSTANCE.getLabelTextFont(), composerStartRestartGroup, 6), ShapesKt.getValue(NavigationBarTokens.INSTANCE.getItemActiveIndicatorShape(), composerStartRestartGroup, 6), NavigationBarVerticalItemTokens.INSTANCE.m5557getActiveIndicatorWidthD9Ej5fM(), f11, f2, TopIconIndicatorToLabelPadding, StartIconToLabelPadding, TopIconItemVerticalPadding, navigationItemColors3, modifier3, z6, function3, i1113, mutableInteractionSource4, composer2, (i13 & 14) | 906166272 | (i13 & 112) | (i13 & 896), 6 | ((i13 >> 18) & 112) | (i1112 & 896) | (i1112 & 7168) | ((i13 << 3) & 57344) | ((i13 >> 3) & 458752));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                mutableInteractionSource2 = mutableInteractionSource3;
                navigationItemColors2 = navigationItemColors3;
                modifier2 = modifier3;
                z5 = z6;
                i12 = i1113;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                z5 = z3;
                i12 = iM3895getTopxw1Ddg;
                navigationItemColors2 = navigationItemColorsColors;
                mutableInteractionSource2 = mutableInteractionSource;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ShortNavigationBarKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ShortNavigationBarKt.ShortNavigationBarItem_6ZDA4I0$lambda$1(z, function0, function2, function3, modifier2, z5, i12, navigationItemColors2, mutableInteractionSource2, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i4 |= 24576;
        modifier2 = modifier;
        i5 = i3 & 32;
        if (i5 != 0) {
            if ((196608 & i2) == 0) {
                z3 = z2;
                if (composerStartRestartGroup.changed(z3)) {
                    i6 = 131072;
                } else {
                    i6 = 65536;
                }
                i4 |= i6;
            }
            i7 = i3 & 64;
            if (i7 != 0) {
                if ((1572864 & i2) == 0) {
                    iM3895getTopxw1Ddg = i;
                    if (composerStartRestartGroup.changed(iM3895getTopxw1Ddg)) {
                        i8 = 1048576;
                    } else {
                        i8 = 524288;
                    }
                    i4 |= i8;
                }
                if ((12582912 & i2) == 0) {
                    if ((i3 & 128) == 0) {
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
                i9 = i3 & 256;
                if (i9 != 0) {
                    if ((i2 & 100663296) == 0) {
                        if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                            i10 = 67108864;
                        } else {
                            i10 = 33554432;
                        }
                        i4 |= i10;
                    }
                    i11 = i4;
                    if ((i4 & 38347923) != 38347922) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z4, i11 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "219@9856L8");
                        if ((i2 & 1) != 0) {
                            if (i14 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i5 != 0) {
                                z3 = true;
                            }
                            if (i7 != 0) {
                                iM3895getTopxw1Ddg = NavigationItemIconPosition.INSTANCE.m3895getTopxw1Ddg();
                            }
                            if ((i3 & 128) != 0) {
                                i13 = i11 & (-29360129);
                                navigationItemColorsColors = ShortNavigationBarItemDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                            } else {
                                i13 = i11;
                            }
                            if (i9 != 0) {
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            modifier3 = modifier2;
                            z6 = z3;
                            navigationItemColors3 = navigationItemColorsColors;
                        } else {
                            if (i14 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i5 != 0) {
                                z3 = true;
                            }
                            if (i7 != 0) {
                                iM3895getTopxw1Ddg = NavigationItemIconPosition.INSTANCE.m3895getTopxw1Ddg();
                            }
                            if ((i3 & 128) != 0) {
                                i13 = i11 & (-29360129);
                                navigationItemColorsColors = ShortNavigationBarItemDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                            } else {
                                i13 = i11;
                            }
                            if (i9 != 0) {
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            modifier3 = modifier2;
                            z6 = z3;
                            navigationItemColors3 = navigationItemColorsColors;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1164996656, i13, -1, "androidx.compose.material3.ShortNavigationBarItem (ShortNavigationBar.kt:221)");
                        }
                        if (mutableInteractionSource3 == null) {
                            composerStartRestartGroup.startReplaceGroup(1215846219);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "223@10008L39");
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1424694167, "CC(remember):ShortNavigationBar.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            composerStartRestartGroup.endReplaceGroup();
                            mutableInteractionSource4 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            composerStartRestartGroup.startReplaceGroup(1424693516);
                            composerStartRestartGroup.endReplaceGroup();
                            mutableInteractionSource4 = mutableInteractionSource3;
                        }
                        zM3890equalsimpl0 = NavigationItemIconPosition.m3890equalsimpl0(iM3895getTopxw1Ddg, NavigationItemIconPosition.INSTANCE.m3895getTopxw1Ddg());
                        if (zM3890equalsimpl0) {
                            f = TopIconIndicatorHorizontalPadding;
                        } else {
                            f = StartIconIndicatorHorizontalPadding;
                        }
                        float f12 = f;
                        if (zM3890equalsimpl0) {
                            f2 = TopIconIndicatorVerticalPadding;
                        } else {
                            f2 = StartIconIndicatorVerticalPadding;
                        }
                        int i1114 = i13 >> 6;
                        composer2 = composerStartRestartGroup;
                        int i1115 = iM3895getTopxw1Ddg;
                        NavigationItemKt.m3905NavigationItem8Df7sds(z, function0, function2, TypographyKt.getValue(NavigationBarTokens.INSTANCE.getLabelTextFont(), composerStartRestartGroup, 6), ShapesKt.getValue(NavigationBarTokens.INSTANCE.getItemActiveIndicatorShape(), composerStartRestartGroup, 6), NavigationBarVerticalItemTokens.INSTANCE.m5557getActiveIndicatorWidthD9Ej5fM(), f12, f2, TopIconIndicatorToLabelPadding, StartIconToLabelPadding, TopIconItemVerticalPadding, navigationItemColors3, modifier3, z6, function3, i1115, mutableInteractionSource4, composer2, (i13 & 14) | 906166272 | (i13 & 112) | (i13 & 896), 6 | ((i13 >> 18) & 112) | (i1114 & 896) | (i1114 & 7168) | ((i13 << 3) & 57344) | ((i13 >> 3) & 458752));
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        mutableInteractionSource2 = mutableInteractionSource3;
                        navigationItemColors2 = navigationItemColors3;
                        modifier2 = modifier3;
                        z5 = z6;
                        i12 = i1115;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        z5 = z3;
                        i12 = iM3895getTopxw1Ddg;
                        navigationItemColors2 = navigationItemColorsColors;
                        mutableInteractionSource2 = mutableInteractionSource;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ShortNavigationBarKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return ShortNavigationBarKt.ShortNavigationBarItem_6ZDA4I0$lambda$1(z, function0, function2, function3, modifier2, z5, i12, navigationItemColors2, mutableInteractionSource2, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i4 |= 100663296;
                i11 = i4;
                if ((i4 & 38347923) != 38347922) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z4, i11 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "219@9856L8");
                    if ((i2 & 1) != 0) {
                        if (i14 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i5 != 0) {
                            z3 = true;
                        }
                        if (i7 != 0) {
                            iM3895getTopxw1Ddg = NavigationItemIconPosition.INSTANCE.m3895getTopxw1Ddg();
                        }
                        if ((i3 & 128) != 0) {
                            i13 = i11 & (-29360129);
                            navigationItemColorsColors = ShortNavigationBarItemDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                        } else {
                            i13 = i11;
                        }
                        if (i9 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        modifier3 = modifier2;
                        z6 = z3;
                        navigationItemColors3 = navigationItemColorsColors;
                    } else {
                        if (i14 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i5 != 0) {
                            z3 = true;
                        }
                        if (i7 != 0) {
                            iM3895getTopxw1Ddg = NavigationItemIconPosition.INSTANCE.m3895getTopxw1Ddg();
                        }
                        if ((i3 & 128) != 0) {
                            i13 = i11 & (-29360129);
                            navigationItemColorsColors = ShortNavigationBarItemDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                        } else {
                            i13 = i11;
                        }
                        if (i9 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        modifier3 = modifier2;
                        z6 = z3;
                        navigationItemColors3 = navigationItemColorsColors;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1164996656, i13, -1, "androidx.compose.material3.ShortNavigationBarItem (ShortNavigationBar.kt:221)");
                    }
                    if (mutableInteractionSource3 == null) {
                        composerStartRestartGroup.startReplaceGroup(1215846219);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "223@10008L39");
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1424694167, "CC(remember):ShortNavigationBar.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.endReplaceGroup();
                        mutableInteractionSource4 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        composerStartRestartGroup.startReplaceGroup(1424693516);
                        composerStartRestartGroup.endReplaceGroup();
                        mutableInteractionSource4 = mutableInteractionSource3;
                    }
                    zM3890equalsimpl0 = NavigationItemIconPosition.m3890equalsimpl0(iM3895getTopxw1Ddg, NavigationItemIconPosition.INSTANCE.m3895getTopxw1Ddg());
                    if (zM3890equalsimpl0) {
                        f = TopIconIndicatorHorizontalPadding;
                    } else {
                        f = StartIconIndicatorHorizontalPadding;
                    }
                    float f13 = f;
                    if (zM3890equalsimpl0) {
                        f2 = TopIconIndicatorVerticalPadding;
                    } else {
                        f2 = StartIconIndicatorVerticalPadding;
                    }
                    int i1116 = i13 >> 6;
                    composer2 = composerStartRestartGroup;
                    int i1117 = iM3895getTopxw1Ddg;
                    NavigationItemKt.m3905NavigationItem8Df7sds(z, function0, function2, TypographyKt.getValue(NavigationBarTokens.INSTANCE.getLabelTextFont(), composerStartRestartGroup, 6), ShapesKt.getValue(NavigationBarTokens.INSTANCE.getItemActiveIndicatorShape(), composerStartRestartGroup, 6), NavigationBarVerticalItemTokens.INSTANCE.m5557getActiveIndicatorWidthD9Ej5fM(), f13, f2, TopIconIndicatorToLabelPadding, StartIconToLabelPadding, TopIconItemVerticalPadding, navigationItemColors3, modifier3, z6, function3, i1117, mutableInteractionSource4, composer2, (i13 & 14) | 906166272 | (i13 & 112) | (i13 & 896), 6 | ((i13 >> 18) & 112) | (i1116 & 896) | (i1116 & 7168) | ((i13 << 3) & 57344) | ((i13 >> 3) & 458752));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    mutableInteractionSource2 = mutableInteractionSource3;
                    navigationItemColors2 = navigationItemColors3;
                    modifier2 = modifier3;
                    z5 = z6;
                    i12 = i1117;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    z5 = z3;
                    i12 = iM3895getTopxw1Ddg;
                    navigationItemColors2 = navigationItemColorsColors;
                    mutableInteractionSource2 = mutableInteractionSource;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ShortNavigationBarKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ShortNavigationBarKt.ShortNavigationBarItem_6ZDA4I0$lambda$1(z, function0, function2, function3, modifier2, z5, i12, navigationItemColors2, mutableInteractionSource2, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i4 |= 1572864;
            iM3895getTopxw1Ddg = i;
            if ((12582912 & i2) == 0) {
                if ((i3 & 128) == 0) {
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
            i9 = i3 & 256;
            if (i9 != 0) {
                if ((i2 & 100663296) == 0) {
                    if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                        i10 = 67108864;
                    } else {
                        i10 = 33554432;
                    }
                    i4 |= i10;
                }
                i11 = i4;
                if ((i4 & 38347923) != 38347922) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z4, i11 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "219@9856L8");
                    if ((i2 & 1) != 0) {
                        if (i14 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i5 != 0) {
                            z3 = true;
                        }
                        if (i7 != 0) {
                            iM3895getTopxw1Ddg = NavigationItemIconPosition.INSTANCE.m3895getTopxw1Ddg();
                        }
                        if ((i3 & 128) != 0) {
                            i13 = i11 & (-29360129);
                            navigationItemColorsColors = ShortNavigationBarItemDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                        } else {
                            i13 = i11;
                        }
                        if (i9 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        modifier3 = modifier2;
                        z6 = z3;
                        navigationItemColors3 = navigationItemColorsColors;
                    } else {
                        if (i14 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i5 != 0) {
                            z3 = true;
                        }
                        if (i7 != 0) {
                            iM3895getTopxw1Ddg = NavigationItemIconPosition.INSTANCE.m3895getTopxw1Ddg();
                        }
                        if ((i3 & 128) != 0) {
                            i13 = i11 & (-29360129);
                            navigationItemColorsColors = ShortNavigationBarItemDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                        } else {
                            i13 = i11;
                        }
                        if (i9 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        modifier3 = modifier2;
                        z6 = z3;
                        navigationItemColors3 = navigationItemColorsColors;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1164996656, i13, -1, "androidx.compose.material3.ShortNavigationBarItem (ShortNavigationBar.kt:221)");
                    }
                    if (mutableInteractionSource3 == null) {
                        composerStartRestartGroup.startReplaceGroup(1215846219);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "223@10008L39");
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1424694167, "CC(remember):ShortNavigationBar.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.endReplaceGroup();
                        mutableInteractionSource4 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        composerStartRestartGroup.startReplaceGroup(1424693516);
                        composerStartRestartGroup.endReplaceGroup();
                        mutableInteractionSource4 = mutableInteractionSource3;
                    }
                    zM3890equalsimpl0 = NavigationItemIconPosition.m3890equalsimpl0(iM3895getTopxw1Ddg, NavigationItemIconPosition.INSTANCE.m3895getTopxw1Ddg());
                    if (zM3890equalsimpl0) {
                        f = TopIconIndicatorHorizontalPadding;
                    } else {
                        f = StartIconIndicatorHorizontalPadding;
                    }
                    float f14 = f;
                    if (zM3890equalsimpl0) {
                        f2 = TopIconIndicatorVerticalPadding;
                    } else {
                        f2 = StartIconIndicatorVerticalPadding;
                    }
                    int i1118 = i13 >> 6;
                    composer2 = composerStartRestartGroup;
                    int i1119 = iM3895getTopxw1Ddg;
                    NavigationItemKt.m3905NavigationItem8Df7sds(z, function0, function2, TypographyKt.getValue(NavigationBarTokens.INSTANCE.getLabelTextFont(), composerStartRestartGroup, 6), ShapesKt.getValue(NavigationBarTokens.INSTANCE.getItemActiveIndicatorShape(), composerStartRestartGroup, 6), NavigationBarVerticalItemTokens.INSTANCE.m5557getActiveIndicatorWidthD9Ej5fM(), f14, f2, TopIconIndicatorToLabelPadding, StartIconToLabelPadding, TopIconItemVerticalPadding, navigationItemColors3, modifier3, z6, function3, i1119, mutableInteractionSource4, composer2, (i13 & 14) | 906166272 | (i13 & 112) | (i13 & 896), 6 | ((i13 >> 18) & 112) | (i1118 & 896) | (i1118 & 7168) | ((i13 << 3) & 57344) | ((i13 >> 3) & 458752));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    mutableInteractionSource2 = mutableInteractionSource3;
                    navigationItemColors2 = navigationItemColors3;
                    modifier2 = modifier3;
                    z5 = z6;
                    i12 = i1119;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    z5 = z3;
                    i12 = iM3895getTopxw1Ddg;
                    navigationItemColors2 = navigationItemColorsColors;
                    mutableInteractionSource2 = mutableInteractionSource;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ShortNavigationBarKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ShortNavigationBarKt.ShortNavigationBarItem_6ZDA4I0$lambda$1(z, function0, function2, function3, modifier2, z5, i12, navigationItemColors2, mutableInteractionSource2, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i4 |= 100663296;
            i11 = i4;
            if ((i4 & 38347923) != 38347922) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z4, i11 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "219@9856L8");
                if ((i2 & 1) != 0) {
                    if (i14 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i5 != 0) {
                        z3 = true;
                    }
                    if (i7 != 0) {
                        iM3895getTopxw1Ddg = NavigationItemIconPosition.INSTANCE.m3895getTopxw1Ddg();
                    }
                    if ((i3 & 128) != 0) {
                        i13 = i11 & (-29360129);
                        navigationItemColorsColors = ShortNavigationBarItemDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                    } else {
                        i13 = i11;
                    }
                    if (i9 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    modifier3 = modifier2;
                    z6 = z3;
                    navigationItemColors3 = navigationItemColorsColors;
                } else {
                    if (i14 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i5 != 0) {
                        z3 = true;
                    }
                    if (i7 != 0) {
                        iM3895getTopxw1Ddg = NavigationItemIconPosition.INSTANCE.m3895getTopxw1Ddg();
                    }
                    if ((i3 & 128) != 0) {
                        i13 = i11 & (-29360129);
                        navigationItemColorsColors = ShortNavigationBarItemDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                    } else {
                        i13 = i11;
                    }
                    if (i9 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    modifier3 = modifier2;
                    z6 = z3;
                    navigationItemColors3 = navigationItemColorsColors;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1164996656, i13, -1, "androidx.compose.material3.ShortNavigationBarItem (ShortNavigationBar.kt:221)");
                }
                if (mutableInteractionSource3 == null) {
                    composerStartRestartGroup.startReplaceGroup(1215846219);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "223@10008L39");
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1424694167, "CC(remember):ShortNavigationBar.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endReplaceGroup();
                    mutableInteractionSource4 = (MutableInteractionSource) objRememberedValue;
                } else {
                    composerStartRestartGroup.startReplaceGroup(1424693516);
                    composerStartRestartGroup.endReplaceGroup();
                    mutableInteractionSource4 = mutableInteractionSource3;
                }
                zM3890equalsimpl0 = NavigationItemIconPosition.m3890equalsimpl0(iM3895getTopxw1Ddg, NavigationItemIconPosition.INSTANCE.m3895getTopxw1Ddg());
                if (zM3890equalsimpl0) {
                    f = TopIconIndicatorHorizontalPadding;
                } else {
                    f = StartIconIndicatorHorizontalPadding;
                }
                float f15 = f;
                if (zM3890equalsimpl0) {
                    f2 = TopIconIndicatorVerticalPadding;
                } else {
                    f2 = StartIconIndicatorVerticalPadding;
                }
                int i11110 = i13 >> 6;
                composer2 = composerStartRestartGroup;
                int i11111 = iM3895getTopxw1Ddg;
                NavigationItemKt.m3905NavigationItem8Df7sds(z, function0, function2, TypographyKt.getValue(NavigationBarTokens.INSTANCE.getLabelTextFont(), composerStartRestartGroup, 6), ShapesKt.getValue(NavigationBarTokens.INSTANCE.getItemActiveIndicatorShape(), composerStartRestartGroup, 6), NavigationBarVerticalItemTokens.INSTANCE.m5557getActiveIndicatorWidthD9Ej5fM(), f15, f2, TopIconIndicatorToLabelPadding, StartIconToLabelPadding, TopIconItemVerticalPadding, navigationItemColors3, modifier3, z6, function3, i11111, mutableInteractionSource4, composer2, (i13 & 14) | 906166272 | (i13 & 112) | (i13 & 896), 6 | ((i13 >> 18) & 112) | (i11110 & 896) | (i11110 & 7168) | ((i13 << 3) & 57344) | ((i13 >> 3) & 458752));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                mutableInteractionSource2 = mutableInteractionSource3;
                navigationItemColors2 = navigationItemColors3;
                modifier2 = modifier3;
                z5 = z6;
                i12 = i11111;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                z5 = z3;
                i12 = iM3895getTopxw1Ddg;
                navigationItemColors2 = navigationItemColorsColors;
                mutableInteractionSource2 = mutableInteractionSource;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ShortNavigationBarKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ShortNavigationBarKt.ShortNavigationBarItem_6ZDA4I0$lambda$1(z, function0, function2, function3, modifier2, z5, i12, navigationItemColors2, mutableInteractionSource2, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        z3 = z2;
        i7 = i3 & 64;
        if (i7 != 0) {
            if ((1572864 & i2) == 0) {
                iM3895getTopxw1Ddg = i;
                if (composerStartRestartGroup.changed(iM3895getTopxw1Ddg)) {
                    i8 = 1048576;
                } else {
                    i8 = 524288;
                }
                i4 |= i8;
            }
            if ((12582912 & i2) == 0) {
                if ((i3 & 128) == 0) {
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
            i9 = i3 & 256;
            if (i9 != 0) {
                if ((i2 & 100663296) == 0) {
                    if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                        i10 = 67108864;
                    } else {
                        i10 = 33554432;
                    }
                    i4 |= i10;
                }
                i11 = i4;
                if ((i4 & 38347923) != 38347922) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z4, i11 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "219@9856L8");
                    if ((i2 & 1) != 0) {
                        if (i14 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i5 != 0) {
                            z3 = true;
                        }
                        if (i7 != 0) {
                            iM3895getTopxw1Ddg = NavigationItemIconPosition.INSTANCE.m3895getTopxw1Ddg();
                        }
                        if ((i3 & 128) != 0) {
                            i13 = i11 & (-29360129);
                            navigationItemColorsColors = ShortNavigationBarItemDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                        } else {
                            i13 = i11;
                        }
                        if (i9 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        modifier3 = modifier2;
                        z6 = z3;
                        navigationItemColors3 = navigationItemColorsColors;
                    } else {
                        if (i14 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i5 != 0) {
                            z3 = true;
                        }
                        if (i7 != 0) {
                            iM3895getTopxw1Ddg = NavigationItemIconPosition.INSTANCE.m3895getTopxw1Ddg();
                        }
                        if ((i3 & 128) != 0) {
                            i13 = i11 & (-29360129);
                            navigationItemColorsColors = ShortNavigationBarItemDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                        } else {
                            i13 = i11;
                        }
                        if (i9 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        modifier3 = modifier2;
                        z6 = z3;
                        navigationItemColors3 = navigationItemColorsColors;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1164996656, i13, -1, "androidx.compose.material3.ShortNavigationBarItem (ShortNavigationBar.kt:221)");
                    }
                    if (mutableInteractionSource3 == null) {
                        composerStartRestartGroup.startReplaceGroup(1215846219);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "223@10008L39");
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1424694167, "CC(remember):ShortNavigationBar.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.endReplaceGroup();
                        mutableInteractionSource4 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        composerStartRestartGroup.startReplaceGroup(1424693516);
                        composerStartRestartGroup.endReplaceGroup();
                        mutableInteractionSource4 = mutableInteractionSource3;
                    }
                    zM3890equalsimpl0 = NavigationItemIconPosition.m3890equalsimpl0(iM3895getTopxw1Ddg, NavigationItemIconPosition.INSTANCE.m3895getTopxw1Ddg());
                    if (zM3890equalsimpl0) {
                        f = TopIconIndicatorHorizontalPadding;
                    } else {
                        f = StartIconIndicatorHorizontalPadding;
                    }
                    float f16 = f;
                    if (zM3890equalsimpl0) {
                        f2 = TopIconIndicatorVerticalPadding;
                    } else {
                        f2 = StartIconIndicatorVerticalPadding;
                    }
                    int i11112 = i13 >> 6;
                    composer2 = composerStartRestartGroup;
                    int i11113 = iM3895getTopxw1Ddg;
                    NavigationItemKt.m3905NavigationItem8Df7sds(z, function0, function2, TypographyKt.getValue(NavigationBarTokens.INSTANCE.getLabelTextFont(), composerStartRestartGroup, 6), ShapesKt.getValue(NavigationBarTokens.INSTANCE.getItemActiveIndicatorShape(), composerStartRestartGroup, 6), NavigationBarVerticalItemTokens.INSTANCE.m5557getActiveIndicatorWidthD9Ej5fM(), f16, f2, TopIconIndicatorToLabelPadding, StartIconToLabelPadding, TopIconItemVerticalPadding, navigationItemColors3, modifier3, z6, function3, i11113, mutableInteractionSource4, composer2, (i13 & 14) | 906166272 | (i13 & 112) | (i13 & 896), 6 | ((i13 >> 18) & 112) | (i11112 & 896) | (i11112 & 7168) | ((i13 << 3) & 57344) | ((i13 >> 3) & 458752));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    mutableInteractionSource2 = mutableInteractionSource3;
                    navigationItemColors2 = navigationItemColors3;
                    modifier2 = modifier3;
                    z5 = z6;
                    i12 = i11113;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    z5 = z3;
                    i12 = iM3895getTopxw1Ddg;
                    navigationItemColors2 = navigationItemColorsColors;
                    mutableInteractionSource2 = mutableInteractionSource;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ShortNavigationBarKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ShortNavigationBarKt.ShortNavigationBarItem_6ZDA4I0$lambda$1(z, function0, function2, function3, modifier2, z5, i12, navigationItemColors2, mutableInteractionSource2, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i4 |= 100663296;
            i11 = i4;
            if ((i4 & 38347923) != 38347922) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z4, i11 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "219@9856L8");
                if ((i2 & 1) != 0) {
                    if (i14 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i5 != 0) {
                        z3 = true;
                    }
                    if (i7 != 0) {
                        iM3895getTopxw1Ddg = NavigationItemIconPosition.INSTANCE.m3895getTopxw1Ddg();
                    }
                    if ((i3 & 128) != 0) {
                        i13 = i11 & (-29360129);
                        navigationItemColorsColors = ShortNavigationBarItemDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                    } else {
                        i13 = i11;
                    }
                    if (i9 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    modifier3 = modifier2;
                    z6 = z3;
                    navigationItemColors3 = navigationItemColorsColors;
                } else {
                    if (i14 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i5 != 0) {
                        z3 = true;
                    }
                    if (i7 != 0) {
                        iM3895getTopxw1Ddg = NavigationItemIconPosition.INSTANCE.m3895getTopxw1Ddg();
                    }
                    if ((i3 & 128) != 0) {
                        i13 = i11 & (-29360129);
                        navigationItemColorsColors = ShortNavigationBarItemDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                    } else {
                        i13 = i11;
                    }
                    if (i9 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    modifier3 = modifier2;
                    z6 = z3;
                    navigationItemColors3 = navigationItemColorsColors;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1164996656, i13, -1, "androidx.compose.material3.ShortNavigationBarItem (ShortNavigationBar.kt:221)");
                }
                if (mutableInteractionSource3 == null) {
                    composerStartRestartGroup.startReplaceGroup(1215846219);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "223@10008L39");
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1424694167, "CC(remember):ShortNavigationBar.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endReplaceGroup();
                    mutableInteractionSource4 = (MutableInteractionSource) objRememberedValue;
                } else {
                    composerStartRestartGroup.startReplaceGroup(1424693516);
                    composerStartRestartGroup.endReplaceGroup();
                    mutableInteractionSource4 = mutableInteractionSource3;
                }
                zM3890equalsimpl0 = NavigationItemIconPosition.m3890equalsimpl0(iM3895getTopxw1Ddg, NavigationItemIconPosition.INSTANCE.m3895getTopxw1Ddg());
                if (zM3890equalsimpl0) {
                    f = TopIconIndicatorHorizontalPadding;
                } else {
                    f = StartIconIndicatorHorizontalPadding;
                }
                float f17 = f;
                if (zM3890equalsimpl0) {
                    f2 = TopIconIndicatorVerticalPadding;
                } else {
                    f2 = StartIconIndicatorVerticalPadding;
                }
                int i11114 = i13 >> 6;
                composer2 = composerStartRestartGroup;
                int i11115 = iM3895getTopxw1Ddg;
                NavigationItemKt.m3905NavigationItem8Df7sds(z, function0, function2, TypographyKt.getValue(NavigationBarTokens.INSTANCE.getLabelTextFont(), composerStartRestartGroup, 6), ShapesKt.getValue(NavigationBarTokens.INSTANCE.getItemActiveIndicatorShape(), composerStartRestartGroup, 6), NavigationBarVerticalItemTokens.INSTANCE.m5557getActiveIndicatorWidthD9Ej5fM(), f17, f2, TopIconIndicatorToLabelPadding, StartIconToLabelPadding, TopIconItemVerticalPadding, navigationItemColors3, modifier3, z6, function3, i11115, mutableInteractionSource4, composer2, (i13 & 14) | 906166272 | (i13 & 112) | (i13 & 896), 6 | ((i13 >> 18) & 112) | (i11114 & 896) | (i11114 & 7168) | ((i13 << 3) & 57344) | ((i13 >> 3) & 458752));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                mutableInteractionSource2 = mutableInteractionSource3;
                navigationItemColors2 = navigationItemColors3;
                modifier2 = modifier3;
                z5 = z6;
                i12 = i11115;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                z5 = z3;
                i12 = iM3895getTopxw1Ddg;
                navigationItemColors2 = navigationItemColorsColors;
                mutableInteractionSource2 = mutableInteractionSource;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ShortNavigationBarKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ShortNavigationBarKt.ShortNavigationBarItem_6ZDA4I0$lambda$1(z, function0, function2, function3, modifier2, z5, i12, navigationItemColors2, mutableInteractionSource2, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i4 |= 1572864;
        iM3895getTopxw1Ddg = i;
        if ((12582912 & i2) == 0) {
            if ((i3 & 128) == 0) {
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
        i9 = i3 & 256;
        if (i9 != 0) {
            if ((i2 & 100663296) == 0) {
                if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                    i10 = 67108864;
                } else {
                    i10 = 33554432;
                }
                i4 |= i10;
            }
            i11 = i4;
            if ((i4 & 38347923) != 38347922) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z4, i11 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "219@9856L8");
                if ((i2 & 1) != 0) {
                    if (i14 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i5 != 0) {
                        z3 = true;
                    }
                    if (i7 != 0) {
                        iM3895getTopxw1Ddg = NavigationItemIconPosition.INSTANCE.m3895getTopxw1Ddg();
                    }
                    if ((i3 & 128) != 0) {
                        i13 = i11 & (-29360129);
                        navigationItemColorsColors = ShortNavigationBarItemDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                    } else {
                        i13 = i11;
                    }
                    if (i9 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    modifier3 = modifier2;
                    z6 = z3;
                    navigationItemColors3 = navigationItemColorsColors;
                } else {
                    if (i14 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i5 != 0) {
                        z3 = true;
                    }
                    if (i7 != 0) {
                        iM3895getTopxw1Ddg = NavigationItemIconPosition.INSTANCE.m3895getTopxw1Ddg();
                    }
                    if ((i3 & 128) != 0) {
                        i13 = i11 & (-29360129);
                        navigationItemColorsColors = ShortNavigationBarItemDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                    } else {
                        i13 = i11;
                    }
                    if (i9 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    modifier3 = modifier2;
                    z6 = z3;
                    navigationItemColors3 = navigationItemColorsColors;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1164996656, i13, -1, "androidx.compose.material3.ShortNavigationBarItem (ShortNavigationBar.kt:221)");
                }
                if (mutableInteractionSource3 == null) {
                    composerStartRestartGroup.startReplaceGroup(1215846219);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "223@10008L39");
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1424694167, "CC(remember):ShortNavigationBar.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endReplaceGroup();
                    mutableInteractionSource4 = (MutableInteractionSource) objRememberedValue;
                } else {
                    composerStartRestartGroup.startReplaceGroup(1424693516);
                    composerStartRestartGroup.endReplaceGroup();
                    mutableInteractionSource4 = mutableInteractionSource3;
                }
                zM3890equalsimpl0 = NavigationItemIconPosition.m3890equalsimpl0(iM3895getTopxw1Ddg, NavigationItemIconPosition.INSTANCE.m3895getTopxw1Ddg());
                if (zM3890equalsimpl0) {
                    f = TopIconIndicatorHorizontalPadding;
                } else {
                    f = StartIconIndicatorHorizontalPadding;
                }
                float f18 = f;
                if (zM3890equalsimpl0) {
                    f2 = TopIconIndicatorVerticalPadding;
                } else {
                    f2 = StartIconIndicatorVerticalPadding;
                }
                int i11116 = i13 >> 6;
                composer2 = composerStartRestartGroup;
                int i11117 = iM3895getTopxw1Ddg;
                NavigationItemKt.m3905NavigationItem8Df7sds(z, function0, function2, TypographyKt.getValue(NavigationBarTokens.INSTANCE.getLabelTextFont(), composerStartRestartGroup, 6), ShapesKt.getValue(NavigationBarTokens.INSTANCE.getItemActiveIndicatorShape(), composerStartRestartGroup, 6), NavigationBarVerticalItemTokens.INSTANCE.m5557getActiveIndicatorWidthD9Ej5fM(), f18, f2, TopIconIndicatorToLabelPadding, StartIconToLabelPadding, TopIconItemVerticalPadding, navigationItemColors3, modifier3, z6, function3, i11117, mutableInteractionSource4, composer2, (i13 & 14) | 906166272 | (i13 & 112) | (i13 & 896), 6 | ((i13 >> 18) & 112) | (i11116 & 896) | (i11116 & 7168) | ((i13 << 3) & 57344) | ((i13 >> 3) & 458752));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                mutableInteractionSource2 = mutableInteractionSource3;
                navigationItemColors2 = navigationItemColors3;
                modifier2 = modifier3;
                z5 = z6;
                i12 = i11117;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                z5 = z3;
                i12 = iM3895getTopxw1Ddg;
                navigationItemColors2 = navigationItemColorsColors;
                mutableInteractionSource2 = mutableInteractionSource;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ShortNavigationBarKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ShortNavigationBarKt.ShortNavigationBarItem_6ZDA4I0$lambda$1(z, function0, function2, function3, modifier2, z5, i12, navigationItemColors2, mutableInteractionSource2, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i4 |= 100663296;
        i11 = i4;
        if ((i4 & 38347923) != 38347922) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z4, i11 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "219@9856L8");
            if ((i2 & 1) != 0) {
                if (i14 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i5 != 0) {
                    z3 = true;
                }
                if (i7 != 0) {
                    iM3895getTopxw1Ddg = NavigationItemIconPosition.INSTANCE.m3895getTopxw1Ddg();
                }
                if ((i3 & 128) != 0) {
                    i13 = i11 & (-29360129);
                    navigationItemColorsColors = ShortNavigationBarItemDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                } else {
                    i13 = i11;
                }
                if (i9 != 0) {
                    mutableInteractionSource3 = null;
                } else {
                    mutableInteractionSource3 = mutableInteractionSource;
                }
                modifier3 = modifier2;
                z6 = z3;
                navigationItemColors3 = navigationItemColorsColors;
            } else {
                if (i14 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i5 != 0) {
                    z3 = true;
                }
                if (i7 != 0) {
                    iM3895getTopxw1Ddg = NavigationItemIconPosition.INSTANCE.m3895getTopxw1Ddg();
                }
                if ((i3 & 128) != 0) {
                    i13 = i11 & (-29360129);
                    navigationItemColorsColors = ShortNavigationBarItemDefaults.INSTANCE.colors(composerStartRestartGroup, 6);
                } else {
                    i13 = i11;
                }
                if (i9 != 0) {
                    mutableInteractionSource3 = null;
                } else {
                    mutableInteractionSource3 = mutableInteractionSource;
                }
                modifier3 = modifier2;
                z6 = z3;
                navigationItemColors3 = navigationItemColorsColors;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1164996656, i13, -1, "androidx.compose.material3.ShortNavigationBarItem (ShortNavigationBar.kt:221)");
            }
            if (mutableInteractionSource3 == null) {
                composerStartRestartGroup.startReplaceGroup(1215846219);
                ComposerKt.sourceInformation(composerStartRestartGroup, "223@10008L39");
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1424694167, "CC(remember):ShortNavigationBar.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endReplaceGroup();
                mutableInteractionSource4 = (MutableInteractionSource) objRememberedValue;
            } else {
                composerStartRestartGroup.startReplaceGroup(1424693516);
                composerStartRestartGroup.endReplaceGroup();
                mutableInteractionSource4 = mutableInteractionSource3;
            }
            zM3890equalsimpl0 = NavigationItemIconPosition.m3890equalsimpl0(iM3895getTopxw1Ddg, NavigationItemIconPosition.INSTANCE.m3895getTopxw1Ddg());
            if (zM3890equalsimpl0) {
                f = TopIconIndicatorHorizontalPadding;
            } else {
                f = StartIconIndicatorHorizontalPadding;
            }
            float f19 = f;
            if (zM3890equalsimpl0) {
                f2 = TopIconIndicatorVerticalPadding;
            } else {
                f2 = StartIconIndicatorVerticalPadding;
            }
            int i11118 = i13 >> 6;
            composer2 = composerStartRestartGroup;
            int i11119 = iM3895getTopxw1Ddg;
            NavigationItemKt.m3905NavigationItem8Df7sds(z, function0, function2, TypographyKt.getValue(NavigationBarTokens.INSTANCE.getLabelTextFont(), composerStartRestartGroup, 6), ShapesKt.getValue(NavigationBarTokens.INSTANCE.getItemActiveIndicatorShape(), composerStartRestartGroup, 6), NavigationBarVerticalItemTokens.INSTANCE.m5557getActiveIndicatorWidthD9Ej5fM(), f19, f2, TopIconIndicatorToLabelPadding, StartIconToLabelPadding, TopIconItemVerticalPadding, navigationItemColors3, modifier3, z6, function3, i11119, mutableInteractionSource4, composer2, (i13 & 14) | 906166272 | (i13 & 112) | (i13 & 896), 6 | ((i13 >> 18) & 112) | (i11118 & 896) | (i11118 & 7168) | ((i13 << 3) & 57344) | ((i13 >> 3) & 458752));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            mutableInteractionSource2 = mutableInteractionSource3;
            navigationItemColors2 = navigationItemColors3;
            modifier2 = modifier3;
            z5 = z6;
            i12 = i11119;
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            z5 = z3;
            i12 = iM3895getTopxw1Ddg;
            navigationItemColors2 = navigationItemColorsColors;
            mutableInteractionSource2 = mutableInteractionSource;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ShortNavigationBarKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ShortNavigationBarKt.ShortNavigationBarItem_6ZDA4I0$lambda$1(z, function0, function2, function3, modifier2, z5, i12, navigationItemColors2, mutableInteractionSource2, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final ProvidableCompositionLocal<ShortNavigationBarOverride> getLocalShortNavigationBarOverride() {
        return LocalShortNavigationBarOverride;
    }

    static {
        float f = 2;
        TopIconIndicatorVerticalPadding = Dp.m9687constructorimpl(Dp.m9687constructorimpl(NavigationBarVerticalItemTokens.INSTANCE.m5556getActiveIndicatorHeightD9Ej5fM() - NavigationBarVerticalItemTokens.INSTANCE.m5559getIconSizeD9Ej5fM()) / f);
        TopIconIndicatorHorizontalPadding = Dp.m9687constructorimpl(Dp.m9687constructorimpl(NavigationBarVerticalItemTokens.INSTANCE.m5557getActiveIndicatorWidthD9Ej5fM() - NavigationBarVerticalItemTokens.INSTANCE.m5559getIconSizeD9Ej5fM()) / f);
        StartIconIndicatorVerticalPadding = Dp.m9687constructorimpl(Dp.m9687constructorimpl(NavigationBarHorizontalItemTokens.INSTANCE.m5547getActiveIndicatorHeightD9Ej5fM() - NavigationBarHorizontalItemTokens.INSTANCE.m5550getIconSizeD9Ej5fM()) / f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ShortNavigationBarOverride LocalShortNavigationBarOverride$lambda$0() {
        return DefaultShortNavigationBarOverride.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int calculateCenteredContentHorizontalPadding(int i, int i2) {
        if (i > 6) {
            return 0;
        }
        return MathKt.roundToInt((((100 - ((i + 3) * 10)) / 2.0f) / 100) * i2);
    }

    public static final float getTopIconItemVerticalPadding() {
        return TopIconItemVerticalPadding;
    }

    public static final float getTopIconIndicatorVerticalPadding() {
        return TopIconIndicatorVerticalPadding;
    }

    public static final float getTopIconIndicatorHorizontalPadding() {
        return TopIconIndicatorHorizontalPadding;
    }

    public static final float getStartIconIndicatorVerticalPadding() {
        return StartIconIndicatorVerticalPadding;
    }

    public static final float getTopIconIndicatorToLabelPadding() {
        return TopIconIndicatorToLabelPadding;
    }

    public static final float getStartIconIndicatorHorizontalPadding() {
        return StartIconIndicatorHorizontalPadding;
    }

    public static final float getStartIconToLabelPadding() {
        return StartIconToLabelPadding;
    }
}
