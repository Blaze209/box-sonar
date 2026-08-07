package expo.modules.ui;

import androidx.compose.material3.CheckboxDefaults;
import androidx.compose.material3.CheckboxKt;
import androidx.compose.material3.SwitchDefaults;
import androidx.compose.material3.SwitchKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.media3.extractor.WavUtil;
import androidx.profileinstaller.ProfileVerifier;
import com.facebook.hermes.intl.Constants;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.viewevent.ViewEventDelegate;
import expo.modules.kotlin.views.ComposableScope;
import expo.modules.kotlin.views.ExpoComposeView;
import expo.modules.kotlin.views.FunctionalComposableScope;
import external.sdk.pendo.io.mozilla.javascript.Token;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SwitchView.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000H\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aT\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0015\b\u0002\u0010\n\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b¢\u0006\u0002\b\fH\u0007¢\u0006\u0002\u0010\r\u001a;\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007¢\u0006\u0002\u0010\u000f\u001a\\\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u00032\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0015\b\u0002\u0010\n\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b¢\u0006\u0002\b\fH\u0007¢\u0006\u0002\u0010\u0013\u001a-\u0010\u0014\u001a\u00020\u0001*\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00010\u0005H\u0007¢\u0006\u0002\u0010\u001a¨\u0006\u001b"}, d2 = {"SwitchComposable", "", "checked", "", "onCheckedChange", "Lkotlin/Function1;", "colors", "Lexpo/modules/ui/SwitchColors;", "modifier", "Landroidx/compose/ui/Modifier;", "thumbContent", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(ZLkotlin/jvm/functions/Function1;Lexpo/modules/ui/SwitchColors;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "CheckboxComposable", "(ZLkotlin/jvm/functions/Function1;Lexpo/modules/ui/SwitchColors;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)V", "ThemedHybridSwitch", Constants.SENSITIVITY_VARIANT, "", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Lexpo/modules/ui/SwitchColors;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "SwitchContent", "Lexpo/modules/kotlin/views/FunctionalComposableScope;", "props", "Lexpo/modules/ui/SwitchProps;", "onValueChange", "Lexpo/modules/ui/ValueChangeEvent;", "(Lexpo/modules/kotlin/views/FunctionalComposableScope;Lexpo/modules/ui/SwitchProps;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "expo-ui_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class SwitchViewKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CheckboxComposable$lambda$1(boolean z, Function1 function1, SwitchColors switchColors, Modifier modifier, int i, Composer composer, int i2) {
        CheckboxComposable(z, function1, switchColors, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SwitchComposable$lambda$0(boolean z, Function1 function1, SwitchColors switchColors, Modifier modifier, Function2 function2, int i, int i2, Composer composer, int i3) {
        SwitchComposable(z, function1, switchColors, modifier, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SwitchContent$lambda$6(FunctionalComposableScope functionalComposableScope, SwitchProps switchProps, Function1 function1, int i, Composer composer, int i2) {
        SwitchContent(functionalComposableScope, switchProps, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ThemedHybridSwitch$lambda$2(String str, boolean z, Function1 function1, SwitchColors switchColors, Modifier modifier, Function2 function2, int i, int i2, Composer composer, int i3) {
        ThemedHybridSwitch(str, z, function1, switchColors, modifier, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0055  */
    /* JADX WARN: Code duplicated, block: B:27:0x0058  */
    /* JADX WARN: Code duplicated, block: B:29:0x005c  */
    /* JADX WARN: Code duplicated, block: B:31:0x0062  */
    /* JADX WARN: Code duplicated, block: B:32:0x0065  */
    /* JADX WARN: Code duplicated, block: B:36:0x006c  */
    /* JADX WARN: Code duplicated, block: B:37:0x006f  */
    /* JADX WARN: Code duplicated, block: B:39:0x0073  */
    /* JADX WARN: Code duplicated, block: B:41:0x007b  */
    /* JADX WARN: Code duplicated, block: B:42:0x007e  */
    /* JADX WARN: Code duplicated, block: B:47:0x0088  */
    /* JADX WARN: Code duplicated, block: B:48:0x008b  */
    /* JADX WARN: Code duplicated, block: B:50:0x008f  */
    /* JADX WARN: Code duplicated, block: B:52:0x0097  */
    /* JADX WARN: Code duplicated, block: B:53:0x009a  */
    /* JADX WARN: Code duplicated, block: B:58:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:62:0x00b6 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:63:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:64:0x00bd  */
    /* JADX WARN: Code duplicated, block: B:66:0x00c0  */
    /* JADX WARN: Code duplicated, block: B:67:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:70:0x00cc  */
    /* JADX WARN: Code duplicated, block: B:73:0x00e9  */
    /* JADX WARN: Code duplicated, block: B:74:0x00f6  */
    /* JADX WARN: Code duplicated, block: B:77:0x0112  */
    /* JADX WARN: Code duplicated, block: B:78:0x011f  */
    /* JADX WARN: Code duplicated, block: B:81:0x013b  */
    /* JADX WARN: Code duplicated, block: B:82:0x0148  */
    /* JADX WARN: Code duplicated, block: B:85:0x0166  */
    /* JADX WARN: Code duplicated, block: B:86:0x0173  */
    /* JADX WARN: Code duplicated, block: B:89:0x01c2  */
    /* JADX WARN: Code duplicated, block: B:93:0x01cd  */
    /* JADX WARN: Code duplicated, block: B:95:? A[RETURN, SYNTHETIC] */
    public static final void SwitchComposable(final boolean z, final Function1<? super Boolean, Unit> function1, final SwitchColors colors, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i, final int i2) {
        boolean z2;
        int i3;
        Function1<? super Boolean, Unit> function3;
        int i4;
        int i5;
        Modifier modifier2;
        int i6;
        int i7;
        Function2<? super Composer, ? super Integer, Unit> function4;
        int i8;
        Modifier.Companion companion;
        Function2<? super Composer, ? super Integer, Unit> function5;
        Color composeOrNull;
        long jM6824unboximpl;
        Color composeOrNull2;
        long jM6824unboximpl2;
        Color composeOrNull3;
        long jM6824unboximpl3;
        Color composeOrNull4;
        long jM6824unboximpl4;
        Composer composer2;
        final Modifier modifier3;
        final Function2<? super Composer, ? super Integer, Unit> function6;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(colors, "colors");
        Composer composerStartRestartGroup = composer.startRestartGroup(-473650442);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SwitchComposable)P(!1,3)72@1777L605,67@1621L765:SwitchView.kt#v15e7d");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
            z2 = z;
        } else if ((i & 6) == 0) {
            z2 = z;
            i3 = (composerStartRestartGroup.changed(z2) ? 4 : 2) | i;
        } else {
            z2 = z;
            i3 = i;
        }
        if ((i2 & 2) == 0) {
            if ((i & 48) == 0) {
                function3 = function1;
                i3 |= composerStartRestartGroup.changedInstance(function3) ? 32 : 16;
            }
            if ((i2 & 4) != 0) {
                i3 |= 384;
            } else if ((i & 384) == 0) {
                if (composerStartRestartGroup.changedInstance(colors)) {
                    i4 = 256;
                } else {
                    i4 = 128;
                }
                i3 |= i4;
            }
            i5 = i2 & 8;
            if (i5 != 0) {
                if ((i & 3072) == 0) {
                    modifier2 = modifier;
                    if (composerStartRestartGroup.changed(modifier2)) {
                        i6 = 2048;
                    } else {
                        i6 = 1024;
                    }
                    i3 |= i6;
                }
                i7 = i2 & 16;
                if (i7 != 0) {
                    if ((i & 24576) == 0) {
                        function4 = function2;
                        if (composerStartRestartGroup.changedInstance(function4)) {
                            i8 = 16384;
                        } else {
                            i8 = 8192;
                        }
                        i3 |= i8;
                    }
                    if ((i3 & 9363) == 9362 || !composerStartRestartGroup.getSkipping()) {
                        if (i5 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i7 != 0) {
                            function5 = null;
                        } else {
                            function5 = function4;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-473650442, i3, -1, "expo.modules.ui.SwitchComposable (SwitchView.kt:66)");
                        }
                        SwitchDefaults switchDefaults = SwitchDefaults.INSTANCE;
                        composeOrNull = UtilsKt.getComposeOrNull(colors.getCheckedThumbColor());
                        composerStartRestartGroup.startReplaceGroup(88474769);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "75@1981L8");
                        if (composeOrNull != null) {
                            jM6824unboximpl = composeOrNull.m6824unboximpl();
                        } else {
                            jM6824unboximpl = SwitchDefaults.INSTANCE.colors(composerStartRestartGroup, SwitchDefaults.$stable).getCheckedThumbColor();
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        composeOrNull2 = UtilsKt.getComposeOrNull(colors.getCheckedTrackColor());
                        composerStartRestartGroup.startReplaceGroup(88478577);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "77@2100L8");
                        if (composeOrNull2 != null) {
                            jM6824unboximpl2 = composeOrNull2.m6824unboximpl();
                        } else {
                            jM6824unboximpl2 = SwitchDefaults.INSTANCE.colors(composerStartRestartGroup, SwitchDefaults.$stable).getCheckedTrackColor();
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        composeOrNull3 = UtilsKt.getComposeOrNull(colors.getUncheckedThumbColor());
                        composerStartRestartGroup.startReplaceGroup(88482453);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "79@2223L8");
                        if (composeOrNull3 != null) {
                            jM6824unboximpl3 = composeOrNull3.m6824unboximpl();
                        } else {
                            jM6824unboximpl3 = SwitchDefaults.INSTANCE.colors(composerStartRestartGroup, SwitchDefaults.$stable).getUncheckedThumbColor();
                        }
                        long j = jM6824unboximpl3;
                        composerStartRestartGroup.endReplaceGroup();
                        composeOrNull4 = UtilsKt.getComposeOrNull(colors.getUncheckedTrackColor());
                        composerStartRestartGroup.startReplaceGroup(88486453);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "81@2348L8");
                        if (composeOrNull4 != null) {
                            jM6824unboximpl4 = composeOrNull4.m6824unboximpl();
                        } else {
                            jM6824unboximpl4 = SwitchDefaults.INSTANCE.colors(composerStartRestartGroup, SwitchDefaults.$stable).getUncheckedTrackColor();
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        composer2 = composerStartRestartGroup;
                        int i9 = i3 & 126;
                        int i10 = i3 >> 3;
                        Modifier modifier4 = companion;
                        Function2<? super Composer, ? super Integer, Unit> function7 = function5;
                        SwitchKt.Switch(z2, function3, modifier4, function7, false, switchDefaults.m4356colorsV1nXRL4(jM6824unboximpl, jM6824unboximpl2, 0L, 0L, j, jM6824unboximpl4, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer2, 0, SwitchDefaults.$stable << 18, 65484), null, composer2, i9 | (i10 & 896) | (i10 & 7168), 80);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier4;
                        function6 = function7;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        modifier3 = modifier2;
                        function6 = function4;
                        composer2 = composerStartRestartGroup;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: expo.modules.ui.SwitchViewKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return SwitchViewKt.SwitchComposable$lambda$0(z, function1, colors, modifier3, function6, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= 24576;
                function4 = function2;
                if ((i3 & 9363) == 9362) {
                    if (i5 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i7 != 0) {
                        function5 = null;
                    } else {
                        function5 = function4;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-473650442, i3, -1, "expo.modules.ui.SwitchComposable (SwitchView.kt:66)");
                    }
                    SwitchDefaults switchDefaults2 = SwitchDefaults.INSTANCE;
                    composeOrNull = UtilsKt.getComposeOrNull(colors.getCheckedThumbColor());
                    composerStartRestartGroup.startReplaceGroup(88474769);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "75@1981L8");
                    if (composeOrNull != null) {
                        jM6824unboximpl = composeOrNull.m6824unboximpl();
                    } else {
                        jM6824unboximpl = SwitchDefaults.INSTANCE.colors(composerStartRestartGroup, SwitchDefaults.$stable).getCheckedThumbColor();
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    composeOrNull2 = UtilsKt.getComposeOrNull(colors.getCheckedTrackColor());
                    composerStartRestartGroup.startReplaceGroup(88478577);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "77@2100L8");
                    if (composeOrNull2 != null) {
                        jM6824unboximpl2 = composeOrNull2.m6824unboximpl();
                    } else {
                        jM6824unboximpl2 = SwitchDefaults.INSTANCE.colors(composerStartRestartGroup, SwitchDefaults.$stable).getCheckedTrackColor();
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    composeOrNull3 = UtilsKt.getComposeOrNull(colors.getUncheckedThumbColor());
                    composerStartRestartGroup.startReplaceGroup(88482453);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "79@2223L8");
                    if (composeOrNull3 != null) {
                        jM6824unboximpl3 = composeOrNull3.m6824unboximpl();
                    } else {
                        jM6824unboximpl3 = SwitchDefaults.INSTANCE.colors(composerStartRestartGroup, SwitchDefaults.$stable).getUncheckedThumbColor();
                    }
                    long j2 = jM6824unboximpl3;
                    composerStartRestartGroup.endReplaceGroup();
                    composeOrNull4 = UtilsKt.getComposeOrNull(colors.getUncheckedTrackColor());
                    composerStartRestartGroup.startReplaceGroup(88486453);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "81@2348L8");
                    if (composeOrNull4 != null) {
                        jM6824unboximpl4 = composeOrNull4.m6824unboximpl();
                    } else {
                        jM6824unboximpl4 = SwitchDefaults.INSTANCE.colors(composerStartRestartGroup, SwitchDefaults.$stable).getUncheckedTrackColor();
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    composer2 = composerStartRestartGroup;
                    int i11 = i3 & 126;
                    int i12 = i3 >> 3;
                    Modifier modifier5 = companion;
                    Function2<? super Composer, ? super Integer, Unit> function8 = function5;
                    SwitchKt.Switch(z2, function3, modifier5, function8, false, switchDefaults2.m4356colorsV1nXRL4(jM6824unboximpl, jM6824unboximpl2, 0L, 0L, j2, jM6824unboximpl4, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer2, 0, SwitchDefaults.$stable << 18, 65484), null, composer2, i11 | (i12 & 896) | (i12 & 7168), 80);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier5;
                    function6 = function8;
                } else {
                    if (i5 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i7 != 0) {
                        function5 = null;
                    } else {
                        function5 = function4;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-473650442, i3, -1, "expo.modules.ui.SwitchComposable (SwitchView.kt:66)");
                    }
                    SwitchDefaults switchDefaults3 = SwitchDefaults.INSTANCE;
                    composeOrNull = UtilsKt.getComposeOrNull(colors.getCheckedThumbColor());
                    composerStartRestartGroup.startReplaceGroup(88474769);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "75@1981L8");
                    if (composeOrNull != null) {
                        jM6824unboximpl = composeOrNull.m6824unboximpl();
                    } else {
                        jM6824unboximpl = SwitchDefaults.INSTANCE.colors(composerStartRestartGroup, SwitchDefaults.$stable).getCheckedThumbColor();
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    composeOrNull2 = UtilsKt.getComposeOrNull(colors.getCheckedTrackColor());
                    composerStartRestartGroup.startReplaceGroup(88478577);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "77@2100L8");
                    if (composeOrNull2 != null) {
                        jM6824unboximpl2 = composeOrNull2.m6824unboximpl();
                    } else {
                        jM6824unboximpl2 = SwitchDefaults.INSTANCE.colors(composerStartRestartGroup, SwitchDefaults.$stable).getCheckedTrackColor();
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    composeOrNull3 = UtilsKt.getComposeOrNull(colors.getUncheckedThumbColor());
                    composerStartRestartGroup.startReplaceGroup(88482453);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "79@2223L8");
                    if (composeOrNull3 != null) {
                        jM6824unboximpl3 = composeOrNull3.m6824unboximpl();
                    } else {
                        jM6824unboximpl3 = SwitchDefaults.INSTANCE.colors(composerStartRestartGroup, SwitchDefaults.$stable).getUncheckedThumbColor();
                    }
                    long j3 = jM6824unboximpl3;
                    composerStartRestartGroup.endReplaceGroup();
                    composeOrNull4 = UtilsKt.getComposeOrNull(colors.getUncheckedTrackColor());
                    composerStartRestartGroup.startReplaceGroup(88486453);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "81@2348L8");
                    if (composeOrNull4 != null) {
                        jM6824unboximpl4 = composeOrNull4.m6824unboximpl();
                    } else {
                        jM6824unboximpl4 = SwitchDefaults.INSTANCE.colors(composerStartRestartGroup, SwitchDefaults.$stable).getUncheckedTrackColor();
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    composer2 = composerStartRestartGroup;
                    int i13 = i3 & 126;
                    int i14 = i3 >> 3;
                    Modifier modifier6 = companion;
                    Function2<? super Composer, ? super Integer, Unit> function9 = function5;
                    SwitchKt.Switch(z2, function3, modifier6, function9, false, switchDefaults3.m4356colorsV1nXRL4(jM6824unboximpl, jM6824unboximpl2, 0L, 0L, j3, jM6824unboximpl4, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer2, 0, SwitchDefaults.$stable << 18, 65484), null, composer2, i13 | (i14 & 896) | (i14 & 7168), 80);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier6;
                    function6 = function9;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: expo.modules.ui.SwitchViewKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return SwitchViewKt.SwitchComposable$lambda$0(z, function1, colors, modifier3, function6, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 3072;
            modifier2 = modifier;
            i7 = i2 & 16;
            if (i7 != 0) {
                if ((i & 24576) == 0) {
                    function4 = function2;
                    if (composerStartRestartGroup.changedInstance(function4)) {
                        i8 = 16384;
                    } else {
                        i8 = 8192;
                    }
                    i3 |= i8;
                }
                if ((i3 & 9363) == 9362) {
                    if (i5 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i7 != 0) {
                        function5 = null;
                    } else {
                        function5 = function4;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-473650442, i3, -1, "expo.modules.ui.SwitchComposable (SwitchView.kt:66)");
                    }
                    SwitchDefaults switchDefaults4 = SwitchDefaults.INSTANCE;
                    composeOrNull = UtilsKt.getComposeOrNull(colors.getCheckedThumbColor());
                    composerStartRestartGroup.startReplaceGroup(88474769);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "75@1981L8");
                    if (composeOrNull != null) {
                        jM6824unboximpl = composeOrNull.m6824unboximpl();
                    } else {
                        jM6824unboximpl = SwitchDefaults.INSTANCE.colors(composerStartRestartGroup, SwitchDefaults.$stable).getCheckedThumbColor();
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    composeOrNull2 = UtilsKt.getComposeOrNull(colors.getCheckedTrackColor());
                    composerStartRestartGroup.startReplaceGroup(88478577);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "77@2100L8");
                    if (composeOrNull2 != null) {
                        jM6824unboximpl2 = composeOrNull2.m6824unboximpl();
                    } else {
                        jM6824unboximpl2 = SwitchDefaults.INSTANCE.colors(composerStartRestartGroup, SwitchDefaults.$stable).getCheckedTrackColor();
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    composeOrNull3 = UtilsKt.getComposeOrNull(colors.getUncheckedThumbColor());
                    composerStartRestartGroup.startReplaceGroup(88482453);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "79@2223L8");
                    if (composeOrNull3 != null) {
                        jM6824unboximpl3 = composeOrNull3.m6824unboximpl();
                    } else {
                        jM6824unboximpl3 = SwitchDefaults.INSTANCE.colors(composerStartRestartGroup, SwitchDefaults.$stable).getUncheckedThumbColor();
                    }
                    long j4 = jM6824unboximpl3;
                    composerStartRestartGroup.endReplaceGroup();
                    composeOrNull4 = UtilsKt.getComposeOrNull(colors.getUncheckedTrackColor());
                    composerStartRestartGroup.startReplaceGroup(88486453);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "81@2348L8");
                    if (composeOrNull4 != null) {
                        jM6824unboximpl4 = composeOrNull4.m6824unboximpl();
                    } else {
                        jM6824unboximpl4 = SwitchDefaults.INSTANCE.colors(composerStartRestartGroup, SwitchDefaults.$stable).getUncheckedTrackColor();
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    composer2 = composerStartRestartGroup;
                    int i15 = i3 & 126;
                    int i16 = i3 >> 3;
                    Modifier modifier7 = companion;
                    Function2<? super Composer, ? super Integer, Unit> function10 = function5;
                    SwitchKt.Switch(z2, function3, modifier7, function10, false, switchDefaults4.m4356colorsV1nXRL4(jM6824unboximpl, jM6824unboximpl2, 0L, 0L, j4, jM6824unboximpl4, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer2, 0, SwitchDefaults.$stable << 18, 65484), null, composer2, i15 | (i16 & 896) | (i16 & 7168), 80);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier7;
                    function6 = function10;
                } else {
                    if (i5 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i7 != 0) {
                        function5 = null;
                    } else {
                        function5 = function4;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-473650442, i3, -1, "expo.modules.ui.SwitchComposable (SwitchView.kt:66)");
                    }
                    SwitchDefaults switchDefaults5 = SwitchDefaults.INSTANCE;
                    composeOrNull = UtilsKt.getComposeOrNull(colors.getCheckedThumbColor());
                    composerStartRestartGroup.startReplaceGroup(88474769);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "75@1981L8");
                    if (composeOrNull != null) {
                        jM6824unboximpl = composeOrNull.m6824unboximpl();
                    } else {
                        jM6824unboximpl = SwitchDefaults.INSTANCE.colors(composerStartRestartGroup, SwitchDefaults.$stable).getCheckedThumbColor();
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    composeOrNull2 = UtilsKt.getComposeOrNull(colors.getCheckedTrackColor());
                    composerStartRestartGroup.startReplaceGroup(88478577);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "77@2100L8");
                    if (composeOrNull2 != null) {
                        jM6824unboximpl2 = composeOrNull2.m6824unboximpl();
                    } else {
                        jM6824unboximpl2 = SwitchDefaults.INSTANCE.colors(composerStartRestartGroup, SwitchDefaults.$stable).getCheckedTrackColor();
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    composeOrNull3 = UtilsKt.getComposeOrNull(colors.getUncheckedThumbColor());
                    composerStartRestartGroup.startReplaceGroup(88482453);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "79@2223L8");
                    if (composeOrNull3 != null) {
                        jM6824unboximpl3 = composeOrNull3.m6824unboximpl();
                    } else {
                        jM6824unboximpl3 = SwitchDefaults.INSTANCE.colors(composerStartRestartGroup, SwitchDefaults.$stable).getUncheckedThumbColor();
                    }
                    long j5 = jM6824unboximpl3;
                    composerStartRestartGroup.endReplaceGroup();
                    composeOrNull4 = UtilsKt.getComposeOrNull(colors.getUncheckedTrackColor());
                    composerStartRestartGroup.startReplaceGroup(88486453);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "81@2348L8");
                    if (composeOrNull4 != null) {
                        jM6824unboximpl4 = composeOrNull4.m6824unboximpl();
                    } else {
                        jM6824unboximpl4 = SwitchDefaults.INSTANCE.colors(composerStartRestartGroup, SwitchDefaults.$stable).getUncheckedTrackColor();
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    composer2 = composerStartRestartGroup;
                    int i17 = i3 & 126;
                    int i18 = i3 >> 3;
                    Modifier modifier8 = companion;
                    Function2<? super Composer, ? super Integer, Unit> function11 = function5;
                    SwitchKt.Switch(z2, function3, modifier8, function11, false, switchDefaults5.m4356colorsV1nXRL4(jM6824unboximpl, jM6824unboximpl2, 0L, 0L, j5, jM6824unboximpl4, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer2, 0, SwitchDefaults.$stable << 18, 65484), null, composer2, i17 | (i18 & 896) | (i18 & 7168), 80);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier8;
                    function6 = function11;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: expo.modules.ui.SwitchViewKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return SwitchViewKt.SwitchComposable$lambda$0(z, function1, colors, modifier3, function6, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 24576;
            function4 = function2;
            if ((i3 & 9363) == 9362) {
                if (i5 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i7 != 0) {
                    function5 = null;
                } else {
                    function5 = function4;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-473650442, i3, -1, "expo.modules.ui.SwitchComposable (SwitchView.kt:66)");
                }
                SwitchDefaults switchDefaults6 = SwitchDefaults.INSTANCE;
                composeOrNull = UtilsKt.getComposeOrNull(colors.getCheckedThumbColor());
                composerStartRestartGroup.startReplaceGroup(88474769);
                ComposerKt.sourceInformation(composerStartRestartGroup, "75@1981L8");
                if (composeOrNull != null) {
                    jM6824unboximpl = composeOrNull.m6824unboximpl();
                } else {
                    jM6824unboximpl = SwitchDefaults.INSTANCE.colors(composerStartRestartGroup, SwitchDefaults.$stable).getCheckedThumbColor();
                }
                composerStartRestartGroup.endReplaceGroup();
                composeOrNull2 = UtilsKt.getComposeOrNull(colors.getCheckedTrackColor());
                composerStartRestartGroup.startReplaceGroup(88478577);
                ComposerKt.sourceInformation(composerStartRestartGroup, "77@2100L8");
                if (composeOrNull2 != null) {
                    jM6824unboximpl2 = composeOrNull2.m6824unboximpl();
                } else {
                    jM6824unboximpl2 = SwitchDefaults.INSTANCE.colors(composerStartRestartGroup, SwitchDefaults.$stable).getCheckedTrackColor();
                }
                composerStartRestartGroup.endReplaceGroup();
                composeOrNull3 = UtilsKt.getComposeOrNull(colors.getUncheckedThumbColor());
                composerStartRestartGroup.startReplaceGroup(88482453);
                ComposerKt.sourceInformation(composerStartRestartGroup, "79@2223L8");
                if (composeOrNull3 != null) {
                    jM6824unboximpl3 = composeOrNull3.m6824unboximpl();
                } else {
                    jM6824unboximpl3 = SwitchDefaults.INSTANCE.colors(composerStartRestartGroup, SwitchDefaults.$stable).getUncheckedThumbColor();
                }
                long j6 = jM6824unboximpl3;
                composerStartRestartGroup.endReplaceGroup();
                composeOrNull4 = UtilsKt.getComposeOrNull(colors.getUncheckedTrackColor());
                composerStartRestartGroup.startReplaceGroup(88486453);
                ComposerKt.sourceInformation(composerStartRestartGroup, "81@2348L8");
                if (composeOrNull4 != null) {
                    jM6824unboximpl4 = composeOrNull4.m6824unboximpl();
                } else {
                    jM6824unboximpl4 = SwitchDefaults.INSTANCE.colors(composerStartRestartGroup, SwitchDefaults.$stable).getUncheckedTrackColor();
                }
                composerStartRestartGroup.endReplaceGroup();
                composer2 = composerStartRestartGroup;
                int i19 = i3 & 126;
                int i110 = i3 >> 3;
                Modifier modifier9 = companion;
                Function2<? super Composer, ? super Integer, Unit> function12 = function5;
                SwitchKt.Switch(z2, function3, modifier9, function12, false, switchDefaults6.m4356colorsV1nXRL4(jM6824unboximpl, jM6824unboximpl2, 0L, 0L, j6, jM6824unboximpl4, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer2, 0, SwitchDefaults.$stable << 18, 65484), null, composer2, i19 | (i110 & 896) | (i110 & 7168), 80);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier9;
                function6 = function12;
            } else {
                if (i5 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i7 != 0) {
                    function5 = null;
                } else {
                    function5 = function4;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-473650442, i3, -1, "expo.modules.ui.SwitchComposable (SwitchView.kt:66)");
                }
                SwitchDefaults switchDefaults7 = SwitchDefaults.INSTANCE;
                composeOrNull = UtilsKt.getComposeOrNull(colors.getCheckedThumbColor());
                composerStartRestartGroup.startReplaceGroup(88474769);
                ComposerKt.sourceInformation(composerStartRestartGroup, "75@1981L8");
                if (composeOrNull != null) {
                    jM6824unboximpl = composeOrNull.m6824unboximpl();
                } else {
                    jM6824unboximpl = SwitchDefaults.INSTANCE.colors(composerStartRestartGroup, SwitchDefaults.$stable).getCheckedThumbColor();
                }
                composerStartRestartGroup.endReplaceGroup();
                composeOrNull2 = UtilsKt.getComposeOrNull(colors.getCheckedTrackColor());
                composerStartRestartGroup.startReplaceGroup(88478577);
                ComposerKt.sourceInformation(composerStartRestartGroup, "77@2100L8");
                if (composeOrNull2 != null) {
                    jM6824unboximpl2 = composeOrNull2.m6824unboximpl();
                } else {
                    jM6824unboximpl2 = SwitchDefaults.INSTANCE.colors(composerStartRestartGroup, SwitchDefaults.$stable).getCheckedTrackColor();
                }
                composerStartRestartGroup.endReplaceGroup();
                composeOrNull3 = UtilsKt.getComposeOrNull(colors.getUncheckedThumbColor());
                composerStartRestartGroup.startReplaceGroup(88482453);
                ComposerKt.sourceInformation(composerStartRestartGroup, "79@2223L8");
                if (composeOrNull3 != null) {
                    jM6824unboximpl3 = composeOrNull3.m6824unboximpl();
                } else {
                    jM6824unboximpl3 = SwitchDefaults.INSTANCE.colors(composerStartRestartGroup, SwitchDefaults.$stable).getUncheckedThumbColor();
                }
                long j7 = jM6824unboximpl3;
                composerStartRestartGroup.endReplaceGroup();
                composeOrNull4 = UtilsKt.getComposeOrNull(colors.getUncheckedTrackColor());
                composerStartRestartGroup.startReplaceGroup(88486453);
                ComposerKt.sourceInformation(composerStartRestartGroup, "81@2348L8");
                if (composeOrNull4 != null) {
                    jM6824unboximpl4 = composeOrNull4.m6824unboximpl();
                } else {
                    jM6824unboximpl4 = SwitchDefaults.INSTANCE.colors(composerStartRestartGroup, SwitchDefaults.$stable).getUncheckedTrackColor();
                }
                composerStartRestartGroup.endReplaceGroup();
                composer2 = composerStartRestartGroup;
                int i111 = i3 & 126;
                int i112 = i3 >> 3;
                Modifier modifier10 = companion;
                Function2<? super Composer, ? super Integer, Unit> function13 = function5;
                SwitchKt.Switch(z2, function3, modifier10, function13, false, switchDefaults7.m4356colorsV1nXRL4(jM6824unboximpl, jM6824unboximpl2, 0L, 0L, j7, jM6824unboximpl4, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer2, 0, SwitchDefaults.$stable << 18, 65484), null, composer2, i111 | (i112 & 896) | (i112 & 7168), 80);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier10;
                function6 = function13;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: expo.modules.ui.SwitchViewKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return SwitchViewKt.SwitchComposable$lambda$0(z, function1, colors, modifier3, function6, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 48;
        function3 = function1;
        if ((i2 & 4) != 0) {
            i3 |= 384;
        } else if ((i & 384) == 0) {
            if (composerStartRestartGroup.changedInstance(colors)) {
                i4 = 256;
            } else {
                i4 = 128;
            }
            i3 |= i4;
        }
        i5 = i2 & 8;
        if (i5 != 0) {
            if ((i & 3072) == 0) {
                modifier2 = modifier;
                if (composerStartRestartGroup.changed(modifier2)) {
                    i6 = 2048;
                } else {
                    i6 = 1024;
                }
                i3 |= i6;
            }
            i7 = i2 & 16;
            if (i7 != 0) {
                if ((i & 24576) == 0) {
                    function4 = function2;
                    if (composerStartRestartGroup.changedInstance(function4)) {
                        i8 = 16384;
                    } else {
                        i8 = 8192;
                    }
                    i3 |= i8;
                }
                if ((i3 & 9363) == 9362) {
                    if (i5 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i7 != 0) {
                        function5 = null;
                    } else {
                        function5 = function4;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-473650442, i3, -1, "expo.modules.ui.SwitchComposable (SwitchView.kt:66)");
                    }
                    SwitchDefaults switchDefaults8 = SwitchDefaults.INSTANCE;
                    composeOrNull = UtilsKt.getComposeOrNull(colors.getCheckedThumbColor());
                    composerStartRestartGroup.startReplaceGroup(88474769);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "75@1981L8");
                    if (composeOrNull != null) {
                        jM6824unboximpl = composeOrNull.m6824unboximpl();
                    } else {
                        jM6824unboximpl = SwitchDefaults.INSTANCE.colors(composerStartRestartGroup, SwitchDefaults.$stable).getCheckedThumbColor();
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    composeOrNull2 = UtilsKt.getComposeOrNull(colors.getCheckedTrackColor());
                    composerStartRestartGroup.startReplaceGroup(88478577);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "77@2100L8");
                    if (composeOrNull2 != null) {
                        jM6824unboximpl2 = composeOrNull2.m6824unboximpl();
                    } else {
                        jM6824unboximpl2 = SwitchDefaults.INSTANCE.colors(composerStartRestartGroup, SwitchDefaults.$stable).getCheckedTrackColor();
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    composeOrNull3 = UtilsKt.getComposeOrNull(colors.getUncheckedThumbColor());
                    composerStartRestartGroup.startReplaceGroup(88482453);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "79@2223L8");
                    if (composeOrNull3 != null) {
                        jM6824unboximpl3 = composeOrNull3.m6824unboximpl();
                    } else {
                        jM6824unboximpl3 = SwitchDefaults.INSTANCE.colors(composerStartRestartGroup, SwitchDefaults.$stable).getUncheckedThumbColor();
                    }
                    long j8 = jM6824unboximpl3;
                    composerStartRestartGroup.endReplaceGroup();
                    composeOrNull4 = UtilsKt.getComposeOrNull(colors.getUncheckedTrackColor());
                    composerStartRestartGroup.startReplaceGroup(88486453);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "81@2348L8");
                    if (composeOrNull4 != null) {
                        jM6824unboximpl4 = composeOrNull4.m6824unboximpl();
                    } else {
                        jM6824unboximpl4 = SwitchDefaults.INSTANCE.colors(composerStartRestartGroup, SwitchDefaults.$stable).getUncheckedTrackColor();
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    composer2 = composerStartRestartGroup;
                    int i113 = i3 & 126;
                    int i114 = i3 >> 3;
                    Modifier modifier11 = companion;
                    Function2<? super Composer, ? super Integer, Unit> function14 = function5;
                    SwitchKt.Switch(z2, function3, modifier11, function14, false, switchDefaults8.m4356colorsV1nXRL4(jM6824unboximpl, jM6824unboximpl2, 0L, 0L, j8, jM6824unboximpl4, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer2, 0, SwitchDefaults.$stable << 18, 65484), null, composer2, i113 | (i114 & 896) | (i114 & 7168), 80);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier11;
                    function6 = function14;
                } else {
                    if (i5 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i7 != 0) {
                        function5 = null;
                    } else {
                        function5 = function4;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-473650442, i3, -1, "expo.modules.ui.SwitchComposable (SwitchView.kt:66)");
                    }
                    SwitchDefaults switchDefaults9 = SwitchDefaults.INSTANCE;
                    composeOrNull = UtilsKt.getComposeOrNull(colors.getCheckedThumbColor());
                    composerStartRestartGroup.startReplaceGroup(88474769);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "75@1981L8");
                    if (composeOrNull != null) {
                        jM6824unboximpl = composeOrNull.m6824unboximpl();
                    } else {
                        jM6824unboximpl = SwitchDefaults.INSTANCE.colors(composerStartRestartGroup, SwitchDefaults.$stable).getCheckedThumbColor();
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    composeOrNull2 = UtilsKt.getComposeOrNull(colors.getCheckedTrackColor());
                    composerStartRestartGroup.startReplaceGroup(88478577);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "77@2100L8");
                    if (composeOrNull2 != null) {
                        jM6824unboximpl2 = composeOrNull2.m6824unboximpl();
                    } else {
                        jM6824unboximpl2 = SwitchDefaults.INSTANCE.colors(composerStartRestartGroup, SwitchDefaults.$stable).getCheckedTrackColor();
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    composeOrNull3 = UtilsKt.getComposeOrNull(colors.getUncheckedThumbColor());
                    composerStartRestartGroup.startReplaceGroup(88482453);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "79@2223L8");
                    if (composeOrNull3 != null) {
                        jM6824unboximpl3 = composeOrNull3.m6824unboximpl();
                    } else {
                        jM6824unboximpl3 = SwitchDefaults.INSTANCE.colors(composerStartRestartGroup, SwitchDefaults.$stable).getUncheckedThumbColor();
                    }
                    long j9 = jM6824unboximpl3;
                    composerStartRestartGroup.endReplaceGroup();
                    composeOrNull4 = UtilsKt.getComposeOrNull(colors.getUncheckedTrackColor());
                    composerStartRestartGroup.startReplaceGroup(88486453);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "81@2348L8");
                    if (composeOrNull4 != null) {
                        jM6824unboximpl4 = composeOrNull4.m6824unboximpl();
                    } else {
                        jM6824unboximpl4 = SwitchDefaults.INSTANCE.colors(composerStartRestartGroup, SwitchDefaults.$stable).getUncheckedTrackColor();
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    composer2 = composerStartRestartGroup;
                    int i115 = i3 & 126;
                    int i116 = i3 >> 3;
                    Modifier modifier12 = companion;
                    Function2<? super Composer, ? super Integer, Unit> function15 = function5;
                    SwitchKt.Switch(z2, function3, modifier12, function15, false, switchDefaults9.m4356colorsV1nXRL4(jM6824unboximpl, jM6824unboximpl2, 0L, 0L, j9, jM6824unboximpl4, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer2, 0, SwitchDefaults.$stable << 18, 65484), null, composer2, i115 | (i116 & 896) | (i116 & 7168), 80);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier12;
                    function6 = function15;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: expo.modules.ui.SwitchViewKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return SwitchViewKt.SwitchComposable$lambda$0(z, function1, colors, modifier3, function6, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 24576;
            function4 = function2;
            if ((i3 & 9363) == 9362) {
                if (i5 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i7 != 0) {
                    function5 = null;
                } else {
                    function5 = function4;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-473650442, i3, -1, "expo.modules.ui.SwitchComposable (SwitchView.kt:66)");
                }
                SwitchDefaults switchDefaults10 = SwitchDefaults.INSTANCE;
                composeOrNull = UtilsKt.getComposeOrNull(colors.getCheckedThumbColor());
                composerStartRestartGroup.startReplaceGroup(88474769);
                ComposerKt.sourceInformation(composerStartRestartGroup, "75@1981L8");
                if (composeOrNull != null) {
                    jM6824unboximpl = composeOrNull.m6824unboximpl();
                } else {
                    jM6824unboximpl = SwitchDefaults.INSTANCE.colors(composerStartRestartGroup, SwitchDefaults.$stable).getCheckedThumbColor();
                }
                composerStartRestartGroup.endReplaceGroup();
                composeOrNull2 = UtilsKt.getComposeOrNull(colors.getCheckedTrackColor());
                composerStartRestartGroup.startReplaceGroup(88478577);
                ComposerKt.sourceInformation(composerStartRestartGroup, "77@2100L8");
                if (composeOrNull2 != null) {
                    jM6824unboximpl2 = composeOrNull2.m6824unboximpl();
                } else {
                    jM6824unboximpl2 = SwitchDefaults.INSTANCE.colors(composerStartRestartGroup, SwitchDefaults.$stable).getCheckedTrackColor();
                }
                composerStartRestartGroup.endReplaceGroup();
                composeOrNull3 = UtilsKt.getComposeOrNull(colors.getUncheckedThumbColor());
                composerStartRestartGroup.startReplaceGroup(88482453);
                ComposerKt.sourceInformation(composerStartRestartGroup, "79@2223L8");
                if (composeOrNull3 != null) {
                    jM6824unboximpl3 = composeOrNull3.m6824unboximpl();
                } else {
                    jM6824unboximpl3 = SwitchDefaults.INSTANCE.colors(composerStartRestartGroup, SwitchDefaults.$stable).getUncheckedThumbColor();
                }
                long j10 = jM6824unboximpl3;
                composerStartRestartGroup.endReplaceGroup();
                composeOrNull4 = UtilsKt.getComposeOrNull(colors.getUncheckedTrackColor());
                composerStartRestartGroup.startReplaceGroup(88486453);
                ComposerKt.sourceInformation(composerStartRestartGroup, "81@2348L8");
                if (composeOrNull4 != null) {
                    jM6824unboximpl4 = composeOrNull4.m6824unboximpl();
                } else {
                    jM6824unboximpl4 = SwitchDefaults.INSTANCE.colors(composerStartRestartGroup, SwitchDefaults.$stable).getUncheckedTrackColor();
                }
                composerStartRestartGroup.endReplaceGroup();
                composer2 = composerStartRestartGroup;
                int i117 = i3 & 126;
                int i118 = i3 >> 3;
                Modifier modifier13 = companion;
                Function2<? super Composer, ? super Integer, Unit> function16 = function5;
                SwitchKt.Switch(z2, function3, modifier13, function16, false, switchDefaults10.m4356colorsV1nXRL4(jM6824unboximpl, jM6824unboximpl2, 0L, 0L, j10, jM6824unboximpl4, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer2, 0, SwitchDefaults.$stable << 18, 65484), null, composer2, i117 | (i118 & 896) | (i118 & 7168), 80);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier13;
                function6 = function16;
            } else {
                if (i5 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i7 != 0) {
                    function5 = null;
                } else {
                    function5 = function4;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-473650442, i3, -1, "expo.modules.ui.SwitchComposable (SwitchView.kt:66)");
                }
                SwitchDefaults switchDefaults11 = SwitchDefaults.INSTANCE;
                composeOrNull = UtilsKt.getComposeOrNull(colors.getCheckedThumbColor());
                composerStartRestartGroup.startReplaceGroup(88474769);
                ComposerKt.sourceInformation(composerStartRestartGroup, "75@1981L8");
                if (composeOrNull != null) {
                    jM6824unboximpl = composeOrNull.m6824unboximpl();
                } else {
                    jM6824unboximpl = SwitchDefaults.INSTANCE.colors(composerStartRestartGroup, SwitchDefaults.$stable).getCheckedThumbColor();
                }
                composerStartRestartGroup.endReplaceGroup();
                composeOrNull2 = UtilsKt.getComposeOrNull(colors.getCheckedTrackColor());
                composerStartRestartGroup.startReplaceGroup(88478577);
                ComposerKt.sourceInformation(composerStartRestartGroup, "77@2100L8");
                if (composeOrNull2 != null) {
                    jM6824unboximpl2 = composeOrNull2.m6824unboximpl();
                } else {
                    jM6824unboximpl2 = SwitchDefaults.INSTANCE.colors(composerStartRestartGroup, SwitchDefaults.$stable).getCheckedTrackColor();
                }
                composerStartRestartGroup.endReplaceGroup();
                composeOrNull3 = UtilsKt.getComposeOrNull(colors.getUncheckedThumbColor());
                composerStartRestartGroup.startReplaceGroup(88482453);
                ComposerKt.sourceInformation(composerStartRestartGroup, "79@2223L8");
                if (composeOrNull3 != null) {
                    jM6824unboximpl3 = composeOrNull3.m6824unboximpl();
                } else {
                    jM6824unboximpl3 = SwitchDefaults.INSTANCE.colors(composerStartRestartGroup, SwitchDefaults.$stable).getUncheckedThumbColor();
                }
                long j11 = jM6824unboximpl3;
                composerStartRestartGroup.endReplaceGroup();
                composeOrNull4 = UtilsKt.getComposeOrNull(colors.getUncheckedTrackColor());
                composerStartRestartGroup.startReplaceGroup(88486453);
                ComposerKt.sourceInformation(composerStartRestartGroup, "81@2348L8");
                if (composeOrNull4 != null) {
                    jM6824unboximpl4 = composeOrNull4.m6824unboximpl();
                } else {
                    jM6824unboximpl4 = SwitchDefaults.INSTANCE.colors(composerStartRestartGroup, SwitchDefaults.$stable).getUncheckedTrackColor();
                }
                composerStartRestartGroup.endReplaceGroup();
                composer2 = composerStartRestartGroup;
                int i119 = i3 & 126;
                int i1110 = i3 >> 3;
                Modifier modifier14 = companion;
                Function2<? super Composer, ? super Integer, Unit> function17 = function5;
                SwitchKt.Switch(z2, function3, modifier14, function17, false, switchDefaults11.m4356colorsV1nXRL4(jM6824unboximpl, jM6824unboximpl2, 0L, 0L, j11, jM6824unboximpl4, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer2, 0, SwitchDefaults.$stable << 18, 65484), null, composer2, i119 | (i1110 & 896) | (i1110 & 7168), 80);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier14;
                function6 = function17;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: expo.modules.ui.SwitchViewKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return SwitchViewKt.SwitchComposable$lambda$0(z, function1, colors, modifier3, function6, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 3072;
        modifier2 = modifier;
        i7 = i2 & 16;
        if (i7 != 0) {
            if ((i & 24576) == 0) {
                function4 = function2;
                if (composerStartRestartGroup.changedInstance(function4)) {
                    i8 = 16384;
                } else {
                    i8 = 8192;
                }
                i3 |= i8;
            }
            if ((i3 & 9363) == 9362) {
                if (i5 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i7 != 0) {
                    function5 = null;
                } else {
                    function5 = function4;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-473650442, i3, -1, "expo.modules.ui.SwitchComposable (SwitchView.kt:66)");
                }
                SwitchDefaults switchDefaults12 = SwitchDefaults.INSTANCE;
                composeOrNull = UtilsKt.getComposeOrNull(colors.getCheckedThumbColor());
                composerStartRestartGroup.startReplaceGroup(88474769);
                ComposerKt.sourceInformation(composerStartRestartGroup, "75@1981L8");
                if (composeOrNull != null) {
                    jM6824unboximpl = composeOrNull.m6824unboximpl();
                } else {
                    jM6824unboximpl = SwitchDefaults.INSTANCE.colors(composerStartRestartGroup, SwitchDefaults.$stable).getCheckedThumbColor();
                }
                composerStartRestartGroup.endReplaceGroup();
                composeOrNull2 = UtilsKt.getComposeOrNull(colors.getCheckedTrackColor());
                composerStartRestartGroup.startReplaceGroup(88478577);
                ComposerKt.sourceInformation(composerStartRestartGroup, "77@2100L8");
                if (composeOrNull2 != null) {
                    jM6824unboximpl2 = composeOrNull2.m6824unboximpl();
                } else {
                    jM6824unboximpl2 = SwitchDefaults.INSTANCE.colors(composerStartRestartGroup, SwitchDefaults.$stable).getCheckedTrackColor();
                }
                composerStartRestartGroup.endReplaceGroup();
                composeOrNull3 = UtilsKt.getComposeOrNull(colors.getUncheckedThumbColor());
                composerStartRestartGroup.startReplaceGroup(88482453);
                ComposerKt.sourceInformation(composerStartRestartGroup, "79@2223L8");
                if (composeOrNull3 != null) {
                    jM6824unboximpl3 = composeOrNull3.m6824unboximpl();
                } else {
                    jM6824unboximpl3 = SwitchDefaults.INSTANCE.colors(composerStartRestartGroup, SwitchDefaults.$stable).getUncheckedThumbColor();
                }
                long j12 = jM6824unboximpl3;
                composerStartRestartGroup.endReplaceGroup();
                composeOrNull4 = UtilsKt.getComposeOrNull(colors.getUncheckedTrackColor());
                composerStartRestartGroup.startReplaceGroup(88486453);
                ComposerKt.sourceInformation(composerStartRestartGroup, "81@2348L8");
                if (composeOrNull4 != null) {
                    jM6824unboximpl4 = composeOrNull4.m6824unboximpl();
                } else {
                    jM6824unboximpl4 = SwitchDefaults.INSTANCE.colors(composerStartRestartGroup, SwitchDefaults.$stable).getUncheckedTrackColor();
                }
                composerStartRestartGroup.endReplaceGroup();
                composer2 = composerStartRestartGroup;
                int i1111 = i3 & 126;
                int i1112 = i3 >> 3;
                Modifier modifier15 = companion;
                Function2<? super Composer, ? super Integer, Unit> function18 = function5;
                SwitchKt.Switch(z2, function3, modifier15, function18, false, switchDefaults12.m4356colorsV1nXRL4(jM6824unboximpl, jM6824unboximpl2, 0L, 0L, j12, jM6824unboximpl4, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer2, 0, SwitchDefaults.$stable << 18, 65484), null, composer2, i1111 | (i1112 & 896) | (i1112 & 7168), 80);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier15;
                function6 = function18;
            } else {
                if (i5 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i7 != 0) {
                    function5 = null;
                } else {
                    function5 = function4;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-473650442, i3, -1, "expo.modules.ui.SwitchComposable (SwitchView.kt:66)");
                }
                SwitchDefaults switchDefaults13 = SwitchDefaults.INSTANCE;
                composeOrNull = UtilsKt.getComposeOrNull(colors.getCheckedThumbColor());
                composerStartRestartGroup.startReplaceGroup(88474769);
                ComposerKt.sourceInformation(composerStartRestartGroup, "75@1981L8");
                if (composeOrNull != null) {
                    jM6824unboximpl = composeOrNull.m6824unboximpl();
                } else {
                    jM6824unboximpl = SwitchDefaults.INSTANCE.colors(composerStartRestartGroup, SwitchDefaults.$stable).getCheckedThumbColor();
                }
                composerStartRestartGroup.endReplaceGroup();
                composeOrNull2 = UtilsKt.getComposeOrNull(colors.getCheckedTrackColor());
                composerStartRestartGroup.startReplaceGroup(88478577);
                ComposerKt.sourceInformation(composerStartRestartGroup, "77@2100L8");
                if (composeOrNull2 != null) {
                    jM6824unboximpl2 = composeOrNull2.m6824unboximpl();
                } else {
                    jM6824unboximpl2 = SwitchDefaults.INSTANCE.colors(composerStartRestartGroup, SwitchDefaults.$stable).getCheckedTrackColor();
                }
                composerStartRestartGroup.endReplaceGroup();
                composeOrNull3 = UtilsKt.getComposeOrNull(colors.getUncheckedThumbColor());
                composerStartRestartGroup.startReplaceGroup(88482453);
                ComposerKt.sourceInformation(composerStartRestartGroup, "79@2223L8");
                if (composeOrNull3 != null) {
                    jM6824unboximpl3 = composeOrNull3.m6824unboximpl();
                } else {
                    jM6824unboximpl3 = SwitchDefaults.INSTANCE.colors(composerStartRestartGroup, SwitchDefaults.$stable).getUncheckedThumbColor();
                }
                long j13 = jM6824unboximpl3;
                composerStartRestartGroup.endReplaceGroup();
                composeOrNull4 = UtilsKt.getComposeOrNull(colors.getUncheckedTrackColor());
                composerStartRestartGroup.startReplaceGroup(88486453);
                ComposerKt.sourceInformation(composerStartRestartGroup, "81@2348L8");
                if (composeOrNull4 != null) {
                    jM6824unboximpl4 = composeOrNull4.m6824unboximpl();
                } else {
                    jM6824unboximpl4 = SwitchDefaults.INSTANCE.colors(composerStartRestartGroup, SwitchDefaults.$stable).getUncheckedTrackColor();
                }
                composerStartRestartGroup.endReplaceGroup();
                composer2 = composerStartRestartGroup;
                int i1113 = i3 & 126;
                int i1114 = i3 >> 3;
                Modifier modifier16 = companion;
                Function2<? super Composer, ? super Integer, Unit> function19 = function5;
                SwitchKt.Switch(z2, function3, modifier16, function19, false, switchDefaults13.m4356colorsV1nXRL4(jM6824unboximpl, jM6824unboximpl2, 0L, 0L, j13, jM6824unboximpl4, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer2, 0, SwitchDefaults.$stable << 18, 65484), null, composer2, i1113 | (i1114 & 896) | (i1114 & 7168), 80);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier16;
                function6 = function19;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: expo.modules.ui.SwitchViewKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return SwitchViewKt.SwitchComposable$lambda$0(z, function1, colors, modifier3, function6, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 24576;
        function4 = function2;
        if ((i3 & 9363) == 9362) {
            if (i5 != 0) {
                companion = Modifier.INSTANCE;
            } else {
                companion = modifier2;
            }
            if (i7 != 0) {
                function5 = null;
            } else {
                function5 = function4;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-473650442, i3, -1, "expo.modules.ui.SwitchComposable (SwitchView.kt:66)");
            }
            SwitchDefaults switchDefaults14 = SwitchDefaults.INSTANCE;
            composeOrNull = UtilsKt.getComposeOrNull(colors.getCheckedThumbColor());
            composerStartRestartGroup.startReplaceGroup(88474769);
            ComposerKt.sourceInformation(composerStartRestartGroup, "75@1981L8");
            if (composeOrNull != null) {
                jM6824unboximpl = composeOrNull.m6824unboximpl();
            } else {
                jM6824unboximpl = SwitchDefaults.INSTANCE.colors(composerStartRestartGroup, SwitchDefaults.$stable).getCheckedThumbColor();
            }
            composerStartRestartGroup.endReplaceGroup();
            composeOrNull2 = UtilsKt.getComposeOrNull(colors.getCheckedTrackColor());
            composerStartRestartGroup.startReplaceGroup(88478577);
            ComposerKt.sourceInformation(composerStartRestartGroup, "77@2100L8");
            if (composeOrNull2 != null) {
                jM6824unboximpl2 = composeOrNull2.m6824unboximpl();
            } else {
                jM6824unboximpl2 = SwitchDefaults.INSTANCE.colors(composerStartRestartGroup, SwitchDefaults.$stable).getCheckedTrackColor();
            }
            composerStartRestartGroup.endReplaceGroup();
            composeOrNull3 = UtilsKt.getComposeOrNull(colors.getUncheckedThumbColor());
            composerStartRestartGroup.startReplaceGroup(88482453);
            ComposerKt.sourceInformation(composerStartRestartGroup, "79@2223L8");
            if (composeOrNull3 != null) {
                jM6824unboximpl3 = composeOrNull3.m6824unboximpl();
            } else {
                jM6824unboximpl3 = SwitchDefaults.INSTANCE.colors(composerStartRestartGroup, SwitchDefaults.$stable).getUncheckedThumbColor();
            }
            long j14 = jM6824unboximpl3;
            composerStartRestartGroup.endReplaceGroup();
            composeOrNull4 = UtilsKt.getComposeOrNull(colors.getUncheckedTrackColor());
            composerStartRestartGroup.startReplaceGroup(88486453);
            ComposerKt.sourceInformation(composerStartRestartGroup, "81@2348L8");
            if (composeOrNull4 != null) {
                jM6824unboximpl4 = composeOrNull4.m6824unboximpl();
            } else {
                jM6824unboximpl4 = SwitchDefaults.INSTANCE.colors(composerStartRestartGroup, SwitchDefaults.$stable).getUncheckedTrackColor();
            }
            composerStartRestartGroup.endReplaceGroup();
            composer2 = composerStartRestartGroup;
            int i1115 = i3 & 126;
            int i1116 = i3 >> 3;
            Modifier modifier17 = companion;
            Function2<? super Composer, ? super Integer, Unit> function110 = function5;
            SwitchKt.Switch(z2, function3, modifier17, function110, false, switchDefaults14.m4356colorsV1nXRL4(jM6824unboximpl, jM6824unboximpl2, 0L, 0L, j14, jM6824unboximpl4, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer2, 0, SwitchDefaults.$stable << 18, 65484), null, composer2, i1115 | (i1116 & 896) | (i1116 & 7168), 80);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier17;
            function6 = function110;
        } else {
            if (i5 != 0) {
                companion = Modifier.INSTANCE;
            } else {
                companion = modifier2;
            }
            if (i7 != 0) {
                function5 = null;
            } else {
                function5 = function4;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-473650442, i3, -1, "expo.modules.ui.SwitchComposable (SwitchView.kt:66)");
            }
            SwitchDefaults switchDefaults15 = SwitchDefaults.INSTANCE;
            composeOrNull = UtilsKt.getComposeOrNull(colors.getCheckedThumbColor());
            composerStartRestartGroup.startReplaceGroup(88474769);
            ComposerKt.sourceInformation(composerStartRestartGroup, "75@1981L8");
            if (composeOrNull != null) {
                jM6824unboximpl = composeOrNull.m6824unboximpl();
            } else {
                jM6824unboximpl = SwitchDefaults.INSTANCE.colors(composerStartRestartGroup, SwitchDefaults.$stable).getCheckedThumbColor();
            }
            composerStartRestartGroup.endReplaceGroup();
            composeOrNull2 = UtilsKt.getComposeOrNull(colors.getCheckedTrackColor());
            composerStartRestartGroup.startReplaceGroup(88478577);
            ComposerKt.sourceInformation(composerStartRestartGroup, "77@2100L8");
            if (composeOrNull2 != null) {
                jM6824unboximpl2 = composeOrNull2.m6824unboximpl();
            } else {
                jM6824unboximpl2 = SwitchDefaults.INSTANCE.colors(composerStartRestartGroup, SwitchDefaults.$stable).getCheckedTrackColor();
            }
            composerStartRestartGroup.endReplaceGroup();
            composeOrNull3 = UtilsKt.getComposeOrNull(colors.getUncheckedThumbColor());
            composerStartRestartGroup.startReplaceGroup(88482453);
            ComposerKt.sourceInformation(composerStartRestartGroup, "79@2223L8");
            if (composeOrNull3 != null) {
                jM6824unboximpl3 = composeOrNull3.m6824unboximpl();
            } else {
                jM6824unboximpl3 = SwitchDefaults.INSTANCE.colors(composerStartRestartGroup, SwitchDefaults.$stable).getUncheckedThumbColor();
            }
            long j15 = jM6824unboximpl3;
            composerStartRestartGroup.endReplaceGroup();
            composeOrNull4 = UtilsKt.getComposeOrNull(colors.getUncheckedTrackColor());
            composerStartRestartGroup.startReplaceGroup(88486453);
            ComposerKt.sourceInformation(composerStartRestartGroup, "81@2348L8");
            if (composeOrNull4 != null) {
                jM6824unboximpl4 = composeOrNull4.m6824unboximpl();
            } else {
                jM6824unboximpl4 = SwitchDefaults.INSTANCE.colors(composerStartRestartGroup, SwitchDefaults.$stable).getUncheckedTrackColor();
            }
            composerStartRestartGroup.endReplaceGroup();
            composer2 = composerStartRestartGroup;
            int i1117 = i3 & 126;
            int i1118 = i3 >> 3;
            Modifier modifier18 = companion;
            Function2<? super Composer, ? super Integer, Unit> function111 = function5;
            SwitchKt.Switch(z2, function3, modifier18, function111, false, switchDefaults15.m4356colorsV1nXRL4(jM6824unboximpl, jM6824unboximpl2, 0L, 0L, j15, jM6824unboximpl4, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer2, 0, SwitchDefaults.$stable << 18, 65484), null, composer2, i1117 | (i1118 & 896) | (i1118 & 7168), 80);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier18;
            function6 = function111;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: expo.modules.ui.SwitchViewKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SwitchViewKt.SwitchComposable$lambda$0(z, function1, colors, modifier3, function6, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final void CheckboxComposable(final boolean z, final Function1<? super Boolean, Unit> function1, final SwitchColors colors, final Modifier modifier, Composer composer, final int i) {
        boolean z2;
        int i2;
        Composer composer2;
        Intrinsics.checkNotNullParameter(colors, "colors");
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        Composer composerStartRestartGroup = composer.startRestartGroup(795284166);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(CheckboxComposable)P(!1,3)92@2655L384,88@2528L515:SwitchView.kt#v15e7d");
        if ((i & 6) == 0) {
            z2 = z;
            i2 = (composerStartRestartGroup.changed(z2) ? 4 : 2) | i;
        } else {
            z2 = z;
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function1) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(colors) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changed(modifier) ? 2048 : 1024;
        }
        if ((i2 & 1171) != 1170 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(795284166, i2, -1, "expo.modules.ui.CheckboxComposable (SwitchView.kt:87)");
            }
            int i3 = i2;
            composer2 = composerStartRestartGroup;
            boolean z3 = z2;
            CheckboxKt.Checkbox(z3, function1, modifier, false, CheckboxDefaults.INSTANCE.m2930colors5tl4gsc(UtilsKt.getCompose(colors.getCheckedColor()), UtilsKt.getCompose(colors.getUncheckedColor()), UtilsKt.getCompose(colors.getCheckmarkColor()), UtilsKt.getCompose(colors.getDisabledCheckedColor()), UtilsKt.getCompose(colors.getDisabledUncheckedColor()), UtilsKt.getCompose(colors.getDisabledIndeterminateColor()), composer2, CheckboxDefaults.$stable << 18, 0), null, composer2, (i3 & 126) | ((i3 >> 3) & 896), 40);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            composer2 = composerStartRestartGroup;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: expo.modules.ui.SwitchViewKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SwitchViewKt.CheckboxComposable$lambda$1(z, function1, colors, modifier, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX WARN: Code duplicated, block: B:56:0x0099  */
    /* JADX WARN: Code duplicated, block: B:57:0x009b  */
    /* JADX WARN: Code duplicated, block: B:59:0x009e  */
    /* JADX WARN: Code duplicated, block: B:61:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:62:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:67:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:72:0x00c6 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:73:0x00c8  */
    /* JADX WARN: Code duplicated, block: B:74:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:76:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:79:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:82:0x00e7  */
    /* JADX WARN: Code duplicated, block: B:83:0x0108  */
    /* JADX WARN: Code duplicated, block: B:86:0x0127  */
    /* JADX WARN: Code duplicated, block: B:90:0x0132  */
    /* JADX WARN: Code duplicated, block: B:92:? A[RETURN, SYNTHETIC] */
    public static final void ThemedHybridSwitch(final String variant, final boolean z, final Function1<? super Boolean, Unit> function1, final SwitchColors colors, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        Function2<? super Composer, ? super Integer, Unit> function3;
        int i5;
        Modifier.Companion companion;
        Modifier modifier3;
        final Modifier modifier4;
        final Function2<? super Composer, ? super Integer, Unit> function4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(variant, "variant");
        Intrinsics.checkNotNullParameter(colors, "colors");
        Composer composerStartRestartGroup = composer.startRestartGroup(685460675);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ThemedHybridSwitch)P(5!1,3):SwitchView.kt#v15e7d");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(variant) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(z) ? 32 : 16;
        }
        if ((i2 & 4) != 0) {
            i3 |= 384;
        } else if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function1) ? 256 : 128;
        }
        if ((i2 & 8) != 0) {
            i3 |= 3072;
        } else if ((i & 3072) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(colors) ? 2048 : 1024;
        }
        int i6 = i2 & 16;
        if (i6 == 0) {
            if ((i & 24576) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 16384 : 8192;
            }
            i4 = i2 & 32;
            if (i4 != 0) {
                if ((196608 & i) == 0) {
                    function3 = function2;
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i5 = 131072;
                    } else {
                        i5 = 65536;
                    }
                    i3 |= i5;
                }
                if ((74899 & i3) == 74898 || !composerStartRestartGroup.getSkipping()) {
                    if (i6 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i4 != 0) {
                        function3 = null;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(685460675, i3, -1, "expo.modules.ui.ThemedHybridSwitch (SwitchView.kt:111)");
                    }
                    if (Intrinsics.areEqual(variant, "switch")) {
                        composerStartRestartGroup.startReplaceGroup(1597720813);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "113@3308L74");
                        modifier3 = companion;
                        SwitchComposable(z, function1, colors, modifier3, function3, composerStartRestartGroup, (i3 >> 3) & WavUtil.TYPE_WAVE_FORMAT_EXTENSIBLE, 0);
                        composerStartRestartGroup = composerStartRestartGroup;
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        modifier3 = companion;
                        composerStartRestartGroup.startReplaceGroup(1597723585);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "114@3395L62");
                        CheckboxComposable(z, function1, colors, modifier3, composerStartRestartGroup, (i3 >> 3) & 8190);
                        composerStartRestartGroup.endReplaceGroup();
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier4 = modifier3;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier4 = modifier2;
                }
                function4 = function3;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: expo.modules.ui.SwitchViewKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return SwitchViewKt.ThemedHybridSwitch$lambda$2(variant, z, function1, colors, modifier4, function4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            function3 = function2;
            if ((74899 & i3) == 74898) {
                if (i6 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i4 != 0) {
                    function3 = null;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(685460675, i3, -1, "expo.modules.ui.ThemedHybridSwitch (SwitchView.kt:111)");
                }
                if (Intrinsics.areEqual(variant, "switch")) {
                    composerStartRestartGroup.startReplaceGroup(1597720813);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "113@3308L74");
                    modifier3 = companion;
                    SwitchComposable(z, function1, colors, modifier3, function3, composerStartRestartGroup, (i3 >> 3) & WavUtil.TYPE_WAVE_FORMAT_EXTENSIBLE, 0);
                    composerStartRestartGroup = composerStartRestartGroup;
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    modifier3 = companion;
                    composerStartRestartGroup.startReplaceGroup(1597723585);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "114@3395L62");
                    CheckboxComposable(z, function1, colors, modifier3, composerStartRestartGroup, (i3 >> 3) & 8190);
                    composerStartRestartGroup.endReplaceGroup();
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier3;
            } else {
                if (i6 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i4 != 0) {
                    function3 = null;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(685460675, i3, -1, "expo.modules.ui.ThemedHybridSwitch (SwitchView.kt:111)");
                }
                if (Intrinsics.areEqual(variant, "switch")) {
                    composerStartRestartGroup.startReplaceGroup(1597720813);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "113@3308L74");
                    modifier3 = companion;
                    SwitchComposable(z, function1, colors, modifier3, function3, composerStartRestartGroup, (i3 >> 3) & WavUtil.TYPE_WAVE_FORMAT_EXTENSIBLE, 0);
                    composerStartRestartGroup = composerStartRestartGroup;
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    modifier3 = companion;
                    composerStartRestartGroup.startReplaceGroup(1597723585);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "114@3395L62");
                    CheckboxComposable(z, function1, colors, modifier3, composerStartRestartGroup, (i3 >> 3) & 8190);
                    composerStartRestartGroup.endReplaceGroup();
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier3;
            }
            function4 = function3;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: expo.modules.ui.SwitchViewKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return SwitchViewKt.ThemedHybridSwitch$lambda$2(variant, z, function1, colors, modifier4, function4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 24576;
        modifier2 = modifier;
        i4 = i2 & 32;
        if (i4 != 0) {
            if ((196608 & i) == 0) {
                function3 = function2;
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i5 = 131072;
                } else {
                    i5 = 65536;
                }
                i3 |= i5;
            }
            if ((74899 & i3) == 74898) {
                if (i6 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i4 != 0) {
                    function3 = null;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(685460675, i3, -1, "expo.modules.ui.ThemedHybridSwitch (SwitchView.kt:111)");
                }
                if (Intrinsics.areEqual(variant, "switch")) {
                    composerStartRestartGroup.startReplaceGroup(1597720813);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "113@3308L74");
                    modifier3 = companion;
                    SwitchComposable(z, function1, colors, modifier3, function3, composerStartRestartGroup, (i3 >> 3) & WavUtil.TYPE_WAVE_FORMAT_EXTENSIBLE, 0);
                    composerStartRestartGroup = composerStartRestartGroup;
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    modifier3 = companion;
                    composerStartRestartGroup.startReplaceGroup(1597723585);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "114@3395L62");
                    CheckboxComposable(z, function1, colors, modifier3, composerStartRestartGroup, (i3 >> 3) & 8190);
                    composerStartRestartGroup.endReplaceGroup();
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier3;
            } else {
                if (i6 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i4 != 0) {
                    function3 = null;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(685460675, i3, -1, "expo.modules.ui.ThemedHybridSwitch (SwitchView.kt:111)");
                }
                if (Intrinsics.areEqual(variant, "switch")) {
                    composerStartRestartGroup.startReplaceGroup(1597720813);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "113@3308L74");
                    modifier3 = companion;
                    SwitchComposable(z, function1, colors, modifier3, function3, composerStartRestartGroup, (i3 >> 3) & WavUtil.TYPE_WAVE_FORMAT_EXTENSIBLE, 0);
                    composerStartRestartGroup = composerStartRestartGroup;
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    modifier3 = companion;
                    composerStartRestartGroup.startReplaceGroup(1597723585);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "114@3395L62");
                    CheckboxComposable(z, function1, colors, modifier3, composerStartRestartGroup, (i3 >> 3) & 8190);
                    composerStartRestartGroup.endReplaceGroup();
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier4 = modifier3;
            }
            function4 = function3;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: expo.modules.ui.SwitchViewKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return SwitchViewKt.ThemedHybridSwitch$lambda$2(variant, z, function1, colors, modifier4, function4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        function3 = function2;
        if ((74899 & i3) == 74898) {
            if (i6 != 0) {
                companion = Modifier.INSTANCE;
            } else {
                companion = modifier2;
            }
            if (i4 != 0) {
                function3 = null;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(685460675, i3, -1, "expo.modules.ui.ThemedHybridSwitch (SwitchView.kt:111)");
            }
            if (Intrinsics.areEqual(variant, "switch")) {
                composerStartRestartGroup.startReplaceGroup(1597720813);
                ComposerKt.sourceInformation(composerStartRestartGroup, "113@3308L74");
                modifier3 = companion;
                SwitchComposable(z, function1, colors, modifier3, function3, composerStartRestartGroup, (i3 >> 3) & WavUtil.TYPE_WAVE_FORMAT_EXTENSIBLE, 0);
                composerStartRestartGroup = composerStartRestartGroup;
                composerStartRestartGroup.endReplaceGroup();
            } else {
                modifier3 = companion;
                composerStartRestartGroup.startReplaceGroup(1597723585);
                ComposerKt.sourceInformation(composerStartRestartGroup, "114@3395L62");
                CheckboxComposable(z, function1, colors, modifier3, composerStartRestartGroup, (i3 >> 3) & 8190);
                composerStartRestartGroup.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier4 = modifier3;
        } else {
            if (i6 != 0) {
                companion = Modifier.INSTANCE;
            } else {
                companion = modifier2;
            }
            if (i4 != 0) {
                function3 = null;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(685460675, i3, -1, "expo.modules.ui.ThemedHybridSwitch (SwitchView.kt:111)");
            }
            if (Intrinsics.areEqual(variant, "switch")) {
                composerStartRestartGroup.startReplaceGroup(1597720813);
                ComposerKt.sourceInformation(composerStartRestartGroup, "113@3308L74");
                modifier3 = companion;
                SwitchComposable(z, function1, colors, modifier3, function3, composerStartRestartGroup, (i3 >> 3) & WavUtil.TYPE_WAVE_FORMAT_EXTENSIBLE, 0);
                composerStartRestartGroup = composerStartRestartGroup;
                composerStartRestartGroup.endReplaceGroup();
            } else {
                modifier3 = companion;
                composerStartRestartGroup.startReplaceGroup(1597723585);
                ComposerKt.sourceInformation(composerStartRestartGroup, "114@3395L62");
                CheckboxComposable(z, function1, colors, modifier3, composerStartRestartGroup, (i3 >> 3) & 8190);
                composerStartRestartGroup.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier4 = modifier3;
        }
        function4 = function3;
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: expo.modules.ui.SwitchViewKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SwitchViewKt.ThemedHybridSwitch$lambda$2(variant, z, function1, colors, modifier4, function4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final void SwitchContent(final FunctionalComposableScope functionalComposableScope, final SwitchProps props, final Function1<? super ValueChangeEvent, Unit> onValueChange, Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(functionalComposableScope, "<this>");
        Intrinsics.checkNotNullParameter(props, "props");
        Intrinsics.checkNotNullParameter(onValueChange, "onValueChange");
        Composer composerStartRestartGroup = composer.startRestartGroup(2013740342);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SwitchContent)P(1)128@3724L61,130@3833L83,125@3664L425:SwitchView.kt#v15e7d");
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? composerStartRestartGroup.changed(functionalComposableScope) : composerStartRestartGroup.changedInstance(functionalComposableScope) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(props) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onValueChange) ? 256 : 128;
        }
        if ((i2 & Token.DOTQUERY) != 146 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2013740342, i2, -1, "expo.modules.ui.SwitchContent (SwitchView.kt:122)");
            }
            final SlotView slotViewFindChildSlotView = SlotViewKt.findChildSlotView(functionalComposableScope.getView(), "thumbContent");
            String variant = props.getVariant();
            boolean value = props.getValue();
            composerStartRestartGroup.startReplaceGroup(5004770);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):SwitchView.kt#9igjgp");
            boolean z = (i2 & 896) == 256;
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: expo.modules.ui.SwitchViewKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return SwitchViewKt.SwitchContent$lambda$4$lambda$3(onValueChange, ((Boolean) obj).booleanValue());
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            Function1 function1 = (Function1) objRememberedValue;
            composerStartRestartGroup.endReplaceGroup();
            SwitchColors elementColors = props.getElementColors();
            Modifier modifierApplyModifiers = ModifierRegistry.INSTANCE.applyModifiers(props.getModifiers(), functionalComposableScope.getAppContext(), functionalComposableScope.getComposableScope(), functionalComposableScope.getGlobalEventDispatcher(), composerStartRestartGroup, (AppContext.$stable << 3) | (ComposableScope.$stable << 6));
            composerStartRestartGroup = composerStartRestartGroup;
            composerStartRestartGroup.startReplaceGroup(-1825765900);
            ComposerKt.sourceInformation(composerStartRestartGroup, "*132@3971L108");
            ComposableLambda composableLambdaRememberComposableLambda = slotViewFindChildSlotView == null ? null : ComposableLambdaKt.rememberComposableLambda(707633462, true, new Function2<Composer, Integer, Unit>() { // from class: expo.modules.ui.SwitchViewKt$SwitchContent$2$1
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i3) {
                    ComposerKt.sourceInformation(composer2, "C:SwitchView.kt#v15e7d");
                    if ((i3 & 3) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(707633462, i3, -1, "expo.modules.ui.SwitchContent.<anonymous>.<anonymous> (SwitchView.kt:133)");
                    }
                    ComposableScope composableScope = new ComposableScope(null, null, null, null, 15, null);
                    SlotView slotView = slotViewFindChildSlotView;
                    composer2.startReplaceGroup(1430925730);
                    ComposerKt.sourceInformation(composer2, "*135@4040L9");
                    slotView.Content(composableScope, composer2, ComposableScope.$stable | ((ViewEventDelegate.$stable | ExpoComposeView.$stable) << 3));
                    composer2.endReplaceGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composerStartRestartGroup, 54);
            composerStartRestartGroup.endReplaceGroup();
            ThemedHybridSwitch(variant, value, function1, elementColors, modifierApplyModifiers, composableLambdaRememberComposableLambda, composerStartRestartGroup, 0, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: expo.modules.ui.SwitchViewKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SwitchViewKt.SwitchContent$lambda$6(functionalComposableScope, props, onValueChange, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SwitchContent$lambda$4$lambda$3(Function1 function1, boolean z) {
        function1.invoke(new ValueChangeEvent(z));
        return Unit.INSTANCE;
    }
}
