package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.window.AndroidDialog_androidKt;
import androidx.compose.ui.window.DialogProperties;
import androidx.media3.common.C;
import androidx.profileinstaller.ProfileVerifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: AndroidAlertDialog.android.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a§\u0001\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0015\b\u0002\u0010\b\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0015\b\u0002\u0010\t\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0015\b\u0002\u0010\n\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u0011H\u0007¢\u0006\u0004\b\u0012\u0010\u0013\u001a\u0090\u0001\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0011\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0015\b\u0002\u0010\t\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0015\b\u0002\u0010\n\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u0011H\u0007¢\u0006\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"AlertDialog", "", "onDismissRequest", "Lkotlin/Function0;", "confirmButton", "Landroidx/compose/runtime/Composable;", "modifier", "Landroidx/compose/ui/Modifier;", "dismissButton", "title", "text", "shape", "Landroidx/compose/ui/graphics/Shape;", "backgroundColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "properties", "Landroidx/compose/ui/window/DialogProperties;", "AlertDialog-6oU6zVQ", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;JJLandroidx/compose/ui/window/DialogProperties;Landroidx/compose/runtime/Composer;II)V", "buttons", "AlertDialog-wqdebIU", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;JJLandroidx/compose/ui/window/DialogProperties;Landroidx/compose/runtime/Composer;II)V", "material"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class AndroidAlertDialog_androidKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AlertDialog_6oU6zVQ$lambda$0(Function0 function0, Function2 function2, Modifier modifier, Function2 function3, Function2 function4, Function2 function5, Shape shape, long j, long j2, DialogProperties dialogProperties, int i, int i2, Composer composer, int i3) {
        m2241AlertDialog6oU6zVQ(function0, function2, modifier, function3, function4, function5, shape, j, j2, dialogProperties, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AlertDialog_wqdebIU$lambda$0(Function0 function0, Function2 function2, Modifier modifier, Function2 function3, Function2 function4, Shape shape, long j, long j2, DialogProperties dialogProperties, int i, int i2, Composer composer, int i3) {
        m2242AlertDialogwqdebIU(function0, function2, modifier, function3, function4, shape, j, j2, dialogProperties, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0123  */
    /* JADX WARN: Code duplicated, block: B:101:0x0126  */
    /* JADX WARN: Code duplicated, block: B:106:0x0139  */
    /* JADX WARN: Code duplicated, block: B:107:0x013b  */
    /* JADX WARN: Code duplicated, block: B:110:0x0144  */
    /* JADX WARN: Code duplicated, block: B:112:0x0159  */
    /* JADX WARN: Code duplicated, block: B:125:0x0187 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:126:0x0189  */
    /* JADX WARN: Code duplicated, block: B:129:0x0191  */
    /* JADX WARN: Code duplicated, block: B:131:0x0194  */
    /* JADX WARN: Code duplicated, block: B:133:0x0197  */
    /* JADX WARN: Code duplicated, block: B:136:0x019d  */
    /* JADX WARN: Code duplicated, block: B:139:0x01b0  */
    /* JADX WARN: Code duplicated, block: B:140:0x01c0  */
    /* JADX WARN: Code duplicated, block: B:143:0x01c7  */
    /* JADX WARN: Code duplicated, block: B:144:0x01d4  */
    /* JADX WARN: Code duplicated, block: B:146:0x01d8  */
    /* JADX WARN: Code duplicated, block: B:147:0x01f3  */
    /* JADX WARN: Code duplicated, block: B:151:0x020c  */
    /* JADX WARN: Code duplicated, block: B:154:0x0266  */
    /* JADX WARN: Code duplicated, block: B:156:0x0279  */
    /* JADX WARN: Code duplicated, block: B:159:0x028f  */
    /* JADX WARN: Code duplicated, block: B:161:? A[RETURN, SYNTHETIC] */
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
    /* JADX WARN: Code duplicated, block: B:67:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:68:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:71:0x00c1  */
    /* JADX WARN: Code duplicated, block: B:74:0x00c9  */
    /* JADX WARN: Code duplicated, block: B:76:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:78:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:79:0x00db  */
    /* JADX WARN: Code duplicated, block: B:82:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:85:0x00f0  */
    /* JADX WARN: Code duplicated, block: B:87:0x00f8  */
    /* JADX WARN: Code duplicated, block: B:90:0x0101  */
    /* JADX WARN: Code duplicated, block: B:92:0x0106  */
    /* JADX WARN: Code duplicated, block: B:95:0x0112  */
    /* JADX WARN: Code duplicated, block: B:96:0x0115  */
    /* JADX WARN: Code duplicated, block: B:98:0x0119  */
    /* JADX INFO: renamed from: AlertDialog-6oU6zVQ, reason: not valid java name */
    public static final void m2241AlertDialog6oU6zVQ(final Function0<Unit> function0, final Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function3, Function2<? super Composer, ? super Integer, Unit> function4, Function2<? super Composer, ? super Integer, Unit> function5, Shape shape, long j, long j2, DialogProperties dialogProperties, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        Function2<? super Composer, ? super Integer, Unit> function6;
        int i5;
        int i6;
        Function2<? super Composer, ? super Integer, Unit> function7;
        int i7;
        int i8;
        Function2<? super Composer, ? super Integer, Unit> function8;
        int i9;
        Shape medium;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        boolean z;
        Composer composer2;
        final Modifier modifier3;
        final Function2<? super Composer, ? super Integer, Unit> function9;
        final Function2<? super Composer, ? super Integer, Unit> function10;
        final Function2<? super Composer, ? super Integer, Unit> function11;
        final Shape shape2;
        final long j3;
        final long j4;
        final DialogProperties dialogProperties2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        long jM2346getSurface0d7_KjU;
        long jM2360contentColorForek8zF_U;
        DialogProperties dialogProperties3;
        long j5;
        Function2<? super Composer, ? super Integer, Unit> function12;
        int i15;
        long j6;
        Modifier modifier4;
        Function2<? super Composer, ? super Integer, Unit> function13;
        Shape shape3;
        int i16;
        int i17;
        Composer composerStartRestartGroup = composer.startRestartGroup(1967984963);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(AlertDialog)N(onDismissRequest,confirmButton,modifier,dismissButton,title,text,shape,backgroundColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,properties)41@1490L354:AndroidAlertDialog.android.kt#jmzs0o");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(function0) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function2) ? 32 : 16;
        }
        int i18 = i2 & 4;
        if (i18 == 0) {
            if ((i & 384) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            i4 = i2 & 8;
            if (i4 != 0) {
                if ((i & 3072) == 0) {
                    function6 = function3;
                    if (composerStartRestartGroup.changedInstance(function6)) {
                        i5 = 2048;
                    } else {
                        i5 = 1024;
                    }
                    i3 |= i5;
                }
                i6 = i2 & 16;
                if (i6 != 0) {
                    if ((i & 24576) == 0) {
                        function7 = function4;
                        if (composerStartRestartGroup.changedInstance(function7)) {
                            i7 = 16384;
                        } else {
                            i7 = 8192;
                        }
                        i3 |= i7;
                    }
                    i8 = i2 & 32;
                    if (i8 != 0) {
                        if ((196608 & i) == 0) {
                            function8 = function5;
                            if (composerStartRestartGroup.changedInstance(function8)) {
                                i9 = 131072;
                            } else {
                                i9 = 65536;
                            }
                            i3 |= i9;
                        }
                        if ((1572864 & i) == 0) {
                            if ((i2 & 64) == 0) {
                                medium = shape;
                                int i19 = composerStartRestartGroup.changed(medium) ? 1048576 : 524288;
                                i3 |= i19;
                            } else {
                                medium = shape;
                            }
                            i3 |= i19;
                        } else {
                            medium = shape;
                        }
                        if ((i & 12582912) == 0) {
                            if ((i2 & 128) == 0) {
                                i17 = i3;
                                i11 = i18;
                                int i20 = composerStartRestartGroup.changed(j) ? 8388608 : 4194304;
                                i10 = i17 | i20;
                            } else {
                                i17 = i3;
                                i11 = i18;
                            }
                            i10 = i17 | i20;
                        } else {
                            i10 = i3;
                            i11 = i18;
                        }
                        if ((i & 100663296) == 0) {
                            int i21 = i10;
                            if ((i2 & 256) == 0 || !composerStartRestartGroup.changed(j2)) {
                                i16 = 33554432;
                            } else {
                                i16 = 67108864;
                            }
                            i10 = i21 | i16;
                        }
                        i12 = i10;
                        i13 = i2 & 512;
                        if (i13 != 0) {
                            if ((i & 805306368) == 0) {
                                if (composerStartRestartGroup.changed(dialogProperties)) {
                                    i14 = C.BUFFER_FLAG_LAST_SAMPLE;
                                } else {
                                    i14 = 268435456;
                                }
                                i12 |= i14;
                            }
                            if ((i12 & 306783379) != 306783378) {
                                z = true;
                            } else {
                                z = false;
                            }
                            if (composerStartRestartGroup.shouldExecute(z, i12 & 1)) {
                                composerStartRestartGroup.startDefaults();
                                ComposerKt.sourceInformation(composerStartRestartGroup, "77@4252L6,77@4310L6,77@4352L32");
                                if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                    if (i11 != 0) {
                                        modifier2 = Modifier.INSTANCE;
                                    }
                                    if (i4 != 0) {
                                        function6 = null;
                                    }
                                    if (i6 != 0) {
                                        function7 = null;
                                    }
                                    if (i8 != 0) {
                                        function8 = null;
                                    }
                                    if ((i2 & 64) != 0) {
                                        i12 &= -3670017;
                                        medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                                    }
                                    if ((i2 & 128) != 0) {
                                        i12 &= -29360129;
                                        jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                                    } else {
                                        jM2346getSurface0d7_KjU = j;
                                    }
                                    if ((i2 & 256) != 0) {
                                        jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i12 >> 21) & 14);
                                        i12 &= -234881025;
                                    } else {
                                        jM2360contentColorForek8zF_U = j2;
                                    }
                                    if (i13 != 0) {
                                        dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                                    } else {
                                        dialogProperties3 = dialogProperties;
                                    }
                                    j5 = jM2346getSurface0d7_KjU;
                                    function12 = function7;
                                    i15 = i12;
                                    j6 = jM2360contentColorForek8zF_U;
                                    modifier4 = modifier2;
                                    function13 = function8;
                                    shape3 = medium;
                                } else {
                                    composerStartRestartGroup.skipToGroupEnd();
                                    if ((i2 & 64) != 0) {
                                        i12 &= -3670017;
                                    }
                                    if ((i2 & 128) != 0) {
                                        i12 &= -29360129;
                                    }
                                    if ((i2 & 256) != 0) {
                                        i12 &= -234881025;
                                    }
                                    j5 = j;
                                    j6 = j2;
                                    dialogProperties3 = dialogProperties;
                                    function12 = function7;
                                    function13 = function8;
                                    shape3 = medium;
                                    i15 = i12;
                                    modifier4 = modifier2;
                                }
                                composerStartRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1967984963, i15, -1, "androidx.compose.material.AlertDialog (AndroidAlertDialog.android.kt:41)");
                                }
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1483448977, "CC(AlertDialogImpl)N(onDismissRequest,confirmButton,modifier,dismissButton,title,text,shape,backgroundColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,properties)149@6875L386,147@6799L678:AlertDialog.kt#jmzs0o");
                                int i22 = (2147483646 & i15) >> 3;
                                composer2 = composerStartRestartGroup;
                                m2242AlertDialogwqdebIU(function0, ComposableLambdaKt.rememberComposableLambda(-309297447, true, new AlertDialogKt$AlertDialogImpl$1(function6, function2), composerStartRestartGroup, 54), modifier4, function12, function13, shape3, j5, j6, dialogProperties3, composer2, (i15 & 896) | (i15 & 14) | 48 | (i22 & 7168) | (57344 & i22) | (458752 & i22) | (3670016 & i22) | (29360128 & i22) | (i22 & 234881024), 0);
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                function9 = function6;
                                modifier3 = modifier4;
                                function10 = function12;
                                function11 = function13;
                                shape2 = shape3;
                                j3 = j5;
                                j4 = j6;
                                dialogProperties2 = dialogProperties3;
                            } else {
                                composer2 = composerStartRestartGroup;
                                composer2.skipToGroupEnd();
                                modifier3 = modifier2;
                                function9 = function6;
                                function10 = function7;
                                function11 = function8;
                                shape2 = medium;
                                j3 = j;
                                j4 = j2;
                                dialogProperties2 = dialogProperties;
                            }
                            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup != null) {
                                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.AndroidAlertDialog_androidKt$$ExternalSyntheticLambda0
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return AndroidAlertDialog_androidKt.AlertDialog_6oU6zVQ$lambda$0(function0, function2, modifier3, function9, function10, function11, shape2, j3, j4, dialogProperties2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                    }
                                });
                            }
                        }
                        i12 |= 805306368;
                        if ((i12 & 306783379) != 306783378) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (composerStartRestartGroup.shouldExecute(z, i12 & 1)) {
                            composerStartRestartGroup.startDefaults();
                            ComposerKt.sourceInformation(composerStartRestartGroup, "77@4252L6,77@4310L6,77@4352L32");
                            if ((i & 1) != 0) {
                                if (i11 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                if (i4 != 0) {
                                    function6 = null;
                                }
                                if (i6 != 0) {
                                    function7 = null;
                                }
                                if (i8 != 0) {
                                    function8 = null;
                                }
                                if ((i2 & 64) != 0) {
                                    i12 &= -3670017;
                                    medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                                }
                                if ((i2 & 128) != 0) {
                                    i12 &= -29360129;
                                    jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                                } else {
                                    jM2346getSurface0d7_KjU = j;
                                }
                                if ((i2 & 256) != 0) {
                                    jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i12 >> 21) & 14);
                                    i12 &= -234881025;
                                } else {
                                    jM2360contentColorForek8zF_U = j2;
                                }
                                if (i13 != 0) {
                                    dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                                } else {
                                    dialogProperties3 = dialogProperties;
                                }
                                j5 = jM2346getSurface0d7_KjU;
                                function12 = function7;
                                i15 = i12;
                                j6 = jM2360contentColorForek8zF_U;
                                modifier4 = modifier2;
                                function13 = function8;
                                shape3 = medium;
                            } else {
                                if (i11 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                if (i4 != 0) {
                                    function6 = null;
                                }
                                if (i6 != 0) {
                                    function7 = null;
                                }
                                if (i8 != 0) {
                                    function8 = null;
                                }
                                if ((i2 & 64) != 0) {
                                    i12 &= -3670017;
                                    medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                                }
                                if ((i2 & 128) != 0) {
                                    i12 &= -29360129;
                                    jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                                } else {
                                    jM2346getSurface0d7_KjU = j;
                                }
                                if ((i2 & 256) != 0) {
                                    jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i12 >> 21) & 14);
                                    i12 &= -234881025;
                                } else {
                                    jM2360contentColorForek8zF_U = j2;
                                }
                                if (i13 != 0) {
                                    dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                                } else {
                                    dialogProperties3 = dialogProperties;
                                }
                                j5 = jM2346getSurface0d7_KjU;
                                function12 = function7;
                                i15 = i12;
                                j6 = jM2360contentColorForek8zF_U;
                                modifier4 = modifier2;
                                function13 = function8;
                                shape3 = medium;
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1967984963, i15, -1, "androidx.compose.material.AlertDialog (AndroidAlertDialog.android.kt:41)");
                            }
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1483448977, "CC(AlertDialogImpl)N(onDismissRequest,confirmButton,modifier,dismissButton,title,text,shape,backgroundColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,properties)149@6875L386,147@6799L678:AlertDialog.kt#jmzs0o");
                            int i23 = (2147483646 & i15) >> 3;
                            composer2 = composerStartRestartGroup;
                            m2242AlertDialogwqdebIU(function0, ComposableLambdaKt.rememberComposableLambda(-309297447, true, new AlertDialogKt$AlertDialogImpl$1(function6, function2), composerStartRestartGroup, 54), modifier4, function12, function13, shape3, j5, j6, dialogProperties3, composer2, (i15 & 896) | (i15 & 14) | 48 | (i23 & 7168) | (57344 & i23) | (458752 & i23) | (3670016 & i23) | (29360128 & i23) | (i23 & 234881024), 0);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            function9 = function6;
                            modifier3 = modifier4;
                            function10 = function12;
                            function11 = function13;
                            shape2 = shape3;
                            j3 = j5;
                            j4 = j6;
                            dialogProperties2 = dialogProperties3;
                        } else {
                            composer2 = composerStartRestartGroup;
                            composer2.skipToGroupEnd();
                            modifier3 = modifier2;
                            function9 = function6;
                            function10 = function7;
                            function11 = function8;
                            shape2 = medium;
                            j3 = j;
                            j4 = j2;
                            dialogProperties2 = dialogProperties;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.AndroidAlertDialog_androidKt$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return AndroidAlertDialog_androidKt.AlertDialog_6oU6zVQ$lambda$0(function0, function2, modifier3, function9, function10, function11, shape2, j3, j4, dialogProperties2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                        }
                    }
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    function8 = function5;
                    if ((1572864 & i) == 0) {
                        if ((i2 & 64) == 0) {
                            medium = shape;
                            if (composerStartRestartGroup.changed(medium)) {
                            }
                            i3 |= i19;
                        } else {
                            medium = shape;
                        }
                        i3 |= i19;
                    } else {
                        medium = shape;
                    }
                    if ((i & 12582912) == 0) {
                        if ((i2 & 128) == 0) {
                            i17 = i3;
                            i11 = i18;
                            if (composerStartRestartGroup.changed(j)) {
                            }
                            i10 = i17 | i20;
                        } else {
                            i17 = i3;
                            i11 = i18;
                        }
                        i10 = i17 | i20;
                    } else {
                        i10 = i3;
                        i11 = i18;
                    }
                    if ((i & 100663296) == 0) {
                        int i24 = i10;
                        if ((i2 & 256) == 0) {
                            i16 = 33554432;
                        } else {
                            i16 = 33554432;
                        }
                        i10 = i24 | i16;
                    }
                    i12 = i10;
                    i13 = i2 & 512;
                    if (i13 != 0) {
                        if ((i & 805306368) == 0) {
                            if (composerStartRestartGroup.changed(dialogProperties)) {
                                i14 = C.BUFFER_FLAG_LAST_SAMPLE;
                            } else {
                                i14 = 268435456;
                            }
                            i12 |= i14;
                        }
                        if ((i12 & 306783379) != 306783378) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (composerStartRestartGroup.shouldExecute(z, i12 & 1)) {
                            composerStartRestartGroup.startDefaults();
                            ComposerKt.sourceInformation(composerStartRestartGroup, "77@4252L6,77@4310L6,77@4352L32");
                            if ((i & 1) != 0) {
                                if (i11 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                if (i4 != 0) {
                                    function6 = null;
                                }
                                if (i6 != 0) {
                                    function7 = null;
                                }
                                if (i8 != 0) {
                                    function8 = null;
                                }
                                if ((i2 & 64) != 0) {
                                    i12 &= -3670017;
                                    medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                                }
                                if ((i2 & 128) != 0) {
                                    i12 &= -29360129;
                                    jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                                } else {
                                    jM2346getSurface0d7_KjU = j;
                                }
                                if ((i2 & 256) != 0) {
                                    jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i12 >> 21) & 14);
                                    i12 &= -234881025;
                                } else {
                                    jM2360contentColorForek8zF_U = j2;
                                }
                                if (i13 != 0) {
                                    dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                                } else {
                                    dialogProperties3 = dialogProperties;
                                }
                                j5 = jM2346getSurface0d7_KjU;
                                function12 = function7;
                                i15 = i12;
                                j6 = jM2360contentColorForek8zF_U;
                                modifier4 = modifier2;
                                function13 = function8;
                                shape3 = medium;
                            } else {
                                if (i11 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                if (i4 != 0) {
                                    function6 = null;
                                }
                                if (i6 != 0) {
                                    function7 = null;
                                }
                                if (i8 != 0) {
                                    function8 = null;
                                }
                                if ((i2 & 64) != 0) {
                                    i12 &= -3670017;
                                    medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                                }
                                if ((i2 & 128) != 0) {
                                    i12 &= -29360129;
                                    jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                                } else {
                                    jM2346getSurface0d7_KjU = j;
                                }
                                if ((i2 & 256) != 0) {
                                    jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i12 >> 21) & 14);
                                    i12 &= -234881025;
                                } else {
                                    jM2360contentColorForek8zF_U = j2;
                                }
                                if (i13 != 0) {
                                    dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                                } else {
                                    dialogProperties3 = dialogProperties;
                                }
                                j5 = jM2346getSurface0d7_KjU;
                                function12 = function7;
                                i15 = i12;
                                j6 = jM2360contentColorForek8zF_U;
                                modifier4 = modifier2;
                                function13 = function8;
                                shape3 = medium;
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1967984963, i15, -1, "androidx.compose.material.AlertDialog (AndroidAlertDialog.android.kt:41)");
                            }
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1483448977, "CC(AlertDialogImpl)N(onDismissRequest,confirmButton,modifier,dismissButton,title,text,shape,backgroundColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,properties)149@6875L386,147@6799L678:AlertDialog.kt#jmzs0o");
                            int i25 = (2147483646 & i15) >> 3;
                            composer2 = composerStartRestartGroup;
                            m2242AlertDialogwqdebIU(function0, ComposableLambdaKt.rememberComposableLambda(-309297447, true, new AlertDialogKt$AlertDialogImpl$1(function6, function2), composerStartRestartGroup, 54), modifier4, function12, function13, shape3, j5, j6, dialogProperties3, composer2, (i15 & 896) | (i15 & 14) | 48 | (i25 & 7168) | (57344 & i25) | (458752 & i25) | (3670016 & i25) | (29360128 & i25) | (i25 & 234881024), 0);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            function9 = function6;
                            modifier3 = modifier4;
                            function10 = function12;
                            function11 = function13;
                            shape2 = shape3;
                            j3 = j5;
                            j4 = j6;
                            dialogProperties2 = dialogProperties3;
                        } else {
                            composer2 = composerStartRestartGroup;
                            composer2.skipToGroupEnd();
                            modifier3 = modifier2;
                            function9 = function6;
                            function10 = function7;
                            function11 = function8;
                            shape2 = medium;
                            j3 = j;
                            j4 = j2;
                            dialogProperties2 = dialogProperties;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.AndroidAlertDialog_androidKt$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return AndroidAlertDialog_androidKt.AlertDialog_6oU6zVQ$lambda$0(function0, function2, modifier3, function9, function10, function11, shape2, j3, j4, dialogProperties2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                        }
                    }
                    i12 |= 805306368;
                    if ((i12 & 306783379) != 306783378) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z, i12 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "77@4252L6,77@4310L6,77@4352L32");
                        if ((i & 1) != 0) {
                            if (i11 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                function6 = null;
                            }
                            if (i6 != 0) {
                                function7 = null;
                            }
                            if (i8 != 0) {
                                function8 = null;
                            }
                            if ((i2 & 64) != 0) {
                                i12 &= -3670017;
                                medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                            }
                            if ((i2 & 128) != 0) {
                                i12 &= -29360129;
                                jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                            } else {
                                jM2346getSurface0d7_KjU = j;
                            }
                            if ((i2 & 256) != 0) {
                                jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i12 >> 21) & 14);
                                i12 &= -234881025;
                            } else {
                                jM2360contentColorForek8zF_U = j2;
                            }
                            if (i13 != 0) {
                                dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                            } else {
                                dialogProperties3 = dialogProperties;
                            }
                            j5 = jM2346getSurface0d7_KjU;
                            function12 = function7;
                            i15 = i12;
                            j6 = jM2360contentColorForek8zF_U;
                            modifier4 = modifier2;
                            function13 = function8;
                            shape3 = medium;
                        } else {
                            if (i11 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                function6 = null;
                            }
                            if (i6 != 0) {
                                function7 = null;
                            }
                            if (i8 != 0) {
                                function8 = null;
                            }
                            if ((i2 & 64) != 0) {
                                i12 &= -3670017;
                                medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                            }
                            if ((i2 & 128) != 0) {
                                i12 &= -29360129;
                                jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                            } else {
                                jM2346getSurface0d7_KjU = j;
                            }
                            if ((i2 & 256) != 0) {
                                jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i12 >> 21) & 14);
                                i12 &= -234881025;
                            } else {
                                jM2360contentColorForek8zF_U = j2;
                            }
                            if (i13 != 0) {
                                dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                            } else {
                                dialogProperties3 = dialogProperties;
                            }
                            j5 = jM2346getSurface0d7_KjU;
                            function12 = function7;
                            i15 = i12;
                            j6 = jM2360contentColorForek8zF_U;
                            modifier4 = modifier2;
                            function13 = function8;
                            shape3 = medium;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1967984963, i15, -1, "androidx.compose.material.AlertDialog (AndroidAlertDialog.android.kt:41)");
                        }
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1483448977, "CC(AlertDialogImpl)N(onDismissRequest,confirmButton,modifier,dismissButton,title,text,shape,backgroundColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,properties)149@6875L386,147@6799L678:AlertDialog.kt#jmzs0o");
                        int i26 = (2147483646 & i15) >> 3;
                        composer2 = composerStartRestartGroup;
                        m2242AlertDialogwqdebIU(function0, ComposableLambdaKt.rememberComposableLambda(-309297447, true, new AlertDialogKt$AlertDialogImpl$1(function6, function2), composerStartRestartGroup, 54), modifier4, function12, function13, shape3, j5, j6, dialogProperties3, composer2, (i15 & 896) | (i15 & 14) | 48 | (i26 & 7168) | (57344 & i26) | (458752 & i26) | (3670016 & i26) | (29360128 & i26) | (i26 & 234881024), 0);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        function9 = function6;
                        modifier3 = modifier4;
                        function10 = function12;
                        function11 = function13;
                        shape2 = shape3;
                        j3 = j5;
                        j4 = j6;
                        dialogProperties2 = dialogProperties3;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        modifier3 = modifier2;
                        function9 = function6;
                        function10 = function7;
                        function11 = function8;
                        shape2 = medium;
                        j3 = j;
                        j4 = j2;
                        dialogProperties2 = dialogProperties;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.AndroidAlertDialog_androidKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return AndroidAlertDialog_androidKt.AlertDialog_6oU6zVQ$lambda$0(function0, function2, modifier3, function9, function10, function11, shape2, j3, j4, dialogProperties2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= 24576;
                function7 = function4;
                i8 = i2 & 32;
                if (i8 != 0) {
                    if ((196608 & i) == 0) {
                        function8 = function5;
                        if (composerStartRestartGroup.changedInstance(function8)) {
                            i9 = 131072;
                        } else {
                            i9 = 65536;
                        }
                        i3 |= i9;
                    }
                    if ((1572864 & i) == 0) {
                        if ((i2 & 64) == 0) {
                            medium = shape;
                            if (composerStartRestartGroup.changed(medium)) {
                            }
                            i3 |= i19;
                        } else {
                            medium = shape;
                        }
                        i3 |= i19;
                    } else {
                        medium = shape;
                    }
                    if ((i & 12582912) == 0) {
                        if ((i2 & 128) == 0) {
                            i17 = i3;
                            i11 = i18;
                            if (composerStartRestartGroup.changed(j)) {
                            }
                            i10 = i17 | i20;
                        } else {
                            i17 = i3;
                            i11 = i18;
                        }
                        i10 = i17 | i20;
                    } else {
                        i10 = i3;
                        i11 = i18;
                    }
                    if ((i & 100663296) == 0) {
                        int i27 = i10;
                        if ((i2 & 256) == 0) {
                            i16 = 33554432;
                        } else {
                            i16 = 33554432;
                        }
                        i10 = i27 | i16;
                    }
                    i12 = i10;
                    i13 = i2 & 512;
                    if (i13 != 0) {
                        if ((i & 805306368) == 0) {
                            if (composerStartRestartGroup.changed(dialogProperties)) {
                                i14 = C.BUFFER_FLAG_LAST_SAMPLE;
                            } else {
                                i14 = 268435456;
                            }
                            i12 |= i14;
                        }
                        if ((i12 & 306783379) != 306783378) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (composerStartRestartGroup.shouldExecute(z, i12 & 1)) {
                            composerStartRestartGroup.startDefaults();
                            ComposerKt.sourceInformation(composerStartRestartGroup, "77@4252L6,77@4310L6,77@4352L32");
                            if ((i & 1) != 0) {
                                if (i11 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                if (i4 != 0) {
                                    function6 = null;
                                }
                                if (i6 != 0) {
                                    function7 = null;
                                }
                                if (i8 != 0) {
                                    function8 = null;
                                }
                                if ((i2 & 64) != 0) {
                                    i12 &= -3670017;
                                    medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                                }
                                if ((i2 & 128) != 0) {
                                    i12 &= -29360129;
                                    jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                                } else {
                                    jM2346getSurface0d7_KjU = j;
                                }
                                if ((i2 & 256) != 0) {
                                    jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i12 >> 21) & 14);
                                    i12 &= -234881025;
                                } else {
                                    jM2360contentColorForek8zF_U = j2;
                                }
                                if (i13 != 0) {
                                    dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                                } else {
                                    dialogProperties3 = dialogProperties;
                                }
                                j5 = jM2346getSurface0d7_KjU;
                                function12 = function7;
                                i15 = i12;
                                j6 = jM2360contentColorForek8zF_U;
                                modifier4 = modifier2;
                                function13 = function8;
                                shape3 = medium;
                            } else {
                                if (i11 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                if (i4 != 0) {
                                    function6 = null;
                                }
                                if (i6 != 0) {
                                    function7 = null;
                                }
                                if (i8 != 0) {
                                    function8 = null;
                                }
                                if ((i2 & 64) != 0) {
                                    i12 &= -3670017;
                                    medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                                }
                                if ((i2 & 128) != 0) {
                                    i12 &= -29360129;
                                    jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                                } else {
                                    jM2346getSurface0d7_KjU = j;
                                }
                                if ((i2 & 256) != 0) {
                                    jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i12 >> 21) & 14);
                                    i12 &= -234881025;
                                } else {
                                    jM2360contentColorForek8zF_U = j2;
                                }
                                if (i13 != 0) {
                                    dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                                } else {
                                    dialogProperties3 = dialogProperties;
                                }
                                j5 = jM2346getSurface0d7_KjU;
                                function12 = function7;
                                i15 = i12;
                                j6 = jM2360contentColorForek8zF_U;
                                modifier4 = modifier2;
                                function13 = function8;
                                shape3 = medium;
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1967984963, i15, -1, "androidx.compose.material.AlertDialog (AndroidAlertDialog.android.kt:41)");
                            }
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1483448977, "CC(AlertDialogImpl)N(onDismissRequest,confirmButton,modifier,dismissButton,title,text,shape,backgroundColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,properties)149@6875L386,147@6799L678:AlertDialog.kt#jmzs0o");
                            int i28 = (2147483646 & i15) >> 3;
                            composer2 = composerStartRestartGroup;
                            m2242AlertDialogwqdebIU(function0, ComposableLambdaKt.rememberComposableLambda(-309297447, true, new AlertDialogKt$AlertDialogImpl$1(function6, function2), composerStartRestartGroup, 54), modifier4, function12, function13, shape3, j5, j6, dialogProperties3, composer2, (i15 & 896) | (i15 & 14) | 48 | (i28 & 7168) | (57344 & i28) | (458752 & i28) | (3670016 & i28) | (29360128 & i28) | (i28 & 234881024), 0);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            function9 = function6;
                            modifier3 = modifier4;
                            function10 = function12;
                            function11 = function13;
                            shape2 = shape3;
                            j3 = j5;
                            j4 = j6;
                            dialogProperties2 = dialogProperties3;
                        } else {
                            composer2 = composerStartRestartGroup;
                            composer2.skipToGroupEnd();
                            modifier3 = modifier2;
                            function9 = function6;
                            function10 = function7;
                            function11 = function8;
                            shape2 = medium;
                            j3 = j;
                            j4 = j2;
                            dialogProperties2 = dialogProperties;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.AndroidAlertDialog_androidKt$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return AndroidAlertDialog_androidKt.AlertDialog_6oU6zVQ$lambda$0(function0, function2, modifier3, function9, function10, function11, shape2, j3, j4, dialogProperties2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                        }
                    }
                    i12 |= 805306368;
                    if ((i12 & 306783379) != 306783378) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z, i12 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "77@4252L6,77@4310L6,77@4352L32");
                        if ((i & 1) != 0) {
                            if (i11 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                function6 = null;
                            }
                            if (i6 != 0) {
                                function7 = null;
                            }
                            if (i8 != 0) {
                                function8 = null;
                            }
                            if ((i2 & 64) != 0) {
                                i12 &= -3670017;
                                medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                            }
                            if ((i2 & 128) != 0) {
                                i12 &= -29360129;
                                jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                            } else {
                                jM2346getSurface0d7_KjU = j;
                            }
                            if ((i2 & 256) != 0) {
                                jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i12 >> 21) & 14);
                                i12 &= -234881025;
                            } else {
                                jM2360contentColorForek8zF_U = j2;
                            }
                            if (i13 != 0) {
                                dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                            } else {
                                dialogProperties3 = dialogProperties;
                            }
                            j5 = jM2346getSurface0d7_KjU;
                            function12 = function7;
                            i15 = i12;
                            j6 = jM2360contentColorForek8zF_U;
                            modifier4 = modifier2;
                            function13 = function8;
                            shape3 = medium;
                        } else {
                            if (i11 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                function6 = null;
                            }
                            if (i6 != 0) {
                                function7 = null;
                            }
                            if (i8 != 0) {
                                function8 = null;
                            }
                            if ((i2 & 64) != 0) {
                                i12 &= -3670017;
                                medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                            }
                            if ((i2 & 128) != 0) {
                                i12 &= -29360129;
                                jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                            } else {
                                jM2346getSurface0d7_KjU = j;
                            }
                            if ((i2 & 256) != 0) {
                                jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i12 >> 21) & 14);
                                i12 &= -234881025;
                            } else {
                                jM2360contentColorForek8zF_U = j2;
                            }
                            if (i13 != 0) {
                                dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                            } else {
                                dialogProperties3 = dialogProperties;
                            }
                            j5 = jM2346getSurface0d7_KjU;
                            function12 = function7;
                            i15 = i12;
                            j6 = jM2360contentColorForek8zF_U;
                            modifier4 = modifier2;
                            function13 = function8;
                            shape3 = medium;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1967984963, i15, -1, "androidx.compose.material.AlertDialog (AndroidAlertDialog.android.kt:41)");
                        }
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1483448977, "CC(AlertDialogImpl)N(onDismissRequest,confirmButton,modifier,dismissButton,title,text,shape,backgroundColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,properties)149@6875L386,147@6799L678:AlertDialog.kt#jmzs0o");
                        int i29 = (2147483646 & i15) >> 3;
                        composer2 = composerStartRestartGroup;
                        m2242AlertDialogwqdebIU(function0, ComposableLambdaKt.rememberComposableLambda(-309297447, true, new AlertDialogKt$AlertDialogImpl$1(function6, function2), composerStartRestartGroup, 54), modifier4, function12, function13, shape3, j5, j6, dialogProperties3, composer2, (i15 & 896) | (i15 & 14) | 48 | (i29 & 7168) | (57344 & i29) | (458752 & i29) | (3670016 & i29) | (29360128 & i29) | (i29 & 234881024), 0);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        function9 = function6;
                        modifier3 = modifier4;
                        function10 = function12;
                        function11 = function13;
                        shape2 = shape3;
                        j3 = j5;
                        j4 = j6;
                        dialogProperties2 = dialogProperties3;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        modifier3 = modifier2;
                        function9 = function6;
                        function10 = function7;
                        function11 = function8;
                        shape2 = medium;
                        j3 = j;
                        j4 = j2;
                        dialogProperties2 = dialogProperties;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.AndroidAlertDialog_androidKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return AndroidAlertDialog_androidKt.AlertDialog_6oU6zVQ$lambda$0(function0, function2, modifier3, function9, function10, function11, shape2, j3, j4, dialogProperties2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                function8 = function5;
                if ((1572864 & i) == 0) {
                    if ((i2 & 64) == 0) {
                        medium = shape;
                        if (composerStartRestartGroup.changed(medium)) {
                        }
                        i3 |= i19;
                    } else {
                        medium = shape;
                    }
                    i3 |= i19;
                } else {
                    medium = shape;
                }
                if ((i & 12582912) == 0) {
                    if ((i2 & 128) == 0) {
                        i17 = i3;
                        i11 = i18;
                        if (composerStartRestartGroup.changed(j)) {
                        }
                        i10 = i17 | i20;
                    } else {
                        i17 = i3;
                        i11 = i18;
                    }
                    i10 = i17 | i20;
                } else {
                    i10 = i3;
                    i11 = i18;
                }
                if ((i & 100663296) == 0) {
                    int i210 = i10;
                    if ((i2 & 256) == 0) {
                        i16 = 33554432;
                    } else {
                        i16 = 33554432;
                    }
                    i10 = i210 | i16;
                }
                i12 = i10;
                i13 = i2 & 512;
                if (i13 != 0) {
                    if ((i & 805306368) == 0) {
                        if (composerStartRestartGroup.changed(dialogProperties)) {
                            i14 = C.BUFFER_FLAG_LAST_SAMPLE;
                        } else {
                            i14 = 268435456;
                        }
                        i12 |= i14;
                    }
                    if ((i12 & 306783379) != 306783378) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z, i12 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "77@4252L6,77@4310L6,77@4352L32");
                        if ((i & 1) != 0) {
                            if (i11 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                function6 = null;
                            }
                            if (i6 != 0) {
                                function7 = null;
                            }
                            if (i8 != 0) {
                                function8 = null;
                            }
                            if ((i2 & 64) != 0) {
                                i12 &= -3670017;
                                medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                            }
                            if ((i2 & 128) != 0) {
                                i12 &= -29360129;
                                jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                            } else {
                                jM2346getSurface0d7_KjU = j;
                            }
                            if ((i2 & 256) != 0) {
                                jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i12 >> 21) & 14);
                                i12 &= -234881025;
                            } else {
                                jM2360contentColorForek8zF_U = j2;
                            }
                            if (i13 != 0) {
                                dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                            } else {
                                dialogProperties3 = dialogProperties;
                            }
                            j5 = jM2346getSurface0d7_KjU;
                            function12 = function7;
                            i15 = i12;
                            j6 = jM2360contentColorForek8zF_U;
                            modifier4 = modifier2;
                            function13 = function8;
                            shape3 = medium;
                        } else {
                            if (i11 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                function6 = null;
                            }
                            if (i6 != 0) {
                                function7 = null;
                            }
                            if (i8 != 0) {
                                function8 = null;
                            }
                            if ((i2 & 64) != 0) {
                                i12 &= -3670017;
                                medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                            }
                            if ((i2 & 128) != 0) {
                                i12 &= -29360129;
                                jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                            } else {
                                jM2346getSurface0d7_KjU = j;
                            }
                            if ((i2 & 256) != 0) {
                                jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i12 >> 21) & 14);
                                i12 &= -234881025;
                            } else {
                                jM2360contentColorForek8zF_U = j2;
                            }
                            if (i13 != 0) {
                                dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                            } else {
                                dialogProperties3 = dialogProperties;
                            }
                            j5 = jM2346getSurface0d7_KjU;
                            function12 = function7;
                            i15 = i12;
                            j6 = jM2360contentColorForek8zF_U;
                            modifier4 = modifier2;
                            function13 = function8;
                            shape3 = medium;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1967984963, i15, -1, "androidx.compose.material.AlertDialog (AndroidAlertDialog.android.kt:41)");
                        }
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1483448977, "CC(AlertDialogImpl)N(onDismissRequest,confirmButton,modifier,dismissButton,title,text,shape,backgroundColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,properties)149@6875L386,147@6799L678:AlertDialog.kt#jmzs0o");
                        int i211 = (2147483646 & i15) >> 3;
                        composer2 = composerStartRestartGroup;
                        m2242AlertDialogwqdebIU(function0, ComposableLambdaKt.rememberComposableLambda(-309297447, true, new AlertDialogKt$AlertDialogImpl$1(function6, function2), composerStartRestartGroup, 54), modifier4, function12, function13, shape3, j5, j6, dialogProperties3, composer2, (i15 & 896) | (i15 & 14) | 48 | (i211 & 7168) | (57344 & i211) | (458752 & i211) | (3670016 & i211) | (29360128 & i211) | (i211 & 234881024), 0);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        function9 = function6;
                        modifier3 = modifier4;
                        function10 = function12;
                        function11 = function13;
                        shape2 = shape3;
                        j3 = j5;
                        j4 = j6;
                        dialogProperties2 = dialogProperties3;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        modifier3 = modifier2;
                        function9 = function6;
                        function10 = function7;
                        function11 = function8;
                        shape2 = medium;
                        j3 = j;
                        j4 = j2;
                        dialogProperties2 = dialogProperties;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.AndroidAlertDialog_androidKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return AndroidAlertDialog_androidKt.AlertDialog_6oU6zVQ$lambda$0(function0, function2, modifier3, function9, function10, function11, shape2, j3, j4, dialogProperties2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i12 |= 805306368;
                if ((i12 & 306783379) != 306783378) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i12 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "77@4252L6,77@4310L6,77@4352L32");
                    if ((i & 1) != 0) {
                        if (i11 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            function6 = null;
                        }
                        if (i6 != 0) {
                            function7 = null;
                        }
                        if (i8 != 0) {
                            function8 = null;
                        }
                        if ((i2 & 64) != 0) {
                            i12 &= -3670017;
                            medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                        }
                        if ((i2 & 128) != 0) {
                            i12 &= -29360129;
                            jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                        } else {
                            jM2346getSurface0d7_KjU = j;
                        }
                        if ((i2 & 256) != 0) {
                            jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i12 >> 21) & 14);
                            i12 &= -234881025;
                        } else {
                            jM2360contentColorForek8zF_U = j2;
                        }
                        if (i13 != 0) {
                            dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                        } else {
                            dialogProperties3 = dialogProperties;
                        }
                        j5 = jM2346getSurface0d7_KjU;
                        function12 = function7;
                        i15 = i12;
                        j6 = jM2360contentColorForek8zF_U;
                        modifier4 = modifier2;
                        function13 = function8;
                        shape3 = medium;
                    } else {
                        if (i11 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            function6 = null;
                        }
                        if (i6 != 0) {
                            function7 = null;
                        }
                        if (i8 != 0) {
                            function8 = null;
                        }
                        if ((i2 & 64) != 0) {
                            i12 &= -3670017;
                            medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                        }
                        if ((i2 & 128) != 0) {
                            i12 &= -29360129;
                            jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                        } else {
                            jM2346getSurface0d7_KjU = j;
                        }
                        if ((i2 & 256) != 0) {
                            jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i12 >> 21) & 14);
                            i12 &= -234881025;
                        } else {
                            jM2360contentColorForek8zF_U = j2;
                        }
                        if (i13 != 0) {
                            dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                        } else {
                            dialogProperties3 = dialogProperties;
                        }
                        j5 = jM2346getSurface0d7_KjU;
                        function12 = function7;
                        i15 = i12;
                        j6 = jM2360contentColorForek8zF_U;
                        modifier4 = modifier2;
                        function13 = function8;
                        shape3 = medium;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1967984963, i15, -1, "androidx.compose.material.AlertDialog (AndroidAlertDialog.android.kt:41)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1483448977, "CC(AlertDialogImpl)N(onDismissRequest,confirmButton,modifier,dismissButton,title,text,shape,backgroundColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,properties)149@6875L386,147@6799L678:AlertDialog.kt#jmzs0o");
                    int i212 = (2147483646 & i15) >> 3;
                    composer2 = composerStartRestartGroup;
                    m2242AlertDialogwqdebIU(function0, ComposableLambdaKt.rememberComposableLambda(-309297447, true, new AlertDialogKt$AlertDialogImpl$1(function6, function2), composerStartRestartGroup, 54), modifier4, function12, function13, shape3, j5, j6, dialogProperties3, composer2, (i15 & 896) | (i15 & 14) | 48 | (i212 & 7168) | (57344 & i212) | (458752 & i212) | (3670016 & i212) | (29360128 & i212) | (i212 & 234881024), 0);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    function9 = function6;
                    modifier3 = modifier4;
                    function10 = function12;
                    function11 = function13;
                    shape2 = shape3;
                    j3 = j5;
                    j4 = j6;
                    dialogProperties2 = dialogProperties3;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    modifier3 = modifier2;
                    function9 = function6;
                    function10 = function7;
                    function11 = function8;
                    shape2 = medium;
                    j3 = j;
                    j4 = j2;
                    dialogProperties2 = dialogProperties;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.AndroidAlertDialog_androidKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return AndroidAlertDialog_androidKt.AlertDialog_6oU6zVQ$lambda$0(function0, function2, modifier3, function9, function10, function11, shape2, j3, j4, dialogProperties2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 3072;
            function6 = function3;
            i6 = i2 & 16;
            if (i6 != 0) {
                if ((i & 24576) == 0) {
                    function7 = function4;
                    if (composerStartRestartGroup.changedInstance(function7)) {
                        i7 = 16384;
                    } else {
                        i7 = 8192;
                    }
                    i3 |= i7;
                }
                i8 = i2 & 32;
                if (i8 != 0) {
                    if ((196608 & i) == 0) {
                        function8 = function5;
                        if (composerStartRestartGroup.changedInstance(function8)) {
                            i9 = 131072;
                        } else {
                            i9 = 65536;
                        }
                        i3 |= i9;
                    }
                    if ((1572864 & i) == 0) {
                        if ((i2 & 64) == 0) {
                            medium = shape;
                            if (composerStartRestartGroup.changed(medium)) {
                            }
                            i3 |= i19;
                        } else {
                            medium = shape;
                        }
                        i3 |= i19;
                    } else {
                        medium = shape;
                    }
                    if ((i & 12582912) == 0) {
                        if ((i2 & 128) == 0) {
                            i17 = i3;
                            i11 = i18;
                            if (composerStartRestartGroup.changed(j)) {
                            }
                            i10 = i17 | i20;
                        } else {
                            i17 = i3;
                            i11 = i18;
                        }
                        i10 = i17 | i20;
                    } else {
                        i10 = i3;
                        i11 = i18;
                    }
                    if ((i & 100663296) == 0) {
                        int i213 = i10;
                        if ((i2 & 256) == 0) {
                            i16 = 33554432;
                        } else {
                            i16 = 33554432;
                        }
                        i10 = i213 | i16;
                    }
                    i12 = i10;
                    i13 = i2 & 512;
                    if (i13 != 0) {
                        if ((i & 805306368) == 0) {
                            if (composerStartRestartGroup.changed(dialogProperties)) {
                                i14 = C.BUFFER_FLAG_LAST_SAMPLE;
                            } else {
                                i14 = 268435456;
                            }
                            i12 |= i14;
                        }
                        if ((i12 & 306783379) != 306783378) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (composerStartRestartGroup.shouldExecute(z, i12 & 1)) {
                            composerStartRestartGroup.startDefaults();
                            ComposerKt.sourceInformation(composerStartRestartGroup, "77@4252L6,77@4310L6,77@4352L32");
                            if ((i & 1) != 0) {
                                if (i11 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                if (i4 != 0) {
                                    function6 = null;
                                }
                                if (i6 != 0) {
                                    function7 = null;
                                }
                                if (i8 != 0) {
                                    function8 = null;
                                }
                                if ((i2 & 64) != 0) {
                                    i12 &= -3670017;
                                    medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                                }
                                if ((i2 & 128) != 0) {
                                    i12 &= -29360129;
                                    jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                                } else {
                                    jM2346getSurface0d7_KjU = j;
                                }
                                if ((i2 & 256) != 0) {
                                    jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i12 >> 21) & 14);
                                    i12 &= -234881025;
                                } else {
                                    jM2360contentColorForek8zF_U = j2;
                                }
                                if (i13 != 0) {
                                    dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                                } else {
                                    dialogProperties3 = dialogProperties;
                                }
                                j5 = jM2346getSurface0d7_KjU;
                                function12 = function7;
                                i15 = i12;
                                j6 = jM2360contentColorForek8zF_U;
                                modifier4 = modifier2;
                                function13 = function8;
                                shape3 = medium;
                            } else {
                                if (i11 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                if (i4 != 0) {
                                    function6 = null;
                                }
                                if (i6 != 0) {
                                    function7 = null;
                                }
                                if (i8 != 0) {
                                    function8 = null;
                                }
                                if ((i2 & 64) != 0) {
                                    i12 &= -3670017;
                                    medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                                }
                                if ((i2 & 128) != 0) {
                                    i12 &= -29360129;
                                    jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                                } else {
                                    jM2346getSurface0d7_KjU = j;
                                }
                                if ((i2 & 256) != 0) {
                                    jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i12 >> 21) & 14);
                                    i12 &= -234881025;
                                } else {
                                    jM2360contentColorForek8zF_U = j2;
                                }
                                if (i13 != 0) {
                                    dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                                } else {
                                    dialogProperties3 = dialogProperties;
                                }
                                j5 = jM2346getSurface0d7_KjU;
                                function12 = function7;
                                i15 = i12;
                                j6 = jM2360contentColorForek8zF_U;
                                modifier4 = modifier2;
                                function13 = function8;
                                shape3 = medium;
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1967984963, i15, -1, "androidx.compose.material.AlertDialog (AndroidAlertDialog.android.kt:41)");
                            }
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1483448977, "CC(AlertDialogImpl)N(onDismissRequest,confirmButton,modifier,dismissButton,title,text,shape,backgroundColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,properties)149@6875L386,147@6799L678:AlertDialog.kt#jmzs0o");
                            int i214 = (2147483646 & i15) >> 3;
                            composer2 = composerStartRestartGroup;
                            m2242AlertDialogwqdebIU(function0, ComposableLambdaKt.rememberComposableLambda(-309297447, true, new AlertDialogKt$AlertDialogImpl$1(function6, function2), composerStartRestartGroup, 54), modifier4, function12, function13, shape3, j5, j6, dialogProperties3, composer2, (i15 & 896) | (i15 & 14) | 48 | (i214 & 7168) | (57344 & i214) | (458752 & i214) | (3670016 & i214) | (29360128 & i214) | (i214 & 234881024), 0);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            function9 = function6;
                            modifier3 = modifier4;
                            function10 = function12;
                            function11 = function13;
                            shape2 = shape3;
                            j3 = j5;
                            j4 = j6;
                            dialogProperties2 = dialogProperties3;
                        } else {
                            composer2 = composerStartRestartGroup;
                            composer2.skipToGroupEnd();
                            modifier3 = modifier2;
                            function9 = function6;
                            function10 = function7;
                            function11 = function8;
                            shape2 = medium;
                            j3 = j;
                            j4 = j2;
                            dialogProperties2 = dialogProperties;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.AndroidAlertDialog_androidKt$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return AndroidAlertDialog_androidKt.AlertDialog_6oU6zVQ$lambda$0(function0, function2, modifier3, function9, function10, function11, shape2, j3, j4, dialogProperties2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                        }
                    }
                    i12 |= 805306368;
                    if ((i12 & 306783379) != 306783378) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z, i12 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "77@4252L6,77@4310L6,77@4352L32");
                        if ((i & 1) != 0) {
                            if (i11 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                function6 = null;
                            }
                            if (i6 != 0) {
                                function7 = null;
                            }
                            if (i8 != 0) {
                                function8 = null;
                            }
                            if ((i2 & 64) != 0) {
                                i12 &= -3670017;
                                medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                            }
                            if ((i2 & 128) != 0) {
                                i12 &= -29360129;
                                jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                            } else {
                                jM2346getSurface0d7_KjU = j;
                            }
                            if ((i2 & 256) != 0) {
                                jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i12 >> 21) & 14);
                                i12 &= -234881025;
                            } else {
                                jM2360contentColorForek8zF_U = j2;
                            }
                            if (i13 != 0) {
                                dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                            } else {
                                dialogProperties3 = dialogProperties;
                            }
                            j5 = jM2346getSurface0d7_KjU;
                            function12 = function7;
                            i15 = i12;
                            j6 = jM2360contentColorForek8zF_U;
                            modifier4 = modifier2;
                            function13 = function8;
                            shape3 = medium;
                        } else {
                            if (i11 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                function6 = null;
                            }
                            if (i6 != 0) {
                                function7 = null;
                            }
                            if (i8 != 0) {
                                function8 = null;
                            }
                            if ((i2 & 64) != 0) {
                                i12 &= -3670017;
                                medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                            }
                            if ((i2 & 128) != 0) {
                                i12 &= -29360129;
                                jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                            } else {
                                jM2346getSurface0d7_KjU = j;
                            }
                            if ((i2 & 256) != 0) {
                                jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i12 >> 21) & 14);
                                i12 &= -234881025;
                            } else {
                                jM2360contentColorForek8zF_U = j2;
                            }
                            if (i13 != 0) {
                                dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                            } else {
                                dialogProperties3 = dialogProperties;
                            }
                            j5 = jM2346getSurface0d7_KjU;
                            function12 = function7;
                            i15 = i12;
                            j6 = jM2360contentColorForek8zF_U;
                            modifier4 = modifier2;
                            function13 = function8;
                            shape3 = medium;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1967984963, i15, -1, "androidx.compose.material.AlertDialog (AndroidAlertDialog.android.kt:41)");
                        }
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1483448977, "CC(AlertDialogImpl)N(onDismissRequest,confirmButton,modifier,dismissButton,title,text,shape,backgroundColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,properties)149@6875L386,147@6799L678:AlertDialog.kt#jmzs0o");
                        int i215 = (2147483646 & i15) >> 3;
                        composer2 = composerStartRestartGroup;
                        m2242AlertDialogwqdebIU(function0, ComposableLambdaKt.rememberComposableLambda(-309297447, true, new AlertDialogKt$AlertDialogImpl$1(function6, function2), composerStartRestartGroup, 54), modifier4, function12, function13, shape3, j5, j6, dialogProperties3, composer2, (i15 & 896) | (i15 & 14) | 48 | (i215 & 7168) | (57344 & i215) | (458752 & i215) | (3670016 & i215) | (29360128 & i215) | (i215 & 234881024), 0);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        function9 = function6;
                        modifier3 = modifier4;
                        function10 = function12;
                        function11 = function13;
                        shape2 = shape3;
                        j3 = j5;
                        j4 = j6;
                        dialogProperties2 = dialogProperties3;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        modifier3 = modifier2;
                        function9 = function6;
                        function10 = function7;
                        function11 = function8;
                        shape2 = medium;
                        j3 = j;
                        j4 = j2;
                        dialogProperties2 = dialogProperties;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.AndroidAlertDialog_androidKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return AndroidAlertDialog_androidKt.AlertDialog_6oU6zVQ$lambda$0(function0, function2, modifier3, function9, function10, function11, shape2, j3, j4, dialogProperties2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                function8 = function5;
                if ((1572864 & i) == 0) {
                    if ((i2 & 64) == 0) {
                        medium = shape;
                        if (composerStartRestartGroup.changed(medium)) {
                        }
                        i3 |= i19;
                    } else {
                        medium = shape;
                    }
                    i3 |= i19;
                } else {
                    medium = shape;
                }
                if ((i & 12582912) == 0) {
                    if ((i2 & 128) == 0) {
                        i17 = i3;
                        i11 = i18;
                        if (composerStartRestartGroup.changed(j)) {
                        }
                        i10 = i17 | i20;
                    } else {
                        i17 = i3;
                        i11 = i18;
                    }
                    i10 = i17 | i20;
                } else {
                    i10 = i3;
                    i11 = i18;
                }
                if ((i & 100663296) == 0) {
                    int i216 = i10;
                    if ((i2 & 256) == 0) {
                        i16 = 33554432;
                    } else {
                        i16 = 33554432;
                    }
                    i10 = i216 | i16;
                }
                i12 = i10;
                i13 = i2 & 512;
                if (i13 != 0) {
                    if ((i & 805306368) == 0) {
                        if (composerStartRestartGroup.changed(dialogProperties)) {
                            i14 = C.BUFFER_FLAG_LAST_SAMPLE;
                        } else {
                            i14 = 268435456;
                        }
                        i12 |= i14;
                    }
                    if ((i12 & 306783379) != 306783378) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z, i12 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "77@4252L6,77@4310L6,77@4352L32");
                        if ((i & 1) != 0) {
                            if (i11 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                function6 = null;
                            }
                            if (i6 != 0) {
                                function7 = null;
                            }
                            if (i8 != 0) {
                                function8 = null;
                            }
                            if ((i2 & 64) != 0) {
                                i12 &= -3670017;
                                medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                            }
                            if ((i2 & 128) != 0) {
                                i12 &= -29360129;
                                jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                            } else {
                                jM2346getSurface0d7_KjU = j;
                            }
                            if ((i2 & 256) != 0) {
                                jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i12 >> 21) & 14);
                                i12 &= -234881025;
                            } else {
                                jM2360contentColorForek8zF_U = j2;
                            }
                            if (i13 != 0) {
                                dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                            } else {
                                dialogProperties3 = dialogProperties;
                            }
                            j5 = jM2346getSurface0d7_KjU;
                            function12 = function7;
                            i15 = i12;
                            j6 = jM2360contentColorForek8zF_U;
                            modifier4 = modifier2;
                            function13 = function8;
                            shape3 = medium;
                        } else {
                            if (i11 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                function6 = null;
                            }
                            if (i6 != 0) {
                                function7 = null;
                            }
                            if (i8 != 0) {
                                function8 = null;
                            }
                            if ((i2 & 64) != 0) {
                                i12 &= -3670017;
                                medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                            }
                            if ((i2 & 128) != 0) {
                                i12 &= -29360129;
                                jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                            } else {
                                jM2346getSurface0d7_KjU = j;
                            }
                            if ((i2 & 256) != 0) {
                                jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i12 >> 21) & 14);
                                i12 &= -234881025;
                            } else {
                                jM2360contentColorForek8zF_U = j2;
                            }
                            if (i13 != 0) {
                                dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                            } else {
                                dialogProperties3 = dialogProperties;
                            }
                            j5 = jM2346getSurface0d7_KjU;
                            function12 = function7;
                            i15 = i12;
                            j6 = jM2360contentColorForek8zF_U;
                            modifier4 = modifier2;
                            function13 = function8;
                            shape3 = medium;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1967984963, i15, -1, "androidx.compose.material.AlertDialog (AndroidAlertDialog.android.kt:41)");
                        }
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1483448977, "CC(AlertDialogImpl)N(onDismissRequest,confirmButton,modifier,dismissButton,title,text,shape,backgroundColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,properties)149@6875L386,147@6799L678:AlertDialog.kt#jmzs0o");
                        int i217 = (2147483646 & i15) >> 3;
                        composer2 = composerStartRestartGroup;
                        m2242AlertDialogwqdebIU(function0, ComposableLambdaKt.rememberComposableLambda(-309297447, true, new AlertDialogKt$AlertDialogImpl$1(function6, function2), composerStartRestartGroup, 54), modifier4, function12, function13, shape3, j5, j6, dialogProperties3, composer2, (i15 & 896) | (i15 & 14) | 48 | (i217 & 7168) | (57344 & i217) | (458752 & i217) | (3670016 & i217) | (29360128 & i217) | (i217 & 234881024), 0);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        function9 = function6;
                        modifier3 = modifier4;
                        function10 = function12;
                        function11 = function13;
                        shape2 = shape3;
                        j3 = j5;
                        j4 = j6;
                        dialogProperties2 = dialogProperties3;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        modifier3 = modifier2;
                        function9 = function6;
                        function10 = function7;
                        function11 = function8;
                        shape2 = medium;
                        j3 = j;
                        j4 = j2;
                        dialogProperties2 = dialogProperties;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.AndroidAlertDialog_androidKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return AndroidAlertDialog_androidKt.AlertDialog_6oU6zVQ$lambda$0(function0, function2, modifier3, function9, function10, function11, shape2, j3, j4, dialogProperties2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i12 |= 805306368;
                if ((i12 & 306783379) != 306783378) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i12 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "77@4252L6,77@4310L6,77@4352L32");
                    if ((i & 1) != 0) {
                        if (i11 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            function6 = null;
                        }
                        if (i6 != 0) {
                            function7 = null;
                        }
                        if (i8 != 0) {
                            function8 = null;
                        }
                        if ((i2 & 64) != 0) {
                            i12 &= -3670017;
                            medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                        }
                        if ((i2 & 128) != 0) {
                            i12 &= -29360129;
                            jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                        } else {
                            jM2346getSurface0d7_KjU = j;
                        }
                        if ((i2 & 256) != 0) {
                            jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i12 >> 21) & 14);
                            i12 &= -234881025;
                        } else {
                            jM2360contentColorForek8zF_U = j2;
                        }
                        if (i13 != 0) {
                            dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                        } else {
                            dialogProperties3 = dialogProperties;
                        }
                        j5 = jM2346getSurface0d7_KjU;
                        function12 = function7;
                        i15 = i12;
                        j6 = jM2360contentColorForek8zF_U;
                        modifier4 = modifier2;
                        function13 = function8;
                        shape3 = medium;
                    } else {
                        if (i11 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            function6 = null;
                        }
                        if (i6 != 0) {
                            function7 = null;
                        }
                        if (i8 != 0) {
                            function8 = null;
                        }
                        if ((i2 & 64) != 0) {
                            i12 &= -3670017;
                            medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                        }
                        if ((i2 & 128) != 0) {
                            i12 &= -29360129;
                            jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                        } else {
                            jM2346getSurface0d7_KjU = j;
                        }
                        if ((i2 & 256) != 0) {
                            jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i12 >> 21) & 14);
                            i12 &= -234881025;
                        } else {
                            jM2360contentColorForek8zF_U = j2;
                        }
                        if (i13 != 0) {
                            dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                        } else {
                            dialogProperties3 = dialogProperties;
                        }
                        j5 = jM2346getSurface0d7_KjU;
                        function12 = function7;
                        i15 = i12;
                        j6 = jM2360contentColorForek8zF_U;
                        modifier4 = modifier2;
                        function13 = function8;
                        shape3 = medium;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1967984963, i15, -1, "androidx.compose.material.AlertDialog (AndroidAlertDialog.android.kt:41)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1483448977, "CC(AlertDialogImpl)N(onDismissRequest,confirmButton,modifier,dismissButton,title,text,shape,backgroundColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,properties)149@6875L386,147@6799L678:AlertDialog.kt#jmzs0o");
                    int i218 = (2147483646 & i15) >> 3;
                    composer2 = composerStartRestartGroup;
                    m2242AlertDialogwqdebIU(function0, ComposableLambdaKt.rememberComposableLambda(-309297447, true, new AlertDialogKt$AlertDialogImpl$1(function6, function2), composerStartRestartGroup, 54), modifier4, function12, function13, shape3, j5, j6, dialogProperties3, composer2, (i15 & 896) | (i15 & 14) | 48 | (i218 & 7168) | (57344 & i218) | (458752 & i218) | (3670016 & i218) | (29360128 & i218) | (i218 & 234881024), 0);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    function9 = function6;
                    modifier3 = modifier4;
                    function10 = function12;
                    function11 = function13;
                    shape2 = shape3;
                    j3 = j5;
                    j4 = j6;
                    dialogProperties2 = dialogProperties3;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    modifier3 = modifier2;
                    function9 = function6;
                    function10 = function7;
                    function11 = function8;
                    shape2 = medium;
                    j3 = j;
                    j4 = j2;
                    dialogProperties2 = dialogProperties;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.AndroidAlertDialog_androidKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return AndroidAlertDialog_androidKt.AlertDialog_6oU6zVQ$lambda$0(function0, function2, modifier3, function9, function10, function11, shape2, j3, j4, dialogProperties2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 24576;
            function7 = function4;
            i8 = i2 & 32;
            if (i8 != 0) {
                if ((196608 & i) == 0) {
                    function8 = function5;
                    if (composerStartRestartGroup.changedInstance(function8)) {
                        i9 = 131072;
                    } else {
                        i9 = 65536;
                    }
                    i3 |= i9;
                }
                if ((1572864 & i) == 0) {
                    if ((i2 & 64) == 0) {
                        medium = shape;
                        if (composerStartRestartGroup.changed(medium)) {
                        }
                        i3 |= i19;
                    } else {
                        medium = shape;
                    }
                    i3 |= i19;
                } else {
                    medium = shape;
                }
                if ((i & 12582912) == 0) {
                    if ((i2 & 128) == 0) {
                        i17 = i3;
                        i11 = i18;
                        if (composerStartRestartGroup.changed(j)) {
                        }
                        i10 = i17 | i20;
                    } else {
                        i17 = i3;
                        i11 = i18;
                    }
                    i10 = i17 | i20;
                } else {
                    i10 = i3;
                    i11 = i18;
                }
                if ((i & 100663296) == 0) {
                    int i219 = i10;
                    if ((i2 & 256) == 0) {
                        i16 = 33554432;
                    } else {
                        i16 = 33554432;
                    }
                    i10 = i219 | i16;
                }
                i12 = i10;
                i13 = i2 & 512;
                if (i13 != 0) {
                    if ((i & 805306368) == 0) {
                        if (composerStartRestartGroup.changed(dialogProperties)) {
                            i14 = C.BUFFER_FLAG_LAST_SAMPLE;
                        } else {
                            i14 = 268435456;
                        }
                        i12 |= i14;
                    }
                    if ((i12 & 306783379) != 306783378) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z, i12 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "77@4252L6,77@4310L6,77@4352L32");
                        if ((i & 1) != 0) {
                            if (i11 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                function6 = null;
                            }
                            if (i6 != 0) {
                                function7 = null;
                            }
                            if (i8 != 0) {
                                function8 = null;
                            }
                            if ((i2 & 64) != 0) {
                                i12 &= -3670017;
                                medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                            }
                            if ((i2 & 128) != 0) {
                                i12 &= -29360129;
                                jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                            } else {
                                jM2346getSurface0d7_KjU = j;
                            }
                            if ((i2 & 256) != 0) {
                                jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i12 >> 21) & 14);
                                i12 &= -234881025;
                            } else {
                                jM2360contentColorForek8zF_U = j2;
                            }
                            if (i13 != 0) {
                                dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                            } else {
                                dialogProperties3 = dialogProperties;
                            }
                            j5 = jM2346getSurface0d7_KjU;
                            function12 = function7;
                            i15 = i12;
                            j6 = jM2360contentColorForek8zF_U;
                            modifier4 = modifier2;
                            function13 = function8;
                            shape3 = medium;
                        } else {
                            if (i11 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                function6 = null;
                            }
                            if (i6 != 0) {
                                function7 = null;
                            }
                            if (i8 != 0) {
                                function8 = null;
                            }
                            if ((i2 & 64) != 0) {
                                i12 &= -3670017;
                                medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                            }
                            if ((i2 & 128) != 0) {
                                i12 &= -29360129;
                                jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                            } else {
                                jM2346getSurface0d7_KjU = j;
                            }
                            if ((i2 & 256) != 0) {
                                jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i12 >> 21) & 14);
                                i12 &= -234881025;
                            } else {
                                jM2360contentColorForek8zF_U = j2;
                            }
                            if (i13 != 0) {
                                dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                            } else {
                                dialogProperties3 = dialogProperties;
                            }
                            j5 = jM2346getSurface0d7_KjU;
                            function12 = function7;
                            i15 = i12;
                            j6 = jM2360contentColorForek8zF_U;
                            modifier4 = modifier2;
                            function13 = function8;
                            shape3 = medium;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1967984963, i15, -1, "androidx.compose.material.AlertDialog (AndroidAlertDialog.android.kt:41)");
                        }
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1483448977, "CC(AlertDialogImpl)N(onDismissRequest,confirmButton,modifier,dismissButton,title,text,shape,backgroundColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,properties)149@6875L386,147@6799L678:AlertDialog.kt#jmzs0o");
                        int i2110 = (2147483646 & i15) >> 3;
                        composer2 = composerStartRestartGroup;
                        m2242AlertDialogwqdebIU(function0, ComposableLambdaKt.rememberComposableLambda(-309297447, true, new AlertDialogKt$AlertDialogImpl$1(function6, function2), composerStartRestartGroup, 54), modifier4, function12, function13, shape3, j5, j6, dialogProperties3, composer2, (i15 & 896) | (i15 & 14) | 48 | (i2110 & 7168) | (57344 & i2110) | (458752 & i2110) | (3670016 & i2110) | (29360128 & i2110) | (i2110 & 234881024), 0);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        function9 = function6;
                        modifier3 = modifier4;
                        function10 = function12;
                        function11 = function13;
                        shape2 = shape3;
                        j3 = j5;
                        j4 = j6;
                        dialogProperties2 = dialogProperties3;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        modifier3 = modifier2;
                        function9 = function6;
                        function10 = function7;
                        function11 = function8;
                        shape2 = medium;
                        j3 = j;
                        j4 = j2;
                        dialogProperties2 = dialogProperties;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.AndroidAlertDialog_androidKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return AndroidAlertDialog_androidKt.AlertDialog_6oU6zVQ$lambda$0(function0, function2, modifier3, function9, function10, function11, shape2, j3, j4, dialogProperties2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i12 |= 805306368;
                if ((i12 & 306783379) != 306783378) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i12 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "77@4252L6,77@4310L6,77@4352L32");
                    if ((i & 1) != 0) {
                        if (i11 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            function6 = null;
                        }
                        if (i6 != 0) {
                            function7 = null;
                        }
                        if (i8 != 0) {
                            function8 = null;
                        }
                        if ((i2 & 64) != 0) {
                            i12 &= -3670017;
                            medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                        }
                        if ((i2 & 128) != 0) {
                            i12 &= -29360129;
                            jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                        } else {
                            jM2346getSurface0d7_KjU = j;
                        }
                        if ((i2 & 256) != 0) {
                            jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i12 >> 21) & 14);
                            i12 &= -234881025;
                        } else {
                            jM2360contentColorForek8zF_U = j2;
                        }
                        if (i13 != 0) {
                            dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                        } else {
                            dialogProperties3 = dialogProperties;
                        }
                        j5 = jM2346getSurface0d7_KjU;
                        function12 = function7;
                        i15 = i12;
                        j6 = jM2360contentColorForek8zF_U;
                        modifier4 = modifier2;
                        function13 = function8;
                        shape3 = medium;
                    } else {
                        if (i11 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            function6 = null;
                        }
                        if (i6 != 0) {
                            function7 = null;
                        }
                        if (i8 != 0) {
                            function8 = null;
                        }
                        if ((i2 & 64) != 0) {
                            i12 &= -3670017;
                            medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                        }
                        if ((i2 & 128) != 0) {
                            i12 &= -29360129;
                            jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                        } else {
                            jM2346getSurface0d7_KjU = j;
                        }
                        if ((i2 & 256) != 0) {
                            jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i12 >> 21) & 14);
                            i12 &= -234881025;
                        } else {
                            jM2360contentColorForek8zF_U = j2;
                        }
                        if (i13 != 0) {
                            dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                        } else {
                            dialogProperties3 = dialogProperties;
                        }
                        j5 = jM2346getSurface0d7_KjU;
                        function12 = function7;
                        i15 = i12;
                        j6 = jM2360contentColorForek8zF_U;
                        modifier4 = modifier2;
                        function13 = function8;
                        shape3 = medium;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1967984963, i15, -1, "androidx.compose.material.AlertDialog (AndroidAlertDialog.android.kt:41)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1483448977, "CC(AlertDialogImpl)N(onDismissRequest,confirmButton,modifier,dismissButton,title,text,shape,backgroundColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,properties)149@6875L386,147@6799L678:AlertDialog.kt#jmzs0o");
                    int i2111 = (2147483646 & i15) >> 3;
                    composer2 = composerStartRestartGroup;
                    m2242AlertDialogwqdebIU(function0, ComposableLambdaKt.rememberComposableLambda(-309297447, true, new AlertDialogKt$AlertDialogImpl$1(function6, function2), composerStartRestartGroup, 54), modifier4, function12, function13, shape3, j5, j6, dialogProperties3, composer2, (i15 & 896) | (i15 & 14) | 48 | (i2111 & 7168) | (57344 & i2111) | (458752 & i2111) | (3670016 & i2111) | (29360128 & i2111) | (i2111 & 234881024), 0);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    function9 = function6;
                    modifier3 = modifier4;
                    function10 = function12;
                    function11 = function13;
                    shape2 = shape3;
                    j3 = j5;
                    j4 = j6;
                    dialogProperties2 = dialogProperties3;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    modifier3 = modifier2;
                    function9 = function6;
                    function10 = function7;
                    function11 = function8;
                    shape2 = medium;
                    j3 = j;
                    j4 = j2;
                    dialogProperties2 = dialogProperties;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.AndroidAlertDialog_androidKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return AndroidAlertDialog_androidKt.AlertDialog_6oU6zVQ$lambda$0(function0, function2, modifier3, function9, function10, function11, shape2, j3, j4, dialogProperties2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            function8 = function5;
            if ((1572864 & i) == 0) {
                if ((i2 & 64) == 0) {
                    medium = shape;
                    if (composerStartRestartGroup.changed(medium)) {
                    }
                    i3 |= i19;
                } else {
                    medium = shape;
                }
                i3 |= i19;
            } else {
                medium = shape;
            }
            if ((i & 12582912) == 0) {
                if ((i2 & 128) == 0) {
                    i17 = i3;
                    i11 = i18;
                    if (composerStartRestartGroup.changed(j)) {
                    }
                    i10 = i17 | i20;
                } else {
                    i17 = i3;
                    i11 = i18;
                }
                i10 = i17 | i20;
            } else {
                i10 = i3;
                i11 = i18;
            }
            if ((i & 100663296) == 0) {
                int i2112 = i10;
                if ((i2 & 256) == 0) {
                    i16 = 33554432;
                } else {
                    i16 = 33554432;
                }
                i10 = i2112 | i16;
            }
            i12 = i10;
            i13 = i2 & 512;
            if (i13 != 0) {
                if ((i & 805306368) == 0) {
                    if (composerStartRestartGroup.changed(dialogProperties)) {
                        i14 = C.BUFFER_FLAG_LAST_SAMPLE;
                    } else {
                        i14 = 268435456;
                    }
                    i12 |= i14;
                }
                if ((i12 & 306783379) != 306783378) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i12 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "77@4252L6,77@4310L6,77@4352L32");
                    if ((i & 1) != 0) {
                        if (i11 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            function6 = null;
                        }
                        if (i6 != 0) {
                            function7 = null;
                        }
                        if (i8 != 0) {
                            function8 = null;
                        }
                        if ((i2 & 64) != 0) {
                            i12 &= -3670017;
                            medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                        }
                        if ((i2 & 128) != 0) {
                            i12 &= -29360129;
                            jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                        } else {
                            jM2346getSurface0d7_KjU = j;
                        }
                        if ((i2 & 256) != 0) {
                            jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i12 >> 21) & 14);
                            i12 &= -234881025;
                        } else {
                            jM2360contentColorForek8zF_U = j2;
                        }
                        if (i13 != 0) {
                            dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                        } else {
                            dialogProperties3 = dialogProperties;
                        }
                        j5 = jM2346getSurface0d7_KjU;
                        function12 = function7;
                        i15 = i12;
                        j6 = jM2360contentColorForek8zF_U;
                        modifier4 = modifier2;
                        function13 = function8;
                        shape3 = medium;
                    } else {
                        if (i11 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            function6 = null;
                        }
                        if (i6 != 0) {
                            function7 = null;
                        }
                        if (i8 != 0) {
                            function8 = null;
                        }
                        if ((i2 & 64) != 0) {
                            i12 &= -3670017;
                            medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                        }
                        if ((i2 & 128) != 0) {
                            i12 &= -29360129;
                            jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                        } else {
                            jM2346getSurface0d7_KjU = j;
                        }
                        if ((i2 & 256) != 0) {
                            jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i12 >> 21) & 14);
                            i12 &= -234881025;
                        } else {
                            jM2360contentColorForek8zF_U = j2;
                        }
                        if (i13 != 0) {
                            dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                        } else {
                            dialogProperties3 = dialogProperties;
                        }
                        j5 = jM2346getSurface0d7_KjU;
                        function12 = function7;
                        i15 = i12;
                        j6 = jM2360contentColorForek8zF_U;
                        modifier4 = modifier2;
                        function13 = function8;
                        shape3 = medium;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1967984963, i15, -1, "androidx.compose.material.AlertDialog (AndroidAlertDialog.android.kt:41)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1483448977, "CC(AlertDialogImpl)N(onDismissRequest,confirmButton,modifier,dismissButton,title,text,shape,backgroundColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,properties)149@6875L386,147@6799L678:AlertDialog.kt#jmzs0o");
                    int i2113 = (2147483646 & i15) >> 3;
                    composer2 = composerStartRestartGroup;
                    m2242AlertDialogwqdebIU(function0, ComposableLambdaKt.rememberComposableLambda(-309297447, true, new AlertDialogKt$AlertDialogImpl$1(function6, function2), composerStartRestartGroup, 54), modifier4, function12, function13, shape3, j5, j6, dialogProperties3, composer2, (i15 & 896) | (i15 & 14) | 48 | (i2113 & 7168) | (57344 & i2113) | (458752 & i2113) | (3670016 & i2113) | (29360128 & i2113) | (i2113 & 234881024), 0);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    function9 = function6;
                    modifier3 = modifier4;
                    function10 = function12;
                    function11 = function13;
                    shape2 = shape3;
                    j3 = j5;
                    j4 = j6;
                    dialogProperties2 = dialogProperties3;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    modifier3 = modifier2;
                    function9 = function6;
                    function10 = function7;
                    function11 = function8;
                    shape2 = medium;
                    j3 = j;
                    j4 = j2;
                    dialogProperties2 = dialogProperties;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.AndroidAlertDialog_androidKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return AndroidAlertDialog_androidKt.AlertDialog_6oU6zVQ$lambda$0(function0, function2, modifier3, function9, function10, function11, shape2, j3, j4, dialogProperties2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i12 |= 805306368;
            if ((i12 & 306783379) != 306783378) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i12 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "77@4252L6,77@4310L6,77@4352L32");
                if ((i & 1) != 0) {
                    if (i11 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        function6 = null;
                    }
                    if (i6 != 0) {
                        function7 = null;
                    }
                    if (i8 != 0) {
                        function8 = null;
                    }
                    if ((i2 & 64) != 0) {
                        i12 &= -3670017;
                        medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                    }
                    if ((i2 & 128) != 0) {
                        i12 &= -29360129;
                        jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                    } else {
                        jM2346getSurface0d7_KjU = j;
                    }
                    if ((i2 & 256) != 0) {
                        jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i12 >> 21) & 14);
                        i12 &= -234881025;
                    } else {
                        jM2360contentColorForek8zF_U = j2;
                    }
                    if (i13 != 0) {
                        dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                    } else {
                        dialogProperties3 = dialogProperties;
                    }
                    j5 = jM2346getSurface0d7_KjU;
                    function12 = function7;
                    i15 = i12;
                    j6 = jM2360contentColorForek8zF_U;
                    modifier4 = modifier2;
                    function13 = function8;
                    shape3 = medium;
                } else {
                    if (i11 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        function6 = null;
                    }
                    if (i6 != 0) {
                        function7 = null;
                    }
                    if (i8 != 0) {
                        function8 = null;
                    }
                    if ((i2 & 64) != 0) {
                        i12 &= -3670017;
                        medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                    }
                    if ((i2 & 128) != 0) {
                        i12 &= -29360129;
                        jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                    } else {
                        jM2346getSurface0d7_KjU = j;
                    }
                    if ((i2 & 256) != 0) {
                        jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i12 >> 21) & 14);
                        i12 &= -234881025;
                    } else {
                        jM2360contentColorForek8zF_U = j2;
                    }
                    if (i13 != 0) {
                        dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                    } else {
                        dialogProperties3 = dialogProperties;
                    }
                    j5 = jM2346getSurface0d7_KjU;
                    function12 = function7;
                    i15 = i12;
                    j6 = jM2360contentColorForek8zF_U;
                    modifier4 = modifier2;
                    function13 = function8;
                    shape3 = medium;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1967984963, i15, -1, "androidx.compose.material.AlertDialog (AndroidAlertDialog.android.kt:41)");
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1483448977, "CC(AlertDialogImpl)N(onDismissRequest,confirmButton,modifier,dismissButton,title,text,shape,backgroundColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,properties)149@6875L386,147@6799L678:AlertDialog.kt#jmzs0o");
                int i2114 = (2147483646 & i15) >> 3;
                composer2 = composerStartRestartGroup;
                m2242AlertDialogwqdebIU(function0, ComposableLambdaKt.rememberComposableLambda(-309297447, true, new AlertDialogKt$AlertDialogImpl$1(function6, function2), composerStartRestartGroup, 54), modifier4, function12, function13, shape3, j5, j6, dialogProperties3, composer2, (i15 & 896) | (i15 & 14) | 48 | (i2114 & 7168) | (57344 & i2114) | (458752 & i2114) | (3670016 & i2114) | (29360128 & i2114) | (i2114 & 234881024), 0);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                function9 = function6;
                modifier3 = modifier4;
                function10 = function12;
                function11 = function13;
                shape2 = shape3;
                j3 = j5;
                j4 = j6;
                dialogProperties2 = dialogProperties3;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier3 = modifier2;
                function9 = function6;
                function10 = function7;
                function11 = function8;
                shape2 = medium;
                j3 = j;
                j4 = j2;
                dialogProperties2 = dialogProperties;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.AndroidAlertDialog_androidKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return AndroidAlertDialog_androidKt.AlertDialog_6oU6zVQ$lambda$0(function0, function2, modifier3, function9, function10, function11, shape2, j3, j4, dialogProperties2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 384;
        modifier2 = modifier;
        i4 = i2 & 8;
        if (i4 != 0) {
            if ((i & 3072) == 0) {
                function6 = function3;
                if (composerStartRestartGroup.changedInstance(function6)) {
                    i5 = 2048;
                } else {
                    i5 = 1024;
                }
                i3 |= i5;
            }
            i6 = i2 & 16;
            if (i6 != 0) {
                if ((i & 24576) == 0) {
                    function7 = function4;
                    if (composerStartRestartGroup.changedInstance(function7)) {
                        i7 = 16384;
                    } else {
                        i7 = 8192;
                    }
                    i3 |= i7;
                }
                i8 = i2 & 32;
                if (i8 != 0) {
                    if ((196608 & i) == 0) {
                        function8 = function5;
                        if (composerStartRestartGroup.changedInstance(function8)) {
                            i9 = 131072;
                        } else {
                            i9 = 65536;
                        }
                        i3 |= i9;
                    }
                    if ((1572864 & i) == 0) {
                        if ((i2 & 64) == 0) {
                            medium = shape;
                            if (composerStartRestartGroup.changed(medium)) {
                            }
                            i3 |= i19;
                        } else {
                            medium = shape;
                        }
                        i3 |= i19;
                    } else {
                        medium = shape;
                    }
                    if ((i & 12582912) == 0) {
                        if ((i2 & 128) == 0) {
                            i17 = i3;
                            i11 = i18;
                            if (composerStartRestartGroup.changed(j)) {
                            }
                            i10 = i17 | i20;
                        } else {
                            i17 = i3;
                            i11 = i18;
                        }
                        i10 = i17 | i20;
                    } else {
                        i10 = i3;
                        i11 = i18;
                    }
                    if ((i & 100663296) == 0) {
                        int i2115 = i10;
                        if ((i2 & 256) == 0) {
                            i16 = 33554432;
                        } else {
                            i16 = 33554432;
                        }
                        i10 = i2115 | i16;
                    }
                    i12 = i10;
                    i13 = i2 & 512;
                    if (i13 != 0) {
                        if ((i & 805306368) == 0) {
                            if (composerStartRestartGroup.changed(dialogProperties)) {
                                i14 = C.BUFFER_FLAG_LAST_SAMPLE;
                            } else {
                                i14 = 268435456;
                            }
                            i12 |= i14;
                        }
                        if ((i12 & 306783379) != 306783378) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (composerStartRestartGroup.shouldExecute(z, i12 & 1)) {
                            composerStartRestartGroup.startDefaults();
                            ComposerKt.sourceInformation(composerStartRestartGroup, "77@4252L6,77@4310L6,77@4352L32");
                            if ((i & 1) != 0) {
                                if (i11 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                if (i4 != 0) {
                                    function6 = null;
                                }
                                if (i6 != 0) {
                                    function7 = null;
                                }
                                if (i8 != 0) {
                                    function8 = null;
                                }
                                if ((i2 & 64) != 0) {
                                    i12 &= -3670017;
                                    medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                                }
                                if ((i2 & 128) != 0) {
                                    i12 &= -29360129;
                                    jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                                } else {
                                    jM2346getSurface0d7_KjU = j;
                                }
                                if ((i2 & 256) != 0) {
                                    jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i12 >> 21) & 14);
                                    i12 &= -234881025;
                                } else {
                                    jM2360contentColorForek8zF_U = j2;
                                }
                                if (i13 != 0) {
                                    dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                                } else {
                                    dialogProperties3 = dialogProperties;
                                }
                                j5 = jM2346getSurface0d7_KjU;
                                function12 = function7;
                                i15 = i12;
                                j6 = jM2360contentColorForek8zF_U;
                                modifier4 = modifier2;
                                function13 = function8;
                                shape3 = medium;
                            } else {
                                if (i11 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                if (i4 != 0) {
                                    function6 = null;
                                }
                                if (i6 != 0) {
                                    function7 = null;
                                }
                                if (i8 != 0) {
                                    function8 = null;
                                }
                                if ((i2 & 64) != 0) {
                                    i12 &= -3670017;
                                    medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                                }
                                if ((i2 & 128) != 0) {
                                    i12 &= -29360129;
                                    jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                                } else {
                                    jM2346getSurface0d7_KjU = j;
                                }
                                if ((i2 & 256) != 0) {
                                    jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i12 >> 21) & 14);
                                    i12 &= -234881025;
                                } else {
                                    jM2360contentColorForek8zF_U = j2;
                                }
                                if (i13 != 0) {
                                    dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                                } else {
                                    dialogProperties3 = dialogProperties;
                                }
                                j5 = jM2346getSurface0d7_KjU;
                                function12 = function7;
                                i15 = i12;
                                j6 = jM2360contentColorForek8zF_U;
                                modifier4 = modifier2;
                                function13 = function8;
                                shape3 = medium;
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1967984963, i15, -1, "androidx.compose.material.AlertDialog (AndroidAlertDialog.android.kt:41)");
                            }
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1483448977, "CC(AlertDialogImpl)N(onDismissRequest,confirmButton,modifier,dismissButton,title,text,shape,backgroundColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,properties)149@6875L386,147@6799L678:AlertDialog.kt#jmzs0o");
                            int i2116 = (2147483646 & i15) >> 3;
                            composer2 = composerStartRestartGroup;
                            m2242AlertDialogwqdebIU(function0, ComposableLambdaKt.rememberComposableLambda(-309297447, true, new AlertDialogKt$AlertDialogImpl$1(function6, function2), composerStartRestartGroup, 54), modifier4, function12, function13, shape3, j5, j6, dialogProperties3, composer2, (i15 & 896) | (i15 & 14) | 48 | (i2116 & 7168) | (57344 & i2116) | (458752 & i2116) | (3670016 & i2116) | (29360128 & i2116) | (i2116 & 234881024), 0);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            function9 = function6;
                            modifier3 = modifier4;
                            function10 = function12;
                            function11 = function13;
                            shape2 = shape3;
                            j3 = j5;
                            j4 = j6;
                            dialogProperties2 = dialogProperties3;
                        } else {
                            composer2 = composerStartRestartGroup;
                            composer2.skipToGroupEnd();
                            modifier3 = modifier2;
                            function9 = function6;
                            function10 = function7;
                            function11 = function8;
                            shape2 = medium;
                            j3 = j;
                            j4 = j2;
                            dialogProperties2 = dialogProperties;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.AndroidAlertDialog_androidKt$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return AndroidAlertDialog_androidKt.AlertDialog_6oU6zVQ$lambda$0(function0, function2, modifier3, function9, function10, function11, shape2, j3, j4, dialogProperties2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                        }
                    }
                    i12 |= 805306368;
                    if ((i12 & 306783379) != 306783378) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z, i12 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "77@4252L6,77@4310L6,77@4352L32");
                        if ((i & 1) != 0) {
                            if (i11 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                function6 = null;
                            }
                            if (i6 != 0) {
                                function7 = null;
                            }
                            if (i8 != 0) {
                                function8 = null;
                            }
                            if ((i2 & 64) != 0) {
                                i12 &= -3670017;
                                medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                            }
                            if ((i2 & 128) != 0) {
                                i12 &= -29360129;
                                jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                            } else {
                                jM2346getSurface0d7_KjU = j;
                            }
                            if ((i2 & 256) != 0) {
                                jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i12 >> 21) & 14);
                                i12 &= -234881025;
                            } else {
                                jM2360contentColorForek8zF_U = j2;
                            }
                            if (i13 != 0) {
                                dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                            } else {
                                dialogProperties3 = dialogProperties;
                            }
                            j5 = jM2346getSurface0d7_KjU;
                            function12 = function7;
                            i15 = i12;
                            j6 = jM2360contentColorForek8zF_U;
                            modifier4 = modifier2;
                            function13 = function8;
                            shape3 = medium;
                        } else {
                            if (i11 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                function6 = null;
                            }
                            if (i6 != 0) {
                                function7 = null;
                            }
                            if (i8 != 0) {
                                function8 = null;
                            }
                            if ((i2 & 64) != 0) {
                                i12 &= -3670017;
                                medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                            }
                            if ((i2 & 128) != 0) {
                                i12 &= -29360129;
                                jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                            } else {
                                jM2346getSurface0d7_KjU = j;
                            }
                            if ((i2 & 256) != 0) {
                                jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i12 >> 21) & 14);
                                i12 &= -234881025;
                            } else {
                                jM2360contentColorForek8zF_U = j2;
                            }
                            if (i13 != 0) {
                                dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                            } else {
                                dialogProperties3 = dialogProperties;
                            }
                            j5 = jM2346getSurface0d7_KjU;
                            function12 = function7;
                            i15 = i12;
                            j6 = jM2360contentColorForek8zF_U;
                            modifier4 = modifier2;
                            function13 = function8;
                            shape3 = medium;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1967984963, i15, -1, "androidx.compose.material.AlertDialog (AndroidAlertDialog.android.kt:41)");
                        }
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1483448977, "CC(AlertDialogImpl)N(onDismissRequest,confirmButton,modifier,dismissButton,title,text,shape,backgroundColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,properties)149@6875L386,147@6799L678:AlertDialog.kt#jmzs0o");
                        int i2117 = (2147483646 & i15) >> 3;
                        composer2 = composerStartRestartGroup;
                        m2242AlertDialogwqdebIU(function0, ComposableLambdaKt.rememberComposableLambda(-309297447, true, new AlertDialogKt$AlertDialogImpl$1(function6, function2), composerStartRestartGroup, 54), modifier4, function12, function13, shape3, j5, j6, dialogProperties3, composer2, (i15 & 896) | (i15 & 14) | 48 | (i2117 & 7168) | (57344 & i2117) | (458752 & i2117) | (3670016 & i2117) | (29360128 & i2117) | (i2117 & 234881024), 0);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        function9 = function6;
                        modifier3 = modifier4;
                        function10 = function12;
                        function11 = function13;
                        shape2 = shape3;
                        j3 = j5;
                        j4 = j6;
                        dialogProperties2 = dialogProperties3;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        modifier3 = modifier2;
                        function9 = function6;
                        function10 = function7;
                        function11 = function8;
                        shape2 = medium;
                        j3 = j;
                        j4 = j2;
                        dialogProperties2 = dialogProperties;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.AndroidAlertDialog_androidKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return AndroidAlertDialog_androidKt.AlertDialog_6oU6zVQ$lambda$0(function0, function2, modifier3, function9, function10, function11, shape2, j3, j4, dialogProperties2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                function8 = function5;
                if ((1572864 & i) == 0) {
                    if ((i2 & 64) == 0) {
                        medium = shape;
                        if (composerStartRestartGroup.changed(medium)) {
                        }
                        i3 |= i19;
                    } else {
                        medium = shape;
                    }
                    i3 |= i19;
                } else {
                    medium = shape;
                }
                if ((i & 12582912) == 0) {
                    if ((i2 & 128) == 0) {
                        i17 = i3;
                        i11 = i18;
                        if (composerStartRestartGroup.changed(j)) {
                        }
                        i10 = i17 | i20;
                    } else {
                        i17 = i3;
                        i11 = i18;
                    }
                    i10 = i17 | i20;
                } else {
                    i10 = i3;
                    i11 = i18;
                }
                if ((i & 100663296) == 0) {
                    int i2118 = i10;
                    if ((i2 & 256) == 0) {
                        i16 = 33554432;
                    } else {
                        i16 = 33554432;
                    }
                    i10 = i2118 | i16;
                }
                i12 = i10;
                i13 = i2 & 512;
                if (i13 != 0) {
                    if ((i & 805306368) == 0) {
                        if (composerStartRestartGroup.changed(dialogProperties)) {
                            i14 = C.BUFFER_FLAG_LAST_SAMPLE;
                        } else {
                            i14 = 268435456;
                        }
                        i12 |= i14;
                    }
                    if ((i12 & 306783379) != 306783378) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z, i12 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "77@4252L6,77@4310L6,77@4352L32");
                        if ((i & 1) != 0) {
                            if (i11 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                function6 = null;
                            }
                            if (i6 != 0) {
                                function7 = null;
                            }
                            if (i8 != 0) {
                                function8 = null;
                            }
                            if ((i2 & 64) != 0) {
                                i12 &= -3670017;
                                medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                            }
                            if ((i2 & 128) != 0) {
                                i12 &= -29360129;
                                jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                            } else {
                                jM2346getSurface0d7_KjU = j;
                            }
                            if ((i2 & 256) != 0) {
                                jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i12 >> 21) & 14);
                                i12 &= -234881025;
                            } else {
                                jM2360contentColorForek8zF_U = j2;
                            }
                            if (i13 != 0) {
                                dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                            } else {
                                dialogProperties3 = dialogProperties;
                            }
                            j5 = jM2346getSurface0d7_KjU;
                            function12 = function7;
                            i15 = i12;
                            j6 = jM2360contentColorForek8zF_U;
                            modifier4 = modifier2;
                            function13 = function8;
                            shape3 = medium;
                        } else {
                            if (i11 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                function6 = null;
                            }
                            if (i6 != 0) {
                                function7 = null;
                            }
                            if (i8 != 0) {
                                function8 = null;
                            }
                            if ((i2 & 64) != 0) {
                                i12 &= -3670017;
                                medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                            }
                            if ((i2 & 128) != 0) {
                                i12 &= -29360129;
                                jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                            } else {
                                jM2346getSurface0d7_KjU = j;
                            }
                            if ((i2 & 256) != 0) {
                                jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i12 >> 21) & 14);
                                i12 &= -234881025;
                            } else {
                                jM2360contentColorForek8zF_U = j2;
                            }
                            if (i13 != 0) {
                                dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                            } else {
                                dialogProperties3 = dialogProperties;
                            }
                            j5 = jM2346getSurface0d7_KjU;
                            function12 = function7;
                            i15 = i12;
                            j6 = jM2360contentColorForek8zF_U;
                            modifier4 = modifier2;
                            function13 = function8;
                            shape3 = medium;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1967984963, i15, -1, "androidx.compose.material.AlertDialog (AndroidAlertDialog.android.kt:41)");
                        }
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1483448977, "CC(AlertDialogImpl)N(onDismissRequest,confirmButton,modifier,dismissButton,title,text,shape,backgroundColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,properties)149@6875L386,147@6799L678:AlertDialog.kt#jmzs0o");
                        int i2119 = (2147483646 & i15) >> 3;
                        composer2 = composerStartRestartGroup;
                        m2242AlertDialogwqdebIU(function0, ComposableLambdaKt.rememberComposableLambda(-309297447, true, new AlertDialogKt$AlertDialogImpl$1(function6, function2), composerStartRestartGroup, 54), modifier4, function12, function13, shape3, j5, j6, dialogProperties3, composer2, (i15 & 896) | (i15 & 14) | 48 | (i2119 & 7168) | (57344 & i2119) | (458752 & i2119) | (3670016 & i2119) | (29360128 & i2119) | (i2119 & 234881024), 0);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        function9 = function6;
                        modifier3 = modifier4;
                        function10 = function12;
                        function11 = function13;
                        shape2 = shape3;
                        j3 = j5;
                        j4 = j6;
                        dialogProperties2 = dialogProperties3;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        modifier3 = modifier2;
                        function9 = function6;
                        function10 = function7;
                        function11 = function8;
                        shape2 = medium;
                        j3 = j;
                        j4 = j2;
                        dialogProperties2 = dialogProperties;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.AndroidAlertDialog_androidKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return AndroidAlertDialog_androidKt.AlertDialog_6oU6zVQ$lambda$0(function0, function2, modifier3, function9, function10, function11, shape2, j3, j4, dialogProperties2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i12 |= 805306368;
                if ((i12 & 306783379) != 306783378) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i12 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "77@4252L6,77@4310L6,77@4352L32");
                    if ((i & 1) != 0) {
                        if (i11 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            function6 = null;
                        }
                        if (i6 != 0) {
                            function7 = null;
                        }
                        if (i8 != 0) {
                            function8 = null;
                        }
                        if ((i2 & 64) != 0) {
                            i12 &= -3670017;
                            medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                        }
                        if ((i2 & 128) != 0) {
                            i12 &= -29360129;
                            jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                        } else {
                            jM2346getSurface0d7_KjU = j;
                        }
                        if ((i2 & 256) != 0) {
                            jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i12 >> 21) & 14);
                            i12 &= -234881025;
                        } else {
                            jM2360contentColorForek8zF_U = j2;
                        }
                        if (i13 != 0) {
                            dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                        } else {
                            dialogProperties3 = dialogProperties;
                        }
                        j5 = jM2346getSurface0d7_KjU;
                        function12 = function7;
                        i15 = i12;
                        j6 = jM2360contentColorForek8zF_U;
                        modifier4 = modifier2;
                        function13 = function8;
                        shape3 = medium;
                    } else {
                        if (i11 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            function6 = null;
                        }
                        if (i6 != 0) {
                            function7 = null;
                        }
                        if (i8 != 0) {
                            function8 = null;
                        }
                        if ((i2 & 64) != 0) {
                            i12 &= -3670017;
                            medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                        }
                        if ((i2 & 128) != 0) {
                            i12 &= -29360129;
                            jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                        } else {
                            jM2346getSurface0d7_KjU = j;
                        }
                        if ((i2 & 256) != 0) {
                            jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i12 >> 21) & 14);
                            i12 &= -234881025;
                        } else {
                            jM2360contentColorForek8zF_U = j2;
                        }
                        if (i13 != 0) {
                            dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                        } else {
                            dialogProperties3 = dialogProperties;
                        }
                        j5 = jM2346getSurface0d7_KjU;
                        function12 = function7;
                        i15 = i12;
                        j6 = jM2360contentColorForek8zF_U;
                        modifier4 = modifier2;
                        function13 = function8;
                        shape3 = medium;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1967984963, i15, -1, "androidx.compose.material.AlertDialog (AndroidAlertDialog.android.kt:41)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1483448977, "CC(AlertDialogImpl)N(onDismissRequest,confirmButton,modifier,dismissButton,title,text,shape,backgroundColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,properties)149@6875L386,147@6799L678:AlertDialog.kt#jmzs0o");
                    int i21110 = (2147483646 & i15) >> 3;
                    composer2 = composerStartRestartGroup;
                    m2242AlertDialogwqdebIU(function0, ComposableLambdaKt.rememberComposableLambda(-309297447, true, new AlertDialogKt$AlertDialogImpl$1(function6, function2), composerStartRestartGroup, 54), modifier4, function12, function13, shape3, j5, j6, dialogProperties3, composer2, (i15 & 896) | (i15 & 14) | 48 | (i21110 & 7168) | (57344 & i21110) | (458752 & i21110) | (3670016 & i21110) | (29360128 & i21110) | (i21110 & 234881024), 0);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    function9 = function6;
                    modifier3 = modifier4;
                    function10 = function12;
                    function11 = function13;
                    shape2 = shape3;
                    j3 = j5;
                    j4 = j6;
                    dialogProperties2 = dialogProperties3;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    modifier3 = modifier2;
                    function9 = function6;
                    function10 = function7;
                    function11 = function8;
                    shape2 = medium;
                    j3 = j;
                    j4 = j2;
                    dialogProperties2 = dialogProperties;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.AndroidAlertDialog_androidKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return AndroidAlertDialog_androidKt.AlertDialog_6oU6zVQ$lambda$0(function0, function2, modifier3, function9, function10, function11, shape2, j3, j4, dialogProperties2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 24576;
            function7 = function4;
            i8 = i2 & 32;
            if (i8 != 0) {
                if ((196608 & i) == 0) {
                    function8 = function5;
                    if (composerStartRestartGroup.changedInstance(function8)) {
                        i9 = 131072;
                    } else {
                        i9 = 65536;
                    }
                    i3 |= i9;
                }
                if ((1572864 & i) == 0) {
                    if ((i2 & 64) == 0) {
                        medium = shape;
                        if (composerStartRestartGroup.changed(medium)) {
                        }
                        i3 |= i19;
                    } else {
                        medium = shape;
                    }
                    i3 |= i19;
                } else {
                    medium = shape;
                }
                if ((i & 12582912) == 0) {
                    if ((i2 & 128) == 0) {
                        i17 = i3;
                        i11 = i18;
                        if (composerStartRestartGroup.changed(j)) {
                        }
                        i10 = i17 | i20;
                    } else {
                        i17 = i3;
                        i11 = i18;
                    }
                    i10 = i17 | i20;
                } else {
                    i10 = i3;
                    i11 = i18;
                }
                if ((i & 100663296) == 0) {
                    int i21111 = i10;
                    if ((i2 & 256) == 0) {
                        i16 = 33554432;
                    } else {
                        i16 = 33554432;
                    }
                    i10 = i21111 | i16;
                }
                i12 = i10;
                i13 = i2 & 512;
                if (i13 != 0) {
                    if ((i & 805306368) == 0) {
                        if (composerStartRestartGroup.changed(dialogProperties)) {
                            i14 = C.BUFFER_FLAG_LAST_SAMPLE;
                        } else {
                            i14 = 268435456;
                        }
                        i12 |= i14;
                    }
                    if ((i12 & 306783379) != 306783378) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z, i12 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "77@4252L6,77@4310L6,77@4352L32");
                        if ((i & 1) != 0) {
                            if (i11 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                function6 = null;
                            }
                            if (i6 != 0) {
                                function7 = null;
                            }
                            if (i8 != 0) {
                                function8 = null;
                            }
                            if ((i2 & 64) != 0) {
                                i12 &= -3670017;
                                medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                            }
                            if ((i2 & 128) != 0) {
                                i12 &= -29360129;
                                jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                            } else {
                                jM2346getSurface0d7_KjU = j;
                            }
                            if ((i2 & 256) != 0) {
                                jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i12 >> 21) & 14);
                                i12 &= -234881025;
                            } else {
                                jM2360contentColorForek8zF_U = j2;
                            }
                            if (i13 != 0) {
                                dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                            } else {
                                dialogProperties3 = dialogProperties;
                            }
                            j5 = jM2346getSurface0d7_KjU;
                            function12 = function7;
                            i15 = i12;
                            j6 = jM2360contentColorForek8zF_U;
                            modifier4 = modifier2;
                            function13 = function8;
                            shape3 = medium;
                        } else {
                            if (i11 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                function6 = null;
                            }
                            if (i6 != 0) {
                                function7 = null;
                            }
                            if (i8 != 0) {
                                function8 = null;
                            }
                            if ((i2 & 64) != 0) {
                                i12 &= -3670017;
                                medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                            }
                            if ((i2 & 128) != 0) {
                                i12 &= -29360129;
                                jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                            } else {
                                jM2346getSurface0d7_KjU = j;
                            }
                            if ((i2 & 256) != 0) {
                                jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i12 >> 21) & 14);
                                i12 &= -234881025;
                            } else {
                                jM2360contentColorForek8zF_U = j2;
                            }
                            if (i13 != 0) {
                                dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                            } else {
                                dialogProperties3 = dialogProperties;
                            }
                            j5 = jM2346getSurface0d7_KjU;
                            function12 = function7;
                            i15 = i12;
                            j6 = jM2360contentColorForek8zF_U;
                            modifier4 = modifier2;
                            function13 = function8;
                            shape3 = medium;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1967984963, i15, -1, "androidx.compose.material.AlertDialog (AndroidAlertDialog.android.kt:41)");
                        }
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1483448977, "CC(AlertDialogImpl)N(onDismissRequest,confirmButton,modifier,dismissButton,title,text,shape,backgroundColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,properties)149@6875L386,147@6799L678:AlertDialog.kt#jmzs0o");
                        int i21112 = (2147483646 & i15) >> 3;
                        composer2 = composerStartRestartGroup;
                        m2242AlertDialogwqdebIU(function0, ComposableLambdaKt.rememberComposableLambda(-309297447, true, new AlertDialogKt$AlertDialogImpl$1(function6, function2), composerStartRestartGroup, 54), modifier4, function12, function13, shape3, j5, j6, dialogProperties3, composer2, (i15 & 896) | (i15 & 14) | 48 | (i21112 & 7168) | (57344 & i21112) | (458752 & i21112) | (3670016 & i21112) | (29360128 & i21112) | (i21112 & 234881024), 0);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        function9 = function6;
                        modifier3 = modifier4;
                        function10 = function12;
                        function11 = function13;
                        shape2 = shape3;
                        j3 = j5;
                        j4 = j6;
                        dialogProperties2 = dialogProperties3;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        modifier3 = modifier2;
                        function9 = function6;
                        function10 = function7;
                        function11 = function8;
                        shape2 = medium;
                        j3 = j;
                        j4 = j2;
                        dialogProperties2 = dialogProperties;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.AndroidAlertDialog_androidKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return AndroidAlertDialog_androidKt.AlertDialog_6oU6zVQ$lambda$0(function0, function2, modifier3, function9, function10, function11, shape2, j3, j4, dialogProperties2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i12 |= 805306368;
                if ((i12 & 306783379) != 306783378) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i12 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "77@4252L6,77@4310L6,77@4352L32");
                    if ((i & 1) != 0) {
                        if (i11 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            function6 = null;
                        }
                        if (i6 != 0) {
                            function7 = null;
                        }
                        if (i8 != 0) {
                            function8 = null;
                        }
                        if ((i2 & 64) != 0) {
                            i12 &= -3670017;
                            medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                        }
                        if ((i2 & 128) != 0) {
                            i12 &= -29360129;
                            jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                        } else {
                            jM2346getSurface0d7_KjU = j;
                        }
                        if ((i2 & 256) != 0) {
                            jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i12 >> 21) & 14);
                            i12 &= -234881025;
                        } else {
                            jM2360contentColorForek8zF_U = j2;
                        }
                        if (i13 != 0) {
                            dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                        } else {
                            dialogProperties3 = dialogProperties;
                        }
                        j5 = jM2346getSurface0d7_KjU;
                        function12 = function7;
                        i15 = i12;
                        j6 = jM2360contentColorForek8zF_U;
                        modifier4 = modifier2;
                        function13 = function8;
                        shape3 = medium;
                    } else {
                        if (i11 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            function6 = null;
                        }
                        if (i6 != 0) {
                            function7 = null;
                        }
                        if (i8 != 0) {
                            function8 = null;
                        }
                        if ((i2 & 64) != 0) {
                            i12 &= -3670017;
                            medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                        }
                        if ((i2 & 128) != 0) {
                            i12 &= -29360129;
                            jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                        } else {
                            jM2346getSurface0d7_KjU = j;
                        }
                        if ((i2 & 256) != 0) {
                            jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i12 >> 21) & 14);
                            i12 &= -234881025;
                        } else {
                            jM2360contentColorForek8zF_U = j2;
                        }
                        if (i13 != 0) {
                            dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                        } else {
                            dialogProperties3 = dialogProperties;
                        }
                        j5 = jM2346getSurface0d7_KjU;
                        function12 = function7;
                        i15 = i12;
                        j6 = jM2360contentColorForek8zF_U;
                        modifier4 = modifier2;
                        function13 = function8;
                        shape3 = medium;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1967984963, i15, -1, "androidx.compose.material.AlertDialog (AndroidAlertDialog.android.kt:41)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1483448977, "CC(AlertDialogImpl)N(onDismissRequest,confirmButton,modifier,dismissButton,title,text,shape,backgroundColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,properties)149@6875L386,147@6799L678:AlertDialog.kt#jmzs0o");
                    int i21113 = (2147483646 & i15) >> 3;
                    composer2 = composerStartRestartGroup;
                    m2242AlertDialogwqdebIU(function0, ComposableLambdaKt.rememberComposableLambda(-309297447, true, new AlertDialogKt$AlertDialogImpl$1(function6, function2), composerStartRestartGroup, 54), modifier4, function12, function13, shape3, j5, j6, dialogProperties3, composer2, (i15 & 896) | (i15 & 14) | 48 | (i21113 & 7168) | (57344 & i21113) | (458752 & i21113) | (3670016 & i21113) | (29360128 & i21113) | (i21113 & 234881024), 0);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    function9 = function6;
                    modifier3 = modifier4;
                    function10 = function12;
                    function11 = function13;
                    shape2 = shape3;
                    j3 = j5;
                    j4 = j6;
                    dialogProperties2 = dialogProperties3;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    modifier3 = modifier2;
                    function9 = function6;
                    function10 = function7;
                    function11 = function8;
                    shape2 = medium;
                    j3 = j;
                    j4 = j2;
                    dialogProperties2 = dialogProperties;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.AndroidAlertDialog_androidKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return AndroidAlertDialog_androidKt.AlertDialog_6oU6zVQ$lambda$0(function0, function2, modifier3, function9, function10, function11, shape2, j3, j4, dialogProperties2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            function8 = function5;
            if ((1572864 & i) == 0) {
                if ((i2 & 64) == 0) {
                    medium = shape;
                    if (composerStartRestartGroup.changed(medium)) {
                    }
                    i3 |= i19;
                } else {
                    medium = shape;
                }
                i3 |= i19;
            } else {
                medium = shape;
            }
            if ((i & 12582912) == 0) {
                if ((i2 & 128) == 0) {
                    i17 = i3;
                    i11 = i18;
                    if (composerStartRestartGroup.changed(j)) {
                    }
                    i10 = i17 | i20;
                } else {
                    i17 = i3;
                    i11 = i18;
                }
                i10 = i17 | i20;
            } else {
                i10 = i3;
                i11 = i18;
            }
            if ((i & 100663296) == 0) {
                int i21114 = i10;
                if ((i2 & 256) == 0) {
                    i16 = 33554432;
                } else {
                    i16 = 33554432;
                }
                i10 = i21114 | i16;
            }
            i12 = i10;
            i13 = i2 & 512;
            if (i13 != 0) {
                if ((i & 805306368) == 0) {
                    if (composerStartRestartGroup.changed(dialogProperties)) {
                        i14 = C.BUFFER_FLAG_LAST_SAMPLE;
                    } else {
                        i14 = 268435456;
                    }
                    i12 |= i14;
                }
                if ((i12 & 306783379) != 306783378) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i12 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "77@4252L6,77@4310L6,77@4352L32");
                    if ((i & 1) != 0) {
                        if (i11 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            function6 = null;
                        }
                        if (i6 != 0) {
                            function7 = null;
                        }
                        if (i8 != 0) {
                            function8 = null;
                        }
                        if ((i2 & 64) != 0) {
                            i12 &= -3670017;
                            medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                        }
                        if ((i2 & 128) != 0) {
                            i12 &= -29360129;
                            jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                        } else {
                            jM2346getSurface0d7_KjU = j;
                        }
                        if ((i2 & 256) != 0) {
                            jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i12 >> 21) & 14);
                            i12 &= -234881025;
                        } else {
                            jM2360contentColorForek8zF_U = j2;
                        }
                        if (i13 != 0) {
                            dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                        } else {
                            dialogProperties3 = dialogProperties;
                        }
                        j5 = jM2346getSurface0d7_KjU;
                        function12 = function7;
                        i15 = i12;
                        j6 = jM2360contentColorForek8zF_U;
                        modifier4 = modifier2;
                        function13 = function8;
                        shape3 = medium;
                    } else {
                        if (i11 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            function6 = null;
                        }
                        if (i6 != 0) {
                            function7 = null;
                        }
                        if (i8 != 0) {
                            function8 = null;
                        }
                        if ((i2 & 64) != 0) {
                            i12 &= -3670017;
                            medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                        }
                        if ((i2 & 128) != 0) {
                            i12 &= -29360129;
                            jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                        } else {
                            jM2346getSurface0d7_KjU = j;
                        }
                        if ((i2 & 256) != 0) {
                            jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i12 >> 21) & 14);
                            i12 &= -234881025;
                        } else {
                            jM2360contentColorForek8zF_U = j2;
                        }
                        if (i13 != 0) {
                            dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                        } else {
                            dialogProperties3 = dialogProperties;
                        }
                        j5 = jM2346getSurface0d7_KjU;
                        function12 = function7;
                        i15 = i12;
                        j6 = jM2360contentColorForek8zF_U;
                        modifier4 = modifier2;
                        function13 = function8;
                        shape3 = medium;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1967984963, i15, -1, "androidx.compose.material.AlertDialog (AndroidAlertDialog.android.kt:41)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1483448977, "CC(AlertDialogImpl)N(onDismissRequest,confirmButton,modifier,dismissButton,title,text,shape,backgroundColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,properties)149@6875L386,147@6799L678:AlertDialog.kt#jmzs0o");
                    int i21115 = (2147483646 & i15) >> 3;
                    composer2 = composerStartRestartGroup;
                    m2242AlertDialogwqdebIU(function0, ComposableLambdaKt.rememberComposableLambda(-309297447, true, new AlertDialogKt$AlertDialogImpl$1(function6, function2), composerStartRestartGroup, 54), modifier4, function12, function13, shape3, j5, j6, dialogProperties3, composer2, (i15 & 896) | (i15 & 14) | 48 | (i21115 & 7168) | (57344 & i21115) | (458752 & i21115) | (3670016 & i21115) | (29360128 & i21115) | (i21115 & 234881024), 0);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    function9 = function6;
                    modifier3 = modifier4;
                    function10 = function12;
                    function11 = function13;
                    shape2 = shape3;
                    j3 = j5;
                    j4 = j6;
                    dialogProperties2 = dialogProperties3;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    modifier3 = modifier2;
                    function9 = function6;
                    function10 = function7;
                    function11 = function8;
                    shape2 = medium;
                    j3 = j;
                    j4 = j2;
                    dialogProperties2 = dialogProperties;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.AndroidAlertDialog_androidKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return AndroidAlertDialog_androidKt.AlertDialog_6oU6zVQ$lambda$0(function0, function2, modifier3, function9, function10, function11, shape2, j3, j4, dialogProperties2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i12 |= 805306368;
            if ((i12 & 306783379) != 306783378) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i12 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "77@4252L6,77@4310L6,77@4352L32");
                if ((i & 1) != 0) {
                    if (i11 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        function6 = null;
                    }
                    if (i6 != 0) {
                        function7 = null;
                    }
                    if (i8 != 0) {
                        function8 = null;
                    }
                    if ((i2 & 64) != 0) {
                        i12 &= -3670017;
                        medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                    }
                    if ((i2 & 128) != 0) {
                        i12 &= -29360129;
                        jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                    } else {
                        jM2346getSurface0d7_KjU = j;
                    }
                    if ((i2 & 256) != 0) {
                        jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i12 >> 21) & 14);
                        i12 &= -234881025;
                    } else {
                        jM2360contentColorForek8zF_U = j2;
                    }
                    if (i13 != 0) {
                        dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                    } else {
                        dialogProperties3 = dialogProperties;
                    }
                    j5 = jM2346getSurface0d7_KjU;
                    function12 = function7;
                    i15 = i12;
                    j6 = jM2360contentColorForek8zF_U;
                    modifier4 = modifier2;
                    function13 = function8;
                    shape3 = medium;
                } else {
                    if (i11 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        function6 = null;
                    }
                    if (i6 != 0) {
                        function7 = null;
                    }
                    if (i8 != 0) {
                        function8 = null;
                    }
                    if ((i2 & 64) != 0) {
                        i12 &= -3670017;
                        medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                    }
                    if ((i2 & 128) != 0) {
                        i12 &= -29360129;
                        jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                    } else {
                        jM2346getSurface0d7_KjU = j;
                    }
                    if ((i2 & 256) != 0) {
                        jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i12 >> 21) & 14);
                        i12 &= -234881025;
                    } else {
                        jM2360contentColorForek8zF_U = j2;
                    }
                    if (i13 != 0) {
                        dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                    } else {
                        dialogProperties3 = dialogProperties;
                    }
                    j5 = jM2346getSurface0d7_KjU;
                    function12 = function7;
                    i15 = i12;
                    j6 = jM2360contentColorForek8zF_U;
                    modifier4 = modifier2;
                    function13 = function8;
                    shape3 = medium;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1967984963, i15, -1, "androidx.compose.material.AlertDialog (AndroidAlertDialog.android.kt:41)");
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1483448977, "CC(AlertDialogImpl)N(onDismissRequest,confirmButton,modifier,dismissButton,title,text,shape,backgroundColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,properties)149@6875L386,147@6799L678:AlertDialog.kt#jmzs0o");
                int i21116 = (2147483646 & i15) >> 3;
                composer2 = composerStartRestartGroup;
                m2242AlertDialogwqdebIU(function0, ComposableLambdaKt.rememberComposableLambda(-309297447, true, new AlertDialogKt$AlertDialogImpl$1(function6, function2), composerStartRestartGroup, 54), modifier4, function12, function13, shape3, j5, j6, dialogProperties3, composer2, (i15 & 896) | (i15 & 14) | 48 | (i21116 & 7168) | (57344 & i21116) | (458752 & i21116) | (3670016 & i21116) | (29360128 & i21116) | (i21116 & 234881024), 0);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                function9 = function6;
                modifier3 = modifier4;
                function10 = function12;
                function11 = function13;
                shape2 = shape3;
                j3 = j5;
                j4 = j6;
                dialogProperties2 = dialogProperties3;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier3 = modifier2;
                function9 = function6;
                function10 = function7;
                function11 = function8;
                shape2 = medium;
                j3 = j;
                j4 = j2;
                dialogProperties2 = dialogProperties;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.AndroidAlertDialog_androidKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return AndroidAlertDialog_androidKt.AlertDialog_6oU6zVQ$lambda$0(function0, function2, modifier3, function9, function10, function11, shape2, j3, j4, dialogProperties2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 3072;
        function6 = function3;
        i6 = i2 & 16;
        if (i6 != 0) {
            if ((i & 24576) == 0) {
                function7 = function4;
                if (composerStartRestartGroup.changedInstance(function7)) {
                    i7 = 16384;
                } else {
                    i7 = 8192;
                }
                i3 |= i7;
            }
            i8 = i2 & 32;
            if (i8 != 0) {
                if ((196608 & i) == 0) {
                    function8 = function5;
                    if (composerStartRestartGroup.changedInstance(function8)) {
                        i9 = 131072;
                    } else {
                        i9 = 65536;
                    }
                    i3 |= i9;
                }
                if ((1572864 & i) == 0) {
                    if ((i2 & 64) == 0) {
                        medium = shape;
                        if (composerStartRestartGroup.changed(medium)) {
                        }
                        i3 |= i19;
                    } else {
                        medium = shape;
                    }
                    i3 |= i19;
                } else {
                    medium = shape;
                }
                if ((i & 12582912) == 0) {
                    if ((i2 & 128) == 0) {
                        i17 = i3;
                        i11 = i18;
                        if (composerStartRestartGroup.changed(j)) {
                        }
                        i10 = i17 | i20;
                    } else {
                        i17 = i3;
                        i11 = i18;
                    }
                    i10 = i17 | i20;
                } else {
                    i10 = i3;
                    i11 = i18;
                }
                if ((i & 100663296) == 0) {
                    int i21117 = i10;
                    if ((i2 & 256) == 0) {
                        i16 = 33554432;
                    } else {
                        i16 = 33554432;
                    }
                    i10 = i21117 | i16;
                }
                i12 = i10;
                i13 = i2 & 512;
                if (i13 != 0) {
                    if ((i & 805306368) == 0) {
                        if (composerStartRestartGroup.changed(dialogProperties)) {
                            i14 = C.BUFFER_FLAG_LAST_SAMPLE;
                        } else {
                            i14 = 268435456;
                        }
                        i12 |= i14;
                    }
                    if ((i12 & 306783379) != 306783378) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z, i12 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "77@4252L6,77@4310L6,77@4352L32");
                        if ((i & 1) != 0) {
                            if (i11 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                function6 = null;
                            }
                            if (i6 != 0) {
                                function7 = null;
                            }
                            if (i8 != 0) {
                                function8 = null;
                            }
                            if ((i2 & 64) != 0) {
                                i12 &= -3670017;
                                medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                            }
                            if ((i2 & 128) != 0) {
                                i12 &= -29360129;
                                jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                            } else {
                                jM2346getSurface0d7_KjU = j;
                            }
                            if ((i2 & 256) != 0) {
                                jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i12 >> 21) & 14);
                                i12 &= -234881025;
                            } else {
                                jM2360contentColorForek8zF_U = j2;
                            }
                            if (i13 != 0) {
                                dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                            } else {
                                dialogProperties3 = dialogProperties;
                            }
                            j5 = jM2346getSurface0d7_KjU;
                            function12 = function7;
                            i15 = i12;
                            j6 = jM2360contentColorForek8zF_U;
                            modifier4 = modifier2;
                            function13 = function8;
                            shape3 = medium;
                        } else {
                            if (i11 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                function6 = null;
                            }
                            if (i6 != 0) {
                                function7 = null;
                            }
                            if (i8 != 0) {
                                function8 = null;
                            }
                            if ((i2 & 64) != 0) {
                                i12 &= -3670017;
                                medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                            }
                            if ((i2 & 128) != 0) {
                                i12 &= -29360129;
                                jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                            } else {
                                jM2346getSurface0d7_KjU = j;
                            }
                            if ((i2 & 256) != 0) {
                                jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i12 >> 21) & 14);
                                i12 &= -234881025;
                            } else {
                                jM2360contentColorForek8zF_U = j2;
                            }
                            if (i13 != 0) {
                                dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                            } else {
                                dialogProperties3 = dialogProperties;
                            }
                            j5 = jM2346getSurface0d7_KjU;
                            function12 = function7;
                            i15 = i12;
                            j6 = jM2360contentColorForek8zF_U;
                            modifier4 = modifier2;
                            function13 = function8;
                            shape3 = medium;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1967984963, i15, -1, "androidx.compose.material.AlertDialog (AndroidAlertDialog.android.kt:41)");
                        }
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1483448977, "CC(AlertDialogImpl)N(onDismissRequest,confirmButton,modifier,dismissButton,title,text,shape,backgroundColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,properties)149@6875L386,147@6799L678:AlertDialog.kt#jmzs0o");
                        int i21118 = (2147483646 & i15) >> 3;
                        composer2 = composerStartRestartGroup;
                        m2242AlertDialogwqdebIU(function0, ComposableLambdaKt.rememberComposableLambda(-309297447, true, new AlertDialogKt$AlertDialogImpl$1(function6, function2), composerStartRestartGroup, 54), modifier4, function12, function13, shape3, j5, j6, dialogProperties3, composer2, (i15 & 896) | (i15 & 14) | 48 | (i21118 & 7168) | (57344 & i21118) | (458752 & i21118) | (3670016 & i21118) | (29360128 & i21118) | (i21118 & 234881024), 0);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        function9 = function6;
                        modifier3 = modifier4;
                        function10 = function12;
                        function11 = function13;
                        shape2 = shape3;
                        j3 = j5;
                        j4 = j6;
                        dialogProperties2 = dialogProperties3;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        modifier3 = modifier2;
                        function9 = function6;
                        function10 = function7;
                        function11 = function8;
                        shape2 = medium;
                        j3 = j;
                        j4 = j2;
                        dialogProperties2 = dialogProperties;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.AndroidAlertDialog_androidKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return AndroidAlertDialog_androidKt.AlertDialog_6oU6zVQ$lambda$0(function0, function2, modifier3, function9, function10, function11, shape2, j3, j4, dialogProperties2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i12 |= 805306368;
                if ((i12 & 306783379) != 306783378) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i12 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "77@4252L6,77@4310L6,77@4352L32");
                    if ((i & 1) != 0) {
                        if (i11 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            function6 = null;
                        }
                        if (i6 != 0) {
                            function7 = null;
                        }
                        if (i8 != 0) {
                            function8 = null;
                        }
                        if ((i2 & 64) != 0) {
                            i12 &= -3670017;
                            medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                        }
                        if ((i2 & 128) != 0) {
                            i12 &= -29360129;
                            jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                        } else {
                            jM2346getSurface0d7_KjU = j;
                        }
                        if ((i2 & 256) != 0) {
                            jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i12 >> 21) & 14);
                            i12 &= -234881025;
                        } else {
                            jM2360contentColorForek8zF_U = j2;
                        }
                        if (i13 != 0) {
                            dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                        } else {
                            dialogProperties3 = dialogProperties;
                        }
                        j5 = jM2346getSurface0d7_KjU;
                        function12 = function7;
                        i15 = i12;
                        j6 = jM2360contentColorForek8zF_U;
                        modifier4 = modifier2;
                        function13 = function8;
                        shape3 = medium;
                    } else {
                        if (i11 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            function6 = null;
                        }
                        if (i6 != 0) {
                            function7 = null;
                        }
                        if (i8 != 0) {
                            function8 = null;
                        }
                        if ((i2 & 64) != 0) {
                            i12 &= -3670017;
                            medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                        }
                        if ((i2 & 128) != 0) {
                            i12 &= -29360129;
                            jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                        } else {
                            jM2346getSurface0d7_KjU = j;
                        }
                        if ((i2 & 256) != 0) {
                            jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i12 >> 21) & 14);
                            i12 &= -234881025;
                        } else {
                            jM2360contentColorForek8zF_U = j2;
                        }
                        if (i13 != 0) {
                            dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                        } else {
                            dialogProperties3 = dialogProperties;
                        }
                        j5 = jM2346getSurface0d7_KjU;
                        function12 = function7;
                        i15 = i12;
                        j6 = jM2360contentColorForek8zF_U;
                        modifier4 = modifier2;
                        function13 = function8;
                        shape3 = medium;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1967984963, i15, -1, "androidx.compose.material.AlertDialog (AndroidAlertDialog.android.kt:41)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1483448977, "CC(AlertDialogImpl)N(onDismissRequest,confirmButton,modifier,dismissButton,title,text,shape,backgroundColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,properties)149@6875L386,147@6799L678:AlertDialog.kt#jmzs0o");
                    int i21119 = (2147483646 & i15) >> 3;
                    composer2 = composerStartRestartGroup;
                    m2242AlertDialogwqdebIU(function0, ComposableLambdaKt.rememberComposableLambda(-309297447, true, new AlertDialogKt$AlertDialogImpl$1(function6, function2), composerStartRestartGroup, 54), modifier4, function12, function13, shape3, j5, j6, dialogProperties3, composer2, (i15 & 896) | (i15 & 14) | 48 | (i21119 & 7168) | (57344 & i21119) | (458752 & i21119) | (3670016 & i21119) | (29360128 & i21119) | (i21119 & 234881024), 0);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    function9 = function6;
                    modifier3 = modifier4;
                    function10 = function12;
                    function11 = function13;
                    shape2 = shape3;
                    j3 = j5;
                    j4 = j6;
                    dialogProperties2 = dialogProperties3;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    modifier3 = modifier2;
                    function9 = function6;
                    function10 = function7;
                    function11 = function8;
                    shape2 = medium;
                    j3 = j;
                    j4 = j2;
                    dialogProperties2 = dialogProperties;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.AndroidAlertDialog_androidKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return AndroidAlertDialog_androidKt.AlertDialog_6oU6zVQ$lambda$0(function0, function2, modifier3, function9, function10, function11, shape2, j3, j4, dialogProperties2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            function8 = function5;
            if ((1572864 & i) == 0) {
                if ((i2 & 64) == 0) {
                    medium = shape;
                    if (composerStartRestartGroup.changed(medium)) {
                    }
                    i3 |= i19;
                } else {
                    medium = shape;
                }
                i3 |= i19;
            } else {
                medium = shape;
            }
            if ((i & 12582912) == 0) {
                if ((i2 & 128) == 0) {
                    i17 = i3;
                    i11 = i18;
                    if (composerStartRestartGroup.changed(j)) {
                    }
                    i10 = i17 | i20;
                } else {
                    i17 = i3;
                    i11 = i18;
                }
                i10 = i17 | i20;
            } else {
                i10 = i3;
                i11 = i18;
            }
            if ((i & 100663296) == 0) {
                int i211110 = i10;
                if ((i2 & 256) == 0) {
                    i16 = 33554432;
                } else {
                    i16 = 33554432;
                }
                i10 = i211110 | i16;
            }
            i12 = i10;
            i13 = i2 & 512;
            if (i13 != 0) {
                if ((i & 805306368) == 0) {
                    if (composerStartRestartGroup.changed(dialogProperties)) {
                        i14 = C.BUFFER_FLAG_LAST_SAMPLE;
                    } else {
                        i14 = 268435456;
                    }
                    i12 |= i14;
                }
                if ((i12 & 306783379) != 306783378) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i12 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "77@4252L6,77@4310L6,77@4352L32");
                    if ((i & 1) != 0) {
                        if (i11 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            function6 = null;
                        }
                        if (i6 != 0) {
                            function7 = null;
                        }
                        if (i8 != 0) {
                            function8 = null;
                        }
                        if ((i2 & 64) != 0) {
                            i12 &= -3670017;
                            medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                        }
                        if ((i2 & 128) != 0) {
                            i12 &= -29360129;
                            jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                        } else {
                            jM2346getSurface0d7_KjU = j;
                        }
                        if ((i2 & 256) != 0) {
                            jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i12 >> 21) & 14);
                            i12 &= -234881025;
                        } else {
                            jM2360contentColorForek8zF_U = j2;
                        }
                        if (i13 != 0) {
                            dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                        } else {
                            dialogProperties3 = dialogProperties;
                        }
                        j5 = jM2346getSurface0d7_KjU;
                        function12 = function7;
                        i15 = i12;
                        j6 = jM2360contentColorForek8zF_U;
                        modifier4 = modifier2;
                        function13 = function8;
                        shape3 = medium;
                    } else {
                        if (i11 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            function6 = null;
                        }
                        if (i6 != 0) {
                            function7 = null;
                        }
                        if (i8 != 0) {
                            function8 = null;
                        }
                        if ((i2 & 64) != 0) {
                            i12 &= -3670017;
                            medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                        }
                        if ((i2 & 128) != 0) {
                            i12 &= -29360129;
                            jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                        } else {
                            jM2346getSurface0d7_KjU = j;
                        }
                        if ((i2 & 256) != 0) {
                            jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i12 >> 21) & 14);
                            i12 &= -234881025;
                        } else {
                            jM2360contentColorForek8zF_U = j2;
                        }
                        if (i13 != 0) {
                            dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                        } else {
                            dialogProperties3 = dialogProperties;
                        }
                        j5 = jM2346getSurface0d7_KjU;
                        function12 = function7;
                        i15 = i12;
                        j6 = jM2360contentColorForek8zF_U;
                        modifier4 = modifier2;
                        function13 = function8;
                        shape3 = medium;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1967984963, i15, -1, "androidx.compose.material.AlertDialog (AndroidAlertDialog.android.kt:41)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1483448977, "CC(AlertDialogImpl)N(onDismissRequest,confirmButton,modifier,dismissButton,title,text,shape,backgroundColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,properties)149@6875L386,147@6799L678:AlertDialog.kt#jmzs0o");
                    int i211111 = (2147483646 & i15) >> 3;
                    composer2 = composerStartRestartGroup;
                    m2242AlertDialogwqdebIU(function0, ComposableLambdaKt.rememberComposableLambda(-309297447, true, new AlertDialogKt$AlertDialogImpl$1(function6, function2), composerStartRestartGroup, 54), modifier4, function12, function13, shape3, j5, j6, dialogProperties3, composer2, (i15 & 896) | (i15 & 14) | 48 | (i211111 & 7168) | (57344 & i211111) | (458752 & i211111) | (3670016 & i211111) | (29360128 & i211111) | (i211111 & 234881024), 0);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    function9 = function6;
                    modifier3 = modifier4;
                    function10 = function12;
                    function11 = function13;
                    shape2 = shape3;
                    j3 = j5;
                    j4 = j6;
                    dialogProperties2 = dialogProperties3;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    modifier3 = modifier2;
                    function9 = function6;
                    function10 = function7;
                    function11 = function8;
                    shape2 = medium;
                    j3 = j;
                    j4 = j2;
                    dialogProperties2 = dialogProperties;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.AndroidAlertDialog_androidKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return AndroidAlertDialog_androidKt.AlertDialog_6oU6zVQ$lambda$0(function0, function2, modifier3, function9, function10, function11, shape2, j3, j4, dialogProperties2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i12 |= 805306368;
            if ((i12 & 306783379) != 306783378) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i12 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "77@4252L6,77@4310L6,77@4352L32");
                if ((i & 1) != 0) {
                    if (i11 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        function6 = null;
                    }
                    if (i6 != 0) {
                        function7 = null;
                    }
                    if (i8 != 0) {
                        function8 = null;
                    }
                    if ((i2 & 64) != 0) {
                        i12 &= -3670017;
                        medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                    }
                    if ((i2 & 128) != 0) {
                        i12 &= -29360129;
                        jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                    } else {
                        jM2346getSurface0d7_KjU = j;
                    }
                    if ((i2 & 256) != 0) {
                        jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i12 >> 21) & 14);
                        i12 &= -234881025;
                    } else {
                        jM2360contentColorForek8zF_U = j2;
                    }
                    if (i13 != 0) {
                        dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                    } else {
                        dialogProperties3 = dialogProperties;
                    }
                    j5 = jM2346getSurface0d7_KjU;
                    function12 = function7;
                    i15 = i12;
                    j6 = jM2360contentColorForek8zF_U;
                    modifier4 = modifier2;
                    function13 = function8;
                    shape3 = medium;
                } else {
                    if (i11 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        function6 = null;
                    }
                    if (i6 != 0) {
                        function7 = null;
                    }
                    if (i8 != 0) {
                        function8 = null;
                    }
                    if ((i2 & 64) != 0) {
                        i12 &= -3670017;
                        medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                    }
                    if ((i2 & 128) != 0) {
                        i12 &= -29360129;
                        jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                    } else {
                        jM2346getSurface0d7_KjU = j;
                    }
                    if ((i2 & 256) != 0) {
                        jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i12 >> 21) & 14);
                        i12 &= -234881025;
                    } else {
                        jM2360contentColorForek8zF_U = j2;
                    }
                    if (i13 != 0) {
                        dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                    } else {
                        dialogProperties3 = dialogProperties;
                    }
                    j5 = jM2346getSurface0d7_KjU;
                    function12 = function7;
                    i15 = i12;
                    j6 = jM2360contentColorForek8zF_U;
                    modifier4 = modifier2;
                    function13 = function8;
                    shape3 = medium;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1967984963, i15, -1, "androidx.compose.material.AlertDialog (AndroidAlertDialog.android.kt:41)");
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1483448977, "CC(AlertDialogImpl)N(onDismissRequest,confirmButton,modifier,dismissButton,title,text,shape,backgroundColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,properties)149@6875L386,147@6799L678:AlertDialog.kt#jmzs0o");
                int i211112 = (2147483646 & i15) >> 3;
                composer2 = composerStartRestartGroup;
                m2242AlertDialogwqdebIU(function0, ComposableLambdaKt.rememberComposableLambda(-309297447, true, new AlertDialogKt$AlertDialogImpl$1(function6, function2), composerStartRestartGroup, 54), modifier4, function12, function13, shape3, j5, j6, dialogProperties3, composer2, (i15 & 896) | (i15 & 14) | 48 | (i211112 & 7168) | (57344 & i211112) | (458752 & i211112) | (3670016 & i211112) | (29360128 & i211112) | (i211112 & 234881024), 0);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                function9 = function6;
                modifier3 = modifier4;
                function10 = function12;
                function11 = function13;
                shape2 = shape3;
                j3 = j5;
                j4 = j6;
                dialogProperties2 = dialogProperties3;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier3 = modifier2;
                function9 = function6;
                function10 = function7;
                function11 = function8;
                shape2 = medium;
                j3 = j;
                j4 = j2;
                dialogProperties2 = dialogProperties;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.AndroidAlertDialog_androidKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return AndroidAlertDialog_androidKt.AlertDialog_6oU6zVQ$lambda$0(function0, function2, modifier3, function9, function10, function11, shape2, j3, j4, dialogProperties2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 24576;
        function7 = function4;
        i8 = i2 & 32;
        if (i8 != 0) {
            if ((196608 & i) == 0) {
                function8 = function5;
                if (composerStartRestartGroup.changedInstance(function8)) {
                    i9 = 131072;
                } else {
                    i9 = 65536;
                }
                i3 |= i9;
            }
            if ((1572864 & i) == 0) {
                if ((i2 & 64) == 0) {
                    medium = shape;
                    if (composerStartRestartGroup.changed(medium)) {
                    }
                    i3 |= i19;
                } else {
                    medium = shape;
                }
                i3 |= i19;
            } else {
                medium = shape;
            }
            if ((i & 12582912) == 0) {
                if ((i2 & 128) == 0) {
                    i17 = i3;
                    i11 = i18;
                    if (composerStartRestartGroup.changed(j)) {
                    }
                    i10 = i17 | i20;
                } else {
                    i17 = i3;
                    i11 = i18;
                }
                i10 = i17 | i20;
            } else {
                i10 = i3;
                i11 = i18;
            }
            if ((i & 100663296) == 0) {
                int i211113 = i10;
                if ((i2 & 256) == 0) {
                    i16 = 33554432;
                } else {
                    i16 = 33554432;
                }
                i10 = i211113 | i16;
            }
            i12 = i10;
            i13 = i2 & 512;
            if (i13 != 0) {
                if ((i & 805306368) == 0) {
                    if (composerStartRestartGroup.changed(dialogProperties)) {
                        i14 = C.BUFFER_FLAG_LAST_SAMPLE;
                    } else {
                        i14 = 268435456;
                    }
                    i12 |= i14;
                }
                if ((i12 & 306783379) != 306783378) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i12 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "77@4252L6,77@4310L6,77@4352L32");
                    if ((i & 1) != 0) {
                        if (i11 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            function6 = null;
                        }
                        if (i6 != 0) {
                            function7 = null;
                        }
                        if (i8 != 0) {
                            function8 = null;
                        }
                        if ((i2 & 64) != 0) {
                            i12 &= -3670017;
                            medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                        }
                        if ((i2 & 128) != 0) {
                            i12 &= -29360129;
                            jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                        } else {
                            jM2346getSurface0d7_KjU = j;
                        }
                        if ((i2 & 256) != 0) {
                            jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i12 >> 21) & 14);
                            i12 &= -234881025;
                        } else {
                            jM2360contentColorForek8zF_U = j2;
                        }
                        if (i13 != 0) {
                            dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                        } else {
                            dialogProperties3 = dialogProperties;
                        }
                        j5 = jM2346getSurface0d7_KjU;
                        function12 = function7;
                        i15 = i12;
                        j6 = jM2360contentColorForek8zF_U;
                        modifier4 = modifier2;
                        function13 = function8;
                        shape3 = medium;
                    } else {
                        if (i11 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            function6 = null;
                        }
                        if (i6 != 0) {
                            function7 = null;
                        }
                        if (i8 != 0) {
                            function8 = null;
                        }
                        if ((i2 & 64) != 0) {
                            i12 &= -3670017;
                            medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                        }
                        if ((i2 & 128) != 0) {
                            i12 &= -29360129;
                            jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                        } else {
                            jM2346getSurface0d7_KjU = j;
                        }
                        if ((i2 & 256) != 0) {
                            jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i12 >> 21) & 14);
                            i12 &= -234881025;
                        } else {
                            jM2360contentColorForek8zF_U = j2;
                        }
                        if (i13 != 0) {
                            dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                        } else {
                            dialogProperties3 = dialogProperties;
                        }
                        j5 = jM2346getSurface0d7_KjU;
                        function12 = function7;
                        i15 = i12;
                        j6 = jM2360contentColorForek8zF_U;
                        modifier4 = modifier2;
                        function13 = function8;
                        shape3 = medium;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1967984963, i15, -1, "androidx.compose.material.AlertDialog (AndroidAlertDialog.android.kt:41)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1483448977, "CC(AlertDialogImpl)N(onDismissRequest,confirmButton,modifier,dismissButton,title,text,shape,backgroundColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,properties)149@6875L386,147@6799L678:AlertDialog.kt#jmzs0o");
                    int i211114 = (2147483646 & i15) >> 3;
                    composer2 = composerStartRestartGroup;
                    m2242AlertDialogwqdebIU(function0, ComposableLambdaKt.rememberComposableLambda(-309297447, true, new AlertDialogKt$AlertDialogImpl$1(function6, function2), composerStartRestartGroup, 54), modifier4, function12, function13, shape3, j5, j6, dialogProperties3, composer2, (i15 & 896) | (i15 & 14) | 48 | (i211114 & 7168) | (57344 & i211114) | (458752 & i211114) | (3670016 & i211114) | (29360128 & i211114) | (i211114 & 234881024), 0);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    function9 = function6;
                    modifier3 = modifier4;
                    function10 = function12;
                    function11 = function13;
                    shape2 = shape3;
                    j3 = j5;
                    j4 = j6;
                    dialogProperties2 = dialogProperties3;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    modifier3 = modifier2;
                    function9 = function6;
                    function10 = function7;
                    function11 = function8;
                    shape2 = medium;
                    j3 = j;
                    j4 = j2;
                    dialogProperties2 = dialogProperties;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.AndroidAlertDialog_androidKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return AndroidAlertDialog_androidKt.AlertDialog_6oU6zVQ$lambda$0(function0, function2, modifier3, function9, function10, function11, shape2, j3, j4, dialogProperties2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i12 |= 805306368;
            if ((i12 & 306783379) != 306783378) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i12 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "77@4252L6,77@4310L6,77@4352L32");
                if ((i & 1) != 0) {
                    if (i11 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        function6 = null;
                    }
                    if (i6 != 0) {
                        function7 = null;
                    }
                    if (i8 != 0) {
                        function8 = null;
                    }
                    if ((i2 & 64) != 0) {
                        i12 &= -3670017;
                        medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                    }
                    if ((i2 & 128) != 0) {
                        i12 &= -29360129;
                        jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                    } else {
                        jM2346getSurface0d7_KjU = j;
                    }
                    if ((i2 & 256) != 0) {
                        jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i12 >> 21) & 14);
                        i12 &= -234881025;
                    } else {
                        jM2360contentColorForek8zF_U = j2;
                    }
                    if (i13 != 0) {
                        dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                    } else {
                        dialogProperties3 = dialogProperties;
                    }
                    j5 = jM2346getSurface0d7_KjU;
                    function12 = function7;
                    i15 = i12;
                    j6 = jM2360contentColorForek8zF_U;
                    modifier4 = modifier2;
                    function13 = function8;
                    shape3 = medium;
                } else {
                    if (i11 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        function6 = null;
                    }
                    if (i6 != 0) {
                        function7 = null;
                    }
                    if (i8 != 0) {
                        function8 = null;
                    }
                    if ((i2 & 64) != 0) {
                        i12 &= -3670017;
                        medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                    }
                    if ((i2 & 128) != 0) {
                        i12 &= -29360129;
                        jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                    } else {
                        jM2346getSurface0d7_KjU = j;
                    }
                    if ((i2 & 256) != 0) {
                        jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i12 >> 21) & 14);
                        i12 &= -234881025;
                    } else {
                        jM2360contentColorForek8zF_U = j2;
                    }
                    if (i13 != 0) {
                        dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                    } else {
                        dialogProperties3 = dialogProperties;
                    }
                    j5 = jM2346getSurface0d7_KjU;
                    function12 = function7;
                    i15 = i12;
                    j6 = jM2360contentColorForek8zF_U;
                    modifier4 = modifier2;
                    function13 = function8;
                    shape3 = medium;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1967984963, i15, -1, "androidx.compose.material.AlertDialog (AndroidAlertDialog.android.kt:41)");
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1483448977, "CC(AlertDialogImpl)N(onDismissRequest,confirmButton,modifier,dismissButton,title,text,shape,backgroundColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,properties)149@6875L386,147@6799L678:AlertDialog.kt#jmzs0o");
                int i211115 = (2147483646 & i15) >> 3;
                composer2 = composerStartRestartGroup;
                m2242AlertDialogwqdebIU(function0, ComposableLambdaKt.rememberComposableLambda(-309297447, true, new AlertDialogKt$AlertDialogImpl$1(function6, function2), composerStartRestartGroup, 54), modifier4, function12, function13, shape3, j5, j6, dialogProperties3, composer2, (i15 & 896) | (i15 & 14) | 48 | (i211115 & 7168) | (57344 & i211115) | (458752 & i211115) | (3670016 & i211115) | (29360128 & i211115) | (i211115 & 234881024), 0);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                function9 = function6;
                modifier3 = modifier4;
                function10 = function12;
                function11 = function13;
                shape2 = shape3;
                j3 = j5;
                j4 = j6;
                dialogProperties2 = dialogProperties3;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier3 = modifier2;
                function9 = function6;
                function10 = function7;
                function11 = function8;
                shape2 = medium;
                j3 = j;
                j4 = j2;
                dialogProperties2 = dialogProperties;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.AndroidAlertDialog_androidKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return AndroidAlertDialog_androidKt.AlertDialog_6oU6zVQ$lambda$0(function0, function2, modifier3, function9, function10, function11, shape2, j3, j4, dialogProperties2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        function8 = function5;
        if ((1572864 & i) == 0) {
            if ((i2 & 64) == 0) {
                medium = shape;
                if (composerStartRestartGroup.changed(medium)) {
                }
                i3 |= i19;
            } else {
                medium = shape;
            }
            i3 |= i19;
        } else {
            medium = shape;
        }
        if ((i & 12582912) == 0) {
            if ((i2 & 128) == 0) {
                i17 = i3;
                i11 = i18;
                if (composerStartRestartGroup.changed(j)) {
                }
                i10 = i17 | i20;
            } else {
                i17 = i3;
                i11 = i18;
            }
            i10 = i17 | i20;
        } else {
            i10 = i3;
            i11 = i18;
        }
        if ((i & 100663296) == 0) {
            int i211116 = i10;
            if ((i2 & 256) == 0) {
                i16 = 33554432;
            } else {
                i16 = 33554432;
            }
            i10 = i211116 | i16;
        }
        i12 = i10;
        i13 = i2 & 512;
        if (i13 != 0) {
            if ((i & 805306368) == 0) {
                if (composerStartRestartGroup.changed(dialogProperties)) {
                    i14 = C.BUFFER_FLAG_LAST_SAMPLE;
                } else {
                    i14 = 268435456;
                }
                i12 |= i14;
            }
            if ((i12 & 306783379) != 306783378) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i12 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "77@4252L6,77@4310L6,77@4352L32");
                if ((i & 1) != 0) {
                    if (i11 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        function6 = null;
                    }
                    if (i6 != 0) {
                        function7 = null;
                    }
                    if (i8 != 0) {
                        function8 = null;
                    }
                    if ((i2 & 64) != 0) {
                        i12 &= -3670017;
                        medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                    }
                    if ((i2 & 128) != 0) {
                        i12 &= -29360129;
                        jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                    } else {
                        jM2346getSurface0d7_KjU = j;
                    }
                    if ((i2 & 256) != 0) {
                        jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i12 >> 21) & 14);
                        i12 &= -234881025;
                    } else {
                        jM2360contentColorForek8zF_U = j2;
                    }
                    if (i13 != 0) {
                        dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                    } else {
                        dialogProperties3 = dialogProperties;
                    }
                    j5 = jM2346getSurface0d7_KjU;
                    function12 = function7;
                    i15 = i12;
                    j6 = jM2360contentColorForek8zF_U;
                    modifier4 = modifier2;
                    function13 = function8;
                    shape3 = medium;
                } else {
                    if (i11 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        function6 = null;
                    }
                    if (i6 != 0) {
                        function7 = null;
                    }
                    if (i8 != 0) {
                        function8 = null;
                    }
                    if ((i2 & 64) != 0) {
                        i12 &= -3670017;
                        medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                    }
                    if ((i2 & 128) != 0) {
                        i12 &= -29360129;
                        jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                    } else {
                        jM2346getSurface0d7_KjU = j;
                    }
                    if ((i2 & 256) != 0) {
                        jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i12 >> 21) & 14);
                        i12 &= -234881025;
                    } else {
                        jM2360contentColorForek8zF_U = j2;
                    }
                    if (i13 != 0) {
                        dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                    } else {
                        dialogProperties3 = dialogProperties;
                    }
                    j5 = jM2346getSurface0d7_KjU;
                    function12 = function7;
                    i15 = i12;
                    j6 = jM2360contentColorForek8zF_U;
                    modifier4 = modifier2;
                    function13 = function8;
                    shape3 = medium;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1967984963, i15, -1, "androidx.compose.material.AlertDialog (AndroidAlertDialog.android.kt:41)");
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1483448977, "CC(AlertDialogImpl)N(onDismissRequest,confirmButton,modifier,dismissButton,title,text,shape,backgroundColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,properties)149@6875L386,147@6799L678:AlertDialog.kt#jmzs0o");
                int i211117 = (2147483646 & i15) >> 3;
                composer2 = composerStartRestartGroup;
                m2242AlertDialogwqdebIU(function0, ComposableLambdaKt.rememberComposableLambda(-309297447, true, new AlertDialogKt$AlertDialogImpl$1(function6, function2), composerStartRestartGroup, 54), modifier4, function12, function13, shape3, j5, j6, dialogProperties3, composer2, (i15 & 896) | (i15 & 14) | 48 | (i211117 & 7168) | (57344 & i211117) | (458752 & i211117) | (3670016 & i211117) | (29360128 & i211117) | (i211117 & 234881024), 0);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                function9 = function6;
                modifier3 = modifier4;
                function10 = function12;
                function11 = function13;
                shape2 = shape3;
                j3 = j5;
                j4 = j6;
                dialogProperties2 = dialogProperties3;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier3 = modifier2;
                function9 = function6;
                function10 = function7;
                function11 = function8;
                shape2 = medium;
                j3 = j;
                j4 = j2;
                dialogProperties2 = dialogProperties;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.AndroidAlertDialog_androidKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return AndroidAlertDialog_androidKt.AlertDialog_6oU6zVQ$lambda$0(function0, function2, modifier3, function9, function10, function11, shape2, j3, j4, dialogProperties2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i12 |= 805306368;
        if ((i12 & 306783379) != 306783378) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i12 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "77@4252L6,77@4310L6,77@4352L32");
            if ((i & 1) != 0) {
                if (i11 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i4 != 0) {
                    function6 = null;
                }
                if (i6 != 0) {
                    function7 = null;
                }
                if (i8 != 0) {
                    function8 = null;
                }
                if ((i2 & 64) != 0) {
                    i12 &= -3670017;
                    medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                }
                if ((i2 & 128) != 0) {
                    i12 &= -29360129;
                    jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                } else {
                    jM2346getSurface0d7_KjU = j;
                }
                if ((i2 & 256) != 0) {
                    jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i12 >> 21) & 14);
                    i12 &= -234881025;
                } else {
                    jM2360contentColorForek8zF_U = j2;
                }
                if (i13 != 0) {
                    dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                } else {
                    dialogProperties3 = dialogProperties;
                }
                j5 = jM2346getSurface0d7_KjU;
                function12 = function7;
                i15 = i12;
                j6 = jM2360contentColorForek8zF_U;
                modifier4 = modifier2;
                function13 = function8;
                shape3 = medium;
            } else {
                if (i11 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i4 != 0) {
                    function6 = null;
                }
                if (i6 != 0) {
                    function7 = null;
                }
                if (i8 != 0) {
                    function8 = null;
                }
                if ((i2 & 64) != 0) {
                    i12 &= -3670017;
                    medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                }
                if ((i2 & 128) != 0) {
                    i12 &= -29360129;
                    jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                } else {
                    jM2346getSurface0d7_KjU = j;
                }
                if ((i2 & 256) != 0) {
                    jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i12 >> 21) & 14);
                    i12 &= -234881025;
                } else {
                    jM2360contentColorForek8zF_U = j2;
                }
                if (i13 != 0) {
                    dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                } else {
                    dialogProperties3 = dialogProperties;
                }
                j5 = jM2346getSurface0d7_KjU;
                function12 = function7;
                i15 = i12;
                j6 = jM2360contentColorForek8zF_U;
                modifier4 = modifier2;
                function13 = function8;
                shape3 = medium;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1967984963, i15, -1, "androidx.compose.material.AlertDialog (AndroidAlertDialog.android.kt:41)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1483448977, "CC(AlertDialogImpl)N(onDismissRequest,confirmButton,modifier,dismissButton,title,text,shape,backgroundColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,properties)149@6875L386,147@6799L678:AlertDialog.kt#jmzs0o");
            int i211118 = (2147483646 & i15) >> 3;
            composer2 = composerStartRestartGroup;
            m2242AlertDialogwqdebIU(function0, ComposableLambdaKt.rememberComposableLambda(-309297447, true, new AlertDialogKt$AlertDialogImpl$1(function6, function2), composerStartRestartGroup, 54), modifier4, function12, function13, shape3, j5, j6, dialogProperties3, composer2, (i15 & 896) | (i15 & 14) | 48 | (i211118 & 7168) | (57344 & i211118) | (458752 & i211118) | (3670016 & i211118) | (29360128 & i211118) | (i211118 & 234881024), 0);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            function9 = function6;
            modifier3 = modifier4;
            function10 = function12;
            function11 = function13;
            shape2 = shape3;
            j3 = j5;
            j4 = j6;
            dialogProperties2 = dialogProperties3;
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            modifier3 = modifier2;
            function9 = function6;
            function10 = function7;
            function11 = function8;
            shape2 = medium;
            j3 = j;
            j4 = j2;
            dialogProperties2 = dialogProperties;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.AndroidAlertDialog_androidKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AndroidAlertDialog_androidKt.AlertDialog_6oU6zVQ$lambda$0(function0, function2, modifier3, function9, function10, function11, shape2, j3, j4, dialogProperties2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX WARN: Code duplicated, block: B:100:0x012d  */
    /* JADX WARN: Code duplicated, block: B:102:0x0142  */
    /* JADX WARN: Code duplicated, block: B:115:0x0160 A[PHI: r6 r8 r10 r11 r14 r18 r19
      0x0160: PHI (r6v9 androidx.compose.ui.Modifier) = (r6v5 androidx.compose.ui.Modifier), (r6v2 androidx.compose.ui.Modifier) binds: [B:134:0x01aa, B:114:0x015e] A[DONT_GENERATE, DONT_INLINE]
      0x0160: PHI (r8v7 kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) = 
      (r8v4 kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>)
      (r8v2 kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>)
     binds: [B:134:0x01aa, B:114:0x015e] A[DONT_GENERATE, DONT_INLINE]
      0x0160: PHI (r10v6 kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) = 
      (r10v3 kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>)
      (r10v2 kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>)
     binds: [B:134:0x01aa, B:114:0x015e] A[DONT_GENERATE, DONT_INLINE]
      0x0160: PHI (r11v14 androidx.compose.ui.graphics.Shape) = (r11v10 androidx.compose.ui.graphics.Shape), (r11v7 androidx.compose.ui.graphics.Shape) binds: [B:134:0x01aa, B:114:0x015e] A[DONT_GENERATE, DONT_INLINE]
      0x0160: PHI (r14v9 long) = (r14v6 long), (r14v3 long) binds: [B:134:0x01aa, B:114:0x015e] A[DONT_GENERATE, DONT_INLINE]
      0x0160: PHI (r18v14 int) = (r18v9 int), (r18v17 int) binds: [B:134:0x01aa, B:114:0x015e] A[DONT_GENERATE, DONT_INLINE]
      0x0160: PHI (r19v6 long) = (r19v3 long), (r19v7 long) binds: [B:134:0x01aa, B:114:0x015e] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:117:0x0165 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:118:0x0167  */
    /* JADX WARN: Code duplicated, block: B:121:0x016f  */
    /* JADX WARN: Code duplicated, block: B:123:0x0172  */
    /* JADX WARN: Code duplicated, block: B:126:0x0178  */
    /* JADX WARN: Code duplicated, block: B:129:0x018b  */
    /* JADX WARN: Code duplicated, block: B:132:0x019b  */
    /* JADX WARN: Code duplicated, block: B:133:0x01a8  */
    /* JADX WARN: Code duplicated, block: B:135:0x01ac  */
    /* JADX WARN: Code duplicated, block: B:138:0x01cd  */
    /* JADX WARN: Code duplicated, block: B:141:0x022a  */
    /* JADX WARN: Code duplicated, block: B:143:0x0234  */
    /* JADX WARN: Code duplicated, block: B:146:0x0247  */
    /* JADX WARN: Code duplicated, block: B:148:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:31:0x005b  */
    /* JADX WARN: Code duplicated, block: B:32:0x005e  */
    /* JADX WARN: Code duplicated, block: B:34:0x0062  */
    /* JADX WARN: Code duplicated, block: B:36:0x006a  */
    /* JADX WARN: Code duplicated, block: B:37:0x006d  */
    /* JADX WARN: Code duplicated, block: B:42:0x0077  */
    /* JADX WARN: Code duplicated, block: B:43:0x007a  */
    /* JADX WARN: Code duplicated, block: B:45:0x007e  */
    /* JADX WARN: Code duplicated, block: B:47:0x0086  */
    /* JADX WARN: Code duplicated, block: B:48:0x0089  */
    /* JADX WARN: Code duplicated, block: B:53:0x0094  */
    /* JADX WARN: Code duplicated, block: B:55:0x0098  */
    /* JADX WARN: Code duplicated, block: B:57:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:58:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:61:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:64:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:66:0x00b4  */
    /* JADX WARN: Code duplicated, block: B:68:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:69:0x00bf  */
    /* JADX WARN: Code duplicated, block: B:72:0x00c6  */
    /* JADX WARN: Code duplicated, block: B:75:0x00ce  */
    /* JADX WARN: Code duplicated, block: B:77:0x00d6  */
    /* JADX WARN: Code duplicated, block: B:80:0x00df  */
    /* JADX WARN: Code duplicated, block: B:82:0x00e4  */
    /* JADX WARN: Code duplicated, block: B:85:0x00f2  */
    /* JADX WARN: Code duplicated, block: B:86:0x00fb  */
    /* JADX WARN: Code duplicated, block: B:88:0x00ff  */
    /* JADX WARN: Code duplicated, block: B:90:0x0109  */
    /* JADX WARN: Code duplicated, block: B:91:0x010c  */
    /* JADX WARN: Code duplicated, block: B:93:0x0111  */
    /* JADX WARN: Code duplicated, block: B:96:0x0122  */
    /* JADX WARN: Code duplicated, block: B:97:0x0124  */
    /* JADX INFO: renamed from: AlertDialog-wqdebIU, reason: not valid java name */
    public static final void m2242AlertDialogwqdebIU(final Function0<Unit> function0, final Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function3, Function2<? super Composer, ? super Integer, Unit> function4, Shape shape, long j, long j2, DialogProperties dialogProperties, Composer composer, final int i, final int i2) {
        int i3;
        Function2<? super Composer, ? super Integer, Unit> function5;
        Modifier modifier2;
        int i4;
        Function2<? super Composer, ? super Integer, Unit> function6;
        int i5;
        int i6;
        Function2<? super Composer, ? super Integer, Unit> function7;
        int i7;
        Shape medium;
        long jM2346getSurface0d7_KjU;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        boolean z;
        Composer composer2;
        final Modifier modifier3;
        final Function2<? super Composer, ? super Integer, Unit> function8;
        final Shape shape2;
        final long j3;
        final DialogProperties dialogProperties2;
        final Function2<? super Composer, ? super Integer, Unit> function9;
        final long j4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        long jM2360contentColorForek8zF_U;
        DialogProperties dialogProperties3;
        int i13;
        int i14;
        Composer composerStartRestartGroup = composer.startRestartGroup(1409209698);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(AlertDialog)N(onDismissRequest,buttons,modifier,title,text,shape,backgroundColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,properties)66@2171L303:AndroidAlertDialog.android.kt#jmzs0o");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(function0) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            function5 = function2;
            i3 |= composerStartRestartGroup.changedInstance(function5) ? 32 : 16;
        } else {
            function5 = function2;
        }
        int i15 = i2 & 4;
        if (i15 == 0) {
            if ((i & 384) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            i4 = i2 & 8;
            if (i4 != 0) {
                if ((i & 3072) == 0) {
                    function6 = function3;
                    if (composerStartRestartGroup.changedInstance(function6)) {
                        i5 = 2048;
                    } else {
                        i5 = 1024;
                    }
                    i3 |= i5;
                }
                i6 = i2 & 16;
                if (i6 != 0) {
                    if ((i & 24576) == 0) {
                        function7 = function4;
                        if (composerStartRestartGroup.changedInstance(function7)) {
                            i7 = 16384;
                        } else {
                            i7 = 8192;
                        }
                        i3 |= i7;
                    }
                    if ((196608 & i) == 0) {
                        if ((i2 & 32) == 0) {
                            medium = shape;
                            int i16 = composerStartRestartGroup.changed(medium) ? 131072 : 65536;
                            i3 |= i16;
                        } else {
                            medium = shape;
                        }
                        i3 |= i16;
                    } else {
                        medium = shape;
                    }
                    if ((1572864 & i) == 0) {
                        if ((i2 & 64) == 0) {
                            jM2346getSurface0d7_KjU = j;
                            int i17 = composerStartRestartGroup.changed(jM2346getSurface0d7_KjU) ? 1048576 : 524288;
                            i3 |= i17;
                        } else {
                            jM2346getSurface0d7_KjU = j;
                        }
                        i3 |= i17;
                    } else {
                        jM2346getSurface0d7_KjU = j;
                    }
                    if ((i & 12582912) == 0) {
                        int i18 = i3;
                        if ((i2 & 128) == 0 || !composerStartRestartGroup.changed(j2)) {
                            i14 = 4194304;
                        } else {
                            i14 = 8388608;
                        }
                        i8 = i18 | i14;
                    } else {
                        i8 = i3;
                    }
                    i9 = i8;
                    i10 = i2 & 256;
                    if (i10 != 0) {
                        i11 = i9 | 100663296;
                    } else if ((i & 100663296) == 0) {
                        if (composerStartRestartGroup.changed(dialogProperties)) {
                            i12 = 67108864;
                        } else {
                            i12 = 33554432;
                        }
                        i11 = i9 | i12;
                    } else {
                        i11 = i9;
                    }
                    if ((i11 & 38347923) != 38347922) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z, i11 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "77@6141L6,77@6199L6,77@6241L32");
                        if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            if (i15 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                function6 = null;
                            }
                            if (i6 != 0) {
                                function7 = null;
                            }
                            if ((i2 & 32) != 0) {
                                i11 &= -458753;
                                medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                            }
                            if ((i2 & 64) != 0) {
                                jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                                i11 &= -3670017;
                            }
                            if ((i2 & 128) != 0) {
                                jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i11 >> 18) & 14);
                                i11 &= -29360129;
                            } else {
                                jM2360contentColorForek8zF_U = j2;
                            }
                            if (i10 != 0) {
                                dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                            }
                            i13 = i11;
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1409209698, i13, -1, "androidx.compose.material.AlertDialog (AndroidAlertDialog.android.kt:66)");
                            }
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -214309806, "CC(AlertDialogImpl)N(onDismissRequest,buttons,modifier,title,text,shape,backgroundColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,properties)180@7953L276,180@7884L345:AlertDialog.kt#jmzs0o");
                            DialogProperties dialogProperties4 = dialogProperties3;
                            AndroidDialog_androidKt.Dialog(function0, dialogProperties4, ComposableLambdaKt.rememberComposableLambda(-488319269, true, new AlertDialogKt$AlertDialogImpl$2(function5, modifier2, function6, function7, medium, jM2346getSurface0d7_KjU, jM2360contentColorForek8zF_U), composerStartRestartGroup, 54), composerStartRestartGroup, (i13 & 14) | 384 | (((268435454 & i13) >> 21) & 112), 0);
                            composer2 = composerStartRestartGroup;
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier3 = modifier2;
                            function8 = function7;
                            shape2 = medium;
                            j3 = jM2360contentColorForek8zF_U;
                            dialogProperties2 = dialogProperties4;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i2 & 32) != 0) {
                                i11 &= -458753;
                            }
                            if ((i2 & 64) != 0) {
                                i11 &= -3670017;
                            }
                            if ((i2 & 128) != 0) {
                                i11 &= -29360129;
                            }
                            jM2360contentColorForek8zF_U = j2;
                        }
                        dialogProperties3 = dialogProperties;
                        i13 = i11;
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1409209698, i13, -1, "androidx.compose.material.AlertDialog (AndroidAlertDialog.android.kt:66)");
                        }
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -214309806, "CC(AlertDialogImpl)N(onDismissRequest,buttons,modifier,title,text,shape,backgroundColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,properties)180@7953L276,180@7884L345:AlertDialog.kt#jmzs0o");
                        DialogProperties dialogProperties5 = dialogProperties3;
                        AndroidDialog_androidKt.Dialog(function0, dialogProperties5, ComposableLambdaKt.rememberComposableLambda(-488319269, true, new AlertDialogKt$AlertDialogImpl$2(function5, modifier2, function6, function7, medium, jM2346getSurface0d7_KjU, jM2360contentColorForek8zF_U), composerStartRestartGroup, 54), composerStartRestartGroup, (i13 & 14) | 384 | (((268435454 & i13) >> 21) & 112), 0);
                        composer2 = composerStartRestartGroup;
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier2;
                        function8 = function7;
                        shape2 = medium;
                        j3 = jM2360contentColorForek8zF_U;
                        dialogProperties2 = dialogProperties5;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        modifier3 = modifier2;
                        function8 = function7;
                        shape2 = medium;
                        j3 = j2;
                        dialogProperties2 = dialogProperties;
                    }
                    function9 = function6;
                    j4 = jM2346getSurface0d7_KjU;
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.AndroidAlertDialog_androidKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return AndroidAlertDialog_androidKt.AlertDialog_wqdebIU$lambda$0(function0, function2, modifier3, function9, function8, shape2, j4, j3, dialogProperties2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= 24576;
                function7 = function4;
                if ((196608 & i) == 0) {
                    if ((i2 & 32) == 0) {
                        medium = shape;
                        if (composerStartRestartGroup.changed(medium)) {
                        }
                        i3 |= i16;
                    } else {
                        medium = shape;
                    }
                    i3 |= i16;
                } else {
                    medium = shape;
                }
                if ((1572864 & i) == 0) {
                    if ((i2 & 64) == 0) {
                        jM2346getSurface0d7_KjU = j;
                        if (composerStartRestartGroup.changed(jM2346getSurface0d7_KjU)) {
                        }
                        i3 |= i17;
                    } else {
                        jM2346getSurface0d7_KjU = j;
                    }
                    i3 |= i17;
                } else {
                    jM2346getSurface0d7_KjU = j;
                }
                if ((i & 12582912) == 0) {
                    int i19 = i3;
                    if ((i2 & 128) == 0) {
                        i14 = 4194304;
                    } else {
                        i14 = 4194304;
                    }
                    i8 = i19 | i14;
                } else {
                    i8 = i3;
                }
                i9 = i8;
                i10 = i2 & 256;
                if (i10 != 0) {
                    i11 = i9 | 100663296;
                } else if ((i & 100663296) == 0) {
                    if (composerStartRestartGroup.changed(dialogProperties)) {
                        i12 = 67108864;
                    } else {
                        i12 = 33554432;
                    }
                    i11 = i9 | i12;
                } else {
                    i11 = i9;
                }
                if ((i11 & 38347923) != 38347922) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i11 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "77@6141L6,77@6199L6,77@6241L32");
                    if ((i & 1) != 0) {
                        if (i15 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            function6 = null;
                        }
                        if (i6 != 0) {
                            function7 = null;
                        }
                        if ((i2 & 32) != 0) {
                            i11 &= -458753;
                            medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                        }
                        if ((i2 & 64) != 0) {
                            jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                            i11 &= -3670017;
                        }
                        if ((i2 & 128) != 0) {
                            jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i11 >> 18) & 14);
                            i11 &= -29360129;
                        } else {
                            jM2360contentColorForek8zF_U = j2;
                        }
                        if (i10 != 0) {
                            dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                        } else {
                            dialogProperties3 = dialogProperties;
                        }
                    } else {
                        if (i15 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            function6 = null;
                        }
                        if (i6 != 0) {
                            function7 = null;
                        }
                        if ((i2 & 32) != 0) {
                            i11 &= -458753;
                            medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                        }
                        if ((i2 & 64) != 0) {
                            jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                            i11 &= -3670017;
                        }
                        if ((i2 & 128) != 0) {
                            jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i11 >> 18) & 14);
                            i11 &= -29360129;
                        } else {
                            jM2360contentColorForek8zF_U = j2;
                        }
                        if (i10 != 0) {
                            dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                        } else {
                            dialogProperties3 = dialogProperties;
                        }
                    }
                    i13 = i11;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1409209698, i13, -1, "androidx.compose.material.AlertDialog (AndroidAlertDialog.android.kt:66)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -214309806, "CC(AlertDialogImpl)N(onDismissRequest,buttons,modifier,title,text,shape,backgroundColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,properties)180@7953L276,180@7884L345:AlertDialog.kt#jmzs0o");
                    DialogProperties dialogProperties6 = dialogProperties3;
                    AndroidDialog_androidKt.Dialog(function0, dialogProperties6, ComposableLambdaKt.rememberComposableLambda(-488319269, true, new AlertDialogKt$AlertDialogImpl$2(function5, modifier2, function6, function7, medium, jM2346getSurface0d7_KjU, jM2360contentColorForek8zF_U), composerStartRestartGroup, 54), composerStartRestartGroup, (i13 & 14) | 384 | (((268435454 & i13) >> 21) & 112), 0);
                    composer2 = composerStartRestartGroup;
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                    function8 = function7;
                    shape2 = medium;
                    j3 = jM2360contentColorForek8zF_U;
                    dialogProperties2 = dialogProperties6;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    modifier3 = modifier2;
                    function8 = function7;
                    shape2 = medium;
                    j3 = j2;
                    dialogProperties2 = dialogProperties;
                }
                function9 = function6;
                j4 = jM2346getSurface0d7_KjU;
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.AndroidAlertDialog_androidKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return AndroidAlertDialog_androidKt.AlertDialog_wqdebIU$lambda$0(function0, function2, modifier3, function9, function8, shape2, j4, j3, dialogProperties2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 3072;
            function6 = function3;
            i6 = i2 & 16;
            if (i6 != 0) {
                if ((i & 24576) == 0) {
                    function7 = function4;
                    if (composerStartRestartGroup.changedInstance(function7)) {
                        i7 = 16384;
                    } else {
                        i7 = 8192;
                    }
                    i3 |= i7;
                }
                if ((196608 & i) == 0) {
                    if ((i2 & 32) == 0) {
                        medium = shape;
                        if (composerStartRestartGroup.changed(medium)) {
                        }
                        i3 |= i16;
                    } else {
                        medium = shape;
                    }
                    i3 |= i16;
                } else {
                    medium = shape;
                }
                if ((1572864 & i) == 0) {
                    if ((i2 & 64) == 0) {
                        jM2346getSurface0d7_KjU = j;
                        if (composerStartRestartGroup.changed(jM2346getSurface0d7_KjU)) {
                        }
                        i3 |= i17;
                    } else {
                        jM2346getSurface0d7_KjU = j;
                    }
                    i3 |= i17;
                } else {
                    jM2346getSurface0d7_KjU = j;
                }
                if ((i & 12582912) == 0) {
                    int i110 = i3;
                    if ((i2 & 128) == 0) {
                        i14 = 4194304;
                    } else {
                        i14 = 4194304;
                    }
                    i8 = i110 | i14;
                } else {
                    i8 = i3;
                }
                i9 = i8;
                i10 = i2 & 256;
                if (i10 != 0) {
                    i11 = i9 | 100663296;
                } else if ((i & 100663296) == 0) {
                    if (composerStartRestartGroup.changed(dialogProperties)) {
                        i12 = 67108864;
                    } else {
                        i12 = 33554432;
                    }
                    i11 = i9 | i12;
                } else {
                    i11 = i9;
                }
                if ((i11 & 38347923) != 38347922) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i11 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "77@6141L6,77@6199L6,77@6241L32");
                    if ((i & 1) != 0) {
                        if (i15 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            function6 = null;
                        }
                        if (i6 != 0) {
                            function7 = null;
                        }
                        if ((i2 & 32) != 0) {
                            i11 &= -458753;
                            medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                        }
                        if ((i2 & 64) != 0) {
                            jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                            i11 &= -3670017;
                        }
                        if ((i2 & 128) != 0) {
                            jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i11 >> 18) & 14);
                            i11 &= -29360129;
                        } else {
                            jM2360contentColorForek8zF_U = j2;
                        }
                        if (i10 != 0) {
                            dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                        } else {
                            dialogProperties3 = dialogProperties;
                        }
                    } else {
                        if (i15 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            function6 = null;
                        }
                        if (i6 != 0) {
                            function7 = null;
                        }
                        if ((i2 & 32) != 0) {
                            i11 &= -458753;
                            medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                        }
                        if ((i2 & 64) != 0) {
                            jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                            i11 &= -3670017;
                        }
                        if ((i2 & 128) != 0) {
                            jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i11 >> 18) & 14);
                            i11 &= -29360129;
                        } else {
                            jM2360contentColorForek8zF_U = j2;
                        }
                        if (i10 != 0) {
                            dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                        } else {
                            dialogProperties3 = dialogProperties;
                        }
                    }
                    i13 = i11;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1409209698, i13, -1, "androidx.compose.material.AlertDialog (AndroidAlertDialog.android.kt:66)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -214309806, "CC(AlertDialogImpl)N(onDismissRequest,buttons,modifier,title,text,shape,backgroundColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,properties)180@7953L276,180@7884L345:AlertDialog.kt#jmzs0o");
                    DialogProperties dialogProperties7 = dialogProperties3;
                    AndroidDialog_androidKt.Dialog(function0, dialogProperties7, ComposableLambdaKt.rememberComposableLambda(-488319269, true, new AlertDialogKt$AlertDialogImpl$2(function5, modifier2, function6, function7, medium, jM2346getSurface0d7_KjU, jM2360contentColorForek8zF_U), composerStartRestartGroup, 54), composerStartRestartGroup, (i13 & 14) | 384 | (((268435454 & i13) >> 21) & 112), 0);
                    composer2 = composerStartRestartGroup;
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                    function8 = function7;
                    shape2 = medium;
                    j3 = jM2360contentColorForek8zF_U;
                    dialogProperties2 = dialogProperties7;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    modifier3 = modifier2;
                    function8 = function7;
                    shape2 = medium;
                    j3 = j2;
                    dialogProperties2 = dialogProperties;
                }
                function9 = function6;
                j4 = jM2346getSurface0d7_KjU;
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.AndroidAlertDialog_androidKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return AndroidAlertDialog_androidKt.AlertDialog_wqdebIU$lambda$0(function0, function2, modifier3, function9, function8, shape2, j4, j3, dialogProperties2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 24576;
            function7 = function4;
            if ((196608 & i) == 0) {
                if ((i2 & 32) == 0) {
                    medium = shape;
                    if (composerStartRestartGroup.changed(medium)) {
                    }
                    i3 |= i16;
                } else {
                    medium = shape;
                }
                i3 |= i16;
            } else {
                medium = shape;
            }
            if ((1572864 & i) == 0) {
                if ((i2 & 64) == 0) {
                    jM2346getSurface0d7_KjU = j;
                    if (composerStartRestartGroup.changed(jM2346getSurface0d7_KjU)) {
                    }
                    i3 |= i17;
                } else {
                    jM2346getSurface0d7_KjU = j;
                }
                i3 |= i17;
            } else {
                jM2346getSurface0d7_KjU = j;
            }
            if ((i & 12582912) == 0) {
                int i111 = i3;
                if ((i2 & 128) == 0) {
                    i14 = 4194304;
                } else {
                    i14 = 4194304;
                }
                i8 = i111 | i14;
            } else {
                i8 = i3;
            }
            i9 = i8;
            i10 = i2 & 256;
            if (i10 != 0) {
                i11 = i9 | 100663296;
            } else if ((i & 100663296) == 0) {
                if (composerStartRestartGroup.changed(dialogProperties)) {
                    i12 = 67108864;
                } else {
                    i12 = 33554432;
                }
                i11 = i9 | i12;
            } else {
                i11 = i9;
            }
            if ((i11 & 38347923) != 38347922) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i11 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "77@6141L6,77@6199L6,77@6241L32");
                if ((i & 1) != 0) {
                    if (i15 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        function6 = null;
                    }
                    if (i6 != 0) {
                        function7 = null;
                    }
                    if ((i2 & 32) != 0) {
                        i11 &= -458753;
                        medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                    }
                    if ((i2 & 64) != 0) {
                        jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                        i11 &= -3670017;
                    }
                    if ((i2 & 128) != 0) {
                        jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i11 >> 18) & 14);
                        i11 &= -29360129;
                    } else {
                        jM2360contentColorForek8zF_U = j2;
                    }
                    if (i10 != 0) {
                        dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                    } else {
                        dialogProperties3 = dialogProperties;
                    }
                } else {
                    if (i15 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        function6 = null;
                    }
                    if (i6 != 0) {
                        function7 = null;
                    }
                    if ((i2 & 32) != 0) {
                        i11 &= -458753;
                        medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                    }
                    if ((i2 & 64) != 0) {
                        jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                        i11 &= -3670017;
                    }
                    if ((i2 & 128) != 0) {
                        jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i11 >> 18) & 14);
                        i11 &= -29360129;
                    } else {
                        jM2360contentColorForek8zF_U = j2;
                    }
                    if (i10 != 0) {
                        dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                    } else {
                        dialogProperties3 = dialogProperties;
                    }
                }
                i13 = i11;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1409209698, i13, -1, "androidx.compose.material.AlertDialog (AndroidAlertDialog.android.kt:66)");
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -214309806, "CC(AlertDialogImpl)N(onDismissRequest,buttons,modifier,title,text,shape,backgroundColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,properties)180@7953L276,180@7884L345:AlertDialog.kt#jmzs0o");
                DialogProperties dialogProperties8 = dialogProperties3;
                AndroidDialog_androidKt.Dialog(function0, dialogProperties8, ComposableLambdaKt.rememberComposableLambda(-488319269, true, new AlertDialogKt$AlertDialogImpl$2(function5, modifier2, function6, function7, medium, jM2346getSurface0d7_KjU, jM2360contentColorForek8zF_U), composerStartRestartGroup, 54), composerStartRestartGroup, (i13 & 14) | 384 | (((268435454 & i13) >> 21) & 112), 0);
                composer2 = composerStartRestartGroup;
                ComposerKt.sourceInformationMarkerEnd(composer2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier2;
                function8 = function7;
                shape2 = medium;
                j3 = jM2360contentColorForek8zF_U;
                dialogProperties2 = dialogProperties8;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier3 = modifier2;
                function8 = function7;
                shape2 = medium;
                j3 = j2;
                dialogProperties2 = dialogProperties;
            }
            function9 = function6;
            j4 = jM2346getSurface0d7_KjU;
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.AndroidAlertDialog_androidKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return AndroidAlertDialog_androidKt.AlertDialog_wqdebIU$lambda$0(function0, function2, modifier3, function9, function8, shape2, j4, j3, dialogProperties2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 384;
        modifier2 = modifier;
        i4 = i2 & 8;
        if (i4 != 0) {
            if ((i & 3072) == 0) {
                function6 = function3;
                if (composerStartRestartGroup.changedInstance(function6)) {
                    i5 = 2048;
                } else {
                    i5 = 1024;
                }
                i3 |= i5;
            }
            i6 = i2 & 16;
            if (i6 != 0) {
                if ((i & 24576) == 0) {
                    function7 = function4;
                    if (composerStartRestartGroup.changedInstance(function7)) {
                        i7 = 16384;
                    } else {
                        i7 = 8192;
                    }
                    i3 |= i7;
                }
                if ((196608 & i) == 0) {
                    if ((i2 & 32) == 0) {
                        medium = shape;
                        if (composerStartRestartGroup.changed(medium)) {
                        }
                        i3 |= i16;
                    } else {
                        medium = shape;
                    }
                    i3 |= i16;
                } else {
                    medium = shape;
                }
                if ((1572864 & i) == 0) {
                    if ((i2 & 64) == 0) {
                        jM2346getSurface0d7_KjU = j;
                        if (composerStartRestartGroup.changed(jM2346getSurface0d7_KjU)) {
                        }
                        i3 |= i17;
                    } else {
                        jM2346getSurface0d7_KjU = j;
                    }
                    i3 |= i17;
                } else {
                    jM2346getSurface0d7_KjU = j;
                }
                if ((i & 12582912) == 0) {
                    int i112 = i3;
                    if ((i2 & 128) == 0) {
                        i14 = 4194304;
                    } else {
                        i14 = 4194304;
                    }
                    i8 = i112 | i14;
                } else {
                    i8 = i3;
                }
                i9 = i8;
                i10 = i2 & 256;
                if (i10 != 0) {
                    i11 = i9 | 100663296;
                } else if ((i & 100663296) == 0) {
                    if (composerStartRestartGroup.changed(dialogProperties)) {
                        i12 = 67108864;
                    } else {
                        i12 = 33554432;
                    }
                    i11 = i9 | i12;
                } else {
                    i11 = i9;
                }
                if ((i11 & 38347923) != 38347922) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i11 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "77@6141L6,77@6199L6,77@6241L32");
                    if ((i & 1) != 0) {
                        if (i15 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            function6 = null;
                        }
                        if (i6 != 0) {
                            function7 = null;
                        }
                        if ((i2 & 32) != 0) {
                            i11 &= -458753;
                            medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                        }
                        if ((i2 & 64) != 0) {
                            jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                            i11 &= -3670017;
                        }
                        if ((i2 & 128) != 0) {
                            jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i11 >> 18) & 14);
                            i11 &= -29360129;
                        } else {
                            jM2360contentColorForek8zF_U = j2;
                        }
                        if (i10 != 0) {
                            dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                        } else {
                            dialogProperties3 = dialogProperties;
                        }
                    } else {
                        if (i15 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            function6 = null;
                        }
                        if (i6 != 0) {
                            function7 = null;
                        }
                        if ((i2 & 32) != 0) {
                            i11 &= -458753;
                            medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                        }
                        if ((i2 & 64) != 0) {
                            jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                            i11 &= -3670017;
                        }
                        if ((i2 & 128) != 0) {
                            jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i11 >> 18) & 14);
                            i11 &= -29360129;
                        } else {
                            jM2360contentColorForek8zF_U = j2;
                        }
                        if (i10 != 0) {
                            dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                        } else {
                            dialogProperties3 = dialogProperties;
                        }
                    }
                    i13 = i11;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1409209698, i13, -1, "androidx.compose.material.AlertDialog (AndroidAlertDialog.android.kt:66)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -214309806, "CC(AlertDialogImpl)N(onDismissRequest,buttons,modifier,title,text,shape,backgroundColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,properties)180@7953L276,180@7884L345:AlertDialog.kt#jmzs0o");
                    DialogProperties dialogProperties9 = dialogProperties3;
                    AndroidDialog_androidKt.Dialog(function0, dialogProperties9, ComposableLambdaKt.rememberComposableLambda(-488319269, true, new AlertDialogKt$AlertDialogImpl$2(function5, modifier2, function6, function7, medium, jM2346getSurface0d7_KjU, jM2360contentColorForek8zF_U), composerStartRestartGroup, 54), composerStartRestartGroup, (i13 & 14) | 384 | (((268435454 & i13) >> 21) & 112), 0);
                    composer2 = composerStartRestartGroup;
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier2;
                    function8 = function7;
                    shape2 = medium;
                    j3 = jM2360contentColorForek8zF_U;
                    dialogProperties2 = dialogProperties9;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    modifier3 = modifier2;
                    function8 = function7;
                    shape2 = medium;
                    j3 = j2;
                    dialogProperties2 = dialogProperties;
                }
                function9 = function6;
                j4 = jM2346getSurface0d7_KjU;
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.AndroidAlertDialog_androidKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return AndroidAlertDialog_androidKt.AlertDialog_wqdebIU$lambda$0(function0, function2, modifier3, function9, function8, shape2, j4, j3, dialogProperties2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 24576;
            function7 = function4;
            if ((196608 & i) == 0) {
                if ((i2 & 32) == 0) {
                    medium = shape;
                    if (composerStartRestartGroup.changed(medium)) {
                    }
                    i3 |= i16;
                } else {
                    medium = shape;
                }
                i3 |= i16;
            } else {
                medium = shape;
            }
            if ((1572864 & i) == 0) {
                if ((i2 & 64) == 0) {
                    jM2346getSurface0d7_KjU = j;
                    if (composerStartRestartGroup.changed(jM2346getSurface0d7_KjU)) {
                    }
                    i3 |= i17;
                } else {
                    jM2346getSurface0d7_KjU = j;
                }
                i3 |= i17;
            } else {
                jM2346getSurface0d7_KjU = j;
            }
            if ((i & 12582912) == 0) {
                int i113 = i3;
                if ((i2 & 128) == 0) {
                    i14 = 4194304;
                } else {
                    i14 = 4194304;
                }
                i8 = i113 | i14;
            } else {
                i8 = i3;
            }
            i9 = i8;
            i10 = i2 & 256;
            if (i10 != 0) {
                i11 = i9 | 100663296;
            } else if ((i & 100663296) == 0) {
                if (composerStartRestartGroup.changed(dialogProperties)) {
                    i12 = 67108864;
                } else {
                    i12 = 33554432;
                }
                i11 = i9 | i12;
            } else {
                i11 = i9;
            }
            if ((i11 & 38347923) != 38347922) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i11 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "77@6141L6,77@6199L6,77@6241L32");
                if ((i & 1) != 0) {
                    if (i15 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        function6 = null;
                    }
                    if (i6 != 0) {
                        function7 = null;
                    }
                    if ((i2 & 32) != 0) {
                        i11 &= -458753;
                        medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                    }
                    if ((i2 & 64) != 0) {
                        jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                        i11 &= -3670017;
                    }
                    if ((i2 & 128) != 0) {
                        jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i11 >> 18) & 14);
                        i11 &= -29360129;
                    } else {
                        jM2360contentColorForek8zF_U = j2;
                    }
                    if (i10 != 0) {
                        dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                    } else {
                        dialogProperties3 = dialogProperties;
                    }
                } else {
                    if (i15 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        function6 = null;
                    }
                    if (i6 != 0) {
                        function7 = null;
                    }
                    if ((i2 & 32) != 0) {
                        i11 &= -458753;
                        medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                    }
                    if ((i2 & 64) != 0) {
                        jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                        i11 &= -3670017;
                    }
                    if ((i2 & 128) != 0) {
                        jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i11 >> 18) & 14);
                        i11 &= -29360129;
                    } else {
                        jM2360contentColorForek8zF_U = j2;
                    }
                    if (i10 != 0) {
                        dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                    } else {
                        dialogProperties3 = dialogProperties;
                    }
                }
                i13 = i11;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1409209698, i13, -1, "androidx.compose.material.AlertDialog (AndroidAlertDialog.android.kt:66)");
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -214309806, "CC(AlertDialogImpl)N(onDismissRequest,buttons,modifier,title,text,shape,backgroundColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,properties)180@7953L276,180@7884L345:AlertDialog.kt#jmzs0o");
                DialogProperties dialogProperties10 = dialogProperties3;
                AndroidDialog_androidKt.Dialog(function0, dialogProperties10, ComposableLambdaKt.rememberComposableLambda(-488319269, true, new AlertDialogKt$AlertDialogImpl$2(function5, modifier2, function6, function7, medium, jM2346getSurface0d7_KjU, jM2360contentColorForek8zF_U), composerStartRestartGroup, 54), composerStartRestartGroup, (i13 & 14) | 384 | (((268435454 & i13) >> 21) & 112), 0);
                composer2 = composerStartRestartGroup;
                ComposerKt.sourceInformationMarkerEnd(composer2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier2;
                function8 = function7;
                shape2 = medium;
                j3 = jM2360contentColorForek8zF_U;
                dialogProperties2 = dialogProperties10;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier3 = modifier2;
                function8 = function7;
                shape2 = medium;
                j3 = j2;
                dialogProperties2 = dialogProperties;
            }
            function9 = function6;
            j4 = jM2346getSurface0d7_KjU;
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.AndroidAlertDialog_androidKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return AndroidAlertDialog_androidKt.AlertDialog_wqdebIU$lambda$0(function0, function2, modifier3, function9, function8, shape2, j4, j3, dialogProperties2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 3072;
        function6 = function3;
        i6 = i2 & 16;
        if (i6 != 0) {
            if ((i & 24576) == 0) {
                function7 = function4;
                if (composerStartRestartGroup.changedInstance(function7)) {
                    i7 = 16384;
                } else {
                    i7 = 8192;
                }
                i3 |= i7;
            }
            if ((196608 & i) == 0) {
                if ((i2 & 32) == 0) {
                    medium = shape;
                    if (composerStartRestartGroup.changed(medium)) {
                    }
                    i3 |= i16;
                } else {
                    medium = shape;
                }
                i3 |= i16;
            } else {
                medium = shape;
            }
            if ((1572864 & i) == 0) {
                if ((i2 & 64) == 0) {
                    jM2346getSurface0d7_KjU = j;
                    if (composerStartRestartGroup.changed(jM2346getSurface0d7_KjU)) {
                    }
                    i3 |= i17;
                } else {
                    jM2346getSurface0d7_KjU = j;
                }
                i3 |= i17;
            } else {
                jM2346getSurface0d7_KjU = j;
            }
            if ((i & 12582912) == 0) {
                int i114 = i3;
                if ((i2 & 128) == 0) {
                    i14 = 4194304;
                } else {
                    i14 = 4194304;
                }
                i8 = i114 | i14;
            } else {
                i8 = i3;
            }
            i9 = i8;
            i10 = i2 & 256;
            if (i10 != 0) {
                i11 = i9 | 100663296;
            } else if ((i & 100663296) == 0) {
                if (composerStartRestartGroup.changed(dialogProperties)) {
                    i12 = 67108864;
                } else {
                    i12 = 33554432;
                }
                i11 = i9 | i12;
            } else {
                i11 = i9;
            }
            if ((i11 & 38347923) != 38347922) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i11 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "77@6141L6,77@6199L6,77@6241L32");
                if ((i & 1) != 0) {
                    if (i15 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        function6 = null;
                    }
                    if (i6 != 0) {
                        function7 = null;
                    }
                    if ((i2 & 32) != 0) {
                        i11 &= -458753;
                        medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                    }
                    if ((i2 & 64) != 0) {
                        jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                        i11 &= -3670017;
                    }
                    if ((i2 & 128) != 0) {
                        jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i11 >> 18) & 14);
                        i11 &= -29360129;
                    } else {
                        jM2360contentColorForek8zF_U = j2;
                    }
                    if (i10 != 0) {
                        dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                    } else {
                        dialogProperties3 = dialogProperties;
                    }
                } else {
                    if (i15 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        function6 = null;
                    }
                    if (i6 != 0) {
                        function7 = null;
                    }
                    if ((i2 & 32) != 0) {
                        i11 &= -458753;
                        medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                    }
                    if ((i2 & 64) != 0) {
                        jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                        i11 &= -3670017;
                    }
                    if ((i2 & 128) != 0) {
                        jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i11 >> 18) & 14);
                        i11 &= -29360129;
                    } else {
                        jM2360contentColorForek8zF_U = j2;
                    }
                    if (i10 != 0) {
                        dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                    } else {
                        dialogProperties3 = dialogProperties;
                    }
                }
                i13 = i11;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1409209698, i13, -1, "androidx.compose.material.AlertDialog (AndroidAlertDialog.android.kt:66)");
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -214309806, "CC(AlertDialogImpl)N(onDismissRequest,buttons,modifier,title,text,shape,backgroundColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,properties)180@7953L276,180@7884L345:AlertDialog.kt#jmzs0o");
                DialogProperties dialogProperties11 = dialogProperties3;
                AndroidDialog_androidKt.Dialog(function0, dialogProperties11, ComposableLambdaKt.rememberComposableLambda(-488319269, true, new AlertDialogKt$AlertDialogImpl$2(function5, modifier2, function6, function7, medium, jM2346getSurface0d7_KjU, jM2360contentColorForek8zF_U), composerStartRestartGroup, 54), composerStartRestartGroup, (i13 & 14) | 384 | (((268435454 & i13) >> 21) & 112), 0);
                composer2 = composerStartRestartGroup;
                ComposerKt.sourceInformationMarkerEnd(composer2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier2;
                function8 = function7;
                shape2 = medium;
                j3 = jM2360contentColorForek8zF_U;
                dialogProperties2 = dialogProperties11;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier3 = modifier2;
                function8 = function7;
                shape2 = medium;
                j3 = j2;
                dialogProperties2 = dialogProperties;
            }
            function9 = function6;
            j4 = jM2346getSurface0d7_KjU;
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.AndroidAlertDialog_androidKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return AndroidAlertDialog_androidKt.AlertDialog_wqdebIU$lambda$0(function0, function2, modifier3, function9, function8, shape2, j4, j3, dialogProperties2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 24576;
        function7 = function4;
        if ((196608 & i) == 0) {
            if ((i2 & 32) == 0) {
                medium = shape;
                if (composerStartRestartGroup.changed(medium)) {
                }
                i3 |= i16;
            } else {
                medium = shape;
            }
            i3 |= i16;
        } else {
            medium = shape;
        }
        if ((1572864 & i) == 0) {
            if ((i2 & 64) == 0) {
                jM2346getSurface0d7_KjU = j;
                if (composerStartRestartGroup.changed(jM2346getSurface0d7_KjU)) {
                }
                i3 |= i17;
            } else {
                jM2346getSurface0d7_KjU = j;
            }
            i3 |= i17;
        } else {
            jM2346getSurface0d7_KjU = j;
        }
        if ((i & 12582912) == 0) {
            int i115 = i3;
            if ((i2 & 128) == 0) {
                i14 = 4194304;
            } else {
                i14 = 4194304;
            }
            i8 = i115 | i14;
        } else {
            i8 = i3;
        }
        i9 = i8;
        i10 = i2 & 256;
        if (i10 != 0) {
            i11 = i9 | 100663296;
        } else if ((i & 100663296) == 0) {
            if (composerStartRestartGroup.changed(dialogProperties)) {
                i12 = 67108864;
            } else {
                i12 = 33554432;
            }
            i11 = i9 | i12;
        } else {
            i11 = i9;
        }
        if ((i11 & 38347923) != 38347922) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i11 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "77@6141L6,77@6199L6,77@6241L32");
            if ((i & 1) != 0) {
                if (i15 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i4 != 0) {
                    function6 = null;
                }
                if (i6 != 0) {
                    function7 = null;
                }
                if ((i2 & 32) != 0) {
                    i11 &= -458753;
                    medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                }
                if ((i2 & 64) != 0) {
                    jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                    i11 &= -3670017;
                }
                if ((i2 & 128) != 0) {
                    jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i11 >> 18) & 14);
                    i11 &= -29360129;
                } else {
                    jM2360contentColorForek8zF_U = j2;
                }
                if (i10 != 0) {
                    dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                } else {
                    dialogProperties3 = dialogProperties;
                }
            } else {
                if (i15 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i4 != 0) {
                    function6 = null;
                }
                if (i6 != 0) {
                    function7 = null;
                }
                if ((i2 & 32) != 0) {
                    i11 &= -458753;
                    medium = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getMedium();
                }
                if ((i2 & 64) != 0) {
                    jM2346getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m2346getSurface0d7_KjU();
                    i11 &= -3670017;
                }
                if ((i2 & 128) != 0) {
                    jM2360contentColorForek8zF_U = ColorsKt.m2360contentColorForek8zF_U(jM2346getSurface0d7_KjU, composerStartRestartGroup, (i11 >> 18) & 14);
                    i11 &= -29360129;
                } else {
                    jM2360contentColorForek8zF_U = j2;
                }
                if (i10 != 0) {
                    dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                } else {
                    dialogProperties3 = dialogProperties;
                }
            }
            i13 = i11;
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1409209698, i13, -1, "androidx.compose.material.AlertDialog (AndroidAlertDialog.android.kt:66)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -214309806, "CC(AlertDialogImpl)N(onDismissRequest,buttons,modifier,title,text,shape,backgroundColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,properties)180@7953L276,180@7884L345:AlertDialog.kt#jmzs0o");
            DialogProperties dialogProperties12 = dialogProperties3;
            AndroidDialog_androidKt.Dialog(function0, dialogProperties12, ComposableLambdaKt.rememberComposableLambda(-488319269, true, new AlertDialogKt$AlertDialogImpl$2(function5, modifier2, function6, function7, medium, jM2346getSurface0d7_KjU, jM2360contentColorForek8zF_U), composerStartRestartGroup, 54), composerStartRestartGroup, (i13 & 14) | 384 | (((268435454 & i13) >> 21) & 112), 0);
            composer2 = composerStartRestartGroup;
            ComposerKt.sourceInformationMarkerEnd(composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier2;
            function8 = function7;
            shape2 = medium;
            j3 = jM2360contentColorForek8zF_U;
            dialogProperties2 = dialogProperties12;
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            modifier3 = modifier2;
            function8 = function7;
            shape2 = medium;
            j3 = j2;
            dialogProperties2 = dialogProperties;
        }
        function9 = function6;
        j4 = jM2346getSurface0d7_KjU;
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.AndroidAlertDialog_androidKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AndroidAlertDialog_androidKt.AlertDialog_wqdebIU$lambda$0(function0, function2, modifier3, function9, function8, shape2, j4, j3, dialogProperties2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}
