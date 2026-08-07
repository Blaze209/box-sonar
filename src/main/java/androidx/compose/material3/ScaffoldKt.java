package androidx.compose.material3;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsKt;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
import androidx.compose.material3.internal.MutableWindowInsets;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.SubcomposeLayoutKt;
import androidx.compose.ui.layout.SubcomposeMeasureScope;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.media3.common.C;
import androidx.profileinstaller.ProfileVerifier;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Scaffold.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000B\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a®\u0001\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0013\b\u0002\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00062\u0013\b\u0002\u0010\u0007\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00062\u0013\b\u0002\u0010\b\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00062\u0013\b\u0002\u0010\t\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00062\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u0017\u0010\u0011\u001a\u0013\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00010\u0012¢\u0006\u0002\b\u0006H\u0007¢\u0006\u0004\b\u0014\u0010\u0015\u001a\u0084\u0001\u0010\u0016\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u000b2\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00062\u0017\u0010\u0011\u001a\u0013\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00010\u0012¢\u0006\u0002\b\u00062\u0011\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00062\u0011\u0010\u0019\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00062\u0006\u0010\u000f\u001a\u00020\u00102\u0011\u0010\u0007\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u0006H\u0003¢\u0006\u0004\b\u001a\u0010\u001b\"\u0010\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001e¨\u0006\u001f"}, d2 = {"Scaffold", "", "modifier", "Landroidx/compose/ui/Modifier;", "topBar", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "bottomBar", "snackbarHost", "floatingActionButton", "floatingActionButtonPosition", "Landroidx/compose/material3/FabPosition;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "contentWindowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/PaddingValues;", "Scaffold-TvnljyQ", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;IJJLandroidx/compose/foundation/layout/WindowInsets;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "ScaffoldLayout", "fabPosition", "snackbar", "fab", "ScaffoldLayout-FMILGgc", "(ILkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/layout/WindowInsets;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "FabSpacing", "Landroidx/compose/ui/unit/Dp;", "F", "material3"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ScaffoldKt {
    private static final float FabSpacing = Dp.m9687constructorimpl(16);

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ScaffoldLayout_FMILGgc$lambda$7(int i, Function2 function2, Function3 function3, Function2 function4, Function2 function5, WindowInsets windowInsets, Function2 function6, int i2, Composer composer, int i3) {
        m4039ScaffoldLayoutFMILGgc(i, function2, function3, function4, function5, windowInsets, function6, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Scaffold_TvnljyQ$lambda$3(Modifier modifier, Function2 function2, Function2 function3, Function2 function4, Function2 function5, int i, long j, long j2, WindowInsets windowInsets, Function3 function6, int i2, int i3, Composer composer, int i4) {
        m4038ScaffoldTvnljyQ(modifier, function2, function3, function4, function5, i, j, j2, windowInsets, function6, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0121  */
    /* JADX WARN: Code duplicated, block: B:102:0x0127  */
    /* JADX WARN: Code duplicated, block: B:103:0x012a  */
    /* JADX WARN: Code duplicated, block: B:107:0x0138  */
    /* JADX WARN: Code duplicated, block: B:108:0x013a  */
    /* JADX WARN: Code duplicated, block: B:111:0x0143  */
    /* JADX WARN: Code duplicated, block: B:113:0x0158  */
    /* JADX WARN: Code duplicated, block: B:126:0x0186 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:127:0x0188  */
    /* JADX WARN: Code duplicated, block: B:128:0x018d  */
    /* JADX WARN: Code duplicated, block: B:130:0x0191  */
    /* JADX WARN: Code duplicated, block: B:131:0x0198  */
    /* JADX WARN: Code duplicated, block: B:133:0x019b  */
    /* JADX WARN: Code duplicated, block: B:134:0x01a2  */
    /* JADX WARN: Code duplicated, block: B:136:0x01a5  */
    /* JADX WARN: Code duplicated, block: B:137:0x01ac  */
    /* JADX WARN: Code duplicated, block: B:139:0x01af  */
    /* JADX WARN: Code duplicated, block: B:140:0x01b6  */
    /* JADX WARN: Code duplicated, block: B:142:0x01b9  */
    /* JADX WARN: Code duplicated, block: B:143:0x01c0  */
    /* JADX WARN: Code duplicated, block: B:146:0x01c7  */
    /* JADX WARN: Code duplicated, block: B:147:0x01d7  */
    /* JADX WARN: Code duplicated, block: B:150:0x01de  */
    /* JADX WARN: Code duplicated, block: B:151:0x01e9  */
    /* JADX WARN: Code duplicated, block: B:154:0x01ef  */
    /* JADX WARN: Code duplicated, block: B:155:0x01f7  */
    /* JADX WARN: Code duplicated, block: B:159:0x0207  */
    /* JADX WARN: Code duplicated, block: B:160:0x0213  */
    /* JADX WARN: Code duplicated, block: B:163:0x0226  */
    /* JADX WARN: Code duplicated, block: B:165:0x022c  */
    /* JADX WARN: Code duplicated, block: B:171:0x0239  */
    /* JADX WARN: Code duplicated, block: B:173:0x0241  */
    /* JADX WARN: Code duplicated, block: B:176:0x0260  */
    /* JADX WARN: Code duplicated, block: B:178:0x0266  */
    /* JADX WARN: Code duplicated, block: B:184:0x0274  */
    /* JADX WARN: Code duplicated, block: B:186:0x027c  */
    /* JADX WARN: Code duplicated, block: B:189:0x02d2  */
    /* JADX WARN: Code duplicated, block: B:191:0x02e1  */
    /* JADX WARN: Code duplicated, block: B:194:0x02fa  */
    /* JADX WARN: Code duplicated, block: B:196:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:26:0x0050  */
    /* JADX WARN: Code duplicated, block: B:27:0x0053  */
    /* JADX WARN: Code duplicated, block: B:29:0x0057  */
    /* JADX WARN: Code duplicated, block: B:31:0x005f  */
    /* JADX WARN: Code duplicated, block: B:32:0x0062  */
    /* JADX WARN: Code duplicated, block: B:37:0x006c  */
    /* JADX WARN: Code duplicated, block: B:38:0x006f  */
    /* JADX WARN: Code duplicated, block: B:40:0x0073  */
    /* JADX WARN: Code duplicated, block: B:42:0x007b  */
    /* JADX WARN: Code duplicated, block: B:43:0x007e  */
    /* JADX WARN: Code duplicated, block: B:48:0x0088  */
    /* JADX WARN: Code duplicated, block: B:49:0x008b  */
    /* JADX WARN: Code duplicated, block: B:51:0x008f  */
    /* JADX WARN: Code duplicated, block: B:53:0x0097  */
    /* JADX WARN: Code duplicated, block: B:54:0x009a  */
    /* JADX WARN: Code duplicated, block: B:59:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:60:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:62:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:64:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:65:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:69:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:71:0x00cc  */
    /* JADX WARN: Code duplicated, block: B:74:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:76:0x00da  */
    /* JADX WARN: Code duplicated, block: B:79:0x00e4  */
    /* JADX WARN: Code duplicated, block: B:81:0x00ea  */
    /* JADX WARN: Code duplicated, block: B:84:0x00f3  */
    /* JADX WARN: Code duplicated, block: B:86:0x00f7  */
    /* JADX WARN: Code duplicated, block: B:89:0x0101  */
    /* JADX WARN: Code duplicated, block: B:91:0x0105  */
    /* JADX WARN: Code duplicated, block: B:94:0x0110 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:97:0x0117  */
    /* JADX INFO: renamed from: Scaffold-TvnljyQ, reason: not valid java name */
    public static final void m4038ScaffoldTvnljyQ(Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function3, Function2<? super Composer, ? super Integer, Unit> function4, Function2<? super Composer, ? super Integer, Unit> function5, int i, long j, long j2, WindowInsets windowInsets, final Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> function6, Composer composer, final int i2, final int i3) {
        int i4;
        Function2<? super Composer, ? super Integer, Unit> function7;
        int i5;
        Function2<? super Composer, ? super Integer, Unit> function8;
        int i6;
        int i7;
        Function2<? super Composer, ? super Integer, Unit> function9;
        int i8;
        int i9;
        Function2<? super Composer, ? super Integer, Unit> function10;
        int i10;
        int i11;
        int i12;
        boolean z;
        Composer composer2;
        final Modifier modifier2;
        final WindowInsets windowInsets2;
        final Function2<? super Composer, ? super Integer, Unit> function11;
        final Function2<? super Composer, ? super Integer, Unit> function12;
        final Function2<? super Composer, ? super Integer, Unit> function13;
        final Function2<? super Composer, ? super Integer, Unit> function14;
        final int i13;
        final long j3;
        final long j4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        Function2<? super Composer, ? super Integer, Unit> function2M3102getLambda$39202156$material3;
        Function2<? super Composer, ? super Integer, Unit> lambda$1582488484$material3;
        Function2<? super Composer, ? super Integer, Unit> lambda$414328099$material3;
        Function2<? super Composer, ? super Integer, Unit> function2M3101getLambda$1514016380$material3;
        int iM3359getEndERTFSPs;
        long background;
        long jM3051contentColorForek8zF_U;
        final WindowInsets contentWindowInsets;
        long j5;
        boolean z2;
        Object objRememberedValue;
        final MutableWindowInsets mutableWindowInsets;
        boolean zChanged;
        Object objRememberedValue2;
        int i14;
        int i15;
        int i16;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1211482744);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Scaffold)N(modifier,topBar,bottomBar,snackbarHost,floatingActionButton,floatingActionButtonPosition:c#material3.FabPosition,containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,contentWindowInsets,content)94@4873L74,97@5031L224,103@5332L315,95@4952L695:Scaffold.kt#uh7d8r");
        int i17 = i3 & 1;
        if (i17 != 0) {
            i4 = i2 | 6;
        } else if ((i2 & 6) == 0) {
            i4 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i2;
        } else {
            i4 = i2;
        }
        int i18 = i3 & 2;
        if (i18 == 0) {
            if ((i2 & 48) == 0) {
                function7 = function2;
                i4 |= composerStartRestartGroup.changedInstance(function7) ? 32 : 16;
            }
            i5 = i3 & 4;
            if (i5 != 0) {
                if ((i2 & 384) == 0) {
                    function8 = function3;
                    if (composerStartRestartGroup.changedInstance(function8)) {
                        i6 = 256;
                    } else {
                        i6 = 128;
                    }
                    i4 |= i6;
                }
                i7 = i3 & 8;
                if (i7 != 0) {
                    if ((i2 & 3072) == 0) {
                        function9 = function4;
                        if (composerStartRestartGroup.changedInstance(function9)) {
                            i8 = 2048;
                        } else {
                            i8 = 1024;
                        }
                        i4 |= i8;
                    }
                    i9 = i3 & 16;
                    if (i9 != 0) {
                        if ((i2 & 24576) == 0) {
                            function10 = function5;
                            if (composerStartRestartGroup.changedInstance(function10)) {
                                i10 = 16384;
                            } else {
                                i10 = 8192;
                            }
                            i4 |= i10;
                        }
                        i11 = i3 & 32;
                        if (i11 != 0) {
                            i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                        } else if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                            if (composerStartRestartGroup.changed(i)) {
                                i12 = 131072;
                            } else {
                                i12 = 65536;
                            }
                            i4 |= i12;
                        }
                        if ((i2 & 1572864) != 0) {
                            if ((i3 & 64) == 0 || !composerStartRestartGroup.changed(j)) {
                                i16 = 524288;
                            } else {
                                i16 = 1048576;
                            }
                            i4 |= i16;
                        }
                        if ((i2 & 12582912) != 0) {
                            if ((i3 & 128) == 0 || !composerStartRestartGroup.changed(j2)) {
                                i15 = 4194304;
                            } else {
                                i15 = 8388608;
                            }
                            i4 |= i15;
                        }
                        if ((i2 & 100663296) != 0) {
                            i4 |= ((i3 & 256) == 0 || !composerStartRestartGroup.changed(windowInsets)) ? 33554432 : 67108864;
                        }
                        if ((i2 & 805306368) == 0) {
                            if (composerStartRestartGroup.changedInstance(function6)) {
                                i14 = C.BUFFER_FLAG_LAST_SAMPLE;
                            } else {
                                i14 = 268435456;
                            }
                            i4 |= i14;
                        }
                        if ((i4 & 306783379) != 306783378) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
                            composerStartRestartGroup.startDefaults();
                            ComposerKt.sourceInformation(composerStartRestartGroup, "89@4637L11,90@4687L31,91@4777L19");
                            if ((i2 & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                if (i17 != 0) {
                                    companion = Modifier.INSTANCE;
                                } else {
                                    companion = modifier;
                                }
                                if (i18 != 0) {
                                    function2M3102getLambda$39202156$material3 = ComposableSingletons$ScaffoldKt.INSTANCE.m3102getLambda$39202156$material3();
                                } else {
                                    function2M3102getLambda$39202156$material3 = function7;
                                }
                                if (i5 != 0) {
                                    lambda$1582488484$material3 = ComposableSingletons$ScaffoldKt.INSTANCE.getLambda$1582488484$material3();
                                } else {
                                    lambda$1582488484$material3 = function8;
                                }
                                if (i7 != 0) {
                                    lambda$414328099$material3 = ComposableSingletons$ScaffoldKt.INSTANCE.getLambda$414328099$material3();
                                } else {
                                    lambda$414328099$material3 = function9;
                                }
                                if (i9 != 0) {
                                    function2M3101getLambda$1514016380$material3 = ComposableSingletons$ScaffoldKt.INSTANCE.m3101getLambda$1514016380$material3();
                                } else {
                                    function2M3101getLambda$1514016380$material3 = function10;
                                }
                                if (i11 != 0) {
                                    iM3359getEndERTFSPs = FabPosition.INSTANCE.m3359getEndERTFSPs();
                                } else {
                                    iM3359getEndERTFSPs = i;
                                }
                                if ((i3 & 64) != 0) {
                                    i4 &= -3670017;
                                    background = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).getBackground();
                                } else {
                                    background = j;
                                }
                                if ((i3 & 128) != 0) {
                                    jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(background, composerStartRestartGroup, (i4 >> 18) & 14);
                                    i4 &= -29360129;
                                } else {
                                    jM3051contentColorForek8zF_U = j2;
                                }
                                if ((i3 & 256) != 0) {
                                    contentWindowInsets = ScaffoldDefaults.INSTANCE.getContentWindowInsets(composerStartRestartGroup, 6);
                                    i4 &= -234881025;
                                } else {
                                    contentWindowInsets = windowInsets;
                                }
                                j5 = jM3051contentColorForek8zF_U;
                            } else {
                                composerStartRestartGroup.skipToGroupEnd();
                                if ((i3 & 64) != 0) {
                                    i4 &= -3670017;
                                }
                                if ((i3 & 128) != 0) {
                                    i4 &= -29360129;
                                }
                                if ((i3 & 256) != 0) {
                                    i4 &= -234881025;
                                }
                                companion = modifier;
                                iM3359getEndERTFSPs = i;
                                background = j;
                                function2M3102getLambda$39202156$material3 = function7;
                                lambda$1582488484$material3 = function8;
                                lambda$414328099$material3 = function9;
                                function2M3101getLambda$1514016380$material3 = function10;
                                j5 = j2;
                                contentWindowInsets = windowInsets;
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1211482744, i4, -1, "androidx.compose.material3.Scaffold (Scaffold.kt:93)");
                            }
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -298761166, "CC(remember):Scaffold.kt#9igjgp");
                            int i19 = (234881024 & i4) ^ r19;
                            z2 = (i19 <= 67108864 && composerStartRestartGroup.changed(contentWindowInsets)) || (i4 & r19) == 67108864;
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (!z2 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = new MutableWindowInsets(contentWindowInsets);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            mutableWindowInsets = (MutableWindowInsets) objRememberedValue;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            long j6 = background;
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -298755960, "CC(remember):Scaffold.kt#9igjgp");
                            zChanged = composerStartRestartGroup.changed(mutableWindowInsets) | ((i19 <= 67108864 && composerStartRestartGroup.changed(contentWindowInsets)) || (i4 & 100663296) == 67108864);
                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (!zChanged || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue2 = new Function1() { // from class: androidx.compose.material3.ScaffoldKt$$ExternalSyntheticLambda0
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return ScaffoldKt.Scaffold_TvnljyQ$lambda$1$0(mutableWindowInsets, contentWindowInsets, (WindowInsets) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            final Function2<? super Composer, ? super Integer, Unit> function15 = function2M3102getLambda$39202156$material3;
                            final Function2<? super Composer, ? super Integer, Unit> function16 = lambda$1582488484$material3;
                            final Function2<? super Composer, ? super Integer, Unit> function17 = lambda$414328099$material3;
                            final Function2<? super Composer, ? super Integer, Unit> function18 = function2M3101getLambda$1514016380$material3;
                            final int i20 = iM3359getEndERTFSPs;
                            int i21 = i4 >> 12;
                            composer2 = composerStartRestartGroup;
                            SurfaceKt.m4323SurfaceT9BRK9s(WindowInsetsPaddingKt.onConsumedWindowInsetsChanged(companion, (Function1) objRememberedValue2), null, j6, j5, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(848889571, true, new Function2() { // from class: androidx.compose.material3.ScaffoldKt$$ExternalSyntheticLambda2
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return ScaffoldKt.Scaffold_TvnljyQ$lambda$2(i20, function15, function6, function17, function18, mutableWindowInsets, function16, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composerStartRestartGroup, 54), composer2, (i21 & 896) | 12582912 | (i21 & 7168), 114);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier2 = companion;
                            function11 = function2M3102getLambda$39202156$material3;
                            function12 = lambda$1582488484$material3;
                            function13 = lambda$414328099$material3;
                            function14 = function2M3101getLambda$1514016380$material3;
                            i13 = iM3359getEndERTFSPs;
                            windowInsets2 = contentWindowInsets;
                            j3 = j6;
                            j4 = j5;
                        } else {
                            composer2 = composerStartRestartGroup;
                            composer2.skipToGroupEnd();
                            modifier2 = modifier;
                            windowInsets2 = windowInsets;
                            function11 = function7;
                            function12 = function8;
                            function13 = function9;
                            function14 = function10;
                            i13 = i;
                            j3 = j;
                            j4 = j2;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ScaffoldKt$$ExternalSyntheticLambda3
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return ScaffoldKt.Scaffold_TvnljyQ$lambda$3(modifier2, function11, function12, function13, function14, i13, j3, j4, windowInsets2, function6, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                        }
                    }
                    i4 |= 24576;
                    function10 = function5;
                    i11 = i3 & 32;
                    if (i11 != 0) {
                        i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    } else if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                        if (composerStartRestartGroup.changed(i)) {
                            i12 = 131072;
                        } else {
                            i12 = 65536;
                        }
                        i4 |= i12;
                    }
                    if ((i2 & 1572864) != 0) {
                        if ((i3 & 64) == 0) {
                            i16 = 524288;
                        } else {
                            i16 = 524288;
                        }
                        i4 |= i16;
                    }
                    if ((i2 & 12582912) != 0) {
                        if ((i3 & 128) == 0) {
                            i15 = 4194304;
                        } else {
                            i15 = 4194304;
                        }
                        i4 |= i15;
                    }
                    if ((i2 & 100663296) != 0) {
                        i4 |= ((i3 & 256) == 0 || !composerStartRestartGroup.changed(windowInsets)) ? 33554432 : 67108864;
                    }
                    if ((i2 & 805306368) == 0) {
                        if (composerStartRestartGroup.changedInstance(function6)) {
                            i14 = C.BUFFER_FLAG_LAST_SAMPLE;
                        } else {
                            i14 = 268435456;
                        }
                        i4 |= i14;
                    }
                    if ((i4 & 306783379) != 306783378) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "89@4637L11,90@4687L31,91@4777L19");
                        if ((i2 & 1) != 0) {
                            if (i17 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if (i18 != 0) {
                                function2M3102getLambda$39202156$material3 = ComposableSingletons$ScaffoldKt.INSTANCE.m3102getLambda$39202156$material3();
                            } else {
                                function2M3102getLambda$39202156$material3 = function7;
                            }
                            if (i5 != 0) {
                                lambda$1582488484$material3 = ComposableSingletons$ScaffoldKt.INSTANCE.getLambda$1582488484$material3();
                            } else {
                                lambda$1582488484$material3 = function8;
                            }
                            if (i7 != 0) {
                                lambda$414328099$material3 = ComposableSingletons$ScaffoldKt.INSTANCE.getLambda$414328099$material3();
                            } else {
                                lambda$414328099$material3 = function9;
                            }
                            if (i9 != 0) {
                                function2M3101getLambda$1514016380$material3 = ComposableSingletons$ScaffoldKt.INSTANCE.m3101getLambda$1514016380$material3();
                            } else {
                                function2M3101getLambda$1514016380$material3 = function10;
                            }
                            if (i11 != 0) {
                                iM3359getEndERTFSPs = FabPosition.INSTANCE.m3359getEndERTFSPs();
                            } else {
                                iM3359getEndERTFSPs = i;
                            }
                            if ((i3 & 64) != 0) {
                                i4 &= -3670017;
                                background = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).getBackground();
                            } else {
                                background = j;
                            }
                            if ((i3 & 128) != 0) {
                                jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(background, composerStartRestartGroup, (i4 >> 18) & 14);
                                i4 &= -29360129;
                            } else {
                                jM3051contentColorForek8zF_U = j2;
                            }
                            if ((i3 & 256) != 0) {
                                contentWindowInsets = ScaffoldDefaults.INSTANCE.getContentWindowInsets(composerStartRestartGroup, 6);
                                i4 &= -234881025;
                            } else {
                                contentWindowInsets = windowInsets;
                            }
                            j5 = jM3051contentColorForek8zF_U;
                        } else {
                            if (i17 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if (i18 != 0) {
                                function2M3102getLambda$39202156$material3 = ComposableSingletons$ScaffoldKt.INSTANCE.m3102getLambda$39202156$material3();
                            } else {
                                function2M3102getLambda$39202156$material3 = function7;
                            }
                            if (i5 != 0) {
                                lambda$1582488484$material3 = ComposableSingletons$ScaffoldKt.INSTANCE.getLambda$1582488484$material3();
                            } else {
                                lambda$1582488484$material3 = function8;
                            }
                            if (i7 != 0) {
                                lambda$414328099$material3 = ComposableSingletons$ScaffoldKt.INSTANCE.getLambda$414328099$material3();
                            } else {
                                lambda$414328099$material3 = function9;
                            }
                            if (i9 != 0) {
                                function2M3101getLambda$1514016380$material3 = ComposableSingletons$ScaffoldKt.INSTANCE.m3101getLambda$1514016380$material3();
                            } else {
                                function2M3101getLambda$1514016380$material3 = function10;
                            }
                            if (i11 != 0) {
                                iM3359getEndERTFSPs = FabPosition.INSTANCE.m3359getEndERTFSPs();
                            } else {
                                iM3359getEndERTFSPs = i;
                            }
                            if ((i3 & 64) != 0) {
                                i4 &= -3670017;
                                background = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).getBackground();
                            } else {
                                background = j;
                            }
                            if ((i3 & 128) != 0) {
                                jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(background, composerStartRestartGroup, (i4 >> 18) & 14);
                                i4 &= -29360129;
                            } else {
                                jM3051contentColorForek8zF_U = j2;
                            }
                            if ((i3 & 256) != 0) {
                                contentWindowInsets = ScaffoldDefaults.INSTANCE.getContentWindowInsets(composerStartRestartGroup, 6);
                                i4 &= -234881025;
                            } else {
                                contentWindowInsets = windowInsets;
                            }
                            j5 = jM3051contentColorForek8zF_U;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1211482744, i4, -1, "androidx.compose.material3.Scaffold (Scaffold.kt:93)");
                        }
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -298761166, "CC(remember):Scaffold.kt#9igjgp");
                        int i110 = (234881024 & i4) ^ r19;
                        if (i110 <= 67108864) {
                        }
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!z2) {
                            objRememberedValue = new MutableWindowInsets(contentWindowInsets);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = new MutableWindowInsets(contentWindowInsets);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        mutableWindowInsets = (MutableWindowInsets) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        long j7 = background;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -298755960, "CC(remember):Scaffold.kt#9igjgp");
                        zChanged = composerStartRestartGroup.changed(mutableWindowInsets) | ((i110 <= 67108864 && composerStartRestartGroup.changed(contentWindowInsets)) || (i4 & 100663296) == 67108864);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged) {
                            objRememberedValue2 = new Function1() { // from class: androidx.compose.material3.ScaffoldKt$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return ScaffoldKt.Scaffold_TvnljyQ$lambda$1$0(mutableWindowInsets, contentWindowInsets, (WindowInsets) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        } else {
                            objRememberedValue2 = new Function1() { // from class: androidx.compose.material3.ScaffoldKt$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return ScaffoldKt.Scaffold_TvnljyQ$lambda$1$0(mutableWindowInsets, contentWindowInsets, (WindowInsets) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        final Function2 function19 = function2M3102getLambda$39202156$material3;
                        final Function2 function110 = lambda$1582488484$material3;
                        final Function2 function111 = lambda$414328099$material3;
                        final Function2 function112 = function2M3101getLambda$1514016380$material3;
                        final int i22 = iM3359getEndERTFSPs;
                        int i23 = i4 >> 12;
                        composer2 = composerStartRestartGroup;
                        SurfaceKt.m4323SurfaceT9BRK9s(WindowInsetsPaddingKt.onConsumedWindowInsetsChanged(companion, (Function1) objRememberedValue2), null, j7, j5, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(848889571, true, new Function2() { // from class: androidx.compose.material3.ScaffoldKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return ScaffoldKt.Scaffold_TvnljyQ$lambda$2(i22, function19, function6, function111, function112, mutableWindowInsets, function110, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54), composer2, (i23 & 896) | 12582912 | (i23 & 7168), 114);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier2 = companion;
                        function11 = function2M3102getLambda$39202156$material3;
                        function12 = lambda$1582488484$material3;
                        function13 = lambda$414328099$material3;
                        function14 = function2M3101getLambda$1514016380$material3;
                        i13 = iM3359getEndERTFSPs;
                        windowInsets2 = contentWindowInsets;
                        j3 = j7;
                        j4 = j5;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        modifier2 = modifier;
                        windowInsets2 = windowInsets;
                        function11 = function7;
                        function12 = function8;
                        function13 = function9;
                        function14 = function10;
                        i13 = i;
                        j3 = j;
                        j4 = j2;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ScaffoldKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return ScaffoldKt.Scaffold_TvnljyQ$lambda$3(modifier2, function11, function12, function13, function14, i13, j3, j4, windowInsets2, function6, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i4 |= 3072;
                function9 = function4;
                i9 = i3 & 16;
                if (i9 != 0) {
                    if ((i2 & 24576) == 0) {
                        function10 = function5;
                        if (composerStartRestartGroup.changedInstance(function10)) {
                            i10 = 16384;
                        } else {
                            i10 = 8192;
                        }
                        i4 |= i10;
                    }
                    i11 = i3 & 32;
                    if (i11 != 0) {
                        i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    } else if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                        if (composerStartRestartGroup.changed(i)) {
                            i12 = 131072;
                        } else {
                            i12 = 65536;
                        }
                        i4 |= i12;
                    }
                    if ((i2 & 1572864) != 0) {
                        if ((i3 & 64) == 0) {
                            i16 = 524288;
                        } else {
                            i16 = 524288;
                        }
                        i4 |= i16;
                    }
                    if ((i2 & 12582912) != 0) {
                        if ((i3 & 128) == 0) {
                            i15 = 4194304;
                        } else {
                            i15 = 4194304;
                        }
                        i4 |= i15;
                    }
                    if ((i2 & 100663296) != 0) {
                        i4 |= ((i3 & 256) == 0 || !composerStartRestartGroup.changed(windowInsets)) ? 33554432 : 67108864;
                    }
                    if ((i2 & 805306368) == 0) {
                        if (composerStartRestartGroup.changedInstance(function6)) {
                            i14 = C.BUFFER_FLAG_LAST_SAMPLE;
                        } else {
                            i14 = 268435456;
                        }
                        i4 |= i14;
                    }
                    if ((i4 & 306783379) != 306783378) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "89@4637L11,90@4687L31,91@4777L19");
                        if ((i2 & 1) != 0) {
                            if (i17 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if (i18 != 0) {
                                function2M3102getLambda$39202156$material3 = ComposableSingletons$ScaffoldKt.INSTANCE.m3102getLambda$39202156$material3();
                            } else {
                                function2M3102getLambda$39202156$material3 = function7;
                            }
                            if (i5 != 0) {
                                lambda$1582488484$material3 = ComposableSingletons$ScaffoldKt.INSTANCE.getLambda$1582488484$material3();
                            } else {
                                lambda$1582488484$material3 = function8;
                            }
                            if (i7 != 0) {
                                lambda$414328099$material3 = ComposableSingletons$ScaffoldKt.INSTANCE.getLambda$414328099$material3();
                            } else {
                                lambda$414328099$material3 = function9;
                            }
                            if (i9 != 0) {
                                function2M3101getLambda$1514016380$material3 = ComposableSingletons$ScaffoldKt.INSTANCE.m3101getLambda$1514016380$material3();
                            } else {
                                function2M3101getLambda$1514016380$material3 = function10;
                            }
                            if (i11 != 0) {
                                iM3359getEndERTFSPs = FabPosition.INSTANCE.m3359getEndERTFSPs();
                            } else {
                                iM3359getEndERTFSPs = i;
                            }
                            if ((i3 & 64) != 0) {
                                i4 &= -3670017;
                                background = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).getBackground();
                            } else {
                                background = j;
                            }
                            if ((i3 & 128) != 0) {
                                jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(background, composerStartRestartGroup, (i4 >> 18) & 14);
                                i4 &= -29360129;
                            } else {
                                jM3051contentColorForek8zF_U = j2;
                            }
                            if ((i3 & 256) != 0) {
                                contentWindowInsets = ScaffoldDefaults.INSTANCE.getContentWindowInsets(composerStartRestartGroup, 6);
                                i4 &= -234881025;
                            } else {
                                contentWindowInsets = windowInsets;
                            }
                            j5 = jM3051contentColorForek8zF_U;
                        } else {
                            if (i17 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if (i18 != 0) {
                                function2M3102getLambda$39202156$material3 = ComposableSingletons$ScaffoldKt.INSTANCE.m3102getLambda$39202156$material3();
                            } else {
                                function2M3102getLambda$39202156$material3 = function7;
                            }
                            if (i5 != 0) {
                                lambda$1582488484$material3 = ComposableSingletons$ScaffoldKt.INSTANCE.getLambda$1582488484$material3();
                            } else {
                                lambda$1582488484$material3 = function8;
                            }
                            if (i7 != 0) {
                                lambda$414328099$material3 = ComposableSingletons$ScaffoldKt.INSTANCE.getLambda$414328099$material3();
                            } else {
                                lambda$414328099$material3 = function9;
                            }
                            if (i9 != 0) {
                                function2M3101getLambda$1514016380$material3 = ComposableSingletons$ScaffoldKt.INSTANCE.m3101getLambda$1514016380$material3();
                            } else {
                                function2M3101getLambda$1514016380$material3 = function10;
                            }
                            if (i11 != 0) {
                                iM3359getEndERTFSPs = FabPosition.INSTANCE.m3359getEndERTFSPs();
                            } else {
                                iM3359getEndERTFSPs = i;
                            }
                            if ((i3 & 64) != 0) {
                                i4 &= -3670017;
                                background = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).getBackground();
                            } else {
                                background = j;
                            }
                            if ((i3 & 128) != 0) {
                                jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(background, composerStartRestartGroup, (i4 >> 18) & 14);
                                i4 &= -29360129;
                            } else {
                                jM3051contentColorForek8zF_U = j2;
                            }
                            if ((i3 & 256) != 0) {
                                contentWindowInsets = ScaffoldDefaults.INSTANCE.getContentWindowInsets(composerStartRestartGroup, 6);
                                i4 &= -234881025;
                            } else {
                                contentWindowInsets = windowInsets;
                            }
                            j5 = jM3051contentColorForek8zF_U;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1211482744, i4, -1, "androidx.compose.material3.Scaffold (Scaffold.kt:93)");
                        }
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -298761166, "CC(remember):Scaffold.kt#9igjgp");
                        int i111 = (234881024 & i4) ^ r19;
                        if (i111 <= 67108864) {
                        }
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!z2) {
                            objRememberedValue = new MutableWindowInsets(contentWindowInsets);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = new MutableWindowInsets(contentWindowInsets);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        mutableWindowInsets = (MutableWindowInsets) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        long j8 = background;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -298755960, "CC(remember):Scaffold.kt#9igjgp");
                        zChanged = composerStartRestartGroup.changed(mutableWindowInsets) | ((i111 <= 67108864 && composerStartRestartGroup.changed(contentWindowInsets)) || (i4 & 100663296) == 67108864);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged) {
                            objRememberedValue2 = new Function1() { // from class: androidx.compose.material3.ScaffoldKt$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return ScaffoldKt.Scaffold_TvnljyQ$lambda$1$0(mutableWindowInsets, contentWindowInsets, (WindowInsets) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        } else {
                            objRememberedValue2 = new Function1() { // from class: androidx.compose.material3.ScaffoldKt$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return ScaffoldKt.Scaffold_TvnljyQ$lambda$1$0(mutableWindowInsets, contentWindowInsets, (WindowInsets) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        final Function2 function113 = function2M3102getLambda$39202156$material3;
                        final Function2 function114 = lambda$1582488484$material3;
                        final Function2 function115 = lambda$414328099$material3;
                        final Function2 function116 = function2M3101getLambda$1514016380$material3;
                        final int i24 = iM3359getEndERTFSPs;
                        int i25 = i4 >> 12;
                        composer2 = composerStartRestartGroup;
                        SurfaceKt.m4323SurfaceT9BRK9s(WindowInsetsPaddingKt.onConsumedWindowInsetsChanged(companion, (Function1) objRememberedValue2), null, j8, j5, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(848889571, true, new Function2() { // from class: androidx.compose.material3.ScaffoldKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return ScaffoldKt.Scaffold_TvnljyQ$lambda$2(i24, function113, function6, function115, function116, mutableWindowInsets, function114, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54), composer2, (i25 & 896) | 12582912 | (i25 & 7168), 114);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier2 = companion;
                        function11 = function2M3102getLambda$39202156$material3;
                        function12 = lambda$1582488484$material3;
                        function13 = lambda$414328099$material3;
                        function14 = function2M3101getLambda$1514016380$material3;
                        i13 = iM3359getEndERTFSPs;
                        windowInsets2 = contentWindowInsets;
                        j3 = j8;
                        j4 = j5;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        modifier2 = modifier;
                        windowInsets2 = windowInsets;
                        function11 = function7;
                        function12 = function8;
                        function13 = function9;
                        function14 = function10;
                        i13 = i;
                        j3 = j;
                        j4 = j2;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ScaffoldKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return ScaffoldKt.Scaffold_TvnljyQ$lambda$3(modifier2, function11, function12, function13, function14, i13, j3, j4, windowInsets2, function6, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i4 |= 24576;
                function10 = function5;
                i11 = i3 & 32;
                if (i11 != 0) {
                    i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    if (composerStartRestartGroup.changed(i)) {
                        i12 = 131072;
                    } else {
                        i12 = 65536;
                    }
                    i4 |= i12;
                }
                if ((i2 & 1572864) != 0) {
                    if ((i3 & 64) == 0) {
                        i16 = 524288;
                    } else {
                        i16 = 524288;
                    }
                    i4 |= i16;
                }
                if ((i2 & 12582912) != 0) {
                    if ((i3 & 128) == 0) {
                        i15 = 4194304;
                    } else {
                        i15 = 4194304;
                    }
                    i4 |= i15;
                }
                if ((i2 & 100663296) != 0) {
                    i4 |= ((i3 & 256) == 0 || !composerStartRestartGroup.changed(windowInsets)) ? 33554432 : 67108864;
                }
                if ((i2 & 805306368) == 0) {
                    if (composerStartRestartGroup.changedInstance(function6)) {
                        i14 = C.BUFFER_FLAG_LAST_SAMPLE;
                    } else {
                        i14 = 268435456;
                    }
                    i4 |= i14;
                }
                if ((i4 & 306783379) != 306783378) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "89@4637L11,90@4687L31,91@4777L19");
                    if ((i2 & 1) != 0) {
                        if (i17 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i18 != 0) {
                            function2M3102getLambda$39202156$material3 = ComposableSingletons$ScaffoldKt.INSTANCE.m3102getLambda$39202156$material3();
                        } else {
                            function2M3102getLambda$39202156$material3 = function7;
                        }
                        if (i5 != 0) {
                            lambda$1582488484$material3 = ComposableSingletons$ScaffoldKt.INSTANCE.getLambda$1582488484$material3();
                        } else {
                            lambda$1582488484$material3 = function8;
                        }
                        if (i7 != 0) {
                            lambda$414328099$material3 = ComposableSingletons$ScaffoldKt.INSTANCE.getLambda$414328099$material3();
                        } else {
                            lambda$414328099$material3 = function9;
                        }
                        if (i9 != 0) {
                            function2M3101getLambda$1514016380$material3 = ComposableSingletons$ScaffoldKt.INSTANCE.m3101getLambda$1514016380$material3();
                        } else {
                            function2M3101getLambda$1514016380$material3 = function10;
                        }
                        if (i11 != 0) {
                            iM3359getEndERTFSPs = FabPosition.INSTANCE.m3359getEndERTFSPs();
                        } else {
                            iM3359getEndERTFSPs = i;
                        }
                        if ((i3 & 64) != 0) {
                            i4 &= -3670017;
                            background = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).getBackground();
                        } else {
                            background = j;
                        }
                        if ((i3 & 128) != 0) {
                            jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(background, composerStartRestartGroup, (i4 >> 18) & 14);
                            i4 &= -29360129;
                        } else {
                            jM3051contentColorForek8zF_U = j2;
                        }
                        if ((i3 & 256) != 0) {
                            contentWindowInsets = ScaffoldDefaults.INSTANCE.getContentWindowInsets(composerStartRestartGroup, 6);
                            i4 &= -234881025;
                        } else {
                            contentWindowInsets = windowInsets;
                        }
                        j5 = jM3051contentColorForek8zF_U;
                    } else {
                        if (i17 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i18 != 0) {
                            function2M3102getLambda$39202156$material3 = ComposableSingletons$ScaffoldKt.INSTANCE.m3102getLambda$39202156$material3();
                        } else {
                            function2M3102getLambda$39202156$material3 = function7;
                        }
                        if (i5 != 0) {
                            lambda$1582488484$material3 = ComposableSingletons$ScaffoldKt.INSTANCE.getLambda$1582488484$material3();
                        } else {
                            lambda$1582488484$material3 = function8;
                        }
                        if (i7 != 0) {
                            lambda$414328099$material3 = ComposableSingletons$ScaffoldKt.INSTANCE.getLambda$414328099$material3();
                        } else {
                            lambda$414328099$material3 = function9;
                        }
                        if (i9 != 0) {
                            function2M3101getLambda$1514016380$material3 = ComposableSingletons$ScaffoldKt.INSTANCE.m3101getLambda$1514016380$material3();
                        } else {
                            function2M3101getLambda$1514016380$material3 = function10;
                        }
                        if (i11 != 0) {
                            iM3359getEndERTFSPs = FabPosition.INSTANCE.m3359getEndERTFSPs();
                        } else {
                            iM3359getEndERTFSPs = i;
                        }
                        if ((i3 & 64) != 0) {
                            i4 &= -3670017;
                            background = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).getBackground();
                        } else {
                            background = j;
                        }
                        if ((i3 & 128) != 0) {
                            jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(background, composerStartRestartGroup, (i4 >> 18) & 14);
                            i4 &= -29360129;
                        } else {
                            jM3051contentColorForek8zF_U = j2;
                        }
                        if ((i3 & 256) != 0) {
                            contentWindowInsets = ScaffoldDefaults.INSTANCE.getContentWindowInsets(composerStartRestartGroup, 6);
                            i4 &= -234881025;
                        } else {
                            contentWindowInsets = windowInsets;
                        }
                        j5 = jM3051contentColorForek8zF_U;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1211482744, i4, -1, "androidx.compose.material3.Scaffold (Scaffold.kt:93)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -298761166, "CC(remember):Scaffold.kt#9igjgp");
                    int i112 = (234881024 & i4) ^ r19;
                    if (i112 <= 67108864) {
                    }
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z2) {
                        objRememberedValue = new MutableWindowInsets(contentWindowInsets);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new MutableWindowInsets(contentWindowInsets);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    mutableWindowInsets = (MutableWindowInsets) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    long j9 = background;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -298755960, "CC(remember):Scaffold.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(mutableWindowInsets) | ((i112 <= 67108864 && composerStartRestartGroup.changed(contentWindowInsets)) || (i4 & 100663296) == 67108864);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue2 = new Function1() { // from class: androidx.compose.material3.ScaffoldKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return ScaffoldKt.Scaffold_TvnljyQ$lambda$1$0(mutableWindowInsets, contentWindowInsets, (WindowInsets) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new Function1() { // from class: androidx.compose.material3.ScaffoldKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return ScaffoldKt.Scaffold_TvnljyQ$lambda$1$0(mutableWindowInsets, contentWindowInsets, (WindowInsets) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    final Function2 function117 = function2M3102getLambda$39202156$material3;
                    final Function2 function118 = lambda$1582488484$material3;
                    final Function2 function119 = lambda$414328099$material3;
                    final Function2 function1110 = function2M3101getLambda$1514016380$material3;
                    final int i26 = iM3359getEndERTFSPs;
                    int i27 = i4 >> 12;
                    composer2 = composerStartRestartGroup;
                    SurfaceKt.m4323SurfaceT9BRK9s(WindowInsetsPaddingKt.onConsumedWindowInsetsChanged(companion, (Function1) objRememberedValue2), null, j9, j5, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(848889571, true, new Function2() { // from class: androidx.compose.material3.ScaffoldKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ScaffoldKt.Scaffold_TvnljyQ$lambda$2(i26, function117, function6, function119, function1110, mutableWindowInsets, function118, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composer2, (i27 & 896) | 12582912 | (i27 & 7168), 114);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier2 = companion;
                    function11 = function2M3102getLambda$39202156$material3;
                    function12 = lambda$1582488484$material3;
                    function13 = lambda$414328099$material3;
                    function14 = function2M3101getLambda$1514016380$material3;
                    i13 = iM3359getEndERTFSPs;
                    windowInsets2 = contentWindowInsets;
                    j3 = j9;
                    j4 = j5;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    modifier2 = modifier;
                    windowInsets2 = windowInsets;
                    function11 = function7;
                    function12 = function8;
                    function13 = function9;
                    function14 = function10;
                    i13 = i;
                    j3 = j;
                    j4 = j2;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ScaffoldKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ScaffoldKt.Scaffold_TvnljyQ$lambda$3(modifier2, function11, function12, function13, function14, i13, j3, j4, windowInsets2, function6, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i4 |= 384;
            function8 = function3;
            i7 = i3 & 8;
            if (i7 != 0) {
                if ((i2 & 3072) == 0) {
                    function9 = function4;
                    if (composerStartRestartGroup.changedInstance(function9)) {
                        i8 = 2048;
                    } else {
                        i8 = 1024;
                    }
                    i4 |= i8;
                }
                i9 = i3 & 16;
                if (i9 != 0) {
                    if ((i2 & 24576) == 0) {
                        function10 = function5;
                        if (composerStartRestartGroup.changedInstance(function10)) {
                            i10 = 16384;
                        } else {
                            i10 = 8192;
                        }
                        i4 |= i10;
                    }
                    i11 = i3 & 32;
                    if (i11 != 0) {
                        i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    } else if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                        if (composerStartRestartGroup.changed(i)) {
                            i12 = 131072;
                        } else {
                            i12 = 65536;
                        }
                        i4 |= i12;
                    }
                    if ((i2 & 1572864) != 0) {
                        if ((i3 & 64) == 0) {
                            i16 = 524288;
                        } else {
                            i16 = 524288;
                        }
                        i4 |= i16;
                    }
                    if ((i2 & 12582912) != 0) {
                        if ((i3 & 128) == 0) {
                            i15 = 4194304;
                        } else {
                            i15 = 4194304;
                        }
                        i4 |= i15;
                    }
                    if ((i2 & 100663296) != 0) {
                        i4 |= ((i3 & 256) == 0 || !composerStartRestartGroup.changed(windowInsets)) ? 33554432 : 67108864;
                    }
                    if ((i2 & 805306368) == 0) {
                        if (composerStartRestartGroup.changedInstance(function6)) {
                            i14 = C.BUFFER_FLAG_LAST_SAMPLE;
                        } else {
                            i14 = 268435456;
                        }
                        i4 |= i14;
                    }
                    if ((i4 & 306783379) != 306783378) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "89@4637L11,90@4687L31,91@4777L19");
                        if ((i2 & 1) != 0) {
                            if (i17 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if (i18 != 0) {
                                function2M3102getLambda$39202156$material3 = ComposableSingletons$ScaffoldKt.INSTANCE.m3102getLambda$39202156$material3();
                            } else {
                                function2M3102getLambda$39202156$material3 = function7;
                            }
                            if (i5 != 0) {
                                lambda$1582488484$material3 = ComposableSingletons$ScaffoldKt.INSTANCE.getLambda$1582488484$material3();
                            } else {
                                lambda$1582488484$material3 = function8;
                            }
                            if (i7 != 0) {
                                lambda$414328099$material3 = ComposableSingletons$ScaffoldKt.INSTANCE.getLambda$414328099$material3();
                            } else {
                                lambda$414328099$material3 = function9;
                            }
                            if (i9 != 0) {
                                function2M3101getLambda$1514016380$material3 = ComposableSingletons$ScaffoldKt.INSTANCE.m3101getLambda$1514016380$material3();
                            } else {
                                function2M3101getLambda$1514016380$material3 = function10;
                            }
                            if (i11 != 0) {
                                iM3359getEndERTFSPs = FabPosition.INSTANCE.m3359getEndERTFSPs();
                            } else {
                                iM3359getEndERTFSPs = i;
                            }
                            if ((i3 & 64) != 0) {
                                i4 &= -3670017;
                                background = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).getBackground();
                            } else {
                                background = j;
                            }
                            if ((i3 & 128) != 0) {
                                jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(background, composerStartRestartGroup, (i4 >> 18) & 14);
                                i4 &= -29360129;
                            } else {
                                jM3051contentColorForek8zF_U = j2;
                            }
                            if ((i3 & 256) != 0) {
                                contentWindowInsets = ScaffoldDefaults.INSTANCE.getContentWindowInsets(composerStartRestartGroup, 6);
                                i4 &= -234881025;
                            } else {
                                contentWindowInsets = windowInsets;
                            }
                            j5 = jM3051contentColorForek8zF_U;
                        } else {
                            if (i17 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if (i18 != 0) {
                                function2M3102getLambda$39202156$material3 = ComposableSingletons$ScaffoldKt.INSTANCE.m3102getLambda$39202156$material3();
                            } else {
                                function2M3102getLambda$39202156$material3 = function7;
                            }
                            if (i5 != 0) {
                                lambda$1582488484$material3 = ComposableSingletons$ScaffoldKt.INSTANCE.getLambda$1582488484$material3();
                            } else {
                                lambda$1582488484$material3 = function8;
                            }
                            if (i7 != 0) {
                                lambda$414328099$material3 = ComposableSingletons$ScaffoldKt.INSTANCE.getLambda$414328099$material3();
                            } else {
                                lambda$414328099$material3 = function9;
                            }
                            if (i9 != 0) {
                                function2M3101getLambda$1514016380$material3 = ComposableSingletons$ScaffoldKt.INSTANCE.m3101getLambda$1514016380$material3();
                            } else {
                                function2M3101getLambda$1514016380$material3 = function10;
                            }
                            if (i11 != 0) {
                                iM3359getEndERTFSPs = FabPosition.INSTANCE.m3359getEndERTFSPs();
                            } else {
                                iM3359getEndERTFSPs = i;
                            }
                            if ((i3 & 64) != 0) {
                                i4 &= -3670017;
                                background = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).getBackground();
                            } else {
                                background = j;
                            }
                            if ((i3 & 128) != 0) {
                                jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(background, composerStartRestartGroup, (i4 >> 18) & 14);
                                i4 &= -29360129;
                            } else {
                                jM3051contentColorForek8zF_U = j2;
                            }
                            if ((i3 & 256) != 0) {
                                contentWindowInsets = ScaffoldDefaults.INSTANCE.getContentWindowInsets(composerStartRestartGroup, 6);
                                i4 &= -234881025;
                            } else {
                                contentWindowInsets = windowInsets;
                            }
                            j5 = jM3051contentColorForek8zF_U;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1211482744, i4, -1, "androidx.compose.material3.Scaffold (Scaffold.kt:93)");
                        }
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -298761166, "CC(remember):Scaffold.kt#9igjgp");
                        int i113 = (234881024 & i4) ^ r19;
                        if (i113 <= 67108864) {
                        }
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!z2) {
                            objRememberedValue = new MutableWindowInsets(contentWindowInsets);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = new MutableWindowInsets(contentWindowInsets);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        mutableWindowInsets = (MutableWindowInsets) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        long j10 = background;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -298755960, "CC(remember):Scaffold.kt#9igjgp");
                        zChanged = composerStartRestartGroup.changed(mutableWindowInsets) | ((i113 <= 67108864 && composerStartRestartGroup.changed(contentWindowInsets)) || (i4 & 100663296) == 67108864);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged) {
                            objRememberedValue2 = new Function1() { // from class: androidx.compose.material3.ScaffoldKt$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return ScaffoldKt.Scaffold_TvnljyQ$lambda$1$0(mutableWindowInsets, contentWindowInsets, (WindowInsets) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        } else {
                            objRememberedValue2 = new Function1() { // from class: androidx.compose.material3.ScaffoldKt$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return ScaffoldKt.Scaffold_TvnljyQ$lambda$1$0(mutableWindowInsets, contentWindowInsets, (WindowInsets) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        final Function2 function1111 = function2M3102getLambda$39202156$material3;
                        final Function2 function1112 = lambda$1582488484$material3;
                        final Function2 function1113 = lambda$414328099$material3;
                        final Function2 function1114 = function2M3101getLambda$1514016380$material3;
                        final int i28 = iM3359getEndERTFSPs;
                        int i29 = i4 >> 12;
                        composer2 = composerStartRestartGroup;
                        SurfaceKt.m4323SurfaceT9BRK9s(WindowInsetsPaddingKt.onConsumedWindowInsetsChanged(companion, (Function1) objRememberedValue2), null, j10, j5, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(848889571, true, new Function2() { // from class: androidx.compose.material3.ScaffoldKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return ScaffoldKt.Scaffold_TvnljyQ$lambda$2(i28, function1111, function6, function1113, function1114, mutableWindowInsets, function1112, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54), composer2, (i29 & 896) | 12582912 | (i29 & 7168), 114);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier2 = companion;
                        function11 = function2M3102getLambda$39202156$material3;
                        function12 = lambda$1582488484$material3;
                        function13 = lambda$414328099$material3;
                        function14 = function2M3101getLambda$1514016380$material3;
                        i13 = iM3359getEndERTFSPs;
                        windowInsets2 = contentWindowInsets;
                        j3 = j10;
                        j4 = j5;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        modifier2 = modifier;
                        windowInsets2 = windowInsets;
                        function11 = function7;
                        function12 = function8;
                        function13 = function9;
                        function14 = function10;
                        i13 = i;
                        j3 = j;
                        j4 = j2;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ScaffoldKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return ScaffoldKt.Scaffold_TvnljyQ$lambda$3(modifier2, function11, function12, function13, function14, i13, j3, j4, windowInsets2, function6, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i4 |= 24576;
                function10 = function5;
                i11 = i3 & 32;
                if (i11 != 0) {
                    i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    if (composerStartRestartGroup.changed(i)) {
                        i12 = 131072;
                    } else {
                        i12 = 65536;
                    }
                    i4 |= i12;
                }
                if ((i2 & 1572864) != 0) {
                    if ((i3 & 64) == 0) {
                        i16 = 524288;
                    } else {
                        i16 = 524288;
                    }
                    i4 |= i16;
                }
                if ((i2 & 12582912) != 0) {
                    if ((i3 & 128) == 0) {
                        i15 = 4194304;
                    } else {
                        i15 = 4194304;
                    }
                    i4 |= i15;
                }
                if ((i2 & 100663296) != 0) {
                    i4 |= ((i3 & 256) == 0 || !composerStartRestartGroup.changed(windowInsets)) ? 33554432 : 67108864;
                }
                if ((i2 & 805306368) == 0) {
                    if (composerStartRestartGroup.changedInstance(function6)) {
                        i14 = C.BUFFER_FLAG_LAST_SAMPLE;
                    } else {
                        i14 = 268435456;
                    }
                    i4 |= i14;
                }
                if ((i4 & 306783379) != 306783378) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "89@4637L11,90@4687L31,91@4777L19");
                    if ((i2 & 1) != 0) {
                        if (i17 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i18 != 0) {
                            function2M3102getLambda$39202156$material3 = ComposableSingletons$ScaffoldKt.INSTANCE.m3102getLambda$39202156$material3();
                        } else {
                            function2M3102getLambda$39202156$material3 = function7;
                        }
                        if (i5 != 0) {
                            lambda$1582488484$material3 = ComposableSingletons$ScaffoldKt.INSTANCE.getLambda$1582488484$material3();
                        } else {
                            lambda$1582488484$material3 = function8;
                        }
                        if (i7 != 0) {
                            lambda$414328099$material3 = ComposableSingletons$ScaffoldKt.INSTANCE.getLambda$414328099$material3();
                        } else {
                            lambda$414328099$material3 = function9;
                        }
                        if (i9 != 0) {
                            function2M3101getLambda$1514016380$material3 = ComposableSingletons$ScaffoldKt.INSTANCE.m3101getLambda$1514016380$material3();
                        } else {
                            function2M3101getLambda$1514016380$material3 = function10;
                        }
                        if (i11 != 0) {
                            iM3359getEndERTFSPs = FabPosition.INSTANCE.m3359getEndERTFSPs();
                        } else {
                            iM3359getEndERTFSPs = i;
                        }
                        if ((i3 & 64) != 0) {
                            i4 &= -3670017;
                            background = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).getBackground();
                        } else {
                            background = j;
                        }
                        if ((i3 & 128) != 0) {
                            jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(background, composerStartRestartGroup, (i4 >> 18) & 14);
                            i4 &= -29360129;
                        } else {
                            jM3051contentColorForek8zF_U = j2;
                        }
                        if ((i3 & 256) != 0) {
                            contentWindowInsets = ScaffoldDefaults.INSTANCE.getContentWindowInsets(composerStartRestartGroup, 6);
                            i4 &= -234881025;
                        } else {
                            contentWindowInsets = windowInsets;
                        }
                        j5 = jM3051contentColorForek8zF_U;
                    } else {
                        if (i17 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i18 != 0) {
                            function2M3102getLambda$39202156$material3 = ComposableSingletons$ScaffoldKt.INSTANCE.m3102getLambda$39202156$material3();
                        } else {
                            function2M3102getLambda$39202156$material3 = function7;
                        }
                        if (i5 != 0) {
                            lambda$1582488484$material3 = ComposableSingletons$ScaffoldKt.INSTANCE.getLambda$1582488484$material3();
                        } else {
                            lambda$1582488484$material3 = function8;
                        }
                        if (i7 != 0) {
                            lambda$414328099$material3 = ComposableSingletons$ScaffoldKt.INSTANCE.getLambda$414328099$material3();
                        } else {
                            lambda$414328099$material3 = function9;
                        }
                        if (i9 != 0) {
                            function2M3101getLambda$1514016380$material3 = ComposableSingletons$ScaffoldKt.INSTANCE.m3101getLambda$1514016380$material3();
                        } else {
                            function2M3101getLambda$1514016380$material3 = function10;
                        }
                        if (i11 != 0) {
                            iM3359getEndERTFSPs = FabPosition.INSTANCE.m3359getEndERTFSPs();
                        } else {
                            iM3359getEndERTFSPs = i;
                        }
                        if ((i3 & 64) != 0) {
                            i4 &= -3670017;
                            background = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).getBackground();
                        } else {
                            background = j;
                        }
                        if ((i3 & 128) != 0) {
                            jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(background, composerStartRestartGroup, (i4 >> 18) & 14);
                            i4 &= -29360129;
                        } else {
                            jM3051contentColorForek8zF_U = j2;
                        }
                        if ((i3 & 256) != 0) {
                            contentWindowInsets = ScaffoldDefaults.INSTANCE.getContentWindowInsets(composerStartRestartGroup, 6);
                            i4 &= -234881025;
                        } else {
                            contentWindowInsets = windowInsets;
                        }
                        j5 = jM3051contentColorForek8zF_U;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1211482744, i4, -1, "androidx.compose.material3.Scaffold (Scaffold.kt:93)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -298761166, "CC(remember):Scaffold.kt#9igjgp");
                    int i114 = (234881024 & i4) ^ r19;
                    if (i114 <= 67108864) {
                    }
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z2) {
                        objRememberedValue = new MutableWindowInsets(contentWindowInsets);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new MutableWindowInsets(contentWindowInsets);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    mutableWindowInsets = (MutableWindowInsets) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    long j11 = background;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -298755960, "CC(remember):Scaffold.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(mutableWindowInsets) | ((i114 <= 67108864 && composerStartRestartGroup.changed(contentWindowInsets)) || (i4 & 100663296) == 67108864);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue2 = new Function1() { // from class: androidx.compose.material3.ScaffoldKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return ScaffoldKt.Scaffold_TvnljyQ$lambda$1$0(mutableWindowInsets, contentWindowInsets, (WindowInsets) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new Function1() { // from class: androidx.compose.material3.ScaffoldKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return ScaffoldKt.Scaffold_TvnljyQ$lambda$1$0(mutableWindowInsets, contentWindowInsets, (WindowInsets) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    final Function2 function1115 = function2M3102getLambda$39202156$material3;
                    final Function2 function1116 = lambda$1582488484$material3;
                    final Function2 function1117 = lambda$414328099$material3;
                    final Function2 function1118 = function2M3101getLambda$1514016380$material3;
                    final int i210 = iM3359getEndERTFSPs;
                    int i211 = i4 >> 12;
                    composer2 = composerStartRestartGroup;
                    SurfaceKt.m4323SurfaceT9BRK9s(WindowInsetsPaddingKt.onConsumedWindowInsetsChanged(companion, (Function1) objRememberedValue2), null, j11, j5, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(848889571, true, new Function2() { // from class: androidx.compose.material3.ScaffoldKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ScaffoldKt.Scaffold_TvnljyQ$lambda$2(i210, function1115, function6, function1117, function1118, mutableWindowInsets, function1116, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composer2, (i211 & 896) | 12582912 | (i211 & 7168), 114);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier2 = companion;
                    function11 = function2M3102getLambda$39202156$material3;
                    function12 = lambda$1582488484$material3;
                    function13 = lambda$414328099$material3;
                    function14 = function2M3101getLambda$1514016380$material3;
                    i13 = iM3359getEndERTFSPs;
                    windowInsets2 = contentWindowInsets;
                    j3 = j11;
                    j4 = j5;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    modifier2 = modifier;
                    windowInsets2 = windowInsets;
                    function11 = function7;
                    function12 = function8;
                    function13 = function9;
                    function14 = function10;
                    i13 = i;
                    j3 = j;
                    j4 = j2;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ScaffoldKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ScaffoldKt.Scaffold_TvnljyQ$lambda$3(modifier2, function11, function12, function13, function14, i13, j3, j4, windowInsets2, function6, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i4 |= 3072;
            function9 = function4;
            i9 = i3 & 16;
            if (i9 != 0) {
                if ((i2 & 24576) == 0) {
                    function10 = function5;
                    if (composerStartRestartGroup.changedInstance(function10)) {
                        i10 = 16384;
                    } else {
                        i10 = 8192;
                    }
                    i4 |= i10;
                }
                i11 = i3 & 32;
                if (i11 != 0) {
                    i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    if (composerStartRestartGroup.changed(i)) {
                        i12 = 131072;
                    } else {
                        i12 = 65536;
                    }
                    i4 |= i12;
                }
                if ((i2 & 1572864) != 0) {
                    if ((i3 & 64) == 0) {
                        i16 = 524288;
                    } else {
                        i16 = 524288;
                    }
                    i4 |= i16;
                }
                if ((i2 & 12582912) != 0) {
                    if ((i3 & 128) == 0) {
                        i15 = 4194304;
                    } else {
                        i15 = 4194304;
                    }
                    i4 |= i15;
                }
                if ((i2 & 100663296) != 0) {
                    i4 |= ((i3 & 256) == 0 || !composerStartRestartGroup.changed(windowInsets)) ? 33554432 : 67108864;
                }
                if ((i2 & 805306368) == 0) {
                    if (composerStartRestartGroup.changedInstance(function6)) {
                        i14 = C.BUFFER_FLAG_LAST_SAMPLE;
                    } else {
                        i14 = 268435456;
                    }
                    i4 |= i14;
                }
                if ((i4 & 306783379) != 306783378) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "89@4637L11,90@4687L31,91@4777L19");
                    if ((i2 & 1) != 0) {
                        if (i17 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i18 != 0) {
                            function2M3102getLambda$39202156$material3 = ComposableSingletons$ScaffoldKt.INSTANCE.m3102getLambda$39202156$material3();
                        } else {
                            function2M3102getLambda$39202156$material3 = function7;
                        }
                        if (i5 != 0) {
                            lambda$1582488484$material3 = ComposableSingletons$ScaffoldKt.INSTANCE.getLambda$1582488484$material3();
                        } else {
                            lambda$1582488484$material3 = function8;
                        }
                        if (i7 != 0) {
                            lambda$414328099$material3 = ComposableSingletons$ScaffoldKt.INSTANCE.getLambda$414328099$material3();
                        } else {
                            lambda$414328099$material3 = function9;
                        }
                        if (i9 != 0) {
                            function2M3101getLambda$1514016380$material3 = ComposableSingletons$ScaffoldKt.INSTANCE.m3101getLambda$1514016380$material3();
                        } else {
                            function2M3101getLambda$1514016380$material3 = function10;
                        }
                        if (i11 != 0) {
                            iM3359getEndERTFSPs = FabPosition.INSTANCE.m3359getEndERTFSPs();
                        } else {
                            iM3359getEndERTFSPs = i;
                        }
                        if ((i3 & 64) != 0) {
                            i4 &= -3670017;
                            background = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).getBackground();
                        } else {
                            background = j;
                        }
                        if ((i3 & 128) != 0) {
                            jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(background, composerStartRestartGroup, (i4 >> 18) & 14);
                            i4 &= -29360129;
                        } else {
                            jM3051contentColorForek8zF_U = j2;
                        }
                        if ((i3 & 256) != 0) {
                            contentWindowInsets = ScaffoldDefaults.INSTANCE.getContentWindowInsets(composerStartRestartGroup, 6);
                            i4 &= -234881025;
                        } else {
                            contentWindowInsets = windowInsets;
                        }
                        j5 = jM3051contentColorForek8zF_U;
                    } else {
                        if (i17 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i18 != 0) {
                            function2M3102getLambda$39202156$material3 = ComposableSingletons$ScaffoldKt.INSTANCE.m3102getLambda$39202156$material3();
                        } else {
                            function2M3102getLambda$39202156$material3 = function7;
                        }
                        if (i5 != 0) {
                            lambda$1582488484$material3 = ComposableSingletons$ScaffoldKt.INSTANCE.getLambda$1582488484$material3();
                        } else {
                            lambda$1582488484$material3 = function8;
                        }
                        if (i7 != 0) {
                            lambda$414328099$material3 = ComposableSingletons$ScaffoldKt.INSTANCE.getLambda$414328099$material3();
                        } else {
                            lambda$414328099$material3 = function9;
                        }
                        if (i9 != 0) {
                            function2M3101getLambda$1514016380$material3 = ComposableSingletons$ScaffoldKt.INSTANCE.m3101getLambda$1514016380$material3();
                        } else {
                            function2M3101getLambda$1514016380$material3 = function10;
                        }
                        if (i11 != 0) {
                            iM3359getEndERTFSPs = FabPosition.INSTANCE.m3359getEndERTFSPs();
                        } else {
                            iM3359getEndERTFSPs = i;
                        }
                        if ((i3 & 64) != 0) {
                            i4 &= -3670017;
                            background = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).getBackground();
                        } else {
                            background = j;
                        }
                        if ((i3 & 128) != 0) {
                            jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(background, composerStartRestartGroup, (i4 >> 18) & 14);
                            i4 &= -29360129;
                        } else {
                            jM3051contentColorForek8zF_U = j2;
                        }
                        if ((i3 & 256) != 0) {
                            contentWindowInsets = ScaffoldDefaults.INSTANCE.getContentWindowInsets(composerStartRestartGroup, 6);
                            i4 &= -234881025;
                        } else {
                            contentWindowInsets = windowInsets;
                        }
                        j5 = jM3051contentColorForek8zF_U;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1211482744, i4, -1, "androidx.compose.material3.Scaffold (Scaffold.kt:93)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -298761166, "CC(remember):Scaffold.kt#9igjgp");
                    int i115 = (234881024 & i4) ^ r19;
                    if (i115 <= 67108864) {
                    }
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z2) {
                        objRememberedValue = new MutableWindowInsets(contentWindowInsets);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new MutableWindowInsets(contentWindowInsets);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    mutableWindowInsets = (MutableWindowInsets) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    long j12 = background;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -298755960, "CC(remember):Scaffold.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(mutableWindowInsets) | ((i115 <= 67108864 && composerStartRestartGroup.changed(contentWindowInsets)) || (i4 & 100663296) == 67108864);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue2 = new Function1() { // from class: androidx.compose.material3.ScaffoldKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return ScaffoldKt.Scaffold_TvnljyQ$lambda$1$0(mutableWindowInsets, contentWindowInsets, (WindowInsets) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new Function1() { // from class: androidx.compose.material3.ScaffoldKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return ScaffoldKt.Scaffold_TvnljyQ$lambda$1$0(mutableWindowInsets, contentWindowInsets, (WindowInsets) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    final Function2 function1119 = function2M3102getLambda$39202156$material3;
                    final Function2 function11110 = lambda$1582488484$material3;
                    final Function2 function11111 = lambda$414328099$material3;
                    final Function2 function11112 = function2M3101getLambda$1514016380$material3;
                    final int i212 = iM3359getEndERTFSPs;
                    int i213 = i4 >> 12;
                    composer2 = composerStartRestartGroup;
                    SurfaceKt.m4323SurfaceT9BRK9s(WindowInsetsPaddingKt.onConsumedWindowInsetsChanged(companion, (Function1) objRememberedValue2), null, j12, j5, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(848889571, true, new Function2() { // from class: androidx.compose.material3.ScaffoldKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ScaffoldKt.Scaffold_TvnljyQ$lambda$2(i212, function1119, function6, function11111, function11112, mutableWindowInsets, function11110, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composer2, (i213 & 896) | 12582912 | (i213 & 7168), 114);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier2 = companion;
                    function11 = function2M3102getLambda$39202156$material3;
                    function12 = lambda$1582488484$material3;
                    function13 = lambda$414328099$material3;
                    function14 = function2M3101getLambda$1514016380$material3;
                    i13 = iM3359getEndERTFSPs;
                    windowInsets2 = contentWindowInsets;
                    j3 = j12;
                    j4 = j5;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    modifier2 = modifier;
                    windowInsets2 = windowInsets;
                    function11 = function7;
                    function12 = function8;
                    function13 = function9;
                    function14 = function10;
                    i13 = i;
                    j3 = j;
                    j4 = j2;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ScaffoldKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ScaffoldKt.Scaffold_TvnljyQ$lambda$3(modifier2, function11, function12, function13, function14, i13, j3, j4, windowInsets2, function6, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i4 |= 24576;
            function10 = function5;
            i11 = i3 & 32;
            if (i11 != 0) {
                i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            } else if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                if (composerStartRestartGroup.changed(i)) {
                    i12 = 131072;
                } else {
                    i12 = 65536;
                }
                i4 |= i12;
            }
            if ((i2 & 1572864) != 0) {
                if ((i3 & 64) == 0) {
                    i16 = 524288;
                } else {
                    i16 = 524288;
                }
                i4 |= i16;
            }
            if ((i2 & 12582912) != 0) {
                if ((i3 & 128) == 0) {
                    i15 = 4194304;
                } else {
                    i15 = 4194304;
                }
                i4 |= i15;
            }
            if ((i2 & 100663296) != 0) {
                i4 |= ((i3 & 256) == 0 || !composerStartRestartGroup.changed(windowInsets)) ? 33554432 : 67108864;
            }
            if ((i2 & 805306368) == 0) {
                if (composerStartRestartGroup.changedInstance(function6)) {
                    i14 = C.BUFFER_FLAG_LAST_SAMPLE;
                } else {
                    i14 = 268435456;
                }
                i4 |= i14;
            }
            if ((i4 & 306783379) != 306783378) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "89@4637L11,90@4687L31,91@4777L19");
                if ((i2 & 1) != 0) {
                    if (i17 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i18 != 0) {
                        function2M3102getLambda$39202156$material3 = ComposableSingletons$ScaffoldKt.INSTANCE.m3102getLambda$39202156$material3();
                    } else {
                        function2M3102getLambda$39202156$material3 = function7;
                    }
                    if (i5 != 0) {
                        lambda$1582488484$material3 = ComposableSingletons$ScaffoldKt.INSTANCE.getLambda$1582488484$material3();
                    } else {
                        lambda$1582488484$material3 = function8;
                    }
                    if (i7 != 0) {
                        lambda$414328099$material3 = ComposableSingletons$ScaffoldKt.INSTANCE.getLambda$414328099$material3();
                    } else {
                        lambda$414328099$material3 = function9;
                    }
                    if (i9 != 0) {
                        function2M3101getLambda$1514016380$material3 = ComposableSingletons$ScaffoldKt.INSTANCE.m3101getLambda$1514016380$material3();
                    } else {
                        function2M3101getLambda$1514016380$material3 = function10;
                    }
                    if (i11 != 0) {
                        iM3359getEndERTFSPs = FabPosition.INSTANCE.m3359getEndERTFSPs();
                    } else {
                        iM3359getEndERTFSPs = i;
                    }
                    if ((i3 & 64) != 0) {
                        i4 &= -3670017;
                        background = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).getBackground();
                    } else {
                        background = j;
                    }
                    if ((i3 & 128) != 0) {
                        jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(background, composerStartRestartGroup, (i4 >> 18) & 14);
                        i4 &= -29360129;
                    } else {
                        jM3051contentColorForek8zF_U = j2;
                    }
                    if ((i3 & 256) != 0) {
                        contentWindowInsets = ScaffoldDefaults.INSTANCE.getContentWindowInsets(composerStartRestartGroup, 6);
                        i4 &= -234881025;
                    } else {
                        contentWindowInsets = windowInsets;
                    }
                    j5 = jM3051contentColorForek8zF_U;
                } else {
                    if (i17 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i18 != 0) {
                        function2M3102getLambda$39202156$material3 = ComposableSingletons$ScaffoldKt.INSTANCE.m3102getLambda$39202156$material3();
                    } else {
                        function2M3102getLambda$39202156$material3 = function7;
                    }
                    if (i5 != 0) {
                        lambda$1582488484$material3 = ComposableSingletons$ScaffoldKt.INSTANCE.getLambda$1582488484$material3();
                    } else {
                        lambda$1582488484$material3 = function8;
                    }
                    if (i7 != 0) {
                        lambda$414328099$material3 = ComposableSingletons$ScaffoldKt.INSTANCE.getLambda$414328099$material3();
                    } else {
                        lambda$414328099$material3 = function9;
                    }
                    if (i9 != 0) {
                        function2M3101getLambda$1514016380$material3 = ComposableSingletons$ScaffoldKt.INSTANCE.m3101getLambda$1514016380$material3();
                    } else {
                        function2M3101getLambda$1514016380$material3 = function10;
                    }
                    if (i11 != 0) {
                        iM3359getEndERTFSPs = FabPosition.INSTANCE.m3359getEndERTFSPs();
                    } else {
                        iM3359getEndERTFSPs = i;
                    }
                    if ((i3 & 64) != 0) {
                        i4 &= -3670017;
                        background = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).getBackground();
                    } else {
                        background = j;
                    }
                    if ((i3 & 128) != 0) {
                        jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(background, composerStartRestartGroup, (i4 >> 18) & 14);
                        i4 &= -29360129;
                    } else {
                        jM3051contentColorForek8zF_U = j2;
                    }
                    if ((i3 & 256) != 0) {
                        contentWindowInsets = ScaffoldDefaults.INSTANCE.getContentWindowInsets(composerStartRestartGroup, 6);
                        i4 &= -234881025;
                    } else {
                        contentWindowInsets = windowInsets;
                    }
                    j5 = jM3051contentColorForek8zF_U;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1211482744, i4, -1, "androidx.compose.material3.Scaffold (Scaffold.kt:93)");
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -298761166, "CC(remember):Scaffold.kt#9igjgp");
                int i116 = (234881024 & i4) ^ r19;
                if (i116 <= 67108864) {
                }
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z2) {
                    objRememberedValue = new MutableWindowInsets(contentWindowInsets);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new MutableWindowInsets(contentWindowInsets);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                mutableWindowInsets = (MutableWindowInsets) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                long j13 = background;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -298755960, "CC(remember):Scaffold.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(mutableWindowInsets) | ((i116 <= 67108864 && composerStartRestartGroup.changed(contentWindowInsets)) || (i4 & 100663296) == 67108864);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue2 = new Function1() { // from class: androidx.compose.material3.ScaffoldKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return ScaffoldKt.Scaffold_TvnljyQ$lambda$1$0(mutableWindowInsets, contentWindowInsets, (WindowInsets) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = new Function1() { // from class: androidx.compose.material3.ScaffoldKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return ScaffoldKt.Scaffold_TvnljyQ$lambda$1$0(mutableWindowInsets, contentWindowInsets, (WindowInsets) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                final Function2 function11113 = function2M3102getLambda$39202156$material3;
                final Function2 function11114 = lambda$1582488484$material3;
                final Function2 function11115 = lambda$414328099$material3;
                final Function2 function11116 = function2M3101getLambda$1514016380$material3;
                final int i214 = iM3359getEndERTFSPs;
                int i215 = i4 >> 12;
                composer2 = composerStartRestartGroup;
                SurfaceKt.m4323SurfaceT9BRK9s(WindowInsetsPaddingKt.onConsumedWindowInsetsChanged(companion, (Function1) objRememberedValue2), null, j13, j5, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(848889571, true, new Function2() { // from class: androidx.compose.material3.ScaffoldKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ScaffoldKt.Scaffold_TvnljyQ$lambda$2(i214, function11113, function6, function11115, function11116, mutableWindowInsets, function11114, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composer2, (i215 & 896) | 12582912 | (i215 & 7168), 114);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier2 = companion;
                function11 = function2M3102getLambda$39202156$material3;
                function12 = lambda$1582488484$material3;
                function13 = lambda$414328099$material3;
                function14 = function2M3101getLambda$1514016380$material3;
                i13 = iM3359getEndERTFSPs;
                windowInsets2 = contentWindowInsets;
                j3 = j13;
                j4 = j5;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier2 = modifier;
                windowInsets2 = windowInsets;
                function11 = function7;
                function12 = function8;
                function13 = function9;
                function14 = function10;
                i13 = i;
                j3 = j;
                j4 = j2;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ScaffoldKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ScaffoldKt.Scaffold_TvnljyQ$lambda$3(modifier2, function11, function12, function13, function14, i13, j3, j4, windowInsets2, function6, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i4 |= 48;
        function7 = function2;
        i5 = i3 & 4;
        if (i5 != 0) {
            if ((i2 & 384) == 0) {
                function8 = function3;
                if (composerStartRestartGroup.changedInstance(function8)) {
                    i6 = 256;
                } else {
                    i6 = 128;
                }
                i4 |= i6;
            }
            i7 = i3 & 8;
            if (i7 != 0) {
                if ((i2 & 3072) == 0) {
                    function9 = function4;
                    if (composerStartRestartGroup.changedInstance(function9)) {
                        i8 = 2048;
                    } else {
                        i8 = 1024;
                    }
                    i4 |= i8;
                }
                i9 = i3 & 16;
                if (i9 != 0) {
                    if ((i2 & 24576) == 0) {
                        function10 = function5;
                        if (composerStartRestartGroup.changedInstance(function10)) {
                            i10 = 16384;
                        } else {
                            i10 = 8192;
                        }
                        i4 |= i10;
                    }
                    i11 = i3 & 32;
                    if (i11 != 0) {
                        i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    } else if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                        if (composerStartRestartGroup.changed(i)) {
                            i12 = 131072;
                        } else {
                            i12 = 65536;
                        }
                        i4 |= i12;
                    }
                    if ((i2 & 1572864) != 0) {
                        if ((i3 & 64) == 0) {
                            i16 = 524288;
                        } else {
                            i16 = 524288;
                        }
                        i4 |= i16;
                    }
                    if ((i2 & 12582912) != 0) {
                        if ((i3 & 128) == 0) {
                            i15 = 4194304;
                        } else {
                            i15 = 4194304;
                        }
                        i4 |= i15;
                    }
                    if ((i2 & 100663296) != 0) {
                        i4 |= ((i3 & 256) == 0 || !composerStartRestartGroup.changed(windowInsets)) ? 33554432 : 67108864;
                    }
                    if ((i2 & 805306368) == 0) {
                        if (composerStartRestartGroup.changedInstance(function6)) {
                            i14 = C.BUFFER_FLAG_LAST_SAMPLE;
                        } else {
                            i14 = 268435456;
                        }
                        i4 |= i14;
                    }
                    if ((i4 & 306783379) != 306783378) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "89@4637L11,90@4687L31,91@4777L19");
                        if ((i2 & 1) != 0) {
                            if (i17 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if (i18 != 0) {
                                function2M3102getLambda$39202156$material3 = ComposableSingletons$ScaffoldKt.INSTANCE.m3102getLambda$39202156$material3();
                            } else {
                                function2M3102getLambda$39202156$material3 = function7;
                            }
                            if (i5 != 0) {
                                lambda$1582488484$material3 = ComposableSingletons$ScaffoldKt.INSTANCE.getLambda$1582488484$material3();
                            } else {
                                lambda$1582488484$material3 = function8;
                            }
                            if (i7 != 0) {
                                lambda$414328099$material3 = ComposableSingletons$ScaffoldKt.INSTANCE.getLambda$414328099$material3();
                            } else {
                                lambda$414328099$material3 = function9;
                            }
                            if (i9 != 0) {
                                function2M3101getLambda$1514016380$material3 = ComposableSingletons$ScaffoldKt.INSTANCE.m3101getLambda$1514016380$material3();
                            } else {
                                function2M3101getLambda$1514016380$material3 = function10;
                            }
                            if (i11 != 0) {
                                iM3359getEndERTFSPs = FabPosition.INSTANCE.m3359getEndERTFSPs();
                            } else {
                                iM3359getEndERTFSPs = i;
                            }
                            if ((i3 & 64) != 0) {
                                i4 &= -3670017;
                                background = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).getBackground();
                            } else {
                                background = j;
                            }
                            if ((i3 & 128) != 0) {
                                jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(background, composerStartRestartGroup, (i4 >> 18) & 14);
                                i4 &= -29360129;
                            } else {
                                jM3051contentColorForek8zF_U = j2;
                            }
                            if ((i3 & 256) != 0) {
                                contentWindowInsets = ScaffoldDefaults.INSTANCE.getContentWindowInsets(composerStartRestartGroup, 6);
                                i4 &= -234881025;
                            } else {
                                contentWindowInsets = windowInsets;
                            }
                            j5 = jM3051contentColorForek8zF_U;
                        } else {
                            if (i17 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier;
                            }
                            if (i18 != 0) {
                                function2M3102getLambda$39202156$material3 = ComposableSingletons$ScaffoldKt.INSTANCE.m3102getLambda$39202156$material3();
                            } else {
                                function2M3102getLambda$39202156$material3 = function7;
                            }
                            if (i5 != 0) {
                                lambda$1582488484$material3 = ComposableSingletons$ScaffoldKt.INSTANCE.getLambda$1582488484$material3();
                            } else {
                                lambda$1582488484$material3 = function8;
                            }
                            if (i7 != 0) {
                                lambda$414328099$material3 = ComposableSingletons$ScaffoldKt.INSTANCE.getLambda$414328099$material3();
                            } else {
                                lambda$414328099$material3 = function9;
                            }
                            if (i9 != 0) {
                                function2M3101getLambda$1514016380$material3 = ComposableSingletons$ScaffoldKt.INSTANCE.m3101getLambda$1514016380$material3();
                            } else {
                                function2M3101getLambda$1514016380$material3 = function10;
                            }
                            if (i11 != 0) {
                                iM3359getEndERTFSPs = FabPosition.INSTANCE.m3359getEndERTFSPs();
                            } else {
                                iM3359getEndERTFSPs = i;
                            }
                            if ((i3 & 64) != 0) {
                                i4 &= -3670017;
                                background = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).getBackground();
                            } else {
                                background = j;
                            }
                            if ((i3 & 128) != 0) {
                                jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(background, composerStartRestartGroup, (i4 >> 18) & 14);
                                i4 &= -29360129;
                            } else {
                                jM3051contentColorForek8zF_U = j2;
                            }
                            if ((i3 & 256) != 0) {
                                contentWindowInsets = ScaffoldDefaults.INSTANCE.getContentWindowInsets(composerStartRestartGroup, 6);
                                i4 &= -234881025;
                            } else {
                                contentWindowInsets = windowInsets;
                            }
                            j5 = jM3051contentColorForek8zF_U;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1211482744, i4, -1, "androidx.compose.material3.Scaffold (Scaffold.kt:93)");
                        }
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -298761166, "CC(remember):Scaffold.kt#9igjgp");
                        int i117 = (234881024 & i4) ^ r19;
                        if (i117 <= 67108864) {
                        }
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!z2) {
                            objRememberedValue = new MutableWindowInsets(contentWindowInsets);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        } else {
                            objRememberedValue = new MutableWindowInsets(contentWindowInsets);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        mutableWindowInsets = (MutableWindowInsets) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        long j14 = background;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -298755960, "CC(remember):Scaffold.kt#9igjgp");
                        zChanged = composerStartRestartGroup.changed(mutableWindowInsets) | ((i117 <= 67108864 && composerStartRestartGroup.changed(contentWindowInsets)) || (i4 & 100663296) == 67108864);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (!zChanged) {
                            objRememberedValue2 = new Function1() { // from class: androidx.compose.material3.ScaffoldKt$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return ScaffoldKt.Scaffold_TvnljyQ$lambda$1$0(mutableWindowInsets, contentWindowInsets, (WindowInsets) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        } else {
                            objRememberedValue2 = new Function1() { // from class: androidx.compose.material3.ScaffoldKt$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return ScaffoldKt.Scaffold_TvnljyQ$lambda$1$0(mutableWindowInsets, contentWindowInsets, (WindowInsets) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        final Function2 function11117 = function2M3102getLambda$39202156$material3;
                        final Function2 function11118 = lambda$1582488484$material3;
                        final Function2 function11119 = lambda$414328099$material3;
                        final Function2 function111110 = function2M3101getLambda$1514016380$material3;
                        final int i216 = iM3359getEndERTFSPs;
                        int i217 = i4 >> 12;
                        composer2 = composerStartRestartGroup;
                        SurfaceKt.m4323SurfaceT9BRK9s(WindowInsetsPaddingKt.onConsumedWindowInsetsChanged(companion, (Function1) objRememberedValue2), null, j14, j5, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(848889571, true, new Function2() { // from class: androidx.compose.material3.ScaffoldKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return ScaffoldKt.Scaffold_TvnljyQ$lambda$2(i216, function11117, function6, function11119, function111110, mutableWindowInsets, function11118, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54), composer2, (i217 & 896) | 12582912 | (i217 & 7168), 114);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier2 = companion;
                        function11 = function2M3102getLambda$39202156$material3;
                        function12 = lambda$1582488484$material3;
                        function13 = lambda$414328099$material3;
                        function14 = function2M3101getLambda$1514016380$material3;
                        i13 = iM3359getEndERTFSPs;
                        windowInsets2 = contentWindowInsets;
                        j3 = j14;
                        j4 = j5;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        modifier2 = modifier;
                        windowInsets2 = windowInsets;
                        function11 = function7;
                        function12 = function8;
                        function13 = function9;
                        function14 = function10;
                        i13 = i;
                        j3 = j;
                        j4 = j2;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ScaffoldKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return ScaffoldKt.Scaffold_TvnljyQ$lambda$3(modifier2, function11, function12, function13, function14, i13, j3, j4, windowInsets2, function6, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i4 |= 24576;
                function10 = function5;
                i11 = i3 & 32;
                if (i11 != 0) {
                    i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    if (composerStartRestartGroup.changed(i)) {
                        i12 = 131072;
                    } else {
                        i12 = 65536;
                    }
                    i4 |= i12;
                }
                if ((i2 & 1572864) != 0) {
                    if ((i3 & 64) == 0) {
                        i16 = 524288;
                    } else {
                        i16 = 524288;
                    }
                    i4 |= i16;
                }
                if ((i2 & 12582912) != 0) {
                    if ((i3 & 128) == 0) {
                        i15 = 4194304;
                    } else {
                        i15 = 4194304;
                    }
                    i4 |= i15;
                }
                if ((i2 & 100663296) != 0) {
                    i4 |= ((i3 & 256) == 0 || !composerStartRestartGroup.changed(windowInsets)) ? 33554432 : 67108864;
                }
                if ((i2 & 805306368) == 0) {
                    if (composerStartRestartGroup.changedInstance(function6)) {
                        i14 = C.BUFFER_FLAG_LAST_SAMPLE;
                    } else {
                        i14 = 268435456;
                    }
                    i4 |= i14;
                }
                if ((i4 & 306783379) != 306783378) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "89@4637L11,90@4687L31,91@4777L19");
                    if ((i2 & 1) != 0) {
                        if (i17 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i18 != 0) {
                            function2M3102getLambda$39202156$material3 = ComposableSingletons$ScaffoldKt.INSTANCE.m3102getLambda$39202156$material3();
                        } else {
                            function2M3102getLambda$39202156$material3 = function7;
                        }
                        if (i5 != 0) {
                            lambda$1582488484$material3 = ComposableSingletons$ScaffoldKt.INSTANCE.getLambda$1582488484$material3();
                        } else {
                            lambda$1582488484$material3 = function8;
                        }
                        if (i7 != 0) {
                            lambda$414328099$material3 = ComposableSingletons$ScaffoldKt.INSTANCE.getLambda$414328099$material3();
                        } else {
                            lambda$414328099$material3 = function9;
                        }
                        if (i9 != 0) {
                            function2M3101getLambda$1514016380$material3 = ComposableSingletons$ScaffoldKt.INSTANCE.m3101getLambda$1514016380$material3();
                        } else {
                            function2M3101getLambda$1514016380$material3 = function10;
                        }
                        if (i11 != 0) {
                            iM3359getEndERTFSPs = FabPosition.INSTANCE.m3359getEndERTFSPs();
                        } else {
                            iM3359getEndERTFSPs = i;
                        }
                        if ((i3 & 64) != 0) {
                            i4 &= -3670017;
                            background = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).getBackground();
                        } else {
                            background = j;
                        }
                        if ((i3 & 128) != 0) {
                            jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(background, composerStartRestartGroup, (i4 >> 18) & 14);
                            i4 &= -29360129;
                        } else {
                            jM3051contentColorForek8zF_U = j2;
                        }
                        if ((i3 & 256) != 0) {
                            contentWindowInsets = ScaffoldDefaults.INSTANCE.getContentWindowInsets(composerStartRestartGroup, 6);
                            i4 &= -234881025;
                        } else {
                            contentWindowInsets = windowInsets;
                        }
                        j5 = jM3051contentColorForek8zF_U;
                    } else {
                        if (i17 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i18 != 0) {
                            function2M3102getLambda$39202156$material3 = ComposableSingletons$ScaffoldKt.INSTANCE.m3102getLambda$39202156$material3();
                        } else {
                            function2M3102getLambda$39202156$material3 = function7;
                        }
                        if (i5 != 0) {
                            lambda$1582488484$material3 = ComposableSingletons$ScaffoldKt.INSTANCE.getLambda$1582488484$material3();
                        } else {
                            lambda$1582488484$material3 = function8;
                        }
                        if (i7 != 0) {
                            lambda$414328099$material3 = ComposableSingletons$ScaffoldKt.INSTANCE.getLambda$414328099$material3();
                        } else {
                            lambda$414328099$material3 = function9;
                        }
                        if (i9 != 0) {
                            function2M3101getLambda$1514016380$material3 = ComposableSingletons$ScaffoldKt.INSTANCE.m3101getLambda$1514016380$material3();
                        } else {
                            function2M3101getLambda$1514016380$material3 = function10;
                        }
                        if (i11 != 0) {
                            iM3359getEndERTFSPs = FabPosition.INSTANCE.m3359getEndERTFSPs();
                        } else {
                            iM3359getEndERTFSPs = i;
                        }
                        if ((i3 & 64) != 0) {
                            i4 &= -3670017;
                            background = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).getBackground();
                        } else {
                            background = j;
                        }
                        if ((i3 & 128) != 0) {
                            jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(background, composerStartRestartGroup, (i4 >> 18) & 14);
                            i4 &= -29360129;
                        } else {
                            jM3051contentColorForek8zF_U = j2;
                        }
                        if ((i3 & 256) != 0) {
                            contentWindowInsets = ScaffoldDefaults.INSTANCE.getContentWindowInsets(composerStartRestartGroup, 6);
                            i4 &= -234881025;
                        } else {
                            contentWindowInsets = windowInsets;
                        }
                        j5 = jM3051contentColorForek8zF_U;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1211482744, i4, -1, "androidx.compose.material3.Scaffold (Scaffold.kt:93)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -298761166, "CC(remember):Scaffold.kt#9igjgp");
                    int i118 = (234881024 & i4) ^ r19;
                    if (i118 <= 67108864) {
                    }
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z2) {
                        objRememberedValue = new MutableWindowInsets(contentWindowInsets);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new MutableWindowInsets(contentWindowInsets);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    mutableWindowInsets = (MutableWindowInsets) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    long j15 = background;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -298755960, "CC(remember):Scaffold.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(mutableWindowInsets) | ((i118 <= 67108864 && composerStartRestartGroup.changed(contentWindowInsets)) || (i4 & 100663296) == 67108864);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue2 = new Function1() { // from class: androidx.compose.material3.ScaffoldKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return ScaffoldKt.Scaffold_TvnljyQ$lambda$1$0(mutableWindowInsets, contentWindowInsets, (WindowInsets) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new Function1() { // from class: androidx.compose.material3.ScaffoldKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return ScaffoldKt.Scaffold_TvnljyQ$lambda$1$0(mutableWindowInsets, contentWindowInsets, (WindowInsets) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    final Function2 function111111 = function2M3102getLambda$39202156$material3;
                    final Function2 function111112 = lambda$1582488484$material3;
                    final Function2 function111113 = lambda$414328099$material3;
                    final Function2 function111114 = function2M3101getLambda$1514016380$material3;
                    final int i218 = iM3359getEndERTFSPs;
                    int i219 = i4 >> 12;
                    composer2 = composerStartRestartGroup;
                    SurfaceKt.m4323SurfaceT9BRK9s(WindowInsetsPaddingKt.onConsumedWindowInsetsChanged(companion, (Function1) objRememberedValue2), null, j15, j5, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(848889571, true, new Function2() { // from class: androidx.compose.material3.ScaffoldKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ScaffoldKt.Scaffold_TvnljyQ$lambda$2(i218, function111111, function6, function111113, function111114, mutableWindowInsets, function111112, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composer2, (i219 & 896) | 12582912 | (i219 & 7168), 114);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier2 = companion;
                    function11 = function2M3102getLambda$39202156$material3;
                    function12 = lambda$1582488484$material3;
                    function13 = lambda$414328099$material3;
                    function14 = function2M3101getLambda$1514016380$material3;
                    i13 = iM3359getEndERTFSPs;
                    windowInsets2 = contentWindowInsets;
                    j3 = j15;
                    j4 = j5;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    modifier2 = modifier;
                    windowInsets2 = windowInsets;
                    function11 = function7;
                    function12 = function8;
                    function13 = function9;
                    function14 = function10;
                    i13 = i;
                    j3 = j;
                    j4 = j2;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ScaffoldKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ScaffoldKt.Scaffold_TvnljyQ$lambda$3(modifier2, function11, function12, function13, function14, i13, j3, j4, windowInsets2, function6, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i4 |= 3072;
            function9 = function4;
            i9 = i3 & 16;
            if (i9 != 0) {
                if ((i2 & 24576) == 0) {
                    function10 = function5;
                    if (composerStartRestartGroup.changedInstance(function10)) {
                        i10 = 16384;
                    } else {
                        i10 = 8192;
                    }
                    i4 |= i10;
                }
                i11 = i3 & 32;
                if (i11 != 0) {
                    i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    if (composerStartRestartGroup.changed(i)) {
                        i12 = 131072;
                    } else {
                        i12 = 65536;
                    }
                    i4 |= i12;
                }
                if ((i2 & 1572864) != 0) {
                    if ((i3 & 64) == 0) {
                        i16 = 524288;
                    } else {
                        i16 = 524288;
                    }
                    i4 |= i16;
                }
                if ((i2 & 12582912) != 0) {
                    if ((i3 & 128) == 0) {
                        i15 = 4194304;
                    } else {
                        i15 = 4194304;
                    }
                    i4 |= i15;
                }
                if ((i2 & 100663296) != 0) {
                    i4 |= ((i3 & 256) == 0 || !composerStartRestartGroup.changed(windowInsets)) ? 33554432 : 67108864;
                }
                if ((i2 & 805306368) == 0) {
                    if (composerStartRestartGroup.changedInstance(function6)) {
                        i14 = C.BUFFER_FLAG_LAST_SAMPLE;
                    } else {
                        i14 = 268435456;
                    }
                    i4 |= i14;
                }
                if ((i4 & 306783379) != 306783378) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "89@4637L11,90@4687L31,91@4777L19");
                    if ((i2 & 1) != 0) {
                        if (i17 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i18 != 0) {
                            function2M3102getLambda$39202156$material3 = ComposableSingletons$ScaffoldKt.INSTANCE.m3102getLambda$39202156$material3();
                        } else {
                            function2M3102getLambda$39202156$material3 = function7;
                        }
                        if (i5 != 0) {
                            lambda$1582488484$material3 = ComposableSingletons$ScaffoldKt.INSTANCE.getLambda$1582488484$material3();
                        } else {
                            lambda$1582488484$material3 = function8;
                        }
                        if (i7 != 0) {
                            lambda$414328099$material3 = ComposableSingletons$ScaffoldKt.INSTANCE.getLambda$414328099$material3();
                        } else {
                            lambda$414328099$material3 = function9;
                        }
                        if (i9 != 0) {
                            function2M3101getLambda$1514016380$material3 = ComposableSingletons$ScaffoldKt.INSTANCE.m3101getLambda$1514016380$material3();
                        } else {
                            function2M3101getLambda$1514016380$material3 = function10;
                        }
                        if (i11 != 0) {
                            iM3359getEndERTFSPs = FabPosition.INSTANCE.m3359getEndERTFSPs();
                        } else {
                            iM3359getEndERTFSPs = i;
                        }
                        if ((i3 & 64) != 0) {
                            i4 &= -3670017;
                            background = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).getBackground();
                        } else {
                            background = j;
                        }
                        if ((i3 & 128) != 0) {
                            jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(background, composerStartRestartGroup, (i4 >> 18) & 14);
                            i4 &= -29360129;
                        } else {
                            jM3051contentColorForek8zF_U = j2;
                        }
                        if ((i3 & 256) != 0) {
                            contentWindowInsets = ScaffoldDefaults.INSTANCE.getContentWindowInsets(composerStartRestartGroup, 6);
                            i4 &= -234881025;
                        } else {
                            contentWindowInsets = windowInsets;
                        }
                        j5 = jM3051contentColorForek8zF_U;
                    } else {
                        if (i17 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i18 != 0) {
                            function2M3102getLambda$39202156$material3 = ComposableSingletons$ScaffoldKt.INSTANCE.m3102getLambda$39202156$material3();
                        } else {
                            function2M3102getLambda$39202156$material3 = function7;
                        }
                        if (i5 != 0) {
                            lambda$1582488484$material3 = ComposableSingletons$ScaffoldKt.INSTANCE.getLambda$1582488484$material3();
                        } else {
                            lambda$1582488484$material3 = function8;
                        }
                        if (i7 != 0) {
                            lambda$414328099$material3 = ComposableSingletons$ScaffoldKt.INSTANCE.getLambda$414328099$material3();
                        } else {
                            lambda$414328099$material3 = function9;
                        }
                        if (i9 != 0) {
                            function2M3101getLambda$1514016380$material3 = ComposableSingletons$ScaffoldKt.INSTANCE.m3101getLambda$1514016380$material3();
                        } else {
                            function2M3101getLambda$1514016380$material3 = function10;
                        }
                        if (i11 != 0) {
                            iM3359getEndERTFSPs = FabPosition.INSTANCE.m3359getEndERTFSPs();
                        } else {
                            iM3359getEndERTFSPs = i;
                        }
                        if ((i3 & 64) != 0) {
                            i4 &= -3670017;
                            background = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).getBackground();
                        } else {
                            background = j;
                        }
                        if ((i3 & 128) != 0) {
                            jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(background, composerStartRestartGroup, (i4 >> 18) & 14);
                            i4 &= -29360129;
                        } else {
                            jM3051contentColorForek8zF_U = j2;
                        }
                        if ((i3 & 256) != 0) {
                            contentWindowInsets = ScaffoldDefaults.INSTANCE.getContentWindowInsets(composerStartRestartGroup, 6);
                            i4 &= -234881025;
                        } else {
                            contentWindowInsets = windowInsets;
                        }
                        j5 = jM3051contentColorForek8zF_U;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1211482744, i4, -1, "androidx.compose.material3.Scaffold (Scaffold.kt:93)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -298761166, "CC(remember):Scaffold.kt#9igjgp");
                    int i119 = (234881024 & i4) ^ r19;
                    if (i119 <= 67108864) {
                    }
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z2) {
                        objRememberedValue = new MutableWindowInsets(contentWindowInsets);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new MutableWindowInsets(contentWindowInsets);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    mutableWindowInsets = (MutableWindowInsets) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    long j16 = background;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -298755960, "CC(remember):Scaffold.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(mutableWindowInsets) | ((i119 <= 67108864 && composerStartRestartGroup.changed(contentWindowInsets)) || (i4 & 100663296) == 67108864);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue2 = new Function1() { // from class: androidx.compose.material3.ScaffoldKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return ScaffoldKt.Scaffold_TvnljyQ$lambda$1$0(mutableWindowInsets, contentWindowInsets, (WindowInsets) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new Function1() { // from class: androidx.compose.material3.ScaffoldKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return ScaffoldKt.Scaffold_TvnljyQ$lambda$1$0(mutableWindowInsets, contentWindowInsets, (WindowInsets) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    final Function2 function111115 = function2M3102getLambda$39202156$material3;
                    final Function2 function111116 = lambda$1582488484$material3;
                    final Function2 function111117 = lambda$414328099$material3;
                    final Function2 function111118 = function2M3101getLambda$1514016380$material3;
                    final int i2110 = iM3359getEndERTFSPs;
                    int i2111 = i4 >> 12;
                    composer2 = composerStartRestartGroup;
                    SurfaceKt.m4323SurfaceT9BRK9s(WindowInsetsPaddingKt.onConsumedWindowInsetsChanged(companion, (Function1) objRememberedValue2), null, j16, j5, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(848889571, true, new Function2() { // from class: androidx.compose.material3.ScaffoldKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ScaffoldKt.Scaffold_TvnljyQ$lambda$2(i2110, function111115, function6, function111117, function111118, mutableWindowInsets, function111116, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composer2, (i2111 & 896) | 12582912 | (i2111 & 7168), 114);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier2 = companion;
                    function11 = function2M3102getLambda$39202156$material3;
                    function12 = lambda$1582488484$material3;
                    function13 = lambda$414328099$material3;
                    function14 = function2M3101getLambda$1514016380$material3;
                    i13 = iM3359getEndERTFSPs;
                    windowInsets2 = contentWindowInsets;
                    j3 = j16;
                    j4 = j5;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    modifier2 = modifier;
                    windowInsets2 = windowInsets;
                    function11 = function7;
                    function12 = function8;
                    function13 = function9;
                    function14 = function10;
                    i13 = i;
                    j3 = j;
                    j4 = j2;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ScaffoldKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ScaffoldKt.Scaffold_TvnljyQ$lambda$3(modifier2, function11, function12, function13, function14, i13, j3, j4, windowInsets2, function6, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i4 |= 24576;
            function10 = function5;
            i11 = i3 & 32;
            if (i11 != 0) {
                i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            } else if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                if (composerStartRestartGroup.changed(i)) {
                    i12 = 131072;
                } else {
                    i12 = 65536;
                }
                i4 |= i12;
            }
            if ((i2 & 1572864) != 0) {
                if ((i3 & 64) == 0) {
                    i16 = 524288;
                } else {
                    i16 = 524288;
                }
                i4 |= i16;
            }
            if ((i2 & 12582912) != 0) {
                if ((i3 & 128) == 0) {
                    i15 = 4194304;
                } else {
                    i15 = 4194304;
                }
                i4 |= i15;
            }
            if ((i2 & 100663296) != 0) {
                i4 |= ((i3 & 256) == 0 || !composerStartRestartGroup.changed(windowInsets)) ? 33554432 : 67108864;
            }
            if ((i2 & 805306368) == 0) {
                if (composerStartRestartGroup.changedInstance(function6)) {
                    i14 = C.BUFFER_FLAG_LAST_SAMPLE;
                } else {
                    i14 = 268435456;
                }
                i4 |= i14;
            }
            if ((i4 & 306783379) != 306783378) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "89@4637L11,90@4687L31,91@4777L19");
                if ((i2 & 1) != 0) {
                    if (i17 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i18 != 0) {
                        function2M3102getLambda$39202156$material3 = ComposableSingletons$ScaffoldKt.INSTANCE.m3102getLambda$39202156$material3();
                    } else {
                        function2M3102getLambda$39202156$material3 = function7;
                    }
                    if (i5 != 0) {
                        lambda$1582488484$material3 = ComposableSingletons$ScaffoldKt.INSTANCE.getLambda$1582488484$material3();
                    } else {
                        lambda$1582488484$material3 = function8;
                    }
                    if (i7 != 0) {
                        lambda$414328099$material3 = ComposableSingletons$ScaffoldKt.INSTANCE.getLambda$414328099$material3();
                    } else {
                        lambda$414328099$material3 = function9;
                    }
                    if (i9 != 0) {
                        function2M3101getLambda$1514016380$material3 = ComposableSingletons$ScaffoldKt.INSTANCE.m3101getLambda$1514016380$material3();
                    } else {
                        function2M3101getLambda$1514016380$material3 = function10;
                    }
                    if (i11 != 0) {
                        iM3359getEndERTFSPs = FabPosition.INSTANCE.m3359getEndERTFSPs();
                    } else {
                        iM3359getEndERTFSPs = i;
                    }
                    if ((i3 & 64) != 0) {
                        i4 &= -3670017;
                        background = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).getBackground();
                    } else {
                        background = j;
                    }
                    if ((i3 & 128) != 0) {
                        jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(background, composerStartRestartGroup, (i4 >> 18) & 14);
                        i4 &= -29360129;
                    } else {
                        jM3051contentColorForek8zF_U = j2;
                    }
                    if ((i3 & 256) != 0) {
                        contentWindowInsets = ScaffoldDefaults.INSTANCE.getContentWindowInsets(composerStartRestartGroup, 6);
                        i4 &= -234881025;
                    } else {
                        contentWindowInsets = windowInsets;
                    }
                    j5 = jM3051contentColorForek8zF_U;
                } else {
                    if (i17 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i18 != 0) {
                        function2M3102getLambda$39202156$material3 = ComposableSingletons$ScaffoldKt.INSTANCE.m3102getLambda$39202156$material3();
                    } else {
                        function2M3102getLambda$39202156$material3 = function7;
                    }
                    if (i5 != 0) {
                        lambda$1582488484$material3 = ComposableSingletons$ScaffoldKt.INSTANCE.getLambda$1582488484$material3();
                    } else {
                        lambda$1582488484$material3 = function8;
                    }
                    if (i7 != 0) {
                        lambda$414328099$material3 = ComposableSingletons$ScaffoldKt.INSTANCE.getLambda$414328099$material3();
                    } else {
                        lambda$414328099$material3 = function9;
                    }
                    if (i9 != 0) {
                        function2M3101getLambda$1514016380$material3 = ComposableSingletons$ScaffoldKt.INSTANCE.m3101getLambda$1514016380$material3();
                    } else {
                        function2M3101getLambda$1514016380$material3 = function10;
                    }
                    if (i11 != 0) {
                        iM3359getEndERTFSPs = FabPosition.INSTANCE.m3359getEndERTFSPs();
                    } else {
                        iM3359getEndERTFSPs = i;
                    }
                    if ((i3 & 64) != 0) {
                        i4 &= -3670017;
                        background = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).getBackground();
                    } else {
                        background = j;
                    }
                    if ((i3 & 128) != 0) {
                        jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(background, composerStartRestartGroup, (i4 >> 18) & 14);
                        i4 &= -29360129;
                    } else {
                        jM3051contentColorForek8zF_U = j2;
                    }
                    if ((i3 & 256) != 0) {
                        contentWindowInsets = ScaffoldDefaults.INSTANCE.getContentWindowInsets(composerStartRestartGroup, 6);
                        i4 &= -234881025;
                    } else {
                        contentWindowInsets = windowInsets;
                    }
                    j5 = jM3051contentColorForek8zF_U;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1211482744, i4, -1, "androidx.compose.material3.Scaffold (Scaffold.kt:93)");
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -298761166, "CC(remember):Scaffold.kt#9igjgp");
                int i1110 = (234881024 & i4) ^ r19;
                if (i1110 <= 67108864) {
                }
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z2) {
                    objRememberedValue = new MutableWindowInsets(contentWindowInsets);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new MutableWindowInsets(contentWindowInsets);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                mutableWindowInsets = (MutableWindowInsets) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                long j17 = background;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -298755960, "CC(remember):Scaffold.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(mutableWindowInsets) | ((i1110 <= 67108864 && composerStartRestartGroup.changed(contentWindowInsets)) || (i4 & 100663296) == 67108864);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue2 = new Function1() { // from class: androidx.compose.material3.ScaffoldKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return ScaffoldKt.Scaffold_TvnljyQ$lambda$1$0(mutableWindowInsets, contentWindowInsets, (WindowInsets) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = new Function1() { // from class: androidx.compose.material3.ScaffoldKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return ScaffoldKt.Scaffold_TvnljyQ$lambda$1$0(mutableWindowInsets, contentWindowInsets, (WindowInsets) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                final Function2 function111119 = function2M3102getLambda$39202156$material3;
                final Function2 function1111110 = lambda$1582488484$material3;
                final Function2 function1111111 = lambda$414328099$material3;
                final Function2 function1111112 = function2M3101getLambda$1514016380$material3;
                final int i2112 = iM3359getEndERTFSPs;
                int i2113 = i4 >> 12;
                composer2 = composerStartRestartGroup;
                SurfaceKt.m4323SurfaceT9BRK9s(WindowInsetsPaddingKt.onConsumedWindowInsetsChanged(companion, (Function1) objRememberedValue2), null, j17, j5, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(848889571, true, new Function2() { // from class: androidx.compose.material3.ScaffoldKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ScaffoldKt.Scaffold_TvnljyQ$lambda$2(i2112, function111119, function6, function1111111, function1111112, mutableWindowInsets, function1111110, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composer2, (i2113 & 896) | 12582912 | (i2113 & 7168), 114);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier2 = companion;
                function11 = function2M3102getLambda$39202156$material3;
                function12 = lambda$1582488484$material3;
                function13 = lambda$414328099$material3;
                function14 = function2M3101getLambda$1514016380$material3;
                i13 = iM3359getEndERTFSPs;
                windowInsets2 = contentWindowInsets;
                j3 = j17;
                j4 = j5;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier2 = modifier;
                windowInsets2 = windowInsets;
                function11 = function7;
                function12 = function8;
                function13 = function9;
                function14 = function10;
                i13 = i;
                j3 = j;
                j4 = j2;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ScaffoldKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ScaffoldKt.Scaffold_TvnljyQ$lambda$3(modifier2, function11, function12, function13, function14, i13, j3, j4, windowInsets2, function6, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i4 |= 384;
        function8 = function3;
        i7 = i3 & 8;
        if (i7 != 0) {
            if ((i2 & 3072) == 0) {
                function9 = function4;
                if (composerStartRestartGroup.changedInstance(function9)) {
                    i8 = 2048;
                } else {
                    i8 = 1024;
                }
                i4 |= i8;
            }
            i9 = i3 & 16;
            if (i9 != 0) {
                if ((i2 & 24576) == 0) {
                    function10 = function5;
                    if (composerStartRestartGroup.changedInstance(function10)) {
                        i10 = 16384;
                    } else {
                        i10 = 8192;
                    }
                    i4 |= i10;
                }
                i11 = i3 & 32;
                if (i11 != 0) {
                    i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                } else if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    if (composerStartRestartGroup.changed(i)) {
                        i12 = 131072;
                    } else {
                        i12 = 65536;
                    }
                    i4 |= i12;
                }
                if ((i2 & 1572864) != 0) {
                    if ((i3 & 64) == 0) {
                        i16 = 524288;
                    } else {
                        i16 = 524288;
                    }
                    i4 |= i16;
                }
                if ((i2 & 12582912) != 0) {
                    if ((i3 & 128) == 0) {
                        i15 = 4194304;
                    } else {
                        i15 = 4194304;
                    }
                    i4 |= i15;
                }
                if ((i2 & 100663296) != 0) {
                    i4 |= ((i3 & 256) == 0 || !composerStartRestartGroup.changed(windowInsets)) ? 33554432 : 67108864;
                }
                if ((i2 & 805306368) == 0) {
                    if (composerStartRestartGroup.changedInstance(function6)) {
                        i14 = C.BUFFER_FLAG_LAST_SAMPLE;
                    } else {
                        i14 = 268435456;
                    }
                    i4 |= i14;
                }
                if ((i4 & 306783379) != 306783378) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "89@4637L11,90@4687L31,91@4777L19");
                    if ((i2 & 1) != 0) {
                        if (i17 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i18 != 0) {
                            function2M3102getLambda$39202156$material3 = ComposableSingletons$ScaffoldKt.INSTANCE.m3102getLambda$39202156$material3();
                        } else {
                            function2M3102getLambda$39202156$material3 = function7;
                        }
                        if (i5 != 0) {
                            lambda$1582488484$material3 = ComposableSingletons$ScaffoldKt.INSTANCE.getLambda$1582488484$material3();
                        } else {
                            lambda$1582488484$material3 = function8;
                        }
                        if (i7 != 0) {
                            lambda$414328099$material3 = ComposableSingletons$ScaffoldKt.INSTANCE.getLambda$414328099$material3();
                        } else {
                            lambda$414328099$material3 = function9;
                        }
                        if (i9 != 0) {
                            function2M3101getLambda$1514016380$material3 = ComposableSingletons$ScaffoldKt.INSTANCE.m3101getLambda$1514016380$material3();
                        } else {
                            function2M3101getLambda$1514016380$material3 = function10;
                        }
                        if (i11 != 0) {
                            iM3359getEndERTFSPs = FabPosition.INSTANCE.m3359getEndERTFSPs();
                        } else {
                            iM3359getEndERTFSPs = i;
                        }
                        if ((i3 & 64) != 0) {
                            i4 &= -3670017;
                            background = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).getBackground();
                        } else {
                            background = j;
                        }
                        if ((i3 & 128) != 0) {
                            jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(background, composerStartRestartGroup, (i4 >> 18) & 14);
                            i4 &= -29360129;
                        } else {
                            jM3051contentColorForek8zF_U = j2;
                        }
                        if ((i3 & 256) != 0) {
                            contentWindowInsets = ScaffoldDefaults.INSTANCE.getContentWindowInsets(composerStartRestartGroup, 6);
                            i4 &= -234881025;
                        } else {
                            contentWindowInsets = windowInsets;
                        }
                        j5 = jM3051contentColorForek8zF_U;
                    } else {
                        if (i17 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier;
                        }
                        if (i18 != 0) {
                            function2M3102getLambda$39202156$material3 = ComposableSingletons$ScaffoldKt.INSTANCE.m3102getLambda$39202156$material3();
                        } else {
                            function2M3102getLambda$39202156$material3 = function7;
                        }
                        if (i5 != 0) {
                            lambda$1582488484$material3 = ComposableSingletons$ScaffoldKt.INSTANCE.getLambda$1582488484$material3();
                        } else {
                            lambda$1582488484$material3 = function8;
                        }
                        if (i7 != 0) {
                            lambda$414328099$material3 = ComposableSingletons$ScaffoldKt.INSTANCE.getLambda$414328099$material3();
                        } else {
                            lambda$414328099$material3 = function9;
                        }
                        if (i9 != 0) {
                            function2M3101getLambda$1514016380$material3 = ComposableSingletons$ScaffoldKt.INSTANCE.m3101getLambda$1514016380$material3();
                        } else {
                            function2M3101getLambda$1514016380$material3 = function10;
                        }
                        if (i11 != 0) {
                            iM3359getEndERTFSPs = FabPosition.INSTANCE.m3359getEndERTFSPs();
                        } else {
                            iM3359getEndERTFSPs = i;
                        }
                        if ((i3 & 64) != 0) {
                            i4 &= -3670017;
                            background = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).getBackground();
                        } else {
                            background = j;
                        }
                        if ((i3 & 128) != 0) {
                            jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(background, composerStartRestartGroup, (i4 >> 18) & 14);
                            i4 &= -29360129;
                        } else {
                            jM3051contentColorForek8zF_U = j2;
                        }
                        if ((i3 & 256) != 0) {
                            contentWindowInsets = ScaffoldDefaults.INSTANCE.getContentWindowInsets(composerStartRestartGroup, 6);
                            i4 &= -234881025;
                        } else {
                            contentWindowInsets = windowInsets;
                        }
                        j5 = jM3051contentColorForek8zF_U;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1211482744, i4, -1, "androidx.compose.material3.Scaffold (Scaffold.kt:93)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -298761166, "CC(remember):Scaffold.kt#9igjgp");
                    int i1111 = (234881024 & i4) ^ r19;
                    if (i1111 <= 67108864) {
                    }
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z2) {
                        objRememberedValue = new MutableWindowInsets(contentWindowInsets);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new MutableWindowInsets(contentWindowInsets);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    mutableWindowInsets = (MutableWindowInsets) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    long j18 = background;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -298755960, "CC(remember):Scaffold.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(mutableWindowInsets) | ((i1111 <= 67108864 && composerStartRestartGroup.changed(contentWindowInsets)) || (i4 & 100663296) == 67108864);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue2 = new Function1() { // from class: androidx.compose.material3.ScaffoldKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return ScaffoldKt.Scaffold_TvnljyQ$lambda$1$0(mutableWindowInsets, contentWindowInsets, (WindowInsets) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new Function1() { // from class: androidx.compose.material3.ScaffoldKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return ScaffoldKt.Scaffold_TvnljyQ$lambda$1$0(mutableWindowInsets, contentWindowInsets, (WindowInsets) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    final Function2 function1111113 = function2M3102getLambda$39202156$material3;
                    final Function2 function1111114 = lambda$1582488484$material3;
                    final Function2 function1111115 = lambda$414328099$material3;
                    final Function2 function1111116 = function2M3101getLambda$1514016380$material3;
                    final int i2114 = iM3359getEndERTFSPs;
                    int i2115 = i4 >> 12;
                    composer2 = composerStartRestartGroup;
                    SurfaceKt.m4323SurfaceT9BRK9s(WindowInsetsPaddingKt.onConsumedWindowInsetsChanged(companion, (Function1) objRememberedValue2), null, j18, j5, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(848889571, true, new Function2() { // from class: androidx.compose.material3.ScaffoldKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ScaffoldKt.Scaffold_TvnljyQ$lambda$2(i2114, function1111113, function6, function1111115, function1111116, mutableWindowInsets, function1111114, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composer2, (i2115 & 896) | 12582912 | (i2115 & 7168), 114);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier2 = companion;
                    function11 = function2M3102getLambda$39202156$material3;
                    function12 = lambda$1582488484$material3;
                    function13 = lambda$414328099$material3;
                    function14 = function2M3101getLambda$1514016380$material3;
                    i13 = iM3359getEndERTFSPs;
                    windowInsets2 = contentWindowInsets;
                    j3 = j18;
                    j4 = j5;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    modifier2 = modifier;
                    windowInsets2 = windowInsets;
                    function11 = function7;
                    function12 = function8;
                    function13 = function9;
                    function14 = function10;
                    i13 = i;
                    j3 = j;
                    j4 = j2;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ScaffoldKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ScaffoldKt.Scaffold_TvnljyQ$lambda$3(modifier2, function11, function12, function13, function14, i13, j3, j4, windowInsets2, function6, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i4 |= 24576;
            function10 = function5;
            i11 = i3 & 32;
            if (i11 != 0) {
                i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            } else if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                if (composerStartRestartGroup.changed(i)) {
                    i12 = 131072;
                } else {
                    i12 = 65536;
                }
                i4 |= i12;
            }
            if ((i2 & 1572864) != 0) {
                if ((i3 & 64) == 0) {
                    i16 = 524288;
                } else {
                    i16 = 524288;
                }
                i4 |= i16;
            }
            if ((i2 & 12582912) != 0) {
                if ((i3 & 128) == 0) {
                    i15 = 4194304;
                } else {
                    i15 = 4194304;
                }
                i4 |= i15;
            }
            if ((i2 & 100663296) != 0) {
                i4 |= ((i3 & 256) == 0 || !composerStartRestartGroup.changed(windowInsets)) ? 33554432 : 67108864;
            }
            if ((i2 & 805306368) == 0) {
                if (composerStartRestartGroup.changedInstance(function6)) {
                    i14 = C.BUFFER_FLAG_LAST_SAMPLE;
                } else {
                    i14 = 268435456;
                }
                i4 |= i14;
            }
            if ((i4 & 306783379) != 306783378) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "89@4637L11,90@4687L31,91@4777L19");
                if ((i2 & 1) != 0) {
                    if (i17 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i18 != 0) {
                        function2M3102getLambda$39202156$material3 = ComposableSingletons$ScaffoldKt.INSTANCE.m3102getLambda$39202156$material3();
                    } else {
                        function2M3102getLambda$39202156$material3 = function7;
                    }
                    if (i5 != 0) {
                        lambda$1582488484$material3 = ComposableSingletons$ScaffoldKt.INSTANCE.getLambda$1582488484$material3();
                    } else {
                        lambda$1582488484$material3 = function8;
                    }
                    if (i7 != 0) {
                        lambda$414328099$material3 = ComposableSingletons$ScaffoldKt.INSTANCE.getLambda$414328099$material3();
                    } else {
                        lambda$414328099$material3 = function9;
                    }
                    if (i9 != 0) {
                        function2M3101getLambda$1514016380$material3 = ComposableSingletons$ScaffoldKt.INSTANCE.m3101getLambda$1514016380$material3();
                    } else {
                        function2M3101getLambda$1514016380$material3 = function10;
                    }
                    if (i11 != 0) {
                        iM3359getEndERTFSPs = FabPosition.INSTANCE.m3359getEndERTFSPs();
                    } else {
                        iM3359getEndERTFSPs = i;
                    }
                    if ((i3 & 64) != 0) {
                        i4 &= -3670017;
                        background = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).getBackground();
                    } else {
                        background = j;
                    }
                    if ((i3 & 128) != 0) {
                        jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(background, composerStartRestartGroup, (i4 >> 18) & 14);
                        i4 &= -29360129;
                    } else {
                        jM3051contentColorForek8zF_U = j2;
                    }
                    if ((i3 & 256) != 0) {
                        contentWindowInsets = ScaffoldDefaults.INSTANCE.getContentWindowInsets(composerStartRestartGroup, 6);
                        i4 &= -234881025;
                    } else {
                        contentWindowInsets = windowInsets;
                    }
                    j5 = jM3051contentColorForek8zF_U;
                } else {
                    if (i17 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i18 != 0) {
                        function2M3102getLambda$39202156$material3 = ComposableSingletons$ScaffoldKt.INSTANCE.m3102getLambda$39202156$material3();
                    } else {
                        function2M3102getLambda$39202156$material3 = function7;
                    }
                    if (i5 != 0) {
                        lambda$1582488484$material3 = ComposableSingletons$ScaffoldKt.INSTANCE.getLambda$1582488484$material3();
                    } else {
                        lambda$1582488484$material3 = function8;
                    }
                    if (i7 != 0) {
                        lambda$414328099$material3 = ComposableSingletons$ScaffoldKt.INSTANCE.getLambda$414328099$material3();
                    } else {
                        lambda$414328099$material3 = function9;
                    }
                    if (i9 != 0) {
                        function2M3101getLambda$1514016380$material3 = ComposableSingletons$ScaffoldKt.INSTANCE.m3101getLambda$1514016380$material3();
                    } else {
                        function2M3101getLambda$1514016380$material3 = function10;
                    }
                    if (i11 != 0) {
                        iM3359getEndERTFSPs = FabPosition.INSTANCE.m3359getEndERTFSPs();
                    } else {
                        iM3359getEndERTFSPs = i;
                    }
                    if ((i3 & 64) != 0) {
                        i4 &= -3670017;
                        background = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).getBackground();
                    } else {
                        background = j;
                    }
                    if ((i3 & 128) != 0) {
                        jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(background, composerStartRestartGroup, (i4 >> 18) & 14);
                        i4 &= -29360129;
                    } else {
                        jM3051contentColorForek8zF_U = j2;
                    }
                    if ((i3 & 256) != 0) {
                        contentWindowInsets = ScaffoldDefaults.INSTANCE.getContentWindowInsets(composerStartRestartGroup, 6);
                        i4 &= -234881025;
                    } else {
                        contentWindowInsets = windowInsets;
                    }
                    j5 = jM3051contentColorForek8zF_U;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1211482744, i4, -1, "androidx.compose.material3.Scaffold (Scaffold.kt:93)");
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -298761166, "CC(remember):Scaffold.kt#9igjgp");
                int i1112 = (234881024 & i4) ^ r19;
                if (i1112 <= 67108864) {
                }
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z2) {
                    objRememberedValue = new MutableWindowInsets(contentWindowInsets);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new MutableWindowInsets(contentWindowInsets);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                mutableWindowInsets = (MutableWindowInsets) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                long j19 = background;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -298755960, "CC(remember):Scaffold.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(mutableWindowInsets) | ((i1112 <= 67108864 && composerStartRestartGroup.changed(contentWindowInsets)) || (i4 & 100663296) == 67108864);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue2 = new Function1() { // from class: androidx.compose.material3.ScaffoldKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return ScaffoldKt.Scaffold_TvnljyQ$lambda$1$0(mutableWindowInsets, contentWindowInsets, (WindowInsets) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = new Function1() { // from class: androidx.compose.material3.ScaffoldKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return ScaffoldKt.Scaffold_TvnljyQ$lambda$1$0(mutableWindowInsets, contentWindowInsets, (WindowInsets) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                final Function2 function1111117 = function2M3102getLambda$39202156$material3;
                final Function2 function1111118 = lambda$1582488484$material3;
                final Function2 function1111119 = lambda$414328099$material3;
                final Function2 function11111110 = function2M3101getLambda$1514016380$material3;
                final int i2116 = iM3359getEndERTFSPs;
                int i2117 = i4 >> 12;
                composer2 = composerStartRestartGroup;
                SurfaceKt.m4323SurfaceT9BRK9s(WindowInsetsPaddingKt.onConsumedWindowInsetsChanged(companion, (Function1) objRememberedValue2), null, j19, j5, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(848889571, true, new Function2() { // from class: androidx.compose.material3.ScaffoldKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ScaffoldKt.Scaffold_TvnljyQ$lambda$2(i2116, function1111117, function6, function1111119, function11111110, mutableWindowInsets, function1111118, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composer2, (i2117 & 896) | 12582912 | (i2117 & 7168), 114);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier2 = companion;
                function11 = function2M3102getLambda$39202156$material3;
                function12 = lambda$1582488484$material3;
                function13 = lambda$414328099$material3;
                function14 = function2M3101getLambda$1514016380$material3;
                i13 = iM3359getEndERTFSPs;
                windowInsets2 = contentWindowInsets;
                j3 = j19;
                j4 = j5;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier2 = modifier;
                windowInsets2 = windowInsets;
                function11 = function7;
                function12 = function8;
                function13 = function9;
                function14 = function10;
                i13 = i;
                j3 = j;
                j4 = j2;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ScaffoldKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ScaffoldKt.Scaffold_TvnljyQ$lambda$3(modifier2, function11, function12, function13, function14, i13, j3, j4, windowInsets2, function6, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i4 |= 3072;
        function9 = function4;
        i9 = i3 & 16;
        if (i9 != 0) {
            if ((i2 & 24576) == 0) {
                function10 = function5;
                if (composerStartRestartGroup.changedInstance(function10)) {
                    i10 = 16384;
                } else {
                    i10 = 8192;
                }
                i4 |= i10;
            }
            i11 = i3 & 32;
            if (i11 != 0) {
                i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            } else if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                if (composerStartRestartGroup.changed(i)) {
                    i12 = 131072;
                } else {
                    i12 = 65536;
                }
                i4 |= i12;
            }
            if ((i2 & 1572864) != 0) {
                if ((i3 & 64) == 0) {
                    i16 = 524288;
                } else {
                    i16 = 524288;
                }
                i4 |= i16;
            }
            if ((i2 & 12582912) != 0) {
                if ((i3 & 128) == 0) {
                    i15 = 4194304;
                } else {
                    i15 = 4194304;
                }
                i4 |= i15;
            }
            if ((i2 & 100663296) != 0) {
                i4 |= ((i3 & 256) == 0 || !composerStartRestartGroup.changed(windowInsets)) ? 33554432 : 67108864;
            }
            if ((i2 & 805306368) == 0) {
                if (composerStartRestartGroup.changedInstance(function6)) {
                    i14 = C.BUFFER_FLAG_LAST_SAMPLE;
                } else {
                    i14 = 268435456;
                }
                i4 |= i14;
            }
            if ((i4 & 306783379) != 306783378) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "89@4637L11,90@4687L31,91@4777L19");
                if ((i2 & 1) != 0) {
                    if (i17 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i18 != 0) {
                        function2M3102getLambda$39202156$material3 = ComposableSingletons$ScaffoldKt.INSTANCE.m3102getLambda$39202156$material3();
                    } else {
                        function2M3102getLambda$39202156$material3 = function7;
                    }
                    if (i5 != 0) {
                        lambda$1582488484$material3 = ComposableSingletons$ScaffoldKt.INSTANCE.getLambda$1582488484$material3();
                    } else {
                        lambda$1582488484$material3 = function8;
                    }
                    if (i7 != 0) {
                        lambda$414328099$material3 = ComposableSingletons$ScaffoldKt.INSTANCE.getLambda$414328099$material3();
                    } else {
                        lambda$414328099$material3 = function9;
                    }
                    if (i9 != 0) {
                        function2M3101getLambda$1514016380$material3 = ComposableSingletons$ScaffoldKt.INSTANCE.m3101getLambda$1514016380$material3();
                    } else {
                        function2M3101getLambda$1514016380$material3 = function10;
                    }
                    if (i11 != 0) {
                        iM3359getEndERTFSPs = FabPosition.INSTANCE.m3359getEndERTFSPs();
                    } else {
                        iM3359getEndERTFSPs = i;
                    }
                    if ((i3 & 64) != 0) {
                        i4 &= -3670017;
                        background = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).getBackground();
                    } else {
                        background = j;
                    }
                    if ((i3 & 128) != 0) {
                        jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(background, composerStartRestartGroup, (i4 >> 18) & 14);
                        i4 &= -29360129;
                    } else {
                        jM3051contentColorForek8zF_U = j2;
                    }
                    if ((i3 & 256) != 0) {
                        contentWindowInsets = ScaffoldDefaults.INSTANCE.getContentWindowInsets(composerStartRestartGroup, 6);
                        i4 &= -234881025;
                    } else {
                        contentWindowInsets = windowInsets;
                    }
                    j5 = jM3051contentColorForek8zF_U;
                } else {
                    if (i17 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier;
                    }
                    if (i18 != 0) {
                        function2M3102getLambda$39202156$material3 = ComposableSingletons$ScaffoldKt.INSTANCE.m3102getLambda$39202156$material3();
                    } else {
                        function2M3102getLambda$39202156$material3 = function7;
                    }
                    if (i5 != 0) {
                        lambda$1582488484$material3 = ComposableSingletons$ScaffoldKt.INSTANCE.getLambda$1582488484$material3();
                    } else {
                        lambda$1582488484$material3 = function8;
                    }
                    if (i7 != 0) {
                        lambda$414328099$material3 = ComposableSingletons$ScaffoldKt.INSTANCE.getLambda$414328099$material3();
                    } else {
                        lambda$414328099$material3 = function9;
                    }
                    if (i9 != 0) {
                        function2M3101getLambda$1514016380$material3 = ComposableSingletons$ScaffoldKt.INSTANCE.m3101getLambda$1514016380$material3();
                    } else {
                        function2M3101getLambda$1514016380$material3 = function10;
                    }
                    if (i11 != 0) {
                        iM3359getEndERTFSPs = FabPosition.INSTANCE.m3359getEndERTFSPs();
                    } else {
                        iM3359getEndERTFSPs = i;
                    }
                    if ((i3 & 64) != 0) {
                        i4 &= -3670017;
                        background = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).getBackground();
                    } else {
                        background = j;
                    }
                    if ((i3 & 128) != 0) {
                        jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(background, composerStartRestartGroup, (i4 >> 18) & 14);
                        i4 &= -29360129;
                    } else {
                        jM3051contentColorForek8zF_U = j2;
                    }
                    if ((i3 & 256) != 0) {
                        contentWindowInsets = ScaffoldDefaults.INSTANCE.getContentWindowInsets(composerStartRestartGroup, 6);
                        i4 &= -234881025;
                    } else {
                        contentWindowInsets = windowInsets;
                    }
                    j5 = jM3051contentColorForek8zF_U;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1211482744, i4, -1, "androidx.compose.material3.Scaffold (Scaffold.kt:93)");
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -298761166, "CC(remember):Scaffold.kt#9igjgp");
                int i1113 = (234881024 & i4) ^ r19;
                if (i1113 <= 67108864) {
                }
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z2) {
                    objRememberedValue = new MutableWindowInsets(contentWindowInsets);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new MutableWindowInsets(contentWindowInsets);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                mutableWindowInsets = (MutableWindowInsets) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                long j110 = background;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -298755960, "CC(remember):Scaffold.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(mutableWindowInsets) | ((i1113 <= 67108864 && composerStartRestartGroup.changed(contentWindowInsets)) || (i4 & 100663296) == 67108864);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue2 = new Function1() { // from class: androidx.compose.material3.ScaffoldKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return ScaffoldKt.Scaffold_TvnljyQ$lambda$1$0(mutableWindowInsets, contentWindowInsets, (WindowInsets) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = new Function1() { // from class: androidx.compose.material3.ScaffoldKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return ScaffoldKt.Scaffold_TvnljyQ$lambda$1$0(mutableWindowInsets, contentWindowInsets, (WindowInsets) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                final Function2 function11111111 = function2M3102getLambda$39202156$material3;
                final Function2 function11111112 = lambda$1582488484$material3;
                final Function2 function11111113 = lambda$414328099$material3;
                final Function2 function11111114 = function2M3101getLambda$1514016380$material3;
                final int i2118 = iM3359getEndERTFSPs;
                int i2119 = i4 >> 12;
                composer2 = composerStartRestartGroup;
                SurfaceKt.m4323SurfaceT9BRK9s(WindowInsetsPaddingKt.onConsumedWindowInsetsChanged(companion, (Function1) objRememberedValue2), null, j110, j5, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(848889571, true, new Function2() { // from class: androidx.compose.material3.ScaffoldKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ScaffoldKt.Scaffold_TvnljyQ$lambda$2(i2118, function11111111, function6, function11111113, function11111114, mutableWindowInsets, function11111112, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composer2, (i2119 & 896) | 12582912 | (i2119 & 7168), 114);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier2 = companion;
                function11 = function2M3102getLambda$39202156$material3;
                function12 = lambda$1582488484$material3;
                function13 = lambda$414328099$material3;
                function14 = function2M3101getLambda$1514016380$material3;
                i13 = iM3359getEndERTFSPs;
                windowInsets2 = contentWindowInsets;
                j3 = j110;
                j4 = j5;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier2 = modifier;
                windowInsets2 = windowInsets;
                function11 = function7;
                function12 = function8;
                function13 = function9;
                function14 = function10;
                i13 = i;
                j3 = j;
                j4 = j2;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ScaffoldKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ScaffoldKt.Scaffold_TvnljyQ$lambda$3(modifier2, function11, function12, function13, function14, i13, j3, j4, windowInsets2, function6, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i4 |= 24576;
        function10 = function5;
        i11 = i3 & 32;
        if (i11 != 0) {
            i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        } else if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            if (composerStartRestartGroup.changed(i)) {
                i12 = 131072;
            } else {
                i12 = 65536;
            }
            i4 |= i12;
        }
        if ((i2 & 1572864) != 0) {
            if ((i3 & 64) == 0) {
                i16 = 524288;
            } else {
                i16 = 524288;
            }
            i4 |= i16;
        }
        if ((i2 & 12582912) != 0) {
            if ((i3 & 128) == 0) {
                i15 = 4194304;
            } else {
                i15 = 4194304;
            }
            i4 |= i15;
        }
        if ((i2 & 100663296) != 0) {
            i4 |= ((i3 & 256) == 0 || !composerStartRestartGroup.changed(windowInsets)) ? 33554432 : 67108864;
        }
        if ((i2 & 805306368) == 0) {
            if (composerStartRestartGroup.changedInstance(function6)) {
                i14 = C.BUFFER_FLAG_LAST_SAMPLE;
            } else {
                i14 = 268435456;
            }
            i4 |= i14;
        }
        if ((i4 & 306783379) != 306783378) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "89@4637L11,90@4687L31,91@4777L19");
            if ((i2 & 1) != 0) {
                if (i17 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier;
                }
                if (i18 != 0) {
                    function2M3102getLambda$39202156$material3 = ComposableSingletons$ScaffoldKt.INSTANCE.m3102getLambda$39202156$material3();
                } else {
                    function2M3102getLambda$39202156$material3 = function7;
                }
                if (i5 != 0) {
                    lambda$1582488484$material3 = ComposableSingletons$ScaffoldKt.INSTANCE.getLambda$1582488484$material3();
                } else {
                    lambda$1582488484$material3 = function8;
                }
                if (i7 != 0) {
                    lambda$414328099$material3 = ComposableSingletons$ScaffoldKt.INSTANCE.getLambda$414328099$material3();
                } else {
                    lambda$414328099$material3 = function9;
                }
                if (i9 != 0) {
                    function2M3101getLambda$1514016380$material3 = ComposableSingletons$ScaffoldKt.INSTANCE.m3101getLambda$1514016380$material3();
                } else {
                    function2M3101getLambda$1514016380$material3 = function10;
                }
                if (i11 != 0) {
                    iM3359getEndERTFSPs = FabPosition.INSTANCE.m3359getEndERTFSPs();
                } else {
                    iM3359getEndERTFSPs = i;
                }
                if ((i3 & 64) != 0) {
                    i4 &= -3670017;
                    background = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).getBackground();
                } else {
                    background = j;
                }
                if ((i3 & 128) != 0) {
                    jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(background, composerStartRestartGroup, (i4 >> 18) & 14);
                    i4 &= -29360129;
                } else {
                    jM3051contentColorForek8zF_U = j2;
                }
                if ((i3 & 256) != 0) {
                    contentWindowInsets = ScaffoldDefaults.INSTANCE.getContentWindowInsets(composerStartRestartGroup, 6);
                    i4 &= -234881025;
                } else {
                    contentWindowInsets = windowInsets;
                }
                j5 = jM3051contentColorForek8zF_U;
            } else {
                if (i17 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier;
                }
                if (i18 != 0) {
                    function2M3102getLambda$39202156$material3 = ComposableSingletons$ScaffoldKt.INSTANCE.m3102getLambda$39202156$material3();
                } else {
                    function2M3102getLambda$39202156$material3 = function7;
                }
                if (i5 != 0) {
                    lambda$1582488484$material3 = ComposableSingletons$ScaffoldKt.INSTANCE.getLambda$1582488484$material3();
                } else {
                    lambda$1582488484$material3 = function8;
                }
                if (i7 != 0) {
                    lambda$414328099$material3 = ComposableSingletons$ScaffoldKt.INSTANCE.getLambda$414328099$material3();
                } else {
                    lambda$414328099$material3 = function9;
                }
                if (i9 != 0) {
                    function2M3101getLambda$1514016380$material3 = ComposableSingletons$ScaffoldKt.INSTANCE.m3101getLambda$1514016380$material3();
                } else {
                    function2M3101getLambda$1514016380$material3 = function10;
                }
                if (i11 != 0) {
                    iM3359getEndERTFSPs = FabPosition.INSTANCE.m3359getEndERTFSPs();
                } else {
                    iM3359getEndERTFSPs = i;
                }
                if ((i3 & 64) != 0) {
                    i4 &= -3670017;
                    background = MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6).getBackground();
                } else {
                    background = j;
                }
                if ((i3 & 128) != 0) {
                    jM3051contentColorForek8zF_U = ColorSchemeKt.m3051contentColorForek8zF_U(background, composerStartRestartGroup, (i4 >> 18) & 14);
                    i4 &= -29360129;
                } else {
                    jM3051contentColorForek8zF_U = j2;
                }
                if ((i3 & 256) != 0) {
                    contentWindowInsets = ScaffoldDefaults.INSTANCE.getContentWindowInsets(composerStartRestartGroup, 6);
                    i4 &= -234881025;
                } else {
                    contentWindowInsets = windowInsets;
                }
                j5 = jM3051contentColorForek8zF_U;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1211482744, i4, -1, "androidx.compose.material3.Scaffold (Scaffold.kt:93)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -298761166, "CC(remember):Scaffold.kt#9igjgp");
            int i1114 = (234881024 & i4) ^ r19;
            if (i1114 <= 67108864) {
            }
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (!z2) {
                objRememberedValue = new MutableWindowInsets(contentWindowInsets);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            } else {
                objRememberedValue = new MutableWindowInsets(contentWindowInsets);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            mutableWindowInsets = (MutableWindowInsets) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            long j111 = background;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -298755960, "CC(remember):Scaffold.kt#9igjgp");
            zChanged = composerStartRestartGroup.changed(mutableWindowInsets) | ((i1114 <= 67108864 && composerStartRestartGroup.changed(contentWindowInsets)) || (i4 & 100663296) == 67108864);
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (!zChanged) {
                objRememberedValue2 = new Function1() { // from class: androidx.compose.material3.ScaffoldKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ScaffoldKt.Scaffold_TvnljyQ$lambda$1$0(mutableWindowInsets, contentWindowInsets, (WindowInsets) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            } else {
                objRememberedValue2 = new Function1() { // from class: androidx.compose.material3.ScaffoldKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ScaffoldKt.Scaffold_TvnljyQ$lambda$1$0(mutableWindowInsets, contentWindowInsets, (WindowInsets) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final Function2 function11111115 = function2M3102getLambda$39202156$material3;
            final Function2 function11111116 = lambda$1582488484$material3;
            final Function2 function11111117 = lambda$414328099$material3;
            final Function2 function11111118 = function2M3101getLambda$1514016380$material3;
            final int i21110 = iM3359getEndERTFSPs;
            int i21111 = i4 >> 12;
            composer2 = composerStartRestartGroup;
            SurfaceKt.m4323SurfaceT9BRK9s(WindowInsetsPaddingKt.onConsumedWindowInsetsChanged(companion, (Function1) objRememberedValue2), null, j111, j5, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(848889571, true, new Function2() { // from class: androidx.compose.material3.ScaffoldKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ScaffoldKt.Scaffold_TvnljyQ$lambda$2(i21110, function11111115, function6, function11111117, function11111118, mutableWindowInsets, function11111116, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composer2, (i21111 & 896) | 12582912 | (i21111 & 7168), 114);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = companion;
            function11 = function2M3102getLambda$39202156$material3;
            function12 = lambda$1582488484$material3;
            function13 = lambda$414328099$material3;
            function14 = function2M3101getLambda$1514016380$material3;
            i13 = iM3359getEndERTFSPs;
            windowInsets2 = contentWindowInsets;
            j3 = j111;
            j4 = j5;
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            modifier2 = modifier;
            windowInsets2 = windowInsets;
            function11 = function7;
            function12 = function8;
            function13 = function9;
            function14 = function10;
            i13 = i;
            j3 = j;
            j4 = j2;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ScaffoldKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ScaffoldKt.Scaffold_TvnljyQ$lambda$3(modifier2, function11, function12, function13, function14, i13, j3, j4, windowInsets2, function6, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Scaffold_TvnljyQ$lambda$1$0(MutableWindowInsets mutableWindowInsets, WindowInsets windowInsets, WindowInsets windowInsets2) {
        mutableWindowInsets.setInsets(WindowInsetsKt.exclude(windowInsets, windowInsets2));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Scaffold_TvnljyQ$lambda$2(int i, Function2 function2, Function3 function3, Function2 function4, Function2 function5, MutableWindowInsets mutableWindowInsets, Function2 function6, Composer composer, int i2) {
        ComposerKt.sourceInformation(composer, "C104@5342L299:Scaffold.kt#uh7d8r");
        if (!composer.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(848889571, i2, -1, "androidx.compose.material3.Scaffold.<anonymous> (Scaffold.kt:104)");
            }
            m4039ScaffoldLayoutFMILGgc(i, function2, function3, function4, function5, mutableWindowInsets, function6, composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: ScaffoldLayout-FMILGgc, reason: not valid java name */
    private static final void m4039ScaffoldLayoutFMILGgc(final int i, final Function2<? super Composer, ? super Integer, Unit> function2, final Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> function3, final Function2<? super Composer, ? super Integer, Unit> function4, final Function2<? super Composer, ? super Integer, Unit> function5, final WindowInsets windowInsets, final Function2<? super Composer, ? super Integer, Unit> function6, Composer composer, final int i2) {
        int i3;
        boolean z;
        int i4;
        Composer composerStartRestartGroup = composer.startRestartGroup(-280287501);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ScaffoldLayout)N(fabPosition:c#material3.FabPosition,topBar,content,snackbar,fab,contentWindowInsets,bottomBar)142@6839L626,158@7515L41,159@7607L45,160@7698L35,162@7788L73,163@7913L47,164@7982L5885,164@7965L5902:Scaffold.kt#uh7d8r");
        if ((i2 & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(i) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function2) ? 32 : 16;
        }
        if ((i2 & 384) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function3) ? 256 : 128;
        }
        if ((i2 & 3072) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function4) ? 2048 : 1024;
        }
        if ((i2 & 24576) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function5) ? 16384 : 8192;
        }
        if ((196608 & i2) == 0) {
            i3 |= composerStartRestartGroup.changed(windowInsets) ? 131072 : 65536;
        }
        if ((i2 & 1572864) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function6) ? 1048576 : 524288;
        }
        if (!composerStartRestartGroup.shouldExecute((i3 & 599187) != 599186, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-280287501, i3, -1, "androidx.compose.material3.ScaffoldLayout (Scaffold.kt:137)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1226670373, "CC(remember):Scaffold.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new ScaffoldKt$ScaffoldLayout$contentPadding$1$1();
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            final ScaffoldKt$ScaffoldLayout$contentPadding$1$1 scaffoldKt$ScaffoldLayout$contentPadding$1$1 = (ScaffoldKt$ScaffoldLayout$contentPadding$1$1) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1226691420, "CC(remember):Scaffold.kt#9igjgp");
            boolean z2 = (i3 & 112) == 32;
            ComposableLambda composableLambdaRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z2 || composableLambdaRememberedValue == Composer.INSTANCE.getEmpty()) {
                composableLambdaRememberedValue = ComposableLambdaKt.composableLambdaInstance(605195056, true, new Function2() { // from class: androidx.compose.material3.ScaffoldKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ScaffoldKt.ScaffoldLayout_FMILGgc$lambda$1$0(function2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
                composerStartRestartGroup.updateRememberedValue(composableLambdaRememberedValue);
            }
            final Function2 function7 = (Function2) composableLambdaRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1226694368, "CC(remember):Scaffold.kt#9igjgp");
            boolean z3 = (i3 & 7168) == 2048;
            ComposableLambda composableLambdaRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (z3 || composableLambdaRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                composableLambdaRememberedValue2 = ComposableLambdaKt.composableLambdaInstance(418899191, true, new Function2() { // from class: androidx.compose.material3.ScaffoldKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ScaffoldKt.ScaffoldLayout_FMILGgc$lambda$2$0(function4, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
                composerStartRestartGroup.updateRememberedValue(composableLambdaRememberedValue2);
            }
            final Function2 function8 = (Function2) composableLambdaRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1226697270, "CC(remember):Scaffold.kt#9igjgp");
            boolean z4 = (57344 & i3) == 16384;
            ComposableLambda composableLambdaRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (z4 || composableLambdaRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                composableLambdaRememberedValue3 = ComposableLambdaKt.composableLambdaInstance(338600263, true, new Function2() { // from class: androidx.compose.material3.ScaffoldKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ScaffoldKt.ScaffoldLayout_FMILGgc$lambda$3$0(function5, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
                composerStartRestartGroup.updateRememberedValue(composableLambdaRememberedValue3);
            }
            final Function2 function9 = (Function2) composableLambdaRememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1226700188, "CC(remember):Scaffold.kt#9igjgp");
            boolean z5 = (i3 & 896) == 256;
            ComposableLambda composableLambdaRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (z5 || composableLambdaRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                composableLambdaRememberedValue4 = ComposableLambdaKt.composableLambdaInstance(-1776388365, true, new Function2() { // from class: androidx.compose.material3.ScaffoldKt$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ScaffoldKt.ScaffoldLayout_FMILGgc$lambda$4$0(function3, scaffoldKt$ScaffoldLayout$contentPadding$1$1, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
                composerStartRestartGroup.updateRememberedValue(composableLambdaRememberedValue4);
            }
            final Function2 function10 = (Function2) composableLambdaRememberedValue4;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1226704162, "CC(remember):Scaffold.kt#9igjgp");
            boolean z6 = (3670016 & i3) == 1048576;
            ComposableLambda composableLambdaRememberedValue5 = composerStartRestartGroup.rememberedValue();
            if (z6 || composableLambdaRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                z = true;
                composableLambdaRememberedValue5 = ComposableLambdaKt.composableLambdaInstance(-1731662488, true, new Function2() { // from class: androidx.compose.material3.ScaffoldKt$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ScaffoldKt.ScaffoldLayout_FMILGgc$lambda$5$0(function6, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
                composerStartRestartGroup.updateRememberedValue(composableLambdaRememberedValue5);
            } else {
                z = true;
            }
            final Function2 function11 = (Function2) composableLambdaRememberedValue5;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1226712208, "CC(remember):Scaffold.kt#9igjgp");
            boolean zChanged = ((458752 & i3) == 131072 ? z : false) | composerStartRestartGroup.changed(function7) | composerStartRestartGroup.changed(function8) | composerStartRestartGroup.changed(function9) | ((i3 & 14) == 4 ? z : false) | composerStartRestartGroup.changed(function11) | composerStartRestartGroup.changed(function10);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                i4 = 0;
                Function2 function12 = new Function2() { // from class: androidx.compose.material3.ScaffoldKt$$ExternalSyntheticLambda10
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ScaffoldKt.ScaffoldLayout_FMILGgc$lambda$6$0(windowInsets, function7, function8, function9, i, function11, scaffoldKt$ScaffoldLayout$contentPadding$1$1, function10, (SubcomposeMeasureScope) obj, (Constraints) obj2);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(function12);
                objRememberedValue2 = function12;
            } else {
                i4 = 0;
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            SubcomposeLayoutKt.SubcomposeLayout(null, (Function2) objRememberedValue2, composerStartRestartGroup, i4, z);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ScaffoldKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ScaffoldKt.ScaffoldLayout_FMILGgc$lambda$7(i, function2, function3, function4, function5, windowInsets, function6, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ScaffoldLayout_FMILGgc$lambda$1$0(Function2 function2, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C158@7536L16:Scaffold.kt#uh7d8r");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(605195056, i, -1, "androidx.compose.material3.ScaffoldLayout.<anonymous>.<anonymous> (Scaffold.kt:158)");
            }
            ComposerKt.sourceInformationMarkerStart(composer, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            Modifier.Companion companion = Modifier.INSTANCE;
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, companion);
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
            ComposerKt.sourceInformationMarkerStart(composer, -1154869819, "C158@7542L8:Scaffold.kt#uh7d8r");
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
    public static final Unit ScaffoldLayout_FMILGgc$lambda$2$0(Function2 function2, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C159@7630L18:Scaffold.kt#uh7d8r");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(418899191, i, -1, "androidx.compose.material3.ScaffoldLayout.<anonymous>.<anonymous> (Scaffold.kt:159)");
            }
            ComposerKt.sourceInformationMarkerStart(composer, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            Modifier.Companion companion = Modifier.INSTANCE;
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, companion);
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
            ComposerKt.sourceInformationMarkerStart(composer, 367258716, "C159@7636L10:Scaffold.kt#uh7d8r");
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
    public static final Unit ScaffoldLayout_FMILGgc$lambda$3$0(Function2 function2, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C160@7716L13:Scaffold.kt#uh7d8r");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(338600263, i, -1, "androidx.compose.material3.ScaffoldLayout.<anonymous>.<anonymous> (Scaffold.kt:160)");
            }
            ComposerKt.sourceInformationMarkerStart(composer, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            Modifier.Companion companion = Modifier.INSTANCE;
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, companion);
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
            ComposerKt.sourceInformationMarkerStart(composer, 2140512701, "C160@7722L5:Scaffold.kt#uh7d8r");
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
    public static final Unit ScaffoldLayout_FMILGgc$lambda$4$0(Function3 function3, ScaffoldKt$ScaffoldLayout$contentPadding$1$1 scaffoldKt$ScaffoldLayout$contentPadding$1$1, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C162@7826L31:Scaffold.kt#uh7d8r");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1776388365, i, -1, "androidx.compose.material3.ScaffoldLayout.<anonymous>.<anonymous> (Scaffold.kt:162)");
            }
            ComposerKt.sourceInformationMarkerStart(composer, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            Modifier.Companion companion = Modifier.INSTANCE;
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, companion);
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
            ComposerKt.sourceInformationMarkerStart(composer, -931973261, "C162@7832L23:Scaffold.kt#uh7d8r");
            function3.invoke(scaffoldKt$ScaffoldLayout$contentPadding$1$1, composer, 6);
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
    public static final Unit ScaffoldLayout_FMILGgc$lambda$5$0(Function2 function2, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C163@7937L19:Scaffold.kt#uh7d8r");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1731662488, i, -1, "androidx.compose.material3.ScaffoldLayout.<anonymous>.<anonymous> (Scaffold.kt:163)");
            }
            ComposerKt.sourceInformationMarkerStart(composer, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
            Modifier.Companion companion = Modifier.INSTANCE;
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, companion);
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
            ComposerKt.sourceInformationMarkerStart(composer, 79510070, "C163@7943L11:Scaffold.kt#uh7d8r");
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
    public static final MeasureResult ScaffoldLayout_FMILGgc$lambda$6$0(final WindowInsets windowInsets, Function2 function2, Function2 function3, Function2 function4, int i, Function2 function5, ScaffoldKt$ScaffoldLayout$contentPadding$1$1 scaffoldKt$ScaffoldLayout$contentPadding$1$1, Function2 function6, final SubcomposeMeasureScope subcomposeMeasureScope, Constraints constraints) {
        int i2;
        int i3;
        int i4;
        final FabPlacement fabPlacement;
        Integer numValueOf;
        float top;
        float bottom;
        int iIntValue;
        int height;
        int bottom2;
        final int iM9640getMaxWidthimpl = Constraints.m9640getMaxWidthimpl(constraints.getValue());
        final int iM9639getMaxHeightimpl = Constraints.m9639getMaxHeightimpl(constraints.getValue());
        long jM9630copyZbe2FdA$default = Constraints.m9630copyZbe2FdA$default(constraints.getValue(), 0, 0, 0, 0, 10, null);
        SubcomposeMeasureScope subcomposeMeasureScope2 = subcomposeMeasureScope;
        int left = windowInsets.getLeft(subcomposeMeasureScope2, subcomposeMeasureScope.getLayoutDirection());
        int right = windowInsets.getRight(subcomposeMeasureScope2, subcomposeMeasureScope.getLayoutDirection());
        int bottom3 = windowInsets.getBottom(subcomposeMeasureScope2);
        final Placeable placeableMo8265measureBRTryo0 = ((Measurable) CollectionsKt.first((List) subcomposeMeasureScope.subcompose(ScaffoldLayoutContent.TopBar, function2))).mo8265measureBRTryo0(jM9630copyZbe2FdA$default);
        int i5 = (-left) - right;
        int i6 = -bottom3;
        final Placeable placeableMo8265measureBRTryo1 = ((Measurable) CollectionsKt.first((List) subcomposeMeasureScope.subcompose(ScaffoldLayoutContent.Snackbar, function3))).mo8265measureBRTryo0(ConstraintsKt.m9659offsetNN6EwU(jM9630copyZbe2FdA$default, i5, i6));
        final Placeable placeableMo8265measureBRTryo2 = ((Measurable) CollectionsKt.first((List) subcomposeMeasureScope.subcompose(ScaffoldLayoutContent.Fab, function4))).mo8265measureBRTryo0(ConstraintsKt.m9659offsetNN6EwU(jM9630copyZbe2FdA$default, i5, i6));
        if (placeableMo8265measureBRTryo2.getWidth() == 0 && placeableMo8265measureBRTryo2.getHeight() == 0) {
            fabPlacement = null;
        } else {
            int width = placeableMo8265measureBRTryo2.getWidth();
            int height2 = placeableMo8265measureBRTryo2.getHeight();
            if (FabPosition.m3354equalsimpl0(i, FabPosition.INSTANCE.m3361getStartERTFSPs())) {
                if (subcomposeMeasureScope.getLayoutDirection() == LayoutDirection.Ltr) {
                    i2 = subcomposeMeasureScope.mo748roundToPx0680j_4(FabSpacing);
                    i4 = i2 + left;
                } else {
                    i3 = subcomposeMeasureScope.mo748roundToPx0680j_4(FabSpacing);
                    i4 = ((iM9640getMaxWidthimpl - i3) - width) - right;
                }
            } else if (FabPosition.m3354equalsimpl0(i, FabPosition.INSTANCE.m3359getEndERTFSPs()) || FabPosition.m3354equalsimpl0(i, FabPosition.INSTANCE.m3360getEndOverlayERTFSPs())) {
                if (subcomposeMeasureScope.getLayoutDirection() == LayoutDirection.Ltr) {
                    i3 = subcomposeMeasureScope.mo748roundToPx0680j_4(FabSpacing);
                    i4 = ((iM9640getMaxWidthimpl - i3) - width) - right;
                } else {
                    i2 = subcomposeMeasureScope.mo748roundToPx0680j_4(FabSpacing);
                    i4 = i2 + left;
                }
            } else {
                i4 = (((iM9640getMaxWidthimpl - width) + left) - right) / 2;
            }
            fabPlacement = new FabPlacement(i4, width, height2);
        }
        final Placeable placeableMo8265measureBRTryo3 = ((Measurable) CollectionsKt.first((List) subcomposeMeasureScope.subcompose(ScaffoldLayoutContent.BottomBar, function5))).mo8265measureBRTryo0(jM9630copyZbe2FdA$default);
        int i7 = 0;
        boolean z = placeableMo8265measureBRTryo3.getWidth() == 0 && placeableMo8265measureBRTryo3.getHeight() == 0;
        if (fabPlacement != null) {
            if (z || FabPosition.m3354equalsimpl0(i, FabPosition.INSTANCE.m3360getEndOverlayERTFSPs())) {
                height = fabPlacement.getHeight() + subcomposeMeasureScope.mo748roundToPx0680j_4(FabSpacing);
                bottom2 = windowInsets.getBottom(subcomposeMeasureScope2);
            } else {
                height = placeableMo8265measureBRTryo3.getHeight() + fabPlacement.getHeight();
                bottom2 = subcomposeMeasureScope.mo748roundToPx0680j_4(FabSpacing);
            }
            numValueOf = Integer.valueOf(height + bottom2);
        } else {
            numValueOf = null;
        }
        int height3 = placeableMo8265measureBRTryo1.getHeight();
        if (height3 != 0) {
            if (numValueOf != null) {
                iIntValue = numValueOf.intValue();
            } else {
                Integer numValueOf2 = Integer.valueOf(placeableMo8265measureBRTryo3.getHeight());
                numValueOf2.intValue();
                if (z) {
                    numValueOf2 = null;
                }
                iIntValue = numValueOf2 != null ? numValueOf2.intValue() : windowInsets.getBottom(subcomposeMeasureScope2);
            }
            i7 = iIntValue + height3;
        }
        PaddingValues paddingValuesAsPaddingValues = WindowInsetsKt.asPaddingValues(windowInsets, subcomposeMeasureScope2);
        if (placeableMo8265measureBRTryo0.getWidth() == 0 && placeableMo8265measureBRTryo0.getHeight() == 0) {
            top = paddingValuesAsPaddingValues.getTop();
        } else {
            top = subcomposeMeasureScope.mo751toDpu2uoSUM(placeableMo8265measureBRTryo0.getHeight());
        }
        if (z) {
            bottom = paddingValuesAsPaddingValues.getBottom();
        } else {
            bottom = subcomposeMeasureScope.mo751toDpu2uoSUM(placeableMo8265measureBRTryo3.getHeight());
        }
        final Integer num = numValueOf;
        scaffoldKt$ScaffoldLayout$contentPadding$1$1.setPaddingHolder(PaddingKt.m1214PaddingValuesa9UjIt4(PaddingKt.calculateStartPadding(paddingValuesAsPaddingValues, subcomposeMeasureScope.getLayoutDirection()), top, PaddingKt.calculateEndPadding(paddingValuesAsPaddingValues, subcomposeMeasureScope.getLayoutDirection()), bottom));
        final Placeable placeableMo8265measureBRTryo4 = ((Measurable) CollectionsKt.first((List) subcomposeMeasureScope.subcompose(ScaffoldLayoutContent.MainContent, function6))).mo8265measureBRTryo0(jM9630copyZbe2FdA$default);
        final int i8 = i7;
        return MeasureScope.layout$default(subcomposeMeasureScope, iM9640getMaxWidthimpl, iM9639getMaxHeightimpl, null, new Function1() { // from class: androidx.compose.material3.ScaffoldKt$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ScaffoldKt.ScaffoldLayout_FMILGgc$lambda$6$0$2(placeableMo8265measureBRTryo4, placeableMo8265measureBRTryo0, placeableMo8265measureBRTryo1, iM9640getMaxWidthimpl, windowInsets, subcomposeMeasureScope, iM9639getMaxHeightimpl, i8, placeableMo8265measureBRTryo3, fabPlacement, placeableMo8265measureBRTryo2, num, (Placeable.PlacementScope) obj);
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ScaffoldLayout_FMILGgc$lambda$6$0$2(Placeable placeable, Placeable placeable2, Placeable placeable3, int i, WindowInsets windowInsets, SubcomposeMeasureScope subcomposeMeasureScope, int i2, int i3, Placeable placeable4, FabPlacement fabPlacement, Placeable placeable5, Integer num, Placeable.PlacementScope placementScope) {
        Placeable.PlacementScope.place$default(placementScope, placeable, 0, 0, 0.0f, 4, null);
        Placeable.PlacementScope.place$default(placementScope, placeable2, 0, 0, 0.0f, 4, null);
        SubcomposeMeasureScope subcomposeMeasureScope2 = subcomposeMeasureScope;
        Placeable.PlacementScope.place$default(placementScope, placeable3, (((i - placeable3.getWidth()) + windowInsets.getLeft(subcomposeMeasureScope2, subcomposeMeasureScope.getLayoutDirection())) - windowInsets.getRight(subcomposeMeasureScope2, subcomposeMeasureScope.getLayoutDirection())) / 2, i2 - i3, 0.0f, 4, null);
        Placeable.PlacementScope.place$default(placementScope, placeable4, 0, i2 - placeable4.getHeight(), 0.0f, 4, null);
        if (fabPlacement != null) {
            int left = fabPlacement.getLeft();
            Intrinsics.checkNotNull(num);
            Placeable.PlacementScope.place$default(placementScope, placeable5, left, i2 - num.intValue(), 0.0f, 4, null);
        }
        return Unit.INSTANCE;
    }
}
