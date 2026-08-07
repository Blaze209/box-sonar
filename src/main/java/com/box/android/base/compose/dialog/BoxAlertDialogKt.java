package com.box.android.base.compose.dialog;

import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.TestTagKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.media3.common.C;
import androidx.profileinstaller.ProfileVerifier;
import com.box.android.base.compose.BoxTheme;
import com.box.android.base.compose.BoxThemeKt;
import com.box.android.base.compose.button.model.ButtonItem;
import com.box.android.base.compose.dialog.model.DialogButtonsConfig;
import com.swmansion.rnscreens.gamma.stack.screen.event.StackScreenDismissEvent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.events.ComposeIdentificationData;

/* JADX INFO: compiled from: BoxAlertDialog.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001ai\u0010\u0000\u001a\u00020\u00012\b\b\u0001\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\rH\u0007¢\u0006\u0004\b\u000f\u0010\u0010\u001a\r\u0010\u0011\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u0012¨\u0006\u0013"}, d2 = {"BoxAlertDialog", "", "title", "", "text", "positiveButton", "Lcom/box/android/base/compose/button/model/ButtonItem$TextButtonItem;", "negativeButton", ComposeIdentificationData.FIELD_TEST_TAG_HASHED, "", StackScreenDismissEvent.EVENT_REGISTRATION_NAME, "Lkotlin/Function0;", "positiveButtonColor", "Landroidx/compose/ui/graphics/Color;", "negativeButtonColor", "BoxAlertDialog-SxpAMN0", "(IILcom/box/android/base/compose/button/model/ButtonItem$TextButtonItem;Lcom/box/android/base/compose/button/model/ButtonItem$TextButtonItem;Ljava/lang/String;Lkotlin/jvm/functions/Function0;JJLandroidx/compose/runtime/Composer;II)V", "BoxAlertDialogPreview", "(Landroidx/compose/runtime/Composer;I)V", "base_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class BoxAlertDialogKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxAlertDialogPreview$lambda$0(int i, Composer composer, int i2) {
        BoxAlertDialogPreview(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxAlertDialog_SxpAMN0$lambda$2(int i, int i2, ButtonItem.TextButtonItem textButtonItem, ButtonItem.TextButtonItem textButtonItem2, String str, Function0 function0, long j, long j2, int i3, int i4, Composer composer, int i5) {
        m11705BoxAlertDialogSxpAMN0(i, i2, textButtonItem, textButtonItem2, str, function0, j, j2, composer, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), i4);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0133  */
    /* JADX WARN: Code duplicated, block: B:102:0x0136  */
    /* JADX WARN: Code duplicated, block: B:104:0x0139  */
    /* JADX WARN: Code duplicated, block: B:107:0x013e  */
    /* JADX WARN: Code duplicated, block: B:108:0x014b  */
    /* JADX WARN: Code duplicated, block: B:111:0x0151  */
    /* JADX WARN: Code duplicated, block: B:114:0x016c  */
    /* JADX WARN: Code duplicated, block: B:117:0x017d  */
    /* JADX WARN: Code duplicated, block: B:118:0x0185  */
    /* JADX WARN: Code duplicated, block: B:121:0x01db  */
    /* JADX WARN: Code duplicated, block: B:123:0x01e6  */
    /* JADX WARN: Code duplicated, block: B:126:0x01f7  */
    /* JADX WARN: Code duplicated, block: B:128:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:37:0x006d  */
    /* JADX WARN: Code duplicated, block: B:38:0x0070  */
    /* JADX WARN: Code duplicated, block: B:40:0x0074  */
    /* JADX WARN: Code duplicated, block: B:42:0x007c  */
    /* JADX WARN: Code duplicated, block: B:43:0x007f  */
    /* JADX WARN: Code duplicated, block: B:48:0x008b  */
    /* JADX WARN: Code duplicated, block: B:49:0x008d  */
    /* JADX WARN: Code duplicated, block: B:51:0x0090  */
    /* JADX WARN: Code duplicated, block: B:53:0x0098  */
    /* JADX WARN: Code duplicated, block: B:54:0x009b  */
    /* JADX WARN: Code duplicated, block: B:59:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:61:0x00aa  */
    /* JADX WARN: Code duplicated, block: B:63:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:64:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:67:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:70:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:72:0x00c8  */
    /* JADX WARN: Code duplicated, block: B:74:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:75:0x00d6  */
    /* JADX WARN: Code duplicated, block: B:78:0x00e0  */
    /* JADX WARN: Code duplicated, block: B:81:0x00f2  */
    /* JADX WARN: Code duplicated, block: B:82:0x00f4  */
    /* JADX WARN: Code duplicated, block: B:85:0x00fd  */
    /* JADX WARN: Code duplicated, block: B:87:0x0110  */
    /* JADX WARN: Code duplicated, block: B:97:0x0129 A[PHI: r0 r7 r9 r13 r14
      0x0129: PHI (r0v23 int) = (r0v14 int), (r0v27 int), (r0v28 int) binds: [B:110:0x014f, B:95:0x0125, B:96:0x0127] A[DONT_GENERATE, DONT_INLINE]
      0x0129: PHI (r7v9 com.box.android.base.compose.button.model.ButtonItem$TextButtonItem) = 
      (r7v5 com.box.android.base.compose.button.model.ButtonItem$TextButtonItem)
      (r7v2 com.box.android.base.compose.button.model.ButtonItem$TextButtonItem)
      (r7v2 com.box.android.base.compose.button.model.ButtonItem$TextButtonItem)
     binds: [B:110:0x014f, B:95:0x0125, B:96:0x0127] A[DONT_GENERATE, DONT_INLINE]
      0x0129: PHI (r9v17 java.lang.String) = (r9v5 java.lang.String), (r9v2 java.lang.String), (r9v2 java.lang.String) binds: [B:110:0x014f, B:95:0x0125, B:96:0x0127] A[DONT_GENERATE, DONT_INLINE]
      0x0129: PHI (r13v9 kotlin.jvm.functions.Function0<kotlin.Unit>) = 
      (r13v6 kotlin.jvm.functions.Function0<kotlin.Unit>)
      (r13v3 kotlin.jvm.functions.Function0<kotlin.Unit>)
      (r13v3 kotlin.jvm.functions.Function0<kotlin.Unit>)
     binds: [B:110:0x014f, B:95:0x0125, B:96:0x0127] A[DONT_GENERATE, DONT_INLINE]
      0x0129: PHI (r14v12 long) = (r14v8 long), (r14v7 long), (r14v7 long) binds: [B:110:0x014f, B:95:0x0125, B:96:0x0127] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:98:0x0130  */
    /* JADX INFO: renamed from: BoxAlertDialog-SxpAMN0, reason: not valid java name */
    public static final void m11705BoxAlertDialogSxpAMN0(final int i, final int i2, final ButtonItem.TextButtonItem positiveButton, ButtonItem.TextButtonItem textButtonItem, String str, Function0<Unit> function0, long j, long j2, Composer composer, final int i3, final int i4) {
        int i5;
        ButtonItem.TextButtonItem textButtonItem2;
        int i6;
        String str2;
        int i7;
        int i8;
        Function0<Unit> function1;
        int i9;
        long jM11533getMainActiveControl0d7_KjU;
        int i10;
        int i11;
        int i12;
        boolean z;
        Composer composer2;
        final ButtonItem.TextButtonItem textButtonItem3;
        final String str3;
        final long j3;
        final long j4;
        final Function0<Unit> function2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i13;
        long j5;
        long jM11533getMainActiveControl0d7_KjU2;
        String str4;
        DialogButtonsConfig.PositiveButton positiveButton2;
        int i14;
        Intrinsics.checkNotNullParameter(positiveButton, "positiveButton");
        Composer composerStartRestartGroup = composer.startRestartGroup(-543818861);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BoxAlertDialog)N(title,text,positiveButton,negativeButton,testTag,onDismiss,positiveButtonColor:c#ui.graphics.Color,negativeButtonColor:c#ui.graphics.Color)27@1031L26,45@1570L154,39@1412L138,37@1347L580:BoxAlertDialog.kt#fwd9q");
        if ((i3 & 6) == 0) {
            i5 = (composerStartRestartGroup.changed(i) ? 4 : 2) | i3;
        } else {
            i5 = i3;
        }
        if ((i3 & 48) == 0) {
            i5 |= composerStartRestartGroup.changed(i2) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i5 |= composerStartRestartGroup.changed(positiveButton) ? 256 : 128;
        }
        int i15 = i4 & 8;
        if (i15 == 0) {
            if ((i3 & 3072) == 0) {
                textButtonItem2 = textButtonItem;
                i5 |= composerStartRestartGroup.changed(textButtonItem2) ? 2048 : 1024;
            }
            i6 = i4 & 16;
            if (i6 != 0) {
                if ((i3 & 24576) == 0) {
                    str2 = str;
                    if (composerStartRestartGroup.changed(str2)) {
                        i7 = 16384;
                    } else {
                        i7 = 8192;
                    }
                    i5 |= i7;
                }
                i8 = i4 & 32;
                if (i8 != 0) {
                    if ((196608 & i3) == 0) {
                        function1 = function0;
                        if (composerStartRestartGroup.changedInstance(function1)) {
                            i9 = 131072;
                        } else {
                            i9 = 65536;
                        }
                        i5 |= i9;
                    }
                    if ((1572864 & i3) == 0) {
                        if ((i4 & 64) == 0) {
                            jM11533getMainActiveControl0d7_KjU = j;
                            int i16 = composerStartRestartGroup.changed(jM11533getMainActiveControl0d7_KjU) ? 1048576 : 524288;
                            i5 |= i16;
                        } else {
                            jM11533getMainActiveControl0d7_KjU = j;
                        }
                        i5 |= i16;
                    } else {
                        jM11533getMainActiveControl0d7_KjU = j;
                    }
                    if ((i3 & 12582912) == 0) {
                        if ((i4 & 128) == 0) {
                            i14 = i5;
                            i11 = i15;
                            int i17 = composerStartRestartGroup.changed(j2) ? 8388608 : 4194304;
                            i10 = i14 | i17;
                        } else {
                            i14 = i5;
                            i11 = i15;
                        }
                        i10 = i14 | i17;
                    } else {
                        i10 = i5;
                        i11 = i15;
                    }
                    i12 = i10;
                    if ((i12 & 4793491) != 4793490) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z, i12 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "24@915L6,25@983L6");
                        if ((i3 & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            if (i11 != 0) {
                                textButtonItem2 = null;
                            }
                            if (i6 != 0) {
                                str2 = null;
                            }
                            if (i8 != 0) {
                                function1 = null;
                            }
                            if ((i4 & 64) != 0) {
                                jM11533getMainActiveControl0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                                i13 = i12 & (-3670017);
                            } else {
                                i13 = i12;
                            }
                            if ((i4 & 128) != 0) {
                                i13 &= -29360129;
                                j5 = jM11533getMainActiveControl0d7_KjU;
                                jM11533getMainActiveControl0d7_KjU2 = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                                str4 = str2;
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-543818861, i13, -1, "com.box.android.base.compose.dialog.BoxAlertDialog (BoxAlertDialog.kt:26)");
                            }
                            final String strStringResource = StringResources_androidKt.stringResource(i, composerStartRestartGroup, i13 & 14);
                            if (textButtonItem2 != null) {
                                positiveButton2 = new DialogButtonsConfig.PositiveAndNegativeButtons(positiveButton, textButtonItem2);
                            } else {
                                positiveButton2 = new DialogButtonsConfig.PositiveButton(positiveButton);
                            }
                            int i18 = ((i13 >> 15) & 14) | 12582960 | (57344 & i13);
                            int i19 = i13 << 6;
                            composer2 = composerStartRestartGroup;
                            BoxDialogKt.m11710BoxDialog0S3VyRs(function1, ComposableLambdaKt.rememberComposableLambda(-79680134, true, new Function2() { // from class: com.box.android.base.compose.dialog.BoxAlertDialogKt$$ExternalSyntheticLambda1
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return BoxAlertDialogKt.BoxAlertDialog_SxpAMN0$lambda$0(i2, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composerStartRestartGroup, 54), positiveButton2, null, str4, strStringResource, null, ComposableLambdaKt.rememberComposableLambda(-294007756, true, new Function2() { // from class: com.box.android.base.compose.dialog.BoxAlertDialogKt$$ExternalSyntheticLambda2
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return BoxAlertDialogKt.BoxAlertDialog_SxpAMN0$lambda$1(strStringResource, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composerStartRestartGroup, 54), j5, jM11533getMainActiveControl0d7_KjU2, composer2, i18 | (234881024 & i19) | (i19 & C.ENCODING_PCM_DOUBLE), 72);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            textButtonItem3 = textButtonItem2;
                            str3 = str4;
                            j3 = j5;
                            j4 = jM11533getMainActiveControl0d7_KjU2;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            i13 = (i4 & 64) != 0 ? i12 & (-3670017) : i12;
                            if ((i4 & 128) != 0) {
                                i13 &= -29360129;
                            }
                        }
                        jM11533getMainActiveControl0d7_KjU2 = j2;
                        str4 = str2;
                        j5 = jM11533getMainActiveControl0d7_KjU;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-543818861, i13, -1, "com.box.android.base.compose.dialog.BoxAlertDialog (BoxAlertDialog.kt:26)");
                        }
                        final String strStringResource2 = StringResources_androidKt.stringResource(i, composerStartRestartGroup, i13 & 14);
                        if (textButtonItem2 != null) {
                            positiveButton2 = new DialogButtonsConfig.PositiveAndNegativeButtons(positiveButton, textButtonItem2);
                        } else {
                            positiveButton2 = new DialogButtonsConfig.PositiveButton(positiveButton);
                        }
                        int i110 = ((i13 >> 15) & 14) | 12582960 | (57344 & i13);
                        int i111 = i13 << 6;
                        composer2 = composerStartRestartGroup;
                        BoxDialogKt.m11710BoxDialog0S3VyRs(function1, ComposableLambdaKt.rememberComposableLambda(-79680134, true, new Function2() { // from class: com.box.android.base.compose.dialog.BoxAlertDialogKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return BoxAlertDialogKt.BoxAlertDialog_SxpAMN0$lambda$0(i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54), positiveButton2, null, str4, strStringResource2, null, ComposableLambdaKt.rememberComposableLambda(-294007756, true, new Function2() { // from class: com.box.android.base.compose.dialog.BoxAlertDialogKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return BoxAlertDialogKt.BoxAlertDialog_SxpAMN0$lambda$1(strStringResource2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54), j5, jM11533getMainActiveControl0d7_KjU2, composer2, i110 | (234881024 & i111) | (i111 & C.ENCODING_PCM_DOUBLE), 72);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        textButtonItem3 = textButtonItem2;
                        str3 = str4;
                        j3 = j5;
                        j4 = jM11533getMainActiveControl0d7_KjU2;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        textButtonItem3 = textButtonItem2;
                        str3 = str2;
                        j3 = jM11533getMainActiveControl0d7_KjU;
                        j4 = j2;
                    }
                    function2 = function1;
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.dialog.BoxAlertDialogKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return BoxAlertDialogKt.BoxAlertDialog_SxpAMN0$lambda$2(i, i2, positiveButton, textButtonItem3, str3, function2, j3, j4, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                function1 = function0;
                if ((1572864 & i3) == 0) {
                    if ((i4 & 64) == 0) {
                        jM11533getMainActiveControl0d7_KjU = j;
                        if (composerStartRestartGroup.changed(jM11533getMainActiveControl0d7_KjU)) {
                        }
                        i5 |= i16;
                    } else {
                        jM11533getMainActiveControl0d7_KjU = j;
                    }
                    i5 |= i16;
                } else {
                    jM11533getMainActiveControl0d7_KjU = j;
                }
                if ((i3 & 12582912) == 0) {
                    if ((i4 & 128) == 0) {
                        i14 = i5;
                        i11 = i15;
                        if (composerStartRestartGroup.changed(j2)) {
                        }
                        i10 = i14 | i17;
                    } else {
                        i14 = i5;
                        i11 = i15;
                    }
                    i10 = i14 | i17;
                } else {
                    i10 = i5;
                    i11 = i15;
                }
                i12 = i10;
                if ((i12 & 4793491) != 4793490) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i12 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "24@915L6,25@983L6");
                    if ((i3 & 1) != 0) {
                        if (i11 != 0) {
                            textButtonItem2 = null;
                        }
                        if (i6 != 0) {
                            str2 = null;
                        }
                        if (i8 != 0) {
                            function1 = null;
                        }
                        if ((i4 & 64) != 0) {
                            jM11533getMainActiveControl0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                            i13 = i12 & (-3670017);
                        } else {
                            i13 = i12;
                        }
                        if ((i4 & 128) != 0) {
                            i13 &= -29360129;
                            j5 = jM11533getMainActiveControl0d7_KjU;
                            jM11533getMainActiveControl0d7_KjU2 = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                            str4 = str2;
                        } else {
                            jM11533getMainActiveControl0d7_KjU2 = j2;
                            str4 = str2;
                            j5 = jM11533getMainActiveControl0d7_KjU;
                        }
                    } else {
                        if (i11 != 0) {
                            textButtonItem2 = null;
                        }
                        if (i6 != 0) {
                            str2 = null;
                        }
                        if (i8 != 0) {
                            function1 = null;
                        }
                        if ((i4 & 64) != 0) {
                            jM11533getMainActiveControl0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                            i13 = i12 & (-3670017);
                        } else {
                            i13 = i12;
                        }
                        if ((i4 & 128) != 0) {
                            i13 &= -29360129;
                            j5 = jM11533getMainActiveControl0d7_KjU;
                            jM11533getMainActiveControl0d7_KjU2 = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                            str4 = str2;
                        } else {
                            jM11533getMainActiveControl0d7_KjU2 = j2;
                            str4 = str2;
                            j5 = jM11533getMainActiveControl0d7_KjU;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-543818861, i13, -1, "com.box.android.base.compose.dialog.BoxAlertDialog (BoxAlertDialog.kt:26)");
                    }
                    final String strStringResource3 = StringResources_androidKt.stringResource(i, composerStartRestartGroup, i13 & 14);
                    if (textButtonItem2 != null) {
                        positiveButton2 = new DialogButtonsConfig.PositiveAndNegativeButtons(positiveButton, textButtonItem2);
                    } else {
                        positiveButton2 = new DialogButtonsConfig.PositiveButton(positiveButton);
                    }
                    int i112 = ((i13 >> 15) & 14) | 12582960 | (57344 & i13);
                    int i113 = i13 << 6;
                    composer2 = composerStartRestartGroup;
                    BoxDialogKt.m11710BoxDialog0S3VyRs(function1, ComposableLambdaKt.rememberComposableLambda(-79680134, true, new Function2() { // from class: com.box.android.base.compose.dialog.BoxAlertDialogKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return BoxAlertDialogKt.BoxAlertDialog_SxpAMN0$lambda$0(i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), positiveButton2, null, str4, strStringResource3, null, ComposableLambdaKt.rememberComposableLambda(-294007756, true, new Function2() { // from class: com.box.android.base.compose.dialog.BoxAlertDialogKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return BoxAlertDialogKt.BoxAlertDialog_SxpAMN0$lambda$1(strStringResource3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), j5, jM11533getMainActiveControl0d7_KjU2, composer2, i112 | (234881024 & i113) | (i113 & C.ENCODING_PCM_DOUBLE), 72);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    textButtonItem3 = textButtonItem2;
                    str3 = str4;
                    j3 = j5;
                    j4 = jM11533getMainActiveControl0d7_KjU2;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    textButtonItem3 = textButtonItem2;
                    str3 = str2;
                    j3 = jM11533getMainActiveControl0d7_KjU;
                    j4 = j2;
                }
                function2 = function1;
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.dialog.BoxAlertDialogKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return BoxAlertDialogKt.BoxAlertDialog_SxpAMN0$lambda$2(i, i2, positiveButton, textButtonItem3, str3, function2, j3, j4, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i5 |= 24576;
            str2 = str;
            i8 = i4 & 32;
            if (i8 != 0) {
                if ((196608 & i3) == 0) {
                    function1 = function0;
                    if (composerStartRestartGroup.changedInstance(function1)) {
                        i9 = 131072;
                    } else {
                        i9 = 65536;
                    }
                    i5 |= i9;
                }
                if ((1572864 & i3) == 0) {
                    if ((i4 & 64) == 0) {
                        jM11533getMainActiveControl0d7_KjU = j;
                        if (composerStartRestartGroup.changed(jM11533getMainActiveControl0d7_KjU)) {
                        }
                        i5 |= i16;
                    } else {
                        jM11533getMainActiveControl0d7_KjU = j;
                    }
                    i5 |= i16;
                } else {
                    jM11533getMainActiveControl0d7_KjU = j;
                }
                if ((i3 & 12582912) == 0) {
                    if ((i4 & 128) == 0) {
                        i14 = i5;
                        i11 = i15;
                        if (composerStartRestartGroup.changed(j2)) {
                        }
                        i10 = i14 | i17;
                    } else {
                        i14 = i5;
                        i11 = i15;
                    }
                    i10 = i14 | i17;
                } else {
                    i10 = i5;
                    i11 = i15;
                }
                i12 = i10;
                if ((i12 & 4793491) != 4793490) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i12 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "24@915L6,25@983L6");
                    if ((i3 & 1) != 0) {
                        if (i11 != 0) {
                            textButtonItem2 = null;
                        }
                        if (i6 != 0) {
                            str2 = null;
                        }
                        if (i8 != 0) {
                            function1 = null;
                        }
                        if ((i4 & 64) != 0) {
                            jM11533getMainActiveControl0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                            i13 = i12 & (-3670017);
                        } else {
                            i13 = i12;
                        }
                        if ((i4 & 128) != 0) {
                            i13 &= -29360129;
                            j5 = jM11533getMainActiveControl0d7_KjU;
                            jM11533getMainActiveControl0d7_KjU2 = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                            str4 = str2;
                        } else {
                            jM11533getMainActiveControl0d7_KjU2 = j2;
                            str4 = str2;
                            j5 = jM11533getMainActiveControl0d7_KjU;
                        }
                    } else {
                        if (i11 != 0) {
                            textButtonItem2 = null;
                        }
                        if (i6 != 0) {
                            str2 = null;
                        }
                        if (i8 != 0) {
                            function1 = null;
                        }
                        if ((i4 & 64) != 0) {
                            jM11533getMainActiveControl0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                            i13 = i12 & (-3670017);
                        } else {
                            i13 = i12;
                        }
                        if ((i4 & 128) != 0) {
                            i13 &= -29360129;
                            j5 = jM11533getMainActiveControl0d7_KjU;
                            jM11533getMainActiveControl0d7_KjU2 = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                            str4 = str2;
                        } else {
                            jM11533getMainActiveControl0d7_KjU2 = j2;
                            str4 = str2;
                            j5 = jM11533getMainActiveControl0d7_KjU;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-543818861, i13, -1, "com.box.android.base.compose.dialog.BoxAlertDialog (BoxAlertDialog.kt:26)");
                    }
                    final String strStringResource4 = StringResources_androidKt.stringResource(i, composerStartRestartGroup, i13 & 14);
                    if (textButtonItem2 != null) {
                        positiveButton2 = new DialogButtonsConfig.PositiveAndNegativeButtons(positiveButton, textButtonItem2);
                    } else {
                        positiveButton2 = new DialogButtonsConfig.PositiveButton(positiveButton);
                    }
                    int i114 = ((i13 >> 15) & 14) | 12582960 | (57344 & i13);
                    int i115 = i13 << 6;
                    composer2 = composerStartRestartGroup;
                    BoxDialogKt.m11710BoxDialog0S3VyRs(function1, ComposableLambdaKt.rememberComposableLambda(-79680134, true, new Function2() { // from class: com.box.android.base.compose.dialog.BoxAlertDialogKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return BoxAlertDialogKt.BoxAlertDialog_SxpAMN0$lambda$0(i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), positiveButton2, null, str4, strStringResource4, null, ComposableLambdaKt.rememberComposableLambda(-294007756, true, new Function2() { // from class: com.box.android.base.compose.dialog.BoxAlertDialogKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return BoxAlertDialogKt.BoxAlertDialog_SxpAMN0$lambda$1(strStringResource4, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), j5, jM11533getMainActiveControl0d7_KjU2, composer2, i114 | (234881024 & i115) | (i115 & C.ENCODING_PCM_DOUBLE), 72);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    textButtonItem3 = textButtonItem2;
                    str3 = str4;
                    j3 = j5;
                    j4 = jM11533getMainActiveControl0d7_KjU2;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    textButtonItem3 = textButtonItem2;
                    str3 = str2;
                    j3 = jM11533getMainActiveControl0d7_KjU;
                    j4 = j2;
                }
                function2 = function1;
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.dialog.BoxAlertDialogKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return BoxAlertDialogKt.BoxAlertDialog_SxpAMN0$lambda$2(i, i2, positiveButton, textButtonItem3, str3, function2, j3, j4, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            function1 = function0;
            if ((1572864 & i3) == 0) {
                if ((i4 & 64) == 0) {
                    jM11533getMainActiveControl0d7_KjU = j;
                    if (composerStartRestartGroup.changed(jM11533getMainActiveControl0d7_KjU)) {
                    }
                    i5 |= i16;
                } else {
                    jM11533getMainActiveControl0d7_KjU = j;
                }
                i5 |= i16;
            } else {
                jM11533getMainActiveControl0d7_KjU = j;
            }
            if ((i3 & 12582912) == 0) {
                if ((i4 & 128) == 0) {
                    i14 = i5;
                    i11 = i15;
                    if (composerStartRestartGroup.changed(j2)) {
                    }
                    i10 = i14 | i17;
                } else {
                    i14 = i5;
                    i11 = i15;
                }
                i10 = i14 | i17;
            } else {
                i10 = i5;
                i11 = i15;
            }
            i12 = i10;
            if ((i12 & 4793491) != 4793490) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i12 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "24@915L6,25@983L6");
                if ((i3 & 1) != 0) {
                    if (i11 != 0) {
                        textButtonItem2 = null;
                    }
                    if (i6 != 0) {
                        str2 = null;
                    }
                    if (i8 != 0) {
                        function1 = null;
                    }
                    if ((i4 & 64) != 0) {
                        jM11533getMainActiveControl0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                        i13 = i12 & (-3670017);
                    } else {
                        i13 = i12;
                    }
                    if ((i4 & 128) != 0) {
                        i13 &= -29360129;
                        j5 = jM11533getMainActiveControl0d7_KjU;
                        jM11533getMainActiveControl0d7_KjU2 = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                        str4 = str2;
                    } else {
                        jM11533getMainActiveControl0d7_KjU2 = j2;
                        str4 = str2;
                        j5 = jM11533getMainActiveControl0d7_KjU;
                    }
                } else {
                    if (i11 != 0) {
                        textButtonItem2 = null;
                    }
                    if (i6 != 0) {
                        str2 = null;
                    }
                    if (i8 != 0) {
                        function1 = null;
                    }
                    if ((i4 & 64) != 0) {
                        jM11533getMainActiveControl0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                        i13 = i12 & (-3670017);
                    } else {
                        i13 = i12;
                    }
                    if ((i4 & 128) != 0) {
                        i13 &= -29360129;
                        j5 = jM11533getMainActiveControl0d7_KjU;
                        jM11533getMainActiveControl0d7_KjU2 = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                        str4 = str2;
                    } else {
                        jM11533getMainActiveControl0d7_KjU2 = j2;
                        str4 = str2;
                        j5 = jM11533getMainActiveControl0d7_KjU;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-543818861, i13, -1, "com.box.android.base.compose.dialog.BoxAlertDialog (BoxAlertDialog.kt:26)");
                }
                final String strStringResource5 = StringResources_androidKt.stringResource(i, composerStartRestartGroup, i13 & 14);
                if (textButtonItem2 != null) {
                    positiveButton2 = new DialogButtonsConfig.PositiveAndNegativeButtons(positiveButton, textButtonItem2);
                } else {
                    positiveButton2 = new DialogButtonsConfig.PositiveButton(positiveButton);
                }
                int i116 = ((i13 >> 15) & 14) | 12582960 | (57344 & i13);
                int i117 = i13 << 6;
                composer2 = composerStartRestartGroup;
                BoxDialogKt.m11710BoxDialog0S3VyRs(function1, ComposableLambdaKt.rememberComposableLambda(-79680134, true, new Function2() { // from class: com.box.android.base.compose.dialog.BoxAlertDialogKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return BoxAlertDialogKt.BoxAlertDialog_SxpAMN0$lambda$0(i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), positiveButton2, null, str4, strStringResource5, null, ComposableLambdaKt.rememberComposableLambda(-294007756, true, new Function2() { // from class: com.box.android.base.compose.dialog.BoxAlertDialogKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return BoxAlertDialogKt.BoxAlertDialog_SxpAMN0$lambda$1(strStringResource5, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), j5, jM11533getMainActiveControl0d7_KjU2, composer2, i116 | (234881024 & i117) | (i117 & C.ENCODING_PCM_DOUBLE), 72);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                textButtonItem3 = textButtonItem2;
                str3 = str4;
                j3 = j5;
                j4 = jM11533getMainActiveControl0d7_KjU2;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                textButtonItem3 = textButtonItem2;
                str3 = str2;
                j3 = jM11533getMainActiveControl0d7_KjU;
                j4 = j2;
            }
            function2 = function1;
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.dialog.BoxAlertDialogKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return BoxAlertDialogKt.BoxAlertDialog_SxpAMN0$lambda$2(i, i2, positiveButton, textButtonItem3, str3, function2, j3, j4, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i5 |= 3072;
        textButtonItem2 = textButtonItem;
        i6 = i4 & 16;
        if (i6 != 0) {
            if ((i3 & 24576) == 0) {
                str2 = str;
                if (composerStartRestartGroup.changed(str2)) {
                    i7 = 16384;
                } else {
                    i7 = 8192;
                }
                i5 |= i7;
            }
            i8 = i4 & 32;
            if (i8 != 0) {
                if ((196608 & i3) == 0) {
                    function1 = function0;
                    if (composerStartRestartGroup.changedInstance(function1)) {
                        i9 = 131072;
                    } else {
                        i9 = 65536;
                    }
                    i5 |= i9;
                }
                if ((1572864 & i3) == 0) {
                    if ((i4 & 64) == 0) {
                        jM11533getMainActiveControl0d7_KjU = j;
                        if (composerStartRestartGroup.changed(jM11533getMainActiveControl0d7_KjU)) {
                        }
                        i5 |= i16;
                    } else {
                        jM11533getMainActiveControl0d7_KjU = j;
                    }
                    i5 |= i16;
                } else {
                    jM11533getMainActiveControl0d7_KjU = j;
                }
                if ((i3 & 12582912) == 0) {
                    if ((i4 & 128) == 0) {
                        i14 = i5;
                        i11 = i15;
                        if (composerStartRestartGroup.changed(j2)) {
                        }
                        i10 = i14 | i17;
                    } else {
                        i14 = i5;
                        i11 = i15;
                    }
                    i10 = i14 | i17;
                } else {
                    i10 = i5;
                    i11 = i15;
                }
                i12 = i10;
                if ((i12 & 4793491) != 4793490) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i12 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "24@915L6,25@983L6");
                    if ((i3 & 1) != 0) {
                        if (i11 != 0) {
                            textButtonItem2 = null;
                        }
                        if (i6 != 0) {
                            str2 = null;
                        }
                        if (i8 != 0) {
                            function1 = null;
                        }
                        if ((i4 & 64) != 0) {
                            jM11533getMainActiveControl0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                            i13 = i12 & (-3670017);
                        } else {
                            i13 = i12;
                        }
                        if ((i4 & 128) != 0) {
                            i13 &= -29360129;
                            j5 = jM11533getMainActiveControl0d7_KjU;
                            jM11533getMainActiveControl0d7_KjU2 = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                            str4 = str2;
                        } else {
                            jM11533getMainActiveControl0d7_KjU2 = j2;
                            str4 = str2;
                            j5 = jM11533getMainActiveControl0d7_KjU;
                        }
                    } else {
                        if (i11 != 0) {
                            textButtonItem2 = null;
                        }
                        if (i6 != 0) {
                            str2 = null;
                        }
                        if (i8 != 0) {
                            function1 = null;
                        }
                        if ((i4 & 64) != 0) {
                            jM11533getMainActiveControl0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                            i13 = i12 & (-3670017);
                        } else {
                            i13 = i12;
                        }
                        if ((i4 & 128) != 0) {
                            i13 &= -29360129;
                            j5 = jM11533getMainActiveControl0d7_KjU;
                            jM11533getMainActiveControl0d7_KjU2 = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                            str4 = str2;
                        } else {
                            jM11533getMainActiveControl0d7_KjU2 = j2;
                            str4 = str2;
                            j5 = jM11533getMainActiveControl0d7_KjU;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-543818861, i13, -1, "com.box.android.base.compose.dialog.BoxAlertDialog (BoxAlertDialog.kt:26)");
                    }
                    final String strStringResource6 = StringResources_androidKt.stringResource(i, composerStartRestartGroup, i13 & 14);
                    if (textButtonItem2 != null) {
                        positiveButton2 = new DialogButtonsConfig.PositiveAndNegativeButtons(positiveButton, textButtonItem2);
                    } else {
                        positiveButton2 = new DialogButtonsConfig.PositiveButton(positiveButton);
                    }
                    int i118 = ((i13 >> 15) & 14) | 12582960 | (57344 & i13);
                    int i119 = i13 << 6;
                    composer2 = composerStartRestartGroup;
                    BoxDialogKt.m11710BoxDialog0S3VyRs(function1, ComposableLambdaKt.rememberComposableLambda(-79680134, true, new Function2() { // from class: com.box.android.base.compose.dialog.BoxAlertDialogKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return BoxAlertDialogKt.BoxAlertDialog_SxpAMN0$lambda$0(i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), positiveButton2, null, str4, strStringResource6, null, ComposableLambdaKt.rememberComposableLambda(-294007756, true, new Function2() { // from class: com.box.android.base.compose.dialog.BoxAlertDialogKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return BoxAlertDialogKt.BoxAlertDialog_SxpAMN0$lambda$1(strStringResource6, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), j5, jM11533getMainActiveControl0d7_KjU2, composer2, i118 | (234881024 & i119) | (i119 & C.ENCODING_PCM_DOUBLE), 72);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    textButtonItem3 = textButtonItem2;
                    str3 = str4;
                    j3 = j5;
                    j4 = jM11533getMainActiveControl0d7_KjU2;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    textButtonItem3 = textButtonItem2;
                    str3 = str2;
                    j3 = jM11533getMainActiveControl0d7_KjU;
                    j4 = j2;
                }
                function2 = function1;
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.dialog.BoxAlertDialogKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return BoxAlertDialogKt.BoxAlertDialog_SxpAMN0$lambda$2(i, i2, positiveButton, textButtonItem3, str3, function2, j3, j4, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            function1 = function0;
            if ((1572864 & i3) == 0) {
                if ((i4 & 64) == 0) {
                    jM11533getMainActiveControl0d7_KjU = j;
                    if (composerStartRestartGroup.changed(jM11533getMainActiveControl0d7_KjU)) {
                    }
                    i5 |= i16;
                } else {
                    jM11533getMainActiveControl0d7_KjU = j;
                }
                i5 |= i16;
            } else {
                jM11533getMainActiveControl0d7_KjU = j;
            }
            if ((i3 & 12582912) == 0) {
                if ((i4 & 128) == 0) {
                    i14 = i5;
                    i11 = i15;
                    if (composerStartRestartGroup.changed(j2)) {
                    }
                    i10 = i14 | i17;
                } else {
                    i14 = i5;
                    i11 = i15;
                }
                i10 = i14 | i17;
            } else {
                i10 = i5;
                i11 = i15;
            }
            i12 = i10;
            if ((i12 & 4793491) != 4793490) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i12 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "24@915L6,25@983L6");
                if ((i3 & 1) != 0) {
                    if (i11 != 0) {
                        textButtonItem2 = null;
                    }
                    if (i6 != 0) {
                        str2 = null;
                    }
                    if (i8 != 0) {
                        function1 = null;
                    }
                    if ((i4 & 64) != 0) {
                        jM11533getMainActiveControl0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                        i13 = i12 & (-3670017);
                    } else {
                        i13 = i12;
                    }
                    if ((i4 & 128) != 0) {
                        i13 &= -29360129;
                        j5 = jM11533getMainActiveControl0d7_KjU;
                        jM11533getMainActiveControl0d7_KjU2 = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                        str4 = str2;
                    } else {
                        jM11533getMainActiveControl0d7_KjU2 = j2;
                        str4 = str2;
                        j5 = jM11533getMainActiveControl0d7_KjU;
                    }
                } else {
                    if (i11 != 0) {
                        textButtonItem2 = null;
                    }
                    if (i6 != 0) {
                        str2 = null;
                    }
                    if (i8 != 0) {
                        function1 = null;
                    }
                    if ((i4 & 64) != 0) {
                        jM11533getMainActiveControl0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                        i13 = i12 & (-3670017);
                    } else {
                        i13 = i12;
                    }
                    if ((i4 & 128) != 0) {
                        i13 &= -29360129;
                        j5 = jM11533getMainActiveControl0d7_KjU;
                        jM11533getMainActiveControl0d7_KjU2 = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                        str4 = str2;
                    } else {
                        jM11533getMainActiveControl0d7_KjU2 = j2;
                        str4 = str2;
                        j5 = jM11533getMainActiveControl0d7_KjU;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-543818861, i13, -1, "com.box.android.base.compose.dialog.BoxAlertDialog (BoxAlertDialog.kt:26)");
                }
                final String strStringResource7 = StringResources_androidKt.stringResource(i, composerStartRestartGroup, i13 & 14);
                if (textButtonItem2 != null) {
                    positiveButton2 = new DialogButtonsConfig.PositiveAndNegativeButtons(positiveButton, textButtonItem2);
                } else {
                    positiveButton2 = new DialogButtonsConfig.PositiveButton(positiveButton);
                }
                int i1110 = ((i13 >> 15) & 14) | 12582960 | (57344 & i13);
                int i1111 = i13 << 6;
                composer2 = composerStartRestartGroup;
                BoxDialogKt.m11710BoxDialog0S3VyRs(function1, ComposableLambdaKt.rememberComposableLambda(-79680134, true, new Function2() { // from class: com.box.android.base.compose.dialog.BoxAlertDialogKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return BoxAlertDialogKt.BoxAlertDialog_SxpAMN0$lambda$0(i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), positiveButton2, null, str4, strStringResource7, null, ComposableLambdaKt.rememberComposableLambda(-294007756, true, new Function2() { // from class: com.box.android.base.compose.dialog.BoxAlertDialogKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return BoxAlertDialogKt.BoxAlertDialog_SxpAMN0$lambda$1(strStringResource7, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), j5, jM11533getMainActiveControl0d7_KjU2, composer2, i1110 | (234881024 & i1111) | (i1111 & C.ENCODING_PCM_DOUBLE), 72);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                textButtonItem3 = textButtonItem2;
                str3 = str4;
                j3 = j5;
                j4 = jM11533getMainActiveControl0d7_KjU2;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                textButtonItem3 = textButtonItem2;
                str3 = str2;
                j3 = jM11533getMainActiveControl0d7_KjU;
                j4 = j2;
            }
            function2 = function1;
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.dialog.BoxAlertDialogKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return BoxAlertDialogKt.BoxAlertDialog_SxpAMN0$lambda$2(i, i2, positiveButton, textButtonItem3, str3, function2, j3, j4, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i5 |= 24576;
        str2 = str;
        i8 = i4 & 32;
        if (i8 != 0) {
            if ((196608 & i3) == 0) {
                function1 = function0;
                if (composerStartRestartGroup.changedInstance(function1)) {
                    i9 = 131072;
                } else {
                    i9 = 65536;
                }
                i5 |= i9;
            }
            if ((1572864 & i3) == 0) {
                if ((i4 & 64) == 0) {
                    jM11533getMainActiveControl0d7_KjU = j;
                    if (composerStartRestartGroup.changed(jM11533getMainActiveControl0d7_KjU)) {
                    }
                    i5 |= i16;
                } else {
                    jM11533getMainActiveControl0d7_KjU = j;
                }
                i5 |= i16;
            } else {
                jM11533getMainActiveControl0d7_KjU = j;
            }
            if ((i3 & 12582912) == 0) {
                if ((i4 & 128) == 0) {
                    i14 = i5;
                    i11 = i15;
                    if (composerStartRestartGroup.changed(j2)) {
                    }
                    i10 = i14 | i17;
                } else {
                    i14 = i5;
                    i11 = i15;
                }
                i10 = i14 | i17;
            } else {
                i10 = i5;
                i11 = i15;
            }
            i12 = i10;
            if ((i12 & 4793491) != 4793490) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i12 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "24@915L6,25@983L6");
                if ((i3 & 1) != 0) {
                    if (i11 != 0) {
                        textButtonItem2 = null;
                    }
                    if (i6 != 0) {
                        str2 = null;
                    }
                    if (i8 != 0) {
                        function1 = null;
                    }
                    if ((i4 & 64) != 0) {
                        jM11533getMainActiveControl0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                        i13 = i12 & (-3670017);
                    } else {
                        i13 = i12;
                    }
                    if ((i4 & 128) != 0) {
                        i13 &= -29360129;
                        j5 = jM11533getMainActiveControl0d7_KjU;
                        jM11533getMainActiveControl0d7_KjU2 = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                        str4 = str2;
                    } else {
                        jM11533getMainActiveControl0d7_KjU2 = j2;
                        str4 = str2;
                        j5 = jM11533getMainActiveControl0d7_KjU;
                    }
                } else {
                    if (i11 != 0) {
                        textButtonItem2 = null;
                    }
                    if (i6 != 0) {
                        str2 = null;
                    }
                    if (i8 != 0) {
                        function1 = null;
                    }
                    if ((i4 & 64) != 0) {
                        jM11533getMainActiveControl0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                        i13 = i12 & (-3670017);
                    } else {
                        i13 = i12;
                    }
                    if ((i4 & 128) != 0) {
                        i13 &= -29360129;
                        j5 = jM11533getMainActiveControl0d7_KjU;
                        jM11533getMainActiveControl0d7_KjU2 = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                        str4 = str2;
                    } else {
                        jM11533getMainActiveControl0d7_KjU2 = j2;
                        str4 = str2;
                        j5 = jM11533getMainActiveControl0d7_KjU;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-543818861, i13, -1, "com.box.android.base.compose.dialog.BoxAlertDialog (BoxAlertDialog.kt:26)");
                }
                final String strStringResource8 = StringResources_androidKt.stringResource(i, composerStartRestartGroup, i13 & 14);
                if (textButtonItem2 != null) {
                    positiveButton2 = new DialogButtonsConfig.PositiveAndNegativeButtons(positiveButton, textButtonItem2);
                } else {
                    positiveButton2 = new DialogButtonsConfig.PositiveButton(positiveButton);
                }
                int i1112 = ((i13 >> 15) & 14) | 12582960 | (57344 & i13);
                int i1113 = i13 << 6;
                composer2 = composerStartRestartGroup;
                BoxDialogKt.m11710BoxDialog0S3VyRs(function1, ComposableLambdaKt.rememberComposableLambda(-79680134, true, new Function2() { // from class: com.box.android.base.compose.dialog.BoxAlertDialogKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return BoxAlertDialogKt.BoxAlertDialog_SxpAMN0$lambda$0(i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), positiveButton2, null, str4, strStringResource8, null, ComposableLambdaKt.rememberComposableLambda(-294007756, true, new Function2() { // from class: com.box.android.base.compose.dialog.BoxAlertDialogKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return BoxAlertDialogKt.BoxAlertDialog_SxpAMN0$lambda$1(strStringResource8, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), j5, jM11533getMainActiveControl0d7_KjU2, composer2, i1112 | (234881024 & i1113) | (i1113 & C.ENCODING_PCM_DOUBLE), 72);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                textButtonItem3 = textButtonItem2;
                str3 = str4;
                j3 = j5;
                j4 = jM11533getMainActiveControl0d7_KjU2;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                textButtonItem3 = textButtonItem2;
                str3 = str2;
                j3 = jM11533getMainActiveControl0d7_KjU;
                j4 = j2;
            }
            function2 = function1;
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.dialog.BoxAlertDialogKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return BoxAlertDialogKt.BoxAlertDialog_SxpAMN0$lambda$2(i, i2, positiveButton, textButtonItem3, str3, function2, j3, j4, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        function1 = function0;
        if ((1572864 & i3) == 0) {
            if ((i4 & 64) == 0) {
                jM11533getMainActiveControl0d7_KjU = j;
                if (composerStartRestartGroup.changed(jM11533getMainActiveControl0d7_KjU)) {
                }
                i5 |= i16;
            } else {
                jM11533getMainActiveControl0d7_KjU = j;
            }
            i5 |= i16;
        } else {
            jM11533getMainActiveControl0d7_KjU = j;
        }
        if ((i3 & 12582912) == 0) {
            if ((i4 & 128) == 0) {
                i14 = i5;
                i11 = i15;
                if (composerStartRestartGroup.changed(j2)) {
                }
                i10 = i14 | i17;
            } else {
                i14 = i5;
                i11 = i15;
            }
            i10 = i14 | i17;
        } else {
            i10 = i5;
            i11 = i15;
        }
        i12 = i10;
        if ((i12 & 4793491) != 4793490) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i12 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "24@915L6,25@983L6");
            if ((i3 & 1) != 0) {
                if (i11 != 0) {
                    textButtonItem2 = null;
                }
                if (i6 != 0) {
                    str2 = null;
                }
                if (i8 != 0) {
                    function1 = null;
                }
                if ((i4 & 64) != 0) {
                    jM11533getMainActiveControl0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                    i13 = i12 & (-3670017);
                } else {
                    i13 = i12;
                }
                if ((i4 & 128) != 0) {
                    i13 &= -29360129;
                    j5 = jM11533getMainActiveControl0d7_KjU;
                    jM11533getMainActiveControl0d7_KjU2 = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                    str4 = str2;
                } else {
                    jM11533getMainActiveControl0d7_KjU2 = j2;
                    str4 = str2;
                    j5 = jM11533getMainActiveControl0d7_KjU;
                }
            } else {
                if (i11 != 0) {
                    textButtonItem2 = null;
                }
                if (i6 != 0) {
                    str2 = null;
                }
                if (i8 != 0) {
                    function1 = null;
                }
                if ((i4 & 64) != 0) {
                    jM11533getMainActiveControl0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                    i13 = i12 & (-3670017);
                } else {
                    i13 = i12;
                }
                if ((i4 & 128) != 0) {
                    i13 &= -29360129;
                    j5 = jM11533getMainActiveControl0d7_KjU;
                    jM11533getMainActiveControl0d7_KjU2 = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                    str4 = str2;
                } else {
                    jM11533getMainActiveControl0d7_KjU2 = j2;
                    str4 = str2;
                    j5 = jM11533getMainActiveControl0d7_KjU;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-543818861, i13, -1, "com.box.android.base.compose.dialog.BoxAlertDialog (BoxAlertDialog.kt:26)");
            }
            final String strStringResource9 = StringResources_androidKt.stringResource(i, composerStartRestartGroup, i13 & 14);
            if (textButtonItem2 != null) {
                positiveButton2 = new DialogButtonsConfig.PositiveAndNegativeButtons(positiveButton, textButtonItem2);
            } else {
                positiveButton2 = new DialogButtonsConfig.PositiveButton(positiveButton);
            }
            int i1114 = ((i13 >> 15) & 14) | 12582960 | (57344 & i13);
            int i1115 = i13 << 6;
            composer2 = composerStartRestartGroup;
            BoxDialogKt.m11710BoxDialog0S3VyRs(function1, ComposableLambdaKt.rememberComposableLambda(-79680134, true, new Function2() { // from class: com.box.android.base.compose.dialog.BoxAlertDialogKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BoxAlertDialogKt.BoxAlertDialog_SxpAMN0$lambda$0(i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), positiveButton2, null, str4, strStringResource9, null, ComposableLambdaKt.rememberComposableLambda(-294007756, true, new Function2() { // from class: com.box.android.base.compose.dialog.BoxAlertDialogKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BoxAlertDialogKt.BoxAlertDialog_SxpAMN0$lambda$1(strStringResource9, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), j5, jM11533getMainActiveControl0d7_KjU2, composer2, i1114 | (234881024 & i1115) | (i1115 & C.ENCODING_PCM_DOUBLE), 72);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            textButtonItem3 = textButtonItem2;
            str3 = str4;
            j3 = j5;
            j4 = jM11533getMainActiveControl0d7_KjU2;
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            textButtonItem3 = textButtonItem2;
            str3 = str2;
            j3 = jM11533getMainActiveControl0d7_KjU;
            j4 = j2;
        }
        function2 = function1;
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.dialog.BoxAlertDialogKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BoxAlertDialogKt.BoxAlertDialog_SxpAMN0$lambda$2(i, i2, positiveButton, textButtonItem3, str3, function2, j3, j4, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxAlertDialog_SxpAMN0$lambda$1(String str, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C40@1426L114:BoxAlertDialog.kt#fwd9q");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-294007756, i, -1, "com.box.android.base.compose.dialog.BoxAlertDialog.<anonymous> (BoxAlertDialog.kt:40)");
            }
            TextKt.m4494TextNvy7gAk(str, TestTagKt.testTag(Modifier.INSTANCE, "BoxDialogTitle"), 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 48, 0, 262140);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxAlertDialog_SxpAMN0$lambda$0(int i, Composer composer, int i2) {
        ComposerKt.sourceInformation(composer, "C47@1613L25,46@1584L130:BoxAlertDialog.kt#fwd9q");
        if (!composer.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-79680134, i2, -1, "com.box.android.base.compose.dialog.BoxAlertDialog.<anonymous> (BoxAlertDialog.kt:46)");
            }
            TextKt.m4494TextNvy7gAk(StringResources_androidKt.stringResource(i, composer, 0), TestTagKt.testTag(Modifier.INSTANCE, "BoxDialogText"), 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 48, 0, 262140);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    private static final void BoxAlertDialogPreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(1507476724);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BoxAlertDialogPreview)64@2047L462:BoxAlertDialog.kt#fwd9q");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1507476724, i, -1, "com.box.android.base.compose.dialog.BoxAlertDialogPreview (BoxAlertDialog.kt:63)");
            }
            BoxThemeKt.BoxTheme(ComposableSingletons$BoxAlertDialogKt.INSTANCE.getLambda$1358145865$base_generalProdRelease(), composerStartRestartGroup, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.dialog.BoxAlertDialogKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BoxAlertDialogKt.BoxAlertDialogPreview$lambda$0(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}
