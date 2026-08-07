package com.box.android.base.compose.dialog;

import androidx.compose.material3.AndroidAlertDialog_androidKt;
import androidx.compose.material3.ButtonColors;
import androidx.compose.material3.ButtonDefaults;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.platform.TestTagKt;
import androidx.media3.common.C;
import androidx.profileinstaller.ProfileVerifier;
import com.box.android.base.compose.BoxTheme;
import com.box.android.base.compose.BoxThemeKt;
import com.box.android.base.compose.ComposeUtilsKt;
import com.box.android.base.compose.button.BoxTextButtonKt;
import com.box.android.base.compose.button.model.ButtonItem;
import com.box.android.base.compose.dialog.model.DialogButtonsConfig;
import com.box.android.domain.metrics.hubs.HubsObservability;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.events.ComposeIdentificationData;

/* JADX INFO: compiled from: BoxDialog.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u009e\u0001\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00032\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0015\b\u0002\u0010\r\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0015\b\u0002\u0010\u000e\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0010H\u0001¢\u0006\u0004\b\u0012\u0010\u0013\u001a\r\u0010\u0014\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u0015¨\u0006\u0016"}, d2 = {"BoxDialog", "", "onDismissRequest", "Lkotlin/Function0;", "content", "Landroidx/compose/runtime/Composable;", "button", "Lcom/box/android/base/compose/dialog/model/DialogButtonsConfig;", "modifier", "Landroidx/compose/ui/Modifier;", ComposeIdentificationData.FIELD_TEST_TAG_HASHED, "", "contentDescription", HubsObservability.HUB_ASSET_ICON, "title", "positiveButtonColor", "Landroidx/compose/ui/graphics/Color;", "negativeButtonColor", "BoxDialog-0S3VyRs", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Lcom/box/android/base/compose/dialog/model/DialogButtonsConfig;Landroidx/compose/ui/Modifier;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;JJLandroidx/compose/runtime/Composer;II)V", "BoxDialogPreview", "(Landroidx/compose/runtime/Composer;I)V", "base_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class BoxDialogKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxDialogPreview$lambda$0(int i, Composer composer, int i2) {
        BoxDialogPreview(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxDialog_0S3VyRs$lambda$5(Function0 function0, Function2 function2, DialogButtonsConfig dialogButtonsConfig, Modifier modifier, String str, String str2, Function2 function3, Function2 function4, long j, long j2, int i, int i2, Composer composer, int i3) {
        m11710BoxDialog0S3VyRs(function0, function2, dialogButtonsConfig, modifier, str, str2, function3, function4, j, j2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:102:0x0127  */
    /* JADX WARN: Code duplicated, block: B:103:0x0129  */
    /* JADX WARN: Code duplicated, block: B:106:0x0132  */
    /* JADX WARN: Code duplicated, block: B:108:0x0145  */
    /* JADX WARN: Code duplicated, block: B:119:0x0167 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:120:0x0169  */
    /* JADX WARN: Code duplicated, block: B:121:0x016e  */
    /* JADX WARN: Code duplicated, block: B:123:0x0171  */
    /* JADX WARN: Code duplicated, block: B:125:0x0174  */
    /* JADX WARN: Code duplicated, block: B:127:0x0177  */
    /* JADX WARN: Code duplicated, block: B:129:0x017a  */
    /* JADX WARN: Code duplicated, block: B:130:0x017c  */
    /* JADX WARN: Code duplicated, block: B:133:0x0182  */
    /* JADX WARN: Code duplicated, block: B:134:0x018f  */
    /* JADX WARN: Code duplicated, block: B:137:0x0195  */
    /* JADX WARN: Code duplicated, block: B:138:0x01aa  */
    /* JADX WARN: Code duplicated, block: B:141:0x01ba  */
    /* JADX WARN: Code duplicated, block: B:144:0x01c7  */
    /* JADX WARN: Code duplicated, block: B:145:0x01d5  */
    /* JADX WARN: Code duplicated, block: B:147:0x01da  */
    /* JADX WARN: Code duplicated, block: B:148:0x01e7  */
    /* JADX WARN: Code duplicated, block: B:150:0x01eb  */
    /* JADX WARN: Code duplicated, block: B:153:0x0209  */
    /* JADX WARN: Code duplicated, block: B:154:0x020e  */
    /* JADX WARN: Code duplicated, block: B:156:0x0211  */
    /* JADX WARN: Code duplicated, block: B:158:0x0217 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:159:0x0219  */
    /* JADX WARN: Code duplicated, block: B:160:0x021e  */
    /* JADX WARN: Code duplicated, block: B:161:0x0221  */
    /* JADX WARN: Code duplicated, block: B:163:0x0225  */
    /* JADX WARN: Code duplicated, block: B:165:0x0246  */
    /* JADX WARN: Code duplicated, block: B:167:0x0256  */
    /* JADX WARN: Code duplicated, block: B:170:0x0286  */
    /* JADX WARN: Code duplicated, block: B:171:0x0292  */
    /* JADX WARN: Code duplicated, block: B:174:0x0300  */
    /* JADX WARN: Code duplicated, block: B:176:0x030e  */
    /* JADX WARN: Code duplicated, block: B:178:0x0314  */
    /* JADX WARN: Code duplicated, block: B:181:0x0329  */
    /* JADX WARN: Code duplicated, block: B:183:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:37:0x0072  */
    /* JADX WARN: Code duplicated, block: B:38:0x0075  */
    /* JADX WARN: Code duplicated, block: B:40:0x0079  */
    /* JADX WARN: Code duplicated, block: B:42:0x0081  */
    /* JADX WARN: Code duplicated, block: B:43:0x0084  */
    /* JADX WARN: Code duplicated, block: B:48:0x0090  */
    /* JADX WARN: Code duplicated, block: B:49:0x0092  */
    /* JADX WARN: Code duplicated, block: B:51:0x0095  */
    /* JADX WARN: Code duplicated, block: B:53:0x009d  */
    /* JADX WARN: Code duplicated, block: B:54:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:59:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:60:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:62:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:64:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:65:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:70:0x00c9  */
    /* JADX WARN: Code duplicated, block: B:71:0x00ce  */
    /* JADX WARN: Code duplicated, block: B:73:0x00d4  */
    /* JADX WARN: Code duplicated, block: B:75:0x00da  */
    /* JADX WARN: Code duplicated, block: B:76:0x00dd  */
    /* JADX WARN: Code duplicated, block: B:80:0x00e7  */
    /* JADX WARN: Code duplicated, block: B:82:0x00eb  */
    /* JADX WARN: Code duplicated, block: B:85:0x00f6 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:88:0x00fd  */
    /* JADX WARN: Code duplicated, block: B:91:0x0105  */
    /* JADX WARN: Code duplicated, block: B:93:0x0109  */
    /* JADX WARN: Code duplicated, block: B:96:0x0114 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:99:0x011b  */
    /* JADX INFO: renamed from: BoxDialog-0S3VyRs, reason: not valid java name */
    public static final void m11710BoxDialog0S3VyRs(final Function0<Unit> function0, final Function2<? super Composer, ? super Integer, Unit> content, final DialogButtonsConfig button, Modifier modifier, String str, String str2, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function3, long j, long j2, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        String str3;
        int i5;
        int i6;
        String str4;
        int i7;
        int i8;
        Function2<? super Composer, ? super Integer, Unit> function4;
        int i9;
        int i10;
        int i11;
        boolean z;
        Composer composer2;
        final Function2<? super Composer, ? super Integer, Unit> function5;
        final Modifier modifier3;
        final String str5;
        final String str6;
        final Function2<? super Composer, ? super Integer, Unit> function6;
        final long j3;
        final long j4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        Function2<? super Composer, ? super Integer, Unit> function7;
        long jM11533getMainActiveControl0d7_KjU;
        int i12;
        String str7;
        final long j5;
        Function2<? super Composer, ? super Integer, Unit> function8;
        String str8;
        final long jM11533getMainActiveControl0d7_KjU2;
        Pair pair;
        final ButtonItem.TextButtonItem textButtonItem;
        Modifier modifierDialogSemantics;
        Function0<Unit> onClick;
        boolean z2;
        ComposableLambda composableLambdaRememberComposableLambda;
        Object objRememberedValue;
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(button, "button");
        Composer composerStartRestartGroup = composer.startRestartGroup(962660873);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BoxDialog)N(onDismissRequest,content,button,modifier,testTag,contentDescription,icon,title,positiveButtonColor:c#ui.graphics.Color,negativeButtonColor:c#ui.graphics.Color)61@3088L6,62@3149L6,63@3204L6,79@3847L503,56@2763L1593:BoxDialog.kt#fwd9q");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(function0) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(content) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changed(button) ? 256 : 128;
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
                    str3 = str;
                    if (composerStartRestartGroup.changed(str3)) {
                        i5 = 16384;
                    } else {
                        i5 = 8192;
                    }
                    i3 |= i5;
                }
                i6 = i2 & 32;
                if (i6 != 0) {
                    if ((196608 & i) == 0) {
                        str4 = str2;
                        if (composerStartRestartGroup.changed(str4)) {
                            i7 = 131072;
                        } else {
                            i7 = 65536;
                        }
                        i3 |= i7;
                    }
                    i8 = i2 & 64;
                    if (i8 != 0) {
                        if ((1572864 & i) == 0) {
                            function4 = function2;
                            if (composerStartRestartGroup.changedInstance(function4)) {
                                i9 = 1048576;
                            } else {
                                i9 = 524288;
                            }
                            i3 |= i9;
                        }
                        i10 = i2 & 128;
                        if (i10 != 0) {
                            i3 |= 12582912;
                        } else if ((i & 12582912) == 0) {
                            if (composerStartRestartGroup.changedInstance(function3)) {
                                i11 = 8388608;
                            } else {
                                i11 = 4194304;
                            }
                            i3 |= i11;
                        }
                        if ((i & 100663296) != 0) {
                            i3 |= ((i2 & 256) == 0 || !composerStartRestartGroup.changed(j)) ? 33554432 : 67108864;
                        }
                        if ((i & 805306368) != 0) {
                            i3 |= ((i2 & 512) == 0 || !composerStartRestartGroup.changed(j2)) ? 268435456 : C.BUFFER_FLAG_LAST_SAMPLE;
                        }
                        if ((i3 & 306783379) != 306783378) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                            composerStartRestartGroup.startDefaults();
                            ComposerKt.sourceInformation(composerStartRestartGroup, "47@2334L6,48@2402L6");
                            if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                if (i13 != 0) {
                                    companion = Modifier.INSTANCE;
                                } else {
                                    companion = modifier2;
                                }
                                if (i4 != 0) {
                                    str3 = null;
                                }
                                if (i6 != 0) {
                                    str4 = null;
                                }
                                if (i8 != 0) {
                                    function4 = null;
                                }
                                if (i10 != 0) {
                                    function7 = null;
                                } else {
                                    function7 = function3;
                                }
                                if ((i2 & 256) != 0) {
                                    jM11533getMainActiveControl0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                                    i3 &= -234881025;
                                } else {
                                    jM11533getMainActiveControl0d7_KjU = j;
                                }
                                if ((i2 & 512) != 0) {
                                    String str9 = str4;
                                    i12 = i3 & (-1879048193);
                                    str7 = str9;
                                    j5 = jM11533getMainActiveControl0d7_KjU;
                                    function8 = function7;
                                    str8 = str3;
                                    jM11533getMainActiveControl0d7_KjU2 = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                                } else {
                                    String str10 = str4;
                                    i12 = i3;
                                    str7 = str10;
                                    j5 = jM11533getMainActiveControl0d7_KjU;
                                    function8 = function7;
                                    str8 = str3;
                                }
                                composerStartRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(962660873, i12, -1, "com.box.android.base.compose.dialog.BoxDialog (BoxDialog.kt:49)");
                                }
                                if (button instanceof DialogButtonsConfig.PositiveButton) {
                                    pair = new Pair(((DialogButtonsConfig.PositiveButton) button).getButton(), null);
                                } else if (button instanceof DialogButtonsConfig.NegativeButton) {
                                    pair = new Pair(null, ((DialogButtonsConfig.NegativeButton) button).getButton());
                                } else {
                                    if (!(button instanceof DialogButtonsConfig.PositiveAndNegativeButtons)) {
                                        throw new NoWhenBranchMatchedException();
                                    }
                                    DialogButtonsConfig.PositiveAndNegativeButtons positiveAndNegativeButtons = (DialogButtonsConfig.PositiveAndNegativeButtons) button;
                                    pair = new Pair(positiveAndNegativeButtons.getPositiveButton(), positiveAndNegativeButtons.getNegativeButton());
                                }
                                final ButtonItem.TextButtonItem textButtonItem2 = (ButtonItem.TextButtonItem) pair.component1();
                                textButtonItem = (ButtonItem.TextButtonItem) pair.component2();
                                if (str8 != null) {
                                    modifierDialogSemantics = TestTagKt.testTag(companion, str8);
                                } else {
                                    modifierDialogSemantics = companion;
                                }
                                if (str7 != null) {
                                    modifierDialogSemantics = ComposeUtilsKt.dialogSemantics(modifierDialogSemantics, str7);
                                }
                                if (function0 != null) {
                                    onClick = function0;
                                } else if (textButtonItem != null) {
                                    onClick = textButtonItem.getOnClick();
                                } else {
                                    onClick = null;
                                }
                                if (onClick == null) {
                                    composerStartRestartGroup.startReplaceGroup(1134495670);
                                    ComposerKt.sourceInformation(composerStartRestartGroup, "60@3049L3");
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1699164620, "CC(remember):BoxDialog.kt#9igjgp");
                                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                        objRememberedValue = new Function0() { // from class: com.box.android.base.compose.dialog.BoxDialogKt$$ExternalSyntheticLambda1
                                            @Override // kotlin.jvm.functions.Function0
                                            public final Object invoke() {
                                                return Unit.INSTANCE;
                                            }
                                        };
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                    }
                                    onClick = (Function0) objRememberedValue;
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                } else {
                                    composerStartRestartGroup.startReplaceGroup(1699163163);
                                }
                                composerStartRestartGroup.endReplaceGroup();
                                long jM11516getDialogContainer0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11516getDialogContainer0d7_KjU();
                                long jM11500getAppPrimary0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11500getAppPrimary0d7_KjU();
                                long jM11526getItemInfoTextSecondary0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11526getItemInfoTextSecondary0d7_KjU();
                                if (textButtonItem == null) {
                                    composerStartRestartGroup.startReplaceGroup(1134801081);
                                    composerStartRestartGroup.endReplaceGroup();
                                    composableLambdaRememberComposableLambda = null;
                                    z2 = true;
                                } else {
                                    composerStartRestartGroup.startReplaceGroup(1134801082);
                                    ComposerKt.sourceInformation(composerStartRestartGroup, "*68@3360L451");
                                    z2 = true;
                                    composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-1707763176, true, new Function2() { // from class: com.box.android.base.compose.dialog.BoxDialogKt$$ExternalSyntheticLambda2
                                        @Override // kotlin.jvm.functions.Function2
                                        public final Object invoke(Object obj, Object obj2) {
                                            return BoxDialogKt.BoxDialog_0S3VyRs$lambda$3$0(textButtonItem, jM11533getMainActiveControl0d7_KjU2, (Composer) obj, ((Integer) obj2).intValue());
                                        }
                                    }, composerStartRestartGroup, 54);
                                    composerStartRestartGroup.endReplaceGroup();
                                }
                                ComposableLambda composableLambdaRememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(-825495871, z2, new Function2() { // from class: com.box.android.base.compose.dialog.BoxDialogKt$$ExternalSyntheticLambda3
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return BoxDialogKt.BoxDialog_0S3VyRs$lambda$4(textButtonItem2, j5, (Composer) obj, ((Integer) obj2).intValue());
                                    }
                                }, composerStartRestartGroup, 54);
                                int i14 = i12 >> 6;
                                int i15 = (i14 & 458752) | (57344 & i14) | 48 | ((i12 << 15) & 3670016);
                                long j6 = j5;
                                long j7 = jM11533getMainActiveControl0d7_KjU2;
                                composer2 = composerStartRestartGroup;
                                Function2<? super Composer, ? super Integer, Unit> function9 = function4;
                                String str11 = str8;
                                String str12 = str7;
                                Function2<? super Composer, ? super Integer, Unit> function10 = function8;
                                AndroidAlertDialog_androidKt.m2731AlertDialogOix01E0(onClick, composableLambdaRememberComposableLambda2, modifierDialogSemantics, composableLambdaRememberComposableLambda, function9, function10, content, null, jM11516getDialogContainer0d7_KjU, 0L, jM11500getAppPrimary0d7_KjU, jM11526getItemInfoTextSecondary0d7_KjU, 0.0f, null, composer2, i15, 0, 12928);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                modifier3 = companion;
                                str5 = str11;
                                function5 = function10;
                                j4 = j7;
                                j3 = j6;
                                function6 = function9;
                                str6 = str12;
                            } else {
                                composerStartRestartGroup.skipToGroupEnd();
                                if ((i2 & 256) != 0) {
                                    i3 &= -234881025;
                                }
                                if ((i2 & 512) != 0) {
                                    i3 &= -1879048193;
                                }
                                String str13 = str4;
                                i12 = i3;
                                str7 = str13;
                                function8 = function3;
                                companion = modifier2;
                                str8 = str3;
                                j5 = j;
                            }
                            jM11533getMainActiveControl0d7_KjU2 = j2;
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(962660873, i12, -1, "com.box.android.base.compose.dialog.BoxDialog (BoxDialog.kt:49)");
                            }
                            if (button instanceof DialogButtonsConfig.PositiveButton) {
                                pair = new Pair(((DialogButtonsConfig.PositiveButton) button).getButton(), null);
                            } else if (button instanceof DialogButtonsConfig.NegativeButton) {
                                pair = new Pair(null, ((DialogButtonsConfig.NegativeButton) button).getButton());
                            } else {
                                if (!(button instanceof DialogButtonsConfig.PositiveAndNegativeButtons)) {
                                    throw new NoWhenBranchMatchedException();
                                }
                                DialogButtonsConfig.PositiveAndNegativeButtons positiveAndNegativeButtons2 = (DialogButtonsConfig.PositiveAndNegativeButtons) button;
                                pair = new Pair(positiveAndNegativeButtons2.getPositiveButton(), positiveAndNegativeButtons2.getNegativeButton());
                            }
                            final ButtonItem.TextButtonItem textButtonItem3 = (ButtonItem.TextButtonItem) pair.component1();
                            textButtonItem = (ButtonItem.TextButtonItem) pair.component2();
                            if (str8 != null) {
                                modifierDialogSemantics = TestTagKt.testTag(companion, str8);
                            } else {
                                modifierDialogSemantics = companion;
                            }
                            if (str7 != null) {
                                modifierDialogSemantics = ComposeUtilsKt.dialogSemantics(modifierDialogSemantics, str7);
                            }
                            if (function0 != null) {
                                onClick = function0;
                            } else if (textButtonItem != null) {
                                onClick = textButtonItem.getOnClick();
                            } else {
                                onClick = null;
                            }
                            if (onClick == null) {
                                composerStartRestartGroup.startReplaceGroup(1134495670);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "60@3049L3");
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1699164620, "CC(remember):BoxDialog.kt#9igjgp");
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue = new Function0() { // from class: com.box.android.base.compose.dialog.BoxDialogKt$$ExternalSyntheticLambda1
                                        @Override // kotlin.jvm.functions.Function0
                                        public final Object invoke() {
                                            return Unit.INSTANCE;
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                onClick = (Function0) objRememberedValue;
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            } else {
                                composerStartRestartGroup.startReplaceGroup(1699163163);
                            }
                            composerStartRestartGroup.endReplaceGroup();
                            long jM11516getDialogContainer0d7_KjU2 = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11516getDialogContainer0d7_KjU();
                            long jM11500getAppPrimary0d7_KjU2 = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11500getAppPrimary0d7_KjU();
                            long jM11526getItemInfoTextSecondary0d7_KjU2 = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11526getItemInfoTextSecondary0d7_KjU();
                            if (textButtonItem == null) {
                                composerStartRestartGroup.startReplaceGroup(1134801081);
                                composerStartRestartGroup.endReplaceGroup();
                                composableLambdaRememberComposableLambda = null;
                                z2 = true;
                            } else {
                                composerStartRestartGroup.startReplaceGroup(1134801082);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "*68@3360L451");
                                z2 = true;
                                composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-1707763176, true, new Function2() { // from class: com.box.android.base.compose.dialog.BoxDialogKt$$ExternalSyntheticLambda2
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return BoxDialogKt.BoxDialog_0S3VyRs$lambda$3$0(textButtonItem, jM11533getMainActiveControl0d7_KjU2, (Composer) obj, ((Integer) obj2).intValue());
                                    }
                                }, composerStartRestartGroup, 54);
                                composerStartRestartGroup.endReplaceGroup();
                            }
                            ComposableLambda composableLambdaRememberComposableLambda3 = ComposableLambdaKt.rememberComposableLambda(-825495871, z2, new Function2() { // from class: com.box.android.base.compose.dialog.BoxDialogKt$$ExternalSyntheticLambda3
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return BoxDialogKt.BoxDialog_0S3VyRs$lambda$4(textButtonItem3, j5, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composerStartRestartGroup, 54);
                            int i16 = i12 >> 6;
                            int i17 = (i16 & 458752) | (57344 & i16) | 48 | ((i12 << 15) & 3670016);
                            long j8 = j5;
                            long j9 = jM11533getMainActiveControl0d7_KjU2;
                            composer2 = composerStartRestartGroup;
                            Function2<? super Composer, ? super Integer, Unit> function11 = function4;
                            String str14 = str8;
                            String str15 = str7;
                            Function2<? super Composer, ? super Integer, Unit> function12 = function8;
                            AndroidAlertDialog_androidKt.m2731AlertDialogOix01E0(onClick, composableLambdaRememberComposableLambda3, modifierDialogSemantics, composableLambdaRememberComposableLambda, function11, function12, content, null, jM11516getDialogContainer0d7_KjU2, 0L, jM11500getAppPrimary0d7_KjU2, jM11526getItemInfoTextSecondary0d7_KjU2, 0.0f, null, composer2, i17, 0, 12928);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier3 = companion;
                            str5 = str14;
                            function5 = function12;
                            j4 = j9;
                            j3 = j8;
                            function6 = function11;
                            str6 = str15;
                        } else {
                            composer2 = composerStartRestartGroup;
                            composer2.skipToGroupEnd();
                            function5 = function3;
                            modifier3 = modifier2;
                            str5 = str3;
                            str6 = str4;
                            function6 = function4;
                            j3 = j;
                            j4 = j2;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.dialog.BoxDialogKt$$ExternalSyntheticLambda4
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return BoxDialogKt.BoxDialog_0S3VyRs$lambda$5(function0, content, button, modifier3, str5, str6, function6, function5, j3, j4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                        }
                    }
                    i3 |= 1572864;
                    function4 = function2;
                    i10 = i2 & 128;
                    if (i10 != 0) {
                        i3 |= 12582912;
                    } else if ((i & 12582912) == 0) {
                        if (composerStartRestartGroup.changedInstance(function3)) {
                            i11 = 8388608;
                        } else {
                            i11 = 4194304;
                        }
                        i3 |= i11;
                    }
                    if ((i & 100663296) != 0) {
                        i3 |= ((i2 & 256) == 0 || !composerStartRestartGroup.changed(j)) ? 33554432 : 67108864;
                    }
                    if ((i & 805306368) != 0) {
                        i3 |= ((i2 & 512) == 0 || !composerStartRestartGroup.changed(j2)) ? 268435456 : C.BUFFER_FLAG_LAST_SAMPLE;
                    }
                    if ((i3 & 306783379) != 306783378) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "47@2334L6,48@2402L6");
                        if ((i & 1) != 0) {
                            if (i13 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier2;
                            }
                            if (i4 != 0) {
                                str3 = null;
                            }
                            if (i6 != 0) {
                                str4 = null;
                            }
                            if (i8 != 0) {
                                function4 = null;
                            }
                            if (i10 != 0) {
                                function7 = null;
                            } else {
                                function7 = function3;
                            }
                            if ((i2 & 256) != 0) {
                                jM11533getMainActiveControl0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                                i3 &= -234881025;
                            } else {
                                jM11533getMainActiveControl0d7_KjU = j;
                            }
                            if ((i2 & 512) != 0) {
                                String str16 = str4;
                                i12 = i3 & (-1879048193);
                                str7 = str16;
                                j5 = jM11533getMainActiveControl0d7_KjU;
                                function8 = function7;
                                str8 = str3;
                                jM11533getMainActiveControl0d7_KjU2 = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                            } else {
                                String str17 = str4;
                                i12 = i3;
                                str7 = str17;
                                j5 = jM11533getMainActiveControl0d7_KjU;
                                function8 = function7;
                                str8 = str3;
                                jM11533getMainActiveControl0d7_KjU2 = j2;
                            }
                        } else {
                            if (i13 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier2;
                            }
                            if (i4 != 0) {
                                str3 = null;
                            }
                            if (i6 != 0) {
                                str4 = null;
                            }
                            if (i8 != 0) {
                                function4 = null;
                            }
                            if (i10 != 0) {
                                function7 = null;
                            } else {
                                function7 = function3;
                            }
                            if ((i2 & 256) != 0) {
                                jM11533getMainActiveControl0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                                i3 &= -234881025;
                            } else {
                                jM11533getMainActiveControl0d7_KjU = j;
                            }
                            if ((i2 & 512) != 0) {
                                String str18 = str4;
                                i12 = i3 & (-1879048193);
                                str7 = str18;
                                j5 = jM11533getMainActiveControl0d7_KjU;
                                function8 = function7;
                                str8 = str3;
                                jM11533getMainActiveControl0d7_KjU2 = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                            } else {
                                String str19 = str4;
                                i12 = i3;
                                str7 = str19;
                                j5 = jM11533getMainActiveControl0d7_KjU;
                                function8 = function7;
                                str8 = str3;
                                jM11533getMainActiveControl0d7_KjU2 = j2;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(962660873, i12, -1, "com.box.android.base.compose.dialog.BoxDialog (BoxDialog.kt:49)");
                        }
                        if (button instanceof DialogButtonsConfig.PositiveButton) {
                            pair = new Pair(((DialogButtonsConfig.PositiveButton) button).getButton(), null);
                        } else if (button instanceof DialogButtonsConfig.NegativeButton) {
                            pair = new Pair(null, ((DialogButtonsConfig.NegativeButton) button).getButton());
                        } else {
                            if (!(button instanceof DialogButtonsConfig.PositiveAndNegativeButtons)) {
                                throw new NoWhenBranchMatchedException();
                            }
                            DialogButtonsConfig.PositiveAndNegativeButtons positiveAndNegativeButtons3 = (DialogButtonsConfig.PositiveAndNegativeButtons) button;
                            pair = new Pair(positiveAndNegativeButtons3.getPositiveButton(), positiveAndNegativeButtons3.getNegativeButton());
                        }
                        final ButtonItem.TextButtonItem textButtonItem4 = (ButtonItem.TextButtonItem) pair.component1();
                        textButtonItem = (ButtonItem.TextButtonItem) pair.component2();
                        if (str8 != null) {
                            modifierDialogSemantics = TestTagKt.testTag(companion, str8);
                        } else {
                            modifierDialogSemantics = companion;
                        }
                        if (str7 != null) {
                            modifierDialogSemantics = ComposeUtilsKt.dialogSemantics(modifierDialogSemantics, str7);
                        }
                        if (function0 != null) {
                            onClick = function0;
                        } else if (textButtonItem != null) {
                            onClick = textButtonItem.getOnClick();
                        } else {
                            onClick = null;
                        }
                        if (onClick == null) {
                            composerStartRestartGroup.startReplaceGroup(1134495670);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "60@3049L3");
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1699164620, "CC(remember):BoxDialog.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = new Function0() { // from class: com.box.android.base.compose.dialog.BoxDialogKt$$ExternalSyntheticLambda1
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return Unit.INSTANCE;
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            onClick = (Function0) objRememberedValue;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        } else {
                            composerStartRestartGroup.startReplaceGroup(1699163163);
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        long jM11516getDialogContainer0d7_KjU3 = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11516getDialogContainer0d7_KjU();
                        long jM11500getAppPrimary0d7_KjU3 = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11500getAppPrimary0d7_KjU();
                        long jM11526getItemInfoTextSecondary0d7_KjU3 = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11526getItemInfoTextSecondary0d7_KjU();
                        if (textButtonItem == null) {
                            composerStartRestartGroup.startReplaceGroup(1134801081);
                            composerStartRestartGroup.endReplaceGroup();
                            composableLambdaRememberComposableLambda = null;
                            z2 = true;
                        } else {
                            composerStartRestartGroup.startReplaceGroup(1134801082);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "*68@3360L451");
                            z2 = true;
                            composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-1707763176, true, new Function2() { // from class: com.box.android.base.compose.dialog.BoxDialogKt$$ExternalSyntheticLambda2
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return BoxDialogKt.BoxDialog_0S3VyRs$lambda$3$0(textButtonItem, jM11533getMainActiveControl0d7_KjU2, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composerStartRestartGroup, 54);
                            composerStartRestartGroup.endReplaceGroup();
                        }
                        ComposableLambda composableLambdaRememberComposableLambda4 = ComposableLambdaKt.rememberComposableLambda(-825495871, z2, new Function2() { // from class: com.box.android.base.compose.dialog.BoxDialogKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return BoxDialogKt.BoxDialog_0S3VyRs$lambda$4(textButtonItem4, j5, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                        int i18 = i12 >> 6;
                        int i19 = (i18 & 458752) | (57344 & i18) | 48 | ((i12 << 15) & 3670016);
                        long j10 = j5;
                        long j11 = jM11533getMainActiveControl0d7_KjU2;
                        composer2 = composerStartRestartGroup;
                        Function2<? super Composer, ? super Integer, Unit> function13 = function4;
                        String str110 = str8;
                        String str111 = str7;
                        Function2<? super Composer, ? super Integer, Unit> function14 = function8;
                        AndroidAlertDialog_androidKt.m2731AlertDialogOix01E0(onClick, composableLambdaRememberComposableLambda4, modifierDialogSemantics, composableLambdaRememberComposableLambda, function13, function14, content, null, jM11516getDialogContainer0d7_KjU3, 0L, jM11500getAppPrimary0d7_KjU3, jM11526getItemInfoTextSecondary0d7_KjU3, 0.0f, null, composer2, i19, 0, 12928);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = companion;
                        str5 = str110;
                        function5 = function14;
                        j4 = j11;
                        j3 = j10;
                        function6 = function13;
                        str6 = str111;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        function5 = function3;
                        modifier3 = modifier2;
                        str5 = str3;
                        str6 = str4;
                        function6 = function4;
                        j3 = j;
                        j4 = j2;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.dialog.BoxDialogKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return BoxDialogKt.BoxDialog_0S3VyRs$lambda$5(function0, content, button, modifier3, str5, str6, function6, function5, j3, j4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                str4 = str2;
                i8 = i2 & 64;
                if (i8 != 0) {
                    if ((1572864 & i) == 0) {
                        function4 = function2;
                        if (composerStartRestartGroup.changedInstance(function4)) {
                            i9 = 1048576;
                        } else {
                            i9 = 524288;
                        }
                        i3 |= i9;
                    }
                    i10 = i2 & 128;
                    if (i10 != 0) {
                        i3 |= 12582912;
                    } else if ((i & 12582912) == 0) {
                        if (composerStartRestartGroup.changedInstance(function3)) {
                            i11 = 8388608;
                        } else {
                            i11 = 4194304;
                        }
                        i3 |= i11;
                    }
                    if ((i & 100663296) != 0) {
                        i3 |= ((i2 & 256) == 0 || !composerStartRestartGroup.changed(j)) ? 33554432 : 67108864;
                    }
                    if ((i & 805306368) != 0) {
                        i3 |= ((i2 & 512) == 0 || !composerStartRestartGroup.changed(j2)) ? 268435456 : C.BUFFER_FLAG_LAST_SAMPLE;
                    }
                    if ((i3 & 306783379) != 306783378) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "47@2334L6,48@2402L6");
                        if ((i & 1) != 0) {
                            if (i13 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier2;
                            }
                            if (i4 != 0) {
                                str3 = null;
                            }
                            if (i6 != 0) {
                                str4 = null;
                            }
                            if (i8 != 0) {
                                function4 = null;
                            }
                            if (i10 != 0) {
                                function7 = null;
                            } else {
                                function7 = function3;
                            }
                            if ((i2 & 256) != 0) {
                                jM11533getMainActiveControl0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                                i3 &= -234881025;
                            } else {
                                jM11533getMainActiveControl0d7_KjU = j;
                            }
                            if ((i2 & 512) != 0) {
                                String str112 = str4;
                                i12 = i3 & (-1879048193);
                                str7 = str112;
                                j5 = jM11533getMainActiveControl0d7_KjU;
                                function8 = function7;
                                str8 = str3;
                                jM11533getMainActiveControl0d7_KjU2 = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                            } else {
                                String str113 = str4;
                                i12 = i3;
                                str7 = str113;
                                j5 = jM11533getMainActiveControl0d7_KjU;
                                function8 = function7;
                                str8 = str3;
                                jM11533getMainActiveControl0d7_KjU2 = j2;
                            }
                        } else {
                            if (i13 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier2;
                            }
                            if (i4 != 0) {
                                str3 = null;
                            }
                            if (i6 != 0) {
                                str4 = null;
                            }
                            if (i8 != 0) {
                                function4 = null;
                            }
                            if (i10 != 0) {
                                function7 = null;
                            } else {
                                function7 = function3;
                            }
                            if ((i2 & 256) != 0) {
                                jM11533getMainActiveControl0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                                i3 &= -234881025;
                            } else {
                                jM11533getMainActiveControl0d7_KjU = j;
                            }
                            if ((i2 & 512) != 0) {
                                String str114 = str4;
                                i12 = i3 & (-1879048193);
                                str7 = str114;
                                j5 = jM11533getMainActiveControl0d7_KjU;
                                function8 = function7;
                                str8 = str3;
                                jM11533getMainActiveControl0d7_KjU2 = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                            } else {
                                String str115 = str4;
                                i12 = i3;
                                str7 = str115;
                                j5 = jM11533getMainActiveControl0d7_KjU;
                                function8 = function7;
                                str8 = str3;
                                jM11533getMainActiveControl0d7_KjU2 = j2;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(962660873, i12, -1, "com.box.android.base.compose.dialog.BoxDialog (BoxDialog.kt:49)");
                        }
                        if (button instanceof DialogButtonsConfig.PositiveButton) {
                            pair = new Pair(((DialogButtonsConfig.PositiveButton) button).getButton(), null);
                        } else if (button instanceof DialogButtonsConfig.NegativeButton) {
                            pair = new Pair(null, ((DialogButtonsConfig.NegativeButton) button).getButton());
                        } else {
                            if (!(button instanceof DialogButtonsConfig.PositiveAndNegativeButtons)) {
                                throw new NoWhenBranchMatchedException();
                            }
                            DialogButtonsConfig.PositiveAndNegativeButtons positiveAndNegativeButtons4 = (DialogButtonsConfig.PositiveAndNegativeButtons) button;
                            pair = new Pair(positiveAndNegativeButtons4.getPositiveButton(), positiveAndNegativeButtons4.getNegativeButton());
                        }
                        final ButtonItem.TextButtonItem textButtonItem5 = (ButtonItem.TextButtonItem) pair.component1();
                        textButtonItem = (ButtonItem.TextButtonItem) pair.component2();
                        if (str8 != null) {
                            modifierDialogSemantics = TestTagKt.testTag(companion, str8);
                        } else {
                            modifierDialogSemantics = companion;
                        }
                        if (str7 != null) {
                            modifierDialogSemantics = ComposeUtilsKt.dialogSemantics(modifierDialogSemantics, str7);
                        }
                        if (function0 != null) {
                            onClick = function0;
                        } else if (textButtonItem != null) {
                            onClick = textButtonItem.getOnClick();
                        } else {
                            onClick = null;
                        }
                        if (onClick == null) {
                            composerStartRestartGroup.startReplaceGroup(1134495670);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "60@3049L3");
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1699164620, "CC(remember):BoxDialog.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = new Function0() { // from class: com.box.android.base.compose.dialog.BoxDialogKt$$ExternalSyntheticLambda1
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return Unit.INSTANCE;
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            onClick = (Function0) objRememberedValue;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        } else {
                            composerStartRestartGroup.startReplaceGroup(1699163163);
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        long jM11516getDialogContainer0d7_KjU4 = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11516getDialogContainer0d7_KjU();
                        long jM11500getAppPrimary0d7_KjU4 = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11500getAppPrimary0d7_KjU();
                        long jM11526getItemInfoTextSecondary0d7_KjU4 = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11526getItemInfoTextSecondary0d7_KjU();
                        if (textButtonItem == null) {
                            composerStartRestartGroup.startReplaceGroup(1134801081);
                            composerStartRestartGroup.endReplaceGroup();
                            composableLambdaRememberComposableLambda = null;
                            z2 = true;
                        } else {
                            composerStartRestartGroup.startReplaceGroup(1134801082);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "*68@3360L451");
                            z2 = true;
                            composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-1707763176, true, new Function2() { // from class: com.box.android.base.compose.dialog.BoxDialogKt$$ExternalSyntheticLambda2
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return BoxDialogKt.BoxDialog_0S3VyRs$lambda$3$0(textButtonItem, jM11533getMainActiveControl0d7_KjU2, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composerStartRestartGroup, 54);
                            composerStartRestartGroup.endReplaceGroup();
                        }
                        ComposableLambda composableLambdaRememberComposableLambda5 = ComposableLambdaKt.rememberComposableLambda(-825495871, z2, new Function2() { // from class: com.box.android.base.compose.dialog.BoxDialogKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return BoxDialogKt.BoxDialog_0S3VyRs$lambda$4(textButtonItem5, j5, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                        int i110 = i12 >> 6;
                        int i111 = (i110 & 458752) | (57344 & i110) | 48 | ((i12 << 15) & 3670016);
                        long j12 = j5;
                        long j13 = jM11533getMainActiveControl0d7_KjU2;
                        composer2 = composerStartRestartGroup;
                        Function2<? super Composer, ? super Integer, Unit> function15 = function4;
                        String str116 = str8;
                        String str117 = str7;
                        Function2<? super Composer, ? super Integer, Unit> function16 = function8;
                        AndroidAlertDialog_androidKt.m2731AlertDialogOix01E0(onClick, composableLambdaRememberComposableLambda5, modifierDialogSemantics, composableLambdaRememberComposableLambda, function15, function16, content, null, jM11516getDialogContainer0d7_KjU4, 0L, jM11500getAppPrimary0d7_KjU4, jM11526getItemInfoTextSecondary0d7_KjU4, 0.0f, null, composer2, i111, 0, 12928);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = companion;
                        str5 = str116;
                        function5 = function16;
                        j4 = j13;
                        j3 = j12;
                        function6 = function15;
                        str6 = str117;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        function5 = function3;
                        modifier3 = modifier2;
                        str5 = str3;
                        str6 = str4;
                        function6 = function4;
                        j3 = j;
                        j4 = j2;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.dialog.BoxDialogKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return BoxDialogKt.BoxDialog_0S3VyRs$lambda$5(function0, content, button, modifier3, str5, str6, function6, function5, j3, j4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= 1572864;
                function4 = function2;
                i10 = i2 & 128;
                if (i10 != 0) {
                    i3 |= 12582912;
                } else if ((i & 12582912) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i11 = 8388608;
                    } else {
                        i11 = 4194304;
                    }
                    i3 |= i11;
                }
                if ((i & 100663296) != 0) {
                    i3 |= ((i2 & 256) == 0 || !composerStartRestartGroup.changed(j)) ? 33554432 : 67108864;
                }
                if ((i & 805306368) != 0) {
                    i3 |= ((i2 & 512) == 0 || !composerStartRestartGroup.changed(j2)) ? 268435456 : C.BUFFER_FLAG_LAST_SAMPLE;
                }
                if ((i3 & 306783379) != 306783378) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "47@2334L6,48@2402L6");
                    if ((i & 1) != 0) {
                        if (i13 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i4 != 0) {
                            str3 = null;
                        }
                        if (i6 != 0) {
                            str4 = null;
                        }
                        if (i8 != 0) {
                            function4 = null;
                        }
                        if (i10 != 0) {
                            function7 = null;
                        } else {
                            function7 = function3;
                        }
                        if ((i2 & 256) != 0) {
                            jM11533getMainActiveControl0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                            i3 &= -234881025;
                        } else {
                            jM11533getMainActiveControl0d7_KjU = j;
                        }
                        if ((i2 & 512) != 0) {
                            String str118 = str4;
                            i12 = i3 & (-1879048193);
                            str7 = str118;
                            j5 = jM11533getMainActiveControl0d7_KjU;
                            function8 = function7;
                            str8 = str3;
                            jM11533getMainActiveControl0d7_KjU2 = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                        } else {
                            String str119 = str4;
                            i12 = i3;
                            str7 = str119;
                            j5 = jM11533getMainActiveControl0d7_KjU;
                            function8 = function7;
                            str8 = str3;
                            jM11533getMainActiveControl0d7_KjU2 = j2;
                        }
                    } else {
                        if (i13 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i4 != 0) {
                            str3 = null;
                        }
                        if (i6 != 0) {
                            str4 = null;
                        }
                        if (i8 != 0) {
                            function4 = null;
                        }
                        if (i10 != 0) {
                            function7 = null;
                        } else {
                            function7 = function3;
                        }
                        if ((i2 & 256) != 0) {
                            jM11533getMainActiveControl0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                            i3 &= -234881025;
                        } else {
                            jM11533getMainActiveControl0d7_KjU = j;
                        }
                        if ((i2 & 512) != 0) {
                            String str1110 = str4;
                            i12 = i3 & (-1879048193);
                            str7 = str1110;
                            j5 = jM11533getMainActiveControl0d7_KjU;
                            function8 = function7;
                            str8 = str3;
                            jM11533getMainActiveControl0d7_KjU2 = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                        } else {
                            String str1111 = str4;
                            i12 = i3;
                            str7 = str1111;
                            j5 = jM11533getMainActiveControl0d7_KjU;
                            function8 = function7;
                            str8 = str3;
                            jM11533getMainActiveControl0d7_KjU2 = j2;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(962660873, i12, -1, "com.box.android.base.compose.dialog.BoxDialog (BoxDialog.kt:49)");
                    }
                    if (button instanceof DialogButtonsConfig.PositiveButton) {
                        pair = new Pair(((DialogButtonsConfig.PositiveButton) button).getButton(), null);
                    } else if (button instanceof DialogButtonsConfig.NegativeButton) {
                        pair = new Pair(null, ((DialogButtonsConfig.NegativeButton) button).getButton());
                    } else {
                        if (!(button instanceof DialogButtonsConfig.PositiveAndNegativeButtons)) {
                            throw new NoWhenBranchMatchedException();
                        }
                        DialogButtonsConfig.PositiveAndNegativeButtons positiveAndNegativeButtons5 = (DialogButtonsConfig.PositiveAndNegativeButtons) button;
                        pair = new Pair(positiveAndNegativeButtons5.getPositiveButton(), positiveAndNegativeButtons5.getNegativeButton());
                    }
                    final ButtonItem.TextButtonItem textButtonItem6 = (ButtonItem.TextButtonItem) pair.component1();
                    textButtonItem = (ButtonItem.TextButtonItem) pair.component2();
                    if (str8 != null) {
                        modifierDialogSemantics = TestTagKt.testTag(companion, str8);
                    } else {
                        modifierDialogSemantics = companion;
                    }
                    if (str7 != null) {
                        modifierDialogSemantics = ComposeUtilsKt.dialogSemantics(modifierDialogSemantics, str7);
                    }
                    if (function0 != null) {
                        onClick = function0;
                    } else if (textButtonItem != null) {
                        onClick = textButtonItem.getOnClick();
                    } else {
                        onClick = null;
                    }
                    if (onClick == null) {
                        composerStartRestartGroup.startReplaceGroup(1134495670);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "60@3049L3");
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1699164620, "CC(remember):BoxDialog.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new Function0() { // from class: com.box.android.base.compose.dialog.BoxDialogKt$$ExternalSyntheticLambda1
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return Unit.INSTANCE;
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        onClick = (Function0) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    } else {
                        composerStartRestartGroup.startReplaceGroup(1699163163);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    long jM11516getDialogContainer0d7_KjU5 = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11516getDialogContainer0d7_KjU();
                    long jM11500getAppPrimary0d7_KjU5 = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11500getAppPrimary0d7_KjU();
                    long jM11526getItemInfoTextSecondary0d7_KjU5 = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11526getItemInfoTextSecondary0d7_KjU();
                    if (textButtonItem == null) {
                        composerStartRestartGroup.startReplaceGroup(1134801081);
                        composerStartRestartGroup.endReplaceGroup();
                        composableLambdaRememberComposableLambda = null;
                        z2 = true;
                    } else {
                        composerStartRestartGroup.startReplaceGroup(1134801082);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "*68@3360L451");
                        z2 = true;
                        composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-1707763176, true, new Function2() { // from class: com.box.android.base.compose.dialog.BoxDialogKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return BoxDialogKt.BoxDialog_0S3VyRs$lambda$3$0(textButtonItem, jM11533getMainActiveControl0d7_KjU2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                        composerStartRestartGroup.endReplaceGroup();
                    }
                    ComposableLambda composableLambdaRememberComposableLambda6 = ComposableLambdaKt.rememberComposableLambda(-825495871, z2, new Function2() { // from class: com.box.android.base.compose.dialog.BoxDialogKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return BoxDialogKt.BoxDialog_0S3VyRs$lambda$4(textButtonItem6, j5, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54);
                    int i112 = i12 >> 6;
                    int i113 = (i112 & 458752) | (57344 & i112) | 48 | ((i12 << 15) & 3670016);
                    long j14 = j5;
                    long j15 = jM11533getMainActiveControl0d7_KjU2;
                    composer2 = composerStartRestartGroup;
                    Function2<? super Composer, ? super Integer, Unit> function17 = function4;
                    String str1112 = str8;
                    String str1113 = str7;
                    Function2<? super Composer, ? super Integer, Unit> function18 = function8;
                    AndroidAlertDialog_androidKt.m2731AlertDialogOix01E0(onClick, composableLambdaRememberComposableLambda6, modifierDialogSemantics, composableLambdaRememberComposableLambda, function17, function18, content, null, jM11516getDialogContainer0d7_KjU5, 0L, jM11500getAppPrimary0d7_KjU5, jM11526getItemInfoTextSecondary0d7_KjU5, 0.0f, null, composer2, i113, 0, 12928);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = companion;
                    str5 = str1112;
                    function5 = function18;
                    j4 = j15;
                    j3 = j14;
                    function6 = function17;
                    str6 = str1113;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    function5 = function3;
                    modifier3 = modifier2;
                    str5 = str3;
                    str6 = str4;
                    function6 = function4;
                    j3 = j;
                    j4 = j2;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.dialog.BoxDialogKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return BoxDialogKt.BoxDialog_0S3VyRs$lambda$5(function0, content, button, modifier3, str5, str6, function6, function5, j3, j4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 24576;
            str3 = str;
            i6 = i2 & 32;
            if (i6 != 0) {
                if ((196608 & i) == 0) {
                    str4 = str2;
                    if (composerStartRestartGroup.changed(str4)) {
                        i7 = 131072;
                    } else {
                        i7 = 65536;
                    }
                    i3 |= i7;
                }
                i8 = i2 & 64;
                if (i8 != 0) {
                    if ((1572864 & i) == 0) {
                        function4 = function2;
                        if (composerStartRestartGroup.changedInstance(function4)) {
                            i9 = 1048576;
                        } else {
                            i9 = 524288;
                        }
                        i3 |= i9;
                    }
                    i10 = i2 & 128;
                    if (i10 != 0) {
                        i3 |= 12582912;
                    } else if ((i & 12582912) == 0) {
                        if (composerStartRestartGroup.changedInstance(function3)) {
                            i11 = 8388608;
                        } else {
                            i11 = 4194304;
                        }
                        i3 |= i11;
                    }
                    if ((i & 100663296) != 0) {
                        i3 |= ((i2 & 256) == 0 || !composerStartRestartGroup.changed(j)) ? 33554432 : 67108864;
                    }
                    if ((i & 805306368) != 0) {
                        i3 |= ((i2 & 512) == 0 || !composerStartRestartGroup.changed(j2)) ? 268435456 : C.BUFFER_FLAG_LAST_SAMPLE;
                    }
                    if ((i3 & 306783379) != 306783378) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "47@2334L6,48@2402L6");
                        if ((i & 1) != 0) {
                            if (i13 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier2;
                            }
                            if (i4 != 0) {
                                str3 = null;
                            }
                            if (i6 != 0) {
                                str4 = null;
                            }
                            if (i8 != 0) {
                                function4 = null;
                            }
                            if (i10 != 0) {
                                function7 = null;
                            } else {
                                function7 = function3;
                            }
                            if ((i2 & 256) != 0) {
                                jM11533getMainActiveControl0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                                i3 &= -234881025;
                            } else {
                                jM11533getMainActiveControl0d7_KjU = j;
                            }
                            if ((i2 & 512) != 0) {
                                String str1114 = str4;
                                i12 = i3 & (-1879048193);
                                str7 = str1114;
                                j5 = jM11533getMainActiveControl0d7_KjU;
                                function8 = function7;
                                str8 = str3;
                                jM11533getMainActiveControl0d7_KjU2 = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                            } else {
                                String str1115 = str4;
                                i12 = i3;
                                str7 = str1115;
                                j5 = jM11533getMainActiveControl0d7_KjU;
                                function8 = function7;
                                str8 = str3;
                                jM11533getMainActiveControl0d7_KjU2 = j2;
                            }
                        } else {
                            if (i13 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier2;
                            }
                            if (i4 != 0) {
                                str3 = null;
                            }
                            if (i6 != 0) {
                                str4 = null;
                            }
                            if (i8 != 0) {
                                function4 = null;
                            }
                            if (i10 != 0) {
                                function7 = null;
                            } else {
                                function7 = function3;
                            }
                            if ((i2 & 256) != 0) {
                                jM11533getMainActiveControl0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                                i3 &= -234881025;
                            } else {
                                jM11533getMainActiveControl0d7_KjU = j;
                            }
                            if ((i2 & 512) != 0) {
                                String str1116 = str4;
                                i12 = i3 & (-1879048193);
                                str7 = str1116;
                                j5 = jM11533getMainActiveControl0d7_KjU;
                                function8 = function7;
                                str8 = str3;
                                jM11533getMainActiveControl0d7_KjU2 = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                            } else {
                                String str1117 = str4;
                                i12 = i3;
                                str7 = str1117;
                                j5 = jM11533getMainActiveControl0d7_KjU;
                                function8 = function7;
                                str8 = str3;
                                jM11533getMainActiveControl0d7_KjU2 = j2;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(962660873, i12, -1, "com.box.android.base.compose.dialog.BoxDialog (BoxDialog.kt:49)");
                        }
                        if (button instanceof DialogButtonsConfig.PositiveButton) {
                            pair = new Pair(((DialogButtonsConfig.PositiveButton) button).getButton(), null);
                        } else if (button instanceof DialogButtonsConfig.NegativeButton) {
                            pair = new Pair(null, ((DialogButtonsConfig.NegativeButton) button).getButton());
                        } else {
                            if (!(button instanceof DialogButtonsConfig.PositiveAndNegativeButtons)) {
                                throw new NoWhenBranchMatchedException();
                            }
                            DialogButtonsConfig.PositiveAndNegativeButtons positiveAndNegativeButtons6 = (DialogButtonsConfig.PositiveAndNegativeButtons) button;
                            pair = new Pair(positiveAndNegativeButtons6.getPositiveButton(), positiveAndNegativeButtons6.getNegativeButton());
                        }
                        final ButtonItem.TextButtonItem textButtonItem7 = (ButtonItem.TextButtonItem) pair.component1();
                        textButtonItem = (ButtonItem.TextButtonItem) pair.component2();
                        if (str8 != null) {
                            modifierDialogSemantics = TestTagKt.testTag(companion, str8);
                        } else {
                            modifierDialogSemantics = companion;
                        }
                        if (str7 != null) {
                            modifierDialogSemantics = ComposeUtilsKt.dialogSemantics(modifierDialogSemantics, str7);
                        }
                        if (function0 != null) {
                            onClick = function0;
                        } else if (textButtonItem != null) {
                            onClick = textButtonItem.getOnClick();
                        } else {
                            onClick = null;
                        }
                        if (onClick == null) {
                            composerStartRestartGroup.startReplaceGroup(1134495670);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "60@3049L3");
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1699164620, "CC(remember):BoxDialog.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = new Function0() { // from class: com.box.android.base.compose.dialog.BoxDialogKt$$ExternalSyntheticLambda1
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return Unit.INSTANCE;
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            onClick = (Function0) objRememberedValue;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        } else {
                            composerStartRestartGroup.startReplaceGroup(1699163163);
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        long jM11516getDialogContainer0d7_KjU6 = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11516getDialogContainer0d7_KjU();
                        long jM11500getAppPrimary0d7_KjU6 = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11500getAppPrimary0d7_KjU();
                        long jM11526getItemInfoTextSecondary0d7_KjU6 = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11526getItemInfoTextSecondary0d7_KjU();
                        if (textButtonItem == null) {
                            composerStartRestartGroup.startReplaceGroup(1134801081);
                            composerStartRestartGroup.endReplaceGroup();
                            composableLambdaRememberComposableLambda = null;
                            z2 = true;
                        } else {
                            composerStartRestartGroup.startReplaceGroup(1134801082);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "*68@3360L451");
                            z2 = true;
                            composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-1707763176, true, new Function2() { // from class: com.box.android.base.compose.dialog.BoxDialogKt$$ExternalSyntheticLambda2
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return BoxDialogKt.BoxDialog_0S3VyRs$lambda$3$0(textButtonItem, jM11533getMainActiveControl0d7_KjU2, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composerStartRestartGroup, 54);
                            composerStartRestartGroup.endReplaceGroup();
                        }
                        ComposableLambda composableLambdaRememberComposableLambda7 = ComposableLambdaKt.rememberComposableLambda(-825495871, z2, new Function2() { // from class: com.box.android.base.compose.dialog.BoxDialogKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return BoxDialogKt.BoxDialog_0S3VyRs$lambda$4(textButtonItem7, j5, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                        int i114 = i12 >> 6;
                        int i115 = (i114 & 458752) | (57344 & i114) | 48 | ((i12 << 15) & 3670016);
                        long j16 = j5;
                        long j17 = jM11533getMainActiveControl0d7_KjU2;
                        composer2 = composerStartRestartGroup;
                        Function2<? super Composer, ? super Integer, Unit> function19 = function4;
                        String str1118 = str8;
                        String str1119 = str7;
                        Function2<? super Composer, ? super Integer, Unit> function110 = function8;
                        AndroidAlertDialog_androidKt.m2731AlertDialogOix01E0(onClick, composableLambdaRememberComposableLambda7, modifierDialogSemantics, composableLambdaRememberComposableLambda, function19, function110, content, null, jM11516getDialogContainer0d7_KjU6, 0L, jM11500getAppPrimary0d7_KjU6, jM11526getItemInfoTextSecondary0d7_KjU6, 0.0f, null, composer2, i115, 0, 12928);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = companion;
                        str5 = str1118;
                        function5 = function110;
                        j4 = j17;
                        j3 = j16;
                        function6 = function19;
                        str6 = str1119;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        function5 = function3;
                        modifier3 = modifier2;
                        str5 = str3;
                        str6 = str4;
                        function6 = function4;
                        j3 = j;
                        j4 = j2;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.dialog.BoxDialogKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return BoxDialogKt.BoxDialog_0S3VyRs$lambda$5(function0, content, button, modifier3, str5, str6, function6, function5, j3, j4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= 1572864;
                function4 = function2;
                i10 = i2 & 128;
                if (i10 != 0) {
                    i3 |= 12582912;
                } else if ((i & 12582912) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i11 = 8388608;
                    } else {
                        i11 = 4194304;
                    }
                    i3 |= i11;
                }
                if ((i & 100663296) != 0) {
                    i3 |= ((i2 & 256) == 0 || !composerStartRestartGroup.changed(j)) ? 33554432 : 67108864;
                }
                if ((i & 805306368) != 0) {
                    i3 |= ((i2 & 512) == 0 || !composerStartRestartGroup.changed(j2)) ? 268435456 : C.BUFFER_FLAG_LAST_SAMPLE;
                }
                if ((i3 & 306783379) != 306783378) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "47@2334L6,48@2402L6");
                    if ((i & 1) != 0) {
                        if (i13 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i4 != 0) {
                            str3 = null;
                        }
                        if (i6 != 0) {
                            str4 = null;
                        }
                        if (i8 != 0) {
                            function4 = null;
                        }
                        if (i10 != 0) {
                            function7 = null;
                        } else {
                            function7 = function3;
                        }
                        if ((i2 & 256) != 0) {
                            jM11533getMainActiveControl0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                            i3 &= -234881025;
                        } else {
                            jM11533getMainActiveControl0d7_KjU = j;
                        }
                        if ((i2 & 512) != 0) {
                            String str11110 = str4;
                            i12 = i3 & (-1879048193);
                            str7 = str11110;
                            j5 = jM11533getMainActiveControl0d7_KjU;
                            function8 = function7;
                            str8 = str3;
                            jM11533getMainActiveControl0d7_KjU2 = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                        } else {
                            String str11111 = str4;
                            i12 = i3;
                            str7 = str11111;
                            j5 = jM11533getMainActiveControl0d7_KjU;
                            function8 = function7;
                            str8 = str3;
                            jM11533getMainActiveControl0d7_KjU2 = j2;
                        }
                    } else {
                        if (i13 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i4 != 0) {
                            str3 = null;
                        }
                        if (i6 != 0) {
                            str4 = null;
                        }
                        if (i8 != 0) {
                            function4 = null;
                        }
                        if (i10 != 0) {
                            function7 = null;
                        } else {
                            function7 = function3;
                        }
                        if ((i2 & 256) != 0) {
                            jM11533getMainActiveControl0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                            i3 &= -234881025;
                        } else {
                            jM11533getMainActiveControl0d7_KjU = j;
                        }
                        if ((i2 & 512) != 0) {
                            String str11112 = str4;
                            i12 = i3 & (-1879048193);
                            str7 = str11112;
                            j5 = jM11533getMainActiveControl0d7_KjU;
                            function8 = function7;
                            str8 = str3;
                            jM11533getMainActiveControl0d7_KjU2 = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                        } else {
                            String str11113 = str4;
                            i12 = i3;
                            str7 = str11113;
                            j5 = jM11533getMainActiveControl0d7_KjU;
                            function8 = function7;
                            str8 = str3;
                            jM11533getMainActiveControl0d7_KjU2 = j2;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(962660873, i12, -1, "com.box.android.base.compose.dialog.BoxDialog (BoxDialog.kt:49)");
                    }
                    if (button instanceof DialogButtonsConfig.PositiveButton) {
                        pair = new Pair(((DialogButtonsConfig.PositiveButton) button).getButton(), null);
                    } else if (button instanceof DialogButtonsConfig.NegativeButton) {
                        pair = new Pair(null, ((DialogButtonsConfig.NegativeButton) button).getButton());
                    } else {
                        if (!(button instanceof DialogButtonsConfig.PositiveAndNegativeButtons)) {
                            throw new NoWhenBranchMatchedException();
                        }
                        DialogButtonsConfig.PositiveAndNegativeButtons positiveAndNegativeButtons7 = (DialogButtonsConfig.PositiveAndNegativeButtons) button;
                        pair = new Pair(positiveAndNegativeButtons7.getPositiveButton(), positiveAndNegativeButtons7.getNegativeButton());
                    }
                    final ButtonItem.TextButtonItem textButtonItem8 = (ButtonItem.TextButtonItem) pair.component1();
                    textButtonItem = (ButtonItem.TextButtonItem) pair.component2();
                    if (str8 != null) {
                        modifierDialogSemantics = TestTagKt.testTag(companion, str8);
                    } else {
                        modifierDialogSemantics = companion;
                    }
                    if (str7 != null) {
                        modifierDialogSemantics = ComposeUtilsKt.dialogSemantics(modifierDialogSemantics, str7);
                    }
                    if (function0 != null) {
                        onClick = function0;
                    } else if (textButtonItem != null) {
                        onClick = textButtonItem.getOnClick();
                    } else {
                        onClick = null;
                    }
                    if (onClick == null) {
                        composerStartRestartGroup.startReplaceGroup(1134495670);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "60@3049L3");
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1699164620, "CC(remember):BoxDialog.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new Function0() { // from class: com.box.android.base.compose.dialog.BoxDialogKt$$ExternalSyntheticLambda1
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return Unit.INSTANCE;
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        onClick = (Function0) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    } else {
                        composerStartRestartGroup.startReplaceGroup(1699163163);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    long jM11516getDialogContainer0d7_KjU7 = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11516getDialogContainer0d7_KjU();
                    long jM11500getAppPrimary0d7_KjU7 = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11500getAppPrimary0d7_KjU();
                    long jM11526getItemInfoTextSecondary0d7_KjU7 = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11526getItemInfoTextSecondary0d7_KjU();
                    if (textButtonItem == null) {
                        composerStartRestartGroup.startReplaceGroup(1134801081);
                        composerStartRestartGroup.endReplaceGroup();
                        composableLambdaRememberComposableLambda = null;
                        z2 = true;
                    } else {
                        composerStartRestartGroup.startReplaceGroup(1134801082);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "*68@3360L451");
                        z2 = true;
                        composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-1707763176, true, new Function2() { // from class: com.box.android.base.compose.dialog.BoxDialogKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return BoxDialogKt.BoxDialog_0S3VyRs$lambda$3$0(textButtonItem, jM11533getMainActiveControl0d7_KjU2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                        composerStartRestartGroup.endReplaceGroup();
                    }
                    ComposableLambda composableLambdaRememberComposableLambda8 = ComposableLambdaKt.rememberComposableLambda(-825495871, z2, new Function2() { // from class: com.box.android.base.compose.dialog.BoxDialogKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return BoxDialogKt.BoxDialog_0S3VyRs$lambda$4(textButtonItem8, j5, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54);
                    int i116 = i12 >> 6;
                    int i117 = (i116 & 458752) | (57344 & i116) | 48 | ((i12 << 15) & 3670016);
                    long j18 = j5;
                    long j19 = jM11533getMainActiveControl0d7_KjU2;
                    composer2 = composerStartRestartGroup;
                    Function2<? super Composer, ? super Integer, Unit> function111 = function4;
                    String str11114 = str8;
                    String str11115 = str7;
                    Function2<? super Composer, ? super Integer, Unit> function112 = function8;
                    AndroidAlertDialog_androidKt.m2731AlertDialogOix01E0(onClick, composableLambdaRememberComposableLambda8, modifierDialogSemantics, composableLambdaRememberComposableLambda, function111, function112, content, null, jM11516getDialogContainer0d7_KjU7, 0L, jM11500getAppPrimary0d7_KjU7, jM11526getItemInfoTextSecondary0d7_KjU7, 0.0f, null, composer2, i117, 0, 12928);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = companion;
                    str5 = str11114;
                    function5 = function112;
                    j4 = j19;
                    j3 = j18;
                    function6 = function111;
                    str6 = str11115;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    function5 = function3;
                    modifier3 = modifier2;
                    str5 = str3;
                    str6 = str4;
                    function6 = function4;
                    j3 = j;
                    j4 = j2;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.dialog.BoxDialogKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return BoxDialogKt.BoxDialog_0S3VyRs$lambda$5(function0, content, button, modifier3, str5, str6, function6, function5, j3, j4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            str4 = str2;
            i8 = i2 & 64;
            if (i8 != 0) {
                if ((1572864 & i) == 0) {
                    function4 = function2;
                    if (composerStartRestartGroup.changedInstance(function4)) {
                        i9 = 1048576;
                    } else {
                        i9 = 524288;
                    }
                    i3 |= i9;
                }
                i10 = i2 & 128;
                if (i10 != 0) {
                    i3 |= 12582912;
                } else if ((i & 12582912) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i11 = 8388608;
                    } else {
                        i11 = 4194304;
                    }
                    i3 |= i11;
                }
                if ((i & 100663296) != 0) {
                    i3 |= ((i2 & 256) == 0 || !composerStartRestartGroup.changed(j)) ? 33554432 : 67108864;
                }
                if ((i & 805306368) != 0) {
                    i3 |= ((i2 & 512) == 0 || !composerStartRestartGroup.changed(j2)) ? 268435456 : C.BUFFER_FLAG_LAST_SAMPLE;
                }
                if ((i3 & 306783379) != 306783378) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "47@2334L6,48@2402L6");
                    if ((i & 1) != 0) {
                        if (i13 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i4 != 0) {
                            str3 = null;
                        }
                        if (i6 != 0) {
                            str4 = null;
                        }
                        if (i8 != 0) {
                            function4 = null;
                        }
                        if (i10 != 0) {
                            function7 = null;
                        } else {
                            function7 = function3;
                        }
                        if ((i2 & 256) != 0) {
                            jM11533getMainActiveControl0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                            i3 &= -234881025;
                        } else {
                            jM11533getMainActiveControl0d7_KjU = j;
                        }
                        if ((i2 & 512) != 0) {
                            String str11116 = str4;
                            i12 = i3 & (-1879048193);
                            str7 = str11116;
                            j5 = jM11533getMainActiveControl0d7_KjU;
                            function8 = function7;
                            str8 = str3;
                            jM11533getMainActiveControl0d7_KjU2 = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                        } else {
                            String str11117 = str4;
                            i12 = i3;
                            str7 = str11117;
                            j5 = jM11533getMainActiveControl0d7_KjU;
                            function8 = function7;
                            str8 = str3;
                            jM11533getMainActiveControl0d7_KjU2 = j2;
                        }
                    } else {
                        if (i13 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i4 != 0) {
                            str3 = null;
                        }
                        if (i6 != 0) {
                            str4 = null;
                        }
                        if (i8 != 0) {
                            function4 = null;
                        }
                        if (i10 != 0) {
                            function7 = null;
                        } else {
                            function7 = function3;
                        }
                        if ((i2 & 256) != 0) {
                            jM11533getMainActiveControl0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                            i3 &= -234881025;
                        } else {
                            jM11533getMainActiveControl0d7_KjU = j;
                        }
                        if ((i2 & 512) != 0) {
                            String str11118 = str4;
                            i12 = i3 & (-1879048193);
                            str7 = str11118;
                            j5 = jM11533getMainActiveControl0d7_KjU;
                            function8 = function7;
                            str8 = str3;
                            jM11533getMainActiveControl0d7_KjU2 = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                        } else {
                            String str11119 = str4;
                            i12 = i3;
                            str7 = str11119;
                            j5 = jM11533getMainActiveControl0d7_KjU;
                            function8 = function7;
                            str8 = str3;
                            jM11533getMainActiveControl0d7_KjU2 = j2;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(962660873, i12, -1, "com.box.android.base.compose.dialog.BoxDialog (BoxDialog.kt:49)");
                    }
                    if (button instanceof DialogButtonsConfig.PositiveButton) {
                        pair = new Pair(((DialogButtonsConfig.PositiveButton) button).getButton(), null);
                    } else if (button instanceof DialogButtonsConfig.NegativeButton) {
                        pair = new Pair(null, ((DialogButtonsConfig.NegativeButton) button).getButton());
                    } else {
                        if (!(button instanceof DialogButtonsConfig.PositiveAndNegativeButtons)) {
                            throw new NoWhenBranchMatchedException();
                        }
                        DialogButtonsConfig.PositiveAndNegativeButtons positiveAndNegativeButtons8 = (DialogButtonsConfig.PositiveAndNegativeButtons) button;
                        pair = new Pair(positiveAndNegativeButtons8.getPositiveButton(), positiveAndNegativeButtons8.getNegativeButton());
                    }
                    final ButtonItem.TextButtonItem textButtonItem9 = (ButtonItem.TextButtonItem) pair.component1();
                    textButtonItem = (ButtonItem.TextButtonItem) pair.component2();
                    if (str8 != null) {
                        modifierDialogSemantics = TestTagKt.testTag(companion, str8);
                    } else {
                        modifierDialogSemantics = companion;
                    }
                    if (str7 != null) {
                        modifierDialogSemantics = ComposeUtilsKt.dialogSemantics(modifierDialogSemantics, str7);
                    }
                    if (function0 != null) {
                        onClick = function0;
                    } else if (textButtonItem != null) {
                        onClick = textButtonItem.getOnClick();
                    } else {
                        onClick = null;
                    }
                    if (onClick == null) {
                        composerStartRestartGroup.startReplaceGroup(1134495670);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "60@3049L3");
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1699164620, "CC(remember):BoxDialog.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new Function0() { // from class: com.box.android.base.compose.dialog.BoxDialogKt$$ExternalSyntheticLambda1
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return Unit.INSTANCE;
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        onClick = (Function0) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    } else {
                        composerStartRestartGroup.startReplaceGroup(1699163163);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    long jM11516getDialogContainer0d7_KjU8 = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11516getDialogContainer0d7_KjU();
                    long jM11500getAppPrimary0d7_KjU8 = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11500getAppPrimary0d7_KjU();
                    long jM11526getItemInfoTextSecondary0d7_KjU8 = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11526getItemInfoTextSecondary0d7_KjU();
                    if (textButtonItem == null) {
                        composerStartRestartGroup.startReplaceGroup(1134801081);
                        composerStartRestartGroup.endReplaceGroup();
                        composableLambdaRememberComposableLambda = null;
                        z2 = true;
                    } else {
                        composerStartRestartGroup.startReplaceGroup(1134801082);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "*68@3360L451");
                        z2 = true;
                        composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-1707763176, true, new Function2() { // from class: com.box.android.base.compose.dialog.BoxDialogKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return BoxDialogKt.BoxDialog_0S3VyRs$lambda$3$0(textButtonItem, jM11533getMainActiveControl0d7_KjU2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                        composerStartRestartGroup.endReplaceGroup();
                    }
                    ComposableLambda composableLambdaRememberComposableLambda9 = ComposableLambdaKt.rememberComposableLambda(-825495871, z2, new Function2() { // from class: com.box.android.base.compose.dialog.BoxDialogKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return BoxDialogKt.BoxDialog_0S3VyRs$lambda$4(textButtonItem9, j5, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54);
                    int i118 = i12 >> 6;
                    int i119 = (i118 & 458752) | (57344 & i118) | 48 | ((i12 << 15) & 3670016);
                    long j110 = j5;
                    long j111 = jM11533getMainActiveControl0d7_KjU2;
                    composer2 = composerStartRestartGroup;
                    Function2<? super Composer, ? super Integer, Unit> function113 = function4;
                    String str111110 = str8;
                    String str111111 = str7;
                    Function2<? super Composer, ? super Integer, Unit> function114 = function8;
                    AndroidAlertDialog_androidKt.m2731AlertDialogOix01E0(onClick, composableLambdaRememberComposableLambda9, modifierDialogSemantics, composableLambdaRememberComposableLambda, function113, function114, content, null, jM11516getDialogContainer0d7_KjU8, 0L, jM11500getAppPrimary0d7_KjU8, jM11526getItemInfoTextSecondary0d7_KjU8, 0.0f, null, composer2, i119, 0, 12928);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = companion;
                    str5 = str111110;
                    function5 = function114;
                    j4 = j111;
                    j3 = j110;
                    function6 = function113;
                    str6 = str111111;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    function5 = function3;
                    modifier3 = modifier2;
                    str5 = str3;
                    str6 = str4;
                    function6 = function4;
                    j3 = j;
                    j4 = j2;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.dialog.BoxDialogKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return BoxDialogKt.BoxDialog_0S3VyRs$lambda$5(function0, content, button, modifier3, str5, str6, function6, function5, j3, j4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 1572864;
            function4 = function2;
            i10 = i2 & 128;
            if (i10 != 0) {
                i3 |= 12582912;
            } else if ((i & 12582912) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i11 = 8388608;
                } else {
                    i11 = 4194304;
                }
                i3 |= i11;
            }
            if ((i & 100663296) != 0) {
                i3 |= ((i2 & 256) == 0 || !composerStartRestartGroup.changed(j)) ? 33554432 : 67108864;
            }
            if ((i & 805306368) != 0) {
                i3 |= ((i2 & 512) == 0 || !composerStartRestartGroup.changed(j2)) ? 268435456 : C.BUFFER_FLAG_LAST_SAMPLE;
            }
            if ((i3 & 306783379) != 306783378) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "47@2334L6,48@2402L6");
                if ((i & 1) != 0) {
                    if (i13 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i4 != 0) {
                        str3 = null;
                    }
                    if (i6 != 0) {
                        str4 = null;
                    }
                    if (i8 != 0) {
                        function4 = null;
                    }
                    if (i10 != 0) {
                        function7 = null;
                    } else {
                        function7 = function3;
                    }
                    if ((i2 & 256) != 0) {
                        jM11533getMainActiveControl0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                        i3 &= -234881025;
                    } else {
                        jM11533getMainActiveControl0d7_KjU = j;
                    }
                    if ((i2 & 512) != 0) {
                        String str111112 = str4;
                        i12 = i3 & (-1879048193);
                        str7 = str111112;
                        j5 = jM11533getMainActiveControl0d7_KjU;
                        function8 = function7;
                        str8 = str3;
                        jM11533getMainActiveControl0d7_KjU2 = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                    } else {
                        String str111113 = str4;
                        i12 = i3;
                        str7 = str111113;
                        j5 = jM11533getMainActiveControl0d7_KjU;
                        function8 = function7;
                        str8 = str3;
                        jM11533getMainActiveControl0d7_KjU2 = j2;
                    }
                } else {
                    if (i13 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i4 != 0) {
                        str3 = null;
                    }
                    if (i6 != 0) {
                        str4 = null;
                    }
                    if (i8 != 0) {
                        function4 = null;
                    }
                    if (i10 != 0) {
                        function7 = null;
                    } else {
                        function7 = function3;
                    }
                    if ((i2 & 256) != 0) {
                        jM11533getMainActiveControl0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                        i3 &= -234881025;
                    } else {
                        jM11533getMainActiveControl0d7_KjU = j;
                    }
                    if ((i2 & 512) != 0) {
                        String str111114 = str4;
                        i12 = i3 & (-1879048193);
                        str7 = str111114;
                        j5 = jM11533getMainActiveControl0d7_KjU;
                        function8 = function7;
                        str8 = str3;
                        jM11533getMainActiveControl0d7_KjU2 = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                    } else {
                        String str111115 = str4;
                        i12 = i3;
                        str7 = str111115;
                        j5 = jM11533getMainActiveControl0d7_KjU;
                        function8 = function7;
                        str8 = str3;
                        jM11533getMainActiveControl0d7_KjU2 = j2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(962660873, i12, -1, "com.box.android.base.compose.dialog.BoxDialog (BoxDialog.kt:49)");
                }
                if (button instanceof DialogButtonsConfig.PositiveButton) {
                    pair = new Pair(((DialogButtonsConfig.PositiveButton) button).getButton(), null);
                } else if (button instanceof DialogButtonsConfig.NegativeButton) {
                    pair = new Pair(null, ((DialogButtonsConfig.NegativeButton) button).getButton());
                } else {
                    if (!(button instanceof DialogButtonsConfig.PositiveAndNegativeButtons)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    DialogButtonsConfig.PositiveAndNegativeButtons positiveAndNegativeButtons9 = (DialogButtonsConfig.PositiveAndNegativeButtons) button;
                    pair = new Pair(positiveAndNegativeButtons9.getPositiveButton(), positiveAndNegativeButtons9.getNegativeButton());
                }
                final ButtonItem.TextButtonItem textButtonItem10 = (ButtonItem.TextButtonItem) pair.component1();
                textButtonItem = (ButtonItem.TextButtonItem) pair.component2();
                if (str8 != null) {
                    modifierDialogSemantics = TestTagKt.testTag(companion, str8);
                } else {
                    modifierDialogSemantics = companion;
                }
                if (str7 != null) {
                    modifierDialogSemantics = ComposeUtilsKt.dialogSemantics(modifierDialogSemantics, str7);
                }
                if (function0 != null) {
                    onClick = function0;
                } else if (textButtonItem != null) {
                    onClick = textButtonItem.getOnClick();
                } else {
                    onClick = null;
                }
                if (onClick == null) {
                    composerStartRestartGroup.startReplaceGroup(1134495670);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "60@3049L3");
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1699164620, "CC(remember):BoxDialog.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new Function0() { // from class: com.box.android.base.compose.dialog.BoxDialogKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Unit.INSTANCE;
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    onClick = (Function0) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                } else {
                    composerStartRestartGroup.startReplaceGroup(1699163163);
                }
                composerStartRestartGroup.endReplaceGroup();
                long jM11516getDialogContainer0d7_KjU9 = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11516getDialogContainer0d7_KjU();
                long jM11500getAppPrimary0d7_KjU9 = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11500getAppPrimary0d7_KjU();
                long jM11526getItemInfoTextSecondary0d7_KjU9 = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11526getItemInfoTextSecondary0d7_KjU();
                if (textButtonItem == null) {
                    composerStartRestartGroup.startReplaceGroup(1134801081);
                    composerStartRestartGroup.endReplaceGroup();
                    composableLambdaRememberComposableLambda = null;
                    z2 = true;
                } else {
                    composerStartRestartGroup.startReplaceGroup(1134801082);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "*68@3360L451");
                    z2 = true;
                    composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-1707763176, true, new Function2() { // from class: com.box.android.base.compose.dialog.BoxDialogKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return BoxDialogKt.BoxDialog_0S3VyRs$lambda$3$0(textButtonItem, jM11533getMainActiveControl0d7_KjU2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54);
                    composerStartRestartGroup.endReplaceGroup();
                }
                ComposableLambda composableLambdaRememberComposableLambda10 = ComposableLambdaKt.rememberComposableLambda(-825495871, z2, new Function2() { // from class: com.box.android.base.compose.dialog.BoxDialogKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return BoxDialogKt.BoxDialog_0S3VyRs$lambda$4(textButtonItem10, j5, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54);
                int i1110 = i12 >> 6;
                int i1111 = (i1110 & 458752) | (57344 & i1110) | 48 | ((i12 << 15) & 3670016);
                long j112 = j5;
                long j113 = jM11533getMainActiveControl0d7_KjU2;
                composer2 = composerStartRestartGroup;
                Function2<? super Composer, ? super Integer, Unit> function115 = function4;
                String str111116 = str8;
                String str111117 = str7;
                Function2<? super Composer, ? super Integer, Unit> function116 = function8;
                AndroidAlertDialog_androidKt.m2731AlertDialogOix01E0(onClick, composableLambdaRememberComposableLambda10, modifierDialogSemantics, composableLambdaRememberComposableLambda, function115, function116, content, null, jM11516getDialogContainer0d7_KjU9, 0L, jM11500getAppPrimary0d7_KjU9, jM11526getItemInfoTextSecondary0d7_KjU9, 0.0f, null, composer2, i1111, 0, 12928);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = companion;
                str5 = str111116;
                function5 = function116;
                j4 = j113;
                j3 = j112;
                function6 = function115;
                str6 = str111117;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                function5 = function3;
                modifier3 = modifier2;
                str5 = str3;
                str6 = str4;
                function6 = function4;
                j3 = j;
                j4 = j2;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.dialog.BoxDialogKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return BoxDialogKt.BoxDialog_0S3VyRs$lambda$5(function0, content, button, modifier3, str5, str6, function6, function5, j3, j4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 3072;
        modifier2 = modifier;
        i4 = i2 & 16;
        if (i4 != 0) {
            if ((i & 24576) == 0) {
                str3 = str;
                if (composerStartRestartGroup.changed(str3)) {
                    i5 = 16384;
                } else {
                    i5 = 8192;
                }
                i3 |= i5;
            }
            i6 = i2 & 32;
            if (i6 != 0) {
                if ((196608 & i) == 0) {
                    str4 = str2;
                    if (composerStartRestartGroup.changed(str4)) {
                        i7 = 131072;
                    } else {
                        i7 = 65536;
                    }
                    i3 |= i7;
                }
                i8 = i2 & 64;
                if (i8 != 0) {
                    if ((1572864 & i) == 0) {
                        function4 = function2;
                        if (composerStartRestartGroup.changedInstance(function4)) {
                            i9 = 1048576;
                        } else {
                            i9 = 524288;
                        }
                        i3 |= i9;
                    }
                    i10 = i2 & 128;
                    if (i10 != 0) {
                        i3 |= 12582912;
                    } else if ((i & 12582912) == 0) {
                        if (composerStartRestartGroup.changedInstance(function3)) {
                            i11 = 8388608;
                        } else {
                            i11 = 4194304;
                        }
                        i3 |= i11;
                    }
                    if ((i & 100663296) != 0) {
                        i3 |= ((i2 & 256) == 0 || !composerStartRestartGroup.changed(j)) ? 33554432 : 67108864;
                    }
                    if ((i & 805306368) != 0) {
                        i3 |= ((i2 & 512) == 0 || !composerStartRestartGroup.changed(j2)) ? 268435456 : C.BUFFER_FLAG_LAST_SAMPLE;
                    }
                    if ((i3 & 306783379) != 306783378) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "47@2334L6,48@2402L6");
                        if ((i & 1) != 0) {
                            if (i13 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier2;
                            }
                            if (i4 != 0) {
                                str3 = null;
                            }
                            if (i6 != 0) {
                                str4 = null;
                            }
                            if (i8 != 0) {
                                function4 = null;
                            }
                            if (i10 != 0) {
                                function7 = null;
                            } else {
                                function7 = function3;
                            }
                            if ((i2 & 256) != 0) {
                                jM11533getMainActiveControl0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                                i3 &= -234881025;
                            } else {
                                jM11533getMainActiveControl0d7_KjU = j;
                            }
                            if ((i2 & 512) != 0) {
                                String str111118 = str4;
                                i12 = i3 & (-1879048193);
                                str7 = str111118;
                                j5 = jM11533getMainActiveControl0d7_KjU;
                                function8 = function7;
                                str8 = str3;
                                jM11533getMainActiveControl0d7_KjU2 = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                            } else {
                                String str111119 = str4;
                                i12 = i3;
                                str7 = str111119;
                                j5 = jM11533getMainActiveControl0d7_KjU;
                                function8 = function7;
                                str8 = str3;
                                jM11533getMainActiveControl0d7_KjU2 = j2;
                            }
                        } else {
                            if (i13 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier2;
                            }
                            if (i4 != 0) {
                                str3 = null;
                            }
                            if (i6 != 0) {
                                str4 = null;
                            }
                            if (i8 != 0) {
                                function4 = null;
                            }
                            if (i10 != 0) {
                                function7 = null;
                            } else {
                                function7 = function3;
                            }
                            if ((i2 & 256) != 0) {
                                jM11533getMainActiveControl0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                                i3 &= -234881025;
                            } else {
                                jM11533getMainActiveControl0d7_KjU = j;
                            }
                            if ((i2 & 512) != 0) {
                                String str1111110 = str4;
                                i12 = i3 & (-1879048193);
                                str7 = str1111110;
                                j5 = jM11533getMainActiveControl0d7_KjU;
                                function8 = function7;
                                str8 = str3;
                                jM11533getMainActiveControl0d7_KjU2 = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                            } else {
                                String str1111111 = str4;
                                i12 = i3;
                                str7 = str1111111;
                                j5 = jM11533getMainActiveControl0d7_KjU;
                                function8 = function7;
                                str8 = str3;
                                jM11533getMainActiveControl0d7_KjU2 = j2;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(962660873, i12, -1, "com.box.android.base.compose.dialog.BoxDialog (BoxDialog.kt:49)");
                        }
                        if (button instanceof DialogButtonsConfig.PositiveButton) {
                            pair = new Pair(((DialogButtonsConfig.PositiveButton) button).getButton(), null);
                        } else if (button instanceof DialogButtonsConfig.NegativeButton) {
                            pair = new Pair(null, ((DialogButtonsConfig.NegativeButton) button).getButton());
                        } else {
                            if (!(button instanceof DialogButtonsConfig.PositiveAndNegativeButtons)) {
                                throw new NoWhenBranchMatchedException();
                            }
                            DialogButtonsConfig.PositiveAndNegativeButtons positiveAndNegativeButtons10 = (DialogButtonsConfig.PositiveAndNegativeButtons) button;
                            pair = new Pair(positiveAndNegativeButtons10.getPositiveButton(), positiveAndNegativeButtons10.getNegativeButton());
                        }
                        final ButtonItem.TextButtonItem textButtonItem11 = (ButtonItem.TextButtonItem) pair.component1();
                        textButtonItem = (ButtonItem.TextButtonItem) pair.component2();
                        if (str8 != null) {
                            modifierDialogSemantics = TestTagKt.testTag(companion, str8);
                        } else {
                            modifierDialogSemantics = companion;
                        }
                        if (str7 != null) {
                            modifierDialogSemantics = ComposeUtilsKt.dialogSemantics(modifierDialogSemantics, str7);
                        }
                        if (function0 != null) {
                            onClick = function0;
                        } else if (textButtonItem != null) {
                            onClick = textButtonItem.getOnClick();
                        } else {
                            onClick = null;
                        }
                        if (onClick == null) {
                            composerStartRestartGroup.startReplaceGroup(1134495670);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "60@3049L3");
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1699164620, "CC(remember):BoxDialog.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = new Function0() { // from class: com.box.android.base.compose.dialog.BoxDialogKt$$ExternalSyntheticLambda1
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return Unit.INSTANCE;
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            onClick = (Function0) objRememberedValue;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        } else {
                            composerStartRestartGroup.startReplaceGroup(1699163163);
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        long jM11516getDialogContainer0d7_KjU10 = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11516getDialogContainer0d7_KjU();
                        long jM11500getAppPrimary0d7_KjU10 = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11500getAppPrimary0d7_KjU();
                        long jM11526getItemInfoTextSecondary0d7_KjU10 = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11526getItemInfoTextSecondary0d7_KjU();
                        if (textButtonItem == null) {
                            composerStartRestartGroup.startReplaceGroup(1134801081);
                            composerStartRestartGroup.endReplaceGroup();
                            composableLambdaRememberComposableLambda = null;
                            z2 = true;
                        } else {
                            composerStartRestartGroup.startReplaceGroup(1134801082);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "*68@3360L451");
                            z2 = true;
                            composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-1707763176, true, new Function2() { // from class: com.box.android.base.compose.dialog.BoxDialogKt$$ExternalSyntheticLambda2
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return BoxDialogKt.BoxDialog_0S3VyRs$lambda$3$0(textButtonItem, jM11533getMainActiveControl0d7_KjU2, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composerStartRestartGroup, 54);
                            composerStartRestartGroup.endReplaceGroup();
                        }
                        ComposableLambda composableLambdaRememberComposableLambda11 = ComposableLambdaKt.rememberComposableLambda(-825495871, z2, new Function2() { // from class: com.box.android.base.compose.dialog.BoxDialogKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return BoxDialogKt.BoxDialog_0S3VyRs$lambda$4(textButtonItem11, j5, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                        int i1112 = i12 >> 6;
                        int i1113 = (i1112 & 458752) | (57344 & i1112) | 48 | ((i12 << 15) & 3670016);
                        long j114 = j5;
                        long j115 = jM11533getMainActiveControl0d7_KjU2;
                        composer2 = composerStartRestartGroup;
                        Function2<? super Composer, ? super Integer, Unit> function117 = function4;
                        String str1111112 = str8;
                        String str1111113 = str7;
                        Function2<? super Composer, ? super Integer, Unit> function118 = function8;
                        AndroidAlertDialog_androidKt.m2731AlertDialogOix01E0(onClick, composableLambdaRememberComposableLambda11, modifierDialogSemantics, composableLambdaRememberComposableLambda, function117, function118, content, null, jM11516getDialogContainer0d7_KjU10, 0L, jM11500getAppPrimary0d7_KjU10, jM11526getItemInfoTextSecondary0d7_KjU10, 0.0f, null, composer2, i1113, 0, 12928);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = companion;
                        str5 = str1111112;
                        function5 = function118;
                        j4 = j115;
                        j3 = j114;
                        function6 = function117;
                        str6 = str1111113;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        function5 = function3;
                        modifier3 = modifier2;
                        str5 = str3;
                        str6 = str4;
                        function6 = function4;
                        j3 = j;
                        j4 = j2;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.dialog.BoxDialogKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return BoxDialogKt.BoxDialog_0S3VyRs$lambda$5(function0, content, button, modifier3, str5, str6, function6, function5, j3, j4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= 1572864;
                function4 = function2;
                i10 = i2 & 128;
                if (i10 != 0) {
                    i3 |= 12582912;
                } else if ((i & 12582912) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i11 = 8388608;
                    } else {
                        i11 = 4194304;
                    }
                    i3 |= i11;
                }
                if ((i & 100663296) != 0) {
                    i3 |= ((i2 & 256) == 0 || !composerStartRestartGroup.changed(j)) ? 33554432 : 67108864;
                }
                if ((i & 805306368) != 0) {
                    i3 |= ((i2 & 512) == 0 || !composerStartRestartGroup.changed(j2)) ? 268435456 : C.BUFFER_FLAG_LAST_SAMPLE;
                }
                if ((i3 & 306783379) != 306783378) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "47@2334L6,48@2402L6");
                    if ((i & 1) != 0) {
                        if (i13 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i4 != 0) {
                            str3 = null;
                        }
                        if (i6 != 0) {
                            str4 = null;
                        }
                        if (i8 != 0) {
                            function4 = null;
                        }
                        if (i10 != 0) {
                            function7 = null;
                        } else {
                            function7 = function3;
                        }
                        if ((i2 & 256) != 0) {
                            jM11533getMainActiveControl0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                            i3 &= -234881025;
                        } else {
                            jM11533getMainActiveControl0d7_KjU = j;
                        }
                        if ((i2 & 512) != 0) {
                            String str1111114 = str4;
                            i12 = i3 & (-1879048193);
                            str7 = str1111114;
                            j5 = jM11533getMainActiveControl0d7_KjU;
                            function8 = function7;
                            str8 = str3;
                            jM11533getMainActiveControl0d7_KjU2 = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                        } else {
                            String str1111115 = str4;
                            i12 = i3;
                            str7 = str1111115;
                            j5 = jM11533getMainActiveControl0d7_KjU;
                            function8 = function7;
                            str8 = str3;
                            jM11533getMainActiveControl0d7_KjU2 = j2;
                        }
                    } else {
                        if (i13 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i4 != 0) {
                            str3 = null;
                        }
                        if (i6 != 0) {
                            str4 = null;
                        }
                        if (i8 != 0) {
                            function4 = null;
                        }
                        if (i10 != 0) {
                            function7 = null;
                        } else {
                            function7 = function3;
                        }
                        if ((i2 & 256) != 0) {
                            jM11533getMainActiveControl0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                            i3 &= -234881025;
                        } else {
                            jM11533getMainActiveControl0d7_KjU = j;
                        }
                        if ((i2 & 512) != 0) {
                            String str1111116 = str4;
                            i12 = i3 & (-1879048193);
                            str7 = str1111116;
                            j5 = jM11533getMainActiveControl0d7_KjU;
                            function8 = function7;
                            str8 = str3;
                            jM11533getMainActiveControl0d7_KjU2 = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                        } else {
                            String str1111117 = str4;
                            i12 = i3;
                            str7 = str1111117;
                            j5 = jM11533getMainActiveControl0d7_KjU;
                            function8 = function7;
                            str8 = str3;
                            jM11533getMainActiveControl0d7_KjU2 = j2;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(962660873, i12, -1, "com.box.android.base.compose.dialog.BoxDialog (BoxDialog.kt:49)");
                    }
                    if (button instanceof DialogButtonsConfig.PositiveButton) {
                        pair = new Pair(((DialogButtonsConfig.PositiveButton) button).getButton(), null);
                    } else if (button instanceof DialogButtonsConfig.NegativeButton) {
                        pair = new Pair(null, ((DialogButtonsConfig.NegativeButton) button).getButton());
                    } else {
                        if (!(button instanceof DialogButtonsConfig.PositiveAndNegativeButtons)) {
                            throw new NoWhenBranchMatchedException();
                        }
                        DialogButtonsConfig.PositiveAndNegativeButtons positiveAndNegativeButtons11 = (DialogButtonsConfig.PositiveAndNegativeButtons) button;
                        pair = new Pair(positiveAndNegativeButtons11.getPositiveButton(), positiveAndNegativeButtons11.getNegativeButton());
                    }
                    final ButtonItem.TextButtonItem textButtonItem12 = (ButtonItem.TextButtonItem) pair.component1();
                    textButtonItem = (ButtonItem.TextButtonItem) pair.component2();
                    if (str8 != null) {
                        modifierDialogSemantics = TestTagKt.testTag(companion, str8);
                    } else {
                        modifierDialogSemantics = companion;
                    }
                    if (str7 != null) {
                        modifierDialogSemantics = ComposeUtilsKt.dialogSemantics(modifierDialogSemantics, str7);
                    }
                    if (function0 != null) {
                        onClick = function0;
                    } else if (textButtonItem != null) {
                        onClick = textButtonItem.getOnClick();
                    } else {
                        onClick = null;
                    }
                    if (onClick == null) {
                        composerStartRestartGroup.startReplaceGroup(1134495670);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "60@3049L3");
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1699164620, "CC(remember):BoxDialog.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new Function0() { // from class: com.box.android.base.compose.dialog.BoxDialogKt$$ExternalSyntheticLambda1
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return Unit.INSTANCE;
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        onClick = (Function0) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    } else {
                        composerStartRestartGroup.startReplaceGroup(1699163163);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    long jM11516getDialogContainer0d7_KjU11 = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11516getDialogContainer0d7_KjU();
                    long jM11500getAppPrimary0d7_KjU11 = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11500getAppPrimary0d7_KjU();
                    long jM11526getItemInfoTextSecondary0d7_KjU11 = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11526getItemInfoTextSecondary0d7_KjU();
                    if (textButtonItem == null) {
                        composerStartRestartGroup.startReplaceGroup(1134801081);
                        composerStartRestartGroup.endReplaceGroup();
                        composableLambdaRememberComposableLambda = null;
                        z2 = true;
                    } else {
                        composerStartRestartGroup.startReplaceGroup(1134801082);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "*68@3360L451");
                        z2 = true;
                        composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-1707763176, true, new Function2() { // from class: com.box.android.base.compose.dialog.BoxDialogKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return BoxDialogKt.BoxDialog_0S3VyRs$lambda$3$0(textButtonItem, jM11533getMainActiveControl0d7_KjU2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                        composerStartRestartGroup.endReplaceGroup();
                    }
                    ComposableLambda composableLambdaRememberComposableLambda12 = ComposableLambdaKt.rememberComposableLambda(-825495871, z2, new Function2() { // from class: com.box.android.base.compose.dialog.BoxDialogKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return BoxDialogKt.BoxDialog_0S3VyRs$lambda$4(textButtonItem12, j5, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54);
                    int i1114 = i12 >> 6;
                    int i1115 = (i1114 & 458752) | (57344 & i1114) | 48 | ((i12 << 15) & 3670016);
                    long j116 = j5;
                    long j117 = jM11533getMainActiveControl0d7_KjU2;
                    composer2 = composerStartRestartGroup;
                    Function2<? super Composer, ? super Integer, Unit> function119 = function4;
                    String str1111118 = str8;
                    String str1111119 = str7;
                    Function2<? super Composer, ? super Integer, Unit> function1110 = function8;
                    AndroidAlertDialog_androidKt.m2731AlertDialogOix01E0(onClick, composableLambdaRememberComposableLambda12, modifierDialogSemantics, composableLambdaRememberComposableLambda, function119, function1110, content, null, jM11516getDialogContainer0d7_KjU11, 0L, jM11500getAppPrimary0d7_KjU11, jM11526getItemInfoTextSecondary0d7_KjU11, 0.0f, null, composer2, i1115, 0, 12928);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = companion;
                    str5 = str1111118;
                    function5 = function1110;
                    j4 = j117;
                    j3 = j116;
                    function6 = function119;
                    str6 = str1111119;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    function5 = function3;
                    modifier3 = modifier2;
                    str5 = str3;
                    str6 = str4;
                    function6 = function4;
                    j3 = j;
                    j4 = j2;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.dialog.BoxDialogKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return BoxDialogKt.BoxDialog_0S3VyRs$lambda$5(function0, content, button, modifier3, str5, str6, function6, function5, j3, j4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            str4 = str2;
            i8 = i2 & 64;
            if (i8 != 0) {
                if ((1572864 & i) == 0) {
                    function4 = function2;
                    if (composerStartRestartGroup.changedInstance(function4)) {
                        i9 = 1048576;
                    } else {
                        i9 = 524288;
                    }
                    i3 |= i9;
                }
                i10 = i2 & 128;
                if (i10 != 0) {
                    i3 |= 12582912;
                } else if ((i & 12582912) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i11 = 8388608;
                    } else {
                        i11 = 4194304;
                    }
                    i3 |= i11;
                }
                if ((i & 100663296) != 0) {
                    i3 |= ((i2 & 256) == 0 || !composerStartRestartGroup.changed(j)) ? 33554432 : 67108864;
                }
                if ((i & 805306368) != 0) {
                    i3 |= ((i2 & 512) == 0 || !composerStartRestartGroup.changed(j2)) ? 268435456 : C.BUFFER_FLAG_LAST_SAMPLE;
                }
                if ((i3 & 306783379) != 306783378) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "47@2334L6,48@2402L6");
                    if ((i & 1) != 0) {
                        if (i13 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i4 != 0) {
                            str3 = null;
                        }
                        if (i6 != 0) {
                            str4 = null;
                        }
                        if (i8 != 0) {
                            function4 = null;
                        }
                        if (i10 != 0) {
                            function7 = null;
                        } else {
                            function7 = function3;
                        }
                        if ((i2 & 256) != 0) {
                            jM11533getMainActiveControl0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                            i3 &= -234881025;
                        } else {
                            jM11533getMainActiveControl0d7_KjU = j;
                        }
                        if ((i2 & 512) != 0) {
                            String str11111110 = str4;
                            i12 = i3 & (-1879048193);
                            str7 = str11111110;
                            j5 = jM11533getMainActiveControl0d7_KjU;
                            function8 = function7;
                            str8 = str3;
                            jM11533getMainActiveControl0d7_KjU2 = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                        } else {
                            String str11111111 = str4;
                            i12 = i3;
                            str7 = str11111111;
                            j5 = jM11533getMainActiveControl0d7_KjU;
                            function8 = function7;
                            str8 = str3;
                            jM11533getMainActiveControl0d7_KjU2 = j2;
                        }
                    } else {
                        if (i13 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i4 != 0) {
                            str3 = null;
                        }
                        if (i6 != 0) {
                            str4 = null;
                        }
                        if (i8 != 0) {
                            function4 = null;
                        }
                        if (i10 != 0) {
                            function7 = null;
                        } else {
                            function7 = function3;
                        }
                        if ((i2 & 256) != 0) {
                            jM11533getMainActiveControl0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                            i3 &= -234881025;
                        } else {
                            jM11533getMainActiveControl0d7_KjU = j;
                        }
                        if ((i2 & 512) != 0) {
                            String str11111112 = str4;
                            i12 = i3 & (-1879048193);
                            str7 = str11111112;
                            j5 = jM11533getMainActiveControl0d7_KjU;
                            function8 = function7;
                            str8 = str3;
                            jM11533getMainActiveControl0d7_KjU2 = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                        } else {
                            String str11111113 = str4;
                            i12 = i3;
                            str7 = str11111113;
                            j5 = jM11533getMainActiveControl0d7_KjU;
                            function8 = function7;
                            str8 = str3;
                            jM11533getMainActiveControl0d7_KjU2 = j2;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(962660873, i12, -1, "com.box.android.base.compose.dialog.BoxDialog (BoxDialog.kt:49)");
                    }
                    if (button instanceof DialogButtonsConfig.PositiveButton) {
                        pair = new Pair(((DialogButtonsConfig.PositiveButton) button).getButton(), null);
                    } else if (button instanceof DialogButtonsConfig.NegativeButton) {
                        pair = new Pair(null, ((DialogButtonsConfig.NegativeButton) button).getButton());
                    } else {
                        if (!(button instanceof DialogButtonsConfig.PositiveAndNegativeButtons)) {
                            throw new NoWhenBranchMatchedException();
                        }
                        DialogButtonsConfig.PositiveAndNegativeButtons positiveAndNegativeButtons12 = (DialogButtonsConfig.PositiveAndNegativeButtons) button;
                        pair = new Pair(positiveAndNegativeButtons12.getPositiveButton(), positiveAndNegativeButtons12.getNegativeButton());
                    }
                    final ButtonItem.TextButtonItem textButtonItem13 = (ButtonItem.TextButtonItem) pair.component1();
                    textButtonItem = (ButtonItem.TextButtonItem) pair.component2();
                    if (str8 != null) {
                        modifierDialogSemantics = TestTagKt.testTag(companion, str8);
                    } else {
                        modifierDialogSemantics = companion;
                    }
                    if (str7 != null) {
                        modifierDialogSemantics = ComposeUtilsKt.dialogSemantics(modifierDialogSemantics, str7);
                    }
                    if (function0 != null) {
                        onClick = function0;
                    } else if (textButtonItem != null) {
                        onClick = textButtonItem.getOnClick();
                    } else {
                        onClick = null;
                    }
                    if (onClick == null) {
                        composerStartRestartGroup.startReplaceGroup(1134495670);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "60@3049L3");
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1699164620, "CC(remember):BoxDialog.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new Function0() { // from class: com.box.android.base.compose.dialog.BoxDialogKt$$ExternalSyntheticLambda1
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return Unit.INSTANCE;
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        onClick = (Function0) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    } else {
                        composerStartRestartGroup.startReplaceGroup(1699163163);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    long jM11516getDialogContainer0d7_KjU12 = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11516getDialogContainer0d7_KjU();
                    long jM11500getAppPrimary0d7_KjU12 = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11500getAppPrimary0d7_KjU();
                    long jM11526getItemInfoTextSecondary0d7_KjU12 = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11526getItemInfoTextSecondary0d7_KjU();
                    if (textButtonItem == null) {
                        composerStartRestartGroup.startReplaceGroup(1134801081);
                        composerStartRestartGroup.endReplaceGroup();
                        composableLambdaRememberComposableLambda = null;
                        z2 = true;
                    } else {
                        composerStartRestartGroup.startReplaceGroup(1134801082);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "*68@3360L451");
                        z2 = true;
                        composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-1707763176, true, new Function2() { // from class: com.box.android.base.compose.dialog.BoxDialogKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return BoxDialogKt.BoxDialog_0S3VyRs$lambda$3$0(textButtonItem, jM11533getMainActiveControl0d7_KjU2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                        composerStartRestartGroup.endReplaceGroup();
                    }
                    ComposableLambda composableLambdaRememberComposableLambda13 = ComposableLambdaKt.rememberComposableLambda(-825495871, z2, new Function2() { // from class: com.box.android.base.compose.dialog.BoxDialogKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return BoxDialogKt.BoxDialog_0S3VyRs$lambda$4(textButtonItem13, j5, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54);
                    int i1116 = i12 >> 6;
                    int i1117 = (i1116 & 458752) | (57344 & i1116) | 48 | ((i12 << 15) & 3670016);
                    long j118 = j5;
                    long j119 = jM11533getMainActiveControl0d7_KjU2;
                    composer2 = composerStartRestartGroup;
                    Function2<? super Composer, ? super Integer, Unit> function1111 = function4;
                    String str11111114 = str8;
                    String str11111115 = str7;
                    Function2<? super Composer, ? super Integer, Unit> function1112 = function8;
                    AndroidAlertDialog_androidKt.m2731AlertDialogOix01E0(onClick, composableLambdaRememberComposableLambda13, modifierDialogSemantics, composableLambdaRememberComposableLambda, function1111, function1112, content, null, jM11516getDialogContainer0d7_KjU12, 0L, jM11500getAppPrimary0d7_KjU12, jM11526getItemInfoTextSecondary0d7_KjU12, 0.0f, null, composer2, i1117, 0, 12928);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = companion;
                    str5 = str11111114;
                    function5 = function1112;
                    j4 = j119;
                    j3 = j118;
                    function6 = function1111;
                    str6 = str11111115;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    function5 = function3;
                    modifier3 = modifier2;
                    str5 = str3;
                    str6 = str4;
                    function6 = function4;
                    j3 = j;
                    j4 = j2;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.dialog.BoxDialogKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return BoxDialogKt.BoxDialog_0S3VyRs$lambda$5(function0, content, button, modifier3, str5, str6, function6, function5, j3, j4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 1572864;
            function4 = function2;
            i10 = i2 & 128;
            if (i10 != 0) {
                i3 |= 12582912;
            } else if ((i & 12582912) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i11 = 8388608;
                } else {
                    i11 = 4194304;
                }
                i3 |= i11;
            }
            if ((i & 100663296) != 0) {
                i3 |= ((i2 & 256) == 0 || !composerStartRestartGroup.changed(j)) ? 33554432 : 67108864;
            }
            if ((i & 805306368) != 0) {
                i3 |= ((i2 & 512) == 0 || !composerStartRestartGroup.changed(j2)) ? 268435456 : C.BUFFER_FLAG_LAST_SAMPLE;
            }
            if ((i3 & 306783379) != 306783378) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "47@2334L6,48@2402L6");
                if ((i & 1) != 0) {
                    if (i13 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i4 != 0) {
                        str3 = null;
                    }
                    if (i6 != 0) {
                        str4 = null;
                    }
                    if (i8 != 0) {
                        function4 = null;
                    }
                    if (i10 != 0) {
                        function7 = null;
                    } else {
                        function7 = function3;
                    }
                    if ((i2 & 256) != 0) {
                        jM11533getMainActiveControl0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                        i3 &= -234881025;
                    } else {
                        jM11533getMainActiveControl0d7_KjU = j;
                    }
                    if ((i2 & 512) != 0) {
                        String str11111116 = str4;
                        i12 = i3 & (-1879048193);
                        str7 = str11111116;
                        j5 = jM11533getMainActiveControl0d7_KjU;
                        function8 = function7;
                        str8 = str3;
                        jM11533getMainActiveControl0d7_KjU2 = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                    } else {
                        String str11111117 = str4;
                        i12 = i3;
                        str7 = str11111117;
                        j5 = jM11533getMainActiveControl0d7_KjU;
                        function8 = function7;
                        str8 = str3;
                        jM11533getMainActiveControl0d7_KjU2 = j2;
                    }
                } else {
                    if (i13 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i4 != 0) {
                        str3 = null;
                    }
                    if (i6 != 0) {
                        str4 = null;
                    }
                    if (i8 != 0) {
                        function4 = null;
                    }
                    if (i10 != 0) {
                        function7 = null;
                    } else {
                        function7 = function3;
                    }
                    if ((i2 & 256) != 0) {
                        jM11533getMainActiveControl0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                        i3 &= -234881025;
                    } else {
                        jM11533getMainActiveControl0d7_KjU = j;
                    }
                    if ((i2 & 512) != 0) {
                        String str11111118 = str4;
                        i12 = i3 & (-1879048193);
                        str7 = str11111118;
                        j5 = jM11533getMainActiveControl0d7_KjU;
                        function8 = function7;
                        str8 = str3;
                        jM11533getMainActiveControl0d7_KjU2 = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                    } else {
                        String str11111119 = str4;
                        i12 = i3;
                        str7 = str11111119;
                        j5 = jM11533getMainActiveControl0d7_KjU;
                        function8 = function7;
                        str8 = str3;
                        jM11533getMainActiveControl0d7_KjU2 = j2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(962660873, i12, -1, "com.box.android.base.compose.dialog.BoxDialog (BoxDialog.kt:49)");
                }
                if (button instanceof DialogButtonsConfig.PositiveButton) {
                    pair = new Pair(((DialogButtonsConfig.PositiveButton) button).getButton(), null);
                } else if (button instanceof DialogButtonsConfig.NegativeButton) {
                    pair = new Pair(null, ((DialogButtonsConfig.NegativeButton) button).getButton());
                } else {
                    if (!(button instanceof DialogButtonsConfig.PositiveAndNegativeButtons)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    DialogButtonsConfig.PositiveAndNegativeButtons positiveAndNegativeButtons13 = (DialogButtonsConfig.PositiveAndNegativeButtons) button;
                    pair = new Pair(positiveAndNegativeButtons13.getPositiveButton(), positiveAndNegativeButtons13.getNegativeButton());
                }
                final ButtonItem.TextButtonItem textButtonItem14 = (ButtonItem.TextButtonItem) pair.component1();
                textButtonItem = (ButtonItem.TextButtonItem) pair.component2();
                if (str8 != null) {
                    modifierDialogSemantics = TestTagKt.testTag(companion, str8);
                } else {
                    modifierDialogSemantics = companion;
                }
                if (str7 != null) {
                    modifierDialogSemantics = ComposeUtilsKt.dialogSemantics(modifierDialogSemantics, str7);
                }
                if (function0 != null) {
                    onClick = function0;
                } else if (textButtonItem != null) {
                    onClick = textButtonItem.getOnClick();
                } else {
                    onClick = null;
                }
                if (onClick == null) {
                    composerStartRestartGroup.startReplaceGroup(1134495670);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "60@3049L3");
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1699164620, "CC(remember):BoxDialog.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new Function0() { // from class: com.box.android.base.compose.dialog.BoxDialogKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Unit.INSTANCE;
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    onClick = (Function0) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                } else {
                    composerStartRestartGroup.startReplaceGroup(1699163163);
                }
                composerStartRestartGroup.endReplaceGroup();
                long jM11516getDialogContainer0d7_KjU13 = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11516getDialogContainer0d7_KjU();
                long jM11500getAppPrimary0d7_KjU13 = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11500getAppPrimary0d7_KjU();
                long jM11526getItemInfoTextSecondary0d7_KjU13 = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11526getItemInfoTextSecondary0d7_KjU();
                if (textButtonItem == null) {
                    composerStartRestartGroup.startReplaceGroup(1134801081);
                    composerStartRestartGroup.endReplaceGroup();
                    composableLambdaRememberComposableLambda = null;
                    z2 = true;
                } else {
                    composerStartRestartGroup.startReplaceGroup(1134801082);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "*68@3360L451");
                    z2 = true;
                    composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-1707763176, true, new Function2() { // from class: com.box.android.base.compose.dialog.BoxDialogKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return BoxDialogKt.BoxDialog_0S3VyRs$lambda$3$0(textButtonItem, jM11533getMainActiveControl0d7_KjU2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54);
                    composerStartRestartGroup.endReplaceGroup();
                }
                ComposableLambda composableLambdaRememberComposableLambda14 = ComposableLambdaKt.rememberComposableLambda(-825495871, z2, new Function2() { // from class: com.box.android.base.compose.dialog.BoxDialogKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return BoxDialogKt.BoxDialog_0S3VyRs$lambda$4(textButtonItem14, j5, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54);
                int i1118 = i12 >> 6;
                int i1119 = (i1118 & 458752) | (57344 & i1118) | 48 | ((i12 << 15) & 3670016);
                long j1110 = j5;
                long j1111 = jM11533getMainActiveControl0d7_KjU2;
                composer2 = composerStartRestartGroup;
                Function2<? super Composer, ? super Integer, Unit> function1113 = function4;
                String str111111110 = str8;
                String str111111111 = str7;
                Function2<? super Composer, ? super Integer, Unit> function1114 = function8;
                AndroidAlertDialog_androidKt.m2731AlertDialogOix01E0(onClick, composableLambdaRememberComposableLambda14, modifierDialogSemantics, composableLambdaRememberComposableLambda, function1113, function1114, content, null, jM11516getDialogContainer0d7_KjU13, 0L, jM11500getAppPrimary0d7_KjU13, jM11526getItemInfoTextSecondary0d7_KjU13, 0.0f, null, composer2, i1119, 0, 12928);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = companion;
                str5 = str111111110;
                function5 = function1114;
                j4 = j1111;
                j3 = j1110;
                function6 = function1113;
                str6 = str111111111;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                function5 = function3;
                modifier3 = modifier2;
                str5 = str3;
                str6 = str4;
                function6 = function4;
                j3 = j;
                j4 = j2;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.dialog.BoxDialogKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return BoxDialogKt.BoxDialog_0S3VyRs$lambda$5(function0, content, button, modifier3, str5, str6, function6, function5, j3, j4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 24576;
        str3 = str;
        i6 = i2 & 32;
        if (i6 != 0) {
            if ((196608 & i) == 0) {
                str4 = str2;
                if (composerStartRestartGroup.changed(str4)) {
                    i7 = 131072;
                } else {
                    i7 = 65536;
                }
                i3 |= i7;
            }
            i8 = i2 & 64;
            if (i8 != 0) {
                if ((1572864 & i) == 0) {
                    function4 = function2;
                    if (composerStartRestartGroup.changedInstance(function4)) {
                        i9 = 1048576;
                    } else {
                        i9 = 524288;
                    }
                    i3 |= i9;
                }
                i10 = i2 & 128;
                if (i10 != 0) {
                    i3 |= 12582912;
                } else if ((i & 12582912) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i11 = 8388608;
                    } else {
                        i11 = 4194304;
                    }
                    i3 |= i11;
                }
                if ((i & 100663296) != 0) {
                    i3 |= ((i2 & 256) == 0 || !composerStartRestartGroup.changed(j)) ? 33554432 : 67108864;
                }
                if ((i & 805306368) != 0) {
                    i3 |= ((i2 & 512) == 0 || !composerStartRestartGroup.changed(j2)) ? 268435456 : C.BUFFER_FLAG_LAST_SAMPLE;
                }
                if ((i3 & 306783379) != 306783378) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "47@2334L6,48@2402L6");
                    if ((i & 1) != 0) {
                        if (i13 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i4 != 0) {
                            str3 = null;
                        }
                        if (i6 != 0) {
                            str4 = null;
                        }
                        if (i8 != 0) {
                            function4 = null;
                        }
                        if (i10 != 0) {
                            function7 = null;
                        } else {
                            function7 = function3;
                        }
                        if ((i2 & 256) != 0) {
                            jM11533getMainActiveControl0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                            i3 &= -234881025;
                        } else {
                            jM11533getMainActiveControl0d7_KjU = j;
                        }
                        if ((i2 & 512) != 0) {
                            String str111111112 = str4;
                            i12 = i3 & (-1879048193);
                            str7 = str111111112;
                            j5 = jM11533getMainActiveControl0d7_KjU;
                            function8 = function7;
                            str8 = str3;
                            jM11533getMainActiveControl0d7_KjU2 = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                        } else {
                            String str111111113 = str4;
                            i12 = i3;
                            str7 = str111111113;
                            j5 = jM11533getMainActiveControl0d7_KjU;
                            function8 = function7;
                            str8 = str3;
                            jM11533getMainActiveControl0d7_KjU2 = j2;
                        }
                    } else {
                        if (i13 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i4 != 0) {
                            str3 = null;
                        }
                        if (i6 != 0) {
                            str4 = null;
                        }
                        if (i8 != 0) {
                            function4 = null;
                        }
                        if (i10 != 0) {
                            function7 = null;
                        } else {
                            function7 = function3;
                        }
                        if ((i2 & 256) != 0) {
                            jM11533getMainActiveControl0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                            i3 &= -234881025;
                        } else {
                            jM11533getMainActiveControl0d7_KjU = j;
                        }
                        if ((i2 & 512) != 0) {
                            String str111111114 = str4;
                            i12 = i3 & (-1879048193);
                            str7 = str111111114;
                            j5 = jM11533getMainActiveControl0d7_KjU;
                            function8 = function7;
                            str8 = str3;
                            jM11533getMainActiveControl0d7_KjU2 = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                        } else {
                            String str111111115 = str4;
                            i12 = i3;
                            str7 = str111111115;
                            j5 = jM11533getMainActiveControl0d7_KjU;
                            function8 = function7;
                            str8 = str3;
                            jM11533getMainActiveControl0d7_KjU2 = j2;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(962660873, i12, -1, "com.box.android.base.compose.dialog.BoxDialog (BoxDialog.kt:49)");
                    }
                    if (button instanceof DialogButtonsConfig.PositiveButton) {
                        pair = new Pair(((DialogButtonsConfig.PositiveButton) button).getButton(), null);
                    } else if (button instanceof DialogButtonsConfig.NegativeButton) {
                        pair = new Pair(null, ((DialogButtonsConfig.NegativeButton) button).getButton());
                    } else {
                        if (!(button instanceof DialogButtonsConfig.PositiveAndNegativeButtons)) {
                            throw new NoWhenBranchMatchedException();
                        }
                        DialogButtonsConfig.PositiveAndNegativeButtons positiveAndNegativeButtons14 = (DialogButtonsConfig.PositiveAndNegativeButtons) button;
                        pair = new Pair(positiveAndNegativeButtons14.getPositiveButton(), positiveAndNegativeButtons14.getNegativeButton());
                    }
                    final ButtonItem.TextButtonItem textButtonItem15 = (ButtonItem.TextButtonItem) pair.component1();
                    textButtonItem = (ButtonItem.TextButtonItem) pair.component2();
                    if (str8 != null) {
                        modifierDialogSemantics = TestTagKt.testTag(companion, str8);
                    } else {
                        modifierDialogSemantics = companion;
                    }
                    if (str7 != null) {
                        modifierDialogSemantics = ComposeUtilsKt.dialogSemantics(modifierDialogSemantics, str7);
                    }
                    if (function0 != null) {
                        onClick = function0;
                    } else if (textButtonItem != null) {
                        onClick = textButtonItem.getOnClick();
                    } else {
                        onClick = null;
                    }
                    if (onClick == null) {
                        composerStartRestartGroup.startReplaceGroup(1134495670);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "60@3049L3");
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1699164620, "CC(remember):BoxDialog.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new Function0() { // from class: com.box.android.base.compose.dialog.BoxDialogKt$$ExternalSyntheticLambda1
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return Unit.INSTANCE;
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        onClick = (Function0) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    } else {
                        composerStartRestartGroup.startReplaceGroup(1699163163);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    long jM11516getDialogContainer0d7_KjU14 = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11516getDialogContainer0d7_KjU();
                    long jM11500getAppPrimary0d7_KjU14 = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11500getAppPrimary0d7_KjU();
                    long jM11526getItemInfoTextSecondary0d7_KjU14 = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11526getItemInfoTextSecondary0d7_KjU();
                    if (textButtonItem == null) {
                        composerStartRestartGroup.startReplaceGroup(1134801081);
                        composerStartRestartGroup.endReplaceGroup();
                        composableLambdaRememberComposableLambda = null;
                        z2 = true;
                    } else {
                        composerStartRestartGroup.startReplaceGroup(1134801082);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "*68@3360L451");
                        z2 = true;
                        composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-1707763176, true, new Function2() { // from class: com.box.android.base.compose.dialog.BoxDialogKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return BoxDialogKt.BoxDialog_0S3VyRs$lambda$3$0(textButtonItem, jM11533getMainActiveControl0d7_KjU2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54);
                        composerStartRestartGroup.endReplaceGroup();
                    }
                    ComposableLambda composableLambdaRememberComposableLambda15 = ComposableLambdaKt.rememberComposableLambda(-825495871, z2, new Function2() { // from class: com.box.android.base.compose.dialog.BoxDialogKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return BoxDialogKt.BoxDialog_0S3VyRs$lambda$4(textButtonItem15, j5, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54);
                    int i11110 = i12 >> 6;
                    int i11111 = (i11110 & 458752) | (57344 & i11110) | 48 | ((i12 << 15) & 3670016);
                    long j1112 = j5;
                    long j1113 = jM11533getMainActiveControl0d7_KjU2;
                    composer2 = composerStartRestartGroup;
                    Function2<? super Composer, ? super Integer, Unit> function1115 = function4;
                    String str111111116 = str8;
                    String str111111117 = str7;
                    Function2<? super Composer, ? super Integer, Unit> function1116 = function8;
                    AndroidAlertDialog_androidKt.m2731AlertDialogOix01E0(onClick, composableLambdaRememberComposableLambda15, modifierDialogSemantics, composableLambdaRememberComposableLambda, function1115, function1116, content, null, jM11516getDialogContainer0d7_KjU14, 0L, jM11500getAppPrimary0d7_KjU14, jM11526getItemInfoTextSecondary0d7_KjU14, 0.0f, null, composer2, i11111, 0, 12928);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = companion;
                    str5 = str111111116;
                    function5 = function1116;
                    j4 = j1113;
                    j3 = j1112;
                    function6 = function1115;
                    str6 = str111111117;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    function5 = function3;
                    modifier3 = modifier2;
                    str5 = str3;
                    str6 = str4;
                    function6 = function4;
                    j3 = j;
                    j4 = j2;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.dialog.BoxDialogKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return BoxDialogKt.BoxDialog_0S3VyRs$lambda$5(function0, content, button, modifier3, str5, str6, function6, function5, j3, j4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 1572864;
            function4 = function2;
            i10 = i2 & 128;
            if (i10 != 0) {
                i3 |= 12582912;
            } else if ((i & 12582912) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i11 = 8388608;
                } else {
                    i11 = 4194304;
                }
                i3 |= i11;
            }
            if ((i & 100663296) != 0) {
                i3 |= ((i2 & 256) == 0 || !composerStartRestartGroup.changed(j)) ? 33554432 : 67108864;
            }
            if ((i & 805306368) != 0) {
                i3 |= ((i2 & 512) == 0 || !composerStartRestartGroup.changed(j2)) ? 268435456 : C.BUFFER_FLAG_LAST_SAMPLE;
            }
            if ((i3 & 306783379) != 306783378) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "47@2334L6,48@2402L6");
                if ((i & 1) != 0) {
                    if (i13 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i4 != 0) {
                        str3 = null;
                    }
                    if (i6 != 0) {
                        str4 = null;
                    }
                    if (i8 != 0) {
                        function4 = null;
                    }
                    if (i10 != 0) {
                        function7 = null;
                    } else {
                        function7 = function3;
                    }
                    if ((i2 & 256) != 0) {
                        jM11533getMainActiveControl0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                        i3 &= -234881025;
                    } else {
                        jM11533getMainActiveControl0d7_KjU = j;
                    }
                    if ((i2 & 512) != 0) {
                        String str111111118 = str4;
                        i12 = i3 & (-1879048193);
                        str7 = str111111118;
                        j5 = jM11533getMainActiveControl0d7_KjU;
                        function8 = function7;
                        str8 = str3;
                        jM11533getMainActiveControl0d7_KjU2 = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                    } else {
                        String str111111119 = str4;
                        i12 = i3;
                        str7 = str111111119;
                        j5 = jM11533getMainActiveControl0d7_KjU;
                        function8 = function7;
                        str8 = str3;
                        jM11533getMainActiveControl0d7_KjU2 = j2;
                    }
                } else {
                    if (i13 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i4 != 0) {
                        str3 = null;
                    }
                    if (i6 != 0) {
                        str4 = null;
                    }
                    if (i8 != 0) {
                        function4 = null;
                    }
                    if (i10 != 0) {
                        function7 = null;
                    } else {
                        function7 = function3;
                    }
                    if ((i2 & 256) != 0) {
                        jM11533getMainActiveControl0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                        i3 &= -234881025;
                    } else {
                        jM11533getMainActiveControl0d7_KjU = j;
                    }
                    if ((i2 & 512) != 0) {
                        String str1111111110 = str4;
                        i12 = i3 & (-1879048193);
                        str7 = str1111111110;
                        j5 = jM11533getMainActiveControl0d7_KjU;
                        function8 = function7;
                        str8 = str3;
                        jM11533getMainActiveControl0d7_KjU2 = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                    } else {
                        String str1111111111 = str4;
                        i12 = i3;
                        str7 = str1111111111;
                        j5 = jM11533getMainActiveControl0d7_KjU;
                        function8 = function7;
                        str8 = str3;
                        jM11533getMainActiveControl0d7_KjU2 = j2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(962660873, i12, -1, "com.box.android.base.compose.dialog.BoxDialog (BoxDialog.kt:49)");
                }
                if (button instanceof DialogButtonsConfig.PositiveButton) {
                    pair = new Pair(((DialogButtonsConfig.PositiveButton) button).getButton(), null);
                } else if (button instanceof DialogButtonsConfig.NegativeButton) {
                    pair = new Pair(null, ((DialogButtonsConfig.NegativeButton) button).getButton());
                } else {
                    if (!(button instanceof DialogButtonsConfig.PositiveAndNegativeButtons)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    DialogButtonsConfig.PositiveAndNegativeButtons positiveAndNegativeButtons15 = (DialogButtonsConfig.PositiveAndNegativeButtons) button;
                    pair = new Pair(positiveAndNegativeButtons15.getPositiveButton(), positiveAndNegativeButtons15.getNegativeButton());
                }
                final ButtonItem.TextButtonItem textButtonItem16 = (ButtonItem.TextButtonItem) pair.component1();
                textButtonItem = (ButtonItem.TextButtonItem) pair.component2();
                if (str8 != null) {
                    modifierDialogSemantics = TestTagKt.testTag(companion, str8);
                } else {
                    modifierDialogSemantics = companion;
                }
                if (str7 != null) {
                    modifierDialogSemantics = ComposeUtilsKt.dialogSemantics(modifierDialogSemantics, str7);
                }
                if (function0 != null) {
                    onClick = function0;
                } else if (textButtonItem != null) {
                    onClick = textButtonItem.getOnClick();
                } else {
                    onClick = null;
                }
                if (onClick == null) {
                    composerStartRestartGroup.startReplaceGroup(1134495670);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "60@3049L3");
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1699164620, "CC(remember):BoxDialog.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new Function0() { // from class: com.box.android.base.compose.dialog.BoxDialogKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Unit.INSTANCE;
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    onClick = (Function0) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                } else {
                    composerStartRestartGroup.startReplaceGroup(1699163163);
                }
                composerStartRestartGroup.endReplaceGroup();
                long jM11516getDialogContainer0d7_KjU15 = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11516getDialogContainer0d7_KjU();
                long jM11500getAppPrimary0d7_KjU15 = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11500getAppPrimary0d7_KjU();
                long jM11526getItemInfoTextSecondary0d7_KjU15 = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11526getItemInfoTextSecondary0d7_KjU();
                if (textButtonItem == null) {
                    composerStartRestartGroup.startReplaceGroup(1134801081);
                    composerStartRestartGroup.endReplaceGroup();
                    composableLambdaRememberComposableLambda = null;
                    z2 = true;
                } else {
                    composerStartRestartGroup.startReplaceGroup(1134801082);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "*68@3360L451");
                    z2 = true;
                    composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-1707763176, true, new Function2() { // from class: com.box.android.base.compose.dialog.BoxDialogKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return BoxDialogKt.BoxDialog_0S3VyRs$lambda$3$0(textButtonItem, jM11533getMainActiveControl0d7_KjU2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54);
                    composerStartRestartGroup.endReplaceGroup();
                }
                ComposableLambda composableLambdaRememberComposableLambda16 = ComposableLambdaKt.rememberComposableLambda(-825495871, z2, new Function2() { // from class: com.box.android.base.compose.dialog.BoxDialogKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return BoxDialogKt.BoxDialog_0S3VyRs$lambda$4(textButtonItem16, j5, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54);
                int i11112 = i12 >> 6;
                int i11113 = (i11112 & 458752) | (57344 & i11112) | 48 | ((i12 << 15) & 3670016);
                long j1114 = j5;
                long j1115 = jM11533getMainActiveControl0d7_KjU2;
                composer2 = composerStartRestartGroup;
                Function2<? super Composer, ? super Integer, Unit> function1117 = function4;
                String str1111111112 = str8;
                String str1111111113 = str7;
                Function2<? super Composer, ? super Integer, Unit> function1118 = function8;
                AndroidAlertDialog_androidKt.m2731AlertDialogOix01E0(onClick, composableLambdaRememberComposableLambda16, modifierDialogSemantics, composableLambdaRememberComposableLambda, function1117, function1118, content, null, jM11516getDialogContainer0d7_KjU15, 0L, jM11500getAppPrimary0d7_KjU15, jM11526getItemInfoTextSecondary0d7_KjU15, 0.0f, null, composer2, i11113, 0, 12928);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = companion;
                str5 = str1111111112;
                function5 = function1118;
                j4 = j1115;
                j3 = j1114;
                function6 = function1117;
                str6 = str1111111113;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                function5 = function3;
                modifier3 = modifier2;
                str5 = str3;
                str6 = str4;
                function6 = function4;
                j3 = j;
                j4 = j2;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.dialog.BoxDialogKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return BoxDialogKt.BoxDialog_0S3VyRs$lambda$5(function0, content, button, modifier3, str5, str6, function6, function5, j3, j4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        str4 = str2;
        i8 = i2 & 64;
        if (i8 != 0) {
            if ((1572864 & i) == 0) {
                function4 = function2;
                if (composerStartRestartGroup.changedInstance(function4)) {
                    i9 = 1048576;
                } else {
                    i9 = 524288;
                }
                i3 |= i9;
            }
            i10 = i2 & 128;
            if (i10 != 0) {
                i3 |= 12582912;
            } else if ((i & 12582912) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i11 = 8388608;
                } else {
                    i11 = 4194304;
                }
                i3 |= i11;
            }
            if ((i & 100663296) != 0) {
                i3 |= ((i2 & 256) == 0 || !composerStartRestartGroup.changed(j)) ? 33554432 : 67108864;
            }
            if ((i & 805306368) != 0) {
                i3 |= ((i2 & 512) == 0 || !composerStartRestartGroup.changed(j2)) ? 268435456 : C.BUFFER_FLAG_LAST_SAMPLE;
            }
            if ((i3 & 306783379) != 306783378) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "47@2334L6,48@2402L6");
                if ((i & 1) != 0) {
                    if (i13 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i4 != 0) {
                        str3 = null;
                    }
                    if (i6 != 0) {
                        str4 = null;
                    }
                    if (i8 != 0) {
                        function4 = null;
                    }
                    if (i10 != 0) {
                        function7 = null;
                    } else {
                        function7 = function3;
                    }
                    if ((i2 & 256) != 0) {
                        jM11533getMainActiveControl0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                        i3 &= -234881025;
                    } else {
                        jM11533getMainActiveControl0d7_KjU = j;
                    }
                    if ((i2 & 512) != 0) {
                        String str1111111114 = str4;
                        i12 = i3 & (-1879048193);
                        str7 = str1111111114;
                        j5 = jM11533getMainActiveControl0d7_KjU;
                        function8 = function7;
                        str8 = str3;
                        jM11533getMainActiveControl0d7_KjU2 = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                    } else {
                        String str1111111115 = str4;
                        i12 = i3;
                        str7 = str1111111115;
                        j5 = jM11533getMainActiveControl0d7_KjU;
                        function8 = function7;
                        str8 = str3;
                        jM11533getMainActiveControl0d7_KjU2 = j2;
                    }
                } else {
                    if (i13 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i4 != 0) {
                        str3 = null;
                    }
                    if (i6 != 0) {
                        str4 = null;
                    }
                    if (i8 != 0) {
                        function4 = null;
                    }
                    if (i10 != 0) {
                        function7 = null;
                    } else {
                        function7 = function3;
                    }
                    if ((i2 & 256) != 0) {
                        jM11533getMainActiveControl0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                        i3 &= -234881025;
                    } else {
                        jM11533getMainActiveControl0d7_KjU = j;
                    }
                    if ((i2 & 512) != 0) {
                        String str1111111116 = str4;
                        i12 = i3 & (-1879048193);
                        str7 = str1111111116;
                        j5 = jM11533getMainActiveControl0d7_KjU;
                        function8 = function7;
                        str8 = str3;
                        jM11533getMainActiveControl0d7_KjU2 = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                    } else {
                        String str1111111117 = str4;
                        i12 = i3;
                        str7 = str1111111117;
                        j5 = jM11533getMainActiveControl0d7_KjU;
                        function8 = function7;
                        str8 = str3;
                        jM11533getMainActiveControl0d7_KjU2 = j2;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(962660873, i12, -1, "com.box.android.base.compose.dialog.BoxDialog (BoxDialog.kt:49)");
                }
                if (button instanceof DialogButtonsConfig.PositiveButton) {
                    pair = new Pair(((DialogButtonsConfig.PositiveButton) button).getButton(), null);
                } else if (button instanceof DialogButtonsConfig.NegativeButton) {
                    pair = new Pair(null, ((DialogButtonsConfig.NegativeButton) button).getButton());
                } else {
                    if (!(button instanceof DialogButtonsConfig.PositiveAndNegativeButtons)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    DialogButtonsConfig.PositiveAndNegativeButtons positiveAndNegativeButtons16 = (DialogButtonsConfig.PositiveAndNegativeButtons) button;
                    pair = new Pair(positiveAndNegativeButtons16.getPositiveButton(), positiveAndNegativeButtons16.getNegativeButton());
                }
                final ButtonItem.TextButtonItem textButtonItem17 = (ButtonItem.TextButtonItem) pair.component1();
                textButtonItem = (ButtonItem.TextButtonItem) pair.component2();
                if (str8 != null) {
                    modifierDialogSemantics = TestTagKt.testTag(companion, str8);
                } else {
                    modifierDialogSemantics = companion;
                }
                if (str7 != null) {
                    modifierDialogSemantics = ComposeUtilsKt.dialogSemantics(modifierDialogSemantics, str7);
                }
                if (function0 != null) {
                    onClick = function0;
                } else if (textButtonItem != null) {
                    onClick = textButtonItem.getOnClick();
                } else {
                    onClick = null;
                }
                if (onClick == null) {
                    composerStartRestartGroup.startReplaceGroup(1134495670);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "60@3049L3");
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1699164620, "CC(remember):BoxDialog.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new Function0() { // from class: com.box.android.base.compose.dialog.BoxDialogKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Unit.INSTANCE;
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    onClick = (Function0) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                } else {
                    composerStartRestartGroup.startReplaceGroup(1699163163);
                }
                composerStartRestartGroup.endReplaceGroup();
                long jM11516getDialogContainer0d7_KjU16 = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11516getDialogContainer0d7_KjU();
                long jM11500getAppPrimary0d7_KjU16 = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11500getAppPrimary0d7_KjU();
                long jM11526getItemInfoTextSecondary0d7_KjU16 = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11526getItemInfoTextSecondary0d7_KjU();
                if (textButtonItem == null) {
                    composerStartRestartGroup.startReplaceGroup(1134801081);
                    composerStartRestartGroup.endReplaceGroup();
                    composableLambdaRememberComposableLambda = null;
                    z2 = true;
                } else {
                    composerStartRestartGroup.startReplaceGroup(1134801082);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "*68@3360L451");
                    z2 = true;
                    composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-1707763176, true, new Function2() { // from class: com.box.android.base.compose.dialog.BoxDialogKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return BoxDialogKt.BoxDialog_0S3VyRs$lambda$3$0(textButtonItem, jM11533getMainActiveControl0d7_KjU2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54);
                    composerStartRestartGroup.endReplaceGroup();
                }
                ComposableLambda composableLambdaRememberComposableLambda17 = ComposableLambdaKt.rememberComposableLambda(-825495871, z2, new Function2() { // from class: com.box.android.base.compose.dialog.BoxDialogKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return BoxDialogKt.BoxDialog_0S3VyRs$lambda$4(textButtonItem17, j5, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54);
                int i11114 = i12 >> 6;
                int i11115 = (i11114 & 458752) | (57344 & i11114) | 48 | ((i12 << 15) & 3670016);
                long j1116 = j5;
                long j1117 = jM11533getMainActiveControl0d7_KjU2;
                composer2 = composerStartRestartGroup;
                Function2<? super Composer, ? super Integer, Unit> function1119 = function4;
                String str1111111118 = str8;
                String str1111111119 = str7;
                Function2<? super Composer, ? super Integer, Unit> function11110 = function8;
                AndroidAlertDialog_androidKt.m2731AlertDialogOix01E0(onClick, composableLambdaRememberComposableLambda17, modifierDialogSemantics, composableLambdaRememberComposableLambda, function1119, function11110, content, null, jM11516getDialogContainer0d7_KjU16, 0L, jM11500getAppPrimary0d7_KjU16, jM11526getItemInfoTextSecondary0d7_KjU16, 0.0f, null, composer2, i11115, 0, 12928);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = companion;
                str5 = str1111111118;
                function5 = function11110;
                j4 = j1117;
                j3 = j1116;
                function6 = function1119;
                str6 = str1111111119;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                function5 = function3;
                modifier3 = modifier2;
                str5 = str3;
                str6 = str4;
                function6 = function4;
                j3 = j;
                j4 = j2;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.dialog.BoxDialogKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return BoxDialogKt.BoxDialog_0S3VyRs$lambda$5(function0, content, button, modifier3, str5, str6, function6, function5, j3, j4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 1572864;
        function4 = function2;
        i10 = i2 & 128;
        if (i10 != 0) {
            i3 |= 12582912;
        } else if ((i & 12582912) == 0) {
            if (composerStartRestartGroup.changedInstance(function3)) {
                i11 = 8388608;
            } else {
                i11 = 4194304;
            }
            i3 |= i11;
        }
        if ((i & 100663296) != 0) {
            i3 |= ((i2 & 256) == 0 || !composerStartRestartGroup.changed(j)) ? 33554432 : 67108864;
        }
        if ((i & 805306368) != 0) {
            i3 |= ((i2 & 512) == 0 || !composerStartRestartGroup.changed(j2)) ? 268435456 : C.BUFFER_FLAG_LAST_SAMPLE;
        }
        if ((i3 & 306783379) != 306783378) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "47@2334L6,48@2402L6");
            if ((i & 1) != 0) {
                if (i13 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i4 != 0) {
                    str3 = null;
                }
                if (i6 != 0) {
                    str4 = null;
                }
                if (i8 != 0) {
                    function4 = null;
                }
                if (i10 != 0) {
                    function7 = null;
                } else {
                    function7 = function3;
                }
                if ((i2 & 256) != 0) {
                    jM11533getMainActiveControl0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                    i3 &= -234881025;
                } else {
                    jM11533getMainActiveControl0d7_KjU = j;
                }
                if ((i2 & 512) != 0) {
                    String str11111111110 = str4;
                    i12 = i3 & (-1879048193);
                    str7 = str11111111110;
                    j5 = jM11533getMainActiveControl0d7_KjU;
                    function8 = function7;
                    str8 = str3;
                    jM11533getMainActiveControl0d7_KjU2 = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                } else {
                    String str11111111111 = str4;
                    i12 = i3;
                    str7 = str11111111111;
                    j5 = jM11533getMainActiveControl0d7_KjU;
                    function8 = function7;
                    str8 = str3;
                    jM11533getMainActiveControl0d7_KjU2 = j2;
                }
            } else {
                if (i13 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i4 != 0) {
                    str3 = null;
                }
                if (i6 != 0) {
                    str4 = null;
                }
                if (i8 != 0) {
                    function4 = null;
                }
                if (i10 != 0) {
                    function7 = null;
                } else {
                    function7 = function3;
                }
                if ((i2 & 256) != 0) {
                    jM11533getMainActiveControl0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                    i3 &= -234881025;
                } else {
                    jM11533getMainActiveControl0d7_KjU = j;
                }
                if ((i2 & 512) != 0) {
                    String str11111111112 = str4;
                    i12 = i3 & (-1879048193);
                    str7 = str11111111112;
                    j5 = jM11533getMainActiveControl0d7_KjU;
                    function8 = function7;
                    str8 = str3;
                    jM11533getMainActiveControl0d7_KjU2 = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                } else {
                    String str11111111113 = str4;
                    i12 = i3;
                    str7 = str11111111113;
                    j5 = jM11533getMainActiveControl0d7_KjU;
                    function8 = function7;
                    str8 = str3;
                    jM11533getMainActiveControl0d7_KjU2 = j2;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(962660873, i12, -1, "com.box.android.base.compose.dialog.BoxDialog (BoxDialog.kt:49)");
            }
            if (button instanceof DialogButtonsConfig.PositiveButton) {
                pair = new Pair(((DialogButtonsConfig.PositiveButton) button).getButton(), null);
            } else if (button instanceof DialogButtonsConfig.NegativeButton) {
                pair = new Pair(null, ((DialogButtonsConfig.NegativeButton) button).getButton());
            } else {
                if (!(button instanceof DialogButtonsConfig.PositiveAndNegativeButtons)) {
                    throw new NoWhenBranchMatchedException();
                }
                DialogButtonsConfig.PositiveAndNegativeButtons positiveAndNegativeButtons17 = (DialogButtonsConfig.PositiveAndNegativeButtons) button;
                pair = new Pair(positiveAndNegativeButtons17.getPositiveButton(), positiveAndNegativeButtons17.getNegativeButton());
            }
            final ButtonItem.TextButtonItem textButtonItem18 = (ButtonItem.TextButtonItem) pair.component1();
            textButtonItem = (ButtonItem.TextButtonItem) pair.component2();
            if (str8 != null) {
                modifierDialogSemantics = TestTagKt.testTag(companion, str8);
            } else {
                modifierDialogSemantics = companion;
            }
            if (str7 != null) {
                modifierDialogSemantics = ComposeUtilsKt.dialogSemantics(modifierDialogSemantics, str7);
            }
            if (function0 != null) {
                onClick = function0;
            } else if (textButtonItem != null) {
                onClick = textButtonItem.getOnClick();
            } else {
                onClick = null;
            }
            if (onClick == null) {
                composerStartRestartGroup.startReplaceGroup(1134495670);
                ComposerKt.sourceInformation(composerStartRestartGroup, "60@3049L3");
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1699164620, "CC(remember):BoxDialog.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function0() { // from class: com.box.android.base.compose.dialog.BoxDialogKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return Unit.INSTANCE;
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                onClick = (Function0) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            } else {
                composerStartRestartGroup.startReplaceGroup(1699163163);
            }
            composerStartRestartGroup.endReplaceGroup();
            long jM11516getDialogContainer0d7_KjU17 = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11516getDialogContainer0d7_KjU();
            long jM11500getAppPrimary0d7_KjU17 = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11500getAppPrimary0d7_KjU();
            long jM11526getItemInfoTextSecondary0d7_KjU17 = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11526getItemInfoTextSecondary0d7_KjU();
            if (textButtonItem == null) {
                composerStartRestartGroup.startReplaceGroup(1134801081);
                composerStartRestartGroup.endReplaceGroup();
                composableLambdaRememberComposableLambda = null;
                z2 = true;
            } else {
                composerStartRestartGroup.startReplaceGroup(1134801082);
                ComposerKt.sourceInformation(composerStartRestartGroup, "*68@3360L451");
                z2 = true;
                composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-1707763176, true, new Function2() { // from class: com.box.android.base.compose.dialog.BoxDialogKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return BoxDialogKt.BoxDialog_0S3VyRs$lambda$3$0(textButtonItem, jM11533getMainActiveControl0d7_KjU2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54);
                composerStartRestartGroup.endReplaceGroup();
            }
            ComposableLambda composableLambdaRememberComposableLambda18 = ComposableLambdaKt.rememberComposableLambda(-825495871, z2, new Function2() { // from class: com.box.android.base.compose.dialog.BoxDialogKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BoxDialogKt.BoxDialog_0S3VyRs$lambda$4(textButtonItem18, j5, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54);
            int i11116 = i12 >> 6;
            int i11117 = (i11116 & 458752) | (57344 & i11116) | 48 | ((i12 << 15) & 3670016);
            long j1118 = j5;
            long j1119 = jM11533getMainActiveControl0d7_KjU2;
            composer2 = composerStartRestartGroup;
            Function2<? super Composer, ? super Integer, Unit> function11111 = function4;
            String str11111111114 = str8;
            String str11111111115 = str7;
            Function2<? super Composer, ? super Integer, Unit> function11112 = function8;
            AndroidAlertDialog_androidKt.m2731AlertDialogOix01E0(onClick, composableLambdaRememberComposableLambda18, modifierDialogSemantics, composableLambdaRememberComposableLambda, function11111, function11112, content, null, jM11516getDialogContainer0d7_KjU17, 0L, jM11500getAppPrimary0d7_KjU17, jM11526getItemInfoTextSecondary0d7_KjU17, 0.0f, null, composer2, i11117, 0, 12928);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = companion;
            str5 = str11111111114;
            function5 = function11112;
            j4 = j1119;
            j3 = j1118;
            function6 = function11111;
            str6 = str11111111115;
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            function5 = function3;
            modifier3 = modifier2;
            str5 = str3;
            str6 = str4;
            function6 = function4;
            j3 = j;
            j4 = j2;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.dialog.BoxDialogKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BoxDialogKt.BoxDialog_0S3VyRs$lambda$5(function0, content, button, modifier3, str5, str6, function6, function5, j3, j4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxDialog_0S3VyRs$lambda$3$0(ButtonItem.TextButtonItem textButtonItem, long j, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C72@3568L211,69@3378L419:BoxDialog.kt#fwd9q");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1707763176, i, -1, "com.box.android.base.compose.dialog.BoxDialog.<anonymous>.<anonymous> (BoxDialog.kt:69)");
            }
            BoxTextButtonKt.BoxTextButton(textButtonItem, TestTagKt.testTag(Modifier.INSTANCE, "BoxDialogNegativeButton"), ButtonDefaults.INSTANCE.m2878textButtonColorsro_MJ88(0L, j, 0L, Color.m6813copywmQWz5c$default(j, 0.4f, 0.0f, 0.0f, 0.0f, 14, null), composer, ButtonDefaults.$stable << 12, 5), composer, 48, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxDialog_0S3VyRs$lambda$4(ButtonItem.TextButtonItem textButtonItem, long j, Composer composer, int i) {
        Composer composer2 = composer;
        ComposerKt.sourceInformation(composer2, "C:BoxDialog.kt#fwd9q");
        if (composer2.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-825495871, i, -1, "com.box.android.base.compose.dialog.BoxDialog.<anonymous> (BoxDialog.kt:80)");
            }
            if (textButtonItem != null) {
                composer2.startReplaceGroup(635299582);
                ComposerKt.sourceInformation(composer2, "84@4097L211,81@3907L419");
                Modifier modifierTestTag = TestTagKt.testTag(Modifier.INSTANCE, "BoxDialogPositiveButton");
                ButtonColors buttonColorsM2878textButtonColorsro_MJ88 = ButtonDefaults.INSTANCE.m2878textButtonColorsro_MJ88(0L, j, 0L, Color.m6813copywmQWz5c$default(j, 0.4f, 0.0f, 0.0f, 0.0f, 14, null), composer2, ButtonDefaults.$stable << 12, 5);
                composer2 = composer;
                BoxTextButtonKt.BoxTextButton(textButtonItem, modifierTestTag, buttonColorsM2878textButtonColorsro_MJ88, composer2, 48, 0);
            } else {
                composer2.startReplaceGroup(631426721);
            }
            composer2.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer2.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    private static final void BoxDialogPreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-2080105616);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BoxDialogPreview)99@4471L632:BoxDialog.kt#fwd9q");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2080105616, i, -1, "com.box.android.base.compose.dialog.BoxDialogPreview (BoxDialog.kt:98)");
            }
            BoxThemeKt.BoxTheme(ComposableSingletons$BoxDialogKt.INSTANCE.m11720getLambda$1811286523$base_generalProdRelease(), composerStartRestartGroup, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.dialog.BoxDialogKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BoxDialogKt.BoxDialogPreview$lambda$0(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}
