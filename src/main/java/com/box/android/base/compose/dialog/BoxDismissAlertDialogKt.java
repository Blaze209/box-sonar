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

/* JADX INFO: compiled from: BoxDismissAlertDialog.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\\\u0010\u0000\u001a\u00020\u00012\b\b\u0001\u0010\u0002\u001a\u00020\u00032\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u00062\u0006\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00052\b\b\u0002\u0010\f\u001a\u00020\rH\u0007¢\u0006\u0004\b\u000e\u0010\u000f\u001a\r\u0010\u0010\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u0011¨\u0006\u0012"}, d2 = {"BoxDismissAlertDialog", "", "title", "", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "negativeButton", "Lcom/box/android/base/compose/button/model/ButtonItem$TextButtonItem;", ComposeIdentificationData.FIELD_TEST_TAG_HASHED, "", StackScreenDismissEvent.EVENT_REGISTRATION_NAME, "negativeButtonColor", "Landroidx/compose/ui/graphics/Color;", "BoxDismissAlertDialog-V-9fs2A", "(ILkotlin/jvm/functions/Function2;Lcom/box/android/base/compose/button/model/ButtonItem$TextButtonItem;Ljava/lang/String;Lkotlin/jvm/functions/Function0;JLandroidx/compose/runtime/Composer;II)V", "BoxDismissAlertDialogPreview", "(Landroidx/compose/runtime/Composer;I)V", "base_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class BoxDismissAlertDialogKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxDismissAlertDialogPreview$lambda$0(int i, Composer composer, int i2) {
        BoxDismissAlertDialogPreview(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxDismissAlertDialog_V_9fs2A$lambda$1(int i, Function2 function2, ButtonItem.TextButtonItem textButtonItem, String str, Function0 function0, long j, int i2, int i3, Composer composer, int i4) {
        m11712BoxDismissAlertDialogV9fs2A(i, function2, textButtonItem, str, function0, j, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:37:0x0070  */
    /* JADX WARN: Code duplicated, block: B:38:0x0073  */
    /* JADX WARN: Code duplicated, block: B:40:0x0077  */
    /* JADX WARN: Code duplicated, block: B:42:0x007f  */
    /* JADX WARN: Code duplicated, block: B:43:0x0082  */
    /* JADX WARN: Code duplicated, block: B:48:0x008d  */
    /* JADX WARN: Code duplicated, block: B:50:0x0091  */
    /* JADX WARN: Code duplicated, block: B:52:0x0099  */
    /* JADX WARN: Code duplicated, block: B:53:0x009c  */
    /* JADX WARN: Code duplicated, block: B:56:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:59:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:60:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:63:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:65:0x00c8  */
    /* JADX WARN: Code duplicated, block: B:72:0x00db  */
    /* JADX WARN: Code duplicated, block: B:74:0x00de  */
    /* JADX WARN: Code duplicated, block: B:76:0x00e1  */
    /* JADX WARN: Code duplicated, block: B:79:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:82:0x00fb  */
    /* JADX WARN: Code duplicated, block: B:85:0x0148  */
    /* JADX WARN: Code duplicated, block: B:87:0x014f  */
    /* JADX WARN: Code duplicated, block: B:90:0x015b  */
    /* JADX WARN: Code duplicated, block: B:92:? A[RETURN, SYNTHETIC] */
    /* JADX INFO: renamed from: BoxDismissAlertDialog-V-9fs2A, reason: not valid java name */
    public static final void m11712BoxDismissAlertDialogV9fs2A(final int i, final Function2<? super Composer, ? super Integer, Unit> content, final ButtonItem.TextButtonItem negativeButton, String str, Function0<Unit> function0, long j, Composer composer, final int i2, final int i3) {
        int i4;
        String str2;
        int i5;
        Function0<Unit> function1;
        int i6;
        long jM11533getMainActiveControl0d7_KjU;
        boolean z;
        final String str3;
        final Function0<Unit> function2;
        final long j2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(negativeButton, "negativeButton");
        Composer composerStartRestartGroup = composer.startRestartGroup(1751985636);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BoxDismissAlertDialog)N(title,content,negativeButton,testTag,onDismiss,negativeButtonColor:c#ui.graphics.Color)36@1529L21,40@1621L138,38@1556L422:BoxDismissAlertDialog.kt#fwd9q");
        if ((i2 & 6) == 0) {
            i4 = (composerStartRestartGroup.changed(i) ? 4 : 2) | i2;
        } else {
            i4 = i2;
        }
        if ((i2 & 48) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(content) ? 32 : 16;
        }
        if ((i2 & 384) == 0) {
            i4 |= composerStartRestartGroup.changed(negativeButton) ? 256 : 128;
        }
        int i7 = i3 & 8;
        if (i7 == 0) {
            if ((i2 & 3072) == 0) {
                str2 = str;
                i4 |= composerStartRestartGroup.changed(str2) ? 2048 : 1024;
            }
            i5 = i3 & 16;
            if (i5 != 0) {
                if ((i2 & 24576) == 0) {
                    function1 = function0;
                    if (composerStartRestartGroup.changedInstance(function1)) {
                        i6 = 16384;
                    } else {
                        i6 = 8192;
                    }
                    i4 |= i6;
                }
                if ((196608 & i2) == 0) {
                    if ((i3 & 32) == 0) {
                        jM11533getMainActiveControl0d7_KjU = j;
                        int i8 = composerStartRestartGroup.changed(jM11533getMainActiveControl0d7_KjU) ? 131072 : 65536;
                        i4 |= i8;
                    } else {
                        jM11533getMainActiveControl0d7_KjU = j;
                    }
                    i4 |= i8;
                } else {
                    jM11533getMainActiveControl0d7_KjU = j;
                }
                if ((74899 & i4) != 74898) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "34@1481L6");
                    if ((i2 & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                        if (i7 != 0) {
                            str2 = null;
                        }
                        if (i5 != 0) {
                            function1 = null;
                        }
                        if ((i3 & 32) != 0) {
                            jM11533getMainActiveControl0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                            i4 &= -458753;
                        }
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        if ((i3 & 32) != 0) {
                            i4 &= -458753;
                        }
                    }
                    String str4 = str2;
                    Function0<Unit> function3 = function1;
                    long j3 = jM11533getMainActiveControl0d7_KjU;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1751985636, i4, -1, "com.box.android.base.compose.dialog.BoxDismissAlertDialog (BoxDismissAlertDialog.kt:35)");
                    }
                    final String strStringResource = StringResources_androidKt.stringResource(i, composerStartRestartGroup, i4 & 14);
                    BoxDialogKt.m11710BoxDialog0S3VyRs(function3, content, new DialogButtonsConfig.NegativeButton(negativeButton), null, str4, strStringResource, null, ComposableLambdaKt.rememberComposableLambda(-1224506781, true, new Function2() { // from class: com.box.android.base.compose.dialog.BoxDismissAlertDialogKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return BoxDismissAlertDialogKt.BoxDismissAlertDialog_V_9fs2A$lambda$0(strStringResource, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), 0L, j3, composerStartRestartGroup, ((i4 >> 12) & 14) | 12582912 | (i4 & 112) | ((i4 << 3) & 57344) | ((i4 << 12) & C.ENCODING_PCM_DOUBLE), 328);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    function2 = function3;
                    str3 = str4;
                    j2 = j3;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    str3 = str2;
                    function2 = function1;
                    j2 = jM11533getMainActiveControl0d7_KjU;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.dialog.BoxDismissAlertDialogKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return BoxDismissAlertDialogKt.BoxDismissAlertDialog_V_9fs2A$lambda$1(i, content, negativeButton, str3, function2, j2, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i4 |= 24576;
            function1 = function0;
            if ((196608 & i2) == 0) {
                if ((i3 & 32) == 0) {
                    jM11533getMainActiveControl0d7_KjU = j;
                    if (composerStartRestartGroup.changed(jM11533getMainActiveControl0d7_KjU)) {
                    }
                    i4 |= i8;
                } else {
                    jM11533getMainActiveControl0d7_KjU = j;
                }
                i4 |= i8;
            } else {
                jM11533getMainActiveControl0d7_KjU = j;
            }
            if ((74899 & i4) != 74898) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "34@1481L6");
                if ((i2 & 1) != 0) {
                    if (i7 != 0) {
                        str2 = null;
                    }
                    if (i5 != 0) {
                        function1 = null;
                    }
                    if ((i3 & 32) != 0) {
                        jM11533getMainActiveControl0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                        i4 &= -458753;
                    }
                } else {
                    if (i7 != 0) {
                        str2 = null;
                    }
                    if (i5 != 0) {
                        function1 = null;
                    }
                    if ((i3 & 32) != 0) {
                        jM11533getMainActiveControl0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                        i4 &= -458753;
                    }
                }
                String str5 = str2;
                Function0<Unit> function4 = function1;
                long j4 = jM11533getMainActiveControl0d7_KjU;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1751985636, i4, -1, "com.box.android.base.compose.dialog.BoxDismissAlertDialog (BoxDismissAlertDialog.kt:35)");
                }
                final String strStringResource2 = StringResources_androidKt.stringResource(i, composerStartRestartGroup, i4 & 14);
                BoxDialogKt.m11710BoxDialog0S3VyRs(function4, content, new DialogButtonsConfig.NegativeButton(negativeButton), null, str5, strStringResource2, null, ComposableLambdaKt.rememberComposableLambda(-1224506781, true, new Function2() { // from class: com.box.android.base.compose.dialog.BoxDismissAlertDialogKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return BoxDismissAlertDialogKt.BoxDismissAlertDialog_V_9fs2A$lambda$0(strStringResource2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), 0L, j4, composerStartRestartGroup, ((i4 >> 12) & 14) | 12582912 | (i4 & 112) | ((i4 << 3) & 57344) | ((i4 << 12) & C.ENCODING_PCM_DOUBLE), 328);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                function2 = function4;
                str3 = str5;
                j2 = j4;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                str3 = str2;
                function2 = function1;
                j2 = jM11533getMainActiveControl0d7_KjU;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.dialog.BoxDismissAlertDialogKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return BoxDismissAlertDialogKt.BoxDismissAlertDialog_V_9fs2A$lambda$1(i, content, negativeButton, str3, function2, j2, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i4 |= 3072;
        str2 = str;
        i5 = i3 & 16;
        if (i5 != 0) {
            if ((i2 & 24576) == 0) {
                function1 = function0;
                if (composerStartRestartGroup.changedInstance(function1)) {
                    i6 = 16384;
                } else {
                    i6 = 8192;
                }
                i4 |= i6;
            }
            if ((196608 & i2) == 0) {
                if ((i3 & 32) == 0) {
                    jM11533getMainActiveControl0d7_KjU = j;
                    if (composerStartRestartGroup.changed(jM11533getMainActiveControl0d7_KjU)) {
                    }
                    i4 |= i8;
                } else {
                    jM11533getMainActiveControl0d7_KjU = j;
                }
                i4 |= i8;
            } else {
                jM11533getMainActiveControl0d7_KjU = j;
            }
            if ((74899 & i4) != 74898) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "34@1481L6");
                if ((i2 & 1) != 0) {
                    if (i7 != 0) {
                        str2 = null;
                    }
                    if (i5 != 0) {
                        function1 = null;
                    }
                    if ((i3 & 32) != 0) {
                        jM11533getMainActiveControl0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                        i4 &= -458753;
                    }
                } else {
                    if (i7 != 0) {
                        str2 = null;
                    }
                    if (i5 != 0) {
                        function1 = null;
                    }
                    if ((i3 & 32) != 0) {
                        jM11533getMainActiveControl0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                        i4 &= -458753;
                    }
                }
                String str6 = str2;
                Function0<Unit> function5 = function1;
                long j5 = jM11533getMainActiveControl0d7_KjU;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1751985636, i4, -1, "com.box.android.base.compose.dialog.BoxDismissAlertDialog (BoxDismissAlertDialog.kt:35)");
                }
                final String strStringResource3 = StringResources_androidKt.stringResource(i, composerStartRestartGroup, i4 & 14);
                BoxDialogKt.m11710BoxDialog0S3VyRs(function5, content, new DialogButtonsConfig.NegativeButton(negativeButton), null, str6, strStringResource3, null, ComposableLambdaKt.rememberComposableLambda(-1224506781, true, new Function2() { // from class: com.box.android.base.compose.dialog.BoxDismissAlertDialogKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return BoxDismissAlertDialogKt.BoxDismissAlertDialog_V_9fs2A$lambda$0(strStringResource3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), 0L, j5, composerStartRestartGroup, ((i4 >> 12) & 14) | 12582912 | (i4 & 112) | ((i4 << 3) & 57344) | ((i4 << 12) & C.ENCODING_PCM_DOUBLE), 328);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                function2 = function5;
                str3 = str6;
                j2 = j5;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                str3 = str2;
                function2 = function1;
                j2 = jM11533getMainActiveControl0d7_KjU;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.dialog.BoxDismissAlertDialogKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return BoxDismissAlertDialogKt.BoxDismissAlertDialog_V_9fs2A$lambda$1(i, content, negativeButton, str3, function2, j2, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i4 |= 24576;
        function1 = function0;
        if ((196608 & i2) == 0) {
            if ((i3 & 32) == 0) {
                jM11533getMainActiveControl0d7_KjU = j;
                if (composerStartRestartGroup.changed(jM11533getMainActiveControl0d7_KjU)) {
                }
                i4 |= i8;
            } else {
                jM11533getMainActiveControl0d7_KjU = j;
            }
            i4 |= i8;
        } else {
            jM11533getMainActiveControl0d7_KjU = j;
        }
        if ((74899 & i4) != 74898) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "34@1481L6");
            if ((i2 & 1) != 0) {
                if (i7 != 0) {
                    str2 = null;
                }
                if (i5 != 0) {
                    function1 = null;
                }
                if ((i3 & 32) != 0) {
                    jM11533getMainActiveControl0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                    i4 &= -458753;
                }
            } else {
                if (i7 != 0) {
                    str2 = null;
                }
                if (i5 != 0) {
                    function1 = null;
                }
                if ((i3 & 32) != 0) {
                    jM11533getMainActiveControl0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                    i4 &= -458753;
                }
            }
            String str7 = str2;
            Function0<Unit> function6 = function1;
            long j6 = jM11533getMainActiveControl0d7_KjU;
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1751985636, i4, -1, "com.box.android.base.compose.dialog.BoxDismissAlertDialog (BoxDismissAlertDialog.kt:35)");
            }
            final String strStringResource4 = StringResources_androidKt.stringResource(i, composerStartRestartGroup, i4 & 14);
            BoxDialogKt.m11710BoxDialog0S3VyRs(function6, content, new DialogButtonsConfig.NegativeButton(negativeButton), null, str7, strStringResource4, null, ComposableLambdaKt.rememberComposableLambda(-1224506781, true, new Function2() { // from class: com.box.android.base.compose.dialog.BoxDismissAlertDialogKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BoxDismissAlertDialogKt.BoxDismissAlertDialog_V_9fs2A$lambda$0(strStringResource4, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), 0L, j6, composerStartRestartGroup, ((i4 >> 12) & 14) | 12582912 | (i4 & 112) | ((i4 << 3) & 57344) | ((i4 << 12) & C.ENCODING_PCM_DOUBLE), 328);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            function2 = function6;
            str3 = str7;
            j2 = j6;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            str3 = str2;
            function2 = function1;
            j2 = jM11533getMainActiveControl0d7_KjU;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.dialog.BoxDismissAlertDialogKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BoxDismissAlertDialogKt.BoxDismissAlertDialog_V_9fs2A$lambda$1(i, content, negativeButton, str3, function2, j2, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxDismissAlertDialog_V_9fs2A$lambda$0(String str, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C41@1635L114:BoxDismissAlertDialog.kt#fwd9q");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1224506781, i, -1, "com.box.android.base.compose.dialog.BoxDismissAlertDialog.<anonymous> (BoxDismissAlertDialog.kt:41)");
            }
            TextKt.m4494TextNvy7gAk(str, TestTagKt.testTag(Modifier.INSTANCE, "BoxDialogTitle"), 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 48, 0, 262140);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    private static final void BoxDismissAlertDialogPreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-2046013492);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BoxDismissAlertDialogPreview)59@2114L331:BoxDismissAlertDialog.kt#fwd9q");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2046013492, i, -1, "com.box.android.base.compose.dialog.BoxDismissAlertDialogPreview (BoxDismissAlertDialog.kt:58)");
            }
            BoxThemeKt.BoxTheme(ComposableSingletons$BoxDismissAlertDialogKt.INSTANCE.getLambda$683735905$base_generalProdRelease(), composerStartRestartGroup, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.dialog.BoxDismissAlertDialogKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BoxDismissAlertDialogKt.BoxDismissAlertDialogPreview$lambda$0(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}
