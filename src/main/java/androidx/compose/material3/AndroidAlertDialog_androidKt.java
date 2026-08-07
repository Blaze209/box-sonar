package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.window.DialogProperties;
import androidx.media3.common.C;
import androidx.profileinstaller.ProfileVerifier;
import com.box.android.domain.metrics.hubs.HubsObservability;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: AndroidAlertDialog.android.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aÜ\u0001\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0015\b\u0002\u0010\b\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0015\b\u0002\u0010\t\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0015\b\u0002\u0010\n\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0015\b\u0002\u0010\u000b\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u000f2\b\b\u0002\u0010\u0012\u001a\u00020\u000f2\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u0016H\u0007¢\u0006\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"AlertDialog", "", "onDismissRequest", "Lkotlin/Function0;", "confirmButton", "Landroidx/compose/runtime/Composable;", "modifier", "Landroidx/compose/ui/Modifier;", "dismissButton", HubsObservability.HUB_ASSET_ICON, "title", "text", "shape", "Landroidx/compose/ui/graphics/Shape;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "iconContentColor", "titleContentColor", "textContentColor", "tonalElevation", "Landroidx/compose/ui/unit/Dp;", "properties", "Landroidx/compose/ui/window/DialogProperties;", "AlertDialog-Oix01E0", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;JJJJFLandroidx/compose/ui/window/DialogProperties;Landroidx/compose/runtime/Composer;III)V", "material3"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class AndroidAlertDialog_androidKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AlertDialog_Oix01E0$lambda$0(Function0 function0, Function2 function2, Modifier modifier, Function2 function3, Function2 function4, Function2 function5, Function2 function6, Shape shape, long j, long j2, long j3, long j4, float f, DialogProperties dialogProperties, int i, int i2, int i3, Composer composer, int i4) {
        m2731AlertDialogOix01E0(function0, function2, modifier, function3, function4, function5, function6, shape, j, j2, j3, j4, f, dialogProperties, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0125  */
    /* JADX WARN: Code duplicated, block: B:104:0x012b  */
    /* JADX WARN: Code duplicated, block: B:106:0x0131  */
    /* JADX WARN: Code duplicated, block: B:109:0x013a  */
    /* JADX WARN: Code duplicated, block: B:111:0x013f  */
    /* JADX WARN: Code duplicated, block: B:114:0x0146  */
    /* JADX WARN: Code duplicated, block: B:116:0x014c  */
    /* JADX WARN: Code duplicated, block: B:119:0x0155  */
    /* JADX WARN: Code duplicated, block: B:121:0x015a  */
    /* JADX WARN: Code duplicated, block: B:124:0x0160  */
    /* JADX WARN: Code duplicated, block: B:125:0x0163  */
    /* JADX WARN: Code duplicated, block: B:127:0x0167  */
    /* JADX WARN: Code duplicated, block: B:129:0x016f  */
    /* JADX WARN: Code duplicated, block: B:130:0x0172  */
    /* JADX WARN: Code duplicated, block: B:135:0x017d  */
    /* JADX WARN: Code duplicated, block: B:136:0x0182  */
    /* JADX WARN: Code duplicated, block: B:138:0x0188  */
    /* JADX WARN: Code duplicated, block: B:141:0x0191  */
    /* JADX WARN: Code duplicated, block: B:146:0x01a2  */
    /* JADX WARN: Code duplicated, block: B:150:0x01ab  */
    /* JADX WARN: Code duplicated, block: B:153:0x01b4  */
    /* JADX WARN: Code duplicated, block: B:155:0x01c6  */
    /* JADX WARN: Code duplicated, block: B:174:0x0209 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:175:0x020b  */
    /* JADX WARN: Code duplicated, block: B:178:0x0213  */
    /* JADX WARN: Code duplicated, block: B:179:0x0215  */
    /* JADX WARN: Code duplicated, block: B:181:0x0219  */
    /* JADX WARN: Code duplicated, block: B:183:0x021c  */
    /* JADX WARN: Code duplicated, block: B:185:0x021f  */
    /* JADX WARN: Code duplicated, block: B:188:0x0227  */
    /* JADX WARN: Code duplicated, block: B:191:0x0234  */
    /* JADX WARN: Code duplicated, block: B:192:0x023d  */
    /* JADX WARN: Code duplicated, block: B:195:0x0243  */
    /* JADX WARN: Code duplicated, block: B:196:0x024f  */
    /* JADX WARN: Code duplicated, block: B:199:0x0255  */
    /* JADX WARN: Code duplicated, block: B:200:0x025e  */
    /* JADX WARN: Code duplicated, block: B:203:0x0264  */
    /* JADX WARN: Code duplicated, block: B:204:0x026e  */
    /* JADX WARN: Code duplicated, block: B:206:0x0271  */
    /* JADX WARN: Code duplicated, block: B:207:0x0278  */
    /* JADX WARN: Code duplicated, block: B:209:0x027c  */
    /* JADX WARN: Code duplicated, block: B:210:0x029b  */
    /* JADX WARN: Code duplicated, block: B:214:0x02c0  */
    /* JADX WARN: Code duplicated, block: B:217:0x02dd  */
    /* JADX WARN: Code duplicated, block: B:219:0x02f1  */
    /* JADX WARN: Code duplicated, block: B:222:0x030e  */
    /* JADX WARN: Code duplicated, block: B:224:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:31:0x0062  */
    /* JADX WARN: Code duplicated, block: B:32:0x0065  */
    /* JADX WARN: Code duplicated, block: B:34:0x0069  */
    /* JADX WARN: Code duplicated, block: B:36:0x0071  */
    /* JADX WARN: Code duplicated, block: B:37:0x0074  */
    /* JADX WARN: Code duplicated, block: B:42:0x007f  */
    /* JADX WARN: Code duplicated, block: B:43:0x0082  */
    /* JADX WARN: Code duplicated, block: B:45:0x0086  */
    /* JADX WARN: Code duplicated, block: B:47:0x008e  */
    /* JADX WARN: Code duplicated, block: B:48:0x0091  */
    /* JADX WARN: Code duplicated, block: B:53:0x009e  */
    /* JADX WARN: Code duplicated, block: B:54:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:56:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:58:0x00af  */
    /* JADX WARN: Code duplicated, block: B:59:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:63:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:64:0x00c1  */
    /* JADX WARN: Code duplicated, block: B:66:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:68:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:69:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:73:0x00da  */
    /* JADX WARN: Code duplicated, block: B:75:0x00de  */
    /* JADX WARN: Code duplicated, block: B:77:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:78:0x00e9  */
    /* JADX WARN: Code duplicated, block: B:81:0x00f0  */
    /* JADX WARN: Code duplicated, block: B:84:0x00f8  */
    /* JADX WARN: Code duplicated, block: B:86:0x00fe  */
    /* JADX WARN: Code duplicated, block: B:89:0x0107  */
    /* JADX WARN: Code duplicated, block: B:91:0x010b  */
    /* JADX WARN: Code duplicated, block: B:94:0x0112  */
    /* JADX WARN: Code duplicated, block: B:96:0x0118  */
    /* JADX WARN: Code duplicated, block: B:99:0x0121  */
    /* JADX INFO: renamed from: AlertDialog-Oix01E0, reason: not valid java name */
    public static final void m2731AlertDialogOix01E0(final Function0<Unit> function0, final Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function3, Function2<? super Composer, ? super Integer, Unit> function4, Function2<? super Composer, ? super Integer, Unit> function5, Function2<? super Composer, ? super Integer, Unit> function6, Shape shape, long j, long j2, long j3, long j4, float f, DialogProperties dialogProperties, Composer composer, final int i, final int i2, final int i3) {
        int i4;
        Modifier modifier2;
        int i5;
        int i6;
        int i7;
        Function2<? super Composer, ? super Integer, Unit> function7;
        int i8;
        int i9;
        Function2<? super Composer, ? super Integer, Unit> function8;
        int i10;
        int i11;
        Function2<? super Composer, ? super Integer, Unit> function9;
        int i12;
        Shape shape2;
        int i13;
        long j5;
        int i14;
        int i15;
        int i16;
        int i17;
        boolean z;
        Composer composer2;
        final Function2<? super Composer, ? super Integer, Unit> function10;
        final float f2;
        final DialogProperties dialogProperties2;
        final Shape shape3;
        final Modifier modifier3;
        final long j6;
        final long j7;
        final Function2<? super Composer, ? super Integer, Unit> function11;
        final Function2<? super Composer, ? super Integer, Unit> function12;
        final Function2<? super Composer, ? super Integer, Unit> function13;
        final long j8;
        final long j9;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Function2<? super Composer, ? super Integer, Unit> function14;
        long containerColor;
        long iconContentColor;
        long titleContentColor;
        long textContentColor;
        float fM2717getTonalElevationD9Ej5fM;
        DialogProperties dialogProperties3;
        Function2<? super Composer, ? super Integer, Unit> function15;
        Function2<? super Composer, ? super Integer, Unit> function16;
        Shape shape4;
        Modifier modifier4;
        int i18;
        Function2<? super Composer, ? super Integer, Unit> function17;
        Function2<? super Composer, ? super Integer, Unit> function18;
        long j10;
        long j11;
        int i19;
        int i20;
        long j12;
        long j13;
        int i21;
        int i22;
        int i23;
        int i24;
        Composer composerStartRestartGroup = composer.startRestartGroup(94478519);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(AlertDialog)N(onDismissRequest,confirmButton,modifier,dismissButton,icon,title,text,shape,containerColor:c#ui.graphics.Color,iconContentColor:c#ui.graphics.Color,titleContentColor:c#ui.graphics.Color,textContentColor:c#ui.graphics.Color,tonalElevation:c#ui.unit.Dp,properties)46@1649L514:AndroidAlertDialog.android.kt#uh7d8r");
        if ((i & 6) == 0) {
            i4 = (composerStartRestartGroup.changedInstance(function0) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        if ((i & 48) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(function2) ? 32 : 16;
        }
        int i25 = i3 & 4;
        if (i25 == 0) {
            if ((i & 384) == 0) {
                modifier2 = modifier;
                i4 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            i5 = i3 & 8;
            if (i5 != 0) {
                if ((i & 3072) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i6 = 2048;
                    } else {
                        i6 = 1024;
                    }
                    i4 |= i6;
                }
                i7 = i3 & 16;
                if (i7 != 0) {
                    if ((i & 24576) == 0) {
                        function7 = function4;
                        if (composerStartRestartGroup.changedInstance(function7)) {
                            i8 = 16384;
                        } else {
                            i8 = 8192;
                        }
                        i4 |= i8;
                    }
                    i9 = i3 & 32;
                    if (i9 != 0) {
                        i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                        function8 = function5;
                    } else {
                        function8 = function5;
                        if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                            if (composerStartRestartGroup.changedInstance(function8)) {
                                i10 = 131072;
                            } else {
                                i10 = 65536;
                            }
                            i4 |= i10;
                        }
                    }
                    i11 = i3 & 64;
                    if (i11 != 0) {
                        i4 |= 1572864;
                        function9 = function6;
                    } else {
                        function9 = function6;
                        if ((i & 1572864) == 0) {
                            if (composerStartRestartGroup.changedInstance(function9)) {
                                i12 = 1048576;
                            } else {
                                i12 = 524288;
                            }
                            i4 |= i12;
                        }
                    }
                    if ((i & 12582912) == 0) {
                        if ((i3 & 128) == 0) {
                            shape2 = shape;
                            int i26 = composerStartRestartGroup.changed(shape2) ? 8388608 : 4194304;
                            i4 |= i26;
                        } else {
                            shape2 = shape;
                        }
                        i4 |= i26;
                    } else {
                        shape2 = shape;
                    }
                    if ((i & 100663296) != 0) {
                        if ((i3 & 256) == 0 || !composerStartRestartGroup.changed(j)) {
                            i24 = 33554432;
                        } else {
                            i24 = 67108864;
                        }
                        i4 |= i24;
                    }
                    if ((805306368 & i) != 0) {
                        if ((i3 & 512) == 0 || !composerStartRestartGroup.changed(j2)) {
                            i23 = 268435456;
                        } else {
                            i23 = C.BUFFER_FLAG_LAST_SAMPLE;
                        }
                        i4 |= i23;
                    }
                    if ((i2 & 6) == 0) {
                        if ((i3 & 1024) == 0 || !composerStartRestartGroup.changed(j3)) {
                            i22 = 2;
                        } else {
                            i22 = 4;
                        }
                        i13 = i2 | i22;
                    } else {
                        i13 = i2;
                    }
                    if ((i2 & 48) == 0) {
                        j5 = j4;
                        if ((i3 & 2048) == 0 || !composerStartRestartGroup.changed(j5)) {
                            i21 = 16;
                        } else {
                            i21 = 32;
                        }
                        i13 |= i21;
                    } else {
                        j5 = j4;
                    }
                    i14 = i3 & 4096;
                    if (i14 != 0) {
                        if ((i2 & 384) == 0) {
                            if (composerStartRestartGroup.changed(f)) {
                                i15 = 256;
                            } else {
                                i15 = 128;
                            }
                            i13 |= i15;
                        }
                        i16 = i3 & 8192;
                        if (i16 != 0) {
                            i17 = i16;
                            if ((i2 & 3072) == 0) {
                                i13 |= composerStartRestartGroup.changed(dialogProperties) ? 2048 : 1024;
                            }
                            if ((i4 & 306783379) == 306783378 || (i13 & 1171) != 1170) {
                                z = true;
                            } else {
                                z = false;
                            }
                            if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
                                composerStartRestartGroup.startDefaults();
                                ComposerKt.sourceInformation(composerStartRestartGroup, "62@4972L5,62@5027L14,62@5093L16,62@5162L17,62@5231L16");
                                if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                    if (i25 != 0) {
                                        modifier2 = Modifier.INSTANCE;
                                    }
                                    if (i5 != 0) {
                                        function14 = null;
                                    } else {
                                        function14 = function3;
                                    }
                                    if (i7 != 0) {
                                        function7 = null;
                                    }
                                    if (i9 != 0) {
                                        function8 = null;
                                    }
                                    if (i11 != 0) {
                                        function9 = null;
                                    }
                                    if ((i3 & 128) != 0) {
                                        i4 &= -29360129;
                                        shape2 = AlertDialogDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                                    }
                                    if ((i3 & 256) != 0) {
                                        containerColor = AlertDialogDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                                        i4 &= -234881025;
                                    } else {
                                        containerColor = j;
                                    }
                                    if ((i3 & 512) != 0) {
                                        iconContentColor = AlertDialogDefaults.INSTANCE.getIconContentColor(composerStartRestartGroup, 6);
                                        i4 = (-1879048193) & i4;
                                    } else {
                                        iconContentColor = j2;
                                    }
                                    if ((i3 & 1024) != 0) {
                                        titleContentColor = AlertDialogDefaults.INSTANCE.getTitleContentColor(composerStartRestartGroup, 6);
                                        i13 &= -15;
                                    } else {
                                        titleContentColor = j3;
                                    }
                                    if ((i3 & 2048) != 0) {
                                        textContentColor = AlertDialogDefaults.INSTANCE.getTextContentColor(composerStartRestartGroup, 6);
                                        i13 &= -113;
                                    } else {
                                        textContentColor = j5;
                                    }
                                    if (i14 != 0) {
                                        fM2717getTonalElevationD9Ej5fM = AlertDialogDefaults.INSTANCE.m2717getTonalElevationD9Ej5fM();
                                    } else {
                                        fM2717getTonalElevationD9Ej5fM = f;
                                    }
                                    if (i17 != 0) {
                                        dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                                    } else {
                                        dialogProperties3 = dialogProperties;
                                    }
                                    function15 = function8;
                                    function16 = function9;
                                    shape4 = shape2;
                                    modifier4 = modifier2;
                                    i18 = 94478519;
                                    int i27 = i4;
                                    function17 = function7;
                                    function18 = function14;
                                    j10 = containerColor;
                                    j11 = titleContentColor;
                                    long j14 = textContentColor;
                                    i19 = i27;
                                    i20 = i13;
                                    j12 = iconContentColor;
                                    j13 = j14;
                                } else {
                                    composerStartRestartGroup.skipToGroupEnd();
                                    if ((i3 & 128) != 0) {
                                        i4 &= -29360129;
                                    }
                                    if ((i3 & 256) != 0) {
                                        i4 &= -234881025;
                                    }
                                    if ((i3 & 512) != 0) {
                                        i4 &= -1879048193;
                                    }
                                    if ((i3 & 1024) != 0) {
                                        i13 &= -15;
                                    }
                                    if ((i3 & 2048) != 0) {
                                        i13 &= -113;
                                    }
                                    j11 = j3;
                                    fM2717getTonalElevationD9Ej5fM = f;
                                    dialogProperties3 = dialogProperties;
                                    j13 = j5;
                                    i19 = i4;
                                    function15 = function8;
                                    function16 = function9;
                                    shape4 = shape2;
                                    i20 = i13;
                                    modifier4 = modifier2;
                                    i18 = 94478519;
                                    j10 = j;
                                    j12 = j2;
                                    function17 = function7;
                                    function18 = function3;
                                }
                                composerStartRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(i18, i19, i20, "androidx.compose.material3.AlertDialog (AndroidAlertDialog.android.kt:46)");
                                }
                                composer2 = composerStartRestartGroup;
                                AlertDialogKt.m2726AlertDialogImplwrnwzgE(function0, function2, modifier4, function18, function17, function15, function16, shape4, j10, j12, j11, j13, fM2717getTonalElevationD9Ej5fM, dialogProperties3, composer2, i19 & 2147483646, i20 & 8190);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                modifier3 = modifier4;
                                function10 = function18;
                                function11 = function17;
                                function12 = function15;
                                function13 = function16;
                                shape3 = shape4;
                                j8 = j10;
                                j9 = j12;
                                j6 = j11;
                                j7 = j13;
                                f2 = fM2717getTonalElevationD9Ej5fM;
                                dialogProperties2 = dialogProperties3;
                            } else {
                                composer2 = composerStartRestartGroup;
                                composer2.skipToGroupEnd();
                                function10 = function3;
                                f2 = f;
                                dialogProperties2 = dialogProperties;
                                shape3 = shape2;
                                modifier3 = modifier2;
                                j6 = j3;
                                j7 = j5;
                                function11 = function7;
                                function12 = function8;
                                function13 = function9;
                                j8 = j;
                                j9 = j2;
                            }
                            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup != null) {
                                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.AndroidAlertDialog_androidKt$$ExternalSyntheticLambda0
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return AndroidAlertDialog_androidKt.AlertDialog_Oix01E0$lambda$0(function0, function2, modifier3, function10, function11, function12, function13, shape3, j8, j9, j6, j7, f2, dialogProperties2, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                                    }
                                });
                            }
                        }
                        i13 |= 3072;
                        i17 = i16;
                        if ((i4 & 306783379) == 306783378) {
                            z = true;
                        } else {
                            z = true;
                        }
                        if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
                            composerStartRestartGroup.startDefaults();
                            ComposerKt.sourceInformation(composerStartRestartGroup, "62@4972L5,62@5027L14,62@5093L16,62@5162L17,62@5231L16");
                            if ((i & 1) != 0) {
                                if (i25 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                if (i5 != 0) {
                                    function14 = null;
                                } else {
                                    function14 = function3;
                                }
                                if (i7 != 0) {
                                    function7 = null;
                                }
                                if (i9 != 0) {
                                    function8 = null;
                                }
                                if (i11 != 0) {
                                    function9 = null;
                                }
                                if ((i3 & 128) != 0) {
                                    i4 &= -29360129;
                                    shape2 = AlertDialogDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                                }
                                if ((i3 & 256) != 0) {
                                    containerColor = AlertDialogDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                                    i4 &= -234881025;
                                } else {
                                    containerColor = j;
                                }
                                if ((i3 & 512) != 0) {
                                    iconContentColor = AlertDialogDefaults.INSTANCE.getIconContentColor(composerStartRestartGroup, 6);
                                    i4 = (-1879048193) & i4;
                                } else {
                                    iconContentColor = j2;
                                }
                                if ((i3 & 1024) != 0) {
                                    titleContentColor = AlertDialogDefaults.INSTANCE.getTitleContentColor(composerStartRestartGroup, 6);
                                    i13 &= -15;
                                } else {
                                    titleContentColor = j3;
                                }
                                if ((i3 & 2048) != 0) {
                                    textContentColor = AlertDialogDefaults.INSTANCE.getTextContentColor(composerStartRestartGroup, 6);
                                    i13 &= -113;
                                } else {
                                    textContentColor = j5;
                                }
                                if (i14 != 0) {
                                    fM2717getTonalElevationD9Ej5fM = AlertDialogDefaults.INSTANCE.m2717getTonalElevationD9Ej5fM();
                                } else {
                                    fM2717getTonalElevationD9Ej5fM = f;
                                }
                                if (i17 != 0) {
                                    dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                                } else {
                                    dialogProperties3 = dialogProperties;
                                }
                                function15 = function8;
                                function16 = function9;
                                shape4 = shape2;
                                modifier4 = modifier2;
                                i18 = 94478519;
                                int i28 = i4;
                                function17 = function7;
                                function18 = function14;
                                j10 = containerColor;
                                j11 = titleContentColor;
                                long j15 = textContentColor;
                                i19 = i28;
                                i20 = i13;
                                j12 = iconContentColor;
                                j13 = j15;
                            } else {
                                if (i25 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                if (i5 != 0) {
                                    function14 = null;
                                } else {
                                    function14 = function3;
                                }
                                if (i7 != 0) {
                                    function7 = null;
                                }
                                if (i9 != 0) {
                                    function8 = null;
                                }
                                if (i11 != 0) {
                                    function9 = null;
                                }
                                if ((i3 & 128) != 0) {
                                    i4 &= -29360129;
                                    shape2 = AlertDialogDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                                }
                                if ((i3 & 256) != 0) {
                                    containerColor = AlertDialogDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                                    i4 &= -234881025;
                                } else {
                                    containerColor = j;
                                }
                                if ((i3 & 512) != 0) {
                                    iconContentColor = AlertDialogDefaults.INSTANCE.getIconContentColor(composerStartRestartGroup, 6);
                                    i4 = (-1879048193) & i4;
                                } else {
                                    iconContentColor = j2;
                                }
                                if ((i3 & 1024) != 0) {
                                    titleContentColor = AlertDialogDefaults.INSTANCE.getTitleContentColor(composerStartRestartGroup, 6);
                                    i13 &= -15;
                                } else {
                                    titleContentColor = j3;
                                }
                                if ((i3 & 2048) != 0) {
                                    textContentColor = AlertDialogDefaults.INSTANCE.getTextContentColor(composerStartRestartGroup, 6);
                                    i13 &= -113;
                                } else {
                                    textContentColor = j5;
                                }
                                if (i14 != 0) {
                                    fM2717getTonalElevationD9Ej5fM = AlertDialogDefaults.INSTANCE.m2717getTonalElevationD9Ej5fM();
                                } else {
                                    fM2717getTonalElevationD9Ej5fM = f;
                                }
                                if (i17 != 0) {
                                    dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                                } else {
                                    dialogProperties3 = dialogProperties;
                                }
                                function15 = function8;
                                function16 = function9;
                                shape4 = shape2;
                                modifier4 = modifier2;
                                i18 = 94478519;
                                int i29 = i4;
                                function17 = function7;
                                function18 = function14;
                                j10 = containerColor;
                                j11 = titleContentColor;
                                long j16 = textContentColor;
                                i19 = i29;
                                i20 = i13;
                                j12 = iconContentColor;
                                j13 = j16;
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(i18, i19, i20, "androidx.compose.material3.AlertDialog (AndroidAlertDialog.android.kt:46)");
                            }
                            composer2 = composerStartRestartGroup;
                            AlertDialogKt.m2726AlertDialogImplwrnwzgE(function0, function2, modifier4, function18, function17, function15, function16, shape4, j10, j12, j11, j13, fM2717getTonalElevationD9Ej5fM, dialogProperties3, composer2, i19 & 2147483646, i20 & 8190);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier3 = modifier4;
                            function10 = function18;
                            function11 = function17;
                            function12 = function15;
                            function13 = function16;
                            shape3 = shape4;
                            j8 = j10;
                            j9 = j12;
                            j6 = j11;
                            j7 = j13;
                            f2 = fM2717getTonalElevationD9Ej5fM;
                            dialogProperties2 = dialogProperties3;
                        } else {
                            composer2 = composerStartRestartGroup;
                            composer2.skipToGroupEnd();
                            function10 = function3;
                            f2 = f;
                            dialogProperties2 = dialogProperties;
                            shape3 = shape2;
                            modifier3 = modifier2;
                            j6 = j3;
                            j7 = j5;
                            function11 = function7;
                            function12 = function8;
                            function13 = function9;
                            j8 = j;
                            j9 = j2;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.AndroidAlertDialog_androidKt$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return AndroidAlertDialog_androidKt.AlertDialog_Oix01E0$lambda$0(function0, function2, modifier3, function10, function11, function12, function13, shape3, j8, j9, j6, j7, f2, dialogProperties2, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                        }
                    }
                    i13 |= 384;
                    i16 = i3 & 8192;
                    if (i16 != 0) {
                        i17 = i16;
                        if ((i2 & 3072) == 0) {
                            i13 |= composerStartRestartGroup.changed(dialogProperties) ? 2048 : 1024;
                        }
                        if ((i4 & 306783379) == 306783378) {
                            z = true;
                        } else {
                            z = true;
                        }
                        if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
                            composerStartRestartGroup.startDefaults();
                            ComposerKt.sourceInformation(composerStartRestartGroup, "62@4972L5,62@5027L14,62@5093L16,62@5162L17,62@5231L16");
                            if ((i & 1) != 0) {
                                if (i25 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                if (i5 != 0) {
                                    function14 = null;
                                } else {
                                    function14 = function3;
                                }
                                if (i7 != 0) {
                                    function7 = null;
                                }
                                if (i9 != 0) {
                                    function8 = null;
                                }
                                if (i11 != 0) {
                                    function9 = null;
                                }
                                if ((i3 & 128) != 0) {
                                    i4 &= -29360129;
                                    shape2 = AlertDialogDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                                }
                                if ((i3 & 256) != 0) {
                                    containerColor = AlertDialogDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                                    i4 &= -234881025;
                                } else {
                                    containerColor = j;
                                }
                                if ((i3 & 512) != 0) {
                                    iconContentColor = AlertDialogDefaults.INSTANCE.getIconContentColor(composerStartRestartGroup, 6);
                                    i4 = (-1879048193) & i4;
                                } else {
                                    iconContentColor = j2;
                                }
                                if ((i3 & 1024) != 0) {
                                    titleContentColor = AlertDialogDefaults.INSTANCE.getTitleContentColor(composerStartRestartGroup, 6);
                                    i13 &= -15;
                                } else {
                                    titleContentColor = j3;
                                }
                                if ((i3 & 2048) != 0) {
                                    textContentColor = AlertDialogDefaults.INSTANCE.getTextContentColor(composerStartRestartGroup, 6);
                                    i13 &= -113;
                                } else {
                                    textContentColor = j5;
                                }
                                if (i14 != 0) {
                                    fM2717getTonalElevationD9Ej5fM = AlertDialogDefaults.INSTANCE.m2717getTonalElevationD9Ej5fM();
                                } else {
                                    fM2717getTonalElevationD9Ej5fM = f;
                                }
                                if (i17 != 0) {
                                    dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                                } else {
                                    dialogProperties3 = dialogProperties;
                                }
                                function15 = function8;
                                function16 = function9;
                                shape4 = shape2;
                                modifier4 = modifier2;
                                i18 = 94478519;
                                int i210 = i4;
                                function17 = function7;
                                function18 = function14;
                                j10 = containerColor;
                                j11 = titleContentColor;
                                long j17 = textContentColor;
                                i19 = i210;
                                i20 = i13;
                                j12 = iconContentColor;
                                j13 = j17;
                            } else {
                                if (i25 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                if (i5 != 0) {
                                    function14 = null;
                                } else {
                                    function14 = function3;
                                }
                                if (i7 != 0) {
                                    function7 = null;
                                }
                                if (i9 != 0) {
                                    function8 = null;
                                }
                                if (i11 != 0) {
                                    function9 = null;
                                }
                                if ((i3 & 128) != 0) {
                                    i4 &= -29360129;
                                    shape2 = AlertDialogDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                                }
                                if ((i3 & 256) != 0) {
                                    containerColor = AlertDialogDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                                    i4 &= -234881025;
                                } else {
                                    containerColor = j;
                                }
                                if ((i3 & 512) != 0) {
                                    iconContentColor = AlertDialogDefaults.INSTANCE.getIconContentColor(composerStartRestartGroup, 6);
                                    i4 = (-1879048193) & i4;
                                } else {
                                    iconContentColor = j2;
                                }
                                if ((i3 & 1024) != 0) {
                                    titleContentColor = AlertDialogDefaults.INSTANCE.getTitleContentColor(composerStartRestartGroup, 6);
                                    i13 &= -15;
                                } else {
                                    titleContentColor = j3;
                                }
                                if ((i3 & 2048) != 0) {
                                    textContentColor = AlertDialogDefaults.INSTANCE.getTextContentColor(composerStartRestartGroup, 6);
                                    i13 &= -113;
                                } else {
                                    textContentColor = j5;
                                }
                                if (i14 != 0) {
                                    fM2717getTonalElevationD9Ej5fM = AlertDialogDefaults.INSTANCE.m2717getTonalElevationD9Ej5fM();
                                } else {
                                    fM2717getTonalElevationD9Ej5fM = f;
                                }
                                if (i17 != 0) {
                                    dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                                } else {
                                    dialogProperties3 = dialogProperties;
                                }
                                function15 = function8;
                                function16 = function9;
                                shape4 = shape2;
                                modifier4 = modifier2;
                                i18 = 94478519;
                                int i211 = i4;
                                function17 = function7;
                                function18 = function14;
                                j10 = containerColor;
                                j11 = titleContentColor;
                                long j18 = textContentColor;
                                i19 = i211;
                                i20 = i13;
                                j12 = iconContentColor;
                                j13 = j18;
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(i18, i19, i20, "androidx.compose.material3.AlertDialog (AndroidAlertDialog.android.kt:46)");
                            }
                            composer2 = composerStartRestartGroup;
                            AlertDialogKt.m2726AlertDialogImplwrnwzgE(function0, function2, modifier4, function18, function17, function15, function16, shape4, j10, j12, j11, j13, fM2717getTonalElevationD9Ej5fM, dialogProperties3, composer2, i19 & 2147483646, i20 & 8190);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier3 = modifier4;
                            function10 = function18;
                            function11 = function17;
                            function12 = function15;
                            function13 = function16;
                            shape3 = shape4;
                            j8 = j10;
                            j9 = j12;
                            j6 = j11;
                            j7 = j13;
                            f2 = fM2717getTonalElevationD9Ej5fM;
                            dialogProperties2 = dialogProperties3;
                        } else {
                            composer2 = composerStartRestartGroup;
                            composer2.skipToGroupEnd();
                            function10 = function3;
                            f2 = f;
                            dialogProperties2 = dialogProperties;
                            shape3 = shape2;
                            modifier3 = modifier2;
                            j6 = j3;
                            j7 = j5;
                            function11 = function7;
                            function12 = function8;
                            function13 = function9;
                            j8 = j;
                            j9 = j2;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.AndroidAlertDialog_androidKt$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return AndroidAlertDialog_androidKt.AlertDialog_Oix01E0$lambda$0(function0, function2, modifier3, function10, function11, function12, function13, shape3, j8, j9, j6, j7, f2, dialogProperties2, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                        }
                    }
                    i13 |= 3072;
                    i17 = i16;
                    if ((i4 & 306783379) == 306783378) {
                        z = true;
                    } else {
                        z = true;
                    }
                    if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "62@4972L5,62@5027L14,62@5093L16,62@5162L17,62@5231L16");
                        if ((i & 1) != 0) {
                            if (i25 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i5 != 0) {
                                function14 = null;
                            } else {
                                function14 = function3;
                            }
                            if (i7 != 0) {
                                function7 = null;
                            }
                            if (i9 != 0) {
                                function8 = null;
                            }
                            if (i11 != 0) {
                                function9 = null;
                            }
                            if ((i3 & 128) != 0) {
                                i4 &= -29360129;
                                shape2 = AlertDialogDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                            }
                            if ((i3 & 256) != 0) {
                                containerColor = AlertDialogDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                                i4 &= -234881025;
                            } else {
                                containerColor = j;
                            }
                            if ((i3 & 512) != 0) {
                                iconContentColor = AlertDialogDefaults.INSTANCE.getIconContentColor(composerStartRestartGroup, 6);
                                i4 = (-1879048193) & i4;
                            } else {
                                iconContentColor = j2;
                            }
                            if ((i3 & 1024) != 0) {
                                titleContentColor = AlertDialogDefaults.INSTANCE.getTitleContentColor(composerStartRestartGroup, 6);
                                i13 &= -15;
                            } else {
                                titleContentColor = j3;
                            }
                            if ((i3 & 2048) != 0) {
                                textContentColor = AlertDialogDefaults.INSTANCE.getTextContentColor(composerStartRestartGroup, 6);
                                i13 &= -113;
                            } else {
                                textContentColor = j5;
                            }
                            if (i14 != 0) {
                                fM2717getTonalElevationD9Ej5fM = AlertDialogDefaults.INSTANCE.m2717getTonalElevationD9Ej5fM();
                            } else {
                                fM2717getTonalElevationD9Ej5fM = f;
                            }
                            if (i17 != 0) {
                                dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                            } else {
                                dialogProperties3 = dialogProperties;
                            }
                            function15 = function8;
                            function16 = function9;
                            shape4 = shape2;
                            modifier4 = modifier2;
                            i18 = 94478519;
                            int i212 = i4;
                            function17 = function7;
                            function18 = function14;
                            j10 = containerColor;
                            j11 = titleContentColor;
                            long j19 = textContentColor;
                            i19 = i212;
                            i20 = i13;
                            j12 = iconContentColor;
                            j13 = j19;
                        } else {
                            if (i25 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i5 != 0) {
                                function14 = null;
                            } else {
                                function14 = function3;
                            }
                            if (i7 != 0) {
                                function7 = null;
                            }
                            if (i9 != 0) {
                                function8 = null;
                            }
                            if (i11 != 0) {
                                function9 = null;
                            }
                            if ((i3 & 128) != 0) {
                                i4 &= -29360129;
                                shape2 = AlertDialogDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                            }
                            if ((i3 & 256) != 0) {
                                containerColor = AlertDialogDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                                i4 &= -234881025;
                            } else {
                                containerColor = j;
                            }
                            if ((i3 & 512) != 0) {
                                iconContentColor = AlertDialogDefaults.INSTANCE.getIconContentColor(composerStartRestartGroup, 6);
                                i4 = (-1879048193) & i4;
                            } else {
                                iconContentColor = j2;
                            }
                            if ((i3 & 1024) != 0) {
                                titleContentColor = AlertDialogDefaults.INSTANCE.getTitleContentColor(composerStartRestartGroup, 6);
                                i13 &= -15;
                            } else {
                                titleContentColor = j3;
                            }
                            if ((i3 & 2048) != 0) {
                                textContentColor = AlertDialogDefaults.INSTANCE.getTextContentColor(composerStartRestartGroup, 6);
                                i13 &= -113;
                            } else {
                                textContentColor = j5;
                            }
                            if (i14 != 0) {
                                fM2717getTonalElevationD9Ej5fM = AlertDialogDefaults.INSTANCE.m2717getTonalElevationD9Ej5fM();
                            } else {
                                fM2717getTonalElevationD9Ej5fM = f;
                            }
                            if (i17 != 0) {
                                dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                            } else {
                                dialogProperties3 = dialogProperties;
                            }
                            function15 = function8;
                            function16 = function9;
                            shape4 = shape2;
                            modifier4 = modifier2;
                            i18 = 94478519;
                            int i213 = i4;
                            function17 = function7;
                            function18 = function14;
                            j10 = containerColor;
                            j11 = titleContentColor;
                            long j110 = textContentColor;
                            i19 = i213;
                            i20 = i13;
                            j12 = iconContentColor;
                            j13 = j110;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(i18, i19, i20, "androidx.compose.material3.AlertDialog (AndroidAlertDialog.android.kt:46)");
                        }
                        composer2 = composerStartRestartGroup;
                        AlertDialogKt.m2726AlertDialogImplwrnwzgE(function0, function2, modifier4, function18, function17, function15, function16, shape4, j10, j12, j11, j13, fM2717getTonalElevationD9Ej5fM, dialogProperties3, composer2, i19 & 2147483646, i20 & 8190);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier4;
                        function10 = function18;
                        function11 = function17;
                        function12 = function15;
                        function13 = function16;
                        shape3 = shape4;
                        j8 = j10;
                        j9 = j12;
                        j6 = j11;
                        j7 = j13;
                        f2 = fM2717getTonalElevationD9Ej5fM;
                        dialogProperties2 = dialogProperties3;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        function10 = function3;
                        f2 = f;
                        dialogProperties2 = dialogProperties;
                        shape3 = shape2;
                        modifier3 = modifier2;
                        j6 = j3;
                        j7 = j5;
                        function11 = function7;
                        function12 = function8;
                        function13 = function9;
                        j8 = j;
                        j9 = j2;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.AndroidAlertDialog_androidKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return AndroidAlertDialog_androidKt.AlertDialog_Oix01E0$lambda$0(function0, function2, modifier3, function10, function11, function12, function13, shape3, j8, j9, j6, j7, f2, dialogProperties2, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i4 |= 24576;
                function7 = function4;
                i9 = i3 & 32;
                if (i9 != 0) {
                    i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    function8 = function5;
                } else {
                    function8 = function5;
                    if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                        if (composerStartRestartGroup.changedInstance(function8)) {
                            i10 = 131072;
                        } else {
                            i10 = 65536;
                        }
                        i4 |= i10;
                    }
                }
                i11 = i3 & 64;
                if (i11 != 0) {
                    i4 |= 1572864;
                    function9 = function6;
                } else {
                    function9 = function6;
                    if ((i & 1572864) == 0) {
                        if (composerStartRestartGroup.changedInstance(function9)) {
                            i12 = 1048576;
                        } else {
                            i12 = 524288;
                        }
                        i4 |= i12;
                    }
                }
                if ((i & 12582912) == 0) {
                    if ((i3 & 128) == 0) {
                        shape2 = shape;
                        if (composerStartRestartGroup.changed(shape2)) {
                        }
                        i4 |= i26;
                    } else {
                        shape2 = shape;
                    }
                    i4 |= i26;
                } else {
                    shape2 = shape;
                }
                if ((i & 100663296) != 0) {
                    if ((i3 & 256) == 0) {
                        i24 = 33554432;
                    } else {
                        i24 = 33554432;
                    }
                    i4 |= i24;
                }
                if ((805306368 & i) != 0) {
                    if ((i3 & 512) == 0) {
                        i23 = 268435456;
                    } else {
                        i23 = 268435456;
                    }
                    i4 |= i23;
                }
                if ((i2 & 6) == 0) {
                    if ((i3 & 1024) == 0) {
                        i22 = 2;
                    } else {
                        i22 = 2;
                    }
                    i13 = i2 | i22;
                } else {
                    i13 = i2;
                }
                if ((i2 & 48) == 0) {
                    j5 = j4;
                    if ((i3 & 2048) == 0) {
                        i21 = 16;
                    } else {
                        i21 = 16;
                    }
                    i13 |= i21;
                } else {
                    j5 = j4;
                }
                i14 = i3 & 4096;
                if (i14 != 0) {
                    if ((i2 & 384) == 0) {
                        if (composerStartRestartGroup.changed(f)) {
                            i15 = 256;
                        } else {
                            i15 = 128;
                        }
                        i13 |= i15;
                    }
                    i16 = i3 & 8192;
                    if (i16 != 0) {
                        i17 = i16;
                        if ((i2 & 3072) == 0) {
                            i13 |= composerStartRestartGroup.changed(dialogProperties) ? 2048 : 1024;
                        }
                        if ((i4 & 306783379) == 306783378) {
                            z = true;
                        } else {
                            z = true;
                        }
                        if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
                            composerStartRestartGroup.startDefaults();
                            ComposerKt.sourceInformation(composerStartRestartGroup, "62@4972L5,62@5027L14,62@5093L16,62@5162L17,62@5231L16");
                            if ((i & 1) != 0) {
                                if (i25 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                if (i5 != 0) {
                                    function14 = null;
                                } else {
                                    function14 = function3;
                                }
                                if (i7 != 0) {
                                    function7 = null;
                                }
                                if (i9 != 0) {
                                    function8 = null;
                                }
                                if (i11 != 0) {
                                    function9 = null;
                                }
                                if ((i3 & 128) != 0) {
                                    i4 &= -29360129;
                                    shape2 = AlertDialogDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                                }
                                if ((i3 & 256) != 0) {
                                    containerColor = AlertDialogDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                                    i4 &= -234881025;
                                } else {
                                    containerColor = j;
                                }
                                if ((i3 & 512) != 0) {
                                    iconContentColor = AlertDialogDefaults.INSTANCE.getIconContentColor(composerStartRestartGroup, 6);
                                    i4 = (-1879048193) & i4;
                                } else {
                                    iconContentColor = j2;
                                }
                                if ((i3 & 1024) != 0) {
                                    titleContentColor = AlertDialogDefaults.INSTANCE.getTitleContentColor(composerStartRestartGroup, 6);
                                    i13 &= -15;
                                } else {
                                    titleContentColor = j3;
                                }
                                if ((i3 & 2048) != 0) {
                                    textContentColor = AlertDialogDefaults.INSTANCE.getTextContentColor(composerStartRestartGroup, 6);
                                    i13 &= -113;
                                } else {
                                    textContentColor = j5;
                                }
                                if (i14 != 0) {
                                    fM2717getTonalElevationD9Ej5fM = AlertDialogDefaults.INSTANCE.m2717getTonalElevationD9Ej5fM();
                                } else {
                                    fM2717getTonalElevationD9Ej5fM = f;
                                }
                                if (i17 != 0) {
                                    dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                                } else {
                                    dialogProperties3 = dialogProperties;
                                }
                                function15 = function8;
                                function16 = function9;
                                shape4 = shape2;
                                modifier4 = modifier2;
                                i18 = 94478519;
                                int i214 = i4;
                                function17 = function7;
                                function18 = function14;
                                j10 = containerColor;
                                j11 = titleContentColor;
                                long j111 = textContentColor;
                                i19 = i214;
                                i20 = i13;
                                j12 = iconContentColor;
                                j13 = j111;
                            } else {
                                if (i25 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                if (i5 != 0) {
                                    function14 = null;
                                } else {
                                    function14 = function3;
                                }
                                if (i7 != 0) {
                                    function7 = null;
                                }
                                if (i9 != 0) {
                                    function8 = null;
                                }
                                if (i11 != 0) {
                                    function9 = null;
                                }
                                if ((i3 & 128) != 0) {
                                    i4 &= -29360129;
                                    shape2 = AlertDialogDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                                }
                                if ((i3 & 256) != 0) {
                                    containerColor = AlertDialogDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                                    i4 &= -234881025;
                                } else {
                                    containerColor = j;
                                }
                                if ((i3 & 512) != 0) {
                                    iconContentColor = AlertDialogDefaults.INSTANCE.getIconContentColor(composerStartRestartGroup, 6);
                                    i4 = (-1879048193) & i4;
                                } else {
                                    iconContentColor = j2;
                                }
                                if ((i3 & 1024) != 0) {
                                    titleContentColor = AlertDialogDefaults.INSTANCE.getTitleContentColor(composerStartRestartGroup, 6);
                                    i13 &= -15;
                                } else {
                                    titleContentColor = j3;
                                }
                                if ((i3 & 2048) != 0) {
                                    textContentColor = AlertDialogDefaults.INSTANCE.getTextContentColor(composerStartRestartGroup, 6);
                                    i13 &= -113;
                                } else {
                                    textContentColor = j5;
                                }
                                if (i14 != 0) {
                                    fM2717getTonalElevationD9Ej5fM = AlertDialogDefaults.INSTANCE.m2717getTonalElevationD9Ej5fM();
                                } else {
                                    fM2717getTonalElevationD9Ej5fM = f;
                                }
                                if (i17 != 0) {
                                    dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                                } else {
                                    dialogProperties3 = dialogProperties;
                                }
                                function15 = function8;
                                function16 = function9;
                                shape4 = shape2;
                                modifier4 = modifier2;
                                i18 = 94478519;
                                int i215 = i4;
                                function17 = function7;
                                function18 = function14;
                                j10 = containerColor;
                                j11 = titleContentColor;
                                long j112 = textContentColor;
                                i19 = i215;
                                i20 = i13;
                                j12 = iconContentColor;
                                j13 = j112;
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(i18, i19, i20, "androidx.compose.material3.AlertDialog (AndroidAlertDialog.android.kt:46)");
                            }
                            composer2 = composerStartRestartGroup;
                            AlertDialogKt.m2726AlertDialogImplwrnwzgE(function0, function2, modifier4, function18, function17, function15, function16, shape4, j10, j12, j11, j13, fM2717getTonalElevationD9Ej5fM, dialogProperties3, composer2, i19 & 2147483646, i20 & 8190);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier3 = modifier4;
                            function10 = function18;
                            function11 = function17;
                            function12 = function15;
                            function13 = function16;
                            shape3 = shape4;
                            j8 = j10;
                            j9 = j12;
                            j6 = j11;
                            j7 = j13;
                            f2 = fM2717getTonalElevationD9Ej5fM;
                            dialogProperties2 = dialogProperties3;
                        } else {
                            composer2 = composerStartRestartGroup;
                            composer2.skipToGroupEnd();
                            function10 = function3;
                            f2 = f;
                            dialogProperties2 = dialogProperties;
                            shape3 = shape2;
                            modifier3 = modifier2;
                            j6 = j3;
                            j7 = j5;
                            function11 = function7;
                            function12 = function8;
                            function13 = function9;
                            j8 = j;
                            j9 = j2;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.AndroidAlertDialog_androidKt$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return AndroidAlertDialog_androidKt.AlertDialog_Oix01E0$lambda$0(function0, function2, modifier3, function10, function11, function12, function13, shape3, j8, j9, j6, j7, f2, dialogProperties2, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                        }
                    }
                    i13 |= 3072;
                    i17 = i16;
                    if ((i4 & 306783379) == 306783378) {
                        z = true;
                    } else {
                        z = true;
                    }
                    if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "62@4972L5,62@5027L14,62@5093L16,62@5162L17,62@5231L16");
                        if ((i & 1) != 0) {
                            if (i25 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i5 != 0) {
                                function14 = null;
                            } else {
                                function14 = function3;
                            }
                            if (i7 != 0) {
                                function7 = null;
                            }
                            if (i9 != 0) {
                                function8 = null;
                            }
                            if (i11 != 0) {
                                function9 = null;
                            }
                            if ((i3 & 128) != 0) {
                                i4 &= -29360129;
                                shape2 = AlertDialogDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                            }
                            if ((i3 & 256) != 0) {
                                containerColor = AlertDialogDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                                i4 &= -234881025;
                            } else {
                                containerColor = j;
                            }
                            if ((i3 & 512) != 0) {
                                iconContentColor = AlertDialogDefaults.INSTANCE.getIconContentColor(composerStartRestartGroup, 6);
                                i4 = (-1879048193) & i4;
                            } else {
                                iconContentColor = j2;
                            }
                            if ((i3 & 1024) != 0) {
                                titleContentColor = AlertDialogDefaults.INSTANCE.getTitleContentColor(composerStartRestartGroup, 6);
                                i13 &= -15;
                            } else {
                                titleContentColor = j3;
                            }
                            if ((i3 & 2048) != 0) {
                                textContentColor = AlertDialogDefaults.INSTANCE.getTextContentColor(composerStartRestartGroup, 6);
                                i13 &= -113;
                            } else {
                                textContentColor = j5;
                            }
                            if (i14 != 0) {
                                fM2717getTonalElevationD9Ej5fM = AlertDialogDefaults.INSTANCE.m2717getTonalElevationD9Ej5fM();
                            } else {
                                fM2717getTonalElevationD9Ej5fM = f;
                            }
                            if (i17 != 0) {
                                dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                            } else {
                                dialogProperties3 = dialogProperties;
                            }
                            function15 = function8;
                            function16 = function9;
                            shape4 = shape2;
                            modifier4 = modifier2;
                            i18 = 94478519;
                            int i216 = i4;
                            function17 = function7;
                            function18 = function14;
                            j10 = containerColor;
                            j11 = titleContentColor;
                            long j113 = textContentColor;
                            i19 = i216;
                            i20 = i13;
                            j12 = iconContentColor;
                            j13 = j113;
                        } else {
                            if (i25 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i5 != 0) {
                                function14 = null;
                            } else {
                                function14 = function3;
                            }
                            if (i7 != 0) {
                                function7 = null;
                            }
                            if (i9 != 0) {
                                function8 = null;
                            }
                            if (i11 != 0) {
                                function9 = null;
                            }
                            if ((i3 & 128) != 0) {
                                i4 &= -29360129;
                                shape2 = AlertDialogDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                            }
                            if ((i3 & 256) != 0) {
                                containerColor = AlertDialogDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                                i4 &= -234881025;
                            } else {
                                containerColor = j;
                            }
                            if ((i3 & 512) != 0) {
                                iconContentColor = AlertDialogDefaults.INSTANCE.getIconContentColor(composerStartRestartGroup, 6);
                                i4 = (-1879048193) & i4;
                            } else {
                                iconContentColor = j2;
                            }
                            if ((i3 & 1024) != 0) {
                                titleContentColor = AlertDialogDefaults.INSTANCE.getTitleContentColor(composerStartRestartGroup, 6);
                                i13 &= -15;
                            } else {
                                titleContentColor = j3;
                            }
                            if ((i3 & 2048) != 0) {
                                textContentColor = AlertDialogDefaults.INSTANCE.getTextContentColor(composerStartRestartGroup, 6);
                                i13 &= -113;
                            } else {
                                textContentColor = j5;
                            }
                            if (i14 != 0) {
                                fM2717getTonalElevationD9Ej5fM = AlertDialogDefaults.INSTANCE.m2717getTonalElevationD9Ej5fM();
                            } else {
                                fM2717getTonalElevationD9Ej5fM = f;
                            }
                            if (i17 != 0) {
                                dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                            } else {
                                dialogProperties3 = dialogProperties;
                            }
                            function15 = function8;
                            function16 = function9;
                            shape4 = shape2;
                            modifier4 = modifier2;
                            i18 = 94478519;
                            int i217 = i4;
                            function17 = function7;
                            function18 = function14;
                            j10 = containerColor;
                            j11 = titleContentColor;
                            long j114 = textContentColor;
                            i19 = i217;
                            i20 = i13;
                            j12 = iconContentColor;
                            j13 = j114;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(i18, i19, i20, "androidx.compose.material3.AlertDialog (AndroidAlertDialog.android.kt:46)");
                        }
                        composer2 = composerStartRestartGroup;
                        AlertDialogKt.m2726AlertDialogImplwrnwzgE(function0, function2, modifier4, function18, function17, function15, function16, shape4, j10, j12, j11, j13, fM2717getTonalElevationD9Ej5fM, dialogProperties3, composer2, i19 & 2147483646, i20 & 8190);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier4;
                        function10 = function18;
                        function11 = function17;
                        function12 = function15;
                        function13 = function16;
                        shape3 = shape4;
                        j8 = j10;
                        j9 = j12;
                        j6 = j11;
                        j7 = j13;
                        f2 = fM2717getTonalElevationD9Ej5fM;
                        dialogProperties2 = dialogProperties3;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        function10 = function3;
                        f2 = f;
                        dialogProperties2 = dialogProperties;
                        shape3 = shape2;
                        modifier3 = modifier2;
                        j6 = j3;
                        j7 = j5;
                        function11 = function7;
                        function12 = function8;
                        function13 = function9;
                        j8 = j;
                        j9 = j2;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.AndroidAlertDialog_androidKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return AndroidAlertDialog_androidKt.AlertDialog_Oix01E0$lambda$0(function0, function2, modifier3, function10, function11, function12, function13, shape3, j8, j9, j6, j7, f2, dialogProperties2, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i13 |= 384;
                i16 = i3 & 8192;
                if (i16 != 0) {
                    i17 = i16;
                    if ((i2 & 3072) == 0) {
                        i13 |= composerStartRestartGroup.changed(dialogProperties) ? 2048 : 1024;
                    }
                    if ((i4 & 306783379) == 306783378) {
                        z = true;
                    } else {
                        z = true;
                    }
                    if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "62@4972L5,62@5027L14,62@5093L16,62@5162L17,62@5231L16");
                        if ((i & 1) != 0) {
                            if (i25 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i5 != 0) {
                                function14 = null;
                            } else {
                                function14 = function3;
                            }
                            if (i7 != 0) {
                                function7 = null;
                            }
                            if (i9 != 0) {
                                function8 = null;
                            }
                            if (i11 != 0) {
                                function9 = null;
                            }
                            if ((i3 & 128) != 0) {
                                i4 &= -29360129;
                                shape2 = AlertDialogDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                            }
                            if ((i3 & 256) != 0) {
                                containerColor = AlertDialogDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                                i4 &= -234881025;
                            } else {
                                containerColor = j;
                            }
                            if ((i3 & 512) != 0) {
                                iconContentColor = AlertDialogDefaults.INSTANCE.getIconContentColor(composerStartRestartGroup, 6);
                                i4 = (-1879048193) & i4;
                            } else {
                                iconContentColor = j2;
                            }
                            if ((i3 & 1024) != 0) {
                                titleContentColor = AlertDialogDefaults.INSTANCE.getTitleContentColor(composerStartRestartGroup, 6);
                                i13 &= -15;
                            } else {
                                titleContentColor = j3;
                            }
                            if ((i3 & 2048) != 0) {
                                textContentColor = AlertDialogDefaults.INSTANCE.getTextContentColor(composerStartRestartGroup, 6);
                                i13 &= -113;
                            } else {
                                textContentColor = j5;
                            }
                            if (i14 != 0) {
                                fM2717getTonalElevationD9Ej5fM = AlertDialogDefaults.INSTANCE.m2717getTonalElevationD9Ej5fM();
                            } else {
                                fM2717getTonalElevationD9Ej5fM = f;
                            }
                            if (i17 != 0) {
                                dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                            } else {
                                dialogProperties3 = dialogProperties;
                            }
                            function15 = function8;
                            function16 = function9;
                            shape4 = shape2;
                            modifier4 = modifier2;
                            i18 = 94478519;
                            int i218 = i4;
                            function17 = function7;
                            function18 = function14;
                            j10 = containerColor;
                            j11 = titleContentColor;
                            long j115 = textContentColor;
                            i19 = i218;
                            i20 = i13;
                            j12 = iconContentColor;
                            j13 = j115;
                        } else {
                            if (i25 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i5 != 0) {
                                function14 = null;
                            } else {
                                function14 = function3;
                            }
                            if (i7 != 0) {
                                function7 = null;
                            }
                            if (i9 != 0) {
                                function8 = null;
                            }
                            if (i11 != 0) {
                                function9 = null;
                            }
                            if ((i3 & 128) != 0) {
                                i4 &= -29360129;
                                shape2 = AlertDialogDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                            }
                            if ((i3 & 256) != 0) {
                                containerColor = AlertDialogDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                                i4 &= -234881025;
                            } else {
                                containerColor = j;
                            }
                            if ((i3 & 512) != 0) {
                                iconContentColor = AlertDialogDefaults.INSTANCE.getIconContentColor(composerStartRestartGroup, 6);
                                i4 = (-1879048193) & i4;
                            } else {
                                iconContentColor = j2;
                            }
                            if ((i3 & 1024) != 0) {
                                titleContentColor = AlertDialogDefaults.INSTANCE.getTitleContentColor(composerStartRestartGroup, 6);
                                i13 &= -15;
                            } else {
                                titleContentColor = j3;
                            }
                            if ((i3 & 2048) != 0) {
                                textContentColor = AlertDialogDefaults.INSTANCE.getTextContentColor(composerStartRestartGroup, 6);
                                i13 &= -113;
                            } else {
                                textContentColor = j5;
                            }
                            if (i14 != 0) {
                                fM2717getTonalElevationD9Ej5fM = AlertDialogDefaults.INSTANCE.m2717getTonalElevationD9Ej5fM();
                            } else {
                                fM2717getTonalElevationD9Ej5fM = f;
                            }
                            if (i17 != 0) {
                                dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                            } else {
                                dialogProperties3 = dialogProperties;
                            }
                            function15 = function8;
                            function16 = function9;
                            shape4 = shape2;
                            modifier4 = modifier2;
                            i18 = 94478519;
                            int i219 = i4;
                            function17 = function7;
                            function18 = function14;
                            j10 = containerColor;
                            j11 = titleContentColor;
                            long j116 = textContentColor;
                            i19 = i219;
                            i20 = i13;
                            j12 = iconContentColor;
                            j13 = j116;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(i18, i19, i20, "androidx.compose.material3.AlertDialog (AndroidAlertDialog.android.kt:46)");
                        }
                        composer2 = composerStartRestartGroup;
                        AlertDialogKt.m2726AlertDialogImplwrnwzgE(function0, function2, modifier4, function18, function17, function15, function16, shape4, j10, j12, j11, j13, fM2717getTonalElevationD9Ej5fM, dialogProperties3, composer2, i19 & 2147483646, i20 & 8190);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier4;
                        function10 = function18;
                        function11 = function17;
                        function12 = function15;
                        function13 = function16;
                        shape3 = shape4;
                        j8 = j10;
                        j9 = j12;
                        j6 = j11;
                        j7 = j13;
                        f2 = fM2717getTonalElevationD9Ej5fM;
                        dialogProperties2 = dialogProperties3;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        function10 = function3;
                        f2 = f;
                        dialogProperties2 = dialogProperties;
                        shape3 = shape2;
                        modifier3 = modifier2;
                        j6 = j3;
                        j7 = j5;
                        function11 = function7;
                        function12 = function8;
                        function13 = function9;
                        j8 = j;
                        j9 = j2;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.AndroidAlertDialog_androidKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return AndroidAlertDialog_androidKt.AlertDialog_Oix01E0$lambda$0(function0, function2, modifier3, function10, function11, function12, function13, shape3, j8, j9, j6, j7, f2, dialogProperties2, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i13 |= 3072;
                i17 = i16;
                if ((i4 & 306783379) == 306783378) {
                    z = true;
                } else {
                    z = true;
                }
                if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "62@4972L5,62@5027L14,62@5093L16,62@5162L17,62@5231L16");
                    if ((i & 1) != 0) {
                        if (i25 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i5 != 0) {
                            function14 = null;
                        } else {
                            function14 = function3;
                        }
                        if (i7 != 0) {
                            function7 = null;
                        }
                        if (i9 != 0) {
                            function8 = null;
                        }
                        if (i11 != 0) {
                            function9 = null;
                        }
                        if ((i3 & 128) != 0) {
                            i4 &= -29360129;
                            shape2 = AlertDialogDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                        }
                        if ((i3 & 256) != 0) {
                            containerColor = AlertDialogDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                            i4 &= -234881025;
                        } else {
                            containerColor = j;
                        }
                        if ((i3 & 512) != 0) {
                            iconContentColor = AlertDialogDefaults.INSTANCE.getIconContentColor(composerStartRestartGroup, 6);
                            i4 = (-1879048193) & i4;
                        } else {
                            iconContentColor = j2;
                        }
                        if ((i3 & 1024) != 0) {
                            titleContentColor = AlertDialogDefaults.INSTANCE.getTitleContentColor(composerStartRestartGroup, 6);
                            i13 &= -15;
                        } else {
                            titleContentColor = j3;
                        }
                        if ((i3 & 2048) != 0) {
                            textContentColor = AlertDialogDefaults.INSTANCE.getTextContentColor(composerStartRestartGroup, 6);
                            i13 &= -113;
                        } else {
                            textContentColor = j5;
                        }
                        if (i14 != 0) {
                            fM2717getTonalElevationD9Ej5fM = AlertDialogDefaults.INSTANCE.m2717getTonalElevationD9Ej5fM();
                        } else {
                            fM2717getTonalElevationD9Ej5fM = f;
                        }
                        if (i17 != 0) {
                            dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                        } else {
                            dialogProperties3 = dialogProperties;
                        }
                        function15 = function8;
                        function16 = function9;
                        shape4 = shape2;
                        modifier4 = modifier2;
                        i18 = 94478519;
                        int i2110 = i4;
                        function17 = function7;
                        function18 = function14;
                        j10 = containerColor;
                        j11 = titleContentColor;
                        long j117 = textContentColor;
                        i19 = i2110;
                        i20 = i13;
                        j12 = iconContentColor;
                        j13 = j117;
                    } else {
                        if (i25 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i5 != 0) {
                            function14 = null;
                        } else {
                            function14 = function3;
                        }
                        if (i7 != 0) {
                            function7 = null;
                        }
                        if (i9 != 0) {
                            function8 = null;
                        }
                        if (i11 != 0) {
                            function9 = null;
                        }
                        if ((i3 & 128) != 0) {
                            i4 &= -29360129;
                            shape2 = AlertDialogDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                        }
                        if ((i3 & 256) != 0) {
                            containerColor = AlertDialogDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                            i4 &= -234881025;
                        } else {
                            containerColor = j;
                        }
                        if ((i3 & 512) != 0) {
                            iconContentColor = AlertDialogDefaults.INSTANCE.getIconContentColor(composerStartRestartGroup, 6);
                            i4 = (-1879048193) & i4;
                        } else {
                            iconContentColor = j2;
                        }
                        if ((i3 & 1024) != 0) {
                            titleContentColor = AlertDialogDefaults.INSTANCE.getTitleContentColor(composerStartRestartGroup, 6);
                            i13 &= -15;
                        } else {
                            titleContentColor = j3;
                        }
                        if ((i3 & 2048) != 0) {
                            textContentColor = AlertDialogDefaults.INSTANCE.getTextContentColor(composerStartRestartGroup, 6);
                            i13 &= -113;
                        } else {
                            textContentColor = j5;
                        }
                        if (i14 != 0) {
                            fM2717getTonalElevationD9Ej5fM = AlertDialogDefaults.INSTANCE.m2717getTonalElevationD9Ej5fM();
                        } else {
                            fM2717getTonalElevationD9Ej5fM = f;
                        }
                        if (i17 != 0) {
                            dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                        } else {
                            dialogProperties3 = dialogProperties;
                        }
                        function15 = function8;
                        function16 = function9;
                        shape4 = shape2;
                        modifier4 = modifier2;
                        i18 = 94478519;
                        int i2111 = i4;
                        function17 = function7;
                        function18 = function14;
                        j10 = containerColor;
                        j11 = titleContentColor;
                        long j118 = textContentColor;
                        i19 = i2111;
                        i20 = i13;
                        j12 = iconContentColor;
                        j13 = j118;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(i18, i19, i20, "androidx.compose.material3.AlertDialog (AndroidAlertDialog.android.kt:46)");
                    }
                    composer2 = composerStartRestartGroup;
                    AlertDialogKt.m2726AlertDialogImplwrnwzgE(function0, function2, modifier4, function18, function17, function15, function16, shape4, j10, j12, j11, j13, fM2717getTonalElevationD9Ej5fM, dialogProperties3, composer2, i19 & 2147483646, i20 & 8190);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier4;
                    function10 = function18;
                    function11 = function17;
                    function12 = function15;
                    function13 = function16;
                    shape3 = shape4;
                    j8 = j10;
                    j9 = j12;
                    j6 = j11;
                    j7 = j13;
                    f2 = fM2717getTonalElevationD9Ej5fM;
                    dialogProperties2 = dialogProperties3;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    function10 = function3;
                    f2 = f;
                    dialogProperties2 = dialogProperties;
                    shape3 = shape2;
                    modifier3 = modifier2;
                    j6 = j3;
                    j7 = j5;
                    function11 = function7;
                    function12 = function8;
                    function13 = function9;
                    j8 = j;
                    j9 = j2;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.AndroidAlertDialog_androidKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return AndroidAlertDialog_androidKt.AlertDialog_Oix01E0$lambda$0(function0, function2, modifier3, function10, function11, function12, function13, shape3, j8, j9, j6, j7, f2, dialogProperties2, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i4 |= 3072;
            i7 = i3 & 16;
            if (i7 != 0) {
                if ((i & 24576) == 0) {
                    function7 = function4;
                    if (composerStartRestartGroup.changedInstance(function7)) {
                        i8 = 16384;
                    } else {
                        i8 = 8192;
                    }
                    i4 |= i8;
                }
                i9 = i3 & 32;
                if (i9 != 0) {
                    i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    function8 = function5;
                } else {
                    function8 = function5;
                    if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                        if (composerStartRestartGroup.changedInstance(function8)) {
                            i10 = 131072;
                        } else {
                            i10 = 65536;
                        }
                        i4 |= i10;
                    }
                }
                i11 = i3 & 64;
                if (i11 != 0) {
                    i4 |= 1572864;
                    function9 = function6;
                } else {
                    function9 = function6;
                    if ((i & 1572864) == 0) {
                        if (composerStartRestartGroup.changedInstance(function9)) {
                            i12 = 1048576;
                        } else {
                            i12 = 524288;
                        }
                        i4 |= i12;
                    }
                }
                if ((i & 12582912) == 0) {
                    if ((i3 & 128) == 0) {
                        shape2 = shape;
                        if (composerStartRestartGroup.changed(shape2)) {
                        }
                        i4 |= i26;
                    } else {
                        shape2 = shape;
                    }
                    i4 |= i26;
                } else {
                    shape2 = shape;
                }
                if ((i & 100663296) != 0) {
                    if ((i3 & 256) == 0) {
                        i24 = 33554432;
                    } else {
                        i24 = 33554432;
                    }
                    i4 |= i24;
                }
                if ((805306368 & i) != 0) {
                    if ((i3 & 512) == 0) {
                        i23 = 268435456;
                    } else {
                        i23 = 268435456;
                    }
                    i4 |= i23;
                }
                if ((i2 & 6) == 0) {
                    if ((i3 & 1024) == 0) {
                        i22 = 2;
                    } else {
                        i22 = 2;
                    }
                    i13 = i2 | i22;
                } else {
                    i13 = i2;
                }
                if ((i2 & 48) == 0) {
                    j5 = j4;
                    if ((i3 & 2048) == 0) {
                        i21 = 16;
                    } else {
                        i21 = 16;
                    }
                    i13 |= i21;
                } else {
                    j5 = j4;
                }
                i14 = i3 & 4096;
                if (i14 != 0) {
                    if ((i2 & 384) == 0) {
                        if (composerStartRestartGroup.changed(f)) {
                            i15 = 256;
                        } else {
                            i15 = 128;
                        }
                        i13 |= i15;
                    }
                    i16 = i3 & 8192;
                    if (i16 != 0) {
                        i17 = i16;
                        if ((i2 & 3072) == 0) {
                            i13 |= composerStartRestartGroup.changed(dialogProperties) ? 2048 : 1024;
                        }
                        if ((i4 & 306783379) == 306783378) {
                            z = true;
                        } else {
                            z = true;
                        }
                        if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
                            composerStartRestartGroup.startDefaults();
                            ComposerKt.sourceInformation(composerStartRestartGroup, "62@4972L5,62@5027L14,62@5093L16,62@5162L17,62@5231L16");
                            if ((i & 1) != 0) {
                                if (i25 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                if (i5 != 0) {
                                    function14 = null;
                                } else {
                                    function14 = function3;
                                }
                                if (i7 != 0) {
                                    function7 = null;
                                }
                                if (i9 != 0) {
                                    function8 = null;
                                }
                                if (i11 != 0) {
                                    function9 = null;
                                }
                                if ((i3 & 128) != 0) {
                                    i4 &= -29360129;
                                    shape2 = AlertDialogDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                                }
                                if ((i3 & 256) != 0) {
                                    containerColor = AlertDialogDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                                    i4 &= -234881025;
                                } else {
                                    containerColor = j;
                                }
                                if ((i3 & 512) != 0) {
                                    iconContentColor = AlertDialogDefaults.INSTANCE.getIconContentColor(composerStartRestartGroup, 6);
                                    i4 = (-1879048193) & i4;
                                } else {
                                    iconContentColor = j2;
                                }
                                if ((i3 & 1024) != 0) {
                                    titleContentColor = AlertDialogDefaults.INSTANCE.getTitleContentColor(composerStartRestartGroup, 6);
                                    i13 &= -15;
                                } else {
                                    titleContentColor = j3;
                                }
                                if ((i3 & 2048) != 0) {
                                    textContentColor = AlertDialogDefaults.INSTANCE.getTextContentColor(composerStartRestartGroup, 6);
                                    i13 &= -113;
                                } else {
                                    textContentColor = j5;
                                }
                                if (i14 != 0) {
                                    fM2717getTonalElevationD9Ej5fM = AlertDialogDefaults.INSTANCE.m2717getTonalElevationD9Ej5fM();
                                } else {
                                    fM2717getTonalElevationD9Ej5fM = f;
                                }
                                if (i17 != 0) {
                                    dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                                } else {
                                    dialogProperties3 = dialogProperties;
                                }
                                function15 = function8;
                                function16 = function9;
                                shape4 = shape2;
                                modifier4 = modifier2;
                                i18 = 94478519;
                                int i2112 = i4;
                                function17 = function7;
                                function18 = function14;
                                j10 = containerColor;
                                j11 = titleContentColor;
                                long j119 = textContentColor;
                                i19 = i2112;
                                i20 = i13;
                                j12 = iconContentColor;
                                j13 = j119;
                            } else {
                                if (i25 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                if (i5 != 0) {
                                    function14 = null;
                                } else {
                                    function14 = function3;
                                }
                                if (i7 != 0) {
                                    function7 = null;
                                }
                                if (i9 != 0) {
                                    function8 = null;
                                }
                                if (i11 != 0) {
                                    function9 = null;
                                }
                                if ((i3 & 128) != 0) {
                                    i4 &= -29360129;
                                    shape2 = AlertDialogDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                                }
                                if ((i3 & 256) != 0) {
                                    containerColor = AlertDialogDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                                    i4 &= -234881025;
                                } else {
                                    containerColor = j;
                                }
                                if ((i3 & 512) != 0) {
                                    iconContentColor = AlertDialogDefaults.INSTANCE.getIconContentColor(composerStartRestartGroup, 6);
                                    i4 = (-1879048193) & i4;
                                } else {
                                    iconContentColor = j2;
                                }
                                if ((i3 & 1024) != 0) {
                                    titleContentColor = AlertDialogDefaults.INSTANCE.getTitleContentColor(composerStartRestartGroup, 6);
                                    i13 &= -15;
                                } else {
                                    titleContentColor = j3;
                                }
                                if ((i3 & 2048) != 0) {
                                    textContentColor = AlertDialogDefaults.INSTANCE.getTextContentColor(composerStartRestartGroup, 6);
                                    i13 &= -113;
                                } else {
                                    textContentColor = j5;
                                }
                                if (i14 != 0) {
                                    fM2717getTonalElevationD9Ej5fM = AlertDialogDefaults.INSTANCE.m2717getTonalElevationD9Ej5fM();
                                } else {
                                    fM2717getTonalElevationD9Ej5fM = f;
                                }
                                if (i17 != 0) {
                                    dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                                } else {
                                    dialogProperties3 = dialogProperties;
                                }
                                function15 = function8;
                                function16 = function9;
                                shape4 = shape2;
                                modifier4 = modifier2;
                                i18 = 94478519;
                                int i2113 = i4;
                                function17 = function7;
                                function18 = function14;
                                j10 = containerColor;
                                j11 = titleContentColor;
                                long j1110 = textContentColor;
                                i19 = i2113;
                                i20 = i13;
                                j12 = iconContentColor;
                                j13 = j1110;
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(i18, i19, i20, "androidx.compose.material3.AlertDialog (AndroidAlertDialog.android.kt:46)");
                            }
                            composer2 = composerStartRestartGroup;
                            AlertDialogKt.m2726AlertDialogImplwrnwzgE(function0, function2, modifier4, function18, function17, function15, function16, shape4, j10, j12, j11, j13, fM2717getTonalElevationD9Ej5fM, dialogProperties3, composer2, i19 & 2147483646, i20 & 8190);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier3 = modifier4;
                            function10 = function18;
                            function11 = function17;
                            function12 = function15;
                            function13 = function16;
                            shape3 = shape4;
                            j8 = j10;
                            j9 = j12;
                            j6 = j11;
                            j7 = j13;
                            f2 = fM2717getTonalElevationD9Ej5fM;
                            dialogProperties2 = dialogProperties3;
                        } else {
                            composer2 = composerStartRestartGroup;
                            composer2.skipToGroupEnd();
                            function10 = function3;
                            f2 = f;
                            dialogProperties2 = dialogProperties;
                            shape3 = shape2;
                            modifier3 = modifier2;
                            j6 = j3;
                            j7 = j5;
                            function11 = function7;
                            function12 = function8;
                            function13 = function9;
                            j8 = j;
                            j9 = j2;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.AndroidAlertDialog_androidKt$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return AndroidAlertDialog_androidKt.AlertDialog_Oix01E0$lambda$0(function0, function2, modifier3, function10, function11, function12, function13, shape3, j8, j9, j6, j7, f2, dialogProperties2, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                        }
                    }
                    i13 |= 3072;
                    i17 = i16;
                    if ((i4 & 306783379) == 306783378) {
                        z = true;
                    } else {
                        z = true;
                    }
                    if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "62@4972L5,62@5027L14,62@5093L16,62@5162L17,62@5231L16");
                        if ((i & 1) != 0) {
                            if (i25 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i5 != 0) {
                                function14 = null;
                            } else {
                                function14 = function3;
                            }
                            if (i7 != 0) {
                                function7 = null;
                            }
                            if (i9 != 0) {
                                function8 = null;
                            }
                            if (i11 != 0) {
                                function9 = null;
                            }
                            if ((i3 & 128) != 0) {
                                i4 &= -29360129;
                                shape2 = AlertDialogDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                            }
                            if ((i3 & 256) != 0) {
                                containerColor = AlertDialogDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                                i4 &= -234881025;
                            } else {
                                containerColor = j;
                            }
                            if ((i3 & 512) != 0) {
                                iconContentColor = AlertDialogDefaults.INSTANCE.getIconContentColor(composerStartRestartGroup, 6);
                                i4 = (-1879048193) & i4;
                            } else {
                                iconContentColor = j2;
                            }
                            if ((i3 & 1024) != 0) {
                                titleContentColor = AlertDialogDefaults.INSTANCE.getTitleContentColor(composerStartRestartGroup, 6);
                                i13 &= -15;
                            } else {
                                titleContentColor = j3;
                            }
                            if ((i3 & 2048) != 0) {
                                textContentColor = AlertDialogDefaults.INSTANCE.getTextContentColor(composerStartRestartGroup, 6);
                                i13 &= -113;
                            } else {
                                textContentColor = j5;
                            }
                            if (i14 != 0) {
                                fM2717getTonalElevationD9Ej5fM = AlertDialogDefaults.INSTANCE.m2717getTonalElevationD9Ej5fM();
                            } else {
                                fM2717getTonalElevationD9Ej5fM = f;
                            }
                            if (i17 != 0) {
                                dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                            } else {
                                dialogProperties3 = dialogProperties;
                            }
                            function15 = function8;
                            function16 = function9;
                            shape4 = shape2;
                            modifier4 = modifier2;
                            i18 = 94478519;
                            int i2114 = i4;
                            function17 = function7;
                            function18 = function14;
                            j10 = containerColor;
                            j11 = titleContentColor;
                            long j1111 = textContentColor;
                            i19 = i2114;
                            i20 = i13;
                            j12 = iconContentColor;
                            j13 = j1111;
                        } else {
                            if (i25 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i5 != 0) {
                                function14 = null;
                            } else {
                                function14 = function3;
                            }
                            if (i7 != 0) {
                                function7 = null;
                            }
                            if (i9 != 0) {
                                function8 = null;
                            }
                            if (i11 != 0) {
                                function9 = null;
                            }
                            if ((i3 & 128) != 0) {
                                i4 &= -29360129;
                                shape2 = AlertDialogDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                            }
                            if ((i3 & 256) != 0) {
                                containerColor = AlertDialogDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                                i4 &= -234881025;
                            } else {
                                containerColor = j;
                            }
                            if ((i3 & 512) != 0) {
                                iconContentColor = AlertDialogDefaults.INSTANCE.getIconContentColor(composerStartRestartGroup, 6);
                                i4 = (-1879048193) & i4;
                            } else {
                                iconContentColor = j2;
                            }
                            if ((i3 & 1024) != 0) {
                                titleContentColor = AlertDialogDefaults.INSTANCE.getTitleContentColor(composerStartRestartGroup, 6);
                                i13 &= -15;
                            } else {
                                titleContentColor = j3;
                            }
                            if ((i3 & 2048) != 0) {
                                textContentColor = AlertDialogDefaults.INSTANCE.getTextContentColor(composerStartRestartGroup, 6);
                                i13 &= -113;
                            } else {
                                textContentColor = j5;
                            }
                            if (i14 != 0) {
                                fM2717getTonalElevationD9Ej5fM = AlertDialogDefaults.INSTANCE.m2717getTonalElevationD9Ej5fM();
                            } else {
                                fM2717getTonalElevationD9Ej5fM = f;
                            }
                            if (i17 != 0) {
                                dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                            } else {
                                dialogProperties3 = dialogProperties;
                            }
                            function15 = function8;
                            function16 = function9;
                            shape4 = shape2;
                            modifier4 = modifier2;
                            i18 = 94478519;
                            int i2115 = i4;
                            function17 = function7;
                            function18 = function14;
                            j10 = containerColor;
                            j11 = titleContentColor;
                            long j1112 = textContentColor;
                            i19 = i2115;
                            i20 = i13;
                            j12 = iconContentColor;
                            j13 = j1112;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(i18, i19, i20, "androidx.compose.material3.AlertDialog (AndroidAlertDialog.android.kt:46)");
                        }
                        composer2 = composerStartRestartGroup;
                        AlertDialogKt.m2726AlertDialogImplwrnwzgE(function0, function2, modifier4, function18, function17, function15, function16, shape4, j10, j12, j11, j13, fM2717getTonalElevationD9Ej5fM, dialogProperties3, composer2, i19 & 2147483646, i20 & 8190);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier4;
                        function10 = function18;
                        function11 = function17;
                        function12 = function15;
                        function13 = function16;
                        shape3 = shape4;
                        j8 = j10;
                        j9 = j12;
                        j6 = j11;
                        j7 = j13;
                        f2 = fM2717getTonalElevationD9Ej5fM;
                        dialogProperties2 = dialogProperties3;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        function10 = function3;
                        f2 = f;
                        dialogProperties2 = dialogProperties;
                        shape3 = shape2;
                        modifier3 = modifier2;
                        j6 = j3;
                        j7 = j5;
                        function11 = function7;
                        function12 = function8;
                        function13 = function9;
                        j8 = j;
                        j9 = j2;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.AndroidAlertDialog_androidKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return AndroidAlertDialog_androidKt.AlertDialog_Oix01E0$lambda$0(function0, function2, modifier3, function10, function11, function12, function13, shape3, j8, j9, j6, j7, f2, dialogProperties2, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i13 |= 384;
                i16 = i3 & 8192;
                if (i16 != 0) {
                    i17 = i16;
                    if ((i2 & 3072) == 0) {
                        i13 |= composerStartRestartGroup.changed(dialogProperties) ? 2048 : 1024;
                    }
                    if ((i4 & 306783379) == 306783378) {
                        z = true;
                    } else {
                        z = true;
                    }
                    if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "62@4972L5,62@5027L14,62@5093L16,62@5162L17,62@5231L16");
                        if ((i & 1) != 0) {
                            if (i25 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i5 != 0) {
                                function14 = null;
                            } else {
                                function14 = function3;
                            }
                            if (i7 != 0) {
                                function7 = null;
                            }
                            if (i9 != 0) {
                                function8 = null;
                            }
                            if (i11 != 0) {
                                function9 = null;
                            }
                            if ((i3 & 128) != 0) {
                                i4 &= -29360129;
                                shape2 = AlertDialogDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                            }
                            if ((i3 & 256) != 0) {
                                containerColor = AlertDialogDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                                i4 &= -234881025;
                            } else {
                                containerColor = j;
                            }
                            if ((i3 & 512) != 0) {
                                iconContentColor = AlertDialogDefaults.INSTANCE.getIconContentColor(composerStartRestartGroup, 6);
                                i4 = (-1879048193) & i4;
                            } else {
                                iconContentColor = j2;
                            }
                            if ((i3 & 1024) != 0) {
                                titleContentColor = AlertDialogDefaults.INSTANCE.getTitleContentColor(composerStartRestartGroup, 6);
                                i13 &= -15;
                            } else {
                                titleContentColor = j3;
                            }
                            if ((i3 & 2048) != 0) {
                                textContentColor = AlertDialogDefaults.INSTANCE.getTextContentColor(composerStartRestartGroup, 6);
                                i13 &= -113;
                            } else {
                                textContentColor = j5;
                            }
                            if (i14 != 0) {
                                fM2717getTonalElevationD9Ej5fM = AlertDialogDefaults.INSTANCE.m2717getTonalElevationD9Ej5fM();
                            } else {
                                fM2717getTonalElevationD9Ej5fM = f;
                            }
                            if (i17 != 0) {
                                dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                            } else {
                                dialogProperties3 = dialogProperties;
                            }
                            function15 = function8;
                            function16 = function9;
                            shape4 = shape2;
                            modifier4 = modifier2;
                            i18 = 94478519;
                            int i2116 = i4;
                            function17 = function7;
                            function18 = function14;
                            j10 = containerColor;
                            j11 = titleContentColor;
                            long j1113 = textContentColor;
                            i19 = i2116;
                            i20 = i13;
                            j12 = iconContentColor;
                            j13 = j1113;
                        } else {
                            if (i25 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i5 != 0) {
                                function14 = null;
                            } else {
                                function14 = function3;
                            }
                            if (i7 != 0) {
                                function7 = null;
                            }
                            if (i9 != 0) {
                                function8 = null;
                            }
                            if (i11 != 0) {
                                function9 = null;
                            }
                            if ((i3 & 128) != 0) {
                                i4 &= -29360129;
                                shape2 = AlertDialogDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                            }
                            if ((i3 & 256) != 0) {
                                containerColor = AlertDialogDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                                i4 &= -234881025;
                            } else {
                                containerColor = j;
                            }
                            if ((i3 & 512) != 0) {
                                iconContentColor = AlertDialogDefaults.INSTANCE.getIconContentColor(composerStartRestartGroup, 6);
                                i4 = (-1879048193) & i4;
                            } else {
                                iconContentColor = j2;
                            }
                            if ((i3 & 1024) != 0) {
                                titleContentColor = AlertDialogDefaults.INSTANCE.getTitleContentColor(composerStartRestartGroup, 6);
                                i13 &= -15;
                            } else {
                                titleContentColor = j3;
                            }
                            if ((i3 & 2048) != 0) {
                                textContentColor = AlertDialogDefaults.INSTANCE.getTextContentColor(composerStartRestartGroup, 6);
                                i13 &= -113;
                            } else {
                                textContentColor = j5;
                            }
                            if (i14 != 0) {
                                fM2717getTonalElevationD9Ej5fM = AlertDialogDefaults.INSTANCE.m2717getTonalElevationD9Ej5fM();
                            } else {
                                fM2717getTonalElevationD9Ej5fM = f;
                            }
                            if (i17 != 0) {
                                dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                            } else {
                                dialogProperties3 = dialogProperties;
                            }
                            function15 = function8;
                            function16 = function9;
                            shape4 = shape2;
                            modifier4 = modifier2;
                            i18 = 94478519;
                            int i2117 = i4;
                            function17 = function7;
                            function18 = function14;
                            j10 = containerColor;
                            j11 = titleContentColor;
                            long j1114 = textContentColor;
                            i19 = i2117;
                            i20 = i13;
                            j12 = iconContentColor;
                            j13 = j1114;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(i18, i19, i20, "androidx.compose.material3.AlertDialog (AndroidAlertDialog.android.kt:46)");
                        }
                        composer2 = composerStartRestartGroup;
                        AlertDialogKt.m2726AlertDialogImplwrnwzgE(function0, function2, modifier4, function18, function17, function15, function16, shape4, j10, j12, j11, j13, fM2717getTonalElevationD9Ej5fM, dialogProperties3, composer2, i19 & 2147483646, i20 & 8190);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier4;
                        function10 = function18;
                        function11 = function17;
                        function12 = function15;
                        function13 = function16;
                        shape3 = shape4;
                        j8 = j10;
                        j9 = j12;
                        j6 = j11;
                        j7 = j13;
                        f2 = fM2717getTonalElevationD9Ej5fM;
                        dialogProperties2 = dialogProperties3;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        function10 = function3;
                        f2 = f;
                        dialogProperties2 = dialogProperties;
                        shape3 = shape2;
                        modifier3 = modifier2;
                        j6 = j3;
                        j7 = j5;
                        function11 = function7;
                        function12 = function8;
                        function13 = function9;
                        j8 = j;
                        j9 = j2;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.AndroidAlertDialog_androidKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return AndroidAlertDialog_androidKt.AlertDialog_Oix01E0$lambda$0(function0, function2, modifier3, function10, function11, function12, function13, shape3, j8, j9, j6, j7, f2, dialogProperties2, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i13 |= 3072;
                i17 = i16;
                if ((i4 & 306783379) == 306783378) {
                    z = true;
                } else {
                    z = true;
                }
                if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "62@4972L5,62@5027L14,62@5093L16,62@5162L17,62@5231L16");
                    if ((i & 1) != 0) {
                        if (i25 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i5 != 0) {
                            function14 = null;
                        } else {
                            function14 = function3;
                        }
                        if (i7 != 0) {
                            function7 = null;
                        }
                        if (i9 != 0) {
                            function8 = null;
                        }
                        if (i11 != 0) {
                            function9 = null;
                        }
                        if ((i3 & 128) != 0) {
                            i4 &= -29360129;
                            shape2 = AlertDialogDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                        }
                        if ((i3 & 256) != 0) {
                            containerColor = AlertDialogDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                            i4 &= -234881025;
                        } else {
                            containerColor = j;
                        }
                        if ((i3 & 512) != 0) {
                            iconContentColor = AlertDialogDefaults.INSTANCE.getIconContentColor(composerStartRestartGroup, 6);
                            i4 = (-1879048193) & i4;
                        } else {
                            iconContentColor = j2;
                        }
                        if ((i3 & 1024) != 0) {
                            titleContentColor = AlertDialogDefaults.INSTANCE.getTitleContentColor(composerStartRestartGroup, 6);
                            i13 &= -15;
                        } else {
                            titleContentColor = j3;
                        }
                        if ((i3 & 2048) != 0) {
                            textContentColor = AlertDialogDefaults.INSTANCE.getTextContentColor(composerStartRestartGroup, 6);
                            i13 &= -113;
                        } else {
                            textContentColor = j5;
                        }
                        if (i14 != 0) {
                            fM2717getTonalElevationD9Ej5fM = AlertDialogDefaults.INSTANCE.m2717getTonalElevationD9Ej5fM();
                        } else {
                            fM2717getTonalElevationD9Ej5fM = f;
                        }
                        if (i17 != 0) {
                            dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                        } else {
                            dialogProperties3 = dialogProperties;
                        }
                        function15 = function8;
                        function16 = function9;
                        shape4 = shape2;
                        modifier4 = modifier2;
                        i18 = 94478519;
                        int i2118 = i4;
                        function17 = function7;
                        function18 = function14;
                        j10 = containerColor;
                        j11 = titleContentColor;
                        long j1115 = textContentColor;
                        i19 = i2118;
                        i20 = i13;
                        j12 = iconContentColor;
                        j13 = j1115;
                    } else {
                        if (i25 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i5 != 0) {
                            function14 = null;
                        } else {
                            function14 = function3;
                        }
                        if (i7 != 0) {
                            function7 = null;
                        }
                        if (i9 != 0) {
                            function8 = null;
                        }
                        if (i11 != 0) {
                            function9 = null;
                        }
                        if ((i3 & 128) != 0) {
                            i4 &= -29360129;
                            shape2 = AlertDialogDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                        }
                        if ((i3 & 256) != 0) {
                            containerColor = AlertDialogDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                            i4 &= -234881025;
                        } else {
                            containerColor = j;
                        }
                        if ((i3 & 512) != 0) {
                            iconContentColor = AlertDialogDefaults.INSTANCE.getIconContentColor(composerStartRestartGroup, 6);
                            i4 = (-1879048193) & i4;
                        } else {
                            iconContentColor = j2;
                        }
                        if ((i3 & 1024) != 0) {
                            titleContentColor = AlertDialogDefaults.INSTANCE.getTitleContentColor(composerStartRestartGroup, 6);
                            i13 &= -15;
                        } else {
                            titleContentColor = j3;
                        }
                        if ((i3 & 2048) != 0) {
                            textContentColor = AlertDialogDefaults.INSTANCE.getTextContentColor(composerStartRestartGroup, 6);
                            i13 &= -113;
                        } else {
                            textContentColor = j5;
                        }
                        if (i14 != 0) {
                            fM2717getTonalElevationD9Ej5fM = AlertDialogDefaults.INSTANCE.m2717getTonalElevationD9Ej5fM();
                        } else {
                            fM2717getTonalElevationD9Ej5fM = f;
                        }
                        if (i17 != 0) {
                            dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                        } else {
                            dialogProperties3 = dialogProperties;
                        }
                        function15 = function8;
                        function16 = function9;
                        shape4 = shape2;
                        modifier4 = modifier2;
                        i18 = 94478519;
                        int i2119 = i4;
                        function17 = function7;
                        function18 = function14;
                        j10 = containerColor;
                        j11 = titleContentColor;
                        long j1116 = textContentColor;
                        i19 = i2119;
                        i20 = i13;
                        j12 = iconContentColor;
                        j13 = j1116;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(i18, i19, i20, "androidx.compose.material3.AlertDialog (AndroidAlertDialog.android.kt:46)");
                    }
                    composer2 = composerStartRestartGroup;
                    AlertDialogKt.m2726AlertDialogImplwrnwzgE(function0, function2, modifier4, function18, function17, function15, function16, shape4, j10, j12, j11, j13, fM2717getTonalElevationD9Ej5fM, dialogProperties3, composer2, i19 & 2147483646, i20 & 8190);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier4;
                    function10 = function18;
                    function11 = function17;
                    function12 = function15;
                    function13 = function16;
                    shape3 = shape4;
                    j8 = j10;
                    j9 = j12;
                    j6 = j11;
                    j7 = j13;
                    f2 = fM2717getTonalElevationD9Ej5fM;
                    dialogProperties2 = dialogProperties3;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    function10 = function3;
                    f2 = f;
                    dialogProperties2 = dialogProperties;
                    shape3 = shape2;
                    modifier3 = modifier2;
                    j6 = j3;
                    j7 = j5;
                    function11 = function7;
                    function12 = function8;
                    function13 = function9;
                    j8 = j;
                    j9 = j2;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.AndroidAlertDialog_androidKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return AndroidAlertDialog_androidKt.AlertDialog_Oix01E0$lambda$0(function0, function2, modifier3, function10, function11, function12, function13, shape3, j8, j9, j6, j7, f2, dialogProperties2, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i4 |= 24576;
            function7 = function4;
            i9 = i3 & 32;
            if (i9 != 0) {
                i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                function8 = function5;
            } else {
                function8 = function5;
                if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    if (composerStartRestartGroup.changedInstance(function8)) {
                        i10 = 131072;
                    } else {
                        i10 = 65536;
                    }
                    i4 |= i10;
                }
            }
            i11 = i3 & 64;
            if (i11 != 0) {
                i4 |= 1572864;
                function9 = function6;
            } else {
                function9 = function6;
                if ((i & 1572864) == 0) {
                    if (composerStartRestartGroup.changedInstance(function9)) {
                        i12 = 1048576;
                    } else {
                        i12 = 524288;
                    }
                    i4 |= i12;
                }
            }
            if ((i & 12582912) == 0) {
                if ((i3 & 128) == 0) {
                    shape2 = shape;
                    if (composerStartRestartGroup.changed(shape2)) {
                    }
                    i4 |= i26;
                } else {
                    shape2 = shape;
                }
                i4 |= i26;
            } else {
                shape2 = shape;
            }
            if ((i & 100663296) != 0) {
                if ((i3 & 256) == 0) {
                    i24 = 33554432;
                } else {
                    i24 = 33554432;
                }
                i4 |= i24;
            }
            if ((805306368 & i) != 0) {
                if ((i3 & 512) == 0) {
                    i23 = 268435456;
                } else {
                    i23 = 268435456;
                }
                i4 |= i23;
            }
            if ((i2 & 6) == 0) {
                if ((i3 & 1024) == 0) {
                    i22 = 2;
                } else {
                    i22 = 2;
                }
                i13 = i2 | i22;
            } else {
                i13 = i2;
            }
            if ((i2 & 48) == 0) {
                j5 = j4;
                if ((i3 & 2048) == 0) {
                    i21 = 16;
                } else {
                    i21 = 16;
                }
                i13 |= i21;
            } else {
                j5 = j4;
            }
            i14 = i3 & 4096;
            if (i14 != 0) {
                if ((i2 & 384) == 0) {
                    if (composerStartRestartGroup.changed(f)) {
                        i15 = 256;
                    } else {
                        i15 = 128;
                    }
                    i13 |= i15;
                }
                i16 = i3 & 8192;
                if (i16 != 0) {
                    i17 = i16;
                    if ((i2 & 3072) == 0) {
                        i13 |= composerStartRestartGroup.changed(dialogProperties) ? 2048 : 1024;
                    }
                    if ((i4 & 306783379) == 306783378) {
                        z = true;
                    } else {
                        z = true;
                    }
                    if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "62@4972L5,62@5027L14,62@5093L16,62@5162L17,62@5231L16");
                        if ((i & 1) != 0) {
                            if (i25 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i5 != 0) {
                                function14 = null;
                            } else {
                                function14 = function3;
                            }
                            if (i7 != 0) {
                                function7 = null;
                            }
                            if (i9 != 0) {
                                function8 = null;
                            }
                            if (i11 != 0) {
                                function9 = null;
                            }
                            if ((i3 & 128) != 0) {
                                i4 &= -29360129;
                                shape2 = AlertDialogDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                            }
                            if ((i3 & 256) != 0) {
                                containerColor = AlertDialogDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                                i4 &= -234881025;
                            } else {
                                containerColor = j;
                            }
                            if ((i3 & 512) != 0) {
                                iconContentColor = AlertDialogDefaults.INSTANCE.getIconContentColor(composerStartRestartGroup, 6);
                                i4 = (-1879048193) & i4;
                            } else {
                                iconContentColor = j2;
                            }
                            if ((i3 & 1024) != 0) {
                                titleContentColor = AlertDialogDefaults.INSTANCE.getTitleContentColor(composerStartRestartGroup, 6);
                                i13 &= -15;
                            } else {
                                titleContentColor = j3;
                            }
                            if ((i3 & 2048) != 0) {
                                textContentColor = AlertDialogDefaults.INSTANCE.getTextContentColor(composerStartRestartGroup, 6);
                                i13 &= -113;
                            } else {
                                textContentColor = j5;
                            }
                            if (i14 != 0) {
                                fM2717getTonalElevationD9Ej5fM = AlertDialogDefaults.INSTANCE.m2717getTonalElevationD9Ej5fM();
                            } else {
                                fM2717getTonalElevationD9Ej5fM = f;
                            }
                            if (i17 != 0) {
                                dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                            } else {
                                dialogProperties3 = dialogProperties;
                            }
                            function15 = function8;
                            function16 = function9;
                            shape4 = shape2;
                            modifier4 = modifier2;
                            i18 = 94478519;
                            int i21110 = i4;
                            function17 = function7;
                            function18 = function14;
                            j10 = containerColor;
                            j11 = titleContentColor;
                            long j1117 = textContentColor;
                            i19 = i21110;
                            i20 = i13;
                            j12 = iconContentColor;
                            j13 = j1117;
                        } else {
                            if (i25 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i5 != 0) {
                                function14 = null;
                            } else {
                                function14 = function3;
                            }
                            if (i7 != 0) {
                                function7 = null;
                            }
                            if (i9 != 0) {
                                function8 = null;
                            }
                            if (i11 != 0) {
                                function9 = null;
                            }
                            if ((i3 & 128) != 0) {
                                i4 &= -29360129;
                                shape2 = AlertDialogDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                            }
                            if ((i3 & 256) != 0) {
                                containerColor = AlertDialogDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                                i4 &= -234881025;
                            } else {
                                containerColor = j;
                            }
                            if ((i3 & 512) != 0) {
                                iconContentColor = AlertDialogDefaults.INSTANCE.getIconContentColor(composerStartRestartGroup, 6);
                                i4 = (-1879048193) & i4;
                            } else {
                                iconContentColor = j2;
                            }
                            if ((i3 & 1024) != 0) {
                                titleContentColor = AlertDialogDefaults.INSTANCE.getTitleContentColor(composerStartRestartGroup, 6);
                                i13 &= -15;
                            } else {
                                titleContentColor = j3;
                            }
                            if ((i3 & 2048) != 0) {
                                textContentColor = AlertDialogDefaults.INSTANCE.getTextContentColor(composerStartRestartGroup, 6);
                                i13 &= -113;
                            } else {
                                textContentColor = j5;
                            }
                            if (i14 != 0) {
                                fM2717getTonalElevationD9Ej5fM = AlertDialogDefaults.INSTANCE.m2717getTonalElevationD9Ej5fM();
                            } else {
                                fM2717getTonalElevationD9Ej5fM = f;
                            }
                            if (i17 != 0) {
                                dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                            } else {
                                dialogProperties3 = dialogProperties;
                            }
                            function15 = function8;
                            function16 = function9;
                            shape4 = shape2;
                            modifier4 = modifier2;
                            i18 = 94478519;
                            int i21111 = i4;
                            function17 = function7;
                            function18 = function14;
                            j10 = containerColor;
                            j11 = titleContentColor;
                            long j1118 = textContentColor;
                            i19 = i21111;
                            i20 = i13;
                            j12 = iconContentColor;
                            j13 = j1118;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(i18, i19, i20, "androidx.compose.material3.AlertDialog (AndroidAlertDialog.android.kt:46)");
                        }
                        composer2 = composerStartRestartGroup;
                        AlertDialogKt.m2726AlertDialogImplwrnwzgE(function0, function2, modifier4, function18, function17, function15, function16, shape4, j10, j12, j11, j13, fM2717getTonalElevationD9Ej5fM, dialogProperties3, composer2, i19 & 2147483646, i20 & 8190);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier4;
                        function10 = function18;
                        function11 = function17;
                        function12 = function15;
                        function13 = function16;
                        shape3 = shape4;
                        j8 = j10;
                        j9 = j12;
                        j6 = j11;
                        j7 = j13;
                        f2 = fM2717getTonalElevationD9Ej5fM;
                        dialogProperties2 = dialogProperties3;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        function10 = function3;
                        f2 = f;
                        dialogProperties2 = dialogProperties;
                        shape3 = shape2;
                        modifier3 = modifier2;
                        j6 = j3;
                        j7 = j5;
                        function11 = function7;
                        function12 = function8;
                        function13 = function9;
                        j8 = j;
                        j9 = j2;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.AndroidAlertDialog_androidKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return AndroidAlertDialog_androidKt.AlertDialog_Oix01E0$lambda$0(function0, function2, modifier3, function10, function11, function12, function13, shape3, j8, j9, j6, j7, f2, dialogProperties2, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i13 |= 3072;
                i17 = i16;
                if ((i4 & 306783379) == 306783378) {
                    z = true;
                } else {
                    z = true;
                }
                if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "62@4972L5,62@5027L14,62@5093L16,62@5162L17,62@5231L16");
                    if ((i & 1) != 0) {
                        if (i25 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i5 != 0) {
                            function14 = null;
                        } else {
                            function14 = function3;
                        }
                        if (i7 != 0) {
                            function7 = null;
                        }
                        if (i9 != 0) {
                            function8 = null;
                        }
                        if (i11 != 0) {
                            function9 = null;
                        }
                        if ((i3 & 128) != 0) {
                            i4 &= -29360129;
                            shape2 = AlertDialogDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                        }
                        if ((i3 & 256) != 0) {
                            containerColor = AlertDialogDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                            i4 &= -234881025;
                        } else {
                            containerColor = j;
                        }
                        if ((i3 & 512) != 0) {
                            iconContentColor = AlertDialogDefaults.INSTANCE.getIconContentColor(composerStartRestartGroup, 6);
                            i4 = (-1879048193) & i4;
                        } else {
                            iconContentColor = j2;
                        }
                        if ((i3 & 1024) != 0) {
                            titleContentColor = AlertDialogDefaults.INSTANCE.getTitleContentColor(composerStartRestartGroup, 6);
                            i13 &= -15;
                        } else {
                            titleContentColor = j3;
                        }
                        if ((i3 & 2048) != 0) {
                            textContentColor = AlertDialogDefaults.INSTANCE.getTextContentColor(composerStartRestartGroup, 6);
                            i13 &= -113;
                        } else {
                            textContentColor = j5;
                        }
                        if (i14 != 0) {
                            fM2717getTonalElevationD9Ej5fM = AlertDialogDefaults.INSTANCE.m2717getTonalElevationD9Ej5fM();
                        } else {
                            fM2717getTonalElevationD9Ej5fM = f;
                        }
                        if (i17 != 0) {
                            dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                        } else {
                            dialogProperties3 = dialogProperties;
                        }
                        function15 = function8;
                        function16 = function9;
                        shape4 = shape2;
                        modifier4 = modifier2;
                        i18 = 94478519;
                        int i21112 = i4;
                        function17 = function7;
                        function18 = function14;
                        j10 = containerColor;
                        j11 = titleContentColor;
                        long j1119 = textContentColor;
                        i19 = i21112;
                        i20 = i13;
                        j12 = iconContentColor;
                        j13 = j1119;
                    } else {
                        if (i25 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i5 != 0) {
                            function14 = null;
                        } else {
                            function14 = function3;
                        }
                        if (i7 != 0) {
                            function7 = null;
                        }
                        if (i9 != 0) {
                            function8 = null;
                        }
                        if (i11 != 0) {
                            function9 = null;
                        }
                        if ((i3 & 128) != 0) {
                            i4 &= -29360129;
                            shape2 = AlertDialogDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                        }
                        if ((i3 & 256) != 0) {
                            containerColor = AlertDialogDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                            i4 &= -234881025;
                        } else {
                            containerColor = j;
                        }
                        if ((i3 & 512) != 0) {
                            iconContentColor = AlertDialogDefaults.INSTANCE.getIconContentColor(composerStartRestartGroup, 6);
                            i4 = (-1879048193) & i4;
                        } else {
                            iconContentColor = j2;
                        }
                        if ((i3 & 1024) != 0) {
                            titleContentColor = AlertDialogDefaults.INSTANCE.getTitleContentColor(composerStartRestartGroup, 6);
                            i13 &= -15;
                        } else {
                            titleContentColor = j3;
                        }
                        if ((i3 & 2048) != 0) {
                            textContentColor = AlertDialogDefaults.INSTANCE.getTextContentColor(composerStartRestartGroup, 6);
                            i13 &= -113;
                        } else {
                            textContentColor = j5;
                        }
                        if (i14 != 0) {
                            fM2717getTonalElevationD9Ej5fM = AlertDialogDefaults.INSTANCE.m2717getTonalElevationD9Ej5fM();
                        } else {
                            fM2717getTonalElevationD9Ej5fM = f;
                        }
                        if (i17 != 0) {
                            dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                        } else {
                            dialogProperties3 = dialogProperties;
                        }
                        function15 = function8;
                        function16 = function9;
                        shape4 = shape2;
                        modifier4 = modifier2;
                        i18 = 94478519;
                        int i21113 = i4;
                        function17 = function7;
                        function18 = function14;
                        j10 = containerColor;
                        j11 = titleContentColor;
                        long j11110 = textContentColor;
                        i19 = i21113;
                        i20 = i13;
                        j12 = iconContentColor;
                        j13 = j11110;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(i18, i19, i20, "androidx.compose.material3.AlertDialog (AndroidAlertDialog.android.kt:46)");
                    }
                    composer2 = composerStartRestartGroup;
                    AlertDialogKt.m2726AlertDialogImplwrnwzgE(function0, function2, modifier4, function18, function17, function15, function16, shape4, j10, j12, j11, j13, fM2717getTonalElevationD9Ej5fM, dialogProperties3, composer2, i19 & 2147483646, i20 & 8190);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier4;
                    function10 = function18;
                    function11 = function17;
                    function12 = function15;
                    function13 = function16;
                    shape3 = shape4;
                    j8 = j10;
                    j9 = j12;
                    j6 = j11;
                    j7 = j13;
                    f2 = fM2717getTonalElevationD9Ej5fM;
                    dialogProperties2 = dialogProperties3;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    function10 = function3;
                    f2 = f;
                    dialogProperties2 = dialogProperties;
                    shape3 = shape2;
                    modifier3 = modifier2;
                    j6 = j3;
                    j7 = j5;
                    function11 = function7;
                    function12 = function8;
                    function13 = function9;
                    j8 = j;
                    j9 = j2;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.AndroidAlertDialog_androidKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return AndroidAlertDialog_androidKt.AlertDialog_Oix01E0$lambda$0(function0, function2, modifier3, function10, function11, function12, function13, shape3, j8, j9, j6, j7, f2, dialogProperties2, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i13 |= 384;
            i16 = i3 & 8192;
            if (i16 != 0) {
                i17 = i16;
                if ((i2 & 3072) == 0) {
                    i13 |= composerStartRestartGroup.changed(dialogProperties) ? 2048 : 1024;
                }
                if ((i4 & 306783379) == 306783378) {
                    z = true;
                } else {
                    z = true;
                }
                if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "62@4972L5,62@5027L14,62@5093L16,62@5162L17,62@5231L16");
                    if ((i & 1) != 0) {
                        if (i25 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i5 != 0) {
                            function14 = null;
                        } else {
                            function14 = function3;
                        }
                        if (i7 != 0) {
                            function7 = null;
                        }
                        if (i9 != 0) {
                            function8 = null;
                        }
                        if (i11 != 0) {
                            function9 = null;
                        }
                        if ((i3 & 128) != 0) {
                            i4 &= -29360129;
                            shape2 = AlertDialogDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                        }
                        if ((i3 & 256) != 0) {
                            containerColor = AlertDialogDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                            i4 &= -234881025;
                        } else {
                            containerColor = j;
                        }
                        if ((i3 & 512) != 0) {
                            iconContentColor = AlertDialogDefaults.INSTANCE.getIconContentColor(composerStartRestartGroup, 6);
                            i4 = (-1879048193) & i4;
                        } else {
                            iconContentColor = j2;
                        }
                        if ((i3 & 1024) != 0) {
                            titleContentColor = AlertDialogDefaults.INSTANCE.getTitleContentColor(composerStartRestartGroup, 6);
                            i13 &= -15;
                        } else {
                            titleContentColor = j3;
                        }
                        if ((i3 & 2048) != 0) {
                            textContentColor = AlertDialogDefaults.INSTANCE.getTextContentColor(composerStartRestartGroup, 6);
                            i13 &= -113;
                        } else {
                            textContentColor = j5;
                        }
                        if (i14 != 0) {
                            fM2717getTonalElevationD9Ej5fM = AlertDialogDefaults.INSTANCE.m2717getTonalElevationD9Ej5fM();
                        } else {
                            fM2717getTonalElevationD9Ej5fM = f;
                        }
                        if (i17 != 0) {
                            dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                        } else {
                            dialogProperties3 = dialogProperties;
                        }
                        function15 = function8;
                        function16 = function9;
                        shape4 = shape2;
                        modifier4 = modifier2;
                        i18 = 94478519;
                        int i21114 = i4;
                        function17 = function7;
                        function18 = function14;
                        j10 = containerColor;
                        j11 = titleContentColor;
                        long j11111 = textContentColor;
                        i19 = i21114;
                        i20 = i13;
                        j12 = iconContentColor;
                        j13 = j11111;
                    } else {
                        if (i25 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i5 != 0) {
                            function14 = null;
                        } else {
                            function14 = function3;
                        }
                        if (i7 != 0) {
                            function7 = null;
                        }
                        if (i9 != 0) {
                            function8 = null;
                        }
                        if (i11 != 0) {
                            function9 = null;
                        }
                        if ((i3 & 128) != 0) {
                            i4 &= -29360129;
                            shape2 = AlertDialogDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                        }
                        if ((i3 & 256) != 0) {
                            containerColor = AlertDialogDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                            i4 &= -234881025;
                        } else {
                            containerColor = j;
                        }
                        if ((i3 & 512) != 0) {
                            iconContentColor = AlertDialogDefaults.INSTANCE.getIconContentColor(composerStartRestartGroup, 6);
                            i4 = (-1879048193) & i4;
                        } else {
                            iconContentColor = j2;
                        }
                        if ((i3 & 1024) != 0) {
                            titleContentColor = AlertDialogDefaults.INSTANCE.getTitleContentColor(composerStartRestartGroup, 6);
                            i13 &= -15;
                        } else {
                            titleContentColor = j3;
                        }
                        if ((i3 & 2048) != 0) {
                            textContentColor = AlertDialogDefaults.INSTANCE.getTextContentColor(composerStartRestartGroup, 6);
                            i13 &= -113;
                        } else {
                            textContentColor = j5;
                        }
                        if (i14 != 0) {
                            fM2717getTonalElevationD9Ej5fM = AlertDialogDefaults.INSTANCE.m2717getTonalElevationD9Ej5fM();
                        } else {
                            fM2717getTonalElevationD9Ej5fM = f;
                        }
                        if (i17 != 0) {
                            dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                        } else {
                            dialogProperties3 = dialogProperties;
                        }
                        function15 = function8;
                        function16 = function9;
                        shape4 = shape2;
                        modifier4 = modifier2;
                        i18 = 94478519;
                        int i21115 = i4;
                        function17 = function7;
                        function18 = function14;
                        j10 = containerColor;
                        j11 = titleContentColor;
                        long j11112 = textContentColor;
                        i19 = i21115;
                        i20 = i13;
                        j12 = iconContentColor;
                        j13 = j11112;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(i18, i19, i20, "androidx.compose.material3.AlertDialog (AndroidAlertDialog.android.kt:46)");
                    }
                    composer2 = composerStartRestartGroup;
                    AlertDialogKt.m2726AlertDialogImplwrnwzgE(function0, function2, modifier4, function18, function17, function15, function16, shape4, j10, j12, j11, j13, fM2717getTonalElevationD9Ej5fM, dialogProperties3, composer2, i19 & 2147483646, i20 & 8190);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier4;
                    function10 = function18;
                    function11 = function17;
                    function12 = function15;
                    function13 = function16;
                    shape3 = shape4;
                    j8 = j10;
                    j9 = j12;
                    j6 = j11;
                    j7 = j13;
                    f2 = fM2717getTonalElevationD9Ej5fM;
                    dialogProperties2 = dialogProperties3;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    function10 = function3;
                    f2 = f;
                    dialogProperties2 = dialogProperties;
                    shape3 = shape2;
                    modifier3 = modifier2;
                    j6 = j3;
                    j7 = j5;
                    function11 = function7;
                    function12 = function8;
                    function13 = function9;
                    j8 = j;
                    j9 = j2;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.AndroidAlertDialog_androidKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return AndroidAlertDialog_androidKt.AlertDialog_Oix01E0$lambda$0(function0, function2, modifier3, function10, function11, function12, function13, shape3, j8, j9, j6, j7, f2, dialogProperties2, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i13 |= 3072;
            i17 = i16;
            if ((i4 & 306783379) == 306783378) {
                z = true;
            } else {
                z = true;
            }
            if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "62@4972L5,62@5027L14,62@5093L16,62@5162L17,62@5231L16");
                if ((i & 1) != 0) {
                    if (i25 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i5 != 0) {
                        function14 = null;
                    } else {
                        function14 = function3;
                    }
                    if (i7 != 0) {
                        function7 = null;
                    }
                    if (i9 != 0) {
                        function8 = null;
                    }
                    if (i11 != 0) {
                        function9 = null;
                    }
                    if ((i3 & 128) != 0) {
                        i4 &= -29360129;
                        shape2 = AlertDialogDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                    }
                    if ((i3 & 256) != 0) {
                        containerColor = AlertDialogDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        i4 &= -234881025;
                    } else {
                        containerColor = j;
                    }
                    if ((i3 & 512) != 0) {
                        iconContentColor = AlertDialogDefaults.INSTANCE.getIconContentColor(composerStartRestartGroup, 6);
                        i4 = (-1879048193) & i4;
                    } else {
                        iconContentColor = j2;
                    }
                    if ((i3 & 1024) != 0) {
                        titleContentColor = AlertDialogDefaults.INSTANCE.getTitleContentColor(composerStartRestartGroup, 6);
                        i13 &= -15;
                    } else {
                        titleContentColor = j3;
                    }
                    if ((i3 & 2048) != 0) {
                        textContentColor = AlertDialogDefaults.INSTANCE.getTextContentColor(composerStartRestartGroup, 6);
                        i13 &= -113;
                    } else {
                        textContentColor = j5;
                    }
                    if (i14 != 0) {
                        fM2717getTonalElevationD9Ej5fM = AlertDialogDefaults.INSTANCE.m2717getTonalElevationD9Ej5fM();
                    } else {
                        fM2717getTonalElevationD9Ej5fM = f;
                    }
                    if (i17 != 0) {
                        dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                    } else {
                        dialogProperties3 = dialogProperties;
                    }
                    function15 = function8;
                    function16 = function9;
                    shape4 = shape2;
                    modifier4 = modifier2;
                    i18 = 94478519;
                    int i21116 = i4;
                    function17 = function7;
                    function18 = function14;
                    j10 = containerColor;
                    j11 = titleContentColor;
                    long j11113 = textContentColor;
                    i19 = i21116;
                    i20 = i13;
                    j12 = iconContentColor;
                    j13 = j11113;
                } else {
                    if (i25 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i5 != 0) {
                        function14 = null;
                    } else {
                        function14 = function3;
                    }
                    if (i7 != 0) {
                        function7 = null;
                    }
                    if (i9 != 0) {
                        function8 = null;
                    }
                    if (i11 != 0) {
                        function9 = null;
                    }
                    if ((i3 & 128) != 0) {
                        i4 &= -29360129;
                        shape2 = AlertDialogDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                    }
                    if ((i3 & 256) != 0) {
                        containerColor = AlertDialogDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        i4 &= -234881025;
                    } else {
                        containerColor = j;
                    }
                    if ((i3 & 512) != 0) {
                        iconContentColor = AlertDialogDefaults.INSTANCE.getIconContentColor(composerStartRestartGroup, 6);
                        i4 = (-1879048193) & i4;
                    } else {
                        iconContentColor = j2;
                    }
                    if ((i3 & 1024) != 0) {
                        titleContentColor = AlertDialogDefaults.INSTANCE.getTitleContentColor(composerStartRestartGroup, 6);
                        i13 &= -15;
                    } else {
                        titleContentColor = j3;
                    }
                    if ((i3 & 2048) != 0) {
                        textContentColor = AlertDialogDefaults.INSTANCE.getTextContentColor(composerStartRestartGroup, 6);
                        i13 &= -113;
                    } else {
                        textContentColor = j5;
                    }
                    if (i14 != 0) {
                        fM2717getTonalElevationD9Ej5fM = AlertDialogDefaults.INSTANCE.m2717getTonalElevationD9Ej5fM();
                    } else {
                        fM2717getTonalElevationD9Ej5fM = f;
                    }
                    if (i17 != 0) {
                        dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                    } else {
                        dialogProperties3 = dialogProperties;
                    }
                    function15 = function8;
                    function16 = function9;
                    shape4 = shape2;
                    modifier4 = modifier2;
                    i18 = 94478519;
                    int i21117 = i4;
                    function17 = function7;
                    function18 = function14;
                    j10 = containerColor;
                    j11 = titleContentColor;
                    long j11114 = textContentColor;
                    i19 = i21117;
                    i20 = i13;
                    j12 = iconContentColor;
                    j13 = j11114;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(i18, i19, i20, "androidx.compose.material3.AlertDialog (AndroidAlertDialog.android.kt:46)");
                }
                composer2 = composerStartRestartGroup;
                AlertDialogKt.m2726AlertDialogImplwrnwzgE(function0, function2, modifier4, function18, function17, function15, function16, shape4, j10, j12, j11, j13, fM2717getTonalElevationD9Ej5fM, dialogProperties3, composer2, i19 & 2147483646, i20 & 8190);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier4;
                function10 = function18;
                function11 = function17;
                function12 = function15;
                function13 = function16;
                shape3 = shape4;
                j8 = j10;
                j9 = j12;
                j6 = j11;
                j7 = j13;
                f2 = fM2717getTonalElevationD9Ej5fM;
                dialogProperties2 = dialogProperties3;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                function10 = function3;
                f2 = f;
                dialogProperties2 = dialogProperties;
                shape3 = shape2;
                modifier3 = modifier2;
                j6 = j3;
                j7 = j5;
                function11 = function7;
                function12 = function8;
                function13 = function9;
                j8 = j;
                j9 = j2;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.AndroidAlertDialog_androidKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return AndroidAlertDialog_androidKt.AlertDialog_Oix01E0$lambda$0(function0, function2, modifier3, function10, function11, function12, function13, shape3, j8, j9, j6, j7, f2, dialogProperties2, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i4 |= 384;
        modifier2 = modifier;
        i5 = i3 & 8;
        if (i5 != 0) {
            if ((i & 3072) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i6 = 2048;
                } else {
                    i6 = 1024;
                }
                i4 |= i6;
            }
            i7 = i3 & 16;
            if (i7 != 0) {
                if ((i & 24576) == 0) {
                    function7 = function4;
                    if (composerStartRestartGroup.changedInstance(function7)) {
                        i8 = 16384;
                    } else {
                        i8 = 8192;
                    }
                    i4 |= i8;
                }
                i9 = i3 & 32;
                if (i9 != 0) {
                    i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    function8 = function5;
                } else {
                    function8 = function5;
                    if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                        if (composerStartRestartGroup.changedInstance(function8)) {
                            i10 = 131072;
                        } else {
                            i10 = 65536;
                        }
                        i4 |= i10;
                    }
                }
                i11 = i3 & 64;
                if (i11 != 0) {
                    i4 |= 1572864;
                    function9 = function6;
                } else {
                    function9 = function6;
                    if ((i & 1572864) == 0) {
                        if (composerStartRestartGroup.changedInstance(function9)) {
                            i12 = 1048576;
                        } else {
                            i12 = 524288;
                        }
                        i4 |= i12;
                    }
                }
                if ((i & 12582912) == 0) {
                    if ((i3 & 128) == 0) {
                        shape2 = shape;
                        if (composerStartRestartGroup.changed(shape2)) {
                        }
                        i4 |= i26;
                    } else {
                        shape2 = shape;
                    }
                    i4 |= i26;
                } else {
                    shape2 = shape;
                }
                if ((i & 100663296) != 0) {
                    if ((i3 & 256) == 0) {
                        i24 = 33554432;
                    } else {
                        i24 = 33554432;
                    }
                    i4 |= i24;
                }
                if ((805306368 & i) != 0) {
                    if ((i3 & 512) == 0) {
                        i23 = 268435456;
                    } else {
                        i23 = 268435456;
                    }
                    i4 |= i23;
                }
                if ((i2 & 6) == 0) {
                    if ((i3 & 1024) == 0) {
                        i22 = 2;
                    } else {
                        i22 = 2;
                    }
                    i13 = i2 | i22;
                } else {
                    i13 = i2;
                }
                if ((i2 & 48) == 0) {
                    j5 = j4;
                    if ((i3 & 2048) == 0) {
                        i21 = 16;
                    } else {
                        i21 = 16;
                    }
                    i13 |= i21;
                } else {
                    j5 = j4;
                }
                i14 = i3 & 4096;
                if (i14 != 0) {
                    if ((i2 & 384) == 0) {
                        if (composerStartRestartGroup.changed(f)) {
                            i15 = 256;
                        } else {
                            i15 = 128;
                        }
                        i13 |= i15;
                    }
                    i16 = i3 & 8192;
                    if (i16 != 0) {
                        i17 = i16;
                        if ((i2 & 3072) == 0) {
                            i13 |= composerStartRestartGroup.changed(dialogProperties) ? 2048 : 1024;
                        }
                        if ((i4 & 306783379) == 306783378) {
                            z = true;
                        } else {
                            z = true;
                        }
                        if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
                            composerStartRestartGroup.startDefaults();
                            ComposerKt.sourceInformation(composerStartRestartGroup, "62@4972L5,62@5027L14,62@5093L16,62@5162L17,62@5231L16");
                            if ((i & 1) != 0) {
                                if (i25 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                if (i5 != 0) {
                                    function14 = null;
                                } else {
                                    function14 = function3;
                                }
                                if (i7 != 0) {
                                    function7 = null;
                                }
                                if (i9 != 0) {
                                    function8 = null;
                                }
                                if (i11 != 0) {
                                    function9 = null;
                                }
                                if ((i3 & 128) != 0) {
                                    i4 &= -29360129;
                                    shape2 = AlertDialogDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                                }
                                if ((i3 & 256) != 0) {
                                    containerColor = AlertDialogDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                                    i4 &= -234881025;
                                } else {
                                    containerColor = j;
                                }
                                if ((i3 & 512) != 0) {
                                    iconContentColor = AlertDialogDefaults.INSTANCE.getIconContentColor(composerStartRestartGroup, 6);
                                    i4 = (-1879048193) & i4;
                                } else {
                                    iconContentColor = j2;
                                }
                                if ((i3 & 1024) != 0) {
                                    titleContentColor = AlertDialogDefaults.INSTANCE.getTitleContentColor(composerStartRestartGroup, 6);
                                    i13 &= -15;
                                } else {
                                    titleContentColor = j3;
                                }
                                if ((i3 & 2048) != 0) {
                                    textContentColor = AlertDialogDefaults.INSTANCE.getTextContentColor(composerStartRestartGroup, 6);
                                    i13 &= -113;
                                } else {
                                    textContentColor = j5;
                                }
                                if (i14 != 0) {
                                    fM2717getTonalElevationD9Ej5fM = AlertDialogDefaults.INSTANCE.m2717getTonalElevationD9Ej5fM();
                                } else {
                                    fM2717getTonalElevationD9Ej5fM = f;
                                }
                                if (i17 != 0) {
                                    dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                                } else {
                                    dialogProperties3 = dialogProperties;
                                }
                                function15 = function8;
                                function16 = function9;
                                shape4 = shape2;
                                modifier4 = modifier2;
                                i18 = 94478519;
                                int i21118 = i4;
                                function17 = function7;
                                function18 = function14;
                                j10 = containerColor;
                                j11 = titleContentColor;
                                long j11115 = textContentColor;
                                i19 = i21118;
                                i20 = i13;
                                j12 = iconContentColor;
                                j13 = j11115;
                            } else {
                                if (i25 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                if (i5 != 0) {
                                    function14 = null;
                                } else {
                                    function14 = function3;
                                }
                                if (i7 != 0) {
                                    function7 = null;
                                }
                                if (i9 != 0) {
                                    function8 = null;
                                }
                                if (i11 != 0) {
                                    function9 = null;
                                }
                                if ((i3 & 128) != 0) {
                                    i4 &= -29360129;
                                    shape2 = AlertDialogDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                                }
                                if ((i3 & 256) != 0) {
                                    containerColor = AlertDialogDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                                    i4 &= -234881025;
                                } else {
                                    containerColor = j;
                                }
                                if ((i3 & 512) != 0) {
                                    iconContentColor = AlertDialogDefaults.INSTANCE.getIconContentColor(composerStartRestartGroup, 6);
                                    i4 = (-1879048193) & i4;
                                } else {
                                    iconContentColor = j2;
                                }
                                if ((i3 & 1024) != 0) {
                                    titleContentColor = AlertDialogDefaults.INSTANCE.getTitleContentColor(composerStartRestartGroup, 6);
                                    i13 &= -15;
                                } else {
                                    titleContentColor = j3;
                                }
                                if ((i3 & 2048) != 0) {
                                    textContentColor = AlertDialogDefaults.INSTANCE.getTextContentColor(composerStartRestartGroup, 6);
                                    i13 &= -113;
                                } else {
                                    textContentColor = j5;
                                }
                                if (i14 != 0) {
                                    fM2717getTonalElevationD9Ej5fM = AlertDialogDefaults.INSTANCE.m2717getTonalElevationD9Ej5fM();
                                } else {
                                    fM2717getTonalElevationD9Ej5fM = f;
                                }
                                if (i17 != 0) {
                                    dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                                } else {
                                    dialogProperties3 = dialogProperties;
                                }
                                function15 = function8;
                                function16 = function9;
                                shape4 = shape2;
                                modifier4 = modifier2;
                                i18 = 94478519;
                                int i21119 = i4;
                                function17 = function7;
                                function18 = function14;
                                j10 = containerColor;
                                j11 = titleContentColor;
                                long j11116 = textContentColor;
                                i19 = i21119;
                                i20 = i13;
                                j12 = iconContentColor;
                                j13 = j11116;
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(i18, i19, i20, "androidx.compose.material3.AlertDialog (AndroidAlertDialog.android.kt:46)");
                            }
                            composer2 = composerStartRestartGroup;
                            AlertDialogKt.m2726AlertDialogImplwrnwzgE(function0, function2, modifier4, function18, function17, function15, function16, shape4, j10, j12, j11, j13, fM2717getTonalElevationD9Ej5fM, dialogProperties3, composer2, i19 & 2147483646, i20 & 8190);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier3 = modifier4;
                            function10 = function18;
                            function11 = function17;
                            function12 = function15;
                            function13 = function16;
                            shape3 = shape4;
                            j8 = j10;
                            j9 = j12;
                            j6 = j11;
                            j7 = j13;
                            f2 = fM2717getTonalElevationD9Ej5fM;
                            dialogProperties2 = dialogProperties3;
                        } else {
                            composer2 = composerStartRestartGroup;
                            composer2.skipToGroupEnd();
                            function10 = function3;
                            f2 = f;
                            dialogProperties2 = dialogProperties;
                            shape3 = shape2;
                            modifier3 = modifier2;
                            j6 = j3;
                            j7 = j5;
                            function11 = function7;
                            function12 = function8;
                            function13 = function9;
                            j8 = j;
                            j9 = j2;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.AndroidAlertDialog_androidKt$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return AndroidAlertDialog_androidKt.AlertDialog_Oix01E0$lambda$0(function0, function2, modifier3, function10, function11, function12, function13, shape3, j8, j9, j6, j7, f2, dialogProperties2, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                        }
                    }
                    i13 |= 3072;
                    i17 = i16;
                    if ((i4 & 306783379) == 306783378) {
                        z = true;
                    } else {
                        z = true;
                    }
                    if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "62@4972L5,62@5027L14,62@5093L16,62@5162L17,62@5231L16");
                        if ((i & 1) != 0) {
                            if (i25 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i5 != 0) {
                                function14 = null;
                            } else {
                                function14 = function3;
                            }
                            if (i7 != 0) {
                                function7 = null;
                            }
                            if (i9 != 0) {
                                function8 = null;
                            }
                            if (i11 != 0) {
                                function9 = null;
                            }
                            if ((i3 & 128) != 0) {
                                i4 &= -29360129;
                                shape2 = AlertDialogDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                            }
                            if ((i3 & 256) != 0) {
                                containerColor = AlertDialogDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                                i4 &= -234881025;
                            } else {
                                containerColor = j;
                            }
                            if ((i3 & 512) != 0) {
                                iconContentColor = AlertDialogDefaults.INSTANCE.getIconContentColor(composerStartRestartGroup, 6);
                                i4 = (-1879048193) & i4;
                            } else {
                                iconContentColor = j2;
                            }
                            if ((i3 & 1024) != 0) {
                                titleContentColor = AlertDialogDefaults.INSTANCE.getTitleContentColor(composerStartRestartGroup, 6);
                                i13 &= -15;
                            } else {
                                titleContentColor = j3;
                            }
                            if ((i3 & 2048) != 0) {
                                textContentColor = AlertDialogDefaults.INSTANCE.getTextContentColor(composerStartRestartGroup, 6);
                                i13 &= -113;
                            } else {
                                textContentColor = j5;
                            }
                            if (i14 != 0) {
                                fM2717getTonalElevationD9Ej5fM = AlertDialogDefaults.INSTANCE.m2717getTonalElevationD9Ej5fM();
                            } else {
                                fM2717getTonalElevationD9Ej5fM = f;
                            }
                            if (i17 != 0) {
                                dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                            } else {
                                dialogProperties3 = dialogProperties;
                            }
                            function15 = function8;
                            function16 = function9;
                            shape4 = shape2;
                            modifier4 = modifier2;
                            i18 = 94478519;
                            int i211110 = i4;
                            function17 = function7;
                            function18 = function14;
                            j10 = containerColor;
                            j11 = titleContentColor;
                            long j11117 = textContentColor;
                            i19 = i211110;
                            i20 = i13;
                            j12 = iconContentColor;
                            j13 = j11117;
                        } else {
                            if (i25 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i5 != 0) {
                                function14 = null;
                            } else {
                                function14 = function3;
                            }
                            if (i7 != 0) {
                                function7 = null;
                            }
                            if (i9 != 0) {
                                function8 = null;
                            }
                            if (i11 != 0) {
                                function9 = null;
                            }
                            if ((i3 & 128) != 0) {
                                i4 &= -29360129;
                                shape2 = AlertDialogDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                            }
                            if ((i3 & 256) != 0) {
                                containerColor = AlertDialogDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                                i4 &= -234881025;
                            } else {
                                containerColor = j;
                            }
                            if ((i3 & 512) != 0) {
                                iconContentColor = AlertDialogDefaults.INSTANCE.getIconContentColor(composerStartRestartGroup, 6);
                                i4 = (-1879048193) & i4;
                            } else {
                                iconContentColor = j2;
                            }
                            if ((i3 & 1024) != 0) {
                                titleContentColor = AlertDialogDefaults.INSTANCE.getTitleContentColor(composerStartRestartGroup, 6);
                                i13 &= -15;
                            } else {
                                titleContentColor = j3;
                            }
                            if ((i3 & 2048) != 0) {
                                textContentColor = AlertDialogDefaults.INSTANCE.getTextContentColor(composerStartRestartGroup, 6);
                                i13 &= -113;
                            } else {
                                textContentColor = j5;
                            }
                            if (i14 != 0) {
                                fM2717getTonalElevationD9Ej5fM = AlertDialogDefaults.INSTANCE.m2717getTonalElevationD9Ej5fM();
                            } else {
                                fM2717getTonalElevationD9Ej5fM = f;
                            }
                            if (i17 != 0) {
                                dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                            } else {
                                dialogProperties3 = dialogProperties;
                            }
                            function15 = function8;
                            function16 = function9;
                            shape4 = shape2;
                            modifier4 = modifier2;
                            i18 = 94478519;
                            int i211111 = i4;
                            function17 = function7;
                            function18 = function14;
                            j10 = containerColor;
                            j11 = titleContentColor;
                            long j11118 = textContentColor;
                            i19 = i211111;
                            i20 = i13;
                            j12 = iconContentColor;
                            j13 = j11118;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(i18, i19, i20, "androidx.compose.material3.AlertDialog (AndroidAlertDialog.android.kt:46)");
                        }
                        composer2 = composerStartRestartGroup;
                        AlertDialogKt.m2726AlertDialogImplwrnwzgE(function0, function2, modifier4, function18, function17, function15, function16, shape4, j10, j12, j11, j13, fM2717getTonalElevationD9Ej5fM, dialogProperties3, composer2, i19 & 2147483646, i20 & 8190);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier4;
                        function10 = function18;
                        function11 = function17;
                        function12 = function15;
                        function13 = function16;
                        shape3 = shape4;
                        j8 = j10;
                        j9 = j12;
                        j6 = j11;
                        j7 = j13;
                        f2 = fM2717getTonalElevationD9Ej5fM;
                        dialogProperties2 = dialogProperties3;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        function10 = function3;
                        f2 = f;
                        dialogProperties2 = dialogProperties;
                        shape3 = shape2;
                        modifier3 = modifier2;
                        j6 = j3;
                        j7 = j5;
                        function11 = function7;
                        function12 = function8;
                        function13 = function9;
                        j8 = j;
                        j9 = j2;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.AndroidAlertDialog_androidKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return AndroidAlertDialog_androidKt.AlertDialog_Oix01E0$lambda$0(function0, function2, modifier3, function10, function11, function12, function13, shape3, j8, j9, j6, j7, f2, dialogProperties2, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i13 |= 384;
                i16 = i3 & 8192;
                if (i16 != 0) {
                    i17 = i16;
                    if ((i2 & 3072) == 0) {
                        i13 |= composerStartRestartGroup.changed(dialogProperties) ? 2048 : 1024;
                    }
                    if ((i4 & 306783379) == 306783378) {
                        z = true;
                    } else {
                        z = true;
                    }
                    if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "62@4972L5,62@5027L14,62@5093L16,62@5162L17,62@5231L16");
                        if ((i & 1) != 0) {
                            if (i25 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i5 != 0) {
                                function14 = null;
                            } else {
                                function14 = function3;
                            }
                            if (i7 != 0) {
                                function7 = null;
                            }
                            if (i9 != 0) {
                                function8 = null;
                            }
                            if (i11 != 0) {
                                function9 = null;
                            }
                            if ((i3 & 128) != 0) {
                                i4 &= -29360129;
                                shape2 = AlertDialogDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                            }
                            if ((i3 & 256) != 0) {
                                containerColor = AlertDialogDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                                i4 &= -234881025;
                            } else {
                                containerColor = j;
                            }
                            if ((i3 & 512) != 0) {
                                iconContentColor = AlertDialogDefaults.INSTANCE.getIconContentColor(composerStartRestartGroup, 6);
                                i4 = (-1879048193) & i4;
                            } else {
                                iconContentColor = j2;
                            }
                            if ((i3 & 1024) != 0) {
                                titleContentColor = AlertDialogDefaults.INSTANCE.getTitleContentColor(composerStartRestartGroup, 6);
                                i13 &= -15;
                            } else {
                                titleContentColor = j3;
                            }
                            if ((i3 & 2048) != 0) {
                                textContentColor = AlertDialogDefaults.INSTANCE.getTextContentColor(composerStartRestartGroup, 6);
                                i13 &= -113;
                            } else {
                                textContentColor = j5;
                            }
                            if (i14 != 0) {
                                fM2717getTonalElevationD9Ej5fM = AlertDialogDefaults.INSTANCE.m2717getTonalElevationD9Ej5fM();
                            } else {
                                fM2717getTonalElevationD9Ej5fM = f;
                            }
                            if (i17 != 0) {
                                dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                            } else {
                                dialogProperties3 = dialogProperties;
                            }
                            function15 = function8;
                            function16 = function9;
                            shape4 = shape2;
                            modifier4 = modifier2;
                            i18 = 94478519;
                            int i211112 = i4;
                            function17 = function7;
                            function18 = function14;
                            j10 = containerColor;
                            j11 = titleContentColor;
                            long j11119 = textContentColor;
                            i19 = i211112;
                            i20 = i13;
                            j12 = iconContentColor;
                            j13 = j11119;
                        } else {
                            if (i25 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i5 != 0) {
                                function14 = null;
                            } else {
                                function14 = function3;
                            }
                            if (i7 != 0) {
                                function7 = null;
                            }
                            if (i9 != 0) {
                                function8 = null;
                            }
                            if (i11 != 0) {
                                function9 = null;
                            }
                            if ((i3 & 128) != 0) {
                                i4 &= -29360129;
                                shape2 = AlertDialogDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                            }
                            if ((i3 & 256) != 0) {
                                containerColor = AlertDialogDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                                i4 &= -234881025;
                            } else {
                                containerColor = j;
                            }
                            if ((i3 & 512) != 0) {
                                iconContentColor = AlertDialogDefaults.INSTANCE.getIconContentColor(composerStartRestartGroup, 6);
                                i4 = (-1879048193) & i4;
                            } else {
                                iconContentColor = j2;
                            }
                            if ((i3 & 1024) != 0) {
                                titleContentColor = AlertDialogDefaults.INSTANCE.getTitleContentColor(composerStartRestartGroup, 6);
                                i13 &= -15;
                            } else {
                                titleContentColor = j3;
                            }
                            if ((i3 & 2048) != 0) {
                                textContentColor = AlertDialogDefaults.INSTANCE.getTextContentColor(composerStartRestartGroup, 6);
                                i13 &= -113;
                            } else {
                                textContentColor = j5;
                            }
                            if (i14 != 0) {
                                fM2717getTonalElevationD9Ej5fM = AlertDialogDefaults.INSTANCE.m2717getTonalElevationD9Ej5fM();
                            } else {
                                fM2717getTonalElevationD9Ej5fM = f;
                            }
                            if (i17 != 0) {
                                dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                            } else {
                                dialogProperties3 = dialogProperties;
                            }
                            function15 = function8;
                            function16 = function9;
                            shape4 = shape2;
                            modifier4 = modifier2;
                            i18 = 94478519;
                            int i211113 = i4;
                            function17 = function7;
                            function18 = function14;
                            j10 = containerColor;
                            j11 = titleContentColor;
                            long j111110 = textContentColor;
                            i19 = i211113;
                            i20 = i13;
                            j12 = iconContentColor;
                            j13 = j111110;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(i18, i19, i20, "androidx.compose.material3.AlertDialog (AndroidAlertDialog.android.kt:46)");
                        }
                        composer2 = composerStartRestartGroup;
                        AlertDialogKt.m2726AlertDialogImplwrnwzgE(function0, function2, modifier4, function18, function17, function15, function16, shape4, j10, j12, j11, j13, fM2717getTonalElevationD9Ej5fM, dialogProperties3, composer2, i19 & 2147483646, i20 & 8190);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier4;
                        function10 = function18;
                        function11 = function17;
                        function12 = function15;
                        function13 = function16;
                        shape3 = shape4;
                        j8 = j10;
                        j9 = j12;
                        j6 = j11;
                        j7 = j13;
                        f2 = fM2717getTonalElevationD9Ej5fM;
                        dialogProperties2 = dialogProperties3;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        function10 = function3;
                        f2 = f;
                        dialogProperties2 = dialogProperties;
                        shape3 = shape2;
                        modifier3 = modifier2;
                        j6 = j3;
                        j7 = j5;
                        function11 = function7;
                        function12 = function8;
                        function13 = function9;
                        j8 = j;
                        j9 = j2;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.AndroidAlertDialog_androidKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return AndroidAlertDialog_androidKt.AlertDialog_Oix01E0$lambda$0(function0, function2, modifier3, function10, function11, function12, function13, shape3, j8, j9, j6, j7, f2, dialogProperties2, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i13 |= 3072;
                i17 = i16;
                if ((i4 & 306783379) == 306783378) {
                    z = true;
                } else {
                    z = true;
                }
                if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "62@4972L5,62@5027L14,62@5093L16,62@5162L17,62@5231L16");
                    if ((i & 1) != 0) {
                        if (i25 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i5 != 0) {
                            function14 = null;
                        } else {
                            function14 = function3;
                        }
                        if (i7 != 0) {
                            function7 = null;
                        }
                        if (i9 != 0) {
                            function8 = null;
                        }
                        if (i11 != 0) {
                            function9 = null;
                        }
                        if ((i3 & 128) != 0) {
                            i4 &= -29360129;
                            shape2 = AlertDialogDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                        }
                        if ((i3 & 256) != 0) {
                            containerColor = AlertDialogDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                            i4 &= -234881025;
                        } else {
                            containerColor = j;
                        }
                        if ((i3 & 512) != 0) {
                            iconContentColor = AlertDialogDefaults.INSTANCE.getIconContentColor(composerStartRestartGroup, 6);
                            i4 = (-1879048193) & i4;
                        } else {
                            iconContentColor = j2;
                        }
                        if ((i3 & 1024) != 0) {
                            titleContentColor = AlertDialogDefaults.INSTANCE.getTitleContentColor(composerStartRestartGroup, 6);
                            i13 &= -15;
                        } else {
                            titleContentColor = j3;
                        }
                        if ((i3 & 2048) != 0) {
                            textContentColor = AlertDialogDefaults.INSTANCE.getTextContentColor(composerStartRestartGroup, 6);
                            i13 &= -113;
                        } else {
                            textContentColor = j5;
                        }
                        if (i14 != 0) {
                            fM2717getTonalElevationD9Ej5fM = AlertDialogDefaults.INSTANCE.m2717getTonalElevationD9Ej5fM();
                        } else {
                            fM2717getTonalElevationD9Ej5fM = f;
                        }
                        if (i17 != 0) {
                            dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                        } else {
                            dialogProperties3 = dialogProperties;
                        }
                        function15 = function8;
                        function16 = function9;
                        shape4 = shape2;
                        modifier4 = modifier2;
                        i18 = 94478519;
                        int i211114 = i4;
                        function17 = function7;
                        function18 = function14;
                        j10 = containerColor;
                        j11 = titleContentColor;
                        long j111111 = textContentColor;
                        i19 = i211114;
                        i20 = i13;
                        j12 = iconContentColor;
                        j13 = j111111;
                    } else {
                        if (i25 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i5 != 0) {
                            function14 = null;
                        } else {
                            function14 = function3;
                        }
                        if (i7 != 0) {
                            function7 = null;
                        }
                        if (i9 != 0) {
                            function8 = null;
                        }
                        if (i11 != 0) {
                            function9 = null;
                        }
                        if ((i3 & 128) != 0) {
                            i4 &= -29360129;
                            shape2 = AlertDialogDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                        }
                        if ((i3 & 256) != 0) {
                            containerColor = AlertDialogDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                            i4 &= -234881025;
                        } else {
                            containerColor = j;
                        }
                        if ((i3 & 512) != 0) {
                            iconContentColor = AlertDialogDefaults.INSTANCE.getIconContentColor(composerStartRestartGroup, 6);
                            i4 = (-1879048193) & i4;
                        } else {
                            iconContentColor = j2;
                        }
                        if ((i3 & 1024) != 0) {
                            titleContentColor = AlertDialogDefaults.INSTANCE.getTitleContentColor(composerStartRestartGroup, 6);
                            i13 &= -15;
                        } else {
                            titleContentColor = j3;
                        }
                        if ((i3 & 2048) != 0) {
                            textContentColor = AlertDialogDefaults.INSTANCE.getTextContentColor(composerStartRestartGroup, 6);
                            i13 &= -113;
                        } else {
                            textContentColor = j5;
                        }
                        if (i14 != 0) {
                            fM2717getTonalElevationD9Ej5fM = AlertDialogDefaults.INSTANCE.m2717getTonalElevationD9Ej5fM();
                        } else {
                            fM2717getTonalElevationD9Ej5fM = f;
                        }
                        if (i17 != 0) {
                            dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                        } else {
                            dialogProperties3 = dialogProperties;
                        }
                        function15 = function8;
                        function16 = function9;
                        shape4 = shape2;
                        modifier4 = modifier2;
                        i18 = 94478519;
                        int i211115 = i4;
                        function17 = function7;
                        function18 = function14;
                        j10 = containerColor;
                        j11 = titleContentColor;
                        long j111112 = textContentColor;
                        i19 = i211115;
                        i20 = i13;
                        j12 = iconContentColor;
                        j13 = j111112;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(i18, i19, i20, "androidx.compose.material3.AlertDialog (AndroidAlertDialog.android.kt:46)");
                    }
                    composer2 = composerStartRestartGroup;
                    AlertDialogKt.m2726AlertDialogImplwrnwzgE(function0, function2, modifier4, function18, function17, function15, function16, shape4, j10, j12, j11, j13, fM2717getTonalElevationD9Ej5fM, dialogProperties3, composer2, i19 & 2147483646, i20 & 8190);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier4;
                    function10 = function18;
                    function11 = function17;
                    function12 = function15;
                    function13 = function16;
                    shape3 = shape4;
                    j8 = j10;
                    j9 = j12;
                    j6 = j11;
                    j7 = j13;
                    f2 = fM2717getTonalElevationD9Ej5fM;
                    dialogProperties2 = dialogProperties3;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    function10 = function3;
                    f2 = f;
                    dialogProperties2 = dialogProperties;
                    shape3 = shape2;
                    modifier3 = modifier2;
                    j6 = j3;
                    j7 = j5;
                    function11 = function7;
                    function12 = function8;
                    function13 = function9;
                    j8 = j;
                    j9 = j2;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.AndroidAlertDialog_androidKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return AndroidAlertDialog_androidKt.AlertDialog_Oix01E0$lambda$0(function0, function2, modifier3, function10, function11, function12, function13, shape3, j8, j9, j6, j7, f2, dialogProperties2, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i4 |= 24576;
            function7 = function4;
            i9 = i3 & 32;
            if (i9 != 0) {
                i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                function8 = function5;
            } else {
                function8 = function5;
                if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    if (composerStartRestartGroup.changedInstance(function8)) {
                        i10 = 131072;
                    } else {
                        i10 = 65536;
                    }
                    i4 |= i10;
                }
            }
            i11 = i3 & 64;
            if (i11 != 0) {
                i4 |= 1572864;
                function9 = function6;
            } else {
                function9 = function6;
                if ((i & 1572864) == 0) {
                    if (composerStartRestartGroup.changedInstance(function9)) {
                        i12 = 1048576;
                    } else {
                        i12 = 524288;
                    }
                    i4 |= i12;
                }
            }
            if ((i & 12582912) == 0) {
                if ((i3 & 128) == 0) {
                    shape2 = shape;
                    if (composerStartRestartGroup.changed(shape2)) {
                    }
                    i4 |= i26;
                } else {
                    shape2 = shape;
                }
                i4 |= i26;
            } else {
                shape2 = shape;
            }
            if ((i & 100663296) != 0) {
                if ((i3 & 256) == 0) {
                    i24 = 33554432;
                } else {
                    i24 = 33554432;
                }
                i4 |= i24;
            }
            if ((805306368 & i) != 0) {
                if ((i3 & 512) == 0) {
                    i23 = 268435456;
                } else {
                    i23 = 268435456;
                }
                i4 |= i23;
            }
            if ((i2 & 6) == 0) {
                if ((i3 & 1024) == 0) {
                    i22 = 2;
                } else {
                    i22 = 2;
                }
                i13 = i2 | i22;
            } else {
                i13 = i2;
            }
            if ((i2 & 48) == 0) {
                j5 = j4;
                if ((i3 & 2048) == 0) {
                    i21 = 16;
                } else {
                    i21 = 16;
                }
                i13 |= i21;
            } else {
                j5 = j4;
            }
            i14 = i3 & 4096;
            if (i14 != 0) {
                if ((i2 & 384) == 0) {
                    if (composerStartRestartGroup.changed(f)) {
                        i15 = 256;
                    } else {
                        i15 = 128;
                    }
                    i13 |= i15;
                }
                i16 = i3 & 8192;
                if (i16 != 0) {
                    i17 = i16;
                    if ((i2 & 3072) == 0) {
                        i13 |= composerStartRestartGroup.changed(dialogProperties) ? 2048 : 1024;
                    }
                    if ((i4 & 306783379) == 306783378) {
                        z = true;
                    } else {
                        z = true;
                    }
                    if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "62@4972L5,62@5027L14,62@5093L16,62@5162L17,62@5231L16");
                        if ((i & 1) != 0) {
                            if (i25 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i5 != 0) {
                                function14 = null;
                            } else {
                                function14 = function3;
                            }
                            if (i7 != 0) {
                                function7 = null;
                            }
                            if (i9 != 0) {
                                function8 = null;
                            }
                            if (i11 != 0) {
                                function9 = null;
                            }
                            if ((i3 & 128) != 0) {
                                i4 &= -29360129;
                                shape2 = AlertDialogDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                            }
                            if ((i3 & 256) != 0) {
                                containerColor = AlertDialogDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                                i4 &= -234881025;
                            } else {
                                containerColor = j;
                            }
                            if ((i3 & 512) != 0) {
                                iconContentColor = AlertDialogDefaults.INSTANCE.getIconContentColor(composerStartRestartGroup, 6);
                                i4 = (-1879048193) & i4;
                            } else {
                                iconContentColor = j2;
                            }
                            if ((i3 & 1024) != 0) {
                                titleContentColor = AlertDialogDefaults.INSTANCE.getTitleContentColor(composerStartRestartGroup, 6);
                                i13 &= -15;
                            } else {
                                titleContentColor = j3;
                            }
                            if ((i3 & 2048) != 0) {
                                textContentColor = AlertDialogDefaults.INSTANCE.getTextContentColor(composerStartRestartGroup, 6);
                                i13 &= -113;
                            } else {
                                textContentColor = j5;
                            }
                            if (i14 != 0) {
                                fM2717getTonalElevationD9Ej5fM = AlertDialogDefaults.INSTANCE.m2717getTonalElevationD9Ej5fM();
                            } else {
                                fM2717getTonalElevationD9Ej5fM = f;
                            }
                            if (i17 != 0) {
                                dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                            } else {
                                dialogProperties3 = dialogProperties;
                            }
                            function15 = function8;
                            function16 = function9;
                            shape4 = shape2;
                            modifier4 = modifier2;
                            i18 = 94478519;
                            int i211116 = i4;
                            function17 = function7;
                            function18 = function14;
                            j10 = containerColor;
                            j11 = titleContentColor;
                            long j111113 = textContentColor;
                            i19 = i211116;
                            i20 = i13;
                            j12 = iconContentColor;
                            j13 = j111113;
                        } else {
                            if (i25 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i5 != 0) {
                                function14 = null;
                            } else {
                                function14 = function3;
                            }
                            if (i7 != 0) {
                                function7 = null;
                            }
                            if (i9 != 0) {
                                function8 = null;
                            }
                            if (i11 != 0) {
                                function9 = null;
                            }
                            if ((i3 & 128) != 0) {
                                i4 &= -29360129;
                                shape2 = AlertDialogDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                            }
                            if ((i3 & 256) != 0) {
                                containerColor = AlertDialogDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                                i4 &= -234881025;
                            } else {
                                containerColor = j;
                            }
                            if ((i3 & 512) != 0) {
                                iconContentColor = AlertDialogDefaults.INSTANCE.getIconContentColor(composerStartRestartGroup, 6);
                                i4 = (-1879048193) & i4;
                            } else {
                                iconContentColor = j2;
                            }
                            if ((i3 & 1024) != 0) {
                                titleContentColor = AlertDialogDefaults.INSTANCE.getTitleContentColor(composerStartRestartGroup, 6);
                                i13 &= -15;
                            } else {
                                titleContentColor = j3;
                            }
                            if ((i3 & 2048) != 0) {
                                textContentColor = AlertDialogDefaults.INSTANCE.getTextContentColor(composerStartRestartGroup, 6);
                                i13 &= -113;
                            } else {
                                textContentColor = j5;
                            }
                            if (i14 != 0) {
                                fM2717getTonalElevationD9Ej5fM = AlertDialogDefaults.INSTANCE.m2717getTonalElevationD9Ej5fM();
                            } else {
                                fM2717getTonalElevationD9Ej5fM = f;
                            }
                            if (i17 != 0) {
                                dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                            } else {
                                dialogProperties3 = dialogProperties;
                            }
                            function15 = function8;
                            function16 = function9;
                            shape4 = shape2;
                            modifier4 = modifier2;
                            i18 = 94478519;
                            int i211117 = i4;
                            function17 = function7;
                            function18 = function14;
                            j10 = containerColor;
                            j11 = titleContentColor;
                            long j111114 = textContentColor;
                            i19 = i211117;
                            i20 = i13;
                            j12 = iconContentColor;
                            j13 = j111114;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(i18, i19, i20, "androidx.compose.material3.AlertDialog (AndroidAlertDialog.android.kt:46)");
                        }
                        composer2 = composerStartRestartGroup;
                        AlertDialogKt.m2726AlertDialogImplwrnwzgE(function0, function2, modifier4, function18, function17, function15, function16, shape4, j10, j12, j11, j13, fM2717getTonalElevationD9Ej5fM, dialogProperties3, composer2, i19 & 2147483646, i20 & 8190);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier4;
                        function10 = function18;
                        function11 = function17;
                        function12 = function15;
                        function13 = function16;
                        shape3 = shape4;
                        j8 = j10;
                        j9 = j12;
                        j6 = j11;
                        j7 = j13;
                        f2 = fM2717getTonalElevationD9Ej5fM;
                        dialogProperties2 = dialogProperties3;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        function10 = function3;
                        f2 = f;
                        dialogProperties2 = dialogProperties;
                        shape3 = shape2;
                        modifier3 = modifier2;
                        j6 = j3;
                        j7 = j5;
                        function11 = function7;
                        function12 = function8;
                        function13 = function9;
                        j8 = j;
                        j9 = j2;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.AndroidAlertDialog_androidKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return AndroidAlertDialog_androidKt.AlertDialog_Oix01E0$lambda$0(function0, function2, modifier3, function10, function11, function12, function13, shape3, j8, j9, j6, j7, f2, dialogProperties2, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i13 |= 3072;
                i17 = i16;
                if ((i4 & 306783379) == 306783378) {
                    z = true;
                } else {
                    z = true;
                }
                if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "62@4972L5,62@5027L14,62@5093L16,62@5162L17,62@5231L16");
                    if ((i & 1) != 0) {
                        if (i25 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i5 != 0) {
                            function14 = null;
                        } else {
                            function14 = function3;
                        }
                        if (i7 != 0) {
                            function7 = null;
                        }
                        if (i9 != 0) {
                            function8 = null;
                        }
                        if (i11 != 0) {
                            function9 = null;
                        }
                        if ((i3 & 128) != 0) {
                            i4 &= -29360129;
                            shape2 = AlertDialogDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                        }
                        if ((i3 & 256) != 0) {
                            containerColor = AlertDialogDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                            i4 &= -234881025;
                        } else {
                            containerColor = j;
                        }
                        if ((i3 & 512) != 0) {
                            iconContentColor = AlertDialogDefaults.INSTANCE.getIconContentColor(composerStartRestartGroup, 6);
                            i4 = (-1879048193) & i4;
                        } else {
                            iconContentColor = j2;
                        }
                        if ((i3 & 1024) != 0) {
                            titleContentColor = AlertDialogDefaults.INSTANCE.getTitleContentColor(composerStartRestartGroup, 6);
                            i13 &= -15;
                        } else {
                            titleContentColor = j3;
                        }
                        if ((i3 & 2048) != 0) {
                            textContentColor = AlertDialogDefaults.INSTANCE.getTextContentColor(composerStartRestartGroup, 6);
                            i13 &= -113;
                        } else {
                            textContentColor = j5;
                        }
                        if (i14 != 0) {
                            fM2717getTonalElevationD9Ej5fM = AlertDialogDefaults.INSTANCE.m2717getTonalElevationD9Ej5fM();
                        } else {
                            fM2717getTonalElevationD9Ej5fM = f;
                        }
                        if (i17 != 0) {
                            dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                        } else {
                            dialogProperties3 = dialogProperties;
                        }
                        function15 = function8;
                        function16 = function9;
                        shape4 = shape2;
                        modifier4 = modifier2;
                        i18 = 94478519;
                        int i211118 = i4;
                        function17 = function7;
                        function18 = function14;
                        j10 = containerColor;
                        j11 = titleContentColor;
                        long j111115 = textContentColor;
                        i19 = i211118;
                        i20 = i13;
                        j12 = iconContentColor;
                        j13 = j111115;
                    } else {
                        if (i25 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i5 != 0) {
                            function14 = null;
                        } else {
                            function14 = function3;
                        }
                        if (i7 != 0) {
                            function7 = null;
                        }
                        if (i9 != 0) {
                            function8 = null;
                        }
                        if (i11 != 0) {
                            function9 = null;
                        }
                        if ((i3 & 128) != 0) {
                            i4 &= -29360129;
                            shape2 = AlertDialogDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                        }
                        if ((i3 & 256) != 0) {
                            containerColor = AlertDialogDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                            i4 &= -234881025;
                        } else {
                            containerColor = j;
                        }
                        if ((i3 & 512) != 0) {
                            iconContentColor = AlertDialogDefaults.INSTANCE.getIconContentColor(composerStartRestartGroup, 6);
                            i4 = (-1879048193) & i4;
                        } else {
                            iconContentColor = j2;
                        }
                        if ((i3 & 1024) != 0) {
                            titleContentColor = AlertDialogDefaults.INSTANCE.getTitleContentColor(composerStartRestartGroup, 6);
                            i13 &= -15;
                        } else {
                            titleContentColor = j3;
                        }
                        if ((i3 & 2048) != 0) {
                            textContentColor = AlertDialogDefaults.INSTANCE.getTextContentColor(composerStartRestartGroup, 6);
                            i13 &= -113;
                        } else {
                            textContentColor = j5;
                        }
                        if (i14 != 0) {
                            fM2717getTonalElevationD9Ej5fM = AlertDialogDefaults.INSTANCE.m2717getTonalElevationD9Ej5fM();
                        } else {
                            fM2717getTonalElevationD9Ej5fM = f;
                        }
                        if (i17 != 0) {
                            dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                        } else {
                            dialogProperties3 = dialogProperties;
                        }
                        function15 = function8;
                        function16 = function9;
                        shape4 = shape2;
                        modifier4 = modifier2;
                        i18 = 94478519;
                        int i211119 = i4;
                        function17 = function7;
                        function18 = function14;
                        j10 = containerColor;
                        j11 = titleContentColor;
                        long j111116 = textContentColor;
                        i19 = i211119;
                        i20 = i13;
                        j12 = iconContentColor;
                        j13 = j111116;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(i18, i19, i20, "androidx.compose.material3.AlertDialog (AndroidAlertDialog.android.kt:46)");
                    }
                    composer2 = composerStartRestartGroup;
                    AlertDialogKt.m2726AlertDialogImplwrnwzgE(function0, function2, modifier4, function18, function17, function15, function16, shape4, j10, j12, j11, j13, fM2717getTonalElevationD9Ej5fM, dialogProperties3, composer2, i19 & 2147483646, i20 & 8190);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier4;
                    function10 = function18;
                    function11 = function17;
                    function12 = function15;
                    function13 = function16;
                    shape3 = shape4;
                    j8 = j10;
                    j9 = j12;
                    j6 = j11;
                    j7 = j13;
                    f2 = fM2717getTonalElevationD9Ej5fM;
                    dialogProperties2 = dialogProperties3;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    function10 = function3;
                    f2 = f;
                    dialogProperties2 = dialogProperties;
                    shape3 = shape2;
                    modifier3 = modifier2;
                    j6 = j3;
                    j7 = j5;
                    function11 = function7;
                    function12 = function8;
                    function13 = function9;
                    j8 = j;
                    j9 = j2;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.AndroidAlertDialog_androidKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return AndroidAlertDialog_androidKt.AlertDialog_Oix01E0$lambda$0(function0, function2, modifier3, function10, function11, function12, function13, shape3, j8, j9, j6, j7, f2, dialogProperties2, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i13 |= 384;
            i16 = i3 & 8192;
            if (i16 != 0) {
                i17 = i16;
                if ((i2 & 3072) == 0) {
                    i13 |= composerStartRestartGroup.changed(dialogProperties) ? 2048 : 1024;
                }
                if ((i4 & 306783379) == 306783378) {
                    z = true;
                } else {
                    z = true;
                }
                if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "62@4972L5,62@5027L14,62@5093L16,62@5162L17,62@5231L16");
                    if ((i & 1) != 0) {
                        if (i25 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i5 != 0) {
                            function14 = null;
                        } else {
                            function14 = function3;
                        }
                        if (i7 != 0) {
                            function7 = null;
                        }
                        if (i9 != 0) {
                            function8 = null;
                        }
                        if (i11 != 0) {
                            function9 = null;
                        }
                        if ((i3 & 128) != 0) {
                            i4 &= -29360129;
                            shape2 = AlertDialogDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                        }
                        if ((i3 & 256) != 0) {
                            containerColor = AlertDialogDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                            i4 &= -234881025;
                        } else {
                            containerColor = j;
                        }
                        if ((i3 & 512) != 0) {
                            iconContentColor = AlertDialogDefaults.INSTANCE.getIconContentColor(composerStartRestartGroup, 6);
                            i4 = (-1879048193) & i4;
                        } else {
                            iconContentColor = j2;
                        }
                        if ((i3 & 1024) != 0) {
                            titleContentColor = AlertDialogDefaults.INSTANCE.getTitleContentColor(composerStartRestartGroup, 6);
                            i13 &= -15;
                        } else {
                            titleContentColor = j3;
                        }
                        if ((i3 & 2048) != 0) {
                            textContentColor = AlertDialogDefaults.INSTANCE.getTextContentColor(composerStartRestartGroup, 6);
                            i13 &= -113;
                        } else {
                            textContentColor = j5;
                        }
                        if (i14 != 0) {
                            fM2717getTonalElevationD9Ej5fM = AlertDialogDefaults.INSTANCE.m2717getTonalElevationD9Ej5fM();
                        } else {
                            fM2717getTonalElevationD9Ej5fM = f;
                        }
                        if (i17 != 0) {
                            dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                        } else {
                            dialogProperties3 = dialogProperties;
                        }
                        function15 = function8;
                        function16 = function9;
                        shape4 = shape2;
                        modifier4 = modifier2;
                        i18 = 94478519;
                        int i2111110 = i4;
                        function17 = function7;
                        function18 = function14;
                        j10 = containerColor;
                        j11 = titleContentColor;
                        long j111117 = textContentColor;
                        i19 = i2111110;
                        i20 = i13;
                        j12 = iconContentColor;
                        j13 = j111117;
                    } else {
                        if (i25 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i5 != 0) {
                            function14 = null;
                        } else {
                            function14 = function3;
                        }
                        if (i7 != 0) {
                            function7 = null;
                        }
                        if (i9 != 0) {
                            function8 = null;
                        }
                        if (i11 != 0) {
                            function9 = null;
                        }
                        if ((i3 & 128) != 0) {
                            i4 &= -29360129;
                            shape2 = AlertDialogDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                        }
                        if ((i3 & 256) != 0) {
                            containerColor = AlertDialogDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                            i4 &= -234881025;
                        } else {
                            containerColor = j;
                        }
                        if ((i3 & 512) != 0) {
                            iconContentColor = AlertDialogDefaults.INSTANCE.getIconContentColor(composerStartRestartGroup, 6);
                            i4 = (-1879048193) & i4;
                        } else {
                            iconContentColor = j2;
                        }
                        if ((i3 & 1024) != 0) {
                            titleContentColor = AlertDialogDefaults.INSTANCE.getTitleContentColor(composerStartRestartGroup, 6);
                            i13 &= -15;
                        } else {
                            titleContentColor = j3;
                        }
                        if ((i3 & 2048) != 0) {
                            textContentColor = AlertDialogDefaults.INSTANCE.getTextContentColor(composerStartRestartGroup, 6);
                            i13 &= -113;
                        } else {
                            textContentColor = j5;
                        }
                        if (i14 != 0) {
                            fM2717getTonalElevationD9Ej5fM = AlertDialogDefaults.INSTANCE.m2717getTonalElevationD9Ej5fM();
                        } else {
                            fM2717getTonalElevationD9Ej5fM = f;
                        }
                        if (i17 != 0) {
                            dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                        } else {
                            dialogProperties3 = dialogProperties;
                        }
                        function15 = function8;
                        function16 = function9;
                        shape4 = shape2;
                        modifier4 = modifier2;
                        i18 = 94478519;
                        int i2111111 = i4;
                        function17 = function7;
                        function18 = function14;
                        j10 = containerColor;
                        j11 = titleContentColor;
                        long j111118 = textContentColor;
                        i19 = i2111111;
                        i20 = i13;
                        j12 = iconContentColor;
                        j13 = j111118;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(i18, i19, i20, "androidx.compose.material3.AlertDialog (AndroidAlertDialog.android.kt:46)");
                    }
                    composer2 = composerStartRestartGroup;
                    AlertDialogKt.m2726AlertDialogImplwrnwzgE(function0, function2, modifier4, function18, function17, function15, function16, shape4, j10, j12, j11, j13, fM2717getTonalElevationD9Ej5fM, dialogProperties3, composer2, i19 & 2147483646, i20 & 8190);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier4;
                    function10 = function18;
                    function11 = function17;
                    function12 = function15;
                    function13 = function16;
                    shape3 = shape4;
                    j8 = j10;
                    j9 = j12;
                    j6 = j11;
                    j7 = j13;
                    f2 = fM2717getTonalElevationD9Ej5fM;
                    dialogProperties2 = dialogProperties3;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    function10 = function3;
                    f2 = f;
                    dialogProperties2 = dialogProperties;
                    shape3 = shape2;
                    modifier3 = modifier2;
                    j6 = j3;
                    j7 = j5;
                    function11 = function7;
                    function12 = function8;
                    function13 = function9;
                    j8 = j;
                    j9 = j2;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.AndroidAlertDialog_androidKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return AndroidAlertDialog_androidKt.AlertDialog_Oix01E0$lambda$0(function0, function2, modifier3, function10, function11, function12, function13, shape3, j8, j9, j6, j7, f2, dialogProperties2, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i13 |= 3072;
            i17 = i16;
            if ((i4 & 306783379) == 306783378) {
                z = true;
            } else {
                z = true;
            }
            if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "62@4972L5,62@5027L14,62@5093L16,62@5162L17,62@5231L16");
                if ((i & 1) != 0) {
                    if (i25 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i5 != 0) {
                        function14 = null;
                    } else {
                        function14 = function3;
                    }
                    if (i7 != 0) {
                        function7 = null;
                    }
                    if (i9 != 0) {
                        function8 = null;
                    }
                    if (i11 != 0) {
                        function9 = null;
                    }
                    if ((i3 & 128) != 0) {
                        i4 &= -29360129;
                        shape2 = AlertDialogDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                    }
                    if ((i3 & 256) != 0) {
                        containerColor = AlertDialogDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        i4 &= -234881025;
                    } else {
                        containerColor = j;
                    }
                    if ((i3 & 512) != 0) {
                        iconContentColor = AlertDialogDefaults.INSTANCE.getIconContentColor(composerStartRestartGroup, 6);
                        i4 = (-1879048193) & i4;
                    } else {
                        iconContentColor = j2;
                    }
                    if ((i3 & 1024) != 0) {
                        titleContentColor = AlertDialogDefaults.INSTANCE.getTitleContentColor(composerStartRestartGroup, 6);
                        i13 &= -15;
                    } else {
                        titleContentColor = j3;
                    }
                    if ((i3 & 2048) != 0) {
                        textContentColor = AlertDialogDefaults.INSTANCE.getTextContentColor(composerStartRestartGroup, 6);
                        i13 &= -113;
                    } else {
                        textContentColor = j5;
                    }
                    if (i14 != 0) {
                        fM2717getTonalElevationD9Ej5fM = AlertDialogDefaults.INSTANCE.m2717getTonalElevationD9Ej5fM();
                    } else {
                        fM2717getTonalElevationD9Ej5fM = f;
                    }
                    if (i17 != 0) {
                        dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                    } else {
                        dialogProperties3 = dialogProperties;
                    }
                    function15 = function8;
                    function16 = function9;
                    shape4 = shape2;
                    modifier4 = modifier2;
                    i18 = 94478519;
                    int i2111112 = i4;
                    function17 = function7;
                    function18 = function14;
                    j10 = containerColor;
                    j11 = titleContentColor;
                    long j111119 = textContentColor;
                    i19 = i2111112;
                    i20 = i13;
                    j12 = iconContentColor;
                    j13 = j111119;
                } else {
                    if (i25 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i5 != 0) {
                        function14 = null;
                    } else {
                        function14 = function3;
                    }
                    if (i7 != 0) {
                        function7 = null;
                    }
                    if (i9 != 0) {
                        function8 = null;
                    }
                    if (i11 != 0) {
                        function9 = null;
                    }
                    if ((i3 & 128) != 0) {
                        i4 &= -29360129;
                        shape2 = AlertDialogDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                    }
                    if ((i3 & 256) != 0) {
                        containerColor = AlertDialogDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        i4 &= -234881025;
                    } else {
                        containerColor = j;
                    }
                    if ((i3 & 512) != 0) {
                        iconContentColor = AlertDialogDefaults.INSTANCE.getIconContentColor(composerStartRestartGroup, 6);
                        i4 = (-1879048193) & i4;
                    } else {
                        iconContentColor = j2;
                    }
                    if ((i3 & 1024) != 0) {
                        titleContentColor = AlertDialogDefaults.INSTANCE.getTitleContentColor(composerStartRestartGroup, 6);
                        i13 &= -15;
                    } else {
                        titleContentColor = j3;
                    }
                    if ((i3 & 2048) != 0) {
                        textContentColor = AlertDialogDefaults.INSTANCE.getTextContentColor(composerStartRestartGroup, 6);
                        i13 &= -113;
                    } else {
                        textContentColor = j5;
                    }
                    if (i14 != 0) {
                        fM2717getTonalElevationD9Ej5fM = AlertDialogDefaults.INSTANCE.m2717getTonalElevationD9Ej5fM();
                    } else {
                        fM2717getTonalElevationD9Ej5fM = f;
                    }
                    if (i17 != 0) {
                        dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                    } else {
                        dialogProperties3 = dialogProperties;
                    }
                    function15 = function8;
                    function16 = function9;
                    shape4 = shape2;
                    modifier4 = modifier2;
                    i18 = 94478519;
                    int i2111113 = i4;
                    function17 = function7;
                    function18 = function14;
                    j10 = containerColor;
                    j11 = titleContentColor;
                    long j1111110 = textContentColor;
                    i19 = i2111113;
                    i20 = i13;
                    j12 = iconContentColor;
                    j13 = j1111110;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(i18, i19, i20, "androidx.compose.material3.AlertDialog (AndroidAlertDialog.android.kt:46)");
                }
                composer2 = composerStartRestartGroup;
                AlertDialogKt.m2726AlertDialogImplwrnwzgE(function0, function2, modifier4, function18, function17, function15, function16, shape4, j10, j12, j11, j13, fM2717getTonalElevationD9Ej5fM, dialogProperties3, composer2, i19 & 2147483646, i20 & 8190);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier4;
                function10 = function18;
                function11 = function17;
                function12 = function15;
                function13 = function16;
                shape3 = shape4;
                j8 = j10;
                j9 = j12;
                j6 = j11;
                j7 = j13;
                f2 = fM2717getTonalElevationD9Ej5fM;
                dialogProperties2 = dialogProperties3;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                function10 = function3;
                f2 = f;
                dialogProperties2 = dialogProperties;
                shape3 = shape2;
                modifier3 = modifier2;
                j6 = j3;
                j7 = j5;
                function11 = function7;
                function12 = function8;
                function13 = function9;
                j8 = j;
                j9 = j2;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.AndroidAlertDialog_androidKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return AndroidAlertDialog_androidKt.AlertDialog_Oix01E0$lambda$0(function0, function2, modifier3, function10, function11, function12, function13, shape3, j8, j9, j6, j7, f2, dialogProperties2, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i4 |= 3072;
        i7 = i3 & 16;
        if (i7 != 0) {
            if ((i & 24576) == 0) {
                function7 = function4;
                if (composerStartRestartGroup.changedInstance(function7)) {
                    i8 = 16384;
                } else {
                    i8 = 8192;
                }
                i4 |= i8;
            }
            i9 = i3 & 32;
            if (i9 != 0) {
                i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                function8 = function5;
            } else {
                function8 = function5;
                if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    if (composerStartRestartGroup.changedInstance(function8)) {
                        i10 = 131072;
                    } else {
                        i10 = 65536;
                    }
                    i4 |= i10;
                }
            }
            i11 = i3 & 64;
            if (i11 != 0) {
                i4 |= 1572864;
                function9 = function6;
            } else {
                function9 = function6;
                if ((i & 1572864) == 0) {
                    if (composerStartRestartGroup.changedInstance(function9)) {
                        i12 = 1048576;
                    } else {
                        i12 = 524288;
                    }
                    i4 |= i12;
                }
            }
            if ((i & 12582912) == 0) {
                if ((i3 & 128) == 0) {
                    shape2 = shape;
                    if (composerStartRestartGroup.changed(shape2)) {
                    }
                    i4 |= i26;
                } else {
                    shape2 = shape;
                }
                i4 |= i26;
            } else {
                shape2 = shape;
            }
            if ((i & 100663296) != 0) {
                if ((i3 & 256) == 0) {
                    i24 = 33554432;
                } else {
                    i24 = 33554432;
                }
                i4 |= i24;
            }
            if ((805306368 & i) != 0) {
                if ((i3 & 512) == 0) {
                    i23 = 268435456;
                } else {
                    i23 = 268435456;
                }
                i4 |= i23;
            }
            if ((i2 & 6) == 0) {
                if ((i3 & 1024) == 0) {
                    i22 = 2;
                } else {
                    i22 = 2;
                }
                i13 = i2 | i22;
            } else {
                i13 = i2;
            }
            if ((i2 & 48) == 0) {
                j5 = j4;
                if ((i3 & 2048) == 0) {
                    i21 = 16;
                } else {
                    i21 = 16;
                }
                i13 |= i21;
            } else {
                j5 = j4;
            }
            i14 = i3 & 4096;
            if (i14 != 0) {
                if ((i2 & 384) == 0) {
                    if (composerStartRestartGroup.changed(f)) {
                        i15 = 256;
                    } else {
                        i15 = 128;
                    }
                    i13 |= i15;
                }
                i16 = i3 & 8192;
                if (i16 != 0) {
                    i17 = i16;
                    if ((i2 & 3072) == 0) {
                        i13 |= composerStartRestartGroup.changed(dialogProperties) ? 2048 : 1024;
                    }
                    if ((i4 & 306783379) == 306783378) {
                        z = true;
                    } else {
                        z = true;
                    }
                    if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "62@4972L5,62@5027L14,62@5093L16,62@5162L17,62@5231L16");
                        if ((i & 1) != 0) {
                            if (i25 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i5 != 0) {
                                function14 = null;
                            } else {
                                function14 = function3;
                            }
                            if (i7 != 0) {
                                function7 = null;
                            }
                            if (i9 != 0) {
                                function8 = null;
                            }
                            if (i11 != 0) {
                                function9 = null;
                            }
                            if ((i3 & 128) != 0) {
                                i4 &= -29360129;
                                shape2 = AlertDialogDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                            }
                            if ((i3 & 256) != 0) {
                                containerColor = AlertDialogDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                                i4 &= -234881025;
                            } else {
                                containerColor = j;
                            }
                            if ((i3 & 512) != 0) {
                                iconContentColor = AlertDialogDefaults.INSTANCE.getIconContentColor(composerStartRestartGroup, 6);
                                i4 = (-1879048193) & i4;
                            } else {
                                iconContentColor = j2;
                            }
                            if ((i3 & 1024) != 0) {
                                titleContentColor = AlertDialogDefaults.INSTANCE.getTitleContentColor(composerStartRestartGroup, 6);
                                i13 &= -15;
                            } else {
                                titleContentColor = j3;
                            }
                            if ((i3 & 2048) != 0) {
                                textContentColor = AlertDialogDefaults.INSTANCE.getTextContentColor(composerStartRestartGroup, 6);
                                i13 &= -113;
                            } else {
                                textContentColor = j5;
                            }
                            if (i14 != 0) {
                                fM2717getTonalElevationD9Ej5fM = AlertDialogDefaults.INSTANCE.m2717getTonalElevationD9Ej5fM();
                            } else {
                                fM2717getTonalElevationD9Ej5fM = f;
                            }
                            if (i17 != 0) {
                                dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                            } else {
                                dialogProperties3 = dialogProperties;
                            }
                            function15 = function8;
                            function16 = function9;
                            shape4 = shape2;
                            modifier4 = modifier2;
                            i18 = 94478519;
                            int i2111114 = i4;
                            function17 = function7;
                            function18 = function14;
                            j10 = containerColor;
                            j11 = titleContentColor;
                            long j1111111 = textContentColor;
                            i19 = i2111114;
                            i20 = i13;
                            j12 = iconContentColor;
                            j13 = j1111111;
                        } else {
                            if (i25 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i5 != 0) {
                                function14 = null;
                            } else {
                                function14 = function3;
                            }
                            if (i7 != 0) {
                                function7 = null;
                            }
                            if (i9 != 0) {
                                function8 = null;
                            }
                            if (i11 != 0) {
                                function9 = null;
                            }
                            if ((i3 & 128) != 0) {
                                i4 &= -29360129;
                                shape2 = AlertDialogDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                            }
                            if ((i3 & 256) != 0) {
                                containerColor = AlertDialogDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                                i4 &= -234881025;
                            } else {
                                containerColor = j;
                            }
                            if ((i3 & 512) != 0) {
                                iconContentColor = AlertDialogDefaults.INSTANCE.getIconContentColor(composerStartRestartGroup, 6);
                                i4 = (-1879048193) & i4;
                            } else {
                                iconContentColor = j2;
                            }
                            if ((i3 & 1024) != 0) {
                                titleContentColor = AlertDialogDefaults.INSTANCE.getTitleContentColor(composerStartRestartGroup, 6);
                                i13 &= -15;
                            } else {
                                titleContentColor = j3;
                            }
                            if ((i3 & 2048) != 0) {
                                textContentColor = AlertDialogDefaults.INSTANCE.getTextContentColor(composerStartRestartGroup, 6);
                                i13 &= -113;
                            } else {
                                textContentColor = j5;
                            }
                            if (i14 != 0) {
                                fM2717getTonalElevationD9Ej5fM = AlertDialogDefaults.INSTANCE.m2717getTonalElevationD9Ej5fM();
                            } else {
                                fM2717getTonalElevationD9Ej5fM = f;
                            }
                            if (i17 != 0) {
                                dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                            } else {
                                dialogProperties3 = dialogProperties;
                            }
                            function15 = function8;
                            function16 = function9;
                            shape4 = shape2;
                            modifier4 = modifier2;
                            i18 = 94478519;
                            int i2111115 = i4;
                            function17 = function7;
                            function18 = function14;
                            j10 = containerColor;
                            j11 = titleContentColor;
                            long j1111112 = textContentColor;
                            i19 = i2111115;
                            i20 = i13;
                            j12 = iconContentColor;
                            j13 = j1111112;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(i18, i19, i20, "androidx.compose.material3.AlertDialog (AndroidAlertDialog.android.kt:46)");
                        }
                        composer2 = composerStartRestartGroup;
                        AlertDialogKt.m2726AlertDialogImplwrnwzgE(function0, function2, modifier4, function18, function17, function15, function16, shape4, j10, j12, j11, j13, fM2717getTonalElevationD9Ej5fM, dialogProperties3, composer2, i19 & 2147483646, i20 & 8190);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier4;
                        function10 = function18;
                        function11 = function17;
                        function12 = function15;
                        function13 = function16;
                        shape3 = shape4;
                        j8 = j10;
                        j9 = j12;
                        j6 = j11;
                        j7 = j13;
                        f2 = fM2717getTonalElevationD9Ej5fM;
                        dialogProperties2 = dialogProperties3;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        function10 = function3;
                        f2 = f;
                        dialogProperties2 = dialogProperties;
                        shape3 = shape2;
                        modifier3 = modifier2;
                        j6 = j3;
                        j7 = j5;
                        function11 = function7;
                        function12 = function8;
                        function13 = function9;
                        j8 = j;
                        j9 = j2;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.AndroidAlertDialog_androidKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return AndroidAlertDialog_androidKt.AlertDialog_Oix01E0$lambda$0(function0, function2, modifier3, function10, function11, function12, function13, shape3, j8, j9, j6, j7, f2, dialogProperties2, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i13 |= 3072;
                i17 = i16;
                if ((i4 & 306783379) == 306783378) {
                    z = true;
                } else {
                    z = true;
                }
                if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "62@4972L5,62@5027L14,62@5093L16,62@5162L17,62@5231L16");
                    if ((i & 1) != 0) {
                        if (i25 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i5 != 0) {
                            function14 = null;
                        } else {
                            function14 = function3;
                        }
                        if (i7 != 0) {
                            function7 = null;
                        }
                        if (i9 != 0) {
                            function8 = null;
                        }
                        if (i11 != 0) {
                            function9 = null;
                        }
                        if ((i3 & 128) != 0) {
                            i4 &= -29360129;
                            shape2 = AlertDialogDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                        }
                        if ((i3 & 256) != 0) {
                            containerColor = AlertDialogDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                            i4 &= -234881025;
                        } else {
                            containerColor = j;
                        }
                        if ((i3 & 512) != 0) {
                            iconContentColor = AlertDialogDefaults.INSTANCE.getIconContentColor(composerStartRestartGroup, 6);
                            i4 = (-1879048193) & i4;
                        } else {
                            iconContentColor = j2;
                        }
                        if ((i3 & 1024) != 0) {
                            titleContentColor = AlertDialogDefaults.INSTANCE.getTitleContentColor(composerStartRestartGroup, 6);
                            i13 &= -15;
                        } else {
                            titleContentColor = j3;
                        }
                        if ((i3 & 2048) != 0) {
                            textContentColor = AlertDialogDefaults.INSTANCE.getTextContentColor(composerStartRestartGroup, 6);
                            i13 &= -113;
                        } else {
                            textContentColor = j5;
                        }
                        if (i14 != 0) {
                            fM2717getTonalElevationD9Ej5fM = AlertDialogDefaults.INSTANCE.m2717getTonalElevationD9Ej5fM();
                        } else {
                            fM2717getTonalElevationD9Ej5fM = f;
                        }
                        if (i17 != 0) {
                            dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                        } else {
                            dialogProperties3 = dialogProperties;
                        }
                        function15 = function8;
                        function16 = function9;
                        shape4 = shape2;
                        modifier4 = modifier2;
                        i18 = 94478519;
                        int i2111116 = i4;
                        function17 = function7;
                        function18 = function14;
                        j10 = containerColor;
                        j11 = titleContentColor;
                        long j1111113 = textContentColor;
                        i19 = i2111116;
                        i20 = i13;
                        j12 = iconContentColor;
                        j13 = j1111113;
                    } else {
                        if (i25 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i5 != 0) {
                            function14 = null;
                        } else {
                            function14 = function3;
                        }
                        if (i7 != 0) {
                            function7 = null;
                        }
                        if (i9 != 0) {
                            function8 = null;
                        }
                        if (i11 != 0) {
                            function9 = null;
                        }
                        if ((i3 & 128) != 0) {
                            i4 &= -29360129;
                            shape2 = AlertDialogDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                        }
                        if ((i3 & 256) != 0) {
                            containerColor = AlertDialogDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                            i4 &= -234881025;
                        } else {
                            containerColor = j;
                        }
                        if ((i3 & 512) != 0) {
                            iconContentColor = AlertDialogDefaults.INSTANCE.getIconContentColor(composerStartRestartGroup, 6);
                            i4 = (-1879048193) & i4;
                        } else {
                            iconContentColor = j2;
                        }
                        if ((i3 & 1024) != 0) {
                            titleContentColor = AlertDialogDefaults.INSTANCE.getTitleContentColor(composerStartRestartGroup, 6);
                            i13 &= -15;
                        } else {
                            titleContentColor = j3;
                        }
                        if ((i3 & 2048) != 0) {
                            textContentColor = AlertDialogDefaults.INSTANCE.getTextContentColor(composerStartRestartGroup, 6);
                            i13 &= -113;
                        } else {
                            textContentColor = j5;
                        }
                        if (i14 != 0) {
                            fM2717getTonalElevationD9Ej5fM = AlertDialogDefaults.INSTANCE.m2717getTonalElevationD9Ej5fM();
                        } else {
                            fM2717getTonalElevationD9Ej5fM = f;
                        }
                        if (i17 != 0) {
                            dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                        } else {
                            dialogProperties3 = dialogProperties;
                        }
                        function15 = function8;
                        function16 = function9;
                        shape4 = shape2;
                        modifier4 = modifier2;
                        i18 = 94478519;
                        int i2111117 = i4;
                        function17 = function7;
                        function18 = function14;
                        j10 = containerColor;
                        j11 = titleContentColor;
                        long j1111114 = textContentColor;
                        i19 = i2111117;
                        i20 = i13;
                        j12 = iconContentColor;
                        j13 = j1111114;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(i18, i19, i20, "androidx.compose.material3.AlertDialog (AndroidAlertDialog.android.kt:46)");
                    }
                    composer2 = composerStartRestartGroup;
                    AlertDialogKt.m2726AlertDialogImplwrnwzgE(function0, function2, modifier4, function18, function17, function15, function16, shape4, j10, j12, j11, j13, fM2717getTonalElevationD9Ej5fM, dialogProperties3, composer2, i19 & 2147483646, i20 & 8190);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier4;
                    function10 = function18;
                    function11 = function17;
                    function12 = function15;
                    function13 = function16;
                    shape3 = shape4;
                    j8 = j10;
                    j9 = j12;
                    j6 = j11;
                    j7 = j13;
                    f2 = fM2717getTonalElevationD9Ej5fM;
                    dialogProperties2 = dialogProperties3;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    function10 = function3;
                    f2 = f;
                    dialogProperties2 = dialogProperties;
                    shape3 = shape2;
                    modifier3 = modifier2;
                    j6 = j3;
                    j7 = j5;
                    function11 = function7;
                    function12 = function8;
                    function13 = function9;
                    j8 = j;
                    j9 = j2;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.AndroidAlertDialog_androidKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return AndroidAlertDialog_androidKt.AlertDialog_Oix01E0$lambda$0(function0, function2, modifier3, function10, function11, function12, function13, shape3, j8, j9, j6, j7, f2, dialogProperties2, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i13 |= 384;
            i16 = i3 & 8192;
            if (i16 != 0) {
                i17 = i16;
                if ((i2 & 3072) == 0) {
                    i13 |= composerStartRestartGroup.changed(dialogProperties) ? 2048 : 1024;
                }
                if ((i4 & 306783379) == 306783378) {
                    z = true;
                } else {
                    z = true;
                }
                if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "62@4972L5,62@5027L14,62@5093L16,62@5162L17,62@5231L16");
                    if ((i & 1) != 0) {
                        if (i25 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i5 != 0) {
                            function14 = null;
                        } else {
                            function14 = function3;
                        }
                        if (i7 != 0) {
                            function7 = null;
                        }
                        if (i9 != 0) {
                            function8 = null;
                        }
                        if (i11 != 0) {
                            function9 = null;
                        }
                        if ((i3 & 128) != 0) {
                            i4 &= -29360129;
                            shape2 = AlertDialogDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                        }
                        if ((i3 & 256) != 0) {
                            containerColor = AlertDialogDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                            i4 &= -234881025;
                        } else {
                            containerColor = j;
                        }
                        if ((i3 & 512) != 0) {
                            iconContentColor = AlertDialogDefaults.INSTANCE.getIconContentColor(composerStartRestartGroup, 6);
                            i4 = (-1879048193) & i4;
                        } else {
                            iconContentColor = j2;
                        }
                        if ((i3 & 1024) != 0) {
                            titleContentColor = AlertDialogDefaults.INSTANCE.getTitleContentColor(composerStartRestartGroup, 6);
                            i13 &= -15;
                        } else {
                            titleContentColor = j3;
                        }
                        if ((i3 & 2048) != 0) {
                            textContentColor = AlertDialogDefaults.INSTANCE.getTextContentColor(composerStartRestartGroup, 6);
                            i13 &= -113;
                        } else {
                            textContentColor = j5;
                        }
                        if (i14 != 0) {
                            fM2717getTonalElevationD9Ej5fM = AlertDialogDefaults.INSTANCE.m2717getTonalElevationD9Ej5fM();
                        } else {
                            fM2717getTonalElevationD9Ej5fM = f;
                        }
                        if (i17 != 0) {
                            dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                        } else {
                            dialogProperties3 = dialogProperties;
                        }
                        function15 = function8;
                        function16 = function9;
                        shape4 = shape2;
                        modifier4 = modifier2;
                        i18 = 94478519;
                        int i2111118 = i4;
                        function17 = function7;
                        function18 = function14;
                        j10 = containerColor;
                        j11 = titleContentColor;
                        long j1111115 = textContentColor;
                        i19 = i2111118;
                        i20 = i13;
                        j12 = iconContentColor;
                        j13 = j1111115;
                    } else {
                        if (i25 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i5 != 0) {
                            function14 = null;
                        } else {
                            function14 = function3;
                        }
                        if (i7 != 0) {
                            function7 = null;
                        }
                        if (i9 != 0) {
                            function8 = null;
                        }
                        if (i11 != 0) {
                            function9 = null;
                        }
                        if ((i3 & 128) != 0) {
                            i4 &= -29360129;
                            shape2 = AlertDialogDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                        }
                        if ((i3 & 256) != 0) {
                            containerColor = AlertDialogDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                            i4 &= -234881025;
                        } else {
                            containerColor = j;
                        }
                        if ((i3 & 512) != 0) {
                            iconContentColor = AlertDialogDefaults.INSTANCE.getIconContentColor(composerStartRestartGroup, 6);
                            i4 = (-1879048193) & i4;
                        } else {
                            iconContentColor = j2;
                        }
                        if ((i3 & 1024) != 0) {
                            titleContentColor = AlertDialogDefaults.INSTANCE.getTitleContentColor(composerStartRestartGroup, 6);
                            i13 &= -15;
                        } else {
                            titleContentColor = j3;
                        }
                        if ((i3 & 2048) != 0) {
                            textContentColor = AlertDialogDefaults.INSTANCE.getTextContentColor(composerStartRestartGroup, 6);
                            i13 &= -113;
                        } else {
                            textContentColor = j5;
                        }
                        if (i14 != 0) {
                            fM2717getTonalElevationD9Ej5fM = AlertDialogDefaults.INSTANCE.m2717getTonalElevationD9Ej5fM();
                        } else {
                            fM2717getTonalElevationD9Ej5fM = f;
                        }
                        if (i17 != 0) {
                            dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                        } else {
                            dialogProperties3 = dialogProperties;
                        }
                        function15 = function8;
                        function16 = function9;
                        shape4 = shape2;
                        modifier4 = modifier2;
                        i18 = 94478519;
                        int i2111119 = i4;
                        function17 = function7;
                        function18 = function14;
                        j10 = containerColor;
                        j11 = titleContentColor;
                        long j1111116 = textContentColor;
                        i19 = i2111119;
                        i20 = i13;
                        j12 = iconContentColor;
                        j13 = j1111116;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(i18, i19, i20, "androidx.compose.material3.AlertDialog (AndroidAlertDialog.android.kt:46)");
                    }
                    composer2 = composerStartRestartGroup;
                    AlertDialogKt.m2726AlertDialogImplwrnwzgE(function0, function2, modifier4, function18, function17, function15, function16, shape4, j10, j12, j11, j13, fM2717getTonalElevationD9Ej5fM, dialogProperties3, composer2, i19 & 2147483646, i20 & 8190);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier4;
                    function10 = function18;
                    function11 = function17;
                    function12 = function15;
                    function13 = function16;
                    shape3 = shape4;
                    j8 = j10;
                    j9 = j12;
                    j6 = j11;
                    j7 = j13;
                    f2 = fM2717getTonalElevationD9Ej5fM;
                    dialogProperties2 = dialogProperties3;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    function10 = function3;
                    f2 = f;
                    dialogProperties2 = dialogProperties;
                    shape3 = shape2;
                    modifier3 = modifier2;
                    j6 = j3;
                    j7 = j5;
                    function11 = function7;
                    function12 = function8;
                    function13 = function9;
                    j8 = j;
                    j9 = j2;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.AndroidAlertDialog_androidKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return AndroidAlertDialog_androidKt.AlertDialog_Oix01E0$lambda$0(function0, function2, modifier3, function10, function11, function12, function13, shape3, j8, j9, j6, j7, f2, dialogProperties2, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i13 |= 3072;
            i17 = i16;
            if ((i4 & 306783379) == 306783378) {
                z = true;
            } else {
                z = true;
            }
            if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "62@4972L5,62@5027L14,62@5093L16,62@5162L17,62@5231L16");
                if ((i & 1) != 0) {
                    if (i25 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i5 != 0) {
                        function14 = null;
                    } else {
                        function14 = function3;
                    }
                    if (i7 != 0) {
                        function7 = null;
                    }
                    if (i9 != 0) {
                        function8 = null;
                    }
                    if (i11 != 0) {
                        function9 = null;
                    }
                    if ((i3 & 128) != 0) {
                        i4 &= -29360129;
                        shape2 = AlertDialogDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                    }
                    if ((i3 & 256) != 0) {
                        containerColor = AlertDialogDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        i4 &= -234881025;
                    } else {
                        containerColor = j;
                    }
                    if ((i3 & 512) != 0) {
                        iconContentColor = AlertDialogDefaults.INSTANCE.getIconContentColor(composerStartRestartGroup, 6);
                        i4 = (-1879048193) & i4;
                    } else {
                        iconContentColor = j2;
                    }
                    if ((i3 & 1024) != 0) {
                        titleContentColor = AlertDialogDefaults.INSTANCE.getTitleContentColor(composerStartRestartGroup, 6);
                        i13 &= -15;
                    } else {
                        titleContentColor = j3;
                    }
                    if ((i3 & 2048) != 0) {
                        textContentColor = AlertDialogDefaults.INSTANCE.getTextContentColor(composerStartRestartGroup, 6);
                        i13 &= -113;
                    } else {
                        textContentColor = j5;
                    }
                    if (i14 != 0) {
                        fM2717getTonalElevationD9Ej5fM = AlertDialogDefaults.INSTANCE.m2717getTonalElevationD9Ej5fM();
                    } else {
                        fM2717getTonalElevationD9Ej5fM = f;
                    }
                    if (i17 != 0) {
                        dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                    } else {
                        dialogProperties3 = dialogProperties;
                    }
                    function15 = function8;
                    function16 = function9;
                    shape4 = shape2;
                    modifier4 = modifier2;
                    i18 = 94478519;
                    int i21111110 = i4;
                    function17 = function7;
                    function18 = function14;
                    j10 = containerColor;
                    j11 = titleContentColor;
                    long j1111117 = textContentColor;
                    i19 = i21111110;
                    i20 = i13;
                    j12 = iconContentColor;
                    j13 = j1111117;
                } else {
                    if (i25 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i5 != 0) {
                        function14 = null;
                    } else {
                        function14 = function3;
                    }
                    if (i7 != 0) {
                        function7 = null;
                    }
                    if (i9 != 0) {
                        function8 = null;
                    }
                    if (i11 != 0) {
                        function9 = null;
                    }
                    if ((i3 & 128) != 0) {
                        i4 &= -29360129;
                        shape2 = AlertDialogDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                    }
                    if ((i3 & 256) != 0) {
                        containerColor = AlertDialogDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        i4 &= -234881025;
                    } else {
                        containerColor = j;
                    }
                    if ((i3 & 512) != 0) {
                        iconContentColor = AlertDialogDefaults.INSTANCE.getIconContentColor(composerStartRestartGroup, 6);
                        i4 = (-1879048193) & i4;
                    } else {
                        iconContentColor = j2;
                    }
                    if ((i3 & 1024) != 0) {
                        titleContentColor = AlertDialogDefaults.INSTANCE.getTitleContentColor(composerStartRestartGroup, 6);
                        i13 &= -15;
                    } else {
                        titleContentColor = j3;
                    }
                    if ((i3 & 2048) != 0) {
                        textContentColor = AlertDialogDefaults.INSTANCE.getTextContentColor(composerStartRestartGroup, 6);
                        i13 &= -113;
                    } else {
                        textContentColor = j5;
                    }
                    if (i14 != 0) {
                        fM2717getTonalElevationD9Ej5fM = AlertDialogDefaults.INSTANCE.m2717getTonalElevationD9Ej5fM();
                    } else {
                        fM2717getTonalElevationD9Ej5fM = f;
                    }
                    if (i17 != 0) {
                        dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                    } else {
                        dialogProperties3 = dialogProperties;
                    }
                    function15 = function8;
                    function16 = function9;
                    shape4 = shape2;
                    modifier4 = modifier2;
                    i18 = 94478519;
                    int i21111111 = i4;
                    function17 = function7;
                    function18 = function14;
                    j10 = containerColor;
                    j11 = titleContentColor;
                    long j1111118 = textContentColor;
                    i19 = i21111111;
                    i20 = i13;
                    j12 = iconContentColor;
                    j13 = j1111118;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(i18, i19, i20, "androidx.compose.material3.AlertDialog (AndroidAlertDialog.android.kt:46)");
                }
                composer2 = composerStartRestartGroup;
                AlertDialogKt.m2726AlertDialogImplwrnwzgE(function0, function2, modifier4, function18, function17, function15, function16, shape4, j10, j12, j11, j13, fM2717getTonalElevationD9Ej5fM, dialogProperties3, composer2, i19 & 2147483646, i20 & 8190);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier4;
                function10 = function18;
                function11 = function17;
                function12 = function15;
                function13 = function16;
                shape3 = shape4;
                j8 = j10;
                j9 = j12;
                j6 = j11;
                j7 = j13;
                f2 = fM2717getTonalElevationD9Ej5fM;
                dialogProperties2 = dialogProperties3;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                function10 = function3;
                f2 = f;
                dialogProperties2 = dialogProperties;
                shape3 = shape2;
                modifier3 = modifier2;
                j6 = j3;
                j7 = j5;
                function11 = function7;
                function12 = function8;
                function13 = function9;
                j8 = j;
                j9 = j2;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.AndroidAlertDialog_androidKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return AndroidAlertDialog_androidKt.AlertDialog_Oix01E0$lambda$0(function0, function2, modifier3, function10, function11, function12, function13, shape3, j8, j9, j6, j7, f2, dialogProperties2, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i4 |= 24576;
        function7 = function4;
        i9 = i3 & 32;
        if (i9 != 0) {
            i4 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            function8 = function5;
        } else {
            function8 = function5;
            if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                if (composerStartRestartGroup.changedInstance(function8)) {
                    i10 = 131072;
                } else {
                    i10 = 65536;
                }
                i4 |= i10;
            }
        }
        i11 = i3 & 64;
        if (i11 != 0) {
            i4 |= 1572864;
            function9 = function6;
        } else {
            function9 = function6;
            if ((i & 1572864) == 0) {
                if (composerStartRestartGroup.changedInstance(function9)) {
                    i12 = 1048576;
                } else {
                    i12 = 524288;
                }
                i4 |= i12;
            }
        }
        if ((i & 12582912) == 0) {
            if ((i3 & 128) == 0) {
                shape2 = shape;
                if (composerStartRestartGroup.changed(shape2)) {
                }
                i4 |= i26;
            } else {
                shape2 = shape;
            }
            i4 |= i26;
        } else {
            shape2 = shape;
        }
        if ((i & 100663296) != 0) {
            if ((i3 & 256) == 0) {
                i24 = 33554432;
            } else {
                i24 = 33554432;
            }
            i4 |= i24;
        }
        if ((805306368 & i) != 0) {
            if ((i3 & 512) == 0) {
                i23 = 268435456;
            } else {
                i23 = 268435456;
            }
            i4 |= i23;
        }
        if ((i2 & 6) == 0) {
            if ((i3 & 1024) == 0) {
                i22 = 2;
            } else {
                i22 = 2;
            }
            i13 = i2 | i22;
        } else {
            i13 = i2;
        }
        if ((i2 & 48) == 0) {
            j5 = j4;
            if ((i3 & 2048) == 0) {
                i21 = 16;
            } else {
                i21 = 16;
            }
            i13 |= i21;
        } else {
            j5 = j4;
        }
        i14 = i3 & 4096;
        if (i14 != 0) {
            if ((i2 & 384) == 0) {
                if (composerStartRestartGroup.changed(f)) {
                    i15 = 256;
                } else {
                    i15 = 128;
                }
                i13 |= i15;
            }
            i16 = i3 & 8192;
            if (i16 != 0) {
                i17 = i16;
                if ((i2 & 3072) == 0) {
                    i13 |= composerStartRestartGroup.changed(dialogProperties) ? 2048 : 1024;
                }
                if ((i4 & 306783379) == 306783378) {
                    z = true;
                } else {
                    z = true;
                }
                if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "62@4972L5,62@5027L14,62@5093L16,62@5162L17,62@5231L16");
                    if ((i & 1) != 0) {
                        if (i25 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i5 != 0) {
                            function14 = null;
                        } else {
                            function14 = function3;
                        }
                        if (i7 != 0) {
                            function7 = null;
                        }
                        if (i9 != 0) {
                            function8 = null;
                        }
                        if (i11 != 0) {
                            function9 = null;
                        }
                        if ((i3 & 128) != 0) {
                            i4 &= -29360129;
                            shape2 = AlertDialogDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                        }
                        if ((i3 & 256) != 0) {
                            containerColor = AlertDialogDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                            i4 &= -234881025;
                        } else {
                            containerColor = j;
                        }
                        if ((i3 & 512) != 0) {
                            iconContentColor = AlertDialogDefaults.INSTANCE.getIconContentColor(composerStartRestartGroup, 6);
                            i4 = (-1879048193) & i4;
                        } else {
                            iconContentColor = j2;
                        }
                        if ((i3 & 1024) != 0) {
                            titleContentColor = AlertDialogDefaults.INSTANCE.getTitleContentColor(composerStartRestartGroup, 6);
                            i13 &= -15;
                        } else {
                            titleContentColor = j3;
                        }
                        if ((i3 & 2048) != 0) {
                            textContentColor = AlertDialogDefaults.INSTANCE.getTextContentColor(composerStartRestartGroup, 6);
                            i13 &= -113;
                        } else {
                            textContentColor = j5;
                        }
                        if (i14 != 0) {
                            fM2717getTonalElevationD9Ej5fM = AlertDialogDefaults.INSTANCE.m2717getTonalElevationD9Ej5fM();
                        } else {
                            fM2717getTonalElevationD9Ej5fM = f;
                        }
                        if (i17 != 0) {
                            dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                        } else {
                            dialogProperties3 = dialogProperties;
                        }
                        function15 = function8;
                        function16 = function9;
                        shape4 = shape2;
                        modifier4 = modifier2;
                        i18 = 94478519;
                        int i21111112 = i4;
                        function17 = function7;
                        function18 = function14;
                        j10 = containerColor;
                        j11 = titleContentColor;
                        long j1111119 = textContentColor;
                        i19 = i21111112;
                        i20 = i13;
                        j12 = iconContentColor;
                        j13 = j1111119;
                    } else {
                        if (i25 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i5 != 0) {
                            function14 = null;
                        } else {
                            function14 = function3;
                        }
                        if (i7 != 0) {
                            function7 = null;
                        }
                        if (i9 != 0) {
                            function8 = null;
                        }
                        if (i11 != 0) {
                            function9 = null;
                        }
                        if ((i3 & 128) != 0) {
                            i4 &= -29360129;
                            shape2 = AlertDialogDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                        }
                        if ((i3 & 256) != 0) {
                            containerColor = AlertDialogDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                            i4 &= -234881025;
                        } else {
                            containerColor = j;
                        }
                        if ((i3 & 512) != 0) {
                            iconContentColor = AlertDialogDefaults.INSTANCE.getIconContentColor(composerStartRestartGroup, 6);
                            i4 = (-1879048193) & i4;
                        } else {
                            iconContentColor = j2;
                        }
                        if ((i3 & 1024) != 0) {
                            titleContentColor = AlertDialogDefaults.INSTANCE.getTitleContentColor(composerStartRestartGroup, 6);
                            i13 &= -15;
                        } else {
                            titleContentColor = j3;
                        }
                        if ((i3 & 2048) != 0) {
                            textContentColor = AlertDialogDefaults.INSTANCE.getTextContentColor(composerStartRestartGroup, 6);
                            i13 &= -113;
                        } else {
                            textContentColor = j5;
                        }
                        if (i14 != 0) {
                            fM2717getTonalElevationD9Ej5fM = AlertDialogDefaults.INSTANCE.m2717getTonalElevationD9Ej5fM();
                        } else {
                            fM2717getTonalElevationD9Ej5fM = f;
                        }
                        if (i17 != 0) {
                            dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                        } else {
                            dialogProperties3 = dialogProperties;
                        }
                        function15 = function8;
                        function16 = function9;
                        shape4 = shape2;
                        modifier4 = modifier2;
                        i18 = 94478519;
                        int i21111113 = i4;
                        function17 = function7;
                        function18 = function14;
                        j10 = containerColor;
                        j11 = titleContentColor;
                        long j11111110 = textContentColor;
                        i19 = i21111113;
                        i20 = i13;
                        j12 = iconContentColor;
                        j13 = j11111110;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(i18, i19, i20, "androidx.compose.material3.AlertDialog (AndroidAlertDialog.android.kt:46)");
                    }
                    composer2 = composerStartRestartGroup;
                    AlertDialogKt.m2726AlertDialogImplwrnwzgE(function0, function2, modifier4, function18, function17, function15, function16, shape4, j10, j12, j11, j13, fM2717getTonalElevationD9Ej5fM, dialogProperties3, composer2, i19 & 2147483646, i20 & 8190);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier4;
                    function10 = function18;
                    function11 = function17;
                    function12 = function15;
                    function13 = function16;
                    shape3 = shape4;
                    j8 = j10;
                    j9 = j12;
                    j6 = j11;
                    j7 = j13;
                    f2 = fM2717getTonalElevationD9Ej5fM;
                    dialogProperties2 = dialogProperties3;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    function10 = function3;
                    f2 = f;
                    dialogProperties2 = dialogProperties;
                    shape3 = shape2;
                    modifier3 = modifier2;
                    j6 = j3;
                    j7 = j5;
                    function11 = function7;
                    function12 = function8;
                    function13 = function9;
                    j8 = j;
                    j9 = j2;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.AndroidAlertDialog_androidKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return AndroidAlertDialog_androidKt.AlertDialog_Oix01E0$lambda$0(function0, function2, modifier3, function10, function11, function12, function13, shape3, j8, j9, j6, j7, f2, dialogProperties2, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i13 |= 3072;
            i17 = i16;
            if ((i4 & 306783379) == 306783378) {
                z = true;
            } else {
                z = true;
            }
            if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "62@4972L5,62@5027L14,62@5093L16,62@5162L17,62@5231L16");
                if ((i & 1) != 0) {
                    if (i25 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i5 != 0) {
                        function14 = null;
                    } else {
                        function14 = function3;
                    }
                    if (i7 != 0) {
                        function7 = null;
                    }
                    if (i9 != 0) {
                        function8 = null;
                    }
                    if (i11 != 0) {
                        function9 = null;
                    }
                    if ((i3 & 128) != 0) {
                        i4 &= -29360129;
                        shape2 = AlertDialogDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                    }
                    if ((i3 & 256) != 0) {
                        containerColor = AlertDialogDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        i4 &= -234881025;
                    } else {
                        containerColor = j;
                    }
                    if ((i3 & 512) != 0) {
                        iconContentColor = AlertDialogDefaults.INSTANCE.getIconContentColor(composerStartRestartGroup, 6);
                        i4 = (-1879048193) & i4;
                    } else {
                        iconContentColor = j2;
                    }
                    if ((i3 & 1024) != 0) {
                        titleContentColor = AlertDialogDefaults.INSTANCE.getTitleContentColor(composerStartRestartGroup, 6);
                        i13 &= -15;
                    } else {
                        titleContentColor = j3;
                    }
                    if ((i3 & 2048) != 0) {
                        textContentColor = AlertDialogDefaults.INSTANCE.getTextContentColor(composerStartRestartGroup, 6);
                        i13 &= -113;
                    } else {
                        textContentColor = j5;
                    }
                    if (i14 != 0) {
                        fM2717getTonalElevationD9Ej5fM = AlertDialogDefaults.INSTANCE.m2717getTonalElevationD9Ej5fM();
                    } else {
                        fM2717getTonalElevationD9Ej5fM = f;
                    }
                    if (i17 != 0) {
                        dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                    } else {
                        dialogProperties3 = dialogProperties;
                    }
                    function15 = function8;
                    function16 = function9;
                    shape4 = shape2;
                    modifier4 = modifier2;
                    i18 = 94478519;
                    int i21111114 = i4;
                    function17 = function7;
                    function18 = function14;
                    j10 = containerColor;
                    j11 = titleContentColor;
                    long j11111111 = textContentColor;
                    i19 = i21111114;
                    i20 = i13;
                    j12 = iconContentColor;
                    j13 = j11111111;
                } else {
                    if (i25 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i5 != 0) {
                        function14 = null;
                    } else {
                        function14 = function3;
                    }
                    if (i7 != 0) {
                        function7 = null;
                    }
                    if (i9 != 0) {
                        function8 = null;
                    }
                    if (i11 != 0) {
                        function9 = null;
                    }
                    if ((i3 & 128) != 0) {
                        i4 &= -29360129;
                        shape2 = AlertDialogDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                    }
                    if ((i3 & 256) != 0) {
                        containerColor = AlertDialogDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        i4 &= -234881025;
                    } else {
                        containerColor = j;
                    }
                    if ((i3 & 512) != 0) {
                        iconContentColor = AlertDialogDefaults.INSTANCE.getIconContentColor(composerStartRestartGroup, 6);
                        i4 = (-1879048193) & i4;
                    } else {
                        iconContentColor = j2;
                    }
                    if ((i3 & 1024) != 0) {
                        titleContentColor = AlertDialogDefaults.INSTANCE.getTitleContentColor(composerStartRestartGroup, 6);
                        i13 &= -15;
                    } else {
                        titleContentColor = j3;
                    }
                    if ((i3 & 2048) != 0) {
                        textContentColor = AlertDialogDefaults.INSTANCE.getTextContentColor(composerStartRestartGroup, 6);
                        i13 &= -113;
                    } else {
                        textContentColor = j5;
                    }
                    if (i14 != 0) {
                        fM2717getTonalElevationD9Ej5fM = AlertDialogDefaults.INSTANCE.m2717getTonalElevationD9Ej5fM();
                    } else {
                        fM2717getTonalElevationD9Ej5fM = f;
                    }
                    if (i17 != 0) {
                        dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                    } else {
                        dialogProperties3 = dialogProperties;
                    }
                    function15 = function8;
                    function16 = function9;
                    shape4 = shape2;
                    modifier4 = modifier2;
                    i18 = 94478519;
                    int i21111115 = i4;
                    function17 = function7;
                    function18 = function14;
                    j10 = containerColor;
                    j11 = titleContentColor;
                    long j11111112 = textContentColor;
                    i19 = i21111115;
                    i20 = i13;
                    j12 = iconContentColor;
                    j13 = j11111112;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(i18, i19, i20, "androidx.compose.material3.AlertDialog (AndroidAlertDialog.android.kt:46)");
                }
                composer2 = composerStartRestartGroup;
                AlertDialogKt.m2726AlertDialogImplwrnwzgE(function0, function2, modifier4, function18, function17, function15, function16, shape4, j10, j12, j11, j13, fM2717getTonalElevationD9Ej5fM, dialogProperties3, composer2, i19 & 2147483646, i20 & 8190);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier4;
                function10 = function18;
                function11 = function17;
                function12 = function15;
                function13 = function16;
                shape3 = shape4;
                j8 = j10;
                j9 = j12;
                j6 = j11;
                j7 = j13;
                f2 = fM2717getTonalElevationD9Ej5fM;
                dialogProperties2 = dialogProperties3;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                function10 = function3;
                f2 = f;
                dialogProperties2 = dialogProperties;
                shape3 = shape2;
                modifier3 = modifier2;
                j6 = j3;
                j7 = j5;
                function11 = function7;
                function12 = function8;
                function13 = function9;
                j8 = j;
                j9 = j2;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.AndroidAlertDialog_androidKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return AndroidAlertDialog_androidKt.AlertDialog_Oix01E0$lambda$0(function0, function2, modifier3, function10, function11, function12, function13, shape3, j8, j9, j6, j7, f2, dialogProperties2, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i13 |= 384;
        i16 = i3 & 8192;
        if (i16 != 0) {
            i17 = i16;
            if ((i2 & 3072) == 0) {
                i13 |= composerStartRestartGroup.changed(dialogProperties) ? 2048 : 1024;
            }
            if ((i4 & 306783379) == 306783378) {
                z = true;
            } else {
                z = true;
            }
            if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "62@4972L5,62@5027L14,62@5093L16,62@5162L17,62@5231L16");
                if ((i & 1) != 0) {
                    if (i25 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i5 != 0) {
                        function14 = null;
                    } else {
                        function14 = function3;
                    }
                    if (i7 != 0) {
                        function7 = null;
                    }
                    if (i9 != 0) {
                        function8 = null;
                    }
                    if (i11 != 0) {
                        function9 = null;
                    }
                    if ((i3 & 128) != 0) {
                        i4 &= -29360129;
                        shape2 = AlertDialogDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                    }
                    if ((i3 & 256) != 0) {
                        containerColor = AlertDialogDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        i4 &= -234881025;
                    } else {
                        containerColor = j;
                    }
                    if ((i3 & 512) != 0) {
                        iconContentColor = AlertDialogDefaults.INSTANCE.getIconContentColor(composerStartRestartGroup, 6);
                        i4 = (-1879048193) & i4;
                    } else {
                        iconContentColor = j2;
                    }
                    if ((i3 & 1024) != 0) {
                        titleContentColor = AlertDialogDefaults.INSTANCE.getTitleContentColor(composerStartRestartGroup, 6);
                        i13 &= -15;
                    } else {
                        titleContentColor = j3;
                    }
                    if ((i3 & 2048) != 0) {
                        textContentColor = AlertDialogDefaults.INSTANCE.getTextContentColor(composerStartRestartGroup, 6);
                        i13 &= -113;
                    } else {
                        textContentColor = j5;
                    }
                    if (i14 != 0) {
                        fM2717getTonalElevationD9Ej5fM = AlertDialogDefaults.INSTANCE.m2717getTonalElevationD9Ej5fM();
                    } else {
                        fM2717getTonalElevationD9Ej5fM = f;
                    }
                    if (i17 != 0) {
                        dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                    } else {
                        dialogProperties3 = dialogProperties;
                    }
                    function15 = function8;
                    function16 = function9;
                    shape4 = shape2;
                    modifier4 = modifier2;
                    i18 = 94478519;
                    int i21111116 = i4;
                    function17 = function7;
                    function18 = function14;
                    j10 = containerColor;
                    j11 = titleContentColor;
                    long j11111113 = textContentColor;
                    i19 = i21111116;
                    i20 = i13;
                    j12 = iconContentColor;
                    j13 = j11111113;
                } else {
                    if (i25 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i5 != 0) {
                        function14 = null;
                    } else {
                        function14 = function3;
                    }
                    if (i7 != 0) {
                        function7 = null;
                    }
                    if (i9 != 0) {
                        function8 = null;
                    }
                    if (i11 != 0) {
                        function9 = null;
                    }
                    if ((i3 & 128) != 0) {
                        i4 &= -29360129;
                        shape2 = AlertDialogDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                    }
                    if ((i3 & 256) != 0) {
                        containerColor = AlertDialogDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                        i4 &= -234881025;
                    } else {
                        containerColor = j;
                    }
                    if ((i3 & 512) != 0) {
                        iconContentColor = AlertDialogDefaults.INSTANCE.getIconContentColor(composerStartRestartGroup, 6);
                        i4 = (-1879048193) & i4;
                    } else {
                        iconContentColor = j2;
                    }
                    if ((i3 & 1024) != 0) {
                        titleContentColor = AlertDialogDefaults.INSTANCE.getTitleContentColor(composerStartRestartGroup, 6);
                        i13 &= -15;
                    } else {
                        titleContentColor = j3;
                    }
                    if ((i3 & 2048) != 0) {
                        textContentColor = AlertDialogDefaults.INSTANCE.getTextContentColor(composerStartRestartGroup, 6);
                        i13 &= -113;
                    } else {
                        textContentColor = j5;
                    }
                    if (i14 != 0) {
                        fM2717getTonalElevationD9Ej5fM = AlertDialogDefaults.INSTANCE.m2717getTonalElevationD9Ej5fM();
                    } else {
                        fM2717getTonalElevationD9Ej5fM = f;
                    }
                    if (i17 != 0) {
                        dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                    } else {
                        dialogProperties3 = dialogProperties;
                    }
                    function15 = function8;
                    function16 = function9;
                    shape4 = shape2;
                    modifier4 = modifier2;
                    i18 = 94478519;
                    int i21111117 = i4;
                    function17 = function7;
                    function18 = function14;
                    j10 = containerColor;
                    j11 = titleContentColor;
                    long j11111114 = textContentColor;
                    i19 = i21111117;
                    i20 = i13;
                    j12 = iconContentColor;
                    j13 = j11111114;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(i18, i19, i20, "androidx.compose.material3.AlertDialog (AndroidAlertDialog.android.kt:46)");
                }
                composer2 = composerStartRestartGroup;
                AlertDialogKt.m2726AlertDialogImplwrnwzgE(function0, function2, modifier4, function18, function17, function15, function16, shape4, j10, j12, j11, j13, fM2717getTonalElevationD9Ej5fM, dialogProperties3, composer2, i19 & 2147483646, i20 & 8190);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier4;
                function10 = function18;
                function11 = function17;
                function12 = function15;
                function13 = function16;
                shape3 = shape4;
                j8 = j10;
                j9 = j12;
                j6 = j11;
                j7 = j13;
                f2 = fM2717getTonalElevationD9Ej5fM;
                dialogProperties2 = dialogProperties3;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                function10 = function3;
                f2 = f;
                dialogProperties2 = dialogProperties;
                shape3 = shape2;
                modifier3 = modifier2;
                j6 = j3;
                j7 = j5;
                function11 = function7;
                function12 = function8;
                function13 = function9;
                j8 = j;
                j9 = j2;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.AndroidAlertDialog_androidKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return AndroidAlertDialog_androidKt.AlertDialog_Oix01E0$lambda$0(function0, function2, modifier3, function10, function11, function12, function13, shape3, j8, j9, j6, j7, f2, dialogProperties2, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i13 |= 3072;
        i17 = i16;
        if ((i4 & 306783379) == 306783378) {
            z = true;
        } else {
            z = true;
        }
        if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "62@4972L5,62@5027L14,62@5093L16,62@5162L17,62@5231L16");
            if ((i & 1) != 0) {
                if (i25 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i5 != 0) {
                    function14 = null;
                } else {
                    function14 = function3;
                }
                if (i7 != 0) {
                    function7 = null;
                }
                if (i9 != 0) {
                    function8 = null;
                }
                if (i11 != 0) {
                    function9 = null;
                }
                if ((i3 & 128) != 0) {
                    i4 &= -29360129;
                    shape2 = AlertDialogDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                }
                if ((i3 & 256) != 0) {
                    containerColor = AlertDialogDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                    i4 &= -234881025;
                } else {
                    containerColor = j;
                }
                if ((i3 & 512) != 0) {
                    iconContentColor = AlertDialogDefaults.INSTANCE.getIconContentColor(composerStartRestartGroup, 6);
                    i4 = (-1879048193) & i4;
                } else {
                    iconContentColor = j2;
                }
                if ((i3 & 1024) != 0) {
                    titleContentColor = AlertDialogDefaults.INSTANCE.getTitleContentColor(composerStartRestartGroup, 6);
                    i13 &= -15;
                } else {
                    titleContentColor = j3;
                }
                if ((i3 & 2048) != 0) {
                    textContentColor = AlertDialogDefaults.INSTANCE.getTextContentColor(composerStartRestartGroup, 6);
                    i13 &= -113;
                } else {
                    textContentColor = j5;
                }
                if (i14 != 0) {
                    fM2717getTonalElevationD9Ej5fM = AlertDialogDefaults.INSTANCE.m2717getTonalElevationD9Ej5fM();
                } else {
                    fM2717getTonalElevationD9Ej5fM = f;
                }
                if (i17 != 0) {
                    dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                } else {
                    dialogProperties3 = dialogProperties;
                }
                function15 = function8;
                function16 = function9;
                shape4 = shape2;
                modifier4 = modifier2;
                i18 = 94478519;
                int i21111118 = i4;
                function17 = function7;
                function18 = function14;
                j10 = containerColor;
                j11 = titleContentColor;
                long j11111115 = textContentColor;
                i19 = i21111118;
                i20 = i13;
                j12 = iconContentColor;
                j13 = j11111115;
            } else {
                if (i25 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i5 != 0) {
                    function14 = null;
                } else {
                    function14 = function3;
                }
                if (i7 != 0) {
                    function7 = null;
                }
                if (i9 != 0) {
                    function8 = null;
                }
                if (i11 != 0) {
                    function9 = null;
                }
                if ((i3 & 128) != 0) {
                    i4 &= -29360129;
                    shape2 = AlertDialogDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                }
                if ((i3 & 256) != 0) {
                    containerColor = AlertDialogDefaults.INSTANCE.getContainerColor(composerStartRestartGroup, 6);
                    i4 &= -234881025;
                } else {
                    containerColor = j;
                }
                if ((i3 & 512) != 0) {
                    iconContentColor = AlertDialogDefaults.INSTANCE.getIconContentColor(composerStartRestartGroup, 6);
                    i4 = (-1879048193) & i4;
                } else {
                    iconContentColor = j2;
                }
                if ((i3 & 1024) != 0) {
                    titleContentColor = AlertDialogDefaults.INSTANCE.getTitleContentColor(composerStartRestartGroup, 6);
                    i13 &= -15;
                } else {
                    titleContentColor = j3;
                }
                if ((i3 & 2048) != 0) {
                    textContentColor = AlertDialogDefaults.INSTANCE.getTextContentColor(composerStartRestartGroup, 6);
                    i13 &= -113;
                } else {
                    textContentColor = j5;
                }
                if (i14 != 0) {
                    fM2717getTonalElevationD9Ej5fM = AlertDialogDefaults.INSTANCE.m2717getTonalElevationD9Ej5fM();
                } else {
                    fM2717getTonalElevationD9Ej5fM = f;
                }
                if (i17 != 0) {
                    dialogProperties3 = new DialogProperties(false, false, false, 7, (DefaultConstructorMarker) null);
                } else {
                    dialogProperties3 = dialogProperties;
                }
                function15 = function8;
                function16 = function9;
                shape4 = shape2;
                modifier4 = modifier2;
                i18 = 94478519;
                int i21111119 = i4;
                function17 = function7;
                function18 = function14;
                j10 = containerColor;
                j11 = titleContentColor;
                long j11111116 = textContentColor;
                i19 = i21111119;
                i20 = i13;
                j12 = iconContentColor;
                j13 = j11111116;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(i18, i19, i20, "androidx.compose.material3.AlertDialog (AndroidAlertDialog.android.kt:46)");
            }
            composer2 = composerStartRestartGroup;
            AlertDialogKt.m2726AlertDialogImplwrnwzgE(function0, function2, modifier4, function18, function17, function15, function16, shape4, j10, j12, j11, j13, fM2717getTonalElevationD9Ej5fM, dialogProperties3, composer2, i19 & 2147483646, i20 & 8190);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier4;
            function10 = function18;
            function11 = function17;
            function12 = function15;
            function13 = function16;
            shape3 = shape4;
            j8 = j10;
            j9 = j12;
            j6 = j11;
            j7 = j13;
            f2 = fM2717getTonalElevationD9Ej5fM;
            dialogProperties2 = dialogProperties3;
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            function10 = function3;
            f2 = f;
            dialogProperties2 = dialogProperties;
            shape3 = shape2;
            modifier3 = modifier2;
            j6 = j3;
            j7 = j5;
            function11 = function7;
            function12 = function8;
            function13 = function9;
            j8 = j;
            j9 = j2;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.AndroidAlertDialog_androidKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AndroidAlertDialog_androidKt.AlertDialog_Oix01E0$lambda$0(function0, function2, modifier3, function10, function11, function12, function13, shape3, j8, j9, j6, j7, f2, dialogProperties2, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}
